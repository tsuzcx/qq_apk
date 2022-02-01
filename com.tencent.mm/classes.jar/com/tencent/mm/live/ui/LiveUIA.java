package com.tencent.mm.live.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.a.b;
import com.tencent.mm.live.a.b.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e.j;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.f.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.h;
import d.g.b.k;
import d.l;
import d.v;

@a(35)
@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-logic_release"})
public class LiveUIA
  extends MMActivity
{
  public static final LiveUIA.a Kyc;
  private b Kyb;
  
  static
  {
    AppMethodBeat.i(203256);
    Kyc = new LiveUIA.a((byte)0);
    AppMethodBeat.o(203256);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(203251);
    Object localObject = f.rGw;
    if (f.fhI().rGx)
    {
      localObject = getIntent();
      if ((localObject != null) && (((Intent)localObject).getBooleanExtra("key_is_live_finished", false) == true))
      {
        AppMethodBeat.o(203251);
        return 1;
      }
      AppMethodBeat.o(203251);
      return 14;
    }
    AppMethodBeat.o(203251);
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496327;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(203250);
    ad.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.Kyb;
    if (localObject != null)
    {
      ad.i(((b)localObject).TAG, "onActivityResult " + ((b)localObject).qvu);
      localObject = ((b)localObject).qvu;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(203250);
        return;
      }
      AppMethodBeat.o(203250);
      return;
    }
    AppMethodBeat.o(203250);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(203254);
    Object localObject = this.Kyb;
    if (localObject != null)
    {
      localObject = ((b)localObject).qvu;
      if (localObject != null) {}
      for (boolean bool = ((BaseLivePluginLayout)localObject).dia();; bool = false)
      {
        if (!bool) {
          super.onBackPressed();
        }
        AppMethodBeat.o(203254);
        return;
      }
    }
    AppMethodBeat.o(203254);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203246);
    ad.i("MicroMsg.LiveUI", "onCreate (" + hashCode() + ')');
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
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
    paramBundle = findViewById(2131307732);
    k.g(paramBundle, "findViewById(R.id.live_ui_root)");
    Object localObject1 = (FrameLayout)paramBundle;
    paramBundle = (LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
    boolean bool = getIntent().getBooleanExtra("key_is_live_finished", false);
    Object localObject2 = (Context)this;
    if (localObject1 == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(203246);
      throw paramBundle;
    }
    this.Kyb = new b((Context)localObject2, (ViewGroup)localObject1, paramBundle, bool);
    localObject1 = this.Kyb;
    if (localObject1 != null)
    {
      localObject2 = ((b)localObject1).context.getSystemService("phone");
      if (localObject2 == null)
      {
        paramBundle = new v("null cannot be cast to non-null type android.telephony.TelephonyManager");
        AppMethodBeat.o(203246);
        throw paramBundle;
      }
      ((TelephonyManager)localObject2).listen(((b)localObject1).qvx, 32);
    }
    localObject1 = f.rGw;
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.getFromScene();
      f.agG(i);
      if (paramBundle == null) {
        break label386;
      }
      paramBundle = Integer.valueOf(paramBundle.ckz());
      label357:
      i = LiveConfig.qsH;
      if (paramBundle != null) {
        break label391;
      }
    }
    label386:
    label391:
    while (paramBundle.intValue() != i)
    {
      i = LiveConfig.qsJ;
      if (paramBundle != null) {
        break label432;
      }
      AppMethodBeat.o(203246);
      return;
      i = LiveConfig.qsN;
      break;
      paramBundle = null;
      break label357;
    }
    paramBundle = this.Kyb;
    if (paramBundle != null)
    {
      localObject1 = e.j.rFK;
      paramBundle.By(e.j.eNz());
      AppMethodBeat.o(203246);
      return;
    }
    AppMethodBeat.o(203246);
    return;
    label432:
    if (paramBundle.intValue() == i)
    {
      paramBundle = this.Kyb;
      if (paramBundle != null)
      {
        localObject1 = e.j.rFK;
        paramBundle.By(e.j.eNA());
        AppMethodBeat.o(203246);
        return;
      }
    }
    AppMethodBeat.o(203246);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(203253);
    ad.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
    super.onDestroy();
    b localb = this.Kyb;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(203253);
      return;
    }
    AppMethodBeat.o(203253);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(203255);
    ad.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("route_to_maximize", false) != true) {
        break label103;
      }
      paramIntent = this.Kyb;
      if (paramIntent == null) {
        break label103;
      }
      paramIntent = paramIntent.qvu;
      if (paramIntent != null)
      {
        b.b.a(paramIntent, b.c.FBl);
        AppMethodBeat.o(203255);
      }
    }
    else
    {
      AppMethodBeat.o(203255);
      return;
    }
    AppMethodBeat.o(203255);
    return;
    label103:
    AppMethodBeat.o(203255);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(203249);
    ad.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
    super.onPause();
    Object localObject = this.Kyb;
    if (localObject != null)
    {
      ad.i(((b)localObject).TAG, "onPause " + ((b)localObject).qvu);
      localObject = ((b)localObject).qvu;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).pause();
        AppMethodBeat.o(203249);
        return;
      }
      AppMethodBeat.o(203249);
      return;
    }
    AppMethodBeat.o(203249);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(203247);
    ad.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
    super.onResume();
    b localb = this.Kyb;
    if (localb != null)
    {
      ad.i(localb.TAG, "onResume " + localb.qvu);
      BaseLivePluginLayout localBaseLivePluginLayout = localb.qvu;
      if (localBaseLivePluginLayout != null) {
        localBaseLivePluginLayout.resume();
      }
      localBaseLivePluginLayout = localb.qvu;
      if (localBaseLivePluginLayout != null)
      {
        localBaseLivePluginLayout.post((Runnable)new b.a(localb));
        AppMethodBeat.o(203247);
        return;
      }
      AppMethodBeat.o(203247);
      return;
    }
    AppMethodBeat.o(203247);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(203248);
    ad.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
    super.onStart();
    Object localObject = this.Kyb;
    if (localObject != null)
    {
      ad.i(((b)localObject).TAG, "onStart " + ((b)localObject).qvu);
      localObject = ((b)localObject).qvu;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).start();
        AppMethodBeat.o(203248);
        return;
      }
      AppMethodBeat.o(203248);
      return;
    }
    AppMethodBeat.o(203248);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(203252);
    ad.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
    super.onStop();
    Object localObject = this.Kyb;
    if (localObject != null)
    {
      ad.i(((b)localObject).TAG, "onStop " + ((b)localObject).qvu);
      h localh = ((b)localObject).ftZ;
      if (localh != null) {
        localh.close();
      }
      localObject = ((b)localObject).qvu;
      if (localObject != null)
      {
        ((BaseLivePluginLayout)localObject).stop();
        AppMethodBeat.o(203252);
        return;
      }
      AppMethodBeat.o(203252);
      return;
    }
    AppMethodBeat.o(203252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIA
 * JD-Core Version:    0.7.0.1
 */