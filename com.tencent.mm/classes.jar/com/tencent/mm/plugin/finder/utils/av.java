package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.Size;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.if.a;
import com.tencent.mm.autogen.a.it;
import com.tencent.mm.autogen.a.it.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.g.b;
import com.tencent.mm.g.h.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderEmptyLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.search.h.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.w;
import com.tencent.mm.plugin.finder.view.w.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.gallery.picker.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.l;
import com.tencent.qqmusic.mediaplayer.util.BytesTransUtil;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
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
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.am;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil;", "", "()V", "FINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "", "getFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "()I", "setFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN_VALUE", "(I)V", "FINDER_POST_DISABLE_HALF_SCREEN_VALUE", "getFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "setFINDER_POST_DISABLE_HALF_SCREEN_VALUE", "MAX_HEIGHT_RATIO", "", "getMAX_HEIGHT_RATIO", "()F", "MEDIA_MAX_HEIGHT_RATIO", "MEDIA_MIN_HEIGHT_RATIO", "MEGA_VIDEO_VISIT_ENTRANCE_VALUE", "MENU_FROM_DEFAULT", "MIN_HEIGHT_RATIO", "OTHER_CARE_REPORT_RV_TYPE", "", "getOTHER_CARE_REPORT_RV_TYPE", "()Ljava/util/Set;", "POST_WIDER_MEDIA_LAYOUT_SIZE", "TAG", "", "TOUCH_DELEGATE_DEFAULT_VALUE", "VISIBILITY_CARE_RV_TYPE", "getVISIBILITY_CARE_RV_TYPE", "debug", "", "getDebug", "()Z", "heightPixels", "isNeedResetFullScreenConfig", "setNeedResetFullScreenConfig", "(Z)V", "lastCenterFeedId", "", "getLastCenterFeedId", "()J", "setLastCenterFeedId", "(J)V", "margin", "mediaRect", "Landroid/graphics/Rect;", "screenInfoObj", "Lorg/json/JSONObject;", "getScreenInfoObj", "()Lorg/json/JSONObject;", "setScreenInfoObj", "(Lorg/json/JSONObject;)V", "statusBarHeight", "getStatusBarHeight", "statusBarHeight$delegate", "Lkotlin/Lazy;", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "addClientReportBuffInfo", "", "intent", "Landroid/content/Intent;", "enterReportScene", "enterExtraInfo", "blurVideoThumb", "Landroid/graphics/Bitmap;", "renderScriptBlur", "Lcom/tencent/mm/ui/blur/RenderScriptBlur;", "bitmap", "source", "buildConvertFailMsg", "logPrefix", "type", "calcLimitSize", "Lkotlin/Pair;", "width", "height", "calculateLongVideoLayoutParams", "context", "Landroid/app/Activity;", "originWidth", "originHeight", "targetView", "Landroid/view/View;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "calculateMediaLayoutParams", "parent", "child", "radio", "screenHeight", "tag", "feedId", "calculatePercent", "offset", "total", "calculatePostLayoutParams", "Lkotlin/Triple;", "calculateStaggeredLayoutParams", "item", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "canFav", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "canFollowMusic", "canLike", "canMegaVideoFav", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "canMegaVideoLike", "canMegaVideoPostBullet", "canMegaVideoShare", "canReprint", "feed", "canShare", "canShareConversation", "canShareRingTone", "canShareSns", "canShareTextStatus", "canShowTencentVideoLink", "canShowTime", "canXSettingAllowSetRingtone", "changeSystemViewColor", "window", "Landroid/view/Window;", "light", "checkAgreeGetPhone", "checkBindPhone", "checkFinderNotifyControlFlag", "info", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "flag", "msgId", "checkHasAccountAndCreate", "activity", "Landroid/content/Context;", "tip", "showRed", "userPrepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "checkHasCloseRedPack", "checkHasEnterRedPackMiniApp", "checkHasRealname", "titleStr", "dismissCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "checkIfAccountLegal", "checkIfMsgMute", "extFlag", "checkIfRedPackInTime", "checkMyTabRedPackRedDot", "priority", "finderSelfUiRedDotTitle", "checkPostDialogHeader", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "headerView", "checkResetFullScreenConfig", "checkShowCgiErrorAlter", "errType", "errCode", "errMsg", "checkUserState", "clearFinderMsgLastBuf", "clearWxMsgLastBuf", "composeTopicTitle", "event", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "convertCompatibilityMediaType", "obj", "createIntentWithCache", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "isHot", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "createVideoPreloadTask", "taskCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "currentTimeSecond", "decodeBitmap", "inputStream", "Ljava/io/InputStream;", "limitW", "limitH", "isRotate", "isClose", "delAliasInfo", "deletingInfo", "Lcom/tencent/mm/plugin/finder/model/FinderOrAliasDeletingInfo;", "deleteMyLocalAccountData", "fillLocalImageToView", "imageView", "Landroid/widget/ImageView;", "fillRefInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "filterText", "origin", "findCenterFeed", "Lcom/tencent/mm/plugin/finder/utils/CenterFeed;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "firstPosition", "lastPosition", "otherCareType", "fixRecyclerViewPosition", "initPos", "linearLayoutManager", "formatCampaignTime", "time", "formatDuration", "duration", "formatLiveNum", "num", "roundingDown", "formatFloat", "formatTextWithEllipse", "paint", "Landroid/text/TextPaint;", "content", "maxLines", "formatTime", "genCheckUserNameCondition", "needDummyConv", "(Ljava/lang/Boolean;)Ljava/lang/String;", "genMsgHolderCondition", "genPoiAddress", "descs", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinString_t;", "getActionMenuInfo", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$ActionMenuInfo;", "from", "afterRefreshStatus", "Lkotlin/Function1;", "getAuthIconDrawable", "style", "username", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/graphics/drawable/Drawable;", "drawable", "getBgmView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "focusHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getCampaignTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dayCount", "getClipData", "getColorWithAlpha", "alpha", "color", "getCommentSceneByTabType", "tabType", "getCompareFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "headCount", "compareFeedLogic", "getCurrentRoleUserName", "getCurrentRoleUserNameByScene", "msgAccountType", "getCurrentScreenIndexInfo", "Lorg/json/JSONArray;", "getDisplayName", "nickname", "printLog", "getEllipseText", "preText", "ellipseTotalText", "endText", "availableWidth", "getFeed", "position", "feedList", "getFeedListByAdapterPosRange", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "start", "end", "getFinderLiveCommentPopCenter", "", "view", "floatView", "getFinderLiveNoticeTips", "forceDate", "(JLjava/lang/Boolean;)Ljava/lang/String;", "getFinderMsgSuffixColor", "scene", "getFinderNickName", "finderNickName", "getFinderPageDir", "getFollowPatWording", "getFromUserName", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getHint", "key", "resId", "getHomeTabInitCacheList", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "firstPageFlag", "isPreload", "filterHistoryFeed", "getImageLocation", "", "getLastBuffKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getListOfType", "E", "T", "clazz", "Ljava/lang/Class;", "getLocationShowString", "countryCode", "provinceCode", "cityCode", "getLong", "startIndex", "byteArr", "", "getMaxMediaHWRadio", "list", "getMaxShareMediaHWRadio", "Lcom/tencent/mm/protocal/protobuf/FinderShareMedia;", "getMaxShareMegaMediaHWRadio", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareMedia;", "getMediaRateLimit", "hwRate", "getMentionNick", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "getNickName", "getNoticeStartTime", "getPoiText", "city", "poiName", "getPosition", "getPrintDescription", "desc", "getRandomChina", "", "getRedDotCharWidth", "textSizeDimen", "getRedDotSingleLineMaxWords", "getRedDotTextSize", "getSceneByCurrentRole", "getScreenInfo", "getSelfNameByScene", "getSelfUsernameByScene", "getShareUiEnter", "reportScene", "getSpanTouchListener", "Landroid/view/View$OnTouchListener;", "tv", "getTextRealLength", "value", "getTextWithLimit", "text", "limit", "getToUserName", "getUnreadList", "cacheDataList", "getVideoInfo", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "filePath", "getVideoLocation", "getVideoType", "localFinderMedia", "getVisibleFeedListByAdapterPosRange", "Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "globalVisibleRect", "getWxDisplayName", "getXSettingGatingAboutShowSubtitle", "hasBgmIcon", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasCreateFinderIdentit", "hasFinderAccount", "ifShowNoticeView", "internalSetAutoIcon", "authIconType", "authIconUrl", "isAcceptLiveObj", "invokeSource", "isAcceptNearbyVideoObj", "isAcceptObj", "isAcceptVideoObj", "isAllowEditFillingFullScreen", "isCampaignFinished", "closeFlag", "endTime", "isCropVideo", "isDisablePostHalfScreen", "isDisplaySettingMpIdentitySwitch", "isFinderComment", "displayFlag", "isFinderEntranceOpen", "isFinderScene", "isFlowCommentScene", "commentScene", "isFoldableDeviceOrInMagicWindowMode", "isFriend", "isFriendComment", "isJsapiFromAd", "extraInfo", "isLikeNotRecommend", "isLongVideo", "attachment", "Lcom/tencent/mm/protocal/protobuf/FinderAttachment;", "isMoovOptimize", "isMsgLikeEvent", "isNewPauseMode", "isNoSeeAtTab", "userName", "isNormalVideo", "isNotAddDescToCommentDrawer", "isPauseIconInside", "media", "isPostNewsQualificaion", "isPoster", "isPrivateAccount", "isRealSvrFeed", "isSelf", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "isSessionIdExist", "talker", "isSettingInMpIdentity", "isSettingMpIdentitySwitchDisable", "isShowAtWxProfile", "isShowCampaignEndTime", "displayMask", "isShowCampaignJoinBtn", "isShowCampaignJoinedCount", "wordingInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventWordingInfo;", "isShowCampaignNickName", "isTest", "isUseCenterInside", "isUserBlocked", "isUserDeleting", "isUserNameBelongMyFinder", "finderUserName", "isUserWxForeign", "isViewVisibleRectMoreThanThreshold", "visibleRectThreshold", "isHeight", "isWxScene", "isWxSelf", "jumpLocation", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "showShareIcon", "poiScale", "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "isDirectToMapUI", "jumpToCampaignAnnounce", "jumpToWxProfile", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "feedUsername", "fromScene", "addBlackListener", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feedUserName", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "nonceId", "limitPostLayoutParams", "liveListIsFirstVisible", "liveListIsVisible", "makeMediaTypeHappy", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "default", "measureMaxWords", "mergeBackCacheAndNotify", "Lcom/tencent/mm/plugin/finder/feed/model/LoaderCache;", "data", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "updateLoaderLastBuf", "millisToUnixTime", "timestamp", "multiLet", "R", "T1", "T2", "p1", "p2", "block", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "newFeedStyle", "switchValue", "parseMentionContactToPb", "Lcom/tencent/mm/protocal/protobuf/FinderCommentMentionedUser;", "ct", "Lcom/tencent/mm/plugin/finder/view/MentionContact;", "parsePbToMentionContact", "user", "parseTipsAsTriple", "tips", "parseUxInfo", "adInfo", "postCommentCountChangedEvent", "it", "postExposeDelEvent", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "commentId", "clientId", "printAllItem", "printFinderMessages", "processFinderAliasSync", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "changeUserName", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;Ljava/lang/Boolean;Ljava/lang/String;)V", "putLong", "x", "reportCollectUnreadItem", "remain", "resize2Even", "saveCacheToIntent", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "customData", "Lcom/tencent/mm/plugin/finder/feed/model/CacheCustom;", "setAuthIcon", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizInfoForFinder;", "authType", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "Landroid/widget/TextView;", "maxInputLength", "maxInputSize", "configCallback", "Lkotlin/Function0;", "setFinderFeedAuthIcon", "authIconView", "nickNameView", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "endMargin", "setSpanTouch", "Landroid/text/Spannable;", "setToMachineTab", "onClick", "setToNearbyLiveMorePage", "setToTargetTab", "tabName", "forceEnableNightMode", "setTouchDelegate", "dx", "dy", "setVisibility", "visibility", "shake", "Landroid/animation/ObjectAnimator;", "shakeFactor", "showBanToast", "wording", "showFeedCommentInput", "ifShow", "showFinderTabType", "showLongVideoEntrance", "finderItem", "sourceFlagToLocalTypeFlag", "sourceType", "switchScene", "tabTypeToSourceFlag", "transDecimalFormat", "count", "transOldFinderMsgSessionAndConv", "transformColor", "begin", "percent", "tryLoadPagLibrary", "prefix", "unixTimeToMillis", "videoFlagToVideoFormat", "videoFlag", "ActionMenuInfo", "VisibilityFeed", "VisibleFeedDataObj", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
{
  private static final kotlin.j AIn;
  private static long AIv;
  private static final int ALs;
  private static final int ANY;
  private static final kotlin.j BqT;
  private static final int DJV;
  private static final int Fsq;
  public static final av GiL;
  private static final int GiM;
  private static final float GiN;
  private static final float GiO;
  private static final Set<Integer> GiP;
  private static final Set<Integer> GiQ;
  private static final Rect GiR;
  private static JSONObject GiS;
  private static boolean GiT;
  private static int GiU;
  public static int GiV;
  public static final String TAG;
  private static final boolean debug;
  
  static
  {
    AppMethodBeat.i(167970);
    GiL = new av();
    TAG = "Finder.FinderUtil";
    ALs = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_1_5_A);
    GiM = (int)MMApplicationContext.getContext().getResources().getDimension(e.c.post_wider_media_layout_size);
    GiN = 1.333333F;
    GiO = 1.0F;
    GiP = ar.setOf(Integer.valueOf(2013));
    GiQ = ar.setOf(Integer.valueOf(2003));
    debug = BuildInfo.DEBUG;
    GiR = new Rect();
    AIv = -1L;
    BqT = kotlin.k.cm((kotlin.g.a.a)av.l.Gjg);
    AIn = kotlin.k.cm((kotlin.g.a.a)m.Gjh);
    ANY = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    Fsq = ((Number)com.tencent.mm.plugin.finder.storage.d.eUS().bmg()).intValue();
    GiT = true;
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    GiU = ((Number)com.tencent.mm.plugin.finder.storage.d.eVt().bmg()).intValue();
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    GiV = ((Number)com.tencent.mm.plugin.finder.storage.d.eVu().bmg()).intValue();
    DJV = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(e.c.Edge_A);
    AppMethodBeat.o(167970);
  }
  
  public static boolean A(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333715);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x1) == 0)
    {
      AppMethodBeat.o(333715);
      return true;
    }
    AppMethodBeat.o(333715);
    return false;
  }
  
  public static boolean B(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333720);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x1) == 0)
    {
      AppMethodBeat.o(333720);
      return true;
    }
    AppMethodBeat.o(333720);
    return false;
  }
  
  public static boolean C(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333727);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x80) == 0)
    {
      AppMethodBeat.o(333727);
      return true;
    }
    AppMethodBeat.o(333727);
    return false;
  }
  
  public static boolean D(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(334547);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager != null)
    {
      label53:
      int i;
      int m;
      int n;
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        if (localLayoutManager == null) {
          break label173;
        }
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {
          break label173;
        }
        if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
          break label150;
        }
        if (paramRecyclerView == null) {
          break label173;
        }
        i = ((LinearLayoutManager)localLayoutManager).Ju();
        m = ((LinearLayoutManager)localLayoutManager).Jw();
        paramRecyclerView = (List)((WxRecyclerAdapter)paramRecyclerView).data;
        n = paramRecyclerView.size();
        if (i > m) {
          break label173;
        }
      }
      int j;
      label150:
      label165:
      do
      {
        j = i;
        int k = j + 1;
        if (j >= 0) {
          if (j < n) {
            i = 1;
          }
        }
        for (;;)
        {
          if ((i == 0) || (!(paramRecyclerView.get(j) instanceof com.tencent.mm.plugin.finder.model.y))) {
            break label165;
          }
          AppMethodBeat.o(334547);
          return true;
          localLayoutManager = null;
          break;
          paramRecyclerView = null;
          break label53;
          i = 0;
          continue;
          i = 0;
        }
        i = k;
      } while (j != m);
    }
    label173:
    AppMethodBeat.o(334547);
    return false;
  }
  
  public static boolean D(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333732);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x2) == 0)
    {
      AppMethodBeat.o(333732);
      return true;
    }
    AppMethodBeat.o(333732);
    return false;
  }
  
  public static boolean E(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333740);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x20) == 0)
    {
      AppMethodBeat.o(333740);
      return true;
    }
    AppMethodBeat.o(333740);
    return false;
  }
  
  public static boolean F(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(333773);
    kotlin.g.b.s.u(paramFinderObject, "finderObject");
    if ((paramFinderObject.permissionFlag & 0x10) == 0)
    {
      AppMethodBeat.o(333773);
      return true;
    }
    AppMethodBeat.o(333773);
    return false;
  }
  
  public static void G(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(178459);
    kotlin.g.b.s.u(paramFinderItem, "it");
    it localit = new it();
    localit.hKk.feedId = paramFinderItem.field_id;
    localit.hKk.hKm = paramFinderItem.getCommentCount();
    localit.publish();
    AppMethodBeat.o(178459);
  }
  
  public static boolean H(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(333994);
    kotlin.g.b.s.u(paramFinderItem, "item");
    if ((paramFinderItem.getFeedObject().incFriendLikeCount > 0) && (paramFinderItem.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(333994);
      return true;
    }
    AppMethodBeat.o(333994);
    return false;
  }
  
  public static boolean I(FinderItem paramFinderItem)
  {
    Object localObject = null;
    FinderObjectDesc localFinderObjectDesc = null;
    int j = 1;
    AppMethodBeat.i(334205);
    kotlin.g.b.s.u(paramFinderItem, "feed");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      AppMethodBeat.o(334205);
      return false;
    }
    FinderObject localFinderObject = paramFinderItem.getFinderObject();
    kotlin.g.b.s.u(localFinderObject, "finderObject");
    if ((localFinderObject.permissionFlag & 0x8) == 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(334205);
      return false;
    }
    kotlin.g.b.s.u(paramFinderItem, "finderItem");
    if ((!Util.isNullOrNil((List)paramFinderItem.getLongVideoMediaList())) && (Fsq == 1)) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(334205);
      return true;
    }
    if (paramFinderItem.getMediaType() == 2)
    {
      localObject = paramFinderItem.getFeedObject().objectDesc;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null)
        {
          localObject = paramFinderItem.getFeedObject().objectDesc;
          if (localObject == null) {
            break label271;
          }
          localObject = ((FinderObjectDesc)localObject).feedBgmInfo;
          if ((localObject == null) || (((bqz)localObject).ZZa != 0)) {
            break label271;
          }
          i = 1;
          label202:
          if (i == 0)
          {
            localObject = paramFinderItem.getFeedObject().objectDesc;
            if (localObject != null) {
              break label276;
            }
            localObject = null;
            label223:
            localObject = (CharSequence)localObject;
            i = j;
            if (localObject != null) {
              if (((CharSequence)localObject).length() != 0) {
                break label304;
              }
            }
          }
        }
      }
      label271:
      label276:
      label304:
      for (i = j;; i = 0)
      {
        if (i == 0) {
          break label309;
        }
        AppMethodBeat.o(334205);
        return false;
        localObject = ((FinderObjectDesc)localObject).feedBgmInfo;
        break;
        i = 0;
        break label202;
        localObject = ((FinderObjectDesc)localObject).feedBgmInfo;
        if (localObject == null)
        {
          localObject = null;
          break label223;
        }
        localObject = ((bqz)localObject).groupId;
        break label223;
      }
      label309:
      paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
      if (paramFinderItem == null) {
        paramFinderItem = localFinderObjectDesc;
      }
      while (paramFinderItem != null)
      {
        boolean bool = paramFinderItem.booleanValue();
        AppMethodBeat.o(334205);
        return bool;
        localObject = paramFinderItem.feedBgmInfo;
        paramFinderItem = localFinderObjectDesc;
        if (localObject != null)
        {
          paramFinderItem = localFinderObjectDesc;
          if (((bqz)localObject).musicInfo != null) {
            paramFinderItem = Boolean.TRUE;
          }
        }
      }
    }
    if (paramFinderItem.getMediaType() == 4)
    {
      localFinderObjectDesc = paramFinderItem.getFeedObject().objectDesc;
      if (localFinderObjectDesc == null) {
        if (localObject != null)
        {
          paramFinderItem = paramFinderItem.getFeedObject().objectDesc;
          if (paramFinderItem == null) {
            break label453;
          }
          paramFinderItem = paramFinderItem.feedBgmInfo;
          if ((paramFinderItem == null) || (paramFinderItem.ZZa != 1)) {
            break label453;
          }
        }
      }
      label453:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label458;
        }
        AppMethodBeat.o(334205);
        return true;
        localObject = localFinderObjectDesc.feedBgmInfo;
        break;
      }
      label458:
      AppMethodBeat.o(334205);
      return false;
    }
    AppMethodBeat.o(334205);
    return false;
  }
  
  public static boolean Iz(String paramString)
  {
    AppMethodBeat.i(167957);
    aw localaw = aw.Gjk;
    boolean bool = aw.Iz(paramString);
    AppMethodBeat.o(167957);
    return bool;
  }
  
  public static com.tencent.mm.plugin.finder.model.cc K(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.cc> paramList)
  {
    AppMethodBeat.i(334059);
    kotlin.g.b.s.u(paramList, "feedList");
    if ((paramInt >= 0) && (paramInt < paramList.size()))
    {
      paramList = (com.tencent.mm.plugin.finder.model.cc)paramList.get(paramInt);
      AppMethodBeat.o(334059);
      return paramList;
    }
    AppMethodBeat.o(334059);
    return null;
  }
  
  public static List<BaseFinderFeed> M(List<? extends BaseFinderFeed> paramList, int paramInt)
  {
    AppMethodBeat.i(334364);
    kotlin.g.b.s.u(paramList, "cacheDataList");
    List localList = (List)new ArrayList();
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.h.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
    localObject1 = (com.tencent.mm.plugin.finder.viewmodel.h)localObject1;
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
          kotlin.a.p.kkW();
        }
        localObject2 = (BaseFinderFeed)localObject2;
        if (i < 2) {
          break label185;
        }
        com.tencent.mm.plugin.finder.storage.data.e.a locala = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        if (!com.tencent.mm.plugin.finder.storage.data.e.a.au(paramInt, ((BaseFinderFeed)localObject2).feedObject.field_id))
        {
          if ((((BaseFinderFeed)localObject2).feedObject.field_id != 0L) && (!((com.tencent.mm.plugin.finder.viewmodel.h)localObject1).az(paramInt, ((BaseFinderFeed)localObject2).feedObject.field_id))) {
            localList.add(localObject2);
          }
          i = j;
          continue;
        }
      }
      AppMethodBeat.o(334364);
      return localList;
      label185:
      i = j;
    }
  }
  
  public static FinderImgFeedMusicTag T(RecyclerView.v paramv)
  {
    AppMethodBeat.i(334197);
    Object localObject;
    if (paramv == null)
    {
      paramv = null;
      if (paramv != null) {
        break label81;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = paramv.getTag(e.e.finder_music_visible_tag);
        if (localObject == null)
        {
          paramv = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
          AppMethodBeat.o(334197);
          throw paramv;
          paramv = paramv.caK;
          if (paramv == null)
          {
            paramv = null;
            break;
          }
          paramv = (FinderImgFeedMusicTag)paramv.findViewById(e.e.bgm_iv);
          break;
          label81:
          localObject = paramv.getTag(e.e.finder_music_visible_tag);
          continue;
        }
        if (((Boolean)localObject).booleanValue()) {
          break label112;
        }
      }
    }
    paramv = null;
    label112:
    for (;;)
    {
      AppMethodBeat.o(334197);
      return paramv;
    }
  }
  
  public static int TM(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static long TZ(int paramInt)
  {
    return paramInt * 1000L;
  }
  
  public static float Ua(int paramInt)
  {
    AppMethodBeat.i(333114);
    float f2 = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
    float f1 = f2;
    if (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true)) {
      if (!com.tencent.mm.ui.aw.bc(f2, 1.1F))
      {
        f1 = f2;
        if (!com.tencent.mm.ui.aw.bc(f2, 0.8F)) {}
      }
      else
      {
        f1 = 1.0F;
      }
    }
    f2 = MMApplicationContext.getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(333114);
    return f1 * f2;
  }
  
  public static String Ub(int paramInt)
  {
    AppMethodBeat.i(167961);
    String str2 = "";
    String str1 = str2;
    switch (paramInt)
    {
    default: 
      str1 = str2;
    }
    while (Util.isNullOrNil(str1))
    {
      str1 = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().cachePath, "finder/page/");
      AppMethodBeat.o(167961);
      return str1;
      str1 = "follow";
      continue;
      str1 = "feed";
      continue;
      str1 = "fans";
      continue;
      str1 = "preload";
      continue;
      str1 = "activity";
      continue;
      str1 = "cleaner";
      continue;
      str1 = "network";
    }
    str1 = com.tencent.mm.kernel.h.baE().cachePath + "finder/page/" + str1 + '/';
    AppMethodBeat.o(167961);
    return str1;
  }
  
  public static int Uc(int paramInt)
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
  
  public static String Ud(int paramInt)
  {
    AppMethodBeat.i(167967);
    Object localObject = aw.Gjk;
    localObject = aw.Ud(paramInt);
    AppMethodBeat.o(167967);
    return localObject;
  }
  
  public static String Ue(int paramInt)
  {
    AppMethodBeat.i(178461);
    if (paramInt == 2)
    {
      str = com.tencent.mm.model.z.bAM();
      kotlin.g.b.s.s(str, "{\n            ConfigStor…eFromUserInfo()\n        }");
      AppMethodBeat.o(178461);
      return str;
    }
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "{\n            ConfigStor…inderUsername()\n        }");
    AppMethodBeat.o(178461);
    return str;
  }
  
  public static int Uf(int paramInt)
  {
    int i = 2;
    if (paramInt == 2) {
      i = 1;
    }
    return i;
  }
  
  public static int Ug(int paramInt)
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
    case 131072: 
      return 18;
    case 33280: 
      return 17;
    case 196608: 
      return 19;
    }
    return 21;
  }
  
  public static at.a Uh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return at.a.adcc;
    case 0: 
      return at.a.adcc;
    case 1: 
      return at.a.adcd;
    case 3: 
      return at.a.adce;
    case 2: 
      return at.a.adcf;
    }
    return at.a.adck;
  }
  
  public static int Ui(int paramInt)
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
  
  public static boolean Uj(int paramInt)
  {
    return (0x8000 & paramInt) != 0;
  }
  
  public static boolean Uk(int paramInt)
  {
    return (0x10000 & paramInt) != 0;
  }
  
  public static final String Ul(int paramInt)
  {
    AppMethodBeat.i(333814);
    Object localObject = new DecimalFormat("0.#");
    ((DecimalFormat)localObject).setRoundingMode(RoundingMode.FLOOR);
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    if (str != null) {}
    switch (str.hashCode())
    {
    default: 
    case 115861428: 
      do
      {
        localObject = kotlin.g.b.s.X(((DecimalFormat)localObject).format(Float.valueOf(paramInt / 1000.0F)), MMApplicationContext.getContext().getString(e.h.finder_ten_thousand_ringtone_no_chinese));
        AppMethodBeat.o(333814);
        return localObject;
      } while (!str.equals("zh_HK"));
    }
    for (;;)
    {
      localObject = kotlin.g.b.s.X(((DecimalFormat)localObject).format(Float.valueOf(paramInt / 10000.0F)), MMApplicationContext.getContext().getString(e.h.finder_ten_thousand_ringtone));
      AppMethodBeat.o(333814);
      return localObject;
      if (!str.equals("zh_TW")) {
        if ((goto 72) || (!str.equals("zh_CN"))) {
          break;
        }
      }
    }
  }
  
  public static boolean Um(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static String Un(int paramInt)
  {
    AppMethodBeat.i(333954);
    switch (paramInt)
    {
    default: 
      String str = kotlin.g.b.s.X("unknow ", Integer.valueOf(paramInt));
      AppMethodBeat.o(333954);
      return str;
    case 0: 
      AppMethodBeat.o(333954);
      return "TAB_TYPE_ALL";
    case 1: 
      AppMethodBeat.o(333954);
      return "TAB_TYPE_FRIEND";
    case 2: 
      AppMethodBeat.o(333954);
      return "TAB_TYPE_LBS";
    case 3: 
      AppMethodBeat.o(333954);
      return "TAB_TYPE_FOLLOW";
    }
    AppMethodBeat.o(333954);
    return "TAB_TYPE_MACHINE";
  }
  
  public static int Uo(int paramInt)
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
  
  public static String Uq(int paramInt)
  {
    AppMethodBeat.i(334497);
    int i = paramInt % 60;
    int j = paramInt / 60 % 60;
    paramInt = paramInt / 60 / 60;
    if (paramInt == 0)
    {
      str = vh(j) + ':' + vh(i);
      AppMethodBeat.o(334497);
      return str;
    }
    String str = vh(paramInt) + ':' + vh(j) + ':' + vh(i);
    AppMethodBeat.o(334497);
    return str;
  }
  
  public static String Ur(int paramInt)
  {
    AppMethodBeat.i(334514);
    switch (paramInt)
    {
    default: 
      str = com.tencent.mm.model.z.bAM();
      kotlin.g.b.s.s(str, "{\n                Config…mUserInfo()\n            }");
      AppMethodBeat.o(334514);
      return str;
    case 2: 
      str = com.tencent.mm.model.z.bAM();
      kotlin.g.b.s.s(str, "{\n                Config…mUserInfo()\n            }");
      AppMethodBeat.o(334514);
      return str;
    case 1: 
      str = com.tencent.mm.model.z.bAW();
      kotlin.g.b.s.s(str, "{\n                Config…rUsername()\n            }");
      AppMethodBeat.o(334514);
      return str;
    }
    String str = com.tencent.mm.model.z.bAX();
    kotlin.g.b.s.s(str, "{\n                Config…sUsername()\n            }");
    AppMethodBeat.o(334514);
    return str;
  }
  
  public static String V(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(370223);
    paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString1);
    if ((paramString1 != null) && ((int)paramString1.maN != 0) && (!Util.isNullOrNil(paramString1.aSV()))) {
      paramString1 = paramString1.aSV();
    }
    for (;;)
    {
      kotlin.g.b.s.s(paramString1, "displayName");
      AppMethodBeat.o(370223);
      return paramString1;
      if (!Util.isNullOrNil(paramString2))
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
      else if (paramString1 == null)
      {
        paramString1 = "";
      }
      else
      {
        paramString2 = paramString1.field_username;
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
    }
  }
  
  public static int a(BaseFinderFeed paramBaseFinderFeed, dji paramdji, int paramInt)
  {
    AppMethodBeat.i(333124);
    kotlin.g.b.s.u(paramBaseFinderFeed, "item");
    kotlin.g.b.s.u(paramdji, "mediaObj");
    if (paramInt > 0)
    {
      paramdji = com.tencent.mm.plugin.finder.storage.data.i.a(paramdji, true);
      int i;
      int j;
      if ((paramBaseFinderFeed.feedObject.isLiveFeed()) || (paramdji.getWidth() <= 0))
      {
        i = (int)(3.5D * paramInt / 3.0D);
        if (i <= paramInt * 1.316667F) {
          break label104;
        }
        j = (int)(paramInt * 1.316667F);
      }
      for (;;)
      {
        AppMethodBeat.o(333124);
        return j;
        i = paramdji.getHeight() * paramInt / paramdji.getWidth();
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
    AppMethodBeat.o(333124);
    return 0;
  }
  
  public static int a(com.tencent.mm.plugin.finder.model.cc paramcc, List<? extends com.tencent.mm.plugin.finder.model.cc> paramList)
  {
    AppMethodBeat.i(334064);
    kotlin.g.b.s.u(paramList, "feedList");
    if (paramcc != null)
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
          kotlin.a.p.kkW();
        }
        if (((com.tencent.mm.plugin.finder.model.cc)localObject).bZA() == paramcc.bZA())
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
    AppMethodBeat.o(334064);
    return k;
  }
  
  public static int a(djh paramdjh)
  {
    AppMethodBeat.i(167947);
    kotlin.g.b.s.u(paramdjh, "content");
    if (paramdjh.mediaList.size() == 0)
    {
      AppMethodBeat.o(167947);
      return 4;
    }
    int i = ((dji)paramdjh.mediaList.get(0)).mediaType;
    aw localaw = aw.Gjk;
    if (!aw.fgq().contains(Integer.valueOf(i)))
    {
      AppMethodBeat.o(167947);
      return i;
    }
    if ((i == 4) && (paramdjh.mediaList.size() > 1))
    {
      AppMethodBeat.o(167947);
      return 8;
    }
    paramdjh = paramdjh.mediaList;
    if (paramdjh != null)
    {
      paramdjh = ((Iterable)paramdjh).iterator();
      while (paramdjh.hasNext()) {
        if (((dji)paramdjh.next()).mediaType != i)
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
    AppMethodBeat.i(334037);
    kotlin.g.b.s.u(paramBaseFinderFeedLoader, "feedLoader");
    kotlin.g.b.s.u(paramLinearLayoutManager, "layoutManager");
    Intent localIntent = new Intent();
    DataBuffer localDataBuffer = paramBaseFinderFeedLoader.getDataListJustForAdapter();
    com.tencent.mm.bx.b localb = paramBaseFinderFeedLoader.getLastBuffer();
    int k = paramBaseFinderFeedLoader.getInitPos();
    int j = paramLinearLayoutManager.Ju();
    int m = paramLinearLayoutManager.Jw();
    Log.i(TAG, "fixRVPos posStart:" + j + ", posEnd " + m + ", initPos:" + k);
    int i = j;
    if (k >= j)
    {
      i = j;
      if (k <= m) {
        i = -1;
      }
    }
    BaseFeedLoader.saveCacheToIntent$default((BaseFeedLoader)paramBaseFinderFeedLoader, localIntent, (List)localDataBuffer, localb, i, null, 16, null);
    AppMethodBeat.o(334037);
    return localIntent;
  }
  
  public static com.tencent.mm.g.h a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, boolean paramBoolean, com.tencent.mm.g.g.a parama, g.b paramb, int paramInt2, long paramLong, String paramString7)
  {
    AppMethodBeat.i(334084);
    kotlin.g.b.s.u(paramString1, "mediaId");
    kotlin.g.b.s.u(paramString2, "url");
    kotlin.g.b.s.u(paramString3, "path");
    kotlin.g.b.s.u(paramString4, "fileFormat");
    kotlin.g.b.s.u(paramString5, "urlToken");
    kotlin.g.b.s.u(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool = com.tencent.mm.plugin.finder.storage.d.eRL();
    localObject = new com.tencent.mm.g.h();
    ((com.tencent.mm.g.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.g.h)localObject).url = kotlin.g.b.s.X(paramString2, paramString5);
    ((com.tencent.mm.g.h)localObject).field_fullpath = paramString3;
    ((com.tencent.mm.g.h)localObject).snsCipherKey = paramString6;
    ((com.tencent.mm.g.h)localObject).isHotSnsVideo = paramBoolean;
    ((com.tencent.mm.g.h)localObject).lxb = 2;
    ((com.tencent.mm.g.h)localObject).lxi = 2;
    ((com.tencent.mm.g.h)localObject).lxc = 8;
    ((com.tencent.mm.g.h)localObject).lxn = paramInt2;
    ((com.tencent.mm.g.h)localObject).field_preloadRatio = paramInt2;
    ((com.tencent.mm.g.h)localObject).concurrentCount = com.tencent.mm.plugin.findersdk.a.k.a.Hcc;
    ((com.tencent.mm.g.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVo;
    ((com.tencent.mm.g.h)localObject).field_fileType = com.tencent.mm.g.a.lwi;
    ((com.tencent.mm.g.h)localObject).preloadMinSize = paramLong;
    ((com.tencent.mm.g.h)localObject).lxp = 0;
    ((com.tencent.mm.g.h)localObject).lwL = parama;
    ((com.tencent.mm.g.h)localObject).lxd = paramb;
    int i;
    if (!bool) {
      if (paramInt1 <= 0)
      {
        i = com.tencent.mm.modelcontrol.e.S(1, paramString3);
        ((com.tencent.mm.g.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      Log.i(paramString7, "[createVideoPreloadTask] finder video, isHot=" + paramBoolean + " reqFormat=" + paramInt1 + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.g.h)localObject).url + " preloadPercent:" + paramInt2 + " preloadMinSize:" + paramLong);
      AppMethodBeat.o(334084);
      return localObject;
      i = paramInt1;
      break;
      ((com.tencent.mm.g.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.g.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.g.h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, boolean paramBoolean, h.a parama, String paramString7)
  {
    AppMethodBeat.i(334073);
    kotlin.g.b.s.u(paramString1, "mediaId");
    kotlin.g.b.s.u(paramString2, "url");
    kotlin.g.b.s.u(paramString3, "path");
    kotlin.g.b.s.u(paramString4, "fileFormat");
    kotlin.g.b.s.u(paramString5, "urlToken");
    kotlin.g.b.s.u(parama, "videoCallback");
    kotlin.g.b.s.u(paramString7, "tag");
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool = com.tencent.mm.plugin.finder.storage.d.eRL();
    localObject = new com.tencent.mm.g.h();
    ((com.tencent.mm.g.h)localObject).taskName = "task_FinderUtil";
    ((com.tencent.mm.g.h)localObject).field_mediaId = paramString1;
    ((com.tencent.mm.g.h)localObject).url = kotlin.g.b.s.X(paramString2, paramString5);
    ((com.tencent.mm.g.h)localObject).lwP = 60;
    ((com.tencent.mm.g.h)localObject).lwQ = 60;
    ((com.tencent.mm.g.h)localObject).lxi = 1;
    ((com.tencent.mm.g.h)localObject).lxc = 8;
    ((com.tencent.mm.g.h)localObject).lxp = 0;
    int i;
    if (!bool) {
      if (paramInt <= 0)
      {
        i = com.tencent.mm.modelcontrol.e.S(1, paramString3);
        ((com.tencent.mm.g.h)localObject).field_requestVideoFormat = i;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.g.h)localObject).field_fullpath = paramString3;
      ((com.tencent.mm.g.h)localObject).concurrentCount = com.tencent.mm.plugin.findersdk.a.k.a.Hcc;
      ((com.tencent.mm.g.h)localObject).connectionCount = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMediaPreloadModel().EVp;
      ((com.tencent.mm.g.h)localObject).snsCipherKey = paramString6;
      ((com.tencent.mm.g.h)localObject).isHotSnsVideo = paramBoolean;
      ((com.tencent.mm.g.h)localObject).lxs = parama;
      Log.i(paramString7, "[loadByCdn] finder video, isHot=" + paramBoolean + " reqFormat=" + paramInt + " fileFormat=" + paramString4 + ",isOpenMultiBitRateDownload=" + bool + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + ((com.tencent.mm.g.h)localObject).url + ' ');
      AppMethodBeat.o(334073);
      return localObject;
      i = paramInt;
      break;
      ((com.tencent.mm.g.h)localObject).field_requestVideoFormat = 0;
      ((com.tencent.mm.g.h)localObject).videoFlag = paramString4;
    }
  }
  
  public static com.tencent.mm.plugin.finder.feed.model.s a(Intent paramIntent, RecyclerView paramRecyclerView, BaseFeedLoader<com.tencent.mm.plugin.finder.model.cc> paramBaseFeedLoader, boolean paramBoolean, kotlin.g.a.b<? super com.tencent.mm.plugin.finder.model.cc, Boolean> paramb)
  {
    AppMethodBeat.i(334050);
    kotlin.g.b.s.u(paramIntent, "data");
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramBaseFeedLoader, "feedLoader");
    RecyclerView.a locala = paramRecyclerView.getAdapter();
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    paramBaseFeedLoader.initBackCache(paramIntent);
    com.tencent.mm.plugin.finder.feed.model.s locals = paramBaseFeedLoader.getBackCache();
    if (((locala instanceof WxRecyclerAdapter)) && ((paramRecyclerView instanceof StaggeredGridLayoutManager)) && (locals != null) && (!Util.isNullOrNil((List)locals.pUj)) && (locals.lastBuffer != null))
    {
      int k = ((WxRecyclerAdapter)locala).agOb.size();
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
            kotlin.a.p.kkW();
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
      while (paramIntent.size() != locals.pUj.size())
      {
        paramIntent = ((Iterable)paramIntent).iterator();
        for (;;)
        {
          if (paramIntent.hasNext())
          {
            localDataBuffer.remove((com.tencent.mm.plugin.finder.model.cc)paramIntent.next());
            continue;
            paramIntent = new ArrayList();
            localObject1 = (Iterable)localDataBuffer;
            i = 0;
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = ((Iterator)localObject1).next();
              if (i < 0) {
                kotlin.a.p.kkW();
              }
              localObject2 = (com.tencent.mm.plugin.finder.model.cc)localObject2;
              if ((i >= k) && (((Boolean)paramb.invoke(localObject2)).booleanValue())) {
                paramIntent.add(localObject2);
              }
              i += 1;
            }
            paramIntent = (List)paramIntent;
            break;
          }
        }
        localDataBuffer.addAll((Collection)locals.pUj);
        if (paramBoolean) {
          paramBaseFeedLoader.setLastBuffer(locals.lastBuffer);
        }
        ((WxRecyclerAdapter)locala).bZE.notifyChanged();
      }
      if (locals.position >= 0)
      {
        i = a(K(locals.position, (List)locals.pUj), (List)localDataBuffer);
        ((StaggeredGridLayoutManager)paramRecyclerView).bo(i + k, 0);
      }
      Log.i(TAG, "mergeBackCacheAndNotify, pos:" + locals.position + ", headCount:" + k);
      AppMethodBeat.o(334050);
      return locals;
    }
    AppMethodBeat.o(334050);
    return null;
  }
  
  public static c a(RecyclerView paramRecyclerView, Rect paramRect)
  {
    AppMethodBeat.i(333869);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramRect, "globalVisibleRect");
    c localc = new c();
    RecyclerView.a locala = paramRecyclerView.getAdapter();
    Object localObject1;
    int i;
    int k;
    if ((locala instanceof WxRecyclerAdapter))
    {
      localObject1 = paramRecyclerView.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(333869);
        throw paramRecyclerView;
      }
      i = ((LinearLayoutManager)localObject1).Ju();
      localObject1 = paramRecyclerView.getLayoutManager();
      if (localObject1 == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(333869);
        throw paramRecyclerView;
      }
      k = ((LinearLayoutManager)localObject1).Jw();
      Log.i(TAG, "[getVisibleFeedListByAdapterPosRange] old=" + paramRecyclerView.getChildCount() + " new=" + (k - i + 1));
      if (i > k) {}
    }
    for (;;)
    {
      Object localObject2 = paramRecyclerView.fU(i);
      int j;
      com.tencent.mm.plugin.finder.event.base.g localg;
      l locall;
      if (localObject2 != null)
      {
        localObject1 = ((RecyclerView.v)localObject2).caK;
        kotlin.g.b.s.s(localObject1, "childHolder.itemView");
        if ((localObject2 instanceof com.tencent.mm.view.recyclerview.j))
        {
          localObject2 = (com.tencent.mm.view.recyclerview.a)((com.tencent.mm.view.recyclerview.j)localObject2).CSA;
          j = ((WxRecyclerAdapter)locala).agOb.size();
          if (((localObject2 instanceof com.tencent.mm.plugin.finder.model.cc)) && (((com.tencent.mm.view.recyclerview.a)localObject2).bZA() != 0L))
          {
            localg = new com.tencent.mm.plugin.finder.event.base.g((com.tencent.mm.plugin.finder.model.cc)localObject2, i - j, (byte)0);
            if (!(localObject2 instanceof BaseFinderFeed)) {
              break label655;
            }
            locall = (l)((WxRecyclerAdapter)locala).agOM.get(((com.tencent.mm.view.recyclerview.a)localObject2).bZA());
            if (locall != null)
            {
              if (((BaseFinderFeed)localObject2).feedObject.getFoldedLayout() != null)
              {
                Object localObject3 = new Rect();
                paramRecyclerView.getChildVisibleRect((View)localObject1, (Rect)localObject3, null);
                locall.agOt = paramRect.top;
                locall.agOu = paramRect.bottom;
                locall.agOs = ((Rect)localObject3).top;
                localObject1 = (FinderFoldedScrollLayout)((View)localObject1).findViewById(e.e.feed_folded_scroll_layout);
                if (localObject1 != null)
                {
                  if (((FinderFoldedScrollLayout)localObject1).getVisibility() != 0) {
                    break label547;
                  }
                  j = 1;
                  if (j == 0) {
                    break label552;
                  }
                  label396:
                  if (localObject1 != null)
                  {
                    localObject3 = ((FinderFoldedScrollLayout)localObject1).getParent();
                    if (localObject3 != null)
                    {
                      localObject3 = ((ViewParent)localObject3).getParent();
                      if ((localObject3 != null) && ((localObject3 instanceof View)))
                      {
                        locall.agOv = ((View)localObject3).getTop();
                        locall.agOz = new WeakReference(((FinderFoldedScrollLayout)localObject1).getAdapter());
                        locall.agOy = ((FinderFoldedScrollLayout)localObject1).getAdapter().agOQ;
                        if (locall.agOv != 0) {
                          break label558;
                        }
                        ((View)localObject3).post(new av..ExternalSyntheticLambda12(locall, (ViewParent)localObject3));
                      }
                    }
                  }
                }
              }
              label506:
              localg.AOo = locall;
            }
          }
        }
      }
      for (;;)
      {
        if (!(localObject2 instanceof com.tencent.mm.plugin.finder.model.y)) {
          localc.Gjd.add(localg);
        }
        if (i != k) {
          break label693;
        }
        AppMethodBeat.o(333869);
        return localc;
        label547:
        j = 0;
        break;
        label552:
        localObject1 = null;
        break label396;
        label558:
        if (locall.agOu - locall.agOt - locall.agOs > locall.agOv)
        {
          if (locall.agOw) {
            break label506;
          }
          locall.agOw = true;
          localObject1 = locall.agOz;
          if (localObject1 == null) {
            break label506;
          }
          localObject1 = (WxRecyclerAdapter)((WeakReference)localObject1).get();
          if (localObject1 == null) {
            break label506;
          }
          ((WxRecyclerAdapter)localObject1).onResume();
          break label506;
        }
        if (!locall.agOw) {
          break label506;
        }
        locall.agOw = false;
        locall.agOx = true;
        break label506;
        label655:
        localObject1 = (l)((WxRecyclerAdapter)locala).agOM.get(((com.tencent.mm.view.recyclerview.a)localObject2).bZA());
        if (localObject1 != null) {
          localg.AOo = ((l)localObject1);
        }
      }
      label693:
      i += 1;
    }
  }
  
  public static d a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Set<Integer> paramSet)
  {
    AppMethodBeat.i(333497);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramSet, "otherCareType");
    long l = SystemClock.uptimeMillis();
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if (localObject1 == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
      AppMethodBeat.o(333497);
      throw paramRecyclerView;
    }
    localObject1 = (LinearLayoutManager)localObject1;
    if (paramInt1 == -2147483648) {}
    int j;
    for (int i = ((LinearLayoutManager)localObject1).Ju();; i = paramInt1)
    {
      j = paramInt2;
      if (paramInt2 == -2147483648) {
        j = ((LinearLayoutManager)localObject1).Jw();
      }
      if ((i >= 0) && (j >= i) && (j >= 0)) {
        break;
      }
      paramRecyclerView = new d(false, null, 254);
      AppMethodBeat.o(333497);
      return paramRecyclerView;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject1 = paramRecyclerView.getAdapter();
    if (localObject1 == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
      AppMethodBeat.o(333497);
      throw paramRecyclerView;
    }
    localObject1 = (WxRecyclerAdapter)localObject1;
    Object localObject2 = (List)((WxRecyclerAdapter)localObject1).data;
    paramInt1 = 0;
    localObject2 = ((List)localObject2).iterator();
    Object localObject3;
    label264:
    label268:
    int n;
    label301:
    label359:
    label363:
    int i1;
    int i2;
    float f;
    d locald;
    int k;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.view.recyclerview.a)((Iterator)localObject2).next();
      if ((((com.tencent.mm.view.recyclerview.a)localObject3).bZB() == 4) || (((com.tencent.mm.view.recyclerview.a)localObject3).bZB() == 2013) || (((com.tencent.mm.view.recyclerview.a)localObject3).bZB() == 9))
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label718;
        }
        n = paramInt1 + ((com.tencent.mm.view.recyclerview.i)localObject1).agOb.size();
        localObject2 = (List)((WxRecyclerAdapter)localObject1).data;
        paramInt1 = 0;
        localObject2 = ((List)localObject2).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label742;
        }
        localObject3 = (com.tencent.mm.view.recyclerview.a)((Iterator)localObject2).next();
        if ((((com.tencent.mm.view.recyclerview.a)localObject3).bZB() != 4) && (((com.tencent.mm.view.recyclerview.a)localObject3).bZB() != 2) && (((com.tencent.mm.view.recyclerview.a)localObject3).bZB() != 9)) {
          break label730;
        }
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label735;
        }
        i1 = paramInt1 + ((com.tencent.mm.view.recyclerview.i)localObject1).agOb.size();
        i2 = ANY;
        f = i2;
        locald = new d(false, null, 255);
        if (i <= j)
        {
          paramInt1 = 2147483647;
          k = i;
        }
      }
    }
    label531:
    label1044:
    label1177:
    for (;;)
    {
      localObject1 = paramRecyclerView.fT(k);
      label437:
      label464:
      int m;
      View localView;
      if ((localObject1 instanceof com.tencent.mm.view.recyclerview.j))
      {
        localObject2 = (com.tencent.mm.view.recyclerview.j)localObject1;
        if (localObject2 == null) {
          break label1201;
        }
        localObject1 = ((com.tencent.mm.view.recyclerview.j)localObject2).CSA;
        if (!(localObject1 instanceof com.tencent.mm.plugin.finder.model.cc)) {
          break label753;
        }
        localObject3 = (com.tencent.mm.plugin.finder.model.cc)localObject1;
        if (localObject3 == null) {
          break label1201;
        }
        m = ((com.tencent.mm.plugin.finder.model.cc)localObject3).bZB();
        if ((!(localObject3 instanceof BaseFinderFeed)) && (!paramSet.contains(Integer.valueOf(m))) && (!(localObject3 instanceof ca))) {
          break label1201;
        }
        if (!(localObject3 instanceof BaseFinderFeed)) {
          break label759;
        }
        localObject1 = FeedData.Companion;
        localObject1 = FeedData.a.l((BaseFinderFeed)localObject3);
        if (((!(localObject3 instanceof BaseFinderFeed)) && (!(localObject3 instanceof ca))) || ((localObject3 instanceof ad))) {
          break label807;
        }
        localView = ((com.tencent.mm.view.recyclerview.j)localObject2).UH(e.e.media_banner);
        label565:
        GiR.setEmpty();
        if (localView.getGlobalVisibleRect(GiR)) {
          break label817;
        }
        Log.v(TAG, kotlin.g.b.s.X("getGlobalVisibleRect error continue ", GiR));
      }
      label807:
      label817:
      label1201:
      for (;;)
      {
        if (k != j) {
          break label1204;
        }
        locald.GfW.addAll((Collection)localLinkedList);
        if (AIv != locald.feedId)
        {
          Log.i(TAG, "[findCenterFeed] cost=" + (SystemClock.uptimeMillis() - l) + "ms firstFeedIndex=" + i1 + " firstVideoFeedIndex=" + n + ", centerResult=[" + locald + ']');
          AIv = locald.feedId;
        }
        AppMethodBeat.o(333497);
        return locald;
        paramInt2 = 0;
        break label264;
        label718:
        paramInt1 += 1;
        break;
        paramInt1 = -1;
        break label268;
        label730:
        paramInt2 = 0;
        break label359;
        label735:
        paramInt1 += 1;
        break label301;
        label742:
        paramInt1 = -1;
        break label363;
        localObject2 = null;
        break label437;
        label753:
        localObject3 = null;
        break label464;
        label759:
        if ((localObject3 instanceof ca))
        {
          localObject1 = ((ca)localObject3).ecz();
          break label531;
        }
        if ((localObject3 instanceof com.tencent.mm.plugin.finder.feed.au))
        {
          localObject1 = ((com.tencent.mm.plugin.finder.feed.au)localObject3).ecz();
          break label531;
        }
        localObject1 = null;
        break label531;
        localView = ((com.tencent.mm.view.recyclerview.j)localObject2).caK;
        break label565;
        Rect localRect = GiR;
        localRect.top = androidx.core.b.a.clamp(localRect.top, 0, i2);
        localRect = GiR;
        localRect.bottom = androidx.core.b.a.clamp(localRect.bottom, 0, i2);
        if (GiR.height() <= 0)
        {
          Log.v(TAG, kotlin.g.b.s.X("mediaRect.height() error continue ", GiR));
        }
        else
        {
          if ((k == n) && (i1 == n))
          {
            paramInt2 = 0;
            if ((m != 4) && (m != 2013))
            {
              i = paramInt2;
              if (m == 2)
              {
                if ((localObject1 == null) || (((FeedData)localObject1).getHasBgmInfo() != true)) {
                  break label1161;
                }
                m = 1;
                i = paramInt2;
                if (m == 0) {}
              }
            }
            else
            {
              i = paramInt2;
              if (GiR.height() > localView.getHeight() / 2) {
                i = paramInt2 - i2;
              }
            }
            if (i >= paramInt1) {
              break label1201;
            }
            locald.GfT = ((com.tencent.mm.plugin.finder.model.cc)localObject3).bZB();
            locald.GfU = k;
            locald.AIz = ((com.tencent.mm.view.recyclerview.j)localObject2);
            locald.feedId = ((com.tencent.mm.plugin.finder.model.cc)localObject3).bZA();
            locald.feed = ((FeedData)localObject1);
            localObject2 = ((com.tencent.mm.view.recyclerview.j)localObject2).UH(e.e.media_banner);
            if (localObject1 != null) {
              break label1167;
            }
            localObject1 = null;
            localObject3 = aw.Gjk;
            if ((localObject2 != null) && (localObject1 != null))
            {
              localObject2 = (FinderMediaBanner)localObject2;
              if ((((FinderMediaBanner)localObject2).getFocusPosition() >= 0) && (((FinderMediaBanner)localObject2).getFocusPosition() < ((LinkedList)localObject1).size()))
              {
                localObject1 = (dji)kotlin.a.p.ae((List)localObject1, ((FinderMediaBanner)localObject2).getFocusPosition());
                if (localObject1 != null) {
                  break label1177;
                }
                localObject1 = "";
              }
            }
          }
          for (;;)
          {
            locald.setMediaId((String)localObject1);
            localLinkedList.add(d.b(locald));
            paramInt1 = i;
            break;
            paramInt2 = (int)Math.abs(f * 0.4F - GiR.top);
            break label902;
            m = 0;
            break label942;
            localObject1 = ((FeedData)localObject1).getMediaList();
            break label1044;
            localObject2 = ((dji)localObject1).mediaId;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
        }
      }
      label942:
      label1204:
      k += 1;
    }
  }
  
  public static com.tencent.mm.plugin.finder.view.d a(Context paramContext, String paramString, Intent paramIntent, int paramInt, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(333613);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i(TAG, "jump to wx profile %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    if (!Util.isNullOrNil(paramString)) {
      localIntent.putExtra("Username", paramString);
    }
    paramString = w.GEc;
    paramContext = w.a.a(paramContext, localIntent, paramInt, paramb);
    AppMethodBeat.o(333613);
    return paramContext;
  }
  
  public static String a(TextPaint paramTextPaint, String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(333940);
    kotlin.g.b.s.u(paramTextPaint, "paint");
    kotlin.g.b.s.u(paramString1, "preText");
    kotlin.g.b.s.u(paramString2, "ellipseTotalText");
    kotlin.g.b.s.u(paramString3, "endText");
    float f1 = paramTextPaint.measureText(paramString1);
    float f2 = paramTextPaint.measureText(paramString3);
    paramString2 = TextUtils.ellipsize((CharSequence)paramString2, paramTextPaint, paramFloat - f1 - f2, TextUtils.TruncateAt.END);
    paramString1 = new StringBuilder().append(paramString1);
    paramTextPaint = paramString2;
    if (paramString2 == null) {
      paramTextPaint = (CharSequence)"";
    }
    paramTextPaint = paramTextPaint + paramString3;
    AppMethodBeat.o(333940);
    return paramTextPaint;
  }
  
  public static String a(com.tencent.mm.plugin.finder.model.a parama)
  {
    AppMethodBeat.i(333573);
    kotlin.g.b.s.u(parama, "item");
    Object localObject = parama.ECa;
    if (((com.tencent.mm.plugin.finder.storage.av)localObject).eZS())
    {
      parama = new StringBuilder();
      localObject = ((com.tencent.mm.plugin.finder.storage.av)localObject).field_aggregatedContacts.ZXE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FinderContact localFinderContact = (FinderContact)((Iterator)localObject).next();
        parama.append(iq(localFinderContact.username, localFinderContact.nickname)).append("，");
      }
      localObject = parama.toString();
      kotlin.g.b.s.s(localObject, "nickNameList.toString()");
      parama = (com.tencent.mm.plugin.finder.model.a)localObject;
      if (!Util.isNullOrNil((String)localObject))
      {
        parama = ((String)localObject).substring(0, ((String)localObject).length() - 1);
        kotlin.g.b.s.s(parama, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      AppMethodBeat.o(333573);
      return parama;
    }
    parama = iq(((com.tencent.mm.plugin.finder.storage.av)localObject).field_username, ((com.tencent.mm.plugin.finder.storage.av)localObject).field_nickname);
    AppMethodBeat.o(333573);
    return parama;
  }
  
  public static String a(atg paramatg)
  {
    AppMethodBeat.i(333419);
    kotlin.g.b.s.u(paramatg, "event");
    if ((TextUtils.isEmpty((CharSequence)paramatg.ZDL)) || (!qI(paramatg.FOi)))
    {
      paramatg = paramatg.ZDK;
      AppMethodBeat.o(333419);
      return paramatg;
    }
    paramatg = MMApplicationContext.getContext().getString(e.h.finder_activity_share_conversation_wording, new Object[] { paramatg.ZDL, paramatg.ZDK });
    AppMethodBeat.o(333419);
    return paramatg;
  }
  
  public static List<com.tencent.mm.plugin.finder.event.base.g> a(int paramInt1, int paramInt2, RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(333848);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    LinkedList localLinkedList = new LinkedList();
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramInt2))
    {
      paramRecyclerView = kotlin.a.p.J((Collection)localLinkedList);
      AppMethodBeat.o(333848);
      return paramRecyclerView;
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    List localList;
    if ((paramRecyclerView instanceof WxRecyclerAdapter))
    {
      localList = (List)((WxRecyclerAdapter)paramRecyclerView).data;
      if (paramInt1 > paramInt2) {}
    }
    for (;;)
    {
      int i = paramInt1 - ((WxRecyclerAdapter)paramRecyclerView).agOb.size();
      Object localObject1;
      if ((i >= 0) && (i < localList.size()))
      {
        Object localObject2 = (com.tencent.mm.view.recyclerview.a)localList.get(i);
        if ((((com.tencent.mm.view.recyclerview.a)localObject2).bZA() != 0L) && ((localObject2 instanceof com.tencent.mm.plugin.finder.model.cc)))
        {
          localObject1 = new com.tencent.mm.plugin.finder.event.base.g((com.tencent.mm.plugin.finder.model.cc)localObject2, i, (byte)0);
          localObject2 = (l)((WxRecyclerAdapter)paramRecyclerView).agOM.get(((com.tencent.mm.view.recyclerview.a)localObject2).bZA());
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.event.base.g)localObject1).AOo = ((l)localObject2);
          }
          localLinkedList.add(localObject1);
        }
      }
      if (paramInt1 == paramInt2)
      {
        do
        {
          do
          {
            paramRecyclerView = kotlin.a.p.J((Collection)localLinkedList);
            AppMethodBeat.o(333848);
            return paramRecyclerView;
          } while (!(paramRecyclerView instanceof h.b));
          localList = ((h.b)paramRecyclerView).getData();
        } while (paramInt1 > paramInt2);
        for (;;)
        {
          i = ((h.b)paramRecyclerView).Td(paramInt1);
          if ((i >= 0) && (i < localList.size()))
          {
            localObject1 = (BaseFinderFeed)localList.get(i);
            if (((BaseFinderFeed)localObject1).bZA() != 0L) {
              localLinkedList.add(new com.tencent.mm.plugin.finder.event.base.g((com.tencent.mm.plugin.finder.model.cc)localObject1, i, (byte)0));
            }
          }
          if (paramInt1 == paramInt2) {
            break;
          }
          paramInt1 += 1;
        }
      }
      paramInt1 += 1;
    }
  }
  
  public static <T, E> List<E> a(List<? extends T> paramList, Class<E> paramClass)
  {
    AppMethodBeat.i(334004);
    kotlin.g.b.s.u(paramList, "dataList");
    kotlin.g.b.s.u(paramClass, "clazz");
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (paramClass.isInstance(localObject)) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(334004);
    return localList;
  }
  
  public static void a(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.cc> paramList, com.tencent.mm.bx.b paramb, Intent paramIntent, com.tencent.mm.plugin.finder.feed.model.c paramc)
  {
    AppMethodBeat.i(334025);
    kotlin.g.b.s.u(paramList, "feedList");
    kotlin.g.b.s.u(paramIntent, "intent");
    FinderEmptyLoader localFinderEmptyLoader = new FinderEmptyLoader();
    localFinderEmptyLoader.getDataList().addAll((Collection)paramList);
    localFinderEmptyLoader.setLastBuffer(paramb);
    localFinderEmptyLoader.saveCache(paramIntent, paramInt, paramc);
    AppMethodBeat.o(334025);
  }
  
  public static void a(int paramInt, List<? extends com.tencent.mm.plugin.finder.model.cc> paramList, bui parambui)
  {
    AppMethodBeat.i(333923);
    kotlin.g.b.s.u(paramList, "remain");
    LinkedList localLinkedList = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (com.tencent.mm.plugin.finder.model.cc)paramList.next();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      if (!com.tencent.mm.plugin.finder.storage.data.e.a.au(paramInt, ((com.tencent.mm.plugin.finder.model.cc)localObject1).bZA()))
      {
        localObject2 = new byg();
        ((byg)localObject2).hKN = ((com.tencent.mm.plugin.finder.model.cc)localObject1).bZA();
        if ((localObject1 instanceof BaseFinderFeed)) {
          ((byg)localObject2).objectNonceId = ((BaseFinderFeed)localObject1).feedObject.getObjectNonceId();
        }
        if (parambui != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          ((byg)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(((byg)localObject2).hKN, parambui.AJo);
        }
        ((byg)localObject2).hJx = 4;
        localLinkedList.add(localObject2);
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        new com.tencent.mm.plugin.finder.cgi.c((List)localLinkedList, parambui).bFJ();
      }
      AppMethodBeat.o(333923);
      return;
    }
  }
  
  public static void a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(334587);
    byte[] arrayOfByte = BytesTransUtil.getInstance().getBytes(paramLong, false);
    int i = paramInt;
    for (paramInt = j;; paramInt = j)
    {
      j = paramInt + 1;
      paramArrayOfByte[i] = arrayOfByte[paramInt];
      i += 1;
      if (j >= 8)
      {
        AppMethodBeat.o(334587);
        return;
      }
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(334165);
    if localif;
    if.a locala;
    if (BuildInfo.IS_FLAVOR_PURPLE)
    {
      localif = new if();
      localif.hJB.id = paramLong;
      locala = localif.hJB;
      if (!paramBoolean) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      locala.hJD = i;
      localif.hJB.hJC = paramInt;
      localif.hJB.type = 7;
      localif.publish();
      AppMethodBeat.o(334165);
      return;
    }
  }
  
  public static void a(Activity paramActivity, float paramFloat1, float paramFloat2, View paramView, dju paramdju)
  {
    AppMethodBeat.i(333136);
    kotlin.g.b.s.u(paramActivity, "context");
    kotlin.g.b.s.u(paramView, "targetView");
    Object localObject = aw.Gjk;
    paramActivity = aw.a((Context)paramActivity, paramFloat1, paramFloat2);
    int i = ((Number)paramActivity.bsD).intValue();
    int j = ((Number)paramActivity.aiuN).intValue();
    if (paramdju != null)
    {
      paramFloat1 = i / paramFloat1;
      if (Float.compare(1.0F, paramFloat1) != 0)
      {
        localObject = paramdju.aaPK;
        paramActivity = (Activity)localObject;
        if (localObject == null) {
          paramActivity = new byz();
        }
        localObject = new Matrix();
        paramActivity = paramActivity.aaib;
        kotlin.g.b.s.s(paramActivity, "originMatrix.value");
        ((Matrix)localObject).setValues(kotlin.a.p.H((Collection)paramActivity));
        ((Matrix)localObject).postScale(paramFloat1, paramFloat1);
        paramActivity = new float[9];
        ((Matrix)localObject).getValues(paramActivity);
        localObject = paramdju.aaPK;
        if (localObject != null)
        {
          localObject = ((byz)localObject).aaib;
          if (localObject != null) {
            ((LinkedList)localObject).clear();
          }
        }
        localObject = paramdju.aaPK;
        if (localObject != null)
        {
          localObject = ((byz)localObject).aaib;
          if (localObject != null) {
            ((LinkedList)localObject).addAll((Collection)kotlin.a.k.D(paramActivity));
          }
        }
        paramdju.width = i;
        paramdju.height = j;
        paramActivity = paramdju.aaPJ;
        if (paramActivity != null) {
          paramActivity.left = 0;
        }
        paramActivity = paramdju.aaPJ;
        if (paramActivity != null) {
          paramActivity.right = i;
        }
        paramActivity = paramdju.aaPJ;
        if (paramActivity != null) {
          paramActivity.top = j;
        }
        paramActivity = paramdju.aaPJ;
        if (paramActivity != null) {
          paramActivity.bottom = 0;
        }
      }
    }
    paramdju = paramView.getLayoutParams();
    paramActivity = paramdju;
    if (paramdju == null) {
      paramActivity = new ViewGroup.LayoutParams(i, j);
    }
    paramActivity.width = i;
    paramActivity.height = j;
    paramView.setLayoutParams(paramActivity);
    AppMethodBeat.o(333136);
  }
  
  private static final void a(Activity paramActivity, ca.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(334603);
    kotlin.g.b.s.u(paramActivity, "$activity");
    paramDialogInterface = a.GfO;
    a.aK(paramActivity);
    if (parama != null) {
      parama.onCallback(Boolean.TRUE);
    }
    paramActivity = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aQ(7, false);
    AppMethodBeat.o(334603);
  }
  
  public static void a(Context paramContext, boi paramboi, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(333317);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramboi, "location");
    if (Util.isNullOrNil(paramboi.ZWG))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("map_view_type", 7);
      localIntent.putExtra("kwebmap_slat", paramboi.latitude);
      localIntent.putExtra("kwebmap_lng", paramboi.longitude);
      localIntent.putExtra("kwebmap_scale", paramInt);
      String str = paramboi.poiName;
      localObject = str;
      if (Util.isNullOrNil(str)) {
        localObject = paramboi.city;
      }
      localIntent.putExtra("kPoiName", (String)localObject);
      localIntent.putExtra("Kwebmap_locaion", paramboi.ReU);
      localIntent.putExtra("kShowshare", paramBoolean);
      com.tencent.mm.br.c.b(paramContext, "location", ".ui.RedirectUI", localIntent);
      AppMethodBeat.o(333317);
      return;
    }
    Object localObject = am.aixg;
    localObject = com.tencent.mm.protocal.d.Yxq;
    kotlin.g.b.s.s(localObject, "MM_NEAR_LIFE_URI");
    paramboi = String.format((String)localObject, Arrays.copyOf(new Object[] { paramboi.ZWG }, 1));
    kotlin.g.b.s.s(paramboi, "java.lang.String.format(format, *args)");
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramboi);
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    AppMethodBeat.o(333317);
  }
  
  public static void a(View paramView1, View paramView2, float paramFloat, int paramInt, String paramString, final long paramLong)
  {
    AppMethodBeat.i(333480);
    kotlin.g.b.s.u(paramView2, "child");
    boolean bool1;
    int i;
    int j;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    int k;
    boolean bool2;
    if (paramView1 != null)
    {
      Context localContext1 = paramView1.getContext();
      if (localContext1 == null)
      {
        paramView1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(333480);
        throw paramView1;
      }
      Context localContext2 = ((Activity)localContext1).getBaseContext();
      if (localContext2.getResources().getConfiguration().orientation == 1)
      {
        bool1 = true;
        if (!bool1) {
          break label256;
        }
      }
      label256:
      for (i = kotlin.k.k.qv(localContext2.getResources().getDisplayMetrics().widthPixels, localContext2.getResources().getDisplayMetrics().heightPixels);; i = kotlin.k.k.qu(localContext2.getResources().getDisplayMetrics().widthPixels, localContext2.getResources().getDisplayMetrics().heightPixels))
      {
        j = paramInt - (int)((Activity)localContext1).getResources().getDimension(e.c.Edge_10A);
        f1 = 1.0F * paramInt / i;
        f2 = 1.0F * (j - getTopBarHeight()) / i;
        f3 = 1.0F * j / i;
        f4 = 1.0F * (j - efM()) / i;
        f5 = paramInt;
        k = kotlin.h.a.eH(paramInt * 0.05F);
        bool2 = fgj();
        if (!Float.isNaN(paramFloat)) {
          break label438;
        }
        paramView2.getLayoutParams().width = i;
        paramView2.getLayoutParams().height = i;
        paramView1 = paramView1.getLayoutParams();
        if (paramView1 != null) {
          break label286;
        }
        paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(333480);
        throw paramView1;
        bool1 = false;
        break;
      }
      label286:
      paramView1 = (FrameLayout.LayoutParams)paramView1;
      paramView1.topMargin = getTopBarHeight();
      paramView1.bottomMargin = 0;
      paramView1.gravity = 48;
      com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "calculateMedia_radio_error", false, null, false, (kotlin.g.a.a)new d(paramString, paramLong), 28);
      paramInt = -2;
    }
    for (;;)
    {
      Log.i(TAG, "[calculateMediaLayoutParams] source=" + paramInt + " tag=" + paramString + " radio=" + paramFloat + " screenRadio=" + f1 + " avatarFromScreenTopRadio=" + f3 + " avatarFromTopBarRadio=" + f2 + ", isPortrait = " + bool1);
      AppMethodBeat.o(333480);
      return;
      label438:
      if (bool2)
      {
        if (paramFloat >= f1)
        {
          paramView2.getLayoutParams().height = paramInt;
          paramView2.getLayoutParams().width = kotlin.h.a.eH(paramInt / paramFloat);
        }
        for (;;)
        {
          paramView1 = paramView1.getLayoutParams();
          if (paramView1 != null) {
            break;
          }
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
          throw paramView1;
          paramView2.getLayoutParams().width = i;
          paramView2.getLayoutParams().height = kotlin.h.a.eH(i * paramFloat);
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
        paramView2.getLayoutParams().height = kotlin.h.a.eH(i * paramFloat);
        paramView1 = paramView1.getLayoutParams();
        if (paramView1 == null)
        {
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
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
        paramView2.getLayoutParams().width = kotlin.h.a.eH(paramInt / paramFloat);
        paramView2.getLayoutParams().height = paramInt;
        paramView1 = paramView1.getLayoutParams();
        if (paramView1 == null)
        {
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
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
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
          throw paramView1;
        }
        paramView1 = (FrameLayout.LayoutParams)paramView1;
        paramView1.topMargin = 0;
        paramView1.bottomMargin = 0;
        paramView1.gravity = 48;
        paramInt = 3;
      }
      else if (f5 * 0.45F - i * paramFloat / 2.0F >= getTopBarHeight())
      {
        paramView2.getLayoutParams().width = i;
        paramView2.getLayoutParams().height = kotlin.h.a.eH(i * paramFloat);
        paramView1 = paramView1.getLayoutParams();
        if (paramView1 == null)
        {
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
          throw paramView1;
        }
        paramView1 = (FrameLayout.LayoutParams)paramView1;
        paramView1.topMargin = (-k);
        paramView1.bottomMargin = 0;
        paramView1.gravity = 17;
        paramInt = 4;
      }
      else if ((f2 > paramFloat) && (paramFloat >= 1.777778F))
      {
        paramView2.getLayoutParams().width = i;
        paramView2.getLayoutParams().height = kotlin.h.a.eH(i * f4);
        paramView1 = paramView1.getLayoutParams();
        if (paramView1 == null)
        {
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
          throw paramView1;
        }
        paramView1 = (FrameLayout.LayoutParams)paramView1;
        paramView1.topMargin = efM();
        paramView1.bottomMargin = 0;
        paramView1.gravity = 48;
        paramInt = 5;
      }
      else
      {
        paramView2.getLayoutParams().width = i;
        paramView2.getLayoutParams().height = kotlin.h.a.eH(i * paramFloat);
        paramView1 = paramView1.getLayoutParams();
        if (paramView1 == null)
        {
          paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(333480);
          throw paramView1;
        }
        paramView1 = (FrameLayout.LayoutParams)paramView1;
        paramView1.topMargin = getTopBarHeight();
        paramView1.bottomMargin = 0;
        paramView1.gravity = 48;
        paramInt = 6;
      }
    }
  }
  
  public static void a(EditText paramEditText, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(334581);
    ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(paramEditText, parama);
    AppMethodBeat.o(334581);
  }
  
  private static void a(ImageView paramImageView, int paramInt1, String paramString, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(334110);
    paramImageView.setVisibility(0);
    if (paramInt1 > 0)
    {
      Object localObject;
      com.tencent.mm.plugin.finder.loader.p localp;
      switch (paramInt1)
      {
      default: 
        paramImageView.setVisibility(8);
        AppMethodBeat.o(334110);
        return;
      case 1: 
        localObject = (CharSequence)paramString;
        if (localObject != null)
        {
          paramInt1 = i;
          if (((CharSequence)localObject).length() != 0) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 == 0)
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
          paramString = new com.tencent.mm.plugin.finder.loader.s(paramString, com.tencent.mm.plugin.finder.storage.v.FKY);
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          AppMethodBeat.o(334110);
          return;
        }
        if (paramInt2 == 0)
        {
          paramImageView.setImageResource(e.g.icons_filled_star_identify_sold);
          AppMethodBeat.o(334110);
          return;
        }
        paramImageView.setImageDrawable(bb.m(paramImageView.getContext(), e.g.icons_filled_star_identify, com.tencent.mm.cd.a.w(paramImageView.getContext(), e.b.orange_100)));
        AppMethodBeat.o(334110);
        return;
      case 2: 
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCl();
          paramString = new com.tencent.mm.plugin.finder.loader.s(paramString, com.tencent.mm.plugin.finder.storage.v.FKY);
          localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject).a(paramString, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
          AppMethodBeat.o(334110);
          return;
        }
        if (paramInt2 == 0)
        {
          paramImageView.setImageResource(e.g.icons_filled_star_identify_enterprise_sold);
          AppMethodBeat.o(334110);
          return;
        }
        paramImageView.setImageResource(e.g.icons_filled_star_identify_enterprise);
        AppMethodBeat.o(334110);
        return;
      }
      paramImageView.setVisibility(8);
      AppMethodBeat.o(334110);
      return;
    }
    paramImageView.setVisibility(8);
    AppMethodBeat.o(334110);
  }
  
  public static void a(ImageView paramImageView, FinderAuthInfo paramFinderAuthInfo, int paramInt, pu parampu)
  {
    AppMethodBeat.i(334095);
    kotlin.g.b.s.u(paramImageView, "view");
    paramImageView.setVisibility(8);
    Drawable localDrawable = paramImageView.getDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(null);
    }
    if (parampu != null)
    {
      paramFinderAuthInfo = parampu.YTm;
      if (paramFinderAuthInfo != null)
      {
        Log.i(TAG, "set biz authInfo, authType = " + paramFinderAuthInfo.auth_icon_type + ", authIconUrl = " + paramFinderAuthInfo.YRv);
        a(paramImageView, paramFinderAuthInfo.auth_icon_type, paramFinderAuthInfo.YRv, paramInt);
        AppMethodBeat.o(334095);
      }
    }
    else if (paramFinderAuthInfo != null)
    {
      Log.i(TAG, "authType = " + paramFinderAuthInfo.authIconType + ", authIconUrl = " + paramFinderAuthInfo.authIconUrl);
      a(paramImageView, paramFinderAuthInfo.authIconType, paramFinderAuthInfo.authIconUrl, paramInt);
    }
    AppMethodBeat.o(334095);
  }
  
  public static void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(333803);
    kotlin.g.b.s.u(paramTextView, "tv");
    kotlin.g.b.s.u(paramSpannable, "text");
    paramTextView.setOnTouchListener(gS((View)paramTextView));
    AppMethodBeat.o(333803);
  }
  
  public static void a(TextView paramTextView, String paramString, boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(333917);
    kotlin.g.b.s.u(paramTextView, "tv");
    kotlin.g.b.s.u(paramString, "tabName");
    kotlin.g.b.s.u(parama, "onClick");
    Object localObject = paramTextView.getContext().getResources().getString(e.h.nearby_live_square_tab_more_live_tips);
    kotlin.g.b.s.s(localObject, "tv.context.resources.get…quare_tab_more_live_tips)");
    paramString = paramTextView.getContext().getResources().getString(e.h.nearby_live_square_tab_no_live_data_tips, new Object[] { paramString, localObject });
    kotlin.g.b.s.s(paramString, "tv.context.resources.get…   gotoPageTips\n        )");
    int j = kotlin.n.n.a((CharSequence)paramString, (String)localObject, 0, false, 6);
    int i = j + ((String)localObject).length();
    localObject = new SpannableString((CharSequence)paramString);
    if ((j <= 0) || (i > paramString.length()))
    {
      i = paramString.length();
      j = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject).setSpan(new av.k(parama, paramTextView, paramBoolean), j, i, 33);
      paramTextView.setHighlightColor(paramTextView.getContext().getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(333917);
      return;
    }
  }
  
  public static void a(TextView paramTextView, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(333900);
    kotlin.g.b.s.u(paramTextView, "tv");
    kotlin.g.b.s.u(parama, "onClick");
    Object localObject1 = paramTextView.getContext().getResources();
    int i = e.h.finder_go_to_machine_tab_tips;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    localObject1 = ((Resources)localObject1).getString(i, new Object[] { com.tencent.mm.plugin.finder.storage.d.eRK() });
    kotlin.g.b.s.s(localObject1, "tv.context.resources.get…B_TYPE_MACHINE)\n        )");
    localObject2 = paramTextView.getContext().getResources();
    i = e.h.finder_go_to_machine_tab_tips_for_index;
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    localObject2 = ((Resources)localObject2).getString(i, new Object[] { com.tencent.mm.plugin.finder.storage.d.eRK() });
    kotlin.g.b.s.s(localObject2, "tv.context.resources.get…B_TYPE_MACHINE)\n        )");
    int j = kotlin.n.n.a((CharSequence)localObject1, (String)localObject2, 0, false, 6);
    i = j + ((String)localObject2).length();
    localObject2 = new SpannableString((CharSequence)localObject1);
    if ((j <= 0) || (i > ((String)localObject1).length()))
    {
      i = ((String)localObject1).length();
      j = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject2).setSpan(new av.i(parama, paramTextView), j, i, 33);
      paramTextView.setHighlightColor(paramTextView.getContext().getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject2);
      AppMethodBeat.o(333900);
      return;
    }
  }
  
  public static void a(m paramm, View paramView)
  {
    int j = 0;
    AppMethodBeat.i(334527);
    kotlin.g.b.s.u(paramm, "selfContact");
    kotlin.g.b.s.u(paramView, "headerView");
    Object localObject;
    if (com.tencent.mm.plugin.finder.api.c.a(paramm, true) != null)
    {
      i = 1;
      localObject = paramView.findViewById(e.e.biz_title_area);
      if (localObject != null)
      {
        if (i == 0) {
          break label202;
        }
        label50:
        ((View)localObject).setVisibility(j);
      }
      localObject = (TextView)paramView.findViewById(e.e.titleTv2);
      if (localObject != null) {
        if (i == 0) {
          break label208;
        }
      }
    }
    label202:
    label208:
    for (int i = e.h.finder_sheet_post_tip_with_biz_identity;; i = e.h.finder_sheet_post_tip)
    {
      ((TextView)localObject).setText(i);
      paramm = com.tencent.mm.plugin.finder.api.c.a(paramm, true);
      if (paramm != null)
      {
        localObject = (TextView)paramView.findViewById(e.e.nickname);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)paramm.YTl));
        }
        paramView = (ImageView)paramView.findViewById(e.e.avatar);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
          paramm = new com.tencent.mm.plugin.finder.loader.b(paramm.xkY);
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((com.tencent.mm.loader.d)localObject).a(paramm, paramView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        }
      }
      AppMethodBeat.o(334527);
      return;
      i = 0;
      break;
      j = 8;
      break label50;
    }
  }
  
  private static final void a(bo parambo, String paramString)
  {
    AppMethodBeat.i(334694);
    kotlin.g.b.s.u(paramString, "$source");
    if (parambo != null) {}
    Object localObject1;
    try
    {
      localObject1 = (CharSequence)parambo.field_username;
      if (localObject1 == null) {
        break label963;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label968;
      }
    }
    catch (Exception parambo)
    {
      Log.i(TAG, kotlin.g.b.s.X("[deleteMyLocalAccountData]  exception:", parambo.getMessage()));
      Log.printErrStackTrace(TAG, (Throwable)parambo, "", new Object[0]);
      com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "deleteMyLocalAccountData", false, null, false, (kotlin.g.a.a)new h(parambo), 28);
      AppMethodBeat.o(334694);
      throw parambo;
    }
    if (i != 0)
    {
      Log.i(TAG, "[deleteMyLocalAccountData] source:" + paramString + " , deletingInfo empty");
      AppMethodBeat.o(334694);
      return;
    }
    if (parambo != null)
    {
      localObject1 = parambo.field_username;
      if (localObject1 != null) {
        if (((CharSequence)localObject1).length() > 0)
        {
          i = 1;
          break label973;
          label117:
          Log.i(TAG, "[deleteMyLocalAccountData] currentFinderUsername:" + localObject1 + " , source:" + paramString);
          kotlin.g.b.s.s(localObject1, "currentFinderUsername");
          if (((CharSequence)localObject1).length() != 0) {
            break label994;
          }
        }
      }
    }
    label289:
    label947:
    label963:
    label968:
    label973:
    label980:
    label994:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i(TAG, "[deleteMyLocalAccountData] source:" + paramString + " ,currentFinderUsername empty return ");
        AppMethodBeat.o(334694);
        return;
        i = 0;
        break label973;
        i = 0;
        break label980;
      }
      do
      {
        localObject1 = parambo.field_username;
        break label117;
        do
        {
          localObject1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acZR, "");
          if (localObject1 == null)
          {
            parambo = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(334694);
            throw parambo;
          }
          localObject1 = (String)localObject1;
          break label117;
          if (parambo == null)
          {
            parambo = new bo();
            parambo.field_username = ((String)localObject1);
            parambo.field_type = 1;
            ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().insert((IAutoDBItem)parambo);
          }
          for (;;)
          {
            ak localak = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage();
            com.tencent.mm.plugin.finder.storage.g localg = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage();
            Object localObject2 = localak.aAI((String)localObject1);
            String str = TAG;
            if (localObject2 == null) {}
            for (paramString = null;; paramString = Integer.valueOf(((LinkedList)localObject2).size()))
            {
              Log.i(str, kotlin.g.b.s.X("[deleteMyLocalAccountData] sessionInfoList.size:", paramString));
              if (localObject2 == null) {
                break;
              }
              paramString = ((Iterable)localObject2).iterator();
              i = 0;
              while (paramString.hasNext())
              {
                localObject2 = paramString.next();
                if (i < 0) {
                  kotlin.a.p.kkW();
                }
                localObject2 = ((o)localObject2).field_sessionId;
                kotlin.g.b.s.s(localObject2, "finderSessionInfo.field_sessionId");
                localObject2 = localg.aAz((String)localObject2);
                bool = localg.deleteNotify(((com.tencent.mm.plugin.finder.conv.b)localObject2).systemRowid, false);
                Log.i(TAG, "[deleteMyLocalAccountData] delete conv begin[" + bool + "]... " + ((com.tencent.mm.plugin.finder.conv.b)localObject2).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.b)localObject2).field_sessionId);
                if (bool) {
                  br.a(((com.tencent.mm.plugin.finder.conv.b)localObject2).field_sessionId, (br.a)new g((com.tencent.mm.plugin.finder.conv.b)localObject2));
                }
                str = ((com.tencent.mm.plugin.finder.conv.b)localObject2).field_sessionId;
                kotlin.g.b.s.s(str, "conv.field_sessionId");
                localak.aAJ(str);
                localak.doNotify(((com.tencent.mm.plugin.finder.conv.b)localObject2).field_sessionId, 6, localObject2);
                Log.i(TAG, "[deleteMyLocalAccountData] delete conv end... " + ((com.tencent.mm.plugin.finder.conv.b)localObject2).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.b)localObject2).field_sessionId);
                i += 1;
              }
            }
            paramString = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
            com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().remove(localObject1);
            paramString = com.tencent.mm.plugin.finder.api.d.AwY;
            kotlin.g.b.s.u(localObject1, "username");
            Log.d(com.tencent.mm.plugin.finder.api.d.access$getTAG$cp(), "delete contact %s", new Object[] { localObject1 });
            if (!Util.isNullOrNil((String)localObject1))
            {
              paramString = com.tencent.mm.plugin.finder.api.d.dUb();
              kotlin.g.b.s.u(localObject1, "key");
              paramString.AwX.remove(localObject1);
              ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().aDW((String)localObject1);
              paramString = kotlin.g.b.s.X("DELETE FROM FinderContact WHERE username = ", com.tencent.mm.storagebase.h.EQ((String)localObject1));
              localObject1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).getContactStorage();
              if (localObject1 != null) {
                break label947;
              }
            }
            for (boolean bool = false;; bool = ((com.tencent.mm.plugin.finder.storage.f)localObject1).execSQL("FinderContact", paramString))
            {
              Log.d(com.tencent.mm.plugin.finder.api.d.access$getTAG$cp(), "delete success %s", new Object[] { Boolean.valueOf(bool) });
              if ((bool) && (localObject1 != null)) {
                ((com.tencent.mm.plugin.finder.storage.f)localObject1).doNotify("FinderContact", 5, localObject1);
              }
              paramString = com.tencent.mm.plugin.finder.storage.data.k.FNg;
              com.tencent.mm.plugin.finder.storage.data.k.a.faj();
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acZR, "");
              paramString = com.tencent.mm.plugin.finder.api.d.AwY;
              d.a.dUf();
              ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().delete((IAutoDBItem)parambo, new String[] { "username" });
              AppMethodBeat.o(334694);
              return;
            }
          }
          i = 1;
          break;
          i = 0;
          break;
          if (i != 1) {
            break label289;
          }
          i = 1;
        } while (i == 0);
      } while (parambo != null);
      localObject1 = null;
      break label117;
    }
  }
  
  private static final void a(ca.a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(334607);
    if (parama != null) {
      parama.onCallback(Boolean.FALSE);
    }
    parama = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aQ(7, false);
    AppMethodBeat.o(334607);
  }
  
  public static void a(bcz parambcz, Boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(334434);
    kotlin.g.b.s.u(parambcz, "aliasInfo");
    kotlin.g.b.s.u(paramString, "source");
    for (;;)
    {
      int i;
      try
      {
        localObject1 = com.tencent.mm.kernel.h.baE().ban().b(at.a.acZY, "");
        Log.i(TAG, "[processFinderAliasSync] source:" + paramString + ", status:" + parambcz.ZNL + " , userName:" + parambcz.ZNJ + " , avatar:" + parambcz.xkY + " , currentAliasUserName:" + localObject1);
        i = parambcz.ZNL;
        switch (i)
        {
        default: 
          AppMethodBeat.o(334434);
          return;
        }
      }
      catch (Exception parambcz)
      {
        Log.printDebugStack(TAG, "", new Object[] { parambcz });
        AppMethodBeat.o(334434);
        return;
      }
      paramString = parambcz.ZNJ;
      if (paramString != null)
      {
        if (((CharSequence)paramString).length() == 0)
        {
          i = 1;
          if (i == 0)
          {
            kotlin.g.b.s.s(localObject1, "currentAliasUserName");
            if (((CharSequence)localObject1).length() > 0)
            {
              i = 1;
              if ((i == 0) || (kotlin.g.b.s.p(localObject1, parambcz.ZNJ))) {
                break label300;
              }
            }
          }
          else
          {
            Log.i(TAG, "processFinderAliasSync ask to change alias info,but alias_msg_name is not legal, alias_msg_name:" + parambcz.ZNJ + ",currentAlias:" + localObject1);
            AppMethodBeat.o(334434);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
        continue;
      }
      label300:
      Object localObject2 = new m();
      Object localObject1 = parambcz.nickname;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((m)localObject2).setNickname(paramString);
      localObject1 = parambcz.xkY;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((m)localObject2).auZ(paramString);
      if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE))
      {
        localObject1 = parambcz.ZNJ;
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((m)localObject2).setUsername(paramString);
      }
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMsgAliasContactStorage().j((m)localObject2);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      at.a locala = at.a.acZZ;
      localObject1 = parambcz.nickname;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((aq)localObject2).set(locala, paramString);
      localObject2 = com.tencent.mm.kernel.h.baE().ban();
      locala = at.a.adaa;
      localObject1 = parambcz.xkY;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((aq)localObject2).set(locala, paramString);
      if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE))
      {
        paramString = com.tencent.mm.kernel.h.baE().ban();
        localObject1 = at.a.acZY;
        paramBoolean = parambcz.ZNJ;
        parambcz = paramBoolean;
        if (paramBoolean == null) {
          parambcz = "";
        }
        paramString.set((at.a)localObject1, parambcz);
        AppMethodBeat.o(334434);
        return;
        b("processFinderAliasSync", null);
      }
    }
  }
  
  public static void a(com.tencent.mm.view.recyclerview.j paramj, String paramString, com.tencent.mm.plugin.finder.model.t paramt)
  {
    AppMethodBeat.i(333592);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramString, "feedUserName");
    kotlin.g.b.s.u(paramt, "item");
    Intent localIntent = new Intent();
    int i = 5;
    if ((!Util.isNullOrNil(paramString)) && (kotlin.g.b.s.p(paramString, com.tencent.mm.model.z.bAW())))
    {
      localIntent.putExtra("IsPoster", true);
      if ((paramt.ECu.eZI().blacklist_flag == 0) && (!Util.isNullOrNil(paramt.ECu.getUsername())) && (!com.tencent.mm.model.z.bAM().equals(paramt.ECu.getUsername()))) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("feedUser", paramString);
      i = 3;
      localIntent.putExtra("Avatar", paramt.ECu.exZ());
      localIntent.putExtra("Nickname", paramt.ECu.getNickname());
      localIntent.putExtra("CommentId", paramt.ECu.eZI().commentId);
      localIntent.putExtra("FeedId", paramt.ECu.field_feedId);
      localIntent.putExtra("FeedNonceId", paramt.ECu.field_objectNonceId);
      localIntent.putExtra("V5UserName", paramt.ECu.getUsername());
      paramString = paramt.ECu.eZI();
      if ((paramString != null) && (paramString.msgInfo != null))
      {
        paramString = paramt.ECu.eZI().msgInfo;
        if (paramString != null) {
          break label350;
        }
      }
    }
    label350:
    for (paramString = null;; paramString = paramString.toByteArray())
    {
      localIntent.putExtra("ContactMsgInfo", paramString);
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      b(paramj, paramt.ECu.getUsername(), localIntent, i);
      if (paramt.ECu.eZI() != null) {
        break label358;
      }
      Log.i(TAG, "commentInfo = null");
      AppMethodBeat.o(333592);
      return;
      localIntent.putExtra("Action", 2);
      localIntent.putExtra("IsPoster", false);
      break;
    }
    label358:
    if (paramt.ECu.eZI().msgInfo == null) {
      Log.i(TAG, "msgInfo is null ,feedId:" + paramt.ECu.field_feedId + ",comentId:" + paramt.ECu.eZI().commentId);
    }
    AppMethodBeat.o(333592);
  }
  
  public static void a(com.tencent.mm.view.recyclerview.j paramj, String paramString, com.tencent.mm.plugin.finder.uniComments.storge.d paramd)
  {
    AppMethodBeat.i(333603);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramString, "feedUserName");
    kotlin.g.b.s.u(paramd, "item");
    Intent localIntent = new Intent();
    int i = 5;
    if ((!Util.isNullOrNil(paramString)) && (kotlin.g.b.s.p(paramString, com.tencent.mm.model.z.bAW())))
    {
      localIntent.putExtra("IsPoster", true);
      if ((paramd.Gbp.eZI().blacklist_flag == 0) && (!Util.isNullOrNil(paramd.Gbp.getUsername())) && (!com.tencent.mm.model.z.bAM().equals(paramd.Gbp.getUsername()))) {
        localIntent.putExtra("Action", 1);
      }
      localIntent.putExtra("feedUser", paramString);
      i = 3;
      localIntent.putExtra("Avatar", paramd.Gbp.exZ());
      localIntent.putExtra("Nickname", paramd.Gbp.getNickname());
      localIntent.putExtra("FeedNonceId", paramd.Gbp.field_objectNonceId);
      localIntent.putExtra("V5UserName", paramd.Gbp.getUsername());
      paramString = paramd.Gbp.eZI();
      if ((paramString != null) && (paramString.msgInfo != null))
      {
        paramString = paramd.Gbp.eZI().msgInfo;
        if (paramString != null) {
          break label315;
        }
      }
    }
    label315:
    for (paramString = null;; paramString = paramString.toByteArray())
    {
      localIntent.putExtra("ContactMsgInfo", paramString);
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      b(paramj, paramd.Gbp.getUsername(), localIntent, i);
      if (paramd.Gbp.eZI() != null) {
        break label323;
      }
      Log.i(TAG, "commentInfo = null");
      AppMethodBeat.o(333603);
      return;
      localIntent.putExtra("Action", 2);
      localIntent.putExtra("IsPoster", false);
      break;
    }
    label323:
    if (paramd.Gbp.eZI().msgInfo == null) {
      Log.i(TAG, "msgInfo is null ,feedId:" + paramd.Gbp.field_feedId + ",comentId:" + paramd.Gbp.eZI().commentId);
    }
    AppMethodBeat.o(333603);
  }
  
  private static final void a(l paraml, ViewParent paramViewParent)
  {
    AppMethodBeat.i(334669);
    kotlin.g.b.s.u(paraml, "$showInfo");
    kotlin.g.b.s.u(paramViewParent, "$foldedParent");
    paraml.agOv = ((View)paramViewParent).getTop();
    if (paraml.agOu - paraml.agOt - paraml.agOs > paraml.agOv)
    {
      if (!paraml.agOw)
      {
        paraml.agOw = true;
        paraml = paraml.agOz;
        if (paraml != null)
        {
          paraml = (WxRecyclerAdapter)paraml.get();
          if (paraml != null)
          {
            paraml.onResume();
            AppMethodBeat.o(334669);
          }
        }
      }
    }
    else if (paraml.agOw)
    {
      paraml.agOw = false;
      paraml.agOx = true;
    }
    AppMethodBeat.o(334669);
  }
  
  public static void a(String paramString, bo parambo)
  {
    AppMethodBeat.i(334385);
    kotlin.g.b.s.u(paramString, "source");
    com.tencent.threadpool.h.ahAA.bn(new av..ExternalSyntheticLambda11(parambo, paramString));
    AppMethodBeat.o(334385);
  }
  
  public static void a(LinkedList<FinderCommentInfo> paramLinkedList, long paramLong1, long paramLong2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(167960);
    kotlin.g.b.s.u(paramLinkedList, "commentList");
    kotlin.g.b.s.u(paramString, "clientId");
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
            break label179;
          }
        }
      }
    }
    Object localObject;
    label179:
    do
    {
      for (;;)
      {
        if (i >= 0)
        {
          paramLinkedList.remove(i);
          Log.i(TAG, kotlin.g.b.s.X("update expose commentList, remove at ", Integer.valueOf(i)));
          paramString = new it();
          paramString.hKk.feedId = paramLong1;
          localObject = paramString.hKk;
          brh localbrh = new brh();
          localbrh.commentList = paramLinkedList;
          paramLinkedList = ah.aiuX;
          ((it.a)localObject).hKl = localbrh;
          paramString.publish();
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
        break label248;
      }
    } while (kotlin.g.b.s.p(((FinderCommentInfo)((Iterator)localObject).next()).client_id, paramString));
    for (;;)
    {
      i += 1;
      break;
      label248:
      i = -1;
    }
  }
  
  private static final void a(boolean paramBoolean, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(334624);
    com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).reportPostRedDot(11);
    }
    for (;;)
    {
      paramDialogInterface = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.SA(5);
      AppMethodBeat.o(334624);
      return;
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).reportPostRedDot(13);
    }
  }
  
  private static final void a(boolean paramBoolean, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(334619);
    com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).reportPostRedDot(11);
    }
    for (;;)
    {
      paramDialogInterface = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.SA(5);
      AppMethodBeat.o(334619);
      return;
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).reportPostRedDot(13);
    }
  }
  
  private static final void a(boolean paramBoolean, bys parambys, Context paramContext, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(334614);
    kotlin.g.b.s.u(paramContext, "$activity");
    com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
    if (paramBoolean) {
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).reportPostRedDot(10);
    }
    for (;;)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("key_create_scene", 1);
      if (parambys != null) {
        paramDialogInterface.putExtra("key_prepare_resp", parambys.toByteArray());
      }
      a.GfO.x(paramContext, paramDialogInterface);
      AppMethodBeat.o(334614);
      return;
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).reportPostRedDot(12);
    }
  }
  
  public static boolean a(Context paramContext, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(334338);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).el(paramContext);
    if (paramContext == null)
    {
      i = 0;
      if ((i == 1) || (i == 8)) {
        break label84;
      }
      if (paramFinderItem != null) {
        break label76;
      }
    }
    label76:
    for (int i = 0;; i = paramFinderItem.getMediaType())
    {
      if (i == 9) {
        break label84;
      }
      AppMethodBeat.o(334338);
      return true;
      i = paramContext.fow();
      break;
    }
    label84:
    AppMethodBeat.o(334338);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean, bys parambys)
  {
    AppMethodBeat.i(333187);
    kotlin.g.b.s.u(paramContext, "activity");
    if (Util.isNullOrNil(com.tencent.mm.model.z.bAW()))
    {
      Log.i(TAG, "need create finder contact");
      String str = paramContext.getString(e.h.finder_create_contact_dialog_tip);
      kotlin.g.b.s.s(str, "activity.getString(R.str…reate_contact_dialog_tip)");
      if (!Util.isNullOrNil(paramString)) {
        str = String.valueOf(paramString);
      }
      paramString = com.tencent.mm.plugin.finder.view.c.GwQ;
      com.tencent.mm.plugin.finder.view.c.a.a(paramContext, paramContext.getString(e.h.finder_create_contact_title), str, paramContext.getString(e.h.finder_create_contact_ok), paramContext.getString(e.h.finder_create_contact_cancel), new av..ExternalSyntheticLambda3(paramBoolean, parambys, paramContext), new av..ExternalSyntheticLambda2(paramBoolean), new av..ExternalSyntheticLambda4(paramBoolean));
      AppMethodBeat.o(333187);
      return false;
    }
    AppMethodBeat.o(333187);
    return true;
  }
  
  public static boolean a(FinderObject paramFinderObject, String paramString)
  {
    AppMethodBeat.i(333239);
    kotlin.g.b.s.u(paramFinderObject, "obj");
    kotlin.g.b.s.u(paramString, "invokeSource");
    FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
    int i;
    if (localFinderObjectDesc == null)
    {
      i = 0;
      paramFinderObject = paramFinderObject.liveInfo;
      if (paramFinderObject != null) {
        break label134;
      }
    }
    label134:
    for (paramFinderObject = null;; paramFinderObject = Integer.valueOf(paramFinderObject.liveStatus))
    {
      Log.d(TAG, paramString + " isAcceptLiveObj mediaType:" + i + " liveState:" + paramFinderObject);
      if (i == 9) {
        break label145;
      }
      Log.w(TAG, paramString + " isAcceptLiveObj return for invalid mediaType:" + i);
      AppMethodBeat.o(333239);
      return false;
      i = localFinderObjectDesc.mediaType;
      break;
    }
    label145:
    if (paramFinderObject == null) {}
    while (paramFinderObject.intValue() != 2)
    {
      AppMethodBeat.o(333239);
      return true;
    }
    Log.w(TAG, paramString + " isAcceptLiveObj return for invalid liveState:" + paramFinderObject);
    AppMethodBeat.o(333239);
    return false;
  }
  
  public static boolean a(atq paramatq)
  {
    AppMethodBeat.i(334561);
    kotlin.g.b.s.u(paramatq, "attachment");
    if (paramatq.type == 1)
    {
      AppMethodBeat.o(334561);
      return true;
    }
    AppMethodBeat.o(334561);
    return false;
  }
  
  public static boolean a(awx paramawx)
  {
    AppMethodBeat.i(333409);
    if (paramawx == null) {}
    for (paramawx = null; !kotlin.g.b.s.p(" ", paramawx); paramawx = paramawx.ZIm)
    {
      AppMethodBeat.o(333409);
      return true;
    }
    AppMethodBeat.o(333409);
    return false;
  }
  
  public static boolean a(dne paramdne)
  {
    if (paramdne == null) {}
    while ((paramdne.permissionFlag & 0x4) != 0) {
      return false;
    }
    return true;
  }
  
  public static com.tencent.mm.plugin.sight.base.b aBH(String paramString)
  {
    AppMethodBeat.i(167939);
    kotlin.g.b.s.u(paramString, "filePath");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(167939);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.sight.base.f.aVY(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.sight.base.b();
    }
    if ((((com.tencent.mm.plugin.sight.base.b)localObject1).height <= 0) || (((com.tencent.mm.plugin.sight.base.b)localObject1).width <= 0)) {}
    try
    {
      localObject2 = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject2).setDataSource(com.tencent.mm.vfs.y.n(paramString, false));
      ((com.tencent.mm.plugin.sight.base.b)localObject1).width = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(18), 0);
      ((com.tencent.mm.plugin.sight.base.b)localObject1).height = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(19), 0);
      ((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate = Util.getInt(((MediaMetadataRetriever)localObject2).extractMetadata(20), 0);
      ((MediaMetadataRetriever)localObject2).release();
      label124:
      int i = SightVideoJNI.getMp4RotateVFS(paramString);
      Log.i(TAG, "width %d, height %d, rotate %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.sight.base.b)localObject1).width), Integer.valueOf(((com.tencent.mm.plugin.sight.base.b)localObject1).height), Integer.valueOf(i) });
      switch (i)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(167939);
        return localObject1;
        i = ((com.tencent.mm.plugin.sight.base.b)localObject1).height;
        ((com.tencent.mm.plugin.sight.base.b)localObject1).height = ((com.tencent.mm.plugin.sight.base.b)localObject1).width;
        paramString = ah.aiuX;
        ((com.tencent.mm.plugin.sight.base.b)localObject1).width = i;
      }
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
  
  public static boolean aBI(String paramString)
  {
    AppMethodBeat.i(167958);
    aw localaw = aw.Gjk;
    boolean bool = aw.aBI(paramString);
    AppMethodBeat.o(167958);
    return bool;
  }
  
  public static r<Double, Double> aBJ(String paramString)
  {
    AppMethodBeat.i(167965);
    kotlin.g.b.s.u(paramString, "path");
    paramString = com.tencent.mm.vfs.y.n(paramString, false);
    kotlin.g.b.s.checkNotNull(paramString);
    Object localObject = new az(new ExifInterface(paramString));
    paramString = ((az)localObject).Gjs;
    localObject = ((az)localObject).Gjr;
    if ((localObject != null) && (paramString != null))
    {
      paramString = new r(Double.valueOf(((Float)localObject).floatValue()), Double.valueOf(paramString.floatValue()));
      AppMethodBeat.o(167965);
      return paramString;
    }
    AppMethodBeat.o(167965);
    return null;
  }
  
  public static r<Double, Double> aBK(String paramString)
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
      Log.i(TAG, kotlin.g.b.s.X("getVideoLatLong locationString ", paramString));
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label326;
      }
      kotlin.g.b.s.checkNotNull(paramString);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(167966);
        throw paramString;
      }
    }
    finally
    {
      AppMethodBeat.o(167966);
      return null;
    }
    paramString = paramString.toCharArray();
    kotlin.g.b.s.s(paramString, "(this as java.lang.String).toCharArray()");
    Object localObject = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        char c = paramString[i];
        i += 1;
        if ((c == '+') || (c == '-') || (c == '.') || (TextUtils.isDigitsOnly((CharSequence)(String.valueOf(c) + "")))) {
          ((StringBuilder)localObject).append(c);
        }
      }
      else
      {
        paramString = ((StringBuilder)localObject).toString();
        kotlin.g.b.s.s(paramString, "locSb.toString()");
        j = kotlin.n.n.b((CharSequence)paramString, '+');
        i = j;
        if (-1 == j) {
          i = kotlin.n.n.b((CharSequence)paramString, '-');
        }
        localObject = paramString.substring(0, i);
        kotlin.g.b.s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double d = Double.parseDouble((String)localObject);
        paramString = paramString.substring(i);
        kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
        paramString = new r(Double.valueOf(d), Double.valueOf(Double.parseDouble(paramString)));
        AppMethodBeat.o(167966);
        return paramString;
        label326:
        AppMethodBeat.o(167966);
        return null;
      }
    }
  }
  
  public static String aBL(String paramString)
  {
    AppMethodBeat.i(178463);
    kotlin.g.b.s.u(paramString, "desc");
    if (paramString.length() > 5)
    {
      paramString = paramString.substring(0, 5);
      kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = kotlin.g.b.s.X(paramString, "***");
      AppMethodBeat.o(178463);
      return paramString;
    }
    AppMethodBeat.o(178463);
    return paramString;
  }
  
  public static boolean aBM(String paramString)
  {
    AppMethodBeat.i(333704);
    int i;
    if (kotlin.g.b.s.p(paramString, com.tencent.mm.model.z.bAW())) {
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
    }
    for (;;)
    {
      if ((i & 0x800) != 0)
      {
        AppMethodBeat.o(333704);
        return true;
        d.a locala = com.tencent.mm.plugin.finder.api.d.AwY;
        paramString = d.a.auT(paramString);
        if (paramString != null) {
          i = paramString.field_extFlag;
        }
      }
      else
      {
        AppMethodBeat.o(333704);
        return false;
      }
      i = 0;
    }
  }
  
  public static String aBN(String paramString)
  {
    AppMethodBeat.i(334116);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eWM().bmg()).intValue();
    if (paramString == null)
    {
      paramString = "";
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(334116);
      return paramString;
      break;
      paramString = "较短的测试名称";
      continue;
      paramString = "较长的测试名称长长长长长长长长长长长长长长长长";
    }
  }
  
  public static boolean aBO(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(334218);
    kotlin.g.b.s.u(paramString, "path");
    long l1 = System.currentTimeMillis();
    if (!com.tencent.mm.vfs.y.ZC(paramString))
    {
      AppMethodBeat.o(334218);
      return false;
    }
    str2 = null;
    str1 = null;
    try
    {
      paramString = com.tencent.mm.vfs.y.eA(paramString, false);
      str1 = paramString;
      str2 = paramString;
      com.tencent.mm.plugin.a.a locala = com.tencent.mm.plugin.a.c.b(paramString, new byte[8], com.tencent.mm.plugin.a.a.cOI);
      str1 = paramString;
      str2 = paramString;
      long l2 = locala.pDG + 8L;
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
      AppMethodBeat.o(334218);
    }
    AppMethodBeat.o(334218);
    return bool1;
  }
  
  public static String aBP(String paramString)
  {
    AppMethodBeat.i(334323);
    kotlin.g.b.s.u(paramString, "origin");
    aw localaw = aw.Gjk;
    paramString = aw.aBP(paramString);
    AppMethodBeat.o(334323);
    return paramString;
  }
  
  public static int aBQ(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(334374);
    kotlin.g.b.s.u(paramString, "videoFlag");
    paramString = paramString.toLowerCase();
    kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
    String str = com.tencent.mm.plugin.finder.storage.v.FLb.detail;
    if (str == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(334374);
      throw paramString;
    }
    str = str.toLowerCase();
    kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
    if (kotlin.g.b.s.p(paramString, str))
    {
      bool1 = true;
      if (!bool1) {
        break label160;
      }
      bool1 = true;
      label85:
      if (!bool1) {
        break label211;
      }
      bool1 = true;
      label91:
      if (!bool1) {
        break label262;
      }
    }
    for (boolean bool1 = true;; bool1 = kotlin.g.b.s.p(paramString, str))
    {
      if (!bool1) {
        break label313;
      }
      AppMethodBeat.o(334374);
      return 1;
      str = com.tencent.mm.plugin.finder.storage.v.FLd.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break;
      label160:
      str = com.tencent.mm.plugin.finder.storage.v.FLf.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break label85;
      label211:
      str = com.tencent.mm.plugin.finder.storage.v.FLh.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break label91;
      label262:
      str = com.tencent.mm.plugin.finder.storage.v.FLj.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
    }
    label313:
    str = com.tencent.mm.plugin.finder.storage.v.FLc.detail;
    if (str == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(334374);
      throw paramString;
    }
    str = str.toLowerCase();
    kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
    if (kotlin.g.b.s.p(paramString, str))
    {
      bool1 = true;
      if (!bool1) {
        break label452;
      }
      bool1 = true;
      label371:
      if (!bool1) {
        break label503;
      }
      bool1 = true;
      label377:
      if (!bool1) {
        break label554;
      }
      bool1 = true;
      label383:
      if (!bool1) {
        break label605;
      }
    }
    for (bool1 = bool2;; bool1 = kotlin.g.b.s.p(paramString, str))
    {
      if (!bool1) {
        break label656;
      }
      AppMethodBeat.o(334374);
      return 2;
      str = com.tencent.mm.plugin.finder.storage.v.FLe.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break;
      label452:
      str = com.tencent.mm.plugin.finder.storage.v.FLg.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break label371;
      label503:
      str = com.tencent.mm.plugin.finder.storage.v.FLi.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break label377;
      label554:
      str = com.tencent.mm.plugin.finder.storage.v.FLl.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
      bool1 = kotlin.g.b.s.p(paramString, str);
      break label383;
      label605:
      str = com.tencent.mm.plugin.finder.storage.v.FLk.detail;
      if (str == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(334374);
        throw paramString;
      }
      str = str.toLowerCase();
      kotlin.g.b.s.s(str, "(this as java.lang.String).toLowerCase()");
    }
    label656:
    AppMethodBeat.o(334374);
    return 0;
  }
  
  public static boolean aBT(String paramString)
  {
    AppMethodBeat.i(334455);
    aw localaw = aw.Gjk;
    boolean bool = aw.aBT(paramString);
    AppMethodBeat.o(334455);
    return bool;
  }
  
  public static boolean aBU(String paramString)
  {
    AppMethodBeat.i(334520);
    kotlin.g.b.s.u(paramString, "finderUserName");
    d.a locala = com.tencent.mm.plugin.finder.api.d.AwY;
    boolean bool = d.a.dUe().contains(paramString);
    AppMethodBeat.o(334520);
    return bool;
  }
  
  public static boolean aBV(String paramString)
  {
    AppMethodBeat.i(334554);
    kotlin.g.b.s.u(paramString, "talker");
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().aAF(paramString);
    AppMethodBeat.o(334554);
    return bool;
  }
  
  public static String aBy(String paramString)
  {
    AppMethodBeat.i(333258);
    kotlin.g.b.s.u(paramString, "text");
    kotlin.n.k localk = new kotlin.n.k("[一-龥]");
    int n = paramString.length() - 1;
    int j;
    int i;
    int k;
    if (n >= 0)
    {
      j = 0;
      i = 0;
      k = 0;
    }
    for (;;)
    {
      int m = j + 1;
      String str = paramString.substring(j, j + 1);
      kotlin.g.b.s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (localk.bm((CharSequence)str)) {
        k += 1;
      }
      while (k * 2 + i > 14)
      {
        paramString = paramString.substring(0, j);
        kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString = kotlin.g.b.s.X(paramString, "...");
        AppMethodBeat.o(333258);
        return paramString;
        i += 1;
      }
      if (m > n)
      {
        AppMethodBeat.o(333258);
        return paramString;
      }
      j = m;
    }
  }
  
  public static boolean aF(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(333205);
    kotlin.g.b.s.u(paramContext, "context");
    if ((paramInt & 0x40) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        com.tencent.mm.ui.widget.a.g.a locala = new com.tencent.mm.ui.widget.a.g.a(MMApplicationContext.getContext());
        locala.bDE(paramContext.getResources().getString(e.h.finder_message_profile_is_mute)).NF(true);
        locala.aEX(c.g.welcome_i_know).b(av..ExternalSyntheticLambda8.INSTANCE).d(av..ExternalSyntheticLambda5.INSTANCE).show();
      }
      AppMethodBeat.o(333205);
      return bool;
    }
  }
  
  public static void aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(333797);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "wording");
    com.tencent.mm.ui.base.aa.a(paramContext, paramString, av..ExternalSyntheticLambda7.INSTANCE);
    AppMethodBeat.o(333797);
  }
  
  public static String aU(com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(333931);
    kotlin.g.b.s.u(paramcc, "msg");
    if (paramcc.field_isSend == 1)
    {
      paramcc = com.tencent.mm.model.z.bAM();
      kotlin.g.b.s.s(paramcc, "getUsernameFromUserInfo()");
    }
    for (;;)
    {
      AppMethodBeat.o(333931);
      return paramcc;
      if (!com.tencent.mm.storage.au.bwE(paramcc.field_talker)) {
        break;
      }
      paramcc = br.JJ(paramcc.field_content);
      kotlin.g.b.s.s(paramcc, "getGroupChatMsgTalker(msg.content)");
    }
    paramcc = paramcc.field_talker;
    kotlin.g.b.s.s(paramcc, "msg.talker");
    AppMethodBeat.o(333931);
    return paramcc;
  }
  
  public static String aV(com.tencent.mm.storage.cc paramcc)
  {
    AppMethodBeat.i(333948);
    kotlin.g.b.s.u(paramcc, "msg");
    if (paramcc.field_isSend == 1)
    {
      paramcc = paramcc.field_talker;
      kotlin.g.b.s.s(paramcc, "msg.talker");
    }
    for (;;)
    {
      AppMethodBeat.o(333948);
      return paramcc;
      if (com.tencent.mm.storage.au.bwE(paramcc.field_talker))
      {
        paramcc = paramcc.field_talker;
        kotlin.g.b.s.s(paramcc, "msg.talker");
      }
      else
      {
        paramcc = com.tencent.mm.model.z.bAM();
        kotlin.g.b.s.s(paramcc, "getUsernameFromUserInfo()");
      }
    }
  }
  
  private static final void ae(boolean paramBoolean, String paramString) {}
  
  public static boolean ag(long paramLong, int paramInt)
  {
    AppMethodBeat.i(334418);
    Object localObject = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().oC(paramLong);
    int i;
    if (((com.tencent.d.a.a.a.d.a.g)localObject).systemRowid != -1L)
    {
      i = 1;
      if (i == 0) {
        break label70;
      }
      label44:
      if (localObject != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (localObject = null;; localObject = Boolean.valueOf(com.tencent.mm.ae.d.ee(((com.tencent.d.a.a.a.d.a.g)localObject).field_controlFlag, paramInt)))
    {
      if (localObject != null) {
        break label93;
      }
      AppMethodBeat.o(334418);
      return false;
      i = 0;
      break;
      localObject = null;
      break label44;
    }
    label93:
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(334418);
    return bool;
  }
  
  public static boolean aw(int paramInt, long paramLong)
  {
    AppMethodBeat.i(334157);
    if ((paramInt > 0) || ((paramLong != 0L) && (1000L * paramLong < com.tencent.mm.model.cn.bDw())))
    {
      AppMethodBeat.o(334157);
      return true;
    }
    AppMethodBeat.o(334157);
    return false;
  }
  
  public static String b(long paramLong, Context paramContext)
  {
    AppMethodBeat.i(334316);
    kotlin.g.b.s.u(paramContext, "context");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(paramLong));
    int i = localCalendar.get(11);
    String str1;
    if (i < 10)
    {
      str1 = kotlin.g.b.s.X("0", Integer.valueOf(i));
      i = localCalendar.get(12);
      if (i >= 10) {
        break label170;
      }
    }
    label170:
    for (String str2 = kotlin.g.b.s.X("0", Integer.valueOf(i));; str2 = String.valueOf(i))
    {
      paramContext = paramContext.getResources().getString(e.h.finder_campaign_time_date_1, new Object[] { Integer.valueOf(localCalendar.get(1)), Integer.valueOf(localCalendar.get(2) + 1), Integer.valueOf(localCalendar.get(5)), str1, str2 });
      kotlin.g.b.s.s(paramContext, "context.resources.getStr…      minuteStr\n        )");
      AppMethodBeat.o(334316);
      return paramContext;
      str1 = String.valueOf(i);
      break;
    }
  }
  
  public static void b(TextView paramTextView, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(333911);
    kotlin.g.b.s.u(paramTextView, "tv");
    kotlin.g.b.s.u(parama, "onClick");
    Object localObject = paramTextView.getContext().getResources().getString(e.h.nearby_more_reomm_live_tips);
    kotlin.g.b.s.s(localObject, "tv.context.resources.get…rby_more_reomm_live_tips)");
    String str = paramTextView.getContext().getResources().getString(e.h.nearby_no_live_data_tips, new Object[] { localObject });
    kotlin.g.b.s.s(str, "tv.context.resources.get…_data_tips, gotoPageTips)");
    int i = kotlin.n.n.a((CharSequence)str, (String)localObject, 0, false, 6);
    int j = i + ((String)localObject).length();
    localObject = new SpannableString((CharSequence)str);
    if ((i <= 0) || (j > str.length()))
    {
      j = str.length();
      i = 0;
    }
    for (;;)
    {
      ((SpannableString)localObject).setSpan(new av.j(parama, paramTextView), i, j, 33);
      paramTextView.setHighlightColor(paramTextView.getContext().getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(333911);
      return;
    }
  }
  
  private static final void b(bo parambo, String paramString)
  {
    AppMethodBeat.i(334707);
    kotlin.g.b.s.u(paramString, "$source");
    if (parambo != null) {}
    int i;
    try
    {
      localObject1 = (CharSequence)parambo.field_username;
      if (localObject1 == null) {
        break label821;
      }
      if (((CharSequence)localObject1).length() != 0) {
        break label826;
      }
    }
    catch (Exception parambo)
    {
      label117:
      Log.i(TAG, kotlin.g.b.s.X("[delAliasInfo]  exception:", parambo.getMessage()));
      label150:
      Log.printErrStackTrace(TAG, (Throwable)parambo, "", new Object[0]);
      com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT, "delAliasInfo", false, null, false, (kotlin.g.a.a)new f(parambo), 28);
      AppMethodBeat.o(334707);
      throw parambo;
    }
    if (i != 0)
    {
      Log.i(TAG, "[delAliasInfo] source:" + paramString + " , deletingInfo empty");
      AppMethodBeat.o(334707);
      return;
    }
    if (parambo != null)
    {
      localObject1 = parambo.field_username;
      if (localObject1 != null) {
        if (((CharSequence)localObject1).length() > 0)
        {
          i = 1;
          break label831;
          if (i == 0) {
            break label270;
          }
        }
      }
    }
    label265:
    label270:
    for (Object localObject1 = parambo.field_username;; localObject1 = com.tencent.mm.kernel.h.baE().ban().b(at.a.acZY, ""))
    {
      kotlin.g.b.s.s(localObject1, "aliasUserName");
      if (((CharSequence)localObject1).length() != 0) {
        break label841;
      }
      i = 1;
      if (i == 0) {
        break label290;
      }
      Log.i(TAG, "[delAliasInfo] source:" + paramString + " ,aliasUserName empty return ");
      AppMethodBeat.o(334707);
      return;
      i = 0;
      break label831;
      i = 0;
      break;
    }
    label290:
    if (parambo == null)
    {
      parambo = new bo();
      parambo.field_username = ((String)localObject1);
      parambo.field_type = 2;
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().insert((IAutoDBItem)parambo);
      Log.i(TAG, kotlin.g.b.s.X("[delAliasInfo] insert DeletingInfo Result : ", Boolean.valueOf(bool)));
      label349:
      Log.i(TAG, "[delAliasInfo] source:" + paramString + " ,aliasUserName:" + localObject1);
      paramString = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage();
      com.tencent.mm.plugin.finder.storage.g localg = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage();
      Object localObject2 = paramString.aAH((String)localObject1);
      if (localObject2 != null)
      {
        localObject2 = (Iterable)localObject2;
        i = 0;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject3 = ((o)localObject3).field_sessionId;
          kotlin.g.b.s.s(localObject3, "it.field_sessionId");
          localObject3 = localg.aAz((String)localObject3);
          bool = localg.deleteNotify(((com.tencent.mm.plugin.finder.conv.b)localObject3).systemRowid, false);
          Log.i(TAG, "delete conv begin[" + bool + "]... " + ((com.tencent.mm.plugin.finder.conv.b)localObject3).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.b)localObject3).field_sessionId);
          if (bool) {
            br.a(((com.tencent.mm.plugin.finder.conv.b)localObject3).field_sessionId, (br.a)new e((com.tencent.mm.plugin.finder.conv.b)localObject3));
          }
          String str = ((com.tencent.mm.plugin.finder.conv.b)localObject3).field_sessionId;
          kotlin.g.b.s.s(str, "conv.field_sessionId");
          paramString.aAJ(str);
          localg.doNotify(((com.tencent.mm.plugin.finder.conv.b)localObject3).field_sessionId, 6, localObject3);
          Log.i(TAG, "delete conv end... " + ((com.tencent.mm.plugin.finder.conv.b)localObject3).nickname + ' ' + ((com.tencent.mm.plugin.finder.conv.b)localObject3).field_sessionId);
          i += 1;
        }
      }
      paramString = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMsgAliasContactStorage().auT((String)localObject1);
      if (paramString != null)
      {
        if (paramString.systemRowid == -1L) {
          break label808;
        }
        i = 1;
        break label846;
      }
    }
    for (;;)
    {
      label702:
      if (paramString != null) {
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMsgAliasContactStorage().delete(paramString.systemRowid);
      }
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZZ, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adaa, "");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acZY, "");
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderOrAliasDeletingInfoStorage().delete((IAutoDBItem)parambo, new String[] { "username" });
      AppMethodBeat.o(334707);
      return;
      label808:
      i = 0;
      label821:
      label826:
      label831:
      label841:
      label846:
      while (i == 0)
      {
        paramString = null;
        break label702;
        break label349;
        i = 1;
        break;
        i = 0;
        break;
        if (i != 1) {
          break label265;
        }
        i = 1;
        break label117;
        i = 0;
        break label150;
      }
    }
  }
  
  public static void b(String paramString, bo parambo)
  {
    AppMethodBeat.i(334443);
    kotlin.g.b.s.u(paramString, "source");
    com.tencent.threadpool.h.ahAA.bn(new av..ExternalSyntheticLambda10(parambo, paramString));
    AppMethodBeat.o(334443);
  }
  
  private static final boolean b(View paramView1, View paramView2, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(334657);
    kotlin.g.b.s.u(paramView1, "$tv");
    int j = paramMotionEvent.getAction();
    if (paramView2 == null)
    {
      paramView1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(334657);
      throw paramView1;
    }
    TextView localTextView = (TextView)paramView2;
    if ((localTextView.getText() instanceof Spannable))
    {
      paramView2 = localTextView.getText();
      if (paramView2 == null)
      {
        paramView1 = new NullPointerException("null cannot be cast to non-null type android.text.Spannable");
        AppMethodBeat.o(334657);
        throw paramView1;
      }
      paramView2 = (Spannable)paramView2;
      switch (j)
      {
      case 2: 
      default: 
        label120:
        switch (j)
        {
        }
        break;
      }
    }
    for (;;)
    {
      boolean bool = false;
      Log.i(TAG, "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      AppMethodBeat.o(334657);
      return bool;
      paramView2 = (Spannable)new SpannableString(localTextView.getText());
      break;
      Object localObject1 = (ClickableSpan[])paramView2.getSpans(0, paramView2.length(), ClickableSpan.class);
      if (localObject1 == null) {
        break label120;
      }
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof com.tencent.mm.pluginsdk.ui.span.t))
        {
          ((com.tencent.mm.pluginsdk.ui.span.t)localObject2).setIsPressed(false);
          paramView1.invalidate();
        }
        i += 1;
      }
      int m = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      int n = localTextView.getTotalPaddingLeft();
      k = localTextView.getTotalPaddingTop();
      m = m - n + localTextView.getScrollX();
      n = localTextView.getScrollY();
      localObject1 = localTextView.getLayout();
      i = ((Layout)localObject1).getLineForVertical(i - k + n);
      k = ((Layout)localObject1).getOffsetForHorizontal(i, m);
      if (m > ((Layout)localObject1).getLineWidth(i))
      {
        localObject1 = null;
        label392:
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label516;
        }
        localObject1 = localObject1[0];
        switch (j)
        {
        }
      }
      for (;;)
      {
        bool = true;
        break;
        localObject1 = (ClickableSpan[])paramView2.getSpans(k, k, ClickableSpan.class);
        break label392;
        ((ClickableSpan)localObject1).onClick((View)localTextView);
        continue;
        if ((localObject1 instanceof com.tencent.mm.pluginsdk.ui.span.t))
        {
          ((com.tencent.mm.pluginsdk.ui.span.t)localObject1).setIsPressed(true);
          paramView1.invalidate();
        }
        Selection.setSelection(paramView2, paramView2.getSpanStart(localObject1), paramView2.getSpanEnd(localObject1));
      }
      label516:
      Selection.removeSelection(paramView2);
    }
  }
  
  public static boolean b(ca paramca)
  {
    AppMethodBeat.i(333347);
    kotlin.g.b.s.u(paramca, "feed");
    paramca = paramca.contact;
    if (!Util.isNullOrNil(com.tencent.mm.model.z.bAW()))
    {
      if (paramca == null) {}
      for (paramca = null; kotlin.n.n.T(paramca, com.tencent.mm.model.z.bAW(), false); paramca = paramca.username)
      {
        AppMethodBeat.o(333347);
        return true;
      }
    }
    AppMethodBeat.o(333347);
    return false;
  }
  
  public static boolean b(dne paramdne)
  {
    if (paramdne == null) {}
    while ((paramdne.permissionFlag & 0x1) != 0) {
      return false;
    }
    return true;
  }
  
  public static long bUu()
  {
    AppMethodBeat.i(334189);
    long l = ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).bUu();
    AppMethodBeat.o(334189);
    return l;
  }
  
  public static boolean bgV()
  {
    AppMethodBeat.i(334177);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(334177);
      return true;
    }
    AppMethodBeat.o(334177);
    return false;
  }
  
  public static boolean c(dne paramdne)
  {
    if (paramdne == null) {}
    while ((paramdne.permissionFlag & 0x2) != 0) {
      return false;
    }
    return true;
  }
  
  public static String cn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167969);
    if (!Util.isNullOrNil(new String[] { paramString1, paramString2 }))
    {
      paramString1 = MMApplicationContext.getResources().getString(e.h.finder_location_poi, new Object[] { paramString1, paramString2 });
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
  
  public static Bitmap d(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(167968);
    kotlin.g.b.s.u(paramInputStream, "inputStream");
    b.a locala = com.tencent.mm.plugin.gallery.picker.b.b.HJz;
    paramInputStream = b.a.a(paramInputStream, paramInt1, paramInt2, true, false);
    AppMethodBeat.o(167968);
    return paramInputStream;
  }
  
  public static void d(Window paramWindow)
  {
    AppMethodBeat.i(334249);
    kotlin.g.b.s.u(paramWindow, "window");
    com.tencent.mm.ui.aw.c(paramWindow, false);
    com.tencent.mm.ui.aw.d(paramWindow, false);
    AppMethodBeat.o(334249);
  }
  
  public static boolean d(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(334123);
    kotlin.g.b.s.u(paramContext, "context");
    Log.e(TAG, "checkShowCgiErrorAlter: errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
      {
        paramContext = new com.tencent.mm.ui.widget.a.e.a(paramContext);
        paramContext.bDw(paramString);
        paramContext.NC(true);
        paramContext.aER(e.h.app_ok);
        paramContext.jHH().show();
        AppMethodBeat.o(334123);
        return true;
      }
    }
    AppMethodBeat.o(334123);
    return false;
  }
  
  public static int e(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(334015);
    int i = kotlin.k.k.qv(255, kotlin.k.k.qu(0, (int)(255.0F * paramFloat)));
    AppMethodBeat.o(334015);
    return (i << 24) + (0xFFFFFF & paramInt);
  }
  
  public static boolean e(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167956);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    aw localaw = aw.Gjk;
    boolean bool = aw.e(paramBaseFinderFeed);
    AppMethodBeat.o(167956);
    return bool;
  }
  
  public static String eX(String paramString, int paramInt)
  {
    AppMethodBeat.i(167962);
    kotlin.g.b.s.u(paramString, "key");
    aw localaw = aw.Gjk;
    paramString = aw.eX(paramString, paramInt);
    AppMethodBeat.o(167962);
    return paramString;
  }
  
  public static void eY(String paramString, int paramInt)
  {
    AppMethodBeat.i(334290);
    kotlin.g.b.s.u(paramString, "logPrefix");
    aw localaw = aw.Gjk;
    aw.eY(paramString, paramInt);
    AppMethodBeat.o(334290);
  }
  
  public static int efM()
  {
    AppMethodBeat.i(333457);
    int i = ((Number)BqT.getValue()).intValue();
    AppMethodBeat.o(333457);
    return i;
  }
  
  public static float ffN()
  {
    return GiN;
  }
  
  public static Set<Integer> ffO()
  {
    return GiP;
  }
  
  public static Set<Integer> ffP()
  {
    return GiQ;
  }
  
  public static boolean ffR()
  {
    AppMethodBeat.i(178458);
    aw localaw = aw.Gjk;
    boolean bool = aw.ffR();
    AppMethodBeat.o(178458);
    return bool;
  }
  
  public static String ffS()
  {
    AppMethodBeat.i(167953);
    String str = ClipboardHelper.getText().toString();
    if (str == null)
    {
      AppMethodBeat.o(167953);
      return "";
    }
    AppMethodBeat.o(167953);
    return str;
  }
  
  public static long ffU()
  {
    return AIv;
  }
  
  public static boolean ffV()
  {
    AppMethodBeat.i(333652);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x20) != 0)
    {
      AppMethodBeat.o(333652);
      return true;
    }
    AppMethodBeat.o(333652);
    return false;
  }
  
  public static boolean ffW()
  {
    AppMethodBeat.i(333656);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x40000) != 0)
    {
      AppMethodBeat.o(333656);
      return true;
    }
    AppMethodBeat.o(333656);
    return false;
  }
  
  public static boolean ffX()
  {
    AppMethodBeat.i(333660);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x2000) != 0)
    {
      AppMethodBeat.o(333660);
      return true;
    }
    AppMethodBeat.o(333660);
    return false;
  }
  
  public static boolean ffY()
  {
    AppMethodBeat.i(333668);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x4000000) != 0)
    {
      AppMethodBeat.o(333668);
      return true;
    }
    AppMethodBeat.o(333668);
    return false;
  }
  
  public static boolean ffZ()
  {
    AppMethodBeat.i(333683);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x800000) != 0)
    {
      AppMethodBeat.o(333683);
      return true;
    }
    AppMethodBeat.o(333683);
    return false;
  }
  
  public static boolean fga()
  {
    AppMethodBeat.i(333689);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x1000000) != 0)
    {
      AppMethodBeat.o(333689);
      return true;
    }
    AppMethodBeat.o(333689);
    return false;
  }
  
  public static boolean fgb()
  {
    AppMethodBeat.i(333696);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0) & 0x2000000) != 0)
    {
      AppMethodBeat.o(333696);
      return true;
    }
    AppMethodBeat.o(333696);
    return false;
  }
  
  public static int fgc()
  {
    AppMethodBeat.i(333749);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zsw, 0);
    AppMethodBeat.o(333749);
    return i;
  }
  
  public static JSONObject fgd()
  {
    AppMethodBeat.i(333880);
    if (GiS == null)
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("screenwidth", com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()));
      localJSONObject.put("screenheight", com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()));
      GiS = localJSONObject;
    }
    JSONObject localJSONObject = GiS;
    if (localJSONObject == null)
    {
      localJSONObject = new JSONObject();
      AppMethodBeat.o(333880);
      return localJSONObject;
    }
    AppMethodBeat.o(333880);
    return localJSONObject;
  }
  
  public static void fge()
  {
    AppMethodBeat.i(333962);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addx, "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addy, "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addz, "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addA, "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addB, "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addF, Integer.valueOf(0));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addG, Integer.valueOf(0));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addH, Integer.valueOf(0));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addI, Integer.valueOf(0));
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addJ, Integer.valueOf(0));
    AppMethodBeat.o(333962);
  }
  
  public static void fgf()
  {
    AppMethodBeat.i(333970);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.adds, "");
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addC, Integer.valueOf(0));
    AppMethodBeat.o(333970);
  }
  
  public static int fgg()
  {
    boolean bool3 = true;
    int j = 1;
    AppMethodBeat.i(334154);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = ((Number)com.tencent.mm.plugin.finder.storage.d.eTb().bmg()).intValue();
    if (i != -1)
    {
      Log.d(TAG, kotlin.g.b.s.X("harcode user state = ", Integer.valueOf(i)));
      AppMethodBeat.o(334154);
      return i;
    }
    boolean bool1;
    label117:
    boolean bool2;
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0) & 0x2) != 0)
    {
      bool1 = true;
      boolean bool4 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).showPostEntry();
      localObject = (CharSequence)com.tencent.mm.model.z.bAW();
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label196;
      }
      i = 1;
      if (i != 0) {
        break label201;
      }
      bool2 = true;
      label123:
      Log.i(TAG, "[checkUserState] hasCreatedIdentity=" + bool2 + ", showPostEntry=" + bool4 + ", isReviewing=" + bool1);
      if (bool4) {
        break label206;
      }
      Log.i(TAG, "resultState = USER_STATE_NO_POST_QUALITY");
      i = j;
    }
    label320:
    for (;;)
    {
      AppMethodBeat.o(334154);
      return i;
      bool1 = false;
      break;
      label196:
      i = 0;
      break label117;
      label201:
      bool2 = false;
      break label123;
      label206:
      if (bool2)
      {
        localObject = com.tencent.mm.plugin.finder.api.d.AwY;
        localObject = d.a.auT(com.tencent.mm.model.z.bAW());
        kotlin.g.b.s.checkNotNull(localObject);
        bool2 = ((m)localObject).isBlock();
        localObject = com.tencent.mm.plugin.finder.api.d.AwY;
        localObject = d.a.auT(com.tencent.mm.model.z.bAW());
        kotlin.g.b.s.checkNotNull(localObject);
        if (((m)localObject).field_spamStatus == 2) {}
        for (bool1 = bool3;; bool1 = false)
        {
          Log.i(TAG, "[checkUserState] isAccountBlocked=" + bool2 + ", isAccountSilent=" + bool1);
          if (!bool2) {
            break label320;
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
  
  public static void fgh()
  {
    GiT = true;
  }
  
  public static void fgi()
  {
    AppMethodBeat.i(334235);
    if (GiT)
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      GiU = ((Number)com.tencent.mm.plugin.finder.storage.d.eVt().bmg()).intValue();
      locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      GiV = ((Number)com.tencent.mm.plugin.finder.storage.d.eVu().bmg()).intValue();
      GiT = false;
      Log.i(TAG, "[checkResetFullScreenConfig] reset config DISABLE_HALF_SCREEN=" + GiU + " ALLOW_FILLING_FULL_SCREEN_VALUE=" + GiV);
    }
    AppMethodBeat.o(334235);
  }
  
  public static boolean fgj()
  {
    AppMethodBeat.i(334258);
    long l = System.nanoTime();
    if ((com.tencent.mm.ui.aw.jkS()) || (com.tencent.mm.ui.aw.ato())) {}
    for (boolean bool = true;; bool = false)
    {
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "[isFoldableDeviceOrInMagicWindowMode] cost=" + (System.nanoTime() - l) + "ns");
      }
      AppMethodBeat.o(334258);
      return bool;
    }
  }
  
  public static boolean fgk()
  {
    AppMethodBeat.i(334381);
    if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adff, false))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eWo().bmg()).booleanValue()) {}
    }
    else
    {
      AppMethodBeat.o(334381);
      return true;
    }
    AppMethodBeat.o(334381);
    return false;
  }
  
  public static boolean fgl()
  {
    AppMethodBeat.i(334402);
    boolean bool = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
    int i;
    if ((com.tencent.mm.model.z.bAR() & 0x0) == 0L)
    {
      i = 1;
      if ((!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()) || (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).eZD() != 2)) {
        break label97;
      }
    }
    label97:
    for (int j = 1;; j = 0)
    {
      if ((!bool) || (i == 0) || (j != 0)) {
        break label102;
      }
      AppMethodBeat.o(334402);
      return true;
      i = 0;
      break;
    }
    label102:
    AppMethodBeat.o(334402);
    return false;
  }
  
  public static boolean fgm()
  {
    AppMethodBeat.i(334410);
    boolean bool = com.tencent.mm.ae.d.ee(com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaB, 0), 4);
    if (bgV()) {
      Log.i(TAG, kotlin.g.b.s.X("[checkBindPhone] ", Boolean.valueOf(bool)));
    }
    AppMethodBeat.o(334410);
    return bool;
  }
  
  public static String fgn()
  {
    AppMethodBeat.i(334426);
    switch (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 1))
    {
    default: 
      str = com.tencent.mm.model.z.bAM();
      kotlin.g.b.s.s(str, "{\n                Config…mUserInfo()\n            }");
      AppMethodBeat.o(334426);
      return str;
    case 1: 
      str = com.tencent.mm.model.z.bAM();
      kotlin.g.b.s.s(str, "{\n                Config…mUserInfo()\n            }");
      AppMethodBeat.o(334426);
      return str;
    case 2: 
      str = com.tencent.mm.model.z.bAX();
      kotlin.g.b.s.s(str, "{\n                Config…sUsername()\n            }");
      AppMethodBeat.o(334426);
      return str;
    }
    String str = com.tencent.mm.model.z.bAW();
    kotlin.g.b.s.s(str, "{\n                Config…rUsername()\n            }");
    AppMethodBeat.o(334426);
    return str;
  }
  
  public static int fgo()
  {
    AppMethodBeat.i(334465);
    switch (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 1))
    {
    default: 
      AppMethodBeat.o(334465);
      return 2;
    case 1: 
      AppMethodBeat.o(334465);
      return 2;
    case 2: 
      AppMethodBeat.o(334465);
      return 3;
    }
    AppMethodBeat.o(334465);
    return 1;
  }
  
  public static void fgp()
  {
    AppMethodBeat.i(334477);
    boolean bool1 = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adbc, false);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool2 = ((Boolean)com.tencent.mm.plugin.finder.storage.d.eWD().bmg()).booleanValue();
    Log.i(TAG, "[checkOldSessionInfo] hasTrans:" + bool1 + " , ignoreHasTrans:" + bool2);
    final ah.a locala;
    com.tencent.mm.ae.e locale;
    if ((!bool1) || (bool2))
    {
      Log.i(TAG, "[checkOldSessionInfo] begin");
      long l = SystemClock.uptimeMillis();
      localObject = new ah.a();
      ((ah.a)localObject).aiwY = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getSessionInfoStorage().bUc();
      locala = new ah.a();
      locala.aiwY = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage().bUd();
      l = SystemClock.uptimeMillis() - l;
      Log.i(TAG, kotlin.g.b.s.X("[checkOldSessionInfo] end,duration = ", Long.valueOf(l)));
      locale = (com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT;
      if (l <= 10000L) {
        break label301;
      }
      bool1 = true;
      com.tencent.mm.ae.e.a.a(locale, "transOldFinderMsgSessionInfo", bool1, (kotlin.g.a.a)new n(l));
      locale = (com.tencent.mm.ae.e)com.tencent.mm.plugin.findersdk.b.HbT;
      if ((!((ah.a)localObject).aiwY) || (!locala.aiwY)) {
        break label306;
      }
    }
    label301:
    label306:
    for (bool1 = true;; bool1 = false)
    {
      com.tencent.mm.ae.e.a.a(locale, "transOldFinderMsgSessionInfo-result", bool1, null, false, (kotlin.g.a.a)new o((ah.a)localObject, locala), 28);
      if ((((ah.a)localObject).aiwY) && (locala.aiwY)) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adbc, Boolean.TRUE);
      }
      AppMethodBeat.o(334477);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static View.OnTouchListener gS(View paramView)
  {
    AppMethodBeat.i(333822);
    kotlin.g.b.s.u(paramView, "tv");
    paramView = new av..ExternalSyntheticLambda6(paramView);
    AppMethodBeat.o(333822);
    return paramView;
  }
  
  public static void gT(View paramView)
  {
    AppMethodBeat.i(333977);
    if ((paramView != null) && (paramView.getVisibility() != 0)) {
      paramView.setVisibility(0);
    }
    AppMethodBeat.o(333977);
  }
  
  private static final void gV(View paramView)
  {
    AppMethodBeat.i(334642);
    if (paramView != null)
    {
      paramView = (TextView)paramView.findViewById(e.e.toast_text);
      if (paramView != null) {
        paramView.setTextSize(1, 14.0F);
      }
    }
    AppMethodBeat.o(334642);
  }
  
  private static int getTopBarHeight()
  {
    AppMethodBeat.i(333464);
    int i = ((Number)AIn.getValue()).intValue();
    AppMethodBeat.o(333464);
    return i;
  }
  
  public static boolean h(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(334537);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager != null)
    {
      label49:
      int j;
      int i;
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        if (localLayoutManager == null) {
          break label133;
        }
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {
          break label133;
        }
        if (!(paramRecyclerView instanceof WxRecyclerAdapter)) {
          break label118;
        }
        if (paramRecyclerView == null) {
          break label133;
        }
        j = ((LinearLayoutManager)localLayoutManager).Ju();
        paramRecyclerView = (List)((WxRecyclerAdapter)paramRecyclerView).data;
        if (j < 0) {
          break label128;
        }
        if (j >= paramRecyclerView.size()) {
          break label123;
        }
        i = 1;
      }
      for (;;)
      {
        if ((i == 0) || (!(paramRecyclerView.get(j) instanceof com.tencent.mm.plugin.finder.model.y))) {
          break label133;
        }
        AppMethodBeat.o(334537);
        return true;
        localLayoutManager = null;
        break;
        label118:
        paramRecyclerView = null;
        break label49;
        label123:
        i = 0;
        continue;
        label128:
        i = 0;
      }
    }
    label133:
    AppMethodBeat.o(334537);
    return false;
  }
  
  public static float hI(List<? extends dji> paramList)
  {
    AppMethodBeat.i(334264);
    kotlin.g.b.s.u(paramList, "list");
    dji localdji = (dji)kotlin.a.p.oL(paramList);
    if (localdji == null)
    {
      AppMethodBeat.o(334264);
      return 0.75F;
    }
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localdji;
    float f;
    if (localIterator.hasNext())
    {
      localdji = (dji)localIterator.next();
      f = localdji.height * 1.0F / localdji.width;
      if (paramList.height * 1.0F / paramList.width >= f) {
        break label119;
      }
      paramList = localdji;
    }
    label119:
    for (;;)
    {
      break;
      f = paramList.height * 1.0F / paramList.width;
      AppMethodBeat.o(334264);
      return f;
    }
  }
  
  public static float hJ(List<? extends bvj> paramList)
  {
    AppMethodBeat.i(334277);
    kotlin.g.b.s.u(paramList, "list");
    bvj localbvj = (bvj)kotlin.a.p.oL(paramList);
    if (localbvj == null)
    {
      AppMethodBeat.o(334277);
      return 0.75F;
    }
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localbvj;
    float f1;
    if (localIterator.hasNext())
    {
      localbvj = (bvj)localIterator.next();
      f1 = localbvj.height * 1.0F / localbvj.width;
      if (paramList.height * 1.0F / paramList.width >= f1) {
        break label135;
      }
      paramList = localbvj;
    }
    label135:
    for (;;)
    {
      break;
      float f2 = paramList.height * 1.0F / paramList.width;
      f1 = f2;
      if (Float.isNaN(f2)) {
        f1 = 1.166667F;
      }
      AppMethodBeat.o(334277);
      return f1;
    }
  }
  
  public static float hK(List<? extends dob> paramList)
  {
    AppMethodBeat.i(334281);
    kotlin.g.b.s.u(paramList, "list");
    dob localdob = (dob)kotlin.a.p.oL(paramList);
    if (localdob == null)
    {
      AppMethodBeat.o(334281);
      return 0.75F;
    }
    Iterator localIterator = ((Iterable)paramList).iterator();
    paramList = localdob;
    float f1;
    if (localIterator.hasNext())
    {
      localdob = (dob)localIterator.next();
      f1 = localdob.height * 1.0F / localdob.width;
      if (paramList.height * 1.0F / paramList.width >= f1) {
        break label135;
      }
      paramList = localdob;
    }
    label135:
    for (;;)
    {
      break;
      float f2 = paramList.height * 1.0F / paramList.width;
      f1 = f2;
      if (Float.isNaN(f2)) {
        f1 = 1.166667F;
      }
      AppMethodBeat.o(334281);
      return f1;
    }
  }
  
  public static void hq(Context paramContext)
  {
    AppMethodBeat.i(333625);
    kotlin.g.b.s.u(paramContext, "context");
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=page/agreement/finder_live_user_event");
    com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(333625);
  }
  
  public static boolean i(dji paramdji)
  {
    boolean bool = false;
    if (paramdji != null)
    {
      paramdji = paramdji.aaDI;
      if ((paramdji == null) || (paramdji.Znj != true)) {
        break label33;
      }
    }
    label33:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static String iq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(333580);
    if (Util.isNullOrNil(paramString1))
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(333580);
        return "";
      }
      AppMethodBeat.o(333580);
      return paramString2;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = k(str, paramString1, false);
    AppMethodBeat.o(333580);
    return paramString1;
  }
  
  public static kotlin.u<Integer, Integer, Integer> ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333149);
    float f = 1.0F * paramInt2 / paramInt1;
    kotlin.u localu = new kotlin.u(Integer.valueOf(ImageView.ScaleType.FIT_XY.ordinal()), Integer.valueOf(GiM), Integer.valueOf((int)(f * GiM)));
    AppMethodBeat.o(333149);
    return localu;
  }
  
  public static r<Integer, Integer> is(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333157);
    if (paramInt2 * 1.0F / paramInt1 > GiN)
    {
      localr = new r(Integer.valueOf(paramInt1), Integer.valueOf((int)(paramInt1 * GiN)));
      AppMethodBeat.o(333157);
      return localr;
    }
    if (paramInt2 * 1.0F / paramInt1 < 1.0F)
    {
      localr = new r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt1));
      AppMethodBeat.o(333157);
      return localr;
    }
    r localr = new r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    AppMethodBeat.o(333157);
    return localr;
  }
  
  public static boolean isDisablePostHalfScreen()
  {
    AppMethodBeat.i(334242);
    fgi();
    if (GiU == 1)
    {
      AppMethodBeat.o(334242);
      return true;
    }
    AppMethodBeat.o(334242);
    return false;
  }
  
  public static boolean isFriend(String paramString)
  {
    AppMethodBeat.i(167952);
    if (paramString == null)
    {
      AppMethodBeat.o(167952);
      return false;
    }
    if ((!kotlin.n.n.rs(paramString, "@stranger")) && (!com.tencent.mm.storage.au.bwV(paramString)) && (!kotlin.g.b.s.p(paramString, com.tencent.mm.model.z.bAM())) && (ab.IR(paramString)))
    {
      AppMethodBeat.o(167952);
      return true;
    }
    AppMethodBeat.o(167952);
    return false;
  }
  
  public static kotlin.u<Integer, Integer, Integer> it(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(333164);
    float f;
    if (paramInt2 * 1.0F / paramInt1 > GiN) {
      f = GiN;
    }
    for (;;)
    {
      kotlin.u localu = new kotlin.u(Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), Integer.valueOf(GiM), Integer.valueOf((int)(f * GiM)));
      AppMethodBeat.o(333164);
      return localu;
      if (paramInt2 * 1.0F / paramInt1 < 1.0F) {
        f = GiO;
      } else {
        f = paramInt2 * 1.0F / paramInt1;
      }
    }
  }
  
  public static int iu(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return (int)(100.0F * paramInt1 / paramInt2);
    }
    return 0;
  }
  
  public static int j(dji paramdji)
  {
    int j = 1;
    if ((paramdji != null) && (paramdji.mediaType == 9)) {
      j = 2;
    }
    for (;;)
    {
      return j;
      if (paramdji != null)
      {
        paramdji = paramdji.aaDI;
        if ((paramdji == null) || (paramdji.Znj != true)) {
          break label48;
        }
      }
      label48:
      for (int i = 1; i == 0; i = 0) {
        return 0;
      }
    }
  }
  
  public static String k(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(333277);
    if (Util.isNullOrNil(paramString1))
    {
      if (paramString2 == null)
      {
        AppMethodBeat.o(333277);
        return "";
      }
      AppMethodBeat.o(333277);
      return paramString2;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = "";
    Object localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
    boolean bool;
    if (paramString1 == null)
    {
      bool = false;
      if (!bool) {
        break label193;
      }
      if (Util.isNullOrNil(paramString2)) {
        break label163;
      }
      if (paramString2 != null) {
        break label157;
      }
      localObject1 = "";
      label80:
      localStringBuffer.append("displayName is is finder contact");
    }
    for (;;)
    {
      if (paramBoolean) {
        Log.i(TAG, "getDisplayName username " + paramString1 + " nickname " + paramString2 + " buf:" + localStringBuffer);
      }
      AppMethodBeat.o(333277);
      return localObject1;
      bool = kotlin.n.n.rs(paramString1, "@finder");
      break;
      label157:
      localObject1 = paramString2;
      break label80;
      label163:
      localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
      kotlin.g.b.s.checkNotNull(paramString1);
      localObject2 = d.a.auT(paramString1);
      if (localObject2 == null) {
        break label80;
      }
      localObject1 = ((m)localObject2).getNickname();
      break label80;
      label193:
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString1);
      if (((int)((com.tencent.mm.contact.d)localObject1).maN != 0) && (!Util.isNullOrNil(((com.tencent.mm.storage.au)localObject1).aSV())))
      {
        localObject1 = ((com.tencent.mm.storage.au)localObject1).aSV();
        kotlin.g.b.s.s(localObject1, "ct.displayRemark");
        localStringBuffer.append(kotlin.g.b.s.X("displayName is ", localObject1));
      }
      else if (!Util.isNullOrNil(paramString2))
      {
        if (paramString2 == null) {
          localObject1 = "";
        } else {
          localObject1 = paramString2;
        }
      }
      else
      {
        localObject1 = ((com.tencent.mm.autogen.b.az)localObject1).field_username;
        kotlin.g.b.s.s(localObject1, "ct.getUsername()");
      }
    }
  }
  
  public static boolean k(dji paramdji)
  {
    AppMethodBeat.i(333838);
    kotlin.g.b.s.u(paramdji, "localFinderMedia");
    if ((paramdji.aaPf) && (paramdji.EDC != null))
    {
      AppMethodBeat.o(333838);
      return true;
    }
    AppMethodBeat.o(333838);
    return false;
  }
  
  public static brq o(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(167959);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    brq localbrq = new brq();
    localbrq.refObjectFlag = 1L;
    if (paramBaseFinderFeed.feedObject.getRefObjectFlag() == 1L) {
      localbrq.refObjectId = paramBaseFinderFeed.feedObject.getRefObjectId();
    }
    for (localbrq.refObjectContact = paramBaseFinderFeed.feedObject.getRefObjectContact();; localbrq.refObjectContact = com.tencent.mm.plugin.finder.api.c.a(paramBaseFinderFeed))
    {
      AppMethodBeat.o(167959);
      return localbrq;
      localbrq.refObjectId = paramBaseFinderFeed.feedObject.getId();
      paramBaseFinderFeed = paramBaseFinderFeed.contact;
      kotlin.g.b.s.checkNotNull(paramBaseFinderFeed);
    }
  }
  
  public static boolean p(BaseFinderFeed paramBaseFinderFeed)
  {
    Object localObject2 = null;
    AppMethodBeat.i(333766);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zsv, true))
    {
      AppMethodBeat.o(333766);
      return false;
    }
    FinderObject localFinderObject = paramBaseFinderFeed.feedObject.getFinderObject();
    kotlin.g.b.s.u(localFinderObject, "obj");
    if (localFinderObject.objectDesc != null)
    {
      localObject1 = localFinderObject.objectDesc;
      if (localObject1 != null) {
        break label173;
      }
      localObject1 = null;
      if (localObject1 != null) {}
    }
    else
    {
      Log.printInfoStack(TAG, kotlin.g.b.s.X("obj ", localFinderObject), new Object[0]);
    }
    Object localObject1 = aw.Gjk;
    Iterable localIterable = (Iterable)aw.fgq();
    localObject1 = localFinderObject.objectDesc;
    if (localObject1 == null)
    {
      localObject1 = null;
      label136:
      if (!kotlin.a.p.a(localIterable, localObject1)) {
        break label208;
      }
      localObject1 = localFinderObject.objectDesc;
      if (localObject1 != null) {
        break label199;
      }
      i = 0;
    }
    for (;;)
    {
      if (i == 4) {
        break label491;
      }
      AppMethodBeat.o(333766);
      return false;
      label173:
      localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);
      break;
      localObject1 = Integer.valueOf(((FinderObjectDesc)localObject1).mediaType);
      break label136;
      label199:
      i = ((FinderObjectDesc)localObject1).mediaType;
      continue;
      label208:
      localObject1 = localFinderObject.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if ((localObject1 != null) && (((LinkedList)localObject1).size() == 0)) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject1 = localFinderObject.objectDesc;
          if (localObject1 == null)
          {
            i = 0;
            break;
            i = 0;
            continue;
          }
          i = ((FinderObjectDesc)localObject1).mediaType;
          break;
        }
      }
      localObject1 = localFinderObject.objectDesc;
      int j;
      if (localObject1 == null)
      {
        j = 0;
        label291:
        localObject1 = aw.Gjk;
        i = j;
        if (!aw.fgq().contains(Integer.valueOf(j))) {
          continue;
        }
        if (j != 4) {
          break label416;
        }
        localObject1 = localFinderObject.objectDesc;
        if (localObject1 != null) {
          break label390;
        }
        i = 0;
      }
      for (;;)
      {
        if (i <= 1) {
          break label416;
        }
        i = 8;
        break;
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 == null)
        {
          j = 0;
          break label291;
        }
        localObject1 = (FinderMedia)((LinkedList)localObject1).get(0);
        if (localObject1 == null)
        {
          j = 0;
          break label291;
        }
        j = ((FinderMedia)localObject1).mediaType;
        break label291;
        label390:
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 == null) {
          i = 0;
        } else {
          i = ((LinkedList)localObject1).size();
        }
      }
      label416:
      localObject1 = localFinderObject.objectDesc;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        i = j;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          } while (((FinderMedia)((Iterator)localObject1).next()).mediaType == j);
          i = 8;
        }
      }
    }
    label491:
    if (paramBaseFinderFeed.feedObject.getLongVideoMediaList().isEmpty())
    {
      paramBaseFinderFeed = localFinderObject.objectDesc;
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = null;
        if (paramBaseFinderFeed != null)
        {
          paramBaseFinderFeed = localFinderObject.objectDesc;
          if (paramBaseFinderFeed == null) {
            break label569;
          }
          paramBaseFinderFeed = paramBaseFinderFeed.media;
          if ((paramBaseFinderFeed == null) || (paramBaseFinderFeed.isEmpty() != true)) {
            break label569;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label574;
        }
        AppMethodBeat.o(333766);
        return false;
        paramBaseFinderFeed = paramBaseFinderFeed.media;
        break;
      }
      paramBaseFinderFeed = localFinderObject.objectDesc;
      if (paramBaseFinderFeed == null) {
        paramBaseFinderFeed = localObject2;
      }
      while (paramBaseFinderFeed == null)
      {
        AppMethodBeat.o(333766);
        return false;
        localObject1 = paramBaseFinderFeed.media;
        paramBaseFinderFeed = localObject2;
        if (localObject1 != null)
        {
          localObject1 = (FinderMedia)((LinkedList)localObject1).getFirst();
          paramBaseFinderFeed = localObject2;
          if (localObject1 != null) {
            paramBaseFinderFeed = Integer.valueOf(((FinderMedia)localObject1).videoDuration);
          }
        }
      }
    }
    label569:
    label574:
    for (int i = paramBaseFinderFeed.intValue();; i = ((dji)paramBaseFinderFeed.feedObject.getLongVideoMediaList().getFirst()).videoDuration)
    {
      long l = Util.getLong(com.tencent.mm.k.i.aRC().getValue("FinderRingToneVideoDurationLimit"), 300L);
      if (i <= l) {
        break;
      }
      AppMethodBeat.o(333766);
      return false;
    }
    if ((localFinderObject.permissionFlag & 0x40) == 0)
    {
      AppMethodBeat.o(333766);
      return true;
    }
    AppMethodBeat.o(333766);
    return false;
  }
  
  public static long q(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(334590);
    paramArrayOfByte = kotlin.a.k.copyOfRange(paramArrayOfByte, paramInt, paramInt + 8);
    long l = BytesTransUtil.getInstance().getLong(paramArrayOfByte, false);
    AppMethodBeat.o(334590);
    return l;
  }
  
  public static boolean q(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(333986);
    kotlin.g.b.s.u(paramBaseFinderFeed, "item");
    if ((paramBaseFinderFeed.feedObject.getFeedObject().incFriendLikeCount > 0) && (paramBaseFinderFeed.feedObject.getFeedObject().msgEventFlag == 1))
    {
      AppMethodBeat.o(333986);
      return true;
    }
    AppMethodBeat.o(333986);
    return false;
  }
  
  public static int qH(long paramLong)
  {
    return (int)(paramLong / 1000L);
  }
  
  public static boolean qI(long paramLong)
  {
    return (paramLong & 1L) != 1L;
  }
  
  public static boolean qJ(long paramLong)
  {
    return (paramLong & 0x2) != 2L;
  }
  
  public static boolean qK(long paramLong)
  {
    return (paramLong & 0x8) != 8L;
  }
  
  public static void qL(long paramLong)
  {
    AIv = paramLong;
  }
  
  public static boolean qN(long paramLong)
  {
    return (paramLong > 2147483647L) || (paramLong < -2147483648L);
  }
  
  public static String r(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(334301);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    if (paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count > 1)
    {
      paramBaseFinderFeed = MMApplicationContext.getContext().getString(e.h.finder_feed_follow_pat_entrance_tips_with_count, new Object[] { Integer.valueOf(paramBaseFinderFeed.feedObject.field_finderObject.follow_feed_count) });
      kotlin.g.b.s.s(paramBaseFinderFeed, "{\n            MMApplicat…              )\n        }");
      AppMethodBeat.o(334301);
      return paramBaseFinderFeed;
    }
    paramBaseFinderFeed = MMApplicationContext.getContext().getString(e.h.finder_feed_follow_pat_entrance_tips);
    kotlin.g.b.s.s(paramBaseFinderFeed, "{\n            MMApplicat…_entrance_tips)\n        }");
    AppMethodBeat.o(334301);
    return paramBaseFinderFeed;
  }
  
  private static final void u(DialogInterface paramDialogInterface) {}
  
  private static String vh(int paramInt)
  {
    AppMethodBeat.i(334505);
    if (paramInt < 10)
    {
      String str = kotlin.g.b.s.X("0", Integer.valueOf(paramInt));
      AppMethodBeat.o(334505);
      return str;
    }
    AppMethodBeat.o(334505);
    return String.valueOf(paramInt);
  }
  
  public static String w(Boolean paramBoolean)
  {
    AppMethodBeat.i(334489);
    ArrayList localArrayList = new ArrayList((Collection)kotlin.a.p.listOf(new String[] { com.tencent.mm.model.z.bAM(), com.tencent.mm.model.z.bAX() }));
    Object localObject1 = "(";
    Object localObject3 = (Iterable)localArrayList;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    label136:
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      String str = (String)localObject4;
      kotlin.g.b.s.s(str, "it");
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
        kotlin.a.p.kkW();
      }
      localObject2 = (String)localObject2;
      localObject2 = (String)localObject1 + "senderUserName = '" + localObject2 + '\'';
      localObject1 = localObject2;
      if (i + 1 < localArrayList.size()) {
        localObject1 = kotlin.g.b.s.X((String)localObject2, " or ");
      }
      i += 1;
    }
    localObject1 = kotlin.n.n.d((String)localObject1, (CharSequence)" or ");
    localObject2 = (String)localObject1 + " or senderUserNameVersion = " + com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbe, 0);
    localObject1 = localObject2;
    if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE)) {
      localObject1 = kotlin.g.b.s.X((String)localObject2, " or talker = 'finderaliassessionholder' or talker = 'findersayhisessionholder'");
    }
    paramBoolean = kotlin.g.b.s.X((String)localObject1, ")");
    AppMethodBeat.o(334489);
    return paramBoolean;
  }
  
  private static final void w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(334713);
    kotlin.g.b.s.u(paramView, "$view");
    Rect localRect = new Rect();
    paramView.getHitRect(localRect);
    localRect.inset(-paramInt1, -paramInt2);
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(334713);
      throw paramView;
    }
    ((View)localViewParent).setTouchDelegate(new TouchDelegate(localRect, paramView));
    AppMethodBeat.o(334713);
  }
  
  public static void w(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(167955);
    kotlin.g.b.s.u(paramList, "list");
    kotlin.g.b.s.u(paramString, "tag");
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
      if (paramList == null) {}
      for (paramList = null;; paramList = paramList.username)
      {
        Log.i(str, paramList);
        i += 1;
        break;
      }
    }
    Log.v(TAG, "---------------------------------------------------------------------printAllItemEnd " + paramString + "---------------------------------------------------------------------");
    AppMethodBeat.o(167955);
  }
  
  public static boolean y(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(167948);
    kotlin.g.b.s.u(paramFinderObject, "obj");
    Object localObject = aw.Gjk;
    localObject = aw.fgq();
    FinderObjectDesc localFinderObjectDesc = paramFinderObject.objectDesc;
    if (localFinderObjectDesc == null) {}
    for (int i = 0; ((List)localObject).contains(Integer.valueOf(i)); i = localFinderObjectDesc.mediaType)
    {
      AppMethodBeat.o(167948);
      return true;
    }
    localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if ((localObject == null) || (((LinkedList)localObject).size() != 0)) {}
    }
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(167948);
      return false;
    }
    localObject = paramFinderObject.objectDesc;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      localObject = aw.Gjk;
      if (aw.fgq().contains(Integer.valueOf(i))) {
        break;
      }
      AppMethodBeat.o(167948);
      return false;
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject == null)
      {
        i = 0;
      }
      else
      {
        localObject = (FinderMedia)((LinkedList)localObject).get(0);
        if (localObject == null) {
          i = 0;
        } else {
          i = ((FinderMedia)localObject).mediaType;
        }
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
            AppMethodBeat.o(167948);
            return false;
          }
        }
      }
    }
    AppMethodBeat.o(167948);
    return true;
  }
  
  public static boolean yi(int paramInt)
  {
    return paramInt == 1;
  }
  
  public final void a(ImageView paramImageView, TextView paramTextView, bvl parambvl, int paramInt)
  {
    AppMethodBeat.i(334817);
    kotlin.g.b.s.u(paramImageView, "authIconView");
    kotlin.g.b.s.u(paramTextView, "nickNameView");
    kotlin.g.b.s.u(parambvl, "shareObject");
    Object localObject = (CharSequence)parambvl.aacW;
    int i;
    label65:
    int j;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label138;
      }
      i = parambvl.authIconType;
      localObject = (CharSequence)parambvl.aacW;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label147;
      }
      j = 1;
      label92:
      if (j == 0) {
        break label153;
      }
    }
    label138:
    label147:
    label153:
    for (parambvl = parambvl.authIconUrl;; parambvl = parambvl.aacY)
    {
      localObject = paramTextView.getLayoutParams();
      if (localObject != null) {
        break label161;
      }
      paramImageView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(334817);
      throw paramImageView;
      i = 0;
      break;
      i = parambvl.aacX;
      break label65;
      j = 0;
      break label92;
    }
    label161:
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    a(paramImageView, i, parambvl);
    switch (i)
    {
    default: 
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(0);
    }
    for (;;)
    {
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(334817);
      return;
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(paramInt);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$ActionMenuInfo;", "", "forwardDisable", "", "snsDisable", "favDisable", "forwardTip", "", "snsTip", "favTip", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFavDisable", "()Z", "getFavTip", "()Ljava/lang/String;", "getForwardDisable", "getForwardTip", "getSnsDisable", "getSnsTip", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final boolean GiW;
    public final boolean GiX;
    public final boolean GiY;
    public final String GiZ;
    public final String Gja;
    public final String Gjb;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(333478);
      this.GiW = paramBoolean1;
      this.GiX = paramBoolean2;
      this.GiY = paramBoolean3;
      this.GiZ = paramString1;
      this.Gja = paramString2;
      this.Gjb = paramString3;
      AppMethodBeat.o(333478);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(333490);
      if (this == paramObject)
      {
        AppMethodBeat.o(333490);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(333490);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.GiW != paramObject.GiW)
      {
        AppMethodBeat.o(333490);
        return false;
      }
      if (this.GiX != paramObject.GiX)
      {
        AppMethodBeat.o(333490);
        return false;
      }
      if (this.GiY != paramObject.GiY)
      {
        AppMethodBeat.o(333490);
        return false;
      }
      if (!kotlin.g.b.s.p(this.GiZ, paramObject.GiZ))
      {
        AppMethodBeat.o(333490);
        return false;
      }
      if (!kotlin.g.b.s.p(this.Gja, paramObject.Gja))
      {
        AppMethodBeat.o(333490);
        return false;
      }
      if (!kotlin.g.b.s.p(this.Gjb, paramObject.Gjb))
      {
        AppMethodBeat.o(333490);
        return false;
      }
      AppMethodBeat.o(333490);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(333482);
      String str = "ActionMenuInfo(forwardDisable=" + this.GiW + ", snsDisable=" + this.GiX + ", favDisable=" + this.GiY + ", forwardTip=" + this.GiZ + ", snsTip=" + this.Gja + ", favTip=" + this.Gjb + ')';
      AppMethodBeat.o(333482);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibilityFeed;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentVisiblityFeedList", "Ljava/util/LinkedList;", "getCurrentVisiblityFeedList", "()Ljava/util/LinkedList;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;)V", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setHolder", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private com.tencent.mm.view.recyclerview.j AIz;
    private com.tencent.mm.plugin.finder.model.cc AOm;
    public final LinkedList<b> Gjc;
    
    public b(com.tencent.mm.plugin.finder.model.cc paramcc, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(333488);
      this.AOm = paramcc;
      this.AIz = paramj;
      this.Gjc = new LinkedList();
      AppMethodBeat.o(333488);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(333518);
      if (this == paramObject)
      {
        AppMethodBeat.o(333518);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(333518);
        return false;
      }
      paramObject = (b)paramObject;
      if (!kotlin.g.b.s.p(this.AOm, paramObject.AOm))
      {
        AppMethodBeat.o(333518);
        return false;
      }
      if (!kotlin.g.b.s.p(this.AIz, paramObject.AIz))
      {
        AppMethodBeat.o(333518);
        return false;
      }
      AppMethodBeat.o(333518);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(333512);
      int i;
      if (this.AOm == null)
      {
        i = 0;
        if (this.AIz != null) {
          break label46;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(333512);
        return i * 31 + j;
        i = this.AOm.hashCode();
        break;
        label46:
        j = this.AIz.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(333504);
      StringBuilder localStringBuilder1 = new StringBuilder("VisibilityFeed:");
      Object localObject = (Iterable)this.Gjc;
      int i = 0;
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject = (b)localObject;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(kotlin.g.b.s.X("[index:", Integer.valueOf(i)));
        StringBuilder localStringBuilder3 = new StringBuilder("type:");
        localObject = ((b)localObject).AOm;
        if (localObject == null) {}
        for (localObject = null;; localObject = Integer.valueOf(((com.tencent.mm.plugin.finder.model.cc)localObject).bZB()))
        {
          localStringBuilder2.append(localObject + ']');
          i += 1;
          break;
        }
      }
      localObject = localStringBuilder1.toString();
      kotlin.g.b.s.s(localObject, "sb.toString()");
      AppMethodBeat.o(333504);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$VisibleFeedDataObj;", "", "feedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "notFeedDataList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Ljava/util/LinkedList;Ljava/util/LinkedList;)V", "getFeedDataList", "()Ljava/util/LinkedList;", "setFeedDataList", "(Ljava/util/LinkedList;)V", "getNotFeedDataList", "setNotFeedDataList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public LinkedList<com.tencent.mm.plugin.finder.event.base.g> Gjd;
    public LinkedList<com.tencent.mm.plugin.finder.model.cc> Gje;
    
    private c(LinkedList<com.tencent.mm.plugin.finder.event.base.g> paramLinkedList, LinkedList<com.tencent.mm.plugin.finder.model.cc> paramLinkedList1)
    {
      AppMethodBeat.i(333483);
      this.Gjd = paramLinkedList;
      this.Gje = paramLinkedList1;
      AppMethodBeat.o(333483);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(333507);
      if (this == paramObject)
      {
        AppMethodBeat.o(333507);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(333507);
        return false;
      }
      paramObject = (c)paramObject;
      if (!kotlin.g.b.s.p(this.Gjd, paramObject.Gjd))
      {
        AppMethodBeat.o(333507);
        return false;
      }
      if (!kotlin.g.b.s.p(this.Gje, paramObject.Gje))
      {
        AppMethodBeat.o(333507);
        return false;
      }
      AppMethodBeat.o(333507);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(333500);
      int i = this.Gjd.hashCode();
      int j = this.Gje.hashCode();
      AppMethodBeat.o(333500);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(333492);
      String str = "VisibleFeedDataObj(feedDataList=" + this.Gjd + ", notFeedDataList=" + this.Gje + ')';
      AppMethodBeat.o(333492);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    d(String paramString, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderUtil$delAliasInfo$1$2$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements br.a
  {
    e(com.tencent.mm.plugin.finder.conv.b paramb) {}
    
    public final boolean aMJ()
    {
      return false;
    }
    
    public final void aMK()
    {
      AppMethodBeat.i(333498);
      Log.i(av.aUw(), "delete msg end... " + this.AFI.nickname + ' ' + this.AFI.field_sessionId);
      AppMethodBeat.o(333498);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    f(Exception paramException)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderUtil$deleteMyLocalAccountData$1$2$1", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements br.a
  {
    g(com.tencent.mm.plugin.finder.conv.b paramb) {}
    
    public final boolean aMJ()
    {
      return false;
    }
    
    public final void aMK()
    {
      AppMethodBeat.i(333385);
      Log.i(av.aUw(), "[deleteMyLocalAccountData] delete msg end... " + this.AFI.nickname + ' ' + this.AFI.field_sessionId);
      AppMethodBeat.o(333385);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    h(Exception paramException)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final m Gjh;
    
    static
    {
      AppMethodBeat.i(333399);
      Gjh = new m();
      AppMethodBeat.o(333399);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    n(long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    o(ah.a parama1, ah.a parama2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.av
 * JD-Core Version:    0.7.0.1
 */