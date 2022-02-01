package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.storage.config.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.k.h;
import d.n.n;
import d.o;
import d.v;
import d.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderConfig;", "", "()V", "ADJUST_AVATAR_ORDER_LIKE", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "getADJUST_AVATAR_ORDER_LIKE", "()Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "AT_SWITCH", "", "getAT_SWITCH", "()Z", "AUTO_FEEDBACK", "Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "getAUTO_FEEDBACK", "()Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "AVATAR_COMPRESS_QUALITY", "getAVATAR_COMPRESS_QUALITY", "()I", "setAVATAR_COMPRESS_QUALITY", "(I)V", "AVATAR_MAX_HEIGHT", "getAVATAR_MAX_HEIGHT", "setAVATAR_MAX_HEIGHT", "AVATAR_MAX_THUMB_WIDTH", "AVATAR_MAX_WIDTH", "getAVATAR_MAX_WIDTH", "setAVATAR_MAX_WIDTH", "AVATAR_UPLOAD_MAX_SIZE", "getAVATAR_UPLOAD_MAX_SIZE", "BG_MERGE", "getBG_MERGE", "Big_File_LENGTH", "getBig_File_LENGTH", "setBig_File_LENGTH", "CAN_BAN_FINDER_COMMENT", "getCAN_BAN_FINDER_COMMENT", "CAN_SHOW_CHANGE_DISTRICT", "getCAN_SHOW_CHANGE_DISTRICT", "setCAN_SHOW_CHANGE_DISTRICT", "(Z)V", "CAN_SWITCH_SCENE", "getCAN_SWITCH_SCENE", "CDN_UPLOAD_CONTROL", "getCDN_UPLOAD_CONTROL", "CHANGE_TO_NO_FINDER_ENTRANCE", "Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "getCHANGE_TO_NO_FINDER_ENTRANCE", "()Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "setCHANGE_TO_NO_FINDER_ENTRANCE", "(Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;)V", "CHECK_FINDER_CACHE", "getCHECK_FINDER_CACHE", "CHECK_TAB_TIP_TEST", "getCHECK_TAB_TIP_TEST", "CLEAR_KEY_BUF", "getCLEAR_KEY_BUF", "setCLEAR_KEY_BUF", "CLEAR_KEY_BUF_DATA", "getCLEAR_KEY_BUF_DATA", "setCLEAR_KEY_BUF_DATA", "CLEAR_MSG_LAST_BUFF", "getCLEAR_MSG_LAST_BUFF", "CLEAR_MUTITAB_NEW_RED_DOT", "getCLEAR_MUTITAB_NEW_RED_DOT", "CLEAR_PNG_VIDEO_CACHE", "getCLEAR_PNG_VIDEO_CACHE", "setCLEAR_PNG_VIDEO_CACHE", "CLEAR_SIMILAR_TIPS", "getCLEAR_SIMILAR_TIPS", "COMMENT_EXPAND", "getCOMMENT_EXPAND", "COMMENT_FRIEND_CAN_CLICK", "getCOMMENT_FRIEND_CAN_CLICK", "COMMENT_FULL_SCREEN", "getCOMMENT_FULL_SCREEN", "COMMENT_PRELOAD_ENABLE", "getCOMMENT_PRELOAD_ENABLE", "COMMENT_PRELOAD_REMAIN_COUNT", "getCOMMENT_PRELOAD_REMAIN_COUNT", "COMMENT_TEXT_LIMIT", "getCOMMENT_TEXT_LIMIT", "COVER_COMPRESS_QUALITY", "getCOVER_COMPRESS_QUALITY", "setCOVER_COMPRESS_QUALITY", "COVER_MAX_HEIGHT", "getCOVER_MAX_HEIGHT", "setCOVER_MAX_HEIGHT", "COVER_MAX_WIDTH", "getCOVER_MAX_WIDTH", "setCOVER_MAX_WIDTH", "CP_TO_CLIPBOARD", "getCP_TO_CLIPBOARD", "Comment_Max_Length", "getComment_Max_Length", "DEBUG_FAV_SIMILAR", "getDEBUG_FAV_SIMILAR", "DEBUG_POST_UPLOAD_BLOCK", "getDEBUG_POST_UPLOAD_BLOCK", "DEBUG_PRIVATE_LIKE_TIPS_COUNT", "getDEBUG_PRIVATE_LIKE_TIPS_COUNT", "setDEBUG_PRIVATE_LIKE_TIPS_COUNT", "DEBUG_SWITCH_SCENE_TIP", "getDEBUG_SWITCH_SCENE_TIP", "setDEBUG_SWITCH_SCENE_TIP", "DEFAULT_FAKE_VIDEO_CONFIG_JSON", "", "DEFAULT_GESTURE_PREVIEW_MEDIA_JSON", "DEFAULT_REPLY_SCENE", "getDEFAULT_REPLY_SCENE", "setDEFAULT_REPLY_SCENE", "DELAY_TIME", "getDELAY_TIME", "setDELAY_TIME", "DOUBLE_CLICK_RESET_FAV_RED_DOT", "getDOUBLE_CLICK_RESET_FAV_RED_DOT", "setDOUBLE_CLICK_RESET_FAV_RED_DOT", "DUMP_FILE_TIME_INTERVAL", "", "getDUMP_FILE_TIME_INTERVAL", "()J", "EDITOR_TRANSITION_MAGIC", "getEDITOR_TRANSITION_MAGIC", "EMPTY_FOOTER_IGNORE_CHECK", "getEMPTY_FOOTER_IGNORE_CHECK", "ENABLE_FINDER_MESSAGE", "getENABLE_FINDER_MESSAGE", "ENABLE_POST_43_RADIO_VIDEO", "getENABLE_POST_43_RADIO_VIDEO", "ENABLE_SHOW_OTHER_PROFILE_FANS", "getENABLE_SHOW_OTHER_PROFILE_FANS", "ENABLE_VIDEO_TEMPLTE", "getENABLE_VIDEO_TEMPLTE", "EXPOSE_COMMENTBTN_SHOW", "getEXPOSE_COMMENTBTN_SHOW", "EXPOSE_COMMENT_SHOW", "getEXPOSE_COMMENT_SHOW", "FAKE_CARD_JUMP_HOT_TAB_DATA", "getFAKE_CARD_JUMP_HOT_TAB_DATA", "FAKE_DATA_IN_SELF_SCENE", "getFAKE_DATA_IN_SELF_SCENE", "FAKE_LOADING_TOAST", "getFAKE_LOADING_TOAST", "FAKE_VIDEO_CONFIG_JSON", "kotlin.jvm.PlatformType", "getFAKE_VIDEO_CONFIG_JSON", "()Ljava/lang/String;", "FEED_ONLY_ME_VISIBLE", "getFEED_ONLY_ME_VISIBLE", "setFEED_ONLY_ME_VISIBLE", "FINDER_CLEAR_CACHE", "getFINDER_CLEAR_CACHE", "FINDER_CREATE_GUIDE_ENTRY", "getFINDER_CREATE_GUIDE_ENTRY", "FINDER_NOTIFY_RED_DOT", "getFINDER_NOTIFY_RED_DOT", "FINDER_NOTIFY_RED_DOT_VALUE", "", "Lkotlin/Pair;", "getFINDER_NOTIFY_RED_DOT_VALUE", "()Ljava/util/List;", "setFINDER_NOTIFY_RED_DOT_VALUE", "(Ljava/util/List;)V", "FINDER_OPEN_GESUTURE", "getFINDER_OPEN_GESUTURE", "FINDER_OPEN_PRELOAD_PREVIEW", "getFINDER_OPEN_PRELOAD_PREVIEW", "FINDER_SELF_STATE", "getFINDER_SELF_STATE", "FINDER_SHARE_MODE", "getFINDER_SHARE_MODE", "FINDER_TIMELINE_REFRESH_EXPIRED", "getFINDER_TIMELINE_REFRESH_EXPIRED", "FINDER_TIMLINE_ENTRY", "getFINDER_TIMLINE_ENTRY", "FOLDED_MORE_ITEM_COUNT", "getFOLDED_MORE_ITEM_COUNT", "FOLDER_MAXSIZE_OF_AVATAR", "getFOLDER_MAXSIZE_OF_AVATAR", "FOLDER_MAXSIZE_OF_CAPTURE", "getFOLDER_MAXSIZE_OF_CAPTURE", "FOLDER_MAXSIZE_OF_COVERIMG", "getFOLDER_MAXSIZE_OF_COVERIMG", "FOLDER_MAXSIZE_OF_IMAGE", "getFOLDER_MAXSIZE_OF_IMAGE", "FOLDER_MAXSIZE_OF_POSTTMP", "getFOLDER_MAXSIZE_OF_POSTTMP", "FOLDER_MAXSIZE_OF_TMP", "getFOLDER_MAXSIZE_OF_TMP", "FOLDER_MAXSIZE_OF_VIDEO", "getFOLDER_MAXSIZE_OF_VIDEO", "FOLDER_SIZE_LEVEL", "", "getFOLDER_SIZE_LEVEL", "()F", "GRID_LAYOUT", "getGRID_LAYOUT", "HIGH_RECORD_BITRATE", "getHIGH_RECORD_BITRATE", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "setIMAGE_COMPRESS_QUALITY", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "IS_ADJUST_FEED_WHEN_OPEN_DRAWER", "getIS_ADJUST_FEED_WHEN_OPEN_DRAWER", "IS_SHOW_FAV_ANIM_UNLIMITED", "getIS_SHOW_FAV_ANIM_UNLIMITED", "IS_USE_VLOG_MODE", "getIS_USE_VLOG_MODE", "IS_VLOG_BACKGROUND_MUX", "getIS_VLOG_BACKGROUND_MUX", "Image_Max_Size", "getImage_Max_Size", "JSAPI_SWITCH", "getJSAPI_SWITCH", "LBS_CGI_ONLY_STREAM", "getLBS_CGI_ONLY_STREAM", "LBS_TAB_LOCATION_DURATION", "getLBS_TAB_LOCATION_DURATION", "LBS_TAB_WAIT_LOCATION_TIME", "getLBS_TAB_WAIT_LOCATION_TIME", "LIKE_COMMENT_EDU", "getLIKE_COMMENT_EDU", "LOAD_IMAGE_ANIM", "getLOAD_IMAGE_ANIM", "MAKE_POST_FAILED", "getMAKE_POST_FAILED", "setMAKE_POST_FAILED", "(Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;)V", "MAKE_POST_MEDIAPROCESS_BLOCKING", "getMAKE_POST_MEDIAPROCESS_BLOCKING", "setMAKE_POST_MEDIAPROCESS_BLOCKING", "MAKE_SEND_COMMENT_FAIL", "getMAKE_SEND_COMMENT_FAIL", "setMAKE_SEND_COMMENT_FAIL", "MARK_READ_OPEN", "getMARK_READ_OPEN", "setMARK_READ_OPEN", "MAX_AT_COUNT", "getMAX_AT_COUNT", "MAX_COMMENT_NAME_COUNT", "getMAX_COMMENT_NAME_COUNT", "MAX_TOPIC_COUNT", "getMAX_TOPIC_COUNT", "MAX_TOPIC_LENGTH", "getMAX_TOPIC_LENGTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_PUBLISH_TEXT_LIMIT", "getMEDIA_PUBLISH_TEXT_LIMIT", "MMFINDER_MORE_LOG", "getMMFINDER_MORE_LOG", "MP_REPUDUCE_SWITCH", "getMP_REPUDUCE_SWITCH", "ONLY_SEARCH_CONTACT", "getONLY_SEARCH_CONTACT", "ONLY_SEE_FEED_TYPE", "getONLY_SEE_FEED_TYPE", "OPEN_FOLLOW_LIST_SEARCH_FLAG", "getOPEN_FOLLOW_LIST_SEARCH_FLAG", "POST_EDUCATION_DESC", "getPOST_EDUCATION_DESC", "POST_EDUCATION_TITLE", "getPOST_EDUCATION_TITLE", "POST_PROGRESS_WEIGHT_MEDIA_PROCESS", "getPOST_PROGRESS_WEIGHT_MEDIA_PROCESS", "POST_PROGRESS_WEIGHT_NETSCENE", "getPOST_PROGRESS_WEIGHT_NETSCENE", "POST_PROGRESS_WEIGHT_UPLOAD", "getPOST_PROGRESS_WEIGHT_UPLOAD", "POST_VIDEO_COVER_COMPRESS_QUALITY", "getPOST_VIDEO_COVER_COMPRESS_QUALITY", "setPOST_VIDEO_COVER_COMPRESS_QUALITY", "PRELOAD_DURATION", "getPRELOAD_DURATION", "PRIVATE_ACCOUNT_ENABLE", "getPRIVATE_ACCOUNT_ENABLE", "value", "PRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "getPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "setPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "PROFILE_SHOW_FANS_COUNT", "getPROFILE_SHOW_FANS_COUNT", "PURE_TEXT_LIMIT", "getPURE_TEXT_LIMIT", "PhoneRemainSpace", "getPhoneRemainSpace", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "RECYCLERVIEW_SPEED", "getRECYCLERVIEW_SPEED", "REDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "getREDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "RED_DOT_NO_TIME_LIMIT", "getRED_DOT_NO_TIME_LIMIT", "REFUSE_ALL_PRIVATE_MSG_SWITCH", "getREFUSE_ALL_PRIVATE_MSG_SWITCH", "REMUX_WITH_ABAPARAMS", "getREMUX_WITH_ABAPARAMS", "REPLY_SCENE", "getREPLY_SCENE", "setREPLY_SCENE", "REPORT_QUALITY_INFO", "getREPORT_QUALITY_INFO", "REPORT_QUALITY_INFO_CONFIG", "getREPORT_QUALITY_INFO_CONFIG", "REPORT_WHEN_SCREEN_SHOT", "getREPORT_WHEN_SCREEN_SHOT", "RESET_CAMERA_RED_DOT", "getRESET_CAMERA_RED_DOT", "setRESET_CAMERA_RED_DOT", "RESET_FIRST_POST_QUALIFICASTION", "getRESET_FIRST_POST_QUALIFICASTION", "RESET_PRIVATE_LIKE_TIPS_COUNT", "getRESET_PRIVATE_LIKE_TIPS_COUNT", "RESET_QUIT_TL_TIME_TO_ZERO", "getRESET_QUIT_TL_TIME_TO_ZERO", "SELECT_DISTRICT", "getSELECT_DISTRICT", "setSELECT_DISTRICT", "SELF_LIKE_EDU", "getSELF_LIKE_EDU", "SELF_PRIVATE_LIKE", "getSELF_PRIVATE_LIKE", "setSELF_PRIVATE_LIKE", "(Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;)V", "SELF_PRIVATE_LIKE_TIPS_COUNT", "getSELF_PRIVATE_LIKE_TIPS_COUNT", "setSELF_PRIVATE_LIKE_TIPS_COUNT", "SHARE_FEED_ENTRANCE", "getSHARE_FEED_ENTRANCE", "SHOW_POST_EDUCATION", "getSHOW_POST_EDUCATION", "SHOW_SELF_FEED_LIKE_TIPS_TIMES", "getSHOW_SELF_FEED_LIKE_TIPS_TIMES", "setSHOW_SELF_FEED_LIKE_TIPS_TIMES", "SIZE_KB", "getSIZE_KB", "SIZE_MB", "getSIZE_MB", "SNS_TO_FINDER_SWITCH", "getSNS_TO_FINDER_SWITCH", "STATS_REPORT_CONTROL", "getSTATS_REPORT_CONTROL", "setSTATS_REPORT_CONTROL", "STREAM_CDN_CONNECTION_COUNT", "getSTREAM_CDN_CONNECTION_COUNT", "setSTREAM_CDN_CONNECTION_COUNT", "SWITCH_FEED_TITLE_STYLE", "getSWITCH_FEED_TITLE_STYLE", "SWITCH_SCENE_TIP", "getSWITCH_SCENE_TIP", "setSWITCH_SCENE_TIP", "SWITC_VIEW_PAGE_TIME", "getSWITC_VIEW_PAGE_TIME", "SYNC_TIME_INTERVAL", "getSYNC_TIME_INTERVAL", "setSYNC_TIME_INTERVAL", "TAG", "TIMELINE_CRASH", "getTIMELINE_CRASH", "setTIMELINE_CRASH", "TIMELINE_ENABLE_SUB_PAGE", "getTIMELINE_ENABLE_SUB_PAGE", "TIMELINE_LIKE_EVENT", "getTIMELINE_LIKE_EVENT", "TIMELINE_LOADING_EXPIRED_TIME", "getTIMELINE_LOADING_EXPIRED_TIME", "TIMELINE_POST_ENTRANCE", "getTIMELINE_POST_ENTRANCE", "TIMELINE_REFRESH_EXPIRED_TIME", "getTIMELINE_REFRESH_EXPIRED_TIME", "TIMELINE_SUB_PAGE_COUNT", "getTIMELINE_SUB_PAGE_COUNT", "TOPIC_JUMP_POI_SWITCH", "getTOPIC_JUMP_POI_SWITCH", "TOPIC_SUGGEST_SWITCH", "getTOPIC_SUGGEST_SWITCH", "TOPIC_SWITCH", "getTOPIC_SWITCH", "Thumb_Max_Size", "getThumb_Max_Size", "USE_DAEMON_RECORD", "getUSE_DAEMON_RECORD", "VIDEO_3_4_RATIO", "getVIDEO_3_4_RATIO", "VIDEO_THUMB_MAX_SIZE", "getVIDEO_THUMB_MAX_SIZE", "VideoQualityDefault", "getVideoQualityDefault", "Video_Max_Size", "getVideo_Max_Size", "setVideo_Max_Size", "Video_Remux_Max_Count", "getVideo_Remux_Max_Count", "debugDumpFileTimeInterval", "getDebugDumpFileTimeInterval", "setDebugDumpFileTimeInterval", "(J)V", "debugPreloadComment", "getDebugPreloadComment", "setDebugPreloadComment", "debugPreloadCommentRemainCount", "getDebugPreloadCommentRemainCount", "setDebugPreloadCommentRemainCount", "debugTextLimit", "getDebugTextLimit", "setDebugTextLimit", "debugTopicJumpPoi", "getDebugTopicJumpPoi", "setDebugTopicJumpPoi", "follow_no_reddot_prefetch_inner_interval", "getFollow_no_reddot_prefetch_inner_interval", "follow_no_reddot_prefetch_outter_interval", "getFollow_no_reddot_prefetch_outter_interval", "follow_reddot_prefetch_inner_interval", "getFollow_reddot_prefetch_inner_interval", "follow_reddot_prefetch_outter_interval", "getFollow_reddot_prefetch_outter_interval", "friend_no_reddot_prefetch_inner_interval", "getFriend_no_reddot_prefetch_inner_interval", "friend_no_reddot_prefetch_outter_interval", "getFriend_no_reddot_prefetch_outter_interval", "friend_reddot_prefetch_inner_interval", "getFriend_reddot_prefetch_inner_interval", "friend_reddot_prefetch_outter_interval", "getFriend_reddot_prefetch_outter_interval", "hot_no_reddot_prefetch_inner_interval", "getHot_no_reddot_prefetch_inner_interval", "hot_no_reddot_prefetch_outter_interval", "getHot_no_reddot_prefetch_outter_interval", "hot_reddot_prefetch_inner_interval", "getHot_reddot_prefetch_inner_interval", "hot_reddot_prefetch_outter_interval", "getHot_reddot_prefetch_outter_interval", "isEnableGesturePreviewImage", "isEnableGesturePreviewImage$delegate", "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo$delegate", "isEnableGestureSeekBar", "isEnablePreloadStreamRefresh", "isEnablePreloadVideoForPreloadStream", "isEnableShowNew", "isEnableStoreLastTabType", "isGetGps", "isMoreTabEnable", "isNeverEnterMultiTab", "setNeverEnterMultiTab", "isOpenMultiBitRateDownload", "isPreloadImageEnable", "isPreloadVideoEnable", "isTestStreamFetch", "localEnableShowNew", "getLocalEnableShowNew", "setLocalEnableShowNew", "mp4ParserMode", "getMp4ParserMode", "msg", "getMsg", "nearby_no_reddot_prefetch_inner_interval", "getNearby_no_reddot_prefetch_inner_interval", "nearby_no_reddot_prefetch_outter_interval", "getNearby_no_reddot_prefetch_outter_interval", "nearby_reddot_prefetch_inner_interval", "getNearby_reddot_prefetch_inner_interval", "nearby_reddot_prefetch_outter_interval", "getNearby_reddot_prefetch_outter_interval", "tab_inner_hot_prefetch_switch", "getTab_inner_hot_prefetch_switch", "timelineShowTipsDuration", "getTimelineShowTipsDuration", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "videoAlbumMaxSelectDuration", "getVideoAlbumMaxSelectDuration", "videoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoRatioRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getVideoRatioRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "videoRecordPara", "getVideoRecordPara", "checkEnableGesturePreviewMedia", "", "getTabName", "tabType", "defaultStr", "getVideoViewConfig", "plugin-finder_release"})
public final class b
{
  private static final d.k.l<Double> OcM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcP;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcQ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcW;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> OcZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Oda;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Odb;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Odc;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Odd;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Ode;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Odf;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> Odg;
  private static final String msg;
  private static final int suH = 1024;
  private static final int suI = 1048576;
  private static final int suJ = 40;
  private static final int suK = 10485760;
  private static final int suL = 1048576;
  private static int suM = 0;
  private static int suN = 0;
  private static final int suO = 300;
  private static int suP = 0;
  private static int suQ = 0;
  private static int suR = 0;
  private static final int suS = 143360;
  private static int suT = 0;
  private static int suU = 0;
  private static int suV = 0;
  private static int suW = 0;
  private static int suX = 0;
  private static int suY = 0;
  private static int suZ = 0;
  private static final int svA;
  private static boolean svB = false;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svE;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svF;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svH;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a svI;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svJ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svK;
  private static final c svL;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svP;
  private static final c svQ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svT;
  private static c svU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svV;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a svW;
  private static c svX;
  private static c svY;
  private static c svZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sva;
  private static final int svb = 3;
  private static final int svc = 800;
  private static int svd = 0;
  private static final int sve = 45;
  private static final int svf = 45;
  private static final int svg = 10;
  private static boolean svh = false;
  private static boolean svi = false;
  private static long svj = 0L;
  private static final long svk;
  private static final f svl;
  private static final f svm;
  private static final f svn;
  private static int svo = 0;
  private static boolean svp = false;
  private static int svq = 0;
  private static int svr = 0;
  private static boolean svs = false;
  private static int svt = 0;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> svu;
  private static final boolean svv = false;
  private static final long svw = 2000L;
  private static final boolean svx = false;
  private static final int svy = 300000;
  private static final int svz = 5000;
  private static final c swB;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swE;
  private static List<o<Integer, String>> swF;
  private static boolean swG;
  private static boolean swH;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swI;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swK;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swL;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swN;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a swO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swP;
  private static c swQ;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> swR;
  private static final c swS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swW;
  private static final c swX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swZ;
  private static c swa;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swb;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swc;
  private static c swd;
  private static c swe;
  private static c swf;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swh;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swi;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swj;
  private static c swk;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swl;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a swm;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a swn;
  private static final c swo;
  private static final c swp;
  private static final c swq;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swr;
  private static final c sws;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a swt;
  private static final c swu;
  private static final c swv;
  private static final c sww;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> swx;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> swy;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> swz;
  public static final b sxa;
  
  static
  {
    AppMethodBeat.i(166903);
    sxa = new b();
    suH = 1024;
    suI = 1048576;
    suJ = 40;
    suK = suI * 10;
    suL = suI * 1;
    suM = suI * 28;
    suN = suI * 28;
    suO = 300;
    suP = 1280;
    suQ = 1080;
    suR = 90;
    suS = suH * 140;
    suT = 1080;
    suU = 1080;
    suV = 70;
    suW = 1080;
    suX = 1080;
    suY = 70;
    suZ = 50;
    sva = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "不再接收私信入口").aiA("FinderPrivateRefuseAllMsgSwitch").b("REFUSE_ALL_PRIVATE_MSG_SWITCH", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认(0)", "打开入口(1)", "关闭入口(0)" }));
    svb = 3;
    svc = 800;
    svd = 300000;
    sve = 45;
    svf = 45;
    svg = 10;
    svj = -1L;
    svk = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
    msg = "\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + cFN() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + cFJ() + " 后台处理\n    3、可配置（接x）：timeline顶部相机入口是否展示（默认展示）" + cFK() + "\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量）\n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + cFL() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + com.tencent.mm.plugin.expt.b.b.a.qzM + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ";
    svl = d.g.O((d.g.a.a)y.sxz);
    svm = d.g.O((d.g.a.a)z.sxA);
    svn = d.g.O((d.g.a.a)b.r.sxs);
    svo = 1;
    svq = 5;
    svr = 2;
    svs = true;
    svu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300000, "tab流自动刷新缓存时间").c(com.tencent.mm.plugin.expt.b.b.a.qzT).b("AUTO_REEFRESH_CACHE_INTERVAL", j.listOf(new Integer[] { Integer.valueOf(300000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) }), j.listOf(new String[] { "默认(5min)", "10s", "30s", "1min" }));
    svw = 2000L;
    svy = 300000;
    svz = 5000;
    svA = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGj, 0);
    svB = true;
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.d.BNj;
    if (com.tencent.mm.plugin.vlog.ui.plugin.d.etr())
    {
      localObject = h.O(0.75D);
      OcM = (d.k.l)localObject;
      svC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "二级评论是否展开").aiA("FinderCommentAutoExpandSubcommentList").b("COMMENT_EXPAND_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "是", "否" }));
      svD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞").c(com.tencent.mm.plugin.expt.b.b.a.qzY).b("REAL_NAME_LIKE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "实名点赞", "非实名点赞" }));
      svE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "评论全屏方案").c(com.tencent.mm.plugin.expt.b.b.a.qzX).b("COMMENT_STYLE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "全屏", "半屏" }));
      svF = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "圈外分享模式(仅预览)").c(com.tencent.mm.plugin.expt.b.b.a.qzX).b("USERINFO_FINDER_FORWARD_DEBUG_TYPE_INT", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "允许nickname", "过滤nickname" }));
      svG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "附近tab使用瀑布流/卡片流开关").c(com.tencent.mm.plugin.expt.b.b.a.qzW).b("LBS_UI_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "瀑布流", "卡片流" }));
      svH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(20, "关注/点赞折叠超过x条后折叠").b("FOLLOW_LIKE_FOLD_MORE_THAN_X", j.listOf(new Integer[] { Integer.valueOf(20), Integer.valueOf(3) }), j.listOf(new String[] { "20", "3" }));
      svI = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "开启视频预加载预览View", "USERINFO_FINDER_PRELOAD_VIEW_BOOLEAN_SYNC");
      svJ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否开启手势切Tab").b("USERINFO_FINDER_GESTURE_TAB_INT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(1) }), j.listOf(new String[] { "默认(0)", "关闭(-1)", "打开(1)" }));
      svK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "切换单Tab").c(com.tencent.mm.plugin.expt.b.b.a.qzV).b("FINDER_TAB_STYLE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "切换多tab", "切换单tab" }));
      svL = new c("重置最后退出TL时间为0", (d.g.a.a)b.w.sxx);
      svM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "评论字数限制10").aiA("FinderCommentTextLimit").b("COMMENT_TEXT_LIMIT_CONFIG", j.listOf(Integer.valueOf(10)), j.listOf("评论字数限制10"));
      svN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "Media字数限制15").aiA("FinderMediaPublishTextLimit").b("MEDIA_TEXT_LIMIT_CONFIG", j.listOf(Integer.valueOf(15)), j.listOf("Media字数限制15"));
      svO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "纯文本字数限制15").aiA("FinderPureTextPublishTextLimit").b("PURE_TEXT_LIMIT_CONFIG", j.listOf(Integer.valueOf(20)), j.listOf("纯文本字数限制15"));
      svP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "最大话题数改为3个").aiA("FinderMaxTopicCount").b("MAX_TOPIC_CONFIG", j.listOf(Integer.valueOf(3)), j.listOf("最大话题数改为3个"));
      svQ = new c("假菊花Toast", (d.g.a.a)b.o.sxp);
      svR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(15, "话题最大长度改为10").aiA("FinderTopicTextLimit").b("MAX_TOPIC_LENGTH_CONFIG", j.listOf(Integer.valueOf(10)), j.listOf("话题最大长度改为10"));
      svS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "话题推荐开关").aiA("FinderSuggestTagViewShow").b("TOPIC_RECOMMEND_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      svT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "打开切换身份评论").c(com.tencent.mm.plugin.expt.b.b.a.qAE).b("CAN_SWITCH_SCENE", j.listOf(Integer.valueOf(1)), j.listOf("打开"));
      svU = new c("重置切换身份提示", (d.g.a.a)b.l.sxm);
      svV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "最大at数改为3个").aiA("FinderMaxMentionSbCount").b("MAX_AT_COUNT_CONFIG", j.listOf(Integer.valueOf(3)), j.listOf("最大at数改为3个"));
      svW = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "发表feed/评论点赞固定失败");
      svX = new c("评论点赞重试间隔改为1s", (d.g.a.a)m.sxn);
      svY = new c("清除keybuf/账号数据", (d.g.a.a)e.sxf);
      svZ = new c("清除图片视频所有缓存", (d.g.a.a)h.sxi);
      swa = new c("清空keybuf", (d.g.a.a)d.sxe);
      swb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(80, "RecyclerView滑动速度").b("RECYCLERVIEW_SPEED", j.listOf(new Integer[] { Integer.valueOf(80), Integer.valueOf(50), Integer.valueOf(60), Integer.valueOf(70), Integer.valueOf(80), Integer.valueOf(90), Integer.valueOf(100), Integer.valueOf(130) }), j.listOf(new String[] { "默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍" }));
      swc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300, "loadmore假菊花时长").aiA("FinderFakeLoadingDurationMS").b("TIMELINE_LOADING_EXPIRED_TIME", j.listOf(new Integer[] { Integer.valueOf(100), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(500), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(3000) }), j.listOf(new String[] { "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      swd = new c("把自己改成非白名单用户", (d.g.a.a)a.sxb);
      swe = new c("把所有feed改为仅自己可见", (d.g.a.a)p.sxq);
      swf = new c("双击与展开教育/收藏红点重置", (d.g.a.a)n.sxo);
      swg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "红点不受配置时间限制").b("USERINFO_FINDER_TEST_RED_DOT_FACTOR_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(1000000000) }), j.listOf(new String[] { "默认", "无限制" }));
      swh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "后台合成").b("USERINFO_FINDER_VIDEO_REMUX_BACKGROUND_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "X实验配置", "否", "是" }));
      if ((!i.IS_FLAVOR_PURPLE) && (!i.DEBUG)) {
        break label7359;
      }
      i = 1;
      label2188:
      swi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(i, "特效").b("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" }));
      swj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "允许3:4视频比例").b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "开", "关" }));
      swk = new c("发表相机红点重置", (d.g.a.a)t.sxu);
      swl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "只看某个feed").b("USERINFO_FINDER_CARE_FEED_TYPE_INT", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8) }), j.listOf(new String[] { "DEFAULT", "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA" }));
      swm = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "进入视频号Crash");
      swn = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "输出视频号DEBUG日志", "USERINFO_FINDER_DEBUG_LOG_BOOLEAN_SYNC");
      swo = new c("清理首页文件缓存", (d.g.a.a)q.sxr);
      swp = new c("查看Finder缓存大小", (d.g.a.a)b.sxc);
      swq = new c("复制finder配置到剪贴板", (d.g.a.a)j.sxk);
      swr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "个人中心用户状态").b("FINDER_SELF_STATE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(-1) })), (List)new ArrayList((Collection)j.listOf(new String[] { "无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "reset" })));
      sws = new c("重置首次获得发表权限标志", (d.g.a.a)b.u.sxv);
      swt = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(true, "自动触发正例反馈");
      swu = new c("清空通知lastBuffer", (d.g.a.a)f.sxg);
      swv = new c("清理New红点配置", (d.g.a.a)b.g.sxh);
      sww = new c("清理更多相似动态状态", (d.g.a.a)b.i.sxj);
      swx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "打开评论抽屉是否调整feed位置").b("IS_ADJUST_FEED_WHEN_OPEN_DRAWER", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "默认模式(关闭)", "自动调整模式" }));
      swy = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(500L, "refresh假菊花时长").c(com.tencent.mm.plugin.expt.b.b.a.qsK).b("TIMELINE_REFRESH_EXPIRED_TIME", (List)new ArrayList((Collection)j.listOf(new Long[] { Long.valueOf(500L), Long.valueOf(100L), Long.valueOf(200L), Long.valueOf(400L), Long.valueOf(500L), Long.valueOf(600L), Long.valueOf(700L), Long.valueOf(800L), Long.valueOf(1000L), Long.valueOf(3000L) })), j.listOf(new String[] { "默认(500)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      swz = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(1200000L, "预加载debug轮询时长").c(com.tencent.mm.plugin.expt.b.b.a.qsJ).b("PRELOAD_DURATION", (List)new ArrayList((Collection)j.listOf(new Long[] { Long.valueOf(1200000L), Long.valueOf(5000L), Long.valueOf(10000L), Long.valueOf(60000L) })), j.listOf(new String[] { "默认(20min)", "5s", "10s", "1min" }));
      swB = new c("生效一次，收到红点会去掉（朋友/关注）发现页红点", (d.g.a.a)c.sxd);
      swC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频模板").b("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" }));
      swD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "点赞事件UI").b("TIMELINE_LIKE_EVENT_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "卡片模式", "m+n模式" }));
      swE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "FIDNER_RED_DOT_STYLE").b("FIDNER_RED_DOT_STYLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(-1) }), j.listOf(new String[] { "4(ICON)+liked", "7(SQUARE_ICON)+liked", "11(ICON_WITH_RED_DOT)+liked", "12(SQUARE_ICON_WITH_RED_DOT)+liked", "liked+13(RIGHT_ICON_WITH_RED_DOT)", "liked+14(RIGHT_SQUARE_ICON_WITH_RED_DOT)", "4(ICON)", "7(SQUARE_ICON)", "default" }));
      swF = j.listOf(new o[] { new o(Integer.valueOf(4), "liked"), new o(Integer.valueOf(7), "liked"), new o(Integer.valueOf(11), "liked"), new o(Integer.valueOf(12), "liked"), new o(Integer.valueOf(13), "liked"), new o(Integer.valueOf(14), "liked"), new o(Integer.valueOf(4), ""), new o(Integer.valueOf(7), ""), new o(Integer.valueOf(-1), "") });
      swG = true;
      swH = true;
      swI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否打开私信入口").c(com.tencent.mm.plugin.expt.b.b.a.qAb).b("ENABLE_FINDER_MESSAGE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "默认", "打开", "关闭" }));
      swK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "截屏上报").c(com.tencent.mm.plugin.expt.b.b.a.qAQ).b("FINDER_REPORT_WHEN_SCREEN_SHOT", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      swL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否在朋友tab制造个假跳转热门数据").b("FAKE_CARD_JUMP_HOT_TAB_DATA", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      if (!i.IS_FLAVOR_PURPLE) {
        break label7364;
      }
    }
    label7359:
    label7364:
    for (int i = 1;; i = 0)
    {
      swM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(i, "加载图片渐现").b("LOAD_IMAGE_ANIM", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      swN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "切换ViewPage速度").b("SWITC_VIEW_PAGE_TIME", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(1200), Integer.valueOf(1500) })), j.listOf(new String[] { "默认", "200", "400", "600", "700", "800", "1000", "1200", "1500" }));
      swO = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "是否在作者视角动态展示假数据");
      swP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "私密帐号").c(com.tencent.mm.plugin.expt.b.b.a.qBa).b("PRIVATE_ACCOUNT_ENABLE_DEBUG", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      swQ = new c("重置私密feed点赞提示次数", (d.g.a.a)b.k.sxl);
      swR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "支持匿名赞").c(com.tencent.mm.plugin.expt.b.b.a.qBt).b("USERINFO_SELF_PRIVATE_LIKE_INT_SYNC", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认", "支持", "不支持" }));
      swS = new c("重置私密feed点赞和匿名赞提示次数", (d.g.a.a)b.v.sxw);
      swT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏动画开关").b("IS_SHOW_FAV_ANIM_UNLIMITED", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      swU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频质量分上报").c(com.tencent.mm.plugin.expt.b.b.a.qBb).b("REPORT_QUALITY_INFO", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      swV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "选择 FeedHeadBar 样式").c(com.tencent.mm.plugin.expt.b.b.a.qAR).b("SWITCH_FEED_TITLE_STYLE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) })), j.listOf(new String[] { "默认(0)", "沉浸式(1)", "非沉浸式(0)", "4:3 沉浸式(2)" }));
      swW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表支持4:3").c(com.tencent.mm.plugin.expt.b.b.a.qIe).b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认", "支持", "不支持" }));
      swX = new c("点击切换朋友圈跳视频号入口", (d.g.a.a)b.x.sxy);
      swY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表上传block").b("DEBUG_POST_UPLOAD_BLOCK", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(20) })), j.listOf(new String[] { "不block", "block 20秒" }));
      swZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏出相似流").b("DEBUG_FAV_SIMILAR", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "使用后台配置", "支持" }));
      OcN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_o_interval").b("follow_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_o_interval").b("friend_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_o_interval").b("hot_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcQ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_o_interval").b("nearby_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_o_interval").b("follow_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_o_interval").b("friend_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_o_interval").b("hot_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_o_interval").b("nearby_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_i_interval").b("follow_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_i_interval").b("friend_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_i_interval").b("hot_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_i_interval").b("nearby_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      OcZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_i_interval").b("follow_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      Oda = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_i_interval").b("friend_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      Odb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_i_interval").b("hot_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      Odc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_i_interval").b("nearby_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      Odd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "tab_inner_hot_prefetch_switch").b("tab_inner_hot_prefetch_switch", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认", "true", "false" }));
      Ode = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否本地调整点赞头像顺序").c(com.tencent.mm.plugin.expt.b.b.a.BPn).b("ADJUST_AVATAR_ORDER_LIKE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Odf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "引导用户点赞自己的视频").c(com.tencent.mm.plugin.expt.b.b.a.CZn).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "支持" }));
      Odg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "引导用户点赞后评论").c(com.tencent.mm.plugin.expt.b.b.a.CZk).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "支持" }));
      AppMethodBeat.o(166903);
      return;
      localObject = h.O(0.857142857142857D);
      break;
      i = 0;
      break label2188;
    }
  }
  
  public static void Fg(int paramInt)
  {
    svd = paramInt;
  }
  
  public static void Fh(int paramInt)
  {
    AppMethodBeat.i(203614);
    ad.i("FinderConfig", "set REPLY_SCENE value:".concat(String.valueOf(paramInt)));
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIQ, Integer.valueOf(paramInt));
    AppMethodBeat.o(203614);
  }
  
  public static void Fi(int paramInt)
  {
    AppMethodBeat.i(203627);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIl, Integer.valueOf(paramInt));
    AppMethodBeat.o(203627);
  }
  
  public static void Fj(int paramInt)
  {
    AppMethodBeat.i(203629);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIo, Integer.valueOf(paramInt));
    AppMethodBeat.o(203629);
  }
  
  public static void Fk(int paramInt)
  {
    AppMethodBeat.i(203634);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIm, Integer.valueOf(paramInt));
    AppMethodBeat.o(203634);
  }
  
  public static void Fl(int paramInt)
  {
    AppMethodBeat.i(203636);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IIn, Integer.valueOf(paramInt));
    AppMethodBeat.o(203636);
  }
  
  public static String ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(203619);
    p.h(paramString, "defaultStr");
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      switch (paramInt)
      {
      case 2: 
      default: 
        paramString = "";
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.e locale;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(203619);
        return "";
        paramString = aj.getContext().getString(2131766501);
        p.g(paramString, "MMApplicationContext.get…string.finder_tab_friend)");
        continue;
        paramString = aj.getContext().getString(2131766500);
        p.g(paramString, "MMApplicationContext.get…string.finder_tab_follow)");
        continue;
        paramString = aj.getContext().getString(2131766503);
        p.g(paramString, "MMApplicationContext.get…tring.finder_tab_machine)");
        break;
      case 1: 
        locale = com.tencent.mm.kernel.g.ajC();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.ajl().get(al.a.IHj, paramString);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(203619);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(203619);
        return paramString;
      case 3: 
        locale = com.tencent.mm.kernel.g.ajC();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.ajl().get(al.a.IHl, paramString);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(203619);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(203619);
        return paramString;
      case 4: 
        locale = com.tencent.mm.kernel.g.ajC();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.ajl().get(al.a.IHk, paramString);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(203619);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(203619);
        return paramString;
      }
    }
  }
  
  public static VideoTransPara cEX()
  {
    AppMethodBeat.i(166904);
    Object localObject = com.tencent.mm.modelcontrol.d.aGQ();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.d)localObject).aGV();
    AppMethodBeat.o(166904);
    return localObject;
  }
  
  public static VideoTransPara cEY()
  {
    AppMethodBeat.i(166905);
    Object localObject = com.tencent.mm.modelcontrol.d.aGQ();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.d)localObject).aGW();
    AppMethodBeat.o(166905);
    return localObject;
  }
  
  public static int cEZ()
  {
    AppMethodBeat.i(166906);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzQ, 300);
    AppMethodBeat.o(166906);
    return i;
  }
  
  private static float cFA()
  {
    AppMethodBeat.i(166918);
    ad.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + svk);
    if (svk < 10L)
    {
      AppMethodBeat.o(166918);
      return 0.5F;
    }
    if (svk < 20L)
    {
      AppMethodBeat.o(166918);
      return 1.0F;
    }
    AppMethodBeat.o(166918);
    return 2.0F;
  }
  
  public static long cFB()
  {
    AppMethodBeat.i(166919);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAd, 1024L) * suI) * cFA());
    AppMethodBeat.o(166919);
    return l;
  }
  
  public static long cFC()
  {
    AppMethodBeat.i(166920);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAe, 100L) * suI) * cFA());
    AppMethodBeat.o(166920);
    return l;
  }
  
  public static long cFD()
  {
    AppMethodBeat.i(166921);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAf, 500L) * suI) * cFA());
    AppMethodBeat.o(166921);
    return l;
  }
  
  public static long cFE()
  {
    AppMethodBeat.i(166922);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAg, 1024L) * suI) * cFA());
    AppMethodBeat.o(166922);
    return l;
  }
  
  public static long cFF()
  {
    AppMethodBeat.i(166923);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAh, 500L) * suI) * cFA());
    AppMethodBeat.o(166923);
    return l;
  }
  
  public static long cFG()
  {
    AppMethodBeat.i(166924);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAi, 500L) * suI) * cFA());
    AppMethodBeat.o(166924);
    return l;
  }
  
  public static long cFH()
  {
    AppMethodBeat.i(166925);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAj, 500L) * suI) * cFA());
    AppMethodBeat.o(166925);
    return l;
  }
  
  public static int cFI()
  {
    AppMethodBeat.i(166929);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderTimelineEntry", 0);
    AppMethodBeat.o(166929);
    return i;
  }
  
  public static boolean cFJ()
  {
    AppMethodBeat.i(166930);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzK, 1) == 1)
    {
      AppMethodBeat.o(166930);
      return true;
    }
    AppMethodBeat.o(166930);
    return false;
  }
  
  public static boolean cFK()
  {
    AppMethodBeat.i(166931);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzJ, 1) == 1)
    {
      AppMethodBeat.o(166931);
      return true;
    }
    AppMethodBeat.o(166931);
    return false;
  }
  
  public static boolean cFL()
  {
    AppMethodBeat.i(166932);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzL, 1) == 1)
    {
      AppMethodBeat.o(166932);
      return true;
    }
    AppMethodBeat.o(166932);
    return false;
  }
  
  public static boolean cFM()
  {
    AppMethodBeat.i(166933);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzR, 1) == 1)
    {
      AppMethodBeat.o(166933);
      return true;
    }
    AppMethodBeat.o(166933);
    return false;
  }
  
  public static boolean cFN()
  {
    AppMethodBeat.i(166934);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzS, 1) == 1)
    {
      AppMethodBeat.o(166934);
      return true;
    }
    AppMethodBeat.o(166934);
    return false;
  }
  
  public static boolean cFO()
  {
    AppMethodBeat.i(166935);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderShareDetailCommentListShow", 1) == 1)
    {
      AppMethodBeat.o(166935);
      return true;
    }
    AppMethodBeat.o(166935);
    return false;
  }
  
  public static boolean cFP()
  {
    AppMethodBeat.i(166936);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderShareDetailCommentButtonShow", 1) == 1)
    {
      AppMethodBeat.o(166936);
      return true;
    }
    AppMethodBeat.o(166936);
    return false;
  }
  
  public static boolean cFQ()
  {
    AppMethodBeat.i(203605);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderFeedCameraShowPostEducation", 1) == 1)
    {
      AppMethodBeat.o(203605);
      return true;
    }
    AppMethodBeat.o(203605);
    return false;
  }
  
  public static String cFR()
  {
    AppMethodBeat.i(203606);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IGM, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203606);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = aj.getContext().getString(2131759289);
      p.g(localObject, "MMApplicationContext.get…finder_no_post_edu_title)");
      AppMethodBeat.o(203606);
      return localObject;
    }
    AppMethodBeat.o(203606);
    return localObject;
  }
  
  public static String cFS()
  {
    AppMethodBeat.i(203607);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IGN, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(203607);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bt.isNullOrNil((String)localObject))
    {
      localObject = aj.getContext().getString(2131759288);
      p.g(localObject, "MMApplicationContext.get….finder_no_post_edu_desc)");
      AppMethodBeat.o(203607);
      return localObject;
    }
    AppMethodBeat.o(203607);
    return localObject;
  }
  
  public static boolean cFT()
  {
    AppMethodBeat.i(166937);
    boolean bool = ((Boolean)svl.getValue()).booleanValue();
    AppMethodBeat.o(166937);
    return bool;
  }
  
  public static boolean cFU()
  {
    AppMethodBeat.i(166938);
    boolean bool = ((Boolean)svm.getValue()).booleanValue();
    AppMethodBeat.o(166938);
    return bool;
  }
  
  private static boolean[] cFV()
  {
    AppMethodBeat.i(166939);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAu, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] JSON=".concat(String.valueOf(localObject1)));
        localObject1 = new JSONObject((String)localObject1);
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("hard-close");
        int j = localJSONArray.length();
        i = 0;
        if (i < j)
        {
          Object localObject3 = localJSONArray.getJSONObject(i);
          Object localObject2 = ((JSONObject)localObject3).getString("device-brand");
          String str = ((JSONObject)localObject3).getString("device-model");
          int k = ((JSONObject)localObject3).getInt("below-sdk-version");
          bool1 = ((JSONObject)localObject3).getBoolean("isEnableImage");
          bool2 = ((JSONObject)localObject3).getBoolean("isEnableVideo");
          localObject3 = Build.BRAND + " " + Build.MODEL;
          ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] name=" + (String)localObject2 + " model=" + str + " version=" + k + " isEnableImage=" + bool1 + " isEnableVideo=" + bool2 + " | this device=" + (String)localObject3 + " version=" + Build.VERSION.SDK_INT);
          if (k < Build.VERSION.SDK_INT) {
            break label471;
          }
          CharSequence localCharSequence = (CharSequence)localObject3;
          p.g(localObject2, "name");
          if (!n.a(localCharSequence, (CharSequence)localObject2, true)) {
            break label471;
          }
          localObject2 = (CharSequence)localObject3;
          p.g(str, "model");
          if (!n.a((CharSequence)localObject2, (CharSequence)str, true)) {
            break label471;
          }
          AppMethodBeat.o(166939);
          return new boolean[] { bool1, bool2 };
        }
        boolean bool1 = ((JSONObject)localObject1).getBoolean("isEnableImage");
        boolean bool2 = ((JSONObject)localObject1).getBoolean("isEnableVideo");
        ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] isEnableImage=" + bool1 + " isEnableVideo=" + bool2);
        AppMethodBeat.o(166939);
        return new boolean[] { bool1, bool2 };
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("FinderConfig", (Throwable)localException, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(166939);
        return new boolean[] { true, true };
        ad.i("FinderConfig", "[checkEnableGesturePreviewMedia] json is Empty! just pass!");
      }
      label471:
      i += 1;
    }
  }
  
  public static boolean cFW()
  {
    AppMethodBeat.i(203608);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAq, 1) == 1)
    {
      AppMethodBeat.o(203608);
      return true;
    }
    AppMethodBeat.o(203608);
    return false;
  }
  
  public static boolean cFX()
  {
    AppMethodBeat.i(203609);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAr, 1) == 1)
    {
      AppMethodBeat.o(203609);
      return true;
    }
    AppMethodBeat.o(203609);
    return false;
  }
  
  public static o<Integer, Boolean> cFY()
  {
    AppMethodBeat.i(203610);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAl, 3);
    try
    {
      Object localObject1 = Build.MODEL;
      p.g(localObject1, "Build.MODEL");
      localObject3 = Locale.getDefault();
      p.g(localObject3, "Locale.getDefault()");
      if (localObject1 != null) {
        break label111;
      }
      localObject1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203610);
      throw ((Throwable)localObject1);
    }
    catch (Throwable localThrowable1)
    {
      bool = false;
    }
    ad.printErrStackTrace("FinderConfig", localThrowable1, "", new Object[0]);
    Object localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
    AppMethodBeat.o(203610);
    return localObject2;
    label111:
    localObject2 = ((String)localObject2).toLowerCase((Locale)localObject3);
    p.g(localObject2, "(this as java.lang.String).toLowerCase(locale)");
    Object localObject3 = Build.BRAND;
    p.g(localObject3, "Build.BRAND");
    Object localObject4 = Locale.getDefault();
    p.g(localObject4, "Locale.getDefault()");
    if (localObject3 == null)
    {
      localObject2 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(203610);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
    p.g(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    localObject4 = "API#" + Build.VERSION.SDK_INT;
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAn, "");
    if (!bt.isNullOrNil(str))
    {
      p.g(str, "waitForRelease");
      if ((n.e((CharSequence)str, (CharSequence)localObject2)) || (n.e((CharSequence)str, (CharSequence)localObject3)) || (n.e((CharSequence)str, (CharSequence)localObject4))) {
        ad.i("FinderConfig", "[getVideoViewConfig#waitForRelease] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
      }
    }
    for (boolean bool = true;; bool = false) {
      label520:
      for (;;)
      {
        try
        {
          str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAm, "");
          if (bt.isNullOrNil(str)) {
            break label520;
          }
          p.g(str, "videoSingleCount");
          if ((!n.e((CharSequence)str, (CharSequence)localObject2)) && (!n.e((CharSequence)str, (CharSequence)localObject3)) && (!n.e((CharSequence)str, (CharSequence)localObject4))) {
            break label520;
          }
          ad.i("FinderConfig", "[getVideoViewConfig#videoSingleCount] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
          i = 1;
          try
          {
            localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
            AppMethodBeat.o(203610);
            return localObject2;
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
        break;
      }
    }
  }
  
  public static int cFZ()
  {
    AppMethodBeat.i(166942);
    int i = ((Number)svn.getValue()).intValue();
    AppMethodBeat.o(166942);
    return i;
  }
  
  public static boolean cFa()
  {
    AppMethodBeat.i(166907);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAy, 1) == 1)
    {
      AppMethodBeat.o(166907);
      return true;
    }
    AppMethodBeat.o(166907);
    return false;
  }
  
  public static int cFb()
  {
    return suJ;
  }
  
  public static boolean cFc()
  {
    AppMethodBeat.i(221543);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.CZj, 0) == 1)
    {
      AppMethodBeat.o(221543);
      return true;
    }
    AppMethodBeat.o(221543);
    return false;
  }
  
  public static boolean cFd()
  {
    AppMethodBeat.i(203601);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAY, 0) == 1)
    {
      AppMethodBeat.o(203601);
      return true;
    }
    AppMethodBeat.o(203601);
    return false;
  }
  
  public static int cFe()
  {
    AppMethodBeat.i(203602);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAN, suI * 28);
    AppMethodBeat.o(203602);
    return i;
  }
  
  public static int cFf()
  {
    AppMethodBeat.i(203603);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAO, suI * 28);
    AppMethodBeat.o(203603);
    return i;
  }
  
  public static int cFg()
  {
    return suO;
  }
  
  public static int cFh()
  {
    AppMethodBeat.i(166908);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166908);
      return 1280;
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166908);
      throw ((Throwable)localObject);
    }
    i = bt.aRe((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166908);
    return i;
  }
  
  public static int cFi()
  {
    AppMethodBeat.i(166909);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166909);
      return 1080;
    }
    ad.d("FinderConfig", "FinderFeedCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166909);
      throw ((Throwable)localObject);
    }
    i = bt.aRe((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166909);
    return i;
  }
  
  public static int cFj()
  {
    AppMethodBeat.i(166910);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderFeedCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166910);
      return 90;
    }
    ad.d("FinderConfig", "FinderFeedCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166910);
      throw ((Throwable)localObject);
    }
    i = bt.aRe(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166910);
    return i;
  }
  
  public static int cFk()
  {
    return suS;
  }
  
  public static int cFl()
  {
    AppMethodBeat.i(166911);
    int i = suT;
    AppMethodBeat.o(166911);
    return i;
  }
  
  public static int cFm()
  {
    AppMethodBeat.i(166912);
    int i = suU;
    AppMethodBeat.o(166912);
    return i;
  }
  
  public static int cFn()
  {
    AppMethodBeat.i(166913);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderHeadCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166913);
      return 90;
    }
    ad.i("FinderConfig", "FinderHeadCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166913);
      throw ((Throwable)localObject);
    }
    i = bt.aRe(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166913);
    return i;
  }
  
  public static int cFo()
  {
    AppMethodBeat.i(166914);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166914);
      return 1080;
    }
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166914);
      throw ((Throwable)localObject);
    }
    i = bt.aRe((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166914);
    return i;
  }
  
  public static int cFp()
  {
    AppMethodBeat.i(166915);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166915);
      return 1080;
    }
    ad.i("FinderConfig", "FinderHeadCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166915);
      throw ((Throwable)localObject);
    }
    i = bt.aRe((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166915);
    return i;
  }
  
  public static int cFq()
  {
    AppMethodBeat.i(166916);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acA().getValue("FinderProfileBgImgCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166916);
      return 70;
    }
    ad.i("FinderConfig", "FinderProfileBgImgCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166916);
      throw ((Throwable)localObject);
    }
    i = bt.aRe(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166916);
    return i;
  }
  
  public static int cFr()
  {
    AppMethodBeat.i(203604);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderCoverCompressPicLevel", 50);
    AppMethodBeat.o(203604);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cFs()
  {
    return sva;
  }
  
  public static int cFt()
  {
    return svb;
  }
  
  public static int cFu()
  {
    return svd;
  }
  
  public static int cFv()
  {
    return sve;
  }
  
  public static int cFw()
  {
    return svf;
  }
  
  public static boolean cFx()
  {
    return svh;
  }
  
  public static boolean cFy()
  {
    return svi;
  }
  
  public static long cFz()
  {
    AppMethodBeat.i(166917);
    if ((svj > 0L) && (ad.getLogLevel() <= 1))
    {
      l = svj;
      AppMethodBeat.o(166917);
      return l;
    }
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAc, 86400L);
    AppMethodBeat.o(166917);
    return l * 1000L;
  }
  
  public static int cGA()
  {
    AppMethodBeat.i(203616);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderFakeLoadingPageCount", 5);
    AppMethodBeat.o(203616);
    return i;
  }
  
  public static boolean cGB()
  {
    AppMethodBeat.i(203617);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderFakeLoadingPageCount", 5) > 0)
    {
      AppMethodBeat.o(203617);
      return true;
    }
    AppMethodBeat.o(203617);
    return false;
  }
  
  public static boolean cGC()
  {
    AppMethodBeat.i(203618);
    if (i.IS_FLAVOR_PURPLE)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
      p.g(locale, "MMKernel.storage()");
      if (locale.ajl().getBoolean(al.a.IHi, false))
      {
        AppMethodBeat.o(203618);
        return true;
      }
    }
    AppMethodBeat.o(203618);
    return false;
  }
  
  public static boolean cGE()
  {
    AppMethodBeat.i(203621);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzZ, 1) == 1)
    {
      AppMethodBeat.o(203621);
      return true;
    }
    AppMethodBeat.o(203621);
    return false;
  }
  
  public static int cGF()
  {
    return svA;
  }
  
  public static boolean cGG()
  {
    AppMethodBeat.i(203622);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qsG, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("FinderConfig", "[GET] isEnableStoreLastTabType=".concat(String.valueOf(bool)));
      AppMethodBeat.o(203622);
      return bool;
    }
  }
  
  public static void cGH()
  {
    AppMethodBeat.i(203623);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IHo, Integer.valueOf(1));
    svB = false;
    AppMethodBeat.o(203623);
  }
  
  public static boolean cGI()
  {
    AppMethodBeat.i(203624);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qsH, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("FinderConfig", "[GET] isEnablePreloadStreamRefresh=".concat(String.valueOf(bool)));
      AppMethodBeat.o(203624);
      return bool;
    }
  }
  
  public static boolean cGJ()
  {
    AppMethodBeat.i(203625);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qsI, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("FinderConfig", "[GET] isEnablePreloadVideoForPreloadStream=".concat(String.valueOf(bool)));
      AppMethodBeat.o(203625);
      return bool;
    }
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGK()
  {
    return svC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGL()
  {
    return svD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGM()
  {
    return svE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGN()
  {
    return svF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGO()
  {
    return svG;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGP()
  {
    return svH;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cGQ()
  {
    return svI;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGR()
  {
    return svJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGS()
  {
    return svK;
  }
  
  public static c cGT()
  {
    return svL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGU()
  {
    return svM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGV()
  {
    return svN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGW()
  {
    return svO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGX()
  {
    return svP;
  }
  
  public static c cGY()
  {
    return svQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGZ()
  {
    return svR;
  }
  
  public static boolean cGa()
  {
    AppMethodBeat.i(203611);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGT, 1) == 1) || (i.IS_FLAVOR_PURPLE) || (i.DEBUG))
    {
      AppMethodBeat.o(203611);
      return true;
    }
    AppMethodBeat.o(203611);
    return false;
  }
  
  public static boolean cGb()
  {
    AppMethodBeat.i(203612);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGU, 1) == 1)
    {
      AppMethodBeat.o(203612);
      return true;
    }
    AppMethodBeat.o(203612);
    return false;
  }
  
  public static String cGc()
  {
    AppMethodBeat.i(166943);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAw, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
    AppMethodBeat.o(166943);
    return str;
  }
  
  public static boolean cGd()
  {
    AppMethodBeat.i(166944);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1)
    {
      AppMethodBeat.o(166944);
      return true;
    }
    AppMethodBeat.o(166944);
    return false;
  }
  
  public static boolean cGe()
  {
    AppMethodBeat.i(166945);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAx, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(bool)));
      AppMethodBeat.o(166945);
      return bool;
    }
  }
  
  public static boolean cGf()
  {
    AppMethodBeat.i(166948);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAz, 1) == 1)
    {
      AppMethodBeat.o(166948);
      return true;
    }
    AppMethodBeat.o(166948);
    return false;
  }
  
  public static boolean cGg()
  {
    AppMethodBeat.i(203613);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderMaxMentionSbCount", 1000) > 0)
    {
      AppMethodBeat.o(203613);
      return true;
    }
    AppMethodBeat.o(203613);
    return false;
  }
  
  public static boolean cGh()
  {
    AppMethodBeat.i(166950);
    if ((svo == 0) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166950);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderPoiJumpTopicSwitch", 0) == 1)
    {
      AppMethodBeat.o(166950);
      return true;
    }
    AppMethodBeat.o(166950);
    return false;
  }
  
  public static boolean cGi()
  {
    AppMethodBeat.i(166952);
    if ((svp) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166952);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAB, 1) == 1)
    {
      AppMethodBeat.o(166952);
      return true;
    }
    AppMethodBeat.o(166952);
    return false;
  }
  
  public static int cGj()
  {
    AppMethodBeat.i(178407);
    if ((svq != 5) && (ad.getLogLevel() <= 1))
    {
      i = svq;
      AppMethodBeat.o(178407);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAD, svq);
    AppMethodBeat.o(178407);
    return i;
  }
  
  public static boolean cGk()
  {
    AppMethodBeat.i(178408);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.ajl().getBoolean(al.a.IHO, false);
    ad.i("FinderConfig", "[GET] ENABLE_SHOW_OTHER_PROFILE_FANS = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(178408);
    return bool;
  }
  
  public static int cGl()
  {
    AppMethodBeat.i(178412);
    if (((Number)svT.value()).intValue() == 1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
      p.g(locale, "MMKernel.storage()");
      int i = locale.ajl().getInt(al.a.IIQ, svr);
      if (i <= 0)
      {
        i = svr;
        AppMethodBeat.o(178412);
        return i;
      }
      AppMethodBeat.o(178412);
      return i;
    }
    AppMethodBeat.o(178412);
    return 2;
  }
  
  public static int cGm()
  {
    return svr;
  }
  
  public static boolean cGn()
  {
    AppMethodBeat.i(178413);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderCommentShowBlacklist", 0) == 1)
    {
      AppMethodBeat.o(178413);
      return true;
    }
    AppMethodBeat.o(178413);
    return false;
  }
  
  public static int cGo()
  {
    AppMethodBeat.i(178414);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAU, 0);
    AppMethodBeat.o(178414);
    return i;
  }
  
  public static boolean cGp()
  {
    AppMethodBeat.i(178415);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajl().a(al.a.IIq, 0L) == 0L)
    {
      AppMethodBeat.o(178415);
      return true;
    }
    AppMethodBeat.o(178415);
    return false;
  }
  
  public static boolean cGq()
  {
    AppMethodBeat.i(178416);
    if ((svt == 1) && (ad.getLogLevel() <= 1))
    {
      AppMethodBeat.o(178416);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAS, 0) == 1)
    {
      AppMethodBeat.o(178416);
      return true;
    }
    AppMethodBeat.o(178416);
    return false;
  }
  
  public static int cGr()
  {
    AppMethodBeat.i(178417);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAT, 10000000);
    AppMethodBeat.o(178417);
    return i;
  }
  
  public static int cGs()
  {
    AppMethodBeat.i(178418);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("FinderCommentNickNameMaxLength", 6);
    AppMethodBeat.o(178418);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cGt()
  {
    return svu;
  }
  
  public static boolean cGu()
  {
    return svv;
  }
  
  public static long cGv()
  {
    return svw;
  }
  
  public static boolean cGw()
  {
    AppMethodBeat.i(203615);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzU, 1) == 1)
    {
      AppMethodBeat.o(203615);
      return true;
    }
    AppMethodBeat.o(203615);
    return false;
  }
  
  public static boolean cGx()
  {
    return svx;
  }
  
  public static int cGy()
  {
    return svy;
  }
  
  public static int cGz()
  {
    return svz;
  }
  
  public static c cHA()
  {
    return swq;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHB()
  {
    return swr;
  }
  
  public static c cHC()
  {
    return sws;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cHD()
  {
    return swt;
  }
  
  public static c cHE()
  {
    return swu;
  }
  
  public static c cHF()
  {
    return swv;
  }
  
  public static c cHG()
  {
    return sww;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHH()
  {
    return swx;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> cHI()
  {
    return swy;
  }
  
  public static boolean cHJ()
  {
    AppMethodBeat.i(221544);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.CZi, 0) == 1)
    {
      AppMethodBeat.o(221544);
      return true;
    }
    AppMethodBeat.o(221544);
    return false;
  }
  
  public static d.k.l<Double> cHK()
  {
    return OcM;
  }
  
  public static c cHL()
  {
    return swB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHM()
  {
    return swC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHN()
  {
    return swD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHO()
  {
    return swE;
  }
  
  public static List<o<Integer, String>> cHP()
  {
    return swF;
  }
  
  public static boolean cHQ()
  {
    AppMethodBeat.i(203630);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderStatsReportControl", 1) == 1)
    {
      AppMethodBeat.o(203630);
      return true;
    }
    AppMethodBeat.o(203630);
    return false;
  }
  
  public static boolean cHR()
  {
    AppMethodBeat.i(203631);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).acA().getInt("FinderMarkReadOpenControl", 1) == 1)
    {
      AppMethodBeat.o(203631);
      return true;
    }
    AppMethodBeat.o(203631);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHS()
  {
    return swI;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHT()
  {
    return OcN;
  }
  
  public static int cHU()
  {
    AppMethodBeat.i(203632);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAP, 0);
    AppMethodBeat.o(203632);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHV()
  {
    return swK;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHW()
  {
    return swL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHX()
  {
    return swM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHY()
  {
    return swN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cHZ()
  {
    return swO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHa()
  {
    return svS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHb()
  {
    return svT;
  }
  
  public static c cHc()
  {
    return svU;
  }
  
  public static int cHd()
  {
    AppMethodBeat.i(203626);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IIl, 4);
    AppMethodBeat.o(203626);
    return i;
  }
  
  public static int cHe()
  {
    AppMethodBeat.i(203628);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IIo, 0);
    AppMethodBeat.o(203628);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHf()
  {
    return svV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cHg()
  {
    return svW;
  }
  
  public static c cHh()
  {
    return svX;
  }
  
  public static c cHi()
  {
    return svY;
  }
  
  public static c cHj()
  {
    return svZ;
  }
  
  public static c cHk()
  {
    return swa;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHl()
  {
    return swb;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHm()
  {
    return swc;
  }
  
  public static c cHn()
  {
    return swd;
  }
  
  public static c cHo()
  {
    return swe;
  }
  
  public static c cHp()
  {
    return swf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHq()
  {
    return swg;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHr()
  {
    return swh;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHs()
  {
    return swi;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHt()
  {
    return swj;
  }
  
  public static c cHu()
  {
    return swk;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHv()
  {
    return swl;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cHw()
  {
    return swm;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cHx()
  {
    return swn;
  }
  
  public static c cHy()
  {
    return swo;
  }
  
  public static c cHz()
  {
    return swp;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIa()
  {
    return swP;
  }
  
  public static int cIb()
  {
    AppMethodBeat.i(203633);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IIm, 3);
    AppMethodBeat.o(203633);
    return i;
  }
  
  public static int cIc()
  {
    AppMethodBeat.i(203635);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajl().getInt(al.a.IIn, 3);
    AppMethodBeat.o(203635);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cId()
  {
    return swR;
  }
  
  public static c cIe()
  {
    return swS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIf()
  {
    return swT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIg()
  {
    return swU;
  }
  
  public static boolean cIh()
  {
    AppMethodBeat.i(203637);
    if (((Number)swU.value()).intValue() == 1)
    {
      AppMethodBeat.o(203637);
      return true;
    }
    AppMethodBeat.o(203637);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIi()
  {
    return swV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIj()
  {
    return swW;
  }
  
  public static c cIk()
  {
    return swX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIl()
  {
    return swY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIm()
  {
    return swZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cNk()
  {
    return OcO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cOe()
  {
    return OcP;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cOg()
  {
    return OcQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cOh()
  {
    return OcR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cOi()
  {
    return OcS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cOj()
  {
    return OcT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cOk()
  {
    return OcU;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cVi()
  {
    return OcV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cVm()
  {
    return OcW;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dRe()
  {
    return OcZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dSc()
  {
    return Oda;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dSf()
  {
    return Odb;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dSg()
  {
    return Odc;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dSh()
  {
    return Odd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dbP()
  {
    return OcX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dbQ()
  {
    return OcY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> eQo()
  {
    return Ode;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> eQp()
  {
    return Odf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> eQq()
  {
    return Odg;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a sxb;
    
    static
    {
      AppMethodBeat.i(203555);
      sxb = new a();
      AppMethodBeat.o(203555);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    public static final b sxc;
    
    static
    {
      AppMethodBeat.i(203557);
      sxc = new b();
      AppMethodBeat.o(203557);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    public static final c sxd;
    
    static
    {
      AppMethodBeat.i(203559);
      sxd = new c();
      AppMethodBeat.o(203559);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    public static final d sxe;
    
    static
    {
      AppMethodBeat.i(203561);
      sxe = new d();
      AppMethodBeat.o(203561);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    public static final e sxf;
    
    static
    {
      AppMethodBeat.i(203563);
      sxf = new e();
      AppMethodBeat.o(203563);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    public static final f sxg;
    
    static
    {
      AppMethodBeat.i(203565);
      sxg = new f();
      AppMethodBeat.o(203565);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    public static final h sxi;
    
    static
    {
      AppMethodBeat.i(203569);
      sxi = new h();
      AppMethodBeat.o(203569);
    }
    
    h()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    public static final j sxk;
    
    static
    {
      AppMethodBeat.i(203573);
      sxk = new j();
      AppMethodBeat.o(203573);
    }
    
    j()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
  {
    public static final m sxn;
    
    static
    {
      AppMethodBeat.i(203579);
      sxn = new m();
      AppMethodBeat.o(203579);
    }
    
    m()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<z>
  {
    public static final n sxo;
    
    static
    {
      AppMethodBeat.i(203581);
      sxo = new n();
      AppMethodBeat.o(203581);
    }
    
    n()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<z>
  {
    public static final p sxq;
    
    static
    {
      AppMethodBeat.i(203585);
      sxq = new p();
      AppMethodBeat.o(203585);
    }
    
    p()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<z>
  {
    public static final q sxr;
    
    static
    {
      AppMethodBeat.i(203587);
      sxr = new q();
      AppMethodBeat.o(203587);
    }
    
    q()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements d.g.a.a<z>
  {
    public static final t sxu;
    
    static
    {
      AppMethodBeat.i(203591);
      sxu = new t();
      AppMethodBeat.o(203591);
    }
    
    t()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final y sxz;
    
    static
    {
      AppMethodBeat.i(166900);
      sxz = new y();
      AppMethodBeat.o(166900);
    }
    
    y()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class z
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final z sxA;
    
    static
    {
      AppMethodBeat.i(166902);
      sxA = new z();
      AppMethodBeat.o(166902);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */