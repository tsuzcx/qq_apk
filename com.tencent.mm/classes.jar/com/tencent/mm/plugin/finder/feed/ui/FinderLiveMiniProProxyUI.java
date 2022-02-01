package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMiniProProxyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkIntentState", "", "enableActivityAnimation", "", "finish", "getLayoutId", "", "launchMiniProgram", "context", "Landroid/content/Context;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLiveMiniProProxyUI
  extends MMFinderUI
{
  private final String TAG = "FinderLive.MiniProProxyUI";
  
  private static final void a(FinderLiveMiniProProxyUI paramFinderLiveMiniProProxyUI, boolean paramBoolean)
  {
    AppMethodBeat.i(365494);
    s.u(paramFinderLiveMiniProProxyUI, "this$0");
    Log.i(paramFinderLiveMiniProProxyUI.TAG, s.X("convertActivityToTranslucent complete:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(365494);
  }
  
  private final void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(365480);
    Log.i(this.TAG, "launchMiniProgram appid:" + paramg.appId + ", path:" + paramg.qAF);
    ((t)h.ax(t.class)).a(paramContext, paramg);
    AppMethodBeat.o(365480);
  }
  
  private final void efk()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365489);
    Object localObject1 = getIntent();
    Object localObject3;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(this.TAG, s.X("[checkIntentState] purpose = ", localObject1));
      localObject3 = a.b.Hbz;
      i = a.b.frc();
      if (localObject1 != null) {
        break label112;
      }
      label45:
      localObject2 = a.b.Hbz;
      i = a.b.frd();
      if (localObject1 != null) {
        break label284;
      }
      label58:
      localObject2 = a.b.Hbz;
      i = a.b.fre();
      if (localObject1 != null) {
        break label295;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(365489);
      return;
      localObject3 = a.b.Hbz;
      localObject3 = a.b.fqZ();
      a.b localb = a.b.Hbz;
      localObject1 = Integer.valueOf(((Intent)localObject1).getIntExtra((String)localObject3, a.b.frb()));
      break;
      label112:
      if (((Integer)localObject1).intValue() != i) {
        break label45;
      }
      localObject1 = getIntent();
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((Intent)localObject1).getIntExtra(a.b.fra(), 0)))
      {
        localObject2 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.Ebv;
        localObject2 = (Map)com.tencent.mm.plugin.finder.live.viewmodel.data.g.exX();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(365489);
        throw ((Throwable)localObject1);
        localObject2 = a.b.Hbz;
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.api.g)an.hJ(localObject2).remove(localObject1);
      localObject3 = this.TAG;
      localObject1 = new StringBuilder("[LUANCH_MINI_PROGRAM] key = ").append(localObject1).append(",bundle is null:");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i((String)localObject3, bool);
        if (localObject2 == null) {
          break;
        }
        b((Context)this, (com.tencent.mm.plugin.appbrand.api.g)localObject2);
        AppMethodBeat.o(365489);
        return;
      }
      finish();
      AppMethodBeat.o(365489);
      return;
      label284:
      if (((Integer)localObject1).intValue() != i)
      {
        break label58;
        label295:
        if (((Integer)localObject1).intValue() == i) {
          moveTaskToBack(true);
        }
      }
    }
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public boolean enableActivityAnimation()
  {
    AppMethodBeat.i(365561);
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      Object localObject2 = a.b.Hbz;
      localObject2 = a.b.fqZ();
      a.b localb = a.b.Hbz;
      i = ((Intent)localObject1).getIntExtra((String)localObject2, a.b.frb());
      localObject1 = a.b.Hbz;
      if (i != a.b.frc()) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(365561);
      return false;
    }
    boolean bool = super.enableActivityAnimation();
    AppMethodBeat.o(365561);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(365547);
    Log.i(this.TAG, "finish");
    super.finish();
    AppMethodBeat.o(365547);
  }
  
  public int getLayoutId()
  {
    return p.f.CeO;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(365554);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, s.X("onConfigurationChanged orientation:", Integer.valueOf(paramConfiguration.orientation)));
    AppMethodBeat.o(365554);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365512);
    Log.i(this.TAG, "onCreate");
    super.onCreate(paramBundle);
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
    b.a((Activity)this, new FinderLiveMiniProProxyUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(365512);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(365543);
    Log.i(this.TAG, "onDestroy");
    super.onDestroy();
    AppMethodBeat.o(365543);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(365524);
    Log.i(this.TAG, "onNewIntent");
    super.onNewIntent(paramIntent);
    efk();
    AppMethodBeat.o(365524);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(365529);
    Log.i(this.TAG, "onPause");
    super.onPause();
    AppMethodBeat.o(365529);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(365527);
    Log.i(this.TAG, "onResume");
    super.onResume();
    efk();
    AppMethodBeat.o(365527);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(365520);
    Log.i(this.TAG, "onStart");
    super.onStart();
    AppMethodBeat.o(365520);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(365535);
    Log.i(this.TAG, "onStop");
    super.onStop();
    AppMethodBeat.o(365535);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI
 * JD-Core Version:    0.7.0.1
 */