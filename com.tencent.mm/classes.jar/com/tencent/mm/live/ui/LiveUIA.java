package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.app.ActionBar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.live.a.a.a;
import com.tencent.mm.live.a.a.b;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o.k;
import com.tencent.mm.live.b.w;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.b.x.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.xwalk.core.XWalkEnvironment;

@com.tencent.mm.ui.base.a(35)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "roomLivePageFloatBallHelper", "Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-logic_release"})
public class LiveUIA
  extends MMActivity
{
  public static final a hTT;
  private com.tencent.mm.live.a.a hTR;
  private w hTS;
  
  static
  {
    AppMethodBeat.i(208376);
    hTT = new a((byte)0);
    AppMethodBeat.o(208376);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(208371);
    Object localObject = x.hJf;
    if (x.aGF().hJg)
    {
      localObject = getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_is_live_finished", false) == true))
      {
        AppMethodBeat.o(208371);
        return 1;
      }
      AppMethodBeat.o(208371);
      return 14;
    }
    AppMethodBeat.o(208371);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495276;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(208370);
    Log.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.hTR;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, "onActivityResult " + ((com.tencent.mm.live.a.a)localObject).hwp);
      localObject = ((com.tencent.mm.live.a.a)localObject).hwp;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(208370);
        return;
      }
      AppMethodBeat.o(208370);
      return;
    }
    AppMethodBeat.o(208370);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(208374);
    Object localObject = this.hTR;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.a.a)localObject).hwp;
      if (localObject != null) {}
      for (boolean bool = ((BaseLivePluginLayout)localObject).onBackPress();; bool = false)
      {
        if (!bool) {
          super.onBackPressed();
        }
        AppMethodBeat.o(208374);
        return;
      }
    }
    AppMethodBeat.o(208374);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208366);
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
      p.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      p.g(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(2131303601);
    p.g(paramBundle, "findViewById(R.id.live_ui_root)");
    Object localObject1 = (FrameLayout)paramBundle;
    paramBundle = (LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    boolean bool = getIntent().getBooleanExtra("key_is_live_finished", false);
    Object localObject2 = (Context)this;
    if (localObject1 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(208366);
      throw paramBundle;
    }
    this.hTR = new com.tencent.mm.live.a.a((Context)localObject2, (ViewGroup)localObject1, paramBundle, bool);
    localObject2 = this.hTR;
    if (localObject2 != null)
    {
      localObject1 = ((com.tencent.mm.live.a.a)localObject2).context.getSystemService("phone");
      if (localObject1 == null)
      {
        paramBundle = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(208366);
        throw paramBundle;
      }
      localObject1 = (TelephonyManager)localObject1;
      localObject2 = ((com.tencent.mm.live.a.a)localObject2).phoneStatelistener;
      localObject2 = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    localObject1 = x.hJf;
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getFromScene();
      x.rc(i);
      if (paramBundle == null) {
        break label532;
      }
      paramBundle = Integer.valueOf(paramBundle.aBC());
      label460:
      i = LiveConfig.hvT;
      if (paramBundle != null) {
        break label537;
      }
      label468:
      i = LiveConfig.hvU;
      if (paramBundle != null) {
        break label581;
      }
    }
    for (;;)
    {
      this.hTS = new w((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
      paramBundle = this.hTS;
      if (paramBundle == null) {
        break label625;
      }
      paramBundle.G(21, b.cjf());
      AppMethodBeat.o(208366);
      return;
      i = LiveConfig.hvY;
      break;
      label532:
      paramBundle = null;
      break label460;
      label537:
      if (paramBundle.intValue() != i) {
        break label468;
      }
      paramBundle = x.hJf;
      x.u((Context)this, true);
      paramBundle = this.hTR;
      if (paramBundle != null)
      {
        localObject1 = o.k.hHn;
        paramBundle.qp(o.k.aFM());
        continue;
        label581:
        if (paramBundle.intValue() == i)
        {
          paramBundle = x.hJf;
          x.u((Context)this, false);
          paramBundle = this.hTR;
          if (paramBundle != null)
          {
            localObject1 = o.k.hHn;
            paramBundle.qp(o.k.aFN());
          }
        }
      }
    }
    label625:
    AppMethodBeat.o(208366);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(208373);
    Log.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
    super.onDestroy();
    Object localObject = this.hTR;
    if (localObject != null) {
      ((com.tencent.mm.live.a.a)localObject).onDestroy();
    }
    localObject = this.hTS;
    if (localObject != null)
    {
      ((w)localObject).onDestroy();
      AppMethodBeat.o(208373);
      return;
    }
    AppMethodBeat.o(208373);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(208375);
    Log.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("route_to_maximize", false) != true) {
        break label103;
      }
      paramIntent = this.hTR;
      if (paramIntent == null) {
        break label103;
      }
      paramIntent = paramIntent.hwp;
      if (paramIntent != null)
      {
        b.b.a(paramIntent, b.c.hLR);
        AppMethodBeat.o(208375);
      }
    }
    else
    {
      AppMethodBeat.o(208375);
      return;
    }
    AppMethodBeat.o(208375);
    return;
    label103:
    AppMethodBeat.o(208375);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(208369);
    Log.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
    super.onPause();
    Object localObject = this.hTR;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, "onPause " + ((com.tencent.mm.live.a.a)localObject).hwp);
      localObject = ((com.tencent.mm.live.a.a)localObject).hwp;
      if (localObject != null) {
        ((BaseLivePluginLayout)localObject).pause();
      }
    }
    localObject = this.hTS;
    if (localObject != null) {
      ((w)localObject).aGj();
    }
    com.tencent.mm.plugin.ball.f.f.cji();
    AppMethodBeat.o(208369);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(208367);
    Log.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
    super.onResume();
    Object localObject = this.hTR;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, "onResume " + ((com.tencent.mm.live.a.a)localObject).hwp);
      BaseLivePluginLayout localBaseLivePluginLayout = ((com.tencent.mm.live.a.a)localObject).hwp;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.resume();
      }
      localBaseLivePluginLayout = ((com.tencent.mm.live.a.a)localObject).hwp;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.post((Runnable)new a.b((com.tencent.mm.live.a.a)localObject));
      }
    }
    localObject = this.hTS;
    if (localObject != null) {
      ((w)localObject).aGf();
    }
    com.tencent.mm.plugin.ball.f.f.cjk();
    AppMethodBeat.o(208367);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(208368);
    Log.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
    super.onStart();
    Object localObject1 = this.hTR;
    if (localObject1 != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject1).TAG, "onStart " + ((com.tencent.mm.live.a.a)localObject1).hwp);
      Object localObject2 = ((com.tencent.mm.live.a.a)localObject1).hwp;
      if (localObject2 != null) {
        if ((Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") != 1) || (!((com.tencent.mm.live.a.a)localObject1).sp.getBoolean("settings_landscape_mode", false))) {
          break label164;
        }
      }
      for (;;)
      {
        ((BaseLivePluginLayout)localObject2).onRotationSwitchChange(bool);
        localObject2 = ((com.tencent.mm.live.a.a)localObject1).hwm;
        ((a.a)localObject2).hwt.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, (ContentObserver)localObject2);
        localObject1 = ((com.tencent.mm.live.a.a)localObject1).hwp;
        if (localObject1 == null) {
          break;
        }
        ((BaseLivePluginLayout)localObject1).start();
        AppMethodBeat.o(208368);
        return;
        label164:
        bool = false;
      }
      AppMethodBeat.o(208368);
      return;
    }
    AppMethodBeat.o(208368);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(208372);
    Log.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
    super.onStop();
    Object localObject1 = this.hTR;
    if (localObject1 != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject1).TAG, "onStop " + ((com.tencent.mm.live.a.a)localObject1).hwp);
      Object localObject2 = ((com.tencent.mm.live.a.a)localObject1).hwm;
      ((a.a)localObject2).hwt.unregisterContentObserver((ContentObserver)localObject2);
      localObject2 = ((com.tencent.mm.live.a.a)localObject1).gyh;
      if (localObject2 != null) {
        ((h)localObject2).close();
      }
      localObject1 = ((com.tencent.mm.live.a.a)localObject1).hwp;
      if (localObject1 != null)
      {
        ((BaseLivePluginLayout)localObject1).stop();
        AppMethodBeat.o(208372);
        return;
      }
      AppMethodBeat.o(208372);
      return;
    }
    AppMethodBeat.o(208372);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUIA$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA
 * JD-Core Version:    0.7.0.1
 */