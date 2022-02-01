package com.tencent.mm.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.an;
import com.tencent.mm.plugin.findersdk.a.ao;
import com.tencent.mm.plugin.findersdk.a.s;
import com.tencent.mm.plugin.findersdk.a.u;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/IFinderCommonLiveService;", "Lcom/tencent/mm/kernel/service/IService;", "Audience21053ReportReportOnExposure", "", "liveFeed", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "addCreateNotice", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "addNotice", "userName", "", "liveNoticeInfo", "assignIsIgnorePreloadForFeedId", "isIgnorePreloadForFeedId", "", "assignLiveLoaderIsIgnorePreloadForFeedId", "assignLiveLoaderIsIgnorePreloadShopForFeedId", "isIgnorePreloadShopForFeedId", "autoPlayFinderLiveList", "", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "convertToLiveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toWhere", "", "forceFetchObject", "convertToSimilarLive", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "clickFeed", "commentScene", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "convertToVisitorLiveData", "tabType", "createFinderLiveFeedDecorator", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedDecorator;", "scene", "decorateView", "Landroid/view/ViewGroup;", "createFinderLivePlayView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "createFinderLivePlayViewClass", "createFinderUploadLiveCoverImageTask", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "createLiveCardAutoPlayMgr", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardAutoPlayManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "feedList", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "createLiveLogoAssistant", "Lcom/tencent/mm/plugin/findersdk/api/ILiveLogoAssistant;", "anchorUsername", "position", "isLiveFeed", "createNetSceneAudienceReserveLive", "Lcom/tencent/mm/modelbase/NetSceneBase;", "noticeId", "optype", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "promoToken", "doCgiFinderAudienceReserveLive", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "doCgiFinderAuthAppMsg", "Lcom/tencent/mm/protocal/protobuf/FinderSendInviteMsgResponse;", "toUserName", "msgContent", "callback", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderAuthAppMsg;", "doCgiFinderBatchGetObjectAsyncLoadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBatchGetObjectAsyncLoadInfoResponse;", "units", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectUidUnit;", "liveReportScene", "finderUserName", "uxInfo", "objectIds", "Lkotlin/Pair;", "doCgiFinderCreateLiveNotice", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "opType", "doCgiFinderLiveGetLastObject", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "username", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "doCgiFinderLiveStream", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "lng", "", "lat", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveStreamCallback;", "enableMoclLiveList", "filterData", "Ljava/util/LinkedList;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "firstItemPos", "lastItemPos", "formatNumber", "number", "getFinderLiveConfettView", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveConfettView;", "getHalfMiniProgramHeight", "getHourList", "day", "formatStrRes", "isIgnoreMinute", "getMiniprogramType", "getNotice", "getNoticeSnapshot", "getNoticeStartTime", "getPerformanceLevel", "getPreloadMiniProgramBundleList", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "preloadInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveWxaPreloadInfo;", "goAnchorUIWithCheck", "config", "contextId", "clickTabContextId", "intent", "Landroid/content/Intent;", "goVisitorUIWithCheck", "i", "needAnim", "onBeforeStart", "Lkotlin/Function0;", "gotoReplayUI", "withCheck", "hasCreateNotice", "isAnchorLive", "isLibPagEnabled", "needCalculateWatchNumberOnFeedFlow", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "readLiveListDebugInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "releaseWithMiniWindow", "isTopApplication", "removeCreateNotice", "replaceNotify", "newMsgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "rewardGainEnableBySwitchFlag", "switchFlag", "saveAliasInfoList", "aliasInfoList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "saveLiveListDebugInfo", "info", "", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "Landroid/widget/TextView;", "maxInputLength", "maxInputSize", "configCallback", "startPlayLiveOnFeedFlow", "finderObject", "stopPlayLiveOnFeedFlow", "str2NameList", "str", "tryToPreRender", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "bundle", "preloadIfFail", "updateCreateNoticeList", "list", "watchLiveVisitorCore", "closeLive", "outSideLive", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface g
  extends com.tencent.mm.kernel.c.a
{
  public abstract void B(Context paramContext, Intent paramIntent);
  
  public abstract bkk Sv(String paramString);
  
  public abstract void Sw(String paramString);
  
  public abstract List<String> Sx(String paramString);
  
  public abstract int a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent, boolean paramBoolean, kotlin.g.a.a<ah> parama);
  
  public abstract p a(String paramString1, String paramString2, int paramInt, bui parambui, String paramString3);
  
  public abstract FinderLiveBundle a(ArrayList<com.tencent.mm.plugin.finder.model.cc> paramArrayList, com.tencent.mm.plugin.finder.model.cc paramcc, int paramInt);
  
  public abstract FinderLiveBundle a(ArrayList<com.tencent.mm.plugin.finder.model.cc> paramArrayList, com.tencent.mm.plugin.finder.model.cc paramcc, int paramInt1, int paramInt2);
  
  public abstract ak a(Context paramContext, RecyclerView paramRecyclerView, ArrayList<com.tencent.mm.plugin.finder.model.cc> paramArrayList, WxRecyclerAdapter<?> paramWxRecyclerAdapter);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<bne> a(b paramb, int paramInt, float paramFloat1, float paramFloat2, u paramu);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<azf> a(String paramString, com.tencent.mm.plugin.findersdk.a.t paramt);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<avy> a(String paramString, bkk parambkk, bui parambui);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<att> a(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<Object> a(String paramString1, String paramString2, s params);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<aub> a(List<? extends brr> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract LinkedList<com.tencent.mm.plugin.finder.model.cc> a(BaseFeedLoader<com.tencent.mm.plugin.finder.model.cc> paramBaseFeedLoader, int paramInt1, int paramInt2);
  
  public abstract List<com.tencent.mm.plugin.appbrand.api.g> a(boh paramboh);
  
  public abstract void a(Context paramContext, FinderLiveBundle paramFinderLiveBundle, String paramString1, String paramString2, Intent paramIntent);
  
  public abstract void a(EditText paramEditText, kotlin.g.a.a<ah> parama);
  
  public abstract void a(ImageView paramImageView, String paramString);
  
  public abstract void a(com.tencent.mm.plugin.appbrand.api.g paramg);
  
  public abstract void a(com.tencent.mm.plugin.finder.live.report.g paramg);
  
  public abstract void a(bkk parambkk);
  
  public abstract void a(String paramString, bkk parambkk);
  
  public abstract boolean a(int paramInt1, int paramInt2, BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void aA(com.tencent.mm.storage.cc paramcc);
  
  public abstract LiveConfig b(FinderObject paramFinderObject, int paramInt);
  
  public abstract com.tencent.mm.plugin.findersdk.b.c<aub> b(List<r<Long, String>> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract void b(FinderObject paramFinderObject, bui parambui);
  
  public abstract boolean bUb();
  
  public abstract boolean bUo();
  
  public abstract void bUp();
  
  public abstract int bUq();
  
  public abstract void bUr();
  
  public abstract void bUs();
  
  public abstract Class<? extends com.tencent.mm.plugin.finder.video.t> bUt();
  
  public abstract long bUu();
  
  public abstract boolean bUv();
  
  public abstract int bUw();
  
  public abstract boolean bUx();
  
  public abstract String chX();
  
  public abstract com.tencent.mm.loader.f.c co(String paramString1, String paramString2);
  
  public abstract ArrayList<List<String>> eZ(int paramInt1, int paramInt2);
  
  public abstract an en(Context paramContext);
  
  public abstract com.tencent.mm.plugin.finder.video.t eo(Context paramContext);
  
  public abstract ao i(ViewGroup paramViewGroup);
  
  public abstract void jo(long paramLong);
  
  public abstract String jp(long paramLong);
  
  public abstract boolean jq(long paramLong);
  
  public abstract void jr(long paramLong);
  
  public abstract void js(long paramLong);
  
  public abstract void t(LinkedList<bkk> paramLinkedList);
  
  public abstract void u(LinkedList<bcz> paramLinkedList);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.g
 * JD-Core Version:    0.7.0.1
 */