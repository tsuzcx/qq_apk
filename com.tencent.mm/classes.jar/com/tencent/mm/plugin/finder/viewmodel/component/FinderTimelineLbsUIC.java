package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ad.a;
import com.tencent.mm.plugin.finder.feed.ad.b;
import com.tencent.mm.plugin.finder.feed.ae;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.ag.j;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "autoFlingFlag", "", "getAutoFlingFlag", "()Z", "setAutoFlingFlag", "(Z)V", "hasPermissionWhenPause", "locationVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderGlobalLocationVM;", "presenter1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "presenter2", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "viewCallback1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsViewCallback;", "getLayoutId", "", "onActionbarClick", "", "onActionbarDoubleClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishing", "onPause", "onPermissionOk", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public final class FinderTimelineLbsUIC
  extends UIComponent
{
  public static final a tcX;
  private final FinderGlobalLocationVM shA;
  public ag tcS;
  public ae tcT;
  private aj tcU;
  private boolean tcV;
  private boolean tcW;
  
  static
  {
    AppMethodBeat.i(205687);
    tcX = new a((byte)0);
    AppMethodBeat.o(205687);
  }
  
  public FinderTimelineLbsUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205686);
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    paramMMActivity = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    d.g.b.p.g(paramMMActivity, "UICProvider.of(PluginFin…alLocationVM::class.java)");
    this.shA = ((FinderGlobalLocationVM)paramMMActivity);
    this.tcV = true;
    this.tcW = true;
    AppMethodBeat.o(205686);
  }
  
  private final void cOB()
  {
    AppMethodBeat.i(205685);
    if (this.tcW)
    {
      this.tcW = false;
      Object localObject = this.tcS;
      if (localObject != null) {
        ((ag)localObject).wh(100L);
      }
      localObject = this.tcT;
      if (localObject != null) {
        ((ae)localObject).wh(100L);
      }
      localObject = h.soM;
      h.W((Context)getActivity(), 5);
    }
    AppMethodBeat.o(205685);
  }
  
  public final void cBA()
  {
    AppMethodBeat.i(205679);
    super.cBA();
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    localObject1 = this.tcS;
    Object localObject2;
    if (localObject1 != null)
    {
      c.b(null, (d.g.a.a)new ag.j((ag)localObject1));
      if (((ag)localObject1).rYe)
      {
        localObject2 = h.soM;
        h.W((Context)((ag)localObject1).activity, 1);
      }
    }
    localObject1 = this.tcT;
    if (localObject1 != null)
    {
      if (((ae)localObject1).rYe)
      {
        localObject2 = h.soM;
        h.W((Context)((ae)localObject1).activity, 1);
      }
      localObject1 = g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      com.tencent.mm.plugin.finder.extension.reddot.e.a(((PluginFinder)localObject1).getRedDotManager(), 1003);
    }
    localObject1 = com.tencent.mm.ui.component.a.KiD;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).D((d.g.a.b)b.tcY);
    this.shA.bYc();
    localObject1 = g.ad(PluginFinder.class);
    d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
    localObject1 = ((PluginFinder)localObject1).getRedDotManager();
    if (((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1).Es(2))
    {
      ad.i("Finder.TimelineLbsUIC", "[onUserVisibleFocused] tabType=2 autoFlingToRefresh");
      localObject2 = this.tcS;
      if (localObject2 != null) {
        ((ag)localObject2).wh(0L);
      }
      localObject2 = this.tcT;
      if (localObject2 != null) {
        ((ae)localObject2).wh(0L);
      }
      localObject2 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
      {
        localObject2 = FinderReporterUIC.tcM;
        localObject2 = FinderReporterUIC.a.eY((Context)getActivity());
        if (localObject2 != null)
        {
          h localh = h.soM;
          h.a(((FinderReporterUIC)localObject2).cOu(), 6);
        }
      }
    }
    com.tencent.mm.plugin.finder.extension.reddot.e.a((com.tencent.mm.plugin.finder.extension.reddot.e)localObject1, 1003);
    AppMethodBeat.o(205679);
  }
  
  public final void cKA()
  {
    AppMethodBeat.i(205680);
    super.cKA();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gh(2);
    AppMethodBeat.o(205680);
  }
  
  public final void cKz()
  {
    AppMethodBeat.i(205678);
    Object localObject = this.tcS;
    if (localObject != null) {
      ((ag)localObject).lT(true);
    }
    localObject = this.tcT;
    if (localObject != null)
    {
      ((ae)localObject).lT(true);
      AppMethodBeat.o(205678);
      return;
    }
    AppMethodBeat.o(205678);
  }
  
  public final void cOA()
  {
    AppMethodBeat.i(205681);
    super.cOA();
    Object localObject1 = this.tcS;
    Object localObject2;
    int i;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((ag)localObject1).rXZ;
      if (localObject2 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      i = ag.u(((ad.b)localObject2).getRecyclerView());
      ad.i("Finder.TimelineLbsPresenter", "[onFinishing] position=" + i + " totalDy=" + ((ag)localObject1).rYc);
      localObject2 = ((Iterable)((ag)localObject1).rYC.getDataListJustForAdapter()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (al)((Iterator)localObject2).next();
        if ((localObject3 instanceof BaseFinderFeed)) {
          ((BaseFinderFeed)localObject3).cCH();
        }
      }
      FinderHomeTabStateVM.a(((ag)localObject1).rYa, 2, 0, ((ag)localObject1).rYc, (ArrayList)((ag)localObject1).rYC.getDataListJustForAdapter());
    }
    localObject1 = this.tcT;
    if (localObject1 != null)
    {
      localObject2 = ((ae)localObject1).rXZ;
      if (localObject2 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      i = ae.u(((ad.b)localObject2).getRecyclerView());
      ad.i("Finder.FinderTimelineLbsMixPresenter", "[onFinishing] position=" + i + " totalDy=" + ((ae)localObject1).rYc);
      localObject2 = ((ae)localObject1).rYa;
      int j = ((ae)localObject1).rYc;
      localObject3 = new ArrayList(0);
      localObject1 = ((ae)localObject1).rXY;
      if (localObject1 == null) {
        d.g.b.p.bcb("feedLoader");
      }
      ((FinderHomeTabStateVM)localObject2).a(1000, i, j, (ArrayList)localObject3, (ArrayList)((FinderLbsLoader)localObject1).getDataListJustForAdapter());
      AppMethodBeat.o(205681);
      return;
    }
    AppMethodBeat.o(205681);
  }
  
  public final int getLayoutId()
  {
    return 2131496265;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(205683);
    if ((paramInt1 == 501) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject1 = this.tcS;
      if (localObject1 != null)
      {
        d.g.b.p.h(paramIntent, "data");
        Object localObject2 = ((ag)localObject1).rXZ;
        if (localObject2 == null) {
          d.g.b.p.bcb("viewCallback");
        }
        if (localObject2 != null)
        {
          localObject2 = ((ad.b)localObject2).getRecyclerView();
          if (localObject2 != null)
          {
            com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
            paramIntent = com.tencent.mm.plugin.finder.utils.p.a(paramIntent, (RecyclerView)localObject2, (BaseFinderFeedLoader)((ag)localObject1).rYC, false);
            localObject1 = g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl();
            localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.FS(2);
            if (paramIntent != null)
            {
              paramIntent = paramIntent.lastBuffer;
              if (paramIntent == null) {}
            }
            for (paramIntent = paramIntent.toByteArray();; paramIntent = null)
            {
              ((ai)localObject1).set((al.a)localObject2, bt.cE(paramIntent));
              AppMethodBeat.o(205683);
              return;
            }
          }
        }
        AppMethodBeat.o(205683);
        return;
      }
    }
    AppMethodBeat.o(205683);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205675);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGO().value()).intValue() == 1)
    {
      paramBundle = new ag(getActivity(), (FinderHomeTabFragment)this.fragment);
      this.tcS = paramBundle;
      aj localaj = new aj(getActivity(), (ad.a)paramBundle, getRootView());
      paramBundle.a((ad.b)localaj);
      this.tcU = localaj;
      AppMethodBeat.o(205675);
      return;
    }
    paramBundle = new ae(getActivity(), (FinderHomeTabFragment)this.fragment);
    this.tcT = paramBundle;
    paramBundle.a((ad.b)new af(getActivity(), (ad.a)paramBundle, getRootView()));
    AppMethodBeat.o(205675);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205682);
    super.onDestroy();
    Object localObject = this.tcS;
    if (localObject != null) {
      ((ag)localObject).onDetach();
    }
    localObject = this.tcT;
    if (localObject != null) {
      ((ae)localObject).onDetach();
    }
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ET(2);
    AppMethodBeat.o(205682);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205677);
    super.onPause();
    this.tcV = FinderGlobalLocationVM.cOa();
    AppMethodBeat.o(205677);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(205684);
    d.g.b.p.h(paramArrayOfString, "permissions");
    d.g.b.p.h(paramArrayOfInt, "grantResults");
    if (paramInt == 79)
    {
      if (paramArrayOfInt[0] == 0)
      {
        cOB();
        AppMethodBeat.o(205684);
        return;
      }
      paramArrayOfString = h.soM;
      h.W((Context)getActivity(), 3);
    }
    AppMethodBeat.o(205684);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205676);
    super.onResume();
    if ((!this.tcV) && (FinderGlobalLocationVM.cOa())) {
      cOB();
    }
    com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.EP(2);
    AppMethodBeat.o(205676);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineLbsUIC$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<o, Boolean>
  {
    public static final b tcY;
    
    static
    {
      AppMethodBeat.i(205674);
      tcY = new b();
      AppMethodBeat.o(205674);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineLbsUIC
 * JD-Core Version:    0.7.0.1
 */