package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.live.a.a.a;
import com.tencent.mm.live.a.a.b;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.l.j;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.b.u.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;
import org.xwalk.core.XWalkEnvironment;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "originBackground", "Landroid/graphics/drawable/Drawable;", "roomLivePageFloatBallHelper", "Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "initSwipeBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "Companion", "plugin-logic_release"})
public class LiveUIA
  extends MMActivity
{
  public static final a kIr;
  private com.tencent.mm.live.a.a kIo;
  private com.tencent.mm.live.b.t kIp;
  private Drawable kIq;
  
  static
  {
    AppMethodBeat.i(191533);
    kIr = new a((byte)0);
    AppMethodBeat.o(191533);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(191506);
    Object localObject = u.kwz;
    if (u.aOF().kwA)
    {
      localObject = getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_is_live_finished", false) == true))
      {
        AppMethodBeat.o(191506);
        return 1;
      }
      AppMethodBeat.o(191506);
      return 14;
    }
    AppMethodBeat.o(191506);
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.live_root_ui_layout;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(191451);
    super.initSwipeBack();
    g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new LiveUIA.b(this, null), 2);
    AppMethodBeat.o(191451);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(191500);
    Log.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.kIo;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, "onActivityResult " + ((com.tencent.mm.live.a.a)localObject).kiC);
      localObject = ((com.tencent.mm.live.a.a)localObject).kiC;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(191500);
        return;
      }
      AppMethodBeat.o(191500);
      return;
    }
    AppMethodBeat.o(191500);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(191519);
    Object localObject = this.kIo;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.a.a)localObject).kiC;
      if (localObject != null) {}
      for (boolean bool = ((BaseLivePluginLayout)localObject).onBackPress();; bool = false)
      {
        if (!bool)
        {
          Log.i("MicroMsg.LiveUI", "onBackPressed (" + hashCode() + ')');
          super.onBackPressed();
        }
        AppMethodBeat.o(191519);
        return;
      }
    }
    AppMethodBeat.o(191519);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191467);
    Log.i("MicroMsg.LiveUI", "onCreate (" + hashCode() + ')');
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().clearFlags(67108864);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.j(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(b.e.live_ui_root);
    p.j(paramBundle, "findViewById(R.id.live_ui_root)");
    Object localObject1 = (FrameLayout)paramBundle;
    paramBundle = (LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    boolean bool = getIntent().getBooleanExtra("key_is_live_finished", false);
    Object localObject2 = (Context)this;
    if (localObject1 == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(191467);
      throw paramBundle;
    }
    this.kIo = new com.tencent.mm.live.a.a((Context)localObject2, (ViewGroup)localObject1, paramBundle, bool);
    localObject2 = this.kIo;
    if (localObject2 != null)
    {
      localObject1 = ((com.tencent.mm.live.a.a)localObject2).context.getSystemService("phone");
      if (localObject1 == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(191467);
        throw paramBundle;
      }
      localObject1 = (TelephonyManager)localObject1;
      localObject2 = ((com.tencent.mm.live.a.a)localObject2).kiE;
      localObject2 = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    localObject1 = u.kwz;
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getFromScene();
      u.tR(i);
      if (paramBundle == null) {
        break label558;
      }
      paramBundle = Integer.valueOf(paramBundle.aJf());
      label465:
      i = LiveConfig.khW;
      if (paramBundle != null) {
        break label563;
      }
      label473:
      i = LiveConfig.khX;
      if (paramBundle != null) {
        break label607;
      }
    }
    for (;;)
    {
      this.kIp = new com.tencent.mm.live.b.t((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
      paramBundle = this.kIp;
      if (paramBundle != null) {
        paramBundle.I(21, b.cwx());
      }
      paramBundle = getContext();
      if (paramBundle != null) {
        break label651;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(191467);
      throw paramBundle;
      i = LiveConfig.kib;
      break;
      label558:
      paramBundle = null;
      break label465;
      label563:
      if (paramBundle.intValue() != i) {
        break label473;
      }
      paramBundle = u.kwz;
      u.x((Context)this, true);
      paramBundle = this.kIo;
      if (paramBundle != null)
      {
        localObject1 = l.j.kuS;
        paramBundle.sR(l.j.aNT());
        continue;
        label607:
        if (paramBundle.intValue() == i)
        {
          paramBundle = u.kwz;
          u.x((Context)this, false);
          paramBundle = this.kIo;
          if (paramBundle != null)
          {
            localObject1 = l.j.kuS;
            paramBundle.sR(l.j.aNU());
          }
        }
      }
    }
    label651:
    paramBundle = ((Activity)paramBundle).getWindow();
    p.j(paramBundle, "(context as Activity).window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "(context as Activity).window.decorView");
    this.kIq = paramBundle.getBackground();
    AppMethodBeat.o(191467);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191516);
    Log.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
    super.onDestroy();
    Object localObject = this.kIo;
    if (localObject != null) {
      ((com.tencent.mm.live.a.a)localObject).onDestroy();
    }
    localObject = this.kIp;
    if (localObject != null)
    {
      ((com.tencent.mm.live.b.t)localObject).onDestroy();
      AppMethodBeat.o(191516);
      return;
    }
    AppMethodBeat.o(191516);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(191530);
    Log.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    getSwipeBackLayout().emh();
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("route_to_maximize", false) != true) {
        break label110;
      }
      paramIntent = this.kIo;
      if (paramIntent == null) {
        break label110;
      }
      paramIntent = paramIntent.kiC;
      if (paramIntent != null)
      {
        b.b.a(paramIntent, b.c.kzj);
        AppMethodBeat.o(191530);
      }
    }
    else
    {
      AppMethodBeat.o(191530);
      return;
    }
    AppMethodBeat.o(191530);
    return;
    label110:
    AppMethodBeat.o(191530);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(191494);
    Log.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
    super.onPause();
    Object localObject = this.kIo;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, "onPause " + ((com.tencent.mm.live.a.a)localObject).kiC);
      localObject = ((com.tencent.mm.live.a.a)localObject).kiC;
      if (localObject != null) {
        ((BaseLivePluginLayout)localObject).pause();
      }
    }
    localObject = this.kIp;
    if (localObject != null) {
      ((com.tencent.mm.live.b.t)localObject).aOj();
    }
    com.tencent.mm.plugin.ball.f.f.cwA();
    AppMethodBeat.o(191494);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(191478);
    Log.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
    super.onResume();
    Object localObject = this.kIo;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, "onResume " + ((com.tencent.mm.live.a.a)localObject).kiC);
      BaseLivePluginLayout localBaseLivePluginLayout = ((com.tencent.mm.live.a.a)localObject).kiC;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.resume();
      }
      localBaseLivePluginLayout = ((com.tencent.mm.live.a.a)localObject).kiC;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.post((Runnable)new a.b((com.tencent.mm.live.a.a)localObject));
      }
    }
    localObject = this.kIp;
    if (localObject != null) {
      ((com.tencent.mm.live.b.t)localObject).aOf();
    }
    com.tencent.mm.plugin.ball.f.f.cvI();
    AppMethodBeat.o(191478);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(191487);
    Log.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
    super.onStart();
    Object localObject1 = this.kIo;
    if (localObject1 != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject1).TAG, "onStart " + ((com.tencent.mm.live.a.a)localObject1).kiC);
      for (;;)
      {
        try
        {
          i = Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation");
          if (i != 1) {
            continue;
          }
          i = 1;
        }
        catch (Settings.SettingNotFoundException localSettingNotFoundException)
        {
          Object localObject2;
          Log.printErrStackTrace(((com.tencent.mm.live.a.a)localObject1).TAG, (Throwable)localSettingNotFoundException, "", new Object[0]);
          int i = 0;
          continue;
          bool = false;
          continue;
          AppMethodBeat.o(191487);
          return;
        }
        localObject2 = ((com.tencent.mm.live.a.a)localObject1).kiC;
        if (localObject2 != null)
        {
          if ((i == 0) || (!((com.tencent.mm.live.a.a)localObject1).sp.getBoolean("settings_landscape_mode", false))) {
            continue;
          }
          ((BaseLivePluginLayout)localObject2).onRotationSwitchChange(bool);
        }
        localObject2 = ((com.tencent.mm.live.a.a)localObject1).kiz;
        ((a.a)localObject2).kiH.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, (ContentObserver)localObject2);
        localObject1 = ((com.tencent.mm.live.a.a)localObject1).kiC;
        if (localObject1 == null) {
          continue;
        }
        ((BaseLivePluginLayout)localObject1).start();
        AppMethodBeat.o(191487);
        return;
        i = 0;
      }
    }
    AppMethodBeat.o(191487);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(191513);
    Log.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
    super.onStop();
    Object localObject1 = this.kIo;
    if (localObject1 != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject1).TAG, "onStop " + ((com.tencent.mm.live.a.a)localObject1).kiC);
      Object localObject2 = ((com.tencent.mm.live.a.a)localObject1).kiz;
      ((a.a)localObject2).kiH.unregisterContentObserver((ContentObserver)localObject2);
      localObject2 = ((com.tencent.mm.live.a.a)localObject1).jij;
      if (localObject2 != null) {
        ((i)localObject2).close();
      }
      localObject1 = ((com.tencent.mm.live.a.a)localObject1).kiC;
      if (localObject1 != null) {
        ((BaseLivePluginLayout)localObject1).stop();
      }
    }
    getSwipeBackLayout().emh();
    AppMethodBeat.o(191513);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(191525);
    Log.i("MicroMsg.LiveUI", "onSwipeBack (" + hashCode() + ')');
    Object localObject = this.kIo;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.a.a)localObject).kiC;
      if (localObject != null) {}
      for (boolean bool = ((BaseLivePluginLayout)localObject).onSwipeBack();; bool = false)
      {
        if (!bool)
        {
          Log.i("MicroMsg.LiveUI", "super onBackPressed (" + hashCode() + ')');
          super.onSwipeBack();
        }
        AppMethodBeat.o(191525);
        return;
      }
    }
    AppMethodBeat.o(191525);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUIA$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA
 * JD-Core Version:    0.7.0.1
 */