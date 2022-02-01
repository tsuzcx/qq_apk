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
import com.tencent.mm.g.a.hd;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.convert.k;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.plugin.finder.video.i.b;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "selfFlag", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;Z)V", "MENU_ID_CLOSE_COMMENT", "", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "scene", "getSelfFlag", "()Z", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getUsername", "()Ljava/lang/String;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onUIPause", "onUIResume", "removeDataAt", "index", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public final class x$b
  implements h, x.a, com.tencent.mm.plugin.finder.presenter.base.a<x.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  boolean drv;
  final MMActivity fLP;
  final int iUG;
  final int orP;
  final int orV;
  final int rMA;
  final i rOe;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> rTB;
  private final com.tencent.mm.plugin.finder.view.e rTG;
  private final com.tencent.mm.plugin.finder.feed.model.d rTq;
  final int rTs;
  final int rTt;
  final int rTu;
  final int rTv;
  final int rTw;
  final int rTx;
  private final d.f rWA;
  x.c rWB;
  private final d.f rWC;
  final int rWD;
  final int rWE;
  private com.tencent.mm.plugin.finder.view.b rWF;
  private final b rWG;
  private final d rWH;
  private final boolean rWI;
  int scene;
  Dialog tipDialog;
  final String username;
  
  public x$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(201988);
    this.fLP = paramMMActivity;
    this.rTG = parame;
    this.username = paramString;
    this.rWI = paramBoolean;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.rWA = d.g.O((d.g.a.a)p.rWQ);
    this.rTB = new CopyOnWriteArraySet();
    this.rWC = d.g.O((d.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.KiD;
    this.rTq = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderCommentPreloaderUIC.class)).rTq;
    if ((this.username.equals(com.tencent.mm.model.u.aAu())) && (this.rWI))
    {
      paramBoolean = true;
      this.drv = paramBoolean;
      if (!this.drv) {
        break label288;
      }
    }
    for (;;)
    {
      this.scene = i;
      this.rTs = 99;
      this.rMA = 100;
      this.orV = 101;
      this.rTt = 102;
      this.orP = 103;
      this.rTu = 104;
      this.rTv = 105;
      this.rTw = 106;
      this.rTx = 107;
      this.iUG = 108;
      this.rWD = 109;
      this.rWE = 110;
      this.rOe = new i();
      this.rWG = new b(this);
      this.rWH = new d(this);
      AppMethodBeat.o(201988);
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
    this.rWB = paramc;
    int i;
    if (this.rWI)
    {
      i = 8;
      paramc = cBm();
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
      com.tencent.mm.sdk.b.a.IbL.b((com.tencent.mm.sdk.b.c)this.rWG);
      com.tencent.mm.sdk.b.a.IbL.b((com.tencent.mm.sdk.b.c)this.rWH);
      this.rWF = new com.tencent.mm.plugin.finder.view.b((BaseFinderFeedLoader)cBm());
      paramc = this.rWF;
      if (paramc != null) {
        paramc.alive();
      }
      paramc = this.rOe;
      Object localObject = this.rWB;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      i.a(paramc, ((x.c)localObject).fLP, (i.b)new o(this), 4);
      paramc = MediaPreloadCore.skO;
      DataBuffer localDataBuffer;
      i locali;
      if (MediaPreloadCore.cDb())
      {
        localObject = (TestPreloadPreview)this.fLP.findViewById(2131305708);
        if (localObject != null)
        {
          ((TestPreloadPreview)localObject).setVisibility(0);
          localDataBuffer = cBm().getDataListJustForAdapter();
          locali = this.rOe;
          paramc = FinderReporterUIC.tcM;
          paramc = FinderReporterUIC.a.eY((Context)this.fLP);
          if (paramc == null) {
            break label315;
          }
        }
      }
      for (paramc = FinderReporterUIC.a(paramc);; paramc = null)
      {
        ((TestPreloadPreview)localObject).a(localDataBuffer, 0, locali, paramc, -1);
        this.rTq.a(this.scene, i, (d.g.a.b)new r(this));
        paramc = FinderReporterUIC.tcM;
        paramc = FinderReporterUIC.a.eY((Context)this.fLP);
        if (paramc == null) {
          break label320;
        }
        paramc = FinderReporterUIC.a(paramc);
        if (paramc == null) {
          break label320;
        }
        paramc.a((com.tencent.mm.plugin.finder.event.base.d)this.rTq);
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
    AppMethodBeat.i(201987);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.a.KiD;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s(this.fLP).get(FinderReporterUIC.class)).cOu();
    Object localObject2 = com.tencent.mm.plugin.finder.model.w.skq;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
    com.tencent.mm.plugin.finder.model.w.a((aqy)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.p.j(paramBaseFinderFeed.contact));
    AppMethodBeat.o(201987);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(201985);
    d.g.b.p.h(paramFinderItem, "feed");
    m.a.a(m.sLy, this.fLP, paramFinderItem, 0, 12);
    AppMethodBeat.o(201985);
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
    AppMethodBeat.i(201984);
    d.g.b.p.h(paramFinderItem, "feed");
    parame = com.tencent.mm.plugin.finder.model.l.sjY;
    com.tencent.mm.plugin.finder.model.l.a(this.fLP, paramFinderItem, paramBoolean);
    AppMethodBeat.o(201984);
  }
  
  public final RecyclerView.n cAF()
  {
    AppMethodBeat.i(165765);
    RecyclerView.n localn = (RecyclerView.n)this.rWA.getValue();
    AppMethodBeat.o(165765);
    return localn;
  }
  
  public final com.tencent.mm.plugin.finder.view.e cAG()
  {
    return this.rTG;
  }
  
  public final boolean cAz()
  {
    return this.drv;
  }
  
  public final ArrayList<al> cBg()
  {
    AppMethodBeat.i(201983);
    ArrayList localArrayList = (ArrayList)cBm().getDataListJustForAdapter();
    AppMethodBeat.o(201983);
    return localArrayList;
  }
  
  public final FinderProfileFeedLoader cBm()
  {
    AppMethodBeat.i(201982);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.rWC.getValue();
    AppMethodBeat.o(201982);
    return localFinderProfileFeedLoader;
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
    AppMethodBeat.i(201986);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    m.a locala = m.sLy;
    m.a.a(this.fLP, paramBaseFinderFeed, 4, 4);
    AppMethodBeat.o(201986);
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final i getVideoCore()
  {
    return this.rOe;
  }
  
  public final int h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    d.g.b.p.h(paramBaseFinderFeed, "feed");
    int i = cBm().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    d.g.b.p.h(parama, "p0");
    this.rTB.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.rTq.onDetach();
    Object localObject = FinderReporterUIC.tcM;
    localObject = FinderReporterUIC.a.eY((Context)this.fLP);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.rTq);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.e.szM.clearCache();
    localObject = ((Iterable)this.rTB).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.rTB.clear();
    this.rWB = null;
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.rWG);
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.rWH);
    localObject = this.rWF;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.view.b)localObject).dead();
      AppMethodBeat.o(165757);
      return;
    }
    AppMethodBeat.o(165757);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(165729);
      Object localObject = com.tencent.mm.ui.component.a.KiD;
      com.tencent.mm.ui.component.a.s(this.rWJ.fLP).get(FinderReporterUIC.class);
      switch (paramInt)
      {
      default: 
        localObject = (com.tencent.mm.view.recyclerview.b)new k((h)this.rWJ, false, 0, 6);
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
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.w(this.rWJ.rOe, (h)this.rWJ, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (com.tencent.mm.view.recyclerview.b)new k((h)this.rWJ, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 7: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.u((h)this.rWJ, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      case 8: 
        localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.n(this.rWJ.rOe, (h)this.rWJ, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.b)new com.tencent.mm.plugin.finder.convert.q((h)this.rWJ, false, 0, 6);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
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
    
    public final void a(long paramLong, aqa paramaqa)
    {
      AppMethodBeat.i(165732);
      Object localObject1 = this.rWJ.rWB;
      if (localObject1 != null)
      {
        localObject1 = ((x.c)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramaqa = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165732);
            throw paramaqa;
          }
          localObject2 = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.w)localObject2).lN();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new d.o(Integer.valueOf(1), paramaqa));
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
    
    public final FinderItem wf(long paramLong)
    {
      AppMethodBeat.i(165731);
      Object localObject = this.rWJ.rWB;
      if (localObject != null)
      {
        localObject = ((x.c)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165731);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.d.c((com.tencent.mm.view.recyclerview.d)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.w)localObject).lN();
            localObject = (al)this.rWJ.cBm().safeGet(i);
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<FinderProfileFeedLoader>
  {
    c(x.b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends com.tencent.mm.sdk.b.c<hd>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
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
      if (!this.rWJ.drv)
      {
        localObject1 = this.rWJ.fLP.getString(2131755893);
        localObject2 = this.rWJ.fLP.getString(2131766851);
        this.rWJ.fLP.getString(2131758845);
        localObject3 = this.rWJ.TAG;
        localObject4 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
        ad.i((String)localObject3, com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed))
          {
            localObject1 = j.sLq;
            localObject2 = j.a((Context)this.rWJ.fLP, paramBaseFinderFeed, this.rWJ.scene, (d.g.a.b)new a(this, paraml));
            localObject1 = (String)((d.t)localObject2).first;
            localObject2 = (String)((d.t)localObject2).second;
            bool2 = true;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        paraml.a(this.rWJ.rTt, (CharSequence)localObject1, 2131691565, this.rWJ.fLP.getResources().getColor(2131099699), bool1);
        paraml.a(this.rWJ.orP, (CharSequence)localObject2, 2131689817, 0, bool2);
        do
        {
          paraml = com.tencent.mm.plugin.finder.report.h.soM;
          long l = paramBaseFinderFeed.lP();
          paraml = FinderReporterUIC.tcM;
          paraml = FinderReporterUIC.a.eY((Context)this.rWJ.fLP);
          if (paraml != null) {
            i = paraml.rTD;
          }
          com.tencent.mm.plugin.finder.report.h.J(l, i);
          paraml = FinderReporterUIC.tcM;
          paraml = FinderReporterUIC.a.eY((Context)this.rWJ.fLP);
          if (paraml == null) {
            break label883;
          }
          paraml = FinderReporterUIC.b(paraml);
          if (paraml == null) {
            break label883;
          }
          paraml.cze().wa(paramBaseFinderFeed.lP());
          AppMethodBeat.o(165736);
          return;
          if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
            break label898;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject1 = com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeForward", 2131759344);
          localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
          localObject2 = com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeShare", 2131759345);
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeCollect", 2131759343);
          bool2 = true;
          bool1 = true;
          break;
          d.g.b.p.g(paraml, "menu");
        } while (!paraml.fyP());
        localObject2 = aj.getContext().getString(2131755893);
        localObject1 = aj.getContext().getString(2131766851);
        aj.getContext().getString(2131758845);
        localObject3 = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localObject4 = com.tencent.mm.plugin.finder.utils.p.sMo;
        ad.i("Finder.ProfileTimeLineCovert", com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed))
          {
            localObject1 = j.sLq;
            localObject1 = j.a((Context)this.rWJ.fLP, paramBaseFinderFeed, this.rWJ.scene, (d.g.a.b)new b(this, paraml));
            localObject2 = (String)((d.t)localObject1).first;
            localObject1 = (String)((d.t)localObject1).second;
            bool2 = true;
            bool1 = true;
          }
        }
        for (;;)
        {
          int j = this.rWJ.rTt;
          localObject2 = (CharSequence)localObject2;
          localObject3 = aj.getContext();
          d.g.b.p.g(localObject3, "MMApplicationContext.getContext()");
          paraml.a(j, (CharSequence)localObject2, 2131691565, ((Context)localObject3).getResources().getColor(2131099699), bool1);
          paraml.a(this.rWJ.orP, (CharSequence)localObject1, 2131689817, 0, bool2);
          break;
          if ((paramBaseFinderFeed.feedObject.isOnlySelfSee()) || (paramBaseFinderFeed.feedObject.isNotShare()))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject2 = com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeForward", 2131759344);
            localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
            localObject1 = com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeShare", 2131759345);
            localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
            com.tencent.mm.plugin.finder.utils.p.dx("FinderSafeSelfSeeCollect", 2131759343);
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
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.b<d.t<? extends String, ? extends String, ? extends String>, z>
    {
      a(x.b.e parame, com.tencent.mm.ui.base.l paraml)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements n.d
  {
    f(x.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      boolean bool = true;
      AppMethodBeat.i(165737);
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      if ((com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed)) && (this.rWJ.drv))
      {
        paraml.aL(this.rWJ.iUG, 2131755707, 2131690551);
        int i;
        int j;
        if (paramBaseFinderFeed.feedObject.isCommentClose())
        {
          paraml.a(this.rWJ.rTx, (CharSequence)this.rWJ.fLP.getString(2131759223), 2131690547);
          localObject = com.tencent.mm.plugin.finder.utils.l.sLx;
          d.g.b.p.g(paraml, "menu");
          localObject = (Context)this.rWJ.fLP;
          paramBaseFinderFeed.feedObject.getMediaType();
          i = this.rWJ.rWE;
          j = this.rWJ.rWD;
          if (paramBaseFinderFeed.feedObject.getPrivate_flag() != 1) {
            break label203;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.finder.utils.l.a(paraml, (Context)localObject, i, j, bool);
          AppMethodBeat.o(165737);
          return;
          paraml.a(this.rWJ.rTw, (CharSequence)this.rWJ.fLP.getString(2131759210), 2131690190);
          break;
          label203:
          bool = false;
        }
      }
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (!com.tencent.mm.plugin.finder.utils.p.d(paramBaseFinderFeed)) {
        paraml.aL(this.rWJ.orV, 2131761332, 2131690646);
      }
      AppMethodBeat.o(165737);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(x.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165738);
      if (!this.rWJ.drv)
      {
        localObject1 = this.rWJ;
        d.g.b.p.g(paramMenuItem, "menuItem");
        localObject2 = paramBaseFinderFeed;
        ad.i(((x.b)localObject1).TAG, "getMoreMenuItemSelectedListener feed " + localObject2 + " menuItem:" + paramMenuItem.getItemId());
        paramInt = paramMenuItem.getItemId();
        if (paramInt == ((x.b)localObject1).rTs)
        {
          paramInt = ((x.b)localObject1).cBm().getDataListJustForAdapter().indexOf(localObject2);
          if (paramInt >= 0)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.b.saP;
            com.tencent.mm.plugin.finder.feed.logic.b.a((Context)((x.b)localObject1).fLP, ((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), (d.g.a.b)new x.b.h((x.b)localObject1, (BaseFinderFeed)localObject2));
            AppMethodBeat.o(165738);
            return;
          }
          ad.i(((x.b)localObject1).TAG, "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt != ((x.b)localObject1).rMA)
        {
          if (paramInt == ((x.b)localObject1).rTt)
          {
            m.a.a(m.sLy, ((x.b)localObject1).fLP, ((BaseFinderFeed)localObject2).feedObject, 3, 4);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).orP)
          {
            paramMenuItem = m.sLy;
            m.a.a(((x.b)localObject1).fLP, (BaseFinderFeed)localObject2, 0, 12);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).rTu)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.utils.d.sKW;
            com.tencent.mm.plugin.finder.utils.d.a((BaseFinderFeed)localObject2, ((x.b)localObject1).fLP);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).orV)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.saO;
            com.tencent.mm.plugin.finder.feed.logic.a.i((Context)((x.b)localObject1).fLP, ((BaseFinderFeed)localObject2).feedObject.field_id);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).rTv)
          {
            paramMenuItem = new Intent();
            paramMenuItem.putExtra("postRefMediaList", ((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectDesc.toByteArray());
            localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
            paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.p.n((BaseFinderFeed)localObject2).toByteArray());
            paramMenuItem.putExtra("postType", ((BaseFinderFeed)localObject2).feedObject.getMediaType());
            paramMenuItem.putExtra("key_finder_post_from", 5);
            localObject2 = com.tencent.mm.plugin.finder.utils.a.sKD;
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)((x.b)localObject1).fLP, paramMenuItem);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).rTx)
          {
            ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getFeedObject(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.s)new x.b.i((x.b)localObject1));
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((x.b)localObject1).rTw) {
            ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getFeedObject(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.s)new x.b.j((x.b)localObject1));
          }
        }
        AppMethodBeat.o(165738);
        return;
      }
      Object localObject3 = this.rWJ;
      d.g.b.p.g(paramMenuItem, "menuItem");
      Object localObject2 = paramBaseFinderFeed;
      Object localObject1 = (Context)this.rWJ.fLP;
      paramInt = paramMenuItem.getItemId();
      if (paramInt == ((x.b)localObject3).rTt)
      {
        paramMenuItem = m.sLy;
        if (localObject1 == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165738);
          throw paramMenuItem;
        }
        m.a.a(paramMenuItem, (MMActivity)localObject1, ((BaseFinderFeed)localObject2).feedObject, 3, 4);
        AppMethodBeat.o(165738);
        return;
      }
      if (paramInt == ((x.b)localObject3).orP)
      {
        paramMenuItem = m.sLy;
        if (localObject1 == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165738);
          throw paramMenuItem;
        }
        m.a.a((MMActivity)localObject1, (BaseFinderFeed)localObject2, 0, 12);
        AppMethodBeat.o(165738);
        return;
      }
      if (paramInt == ((x.b)localObject3).iUG)
      {
        paramMenuItem = com.tencent.mm.plugin.finder.utils.p.sMo;
        if ((com.tencent.mm.plugin.finder.utils.p.d((BaseFinderFeed)localObject2)) && (((BaseFinderFeed)localObject2).feedObject.isPostFinish()))
        {
          com.tencent.mm.ui.base.h.a((Context)localObject1, 2131759309, 0, (DialogInterface.OnClickListener)new x.b.k((x.b)localObject3, (BaseFinderFeed)localObject2, (Context)localObject1), null);
          AppMethodBeat.o(165738);
        }
      }
      else if (paramInt == ((x.b)localObject3).rTs)
      {
        if (((x.b)localObject3).h((BaseFinderFeed)localObject2) >= 0)
        {
          paramMenuItem = ((x.b)localObject3).rWB;
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.getRecyclerView();
            if (paramMenuItem == null) {}
          }
          for (paramMenuItem = paramMenuItem.getAdapter();; paramMenuItem = null)
          {
            com.tencent.mm.plugin.finder.feed.logic.b localb = com.tencent.mm.plugin.finder.feed.logic.b.saP;
            com.tencent.mm.plugin.finder.feed.logic.b.a((Context)localObject1, ((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), (d.g.a.b)new x.b.l((x.b)localObject3, (BaseFinderFeed)localObject2, paramMenuItem));
            AppMethodBeat.o(165738);
            return;
          }
        }
      }
      else
      {
        if (paramInt == ((x.b)localObject3).orV)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.saO;
          com.tencent.mm.plugin.finder.feed.logic.a.i((Context)localObject1, ((BaseFinderFeed)localObject2).feedObject.field_id);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject3).rTx)
        {
          ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getFeedObject(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.i.a.s)new x.b.m((Context)localObject1));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject3).rTw)
        {
          ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.l.class)).a(((BaseFinderFeed)localObject2).feedObject.getId(), ((BaseFinderFeed)localObject2).feedObject.getFeedObject(), ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.i.a.s)new x.b.n((Context)localObject1));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject3).rWE)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.l.sLx;
          com.tencent.mm.plugin.finder.utils.l.a((Context)localObject1, ((BaseFinderFeed)localObject2).feedObject, false);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject3).rWD)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.l.sLx;
          com.tencent.mm.plugin.finder.utils.l.a((Context)localObject1, ((BaseFinderFeed)localObject2).feedObject, true);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject3).rTv)
        {
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("postRefMediaList", ((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectDesc.toByteArray());
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.p.n((BaseFinderFeed)localObject2).toByteArray());
          paramMenuItem.putExtra("postType", ((BaseFinderFeed)localObject2).feedObject.getMediaType());
          paramMenuItem.putExtra("key_finder_post_from", 5);
          localObject2 = com.tencent.mm.plugin.finder.utils.a.sKD;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)localObject1, paramMenuItem);
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt == ((x.b)localObject3).rTu)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.d.sKW;
          if (localObject1 == null)
          {
            paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(165738);
            throw paramMenuItem;
          }
          com.tencent.mm.plugin.finder.utils.d.a((BaseFinderFeed)localObject2, (MMActivity)localObject1);
          AppMethodBeat.o(165738);
          return;
        }
        Toast.makeText((Context)localObject1, 2131759377, 1).show();
      }
      AppMethodBeat.o(165738);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    h(x.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$2", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.i.a.s<apn>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.i.a.s<apn>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class k
    implements DialogInterface.OnClickListener
  {
    k(x.b paramb, BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178257);
      paramDialogInterface = com.tencent.mm.model.u.aAu();
      d.g.b.p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new aa(paramDialogInterface, this.rPa.feedObject.getId(), this.rPa.feedObject.getObjectNonceId());
      Object localObject = this.rWJ.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.aiU().a(paramDialogInterface.getType(), (com.tencent.mm.al.f)new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(178256);
            if (((paramAnonymousn instanceof aa)) && (((aa)paramAnonymousn).rIZ == paramDialogInterface.rIZ)) {
              com.tencent.mm.kernel.g.aiU().b(paramDialogInterface.getType(), (com.tencent.mm.al.f)this);
            }
            paramAnonymousString = this.rWO.rWJ.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              com.tencent.mm.ui.base.t.makeText(this.rWO.cqB, 2131766485, 0).show();
            }
            AppMethodBeat.o(178256);
          }
        });
        com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)paramDialogInterface);
        AppMethodBeat.o(178257);
        return;
        localObject = this.rWJ;
        Context localContext = this.cqB;
        this.cqB.getString(2131755906);
        ((x.b)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.b(localContext, this.cqB.getString(2131755936), false, (DialogInterface.OnCancelListener)a.rWN));
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a rWN;
      
      static
      {
        AppMethodBeat.i(178255);
        rWN = new a();
        AppMethodBeat.o(178255);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.b<Integer, LinkedList<Long>>
  {
    l(x.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class m
    implements com.tencent.mm.plugin.i.a.s<apn>
  {
    m(Context paramContext) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class n
    implements com.tencent.mm.plugin.i.a.s<apn>
  {
    n(Context paramContext) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class o
    implements i.b
  {
    public final RecyclerView cAH()
    {
      AppMethodBeat.i(165742);
      Object localObject = this.rWJ.rWB;
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      localObject = ((x.c)localObject).getRecyclerView();
      AppMethodBeat.o(165742);
      return localObject;
    }
    
    public final DataBuffer<al> cAI()
    {
      AppMethodBeat.i(201979);
      DataBuffer localDataBuffer = this.rWJ.cBm().getDataList();
      AppMethodBeat.o(201979);
      return localDataBuffer;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.a<RecyclerView.n>
  {
    public static final p rWQ;
    
    static
    {
      AppMethodBeat.i(165745);
      rWQ = new p();
      AppMethodBeat.o(165745);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.b<IResponse<al>, z>
  {
    q(x.b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x.b
 * JD-Core Version:    0.7.0.1
 */