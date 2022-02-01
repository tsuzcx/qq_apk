package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveMiniProProxyUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkIntentState", "", "enableActivityAnimation", "", "finish", "getLayoutId", "", "launchMiniProgram", "context", "Landroid/content/Context;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "plugin-finder-live_release"})
public final class FinderLiveMiniProProxyUI
  extends MMFinderUI
{
  final String TAG = "FinderLive.MiniProProxyUI";
  private HashMap _$_findViewCache;
  
  private final void b(Context paramContext, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(232813);
    Log.i(this.TAG, "launchMiniProgram appid:" + paramg.appId + ", path:" + paramg.nBq);
    ((r)h.ae(r.class)).a(paramContext, paramg);
    AppMethodBeat.o(232813);
  }
  
  private final void dvq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(232814);
    Object localObject1 = getIntent();
    Object localObject3;
    int i;
    if (localObject1 != null)
    {
      localObject3 = a.b.BuP;
      localObject3 = a.b.emQ();
      a.b localb = a.b.BuP;
      localObject1 = Integer.valueOf(((Intent)localObject1).getIntExtra((String)localObject3, a.b.emS()));
      Log.i(this.TAG, "[checkIntentState] purpose = ".concat(String.valueOf(localObject1)));
      localObject3 = a.b.BuP;
      i = a.b.emT();
      if (localObject1 != null) {
        break label115;
      }
      label74:
      localObject2 = a.b.BuP;
      i = a.b.emU();
      if (localObject1 != null) {
        break label286;
      }
      label87:
      localObject2 = a.b.BuP;
      i = a.b.emV();
      if (localObject1 != null) {
        break label297;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(232814);
      return;
      localObject1 = null;
      break;
      label115:
      if (((Integer)localObject1).intValue() != i) {
        break label74;
      }
      localObject3 = getIntent();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = a.b.BuP;
        localObject1 = Integer.valueOf(((Intent)localObject3).getIntExtra(a.b.emR(), 0));
      }
      localObject2 = com.tencent.mm.plugin.finder.live.viewmodel.data.g.zeD;
      localObject2 = (Map)com.tencent.mm.plugin.finder.live.viewmodel.data.g.dGB();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(232814);
        throw ((Throwable)localObject1);
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.api.g)ag.fk(localObject2).remove(localObject1);
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
        AppMethodBeat.o(232814);
        return;
      }
      finish();
      AppMethodBeat.o(232814);
      return;
      label286:
      if (((Integer)localObject1).intValue() != i)
      {
        break label87;
        label297:
        if (((Integer)localObject1).intValue() == i) {
          moveTaskToBack(true);
        }
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(232820);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(232820);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(232818);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(232818);
    return localView1;
  }
  
  public final boolean enableActivityAnimation()
  {
    AppMethodBeat.i(232811);
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      Object localObject2 = a.b.BuP;
      localObject2 = a.b.emQ();
      a.b localb = a.b.BuP;
      int i = ((Intent)localObject1).getIntExtra((String)localObject2, a.b.emS());
      localObject1 = a.b.BuP;
      if (i == a.b.emT())
      {
        AppMethodBeat.o(232811);
        return false;
      }
    }
    boolean bool = super.enableActivityAnimation();
    AppMethodBeat.o(232811);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(232809);
    Log.i(this.TAG, "finish");
    super.finish();
    AppMethodBeat.o(232809);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_occupy_ui;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(232810);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "onConfigurationChanged orientation:" + paramConfiguration.orientation);
    AppMethodBeat.o(232810);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232802);
    Log.i(this.TAG, "onCreate");
    super.onCreate(paramBundle);
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
    b.a((Activity)this, (b.b)new a(this));
    AppMethodBeat.o(232802);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232808);
    Log.i(this.TAG, "onDestroy");
    super.onDestroy();
    AppMethodBeat.o(232808);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(232804);
    Log.i(this.TAG, "onNewIntent");
    super.onNewIntent(paramIntent);
    dvq();
    AppMethodBeat.o(232804);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(232806);
    Log.i(this.TAG, "onPause");
    super.onPause();
    AppMethodBeat.o(232806);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(232805);
    Log.i(this.TAG, "onResume");
    super.onResume();
    dvq();
    AppMethodBeat.o(232805);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(232803);
    Log.i(this.TAG, "onStart");
    super.onStart();
    AppMethodBeat.o(232803);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(232807);
    Log.i(this.TAG, "onStop");
    super.onStop();
    AppMethodBeat.o(232807);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onComplete"})
  static final class a
    implements b.b
  {
    a(FinderLiveMiniProProxyUI paramFinderLiveMiniProProxyUI) {}
    
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(233083);
      Log.i(this.xPr.TAG, "convertActivityToTranslucent complete:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(233083);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI
 * JD-Core Version:    0.7.0.1
 */