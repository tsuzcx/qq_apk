package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.z.b;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "mDragFeatureView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "mList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "mWxaAttrsStorageListener", "getLayoutId", "", "hideLoading", "", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshDataList", "replace", "", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "requestLayoutSpanCount", "setupStorageListeners", "showLoading", "WrapperGridLayoutManager", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherCollectionList
  extends AppBrandLauncherUI.Fragment
{
  private b iRK;
  private h iRL;
  private a iRM;
  private al iRq;
  private final k.a iRu;
  private final k.a iRv;
  
  public AppBrandLauncherCollectionList()
  {
    AppMethodBeat.i(135068);
    this.iRu = ((k.a)new AppBrandLauncherCollectionList.c(this));
    this.iRv = ((k.a)AppBrandLauncherCollectionList.d.iRQ);
    AppMethodBeat.o(135068);
  }
  
  private final void a(boolean paramBoolean, a.f.a.a<? extends Runnable> parama)
  {
    AppMethodBeat.i(135062);
    parama = (Runnable)new AppBrandLauncherCollectionList.h(this, paramBoolean, parama);
    al localal = this.iRq;
    if (localal == null) {
      j.ebi();
    }
    if (localal.dte())
    {
      parama.run();
      AppMethodBeat.o(135062);
      return;
    }
    localal = this.iRq;
    if (localal == null) {
      j.ebi();
    }
    localal.ac(parama);
    AppMethodBeat.o(135062);
  }
  
  public final void aMd()
  {
    AppMethodBeat.i(135066);
    h localh = this.iRL;
    if (localh != null)
    {
      localh.smoothScrollToPosition(0);
      AppMethodBeat.o(135066);
      return;
    }
    AppMethodBeat.o(135066);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(135065);
    Object localObject1 = new h((Context)getActivity());
    getActivity();
    Object localObject2 = new AppBrandLauncherCollectionList.a();
    ((AppBrandLauncherCollectionList.a)localObject2).jy();
    ((h)localObject1).setLayoutManager((RecyclerView.i)localObject2);
    localObject2 = new a(new ArrayList());
    this.iRM = ((a)localObject2);
    ((h)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((h)localObject1).setClipToPadding(false);
    localObject2 = ((h)localObject1).getContext();
    j.p(localObject2, "context");
    int i = ((Context)localObject2).getResources().getDimensionPixelSize(2131428085);
    localObject2 = ((h)localObject1).getContext();
    j.p(localObject2, "context");
    ((h)localObject1).setPadding(0, i, 0, ((Context)localObject2).getResources().getDimensionPixelSize(2131428085));
    ((h)localObject1).setBackgroundColor(-1);
    ((h)localObject1).b((RecyclerView.h)new e());
    this.iRL = ((h)localObject1);
    localObject1 = getContentView();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(135065);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout)localObject1;
    localObject2 = this.iRL;
    if (localObject2 == null) {
      j.ebi();
    }
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    localObject1 = getActivity();
    if (localObject1 == null) {
      j.ebi();
    }
    j.p(localObject1, "activity!!");
    localObject1 = (Context)localObject1;
    localObject2 = this.iRL;
    if (localObject2 == null) {
      j.ebi();
    }
    localObject1 = new AppBrandLauncherCollectionList.b(this, (Context)localObject1, (h)localObject2);
    localObject2 = getContentView();
    if (localObject2 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(135065);
      throw ((Throwable)localObject1);
    }
    ((FrameLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    localObject2 = this.iRL;
    if (localObject2 == null) {
      j.ebi();
    }
    ((h)localObject2).l((DragFeatureView)localObject1);
    localObject2 = this.iRL;
    if (localObject2 == null) {
      j.ebi();
    }
    ((AppBrandLauncherCollectionList.b)localObject1).setRecyclerView((RecyclerView)localObject2);
    this.iRK = ((b)localObject1);
    AppMethodBeat.o(135065);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(135064);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.iRL;
    if (paramConfiguration != null)
    {
      paramConfiguration = paramConfiguration.getViewTreeObserver();
      if (paramConfiguration != null)
      {
        paramConfiguration.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new AppBrandLauncherCollectionList.e(this));
        AppMethodBeat.o(135064);
        return;
      }
    }
    AppMethodBeat.o(135064);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(135067);
    super.onDestroyView();
    ((c)com.tencent.mm.kernel.g.E(c.class)).a(z.b.hcB);
    ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).remove(this.iRu);
    com.tencent.mm.plugin.appbrand.app.g.auF().remove(this.iRv);
    al localal = this.iRq;
    if (localal != null)
    {
      localal.quit();
      AppMethodBeat.o(135067);
      return;
    }
    AppMethodBeat.o(135067);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(135063);
    j.q(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = this.iRL;
    if (paramView == null) {
      j.ebi();
    }
    paramView.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new AppBrandLauncherCollectionList.f(this));
    this.iRq = new al("AppBrandLauncherCollectionList");
    a(false, (a.f.a.a)new AppBrandLauncherCollectionList.g(this));
    AppMethodBeat.o(135063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList
 * JD-Core Version:    0.7.0.1
 */