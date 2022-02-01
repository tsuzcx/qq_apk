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
import com.tencent.mm.sdk.platformtools.ac;
import d.f;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.util.HashMap;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList
  extends AppBrandLauncherUI.Fragment
{
  private static final String TAG = "MicroMsg.AppBrandLauncherRecommendsList";
  public static final AppBrandLauncherRecommendList.a mlS;
  private HashMap _$_findViewCache;
  private final f mlR;
  
  static
  {
    AppMethodBeat.i(51309);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(AppBrandLauncherRecommendList.class), "uiLogic", "getUiLogic()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;")) };
    mlS = new AppBrandLauncherRecommendList.a((byte)0);
    TAG = "MicroMsg.AppBrandLauncherRecommendsList";
    AppMethodBeat.o(51309);
  }
  
  public AppBrandLauncherRecommendList()
  {
    AppMethodBeat.i(51316);
    this.mlR = d.g.K((d.g.a.a)new b(this));
    AppMethodBeat.o(51316);
  }
  
  private final AppBrandRecommendUILogic bwM()
  {
    AppMethodBeat.i(51310);
    AppBrandRecommendUILogic localAppBrandRecommendUILogic = (AppBrandRecommendUILogic)this.mlR.getValue();
    AppMethodBeat.o(51310);
    return localAppBrandRecommendUILogic;
  }
  
  public final void bvc()
  {
    AppMethodBeat.i(51313);
    super.bvc();
    ac.i(TAG, "onTitleDoubleTap");
    LoadMoreRecyclerView localLoadMoreRecyclerView = bwM().bwZ();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLoadMoreRecyclerView, locala.aeD(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localLoadMoreRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
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
    Object localObject1 = bwM();
    ((AppBrandRecommendUILogic)localObject1).bwZ().setLayoutManager((RecyclerView.i)((AppBrandRecommendUILogic)localObject1).mmN);
    Object localObject2 = ((AppBrandRecommendUILogic)localObject1).getContentView();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)((AppBrandRecommendUILogic)localObject1).bwZ(), new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandRecommendUILogic)localObject1).mmL.av(true);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mmL;
    Object localObject3 = (m)new AppBrandRecommendUILogic.m((AppBrandRecommendUILogic)localObject1);
    d.g.b.k.h(localObject3, "<set-?>");
    ((a)localObject2).mlW = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mmL;
    localObject3 = (m)new AppBrandRecommendUILogic.n((AppBrandRecommendUILogic)localObject1);
    d.g.b.k.h(localObject3, "<set-?>");
    ((a)localObject2).mlY = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mmL;
    localObject3 = (m)new AppBrandRecommendUILogic.o((AppBrandRecommendUILogic)localObject1);
    d.g.b.k.h(localObject3, "<set-?>");
    ((a)localObject2).mlX = ((m)localObject3);
    ((AppBrandRecommendUILogic)localObject1).bwZ().setAdapter((RecyclerView.a)((AppBrandRecommendUILogic)localObject1).mmL);
    if (((AppBrandRecommendUILogic)localObject1).bwO())
    {
      ((AppBrandRecommendUILogic)localObject1).bwZ().addHeaderView(((AppBrandRecommendUILogic)localObject1).mmO.bwp());
      localObject2 = ((AppBrandRecommendUILogic)localObject1).mmO.bwp();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((AppBrandRecommendUILogic)localObject1).mmO.bwo();
      ((AppBrandRecommendUILogic)localObject1).mmO.uV(0);
      ((AppBrandRecommendUILogic)localObject1).mmO.uW(0);
    }
    localObject2 = LayoutInflater.from(((AppBrandRecommendUILogic)localObject1).context).inflate(2131493048, (ViewGroup)((AppBrandRecommendUILogic)localObject1).bwZ(), false);
    ((AppBrandRecommendUILogic)localObject1).bwZ().addHeaderView((View)localObject2);
    localObject3 = ((View)localObject2).findViewById(2131300736);
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((TextView)localObject3).setText((CharSequence)((AppBrandRecommendUILogic)localObject1).bwN());
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)AppBrandRecommendUILogic.g.mnk);
    ((AppBrandRecommendUILogic)localObject1).bwZ().setLoadingView(((AppBrandRecommendUILogic)localObject1).bxb().bwp());
    i.a((AppBrandRecommendUILogic)localObject1, false);
    i.b((AppBrandRecommendUILogic)localObject1, false);
    ((AppBrandRecommendUILogic)localObject1).bxb();
    ((AppBrandRecommendUILogic)localObject1).bxb().bwF();
    ((AppBrandRecommendUILogic)localObject1).mmM.hTO = ((AppBrandRecommendUILogic)localObject1).bxa().jwP;
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mmM;
    if (((AppBrandRecommendUILogic)localObject1).bxa().jwO > 0)
    {
      bool1 = true;
      ((AppBrandRecommendUILogic.b)localObject2).mnb = bool1;
      ((AppBrandRecommendUILogic)localObject1).bxa().jwV = ((q)new AppBrandRecommendUILogic.f((AppBrandRecommendUILogic)localObject1));
      if ((((AppBrandRecommendUILogic)localObject1).bxa().aZp().isEmpty()) || (!((AppBrandRecommendUILogic)localObject1).bxa().jwQ)) {
        break label542;
      }
    }
    label542:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AppBrandRecommendUILogic)localObject1).hG(bool1);
      if (!bool1) {
        g.va(2);
      }
      ((AppBrandRecommendUILogic)localObject1).bwZ().setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new AppBrandRecommendUILogic.h((AppBrandRecommendUILogic)localObject1));
      ((AppBrandRecommendUILogic)localObject1).bwZ().a((RecyclerView.m)((AppBrandRecommendUILogic)localObject1).mmX);
      ((AppBrandRecommendUILogic)localObject1).mmP.bwU();
      ((AppBrandRecommendUILogic)localObject1).mmL.notifyDataSetChanged();
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
    ac.i(TAG, "onCreate");
    getLifecycle().addObserver((LifecycleObserver)bwM());
    AppMethodBeat.o(51311);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(51314);
    super.onDestroyView();
    ac.i(TAG, "onDestroyView");
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
    ac.i(TAG, "onPause");
    AppMethodBeat.o(51315);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList
 * JD-Core Version:    0.7.0.1
 */