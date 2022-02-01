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
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.plugin.finder.cgi.m;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.g.a;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.w;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "initPos", "", "selfFlag", "", "cacheKey", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;IZLjava/lang/String;)V", "MENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "getCacheKey", "()Ljava/lang/String;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "getInitPos", "()I", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "scene", "getSelfFlag", "()Z", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getUsername", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "onUIPause", "onUIResume", "removeDataAt", "index", "requestRefresh", "shareFeed", "plugin-finder_release"})
public final class f$b
  implements c, f.a, com.tencent.mm.plugin.finder.presenter.base.a<f.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final com.tencent.mm.plugin.finder.view.f KMN;
  private final d.f KNR;
  private final String TAG;
  final String cacheKey;
  private boolean diE;
  private final int ibt;
  final MMActivity imP;
  private final int nmj;
  private final int nmp;
  private final int qqA;
  private final com.tencent.mm.plugin.finder.video.c qrq;
  private final int qtT;
  private final int qtU;
  private final int qtV;
  private final int qtW;
  private final int qtX;
  private final int qtY;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> quc;
  private final d qvA;
  private final int qvB;
  private final boolean qvC;
  private final d.f qvv;
  private f.c qvw;
  private final com.tencent.mm.plugin.finder.feed.model.e qvy;
  private final c qvz;
  private int scene;
  Dialog tipDialog;
  final String username;
  
  static
  {
    AppMethodBeat.i(165747);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "mediaBannerViewPoolCache", "getMediaBannerViewPoolCache()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;")), (d.l.k)w.a(new d.g.b.u(w.bk(b.class), "feedLoader", "getFeedLoader()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;")) };
    AppMethodBeat.o(165747);
  }
  
  public f$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.f paramf, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(197865);
    this.imP = paramMMActivity;
    this.KMN = paramf;
    this.username = paramString1;
    this.qvB = paramInt;
    this.qvC = paramBoolean;
    this.cacheKey = paramString2;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.qvv = d.g.E((d.g.a.a)q.qvL);
    this.quc = new CopyOnWriteArraySet();
    this.KNR = d.g.E((d.g.a.a)new b(this));
    this.qvy = new com.tencent.mm.plugin.finder.feed.model.e(this.imP);
    if ((this.username.equals(com.tencent.mm.model.u.aqO())) && (this.qvC))
    {
      paramBoolean = true;
      this.diE = paramBoolean;
      if (!this.diE) {
        break label293;
      }
    }
    label293:
    for (paramInt = i;; paramInt = 2)
    {
      this.scene = paramInt;
      this.qtT = 99;
      this.qqA = 100;
      this.nmp = 101;
      this.qtU = 102;
      this.nmj = 103;
      this.qtV = 104;
      this.qtW = 105;
      this.qtX = 106;
      this.qtY = 107;
      this.ibt = 108;
      this.qrq = new com.tencent.mm.plugin.finder.video.c();
      this.qvz = new c(this);
      this.qvA = new d(this);
      AppMethodBeat.o(197865);
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
  
  public final void a(f.c paramc)
  {
    AppMethodBeat.i(165754);
    d.g.b.k.h(paramc, "callback");
    this.qvw = paramc;
    int i;
    if (this.qvC)
    {
      i = 8;
      paramc = fTm();
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
      com.tencent.mm.sdk.b.a.ESL.b((com.tencent.mm.sdk.b.c)this.qvz);
      com.tencent.mm.sdk.b.a.ESL.b((com.tencent.mm.sdk.b.c)this.qvA);
      paramc = this.qrq;
      Object localObject = this.qvw;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      com.tencent.mm.plugin.finder.video.c.a(paramc, ((f.c)localObject).imP, (com.tencent.mm.plugin.finder.video.c.b)new p(this), 4);
      paramc = MediaPreloadCore.KTA;
      DataBuffer localDataBuffer;
      com.tencent.mm.plugin.finder.video.c localc;
      if (MediaPreloadCore.fTP())
      {
        localObject = (TestPreloadPreview)this.imP.findViewById(2131305708);
        if (localObject != null)
        {
          ((TestPreloadPreview)localObject).setVisibility(0);
          localDataBuffer = fTm().getDataListJustForAdapter();
          localc = this.qrq;
          paramc = FinderReporterUIC.Ljl;
          paramc = FinderReporterUIC.a.lB((Context)this.imP);
          if (paramc == null) {
            break label283;
          }
        }
      }
      for (paramc = FinderReporterUIC.a(paramc);; paramc = null)
      {
        ((TestPreloadPreview)localObject).a(localDataBuffer, 0, localc, paramc, -1);
        this.qvy.a(this.scene, i, (d.g.a.b)new s(this));
        paramc = FinderReporterUIC.Ljl;
        paramc = FinderReporterUIC.a.lB((Context)this.imP);
        if (paramc == null) {
          break label288;
        }
        paramc = FinderReporterUIC.a(paramc);
        if (paramc == null) {
          break label288;
        }
        paramc.a((com.tencent.mm.plugin.finder.event.base.f)this.qvy);
        AppMethodBeat.o(165754);
        return;
        i = 1;
        break;
      }
      AppMethodBeat.o(165754);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.feed.model.internal.g paramg)
  {
    AppMethodBeat.i(165758);
    d.g.b.k.h(paramg, "initDone");
    com.tencent.mm.plugin.finder.feed.model.internal.a.initData$default(fTm(), (com.tencent.mm.plugin.finder.feed.model.internal.h)new com.tencent.mm.plugin.finder.feed.model.o(this.username, this.qvB + 10, paramg, fTm().getOldDataList()), false, 2, null);
    AppMethodBeat.o(165758);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(197864);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.LCX;
    localObject = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.imP).get(FinderReporterUIC.class)).fXs();
    p localp = p.qDG;
    p.a((dzp)localObject, paramInt, paramBaseFinderFeed.feedObject, paramBoolean, paramBaseFinderFeed.showLikeTips);
    AppMethodBeat.o(197864);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(197863);
    d.g.b.k.h(paramFinderItem, "feed");
    g.a.a(com.tencent.mm.plugin.finder.utils.g.qSw, this.imP, paramFinderItem);
    AppMethodBeat.o(197863);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165767);
    d.g.b.k.h(paramFinderItem, "feed");
    d.g.b.k.h(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165767);
  }
  
  public final n.c c(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165761);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.c)new f(this, paramBaseFinderFeed);
    AppMethodBeat.o(165761);
    return paramBaseFinderFeed;
  }
  
  public final boolean clH()
  {
    return this.diE;
  }
  
  public final RecyclerView.n clM()
  {
    AppMethodBeat.i(165765);
    RecyclerView.n localn = (RecyclerView.n)this.qvv.getValue();
    AppMethodBeat.o(165765);
    return localn;
  }
  
  public final ArrayList<BaseFinderFeed> clY()
  {
    AppMethodBeat.i(197861);
    ArrayList localArrayList = (ArrayList)fTm().getDataListJustForAdapter();
    AppMethodBeat.o(197861);
    return localArrayList;
  }
  
  public final n.d d(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165762);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.d)new g(this, paramBaseFinderFeed);
    AppMethodBeat.o(165762);
    return paramBaseFinderFeed;
  }
  
  public final void d(FinderItem paramFinderItem, boolean paramBoolean)
  {
    AppMethodBeat.i(197862);
    d.g.b.k.h(paramFinderItem, "feed");
    com.tencent.mm.plugin.finder.model.y localy = com.tencent.mm.plugin.finder.model.y.KTo;
    com.tencent.mm.plugin.finder.model.y.a(this.imP, paramFinderItem, paramBoolean);
    AppMethodBeat.o(197862);
  }
  
  public final int e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    d.g.b.k.h(paramBaseFinderFeed, "feed");
    int i = fTm().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final com.tencent.mm.plugin.finder.view.f fSW()
  {
    return this.KMN;
  }
  
  public final FinderProfileFeedLoader fTm()
  {
    AppMethodBeat.i(197860);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.KNR.getValue();
    AppMethodBeat.o(197860);
    return localFinderProfileFeedLoader;
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  public final com.tencent.mm.plugin.finder.video.c getVideoCore()
  {
    return this.qrq;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    d.g.b.k.h(parama, "p0");
    this.quc.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.qvy.onDetach();
    Object localObject = FinderReporterUIC.Ljl;
    localObject = FinderReporterUIC.a.lB((Context)this.imP);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.d)localObject).b((com.tencent.mm.plugin.finder.event.base.f)this.qvy);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.c.qKo.clearCache();
    localObject = ((Iterable)this.quc).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.quc.clear();
    this.qvw = null;
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.qvz);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.qvA);
    AppMethodBeat.o(165757);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(165729);
      Object localObject = com.tencent.mm.ui.component.a.LCX;
      com.tencent.mm.ui.component.a.s(this.qvD.imP).get(FinderReporterUIC.class);
      switch (paramInt)
      {
      case -1: 
      case 0: 
      case 3: 
      case 5: 
      case 6: 
      default: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((c)this.qvD, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case -2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.k();
        AppMethodBeat.o(165729);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n();
        AppMethodBeat.o(165729);
        return localObject;
      case 4: 
        localObject = (com.tencent.mm.view.recyclerview.b)new r(f.b.d(this.qvD), (c)this.qvD, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.g((c)this.qvD, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.o((c)this.qvD, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 8: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.i(f.b.d(this.qvD), (c)this.qvD, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.l((c)this.qvD, false, 0, 6);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<FinderProfileFeedLoader>
  {
    b(f.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.plugin.finder.view.d
  {
    private String tag;
    
    c()
    {
      AppMethodBeat.i(165733);
      this.tag = f.b.g(localb);
      AppMethodBeat.o(165733);
    }
    
    public final void a(long paramLong, ake paramake)
    {
      AppMethodBeat.i(165732);
      Object localObject1 = f.b.b(this.qvD);
      if (localObject1 != null)
      {
        localObject1 = ((f.c)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramake = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165732);
            throw paramake;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).ln();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new d.o(Integer.valueOf(1), paramake));
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
    
    public final FinderItem pZ(long paramLong)
    {
      AppMethodBeat.i(165731);
      Object localObject = f.b.b(this.qvD);
      if (localObject != null)
      {
        localObject = ((f.c)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165731);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.d.a((com.tencent.mm.view.recyclerview.d)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.v)localObject).ln();
            localObject = (BaseFinderFeed)f.b.c(this.qvD).safeGet(i);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<gx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    e(f.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paraml)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      int i = 0;
      AppMethodBeat.i(165736);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (!f.b.e(this.qvD))
      {
        this.qvD.imP.getString(2131755893);
        localObject1 = this.qvD.imP.getString(2131755892);
        this.qvD.imP.getString(2131758845);
        localObject2 = f.b.g(this.qvD);
        localObject3 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
        ad.i((String)localObject2, com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          if (com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.f.qSs;
            localObject1 = (String)com.tencent.mm.plugin.finder.utils.f.a((Context)this.qvD.imP, paramBaseFinderFeed, f.b.f(this.qvD), (d.g.a.b)new a(this, paraml)).second;
          }
        }
      }
      for (;;)
      {
        paraml.a(f.b.i(this.qvD), (CharSequence)localObject1, 2131689817, 0, bool1);
        do
        {
          paraml = com.tencent.mm.plugin.finder.report.b.qFq;
          long l = paramBaseFinderFeed.bMs();
          paraml = FinderReporterUIC.Ljl;
          paraml = FinderReporterUIC.a.lB((Context)this.qvD.imP);
          if (paraml != null) {
            i = paraml.qqE;
          }
          com.tencent.mm.plugin.finder.report.b.E(l, i);
          paraml = FinderReporterUIC.Ljl;
          paraml = FinderReporterUIC.a.lB((Context)this.qvD.imP);
          if (paraml == null) {
            break label741;
          }
          paraml = FinderReporterUIC.b(paraml);
          if (paraml == null) {
            break label741;
          }
          paraml.fSl().BF(paramBaseFinderFeed.bMs());
          AppMethodBeat.o(165736);
          return;
          if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
            break label752;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
          com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeForward", 2131759344);
          localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
          localObject1 = com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeShare", 2131759345);
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeCollect", 2131759343);
          break;
          d.g.b.k.g(paraml, "menu");
        } while (!paraml.eSQ());
        aj.getContext().getString(2131755893);
        localObject1 = aj.getContext().getString(2131755892);
        aj.getContext().getString(2131758845);
        localObject2 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localObject3 = com.tencent.mm.plugin.finder.utils.i.qTa;
        ad.i("Finder.ProfileTimeLineCovert", com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
          if (com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.f.qSs;
            localObject1 = (String)com.tencent.mm.plugin.finder.utils.f.a((Context)this.qvD.imP, paramBaseFinderFeed, f.b.f(this.qvD), (d.g.a.b)new b(this, paraml)).second;
            bool1 = bool2;
          }
        }
        for (;;)
        {
          paraml.a(f.b.i(this.qvD), (CharSequence)localObject1, 2131689817, 0, bool1);
          break;
          if ((paramBaseFinderFeed.feedObject.isOnlySelfSee()) || (paramBaseFinderFeed.feedObject.isNotShare()))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
            com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeForward", 2131759344);
            localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
            localObject1 = com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeShare", 2131759345);
            localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
            com.tencent.mm.plugin.finder.utils.i.dc("FinderSafeSelfSeeCollect", 2131759343);
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, d.y>
    {
      a(f.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, d.y>
    {
      b(f.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.c
  {
    f(f.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(165737);
      com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
      if ((com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed)) && (f.b.e(this.qvD)))
      {
        paraml.aI(f.b.k(this.qvD), 2131755707, 2131690551);
        if (paramBaseFinderFeed.feedObject.isCommentClose())
        {
          paraml.a(f.b.l(this.qvD), (CharSequence)this.qvD.imP.getString(2131759223), 2131690547);
          AppMethodBeat.o(165737);
          return;
        }
        paraml.a(f.b.m(this.qvD), (CharSequence)this.qvD.imP.getString(2131759210), 2131690190);
        AppMethodBeat.o(165737);
        return;
      }
      locali = com.tencent.mm.plugin.finder.utils.i.qTa;
      if (!com.tencent.mm.plugin.finder.utils.i.k(paramBaseFinderFeed)) {
        paraml.aI(f.b.n(this.qvD), 2131761332, 2131690646);
      }
      AppMethodBeat.o(165737);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(f.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165738);
      if (!f.b.e(this.qvD))
      {
        localb = this.qvD;
        d.g.b.k.g(paramMenuItem, "menuItem");
        f.b.a(localb, paramMenuItem, paramBaseFinderFeed);
        AppMethodBeat.o(165738);
        return;
      }
      f.b localb = this.qvD;
      d.g.b.k.g(paramMenuItem, "menuItem");
      f.b.a(localb, paramMenuItem, paramBaseFinderFeed, (Context)this.qvD.imP);
      AppMethodBeat.o(165738);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    h(f.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.i.a.i<ajx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.i.a.i<ajx>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class k
    implements DialogInterface.OnClickListener
  {
    k(f.b paramb, BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178257);
      paramDialogInterface = com.tencent.mm.model.u.aqO();
      d.g.b.k.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new m(paramDialogInterface, this.qug.feedObject.getId(), this.qug.feedObject.getObjectNonceId());
      Object localObject = this.qvD.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.aeS().a(paramDialogInterface.getType(), (com.tencent.mm.al.g)new com.tencent.mm.al.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(178256);
            if (((paramAnonymousn instanceof m)) && (((m)paramAnonymousn).objectId == paramDialogInterface.objectId)) {
              com.tencent.mm.kernel.g.aeS().b(paramDialogInterface.getType(), (com.tencent.mm.al.g)this);
            }
            paramAnonymousString = this.qvI.qvD.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              com.tencent.mm.ui.base.t.makeText(this.qvI.cjo, 2131766471, 0).show();
            }
            AppMethodBeat.o(178256);
          }
        });
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramDialogInterface);
        AppMethodBeat.o(178257);
        return;
        localObject = this.qvD;
        Context localContext = this.cjo;
        this.cjo.getString(2131755906);
        ((f.b)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b(localContext, this.cjo.getString(2131755936), false, (DialogInterface.OnCancelListener)f.b.k.a.qvH));
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    l(f.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.i.a.i<ajx>
  {
    m(Context paramContext) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.plugin.i.a.i<ajx>
  {
    n(Context paramContext) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class o
    implements com.tencent.mm.plugin.finder.feed.model.internal.g
  {
    public final void call(int paramInt) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.plugin.finder.video.c.b
  {
    public final RecyclerView clN()
    {
      AppMethodBeat.i(165742);
      Object localObject = f.b.b(this.qvD);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = ((f.c)localObject).getRecyclerView();
      AppMethodBeat.o(165742);
      return localObject;
    }
    
    public final DataBuffer<BaseFinderFeed> fSX()
    {
      AppMethodBeat.i(197859);
      DataBuffer localDataBuffer = f.b.c(this.qvD).getDataList();
      AppMethodBeat.o(197859);
      return localDataBuffer;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<RecyclerView.n>
  {
    public static final q qvL;
    
    static
    {
      AppMethodBeat.i(165745);
      qvL = new q();
      AppMethodBeat.o(165745);
    }
    
    q()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    r(f.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    s(f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.f.b
 * JD-Core Version:    0.7.0.1
 */