package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.plugin.finder.convert.j;
import com.tencent.mm.plugin.finder.convert.m;
import com.tencent.mm.plugin.finder.convert.p;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.w;
import d.o;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "initPos", "", "selfFlag", "", "cacheKey", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;IZLjava/lang/String;)V", "MENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "getCacheKey", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "getInitPos", "()I", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "scene", "getSelfFlag", "()Z", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getUsername", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "onUIPause", "onUIResume", "removeDataAt", "index", "requestRefresh", "shareFeed", "plugin-finder_release"})
public final class t$b
  implements g, t.a, com.tencent.mm.plugin.finder.presenter.base.a<t.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  final String cacheKey;
  private boolean dfZ;
  private final int iBw;
  final MMActivity iMV;
  private final int nPj;
  private final int nPp;
  private final int raj;
  private final com.tencent.mm.plugin.finder.video.i rbo;
  private final com.tencent.mm.plugin.finder.feed.model.c rfE;
  private final int rfG;
  private final int rfH;
  private final int rfI;
  private final int rfJ;
  private final int rfK;
  private final int rfL;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rfP;
  private final com.tencent.mm.plugin.finder.view.d rfU;
  private final int rht;
  private final d.f riq;
  private t.c rir;
  private final d.f ris;
  private final b rit;
  private final d riu;
  private final boolean riv;
  private int scene;
  Dialog tipDialog;
  final String username;
  
  static
  {
    AppMethodBeat.i(165747);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "mediaBannerViewPoolCache", "getMediaBannerViewPoolCache()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;")), (d.l.k)w.a(new d.g.b.u(w.bn(b.class), "feedLoader", "getFeedLoader()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;")) };
    AppMethodBeat.o(165747);
  }
  
  public t$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.d paramd, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(201762);
    this.iMV = paramMMActivity;
    this.rfU = paramd;
    this.username = paramString1;
    this.rht = paramInt;
    this.riv = paramBoolean;
    this.cacheKey = paramString2;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.riq = d.g.K((d.g.a.a)q.riD);
    this.rfP = new CopyOnWriteArraySet();
    this.ris = d.g.K((d.g.a.a)new c(this));
    this.rfE = new com.tencent.mm.plugin.finder.feed.model.c(this.iMV);
    if ((this.username.equals(com.tencent.mm.model.u.axE())) && (this.riv))
    {
      paramBoolean = true;
      this.dfZ = paramBoolean;
      if (!this.dfZ) {
        break label293;
      }
    }
    label293:
    for (paramInt = i;; paramInt = 2)
    {
      this.scene = paramInt;
      this.rfG = 99;
      this.raj = 100;
      this.nPp = 101;
      this.rfH = 102;
      this.nPj = 103;
      this.rfI = 104;
      this.rfJ = 105;
      this.rfK = 106;
      this.rfL = 107;
      this.iBw = 108;
      this.rbo = new com.tencent.mm.plugin.finder.video.i();
      this.rit = new b(this);
      this.riu = new d(this);
      AppMethodBeat.o(201762);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public final n.c a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(165760);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    d.g.b.k.h(parame, "sheet");
    paramBaseFinderFeed = (n.c)new e(this, paramBaseFinderFeed, parame);
    AppMethodBeat.o(165760);
    return paramBaseFinderFeed;
  }
  
  public final void a(com.tencent.mm.plugin.finder.feed.model.internal.f paramf)
  {
    AppMethodBeat.i(165758);
    d.g.b.k.h(paramf, "initDone");
    com.tencent.mm.plugin.finder.feed.model.internal.a.initData$default(cuV(), (com.tencent.mm.plugin.finder.feed.model.internal.g)new com.tencent.mm.plugin.finder.feed.model.t(this.username, this.rht + 10, paramf, cuV().getOldDataList()), false, 2, null);
    AppMethodBeat.o(165758);
  }
  
  public final void a(t.c paramc)
  {
    AppMethodBeat.i(165754);
    d.g.b.k.h(paramc, "callback");
    this.rir = paramc;
    int i;
    if (this.riv)
    {
      i = 8;
      paramc = cuV();
      if ((paramc instanceof FinderProfileFeedLoader)) {
        break label295;
      }
      paramc = null;
    }
    label283:
    label288:
    label295:
    for (;;)
    {
      if (paramc != null) {
        paramc.setFetchEndCallback((d.g.a.a)new r(this));
      }
      com.tencent.mm.sdk.b.a.GpY.b((com.tencent.mm.sdk.b.c)this.rit);
      com.tencent.mm.sdk.b.a.GpY.b((com.tencent.mm.sdk.b.c)this.riu);
      paramc = this.rbo;
      Object localObject = this.rir;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      com.tencent.mm.plugin.finder.video.i.a(paramc, ((t.c)localObject).iMV, (i.b)new p(this), 4);
      paramc = MediaPreloadCore.rvo;
      DataBuffer localDataBuffer;
      com.tencent.mm.plugin.finder.video.i locali;
      if (MediaPreloadCore.cwJ())
      {
        localObject = (TestPreloadPreview)this.iMV.findViewById(2131305708);
        if (localObject != null)
        {
          ((TestPreloadPreview)localObject).setVisibility(0);
          localDataBuffer = cuV().getDataListJustForAdapter();
          locali = this.rbo;
          paramc = FinderReporterUIC.seQ;
          paramc = FinderReporterUIC.a.eV((Context)this.iMV);
          if (paramc == null) {
            break label283;
          }
        }
      }
      for (paramc = FinderReporterUIC.a(paramc);; paramc = null)
      {
        ((TestPreloadPreview)localObject).a(localDataBuffer, 0, locali, paramc, -1);
        this.rfE.a(this.scene, i, (d.g.a.b)new s(this));
        paramc = FinderReporterUIC.seQ;
        paramc = FinderReporterUIC.a.eV((Context)this.iMV);
        if (paramc == null) {
          break label288;
        }
        paramc = FinderReporterUIC.a(paramc);
        if (paramc == null) {
          break label288;
        }
        paramc.a((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
        AppMethodBeat.o(165754);
        return;
        i = 1;
        break;
      }
      AppMethodBeat.o(165754);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(201761);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.IrY;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q(this.iMV).get(FinderReporterUIC.class)).cGb();
    com.tencent.mm.plugin.finder.model.u localu = com.tencent.mm.plugin.finder.model.u.ruV;
    com.tencent.mm.plugin.finder.model.u.a((anm)localObject, paramInt, paramBaseFinderFeed.feedObject, paramBoolean, paramBaseFinderFeed.showLikeTips);
    AppMethodBeat.o(201761);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(201760);
    d.g.b.k.h(paramFinderItem, "feed");
    k.a.a(com.tencent.mm.plugin.finder.utils.k.rPa, this.iMV, paramFinderItem);
    AppMethodBeat.o(201760);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165767);
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165767);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(201759);
    d.g.b.k.h(paramFinderItem, "feed");
    com.tencent.mm.plugin.finder.model.k localk = com.tencent.mm.plugin.finder.model.k.ruF;
    com.tencent.mm.plugin.finder.model.k.a(this.iMV, paramFinderItem, paramBoolean);
    AppMethodBeat.o(201759);
  }
  
  public final ArrayList<BaseFinderFeed> cuP()
  {
    AppMethodBeat.i(201758);
    ArrayList localArrayList = (ArrayList)cuV().getDataListJustForAdapter();
    AppMethodBeat.o(201758);
    return localArrayList;
  }
  
  public final FinderProfileFeedLoader cuV()
  {
    AppMethodBeat.i(201757);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.ris.getValue();
    AppMethodBeat.o(201757);
    return localFinderProfileFeedLoader;
  }
  
  public final boolean cuq()
  {
    return this.dfZ;
  }
  
  public final RecyclerView.n cuu()
  {
    AppMethodBeat.i(165765);
    RecyclerView.n localn = (RecyclerView.n)this.riq.getValue();
    AppMethodBeat.o(165765);
    return localn;
  }
  
  public final com.tencent.mm.plugin.finder.view.d cuv()
  {
    return this.rfU;
  }
  
  public final n.c d(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165761);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.c)new f(this, paramBaseFinderFeed);
    AppMethodBeat.o(165761);
    return paramBaseFinderFeed;
  }
  
  public final n.d e(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165762);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.d)new g(this, paramBaseFinderFeed);
    AppMethodBeat.o(165762);
    return paramBaseFinderFeed;
  }
  
  public final int f(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    int i = cuV().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final MMActivity getActivity()
  {
    return this.iMV;
  }
  
  public final com.tencent.mm.plugin.finder.video.i getVideoCore()
  {
    return this.rbo;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    d.g.b.k.h(parama, "p0");
    this.rfP.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.rfE.onDetach();
    Object localObject = FinderReporterUIC.seQ;
    localObject = FinderReporterUIC.a.eV((Context)this.iMV);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.rfE);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.e.rEI.clearCache();
    localObject = ((Iterable)this.rfP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.rfP.clear();
    this.rir = null;
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.rit);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.riu);
    AppMethodBeat.o(165757);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(165729);
      Object localObject = com.tencent.mm.ui.component.a.IrY;
      com.tencent.mm.ui.component.a.q(this.riw.iMV).get(FinderReporterUIC.class);
      switch (paramInt)
      {
      case -1: 
      case 0: 
      case 3: 
      case 5: 
      case 6: 
      default: 
        localObject = (com.tencent.mm.view.recyclerview.b)new j((g)this.riw, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n();
        AppMethodBeat.o(165729);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new r();
        AppMethodBeat.o(165729);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.v(t.b.d(this.riw), (g)this.riw, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new j((g)this.riw, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.t((g)this.riw, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 8: 
        localObject = (com.tencent.mm.view.recyclerview.b)new m(t.b.d(this.riw), (g)this.riw, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.b)new p((g)this.riw, false, 0, 6);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.view.e
  {
    private String tag;
    
    b()
    {
      AppMethodBeat.i(165733);
      this.tag = t.b.f(localb);
      AppMethodBeat.o(165733);
    }
    
    public final void a(long paramLong, amp paramamp)
    {
      AppMethodBeat.i(165732);
      Object localObject1 = t.b.b(this.riw);
      if (localObject1 != null)
      {
        localObject1 = ((t.c)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramamp = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165732);
            throw paramamp;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lv();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new o(Integer.valueOf(1), paramamp));
              AppMethodBeat.o(165732);
              return;
            }
            AppMethodBeat.o(165732);
            return;
          }
          AppMethodBeat.o(165732);
          return;
        }
      }
      AppMethodBeat.o(165732);
    }
    
    public final String getTag()
    {
      return this.tag;
    }
    
    public final FinderItem uf(long paramLong)
    {
      AppMethodBeat.i(165731);
      Object localObject = t.b.b(this.riw);
      if (localObject != null)
      {
        localObject = ((t.c)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165731);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.w)localObject).lv();
            localObject = (BaseFinderFeed)t.b.c(this.riw).safeGet(i);
            if (localObject != null)
            {
              localObject = ((BaseFinderFeed)localObject).feedObject;
              AppMethodBeat.o(165731);
              return localObject;
            }
            AppMethodBeat.o(165731);
            return null;
          }
        }
      }
      AppMethodBeat.o(165731);
      return null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<FinderProfileFeedLoader>
  {
    c(t.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<gz>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    e(t.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paraml)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      int i = 0;
      AppMethodBeat.i(165736);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (!t.b.e(this.riw))
      {
        this.riw.iMV.getString(2131755893);
        localObject1 = this.riw.iMV.getString(2131755892);
        this.riw.iMV.getString(2131758845);
        localObject2 = t.b.f(this.riw);
        localObject3 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
        ac.i((String)localObject2, com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
          if (com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.i.rOT;
            localObject1 = (String)com.tencent.mm.plugin.finder.utils.i.a((Context)this.riw.iMV, paramBaseFinderFeed, t.b.g(this.riw), (d.g.a.b)new a(this, paraml)).second;
          }
        }
      }
      for (;;)
      {
        paraml.a(t.b.h(this.riw), (CharSequence)localObject1, 2131689817, 0, bool1);
        do
        {
          paraml = com.tencent.mm.plugin.finder.report.d.rxr;
          long l = paramBaseFinderFeed.lx();
          paraml = FinderReporterUIC.seQ;
          paraml = FinderReporterUIC.a.eV((Context)this.riw.iMV);
          if (paraml != null) {
            i = paraml.rfR;
          }
          com.tencent.mm.plugin.finder.report.d.H(l, i);
          paraml = FinderReporterUIC.seQ;
          paraml = FinderReporterUIC.a.eV((Context)this.riw.iMV);
          if (paraml == null) {
            break label741;
          }
          paraml = FinderReporterUIC.b(paraml);
          if (paraml == null) {
            break label741;
          }
          paraml.ctb().ud(paramBaseFinderFeed.lx());
          AppMethodBeat.o(165736);
          return;
          if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
            break label752;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
          com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeForward", 2131759344);
          localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
          localObject1 = com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeShare", 2131759345);
          localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
          com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeCollect", 2131759343);
          break;
          d.g.b.k.g(paraml, "menu");
        } while (!paraml.fiA());
        ai.getContext().getString(2131755893);
        localObject1 = ai.getContext().getString(2131755892);
        ai.getContext().getString(2131758845);
        localObject2 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localObject3 = com.tencent.mm.plugin.finder.utils.n.rPN;
        ac.i("Finder.ProfileTimeLineCovert", com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
          if (com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.i.rOT;
            localObject1 = (String)com.tencent.mm.plugin.finder.utils.i.a((Context)this.riw.iMV, paramBaseFinderFeed, t.b.g(this.riw), (d.g.a.b)new b(this, paraml)).second;
            bool1 = bool2;
          }
        }
        for (;;)
        {
          paraml.a(t.b.h(this.riw), (CharSequence)localObject1, 2131689817, 0, bool1);
          break;
          if ((paramBaseFinderFeed.feedObject.isOnlySelfSee()) || (paramBaseFinderFeed.feedObject.isNotShare()))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
            com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeForward", 2131759344);
            localObject1 = com.tencent.mm.plugin.finder.utils.n.rPN;
            localObject1 = com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeShare", 2131759345);
            localObject2 = com.tencent.mm.plugin.finder.utils.n.rPN;
            com.tencent.mm.plugin.finder.utils.n.dh("FinderSafeSelfSeeCollect", 2131759343);
            bool1 = bool2;
            continue;
            label741:
            AppMethodBeat.o(165736);
          }
          else
          {
            bool1 = false;
          }
        }
        label752:
        bool1 = false;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, y>
    {
      a(t.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, y>
    {
      b(t.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.c
  {
    f(t.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165737);
      com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      if ((com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed)) && (t.b.e(this.riw)))
      {
        paraml.aJ(t.b.i(this.riw), 2131755707, 2131690551);
        if (paramBaseFinderFeed.feedObject.isCommentClose())
        {
          paraml.a(t.b.j(this.riw), (CharSequence)this.riw.iMV.getString(2131759223), 2131690547);
          AppMethodBeat.o(165737);
          return;
        }
        paraml.a(t.b.k(this.riw), (CharSequence)this.riw.iMV.getString(2131759210), 2131690190);
        AppMethodBeat.o(165737);
        return;
      }
      localn = com.tencent.mm.plugin.finder.utils.n.rPN;
      if (!com.tencent.mm.plugin.finder.utils.n.l(paramBaseFinderFeed)) {
        paraml.aJ(t.b.l(this.riw), 2131761332, 2131690646);
      }
      AppMethodBeat.o(165737);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(t.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165738);
      if (!t.b.e(this.riw))
      {
        localb = this.riw;
        d.g.b.k.g(paramMenuItem, "menuItem");
        t.b.a(localb, paramMenuItem, paramBaseFinderFeed);
        AppMethodBeat.o(165738);
        return;
      }
      t.b localb = this.riw;
      d.g.b.k.g(paramMenuItem, "menuItem");
      t.b.a(localb, paramMenuItem, paramBaseFinderFeed, (Context)this.riw.iMV);
      AppMethodBeat.o(165738);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    h(t.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.i.a.k<amg>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.i.a.k<amg>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class k
    implements DialogInterface.OnClickListener
  {
    k(t.b paramb, BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178257);
      paramDialogInterface = com.tencent.mm.model.u.axE();
      d.g.b.k.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new com.tencent.mm.plugin.finder.cgi.v(paramDialogInterface, this.rce.feedObject.getId(), this.rce.feedObject.getObjectNonceId());
      Object localObject = this.riw.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.agi().a(paramDialogInterface.getType(), (com.tencent.mm.ak.g)new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(178256);
            if (((paramAnonymousn instanceof com.tencent.mm.plugin.finder.cgi.v)) && (((com.tencent.mm.plugin.finder.cgi.v)paramAnonymousn).qXP == paramDialogInterface.qXP)) {
              com.tencent.mm.kernel.g.agi().b(paramDialogInterface.getType(), (com.tencent.mm.ak.g)this);
            }
            paramAnonymousString = this.riB.riw.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              com.tencent.mm.ui.base.t.makeText(this.riB.cgl, 2131766485, 0).show();
            }
            AppMethodBeat.o(178256);
          }
        });
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramDialogInterface);
        AppMethodBeat.o(178257);
        return;
        localObject = this.riw;
        Context localContext = this.cgl;
        this.cgl.getString(2131755906);
        ((t.b)localObject).tipDialog = ((Dialog)h.b(localContext, this.cgl.getString(2131755936), false, (DialogInterface.OnCancelListener)t.b.k.a.riA));
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    l(t.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.i.a.k<amg>
  {
    m(Context paramContext) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.plugin.i.a.k<amg>
  {
    n(Context paramContext) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class o
    implements com.tencent.mm.plugin.finder.feed.model.internal.f
  {
    public final void call(int paramInt) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class p
    implements i.b
  {
    public final RecyclerView cuw()
    {
      AppMethodBeat.i(165742);
      Object localObject = t.b.b(this.riw);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = ((t.c)localObject).getRecyclerView();
      AppMethodBeat.o(165742);
      return localObject;
    }
    
    public final DataBuffer<BaseFinderFeed> cux()
    {
      AppMethodBeat.i(201756);
      DataBuffer localDataBuffer = t.b.c(this.riw).getDataList();
      AppMethodBeat.o(201756);
      return localDataBuffer;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<RecyclerView.n>
  {
    public static final q riD;
    
    static
    {
      AppMethodBeat.i(165745);
      riD = new q();
      AppMethodBeat.o(165745);
    }
    
    q()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    r(t.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    s(t.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.t.b
 * JD-Core Version:    0.7.0.1
 */