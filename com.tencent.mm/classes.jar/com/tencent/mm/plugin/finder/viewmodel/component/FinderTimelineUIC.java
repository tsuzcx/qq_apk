package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.convert.u.a;
import com.tencent.mm.plugin.finder.extension.reddot.f.a;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.feed.x.a;
import com.tencent.mm.plugin.finder.feed.x.b;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.n.a;
import com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.component.SimpleUIComponent;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.w;
import d.v;
import d.y;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "MENU_ID_POST", "", "MENU_ID_POST_NO_PERMISSION", "MENU_ID_PROFILE", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "progressDlg", "Landroid/app/ProgressDialog;", "tabType", "getTabType", "()I", "tabType$delegate", "Lkotlin/Lazy;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "addAllMenu", "", "addPostEducation", "doClickPostAction", "doPrepareUser", "showPostRed", "", "findBaseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedId", "", "getLayoutId", "getVisibleFeedByUsername", "username", "", "handleCmd", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "onActionbarClick", "isDouble", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFocused", "onUserVisibleUnFocused", "requestInsert", "keepUnreadSize", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "Companion", "plugin-finder_release"})
public final class FinderTimelineUIC
  extends UIComponent
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.finder.api.e
{
  public static final FinderTimelineUIC.a sfg;
  private ProgressDialog iPT;
  x.b rbJ;
  private x.a rlB;
  private final int rrs;
  private aoy rsp;
  private final int rsq;
  private final int rsr;
  private final d.f sdw;
  
  static
  {
    AppMethodBeat.i(204667);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(FinderTimelineUIC.class), "tabType", "getTabType()I")) };
    sfg = new FinderTimelineUIC.a((byte)0);
    AppMethodBeat.o(204667);
  }
  
  public FinderTimelineUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204684);
    this.rsq = 1;
    this.rrs = 2;
    this.rsr = 3;
    this.sdw = d.g.K((d.g.a.a)new n(this));
    AppMethodBeat.o(204684);
  }
  
  public FinderTimelineUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204683);
    this.rsq = 1;
    this.rrs = 2;
    this.rsr = 3;
    this.sdw = d.g.K((d.g.a.a)new n(this));
    AppMethodBeat.o(204683);
  }
  
  private final int cvi()
  {
    AppMethodBeat.i(204668);
    int i = ((Number)this.sdw.getValue()).intValue();
    AppMethodBeat.o(204668);
    return i;
  }
  
  private final void cwh()
  {
    AppMethodBeat.i(204675);
    Object localObject1 = com.tencent.mm.plugin.finder.spam.a.rBD;
    if (com.tencent.mm.plugin.finder.spam.a.aed("post"))
    {
      AppMethodBeat.o(204675);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
    if (com.tencent.mm.plugin.finder.utils.a.eO((Context)getActivity()))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.ae(1, true);
      AppMethodBeat.o(204675);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.report.c.rxi;
    com.tencent.mm.plugin.finder.report.c.ae(1, false);
    localObject1 = new com.tencent.mm.ui.widget.a.e((Context)getActivity(), 1, true);
    View localView = z.jD((Context)getActivity()).inflate(2131494113, null);
    Object localObject2 = (TextView)localView.findViewById(2131302863);
    ImageView localImageView = (ImageView)localView.findViewById(2131296996);
    Object localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject3 = com.tencent.mm.model.u.axE();
    d.g.b.k.g(localObject3, "ConfigStorageLogic.getMyFinderUsername()");
    localObject3 = b.a.adh((String)localObject3);
    if (localObject3 != null)
    {
      d.g.b.k.g(localObject2, "nicknameTv");
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)getActivity(), (CharSequence)((com.tencent.mm.plugin.finder.api.f)localObject3).Tn()));
      localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
      localObject2 = com.tencent.mm.plugin.finder.loader.h.cwo();
      localObject3 = new com.tencent.mm.plugin.finder.loader.a(((com.tencent.mm.plugin.finder.api.f)localObject3).field_avatarUrl);
      d.g.b.k.g(localImageView, "avatarIv");
      com.tencent.mm.plugin.finder.loader.h localh = com.tencent.mm.plugin.finder.loader.h.rtK;
      ((com.tencent.mm.loader.d)localObject2).a(localObject3, localImageView, com.tencent.mm.plugin.finder.loader.h.a(h.a.rtN));
    }
    ((com.tencent.mm.ui.widget.a.e)localObject1).J(localView, true);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)FinderTimelineUIC.e.sfi);
    ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new f(this));
    ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)g.sfj);
    ((com.tencent.mm.ui.widget.a.e)localObject1).cED();
    AppMethodBeat.o(204675);
  }
  
  public final void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(204671);
    if (!fqL()) {
      com.tencent.mm.pluginsdk.g.p(getActivity());
    }
    paramBundle = this.rlB;
    if (paramBundle == null) {
      d.g.b.k.aVY("presenter");
    }
    FinderVideoAutoPlayManager localFinderVideoAutoPlayManager = paramBundle.getVideoCore().rSr;
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
        AppMethodBeat.o(204671);
        return;
      }
    }
    AppMethodBeat.o(204671);
  }
  
  public final void a(final long paramLong, int paramInt, final boolean paramBoolean, final ald paramald)
  {
    int j = 0;
    x.a locala = null;
    AppMethodBeat.i(204672);
    Object localObject1 = this.rbJ;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    Object localObject2 = ((x.b)localObject1).getRecyclerView().getAdapter();
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
      localBaseFinderFeed = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject1).fzs();
      if (localBaseFinderFeed == null) {
        break label567;
      }
      localLinkedList = new LinkedList();
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject2 = ((x.b)localObject1).getRecyclerView().getLayoutManager();
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
    for (int i = ((LinearLayoutManager)localObject1).jW();; i = 0)
    {
      if (localObject1 != null) {
        j = ((LinearLayoutManager)localObject1).jY();
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      l = com.tencent.mm.plugin.finder.utils.n.b(((x.b)localObject1).getRecyclerView(), i, j, 8).dig;
      if (i > j) {
        break label345;
      }
      for (;;)
      {
        localObject1 = this.rbJ;
        if (localObject1 == null) {
          d.g.b.k.aVY("viewCallback");
        }
        localObject2 = ((x.b)localObject1).getRecyclerView().ci(i);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.e)) {
          localObject1 = null;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.e)localObject1;
        if ((localObject1 instanceof com.tencent.mm.view.recyclerview.e))
        {
          localObject1 = ((com.tencent.mm.view.recyclerview.e)localObject1).fzs();
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
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject2 = ((x.b)localObject1).getRecyclerView().getAdapter();
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
          localObject1 = (BaseFinderFeed)((com.tencent.mm.view.recyclerview.e)localObject2).fzs();
        }
      }
      if (localObject1 != null)
      {
        locala = this.rlB;
        if (locala == null) {
          d.g.b.k.aVY("presenter");
        }
        locala.a(localBaseFinderFeed, (BaseFinderFeed)localObject1, paramInt, (List)localLinkedList, paramBoolean, paramald);
      }
    }
    for (;;)
    {
      localObject1 = MediaPreloadCore.rvo;
      if (MediaPreloadCore.cwJ()) {
        com.tencent.mm.ac.c.g((d.g.a.a)new m(localBaseFinderFeed, this, paramLong, paramInt, paramBoolean, paramald));
      }
      AppMethodBeat.o(204672);
      return;
      localObject1 = this.rlB;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      ((x.a)localObject1).a(localBaseFinderFeed, localBaseFinderFeed, paramInt, (List)localLinkedList, paramBoolean, paramald);
    }
    label567:
    AppMethodBeat.o(204672);
  }
  
  public final void a(aiy paramaiy)
  {
    AppMethodBeat.i(204682);
    d.g.b.k.h(paramaiy, "cmdItem");
    switch (paramaiy.cmdId)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(204682);
      return;
      paramaiy = this.rlB;
      if (paramaiy == null) {
        d.g.b.k.aVY("presenter");
      }
      paramaiy.cvg();
    }
  }
  
  public final void aa(Bundle paramBundle)
  {
    AppMethodBeat.i(204669);
    if (!fqL()) {
      com.tencent.mm.pluginsdk.g.o(getActivity());
    }
    AppMethodBeat.o(204669);
  }
  
  public final void cFT()
  {
    AppMethodBeat.i(204673);
    Object localObject1 = this.rbJ;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    localObject1 = ((x.b)localObject1).getRecyclerView().getLayoutManager();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
      AppMethodBeat.o(204673);
      throw ((Throwable)localObject1);
    }
    int i = ((LinearLayoutManager)localObject1).jW();
    Object localObject2;
    label168:
    label192:
    x.b localb;
    if (i <= 3)
    {
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject1 = ((x.b)localObject1).getRecyclerView();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      if (i > 0) {
        break label402;
      }
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      ((x.b)localObject1).uh(200L);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czT())
      {
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = FinderReporterUIC.a.eV((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject1).cGb(), 5, cvi());
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.convert.u.rbM;
      localb = this.rbJ;
      if (localb == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject2 = this.fragment;
      localObject1 = localObject2;
      if (!(localObject2 instanceof FinderHomeTabFragment)) {
        localObject1 = null;
      }
      localObject1 = (FinderHomeTabFragment)localObject1;
      if (localObject1 == null) {
        break label434;
      }
    }
    label402:
    label434:
    for (i = ((FinderHomeTabFragment)localObject1).diw;; i = 0)
    {
      u.a.a(null, localb, i);
      AppMethodBeat.o(204673);
      return;
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject1 = ((x.b)localObject1).getRecyclerView();
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      ((RecyclerView)localObject1).ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      break;
      if (3 < i) {
        break label168;
      }
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      ((x.b)localObject1).uh(600L);
      break label192;
    }
  }
  
  public final void cFW()
  {
    AppMethodBeat.i(204679);
    super.cFW();
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).ET(cvi());
    AppMethodBeat.o(204679);
  }
  
  public final void cvj()
  {
    Object localObject2 = null;
    AppMethodBeat.i(204678);
    super.cvj();
    Object localObject1 = com.tencent.mm.ui.component.a.IrY;
    com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class);
    cvi();
    localObject1 = com.tencent.mm.ui.component.a.IrY;
    ((FinderVideoRecycler)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoRecycler.class)).C((d.g.a.b)FinderTimelineUIC.l.sfl);
    localObject1 = this.rlB;
    if (localObject1 == null) {
      d.g.b.k.aVY("presenter");
    }
    Object localObject3 = ((x.a)localObject1).getVideoCore().rSr;
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
          ((FinderVideoAutoPlayManager)localObject3).e((String)localObject1 + "#onViewFocused", false, true);
        }
      }
    }
    else
    {
      localObject1 = this.rlB;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      localObject1 = ((x.a)localObject1).getActivity();
      if (localObject1 == null) {
        break label566;
      }
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null) {
        break label566;
      }
      bool1 = ((Intent)localObject1).getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
      label214:
      localObject1 = this.rlB;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      localObject1 = ((x.a)localObject1).getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).removeExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB");
        }
      }
      localObject1 = this.rlB;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      ((x.a)localObject1).cvj();
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      boolean bool2 = ((PluginFinder)localObject1).getRedDotManager().Dz(cvi());
      if ((bool1) && (cvi() == 3)) {
        break label571;
      }
      localObject1 = this.rlB;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      ((x.a)localObject1).M(false, true);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if ((com.tencent.mm.plugin.finder.storage.b.czT()) && (bool2))
      {
        localObject1 = FinderReporterUIC.seQ;
        localObject1 = FinderReporterUIC.a.eV((Context)getActivity());
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
          com.tencent.mm.plugin.finder.report.d.a(((FinderReporterUIC)localObject1).cGb(), 6);
        }
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.ui.component.a.IrY;
      localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(getActivity()).get(FinderReporterUIC.class)).Fd(cvi());
      if (localObject1 == null) {
        break label725;
      }
      cvi();
      localObject2 = new com.tencent.mm.plugin.finder.event.base.k();
      localObject3 = this.rbJ;
      if (localObject3 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject3 = ((x.b)localObject3).getRecyclerView();
      localObject4 = ((RecyclerView)localObject3).getLayoutManager();
      if ((localObject4 instanceof LinearLayoutManager))
      {
        int i = ((LinearLayoutManager)localObject4).jW();
        int j = ((LinearLayoutManager)localObject4).jY();
        localObject4 = com.tencent.mm.plugin.finder.utils.n.rPN;
        ((com.tencent.mm.plugin.finder.event.base.k)localObject2).rde = com.tencent.mm.plugin.finder.utils.n.b((RecyclerView)localObject3, i, j, 8).rdD;
      }
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.b)localObject2);
      AppMethodBeat.o(204678);
      return;
      localObject1 = null;
      break;
      label566:
      bool1 = false;
      break label214;
      label571:
      if ((bool1) && (cvi() == 3))
      {
        localObject1 = this.rlB;
        if (localObject1 == null) {
          d.g.b.k.aVY("presenter");
        }
        localObject3 = ((x.a)localObject1).getVideoCore().rSr;
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
          ((FinderVideoAutoPlayManager)localObject3).e((String)localObject1 + "#onAttach", false, true);
        }
        localObject1 = this.rlB;
        if (localObject1 == null) {
          d.g.b.k.aVY("presenter");
        }
        ((x.a)localObject1).M(true, false);
        ac.i("Finder.TimelineUIC", "[onUserVisibleFocused] pass this check");
      }
    }
    label725:
    AppMethodBeat.o(204678);
  }
  
  public final int getLayoutId()
  {
    return 2131494117;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(204676);
    if (fqL())
    {
      locala = this.rlB;
      if (locala == null) {
        d.g.b.k.aVY("presenter");
      }
      boolean bool = locala.onBackPressed();
      AppMethodBeat.o(204676);
      return bool;
    }
    x.a locala = this.rlB;
    if (locala == null) {
      d.g.b.k.aVY("presenter");
    }
    if (!locala.onBackPressed())
    {
      getActivity().finish();
      AppMethodBeat.o(204676);
      return true;
    }
    AppMethodBeat.o(204676);
    return false;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(204670);
    paramBundle = s.qXL;
    s.csj();
    paramBundle = com.tencent.mm.plugin.finder.upload.b.rMB;
    com.tencent.mm.plugin.finder.upload.b.cCr().cCq();
    Object localObject1;
    Object localObject2;
    if (!fqL())
    {
      getActivity().setMMTitle(2131759376);
      getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if ((!com.tencent.mm.plugin.finder.storage.b.cyP()) || (!((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).showPostEntry())) {
        break label667;
      }
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)paramBundle).getRedDotManager().adw("TLCamera");
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      localObject2 = ((PluginFinder)paramBundle).getRedDotManager().adx("TLCamera");
      paramBundle = com.tencent.mm.plugin.finder.utils.n.rPN;
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
        paramBundle = FinderReporterUIC.seQ;
        paramBundle = FinderReporterUIC.a.eV((Context)getActivity());
        if (paramBundle == null) {
          break label662;
        }
        paramBundle = paramBundle.cGb();
        com.tencent.mm.plugin.finder.report.d.a("2", 2, 1, 1, 1, 0, null, null, 0L, paramBundle, 0, 0, 3520);
      }
      getActivity().removeOptionMenu(this.rrs);
      getActivity().addIconOptionMenu(this.rrs, -1, 2131690526, (MenuItem.OnMenuItemClickListener)new b(this, (aon)localObject1, (com.tencent.mm.plugin.finder.extension.reddot.h)localObject2));
      label242:
      getActivity().removeOptionMenu(this.rsq);
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      paramBundle = ((PluginFinder)paramBundle).getRedDotManager().adw("TLPersonalCenter");
      localObject1 = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject1, "MMKernel.plugin(PluginFinder::class.java)");
      localObject1 = ((PluginFinder)localObject1).getRedDotManager().adx("TLPersonalCenter");
      getActivity().addIconOptionMenu(this.rsq, -1, 2131690592, (MenuItem.OnMenuItemClickListener)new c(this, paramBundle, (com.tencent.mm.plugin.finder.extension.reddot.h)localObject1));
      localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
      if ((paramBundle != null) && (localObject1 != null))
      {
        paramBundle = com.tencent.mm.plugin.finder.report.d.rxr;
        localObject1 = ((com.tencent.mm.plugin.finder.extension.reddot.h)localObject1).field_tipsId;
        d.g.b.k.g(localObject1, "ctrInfo.field_tipsId");
        paramBundle = FinderReporterUIC.seQ;
        paramBundle = FinderReporterUIC.a.eV((Context)getActivity());
        if (paramBundle == null) {
          break label718;
        }
      }
    }
    label662:
    label667:
    label718:
    for (paramBundle = paramBundle.cGb();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.d.a("2", 1, 1, 1, 2, 0, (String)localObject1, null, 0L, paramBundle, 0, 0, 3456);
      int i = getIntent().getIntExtra("FROM_SCENE_KEY", 2);
      paramBundle = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramBundle).getRedDotManager().Dw(i);
      localObject2 = getActivity();
      localObject1 = this.fragment;
      paramBundle = (Bundle)localObject1;
      if (!(localObject1 instanceof FinderHomeTabFragment)) {
        paramBundle = null;
      }
      this.rlB = ((x.a)new ag((MMActivity)localObject2, (FinderHomeTabFragment)paramBundle));
      paramBundle = getActivity();
      localObject1 = this.rlB;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      this.rbJ = ((x.b)new ah(paramBundle, (x.a)localObject1, getRootView()));
      paramBundle = this.rlB;
      if (paramBundle == null) {
        d.g.b.k.aVY("presenter");
      }
      localObject1 = this.rbJ;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      paramBundle.cY(localObject1);
      paramBundle = com.tencent.mm.plugin.finder.upload.f.rNg;
      com.tencent.mm.plugin.finder.upload.f.cCv().cCu();
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(104, (com.tencent.mm.plugin.finder.api.e)this);
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(108, (com.tencent.mm.plugin.finder.api.e)this);
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      paramBundle = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
      com.tencent.mm.plugin.finder.extension.reddot.f.a(com.tencent.mm.plugin.finder.extension.reddot.f.ctO(), (LifecycleOwner)getActivity(), (Observer)new j(this));
      AppMethodBeat.o(204670);
      return;
      paramBundle = null;
      break;
      getActivity().removeOptionMenu(this.rsr);
      paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.cyV()) {
        break label242;
      }
      getActivity().addIconOptionMenu(this.rsr, -1, 2131690194, (MenuItem.OnMenuItemClickListener)new d(this));
      break label242;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204681);
    ac.i("Finder.TimelineUIC", "onDestroy");
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(104, (com.tencent.mm.plugin.finder.api.e)this);
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(108, (com.tencent.mm.plugin.finder.api.e)this);
    com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
    Object localObject = this.rlB;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    ((x.a)localObject).onDetach();
    localObject = com.tencent.mm.plugin.finder.model.i.ruE;
    com.tencent.mm.plugin.finder.model.i.release();
    com.tencent.mm.ac.c.b(null, (d.g.a.a)k.sfk);
    if (!fqL())
    {
      localObject = com.tencent.mm.kernel.g.ad(PluginFinder.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)localObject).getRedDotManager().ctH();
    }
    AppMethodBeat.o(204681);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(204680);
    super.onPause();
    if (this.rlB == null) {
      d.g.b.k.aVY("presenter");
    }
    AppMethodBeat.o(204680);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(204677);
    super.onResume();
    Object localObject = this.rlB;
    if (localObject == null) {
      d.g.b.k.aVY("presenter");
    }
    ((x.a)localObject).onUIResume();
    localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
    if (com.tencent.mm.plugin.finder.upload.f.cCw())
    {
      ac.i("Finder.TimelineUIC", "[onResume] shouldScrollToPostingItem");
      localObject = this.rbJ;
      if (localObject == null) {
        d.g.b.k.aVY("viewCallback");
      }
      localObject = ((x.b)localObject).getRecyclerView();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC", "onResume", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      localObject = com.tencent.mm.plugin.finder.upload.f.rNg;
      com.tencent.mm.plugin.finder.upload.f.lO(false);
    }
    AppMethodBeat.o(204677);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(204674);
    ac.i("Finder.TimelineUIC", "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    paramString = this.iPT;
    if (paramString != null) {
      paramString.dismiss();
    }
    if (paramn != null)
    {
      if (paramn.getType() != 3761) {
        break label276;
      }
      com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label259;
      }
      paramString = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramString, "MMKernel.storage()");
      paramInt1 = paramString.agA().getInt(ah.a.GUi, 0);
      ac.i("Finder.TimelineUIC", "userFlag %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 & 0x2) != 0)
      {
        this.rsp = ((aq)paramn).csO();
        com.tencent.mm.ui.base.h.Q((Context)getActivity(), getString(2131759342), "");
        AppMethodBeat.o(204674);
      }
    }
    else
    {
      AppMethodBeat.o(204674);
      return;
    }
    paramString = com.tencent.mm.plugin.finder.utils.n.rPN;
    if (com.tencent.mm.plugin.finder.utils.n.ap((Activity)getActivity()))
    {
      paramString = com.tencent.mm.plugin.finder.utils.n.rPN;
      if (com.tencent.mm.plugin.finder.utils.n.a((Context)getActivity(), getString(2131759369), ((aq)paramn).qYB, this.rsp)) {
        cwh();
      }
    }
    AppMethodBeat.o(204674);
    return;
    label259:
    t.makeText((Context)getActivity(), 2131759307, 1).show();
    label276:
    AppMethodBeat.o(204674);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderTimelineUIC paramFinderTimelineUIC, aon paramaon, com.tencent.mm.plugin.finder.extension.reddot.h paramh) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204649);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
      paramMenuItem = this.rsv;
      com.tencent.mm.plugin.finder.extension.reddot.h localh = this.rsw;
      if ((paramMenuItem != null) && (localh != null))
      {
        paramMenuItem = com.tencent.mm.plugin.finder.report.d.rxr;
        paramMenuItem = FinderReporterUIC.seQ;
        paramMenuItem = FinderReporterUIC.a.eV((Context)this.sfh.getActivity());
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.cGb();
          com.tencent.mm.plugin.finder.report.d.a("2", 2, 2, 1, 1, 0, null, null, 0L, paramMenuItem, 0, 0, 3520);
        }
      }
      else
      {
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.l)paramMenuItem).getRedDotManager().adv("TLCamera");
        if (!bs.isNullOrNil(com.tencent.mm.model.u.axE())) {
          break label321;
        }
        if (FinderTimelineUIC.b(this.sfh) != null) {
          break label186;
        }
        ac.i("Finder.TimelineUIC", "need prepare user");
        paramMenuItem = com.tencent.mm.plugin.finder.extension.reddot.f.rfl;
        paramMenuItem = (f.a)com.tencent.mm.plugin.finder.extension.reddot.f.ctN().getValue();
        if ((paramMenuItem == null) || (paramMenuItem.daU != true)) {
          break label181;
        }
      }
      label181:
      for (boolean bool = true;; bool = false)
      {
        FinderTimelineUIC.a(this.sfh, bool);
        AppMethodBeat.o(204649);
        return true;
        paramMenuItem = null;
        break;
      }
      label186:
      paramMenuItem = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramMenuItem, "MMKernel.storage()");
      int i = paramMenuItem.agA().getInt(ah.a.GUi, 0);
      ac.i("Finder.TimelineUIC", "userFlag %d", new Object[] { Integer.valueOf(i) });
      if ((i & 0x2) != 0) {
        com.tencent.mm.ui.base.h.Q((Context)this.sfh.getActivity(), this.sfh.getString(2131759342), "");
      }
      for (;;)
      {
        AppMethodBeat.o(204649);
        return true;
        paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
        if (com.tencent.mm.plugin.finder.utils.n.ap((Activity)this.sfh.getActivity()))
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
          com.tencent.mm.plugin.finder.utils.n.a((Context)this.sfh.getActivity(), this.sfh.getString(2131759369), FinderTimelineUIC.b(this.sfh));
          continue;
          label321:
          FinderTimelineUIC.c(this.sfh);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderTimelineUIC paramFinderTimelineUIC, aon paramaon, com.tencent.mm.plugin.finder.extension.reddot.h paramh) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204650);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.n.rPN;
      Object localObject = paramBundle;
      paramMenuItem = this.rsy;
      if ((localObject != null) && (paramMenuItem != null))
      {
        localObject = com.tencent.mm.plugin.finder.report.d.rxr;
        localObject = paramMenuItem.field_tipsId;
        d.g.b.k.g(localObject, "ctrInfo.field_tipsId");
        paramMenuItem = FinderReporterUIC.seQ;
        paramMenuItem = FinderReporterUIC.a.eV((Context)this.sfh.getActivity());
        if (paramMenuItem == null) {
          break label141;
        }
      }
      label141:
      for (paramMenuItem = paramMenuItem.cGb();; paramMenuItem = null)
      {
        com.tencent.mm.plugin.finder.report.d.a("2", 1, 2, 1, 2, 0, (String)localObject, null, 0L, paramMenuItem, 0, 0, 3456);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.x((Context)this.sfh.getActivity(), null);
        paramMenuItem = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class);
        d.g.b.k.g(paramMenuItem, "MMKernel.plugin(IPluginFinder::class.java)");
        ((com.tencent.mm.plugin.i.a.l)paramMenuItem).getRedDotManager().adv("TLPersonalCenter");
        AppMethodBeat.o(204650);
        return true;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204652);
      paramMenuItem = new ax();
      paramMenuItem.Qu();
      paramMenuItem.aHZ();
      ac.i("Finder.TimelineUIC", "report18939 postEdu: " + paramMenuItem.Qv());
      paramMenuItem = new com.tencent.mm.plugin.finder.view.c((Context)this.sfh.getActivity());
      paramMenuItem.EP(2131494081);
      Object localObject = (TextView)paramMenuItem.khe.findViewById(2131302882);
      TextView localTextView1 = (TextView)paramMenuItem.khe.findViewById(2131302880);
      TextView localTextView2 = (TextView)paramMenuItem.khe.findViewById(2131302881);
      d.g.b.k.g(localObject, "titleTv");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cyW());
      d.g.b.k.g(localTextView1, "descTv");
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      localTextView1.setText((CharSequence)com.tencent.mm.plugin.finder.storage.b.cyX());
      localTextView2.setOnClickListener((View.OnClickListener)new a(paramMenuItem));
      paramMenuItem.cED();
      AppMethodBeat.o(204652);
      return true;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.plugin.finder.view.c paramc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204651);
        this.rsz.bmi();
        AppMethodBeat.o(204651);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements n.d
  {
    f(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(204655);
      Intent localIntent = new Intent();
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == 1001) {
        localIntent.putExtra("key_finder_post_router", 2);
      }
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 5);
        paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.v((Context)this.sfh.getActivity(), localIntent);
        AppMethodBeat.o(204655);
        return;
        if (paramMenuItem.getItemId() == 1002) {
          localIntent.putExtra("key_finder_post_router", 3);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    public static final g sfj;
    
    static
    {
      AppMethodBeat.i(204657);
      sfj = new g();
      AppMethodBeat.o(204657);
    }
    
    public final void onDismiss()
    {
      AppMethodBeat.i(204656);
      com.tencent.mm.plugin.finder.report.c localc = com.tencent.mm.plugin.finder.report.c.rxi;
      com.tencent.mm.plugin.finder.report.c.DS(6);
      AppMethodBeat.o(204656);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(FinderTimelineUIC paramFinderTimelineUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204659);
      this.sfh.onBackPressed();
      AppMethodBeat.o(204659);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "onChanged"})
  static final class j<T>
    implements Observer<f.a>
  {
    j(FinderTimelineUIC paramFinderTimelineUIC) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final k sfk;
    
    static
    {
      AppMethodBeat.i(204662);
      sfk = new k();
      AppMethodBeat.o(204662);
    }
    
    k()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/viewmodel/component/FinderTimelineUIC$requestInsert$1$1"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(BaseFinderFeed paramBaseFinderFeed, FinderTimelineUIC paramFinderTimelineUIC, long paramLong, int paramInt, boolean paramBoolean, ald paramald)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTimelineUIC
 * JD-Core Version:    0.7.0.1
 */