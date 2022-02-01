package com.tencent.mm.plugin.finder.nearby.live;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bn;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.plugin.finder.viewmodel.n;
import com.tencent.mm.plugin.finder.viewmodel.n.f;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i.e;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "by_pass", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;)V", "autoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "getBy_pass", "()Ljava/lang/String;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "enableFoldFollowData", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "finderNearbyDataUpdateEventListener", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$finderNearbyDataUpdateEventListener$1", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$finderNearbyDataUpdateEventListener$1;", "finderNearbyRefreshEventListener", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$finderNearbyRefreshEventListener$1", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$finderNearbyRefreshEventListener$1;", "firstAttach", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "isFirstOnResume", "isFirstOnUserVisibleFocused", "isOnResume", "isOnUserVisibleFocused", "isRequestingLbs", "lastOnPauseHasPermission", "lastResponseBuffer", "nearbyRVPositionHelper", "Lcom/tencent/mm/plugin/finder/nearby/base/NearbyRVPositionHelper;", "nextPagePreload", "Lcom/tencent/mm/plugin/finder/nearby/preload/nextpage/NearbyNextPagePreload;", "refreshPullType", "", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "targetPageForceRefreshFlag", "getTargetPageForceRefreshFlag", "()Z", "setTargetPageForceRefreshFlag", "(Z)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/NearbyLivePreloadCacheVM;", "viewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "canTimelineRefresh", "checkAutoPlay", "checkCache", "invokeSource", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "checkPermission", "checkTryRequestFirstPageAgain", "createFeedLoader", "disposeRedDot", "fetchSubTabFeeds", "subTabInfo", "findFirstPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getAutoPlayManager", "getCommentScene", "getFileCacheFlag", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getMemoryCacheFlag", "getReportContextObj", "getTabType", "handleFluentSwitch", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "handleRecomRefreshFetchDone", "handleRequestNoPermission", "isEnableVoice", "onActionbarClick", "isDouble", "onAttach", "callback", "targetTabPageLastBuffer", "onDetach", "onFinishing", "onLoadMore", "onLoadMoreFollowFeed", "finderStreamCard", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "onRefresh", "onRefreshEnd", "reason", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "realRequestRefresh", "pullType", "objectId", "lastBuffer", "registerEvent", "requestFirstPage", "requestLocationPermission", "requestRefresh", "requestRefreshForPermission", "saveRefreshInterval", "storeMemoryCache", "unRegisterEvent", "Companion", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  implements b.a<cc>
{
  public static final a EIT;
  protected final bui Auc;
  private com.tencent.mm.bx.b BiQ;
  boolean EIU;
  public b.b<cc> EIV;
  private com.tencent.mm.plugin.finder.nearby.base.d EIW;
  private com.tencent.mm.plugin.finder.nearby.live.play.e EIX;
  NearbyLiveFeedLoader EIZ;
  private final String EIo;
  private int EIp;
  protected bnn EIq;
  private com.tencent.mm.bx.b EIt;
  private com.tencent.mm.view.k EJa;
  private boolean EJb;
  private final NearbyLivePresenter.finderNearbyDataUpdateEventListener.1 EJc;
  private final NearbyLivePresenter.finderNearbyRefreshEventListener.1 EJd;
  private final MMActivity activity;
  private com.tencent.mm.plugin.finder.model.g emptyData;
  private boolean firstAttach;
  protected Fragment fragment;
  private boolean isFirstOnResume;
  private boolean isFirstOnUserVisibleFocused;
  private boolean isOnResume;
  private boolean isOnUserVisibleFocused;
  private boolean isRequestingLbs;
  private boolean lastOnPauseHasPermission;
  private com.tencent.mm.plugin.finder.nearby.preload.nextpage.a nextPagePreload;
  private final n tlCache;
  
  static
  {
    AppMethodBeat.i(340893);
    EIT = new a((byte)0);
    AppMethodBeat.o(340893);
  }
  
  public e(MMActivity paramMMActivity, bui parambui, String paramString)
  {
    AppMethodBeat.i(340670);
    this.activity = paramMMActivity;
    this.Auc = parambui;
    this.EIo = paramString;
    paramMMActivity = com.tencent.mm.ui.component.k.aeZF;
    paramMMActivity = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(n.class);
    s.s(paramMMActivity, "UICProvider.of(PluginFin…eloadCacheVM::class.java)");
    this.tlCache = ((n)paramMMActivity);
    this.EJa = ((com.tencent.mm.view.k)new i(this));
    Log.i("Finder.NearbyLivePresenter", "#init");
    this.EJb = true;
    this.EJc = new NearbyLivePresenter.finderNearbyDataUpdateEventListener.1(this, com.tencent.mm.app.f.hfK);
    this.EJd = new NearbyLivePresenter.finderNearbyRefreshEventListener.1(this, com.tencent.mm.app.f.hfK);
    this.emptyData = new com.tencent.mm.plugin.finder.model.g();
    this.isFirstOnUserVisibleFocused = true;
    this.isFirstOnResume = true;
    AppMethodBeat.o(340670);
  }
  
  private final void Y(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(340746);
    if ((paramBoolean) && (this.tlCache.Rp(eEF())))
    {
      Log.w("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " return for checkCache:" + paramBoolean + " memoryCacheFlag:" + eEF());
      AppMethodBeat.o(340746);
      return;
    }
    if (!this.isOnResume)
    {
      Log.i("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " return for isOnResume:" + this.isOnResume + " memoryCacheFlag:" + eEF());
      AppMethodBeat.o(340746);
      return;
    }
    if (!this.isOnUserVisibleFocused)
    {
      Log.i("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " return for isOnUserVisibleFocused:" + this.isOnUserVisibleFocused + " memoryCacheFlag:" + eEF());
      AppMethodBeat.o(340746);
      return;
    }
    Log.i("Finder.NearbyLivePresenter", "checkAutoPlay " + paramString + " memoryCacheFlag:" + eEF());
    paramString = this.EIX;
    if (paramString != null) {
      paramString.eES();
    }
    AppMethodBeat.o(340746);
  }
  
  private void a(b.b<cc> paramb)
  {
    AppMethodBeat.i(340683);
    s.u(paramb, "<set-?>");
    this.EIV = paramb;
    AppMethodBeat.o(340683);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(340768);
    s.u(parame, "this$0");
    new RefreshLoadMoreLayout.d(0).agJs = -2;
    parame = parame.eEB().eEy();
    if (parame != null) {
      parame.Od(false);
    }
    AppMethodBeat.o(340768);
  }
  
  private static final void a(e parame, Boolean paramBoolean)
  {
    AppMethodBeat.i(340781);
    s.u(parame, "this$0");
    s.s(paramBoolean, "it");
    if (paramBoolean.booleanValue())
    {
      paramBoolean = parame.EIZ;
      s.checkNotNull(paramBoolean);
      paramBoolean.a(parame.eEF(), parame.eEE(), parame.EIq);
      AppMethodBeat.o(340781);
      return;
    }
    paramBoolean = new RefreshLoadMoreLayout.d(0);
    paramBoolean.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_no_more_content));
    paramBoolean.agJs = -2;
    ah localah = ah.aiuX;
    parame.checkEmptyHeader(paramBoolean);
    AppMethodBeat.o(340781);
  }
  
  private static final void a(WxRefreshLayout paramWxRefreshLayout)
  {
    AppMethodBeat.i(340773);
    paramWxRefreshLayout.autoRefresh();
    AppMethodBeat.o(340773);
  }
  
  private final void ayY(String paramString)
  {
    AppMethodBeat.i(340759);
    Log.i("Finder.NearbyLivePresenter", s.X("disposeRedDot from ", paramString));
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      localObject = this.EIq;
      if ((localObject != null) && (((bnn)localObject).ZVZ == 88889)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("Finder.NearbyLivePresenter", "disposeRedDot from " + paramString + " return for 同城直播.");
        AppMethodBeat.o(340759);
        return;
      }
    }
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    if (com.tencent.mm.plugin.finder.nearby.live.square.page.b.QN(getCommentScene()))
    {
      Log.i("Finder.NearbyLivePresenter", "disposeRedDot from " + paramString + " return for in operation game.");
      AppMethodBeat.o(340759);
      return;
    }
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL("NearbyLiveTab");
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().hH("NearbyLiveTab", paramString);
    AppMethodBeat.o(340759);
  }
  
  private static final void b(e parame, Boolean paramBoolean)
  {
    AppMethodBeat.i(370428);
    s.u(parame, "this$0");
    s.s(paramBoolean, "it");
    if (paramBoolean.booleanValue())
    {
      parame.checkTryRequestFirstPageAgain();
      AppMethodBeat.o(370428);
      return;
    }
    paramBoolean = new RefreshLoadMoreLayout.d(0);
    paramBoolean.agJt = ((CharSequence)MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_no_more_content));
    paramBoolean.agJs = -2;
    ah localah = ah.aiuX;
    parame.checkEmptyHeader(paramBoolean);
    AppMethodBeat.o(370428);
  }
  
  private final void checkEmptyHeader(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(340724);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramd, this));
    AppMethodBeat.o(340724);
  }
  
  private final void checkPermission()
  {
    AppMethodBeat.i(340729);
    com.tencent.mm.plugin.finder.nearby.live.base.a locala = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
    if ((com.tencent.mm.plugin.finder.nearby.live.base.a.a("checkOnPauseDataIsEmpty", this.EIq, getCommentScene())) && (((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, d.a.acsO))) {}
    for (boolean bool = true;; bool = false)
    {
      this.lastOnPauseHasPermission = bool;
      AppMethodBeat.o(340729);
      return;
    }
  }
  
  private final void checkTryRequestFirstPageAgain()
  {
    AppMethodBeat.i(340741);
    if (!this.isOnResume)
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for isOnResume:" + this.isOnResume + " memoryCacheFlag:" + eEF());
      AppMethodBeat.o(340741);
      return;
    }
    if (!this.isOnUserVisibleFocused)
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for isOnUserVisibleFocused:" + this.isOnUserVisibleFocused + " memoryCacheFlag:" + eEF());
      AppMethodBeat.o(340741);
      return;
    }
    if (this.lastOnPauseHasPermission)
    {
      Log.i("Finder.NearbyLivePresenter", s.X("shouldTryRequestFirstPageAgain return for lastOnPauseHasPermission:", Boolean.valueOf(this.lastOnPauseHasPermission)));
      AppMethodBeat.o(340741);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
    if (!com.tencent.mm.plugin.finder.nearby.live.base.a.a("requestFirstPage", this.EIq, getCommentScene()))
    {
      Log.i("Finder.NearbyLivePresenter", "shouldTryRequestFirstPageAgain return for canLoadNearbyCityFeeds.");
      AppMethodBeat.o(340741);
      return;
    }
    localObject = this.EIq;
    if ((localObject != null) && (((bnn)localObject).ZVZ == 88889)) {}
    for (int i = 1; (i != 0) && (((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actu, d.a.acsO, new e..ExternalSyntheticLambda0(this))); i = 0)
    {
      Log.i("Finder.NearbyLivePresenter", s.X("checkTryRequestFirstPageAgain return for permission:", Boolean.valueOf(this.lastOnPauseHasPermission)));
      AppMethodBeat.o(340741);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("shouldTryRequestFirstPageAgain requestInit tab:");
    localObject = this.EIq;
    if (localObject == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append('-');
      localObject = this.EIq;
      if (localObject != null) {
        break label375;
      }
    }
    label375:
    for (localObject = null;; localObject = ((bnn)localObject).ZWa)
    {
      Log.i("Finder.NearbyLivePresenter", localObject);
      checkEmptyHeader(null);
      localObject = this.EIZ;
      s.checkNotNull(localObject);
      ((NearbyLiveFeedLoader)localObject).a(eEF(), eEE(), this.EIq);
      AppMethodBeat.o(340741);
      return;
      localObject = Integer.valueOf(((bnn)localObject).ZVZ);
      break;
    }
  }
  
  private final void eED()
  {
    AppMethodBeat.i(340694);
    WxRefreshLayout localWxRefreshLayout = eEB().eEy();
    if (localWxRefreshLayout != null) {
      localWxRefreshLayout.postDelayed(new e..ExternalSyntheticLambda2(this), 200L);
    }
    AppMethodBeat.o(340694);
  }
  
  private int eEE()
  {
    AppMethodBeat.i(340699);
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(getCommentScene(), ((bnn)localObject).ZVZ)))
    {
      localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
      i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(getCommentScene(), eEC());
      AppMethodBeat.o(340699);
      return i;
      com.tencent.mm.plugin.finder.nearby.live.square.page.b localb = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(340699);
    return i;
  }
  
  private final boolean eEG()
  {
    AppMethodBeat.i(340707);
    Object localObject = com.tencent.d.a.b.a.a.a.a.ahqb;
    if (((Number)com.tencent.d.a.b.a.a.a.a.jWA().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(340707);
      return true;
    }
    localObject = this.EIq;
    if (localObject == null)
    {
      AppMethodBeat.o(340707);
      return false;
    }
    boolean bool = ((bnn)localObject).ZWe;
    AppMethodBeat.o(340707);
    return bool;
  }
  
  private final void eEH()
  {
    AppMethodBeat.i(340712);
    ((com.tencent.d.a.b.a.b.a)h.ax(com.tencent.d.a.b.a.b.a.class)).sU(true);
    this.EJd.alive();
    this.EJc.alive();
    AppMethodBeat.o(340712);
  }
  
  private final NearbyLiveFeedLoader eEI()
  {
    Object localObject2 = null;
    AppMethodBeat.i(340718);
    ah.a locala = new ah.a();
    locala.aiwY = this.tlCache.Rp(eEF());
    StringBuilder localStringBuilder = new StringBuilder("createFeedLoader canTimelineRefresh=").append(locala.aiwY).append(" memoryCacheFlag:").append(eEF()).append(" tabId: ");
    Object localObject1 = this.EIq;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" tabName: ");
      localObject1 = this.EIq;
      if (localObject1 != null) {
        break label235;
      }
    }
    label235:
    for (localObject1 = localObject2;; localObject1 = ((bnn)localObject1).ZWa)
    {
      Log.i("Finder.NearbyLivePresenter", localObject1 + "  commentScene: " + getCommentScene() + " contextScene: " + this.Auc.AJo);
      localObject1 = new NearbyLivePresenter.createFeedLoader.1(this, this.Auc, getCommentScene(), getTabType(), eEC(), this.EIo);
      ((NearbyLivePresenter.createFeedLoader.1)localObject1).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new c(locala, this, (NearbyLivePresenter.createFeedLoader.1)localObject1));
      ((NearbyLiveFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new d(this, (NearbyLivePresenter.createFeedLoader.1)localObject1));
      localObject1 = (NearbyLiveFeedLoader)localObject1;
      AppMethodBeat.o(340718);
      return localObject1;
      localObject1 = Integer.valueOf(((bnn)localObject1).ZVZ);
      break;
    }
  }
  
  public final void a(int paramInt, long paramLong, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(340950);
    Object localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    int i = getTabType();
    localObject = this.EIq;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.nearby.report.b.x(paramInt, i, (String)localObject);
      localObject = this.EIZ;
      s.checkNotNull(localObject);
      ((NearbyLiveFeedLoader)localObject).a(this.EIq, paramInt, paramb, this.EIU, paramLong);
      AppMethodBeat.o(340950);
      return;
      String str = ((bnn)localObject).ZWa;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final void a(b.b<cc> paramb, boolean paramBoolean, com.tencent.mm.bx.b paramb1)
  {
    AppMethodBeat.i(341037);
    s.u(paramb, "callback");
    Log.i("Finder.NearbyLivePresenter", "onAttach targetPageForceRefreshFlag:" + paramBoolean + " targetTabPageLastBuffer:" + paramb1);
    this.EIZ = eEI();
    this.BiQ = paramb1;
    this.EIU = paramBoolean;
    if (paramBoolean)
    {
      new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
      com.tencent.mm.plugin.finder.nearby.preload.cache.a.QX(eEF());
    }
    a(paramb);
    paramb = eEB();
    paramb1 = this.EIZ;
    s.checkNotNull(paramb1);
    paramb.ae((ArrayList)paramb1.getDataListJustForAdapter());
    paramb = this.EIZ;
    if (paramb != null) {
      paramb.register(this.EJa);
    }
    eEH();
    paramb = eEB().getRecyclerView();
    if (paramb != null)
    {
      paramb.a((RecyclerView.l)new e(this));
      paramb1 = com.tencent.mm.plugin.finder.nearby.report.a.EQq;
      com.tencent.mm.plugin.finder.nearby.report.a.Ra(this.Auc.AJo);
      paramb1 = (Context)this.activity;
      Object localObject = this.EIZ;
      s.checkNotNull(localObject);
      localObject = (ArrayList)((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter();
      paramBoolean = eEG();
      bnn localbnn = this.EIq;
      if (localbnn == null) {}
      for (int i = 0;; i = localbnn.ZVZ)
      {
        this.EIX = new com.tencent.mm.plugin.finder.nearby.live.play.e(paramb1, paramb, (ArrayList)localObject, paramBoolean, i, false, false, 224);
        paramb1 = this.EIX;
        if (paramb1 != null) {
          com.tencent.mm.plugin.finder.nearby.live.play.e.a(paramb1);
        }
        paramb1 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.nearby.live.play.g)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.nearby.live.play.g.class)).a((AppCompatActivity)this.activity);
        if (!(paramb.getAdapter() instanceof WxRecyclerAdapter)) {
          break label364;
        }
        paramb = paramb.getAdapter();
        if (paramb != null) {
          break;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
        AppMethodBeat.o(341037);
        throw paramb;
      }
      paramb1 = (WxRecyclerAdapter)paramb;
      paramb = this.EIX;
      if (paramb != null) {
        break label472;
      }
    }
    label472:
    for (paramb = null;; paramb = paramb.EKE)
    {
      paramb1.agOf = ((i.e)paramb);
      label364:
      if ((eEB().getRecyclerView() != null) && (this.EIZ != null))
      {
        paramb = eEB().getRecyclerView();
        s.checkNotNull(paramb);
        paramb1 = this.EIZ;
        s.checkNotNull(paramb1);
        this.nextPagePreload = new com.tencent.mm.plugin.finder.nearby.preload.nextpage.a(paramb, (BaseFinderFeedLoader)paramb1, this.EIq, getCommentScene());
        paramb = eEB().getRecyclerView();
        s.checkNotNull(paramb);
        this.EIW = new com.tencent.mm.plugin.finder.nearby.base.d(paramb);
      }
      checkPermission();
      this.firstAttach = true;
      AppMethodBeat.o(341037);
      return;
    }
  }
  
  public final void a(bnn parambnn)
  {
    AppMethodBeat.i(341061);
    Object localObject1 = this.EIq;
    int i;
    if ((localObject1 != null) && (parambnn != null))
    {
      Object localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(n.class);
      s.s(localObject2, "UICProvider.of(PluginFin…eloadCacheVM::class.java)");
      n localn = (n)localObject2;
      ((bnn)localObject1).ZWf.clear();
      if (parambnn.ZVZ == ((bnn)localObject1).ZVZ) {
        break label327;
      }
      ((bnn)localObject1).ZWf.add(parambnn);
      localObject2 = n.a((bnn)localObject1, parambnn);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = this.EIX;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.nearby.live.play.e)localObject2).EKF.clear();
      }
      localObject2 = this.EIX;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.finder.nearby.live.play.e)localObject2).eET();
      }
      eEB().pq((List)new ArrayList());
      s.u(localObject1, "dataId");
      localObject1 = (n.f)localn.akir.get(localObject1);
      if (localObject1 != null)
      {
        long l1 = System.currentTimeMillis();
        long l2 = ((n.f)localObject1).timestamp;
        localObject2 = com.tencent.mm.plugin.findersdk.storage.config.a.Hds;
        if (l1 - l2 <= ((Number)com.tencent.mm.plugin.findersdk.storage.config.a.kLF().bmg()).intValue()) {
          break label338;
        }
        i = 1;
        label228:
        if (i == 0) {
          break label343;
        }
      }
      localObject1 = null;
      label235:
      if (localObject1 == null) {
        break label351;
      }
      localObject2 = (Collection)((n.f)localObject1).data;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label346;
      }
      i = 1;
      label267:
      if (i != 0) {
        break label351;
      }
      eEB().pq((List)((n.f)localObject1).data);
      label288:
      localObject1 = this.fragment;
      if (!(localObject1 instanceof NearbyLiveSquareTabFragment)) {
        break label359;
      }
    }
    label327:
    label338:
    label343:
    label346:
    label351:
    label359:
    for (localObject1 = (NearbyLiveSquareTabFragment)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((NearbyLiveSquareTabFragment)localObject1).ELV = parambnn;
      }
      AppMethodBeat.o(341061);
      return;
      localObject1 = n.a((bnn)localObject1, null);
      break;
      i = 0;
      break label228;
      break label235;
      i = 0;
      break label267;
      nx(0L);
      break label288;
    }
  }
  
  public final void b(au paramau)
  {
    AppMethodBeat.i(340974);
    s.u(paramau, "finderStreamCard");
    Log.i("Finder.NearbyLivePresenter", "onLoadMoreFollowFeed.");
    NearbyLiveFeedLoader localNearbyLiveFeedLoader = this.EIZ;
    if (localNearbyLiveFeedLoader != null)
    {
      bnn localbnn = this.EIq;
      s.u(paramau, "finderStreamCard");
      if (localNearbyLiveFeedLoader.EIx)
      {
        Log.i(localNearbyLiveFeedLoader.getTAG(), "requestMoreFollowFeed return for isFetchingLoadMore");
        localNearbyLiveFeedLoader.EIy.ama("requestMoreFollowFeed");
      }
      Log.i(localNearbyLiveFeedLoader.getTAG(), "requestMoreFollowFeed pos:" + paramau.position + " continueAtTheEnd:" + paramau.AYW.ECL + " rvFeedList:" + paramau.rvFeedList.size());
      localNearbyLiveFeedLoader.EIz = paramau;
      NearbyLiveFeedLoader.d locald = new NearbyLiveFeedLoader.d(0, 0, "LOCAL_OK", (byte)0);
      locald.setIncrementList((List)new LinkedList((Collection)paramau.rvFeedList));
      locald.setPullType(2);
      locald.setLastBuffer(localNearbyLiveFeedLoader.EIt);
      locald.setHasMore(paramau.AYW.ECL);
      locald.setRequest(new NearbyLiveFeedLoader.c(2, localbnn, localNearbyLiveFeedLoader.EIt, localNearbyLiveFeedLoader.EIr, localNearbyLiveFeedLoader.hJx, localNearbyLiveFeedLoader.AJo, localNearbyLiveFeedLoader.EIo, 1, 0L, 256));
      localNearbyLiveFeedLoader.EIx = true;
      localNearbyLiveFeedLoader.onFetchDone((IResponse)locald);
    }
    AppMethodBeat.o(340974);
  }
  
  public final void b(b.b<cc> paramb)
  {
    AppMethodBeat.i(341025);
    s.u(paramb, "callback");
    a(paramb, false, null);
    AppMethodBeat.o(341025);
  }
  
  public final b.b<cc> eEB()
  {
    AppMethodBeat.i(340926);
    b.b localb = this.EIV;
    if (localb != null)
    {
      AppMethodBeat.o(340926);
      return localb;
    }
    s.bIx("viewCallback");
    AppMethodBeat.o(340926);
    return null;
  }
  
  protected int eEC()
  {
    return 15;
  }
  
  public final int eEF()
  {
    AppMethodBeat.i(341013);
    Object localObject = this.EIq;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(getCommentScene(), ((bnn)localObject).ZVZ)))
    {
      localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
      i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(getCommentScene(), eEC());
      AppMethodBeat.o(341013);
      return i;
      com.tencent.mm.plugin.finder.nearby.live.square.page.b localb = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(341013);
    return i;
  }
  
  public final com.tencent.mm.plugin.finder.nearby.live.play.e eEx()
  {
    return this.EIX;
  }
  
  public int getCommentScene()
  {
    return 76;
  }
  
  protected int getTabType()
  {
    return 1001;
  }
  
  public final void nx(long paramLong)
  {
    AppMethodBeat.i(341019);
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("startFetchLives");
    localObject = eEB().eEy();
    if (localObject != null) {
      ((WxRefreshLayout)localObject).postDelayed(new e..ExternalSyntheticLambda3((WxRefreshLayout)localObject), paramLong);
    }
    localObject = this.fragment;
    if ((localObject != null) && (((Fragment)localObject).getParentFragment() != null))
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = this.fragment;
      s.checkNotNull(localObject);
      localObject = ((Fragment)localObject).getParentFragment();
      s.checkNotNull(localObject);
      s.s(localObject, "fragment!!.parentFragment!!");
      if (((com.tencent.mm.plugin.finder.nearby.live.square.b)com.tencent.mm.ui.component.k.y((Fragment)localObject).q(com.tencent.mm.plugin.finder.nearby.live.square.b.class)).getCurrentTabIndex() != 0)
      {
        localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
        com.tencent.mm.plugin.finder.nearby.report.b.sS(false);
      }
    }
    AppMethodBeat.o(341019);
  }
  
  public final void onActionbarClick(boolean paramBoolean)
  {
    AppMethodBeat.i(340998);
    RecyclerView localRecyclerView = eEB().getRecyclerView();
    if (localRecyclerView == null)
    {
      AppMethodBeat.o(340998);
      return;
    }
    Object localObject = localRecyclerView.getLayoutManager();
    int i;
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)localObject).n(arrayOfInt);
      i = arrayOfInt[0];
      Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + i + " isDouble=" + paramBoolean);
      if (!paramBoolean) {
        break label316;
      }
      if (i > 12) {
        break label228;
      }
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    for (;;)
    {
      if (i > 12) {
        break label309;
      }
      nx(20L);
      AppMethodBeat.o(340998);
      return;
      if ((localObject instanceof LinearLayoutManager))
      {
        i = ((LinearLayoutManager)localObject).Ju();
        break;
      }
      i = 0;
      break;
      label228:
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
      localRecyclerView.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localRecyclerView, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
    }
    label309:
    nx(100L);
    label316:
    AppMethodBeat.o(340998);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(341047);
    ((com.tencent.d.a.b.a.b.a)h.ax(com.tencent.d.a.b.a.b.a.class)).sU(false);
    this.EJc.dead();
    this.EJd.dead();
    Object localObject = this.EIZ;
    if (localObject != null) {
      ((NearbyLiveFeedLoader)localObject).unregister(this.EJa);
    }
    localObject = this.EIZ;
    s.checkNotNull(localObject);
    if (((NearbyLiveFeedLoader)localObject).getDataListJustForAdapter().size() > 0)
    {
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((n)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(n.class)).UT(eEF());
    }
    localObject = this.EIX;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.nearby.live.play.e)localObject).detach();
    }
    this.firstAttach = false;
    AppMethodBeat.o(341047);
  }
  
  public final void onFinishing()
  {
    AppMethodBeat.i(340989);
    if (this.EIZ == null)
    {
      Log.w("Finder.NearbyLivePresenter", s.X("storeMemoryCache return for feedLoader:", this.EIZ));
      AppMethodBeat.o(340989);
      return;
    }
    this.tlCache.akir.clear();
    Object localObject1 = this.EIZ;
    s.checkNotNull(localObject1);
    au localau = ((NearbyLiveFeedLoader)localObject1).EIz;
    localObject1 = this.EIW;
    int k;
    label90:
    int m;
    int n;
    label138:
    int i;
    if (localObject1 == null)
    {
      j = 0;
      localObject1 = this.EIW;
      if (localObject1 != null) {
        break label302;
      }
      k = 0;
      localObject1 = this.EIZ;
      s.checkNotNull(localObject1);
      m = ((NearbyLiveFeedLoader)localObject1).getDataListJustForAdapter().size();
      n = eEF();
      localObject1 = this.fragment;
      if (!(localObject1 instanceof NearbyLiveSquareTabFragment)) {
        break label311;
      }
      localObject1 = (NearbyLiveSquareTabFragment)localObject1;
      if (localObject1 != null) {
        break label317;
      }
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      if ((this.EJb) && (localau != null)) {
        break label343;
      }
      if (m <= 0) {
        break label973;
      }
      localObject1 = this.tlCache;
      localObject2 = this.EIZ;
      s.checkNotNull(localObject2);
      n.a((n)localObject1, n, j, k, (ArrayList)((NearbyLiveFeedLoader)localObject2).getDataListJustForAdapter(), null, this.EIt, false, i, 80);
      Log.i("Finder.NearbyLivePresenter", "[onFinishing] memoryCacheFlag:" + n + " enableFoldFollowData:" + this.EJb + " position:" + j + " offset:" + k + " size:" + m + " lastBuffer:" + this.EIt);
      AppMethodBeat.o(340989);
      return;
      j = ((com.tencent.mm.plugin.finder.nearby.base.d)localObject1).position;
      break;
      label302:
      k = ((com.tencent.mm.plugin.finder.nearby.base.d)localObject1).offset;
      break label90;
      label311:
      localObject1 = null;
      break label138;
      label317:
      localObject1 = ((NearbyLiveSquareTabFragment)localObject1).ELV;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = ((bnn)localObject1).ZVZ;
      }
    }
    label343:
    int i1 = localau.position;
    localObject1 = this.EIZ;
    s.checkNotNull(localObject1);
    ArrayList localArrayList = new ArrayList((Collection)((NearbyLiveFeedLoader)localObject1).getDataListJustForAdapter());
    localObject1 = (List)localArrayList;
    int j = 0;
    localObject1 = ((List)localObject1).iterator();
    label441:
    label445:
    LinkedList localLinkedList;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cc)((Iterator)localObject1).next();
      if (((localObject2 instanceof bn)) && (((bn)localObject2).index > i1))
      {
        k = 1;
        if (k == 0) {
          break label633;
        }
        localLinkedList = new LinkedList((Collection)localArrayList.subList(0, i1));
        if ((j == -1) || (j >= localArrayList.size())) {
          break label645;
        }
        localObject2 = new LinkedList((Collection)localArrayList.subList(j, localArrayList.size()));
        label502:
        if ((i1 == -1) || (j == -1) || (j >= localArrayList.size()) || (j <= i1)) {
          break label657;
        }
        localObject1 = new LinkedList((Collection)localArrayList.subList(i1, j));
      }
    }
    for (;;)
    {
      localObject3 = new LinkedList();
      s.u(localObject3, "<set-?>");
      localau.rvFeedList = ((LinkedList)localObject3);
      localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (cc)((Iterator)localObject3).next();
        if ((localObject4 instanceof BaseFinderFeed)) {
          localau.rvFeedList.add(localObject4);
        }
      }
      k = 0;
      break label441;
      label633:
      j += 1;
      break;
      j = -1;
      break label445;
      label645:
      localObject2 = new LinkedList();
      break label502;
      label657:
      if ((i1 != -1) && (j == -1) && (i1 < localArrayList.size())) {
        localObject1 = new LinkedList((Collection)localArrayList.subList(i1, localArrayList.size()));
      } else {
        localObject1 = new LinkedList();
      }
    }
    Object localObject3 = bg.ABl;
    localObject3 = bg.fU((List)localLinkedList);
    Object localObject4 = bg.ABl;
    localObject1 = bg.fU((List)localObject1);
    localObject4 = bg.ABl;
    localObject4 = bg.fU((List)localObject2);
    Object localObject5 = bg.ABl;
    localObject5 = bg.fU((List)localArrayList);
    Log.i("Finder.NearbyLivePresenter", "onFinishing moreFollowCardIndex:" + i1 + " moreRecommendDividerIndex:" + j + " beforeFollowDataListStr:" + (String)localObject3 + " followDataListStr:" + (String)localObject1 + " recommendDataListStr:" + (String)localObject4 + " dataListStr:" + (String)localObject5);
    localArrayList.clear();
    localArrayList.addAll((Collection)localLinkedList);
    localArrayList.add(localau);
    localArrayList.addAll((Collection)localObject2);
    n.a(this.tlCache, n, 0, 0, localArrayList, null, this.EIt, false, i, 80);
    Log.i("Finder.NearbyLivePresenter", "[onFinishing] memoryCacheFlag:" + n + " enableFoldFollowData:" + this.EJb + " position:0 offset:0 size:" + m + " lastBuffer:" + this.EIt);
    label973:
    AppMethodBeat.o(340989);
  }
  
  public final void onLoadMore()
  {
    int i = 1;
    AppMethodBeat.i(340966);
    Object localObject = this.nextPagePreload;
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).uSA == true)) {}
    while (i != 0)
    {
      Log.i("Finder.NearbyLivePresenter", "onLoadMore return for is preloading.");
      AppMethodBeat.o(340966);
      return;
      i = 0;
    }
    Log.i("Finder.NearbyLivePresenter", "onLoadMore.");
    localObject = this.EIZ;
    if (localObject != null) {
      ((NearbyLiveFeedLoader)localObject).requestLoadMore(this.EIq);
    }
    AppMethodBeat.o(340966);
  }
  
  public final void onRefresh()
  {
    AppMethodBeat.i(340941);
    Object localObject = this.EIq;
    if ((localObject != null) && (((bnn)localObject).ZVZ == 88889)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = v.GgU;
      v.a((kotlin.g.a.a)new f(this), (kotlin.g.a.a)new g(this), (kotlin.g.a.a)new h(this));
      AppMethodBeat.o(340941);
      return;
    }
    requestRefresh();
    AppMethodBeat.o(340941);
  }
  
  public void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(340960);
    s.u(paramd, "reason");
    Object localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
    com.tencent.mm.plugin.finder.nearby.trace.c.eGR().gG("onRefreshEnd");
    localObject = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    localObject = com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(eEF());
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERB = System.currentTimeMillis();
    Log.i(s.X("NearbyTimeConsumingHelper-", Integer.valueOf(((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).hJx)), "onVisible->onRefreshEnd:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERB - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERv) + " \nonAttach->startFetch:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERw - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERv) + " \nstartFetch->startCgi:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERx - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERw) + " \nstartCgi->onCgiBack:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERy - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERx) + " \nonCgiBack->onFetchDone:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERz - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERy) + " \nonFetchDone->onViewUpdate:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERA - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERz) + " \nonViewUpdate->onRefreshEnd:" + (((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERB - ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERA));
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERv = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERw = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERx = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERy = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERz = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERA = 0L;
    ((com.tencent.mm.plugin.finder.nearby.trace.b)localObject).ERB = 0L;
    if (paramd.agJv <= 0)
    {
      localObject = eEB().eEy();
      if (localObject != null) {
        ((WxRefreshLayout)localObject).jNx();
      }
    }
    if (paramd.agJu)
    {
      localObject = eEB().eEy();
      if (localObject != null) {
        ((WxRefreshLayout)localObject).Of(false);
      }
    }
    checkEmptyHeader(paramd);
    ayY("onRefreshEnd");
    localObject = this.nextPagePreload;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).isRefreshing = false;
    }
    localObject = this.nextPagePreload;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).sR(paramd.agJu);
    }
    Y(false, "onRefreshEnd");
    AppMethodBeat.o(340960);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(341104);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    Log.i("Finder.NearbyLivePresenter", "onRequestPermissionsResult requestCode:" + paramInt + " grantResults[0]:" + paramArrayOfInt[0]);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(341104);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        checkTryRequestFirstPageAgain();
        AppMethodBeat.o(341104);
        return;
      }
      Log.i("Finder.NearbyLivePresenter", "onRequestPermissionsResult return for grant.");
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(341087);
    this.isOnResume = true;
    Log.i("Finder.NearbyLivePresenter", s.X("onStart memoryCacheFlag:", Integer.valueOf(eEF())));
    if (!this.isFirstOnResume) {
      checkTryRequestFirstPageAgain();
    }
    com.tencent.mm.plugin.finder.nearby.live.play.e locale = this.EIX;
    if ((locale != null) && (!locale.EKz)) {
      Y(this.isFirstOnResume, "onStart");
    }
    this.isFirstOnResume = false;
    AppMethodBeat.o(341087);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(341095);
    this.isOnResume = false;
    Log.i("Finder.NearbyLivePresenter", s.X("onStop memoryCacheFlag:", Integer.valueOf(eEF())));
    com.tencent.mm.plugin.finder.nearby.live.play.e locale = this.EIX;
    if (locale != null) {
      locale.EKF.clear();
    }
    locale = this.EIX;
    if (locale != null) {
      locale.eET();
    }
    checkPermission();
    AppMethodBeat.o(341095);
  }
  
  public final void onUserVisibleFocused()
  {
    Object localObject2 = null;
    int i = 1;
    AppMethodBeat.i(341078);
    Log.i("Finder.NearbyLivePresenter", s.X("onUserVisibleFocused memoryCacheFlag:", Integer.valueOf(eEF())));
    this.isOnUserVisibleFocused = true;
    Object localObject1 = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
    com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(eEF()).ERv = System.currentTimeMillis();
    if (this.isFirstOnUserVisibleFocused)
    {
      localObject1 = com.tencent.mm.plugin.finder.nearby.live.base.a.EJF;
      if (!com.tencent.mm.plugin.finder.nearby.live.base.a.a("requestFirstPage", this.EIq, getCommentScene())) {
        break label328;
      }
      localObject1 = this.EIq;
      if ((localObject1 == null) || (((bnn)localObject1).ZVZ != 88889)) {
        break label295;
      }
      if ((i == 0) || (!((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkAndShowPermissionDialog(d.c.actu, d.a.acsO, new e..ExternalSyntheticLambda1(this)))) {
        break label300;
      }
      Log.i("Finder.NearbyLivePresenter", s.X("checkTryRequestFirstPageAgain return for permission:", Boolean.valueOf(this.lastOnPauseHasPermission)));
    }
    Object localObject3;
    bnn localbnn;
    for (;;)
    {
      if (!this.isFirstOnUserVisibleFocused) {
        checkTryRequestFirstPageAgain();
      }
      localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
      localObject3 = this.Auc;
      localbnn = this.EIq;
      s.u(localObject3, "contextObj");
      StringBuilder localStringBuilder = new StringBuilder("onEnterLiveSquareTabPage tab:[");
      if (localbnn != null) {
        break label570;
      }
      localObject1 = null;
      label207:
      localStringBuilder = localStringBuilder.append(localObject1).append(", ");
      if (localbnn != null) {
        break label582;
      }
      localObject1 = null;
      label228:
      Log.i("NearbyPreloadManager", localObject1 + ']');
      if (com.tencent.mm.plugin.finder.nearby.preload.a.eGs()) {
        break label591;
      }
      Log.w("NearbyPreloadManager", s.X("onEnterLiveSquareTabPage return for enableNearbyLivePagesPreload:", Boolean.valueOf(com.tencent.mm.plugin.finder.nearby.preload.a.eGs())));
      label272:
      Y(this.isFirstOnUserVisibleFocused, "onUserVisibleFocused");
      this.isFirstOnUserVisibleFocused = false;
      AppMethodBeat.o(341078);
      return;
      label295:
      i = 0;
      break;
      label300:
      localObject1 = this.EIZ;
      s.checkNotNull(localObject1);
      ((NearbyLiveFeedLoader)localObject1).a(eEF(), eEE(), this.EIq);
      continue;
      label328:
      localObject1 = new RefreshLoadMoreLayout.d(0);
      ((RefreshLoadMoreLayout.d)localObject1).agJs = -2;
      localObject3 = ah.aiuX;
      checkEmptyHeader((RefreshLoadMoreLayout.d)localObject1);
      localObject1 = this.EIq;
      if ((localObject1 != null) && (((bnn)localObject1).ZVZ == 88889)) {}
      for (i = 1; i != 0; i = 0)
      {
        localObject1 = h.baE().ban().d(274436, null);
        if (localObject1 != null) {
          break label420;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(341078);
        throw ((Throwable)localObject1);
      }
    }
    label420:
    boolean bool;
    if (com.tencent.mm.au.b.OE((String)localObject1))
    {
      bool = com.tencent.mm.pluginsdk.permission.b.s((Context)this.activity, "android.permission.ACCESS_FINE_LOCATION");
      if (bool) {
        break label723;
      }
      if (!h.baE().ban().getBoolean(at.a.acXn, false)) {
        com.tencent.mm.plugin.account.sdk.c.a.b((Context)this.activity, this.activity.getString(com.tencent.mm.plugin.finder.e.h.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
      }
    }
    label570:
    label582:
    label591:
    label721:
    label723:
    for (;;)
    {
      Log.i("Finder.NearbyLivePresenter", s.X("requestLocationPermission checkLocation:", Boolean.valueOf(bool)));
      break;
      com.tencent.mm.pluginsdk.permission.b.b((Activity)this.activity, "android.permission.ACCESS_FINE_LOCATION", 153);
      continue;
      bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.activity, new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 153, null);
      continue;
      localObject1 = Integer.valueOf(localbnn.ZVZ);
      break label207;
      localObject1 = localbnn.ZWa;
      break label228;
      if (localbnn == null) {}
      for (localObject1 = localObject2;; localObject1 = ah.aiuX)
      {
        if (localObject1 != null) {
          break label721;
        }
        Log.w("NearbyPreloadManager", "onEnterLiveSquareTabPage return for null");
        break;
        Log.i("NearbyPreloadManager", "onEnterLiveSquareTabPage startPreload preTab:" + localbnn.ZWd + " nextTab:" + localbnn.ZWc);
        if (localbnn.ZWc)
        {
          localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
          com.tencent.mm.plugin.finder.nearby.preload.a.a((bui)localObject3, com.tencent.mm.plugin.finder.nearby.preload.a.b(localbnn, com.tencent.mm.plugin.finder.nearby.preload.a.EPK), 14, "preloadNextTab");
        }
        if (localbnn.ZWd)
        {
          localObject1 = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
          com.tencent.mm.plugin.finder.nearby.preload.a.a((bui)localObject3, com.tencent.mm.plugin.finder.nearby.preload.a.a(localbnn, com.tencent.mm.plugin.finder.nearby.preload.a.EPK), 15, "preloadPreTab");
        }
      }
      break label272;
    }
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(341083);
    Log.i("Finder.NearbyLivePresenter", s.X("onUserVisibleUnFocused memoryCacheFlag:", Integer.valueOf(eEF())));
    this.isOnUserVisibleFocused = false;
    com.tencent.mm.plugin.finder.nearby.live.play.e locale = this.EIX;
    if (locale != null) {
      locale.EKF.clear();
    }
    locale = this.EIX;
    if (locale != null) {
      locale.eET();
    }
    AppMethodBeat.o(341083);
  }
  
  protected final void requestRefresh()
  {
    AppMethodBeat.i(341006);
    Object localObject = this.EIq;
    if ((localObject != null) && (((bnn)localObject).ZVZ == 88889)) {}
    for (int i = 1; (i == 0) || (((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).checkBusinessPermission(d.c.actu, d.a.acsO)); i = 0)
    {
      Log.i("Finder.NearbyLivePresenter", "requestRefresh");
      a(this, this.EIp);
      this.EIp = 1;
      this.EIU = false;
      this.BiQ = null;
      localObject = this.nextPagePreload;
      if (localObject == null) {
        break label125;
      }
      ((com.tencent.mm.plugin.finder.nearby.preload.nextpage.a)localObject).isRefreshing = true;
      AppMethodBeat.o(341006);
      return;
    }
    Log.i("Finder.NearbyLivePresenter", "business switch close");
    eED();
    label125:
    AppMethodBeat.o(341006);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(RefreshLoadMoreLayout.d<Object> paramd, e parame)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(e parame, bnn parambnn)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    c(ah.a parama, e parame, NearbyLivePresenter.createFeedLoader.1 param1) {}
    
    public final void call(final int paramInt)
    {
      AppMethodBeat.i(340721);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.EJg, jdField_this, paramInt, this.EJh));
      AppMethodBeat.o(340721);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ah.a parama, e parame, int paramInt, NearbyLivePresenter.createFeedLoader.1 param1)
      {
        super();
      }
      
      private static final void a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2, e parame)
      {
        AppMethodBeat.i(340818);
        s.u(parame, "this$0");
        ((StaggeredGridLayoutManager)paramLayoutManager).bo(paramInt1, paramInt2);
        e.a(parame, "IInitDone");
        AppMethodBeat.o(340818);
      }
      
      private static final void a(e parame, int paramInt, RecyclerView paramRecyclerView)
      {
        AppMethodBeat.i(370445);
        s.u(parame, "this$0");
        parame.eEB().QB(paramInt);
        parame = paramRecyclerView.getLayoutManager();
        if (parame != null)
        {
          paramRecyclerView = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(parame, paramRecyclerView.aYi(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$2$1$call$1", "invoke$lambda-2", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;ILandroidx/recyclerview/widget/RecyclerView;)V", "Undefined", "scrollToPosition", "(I)V");
          parame.scrollToPosition(((Integer)paramRecyclerView.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(parame, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$2$1$call$1", "invoke$lambda-2", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;ILandroidx/recyclerview/widget/RecyclerView;)V", "Undefined", "scrollToPosition", "(I)V");
        }
        AppMethodBeat.o(370445);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    d(e parame, NearbyLivePresenter.createFeedLoader.1 param1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(e parame) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(340715);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(340715);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340711);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.live.report.j.Dob;
      com.tencent.mm.plugin.finder.live.report.j.a(paramRecyclerView, q.w.DwP, String.valueOf(this.EJe.getCommentScene()), com.tencent.mm.plugin.finder.live.report.d.Dne, -100, -100);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(340711);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$viewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.view.k
  {
    i(e parame) {}
    
    private WxRecyclerAdapter<?> getAdapter()
    {
      AppMethodBeat.i(340763);
      Object localObject = this.EJe.eEB().getRecyclerView();
      if (localObject == null) {}
      for (localObject = null; (localObject instanceof WxRecyclerAdapter); localObject = ((RecyclerView)localObject).getAdapter())
      {
        localObject = (WxRecyclerAdapter)localObject;
        AppMethodBeat.o(340763);
        return localObject;
      }
      AppMethodBeat.o(340763);
      return null;
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(340777);
      this.EJe.eEB().eEz().onChanged();
      Object localObject = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
      com.tencent.mm.plugin.finder.nearby.preload.a.a(this.EJe.Auc, this.EJe.EIq);
      localObject = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
      com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(this.EJe.eEF()).ERA = System.currentTimeMillis();
      localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
      com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("recyclerOnChange");
      AppMethodBeat.o(340777);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340788);
      com.tencent.mm.view.k localk = this.EJe.eEB().eEz();
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      if (localWxRecyclerAdapter == null) {}
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        localk.onItemRangeChanged(i + paramInt1, paramInt2);
        AppMethodBeat.o(340788);
        return;
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(340799);
      com.tencent.mm.view.k localk = this.EJe.eEB().eEz();
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      if (localWxRecyclerAdapter == null) {}
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        localk.onItemRangeChanged(i + paramInt1, paramInt2, paramObject);
        AppMethodBeat.o(340799);
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340811);
      Object localObject = this.EJe.eEB().eEz();
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      if (localWxRecyclerAdapter == null) {}
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        ((com.tencent.mm.view.k)localObject).onItemRangeInserted(i + paramInt1, paramInt2);
        localObject = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
        com.tencent.mm.plugin.finder.nearby.preload.a.a(this.EJe.Auc, this.EJe.EIq);
        localObject = com.tencent.mm.plugin.finder.nearby.trace.b.ERu;
        com.tencent.mm.plugin.finder.nearby.trace.b.a.Rm(this.EJe.eEF()).ERA = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
        paramInt1 = this.EJe.getTabType();
        localObject = com.tencent.mm.plugin.finder.nearby.report.b.Rb(paramInt1);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.finder.nearby.report.b.a)localObject).EQH = cn.bDw();
          Log.i("FinderNearbyLiveLoadingReporter", s.X("onUIShowEnd tabType: ", Integer.valueOf(paramInt1)));
          localObject = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
          com.tencent.mm.plugin.finder.nearby.report.b.Rd(paramInt1);
        }
        localObject = com.tencent.mm.plugin.finder.nearby.trace.c.ERD;
        com.tencent.mm.plugin.finder.nearby.trace.c.eGR().aDn("recyclerOnInsert");
        AppMethodBeat.o(340811);
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(340816);
      com.tencent.mm.view.k localk = this.EJe.eEB().eEz();
      WxRecyclerAdapter localWxRecyclerAdapter = getAdapter();
      if (localWxRecyclerAdapter == null) {}
      for (int i = 0;; i = localWxRecyclerAdapter.agOb.size())
      {
        localk.onItemRangeRemoved(i + paramInt1, paramInt2);
        AppMethodBeat.o(340816);
        return;
      }
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(340831);
      s.u(paramd, "reason");
      this.EJe.eEB().eEz().onPreFinishLoadMore(paramd);
      AppMethodBeat.o(340831);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(340839);
      s.u(paramd, "reason");
      this.EJe.eEB().eEz().onPreFinishLoadMoreSmooth(paramd);
      com.tencent.mm.plugin.finder.nearby.preload.nextpage.a locala = e.j(this.EJe);
      if (locala != null) {
        locala.sR(paramd.agJu);
      }
      AppMethodBeat.o(340839);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(340826);
      s.u(paramd, "reason");
      this.EJe.eEB().eEz().onPreFinishRefresh(paramd);
      AppMethodBeat.o(340826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.e
 * JD-Core Version:    0.7.0.1
 */