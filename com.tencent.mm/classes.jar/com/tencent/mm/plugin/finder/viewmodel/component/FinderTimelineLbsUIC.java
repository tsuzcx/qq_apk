package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ad.a;
import com.tencent.mm.plugin.finder.feed.ad.b;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.ag.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineLbsUIC
  extends UIComponent
{
  public static final FinderTimelineLbsUIC.a tnR;
  private final FinderGlobalLocationVM sqv;
  public ag tnM;
  public com.tencent.mm.plugin.finder.feed.ae tnN;
  private com.tencent.mm.plugin.finder.feed.aj tnO;
  private boolean tnP;
  private boolean tnQ;
  
  static
  {
    AppMethodBeat.i(206316);
    tnR = new FinderTimelineLbsUIC.a((byte)0);
    AppMethodBeat.o(206316);
  }
  
  public FinderTimelineLbsUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206315);
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    d.g.b.p.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.sqv = ((FinderGlobalLocationVM)paramMMActivity);
    this.tnP = true;
    this.tnQ = true;
    AppMethodBeat.o(206315);
  }
  
  private final void cRg()
  {
    AppMethodBeat.i(206314);
    if (this.tnQ)
    {
      this.tnQ = false;
      Object localObject = this.tnM;
      if (localObject != null) {
        ((ag)localObject).wx(100L);
      }
      localObject = this.tnN;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.ae)localObject).wx(100L);
      }
      localObject = i.syT;
      i.W((Context)getActivity(), 5);
    }
    AppMethodBeat.o(206314);
  }
  
  public final void cDm()
  {
    AppMethodBeat.i(206308);
    super.cDm();
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    localObject1 = this.tnM;
    Object localObject2;
    if (localObject1 != null)
    {
      c.b(null, (d.g.a.a)new ag.j((ag)localObject1));
      if (((ag)localObject1).sgQ)
      {
        localObject2 = i.syT;
        i.W((Context)((ag)localObject1).activity, 1);
      }
    }
    localObject1 = this.tnN;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.plugin.finder.feed.ae)localObject1).sgQ)
      {
        localObject2 = i.syT;
        i.W((Context)((com.tencent.mm.plugin.finder.feed.ae)localObject1).activity, 1);
      }
      localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.e.a(((PluginFinder)localObject1).getRedDotManager(), 1003);
    }
    localObject1 = com.tencent.mm.ui.component.a.KEX;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).E((d.g.a.b)FinderTimelineLbsUIC.b.tnS);
    this.sqv.bZr();
    localObject1 = g.ad(PluginFinder.class);
    d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    if (((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).EF(2))
    {
      com.tencent.mm.sdk.platformtools.ae.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject2 = this.tnM;
      if (localObject2 != null) {
        ((ag)localObject2).wx(0L);
      }
      localObject2 = this.tnN;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.feed.ae)localObject2).wx(0L);
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
      {
        localObject2 = FinderReporterUIC.tnG;
        localObject2 = FinderReporterUIC.a.fc((Context)getActivity());
        if (localObject2 != null)
        {
          i locali = i.syT;
          i.a(((FinderReporterUIC)localObject2).cQZ(), 6);
        }
      }
    }
    com.tencent.mm.plugin.finder.extension.reddot.e.a((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1, 1003);
    AppMethodBeat.o(206308);
  }
  
  public final void cNd()
  {
    AppMethodBeat.i(206307);
    Object localObject = this.tnM;
    if (localObject != null) {
      ((ag)localObject).lT(true);
    }
    localObject = this.tnN;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.feed.ae)localObject).lT(true);
      AppMethodBeat.o(206307);
      return;
    }
    AppMethodBeat.o(206307);
  }
  
  public final void cNe()
  {
    AppMethodBeat.i(206309);
    super.cNe();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GG(2);
    AppMethodBeat.o(206309);
  }
  
  public final void cRf()
  {
    AppMethodBeat.i(206310);
    super.cRf();
    Object localObject1 = this.tnM;
    Object localObject2;
    int i;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((ag)localObject1).sgL;
      if (localObject2 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      i = ag.u(((ad.b)localObject2).getRecyclerView());
      com.tencent.mm.sdk.platformtools.ae.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((ag)localObject1).sgO);
      localObject2 = ((Iterable)((ag)localObject1).sho.getDataListJustForAdapter()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (am)((Iterator)localObject2).next();
        if ((localObject3 instanceof BaseFinderFeed)) {
          ((BaseFinderFeed)localObject3).cEu();
        }
      }
      FinderHomeTabStateVM.a(((ag)localObject1).sgM, 2, 0, ((ag)localObject1).sgO, (ArrayList)((ag)localObject1).sho.getDataListJustForAdapter());
    }
    localObject1 = this.tnN;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.feed.ae)localObject1).sgL;
      if (localObject2 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      i = com.tencent.mm.plugin.finder.feed.ae.u(((ad.b)localObject2).getRecyclerView());
      com.tencent.mm.sdk.platformtools.ae.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((com.tencent.mm.plugin.finder.feed.ae)localObject1).sgO);
      localObject2 = ((com.tencent.mm.plugin.finder.feed.ae)localObject1).sgM;
      int j = ((com.tencent.mm.plugin.finder.feed.ae)localObject1).sgO;
      localObject3 = new ArrayList(0);
      localObject1 = ((com.tencent.mm.plugin.finder.feed.ae)localObject1).sgK;
      if (localObject1 == null) {
        d.g.b.p.bdF("feedLoader");
      }
      ((FinderHomeTabStateVM)localObject2).a(1000, i, j, (ArrayList)localObject3, (ArrayList)((FinderLbsLoader)localObject1).getDataListJustForAdapter());
      AppMethodBeat.o(206310);
      return;
    }
    AppMethodBeat.o(206310);
  }
  
  public final int getLayoutId()
  {
    return 2131496265;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206312);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject1 = this.tnM;
      if (localObject1 != null)
      {
        d.g.b.p.h(paramIntent, "data");
        Object localObject2 = ((ag)localObject1).sgL;
        if (localObject2 == null) {
          d.g.b.p.bdF("viewCallback");
        }
        if (localObject2 != null)
        {
          localObject2 = ((ad.b)localObject2).getRecyclerView();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
            paramIntent = com.tencent.mm.plugin.finder.utils.p.a(paramIntent, (RecyclerView)localObject2, (BaseFinderFeedLoader)((ag)localObject1).sho, false);
            localObject1 = g.ajR();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA();
            localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.Gr(2);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.lastBuffer;
              if (paramIntent == null) {}
            }
            for (paramIntent = paramIntent.toByteArray();; paramIntent = null)
            {
              ((com.tencent.mm.storage.aj)localObject1).set((am.a)localObject2, bu.cH(paramIntent));
              AppMethodBeat.o(206312);
              return;
            }
          }
        }
        AppMethodBeat.o(206312);
        return;
      }
    }
    AppMethodBeat.o(206312);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206304);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIN().value()).intValue() == 1)
    {
      paramBundle = new ag(getActivity(), (FinderHomeTabFragment)this.fragment);
      this.tnM = paramBundle;
      com.tencent.mm.plugin.finder.feed.aj localaj = new com.tencent.mm.plugin.finder.feed.aj(getActivity(), (ad.a)paramBundle, getRootView());
      paramBundle.a((ad.b)localaj);
      this.tnO = localaj;
      AppMethodBeat.o(206304);
      return;
    }
    paramBundle = new com.tencent.mm.plugin.finder.feed.ae(getActivity(), (FinderHomeTabFragment)this.fragment);
    this.tnN = paramBundle;
    paramBundle.a((ad.b)new af(getActivity(), (ad.a)paramBundle, getRootView()));
    AppMethodBeat.o(206304);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206311);
    super.onDestroy();
    Object localObject = this.tnM;
    if (localObject != null) {
      ((ag)localObject).onDetach();
    }
    localObject = this.tnN;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.feed.ae)localObject).onDetach();
    }
    localObject = f.syc;
    f.Fp(2);
    AppMethodBeat.o(206311);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206306);
    super.onPause();
    this.tnP = FinderGlobalLocationVM.cQK();
    AppMethodBeat.o(206306);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206313);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        cRg();
        AppMethodBeat.o(206313);
        return;
      }
      paramArrayOfString = i.syT;
      i.W((Context)getActivity(), 3);
    }
    AppMethodBeat.o(206313);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206305);
    super.onResume();
    if ((!this.tnP) && (FinderGlobalLocationVM.cQK())) {
      cRg();
    }
    f localf = f.syc;
    f.Fl(2);
    AppMethodBeat.o(206305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC
 * JD-Core Version:    0.7.0.1
 */