package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f;
import a.f.a.a;
import a.f.b.t;
import a.l;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.h.c.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "mHadEnterWxa", "", "mList", "Landroid/support/v7/widget/RecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "mRefreshOnResume", "mWxaAttrsStorageListener", "sceneFor13801", "", "getSceneFor13801", "()I", "sceneFor13801$delegate", "Lkotlin/Lazy;", "sceneIdFor13801", "", "getSceneIdFor13801", "()Ljava/lang/String;", "sceneIdFor13801$delegate", "getLayoutId", "hideLoading", "", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEnter", "onResume", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "queryDataList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "refreshDataList", "replace", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "setupStorageListeners", "showLoading", "updateDataListUsingDiffs", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionDisplayVerticalList
  extends AppBrandLauncherUI.Fragment
  implements l.a
{
  private RecyclerView iRn;
  private j iRo;
  private boolean iRp;
  private al iRq;
  private boolean iRr;
  private final f iRs;
  private final f iRt;
  private final k.a iRu;
  private final k.a iRv;
  
  static
  {
    AppMethodBeat.i(135020);
    eOJ = new a.j.k[] { (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(AppBrandCollectionDisplayVerticalList.class), "sceneFor13801", "getSceneFor13801()I")), (a.j.k)a.f.b.v.a(new t(a.f.b.v.aG(AppBrandCollectionDisplayVerticalList.class), "sceneIdFor13801", "getSceneIdFor13801()Ljava/lang/String;")) };
    AppMethodBeat.o(135020);
  }
  
  public AppBrandCollectionDisplayVerticalList()
  {
    AppMethodBeat.i(135030);
    this.iRs = a.g.j((a)new AppBrandCollectionDisplayVerticalList.h(this));
    this.iRt = a.g.j((a)new AppBrandCollectionDisplayVerticalList.i(this));
    this.iRu = ((k.a)new AppBrandCollectionDisplayVerticalList.b(this));
    this.iRv = ((k.a)new AppBrandCollectionDisplayVerticalList.c(this));
    AppMethodBeat.o(135030);
  }
  
  private final void a(boolean paramBoolean, a<? extends Runnable> parama)
  {
    AppMethodBeat.i(135022);
    parama = (Runnable)new AppBrandCollectionDisplayVerticalList.g(this, paramBoolean, parama);
    al localal = this.iRq;
    if (localal == null) {
      a.f.b.j.ebi();
    }
    if (localal.dte())
    {
      parama.run();
      AppMethodBeat.o(135022);
      return;
    }
    localal = this.iRq;
    if (localal == null) {
      a.f.b.j.ebi();
    }
    localal.ac(parama);
    AppMethodBeat.o(135022);
  }
  
  private static List<LocalUsageInfo> aMR()
  {
    AppMethodBeat.i(135021);
    Object localObject2 = ((af)com.tencent.mm.kernel.g.E(af.class)).a(2147483647, af.a.hcJ);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)a.a.v.BMx;
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label103:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((LocalUsageInfo)localObject3 != null) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label103;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(135021);
    return localObject1;
  }
  
  public final void aMd()
  {
    AppMethodBeat.i(135028);
    RecyclerView localRecyclerView = this.iRn;
    if (localRecyclerView != null)
    {
      localRecyclerView.smoothScrollToPosition(0);
      AppMethodBeat.o(135028);
      return;
    }
    AppMethodBeat.o(135028);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(135027);
    Object localObject1 = new RecyclerView((Context)getActivity());
    getActivity();
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new AppBrandCollectionDisplayVerticalList.a(this));
    Object localObject2 = new j(new ArrayList(), (l.a)this);
    this.iRo = ((j)localObject2);
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    ((RecyclerView)localObject1).setBackgroundColor(-1);
    ((RecyclerView)localObject1).b((RecyclerView.h)new k());
    ((RecyclerView)localObject1).setItemAnimator(null);
    this.iRn = ((RecyclerView)localObject1);
    localObject1 = getContentView();
    if (localObject1 == null)
    {
      localObject1 = new a.v("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(135027);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout)localObject1;
    localObject2 = this.iRn;
    if (localObject2 == null) {
      a.f.b.j.ebi();
    }
    ((FrameLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(135027);
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(135024);
    super.onActivityCreated(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    paramBundle = localFragmentActivity;
    if (!(localFragmentActivity instanceof MMActivity)) {
      paramBundle = null;
    }
    paramBundle = (MMActivity)paramBundle;
    if (paramBundle != null)
    {
      paramBundle.addTextOptionMenu(0, getString(2131296869), (MenuItem.OnMenuItemClickListener)new AppBrandCollectionDisplayVerticalList.d(this), null, q.b.zbA);
      AppMethodBeat.o(135024);
      return;
    }
    AppMethodBeat.o(135024);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(135029);
    super.onDestroyView();
    ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).remove(this.iRu);
    com.tencent.mm.plugin.appbrand.app.g.auF().remove(this.iRv);
    al localal = this.iRq;
    if (localal != null)
    {
      localal.quit();
      AppMethodBeat.o(135029);
      return;
    }
    AppMethodBeat.o(135029);
  }
  
  public final void onEnter()
  {
    this.iRr = true;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(135025);
    super.onResume();
    if (this.iRp)
    {
      a(this);
      this.iRp = false;
    }
    if (this.iRr)
    {
      e.ps(2);
      this.iRr = false;
    }
    AppMethodBeat.o(135025);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(135026);
    a.f.b.j.q(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    this.iRq = new al("AppBrandLauncherCollectionList");
    a(false, (a)new AppBrandCollectionDisplayVerticalList.e(this));
    AppMethodBeat.o(135026);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$updateDataListUsingDiffs$2$1"})
  static final class j
    implements Runnable
  {
    j(c.b paramb, AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList, List paramList) {}
    
    public final void run()
    {
      AppMethodBeat.i(135018);
      j localj = AppBrandCollectionDisplayVerticalList.b(this.iRw);
      if (localj != null)
      {
        localj.aL(this.haO);
        this.iRD.a((RecyclerView.a)localj);
        AppMethodBeat.o(135018);
        return;
      }
      AppMethodBeat.o(135018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList
 * JD-Core Version:    0.7.0.1
 */