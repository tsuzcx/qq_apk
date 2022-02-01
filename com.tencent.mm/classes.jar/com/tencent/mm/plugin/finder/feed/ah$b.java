package com.tencent.mm.plugin.finder.feed;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ab;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.TestPreloadPreview;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.al.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.g.a.m;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$IProfileTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "username", "", "selfFlag", "", "topicId", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;Ljava/lang/String;ZJ)V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_DELETE", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FLOAT_MINI_VIEW", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_POST_SAME_STYLE", "MENU_ID_REPRINT", "MENU_ID_SET_CANCEL_STICKY", "MENU_ID_SET_PRIVATE", "MENU_ID_SET_PUBLIC", "MENU_ID_SET_STICKY", "MENU_ID_SHARE_RINGTONE", "MENU_ID_SHARE_TEXT_STATUS", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SPEED_CTRL", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "isSelf", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPoolCache", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getMediaBannerViewPoolCache", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "mediaBannerViewPoolCache$delegate", "observerForExposeReport", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "scene", "getSelfFlag", "()Z", "stickyComponent", "Lcom/tencent/mm/plugin/finder/feed/component/StickyFeedComponent;", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "getTopicId", "()J", "getUsername", "()Ljava/lang/String;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dataStore", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "doSceneNextPage", "", "getActivity", "getCommentDrawer", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "from", "getCreateSecondMoreMenuListener", "getDataIndex", "getFeedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getMediaBannerRecyclerViewPool", "getMediaBannerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getVideoCore", "handleMenuSelected", "menuItem", "Landroid/view/MenuItem;", "handleSelfMenuSelected", "Landroid/content/Context;", "initData", "beforeTime", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "initVideoAbout", "isFinderSelfScene", "keep", "p0", "onAttach", "callback", "onDetach", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLikeLocalFeed", "isPrivate", "onUIPause", "onUIResume", "removeDataAt", "index", "reportDelete", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "isClick", "requestRefresh", "shareFeed", "shareFeedToSns", "updateBottomSheet", "plugin-finder_release"})
public final class ah$b
  implements ah.a, i, com.tencent.mm.plugin.finder.presenter.base.a<ah.c>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  private boolean fCB;
  public final MMActivity iXq;
  private final int mLK;
  private int scene;
  Dialog tipDialog;
  final String username;
  private final int wXf;
  private final int wXg;
  private final kotlin.f xAn;
  private ah.c xAo;
  private final kotlin.f xAp;
  private final com.tencent.mm.plugin.finder.feed.component.b xAq;
  private final int xAr;
  private final int xAs;
  private final int xAt;
  private final int xAu;
  private com.tencent.mm.plugin.finder.view.c xAv;
  private final b xAw;
  private final d xAx;
  private final boolean xAy;
  final long xee;
  private final int xhI;
  private final com.tencent.mm.plugin.finder.video.l xkW;
  private final int xvB;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> xvE;
  private final com.tencent.mm.plugin.finder.view.f xvK;
  private final com.tencent.mm.plugin.finder.feed.model.i xve;
  private final k xvf;
  private final int xvj;
  private final int xvk;
  private final int xvl;
  private final int xvm;
  private final int xvn;
  private final int xvo;
  private final int xvq;
  private final int xvr;
  private final int xvs;
  private final int xvt;
  private final int xvu;
  private final int xvx;
  private final int xvy;
  private final int xvz;
  private com.tencent.mm.plugin.finder.event.base.d xxI;
  
  public ah$b(MMActivity paramMMActivity, com.tencent.mm.plugin.finder.view.f paramf, String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(233177);
    this.iXq = paramMMActivity;
    this.xvK = paramf;
    this.username = paramString;
    this.xAy = paramBoolean;
    this.xee = paramLong;
    this.TAG = "Finder.ProfileTimelinePresenter";
    this.xAn = kotlin.g.ar((kotlin.g.a.a)w.xAJ);
    this.xvE = new CopyOnWriteArraySet();
    this.xAp = kotlin.g.ar((kotlin.g.a.a)new c(this));
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    paramMMActivity = com.tencent.mm.ui.component.g.Xox;
    this.xvf = ((com.tencent.mm.plugin.finder.live.component.y)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.live.component.y.class)).yci;
    if ((this.username.equals(z.bdh())) && (this.xAy))
    {
      paramBoolean = true;
      this.fCB = paramBoolean;
      if (!this.fCB) {
        break label410;
      }
    }
    for (;;)
    {
      this.scene = i;
      this.xAq = new com.tencent.mm.plugin.finder.feed.component.b();
      this.xvj = 99;
      this.xhI = 100;
      this.xvk = 101;
      this.wXf = 102;
      this.wXg = 103;
      this.xvl = 104;
      this.xvm = 105;
      this.xvn = 106;
      this.xvo = 107;
      this.mLK = 108;
      this.xAr = 109;
      this.xAs = 110;
      this.xAt = 111;
      this.xAu = 112;
      this.xvq = 113;
      this.xvt = 114;
      this.xvr = 115;
      this.xvs = 116;
      this.xvu = 117;
      this.xvx = 118;
      this.xvy = 119;
      this.xvz = 120;
      this.xvB = 200;
      this.xkW = new com.tencent.mm.plugin.finder.video.l();
      this.xAw = new b(this);
      this.xAx = new d(this);
      AppMethodBeat.o(233177);
      return;
      paramBoolean = false;
      break;
      label410:
      i = 2;
    }
  }
  
  private static void a(bid parambid, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(233158);
    com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i();
    if (paramInt == 1) {}
    for (Object localObject = "forward";; localObject = "tridot")
    {
      locali.g("ref_eid", localObject);
      localObject = com.tencent.mm.plugin.finder.report.am.zZN;
      com.tencent.mm.plugin.finder.report.am.a(parambid, paramString, paramBoolean, (JSONObject)locali);
      AppMethodBeat.o(233158);
      return;
    }
  }
  
  public final q.f a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(233154);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(parame, "sheet");
    paramBaseFinderFeed = (q.f)new f(this, paramBaseFinderFeed, parame);
    AppMethodBeat.o(233154);
    return paramBaseFinderFeed;
  }
  
  public final q.f a(final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.e parame, final int paramInt)
  {
    AppMethodBeat.i(233152);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(parame, "sheet");
    paramBaseFinderFeed = (q.f)new e(this, paramBaseFinderFeed, parame, paramInt);
    AppMethodBeat.o(233152);
    return paramBaseFinderFeed;
  }
  
  public final q.g a(final BaseFinderFeed paramBaseFinderFeed, final int paramInt, final com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(233156);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    kotlin.g.b.p.k(parami, "holder");
    paramBaseFinderFeed = (q.g)new g(this, paramBaseFinderFeed, parami, paramInt);
    AppMethodBeat.o(233156);
    return paramBaseFinderFeed;
  }
  
  public final void a(ah.c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(165754);
    kotlin.g.b.p.k(paramc, "callback");
    this.xAo = paramc;
    int i;
    Object localObject1;
    if (this.xAy)
    {
      i = 8;
      localObject1 = getFeedLoader();
      if ((localObject1 instanceof FinderProfileFeedLoader)) {
        break label540;
      }
      localObject1 = null;
    }
    label535:
    label540:
    for (;;)
    {
      if (localObject1 != null) {
        ((FinderProfileFeedLoader)localObject1).setFetchEndCallback((kotlin.g.a.b)new x(this));
      }
      EventCenter.instance.add((IListener)this.xAw);
      EventCenter.instance.add((IListener)this.xAx);
      this.xAv = new com.tencent.mm.plugin.finder.view.c((BaseFinderFeedLoader)getFeedLoader());
      localObject1 = this.xAv;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.view.c)localObject1).alive();
      }
      localObject1 = this.xkW;
      Object localObject3 = this.xAo;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      com.tencent.mm.plugin.finder.video.l.a((com.tencent.mm.plugin.finder.video.l)localObject1, (AppCompatActivity)((ah.c)localObject3).iXq, (l.b)new v(this), 4);
      localObject1 = com.tencent.mm.plugin.finder.preload.c.zKl;
      Object localObject4;
      Object localObject5;
      if (com.tencent.mm.plugin.finder.preload.c.dMG())
      {
        localObject3 = (TestPreloadPreview)this.iXq.findViewById(b.f.test_preload_view);
        if (localObject3 != null)
        {
          ((TestPreloadPreview)localObject3).setVisibility(0);
          localObject4 = getFeedLoader().getDataListJustForAdapter();
          localObject5 = this.xkW;
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject1 = aj.a.fZ((Context)this.iXq);
          if (localObject1 == null) {
            break label535;
          }
        }
      }
      for (localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);; localObject1 = null)
      {
        ((TestPreloadPreview)localObject3).a((DataBuffer)localObject4, 0, (com.tencent.mm.plugin.finder.video.l)localObject5, (com.tencent.mm.plugin.finder.event.base.c)localObject1, -1);
        this.xve.a(this.scene, i, (kotlin.g.a.b)new y(this));
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = aj.a.fZ((Context)this.iXq);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)this.xve);
          }
        }
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        this.xxI = new com.tencent.mm.plugin.finder.report.p(((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY()).xxI;
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = aj.a.fZ((Context)this.iXq);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
          if (localObject1 != null)
          {
            localObject3 = this.xxI;
            if (localObject3 == null) {
              kotlin.g.b.p.bGy("observerForExposeReport");
            }
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)localObject3);
          }
        }
        localObject3 = this.xvf;
        localObject4 = (m)new z(this);
        localObject5 = this.xAo;
        localObject1 = localObject2;
        if (localObject5 != null) {
          localObject1 = ((ah.c)localObject5).getRecyclerView();
        }
        ((k)localObject3).a((m)localObject4, (RecyclerView)localObject1);
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        localObject1 = aj.a.fZ((Context)this.iXq);
        if (localObject1 != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.finder.event.base.c)localObject1).a((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
          }
        }
        localObject1 = com.tencent.mm.ui.component.g.Xox;
        ((com.tencent.mm.plugin.finder.viewmodel.component.s)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.s.class)).u(paramc.getRecyclerView());
        AppMethodBeat.o(165754);
        return;
        i = 1;
        break;
      }
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(233166);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    Object localObject2 = com.tencent.mm.plugin.finder.model.al.zAN;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.aj localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
    com.tencent.mm.plugin.finder.model.al.a((bid)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed.contact));
    AppMethodBeat.o(233166);
  }
  
  public final void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo)
  {
    AppMethodBeat.i(165767);
    kotlin.g.b.p.k(paramFinderItem, "feed");
    kotlin.g.b.p.k(paramFinderCommentInfo, "comment");
    AppMethodBeat.o(165767);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(233160);
    kotlin.g.b.p.k(paramFinderItem, "feed");
    parami = com.tencent.mm.plugin.finder.model.r.zAk;
    com.tencent.mm.plugin.finder.model.r.a((AppCompatActivity)this.iXq, paramFinderItem, paramBoolean);
    AppMethodBeat.o(233160);
  }
  
  public final void b(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(233161);
    kotlin.g.b.p.k(paramFinderItem, "feed");
    ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, paramFinderItem, null, 0, null, 28);
    AppMethodBeat.o(233161);
  }
  
  public final boolean dsp()
  {
    return this.fCB;
  }
  
  public final RecyclerView.m dsv()
  {
    AppMethodBeat.i(233170);
    RecyclerView.m localm = (RecyclerView.m)this.xAn.getValue();
    AppMethodBeat.o(233170);
    return localm;
  }
  
  public final com.tencent.mm.plugin.finder.view.f dsw()
  {
    return this.xvK;
  }
  
  public final ArrayList<bu> dta()
  {
    AppMethodBeat.i(233149);
    ArrayList localArrayList = (ArrayList)getFeedLoader().getDataListJustForAdapter();
    AppMethodBeat.o(233149);
    return localArrayList;
  }
  
  public final MMActivity getActivity()
  {
    return this.iXq;
  }
  
  public final FinderProfileFeedLoader getFeedLoader()
  {
    AppMethodBeat.i(233142);
    FinderProfileFeedLoader localFinderProfileFeedLoader = (FinderProfileFeedLoader)this.xAp.getValue();
    AppMethodBeat.o(233142);
    return localFinderProfileFeedLoader;
  }
  
  public final com.tencent.mm.plugin.finder.video.l getVideoCore()
  {
    return this.xkW;
  }
  
  public final void k(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(233163);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    ac.a.a(ac.AEJ, (AppCompatActivity)this.iXq, paramBaseFinderFeed, 4, 0, 20);
    AppMethodBeat.o(233163);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165766);
    kotlin.g.b.p.k(parama, "p0");
    this.xvE.add(parama);
    AppMethodBeat.o(165766);
  }
  
  public final void l(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(233167);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    bid localbid = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
    localObject1 = ai.zAJ;
    localObject1 = paramBaseFinderFeed.contact;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.api.i)localObject1).getUsername();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = an.xci;
    ai.a(localbid, (String)localObject1, an.dnL(), paramBaseFinderFeed.mf(), paramBaseFinderFeed.isDeepEnjoy, 96);
    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed != null)
    {
      localObject1 = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramBaseFinderFeed = "";
    }
    localObject1 = com.tencent.mm.plugin.finder.api.i.xai;
    d.a.dP(paramBaseFinderFeed, com.tencent.mm.plugin.finder.api.i.dny());
    AppMethodBeat.o(233167);
  }
  
  public final int m(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165752);
    kotlin.g.b.p.k(paramBaseFinderFeed, "feed");
    int i = getFeedLoader().getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
    AppMethodBeat.o(165752);
    return i;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165757);
    this.xve.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.xve);
      }
    }
    this.xvf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
      }
    }
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null)
      {
        com.tencent.mm.plugin.finder.event.base.d locald = this.xxI;
        if (locald == null) {
          kotlin.g.b.p.bGy("observerForExposeReport");
        }
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b(locald);
      }
    }
    com.tencent.mm.plugin.finder.storage.data.f.Anc.clearCache();
    localObject = ((Iterable)this.xvE).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.vending.e.a)((Iterator)localObject).next()).dead();
    }
    this.xvE.clear();
    this.xAo = null;
    EventCenter.instance.removeListener((IListener)this.xAw);
    EventCenter.instance.removeListener((IListener)this.xAx);
    localObject = this.xAv;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.view.c)localObject).dead();
      AppMethodBeat.o(165757);
      return;
    }
    AppMethodBeat.o(165757);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(165729);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.em(ah.b.c(this.xAz), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(165729);
        return localObject;
      case 4: 
      case 3002: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new u(ah.b.b(this.xAz), (i)this.xAz, false, 0, 12);
          AppMethodBeat.o(165729);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.am(ah.b.b(this.xAz), (i)this.xAz, false, 0, 12);
        AppMethodBeat.o(165729);
        return localObject;
      case 2: 
      case 3001: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.r((i)this.xAz, false, 0, 6);
          AppMethodBeat.o(165729);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new v((i)this.xAz, false, 0, 6);
        AppMethodBeat.o(165729);
        return localObject;
      }
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.s(ah.b.b(this.xAz), (i)this.xAz, 0, 0, 28);
        AppMethodBeat.o(165729);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.y(ah.b.b(this.xAz), (i)this.xAz);
      AppMethodBeat.o(165729);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.view.g
  {
    private String tag;
    
    b()
    {
      AppMethodBeat.i(165733);
      this.tag = ah.b.c(localb);
      AppMethodBeat.o(165733);
    }
    
    public final FinderItem KQ(long paramLong)
    {
      AppMethodBeat.i(165731);
      Object localObject = ah.b.a(this.xAz);
      if (localObject != null)
      {
        localObject = ((ah.c)localObject).getRecyclerView();
        if (localObject != null)
        {
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject == null)
          {
            localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165731);
            throw ((Throwable)localObject);
          }
          localObject = com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject, paramLong);
          if (localObject != null)
          {
            int i = ((RecyclerView.v)localObject).md();
            localObject = (bu)this.xAz.getFeedLoader().safeGet(i);
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
    
    public final void a(long paramLong, bfw parambfw)
    {
      AppMethodBeat.i(165732);
      Object localObject1 = ah.b.a(this.xAz);
      if (localObject1 != null)
      {
        localObject1 = ((ah.c)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          Object localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 == null)
          {
            parambfw = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<androidx.recyclerview.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(165732);
            throw parambfw;
          }
          localObject2 = com.tencent.mm.view.recyclerview.h.c((com.tencent.mm.view.recyclerview.h)localObject2, paramLong);
          if (localObject2 != null)
          {
            int i = ((RecyclerView.v)localObject2).md();
            localObject1 = ((RecyclerView)localObject1).getAdapter();
            if (localObject1 != null)
            {
              ((RecyclerView.a)localObject1).d(i, new kotlin.o(Integer.valueOf(1), parambfw));
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FinderProfileFeedLoader>
  {
    c(ah.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class d
    extends IListener<hr>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements q.f
  {
    e(ah.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame, int paramInt) {}
    
    public final void onCreateMMMenu(final com.tencent.mm.ui.base.o paramo)
    {
      int j = 0;
      AppMethodBeat.i(165736);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      StringBuilder localStringBuilder;
      com.tencent.mm.plugin.finder.utils.aj localaj;
      boolean bool2;
      boolean bool1;
      if (!ah.b.d(this.xAz))
      {
        localObject1 = this.xAz.iXq.getString(b.j.app_share_to_weixin);
        kotlin.g.b.p.j(localObject1, "context.getString(R.string.app_share_to_weixin)");
        localObject2 = this.xAz.iXq.getString(b.j.finder_share_timeline);
        kotlin.g.b.p.j(localObject2, "context.getString(R.string.finder_share_timeline)");
        kotlin.g.b.p.j(this.xAz.iXq.getString(b.j.favorite), "context.getString(R.string.favorite)");
        localObject3 = ah.b.c(this.xAz);
        localStringBuilder = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
        Log.i((String)localObject3, com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.t.ADN;
            localObject2 = com.tencent.mm.plugin.finder.utils.t.a((Context)this.xAz.iXq, paramBaseFinderFeed, ah.b.e(this.xAz), (kotlin.g.a.b)new a(this, paramo));
            localObject1 = (String)((kotlin.r)localObject2).Mx;
            localObject2 = (String)((kotlin.r)localObject2).My;
            bool2 = true;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        paramo.a(ah.b.g(this.xAz), (CharSequence)localObject1, b.i.finder_icons_filled_share, this.xAz.iXq.getResources().getColor(b.c.Brand), bool1);
        paramo.a(ah.b.f(this.xAz), (CharSequence)localObject2, b.i.bottomsheet_icon_moment, 0, bool2);
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        int i;
        if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.c.ABD;
          if (!com.tencent.mm.plugin.finder.upload.action.c.ecy().p(paramBaseFinderFeed.feedObject.getFeedObject()))
          {
            i = 1;
            label376:
            if (i == 0) {
              break label797;
            }
            paramo.a(ah.b.h(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.favorite), b.i.finder_icons_filled_star2, this.xAz.iXq.getResources().getColor(b.c.orange_100));
          }
        }
        else
        {
          label427:
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dXB().aSr()).intValue() == 1)
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject.getFeedObject()))
            {
              localObject1 = n.zWF;
              n.j((Context)this.xAz.iXq, paramBaseFinderFeed.mf());
              paramo.a(ah.b.j(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_share_text_stauts_title), b.i.state_icon_main, this.xAz.iXq.getResources().getColor(b.c.Blue));
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.C(paramBaseFinderFeed.feedObject.getFeedObject())) {
            paramo.a(ah.b.k(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_share_ringtone_title), b.i.finder_icons_colorring, this.xAz.iXq.getResources().getColor(b.c.Yellow));
          }
        }
        label797:
        do
        {
          paramo = n.zWF;
          long l = paramBaseFinderFeed.mf();
          paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramo = aj.a.fZ((Context)this.xAz.iXq);
          i = j;
          if (paramo != null) {
            i = paramo.xkX;
          }
          n.O(l, i);
          paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramo = aj.a.fZ((Context)this.xAz.iXq);
          if (paramo == null) {
            break label1542;
          }
          paramo = com.tencent.mm.plugin.finder.viewmodel.component.aj.b(paramo);
          if (paramo == null) {
            break label1542;
          }
          paramo.dpO().KL(paramBaseFinderFeed.mf());
          AppMethodBeat.o(165736);
          return;
          if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
            break label1557;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
          localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeCollect", b.j.finder_self_see_tips_fav);
          bool2 = true;
          bool1 = true;
          break;
          i = 0;
          break label376;
          paramo.a(ah.b.i(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_cancel_fav_title), b.i.finder_icons_filled_unstar2, this.xAz.iXq.getResources().getColor(b.c.orange_100));
          break label427;
          kotlin.g.b.p.j(paramo, "menu");
        } while (!paramo.hJO());
        localObject2 = MMApplicationContext.getContext().getString(b.j.app_share_to_weixin);
        kotlin.g.b.p.j(localObject2, "MMApplicationContext.get…ring.app_share_to_weixin)");
        localObject1 = MMApplicationContext.getContext().getString(b.j.finder_share_timeline);
        kotlin.g.b.p.j(localObject1, "MMApplicationContext.get…ng.finder_share_timeline)");
        kotlin.g.b.p.j(MMApplicationContext.getContext().getString(b.j.favorite), "MMApplicationContext.get…String(R.string.favorite)");
        localObject3 = ah.b.c(this.xAz);
        localStringBuilder = new StringBuilder("lxl object Status: ").append(paramBaseFinderFeed.feedObject.getFeedObject().objectStatus).append(" isOnlySelfSee=").append(paramBaseFinderFeed.feedObject.isOnlySelfSee()).append(" isSelf=");
        localaj = com.tencent.mm.plugin.finder.utils.aj.AGc;
        Log.i((String)localObject3, com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed) + " isNotShare=" + paramBaseFinderFeed.feedObject.isNotShare());
        if (paramBaseFinderFeed.feedObject.isOnlySelfSee())
        {
          localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed))
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.t.ADN;
            localObject1 = com.tencent.mm.plugin.finder.utils.t.a((Context)this.xAz.iXq, paramBaseFinderFeed, ah.b.e(this.xAz), (kotlin.g.a.b)new b(this, paramo));
            localObject2 = (String)((kotlin.r)localObject1).Mx;
            localObject1 = (String)((kotlin.r)localObject1).My;
            bool2 = true;
            bool1 = true;
          }
        }
        for (;;)
        {
          label1113:
          i = ah.b.g(this.xAz);
          localObject2 = (CharSequence)localObject2;
          int k = b.i.finder_icons_filled_share;
          localObject3 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject3, "MMApplicationContext.getContext()");
          paramo.a(i, (CharSequence)localObject2, k, ((Context)localObject3).getResources().getColor(b.c.Brand), bool1);
          paramo.a(ah.b.f(this.xAz), (CharSequence)localObject1, b.i.bottomsheet_icon_moment, 0, bool2);
          localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.dXB().aSr()).intValue() == 1)
          {
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject.getFeedObject()))
            {
              localObject1 = n.zWF;
              n.j((Context)this.xAz.iXq, paramBaseFinderFeed.mf());
              paramo.a(ah.b.j(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_share_text_stauts_title), b.i.state_icon_main, this.xAz.iXq.getResources().getColor(b.c.Blue));
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.C(paramBaseFinderFeed.feedObject.getFeedObject())) {
            paramo.a(ah.b.k(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_share_ringtone_title), b.i.finder_icons_colorring, this.xAz.iXq.getResources().getColor(b.c.Yellow));
          }
          paramo = com.tencent.mm.ui.component.g.Xox;
          localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xAz.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
          ah.b.a((bid)localObject1, "delete", paramInt);
          paramo = com.tencent.mm.plugin.finder.report.am.zZN;
          if (paramInt == 1) {}
          for (paramo = "forward";; paramo = "tridot")
          {
            com.tencent.mm.plugin.finder.report.am.a((bid)localObject1, paramo, true, (JSONObject)new com.tencent.mm.ad.i());
            break;
            if ((!paramBaseFinderFeed.feedObject.isOnlySelfSee()) && (!paramBaseFinderFeed.feedObject.isNotShare())) {
              break label1548;
            }
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeForward", b.j.finder_self_see_tips_forward);
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeShare", b.j.finder_self_see_tips_sns);
            localObject3 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            com.tencent.mm.plugin.finder.utils.aj.el("FinderSafeSelfSeeCollect", b.j.finder_self_see_tips_fav);
            bool2 = true;
            bool1 = true;
            break label1113;
          }
          label1542:
          AppMethodBeat.o(165736);
          return;
          label1548:
          bool2 = false;
          bool1 = false;
        }
        label1557:
        bool2 = false;
        bool1 = false;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, x>
    {
      a(ah.b.e parame, com.tencent.mm.ui.base.o paramo)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lkotlin/Triple;", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<kotlin.r<? extends String, ? extends String, ? extends String>, x>
    {
      b(ah.b.e parame, com.tencent.mm.ui.base.o paramo)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements q.f
  {
    f(ah.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      AppMethodBeat.i(165737);
      if (paramBaseFinderFeed.feedObject.isLongVideo())
      {
        paramo.b(ah.b.l(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_live_more_action_mini_window), b.i.icons_filled_mini_window_2);
        localObject1 = ah.b.a(this.xAz);
        if (localObject1 != null)
        {
          localObject1 = ((ah.c)localObject1).getRecyclerView();
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.al.Bou;
            localObject2 = al.a.w((RecyclerView)localObject1);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label124;
            }
          }
        }
        localObject1 = this.xAz.iXq.getString(b.j.mega_video_play_speed_text);
        kotlin.g.b.p.j(localObject1, "context.getString(R.stri…ga_video_play_speed_text)");
        label124:
        paramo.b(ah.b.m(this.xAz), (CharSequence)localObject1, b.i.icons_outlined_play_control_2);
      }
      Object localObject1 = ab.AEA;
      localObject1 = (Activity)this.xAz.iXq;
      Object localObject2 = paramBaseFinderFeed;
      kotlin.g.b.p.j(paramo, "menu");
      ab.a((Activity)localObject1, (BaseFinderFeed)localObject2, paramo, parame, ah.b.n(this.xAz));
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      int i;
      int j;
      if ((com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed)) && (ah.b.d(this.xAz)))
      {
        paramo.aW(ah.b.o(this.xAz), b.j.app_delete, b.i.icons_outlined_delete);
        label340:
        int k;
        if (paramBaseFinderFeed.feedObject.isCommentClose())
        {
          paramo.b(ah.b.p(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_feed_open_comment), b.i.icons_outlined_comment);
          localObject1 = com.tencent.mm.plugin.finder.utils.y.AEi;
          localObject1 = (Context)this.xAz.iXq;
          paramBaseFinderFeed.feedObject.getMediaType();
          i = ah.b.r(this.xAz);
          j = ah.b.s(this.xAz);
          if (paramBaseFinderFeed.feedObject.getPrivate_flag() != 1) {
            break label645;
          }
          bool1 = true;
          com.tencent.mm.plugin.finder.utils.y.a(paramo, (Context)localObject1, i, j, bool1);
          ah.b.t(this.xAz);
          localObject1 = (Context)this.xAz.iXq;
          j = ah.b.u(this.xAz);
          k = ah.b.v(this.xAz);
          if (paramBaseFinderFeed.feedObject.getStickyTime() == 0) {
            break label651;
          }
          i = 1;
          label402:
          kotlin.g.b.p.k(paramo, "menu");
          kotlin.g.b.p.k(localObject1, "context");
          if (i == 0) {
            break label656;
          }
          paramo.b(j, (CharSequence)((Context)localObject1).getString(b.j.finder_cancel_sticky), b.i.icons_outlined_top_off);
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject))
          {
            i = ah.b.w(this.xAz);
            localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            localObject1 = (CharSequence)com.tencent.mm.plugin.finder.utils.aj.x(paramBaseFinderFeed);
            j = b.i.icons_outlined_bgm_play;
            if (paramBaseFinderFeed.feedObject.isPostFinish())
            {
              bool1 = bool2;
              if (!paramBaseFinderFeed.feedObject.isPostFailed()) {}
            }
            else
            {
              bool1 = true;
            }
            paramo.a(i, (CharSequence)localObject1, j, bool1);
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy()) {
            break label800;
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if ((!com.tencent.mm.plugin.finder.utils.aj.isAnyEnableFullScreenEnjoy()) || ((paramBaseFinderFeed.bAQ() != 4) && (paramBaseFinderFeed.bAQ() != 2))) {
            break label800;
          }
          paramo.b(ah.b.x(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_feed_open_in_full_window), b.i.finder_icons_outlined_max_window);
          AppMethodBeat.o(165737);
          return;
          paramo.b(ah.b.q(this.xAz), (CharSequence)this.xAz.iXq.getString(b.j.finder_feed_close_comment), b.i.finder_feed_discomment);
          break;
          label645:
          bool1 = false;
          break label340;
          label651:
          i = 0;
          break label402;
          label656:
          paramo.b(k, (CharSequence)((Context)localObject1).getString(b.j.finder_set_sticky), b.i.icons_outlined_top);
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject))
        {
          i = ah.b.w(this.xAz);
          localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject1 = (CharSequence)com.tencent.mm.plugin.finder.utils.aj.x(paramBaseFinderFeed);
          j = b.i.icons_outlined_bgm_play;
          if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed())) {
            bool1 = true;
          }
          paramo.a(i, (CharSequence)localObject1, j, bool1);
        }
        paramo.aW(ah.b.y(this.xAz), b.j.more_menu_back, b.i.icons_outlined_report_problem);
      }
      label800:
      AppMethodBeat.o(165737);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements q.g
  {
    g(ah.b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.i parami, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(165738);
      kotlin.g.b.p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Object localObject;
      if (paramInt == ah.b.l(this.xAz))
      {
        paramMenuItem = ah.b.a(this.xAz);
        if (paramMenuItem != null)
        {
          localObject = com.tencent.mm.ui.component.g.Xox;
          com.tencent.mm.plugin.finder.viewmodel.component.t.a((com.tencent.mm.plugin.finder.viewmodel.component.t)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xAz.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.t.class), new bs(paramBaseFinderFeed.feedObject.getFeedObject()), paramMenuItem.getRecyclerView());
          AppMethodBeat.o(165738);
          return;
        }
        AppMethodBeat.o(165738);
        return;
      }
      if (paramInt == ah.b.m(this.xAz))
      {
        if (ah.b.a(this.xAz) != null)
        {
          List localList = (List)new ArrayList();
          paramMenuItem = parami.RD(b.f.finder_feed_full_footer_layout);
          if (paramMenuItem != null) {
            localList.add(paramMenuItem);
          }
          paramMenuItem = (FinderVideoLayout)parami.RD(b.f.finder_banner_video_layout);
          if (paramMenuItem != null) {}
          for (paramMenuItem = paramMenuItem.getVideoView();; paramMenuItem = null)
          {
            localObject = paramMenuItem;
            if (!(paramMenuItem instanceof FinderThumbPlayerProxy)) {
              localObject = null;
            }
            paramMenuItem = (FinderThumbPlayerProxy)localObject;
            if (paramMenuItem == null) {
              break;
            }
            localObject = com.tencent.mm.ui.component.g.Xox;
            com.tencent.mm.plugin.finder.viewmodel.component.al.a((com.tencent.mm.plugin.finder.viewmodel.component.al)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.xAz.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.al.class), localList, paramMenuItem);
            AppMethodBeat.o(165738);
            return;
          }
        }
        AppMethodBeat.o(165738);
        return;
      }
      if (!ah.b.d(this.xAz))
      {
        ah.b.a(this.xAz, paramMenuItem, paramBaseFinderFeed);
        AppMethodBeat.o(165738);
        return;
      }
      ah.b.a(this.xAz, paramMenuItem, paramBaseFinderFeed, (Context)this.xAz.iXq, paramInt);
      AppMethodBeat.o(165738);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, LinkedList<Long>>
  {
    h(ah.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$3", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.findersdk.a.aj<bet>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class j
    implements com.tencent.mm.plugin.findersdk.a.aj<bet>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class k
    implements w.b
  {
    k(ah.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(276942);
      Object localObject;
      if (paramView != null)
      {
        localObject = (TextView)paramView.findViewById(b.f.toast_text);
        if (localObject != null) {
          ((TextView)localObject).setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(b.f.toast_img);
        if (paramView != null)
        {
          paramView.setImageResource(b.i.icons_filled_done);
          localObject = paramView.getContext();
          kotlin.g.b.p.j(localObject, "context");
          paramView.setIconColor(((Context)localObject).getResources().getColor(b.c.White));
        }
      }
      this.xAz.a(this.xno.feedObject, true, null);
      AppMethodBeat.o(276942);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class l
    implements w.b
  {
    l(ah.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(229008);
      Object localObject;
      if (paramView != null)
      {
        localObject = (TextView)paramView.findViewById(b.f.toast_text);
        if (localObject != null) {
          ((TextView)localObject).setTextSize(1, 14.0F);
        }
      }
      if (paramView != null)
      {
        paramView = (WeImageView)paramView.findViewById(b.f.toast_img);
        if (paramView != null)
        {
          paramView.setImageResource(b.i.icons_filled_done);
          localObject = paramView.getContext();
          kotlin.g.b.p.j(localObject, "context");
          paramView.setIconColor(((Context)localObject).getResources().getColor(b.c.White));
        }
      }
      this.xAz.a(this.xno.feedObject, false, null);
      AppMethodBeat.o(229008);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class m
    implements DialogInterface.OnClickListener
  {
    m(ah.b paramb, BaseFinderFeed paramBaseFinderFeed, Context paramContext) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(178257);
      paramDialogInterface = z.bdh();
      kotlin.g.b.p.j(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new ay(paramDialogInterface, this.xno.feedObject.getFeedObject());
      Object localObject = this.xAz.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.aGY().a(paramDialogInterface.getType(), (com.tencent.mm.an.i)new com.tencent.mm.an.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
          {
            AppMethodBeat.i(178256);
            if (((paramAnonymousq instanceof ay)) && (((ay)paramAnonymousq).xbk == paramDialogInterface.xbk)) {
              com.tencent.mm.kernel.h.aGY().b(paramDialogInterface.getType(), (com.tencent.mm.an.i)this);
            }
            paramAnonymousString = this.xAD.xAz.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
              w.makeText(this.xAD.$context, b.j.finder_profile_del_feed_failed, 0).show();
            }
            AppMethodBeat.o(178256);
          }
        });
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramDialogInterface);
        AppMethodBeat.o(178257);
        return;
        localObject = this.xAz;
        Context localContext = this.$context;
        this.$context.getString(b.j.app_tip);
        ((ah.b)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a(localContext, this.$context.getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.xAC));
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xAC;
      
      static
      {
        AppMethodBeat.i(178255);
        xAC = new a();
        AppMethodBeat.o(178255);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements m<bfa, aqu, x>
  {
    n(Context paramContext)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "", "subType", "", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, LinkedList<Long>>
  {
    o(ah.b paramb, BaseFinderFeed paramBaseFinderFeed, RecyclerView.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$4", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class p
    implements com.tencent.mm.plugin.findersdk.a.aj<bet>
  {
    p(Context paramContext) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$handleSelfMenuSelected$5", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class q
    implements com.tencent.mm.plugin.findersdk.a.aj<bet>
  {
    q(Context paramContext) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class r
    implements w.b
  {
    public static final r xAG;
    
    static
    {
      AppMethodBeat.i(270640);
      xAG = new r();
      AppMethodBeat.o(270640);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(270639);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(270639);
          return;
        }
      }
      AppMethodBeat.o(270639);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class s
    implements DialogInterface.OnClickListener
  {
    s(Context paramContext, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(274863);
      paramDialogInterface = com.tencent.mm.plugin.finder.utils.y.AEi;
      com.tencent.mm.plugin.finder.utils.y.a(this.$context, this.xno.feedObject, true);
      AppMethodBeat.o(274863);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModProfileStickySetting;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements m<bfa, aqu, x>
  {
    t(Context paramContext)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class u
    implements w.b
  {
    public static final u xAI;
    
    static
    {
      AppMethodBeat.i(291116);
      xAI = new u();
      AppMethodBeat.o(291116);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(291115);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(291115);
          return;
        }
      }
      AppMethodBeat.o(291115);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
  public static final class v
    implements l.b
  {
    public final RecyclerView dsx()
    {
      AppMethodBeat.i(283452);
      Object localObject = ah.b.a(this.xAz);
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = ((ah.c)localObject).getRecyclerView();
      AppMethodBeat.o(283452);
      return localObject;
    }
    
    public final DataBuffer<bu> dsy()
    {
      AppMethodBeat.i(283453);
      DataBuffer localDataBuffer = this.xAz.getFeedLoader().getDataList();
      AppMethodBeat.o(283453);
      return localDataBuffer;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecyclerView.m>
  {
    public static final w xAJ;
    
    static
    {
      AppMethodBeat.i(165745);
      xAJ = new w();
      AppMethodBeat.o(165745);
    }
    
    w()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    x(ah.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, bu>
  {
    y(ah.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    z(ah.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ah.b
 * JD-Core Version:    0.7.0.1
 */