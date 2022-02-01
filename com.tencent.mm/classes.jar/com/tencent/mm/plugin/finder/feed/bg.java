package com.tencent.mm.plugin.finder.feed;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aav;
import com.tencent.mm.autogen.a.on;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.convert.ae;
import com.tencent.mm.plugin.finder.convert.ao;
import com.tencent.mm.plugin.finder.convert.cn.a;
import com.tencent.mm.plugin.finder.convert.cq;
import com.tencent.mm.plugin.finder.convert.cs;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.c;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.d;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.preload.c.b;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.f;
import com.tencent.mm.plugin.finder.preload.tabPreload.g.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.autoplay.FinderVideoAutoPlayManager;
import com.tencent.mm.plugin.finder.video.l.b;
import com.tencent.mm.plugin.finder.view.ContactUninterestEventListener;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.view.whatnews.FinderWhatsNewView;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "", "autoLoadingMoreBegin", "", "autoRefreshEventListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$autoRefreshEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$autoRefreshEventListener$1;", "byPassInfo", "getByPassInfo", "()Ljava/lang/String;", "byPassInfo$delegate", "Lkotlin/Lazy;", "byPassInfoType", "", "getByPassInfoType", "()Ljava/lang/Integer;", "byPassInfoType$delegate", "canTimelineRefresh", "", "commentChangeEventListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$commentChangeEventListener$1;", "commentFailedNotifyDataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "configPosition", "contactUninterestListener", "Lcom/tencent/mm/plugin/finder/view/ContactUninterestEventListener;", "emptyData", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "emptyFooterData", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedExposeInfoChangeListener$1;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "feedProgressListener", "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedProgressListener$1;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "followBizListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ModNewContactEvent;", "guideBarObjId", "getGuideBarObjId", "()Ljava/lang/Long;", "guideBarObjId$delegate", "hadAttached", "headerFullMergedData", "Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "isAutoLoadingMore", "isCanAutoPreloadMore", "isCurrentEmptyData", "isFirstRefreshEnd", "isFooterEmpty", "isFragment", "isFromShareToTimeline", "()Z", "isFromShareToTimeline$delegate", "isStartAutoRefresh", "lbsBarData", "Lcom/tencent/mm/plugin/finder/model/FeedLbsBarData;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mediaBannerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "nonceId", "getNonceId", "nonceId$delegate", "objectId", "getObjectId", "()J", "objectId$delegate", "preLoadBeginPosition", "privateMsgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "quickMenuHelper", "Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "reportScene", "getReportScene", "()I", "reportScene$delegate", "requestScene", "getRequestScene", "requestScene$delegate", "sourceType", "getSourceType", "sourceType$delegate", "tabCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM$Cache;", "tabType", "targetTabType", "getTargetTabType", "targetTabType$delegate", "tipDialog", "Landroid/app/Dialog;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "unFollowBizListener", "Lcom/tencent/mm/pluginsdk/oplog/IDeleteContactService$IDeleteContactResult;", "unreadVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "getUnreadVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;", "unreadVM$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "whatsNewView", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "getWhatsNewView", "()Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "whatsNewView$delegate", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "isHard", "isWithRefresh", "delayStartMs", "checkCacheState", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkDataReplace", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "checkEmptyHeader", "r", "checkNoMoreFooter", "isRefreshEnd", "checkTeenDigShow", "fetchData", "finderSharePreloadCore", "Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore;", "isMegaVideo", "username", "findUnreadFeeds", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feed", "dataList", "", "genHasMoreCacheKey", "getActivity", "getAdapter", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "from", "getCreateQuickMoreMenuListener", "getCreateSecondMoreMenuListener", "holder", "getFinderContextId", "getFragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "getHeaderInfo", "getItemCount", "getLastVisibleItemPosition", "getMediaBannerRecyclerViewPool", "getMoreMenuItemLongSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemLongSelectedListener;", "bottomSheet", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getTabType", "getTimelineFeedLoader", "getVideoCore", "hideSearchBar", "delay", "isSmooth", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "isFinderSelfScene", "isSelf", "keep", "p0", "loadMoreData", "isAuto", "loadShareFeed", "notifyChanged", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "itemId", "complete", "Lkotlin/Function0;", "onAttach", "onAutoToLoadMore", "onBackPressed", "onDetach", "onEventHappen", "ev", "onFavFeed", "isFav", "source", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onLikeLocalFeed", "isPrivate", "onLoadMoreEnd", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "preloadCallback", "Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore$PreloadCallback;", "refreshMsgNotify", "reportUnreadFeed", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "reportWxMessage", "reportWxPrivateMessage", "requestRefresh", "setCanAutoPreloadMore", "canAutoPreloadMore", "shareFeed", "shareFeedToSns", "smoothScrollToNextPosition", "recyclerView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
  extends com.tencent.mm.plugin.finder.event.base.d
  implements aw.a, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private static final int AST;
  private static final int ASU;
  private static final int ASV;
  private static final int ASW;
  private static final int ASX;
  private static final int ASY;
  private static final int ASZ;
  private static final int ATb;
  private static final int ATc;
  private static final int ATd;
  private static final int ATe;
  private static final int ATf;
  private static final int ATi;
  private static final int ATj;
  private static final int ATk;
  private static final int ATl;
  private static final int ATm;
  private static final int ATn;
  public static final a AZN;
  private static final int Auf;
  private static final int Aug;
  private static final int BaA;
  private static ConcurrentHashMap<String, RefreshLoadMoreLayout.d<Object>> Baz;
  private static final int pIs;
  private final com.tencent.mm.bx.b AEA;
  public final com.tencent.mm.plugin.finder.video.l AJn;
  private com.tencent.mm.view.k ATF;
  private RecyclerView.m ATp;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  private final com.tencent.mm.pluginsdk.q ATr;
  private ContactUninterestEventListener AYg;
  private final com.tencent.mm.plugin.finder.model.i AZE;
  private aw.b AZO;
  private com.tencent.mm.plugin.finder.viewmodel.d.a AZP;
  private boolean AZQ;
  private com.tencent.mm.pluginsdk.i.a.a AZR;
  private IListener<on> AZS;
  private final kotlin.j AZT;
  private final kotlin.j AZU;
  private final kotlin.j AZV;
  private final kotlin.j AZW;
  private final kotlin.j AZX;
  private final kotlin.j AZY;
  private final kotlin.j AZZ;
  public final FinderHomeTabFragment AZg;
  private final com.tencent.mm.plugin.finder.viewmodel.d AZj;
  public final FinderTimelineFeedLoader AZs;
  private final kotlin.j Baa;
  private final kotlin.j Bab;
  private final kotlin.j Bac;
  private final kotlin.j Bad;
  private final kotlin.j Bae;
  private final kotlin.j Baf;
  private final FinderTimelinePresenter.commentChangeEventListener.1 Bag;
  private final FinderTimelinePresenter.autoRefreshEventListener.1 Bah;
  private final kotlin.j Bai;
  private boolean Baj;
  private boolean Bak;
  private boolean Bal;
  private final FinderTimelinePresenter.feedExposeInfoChangeListener.1 Bam;
  private final bs Ban;
  private final com.tencent.mm.plugin.finder.model.k Bao;
  private i.b Bap;
  private i.b Baq;
  private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.model.f> Bar;
  private final com.tencent.mm.plugin.finder.model.al Bas;
  private boolean Bat;
  private long Bau;
  private int Bav;
  private int Baw;
  private int Bax;
  private final FinderTimelinePresenter.feedProgressListener.1 Bay;
  private final String TAG;
  private boolean canTimelineRefresh;
  public final int hJx;
  final MMActivity lzt;
  private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
  private Dialog tipDialog;
  private final boolean xho;
  
  static
  {
    AppMethodBeat.i(165897);
    AZN = new a((byte)0);
    Baz = new ConcurrentHashMap();
    com.tencent.mm.plugin.findersdk.a.o localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    AST = com.tencent.mm.plugin.findersdk.a.o.ebj();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ASU = com.tencent.mm.plugin.findersdk.a.o.frF();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ASV = com.tencent.mm.plugin.findersdk.a.o.ebk();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    Auf = com.tencent.mm.plugin.findersdk.a.o.frG();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    Aug = com.tencent.mm.plugin.findersdk.a.o.ebl();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ASW = com.tencent.mm.plugin.findersdk.a.o.frH();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ASX = com.tencent.mm.plugin.findersdk.a.o.frI();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ASY = com.tencent.mm.plugin.findersdk.a.o.ebm();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ASZ = com.tencent.mm.plugin.findersdk.a.o.ebn();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    pIs = com.tencent.mm.plugin.findersdk.a.o.frJ();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATb = com.tencent.mm.plugin.findersdk.a.o.ebp();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATc = com.tencent.mm.plugin.findersdk.a.o.ebq();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATd = com.tencent.mm.plugin.findersdk.a.o.ebr();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATe = com.tencent.mm.plugin.findersdk.a.o.ebs();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATf = com.tencent.mm.plugin.findersdk.a.o.frK();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATi = com.tencent.mm.plugin.findersdk.a.o.ebv();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATj = com.tencent.mm.plugin.findersdk.a.o.frL();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATk = com.tencent.mm.plugin.findersdk.a.o.frM();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATl = com.tencent.mm.plugin.findersdk.a.o.frN();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATn = com.tencent.mm.plugin.findersdk.a.o.frP();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    BaA = com.tencent.mm.plugin.findersdk.a.o.frQ();
    localo = com.tencent.mm.plugin.findersdk.a.o.Hck;
    ATm = com.tencent.mm.plugin.findersdk.a.o.frO();
    AppMethodBeat.o(165897);
  }
  
  public bg(final MMActivity paramMMActivity, FinderHomeTabFragment paramFinderHomeTabFragment, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(362927);
    this.lzt = paramMMActivity;
    this.AZg = paramFinderHomeTabFragment;
    this.AEA = paramb;
    this.ATq = new CopyOnWriteArraySet();
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    paramMMActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
    kotlin.g.b.s.s(paramMMActivity, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
    this.AZj = ((com.tencent.mm.plugin.finder.viewmodel.d)paramMMActivity);
    paramMMActivity = this.AZg;
    int i;
    boolean bool1;
    label130:
    int j;
    label369:
    com.tencent.mm.plugin.finder.cgi.fetcher.d locald;
    if (paramMMActivity == null)
    {
      i = 0;
      this.hJx = i;
      if ((!this.AZj.Rp(this.hJx)) || (this.lzt.getIntent().getBooleanExtra("KEY_FORCE_NOT_REFRESH_FIRST_TIME", false))) {
        break label829;
      }
      bool1 = true;
      this.canTimelineRefresh = bool1;
      this.ATr = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.q.class)).iGI();
      this.AZT = kotlin.k.cm((kotlin.g.a.a)new q(this));
      this.AZU = kotlin.k.cm((kotlin.g.a.a)new c(this));
      this.AZV = kotlin.k.cm((kotlin.g.a.a)new ag(this));
      this.AZW = kotlin.k.cm((kotlin.g.a.a)new d(this));
      this.AZX = kotlin.k.cm((kotlin.g.a.a)new af(this));
      this.AZY = kotlin.k.cm((kotlin.g.a.a)new u(this));
      this.AZZ = kotlin.k.cm((kotlin.g.a.a)new t(this));
      this.Baa = kotlin.k.cm((kotlin.g.a.a)new r(this));
      this.Bab = kotlin.k.cm((kotlin.g.a.a)ah.BaM);
      this.Bac = kotlin.k.cm((kotlin.g.a.a)new ae(this));
      this.Bad = kotlin.k.cm((kotlin.g.a.a)new ac(this));
      paramMMActivity = com.tencent.mm.plugin.finder.feed.model.internal.g.Bkb;
      paramFinderHomeTabFragment = com.tencent.mm.plugin.finder.feed.model.internal.g.a.Od(this.hJx);
      if (!this.canTimelineRefresh) {
        break label835;
      }
      j = 0;
      paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
      paramb = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).Vl(this.hJx);
      locald = new com.tencent.mm.plugin.finder.cgi.fetcher.d();
      paramMMActivity = (Integer)this.AZV.getValue();
      i = this.hJx;
      if (paramMMActivity != null) {
        break label841;
      }
      label432:
      paramMMActivity = this.AZg;
      if (paramMMActivity != null) {
        break label1162;
      }
      bool1 = false;
    }
    for (;;)
    {
      locald.AED = bool1;
      paramMMActivity = ah.aiuX;
      paramMMActivity = new FinderTimelineFeedLoader(paramFinderHomeTabFragment, j, paramb, locald);
      paramMMActivity.setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new h(this, paramMMActivity));
      paramFinderHomeTabFragment = ah.aiuX;
      this.AZs = paramMMActivity;
      paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
      this.ATp = ((com.tencent.mm.plugin.finder.viewmodel.e)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.e.class)).ATp;
      this.AJn = new com.tencent.mm.plugin.finder.video.l(this.hJx);
      this.Bae = kotlin.k.cm((kotlin.g.a.a)new g(this));
      this.Baf = kotlin.k.cm((kotlin.g.a.a)new i(this));
      this.Bag = new FinderTimelinePresenter.commentChangeEventListener.1(this, com.tencent.mm.app.f.hfK);
      this.Bah = new FinderTimelinePresenter.autoRefreshEventListener.1(this, com.tencent.mm.app.f.hfK);
      this.TAG = kotlin.g.b.s.X("Finder.TimelinePresenter#", Integer.valueOf(this.hJx));
      this.ATF = ((com.tencent.mm.view.k)new com.tencent.mm.view.k()
      {
        public final void onChanged()
        {
          AppMethodBeat.i(165861);
          Object localObject = bg.g(this.BaB);
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null) {
              ((RefreshLoadMoreLayout)localObject).onChanged();
            }
          }
          AppMethodBeat.o(165861);
        }
        
        public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(362727);
          Object localObject = bg.g(this.BaB);
          com.tencent.mm.view.recyclerview.i locali;
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null)
            {
              locali = bg.w(this.BaB);
              if (locali != null) {
                break label64;
              }
            }
          }
          label64:
          for (int i = 0;; i = locali.agOb.size())
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(362727);
            return;
          }
        }
        
        public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(165862);
          Object localObject = bg.g(this.BaB);
          com.tencent.mm.view.recyclerview.i locali;
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null)
            {
              locali = bg.w(this.BaB);
              if (locali != null) {
                break label67;
              }
            }
          }
          label67:
          for (int i = 0;; i = locali.agOb.size())
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
            AppMethodBeat.o(165862);
            return;
          }
        }
        
        public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165863);
          Object localObject = bg.g(this.BaB);
          com.tencent.mm.view.recyclerview.i locali;
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null)
            {
              locali = bg.w(this.BaB);
              if (locali != null) {
                break label64;
              }
            }
          }
          label64:
          for (int i = 0;; i = locali.agOb.size())
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(165863);
            return;
          }
        }
        
        public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(165864);
          Object localObject = bg.g(this.BaB);
          com.tencent.mm.view.recyclerview.i locali;
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null)
            {
              locali = bg.w(this.BaB);
              if (locali != null) {
                break label64;
              }
            }
          }
          label64:
          for (int i = 0;; i = locali.agOb.size())
          {
            ((RefreshLoadMoreLayout)localObject).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
            AppMethodBeat.o(165864);
            return;
          }
        }
        
        public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(362706);
          kotlin.g.b.s.u(paramAnonymousd, "reason");
          Object localObject = bg.g(this.BaB);
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null) {
              ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMore(paramAnonymousd);
            }
          }
          AppMethodBeat.o(362706);
        }
        
        public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(165860);
          kotlin.g.b.s.u(paramAnonymousd, "reason");
          Object localObject = bg.g(this.BaB);
          if (localObject != null)
          {
            localObject = ((aw.b)localObject).aNL();
            if (localObject != null) {
              ((RefreshLoadMoreLayout)localObject).onPreFinishLoadMoreSmooth(paramAnonymousd);
            }
          }
          AppMethodBeat.o(165860);
        }
        
        public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(165859);
          kotlin.g.b.s.u(paramAnonymousd, "reason");
          Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (((Number)com.tencent.mm.plugin.finder.storage.d.eUj().bmg()).intValue() == 1)
          {
            Object localObject2 = (Iterable)this.BaB.AZs.getDataList();
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            Object localObject3;
            label132:
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((Iterator)localObject2).next();
              cc localcc = (cc)localObject3;
              if (((localcc instanceof BaseFinderFeed)) && (((BaseFinderFeed)localcc).showCommentEdu)) {}
              for (int i = 1;; i = 0)
              {
                if (i == 0) {
                  break label132;
                }
                ((Collection)localObject1).add(localObject3);
                break;
              }
            }
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (cc)((Iterator)localObject1).next();
              localObject3 = com.tencent.mm.plugin.finder.utils.av.GiL;
              com.tencent.mm.plugin.finder.utils.av.qM(((BaseFinderFeed)localObject2).feedObject.field_id);
            }
          }
          bg.b(this.BaB, paramAnonymousd);
          localObject1 = bg.g(this.BaB);
          if (localObject1 != null)
          {
            localObject1 = ((aw.b)localObject1).aNL();
            if (localObject1 != null) {
              ((RefreshLoadMoreLayout)localObject1).onPreFinishRefresh(paramAnonymousd);
            }
          }
          if (bg.t(this.BaB))
          {
            bg.u(this.BaB);
            com.tencent.mm.ae.d.a(150L, (kotlin.g.a.a)new a(this.BaB));
          }
          AppMethodBeat.o(165859);
        }
        
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends kotlin.g.b.u
          implements kotlin.g.a.a<ah>
        {
          a(bg parambg)
          {
            super();
          }
        }
      });
      bool1 = bool2;
      if (this.AZg != null) {
        bool1 = true;
      }
      this.xho = bool1;
      this.Bai = kotlin.k.cm((kotlin.g.a.a)new ai(this));
      this.Baj = true;
      this.Bam = new FinderTimelinePresenter.feedExposeInfoChangeListener.1(this);
      this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
      this.Ban = new bs();
      this.AZE = new com.tencent.mm.plugin.finder.model.i();
      this.Bao = new com.tencent.mm.plugin.finder.model.k();
      this.Bap = ((i.b)new com.tencent.mm.plugin.finder.model.g());
      this.Baq = ((i.b)new com.tencent.mm.plugin.finder.model.e());
      this.Bar = new ConcurrentLinkedQueue();
      this.Bas = new com.tencent.mm.plugin.finder.model.al(this.msgNotifyData, this.Ban, this.Bar);
      this.Bay = new FinderTimelinePresenter.feedProgressListener.1(this, com.tencent.mm.app.f.hfK);
      AppMethodBeat.o(362927);
      return;
      i = paramMMActivity.hJx;
      break;
      label829:
      bool1 = false;
      break label130;
      label835:
      j = 1;
      break label369;
      label841:
      if (paramMMActivity.intValue() != i) {
        break label432;
      }
      locald.AEA = this.AEA;
      locald.AEz = ((Long)this.AZT.getValue());
      paramMMActivity = (String)this.AZU.getValue();
      if (paramMMActivity != null)
      {
        if (((CharSequence)paramMMActivity).length() != 0) {
          break label1111;
        }
        i = 1;
        label908:
        if (i != 0) {
          break label1117;
        }
        i = 1;
        label916:
        if (i == 0) {
          break label1123;
        }
        label921:
        if (paramMMActivity != null)
        {
          paramMMActivity = paramMMActivity.getBytes(kotlin.n.d.UTF_8);
          kotlin.g.b.s.s(paramMMActivity, "(this as java.lang.String).getBytes(charset)");
          locald.AEB = new com.tencent.mm.bx.b(paramMMActivity);
        }
      }
      locald.AEC = ((Integer)this.AZW.getValue());
      locald.sourceType = ((Number)this.AZX.getValue()).intValue();
      locald.hKN = ecI();
      locald.setNonceId(getNonceId());
      if ((ecJ()) && (this.hJx == 4)) {
        locald.AAd = 1;
      }
      if (((Number)this.Bad.getValue()).intValue() == 15)
      {
        i = 6;
        label1053:
        locald.ACA = i;
        paramMMActivity = (CharSequence)this.lzt.getIntent().getStringExtra("FLOAT_BALL_KEY");
        if ((paramMMActivity != null) && (paramMMActivity.length() != 0)) {
          break label1150;
        }
        i = 1;
        label1093:
        if (i != 0) {
          break label1156;
        }
      }
      label1156:
      for (bool1 = true;; bool1 = false)
      {
        locald.AEE = bool1;
        break;
        label1111:
        i = 0;
        break label908;
        label1117:
        i = 0;
        break label916;
        label1123:
        paramMMActivity = null;
        break label921;
        if (ecK() < 0)
        {
          i = 3;
          break label1053;
        }
        i = ecK();
        break label1053;
        label1150:
        i = 0;
        break label1093;
      }
      label1162:
      paramMMActivity = paramMMActivity.EHy;
      if (paramMMActivity == null) {
        bool1 = false;
      } else {
        bool1 = paramMMActivity.getBoolean("IsFirstEnterTab", false);
      }
    }
  }
  
  private static final void a(bg parambg, l.a parama)
  {
    AppMethodBeat.i(363076);
    kotlin.g.b.s.u(parambg, "this$0");
    parambg = parambg.AZg;
    if (parambg != null)
    {
      parama = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)parambg).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fnb();
    }
    AppMethodBeat.o(363076);
  }
  
  private static final void a(bg parambg, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(370846);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    i.a.a((i)parambg, paramBaseFinderFeed.feedObject, true);
    AppMethodBeat.o(370846);
  }
  
  private static final void a(final bg parambg, final BaseFinderFeed paramBaseFinderFeed, final com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(370842);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramf, "$sheet");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    Object localObject2 = com.tencent.mm.plugin.finder.utils.av.a((Context)parambg.lzt, paramBaseFinderFeed, (kotlin.g.a.b)new j(params, paramBaseFinderFeed, parambg, paramf), 4);
    boolean bool1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiW;
    boolean bool2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiX;
    boolean bool3 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiY;
    paramf = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).GiZ;
    localObject1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).Gja;
    localObject2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject2).Gjb;
    params.a(Auf, (CharSequence)paramf, e.g.finder_icons_filled_share, parambg.lzt.getResources().getColor(e.b.Brand), bool1);
    params.a(Aug, (CharSequence)localObject1, e.g.bottomsheet_icon_moment, 0, bool2);
    paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
    int i;
    label188:
    label228:
    int j;
    label248:
    int k;
    if (paramf == null)
    {
      paramf = null;
      paramf = (CharSequence)paramf;
      if ((paramf != null) && (paramf.length() != 0)) {
        break label865;
      }
      i = 1;
      if (i == 0)
      {
        paramf = ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig();
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject1 != null) {
          break label871;
        }
        i = 0;
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject1 != null) {
          break label917;
        }
        j = 0;
        localObject1 = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (localObject1 != null) {
          break label963;
        }
        k = -1;
        label268:
        if (paramf.ag(i, j, k))
        {
          paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramf != null) {
            break label991;
          }
          i = 0;
          label301:
          if (i <= 0) {
            break label1041;
          }
          localObject1 = parambg.lzt;
          j = e.h.finder_share_use_same_template_with_count;
          if (i <= 99999) {
            break label1015;
          }
          paramf = String.valueOf(parambg.lzt.getString(e.h.finder_hundred_thousand_ringtone));
          label339:
          paramf = ((MMActivity)localObject1).getString(j, new Object[] { paramf });
          label355:
          kotlin.g.b.s.s(paramf, "if (count > 0) context.g…_share_use_same_template)");
          params.a(ATm, (CharSequence)paramf, e.d.icons_filled_saneeffects, parambg.lzt.getResources().getColor(e.b.Brand), false);
          paramf = com.tencent.mm.ui.component.k.aeZF;
          bui localbui = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)parambg.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
          paramf = com.tencent.mm.plugin.finder.report.bb.FuK;
          JSONObject localJSONObject = new JSONObject();
          paramf = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramf != null) {
            break label1055;
          }
          paramf = Integer.valueOf(0);
          label452:
          localJSONObject.put("templateId", paramf);
          paramf = ah.aiuX;
          com.tencent.mm.plugin.finder.report.bb.a(localbui, "shoot_same_video", false, localJSONObject);
        }
      }
      paramf = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      if (com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject())) {
        break label1094;
      }
      i = 1;
      label500:
      paramf = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
      {
        if (!bool3) {
          break label1100;
        }
        params.a(ATc, (CharSequence)localObject2, e.g.finder_icons_filled_star2, parambg.lzt.getResources().getColor(e.b.orange_100), true);
      }
      label554:
      paramf = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWt().bmg()).intValue() == 1)
      {
        paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (com.tencent.mm.plugin.finder.utils.av.F(paramBaseFinderFeed.feedObject.getFeedObject()))
        {
          paramf = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.j((Context)parambg.lzt, paramBaseFinderFeed.bZA());
          params.a(ATf, (CharSequence)parambg.lzt.getString(e.h.finder_share_text_stauts_title), e.g.state_icon_main, parambg.lzt.getResources().getColor(e.b.Blue));
        }
      }
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.p(paramBaseFinderFeed))
      {
        paramf = paramBaseFinderFeed.feedObject;
        if (paramf != null) {
          break label1185;
        }
        i = 0;
        label669:
        if (i == 0) {
          break label1235;
        }
        paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (i < com.tencent.mm.plugin.finder.utils.av.fgc()) {
          break label1235;
        }
        if (i <= 99999) {
          break label1209;
        }
        paramf = String.valueOf(parambg.lzt.getString(e.h.finder_hundred_thousand_ringtone));
      }
    }
    label708:
    label1094:
    label1100:
    label1235:
    for (paramf = parambg.lzt.getString(e.h.finder_feed_has_been_set_ringtone, new Object[] { paramf });; paramf = parambg.lzt.getString(e.h.finder_share_ringtone_title))
    {
      kotlin.g.b.s.s(paramf, "if(count != 0 && count >…tone_title)\n            }");
      params.a(ATi, (CharSequence)paramf, e.g.icons_filled_ringtone, 0);
      paramf = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramf = as.a.hu((Context)parambg.lzt);
      if (paramf != null)
      {
        params = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.aa(paramBaseFinderFeed.bZA(), paramf.AJo);
      }
      paramf = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      parambg = as.a.hu((Context)parambg.lzt);
      if (parambg != null)
      {
        parambg = ((bn)parambg).foy();
        if (parambg != null)
        {
          parambg = parambg.dYj();
          if (parambg != null) {
            parambg.nj(paramBaseFinderFeed.bZA());
          }
        }
      }
      AppMethodBeat.o(370842);
      return;
      paramf = paramf.video_tmpl_info;
      if (paramf == null)
      {
        paramf = null;
        break;
      }
      paramf = paramf.id;
      break;
      label865:
      i = 0;
      break label188;
      label871:
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        i = 0;
        break label228;
      }
      localObject1 = ((byy)localObject1).aahY;
      if (localObject1 == null)
      {
        i = 0;
        break label228;
      }
      i = ((fxe)localObject1).abME;
      break label228;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        j = 0;
        break label248;
      }
      localObject1 = ((byy)localObject1).aahY;
      if (localObject1 == null)
      {
        j = 0;
        break label248;
      }
      j = ((fxe)localObject1).abMF;
      break label248;
      localObject1 = ((FinderObjectDesc)localObject1).video_tmpl_info;
      if (localObject1 == null)
      {
        k = -1;
        break label268;
      }
      k = ((byy)localObject1).type;
      break label268;
      label991:
      paramf = paramf.video_tmpl_info;
      if (paramf == null)
      {
        i = 0;
        break label301;
      }
      i = paramf.ZmT;
      break label301;
      label1015:
      if (i > 9999)
      {
        paramf = com.tencent.mm.plugin.finder.utils.av.Ul(i);
        break label339;
      }
      paramf = String.valueOf(i);
      break label339;
      paramf = parambg.lzt.getString(e.h.finder_share_use_same_template);
      break label355;
      paramf = paramf.video_tmpl_info;
      if (paramf == null)
      {
        paramf = Integer.valueOf(0);
        break label452;
      }
      localObject1 = paramf.id;
      paramf = (com.tencent.mm.ui.widget.a.f)localObject1;
      if (localObject1 != null) {
        break label452;
      }
      paramf = Integer.valueOf(0);
      break label452;
      i = 0;
      break label500;
      if (i != 0)
      {
        params.a(ATc, (CharSequence)parambg.lzt.getString(e.h.favorite), e.g.finder_icons_filled_star2, parambg.lzt.getResources().getColor(e.b.orange_100));
        break label554;
      }
      params.a(ATd, (CharSequence)parambg.lzt.getString(e.h.finder_cancel_fav_title), e.g.finder_icons_filled_unstar2, parambg.lzt.getResources().getColor(e.b.orange_100));
      break label554;
      paramf = paramf.field_finderObject;
      if (paramf == null)
      {
        i = 0;
        break label669;
      }
      i = paramf.ringtone_count;
      break label669;
      if (i > 9999)
      {
        paramf = com.tencent.mm.plugin.finder.utils.av.Ul(i);
        break label708;
      }
      paramf = String.valueOf(i);
      break label708;
    }
  }
  
  private static final void a(final bg parambg, final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, final MenuItem paramMenuItem, final int paramInt)
  {
    AppMethodBeat.i(370849);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramj, "$holder");
    Log.i(parambg.TAG, "[getMoreMenuItemSelectedListener] feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    int i = paramMenuItem.getItemId();
    if (i == ATj)
    {
      paramj = parambg.AZO;
      if (paramj != null)
      {
        paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
        parambg = com.tencent.mm.ui.component.k.d((AppCompatActivity)parambg.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.x.class);
        kotlin.g.b.s.s(parambg, "UICProvider.of(getActivi…tMiniViewUIC::class.java)");
        com.tencent.mm.plugin.finder.viewmodel.component.x.a((com.tencent.mm.plugin.finder.viewmodel.component.x)parambg, new ca(paramBaseFinderFeed.feedObject.getFeedObject()), paramj.getRecyclerView());
        parambg = ah.aiuX;
        parambg = ah.aiuX;
      }
      AppMethodBeat.o(370849);
      return;
    }
    if (i == ATk)
    {
      if (parambg.AZO != null)
      {
        paramMenuItem = (List)new ArrayList();
        paramBaseFinderFeed = paramj.UH(e.e.finder_feed_full_footer_layout);
        if (paramBaseFinderFeed != null) {
          paramMenuItem.add(paramBaseFinderFeed);
        }
        paramBaseFinderFeed = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
        if (paramBaseFinderFeed != null) {
          break label307;
        }
        paramBaseFinderFeed = null;
        if (!(paramBaseFinderFeed instanceof FinderThumbPlayerProxy)) {
          break label315;
        }
      }
      label307:
      label315:
      for (paramBaseFinderFeed = (FinderThumbPlayerProxy)paramBaseFinderFeed;; paramBaseFinderFeed = null)
      {
        if (paramBaseFinderFeed != null)
        {
          paramj = com.tencent.mm.ui.component.k.aeZF;
          parambg = com.tencent.mm.ui.component.k.d((AppCompatActivity)parambg.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.av.class);
          kotlin.g.b.s.s(parambg, "UICProvider.of(getActivi…edControlUIC::class.java)");
          com.tencent.mm.plugin.finder.viewmodel.component.av.a((com.tencent.mm.plugin.finder.viewmodel.component.av)parambg, paramMenuItem, paramBaseFinderFeed, 0, false, null, 28);
          parambg = ah.aiuX;
          parambg = ah.aiuX;
        }
        AppMethodBeat.o(370849);
        return;
        paramBaseFinderFeed = paramBaseFinderFeed.getVideoView();
        break;
      }
    }
    if (i == BaA)
    {
      paramj = new Intent();
      paramMenuItem = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(paramBaseFinderFeed.feedObject.getExpectId(), (dji)kotlin.a.p.oK((List)paramBaseFinderFeed.feedObject.getMediaList()));
      paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().internal_feedback_url + "?&requestFormat=" + paramMenuItem.ExF.detail + "&currentSpeed=" + CdnLogic.getRecentAverageSpeed(2) + "&maxBitRate=" + ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVs;
      Log.i(parambg.TAG, kotlin.g.b.s.X("internal_feedback_url=", paramBaseFinderFeed));
      paramj.putExtra("rawUrl", paramBaseFinderFeed);
      com.tencent.mm.br.c.b((Context)parambg.lzt, "webview", ".ui.tools.WebViewUI", paramj);
      AppMethodBeat.o(370849);
      return;
    }
    Object localObject;
    if (i == AST)
    {
      paramMenuItem = parambg.AZs.getListOfType(BaseFinderFeed.class);
      i = paramMenuItem.indexOf(paramBaseFinderFeed);
      if (i >= 0)
      {
        localObject = com.tencent.mm.plugin.finder.feed.logic.c.Bep;
        com.tencent.mm.plugin.finder.feed.logic.c.a((Context)parambg.lzt, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new n(parambg, paramBaseFinderFeed, paramMenuItem, paramInt));
        com.tencent.mm.ui.base.aa.y((Context)parambg.lzt, parambg.lzt.getResources().getString(e.h.finder_reduce_recommendation), e.g.icons_filled_done);
        ((com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a("feed_uninterest_clk", paramj.caK, null, 24617);
        AppMethodBeat.o(370849);
        return;
      }
      Log.i(parambg.TAG, "[not interested] pos error=" + i + ", feed=" + paramBaseFinderFeed + ", dataList=" + paramMenuItem);
      AppMethodBeat.o(370849);
      return;
    }
    if (i == pIs)
    {
      if (paramBaseFinderFeed.feedObject.isPostFinish())
      {
        paramInt = e.h.finder_profile_confirm_del;
        com.tencent.mm.ui.base.k.a((Context)parambg.lzt, paramInt, 0, new bg..ExternalSyntheticLambda1(paramBaseFinderFeed, parambg), null);
        AppMethodBeat.o(370849);
      }
    }
    else if (i != ASU)
    {
      if (i == Auf)
      {
        paramj = new Bundle();
        an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)parambg.lzt, paramBaseFinderFeed.feedObject, paramj, 3, 16);
        parambg = ah.aiuX;
        AppMethodBeat.o(370849);
        return;
      }
      if (i == Aug)
      {
        an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)parambg.lzt, paramBaseFinderFeed, 0, 0, 28);
        AppMethodBeat.o(370849);
        return;
      }
      if (i == ATm)
      {
        paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramj == null)
        {
          paramj = null;
          if (paramj != null) {
            break label965;
          }
          com.tencent.mm.ui.base.aa.dc((Context)parambg.lzt, parambg.lzt.getString(e.h.finder_get_video_template_error));
          paramj = com.tencent.mm.ui.component.k.aeZF;
          paramj = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)parambg.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
          parambg = com.tencent.mm.plugin.finder.report.bb.FuK;
          paramMenuItem = new JSONObject();
          parambg = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (parambg != null) {
            break label1067;
          }
          parambg = Integer.valueOf(0);
        }
        for (;;)
        {
          paramMenuItem.put("templateId", parambg);
          parambg = ah.aiuX;
          com.tencent.mm.plugin.finder.report.bb.a(paramj, "shoot_same_video", true, paramMenuItem);
          AppMethodBeat.o(370849);
          return;
          paramj = paramj.video_tmpl_info;
          break;
          label965:
          paramMenuItem = new Intent();
          switch (paramj.type)
          {
          default: 
            paramInt = -1;
          }
          for (;;)
          {
            localObject = (com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class);
            Activity localActivity = (Activity)parambg.lzt;
            paramMenuItem.putExtra("key_maas_entrance", 5);
            ah localah = ah.aiuX;
            ((com.tencent.mm.mj_template.api.d)localObject).creationBySameTemplate(localActivity, paramj, paramMenuItem, paramInt);
            break;
            paramInt = 16;
            continue;
            paramInt = 13;
          }
          label1067:
          parambg = parambg.video_tmpl_info;
          if (parambg == null)
          {
            parambg = Integer.valueOf(0);
          }
          else
          {
            paramBaseFinderFeed = parambg.id;
            parambg = paramBaseFinderFeed;
            if (paramBaseFinderFeed == null) {
              parambg = Integer.valueOf(0);
            }
          }
        }
      }
      if (i == ASW)
      {
        paramj = com.tencent.mm.plugin.finder.utils.n.Ggy;
        com.tencent.mm.plugin.finder.utils.n.a(paramBaseFinderFeed, (Activity)parambg.lzt);
        AppMethodBeat.o(370849);
        return;
      }
      if (i == ASV)
      {
        paramj = aw.Gjk;
        if (aw.s(paramBaseFinderFeed))
        {
          paramj = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramj != null)
          {
            long l = paramj.liveId;
            paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
            com.tencent.mm.plugin.finder.feed.logic.a.c((Context)parambg.lzt, l, paramBaseFinderFeed.feedObject.getUserName());
            parambg = ah.aiuX;
            parambg = ah.aiuX;
          }
          AppMethodBeat.o(370849);
          return;
        }
        paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramj = as.a.hu((Context)parambg.lzt);
        if (paramj == null) {}
        for (paramInt = 0;; paramInt = paramj.AJo)
        {
          paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
          com.tencent.mm.plugin.finder.feed.logic.a.a((Context)parambg.lzt, paramBaseFinderFeed.feedObject.field_id, 0L, 0, paramInt, 12);
          AppMethodBeat.o(370849);
          return;
        }
      }
      if (i == ASX)
      {
        paramMenuItem = new Intent();
        paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (paramj == null) {}
        for (paramj = null;; paramj = paramj.toByteArray())
        {
          paramMenuItem.putExtra("postRefMediaList", paramj);
          paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
          paramMenuItem.putExtra("postRefFeedInfo", com.tencent.mm.plugin.finder.utils.av.o(paramBaseFinderFeed).toByteArray());
          paramMenuItem.putExtra("postType", paramBaseFinderFeed.feedObject.getMediaType());
          paramMenuItem.putExtra("key_finder_post_from", 5);
          paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)parambg.lzt, paramMenuItem);
          AppMethodBeat.o(370849);
          return;
        }
      }
      if (i == ASZ)
      {
        ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (ck)new p(parambg));
        AppMethodBeat.o(370849);
        return;
      }
      if (i == ASY)
      {
        ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (ck)new k(parambg));
        AppMethodBeat.o(370849);
        return;
      }
      if (i == ATb)
      {
        if (paramBaseFinderFeed.feedObject.isPostFinish())
        {
          paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          paramj = as.a.hu((Context)parambg.lzt);
          if (paramj == null) {}
          for (paramInt = 0; paramInt == 52; paramInt = paramj.AJo)
          {
            if ((parambg.lzt instanceof FinderTopicTimelineUI)) {
              ((FinderTopicTimelineUI)parambg.lzt).onBackPressed();
            }
            paramj = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.a((Context)parambg.lzt, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
            AppMethodBeat.o(370849);
            return;
          }
          paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
          e.a.s(paramBaseFinderFeed.feedObject);
          paramj = com.tencent.mm.plugin.finder.utils.as.GiG;
          paramMenuItem = (Context)parambg.lzt;
          paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
          if (paramj == null) {}
          for (paramj = null;; paramj = paramj.feedBgmInfo)
          {
            com.tencent.mm.plugin.finder.utils.as.a(paramMenuItem, paramj, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), parambg.hJx);
            break;
          }
        }
      }
      else
      {
        if (i == ATc)
        {
          paramj = com.tencent.mm.plugin.finder.report.bb.FuK;
          paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          paramj = as.a.hu((Context)parambg.lzt);
          if (paramj == null)
          {
            paramj = null;
            com.tencent.mm.plugin.finder.report.bb.a(paramj, "fav_in_menu", false, paramBaseFinderFeed.bZA());
            paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
              break label1815;
            }
          }
          label1815:
          for (paramj = parambg.lzt.getResources().getString(e.h.finder_has_fav_title);; paramj = parambg.lzt.getResources().getString(e.h.finder_has_fav_title2))
          {
            kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…title2)\n                }");
            com.tencent.mm.ui.base.aa.a((Context)parambg.lzt, paramj, new bg..ExternalSyntheticLambda5(parambg, paramBaseFinderFeed));
            AppMethodBeat.o(370849);
            return;
            paramj = paramj.fou();
            break;
          }
        }
        if (i == ATd)
        {
          paramj = com.tencent.mm.plugin.finder.report.bb.FuK;
          paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          paramj = as.a.hu((Context)parambg.lzt);
          if (paramj == null)
          {
            paramj = null;
            com.tencent.mm.plugin.finder.report.bb.a(paramj, "unfav_in_menu", false, paramBaseFinderFeed.bZA());
            paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() != 0) {
              break label1952;
            }
          }
          label1952:
          for (paramj = parambg.lzt.getResources().getString(e.h.finder_has_cancel_fav_title);; paramj = parambg.lzt.getResources().getString(e.h.finder_has_cancel_fav_title2))
          {
            kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…title2)\n                }");
            com.tencent.mm.ui.base.aa.a((Context)parambg.lzt, paramj, new bg..ExternalSyntheticLambda6(parambg, paramBaseFinderFeed));
            AppMethodBeat.o(370849);
            return;
            paramj = paramj.fou();
            break;
          }
        }
        if (i == ATf)
        {
          an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)parambg.lzt, paramBaseFinderFeed);
          AppMethodBeat.o(370849);
          return;
        }
        if (i == ATi)
        {
          paramj = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
          paramj.fiH();
          paramMenuItem = com.tencent.mm.plugin.finder.utils.al.GhB;
          com.tencent.mm.plugin.finder.utils.al.a((AppCompatActivity)parambg.lzt, paramBaseFinderFeed, (kotlin.g.a.b)new l(paramj, parambg));
          AppMethodBeat.o(370849);
          return;
        }
        if (i == ATb)
        {
          if (paramBaseFinderFeed.feedObject.isPostFinish())
          {
            paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
            paramj = as.a.hu((Context)parambg.lzt);
            if (paramj == null) {}
            for (paramInt = 0; paramInt == 52; paramInt = paramj.AJo)
            {
              if ((parambg.lzt instanceof FinderTopicTimelineUI)) {
                ((FinderTopicTimelineUI)parambg.lzt).onBackPressed();
              }
              paramj = com.tencent.mm.plugin.finder.report.z.FrZ;
              com.tencent.mm.plugin.finder.report.z.a((Context)parambg.lzt, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
              AppMethodBeat.o(370849);
              return;
            }
            paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
            e.a.s(paramBaseFinderFeed.feedObject);
            paramj = com.tencent.mm.plugin.finder.utils.as.GiG;
            paramMenuItem = (Context)parambg.lzt;
            paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramj == null) {}
            for (paramj = null;; paramj = paramj.feedBgmInfo)
            {
              com.tencent.mm.plugin.finder.utils.as.a(paramMenuItem, paramj, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), parambg.hJx);
              break;
            }
          }
        }
        else
        {
          if (i == ATe)
          {
            paramj = new Intent();
            paramj.putExtra("KEY_FROM_SCENE", 1);
            paramj.putExtra("KEY_USERNAME", com.tencent.mm.model.z.bAW());
            paramj.putExtra("KEY_FINDER_SELF_FLAG", true);
            paramj.putExtra("KEY_IS_FULLSCREEN", true);
            paramj.putExtra("KEY_ENABLE_SWITCH_PREVIEW_MODE", false);
            paramMenuItem = com.tencent.mm.plugin.finder.utils.av.GiL;
            com.tencent.mm.plugin.finder.utils.av.a(0, kotlin.a.p.listOf(paramBaseFinderFeed), null, paramj);
            paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.a.GfO;
            com.tencent.mm.plugin.finder.utils.a.S((Context)parambg.lzt, paramj);
            AppMethodBeat.o(370849);
            return;
          }
          if (i == ATn)
          {
            paramj = am.GhD;
            parambg = (Activity)parambg.lzt;
            paramj = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
            am.a(paramBaseFinderFeed, parambg, com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId()));
            AppMethodBeat.o(370849);
            return;
          }
          if (i == ATl)
          {
            ag.a(parambg.lzt.getTaskId(), null);
            AppMethodBeat.o(370849);
            return;
          }
          paramj = parambg.ATr;
          if (paramMenuItem == null)
          {
            parambg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
            AppMethodBeat.o(370849);
            throw parambg;
          }
          paramj.a((com.tencent.mm.ui.base.t)paramMenuItem, (kotlin.g.a.b)new m(parambg, paramMenuItem, paramBaseFinderFeed));
        }
      }
    }
    AppMethodBeat.o(370849);
  }
  
  private static final void a(bg parambg, com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(370850);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    com.tencent.mm.pluginsdk.q localq = parambg.ATr;
    if (paramMenuItem == null)
    {
      parambg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(370850);
      throw parambg;
    }
    boolean bool = localq.a(paramf, (com.tencent.mm.ui.base.t)paramMenuItem);
    Log.i(parambg.TAG, kotlin.g.b.s.X("getMoreMenuItemLongSelectedListener :", Boolean.valueOf(bool)));
    AppMethodBeat.o(370850);
  }
  
  private static final void a(bg parambg, String paramString, int paramInt, dzc paramdzc)
  {
    Object localObject1 = null;
    AppMethodBeat.i(363103);
    kotlin.g.b.s.u(parambg, "this$0");
    Log.i(parambg.TAG, "onDeleteContact: ret = " + paramInt + ", oplogErrMsg = " + paramdzc + ", bizUsername = " + paramString);
    if (paramInt == 0)
    {
      Iterator localIterator = ((Iterable)parambg.AZs.getDataListJustForAdapter()).iterator();
      if (!localIterator.hasNext()) {
        break label235;
      }
      Object localObject2 = localIterator.next();
      paramdzc = (cc)localObject2;
      if (!(paramdzc instanceof BaseFinderFeed)) {
        break label230;
      }
      paramdzc = ((BaseFinderFeed)paramdzc).feedObject.getBizInfo();
      if (paramdzc != null) {
        break label222;
      }
      paramdzc = null;
      label130:
      if (!kotlin.g.b.s.p(paramdzc, paramString)) {
        break label230;
      }
      paramInt = 1;
      label140:
      if (paramInt == 0) {
        break label233;
      }
      paramString = localObject2;
      label147:
      paramString = (cc)paramString;
      if (!(paramString instanceof BaseFinderFeed)) {
        break label240;
      }
      paramString = (BaseFinderFeed)paramString;
      label164:
      if (paramString != null)
      {
        paramdzc = parambg.TAG;
        parambg = paramString.feedObject.getBizInfo();
        if (parambg != null) {
          break label245;
        }
      }
    }
    label222:
    label230:
    label233:
    label235:
    label240:
    label245:
    for (parambg = localObject1;; parambg = parambg.YTl)
    {
      Log.i(paramdzc, kotlin.g.b.s.X("onDeleteContact: biz nickname = ", parambg));
      parambg = com.tencent.mm.plugin.finder.upload.action.f.GcR;
      com.tencent.mm.plugin.finder.upload.action.f.e(1, paramString.feedObject.getUserName(), true);
      AppMethodBeat.o(363103);
      return;
      paramdzc = paramdzc.ADE;
      break label130;
      paramInt = 0;
      break label140;
      break;
      paramString = null;
      break label147;
      paramString = null;
      break label164;
    }
  }
  
  private static final void a(bg parambg, boolean paramBoolean, LinearLayoutManager paramLinearLayoutManager, long paramLong)
  {
    AppMethodBeat.i(370833);
    kotlin.g.b.s.u(parambg, "this$0");
    Object localObject = parambg.ecQ();
    if (localObject != null)
    {
      com.tencent.mm.view.recyclerview.j localj = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject, parambg.AZE.hashCode());
      if (localj != null)
      {
        localObject = new Rect();
        if ((localj.caK.getGlobalVisibleRect((Rect)localObject)) && (((Rect)localObject).height() > 0))
        {
          if (!paramBoolean) {
            break label166;
          }
          paramLinearLayoutManager = parambg.AZO;
          if (paramLinearLayoutManager != null)
          {
            paramLinearLayoutManager = paramLinearLayoutManager.getRecyclerView();
            if (paramLinearLayoutManager != null) {
              paramLinearLayoutManager.br(0, ((Rect)localObject).height());
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i(parambg.TAG, "[hideSearchBar] to hide search bar. delay=" + paramLong + " isSmooth=" + paramBoolean + " height=" + ((Rect)localObject).height());
      AppMethodBeat.o(370833);
      return;
      label166:
      if (paramLinearLayoutManager != null) {
        paramLinearLayoutManager.bo(1, 0);
      }
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, final bg parambg, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(370845);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(parambg, "this$0");
    paramDialogInterface = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(paramDialogInterface, "getMyFinderUsername()");
    paramDialogInterface = new bt(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
    paramBaseFinderFeed = parambg.tipDialog;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = ah.aiuX)
    {
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = (Context)parambg.lzt;
        parambg.lzt.getString(e.h.app_tip);
        parambg.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a(paramBaseFinderFeed, parambg.lzt.getString(e.h.app_waiting), false, bg..ExternalSyntheticLambda0.INSTANCE));
      }
      com.tencent.mm.kernel.h.aZW().a(paramDialogInterface.getType(), (com.tencent.mm.am.h)new o(paramDialogInterface, parambg));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramDialogInterface, 0);
      AppMethodBeat.o(370845);
      return;
      paramBaseFinderFeed.show();
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, bg parambg, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(370844);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramf, "$sheet");
    if (!paramBaseFinderFeed.feedObject.isNotShareConversation())
    {
      paramBaseFinderFeed = parambg.ATr;
      Context localContext = (Context)parambg.lzt;
      kotlin.g.b.s.s(params, "menu");
      paramBaseFinderFeed.a(localContext, params, paramf);
      paramBaseFinderFeed = com.tencent.mm.plugin.finder.utils.an.GhR;
      an.a.TX(parambg.ATr.getItemCount());
    }
    AppMethodBeat.o(370844);
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj, bg parambg, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(370843);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramf, "$sheet");
    label93:
    Object localObject1;
    if (paramBaseFinderFeed.feedObject.isLongVideo())
    {
      paramBaseFinderFeed.feedObject.isPostFinish();
      paramj = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
      if (paramj != null) {
        break label495;
      }
      paramj = null;
      if ((paramj instanceof FinderThumbPlayerProxy))
      {
        paramj = parambg.AZO;
        if (paramj != null) {
          break label503;
        }
        paramj = null;
        localObject1 = paramj;
        if (paramj == null)
        {
          localObject1 = parambg.lzt.getString(e.h.mega_video_play_speed_text);
          kotlin.g.b.s.s(localObject1, "context.getString(R.stri…ga_video_play_speed_text)");
        }
        params.a(ATk, (CharSequence)localObject1, e.g.icons_outlined_play_control_2);
      }
    }
    paramj = am.GhD;
    paramj = (Activity)parambg.lzt;
    kotlin.g.b.s.s(params, "menu");
    am.a(paramj, paramBaseFinderFeed, params, paramf, ATn);
    paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
    boolean bool;
    if (com.tencent.mm.plugin.finder.utils.av.I(paramBaseFinderFeed.feedObject))
    {
      int j = ATb;
      paramj = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramj = (CharSequence)com.tencent.mm.plugin.finder.utils.av.r(paramBaseFinderFeed);
      int k = e.g.icons_outlined_bgm_play;
      if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed()))
      {
        bool = true;
        label227:
        params.a(j, paramj, k, bool);
      }
    }
    else
    {
      paramj = paramBaseFinderFeed.contact;
      if (paramj != null) {
        break label538;
      }
      paramj = localObject2;
      label252:
      if (kotlin.n.n.T(paramj, com.tencent.mm.model.z.bAW(), false)) {
        break label546;
      }
      params.a(AST, (CharSequence)parambg.lzt.getString(e.h.more_menu_unlike), e.g.finder_feed_dislike);
      params.a(ASV, (CharSequence)parambg.lzt.getString(e.h.more_menu_back), e.g.icons_outlined_report_problem);
    }
    for (;;)
    {
      paramj = (CharSequence)paramBaseFinderFeed.feedObject.getFeedObject().internal_feedback_url;
      if ((paramj == null) || (paramj.length() == 0)) {
        i = 1;
      }
      if (i == 0) {
        params.a(BaA, (CharSequence)parambg.lzt.getString(e.h.finder_debug_title_2), e.g.icons_outlined_finder_internal_feedback);
      }
      i = parambg.AZs.getDataListJustForAdapter().indexOf(paramBaseFinderFeed);
      if (i < 0)
      {
        Log.i(parambg.TAG, "pos is error " + i + ' ' + paramBaseFinderFeed);
        if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {
          com.tencent.mm.ui.base.aa.makeText(MMApplicationContext.getContext(), (CharSequence)("pos is error " + i + ' ' + paramBaseFinderFeed + ' '), 1).show();
        }
      }
      AppMethodBeat.o(370843);
      return;
      label495:
      paramj = paramj.getVideoView();
      break;
      label503:
      paramj = paramj.getRecyclerView();
      if (paramj == null)
      {
        paramj = null;
        break label93;
      }
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.av.GUq;
      paramj = com.tencent.mm.plugin.finder.viewmodel.component.av.a.H(paramj);
      break label93;
      bool = false;
      break label227;
      label538:
      paramj = paramj.field_username;
      break label252;
      label546:
      paramj = aw.Gjk;
      if (!aw.s(paramBaseFinderFeed))
      {
        params.bx(pIs, e.h.app_delete, e.g.icons_outlined_delete);
        if (paramBaseFinderFeed.feedObject.isCommentClose()) {
          params.a(ASZ, (CharSequence)parambg.lzt.getString(e.h.finder_feed_open_comment), e.g.icons_outlined_comment);
        } else {
          params.a(ASY, (CharSequence)parambg.lzt.getString(e.h.finder_feed_close_comment), e.g.finder_feed_discomment);
        }
      }
    }
  }
  
  private final void a(com.tencent.mm.plugin.finder.preload.c paramc, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(362982);
    com.tencent.mm.plugin.finder.preload.c.pp(ecI());
    Object localObject = this.AZO;
    if (localObject != null) {
      ((aw.b)localObject).pZ(true);
    }
    c.b localb = (c.b)new aa(this);
    Log.i(this.TAG, "load share feed no hit cache objectId=" + ecI() + " isMegaVideo=" + paramBoolean + " username=" + paramString);
    long l = ecI();
    String str = getNonceId();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject = as.a.hu((Context)this.lzt);
      if (localObject != null) {
        break label187;
      }
    }
    label187:
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).fou())
    {
      com.tencent.mm.plugin.finder.preload.c.a(paramc, l, str, i, (bui)localObject, paramBoolean, paramString, localb);
      AppMethodBeat.o(362982);
      return;
      i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).AJo;
      break;
    }
  }
  
  private final void a(bui parambui, ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(363044);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = (Iterable)paramArrayList;
    paramArrayList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    label126:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      cc localcc = (cc)localObject2;
      if (((localcc instanceof BaseFinderFeed)) && (!((com.tencent.mm.plugin.finder.viewmodel.h)this.Bab.getValue()).az(4, ((BaseFinderFeed)localcc).feedObject.getId()))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label126;
        }
        paramArrayList.add(localObject2);
        break;
      }
    }
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      localObject2 = (cc)paramArrayList.next();
      if ((localObject2 instanceof BaseFinderFeed))
      {
        localObject1 = new byg();
        ((byg)localObject1).hKN = ((BaseFinderFeed)localObject2).feedObject.getId();
        ((byg)localObject1).objectNonceId = ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId();
        localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
        ((byg)localObject1).sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(((byg)localObject1).hKN, parambui.AJo);
        ((byg)localObject1).hJx = 4;
        localLinkedList.add(localObject1);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new com.tencent.mm.plugin.finder.cgi.c((List)localLinkedList, parambui).bFJ();
      }
      AppMethodBeat.o(363044);
      return;
    }
  }
  
  private final void a(RefreshLoadMoreLayout.d<Object> paramd, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(363025);
    Object localObject1 = this.AZO;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        break label103;
      }
      localObject1 = (WxRecyclerAdapter)localObject1;
      label38:
      if (localObject1 != null) {
        break label109;
      }
      i = 0;
      label45:
      if (i > 0) {
        break label118;
      }
    }
    com.tencent.mm.plugin.finder.storage.d locald;
    label103:
    label109:
    label118:
    for (int i = 1;; i = 0)
    {
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eRH()) || (i == 0)) {
        break label123;
      }
      AppMethodBeat.o(363025);
      return;
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      break;
      localObject1 = null;
      break label38;
      i = ((com.tencent.mm.view.recyclerview.i)localObject1).jNl();
      break label45;
    }
    label123:
    if (((this.hJx == 3) || (this.hJx == 1)) && (paramd != null))
    {
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eRH()) || ((i == 0) && (!paramd.agJu)))
      {
        this.Bal = true;
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f((WxRecyclerAdapter)localObject1, this));
        ((Map)Baz).put(ecP(), paramd);
        AppMethodBeat.o(363025);
        return;
      }
      if ((paramBoolean) && (localObject1 != null))
      {
        if (((WxRecyclerAdapter)localObject1).b(this.Baq)) {
          com.tencent.mm.view.recyclerview.i.b((com.tencent.mm.view.recyclerview.i)localObject1, this.Baq.bZA());
        }
        paramd = this.AZO;
        if (paramd != null) {
          break label294;
        }
        paramd = null;
        if (paramd != null) {
          paramd.setCanLoadMore(true);
        }
        paramd = this.AZO;
        if (paramd != null) {
          break label304;
        }
      }
    }
    label294:
    label304:
    for (paramd = localObject2;; paramd = paramd.aNL())
    {
      if (paramd != null) {
        paramd.setHasBottomMore(true);
      }
      AppMethodBeat.o(363025);
      return;
      paramd = paramd.aNL();
      break;
    }
  }
  
  private static final void b(LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(370835);
    if (paramLinearLayoutManager != null) {
      paramLinearLayoutManager.bo(0, 0);
    }
    AppMethodBeat.o(370835);
  }
  
  private static final void b(bg parambg)
  {
    AppMethodBeat.i(363093);
    kotlin.g.b.s.u(parambg, "this$0");
    if (parambg.hJx == 1)
    {
      com.tencent.mm.plugin.finder.extension.reddot.l locall = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
      com.tencent.mm.plugin.finder.extension.reddot.l.dZP().a((androidx.lifecycle.q)parambg.lzt, new bg..ExternalSyntheticLambda2(parambg));
      locall = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
      com.tencent.mm.plugin.finder.extension.reddot.l.dZJ().a((androidx.lifecycle.q)parambg.lzt, new bg..ExternalSyntheticLambda3(parambg));
    }
    AppMethodBeat.o(363093);
  }
  
  private static final void b(bg parambg, l.a parama)
  {
    AppMethodBeat.i(363084);
    kotlin.g.b.s.u(parambg, "this$0");
    parambg = parambg.AZg;
    if (parambg != null)
    {
      parama = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)parambg).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fnb();
    }
    AppMethodBeat.o(363084);
  }
  
  private static final void b(bg parambg, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(370847);
    kotlin.g.b.s.u(parambg, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(e.e.toast_text);
      if (localTextView != null) {
        localTextView.setTextSize(1, 14.0F);
      }
    }
    if (paramView != null)
    {
      paramView = (WeImageView)paramView.findViewById(e.e.toast_img);
      if (paramView != null)
      {
        paramView.setImageResource(e.g.icons_filled_done);
        paramView.setIconColor(paramView.getContext().getResources().getColor(e.b.White));
      }
    }
    i.a.a((i)parambg, paramBaseFinderFeed.feedObject, false);
    AppMethodBeat.o(370847);
  }
  
  private static final void c(bg parambg)
  {
    AppMethodBeat.i(370827);
    kotlin.g.b.s.u(parambg, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)parambg.lzt);
    if (localObject != null)
    {
      parambg = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).Vo(parambg.hJx);
      if (parambg != null)
      {
        parambg = parambg.AOi;
        if (parambg != null) {
          parambg.onChanged();
        }
      }
    }
    AppMethodBeat.o(370827);
  }
  
  private final void checkEmptyHeader(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(165903);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramd, this));
    AppMethodBeat.o(165903);
  }
  
  private static final void d(bg parambg)
  {
    AppMethodBeat.i(370829);
    kotlin.g.b.s.u(parambg, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)parambg.lzt);
    if (localObject != null)
    {
      parambg = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject).Vo(parambg.hJx);
      if (parambg != null)
      {
        parambg = parambg.AOi;
        if (parambg != null) {
          parambg.onChanged();
        }
      }
    }
    AppMethodBeat.o(370829);
  }
  
  private static final void e(bg parambg)
  {
    AppMethodBeat.i(370837);
    kotlin.g.b.s.u(parambg, "this$0");
    AppMethodBeat.o(370837);
  }
  
  private final long ecI()
  {
    AppMethodBeat.i(362939);
    long l = ((Number)this.AZY.getValue()).longValue();
    AppMethodBeat.o(362939);
    return l;
  }
  
  private final boolean ecJ()
  {
    AppMethodBeat.i(362951);
    boolean bool = ((Boolean)this.Baa.getValue()).booleanValue();
    AppMethodBeat.o(362951);
    return bool;
  }
  
  private final int ecK()
  {
    AppMethodBeat.i(362958);
    int i = ((Number)this.Bac.getValue()).intValue();
    AppMethodBeat.o(362958);
    return i;
  }
  
  private final com.tencent.mm.plugin.finder.feed.model.i ecL()
  {
    AppMethodBeat.i(362966);
    com.tencent.mm.plugin.finder.feed.model.i locali = (com.tencent.mm.plugin.finder.feed.model.i)this.Bae.getValue();
    AppMethodBeat.o(362966);
    return locali;
  }
  
  private final com.tencent.mm.plugin.findersdk.a.as ecM()
  {
    AppMethodBeat.i(362974);
    com.tencent.mm.plugin.findersdk.a.as localas = (com.tencent.mm.plugin.findersdk.a.as)this.Baf.getValue();
    AppMethodBeat.o(362974);
    return localas;
  }
  
  private final FinderWhatsNewView ecN()
  {
    AppMethodBeat.i(165899);
    FinderWhatsNewView localFinderWhatsNewView = (FinderWhatsNewView)this.Bai.getValue();
    AppMethodBeat.o(165899);
    return localFinderWhatsNewView;
  }
  
  private final void ecO()
  {
    AppMethodBeat.i(363007);
    Object localObject1 = this.AZO;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        break label84;
      }
      localObject1 = (WxRecyclerAdapter)localObject1;
      label29:
      if ((localObject1 == null) || (((WxRecyclerAdapter)localObject1).a((i.b)this.AZE))) {
        break label89;
      }
    }
    label84:
    label89:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label94;
      }
      AppMethodBeat.o(363007);
      return;
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((RecyclerView)localObject1).getAdapter();
      break;
      localObject1 = null;
      break label29;
    }
    label94:
    localObject1 = this.AZO;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        break label177;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      label117:
      localObject2 = ecQ();
      if ((localObject2 == null) || (((com.tencent.mm.view.recyclerview.i)localObject2).a((i.b)this.AZE))) {
        break label182;
      }
    }
    label177:
    label182:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label187;
      }
      AppMethodBeat.o(363007);
      return;
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      break;
      localObject1 = null;
      break label117;
    }
    label187:
    if (localObject1 != null) {
      ((LinearLayoutManager)localObject1).bo(1, 0);
    }
    Object localObject2 = this.AZO;
    if (localObject2 != null)
    {
      localObject2 = ((aw.b)localObject2).getRecyclerView();
      if (localObject2 != null) {
        ((RecyclerView)localObject2).postDelayed(new bg..ExternalSyntheticLambda19(this, false, (LinearLayoutManager)localObject1, 0L), 0L);
      }
    }
    AppMethodBeat.o(363007);
  }
  
  private final com.tencent.mm.view.recyclerview.i<com.tencent.mm.view.recyclerview.j> ecQ()
  {
    AppMethodBeat.i(165914);
    Object localObject = this.AZO;
    if (localObject == null) {
      localObject = null;
    }
    while ((localObject instanceof com.tencent.mm.view.recyclerview.i))
    {
      localObject = (com.tencent.mm.view.recyclerview.i)localObject;
      AppMethodBeat.o(165914);
      return localObject;
      localObject = ((aw.b)localObject).getRecyclerView();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((RecyclerView)localObject).getAdapter();
      }
    }
    AppMethodBeat.o(165914);
    return null;
  }
  
  private void ecR()
  {
    AppMethodBeat.i(363056);
    if (!this.Bat)
    {
      Object localObject = this.AZO;
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).aNL();
        if (localObject != null) {
          ((RefreshLoadMoreLayout)localObject).NZ(true);
        }
      }
      this.Bau = System.currentTimeMillis();
      localObject = new aav();
      ((aav)localObject).ieu.hJx = this.hJx;
      ((aav)localObject).ieu.iev = 1;
      ((aav)localObject).publish();
      this.Bat = true;
    }
    AppMethodBeat.o(363056);
  }
  
  private final void ecS()
  {
    AppMethodBeat.i(363067);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXj().bmg()).intValue() == 1)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.findersdk.a.by)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).cq(com.tencent.mm.plugin.findersdk.a.by.class)).fpm();
    }
    AppMethodBeat.o(363067);
  }
  
  private final int getItemCount()
  {
    AppMethodBeat.i(363061);
    com.tencent.mm.view.recyclerview.i locali = ecQ();
    if (locali == null)
    {
      AppMethodBeat.o(363061);
      return 0;
    }
    int i = locali.getItemCount();
    int j = locali.agOb.size();
    AppMethodBeat.o(363061);
    return i - j;
  }
  
  private final String getNonceId()
  {
    AppMethodBeat.i(362944);
    String str = (String)this.AZZ.getValue();
    AppMethodBeat.o(362944);
    return str;
  }
  
  private static final void j(DialogInterface paramDialogInterface) {}
  
  private static final void m(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(370826);
    kotlin.g.b.s.u(paramRecyclerView, "$rv");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt + 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "onRefreshEnd$lambda-25$lambda-24$lambda-23", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "onRefreshEnd$lambda-25$lambda-24$lambda-23", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(370826);
  }
  
  private static final void n(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(370832);
    kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "smoothScrollToNextPosition$lambda-35", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "smoothScrollToNextPosition$lambda-35", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(370832);
  }
  
  private final void t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(362996);
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(362996);
      throw paramRecyclerView;
    }
    int i = ((FinderLinearLayoutManager)localLayoutManager).Ju() + 1;
    Log.i(this.TAG, kotlin.g.b.s.X("[smoothScrollToNextPosition] nextPosition=", Integer.valueOf(i)));
    paramRecyclerView.post(new bg..ExternalSyntheticLambda14(paramRecyclerView, i));
    AppMethodBeat.o(362996);
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf)
  {
    AppMethodBeat.i(363820);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramBaseFinderFeed = new bg..ExternalSyntheticLambda8(paramBaseFinderFeed, this, paramf);
    AppMethodBeat.o(363820);
    return paramBaseFinderFeed;
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, int paramInt)
  {
    AppMethodBeat.i(363805);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramBaseFinderFeed = new bg..ExternalSyntheticLambda7(this, paramBaseFinderFeed, paramf);
    AppMethodBeat.o(363805);
    return paramBaseFinderFeed;
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363815);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new bg..ExternalSyntheticLambda9(paramBaseFinderFeed, paramj, this, paramf);
    AppMethodBeat.o(363815);
    return paramBaseFinderFeed;
  }
  
  public final u.h a(com.tencent.mm.ui.widget.a.f paramf, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363837);
    kotlin.g.b.s.u(paramf, "bottomSheet");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramf = new bg..ExternalSyntheticLambda10(this, paramf);
    AppMethodBeat.o(363837);
    return paramf;
  }
  
  public final u.i a(BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363827);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new bg..ExternalSyntheticLambda11(this, paramBaseFinderFeed, paramj);
    AppMethodBeat.o(363827);
    return paramBaseFinderFeed;
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(165919);
    kotlin.g.b.s.u(paramb, "ev");
    this.Baw = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcp, 3);
    Object localObject;
    int i;
    if ((this.Baw > 0) && ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5)))
    {
      localObject = ecQ();
      if (localObject == null) {}
      for (i = 0;; i = ((com.tencent.mm.view.recyclerview.i)localObject).getItemCount() - ((com.tencent.mm.view.recyclerview.i)localObject).agOb.size())
      {
        this.Bax = (i - this.Baw);
        localObject = com.tencent.mm.ui.component.k.aeZF;
        localObject = ((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(this.hJx);
        if ((this.Bav != 1) || (this.Bat) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).AOt < this.Bax) || (((com.tencent.mm.plugin.finder.viewmodel.d.a)localObject).GKD)) {
          break;
        }
        ecR();
        Log.i(this.TAG, "[onAutoToLoadMore] tabType=" + this.hJx + " configPosition=" + this.Baw + ", lastPosition=" + ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOt + ", preLoadBeginPosition=" + this.Bax + ", count=" + i);
        AppMethodBeat.o(165919);
        return;
      }
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.a.a))
    {
      i = ((com.tencent.mm.plugin.finder.event.a.a)paramb).type;
      localObject = com.tencent.mm.plugin.finder.event.a.a.ANi;
      if (i != com.tencent.mm.plugin.finder.event.a.a.dYk())
      {
        i = ((com.tencent.mm.plugin.finder.event.a.a)paramb).type;
        localObject = com.tencent.mm.plugin.finder.event.a.a.ANi;
        if (i != com.tencent.mm.plugin.finder.event.a.a.dYl()) {}
      }
      else
      {
        localObject = ecQ();
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.recyclerview.j)com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject, ((com.tencent.mm.plugin.finder.event.a.a)paramb).feedId);
          if (localObject != null)
          {
            com.tencent.mm.view.recyclerview.i locali = ecQ();
            if (locali != null) {
              locali.t(((com.tencent.mm.view.recyclerview.j)localObject).KJ(), new kotlin.r(Integer.valueOf(9), Long.valueOf(((com.tencent.mm.plugin.finder.event.a.a)paramb).feedId)));
            }
          }
        }
      }
    }
    AppMethodBeat.o(165919);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(363688);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    Object localObject2 = com.tencent.mm.plugin.finder.model.an.ECX;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    aw localaw = aw.Gjk;
    com.tencent.mm.plugin.finder.model.an.a((bui)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, aw.n(paramBaseFinderFeed.contact));
    AppMethodBeat.o(363688);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(363683);
    kotlin.g.b.s.u(paramFinderItem, "feed");
    Object localObject1 = com.tencent.mm.plugin.finder.model.s.ECs;
    com.tencent.mm.plugin.finder.model.s.a((AppCompatActivity)this.lzt, paramFinderItem, paramBoolean, paramInt);
    com.tencent.mm.plugin.finder.viewmodel.component.o localo;
    if (paramBoolean)
    {
      paramFinderItem = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((((Number)com.tencent.mm.plugin.finder.storage.d.eTy().bmg()).intValue() == 1) && (paramj != null))
      {
        localObject1 = new int[2];
        switch (paramj.caO)
        {
        case 3: 
        default: 
          paramFinderItem = null;
        }
        for (;;)
        {
          paramj = com.tencent.mm.ui.component.k.aeZF;
          localo = (com.tencent.mm.plugin.finder.viewmodel.component.o)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.o.class);
          kotlin.g.b.s.u(localObject1, "startViewLocation");
          localo.GOR = ((int[])localObject1);
          paramj = com.tencent.mm.ui.component.k.aeZF;
          Object localObject2 = (com.tencent.mm.plugin.finder.viewmodel.component.af)com.tencent.mm.ui.component.k.d(localo.getActivity()).q(com.tencent.mm.plugin.finder.viewmodel.component.af.class);
          paramj = localo.CCC;
          kotlin.g.b.s.u(paramj, "outRect");
          localObject1 = new int[2];
          localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.af)localObject2).findViewById(e.e.personalCenter);
          if (localObject2 != null)
          {
            ((View)localObject2).getLocationInWindow((int[])localObject1);
            paramInt = localObject1[0];
            int i = localObject1[1];
            int j = localObject1[0];
            int k = ((View)localObject2).getWidth();
            int m = localObject1[1];
            paramj.set(paramInt, i, j + k, ((View)localObject2).getHeight() + m);
          }
          localObject1 = localo.GOR;
          paramj = (com.tencent.mm.view.recyclerview.j)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("startLocation");
            paramj = null;
          }
          if ((paramj[1] >= localo.CCC.bottom) && (paramFinderItem != null)) {
            break;
          }
          Log.i("FinderFavAnimUIC", kotlin.g.b.s.X("animFav: only animate star, bitmap = ", paramFinderItem));
          localo.fnx();
          AppMethodBeat.o(363683);
          return;
          paramj = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
          paramFinderItem = paramj.getBitmap();
          paramj.getLocationInWindow((int[])localObject1);
          continue;
          paramFinderItem = ((FinderMediaBanner)paramj.UH(e.e.media_banner)).getPagerView();
          paramj = paramFinderItem.getLayoutManager();
          if (paramj == null)
          {
            paramFinderItem = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(363683);
            throw paramFinderItem;
          }
          paramFinderItem = paramFinderItem.fU(((LinearLayoutManager)paramj).Ju());
          if (paramFinderItem == null)
          {
            paramFinderItem = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.SimpleViewHolder");
            AppMethodBeat.o(363683);
            throw paramFinderItem;
          }
          paramj = (ImageView)((com.tencent.mm.view.recyclerview.j)paramFinderItem).UH(e.e.finder_banner_image_layout);
          paramFinderItem = paramj.getDrawable();
          if (paramFinderItem == null)
          {
            paramFinderItem = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            AppMethodBeat.o(363683);
            throw paramFinderItem;
          }
          paramFinderItem = ((BitmapDrawable)paramFinderItem).getBitmap();
          paramj.getLocationInWindow((int[])localObject1);
        }
        Log.i("FinderFavAnimUIC", "[animFrameImage]");
        if (localo.GOL == null)
        {
          paramj = (com.tencent.mm.plugin.finder.viewmodel.component.o)localo;
          paramj.GOL = new ImageView((Context)paramj.getActivity());
        }
        paramj = localo.GOL;
        if (paramj != null)
        {
          paramj.setImageBitmap(paramFinderItem);
          if (paramFinderItem.getWidth() <= paramFinderItem.getHeight()) {
            break label623;
          }
        }
      }
    }
    label623:
    for (float f = localo.GON / paramFinderItem.getWidth();; f = localo.GON / paramFinderItem.getHeight())
    {
      localo.EHT = f;
      localo.GOT.start();
      paramInt = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfk, 0);
      if (paramInt < 3) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfk, Integer.valueOf(paramInt + 1));
      }
      AppMethodBeat.o(363683);
      return;
    }
  }
  
  public final void a(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(165901);
    kotlin.g.b.s.u(paramd, "reason");
    checkEmptyHeader(paramd);
    Object localObject = this.AZO;
    if (localObject != null)
    {
      localObject = ((aw.b)localObject).getRecyclerView();
      if (localObject != null) {
        ((RecyclerView)localObject).post(new bg..ExternalSyntheticLambda15(this));
      }
    }
    com.tencent.mm.plugin.finder.report.s.a(com.tencent.mm.plugin.finder.report.s.Fqv, this.hJx, false, null, 12);
    Log.i(this.TAG, "[onLoadMoreEnd] reason=" + paramd + " isAutoLoadingMore=" + this.Bat);
    if ((paramd.agJw) && (paramd.agJu))
    {
      localObject = this.AZO;
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).getRecyclerView();
        if (localObject != null) {
          t((RecyclerView)localObject);
        }
      }
    }
    localObject = com.tencent.mm.plugin.finder.report.o.FpJ;
    localObject = (Context)this.lzt;
    int i = this.hJx;
    int j = getItemCount();
    boolean bool = this.Bat;
    int k = dYO();
    kotlin.g.b.s.u(localObject, "context");
    if (!com.tencent.mm.plugin.finder.report.o.cng())
    {
      Log.i("Finder.HomeActionReporter", "[onLoadMoreEnd] tabType:" + i + " itemCount:" + j + " isAuto:" + bool + " curPosition:" + k);
      com.tencent.mm.plugin.finder.report.o.hJx = i;
      com.tencent.mm.plugin.finder.report.o.c(i, j, false, k);
      com.tencent.mm.plugin.finder.report.o.B(i, 8, bool);
      com.tencent.mm.plugin.finder.report.o.a((Context)localObject, i, new kotlin.r(Integer.valueOf(8), Integer.valueOf(7)), true);
    }
    a(paramd, false);
    this.Bat = false;
    localObject = new aav();
    ((aav)localObject).ieu.hJx = this.hJx;
    ((aav)localObject).ieu.iev = 2;
    ((aav)localObject).ieu.iew = paramd.agJv;
    ((aav)localObject).ieu.costTime = (System.currentTimeMillis() - this.Bau);
    ((aav)localObject).publish();
    if ((paramd.agJu) && (paramd.agJv > 0)) {}
    for (i = 1;; i = -1)
    {
      this.Bav = i;
      AppMethodBeat.o(165901);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(165920);
    kotlin.g.b.s.u(paramc, "dispatcher");
    kotlin.g.b.s.u(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5))
      {
        AppMethodBeat.o(165920);
        return true;
      }
      AppMethodBeat.o(165920);
      return false;
    }
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.a.a))
    {
      int i = ((com.tencent.mm.plugin.finder.event.a.a)paramb).type;
      paramc = com.tencent.mm.plugin.finder.event.a.a.ANi;
      if (i != com.tencent.mm.plugin.finder.event.a.a.dYk())
      {
        i = ((com.tencent.mm.plugin.finder.event.a.a)paramb).type;
        paramc = com.tencent.mm.plugin.finder.event.a.a.ANi;
        if (i != com.tencent.mm.plugin.finder.event.a.a.dYl()) {}
      }
      else
      {
        AppMethodBeat.o(165920);
        return true;
      }
      AppMethodBeat.o(165920);
      return false;
    }
    AppMethodBeat.o(165920);
    return false;
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(363758);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    Object localObject2 = ((com.tencent.mm.plugin.finder.preload.tabPreload.c)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.preload.tabPreload.c.class)).Rn(this.hJx);
    boolean bool3 = this.AZj.Rp(this.hJx);
    int i;
    label102:
    label110:
    int j;
    label121:
    boolean bool1;
    if (localObject2 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject2).EWm;
      if ((localObject1 != null) && (((g.f)localObject1).isLoading == true))
      {
        i = 1;
        if ((i == 0) || (((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject2).EWm.EWo != g.g.EWG)) {
          break label569;
        }
        i = 1;
        if (localObject2 != null) {
          break label575;
        }
        localObject1 = null;
        if (localObject1 != g.g.EWG) {
          break label603;
        }
        j = 1;
        if ((!bool3) || (i == 0)) {
          break label609;
        }
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject2).a(false, g.g.EWG);
        }
        Log.w(this.TAG, kotlin.g.b.s.X("[checkAutoFlingToRefresh] reset loadingState tabType=", Integer.valueOf(this.hJx)));
        label165:
        if ((bool3) || ((i == 0) && (j == 0))) {
          break label654;
        }
        bool1 = true;
        label183:
        if ((!bool1) && (!bool3) && (!paramBoolean1)) {
          break label762;
        }
        localObject1 = this.AZO;
        if (localObject1 != null) {
          break label660;
        }
        localObject1 = null;
        label211:
        if (!(localObject1 instanceof LinearLayoutManager)) {
          break label690;
        }
        localObject1 = (LinearLayoutManager)localObject1;
        label226:
        if (localObject1 != null) {
          break label696;
        }
        i = 0;
        label234:
        Log.i(this.TAG, "[checkAutoFlingToRefresh] isHard=" + paramBoolean1 + " isWithRefresh=" + paramBoolean2 + " isContinueRefresh=" + bool1 + " offset=" + i + " delayStartMs=" + paramLong + " tabType=" + this.hJx + " isFromShareToTimeline=" + ecJ());
        localObject1 = this.AZO;
        if (localObject1 != null) {
          break label706;
        }
        localObject1 = null;
        label340:
        if (!(localObject1 instanceof LinearLayoutManager)) {
          break label736;
        }
        localObject1 = (LinearLayoutManager)localObject1;
        label355:
        if (localObject1 != null) {
          ((LinearLayoutManager)localObject1).bo(0, 0);
        }
        if (i < 0)
        {
          localObject2 = this.AZO;
          if (localObject2 != null)
          {
            localObject2 = ((aw.b)localObject2).getRecyclerView();
            if (localObject2 != null) {
              ((RecyclerView)localObject2).post(new bg..ExternalSyntheticLambda12((LinearLayoutManager)localObject1));
            }
          }
        }
        if (!paramBoolean2) {
          break label787;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
        com.tencent.mm.plugin.finder.report.s.Ss(this.hJx);
        if ((!ecJ()) || (this.AZs.Bjd) || (this.hJx != 4)) {
          break label742;
        }
        localObject1 = this.AZO;
        if (localObject1 != null) {
          ((aw.b)localObject1).c(0L, true, true);
        }
        label474:
        this.AZQ = true;
      }
    }
    label654:
    label787:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.canTimelineRefresh = false;
      label486:
      if (this.hJx == 4)
      {
        localObject1 = this.AZg;
        if (localObject1 != null) {
          if (!paramBoolean1) {
            break label772;
          }
        }
      }
      for (this.Bas.ECT.state = -200;; this.Bas.ECT.state = -100)
      {
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fnb();
        localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
        com.tencent.mm.plugin.finder.report.s.eMO();
        AppMethodBeat.o(363758);
        return paramBoolean1;
        i = 0;
        break;
        label569:
        i = 0;
        break label102;
        label575:
        localObject1 = ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject2).EWk;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label110;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.preload.tabPreload.g.a)localObject1).EWo;
        break label110;
        label603:
        j = 0;
        break label121;
        label609:
        if ((!bool3) || (j == 0)) {
          break label165;
        }
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.finder.preload.tabPreload.g)localObject2).ta(true);
        }
        Log.w(this.TAG, kotlin.g.b.s.X("[checkAutoFlingToRefresh] clear last refresh response. tabType=", Integer.valueOf(this.hJx)));
        break label165;
        bool1 = false;
        break label183;
        label660:
        localObject1 = ((aw.b)localObject1).getRecyclerView();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label211;
        }
        localObject1 = ((RecyclerView)localObject1).getLayoutManager();
        break label211;
        label690:
        localObject1 = null;
        break label226;
        label696:
        i = ((LinearLayoutManager)localObject1).Ju();
        break label234;
        label706:
        localObject1 = ((aw.b)localObject1).getRecyclerView();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label340;
        }
        localObject1 = ((RecyclerView)localObject1).getLayoutManager();
        break label340;
        label736:
        localObject1 = null;
        break label355;
        label742:
        localObject1 = this.AZO;
        if (localObject1 == null) {
          break label474;
        }
        aw.b.a.a((aw.b)localObject1, paramLong);
        break label474;
        label762:
        ecS();
        paramBoolean1 = bool2;
        break label486;
      }
    }
  }
  
  public final String bys()
  {
    AppMethodBeat.i(363586);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).zIO;
    if (localObject == null)
    {
      AppMethodBeat.o(363586);
      return "";
    }
    AppMethodBeat.o(363586);
    return localObject;
  }
  
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(165910);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new b(this);
    AppMethodBeat.o(165910);
    return localg;
  }
  
  public final int dYO()
  {
    AppMethodBeat.i(363877);
    Object localObject = this.AZO;
    if (localObject == null) {
      i = 0;
    }
    while (i <= 0)
    {
      AppMethodBeat.o(363877);
      return 0;
      localObject = ((aw.b)localObject).getRecyclerView();
      if (localObject == null) {
        i = 0;
      } else {
        i = ((RecyclerView)localObject).getChildCount();
      }
    }
    localObject = this.AZO;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof LinearLayoutManager)) {
        break label112;
      }
    }
    label112:
    for (localObject = (LinearLayoutManager)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label117;
      }
      AppMethodBeat.o(363877);
      return 0;
      localObject = ((aw.b)localObject).getRecyclerView();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((RecyclerView)localObject).getLayoutManager();
      break;
    }
    label117:
    int i = ((LinearLayoutManager)localObject).Jw();
    AppMethodBeat.o(363877);
    return i;
  }
  
  public final com.tencent.mm.plugin.finder.view.f ebA()
  {
    AppMethodBeat.i(363560);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.i)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.i.class)).ATy;
    AppMethodBeat.o(363560);
    return localObject;
  }
  
  public final boolean ebw()
  {
    return false;
  }
  
  public final RecyclerView.m ebz()
  {
    return this.ATp;
  }
  
  public final void ecA()
  {
    AppMethodBeat.i(363784);
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new ab(this));
    AppMethodBeat.o(363784);
  }
  
  public final FinderTimelineFeedLoader ecB()
  {
    return this.AZs;
  }
  
  public final String ecP()
  {
    AppMethodBeat.i(363635);
    Object localObject = this.AZs.getListOfType(BaseFinderFeed.class);
    int i;
    long l1;
    if (((List)localObject).size() == 0)
    {
      i = 1;
      if (i == 0) {
        break label110;
      }
      l1 = 0L;
      label36:
      if (i == 0) {
        break label131;
      }
    }
    label131:
    for (long l2 = 0L;; l2 = ((BaseFinderFeed)((List)localObject).get(((List)localObject).size() - 1)).feedObject.getId())
    {
      localObject = this.hJx + '_' + l1 + '_' + l2 + '_' + ((List)localObject).size();
      AppMethodBeat.o(363635);
      return localObject;
      i = 0;
      break;
      label110:
      l1 = ((BaseFinderFeed)((List)localObject).get(0)).feedObject.getId();
      break label36;
    }
  }
  
  public final void f(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(363850);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    ak localak = ak.ECS;
    Context localContext = (Context)this.lzt;
    bh localbh = bh.ABm;
    ak.a(localak, localContext, (bui)localObject, paramBaseFinderFeed, bh.dVr(), paramBaseFinderFeed.isDeepEnjoy);
    localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null) {
      paramBaseFinderFeed = "";
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.api.m.Axk;
      com.tencent.mm.plugin.finder.api.d.a.et(paramBaseFinderFeed, com.tencent.mm.plugin.finder.api.m.dUG());
      AppMethodBeat.o(363850);
      return;
      localObject = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject;
      if (localObject == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  public final MMActivity getActivity()
  {
    return this.lzt;
  }
  
  public final List<i.b> getHeaderInfo()
  {
    Object localObject2 = null;
    AppMethodBeat.i(165909);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcq, 0);
    int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcs, 0);
    int k = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adct, 0);
    int m = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcu, 0);
    com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcv, 0);
    int n = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcw, 0);
    this.msgNotifyData.count = (i + j + k + m + n);
    Object localObject1 = this.msgNotifyData;
    ((com.tencent.mm.plugin.finder.model.h)localObject1).commentCount = i;
    ((com.tencent.mm.plugin.finder.model.h)localObject1).likeCount = (j + k + m);
    ((com.tencent.mm.plugin.finder.model.h)localObject1).ECm = n;
    localObject1 = this.msgNotifyData;
    Object localObject3 = com.tencent.mm.kernel.h.baE().ban().get(at.a.adcx, "");
    if (localObject3 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(165909);
      throw ((Throwable)localObject1);
    }
    ((com.tencent.mm.plugin.finder.model.h)localObject1).setAvatar((String)localObject3);
    Log.i(this.TAG, "commentCnt " + i + ", likeCnt " + j + " objectLikeLikeCnt " + k + " objectRecommendLikeCnt friendRecommendCnt:" + n + ' ' + m + " avatar: " + this.msgNotifyData.avatar + " tabType " + this.hJx);
    com.tencent.mm.plugin.finder.model.al localal;
    com.tencent.mm.view.recyclerview.j localj;
    if ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (3 != this.hJx))
    {
      localObject1 = this.AZg;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.ui.component.k.aeZF;
        com.tencent.mm.plugin.finder.viewmodel.component.e locale = (com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class);
        localal = this.Bas;
        kotlin.g.b.s.u(localal, "headerFullMergedData");
        kotlin.g.b.s.u(this, "presenter");
        locale.Bas = localal;
        localObject1 = (ViewGroup)locale.findViewById(e.e.actionBarMergedLayout);
        ((ViewGroup)localObject1).setVisibility(0);
        locale.GMB = new com.tencent.mm.plugin.finder.convert.s(this);
        localObject3 = com.tencent.mm.ui.af.mU((Context)locale.getContext());
        if (locale.GMB == null) {
          kotlin.g.b.s.bIx("feedFullMergedHeaderConvert");
        }
        localObject3 = ((LayoutInflater)localObject3).inflate(e.f._feed_full_merged_header_layout, (ViewGroup)localObject1, false);
        ((ViewGroup)localObject1).addView((View)localObject3);
        localObject1 = new com.tencent.mm.view.recyclerview.j((View)localObject3);
        ((com.tencent.mm.view.recyclerview.j)localObject1).mkw = locale.getRecyclerView();
        localObject3 = ah.aiuX;
        locale.GMC = ((com.tencent.mm.view.recyclerview.j)localObject1);
        localj = locale.GMC;
        if (localj != null)
        {
          localObject3 = locale.GMB;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            kotlin.g.b.s.bIx("feedFullMergedHeaderConvert");
            localObject1 = null;
          }
          ((com.tencent.mm.plugin.finder.convert.s)localObject1).a(locale.getRecyclerView(), localj, 2019);
          localj.CSA = localal;
          localObject1 = locale.GMB;
          if (localObject1 != null) {
            break label604;
          }
          kotlin.g.b.s.bIx("feedFullMergedHeaderConvert");
          localObject1 = localObject2;
        }
      }
    }
    label604:
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.convert.s)localObject1).a(localj, localal, 0);
      localObject1 = (List)kotlin.a.ab.aivy;
      AppMethodBeat.o(165909);
      return localObject1;
    }
  }
  
  public final int getTabType()
  {
    return this.hJx;
  }
  
  public final com.tencent.mm.plugin.finder.video.l getVideoCore()
  {
    return this.AJn;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(165921);
    kotlin.g.b.s.u(parama, "p0");
    this.ATq.add(parama);
    AppMethodBeat.o(165921);
  }
  
  public final void oi(final boolean paramBoolean)
  {
    AppMethodBeat.i(363657);
    Object localObject = com.tencent.mm.plugin.finder.report.o.FpJ;
    localObject = (Context)this.lzt;
    int i = this.hJx;
    int j = getItemCount();
    boolean bool = this.Bat;
    int k = dYO();
    kotlin.g.b.s.u(localObject, "context");
    if (!com.tencent.mm.plugin.finder.report.o.cng())
    {
      Log.i("Finder.HomeActionReporter", "[onLoadMoreStart] tabType:" + i + " itemCount:" + j + " isAuto:" + bool + " curPosition:" + k);
      com.tencent.mm.plugin.finder.report.o.hJx = i;
      com.tencent.mm.plugin.finder.report.o.c(i, j, true, k);
      com.tencent.mm.plugin.finder.report.o.B(i, 7, bool);
      com.tencent.mm.plugin.finder.report.o.a((Context)localObject, i, new kotlin.r(Integer.valueOf(7), Integer.valueOf(8)));
    }
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new s(this, paramBoolean));
    AppMethodBeat.o(363657);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(363665);
    if (this.AZO == null) {}
    aw.b localb;
    for (boolean bool = false;; bool = localb.onBackPressed())
    {
      AppMethodBeat.o(363665);
      return bool;
      localb = this.AZO;
      kotlin.g.b.s.checkNotNull(localb);
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(165913);
    Log.i(this.TAG, "onDestroy");
    com.tencent.mm.plugin.finder.storage.data.f.FMT.clearCache();
    this.Bag.dead();
    this.Bah.dead();
    Object localObject1 = this.AZO;
    int i;
    int j;
    if (localObject1 != null)
    {
      Object localObject2 = ((aw.b)localObject1).getRecyclerView().getLayoutManager();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(165913);
        throw ((Throwable)localObject1);
      }
      int k = ((LinearLayoutManager)localObject2).Ju();
      localObject2 = ecQ();
      if (localObject2 == null)
      {
        i = 0;
        j = k - i;
        localObject1 = ((aw.b)localObject1).getRecyclerView().fT(k);
        if (localObject1 != null) {
          break label216;
        }
        i = 0;
      }
      for (;;)
      {
        label131:
        if ((!ecJ()) || (this.hJx != 4))
        {
          localObject1 = ((Iterable)this.AZs.getDataListJustForAdapter()).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (cc)((Iterator)localObject1).next();
              if ((localObject2 instanceof BaseFinderFeed))
              {
                ((BaseFinderFeed)localObject2).eDg();
                continue;
                i = ((com.tencent.mm.view.recyclerview.i)localObject2).agOb.size();
                break;
                label216:
                localObject1 = ((RecyclerView.v)localObject1).caK;
                if (localObject1 == null)
                {
                  i = 0;
                  break label131;
                }
                i = ((View)localObject1).getTop();
                break label131;
              }
            }
          }
          localObject1 = com.tencent.mm.ui.component.k.aeZF;
          localObject1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
          kotlin.g.b.s.s(localObject1, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
          com.tencent.mm.plugin.finder.viewmodel.d.a((com.tencent.mm.plugin.finder.viewmodel.d)localObject1, this.hJx, j, i, (ArrayList)this.AZs.getDataListJustForAdapter(), null, 112);
        }
      }
    }
    for (;;)
    {
      localObject1 = this.AZR;
      if (localObject1 != null)
      {
        ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).b((com.tencent.mm.pluginsdk.i.a.a)localObject1);
        this.AZR = null;
      }
      localObject1 = this.AZS;
      if (localObject1 != null)
      {
        ((IListener)localObject1).dead();
        this.AZS = null;
      }
      localObject1 = ((Iterable)this.ATq).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((com.tencent.mm.vending.e.a)((Iterator)localObject1).next()).dead();
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class);
      kotlin.g.b.s.s(localObject1, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
      com.tencent.mm.plugin.finder.viewmodel.d.a((com.tencent.mm.plugin.finder.viewmodel.d)localObject1, 114, j, i, (ArrayList)this.AZs.getDataListJustForAdapter(), null, 112);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      a(((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), (ArrayList)this.AZs.getDataListJustForAdapter());
    }
    this.ATq.clear();
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).Vr(this.hJx);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)ecL());
    }
    ecL().onDetach();
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).Vr(this.hJx);
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)this);
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b(ecM().edV());
    }
    ecM().onDetach();
    this.AZs.unregister(this.ATF);
    this.Bam.dead();
    this.Bay.dead();
    localObject1 = this.AYg;
    if (localObject1 != null) {
      ((ContactUninterestEventListener)localObject1).dead();
    }
    this.AZO = null;
    AppMethodBeat.o(165913);
  }
  
  public final void onRefreshEnd(final RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(165900);
    kotlin.g.b.s.u(paramd, "reason");
    Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
    Object localObject2 = com.tencent.mm.plugin.finder.extension.reddot.i.Nu(this.hJx);
    ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).DIg.remove(localObject2);
    localObject2 = this.lzt.getIntent().getStringExtra("KEY_TASK_ID");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i;
    if (this.Baj)
    {
      if (((CharSequence)localObject1).length() <= 0) {
        break label615;
      }
      i = 1;
      if (i != 0)
      {
        this.Baj = false;
        com.tencent.mm.plugin.report.service.h.OAn.b(23669, new Object[] { localObject1, "feed_got", Long.valueOf(System.currentTimeMillis()), "", Integer.valueOf(1), Integer.valueOf(1) });
      }
    }
    localObject1 = this.AZO;
    if (localObject1 != null) {
      ((aw.b)localObject1).pZ(false);
    }
    if ((paramd.agJw) && (paramd.agJu))
    {
      localObject1 = this.AZO;
      if (localObject1 != null)
      {
        localObject1 = ((aw.b)localObject1).getRecyclerView();
        if (localObject1 != null) {
          t((RecyclerView)localObject1);
        }
      }
    }
    localObject1 = this.AZO;
    if (localObject1 == null)
    {
      localObject1 = null;
      label239:
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setLayoutFrozen(false);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.id(bys(), "EndCgi");
      localObject2 = this.AJn.GpZ;
      if (localObject2 != null)
      {
        localObject1 = this.AZg;
        if (localObject1 != null) {
          break label632;
        }
        localObject1 = null;
        label293:
        FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject2, kotlin.g.b.s.X((String)localObject1, "#onAttach"), false);
      }
      Log.i(this.TAG, kotlin.g.b.s.X("[onRefreshEnd] reason=", paramd));
      if (paramd.agJv <= 0) {
        break label2001;
      }
      localObject1 = (List)this.AZs.getDataListJustForAdapter();
      localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
      label356:
      if (!((ListIterator)localObject2).hasPrevious()) {
        break label671;
      }
      localObject1 = (cc)((ListIterator)localObject2).previous();
      if (!(localObject1 instanceof BaseFinderFeed)) {
        break label660;
      }
      localObject1 = (BaseFinderFeed)localObject1;
      label393:
      if ((localObject1 == null) || (((BaseFinderFeed)localObject1).isHistoryFeed != true)) {
        break label666;
      }
      i = 1;
      label409:
      if (i == 0) {
        break label669;
      }
      i = ((ListIterator)localObject2).nextIndex();
      label421:
      if (i < 0) {
        break label2001;
      }
      localObject1 = this.AZO;
      if (localObject1 != null)
      {
        localObject1 = ((aw.b)localObject1).getRecyclerView();
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
          ((RecyclerView)localObject1).post(new bg..ExternalSyntheticLambda13((RecyclerView)localObject1, i));
        }
      }
    }
    for (;;)
    {
      int j;
      if (ecN() != null)
      {
        localObject1 = ecN();
        if ((localObject1 != null) && (((FinderWhatsNewView)localObject1).isAttachedToWindow() == true)) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label681;
          }
          localObject1 = ecN();
          if (localObject1 != null) {
            ((FinderWhatsNewView)localObject1).setDetachFinish((kotlin.g.a.a)new z(this, paramd));
          }
          AppMethodBeat.o(165900);
          return;
          label615:
          i = 0;
          break;
          localObject1 = ((aw.b)localObject1).getRecyclerView();
          break label239;
          label632:
          localObject1 = localObject1.getClass();
          if (localObject1 == null)
          {
            localObject1 = null;
            break label293;
          }
          localObject1 = ((Class)localObject1).getSimpleName();
          break label293;
          label660:
          localObject1 = null;
          break label393;
          label666:
          i = 0;
          break label409;
          label669:
          break label356;
          label671:
          i = -1;
          break label421;
        }
      }
      label681:
      label824:
      boolean bool;
      label862:
      FinderHomeTabFragment localFinderHomeTabFragment;
      if (paramd.agJv <= 0)
      {
        localObject1 = this.AZO;
        if (localObject1 != null)
        {
          localObject1 = ((aw.b)localObject1).aNL();
          if (localObject1 != null) {
            ((RefreshLoadMoreLayout)localObject1).e(0L, (kotlin.g.a.a)y.EGR);
          }
        }
        checkEmptyHeader(paramd);
        localObject1 = this.AZO;
        if (localObject1 != null)
        {
          localObject1 = ((aw.b)localObject1).getRecyclerView();
          if (localObject1 != null) {
            ((RecyclerView)localObject1).post(new bg..ExternalSyntheticLambda16(this));
          }
        }
        a(paramd, true);
        localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
        switch (this.hJx)
        {
        case 2: 
        default: 
          localObject1 = this.AZs.getDataListJustForAdapter();
          if ((((DataBuffer)localObject1).size() > 0) && (((cc)((DataBuffer)localObject1).get(0)).bZB() == 2))
          {
            bool = true;
            localObject1 = com.tencent.mm.plugin.finder.report.s.Fqv;
            j = this.hJx;
            localObject1 = com.tencent.mm.ui.component.k.aeZF;
            com.tencent.mm.plugin.finder.report.s.a(j, false, ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), bool);
            localObject1 = com.tencent.mm.plugin.finder.report.o.FpJ;
            localObject1 = (Context)this.lzt;
            j = this.hJx;
            int k = getItemCount();
            int m = dYO();
            kotlin.g.b.s.u(localObject1, "context");
            if (!com.tencent.mm.plugin.finder.report.o.cng())
            {
              Log.i("Finder.HomeActionReporter", "[onRefreshEnd] tabType:" + j + " itemCount:" + k + " curPosition:" + m);
              com.tencent.mm.plugin.finder.report.o.hJx = j;
              com.tencent.mm.plugin.finder.report.o.c(j, k, false, m);
              com.tencent.mm.plugin.finder.report.o.id(j, 6);
              com.tencent.mm.plugin.finder.report.o.a((Context)localObject1, j, new kotlin.r(Integer.valueOf(6), Integer.valueOf(5)), true);
            }
            localFinderHomeTabFragment = this.AZg;
            if (localFinderHomeTabFragment == null) {
              break label1749;
            }
            localObject1 = com.tencent.mm.ui.component.k.aeZF;
            localObject2 = (com.tencent.mm.plugin.finder.viewmodel.component.ac)com.tencent.mm.ui.component.k.y((Fragment)localFinderHomeTabFragment).q(com.tencent.mm.plugin.finder.viewmodel.component.ac.class);
            localObject1 = this.AZO;
            if (localObject1 != null) {
              break label1386;
            }
            localObject1 = null;
            label1088:
            ((com.tencent.mm.plugin.finder.viewmodel.component.ac)localObject2).setRecyclerView((RecyclerView)localObject1);
            localObject1 = this.AZs;
            if (localObject1 != null) {
              break label1398;
            }
            localObject1 = null;
            label1109:
            if (((localObject1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject1).feedObject.getMediaType() == 15)) {
              ((com.tencent.mm.plugin.finder.viewmodel.component.ac)localObject2).GQx = true;
            }
            localObject1 = this.AZs;
            if (localObject1 != null) {
              break label1433;
            }
          }
          break;
        }
      }
      for (localObject1 = null;; localObject1 = null)
      {
        ((com.tencent.mm.plugin.finder.viewmodel.component.ac)localObject2).l((cc)localObject1);
        ((com.tencent.mm.plugin.finder.viewmodel.component.ac)localObject2).vn(paramd.agJy);
        if (!(paramd.extraData instanceof FinderTimelineFeedLoader.d)) {
          break label1749;
        }
        localObject1 = paramd.extraData;
        if (localObject1 != null) {
          break label1485;
        }
        paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader.TimelineResponse");
        AppMethodBeat.o(165900);
        throw paramd;
        ecO();
        break;
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).hH("TLRecommendTab", "onRefreshEnd");
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL("TLRecommendTab");
        if (!ecJ()) {
          break label824;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).Su("TLRecommendTab");
        if (localObject2 == null) {
          break label824;
        }
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, "FinderEntrance", false);
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, "Discovery", false);
        break label824;
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).hH("TLFollow", "onRefreshEnd");
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL("TLFollow");
        if (!ecJ()) {
          break label824;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).Su("TLFollow");
        if (localObject2 == null) {
          break label824;
        }
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, "FinderEntrance", false);
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a((com.tencent.mm.plugin.finder.extension.reddot.p)localObject2, "Discovery", false);
        break label824;
        if (ecJ()) {
          break label824;
        }
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).hH("finder_tl_hot_tab", "onRefreshEnd");
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL("finder_tl_hot_tab");
        break label824;
        bool = false;
        break label862;
        label1386:
        localObject1 = ((aw.b)localObject1).getRecyclerView();
        break label1088;
        label1398:
        localObject1 = ((FinderTimelineFeedLoader)localObject1).getDataListJustForAdapter();
        if (localObject1 == null)
        {
          localObject1 = null;
          break label1109;
        }
        localObject1 = (cc)kotlin.a.p.ae((List)localObject1, 0);
        break label1109;
        label1433:
        localObject1 = ((FinderTimelineFeedLoader)localObject1).getDataListJustForAdapter();
        if (localObject1 != null) {
          break label1451;
        }
      }
      label1451:
      localObject1 = (List)localObject1;
      if (i >= 0) {
        i += 2;
      }
      for (;;)
      {
        localObject1 = (cc)kotlin.a.p.ae((List)localObject1, i);
        break;
        i = 1;
      }
      label1485:
      localObject1 = (FinderTimelineFeedLoader.d)localObject1;
      bwk localbwk = ((FinderTimelineFeedLoader.d)localObject1).Bjn;
      localObject1 = ((FinderTimelineFeedLoader.d)localObject1).getRequest();
      label1529:
      long l;
      if ((localObject1 instanceof FinderTimelineFeedLoader.c))
      {
        localObject2 = (FinderTimelineFeedLoader.c)localObject1;
        if (localObject2 != null) {
          break label1850;
        }
        localObject1 = null;
        if (localObject2 != null) {
          break label1881;
        }
        localObject2 = null;
        label1537:
        String str = this.TAG;
        localObject2 = new StringBuilder("[onRefreshEnd] tabType=").append(this.hJx).append(" requestId=").append(localObject2).append(" from_tab_type=").append(localObject1).append(" tipsShowInfo={show_reddot=");
        if (localbwk != null) {
          break label1894;
        }
        localObject1 = null;
        label1598:
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", tab_tips_object_id=");
        if (localbwk != null) {
          break label1907;
        }
        l = 0L;
        label1621:
        localObject2 = ((StringBuilder)localObject1).append(com.tencent.mm.ae.d.hF(l)).append(", show_seconds=");
        if (localbwk != null) {
          break label1917;
        }
        localObject1 = null;
        label1647:
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(", show_type=");
        if (localbwk != null) {
          break label1930;
        }
        i = -1;
        label1669:
        Log.i(str, i + '}');
        if ((localbwk == null) || (localbwk.aaft == 0)) {
          break label1956;
        }
        this.Bas.ECT.Bjn = localbwk;
        this.Bas.ECT.state = 1;
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)localFinderHomeTabFragment).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fnb();
        label1749:
        i = paramd.actionType;
        localObject1 = RefreshLoadMoreLayout.d.agJr;
        if ((i == RefreshLoadMoreLayout.d.jMH()) && (paramd.agJv <= 0)) {
          break label1996;
        }
      }
      label1850:
      label1996:
      for (i = 1;; i = -1)
      {
        this.Bav = i;
        if ((this.lzt.getIntent().getIntExtra("KEY_PUSH_RETURN_TO", 0) > 0) && (paramd.agJs == -1))
        {
          this.lzt.getIntent().putExtra("KEY_PUSH_FAIL_RETURN_READY", true);
          this.lzt.finish();
          Log.i(this.TAG, "finish for app push");
        }
        AppMethodBeat.o(165900);
        return;
        localObject2 = null;
        break;
        localObject1 = ((FinderTimelineFeedLoader.c)localObject2).Bjm;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label1529;
        }
        localObject1 = Integer.valueOf(((bwj)localObject1).aafs);
        break label1529;
        label1881:
        localObject2 = Long.valueOf(((FinderTimelineFeedLoader.c)localObject2).Bjl);
        break label1537;
        label1894:
        localObject1 = Integer.valueOf(localbwk.aaft);
        break label1598;
        label1907:
        l = localbwk.ZNj;
        break label1621;
        label1917:
        localObject1 = Integer.valueOf(localbwk.aafv);
        break label1647;
        localObject2 = localbwk.aafu;
        if (localObject2 == null)
        {
          i = -1;
          break label1669;
        }
        i = ((bxq)localObject2).show_type;
        break label1669;
        this.Bas.ECT.state = -100;
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)localFinderHomeTabFragment).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fnb();
        break label1749;
      }
      label1930:
      label1956:
      label2001:
      i = -1;
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(178274);
    com.tencent.mm.plugin.finder.report.s locals = com.tencent.mm.plugin.finder.report.s.Fqv;
    com.tencent.mm.plugin.finder.report.s.eMO();
    AppMethodBeat.o(178274);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(165911);
    ecA();
    Object localObject = com.tencent.mm.plugin.finder.utils.ac.Ghd;
    localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
    int i;
    if (com.tencent.mm.plugin.finder.utils.av.ffR())
    {
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adac, 0) != 1) {
        break label455;
      }
      i = 1;
      if ((i == 0) && (com.tencent.mm.plugin.finder.utils.ac.ffa()) && (!com.tencent.mm.plugin.finder.utils.ac.ffe()))
      {
        localObject = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
        btw localbtw = new btw();
        localbtw.ZYN = String.valueOf(com.tencent.mm.model.cn.bDw());
        localbtw.priority = 50000;
        localbtw.type = 1000;
        bxq localbxq = new bxq();
        localbxq.show_type = 1;
        localbxq.aagq = 1;
        localbxq.path = "FinderPosterEntrance";
        localbtw.aabA.add(localbxq);
        localbxq = new bxq();
        localbxq.show_type = 1;
        localbxq.aagq = 1;
        localbxq.path = "OriginalEntrance";
        localbtw.aabA.add(localbxq);
        com.tencent.mm.plugin.finder.extension.reddot.i.a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject, localbtw, "checkInsertOriginalRedDot", null, true, null, null, 0L, 116);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adac, Integer.valueOf(1));
        Log.i(com.tencent.mm.plugin.finder.utils.ac.TAG, "insertOriginalRedDot");
      }
    }
    boolean bool1;
    if (this.hJx == 3)
    {
      long l = this.lzt.getIntent().getLongExtra("key_finder_post_local_id", -1L);
      if ((!this.lzt.getIntent().getBooleanExtra("key_form_sns", false)) && (!this.lzt.getIntent().getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false))) {
        break label460;
      }
      bool1 = true;
      label296:
      boolean bool2 = this.lzt.getIntent().getBooleanExtra("KEY_FROM_SDK_SHARE", false);
      if ((l != -1L) && ((bool1) || (bool2))) {
        this.AZs.onPostStart(l, bool1);
      }
      this.lzt.getIntent().removeExtra("key_finder_post_local_id");
      localObject = Boolean.valueOf(this.lzt.getIntent().getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false));
      if ((!((Boolean)localObject).booleanValue()) || (!this.Bak)) {
        break label466;
      }
      i = 1;
      label389:
      if (i == 0) {
        break label471;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Boolean)localObject).booleanValue();
        checkEmptyHeader(null);
      }
      localObject = this.AZO;
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).getRecyclerView();
        if (localObject != null) {
          ((RecyclerView)localObject).post(new bg..ExternalSyntheticLambda18(this));
        }
      }
      AppMethodBeat.o(165911);
      return;
      label455:
      i = 0;
      break;
      label460:
      bool1 = false;
      break label296;
      label466:
      i = 0;
      break label389;
      label471:
      localObject = null;
    }
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(363728);
    Object localObject2 = ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm();
    Object localObject1 = this.AZO;
    label76:
    int i;
    label148:
    label192:
    label218:
    int j;
    label258:
    label269:
    label281:
    label319:
    com.tencent.mm.plugin.finder.extension.reddot.p localp;
    label411:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      ((com.tencent.mm.plugin.finder.live.report.q)localObject2).Dqx = new WeakReference(localObject1);
      if (this.hJx == 1)
      {
        localObject2 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
        localObject1 = this.AZO;
        if (localObject1 != null) {
          break label703;
        }
        localObject1 = null;
        ((ce)localObject2).b((RecyclerView)localObject1, q.w.DwQ, q.n.DtA.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
      }
      localObject1 = ax.AZe;
      i = this.hJx;
      localObject1 = this.AZj;
      localObject2 = this.AZs;
      kotlin.g.b.s.u(localObject1, "tlCache");
      if (((com.tencent.mm.plugin.finder.viewmodel.d)localObject1).Rp(i))
      {
        if (!ax.NG(i)) {
          break label713;
        }
        if (localObject2 != null) {
          ((FinderTimelineFeedLoader)localObject2).edW();
        }
      }
      ecA();
      if (this.hJx == 4)
      {
        localObject1 = this.AZg;
        if (localObject1 == null) {
          break label740;
        }
        localObject1 = ((FinderHomeTabFragment)localObject1).EHy;
        if ((localObject1 == null) || (((Bundle)localObject1).getInt("RequestScene", -1) != 1)) {
          break label740;
        }
        i = 1;
        if (i != 0)
        {
          this.AZs.requestInit(true);
          localObject1 = this.AZg.EHy;
          if (localObject1 != null) {
            break label745;
          }
          i = -1;
          Log.i(this.TAG, "[onUserVisibleFocused] requestInit after scroll to position[" + i + ']');
          localObject1 = ecQ();
          if (localObject1 != null) {
            break label757;
          }
          j = 0;
          localObject1 = this.AZO;
          if (localObject1 != null) {
            break label768;
          }
          localObject1 = null;
          if (!(localObject1 instanceof LinearLayoutManager)) {
            break label792;
          }
          localObject1 = (LinearLayoutManager)localObject1;
          if (localObject1 != null) {
            ((LinearLayoutManager)localObject1).bo(j + i, 0);
          }
          localObject1 = this.AZg.EHy;
          if ((localObject1 == null) || (((Bundle)localObject1).getBoolean("RequestLoadMore", false) != true)) {
            break label797;
          }
          i = 1;
          if (i != 0) {
            ecR();
          }
        }
      }
      if ((this.hJx == 3) && (this.AZs.Bjc))
      {
        Log.i(this.TAG, "postFeedFlag true");
        localObject1 = this.lzt.getIntent();
        if (localObject1 != null) {
          ((Intent)localObject1).putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", true);
        }
        this.AZs.Bjc = false;
      }
      localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLWxBubble");
      if (localp != null) {
        break label802;
      }
      localObject1 = null;
      if ((1 == this.hJx) && (localp != null) && (localObject1 != null))
      {
        localObject2 = ar.Giw;
        localObject3 = ar.a((Context)this.lzt, this.msgNotifyData.ECm, this.msgNotifyData.likeCount, this.msgNotifyData.commentCount, this.msgNotifyData.count);
        com.tencent.mm.plugin.finder.report.w localw = com.tencent.mm.plugin.finder.report.w.FrV;
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject2 = as.a.hu((Context)this.lzt);
        if (localObject2 != null) {
          break label814;
        }
        localObject2 = null;
        label503:
        com.tencent.mm.plugin.finder.report.w.a(localw, "7", localp, (bxq)localObject1, 1, (bui)localObject2, this.msgNotifyData.count, (String)localObject3, this.hJx, 256);
        localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
        i = ((bxq)localObject1).show_type;
        j = this.msgNotifyData.count;
        localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject1 = as.a.hu((Context)this.lzt);
        if (localObject1 != null) {
          break label824;
        }
        localObject1 = null;
        label572:
        com.tencent.mm.plugin.finder.report.z.a("7", 5, 1, i, 0, j, null, null, 0L, (bui)localObject1, 0, 0, 3520);
      }
      localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su("TLWxPrivateMsgBubble");
      if (localp != null) {
        break label832;
      }
      localObject1 = null;
      label619:
      if ((1 == this.hJx) && (localp != null) && (localObject1 != null))
      {
        localObject3 = com.tencent.mm.plugin.finder.report.w.FrV;
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject2 = as.a.hu((Context)this.lzt);
        if (localObject2 != null) {
          break label844;
        }
      }
    }
    label703:
    label713:
    label844:
    for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject2).fou())
    {
      com.tencent.mm.plugin.finder.report.w.a((com.tencent.mm.plugin.finder.report.w)localObject3, "7", localp, (bxq)localObject1, 1, (bui)localObject2, 0, null, 0, 480);
      AppMethodBeat.o(363728);
      return;
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      break;
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      break label76;
      if ((!ax.NH(i)) || (!ax.NI(i)) || (localObject2 == null)) {
        break label148;
      }
      ((FinderTimelineFeedLoader)localObject2).edW();
      break label148;
      label740:
      i = 0;
      break label192;
      label745:
      i = ((Bundle)localObject1).getInt("ScrollPosition", -1);
      break label218;
      label757:
      j = ((com.tencent.mm.view.recyclerview.i)localObject1).agOb.size();
      break label258;
      localObject1 = ((aw.b)localObject1).getRecyclerView();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label269;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      break label269;
      localObject1 = null;
      break label281;
      i = 0;
      break label319;
      localObject1 = localp.avK("TLWxBubble");
      break label411;
      localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject2).fou();
      break label503;
      localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou();
      break label572;
      localObject1 = localp.avK("TLWxPrivateMsgBubble");
      break label619;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(363744);
    switch (this.hJx)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(363744);
      return;
      Object localObject2 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
      Object localObject1 = this.AZO;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((aw.b)localObject1).getRecyclerView())
      {
        ((ce)localObject2).b((RecyclerView)localObject1, q.w.DwQ, q.n.DtA.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
        AppMethodBeat.o(363744);
        return;
      }
      localObject1 = this.AZg;
      if (localObject1 != null)
      {
        this.Bas.ECT.state = -1;
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.viewmodel.component.e)com.tencent.mm.ui.component.k.y((Fragment)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.e.class)).fnb();
      }
    }
  }
  
  public final void pY(boolean paramBoolean)
  {
    AppMethodBeat.i(363735);
    Log.i(this.TAG, kotlin.g.b.s.X("setCanAutoPreloadMore: canAutoPreloadMore = ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      this.Bav = i;
      AppMethodBeat.o(363735);
      return;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(165905);
    final List localList = (List)new ArrayList();
    Object localObject2;
    BaseFinderFeed localBaseFinderFeed;
    long l;
    if ((this.hJx == 3) || (this.hJx == 1))
    {
      localObject1 = this.AZs.getListOfType(BaseFinderFeed.class);
      localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject2 = com.tencent.mm.plugin.finder.utils.av.a(this.AZs.getDataList().getBuffer(), BaseFinderFeed.class);
      Log.i(this.TAG, "[requestRefresh] tabType=" + this.hJx + ", dataList=" + ((List)localObject1).size() + " buffer=" + ((List)localObject2).size());
      ((List)localObject1).addAll((Collection)localObject2);
      localObject2 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localList.addAll((Collection)com.tencent.mm.plugin.finder.utils.av.M((List)localObject1, this.hJx));
      localObject1 = ((Iterable)kotlin.a.p.m((Iterable)localList)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseFinderFeed)((Iterator)localObject1).next();
        this.AZs.remove(((BaseFinderFeed)localObject2).feedObject.field_id, true);
      }
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("[requestRefresh] tabType=").append(this.hJx).append(", unreadList=").append(localList.size()).append(" first=");
      localBaseFinderFeed = (BaseFinderFeed)kotlin.a.p.oN(localList);
      if (localBaseFinderFeed == null)
      {
        l = 0L;
        Log.i((String)localObject1, com.tencent.mm.ae.d.hF(l) + " isFirstLoad=" + this.AZs.Bja);
      }
    }
    else if ((this.hJx == 4) && (this.lzt.getIntent().getIntExtra("KEY_SOURCE_TYPE", 0) == 2) && (this.AZs.Bja == 0))
    {
      localObject1 = this.AZO;
      if (localObject1 != null) {
        break label587;
      }
    }
    label587:
    for (Object localObject1 = null;; localObject1 = ((aw.b)localObject1).getRecyclerView())
    {
      if (localObject1 != null) {
        ((RecyclerView)localObject1).setLayoutFrozen(true);
      }
      localObject1 = com.tencent.mm.plugin.finder.report.o.FpJ;
      localObject1 = (Context)this.lzt;
      int i = this.hJx;
      int j = getItemCount();
      int k = dYO();
      kotlin.g.b.s.u(localObject1, "context");
      if (!com.tencent.mm.plugin.finder.report.o.cng())
      {
        Log.i("Finder.HomeActionReporter", "[onRefreshStart] tabType:" + i + " itemCount:" + j + " curPosition:" + k);
        com.tencent.mm.plugin.finder.report.o.hJx = i;
        com.tencent.mm.plugin.finder.report.o.c(i, j, true, k);
        com.tencent.mm.plugin.finder.report.o.id(i, 5);
        com.tencent.mm.plugin.finder.report.o.a((Context)localObject1, i, new kotlin.r(Integer.valueOf(5), Integer.valueOf(0)));
      }
      if (this.AZs.Bja == 0)
      {
        localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
        localObject2 = com.tencent.mm.plugin.finder.extension.reddot.i.Nu(this.hJx);
        ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).DIg.add(localObject2);
      }
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new ad(this, localList));
      AppMethodBeat.o(165905);
      return;
      l = localBaseFinderFeed.bZA();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$Companion;", "", "()V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "getMENU_ID_CANCEL_FAV_TO_FINDER", "()I", "MENU_ID_CLOSE_COMMENT", "getMENU_ID_CLOSE_COMMENT", "MENU_ID_CREATION_BY_SAME_TEMPLATE", "getMENU_ID_CREATION_BY_SAME_TEMPLATE", "MENU_ID_DELETE", "getMENU_ID_DELETE", "MENU_ID_EXPOSE", "getMENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "getMENU_ID_FAV_TO_FINDER", "MENU_ID_FLOAT_MINI_VIEW", "getMENU_ID_FLOAT_MINI_VIEW", "MENU_ID_FOLLOW_PAT", "getMENU_ID_FOLLOW_PAT", "MENU_ID_INNER_FEEDBACK", "getMENU_ID_INNER_FEEDBACK", "MENU_ID_OPEN_COMMENT", "getMENU_ID_OPEN_COMMENT", "MENU_ID_OPEN_IN_FULL_WINDOW", "getMENU_ID_OPEN_IN_FULL_WINDOW", "MENU_ID_POST_SAME_STYLE", "getMENU_ID_POST_SAME_STYLE", "MENU_ID_REPRINT", "getMENU_ID_REPRINT", "MENU_ID_SHARE_RINGTONE", "getMENU_ID_SHARE_RINGTONE", "MENU_ID_SHARE_TEXT_STATUS", "getMENU_ID_SHARE_TEXT_STATUS", "MENU_ID_SHARE_TO_CHAT", "getMENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "getMENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "getMENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SPEED_CTRL", "getMENU_ID_SPEED_CTRL", "MENU_ID_SPLIT_SCREEN", "getMENU_ID_SPLIT_SCREEN", "MENU_ID_UNFOLLOW", "getMENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "getMENU_ID_UNINTEREST", "hasMoreCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "getHasMoreCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHasMoreCache", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$preloadCallback$1", "Lcom/tencent/mm/plugin/finder/preload/FinderSharePreloadCore$PreloadCallback;", "loadFinish", "", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "errorCode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class aa
    implements c.b
  {
    aa(bg parambg) {}
    
    public final void c(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(363498);
      if (paramFinderItem != null)
      {
        bg localbg = this.BaB;
        Object localObject;
        if (paramFinderItem.getFinderObject().place_holder_info == null)
        {
          localObject = bg.g(localbg);
          if (localObject != null) {
            ((aw.b)localObject).pZ(false);
          }
        }
        if (localbg.AZs.getDataList().size() == 0)
        {
          Log.i(bg.f(localbg), kotlin.g.b.s.X("preloadCallback data list size = 0 feedId=", Long.valueOf(paramFinderItem.getId())));
          localObject = localbg.AZs.getDataList();
          com.tencent.mm.plugin.finder.storage.logic.d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          ((DataBuffer)localObject).add(com.tencent.mm.plugin.finder.storage.logic.d.a.a(paramFinderItem));
          paramFinderItem = bg.g(localbg);
          if (paramFinderItem != null)
          {
            paramFinderItem = paramFinderItem.getRecyclerView();
            if (paramFinderItem != null)
            {
              paramFinderItem = paramFinderItem.getAdapter();
              if (paramFinderItem != null) {
                paramFinderItem.bZE.notifyChanged();
              }
            }
          }
        }
      }
      AppMethodBeat.o(363498);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ab(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    ac(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    ad(bg parambg, List<BaseFinderFeed> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ae
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    ae(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class af
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    af(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ag
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    ag(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTabStreamUnreadVM;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.viewmodel.h>
  {
    public static final ah BaM;
    
    static
    {
      AppMethodBeat.i(363409);
      BaM = new ah();
      AppMethodBeat.o(363409);
    }
    
    ah()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ai
    extends kotlin.g.b.u
    implements kotlin.g.a.a<FinderWhatsNewView>
  {
    ai(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.g
  {
    b(bg parambg) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(165865);
      Object localObject2;
      switch (paramInt)
      {
      default: 
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        com.tencent.mm.plugin.finder.utils.av.eY(bg.f(this.BaB), paramInt);
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(165865);
        return localObject1;
      case -7: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.aa(bg.j(this.BaB));
        AppMethodBeat.o(165865);
        return localObject1;
      case -1: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.n((kotlin.g.a.a)new a(this.BaB), null, 6);
        AppMethodBeat.o(165865);
        return localObject1;
      case -4: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.k();
        AppMethodBeat.o(165865);
        return localObject1;
      case -5: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.z();
        AppMethodBeat.o(165865);
        return localObject1;
      case -6: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.by();
        AppMethodBeat.o(165865);
        return localObject1;
      case 2019: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.s(this.BaB);
        AppMethodBeat.o(165865);
        return localObject1;
      case -3: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new ae();
        AppMethodBeat.o(165865);
        return localObject1;
      case 9: 
        localObject1 = bg.l(this.BaB);
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        localObject2 = as.a.hu((Context)bg.k(this.BaB));
        if (localObject2 == null) {}
        for (paramInt = 0;; paramInt = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject2).AJo)
        {
          int i = bg.j(this.BaB);
          localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.r((com.tencent.mm.plugin.finder.video.l)localObject1, (i)this.BaB, i, paramInt, 4);
          AppMethodBeat.o(165865);
          return localObject1;
        }
      case 4: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.t(bg.l(this.BaB), (i)this.BaB, false, bg.j(this.BaB), 4);
        AppMethodBeat.o(165865);
        return localObject1;
      case 2: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.q((i)this.BaB, false, bg.j(this.BaB), 2);
        AppMethodBeat.o(165865);
        return localObject1;
      case 2017: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.p((aw.a)this.BaB);
        AppMethodBeat.o(165865);
        return localObject1;
      case 3001: 
        if (bg.j(this.BaB) == 1)
        {
          localObject1 = (com.tencent.mm.view.recyclerview.f)new ao();
          AppMethodBeat.o(165865);
          return localObject1;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.q((i)this.BaB, false, bg.j(this.BaB), 2);
        AppMethodBeat.o(165865);
        return localObject1;
      case 3002: 
        if (bg.j(this.BaB) == 1)
        {
          localObject1 = (com.tencent.mm.view.recyclerview.f)new ao();
          AppMethodBeat.o(165865);
          return localObject1;
        }
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.t(bg.l(this.BaB), (i)this.BaB, false, bg.j(this.BaB), 4);
        AppMethodBeat.o(165865);
        return localObject1;
      case 2011: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.al(bg.j(this.BaB));
        AppMethodBeat.o(165865);
        return localObject1;
      case 2013: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new cq(this.BaB, bg.j(this.BaB));
        AppMethodBeat.o(165865);
        return localObject1;
      case 2010: 
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.view.recyclerview.f)new cs(((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)bg.k(this.BaB)).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), bg.j(this.BaB));
        AppMethodBeat.o(165865);
        return localObject1;
      case 2002: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.bb();
        AppMethodBeat.o(165865);
        return localObject1;
      case 2003: 
        localObject1 = (i)this.BaB;
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.w((i)localObject1, ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)bg.k(this.BaB)).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), bg.j(this.BaB));
        AppMethodBeat.o(165865);
        return localObject1;
      case 2012: 
        localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.an();
        AppMethodBeat.o(165865);
        return localObject1;
      }
      Object localObject1 = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.ab((kotlin.g.a.b)new b(this.BaB), (i)this.BaB, bg.j(this.BaB));
      AppMethodBeat.o(165865);
      return localObject1;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(bg parambg)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.b<Integer, ah>
    {
      b(bg parambg)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    c(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    d(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    e(RefreshLoadMoreLayout.d<Object> paramd, bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(WxRecyclerAdapter<?> paramWxRecyclerAdapter, bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.i>
  {
    g(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedLoader$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    h(bg parambg, FinderTimelineFeedLoader paramFinderTimelineFeedLoader) {}
    
    public final void call(int paramInt)
    {
      String str = null;
      paramInt = 1;
      AppMethodBeat.i(363925);
      Object localObject1 = bg.n(this.BaB);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((FinderHomeTabFragment)localObject1).EHy;
        if ((localObject1 != null) && (((Bundle)localObject1).getInt("RequestScene", -1) == 1))
        {
          if (paramInt == 0) {
            break label129;
          }
          Log.i(paramMMActivity.getTAG(), "IInitDone come from hot card.");
          localObject1 = bg.l(this.BaB).GpZ;
          if (localObject1 != null)
          {
            localObject2 = bg.n(this.BaB);
            if (localObject2 != null) {
              break label108;
            }
          }
        }
      }
      for (;;)
      {
        FinderVideoAutoPlayManager.a((FinderVideoAutoPlayManager)localObject1, kotlin.g.b.s.X(str, "#onAttach"), false);
        AppMethodBeat.o(363925);
        return;
        paramInt = 0;
        break;
        label108:
        localObject2 = localObject2.getClass();
        if (localObject2 != null) {
          str = ((Class)localObject2).getSimpleName();
        }
      }
      label129:
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.BaB, paramMMActivity));
      AppMethodBeat.o(363925);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(bg parambg, FinderTimelineFeedLoader paramFinderTimelineFeedLoader)
      {
        super();
      }
      
      private static final void a(LinearLayoutManager paramLinearLayoutManager, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(363946);
        kotlin.g.b.s.u(paramLinearLayoutManager, "$layoutManager");
        paramLinearLayoutManager.bo(paramInt1, paramInt2);
        AppMethodBeat.o(363946);
      }
      
      private static final void a(RecyclerView paramRecyclerView, int paramInt, bg parambg)
      {
        AppMethodBeat.i(363961);
        kotlin.g.b.s.u(paramRecyclerView, "$it");
        kotlin.g.b.s.u(parambg, "this$0");
        Object localObject1 = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedLoader$2$1$call$1", "invoke$lambda-4$lambda-3", "(Landroidx/recyclerview/widget/RecyclerView;ILcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;)V", "Undefined", "scrollToPosition", "(I)V");
        paramRecyclerView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$feedLoader$2$1$call$1", "invoke$lambda-4$lambda-3", "(Landroidx/recyclerview/widget/RecyclerView;ILcom/tencent/mm/plugin/finder/feed/FinderTimelinePresenter;)V", "Undefined", "scrollToPosition", "(I)V");
        paramRecyclerView = com.tencent.mm.plugin.finder.convert.cn.AMo;
        Object localObject2 = (Context)bg.k(parambg);
        paramInt = bg.j(parambg);
        kotlin.g.b.s.u(localObject2, "context");
        switch (paramInt)
        {
        case 2: 
        default: 
          paramRecyclerView = "";
          localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager();
          parambg = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.nq((Context)localObject2).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
          parambg = ((bui)localObject2).zIO;
          if (parambg == null) {
            parambg = "";
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.plugin.finder.extension.reddot.p localp = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).Su(paramRecyclerView);
          bxq localbxq = ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).avp(paramRecyclerView);
          if ((localp != null) && (localbxq != null))
          {
            com.tencent.mm.plugin.finder.report.w localw = com.tencent.mm.plugin.finder.report.w.FrV;
            com.tencent.mm.plugin.finder.report.w.a("2", localp, localbxq, 2, (bui)localObject2, 1, paramInt, null, 0, 3, null, 0, 3456);
          }
          com.tencent.mm.plugin.finder.convert.cn.a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, paramRecyclerView, parambg);
          ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL(paramRecyclerView);
          com.tencent.mm.plugin.finder.convert.cn.a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, "FinderEntrance", parambg);
          ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).TL("FinderEntrance");
          com.tencent.mm.plugin.finder.convert.cn.a((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1, "Discovery", parambg);
          ((com.tencent.mm.plugin.finder.extension.reddot.i)localObject1).a("Discovery", (kotlin.g.a.b)cn.a.AMp, true);
          paramRecyclerView = com.tencent.mm.plugin.finder.convert.cn.AMo;
          com.tencent.mm.plugin.finder.convert.cn.clear();
          AppMethodBeat.o(363961);
          return;
          paramRecyclerView = "TLRecommendTab";
          break;
          paramRecyclerView = "TLFollow";
          break;
          paramRecyclerView = "finder_tl_hot_tab";
          break;
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<ah>
      {
        a(FinderHomeTabFragment paramFinderHomeTabFragment, bg parambg)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.a.as>
  {
    i(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Triple;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.b<kotlin.u<? extends String, ? extends String, ? extends String>, ah>
  {
    j(com.tencent.mm.ui.base.s params, BaseFinderFeed paramBaseFinderFeed, bg parambg, com.tencent.mm.ui.widget.a.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$getMoreMenuItemSelectedListener$1$10", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements ck<bpu>
  {
    k(bg parambg) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    l(FinderFullSeekBarLayout paramFinderFullSeekBarLayout, bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    m(bg parambg, MenuItem paramMenuItem, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "subType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, List<? extends Long>>
  {
    n(bg parambg, BaseFinderFeed paramBaseFinderFeed, List<BaseFinderFeed> paramList, int paramInt)
    {
      super();
    }
    
    private List<Long> NJ(int paramInt)
    {
      AppMethodBeat.i(363949);
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = new LinkedList();
      ??? = paramMenuItem;
      Object localObject4 = paramBaseFinderFeed;
      for (;;)
      {
        int i;
        synchronized ((Iterable)???)
        {
          Iterator localIterator = ((Iterable)???).iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            Object localObject5 = localIterator.next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            localObject5 = (BaseFinderFeed)localObject5;
            if ((!(localObject5 instanceof BaseFinderFeed)) || (((BaseFinderFeed)localObject5).feedObject.getId() != ((BaseFinderFeed)localObject4).feedObject.getId())) {
              break label360;
            }
            ((LinkedList)localObject2).add(0, new kotlin.r(Integer.valueOf(i), localObject5));
            break label360;
          }
          localObject4 = ah.aiuX;
          ??? = (Iterable)localObject2;
          localObject2 = this.BaB;
          i = paramInt;
          ??? = ((Iterable)???).iterator();
          if (((Iterator)???).hasNext())
          {
            localObject4 = (kotlin.r)((Iterator)???).next();
            Log.i(bg.f((bg)localObject2), "[not interested] removeAt " + i + " subType=" + paramInt + ' ' + ((BaseFinderFeed)((kotlin.r)localObject4).bsD).feedObject);
            ((bg)localObject2).AZs.getDataListJustForAdapter().remove(((kotlin.r)localObject4).bsD);
            localLinkedList.add(Long.valueOf(((BaseFinderFeed)((kotlin.r)localObject4).bsD).feedObject.getCreateTime()));
            bg.r((bg)localObject2).onItemRangeRemoved(((Number)((kotlin.r)localObject4).bsC).intValue(), 1);
          }
        }
        Log.i(bg.f(this.BaB), kotlin.g.b.s.X("[not interested] feed ", paramBaseFinderFeed));
        bg.a(this.BaB);
        List localList = (List)localObject1;
        AppMethodBeat.o(363949);
        return localList;
        label360:
        i += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$getMoreMenuItemSelectedListener$1$4$3", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements com.tencent.mm.am.h
  {
    o(bt parambt, bg parambg) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(363928);
      if (((paramp instanceof bt)) && (((bt)paramp).hKN == this.AVi.hKN)) {
        com.tencent.mm.kernel.h.aZW().b(this.AVi.getType(), (com.tencent.mm.am.h)this);
      }
      paramString = bg.q(parambg);
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        com.tencent.mm.ui.base.aa.makeText((Context)bg.k(parambg), e.h.finder_profile_del_feed_failed, 0).show();
      }
      AppMethodBeat.o(363928);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$getMoreMenuItemSelectedListener$1$9", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements ck<bpu>
  {
    p(bg parambg) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    q(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    r(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    s(bg parambg, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    t(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Long>
  {
    u(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements l.b
  {
    v(aw.b paramb, bg parambg) {}
    
    public final RecyclerView ebB()
    {
      AppMethodBeat.i(364105);
      RecyclerView localRecyclerView = this.BaG.getRecyclerView();
      AppMethodBeat.o(364105);
      return localRecyclerView;
    }
    
    public final boolean ebC()
    {
      return true;
    }
    
    public final boolean ebD()
    {
      return true;
    }
    
    public final DataBuffer<cc> ebE()
    {
      AppMethodBeat.i(364116);
      DataBuffer localDataBuffer = this.BaB.AZs.getDataListJustForAdapter();
      AppMethodBeat.o(364116);
      return localDataBuffer;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "visiblePosition", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, cc>
  {
    w(aw.b paramb, bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.m<Integer, Integer, LinkedList<cc>>
  {
    x(bg parambg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    public static final y EGR;
    
    static
    {
      AppMethodBeat.i(370855);
      EGR = new y();
      AppMethodBeat.o(370855);
    }
    
    y()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    z(bg parambg, RefreshLoadMoreLayout.d<Object> paramd)
    {
      super();
    }
    
    private static final void c(bg parambg, RefreshLoadMoreLayout.d paramd)
    {
      AppMethodBeat.i(370853);
      kotlin.g.b.s.u(parambg, "this$0");
      kotlin.g.b.s.u(paramd, "$reason");
      Object localObject = bg.g(parambg);
      if (localObject != null)
      {
        localObject = ((aw.b)localObject).aNL();
        if (localObject != null) {
          RefreshLoadMoreLayout.c((RefreshLoadMoreLayout)localObject);
        }
      }
      parambg.onRefreshEnd(paramd);
      AppMethodBeat.o(370853);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bg
 * JD-Core Version:    0.7.0.1
 */