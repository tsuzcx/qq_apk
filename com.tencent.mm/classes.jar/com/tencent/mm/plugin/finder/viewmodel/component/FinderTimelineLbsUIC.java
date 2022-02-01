package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.aa;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.feed.ab.j;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.j.a;
import com.tencent.mm.plugin.finder.feed.model.j.a.a;
import com.tencent.mm.plugin.finder.feed.model.m;
import com.tencent.mm.plugin.finder.feed.y.a;
import com.tencent.mm.plugin.finder.feed.y.b;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineLbsUIC
  extends UIComponent
{
  public static final FinderTimelineLbsUIC.a sfb;
  private final FinderGlobalLocationVM rss;
  public ab seW;
  public z seX;
  private com.tencent.mm.plugin.finder.feed.ac seY;
  private boolean seZ;
  private boolean sfa;
  
  static
  {
    AppMethodBeat.i(204638);
    sfb = new FinderTimelineLbsUIC.a((byte)0);
    AppMethodBeat.o(204638);
  }
  
  public FinderTimelineLbsUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204637);
    paramMMActivity = com.tencent.mm.ui.component.a.IrY;
    paramMMActivity = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderGlobalLocationVM.class);
    k.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.rss = ((FinderGlobalLocationVM)paramMMActivity);
    this.seZ = true;
    this.sfa = true;
    AppMethodBeat.o(204637);
  }
  
  private final void cGi()
  {
    AppMethodBeat.i(204636);
    if (this.sfa)
    {
      this.sfa = false;
      Object localObject = this.seW;
      if (localObject != null) {
        ((ab)localObject).uh(100L);
      }
      localObject = this.seX;
      if (localObject != null) {
        ((z)localObject).uh(100L);
      }
      localObject = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.V((Context)getActivity(), 5);
    }
    AppMethodBeat.o(204636);
  }
  
  public final void cCp()
  {
    AppMethodBeat.i(204629);
    Object localObject = this.seW;
    if (localObject != null) {
      ((ab)localObject).ly(true);
    }
    localObject = this.seX;
    if (localObject != null)
    {
      ((z)localObject).ly(true);
      AppMethodBeat.o(204629);
      return;
    }
    AppMethodBeat.o(204629);
  }
  
  public final void cFW()
  {
    AppMethodBeat.i(204631);
    super.cFW();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).ET(2);
    AppMethodBeat.o(204631);
  }
  
  public final void cGh()
  {
    AppMethodBeat.i(204632);
    super.cGh();
    Object localObject1 = this.seW;
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((ab)localObject1).rjB;
      if (localObject2 == null) {
        k.aVY("viewCallback");
      }
      i = ab.u(((y.b)localObject2).getRecyclerView());
      com.tencent.mm.sdk.platformtools.ac.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((ab)localObject1).rjE);
      localObject2 = ((Iterable)((ab)localObject1).rke.getDataListJustForAdapter()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((BaseFinderFeed)((Iterator)localObject2).next()).showLikeTips = false;
      }
      FinderHomeTabStateVM.a(((ab)localObject1).rjC, 2, 0, ((ab)localObject1).rjE, (ArrayList)((ab)localObject1).rke.getDataListJustForAdapter());
    }
    localObject1 = this.seX;
    if (localObject1 != null)
    {
      localObject2 = ((z)localObject1).rjB;
      if (localObject2 == null) {
        k.aVY("viewCallback");
      }
      i = z.u(((y.b)localObject2).getRecyclerView());
      com.tencent.mm.sdk.platformtools.ac.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((z)localObject1).rjE);
      localObject2 = ((z)localObject1).rjC;
      int j = ((z)localObject1).rjE;
      ArrayList localArrayList = new ArrayList(0);
      localObject1 = ((z)localObject1).rjA;
      if (localObject1 == null) {
        k.aVY("feedLoader");
      }
      ((FinderHomeTabStateVM)localObject2).a(1000, i, j, localArrayList, (ArrayList)((i)localObject1).getDataListJustForAdapter());
      AppMethodBeat.o(204632);
      return;
    }
    AppMethodBeat.o(204632);
  }
  
  public final void cvj()
  {
    AppMethodBeat.i(204630);
    super.cvj();
    Object localObject1 = com.tencent.mm.ui.component.a.IrY;
    com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    localObject1 = this.seW;
    Object localObject2;
    if (localObject1 != null)
    {
      c.b(null, (d.g.a.a)new ab.j((ab)localObject1));
      if (((ab)localObject1).rjG)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.V((Context)((ab)localObject1).activity, 1);
      }
    }
    localObject1 = this.seX;
    if (localObject1 != null)
    {
      if (((z)localObject1).rjG)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.V((Context)((z)localObject1).activity, 1);
      }
      localObject1 = g.ad(PluginFinder.class);
      k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject1).getRedDotManager().Dy(1003);
    }
    localObject1 = com.tencent.mm.ui.component.a.IrY;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoRecycler.class)).C((d.g.a.b)FinderTimelineLbsUIC.b.sfc);
    this.rss.bTx();
    localObject1 = g.ad(PluginFinder.class);
    k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    if (((com.tencent.mm.plugin.finder.extension.reddot.d)localObject1).Dz(2))
    {
      com.tencent.mm.sdk.platformtools.ac.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject2 = this.seW;
      if (localObject2 != null) {
        ((ab)localObject2).uh(0L);
      }
      localObject2 = this.seX;
      if (localObject2 != null) {
        ((z)localObject2).uh(0L);
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czT())
      {
        localObject2 = FinderReporterUIC.seQ;
        localObject2 = FinderReporterUIC.a.eV((Context)getActivity());
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject2).cGb(), 6);
        }
      }
    }
    ((com.tencent.mm.plugin.finder.extension.reddot.d)localObject1).Dy(1003);
    AppMethodBeat.o(204630);
  }
  
  public final int getLayoutId()
  {
    return 2131496265;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204634);
    if ((paramInt1 == 501) && (paramInt2 == 0) && (this.seW != null) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("KEY_CACHE_ID", 0L);
      int i = paramIntent.getIntExtra("KEY_CLICK_FEED_POSITION", -1);
      paramIntent = com.tencent.mm.plugin.finder.feed.model.j.rmZ;
      j.a.a locala = j.a.un(l);
      paramIntent = com.tencent.mm.plugin.finder.feed.model.j.rmZ;
      j.a.ui(l);
      Object localObject2 = this.seW;
      Object localObject1;
      label143:
      int j;
      Object localObject4;
      label233:
      Object localObject5;
      if (localObject2 != null)
      {
        paramIntent = ((ab)localObject2).cvn();
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getRecyclerView();
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getAdapter();
            if (localObject2 == null) {
              break label293;
            }
            localObject1 = ((ab)localObject2).cvn();
            if (localObject1 == null) {
              break label293;
            }
            localObject1 = ((y.b)localObject1).getRecyclerView();
            if (localObject1 == null) {
              break label293;
            }
            localObject1 = ((RecyclerView)localObject1).getLayoutManager();
            if ((paramIntent == null) || (!(paramIntent instanceof WxRecyclerAdapter)) || (!(localObject1 instanceof StaggeredGridLayoutManager)) || (bs.gY(locala.dataList)) || (locala.lastBuffer == null)) {
              break label503;
            }
            j = ((WxRecyclerAdapter)paramIntent).JCb.size();
            localObject2 = ((ab)localObject2).rke.getDataList();
            localObject4 = (Iterable)localObject2;
            localObject3 = (Collection)new ArrayList();
            localObject4 = ((Iterable)localObject4).iterator();
            paramInt1 = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label304;
            }
            localObject5 = ((Iterator)localObject4).next();
            if (paramInt1 < 0) {
              d.a.j.fOc();
            }
            if (paramInt1 < j) {
              break label299;
            }
          }
        }
      }
      label293:
      label299:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 != 0) {
          ((Collection)localObject3).add(localObject5);
        }
        paramInt1 += 1;
        break label233;
        paramIntent = null;
        break;
        localObject1 = null;
        break label143;
      }
      label304:
      Object localObject3 = (List)localObject3;
      if (((List)localObject3).size() != locala.dataList.size())
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((DataBuffer)localObject2).remove((BaseFinderFeed)((Iterator)localObject3).next());
        }
        ((DataBuffer)localObject2).addAll((Collection)locala.dataList);
        localObject3 = g.agR();
        k.g(localObject3, "MMKernel.storage()");
        localObject3 = ((e)localObject3).agA();
        localObject4 = n.rPN;
        ((ae)localObject3).set(n.EI(2), bs.cx(locala.lastBuffer.toByteArray()));
        paramIntent.notifyDataSetChanged();
      }
      if (i >= 0) {
        ((StaggeredGridLayoutManager)localObject1).af(i + j, 0);
      }
      com.tencent.mm.sdk.platformtools.ac.i("Finder.TimelineLbsUIC", "lxl onActivityResult refresh lbs, pos:" + i + ", headCount:" + j + ", datasize:" + ((DataBuffer)localObject2).size());
    }
    label503:
    AppMethodBeat.o(204634);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204626);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czW())
    {
      paramBundle = new ab(getActivity(), (FinderHomeTabFragment)this.fragment);
      this.seW = paramBundle;
      com.tencent.mm.plugin.finder.feed.ac localac = new com.tencent.mm.plugin.finder.feed.ac(getActivity(), (y.a)paramBundle, getRootView());
      paramBundle.a((y.b)localac);
      this.seY = localac;
      AppMethodBeat.o(204626);
      return;
    }
    paramBundle = new z(getActivity(), (FinderHomeTabFragment)this.fragment);
    this.seX = paramBundle;
    paramBundle.a((y.b)new aa(getActivity(), (y.a)paramBundle, getRootView()));
    AppMethodBeat.o(204626);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204633);
    super.onDestroy();
    Object localObject = this.seW;
    if (localObject != null) {
      ((ab)localObject).onDetach();
    }
    localObject = this.seX;
    if (localObject != null)
    {
      ((z)localObject).onDetach();
      AppMethodBeat.o(204633);
      return;
    }
    AppMethodBeat.o(204633);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204628);
    super.onPause();
    this.seZ = FinderGlobalLocationVM.cFG();
    AppMethodBeat.o(204628);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(204635);
    k.h(paramArrayOfString, "permissions");
    k.h(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        cGi();
        AppMethodBeat.o(204635);
        return;
      }
      paramArrayOfString = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.V((Context)getActivity(), 3);
    }
    AppMethodBeat.o(204635);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204627);
    super.onResume();
    if ((!this.seZ) && (FinderGlobalLocationVM.cFG())) {
      cGi();
    }
    AppMethodBeat.o(204627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC
 * JD-Core Version:    0.7.0.1
 */