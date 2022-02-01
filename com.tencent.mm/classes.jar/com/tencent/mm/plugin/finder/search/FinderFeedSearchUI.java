package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.cgi.dw;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.feed.i.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ak;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.search.data.SearchHotWordListParcelable;
import com.tencent.mm.plugin.finder.search.data.SearchHotWordParcelable;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.ui.MMFinderFeedDetailUI;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderExposeChangedEventListener;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.finder.viewmodel.component.x;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderFeedDetailUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FLOAT_MINI_VIEW", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_POST_SAME_STYLE", "MENU_ID_REPRINT", "MENU_ID_SHARE_RINGTONE", "MENU_ID_SHARE_TEXT_STATUS", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SPEED_CTRL", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "SCROLL_TIPS_DISMISS_MS", "", "audioHelperTool", "Lcom/tencent/mm/model/AudioHelperTool;", "kotlin.jvm.PlatformType", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "continueFlag", "curEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "currentHitWording", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$feedExposeInfoChangeListener$1;", "feedList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "forwardDirection", "", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "getHotWordListScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneGetHotWordList;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "hotEventInfoMap", "hotPosWordingMap", "hotSearchContainer", "Landroid/view/View;", "hotSearchInfoDialog", "Lcom/tencent/mm/plugin/finder/search/FinderHotSearchInfoDialog;", "hotSearchTitleContainer", "hotSearchTitleIcon", "hotSearchTitleView", "Landroid/widget/TextView;", "hotSearchType", "hotSession", "Lcom/tencent/mm/protobuf/ByteString;", "ignoreIds", "Ljava/util/HashSet;", "initPosition", "isFirstCreate", "isFromHotSearch", "isLoadingSearchList", "isPreloadingNextHotPage", "isPreloadingNextHotWord", "isWaitingForSearchList", "lastBuff", "loadingView", "mOnScrollListener", "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1;", "mediaBannerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "objHotInfoBuffer", "offset", "pendSearchHotRunnable", "Ljava/lang/Runnable;", "preloadNetSceneFinderSearch", "query", "quickMenuHelper", "Lcom/tencent/mm/pluginsdk/IRecentForwardMenuHelper;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "reportDataMap", "Landroid/util/ArrayMap;", "Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$ReportData;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "scrollHotWordTipsView", "scrollTipsDismissRunnable", "searchHotWordListParcelable", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "searchListContinueFlag", "searchListLastBuff", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchType", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "addExposeItem", "", "id", "position", "feedId", "type", "addFinderObject", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "addHotWordTipsOnInsertHotList", "insertHotWords", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "addReportData", "hotWordId", "addScrollTips", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedSearchHotScrollTipsData;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkFocusItemChange", "newState", "dy", "checkForwardDirection", "dx", "dismissFooter", "dismissHotWordTipsView", "fixActionBarStatus", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "getCommentScene", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "from", "getCreateQuickMoreMenuListener", "getCreateSecondMoreMenuListener", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getHotSearchList", "hotWord", "isPreload", "getLayoutId", "getMediaBannerRecyclerViewPool", "getMoreMenuItemLongSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemLongSelectedListener;", "bottomSheet", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getQueryOnReport", "getReportType", "getRequestIdOnReport", "getSearchHotScrollTipsWording", "getVideoCore", "goBack", "handleIntent", "handleItemChange", "prePos", "curPos", "curView", "handleSearchScrollTipsView", "view", "nextPos", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initContentView", "initData", "initHotSearchTitle", "initSearchView", "initSuggestion", "initVideoAbout", "isBlockHotSearch", "isClosetPosition", "closetView", "isFinderSelfScene", "isHideStatusBar", "isIgnorePosition", "isIgnoreView", "isSelf", "loadJumpInfoOnInit", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickBackBtn", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "source", "onFollow", "isFollow", "onGetHotSearchList", "list", "isOnLoadMore", "onHotSearchListEmpty", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "tag", "optRequestScene", "overlayStatusBar", "parseHotWordingByPos", "recordEventInfo", "hotWords", "recordHotPosWording", "wording", "refreshHotSearchTitle", "hotWordText", "replaceEmptyTip", "curWording", "reportOnExpose", "reportSearch", "isFeedEmpty", "isHotWordSearch", "reportSearchExpose", "needClear", "setNextHotWord", "netScene", "hotWordList", "shareFeed", "shareFeedToSns", "showHotSearchTitle", "showLoadMoreFooter", "showNoMoreFooter", "showNormalSearchTitle", "showScrollHotWordTipsView", "smoothScrollToLastPosition", "smoothScrollToNextPosition", "startPreloadNextHotWord", "startSearch", "hotSessionBuffer", "isUseExistRequestId", "startSearchMore", "startSearchNextHot", "startSearchNextPage", "Companion", "FinderFeedSearchReporter", "ReportData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedSearchUI
  extends MMFinderFeedDetailUI
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.finder.feed.i, FTSEditTextView.c, FTSSearchView.b
{
  public static final a FvV;
  private boolean ADh;
  private final com.tencent.mm.plugin.finder.video.l AJn;
  private final int AST;
  private final int ASU;
  private final int ASV;
  private final int ASW;
  private final int ASX;
  private final int ASY;
  private final int ASZ;
  public FinderLikeDrawer ATA;
  private final int ATb;
  private final int ATc;
  private final int ATd;
  private final int ATf;
  private final int ATi;
  private final int ATj;
  private final int ATk;
  private final int ATn;
  private RecyclerView.m ATp;
  private com.tencent.mm.pluginsdk.q ATr;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.plugin.finder.view.f ATy;
  private final int Auf;
  private final int Aug;
  private final kotlin.j Bae;
  private final kotlin.j Baf;
  private com.tencent.mm.bx.b BgS;
  private TextView BnA;
  private j BnB;
  private l BnC;
  private dk BnD;
  private FTSSearchView Bny;
  private HashMap<String, a> FvE;
  private boolean FvW;
  private int FvX;
  private com.tencent.mm.bx.b FvY;
  private dw FvZ;
  private String FwA;
  private final HashSet<Integer> FwB;
  private DataBuffer<cc> Fwa;
  private int Fwb;
  private boolean Fwc;
  private boolean Fwd;
  private final ArrayMap<Long, FinderFeedSearchUI.c> Fwe;
  private SearchHotWordListParcelable Fwf;
  private com.tencent.mm.bx.b Fwg;
  private com.tencent.mm.bx.b Fwh;
  private View Fwi;
  private TextView Fwj;
  private View Fwk;
  private View Fwl;
  private awt Fwm;
  private b Fwn;
  private IListener<if> Fwo;
  private Runnable Fwp;
  private dk Fwq;
  private boolean Fwr;
  private final feedExposeInfoChangeListener.1 Fws;
  private final t Fwt;
  private Runnable Fwu;
  private TextView Fwv;
  private final long Fww;
  private boolean Fwx;
  private HashMap<Integer, String> Fwy;
  private HashMap<String, awt> Fwz;
  private int continueFlag;
  private String hOG;
  private MMHandler mRi;
  private RecyclerView mkw;
  private View njN;
  private final com.tencent.mm.model.d nmW;
  private int offset;
  private int pyl;
  private String query;
  private int xVf;
  
  static
  {
    AppMethodBeat.i(166770);
    FvV = new a((byte)0);
    AppMethodBeat.o(166770);
  }
  
  public FinderFeedSearchUI()
  {
    AppMethodBeat.i(166792);
    this.nmW = new com.tencent.mm.model.d();
    this.FvW = true;
    this.query = "";
    this.Fwa = new DataBuffer(null, 1, null);
    this.hOG = "";
    this.FvE = new HashMap();
    this.ATp = new RecyclerView.m();
    this.xVf = 1;
    this.AJn = new com.tencent.mm.plugin.finder.video.l();
    this.Fwe = new ArrayMap();
    this.Bae = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Baf = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.AST = 99;
    this.ASU = 100;
    this.ASV = 101;
    this.Auf = 102;
    this.Aug = 103;
    this.ASW = 104;
    this.ASX = 105;
    this.ASY = 106;
    this.ASZ = 107;
    this.ATb = 108;
    this.ATc = 110;
    this.ATd = 111;
    this.ATf = 112;
    this.ATi = 113;
    this.ATj = 114;
    this.ATk = 115;
    this.ATn = 200;
    this.Fwp = new FinderFeedSearchUI..ExternalSyntheticLambda14(this);
    this.Fws = new FinderExposeChangedEventListener()
    {
      private String tag;
      
      public final void a(long paramAnonymousLong, brh paramAnonymousbrh)
      {
        AppMethodBeat.i(166751);
        Object localObject1 = FinderFeedSearchUI.r(this.FwC);
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          localObject1 = null;
        }
        for (;;)
        {
          localObject2 = ((RecyclerView)localObject1).getAdapter();
          if (localObject2 != null) {
            break;
          }
          paramAnonymousbrh = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
          AppMethodBeat.o(166751);
          throw paramAnonymousbrh;
        }
        Object localObject2 = com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject2, paramAnonymousLong);
        if (localObject2 != null)
        {
          int i = ((RecyclerView.v)localObject2).KJ();
          localObject1 = ((RecyclerView)localObject1).getAdapter();
          if (localObject1 != null) {
            ((RecyclerView.a)localObject1).t(i, new kotlin.r(Integer.valueOf(1), paramAnonymousbrh));
          }
        }
        AppMethodBeat.o(166751);
      }
      
      public final String getTag()
      {
        return this.tag;
      }
      
      public final FinderItem np(long paramAnonymousLong)
      {
        AppMethodBeat.i(166750);
        Object localObject2 = FinderFeedSearchUI.r(this.FwC);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          localObject1 = null;
        }
        localObject2 = this.FwC;
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<@[FlexibleNullability] androidx.recyclerview.widget.RecyclerView.ViewHolder?>");
          AppMethodBeat.o(166750);
          throw ((Throwable)localObject1);
        }
        localObject1 = com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, paramAnonymousLong);
        if (localObject1 != null)
        {
          int i = ((RecyclerView.v)localObject1).KJ();
          localObject1 = (cc)FinderFeedSearchUI.s((FinderFeedSearchUI)localObject2).get(i);
          if ((localObject1 instanceof BaseFinderFeed))
          {
            localObject1 = ((BaseFinderFeed)localObject1).feedObject;
            AppMethodBeat.o(166750);
            return localObject1;
          }
        }
        AppMethodBeat.o(166750);
        return null;
      }
    };
    this.Fwt = new t(this);
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.Fww = 3000L;
    this.Fwy = new HashMap();
    this.Fwz = new HashMap();
    this.FwA = "";
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.valueOf(e.e.search_scroll_tips_root));
    ah localah = ah.aiuX;
    this.FwB = localHashSet;
    AppMethodBeat.o(166792);
  }
  
  private static void B(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(342724);
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(342724);
      throw paramRecyclerView;
    }
    int i = ((FinderLinearLayoutManager)localLayoutManager).Jw();
    Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("[smoothScrollToLastPosition] nextPosition=", Integer.valueOf(i)));
    paramRecyclerView.post(new FinderFeedSearchUI..ExternalSyntheticLambda10(paramRecyclerView, i));
    AppMethodBeat.o(342724);
  }
  
  private final String Tb(int paramInt)
  {
    AppMethodBeat.i(342743);
    Object localObject1 = null;
    Iterator localIterator = ((Map)this.Fwy).entrySet().iterator();
    int i = 2147483647;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      int k = ((Number)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      int j = Math.abs(paramInt - k);
      if ((paramInt > k) && (j < i))
      {
        i = j;
        localObject1 = localObject2;
      }
      else if ((paramInt <= 0) && (k == 0))
      {
        AppMethodBeat.o(342743);
        return localObject2;
      }
    }
    AppMethodBeat.o(342743);
    return localObject1;
  }
  
  private final boolean Tc(int paramInt)
  {
    AppMethodBeat.i(342751);
    Iterator localIterator = ((Map)this.Fwy).entrySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      i = ((Number)localEntry.getKey()).intValue();
      localEntry.getValue();
    } while (paramInt != i);
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(342751);
      return bool;
    }
  }
  
  private static void a(dk paramdk, SearchHotWordListParcelable paramSearchHotWordListParcelable)
  {
    int j = 0;
    AppMethodBeat.i(342714);
    if ((paramdk != null) && (paramSearchHotWordListParcelable != null) && (paramSearchHotWordListParcelable.FyE != null))
    {
      int k = paramSearchHotWordListParcelable.position + 1;
      int m = paramSearchHotWordListParcelable.FyE.size();
      int i = j;
      if (k >= 0)
      {
        i = j;
        if (k < m) {
          i = 1;
        }
      }
      if (i != 0) {
        paramdk.ADj = ((SearchHotWordParcelable)paramSearchHotWordListParcelable.FyE.get(k)).FyF;
      }
    }
    AppMethodBeat.o(342714);
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, FinderFeedSearchUI paramFinderFeedSearchUI, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342805);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    kotlin.g.b.s.u(paramf, "$sheet");
    int i;
    if (paramBaseFinderFeed.feedObject.isLongVideo())
    {
      i = paramFinderFeedSearchUI.ATk;
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.av.GUq;
      RecyclerView localRecyclerView = paramFinderFeedSearchUI.mkw;
      localObject1 = localRecyclerView;
      if (localRecyclerView == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = null;
      }
      params.a(i, (CharSequence)com.tencent.mm.plugin.finder.viewmodel.component.av.a.H((RecyclerView)localObject1), e.g.icons_outlined_play_control_2);
    }
    Object localObject1 = am.GhD;
    localObject1 = paramFinderFeedSearchUI.getContext();
    kotlin.g.b.s.s(localObject1, "context");
    localObject1 = (Activity)localObject1;
    kotlin.g.b.s.s(params, "menu");
    am.a((Activity)localObject1, paramBaseFinderFeed, params, paramf, paramFinderFeedSearchUI.ATn);
    paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
    boolean bool;
    if (com.tencent.mm.plugin.finder.utils.av.I(paramBaseFinderFeed.feedObject))
    {
      i = paramFinderFeedSearchUI.ATb;
      paramf = com.tencent.mm.plugin.finder.utils.av.GiL;
      paramf = (CharSequence)com.tencent.mm.plugin.finder.utils.av.r(paramBaseFinderFeed);
      int j = e.g.icons_outlined_bgm_play;
      if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed()))
      {
        bool = true;
        params.a(i, paramf, j, bool);
      }
    }
    else
    {
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed != null) {
        break label271;
      }
    }
    label271:
    for (paramBaseFinderFeed = localObject2;; paramBaseFinderFeed = paramBaseFinderFeed.field_username)
    {
      if (!kotlin.n.n.T(paramBaseFinderFeed, com.tencent.mm.model.z.bAW(), false)) {
        params.a(paramFinderFeedSearchUI.ASV, (CharSequence)paramFinderFeedSearchUI.getContext().getString(e.h.more_menu_back), e.g.icons_outlined_report_problem);
      }
      AppMethodBeat.o(342805);
      return;
      bool = false;
      break;
    }
  }
  
  private static final void a(final BaseFinderFeed paramBaseFinderFeed, FinderFeedSearchUI paramFinderFeedSearchUI, com.tencent.mm.view.recyclerview.j paramj, final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(342846);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    Log.i("Finder.FinderFeedSearchUI", "getMoreMenuItemSelectedListener feed " + paramBaseFinderFeed + ' ' + paramInt + " menuItem:" + paramMenuItem.getItemId());
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramFinderFeedSearchUI.ATj)
    {
      paramj = com.tencent.mm.ui.component.k.aeZF;
      paramj = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramFinderFeedSearchUI).q(x.class);
      kotlin.g.b.s.s(paramj, "UICProvider.of(getActivi…tMiniViewUIC::class.java)");
      paramj = (x)paramj;
      paramMenuItem = new ca(paramBaseFinderFeed.feedObject.getFeedObject());
      paramFinderFeedSearchUI = paramFinderFeedSearchUI.mkw;
      paramBaseFinderFeed = paramFinderFeedSearchUI;
      if (paramFinderFeedSearchUI == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBaseFinderFeed = null;
      }
      x.a(paramj, paramMenuItem, paramBaseFinderFeed);
      AppMethodBeat.o(342846);
      return;
    }
    if (paramInt == paramFinderFeedSearchUI.ATk)
    {
      paramMenuItem = (List)new ArrayList();
      paramBaseFinderFeed = paramj.UH(e.e.finder_feed_full_footer_layout);
      if (paramBaseFinderFeed != null) {
        paramMenuItem.add(paramBaseFinderFeed);
      }
      paramBaseFinderFeed = (FinderVideoLayout)paramj.UH(e.e.finder_banner_video_layout);
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = null;
        if (!(paramBaseFinderFeed instanceof FinderThumbPlayerProxy)) {
          break label302;
        }
      }
      label302:
      for (paramBaseFinderFeed = (FinderThumbPlayerProxy)paramBaseFinderFeed;; paramBaseFinderFeed = null)
      {
        if (paramBaseFinderFeed == null) {
          break label1671;
        }
        paramj = com.tencent.mm.ui.component.k.aeZF;
        paramFinderFeedSearchUI = com.tencent.mm.ui.component.k.d((AppCompatActivity)paramFinderFeedSearchUI).q(com.tencent.mm.plugin.finder.viewmodel.component.av.class);
        kotlin.g.b.s.s(paramFinderFeedSearchUI, "UICProvider.of(getActivi…edControlUIC::class.java)");
        com.tencent.mm.plugin.finder.viewmodel.component.av.a((com.tencent.mm.plugin.finder.viewmodel.component.av)paramFinderFeedSearchUI, paramMenuItem, paramBaseFinderFeed, 0, false, null, 28);
        AppMethodBeat.o(342846);
        return;
        paramBaseFinderFeed = paramBaseFinderFeed.getVideoView();
        break;
      }
    }
    if (paramInt == paramFinderFeedSearchUI.AST)
    {
      paramInt = paramFinderFeedSearchUI.Fwa.indexOf(paramBaseFinderFeed);
      if (paramInt >= 0)
      {
        paramMenuItem = paramFinderFeedSearchUI.mkw;
        paramj = paramMenuItem;
        if (paramMenuItem == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          paramj = null;
        }
        RecyclerView.f localf = paramj.getItemAnimator();
        androidx.recyclerview.widget.f localf1 = new androidx.recyclerview.widget.f();
        localf1.bZJ = 2000L;
        paramj = paramFinderFeedSearchUI.mkw;
        if (paramj == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          paramj = null;
        }
        for (;;)
        {
          paramj.setItemAnimator((RecyclerView.f)localf1);
          paramMenuItem = paramFinderFeedSearchUI.mkw;
          paramj = paramMenuItem;
          if (paramMenuItem == null)
          {
            kotlin.g.b.s.bIx("recyclerView");
            paramj = null;
          }
          paramj.postDelayed(new FinderFeedSearchUI..ExternalSyntheticLambda16(paramFinderFeedSearchUI, localf), localf1.Ku());
          Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("defaultItemAnimator.removeDuration =", Long.valueOf(localf1.Ku())));
          paramj = com.tencent.mm.plugin.finder.feed.logic.c.Bep;
          paramj = paramFinderFeedSearchUI.getContext();
          kotlin.g.b.s.s(paramj, "context");
          com.tencent.mm.plugin.finder.feed.logic.c.a((Context)paramj, paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getObjectNonceId(), (kotlin.g.a.b)new i(paramFinderFeedSearchUI, paramBaseFinderFeed));
          AppMethodBeat.o(342846);
          return;
        }
      }
      Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("[UNINTEREST] pos error ", Integer.valueOf(paramInt)));
      AppMethodBeat.o(342846);
      return;
    }
    if (paramInt == paramFinderFeedSearchUI.ASU)
    {
      if (paramBaseFinderFeed.contact != null) {
        AppMethodBeat.o(342846);
      }
    }
    else
    {
      if (paramInt == paramFinderFeedSearchUI.Auf)
      {
        an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)paramFinderFeedSearchUI, paramBaseFinderFeed.feedObject, null, 3, 20);
        AppMethodBeat.o(342846);
        return;
      }
      if (paramInt == paramFinderFeedSearchUI.Aug)
      {
        an.a.a(com.tencent.mm.plugin.finder.utils.an.GhR, (AppCompatActivity)paramFinderFeedSearchUI, paramBaseFinderFeed, 0, 0, 28);
        AppMethodBeat.o(342846);
        return;
      }
      if (paramInt == paramFinderFeedSearchUI.ASW)
      {
        paramj = com.tencent.mm.plugin.finder.utils.n.Ggy;
        com.tencent.mm.plugin.finder.utils.n.a(paramBaseFinderFeed, (Activity)paramFinderFeedSearchUI);
        AppMethodBeat.o(342846);
        return;
      }
      if (paramInt == paramFinderFeedSearchUI.ATf)
      {
        paramj = com.tencent.mm.plugin.finder.utils.an.GhR;
        paramFinderFeedSearchUI = paramFinderFeedSearchUI.getContext();
        kotlin.g.b.s.s(paramFinderFeedSearchUI, "context");
        an.a.a(paramj, paramFinderFeedSearchUI, paramBaseFinderFeed);
        AppMethodBeat.o(342846);
        return;
      }
      if (paramInt == paramFinderFeedSearchUI.ATi)
      {
        paramj = (FinderFullSeekBarLayout)paramj.UH(e.e.full_seek_bar_layout);
        paramj.fiH();
        paramMenuItem = al.GhB;
        paramFinderFeedSearchUI = paramFinderFeedSearchUI.getContext();
        kotlin.g.b.s.s(paramFinderFeedSearchUI, "context");
        al.a(paramFinderFeedSearchUI, paramBaseFinderFeed, (kotlin.g.a.b)new j(paramj));
        AppMethodBeat.o(342846);
        return;
      }
      if (paramInt == paramFinderFeedSearchUI.ASV)
      {
        paramj = com.tencent.mm.plugin.finder.utils.aw.Gjk;
        if (com.tencent.mm.plugin.finder.utils.aw.s(paramBaseFinderFeed))
        {
          paramj = paramBaseFinderFeed.feedObject.getLiveInfo();
          if (paramj != null)
          {
            long l = paramj.liveId;
            paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
            paramFinderFeedSearchUI = paramFinderFeedSearchUI.getContext();
            kotlin.g.b.s.s(paramFinderFeedSearchUI, "context");
            com.tencent.mm.plugin.finder.feed.logic.a.c((Context)paramFinderFeedSearchUI, l, paramBaseFinderFeed.feedObject.getUserName());
            AppMethodBeat.o(342846);
          }
        }
        else
        {
          paramj = com.tencent.mm.plugin.finder.feed.logic.a.Bem;
          paramFinderFeedSearchUI = paramFinderFeedSearchUI.getContext();
          kotlin.g.b.s.s(paramFinderFeedSearchUI, "context");
          com.tencent.mm.plugin.finder.feed.logic.a.a((Context)paramFinderFeedSearchUI, paramBaseFinderFeed.feedObject.field_id, 0L, 0, 0, 28);
          AppMethodBeat.o(342846);
        }
      }
      else
      {
        if (paramInt == paramFinderFeedSearchUI.ASX)
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
            paramBaseFinderFeed = paramFinderFeedSearchUI.getContext();
            kotlin.g.b.s.s(paramBaseFinderFeed, "context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI((Context)paramBaseFinderFeed, paramMenuItem);
            AppMethodBeat.o(342846);
            return;
          }
        }
        if (paramInt == paramFinderFeedSearchUI.ASZ)
        {
          ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), true, (com.tencent.mm.plugin.findersdk.a.ck)new k(paramFinderFeedSearchUI));
          AppMethodBeat.o(342846);
          return;
        }
        if (paramInt == paramFinderFeedSearchUI.ASY)
        {
          ((com.tencent.mm.plugin.finder.service.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.finder.service.q.class)).a(paramBaseFinderFeed.feedObject.getId(), paramBaseFinderFeed.feedObject.getFeedObject(), paramBaseFinderFeed.feedObject.getObjectNonceId(), false, (com.tencent.mm.plugin.findersdk.a.ck)new l(paramFinderFeedSearchUI));
          AppMethodBeat.o(342846);
          return;
        }
        if (paramInt == paramFinderFeedSearchUI.ATb)
        {
          if (paramBaseFinderFeed.feedObject.isPostFinish())
          {
            paramj = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
            paramj = paramFinderFeedSearchUI.getContext();
            kotlin.g.b.s.s(paramj, "context");
            paramj = as.a.hu((Context)paramj);
            if (paramj == null) {
              paramInt = 0;
            }
            while (paramInt == 52) {
              if ((paramFinderFeedSearchUI.getContext() instanceof FinderTopicTimelineUI))
              {
                paramj = paramFinderFeedSearchUI.getContext();
                if (paramj == null)
                {
                  paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                  AppMethodBeat.o(342846);
                  throw paramBaseFinderFeed;
                  paramInt = paramj.AJo;
                }
                else
                {
                  ((FinderTopicTimelineUI)paramj).onBackPressed();
                }
              }
              else
              {
                paramj = com.tencent.mm.plugin.finder.report.z.FrZ;
                paramFinderFeedSearchUI = paramFinderFeedSearchUI.getContext();
                kotlin.g.b.s.s(paramFinderFeedSearchUI, "context");
                com.tencent.mm.plugin.finder.report.z.a((Context)paramFinderFeedSearchUI, 1, 1, Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count));
                AppMethodBeat.o(342846);
                return;
              }
            }
            paramj = com.tencent.mm.plugin.finder.storage.data.e.FMN;
            e.a.s(paramBaseFinderFeed.feedObject);
            paramj = com.tencent.mm.plugin.finder.utils.as.GiG;
            paramj = paramFinderFeedSearchUI.getContext();
            kotlin.g.b.s.s(paramj, "context");
            paramMenuItem = (Context)paramj;
            paramj = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
            if (paramj == null) {}
            for (paramj = null;; paramj = paramj.feedBgmInfo)
            {
              com.tencent.mm.plugin.finder.utils.as.a(paramMenuItem, paramj, Long.valueOf(paramBaseFinderFeed.feedObject.field_id), 0);
              break;
            }
          }
        }
        else
        {
          if (paramInt == paramFinderFeedSearchUI.ATc)
          {
            paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0) {}
            for (paramj = paramFinderFeedSearchUI.getContext().getResources().getString(e.h.finder_has_fav_title);; paramj = paramFinderFeedSearchUI.getContext().getResources().getString(e.h.finder_has_fav_title2))
            {
              kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…title2)\n                }");
              com.tencent.mm.ui.base.aa.a((Context)paramFinderFeedSearchUI.getContext(), paramj, new FinderFeedSearchUI..ExternalSyntheticLambda4(paramFinderFeedSearchUI, paramBaseFinderFeed));
              AppMethodBeat.o(342846);
              return;
            }
          }
          if (paramInt == paramFinderFeedSearchUI.ATd)
          {
            paramj = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0) {}
            for (paramj = paramFinderFeedSearchUI.getContext().getResources().getString(e.h.finder_has_cancel_fav_title);; paramj = paramFinderFeedSearchUI.getContext().getResources().getString(e.h.finder_has_cancel_fav_title2))
            {
              kotlin.g.b.s.s(paramj, "if (FinderConfig.FINDER_…title2)\n                }");
              com.tencent.mm.ui.base.aa.a((Context)paramFinderFeedSearchUI.getContext(), paramj, new FinderFeedSearchUI..ExternalSyntheticLambda3(paramFinderFeedSearchUI, paramBaseFinderFeed));
              AppMethodBeat.o(342846);
              return;
            }
          }
          if (paramInt == paramFinderFeedSearchUI.ATn)
          {
            paramj = am.GhD;
            paramFinderFeedSearchUI = paramFinderFeedSearchUI.getContext();
            kotlin.g.b.s.s(paramFinderFeedSearchUI, "context");
            paramFinderFeedSearchUI = (Activity)paramFinderFeedSearchUI;
            paramj = com.tencent.mm.plugin.finder.storage.logic.h.FNM;
            am.a(paramBaseFinderFeed, paramFinderFeedSearchUI, com.tencent.mm.plugin.finder.storage.logic.h.aAP(paramBaseFinderFeed.feedObject.getFromAppId()));
            AppMethodBeat.o(342846);
            return;
          }
          paramj = paramFinderFeedSearchUI.ATr;
          if (paramj == null)
          {
            kotlin.g.b.s.bIx("quickMenuHelper");
            paramj = null;
          }
          while (paramMenuItem == null)
          {
            paramBaseFinderFeed = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
            AppMethodBeat.o(342846);
            throw paramBaseFinderFeed;
          }
          paramj.a((com.tencent.mm.ui.base.t)paramMenuItem, (kotlin.g.a.b)new h(paramFinderFeedSearchUI, paramMenuItem, paramBaseFinderFeed));
        }
      }
    }
    label1671:
    AppMethodBeat.o(342846);
  }
  
  private final void a(com.tencent.mm.plugin.finder.model.af paramaf)
  {
    AppMethodBeat.i(342578);
    Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("addScrollTips wording:", paramaf.wording));
    if ((kotlin.a.p.oM((List)this.Fwa) instanceof com.tencent.mm.plugin.finder.model.af))
    {
      aAd(paramaf.wording);
      AppMethodBeat.o(342578);
      return;
    }
    bC(this.Fwa.size(), paramaf.wording);
    this.Fwa.add(paramaf);
    AppMethodBeat.o(342578);
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, View paramView)
  {
    AppMethodBeat.i(342775);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedSearchUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    paramFinderFeedSearchUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(342775);
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, View paramView1, View paramView2)
  {
    AppMethodBeat.i(342766);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFeedSearchUI);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    paramView1 = paramFinderFeedSearchUI.Fwm;
    if (paramView1 == null) {}
    for (paramFinderFeedSearchUI = null;; paramFinderFeedSearchUI = null)
    {
      if (paramFinderFeedSearchUI == null) {
        Log.i("Finder.FinderFeedSearchUI", "info empty onClick!");
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342766);
      return;
      paramFinderFeedSearchUI = paramFinderFeedSearchUI.Fwn;
      if (paramFinderFeedSearchUI != null) {
        break;
      }
    }
    Log.i("Finder.HotSearchInfoDialog", "showDialog");
    paramView2 = paramFinderFeedSearchUI.FwF;
    if ((paramView2 != null) && (paramView2.isShowing() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramFinderFeedSearchUI.a(paramView1);
        paramFinderFeedSearchUI = paramFinderFeedSearchUI.FwF;
        if (paramFinderFeedSearchUI != null) {
          paramFinderFeedSearchUI.show();
        }
      }
      paramFinderFeedSearchUI = ah.aiuX;
      break;
    }
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, RecyclerView.f paramf)
  {
    AppMethodBeat.i(342824);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    RecyclerView localRecyclerView = paramFinderFeedSearchUI.mkw;
    paramFinderFeedSearchUI = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramFinderFeedSearchUI = null;
    }
    paramFinderFeedSearchUI.setItemAnimator(paramf);
    AppMethodBeat.o(342824);
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(342830);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
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
    i.a.a((com.tencent.mm.plugin.finder.feed.i)paramFinderFeedSearchUI, paramBaseFinderFeed.feedObject, true);
    AppMethodBeat.o(342830);
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(342794);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    Object localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
    localObject1 = paramFinderFeedSearchUI.getContext();
    kotlin.g.b.s.s(localObject1, "context");
    localObject1 = com.tencent.mm.plugin.finder.utils.av.a((Context)localObject1, paramBaseFinderFeed, null, 12);
    boolean bool1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiW;
    boolean bool2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiX;
    boolean bool3 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiY;
    Object localObject2 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).GiZ;
    String str = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).Gja;
    localObject1 = ((com.tencent.mm.plugin.finder.utils.av.a)localObject1).Gjb;
    params.a(paramFinderFeedSearchUI.Auf, (CharSequence)localObject2, e.g.finder_icons_filled_share, paramFinderFeedSearchUI.getContext().getResources().getColor(e.b.Brand), bool1);
    params.a(paramFinderFeedSearchUI.Aug, (CharSequence)str, e.g.bottomsheet_icon_moment, 0, bool2);
    localObject2 = com.tencent.mm.plugin.finder.upload.action.c.GcH;
    int i;
    if (!com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject()))
    {
      i = 1;
      localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
      {
        if (!bool3) {
          break label518;
        }
        params.a(paramFinderFeedSearchUI.ATc, (CharSequence)localObject1, e.g.finder_icons_filled_star2, paramFinderFeedSearchUI.getContext().getResources().getColor(e.b.orange_100), true);
      }
      label226:
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eWt().bmg()).intValue() == 1)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (com.tencent.mm.plugin.finder.utils.av.F(paramBaseFinderFeed.feedObject.getFeedObject()))
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          localObject1 = paramFinderFeedSearchUI.getContext();
          kotlin.g.b.s.s(localObject1, "context");
          com.tencent.mm.plugin.finder.report.z.j((Context)localObject1, paramBaseFinderFeed.bZA());
          params.a(paramFinderFeedSearchUI.ATf, (CharSequence)paramFinderFeedSearchUI.getContext().getString(e.h.finder_share_text_stauts_title), e.g.state_icon_main, paramFinderFeedSearchUI.getContext().getResources().getColor(e.b.Blue));
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      if (com.tencent.mm.plugin.finder.utils.av.p(paramBaseFinderFeed))
      {
        localObject1 = paramBaseFinderFeed.feedObject;
        if (localObject1 != null) {
          break label604;
        }
        i = 0;
        label359:
        if (i == 0) {
          break label655;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
        if (i < com.tencent.mm.plugin.finder.utils.av.fgc()) {
          break label655;
        }
        if (i <= 99999) {
          break label630;
        }
        localObject1 = String.valueOf(paramFinderFeedSearchUI.getContext().getString(e.h.finder_hundred_thousand_ringtone));
      }
    }
    label397:
    label655:
    for (localObject1 = paramFinderFeedSearchUI.getContext().getString(e.h.finder_feed_has_been_set_ringtone, new Object[] { localObject1 });; localObject1 = paramFinderFeedSearchUI.getContext().getString(e.h.finder_share_ringtone_title))
    {
      kotlin.g.b.s.s(localObject1, "if(count != 0 && count >…tone_title)\n            }");
      params.a(paramFinderFeedSearchUI.ATi, (CharSequence)localObject1, e.g.icons_filled_ringtone, 0);
      params = com.tencent.mm.plugin.finder.report.z.FrZ;
      com.tencent.mm.plugin.finder.report.z.aa(paramBaseFinderFeed.bZA(), 6);
      params = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramFinderFeedSearchUI = as.a.hu((Context)paramFinderFeedSearchUI);
      if (paramFinderFeedSearchUI != null)
      {
        paramFinderFeedSearchUI = ((bn)paramFinderFeedSearchUI).foy();
        if (paramFinderFeedSearchUI != null)
        {
          paramFinderFeedSearchUI = paramFinderFeedSearchUI.dYj();
          if (paramFinderFeedSearchUI != null) {
            paramFinderFeedSearchUI.nj(paramBaseFinderFeed.bZA());
          }
        }
      }
      AppMethodBeat.o(342794);
      return;
      i = 0;
      break;
      if (i != 0)
      {
        params.a(paramFinderFeedSearchUI.ATc, (CharSequence)paramFinderFeedSearchUI.getContext().getString(e.h.favorite), e.g.finder_icons_filled_star2, paramFinderFeedSearchUI.getContext().getResources().getColor(e.b.orange_100));
        break label226;
      }
      params.a(paramFinderFeedSearchUI.ATd, (CharSequence)paramFinderFeedSearchUI.getContext().getString(e.h.finder_cancel_fav_title), e.g.finder_icons_filled_unstar2, paramFinderFeedSearchUI.getContext().getResources().getColor(e.b.orange_100));
      break label226;
      label604:
      localObject1 = ((FinderItem)localObject1).field_finderObject;
      if (localObject1 == null)
      {
        i = 0;
        break label359;
      }
      i = ((FinderObject)localObject1).ringtone_count;
      break label359;
      label630:
      if (i > 9999)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.av.Ul(i);
        break label397;
      }
      localObject1 = String.valueOf(i);
      break label397;
    }
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(342818);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    com.tencent.mm.pluginsdk.q localq = paramFinderFeedSearchUI.ATr;
    paramFinderFeedSearchUI = localq;
    if (localq == null)
    {
      kotlin.g.b.s.bIx("quickMenuHelper");
      paramFinderFeedSearchUI = null;
    }
    if (paramMenuItem == null)
    {
      paramFinderFeedSearchUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMMenuItem");
      AppMethodBeat.o(342818);
      throw paramFinderFeedSearchUI;
    }
    Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("getMoreMenuItemLongSelectedListener :", Boolean.valueOf(paramFinderFeedSearchUI.a(paramf, (com.tencent.mm.ui.base.t)paramMenuItem))));
    AppMethodBeat.o(342818);
  }
  
  private static final void a(FinderFeedSearchUI paramFinderFeedSearchUI, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342812);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    kotlin.g.b.s.u(paramf, "$sheet");
    com.tencent.mm.pluginsdk.q localq = paramFinderFeedSearchUI.ATr;
    if (localq == null)
    {
      kotlin.g.b.s.bIx("quickMenuHelper");
      localq = null;
      Object localObject2 = paramFinderFeedSearchUI.getContext();
      kotlin.g.b.s.s(localObject2, "context");
      localObject2 = (Context)localObject2;
      kotlin.g.b.s.s(params, "it");
      localq.a((Context)localObject2, params, paramf);
      paramf = com.tencent.mm.plugin.finder.utils.an.GhR;
      paramFinderFeedSearchUI = paramFinderFeedSearchUI.ATr;
      if (paramFinderFeedSearchUI != null) {
        break label119;
      }
      kotlin.g.b.s.bIx("quickMenuHelper");
      paramFinderFeedSearchUI = localObject1;
    }
    label119:
    for (;;)
    {
      an.a.TX(paramFinderFeedSearchUI.getItemCount());
      AppMethodBeat.o(342812);
      return;
      break;
    }
  }
  
  private final void a(bux parambux)
  {
    AppMethodBeat.i(342543);
    Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("recordEventInfo hotWord:", parambux));
    if (parambux != null)
    {
      Map localMap = (Map)this.Fwz;
      String str2 = parambux.aacq;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localMap.put(str1, parambux.AtP);
      str2 = getIntent().getStringExtra("key_search_query");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      if (kotlin.g.b.s.p(str1, parambux.aacq)) {
        aAc(str1);
      }
    }
    AppMethodBeat.o(342543);
  }
  
  private final void a(String paramString, com.tencent.mm.bx.b paramb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(342622);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.BgS = null;
    this.Fwa.clear();
    if (!paramBoolean2)
    {
      str = UUID.randomUUID().toString();
      kotlin.g.b.s.s(str, "randomUUID().toString()");
      this.hOG = str;
    }
    if (this.BnD != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD);
    }
    eOD();
    int i = eOF();
    Log.i("Finder.FinderFeedSearchUI", "startSearch query:" + paramString + " requestScene:" + i);
    int j = this.offset;
    String str = this.hOG;
    com.tencent.mm.bx.b localb = this.BgS;
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    this.BnD = new dk(paramString, j, str, localb, i, ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), paramb, this.Fwg, 128);
    paramString = this.BnD;
    if (paramString != null) {
      paramString.xVf = this.xVf;
    }
    paramString = this.BnD;
    if (paramString != null) {
      paramString.ADh = paramBoolean1;
    }
    if (paramBoolean1)
    {
      this.xVf = 3;
      if (this.Fwf != null)
      {
        paramString = this.Fwp;
        if (paramString != null) {
          paramString.run();
        }
        this.Fwp = null;
      }
    }
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD, 0);
    com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
    paramb = this.njN;
    paramString = paramb;
    if (paramb == null)
    {
      kotlin.g.b.s.bIx("loadingView");
      paramString = null;
    }
    paramString.setVisibility(0);
    paramb = this.BnA;
    paramString = paramb;
    if (paramb == null)
    {
      kotlin.g.b.s.bIx("noResultView");
      paramString = null;
    }
    paramString.setVisibility(8);
    paramb = this.ATx;
    paramString = paramb;
    if (paramb == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramString = null;
    }
    paramString.setVisibility(8);
    paramb = this.mkw;
    paramString = paramb;
    if (paramb == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramString = null;
    }
    paramb = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramb.aYi(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "startSearch", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZZ)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)paramb.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "startSearch", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZZ)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(342622);
  }
  
  private static final boolean a(FinderFeedSearchUI paramFinderFeedSearchUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342783);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    paramMotionEvent = paramFinderFeedSearchUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderFeedSearchUI.hideVKB();
    AppMethodBeat.o(342783);
    return false;
  }
  
  private final void aAc(String paramString)
  {
    AppMethodBeat.i(342684);
    if (!eOA())
    {
      Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("refreshHotSearchTitle hotWordText:", paramString));
      awt localawt = (awt)this.Fwz.get(paramString);
      this.Fwm = localawt;
      TextView localTextView = this.Fwj;
      if (localTextView != null) {
        localTextView.setText((CharSequence)paramString);
      }
      if (localawt != null) {
        break label92;
      }
    }
    for (paramString = null;; paramString = ah.aiuX)
    {
      if (paramString == null)
      {
        paramString = this.Fwk;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
      AppMethodBeat.o(342684);
      return;
      label92:
      paramString = this.Fwk;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
  }
  
  private final void aAd(String paramString)
  {
    AppMethodBeat.i(342699);
    Object localObject = this.Fwf;
    if (localObject != null) {
      ((SearchHotWordListParcelable)localObject).aAk(paramString);
    }
    if (this.Fwa.size() > 0)
    {
      localObject = kotlin.a.p.oM((List)this.Fwa);
      if (!(localObject instanceof com.tencent.mm.plugin.finder.model.af)) {
        break label133;
      }
    }
    label133:
    for (localObject = (com.tencent.mm.plugin.finder.model.af)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.model.af)localObject).ayQ(paramString);
      }
      RecyclerView localRecyclerView = this.mkw;
      localObject = localRecyclerView;
      if (localRecyclerView == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject = null;
      }
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).fV(this.Fwa.size() - 1);
      }
      bC(this.Fwa.size() - 1, paramString);
      Log.w("Finder.FinderFeedSearchUI", "onSceneEnd remove for list empty!");
      AppMethodBeat.o(342699);
      return;
    }
  }
  
  private final void aAe(String paramString)
  {
    AppMethodBeat.i(342731);
    TextView localTextView = this.Fwv;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    localTextView = this.Fwv;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
    if (this.Fwu != null)
    {
      this.mRi.removeCallbacks(this.Fwu);
      this.Fwu = null;
    }
    this.Fwu = new FinderFeedSearchUI..ExternalSyntheticLambda15(this);
    this.mRi.postDelayed(this.Fwu, this.Fww);
    AppMethodBeat.o(342731);
  }
  
  private final void aNi()
  {
    AppMethodBeat.i(342565);
    Object localObject1 = k.FxZ;
    k.ePf().clear();
    localObject1 = k.FxZ;
    if (k.ePe() != null)
    {
      localObject1 = k.FxZ;
      Object localObject3 = k.ePe();
      kotlin.g.b.s.checkNotNull(localObject3);
      localObject1 = k.FxZ;
      k.a(null);
      localObject2 = ((axg)localObject3).hOG;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.hOG = ((String)localObject1);
      localObject2 = ((axg)localObject3).query;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.query = ((String)localObject1);
      this.offset = ((axg)localObject3).offset;
      this.continueFlag = ((axg)localObject3).continueFlag;
      this.BgS = ((axg)localObject3).BgS;
      this.pyl = ((axg)localObject3).ERV;
      localObject1 = ((axg)localObject3).AdW;
      kotlin.g.b.s.s(localObject1, "finderFeedObj.objectList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject2).next();
        kotlin.g.b.s.s(localObject3, "it");
        q((FinderObject)localObject3);
        ((Collection)localObject1).add(ah.aiuX);
      }
    }
    localObject1 = UUID.randomUUID().toString();
    kotlin.g.b.s.s(localObject1, "randomUUID().toString()");
    this.hOG = ((String)localObject1);
    this.query = "";
    Object localObject2 = this.Bny;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      localObject1 = null;
    }
    ((FTSSearchView)localObject1).getFtsEditText().aWT();
    localObject2 = this.Bny;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      localObject1 = null;
    }
    ((FTSSearchView)localObject1).getFtsEditText().aWS();
    this.ATp.bD(1, 10);
    this.ATp.bD(2, 10);
    this.BnB = new j((MMActivity)this, true, true, (kotlin.g.a.b)new p(this), null);
    AppMethodBeat.o(342565);
  }
  
  private final void ac(long paramLong, int paramInt)
  {
    AppMethodBeat.i(342708);
    if ((paramLong == 0L) || (paramLong == -1L))
    {
      AppMethodBeat.o(342708);
      return;
    }
    Object localObject1 = com.tencent.mm.ae.d.hF(paramLong);
    Object localObject2;
    int i;
    label156:
    label185:
    label234:
    String str1;
    label263:
    label271:
    Object localObject3;
    String str2;
    int j;
    if (!this.FvE.containsKey(localObject1))
    {
      localObject2 = new a();
      ((a)localObject2).setId((String)localObject1);
      ((a)localObject2).position = paramInt;
      ((a)localObject2).type = 2;
      ((a)localObject2).timeStamp = System.currentTimeMillis();
      ((Map)this.FvE).put(localObject1, localObject2);
      if (this.FvE.size() % 30 == 0)
      {
        if ((paramLong != 0L) && (paramLong != -1L)) {
          break label355;
        }
        localObject1 = "";
        if (!Util.isNullOrNil((String)localObject1))
        {
          if (((Map)this.FvE).isEmpty()) {
            break label394;
          }
          i = 1;
          if (i != 0)
          {
            localObject2 = com.tencent.mm.plugin.finder.report.aa.Fsi;
            if ((paramLong != 0L) && (paramLong != -1L)) {
              break label400;
            }
            localObject2 = "";
            com.tencent.mm.plugin.finder.report.aa.b((String)localObject1, (String)localObject2, this.FvE, 3);
          }
        }
      }
      i = 3;
      if ((this.Fwb == 6) || (this.Fwb == 5))
      {
        this.xVf = 3;
        if (this.Fwb != 6) {
          break label439;
        }
        i = 1;
      }
      localObject4 = (FinderFeedSearchUI.c)this.Fwe.get(Long.valueOf(paramLong));
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      if (localObject4 != null) {
        break label445;
      }
      localObject1 = null;
      if (localObject4 != null) {
        break label455;
      }
      localObject2 = null;
      str1 = com.tencent.mm.ae.d.hF(paramLong);
      localObject3 = com.tencent.mm.plugin.finder.report.z.FrZ;
      str2 = com.tencent.mm.plugin.finder.report.z.eMW();
      j = this.xVf;
      localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      localObject3 = as.a.hu((Context)this);
      if (localObject3 != null) {
        break label465;
      }
      localObject3 = null;
      label315:
      if (localObject4 != null) {
        break label475;
      }
    }
    label394:
    label400:
    label439:
    label445:
    label455:
    label465:
    label475:
    for (Object localObject4 = "";; localObject4 = ((FinderFeedSearchUI.c)localObject4).FwD)
    {
      com.tencent.mm.plugin.finder.report.z.a((String)localObject1, (String)localObject2, 2, 2, str1, paramInt, i, str2, 1, j, (bui)localObject3, (String)localObject4);
      AppMethodBeat.o(342708);
      return;
      label355:
      localObject1 = (FinderFeedSearchUI.c)this.Fwe.get(Long.valueOf(paramLong));
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      localObject1 = ((FinderFeedSearchUI.c)localObject1).hOG;
      break;
      i = 0;
      break label156;
      localObject2 = (FinderFeedSearchUI.c)this.Fwe.get(Long.valueOf(paramLong));
      if (localObject2 == null)
      {
        localObject2 = "";
        break label185;
      }
      localObject2 = ((FinderFeedSearchUI.c)localObject2).query;
      break label185;
      i = 5;
      break label234;
      localObject1 = ((FinderFeedSearchUI.c)localObject4).hOG;
      break label263;
      localObject2 = ((FinderFeedSearchUI.c)localObject4).query;
      break label271;
      localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject3).fou();
      break label315;
    }
  }
  
  private final String b(bux parambux)
  {
    AppMethodBeat.i(342719);
    parambux = parambux.aacq;
    if (parambux == null)
    {
      parambux = getResources().getString(e.h.finder_search_hot_tips_default);
      kotlin.g.b.s.s(parambux, "resources.getString(R.st…_search_hot_tips_default)");
      AppMethodBeat.o(342719);
      return parambux;
    }
    AppMethodBeat.o(342719);
    return parambux;
  }
  
  private static final void b(FinderFeedSearchUI paramFinderFeedSearchUI, BaseFinderFeed paramBaseFinderFeed, View paramView)
  {
    AppMethodBeat.i(342835);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
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
    i.a.a((com.tencent.mm.plugin.finder.feed.i)paramFinderFeedSearchUI, paramBaseFinderFeed.feedObject, false);
    AppMethodBeat.o(342835);
  }
  
  private final void bC(int paramInt, String paramString)
  {
    AppMethodBeat.i(342736);
    ((Map)this.Fwy).put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(342736);
  }
  
  private final void bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(342638);
    Log.i("Finder.FinderFeedSearchUI", "startSearchNextPage: " + paramString + " isPreload:" + paramBoolean);
    if (eOA())
    {
      Log.w("Finder.FinderFeedSearchUI", "startSearchNextPage return for BlockHotSearch.");
      AppMethodBeat.o(342638);
      return;
    }
    if (this.Fwr)
    {
      AppMethodBeat.o(342638);
      return;
    }
    int i = this.offset;
    Object localObject = this.hOG;
    com.tencent.mm.bx.b localb = this.BgS;
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    this.BnD = new dk(paramString, i, (String)localObject, localb, 0, ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou(), null, this.Fwg, 208);
    localObject = this.BnD;
    if (localObject != null) {
      ((dk)localObject).rsE = paramBoolean;
    }
    if (this.ADh) {
      a(this.BnD, this.Fwf);
    }
    Log.i("Finder.FinderFeedSearchUI", "startSearchNextPage: " + paramString + " isPreload:" + paramBoolean + " netSceneFinderSearch:" + this.BnD);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD, 0);
    com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
    eOC();
    AppMethodBeat.o(342638);
  }
  
  private static final void c(FinderFeedSearchUI paramFinderFeedSearchUI)
  {
    AppMethodBeat.i(342851);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    paramFinderFeedSearchUI.bC(0, paramFinderFeedSearchUI.query);
    a(paramFinderFeedSearchUI.BnD, paramFinderFeedSearchUI.Fwf);
    AppMethodBeat.o(342851);
  }
  
  private static final void d(FinderFeedSearchUI paramFinderFeedSearchUI)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342861);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    RecyclerView localRecyclerView = paramFinderFeedSearchUI.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = null;
    }
    if ((((RecyclerView)localObject1).getLayoutManager() instanceof LinearLayoutManager))
    {
      localRecyclerView = paramFinderFeedSearchUI.mkw;
      localObject1 = localRecyclerView;
      if (localRecyclerView == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = null;
      }
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      if (localObject1 == null)
      {
        paramFinderFeedSearchUI = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(342861);
        throw paramFinderFeedSearchUI;
      }
      int i = ((LinearLayoutManager)localObject1).Ju();
      localObject1 = paramFinderFeedSearchUI.mkw;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = ((RecyclerView)localObject1).getLayoutManager();
        if (localObject1 != null) {
          break;
        }
        paramFinderFeedSearchUI = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(342861);
        throw paramFinderFeedSearchUI;
      }
      int k = ((LinearLayoutManager)localObject1).Jw();
      if (i <= k)
      {
        int j;
        do
        {
          j = i;
          i = j + 1;
          if ((j >= 0) && (j < paramFinderFeedSearchUI.Fwa.size())) {
            paramFinderFeedSearchUI.ac(((cc)paramFinderFeedSearchUI.Fwa.get(j)).bZA(), j);
          }
        } while (j != k);
      }
    }
    AppMethodBeat.o(342861);
  }
  
  private static final void e(FinderFeedSearchUI paramFinderFeedSearchUI)
  {
    AppMethodBeat.i(342870);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    if (paramFinderFeedSearchUI.ATr == null) {
      kotlin.g.b.s.bIx("quickMenuHelper");
    }
    AppMethodBeat.o(342870);
  }
  
  private final boolean eOA()
  {
    return (this.Fwb != 5) && (this.Fwb != 6);
  }
  
  private final void eOB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342590);
    Log.i("Finder.FinderFeedSearchUI", "showNoMoreFooter");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    Object localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
    if (localObject1 != null)
    {
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(e.h.finder_load_more_no_result_tip);
      }
    }
    localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label267;
      }
      localObject1 = null;
      label137:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label278;
      }
      localObject1 = null;
      label176:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label289;
      }
      localObject1 = null;
      label215:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label300;
      }
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = localObject2;
    }
    label267:
    label278:
    label289:
    label300:
    for (;;)
    {
      B((RecyclerView)localObject1);
      AppMethodBeat.o(342590);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      break;
      localObject1 = ((View)localObject1).findViewById(e.e.load_more_footer_end_layout);
      break label137;
      localObject1 = ((View)localObject1).findViewById(e.e.load_finish);
      break label176;
      localObject1 = ((View)localObject1).findViewById(e.e.rl_loading_icon);
      break label215;
    }
  }
  
  private final void eOC()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342595);
    Log.i("Finder.FinderFeedSearchUI", "showLoadMoreFooter");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    Object localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
    if (localObject1 != null)
    {
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(e.h.finder_load_more_footer_tip);
      }
    }
    localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label246;
      }
      localObject1 = null;
      label136:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label257;
      }
      localObject1 = null;
      label176:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label268;
      }
    }
    label257:
    label268:
    for (localObject1 = localObject2;; localObject1 = ((View)localObject1).findViewById(e.e.rl_loading_icon))
    {
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      AppMethodBeat.o(342595);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      break;
      label246:
      localObject1 = ((View)localObject1).findViewById(e.e.load_more_footer_end_layout);
      break label136;
      localObject1 = ((View)localObject1).findViewById(e.e.load_finish);
      break label176;
    }
  }
  
  private final void eOD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342603);
    Log.i("Finder.FinderFeedSearchUI", "dismissFooter");
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    Object localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
    if (localObject1 != null)
    {
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(e.h.finder_load_more_no_result_tip);
      }
    }
    localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label248;
      }
      localObject1 = null;
      label137:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label259;
      }
      localObject1 = null;
      label177:
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localRefreshLoadMoreLayout = this.ATx;
      localObject1 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = null;
      }
      localObject1 = ((RefreshLoadMoreLayout)localObject1).getLoadMoreFooter();
      if (localObject1 != null) {
        break label270;
      }
    }
    label259:
    label270:
    for (localObject1 = localObject2;; localObject1 = ((View)localObject1).findViewById(e.e.rl_loading_icon))
    {
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      AppMethodBeat.o(342603);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(e.e.load_more_footer_tip_tv);
      break;
      label248:
      localObject1 = ((View)localObject1).findViewById(e.e.load_more_footer_end_layout);
      break label137;
      localObject1 = ((View)localObject1).findViewById(e.e.load_finish);
      break label177;
    }
  }
  
  private final void eOE()
  {
    AppMethodBeat.i(342610);
    Object localObject1 = (Iterable)this.Fwa;
    Object localObject2 = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    label84:
    while (localIterator.hasNext())
    {
      localObject1 = (cc)localIterator.next();
      if ((localObject1 instanceof BaseFinderFeed)) {}
      for (localObject1 = ((BaseFinderFeed)localObject1).feedObject;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label84;
        }
        ((Collection)localObject2).add(localObject1);
        break;
      }
    }
    localObject1 = (List)localObject2;
    localObject2 = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.feed.jumper.i)com.tencent.mm.ui.component.k.cn(cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class)).F((List)localObject1, 6);
    AppMethodBeat.o(342610);
  }
  
  private final int eOF()
  {
    AppMethodBeat.i(342631);
    if (!eOA())
    {
      if (this.Fwf != null)
      {
        AppMethodBeat.o(342631);
        return 10;
      }
      AppMethodBeat.o(342631);
      return 14;
    }
    AppMethodBeat.o(342631);
    return 2;
  }
  
  private final void eOG()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342693);
    Object localObject3;
    Object localObject1;
    if (this.Fwb == 0)
    {
      localObject3 = this.Bny;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        localObject1 = null;
      }
      if (((FTSSearchView)localObject1).getParent() == null)
      {
        ((FrameLayout)findViewById(e.e.actionBarLayout)).removeAllViews();
        localObject3 = this.Bny;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          localObject1 = null;
        }
        localObject1 = ((FTSSearchView)localObject1).getSearchContainer().getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          AppMethodBeat.o(342693);
          throw ((Throwable)localObject1);
        }
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        localObject1 = this.Bny;
        if (localObject1 != null) {
          break label189;
        }
        kotlin.g.b.s.bIx("searchView");
        localObject1 = null;
        ((FTSSearchView)localObject1).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        localObject3 = (FrameLayout)findViewById(e.e.actionBarLayout);
        localObject1 = this.Bny;
        if (localObject1 != null) {
          break label192;
        }
        kotlin.g.b.s.bIx("searchView");
        localObject1 = localObject2;
      }
    }
    label189:
    label192:
    for (;;)
    {
      ((FrameLayout)localObject3).addView((View)localObject1);
      AppMethodBeat.o(342693);
      return;
      break;
    }
  }
  
  private FinderLikeDrawer ebF()
  {
    AppMethodBeat.i(342506);
    FinderLikeDrawer localFinderLikeDrawer = this.ATA;
    if (localFinderLikeDrawer != null)
    {
      AppMethodBeat.o(342506);
      return localFinderLikeDrawer;
    }
    kotlin.g.b.s.bIx("friendLikeDrawer");
    AppMethodBeat.o(342506);
    return null;
  }
  
  private com.tencent.mm.plugin.finder.feed.model.i ecL()
  {
    AppMethodBeat.i(342511);
    com.tencent.mm.plugin.finder.feed.model.i locali = (com.tencent.mm.plugin.finder.feed.model.i)this.Bae.getValue();
    AppMethodBeat.o(342511);
    return locali;
  }
  
  private com.tencent.mm.plugin.findersdk.a.as ecM()
  {
    AppMethodBeat.i(342515);
    com.tencent.mm.plugin.findersdk.a.as localas = (com.tencent.mm.plugin.findersdk.a.as)this.Baf.getValue();
    AppMethodBeat.o(342515);
    return localas;
  }
  
  private static final void f(FinderFeedSearchUI paramFinderFeedSearchUI)
  {
    AppMethodBeat.i(342889);
    kotlin.g.b.s.u(paramFinderFeedSearchUI, "this$0");
    paramFinderFeedSearchUI = paramFinderFeedSearchUI.Fwv;
    if (paramFinderFeedSearchUI != null) {
      paramFinderFeedSearchUI.setVisibility(8);
    }
    AppMethodBeat.o(342889);
  }
  
  private final boolean gG(View paramView)
  {
    AppMethodBeat.i(342756);
    if (paramView == null)
    {
      AppMethodBeat.o(342756);
      return false;
    }
    Iterator localIterator = ((Iterable)this.FwB).iterator();
    while (localIterator.hasNext())
    {
      View localView = paramView.findViewById(((Number)localIterator.next()).intValue());
      if ((localView != null) && (localView.getVisibility() == 0))
      {
        AppMethodBeat.o(342756);
        return true;
      }
    }
    AppMethodBeat.o(342756);
    return false;
  }
  
  private final void q(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(166772);
    Object localObject = FinderItem.Companion;
    paramFinderObject = FinderItem.a.e(paramFinderObject, 16);
    localObject = k.FxZ;
    ((Map)k.ePf()).put(Long.valueOf(paramFinderObject.getId()), paramFinderObject);
    localObject = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    localObject = com.tencent.mm.plugin.finder.storage.logic.d.a.a(paramFinderObject);
    com.tencent.mm.plugin.finder.feed.component.d.a locala = com.tencent.mm.plugin.finder.feed.component.d.Bca;
    com.tencent.mm.plugin.finder.feed.component.d.a.edf().gb(kotlin.a.p.listOf(paramFinderObject));
    this.Fwa.add(localObject);
    AppMethodBeat.o(166772);
  }
  
  private static final void r(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(342875);
    kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "smoothScrollToNextPosition$lambda-54", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "smoothScrollToNextPosition$lambda-54", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(342875);
  }
  
  private static final void s(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(342882);
    kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "smoothScrollToLastPosition$lambda-55", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "smoothScrollToLastPosition$lambda-55", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(342882);
  }
  
  private final boolean ua(boolean paramBoolean)
  {
    AppMethodBeat.i(342526);
    Log.i("Finder.FinderFeedSearchUI", "getHotSearchList");
    if (this.Fwb != 5)
    {
      Log.i("Finder.FinderFeedSearchUI", "getHotSearchList return for hotSearchType:" + this.Fwb + '!');
      AppMethodBeat.o(342526);
      return false;
    }
    if (this.Fwc)
    {
      localObject1 = this.FvZ;
      if (localObject1 != null) {
        ((dw)localObject1).rsE = paramBoolean;
      }
      Log.i("Finder.FinderFeedSearchUI", "getHotSearchList return for isLoadingSearchList:" + this.Fwc + '!');
      AppMethodBeat.o(342526);
      return true;
    }
    this.Fwc = true;
    Object localObject2 = this.FvY;
    Object localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    localObject1 = as.a.hu((Context)localObject1);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1).fou())
    {
      this.FvZ = new dw(14, (com.tencent.mm.bx.b)localObject2, (bui)localObject1, this.Fwh, this.Fwg, 32);
      localObject1 = this.FvZ;
      if (localObject1 != null) {
        ((dw)localObject1).rsE = paramBoolean;
      }
      com.tencent.mm.kernel.h.aZW().a(4069, (com.tencent.mm.am.h)new g(this));
      localObject1 = com.tencent.mm.kernel.h.aZW();
      localObject2 = this.FvZ;
      kotlin.g.b.s.checkNotNull(localObject2);
      ((com.tencent.mm.am.s)localObject1).a((com.tencent.mm.am.p)localObject2, 0);
      AppMethodBeat.o(342526);
      return true;
    }
  }
  
  private final void ub(boolean paramBoolean)
  {
    AppMethodBeat.i(342548);
    Log.i("Finder.FinderFeedSearchUI", "onGetHotSearchList ");
    this.FvX = 0;
    if ((paramBoolean) || (this.Fwd)) {
      eOB();
    }
    AppMethodBeat.o(342548);
  }
  
  private final boolean uc(boolean paramBoolean)
  {
    AppMethodBeat.i(342668);
    Log.i("Finder.FinderFeedSearchUI", "startSearchNextHot: " + this.Fwf + " isPreloadingNextHotWord:" + this.Fwr);
    if (eOA())
    {
      Log.w("Finder.FinderFeedSearchUI", "startSearchNextHot return for BlockHotSearch.");
      AppMethodBeat.o(342668);
      return true;
    }
    if (this.Fwr)
    {
      Log.w("Finder.FinderFeedSearchUI", "startSearchNextHot return for isPreloadingNextHotWord.");
      AppMethodBeat.o(342668);
      return true;
    }
    Object localObject1 = this.Fwf;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        Log.w("Finder.FinderFeedSearchUI", "startSearchNextHot return for null.");
      }
      AppMethodBeat.o(342668);
      return false;
    }
    if (((SearchHotWordListParcelable)localObject1).FyE.isEmpty())
    {
      Log.w("Finder.FinderFeedSearchUI", "startSearchNextHot return for searchHotWordParcelableList is null.");
      AppMethodBeat.o(342668);
      return false;
    }
    if (((SearchHotWordListParcelable)localObject1).position < 0)
    {
      Log.w("Finder.FinderFeedSearchUI", "startSearchNextHot return for invalid pos:" + ((SearchHotWordListParcelable)localObject1).position + '.');
      AppMethodBeat.o(342668);
      return false;
    }
    ((SearchHotWordListParcelable)localObject1).position += 1;
    if (((SearchHotWordListParcelable)localObject1).position >= ((SearchHotWordListParcelable)localObject1).FyE.size())
    {
      Log.w("Finder.FinderFeedSearchUI", "startSearchNextHot: return for pos:" + ((SearchHotWordListParcelable)localObject1).position + " over size:" + ((SearchHotWordListParcelable)localObject1).FyE.size() + '.');
      ((SearchHotWordListParcelable)localObject1).position -= 1;
      AppMethodBeat.o(342668);
      return false;
    }
    ((SearchHotWordListParcelable)localObject1).FyD = ((SearchHotWordParcelable)((SearchHotWordListParcelable)localObject1).FyE.get(((SearchHotWordListParcelable)localObject1).position));
    Object localObject2 = ((SearchHotWordListParcelable)localObject1).FyD;
    if (localObject2 != null)
    {
      localObject2 = ((SearchHotWordParcelable)localObject2).FyF;
      if (localObject2 != null)
      {
        localObject2 = ((bux)localObject2).aacq;
        if (localObject2 != null)
        {
          this.query = ((String)localObject2);
          this.offset = 0;
          localObject2 = UUID.randomUUID().toString();
          kotlin.g.b.s.s(localObject2, "randomUUID().toString()");
          this.hOG = ((String)localObject2);
          this.BgS = null;
          localObject2 = ((SearchHotWordListParcelable)localObject1).FyD;
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = ((SearchHotWordParcelable)localObject2).FyF;
          kotlin.g.b.s.checkNotNull(localObject2);
          localObject2 = ((bux)localObject2).ZRe;
          Object localObject3 = com.tencent.mm.ui.component.k.aeZF;
          localObject3 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
          this.Fwq = new dk(this.query, this.offset, this.hOG, this.BgS, 10, (bui)localObject3, (com.tencent.mm.bx.b)localObject2, this.Fwg, 128);
          localObject2 = this.Fwq;
          if (localObject2 != null) {
            ((dk)localObject2).xVf = 3;
          }
          localObject2 = this.Fwq;
          if (localObject2 != null) {
            ((dk)localObject2).ADh = true;
          }
          localObject2 = this.Fwq;
          if (localObject2 != null) {
            ((dk)localObject2).rsE = paramBoolean;
          }
          a(this.Fwq, this.Fwf);
          Log.i("Finder.FinderFeedSearchUI", "startSearchNextHot pos:" + ((SearchHotWordListParcelable)localObject1).position + " query:" + this.query + " isPreload:" + paramBoolean + " preloadNetSceneFinderSearch:" + this.Fwq);
          if (!paramBoolean)
          {
            localObject2 = this.BnC;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              kotlin.g.b.s.bIx("searchSuggestionManager");
              localObject1 = null;
            }
            ((l)localObject1).aAj(this.query);
            localObject2 = this.Bny;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              kotlin.g.b.s.bIx("searchView");
              localObject1 = null;
            }
            ((FTSSearchView)localObject1).getFtsEditText().bCt(this.query);
          }
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.Fwq, 0);
          com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
          this.Fwr = true;
          AppMethodBeat.o(342668);
          return true;
        }
      }
    }
    localObject2 = new StringBuilder("startSearchNextHot hotWord:");
    localObject1 = ((SearchHotWordListParcelable)localObject1).FyD;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((SearchHotWordParcelable)localObject1).FyF)
    {
      Log.w("Finder.FinderFeedSearchUI", localObject1 + '.');
      localObject1 = ah.aiuX;
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf)
  {
    AppMethodBeat.i(343264);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramBaseFinderFeed = new FinderFeedSearchUI..ExternalSyntheticLambda7(this, paramf);
    AppMethodBeat.o(343264);
    return paramBaseFinderFeed;
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, int paramInt)
  {
    AppMethodBeat.i(343259);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    paramBaseFinderFeed = new FinderFeedSearchUI..ExternalSyntheticLambda6(this, paramBaseFinderFeed);
    AppMethodBeat.o(343259);
    return paramBaseFinderFeed;
  }
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(343262);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new FinderFeedSearchUI..ExternalSyntheticLambda5(paramBaseFinderFeed, this, paramf);
    AppMethodBeat.o(343262);
    return paramBaseFinderFeed;
  }
  
  public final u.h a(com.tencent.mm.ui.widget.a.f paramf, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(343268);
    kotlin.g.b.s.u(paramf, "bottomSheet");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramf = new FinderFeedSearchUI..ExternalSyntheticLambda8(this, paramf);
    AppMethodBeat.o(343268);
    return paramf;
  }
  
  public final u.i a(BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(343271);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new FinderFeedSearchUI..ExternalSyntheticLambda9(paramBaseFinderFeed, this, paramj);
    AppMethodBeat.o(343271);
    return paramBaseFinderFeed;
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(343279);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    Object localObject2 = com.tencent.mm.plugin.finder.model.an.ECX;
    localObject2 = paramBaseFinderFeed.feedObject;
    boolean bool = paramBaseFinderFeed.showLikeTips;
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    com.tencent.mm.plugin.finder.model.an.a((bui)localObject1, paramInt, (FinderItem)localObject2, paramBoolean1, paramBoolean2, 2, bool, paramBoolean3, com.tencent.mm.plugin.finder.utils.aw.n(paramBaseFinderFeed.contact));
    AppMethodBeat.o(343279);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(343276);
    kotlin.g.b.s.u(paramFinderItem, "feed");
    paramj = com.tencent.mm.plugin.finder.model.s.ECs;
    com.tencent.mm.plugin.finder.model.s.a((AppCompatActivity)this, paramFinderItem, paramBoolean, paramInt);
    AppMethodBeat.o(343276);
  }
  
  public final boolean aWU()
  {
    Object localObject3 = null;
    AppMethodBeat.i(166780);
    hideVKB();
    Object localObject2 = this.Bny;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      localObject1 = null;
    }
    localObject1 = ((FTSSearchView)localObject1).getFtsEditText().getTotalQuery();
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166780);
      return true;
      localObject2 = kotlin.n.n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    this.xVf = 1;
    this.Fwg = null;
    this.Fwb = 0;
    eOG();
    a(this, (String)localObject1);
    j localj = this.BnB;
    localObject2 = localj;
    if (localj == null)
    {
      kotlin.g.b.s.bIx("historyLogic");
      localObject2 = null;
    }
    ((j)localObject2).azd((String)localObject1);
    localObject1 = this.BnC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((l)localObject1).ePg();
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 6L, 1L, false);
      AppMethodBeat.o(166780);
      return false;
    }
  }
  
  public final com.tencent.mm.plugin.finder.view.f ebA()
  {
    AppMethodBeat.i(343201);
    com.tencent.mm.plugin.finder.view.f localf = this.ATy;
    if (localf == null)
    {
      kotlin.g.b.s.bIx("drawer");
      AppMethodBeat.o(343201);
      return null;
    }
    AppMethodBeat.o(343201);
    return localf;
  }
  
  public final boolean ebw()
  {
    return false;
  }
  
  public final RecyclerView.m ebz()
  {
    return this.ATp;
  }
  
  public final int edC()
  {
    return 2;
  }
  
  public final void eeU() {}
  
  public final void f(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(343287);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.as)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject1).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).fou();
    ak localak = ak.ECS;
    Object localObject2 = getContext();
    kotlin.g.b.s.s(localObject2, "context");
    localObject2 = (Context)localObject2;
    bh localbh = bh.ABm;
    ak.a(localak, (Context)localObject2, (bui)localObject1, paramBaseFinderFeed, bh.dVr(), paramBaseFinderFeed.isDeepEnjoy);
    localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (paramBaseFinderFeed == null) {
      paramBaseFinderFeed = "";
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.api.m.Axk;
      com.tencent.mm.plugin.finder.api.d.a.et(paramBaseFinderFeed, com.tencent.mm.plugin.finder.api.m.dUG());
      AppMethodBeat.o(343287);
      return;
      localObject1 = paramBaseFinderFeed.getUsername();
      paramBaseFinderFeed = (BaseFinderFeed)localObject1;
      if (localObject1 == null) {
        paramBaseFinderFeed = "";
      }
    }
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(166776);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.aa localaa = com.tencent.mm.plugin.finder.report.aa.Fsi;
      com.tencent.mm.plugin.finder.report.aa.eMZ();
    }
    AppMethodBeat.o(166776);
  }
  
  public final MMActivity getActivity()
  {
    return (MMActivity)this;
  }
  
  public final int getCommentScene()
  {
    return 6;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_feed_search_ui;
  }
  
  public final com.tencent.mm.plugin.finder.video.l getVideoCore()
  {
    return this.AJn;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(343189);
    Set localSet = ar.setOf(new Class[] { ag.class, az.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, com.tencent.mm.plugin.finder.viewmodel.component.f.class, com.tencent.mm.plugin.finder.viewmodel.component.c.class, ae.class });
    AppMethodBeat.o(343189);
    return localSet;
  }
  
  public final boolean isHideStatusBar()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(343206);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.f localf2 = this.ATy;
    com.tencent.mm.plugin.finder.view.f localf1 = localf2;
    if (localf2 == null)
    {
      kotlin.g.b.s.bIx("drawer");
      localf1 = null;
    }
    localf1.g(paramInt1, paramIntent);
    AppMethodBeat.o(343206);
  }
  
  public final void onBackPressed()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166791);
    com.tencent.mm.plugin.finder.view.f localf = this.ATy;
    Object localObject1 = localf;
    if (localf == null)
    {
      kotlin.g.b.s.bIx("drawer");
      localObject1 = null;
    }
    if (((com.tencent.mm.plugin.finder.view.f)localObject1).fkp())
    {
      localObject1 = this.ATy;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("drawer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.finder.view.f)localObject1).fdh();
        AppMethodBeat.o(166791);
        return;
      }
    }
    if (ebF().fkp())
    {
      ebF().fdh();
      AppMethodBeat.o(166791);
      return;
    }
    finish();
    AppMethodBeat.o(166791);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(166773);
    hideVKB();
    finish();
    AppMethodBeat.o(166773);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(166774);
    hideVKB();
    finish();
    AppMethodBeat.o(166774);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(166779);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(166779);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166771);
    super.onCreate(paramBundle);
    this.Bny = new FTSSearchView((Context)this);
    paramBundle = this.Bny;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle.setSearchViewListener((FTSSearchView.b)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search));
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().jBL();
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.findViewById(e.e.cancel_btn).setVisibility(8);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getSearchContainer().setBackground(null);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getSearchContainer().getLayoutParams();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(166771);
      throw paramBundle;
    }
    ((LinearLayout.LayoutParams)paramBundle).leftMargin = 0;
    paramBundle = this.Bny;
    Object localObject2;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
      localObject2 = (FrameLayout)findViewById(e.e.actionBarLayout);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      ((FrameLayout)localObject2).addView((View)paramBundle);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      i = paramBundle.getContext().getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_64);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().getEditText().setTextColor(i);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getSearchIcon().setIconColor(i);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().getClearBtn().getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      aNi();
      localObject2 = (MMActivity)this;
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getFtsEditText();
      kotlin.g.b.s.s(paramBundle, "searchView.ftsEditText");
      this.BnC = new l((MMActivity)localObject2, paramBundle, (kotlin.g.a.b)new q(this));
      paramBundle = this.BnC;
      if (paramBundle != null) {
        break label1266;
      }
      kotlin.g.b.s.bIx("searchSuggestionManager");
      paramBundle = null;
      label608:
      paramBundle.a((l.b)new r(this));
      paramBundle = com.tencent.mm.plugin.finder.view.f.GxF;
      paramBundle = (MMFragmentActivity)this;
      localObject1 = getWindow().getDecorView();
      kotlin.g.b.s.s(localObject1, "window.decorView");
      this.ATy = f.a.a(paramBundle, (View)localObject1, 2, false, 0, 24);
      paramBundle = FinderLikeDrawer.GAf;
      paramBundle = getContext();
      kotlin.g.b.s.s(paramBundle, "context");
      paramBundle = (Context)paramBundle;
      localObject1 = ((MMActivity)this).getWindow();
      kotlin.g.b.s.s(localObject1, "getActivity().window");
      localObject2 = FinderLikeDrawer.GAf;
      paramBundle = FinderLikeDrawer.a.a(paramBundle, (Window)localObject1, FinderLikeDrawer.fkM());
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.ATA = paramBundle;
      paramBundle = getContext().findViewById(e.e.rl_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)paramBundle);
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      this.mkw = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(e.e.no_result_tv);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.BnA = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(e.e.loading_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.njN = paramBundle;
      this.Fwv = ((TextView)getContext().findViewById(e.e.search_hot_word_change_tips_tv));
      localObject3 = new FinderLinearLayoutManager((Context)this);
      ((FinderLinearLayoutManager)localObject3).GGx = 25.0F;
      ((FinderLinearLayoutManager)localObject3).xwJ = 100;
      eOE();
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1269;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label900:
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject3);
      localObject2 = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new d(this), (ArrayList)this.Fwa);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1272;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label953:
      paramBundle.setAdapter((RecyclerView.a)localObject2);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1275;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label979:
      paramBundle.a((RecyclerView.l)this.Fwt);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      if (!(paramBundle instanceof FinderRecyclerView)) {
        break label1278;
      }
    }
    label1266:
    label1269:
    label1272:
    label1275:
    label1278:
    for (paramBundle = (FinderRecyclerView)paramBundle;; paramBundle = null)
    {
      if (paramBundle != null) {
        paramBundle.a((LinearLayoutManager)localObject3);
      }
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setHasFixedSize(true);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setItemViewCacheSize(5);
      localObject1 = this.BnA;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramBundle = null;
      }
      paramBundle.setTextColor(getResources().getColor(e.b.hot_tab_BW93));
      ((TouchableLayout)findViewById(e.e.uiContainer)).setBackgroundColor(getResources().getColor(e.b.full_black));
      ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(0);
      ((LinearLayout)findViewById(e.e.back_button)).setOnClickListener(new FinderFeedSearchUI..ExternalSyntheticLambda0(this));
      i = (int)getContext().getResources().getDimension(e.c.Edge_2A);
      int j = bf.getStatusBarHeight((Context)getContext());
      i += bf.fs((Context)getContext()) + j;
      paramBundle = ((ListView)findViewById(e.e.history_lv)).getLayoutParams();
      if (paramBundle != null) {
        break label1283;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(166771);
      throw paramBundle;
      break;
      break label608;
      break label900;
      break label953;
      break label979;
    }
    label1283:
    ((FrameLayout.LayoutParams)paramBundle).topMargin = i;
    paramBundle = ((ListView)findViewById(e.e.suggestion_lv)).getLayoutParams();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(166771);
      throw paramBundle;
    }
    ((FrameLayout.LayoutParams)paramBundle).topMargin = i;
    ((ListView)findViewById(e.e.history_lv)).setTag(Boolean.TRUE);
    paramBundle = getWindow().getDecorView();
    kotlin.g.b.s.s(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x400 | 0x100);
    getWindow().setStatusBarColor(0);
    getController().s((Activity)this, getResources().getColor(e.b.transparent));
    com.tencent.mm.ui.c.h((Activity)this, false);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      paramBundle.hide();
    }
    int i = bf.getStatusBarHeight((Context)this);
    ((FrameLayout)findViewById(e.e.full_actionbar)).setPadding(0, i, 0, 0);
    paramBundle = com.tencent.mm.plugin.finder.utils.av.GiL;
    paramBundle = getWindow();
    kotlin.g.b.s.s(paramBundle, "window");
    com.tencent.mm.plugin.finder.utils.av.d(paramBundle);
    setNavigationbarColor(getResources().getColor(e.b.black));
    Object localObject3 = new com.tencent.mm.plugin.finder.ui.e();
    Object localObject1 = this.mkw;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
    }
    ((com.tencent.mm.plugin.finder.ui.e)localObject3).a(paramBundle);
    paramBundle = this.ATx;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      localObject1 = com.tencent.mm.ui.af.mU((Context)getContext()).inflate(e.f.search_feed_load_more_footer, null);
      kotlin.g.b.s.s(localObject1, "getInflater(context).inf…d_load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener(new FinderFeedSearchUI..ExternalSyntheticLambda2(this));
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label3064;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      label1672:
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new m(this));
      localObject3 = this.query;
      if (localObject3 != null)
      {
        localObject1 = this.BnC;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchSuggestionManager");
          paramBundle = null;
        }
        paramBundle.aAj((String)localObject3);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().bCt((String)localObject3);
      }
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.pyl, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
      kotlin.g.b.s.s(paramBundle, "UICProvider.of(this@Find…rReporterUIC::class.java)");
      localObject3 = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)paramBundle);
      if (localObject3 != null)
      {
        localObject1 = this.mkw;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          paramBundle = null;
        }
        ((com.tencent.mm.plugin.finder.event.base.f)localObject3).o(paramBundle);
      }
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
      kotlin.g.b.s.s(paramBundle, "UICProvider.of(this@Find…rReporterUIC::class.java)");
      paramBundle = ((bn)paramBundle).Vm(-1);
      if (paramBundle != null) {
        paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)new b());
      }
      this.Fws.alive();
      ecL().a(2, 6, (kotlin.g.a.b)new n(this));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
      kotlin.g.b.s.s(paramBundle, "UICProvider.of(this@Find…rReporterUIC::class.java)");
      paramBundle = ((bn)paramBundle).Vm(-1);
      if (paramBundle != null) {
        paramBundle.a((com.tencent.mm.plugin.finder.event.base.d)ecL());
      }
      localObject3 = ecM();
      kotlin.g.a.m localm = (kotlin.g.a.m)new o(this);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      ((com.tencent.mm.plugin.findersdk.a.as)localObject3).a(localm, paramBundle);
      paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramBundle = getContext();
      kotlin.g.b.s.s(paramBundle, "context");
      paramBundle = as.a.hu((Context)paramBundle);
      if (paramBundle != null)
      {
        paramBundle = ((bn)paramBundle).Vm(-1);
        if (paramBundle != null) {
          paramBundle.a(ecM().edV());
        }
      }
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      localObject3 = (com.tencent.mm.plugin.finder.viewmodel.component.t)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.t.class);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      ((com.tencent.mm.plugin.finder.viewmodel.component.t)localObject3).E(paramBundle);
      this.Fwo = ((IListener)new IListener((WxRecyclerAdapter)localObject2)
      {
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements kotlin.g.a.a<ah>
        {
          a(if paramif, FinderFeedSearchUI paramFinderFeedSearchUI, WxRecyclerAdapter<cc> paramWxRecyclerAdapter)
          {
            super();
          }
        }
      });
      paramBundle = this.Fwo;
      if (paramBundle != null) {
        paramBundle.alive();
      }
      com.tencent.mm.plugin.finder.video.l.a(this.AJn, (AppCompatActivity)this, (com.tencent.mm.plugin.finder.video.l.b)new s(this), 4);
      localObject2 = getIntent().getStringExtra("key_search_query");
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = this.BnC;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchSuggestionManager");
          paramBundle = null;
        }
        kotlin.g.b.s.checkNotNull(localObject2);
        paramBundle.aAj((String)localObject2);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().bCt((String)localObject2);
        paramBundle = getIntent().getByteArrayExtra("key_search_session_buffer");
        if (paramBundle != null) {
          this.Fwh = new com.tencent.mm.bx.b(paramBundle);
        }
        this.Fwf = ((SearchHotWordListParcelable)getIntent().getParcelableExtra("key_search_hot_word_info"));
        paramBundle = getIntent().getByteArrayExtra("key_search_hot_word_buffer");
        if (paramBundle != null) {
          this.Fwg = new com.tencent.mm.bx.b(paramBundle);
        }
        Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("searchHotWordList: ", this.Fwf));
        this.ADh = true;
        this.Fwb = 6;
        if (getIntent().getBooleanExtra("key_search_is_from_feed_list", false))
        {
          this.Fwb = 5;
          paramBundle = new JSONObject();
          paramBundle.put("feedid", com.tencent.mm.ae.d.hF(getIntent().getLongExtra("key_search_feed_id", 0L)));
          paramBundle.put("requestid", this.hOG);
          paramBundle.put("query_word", localObject2);
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          paramBundle = paramBundle.toString();
          kotlin.g.b.s.s(paramBundle, "kvJson.toString()");
          localObject1 = kotlin.n.n.bV(paramBundle, ",", ";");
          paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
          paramBundle = getContext();
          kotlin.g.b.s.s(paramBundle, "context");
          paramBundle = as.a.hu((Context)paramBundle);
          if (paramBundle != null) {
            break label3067;
          }
          paramBundle = null;
          label2586:
          com.tencent.mm.plugin.finder.report.z.b(1, "hotsearch_timelinespot", (String)localObject1, paramBundle);
        }
        if (getIntent().getBooleanExtra("key_search_is_from_wx_global_search", false))
        {
          this.ADh = false;
          this.Fwb = 0;
          eOG();
        }
        paramBundle = com.tencent.mm.plugin.finder.report.j.Fpm;
        com.tencent.mm.plugin.finder.report.j.Se(hashCode());
        a((String)localObject2, this.Fwh, this.ADh, true);
        localObject1 = this.BnB;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("historyLogic");
          paramBundle = null;
        }
        paramBundle.azd((String)localObject2);
        if (this.Fwf == null)
        {
          paramBundle = new bux();
          paramBundle.aacq = ((String)localObject2);
          paramBundle.ZRe = this.Fwh;
          paramBundle.actionType = 1;
          ua(false);
        }
        if (!eOA())
        {
          if (this.Fwi == null)
          {
            paramBundle = com.tencent.mm.ui.af.mU((Context)getContext()).inflate(e.f.hot_search_info_title, null);
            this.Fwk = paramBundle.findViewById(e.e.hot_search_title_arrow);
            this.Fwj = ((TextView)paramBundle.findViewById(e.e.hot_search_title_text));
            this.Fwl = paramBundle.findViewById(e.e.hot_search_title_container);
            localObject1 = paramBundle.getContext();
            kotlin.g.b.s.s(localObject1, "context");
            this.Fwn = new b((Context)localObject1);
            localObject1 = this.Fwj;
            if (localObject1 != null) {
              com.tencent.mm.ui.aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
            }
            localObject1 = this.Fwl;
            if (localObject1 != null) {
              ((View)localObject1).setOnClickListener(new FinderFeedSearchUI..ExternalSyntheticLambda1(this, paramBundle));
            }
            kotlin.g.b.s.s(paramBundle, "getInflater(context).inf…          }\n            }");
            this.Fwi = paramBundle;
          }
          paramBundle = this.Fwi;
          if (paramBundle != null)
          {
            ((FrameLayout)findViewById(e.e.actionBarLayout)).removeAllViews();
            localObject1 = new FrameLayout.LayoutParams(-1, -2);
            ((FrameLayout.LayoutParams)localObject1).setMarginEnd((int)getResources().getDimension(e.c.Edge_5A));
            ((FrameLayout)findViewById(e.e.actionBarLayout)).addView(paramBundle, (ViewGroup.LayoutParams)localObject1);
          }
        }
        aAc((String)localObject2);
      }
      paramBundle = com.tencent.mm.plugin.finder.preload.f.EUC;
      if (com.tencent.mm.plugin.finder.preload.f.eHI())
      {
        paramBundle = com.tencent.mm.ui.component.k.aeZF;
        paramBundle = getContext();
        kotlin.g.b.s.s(paramBundle, "context");
        localObject1 = (com.tencent.mm.plugin.finder.viewmodel.component.c)com.tencent.mm.ui.component.k.d(paramBundle).q(com.tencent.mm.plugin.finder.viewmodel.component.c.class);
        localObject2 = this.Fwa;
        localObject3 = this.AJn;
        paramBundle = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
        paramBundle = as.a.hu((Context)this);
        if (paramBundle != null) {
          break label3075;
        }
      }
    }
    label3075:
    for (paramBundle = null;; paramBundle = ((bn)paramBundle).Vm(-1))
    {
      ((com.tencent.mm.plugin.finder.viewmodel.component.c)localObject1).a((DataBuffer)localObject2, 0, (com.tencent.mm.plugin.finder.video.l)localObject3, paramBundle, -1);
      this.ATr = ((com.tencent.mm.pluginsdk.q)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.q.class)).iGI();
      AppMethodBeat.o(166771);
      return;
      break;
      label3064:
      break label1672;
      label3067:
      paramBundle = paramBundle.fou();
      break label2586;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166787);
    Object localObject1 = k.FxZ;
    k.ePf().clear();
    Object localObject3 = this.BnB;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("historyLogic");
      localObject1 = null;
    }
    ((j)localObject1).onDestroy();
    com.tencent.mm.plugin.finder.storage.data.f.FMT.clearCache();
    this.Fws.dead();
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    hideVKB();
    ecL().onDetach();
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(this@Find…rReporterUIC::class.java)");
    localObject1 = ((bn)localObject1).Vm(-1);
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b((com.tencent.mm.plugin.finder.event.base.d)ecL());
    }
    ecM().onDetach();
    localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    localObject1 = as.a.hu((Context)localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((bn)localObject1).Vm(-1);
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject1).b(ecM().edV());
      }
    }
    localObject1 = this.Fwo;
    if (localObject1 != null) {
      ((IListener)localObject1).dead();
    }
    localObject3 = this.ATy;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("drawer");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.view.f)localObject1).onDetach();
    localObject1 = this.mkw;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((RecyclerView)localObject1).b((RecyclerView.l)this.Fwt);
      super.onDestroy();
      AppMethodBeat.o(166787);
      return;
    }
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(166775);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (Util.isNullOrNil(paramString1))
      {
        paramd = this.njN;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("loadingView");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
        paramd = this.BnA;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("noResultView");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
        paramd = this.ATx;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
      }
      paramString2 = this.BnB;
      if (paramString2 != null) {
        break label160;
      }
      kotlin.g.b.s.bIx("historyLogic");
      paramString2 = paramList;
    }
    label160:
    for (;;)
    {
      paramString2.aAg(paramString1);
      AppMethodBeat.o(166775);
      return;
      paramString2 = kotlin.n.n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178406);
    super.onPause();
    if (this.ATy == null) {
      kotlin.g.b.s.bIx("drawer");
    }
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwP, "6", com.tencent.mm.plugin.finder.live.report.d.Dng);
    l locall2 = this.BnC;
    l locall1 = locall2;
    if (locall2 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      locall1 = null;
    }
    locall1.onActivityPause();
    this.nmW.gR(false);
    if (this.ATr == null) {
      kotlin.g.b.s.bIx("quickMenuHelper");
    }
    AppMethodBeat.o(178406);
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(178405);
    super.onResume();
    Object localObject3 = this.ATy;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("drawer");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.finder.view.f)localObject1).onUIResume();
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwP, "6", com.tencent.mm.plugin.finder.live.report.d.Dnf);
    if (!this.FvW)
    {
      localObject3 = this.mkw;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).post(new FinderFeedSearchUI..ExternalSyntheticLambda13(this));
      localObject3 = this.BnC;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("searchSuggestionManager");
        localObject1 = null;
      }
      ((l)localObject1).onActivityResume();
      com.tencent.mm.model.d.a(this.nmW, "Finder.FinderFeedSearchUI");
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label176;
      }
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = localObject2;
    }
    label176:
    for (;;)
    {
      ((RecyclerView)localObject1).post(new FinderFeedSearchUI..ExternalSyntheticLambda12(this));
      AppMethodBeat.o(178405);
      return;
      this.FvW = false;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(166789);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    int j = this.Fwa.size();
    int i = this.Fwa.size();
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramp instanceof dk))
    {
      if (((dk)paramp).rsE) {
        bool1 = true;
      }
      if (kotlin.g.b.s.p(this.Fwq, paramp))
      {
        this.Fwr = false;
        Log.i("Finder.FinderFeedSearchUI", "onSceneEnd: MMFunc_FinderSearch scene:" + paramp + "  preloadNetSceneFinderSearch:" + this.Fwq + " netSceneFinderSearch:" + this.BnD + ' ');
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1593;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 7L, 1L, false);
        if (!(paramp instanceof dk)) {
          break label251;
        }
        paramString = (dk)paramp;
        label173:
        if (paramString != null) {
          break label256;
        }
      }
    }
    label256:
    for (Object localObject2 = null;; localObject2 = paramString.ADk)
    {
      if (localObject2 != null) {
        break label265;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(166789);
      throw paramString;
      bool2 = bool1;
      if (kotlin.g.b.s.p(this.BnD, paramp))
      {
        bool2 = bool1;
        if (((dk)paramp).rsE)
        {
          this.Fwr = false;
          bool2 = bool1;
        }
      }
      bool1 = bool2;
      break;
      label251:
      paramString = null;
      break label173;
    }
    label265:
    paramString = ((bva)localObject2).AdW;
    kotlin.g.b.s.s(paramString, "response.objectList");
    paramString = (Iterable)paramString;
    Object localObject4 = (Collection)new ArrayList(kotlin.a.p.a(paramString, 10));
    Iterator localIterator = paramString.iterator();
    label362:
    label370:
    Object localObject1;
    label385:
    label395:
    Object localObject3;
    if (localIterator.hasNext())
    {
      paramString = (FinderObject)localIterator.next();
      kotlin.g.b.s.s(paramString, "it");
      q(paramString);
      long l2 = paramString.id;
      if ((paramp instanceof dk))
      {
        paramString = (dk)paramp;
        if (paramString != null) {
          break label464;
        }
        paramString = "";
        if (!(paramp instanceof dk)) {
          break label485;
        }
        localObject1 = (dk)paramp;
        if (localObject1 != null) {
          break label491;
        }
        localObject1 = "";
        localObject3 = ((bva)localObject2).aacC;
        if (localObject3 != null) {
          break label515;
        }
      }
      label515:
      for (long l1 = 0L;; l1 = ((bux)localObject3).aacs)
      {
        ((Map)this.Fwe).put(Long.valueOf(l2), new FinderFeedSearchUI.c(l2, paramString, (String)localObject1, com.tencent.mm.ae.d.hF(l1)));
        ((Collection)localObject4).add(ah.aiuX);
        break;
        paramString = null;
        break label362;
        label464:
        localObject1 = paramString.query;
        paramString = (String)localObject1;
        if (localObject1 != null) {
          break label370;
        }
        paramString = "";
        break label370;
        label485:
        localObject1 = null;
        break label385;
        label491:
        localObject3 = ((dk)localObject1).hOG;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break label395;
        }
        localObject1 = "";
        break label395;
      }
    }
    Log.w("Finder.FinderFeedSearchUI", "onSceneEnd: MMFunc_FinderSearch scene:" + paramp + " size:" + ((bva)localObject2).AdW.size());
    if (((bva)localObject2).AdW.size() == 0)
    {
      Log.w("Finder.FinderFeedSearchUI", "response objectList empty");
      label651:
      if (((bva)localObject2).continueFlag == 0)
      {
        if (!(paramp instanceof dk)) {
          break label1478;
        }
        paramString = (dk)paramp;
        label608:
        if (paramString != null)
        {
          paramString = paramString.ADj;
          if (paramString != null)
          {
            localObject1 = ((bva)localObject2).AdW;
            kotlin.g.b.s.s(localObject1, "response.objectList");
            if (((Collection)localObject1).isEmpty()) {
              break label1483;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label1488;
            }
            a(new com.tencent.mm.plugin.finder.model.af(new FinderItem(), b(paramString)));
          }
        }
      }
      label678:
      this.offset = ((bva)localObject2).offset;
      this.continueFlag = ((bva)localObject2).continueFlag;
      this.BgS = ((bva)localObject2).BgS;
      i = this.Fwa.size();
      localObject1 = new StringBuilder("onSceneEnd ").append(bool1).append(' ').append(((bva)localObject2).offset).append(' ').append(((bva)localObject2).continueFlag).append(' ').append(this.Fwa.size()).append(' ');
      if (!(paramp instanceof dk)) {
        break label1514;
      }
      paramString = (dk)paramp;
      label791:
      if (paramString != null) {
        break label1519;
      }
      paramString = null;
      label797:
      Log.i("Finder.FinderFeedSearchUI", paramString);
      if (!(paramp instanceof dk)) {
        break label1541;
      }
      paramString = (dk)paramp;
      label826:
      if (paramString != null) {
        break label1546;
      }
      paramString = null;
      label832:
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = this.query;
      }
      if (!(paramp instanceof dk)) {
        break label1554;
      }
      paramString = (dk)paramp;
      label859:
      if (paramString != null) {
        break label1559;
      }
      paramString = null;
      label865:
      localObject3 = paramString;
      if (paramString == null) {
        localObject3 = this.hOG;
      }
      if (!(paramp instanceof dk)) {
        break label1567;
      }
      paramString = (dk)paramp;
      label892:
      if (paramString != null) {
        break label1572;
      }
      paramInt1 = 1;
      label898:
      if (!((bva)localObject2).AdW.isEmpty()) {
        break label1580;
      }
      paramInt2 = 1;
      label911:
      paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = com.tencent.mm.plugin.finder.report.z.eMW();
      paramString = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramString = getContext();
      kotlin.g.b.s.s(paramString, "context");
      paramString = as.a.hu((Context)paramString);
      if (paramString != null) {
        break label1585;
      }
      paramString = null;
      label954:
      com.tencent.mm.plugin.finder.report.z.a((String)localObject2, (String)localObject3, (String)localObject1, 3, paramInt1, 2, 0, paramInt2, paramString);
      paramInt1 = i;
      label972:
      if (kotlin.g.b.s.p(this.Fwq, paramp)) {
        this.Fwq = null;
      }
      if (kotlin.g.b.s.p(this.BnD, paramp)) {
        this.BnD = null;
      }
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.aFW(paramInt1);
      if (paramInt1 != 0) {
        break label1613;
      }
      paramp = this.njN;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString = null;
      }
      paramString.setVisibility(8);
      paramp = this.BnA;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString = null;
      }
      paramString.setVisibility(0);
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.setVisibility(8);
      label1120:
      if (j != 0) {
        break label1699;
      }
      paramp = this.mkw;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramString = null;
      }
      paramString = paramString.getAdapter();
      if (paramString != null)
      {
        paramString.bZE.notifyChanged();
        paramString = ah.aiuX;
      }
      label1167:
      paramString = com.tencent.mm.plugin.finder.report.j.Fpm;
      com.tencent.mm.plugin.finder.report.j.Sf(hashCode());
      if ((bool1) || (eOA())) {
        break label1797;
      }
      paramString = this.mkw;
      if (paramString != null) {
        break label1753;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramString = null;
    }
    label1289:
    label1418:
    label1423:
    label1478:
    label1483:
    label1488:
    label1753:
    for (;;)
    {
      paramp = paramString.getLayoutManager();
      if (paramp != null) {
        break label1756;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(166789);
      throw paramString;
      if (!eOA())
      {
        paramString = ((bva)localObject2).aacC;
        if (paramString != null) {
          break label1410;
        }
        paramString = null;
        if (Util.isNullOrNil(paramString))
        {
          localObject3 = ((bva)localObject2).aacC;
          if (localObject3 != null)
          {
            if (!(paramp instanceof dk)) {
              break label1418;
            }
            paramString = (dk)paramp;
            if (paramString != null) {
              break label1423;
            }
            paramString = "";
          }
        }
      }
      for (;;)
      {
        ((bux)localObject3).aacq = paramString;
        a(((bva)localObject2).aacC);
        paramString = ((bva)localObject2).AdW;
        kotlin.g.b.s.s(paramString, "response.objectList");
        localObject1 = (Iterable)paramString;
        paramString = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (FinderObject)((Iterator)localObject1).next();
          localObject4 = FinderItem.Companion;
          kotlin.g.b.s.s(localObject3, "it");
          paramString.add(FinderItem.a.e((FinderObject)localObject3, 16));
        }
        paramString = paramString.aacq;
        break;
        paramString = null;
        break label1289;
        localObject1 = paramString.query;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
      }
      paramString = (List)paramString;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.feed.jumper.i)com.tencent.mm.ui.component.k.cn(cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class)).F(paramString, 6);
      break;
      paramString = null;
      break label608;
      paramInt1 = 0;
      break label651;
      localObject1 = paramString.aacq;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      aAd(paramString);
      break label678;
      label1514:
      paramString = null;
      break label791;
      label1519:
      paramString = paramString.ADj;
      if (paramString == null)
      {
        paramString = null;
        break label797;
      }
      paramString = paramString.aacq;
      break label797;
      paramString = null;
      break label826;
      paramString = paramString.query;
      break label832;
      paramString = null;
      break label859;
      paramString = paramString.hOG;
      break label865;
      paramString = null;
      break label892;
      paramInt1 = paramString.xVf;
      break label898;
      paramInt2 = 2;
      break label911;
      paramString = paramString.fou();
      break label954;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 8L, 1L, false);
      paramInt1 = i;
      break label972;
      paramp = this.njN;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString = null;
      }
      paramString.setVisibility(8);
      paramp = this.BnA;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString = null;
      }
      paramString.setVisibility(8);
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.setVisibility(0);
      break label1120;
      if (j >= paramInt1) {
        break label1167;
      }
      paramp = this.mkw;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramString = null;
      }
      paramString = paramString.getAdapter();
      if (paramString == null) {
        break label1167;
      }
      paramString.bA(j, paramInt1 - j);
      paramString = ah.aiuX;
      break label1167;
    }
    label1410:
    label1541:
    label1546:
    label1554:
    label1559:
    label1567:
    label1572:
    label1580:
    label1585:
    label1593:
    label1613:
    label1756:
    paramInt1 = ((FinderLinearLayoutManager)paramp).Jw() + 1;
    label1699:
    Log.i("Finder.FinderFeedSearchUI", kotlin.g.b.s.X("[smoothScrollToNextPosition] nextPosition=", Integer.valueOf(paramInt1)));
    paramString.post(new FinderFeedSearchUI..ExternalSyntheticLambda11(paramString, paramInt1));
    label1797:
    AppMethodBeat.o(166789);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(343252);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(343252);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$Companion;", "", "()V", "HOT_SEARCH_DEFAULT", "", "HOT_SEARCH_FEED", "HOT_SEARCH_PAGE", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public b()
    {
      AppMethodBeat.i(342310);
      AppMethodBeat.o(342310);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166748);
      kotlin.g.b.s.u(paramb, "event");
      int i;
      int j;
      if (((paramb instanceof com.tencent.mm.plugin.finder.event.base.h)) && ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 1)))
      {
        i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOr;
        j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOt;
        if (i > j) {}
      }
      for (;;)
      {
        if ((i < FinderFeedSearchUI.s(this.FwC).size()) && (i >= 0)) {
          FinderFeedSearchUI.a(this.FwC, ((cc)FinderFeedSearchUI.s(this.FwC).get(i)).bZA(), i);
        }
        if (i == j)
        {
          AppMethodBeat.o(166748);
          return;
        }
        i += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.recyclerview.g
  {
    d(FinderFeedSearchUI paramFinderFeedSearchUI) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(166749);
      switch (paramInt)
      {
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(166749);
        return localf;
      case 4: 
      case 3002: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.t(FinderFeedSearchUI.C(this.FwC), (com.tencent.mm.plugin.finder.feed.i)this.FwC, false, 0, 12);
        AppMethodBeat.o(166749);
        return localf;
      case 2: 
      case 3001: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.q((com.tencent.mm.plugin.finder.feed.i)this.FwC, false, 0, 6);
        AppMethodBeat.o(166749);
        return localf;
      case 9: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.r(FinderFeedSearchUI.C(this.FwC), (com.tencent.mm.plugin.finder.feed.i)this.FwC, 0, 0, 28);
        AppMethodBeat.o(166749);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.ck();
      AppMethodBeat.o(166749);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.i>
  {
    e(FinderFeedSearchUI paramFinderFeedSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.findersdk.a.as>
  {
    f(FinderFeedSearchUI paramFinderFeedSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$getHotSearchList$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.am.h
  {
    g(FinderFeedSearchUI paramFinderFeedSearchUI) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      bux localbux = null;
      AppMethodBeat.i(342313);
      int i;
      Object localObject;
      label135:
      label171:
      boolean bool;
      if ((paramp != null) && (paramp.getType() == 4069))
      {
        i = 1;
        if (i != 0)
        {
          com.tencent.mm.kernel.h.aZW().b(4069, (com.tencent.mm.am.h)this);
          if ((paramp instanceof dw))
          {
            Log.i("Finder.FinderFeedSearchUI", "getHotSearchList onSceneEnd errType:" + paramInt1 + " isPreload:" + ((dw)paramp).rsE + " hotWords:" + ((dw)paramp).dWH());
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label281;
            }
            localObject = this.FwC;
            paramString = ((dw)paramp).ADG;
            if (paramString != null) {
              break label223;
            }
            paramString = null;
            FinderFeedSearchUI.a((FinderFeedSearchUI)localObject, paramString);
            localObject = ((dw)paramp).dWH();
            FinderFeedSearchUI.a(this.FwC, (LinkedList)localObject);
            FinderFeedSearchUI localFinderFeedSearchUI = this.FwC;
            if (localObject != null) {
              break label231;
            }
            if (((dw)paramp).rsE) {
              break label275;
            }
            bool = true;
            label185:
            FinderFeedSearchUI.a(localFinderFeedSearchUI, localbux, (LinkedList)localObject, bool);
          }
        }
      }
      for (;;)
      {
        FinderFeedSearchUI.a(this.FwC, false);
        FinderFeedSearchUI.i(this.FwC);
        AppMethodBeat.o(342313);
        return;
        i = 0;
        break;
        label223:
        paramString = paramString.aacm;
        break label135;
        label231:
        if (((LinkedList)localObject).size() > 0)
        {
          paramInt1 = 1;
          label241:
          if (paramInt1 == 0) {
            break label270;
          }
        }
        label270:
        for (paramString = (String)localObject;; paramString = null)
        {
          if (paramString == null) {
            break label273;
          }
          localbux = (bux)paramString.get(0);
          break;
          paramInt1 = 0;
          break label241;
        }
        label273:
        break label171;
        label275:
        bool = false;
        break label185;
        label281:
        if ((!((dw)paramp).rsE) || (FinderFeedSearchUI.g(this.FwC))) {
          FinderFeedSearchUI.h(this.FwC);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "userName", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    h(FinderFeedSearchUI paramFinderFeedSearchUI, MenuItem paramMenuItem, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "subType", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Integer, List<? extends Long>>
  {
    i(FinderFeedSearchUI paramFinderFeedSearchUI, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class initContentView$7$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    initContentView$7$a(if paramif, FinderFeedSearchUI paramFinderFeedSearchUI, WxRecyclerAdapter<cc> paramWxRecyclerAdapter)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    j(FinderFullSeekBarLayout paramFinderFullSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$getMoreMenuItemSelectedListener$1$8", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.plugin.findersdk.a.ck<bpu>
  {
    k(FinderFeedSearchUI paramFinderFeedSearchUI) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$getMoreMenuItemSelectedListener$1$9", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModFeedSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.plugin.findersdk.a.ck<bpu>
  {
    l(FinderFeedSearchUI paramFinderFeedSearchUI) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    m(FinderFeedSearchUI paramFinderFeedSearchUI) {}
    
    public final void ND(int paramInt)
    {
      AppMethodBeat.i(342384);
      if ((this.ATC) && (paramInt > 0))
      {
        Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.FwC).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class);
        kotlin.g.b.s.s(localObject1, "UICProvider.of(this@Find…rReporterUIC::class.java)");
        Object localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.b((com.tencent.mm.plugin.finder.viewmodel.component.as)localObject1);
        if (localObject2 != null)
        {
          localObject1 = this.FwC;
          RecyclerView.l locall = ((com.tencent.mm.plugin.finder.event.base.f)localObject2).dYJ();
          localObject2 = FinderFeedSearchUI.r((FinderFeedSearchUI)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("recyclerView");
            localObject1 = null;
          }
          locall.onScrollStateChanged((RecyclerView)localObject1, 5);
        }
        this.ATC = false;
      }
      AppMethodBeat.o(342384);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(342369);
      kotlin.g.b.s.u(paramd, "reason");
      Log.i("Finder.FinderFeedSearchUI", "onLoadMoreEnd");
      AppMethodBeat.o(342369);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(342359);
      Log.i("Finder.FinderFeedSearchUI", "onLoadMoreBegin");
      Object localObject;
      if (FinderFeedSearchUI.u(this.FwC))
      {
        if (FinderFeedSearchUI.v(this.FwC) != null)
        {
          localObject = this.FwC;
          FinderFeedSearchUI.w((FinderFeedSearchUI)localObject);
          FinderFeedSearchUI.x((FinderFeedSearchUI)localObject);
          AppMethodBeat.o(342359);
        }
      }
      else
      {
        localObject = FinderFeedSearchUI.v(this.FwC);
        if (localObject != null)
        {
          FinderFeedSearchUI localFinderFeedSearchUI = this.FwC;
          if (FinderFeedSearchUI.y(localFinderFeedSearchUI) == 1)
          {
            FinderFeedSearchUI.b(localFinderFeedSearchUI, (String)localObject);
            AppMethodBeat.o(342359);
            return;
          }
          if (FinderFeedSearchUI.b(localFinderFeedSearchUI))
          {
            FinderFeedSearchUI.x(localFinderFeedSearchUI);
            AppMethodBeat.o(342359);
            return;
          }
          if (FinderFeedSearchUI.z(localFinderFeedSearchUI) == 1)
          {
            FinderFeedSearchUI.a(localFinderFeedSearchUI);
            AppMethodBeat.o(342359);
            return;
          }
          if ((FinderFeedSearchUI.z(localFinderFeedSearchUI) == 0) && (FinderFeedSearchUI.A(localFinderFeedSearchUI) == null) && (FinderFeedSearchUI.B(localFinderFeedSearchUI)))
          {
            Log.i("Finder.FinderFeedSearchUI", "onLoadMoreBegin wait for onGetList");
            FinderFeedSearchUI.a(localFinderFeedSearchUI, true);
            AppMethodBeat.o(342359);
            return;
          }
          FinderFeedSearchUI.h(localFinderFeedSearchUI);
        }
      }
      AppMethodBeat.o(342359);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<Integer, cc>
  {
    n(FinderFeedSearchUI paramFinderFeedSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.m<Integer, Integer, LinkedList<cc>>
  {
    o(FinderFeedSearchUI paramFinderFeedSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    p(FinderFeedSearchUI paramFinderFeedSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "suggestion", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    q(FinderFeedSearchUI paramFinderFeedSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initSuggestion$2", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "onVisibleChange", "", "visibility", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    implements l.b
  {
    r(FinderFeedSearchUI paramFinderFeedSearchUI) {}
    
    public final void Oh(int paramInt)
    {
      Object localObject2 = null;
      FTSSearchView localFTSSearchView = null;
      AppMethodBeat.i(342707);
      if (paramInt == 0)
      {
        localObject2 = FinderFeedSearchUI.o(this.FwC);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("loadingView");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(8);
        localObject2 = FinderFeedSearchUI.p(this.FwC);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("noResultView");
          localObject1 = null;
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = FinderFeedSearchUI.q(this.FwC);
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject1 = localFTSSearchView;
        }
        for (;;)
        {
          ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
          AppMethodBeat.o(342707);
          return;
        }
      }
      localFTSSearchView = FinderFeedSearchUI.j(this.FwC);
      Object localObject1 = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        kotlin.g.b.s.bIx("searchView");
        localObject1 = null;
      }
      if (!Util.isNullOrNil(((FTSSearchView)localObject1).getFtsEditText().getEditText().getText().toString()))
      {
        localObject1 = FinderFeedSearchUI.q(this.FwC);
        if (localObject1 != null) {
          break label179;
        }
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = localObject2;
      }
      label179:
      for (;;)
      {
        ((RefreshLoadMoreLayout)localObject1).setVisibility(0);
        AppMethodBeat.o(342707);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements com.tencent.mm.plugin.finder.video.l.b
  {
    s(FinderFeedSearchUI paramFinderFeedSearchUI) {}
    
    public final RecyclerView ebB()
    {
      AppMethodBeat.i(342713);
      RecyclerView localRecyclerView = FinderFeedSearchUI.r(this.FwC);
      if (localRecyclerView == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        AppMethodBeat.o(342713);
        return null;
      }
      AppMethodBeat.o(342713);
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
      AppMethodBeat.i(342740);
      DataBuffer localDataBuffer = FinderFeedSearchUI.s(this.FwC);
      AppMethodBeat.o(342740);
      return localDataBuffer;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    extends RecyclerView.l
  {
    t(FinderFeedSearchUI paramFinderFeedSearchUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(342706);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      int i;
      if ((paramInt == 0) && (!FinderFeedSearchUI.u(this.FwC)))
      {
        localObject = paramRecyclerView.getLayoutManager();
        if (localObject == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(342706);
          throw paramRecyclerView;
        }
        localObject = (LinearLayoutManager)localObject;
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView != null) {
          break label215;
        }
        paramInt = 0;
        i = ((LinearLayoutManager)localObject).Ju();
        int j = ((LinearLayoutManager)localObject).Jw();
        if (!FinderFeedSearchUI.D(this.FwC)) {
          break label223;
        }
        i = j;
      }
      label215:
      label223:
      for (;;)
      {
        if ((i != -1) && (paramInt - i <= 3))
        {
          Log.i("Finder.FinderFeedSearchUI", "startPreloadNextHotWord currentPos:" + i + " itemCount:" + paramInt);
          FinderFeedSearchUI.b(this.FwC, FinderFeedSearchUI.y(this.FwC));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(342706);
        return;
        paramInt = paramRecyclerView.getItemCount();
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(342712);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (!FinderFeedSearchUI.u(this.FwC))
      {
        FinderFeedSearchUI.a(this.FwC, paramRecyclerView, paramInt1, paramInt2);
        FinderFeedSearchUI.a(this.FwC, paramRecyclerView);
      }
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramRecyclerView, q.w.DwP, "6", com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(342712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderFeedSearchUI
 * JD-Core Version:    0.7.0.1
 */