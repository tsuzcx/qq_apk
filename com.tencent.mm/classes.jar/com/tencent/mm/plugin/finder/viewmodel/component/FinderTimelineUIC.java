package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.convert.v.a;
import com.tencent.mm.plugin.finder.feed.ac.a;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.p.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "tabType", "", "getTabType", "()I", "tabType$delegate", "Lkotlin/Lazy;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getLayoutId", "getVisibleFeedByUsername", "username", "", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActionbarClick", "isDouble", "", "onAutoToLoadMore", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestInsert", "keepUnreadSize", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUIC
  extends UIComponent
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.finder.api.f
{
  public static final FinderTimelineUIC.a tnW;
  ac.b shU;
  private ac.a siY;
  private final d.f tlN;
  
  static
  {
    AppMethodBeat.i(206351);
    tnW = new FinderTimelineUIC.a((byte)0);
    AppMethodBeat.o(206351);
  }
  
  public FinderTimelineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(206350);
    this.tlN = d.g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(206350);
  }
  
  public FinderTimelineUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206349);
    this.tlN = d.g.O((d.g.a.a)new f(this));
    AppMethodBeat.o(206349);
  }
  
  private final int cDl()
  {
    AppMethodBeat.i(206334);
    int i = ((Number)this.tlN.getValue()).intValue();
    AppMethodBeat.o(206334);
    return i;
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean, aov paramaov)
  {
    int j = 0;
    ac.a locala = null;
    AppMethodBeat.i(206338);
    Object localObject1 = this.shU;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    Object localObject2 = ((ac.b)localObject1).getRecyclerView().getAdapter();
    localObject1 = localObject2;
    if (!(localObject2 instanceof WxRecyclerAdapter)) {
      localObject1 = null;
    }
    localObject1 = (WxRecyclerAdapter)localObject1;
    BaseFinderFeed localBaseFinderFeed;
    LinkedList localLinkedList;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.view.recyclerview.e)d.c((d)localObject1, paramLong);
      if (localObject1 == null) {
        break label558;
      }
      localBaseFinderFeed = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject1).fUY();
      if (localBaseFinderFeed == null) {
        break label558;
      }
      localLinkedList = new LinkedList();
      localObject1 = this.shU;
      if (localObject1 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject2 = ((ac.b)localObject1).getRecyclerView().getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof LinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 == null) {
        break label334;
      }
    }
    long l;
    label334:
    for (int i = ((LinearLayoutManager)localObject1).km();; i = 0)
    {
      if (localObject1 != null) {
        j = ((LinearLayoutManager)localObject1).ko();
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject1 = this.shU;
      if (localObject1 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      l = com.tencent.mm.plugin.finder.utils.p.b(((ac.b)localObject1).getRecyclerView(), i, j, 8).duw;
      if (i > j) {
        break label340;
      }
      for (;;)
      {
        localObject1 = this.shU;
        if (localObject1 == null) {
          d.g.b.p.bdF("viewCallback");
        }
        localObject2 = ((ac.b)localObject1).getRecyclerView().ci(i);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.e)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.e))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.e)localObject1).fUY();
          if ((localObject1 instanceof BaseFinderFeed)) {
            localLinkedList.add(localObject1);
          }
        }
        if (i == j) {
          break;
        }
        i += 1;
      }
      localObject1 = null;
      break;
    }
    label340:
    if (paramLong != l)
    {
      localObject1 = this.shU;
      if (localObject1 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject2 = ((ac.b)localObject1).getRecyclerView().getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        localObject1 = null;
      }
      localObject2 = (WxRecyclerAdapter)localObject1;
      localObject1 = locala;
      if (localObject2 != null)
      {
        localObject2 = (com.tencent.mm.view.recyclerview.e)d.c((d)localObject2, l);
        localObject1 = locala;
        if (localObject2 != null) {
          localObject1 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject2).fUY();
        }
      }
      if (localObject1 != null)
      {
        locala = this.siY;
        if (locala == null) {
          d.g.b.p.bdF("presenter");
        }
        locala.a(localBaseFinderFeed, (BaseFinderFeed)localObject1, paramInt, (List)localLinkedList, paramBoolean, paramaov);
      }
    }
    for (;;)
    {
      localObject1 = MediaPreloadCore.stL;
      if (MediaPreloadCore.cEO()) {
        com.tencent.mm.ac.c.h((d.g.a.a)new FinderTimelineUIC.e(localBaseFinderFeed, this, paramLong, paramInt, paramBoolean, paramaov));
      }
      AppMethodBeat.o(206338);
      return;
      localObject1 = this.siY;
      if (localObject1 == null) {
        d.g.b.p.bdF("presenter");
      }
      ((ac.a)localObject1).a(localBaseFinderFeed, localBaseFinderFeed, paramInt, (List)localLinkedList, paramBoolean, paramaov);
    }
    label558:
    AppMethodBeat.o(206338);
  }
  
  public final void a(ama paramama)
  {
    AppMethodBeat.i(206348);
    d.g.b.p.h(paramama, "cmdItem");
    switch (paramama.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206348);
      return;
      paramama = this.siY;
      if (paramama == null) {
        d.g.b.p.bdF("presenter");
      }
      paramama.cDk();
    }
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(206337);
    if (!fLQ()) {
      h.r(getActivity());
    }
    paramBundle = this.siY;
    if (paramBundle == null) {
      d.g.b.p.bdF("presenter");
    }
    FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = paramBundle.getVideoCore().tam;
    if (localFinderVideoAutoPlayManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramBundle = this.fragment;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getClass();
        if (paramBundle == null) {}
      }
      for (paramBundle = paramBundle.getSimpleName();; paramBundle = null)
      {
        FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, paramBundle + "#onViewFocused", true);
        AppMethodBeat.o(206337);
        return;
      }
    }
    AppMethodBeat.o(206337);
  }
  
  public final void ae(Bundle paramBundle)
  {
    AppMethodBeat.i(206335);
    if (!fLQ()) {
      h.q(getActivity());
    }
    AppMethodBeat.o(206335);
  }
  
  public final void cDm()
  {
    Object localObject2 = null;
    AppMethodBeat.i(206343);
    super.cDm();
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    cDl();
    localObject1 = com.tencent.mm.ui.component.a.KEX;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).E((d.g.a.b)FinderTimelineUIC.d.tnZ);
    localObject1 = this.siY;
    if (localObject1 == null) {
      d.g.b.p.bdF("presenter");
    }
    Object localObject3 = ((ac.a)localObject1).getVideoCore().tam;
    Object localObject4;
    boolean bool1;
    if (localObject3 != null)
    {
      localObject4 = new StringBuilder();
      localObject1 = this.fragment;
      if (localObject1 != null)
      {
        localObject1 = localObject1.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getSimpleName();
          ((FinderVideoAutoPlayManager)localObject3).f((String)localObject1 + "#onViewFocused", false, true);
        }
      }
    }
    else
    {
      localObject1 = this.siY;
      if (localObject1 == null) {
        d.g.b.p.bdF("presenter");
      }
      ((ac.a)localObject1).cDm();
      localObject1 = this.siY;
      if (localObject1 == null) {
        d.g.b.p.bdF("presenter");
      }
      localObject1 = ((ac.a)localObject1).getActivity();
      if (localObject1 == null) {
        break label570;
      }
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null) {
        break label570;
      }
      bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
      label235:
      localObject1 = this.siY;
      if (localObject1 == null) {
        d.g.b.p.bdF("presenter");
      }
      localObject1 = ((ac.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
      }
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      boolean bool2 = ((PluginFinder)localObject1).getRedDotManager().EF(cDl());
      if ((bool1) && (cDl() == 3)) {
        break label575;
      }
      localObject1 = this.siY;
      if (localObject1 == null) {
        d.g.b.p.bdF("presenter");
      }
      ((ac.a)localObject1).N(false, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if ((((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1) && (bool2))
      {
        localObject1 = FinderReporterUIC.tnG;
        localObject1 = FinderReporterUIC.a.fc((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
          com.tencent.mm.plugin.finder.report.i.a(((FinderReporterUIC)localObject1).cQZ(), 6);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.ui.component.a.KEX;
      localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderReporterUIC.class)).GQ(cDl());
      if (localObject1 == null) {
        break label727;
      }
      cDl();
      localObject2 = new com.tencent.mm.plugin.finder.event.base.k();
      localObject3 = this.shU;
      if (localObject3 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject3 = ((ac.b)localObject3).getRecyclerView();
      localObject4 = ((RecyclerView)localObject3).getLayoutManager();
      if ((localObject4 instanceof LinearLayoutManager))
      {
        int i = ((LinearLayoutManager)localObject4).km();
        int j = ((LinearLayoutManager)localObject4).ko();
        localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
        ((com.tencent.mm.plugin.finder.event.base.k)localObject2).rZP = com.tencent.mm.plugin.finder.utils.p.b((RecyclerView)localObject3, i, j, 8).rZB;
      }
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.b)localObject2);
      AppMethodBeat.o(206343);
      return;
      localObject1 = null;
      break;
      label570:
      bool1 = false;
      break label235;
      label575:
      if ((bool1) && (cDl() == 3))
      {
        localObject1 = this.siY;
        if (localObject1 == null) {
          d.g.b.p.bdF("presenter");
        }
        localObject3 = ((ac.a)localObject1).getVideoCore().tam;
        if (localObject3 != null)
        {
          localObject4 = new StringBuilder();
          Object localObject5 = this.fragment;
          localObject1 = localObject2;
          if (localObject5 != null)
          {
            localObject5 = localObject5.getClass();
            localObject1 = localObject2;
            if (localObject5 != null) {
              localObject1 = ((Class)localObject5).getSimpleName();
            }
          }
          ((FinderVideoAutoPlayManager)localObject3).f((String)localObject1 + "#onAttach", false, true);
        }
        localObject1 = this.siY;
        if (localObject1 == null) {
          d.g.b.p.bdF("presenter");
        }
        ((ac.a)localObject1).N(true, false);
        ae.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
      }
    }
    label727:
    AppMethodBeat.o(206343);
  }
  
  public final void cNe()
  {
    AppMethodBeat.i(206344);
    super.cNe();
    Object localObject = com.tencent.mm.ui.component.a.KEX;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GG(cDl());
    localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.Fq(cDl());
    localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.al(cDl(), true);
    localObject = com.tencent.mm.plugin.finder.report.e.sxO;
    com.tencent.mm.plugin.finder.report.e.cFk();
    AppMethodBeat.o(206344);
  }
  
  public final void cQQ()
  {
    AppMethodBeat.i(206339);
    Object localObject1 = this.shU;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    localObject1 = ((ac.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(206339);
      throw ((Throwable)localObject1);
    }
    int i = ((LinearLayoutManager)localObject1).km();
    localObject1 = this.shU;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    Object localObject2 = ((ac.b)localObject1).getRecyclerView().getLayoutManager();
    localObject1 = localObject2;
    if (!(localObject2 instanceof LinearLayoutManager)) {
      localObject1 = null;
    }
    localObject1 = (LinearLayoutManager)localObject1;
    if (localObject1 != null) {
      ((LinearLayoutManager)localObject1).ag(0, 0);
    }
    if (i < 0)
    {
      localObject2 = this.shU;
      if (localObject2 == null) {
        d.g.b.p.bdF("viewCallback");
      }
      ((ac.b)localObject2).getRecyclerView().post((Runnable)new b((LinearLayoutManager)localObject1));
    }
    localObject1 = this.shU;
    if (localObject1 == null) {
      d.g.b.p.bdF("viewCallback");
    }
    ((ac.b)localObject1).cDo();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIR().value()).intValue() == 1)
    {
      localObject1 = FinderReporterUIC.tnG;
      localObject1 = FinderReporterUIC.a.fc((Context)getActivity());
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.i.syT;
        com.tencent.mm.plugin.finder.report.i.a(((FinderReporterUIC)localObject1).cQZ(), 5, cDl());
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.convert.v.rXd;
    ac.b localb = this.shU;
    if (localb == null) {
      d.g.b.p.bdF("viewCallback");
    }
    localObject2 = this.fragment;
    localObject1 = localObject2;
    if (!(localObject2 instanceof FinderHomeTabFragment)) {
      localObject1 = null;
    }
    localObject1 = (FinderHomeTabFragment)localObject1;
    if (localObject1 != null) {}
    for (i = ((FinderHomeTabFragment)localObject1).dvm;; i = 0)
    {
      v.a.a(localb, i);
      AppMethodBeat.o(206339);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494117;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206341);
    if (fLQ())
    {
      locala = this.siY;
      if (locala == null) {
        d.g.b.p.bdF("presenter");
      }
      boolean bool = locala.onBackPressed();
      AppMethodBeat.o(206341);
      return bool;
    }
    ac.a locala = this.siY;
    if (locala == null) {
      d.g.b.p.bdF("presenter");
    }
    if (!locala.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(206341);
      return true;
    }
    AppMethodBeat.o(206341);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206336);
    paramBundle = x.rRf;
    x.czA();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.sTP;
    com.tencent.mm.plugin.finder.upload.b.cNg().cNf();
    MMActivity localMMActivity = getActivity();
    Object localObject = this.fragment;
    paramBundle = (Bundle)localObject;
    if (!(localObject instanceof FinderHomeTabFragment)) {
      paramBundle = null;
    }
    this.siY = ((ac.a)new an(localMMActivity, (FinderHomeTabFragment)paramBundle));
    paramBundle = getActivity();
    localObject = this.siY;
    if (localObject == null) {
      d.g.b.p.bdF("presenter");
    }
    this.shU = ((ac.b)new ao(paramBundle, (ac.a)localObject, getRootView()));
    paramBundle = this.siY;
    if (paramBundle == null) {
      d.g.b.p.bdF("presenter");
    }
    localObject = this.shU;
    if (localObject == null) {
      d.g.b.p.bdF("viewCallback");
    }
    paramBundle.dc(localObject);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.sUx;
    com.tencent.mm.plugin.finder.upload.g.cNo().cNn();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.f)this);
    AppMethodBeat.o(206336);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206347);
    ae.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.f)this);
    Object localObject = this.siY;
    if (localObject == null) {
      d.g.b.p.bdF("presenter");
    }
    ((ac.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.k.ssU;
    com.tencent.mm.plugin.finder.model.k.release();
    com.tencent.mm.ac.c.b(null, (d.g.a.a)c.tnY);
    localObject = this.shU;
    if (localObject == null) {
      d.g.b.p.bdF("viewCallback");
    }
    ((ac.b)localObject).getRecyclerView().setAdapter(null);
    localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.Fp(cDl());
    localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.cFp();
    AppMethodBeat.o(206347);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206345);
    super.onPause();
    Object localObject = this.siY;
    if (localObject == null) {
      d.g.b.p.bdF("presenter");
    }
    ((ac.a)localObject).onUIPause();
    localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.cFp();
    AppMethodBeat.o(206345);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206342);
    super.onResume();
    Object localObject = this.siY;
    if (localObject == null) {
      d.g.b.p.bdF("presenter");
    }
    ((ac.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.sUx;
    if (com.tencent.mm.plugin.finder.upload.g.cNp())
    {
      ae.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject = this.shU;
      if (localObject == null) {
        d.g.b.p.bdF("viewCallback");
      }
      localObject = ((ac.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.g.sUx;
      com.tencent.mm.plugin.finder.upload.g.mj(false);
    }
    localObject = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.Fl(cDl());
    AppMethodBeat.o(206342);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(206340);
    ae.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(206340);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(206346);
    super.onStop();
    if (getActivity().isFinishing())
    {
      localf = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fp(cDl());
      AppMethodBeat.o(206346);
      return;
    }
    com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.syc;
    com.tencent.mm.plugin.finder.report.f.Fn(cDl());
    AppMethodBeat.o(206346);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(LinearLayoutManager paramLinearLayoutManager) {}
    
    public final void run()
    {
      AppMethodBeat.i(206327);
      LinearLayoutManager localLinearLayoutManager = this.six;
      if (localLinearLayoutManager != null)
      {
        if (this.tnX) {}
        for (int i = 0;; i = 1)
        {
          localLinearLayoutManager.ag(i, 0);
          AppMethodBeat.o(206327);
          return;
        }
      }
      AppMethodBeat.o(206327);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    public static final c tnY;
    
    static
    {
      AppMethodBeat.i(206329);
      tnY = new c();
      AppMethodBeat.o(206329);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Integer>
  {
    f(FinderTimelineUIC paramFinderTimelineUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC
 * JD-Core Version:    0.7.0.1
 */