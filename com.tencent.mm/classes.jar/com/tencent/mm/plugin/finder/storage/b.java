package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.storage.config.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderConfig;", "", "()V", "ADJUST_AVATAR_ORDER_LIKE", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "getADJUST_AVATAR_ORDER_LIKE", "()Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "AT_SWITCH", "", "getAT_SWITCH", "()Z", "AUTO_FEEDBACK", "Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "getAUTO_FEEDBACK", "()Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "AVATAR_COMPRESS_QUALITY", "getAVATAR_COMPRESS_QUALITY", "()I", "setAVATAR_COMPRESS_QUALITY", "(I)V", "AVATAR_MAX_HEIGHT", "getAVATAR_MAX_HEIGHT", "setAVATAR_MAX_HEIGHT", "AVATAR_MAX_THUMB_WIDTH", "AVATAR_MAX_WIDTH", "getAVATAR_MAX_WIDTH", "setAVATAR_MAX_WIDTH", "AVATAR_UPLOAD_MAX_SIZE", "getAVATAR_UPLOAD_MAX_SIZE", "BG_MERGE", "getBG_MERGE", "Big_File_LENGTH", "getBig_File_LENGTH", "setBig_File_LENGTH", "CAN_BAN_FINDER_COMMENT", "getCAN_BAN_FINDER_COMMENT", "CAN_SHOW_CHANGE_DISTRICT", "getCAN_SHOW_CHANGE_DISTRICT", "setCAN_SHOW_CHANGE_DISTRICT", "(Z)V", "CAN_SWITCH_SCENE", "getCAN_SWITCH_SCENE", "CDN_UPLOAD_CONTROL", "getCDN_UPLOAD_CONTROL", "CHANGE_TO_NO_FINDER_ENTRANCE", "Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "getCHANGE_TO_NO_FINDER_ENTRANCE", "()Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "setCHANGE_TO_NO_FINDER_ENTRANCE", "(Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;)V", "CHECK_FINDER_CACHE", "getCHECK_FINDER_CACHE", "CHECK_TAB_TIP_TEST", "getCHECK_TAB_TIP_TEST", "CLEAR_KEY_BUF", "getCLEAR_KEY_BUF", "setCLEAR_KEY_BUF", "CLEAR_KEY_BUF_DATA", "getCLEAR_KEY_BUF_DATA", "setCLEAR_KEY_BUF_DATA", "CLEAR_MSG_LAST_BUFF", "getCLEAR_MSG_LAST_BUFF", "CLEAR_MUTITAB_NEW_RED_DOT", "getCLEAR_MUTITAB_NEW_RED_DOT", "CLEAR_PNG_VIDEO_CACHE", "getCLEAR_PNG_VIDEO_CACHE", "setCLEAR_PNG_VIDEO_CACHE", "CLEAR_SIMILAR_TIPS", "getCLEAR_SIMILAR_TIPS", "COMMENT_EXPAND", "getCOMMENT_EXPAND", "COMMENT_FRIEND_CAN_CLICK", "getCOMMENT_FRIEND_CAN_CLICK", "COMMENT_FULL_SCREEN", "getCOMMENT_FULL_SCREEN", "COMMENT_PRELOAD_ENABLE", "getCOMMENT_PRELOAD_ENABLE", "COMMENT_PRELOAD_REMAIN_COUNT", "getCOMMENT_PRELOAD_REMAIN_COUNT", "COMMENT_TEXT_LIMIT", "getCOMMENT_TEXT_LIMIT", "COVER_COMPRESS_QUALITY", "getCOVER_COMPRESS_QUALITY", "setCOVER_COMPRESS_QUALITY", "COVER_MAX_HEIGHT", "getCOVER_MAX_HEIGHT", "setCOVER_MAX_HEIGHT", "COVER_MAX_WIDTH", "getCOVER_MAX_WIDTH", "setCOVER_MAX_WIDTH", "CP_TO_CLIPBOARD", "getCP_TO_CLIPBOARD", "Comment_Max_Length", "getComment_Max_Length", "DEBUG_FAV_SIMILAR", "getDEBUG_FAV_SIMILAR", "DEBUG_POST_UPLOAD_BLOCK", "getDEBUG_POST_UPLOAD_BLOCK", "DEBUG_PRIVATE_LIKE_TIPS_COUNT", "getDEBUG_PRIVATE_LIKE_TIPS_COUNT", "setDEBUG_PRIVATE_LIKE_TIPS_COUNT", "DEBUG_SWITCH_SCENE_TIP", "getDEBUG_SWITCH_SCENE_TIP", "setDEBUG_SWITCH_SCENE_TIP", "DEFAULT_FAKE_VIDEO_CONFIG_JSON", "", "DEFAULT_GESTURE_PREVIEW_MEDIA_JSON", "DEFAULT_REPLY_SCENE", "getDEFAULT_REPLY_SCENE", "setDEFAULT_REPLY_SCENE", "DELAY_TIME", "getDELAY_TIME", "setDELAY_TIME", "DOUBLE_CLICK_RESET_FAV_RED_DOT", "getDOUBLE_CLICK_RESET_FAV_RED_DOT", "setDOUBLE_CLICK_RESET_FAV_RED_DOT", "DUMP_FILE_TIME_INTERVAL", "", "getDUMP_FILE_TIME_INTERVAL", "()J", "EDITOR_TRANSITION_MAGIC", "getEDITOR_TRANSITION_MAGIC", "EMPTY_FOOTER_IGNORE_CHECK", "getEMPTY_FOOTER_IGNORE_CHECK", "ENABLE_FINDER_MESSAGE", "getENABLE_FINDER_MESSAGE", "ENABLE_POST_43_RADIO_VIDEO", "getENABLE_POST_43_RADIO_VIDEO", "ENABLE_SHOW_OTHER_PROFILE_FANS", "getENABLE_SHOW_OTHER_PROFILE_FANS", "ENABLE_VIDEO_TEMPLTE", "getENABLE_VIDEO_TEMPLTE", "EXPOSE_COMMENTBTN_SHOW", "getEXPOSE_COMMENTBTN_SHOW", "EXPOSE_COMMENT_SHOW", "getEXPOSE_COMMENT_SHOW", "FAKE_CARD_JUMP_HOT_TAB_DATA", "getFAKE_CARD_JUMP_HOT_TAB_DATA", "FAKE_DATA_IN_SELF_SCENE", "getFAKE_DATA_IN_SELF_SCENE", "FAKE_LOADING_TOAST", "getFAKE_LOADING_TOAST", "FAKE_VIDEO_CONFIG_JSON", "kotlin.jvm.PlatformType", "getFAKE_VIDEO_CONFIG_JSON", "()Ljava/lang/String;", "FEED_ALL_FORCE_NEWS", "getFEED_ALL_FORCE_NEWS", "FEED_COMMENT_EDU", "getFEED_COMMENT_EDU", "FEED_ONLY_ME_VISIBLE", "getFEED_ONLY_ME_VISIBLE", "setFEED_ONLY_ME_VISIBLE", "FINDER_CLEAR_CACHE", "getFINDER_CLEAR_CACHE", "FINDER_CREATE_GUIDE_ENTRY", "getFINDER_CREATE_GUIDE_ENTRY", "FINDER_NOTIFY_RED_DOT", "getFINDER_NOTIFY_RED_DOT", "FINDER_NOTIFY_RED_DOT_VALUE", "", "Lkotlin/Pair;", "getFINDER_NOTIFY_RED_DOT_VALUE", "()Ljava/util/List;", "setFINDER_NOTIFY_RED_DOT_VALUE", "(Ljava/util/List;)V", "FINDER_OPEN_GESUTURE", "getFINDER_OPEN_GESUTURE", "FINDER_OPEN_PRELOAD_PREVIEW", "getFINDER_OPEN_PRELOAD_PREVIEW", "FINDER_SELF_STATE", "getFINDER_SELF_STATE", "FINDER_SHARE_MODE", "getFINDER_SHARE_MODE", "FINDER_TIMELINE_REFRESH_EXPIRED", "getFINDER_TIMELINE_REFRESH_EXPIRED", "FINDER_TIMLINE_ENTRY", "getFINDER_TIMLINE_ENTRY", "FIRST_HOT_TAB_PRELOAD_RANDOM", "getFIRST_HOT_TAB_PRELOAD_RANDOM", "FOLDED_MORE_ITEM_COUNT", "getFOLDED_MORE_ITEM_COUNT", "FOLDER_MAXSIZE_OF_AVATAR", "getFOLDER_MAXSIZE_OF_AVATAR", "FOLDER_MAXSIZE_OF_CAPTURE", "getFOLDER_MAXSIZE_OF_CAPTURE", "FOLDER_MAXSIZE_OF_COVERIMG", "getFOLDER_MAXSIZE_OF_COVERIMG", "FOLDER_MAXSIZE_OF_IMAGE", "getFOLDER_MAXSIZE_OF_IMAGE", "FOLDER_MAXSIZE_OF_POSTTMP", "getFOLDER_MAXSIZE_OF_POSTTMP", "FOLDER_MAXSIZE_OF_TMP", "getFOLDER_MAXSIZE_OF_TMP", "FOLDER_MAXSIZE_OF_VIDEO", "getFOLDER_MAXSIZE_OF_VIDEO", "FOLDER_SIZE_LEVEL", "", "getFOLDER_SIZE_LEVEL", "()F", "FRIEND_COMMENT_SHOW_HEADER", "getFRIEND_COMMENT_SHOW_HEADER", "GRID_LAYOUT", "getGRID_LAYOUT", "HIGH_RECORD_BITRATE", "getHIGH_RECORD_BITRATE", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "setIMAGE_COMPRESS_QUALITY", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "IS_ADJUST_FEED_WHEN_OPEN_DRAWER", "getIS_ADJUST_FEED_WHEN_OPEN_DRAWER", "IS_SHOW_FAV_ANIM_UNLIMITED", "getIS_SHOW_FAV_ANIM_UNLIMITED", "IS_USE_VLOG_MODE", "getIS_USE_VLOG_MODE", "IS_VLOG_BACKGROUND_MUX", "getIS_VLOG_BACKGROUND_MUX", "Image_Max_Size", "getImage_Max_Size", "JSAPI_SWITCH", "getJSAPI_SWITCH", "LBS_CGI_ONLY_STREAM", "getLBS_CGI_ONLY_STREAM", "LBS_TAB_LOCATION_DURATION", "getLBS_TAB_LOCATION_DURATION", "LBS_TAB_WAIT_LOCATION_TIME", "getLBS_TAB_WAIT_LOCATION_TIME", "LIKE_COMMENT_EDU", "getLIKE_COMMENT_EDU", "LOAD_IMAGE_ANIM", "getLOAD_IMAGE_ANIM", "MAKE_POST_FAILED", "getMAKE_POST_FAILED", "setMAKE_POST_FAILED", "(Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;)V", "MAKE_POST_MEDIAPROCESS_BLOCKING", "getMAKE_POST_MEDIAPROCESS_BLOCKING", "setMAKE_POST_MEDIAPROCESS_BLOCKING", "MAKE_SEND_COMMENT_FAIL", "getMAKE_SEND_COMMENT_FAIL", "setMAKE_SEND_COMMENT_FAIL", "MARK_READ_OPEN", "getMARK_READ_OPEN", "setMARK_READ_OPEN", "MAX_AT_COUNT", "getMAX_AT_COUNT", "MAX_COMMENT_NAME_COUNT", "getMAX_COMMENT_NAME_COUNT", "MAX_TOPIC_COUNT", "getMAX_TOPIC_COUNT", "MAX_TOPIC_LENGTH", "getMAX_TOPIC_LENGTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_PUBLISH_TEXT_LIMIT", "getMEDIA_PUBLISH_TEXT_LIMIT", "MMFINDER_MORE_LOG", "getMMFINDER_MORE_LOG", "MP_REPUDUCE_SWITCH", "getMP_REPUDUCE_SWITCH", "ONLY_SEARCH_CONTACT", "getONLY_SEARCH_CONTACT", "ONLY_SEE_FEED_TYPE", "getONLY_SEE_FEED_TYPE", "OPEN_FOLLOW_LIST_SEARCH_FLAG", "getOPEN_FOLLOW_LIST_SEARCH_FLAG", "ORIGIN_ACCOUNT_ENABLE", "getORIGIN_ACCOUNT_ENABLE", "ORIGIN_ACCOUNT_POST_TIPS", "getORIGIN_ACCOUNT_POST_TIPS", "value", "ORIGIN_ACCOUNT_POST_TIPS_COUNT", "getORIGIN_ACCOUNT_POST_TIPS_COUNT", "setORIGIN_ACCOUNT_POST_TIPS_COUNT", "ORIGIN_H5_URL", "getORIGIN_H5_URL", "POST_EDUCATION_DESC", "getPOST_EDUCATION_DESC", "POST_EDUCATION_TITLE", "getPOST_EDUCATION_TITLE", "POST_ENTRANCE_OUTSIDE_ENABLE", "getPOST_ENTRANCE_OUTSIDE_ENABLE", "POST_PROGRESS_WEIGHT_MEDIA_PROCESS", "getPOST_PROGRESS_WEIGHT_MEDIA_PROCESS", "POST_PROGRESS_WEIGHT_NETSCENE", "getPOST_PROGRESS_WEIGHT_NETSCENE", "POST_PROGRESS_WEIGHT_UPLOAD", "getPOST_PROGRESS_WEIGHT_UPLOAD", "POST_VIDEO_COVER_COMPRESS_QUALITY", "getPOST_VIDEO_COVER_COMPRESS_QUALITY", "setPOST_VIDEO_COVER_COMPRESS_QUALITY", "PRELOAD_DURATION", "getPRELOAD_DURATION", "PRIVATE_ACCOUNT_ENABLE", "getPRIVATE_ACCOUNT_ENABLE", "PRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "getPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "setPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "PROFILE_SHOW_FANS_COUNT", "getPROFILE_SHOW_FANS_COUNT", "PURE_TEXT_LIMIT", "getPURE_TEXT_LIMIT", "PhoneRemainSpace", "getPhoneRemainSpace", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "REAL_NAME_LIKE_AVATAR_RADIUS", "getREAL_NAME_LIKE_AVATAR_RADIUS", "RECYCLERVIEW_SPEED", "getRECYCLERVIEW_SPEED", "REDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "getREDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "RED_DOT_NO_TIME_LIMIT", "getRED_DOT_NO_TIME_LIMIT", "REFUSE_ALL_PRIVATE_MSG_SWITCH", "getREFUSE_ALL_PRIVATE_MSG_SWITCH", "REMUX_WITH_ABAPARAMS", "getREMUX_WITH_ABAPARAMS", "REPLY_SCENE", "getREPLY_SCENE", "setREPLY_SCENE", "REPORT_QUALITY_INFO", "getREPORT_QUALITY_INFO", "REPORT_QUALITY_INFO_CONFIG", "getREPORT_QUALITY_INFO_CONFIG", "REPORT_WHEN_SCREEN_SHOT", "getREPORT_WHEN_SCREEN_SHOT", "RESET_CAMERA_RED_DOT", "getRESET_CAMERA_RED_DOT", "setRESET_CAMERA_RED_DOT", "RESET_FIRST_POST_QUALIFICASTION", "getRESET_FIRST_POST_QUALIFICASTION", "RESET_PRIVATE_LIKE_TIPS_COUNT", "getRESET_PRIVATE_LIKE_TIPS_COUNT", "RESET_QUIT_TL_TIME_TO_ZERO", "getRESET_QUIT_TL_TIME_TO_ZERO", "SELECT_DISTRICT", "getSELECT_DISTRICT", "setSELECT_DISTRICT", "SELF_LIKE_EDU", "getSELF_LIKE_EDU", "SELF_PRIVATE_LIKE", "getSELF_PRIVATE_LIKE", "setSELF_PRIVATE_LIKE", "(Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;)V", "SELF_PRIVATE_LIKE_TIPS_COUNT", "getSELF_PRIVATE_LIKE_TIPS_COUNT", "setSELF_PRIVATE_LIKE_TIPS_COUNT", "SHARE_FEED_ENTRANCE", "getSHARE_FEED_ENTRANCE", "SHOW_POST_EDUCATION", "getSHOW_POST_EDUCATION", "SHOW_SELF_FEED_LIKE_TIPS_TIMES", "getSHOW_SELF_FEED_LIKE_TIPS_TIMES", "setSHOW_SELF_FEED_LIKE_TIPS_TIMES", "SIZE_KB", "getSIZE_KB", "SIZE_MB", "getSIZE_MB", "SNS_TO_FINDER_SWITCH", "getSNS_TO_FINDER_SWITCH", "STATS_REPORT_CONTROL", "getSTATS_REPORT_CONTROL", "setSTATS_REPORT_CONTROL", "STREAM_CARD_LAYOUT", "getSTREAM_CARD_LAYOUT", "STREAM_CDN_CONNECTION_COUNT", "getSTREAM_CDN_CONNECTION_COUNT", "setSTREAM_CDN_CONNECTION_COUNT", "SWITCH_FEED_TITLE_STYLE", "getSWITCH_FEED_TITLE_STYLE", "SWITCH_SCENE_TIP", "getSWITCH_SCENE_TIP", "setSWITCH_SCENE_TIP", "SWITC_VIEW_PAGE_TIME", "getSWITC_VIEW_PAGE_TIME", "SYNC_TIME_INTERVAL", "getSYNC_TIME_INTERVAL", "setSYNC_TIME_INTERVAL", "TAG", "THREE_DAY", "THREE_DAY_THRESHOLD", "getTHREE_DAY_THRESHOLD", "THREE_DAY_TWO_DAY_ENABLE", "getTHREE_DAY_TWO_DAY_ENABLE", "TIMELINE_CRASH", "getTIMELINE_CRASH", "setTIMELINE_CRASH", "TIMELINE_ENABLE_SUB_PAGE", "getTIMELINE_ENABLE_SUB_PAGE", "TIMELINE_LIKE_EVENT", "getTIMELINE_LIKE_EVENT", "TIMELINE_LOADING_EXPIRED_TIME", "getTIMELINE_LOADING_EXPIRED_TIME", "TIMELINE_POST_ENTRANCE", "getTIMELINE_POST_ENTRANCE", "TIMELINE_REFRESH_EXPIRED_TIME", "getTIMELINE_REFRESH_EXPIRED_TIME", "TIMELINE_SUB_PAGE_COUNT", "getTIMELINE_SUB_PAGE_COUNT", "TOPIC_JUMP_POI_SWITCH", "getTOPIC_JUMP_POI_SWITCH", "TOPIC_SUGGEST_SWITCH", "getTOPIC_SUGGEST_SWITCH", "TOPIC_SWITCH", "getTOPIC_SWITCH", "TWO_DAY", "TWO_DAY_THRESHOLD", "getTWO_DAY_THRESHOLD", "Thumb_Max_Size", "getThumb_Max_Size", "USE_DAEMON_RECORD", "getUSE_DAEMON_RECORD", "VIDEO_3_4_RATIO", "getVIDEO_3_4_RATIO", "VIDEO_THUMB_MAX_SIZE", "getVIDEO_THUMB_MAX_SIZE", "VideoQualityDefault", "getVideoQualityDefault", "Video_Max_Size", "getVideo_Max_Size", "setVideo_Max_Size", "Video_Remux_Max_Count", "getVideo_Remux_Max_Count", "debugDumpFileTimeInterval", "getDebugDumpFileTimeInterval", "setDebugDumpFileTimeInterval", "(J)V", "debugPreloadComment", "getDebugPreloadComment", "setDebugPreloadComment", "debugPreloadCommentRemainCount", "getDebugPreloadCommentRemainCount", "setDebugPreloadCommentRemainCount", "debugTextLimit", "getDebugTextLimit", "setDebugTextLimit", "debugTopicJumpPoi", "getDebugTopicJumpPoi", "setDebugTopicJumpPoi", "follow_no_reddot_prefetch_inner_interval", "getFollow_no_reddot_prefetch_inner_interval", "follow_no_reddot_prefetch_outter_interval", "getFollow_no_reddot_prefetch_outter_interval", "follow_reddot_prefetch_inner_interval", "getFollow_reddot_prefetch_inner_interval", "follow_reddot_prefetch_outter_interval", "getFollow_reddot_prefetch_outter_interval", "friend_no_reddot_prefetch_inner_interval", "getFriend_no_reddot_prefetch_inner_interval", "friend_no_reddot_prefetch_outter_interval", "getFriend_no_reddot_prefetch_outter_interval", "friend_reddot_prefetch_inner_interval", "getFriend_reddot_prefetch_inner_interval", "friend_reddot_prefetch_outter_interval", "getFriend_reddot_prefetch_outter_interval", "hot_no_reddot_prefetch_inner_interval", "getHot_no_reddot_prefetch_inner_interval", "hot_no_reddot_prefetch_outter_interval", "getHot_no_reddot_prefetch_outter_interval", "hot_reddot_prefetch_inner_interval", "getHot_reddot_prefetch_inner_interval", "hot_reddot_prefetch_outter_interval", "getHot_reddot_prefetch_outter_interval", "isEnableGesturePreviewImage", "isEnableGesturePreviewImage$delegate", "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo$delegate", "isEnableGestureSeekBar", "isEnablePreloadStreamRefresh", "isEnablePreloadVideoForPreloadStream", "isEnableShowNew", "isEnableStoreLastTabType", "isGetGps", "isMoreTabEnable", "isNeverEnterMultiTab", "setNeverEnterMultiTab", "isOpenMultiBitRateDownload", "isPreloadImageEnable", "isPreloadVideoEnable", "isTestStreamFetch", "localEnableShowNew", "getLocalEnableShowNew", "setLocalEnableShowNew", "mp4ParserMode", "getMp4ParserMode", "msg", "getMsg", "nearby_no_reddot_prefetch_inner_interval", "getNearby_no_reddot_prefetch_inner_interval", "nearby_no_reddot_prefetch_outter_interval", "getNearby_no_reddot_prefetch_outter_interval", "nearby_reddot_prefetch_inner_interval", "getNearby_reddot_prefetch_inner_interval", "nearby_reddot_prefetch_outter_interval", "getNearby_reddot_prefetch_outter_interval", "tab_inner_hot_prefetch_switch", "getTab_inner_hot_prefetch_switch", "timelineShowTipsDuration", "getTimelineShowTipsDuration", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "videoAlbumMaxSelectDuration", "getVideoAlbumMaxSelectDuration", "videoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoRatioRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getVideoRatioRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "videoRecordPara", "getVideoRecordPara", "checkEnableGesturePreviewMedia", "", "getTabName", "tabType", "defaultStr", "getVideoViewConfig", "plugin-finder_release"})
public final class b
{
  private static final String msg;
  private static final int sER = 1024;
  private static final int sES = 1048576;
  private static final int sET = 40;
  private static final int sEU = 10485760;
  private static final int sEV = 1048576;
  private static int sEW = 0;
  private static int sEX = 0;
  private static final int sEY = 300;
  private static int sEZ = 0;
  private static int sFA = 0;
  private static int sFB = 0;
  private static boolean sFC = false;
  private static int sFD = 0;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFE;
  private static final boolean sFF = false;
  private static final long sFG = 2000L;
  private static final boolean sFH = false;
  private static final int sFI = 300000;
  private static final int sFJ = 5000;
  private static final int sFK;
  private static boolean sFL = false;
  private static final d.k.b<Double> sFM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFP;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFQ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFT;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a sFU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFW;
  private static final c sFX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFZ;
  private static int sFa = 0;
  private static int sFb = 0;
  private static final int sFc = 143360;
  private static int sFd = 0;
  private static int sFe = 0;
  private static int sFf = 0;
  private static int sFg = 0;
  private static int sFh = 0;
  private static int sFi = 0;
  private static int sFj = 0;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sFk;
  private static final int sFl = 3;
  private static final int sFm = 800;
  private static int sFn = 0;
  private static final int sFo = 45;
  private static final int sFp = 45;
  private static final int sFq = 10;
  private static boolean sFr;
  private static boolean sFs;
  private static long sFt;
  private static final long sFu;
  private static final f sFv;
  private static final f sFw;
  private static final f sFx;
  private static int sFy;
  private static boolean sFz;
  private static final c sGA;
  private static final c sGB;
  private static final c sGC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGD;
  private static final c sGE;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a sGF;
  private static final c sGG;
  private static final c sGH;
  private static final c sGI;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGJ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> sGK;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> sGL;
  private static final c sGM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGP;
  private static List<o<Integer, String>> sGQ;
  private static boolean sGR;
  private static boolean sGS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGW;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGX;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a sGY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGa;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGb;
  private static final c sGc;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGd;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGe;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGf;
  private static c sGg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGh;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a sGi;
  private static c sGj;
  private static c sGk;
  private static c sGl;
  private static c sGm;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGn;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGo;
  private static c sGp;
  private static c sGq;
  private static c sGr;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGs;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGt;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGu;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGv;
  private static c sGw;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sGx;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a sGy;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a sGz;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHA;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHB;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHE;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHF;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHH;
  private static final c sHI;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHJ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHK;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHL;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHO;
  public static final b sHP;
  private static c sHa;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> sHb;
  private static final c sHc;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHd;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHe;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHf;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHh;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHi;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHj;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHk;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHl;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHm;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHn;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHo;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHp;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHq;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHr;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHs;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHt;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHu;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHv;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHw;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHx;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHy;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> sHz;
  
  static
  {
    AppMethodBeat.i(166903);
    sHP = new b();
    sER = 1024;
    sES = 1048576;
    sET = 40;
    sEU = sES * 10;
    sEV = sES * 1;
    sEW = sES * 28;
    sEX = sES * 28;
    sEY = 300;
    sEZ = 1280;
    sFa = 1080;
    sFb = 90;
    sFc = sER * 140;
    sFd = 1080;
    sFe = 1080;
    sFf = 70;
    sFg = 1080;
    sFh = 1080;
    sFi = 70;
    sFj = 50;
    sFk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "不再接收私信入口").ajx("FinderPrivateRefuseAllMsgSwitch").b("REFUSE_ALL_PRIVATE_MSG_SWITCH", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "默认(0)", "打开入口(1)", "关闭入口(0)" }));
    sFl = 3;
    sFm = 800;
    sFn = 300000;
    sFo = 45;
    sFp = 45;
    sFq = 10;
    sFt = -1L;
    sFu = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
    msg = "\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + cHK() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + cHG() + " 后台处理\n    3、可配置（接x）：timeline顶部相机入口是否展示（默认展示）" + cHH() + "\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量）\n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + cHI() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + com.tencent.mm.plugin.expt.b.b.a.qGT + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ";
    sFv = d.g.O((d.g.a.a)b.aa.sIq);
    sFw = d.g.O((d.g.a.a)b.ab.sIr);
    sFx = d.g.O((d.g.a.a)b.s.sIi);
    sFy = 1;
    sFA = 5;
    sFB = 2;
    sFC = true;
    sFE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300000, "tab流自动刷新缓存时间").d(com.tencent.mm.plugin.expt.b.b.a.qHa).b("AUTO_REEFRESH_CACHE_INTERVAL", d.a.j.listOf(new Integer[] { Integer.valueOf(300000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) }), d.a.j.listOf(new String[] { "默认(5min)", "10s", "30s", "1min" }));
    sFG = 2000L;
    sFI = 300000;
    sFJ = 5000;
    sFK = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qNP, 0);
    sFL = true;
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.d.CeI;
    if (com.tencent.mm.plugin.vlog.ui.plugin.d.ewY())
    {
      localObject = d.k.j.L(0.75D);
      sFM = (d.k.b)localObject;
      sFN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "二级评论是否展开").ajx("FinderCommentAutoExpandSubcommentList").b("COMMENT_EXPAND_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), d.a.j.listOf(new String[] { "是", "否" }));
      sFO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞").d(com.tencent.mm.plugin.expt.b.b.a.qHf).b("REAL_NAME_LIKE_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "实名点赞", "非实名点赞" }));
      sFP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞头像").d(com.tencent.mm.plugin.expt.b.b.a.qHh).b("REAL_NAME_LIKE_AVATAR_RADIUS_CONTROL", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "圆头像", "方头像" }));
      sFQ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "评论全屏方案").d(com.tencent.mm.plugin.expt.b.b.a.qHe).b("COMMENT_STYLE_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), d.a.j.listOf(new String[] { "全屏", "半屏" }));
      sFR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "圈外分享模式(仅预览)").d(com.tencent.mm.plugin.expt.b.b.a.qHe).b("USERINFO_FINDER_FORWARD_DEBUG_TYPE_INT", d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "默认", "允许nickname", "过滤nickname" }));
      sFS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "附近tab使用瀑布流/卡片流开关").d(com.tencent.mm.plugin.expt.b.b.a.qHd).b("LBS_UI_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "瀑布流", "卡片流" }));
      sFT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(20, "关注/点赞折叠超过x条后折叠").b("FOLLOW_LIKE_FOLD_MORE_THAN_X", d.a.j.listOf(new Integer[] { Integer.valueOf(20), Integer.valueOf(3) }), d.a.j.listOf(new String[] { "20", "3" }));
      sFU = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "开启视频预加载预览View", "USERINFO_FINDER_PRELOAD_VIEW_BOOLEAN_SYNC");
      sFV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否开启手势切Tab").b("USERINFO_FINDER_GESTURE_TAB_INT", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "默认(0)", "关闭(-1)", "打开(1)" }));
      sFW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "切换单Tab").d(com.tencent.mm.plugin.expt.b.b.a.qHc).b("FINDER_TAB_STYLE_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "切换多tab", "切换单tab" }));
      sFX = new c("重置最后退出TL时间为0", (d.g.a.a)b.y.sIo);
      sFY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "评论字数限制10").ajx("FinderCommentTextLimit").b("COMMENT_TEXT_LIMIT_CONFIG", d.a.j.listOf(Integer.valueOf(10)), d.a.j.listOf("评论字数限制10"));
      sFZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "Media字数限制15").ajx("FinderMediaPublishTextLimit").b("MEDIA_TEXT_LIMIT_CONFIG", d.a.j.listOf(Integer.valueOf(15)), d.a.j.listOf("Media字数限制15"));
      sGa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "纯文本字数限制15").ajx("FinderPureTextPublishTextLimit").b("PURE_TEXT_LIMIT_CONFIG", d.a.j.listOf(Integer.valueOf(20)), d.a.j.listOf("纯文本字数限制15"));
      sGb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "最大话题数改为3个").ajx("FinderMaxTopicCount").b("MAX_TOPIC_CONFIG", d.a.j.listOf(Integer.valueOf(3)), d.a.j.listOf("最大话题数改为3个"));
      sGc = new c("假菊花Toast", (d.g.a.a)b.o.sIe);
      sGd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(15, "话题最大长度改为10").ajx("FinderTopicTextLimit").b("MAX_TOPIC_LENGTH_CONFIG", d.a.j.listOf(Integer.valueOf(10)), d.a.j.listOf("话题最大长度改为10"));
      sGe = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "话题推荐开关").ajx("FinderSuggestTagViewShow").b("TOPIC_RECOMMEND_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), d.a.j.listOf(new String[] { "打开", "关闭" }));
      sGf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "打开切换身份评论").d(com.tencent.mm.plugin.expt.b.b.a.qHO).b("CAN_SWITCH_SCENE", d.a.j.listOf(Integer.valueOf(1)), d.a.j.listOf("打开"));
      sGg = new c("重置切换身份提示", (d.g.a.a)b.l.sIb);
      sGh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "最大at数改为3个").ajx("FinderMaxMentionSbCount").b("MAX_AT_COUNT_CONFIG", d.a.j.listOf(Integer.valueOf(3)), d.a.j.listOf("最大at数改为3个"));
      sGi = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "发表feed/评论点赞固定失败");
      sGj = new c("评论点赞重试间隔改为1s", (d.g.a.a)m.sIc);
      sGk = new c("清除keybuf/账号数据", (d.g.a.a)b.e.sHU);
      sGl = new c("清除图片视频所有缓存", (d.g.a.a)h.sHX);
      sGm = new c("清空keybuf", (d.g.a.a)b.d.sHT);
      sGn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(80, "RecyclerView滑动速度").b("RECYCLERVIEW_SPEED", d.a.j.listOf(new Integer[] { Integer.valueOf(80), Integer.valueOf(50), Integer.valueOf(60), Integer.valueOf(70), Integer.valueOf(80), Integer.valueOf(90), Integer.valueOf(100), Integer.valueOf(130) }), d.a.j.listOf(new String[] { "默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍" }));
      sGo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300, "loadmore假菊花时长").ajx("FinderFakeLoadingDurationMS").b("TIMELINE_LOADING_EXPIRED_TIME", d.a.j.listOf(new Integer[] { Integer.valueOf(100), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(500), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(3000) }), d.a.j.listOf(new String[] { "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      sGp = new c("把自己改成非白名单用户", (d.g.a.a)b.a.sHQ);
      sGq = new c("把所有feed改为仅自己可见", (d.g.a.a)p.sIf);
      sGr = new c("双击与展开教育/收藏红点重置", (d.g.a.a)b.n.sId);
      sGs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "红点不受配置时间限制").b("USERINFO_FINDER_TEST_RED_DOT_FACTOR_INT_SYNC", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(1000000000) }), d.a.j.listOf(new String[] { "默认", "无限制" }));
      sGt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "后台合成").b("USERINFO_FINDER_VIDEO_REMUX_BACKGROUND_INT_SYNC", d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "X实验配置", "否", "是" }));
      if ((!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) && (!com.tencent.mm.sdk.platformtools.j.DEBUG)) {
        break label8406;
      }
      i = 1;
      label2254:
      sGu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(i, "特效").b("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "关", "开" }));
      sGv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "允许3:4视频比例").b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "默认", "开", "关" }));
      sGw = new c("发表相机红点重置", (d.g.a.a)b.v.sIl);
      sGx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "只看某个feed").b("USERINFO_FINDER_CARE_FEED_TYPE_INT", d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8) }), d.a.j.listOf(new String[] { "DEFAULT", "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA" }));
      sGy = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "进入视频号Crash");
      sGz = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "输出视频号DEBUG日志", "USERINFO_FINDER_DEBUG_LOG_BOOLEAN_SYNC");
      sGA = new c("清理首页文件缓存", (d.g.a.a)b.q.sIg);
      sGB = new c("查看Finder缓存大小", (d.g.a.a)b.b.sHR);
      sGC = new c("复制finder配置到剪贴板", (d.g.a.a)j.sHZ);
      sGD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "个人中心用户状态").b("FINDER_SELF_STATE", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(-1) })), (List)new ArrayList((Collection)d.a.j.listOf(new String[] { "无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "全网禁言", "reset" })));
      sGE = new c("重置首次获得发表权限标志", (d.g.a.a)b.w.sIm);
      sGF = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(true, "自动触发正例反馈");
      sGG = new c("清空通知lastBuffer", (d.g.a.a)f.sHV);
      sGH = new c("清理New红点配置", (d.g.a.a)b.g.sHW);
      sGI = new c("清理更多相似动态状态", (d.g.a.a)b.i.sHY);
      sGJ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "打开评论抽屉是否调整feed位置").b("IS_ADJUST_FEED_WHEN_OPEN_DRAWER", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "默认模式(关闭)", "自动调整模式" }));
      sGK = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(500L, "refresh假菊花时长").d(com.tencent.mm.plugin.expt.b.b.a.qzz).b("TIMELINE_REFRESH_EXPIRED_TIME", (List)new ArrayList((Collection)d.a.j.listOf(new Long[] { Long.valueOf(500L), Long.valueOf(100L), Long.valueOf(200L), Long.valueOf(400L), Long.valueOf(500L), Long.valueOf(600L), Long.valueOf(700L), Long.valueOf(800L), Long.valueOf(1000L), Long.valueOf(3000L) })), d.a.j.listOf(new String[] { "默认(500)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      sGL = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(1200000L, "预加载debug轮询时长").d(com.tencent.mm.plugin.expt.b.b.a.qzy).b("PRELOAD_DURATION", (List)new ArrayList((Collection)d.a.j.listOf(new Long[] { Long.valueOf(1200000L), Long.valueOf(5000L), Long.valueOf(10000L), Long.valueOf(60000L) })), d.a.j.listOf(new String[] { "默认(20min)", "5s", "10s", "1min" }));
      sGM = new c("生效一次，收到红点会去掉（朋友/关注）发现页红点", (d.g.a.a)b.c.sHS);
      sGN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频模板").b("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "关", "开" }));
      sGO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "点赞事件UI").b("TIMELINE_LIKE_EVENT_CONFIG", d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "卡片模式", "m+n模式" }));
      sGP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "FIDNER_RED_DOT_STYLE").b("FIDNER_RED_DOT_STYLE", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(-1) }), d.a.j.listOf(new String[] { "4(ICON)+liked", "7(SQUARE_ICON)+liked", "11(ICON_WITH_RED_DOT)+liked", "12(SQUARE_ICON_WITH_RED_DOT)+liked", "liked+13(RIGHT_ICON_WITH_RED_DOT)", "liked+14(RIGHT_SQUARE_ICON_WITH_RED_DOT)", "4(ICON)", "7(SQUARE_ICON)", "default" }));
      sGQ = d.a.j.listOf(new o[] { new o(Integer.valueOf(4), "liked"), new o(Integer.valueOf(7), "liked"), new o(Integer.valueOf(11), "liked"), new o(Integer.valueOf(12), "liked"), new o(Integer.valueOf(13), "liked"), new o(Integer.valueOf(14), "liked"), new o(Integer.valueOf(4), ""), new o(Integer.valueOf(7), ""), new o(Integer.valueOf(-1), "") });
      sGR = true;
      sGS = true;
      sGT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否打开私信入口").d(com.tencent.mm.plugin.expt.b.b.a.qHk).b("ENABLE_FINDER_MESSAGE", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }), d.a.j.listOf(new String[] { "默认", "打开", "关闭" }));
      sGU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "截屏上报").d(com.tencent.mm.plugin.expt.b.b.a.qIa).b("FINDER_REPORT_WHEN_SCREEN_SHOT", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "打开", "关闭" }));
      sGV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否在朋友tab制造个假跳转热门数据").b("FAKE_CARD_JUMP_HOT_TAB_DATA", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "打开", "关闭" }));
      if (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) {
        break label8411;
      }
    }
    label8406:
    label8411:
    for (int i = 1;; i = 0)
    {
      sGW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(i, "加载图片渐现").b("LOAD_IMAGE_ANIM", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "打开", "关闭" }));
      sGX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "切换ViewPage速度").b("SWITC_VIEW_PAGE_TIME", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(1200), Integer.valueOf(1500) })), d.a.j.listOf(new String[] { "默认", "200", "400", "600", "700", "800", "1000", "1200", "1500" }));
      sGY = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "是否在作者视角动态展示假数据");
      sGZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "私密帐号").d(com.tencent.mm.plugin.expt.b.b.a.qIm).b("PRIVATE_ACCOUNT_ENABLE_DEBUG", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "打开", "关闭" }));
      sHa = new c("重置私密feed点赞提示次数", (d.g.a.a)b.k.sIa);
      sHb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "支持匿名赞").d(com.tencent.mm.plugin.expt.b.b.a.qIM).b("USERINFO_SELF_PRIVATE_LIKE_INT_SYNC", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "默认", "支持", "不支持" }));
      sHc = new c("重置私密feed点赞和匿名赞提示次数", (d.g.a.a)b.x.sIn);
      sHd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏动画开关").b("IS_SHOW_FAV_ANIM_UNLIMITED", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHe = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频质量分上报").d(com.tencent.mm.plugin.expt.b.b.a.qIn).b("REPORT_QUALITY_INFO", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "选择 FeedHeadBar 样式").d(com.tencent.mm.plugin.expt.b.b.a.qIb).b("SWITCH_FEED_TITLE_STYLE", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) })), d.a.j.listOf(new String[] { "默认(0)", "沉浸式(1)", "非沉浸式(0)", "4:3 沉浸式(2)" }));
      sHg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表支持4:3").d(com.tencent.mm.plugin.expt.b.b.a.qPL).b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "默认", "支持", "不支持" }));
      sHh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "TL导航栏icon样式").d(com.tencent.mm.plugin.expt.b.b.a.qPK).b("POST_ENTRANCE_OUTSIDE_ENABLE", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), d.a.j.listOf(new String[] { "[A]默认", "[B]发表右上角+热门加附近", "[C]搜索右上角+热门加附近", "[D]热门加附近" })).C((d.g.a.b)b.u.sIk);
      sHi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "切换朋友圈跳视频号入口类型", (d.g.a.b)b.z.sIp).b("SNS_TO_FINDER_SWITCH", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), d.a.j.listOf(new String[] { "默认", "跳转方式1", "跳转方式2" }));
      sHj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表上传block").b("DEBUG_POST_UPLOAD_BLOCK", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(20) })), d.a.j.listOf(new String[] { "不block", "block 20秒" }));
      sHk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏出相似流").b("DEBUG_FAV_SIMILAR", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "使用后台配置", "支持" }));
      sHl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_o_interval").b("follow_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_o_interval").b("friend_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_o_interval").b("hot_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_o_interval").b("nearby_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_o_interval").b("follow_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_o_interval").b("friend_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_o_interval").b("hot_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_o_interval").b("nearby_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_i_interval").b("follow_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_i_interval").b("friend_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_i_interval").b("hot_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_i_interval").b("nearby_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_i_interval").b("follow_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_i_interval").b("friend_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_i_interval").b("hot_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_i_interval").b("nearby_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), d.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      sHB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "tab_inner_hot_prefetch_switch").b("tab_inner_hot_prefetch_switch", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(0) })), d.a.j.listOf(new String[] { "默认", "true", "false" }));
      sHC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否本地调整点赞头像顺序").d(com.tencent.mm.plugin.expt.b.b.a.qHl).b("ADJUST_AVATAR_ORDER_LIKE", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "引导用户点赞自己的视频").d(com.tencent.mm.plugin.expt.b.b.a.qPV).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "支持" }));
      sHE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "引导用户点赞后评论").d(com.tencent.mm.plugin.expt.b.b.a.qIp).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "支持" }));
      sHF = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "专栏布局样式大小").b("STREAM_CARD_LAYOUT", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })), d.a.j.listOf(new String[] { "不支持", "大大大 ", " 小小小 " }));
      sHG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "feed播放一段时间后，出评论输入框").d(com.tencent.mm.plugin.expt.b.b.a.qIq).b("FEED_COMMENT_EDU", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "原创帐号开关").b("ORIGIN_ACCOUNT_ENABLE", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHI = new c("原创帐号发表提示和红点重置", (d.g.a.a)b.t.sIj);
      sHJ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "朋友的外显评论是否显示头像").d(com.tencent.mm.plugin.expt.b.b.a.qIr).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "强制所有feed都为新闻类").b("FEED_ALL_FORCE_NEWS", d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "首次打开热门预加载请求随机数").d(com.tencent.mm.plugin.expt.b.b.a.qIs).b("FIRST_HOT_TAB_PRELOAD_RANDOM", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(10) })), d.a.j.listOf(new String[] { "重置first", "关闭", "50%", "20%", "10%" })).C((d.g.a.b)b.r.sIh);
      sHM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "3天2天总开关").d(com.tencent.mm.plugin.expt.b.b.a.qIt).b("THREE_DAY_TWO_DAY_ENABLE", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), d.a.j.listOf(new String[] { "关闭", "打开" }));
      sHN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(259200000, "3天超时阈值").d(com.tencent.mm.plugin.expt.b.b.a.qIu).b("THREE_DAY_THRESHOLD", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(259200000), Integer.valueOf(30000), Integer.valueOf(180000) })), d.a.j.listOf(new String[] { "3天", "30 秒", "3 分钟" }));
      sHO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(172800000, "2天不出阈值").d(com.tencent.mm.plugin.expt.b.b.a.qIv).b("TWO_DAY_THRESHOLD", (List)new ArrayList((Collection)d.a.j.listOf(new Integer[] { Integer.valueOf(172800000), Integer.valueOf(20000), Integer.valueOf(120000) })), d.a.j.listOf(new String[] { "2天", "20 秒", "2 分钟" }));
      AppMethodBeat.o(166903);
      return;
      localObject = d.k.j.L(0.857142857142857D);
      break;
      i = 0;
      break label2254;
    }
  }
  
  public static void FC(int paramInt)
  {
    sFn = paramInt;
  }
  
  public static void FD(int paramInt)
  {
    AppMethodBeat.i(204179);
    ae.i("FinderConfig", "set REPLY_SCENE value:".concat(String.valueOf(paramInt)));
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jdv, Integer.valueOf(paramInt));
    AppMethodBeat.o(204179);
  }
  
  public static void FE(int paramInt)
  {
    AppMethodBeat.i(204192);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcO, Integer.valueOf(paramInt));
    AppMethodBeat.o(204192);
  }
  
  public static void FF(int paramInt)
  {
    AppMethodBeat.i(204194);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcR, Integer.valueOf(paramInt));
    AppMethodBeat.o(204194);
  }
  
  public static void FG(int paramInt)
  {
    AppMethodBeat.i(204199);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcP, Integer.valueOf(paramInt));
    AppMethodBeat.o(204199);
  }
  
  public static void FH(int paramInt)
  {
    AppMethodBeat.i(204201);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JcQ, Integer.valueOf(paramInt));
    AppMethodBeat.o(204201);
  }
  
  public static void FI(int paramInt)
  {
    AppMethodBeat.i(204205);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JbD, Integer.valueOf(paramInt));
    AppMethodBeat.o(204205);
  }
  
  public static String aZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(204184);
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
        AppMethodBeat.o(204184);
        return "";
        paramString = ak.getContext().getString(2131766501);
        p.g(paramString, "MMApplicationContext.get…string.finder_tab_friend)");
        continue;
        paramString = ak.getContext().getString(2131766500);
        p.g(paramString, "MMApplicationContext.get…string.finder_tab_follow)");
        continue;
        paramString = ak.getContext().getString(2131766503);
        p.g(paramString, "MMApplicationContext.get…tring.finder_tab_machine)");
        break;
      case 1: 
        locale = com.tencent.mm.kernel.g.ajR();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.ajA().get(am.a.JbM, paramString);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(204184);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(204184);
        return paramString;
      case 3: 
        locale = com.tencent.mm.kernel.g.ajR();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.ajA().get(am.a.JbO, paramString);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(204184);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(204184);
        return paramString;
      case 4: 
        locale = com.tencent.mm.kernel.g.ajR();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.ajA().get(am.a.JbN, paramString);
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(204184);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(204184);
        return paramString;
      }
    }
  }
  
  public static VideoTransPara cGT()
  {
    AppMethodBeat.i(166904);
    Object localObject = com.tencent.mm.modelcontrol.d.aHh();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.d)localObject).aHm();
    AppMethodBeat.o(166904);
    return localObject;
  }
  
  public static VideoTransPara cGU()
  {
    AppMethodBeat.i(166905);
    Object localObject = com.tencent.mm.modelcontrol.d.aHh();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.d)localObject).aHn();
    AppMethodBeat.o(166905);
    return localObject;
  }
  
  public static int cGV()
  {
    AppMethodBeat.i(166906);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGX, 300);
    AppMethodBeat.o(166906);
    return i;
  }
  
  public static boolean cGW()
  {
    AppMethodBeat.i(166907);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHI, 1) == 1)
    {
      AppMethodBeat.o(166907);
      return true;
    }
    AppMethodBeat.o(166907);
    return false;
  }
  
  public static int cGX()
  {
    return sET;
  }
  
  public static boolean cGY()
  {
    AppMethodBeat.i(204164);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIi, 0) == 1)
    {
      AppMethodBeat.o(204164);
      return true;
    }
    AppMethodBeat.o(204164);
    return false;
  }
  
  public static boolean cGZ()
  {
    AppMethodBeat.i(204165);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIh, 0) == 1)
    {
      AppMethodBeat.o(204165);
      return true;
    }
    AppMethodBeat.o(204165);
    return false;
  }
  
  public static long cHA()
  {
    AppMethodBeat.i(166921);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHp, 500L) * sES) * cHx());
    AppMethodBeat.o(166921);
    return l;
  }
  
  public static long cHB()
  {
    AppMethodBeat.i(166922);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHq, 1024L) * sES) * cHx());
    AppMethodBeat.o(166922);
    return l;
  }
  
  public static long cHC()
  {
    AppMethodBeat.i(166923);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHr, 500L) * sES) * cHx());
    AppMethodBeat.o(166923);
    return l;
  }
  
  public static long cHD()
  {
    AppMethodBeat.i(166924);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHs, 500L) * sES) * cHx());
    AppMethodBeat.o(166924);
    return l;
  }
  
  public static long cHE()
  {
    AppMethodBeat.i(166925);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHt, 500L) * sES) * cHx());
    AppMethodBeat.o(166925);
    return l;
  }
  
  public static int cHF()
  {
    AppMethodBeat.i(166929);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderTimelineEntry", 0);
    AppMethodBeat.o(166929);
    return i;
  }
  
  public static boolean cHG()
  {
    AppMethodBeat.i(166930);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGR, 1) == 1)
    {
      AppMethodBeat.o(166930);
      return true;
    }
    AppMethodBeat.o(166930);
    return false;
  }
  
  public static boolean cHH()
  {
    AppMethodBeat.i(166931);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGQ, 1) == 1)
    {
      AppMethodBeat.o(166931);
      return true;
    }
    AppMethodBeat.o(166931);
    return false;
  }
  
  public static boolean cHI()
  {
    AppMethodBeat.i(166932);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGS, 1) == 1)
    {
      AppMethodBeat.o(166932);
      return true;
    }
    AppMethodBeat.o(166932);
    return false;
  }
  
  public static boolean cHJ()
  {
    AppMethodBeat.i(166933);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGY, 1) == 1)
    {
      AppMethodBeat.o(166933);
      return true;
    }
    AppMethodBeat.o(166933);
    return false;
  }
  
  public static boolean cHK()
  {
    AppMethodBeat.i(166934);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGZ, 1) == 1)
    {
      AppMethodBeat.o(166934);
      return true;
    }
    AppMethodBeat.o(166934);
    return false;
  }
  
  public static boolean cHL()
  {
    AppMethodBeat.i(166935);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderShareDetailCommentListShow", 1) == 1)
    {
      AppMethodBeat.o(166935);
      return true;
    }
    AppMethodBeat.o(166935);
    return false;
  }
  
  public static boolean cHM()
  {
    AppMethodBeat.i(166936);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderShareDetailCommentButtonShow", 1) == 1)
    {
      AppMethodBeat.o(166936);
      return true;
    }
    AppMethodBeat.o(166936);
    return false;
  }
  
  public static boolean cHN()
  {
    AppMethodBeat.i(204170);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderFeedCameraShowPostEducation", 1) == 1)
    {
      AppMethodBeat.o(204170);
      return true;
    }
    AppMethodBeat.o(204170);
    return false;
  }
  
  public static String cHO()
  {
    AppMethodBeat.i(204171);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.Jbm, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204171);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bu.isNullOrNil((String)localObject))
    {
      localObject = ak.getContext().getString(2131759289);
      p.g(localObject, "MMApplicationContext.get…finder_no_post_edu_title)");
      AppMethodBeat.o(204171);
      return localObject;
    }
    AppMethodBeat.o(204171);
    return localObject;
  }
  
  public static String cHP()
  {
    AppMethodBeat.i(204172);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.Jbn, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204172);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (bu.isNullOrNil((String)localObject))
    {
      localObject = ak.getContext().getString(2131759288);
      p.g(localObject, "MMApplicationContext.get….finder_no_post_edu_desc)");
      AppMethodBeat.o(204172);
      return localObject;
    }
    AppMethodBeat.o(204172);
    return localObject;
  }
  
  public static boolean cHQ()
  {
    AppMethodBeat.i(166937);
    boolean bool = ((Boolean)sFv.getValue()).booleanValue();
    AppMethodBeat.o(166937);
    return bool;
  }
  
  public static boolean cHR()
  {
    AppMethodBeat.i(166938);
    boolean bool = ((Boolean)sFw.getValue()).booleanValue();
    AppMethodBeat.o(166938);
    return bool;
  }
  
  private static boolean[] cHS()
  {
    AppMethodBeat.i(166939);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHE, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        ae.i("FinderConfig", "[checkEnableGesturePreviewMedia] JSON=".concat(String.valueOf(localObject1)));
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
          ae.i("FinderConfig", "[checkEnableGesturePreviewMedia] name=" + (String)localObject2 + " model=" + str + " version=" + k + " isEnableImage=" + bool1 + " isEnableVideo=" + bool2 + " | this device=" + (String)localObject3 + " version=" + Build.VERSION.SDK_INT);
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
        ae.i("FinderConfig", "[checkEnableGesturePreviewMedia] isEnableImage=" + bool1 + " isEnableVideo=" + bool2);
        AppMethodBeat.o(166939);
        return new boolean[] { bool1, bool2 };
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("FinderConfig", (Throwable)localException, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(166939);
        return new boolean[] { true, true };
        ae.i("FinderConfig", "[checkEnableGesturePreviewMedia] json is Empty! just pass!");
      }
      label471:
      i += 1;
    }
  }
  
  public static boolean cHT()
  {
    AppMethodBeat.i(204173);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHA, 1) == 1)
    {
      AppMethodBeat.o(204173);
      return true;
    }
    AppMethodBeat.o(204173);
    return false;
  }
  
  public static boolean cHU()
  {
    AppMethodBeat.i(204174);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHB, 1) == 1)
    {
      AppMethodBeat.o(204174);
      return true;
    }
    AppMethodBeat.o(204174);
    return false;
  }
  
  public static o<Integer, Boolean> cHV()
  {
    AppMethodBeat.i(204175);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHv, 3);
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
      AppMethodBeat.o(204175);
      throw ((Throwable)localObject1);
    }
    catch (Throwable localThrowable1)
    {
      bool = false;
    }
    ae.printErrStackTrace("FinderConfig", localThrowable1, "", new Object[0]);
    Object localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
    AppMethodBeat.o(204175);
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
      AppMethodBeat.o(204175);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
    p.g(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    localObject4 = "API#" + Build.VERSION.SDK_INT;
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHx, "");
    if (!bu.isNullOrNil(str))
    {
      p.g(str, "waitForRelease");
      if ((n.f((CharSequence)str, (CharSequence)localObject2)) || (n.f((CharSequence)str, (CharSequence)localObject3)) || (n.f((CharSequence)str, (CharSequence)localObject4))) {
        ae.i("FinderConfig", "[getVideoViewConfig#waitForRelease] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
      }
    }
    for (boolean bool = true;; bool = false) {
      label520:
      for (;;)
      {
        try
        {
          str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHw, "");
          if (bu.isNullOrNil(str)) {
            break label520;
          }
          p.g(str, "videoSingleCount");
          if ((!n.f((CharSequence)str, (CharSequence)localObject2)) && (!n.f((CharSequence)str, (CharSequence)localObject3)) && (!n.f((CharSequence)str, (CharSequence)localObject4))) {
            break label520;
          }
          ae.i("FinderConfig", "[getVideoViewConfig#videoSingleCount] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
          i = 1;
          try
          {
            localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
            AppMethodBeat.o(204175);
            return localObject2;
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
        break;
      }
    }
  }
  
  public static int cHW()
  {
    AppMethodBeat.i(166942);
    int i = ((Number)sFx.getValue()).intValue();
    AppMethodBeat.o(166942);
    return i;
  }
  
  public static boolean cHX()
  {
    AppMethodBeat.i(204176);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOz, 1) == 1) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.DEBUG))
    {
      AppMethodBeat.o(204176);
      return true;
    }
    AppMethodBeat.o(204176);
    return false;
  }
  
  public static boolean cHY()
  {
    AppMethodBeat.i(204177);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOA, 1) == 1)
    {
      AppMethodBeat.o(204177);
      return true;
    }
    AppMethodBeat.o(204177);
    return false;
  }
  
  public static String cHZ()
  {
    AppMethodBeat.i(166943);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHG, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
    AppMethodBeat.o(166943);
    return str;
  }
  
  public static boolean cHa()
  {
    AppMethodBeat.i(204166);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIj, 0) == 1)
    {
      AppMethodBeat.o(204166);
      return true;
    }
    AppMethodBeat.o(204166);
    return false;
  }
  
  public static int cHb()
  {
    AppMethodBeat.i(204167);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHX, sES * 28);
    AppMethodBeat.o(204167);
    return i;
  }
  
  public static int cHc()
  {
    AppMethodBeat.i(204168);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHY, sES * 28);
    AppMethodBeat.o(204168);
    return i;
  }
  
  public static int cHd()
  {
    return sEY;
  }
  
  public static int cHe()
  {
    AppMethodBeat.i(166908);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderFeedCompressResolution");
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
    i = bu.aSB((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166908);
    return i;
  }
  
  public static int cHf()
  {
    AppMethodBeat.i(166909);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166909);
      return 1080;
    }
    ae.d("FinderConfig", "FinderFeedCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166909);
      throw ((Throwable)localObject);
    }
    i = bu.aSB((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166909);
    return i;
  }
  
  public static int cHg()
  {
    AppMethodBeat.i(166910);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderFeedCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166910);
      return 90;
    }
    ae.d("FinderConfig", "FinderFeedCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166910);
      throw ((Throwable)localObject);
    }
    i = bu.aSB(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166910);
    return i;
  }
  
  public static int cHh()
  {
    return sFc;
  }
  
  public static int cHi()
  {
    AppMethodBeat.i(166911);
    int i = sFd;
    AppMethodBeat.o(166911);
    return i;
  }
  
  public static int cHj()
  {
    AppMethodBeat.i(166912);
    int i = sFe;
    AppMethodBeat.o(166912);
    return i;
  }
  
  public static int cHk()
  {
    AppMethodBeat.i(166913);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderHeadCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166913);
      return 90;
    }
    ae.i("FinderConfig", "FinderHeadCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166913);
      throw ((Throwable)localObject);
    }
    i = bu.aSB(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166913);
    return i;
  }
  
  public static int cHl()
  {
    AppMethodBeat.i(166914);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderProfileBgImgCompressResolution");
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
    i = bu.aSB((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166914);
    return i;
  }
  
  public static int cHm()
  {
    AppMethodBeat.i(166915);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166915);
      return 1080;
    }
    ae.i("FinderConfig", "FinderHeadCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166915);
      throw ((Throwable)localObject);
    }
    i = bu.aSB((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166915);
    return i;
  }
  
  public static int cHn()
  {
    AppMethodBeat.i(166916);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderProfileBgImgCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166916);
      return 70;
    }
    ae.i("FinderConfig", "FinderProfileBgImgCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166916);
      throw ((Throwable)localObject);
    }
    i = bu.aSB(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166916);
    return i;
  }
  
  public static int cHo()
  {
    AppMethodBeat.i(204169);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderCoverCompressPicLevel", 50);
    AppMethodBeat.o(204169);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cHp()
  {
    return sFk;
  }
  
  public static int cHq()
  {
    return sFl;
  }
  
  public static int cHr()
  {
    return sFn;
  }
  
  public static int cHs()
  {
    return sFo;
  }
  
  public static int cHt()
  {
    return sFp;
  }
  
  public static boolean cHu()
  {
    return sFr;
  }
  
  public static boolean cHv()
  {
    return sFs;
  }
  
  public static long cHw()
  {
    AppMethodBeat.i(166917);
    if ((sFt > 0L) && (ae.getLogLevel() <= 1))
    {
      l = sFt;
      AppMethodBeat.o(166917);
      return l;
    }
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHm, 86400L);
    AppMethodBeat.o(166917);
    return l * 1000L;
  }
  
  private static float cHx()
  {
    AppMethodBeat.i(166918);
    ae.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + sFu);
    if (sFu < 10L)
    {
      AppMethodBeat.o(166918);
      return 0.5F;
    }
    if (sFu < 20L)
    {
      AppMethodBeat.o(166918);
      return 1.0F;
    }
    AppMethodBeat.o(166918);
    return 2.0F;
  }
  
  public static long cHy()
  {
    AppMethodBeat.i(166919);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHn, 1024L) * sES) * cHx());
    AppMethodBeat.o(166919);
    return l;
  }
  
  public static long cHz()
  {
    AppMethodBeat.i(166920);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHo, 100L) * sES) * cHx());
    AppMethodBeat.o(166920);
    return l;
  }
  
  public static boolean cIB()
  {
    AppMethodBeat.i(204186);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHi, 1) == 1)
    {
      AppMethodBeat.o(204186);
      return true;
    }
    AppMethodBeat.o(204186);
    return false;
  }
  
  public static int cIC()
  {
    return sFK;
  }
  
  public static boolean cID()
  {
    AppMethodBeat.i(204187);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzv, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("FinderConfig", "[GET] isEnableStoreLastTabType=".concat(String.valueOf(bool)));
      AppMethodBeat.o(204187);
      return bool;
    }
  }
  
  public static void cIE()
  {
    AppMethodBeat.i(204188);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.JbR, Integer.valueOf(1));
    sFL = false;
    AppMethodBeat.o(204188);
  }
  
  public static boolean cIF()
  {
    AppMethodBeat.i(204189);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzw, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("FinderConfig", "[GET] isEnablePreloadStreamRefresh=".concat(String.valueOf(bool)));
      AppMethodBeat.o(204189);
      return bool;
    }
  }
  
  public static boolean cIG()
  {
    AppMethodBeat.i(204190);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzx, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("FinderConfig", "[GET] isEnablePreloadVideoForPreloadStream=".concat(String.valueOf(bool)));
      AppMethodBeat.o(204190);
      return bool;
    }
  }
  
  public static d.k.b<Double> cIH()
  {
    return sFM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cII()
  {
    return sFN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIJ()
  {
    return sFO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIK()
  {
    return sFP;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIL()
  {
    return sFQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIM()
  {
    return sFR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIN()
  {
    return sFS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIO()
  {
    return sFT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cIP()
  {
    return sFU;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIQ()
  {
    return sFV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIR()
  {
    return sFW;
  }
  
  public static c cIS()
  {
    return sFX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIT()
  {
    return sFY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIU()
  {
    return sFZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIV()
  {
    return sGa;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIW()
  {
    return sGb;
  }
  
  public static c cIX()
  {
    return sGc;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIY()
  {
    return sGd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIZ()
  {
    return sGe;
  }
  
  public static boolean cIa()
  {
    AppMethodBeat.i(166944);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1)
    {
      AppMethodBeat.o(166944);
      return true;
    }
    AppMethodBeat.o(166944);
    return false;
  }
  
  public static boolean cIb()
  {
    AppMethodBeat.i(166945);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHH, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(bool)));
      AppMethodBeat.o(166945);
      return bool;
    }
  }
  
  public static boolean cIc()
  {
    AppMethodBeat.i(166948);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHJ, 1) == 1)
    {
      AppMethodBeat.o(166948);
      return true;
    }
    AppMethodBeat.o(166948);
    return false;
  }
  
  public static boolean cId()
  {
    AppMethodBeat.i(204178);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderMaxMentionSbCount", 1000) > 0)
    {
      AppMethodBeat.o(204178);
      return true;
    }
    AppMethodBeat.o(204178);
    return false;
  }
  
  public static boolean cIe()
  {
    AppMethodBeat.i(166950);
    if ((sFy == 0) && (ae.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166950);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderPoiJumpTopicSwitch", 0) == 1)
    {
      AppMethodBeat.o(166950);
      return true;
    }
    AppMethodBeat.o(166950);
    return false;
  }
  
  public static boolean cIf()
  {
    AppMethodBeat.i(166952);
    if ((sFz) && (ae.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166952);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHL, 1) == 1)
    {
      AppMethodBeat.o(166952);
      return true;
    }
    AppMethodBeat.o(166952);
    return false;
  }
  
  public static int cIg()
  {
    AppMethodBeat.i(178407);
    if ((sFA != 5) && (ae.getLogLevel() <= 1))
    {
      i = sFA;
      AppMethodBeat.o(178407);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHN, sFA);
    AppMethodBeat.o(178407);
    return i;
  }
  
  public static boolean cIh()
  {
    AppMethodBeat.i(178408);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    boolean bool = locale.ajA().getBoolean(am.a.Jcr, false);
    ae.i("FinderConfig", "[GET] ENABLE_SHOW_OTHER_PROFILE_FANS = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(178408);
    return bool;
  }
  
  public static int cIi()
  {
    AppMethodBeat.i(178412);
    if (((Number)sGf.value()).intValue() == 1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
      p.g(locale, "MMKernel.storage()");
      int i = locale.ajA().getInt(am.a.Jdv, sFB);
      if (i <= 0)
      {
        i = sFB;
        AppMethodBeat.o(178412);
        return i;
      }
      AppMethodBeat.o(178412);
      return i;
    }
    AppMethodBeat.o(178412);
    return 2;
  }
  
  public static int cIj()
  {
    return sFB;
  }
  
  public static boolean cIk()
  {
    AppMethodBeat.i(178413);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderCommentShowBlacklist", 0) == 1)
    {
      AppMethodBeat.o(178413);
      return true;
    }
    AppMethodBeat.o(178413);
    return false;
  }
  
  public static int cIl()
  {
    AppMethodBeat.i(178414);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIe, 0);
    AppMethodBeat.o(178414);
    return i;
  }
  
  public static boolean cIm()
  {
    AppMethodBeat.i(178415);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    if (locale.ajA().a(am.a.JcT, 0L) == 0L)
    {
      AppMethodBeat.o(178415);
      return true;
    }
    AppMethodBeat.o(178415);
    return false;
  }
  
  public static boolean cIn()
  {
    AppMethodBeat.i(178416);
    if ((sFD == 1) && (ae.getLogLevel() <= 1))
    {
      AppMethodBeat.o(178416);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIc, 0) == 1)
    {
      AppMethodBeat.o(178416);
      return true;
    }
    AppMethodBeat.o(178416);
    return false;
  }
  
  public static int cIo()
  {
    AppMethodBeat.i(178417);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qId, 10000000);
    AppMethodBeat.o(178417);
    return i;
  }
  
  public static int cIp()
  {
    AppMethodBeat.i(178418);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("FinderCommentNickNameMaxLength", 6);
    AppMethodBeat.o(178418);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cIq()
  {
    return sFE;
  }
  
  public static boolean cIr()
  {
    return sFF;
  }
  
  public static long cIs()
  {
    return sFG;
  }
  
  public static boolean cIt()
  {
    AppMethodBeat.i(204180);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHb, 1) == 1)
    {
      AppMethodBeat.o(204180);
      return true;
    }
    AppMethodBeat.o(204180);
    return false;
  }
  
  public static boolean cIu()
  {
    return sFH;
  }
  
  public static int cIv()
  {
    return sFI;
  }
  
  public static int cIw()
  {
    return sFJ;
  }
  
  public static int cIx()
  {
    AppMethodBeat.i(204181);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderFakeLoadingPageCount", 5);
    AppMethodBeat.o(204181);
    return i;
  }
  
  public static boolean cIy()
  {
    AppMethodBeat.i(204182);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service(IConfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderFakeLoadingPageCount", 5) > 0)
    {
      AppMethodBeat.o(204182);
      return true;
    }
    AppMethodBeat.o(204182);
    return false;
  }
  
  public static boolean cIz()
  {
    AppMethodBeat.i(204183);
    if (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
      p.g(locale, "MMKernel.storage()");
      if (locale.ajA().getBoolean(am.a.JbL, false))
      {
        AppMethodBeat.o(204183);
        return true;
      }
    }
    AppMethodBeat.o(204183);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJA()
  {
    return sGD;
  }
  
  public static c cJB()
  {
    return sGE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cJC()
  {
    return sGF;
  }
  
  public static c cJD()
  {
    return sGG;
  }
  
  public static c cJE()
  {
    return sGH;
  }
  
  public static c cJF()
  {
    return sGI;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJG()
  {
    return sGJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> cJH()
  {
    return sGK;
  }
  
  public static c cJI()
  {
    return sGM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJJ()
  {
    return sGN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJK()
  {
    return sGO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJL()
  {
    return sGP;
  }
  
  public static List<o<Integer, String>> cJM()
  {
    return sGQ;
  }
  
  public static boolean cJN()
  {
    AppMethodBeat.i(204195);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderStatsReportControl", 1) == 1)
    {
      AppMethodBeat.o(204195);
      return true;
    }
    AppMethodBeat.o(204195);
    return false;
  }
  
  public static boolean cJO()
  {
    AppMethodBeat.i(204196);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).acL().getInt("FinderMarkReadOpenControl", 1) == 1)
    {
      AppMethodBeat.o(204196);
      return true;
    }
    AppMethodBeat.o(204196);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJP()
  {
    return sGT;
  }
  
  public static int cJQ()
  {
    AppMethodBeat.i(204197);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHZ, 0);
    AppMethodBeat.o(204197);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJR()
  {
    return sGU;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJS()
  {
    return sGV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJT()
  {
    return sGW;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJU()
  {
    return sGX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cJV()
  {
    return sGY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJW()
  {
    return sGZ;
  }
  
  public static int cJX()
  {
    AppMethodBeat.i(204198);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JcP, 3);
    AppMethodBeat.o(204198);
    return i;
  }
  
  public static int cJY()
  {
    AppMethodBeat.i(204200);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JcQ, 3);
    AppMethodBeat.o(204200);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJZ()
  {
    return sHb;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJa()
  {
    return sGf;
  }
  
  public static c cJb()
  {
    return sGg;
  }
  
  public static int cJc()
  {
    AppMethodBeat.i(204191);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JcO, 4);
    AppMethodBeat.o(204191);
    return i;
  }
  
  public static int cJd()
  {
    AppMethodBeat.i(204193);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JcR, 0);
    AppMethodBeat.o(204193);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJe()
  {
    return sGh;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cJf()
  {
    return sGi;
  }
  
  public static c cJg()
  {
    return sGj;
  }
  
  public static c cJh()
  {
    return sGk;
  }
  
  public static c cJi()
  {
    return sGl;
  }
  
  public static c cJj()
  {
    return sGm;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJk()
  {
    return sGn;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJl()
  {
    return sGo;
  }
  
  public static c cJm()
  {
    return sGp;
  }
  
  public static c cJn()
  {
    return sGq;
  }
  
  public static c cJo()
  {
    return sGr;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJp()
  {
    return sGs;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJq()
  {
    return sGt;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJr()
  {
    return sGu;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJs()
  {
    return sGv;
  }
  
  public static c cJt()
  {
    return sGw;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cJu()
  {
    return sGx;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cJv()
  {
    return sGy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a cJw()
  {
    return sGz;
  }
  
  public static c cJx()
  {
    return sGA;
  }
  
  public static c cJy()
  {
    return sGB;
  }
  
  public static c cJz()
  {
    return sGC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKA()
  {
    return sHB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKB()
  {
    return sHC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKC()
  {
    return sHD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKD()
  {
    return sHE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKE()
  {
    return sHF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKF()
  {
    return sHG;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKG()
  {
    return sHH;
  }
  
  public static String cKH()
  {
    AppMethodBeat.i(204203);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).acL().getValue("FinderShowOriginalCertificationUrl");
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(204203);
      return "https://support.weixin.qq.com/cgi-bin/mmfindersupport-bin/newreadtemplate?t=page/outer_page/original_plan&wechat_real_lang=zh_CN";
    }
    p.g(localObject, "url");
    AppMethodBeat.o(204203);
    return localObject;
  }
  
  public static c cKI()
  {
    return sHI;
  }
  
  public static int cKJ()
  {
    AppMethodBeat.i(204204);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    int i = locale.ajA().getInt(am.a.JbD, 1);
    AppMethodBeat.o(204204);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKK()
  {
    return sHJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKL()
  {
    return sHK;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKM()
  {
    return sHL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKN()
  {
    return sHM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKO()
  {
    return sHN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKP()
  {
    return sHO;
  }
  
  public static c cKa()
  {
    return sHc;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKb()
  {
    return sHd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKc()
  {
    return sHe;
  }
  
  public static boolean cKd()
  {
    AppMethodBeat.i(204202);
    if (((Number)sHe.value()).intValue() == 1)
    {
      AppMethodBeat.o(204202);
      return true;
    }
    AppMethodBeat.o(204202);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKe()
  {
    return sHf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKf()
  {
    return sHg;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKg()
  {
    return sHh;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKh()
  {
    return sHi;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKi()
  {
    return sHj;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKj()
  {
    return sHk;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKk()
  {
    return sHl;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKl()
  {
    return sHm;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKm()
  {
    return sHn;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKn()
  {
    return sHo;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKo()
  {
    return sHp;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKp()
  {
    return sHq;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKq()
  {
    return sHr;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKr()
  {
    return sHs;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKs()
  {
    return sHt;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKt()
  {
    return sHu;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKu()
  {
    return sHv;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKv()
  {
    return sHw;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKw()
  {
    return sHx;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKx()
  {
    return sHy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKy()
  {
    return sHz;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> cKz()
  {
    return sHA;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    public static final f sHV;
    
    static
    {
      AppMethodBeat.i(204125);
      sHV = new f();
      AppMethodBeat.o(204125);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    public static final h sHX;
    
    static
    {
      AppMethodBeat.i(204129);
      sHX = new h();
      AppMethodBeat.o(204129);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.a<z>
  {
    public static final j sHZ;
    
    static
    {
      AppMethodBeat.i(204133);
      sHZ = new j();
      AppMethodBeat.o(204133);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<z>
  {
    public static final m sIc;
    
    static
    {
      AppMethodBeat.i(204139);
      sIc = new m();
      AppMethodBeat.o(204139);
    }
    
    m()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<z>
  {
    public static final p sIf;
    
    static
    {
      AppMethodBeat.i(204145);
      sIf = new p();
      AppMethodBeat.o(204145);
    }
    
    p()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.b
 * JD-Core Version:    0.7.0.1
 */