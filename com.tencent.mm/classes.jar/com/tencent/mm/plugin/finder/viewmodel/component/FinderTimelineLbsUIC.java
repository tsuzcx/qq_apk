package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.feed.aj.a;
import com.tencent.mm.plugin.finder.feed.aj.b;
import com.tencent.mm.plugin.finder.feed.ak;
import com.tencent.mm.plugin.finder.feed.al;
import com.tencent.mm.plugin.finder.feed.am;
import com.tencent.mm.plugin.finder.feed.am.j;
import com.tencent.mm.plugin.finder.feed.am.k;
import com.tencent.mm.plugin.finder.feed.ap;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinished", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineLbsUIC
  extends UIComponent
{
  public static final a wAF;
  private boolean uTD;
  private boolean uTE;
  private final FinderGlobalLocationVM udf;
  public am wAC;
  public ak wAD;
  private ap wAE;
  
  static
  {
    AppMethodBeat.i(255995);
    wAF = new a((byte)0);
    AppMethodBeat.o(255995);
  }
  
  public FinderTimelineLbsUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255994);
    paramAppCompatActivity = com.tencent.mm.ui.component.a.PRN;
    paramAppCompatActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    p.g(paramAppCompatActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.udf = ((FinderGlobalLocationVM)paramAppCompatActivity);
    this.uTD = true;
    this.uTE = true;
    AppMethodBeat.o(255994);
  }
  
  private final void dlD()
  {
    AppMethodBeat.i(255993);
    if (this.uTE)
    {
      this.uTE = false;
      Object localObject = this.wAC;
      if (localObject != null) {
        ((am)localObject).ED(100L);
      }
      localObject = this.wAD;
      if (localObject != null) {
        ((ak)localObject).ED(100L);
      }
      localObject = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.ac((Context)getActivity(), 5);
    }
    AppMethodBeat.o(255993);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(255986);
    Object localObject = this.wAC;
    if (localObject != null) {
      ((am)localObject).onActionbarClick(true);
    }
    localObject = this.wAD;
    if (localObject != null)
    {
      ((ak)localObject).onActionbarClick(true);
      AppMethodBeat.o(255986);
      return;
    }
    AppMethodBeat.o(255986);
  }
  
  public final int getLayoutId()
  {
    return 2131494653;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(255991);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject1 = this.wAC;
      if (localObject1 != null)
      {
        p.h(paramIntent, "data");
        Object localObject2 = ((am)localObject1).tQZ;
        if (localObject2 == null) {
          p.btv("viewCallback");
        }
        if (localObject2 != null)
        {
          localObject2 = ((aj.b)localObject2).getRecyclerView();
          if (localObject2 != null)
          {
            y localy = y.vXH;
            paramIntent = y.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)((am)localObject1).tRo, false, (kotlin.g.a.b)am.k.tRA);
            localObject1 = g.aAh();
            p.g(localObject1, "MMKernel.storage()");
            localObject1 = ((e)localObject1).azQ();
            localObject2 = y.vXH;
            localObject2 = y.LK(2);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.lastBuffer;
              if (paramIntent == null) {}
            }
            for (paramIntent = paramIntent.toByteArray();; paramIntent = null)
            {
              ((ao)localObject1).set((ar.a)localObject2, Util.encodeHexString(paramIntent));
              AppMethodBeat.o(255991);
              return;
            }
          }
        }
        AppMethodBeat.o(255991);
        return;
      }
    }
    AppMethodBeat.o(255991);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255983);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dst().value()).intValue() == 1)
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255983);
        throw paramBundle;
      }
      paramBundle = new am((MMActivity)paramBundle, (FinderHomeTabFragment)getFragment());
      this.wAC = paramBundle;
      localObject = getActivity();
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255983);
        throw paramBundle;
      }
      localObject = new ap((MMActivity)localObject, (aj.a)paramBundle, getRootView());
      paramBundle.a((aj.b)localObject);
      this.wAE = ((ap)localObject);
      AppMethodBeat.o(255983);
      return;
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255983);
      throw paramBundle;
    }
    paramBundle = new ak((MMActivity)paramBundle, (FinderHomeTabFragment)getFragment());
    this.wAD = paramBundle;
    Object localObject = getActivity();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255983);
      throw paramBundle;
    }
    paramBundle.a((aj.b)new al((MMActivity)localObject, (aj.a)paramBundle, getRootView()));
    AppMethodBeat.o(255983);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255990);
    super.onDestroy();
    Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.voz, s.j.vnV.scene, com.tencent.mm.plugin.finder.report.live.c.vjl);
    localObject = this.wAC;
    if (localObject != null) {
      ((am)localObject).onDetach();
    }
    localObject = this.wAD;
    if (localObject != null) {
      ((ak)localObject).onDetach();
    }
    localObject = com.tencent.mm.plugin.finder.report.h.veu;
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)getActivity());
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.h.e(2, (bbn)localObject);
      AppMethodBeat.o(255990);
      return;
    }
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(255989);
    super.onFinished();
    Object localObject1 = this.wAC;
    if (localObject1 != null)
    {
      localObject2 = ((am)localObject1).tQZ;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      localObject2 = ((aj.b)localObject2).getRecyclerView();
      if (localObject2 != null) {
        break label95;
      }
    }
    for (;;)
    {
      localObject1 = this.wAD;
      if (localObject1 == null) {
        break label325;
      }
      localObject2 = ((ak)localObject1).tQZ;
      if (localObject2 == null) {
        p.btv("viewCallback");
      }
      localObject2 = ((aj.b)localObject2).getRecyclerView();
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(255989);
      return;
      label95:
      i = am.findFirstPosition((RecyclerView)localObject2);
      Log.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((am)localObject1).totalDy);
      localObject2 = ((Iterable)((am)localObject1).tRo.getDataListJustForAdapter()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bo)((Iterator)localObject2).next();
        if ((localObject3 instanceof BaseFinderFeed)) {
          ((BaseFinderFeed)localObject3).dku();
        }
      }
      FinderHomeTabStateVM.a(((am)localObject1).tlCache, 2, 0, ((am)localObject1).totalDy, (ArrayList)((am)localObject1).tRo.getDataListJustForAdapter());
    }
    int i = ak.findFirstPosition((RecyclerView)localObject2);
    Log.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((ak)localObject1).totalDy);
    Object localObject2 = ((ak)localObject1).tlCache;
    int j = ((ak)localObject1).totalDy;
    Object localObject3 = new ArrayList(0);
    localObject1 = ((ak)localObject1).tQY;
    if (localObject1 == null) {
      p.btv("feedLoader");
    }
    ((FinderHomeTabStateVM)localObject2).a(1000, i, j, (ArrayList)localObject3, (ArrayList)((FinderLbsLoader)localObject1).getDataListJustForAdapter());
    AppMethodBeat.o(255989);
    return;
    label325:
    AppMethodBeat.o(255989);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255985);
    super.onPause();
    this.uTD = FinderGlobalLocationVM.dHO();
    Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    localObject = this.wAE;
    if (localObject != null) {}
    for (localObject = ((ap)localObject).getRecyclerView();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.live.k.b((RecyclerView)localObject, s.p.voz, s.j.vnV.scene, com.tencent.mm.plugin.finder.report.live.c.vjg);
      AppMethodBeat.o(255985);
      return;
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(255992);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        dlD();
        AppMethodBeat.o(255992);
        return;
      }
      paramArrayOfString = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.ac((Context)getActivity(), 3);
    }
    AppMethodBeat.o(255992);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255984);
    super.onResume();
    if ((!this.uTD) && (FinderGlobalLocationVM.dHO())) {
      dlD();
    }
    Object localObject = com.tencent.mm.plugin.finder.report.h.veu;
    com.tencent.mm.plugin.finder.report.h.Km(2);
    localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    localObject = this.wAE;
    if (localObject != null) {}
    for (localObject = ((ap)localObject).getRecyclerView();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.live.k.b((RecyclerView)localObject, s.p.voz, s.j.vnV.scene, com.tencent.mm.plugin.finder.report.live.c.vjf);
      AppMethodBeat.o(255984);
      return;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(255987);
    super.onUserVisibleFocused();
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    localObject = this.wAC;
    com.tencent.mm.plugin.finder.report.k localk;
    if (localObject != null)
    {
      d.i((kotlin.g.a.a)new am.j((am)localObject));
      if (((am)localObject).isEmptyLocation)
      {
        localk = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.ac((Context)((am)localObject).activity, 1);
      }
    }
    localObject = this.wAD;
    if (localObject != null)
    {
      if (((ak)localObject).isEmptyLocation)
      {
        localk = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.ac((Context)((ak)localObject).activity, 1);
      }
      localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().asV("finder_tl_nearby_tab");
      localObject = g.ah(PluginFinder.class);
      p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().gI("finder_tl_nearby_tab", "onRefreshEnd");
    }
    localObject = com.tencent.mm.ui.component.a.PRN;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).J((kotlin.g.a.b)FinderTimelineLbsUIC.b.wAG);
    this.udf.cxh();
    localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    if (((PluginFinder)localObject).getRedDotManager().Iz(2))
    {
      Log.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject = this.wAC;
      if (localObject != null) {
        ((am)localObject).ED(0L);
      }
      localObject = this.wAD;
      if (localObject != null) {
        ((ak)localObject).ED(0L);
      }
      localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsx().value()).intValue() == 1)
      {
        localObject = FinderReporterUIC.wzC;
        localObject = FinderReporterUIC.a.fH((Context)getActivity());
        if (localObject != null)
        {
          localk = com.tencent.mm.plugin.finder.report.k.vfA;
          com.tencent.mm.plugin.finder.report.k.a(((FinderReporterUIC)localObject).dIx(), 6);
        }
      }
    }
    localObject = g.ah(PluginFinder.class);
    p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    ((PluginFinder)localObject).getRedDotManager().asV("finder_tl_nearby_tab");
    AppMethodBeat.o(255987);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(255988);
    super.onUserVisibleUnFocused();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(2);
    AppMethodBeat.o(255988);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC
 * JD-Core Version:    0.7.0.1
 */