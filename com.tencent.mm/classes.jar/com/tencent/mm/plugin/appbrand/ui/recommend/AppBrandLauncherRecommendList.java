package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.util.HashMap;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList
  extends AppBrandLauncherUI.Fragment
{
  private static final String TAG = "MicroMsg.AppBrandLauncherRecommendsList";
  public static final AppBrandLauncherRecommendList.a lJV;
  private HashMap _$_findViewCache;
  private final f lJU;
  
  static
  {
    AppMethodBeat.i(51309);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(AppBrandLauncherRecommendList.class), "uiLogic", "getUiLogic()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;")) };
    lJV = new AppBrandLauncherRecommendList.a((byte)0);
    TAG = "MicroMsg.AppBrandLauncherRecommendsList";
    AppMethodBeat.o(51309);
  }
  
  public AppBrandLauncherRecommendList()
  {
    AppMethodBeat.i(51316);
    this.lJU = d.g.E((d.g.a.a)new b(this));
    AppMethodBeat.o(51316);
  }
  
  private final AppBrandRecommendUILogic bpP()
  {
    AppMethodBeat.i(51310);
    AppBrandRecommendUILogic localAppBrandRecommendUILogic = (AppBrandRecommendUILogic)this.lJU.getValue();
    AppMethodBeat.o(51310);
    return localAppBrandRecommendUILogic;
  }
  
  public final void bog()
  {
    AppMethodBeat.i(51313);
    super.bog();
    ad.i(TAG, "onTitleDoubleTap");
    LoadMoreRecyclerView localLoadMoreRecyclerView = bpP().bqc();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLoadMoreRecyclerView, locala.adn(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localLoadMoreRecyclerView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localLoadMoreRecyclerView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(51313);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(51312);
    Object localObject1 = bpP();
    ((AppBrandRecommendUILogic)localObject1).bqc().setLayoutManager((RecyclerView.i)((AppBrandRecommendUILogic)localObject1).lKQ);
    Object localObject2 = ((AppBrandRecommendUILogic)localObject1).getContentView();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)((AppBrandRecommendUILogic)localObject1).bqc(), new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandRecommendUILogic)localObject1).lKO.av(true);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).lKO;
    Object localObject3 = (m)new AppBrandRecommendUILogic.m((AppBrandRecommendUILogic)localObject1);
    d.g.b.k.h(localObject3, "<set-?>");
    ((a)localObject2).lJZ = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).lKO;
    localObject3 = (m)new AppBrandRecommendUILogic.n((AppBrandRecommendUILogic)localObject1);
    d.g.b.k.h(localObject3, "<set-?>");
    ((a)localObject2).lKb = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).lKO;
    localObject3 = (m)new AppBrandRecommendUILogic.o((AppBrandRecommendUILogic)localObject1);
    d.g.b.k.h(localObject3, "<set-?>");
    ((a)localObject2).lKa = ((m)localObject3);
    ((AppBrandRecommendUILogic)localObject1).bqc().setAdapter((RecyclerView.a)((AppBrandRecommendUILogic)localObject1).lKO);
    if (((AppBrandRecommendUILogic)localObject1).bpR())
    {
      ((AppBrandRecommendUILogic)localObject1).bqc().addHeaderView(((AppBrandRecommendUILogic)localObject1).lKR.bpu());
      localObject2 = ((AppBrandRecommendUILogic)localObject1).lKR.bpu();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((AppBrandRecommendUILogic)localObject1).lKR.bpt();
      ((AppBrandRecommendUILogic)localObject1).lKR.ud(0);
      ((AppBrandRecommendUILogic)localObject1).lKR.ue(0);
    }
    localObject2 = LayoutInflater.from(((AppBrandRecommendUILogic)localObject1).context).inflate(2131493048, (ViewGroup)((AppBrandRecommendUILogic)localObject1).bqc(), false);
    ((AppBrandRecommendUILogic)localObject1).bqc().addHeaderView((View)localObject2);
    localObject3 = ((View)localObject2).findViewById(2131300736);
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((TextView)localObject3).setText((CharSequence)((AppBrandRecommendUILogic)localObject1).bpQ());
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)AppBrandRecommendUILogic.g.lLn);
    ((AppBrandRecommendUILogic)localObject1).bqc().setLoadingView(((AppBrandRecommendUILogic)localObject1).bqe().bpu());
    i.a((AppBrandRecommendUILogic)localObject1, false);
    i.b((AppBrandRecommendUILogic)localObject1, false);
    ((AppBrandRecommendUILogic)localObject1).bqe();
    ((AppBrandRecommendUILogic)localObject1).bqe().bpI();
    ((AppBrandRecommendUILogic)localObject1).lKP.htm = ((AppBrandRecommendUILogic)localObject1).bqd().iWz;
    localObject2 = ((AppBrandRecommendUILogic)localObject1).lKP;
    if (((AppBrandRecommendUILogic)localObject1).bqd().iWy > 0)
    {
      bool1 = true;
      ((AppBrandRecommendUILogic.b)localObject2).lLe = bool1;
      ((AppBrandRecommendUILogic)localObject1).bqd().iWF = ((q)new AppBrandRecommendUILogic.f((AppBrandRecommendUILogic)localObject1));
      if ((((AppBrandRecommendUILogic)localObject1).bqd().aSs().isEmpty()) || (!((AppBrandRecommendUILogic)localObject1).bqd().iWA)) {
        break label542;
      }
    }
    label542:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AppBrandRecommendUILogic)localObject1).hj(bool1);
      if (!bool1) {
        g.ui(2);
      }
      ((AppBrandRecommendUILogic)localObject1).bqc().setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new AppBrandRecommendUILogic.h((AppBrandRecommendUILogic)localObject1));
      ((AppBrandRecommendUILogic)localObject1).bqc().a((RecyclerView.m)((AppBrandRecommendUILogic)localObject1).lLa);
      ((AppBrandRecommendUILogic)localObject1).lKS.bpX();
      ((AppBrandRecommendUILogic)localObject1).lKO.notifyDataSetChanged();
      AppMethodBeat.o(51312);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51311);
    super.onCreate(paramBundle);
    ad.i(TAG, "onCreate");
    getLifecycle().addObserver((LifecycleObserver)bpP());
    AppMethodBeat.o(51311);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(51314);
    super.onDestroyView();
    ad.i(TAG, "onDestroyView");
    Lifecycle localLifecycle = getLifecycle();
    d.g.b.k.g(localLifecycle, "lifecycle");
    localLifecycle.getCurrentState();
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(51314);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51315);
    super.onPause();
    ad.i(TAG, "onPause");
    AppMethodBeat.o(51315);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<AppBrandLauncherRecommendList.uiLogic.2.1>
  {
    b(AppBrandLauncherRecommendList paramAppBrandLauncherRecommendList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList
 * JD-Core Version:    0.7.0.1
 */