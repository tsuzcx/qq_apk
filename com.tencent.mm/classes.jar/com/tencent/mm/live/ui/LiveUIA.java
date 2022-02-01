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
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.l.j;
import com.tencent.mm.live.model.t;
import com.tencent.mm.live.model.u;
import com.tencent.mm.live.model.u.a;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "originBackground", "Landroid/graphics/drawable/Drawable;", "roomLivePageFloatBallHelper", "Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "initSwipeBack", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "setWindowStyle", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LiveUIA
  extends MMActivity
{
  public static final LiveUIA.a nkR;
  private com.tencent.mm.live.a.a nkS;
  private t nkT;
  private Drawable nkU;
  
  static
  {
    AppMethodBeat.i(246305);
    nkR = new LiveUIA.a((byte)0);
    AppMethodBeat.o(246305);
  }
  
  public int getForceOrientation()
  {
    int j = 0;
    AppMethodBeat.i(246381);
    Object localObject = u.mZl;
    if (u.bis().nab)
    {
      localObject = getIntent();
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (((Intent)localObject).getBooleanExtra("key_is_live_finished", false) == true) {
          i = 1;
        }
      }
      if (i == 0)
      {
        AppMethodBeat.o(246381);
        return 14;
      }
    }
    AppMethodBeat.o(246381);
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.f.live_root_ui_layout;
  }
  
  public void initSwipeBack()
  {
    AppMethodBeat.i(246319);
    super.initSwipeBack();
    j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new LiveUIA.b(this, null), 2);
    AppMethodBeat.o(246319);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(246373);
    Log.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.nkS;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, s.X("onActivityResult ", ((com.tencent.mm.live.a.a)localObject).mJj));
      localObject = ((com.tencent.mm.live.a.a)localObject).mJj;
      if (localObject != null) {
        ((BaseLivePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    AppMethodBeat.o(246373);
  }
  
  public void onBackPressed()
  {
    int j = 0;
    AppMethodBeat.i(246408);
    Object localObject = this.nkS;
    int i = j;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.a.a)localObject).mJj;
      if (localObject != null) {
        break label85;
      }
    }
    label85:
    for (boolean bool = false;; bool = ((BaseLivePluginLayout)localObject).onBackPress())
    {
      i = j;
      if (!bool) {
        i = 1;
      }
      if (i != 0)
      {
        Log.i("MicroMsg.LiveUI", "onBackPressed (" + hashCode() + ')');
        super.onBackPressed();
      }
      AppMethodBeat.o(246408);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246341);
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
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(b.e.live_ui_root);
    s.s(paramBundle, "findViewById(R.id.live_ui_root)");
    paramBundle = (FrameLayout)paramBundle;
    Object localObject1 = (LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    boolean bool = getIntent().getBooleanExtra("key_is_live_finished", false);
    this.nkS = new com.tencent.mm.live.a.a((Context)this, (ViewGroup)paramBundle, (LiveConfig)localObject1, bool);
    Object localObject2 = this.nkS;
    if (localObject2 != null)
    {
      paramBundle = ((com.tencent.mm.live.a.a)localObject2).context.getSystemService("phone");
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(246341);
        throw paramBundle;
      }
      paramBundle = (TelephonyManager)paramBundle;
      localObject2 = ((com.tencent.mm.live.a.a)localObject2).mJl;
      localObject2 = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramBundle.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    paramBundle = u.mZl;
    int i;
    if (localObject1 == null)
    {
      paramBundle = null;
      if (paramBundle != null) {
        break label496;
      }
      i = LiveConfig.mIx;
      label387:
      u.tL(i);
      if (localObject1 != null) {
        break label504;
      }
      paramBundle = null;
      label398:
      i = LiveConfig.mIs;
      if (paramBundle != null) {
        break label516;
      }
      label406:
      i = LiveConfig.mIt;
      if (paramBundle != null) {
        break label560;
      }
    }
    for (;;)
    {
      this.nkT = new t((com.tencent.mm.plugin.ball.a.f)new e((Activity)this));
      paramBundle = this.nkT;
      if (paramBundle != null) {
        paramBundle.J(21, "LiveFloatBall");
      }
      paramBundle = getContext();
      if (paramBundle != null) {
        break label604;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(246341);
      throw paramBundle;
      paramBundle = Integer.valueOf(((LiveConfig)localObject1).fromScene);
      break;
      label496:
      i = paramBundle.intValue();
      break label387;
      label504:
      paramBundle = Integer.valueOf(((LiveConfig)localObject1).mIy);
      break label398;
      label516:
      if (paramBundle.intValue() != i) {
        break label406;
      }
      paramBundle = u.mZl;
      u.y((Context)this, true);
      paramBundle = this.nkS;
      if (paramBundle != null)
      {
        localObject1 = l.j.mYK;
        paramBundle.sL(l.j.bhE());
        continue;
        label560:
        if (paramBundle.intValue() == i)
        {
          paramBundle = u.mZl;
          u.y((Context)this, false);
          paramBundle = this.nkS;
          if (paramBundle != null)
          {
            localObject1 = l.j.mYK;
            paramBundle.sL(l.j.bhF());
          }
        }
      }
    }
    label604:
    this.nkU = ((Activity)paramBundle).getWindow().getDecorView().getBackground();
    AppMethodBeat.o(246341);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(246400);
    Log.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
    super.onDestroy();
    Object localObject = this.nkS;
    if (localObject != null) {
      ((com.tencent.mm.live.a.a)localObject).onDestroy();
    }
    localObject = this.nkT;
    if (localObject != null) {
      ((t)localObject).onDestroy();
    }
    AppMethodBeat.o(246400);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(246425);
    Log.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    getSwipeBackLayout().jFd();
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("route_to_maximize", false) == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        paramIntent = this.nkS;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.mJj;
          if (paramIntent != null) {
            b.b.a((b)paramIntent, b.c.ncy);
          }
        }
      }
      AppMethodBeat.o(246425);
      return;
      i = 0;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(246365);
    Log.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
    super.onPause();
    Object localObject = this.nkS;
    if (localObject != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject).TAG, s.X("onPause ", ((com.tencent.mm.live.a.a)localObject).mJj));
      localObject = ((com.tencent.mm.live.a.a)localObject).mJj;
      if (localObject != null) {
        ((BaseLivePluginLayout)localObject).pause();
      }
    }
    localObject = this.nkT;
    if (localObject != null) {
      ((t)localObject).bhW();
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(246365);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(246347);
    Log.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
    super.onResume();
    Object localObject = this.nkS;
    if (localObject != null) {
      ((com.tencent.mm.live.a.a)localObject).onResume();
    }
    localObject = this.nkT;
    if (localObject != null) {
      ((t)localObject).bhT();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    AppMethodBeat.o(246347);
  }
  
  public void onStart()
  {
    bool = true;
    AppMethodBeat.i(246358);
    Log.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
    super.onStart();
    localObject1 = this.nkS;
    if (localObject1 != null) {
      Log.i(((com.tencent.mm.live.a.a)localObject1).TAG, s.X("onStart ", ((com.tencent.mm.live.a.a)localObject1).mJj));
    }
    for (;;)
    {
      try
      {
        i = Settings.System.getInt(MMApplicationContext.getContext().getContentResolver(), "accelerometer_rotation");
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
      }
      localObject2 = ((com.tencent.mm.live.a.a)localObject1).mJj;
      if (localObject2 != null)
      {
        if ((i == 0) || (!((com.tencent.mm.live.a.a)localObject1).sp.getBoolean("settings_landscape_mode", false))) {
          continue;
        }
        ((BaseLivePluginLayout)localObject2).onRotationSwitchChange(bool);
      }
      localObject2 = ((com.tencent.mm.live.a.a)localObject1).mJg;
      ((a.a)localObject2).mJn.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, (ContentObserver)localObject2);
      localObject1 = ((com.tencent.mm.live.a.a)localObject1).mJj;
      if (localObject1 != null) {
        ((BaseLivePluginLayout)localObject1).start();
      }
      AppMethodBeat.o(246358);
      return;
      i = 0;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(246392);
    Log.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
    super.onStop();
    Object localObject1 = this.nkS;
    if (localObject1 != null)
    {
      Log.i(((com.tencent.mm.live.a.a)localObject1).TAG, s.X("onStop ", ((com.tencent.mm.live.a.a)localObject1).mJj));
      Object localObject2 = ((com.tencent.mm.live.a.a)localObject1).mJg;
      ((a.a)localObject2).mJn.unregisterContentObserver((ContentObserver)localObject2);
      localObject2 = ((com.tencent.mm.live.a.a)localObject1).lKz;
      if (localObject2 != null) {
        ((i)localObject2).close();
      }
      localObject1 = ((com.tencent.mm.live.a.a)localObject1).mJj;
      if (localObject1 != null) {
        ((BaseLivePluginLayout)localObject1).stop();
      }
    }
    getSwipeBackLayout().jFd();
    AppMethodBeat.o(246392);
  }
  
  public void onSwipeBack()
  {
    int j = 0;
    AppMethodBeat.i(246416);
    Log.i("MicroMsg.LiveUI", "onSwipeBack (" + hashCode() + ')');
    Object localObject = this.nkS;
    int i = j;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.a.a)localObject).mJj;
      if (localObject != null) {
        break label118;
      }
    }
    label118:
    for (boolean bool = false;; bool = ((BaseLivePluginLayout)localObject).onSwipeBack())
    {
      i = j;
      if (!bool) {
        i = 1;
      }
      if (i != 0)
      {
        Log.i("MicroMsg.LiveUI", "super onBackPressed (" + hashCode() + ')');
        super.onSwipeBack();
      }
      AppMethodBeat.o(246416);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA
 * JD-Core Version:    0.7.0.1
 */