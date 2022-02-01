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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.h;
import d.g.b.p;
import d.l;
import d.v;
import org.xwalk.core.XWalkEnvironment;

@a(35)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-logic_release"})
public class LiveUIA
  extends MMActivity
{
  public static final LiveUIA.a haZ;
  private b haY;
  
  static
  {
    AppMethodBeat.i(216415);
    haZ = new LiveUIA.a((byte)0);
    AppMethodBeat.o(216415);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(216410);
    Object localObject = g.gQZ;
    if (g.anX().gRa)
    {
      localObject = getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_is_live_finished", false) == true))
      {
        AppMethodBeat.o(216410);
        return 1;
      }
      AppMethodBeat.o(216410);
      return 14;
    }
    AppMethodBeat.o(216410);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496336;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(216409);
    ae.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.haY;
    if (localObject != null)
    {
      ae.i(((b)localObject).TAG, "onActivityResult " + ((b)localObject).gJq);
      localObject = ((b)localObject).gJq;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(216409);
        return;
      }
      AppMethodBeat.o(216409);
      return;
    }
    AppMethodBeat.o(216409);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(216413);
    Object localObject = this.haY;
    if (localObject != null)
    {
      localObject = ((b)localObject).gJq;
      if (localObject != null) {}
      for (boolean bool = ((BaseLivePluginLayout)localObject).aoQ();; bool = false)
      {
        if (!bool) {
          super.onBackPressed();
        }
        AppMethodBeat.o(216413);
        return;
      }
    }
    AppMethodBeat.o(216413);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216405);
    ae.i("MicroMsg.LiveUI", "onCreate (" + hashCode() + ')');
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
    paramBundle = findViewById(2131307813);
    p.g(paramBundle, "findViewById(R.id.live_ui_root)");
    Object localObject1 = (FrameLayout)paramBundle;
    paramBundle = (LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    boolean bool = getIntent().getBooleanExtra("key_is_live_finished", false);
    Object localObject2 = (Context)this;
    if (localObject1 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(216405);
      throw paramBundle;
    }
    this.haY = new b((Context)localObject2, (ViewGroup)localObject1, paramBundle, bool);
    localObject1 = this.haY;
    if (localObject1 != null)
    {
      localObject2 = ((b)localObject1).context.getSystemService("phone");
      if (localObject2 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(216405);
        throw paramBundle;
      }
      ((TelephonyManager)localObject2).listen(((b)localObject1).gJs, 32);
    }
    localObject1 = g.gQZ;
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getFromScene();
      g.nG(i);
      if (paramBundle == null) {
        break label393;
      }
      paramBundle = Integer.valueOf(paramBundle.alj());
      label364:
      i = LiveConfig.gJa;
      if (paramBundle != null) {
        break label398;
      }
    }
    label393:
    label398:
    while (paramBundle.intValue() != i)
    {
      i = LiveConfig.gJb;
      if (paramBundle != null) {
        break label439;
      }
      AppMethodBeat.o(216405);
      return;
      i = LiveConfig.gJf;
      break;
      paramBundle = null;
      break label364;
    }
    paramBundle = this.haY;
    if (paramBundle != null)
    {
      localObject1 = f.j.gQk;
      paramBundle.nb(f.j.anA());
      AppMethodBeat.o(216405);
      return;
    }
    AppMethodBeat.o(216405);
    return;
    label439:
    if (paramBundle.intValue() == i)
    {
      paramBundle = this.haY;
      if (paramBundle != null)
      {
        localObject1 = f.j.gQk;
        paramBundle.nb(f.j.anB());
        AppMethodBeat.o(216405);
        return;
      }
    }
    AppMethodBeat.o(216405);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(216412);
    ae.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
    super.onDestroy();
    b localb = this.haY;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(216412);
      return;
    }
    AppMethodBeat.o(216412);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(216414);
    ae.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("route_to_maximize", false) != true) {
        break label103;
      }
      paramIntent = this.haY;
      if (paramIntent == null) {
        break label103;
      }
      paramIntent = paramIntent.gJq;
      if (paramIntent != null)
      {
        com.tencent.mm.live.c.b.b.a(paramIntent, b.c.gUs);
        AppMethodBeat.o(216414);
      }
    }
    else
    {
      AppMethodBeat.o(216414);
      return;
    }
    AppMethodBeat.o(216414);
    return;
    label103:
    AppMethodBeat.o(216414);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(216408);
    ae.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
    super.onPause();
    Object localObject = this.haY;
    if (localObject != null)
    {
      ae.i(((b)localObject).TAG, "onPause " + ((b)localObject).gJq);
      localObject = ((b)localObject).gJq;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).pause();
        AppMethodBeat.o(216408);
        return;
      }
      AppMethodBeat.o(216408);
      return;
    }
    AppMethodBeat.o(216408);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(216406);
    ae.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
    super.onResume();
    b localb = this.haY;
    if (localb != null)
    {
      ae.i(localb.TAG, "onResume " + localb.gJq);
      BaseLivePluginLayout localBaseLivePluginLayout = localb.gJq;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.resume();
      }
      localBaseLivePluginLayout = localb.gJq;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.post((Runnable)new com.tencent.mm.live.a.b.b(localb));
        AppMethodBeat.o(216406);
        return;
      }
      AppMethodBeat.o(216406);
      return;
    }
    AppMethodBeat.o(216406);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(216407);
    ae.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
    super.onStart();
    Object localObject1 = this.haY;
    if (localObject1 != null)
    {
      ae.i(((b)localObject1).TAG, "onStart " + ((b)localObject1).gJq);
      Object localObject2 = ((b)localObject1).gJq;
      if (localObject2 != null) {
        if ((Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") != 1) || (!((b)localObject1).sp.getBoolean("settings_landscape_mode", false))) {
          break label164;
        }
      }
      for (;;)
      {
        ((BaseLivePluginLayout)localObject2).dY(bool);
        localObject2 = ((b)localObject1).gJn;
        ((b.a)localObject2).gJw.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, (ContentObserver)localObject2);
        localObject1 = ((b)localObject1).gJq;
        if (localObject1 == null) {
          break;
        }
        ((BaseLivePluginLayout)localObject1).start();
        AppMethodBeat.o(216407);
        return;
        label164:
        bool = false;
      }
      AppMethodBeat.o(216407);
      return;
    }
    AppMethodBeat.o(216407);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(216411);
    ae.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
    super.onStop();
    Object localObject1 = this.haY;
    if (localObject1 != null)
    {
      ae.i(((b)localObject1).TAG, "onStop " + ((b)localObject1).gJq);
      Object localObject2 = ((b)localObject1).gJn;
      ((b.a)localObject2).gJw.unregisterContentObserver((ContentObserver)localObject2);
      localObject2 = ((b)localObject1).fSZ;
      if (localObject2 != null) {
        ((h)localObject2).close();
      }
      localObject1 = ((b)localObject1).gJq;
      if (localObject1 != null)
      {
        ((BaseLivePluginLayout)localObject1).stop();
        AppMethodBeat.o(216411);
        return;
      }
      AppMethodBeat.o(216411);
      return;
    }
    AppMethodBeat.o(216411);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA
 * JD-Core Version:    0.7.0.1
 */