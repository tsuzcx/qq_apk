package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.bb.a;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI10;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k.b;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.v;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "selfFlag", "", "topicId", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;ZJ)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_REPRINT", "MENU_ID_SET_CANCEL_STICKY", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SET_STICKY", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "scene", "getSelfFlag", "()Z", "stickyComponent", "Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getTopicId", "()J", "getUsername", "()Ljava/lang/String;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLikeLocalFeed", "isPrivate", "onUIPause", "onUIResume", "removeDataAt", "index", "requestRefresh", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public final class ab$b
  implements ab.a, i, com.tencent.mm.plugin.finder.presenter.base.a<ab.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  boolean dJM;
  public final MMActivity gte;
  final int jUx;
  final int pLU;
  final int pMa;
  int scene;
  final com.tencent.mm.plugin.finder.video.k tCD;
  final int tLD;
  final int tLE;
  final int tLF;
  final int tLG;
  final int tLH;
  final int tLJ;
  final int tLK;
  final int tLL;
  final int tLM;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
  private final com.tencent.mm.plugin.finder.view.e tLT;
  private final com.tencent.mm.plugin.finder.feed.model.d tLy;
  private final com.tencent.mm.plugin.finder.feed.model.f tLz;
  final int tPA;
  final int tPB;
  final int tPC;
  final int tPD;
  private com.tencent.mm.plugin.finder.view.b tPE;
  private final b tPF;
  private final d tPG;
  private final boolean tPH;
  private final kotlin.f tPw;
  ab.c tPx;
  private final kotlin.f tPy;
  final com.tencent.mm.plugin.finder.feed.component.b tPz;
  Dialog tipDialog;
  final int tqv;
  final long twp;
  final int tzW;
  final String username;
  
  public ab$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.e parame, String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(244077);
    this.gte = paramMMActivity;
    this.tLT = parame;
    this.username = paramString;
    this.tPH = paramBoolean;
    this.twp = paramLong;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.tPw = kotlin.g.ah((kotlin.g.a.a)u.tPT);
    this.tLP = new CopyOnWriteArraySet();
    this.tPy = kotlin.g.ah((kotlin.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    this.tLy = ((FinderCommentPreloaderUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderCommentPreloaderUIC.class)).tLy;
    paramMMActivity = com.tencent.mm.ui.component.a.PRN;
    this.tLz = ((FinderLiveNoticePreLoadUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderLiveNoticePreLoadUIC.class)).wyi;
    if ((this.username.equals(z.aUg())) && (this.tPH))
    {
      paramBoolean = true;
      this.dJM = paramBoolean;
      if (!this.dJM) {
        break label379;
      }
    }
    for (;;)
    {
      this.scene = i;
      this.tPz = new com.tencent.mm.plugin.finder.feed.component.b();
      this.tLD = 99;
      this.tzW = 100;
      this.pMa = 101;
      this.tqv = 102;
      this.pLU = 103;
      this.tLE = 104;
      this.tLF = 105;
      this.tLG = 106;
      this.tLH = 107;
      this.jUx = 108;
      this.tPA = 109;
      this.tPB = 110;
      this.tPC = 111;
      this.tPD = 112;
      this.tLJ = 113;
      this.tLM = 114;
      this.tLK = 110;
      this.tLL = 111;
      this.tCD = new com.tencent.mm.plugin.finder.video.k();
      this.tPF = new b(this);
      this.tPG = new d(this);
      AppMethodBeat.o(244077);
      return;
      paramBoolean = false;
      break;
      label379:
      i = 2;
    }
  }
  
  public final o.f a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(165760);
    p.h(paramBaseFinderFeed, "feed");
    p.h(parame, "sheet");
    paramBaseFinderFeed = (o.f)new e(this, paramBaseFinderFeed, parame);
    AppMethodBeat.o(165760);
    return paramBaseFinderFeed;
  }
  
  public final void a(ab.c paramc)
  {
    AppMethodBeat.i(165754);
    p.h(paramc, "callback");
    this.tPx = paramc;
    int i;
    Object localObject1;
    if (this.tPH)
    {
      i = 8;
      localObject1 = getFeedLoader();
      if ((localObject1 instanceof FinderProfileFeedLoader)) {
        break label417;
      }
      localObject1 = null;
    }
    label412:
    label417:
    for (;;)
    {
      if (localObject1 != null) {
        ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((kotlin.g.a.b)new v(this));
      }
      EventCenter.instance.add((IListener)this.tPF);
      EventCenter.instance.add((IListener)this.tPG);
      this.tPE = new com.tencent.mm.plugin.finder.view.b((BaseFinderFeedLoader)getFeedLoader());
      localObject1 = this.tPE;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.view.b)localObject1).alive();
      }
      localObject1 = this.tCD;
      Object localObject2 = this.tPx;
      if (localObject2 == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.finder.video.k.a((com.tencent.mm.plugin.finder.video.k)localObject1, (AppCompatActivity)((ab.c)localObject2).gte, (k.b)new t(this), 4);
      localObject1 = MediaPreloadCore.uTV;
      DataBuffer localDataBuffer;
      com.tencent.mm.plugin.finder.video.k localk;
      if (MediaPreloadCore.dlF())
      {
        localObject2 = (TestPreloadPreview)this.gte.findViewById(2131308975);
        if (localObject2 != null)
        {
          ((TestPreloadPreview)localObject2).setVisibility(0);
          localDataBuffer = getFeedLoader().getDataListJustForAdapter();
          localk = this.tCD;
          localObject1 = FinderReporterUIC.wzC;
          localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
          if (localObject1 == null) {
            break label412;
          }
        }
      }
      for (localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);; localObject1 = null)
      {
        ((TestPreloadPreview)localObject2).a(localDataBuffer, 0, localk, (com.tencent.mm.plugin.finder.event.base.c)localObject1, -1);
        this.tLy.a(this.scene, i, (kotlin.g.a.b)new w(this));
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
        if (localObject1 != null)
        {
          localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
          }
        }
        this.tLz.e((kotlin.g.a.m)new x(this));
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = FinderReporterUIC.a.fH((Context)this.gte);
        if (localObject1 != null)
        {
          localObject1 = FinderReporterUIC.a((FinderReporterUIC)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
          }
        }
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        ((FinderFeedMegaVideoBtnAnimUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderFeedMegaVideoBtnAnimUIC.class)).t(paramc.getRecyclerView());
        AppMethodBeat.o(165754);
        return;
        i = 1;
        break;
      }
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(244076);
    p.h(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx();
    Object localObject2 = com.tencent.mm.plugin.finder.model.aj.uOw;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    y localy = y.vXH;
    com.tencent.mm.plugin.finder.model.aj.a((bbn)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, y.i(paramBaseFinderFeed.contact));
    AppMethodBeat.o(244076);
  }
  
  public final void a(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(244074);
    p.h(paramFinderItem, "feed");
    s.a.a(s.vWt, (AppCompatActivity)this.gte, paramFinderItem, 0, 12);
    AppMethodBeat.o(244074);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165767);
    p.h(paramFinderItem, "feed");
    p.h(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165767);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.h paramh)
  {
    AppMethodBeat.i(244073);
    p.h(paramFinderItem, "feed");
    paramh = com.tencent.mm.plugin.finder.model.r.uNW;
    com.tencent.mm.plugin.finder.model.r.a((AppCompatActivity)this.gte, paramFinderItem, paramBoolean);
    AppMethodBeat.o(244073);
  }
  
  public final void b(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    AppMethodBeat.i(165764);
    p.h(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    bbn localbbn = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.gte).get(FinderReporterUIC.class)).dIx();
    localObject = ag.uOs;
    localObject = paramBaseFinderFeed.contact;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.api.g)localObject).getUsername();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      bb.a locala;
      int i;
      if (paramBoolean)
      {
        locala = bb.tve;
        i = bb.cYi();
        localObject = ag.a(localbbn, (String)localObject, i);
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localObject);
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        paramBaseFinderFeed = paramBaseFinderFeed.contact;
        if (paramBaseFinderFeed != null)
        {
          paramBaseFinderFeed = paramBaseFinderFeed.getUsername();
          if (paramBaseFinderFeed != null) {
            break label186;
          }
        }
        paramBaseFinderFeed = "";
      }
      label186:
      for (;;)
      {
        if (paramBoolean) {
          localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        }
        for (i = com.tencent.mm.plugin.finder.api.g.cXO();; i = com.tencent.mm.plugin.finder.api.g.cXP())
        {
          c.a.du(paramBaseFinderFeed, i);
          AppMethodBeat.o(165764);
          return;
          locala = bb.tve;
          i = bb.cYj();
          break;
          localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        }
      }
    }
  }
  
  public final boolean dbZ()
  {
    return this.dJM;
  }
  
  public final ArrayList<bo> dcH()
  {
    AppMethodBeat.i(244072);
    ArrayList localArrayList = (ArrayList)getFeedLoader().getDataListJustForAdapter();
    AppMethodBeat.o(244072);
    return localArrayList;
  }
  
  public final RecyclerView.m dcf()
  {
    AppMethodBeat.i(165765);
    RecyclerView.m localm = (RecyclerView.m)this.tPw.getValue();
    AppMethodBeat.o(165765);
    return localm;
  }
  
  public final com.tencent.mm.plugin.finder.view.e dcg()
  {
    return this.tLT;
  }
  
  public final MMActivity getActivity()
  {
    return this.gte;
  }
  
  public final FinderProfileFeedLoader getFeedLoader()
  {
    AppMethodBeat.i(244071);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.tPy.getValue();
    AppMethodBeat.o(244071);
    return localFinderProfileFeedLoader;
  }
  
  public final com.tencent.mm.plugin.finder.video.k getVideoCore()
  {
    return this.tCD;
  }
  
  public final o.f i(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165761);
    p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (o.f)new f(this, paramBaseFinderFeed);
    AppMethodBeat.o(165761);
    return paramBaseFinderFeed;
  }
  
  public final o.g j(final BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165762);
    p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = (o.g)new g(this, paramBaseFinderFeed);
    AppMethodBeat.o(165762);
    return paramBaseFinderFeed;
  }
  
  public final void k(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(244075);
    p.h(paramBaseFinderFeed, "feed");
    s.a locala = s.vWt;
    s.a.a((AppCompatActivity)this.gte, paramBaseFinderFeed, 4, 0, 20);
    AppMethodBeat.o(244075);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    p.h(parama, "p0");
    this.tLP.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final int l(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    p.h(paramBaseFinderFeed, "feed");
    int i = getFeedLoader().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.tLy.onDetach();
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.onDetach();
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.f.vGd.clearCache();
    localObject = ((Iterable)this.tLP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.tLP.clear();
    this.tPx = null;
    EventCenter.instance.removeListener((IListener)this.tPF);
    EventCenter.instance.removeListener((IListener)this.tPG);
    localObject = this.tPE;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.view.b)localObject).dead();
      AppMethodBeat.o(165757);
      return;
    }
    AppMethodBeat.o(165757);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(165729);
      switch (paramInt)
      {
      default: 
        localObject = y.vXH;
        y.dQ(this.tPI.TAG, paramInt);
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(165729);
        return localObject;
      case 4: 
      case 3002: 
        localObject = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.t(this.tPI.tCD, (i)this.tPI, false, 0, 12);
          AppMethodBeat.o(165729);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new ak(this.tPI.tCD, (i)this.tPI, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
      case 3001: 
        localObject = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.q((i)this.tPI, false, 0, 6);
          AppMethodBeat.o(165729);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.u((i)this.tPI, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      }
      Object localObject = y.vXH;
      if (y.isOtherEnableFullScreenEnjoy())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.r(this.tPI.tCD, (i)this.tPI, 0, 0, 28);
        AppMethodBeat.o(165729);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.x(this.tPI.tCD, (i)this.tPI);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
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
    
    public final FinderItem EB(long paramLong)
    {
      AppMethodBeat.i(165731);
      Object localObject = this.tPI.tPx;
      if (localObject != null)
      {
        localObject = ((ab.c)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165731);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.v)localObject).lR();
            localObject = (bo)this.tPI.getFeedLoader().safeGet(i);
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
    
    public final void a(long paramLong, azt paramazt)
    {
      AppMethodBeat.i(165732);
      Object localObject1 = this.tPI.tPx;
      if (localObject1 != null)
      {
        localObject1 = ((ab.c)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            paramazt = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165732);
            throw paramazt;
          }
          localObject2 = com.tencent.mm.view.recyclerview.g.c((com.tencent.mm.view.recyclerview.g)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).lR();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).b(i, new kotlin.o(Integer.valueOf(1), paramazt));
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
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderProfileFeedLoader>
  {
    c(ab.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hk>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements o.f
  {
    e(ab.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.m paramm)
    {
      int j = 0;
      int i = 1;
      AppMethodBeat.i(165736);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      StringBuilder localStringBuilder;
      y localy;
      boolean bool2;
      boolean bool1;
      if (!this.tPI.dJM)
      {
        localObject1 = this.tPI.gte.getString(2131755985);
        p.g(localObject1, "context.getString(R.string.app_share_to_weixin)");
        localObject2 = this.tPI.gte.getString(2131760572);
        p.g(localObject2, "context.getString(R.string.finder_share_timeline)");
        p.g(this.tPI.gte.getString(2131759168), "context.getString(R.string.favorite)");
        localObject3 = this.tPI.TAG;
        localStringBuilder = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localy = y.vXH;
        Log.i((String)localObject3, y.h(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = y.vXH;
          if (y.h(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.o.vVT;
            localObject2 = com.tencent.mm.plugin.finder.utils.o.a((Context)this.tPI.gte, paramBaseFinderFeed, this.tPI.scene, (kotlin.g.a.b)new a(this, paramm));
            localObject1 = (String)((kotlin.r)localObject2).first;
            localObject2 = (String)((kotlin.r)localObject2).second;
            bool2 = true;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        paramm.a(this.tPI.tqv, (CharSequence)localObject1, 2131690251, this.tPI.gte.getResources().getColor(2131099710), bool1);
        paramm.a(this.tPI.pLU, (CharSequence)localObject2, 2131689830, 0, bool2);
        localObject1 = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy())
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
          if (com.tencent.mm.plugin.finder.upload.action.c.dBq().k(paramBaseFinderFeed.feedObject.getFeedObject())) {
            break label601;
          }
          label370:
          if (i == 0) {
            break label606;
          }
          paramm.a(this.tPI.tLK, (CharSequence)this.tPI.gte.getString(2131759168), 2131691821, this.tPI.gte.getResources().getColor(2131100919));
        }
        label601:
        label606:
        do
        {
          for (;;)
          {
            paramm = com.tencent.mm.plugin.finder.report.k.vfA;
            long l = paramBaseFinderFeed.lT();
            paramm = FinderReporterUIC.wzC;
            paramm = FinderReporterUIC.a.fH((Context)this.tPI.gte);
            i = j;
            if (paramm != null) {
              i = paramm.tCE;
            }
            com.tencent.mm.plugin.finder.report.k.I(l, i);
            paramm = FinderReporterUIC.wzC;
            paramm = FinderReporterUIC.a.fH((Context)this.tPI.gte);
            if (paramm == null) {
              break label1075;
            }
            paramm = FinderReporterUIC.b(paramm);
            if (paramm == null) {
              break label1075;
            }
            paramm.cZR().Ew(paramBaseFinderFeed.lT());
            AppMethodBeat.o(165736);
            return;
            if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
              break label1090;
            }
            localObject1 = y.vXH;
            localObject1 = y.dP("FinderSafeSelfSeeForward", 2131760540);
            localObject2 = y.vXH;
            localObject2 = y.dP("FinderSafeSelfSeeShare", 2131760541);
            localObject3 = y.vXH;
            y.dP("FinderSafeSelfSeeCollect", 2131760539);
            bool2 = true;
            bool1 = true;
            break;
            i = 0;
            break label370;
            paramm.a(this.tPI.tLL, (CharSequence)this.tPI.gte.getString(2131759570), 2131691822, this.tPI.gte.getResources().getColor(2131100919));
          }
          p.g(paramm, "menu");
        } while (!paramm.gKQ());
        localObject2 = MMApplicationContext.getContext().getString(2131755985);
        p.g(localObject2, "MMApplicationContext.get…ring.app_share_to_weixin)");
        localObject1 = MMApplicationContext.getContext().getString(2131760572);
        p.g(localObject1, "MMApplicationContext.get…ng.finder_share_timeline)");
        p.g(MMApplicationContext.getContext().getString(2131759168), "MMApplicationContext.get…String(R.string.favorite)");
        localObject3 = this.tPI.TAG;
        localStringBuilder = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localy = y.vXH;
        Log.i((String)localObject3, y.h(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = y.vXH;
          if (y.h(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.o.vVT;
            localObject1 = com.tencent.mm.plugin.finder.utils.o.a((Context)this.tPI.gte, paramBaseFinderFeed, this.tPI.scene, (kotlin.g.a.b)new b(this, paramm));
            localObject2 = (String)((kotlin.r)localObject1).first;
            localObject1 = (String)((kotlin.r)localObject1).second;
            bool2 = true;
            bool1 = true;
          }
        }
        for (;;)
        {
          i = this.tPI.tqv;
          localObject2 = (CharSequence)localObject2;
          localObject3 = MMApplicationContext.getContext();
          p.g(localObject3, "MMApplicationContext.getContext()");
          paramm.a(i, (CharSequence)localObject2, 2131690251, ((Context)localObject3).getResources().getColor(2131099710), bool1);
          paramm.a(this.tPI.pLU, (CharSequence)localObject1, 2131689830, 0, bool2);
          break;
          if ((paramBaseFinderFeed.feedObject.isOnlySelfSee()) || (paramBaseFinderFeed.feedObject.isNotShare()))
          {
            localObject1 = y.vXH;
            localObject2 = y.dP("FinderSafeSelfSeeForward", 2131760540);
            localObject1 = y.vXH;
            localObject1 = y.dP("FinderSafeSelfSeeShare", 2131760541);
            localObject3 = y.vXH;
            y.dP("FinderSafeSelfSeeCollect", 2131760539);
            bool2 = true;
            bool1 = true;
            continue;
            label1075:
            AppMethodBeat.o(165736);
          }
          else
          {
            bool2 = false;
            bool1 = false;
          }
        }
        label1090:
        bool2 = false;
        bool1 = false;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, kotlin.x>
    {
      a(ab.b.e parame, com.tencent.mm.ui.base.m paramm)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, kotlin.x>
    {
      b(ab.b.e parame, com.tencent.mm.ui.base.m paramm)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    f(ab.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      AppMethodBeat.i(165737);
      Object localObject = y.vXH;
      int i;
      if ((y.h(paramBaseFinderFeed)) && (this.tPI.dJM))
      {
        paramm.aS(this.tPI.jUx, 2131755778, 2131690780);
        label161:
        int k;
        if (paramBaseFinderFeed.feedObject.isCommentClose())
        {
          paramm.b(this.tPI.tLH, (CharSequence)this.tPI.gte.getString(2131759749), 2131690775);
          localObject = com.tencent.mm.plugin.finder.utils.q.vWb;
          p.g(paramm, "menu");
          localObject = (Context)this.tPI.gte;
          paramBaseFinderFeed.feedObject.getMediaType();
          i = this.tPI.tPB;
          int j = this.tPI.tPA;
          if (paramBaseFinderFeed.feedObject.getPrivate_flag() != 1) {
            break label449;
          }
          bool1 = true;
          com.tencent.mm.plugin.finder.utils.q.a(paramm, (Context)localObject, i, j, bool1);
          localObject = (Context)this.tPI.gte;
          j = this.tPI.tPD;
          k = this.tPI.tPC;
          if (paramBaseFinderFeed.feedObject.getStickyTime() == 0) {
            break label455;
          }
          i = 1;
          label215:
          p.h(paramm, "menu");
          p.h(localObject, "context");
          if (i == 0) {
            break label460;
          }
          paramm.b(j, (CharSequence)((Context)localObject).getString(2131759573), 2131690921);
        }
        for (;;)
        {
          localObject = y.vXH;
          if (y.C(paramBaseFinderFeed.feedObject))
          {
            i = this.tPI.tLJ;
            localObject = y.vXH;
            localObject = (CharSequence)y.x(paramBaseFinderFeed);
            if (paramBaseFinderFeed.feedObject.isPostFinish())
            {
              bool1 = bool2;
              if (!paramBaseFinderFeed.feedObject.isPostFailed()) {}
            }
            else
            {
              bool1 = true;
            }
            paramm.a(i, (CharSequence)localObject, 2131690227, bool1);
          }
          localObject = y.vXH;
          if (y.isOtherEnableFullScreenEnjoy()) {
            break label597;
          }
          localObject = y.vXH;
          if ((!y.isAnyEnableFullScreenEnjoy()) || ((paramBaseFinderFeed.cxn() != 4) && (paramBaseFinderFeed.cxn() != 2))) {
            break label597;
          }
          paramm.b(this.tPI.tLM, (CharSequence)this.tPI.gte.getString(2131759752), 2131690257);
          AppMethodBeat.o(165737);
          return;
          paramm.b(this.tPI.tLG, (CharSequence)this.tPI.gte.getString(2131759714), 2131690232);
          break;
          label449:
          bool1 = false;
          break label161;
          label455:
          i = 0;
          break label215;
          label460:
          paramm.b(k, (CharSequence)((Context)localObject).getString(2131760555), 2131690920);
        }
      }
      localObject = y.vXH;
      if (!y.h(paramBaseFinderFeed))
      {
        localObject = y.vXH;
        if (y.C(paramBaseFinderFeed.feedObject))
        {
          i = this.tPI.tLJ;
          localObject = y.vXH;
          localObject = (CharSequence)y.x(paramBaseFinderFeed);
          if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed())) {
            bool1 = true;
          }
          paramm.a(i, (CharSequence)localObject, 2131690227, bool1);
        }
        paramm.aS(this.tPI.pMa, 2131763159, 2131690898);
      }
      label597:
      AppMethodBeat.o(165737);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(ab.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      Object localObject4 = null;
      ab.b localb = null;
      Object localObject3 = null;
      Object localObject5 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      paramInt = 1;
      AppMethodBeat.i(165738);
      long l;
      if (!this.tPI.dJM)
      {
        localObject1 = this.tPI;
        p.g(paramMenuItem, "menuItem");
        localObject3 = paramBaseFinderFeed;
        Log.i(((ab.b)localObject1).TAG, "getMoreMenuItemSelectedListener feed " + localObject3 + " menuItem:" + paramMenuItem.getItemId());
        paramInt = paramMenuItem.getItemId();
        if (paramInt == ((ab.b)localObject1).tLD)
        {
          paramInt = ((ab.b)localObject1).getFeedLoader().getDataListJustForAdapter().indexOf(localObject3);
          if (paramInt >= 0)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
            com.tencent.mm.plugin.finder.feed.logic.c.a((Context)((ab.b)localObject1).gte, ((BaseFinderFeed)localObject3).feedObject.getId(), ((BaseFinderFeed)localObject3).feedObject.getObjectNonceId(), (kotlin.g.a.b)new ab.b.h((ab.b)localObject1, (BaseFinderFeed)localObject3));
            AppMethodBeat.o(165738);
            return;
          }
          Log.i(((ab.b)localObject1).TAG, "[UNINTEREST] pos error ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(165738);
          return;
        }
        if (paramInt != ((ab.b)localObject1).tzW)
        {
          if (paramInt == ((ab.b)localObject1).tqv)
          {
            s.a.a(s.vWt, (AppCompatActivity)((ab.b)localObject1).gte, ((BaseFinderFeed)localObject3).feedObject, 3, 4);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((ab.b)localObject1).pLU)
          {
            paramMenuItem = s.vWt;
            s.a.a((AppCompatActivity)((ab.b)localObject1).gte, (BaseFinderFeed)localObject3, 0, 0, 28);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((ab.b)localObject1).tLE)
          {
            paramMenuItem = com.tencent.mm.plugin.finder.utils.g.vVq;
            com.tencent.mm.plugin.finder.utils.g.a((BaseFinderFeed)localObject3, ((ab.b)localObject1).gte);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((ab.b)localObject1).pMa)
          {
            paramMenuItem = y.vXH;
            if (y.w((BaseFinderFeed)localObject3))
            {
              paramMenuItem = ((BaseFinderFeed)localObject3).feedObject.getLiveInfo();
              if (paramMenuItem != null)
              {
                l = paramMenuItem.liveId;
                paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                com.tencent.mm.plugin.finder.feed.logic.a.b((Context)((ab.b)localObject1).gte, l, ((BaseFinderFeed)localObject3).feedObject.getUserName());
                AppMethodBeat.o(165738);
                return;
              }
              AppMethodBeat.o(165738);
              return;
            }
            paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
            com.tencent.mm.plugin.finder.feed.logic.a.a((Context)((ab.b)localObject1).gte, ((BaseFinderFeed)localObject3).feedObject.field_id, 0L, 0, 12);
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((ab.b)localObject1).tLF)
          {
            localObject2 = new Intent();
            paramMenuItem = ((BaseFinderFeed)localObject3).feedObject.getFeedObject().objectDesc;
            if (paramMenuItem != null) {}
            for (paramMenuItem = paramMenuItem.toByteArray();; paramMenuItem = null)
            {
              ((Intent)localObject2).putExtra("postRefMediaList", paramMenuItem);
              paramMenuItem = y.vXH;
              ((Intent)localObject2).putExtra("postRefFeedInfo", y.u((BaseFinderFeed)localObject3).toByteArray());
              ((Intent)localObject2).putExtra("postType", ((BaseFinderFeed)localObject3).feedObject.getMediaType());
              ((Intent)localObject2).putExtra("key_finder_post_from", 5);
              paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
              com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)((ab.b)localObject1).gte, (Intent)localObject2);
              AppMethodBeat.o(165738);
              return;
            }
          }
          if (paramInt == ((ab.b)localObject1).tLH)
          {
            ((v)com.tencent.mm.kernel.g.af(v.class)).a(((BaseFinderFeed)localObject3).feedObject.getId(), ((BaseFinderFeed)localObject3).feedObject.getFeedObject(), ((BaseFinderFeed)localObject3).feedObject.getObjectNonceId(), true, (ai)new ab.b.i((ab.b)localObject1));
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((ab.b)localObject1).tLG)
          {
            ((v)com.tencent.mm.kernel.g.af(v.class)).a(((BaseFinderFeed)localObject3).feedObject.getId(), ((BaseFinderFeed)localObject3).feedObject.getFeedObject(), ((BaseFinderFeed)localObject3).feedObject.getObjectNonceId(), false, (ai)new ab.b.j((ab.b)localObject1));
            AppMethodBeat.o(165738);
            return;
          }
          if (paramInt == ((ab.b)localObject1).tLJ)
          {
            if (((BaseFinderFeed)localObject3).feedObject.isPostFinish())
            {
              paramMenuItem = FinderReporterUIC.wzC;
              paramMenuItem = FinderReporterUIC.a.fH((Context)((ab.b)localObject1).gte);
              if (paramMenuItem != null) {
                paramInt = paramMenuItem.tCE;
              }
              for (;;)
              {
                if (paramInt == 52) {
                  if ((((ab.b)localObject1).gte instanceof FinderTopicTimelineUI))
                  {
                    paramMenuItem = ((ab.b)localObject1).gte;
                    if (paramMenuItem == null)
                    {
                      paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                      AppMethodBeat.o(165738);
                      throw paramMenuItem;
                      paramInt = 0;
                      continue;
                    }
                    ((FinderTopicTimelineUI)paramMenuItem).onBackPressed();
                  }
                }
              }
              for (;;)
              {
                paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a((Context)((ab.b)localObject1).gte, 1, 1, Integer.valueOf(((BaseFinderFeed)localObject3).feedObject.field_finderObject.follow_feed_count));
                AppMethodBeat.o(165738);
                return;
                paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                e.a.n(((BaseFinderFeed)localObject3).feedObject);
                paramMenuItem = w.vXp;
                localObject4 = ((BaseFinderFeed)localObject3).feedObject.getFeedObject().objectDesc;
                paramMenuItem = (MenuItem)localObject2;
                if (localObject4 != null) {
                  paramMenuItem = ((FinderObjectDesc)localObject4).feedBgmInfo;
                }
                w.a(paramMenuItem, Long.valueOf(((BaseFinderFeed)localObject3).feedObject.field_id), 0);
              }
            }
          }
          else
          {
            if (paramInt == ((ab.b)localObject1).tLK)
            {
              paramMenuItem = com.tencent.mm.plugin.finder.report.aj.viU;
              paramMenuItem = FinderReporterUIC.wzC;
              localObject2 = FinderReporterUIC.a.fH((Context)((ab.b)localObject1).gte);
              paramMenuItem = (MenuItem)localObject4;
              if (localObject2 != null) {
                paramMenuItem = ((FinderReporterUIC)localObject2).dIx();
              }
              com.tencent.mm.plugin.finder.report.aj.a(paramMenuItem, "fav_in_menu", false, ((BaseFinderFeed)localObject3).lT());
              com.tencent.mm.ui.base.u.a((Context)((ab.b)localObject1).gte, ((ab.b)localObject1).gte.getResources().getString(2131759810), (u.b)new ab.b.y((ab.b)localObject1, (BaseFinderFeed)localObject3));
              AppMethodBeat.o(165738);
              return;
            }
            if (paramInt == ((ab.b)localObject1).tLL)
            {
              paramMenuItem = com.tencent.mm.plugin.finder.report.aj.viU;
              paramMenuItem = FinderReporterUIC.wzC;
              localObject2 = FinderReporterUIC.a.fH((Context)((ab.b)localObject1).gte);
              paramMenuItem = localb;
              if (localObject2 != null) {
                paramMenuItem = ((FinderReporterUIC)localObject2).dIx();
              }
              com.tencent.mm.plugin.finder.report.aj.a(paramMenuItem, "unfav_in_menu", false, ((BaseFinderFeed)localObject3).lT());
              com.tencent.mm.ui.base.u.a((Context)((ab.b)localObject1).gte, ((ab.b)localObject1).gte.getResources().getString(2131759809), (u.b)new ab.b.z((ab.b)localObject1, (BaseFinderFeed)localObject3));
            }
          }
        }
        AppMethodBeat.o(165738);
        return;
      }
      localb = this.tPI;
      p.g(paramMenuItem, "menuItem");
      localObject4 = paramBaseFinderFeed;
      localObject2 = (Context)this.tPI.gte;
      int i = paramMenuItem.getItemId();
      if (i == localb.tqv)
      {
        paramMenuItem = s.vWt;
        if (localObject2 == null)
        {
          paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165738);
          throw paramMenuItem;
        }
        s.a.a(paramMenuItem, (AppCompatActivity)localObject2, ((BaseFinderFeed)localObject4).feedObject, 3, 4);
        AppMethodBeat.o(165738);
        return;
      }
      if (i == localb.pLU)
      {
        paramMenuItem = s.vWt;
        if (localObject2 == null)
        {
          paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(165738);
          throw paramMenuItem;
        }
        s.a.a((AppCompatActivity)localObject2, (BaseFinderFeed)localObject4, 0, 0, 28);
        AppMethodBeat.o(165738);
        return;
      }
      if (i == localb.jUx)
      {
        paramMenuItem = y.vXH;
        if ((y.h((BaseFinderFeed)localObject4)) && (((BaseFinderFeed)localObject4).feedObject.isPostFinish()))
        {
          if (!((Collection)((BaseFinderFeed)localObject4).feedObject.getLongVideoMediaList()).isEmpty()) {
            if (paramInt == 0) {
              break label1335;
            }
          }
          label1335:
          for (paramInt = 2131759606;; paramInt = 2131760453)
          {
            com.tencent.mm.ui.base.h.a((Context)localObject2, paramInt, 0, (DialogInterface.OnClickListener)new ab.b.k(localb, (BaseFinderFeed)localObject4, (Context)localObject2), null);
            AppMethodBeat.o(165738);
            return;
            paramInt = 0;
            break;
          }
        }
      }
      else if (i == localb.tLD)
      {
        if (localb.l((BaseFinderFeed)localObject4) >= 0)
        {
          localObject1 = localb.tPx;
          paramMenuItem = (MenuItem)localObject3;
          if (localObject1 != null)
          {
            localObject1 = ((ab.c)localObject1).getRecyclerView();
            paramMenuItem = (MenuItem)localObject3;
            if (localObject1 != null) {
              paramMenuItem = ((RecyclerView)localObject1).getAdapter();
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
          com.tencent.mm.plugin.finder.feed.logic.c.a((Context)localObject2, ((BaseFinderFeed)localObject4).feedObject.getId(), ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId(), (kotlin.g.a.b)new ab.b.m(localb, (BaseFinderFeed)localObject4, paramMenuItem));
          AppMethodBeat.o(165738);
        }
      }
      else
      {
        if (i == localb.pMa)
        {
          paramMenuItem = y.vXH;
          if (y.w((BaseFinderFeed)localObject4))
          {
            paramMenuItem = ((BaseFinderFeed)localObject4).feedObject.getLiveInfo();
            if (paramMenuItem != null)
            {
              l = paramMenuItem.liveId;
              paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
              com.tencent.mm.plugin.finder.feed.logic.a.b((Context)localObject2, l, ((BaseFinderFeed)localObject4).feedObject.getUserName());
              AppMethodBeat.o(165738);
              return;
            }
            AppMethodBeat.o(165738);
            return;
          }
          paramMenuItem = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
          com.tencent.mm.plugin.finder.feed.logic.a.a((Context)localObject2, ((BaseFinderFeed)localObject4).feedObject.field_id, 0L, 0, 12);
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tLH)
        {
          ((v)com.tencent.mm.kernel.g.af(v.class)).a(((BaseFinderFeed)localObject4).feedObject.getId(), ((BaseFinderFeed)localObject4).feedObject.getFeedObject(), ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId(), true, (ai)new ab.b.n((Context)localObject2));
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tLG)
        {
          ((v)com.tencent.mm.kernel.g.af(v.class)).a(((BaseFinderFeed)localObject4).feedObject.getId(), ((BaseFinderFeed)localObject4).feedObject.getFeedObject(), ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId(), false, (ai)new ab.b.o((Context)localObject2));
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tPB)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.q.vWb;
          com.tencent.mm.plugin.finder.utils.q.a((Context)localObject2, ((BaseFinderFeed)localObject4).feedObject, false);
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tPA)
        {
          if (((BaseFinderFeed)localObject4).feedObject.getStickyTime() != 0)
          {
            com.tencent.mm.ui.base.u.a((Context)localObject2, ((Context)localObject2).getString(2131760439), (u.b)ab.b.p.tPQ);
            AppMethodBeat.o(165738);
            return;
          }
          if (!((Collection)((BaseFinderFeed)localObject4).feedObject.getLongVideoMediaList()).isEmpty()) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            com.tencent.mm.ui.base.h.a((Context)localObject2, 2131759607, 0, (DialogInterface.OnClickListener)new ab.b.q((Context)localObject2, (BaseFinderFeed)localObject4), null);
            AppMethodBeat.o(165738);
            return;
          }
          paramMenuItem = com.tencent.mm.plugin.finder.utils.q.vWb;
          com.tencent.mm.plugin.finder.utils.q.a((Context)localObject2, ((BaseFinderFeed)localObject4).feedObject, true);
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tPD)
        {
          localb.tPz.a((Context)localObject2, ((BaseFinderFeed)localObject4).feedObject.getId(), false, ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId(), (kotlin.g.a.m)new ab.b.r((Context)localObject2));
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tPC)
        {
          if (((BaseFinderFeed)localObject4).feedObject.getPrivate_flag() == 1)
          {
            com.tencent.mm.ui.base.u.a(MMApplicationContext.getContext(), ((Context)localObject2).getString(2131760604), (u.b)ab.b.s.tPS);
            AppMethodBeat.o(165738);
            return;
          }
          localb.tPz.a((Context)localObject2, ((BaseFinderFeed)localObject4).feedObject.getId(), true, ((BaseFinderFeed)localObject4).feedObject.getObjectNonceId(), (kotlin.g.a.m)new ab.b.l((Context)localObject2));
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tLF)
        {
          localObject1 = new Intent();
          localObject3 = ((BaseFinderFeed)localObject4).feedObject.getFeedObject().objectDesc;
          paramMenuItem = localObject5;
          if (localObject3 != null) {
            paramMenuItem = ((FinderObjectDesc)localObject3).toByteArray();
          }
          ((Intent)localObject1).putExtra("postRefMediaList", paramMenuItem);
          paramMenuItem = y.vXH;
          ((Intent)localObject1).putExtra("postRefFeedInfo", y.u((BaseFinderFeed)localObject4).toByteArray());
          ((Intent)localObject1).putExtra("postType", ((BaseFinderFeed)localObject4).feedObject.getMediaType());
          ((Intent)localObject1).putExtra("key_finder_post_from", 5);
          paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)localObject2, (Intent)localObject1);
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tLE)
        {
          paramMenuItem = com.tencent.mm.plugin.finder.utils.g.vVq;
          if (localObject2 == null)
          {
            paramMenuItem = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(165738);
            throw paramMenuItem;
          }
          com.tencent.mm.plugin.finder.utils.g.a((BaseFinderFeed)localObject4, (MMActivity)localObject2);
          AppMethodBeat.o(165738);
          return;
        }
        if (i == localb.tLJ)
        {
          if (((BaseFinderFeed)localObject4).feedObject.isPostFinish())
          {
            paramMenuItem = FinderReporterUIC.wzC;
            paramMenuItem = FinderReporterUIC.a.fH((Context)localObject2);
            if (paramMenuItem != null)
            {
              paramInt = paramMenuItem.tCE;
              if (paramInt != 52) {
                break label2246;
              }
              if ((localObject2 instanceof FinderTopicTimelineUI)) {
                ((FinderTopicTimelineUI)localObject2).onBackPressed();
              }
            }
            for (;;)
            {
              paramMenuItem = com.tencent.mm.plugin.finder.report.k.vfA;
              com.tencent.mm.plugin.finder.report.k.a((Context)localObject2, 1, 1, Integer.valueOf(((BaseFinderFeed)localObject4).feedObject.field_finderObject.follow_feed_count));
              AppMethodBeat.o(165738);
              return;
              paramInt = 0;
              break;
              label2246:
              paramMenuItem = com.tencent.mm.plugin.finder.storage.data.e.vFX;
              e.a.n(((BaseFinderFeed)localObject4).feedObject);
              paramMenuItem = w.vXp;
              localObject3 = ((BaseFinderFeed)localObject4).feedObject.getFeedObject().objectDesc;
              paramMenuItem = (MenuItem)localObject1;
              if (localObject3 != null) {
                paramMenuItem = ((FinderObjectDesc)localObject3).feedBgmInfo;
              }
              w.a(paramMenuItem, Long.valueOf(((BaseFinderFeed)localObject4).feedObject.field_id), 0);
            }
          }
        }
        else
        {
          if (i == localb.tLM)
          {
            paramMenuItem = new Intent();
            paramMenuItem.putExtra("KEY_FROM_SCENE", 1);
            paramMenuItem.putExtra("KEY_USERNAME", z.aUg());
            paramMenuItem.putExtra("KEY_FINDER_SELF_FLAG", true);
            localObject1 = OccupyFinderUI10.udX;
            paramMenuItem.putExtra(OccupyFinderUI10.dez(), true);
            localObject1 = OccupyFinderUI10.udX;
            paramMenuItem.putExtra(OccupyFinderUI10.deA(), false);
            localObject1 = y.vXH;
            y.a(0, j.listOf(localObject4), null, paramMenuItem);
            localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.ac((Context)localObject2, paramMenuItem);
            AppMethodBeat.o(165738);
            return;
          }
          Toast.makeText((Context)localObject2, 2131760638, 1).show();
        }
      }
      AppMethodBeat.o(165738);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, LinkedList<Long>>
  {
    h(ab.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class i
    implements ai<ayy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements ai<ayy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class k
    implements DialogInterface.OnClickListener
  {
    k(ab.b paramb, BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178257);
      paramDialogInterface = z.aUg();
      p.g(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new av(paramDialogInterface, this.tEM.feedObject.getFeedObject());
      Object localObject = this.tPI.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.azz().a(paramDialogInterface.getType(), (com.tencent.mm.ak.i)new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(178256);
            if (((paramAnonymousq instanceof av)) && (((av)paramAnonymousq).hFK == paramDialogInterface.hFK)) {
              com.tencent.mm.kernel.g.azz().b(paramDialogInterface.getType(), (com.tencent.mm.ak.i)this);
            }
            paramAnonymousString = this.tPN.tPI.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              com.tencent.mm.ui.base.u.makeText(this.tPN.$context, 2131760456, 0).show();
            }
            AppMethodBeat.o(178256);
          }
        });
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramDialogInterface);
        AppMethodBeat.o(178257);
        return;
        localObject = this.tPI;
        Context localContext = this.$context;
        this.$context.getString(2131755998);
        ((ab.b)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a(localContext, this.$context.getString(2131756029), false, (DialogInterface.OnCancelListener)a.tPM));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a tPM;
      
      static
      {
        AppMethodBeat.i(178255);
        tPM = new a();
        AppMethodBeat.o(178255);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.m<aze, apg, kotlin.x>
  {
    l(Context paramContext)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, LinkedList<Long>>
  {
    m(ab.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class n
    implements ai<ayy>
  {
    n(Context paramContext) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$5", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class o
    implements ai<ayy>
  {
    o(Context paramContext) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class q
    implements DialogInterface.OnClickListener
  {
    q(Context paramContext, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(244061);
      paramDialogInterface = com.tencent.mm.plugin.finder.utils.q.vWb;
      com.tencent.mm.plugin.finder.utils.q.a(this.$context, this.tEM.feedObject, true);
      AppMethodBeat.o(244061);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.m<aze, apg, kotlin.x>
  {
    r(Context paramContext)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
  public static final class t
    implements k.b
  {
    public final RecyclerView dch()
    {
      AppMethodBeat.i(165742);
      Object localObject = this.tPI.tPx;
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((ab.c)localObject).getRecyclerView();
      AppMethodBeat.o(165742);
      return localObject;
    }
    
    public final DataBuffer<bo> dci()
    {
      AppMethodBeat.i(244067);
      DataBuffer localDataBuffer = this.tPI.getFeedLoader().getDataList();
      AppMethodBeat.o(244067);
      return localDataBuffer;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecyclerView.m>
  {
    public static final u tPT;
    
    static
    {
      AppMethodBeat.i(165745);
      tPT = new u();
      AppMethodBeat.o(165745);
    }
    
    u()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bo>, kotlin.x>
  {
    v(ab.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, bo>
  {
    w(ab.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>>
  {
    x(ab.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ab.b
 * JD-Core Version:    0.7.0.1
 */