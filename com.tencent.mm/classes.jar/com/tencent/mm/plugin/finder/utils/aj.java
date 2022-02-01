package com.tencent.mm.plugin.finder.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.f.a.hu.a;
import com.tencent.mm.f.a.ig;
import com.tencent.mm.f.a.ig.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.j.a;
import com.tencent.mm.plugin.gallery.picker.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cww;
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
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
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
import java.util.Map;
import java.util.Set;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.o;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil;", "", "()V", "FAST_CLICK_DELAY_TIME_MS", "", "FINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "getFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "()I", "setFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "(I)V", "FINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "getFINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "setFINDER_FOLLOW_FULLSCREEN_ENJOY_VALUE", "FINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "getFINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "setFINDER_FRIEND_FULLSCREEN_ENJOY_VALUE", "FINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "getFINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "setFINDER_GLOBAL_FULLSCREEN_ENJOY_VALUE", "FINDER_HOT_FULLSCREEN_ENJOY_VALUE", "getFINDER_HOT_FULLSCREEN_ENJOY_VALUE", "setFINDER_HOT_FULLSCREEN_ENJOY_VALUE", "FINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "getFINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "setFINDER_OTHER_FULLSCREEN_ENJOY_VALUE", "FINDER_POST_DISABLE_HALF_SCREEN_VALUE", "getFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "setFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "FINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "getFINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "setFINDER_SHARE_FULLSCREEN_ENJOY_VALUE", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "OTHER_CARE_REPORT_RV_TYPE", "", "getOTHER_CARE_REPORT_RV_TYPE", "()Ljava/util/Set;", "POST_WIDER_MEDIA_LAYOUT_SIZE", "TAG", "", "VISIBILITY_CARE_RV_TYPE", "getVISIBILITY_CARE_RV_TYPE", "debug", "", "getDebug", "()Z", "heightPixels", "isNeedResetFullScreenConfig", "setNeedResetFullScreenConfig", "(Z)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "lastClickTime", "margin", "mediaRect", "Landroid/graphics/Rect;", "navigationBarHeight", "getNavigationBarHeight", "navigationBarHeight$delegate", "Lkotlin/Lazy;", "screenInfoObj", "Lorg/json/JSONObject;", "getScreenInfoObj", "()Lorg/json/JSONObject;", "setScreenInfoObj", "(Lorg/json/JSONObject;)V", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "blurVideoThumb", "Landroid/graphics/Bitmap;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "bitmap", "source", "buildConvertFailMsg", "", "logPrefix", "type", "calculateFloatBallLayoutParams", "Lkotlin/Triple;", "parent", "Landroid/view/View;", "originWidth", "originHeight", "calculateLongVideoLayoutParams", "context", "Landroid/app/Activity;", "targetView", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "calculateLongVideoTLLayoutParams", "Landroid/content/Context;", "calculateMediaLayoutParams", "child", "radio", "screenHeight", "tag", "feedId", "calculatePercent", "offset", "total", "calculatePostLayoutParams", "width", "height", "calculateStaggeredLayoutParams", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "calculateTimelineLayoutParams", "canFav", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "canFollowMusic", "canLike", "canMegaVideoFav", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "canMegaVideoLike", "canMegaVideoPostBullet", "canMegaVideoShare", "canReprint", "feed", "canShare", "canShareRingTone", "canShareTextStatus", "canShowTime", "changeSystemViewColor", "window", "Landroid/view/Window;", "light", "checkAgreeGetPhone", "checkBindPhone", "checkFinderNotifyControlFlag", "info", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "flag", "msgId", "checkFinderSelfRedPackRedDot", "priority", "entranceRedDotTitle", "profileTopRedDotTitle", "checkHasAccountAndCreate", "activity", "tip", "showRed", "userPrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkHasCloseRedPack", "checkHasEnterRedPackMiniApp", "checkHasRealname", "titleStr", "dismissCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "checkIfAccountLegal", "checkIfMsgMute", "extFlag", "checkIfRedPackInTime", "checkMyTabRedPackRedDot", "finderSelfUiRedDotTitle", "checkResetFullScreenConfig", "checkShowCgiErrorAlter", "errType", "errCode", "errMsg", "checkUserState", "clearFinderMsgLastBuf", "clearWxMsgLastBuf", "convertCompatibilityMediaType", "obj", "createIntentWithCache", "Landroid/content/Intent;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "isHot", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "createVideoPreloadTask", "taskCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "currentTimeSecond", "decodeBitmap", "inputStream", "Ljava/io/InputStream;", "limitW", "limitH", "isRotate", "isClose", "delAliasInfo", "deletingInfo", "Lcom/tencent/mm/plugin/finder/model/FinderOrAliasDeletingInfo;", "deleteMyLocalAccountData", "fillLocalImageToView", "imageView", "Landroid/widget/ImageView;", "fillRefInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "filterText", "origin", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "fixRecyclerViewPosition", "initPos", "linearLayoutManager", "formatCampaignTime", "time", "formatLiveNew", "num", "formatLiveNum", "roundingDown", "formatFloat", "formatTextWithEllipse", "paint", "Landroid/text/TextPaint;", "content", "maxLines", "genCheckUserNameCondition", "needDummyConv", "(Ljava/lang/Boolean;)Ljava/lang/String;", "genClientMsgId", "genMsgHolderCondition", "genPoiAddress", "descs", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinString_t;", "getAuthIconDrawable", "style", "username", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/graphics/drawable/Drawable;", "drawable", "getBgmView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "focusHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getCampaignTimeList", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dayCount", "getClipData", "getCommentSceneByTabType", "tabType", "getCompareFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "headCount", "compareFeedLogic", "Lkotlin/Function1;", "getCurrentRoleUserName", "getCurrentRoleUserNameByScene", "msgAccountType", "getCurrentScreenIndexInfo", "Lorg/json/JSONArray;", "getDisplayName", "nickname", "printLog", "getEllipseText", "preText", "ellipseTotalText", "endText", "availableWidth", "getFeed", "position", "feedList", "getFeedListByAdapterPosRange", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "start", "end", "getFinderLiveCommentPopCenter", "", "view", "floatView", "getFinderLiveNoticeTips", "getFinderMsgSuffixColor", "scene", "getFinderPageDir", "getFollowPatWording", "getFromUserName", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getHint", "key", "resId", "getHomeTabInitCacheList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "firstPageFlag", "isPreload", "getHourList", "day", "formatStrRes", "isIgnoreMinute", "getImageLocation", "", "getImageWidthHeight", "Landroid/graphics/Point;", "filePath", "getLastBuffKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getListOfType", "E", "T", "clazz", "Ljava/lang/Class;", "getLocationShowString", "countryCode", "provinceCode", "cityCode", "getMaxMediaHWRadio", "list", "getMaxShareMediaHWRadio", "Lcom/tencent/mm/protocal/protobuf/FinderShareMedia;", "getMaxShareMegaMediaHWRadio", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareMedia;", "getMediaRateLimit", "hwRate", "getMentionNick", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getNickName", "getNoticePickerFirstList", "getNoticePickerSecondList", "getNoticePickerThirdList", "hour", "getNoticeStartTime", "getNumFormatStr", "getPoiText", "city", "poiName", "getPosition", "getPrintDescription", "desc", "getRandomChina", "", "getSceneByCurrentRole", "getScreenInfo", "getSelfNameByScene", "getSelfUsernameByScene", "getShareUiEnter", "reportScene", "getSpanTouchListener", "Landroid/view/View$OnTouchListener;", "tv", "getTextRealLength", "value", "getTextWithLimit", "text", "limit", "getToUserName", "getUnreadList", "cacheDataList", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "getVideoLocation", "getVideoType", "localFinderMedia", "getVisibleFeedListByAdapterPosRange", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "globalVisibleRect", "hasBgmIcon", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasCreateFinderIdentit", "hasFinderAccount", "hasShowFinderNewGuide", "ifPosterBolcked", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "ifShowNoticeView", "isAcceptLiveObj", "invokeSource", "isAcceptObj", "isAcceptVideoObj", "isAllEnableFullScreenEnjoy", "isAllHomeTabEnableFullScreenEnjoy", "isAllowEditFillingFullScreen", "isAnyEnableFullScreenEnjoy", "isAnyHomeTabEnableFullScreenEnjoy", "isCampaignFinished", "closeFlag", "endTime", "isCommentClose", "isCropVideo", "isDisablePostHalfScreen", "isEnableFullScreenEnjoy", "commentScene", "isFastClick", "isFinderComment", "displayFlag", "isFinderEntranceOpen", "isFinderScene", "isFlowCommentScene", "isFoldableDeviceOrInMagicWindowMode", "isFriend", "isFriendComment", "isGlobalEnableFullScreenEnjoy", "isHomeTabEnableFullScreenEnjoy", "isJsapiFromAd", "extraInfo", "isLikeNotRecommend", "isLiveFeed", "isMoovOptimize", "isMsgLikeEvent", "isNewPauseMode", "isNoSeeAtTab", "userName", "isNormalVideo", "isNotAddDescToCommentDrawer", "isOtherEnableFullScreenEnjoy", "isPauseIconInside", "media", "isPostNewsQualificaion", "isPoster", "isPrivateAccount", "isRealSvrFeed", "isRegInChina", "isSelf", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "isSessionIdExist", "talker", "isShowAtWxProfile", "isTest", "isUseCenterInside", "isUserBlocked", "isUserDeleting", "isUserNameBelongMyFinder", "finderUserName", "isUserWxForeign", "isViewVisibleRectMoreThanThreshold", "visibleRectThreshold", "isHeight", "isWxScene", "isWxSelf", "jumpLocation", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "showShareIcon", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "isDirectToMapUI", "jumpToCampaignAnnounce", "jumpToWxProfile", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "feedUsername", "intent", "fromScene", "addBlackListener", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedUserName", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "nonceId", "liveListIsFirstVisible", "liveListIsVisible", "loadPagLib", "loadPagLibImpl", "makeMediaTypeHappy", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "default", "mergeBackCacheAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "updateLoaderLastBuf", "millisToUnixTime", "timestamp", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "newFeedStyle", "switchValue", "parsePrice", "price", "parseUxInfo", "adInfo", "postCommentCountChangedEvent", "it", "postExposeDelEvent", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentId", "clientId", "printAllItem", "printFinderMessages", "processFinderAliasSync", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "changeUserName", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;Ljava/lang/Boolean;Ljava/lang/String;)V", "reportCollectUnreadItem", "remain", "resize2Even", "saveCacheToIntent", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "setPriceTypeFace", "Landroid/widget/TextView;", "setSpanTouch", "Landroid/text/Spannable;", "setToMachineTab", "onClick", "Lkotlin/Function0;", "setToNearbyLiveMorePage", "setToTargetTab", "tabName", "forceEnableNightMode", "setVisibility", "visibility", "shake", "Landroid/animation/ObjectAnimator;", "shakeFactor", "showBanToast", "wording", "showFeedCommentInput", "ifShow", "showFinderTabType", "showLongVideoEntrance", "finderItem", "sourceFlagToLocalTypeFlag", "sourceType", "switchScene", "tabTypeToSourceFlag", "testStack", "transOldFinderMsgSessionAndConv", "transformColor", "begin", "percent", "tryCatchReleaseException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "extraMsg", "tryLoadPagLibrary", "prefix", "unixTimeToMillis", "videoFlagToVideoFormat", "videoFlag", "toByteString", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "VisibilityFeed", "VisibleFeedDataObj", "plugin-finder_release"})
public final class aj
{
  private static final int AFN;
  private static final int AFO;
  private static final Set<Integer> AFP;
  private static final Set<Integer> AFQ;
  private static final Rect AFR;
  private static JSONObject AFS;
  private static boolean AFT = false;
  public static int AFU = 0;
  private static int AFV = 0;
  private static int AFW = 0;
  private static int AFX = 0;
  private static int AFY = 0;
  private static int AFZ = 0;
  private static int AGa = 0;
  public static int AGb = 0;
  public static final aj AGc;
  public static final String TAG = "Finder.FinderUtil";
  private static final boolean aGM;
  private static long lastClickTime;
  private static long xjA;
  static final kotlin.f xjt;
  private static final kotlin.f xju;
  private static final int zFx;
  private static final int zWN;
  
  static
  {
    AppMethodBeat.i(167970);
    AGc = new aj();
    TAG = "Finder.FinderUtil";
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    AFN = (int)((Context)localObject).getResources().getDimension(b.d.Edge_1_5_A);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    AFO = (int)((Context)localObject).getResources().getDimension(b.d.post_wider_media_layout_size);
    AFP = kotlin.a.ak.setOf(Integer.valueOf(2013));
    AFQ = kotlin.a.ak.setOf(Integer.valueOf(2003));
    aGM = BuildInfo.DEBUG;
    AFR = new Rect();
    xjA = -1L;
    xjt = kotlin.g.ar((kotlin.g.a.a)aj.p.AGD);
    xju = kotlin.g.ar((kotlin.g.a.a)aj.u.AGG);
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    zFx = ((Resources)localObject).getDisplayMetrics().heightPixels;
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    zWN = ((Number)com.tencent.mm.plugin.finder.storage.d.dWi().aSr()).intValue();
    AFT = true;
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AFU = ((Number)com.tencent.mm.plugin.finder.storage.d.dWC().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AFV = ((Number)com.tencent.mm.plugin.finder.storage.d.dWD().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AFW = ((Number)com.tencent.mm.plugin.finder.storage.d.dWE().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AFX = ((Number)com.tencent.mm.plugin.finder.storage.d.dWF().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AFY = ((Number)com.tencent.mm.plugin.finder.storage.d.dWH().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AFZ = ((Number)com.tencent.mm.plugin.finder.storage.d.dWG().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AGa = ((Number)com.tencent.mm.plugin.finder.storage.d.dWI().aSr()).intValue();
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    AGb = ((Number)com.tencent.mm.plugin.finder.storage.d.dWJ().aSr()).intValue();
    AppMethodBeat.o(167970);
  }
  
  public static boolean A(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283098);
    p.k(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x20) == 0)
    {
      AppMethodBeat.o(283098);
      return true;
    }
    AppMethodBeat.o(283098);
    return false;
  }
  
  public static void B(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(178459);
    p.k(paramFinderItem, "it");
    ig localig = new ig();
    localig.fFp.feedId = paramFinderItem.field_id;
    localig.fFp.fFr = paramFinderItem.getCommentCount();
    EventCenter.instance.publish((IEvent)localig);
    AppMethodBeat.o(178459);
  }
  
  public static boolean B(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283099);
    p.k(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x4) != 0)
    {
      AppMethodBeat.o(283099);
      return true;
    }
    AppMethodBeat.o(283099);
    return false;
  }
  
  public static boolean C(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(283129);
    p.k(paramFinderItem, "item");
    if ((paramFinderItem.getFeedObject().incFriendLikeCount > 0) && (paramFinderItem.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(283129);
      return true;
    }
    AppMethodBeat.o(283129);
    return false;
  }
  
  public static boolean C(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283101);
    p.k(paramFinderObject, "finderObject");
    p.k(paramFinderObject, "obj");
    if (paramFinderObject.objectDesc != null)
    {
      localObject = paramFinderObject.objectDesc;
      if (localObject == null) {
        break label133;
      }
      localObject = Integer.valueOf(((FinderObjectDesc)localObject).mediaType);
      if (localObject != null) {}
    }
    else
    {
      Log.printInfoStack(TAG, "obj ".concat(String.valueOf(paramFinderObject)), new Object[0]);
    }
    Object localObject = ak.AGL;
    Iterable localIterable = (Iterable)ak.eeC();
    localObject = paramFinderObject.objectDesc;
    label97:
    int i;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((FinderObjectDesc)localObject).mediaType);
      if (!kotlin.a.j.a(localIterable, localObject)) {
        break label148;
      }
      localObject = paramFinderObject.objectDesc;
      if (localObject == null) {
        break label143;
      }
      i = ((FinderObjectDesc)localObject).mediaType;
    }
    for (;;)
    {
      if (i == 4) {
        break label366;
      }
      AppMethodBeat.o(283101);
      return false;
      label133:
      localObject = null;
      break;
      localObject = null;
      break label97;
      label143:
      i = 0;
      continue;
      label148:
      localObject = paramFinderObject.objectDesc;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if ((localObject != null) && (((LinkedList)localObject).size() == 0))
        {
          localObject = paramFinderObject.objectDesc;
          if (localObject != null)
          {
            i = ((FinderObjectDesc)localObject).mediaType;
            continue;
          }
          i = 0;
          continue;
        }
      }
      localObject = paramFinderObject.objectDesc;
      int j;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        if (localObject != null)
        {
          localObject = (FinderMedia)((LinkedList)localObject).get(0);
          if (localObject != null)
          {
            j = ((FinderMedia)localObject).mediaType;
            label231:
            localObject = ak.AGL;
            i = j;
            if (!ak.eeC().contains(Integer.valueOf(j))) {
              continue;
            }
            if (j != 4) {
              break label301;
            }
            localObject = paramFinderObject.objectDesc;
            if (localObject == null) {
              break label296;
            }
            localObject = ((FinderObjectDesc)localObject).media;
            if (localObject == null) {
              break label296;
            }
          }
        }
      }
      label296:
      for (i = ((LinkedList)localObject).size();; i = 0)
      {
        if (i <= 1) {
          break label301;
        }
        i = 8;
        break;
        j = 0;
        break label231;
      }
      label301:
      localObject = paramFinderObject.objectDesc;
      i = j;
      if (localObject != null)
      {
        localObject = ((FinderObjectDesc)localObject).media;
        i = j;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((FinderMedia)((Iterator)localObject).next()).mediaType == j);
          i = 8;
        }
      }
    }
    label366:
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dRO().aSr()).intValue() != 1)
    {
      AppMethodBeat.o(283101);
      return false;
    }
    if ((paramFinderObject.permissionFlag & 0x40) == 0)
    {
      AppMethodBeat.o(283101);
      return true;
    }
    AppMethodBeat.o(283101);
    return false;
  }
  
  public static boolean D(FinderItem paramFinderItem)
  {
    Object localObject1 = null;
    AppMethodBeat.i(283174);
    p.k(paramFinderItem, "feed");
    Object localObject2 = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject2, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)localObject2).dYT())
    {
      AppMethodBeat.o(283174);
      return false;
    }
    if (!E(paramFinderItem.getFinderObject()))
    {
      AppMethodBeat.o(283174);
      return false;
    }
    if (E(paramFinderItem))
    {
      AppMethodBeat.o(283174);
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
            if ((localObject1 != null) && (((bfs)localObject1).SQv == 0)) {}
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
            localObject1 = ((bfs)localObject1).groupId;
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
        AppMethodBeat.o(283174);
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
          AppMethodBeat.o(283174);
          return true;
        }
      }
      AppMethodBeat.o(283174);
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
          if ((paramFinderItem == null) || (paramFinderItem.SQv != 1)) {}
        }
      }
      else
      {
        AppMethodBeat.o(283174);
        return true;
      }
      AppMethodBeat.o(283174);
      return false;
    }
    AppMethodBeat.o(283174);
    return false;
  }
  
  public static boolean D(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283102);
    p.k(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x10) == 0)
    {
      AppMethodBeat.o(283102);
      return true;
    }
    AppMethodBeat.o(283102);
    return false;
  }
  
  public static boolean E(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(283175);
    p.k(paramFinderItem, "finderItem");
    if ((!Util.isNullOrNil((List)paramFinderItem.getLongVideoMediaList())) && (zWN == 1))
    {
      AppMethodBeat.o(283175);
      return true;
    }
    AppMethodBeat.o(283175);
    return false;
  }
  
  public static boolean E(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283103);
    p.k(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x8) == 0)
    {
      AppMethodBeat.o(283103);
      return true;
    }
    AppMethodBeat.o(283103);
    return false;
  }
  
  public static int Ne(long paramLong)
  {
    return (int)(paramLong / 1000L);
  }
  
  public static void Nf(long paramLong)
  {
    xjA = paramLong;
  }
  
  public static String Nh(long paramLong)
  {
    AppMethodBeat.i(283160);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.XU(paramLong);
    AppMethodBeat.o(283160);
    return localObject;
  }
  
  public static String Nj(long paramLong)
  {
    AppMethodBeat.i(283202);
    Object localObject1 = Calendar.getInstance();
    Object localObject2 = new Date(paramLong);
    p.j(localObject1, "date");
    ((Calendar)localObject1).setTime((Date)localObject2);
    int i = ((Calendar)localObject1).get(6);
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date(cm.bfE());
    p.j(localCalendar, "todayDate");
    localCalendar.setTime(localDate);
    i -= localCalendar.get(6);
    Log.i(TAG, "[getFinderLiveNoticeTips] dayDiff:" + i + ", bookTime:" + localObject2 + ", todayTime:" + localDate);
    localObject2 = m.k(MMApplicationContext.getContext(), paramLong);
    if (LocaleUtil.isChineseAppLang()) {
      switch (i)
      {
      default: 
        i = ((Calendar)localObject1).get(7);
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = localObject1.getResources().getStringArray(com.tencent.mm.plugin.finder.b.b.time_day)[((i + 5) % 7)];
        localObject1 = MMApplicationContext.getContext().getString(b.j.finder_live_days_after, new Object[] { DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(b.j.fmt_date), paramLong), localObject1 }) + (CharSequence)localObject2;
      }
    }
    for (;;)
    {
      Log.d(TAG, "result:".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(283202);
      return localObject1;
      localObject1 = MMApplicationContext.getContext().getString(b.j.fmt_pre_yesterday) + (CharSequence)localObject2;
      continue;
      localObject1 = MMApplicationContext.getContext().getString(b.j.fmt_pre_nowday) + (CharSequence)localObject2;
      continue;
      localObject1 = MMApplicationContext.getContext().getString(b.j.fmt_pre_tomorrow) + (CharSequence)localObject2;
      continue;
      localObject1 = MMApplicationContext.getContext().getString(b.j.finder_live_day_after_day) + (CharSequence)localObject2;
      continue;
      i = ((Calendar)localObject1).get(1);
      int j = ((Calendar)localObject1).get(2);
      int k = ((Calendar)localObject1).get(5);
      localObject1 = i + '.' + (j + 1) + '.' + k + ' ' + (CharSequence)localObject2;
    }
  }
  
  public static boolean Nk(long paramLong)
  {
    return (paramLong > 2147483647L) || (paramLong < -2147483648L);
  }
  
  public static boolean PE(String paramString)
  {
    AppMethodBeat.i(167957);
    if ((!Util.isNullOrNil(z.bdh())) && (!Util.isNullOrNil(paramString)) && (kotlin.n.n.L(paramString, z.bdh(), false)))
    {
      AppMethodBeat.o(167957);
      return true;
    }
    AppMethodBeat.o(167957);
    return false;
  }
  
  public static int QC(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static long QN(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static String QO(int paramInt)
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
      localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject2).aHl() + "finder/page/";
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
      continue;
      localObject1 = "cleaner";
    }
    localObject2 = new StringBuilder();
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localObject1 = localf.aHl() + "finder/page/" + (String)localObject1 + '/';
    AppMethodBeat.o(167961);
    return localObject1;
  }
  
  public static int QP(int paramInt)
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
  
  public static boolean QQ(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String QR(int paramInt)
  {
    AppMethodBeat.i(167967);
    String str;
    if (paramInt == 2)
    {
      str = z.bdb();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(167967);
      return localObject;
    }
    Object localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
    localObject = com.tencent.mm.plugin.finder.api.d.a.aAK(z.bdh());
    if (localObject != null)
    {
      str = ((com.tencent.mm.plugin.finder.api.i)localObject).getNickname();
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
  
  public static String QS(int paramInt)
  {
    AppMethodBeat.i(178461);
    if (paramInt == 2)
    {
      str = z.bcZ();
      p.j(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(178461);
      return str;
    }
    String str = z.bdh();
    p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(178461);
    return str;
  }
  
  public static int QT(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    return i;
  }
  
  public static boolean QU(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean QV(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static int QW(int paramInt)
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
    case 8192: 
      return 14;
    }
    return 18;
  }
  
  public static ar.a QX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return ar.a.VzN;
    case 0: 
      return ar.a.VzN;
    case 1: 
      return ar.a.VzO;
    case 3: 
      return ar.a.VzP;
    case 2: 
      return ar.a.VzQ;
    }
    return ar.a.VzV;
  }
  
  public static int QY(int paramInt)
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
  
  public static boolean QZ(int paramInt)
  {
    return (0x8000 & paramInt) != 0;
  }
  
  public static boolean Ra(int paramInt)
  {
    return (0x10000 & paramInt) != 0;
  }
  
  public static boolean Rb(int paramInt)
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
  
  public static String Rc(int paramInt)
  {
    AppMethodBeat.i(283120);
    switch (paramInt)
    {
    default: 
      String str = "unknow ".concat(String.valueOf(paramInt));
      AppMethodBeat.o(283120);
      return str;
    case 0: 
      AppMethodBeat.o(283120);
      return "TAB_TYPE_ALL";
    case 1: 
      AppMethodBeat.o(283120);
      return "TAB_TYPE_FRIEND";
    case 2: 
      AppMethodBeat.o(283120);
      return "TAB_TYPE_LBS";
    case 3: 
      AppMethodBeat.o(283120);
      return "TAB_TYPE_FOLLOW";
    }
    AppMethodBeat.o(283120);
    return "TAB_TYPE_MACHINE";
  }
  
  public static int Rd(int paramInt)
  {
    if (paramInt == 2) {
      return b.c.BW_0_Alpha_0_3;
    }
    return b.c.black_color;
  }
  
  public static int Re(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 17: 
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
    case 18: 
      return 15;
    }
    return 9;
  }
  
  public static String Rf(int paramInt)
  {
    AppMethodBeat.i(283157);
    try
    {
      String str = new DecimalFormat("0.00").format(paramInt / 100.0D);
      p.j(str, "DecimalFormat(\"0.00\").format(price / 100.00)");
      AppMethodBeat.o(283157);
      return str;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(283157);
    }
    return "";
  }
  
  public static String Rg(int paramInt)
  {
    AppMethodBeat.i(283162);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    localObject = com.tencent.mm.plugin.finder.live.utils.a.XU(paramInt);
    AppMethodBeat.o(283162);
    return localObject;
  }
  
  public static String Ri(int paramInt)
  {
    AppMethodBeat.i(283164);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(283164);
      return "0";
    }
    if (paramInt < 100)
    {
      AppMethodBeat.o(283164);
      return String.valueOf(paramInt);
    }
    AppMethodBeat.o(283164);
    return "...";
  }
  
  private static ArrayList<List<String>> Rj(int paramInt)
  {
    AppMethodBeat.i(283168);
    ArrayList localArrayList = y(paramInt, b.j.finder_live_notice_hour_format, false);
    AppMethodBeat.o(283168);
    return localArrayList;
  }
  
  private static ArrayList<List<String>> Rk(int paramInt)
  {
    AppMethodBeat.i(283170);
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = kotlin.k.i.a((kotlin.k.c)kotlin.k.i.ou(0, 60), 5);
    int j = ((kotlin.k.c)localObject3).dHa;
    int k = ((kotlin.k.c)localObject3).aaBQ;
    int m = ((kotlin.k.c)localObject3).oxQ;
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
          localObject3 = Rl(i);
          localObject4 = MMApplicationContext.getContext();
          p.j(localObject4, "MMApplicationContext.getContext()");
          ((ArrayList)localObject2).add(((Context)localObject4).getResources().getString(b.j.finder_live_notice_mintue_format, new Object[] { localObject3 }));
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
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
      AppMethodBeat.o(283170);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ArrayList)localObject2;
    localObject3 = new Date(eel());
    Object localObject4 = Calendar.getInstance();
    p.j(localObject4, "date");
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
      AppMethodBeat.o(283170);
      return localObject1;
    }
  }
  
  public static String Rl(int paramInt)
  {
    AppMethodBeat.i(283171);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(283171);
      return str;
    }
    AppMethodBeat.o(283171);
    return String.valueOf(paramInt);
  }
  
  public static boolean Rm(int paramInt)
  {
    AppMethodBeat.i(283180);
    eep();
    if ((AFU == 1) || ((AFV == 1) && (paramInt == 4)) || ((AFW == 1) && (paramInt == 3)) || ((AFX == 1) && (paramInt == 1)))
    {
      AppMethodBeat.o(283180);
      return true;
    }
    AppMethodBeat.o(283180);
    return false;
  }
  
  public static String Rn(int paramInt)
  {
    AppMethodBeat.i(283239);
    switch (paramInt)
    {
    default: 
      str = z.bcZ();
      p.j(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(283239);
      return str;
    case 2: 
      str = z.bcZ();
      p.j(str, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(283239);
      return str;
    case 1: 
      str = z.bdh();
      p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
      AppMethodBeat.o(283239);
      return str;
    }
    String str = z.bdi();
    p.j(str, "ConfigStorageLogic.getMyFinderAliasUsername()");
    AppMethodBeat.o(283239);
    return str;
  }
  
  public static boolean T(long paramLong, int paramInt)
  {
    AppMethodBeat.i(283228);
    com.tencent.c.a.a.a.d.a.e locale = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().Lv(paramLong);
    int i;
    if (locale.systemRowid != -1L)
    {
      i = 1;
      if (i == 0) {
        break label74;
      }
    }
    for (;;)
    {
      if (locale == null) {
        break label80;
      }
      boolean bool = com.tencent.mm.ae.d.dr(locale.field_controlFlag, paramInt);
      AppMethodBeat.o(283228);
      return bool;
      i = 0;
      break;
      label74:
      locale = null;
    }
    label80:
    AppMethodBeat.o(283228);
    return false;
  }
  
  public static FinderImgFeedMusicTag Y(RecyclerView.v paramv)
  {
    AppMethodBeat.i(283173);
    Object localObject;
    if (paramv != null)
    {
      paramv = paramv.amk;
      if (paramv != null)
      {
        paramv = (FinderImgFeedMusicTag)paramv.findViewById(b.f.bgm_iv);
        if (paramv == null) {
          break label82;
        }
        localObject = paramv.getTag(b.f.finder_music_visible_tag);
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = paramv.getTag(b.f.finder_music_visible_tag);
        if (localObject == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(283173);
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
      AppMethodBeat.o(283173);
      return paramv;
    }
  }
  
  public static int a(BaseFinderFeed paramBaseFinderFeed, csg paramcsg, int paramInt)
  {
    AppMethodBeat.i(283039);
    p.k(paramBaseFinderFeed, "item");
    p.k(paramcsg, "mediaObj");
    if (paramInt > 0)
    {
      paramcsg = com.tencent.mm.plugin.finder.storage.data.i.a(paramcsg, false);
      int i;
      int j;
      if ((paramBaseFinderFeed.feedObject.isLiveFeed()) || (paramcsg.getWidth() <= 0))
      {
        i = (int)(3.5D * paramInt / 3.0D);
        if (i <= paramInt * 1.316667F) {
          break label104;
        }
        j = (int)(paramInt * 1.316667F);
      }
      for (;;)
      {
        AppMethodBeat.o(283039);
        return j;
        i = paramcsg.getHeight() * paramInt / paramcsg.getWidth();
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
    AppMethodBeat.o(283039);
    return 0;
  }
  
  public static int a(bu parambu, List<? extends bu> paramList)
  {
    AppMethodBeat.i(283144);
    p.k(paramList, "feedList");
    if (parambu != null)
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
          kotlin.a.j.iBO();
        }
        if (((bu)localObject).mf() == parambu.mf())
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
    AppMethodBeat.o(283144);
    return k;
  }
  
  public static int a(csf paramcsf)
  {
    AppMethodBeat.i(167947);
    p.k(paramcsf, "content");
    if (paramcsf.mediaList.size() == 0)
    {
      AppMethodBeat.o(167947);
      return 4;
    }
    int i = ((csg)paramcsf.mediaList.get(0)).mediaType;
    ak localak = ak.AGL;
    if (!ak.eeC().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167947);
      return i;
    }
    if ((i == 4) && (paramcsf.mediaList.size() > 1))
    {
      AppMethodBeat.o(167947);
      return 8;
    }
    paramcsf = paramcsf.mediaList;
    if (paramcsf != null)
    {
      paramcsf = ((Iterable)paramcsf).iterator();
      while (paramcsf.hasNext()) {
        if (((csg)paramcsf.next()).mediaType != i)
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
    AppMethodBeat.i(283137);
    p.k(paramBaseFinderFeedLoader, "feedLoader");
    p.k(paramLinearLayoutManager, "layoutManager");
    Intent localIntent = new Intent();
    DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataListJustForAdapter();
    com.tencent.mm.cd.b localb = paramBaseFinderFeedLoader.getLastBuffer();
    int k = paramBaseFinderFeedLoader.getInitPos();
    int j = paramLinearLayoutManager.kJ();
    int m = paramLinearLayoutManager.kL();
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
    AppMethodBeat.o(283137);
    return localIntent;
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, boolean paramBoolean, com.tencent.mm.i.g.a parama, com.tencent.mm.i.g.b paramb, int paramInt2, long paramLong, String paramString7)
  {
    AppMethodBeat.i(283146);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "url");
    p.k(paramString3, "path");
    p.k(paramString4, "fileFormat");
    p.k(paramString5, "urlToken");
    p.k(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    boolean bool = com.tencent.mm.plugin.finder.storage.d.dTw();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
    ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
    ((com.tencent.mm.i.h)localObject).isHotSnsVideo = paramBoolean;
    ((com.tencent.mm.i.h)localObject).iUW = 2;
    ((com.tencent.mm.i.h)localObject).iVd = 2;
    ((com.tencent.mm.i.h)localObject).iUX = 8;
    ((com.tencent.mm.i.h)localObject).iVi = paramInt2;
    ((com.tencent.mm.i.h)localObject).field_preloadRatio = paramInt2;
    ((com.tencent.mm.i.h)localObject).concurrentCount = j.a.Bvh;
    ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMediaPreloadModel().zKH;
    ((com.tencent.mm.i.h)localObject).field_fileType = com.tencent.mm.i.a.iUd;
    ((com.tencent.mm.i.h)localObject).preloadMinSize = paramLong;
    ((com.tencent.mm.i.h)localObject).iVk = 0;
    ((com.tencent.mm.i.h)localObject).iUG = parama;
    ((com.tencent.mm.i.h)localObject).iUY = paramb;
    int i;
    if (!bool) {
      if (paramInt1 <= 0)
      {
        i = com.tencent.mm.modelcontrol.e.N(1, paramString3);
        ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      Log.i(paramString7, "[createVideoPreloadTask] finder video, isHot=" + paramBoolean + " reqFormat=" + paramInt1 + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + " preloadPercent:" + paramInt2 + " preloadMinSize:" + paramLong);
      AppMethodBeat.o(283146);
      return localObject;
      i = paramInt1;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.i.h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, boolean paramBoolean, h.a parama, String paramString7)
  {
    AppMethodBeat.i(283145);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "url");
    p.k(paramString3, "path");
    p.k(paramString4, "fileFormat");
    p.k(paramString5, "urlToken");
    p.k(parama, "videoCallback");
    p.k(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    boolean bool = com.tencent.mm.plugin.finder.storage.d.dTw();
    localObject = new com.tencent.mm.i.h();
    ((com.tencent.mm.i.h)localObject).taskName = "task_FinderUtil";
    ((com.tencent.mm.i.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.i.h)localObject).url = (paramString2 + paramString5);
    ((com.tencent.mm.i.h)localObject).iUK = 60;
    ((com.tencent.mm.i.h)localObject).iUL = 60;
    ((com.tencent.mm.i.h)localObject).iVd = 1;
    ((com.tencent.mm.i.h)localObject).iUX = 8;
    ((com.tencent.mm.i.h)localObject).iVk = 0;
    int i;
    if (!bool) {
      if (paramInt <= 0)
      {
        i = com.tencent.mm.modelcontrol.e.N(1, paramString3);
        ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.i.h)localObject).field_fullpath = paramString3;
      ((com.tencent.mm.i.h)localObject).concurrentCount = j.a.Bvh;
      ((com.tencent.mm.i.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMediaPreloadModel().zKI;
      ((com.tencent.mm.i.h)localObject).snsCipherKey = paramString6;
      ((com.tencent.mm.i.h)localObject).isHotSnsVideo = paramBoolean;
      ((com.tencent.mm.i.h)localObject).iVn = parama;
      Log.i(paramString7, "[loadByCdn] finder video, isHot=" + paramBoolean + " reqFormat=" + paramInt + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.i.h)localObject).url + ' ');
      AppMethodBeat.o(283145);
      return localObject;
      i = paramInt;
      break;
      ((com.tencent.mm.i.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.i.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.q a(Intent paramIntent, RecyclerView paramRecyclerView, BaseFeedLoader<bu> paramBaseFeedLoader, boolean paramBoolean, kotlin.g.a.b<? super bu, Boolean> paramb)
  {
    AppMethodBeat.i(283140);
    p.k(paramIntent, "data");
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramBaseFeedLoader, "feedLoader");
    RecyclerView.a locala = paramRecyclerView.getAdapter();
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    paramBaseFeedLoader.initBackCache(paramIntent);
    com.tencent.mm.plugin.finder.feed.model.q localq = paramBaseFeedLoader.getBackCache();
    if (((locala instanceof WxRecyclerAdapter)) && ((paramRecyclerView instanceof StaggeredGridLayoutManager)) && (localq != null) && (!Util.isNullOrNil((List)localq.mXB)) && (localq.lastBuffer != null))
    {
      int k = ((WxRecyclerAdapter)locala).YSk.size();
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
            kotlin.a.j.iBO();
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
      while (paramIntent.size() != localq.mXB.size())
      {
        paramIntent = ((Iterable)paramIntent).iterator();
        for (;;)
        {
          if (paramIntent.hasNext())
          {
            localDataBuffer.remove((bu)paramIntent.next());
            continue;
            paramIntent = new ArrayList();
            localObject1 = (Iterable)localDataBuffer;
            i = 0;
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = ((Iterator)localObject1).next();
              if (i < 0) {
                kotlin.a.j.iBO();
              }
              localObject2 = (bu)localObject2;
              if ((i >= k) && (((Boolean)paramb.invoke(localObject2)).booleanValue())) {
                paramIntent.add(localObject2);
              }
              i += 1;
            }
            paramIntent = (List)paramIntent;
            break;
          }
        }
        localDataBuffer.addAll((Collection)localq.mXB);
        if (paramBoolean) {
          paramBaseFeedLoader.setLastBuffer(localq.lastBuffer);
        }
        locala.notifyDataSetChanged();
      }
      if (localq.position >= 0)
      {
        i = a(q(localq.position, (List)localq.mXB), (List)localDataBuffer);
        ((StaggeredGridLayoutManager)paramRecyclerView).au(i + k, 0);
      }
      Log.i(TAG, "mergeBackCacheAndNotify, pos:" + localq.position + ", headCount:" + k);
      AppMethodBeat.o(283140);
      return localq;
    }
    AppMethodBeat.o(283140);
    return null;
  }
  
  public static aj.b a(final RecyclerView paramRecyclerView, final Rect paramRect)
  {
    AppMethodBeat.i(283110);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramRect, "globalVisibleRect");
    final aj.b localb = new aj.b();
    final RecyclerView.a locala = paramRecyclerView.getAdapter();
    if ((locala instanceof WxRecyclerAdapter))
    {
      Object localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(283110);
        throw paramRecyclerView;
      }
      final int i = ((LinearLayoutManager)localObject).kJ();
      localObject = paramRecyclerView.getLayoutManager();
      if (localObject == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(283110);
        throw paramRecyclerView;
      }
      int k = ((LinearLayoutManager)localObject).kL();
      Log.i(TAG, "[getVisibleFeedListByAdapterPosRange] old=" + paramRecyclerView.getChildCount() + " new=" + (k - i + 1));
      if (i <= k)
      {
        localObject = paramRecyclerView.cK(i);
        final com.tencent.mm.view.recyclerview.a locala1;
        int j;
        final com.tencent.mm.plugin.finder.event.base.g localg;
        final com.tencent.mm.view.recyclerview.j localj;
        if (localObject != null)
        {
          final View localView = ((RecyclerView.v)localObject).amk;
          p.j(localView, "childHolder.itemView");
          if ((localObject instanceof com.tencent.mm.view.recyclerview.i))
          {
            locala1 = (com.tencent.mm.view.recyclerview.a)((com.tencent.mm.view.recyclerview.i)localObject).ihX();
            j = ((WxRecyclerAdapter)locala).YSk.size();
            if (((locala1 instanceof bu)) && (locala1.mf() != 0L))
            {
              localg = new com.tencent.mm.plugin.finder.event.base.g((bu)locala1, i - j, (byte)0);
              if (!(locala1 instanceof BaseFinderFeed)) {
                break label671;
              }
              localj = (com.tencent.mm.view.recyclerview.j)((WxRecyclerAdapter)locala).YSU.get(locala1.mf());
              if (localj != null)
              {
                if (((BaseFinderFeed)locala1).feedObject.getFoldedLayout() != null)
                {
                  localObject = new Rect();
                  paramRecyclerView.getChildVisibleRect(localView, (Rect)localObject, null);
                  localj.YSC = paramRect.top;
                  localj.YSD = paramRect.bottom;
                  localj.YSB = ((Rect)localObject).top;
                  localObject = (FinderFoldedScrollLayout)localView.findViewById(b.f.feed_folded_scroll_layout);
                  if (localObject != null)
                  {
                    if (((FinderFoldedScrollLayout)localObject).getVisibility() != 0) {
                      break label563;
                    }
                    j = 1;
                    label392:
                    if (j == 0) {
                      break label568;
                    }
                    label396:
                    if (localObject != null)
                    {
                      ViewParent localViewParent = ((FinderFoldedScrollLayout)localObject).getParent();
                      if (localViewParent != null)
                      {
                        localViewParent = localViewParent.getParent();
                        if ((localViewParent != null) && ((localViewParent instanceof View)))
                        {
                          localj.YSE = ((View)localViewParent).getTop();
                          localj.YSI = new WeakReference(((FinderFoldedScrollLayout)localObject).getAdapter());
                          localj.YSH = ((FinderFoldedScrollLayout)localObject).getAdapter().YSY;
                          if (localj.YSE != 0) {
                            break label574;
                          }
                          ((View)localViewParent).post((Runnable)new n(localViewParent, (FinderFoldedScrollLayout)localObject, localj, locala1, localView, localg, i, locala, paramRecyclerView, paramRect, localb));
                        }
                      }
                    }
                  }
                }
                label524:
                localg.xrf = localj;
              }
            }
          }
        }
        for (;;)
        {
          if (!(locala1 instanceof com.tencent.mm.plugin.finder.model.x)) {
            localb.AGe.add(localg);
          }
          if (i == k) {
            break label709;
          }
          i += 1;
          break;
          label563:
          j = 0;
          break label392;
          label568:
          localObject = null;
          break label396;
          label574:
          if (localj.YSD - localj.YSC - localj.YSB > localj.YSE)
          {
            if (localj.YSF) {
              break label524;
            }
            localj.YSF = true;
            localObject = localj.YSI;
            if (localObject == null) {
              break label524;
            }
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject == null) {
              break label524;
            }
            ((WxRecyclerAdapter)localObject).onResume();
            break label524;
          }
          if (!localj.YSF) {
            break label524;
          }
          localj.YSF = false;
          localj.YSG = true;
          break label524;
          label671:
          localObject = (com.tencent.mm.view.recyclerview.j)((WxRecyclerAdapter)locala).YSU.get(locala1.mf());
          if (localObject != null) {
            localg.xrf = ((com.tencent.mm.view.recyclerview.j)localObject);
          }
        }
      }
    }
    label709:
    AppMethodBeat.o(283110);
    return localb;
  }
  
  public static b a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Set<Integer> paramSet)
  {
    AppMethodBeat.i(283073);
    p.k(paramRecyclerView, "recyclerView");
    p.k(paramSet, "otherCareType");
    long l = SystemClock.uptimeMillis();
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(283073);
      throw paramRecyclerView;
    }
    localObject1 = (LinearLayoutManager)localObject1;
    if (paramInt1 == -2147483648) {
      paramInt1 = ((LinearLayoutManager)localObject1).kJ();
    }
    int j;
    for (;;)
    {
      j = paramInt2;
      if (paramInt2 == -2147483648) {
        j = ((LinearLayoutManager)localObject1).kL();
      }
      if ((paramInt1 >= 0) && (j >= paramInt1) && (j >= 0)) {
        break;
      }
      paramRecyclerView = new b(false, null, 126);
      AppMethodBeat.o(283073);
      return paramRecyclerView;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject1 = paramRecyclerView.getAdapter();
    if (localObject1 == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
      AppMethodBeat.o(283073);
      throw paramRecyclerView;
    }
    localObject1 = (WxRecyclerAdapter)localObject1;
    Object localObject2 = (List)((WxRecyclerAdapter)localObject1).data;
    paramInt2 = 0;
    localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    int i;
    label258:
    label263:
    int m;
    label296:
    label355:
    label360:
    int n;
    int i1;
    float f;
    int k;
    label408:
    com.tencent.mm.view.recyclerview.i locali;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.view.recyclerview.a)((Iterator)localObject2).next();
      if ((((com.tencent.mm.view.recyclerview.a)localObject3).bAQ() == 4) || (((com.tencent.mm.view.recyclerview.a)localObject3).bAQ() == 2013) || (((com.tencent.mm.view.recyclerview.a)localObject3).bAQ() == 9))
      {
        i = 1;
        if (i == 0) {
          break label465;
        }
        m = paramInt2 + ((com.tencent.mm.view.recyclerview.h)localObject1).YSk.size();
        localObject2 = (List)((WxRecyclerAdapter)localObject1).data;
        paramInt2 = 0;
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label490;
        }
        localObject3 = (com.tencent.mm.view.recyclerview.a)((Iterator)localObject2).next();
        if ((((com.tencent.mm.view.recyclerview.a)localObject3).bAQ() != 4) && (((com.tencent.mm.view.recyclerview.a)localObject3).bAQ() != 2) && (((com.tencent.mm.view.recyclerview.a)localObject3).bAQ() != 9)) {
          break label477;
        }
        i = 1;
        if (i == 0) {
          break label483;
        }
        n = paramInt2 + ((com.tencent.mm.view.recyclerview.h)localObject1).YSk.size();
        i1 = zFx;
        f = i1;
        localObject3 = new b(false, null, 127);
        if (paramInt1 > j) {
          break label1105;
        }
        k = paramInt1;
        paramInt1 = 2147483647;
        localObject2 = paramRecyclerView.cJ(k);
        localObject1 = localObject2;
        if (!(localObject2 instanceof com.tencent.mm.view.recyclerview.i)) {
          localObject1 = null;
        }
        locali = (com.tencent.mm.view.recyclerview.i)localObject1;
        if (locali != null) {
          break label495;
        }
      }
    }
    label818:
    label1214:
    for (;;)
    {
      if (k != j)
      {
        k += 1;
        break label408;
        i = 0;
        break label258;
        label465:
        paramInt2 += 1;
        break;
        paramInt2 = -1;
        break label263;
        label477:
        i = 0;
        break label355;
        label483:
        paramInt2 += 1;
        break label296;
        label490:
        paramInt2 = -1;
        break label360;
        label495:
        localObject2 = locali.ihX();
        localObject1 = localObject2;
        if (!(localObject2 instanceof bu)) {
          localObject1 = null;
        }
        bu localbu = (bu)localObject1;
        if (localbu == null) {
          continue;
        }
        int i2 = localbu.bAQ();
        if ((!(localbu instanceof BaseFinderFeed)) && (!paramSet.contains(Integer.valueOf(i2))) && (!(localbu instanceof bs))) {
          break label1214;
        }
        if ((localbu instanceof BaseFinderFeed))
        {
          localObject1 = FeedData.Companion;
          localObject1 = FeedData.a.t((BaseFinderFeed)localbu);
          label594:
          if ((!(localbu instanceof BaseFinderFeed)) && (!(localbu instanceof bs))) {
            break label713;
          }
        }
        label713:
        for (localObject2 = locali.RD(b.f.media_banner);; localObject2 = locali.amk)
        {
          AFR.setEmpty();
          if (((View)localObject2).getGlobalVisibleRect(AFR)) {
            break label723;
          }
          Log.v(TAG, "getGlobalVisibleRect error continue " + AFR);
          break;
          if ((localbu instanceof bs))
          {
            localObject1 = ((bs)localbu).dtn();
            break label594;
          }
          if ((localbu instanceof com.tencent.mm.plugin.finder.feed.an))
          {
            localObject1 = ((com.tencent.mm.plugin.finder.feed.an)localbu).dtn();
            break label594;
          }
          localObject1 = null;
          break label594;
        }
        label723:
        Rect localRect = AFR;
        localRect.top = androidx.core.b.a.clamp(localRect.top, 0, i1);
        localRect = AFR;
        localRect.bottom = androidx.core.b.a.clamp(localRect.bottom, 0, i1);
        if (AFR.height() <= 0)
        {
          Log.v(TAG, "mediaRect.height() error continue " + AFR);
          continue;
        }
        if ((k == m) && (n == m))
        {
          paramInt2 = 0;
          if ((i2 != 4) && (i2 != 2013))
          {
            i = paramInt2;
            if (i2 == 2)
            {
              i = paramInt2;
              if (localObject1 != null)
              {
                i = paramInt2;
                if (((FeedData)localObject1).getHasBgmInfo() != true) {}
              }
            }
          }
          else
          {
            i2 = AFR.height();
            p.j(localObject2, "mediaView");
            i = paramInt2;
            if (i2 > ((View)localObject2).getHeight() / 2) {
              i = paramInt2 - i1;
            }
          }
          if (i >= paramInt1) {
            break label1214;
          }
          ((b)localObject3).ACQ = localbu.bAQ();
          ((b)localObject3).ACR = k;
          ((b)localObject3).xhX = locali;
          ((b)localObject3).feedId = localbu.mf();
          ((b)localObject3).feed = ((FeedData)localObject1);
          localObject2 = locali.RD(b.f.media_banner);
          if (localObject1 == null) {
            break label1099;
          }
        }
        label1099:
        for (localObject1 = ((FeedData)localObject1).getMediaList();; localObject1 = null)
        {
          if ((localObject2 != null) && (localObject1 != null))
          {
            localObject2 = (FinderMediaBanner)localObject2;
            if ((((FinderMediaBanner)localObject2).getFocusPosition() >= 0) && (((FinderMediaBanner)localObject2).getFocusPosition() < ((LinkedList)localObject1).size()))
            {
              localObject1 = (csg)kotlin.a.j.M((List)localObject1, ((FinderMediaBanner)localObject2).getFocusPosition());
              if (localObject1 != null)
              {
                localObject2 = ((csg)localObject1).mediaId;
                localObject1 = localObject2;
                if (localObject2 != null) {}
              }
              else
              {
                localObject1 = "";
              }
              ((b)localObject3).setMediaId((String)localObject1);
            }
          }
          localLinkedList.add(b.b((b)localObject3));
          paramInt1 = i;
          break;
          paramInt2 = (int)Math.abs(f * 0.4F - AFR.top);
          break label818;
        }
      }
      label1105:
      ((b)localObject3).ACP.addAll((Collection)localLinkedList);
      if (xjA != ((b)localObject3).feedId)
      {
        Log.i(TAG, "[findCenterFeed] cost=" + (SystemClock.uptimeMillis() - l) + "ms firstFeedIndex=" + n + " firstVideoFeedIndex=" + m + ", centerResult=[" + localObject3 + ']');
        xjA = ((b)localObject3).feedId;
      }
      AppMethodBeat.o(283073);
      return localObject3;
    }
  }
  
  public static com.tencent.mm.plugin.finder.view.e a(Context paramContext, String paramString, Intent paramIntent, int paramInt, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    AppMethodBeat.i(283085);
    p.k(paramContext, "context");
    Log.i(TAG, "jump to wx profile %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    if (!Util.isNullOrNil(paramString)) {
      localIntent.putExtra("Username", paramString);
    }
    paramString = com.tencent.mm.plugin.finder.view.t.BbG;
    paramContext = com.tencent.mm.plugin.finder.view.t.a.a(paramContext, localIntent, paramInt, paramb);
    AppMethodBeat.o(283085);
    return paramContext;
  }
  
  public static String a(TextPaint paramTextPaint, String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(283118);
    p.k(paramTextPaint, "paint");
    p.k(paramString1, "preText");
    p.k(paramString2, "ellipseTotalText");
    p.k(paramString3, "endText");
    float f1 = paramTextPaint.measureText(paramString1);
    float f2 = paramTextPaint.measureText(paramString3);
    paramString2 = TextUtils.ellipsize((CharSequence)paramString2, paramTextPaint, paramFloat - f1 - f2, TextUtils.TruncateAt.END);
    paramString1 = new StringBuilder().append(paramString1);
    paramTextPaint = paramString2;
    if (paramString2 == null) {
      paramTextPaint = "";
    }
    paramTextPaint = paramTextPaint + paramString3;
    AppMethodBeat.o(283118);
    return paramTextPaint;
  }
  
  public static String a(com.tencent.mm.plugin.finder.model.a parama)
  {
    AppMethodBeat.i(283082);
    p.k(parama, "item");
    Object localObject = parama.zzT;
    if (((com.tencent.mm.plugin.finder.storage.an)localObject).dZj())
    {
      parama = new StringBuilder();
      localObject = ((com.tencent.mm.plugin.finder.storage.an)localObject).field_aggregatedContacts.SPt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
        parama.append(hv(localFinderContact.username, localFinderContact.nickname)).append("，");
      }
      localObject = parama.toString();
      p.j(localObject, "nickNameList.toString()");
      parama = (com.tencent.mm.plugin.finder.model.a)localObject;
      if (!Util.isNullOrNil((String)localObject))
      {
        int i = ((String)localObject).length();
        if (localObject == null)
        {
          parama = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(283082);
          throw parama;
        }
        parama = ((String)localObject).substring(0, i - 1);
        p.j(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      AppMethodBeat.o(283082);
      return parama;
    }
    parama = hv(((com.tencent.mm.plugin.finder.storage.an)localObject).field_username, ((com.tencent.mm.plugin.finder.storage.an)localObject).field_nickname);
    AppMethodBeat.o(283082);
    return parama;
  }
  
  public static List<com.tencent.mm.plugin.finder.event.base.g> a(int paramInt1, int paramInt2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(283109);
    p.k(paramRecyclerView, "recyclerView");
    LinkedList localLinkedList = new LinkedList();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2))
    {
      paramRecyclerView = kotlin.a.j.t((Collection)localLinkedList);
      AppMethodBeat.o(283109);
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
          i = paramInt1 - ((WxRecyclerAdapter)paramRecyclerView).YSk.size();
          if ((i >= 0) && (i < localList.size()))
          {
            Object localObject2 = (com.tencent.mm.view.recyclerview.a)localList.get(i);
            if ((((com.tencent.mm.view.recyclerview.a)localObject2).mf() != 0L) && ((localObject2 instanceof bu)))
            {
              localObject1 = new com.tencent.mm.plugin.finder.event.base.g((bu)localObject2, i, (byte)0);
              localObject2 = (com.tencent.mm.view.recyclerview.j)((WxRecyclerAdapter)paramRecyclerView).YSU.get(((com.tencent.mm.view.recyclerview.a)localObject2).mf());
              if (localObject2 != null) {
                ((com.tencent.mm.plugin.finder.event.base.g)localObject1).xrf = ((com.tencent.mm.view.recyclerview.j)localObject2);
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
    else if ((paramRecyclerView instanceof com.tencent.mm.plugin.finder.search.g.b))
    {
      localList = ((com.tencent.mm.plugin.finder.search.g.b)paramRecyclerView).dQT();
      if (paramInt1 <= paramInt2) {
        for (;;)
        {
          i = ((com.tencent.mm.plugin.finder.search.g.b)paramRecyclerView).PW(paramInt1);
          if ((i >= 0) && (i < localList.size()))
          {
            localObject1 = (BaseFinderFeed)localList.get(i);
            if (((BaseFinderFeed)localObject1).mf() != 0L) {
              localLinkedList.add(new com.tencent.mm.plugin.finder.event.base.g((bu)localObject1, i, (byte)0));
            }
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
    }
    paramRecyclerView = kotlin.a.j.t((Collection)localLinkedList);
    AppMethodBeat.o(283109);
    return paramRecyclerView;
  }
  
  public static <T, E> List<E> a(List<? extends T> paramList, Class<E> paramClass)
  {
    AppMethodBeat.i(283130);
    p.k(paramList, "dataList");
    p.k(paramClass, "clazz");
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (paramClass.isInstance(localObject)) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(283130);
    return localList;
  }
  
  public static r<Integer, Integer, Integer> a(Context paramContext, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(283046);
    p.k(paramContext, "context");
    Point localPoint = ar.au(paramContext);
    int j;
    int i;
    if ((localPoint.x != 0) && (localPoint.y != 0))
    {
      j = 1;
      if (j == 0) {
        break label133;
      }
      i = localPoint.y;
      label49:
      if (j == 0) {
        break label159;
      }
      j = localPoint.x;
      label61:
      if (paramFloat2 / paramFloat1 <= i / j) {
        break label183;
      }
    }
    label133:
    label159:
    label183:
    for (int k = i;; k = (int)(j * paramFloat2 / paramFloat1))
    {
      if (i == k) {
        j = (int)(i * paramFloat1 / paramFloat2);
      }
      paramContext = new r(Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), Integer.valueOf(j), Integer.valueOf(k));
      AppMethodBeat.o(283046);
      return paramContext;
      j = 0;
      break;
      Resources localResources = paramContext.getResources();
      p.j(localResources, "context.resources");
      i = localResources.getDisplayMetrics().heightPixels;
      break label49;
      paramContext = paramContext.getResources();
      p.j(paramContext, "context.resources");
      j = paramContext.getDisplayMetrics().widthPixels;
      break label61;
    }
  }
  
  public static void a(final int paramInt, final TextView paramTextView, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(283113);
    p.k(paramTextView, "tv");
    p.k(parama, "onClick");
    Object localObject1 = paramTextView.getContext();
    p.j(localObject1, "tv.context");
    localObject1 = ((Context)localObject1).getResources();
    int i = b.j.finder_go_to_machine_tab_tips;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.AjH;
    localObject1 = ((Resources)localObject1).getString(i, new Object[] { com.tencent.mm.plugin.finder.storage.d.dTv() });
    p.j(localObject1, "tv.context.resources.get…abType.TAB_TYPE_MACHINE))");
    localObject2 = paramTextView.getContext();
    p.j(localObject2, "tv.context");
    localObject2 = ((Context)localObject2).getResources();
    i = b.j.finder_go_to_machine_tab_tips_for_index;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    localObject2 = ((Resources)localObject2).getString(i, new Object[] { com.tencent.mm.plugin.finder.storage.d.dTv() });
    p.j(localObject2, "tv.context.resources.get…abType.TAB_TYPE_MACHINE))");
    i = kotlin.n.n.a((CharSequence)localObject1, (String)localObject2, 0, false, 6);
    int j = i + ((String)localObject2).length();
    localObject2 = new SpannableString((CharSequence)localObject1);
    if ((i <= 0) || (j > ((String)localObject1).length()))
    {
      j = ((String)localObject1).length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject2).setSpan(new q(parama, paramInt, paramTextView), i, j, 33);
      parama = paramTextView.getContext();
      p.j(parama, "tv.context");
      paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject2);
      AppMethodBeat.o(283113);
      return;
    }
  }
  
  public static void a(int paramInt, List<? extends bu> paramList, com.tencent.mm.cd.b paramb, Intent paramIntent, com.tencent.mm.plugin.finder.feed.model.c paramc)
  {
    AppMethodBeat.i(283132);
    p.k(paramList, "feedList");
    p.k(paramIntent, "intent");
    FinderEmptyLoader localFinderEmptyLoader = new FinderEmptyLoader();
    localFinderEmptyLoader.getDataList().addAll((Collection)paramList);
    localFinderEmptyLoader.setLastBuffer(paramb);
    localFinderEmptyLoader.saveCache(paramIntent, paramInt, paramc);
    AppMethodBeat.o(283132);
  }
  
  public static void a(int paramInt, List<? extends bu> paramList, bid parambid)
  {
    AppMethodBeat.i(283116);
    p.k(paramList, "remain");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (bu)paramList.next();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
      if (!e.a.ao(paramInt, ((bu)localObject1).mf()))
      {
        localObject2 = new bku();
        ((bku)localObject2).xbk = ((bu)localObject1).mf();
        if ((localObject1 instanceof BaseFinderFeed)) {
          ((bku)localObject2).objectNonceId = ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId();
        }
        if (parambid != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
          ((bku)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.n.N(((bku)localObject2).xbk, parambid.xkX);
        }
        ((bku)localObject2).fEH = 4;
        localLinkedList.add(localObject2);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        new com.tencent.mm.plugin.finder.cgi.b((List)localLinkedList, parambid).bhW();
      }
      AppMethodBeat.o(283116);
      return;
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(283154);
    hu localhu;
    hu.a locala;
    if (BuildInfo.IS_FLAVOR_PURPLE)
    {
      localhu = new hu();
      localhu.fEL.id = paramLong;
      locala = localhu.fEL;
      if (!paramBoolean) {
        break label89;
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      locala.fEN = i;
      localhu.fEL.fEM = paramInt;
      localhu.fEL.type = 7;
      EventCenter.instance.publish((IEvent)localhu);
      AppMethodBeat.o(283154);
      return;
    }
  }
  
  public static void a(Activity paramActivity, float paramFloat1, float paramFloat2, View paramView, css paramcss)
  {
    AppMethodBeat.i(283042);
    p.k(paramActivity, "context");
    p.k(paramView, "targetView");
    paramActivity = a((Context)paramActivity, paramFloat1, paramFloat2);
    int i = ((Number)paramActivity.My).intValue();
    int j = ((Number)paramActivity.aazK).intValue();
    if (paramcss != null)
    {
      paramFloat1 = i / paramFloat1;
      if (Float.compare(1.0F, paramFloat1) != 0)
      {
        Object localObject = paramcss.TAw;
        paramActivity = (Activity)localObject;
        if (localObject == null) {
          paramActivity = new blk();
        }
        p.j(paramActivity, "it.matrix ?: FinderViewMatrix()");
        localObject = new Matrix();
        paramActivity = paramActivity.SWx;
        p.j(paramActivity, "originMatrix.value");
        ((Matrix)localObject).setValues(kotlin.a.j.r((Collection)paramActivity));
        ((Matrix)localObject).postScale(paramFloat1, paramFloat1);
        paramActivity = new float[9];
        ((Matrix)localObject).getValues(paramActivity);
        localObject = paramcss.TAw;
        if (localObject != null)
        {
          localObject = ((blk)localObject).SWx;
          if (localObject != null) {
            ((LinkedList)localObject).clear();
          }
        }
        localObject = paramcss.TAw;
        if (localObject != null)
        {
          localObject = ((blk)localObject).SWx;
          if (localObject != null) {
            ((LinkedList)localObject).addAll((Collection)kotlin.a.e.t(paramActivity));
          }
        }
        paramcss.width = i;
        paramcss.height = j;
        paramActivity = paramcss.TAv;
        if (paramActivity != null) {
          paramActivity.left = 0;
        }
        paramActivity = paramcss.TAv;
        if (paramActivity != null) {
          paramActivity.right = i;
        }
        paramActivity = paramcss.TAv;
        if (paramActivity != null) {
          paramActivity.top = j;
        }
        paramActivity = paramcss.TAv;
        if (paramActivity != null) {
          paramActivity.bottom = 0;
        }
      }
    }
    paramcss = paramView.getLayoutParams();
    paramActivity = paramcss;
    if (paramcss == null) {
      paramActivity = new ViewGroup.LayoutParams(i, j);
    }
    paramActivity.width = i;
    paramActivity.height = j;
    paramView.setLayoutParams(paramActivity);
    AppMethodBeat.o(283042);
  }
  
  public static void a(Context paramContext, bdm parambdm, boolean paramBoolean)
  {
    AppMethodBeat.i(283065);
    p.k(paramContext, "context");
    p.k(parambdm, "location");
    if (Util.isNullOrNil(parambdm.SOz))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("map_view_type", 7);
      localIntent.putExtra("kwebmap_slat", parambdm.latitude);
      localIntent.putExtra("kwebmap_lng", parambdm.longitude);
      String str = parambdm.poiName;
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = parambdm.city;
      }
      localIntent.putExtra("kPoiName", (String)localObject);
      localIntent.putExtra("Kwebmap_locaion", parambdm.KFu);
      localIntent.putExtra("kShowshare", paramBoolean);
      com.tencent.mm.by.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(283065);
      return;
    }
    Object localObject = kotlin.g.b.af.aaBG;
    localObject = com.tencent.mm.protocal.d.RAM;
    p.j(localObject, "ConstantsProtocal.MM_NEAR_LIFE_URI");
    parambdm = String.format((String)localObject, Arrays.copyOf(new Object[] { parambdm.SOz }, 1));
    p.j(parambdm, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", parambdm);
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(283065);
  }
  
  public static void a(View paramView1, final View paramView2, final float paramFloat, final int paramInt, final String paramString, final long paramLong)
  {
    AppMethodBeat.i(283072);
    p.k(paramView2, "child");
    if (paramView1 != null)
    {
      Object localObject1 = paramView1.getContext();
      if (localObject1 == null)
      {
        paramView1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(283072);
        throw paramView1;
      }
      Object localObject2 = ((Activity)localObject1).getBaseContext();
      p.j(localObject2, "baseContext");
      localObject2 = ((Context)localObject2).getResources();
      p.j(localObject2, "baseContext.resources");
      int i = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      int j = paramInt - (int)((Activity)localObject1).getResources().getDimension(b.d.Edge_10A);
      float f1 = 1.0F * paramInt / i;
      float f2 = 1.0F * (j - getTopBarHeight()) / i;
      float f3 = 1.0F * j / i;
      float f4 = paramInt;
      int k = kotlin.h.a.dm(paramInt * 0.05F);
      boolean bool = eeq();
      if (Float.isNaN(paramFloat))
      {
        paramView2.getLayoutParams().width = i;
        paramView2.getLayoutParams().height = i;
        localObject1 = paramView1.getLayoutParams();
        if (localObject1 == null)
        {
          paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(283072);
          throw paramView1;
        }
        localObject1 = (FrameLayout.LayoutParams)localObject1;
        ((FrameLayout.LayoutParams)localObject1).topMargin = getTopBarHeight();
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((FrameLayout.LayoutParams)localObject1).gravity = 48;
        com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "calculateMedia_radio_error", false, false, (kotlin.g.a.a)new c(paramView1, paramInt, paramFloat, paramView2, paramString, paramLong), 12);
        paramInt = -2;
      }
      for (;;)
      {
        Log.i(TAG, "[calculateMediaLayoutParams] source=" + paramInt + " tag=" + paramString + ' ' + "radio=" + paramFloat + " screenRadio=" + f1 + " avatarFromScreenTopRadio=" + f3 + " avatarFromTopBarRadio=" + f2);
        AppMethodBeat.o(283072);
        return;
        if (bool)
        {
          if (paramFloat >= f1)
          {
            paramView2.getLayoutParams().height = paramInt;
            paramView2.getLayoutParams().width = kotlin.h.a.dm(paramInt / paramFloat);
          }
          for (;;)
          {
            paramView1 = paramView1.getLayoutParams();
            if (paramView1 != null) {
              break;
            }
            paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(283072);
            throw paramView1;
            paramView2.getLayoutParams().width = i;
            paramView2.getLayoutParams().height = kotlin.h.a.dm(i * paramFloat);
          }
          paramView1 = (FrameLayout.LayoutParams)paramView1;
          paramView1.topMargin = 0;
          paramView1.bottomMargin = 0;
          paramView1.gravity = 17;
          paramInt = -1;
        }
        else if (paramFloat >= f1)
        {
          paramView2.getLayoutParams().width = i;
          paramView2.getLayoutParams().height = kotlin.h.a.dm(i * paramFloat);
          paramView1 = paramView1.getLayoutParams();
          if (paramView1 == null)
          {
            paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(283072);
            throw paramView1;
          }
          paramView1 = (FrameLayout.LayoutParams)paramView1;
          paramView1.topMargin = 0;
          paramView1.bottomMargin = 0;
          paramView1.gravity = 17;
          paramInt = 1;
        }
        else if (f3 < paramFloat)
        {
          paramView2.getLayoutParams().width = kotlin.h.a.dm(paramInt / paramFloat);
          paramView2.getLayoutParams().height = paramInt;
          paramView1 = paramView1.getLayoutParams();
          if (paramView1 == null)
          {
            paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(283072);
            throw paramView1;
          }
          paramView1 = (FrameLayout.LayoutParams)paramView1;
          paramView1.topMargin = 0;
          paramView1.bottomMargin = 0;
          paramView1.gravity = 17;
          paramInt = 2;
        }
        else if (f2 < paramFloat)
        {
          paramView2.getLayoutParams().width = i;
          paramView2.getLayoutParams().height = j;
          paramView1 = paramView1.getLayoutParams();
          if (paramView1 == null)
          {
            paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(283072);
            throw paramView1;
          }
          paramView1 = (FrameLayout.LayoutParams)paramView1;
          paramView1.topMargin = 0;
          paramView1.bottomMargin = 0;
          paramView1.gravity = 48;
          paramInt = 3;
        }
        else if (f4 * 0.45F - i * paramFloat / 2.0F >= getTopBarHeight())
        {
          paramView2.getLayoutParams().width = i;
          paramView2.getLayoutParams().height = kotlin.h.a.dm(i * paramFloat);
          paramView1 = paramView1.getLayoutParams();
          if (paramView1 == null)
          {
            paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(283072);
            throw paramView1;
          }
          paramView1 = (FrameLayout.LayoutParams)paramView1;
          paramView1.topMargin = (-k);
          paramView1.bottomMargin = 0;
          paramView1.gravity = 17;
          paramInt = 4;
        }
        else
        {
          paramView2.getLayoutParams().width = i;
          paramView2.getLayoutParams().height = kotlin.h.a.dm(i * paramFloat);
          paramView1 = paramView1.getLayoutParams();
          if (paramView1 == null)
          {
            paramView1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(283072);
            throw paramView1;
          }
          paramView1 = (FrameLayout.LayoutParams)paramView1;
          paramView1.topMargin = getTopBarHeight();
          paramView1.bottomMargin = 0;
          paramView1.gravity = 48;
          paramInt = 5;
        }
      }
    }
    AppMethodBeat.o(283072);
  }
  
  public static void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(283149);
    p.k(paramImageView, "view");
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
        com.tencent.mm.plugin.finder.loader.t localt;
        switch (paramFinderAuthInfo.authIconType)
        {
        default: 
          paramImageView.setVisibility(8);
          AppMethodBeat.o(283149);
          return;
        case 1: 
          localObject = (CharSequence)paramFinderAuthInfo.authIconUrl;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
            i = 1;
          }
          if (i == 0)
          {
            localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
            localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
            paramFinderAuthInfo = new com.tencent.mm.plugin.finder.loader.x(paramFinderAuthInfo.authIconUrl, com.tencent.mm.plugin.finder.storage.u.Aly);
            localt = com.tencent.mm.plugin.finder.loader.t.ztT;
            ((com.tencent.mm.loader.d)localObject).a(paramFinderAuthInfo, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(com.tencent.mm.plugin.finder.loader.t.a.ztU));
            AppMethodBeat.o(283149);
            return;
          }
          if (paramInt == 0)
          {
            paramImageView.setImageResource(b.i.icons_filled_star_identify_sold);
            AppMethodBeat.o(283149);
            return;
          }
          paramImageView.setImageDrawable(au.o(paramImageView.getContext(), b.i.icons_filled_star_identify, com.tencent.mm.ci.a.w(paramImageView.getContext(), b.c.orange_100)));
          AppMethodBeat.o(283149);
          return;
        case 2: 
          localObject = (CharSequence)paramFinderAuthInfo.authIconUrl;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
          for (i = 1; i == 0; i = 0)
          {
            localObject = com.tencent.mm.plugin.finder.loader.t.ztT;
            localObject = com.tencent.mm.plugin.finder.loader.t.dJe();
            paramFinderAuthInfo = new com.tencent.mm.plugin.finder.loader.x(paramFinderAuthInfo.authIconUrl, com.tencent.mm.plugin.finder.storage.u.Aly);
            localt = com.tencent.mm.plugin.finder.loader.t.ztT;
            ((com.tencent.mm.loader.d)localObject).a(paramFinderAuthInfo, paramImageView, com.tencent.mm.plugin.finder.loader.t.a(com.tencent.mm.plugin.finder.loader.t.a.ztU));
            AppMethodBeat.o(283149);
            return;
          }
          if (paramInt == 0)
          {
            paramImageView.setImageResource(b.i.icons_filled_star_identify_enterprise_sold);
            AppMethodBeat.o(283149);
            return;
          }
          paramImageView.setImageResource(b.i.icons_filled_star_identify_enterprise);
          AppMethodBeat.o(283149);
          return;
        }
        paramImageView.setVisibility(8);
        AppMethodBeat.o(283149);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(283149);
      return;
    }
    AppMethodBeat.o(283149);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public static void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(283105);
    p.k(paramTextView, "tv");
    p.k(paramSpannable, "text");
    paramTextView.setOnTouchListener(eN((View)paramTextView));
    AppMethodBeat.o(283105);
  }
  
  public static void a(final TextView paramTextView, String paramString, final boolean paramBoolean, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(283115);
    p.k(paramTextView, "tv");
    p.k(paramString, "tabName");
    p.k(parama, "onClick");
    Object localObject = paramTextView.getContext();
    p.j(localObject, "tv.context");
    localObject = ((Context)localObject).getResources().getString(b.j.nearby_live_square_tab_more_live_tips);
    p.j(localObject, "tv.context.resources.get…quare_tab_more_live_tips)");
    Context localContext = paramTextView.getContext();
    p.j(localContext, "tv.context");
    paramString = localContext.getResources().getString(b.j.nearby_live_square_tab_no_live_data_tips, new Object[] { paramString, localObject });
    p.j(paramString, "tv.context.resources.get…s, tabName, gotoPageTips)");
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
      ((SpannableString)localObject).setSpan(new s(parama, paramTextView, paramBoolean), i, j, 33);
      paramString = paramTextView.getContext();
      p.j(paramString, "tv.context");
      paramTextView.setHighlightColor(paramString.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(283115);
      return;
    }
  }
  
  public static void a(final TextView paramTextView, kotlin.g.a.a<kotlin.x> parama)
  {
    AppMethodBeat.i(283114);
    p.k(paramTextView, "tv");
    p.k(parama, "onClick");
    Object localObject1 = paramTextView.getContext();
    p.j(localObject1, "tv.context");
    localObject1 = ((Context)localObject1).getResources().getString(b.j.nearby_more_reomm_live_tips);
    p.j(localObject1, "tv.context.resources.get…rby_more_reomm_live_tips)");
    Object localObject2 = paramTextView.getContext();
    p.j(localObject2, "tv.context");
    localObject2 = ((Context)localObject2).getResources().getString(b.j.nearby_no_live_data_tips, new Object[] { localObject1 });
    p.j(localObject2, "tv.context.resources.get…_data_tips, gotoPageTips)");
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
      ((SpannableString)localObject1).setSpan(new r(parama, paramTextView), i, j, 33);
      parama = paramTextView.getContext();
      p.j(parama, "tv.context");
      paramTextView.setHighlightColor(parama.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(283114);
      return;
    }
  }
  
  public static void a(axc paramaxc, Boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(283231);
    p.k(paramaxc, "aliasInfo");
    p.k(paramString, "source");
    int i;
    try
    {
      localObject1 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.f)localObject1).aHp().a(ar.a.Vyd, "");
      Log.i(TAG, "[processFinderAliasSync] source:" + paramString + ", status:" + paramaxc.SJB + " , userName:" + paramaxc.SJz + " , avatar:" + paramaxc.ueX + " , currentAliasUserName:" + (String)localObject1);
      i = paramaxc.SJB;
      switch (i)
      {
      default: 
        AppMethodBeat.o(283231);
        return;
      }
    }
    catch (Exception paramaxc)
    {
      label224:
      Log.printDebugStack(TAG, "", new Object[] { paramaxc });
      AppMethodBeat.o(283231);
      return;
    }
    paramString = paramaxc.SJz;
    if (paramString != null)
    {
      p.j(paramString, "it");
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if (i == 0)
        {
          p.j(localObject1, "currentAliasUserName");
          if (((CharSequence)localObject1).length() <= 0) {
            break label316;
          }
          i = 1;
          if ((i == 0) || (!(p.h(localObject1, paramaxc.SJz) ^ true))) {
            break label321;
          }
        }
        Log.i(TAG, "processFinderAliasSync ask to change alias info,but alias_msg_name is not legal, alias_msg_name:" + paramaxc.SJz + ",currentAlias:" + (String)localObject1);
        AppMethodBeat.o(283231);
      }
    }
    label316:
    label321:
    do
    {
      i = 0;
      break;
      i = 0;
      break label224;
      Object localObject2 = new com.tencent.mm.plugin.finder.api.i();
      localObject1 = paramaxc.nickname;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.finder.api.i)localObject2).setNickname(paramString);
      localObject1 = paramaxc.ueX;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.finder.api.i)localObject2).aAS(paramString);
      if (p.h(paramBoolean, Boolean.TRUE))
      {
        localObject1 = paramaxc.SJz;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((com.tencent.mm.plugin.finder.api.i)localObject2).setUsername(paramString);
      }
      ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMsgAliasContactStorage().g((com.tencent.mm.plugin.finder.api.i)localObject2);
      paramString = com.tencent.mm.kernel.h.aHG();
      p.j(paramString, "MMKernel.storage()");
      localObject2 = paramString.aHp();
      ar.a locala = ar.a.Vye;
      localObject1 = paramaxc.nickname;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((ao)localObject2).set(locala, paramString);
      paramString = com.tencent.mm.kernel.h.aHG();
      p.j(paramString, "MMKernel.storage()");
      localObject2 = paramString.aHp();
      locala = ar.a.Vyf;
      localObject1 = paramaxc.ueX;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((ao)localObject2).set(locala, paramString);
    } while (!p.h(paramBoolean, Boolean.TRUE));
    paramBoolean = com.tencent.mm.kernel.h.aHG();
    p.j(paramBoolean, "MMKernel.storage()");
    paramString = paramBoolean.aHp();
    Object localObject1 = ar.a.Vyd;
    paramBoolean = paramaxc.SJz;
    paramaxc = paramBoolean;
    if (paramBoolean == null) {
      paramaxc = "";
    }
    paramString.set((ar.a)localObject1, paramaxc);
    AppMethodBeat.o(283231);
    return;
    b("processFinderAliasSync", null);
    AppMethodBeat.o(283231);
  }
  
  public static void a(com.tencent.mm.view.recyclerview.i parami, String paramString, s params)
  {
    AppMethodBeat.i(283084);
    p.k(parami, "holder");
    p.k(paramString, "feedUserName");
    p.k(params, "item");
    Intent localIntent = new Intent();
    int i = 5;
    if ((!Util.isNullOrNil(paramString)) && (p.h(paramString, z.bdh())))
    {
      localIntent.putExtra("IsPoster", true);
      if ((params.zAt.dYY().blacklist_flag == 0) && (!Util.isNullOrNil(params.zAt.getUsername())) && (!z.bcZ().equals(params.zAt.getUsername()))) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("feedUser", paramString);
      i = 3;
      localIntent.putExtra("Avatar", params.zAt.dYZ());
      localIntent.putExtra("Nickname", params.zAt.getNickname());
      localIntent.putExtra("CommentId", params.zAt.dYY().commentId);
      localIntent.putExtra("FeedId", params.zAt.field_feedId);
      localIntent.putExtra("FeedNonceId", params.zAt.field_objectNonceId);
      localIntent.putExtra("V5UserName", params.zAt.getUsername());
      paramString = params.zAt.dYY();
      if ((paramString != null) && (paramString.msgInfo != null))
      {
        paramString = params.zAt.dYY().msgInfo;
        if (paramString == null) {
          break label358;
        }
      }
    }
    label358:
    for (paramString = paramString.toByteArray();; paramString = null)
    {
      localIntent.putExtra("ContactMsgInfo", paramString);
      parami = parami.getContext();
      p.j(parami, "holder.context");
      b(parami, params.zAt.getUsername(), localIntent, i);
      if (params.zAt.dYY() != null) {
        break label363;
      }
      Log.i(TAG, "commentInfo = null");
      AppMethodBeat.o(283084);
      return;
      localIntent.putExtra("Action", 2);
      p.j(localIntent.putExtra("IsPoster", false), "intent.putExtra(Constant…xProfile.IsPoster, false)");
      break;
    }
    label363:
    if (params.zAt.dYY().msgInfo == null) {
      Log.i(TAG, "msgInfo is null ,feedId:" + params.zAt.field_feedId + ",comentId:" + params.zAt.dYY().commentId);
    }
    AppMethodBeat.o(283084);
  }
  
  public static void a(Exception paramException, String paramString)
  {
    AppMethodBeat.i(283196);
    p.k(paramException, "e");
    p.k(paramString, "extraMsg");
    if (eej())
    {
      paramException = (Throwable)paramException;
      AppMethodBeat.o(283196);
      throw paramException;
    }
    Log.printInfoStack(TAG, paramString + ' ' + paramException.getMessage(), new Object[0]);
    AppMethodBeat.o(283196);
  }
  
  public static void a(final String paramString, bk parambk)
  {
    AppMethodBeat.i(283221);
    p.k(paramString, "source");
    com.tencent.e.h.ZvG.bf((Runnable)new l(parambk, paramString));
    AppMethodBeat.o(283221);
  }
  
  public static void a(LinkedList<FinderCommentInfo> paramLinkedList, long paramLong1, long paramLong2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(167960);
    p.k(paramLinkedList, "commentList");
    p.k(paramString, "clientId");
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
          paramString = new ig();
          paramString.fFp.feedId = paramLong1;
          localObject = paramString.fFp;
          bfw localbfw = new bfw();
          localbfw.commentList = paramLinkedList;
          ((ig.a)localObject).fFq = localbfw;
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
    } while (p.h(((FinderCommentInfo)((Iterator)localObject).next()).client_id, paramString));
    for (;;)
    {
      i += 1;
      break;
      label250:
      i = -1;
    }
  }
  
  public static boolean a(Context paramContext, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(283211);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.viewmodel.component.aj.a locala = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramContext = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ(paramContext);
    if (paramContext != null)
    {
      i = paramContext.xkX;
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
      AppMethodBeat.o(283211);
      return true;
      i = 0;
      break;
    }
    label75:
    AppMethodBeat.o(283211);
    return false;
  }
  
  public static boolean a(final Context paramContext, String paramString, boolean paramBoolean, final ble paramble)
  {
    AppMethodBeat.i(283057);
    p.k(paramContext, "activity");
    if (Util.isNullOrNil(z.bdh()))
    {
      Log.i(TAG, "need create finder contact");
      String str = paramContext.getString(b.j.finder_create_contact_dialog_tip);
      p.j(str, "activity.getString(R.str…reate_contact_dialog_tip)");
      if (!Util.isNullOrNil(paramString)) {
        str = String.valueOf(paramString);
      }
      paramString = com.tencent.mm.plugin.finder.view.d.AUy;
      com.tencent.mm.plugin.finder.view.d.a.a(paramContext, paramContext.getString(b.j.finder_create_contact_title), str, paramContext.getString(b.j.finder_create_contact_ok), paramContext.getString(b.j.finder_create_contact_cancel), (DialogInterface.OnClickListener)new d(paramBoolean, paramble, paramContext), (DialogInterface.OnClickListener)new e(paramBoolean), (DialogInterface.OnDismissListener)new f(paramBoolean));
      AppMethodBeat.o(283057);
      return false;
    }
    AppMethodBeat.o(283057);
    return true;
  }
  
  public static boolean a(bs parambs)
  {
    AppMethodBeat.i(283067);
    p.k(parambs, "feed");
    parambs = parambs.contact;
    if (!Util.isNullOrNil(z.bdh()))
    {
      if (parambs != null) {}
      for (parambs = parambs.username; kotlin.n.n.L(parambs, z.bdh(), false); parambs = null)
      {
        AppMethodBeat.o(283067);
        return true;
      }
    }
    AppMethodBeat.o(283067);
    return false;
  }
  
  public static boolean a(FinderObject paramFinderObject, String paramString)
  {
    AppMethodBeat.i(283062);
    p.k(paramFinderObject, "obj");
    p.k(paramString, "invokeSource");
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
      AppMethodBeat.o(283062);
      return false;
      i = 0;
      break;
    }
    label145:
    if (paramFinderObject == null) {}
    while (paramFinderObject.intValue() != 2)
    {
      AppMethodBeat.o(283062);
      return true;
    }
    Log.w(TAG, paramString + " isAcceptLiveObj return for invalid liveState:" + paramFinderObject);
    AppMethodBeat.o(283062);
    return false;
  }
  
  public static boolean a(cvy paramcvy)
  {
    if (paramcvy == null) {}
    while ((paramcvy.permissionFlag & 0x4) != 0) {
      return false;
    }
    return true;
  }
  
  public static com.tencent.mm.plugin.sight.base.b aFG(String paramString)
  {
    AppMethodBeat.i(167939);
    p.k(paramString, "filePath");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(167939);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.sight.base.f.aYh(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.sight.base.b();
    }
    if ((((com.tencent.mm.plugin.sight.base.b)localObject1).height <= 0) || (((com.tencent.mm.plugin.sight.base.b)localObject1).width <= 0)) {}
    try
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(com.tencent.mm.vfs.u.n(paramString, false));
      ((com.tencent.mm.plugin.sight.base.b)localObject1).width = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(18), 0);
      ((com.tencent.mm.plugin.sight.base.b)localObject1).height = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(19), 0);
      ((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(20), 0);
      ((MediaMetadataRetriever)localObject2).release();
      label124:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      Log.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.b)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.sight.base.b)localObject1).height), Integer.valueOf(i) });
      if ((i == 270) || (i == 90))
      {
        i = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
        ((com.tencent.mm.plugin.sight.base.b)localObject1).height = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
        ((com.tencent.mm.plugin.sight.base.b)localObject1).width = i;
      }
      AppMethodBeat.o(167939);
      return localObject1;
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
  
  public static Point aFH(String paramString)
  {
    AppMethodBeat.i(167940);
    p.k(paramString, "filePath");
    Point localPoint = new Point();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapUtil.decodeFile(paramString, localOptions);
    localPoint.x = localOptions.outWidth;
    localPoint.y = localOptions.outHeight;
    paramString = Exif.fromFile(paramString);
    p.j(paramString, "Exif.fromFile(filePath)");
    if (paramString.getOrientationInDegree() % 180 != 0)
    {
      int i = localPoint.y;
      localPoint.y = localPoint.x;
      localPoint.x = i;
    }
    AppMethodBeat.o(167940);
    return localPoint;
  }
  
  public static String aFI(String paramString)
  {
    AppMethodBeat.i(283064);
    p.k(paramString, "text");
    Object localObject = new kotlin.n.k("[一-龥]");
    int m = ((CharSequence)paramString).length();
    int j = 0;
    int i = 0;
    int k = 0;
    while (j < m)
    {
      String str = paramString.substring(j, j + 1);
      p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (((kotlin.n.k)localObject).aY((CharSequence)str)) {
        k += 1;
      }
      while (k * 2 + i > 14)
      {
        localObject = new StringBuilder();
        paramString = paramString.substring(0, j);
        p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString = paramString + "...";
        AppMethodBeat.o(283064);
        return paramString;
        i += 1;
      }
      j += 1;
    }
    AppMethodBeat.o(283064);
    return paramString;
  }
  
  public static boolean aFJ(String paramString)
  {
    AppMethodBeat.i(167958);
    boolean bool = Util.isEqual(paramString, z.bcZ());
    AppMethodBeat.o(167958);
    return bool;
  }
  
  public static o<Double, Double> aFK(String paramString)
  {
    AppMethodBeat.i(167965);
    p.k(paramString, "path");
    Object localObject = new an(new ExifInterface(com.tencent.mm.vfs.u.n(paramString, false)));
    paramString = ((an)localObject).AGT;
    localObject = ((an)localObject).AGS;
    if ((localObject != null) && (paramString != null))
    {
      paramString = new o(Double.valueOf(((Float)localObject).floatValue()), Double.valueOf(paramString.floatValue()));
      AppMethodBeat.o(167965);
      return paramString;
    }
    AppMethodBeat.o(167965);
    return null;
  }
  
  public static o<Double, Double> aFL(String paramString)
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
      p.j(paramString, "locationString");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
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
    p.j(paramString, "(this as java.lang.String).toCharArray()");
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
        p.j(paramString, "locSb.toString()");
        j = kotlin.n.n.b((CharSequence)paramString, '+');
        i = j;
        if (-1 == j) {
          i = kotlin.n.n.b((CharSequence)paramString, '-');
        }
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        localObject = paramString.substring(0, i);
        p.j(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble((String)localObject);
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(167966);
          throw paramString;
        }
        paramString = paramString.substring(i);
        p.j(paramString, "(this as java.lang.String).substring(startIndex)");
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
  
  public static String aFM(String paramString)
  {
    AppMethodBeat.i(178463);
    p.k(paramString, "desc");
    if (paramString.length() > 5)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramString = paramString.substring(0, 5);
      p.j(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString + "***";
      AppMethodBeat.o(178463);
      return paramString;
    }
    AppMethodBeat.o(178463);
    return paramString;
  }
  
  public static boolean aFN(String paramString)
  {
    AppMethodBeat.i(283092);
    int i;
    if (p.h(paramString, z.bdh()))
    {
      paramString = com.tencent.mm.kernel.h.aHG();
      p.j(paramString, "MMKernel.storage()");
      i = paramString.aHp().getInt(ar.a.Vzn, 0);
    }
    for (;;)
    {
      if ((i & 0x800) != 0)
      {
        AppMethodBeat.o(283092);
        return true;
        com.tencent.mm.plugin.finder.api.d.a locala = com.tencent.mm.plugin.finder.api.d.wZQ;
        paramString = com.tencent.mm.plugin.finder.api.d.a.aAK(paramString);
        if (paramString != null) {
          i = paramString.field_extFlag;
        }
      }
      else
      {
        AppMethodBeat.o(283092);
        return false;
      }
      i = 0;
    }
  }
  
  public static boolean aFO(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(283176);
    p.k(paramString, "path");
    long l1 = System.currentTimeMillis();
    if (!com.tencent.mm.vfs.u.agG(paramString))
    {
      AppMethodBeat.o(283176);
      return false;
    }
    str2 = null;
    str1 = null;
    try
    {
      paramString = com.tencent.mm.vfs.u.dO(paramString, false);
      str1 = paramString;
      str2 = paramString;
      com.tencent.mm.plugin.a.a locala = com.tencent.mm.plugin.a.c.b(paramString, new byte[8], com.tencent.mm.plugin.a.a.aUM);
      str1 = paramString;
      str2 = paramString;
      p.j(locala, "moovAtom");
      str1 = paramString;
      str2 = paramString;
      long l2 = locala.bvG() + 8L;
      str1 = paramString;
      str2 = paramString;
      long l3 = locala.getSize();
      str1 = paramString;
      str2 = paramString;
      Log.i(TAG, "[isMoovOptimize] cost=" + (System.currentTimeMillis() - l1) + "ms beginPos=" + l2 + " remains=" + (l3 - 8L));
      bool1 = bool2;
      if (l2 > 0L)
      {
        bool1 = bool2;
        if (l2 <= 128L) {
          bool1 = true;
        }
      }
      Util.qualityClose((Closeable)paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Util.qualityClose((Closeable)str1);
      }
    }
    finally
    {
      Util.qualityClose((Closeable)str2);
      AppMethodBeat.o(283176);
    }
    AppMethodBeat.o(283176);
    return bool1;
  }
  
  public static String aFP(String paramString)
  {
    AppMethodBeat.i(283204);
    p.k(paramString, "origin");
    paramString = (CharSequence)kotlin.n.n.bb((CharSequence)paramString).toString();
    paramString = (CharSequence)new kotlin.n.k("(\n\n[\\s]*\n)|(\n[\\s]*\n\n)").e(paramString, "\n\n");
    paramString = (CharSequence)new kotlin.n.k("(\r\n\r\n[\\s]*\r\n)|(\r\n[\\s]*\r\n\r\n)").e(paramString, "\r\n\r\n");
    paramString = new kotlin.n.k("[ ]{11,}").e(paramString, "          ");
    AppMethodBeat.o(283204);
    return paramString;
  }
  
  public static void aFQ(String paramString)
  {
    AppMethodBeat.i(283208);
    p.k(paramString, "prefix");
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    boolean bool1 = ((PluginFinder)localObject).isPagEnable();
    boolean bool2 = ChannelUtil.isGPVersion();
    Log.i(TAG, paramString + " tryLoadPagLibrary pag start,gpVersion:" + bool2 + ",isPagEnable:" + bool1);
    if ((!bool2) || (bool1))
    {
      if (com.tencent.mm.kernel.h.aHB()) {
        break label135;
      }
      Log.e(TAG, "loadPagLib account is not ready");
    }
    for (;;)
    {
      Log.i(TAG, paramString + " tryLoadPagLibrary pag end");
      AppMethodBeat.o(283208);
      return;
      label135:
      localObject = com.tencent.c.a.a.a.a.a.Zlt;
      if (((Number)com.tencent.c.a.a.a.a.a.ilt().aSr()).intValue() == 0) {
        com.tencent.e.h.ZvG.be((Runnable)o.AGC);
      } else {
        eer();
      }
    }
  }
  
  public static int aFR(String paramString)
  {
    AppMethodBeat.i(283218);
    p.k(paramString, "videoFlag");
    paramString = paramString.toLowerCase();
    p.j(paramString, "(this as java.lang.String).toLowerCase()");
    String str = com.tencent.mm.plugin.finder.storage.u.AlB.detail;
    if (str == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(283218);
      throw paramString;
    }
    str = str.toLowerCase();
    p.j(str, "(this as java.lang.String).toLowerCase()");
    if (!p.h(paramString, str))
    {
      str = com.tencent.mm.plugin.finder.storage.u.AlD.detail;
      if (str == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(283218);
        throw paramString;
      }
      str = str.toLowerCase();
      p.j(str, "(this as java.lang.String).toLowerCase()");
      if (!p.h(paramString, str))
      {
        str = com.tencent.mm.plugin.finder.storage.u.AlF.detail;
        if (str == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(283218);
          throw paramString;
        }
        str = str.toLowerCase();
        p.j(str, "(this as java.lang.String).toLowerCase()");
        if (!p.h(paramString, str))
        {
          str = com.tencent.mm.plugin.finder.storage.u.AlH.detail;
          if (str == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(283218);
            throw paramString;
          }
          str = str.toLowerCase();
          p.j(str, "(this as java.lang.String).toLowerCase()");
          if (!p.h(paramString, str))
          {
            str = com.tencent.mm.plugin.finder.storage.u.AlJ.detail;
            if (str == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(283218);
              throw paramString;
            }
            str = str.toLowerCase();
            p.j(str, "(this as java.lang.String).toLowerCase()");
            if (!p.h(paramString, str)) {
              break label283;
            }
          }
        }
      }
    }
    AppMethodBeat.o(283218);
    return 1;
    label283:
    str = com.tencent.mm.plugin.finder.storage.u.AlC.detail;
    if (str == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(283218);
      throw paramString;
    }
    str = str.toLowerCase();
    p.j(str, "(this as java.lang.String).toLowerCase()");
    if (!p.h(paramString, str))
    {
      str = com.tencent.mm.plugin.finder.storage.u.AlE.detail;
      if (str == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(283218);
        throw paramString;
      }
      str = str.toLowerCase();
      p.j(str, "(this as java.lang.String).toLowerCase()");
      if (!p.h(paramString, str))
      {
        str = com.tencent.mm.plugin.finder.storage.u.AlG.detail;
        if (str == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(283218);
          throw paramString;
        }
        str = str.toLowerCase();
        p.j(str, "(this as java.lang.String).toLowerCase()");
        if (!p.h(paramString, str))
        {
          str = com.tencent.mm.plugin.finder.storage.u.AlI.detail;
          if (str == null)
          {
            paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(283218);
            throw paramString;
          }
          str = str.toLowerCase();
          p.j(str, "(this as java.lang.String).toLowerCase()");
          if (!p.h(paramString, str))
          {
            str = com.tencent.mm.plugin.finder.storage.u.AlK.detail;
            if (str == null)
            {
              paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(283218);
              throw paramString;
            }
            str = str.toLowerCase();
            p.j(str, "(this as java.lang.String).toLowerCase()");
            if (!p.h(paramString, str)) {
              break label541;
            }
          }
        }
      }
    }
    AppMethodBeat.o(283218);
    return 2;
    label541:
    AppMethodBeat.o(283218);
    return 0;
  }
  
  public static boolean aFU(String paramString)
  {
    AppMethodBeat.i(283235);
    if (paramString != null)
    {
      int i;
      String str;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label77;
        }
        str = paramString;
      }
      for (;;)
      {
        if (str != null)
        {
          paramString = new JSONObject(paramString).optJSONObject("sns_ad");
          if ((paramString != null) && (paramString.has("uxinfo") == true))
          {
            AppMethodBeat.o(283235);
            return true;
            i = 0;
            break;
            label77:
            str = null;
            continue;
          }
          AppMethodBeat.o(283235);
          return false;
        }
      }
    }
    AppMethodBeat.o(283235);
    return false;
  }
  
  public static boolean aFV(String paramString)
  {
    AppMethodBeat.i(283240);
    p.k(paramString, "finderUserName");
    com.tencent.mm.plugin.finder.api.d.a locala = com.tencent.mm.plugin.finder.api.d.wZQ;
    boolean bool = com.tencent.mm.plugin.finder.api.d.a.dnk().contains(paramString);
    AppMethodBeat.o(283240);
    return bool;
  }
  
  public static boolean aFW(String paramString)
  {
    AppMethodBeat.i(283244);
    p.k(paramString, "talker");
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().aEM(paramString);
    AppMethodBeat.o(283244);
    return bool;
  }
  
  public static String aG(ca paramca)
  {
    AppMethodBeat.i(283117);
    p.k(paramca, "msg");
    if (paramca.apA() == 1)
    {
      paramca = z.bcZ();
      p.j(paramca, "ConfigStorageLogic.getUsernameFromUserInfo()");
    }
    for (;;)
    {
      AppMethodBeat.o(283117);
      return paramca;
      if (!ab.Lj(paramca.apJ())) {
        break;
      }
      paramca = bq.RL(paramca.getContent());
      p.j(paramca, "MsgInfoStorageLogic.getG…hatMsgTalker(msg.content)");
    }
    paramca = paramca.apJ();
    p.j(paramca, "msg.talker");
    AppMethodBeat.o(283117);
    return paramca;
  }
  
  public static String aH(ca paramca)
  {
    AppMethodBeat.i(283119);
    p.k(paramca, "msg");
    if (paramca.apA() == 1)
    {
      paramca = paramca.apJ();
      p.j(paramca, "msg.talker");
    }
    for (;;)
    {
      AppMethodBeat.o(283119);
      return paramca;
      if (ab.Lj(paramca.apJ()))
      {
        paramca = paramca.apJ();
        p.j(paramca, "msg.talker");
      }
      else
      {
        paramca = z.bcZ();
        p.j(paramca, "ConfigStorageLogic.getUsernameFromUserInfo()");
      }
    }
  }
  
  public static void aL(Context paramContext, String paramString)
  {
    AppMethodBeat.i(283104);
    p.k(paramContext, "context");
    p.k(paramString, "wording");
    w.a(paramContext, paramString, (w.b)t.AGF);
    AppMethodBeat.o(283104);
  }
  
  public static boolean aq(int paramInt, long paramLong)
  {
    AppMethodBeat.i(283153);
    if ((paramInt > 0) || ((paramLong != 0L) && (1000L * paramLong < cm.bfE())))
    {
      AppMethodBeat.o(283153);
      return true;
    }
    AppMethodBeat.o(283153);
    return false;
  }
  
  public static boolean ar(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(283059);
    p.k(paramContext, "context");
    if ((paramInt & 0x40) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.ui.widget.a.f.a locala = new com.tencent.mm.ui.widget.a.f.a(MMApplicationContext.getContext());
        locala.bBl(paramContext.getResources().getString(b.j.finder_message_profile_is_mute)).HL(true);
        locala.ayp(c.g.welcome_i_know).b((f.c)i.AGp).b((DialogInterface.OnDismissListener)j.AGq).show();
      }
      AppMethodBeat.o(283059);
      return bool;
    }
  }
  
  public static String b(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(283199);
    p.k(paramContext, "context");
    Calendar localCalendar = Calendar.getInstance();
    Object localObject = new Date(paramLong);
    p.j(localCalendar, "date");
    localCalendar.setTime((Date)localObject);
    int i = localCalendar.get(11);
    if (i < 10)
    {
      localObject = "0".concat(String.valueOf(i));
      i = localCalendar.get(12);
      if (i >= 10) {
        break label182;
      }
    }
    label182:
    for (String str = "0".concat(String.valueOf(i));; str = String.valueOf(i))
    {
      paramContext = paramContext.getResources().getString(b.j.finder_campaign_time_date, new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)), localObject, str });
      p.j(paramContext, "context.resources.getStr…      minuteStr\n        )");
      AppMethodBeat.o(283199);
      return paramContext;
      localObject = String.valueOf(i);
      break;
    }
  }
  
  public static void b(Window paramWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(283190);
    p.k(paramWindow, "window");
    ar.d(paramWindow, paramBoolean);
    ar.e(paramWindow, paramBoolean);
    AppMethodBeat.o(283190);
  }
  
  public static void b(final String paramString, bk parambk)
  {
    AppMethodBeat.i(283233);
    p.k(paramString, "source");
    com.tencent.e.h.ZvG.bf((Runnable)new k(parambk, paramString));
    AppMethodBeat.o(283233);
  }
  
  public static boolean b(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283060);
    p.k(paramImageView, "imageView");
    p.k(paramString, "path");
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
      AppMethodBeat.o(283060);
      return true;
    }
    AppMethodBeat.o(283060);
    return false;
  }
  
  public static boolean b(cvy paramcvy)
  {
    if (paramcvy == null) {}
    while ((paramcvy.permissionFlag & 0x1) != 0) {
      return false;
    }
    return true;
  }
  
  public static Bitmap c(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167968);
    p.k(paramInputStream, "inputStream");
    b.a locala = com.tencent.mm.plugin.gallery.picker.b.b.BXq;
    paramInputStream = b.a.a(paramInputStream, paramInt1, paramInt2, true, false);
    AppMethodBeat.o(167968);
    return paramInputStream;
  }
  
  public static boolean c(cvy paramcvy)
  {
    if (paramcvy == null) {}
    while ((paramcvy.permissionFlag & 0x2) != 0) {
      return false;
    }
    return true;
  }
  
  public static boolean d(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(283151);
    p.k(paramContext, "context");
    Log.e(TAG, "checkShowCgiErrorAlter: errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramContext = new com.tencent.mm.ui.widget.a.d.a(paramContext);
        paramContext.bBd(paramString);
        paramContext.HG(true);
        paramContext.ayj(b.j.app_ok);
        paramContext.show();
        AppMethodBeat.o(283151);
        return true;
      }
    }
    AppMethodBeat.o(283151);
    return false;
  }
  
  public static boolean d(cvy paramcvy)
  {
    if (paramcvy == null) {}
    while ((paramcvy.permissionFlag & 0x8) != 0) {
      return false;
    }
    return true;
  }
  
  public static boolean dOO()
  {
    AppMethodBeat.i(283089);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    if ((localf.aHp().getInt(ar.a.Vzn, 0) & 0x400) != 0)
    {
      AppMethodBeat.o(283089);
      return true;
    }
    AppMethodBeat.o(283089);
    return false;
  }
  
  public static boolean e(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(283053);
    int i = paramInt;
    if (paramInt == -1)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      i = ((Number)com.tencent.mm.plugin.finder.storage.d.dVe().aSr()).intValue();
    }
    if ((i == 2) && (paramFloat >= 1.316667F))
    {
      AppMethodBeat.o(283053);
      return true;
    }
    AppMethodBeat.o(283053);
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public static View.OnTouchListener eN(View paramView)
  {
    AppMethodBeat.i(283106);
    p.k(paramView, "tv");
    paramView = (View.OnTouchListener)new aj.m(paramView);
    AppMethodBeat.o(283106);
    return paramView;
  }
  
  public static void eO(View paramView)
  {
    AppMethodBeat.i(283126);
    if ((paramView != null) && (paramView.getVisibility() != 0)) {
      paramView.setVisibility(0);
    }
    AppMethodBeat.o(283126);
  }
  
  public static boolean eP(View paramView)
  {
    AppMethodBeat.i(283241);
    p.k(paramView, "view");
    if ((paramView.getVisibility() != 0) || (!paramView.isShown()))
    {
      AppMethodBeat.o(283241);
      return false;
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    int i = localRect.width();
    int j = paramView.getWidth();
    if (i * 1.0F / j >= 0.5F)
    {
      AppMethodBeat.o(283241);
      return true;
    }
    AppMethodBeat.o(283241);
    return false;
  }
  
  public static float eW(List<? extends csg> paramList)
  {
    AppMethodBeat.i(283192);
    p.k(paramList, "list");
    csg localcsg = (csg)kotlin.a.j.lo(paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localcsg;
    float f;
    if (localIterator.hasNext())
    {
      localcsg = (csg)localIterator.next();
      f = localcsg.height * 1.0F / localcsg.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label105;
      }
      paramList = localcsg;
    }
    label105:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(283192);
      return f;
    }
  }
  
  public static float eX(List<? extends bjc> paramList)
  {
    AppMethodBeat.i(283193);
    p.k(paramList, "list");
    bjc localbjc = (bjc)kotlin.a.j.lo(paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localbjc;
    float f;
    if (localIterator.hasNext())
    {
      localbjc = (bjc)localIterator.next();
      f = localbjc.height * 1.0F / localbjc.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label105;
      }
      paramList = localbjc;
    }
    label105:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(283193);
      return f;
    }
  }
  
  public static float eY(List<? extends cww> paramList)
  {
    AppMethodBeat.i(283194);
    p.k(paramList, "list");
    cww localcww = (cww)kotlin.a.j.lo(paramList);
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localcww;
    float f;
    if (localIterator.hasNext())
    {
      localcww = (cww)localIterator.next();
      f = localcww.height * 1.0F / localcww.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label105;
      }
      paramList = localcww;
    }
    label105:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(283194);
      return f;
    }
  }
  
  public static Set<Integer> edV()
  {
    return AFP;
  }
  
  public static Set<Integer> edW()
  {
    return AFQ;
  }
  
  public static int edX()
  {
    AppMethodBeat.i(293347);
    int i = (int)(cm.bfC() / 1000L);
    AppMethodBeat.o(293347);
    return i;
  }
  
  public static boolean edY()
  {
    AppMethodBeat.i(178458);
    if (!Util.isNullOrNil(z.bdh()))
    {
      AppMethodBeat.o(178458);
      return true;
    }
    AppMethodBeat.o(178458);
    return false;
  }
  
  public static String edZ()
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
  
  public static long eeb()
  {
    return xjA;
  }
  
  public static boolean eec()
  {
    AppMethodBeat.i(283088);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    if ((localf.aHp().getInt(ar.a.Vzn, 0) & 0x20) != 0)
    {
      AppMethodBeat.o(283088);
      return true;
    }
    AppMethodBeat.o(283088);
    return false;
  }
  
  public static boolean eed()
  {
    AppMethodBeat.i(283090);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    if ((localf.aHp().getInt(ar.a.Vzn, 0) & 0x40000) != 0)
    {
      AppMethodBeat.o(283090);
      return true;
    }
    AppMethodBeat.o(283090);
    return false;
  }
  
  public static boolean eee()
  {
    AppMethodBeat.i(283091);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    if ((localf.aHp().getInt(ar.a.Vzn, 0) & 0x2000) != 0)
    {
      AppMethodBeat.o(283091);
      return true;
    }
    AppMethodBeat.o(283091);
    return false;
  }
  
  public static JSONObject eef()
  {
    AppMethodBeat.i(283112);
    if (AFS == null)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("screenwidth", com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()));
      ((JSONObject)localObject).put("screenheight", com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()));
      AFS = (JSONObject)localObject;
    }
    JSONObject localJSONObject = AFS;
    Object localObject = localJSONObject;
    if (localJSONObject == null) {
      localObject = new JSONObject();
    }
    AppMethodBeat.o(283112);
    return localObject;
  }
  
  public static void eeg()
  {
    AppMethodBeat.i(283121);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBd, "");
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBe, "");
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBf, "");
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBg, "");
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBh, "");
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBj, Integer.valueOf(0));
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBk, Integer.valueOf(0));
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBl, Integer.valueOf(0));
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBm, Integer.valueOf(0));
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBn, Integer.valueOf(0));
    AppMethodBeat.o(283121);
  }
  
  public static void eeh()
  {
    AppMethodBeat.i(283124);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBa, "");
    localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBi, Integer.valueOf(0));
    AppMethodBeat.o(283124);
  }
  
  public static int eei()
  {
    boolean bool3 = true;
    int j = 1;
    AppMethodBeat.i(283152);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.dUC().aSr()).intValue();
    if (i != -1)
    {
      Log.d(TAG, "harcode user state = ".concat(String.valueOf(i)));
      AppMethodBeat.o(283152);
      return i;
    }
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    boolean bool1;
    label129:
    boolean bool2;
    if ((((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VyF, 0) & 0x2) != 0)
    {
      bool1 = true;
      boolean bool4 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).showPostEntry();
      localObject = (CharSequence)z.bdh();
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
      AppMethodBeat.o(283152);
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
        localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject = com.tencent.mm.plugin.finder.api.d.a.aAK(z.bdh());
        if (localObject == null) {
          p.iCn();
        }
        bool2 = ((com.tencent.mm.plugin.finder.api.i)localObject).isBlock();
        localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject = com.tencent.mm.plugin.finder.api.d.a.aAK(z.bdh());
        if (localObject == null) {
          p.iCn();
        }
        if (((com.tencent.mm.plugin.finder.api.i)localObject).field_spamStatus == 2) {}
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
  
  public static boolean eej()
  {
    AppMethodBeat.i(283158);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(283158);
      return true;
    }
    AppMethodBeat.o(283158);
    return false;
  }
  
  public static String eek()
  {
    AppMethodBeat.i(283159);
    if (eej())
    {
      String str = Util.getStack().toString();
      p.j(str, "Util.getStack().toString()");
      AppMethodBeat.o(283159);
      return str;
    }
    AppMethodBeat.o(283159);
    return "";
  }
  
  public static long eel()
  {
    AppMethodBeat.i(283165);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.imd().aSr()).intValue() == 1)
    {
      l = System.currentTimeMillis();
      AppMethodBeat.o(283165);
      return l;
    }
    long l = cm.bfE();
    AppMethodBeat.o(283165);
    return l;
  }
  
  public static void een()
  {
    AFT = true;
  }
  
  public static int eeo()
  {
    return AFV;
  }
  
  public static void eep()
  {
    AppMethodBeat.i(283178);
    if (AFT)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AFU = ((Number)com.tencent.mm.plugin.finder.storage.d.dWC().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AFV = ((Number)com.tencent.mm.plugin.finder.storage.d.dWD().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AFW = ((Number)com.tencent.mm.plugin.finder.storage.d.dWE().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AFX = ((Number)com.tencent.mm.plugin.finder.storage.d.dWF().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AFY = ((Number)com.tencent.mm.plugin.finder.storage.d.dWH().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AFZ = ((Number)com.tencent.mm.plugin.finder.storage.d.dWG().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AGa = ((Number)com.tencent.mm.plugin.finder.storage.d.dWI().aSr()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.AjH;
      AGb = ((Number)com.tencent.mm.plugin.finder.storage.d.dWJ().aSr()).intValue();
      AFT = false;
      Log.i(TAG, "[checkResetFullScreenConfig] reset config GLOBAL=" + AFU + " HOT=" + AFV + ' ' + "FOLLOW=" + AFW + " FRIEND=" + AFX + ' ' + "SHARE=" + AFY + " OTHER=" + AFZ);
      Log.i(TAG, "[checkResetFullScreenConfig] reset config DISABLE_HALF_SCREEN=" + AGa + ' ' + "ALLOW_FILLING_FULL_SCREEN_VALUE=" + AGb);
    }
    AppMethodBeat.o(283178);
  }
  
  public static boolean eeq()
  {
    AppMethodBeat.i(283191);
    long l = System.nanoTime();
    if ((ar.hIH()) || (ar.hIM())) {}
    for (boolean bool = true;; bool = false)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "[isFoldableDeviceOrInMagicWindowMode] cost=" + (System.nanoTime() - l) + "ns");
      }
      AppMethodBeat.o(283191);
      return bool;
    }
  }
  
  private static void eer()
  {
    AppMethodBeat.i(283210);
    com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 200L, 1L);
    com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.vtq;
    boolean bool = com.tencent.mm.plugin.expansions.d.avY("pag");
    Log.i(TAG, "loadPagLib result:".concat(String.valueOf(bool)));
    com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 201L, 1L);
    AppMethodBeat.o(283210);
  }
  
  public static boolean ees()
  {
    AppMethodBeat.i(283212);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    if (!((Boolean)com.tencent.c.a.a.a.a.a.ilE().aSr()).booleanValue())
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBX, Boolean.FALSE);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(283212);
        throw ((Throwable)localObject);
      }
      if (((Boolean)localObject).booleanValue())
      {
        AppMethodBeat.o(283212);
        return true;
      }
    }
    AppMethodBeat.o(283212);
    return false;
  }
  
  public static String eet()
  {
    AppMethodBeat.i(283216);
    String str = MD5Util.getMD5String(z.bcZ() + System.currentTimeMillis());
    p.j(str, "MD5Util.getMD5String(\"${…em.currentTimeMillis()}\")");
    AppMethodBeat.o(283216);
    return str;
  }
  
  public static boolean eeu()
  {
    AppMethodBeat.i(283220);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    if (!((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VCp, false))
    {
      localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.dXw().aSr()).booleanValue()) {}
    }
    else
    {
      AppMethodBeat.o(283220);
      return true;
    }
    AppMethodBeat.o(283220);
    return false;
  }
  
  public static boolean eev()
  {
    AppMethodBeat.i(283224);
    boolean bool = ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).showFinderEntry();
    int i;
    if ((z.bde() & 0x0) == 0L)
    {
      i = 1;
      com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
      if ((!((com.tencent.mm.plugin.teenmode.a.b)locala).ZM()) || (((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).dYS() != 2)) {
        break label106;
      }
    }
    label106:
    for (int j = 1;; j = 0)
    {
      if ((!bool) || (i == 0) || (j != 0)) {
        break label111;
      }
      AppMethodBeat.o(283224);
      return true;
      i = 0;
      break;
    }
    label111:
    AppMethodBeat.o(283224);
    return false;
  }
  
  public static boolean eew()
  {
    AppMethodBeat.i(283226);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    boolean bool = com.tencent.mm.ae.d.dr(localf.aHp().getInt(ar.a.VyF, 0), 4);
    if (eej()) {
      Log.i(TAG, "[checkBindPhone] ".concat(String.valueOf(bool)));
    }
    AppMethodBeat.o(283226);
    return bool;
  }
  
  public static String eex()
  {
    AppMethodBeat.i(283230);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    switch (((com.tencent.mm.kernel.f)localObject).aHp().getInt(ar.a.VyS, 1))
    {
    default: 
      localObject = z.bcZ();
      p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(283230);
      return localObject;
    case 1: 
      localObject = z.bcZ();
      p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
      AppMethodBeat.o(283230);
      return localObject;
    case 2: 
      localObject = z.bdi();
      p.j(localObject, "ConfigStorageLogic.getMyFinderAliasUsername()");
      AppMethodBeat.o(283230);
      return localObject;
    }
    localObject = z.bdh();
    p.j(localObject, "ConfigStorageLogic.getMyFinderUsername()");
    AppMethodBeat.o(283230);
    return localObject;
  }
  
  public static int eey()
  {
    AppMethodBeat.i(283236);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    switch (localf.aHp().getInt(ar.a.VyS, 1))
    {
    default: 
      AppMethodBeat.o(283236);
      return 2;
    case 1: 
      AppMethodBeat.o(283236);
      return 2;
    case 2: 
      AppMethodBeat.o(283236);
      return 3;
    }
    AppMethodBeat.o(283236);
    return 1;
  }
  
  public static void eez()
  {
    boolean bool2 = true;
    AppMethodBeat.i(283237);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    boolean bool1 = ((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.Vzb, false);
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    boolean bool3 = ((Boolean)com.tencent.mm.plugin.finder.storage.d.dXJ().aSr()).booleanValue();
    Log.i(TAG, "[checkOldSessionInfo] hasTrans:" + bool1 + " , ignoreHasTrans:" + bool3);
    final aa.a locala;
    com.tencent.mm.plugin.findersdk.b localb;
    if ((!bool1) || (bool3))
    {
      Log.i(TAG, "[checkOldSessionInfo] begin");
      long l = SystemClock.uptimeMillis();
      localObject = new aa.a();
      ((aa.a)localObject).aaBx = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage().bvP();
      locala = new aa.a();
      locala.aaBx = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage().bvQ();
      l = SystemClock.uptimeMillis() - l;
      Log.i(TAG, "[checkOldSessionInfo] end,duration = ".concat(String.valueOf(l)));
      localb = com.tencent.mm.plugin.findersdk.b.BuZ;
      if (l <= 10000L) {
        break label320;
      }
      bool1 = true;
      com.tencent.mm.ae.f.a.a(localb, "transOldFinderMsgSessionInfo", bool1, (kotlin.g.a.a)new v(l));
      localb = com.tencent.mm.plugin.findersdk.b.BuZ;
      if ((!((aa.a)localObject).aaBx) || (!locala.aaBx)) {
        break label325;
      }
    }
    label320:
    label325:
    for (bool1 = bool2;; bool1 = false)
    {
      com.tencent.mm.ae.f.a.a(localb, "transOldFinderMsgSessionInfo-result", bool1, false, (kotlin.g.a.a)new w((aa.a)localObject, locala), 12);
      if ((((aa.a)localObject).aaBx) && (locala.aaBx))
      {
        localObject = com.tencent.mm.kernel.h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vzb, Boolean.TRUE);
      }
      AppMethodBeat.o(283237);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static String el(String paramString, int paramInt)
  {
    AppMethodBeat.i(167962);
    p.k(paramString, "key");
    paramString = MMApplicationContext.getContext().getString(paramInt);
    p.j(paramString, "MMApplicationContext.getContext().getString(resId)");
    AppMethodBeat.o(167962);
    return paramString;
  }
  
  public static void em(String paramString, int paramInt)
  {
    AppMethodBeat.i(283195);
    p.k(paramString, "logPrefix");
    if (eej())
    {
      paramString = (Throwable)new RuntimeException(paramString + " type:" + paramInt + " invalid");
      AppMethodBeat.o(283195);
      throw paramString;
    }
    Log.printInfoStack(TAG, paramString + " type:" + paramInt + " invalid", new Object[0]);
    AppMethodBeat.o(283195);
  }
  
  public static int f(int paramInt1, int paramInt2, float paramFloat)
  {
    int i = 255;
    AppMethodBeat.i(283177);
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
      paramInt1 = Color.argb(Math.min(kotlin.h.a.dm((0.5F - paramFloat) * 255.0F * 2.0F), i), paramInt2, j, paramInt1);
      AppMethodBeat.o(283177);
      return paramInt1;
      paramInt1 = Color.alpha(paramInt2);
      if (paramInt1 == 0) {}
      for (;;)
      {
        paramInt1 = Color.red(paramInt2);
        j = Color.green(paramInt2);
        paramInt2 = Color.blue(paramInt2);
        paramInt1 = Color.argb(Math.min(kotlin.h.a.dm((paramFloat - 0.5F) * 255.0F * 2.0F), i), paramInt1, j, paramInt2);
        AppMethodBeat.o(283177);
        return paramInt1;
        i = paramInt1;
      }
      label141:
      i = paramInt2;
    }
  }
  
  public static r<Integer, Integer, Integer> f(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(283050);
    p.k(paramView, "parent");
    int k = ImageView.ScaleType.CENTER_CROP.ordinal();
    float f1 = paramView.getHeight();
    float f2 = paramView.getWidth();
    if (paramFloat2 / paramFloat1 > f1 / f2) {}
    for (int i = (int)f1;; i = (int)(paramFloat2 * f2 / paramFloat1))
    {
      int j = (int)f2;
      if ((int)f1 == i) {
        j = (int)(paramFloat1 * f1 / paramFloat2);
      }
      paramView = new r(Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i));
      AppMethodBeat.o(283050);
      return paramView;
    }
  }
  
  public static void fU(Context paramContext)
  {
    AppMethodBeat.i(283087);
    p.k(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=page/agreement/finder_live_user_event");
    com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(283087);
  }
  
  public static r<Integer, Integer, Integer> g(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = 0.5625F;
    AppMethodBeat.i(283049);
    p.k(paramContext, "context");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ((Activity)paramContext).getBaseContext();
    }
    p.j(localContext, "baseContext");
    paramContext = localContext.getResources();
    p.j(paramContext, "baseContext.resources");
    int i = paramContext.getDisplayMetrics().widthPixels;
    paramContext = localContext.getResources();
    p.j(paramContext, "baseContext.resources");
    i = kotlin.k.i.ow(i, paramContext.getDisplayMetrics().heightPixels);
    float f1 = paramInt2 * 1.0F / paramInt1;
    int j = ImageView.ScaleType.CENTER_CROP.ordinal();
    if (Math.abs(paramInt1 - paramInt2) <= 10)
    {
      paramInt1 = i;
      paramContext = new r(Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1));
      AppMethodBeat.o(283049);
      return paramContext;
    }
    if (f1 < 0.5625F) {}
    for (f1 = f2;; f1 = 1.316667F) {
      do
      {
        paramInt1 = (int)(f1 * i);
        break;
      } while ((f1 < 1.0F) || (f1 < 1.316667F));
    }
  }
  
  public static boolean g(csg paramcsg)
  {
    if (paramcsg != null) {
      paramcsg = paramcsg.TpG;
    }
    return (paramcsg == null) || (paramcsg.Sox != true);
  }
  
  private static int getTopBarHeight()
  {
    AppMethodBeat.i(283071);
    int i = ((Number)xju.getValue()).intValue();
    AppMethodBeat.o(283071);
    return i;
  }
  
  public static int h(csg paramcsg)
  {
    int i = 1;
    if ((paramcsg != null) && (paramcsg.mediaType == 9)) {
      i = 2;
    }
    do
    {
      return i;
      if (paramcsg == null) {
        break;
      }
      paramcsg = paramcsg.TpG;
    } while ((paramcsg != null) && (paramcsg.Sox == true));
    return 0;
  }
  
  public static r<Integer, Integer, Integer> ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283052);
    float f = 1.0F * paramInt2 / paramInt1;
    r localr = new r(Integer.valueOf(ImageView.ScaleType.FIT_XY.ordinal()), Integer.valueOf(AFO), Integer.valueOf((int)(f * AFO)));
    AppMethodBeat.o(283052);
    return localr;
  }
  
  public static boolean hb(int paramInt1, int paramInt2)
  {
    return (paramInt2 == -4012) && (paramInt1 == 4);
  }
  
  public static int hc(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return (int)(100.0F * paramInt1 / paramInt2);
    }
    return 0;
  }
  
  public static boolean hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283186);
    eep();
    if ((AFU == 1) || (paramInt1 == 10) || ((AFV == 1) && (paramInt1 == 4)) || ((AFV == 1) && (paramInt2 == 20)) || ((AFW == 1) && (paramInt1 == 3)) || ((AFW == 1) && (paramInt2 == 17)) || ((AFX == 1) && (paramInt1 == 1)) || ((AFX == 1) && (paramInt2 == 18)) || ((AFY == 1) && (paramInt1 == 5)) || ((AFY == 1) && (paramInt1 == 6)) || ((AFY == 1) && (paramInt2 == 39)) || ((AFY == 1) && (paramInt2 == 38)) || ((AFY == 1) && (paramInt2 == 25)) || ((isOtherEnableFullScreenEnjoy()) && (paramInt1 != 4) && (paramInt1 != 3) && (paramInt1 != 1) && (paramInt1 != 5) && (paramInt1 != 6) && (paramInt2 != 20) && (paramInt2 != 17) && (paramInt2 != 18) && (paramInt2 != 39) && (paramInt2 != 38) && (paramInt2 != 25)))
    {
      AppMethodBeat.o(283186);
      return true;
    }
    AppMethodBeat.o(283186);
    return false;
  }
  
  public static String hs(String paramString1, String paramString2)
  {
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
    com.tencent.mm.plugin.finder.api.d.a locala = com.tencent.mm.plugin.finder.api.d.wZQ;
    boolean bool;
    if (paramString1 != null)
    {
      bool = kotlin.n.n.pu(paramString1, "@finder");
      if (!bool) {
        break label138;
      }
      if (Util.isNullOrNil(paramString2)) {
        break label103;
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      label77:
      p.j(localStringBuffer.append("displayName is is finder contact"), "buf.append(\"displayName is is finder contact\")");
    }
    for (;;)
    {
      AppMethodBeat.o(167950);
      return paramString1;
      bool = false;
      break;
      label103:
      paramString2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      if (paramString1 == null) {
        p.iCn();
      }
      paramString1 = com.tencent.mm.plugin.finder.api.d.a.aAK(paramString1);
      if (paramString1 != null)
      {
        paramString1 = paramString1.getNickname();
        break label77;
      }
      paramString1 = "";
      break label77;
      label138:
      paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString1);
      p.j(paramString1, "ct");
      if ((paramString1.ayq() != 0) && (!Util.isNullOrNil(paramString1.ays())))
      {
        paramString1 = paramString1.ays();
        p.j(paramString1, "ct.displayRemark");
        p.j(localStringBuffer.append("displayName is ".concat(String.valueOf(paramString1))), "buf.append(\"displayName is $displayName\")");
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
        p.j(paramString1, "ct.getUsername()");
      }
    }
  }
  
  public static String hu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167969);
    if (!Util.isNullOrNil(new String[] { paramString1, paramString2 }))
    {
      paramString1 = MMApplicationContext.getResources().getString(b.j.finder_location_poi, new Object[] { paramString1, paramString2 });
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
  
  public static String hv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(283083);
    if (Util.isNullOrNil(paramString1))
    {
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(283083);
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
      paramString1 = hs(str, paramString1);
    }
    AppMethodBeat.o(283083);
    return paramString1;
  }
  
  public static boolean i(csg paramcsg)
  {
    AppMethodBeat.i(283108);
    p.k(paramcsg, "localFinderMedia");
    if ((paramcsg.TzU) && (paramcsg.zBo != null))
    {
      AppMethodBeat.o(283108);
      return true;
    }
    AppMethodBeat.o(283108);
    return false;
  }
  
  public static boolean isAllEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(283183);
    eep();
    if ((AFU == 1) || ((AFV == 1) && (AFW == 1) && (AFX == 1) && (AFY == 1) && (AFZ == 1)))
    {
      AppMethodBeat.o(283183);
      return true;
    }
    AppMethodBeat.o(283183);
    return false;
  }
  
  public static boolean isAllHomeTabEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(283181);
    eep();
    if ((AFU == 1) || ((AFV == 1) && (AFW == 1) && (AFX == 1)))
    {
      AppMethodBeat.o(283181);
      return true;
    }
    AppMethodBeat.o(283181);
    return false;
  }
  
  public static boolean isAnyEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(283182);
    eep();
    if ((AFU == 1) || (AFV == 1) || (AFW == 1) || (AFX == 1) || (AFY == 1) || (AFZ == 1))
    {
      AppMethodBeat.o(283182);
      return true;
    }
    AppMethodBeat.o(283182);
    return false;
  }
  
  public static boolean isAnyHomeTabEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(283179);
    eep();
    if ((AFU == 1) || (AFZ == 1) || (AFV == 1) || (AFW == 1) || (AFX == 1))
    {
      AppMethodBeat.o(283179);
      return true;
    }
    AppMethodBeat.o(283179);
    return false;
  }
  
  public static boolean isDisablePostHalfScreen()
  {
    AppMethodBeat.i(283185);
    eep();
    if ((AGa == 1) && (isAllEnableFullScreenEnjoy()))
    {
      AppMethodBeat.o(283185);
      return true;
    }
    AppMethodBeat.o(283185);
    return false;
  }
  
  public static boolean isFastClick()
  {
    AppMethodBeat.i(283206);
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l - lastClickTime >= 500L) {
      bool = false;
    }
    lastClickTime = l;
    AppMethodBeat.o(283206);
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
    if ((!kotlin.n.n.pu(paramString, "@stranger")) && (!as.bvP(paramString)) && ((p.h(paramString, z.bcZ()) ^ true)) && (ab.Ql(paramString)))
    {
      AppMethodBeat.o(167952);
      return true;
    }
    AppMethodBeat.o(167952);
    return false;
  }
  
  public static boolean isOtherEnableFullScreenEnjoy()
  {
    AppMethodBeat.i(283184);
    eep();
    if ((AFU == 1) || (AFZ == 1))
    {
      AppMethodBeat.o(283184);
      return true;
    }
    AppMethodBeat.o(283184);
    return false;
  }
  
  public static com.tencent.mm.cd.b j(com.tencent.mm.cd.a parama)
  {
    AppMethodBeat.i(283167);
    p.k(parama, "$this$toByteString");
    parama = parama.toByteArray();
    if (parama != null)
    {
      parama = new com.tencent.mm.cd.b(parama);
      AppMethodBeat.o(283167);
      return parama;
    }
    AppMethodBeat.o(283167);
    return null;
  }
  
  public static boolean j(com.tencent.mm.plugin.finder.api.i parami)
  {
    AppMethodBeat.i(283094);
    if (parami != null) {}
    for (String str = parami.getUsername(); p.h(str, z.bdh()); str = null)
    {
      boolean bool = dOO();
      AppMethodBeat.o(283094);
      return bool;
    }
    if (parami != null) {}
    for (int i = parami.field_extFlag; (i & 0x400) != 0; i = 0)
    {
      AppMethodBeat.o(283094);
      return true;
    }
    AppMethodBeat.o(283094);
    return false;
  }
  
  public static boolean j(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167956);
    p.k(paramBaseFinderFeed, "feed");
    paramBaseFinderFeed = paramBaseFinderFeed.contact;
    if (!Util.isNullOrNil(z.bdh()))
    {
      if (paramBaseFinderFeed != null) {}
      for (paramBaseFinderFeed = paramBaseFinderFeed.field_username; kotlin.n.n.L(paramBaseFinderFeed, z.bdh(), false); paramBaseFinderFeed = null)
      {
        AppMethodBeat.o(167956);
        return true;
      }
    }
    AppMethodBeat.o(167956);
    return false;
  }
  
  public static boolean k(com.tencent.mm.plugin.finder.api.i parami)
  {
    return (parami != null) && ((parami.field_extFlag & 0x4000) != 0);
  }
  
  public static void o(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(167955);
    p.k(paramList, "list");
    p.k(paramString, "tag");
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
  
  public static bu q(int paramInt, List<? extends bu> paramList)
  {
    AppMethodBeat.i(283143);
    p.k(paramList, "feedList");
    if ((paramInt >= 0) && (paramInt < paramList.size()))
    {
      paramList = (bu)paramList.get(paramInt);
      AppMethodBeat.o(283143);
      return paramList;
    }
    AppMethodBeat.o(283143);
    return null;
  }
  
  public static String r(Boolean paramBoolean)
  {
    AppMethodBeat.i(283238);
    ArrayList localArrayList = new ArrayList((Collection)kotlin.a.j.listOf(new String[] { z.bcZ(), z.bdi() }));
    Object localObject1 = "(";
    Object localObject3 = (Iterable)localArrayList;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    label136:
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      String str = (String)localObject4;
      p.j(str, "it");
      if (((CharSequence)str).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label136;
        }
        ((Collection)localObject2).add(localObject4);
        break;
      }
    }
    localObject3 = ((Iterable)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((Iterator)localObject3).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (String)localObject2;
      localObject2 = (String)localObject1 + "senderUserName = '" + (String)localObject2 + '\'';
      localObject1 = localObject2;
      if (i + 1 < localArrayList.size()) {
        localObject1 = (String)localObject2 + " or ";
      }
      i += 1;
    }
    localObject1 = kotlin.n.n.c((String)localObject1, (CharSequence)" or ");
    localObject1 = new StringBuilder().append((String)localObject1).append(" or senderUserNameVersion = ");
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().getInt(ar.a.Vzd, 0);
    localObject1 = localObject2;
    if (p.h(paramBoolean, Boolean.TRUE)) {
      localObject1 = (String)localObject2 + " or talker = 'finderaliassessionholder' or talker = 'findersayhisessionholder'";
    }
    paramBoolean = (String)localObject1 + ")";
    AppMethodBeat.o(283238);
    return paramBoolean;
  }
  
  public static JSONArray r(RecyclerView paramRecyclerView)
  {
    int k = 0;
    AppMethodBeat.i(283111);
    p.k(paramRecyclerView, "recyclerView");
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
      AppMethodBeat.o(283111);
      throw paramRecyclerView;
    }
    Object localObject2 = (StaggeredGridLayoutManager)localObject1;
    localObject1 = ((StaggeredGridLayoutManager)localObject2).k(null);
    localObject2 = ((StaggeredGridLayoutManager)localObject2).l(null);
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
        ((JSONObject)localObject2).put("feedid", com.tencent.mm.ae.d.Fw(((com.tencent.mm.plugin.finder.event.base.g)localObject3).xrd.mf()));
        ((JSONObject)localObject2).put("feedindex", ((com.tencent.mm.plugin.finder.event.base.g)localObject3).xre);
        localObject3 = ((com.tencent.mm.plugin.finder.event.base.g)localObject3).xrf;
        if (localObject3 != null)
        {
          ((JSONObject)localObject2).put("x", ((com.tencent.mm.view.recyclerview.j)localObject3).Gqn + 1);
          ((JSONObject)localObject2).put("width", ((com.tencent.mm.view.recyclerview.j)localObject3).width);
          ((JSONObject)localObject2).put("height", ((com.tencent.mm.view.recyclerview.j)localObject3).height);
        }
        paramRecyclerView.put(localObject2);
      }
      i = 0;
      break;
      j = 0;
      break label88;
    }
    AppMethodBeat.o(283111);
    return paramRecyclerView;
  }
  
  public static boolean s(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(283242);
    p.k(paramRecyclerView, "recyclerView");
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    label81:
    int i;
    int j;
    if (localLayoutManager != null)
    {
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        if (localLayoutManager == null) {
          break label139;
        }
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {
          break label139;
        }
        if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
          break label81;
        }
      }
      for (;;)
      {
        if (paramRecyclerView != null)
        {
          if (localLayoutManager == null)
          {
            paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(283242);
            throw paramRecyclerView;
            localLayoutManager = null;
            break;
            paramRecyclerView = null;
            continue;
          }
          i = ((LinearLayoutManager)localLayoutManager).kJ();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
            AppMethodBeat.o(283242);
            throw paramRecyclerView;
          }
          paramRecyclerView = (List)((WxRecyclerAdapter)paramRecyclerView).data;
          j = paramRecyclerView.size();
          if (i >= 0) {
            break label147;
          }
        }
      }
    }
    label139:
    label147:
    while ((j <= i) || (!(paramRecyclerView.get(i) instanceof com.tencent.mm.plugin.finder.model.x)))
    {
      AppMethodBeat.o(283242);
      return false;
    }
    AppMethodBeat.o(283242);
    return true;
  }
  
  public static List<BaseFinderFeed> t(List<? extends BaseFinderFeed> paramList, int paramInt)
  {
    AppMethodBeat.i(283214);
    p.k(paramList, "cacheDataList");
    List localList = (List)new ArrayList();
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.f.class);
    p.j(localObject1, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
    localObject1 = (com.tencent.mm.plugin.finder.viewmodel.f)localObject1;
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
          kotlin.a.j.iBO();
        }
        localObject2 = (BaseFinderFeed)localObject2;
        if (i < 2) {
          break label185;
        }
        e.a locala = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        if (!e.a.ao(paramInt, ((BaseFinderFeed)localObject2).feedObject.field_id))
        {
          if ((((BaseFinderFeed)localObject2).feedObject.field_id != 0L) && (!((com.tencent.mm.plugin.finder.viewmodel.f)localObject1).as(paramInt, ((BaseFinderFeed)localObject2).feedObject.field_id))) {
            localList.add(localObject2);
          }
          i = j;
          continue;
        }
      }
      AppMethodBeat.o(283214);
      return localList;
      label185:
      i = j;
    }
  }
  
  public static boolean t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(283243);
    p.k(paramRecyclerView, "recyclerView");
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager != null)
    {
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        if (localLayoutManager == null) {
          break label198;
        }
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {
          break label198;
        }
        if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
          break label87;
        }
      }
      for (;;)
      {
        if (paramRecyclerView != null)
        {
          if (localLayoutManager == null)
          {
            paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            AppMethodBeat.o(283243);
            throw paramRecyclerView;
            localLayoutManager = null;
            break;
            label87:
            paramRecyclerView = null;
            continue;
          }
          int i = ((LinearLayoutManager)localLayoutManager).kJ();
          int j = ((LinearLayoutManager)localLayoutManager).kL();
          if (paramRecyclerView == null)
          {
            paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
            AppMethodBeat.o(283243);
            throw paramRecyclerView;
          }
          paramRecyclerView = (List)((WxRecyclerAdapter)paramRecyclerView).data;
          int k = paramRecyclerView.size();
          if (i <= j)
          {
            if (i < 0) {}
            for (;;)
            {
              if (i != j)
              {
                i += 1;
                break;
                if ((k > i) && ((paramRecyclerView.get(i) instanceof com.tencent.mm.plugin.finder.model.x)))
                {
                  AppMethodBeat.o(283243);
                  return true;
                }
              }
            }
          }
        }
      }
    }
    label198:
    AppMethodBeat.o(283243);
    return false;
  }
  
  public static bge u(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167959);
    p.k(paramBaseFinderFeed, "feed");
    bge localbge = new bge();
    localbge.refObjectFlag = 1L;
    if (paramBaseFinderFeed.feedObject.getRefObjectFlag() == 1L) {
      localbge.refObjectId = paramBaseFinderFeed.feedObject.getRefObjectId();
    }
    for (localbge.refObjectContact = paramBaseFinderFeed.feedObject.getRefObjectContact();; localbge.refObjectContact = com.tencent.mm.plugin.finder.api.c.a(paramBaseFinderFeed))
    {
      AppMethodBeat.o(167959);
      return localbge;
      localbge.refObjectId = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      if (paramBaseFinderFeed == null) {
        p.iCn();
      }
    }
  }
  
  public static void u(TextView paramTextView)
  {
    AppMethodBeat.i(283172);
    p.k(paramTextView, "tv");
    try
    {
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      paramTextView.setTypeface(Typeface.createFromAsset(localContext.getAssets(), "fonts/WeChatSansStd-Medium.ttf"));
      AppMethodBeat.o(283172);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e(TAG, "setTypeface() Exception:" + paramTextView.getMessage());
      AppMethodBeat.o(283172);
    }
  }
  
  public static boolean v(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(283128);
    p.k(paramBaseFinderFeed, "item");
    if ((paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount > 0) && (paramBaseFinderFeed.feedObject.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(283128);
      return true;
    }
    AppMethodBeat.o(283128);
    return false;
  }
  
  public static boolean w(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(283156);
    p.k(paramBaseFinderFeed, "item");
    if (paramBaseFinderFeed.feedObject.getMediaType() == 9)
    {
      AppMethodBeat.o(283156);
      return true;
    }
    AppMethodBeat.o(283156);
    return false;
  }
  
  public static boolean w(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167948);
    p.k(paramFinderObject, "obj");
    Object localObject = ak.AGL;
    localObject = ak.eeC();
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
      localObject = ak.AGL;
      if (ak.eeC().contains(Integer.valueOf(i))) {
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
  
  public static String x(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(283197);
    p.k(paramBaseFinderFeed, "feed");
    if (paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count > 1)
    {
      paramBaseFinderFeed = MMApplicationContext.getContext().getString(b.j.finder_feed_follow_pat_entrance_tips_with_count, new Object[] { Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count) });
      p.j(paramBaseFinderFeed, "MMApplicationContext.get…Object.follow_feed_count)");
      AppMethodBeat.o(283197);
      return paramBaseFinderFeed;
    }
    paramBaseFinderFeed = MMApplicationContext.getContext().getString(b.j.finder_feed_follow_pat_entrance_tips);
    p.j(paramBaseFinderFeed, "MMApplicationContext.get…follow_pat_entrance_tips)");
    AppMethodBeat.o(283197);
    return paramBaseFinderFeed;
  }
  
  public static ArrayList<List<String>> y(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(283169);
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 24)
    {
      localObject3 = Rl(i);
      localObject4 = MMApplicationContext.getContext();
      p.j(localObject4, "MMApplicationContext.getContext()");
      ((ArrayList)localObject2).add(((Context)localObject4).getResources().getString(paramInt2, new Object[] { localObject3 }));
      i += 1;
    }
    Object localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      Log.i("getNoticePicker", (String)((Iterator)localObject3).next());
    }
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      ((ArrayList)localObject1).add(localObject2);
      paramInt2 += 1;
    }
    localObject2 = ((ArrayList)localObject2).clone();
    if (localObject2 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
      AppMethodBeat.o(283169);
      throw ((Throwable)localObject1);
    }
    localObject2 = (ArrayList)localObject2;
    localObject3 = new Date(eel());
    Object localObject4 = Calendar.getInstance();
    p.j(localObject4, "date");
    ((Calendar)localObject4).setTime((Date)localObject3);
    paramInt2 = ((Calendar)localObject4).get(11);
    if (paramBoolean)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          ((ArrayList)localObject2).remove(0);
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
      ((ArrayList)localObject1).remove(0);
      if (!((Collection)localObject2).isEmpty())
      {
        paramInt1 = j;
        if (paramInt1 != 0) {
          ((ArrayList)localObject1).add(0, localObject2);
        }
      }
    }
    label384:
    for (;;)
    {
      AppMethodBeat.o(283169);
      return localObject1;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((ArrayList)localObject2).remove(0);
        paramInt1 += 1;
      }
      ((ArrayList)localObject1).remove(0);
      if (((Date)localObject3).getMinutes() >= 55) {
        ((ArrayList)localObject2).remove(0);
      }
      if (!((Collection)localObject2).isEmpty()) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label384;
        }
        ((ArrayList)localObject1).add(0, localObject2);
        break;
      }
    }
  }
  
  public static boolean y(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283095);
    p.k(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x1) == 0)
    {
      AppMethodBeat.o(283095);
      return true;
    }
    AppMethodBeat.o(283095);
    return false;
  }
  
  public static boolean z(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(283096);
    p.k(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x2) == 0)
    {
      AppMethodBeat.o(283096);
      return true;
    }
    AppMethodBeat.o(283096);
    return false;
  }
  
  public final r<ArrayList<String>, ArrayList<List<String>>, ArrayList<List<String>>> eem()
  {
    AppMethodBeat.i(283166);
    Object localObject2 = new Date(eel());
    Object localObject3 = Calendar.getInstance();
    Object localObject1 = new ArrayList();
    int i = 0;
    while (i < 30)
    {
      p.j(localObject3, "date");
      ((Calendar)localObject3).setTime((Date)localObject2);
      ((Calendar)localObject3).set(5, ((Calendar)localObject3).get(5) + i);
      int j = ((Calendar)localObject3).get(5);
      int k = ((Calendar)localObject3).get(2);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      ((ArrayList)localObject1).add(localContext.getResources().getString(b.j.finder_live_notice_date_format, new Object[] { Integer.valueOf(k + 1), Integer.valueOf(j) }));
      i += 1;
    }
    localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext()) {
      Log.i("getNoticePicker", (String)((Iterator)localObject3).next());
    }
    if ((((Date)localObject2).getHours() >= 23) && (((Date)localObject2).getMinutes() >= 55)) {
      ((ArrayList)localObject1).remove(0);
    }
    localObject2 = Rj(((ArrayList)localObject1).size());
    localObject1 = new r(localObject1, localObject2, Rk(((ArrayList)localObject1).size() * ((ArrayList)localObject2).size()));
    AppMethodBeat.o(283166);
    return localObject1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibilityFeed;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentVisiblityFeedList", "Ljava/util/LinkedList;", "getCurrentVisiblityFeedList", "()Ljava/util/LinkedList;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    public final LinkedList<a> AGd;
    public com.tencent.mm.view.recyclerview.i xhX;
    public bu xrd;
    
    public a(bu parambu, com.tencent.mm.view.recyclerview.i parami)
    {
      AppMethodBeat.i(268710);
      this.xrd = parambu;
      this.xhX = parami;
      this.AGd = new LinkedList();
      AppMethodBeat.o(268710);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(268713);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.xrd, paramObject.xrd)) || (!p.h(this.xhX, paramObject.xhX))) {}
        }
      }
      else
      {
        AppMethodBeat.o(268713);
        return true;
      }
      AppMethodBeat.o(268713);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(268712);
      Object localObject = this.xrd;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.xhX;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(268712);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(268709);
      StringBuilder localStringBuilder1 = new StringBuilder("VisibilityFeed:");
      Object localObject = (Iterable)this.AGd;
      int i = 0;
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject = (a)localObject;
        StringBuilder localStringBuilder2 = localStringBuilder1.append("[index:".concat(String.valueOf(i)));
        StringBuilder localStringBuilder3 = new StringBuilder("type:");
        localObject = ((a)localObject).xrd;
        if (localObject != null) {}
        for (localObject = Integer.valueOf(((bu)localObject).bAQ());; localObject = null)
        {
          localStringBuilder2.append(localObject + ']');
          i += 1;
          break;
        }
      }
      localObject = localStringBuilder1.toString();
      p.j(localObject, "sb.toString()");
      AppMethodBeat.o(268709);
      return localObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/utils/FinderUtil$calculateMediaLayoutParams$1$2"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    c(View paramView1, int paramInt, float paramFloat, View paramView2, String paramString, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(boolean paramBoolean, ble paramble, Context paramContext) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167933);
      com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
      if (this.AGl) {
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).reportPostRedDot(10);
      }
      for (;;)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("key_create_scene", 1);
        Object localObject = paramble;
        if (localObject != null) {
          paramDialogInterface.putExtra("key_prepare_resp", ((ble)localObject).toByteArray());
        }
        localObject = a.ACH;
        a.w(paramContext, paramDialogInterface);
        AppMethodBeat.o(167933);
        return;
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).reportPostRedDot(12);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167934);
      com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
      if (this.AGl) {
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.k.zWs;
        com.tencent.mm.plugin.finder.report.k.Pw(5);
        AppMethodBeat.o(167934);
        return;
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).reportPostRedDot(13);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(boolean paramBoolean) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(167936);
      com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
      if (this.AGl) {
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).reportPostRedDot(11);
      }
      for (;;)
      {
        paramDialogInterface = com.tencent.mm.plugin.finder.report.k.zWs;
        com.tencent.mm.plugin.finder.report.k.Pw(5);
        AppMethodBeat.o(167936);
        return;
        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).reportPostRedDot(13);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(Activity paramActivity) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167938);
      paramDialogInterface = a.ACH;
      a.as(this.otc);
      paramDialogInterface = this.AGo;
      if (paramDialogInterface != null) {
        paramDialogInterface.aH(Boolean.TRUE);
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.aw(7, false);
      AppMethodBeat.o(167938);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(280015);
      paramDialogInterface = this.AGo;
      if (paramDialogInterface != null) {
        paramDialogInterface.aH(Boolean.FALSE);
      }
      paramDialogInterface = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.aw(7, false);
      AppMethodBeat.o(280015);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class i
    implements f.c
  {
    public static final i AGp;
    
    static
    {
      AppMethodBeat.i(291495);
      AGp = new i();
      AppMethodBeat.o(291495);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class j
    implements DialogInterface.OnDismissListener
  {
    public static final j AGq;
    
    static
    {
      AppMethodBeat.i(287279);
      AGq = new j();
      AppMethodBeat.o(287279);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(bk parambk, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(289405);
      int i;
      for (;;)
      {
        try
        {
          if (this.AGr != null)
          {
            localObject1 = (CharSequence)this.AGr.field_username;
            if (localObject1 == null) {
              break label898;
            }
            if (((CharSequence)localObject1).length() != 0) {
              break label903;
            }
            break label898;
            if (i != 0)
            {
              localObject1 = aj.AGc;
              Log.i(aj.eeA(), "[delAliasInfo] source:" + paramString + " , deletingInfo empty");
              AppMethodBeat.o(289405);
              return;
            }
          }
          Object localObject1 = this.AGr;
          if (localObject1 == null) {
            break label287;
          }
          localObject1 = ((bk)localObject1).field_username;
          if (localObject1 == null) {
            break label287;
          }
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label287;
            }
            localObject3 = this.AGr.field_username;
            p.j(localObject3, "aliasUserName");
            if (((CharSequence)localObject3).length() != 0) {
              break label908;
            }
            i = 1;
            label151:
            if (i == 0) {
              break;
            }
            localObject1 = aj.AGc;
            Log.i(aj.eeA(), "[delAliasInfo] source:" + paramString + " ,aliasUserName empty return ");
            AppMethodBeat.o(289405);
            return;
          }
        }
        catch (Exception localException)
        {
          localObject3 = aj.AGc;
          Log.i(aj.eeA(), "[delAliasInfo]  exception:" + localException.getMessage());
          localObject3 = aj.AGc;
          Log.printErrStackTrace(aj.eeA(), (Throwable)localException, "", new Object[0]);
          com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "delAliasInfo", false, false, (kotlin.g.a.a)new kotlin.g.b.q(localException) {}, 12);
          localObject2 = (Throwable)localException;
          AppMethodBeat.o(289405);
          throw ((Throwable)localObject2);
        }
        i = 0;
        continue;
        label287:
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject3 = ((com.tencent.mm.kernel.f)localObject2).aHp().a(ar.a.Vyd, "");
      }
      Object localObject4 = this.AGr;
      Object localObject2 = localObject4;
      boolean bool;
      if (localObject4 == null)
      {
        localObject2 = new bk();
        ((bk)localObject2).field_username = ((String)localObject3);
        ((bk)localObject2).field_type = 2;
        bool = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().insert((IAutoDBItem)localObject2);
        localObject4 = aj.AGc;
        Log.i(aj.eeA(), "[delAliasInfo] insert DeletingInfo Result : ".concat(String.valueOf(bool)));
      }
      localObject4 = aj.AGc;
      Log.i(aj.eeA(), "[delAliasInfo] source:" + paramString + " ,aliasUserName:" + (String)localObject3);
      localObject4 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage();
      com.tencent.mm.plugin.finder.storage.f localf = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage();
      Object localObject5 = ((com.tencent.mm.plugin.finder.storage.af)localObject4).aEO((String)localObject3);
      if (localObject5 != null)
      {
        localObject5 = ((Iterable)localObject5).iterator();
        i = 0;
        while (((Iterator)localObject5).hasNext())
        {
          Object localObject6 = ((Iterator)localObject5).next();
          if (i < 0) {
            kotlin.a.j.iBO();
          }
          localObject6 = ((com.tencent.mm.plugin.finder.conv.l)localObject6).field_sessionId;
          p.j(localObject6, "it.field_sessionId");
          localObject6 = localf.aEG((String)localObject6);
          bool = localf.deleteNotify(((com.tencent.mm.plugin.finder.conv.d)localObject6).systemRowid, false);
          Object localObject7 = aj.AGc;
          Log.i(aj.eeA(), "delete conv begin[" + bool + "]... " + ((com.tencent.mm.plugin.finder.conv.d)localObject6).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId);
          if (bool) {
            bq.a(((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId, (bq.a)new a((com.tencent.mm.plugin.finder.conv.d)localObject6));
          }
          localObject7 = ((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId;
          p.j(localObject7, "conv.field_sessionId");
          ((com.tencent.mm.plugin.finder.storage.af)localObject4).aEQ((String)localObject7);
          localf.doNotify(((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId, 6, localObject6);
          localObject7 = aj.AGc;
          Log.i(aj.eeA(), "delete conv end... " + ((com.tencent.mm.plugin.finder.conv.d)localObject6).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId);
          i += 1;
        }
      }
      Object localObject3 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMsgAliasContactStorage().aAK((String)localObject3);
      if (localObject3 != null)
      {
        if (((com.tencent.mm.plugin.finder.api.i)localObject3).systemRowid == -1L) {
          break label887;
        }
        i = 1;
        break label913;
      }
      for (;;)
      {
        label752:
        if (localObject3 != null) {
          ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getMsgAliasContactStorage().delete(((com.tencent.mm.plugin.finder.api.i)localObject3).systemRowid);
        }
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vye, "");
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vyf, "");
        localObject3 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject3, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.Vyd, "");
        ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().delete((IAutoDBItem)localObject2, new String[] { "username" });
        AppMethodBeat.o(289405);
        return;
        label887:
        i = 0;
        label898:
        label903:
        label908:
        label913:
        while (i == 0)
        {
          localObject3 = null;
          break label752;
          i = 1;
          break;
          i = 0;
          break;
          i = 0;
          break label151;
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderUtil$delAliasInfo$1$2$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"})
    public static final class a
      implements bq.a
    {
      a(com.tencent.mm.plugin.finder.conv.d paramd) {}
      
      public final boolean asH()
      {
        return false;
      }
      
      public final void asI()
      {
        AppMethodBeat.i(271872);
        aj localaj = aj.AGc;
        Log.i(aj.eeA(), "delete msg end... " + this.xgp.nickname + ' ' + this.xgp.field_sessionId);
        AppMethodBeat.o(271872);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(bk parambk, String paramString) {}
    
    public final void run()
    {
      Object localObject4 = null;
      AppMethodBeat.i(289450);
      for (;;)
      {
        try
        {
          if (this.AGr != null)
          {
            localObject1 = (CharSequence)this.AGr.field_username;
            if (localObject1 == null) {
              break label1084;
            }
            if (((CharSequence)localObject1).length() != 0) {
              break label1089;
            }
            break label1084;
            if (i != 0)
            {
              localObject1 = aj.AGc;
              Log.i(aj.eeA(), "[deleteMyLocalAccountData] source:" + paramString + " , deletingInfo empty");
              AppMethodBeat.o(289450);
              return;
            }
          }
          Object localObject1 = this.AGr;
          if (localObject1 == null) {
            break label337;
          }
          localObject1 = ((bk)localObject1).field_username;
          if (localObject1 == null) {
            break label337;
          }
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            if (i != 1) {
              break label337;
            }
            localObject1 = this.AGr;
            if (localObject1 == null) {
              break label332;
            }
            localObject1 = ((bk)localObject1).field_username;
            localObject3 = aj.AGc;
            Log.i(aj.eeA(), "[deleteMyLocalAccountData] currentFinderUsername:" + (String)localObject1 + " , source:" + paramString);
            p.j(localObject1, "currentFinderUsername");
            if (((CharSequence)localObject1).length() != 0) {
              break label1094;
            }
            i = 1;
            if (i == 0) {
              break label389;
            }
            localObject1 = aj.AGc;
            Log.i(aj.eeA(), "[deleteMyLocalAccountData] source:" + paramString + " ,currentFinderUsername empty return ");
            AppMethodBeat.o(289450);
            return;
          }
        }
        catch (Exception localException)
        {
          localObject3 = aj.AGc;
          Log.i(aj.eeA(), "[deleteMyLocalAccountData]  exception:" + localException.getMessage());
          localObject3 = aj.AGc;
          Log.printErrStackTrace(aj.eeA(), (Throwable)localException, "", new Object[0]);
          com.tencent.mm.ae.f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "deleteMyLocalAccountData", false, false, (kotlin.g.a.a)new kotlin.g.b.q(localException) {}, 12);
          localObject2 = (Throwable)localException;
          AppMethodBeat.o(289450);
          throw ((Throwable)localObject2);
        }
        int i = 0;
        continue;
        label332:
        Object localObject2 = null;
        continue;
        label337:
        localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().get(ar.a.VxX, "");
        if (localObject2 == null)
        {
          localObject2 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(289450);
          throw ((Throwable)localObject2);
        }
        localObject2 = (String)localObject2;
        continue;
        label389:
        Object localObject5 = this.AGr;
        Object localObject3 = localObject5;
        if (localObject5 == null)
        {
          localObject3 = new bk();
          ((bk)localObject3).field_username = ((String)localObject2);
          ((bk)localObject3).field_type = 1;
          ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().insert((IAutoDBItem)localObject3);
        }
        localObject5 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getSessionInfoStorage();
        com.tencent.mm.plugin.finder.storage.f localf = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage();
        Object localObject6 = ((com.tencent.mm.plugin.finder.storage.af)localObject5).aEP((String)localObject2);
        Object localObject7 = aj.AGc;
        localObject7 = aj.eeA();
        StringBuilder localStringBuilder = new StringBuilder("[deleteMyLocalAccountData] sessionInfoList.size:");
        if (localObject6 != null) {
          localObject4 = Integer.valueOf(((LinkedList)localObject6).size());
        }
        Log.i((String)localObject7, localObject4);
        if (localObject6 != null)
        {
          localObject4 = ((Iterable)localObject6).iterator();
          i = 0;
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = ((Iterator)localObject4).next();
            if (i < 0) {
              kotlin.a.j.iBO();
            }
            localObject6 = ((com.tencent.mm.plugin.finder.conv.l)localObject6).field_sessionId;
            p.j(localObject6, "finderSessionInfo.field_sessionId");
            localObject6 = localf.aEG((String)localObject6);
            bool = localf.deleteNotify(((com.tencent.mm.plugin.finder.conv.d)localObject6).systemRowid, false);
            localObject7 = aj.AGc;
            Log.i(aj.eeA(), "[deleteMyLocalAccountData] delete conv begin[" + bool + "]... " + ((com.tencent.mm.plugin.finder.conv.d)localObject6).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId);
            if (bool) {
              bq.a(((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId, (bq.a)new a((com.tencent.mm.plugin.finder.conv.d)localObject6));
            }
            localObject7 = ((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId;
            p.j(localObject7, "conv.field_sessionId");
            ((com.tencent.mm.plugin.finder.storage.af)localObject5).aEQ((String)localObject7);
            ((com.tencent.mm.plugin.finder.storage.af)localObject5).doNotify(((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId, 6, localObject6);
            localObject7 = aj.AGc;
            Log.i(aj.eeA(), "[deleteMyLocalAccountData] delete conv end... " + ((com.tencent.mm.plugin.finder.conv.d)localObject6).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.d)localObject6).field_sessionId);
            i += 1;
          }
        }
        localObject4 = com.tencent.mm.plugin.finder.profile.uic.j.zSy;
        com.tencent.mm.plugin.finder.profile.uic.j.access$getUserExtInfoCache$cp().remove(localObject2);
        localObject4 = com.tencent.mm.plugin.finder.api.d.wZQ;
        p.k(localObject2, "username");
        Log.d(com.tencent.mm.plugin.finder.api.d.access$getTAG$cp(), "delete contact %s", new Object[] { localObject2 });
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject4 = com.tencent.mm.plugin.finder.api.d.dnh();
          p.k(localObject2, "key");
          ((com.tencent.mm.plugin.finder.api.b)localObject4).wZM.remove(localObject2);
          localObject4 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject4).bbL().aHy((String)localObject2);
          localObject2 = "DELETE FROM FinderContact WHERE username = " + com.tencent.mm.storagebase.h.Mi((String)localObject2);
          localObject4 = ((com.tencent.mm.plugin.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.b.class)).getContactStorage();
          if (localObject4 == null) {
            break label1079;
          }
        }
        label1079:
        for (boolean bool = ((com.tencent.mm.plugin.finder.storage.e)localObject4).execSQL("FinderContact", (String)localObject2);; bool = false)
        {
          Log.d(com.tencent.mm.plugin.finder.api.d.access$getTAG$cp(), "delete success %s", new Object[] { Boolean.valueOf(bool) });
          if ((bool) && (localObject4 != null)) {
            ((com.tencent.mm.plugin.finder.storage.e)localObject4).doNotify("FinderContact", 5, localObject4);
          }
          localObject2 = com.tencent.mm.plugin.finder.storage.data.k.Anu;
          k.a.dZz();
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.VxX, "");
          localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
          Log.i(com.tencent.mm.plugin.finder.api.d.access$getTAG$cp(), "[delFinderNameList]");
          localObject2 = com.tencent.mm.kernel.h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vzc, "");
          ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().delete((IAutoDBItem)localObject3, new String[] { "username" });
          AppMethodBeat.o(289450);
          return;
        }
        label1084:
        i = 1;
        continue;
        label1089:
        i = 0;
        continue;
        label1094:
        i = 0;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderUtil$deleteMyLocalAccountData$1$2$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"})
    public static final class a
      implements bq.a
    {
      a(com.tencent.mm.plugin.finder.conv.d paramd) {}
      
      public final boolean asH()
      {
        return false;
      }
      
      public final void asI()
      {
        AppMethodBeat.i(230135);
        aj localaj = aj.AGc;
        Log.i(aj.eeA(), "[deleteMyLocalAccountData] delete msg end... " + this.xgp.nickname + ' ' + this.xgp.field_sessionId);
        AppMethodBeat.o(230135);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/utils/FinderUtil$getVisibleFeedListByAdapterPosRange$1$1$1$2$1$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$1", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$2", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$3", "com/tencent/mm/plugin/finder/utils/FinderUtil$$special$$inlined$let$lambda$4"})
  static final class n
    implements Runnable
  {
    n(ViewParent paramViewParent, FinderFoldedScrollLayout paramFinderFoldedScrollLayout, com.tencent.mm.view.recyclerview.j paramj, com.tencent.mm.view.recyclerview.a parama, View paramView, com.tencent.mm.plugin.finder.event.base.g paramg, int paramInt, RecyclerView.a parama1, RecyclerView paramRecyclerView, Rect paramRect, aj.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(286764);
      localj.YSE = ((View)this.AGt).getTop();
      if (localj.YSD - localj.YSC - localj.YSB > localj.YSE)
      {
        if (!localj.YSF)
        {
          localj.YSF = true;
          Object localObject = localj.YSI;
          if (localObject != null)
          {
            localObject = (WxRecyclerAdapter)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((WxRecyclerAdapter)localObject).onResume();
              AppMethodBeat.o(286764);
              return;
            }
          }
          AppMethodBeat.o(286764);
        }
      }
      else if (localj.YSF)
      {
        localj.YSF = false;
        localj.YSG = true;
      }
      AppMethodBeat.o(286764);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    public static final o AGC;
    
    static
    {
      AppMethodBeat.i(291357);
      AGC = new o();
      AppMethodBeat.o(291357);
    }
    
    public final void run()
    {
      AppMethodBeat.i(291356);
      aj localaj = aj.AGc;
      aj.eeB();
      AppMethodBeat.o(291356);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToMachineTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class q
    extends ClickableSpan
  {
    q(kotlin.g.a.a parama, int paramInt, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(270219);
      p.k(paramView, "widget");
      paramView = this.xAe;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(270219);
        return;
      }
      AppMethodBeat.o(270219);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(270220);
      p.k(paramTextPaint, "ds");
      Context localContext;
      if (!aj.a(aj.AGc, paramInt, 0, 2))
      {
        localContext = paramTextView.getContext();
        p.j(localContext, "tv.context");
        paramTextPaint.setColor(localContext.getResources().getColor(b.c.Link_80));
      }
      for (;;)
      {
        paramTextPaint.setUnderlineText(false);
        paramTextPaint.clearShadowLayer();
        AppMethodBeat.o(270220);
        return;
        localContext = paramTextView.getContext();
        p.j(localContext, "tv.context");
        paramTextPaint.setColor(localContext.getResources().getColor(b.c.hot_tab_stream_link_color));
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToNearbyLiveMorePage$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class r
    extends ClickableSpan
  {
    r(kotlin.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242499);
      p.k(paramView, "widget");
      paramView = this.xAe;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(242499);
        return;
      }
      AppMethodBeat.o(242499);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(242500);
      p.k(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      p.j(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(b.c.Link_100));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(242500);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/utils/FinderUtil$setToTargetTab$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class s
    extends ClickableSpan
  {
    s(kotlin.g.a.a parama, TextView paramTextView, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290599);
      p.k(paramView, "widget");
      paramView = this.xAe;
      if (paramView != null)
      {
        paramView.invoke();
        AppMethodBeat.o(290599);
        return;
      }
      AppMethodBeat.o(290599);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(290600);
      p.k(paramTextPaint, "ds");
      Object localObject = paramTextView.getContext();
      p.j(localObject, "tv.context");
      localObject = ((Context)localObject).getResources();
      if (paramBoolean) {}
      for (int i = b.c.Link_100_Night_Mode;; i = b.c.Link_100)
      {
        paramTextPaint.setColor(((Resources)localObject).getColor(i));
        paramTextPaint.setUnderlineText(false);
        paramTextPaint.clearShadowLayer();
        AppMethodBeat.o(290600);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class t
    implements w.b
  {
    public static final t AGF;
    
    static
    {
      AppMethodBeat.i(288895);
      AGF = new t();
      AppMethodBeat.o(288895);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(288892);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(b.f.toast_text);
        if (paramView != null)
        {
          paramView.setTextSize(1, 14.0F);
          AppMethodBeat.o(288892);
          return;
        }
      }
      AppMethodBeat.o(288892);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    v(long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    w(aa.a parama1, aa.a parama2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aj
 * JD-Core Version:    0.7.0.1
 */