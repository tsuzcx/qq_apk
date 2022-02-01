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
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.convert.q.a;
import com.tencent.mm.plugin.finder.event.base.m;
import com.tencent.mm.plugin.finder.extension.reddot.d.a;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.i.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.utils.i.e;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.w;
import d.v;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "tabType", "getTabType", "()I", "tabType$delegate", "Lkotlin/Lazy;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "doClickPostAction", "doPrepareUser", "showPostRed", "", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getLayoutId", "getVisibleFeedByUsername", "username", "", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActionbarClick", "isDouble", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestInsert", "keepUnreadSize", "isPrefetch", "Companion", "plugin-finder_release"})
public final class FinderTimelineUIC
  extends UIComponent
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.finder.api.e
{
  public static final a LjA;
  private final d.f LhT;
  private ProgressDialog ipM;
  private final int qAD;
  private alv qBp;
  private final int qBq;
  private final int qBr;
  i.b qrz;
  private i.a qxq;
  
  static
  {
    AppMethodBeat.i(200537);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(FinderTimelineUIC.class), "tabType", "getTabType()I")) };
    LjA = new a((byte)0);
    AppMethodBeat.o(200537);
  }
  
  public FinderTimelineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200554);
    this.qBq = 1;
    this.qAD = 2;
    this.qBr = 3;
    this.LhT = d.g.E((d.g.a.a)new n(this));
    AppMethodBeat.o(200554);
  }
  
  public FinderTimelineUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200553);
    this.qBq = 1;
    this.qAD = 2;
    this.qBr = 3;
    this.LhT = d.g.E((d.g.a.a)new n(this));
    AppMethodBeat.o(200553);
  }
  
  private final void cmO()
  {
    AppMethodBeat.i(200545);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.qIC;
    if (com.tencent.mm.plugin.finder.spam.a.Zv("post"))
    {
      AppMethodBeat.o(200545);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.qSb;
    if (com.tencent.mm.plugin.finder.utils.a.ly((Context)getActivity()))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.kZ(true);
      AppMethodBeat.o(200545);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.a.qFo;
    com.tencent.mm.plugin.finder.report.a.kZ(false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getActivity(), 1, true);
    View localView = com.tencent.mm.ui.y.js((Context)getActivity()).inflate(2131494113, null);
    Object localObject2 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject3 = com.tencent.mm.model.u.aqO();
    d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
    localObject3 = b.a.YL((String)localObject3);
    if (localObject3 != null)
    {
      d.g.b.k.g(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject3).Su()));
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cmV();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject3).field_avatarUrl);
      d.g.b.k.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.qCF;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.qCI));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).J(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)e.LjC);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)g.LjD);
    ((com.tencent.mm.ui.widget.a.e)localObject1).csG();
    AppMethodBeat.o(200545);
  }
  
  private final int epE()
  {
    AppMethodBeat.i(200538);
    int i = ((Number)this.LhT.getValue()).intValue();
    AppMethodBeat.o(200538);
    return i;
  }
  
  public final void a(ahv paramahv)
  {
    AppMethodBeat.i(200552);
    d.g.b.k.h(paramahv, "cmdItem");
    switch (paramahv.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200552);
      return;
      paramahv = this.qxq;
      if (paramahv == null) {
        d.g.b.k.aPZ("presenter");
      }
      paramahv.fTn();
    }
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(200541);
    if (!gak()) {
      com.tencent.mm.pluginsdk.g.p(getActivity());
    }
    AppMethodBeat.o(200541);
  }
  
  public final void be(Bundle paramBundle)
  {
    AppMethodBeat.i(200539);
    if (!gak()) {
      com.tencent.mm.pluginsdk.g.o(getActivity());
    }
    AppMethodBeat.o(200539);
  }
  
  public final void fTo()
  {
    AppMethodBeat.i(200548);
    super.fTo();
    Object localObject1 = com.tencent.mm.ui.component.a.LCX;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderVideoRecycler.class)).J((d.g.a.b)l.LjF);
    localObject1 = this.qxq;
    if (localObject1 == null) {
      d.g.b.k.aPZ("presenter");
    }
    Object localObject2 = ((i.a)localObject1).getVideoCore().qTH;
    Object localObject3;
    boolean bool1;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      localObject1 = this.fragment;
      if (localObject1 != null)
      {
        localObject1 = localObject1.getClass();
        if (localObject1 != null)
        {
          localObject1 = ((Class)localObject1).getSimpleName();
          ((FinderVideoAutoPlayManager)localObject2).m((String)localObject1 + "#onViewFocused", false, true);
        }
      }
    }
    else
    {
      localObject1 = com.tencent.mm.ui.component.a.LCX;
      ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).ahM(epE());
      localObject1 = this.qxq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      localObject1 = ((i.a)localObject1).getActivity();
      if (localObject1 == null) {
        break label566;
      }
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null) {
        break label566;
      }
      bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
      label215:
      localObject1 = this.qxq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      localObject1 = ((i.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
      }
      localObject1 = this.qxq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      ((i.a)localObject1).fTo();
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      boolean bool2 = ((PluginFinder)localObject1).getRedDotManager().ahh(epE());
      if ((bool1) && (epE() == 3)) {
        break label571;
      }
      localObject1 = this.qxq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      ((i.a)localObject1).aV(bool2, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((com.tencent.mm.plugin.finder.storage.b.fUw()) && (bool2))
      {
        localObject1 = FinderReporterUIC.Ljl;
        localObject1 = FinderReporterUIC.a.lB((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject1).fXs(), 6);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.ui.component.a.LCX;
      localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(getActivity()).get(FinderReporterUIC.class)).ahW(epE());
      if (localObject1 == null) {
        break label621;
      }
      epE();
      localObject2 = new m();
      localObject3 = this.qrz;
      if (localObject3 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject3 = ((i.b)localObject3).getRecyclerView();
      Object localObject4 = ((RecyclerView)localObject3).getLayoutManager();
      if ((localObject4 instanceof LinearLayoutManager))
      {
        int i = ((LinearLayoutManager)localObject4).jO();
        int j = ((LinearLayoutManager)localObject4).jQ();
        localObject4 = i.qTa;
        ((m)localObject2).qsl = i.j((RecyclerView)localObject3, i, j).qHv;
      }
      ((com.tencent.mm.plugin.finder.event.base.d)localObject1).d((com.tencent.mm.plugin.finder.event.base.c)localObject2);
      AppMethodBeat.o(200548);
      return;
      localObject1 = null;
      break;
      label566:
      bool1 = false;
      break label215;
      label571:
      if ((bool1) && (epE() == 3))
      {
        localObject1 = this.qxq;
        if (localObject1 == null) {
          d.g.b.k.aPZ("presenter");
        }
        ((i.a)localObject1).aV(true, false);
        ad.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
      }
    }
    label621:
    AppMethodBeat.o(200548);
  }
  
  public final void fXk()
  {
    AppMethodBeat.i(200543);
    Object localObject1 = this.qrz;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    localObject1 = ((i.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(200543);
      throw ((Throwable)localObject1);
    }
    int j = ((LinearLayoutManager)localObject1).jO();
    Object localObject2;
    int i;
    if (j <= 12)
    {
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject1 = ((i.b)localObject1).getRecyclerView();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject1 = com.tencent.mm.plugin.finder.convert.q.qrB;
      i.b localb = this.qrz;
      if (localb == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject2 = this.fragment;
      localObject1 = localObject2;
      if (!(localObject2 instanceof FinderHomeTabFragment)) {
        localObject1 = null;
      }
      localObject1 = (FinderHomeTabFragment)localObject1;
      if (localObject1 == null) {
        break label415;
      }
      i = ((FinderHomeTabFragment)localObject1).IoU;
      label222:
      q.a.a(null, localb, i);
      if (j > 12) {
        break label420;
      }
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      ((i.b)localObject1).BH(40L);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUw()) {
        break label447;
      }
      localObject1 = FinderReporterUIC.Ljl;
      localObject1 = FinderReporterUIC.a.lB((Context)getActivity());
      if (localObject1 == null) {
        break label447;
      }
      localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.a(((FinderReporterUIC)localObject1).fXs(), 5, epE());
      AppMethodBeat.o(200543);
      return;
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject1 = ((i.b)localObject1).getRecyclerView();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      label415:
      i = 0;
      break label222;
      label420:
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      ((i.b)localObject1).BH(300L);
    }
    label447:
    AppMethodBeat.o(200543);
  }
  
  public final void fXn()
  {
    AppMethodBeat.i(200549);
    super.fXn();
    Object localObject = this.qxq;
    if (localObject == null) {
      d.g.b.k.aPZ("presenter");
    }
    FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = ((i.a)localObject).getVideoCore().qTH;
    if (localFinderVideoAutoPlayManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = this.fragment;
      if (localObject != null)
      {
        localObject = localObject.getClass();
        if (localObject == null) {}
      }
      for (localObject = ((Class)localObject).getSimpleName();; localObject = null)
      {
        FinderVideoAutoPlayManager.a(localFinderVideoAutoPlayManager, (String)localObject + "#onViewFocused", true);
        AppMethodBeat.o(200549);
        return;
      }
    }
    AppMethodBeat.o(200549);
  }
  
  public final int getLayoutId()
  {
    return 2131494117;
  }
  
  public final void i(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    int j = 0;
    i.a locala = null;
    AppMethodBeat.i(200542);
    Object localObject1 = this.qrz;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    Object localObject2 = ((i.b)localObject1).getRecyclerView().getAdapter();
    localObject1 = localObject2;
    if (!(localObject2 instanceof WxRecyclerAdapter)) {
      localObject1 = null;
    }
    localObject1 = (WxRecyclerAdapter)localObject1;
    BaseFinderFeed localBaseFinderFeed;
    LinkedList localLinkedList;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.view.recyclerview.e)com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject1, paramLong);
      if (localObject1 == null) {
        break label559;
      }
      localBaseFinderFeed = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject1).fjf();
      if (localBaseFinderFeed == null) {
        break label559;
      }
      localLinkedList = new LinkedList();
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject2 = ((i.b)localObject1).getRecyclerView().getLayoutManager();
      localObject1 = localObject2;
      if (!(localObject2 instanceof LinearLayoutManager)) {
        localObject1 = null;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 == null) {
        break label337;
      }
    }
    long l;
    label337:
    for (int i = ((LinearLayoutManager)localObject1).jO();; i = 0)
    {
      if (localObject1 != null) {
        j = ((LinearLayoutManager)localObject1).jQ();
      }
      localObject1 = i.qTa;
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      l = i.j(((i.b)localObject1).getRecyclerView(), i, j).feedId;
      if (i > j) {
        break label343;
      }
      for (;;)
      {
        localObject1 = this.qrz;
        if (localObject1 == null) {
          d.g.b.k.aPZ("viewCallback");
        }
        localObject2 = ((i.b)localObject1).getRecyclerView().cj(i);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.e)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.e))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.e)localObject1).fjf();
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
    label343:
    if (paramLong != l)
    {
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject2 = ((i.b)localObject1).getRecyclerView().getAdapter();
      localObject1 = localObject2;
      if (!(localObject2 instanceof WxRecyclerAdapter)) {
        localObject1 = null;
      }
      localObject2 = (WxRecyclerAdapter)localObject1;
      localObject1 = locala;
      if (localObject2 != null)
      {
        localObject2 = (com.tencent.mm.view.recyclerview.e)com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject2, l);
        localObject1 = locala;
        if (localObject2 != null) {
          localObject1 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject2).fjf();
        }
      }
      if (localObject1 != null)
      {
        locala = this.qxq;
        if (locala == null) {
          d.g.b.k.aPZ("presenter");
        }
        locala.a(localBaseFinderFeed, (BaseFinderFeed)localObject1, paramInt, (List)localLinkedList, paramBoolean);
      }
    }
    for (;;)
    {
      localObject1 = MediaPreloadCore.KTA;
      if (MediaPreloadCore.fTP()) {
        com.tencent.mm.ad.c.g((d.g.a.a)new m(localBaseFinderFeed, this, paramLong, paramInt, paramBoolean));
      }
      AppMethodBeat.o(200542);
      return;
      localObject1 = this.qxq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      ((i.a)localObject1).a(localBaseFinderFeed, localBaseFinderFeed, paramInt, (List)localLinkedList, paramBoolean);
    }
    label559:
    AppMethodBeat.o(200542);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(200546);
    if (gak())
    {
      locala = this.qxq;
      if (locala == null) {
        d.g.b.k.aPZ("presenter");
      }
      boolean bool = locala.onBackPressed();
      AppMethodBeat.o(200546);
      return bool;
    }
    i.a locala = this.qxq;
    if (locala == null) {
      d.g.b.k.aPZ("presenter");
    }
    if (!locala.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(200546);
      return true;
    }
    AppMethodBeat.o(200546);
    return false;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(200540);
    paramBundle = com.tencent.mm.plugin.finder.cgi.j.qoO;
    com.tencent.mm.plugin.finder.cgi.j.cky();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.qQD;
    com.tencent.mm.plugin.finder.upload.b.crx().crw();
    Object localObject1;
    Object localObject2;
    if (!gak())
    {
      getActivity().setMMTitle(2131759376);
      getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((!com.tencent.mm.plugin.finder.storage.b.cps()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
        break label665;
      }
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().YV("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().YW("TLCamera");
      paramBundle = i.qTa;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
        paramBundle = FinderReporterUIC.Ljl;
        paramBundle = FinderReporterUIC.a.lB((Context)getActivity());
        if (paramBundle == null) {
          break label660;
        }
        paramBundle = paramBundle.fXs();
        com.tencent.mm.plugin.finder.report.b.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 1472);
      }
      getActivity().removeOptionMenu(this.qAD);
      getActivity().addIconOptionMenu(this.qAD, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (aln)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.f)localObject2));
      label241:
      getActivity().removeOptionMenu(this.qBq);
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      paramBundle = ((PluginFinder)paramBundle).getRedDotManager().YV("TLPersonalCenter");
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().YW("TLPersonalCenter");
      getActivity().addIconOptionMenu(this.qBq, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, paramBundle, (com.tencent.mm.plugin.finder.extension.reddot.f)localObject1));
      localObject2 = i.qTa;
      if ((paramBundle != null) && (localObject1 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.b.qFq;
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.f)localObject1).field_tipsId;
        d.g.b.k.g(localObject1, "ctrInfo.field_tipsId");
        paramBundle = FinderReporterUIC.Ljl;
        paramBundle = FinderReporterUIC.a.lB((Context)getActivity());
        if (paramBundle == null) {
          break label716;
        }
      }
    }
    label660:
    label665:
    label716:
    for (paramBundle = paramBundle.fXs();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.b.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 1408);
      int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramBundle).getRedDotManager().Cy(i);
      localObject2 = getActivity();
      localObject1 = this.fragment;
      paramBundle = (Bundle)localObject1;
      if (!(localObject1 instanceof FinderHomeTabFragment)) {
        paramBundle = null;
      }
      this.qxq = ((i.a)new com.tencent.mm.plugin.finder.feed.j((MMActivity)localObject2, (FinderHomeTabFragment)paramBundle));
      paramBundle = getActivity();
      localObject1 = this.qxq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      this.qrz = ((i.b)new com.tencent.mm.plugin.finder.feed.k(paramBundle, (i.a)localObject1, getRootView()));
      paramBundle = this.qxq;
      if (paramBundle == null) {
        d.g.b.k.aPZ("presenter");
      }
      localObject1 = this.qrz;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      paramBundle.cW(localObject1);
      paramBundle = com.tencent.mm.plugin.finder.upload.f.qRf;
      com.tencent.mm.plugin.finder.upload.f.crB().crA();
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.e)this);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.e)this);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
      com.tencent.mm.plugin.finder.extension.reddot.d.a(com.tencent.mm.plugin.finder.extension.reddot.d.cls(), (LifecycleOwner)getActivity(), (Observer)new j(this));
      AppMethodBeat.o(200540);
      return;
      paramBundle = null;
      break;
      getActivity().removeOptionMenu(this.qBr);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.cpy()) {
        break label241;
      }
      getActivity().addIconOptionMenu(this.qBr, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new d(this));
      break label241;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200551);
    ad.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.e)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
    Object localObject = this.qxq;
    if (localObject == null) {
      d.g.b.k.aPZ("presenter");
    }
    ((i.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.f.qDu;
    com.tencent.mm.plugin.finder.model.f.release();
    com.tencent.mm.ad.c.b(null, (d.g.a.a)k.LjE);
    if (!gak())
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().fSI();
    }
    AppMethodBeat.o(200551);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200550);
    super.onPause();
    if (this.qxq == null) {
      d.g.b.k.aPZ("presenter");
    }
    AppMethodBeat.o(200550);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200547);
    super.onResume();
    Object localObject = this.qxq;
    if (localObject == null) {
      d.g.b.k.aPZ("presenter");
    }
    ((i.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.f.qRf;
    if (com.tencent.mm.plugin.finder.upload.f.crC())
    {
      ad.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject = this.qrz;
      if (localObject == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      localObject = ((i.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.f.qRf;
      com.tencent.mm.plugin.finder.upload.f.lg(false);
    }
    AppMethodBeat.o(200547);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(200544);
    ad.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.ipM;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label276;
      }
      com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label259;
      }
      paramString = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.afk().getInt(ae.a.Fwn, 0);
      ad.i("Finder.TimelineUIC", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.qBp = ((com.tencent.mm.plugin.finder.cgi.y)paramn).ckV();
        com.tencent.mm.ui.base.h.R((Context)getActivity(), getString(2131759342), "");
        AppMethodBeat.o(200544);
      }
    }
    else
    {
      AppMethodBeat.o(200544);
      return;
    }
    paramString = i.qTa;
    if (i.al((Activity)getActivity()))
    {
      paramString = i.qTa;
      if (i.a((Context)getActivity(), getString(2131759369), ((com.tencent.mm.plugin.finder.cgi.y)paramn).qpv, this.qBp)) {
        cmO();
      }
    }
    AppMethodBeat.o(200544);
    return;
    label259:
    t.makeText((Context)getActivity(), 2131759307, 1).show();
    label276:
    AppMethodBeat.o(200544);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUIC paramFinderTimelineUIC, aln paramaln, com.tencent.mm.plugin.finder.extension.reddot.f paramf) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      boolean bool2 = false;
      AppMethodBeat.i(200519);
      paramMenuItem = i.qTa;
      paramMenuItem = this.qBu;
      com.tencent.mm.plugin.finder.extension.reddot.f localf = this.qBv;
      if ((paramMenuItem != null) && (localf != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.b.qFq;
        paramMenuItem = FinderReporterUIC.Ljl;
        paramMenuItem = FinderReporterUIC.a.lB((Context)this.LjB.getActivity());
        if (paramMenuItem == null) {
          break label202;
        }
      }
      label202:
      for (paramMenuItem = paramMenuItem.fXs();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.b.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 1472);
        paramMenuItem = com.tencent.mm.plugin.finder.report.a.qFo;
        com.tencent.mm.plugin.finder.report.a.CJ(1);
        paramMenuItem = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (!com.tencent.mm.plugin.finder.storage.b.fUw())
        {
          paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class);
          d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
          ((com.tencent.mm.plugin.i.a.j)paramMenuItem).getRedDotManager().YU("TLCamera");
        }
        if (!bt.isNullOrNil(com.tencent.mm.model.u.aqO())) {
          break label342;
        }
        if (FinderTimelineUIC.c(this.LjB) != null) {
          break;
        }
        ad.i("Finder.TimelineUIC", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.d.qtG;
        paramMenuItem = (d.a)com.tencent.mm.plugin.finder.extension.reddot.d.clr().getValue();
        boolean bool1 = bool2;
        if (paramMenuItem != null)
        {
          bool1 = bool2;
          if (paramMenuItem.ddw == true) {
            bool1 = true;
          }
        }
        FinderTimelineUIC.a(this.LjB, bool1);
        AppMethodBeat.o(200519);
        return true;
      }
      paramMenuItem = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.afk().getInt(ae.a.Fwn, 0);
      ad.i("Finder.TimelineUIC", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.R((Context)this.LjB.getActivity(), this.LjB.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(200519);
        return true;
        paramMenuItem = i.qTa;
        if (i.al((Activity)this.LjB.getActivity()))
        {
          paramMenuItem = i.qTa;
          i.a((Context)this.LjB.getActivity(), this.LjB.getString(2131759369), FinderTimelineUIC.c(this.LjB));
          continue;
          label342:
          FinderTimelineUIC.d(this.LjB);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUIC paramFinderTimelineUIC, aln paramaln, com.tencent.mm.plugin.finder.extension.reddot.f paramf) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200520);
      paramMenuItem = i.qTa;
      Object localObject = paramBundle;
      paramMenuItem = this.qBx;
      if ((localObject != null) && (paramMenuItem != null))
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        localObject = paramMenuItem.field_tipsId;
        d.g.b.k.g(localObject, "ctrInfo.field_tipsId");
        paramMenuItem = FinderReporterUIC.Ljl;
        paramMenuItem = FinderReporterUIC.a.lB((Context)this.LjB.getActivity());
        if (paramMenuItem == null) {
          break label150;
        }
      }
      label150:
      for (paramMenuItem = paramMenuItem.fXs();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.b.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 1408);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.x((Context)this.LjB.getActivity(), null);
        paramMenuItem = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUw())
        {
          paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class);
          d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
          ((com.tencent.mm.plugin.i.a.j)paramMenuItem).getRedDotManager().YU("TLPersonalCenter");
        }
        AppMethodBeat.o(200520);
        return true;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200522);
      paramMenuItem = new af();
      paramMenuItem.Qd();
      paramMenuItem.aBj();
      ad.i("Finder.TimelineUIC", "report18939 postEdu: " + paramMenuItem.Qe());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.c((Context)this.LjB.getActivity());
      paramMenuItem.Do(2131494081);
      Object localObject = (TextView)paramMenuItem.jGG.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.jGG.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.jGG.findViewById(2131302881);
      d.g.b.k.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cpz());
      d.g.b.k.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cpA());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.csG();
      AppMethodBeat.o(200522);
      return true;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(200521);
        this.qBy.bfo();
        AppMethodBeat.o(200521);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    public static final e LjC;
    
    static
    {
      AppMethodBeat.i(200524);
      LjC = new e();
      AppMethodBeat.o(200524);
    }
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(200523);
      d.g.b.k.g(paraml, "it");
      if (paraml.eSQ())
      {
        paraml.jj(1001, 2131755747);
        paraml.jj(1002, 2131755754);
      }
      AppMethodBeat.o(200523);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.d
  {
    f(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(200525);
      Intent localIntent = new Intent();
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.v((Context)this.LjB.getActivity(), localIntent);
        AppMethodBeat.o(200525);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g LjD;
    
    static
    {
      AppMethodBeat.i(200527);
      LjD = new g();
      AppMethodBeat.o(200527);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(200526);
      com.tencent.mm.plugin.finder.report.a locala = com.tencent.mm.plugin.finder.report.a.qFo;
      com.tencent.mm.plugin.finder.report.a.CL(6);
      AppMethodBeat.o(200526);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class h
    implements DialogInterface.OnCancelListener
  {
    h(FinderTimelineUIC paramFinderTimelineUIC, com.tencent.mm.plugin.finder.cgi.y paramy) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(200528);
      com.tencent.mm.kernel.g.aeS().a((n)this.qBB);
      com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this.LjB);
      AppMethodBeat.o(200528);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(200529);
      this.LjB.onBackPressed();
      AppMethodBeat.o(200529);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<d.a>
  {
    j(FinderTimelineUIC paramFinderTimelineUIC) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    public static final k LjE;
    
    static
    {
      AppMethodBeat.i(200532);
      LjE = new k();
      AppMethodBeat.o(200532);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<o, Boolean>
  {
    public static final l LjF;
    
    static
    {
      AppMethodBeat.i(200534);
      LjF = new l();
      AppMethodBeat.o(200534);
    }
    
    l()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$requestInsert$1$1"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    m(BaseFinderFeed paramBaseFinderFeed, FinderTimelineUIC paramFinderTimelineUIC, long paramLong, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    n(FinderTimelineUIC paramFinderTimelineUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC
 * JD-Core Version:    0.7.0.1
 */