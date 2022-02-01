package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.convert.v.a;
import com.tencent.mm.plugin.finder.extension.reddot.g.a;
import com.tencent.mm.plugin.finder.feed.ac.a;
import com.tencent.mm.plugin.finder.feed.ac.b;
import com.tencent.mm.plugin.finder.feed.an;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.j;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.y;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.p.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "tabType", "getTabType", "()I", "tabType$delegate", "Lkotlin/Lazy;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "doClickPostAction", "doPrepareUser", "showPostRed", "", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getLayoutId", "getVisibleFeedByUsername", "username", "", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActionbarClick", "isDouble", "onAutoToLoadMore", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestInsert", "keepUnreadSize", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUIC
  extends UIComponent
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.finder.api.f
{
  public static final a tdc;
  private ProgressDialog jjb;
  ac.b rZi;
  private ac.a saj;
  private final int sgy;
  private asp shx;
  private final int shy;
  private final int shz;
  private final d.f taY;
  
  static
  {
    AppMethodBeat.i(205735);
    tdc = new a((byte)0);
    AppMethodBeat.o(205735);
  }
  
  public FinderTimelineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(205734);
    this.shy = 1;
    this.sgy = 2;
    this.shz = 3;
    this.taY = d.g.O((d.g.a.a)new o(this));
    AppMethodBeat.o(205734);
  }
  
  public FinderTimelineUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205733);
    this.shy = 1;
    this.sgy = 2;
    this.shz = 3;
    this.taY = d.g.O((d.g.a.a)new o(this));
    AppMethodBeat.o(205733);
  }
  
  private final int cBz()
  {
    AppMethodBeat.i(205717);
    int i = ((Number)this.taY.getValue()).intValue();
    AppMethodBeat.o(205717);
    return i;
  }
  
  private final void cCv()
  {
    AppMethodBeat.i(205724);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.suA;
    if (com.tencent.mm.plugin.finder.spam.a.aip("post"))
    {
      AppMethodBeat.o(205724);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.sKD;
    if (com.tencent.mm.plugin.finder.utils.a.eO((Context)getActivity()))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.ai(1, true);
      AppMethodBeat.o(205724);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.f.soC;
    com.tencent.mm.plugin.finder.report.f.ai(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getActivity(), 1, true);
    View localView = com.tencent.mm.ui.z.jO((Context)getActivity()).inflate(2131494113, null);
    Object localObject2 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject3 = com.tencent.mm.plugin.finder.api.c.rHn;
    localObject3 = u.aAu();
    d.g.b.p.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
    localObject3 = c.a.agW((String)localObject3);
    if (localObject3 != null)
    {
      d.g.b.p.g(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.g)localObject3).VC()));
      localObject2 = com.tencent.mm.plugin.finder.loader.i.sja;
      localObject2 = com.tencent.mm.plugin.finder.loader.i.cCC();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.g)localObject3).field_avatarUrl);
      d.g.b.p.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.sja;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.sjd));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).K(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)e.tde);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.e)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)g.tdf);
    ((com.tencent.mm.ui.widget.a.e)localObject1).cMW();
    AppMethodBeat.o(205724);
  }
  
  public final void a(final long paramLong, int paramInt, final boolean paramBoolean, final aoi paramaoi)
  {
    int j = 0;
    ac.a locala = null;
    AppMethodBeat.i(205721);
    Object localObject1 = this.rZi;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
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
      localObject1 = (com.tencent.mm.view.recyclerview.e)com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject1, paramLong);
      if (localObject1 == null) {
        break label567;
      }
      localBaseFinderFeed = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject1).fQC();
      if (localBaseFinderFeed == null) {
        break label567;
      }
      localLinkedList = new LinkedList();
      localObject1 = this.rZi;
      if (localObject1 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localObject2 = ((ac.b)localObject1).getRecyclerView().getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof LinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 == null) {
        break label339;
      }
    }
    long l;
    label339:
    for (int i = ((LinearLayoutManager)localObject1).km();; i = 0)
    {
      if (localObject1 != null) {
        j = ((LinearLayoutManager)localObject1).ko();
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject1 = this.rZi;
      if (localObject1 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      l = com.tencent.mm.plugin.finder.utils.p.b(((ac.b)localObject1).getRecyclerView(), i, j, 8).dtq;
      if (i > j) {
        break label345;
      }
      for (;;)
      {
        localObject1 = this.rZi;
        if (localObject1 == null) {
          d.g.b.p.bcb("viewCallback");
        }
        localObject2 = ((ac.b)localObject1).getRecyclerView().ci(i);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.e)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.e))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.e)localObject1).fQC();
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
    label345:
    if (paramLong != l)
    {
      localObject1 = this.rZi;
      if (localObject1 == null) {
        d.g.b.p.bcb("viewCallback");
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
        localObject2 = (com.tencent.mm.view.recyclerview.e)com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, l);
        localObject1 = locala;
        if (localObject2 != null) {
          localObject1 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject2).fQC();
        }
      }
      if (localObject1 != null)
      {
        locala = this.saj;
        if (locala == null) {
          d.g.b.p.bcb("presenter");
        }
        locala.a(localBaseFinderFeed, (BaseFinderFeed)localObject1, paramInt, (List)localLinkedList, paramBoolean, paramaoi);
      }
    }
    for (;;)
    {
      localObject1 = MediaPreloadCore.skO;
      if (MediaPreloadCore.cDb()) {
        com.tencent.mm.ad.c.g((d.g.a.a)new n(localBaseFinderFeed, this, paramLong, paramInt, paramBoolean, paramaoi));
      }
      AppMethodBeat.o(205721);
      return;
      localObject1 = this.saj;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
      }
      ((ac.a)localObject1).a(localBaseFinderFeed, localBaseFinderFeed, paramInt, (List)localLinkedList, paramBoolean, paramaoi);
    }
    label567:
    AppMethodBeat.o(205721);
  }
  
  public final void a(alo paramalo)
  {
    AppMethodBeat.i(205732);
    d.g.b.p.h(paramalo, "cmdItem");
    switch (paramalo.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205732);
      return;
      paramalo = this.saj;
      if (paramalo == null) {
        d.g.b.p.bcb("presenter");
      }
      paramalo.cBy();
    }
  }
  
  public final void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(205720);
    if (!fHy()) {
      com.tencent.mm.pluginsdk.h.r(getActivity());
    }
    paramBundle = this.saj;
    if (paramBundle == null) {
      d.g.b.p.bcb("presenter");
    }
    FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = paramBundle.getVideoCore().sOZ;
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
        AppMethodBeat.o(205720);
        return;
      }
    }
    AppMethodBeat.o(205720);
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(205718);
    if (!fHy()) {
      com.tencent.mm.pluginsdk.h.q(getActivity());
    }
    AppMethodBeat.o(205718);
  }
  
  public final void cBA()
  {
    Object localObject2 = null;
    AppMethodBeat.i(205727);
    super.cBA();
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
    cBz();
    localObject1 = com.tencent.mm.ui.component.a.KiD;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).D((d.g.a.b)m.tdi);
    localObject1 = this.saj;
    if (localObject1 == null) {
      d.g.b.p.bcb("presenter");
    }
    Object localObject3 = ((ac.a)localObject1).getVideoCore().sOZ;
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
      localObject1 = this.saj;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
      }
      ((ac.a)localObject1).cBA();
      localObject1 = this.saj;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
      }
      localObject1 = ((ac.a)localObject1).getActivity();
      if (localObject1 == null) {
        break label576;
      }
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null) {
        break label576;
      }
      bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
      label238:
      localObject1 = this.saj;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
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
      boolean bool2 = ((PluginFinder)localObject1).getRedDotManager().Es(cBz());
      if ((bool1) && (cBz() == 3)) {
        break label581;
      }
      localObject1 = this.saj;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
      }
      ((ac.a)localObject1).O(false, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1) && (bool2))
      {
        localObject1 = FinderReporterUIC.tcM;
        localObject1 = FinderReporterUIC.a.eY((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
          com.tencent.mm.plugin.finder.report.h.a(((FinderReporterUIC)localObject1).cOu(), 6);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.ui.component.a.KiD;
      localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderReporterUIC.class)).Gt(cBz());
      if (localObject1 == null) {
        break label735;
      }
      cBz();
      localObject2 = new com.tencent.mm.plugin.finder.event.base.k();
      localObject3 = this.rZi;
      if (localObject3 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localObject3 = ((ac.b)localObject3).getRecyclerView();
      localObject4 = ((RecyclerView)localObject3).getLayoutManager();
      if ((localObject4 instanceof LinearLayoutManager))
      {
        int i = ((LinearLayoutManager)localObject4).km();
        int j = ((LinearLayoutManager)localObject4).ko();
        localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
        ((com.tencent.mm.plugin.finder.event.base.k)localObject2).rRn = com.tencent.mm.plugin.finder.utils.p.b((RecyclerView)localObject3, i, j, 8).rQZ;
      }
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.b)localObject2);
      AppMethodBeat.o(205727);
      return;
      localObject1 = null;
      break;
      label576:
      bool1 = false;
      break label238;
      label581:
      if ((bool1) && (cBz() == 3))
      {
        localObject1 = this.saj;
        if (localObject1 == null) {
          d.g.b.p.bcb("presenter");
        }
        localObject3 = ((ac.a)localObject1).getVideoCore().sOZ;
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
        localObject1 = this.saj;
        if (localObject1 == null) {
          d.g.b.p.bcb("presenter");
        }
        ((ac.a)localObject1).O(true, false);
        ad.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
      }
    }
    label735:
    AppMethodBeat.o(205727);
  }
  
  public final void cKA()
  {
    AppMethodBeat.i(205728);
    super.cKA();
    Object localObject = com.tencent.mm.ui.component.a.KiD;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gh(cBz());
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.EU(cBz());
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.bv(cBz(), true);
    localObject = y.LjV;
    y.bFl();
    AppMethodBeat.o(205728);
  }
  
  public final void cOl()
  {
    AppMethodBeat.i(205722);
    Object localObject1 = this.rZi;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject1 = ((ac.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(205722);
      throw ((Throwable)localObject1);
    }
    int i = ((LinearLayoutManager)localObject1).km();
    localObject1 = this.rZi;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
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
      localObject2 = this.rZi;
      if (localObject2 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      ((ac.b)localObject2).getRecyclerView().post((Runnable)new i((LinearLayoutManager)localObject1));
    }
    localObject1 = this.rZi;
    if (localObject1 == null) {
      d.g.b.p.bcb("viewCallback");
    }
    ((ac.b)localObject1).cBC();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGS().value()).intValue() == 1)
    {
      localObject1 = FinderReporterUIC.tcM;
      localObject1 = FinderReporterUIC.a.eY((Context)getActivity());
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
        com.tencent.mm.plugin.finder.report.h.a(((FinderReporterUIC)localObject1).cOu(), 5, cBz());
      }
    }
    localObject1 = com.tencent.mm.plugin.finder.convert.v.rOD;
    ac.b localb = this.rZi;
    if (localb == null) {
      d.g.b.p.bcb("viewCallback");
    }
    localObject2 = this.fragment;
    localObject1 = localObject2;
    if (!(localObject2 instanceof FinderHomeTabFragment)) {
      localObject1 = null;
    }
    localObject1 = (FinderHomeTabFragment)localObject1;
    if (localObject1 != null) {}
    for (i = ((FinderHomeTabFragment)localObject1).duh;; i = 0)
    {
      v.a.a(localb, i);
      AppMethodBeat.o(205722);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131494117;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205725);
    if (fHy())
    {
      locala = this.saj;
      if (locala == null) {
        d.g.b.p.bcb("presenter");
      }
      boolean bool = locala.onBackPressed();
      AppMethodBeat.o(205725);
      return bool;
    }
    ac.a locala = this.saj;
    if (locala == null) {
      d.g.b.p.bcb("presenter");
    }
    if (!locala.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(205725);
      return true;
    }
    AppMethodBeat.o(205725);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205719);
    paramBundle = x.rIV;
    x.cxZ();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.sID;
    com.tencent.mm.plugin.finder.upload.b.cKC().cKB();
    Object localObject1;
    Object localObject2;
    if (!fHy())
    {
      getActivity().setMMTitle(2131759376);
      getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
      if ((!com.tencent.mm.plugin.finder.storage.b.cFK()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
        break label762;
      }
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().ahm("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().ahn("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
        paramBundle = FinderReporterUIC.tcM;
        paramBundle = FinderReporterUIC.a.eY((Context)getActivity());
        if (paramBundle == null) {
          break label752;
        }
        paramBundle = paramBundle.cOu();
        com.tencent.mm.plugin.finder.report.h.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
        paramBundle = com.tencent.mm.plugin.finder.report.g.soH;
        paramBundle = FinderReporterUIC.tcM;
        paramBundle = FinderReporterUIC.a.eY((Context)getActivity());
        if (paramBundle == null) {
          break label757;
        }
        paramBundle = paramBundle.cOu();
        label229:
        com.tencent.mm.plugin.finder.report.g.b("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ase)localObject1, 1, paramBundle, 0, 96);
      }
      getActivity().removeOptionMenu(this.sgy);
      getActivity().addIconOptionMenu(this.sgy, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (ase)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2));
      label284:
      getActivity().removeOptionMenu(this.shy);
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().ahm("TLPersonalCenter");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().ahn("TLPersonalCenter");
      getActivity().addIconOptionMenu(this.shy, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, (ase)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2));
      paramBundle = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.h.soM;
        String str = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject2).field_tipsId;
        d.g.b.p.g(str, "ctrInfo.field_tipsId");
        paramBundle = FinderReporterUIC.tcM;
        paramBundle = FinderReporterUIC.a.eY((Context)getActivity());
        if (paramBundle == null) {
          break label813;
        }
        paramBundle = paramBundle.cOu();
        label438:
        com.tencent.mm.plugin.finder.report.h.a("2", 1, 1, 1, 2, 0, str, null, 0L, paramBundle, 0, 0, 3456);
        paramBundle = com.tencent.mm.plugin.finder.report.g.soH;
        paramBundle = FinderReporterUIC.tcM;
        paramBundle = FinderReporterUIC.a.eY((Context)getActivity());
        if (paramBundle == null) {
          break label818;
        }
      }
    }
    label813:
    label818:
    for (paramBundle = paramBundle.cOu();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.g.b("2", (com.tencent.mm.plugin.finder.extension.reddot.i)localObject2, (ase)localObject1, 1, paramBundle, 0, 96);
      int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramBundle).getRedDotManager().Ep(i);
      localObject2 = getActivity();
      localObject1 = this.fragment;
      paramBundle = (Bundle)localObject1;
      if (!(localObject1 instanceof FinderHomeTabFragment)) {
        paramBundle = null;
      }
      this.saj = ((ac.a)new an((MMActivity)localObject2, (FinderHomeTabFragment)paramBundle));
      paramBundle = getActivity();
      localObject1 = this.saj;
      if (localObject1 == null) {
        d.g.b.p.bcb("presenter");
      }
      this.rZi = ((ac.b)new ao(paramBundle, (ac.a)localObject1, getRootView()));
      paramBundle = this.saj;
      if (paramBundle == null) {
        d.g.b.p.bcb("presenter");
      }
      localObject1 = this.rZi;
      if (localObject1 == null) {
        d.g.b.p.bcb("viewCallback");
      }
      paramBundle.db(localObject1);
      paramBundle = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.cKK().cKJ();
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.f)this);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.f)this);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
      com.tencent.mm.plugin.finder.extension.reddot.g.a(com.tencent.mm.plugin.finder.extension.reddot.g.czW(), (LifecycleOwner)getActivity(), (Observer)new k(this));
      AppMethodBeat.o(205719);
      return;
      label752:
      paramBundle = null;
      break;
      label757:
      paramBundle = null;
      break label229;
      label762:
      getActivity().removeOptionMenu(this.shz);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (!com.tencent.mm.plugin.finder.storage.b.cFQ()) {
        break label284;
      }
      getActivity().addIconOptionMenu(this.shz, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new d(this));
      break label284;
      paramBundle = null;
      break label438;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205731);
    ad.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.f)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.f)this);
    com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
    Object localObject = this.saj;
    if (localObject == null) {
      d.g.b.p.bcb("presenter");
    }
    ((ac.a)localObject).onDetach();
    localObject = j.sjX;
    j.release();
    com.tencent.mm.ad.c.b(null, (d.g.a.a)l.tdh);
    localObject = this.rZi;
    if (localObject == null) {
      d.g.b.p.bcb("viewCallback");
    }
    ((ac.b)localObject).getRecyclerView().setAdapter(null);
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ET(cBz());
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.cDu();
    AppMethodBeat.o(205731);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(205729);
    super.onPause();
    Object localObject = this.saj;
    if (localObject == null) {
      d.g.b.p.bcb("presenter");
    }
    ((ac.a)localObject).onUIPause();
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.cDu();
    AppMethodBeat.o(205729);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205726);
    super.onResume();
    Object localObject = this.saj;
    if (localObject == null) {
      d.g.b.p.bcb("presenter");
    }
    ((ac.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
    if (com.tencent.mm.plugin.finder.upload.g.cKL())
    {
      ad.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject = this.rZi;
      if (localObject == null) {
        d.g.b.p.bcb("viewCallback");
      }
      localObject = ((ac.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.g.sJk;
      com.tencent.mm.plugin.finder.upload.g.me(false);
    }
    localObject = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.EP(cBz());
    AppMethodBeat.o(205726);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(205723);
    ad.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.jjb;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label276;
      }
      com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label259;
      }
      paramString = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.ajl().getInt(al.a.IGO, 0);
      ad.i("Finder.TimelineUIC", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.shx = ((ax)paramn).cyJ();
        com.tencent.mm.ui.base.h.T((Context)getActivity(), getString(2131759342), "");
        AppMethodBeat.o(205723);
      }
    }
    else
    {
      AppMethodBeat.o(205723);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
    if (com.tencent.mm.plugin.finder.utils.p.ap((Activity)getActivity()))
    {
      paramString = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (com.tencent.mm.plugin.finder.utils.p.a((Context)getActivity(), getString(2131759369), ((ax)paramn).rJR, this.shx)) {
        cCv();
      }
    }
    AppMethodBeat.o(205723);
    return;
    label259:
    com.tencent.mm.ui.base.t.makeText((Context)getActivity(), 2131759307, 1).show();
    label276:
    AppMethodBeat.o(205723);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(205730);
    super.onStop();
    if (getActivity().isFinishing())
    {
      locale = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.ET(cBz());
      AppMethodBeat.o(205730);
      return;
    }
    com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.snY;
    com.tencent.mm.plugin.finder.report.e.ame(cBz());
    AppMethodBeat.o(205730);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUIC paramFinderTimelineUIC, ase paramase, com.tencent.mm.plugin.finder.extension.reddot.i parami) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205698);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
      ase localase = this.shD;
      com.tencent.mm.plugin.finder.extension.reddot.i locali = this.shE;
      if ((localase != null) && (locali != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.h.soM;
        paramMenuItem = FinderReporterUIC.tcM;
        paramMenuItem = FinderReporterUIC.a.eY((Context)this.tdd.getActivity());
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.cOu();
          com.tencent.mm.plugin.finder.report.h.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
          paramMenuItem = com.tencent.mm.plugin.finder.report.g.soH;
          paramMenuItem = FinderReporterUIC.tcM;
          paramMenuItem = FinderReporterUIC.a.eY((Context)this.tdd.getActivity());
          if (paramMenuItem == null) {
            break label228;
          }
          paramMenuItem = paramMenuItem.cOu();
          label112:
          com.tencent.mm.plugin.finder.report.g.b("2", locali, localase, 2, paramMenuItem, 0, 96);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramMenuItem).getRedDotManager().ahl("TLCamera");
        if (!bt.isNullOrNil(u.aAu())) {
          break label373;
        }
        if (FinderTimelineUIC.b(this.tdd) != null) {
          break label238;
        }
        ad.i("Finder.TimelineUIC", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.g.rSU;
        paramMenuItem = (g.a)com.tencent.mm.plugin.finder.extension.reddot.g.czV().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.dmo != true)) {
          break label233;
        }
      }
      label228:
      label233:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUIC.a(this.tdd, bool);
        AppMethodBeat.o(205698);
        return true;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label112;
      }
      label238:
      paramMenuItem = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.ajl().getInt(al.a.IGO, 0);
      ad.i("Finder.TimelineUIC", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.T((Context)this.tdd.getActivity(), this.tdd.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(205698);
        return true;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
        if (com.tencent.mm.plugin.finder.utils.p.ap((Activity)this.tdd.getActivity()))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.a((Context)this.tdd.getActivity(), this.tdd.getString(2131759369), FinderTimelineUIC.b(this.tdd));
          continue;
          label373:
          FinderTimelineUIC.c(this.tdd);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUIC paramFinderTimelineUIC, ase paramase, com.tencent.mm.plugin.finder.extension.reddot.i parami) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205699);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
      Object localObject = this.shF;
      com.tencent.mm.plugin.finder.extension.reddot.i locali = this.shG;
      if ((localObject != null) && (locali != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.h.soM;
        String str = locali.field_tipsId;
        d.g.b.p.g(str, "ctrInfo.field_tipsId");
        paramMenuItem = FinderReporterUIC.tcM;
        paramMenuItem = FinderReporterUIC.a.eY((Context)this.tdd.getActivity());
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.cOu();
          com.tencent.mm.plugin.finder.report.h.a("2", 1, 2, 1, 2, 0, str, null, 0L, paramMenuItem, 0, 0, 3456);
          paramMenuItem = com.tencent.mm.plugin.finder.report.g.soH;
          paramMenuItem = FinderReporterUIC.tcM;
          paramMenuItem = FinderReporterUIC.a.eY((Context)this.tdd.getActivity());
          if (paramMenuItem == null) {
            break label259;
          }
          paramMenuItem = paramMenuItem.cOu();
          label125:
          com.tencent.mm.plugin.finder.report.g.b("2", locali, (ase)localObject, 2, paramMenuItem, 0, 96);
        }
      }
      else
      {
        localObject = new Intent();
        paramMenuItem = com.tencent.mm.kernel.g.ad(PluginFinder.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(PluginFinder::class.java)");
        paramMenuItem = ((PluginFinder)paramMenuItem).getRedDotManager().ahn("TLPersonalCenter");
        if (paramMenuItem == null) {
          break label264;
        }
        paramMenuItem = paramMenuItem.ahq("TLPersonalCenter");
        label182:
        if (paramMenuItem == null) {
          break label269;
        }
      }
      label259:
      label264:
      label269:
      for (boolean bool = true;; bool = false)
      {
        paramMenuItem = FinderSelfUI.sGL;
        ((Intent)localObject).putExtra(FinderSelfUI.cKq(), bool);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.y((Context)this.tdd.getActivity(), (Intent)localObject);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class);
        d.g.b.p.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.t)paramMenuItem).getRedDotManager().ahl("TLPersonalCenter");
        AppMethodBeat.o(205699);
        return true;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        break label125;
        paramMenuItem = null;
        break label182;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205701);
      paramMenuItem = new bj();
      paramMenuItem.Ss();
      paramMenuItem.aLk();
      ad.i("Finder.TimelineUIC", "report18939 postEdu: " + paramMenuItem.St());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.d((Context)this.tdd.getActivity());
      paramMenuItem.Gc(2131494081);
      Object localObject = (TextView)paramMenuItem.kBS.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.kBS.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.kBS.findViewById(2131302881);
      d.g.b.p.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cFR());
      d.g.b.p.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cFS());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.cMW();
      AppMethodBeat.o(205701);
      return true;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(205700);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.shI.bpT();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$addPostEducation$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205700);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    public static final e tde;
    
    static
    {
      AppMethodBeat.i(205703);
      tde = new e();
      AppMethodBeat.o(205703);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(205702);
      d.g.b.p.g(paraml, "it");
      if (paraml.fyP())
      {
        paraml.jI(1001, 2131755747);
        paraml.jI(1002, 2131755754);
      }
      AppMethodBeat.o(205702);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.e
  {
    f(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(205704);
      Intent localIntent = new Intent();
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.tdd.getActivity(), localIntent);
        AppMethodBeat.o(205704);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g tdf;
    
    static
    {
      AppMethodBeat.i(205706);
      tdf = new g();
      AppMethodBeat.o(205706);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(205705);
      com.tencent.mm.plugin.finder.report.f localf = com.tencent.mm.plugin.finder.report.f.soC;
      com.tencent.mm.plugin.finder.report.f.EW(6);
      AppMethodBeat.o(205705);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class h
    implements DialogInterface.OnCancelListener
  {
    h(FinderTimelineUIC paramFinderTimelineUIC, ax paramax) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(205707);
      com.tencent.mm.kernel.g.aiU().a((n)this.shL);
      com.tencent.mm.kernel.g.aiU().b(3761, (com.tencent.mm.al.f)this.tdd);
      AppMethodBeat.o(205707);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(LinearLayoutManager paramLinearLayoutManager) {}
    
    public final void run()
    {
      AppMethodBeat.i(205708);
      LinearLayoutManager localLinearLayoutManager = this.rZI;
      if (localLinearLayoutManager != null)
      {
        if (this.tdg) {}
        for (int i = 0;; i = 1)
        {
          localLinearLayoutManager.ag(i, 0);
          AppMethodBeat.o(205708);
          return;
        }
      }
      AppMethodBeat.o(205708);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205709);
      this.tdd.onBackPressed();
      AppMethodBeat.o(205709);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class k<T>
    implements Observer<g.a>
  {
    k(FinderTimelineUIC paramFinderTimelineUIC) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    public static final l tdh;
    
    static
    {
      AppMethodBeat.i(205712);
      tdh = new l();
      AppMethodBeat.o(205712);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.plugin.finder.video.o, Boolean>
  {
    public static final m tdi;
    
    static
    {
      AppMethodBeat.i(205714);
      tdi = new m();
      AppMethodBeat.o(205714);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$requestInsert$1$1"})
  static final class n
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    n(BaseFinderFeed paramBaseFinderFeed, FinderTimelineUIC paramFinderTimelineUIC, long paramLong, int paramInt, boolean paramBoolean, aoi paramaoi)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    o(FinderTimelineUIC paramFinderTimelineUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC
 * JD-Core Version:    0.7.0.1
 */