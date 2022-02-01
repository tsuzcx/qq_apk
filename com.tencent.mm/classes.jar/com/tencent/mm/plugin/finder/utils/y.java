package com.tencent.mm.plugin.finder.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.Size;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hn.a;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.hv.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.search.f.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.n.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.k.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.ae;
import kotlin.o;
import kotlin.r;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil;", "", "()V", "FAST_CLICK_DELAY_TIME_MS", "", "FINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "getFINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "()I", "setFINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "(I)V", "FINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "getFINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "setFINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "FINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "getFINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "setFINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "FINDER_HOT_FULLSCREEN_ENJOY_VALUE", "getFINDER_HOT_FULLSCREEN_ENJOY_VALUE", "setFINDER_HOT_FULLSCREEN_ENJOY_VALUE", "FINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "getFINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "setFINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "FINDER_POST_DISABLE_HALF_SCREEN_VALUE", "getFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "setFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "FINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "getFINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "setFINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "OTHER_CARE_REPORT_RV_TYPE", "", "getOTHER_CARE_REPORT_RV_TYPE", "()Ljava/util/Set;", "POST_WIDER_MEDIA_LAYOUT_SIZE", "TAG", "", "debug", "", "getDebug", "()Z", "heightPixels", "isNeedResetFullScreenConfig", "setNeedResetFullScreenConfig", "(Z)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastClickTime", "margin", "mediaRect", "Landroid/graphics/Rect;", "screenInfoObj", "Lorg/json/JSONObject;", "getScreenInfoObj", "()Lorg/json/JSONObject;", "setScreenInfoObj", "(Lorg/json/JSONObject;)V", "blurVideoThumb", "Landroid/graphics/Bitmap;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "bitmap", "source", "buildConvertFailMsg", "", "logPrefix", "type", "calculateLongVideoLayoutParams", "context", "Landroid/app/Activity;", "originWidth", "originHeight", "targetView", "Landroid/view/View;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "calculateLongVideoTLLayoutParams", "Lkotlin/Triple;", "calculatePercent", "offset", "total", "calculatePostLayoutParams", "width", "height", "calculateStaggeredLayoutParams", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "calculateTimelineLayoutParams", "Landroid/content/Context;", "canFav", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "canFollowMusic", "canMegaVideoFav", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "canMegaVideoLike", "canMegaVideoPostBullet", "canMegaVideoShare", "canReprint", "feed", "canShare", "canShowTime", "changeSystemViewColor", "window", "Landroid/view/Window;", "light", "checkFinderSelfRedPackRedDot", "checkHasAccountAndCreate", "activity", "tip", "showRed", "userPrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkHasAccountToSendMsg", "checkHasCloseRedPack", "checkHasEnterRedPackMiniApp", "checkHasRealname", "titleStr", "checkIfAccountLegal", "checkIfMsgMute", "extFlag", "checkIfRedPackInTime", "checkMyTabRedPackRedDot", "checkResetFullScreenConfig", "checkShowCgiErrorAlter", "errType", "errCode", "errMsg", "checkUserState", "clearFinderMsgLastBuf", "clearWxMsgLastBuf", "convertCompatibilityMediaType", "obj", "createIntentWithCache", "Landroid/content/Intent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "isHot", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadTask", "taskCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "currentTimeSecond", "decodeBitmap", "inputStream", "Ljava/io/InputStream;", "limitW", "limitH", "isRotate", "isClose", "fillLocalImageToView", "imageView", "Landroid/widget/ImageView;", "fillRefInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "filterText", "origin", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "fixRecyclerViewPosition", "initPos", "linearLayoutManager", "formatLiveNew", "num", "formatLiveNum", "genClientMsgId", "genPoiAddress", "descs", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinString_t;", "getBgmView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "focusHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getClipData", "getCommentSceneByTabType", "tabType", "getCompareFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "headCount", "compareFeedLogic", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getCurrentScreenIndexInfo", "Lorg/json/JSONArray;", "getDisplayName", "username", "nickname", "printLog", "getFeed", "position", "feedList", "getFeedListByAdapterPosRange", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "start", "end", "getFinderLiveCommentPopCenter", "", "view", "floatView", "getFinderLiveNoticeTips", "time", "getFinderMsgSuffixColor", "scene", "getFinderPageDir", "getFollowPatWording", "getFromUserName", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getHint", "key", "resId", "getHomeTabInitCacheList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "firstPageFlag", "isPreload", "getImageLocation", "Lkotlin/Pair;", "", "getImageWidthHeight", "Landroid/graphics/Point;", "filePath", "getLastBuffKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getListOfType", "E", "T", "clazz", "Ljava/lang/Class;", "getLocationShowString", "countryCode", "provinceCode", "cityCode", "getMaxMediaHWRadio", "list", "getMaxShareMediaHWRadio", "Lcom/tencent/mm/protocal/protobuf/FinderShareMedia;", "getMaxShareMegaMediaHWRadio", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareMedia;", "getMediaRateLimit", "hwRate", "getMentionNick", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getNickName", "getNoticePickerFirstList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNoticePickerSecondList", "day", "getNoticePickerThirdList", "hour", "getNoticeStartTime", "getNumFormatStr", "getPoiText", "city", "poiName", "getPosition", "getPreloadMiniProgramBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "product", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "getPrintDescription", "desc", "getRandomChina", "", "getScreenInfo", "getSelfNameByScene", "getSelfUsernameByScene", "getShareUiEnter", "reportScene", "getSpanTouchListener", "Landroid/view/View$OnTouchListener;", "tv", "getToUserName", "getUnreadList", "cacheDataList", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "getVideoLocation", "getVideoType", "localFinderMedia", "getVisibleFeedListByAdapterPosRange", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "globalVisibleRect", "hasBgmIcon", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasCreateFinderIdentit", "hasFinderAccount", "hasShowFinderNewGuide", "ifPosterBolcked", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "ifShowNoticeView", "isAcceptLiveObj", "invokeSource", "isAcceptObj", "isAcceptVideoObj", "isAllEnableFullScreenEnjoy", "isAllHomeTabEnableFullScreenEnjoy", "isAnyEnableFullScreenEnjoy", "isAnyHomeTabEnableFullScreenEnjoy", "isCommentClose", "isCropVideo", "isDisablePostHalfScreen", "isEnableFullScreenEnjoy", "commentScene", "isFastClick", "isFinderComment", "displayFlag", "isFinderScene", "isFlowCommentScene", "isFriend", "isFriendComment", "isGlobalEnableFullScreenEnjoy", "isHomeTabEnableFullScreenEnjoy", "isLikeNotRecommend", "isLiveFeed", "isMoovOptimize", "isMsgLikeEvent", "isNoSeeAtTab", "userName", "isNormalVideo", "isNotAddDescToCommentDrawer", "isOtherEnableFullScreenEnjoy", "isPauseIconInside", "media", "isPostNewsQualificaion", "isPoster", "isPrivateAccount", "isRealSvrFeed", "feedId", "isRegInChina", "isSelf", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "isShowAtWxProfile", "isTest", "isThreePartyProduct", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "isUseCenterInside", "radio", "isUserBlocked", "isUserDeleting", "isWxScene", "isWxSelf", "jumpLocation", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "showShareIcon", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "isDirectToMapUI", "jumpToWxProfile", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "feedUsername", "intent", "addBlackListener", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedUserName", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "loadPagLib", "makeMediaTypeHappy", "content", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "default", "mergeBackCacheAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "updateLoaderLastBuf", "millisToUnixTime", "timestamp", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "newFeedStyle", "switchValue", "parsePrice", "price", "postCommentCountChangedEvent", "it", "postExposeDelEvent", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentId", "clientId", "printAllItem", "printFinderMessages", "reportCollectUnreadItem", "remain", "resize2Even", "value", "saveCacheToIntent", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "style", "setPriceTypeFace", "Landroid/widget/TextView;", "setSpanTouch", "text", "Landroid/text/Spannable;", "setToMachineTab", "onClick", "Lkotlin/Function0;", "setToNearbyLiveMorePage", "setToTargetTab", "tabName", "setVisibility", "visibility", "shake", "Landroid/animation/ObjectAnimator;", "shakeFactor", "showBanToast", "wording", "showFeedCommentInput", "ifShow", "showFinderTabType", "showLongVideoEntrance", "finderItem", "sourceFlagToLocalTypeFlag", "sourceType", "switchScene", "tabTypeToSourceFlag", "testStack", "transformColor", "begin", "percent", "tryCatchReleaseException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "extraMsg", "tryLoadPagLibrary", "prefix", "unixTimeToMillis", "toByteString", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "CenterFeed", "VisibleFeedDataObj", "plugin-finder_release"})
public final class y
{
  private static final String TAG = "Finder.FinderUtil";
  private static final boolean aXs;
  private static final int heightPixels;
  private static long lastClickTime;
  private static long tCi;
  public static int vXA;
  private static int vXB;
  private static int vXC;
  private static int vXD;
  private static int vXE;
  private static int vXF;
  private static int vXG;
  public static final y vXH;
  private static final int vXu;
  private static final int vXv;
  private static final Set<Integer> vXw;
  private static final Rect vXx;
  private static JSONObject vXy;
  private static boolean vXz;
  private static final int vfH;
  
  static
  {
    AppMethodBeat.i(167970);
    vXH = new y();
    TAG = "Finder.FinderUtil";
    Object localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    vXu = (int)((Context)localObject).getResources().getDimension(2131165289);
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    vXv = (int)((Context)localObject).getResources().getDimension(2131166812);
    vXw = ak.setOf(Integer.valueOf(2013));
    aXs = BuildInfo.DEBUG;
    vXx = new Rect();
    tCi = -1L;
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext().resources");
    heightPixels = ((Resources)localObject).getDisplayMetrics().heightPixels;
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vfH = ((Number)com.tencent.mm.plugin.finder.storage.c.dvI().value()).intValue();
    vXz = true;
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXA = ((Number)com.tencent.mm.plugin.finder.storage.c.dwr().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXB = ((Number)com.tencent.mm.plugin.finder.storage.c.dws().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXC = ((Number)com.tencent.mm.plugin.finder.storage.c.dwt().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXD = ((Number)com.tencent.mm.plugin.finder.storage.c.dwu().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXE = ((Number)com.tencent.mm.plugin.finder.storage.c.dww().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXF = ((Number)com.tencent.mm.plugin.finder.storage.c.dwv().value()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    vXG = ((Number)com.tencent.mm.plugin.finder.storage.c.dwx().value()).intValue();
    AppMethodBeat.o(167970);
  }
  
  public static void A(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(178459);
    kotlin.g.b.p.h(paramFinderItem, "it");
    hv localhv = new hv();
    localhv.dMr.feedId = paramFinderItem.field_id;
    localhv.dMr.dMt = paramFinderItem.getCommentCount();
    EventCenter.instance.publish((IEvent)localhv);
    AppMethodBeat.o(178459);
  }
  
  public static boolean B(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253638);
    kotlin.g.b.p.h(paramFinderItem, "item");
    if ((paramFinderItem.getFeedObject().incFriendLikeCount > 0) && (paramFinderItem.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(253638);
      return true;
    }
    AppMethodBeat.o(253638);
    return false;
  }
  
  public static boolean C(FinderItem paramFinderItem)
  {
    Object localObject1 = null;
    AppMethodBeat.i(253670);
    kotlin.g.b.p.h(paramFinderItem, "feed");
    Object localObject2 = com.tencent.mm.kernel.g.af(ad.class);
    kotlin.g.b.p.g(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)localObject2).dxX())
    {
      AppMethodBeat.o(253670);
      return false;
    }
    if (!x(paramFinderItem.getFinderObject()))
    {
      AppMethodBeat.o(253670);
      return false;
    }
    if (D(paramFinderItem))
    {
      AppMethodBeat.o(253670);
      return true;
    }
    if (paramFinderItem.getMediaType() == 2)
    {
      localObject1 = paramFinderItem.getFeedObject().objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
        if (localObject1 != null)
        {
          localObject1 = paramFinderItem.getFeedObject().objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
            if ((localObject1 != null) && (((azr)localObject1).LJw == 0)) {}
          }
          else
          {
            localObject1 = paramFinderItem.getFeedObject().objectDesc;
            if (localObject1 == null) {
              break label202;
            }
            localObject1 = ((FinderObjectDesc)localObject1).feedBgmInfo;
            if (localObject1 == null) {
              break label202;
            }
            localObject1 = ((azr)localObject1).groupId;
            label165:
            localObject1 = (CharSequence)localObject1;
            if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
              break label207;
            }
          }
        }
      }
      label202:
      label207:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label212;
        }
        AppMethodBeat.o(253670);
        return false;
        localObject1 = null;
        break;
        localObject1 = null;
        break label165;
      }
      label212:
      paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
      if (paramFinderItem != null)
      {
        paramFinderItem = paramFinderItem.feedBgmInfo;
        if ((paramFinderItem != null) && (paramFinderItem.musicInfo != null))
        {
          AppMethodBeat.o(253670);
          return true;
        }
      }
      AppMethodBeat.o(253670);
      return false;
    }
    if (paramFinderItem.getMediaType() == 4)
    {
      localObject2 = paramFinderItem.getFeedObject().objectDesc;
      if (localObject2 != null) {
        localObject1 = ((FinderObjectDesc)localObject2).feedBgmInfo;
      }
      if (localObject1 != null)
      {
        paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
        if (paramFinderItem != null)
        {
          paramFinderItem = paramFinderItem.feedBgmInfo;
          if ((paramFinderItem == null) || (paramFinderItem.LJw != 1)) {}
        }
      }
      else
      {
        AppMethodBeat.o(253670);
        return true;
      }
      AppMethodBeat.o(253670);
      return false;
    }
    AppMethodBeat.o(253670);
    return false;
  }
  
  public static boolean D(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253671);
    kotlin.g.b.p.h(paramFinderItem, "finderItem");
    if ((!Util.isNullOrNil((List)paramFinderItem.getLongVideoMediaList())) && (vfH == 1))
    {
      AppMethodBeat.o(253671);
      return true;
    }
    AppMethodBeat.o(253671);
    return false;
  }
  
  public static int Gg(long paramLong)
  {
    return (int)(paramLong / 1000L);
  }
  
  public static String Gi(long paramLong)
  {
    AppMethodBeat.i(253693);
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = new Date(paramLong);
    kotlin.g.b.p.g(localObject1, "date");
    ((Calendar)localObject1).setTime((Date)localObject2);
    int i = ((Calendar)localObject1).get(6);
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date(cl.aWA());
    kotlin.g.b.p.g(localCalendar, "todayDate");
    localCalendar.setTime(localDate);
    i -= localCalendar.get(6);
    Log.i(TAG, "[getFinderLiveNoticeTips] dayDiff:" + i + ", bookTime:" + localObject2 + ", todayTime:" + localDate);
    localObject2 = k.j(MMApplicationContext.getContext(), paramLong);
    if (LocaleUtil.isChineseAppLang()) {
      switch (i)
      {
      default: 
        i = ((Calendar)localObject1).get(7);
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localObject1, "MMApplicationContext.getContext()");
        localObject1 = localObject1.getResources().getStringArray(2130903094)[((i + 5) % 7)];
        localObject1 = MMApplicationContext.getContext().getString(2131759915, new Object[] { DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(2131760813), paramLong), localObject1 }) + (CharSequence)localObject2;
      }
    }
    for (;;)
    {
      Log.d(TAG, "result:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(253693);
      return localObject1;
      localObject1 = MMApplicationContext.getContext().getString(2131760868) + (CharSequence)localObject2;
      continue;
      localObject1 = MMApplicationContext.getContext().getString(2131760859) + (CharSequence)localObject2;
      continue;
      localObject1 = MMApplicationContext.getContext().getString(2131760860) + (CharSequence)localObject2;
      continue;
      localObject1 = MMApplicationContext.getContext().getString(2131759914) + (CharSequence)localObject2;
      continue;
      i = ((Calendar)localObject1).get(1);
      int j = ((Calendar)localObject1).get(2);
      int k = ((Calendar)localObject1).get(5);
      localObject1 = i + '.' + (j + 1) + '.' + k + ' ' + (CharSequence)localObject2;
    }
  }
  
  public static boolean Gj(long paramLong)
  {
    return (paramLong > 2147483647L) || (paramLong < -2147483648L);
  }
  
  public static boolean In(String paramString)
  {
    AppMethodBeat.i(167957);
    if ((!Util.isNullOrNil(z.aUg())) && (!Util.isNullOrNil(paramString)) && (kotlin.n.n.I(paramString, z.aUg(), false)))
    {
      AppMethodBeat.o(167957);
      return true;
    }
    AppMethodBeat.o(167957);
    return false;
  }
  
  public static String LA(int paramInt)
  {
    AppMethodBeat.i(167961);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      localObject1 = new StringBuilder();
      localObject2 = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject2).azM() + "finder/page/";
      AppMethodBeat.o(167961);
      return localObject1;
      localObject1 = "follow";
      continue;
      localObject1 = "feed";
      continue;
      localObject1 = "fans";
      continue;
      localObject1 = "preload";
      continue;
      localObject1 = "activity";
    }
    localObject2 = new StringBuilder();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    localObject1 = locale.azM() + "finder/page/" + (String)localObject1 + '/';
    AppMethodBeat.o(167961);
    return localObject1;
  }
  
  public static int LB(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 3: 
      return 17;
    case 1: 
      return 18;
    case 4: 
      return 20;
    }
    return 16;
  }
  
  public static boolean LC(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String LD(int paramInt)
  {
    AppMethodBeat.i(167967);
    String str;
    if (paramInt == 2)
    {
      str = z.aUa();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(167967);
      return localObject;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.c.tsp;
    localObject = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.finder.api.g)localObject).getNickname();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    AppMethodBeat.o(167967);
    return localObject;
  }
  
  public static String LE(int paramInt)
  {
    AppMethodBeat.i(178461);
    if (paramInt == 2)
    {
      str = z.aTY();
      kotlin.g.b.p.g(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(178461);
      return str;
    }
    String str = z.aUg();
    kotlin.g.b.p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(178461);
    return str;
  }
  
  public static int LF(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    return i;
  }
  
  public static boolean LG(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean LH(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean LI(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static int LJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 1: 
      return 0;
    case 512: 
      return 5;
    case 2048: 
      return 7;
    case 1024: 
      return 6;
    case 128: 
      return 4;
    case 2: 
      return 1;
    case 4: 
      return 2;
    case 4096: 
      return 8;
    case 256: 
      return 10;
    }
    return 14;
  }
  
  public static ar.a LK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ar.a.OkS;
    case 0: 
      return ar.a.OkS;
    case 1: 
      return ar.a.OkT;
    case 3: 
      return ar.a.OkU;
    case 2: 
      return ar.a.OkV;
    }
    return ar.a.Ola;
  }
  
  public static int LL(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 3: 
      return 2048;
    case 1: 
      return 512;
    case 2: 
      return 1024;
    case 4: 
      return 4096;
    }
    return 33024;
  }
  
  public static boolean LM(int paramInt)
  {
    return (0x8000 & paramInt) != 0;
  }
  
  public static boolean LN(int paramInt)
  {
    return (0x10000 & paramInt) != 0;
  }
  
  public static boolean LO(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 25: 
    case 27: 
    case 29: 
    case 31: 
    case 34: 
    default: 
      return false;
    }
    return true;
  }
  
  public static String LP(int paramInt)
  {
    AppMethodBeat.i(253633);
    switch (paramInt)
    {
    default: 
      String str = "unknow ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(253633);
      return str;
    case 0: 
      AppMethodBeat.o(253633);
      return "TAB_TYPE_ALL";
    case 1: 
      AppMethodBeat.o(253633);
      return "TAB_TYPE_FRIEND";
    case 2: 
      AppMethodBeat.o(253633);
      return "TAB_TYPE_LBS";
    case 3: 
      AppMethodBeat.o(253633);
      return "TAB_TYPE_FOLLOW";
    }
    AppMethodBeat.o(253633);
    return "TAB_TYPE_MACHINE";
  }
  
  public static int LQ(int paramInt)
  {
    if (paramInt == 2) {
      return 2131099662;
    }
    return 2131100044;
  }
  
  public static int LR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    case 11: 
      return 5;
    case 14: 
      return 6;
    case 15: 
      return 7;
    }
    return 15;
  }
  
  public static String LS(int paramInt)
  {
    AppMethodBeat.i(253656);
    String str = "¥" + new DecimalFormat("0.00").format(paramInt / 100.0D);
    AppMethodBeat.o(253656);
    return str;
  }
  
  public static String LT(int paramInt)
  {
    AppMethodBeat.i(253658);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(253658);
      return "0";
    }
    if (paramInt < 10000)
    {
      AppMethodBeat.o(253658);
      return String.valueOf(paramInt);
    }
    if (paramInt % 10000 >= 10000)
    {
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = ae.SYK;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getResources().getString(2131760361);
        kotlin.g.b.p.g(localObject, "MMApplicationContext.get…mber_more_than_100000000)");
        localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(paramInt / 10000.0F) }, 1));
        kotlin.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(253658);
        return localObject;
      }
      localObject = ae.SYK;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131760364);
      kotlin.g.b.p.g(localObject, "MMApplicationContext.get…r_more_than_100000000_v2)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt / 1000) }, 1));
      kotlin.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(253658);
      return localObject;
    }
    if (paramInt % 10000 >= 1000)
    {
      if (LocaleUtil.isChineseAppLang())
      {
        localObject = ae.SYK;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getResources().getString(2131759969);
        kotlin.g.b.p.g(localObject, "MMApplicationContext.get…r_live_like_count_format)");
        localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Float.valueOf(paramInt / 10000.0F) }, 1));
        kotlin.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(253658);
        return localObject;
      }
      localObject = ae.SYK;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(2131759970);
      kotlin.g.b.p.g(localObject, "MMApplicationContext.get…count_format_not_chinese)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt / 1000) }, 1));
      kotlin.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(253658);
      return localObject;
    }
    Object localObject = ae.SYK;
    localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131759971);
    kotlin.g.b.p.g(localObject, "MMApplicationContext.get…ve_like_count_int_format)");
    localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt / 10000) }, 1));
    kotlin.g.b.p.g(localObject, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(253658);
    return localObject;
  }
  
  public static String LU(int paramInt)
  {
    AppMethodBeat.i(253659);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(253659);
      return "0";
    }
    if (paramInt < 100)
    {
      AppMethodBeat.o(253659);
      return String.valueOf(paramInt);
    }
    AppMethodBeat.o(253659);
    return "...";
  }
  
  private static ArrayList<List<String>> LV(int paramInt)
  {
    AppMethodBeat.i(253665);
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 24)
    {
      localObject3 = LX(i);
      localObject4 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject4, "MMApplicationContext.getContext()");
      ((ArrayList)localObject2).add(((Context)localObject4).getResources().getString(2131760138, new Object[] { localObject3 }));
      i += 1;
    }
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      Log.i("getNoticePicker", (String)((Iterator)localObject3).next());
    }
    i = 0;
    while (i < paramInt)
    {
      ((ArrayList)localObject1).add(localObject2);
      i += 1;
    }
    localObject2 = ((ArrayList)localObject2).clone();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
      AppMethodBeat.o(253665);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ArrayList)localObject2;
    localObject3 = new Date(dCO());
    Object localObject4 = Calendar.getInstance();
    kotlin.g.b.p.g(localObject4, "date");
    ((Calendar)localObject4).setTime((Date)localObject3);
    i = ((Calendar)localObject4).get(11);
    paramInt = 0;
    while (paramInt < i)
    {
      ((ArrayList)localObject2).remove(0);
      paramInt += 1;
    }
    ((ArrayList)localObject1).remove(0);
    if (((Date)localObject3).getMinutes() >= 55) {
      ((ArrayList)localObject2).remove(0);
    }
    if (!((Collection)localObject2).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        ((ArrayList)localObject1).add(0, localObject2);
      }
      AppMethodBeat.o(253665);
      return localObject1;
    }
  }
  
  private static ArrayList<List<String>> LW(int paramInt)
  {
    AppMethodBeat.i(253666);
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = kotlin.k.j.a((kotlin.k.d)kotlin.k.j.mY(0, 60), 5);
    int j = ((kotlin.k.d)localObject3).SYU;
    int k = ((kotlin.k.d)localObject3).SYV;
    int m = ((kotlin.k.d)localObject3).lCq;
    if (m >= 0)
    {
      if (j <= k) {
        i = j;
      }
    }
    else {
      do
      {
        for (;;)
        {
          localObject3 = LX(i);
          localObject4 = MMApplicationContext.getContext();
          kotlin.g.b.p.g(localObject4, "MMApplicationContext.getContext()");
          ((ArrayList)localObject2).add(((Context)localObject4).getResources().getString(2131760139, new Object[] { localObject3 }));
          if (i == k) {
            break;
          }
          i += m;
        }
        i = j;
      } while (j >= k);
    }
    localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      Log.i("getNoticePicker", (String)((Iterator)localObject3).next());
    }
    int i = 0;
    while (i < paramInt)
    {
      ((ArrayList)localObject1).add(localObject2);
      i += 1;
    }
    localObject2 = ((ArrayList)localObject2).clone();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
      AppMethodBeat.o(253666);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ArrayList)localObject2;
    localObject3 = new Date(dCO());
    Object localObject4 = Calendar.getInstance();
    kotlin.g.b.p.g(localObject4, "date");
    ((Calendar)localObject4).setTime((Date)localObject3);
    i = ((Calendar)localObject4).get(12) / 5;
    paramInt = 0;
    while (paramInt < i + 1)
    {
      ((ArrayList)localObject2).remove(0);
      paramInt += 1;
    }
    ((ArrayList)localObject1).remove(0);
    if (!((Collection)localObject2).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        ((ArrayList)localObject1).add(0, localObject2);
      }
      AppMethodBeat.o(253666);
      return localObject1;
    }
  }
  
  public static String LX(int paramInt)
  {
    AppMethodBeat.i(253667);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(253667);
      return str;
    }
    AppMethodBeat.o(253667);
    return String.valueOf(paramInt);
  }
  
  public static boolean LY(int paramInt)
  {
    AppMethodBeat.i(253676);
    dCS();
    if ((vXA == 1) || ((vXB == 1) && (paramInt == 4)) || ((vXC == 1) && (paramInt == 3)) || ((vXD == 1) && (paramInt == 1)))
    {
      AppMethodBeat.o(253676);
      return true;
    }
    AppMethodBeat.o(253676);
    return false;
  }
  
  public static int Lt(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static long Lz(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static FinderImgFeedMusicTag X(RecyclerView.v paramv)
  {
    AppMethodBeat.i(253669);
    Object localObject;
    if (paramv != null)
    {
      paramv = paramv.aus;
      if (paramv != null)
      {
        paramv = (FinderImgFeedMusicTag)paramv.findViewById(2131297363);
        if (paramv == null) {
          break label82;
        }
        localObject = paramv.getTag(2131301376);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = paramv.getTag(2131301376);
        if (localObject == null)
        {
          paramv = new t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(253669);
          throw paramv;
          paramv = null;
          break;
          label82:
          localObject = null;
          continue;
        }
        if (((Boolean)localObject).booleanValue()) {
          break label107;
        }
      }
    }
    paramv = null;
    label107:
    for (;;)
    {
      AppMethodBeat.o(253669);
      return paramv;
    }
  }
  
  public static int a(BaseFinderFeed paramBaseFinderFeed, cjl paramcjl, int paramInt)
  {
    AppMethodBeat.i(253585);
    kotlin.g.b.p.h(paramBaseFinderFeed, "item");
    kotlin.g.b.p.h(paramcjl, "mediaObj");
    if (paramInt > 0)
    {
      paramcjl = com.tencent.mm.plugin.finder.storage.data.j.a(paramcjl, false);
      int i;
      int j;
      if ((paramBaseFinderFeed.feedObject.isLiveFeed()) || (paramcjl.getWidth() <= 0))
      {
        i = (int)(3.5D * paramInt / 3.0D);
        if (i <= paramInt * 1.316667F) {
          break label104;
        }
        j = (int)(paramInt * 1.316667F);
      }
      for (;;)
      {
        AppMethodBeat.o(253585);
        return j;
        i = paramcjl.getHeight() * paramInt / paramcjl.getWidth();
        break;
        label104:
        j = i;
        if (i < paramInt * 0.95F)
        {
          j = (int)(paramInt * 0.95F);
          Log.i(TAG, "calculateStaggeredLayoutParams: originWidth:" + paramInt + " targetHeightL:" + j);
        }
      }
    }
    AppMethodBeat.o(253585);
    return 0;
  }
  
  public static int a(bo parambo, List<? extends bo> paramList)
  {
    AppMethodBeat.i(253646);
    kotlin.g.b.p.h(paramList, "feedList");
    if (parambo != null)
    {
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      int j = 0;
      for (;;)
      {
        k = j;
        if (!paramList.hasNext()) {
          break;
        }
        Object localObject = paramList.next();
        k = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        if (((bo)localObject).lT() == parambo.lT())
        {
          j = i;
          i = k;
        }
        else
        {
          i = k;
        }
      }
    }
    int k = 0;
    AppMethodBeat.o(253646);
    return k;
  }
  
  public static int a(cjk paramcjk)
  {
    AppMethodBeat.i(167947);
    kotlin.g.b.p.h(paramcjk, "content");
    if (paramcjk.mediaList.size() == 0)
    {
      AppMethodBeat.o(167947);
      return 4;
    }
    int i = ((cjl)paramcjk.mediaList.get(0)).mediaType;
    com.tencent.mm.plugin.finder.storage.logic.c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    if (!com.tencent.mm.plugin.finder.storage.logic.c.a.dyN().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167947);
      return i;
    }
    if ((i == 4) && (paramcjk.mediaList.size() > 1))
    {
      AppMethodBeat.o(167947);
      return 8;
    }
    paramcjk = paramcjk.mediaList;
    if (paramcjk != null)
    {
      paramcjk = ((Iterable)paramcjk).iterator();
      while (paramcjk.hasNext()) {
        if (((cjl)paramcjk.next()).mediaType != i)
        {
          AppMethodBeat.o(167947);
          return 8;
        }
      }
    }
    AppMethodBeat.o(167947);
    return i;
  }
  
  public static Intent a(BaseFinderFeedLoader paramBaseFinderFeedLoader, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(253642);
    kotlin.g.b.p.h(paramBaseFinderFeedLoader, "feedLoader");
    kotlin.g.b.p.h(paramLinearLayoutManager, "layoutManager");
    Intent localIntent = new Intent();
    DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataListJustForAdapter();
    com.tencent.mm.bw.b localb = paramBaseFinderFeedLoader.getLastBuffer();
    int k = paramBaseFinderFeedLoader.getInitPos();
    int j = paramLinearLayoutManager.ks();
    int m = paramLinearLayoutManager.ku();
    Log.i(TAG, "fixRVPos posStart:" + j + ", posEnd " + m + ", initPos:" + k);
    int i = j;
    if (k >= j)
    {
      i = j;
      if (k <= m) {
        i = -1;
      }
    }
    BaseFeedLoader.saveCacheToIntent$default(paramBaseFinderFeedLoader, localIntent, (List)localDataBuffer, localb, i, null, 16, null);
    AppMethodBeat.o(253642);
    return localIntent;
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, boolean paramBoolean, g.a parama, g.b paramb, int paramInt2, long paramLong, String paramString7)
  {
    AppMethodBeat.i(253648);
    kotlin.g.b.p.h(paramString1, "mediaId");
    kotlin.g.b.p.h(paramString2, "url");
    kotlin.g.b.p.h(paramString3, "path");
    kotlin.g.b.p.h(paramString4, "fileFormat");
    kotlin.g.b.p.h(paramString5, "urlToken");
    kotlin.g.b.p.h(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool = com.tencent.mm.plugin.finder.storage.c.dsh();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
    ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
    ((com.tencent.mm.i.h)localObject).isHotSnsVideo = paramBoolean;
    ((com.tencent.mm.i.h)localObject).gqO = 2;
    ((com.tencent.mm.i.h)localObject).gqU = 2;
    ((com.tencent.mm.i.h)localObject).gqP = 8;
    ((com.tencent.mm.i.h)localObject).gqZ = paramInt2;
    ((com.tencent.mm.i.h)localObject).field_preloadRatio = paramInt2;
    ((com.tencent.mm.i.h)localObject).concurrentCount = k.a.wEc;
    ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUr;
    ((com.tencent.mm.i.h)localObject).field_fileType = com.tencent.mm.i.a.gpV;
    ((com.tencent.mm.i.h)localObject).preloadMinSize = paramLong;
    ((com.tencent.mm.i.h)localObject).grb = 0;
    ((com.tencent.mm.i.h)localObject).gqy = parama;
    ((com.tencent.mm.i.h)localObject).gqQ = paramb;
    int i;
    if (!bool) {
      if (paramInt1 <= 0)
      {
        i = com.tencent.mm.modelcontrol.e.L(1, paramString3);
        ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      Log.i(paramString7, "[createVideoPreloadTask] finder video, isHot=" + paramBoolean + " reqFormat=" + paramInt1 + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + " preloadPercent:" + paramInt2 + " preloadMinSize:" + paramLong);
      AppMethodBeat.o(253648);
      return localObject;
      i = paramInt1;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, boolean paramBoolean, h.a parama, String paramString7)
  {
    AppMethodBeat.i(253647);
    kotlin.g.b.p.h(paramString1, "mediaId");
    kotlin.g.b.p.h(paramString2, "url");
    kotlin.g.b.p.h(paramString3, "path");
    kotlin.g.b.p.h(paramString4, "fileFormat");
    kotlin.g.b.p.h(paramString5, "urlToken");
    kotlin.g.b.p.h(parama, "videoCallback");
    kotlin.g.b.p.h(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool = com.tencent.mm.plugin.finder.storage.c.dsh();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).taskName = "task_FinderUtil";
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).gqC = 60;
    ((com.tencent.mm.i.h)localObject).gqD = 60;
    ((com.tencent.mm.i.h)localObject).gqU = 1;
    ((com.tencent.mm.i.h)localObject).gqP = 8;
    ((com.tencent.mm.i.h)localObject).grb = 0;
    int i;
    if (!bool) {
      if (paramInt <= 0)
      {
        i = com.tencent.mm.modelcontrol.e.L(1, paramString3);
        ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
      ((com.tencent.mm.i.h)localObject).concurrentCount = k.a.wEc;
      ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUs;
      ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
      ((com.tencent.mm.i.h)localObject).isHotSnsVideo = paramBoolean;
      ((com.tencent.mm.i.h)localObject).gre = parama;
      Log.i(paramString7, "[loadByCdn] finder video, isHot=" + paramBoolean + " reqFormat=" + paramInt + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + ' ');
      AppMethodBeat.o(253647);
      return localObject;
      i = paramInt;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.h a(Intent paramIntent, RecyclerView paramRecyclerView, BaseFeedLoader<bo> paramBaseFeedLoader, boolean paramBoolean, kotlin.g.a.b<? super bo, Boolean> paramb)
  {
    AppMethodBeat.i(253643);
    kotlin.g.b.p.h(paramIntent, "data");
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramBaseFeedLoader, "feedLoader");
    RecyclerView.a locala = paramRecyclerView.getAdapter();
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    paramBaseFeedLoader.initBackCache(paramIntent);
    com.tencent.mm.plugin.finder.feed.model.h localh = paramBaseFeedLoader.getBackCache();
    if (((locala instanceof WxRecyclerAdapter)) && ((paramRecyclerView instanceof StaggeredGridLayoutManager)) && (localh != null) && (!Util.isNullOrNil((List)localh.kgc)) && (localh.lastBuffer != null))
    {
      int k = ((WxRecyclerAdapter)locala).RqM.size();
      DataBuffer localDataBuffer = paramBaseFeedLoader.getDataList();
      int i;
      Object localObject1;
      if (paramb == null)
      {
        paramb = (Iterable)localDataBuffer;
        paramIntent = (Collection)new ArrayList();
        paramb = paramb.iterator();
        i = 0;
        if (paramb.hasNext())
        {
          localObject1 = paramb.next();
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          if (i >= k) {}
          for (int j = 1;; j = 0)
          {
            if (j != 0) {
              paramIntent.add(localObject1);
            }
            i += 1;
            break;
          }
        }
        paramIntent = (List)paramIntent;
      }
      while (paramIntent.size() != localh.kgc.size())
      {
        paramIntent = ((Iterable)paramIntent).iterator();
        for (;;)
        {
          if (paramIntent.hasNext())
          {
            localDataBuffer.remove((bo)paramIntent.next());
            continue;
            paramIntent = new ArrayList();
            localObject1 = (Iterable)localDataBuffer;
            i = 0;
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = ((Iterator)localObject1).next();
              if (i < 0) {
                kotlin.a.j.hxH();
              }
              localObject2 = (bo)localObject2;
              if ((i >= k) && (((Boolean)paramb.invoke(localObject2)).booleanValue())) {
                paramIntent.add(localObject2);
              }
              i += 1;
            }
            paramIntent = (List)paramIntent;
            break;
          }
        }
        localDataBuffer.addAll((Collection)localh.kgc);
        if (paramBoolean) {
          paramBaseFeedLoader.setLastBuffer(localh.lastBuffer);
        }
        locala.notifyDataSetChanged();
      }
      if (localh.position >= 0)
      {
        i = a(n(localh.position, (List)localh.kgc), (List)localDataBuffer);
        ((StaggeredGridLayoutManager)paramRecyclerView).ah(i + k, 0);
      }
      Log.i(TAG, "mergeBackCacheAndNotify, pos:" + localh.position + ", headCount:" + k);
      AppMethodBeat.o(253643);
      return localh;
    }
    AppMethodBeat.o(253643);
    return null;
  }
  
  public static y.b a(final RecyclerView paramRecyclerView, final Rect paramRect)
  {
    AppMethodBeat.i(253624);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    kotlin.g.b.p.h(paramRect, "globalVisibleRect");
    final y.b localb = new y.b();
    final RecyclerView.a locala = paramRecyclerView.getAdapter();
    if ((locala instanceof WxRecyclerAdapter))
    {
      int k = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < k)
      {
        final View localView = paramRecyclerView.getChildAt(i);
        Object localObject;
        final com.tencent.mm.view.recyclerview.a locala1;
        int j;
        final com.tencent.mm.plugin.finder.event.base.g localg;
        final com.tencent.mm.view.recyclerview.i locali;
        if (localView != null)
        {
          localObject = paramRecyclerView.bi(localView);
          if ((localObject != null) && ((localObject instanceof com.tencent.mm.view.recyclerview.h)))
          {
            locala1 = (com.tencent.mm.view.recyclerview.a)((com.tencent.mm.view.recyclerview.h)localObject).hgv();
            j = RecyclerView.bw(localView);
            int m = ((WxRecyclerAdapter)locala).RqM.size();
            if (((locala1 instanceof bo)) && (locala1.lT() != 0L))
            {
              localg = new com.tencent.mm.plugin.finder.event.base.g((bo)locala1, j - m, (byte)0);
              if (!(locala1 instanceof BaseFinderFeed)) {
                break label558;
              }
              locali = (com.tencent.mm.view.recyclerview.i)((WxRecyclerAdapter)locala).Rrv.get(locala1.lT());
              if (locali != null)
              {
                if (((BaseFinderFeed)locala1).feedObject.getFoldedLayout() != null)
                {
                  localObject = new Rect();
                  paramRecyclerView.getChildVisibleRect(localView, (Rect)localObject, null);
                  locali.Rrc = paramRect.top;
                  locali.Rrd = paramRect.bottom;
                  locali.Rrb = ((Rect)localObject).top;
                  localObject = (FinderFoldedScrollLayout)localView.findViewById(2131300570);
                  if (localObject != null)
                  {
                    if (((FinderFoldedScrollLayout)localObject).getVisibility() != 0) {
                      break label450;
                    }
                    j = 1;
                    label286:
                    if (j == 0) {
                      break label455;
                    }
                    label290:
                    if (localObject != null)
                    {
                      ViewParent localViewParent = ((FinderFoldedScrollLayout)localObject).getParent();
                      if (localViewParent != null)
                      {
                        localViewParent = localViewParent.getParent();
                        if ((localViewParent != null) && ((localViewParent instanceof View)))
                        {
                          locali.Rre = ((View)localViewParent).getTop();
                          locali.Rri = new WeakReference(((FinderFoldedScrollLayout)localObject).getAdapter());
                          locali.Rrh = ((FinderFoldedScrollLayout)localObject).getAdapter().Rry;
                          if (locali.Rre != 0) {
                            break label461;
                          }
                          ((View)localViewParent).post((Runnable)new k(localViewParent, (FinderFoldedScrollLayout)localObject, locali, locala1, localg, localView, paramRecyclerView, locala, paramRect, localb));
                        }
                      }
                    }
                  }
                }
                label417:
                localg.tIw = locali;
              }
            }
          }
        }
        for (;;)
        {
          if (!(locala1 instanceof com.tencent.mm.plugin.finder.model.x)) {
            localb.vXL.add(localg);
          }
          i += 1;
          break;
          label450:
          j = 0;
          break label286;
          label455:
          localObject = null;
          break label290;
          label461:
          if (locali.Rrd - locali.Rrc - locali.Rrb > locali.Rre)
          {
            if (locali.Rrf) {
              break label417;
            }
            locali.Rrf = true;
            localObject = locali.Rri;
            if (localObject == null) {
              break label417;
            }
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject == null) {
              break label417;
            }
            ((WxRecyclerAdapter)localObject).onResume();
            break label417;
          }
          if (!locali.Rrf) {
            break label417;
          }
          locali.Rrf = false;
          locali.Rrg = true;
          break label417;
          label558:
          localObject = (com.tencent.mm.view.recyclerview.i)((WxRecyclerAdapter)locala).Rrv.get(locala1.lT());
          if (localObject != null) {
            localg.tIw = ((com.tencent.mm.view.recyclerview.i)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(253624);
    return localb;
  }
  
  public static com.tencent.mm.plugin.finder.view.d a(Context paramContext, String paramString, Intent paramIntent, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    AppMethodBeat.i(253608);
    kotlin.g.b.p.h(paramContext, "context");
    Log.i(TAG, "jump to wx profile %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    if (!Util.isNullOrNil(paramString)) {
      localIntent.putExtra("Username", paramString);
    }
    paramString = com.tencent.mm.plugin.finder.view.n.wpY;
    paramContext = n.a.a(paramContext, localIntent, paramb);
    AppMethodBeat.o(253608);
    return paramContext;
  }
  
  public static String a(com.tencent.mm.plugin.finder.model.a parama)
  {
    AppMethodBeat.i(253605);
    kotlin.g.b.p.h(parama, "item");
    Object localObject = parama.uNF;
    if (((com.tencent.mm.plugin.finder.storage.ao)localObject).isOverlap())
    {
      parama = new StringBuilder();
      localObject = ((com.tencent.mm.plugin.finder.storage.ao)localObject).field_aggregatedContacts.LIH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
        parama.append(hh(localFinderContact.username, localFinderContact.nickname)).append("，");
      }
      localObject = parama.toString();
      kotlin.g.b.p.g(localObject, "nickNameList.toString()");
      parama = (com.tencent.mm.plugin.finder.model.a)localObject;
      if (!Util.isNullOrNil((String)localObject))
      {
        int i = ((String)localObject).length();
        if (localObject == null)
        {
          parama = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(253605);
          throw parama;
        }
        parama = ((String)localObject).substring(0, i - 1);
        kotlin.g.b.p.g(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      AppMethodBeat.o(253605);
      return parama;
    }
    parama = hh(((com.tencent.mm.plugin.finder.storage.ao)localObject).field_username, ((com.tencent.mm.plugin.finder.storage.ao)localObject).field_nickname);
    AppMethodBeat.o(253605);
    return parama;
  }
  
  public static List<com.tencent.mm.plugin.finder.event.base.g> a(int paramInt1, int paramInt2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(253623);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    LinkedList localLinkedList = new LinkedList();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2))
    {
      paramRecyclerView = kotlin.a.j.v((Collection)localLinkedList);
      AppMethodBeat.o(253623);
      return paramRecyclerView;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    List localList;
    int i;
    Object localObject1;
    if ((paramRecyclerView instanceof WxRecyclerAdapter))
    {
      localList = (List)((WxRecyclerAdapter)paramRecyclerView).data;
      if (paramInt1 <= paramInt2) {
        for (;;)
        {
          i = paramInt1 - ((WxRecyclerAdapter)paramRecyclerView).RqM.size();
          if ((i >= 0) && (i < localList.size()))
          {
            Object localObject2 = (com.tencent.mm.view.recyclerview.a)localList.get(i);
            if ((((com.tencent.mm.view.recyclerview.a)localObject2).lT() != 0L) && ((localObject2 instanceof bo)))
            {
              localObject1 = new com.tencent.mm.plugin.finder.event.base.g((bo)localObject2, i, (byte)0);
              localObject2 = (com.tencent.mm.view.recyclerview.i)((WxRecyclerAdapter)paramRecyclerView).Rrv.get(((com.tencent.mm.view.recyclerview.a)localObject2).lT());
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.event.base.g)localObject1).tIw = ((com.tencent.mm.view.recyclerview.i)localObject2);
              }
              localLinkedList.add(localObject1);
            }
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
    }
    else if ((paramRecyclerView instanceof f.b))
    {
      localList = ((f.b)paramRecyclerView).dpH();
      if (paramInt1 <= paramInt2) {
        for (;;)
        {
          i = ((f.b)paramRecyclerView).KL(paramInt1);
          if ((i >= 0) && (i < localList.size()))
          {
            localObject1 = (BaseFinderFeed)localList.get(i);
            if (((BaseFinderFeed)localObject1).lT() != 0L) {
              localLinkedList.add(new com.tencent.mm.plugin.finder.event.base.g((bo)localObject1, i, (byte)0));
            }
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
    }
    paramRecyclerView = kotlin.a.j.v((Collection)localLinkedList);
    AppMethodBeat.o(253623);
    return paramRecyclerView;
  }
  
  public static <T, E> List<E> a(List<? extends T> paramList, Class<E> paramClass)
  {
    AppMethodBeat.i(253639);
    kotlin.g.b.p.h(paramList, "dataList");
    kotlin.g.b.p.h(paramClass, "clazz");
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (paramClass.isInstance(localObject)) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(253639);
    return localList;
  }
  
  public static r<Integer, Integer, Integer> a(Activity paramActivity, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253588);
    kotlin.g.b.p.h(paramActivity, "context");
    Point localPoint = com.tencent.mm.ui.ao.az((Context)paramActivity);
    int j;
    int i;
    if ((localPoint.x != 0) && (localPoint.y != 0))
    {
      j = 1;
      if (j == 0) {
        break label135;
      }
      i = localPoint.y;
      label52:
      if (j == 0) {
        break label161;
      }
      j = localPoint.x;
      label64:
      if (paramFloat2 / paramFloat1 <= i / j) {
        break label185;
      }
    }
    label135:
    label161:
    label185:
    for (int k = i;; k = (int)(j * paramFloat2 / paramFloat1))
    {
      if (i == k) {
        j = (int)(i * paramFloat1 / paramFloat2);
      }
      paramActivity = new r(Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(253588);
      return paramActivity;
      j = 0;
      break;
      Resources localResources = paramActivity.getResources();
      kotlin.g.b.p.g(localResources, "context.resources");
      i = localResources.getDisplayMetrics().heightPixels;
      break label52;
      paramActivity = paramActivity.getResources();
      kotlin.g.b.p.g(paramActivity, "context.resources");
      j = paramActivity.getDisplayMetrics().widthPixels;
      break label64;
    }
  }
  
  public static void a(final int paramInt, final TextView paramTextView, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(253627);
    kotlin.g.b.p.h(paramTextView, "tv");
    kotlin.g.b.p.h(parama, "onClick");
    Object localObject1 = paramTextView.getContext();
    kotlin.g.b.p.g(localObject1, "tv.context");
    localObject1 = ((Context)localObject1).getResources();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.c.vCb;
    localObject1 = ((Resources)localObject1).getString(2131759807, new Object[] { com.tencent.mm.plugin.finder.storage.c.dsg() });
    kotlin.g.b.p.g(localObject1, "tv.context.resources.get…abType.TAB_TYPE_MACHINE))");
    localObject2 = paramTextView.getContext();
    kotlin.g.b.p.g(localObject2, "tv.context");
    localObject2 = ((Context)localObject2).getResources();
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    localObject2 = ((Resources)localObject2).getString(2131759808, new Object[] { com.tencent.mm.plugin.finder.storage.c.dsg() });
    kotlin.g.b.p.g(localObject2, "tv.context.resources.get…abType.TAB_TYPE_MACHINE))");
    int i = kotlin.n.n.a((CharSequence)localObject1, (String)localObject2, 0, false, 6);
    int j = i + ((String)localObject2).length();
    localObject2 = new SpannableString((CharSequence)localObject1);
    if ((i <= 0) || (j > ((String)localObject1).length()))
    {
      j = ((String)localObject1).length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject2).setSpan(new l(parama, paramInt, paramTextView), i, j, 33);
      parama = paramTextView.getContext();
      kotlin.g.b.p.g(parama, "tv.context");
      paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject2);
      AppMethodBeat.o(253627);
      return;
    }
  }
  
  public static void a(int paramInt, List<? extends bo> paramList, com.tencent.mm.bw.b paramb, Intent paramIntent, com.tencent.mm.plugin.finder.feed.model.a parama)
  {
    AppMethodBeat.i(253640);
    kotlin.g.b.p.h(paramList, "feedList");
    kotlin.g.b.p.h(paramIntent, "intent");
    FinderEmptyLoader localFinderEmptyLoader = new FinderEmptyLoader();
    localFinderEmptyLoader.getDataList().addAll((Collection)paramList);
    localFinderEmptyLoader.setLastBuffer(paramb);
    localFinderEmptyLoader.saveCache(paramIntent, paramInt, parama);
    AppMethodBeat.o(253640);
  }
  
  public static void a(int paramInt, List<? extends bo> paramList, bbn parambbn)
  {
    AppMethodBeat.i(253630);
    kotlin.g.b.p.h(paramList, "remain");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (bo)paramList.next();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
      if (!e.a.al(paramInt, ((bo)localObject1).lT()))
      {
        localObject2 = new bdv();
        ((bdv)localObject2).hFK = ((bo)localObject1).lT();
        if ((localObject1 instanceof BaseFinderFeed)) {
          ((bdv)localObject2).objectNonceId = ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId();
        }
        if (parambbn != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          ((bdv)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.k.G(((bdv)localObject2).hFK, parambbn.tCE);
        }
        ((bdv)localObject2).dLS = 4;
        localLinkedList.add(localObject2);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        new com.tencent.mm.plugin.finder.cgi.a((List)localLinkedList, parambbn).aYI();
      }
      AppMethodBeat.o(253630);
      return;
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253653);
    hn localhn;
    hn.a locala;
    if (BuildInfo.IS_FLAVOR_PURPLE)
    {
      localhn = new hn();
      localhn.dLW.id = paramLong;
      locala = localhn.dLW;
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      locala.dLY = i;
      localhn.dLW.dLX = paramInt;
      localhn.dLW.type = 7;
      EventCenter.instance.publish((IEvent)localhn);
      AppMethodBeat.o(253653);
      return;
    }
  }
  
  public static void a(Activity paramActivity, float paramFloat1, float paramFloat2, View paramView, cjx paramcjx)
  {
    AppMethodBeat.i(253586);
    kotlin.g.b.p.h(paramActivity, "context");
    kotlin.g.b.p.h(paramView, "targetView");
    paramActivity = a(paramActivity, paramFloat1, paramFloat2);
    int i = ((Number)paramActivity.second).intValue();
    int j = ((Number)paramActivity.SWY).intValue();
    if (paramcjx != null)
    {
      paramFloat1 = i / paramFloat1;
      if (Float.compare(1.0F, paramFloat1) != 0)
      {
        Object localObject = paramcjx.Mpr;
        paramActivity = (Activity)localObject;
        if (localObject == null) {
          paramActivity = new bej();
        }
        kotlin.g.b.p.g(paramActivity, "it.matrix ?: FinderViewMatrix()");
        localObject = new Matrix();
        paramActivity = paramActivity.LOe;
        kotlin.g.b.p.g(paramActivity, "originMatrix.value");
        ((Matrix)localObject).setValues(kotlin.a.j.t((Collection)paramActivity));
        ((Matrix)localObject).postScale(paramFloat1, paramFloat1);
        paramActivity = new float[9];
        ((Matrix)localObject).getValues(paramActivity);
        localObject = paramcjx.Mpr;
        if (localObject != null)
        {
          localObject = ((bej)localObject).LOe;
          if (localObject != null) {
            ((LinkedList)localObject).clear();
          }
        }
        localObject = paramcjx.Mpr;
        if (localObject != null)
        {
          localObject = ((bej)localObject).LOe;
          if (localObject != null) {
            ((LinkedList)localObject).addAll((Collection)kotlin.a.e.s(paramActivity));
          }
        }
        paramcjx.width = i;
        paramcjx.height = j;
        paramActivity = paramcjx.Mpq;
        if (paramActivity != null) {
          paramActivity.left = 0;
        }
        paramActivity = paramcjx.Mpq;
        if (paramActivity != null) {
          paramActivity.right = i;
        }
        paramActivity = paramcjx.Mpq;
        if (paramActivity != null) {
          paramActivity.top = j;
        }
        paramActivity = paramcjx.Mpq;
        if (paramActivity != null) {
          paramActivity.bottom = 0;
        }
      }
    }
    paramcjx = paramView.getLayoutParams();
    paramActivity = paramcjx;
    if (paramcjx == null) {
      paramActivity = new ViewGroup.LayoutParams(i, j);
    }
    paramActivity.width = i;
    paramActivity.height = j;
    paramView.setLayoutParams(paramActivity);
    AppMethodBeat.o(253586);
  }
  
  public static void a(Context paramContext, axt paramaxt, boolean paramBoolean)
  {
    AppMethodBeat.i(253600);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramaxt, "location");
    if (Util.isNullOrNil(paramaxt.LIb))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("map_view_type", 7);
      localIntent.putExtra("kwebmap_slat", paramaxt.latitude);
      localIntent.putExtra("kwebmap_lng", paramaxt.dTj);
      String str = paramaxt.kHV;
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = paramaxt.fuK;
      }
      localIntent.putExtra("kPoiName", (String)localObject);
      localIntent.putExtra("Kwebmap_locaion", paramaxt.ErZ);
      localIntent.putExtra("kShowshare", paramBoolean);
      com.tencent.mm.br.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(253600);
      return;
    }
    Object localObject = ae.SYK;
    localObject = com.tencent.mm.protocal.d.KyX;
    kotlin.g.b.p.g(localObject, "ConstantsProtocal.MM_NEAR_LIFE_URI");
    paramaxt = String.format((String)localObject, Arrays.copyOf(new Object[] { paramaxt.LIb }, 1));
    kotlin.g.b.p.g(paramaxt, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramaxt);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(253600);
  }
  
  public static void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo, int paramInt)
  {
    AppMethodBeat.i(253649);
    kotlin.g.b.p.h(paramImageView, "view");
    paramImageView.setVisibility(8);
    Object localObject = paramImageView.getDrawable();
    if (localObject != null) {
      ((Drawable)localObject).setColorFilter(null);
    }
    if (paramFinderAuthInfo != null)
    {
      Log.i(TAG, "authType = " + paramFinderAuthInfo.authIconType + ", authIconUrl = " + paramFinderAuthInfo.authIconUrl);
      paramImageView.setVisibility(0);
      if (paramFinderAuthInfo.authIconType > 0)
      {
        switch (paramFinderAuthInfo.authIconType)
        {
        default: 
          paramImageView.setVisibility(8);
          AppMethodBeat.o(253649);
          return;
        case 1: 
          localObject = (CharSequence)paramFinderAuthInfo.authIconUrl;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
          for (int i = 1; i == 0; i = 0)
          {
            localObject = com.tencent.mm.plugin.finder.loader.m.uJa;
            localObject = com.tencent.mm.plugin.finder.loader.m.djY();
            paramFinderAuthInfo = new com.tencent.mm.plugin.finder.loader.p(paramFinderAuthInfo.authIconUrl, com.tencent.mm.plugin.finder.storage.x.vEn);
            com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
            ((com.tencent.mm.loader.d)localObject).a(paramFinderAuthInfo, paramImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb));
            AppMethodBeat.o(253649);
            return;
          }
          if (paramInt == 0)
          {
            paramImageView.setImageResource(2131690681);
            AppMethodBeat.o(253649);
            return;
          }
          paramImageView.setImageDrawable(ar.m(paramImageView.getContext(), 2131690678, com.tencent.mm.cb.a.n(paramImageView.getContext(), 2131100919)));
          AppMethodBeat.o(253649);
          return;
        case 2: 
          if (paramInt == 0)
          {
            paramImageView.setImageResource(2131690680);
            AppMethodBeat.o(253649);
            return;
          }
          paramImageView.setImageResource(2131690679);
          AppMethodBeat.o(253649);
          return;
        }
        paramImageView.setVisibility(8);
        AppMethodBeat.o(253649);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(253649);
      return;
    }
    AppMethodBeat.o(253649);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public static void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(253620);
    kotlin.g.b.p.h(paramTextView, "tv");
    kotlin.g.b.p.h(paramSpannable, "text");
    paramTextView.setOnTouchListener(eh((View)paramTextView));
    AppMethodBeat.o(253620);
  }
  
  public static void a(final TextView paramTextView, String paramString, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(253629);
    kotlin.g.b.p.h(paramTextView, "tv");
    kotlin.g.b.p.h(paramString, "tabName");
    kotlin.g.b.p.h(parama, "onClick");
    Object localObject = paramTextView.getContext();
    kotlin.g.b.p.g(localObject, "tv.context");
    localObject = ((Context)localObject).getResources().getString(2131763471);
    kotlin.g.b.p.g(localObject, "tv.context.resources.get…quare_tab_more_live_tips)");
    Context localContext = paramTextView.getContext();
    kotlin.g.b.p.g(localContext, "tv.context");
    paramString = localContext.getResources().getString(2131763472, new Object[] { paramString, localObject });
    kotlin.g.b.p.g(paramString, "tv.context.resources.get…s, tabName, gotoPageTips)");
    int i = kotlin.n.n.a((CharSequence)paramString, (String)localObject, 0, false, 6);
    int j = i + ((String)localObject).length();
    localObject = new SpannableString((CharSequence)paramString);
    if ((i <= 0) || (j > paramString.length()))
    {
      j = paramString.length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject).setSpan(new n(parama, paramTextView), i, j, 33);
      paramString = paramTextView.getContext();
      kotlin.g.b.p.g(paramString, "tv.context");
      paramTextView.setHighlightColor(paramString.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(253629);
      return;
    }
  }
  
  public static void a(final TextView paramTextView, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(253628);
    kotlin.g.b.p.h(paramTextView, "tv");
    kotlin.g.b.p.h(parama, "onClick");
    Object localObject1 = paramTextView.getContext();
    kotlin.g.b.p.g(localObject1, "tv.context");
    localObject1 = ((Context)localObject1).getResources().getString(2131763475);
    kotlin.g.b.p.g(localObject1, "tv.context.resources.get…rby_more_reomm_live_tips)");
    Object localObject2 = paramTextView.getContext();
    kotlin.g.b.p.g(localObject2, "tv.context");
    localObject2 = ((Context)localObject2).getResources().getString(2131763476, new Object[] { localObject1 });
    kotlin.g.b.p.g(localObject2, "tv.context.resources.get…_data_tips, gotoPageTips)");
    int i = kotlin.n.n.a((CharSequence)localObject2, (String)localObject1, 0, false, 6);
    int j = i + ((String)localObject1).length();
    localObject1 = new SpannableString((CharSequence)localObject2);
    if ((i <= 0) || (j > ((String)localObject2).length()))
    {
      j = ((String)localObject2).length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject1).setSpan(new m(parama, paramTextView), i, j, 33);
      parama = paramTextView.getContext();
      kotlin.g.b.p.g(parama, "tv.context");
      paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(253628);
      return;
    }
  }
  
  public static void a(com.tencent.mm.view.recyclerview.h paramh, String paramString, com.tencent.mm.plugin.finder.model.s params)
  {
    AppMethodBeat.i(253607);
    kotlin.g.b.p.h(paramh, "holder");
    kotlin.g.b.p.h(paramString, "feedUserName");
    kotlin.g.b.p.h(params, "item");
    if (kotlin.g.b.p.j(params.uOf.getUsername(), z.aTY()))
    {
      AppMethodBeat.o(253607);
      return;
    }
    Intent localIntent = new Intent();
    if ((!Util.isNullOrNil(paramString)) && (kotlin.g.b.p.j(paramString, z.aUg())))
    {
      if ((params.uOf.dyb().blacklist_flag == 0) && (!Util.isNullOrNil(params.uOf.getUsername())) && (!z.aTY().equals(params.uOf.getUsername()))) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("feedUser", paramString);
      localIntent.putExtra("Avatar", params.uOf.dyc());
      localIntent.putExtra("Nickname", params.uOf.getNickname());
      localIntent.putExtra("CommentId", params.uOf.dyb().commentId);
      localIntent.putExtra("FeedId", params.uOf.field_feedId);
      localIntent.putExtra("FeedNonceId", params.uOf.field_objectNonceId);
      paramString = params.uOf.dyb();
      if ((paramString != null) && (paramString.msgInfo != null))
      {
        paramString = params.uOf.dyb().msgInfo;
        if (paramString == null) {
          break label325;
        }
      }
    }
    label325:
    for (paramString = paramString.toByteArray();; paramString = null)
    {
      localIntent.putExtra("ContactMsgInfo", paramString);
      paramh = paramh.getContext();
      kotlin.g.b.p.g(paramh, "holder.context");
      a(paramh, params.uOf.getUsername(), localIntent, null);
      if (params.uOf.dyb() != null) {
        break label330;
      }
      Log.i(TAG, "commentInfo = null");
      AppMethodBeat.o(253607);
      return;
      localIntent.putExtra("Action", 2);
      break;
    }
    label330:
    if (params.uOf.dyb().msgInfo == null) {
      Log.i(TAG, "msgInfo is null ,feedId:" + params.uOf.field_feedId + ",comentId:" + params.uOf.dyb().commentId);
    }
    AppMethodBeat.o(253607);
  }
  
  public static void a(Exception paramException, String paramString)
  {
    AppMethodBeat.i(253691);
    kotlin.g.b.p.h(paramException, "e");
    kotlin.g.b.p.h(paramString, "extraMsg");
    if (dCM())
    {
      paramException = (Throwable)paramException;
      AppMethodBeat.o(253691);
      throw paramException;
    }
    Log.printInfoStack(TAG, paramString + ' ' + paramException.getMessage(), new Object[0]);
    AppMethodBeat.o(253691);
  }
  
  public static void a(LinkedList<FinderCommentInfo> paramLinkedList, long paramLong1, long paramLong2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(167960);
    kotlin.g.b.p.h(paramLinkedList, "commentList");
    kotlin.g.b.p.h(paramString, "clientId");
    int j;
    if (paramLong2 != 0L)
    {
      paramString = ((List)paramLinkedList).iterator();
      i = 0;
      if (paramString.hasNext()) {
        if (((FinderCommentInfo)paramString.next()).commentId == paramLong2)
        {
          j = 1;
          label75:
          if (j == 0) {
            break label181;
          }
        }
      }
    }
    Object localObject;
    label181:
    do
    {
      for (;;)
      {
        if (i >= 0)
        {
          paramLinkedList.remove(i);
          Log.i(TAG, "update expose commentList, remove at ".concat(String.valueOf(i)));
          paramString = new hv();
          paramString.dMr.feedId = paramLong1;
          localObject = paramString.dMr;
          azt localazt = new azt();
          localazt.commentList = paramLinkedList;
          ((hv.a)localObject).dMs = localazt;
          EventCenter.instance.publish((IEvent)paramString);
        }
        AppMethodBeat.o(167960);
        return;
        j = 0;
        break label75;
        i += 1;
        break;
        i = -1;
      }
      localObject = ((List)paramLinkedList).iterator();
      if (!((Iterator)localObject).hasNext()) {
        break label250;
      }
    } while (kotlin.g.b.p.j(((FinderCommentInfo)((Iterator)localObject).next()).client_id, paramString));
    for (;;)
    {
      i += 1;
      break;
      label250:
      i = -1;
    }
  }
  
  public static boolean a(final Context paramContext, String paramString, boolean paramBoolean, final bed parambed)
  {
    AppMethodBeat.i(253594);
    kotlin.g.b.p.h(paramContext, "activity");
    if (Util.isNullOrNil(z.aUg()))
    {
      Log.i(TAG, "need create finder contact");
      String str = paramContext.getString(2131759626);
      kotlin.g.b.p.g(str, "activity.getString(R.str…reate_contact_dialog_tip)");
      if (!Util.isNullOrNil(paramString)) {
        str = String.valueOf(paramString);
      }
      paramString = com.tencent.mm.plugin.finder.view.c.wjK;
      com.tencent.mm.plugin.finder.view.c.a.a(paramContext, paramContext.getString(2131759634), str, paramContext.getString(2131759632), paramContext.getString(2131759624), (DialogInterface.OnClickListener)new c(paramBoolean, parambed, paramContext), (DialogInterface.OnClickListener)new d(paramBoolean), (DialogInterface.OnDismissListener)new e(paramBoolean));
      AppMethodBeat.o(253594);
      return false;
    }
    AppMethodBeat.o(253594);
    return true;
  }
  
  public static boolean a(FinderObject paramFinderObject, String paramString)
  {
    AppMethodBeat.i(253598);
    kotlin.g.b.p.h(paramFinderObject, "obj");
    kotlin.g.b.p.h(paramString, "invokeSource");
    FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
    int i;
    if (localFinderObjectDesc != null)
    {
      i = localFinderObjectDesc.mediaType;
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject == null) {
        break label140;
      }
    }
    label140:
    for (paramFinderObject = Integer.valueOf(paramFinderObject.liveStatus);; paramFinderObject = null)
    {
      Log.d(TAG, paramString + " isAcceptLiveObj mediaType:" + i + " liveState:" + paramFinderObject);
      if (i == 9) {
        break label145;
      }
      Log.w(TAG, paramString + " isAcceptLiveObj return for invalid mediaType:" + i);
      AppMethodBeat.o(253598);
      return false;
      i = 0;
      break;
    }
    label145:
    if (paramFinderObject == null) {}
    while (paramFinderObject.intValue() != 2)
    {
      AppMethodBeat.o(253598);
      return true;
    }
    Log.w(TAG, paramString + " isAcceptLiveObj return for invalid liveState:" + paramFinderObject);
    AppMethodBeat.o(253598);
    return false;
  }
  
  public static void aF(Context paramContext, String paramString)
  {
    AppMethodBeat.i(253619);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "wording");
    u.a(paramContext, paramString, (u.b)o.vYd);
    AppMethodBeat.o(253619);
  }
  
  public static boolean af(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(253596);
    kotlin.g.b.p.h(paramContext, "context");
    if ((paramInt & 0x40) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        f.a locala = new f.a(MMApplicationContext.getContext());
        locala.bow(paramContext.getResources().getString(2131760260)).Dq(true);
        locala.apa(2131768713).b((f.c)h.vXR).b((DialogInterface.OnDismissListener)i.vXS).show();
      }
      AppMethodBeat.o(253596);
      return bool;
    }
  }
  
  public static void ai(View paramView, int paramInt)
  {
    AppMethodBeat.i(253636);
    if ((paramView != null) && (paramView.getVisibility() != paramInt)) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(253636);
  }
  
  public static String al(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(178462);
    kotlin.g.b.p.h(paramString1, "countryCode");
    kotlin.g.b.p.h(paramString2, "provinceCode");
    kotlin.g.b.p.h(paramString3, "cityCode");
    RegionCodeDecoder.gEm();
    String str1 = RegionCodeDecoder.getCountry(paramString1);
    RegionCodeDecoder.gEm();
    String str2 = RegionCodeDecoder.mV(paramString1, paramString2);
    RegionCodeDecoder.gEm();
    paramString1 = RegionCodeDecoder.br(paramString1, paramString2, paramString3);
    if (!Util.isNullOrNil(paramString1))
    {
      paramString1 = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).It(str2) + " " + paramString1;
      AppMethodBeat.o(178462);
      return paramString1;
    }
    if (!Util.isNullOrNil(str2))
    {
      paramString1 = str1 + ' ' + str2;
      AppMethodBeat.o(178462);
      return paramString1;
    }
    if (!Util.isNullOrNil(str1))
    {
      kotlin.g.b.p.g(str1, "countryName");
      AppMethodBeat.o(178462);
      return str1;
    }
    AppMethodBeat.o(178462);
    return "";
  }
  
  public static String aw(ca paramca)
  {
    AppMethodBeat.i(253631);
    kotlin.g.b.p.h(paramca, "msg");
    if (paramca.ajN() == 1)
    {
      paramca = z.aTY();
      kotlin.g.b.p.g(paramca, "ConfigStorageLogic.getUsernameFromUserInfo()");
    }
    for (;;)
    {
      AppMethodBeat.o(253631);
      return paramca;
      if (!com.tencent.mm.model.ab.Eq(paramca.ajO())) {
        break;
      }
      paramca = bp.Ks(paramca.getContent());
      kotlin.g.b.p.g(paramca, "MsgInfoStorageLogic.getG…hatMsgTalker(msg.content)");
    }
    paramca = paramca.ajO();
    kotlin.g.b.p.g(paramca, "msg.talker");
    AppMethodBeat.o(253631);
    return paramca;
  }
  
  public static com.tencent.mm.plugin.sight.base.a awl(String paramString)
  {
    AppMethodBeat.i(167939);
    kotlin.g.b.p.h(paramString, "filePath");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(167939);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.sight.base.e.cc(paramString, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.sight.base.a();
    }
    if ((((com.tencent.mm.plugin.sight.base.a)localObject1).height <= 0) || (((com.tencent.mm.plugin.sight.base.a)localObject1).width <= 0)) {}
    try
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(com.tencent.mm.vfs.s.k(paramString, false));
      ((com.tencent.mm.plugin.sight.base.a)localObject1).width = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(18), 0);
      ((com.tencent.mm.plugin.sight.base.a)localObject1).height = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(19), 0);
      ((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(20), 0);
      ((MediaMetadataRetriever)localObject2).release();
      label125:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      Log.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject1).height), Integer.valueOf(i) });
      if ((i == 270) || (i == 90))
      {
        i = ((com.tencent.mm.plugin.sight.base.a)localObject1).height;
        ((com.tencent.mm.plugin.sight.base.a)localObject1).height = ((com.tencent.mm.plugin.sight.base.a)localObject1).width;
        ((com.tencent.mm.plugin.sight.base.a)localObject1).width = i;
      }
      AppMethodBeat.o(167939);
      return localObject1;
    }
    catch (Exception localException)
    {
      break label125;
    }
  }
  
  public static Point awm(String paramString)
  {
    AppMethodBeat.i(167940);
    kotlin.g.b.p.h(paramString, "filePath");
    Point localPoint = new Point();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    localPoint.x = localOptions.outWidth;
    localPoint.y = localOptions.outHeight;
    paramString = Exif.fromFile(paramString);
    kotlin.g.b.p.g(paramString, "Exif.fromFile(filePath)");
    if (paramString.getOrientationInDegree() % 180 != 0)
    {
      int i = localPoint.y;
      localPoint.y = localPoint.x;
      localPoint.x = i;
    }
    AppMethodBeat.o(167940);
    return localPoint;
  }
  
  public static boolean awn(String paramString)
  {
    AppMethodBeat.i(167958);
    boolean bool = Util.isEqual(paramString, z.aTY());
    AppMethodBeat.o(167958);
    return bool;
  }
  
  public static o<Double, Double> awo(String paramString)
  {
    AppMethodBeat.i(167965);
    kotlin.g.b.p.h(paramString, "path");
    Object localObject = new ab(new ExifInterface(com.tencent.mm.vfs.s.k(paramString, false)));
    paramString = ((ab)localObject).vYl;
    localObject = ((ab)localObject).vYk;
    if ((localObject != null) && (paramString != null))
    {
      paramString = new o(Double.valueOf(((Float)localObject).floatValue()), Double.valueOf(paramString.floatValue()));
      AppMethodBeat.o(167965);
      return paramString;
    }
    AppMethodBeat.o(167965);
    return null;
  }
  
  public static o<Double, Double> awp(String paramString)
  {
    AppMethodBeat.i(167966);
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        AppMethodBeat.o(167966);
        return null;
      }
      localObject = new com.tencent.mm.compatible.i.d();
      ((com.tencent.mm.compatible.i.d)localObject).setDataSource(paramString);
      paramString = ((com.tencent.mm.compatible.i.d)localObject).extractMetadata(23);
      ((com.tencent.mm.compatible.i.d)localObject).release();
      Log.i(TAG, "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label372;
      }
      kotlin.g.b.p.g(paramString, "locationString");
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167966);
        throw paramString;
      }
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(167966);
      return null;
    }
    paramString = paramString.toCharArray();
    kotlin.g.b.p.g(paramString, "(this as java.lang.String).toCharArray()");
    Object localObject = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        char c = paramString[i];
        if ((c == '+') || (c == '-') || (c == '.') || (TextUtils.isDigitsOnly((CharSequence)(String.valueOf(c) + "")))) {
          ((StringBuilder)localObject).append(c);
        }
      }
      else
      {
        paramString = ((StringBuilder)localObject).toString();
        kotlin.g.b.p.g(paramString, "locSb.toString()");
        j = kotlin.n.n.b((CharSequence)paramString, '+');
        i = j;
        if (-1 == j) {
          i = kotlin.n.n.b((CharSequence)paramString, '-');
        }
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        localObject = paramString.substring(0, i);
        kotlin.g.b.p.g(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble((String)localObject);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        paramString = paramString.substring(i);
        kotlin.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = new o(Double.valueOf(d), Double.valueOf(Double.parseDouble(paramString)));
        AppMethodBeat.o(167966);
        return paramString;
        label372:
        AppMethodBeat.o(167966);
        return null;
      }
      i += 1;
    }
  }
  
  public static String awq(String paramString)
  {
    AppMethodBeat.i(178463);
    kotlin.g.b.p.h(paramString, "desc");
    if (paramString.length() > 5)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramString = paramString.substring(0, 5);
      kotlin.g.b.p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString + "***";
      AppMethodBeat.o(178463);
      return paramString;
    }
    AppMethodBeat.o(178463);
    return paramString;
  }
  
  public static boolean awr(String paramString)
  {
    AppMethodBeat.i(253613);
    int i;
    if (kotlin.g.b.p.j(paramString, z.aUg()))
    {
      paramString = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(paramString, "MMKernel.storage()");
      i = paramString.azQ().getInt(ar.a.Okw, 0);
    }
    for (;;)
    {
      if ((i & 0x800) != 0)
      {
        AppMethodBeat.o(253613);
        return true;
        com.tencent.mm.plugin.finder.api.c.a locala = com.tencent.mm.plugin.finder.api.c.tsp;
        paramString = com.tencent.mm.plugin.finder.api.c.a.asG(paramString);
        if (paramString != null) {
          i = paramString.field_extFlag;
        }
      }
      else
      {
        AppMethodBeat.o(253613);
        return false;
      }
      i = 0;
    }
  }
  
  public static boolean aws(String paramString)
  {
    bool2 = false;
    bool1 = false;
    AppMethodBeat.i(253672);
    kotlin.g.b.p.h(paramString, "path");
    long l1 = System.currentTimeMillis();
    if (!com.tencent.mm.vfs.s.YS(paramString))
    {
      AppMethodBeat.o(253672);
      return false;
    }
    str2 = null;
    str1 = null;
    try
    {
      paramString = com.tencent.mm.vfs.s.dB(paramString, false);
      str1 = paramString;
      str2 = paramString;
      com.tencent.mm.plugin.a.a locala = com.tencent.mm.plugin.a.c.b(paramString, new byte[8], com.tencent.mm.plugin.a.a.blk);
      str1 = paramString;
      str2 = paramString;
      kotlin.g.b.p.g(locala, "moovAtom");
      str1 = paramString;
      str2 = paramString;
      long l2 = locala.blQ() + 8L;
      str1 = paramString;
      str2 = paramString;
      long l3 = locala.getSize();
      str1 = paramString;
      str2 = paramString;
      Log.i(TAG, "[isMoovOptimize] cost=" + (System.currentTimeMillis() - l1) + "ms beginPos=" + l2 + " remains=" + (l3 - 8L));
      if (l2 > 0L) {
        bool1 = true;
      }
      Util.qualityClose((Closeable)paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Util.qualityClose((Closeable)str1);
        bool1 = bool2;
      }
    }
    finally
    {
      Util.qualityClose((Closeable)str2);
      AppMethodBeat.o(253672);
    }
    AppMethodBeat.o(253672);
    return bool1;
  }
  
  public static String awt(String paramString)
  {
    AppMethodBeat.i(253694);
    kotlin.g.b.p.h(paramString, "origin");
    paramString = (CharSequence)kotlin.n.n.trim((CharSequence)paramString).toString();
    paramString = (CharSequence)new kotlin.n.k("(\n\n[\\s]*\n)|(\n[\\s]*\n\n)").e(paramString, "\n\n");
    paramString = (CharSequence)new kotlin.n.k("(\r\n\r\n[\\s]*\r\n)|(\r\n[\\s]*\r\n\r\n)").e(paramString, "\r\n\r\n");
    paramString = new kotlin.n.k("[ ]{11,}").e(paramString, "          ");
    AppMethodBeat.o(253694);
    return paramString;
  }
  
  public static void awu(String paramString)
  {
    AppMethodBeat.i(253696);
    kotlin.g.b.p.h(paramString, "prefix");
    Object localObject = com.tencent.mm.kernel.g.ah(PluginFinder.class);
    kotlin.g.b.p.g(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    boolean bool1 = ((PluginFinder)localObject).isPagEnable();
    boolean bool2 = ChannelUtil.isGPVersion();
    Log.i(TAG, paramString + " tryLoadPagLibrary pag start,gpVersion:" + bool2 + ",isPagEnable:" + bool1);
    if ((!bool2) || (bool1))
    {
      if (com.tencent.mm.kernel.g.aAc()) {
        break label135;
      }
      Log.e(TAG, "loadPagLib account is not ready");
    }
    for (;;)
    {
      Log.i(TAG, paramString + " tryLoadPagLibrary pag end");
      AppMethodBeat.o(253696);
      return;
      label135:
      com.tencent.mm.plugin.report.service.h.CyF.n(1279L, 200L, 1L);
      localObject = com.tencent.mm.plugin.expansions.d.rNG;
      bool1 = com.tencent.mm.plugin.expansions.d.aoa("pag");
      Log.i(TAG, "loadPagLib result:".concat(String.valueOf(bool1)));
      com.tencent.mm.plugin.report.service.h.CyF.n(1279L, 201L, 1L);
    }
  }
  
  public static String ax(ca paramca)
  {
    AppMethodBeat.i(253632);
    kotlin.g.b.p.h(paramca, "msg");
    if (paramca.ajN() == 1)
    {
      paramca = paramca.ajO();
      kotlin.g.b.p.g(paramca, "msg.talker");
    }
    for (;;)
    {
      AppMethodBeat.o(253632);
      return paramca;
      if (com.tencent.mm.model.ab.Eq(paramca.ajO()))
      {
        paramca = paramca.ajO();
        kotlin.g.b.p.g(paramca, "msg.talker");
      }
      else
      {
        paramca = z.aTY();
        kotlin.g.b.p.g(paramca, "ConfigStorageLogic.getUsernameFromUserInfo()");
      }
    }
  }
  
  public static void b(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(253684);
    kotlin.g.b.p.h(paramWindow, "window");
    com.tencent.mm.ui.ao.d(paramWindow, paramBoolean);
    com.tencent.mm.ui.ao.e(paramWindow, paramBoolean);
    AppMethodBeat.o(253684);
  }
  
  public static boolean b(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(253591);
    int i = paramInt;
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      i = ((Number)com.tencent.mm.plugin.finder.storage.c.dtV().value()).intValue();
    }
    if ((i == 2) && (paramFloat >= 1.316667F))
    {
      AppMethodBeat.o(253591);
      return true;
    }
    AppMethodBeat.o(253591);
    return false;
  }
  
  public static boolean b(Context paramContext, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253698);
    kotlin.g.b.p.h(paramContext, "context");
    FinderReporterUIC.a locala = FinderReporterUIC.wzC;
    paramContext = FinderReporterUIC.a.fH(paramContext);
    if (paramContext != null)
    {
      i = paramContext.tCE;
      if ((i == 1) || (i == 8)) {
        break label75;
      }
      if (paramFinderItem == null) {
        break label70;
      }
    }
    label70:
    for (int i = paramFinderItem.getMediaType();; i = 0)
    {
      if (i == 9) {
        break label75;
      }
      AppMethodBeat.o(253698);
      return true;
      i = 0;
      break;
    }
    label75:
    AppMethodBeat.o(253698);
    return false;
  }
  
  public static boolean b(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253597);
    kotlin.g.b.p.h(paramImageView, "imageView");
    kotlin.g.b.p.h(paramString, "path");
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = BitmapUtil.calculateInSampleSize(localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inMutable = true;
    paramString = MMBitmapFactory.decodeFile(paramString, localOptions);
    paramImageView.setImageBitmap(paramString);
    if (paramString != null)
    {
      AppMethodBeat.o(253597);
      return true;
    }
    AppMethodBeat.o(253597);
    return false;
  }
  
  public static boolean b(bm parambm)
  {
    AppMethodBeat.i(253602);
    kotlin.g.b.p.h(parambm, "feed");
    parambm = parambm.contact;
    if (!Util.isNullOrNil(z.aUg()))
    {
      if (parambm != null) {}
      for (parambm = parambm.username; kotlin.n.n.I(parambm, z.aUg(), false); parambm = null)
      {
        AppMethodBeat.o(253602);
        return true;
      }
    }
    AppMethodBeat.o(253602);
    return false;
  }
  
  public static boolean b(cng paramcng)
  {
    if (paramcng == null) {}
    while ((paramcng.permissionFlag & 0x4) != 0) {
      return false;
    }
    return true;
  }
  
  public static float bj(float paramFloat)
  {
    float f;
    if (paramFloat < 0.5625F) {
      f = 0.5625F;
    }
    do
    {
      do
      {
        return f;
        f = paramFloat;
      } while (paramFloat < 1.0F);
      f = paramFloat;
    } while (paramFloat < 1.316667F);
    return 1.316667F;
  }
  
  public static boolean bl(float paramFloat)
  {
    AppMethodBeat.i(253685);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (paramFloat < ((Number)com.tencent.mm.plugin.finder.storage.c.dwz().value()).floatValue())
    {
      AppMethodBeat.o(253685);
      return true;
    }
    AppMethodBeat.o(253685);
    return false;
  }
  
  public static Bitmap c(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167968);
    kotlin.g.b.p.h(paramInputStream, "inputStream");
    com.tencent.mm.plugin.gallery.picker.b.b.a locala = com.tencent.mm.plugin.gallery.picker.b.b.xkW;
    paramInputStream = com.tencent.mm.plugin.gallery.picker.b.b.a.a(paramInputStream, paramInt1, paramInt2, true, false);
    AppMethodBeat.o(167968);
    return paramInputStream;
  }
  
  public static com.tencent.mm.plugin.appbrand.api.g c(awc paramawc)
  {
    AppMethodBeat.i(253660);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    if (paramawc != null)
    {
      localg.appId = paramawc.LGz;
      localg.kHw = paramawc.LGH;
      Object localObject = new com.tencent.mm.plugin.finder.live.model.x();
      ((com.tencent.mm.plugin.finder.live.model.x)localObject).ukr = paramawc.ukr;
      ((com.tencent.mm.plugin.finder.live.model.x)localObject).ukp = 1;
      localg.kHx = ((com.tencent.mm.plugin.appbrand.api.d)localObject);
      localObject = m.vVH;
      if (!m.dBP()) {
        break label186;
      }
    }
    label186:
    for (int i = 1176;; i = 1177)
    {
      localg.scene = i;
      localg.kHL = new HalfScreenConfig(true, 10, true, null, false, null, false, null, 248);
      localg.username = paramawc.LGI;
      if ((dCM()) && (!Util.isNullOrNil(localg.username)))
      {
        paramawc = localg.username;
        if ((paramawc != null) && (!kotlin.n.n.K(paramawc, "@app", false)))
        {
          paramawc = localg.username;
          localg.username = (paramawc + "@app");
        }
      }
      AppMethodBeat.o(253660);
      return localg;
    }
  }
  
  public static boolean c(axg paramaxg)
  {
    AppMethodBeat.i(253661);
    kotlin.g.b.p.h(paramaxg, "item");
    if (paramaxg.LHO > 0)
    {
      AppMethodBeat.o(253661);
      return true;
    }
    AppMethodBeat.o(253661);
    return false;
  }
  
  public static boolean c(cng paramcng)
  {
    if (paramcng == null) {}
    while ((paramcng.permissionFlag & 0x1) != 0) {
      return false;
    }
    return true;
  }
  
  public static boolean d(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(253651);
    kotlin.g.b.p.h(paramContext, "context");
    Log.e(TAG, "checkShowCgiErrorAlter: errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramContext = new d.a(paramContext);
        paramContext.boo(paramString);
        paramContext.Dk(true);
        paramContext.aoV(2131755921);
        paramContext.show();
        AppMethodBeat.o(253651);
        return true;
      }
    }
    AppMethodBeat.o(253651);
    return false;
  }
  
  public static boolean d(cng paramcng)
  {
    if (paramcng == null) {}
    while ((paramcng.permissionFlag & 0x2) != 0) {
      return false;
    }
    return true;
  }
  
  public static int dCA()
  {
    AppMethodBeat.i(258555);
    int i = (int)(cl.aWy() / 1000L);
    AppMethodBeat.o(258555);
    return i;
  }
  
  public static boolean dCB()
  {
    AppMethodBeat.i(178458);
    if (!Util.isNullOrNil(z.aUg()))
    {
      AppMethodBeat.o(178458);
      return true;
    }
    AppMethodBeat.o(178458);
    return false;
  }
  
  public static String dCC()
  {
    AppMethodBeat.i(167953);
    String str2 = ClipboardHelper.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    AppMethodBeat.o(167953);
    return str1;
  }
  
  public static long dCE()
  {
    return tCi;
  }
  
  public static boolean dCF()
  {
    AppMethodBeat.i(253609);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.azQ().getInt(ar.a.Okw, 0) & 0x20) != 0)
    {
      AppMethodBeat.o(253609);
      return true;
    }
    AppMethodBeat.o(253609);
    return false;
  }
  
  public static boolean dCG()
  {
    AppMethodBeat.i(253611);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.azQ().getInt(ar.a.Okw, 0) & 0x40000) != 0)
    {
      AppMethodBeat.o(253611);
      return true;
    }
    AppMethodBeat.o(253611);
    return false;
  }
  
  public static boolean dCH()
  {
    AppMethodBeat.i(253612);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.azQ().getInt(ar.a.Okw, 0) & 0x2000) != 0)
    {
      AppMethodBeat.o(253612);
      return true;
    }
    AppMethodBeat.o(253612);
    return false;
  }
  
  public static JSONObject dCI()
  {
    AppMethodBeat.i(253626);
    if (vXy == null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("screenwidth", com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()));
      ((JSONObject)localObject).put("screenheight", com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
      vXy = (JSONObject)localObject;
    }
    JSONObject localJSONObject = vXy;
    Object localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = new JSONObject();
    }
    AppMethodBeat.o(253626);
    return localObject;
  }
  
  public static void dCJ()
  {
    AppMethodBeat.i(253634);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omg, "");
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omh, "");
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omi, "");
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omj, "");
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omk, "");
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omm, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omn, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omo, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omp, Integer.valueOf(0));
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omq, Integer.valueOf(0));
    AppMethodBeat.o(253634);
  }
  
  public static void dCK()
  {
    AppMethodBeat.i(253635);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Omd, "");
    locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.Oml, Integer.valueOf(0));
    AppMethodBeat.o(253635);
  }
  
  public static int dCL()
  {
    boolean bool3 = true;
    int j = 1;
    AppMethodBeat.i(253652);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.c.dtr().value()).intValue();
    if (i != -1)
    {
      Log.d(TAG, "harcode user state = ".concat(String.valueOf(i)));
      AppMethodBeat.o(253652);
      return i;
    }
    localObject = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject, "MMKernel.storage()");
    boolean bool1;
    label129:
    boolean bool2;
    if ((((com.tencent.mm.kernel.e)localObject).azQ().getInt(ar.a.Okh, 0) & 0x2) != 0)
    {
      bool1 = true;
      boolean bool4 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).showPostEntry();
      localObject = (CharSequence)z.aUg();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label208;
      }
      i = 1;
      if (i != 0) {
        break label213;
      }
      bool2 = true;
      label135:
      Log.i(TAG, "[checkUserState] hasCreatedIdentity=" + bool2 + ", showPostEntry=" + bool4 + ", isReviewing=" + bool1);
      if (bool4) {
        break label218;
      }
      Log.i(TAG, "resultState = USER_STATE_NO_POST_QUALITY");
      i = j;
    }
    label208:
    label338:
    for (;;)
    {
      AppMethodBeat.o(253652);
      return i;
      bool1 = false;
      break;
      i = 0;
      break label129;
      label213:
      bool2 = false;
      break label135;
      label218:
      if (bool2)
      {
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        bool2 = ((com.tencent.mm.plugin.finder.api.g)localObject).isBlock();
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        if (((com.tencent.mm.plugin.finder.api.g)localObject).field_spamStatus == 2) {}
        for (bool1 = bool3;; bool1 = false)
        {
          Log.i(TAG, "[checkUserState] isAccountBlocked=" + bool2 + ", isAccountSilent=" + bool1);
          if (!bool2) {
            break label338;
          }
          Log.i(TAG, "resultState = USER_STATE_ACCOUNT_FORBID");
          i = 4;
          break;
        }
        if (bool1)
        {
          Log.i(TAG, "resultState = USER_STATE_ACCOUNT_SILIENT");
          i = 6;
        }
        else
        {
          Log.i(TAG, "resultState = USER_STATE_NORMAL");
          i = 3;
        }
      }
      else if (bool1)
      {
        Log.i(TAG, "resultState = USER_STATE_ACCOUNT_REVIEW_ING");
        i = 5;
      }
      else
      {
        Log.i(TAG, "resultState = USER_STATE_HAS_POST_QUALITY_NO_ACCOUNT");
        i = 2;
      }
    }
  }
  
  public static boolean dCM()
  {
    return (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG);
  }
  
  public static String dCN()
  {
    AppMethodBeat.i(253657);
    if (dCM())
    {
      String str = Util.getStack().toString();
      kotlin.g.b.p.g(str, "Util.getStack().toString()");
      AppMethodBeat.o(253657);
      return str;
    }
    AppMethodBeat.o(253657);
    return "";
  }
  
  public static long dCO()
  {
    AppMethodBeat.i(253662);
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dwk().value()).intValue() == 1)
    {
      l = System.currentTimeMillis();
      AppMethodBeat.o(253662);
      return l;
    }
    long l = cl.aWA();
    AppMethodBeat.o(253662);
    return l;
  }
  
  public static r<ArrayList<String>, ArrayList<List<String>>, ArrayList<List<String>>> dCP()
  {
    AppMethodBeat.i(253663);
    Object localObject2 = new Date(dCO());
    Object localObject3 = Calendar.getInstance();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 30)
    {
      kotlin.g.b.p.g(localObject3, "date");
      ((Calendar)localObject3).setTime((Date)localObject2);
      ((Calendar)localObject3).set(5, ((Calendar)localObject3).get(5) + i);
      int j = ((Calendar)localObject3).get(5);
      int k = ((Calendar)localObject3).get(2);
      Context localContext = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localContext, "MMApplicationContext.getContext()");
      ((ArrayList)localObject1).add(localContext.getResources().getString(2131760136, new Object[] { Integer.valueOf(k + 1), Integer.valueOf(j) }));
      i += 1;
    }
    localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext()) {
      Log.i("getNoticePicker", (String)((Iterator)localObject3).next());
    }
    if ((((Date)localObject2).getHours() >= 23) && (((Date)localObject2).getMinutes() >= 55)) {
      ((ArrayList)localObject1).remove(0);
    }
    localObject2 = LV(((ArrayList)localObject1).size());
    localObject1 = new r(localObject1, localObject2, LW(((ArrayList)localObject1).size() * ((ArrayList)localObject2).size()));
    AppMethodBeat.o(253663);
    return localObject1;
  }
  
  public static void dCQ()
  {
    vXz = true;
  }
  
  public static int dCR()
  {
    return vXB;
  }
  
  public static void dCS()
  {
    AppMethodBeat.i(253674);
    if (vXz)
    {
      com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      vXA = ((Number)com.tencent.mm.plugin.finder.storage.c.dwr().value()).intValue();
      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      vXB = ((Number)com.tencent.mm.plugin.finder.storage.c.dws().value()).intValue();
      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      vXC = ((Number)com.tencent.mm.plugin.finder.storage.c.dwt().value()).intValue();
      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      vXD = ((Number)com.tencent.mm.plugin.finder.storage.c.dwu().value()).intValue();
      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      vXE = ((Number)com.tencent.mm.plugin.finder.storage.c.dww().value()).intValue();
      localc = com.tencent.mm.plugin.finder.storage.c.vCb;
      vXF = ((Number)com.tencent.mm.plugin.finder.storage.c.dwv().value()).intValue();
      vXz = false;
      Log.i(TAG, "[checkResetFullScreenConfig] reset config GLOBAL=" + vXA + " HOT=" + vXB + ' ' + "FOLLOW=" + vXC + " FRIEND=" + vXD + ' ' + "SHARE=" + vXE + " OTHER=" + vXF);
    }
    AppMethodBeat.o(253674);
  }
  
  public static boolean dCT()
  {
    AppMethodBeat.i(253697);
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
    Object localObject2 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(274436);
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    localObject1 = Util.nullAs((String)localObject1, "CN");
    boolean bool = kotlin.n.n.I("CN", (String)localObject1, true);
    Log.i(TAG, "isRegInChina, regCountryIsoCode:" + (String)localObject1 + " isChinaReg:" + bool);
    AppMethodBeat.o(253697);
    return bool;
  }
  
  public static boolean dCU()
  {
    AppMethodBeat.i(253699);
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (!((Boolean)com.tencent.mm.plugin.finder.storage.c.dwU().value()).booleanValue())
    {
      localObject = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.OmW, Boolean.FALSE);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(253699);
        throw ((Throwable)localObject);
      }
      if (((Boolean)localObject).booleanValue())
      {
        AppMethodBeat.o(253699);
        return true;
      }
    }
    AppMethodBeat.o(253699);
    return false;
  }
  
  public static String dCV()
  {
    AppMethodBeat.i(253702);
    String str = MD5Util.getMD5String(z.aTY() + System.currentTimeMillis());
    kotlin.g.b.p.g(str, "MD5Util.getMD5String(\"${…em.currentTimeMillis()}\")");
    AppMethodBeat.o(253702);
    return str;
  }
  
  public static void dCW()
  {
    AppMethodBeat.i(253703);
    f localf = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager();
    bbi localbbi = new bbi();
    localbbi.LKM = String.valueOf(cl.aWA());
    localbbi.priority = 0;
    localbbi.type = 1015;
    bdo localbdo = new bdo();
    localbdo.xGz = 3;
    localbdo.title = MMApplicationContext.getContext().getString(2131760510);
    localbdo.LNm = 1;
    localbdo.path = "FinderSelfRedPack";
    localbbi.GaM.add(localbdo);
    f.a(localf, localbbi, "checkFinderRedPackRedDot", null, true, null, 20);
    AppMethodBeat.o(253703);
  }
  
  public static void dCX()
  {
    AppMethodBeat.i(253704);
    f localf = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager();
    bbi localbbi = new bbi();
    localbbi.LKM = String.valueOf(cl.aWA());
    localbbi.priority = 0;
    localbbi.type = 1016;
    bdo localbdo = new bdo();
    localbdo.xGz = 3;
    localbdo.title = MMApplicationContext.getContext().getString(2131760510);
    localbdo.LNm = 1;
    localbdo.path = "FinderMyTabRedPack";
    localbbi.GaM.add(localbdo);
    f.a(localf, localbbi, "checkFinderRedPackRedDot", null, true, null, 20);
    AppMethodBeat.o(253704);
  }
  
  public static boolean dCY()
  {
    AppMethodBeat.i(253705);
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sci, "");
    Log.i(TAG, "[checkIfRedPackRedDotShow]  result:".concat(String.valueOf(localObject)));
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        long l1 = ((JSONObject)localObject).optLong("start");
        l2 = ((JSONObject)localObject).optLong("end");
        int i = cl.aWB();
        Log.i(TAG, "[checkIfRedPackRedDotShow] start:" + l1 + " ,end:" + l2 + ",currentTime:" + i);
        if ((l1 > 0L) && (l2 > 0L) && (l2 > l1))
        {
          l3 = cl.aWB();
          if (l1 <= l3) {
            continue;
          }
        }
        Log.i(TAG, "[checkIfRedPackRedDotShow] not show redpack");
        bool = false;
      }
      catch (Exception localException)
      {
        long l2;
        long l3;
        Log.i(TAG, "[checkIfRedPackRedDotShow] catch exception" + localException.getMessage());
        boolean bool = false;
        continue;
      }
      Log.i(TAG, "[checkIfRedPackRedDotShow] result:".concat(String.valueOf(bool)));
      AppMethodBeat.o(253705);
      return bool;
      if (l2 >= l3)
      {
        Log.i(TAG, "[checkIfRedPackRedDotShow] show redpack");
        bool = true;
      }
    }
  }
  
  public static boolean dCZ()
  {
    AppMethodBeat.i(253706);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.OmX, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(253706);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i(TAG, "[checkHasCloseRedPack] hasColse:".concat(String.valueOf(bool)));
    AppMethodBeat.o(253706);
    return bool;
  }
  
  public static Set<Integer> dCz()
  {
    return vXw;
  }
  
  public static boolean dDa()
  {
    AppMethodBeat.i(253707);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.OmY, Boolean.FALSE);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(253707);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i(TAG, "[checkHasEnterRedPackMiniApp] hasEnter:".concat(String.valueOf(bool)));
    AppMethodBeat.o(253707);
    return bool;
  }
  
  public static String dP(String paramString, int paramInt)
  {
    AppMethodBeat.i(167962);
    kotlin.g.b.p.h(paramString, "key");
    paramString = MMApplicationContext.getContext().getString(paramInt);
    kotlin.g.b.p.g(paramString, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(167962);
    return paramString;
  }
  
  public static void dQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(253690);
    kotlin.g.b.p.h(paramString, "logPrefix");
    if (dCM())
    {
      paramString = (Throwable)new RuntimeException(paramString + " type:" + paramInt + " invalid");
      AppMethodBeat.o(253690);
      throw paramString;
    }
    Log.printInfoStack(TAG, paramString + " type:" + paramInt + " invalid", new Object[0]);
    AppMethodBeat.o(253690);
  }
  
  public static boolean dnv()
  {
    AppMethodBeat.i(253610);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(locale, "MMKernel.storage()");
    if ((locale.azQ().getInt(ar.a.Okw, 0) & 0x400) != 0)
    {
      AppMethodBeat.o(253610);
      return true;
    }
    AppMethodBeat.o(253610);
    return false;
  }
  
  public static int e(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = 255;
    AppMethodBeat.i(253673);
    if (paramFloat <= 0.5F)
    {
      paramInt2 = Color.alpha(paramInt1);
      if (paramInt2 != 0) {
        break label141;
      }
    }
    for (;;)
    {
      paramInt2 = Color.red(paramInt1);
      int j = Color.green(paramInt1);
      paramInt1 = Color.blue(paramInt1);
      paramInt1 = Color.argb(Math.min(kotlin.h.a.cR((0.5F - paramFloat) * 255.0F * 2.0F), i), paramInt2, j, paramInt1);
      AppMethodBeat.o(253673);
      return paramInt1;
      paramInt1 = Color.alpha(paramInt2);
      if (paramInt1 == 0) {}
      for (;;)
      {
        paramInt1 = Color.red(paramInt2);
        j = Color.green(paramInt2);
        paramInt2 = Color.blue(paramInt2);
        paramInt1 = Color.argb(Math.min(kotlin.h.a.cR((paramFloat - 0.5F) * 255.0F * 2.0F), i), paramInt1, j, paramInt2);
        AppMethodBeat.o(253673);
        return paramInt1;
        i = paramInt1;
      }
      label141:
      i = paramInt2;
    }
  }
  
  public static float eA(List<? extends cjl> paramList)
  {
    AppMethodBeat.i(253686);
    kotlin.g.b.p.h(paramList, "list");
    cjl localcjl = (cjl)kotlin.a.j.ks(paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localcjl;
    float f;
    if (localIterator.hasNext())
    {
      localcjl = (cjl)localIterator.next();
      f = localcjl.height * 1.0F / localcjl.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label105;
      }
      paramList = localcjl;
    }
    label105:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(253686);
      return f;
    }
  }
  
  public static float eB(List<? extends bch> paramList)
  {
    AppMethodBeat.i(253687);
    kotlin.g.b.p.h(paramList, "list");
    bch localbch = (bch)kotlin.a.j.ks(paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localbch;
    float f;
    if (localIterator.hasNext())
    {
      localbch = (bch)localIterator.next();
      f = localbch.height * 1.0F / localbch.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label105;
      }
      paramList = localbch;
    }
    label105:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(253687);
      return f;
    }
  }
  
  public static float eC(List<? extends cok> paramList)
  {
    AppMethodBeat.i(253688);
    kotlin.g.b.p.h(paramList, "list");
    cok localcok = (cok)kotlin.a.j.ks(paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localcok;
    float f;
    if (localIterator.hasNext())
    {
      localcok = (cok)localIterator.next();
      f = localcok.height * 1.0F / localcok.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label105;
      }
      paramList = localcok;
    }
    label105:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(253688);
      return f;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public static View.OnTouchListener eh(View paramView)
  {
    AppMethodBeat.i(253621);
    kotlin.g.b.p.h(paramView, "tv");
    paramView = (View.OnTouchListener)new y.j(paramView);
    AppMethodBeat.o(253621);
    return paramView;
  }
  
  public static r<Integer, Integer, Integer> g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253589);
    kotlin.g.b.p.h(paramContext, "context");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ((Activity)paramContext).getBaseContext();
    }
    kotlin.g.b.p.g(localContext, "baseContext");
    paramContext = localContext.getResources();
    kotlin.g.b.p.g(paramContext, "baseContext.resources");
    int i = paramContext.getDisplayMetrics().widthPixels;
    paramContext = localContext.getResources();
    kotlin.g.b.p.g(paramContext, "baseContext.resources");
    i = kotlin.k.j.na(i, paramContext.getDisplayMetrics().heightPixels);
    float f = 1.0F * paramInt2 / paramInt1;
    int j = ImageView.ScaleType.CENTER_CROP.ordinal();
    if (Math.abs(paramInt1 - paramInt2) <= 10) {}
    for (paramInt1 = i;; paramInt1 = (int)(bj(f) * i))
    {
      paramContext = new r(Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1));
      AppMethodBeat.o(253589);
      return paramContext;
    }
  }
  
  public static r<Integer, Integer, Integer> go(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253590);
    float f = 1.0F * paramInt2 / paramInt1;
    r localr = new r(Integer.valueOf(ImageView.ScaleType.FIT_XY.ordinal()), Integer.valueOf(vXv), Integer.valueOf((int)(f * vXv)));
    AppMethodBeat.o(253590);
    return localr;
  }
  
  public static boolean gp(int paramInt1, int paramInt2)
  {
    return (paramInt2 == -4012) && (paramInt1 == 4);
  }
  
  public static int gq(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return (int)(100.0F * paramInt1 / paramInt2);
    }
    return 0;
  }
  
  public static boolean gr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253682);
    dCS();
    if ((vXA == 1) || (paramInt1 == 10) || ((vXB == 1) && (paramInt1 == 4)) || ((vXB == 1) && (paramInt2 == 20)) || ((vXC == 1) && (paramInt1 == 3)) || ((vXC == 1) && (paramInt2 == 17)) || ((vXD == 1) && (paramInt1 == 1)) || ((vXD == 1) && (paramInt2 == 18)) || ((vXE == 1) && (paramInt1 == 5)) || ((vXE == 1) && (paramInt1 == 6)) || ((vXE == 1) && (paramInt2 == 39)) || ((vXE == 1) && (paramInt2 == 38)) || ((vXE == 1) && (paramInt2 == 25)) || ((isOtherEnableFullScreenEnjoy()) && (paramInt1 != 4) && (paramInt1 != 3) && (paramInt1 != 1) && (paramInt1 != 5) && (paramInt1 != 6) && (paramInt2 != 20) && (paramInt2 != 17) && (paramInt2 != 18) && (paramInt2 != 39) && (paramInt2 != 38) && (paramInt2 != 25)))
    {
      AppMethodBeat.o(253682);
      return true;
    }
    AppMethodBeat.o(253682);
    return false;
  }
  
  public static boolean h(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167956);
    kotlin.g.b.p.h(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (!Util.isNullOrNil(z.aUg()))
    {
      if (paramBaseFinderFeed != null) {}
      for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; kotlin.n.n.I(paramBaseFinderFeed, z.aUg(), false); paramBaseFinderFeed = null)
      {
        AppMethodBeat.o(167956);
        return true;
      }
    }
    AppMethodBeat.o(167956);
    return false;
  }
  
  public static boolean h(cjl paramcjl)
  {
    if (paramcjl != null) {
      paramcjl = paramcjl.MfU;
    }
    return (paramcjl == null) || (paramcjl.Lng != true);
  }
  
  public static String he(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(167950);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      AppMethodBeat.o(167950);
      return paramString1;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    com.tencent.mm.plugin.finder.api.c.a locala = com.tencent.mm.plugin.finder.api.c.tsp;
    if (paramString1 != null) {
      bool = kotlin.n.n.K(paramString1, "@finder", false);
    }
    if (bool) {
      if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        kotlin.g.b.p.g(localStringBuffer.append("displayName is is finder contact"), "buf.append(\"displayName is is finder contact\")");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(167950);
      return paramString1;
      paramString2 = com.tencent.mm.plugin.finder.api.c.tsp;
      if (paramString1 == null) {
        kotlin.g.b.p.hyc();
      }
      paramString1 = com.tencent.mm.plugin.finder.api.c.a.asG(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getNickname();
        break;
      }
      paramString1 = "";
      break;
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString1);
      kotlin.g.b.p.g(paramString1, "ct");
      if ((paramString1.arH() != 0) && (!Util.isNullOrNil(paramString1.arJ())))
      {
        paramString1 = paramString1.arJ();
        kotlin.g.b.p.g(paramString1, "ct.displayRemark");
        kotlin.g.b.p.g(localStringBuffer.append("displayName is ".concat(String.valueOf(paramString1))), "buf.append(\"displayName is $displayName\")");
      }
      else if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
      else
      {
        paramString1 = paramString1.getUsername();
        kotlin.g.b.p.g(paramString1, "ct.getUsername()");
      }
    }
  }
  
  public static String hg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167969);
    if (!Util.isNullOrNil(new String[] { paramString1, paramString2 }))
    {
      paramString1 = MMApplicationContext.getResources().getString(2131760240, new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(167969);
      return paramString1;
    }
    if (!Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(167969);
      return paramString1;
    }
    if (!Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(167969);
      return paramString2;
    }
    AppMethodBeat.o(167969);
    return "";
  }
  
  public static String hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253606);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(253606);
        return "";
      }
    }
    else
    {
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      paramString1 = he(str, paramString1);
    }
    AppMethodBeat.o(253606);
    return paramString1;
  }
  
  public static int i(cjl paramcjl)
  {
    int i = 1;
    if ((paramcjl != null) && (paramcjl.mediaType == 9)) {
      i = 2;
    }
    do
    {
      return i;
      if (paramcjl == null) {
        break;
      }
      paramcjl = paramcjl.MfU;
    } while ((paramcjl != null) && (paramcjl.Lng == true));
    return 0;
  }
  
  public static boolean i(com.tencent.mm.plugin.finder.api.g paramg)
  {
    AppMethodBeat.i(253614);
    if (paramg != null) {}
    for (String str = paramg.getUsername(); kotlin.g.b.p.j(str, z.aUg()); str = null)
    {
      boolean bool = dnv();
      AppMethodBeat.o(253614);
      return bool;
    }
    if (paramg != null) {}
    for (int i = paramg.field_extFlag; (i & 0x400) != 0; i = 0)
    {
      AppMethodBeat.o(253614);
      return true;
    }
    AppMethodBeat.o(253614);
    return false;
  }
  
  public static boolean isAllEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(253679);
    dCS();
    if ((vXA == 1) || ((vXB == 1) && (vXC == 1) && (vXD == 1) && (vXE == 1) && (vXF == 1)))
    {
      AppMethodBeat.o(253679);
      return true;
    }
    AppMethodBeat.o(253679);
    return false;
  }
  
  public static boolean isAllHomeTabEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(253677);
    dCS();
    if ((vXA == 1) || ((vXB == 1) && (vXC == 1) && (vXD == 1)))
    {
      AppMethodBeat.o(253677);
      return true;
    }
    AppMethodBeat.o(253677);
    return false;
  }
  
  public static boolean isAnyEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(253678);
    dCS();
    if ((vXA == 1) || (vXB == 1) || (vXC == 1) || (vXD == 1) || (vXE == 1) || (vXF == 1))
    {
      AppMethodBeat.o(253678);
      return true;
    }
    AppMethodBeat.o(253678);
    return false;
  }
  
  public static boolean isAnyHomeTabEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(253675);
    dCS();
    if ((vXA == 1) || (vXF == 1) || (vXB == 1) || (vXC == 1) || (vXD == 1))
    {
      AppMethodBeat.o(253675);
      return true;
    }
    AppMethodBeat.o(253675);
    return false;
  }
  
  public static boolean isDisablePostHalfScreen()
  {
    AppMethodBeat.i(253681);
    dCS();
    if ((vXG == 1) && (isAllEnableFullScreenEnjoy()))
    {
      AppMethodBeat.o(253681);
      return true;
    }
    AppMethodBeat.o(253681);
    return false;
  }
  
  public static boolean isFastClick()
  {
    AppMethodBeat.i(253695);
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l - lastClickTime >= 500L) {
      bool = false;
    }
    lastClickTime = l;
    AppMethodBeat.o(253695);
    return bool;
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(167952);
    if (paramString == null)
    {
      AppMethodBeat.o(167952);
      return false;
    }
    if ((!kotlin.n.n.K(paramString, "@stranger", false)) && ((kotlin.g.b.p.j(paramString, z.aTY()) ^ true)) && (com.tencent.mm.model.ab.IS(paramString)))
    {
      AppMethodBeat.o(167952);
      return true;
    }
    AppMethodBeat.o(167952);
    return false;
  }
  
  public static boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(253680);
    dCS();
    if ((vXA == 1) || (vXF == 1))
    {
      AppMethodBeat.o(253680);
      return true;
    }
    AppMethodBeat.o(253680);
    return false;
  }
  
  public static com.tencent.mm.bw.b j(com.tencent.mm.bw.a parama)
  {
    AppMethodBeat.i(253664);
    kotlin.g.b.p.h(parama, "$this$toByteString");
    parama = parama.toByteArray();
    if (parama != null)
    {
      parama = new com.tencent.mm.bw.b(parama);
      AppMethodBeat.o(253664);
      return parama;
    }
    AppMethodBeat.o(253664);
    return null;
  }
  
  public static boolean j(com.tencent.mm.plugin.finder.api.g paramg)
  {
    return (paramg != null) && ((paramg.field_extFlag & 0x4000) != 0);
  }
  
  public static boolean j(cjl paramcjl)
  {
    AppMethodBeat.i(253622);
    kotlin.g.b.p.h(paramcjl, "localFinderMedia");
    if ((paramcjl.MoO) && (paramcjl.uOR != null))
    {
      AppMethodBeat.o(253622);
      return true;
    }
    AppMethodBeat.o(253622);
    return false;
  }
  
  public static boolean k(cjl paramcjl)
  {
    AppMethodBeat.i(253689);
    kotlin.g.b.p.h(paramcjl, "media");
    if (1.0F * paramcjl.height / paramcjl.width <= 1.333333F)
    {
      AppMethodBeat.o(253689);
      return true;
    }
    AppMethodBeat.o(253689);
    return false;
  }
  
  public static void m(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(167955);
    kotlin.g.b.p.h(paramList, "list");
    kotlin.g.b.p.h(paramString, "tag");
    Log.v(TAG, "---------------------------------------------------------------------printAllItemStart " + paramString + " count " + paramList.size() + "---------------------------------------------------------------------");
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramList = (FinderItem)localIterator.next();
      int j = paramList.getCreateTime();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("#").append(i).append(" print item id:").append(paramList.getId()).append(" rowid:").append(paramList.getLocalId()).append(" time: ").append(Integer.valueOf(j)).append(" sourceFlag:").append(paramList.field_sourceFlag).append(" username:");
      paramList = paramList.getFinderObject();
      if (paramList != null) {}
      for (paramList = paramList.username;; paramList = null)
      {
        Log.i(str, paramList);
        i += 1;
        break;
      }
    }
    Log.v(TAG, "---------------------------------------------------------------------printAllItemEnd " + paramString + "---------------------------------------------------------------------");
    AppMethodBeat.o(167955);
  }
  
  public static bo n(int paramInt, List<? extends bo> paramList)
  {
    AppMethodBeat.i(253645);
    kotlin.g.b.p.h(paramList, "feedList");
    if ((paramInt >= 0) && (paramInt < paramList.size()))
    {
      paramList = (bo)paramList.get(paramInt);
      AppMethodBeat.o(253645);
      return paramList;
    }
    AppMethodBeat.o(253645);
    return null;
  }
  
  public static void q(TextView paramTextView)
  {
    AppMethodBeat.i(253668);
    kotlin.g.b.p.h(paramTextView, "tv");
    try
    {
      Context localContext = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localContext, "MMApplicationContext.getContext()");
      paramTextView.setTypeface(Typeface.createFromAsset(localContext.getAssets(), "fonts/WeChatSansStd-Medium.ttf"));
      AppMethodBeat.o(253668);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e(TAG, "setTypeface() Exception:" + paramTextView.getMessage());
      AppMethodBeat.o(253668);
    }
  }
  
  public static JSONArray r(RecyclerView paramRecyclerView)
  {
    int k = 0;
    AppMethodBeat.i(253625);
    kotlin.g.b.p.h(paramRecyclerView, "recyclerView");
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(253625);
      throw paramRecyclerView;
    }
    Object localObject2 = (StaggeredGridLayoutManager)localObject1;
    localObject1 = ((StaggeredGridLayoutManager)localObject2).n(null);
    localObject2 = ((StaggeredGridLayoutManager)localObject2).o(null);
    int j;
    label88:
    int m;
    if (localObject1 != null)
    {
      i = localObject1[0];
      if (localObject1 == null) {
        break label288;
      }
      j = localObject1[1];
      m = Math.min(i, j);
      if (localObject2 == null) {
        break label293;
      }
    }
    label288:
    label293:
    for (int i = localObject2[0];; i = 0)
    {
      j = k;
      if (localObject2 != null) {
        j = localObject2[1];
      }
      localObject1 = a(m, Math.max(i, j), paramRecyclerView);
      paramRecyclerView = new JSONArray();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (com.tencent.mm.plugin.finder.event.base.g)((Iterator)localObject1).next();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("feedid", com.tencent.mm.ac.d.zs(((com.tencent.mm.plugin.finder.event.base.g)localObject3).tIu.lT()));
        ((JSONObject)localObject2).put("feedindex", ((com.tencent.mm.plugin.finder.event.base.g)localObject3).tIv);
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject3).tIw;
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put("x", ((com.tencent.mm.view.recyclerview.i)localObject3).Rrj + 1);
          ((JSONObject)localObject2).put("width", ((com.tencent.mm.view.recyclerview.i)localObject3).width);
          ((JSONObject)localObject2).put("height", ((com.tencent.mm.view.recyclerview.i)localObject3).height);
        }
        paramRecyclerView.put(localObject2);
      }
      i = 0;
      break;
      j = 0;
      break label88;
    }
    AppMethodBeat.o(253625);
    return paramRecyclerView;
  }
  
  public static boolean r(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167948);
    kotlin.g.b.p.h(paramFinderObject, "obj");
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
    localObject = com.tencent.mm.plugin.finder.storage.logic.c.a.dyN();
    FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
    if (localFinderObjectDesc != null) {}
    for (int i = localFinderObjectDesc.mediaType; ((List)localObject).contains(Integer.valueOf(i)); i = 0)
    {
      AppMethodBeat.o(167948);
      return true;
    }
    localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if ((localObject != null) && (((LinkedList)localObject).size() == 0))
      {
        AppMethodBeat.o(167948);
        return false;
      }
    }
    localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = (FinderMedia)((LinkedList)localObject).get(0);
        if (localObject == null) {}
      }
    }
    for (i = ((FinderMedia)localObject).mediaType;; i = 0)
    {
      localObject = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      if (com.tencent.mm.plugin.finder.storage.logic.c.a.dyN().contains(Integer.valueOf(i))) {
        break;
      }
      AppMethodBeat.o(167948);
      return false;
    }
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = ((Iterable)paramFinderObject).iterator();
        while (paramFinderObject.hasNext()) {
          if (((FinderMedia)paramFinderObject.next()).mediaType != i)
          {
            AppMethodBeat.o(167948);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(167948);
    return true;
  }
  
  public static int t(FinderObject paramFinderObject)
  {
    Object localObject2 = null;
    int k = 0;
    AppMethodBeat.i(167949);
    kotlin.g.b.p.h(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc != null)
    {
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 == null) {
        break label141;
      }
    }
    label141:
    for (Object localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);; localObject1 = null)
    {
      if (localObject1 == null) {
        Log.printInfoStack(TAG, "obj ".concat(String.valueOf(paramFinderObject)), new Object[0]);
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      Iterable localIterable = (Iterable)com.tencent.mm.plugin.finder.storage.logic.c.a.dyN();
      FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
      localObject1 = localObject2;
      if (localFinderObjectDesc != null) {
        localObject1 = Integer.valueOf(localFinderObjectDesc.mediaType);
      }
      if (!kotlin.a.j.a(localIterable, localObject1)) {
        break label155;
      }
      paramFinderObject = paramFinderObject.objectDesc;
      if (paramFinderObject == null) {
        break;
      }
      i = paramFinderObject.mediaType;
      AppMethodBeat.o(167949);
      return i;
    }
    AppMethodBeat.o(167949);
    return 0;
    label155:
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0))
      {
        paramFinderObject = paramFinderObject.objectDesc;
        if (paramFinderObject != null)
        {
          i = paramFinderObject.mediaType;
          AppMethodBeat.o(167949);
          return i;
        }
        AppMethodBeat.o(167949);
        return 0;
      }
    }
    localObject1 = paramFinderObject.objectDesc;
    if (localObject1 != null)
    {
      localObject1 = ((FinderObjectDesc)localObject1).media;
      if (localObject1 != null)
      {
        localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
        if (localObject1 == null) {}
      }
    }
    for (int i = ((FinderMedia)localObject1).mediaType;; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      if (com.tencent.mm.plugin.finder.storage.logic.c.a.dyN().contains(Integer.valueOf(i))) {
        break;
      }
      AppMethodBeat.o(167949);
      return i;
    }
    if (i == 4)
    {
      localObject1 = paramFinderObject.objectDesc;
      int j = k;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        j = k;
        if (localObject1 != null) {
          j = ((LinkedList)localObject1).size();
        }
      }
      if (j > 1)
      {
        AppMethodBeat.o(167949);
        return 8;
      }
    }
    paramFinderObject = paramFinderObject.objectDesc;
    if (paramFinderObject != null)
    {
      paramFinderObject = paramFinderObject.media;
      if (paramFinderObject != null)
      {
        paramFinderObject = ((Iterable)paramFinderObject).iterator();
        while (paramFinderObject.hasNext()) {
          if (((FinderMedia)paramFinderObject.next()).mediaType != i)
          {
            AppMethodBeat.o(167949);
            return 8;
          }
        }
      }
    }
    AppMethodBeat.o(167949);
    return i;
  }
  
  public static azy u(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167959);
    kotlin.g.b.p.h(paramBaseFinderFeed, "feed");
    azy localazy = new azy();
    localazy.refObjectFlag = 1L;
    if (paramBaseFinderFeed.feedObject.getRefObjectFlag() == 1L) {
      localazy.refObjectId = paramBaseFinderFeed.feedObject.getRefObjectId();
    }
    for (localazy.refObjectContact = paramBaseFinderFeed.feedObject.getRefObjectContact();; localazy.refObjectContact = com.tencent.mm.plugin.finder.api.b.a(paramBaseFinderFeed))
    {
      AppMethodBeat.o(167959);
      return localazy;
      localazy.refObjectId = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed == null) {
        kotlin.g.b.p.hyc();
      }
    }
  }
  
  public static List<BaseFinderFeed> u(List<? extends BaseFinderFeed> paramList, int paramInt)
  {
    AppMethodBeat.i(253701);
    kotlin.g.b.p.h(paramList, "cacheDataList");
    List localList = (List)new ArrayList();
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
    kotlin.g.b.p.g(localObject1, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
    localObject1 = (FinderTabStreamUnreadVM)localObject1;
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    for (;;)
    {
      int j;
      if (paramList.hasNext())
      {
        Object localObject2 = paramList.next();
        j = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject2 = (BaseFinderFeed)localObject2;
        if (i < 2) {
          break label261;
        }
        e.a locala = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        if (!e.a.al(paramInt, ((BaseFinderFeed)localObject2).feedObject.field_id))
        {
          long l;
          boolean bool;
          if (((BaseFinderFeed)localObject2).feedObject.field_id != 0L)
          {
            l = ((BaseFinderFeed)localObject2).feedObject.field_id;
            switch (paramInt)
            {
            case 2: 
            default: 
              bool = true;
            }
          }
          for (;;)
          {
            if (!bool) {
              localList.add(localObject2);
            }
            i = j;
            break;
            bool = ((FinderTabStreamUnreadVM)localObject1).wuL.Gz(l);
            continue;
            bool = ((FinderTabStreamUnreadVM)localObject1).wuK.Gz(l);
            continue;
            bool = ((FinderTabStreamUnreadVM)localObject1).wuM.Gz(l);
          }
        }
      }
      AppMethodBeat.o(253701);
      return localList;
      label261:
      i = j;
    }
  }
  
  public static boolean u(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(253615);
    kotlin.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x1) == 0)
    {
      AppMethodBeat.o(253615);
      return true;
    }
    AppMethodBeat.o(253615);
    return false;
  }
  
  public static boolean v(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(253637);
    kotlin.g.b.p.h(paramBaseFinderFeed, "item");
    if ((paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount > 0) && (paramBaseFinderFeed.feedObject.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(253637);
      return true;
    }
    AppMethodBeat.o(253637);
    return false;
  }
  
  public static boolean v(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(253616);
    kotlin.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x2) == 0)
    {
      AppMethodBeat.o(253616);
      return true;
    }
    AppMethodBeat.o(253616);
    return false;
  }
  
  public static boolean w(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(253655);
    kotlin.g.b.p.h(paramBaseFinderFeed, "item");
    if (paramBaseFinderFeed.feedObject.getMediaType() == 9)
    {
      AppMethodBeat.o(253655);
      return true;
    }
    AppMethodBeat.o(253655);
    return false;
  }
  
  public static boolean w(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(253617);
    kotlin.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x4) != 0)
    {
      AppMethodBeat.o(253617);
      return true;
    }
    AppMethodBeat.o(253617);
    return false;
  }
  
  public static String x(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(253692);
    kotlin.g.b.p.h(paramBaseFinderFeed, "feed");
    if (paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count > 1)
    {
      paramBaseFinderFeed = MMApplicationContext.getContext().getString(2131759725, new Object[] { Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count) });
      kotlin.g.b.p.g(paramBaseFinderFeed, "MMApplicationContext.get…Object.follow_feed_count)");
      AppMethodBeat.o(253692);
      return paramBaseFinderFeed;
    }
    paramBaseFinderFeed = MMApplicationContext.getContext().getString(2131759724);
    kotlin.g.b.p.g(paramBaseFinderFeed, "MMApplicationContext.get…follow_pat_entrance_tips)");
    AppMethodBeat.o(253692);
    return paramBaseFinderFeed;
  }
  
  public static boolean x(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(253618);
    kotlin.g.b.p.h(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x8) == 0)
    {
      AppMethodBeat.o(253618);
      return true;
    }
    AppMethodBeat.o(253618);
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "", "isValid", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "feedType", "", "feedPosition", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(ZJLjava/lang/String;Lcom/tencent/mm/plugin/finder/storage/FeedData;IILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentVisibleFeedList", "Ljava/util/LinkedList;", "getCurrentVisibleFeedList", "()Ljava/util/LinkedList;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedPosition", "()I", "setFeedPosition", "(I)V", "getFeedType", "setFeedType", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "()Z", "setValid", "(Z)V", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class a
  {
    boolean daZ;
    public FeedData feed;
    public long feedId;
    public String mediaId;
    public com.tencent.mm.view.recyclerview.h tAm;
    public final LinkedList<a> vXI;
    public int vXJ;
    public int vXK;
    
    public a()
    {
      this(false, null, 127);
    }
    
    public a(boolean paramBoolean, long paramLong, String paramString, FeedData paramFeedData, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.h paramh)
    {
      AppMethodBeat.i(253561);
      this.daZ = paramBoolean;
      this.feedId = paramLong;
      this.mediaId = paramString;
      this.feed = paramFeedData;
      this.vXJ = paramInt1;
      this.vXK = paramInt2;
      this.tAm = paramh;
      this.vXI = new LinkedList();
      AppMethodBeat.o(253561);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(253564);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.daZ != paramObject.daZ) || (this.feedId != paramObject.feedId) || (!kotlin.g.b.p.j(this.mediaId, paramObject.mediaId)) || (!kotlin.g.b.p.j(this.feed, paramObject.feed)) || (this.vXJ != paramObject.vXJ) || (this.vXK != paramObject.vXK) || (!kotlin.g.b.p.j(this.tAm, paramObject.tAm))) {}
        }
      }
      else
      {
        AppMethodBeat.o(253564);
        return true;
      }
      AppMethodBeat.o(253564);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      boolean bool2 = true;
      AppMethodBeat.i(253560);
      Object localObject = new StringBuilder("isValid=").append(this.daZ).append(" feedType=").append(this.vXJ).append(" feedPosition=").append(this.vXK).append(" feedId=").append(com.tencent.mm.ac.d.zs(this.feedId)).append(" mediaId=").append(this.mediaId).append(" holder=");
      if (this.tAm != null)
      {
        bool1 = true;
        localObject = ((StringBuilder)localObject).append(bool1).append(" centerList=").append(this.vXI.size()).append(" feed=");
        if (this.feed != null) {
          break label145;
        }
      }
      label145:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localObject = bool1;
        AppMethodBeat.o(253560);
        return localObject;
        bool1 = false;
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class c
    implements DialogInterface.OnClickListener
  {
    c(boolean paramBoolean, bed parambed, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167933);
      com.tencent.mm.kernel.g.ah(aj.class);
      if (this.vXN) {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(10);
      }
      for (;;)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("key_create_scene", 3);
        paramDialogInterface.putExtra("scene", 1);
        Object localObject = parambed;
        if (localObject != null) {
          paramDialogInterface.putExtra("key_prepare_resp", ((bed)localObject).toByteArray());
        }
        localObject = a.vUU;
        a.w(paramContext, paramDialogInterface);
        AppMethodBeat.o(167933);
        return;
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(12);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167934);
      com.tencent.mm.kernel.g.ah(aj.class);
      if (this.vXN) {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Ks(5);
        AppMethodBeat.o(167934);
        return;
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(13);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class e
    implements DialogInterface.OnDismissListener
  {
    e(boolean paramBoolean) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(167936);
      com.tencent.mm.kernel.g.ah(aj.class);
      if (this.vXN) {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.i.vfo;
        com.tencent.mm.plugin.finder.report.i.Ks(5);
        AppMethodBeat.o(167936);
        return;
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).reportPostRedDot(13);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(Activity paramActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167938);
      paramDialogInterface = a.vUU;
      a.am(this.msB);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.at(7, false);
      AppMethodBeat.o(167938);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    public static final g vXQ;
    
    static
    {
      AppMethodBeat.i(253571);
      vXQ = new g();
      AppMethodBeat.o(253571);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(253570);
      paramDialogInterface = com.tencent.mm.plugin.finder.report.i.vfo;
      com.tencent.mm.plugin.finder.report.i.at(7, false);
      AppMethodBeat.o(253570);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class h
    implements f.c
  {
    public static final h vXR;
    
    static
    {
      AppMethodBeat.i(253572);
      vXR = new h();
      AppMethodBeat.o(253572);
    }
    
    public final void e(boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class i
    implements DialogInterface.OnDismissListener
  {
    public static final i vXS;
    
    static
    {
      AppMethodBeat.i(253573);
      vXS = new i();
      AppMethodBeat.o(253573);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/utils/FinderUtil$getVisibleFeedListByAdapterPosRange$1$1$1$1$2$1$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$4", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$5"})
  static final class k
    implements Runnable
  {
    k(ViewParent paramViewParent, FinderFoldedScrollLayout paramFinderFoldedScrollLayout, com.tencent.mm.view.recyclerview.i parami, com.tencent.mm.view.recyclerview.a parama, com.tencent.mm.plugin.finder.event.base.g paramg, View paramView, RecyclerView paramRecyclerView, RecyclerView.a parama1, Rect paramRect, y.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(253575);
      locali.Rre = ((View)this.vXU).getTop();
      if (locali.Rrd - locali.Rrc - locali.Rrb > locali.Rre)
      {
        if (!locali.Rrf)
        {
          locali.Rrf = true;
          Object localObject = locali.Rri;
          if (localObject != null)
          {
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((WxRecyclerAdapter)localObject).onResume();
              AppMethodBeat.o(253575);
              return;
            }
          }
          AppMethodBeat.o(253575);
        }
      }
      else if (locali.Rrf)
      {
        locali.Rrf = false;
        locali.Rrg = true;
      }
      AppMethodBeat.o(253575);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToMachineTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class l
    extends ClickableSpan
  {
    l(kotlin.g.a.a parama, int paramInt, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253576);
      kotlin.g.b.p.h(paramView, "widget");
      paramView = this.tPo;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(253576);
        return;
      }
      AppMethodBeat.o(253576);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(253577);
      kotlin.g.b.p.h(paramTextPaint, "ds");
      Context localContext;
      if (!y.a(y.vXH, paramInt, 0, 2))
      {
        localContext = paramTextView.getContext();
        kotlin.g.b.p.g(localContext, "tv.context");
        paramTextPaint.setColor(localContext.getResources().getColor(2131099787));
      }
      for (;;)
      {
        paramTextPaint.setUnderlineText(false);
        paramTextPaint.clearShadowLayer();
        AppMethodBeat.o(253577);
        return;
        localContext = paramTextView.getContext();
        kotlin.g.b.p.g(localContext, "tv.context");
        paramTextPaint.setColor(localContext.getResources().getColor(2131100631));
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToNearbyLiveMorePage$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class m
    extends ClickableSpan
  {
    m(kotlin.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253578);
      kotlin.g.b.p.h(paramView, "widget");
      paramView = this.tPo;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(253578);
        return;
      }
      AppMethodBeat.o(253578);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(253579);
      kotlin.g.b.p.h(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      kotlin.g.b.p.g(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(2131099784));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(253579);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToTargetTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class n
    extends ClickableSpan
  {
    n(kotlin.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(253580);
      kotlin.g.b.p.h(paramView, "widget");
      paramView = this.tPo;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(253580);
        return;
      }
      AppMethodBeat.o(253580);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(253581);
      kotlin.g.b.p.h(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      kotlin.g.b.p.g(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(2131099784));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(253581);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class o
    implements u.b
  {
    public static final o vYd;
    
    static
    {
      AppMethodBeat.i(253583);
      vYd = new o();
      AppMethodBeat.o(253583);
    }
    
    public final void dU(View paramView)
    {
      AppMethodBeat.i(253582);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(2131309260);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(253582);
          return;
        }
      }
      AppMethodBeat.o(253582);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.y
 * JD-Core Version:    0.7.0.1
 */