package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.w;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "selfFlag", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;Z)V", "MENU_ID_CLOSE_COMMENT", "", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "scene", "getSelfFlag", "()Z", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getUsername", "()Ljava/lang/String;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onUIPause", "onUIResume", "removeDataAt", "index", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public final class x$b
  implements h, x.a, com.tencent.mm.plugin.finder.presenter.base.a<x.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  boolean dsB;
  final MMActivity fNT;
  final int iXz;
  final int oyq;
  final int oyw;
  final int rUN;
  final com.tencent.mm.plugin.finder.video.i rWB;
  private final com.tencent.mm.plugin.finder.feed.model.d sbU;
  final int sbW;
  final int sbX;
  final int sbY;
  final int sbZ;
  final int sca;
  final int scb;
  int scene;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> scf;
  private final com.tencent.mm.plugin.finder.view.e sck;
  private final d.f sfl;
  x.c sfm;
  private final d.f sfn;
  final int sfo;
  final int sfp;
  private com.tencent.mm.plugin.finder.view.b sfq;
  private final b sfr;
  private final d sfs;
  private final boolean sft;
  Dialog tipDialog;
  final String username;
  
  public x$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202452);
    this.fNT = paramMMActivity;
    this.sck = parame;
    this.username = paramString;
    this.sft = paramBoolean;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.sfl = d.g.O((d.g.a.a)p.sfB);
    this.scf = new CopyOnWriteArraySet();
    this.sfn = d.g.O((d.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.KEX;
    this.sbU = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderCommentPreloaderUIC.class)).sbU;
    if ((this.username.equals(com.tencent.mm.model.v.aAK())) && (this.sft))
    {
      paramBoolean = true;
      this.dsB = paramBoolean;
      if (!this.dsB) {
        break label288;
      }
    }
    for (;;)
    {
      this.scene = i;
      this.sbW = 99;
      this.rUN = 100;
      this.oyw = 101;
      this.sbX = 102;
      this.oyq = 103;
      this.sbY = 104;
      this.sbZ = 105;
      this.sca = 106;
      this.scb = 107;
      this.iXz = 108;
      this.sfo = 109;
      this.sfp = 110;
      this.rWB = new com.tencent.mm.plugin.finder.video.i();
      this.sfr = new b(this);
      this.sfs = new d(this);
      AppMethodBeat.o(202452);
      return;
      paramBoolean = false;
      break;
      label288:
      i = 2;
    }
  }
  
  public final n.d a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(165760);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    d.g.b.p.h(parame, "sheet");
    paramBaseFinderFeed = (n.d)new e(this, paramBaseFinderFeed, parame);
    AppMethodBeat.o(165760);
    return paramBaseFinderFeed;
  }
  
  public final void a(x.c paramc)
  {
    AppMethodBeat.i(165754);
    d.g.b.p.h(paramc, "callback");
    this.sfm = paramc;
    int i;
    if (this.sft)
    {
      i = 8;
      paramc = cCY();
      if ((paramc instanceof FinderProfileFeedLoader)) {
        break label327;
      }
      paramc = null;
    }
    label315:
    label320:
    label327:
    for (;;)
    {
      if (paramc != null) {
        paramc.setFetchEndCallback((d.g.a.b)new q(this));
      }
      com.tencent.mm.sdk.b.a.IvT.b((com.tencent.mm.sdk.b.c)this.sfr);
      com.tencent.mm.sdk.b.a.IvT.b((com.tencent.mm.sdk.b.c)this.sfs);
      this.sfq = new com.tencent.mm.plugin.finder.view.b((BaseFinderFeedLoader)cCY());
      paramc = this.sfq;
      if (paramc != null) {
        paramc.alive();
      }
      paramc = this.rWB;
      Object localObject = this.sfm;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      com.tencent.mm.plugin.finder.video.i.a(paramc, ((x.c)localObject).fNT, (i.b)new o(this), 4);
      paramc = MediaPreloadCore.stL;
      DataBuffer localDataBuffer;
      com.tencent.mm.plugin.finder.video.i locali;
      if (MediaPreloadCore.cEO())
      {
        localObject = (TestPreloadPreview)this.fNT.findViewById(2131305708);
        if (localObject != null)
        {
          ((TestPreloadPreview)localObject).setVisibility(0);
          localDataBuffer = cCY().getDataListJustForAdapter();
          locali = this.rWB;
          paramc = FinderReporterUIC.tnG;
          paramc = FinderReporterUIC.a.fc((Context)this.fNT);
          if (paramc == null) {
            break label315;
          }
        }
      }
      for (paramc = FinderReporterUIC.a(paramc);; paramc = null)
      {
        ((TestPreloadPreview)localObject).a(localDataBuffer, 0, locali, paramc, -1);
        this.sbU.a(this.scene, i, (d.g.a.b)new r(this));
        paramc = FinderReporterUIC.tnG;
        paramc = FinderReporterUIC.a.fc((Context)this.fNT);
        if (paramc == null) {
          break label320;
        }
        paramc = FinderReporterUIC.a(paramc);
        if (paramc == null) {
          break label320;
        }
        paramc.a((com.tencent.mm.plugin.finder.event.base.d)this.sbU);
        AppMethodBeat.o(165754);
        return;
        i = 1;
        break;
      }
      AppMethodBeat.o(165754);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(202451);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.a.KEX;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fNT).get(FinderReporterUIC.class)).cQZ();
    Object localObject2 = x.stn;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
    x.a((arn)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.p.j(paramBaseFinderFeed.contact));
    AppMethodBeat.o(202451);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(202449);
    d.g.b.p.h(paramFinderItem, "feed");
    m.a.a(com.tencent.mm.plugin.finder.utils.m.sWJ, this.fNT, paramFinderItem, 0, 12);
    AppMethodBeat.o(202449);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165767);
    d.g.b.p.h(paramFinderItem, "feed");
    d.g.b.p.h(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165767);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame)
  {
    AppMethodBeat.i(202448);
    d.g.b.p.h(paramFinderItem, "feed");
    parame = com.tencent.mm.plugin.finder.model.m.ssV;
    com.tencent.mm.plugin.finder.model.m.a(this.fNT, paramFinderItem, paramBoolean);
    AppMethodBeat.o(202448);
  }
  
  public final ArrayList<am> cCS()
  {
    AppMethodBeat.i(202447);
    ArrayList localArrayList = (ArrayList)cCY().getDataListJustForAdapter();
    AppMethodBeat.o(202447);
    return localArrayList;
  }
  
  public final FinderProfileFeedLoader cCY()
  {
    AppMethodBeat.i(202446);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.sfn.getValue();
    AppMethodBeat.o(202446);
    return localFinderProfileFeedLoader;
  }
  
  public final boolean cCl()
  {
    return this.dsB;
  }
  
  public final RecyclerView.n cCr()
  {
    AppMethodBeat.i(165765);
    RecyclerView.n localn = (RecyclerView.n)this.sfl.getValue();
    AppMethodBeat.o(165765);
    return localn;
  }
  
  public final com.tencent.mm.plugin.finder.view.e cCs()
  {
    return this.sck;
  }
  
  public final n.d e(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165761);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.d)new f(this, paramBaseFinderFeed);
    AppMethodBeat.o(165761);
    return paramBaseFinderFeed;
  }
  
  public final n.e f(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165762);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (n.e)new g(this, paramBaseFinderFeed);
    AppMethodBeat.o(165762);
    return paramBaseFinderFeed;
  }
  
  public final void g(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(202450);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    m.a locala = com.tencent.mm.plugin.finder.utils.m.sWJ;
    m.a.a(this.fNT, paramBaseFinderFeed, 4, 4);
    AppMethodBeat.o(202450);
  }
  
  public final MMActivity getActivity()
  {
    return this.fNT;
  }
  
  public final com.tencent.mm.plugin.finder.video.i getVideoCore()
  {
    return this.rWB;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    int i = cCY().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    d.g.b.p.h(parama, "p0");
    this.scf.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.sbU.onDetach();
    Object localObject = FinderReporterUIC.tnG;
    localObject = FinderReporterUIC.a.fc((Context)this.fNT);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.sbU);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.e.sKJ.clearCache();
    localObject = ((Iterable)this.scf).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.scf.clear();
    this.sfm = null;
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.sfr);
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.sfs);
    localObject = this.sfq;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.view.b)localObject).dead();
      AppMethodBeat.o(165757);
      return;
    }
    AppMethodBeat.o(165757);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(165729);
      Object localObject = com.tencent.mm.ui.component.a.KEX;
      com.tencent.mm.ui.component.a.s(this.sfu.fNT).get(FinderReporterUIC.class);
      switch (paramInt)
      {
      default: 
        localObject = (com.tencent.mm.view.recyclerview.b)new k((h)this.sfu, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case -5: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.o();
        AppMethodBeat.o(165729);
        return localObject;
      case -3: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.s();
        AppMethodBeat.o(165729);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (com.tencent.mm.view.recyclerview.b)new w(this.sfu.rWB, (h)this.sfu, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new k((h)this.sfu, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new u((h)this.sfu, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 8: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n(this.sfu.rWB, (h)this.sfu, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.q((h)this.sfu, false, 0, 6);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.view.f
  {
    private String tag;
    
    b()
    {
      AppMethodBeat.i(165733);
      this.tag = localObject.TAG;
      AppMethodBeat.o(165733);
    }
    
    public final void a(long paramLong, aqn paramaqn)
    {
      AppMethodBeat.i(165732);
      Object localObject1 = this.sfu.sfm;
      if (localObject1 != null)
      {
        localObject1 = ((x.c)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramaqn = new d.v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165732);
            throw paramaqn;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lN();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new d.o(Integer.valueOf(1), paramaqn));
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
    
    public final FinderItem wv(long paramLong)
    {
      AppMethodBeat.i(165731);
      Object localObject = this.sfu.sfm;
      if (localObject != null)
      {
        localObject = ((x.c)localObject).getRecyclerView();
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
            int i = ((RecyclerView.w)localObject).lN();
            localObject = (am)this.sfu.cCY().safeGet(i);
            if ((localObject instanceof BaseFinderFeed))
            {
              localObject = ((BaseFinderFeed)localObject).feedObject;
              AppMethodBeat.o(165731);
              return localObject;
            }
          }
        }
      }
      AppMethodBeat.o(165731);
      return null;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<FinderProfileFeedLoader>
  {
    c(x.b paramb)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<he>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    e(x.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paraml)
    {
      int i = 0;
      AppMethodBeat.i(165736);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      boolean bool2;
      boolean bool1;
      if (!this.sfu.dsB)
      {
        localObject1 = this.sfu.fNT.getString(2131755893);
        localObject2 = this.sfu.fNT.getString(2131766851);
        this.sfu.fNT.getString(2131758845);
        localObject3 = this.sfu.TAG;
        localObject4 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sXz;
        ae.i((String)localObject3, com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed))
          {
            localObject1 = j.sWB;
            localObject2 = j.a((Context)this.sfu.fNT, paramBaseFinderFeed, this.sfu.scene, (d.g.a.b)new a(this, paraml));
            localObject1 = (String)((d.t)localObject2).first;
            localObject2 = (String)((d.t)localObject2).second;
            bool2 = true;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        paraml.a(this.sfu.sbX, (CharSequence)localObject1, 2131691565, this.sfu.fNT.getResources().getColor(2131099699), bool1);
        paraml.a(this.sfu.oyq, (CharSequence)localObject2, 2131689817, 0, bool2);
        do
        {
          paraml = com.tencent.mm.plugin.finder.report.i.syT;
          long l = paramBaseFinderFeed.lP();
          paraml = FinderReporterUIC.tnG;
          paraml = FinderReporterUIC.a.fc((Context)this.sfu.fNT);
          if (paraml != null) {
            i = paraml.sch;
          }
          com.tencent.mm.plugin.finder.report.i.J(l, i);
          paraml = FinderReporterUIC.tnG;
          paraml = FinderReporterUIC.a.fc((Context)this.sfu.fNT);
          if (paraml == null) {
            break label883;
          }
          paraml = FinderReporterUIC.b(paraml);
          if (paraml == null) {
            break label883;
          }
          paraml.cAI().wq(paramBaseFinderFeed.lP());
          AppMethodBeat.o(165736);
          return;
          if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
            break label898;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject1 = com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeForward", 2131759344);
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
          localObject2 = com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeShare", 2131759345);
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeCollect", 2131759343);
          bool2 = true;
          bool1 = true;
          break;
          d.g.b.p.g(paraml, "menu");
        } while (!paraml.fCR());
        localObject2 = ak.getContext().getString(2131755893);
        localObject1 = ak.getContext().getString(2131766851);
        ak.getContext().getString(2131758845);
        localObject3 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
        ae.i("Finder.ProfileTimeLineCovert", com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed))
          {
            localObject1 = j.sWB;
            localObject1 = j.a((Context)this.sfu.fNT, paramBaseFinderFeed, this.sfu.scene, (d.g.a.b)new b(this, paraml));
            localObject2 = (String)((d.t)localObject1).first;
            localObject1 = (String)((d.t)localObject1).second;
            bool2 = true;
            bool1 = true;
          }
        }
        for (;;)
        {
          int j = this.sfu.sbX;
          localObject2 = (CharSequence)localObject2;
          localObject3 = ak.getContext();
          d.g.b.p.g(localObject3, "MMApplicationContext.getContext()");
          paraml.a(j, (CharSequence)localObject2, 2131691565, ((Context)localObject3).getResources().getColor(2131099699), bool1);
          paraml.a(this.sfu.oyq, (CharSequence)localObject1, 2131689817, 0, bool2);
          break;
          if ((paramBaseFinderFeed.feedObject.isOnlySelfSee()) || (paramBaseFinderFeed.feedObject.isNotShare()))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeForward", 2131759344);
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
            localObject1 = com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeShare", 2131759345);
            localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
            com.tencent.mm.plugin.finder.utils.p.dC("FinderSafeSelfSeeCollect", 2131759343);
            bool2 = true;
            bool1 = true;
            continue;
            label883:
            AppMethodBeat.o(165736);
          }
          else
          {
            bool2 = false;
            bool1 = false;
          }
        }
        label898:
        bool2 = false;
        bool1 = false;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, z>
    {
      a(x.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, z>
    {
      b(x.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.d
  {
    f(x.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      boolean bool = true;
      AppMethodBeat.i(165737);
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      if ((com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed)) && (this.sfu.dsB))
      {
        paraml.aM(this.sfu.iXz, 2131755707, 2131690551);
        int i;
        int j;
        if (paramBaseFinderFeed.feedObject.isCommentClose())
        {
          paraml.a(this.sfu.scb, (CharSequence)this.sfu.fNT.getString(2131759223), 2131690547);
          localObject = com.tencent.mm.plugin.finder.utils.l.sWI;
          d.g.b.p.g(paraml, "menu");
          localObject = (Context)this.sfu.fNT;
          paramBaseFinderFeed.feedObject.getMediaType();
          i = this.sfu.sfp;
          j = this.sfu.sfo;
          if (paramBaseFinderFeed.feedObject.getPrivate_flag() != 1) {
            break label203;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.finder.utils.l.a(paraml, (Context)localObject, i, j, bool);
          AppMethodBeat.o(165737);
          return;
          paraml.a(this.sfu.sca, (CharSequence)this.sfu.fNT.getString(2131759210), 2131690190);
          break;
          label203:
          bool = false;
        }
      }
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (!com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed)) {
        paraml.aM(this.sfu.oyw, 2131761332, 2131690646);
      }
      AppMethodBeat.o(165737);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(x.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(165738);
      if (!this.sfu.dsB)
      {
        localObject1 = this.sfu;
        d.g.b.p.g(paramMenuItem, "menuItem");
        localObject2 = paramBaseFinderFeed;
        ae.i(((x.b)localObject1).TAG, "getMoreMenuItemSelectedListener feed " + localObject2 + " menuItem:" + paramMenuItem.getItemId());
        paramInt = paramMenuItem.getItemId();
        if (paramInt == ((x.b)localObject1).sbW)
        {
          paramInt = ((x.b)localObject1).cCY().getDataListJustForAdapter().indexOf(localObject2);
          if (paramInt >= 0)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.b.sjF;
            com.tencent.mm.plugin.finder.feed.logic.b.a((Context)((x.b)localObject1).fNT, ((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), (d.g.a.b)new x.b.h((x.b)localObject1, (BaseFinderFeed)localObject2));
            AppMethodBeat.o(165738);
            return;
          }
          ae.i(((x.b)localObject1).TAG, "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt != ((x.b)localObject1).rUN)
        {
          if (paramInt == ((x.b)localObject1).sbX)
          {
            m.a.a(com.tencent.mm.plugin.finder.utils.m.sWJ, ((x.b)localObject1).fNT, ((BaseFinderFeed)localObject2).feedObject, 3, 4);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).oyq)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.utils.m.sWJ;
            m.a.a(((x.b)localObject1).fNT, (BaseFinderFeed)localObject2, 0, 12);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).sbY)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.utils.d.sWi;
            com.tencent.mm.plugin.finder.utils.d.a((BaseFinderFeed)localObject2, ((x.b)localObject1).fNT);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).oyw)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.sjE;
            com.tencent.mm.plugin.finder.feed.logic.a.i((Context)((x.b)localObject1).fNT, ((BaseFinderFeed)localObject2).feedObject.field_id);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).sbZ)
          {
            localObject3 = new Intent();
            paramMenuItem = ((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectDesc;
            if (paramMenuItem != null) {}
            for (paramMenuItem = paramMenuItem.toByteArray();; paramMenuItem = null)
            {
              ((Intent)localObject3).putExtra("postRefMediaList", paramMenuItem);
              paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
              ((Intent)localObject3).putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.p.n((BaseFinderFeed)localObject2).toByteArray());
              ((Intent)localObject3).putExtra("postType", ((BaseFinderFeed)localObject2).feedObject.getMediaType());
              ((Intent)localObject3).putExtra("key_finder_post_from", 5);
              paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
              com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)((x.b)localObject1).fNT, (Intent)localObject3);
              AppMethodBeat.o(165738);
              return;
            }
          }
          if (paramInt == ((x.b)localObject1).scb)
          {
            ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getFeedObject(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.s)new x.b.i((x.b)localObject1));
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).sca) {
            ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getFeedObject(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.s)new x.b.j((x.b)localObject1));
          }
        }
        AppMethodBeat.o(165738);
        return;
      }
      Object localObject4 = this.sfu;
      d.g.b.p.g(paramMenuItem, "menuItem");
      BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
      Object localObject3 = (Context)this.sfu.fNT;
      paramInt = paramMenuItem.getItemId();
      if (paramInt == ((x.b)localObject4).sbX)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.m.sWJ;
        if (localObject3 == null)
        {
          paramMenuItem = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165738);
          throw paramMenuItem;
        }
        m.a.a(paramMenuItem, (MMActivity)localObject3, localBaseFinderFeed.feedObject, 3, 4);
        AppMethodBeat.o(165738);
        return;
      }
      if (paramInt == ((x.b)localObject4).oyq)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.m.sWJ;
        if (localObject3 == null)
        {
          paramMenuItem = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165738);
          throw paramMenuItem;
        }
        m.a.a((MMActivity)localObject3, localBaseFinderFeed, 0, 12);
        AppMethodBeat.o(165738);
        return;
      }
      if (paramInt == ((x.b)localObject4).iXz)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
        if ((com.tencent.mm.plugin.finder.utils.p.d(localBaseFinderFeed)) && (localBaseFinderFeed.feedObject.isPostFinish()))
        {
          com.tencent.mm.ui.base.h.a((Context)localObject3, 2131759309, 0, (DialogInterface.OnClickListener)new x.b.k((x.b)localObject4, localBaseFinderFeed, (Context)localObject3), null);
          AppMethodBeat.o(165738);
        }
      }
      else if (paramInt == ((x.b)localObject4).sbW)
      {
        if (((x.b)localObject4).h(localBaseFinderFeed) >= 0)
        {
          localObject2 = ((x.b)localObject4).sfm;
          paramMenuItem = (MenuItem)localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((x.c)localObject2).getRecyclerView();
            paramMenuItem = (MenuItem)localObject1;
            if (localObject2 != null) {
              paramMenuItem = ((RecyclerView)localObject2).getAdapter();
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.feed.logic.b.sjF;
          com.tencent.mm.plugin.finder.feed.logic.b.a((Context)localObject3, localBaseFinderFeed.feedObject.getId(), localBaseFinderFeed.feedObject.getObjectNonceId(), (d.g.a.b)new x.b.l((x.b)localObject4, localBaseFinderFeed, paramMenuItem));
          AppMethodBeat.o(165738);
        }
      }
      else
      {
        if (paramInt == ((x.b)localObject4).oyw)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.sjE;
          com.tencent.mm.plugin.finder.feed.logic.a.i((Context)localObject3, localBaseFinderFeed.feedObject.field_id);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject4).scb)
        {
          ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(localBaseFinderFeed.feedObject.getId(), localBaseFinderFeed.feedObject.getFeedObject(), localBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.s)new x.b.m((Context)localObject3));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject4).sca)
        {
          ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(localBaseFinderFeed.feedObject.getId(), localBaseFinderFeed.feedObject.getFeedObject(), localBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.s)new x.b.n((Context)localObject3));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject4).sfp)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.l.sWI;
          com.tencent.mm.plugin.finder.utils.l.a((Context)localObject3, localBaseFinderFeed.feedObject, false);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject4).sfo)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.l.sWI;
          com.tencent.mm.plugin.finder.utils.l.a((Context)localObject3, localBaseFinderFeed.feedObject, true);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject4).sbZ)
        {
          localObject1 = new Intent();
          localObject4 = localBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          paramMenuItem = (MenuItem)localObject2;
          if (localObject4 != null) {
            paramMenuItem = ((FinderObjectDesc)localObject4).toByteArray();
          }
          ((Intent)localObject1).putExtra("postRefMediaList", paramMenuItem);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sXz;
          ((Intent)localObject1).putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.p.n(localBaseFinderFeed).toByteArray());
          ((Intent)localObject1).putExtra("postType", localBaseFinderFeed.feedObject.getMediaType());
          ((Intent)localObject1).putExtra("key_finder_post_from", 5);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)localObject3, (Intent)localObject1);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject4).sbY)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.d.sWi;
          if (localObject3 == null)
          {
            paramMenuItem = new d.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(165738);
            throw paramMenuItem;
          }
          com.tencent.mm.plugin.finder.utils.d.a(localBaseFinderFeed, (MMActivity)localObject3);
          AppMethodBeat.o(165738);
          return;
        }
        Toast.makeText((Context)localObject3, 2131759377, 1).show();
      }
      AppMethodBeat.o(165738);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    h(x.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.i.a.s<aqa>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.i.a.s<aqa>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class k
    implements DialogInterface.OnClickListener
  {
    k(x.b paramb, BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178257);
      paramDialogInterface = com.tencent.mm.model.v.aAK();
      d.g.b.p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new ab(paramDialogInterface, this.rXB.feedObject.getId(), this.rXB.feedObject.getObjectNonceId());
      Object localObject = this.sfu.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.ajj().a(paramDialogInterface.getType(), (com.tencent.mm.ak.f)new com.tencent.mm.ak.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(178256);
            if (((paramAnonymousn instanceof ab)) && (((ab)paramAnonymousn).rRn == paramDialogInterface.rRn)) {
              com.tencent.mm.kernel.g.ajj().b(paramDialogInterface.getType(), (com.tencent.mm.ak.f)this);
            }
            paramAnonymousString = this.sfz.sfu.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              com.tencent.mm.ui.base.t.makeText(this.sfz.crf, 2131766485, 0).show();
            }
            AppMethodBeat.o(178256);
          }
        });
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)paramDialogInterface);
        AppMethodBeat.o(178257);
        return;
        localObject = this.sfu;
        Context localContext = this.crf;
        this.crf.getString(2131755906);
        ((x.b)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b(localContext, this.crf.getString(2131755936), false, (DialogInterface.OnCancelListener)x.b.k.a.sfy));
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    l(x.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class o
    implements i.b
  {
    public final RecyclerView cCt()
    {
      AppMethodBeat.i(165742);
      Object localObject = this.sfu.sfm;
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      localObject = ((x.c)localObject).getRecyclerView();
      AppMethodBeat.o(165742);
      return localObject;
    }
    
    public final DataBuffer<am> cCu()
    {
      AppMethodBeat.i(202443);
      DataBuffer localDataBuffer = this.sfu.cCY().getDataList();
      AppMethodBeat.o(202443);
      return localDataBuffer;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<RecyclerView.n>
  {
    public static final p sfB;
    
    static
    {
      AppMethodBeat.i(165745);
      sfB = new p();
      AppMethodBeat.o(165745);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.b<IResponse<am>, z>
  {
    q(x.b paramb)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
  static final class r
    extends d.g.b.q
    implements d.g.a.b<Integer, BaseFinderFeed>
  {
    r(x.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x.b
 * JD-Core Version:    0.7.0.1
 */