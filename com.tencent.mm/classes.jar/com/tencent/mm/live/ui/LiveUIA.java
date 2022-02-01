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
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.a.b;
import com.tencent.mm.live.a.b.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.j;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.g.a;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.h;
import d.g.b.k;
import d.l;
import d.v;
import org.xwalk.core.XWalkEnvironment;

@a(35)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-logic_release"})
public class LiveUIA
  extends MMActivity
{
  public static final LiveUIA.a gEC;
  private b gEB;
  
  static
  {
    AppMethodBeat.i(190497);
    gEC = new LiveUIA.a((byte)0);
    AppMethodBeat.o(190497);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(190492);
    Object localObject = g.guG;
    if (g.akV().guH)
    {
      localObject = getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_is_live_finished", false) == true))
      {
        AppMethodBeat.o(190492);
        return 1;
      }
      AppMethodBeat.o(190492);
      return 14;
    }
    AppMethodBeat.o(190492);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496336;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190491);
    ac.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.gEB;
    if (localObject != null)
    {
      ac.i(((b)localObject).TAG, "onActivityResult " + ((b)localObject).gmY);
      localObject = ((b)localObject).gmY;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(190491);
        return;
      }
      AppMethodBeat.o(190491);
      return;
    }
    AppMethodBeat.o(190491);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190495);
    Object localObject = this.gEB;
    if (localObject != null)
    {
      localObject = ((b)localObject).gmY;
      if (localObject != null) {}
      for (boolean bool = ((BaseLivePluginLayout)localObject).alO();; bool = false)
      {
        if (!bool) {
          super.onBackPressed();
        }
        AppMethodBeat.o(190495);
        return;
      }
    }
    AppMethodBeat.o(190495);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190487);
    ac.i("MicroMsg.LiveUI", "onCreate (" + hashCode() + ')');
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
      k.g(paramBundle, "window");
      paramBundle = paramBundle.getDecorView();
      k.g(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getWindow().addFlags(-2147483648);
      paramBundle = getWindow();
      k.g(paramBundle, "window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getWindow();
      k.g(paramBundle, "window");
      paramBundle.setNavigationBarColor(0);
    }
    getWindow().setFormat(-3);
    getWindow().setSoftInputMode(51);
    paramBundle = findViewById(2131307813);
    k.g(paramBundle, "findViewById(R.id.live_ui_root)");
    Object localObject1 = (FrameLayout)paramBundle;
    paramBundle = (LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    boolean bool = getIntent().getBooleanExtra("key_is_live_finished", false);
    Object localObject2 = (Context)this;
    if (localObject1 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(190487);
      throw paramBundle;
    }
    this.gEB = new b((Context)localObject2, (ViewGroup)localObject1, paramBundle, bool);
    localObject1 = this.gEB;
    if (localObject1 != null)
    {
      localObject2 = ((b)localObject1).context.getSystemService("phone");
      if (localObject2 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(190487);
        throw paramBundle;
      }
      ((TelephonyManager)localObject2).listen(((b)localObject1).gna, 32);
    }
    localObject1 = g.guG;
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getFromScene();
      g.ne(i);
      if (paramBundle == null) {
        break label393;
      }
      paramBundle = Integer.valueOf(paramBundle.aii());
      label364:
      i = LiveConfig.gmI;
      if (paramBundle != null) {
        break label398;
      }
    }
    label393:
    label398:
    while (paramBundle.intValue() != i)
    {
      i = LiveConfig.gmJ;
      if (paramBundle != null) {
        break label439;
      }
      AppMethodBeat.o(190487);
      return;
      i = LiveConfig.gmN;
      break;
      paramBundle = null;
      break label364;
    }
    paramBundle = this.gEB;
    if (paramBundle != null)
    {
      localObject1 = f.j.gtQ;
      paramBundle.mz(f.j.aky());
      AppMethodBeat.o(190487);
      return;
    }
    AppMethodBeat.o(190487);
    return;
    label439:
    if (paramBundle.intValue() == i)
    {
      paramBundle = this.gEB;
      if (paramBundle != null)
      {
        localObject1 = f.j.gtQ;
        paramBundle.mz(f.j.akz());
        AppMethodBeat.o(190487);
        return;
      }
    }
    AppMethodBeat.o(190487);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190494);
    ac.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
    super.onDestroy();
    b localb = this.gEB;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(190494);
      return;
    }
    AppMethodBeat.o(190494);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190496);
    ac.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("route_to_maximize", false) != true) {
        break label103;
      }
      paramIntent = this.gEB;
      if (paramIntent == null) {
        break label103;
      }
      paramIntent = paramIntent.gmY;
      if (paramIntent != null)
      {
        com.tencent.mm.live.c.b.b.a(paramIntent, b.c.gxZ);
        AppMethodBeat.o(190496);
      }
    }
    else
    {
      AppMethodBeat.o(190496);
      return;
    }
    AppMethodBeat.o(190496);
    return;
    label103:
    AppMethodBeat.o(190496);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190490);
    ac.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
    super.onPause();
    Object localObject = this.gEB;
    if (localObject != null)
    {
      ac.i(((b)localObject).TAG, "onPause " + ((b)localObject).gmY);
      localObject = ((b)localObject).gmY;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).pause();
        AppMethodBeat.o(190490);
        return;
      }
      AppMethodBeat.o(190490);
      return;
    }
    AppMethodBeat.o(190490);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190488);
    ac.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
    super.onResume();
    b localb = this.gEB;
    if (localb != null)
    {
      ac.i(localb.TAG, "onResume " + localb.gmY);
      BaseLivePluginLayout localBaseLivePluginLayout = localb.gmY;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.resume();
      }
      localBaseLivePluginLayout = localb.gmY;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.post((Runnable)new com.tencent.mm.live.a.b.b(localb));
        AppMethodBeat.o(190488);
        return;
      }
      AppMethodBeat.o(190488);
      return;
    }
    AppMethodBeat.o(190488);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(190489);
    ac.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
    super.onStart();
    Object localObject1 = this.gEB;
    if (localObject1 != null)
    {
      ac.i(((b)localObject1).TAG, "onStart " + ((b)localObject1).gmY);
      Object localObject2 = ((b)localObject1).gmY;
      if (localObject2 != null) {
        if ((Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") != 1) || (!((b)localObject1).sp.getBoolean("settings_landscape_mode", false))) {
          break label164;
        }
      }
      for (;;)
      {
        ((BaseLivePluginLayout)localObject2).dU(bool);
        localObject2 = ((b)localObject1).gmV;
        ((b.a)localObject2).gne.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, (ContentObserver)localObject2);
        localObject1 = ((b)localObject1).gmY;
        if (localObject1 == null) {
          break;
        }
        ((BaseLivePluginLayout)localObject1).start();
        AppMethodBeat.o(190489);
        return;
        label164:
        bool = false;
      }
      AppMethodBeat.o(190489);
      return;
    }
    AppMethodBeat.o(190489);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(190493);
    ac.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
    super.onStop();
    Object localObject1 = this.gEB;
    if (localObject1 != null)
    {
      ac.i(((b)localObject1).TAG, "onStop " + ((b)localObject1).gmY);
      Object localObject2 = ((b)localObject1).gmV;
      ((b.a)localObject2).gne.unregisterContentObserver((ContentObserver)localObject2);
      localObject2 = ((b)localObject1).fxG;
      if (localObject2 != null) {
        ((h)localObject2).close();
      }
      localObject1 = ((b)localObject1).gmY;
      if (localObject1 != null)
      {
        ((BaseLivePluginLayout)localObject1).stop();
        AppMethodBeat.o(190493);
        return;
      }
      AppMethodBeat.o(190493);
      return;
    }
    AppMethodBeat.o(190493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA
 * JD-Core Version:    0.7.0.1
 */