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
import com.tencent.mm.sdk.platformtools.ae;
import d.f;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList
  extends AppBrandLauncherUI.Fragment
{
  private static final String TAG = "MicroMsg.AppBrandLauncherRecommendsList";
  public static final AppBrandLauncherRecommendList.a mRx;
  private HashMap _$_findViewCache;
  private final f mRw;
  
  static
  {
    AppMethodBeat.i(51309);
    mRx = new AppBrandLauncherRecommendList.a((byte)0);
    TAG = "MicroMsg.AppBrandLauncherRecommendsList";
    AppMethodBeat.o(51309);
  }
  
  public AppBrandLauncherRecommendList()
  {
    AppMethodBeat.i(51316);
    this.mRw = d.g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(51316);
  }
  
  private final AppBrandRecommendUILogic bBM()
  {
    AppMethodBeat.i(51310);
    AppBrandRecommendUILogic localAppBrandRecommendUILogic = (AppBrandRecommendUILogic)this.mRw.getValue();
    AppMethodBeat.o(51310);
    return localAppBrandRecommendUILogic;
  }
  
  public final void bAd()
  {
    AppMethodBeat.i(51313);
    super.bAd();
    ae.i(TAG, "onTitleDoubleTap");
    LoadMoreRecyclerView localLoadMoreRecyclerView = bBM().bBZ();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localLoadMoreRecyclerView, locala.ahE(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList", "onTitleDoubleTap", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
    localLoadMoreRecyclerView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
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
    Object localObject1 = bBM();
    ((AppBrandRecommendUILogic)localObject1).bBZ().setLayoutManager((RecyclerView.i)((AppBrandRecommendUILogic)localObject1).mSt);
    Object localObject2 = ((AppBrandRecommendUILogic)localObject1).getContentView();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)((AppBrandRecommendUILogic)localObject1).bBZ(), new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandRecommendUILogic)localObject1).mSr.av(true);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mSr;
    Object localObject3 = (m)new AppBrandRecommendUILogic.m((AppBrandRecommendUILogic)localObject1);
    p.h(localObject3, "<set-?>");
    ((a)localObject2).mRB = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mSr;
    localObject3 = (m)new AppBrandRecommendUILogic.n((AppBrandRecommendUILogic)localObject1);
    p.h(localObject3, "<set-?>");
    ((a)localObject2).mRD = ((m)localObject3);
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mSr;
    localObject3 = (m)new AppBrandRecommendUILogic.o((AppBrandRecommendUILogic)localObject1);
    p.h(localObject3, "<set-?>");
    ((a)localObject2).mRC = ((m)localObject3);
    ((AppBrandRecommendUILogic)localObject1).bBZ().setAdapter((RecyclerView.a)((AppBrandRecommendUILogic)localObject1).mSr);
    if (((AppBrandRecommendUILogic)localObject1).bBO())
    {
      ((AppBrandRecommendUILogic)localObject1).bBZ().addHeaderView(((AppBrandRecommendUILogic)localObject1).mSu.bBp());
      localObject2 = ((AppBrandRecommendUILogic)localObject1).mSu.bBp();
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((AppBrandRecommendUILogic)localObject1).mSu.bwp();
      ((AppBrandRecommendUILogic)localObject1).mSu.vF(0);
      ((AppBrandRecommendUILogic)localObject1).mSu.vG(0);
    }
    localObject2 = LayoutInflater.from(((AppBrandRecommendUILogic)localObject1).context).inflate(2131493048, (ViewGroup)((AppBrandRecommendUILogic)localObject1).bBZ(), false);
    ((AppBrandRecommendUILogic)localObject1).bBZ().addHeaderView((View)localObject2);
    localObject3 = ((View)localObject2).findViewById(2131300736);
    if (localObject3 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(51312);
      throw ((Throwable)localObject1);
    }
    ((TextView)localObject3).setText((CharSequence)((AppBrandRecommendUILogic)localObject1).bBN());
    ((View)localObject2).setOnLongClickListener((View.OnLongClickListener)AppBrandRecommendUILogic.g.mSQ);
    ((AppBrandRecommendUILogic)localObject1).bBZ().setLoadingView(((AppBrandRecommendUILogic)localObject1).bCb().bBp());
    i.a((AppBrandRecommendUILogic)localObject1, false);
    i.b((AppBrandRecommendUILogic)localObject1, false);
    ((AppBrandRecommendUILogic)localObject1).bCb();
    ((AppBrandRecommendUILogic)localObject1).bCb().bBF();
    ((AppBrandRecommendUILogic)localObject1).mSs.iqd = ((AppBrandRecommendUILogic)localObject1).bCa().jUd;
    localObject2 = ((AppBrandRecommendUILogic)localObject1).mSs;
    if (((AppBrandRecommendUILogic)localObject1).bCa().jUc > 0)
    {
      bool1 = true;
      ((AppBrandRecommendUILogic.b)localObject2).mSH = bool1;
      ((AppBrandRecommendUILogic)localObject1).bCa().jUj = ((d.g.a.q)new AppBrandRecommendUILogic.f((AppBrandRecommendUILogic)localObject1));
      if ((((AppBrandRecommendUILogic)localObject1).bCa().bds().isEmpty()) || (!((AppBrandRecommendUILogic)localObject1).bCa().jUe)) {
        break label542;
      }
    }
    label542:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((AppBrandRecommendUILogic)localObject1).hQ(bool1);
      if (!bool1) {
        g.vK(2);
      }
      ((AppBrandRecommendUILogic)localObject1).bBZ().setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new AppBrandRecommendUILogic.h((AppBrandRecommendUILogic)localObject1));
      ((AppBrandRecommendUILogic)localObject1).bBZ().a((RecyclerView.m)((AppBrandRecommendUILogic)localObject1).mSD);
      ((AppBrandRecommendUILogic)localObject1).mSv.bBU();
      ((AppBrandRecommendUILogic)localObject1).mSr.notifyDataSetChanged();
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
    ae.i(TAG, "onCreate");
    getLifecycle().addObserver((LifecycleObserver)bBM());
    AppMethodBeat.o(51311);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(51314);
    super.onDestroyView();
    ae.i(TAG, "onDestroyView");
    Lifecycle localLifecycle = getLifecycle();
    p.g(localLifecycle, "lifecycle");
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
    ae.i(TAG, "onPause");
    AppMethodBeat.o(51315);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
  static final class b
    extends d.g.b.q
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