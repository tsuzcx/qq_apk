package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.x.a.a.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderConfig;", "", "()V", "ADJUST_AVATAR_ORDER_LIKE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getADJUST_AVATAR_ORDER_LIKE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "AT_END_CHAR", "", "", "getAT_END_CHAR", "()Ljava/util/List;", "AT_SWITCH", "", "getAT_SWITCH", "()Z", "AUTO_FEEDBACK", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "getAUTO_FEEDBACK", "()Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "AVATAR_COMPRESS_QUALITY", "getAVATAR_COMPRESS_QUALITY", "()I", "setAVATAR_COMPRESS_QUALITY", "(I)V", "AVATAR_MAX_HEIGHT", "getAVATAR_MAX_HEIGHT", "setAVATAR_MAX_HEIGHT", "AVATAR_MAX_THUMB_WIDTH", "AVATAR_MAX_WIDTH", "getAVATAR_MAX_WIDTH", "setAVATAR_MAX_WIDTH", "AVATAR_UPLOAD_MAX_SIZE", "getAVATAR_UPLOAD_MAX_SIZE", "AVATAR_URL_FORMAT_JSON", "getAVATAR_URL_FORMAT_JSON", "()Ljava/lang/String;", "BG_MERGE", "getBG_MERGE", "Big_File_LENGTH", "getBig_File_LENGTH", "setBig_File_LENGTH", "CAN_BAN_FINDER_COMMENT", "getCAN_BAN_FINDER_COMMENT", "CAN_SHOW_CHANGE_DISTRICT", "getCAN_SHOW_CHANGE_DISTRICT", "setCAN_SHOW_CHANGE_DISTRICT", "(Z)V", "CAN_SWITCH_SCENE", "getCAN_SWITCH_SCENE", "CDN_UPLOAD_CONTROL", "getCDN_UPLOAD_CONTROL", "CLEAR_KEY_BUF", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getCLEAR_KEY_BUF", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "setCLEAR_KEY_BUF", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;)V", "CLEAR_KEY_BUF_DATA", "getCLEAR_KEY_BUF_DATA", "setCLEAR_KEY_BUF_DATA", "CLEAR_MUTITAB_NEW_RED_DOT", "getCLEAR_MUTITAB_NEW_RED_DOT", "CLEAR_SIMILAR_TIPS", "getCLEAR_SIMILAR_TIPS", "COMMENT_EXPAND", "getCOMMENT_EXPAND", "COMMENT_FRIEND_CAN_CLICK", "getCOMMENT_FRIEND_CAN_CLICK", "COMMENT_FULL_SCREEN", "getCOMMENT_FULL_SCREEN", "COMMENT_PRELOAD_ENABLE", "getCOMMENT_PRELOAD_ENABLE", "COMMENT_PRELOAD_REMAIN_COUNT", "getCOMMENT_PRELOAD_REMAIN_COUNT", "COMMENT_TEXT_LIMIT", "getCOMMENT_TEXT_LIMIT", "COVER_COMPRESS_QUALITY", "getCOVER_COMPRESS_QUALITY", "setCOVER_COMPRESS_QUALITY", "COVER_MAX_HEIGHT", "getCOVER_MAX_HEIGHT", "setCOVER_MAX_HEIGHT", "COVER_MAX_WIDTH", "getCOVER_MAX_WIDTH", "setCOVER_MAX_WIDTH", "CP_TO_CLIPBOARD", "getCP_TO_CLIPBOARD", "Comment_Max_Length", "getComment_Max_Length", "DEBUG_FAV_SIMILAR", "getDEBUG_FAV_SIMILAR", "DEBUG_INSERT_RED_DOT_FLAG", "getDEBUG_INSERT_RED_DOT_FLAG", "DEBUG_POST_UPLOAD_BLOCK", "getDEBUG_POST_UPLOAD_BLOCK", "DEBUG_PRIVATE_LIKE_TIPS_COUNT", "getDEBUG_PRIVATE_LIKE_TIPS_COUNT", "setDEBUG_PRIVATE_LIKE_TIPS_COUNT", "DEBUG_SWITCH_SCENE_TIP", "getDEBUG_SWITCH_SCENE_TIP", "setDEBUG_SWITCH_SCENE_TIP", "DEFAULT_CODEC_REUSE_JSON", "DEFAULT_FAKE_VIDEO_CONFIG_JSON", "DEFAULT_GESTURE_PREVIEW_MEDIA_JSON", "DEFAULT_REPLY_SCENE", "getDEFAULT_REPLY_SCENE", "setDEFAULT_REPLY_SCENE", "DELAY_TIME", "getDELAY_TIME", "setDELAY_TIME", "DUMP_FILE_TIME_INTERVAL", "", "getDUMP_FILE_TIME_INTERVAL", "()J", "EDITOR_TRANSITION_MAGIC", "getEDITOR_TRANSITION_MAGIC", "EMPTY_FOOTER_IGNORE_CHECK", "getEMPTY_FOOTER_IGNORE_CHECK", "ENABLE_FINDER_MESSAGE", "getENABLE_FINDER_MESSAGE", "ENABLE_IMAGE_ENHANCEMENT_SETTING", "getENABLE_IMAGE_ENHANCEMENT_SETTING", "ENABLE_MEDIA_CODEC_REUSE", "getENABLE_MEDIA_CODEC_REUSE", "ENABLE_POST_43_RADIO_VIDEO", "getENABLE_POST_43_RADIO_VIDEO", "ENABLE_SHOW_OTHER_PROFILE_FANS", "getENABLE_SHOW_OTHER_PROFILE_FANS", "ENABLE_SOFT_ENCODE_FALLBACK", "getENABLE_SOFT_ENCODE_FALLBACK", "ENABLE_VIDEO_PRELOAD", "getENABLE_VIDEO_PRELOAD", "ENABLE_VIDEO_TEMPLTE", "getENABLE_VIDEO_TEMPLTE", "EXPOSE_COMMENTBTN_SHOW", "getEXPOSE_COMMENTBTN_SHOW", "EXPOSE_COMMENT_SHOW", "getEXPOSE_COMMENT_SHOW", "FAKE_CARD_JUMP_HOT_TAB_DATA", "getFAKE_CARD_JUMP_HOT_TAB_DATA", "FAKE_DATA_IN_SELF_SCENE", "getFAKE_DATA_IN_SELF_SCENE", "FAKE_LOADING_TOAST", "getFAKE_LOADING_TOAST", "FAKE_VIDEO_CONFIG_JSON", "kotlin.jvm.PlatformType", "getFAKE_VIDEO_CONFIG_JSON", "FEED_ALL_FORCE_NEWS", "getFEED_ALL_FORCE_NEWS", "FEED_COMMENT_EDU", "getFEED_COMMENT_EDU", "FINDER_ACTIVITY_SHARE_BUSINESS_TYPE", "getFINDER_ACTIVITY_SHARE_BUSINESS_TYPE", "FINDER_ACTIVITY_TIMER_SELECT_DAY_COUNT", "getFINDER_ACTIVITY_TIMER_SELECT_DAY_COUNT", "FINDER_AUTH_GUARANTOR_FAKE_DATE", "getFINDER_AUTH_GUARANTOR_FAKE_DATE", "FINDER_AUTH_MINI_APP_TYPE", "getFINDER_AUTH_MINI_APP_TYPE", "FINDER_BIND_PHONE_STATUS", "getFINDER_BIND_PHONE_STATUS", "FINDER_BULLET_SUBTITLE_EXPT_SWITCH", "getFINDER_BULLET_SUBTITLE_EXPT_SWITCH", "FINDER_CHECK_REWARD_INSERT_REDDOT", "getFINDER_CHECK_REWARD_INSERT_REDDOT", "FINDER_CLEAR_BULLET_SUBTITLE_EXPT_CONFIGURATION", "getFINDER_CLEAR_BULLET_SUBTITLE_EXPT_CONFIGURATION", "FINDER_CREATE_GUIDE_ENTRY", "getFINDER_CREATE_GUIDE_ENTRY", "FINDER_CREATE_WXNAME_SWITCH", "getFINDER_CREATE_WXNAME_SWITCH", "FINDER_EDIT_ALLOW_FILLING_FULL_SCREEN", "getFINDER_EDIT_ALLOW_FILLING_FULL_SCREEN", "FINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", "getFINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", "FINDER_ENABLE_HORIZONTAL_PREVIEWING", "getFINDER_ENABLE_HORIZONTAL_PREVIEWING", "FINDER_FEED_GROUP_LIKE_GUIDE_CONFIG", "getFINDER_FEED_GROUP_LIKE_GUIDE_CONFIG", "FINDER_FEED_LIVE_DECORATE_ENABLE", "getFINDER_FEED_LIVE_DECORATE_ENABLE", "FINDER_FEED_POI_CLICK_TO_POI_PAGE", "getFINDER_FEED_POI_CLICK_TO_POI_PAGE", "FINDER_FILE_CLEAN_DEBUG_MODE", "getFINDER_FILE_CLEAN_DEBUG_MODE", "FINDER_FILTER_FOLLOW_REDDOT_IN_FOLLOW_TAB", "getFINDER_FILTER_FOLLOW_REDDOT_IN_FOLLOW_TAB", "FINDER_FILTER_FRIEND_REDDOT_IN_FRIEND_TAB", "getFINDER_FILTER_FRIEND_REDDOT_IN_FRIEND_TAB", "FINDER_FILTER_HOT_REDDOT_IN_HOT_TAB", "getFINDER_FILTER_HOT_REDDOT_IN_HOT_TAB", "FINDER_FINDER_ENTER_LOAD_SWITCH", "getFINDER_FINDER_ENTER_LOAD_SWITCH", "FINDER_FOLLOW_FULLSCREEN_ENJOY", "getFINDER_FOLLOW_FULLSCREEN_ENJOY", "FINDER_FOLLOW_PAT_ENTRANCE", "getFINDER_FOLLOW_PAT_ENTRANCE", "FINDER_FRIEND_FULLSCREEN_ENJOY", "getFINDER_FRIEND_FULLSCREEN_ENJOY", "FINDER_FRIEND_GUIDE_JUMP_HOT", "getFINDER_FRIEND_GUIDE_JUMP_HOT", "FINDER_FRIEND_GUIDE_JUMP_HOT_NEW", "getFINDER_FRIEND_GUIDE_JUMP_HOT_NEW", "FINDER_FRIEND_LIKE_BIG_AVATAR", "getFINDER_FRIEND_LIKE_BIG_AVATAR", "FINDER_FULLSCREEN_INSIDE_RADIO", "", "getFINDER_FULLSCREEN_INSIDE_RADIO", "FINDER_FULL_FEED_GUIDE_CONFIG", "getFINDER_FULL_FEED_GUIDE_CONFIG", "FINDER_FULL_LEFT_SLIDE_GUIDE_CONFIG", "getFINDER_FULL_LEFT_SLIDE_GUIDE_CONFIG", "FINDER_FULL_LIKE_FEED_GUIDE_CONFIG", "getFINDER_FULL_LIKE_FEED_GUIDE_CONFIG", "FINDER_GALLERY_TEST", "getFINDER_GALLERY_TEST", "FINDER_GLOBAL_FULLSCREEN_ENJOY", "getFINDER_GLOBAL_FULLSCREEN_ENJOY", "FINDER_GO_LIVE_POST_JSAPI", "getFINDER_GO_LIVE_POST_JSAPI", "setFINDER_GO_LIVE_POST_JSAPI", "FINDER_HARDCODE_OVER_SEA", "getFINDER_HARDCODE_OVER_SEA", "FINDER_HOT_ENHANCE_ENABLE", "getFINDER_HOT_ENHANCE_ENABLE", "FINDER_HOT_ENHANCE_ENABLE_TEST", "getFINDER_HOT_ENHANCE_ENABLE_TEST", "FINDER_HOT_FULLSCREEN_ENJOY", "getFINDER_HOT_FULLSCREEN_ENJOY", "FINDER_HOT_SHOW_NO_CACHE_WHEN_LOADING", "getFINDER_HOT_SHOW_NO_CACHE_WHEN_LOADING", "FINDER_HOT_SHOW_NO_CACHE_WHEN_PRELOAD_EXIST", "getFINDER_HOT_SHOW_NO_CACHE_WHEN_PRELOAD_EXIST", "FINDER_IGNORE_HAS_TRANS_OLD_SESSION", "getFINDER_IGNORE_HAS_TRANS_OLD_SESSION", "FINDER_LIVE_DEL_OUTHER_UXINFO_WHEN_ENDER_AS", "getFINDER_LIVE_DEL_OUTHER_UXINFO_WHEN_ENDER_AS", "FINDER_LIVE_NUMBER_RULE_TEST_PAGE", "getFINDER_LIVE_NUMBER_RULE_TEST_PAGE", "setFINDER_LIVE_NUMBER_RULE_TEST_PAGE", "FINDER_LIVE_TASK_HARDCODE_BIG_IMG", "getFINDER_LIVE_TASK_HARDCODE_BIG_IMG", "FINDER_LIVE_TRACKER_DEBUG", "getFINDER_LIVE_TRACKER_DEBUG", "FINDER_MEGA_VIDEO_ADD_TO_HISTORY_OFFSET", "getFINDER_MEGA_VIDEO_ADD_TO_HISTORY_OFFSET", "FINDER_MEGA_VIDEO_DELETE_FROM_HISTORY_OFFSET", "getFINDER_MEGA_VIDEO_DELETE_FROM_HISTORY_OFFSET", "FINDER_MEGA_VIDEO_FLOAT_VIDEO", "getFINDER_MEGA_VIDEO_FLOAT_VIDEO", "FINDER_MSG_CHOOSE_ID_EVERY_TIME", "getFINDER_MSG_CHOOSE_ID_EVERY_TIME", "FINDER_MUTUAL_AD_PRELOAD", "getFINDER_MUTUAL_AD_PRELOAD", "FINDER_NEARBY_FEED_STREAM_PRELOAD", "getFINDER_NEARBY_FEED_STREAM_PRELOAD", "FINDER_NEARBY_FEED_STREAM_PRELOAD_THRESHLOD_COUNT", "getFINDER_NEARBY_FEED_STREAM_PRELOAD_THRESHLOD_COUNT", "FINDER_NEARBY_INVOKE_START_PRELOAD", "getFINDER_NEARBY_INVOKE_START_PRELOAD", "FINDER_NEARBY_REDDOT_START_PRELOAD", "getFINDER_NEARBY_REDDOT_START_PRELOAD", "FINDER_NEARBY_SQUARE_TABS_PRELOAD", "getFINDER_NEARBY_SQUARE_TABS_PRELOAD", "FINDER_NEARBY_WAITING_PRELOAD_TIMEOUT_MS", "getFINDER_NEARBY_WAITING_PRELOAD_TIMEOUT_MS", "FINDER_NEW_FEED_UI", "getFINDER_NEW_FEED_UI", "FINDER_NOTIFY_RED_DOT", "getFINDER_NOTIFY_RED_DOT", "FINDER_NOTIFY_RED_DOT_VALUE", "Lkotlin/Pair;", "getFINDER_NOTIFY_RED_DOT_VALUE", "setFINDER_NOTIFY_RED_DOT_VALUE", "(Ljava/util/List;)V", "FINDER_OPEN_GESTURE_HOME_UI", "getFINDER_OPEN_GESTURE_HOME_UI", "FINDER_OPEN_PRELOAD_PREVIEW", "getFINDER_OPEN_PRELOAD_PREVIEW", "FINDER_OTHER_FULLSCREEN_ENJOY", "getFINDER_OTHER_FULLSCREEN_ENJOY", "FINDER_OVER_SEA_ASK_SAVE_PHONE", "getFINDER_OVER_SEA_ASK_SAVE_PHONE", "setFINDER_OVER_SEA_ASK_SAVE_PHONE", "FINDER_OVER_SEA_CAN_CREATE_ACCOUNT", "getFINDER_OVER_SEA_CAN_CREATE_ACCOUNT", "setFINDER_OVER_SEA_CAN_CREATE_ACCOUNT", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;)V", "FINDER_OVER_SEA_CONFIRM_GUIDE", "getFINDER_OVER_SEA_CONFIRM_GUIDE", "setFINDER_OVER_SEA_CONFIRM_GUIDE", "FINDER_PAUSE_CHANGE_ENABLE_SWITCH", "getFINDER_PAUSE_CHANGE_ENABLE_SWITCH", "FINDER_POI_REDIRECT_TO_NEW_PAGE", "getFINDER_POI_REDIRECT_TO_NEW_PAGE", "FINDER_POI_SINGLE_FLOW_IS_SYNC", "getFINDER_POI_SINGLE_FLOW_IS_SYNC", "FINDER_POSTER_SERVICE_URL", "getFINDER_POSTER_SERVICE_URL", "FINDER_POSTING_STRATEGY", "getFINDER_POSTING_STRATEGY", "FINDER_POST_CREATE_ACCOUNT_PRECHECK_IGNORE", "getFINDER_POST_CREATE_ACCOUNT_PRECHECK_IGNORE", "FINDER_POST_DISABLE_HALF_SCREEN", "getFINDER_POST_DISABLE_HALF_SCREEN", "FINDER_POST_FAILED_IN_STAGE", "getFINDER_POST_FAILED_IN_STAGE", "FINDER_POST_FORCE_ZIP", "getFINDER_POST_FORCE_ZIP", "FINDER_PREFETCH_FILTER_MIN_FEED_COUNT", "getFINDER_PREFETCH_FILTER_MIN_FEED_COUNT", "FINDER_PRIVATE_MESSAGE_RED_DOT_STYLE", "getFINDER_PRIVATE_MESSAGE_RED_DOT_STYLE", "FINDER_PROFILE_SHOP_TAB_SWITCH", "getFINDER_PROFILE_SHOP_TAB_SWITCH", "FINDER_REAL_NAME_STATUS", "getFINDER_REAL_NAME_STATUS", "FINDER_RECENT_LIKE_SHOW_CLOSE_CONFIG", "getFINDER_RECENT_LIKE_SHOW_CLOSE_CONFIG", "FINDER_RECENT_LIKE_SHOW_CONFIG", "getFINDER_RECENT_LIKE_SHOW_CONFIG", "FINDER_REDPACK_CLOSE_TAG_CLEAR", "getFINDER_REDPACK_CLOSE_TAG_CLEAR", "FINDER_REDPACK_ENTER_TAG_CLEAR", "getFINDER_REDPACK_ENTER_TAG_CLEAR", "FINDER_RED_PACKET_IS_Trial_Version", "getFINDER_RED_PACKET_IS_Trial_Version", "FINDER_RESET_SLIDE_LEFT_COUNT", "getFINDER_RESET_SLIDE_LEFT_COUNT", "setFINDER_RESET_SLIDE_LEFT_COUNT", "FINDER_SCROLL_READY_FORWARD", "getFINDER_SCROLL_READY_FORWARD", "FINDER_SEARCH_HOT", "getFINDER_SEARCH_HOT", "FINDER_SELF_STATE", "getFINDER_SELF_STATE", "FINDER_SETTING_WXPROFILE_SWITCH", "getFINDER_SETTING_WXPROFILE_SWITCH", "FINDER_SET_TEXT_STATUS_TIPS_CONFIG", "getFINDER_SET_TEXT_STATUS_TIPS_CONFIG", "FINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", "getFINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", "FINDER_SHARE_CHATTING_STYLE", "getFINDER_SHARE_CHATTING_STYLE", "FINDER_SHARE_FULLSCREEN_ENJOY", "getFINDER_SHARE_FULLSCREEN_ENJOY", "FINDER_SHARE_JUMP_HOME_DEFAULT_TAB", "getFINDER_SHARE_JUMP_HOME_DEFAULT_TAB", "FINDER_SHARE_MODE", "getFINDER_SHARE_MODE", "FINDER_SHARE_POPUP_ENTRANCE", "getFINDER_SHARE_POPUP_ENTRANCE", "FINDER_SHARE_POPUP_PULL_TIPS_FULL_SCREEN_LAYOUT", "getFINDER_SHARE_POPUP_PULL_TIPS_FULL_SCREEN_LAYOUT", "FINDER_SHARE_POPUP_PULL_TIPS_HALF_SCREEN_LAYOUT", "getFINDER_SHARE_POPUP_PULL_TIPS_HALF_SCREEN_LAYOUT", "FINDER_SHARE_POPUP_PULL_TIPS_LAYOUT", "getFINDER_SHARE_POPUP_PULL_TIPS_LAYOUT", "FINDER_SHOW_FANS_COUNT", "getFINDER_SHOW_FANS_COUNT", "FINDER_SHOW_NOT_WIFI_HINT_DAILY_TIMES_LIMIT", "getFINDER_SHOW_NOT_WIFI_HINT_DAILY_TIMES_LIMIT", "FINDER_SHOW_NOT_WIFI_HINT_WHEN_SWITCH_FOREGROUND", "getFINDER_SHOW_NOT_WIFI_HINT_WHEN_SWITCH_FOREGROUND", "FINDER_SHOW_SELF_FEED_LIKE_TIPS_CONFIG", "getFINDER_SHOW_SELF_FEED_LIKE_TIPS_CONFIG", "FINDER_SNS_CLEAR_BTN", "getFINDER_SNS_CLEAR_BTN", "FINDER_SUPPORT_SHARE_RINGTONE", "getFINDER_SUPPORT_SHARE_RINGTONE", "FINDER_SUPPORT_SHARE_TEXT_STATUS", "getFINDER_SUPPORT_SHARE_TEXT_STATUS", "FINDER_TIMELINE_HOT_WORD_ENABLE", "getFINDER_TIMELINE_HOT_WORD_ENABLE", "FINDER_TIMELINE_REFRESH_EXPIRED", "getFINDER_TIMELINE_REFRESH_EXPIRED", "FINDER_TIMLINE_ENTRY", "getFINDER_TIMLINE_ENTRY", "FINDER_TRANS_OLD_SESSION_CONV", "getFINDER_TRANS_OLD_SESSION_CONV", "setFINDER_TRANS_OLD_SESSION_CONV", "FINDER_VIDEO_TP_PREPARE_ENABLE", "getFINDER_VIDEO_TP_PREPARE_ENABLE", "FINDER_WX_PROFILE_AUTH_FAKE_DATE", "getFINDER_WX_PROFILE_AUTH_FAKE_DATE", "FIRST_HOT_TAB_PRELOAD_RANDOM", "getFIRST_HOT_TAB_PRELOAD_RANDOM", "FIX_REINIT_SELECTOR_ENABLE", "getFIX_REINIT_SELECTOR_ENABLE", "FLUTTER_VERSION", "getFLUTTER_VERSION", "FOLDED_MORE_ITEM_COUNT", "getFOLDED_MORE_ITEM_COUNT", "FOLDER_MAXSIZE_OF_AVATAR", "getFOLDER_MAXSIZE_OF_AVATAR", "FOLDER_MAXSIZE_OF_CAPTURE", "getFOLDER_MAXSIZE_OF_CAPTURE", "FOLDER_MAXSIZE_OF_COVERIMG", "getFOLDER_MAXSIZE_OF_COVERIMG", "FOLDER_MAXSIZE_OF_IMAGE", "getFOLDER_MAXSIZE_OF_IMAGE", "FOLDER_MAXSIZE_OF_POSTTMP", "getFOLDER_MAXSIZE_OF_POSTTMP", "FOLDER_MAXSIZE_OF_TMP", "getFOLDER_MAXSIZE_OF_TMP", "FOLDER_MAXSIZE_OF_VIDEO", "getFOLDER_MAXSIZE_OF_VIDEO", "FOLDER_SIZE_LEVEL", "getFOLDER_SIZE_LEVEL", "()F", "FRIEND_COMMENT_SHOW_HEADER", "getFRIEND_COMMENT_SHOW_HEADER", "Finder_Game_License_Hardcode", "getFinder_Game_License_Hardcode", "Finder_Game_Select_Hardcode", "getFinder_Game_Select_Hardcode", "GAME_CENTER_JSAPI_DEBUG", "getGAME_CENTER_JSAPI_DEBUG", "GAME_CENTER_JSAPI_DEBUG_CONFIG", "getGAME_CENTER_JSAPI_DEBUG_CONFIG", "GRID_LAYOUT", "getGRID_LAYOUT", "HEVC_ENCODE_OPTION", "getHEVC_ENCODE_OPTION", "HIGH_RECORD_BITRATE", "getHIGH_RECORD_BITRATE", "IF_SHOW_ACCOUTN_DETAIL", "getIF_SHOW_ACCOUTN_DETAIL", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "setIMAGE_COMPRESS_QUALITY", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "IS_ADJUST_FEED_WHEN_OPEN_DRAWER", "getIS_ADJUST_FEED_WHEN_OPEN_DRAWER", "IS_ENABLE_SHARE_ALBUM", "getIS_ENABLE_SHARE_ALBUM", "IS_ENABLE_SHARE_ALBUM_PRELOAD", "getIS_ENABLE_SHARE_ALBUM_PRELOAD", "IS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT", "getIS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT", "IS_SHOW_FAV_ANIM_UNLIMITED", "getIS_SHOW_FAV_ANIM_UNLIMITED", "IS_USE_VLOG_MODE", "getIS_USE_VLOG_MODE", "IS_VLOG_BACKGROUND_MUX", "getIS_VLOG_BACKGROUND_MUX", "Image_Max_Size", "getImage_Max_Size", "JSAPI_SWITCH", "getJSAPI_SWITCH", "LBS_CGI_ONLY_STREAM", "getLBS_CGI_ONLY_STREAM", "LBS_TAB_LOCATION_DURATION", "getLBS_TAB_LOCATION_DURATION", "LBS_TAB_WAIT_LOCATION_TIME", "getLBS_TAB_WAIT_LOCATION_TIME", "LIKE_COMMENT_EDU", "getLIKE_COMMENT_EDU", "LOAD_IMAGE_ANIM", "getLOAD_IMAGE_ANIM", "Long_Video_Expect_Max_Size", "getLong_Video_Expect_Max_Size", "Long_Video_Max_Size", "getLong_Video_Max_Size", "MAKE_POST_FAILED", "getMAKE_POST_FAILED", "setMAKE_POST_FAILED", "(Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;)V", "MAKE_POST_MEDIAPROCESS_BLOCKING", "getMAKE_POST_MEDIAPROCESS_BLOCKING", "setMAKE_POST_MEDIAPROCESS_BLOCKING", "MAKE_SEND_COMMENT_FAIL", "getMAKE_SEND_COMMENT_FAIL", "setMAKE_SEND_COMMENT_FAIL", "MARK_READ_FEED_COUNT_THRESHOLD", "getMARK_READ_FEED_COUNT_THRESHOLD", "MARK_READ_OPEN", "getMARK_READ_OPEN", "MAX_AT_COUNT", "getMAX_AT_COUNT", "MAX_COMMENT_NAME_COUNT", "getMAX_COMMENT_NAME_COUNT", "MAX_POST_RETRY_COUNT", "getMAX_POST_RETRY_COUNT", "setMAX_POST_RETRY_COUNT", "MAX_TOPIC_COUNT", "getMAX_TOPIC_COUNT", "MAX_TOPIC_LENGTH", "getMAX_TOPIC_LENGTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_CENTER_ADJUST_SELECT", "getMEDIA_CENTER_ADJUST_SELECT", "MEDIA_PUBLISH_TEXT_LIMIT", "getMEDIA_PUBLISH_TEXT_LIMIT", "MEGA_VIDEO_BTN_ANIM_OFFSET", "getMEGA_VIDEO_BTN_ANIM_OFFSET", "MEGA_VIDEO_BTN_ANIM_OFFSET$delegate", "MEGA_VIDEO_BULLET_TEXT_LIMIT", "getMEGA_VIDEO_BULLET_TEXT_LIMIT", "MEGA_VIDEO_POST_ENTRANCE", "getMEGA_VIDEO_POST_ENTRANCE", "MEGA_VIDEO_PRELOAD_FIRST_SIZE", "getMEGA_VIDEO_PRELOAD_FIRST_SIZE", "MEGA_VIDEO_PRELOAD_SECOND_SIZE", "getMEGA_VIDEO_PRELOAD_SECOND_SIZE", "MEGA_VIDEO_TAB_SWITCH", "getMEGA_VIDEO_TAB_SWITCH", "MEGA_VIDEO_VISIT_ENTRANCE", "getMEGA_VIDEO_VISIT_ENTRANCE", "ME_FINDER_ENTRY_DEBUG", "getME_FINDER_ENTRY_DEBUG", "ME_FINDER_ENTRY_SWITCH", "getME_FINDER_ENTRY_SWITCH", "MMFINDER_MORE_LOG", "getMMFINDER_MORE_LOG", "MP_REPUDUCE_SWITCH", "getMP_REPUDUCE_SWITCH", "ONE_WEEK", "ONLY_SEARCH_CONTACT", "getONLY_SEARCH_CONTACT", "ONLY_SEE_FEED_TYPE", "getONLY_SEE_FEED_TYPE", "OPEN_FOLLOW_LIST_SEARCH_FLAG", "getOPEN_FOLLOW_LIST_SEARCH_FLAG", "OPT_FIND_BEST_VIDEO_ENABLE", "getOPT_FIND_BEST_VIDEO_ENABLE", "ORIGIN_ACCOUNT_ENABLE", "getORIGIN_ACCOUNT_ENABLE", "ORIGIN_ACCOUNT_POST_TIPS", "getORIGIN_ACCOUNT_POST_TIPS", "value", "ORIGIN_ACCOUNT_POST_TIPS_COUNT", "getORIGIN_ACCOUNT_POST_TIPS_COUNT", "setORIGIN_ACCOUNT_POST_TIPS_COUNT", "ORIGIN_H5_URL", "getORIGIN_H5_URL", "POST_EDUCATION_DESC", "getPOST_EDUCATION_DESC", "POST_EDUCATION_TITLE", "getPOST_EDUCATION_TITLE", "POST_ENTRANCE_OUTSIDE_ENABLE", "POST_ENTRANCE_OUTSIDE_ENABLE$annotations", "getPOST_ENTRANCE_OUTSIDE_ENABLE", "POST_PROGRESS_WEIGHT_MEDIA_PROCESS", "getPOST_PROGRESS_WEIGHT_MEDIA_PROCESS", "POST_PROGRESS_WEIGHT_NETSCENE", "getPOST_PROGRESS_WEIGHT_NETSCENE", "POST_PROGRESS_WEIGHT_UPLOAD", "getPOST_PROGRESS_WEIGHT_UPLOAD", "POST_VIDEO_COVER_COMPRESS_QUALITY", "getPOST_VIDEO_COVER_COMPRESS_QUALITY", "setPOST_VIDEO_COVER_COMPRESS_QUALITY", "PRELOAD_DURATION", "getPRELOAD_DURATION", "PRIVATE_ACCOUNT_ENABLE", "getPRIVATE_ACCOUNT_ENABLE", "PRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "getPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "setPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "PROFILE_SHOW_FANS_COUNT", "getPROFILE_SHOW_FANS_COUNT", "PURE_TEXT_LIMIT", "getPURE_TEXT_LIMIT", "PhoneRemainSpace", "getPhoneRemainSpace", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "REAL_NAME_LIKE_AVATAR_RADIUS", "getREAL_NAME_LIKE_AVATAR_RADIUS", "RECYCLERVIEW_SPEED", "getRECYCLERVIEW_SPEED", "REDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "getREDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "RED_DOT_NO_TIME_LIMIT", "getRED_DOT_NO_TIME_LIMIT", "REFUSE_ALL_PRIVATE_MSG_SWITCH", "getREFUSE_ALL_PRIVATE_MSG_SWITCH", "REMUX_WITH_ABAPARAMS", "getREMUX_WITH_ABAPARAMS", "REPLY_SCENE", "getREPLY_SCENE", "setREPLY_SCENE", "REPORT_QUALITY_INFO", "getREPORT_QUALITY_INFO", "REPORT_QUALITY_INFO_CONFIG", "getREPORT_QUALITY_INFO_CONFIG", "REPORT_WHEN_SCREEN_SHOT", "getREPORT_WHEN_SCREEN_SHOT", "RESET_FIRST_POST_QUALIFICASTION", "getRESET_FIRST_POST_QUALIFICASTION", "RESET_PRIVATE_LIKE_TIPS_COUNT", "getRESET_PRIVATE_LIKE_TIPS_COUNT", "RESET_QUIT_TL_TIME_TO_ZERO", "getRESET_QUIT_TL_TIME_TO_ZERO", "SAME_STYLE_SVR_DEBUG", "getSAME_STYLE_SVR_DEBUG", "SAME_STYLE_SWITCH", "getSAME_STYLE_SWITCH", "SELECT_DISTRICT", "getSELECT_DISTRICT", "setSELECT_DISTRICT", "SELF_LIKE_EDU", "getSELF_LIKE_EDU", "SELF_PRIVATE_LIKE", "getSELF_PRIVATE_LIKE", "setSELF_PRIVATE_LIKE", "SELF_PRIVATE_LIKE_TIPS_COUNT", "getSELF_PRIVATE_LIKE_TIPS_COUNT", "setSELF_PRIVATE_LIKE_TIPS_COUNT", "SETTING_TO_ME_FINDER_ENTRY_SWITCH", "getSETTING_TO_ME_FINDER_ENTRY_SWITCH", "SHARE_FEED_ENTRANCE", "getSHARE_FEED_ENTRANCE", "SHARE_POST_DEBUG", "getSHARE_POST_DEBUG", "SHARE_SDK_TEST3", "getSHARE_SDK_TEST3", "SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS", "getSHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS", "SHOW_IMAGE_ENHANCEMENT_SCENE", "getSHOW_IMAGE_ENHANCEMENT_SCENE", "SHOW_POST_EDUCATION", "getSHOW_POST_EDUCATION", "SHOW_SELF_FEED_LIKE_TIPS_TIMES", "getSHOW_SELF_FEED_LIKE_TIPS_TIMES", "setSHOW_SELF_FEED_LIKE_TIPS_TIMES", "SIGNATURE_AT_END_CHAR", "getSIGNATURE_AT_END_CHAR", "SIZEABARatio", "getSIZEABARatio", "SIZE_KB", "getSIZE_KB", "SIZE_MB", "getSIZE_MB", "SNS_TO_FINDER_SWITCH", "getSNS_TO_FINDER_SWITCH", "STATS_REPORT_CONTROL", "getSTATS_REPORT_CONTROL", "setSTATS_REPORT_CONTROL", "STREAM_CARD_LAYOUT", "getSTREAM_CARD_LAYOUT", "STREAM_CDN_CONNECTION_COUNT", "getSTREAM_CDN_CONNECTION_COUNT", "setSTREAM_CDN_CONNECTION_COUNT", "SWITCH_FEED_TITLE_STYLE", "getSWITCH_FEED_TITLE_STYLE", "SWITCH_SCENE_TIP", "getSWITCH_SCENE_TIP", "setSWITCH_SCENE_TIP", "SWITC_VIEW_PAGE_TIME", "getSWITC_VIEW_PAGE_TIME", "SYNC_TIME_INTERVAL", "getSYNC_TIME_INTERVAL", "setSYNC_TIME_INTERVAL", "TAG", "THREE_DAY", "THREE_DAY_THRESHOLD", "getTHREE_DAY_THRESHOLD", "THREE_DAY_TWO_DAY_ENABLE", "getTHREE_DAY_TWO_DAY_ENABLE", "TIMELINE_CRASH", "getTIMELINE_CRASH", "setTIMELINE_CRASH", "TIMELINE_ENABLE_SUB_PAGE", "getTIMELINE_ENABLE_SUB_PAGE", "TIMELINE_LIKE_EVENT", "getTIMELINE_LIKE_EVENT", "TIMELINE_LOADING_EXPIRED_TIME", "getTIMELINE_LOADING_EXPIRED_TIME", "TIMELINE_REFRESH_EXPIRED_TIME", "getTIMELINE_REFRESH_EXPIRED_TIME", "TIMELINE_SNAP", "getTIMELINE_SNAP", "TIMELINE_SNAP_GLOBAL", "getTIMELINE_SNAP_GLOBAL", "TIMELINE_SNAP_THRESHOLD", "getTIMELINE_SNAP_THRESHOLD", "TIMELINE_SUB_PAGE_COUNT", "getTIMELINE_SUB_PAGE_COUNT", "TOPIC_END_CHAR", "getTOPIC_END_CHAR", "TOPIC_JUMP_POI_SWITCH", "getTOPIC_JUMP_POI_SWITCH", "TOPIC_SUGGEST_SWITCH", "getTOPIC_SUGGEST_SWITCH", "TOPIC_SWITCH", "getTOPIC_SWITCH", "TRAN_TO_TRAN_265_IF_CAN", "getTRAN_TO_TRAN_265_IF_CAN", "TWO_DAY", "TWO_DAY_THRESHOLD", "getTWO_DAY_THRESHOLD", "Thumb_Max_Size", "getThumb_Max_Size", "USE_DAEMON_RECORD", "getUSE_DAEMON_RECORD", "VIDEO_3_4_RATIO", "getVIDEO_3_4_RATIO", "VIDEO_THUMB_MAX_SIZE", "getVIDEO_THUMB_MAX_SIZE", "VideoQualityDefault", "getVideoQualityDefault", "Video_Max_Size", "getVideo_Max_Size", "setVideo_Max_Size", "(J)V", "Video_Remux_Max_Count", "getVideo_Remux_Max_Count", "WITHOUT_SPEC_DEFAULT_BIT_RATE", "getWITHOUT_SPEC_DEFAULT_BIT_RATE", "WXPROFILE_ENTRY_SETTING_EDU", "getWXPROFILE_ENTRY_SETTING_EDU", "WX_CONTACT_UPDATE_INTERVAL", "getWX_CONTACT_UPDATE_INTERVAL", "WX_PROFILE_SHOW_FINDER_AUTH", "getWX_PROFILE_SHOW_FINDER_AUTH", "WxaAdCountDownTime", "getWxaAdCountDownTime", "WxaDemo", "getWxaDemo", "debugDumpFileTimeInterval", "getDebugDumpFileTimeInterval", "setDebugDumpFileTimeInterval", "debugLongVideoMaxSize", "getDebugLongVideoMaxSize", "setDebugLongVideoMaxSize", "debugPreloadComment", "getDebugPreloadComment", "setDebugPreloadComment", "debugPreloadCommentRemainCount", "getDebugPreloadCommentRemainCount", "setDebugPreloadCommentRemainCount", "debugTextLimit", "getDebugTextLimit", "setDebugTextLimit", "debugTopicJumpPoi", "getDebugTopicJumpPoi", "setDebugTopicJumpPoi", "follow_no_reddot_prefetch_inner_interval", "getFollow_no_reddot_prefetch_inner_interval", "follow_no_reddot_prefetch_outter_interval", "getFollow_no_reddot_prefetch_outter_interval", "follow_reddot_prefetch_inner_interval", "getFollow_reddot_prefetch_inner_interval", "follow_reddot_prefetch_outter_interval", "getFollow_reddot_prefetch_outter_interval", "friend_no_reddot_prefetch_inner_interval", "getFriend_no_reddot_prefetch_inner_interval", "friend_no_reddot_prefetch_outter_interval", "getFriend_no_reddot_prefetch_outter_interval", "friend_reddot_prefetch_inner_interval", "getFriend_reddot_prefetch_inner_interval", "friend_reddot_prefetch_outter_interval", "getFriend_reddot_prefetch_outter_interval", "hot_no_reddot_prefetch_inner_interval", "getHot_no_reddot_prefetch_inner_interval", "hot_no_reddot_prefetch_outter_interval", "getHot_no_reddot_prefetch_outter_interval", "hot_reddot_prefetch_inner_interval", "getHot_reddot_prefetch_inner_interval", "hot_reddot_prefetch_outter_interval", "getHot_reddot_prefetch_outter_interval", "isEnableCodecReuse", "isEnableCodecReuse$delegate", "isEnableGesturePreviewImage", "isEnableGesturePreviewImage$delegate", "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo$delegate", "isEnableGestureSeekBar", "isEnablePreloadStreamRefresh", "isEnablePreloadVideoForPreloadStream", "isEnableShowNew", "isEnableStoreLastTabType", "isGetGps", "isMoreTabEnable", "isNeverEnterMultiTab", "setNeverEnterMultiTab", "isOpenMultiBitRateDownload", "isPreloadImageEnable", "isPreloadVideoEnable", "isTestStreamFetch", "localEnableShowNew", "getLocalEnableShowNew", "setLocalEnableShowNew", "mp4ParserMode", "getMp4ParserMode", "msg", "getMsg", "nearby_no_reddot_prefetch_inner_interval", "getNearby_no_reddot_prefetch_inner_interval", "nearby_no_reddot_prefetch_outter_interval", "getNearby_no_reddot_prefetch_outter_interval", "nearby_reddot_prefetch_inner_interval", "getNearby_reddot_prefetch_inner_interval", "nearby_reddot_prefetch_outter_interval", "getNearby_reddot_prefetch_outter_interval", "tab_inner_hot_prefetch_switch", "getTab_inner_hot_prefetch_switch", "tab_preload_new_mode", "getTab_preload_new_mode", "timelineShowTipsDuration", "getTimelineShowTipsDuration", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "videoAlbumMaxSelectDuration", "getVideoAlbumMaxSelectDuration", "videoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoRatioRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getVideoRatioRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "videoRecordPara", "getVideoRecordPara", "checkEnableCodecReuse", "checkEnableGesturePreviewMedia", "", "getTabName", "tabType", "defaultStr", "getVideoViewConfig", "isFinderEnterLoadEnable", "isSupportProfileShopTab", "plugin-finder-base_release"})
public final class d
{
  private static final int AdX = 1024;
  private static final int AdY = 1048576;
  private static final float AdZ = 0.38F;
  private static final int AeA = 3;
  private static final int AeB = 800;
  private static int AeC = 0;
  private static final int AeD = 45;
  private static final int AeE = 45;
  private static final int AeF = 10;
  private static boolean AeG = false;
  private static boolean AeH = false;
  private static long AeI = 0L;
  private static final long AeJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AeK;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AeL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> AeM;
  private static final kotlin.f AeN;
  private static final kotlin.f AeO;
  private static final kotlin.f AeP;
  public static final kotlin.f AeQ;
  private static final kotlin.f AeR;
  private static int AeS = 0;
  private static boolean AeT = false;
  private static int AeU = 0;
  private static int AeV = 0;
  private static boolean AeW = false;
  private static int AeX = 0;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AeY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AeZ;
  private static int Aea = 0;
  private static final int Aeb = 40;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aec;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aed;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Aee;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Aef;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aeg;
  private static final int Aeh = 10485760;
  private static final int Aei = 1048576;
  private static long Aej = 0L;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> Aek;
  private static int Ael = 0;
  private static final int Aem = 300;
  private static int Aen = 0;
  private static int Aeo = 0;
  private static int Aep = 0;
  private static final int Aeq = 143360;
  private static int Aer = 0;
  private static int Aes = 0;
  private static int Aet = 0;
  private static int Aeu = 0;
  private static int Aev = 0;
  private static int Aew = 0;
  private static int Aex = 0;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aey;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aez;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AfB;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfC;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfF;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfG;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfH;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfI;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfK;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfM;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AfN;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfO;
  private static com.tencent.mm.plugin.findersdk.d.a.b.a.a AfP;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AfQ;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AfR;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AfS;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfT;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfU;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfV;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AfZ;
  private static final long Afa = 2000L;
  private static final boolean Afb = false;
  private static final int Afc = 300000;
  private static final int Afd = 5000;
  private static final int Afe;
  private static boolean Aff;
  private static final kotlin.k.b<Double> Afg;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afh;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afi;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afj;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afk;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afl;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afm;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afn;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Afo;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afp;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Afq;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afr;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afs;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aft;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afu;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Afv;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afw;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afx;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afy;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Afz;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AgB;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgC;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgF;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgG;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgH;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgI;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AgJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgK;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgM;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgN;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgO;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgP;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgQ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgR;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgS;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgT;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgU;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgV;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AgZ;
  private static com.tencent.mm.plugin.findersdk.d.a.b.a.a Aga;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Agb;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Agc;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Agd;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Age;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Agf;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Agg;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Agh;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Agi;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agj;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Long> Agk;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Long> Agl;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agm;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agn;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ago;
  private static List<o<Integer, String>> Agp;
  private static boolean Agq;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agr;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ags;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agt;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agu;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agv;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agw;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Agx;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Agy;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Agz;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhB;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhC;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Long> AhE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Long> AhF;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Long> AhG;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhH;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhI;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhK;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhM;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhN;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhO;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhP;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhQ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhR;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhS;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhT;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhU;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhV;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AhZ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aha;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahb;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahc;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahd;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahe;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahf;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Ahg;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahh;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahi;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahj;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Ahk;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahl;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahm;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahn;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aho;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahp;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahq;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahr;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahs;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aht;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahu;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Ahv;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahw;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahx;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahy;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ahz;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AiB;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c AiC;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> AiD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> AiE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> AiF;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiG;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiH;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiI;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiK;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a AiL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiM;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiN;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiO;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a AiP;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiQ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiR;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiS;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AiT;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a AiU;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiV;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiZ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aia;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aib;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aic;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aid;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aie;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aif;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aig;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aih;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aii;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aij;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Float> Aik;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ail;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aim;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ain;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aio;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aip;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aiq;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Air;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Ais;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Ait;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Aiu;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.c Aiv;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aiw;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Aix;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> Aiy;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aiz;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AjA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AjB;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AjC;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AjD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AjE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AjF;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c AjG;
  public static final d AjH;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aja;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajb;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajc;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajd;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aje;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajf;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajg;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Ajh;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Aji;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajj;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajk;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajl;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajm;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajn;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajo;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajp;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajq;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajr;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajs;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajt;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Aju;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajv;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Ajw;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajx;
  private static com.tencent.mm.plugin.findersdk.d.a.a.c Ajy;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Ajz;
  private static final String msg;
  
  static
  {
    AppMethodBeat.i(166903);
    AjH = new d();
    AdX = 1024;
    AdY = 1048576;
    AdZ = 0.38F;
    Aea = 5;
    Aeb = 40;
    Aec = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否支持设置为彩铃").d(b.a.vLu).b("FINDER_SUPPORT_SHARE_RINGTONE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T6");
    Aed = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "通用选择器HardCode").b("FINDER_GALLERY_TEST", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), j.listOf(new String[] { "默认(0)", "列表为空", "刷新失败", "刷新失败重试OK" })).aGU("T6");
    Aee = new com.tencent.mm.plugin.findersdk.d.a.a.c("Contact更新最短间隔改为0", (kotlin.g.a.b)d.aq.Akv).aGU("T6");
    Aef = new com.tencent.mm.plugin.findersdk.d.a.a.c("测试游戏中心h5调直播", (kotlin.g.a.b)d.ah.Akm);
    Aeg = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "测试游戏中心h5调直播调试设置").b("GAME_CENTER_JSAPI_DEBUG_CONFIG", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })), j.listOf(new String[] { "默认(0)", "mock主播没开播", "mock直播已结束" }));
    Aeh = AdY * 10;
    Aei = AdY * 1;
    Aej = 28L * AdY;
    Aek = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(0L, "长视频文件上限").b("debugLongVideoMaxSize", (List)new ArrayList((Collection)j.listOf(new Long[] { Long.valueOf(0L), Long.valueOf(20L * AdY), Long.valueOf(800L * AdY) })), j.listOf(new String[] { "默认(0)", "20MB", "800MB" }));
    Ael = AdY * 28;
    Aem = 300;
    Aen = 1280;
    Aeo = 1080;
    Aep = 90;
    Aeq = AdX * 140;
    Aer = 1080;
    Aes = 1080;
    Aet = 70;
    Aeu = 1080;
    Aev = 1080;
    Aew = 70;
    Aex = 50;
    Aey = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "不再接收私信入口").aGT("FinderPrivateRefuseAllMsgSwitch").b("REFUSE_ALL_PRIVATE_MSG_SWITCH", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认(0)", "打开入口(1)", "关闭入口(0)" }));
    Aez = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "发表模拟失败").b("FINDER_POST_FAILED_IN_STAGE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) })), j.listOf(new String[] { "关闭(0)", "裁剪失败", "上传失败", "cgi失败", "上传时文件不存在", "重编码时文件不存在" }));
    AeA = 3;
    AeB = 800;
    AeC = 300000;
    AeD = 45;
    AeE = 45;
    AeF = 10;
    AeI = -1L;
    AeJ = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
    AeK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号目录新策略").d(b.a.vHz).b("FINDER_POSTING_STRATEGY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "启用" })).aGU("T6");
    AeL = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(15, "小程序广告浏览倒计时").d(b.a.vyh);
    AeM = new com.tencent.mm.plugin.findersdk.d.a.a.c("小程序广告demo", (kotlin.g.a.b)ar.Akw).aGU("T6");
    msg = "\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + dSJ() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + dSG() + " 后台处理\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量）\n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + dSH() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + b.a.vHF + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ";
    AeN = g.ar((kotlin.g.a.a)as.Akx);
    AeO = g.ar((kotlin.g.a.a)at.Aky);
    AeP = g.ar((kotlin.g.a.a)au.Akz);
    AeQ = g.ar((kotlin.g.a.a)d.aj.Ako);
    AeR = g.ar((kotlin.g.a.a)d.ai.Akn);
    AeS = 1;
    AeU = 5;
    AeV = 2;
    AeW = true;
    AeY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(300000, "tab流自动刷新缓存时间").d(b.a.vHM).b("AUTO_REEFRESH_CACHE_INTERVAL", j.listOf(new Integer[] { Integer.valueOf(300000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) }), j.listOf(new String[] { "默认(5min)", "10s", "30s", "1min" }));
    AeZ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10000, "直播和附近预拉取超时时间").d(b.a.vHN).b("NEARBY_WAITING_PRELOAD_TIMEOUT_MS", j.listOf(new Integer[] { Integer.valueOf(5000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) }), j.listOf(new String[] { "默认(10s)", "5s", "10s", "30s", "1min" }));
    Afa = 2000L;
    Afc = 300000;
    Afd = 5000;
    Afe = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVq, 0);
    Aff = true;
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.e.NuX;
    if (com.tencent.mm.plugin.vlog.ui.plugin.e.gvk())
    {
      localObject = i.O(0.75D);
      Afg = (kotlin.k.b)localObject;
      Afh = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "二级评论是否展开").aGT("FinderCommentAutoExpandSubcommentList").b("COMMENT_EXPAND_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "是", "否" }));
      Afi = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "实名点赞").d(b.a.vHS).b("REAL_NAME_LIKE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "实名点赞", "非实名点赞" }));
      Afj = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "实名点赞头像").d(b.a.vHU).b("REAL_NAME_LIKE_AVATAR_RADIUS_CONTROL", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "圆头像", "方头像" }));
      Afk = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "评论全屏方案").d(b.a.vHR).b("COMMENT_STYLE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "全屏", "半屏" }));
      Afl = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "圈外分享模式(仅预览)").d(b.a.vHR).b("USERINFO_FINDER_FORWARD_DEBUG_TYPE_INT", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "允许nickname", "过滤nickname" }));
      Afm = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "附近tab使用瀑布流/卡片流开关").d(b.a.vHQ).b("LBS_UI_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "瀑布流", "卡片流" }));
      Afn = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(20, "关注/点赞折叠超过x条后折叠").b("FOLLOW_LIKE_FOLD_MORE_THAN_X", j.listOf(new Integer[] { Integer.valueOf(20), Integer.valueOf(3) }), j.listOf(new String[] { "20", "3" }));
      Afo = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "开启视频预加载预览View", "USERINFO_FINDER_PRELOAD_VIEW_BOOLEAN_SYNC");
      Afp = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "选游戏页-测试hardcode").b("Finder_Game_Select_Hardcode", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), j.listOf(new String[] { "不hardcode", "游戏对局中无法开启直播", "暂无法开启游戏直播", "游戏未安装" })).aGU("T6");
      Afq = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置游戏直播协议勾选", (kotlin.g.a.b)ag.Akl);
      Afr = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "秒剪做同款").d(b.a.vKH).b("SAME_STYLE_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T6");
      Afs = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "秒剪做同款-mock后台配置").b("SAME_STYLE_SVR_DEBUG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T6");
      Aft = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否开启手势切Tab").d(b.a.vZp).b("FINDER_OPEN_GESTURE_HOME_UI", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭(0)", "打开(1)" })).aGU("T6");
      Afu = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "切换单Tab").d(b.a.vHP).b("FINDER_TAB_STYLE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "切换多tab", "切换单tab" }));
      Afv = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置最后退出TL时间为0", (kotlin.g.a.b)d.an.Aks);
      Afw = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "预加载过滤已读剩下feed数则丢弃").aGT("FinderPrefetchFilterMinFeedCount").b("FINDER_PREFETCH_FILTER_MIN_FEED_COUNT", j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(6) }), j.listOf(new String[] { "3", "6" })).aGU("T6");
      Afx = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(800, "评论字数限制10").aGT("FinderCommentTextLimit").b("COMMENT_TEXT_LIMIT_CONFIG", j.listOf(Integer.valueOf(10)), j.listOf("评论字数限制10"));
      Afy = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1000, "Media字数限制15").aGT("FinderMediaPublishTextLimit").b("MEDIA_TEXT_LIMIT_CONFIG", j.listOf(Integer.valueOf(15)), j.listOf("Media字数限制15"));
      Afz = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(800, "纯文本字数限制15").aGT("FinderPureTextPublishTextLimit").b("PURE_TEXT_LIMIT_CONFIG", j.listOf(Integer.valueOf(20)), j.listOf("纯文本字数限制15"));
      AfA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "最大话题数改为3个").aGT("FinderMaxTopicCount").b("MAX_TOPIC_CONFIG", j.listOf(Integer.valueOf(3)), j.listOf("最大话题数改为3个"));
      AfB = new com.tencent.mm.plugin.findersdk.d.a.a.c("假菊花Toast", (kotlin.g.a.b)d.k.AjR);
      AfC = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "发表跳转第三方app").b("SHARE_SDK_TEST3", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "默认", "秒剪测试" }));
      AfD = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "sdk分享特殊情况").b("SHARE_POST_DEBUG", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4) })), j.listOf(new String[] { "默认", "无视频号浏览权限", "无视频号发表帐号权限", "发现页关闭了视频号", "青少年模式" }));
      AfE = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "我-视频入口控制").b("ME_FINDER_ENTRY_DEBUG", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), j.listOf(new String[] { "默认", "青少年模式", "无视频号发表帐号权限", "命中安全打击/封禁" }));
      AfF = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "A-我-视频入口开关").d(b.a.vJQ).b("ME_FINDER_ENTRY_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AfG = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "B-profile设置展示视频号，是否影响我-视频号").d(b.a.vJR).b("SETTING_TO_ME_FINDER_ENTRY_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "不影响", "影响" }));
      AfH = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "C-设置页出“展示我的视频号”开关").d(b.a.vJS).b("FINDER_SETTING_WXPROFILE_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AfI = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "D-创建帐号-默认使用微信昵称").d(b.a.vJT).b("FINDER_CREATE_WXNAME_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AfJ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(15, "话题最大长度改为10").aGT("FinderTopicTextLimit").b("MAX_TOPIC_LENGTH_CONFIG", j.listOf(Integer.valueOf(10)), j.listOf("话题最大长度改为10"));
      AfK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "话题推荐开关").aGT("FinderSuggestTagViewShow").b("TOPIC_RECOMMEND_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AfL = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "打开切换身份评论").d(b.a.vJO).b("CAN_SWITCH_SCENE", j.listOf(Integer.valueOf(1)), j.listOf("打开"));
      AfM = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "发现页没红点，是否默认跳热门").d(b.a.vJP).b("IS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" })).aGU("T6");
      AfN = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置切换身份提示", (kotlin.g.a.b)d.h.AjP);
      AfO = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1000, "最大at数改为3个").aGT("FinderMaxMentionSbCount").b("MAX_AT_COUNT_CONFIG", j.listOf(Integer.valueOf(3)), j.listOf("最大at数改为3个"));
      AfP = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "发表feed/评论点赞固定失败");
      AfQ = new com.tencent.mm.plugin.findersdk.d.a.a.c("评论点赞重试间隔改为1s", (kotlin.g.a.b)i.AjQ);
      AfR = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除keybuf/账号数据", (kotlin.g.a.b)b.AjJ);
      AfS = new com.tencent.mm.plugin.findersdk.d.a.a.c("清空keybuf", (kotlin.g.a.b)a.AjI);
      AfT = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(80, "RecyclerView滑动速度").b("RECYCLERVIEW_SPEED", j.listOf(new Integer[] { Integer.valueOf(80), Integer.valueOf(50), Integer.valueOf(60), Integer.valueOf(70), Integer.valueOf(80), Integer.valueOf(90), Integer.valueOf(100), Integer.valueOf(130) }), j.listOf(new String[] { "默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍" }));
      AfU = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(300, "loadmore假菊花时长").aGT("FinderFakeLoadingDurationMS").b("TIMELINE_LOADING_EXPIRED_TIME", j.listOf(new Integer[] { Integer.valueOf(100), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(500), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(3000) }), j.listOf(new String[] { "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      AfV = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "红点不受配置时间限制").b("USERINFO_FINDER_TEST_RED_DOT_FACTOR_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(1000000000) }), j.listOf(new String[] { "默认", "无限制" }));
      AfW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "后台合成").b("USERINFO_FINDER_VIDEO_REMUX_BACKGROUND_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "X实验配置", "否", "是" }));
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label17022;
      }
      i = 1;
      label3903:
      AfX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(i, "特效").b("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" }));
      AfY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "允许3:4视频比例").b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "开", "关" }));
      AfZ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "只看某个feed").b("USERINFO_FINDER_CARE_FEED_TYPE_INT", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8) }), j.listOf(new String[] { "DEFAULT", "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA" }));
      Aga = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "进入视频号Crash");
      Agb = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "输出视频号DEBUG日志", "USERINFO_FINDER_DEBUG_LOG_BOOLEAN_SYNC");
      Agc = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "资源清理调试模式");
      Agd = new com.tencent.mm.plugin.findersdk.d.a.a.c("复制finder配置到剪贴板", (kotlin.g.a.b)e.AjM);
      Age = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "个人中心用户状态").b("FINDER_SELF_STATE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(-1) })), (List)new ArrayList((Collection)j.listOf(new String[] { "无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "全网禁言", "reset" })));
      Agf = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置首次获得发表权限标志", (kotlin.g.a.b)d.al.Akq);
      Agg = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(true, "自动触发正例反馈");
      Agh = new com.tencent.mm.plugin.findersdk.d.a.a.c("清理New红点配置", (kotlin.g.a.b)d.c.AjK);
      Agi = new com.tencent.mm.plugin.findersdk.d.a.a.c("清理更多相似动态状态", (kotlin.g.a.b)d.d.AjL);
      Agj = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "打开评论抽屉是否调整feed位置").b("IS_ADJUST_FEED_WHEN_OPEN_DRAWER", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "默认模式(关闭)", "自动调整模式" }));
      Agk = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(100L, "refresh假菊花时长").d(b.a.vyd).b("TIMELINE_REFRESH_EXPIRED_TIME", (List)new ArrayList((Collection)j.listOf(new Long[] { Long.valueOf(500L), Long.valueOf(100L), Long.valueOf(200L), Long.valueOf(400L), Long.valueOf(500L), Long.valueOf(600L), Long.valueOf(700L), Long.valueOf(800L), Long.valueOf(1000L), Long.valueOf(3000L) })), j.listOf(new String[] { "默认(500)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      Agl = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(1200000L, "预加载debug轮询时长").d(b.a.vyc).b("PRELOAD_DURATION", (List)new ArrayList((Collection)j.listOf(new Long[] { Long.valueOf(1200000L), Long.valueOf(5000L), Long.valueOf(10000L), Long.valueOf(60000L) })), j.listOf(new String[] { "默认(20min)", "5s", "10s", "1min" }));
      Agm = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频模板").b("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" }));
      Agn = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "点赞事件UI").b("TIMELINE_LIKE_EVENT_CONFIG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "卡片模式", "m+n模式" }));
      Ago = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "FIDNER_RED_DOT_STYLE").b("FIDNER_RED_DOT_STYLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(-1) }), j.listOf(new String[] { "4(ICON)+liked", "7(SQUARE_ICON)+liked", "11(ICON_WITH_RED_DOT)+liked", "12(SQUARE_ICON_WITH_RED_DOT)+liked", "liked+13(RIGHT_ICON_WITH_RED_DOT)", "liked+14(RIGHT_SQUARE_ICON_WITH_RED_DOT)", "4(ICON)", "7(SQUARE_ICON)", "default" }));
      Agp = j.listOf(new o[] { new o(Integer.valueOf(4), "liked"), new o(Integer.valueOf(7), "liked"), new o(Integer.valueOf(11), "liked"), new o(Integer.valueOf(12), "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new o(Integer.valueOf(13), "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new o(Integer.valueOf(14), "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new o(Integer.valueOf(4), ""), new o(Integer.valueOf(7), ""), new o(Integer.valueOf(-1), "") });
      Agq = true;
      Agr = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "MARK_READ_OPEN").aGT("FinderMarkReadOpenControl").b("FinderMarkReadOpenControl", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认(1)", "打开入口(1)", "关闭入口(0)" }));
      Ags = new d.j("是否打开私信入口").d(b.a.vHX).b("ENABLE_FINDER_MESSAGE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "默认", "打开", "关闭" }));
      Agt = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "截屏上报").d(b.a.vKr).b("FINDER_REPORT_WHEN_SCREEN_SHOT", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      Agu = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否在朋友tab制造个假跳转热门数据").b("FAKE_CARD_JUMP_HOT_TAB_DATA", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      if (!BuildInfo.IS_FLAVOR_PURPLE) {
        break label17027;
      }
    }
    label17027:
    for (int i = 1;; i = 0)
    {
      Agv = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(i, "加载图片渐现").b("LOAD_IMAGE_ANIM", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      Agw = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(800, "切换ViewPage速度").b("SWITC_VIEW_PAGE_TIME", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(1200), Integer.valueOf(1500) })), j.listOf(new String[] { "默认", "200", "400", "600", "700", "800", "1000", "1200", "1500" }));
      Agx = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "是否在作者视角动态展示假数据");
      Agy = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "私密帐号").d(b.a.vLi).b("PRIVATE_ACCOUNT_ENABLE_DEBUG", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      Agz = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置私密feed点赞提示次数", (kotlin.g.a.b)d.g.AjO);
      AgA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "支持匿名赞").d(b.a.vNn).b("USERINFO_SELF_PRIVATE_LIKE_INT_SYNC", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认", "支持", "不支持" }));
      AgB = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置私密feed点赞和匿名赞提示次数", (kotlin.g.a.b)d.am.Akr);
      AgC = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "收藏动画开关").b("IS_SHOW_FAV_ANIM_UNLIMITED", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AgD = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频质量分上报").d(b.a.vLj).b("REPORT_QUALITY_INFO", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      AgE = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "选择 FeedHeadBar 样式").d(b.a.vKs).b("SWITCH_FEED_TITLE_STYLE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) })), j.listOf(new String[] { "默认(0)", "沉浸式(1)", "非沉浸式(0)", "4:3 沉浸式(2)" }));
      AgF = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "发表支持4:3").d(b.a.vXY).b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认", "支持", "不支持" }));
      AgG = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "TL导航栏icon样式").b("POST_ENTRANCE_OUTSIDE_ENABLE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), j.listOf(new String[] { "[A]默认", "[B]发表右上角+热门加附近", "[C]搜索右上角+热门加附近", "[D]热门加附近" }));
      AgH = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "切换朋友圈跳视频号入口类型", (m)d.ao.Akt).b("SNS_TO_FINDER_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "跳转方式1", "跳转方式2" }));
      AgI = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "发表上传block").b("DEBUG_POST_UPLOAD_BLOCK", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(20) })), j.listOf(new String[] { "不block", "block 20秒" }));
      AgJ = new com.tencent.mm.plugin.findersdk.d.a.a.c("红点数据库插入数据标记位", (kotlin.g.a.b)d.f.AjN);
      AgK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "收藏出相似流").b("DEBUG_FAV_SIMILAR", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "使用后台配置", "支持" }));
      AgL = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "follow_r_p_o_interval").b("follow_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgM = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "friend_r_p_o_interval").b("friend_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgN = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "hot_r_p_o_interval").b("hot_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgO = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "nearby_r_p_o_interval").b("nearby_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgP = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "follow_n_r_p_o_interval").b("follow_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgQ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "friend_n_r_p_o_interval").b("friend_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgR = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "hot_n_r_p_o_interval").b("hot_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgS = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "nearby_n_r_p_o_interval").b("nearby_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgT = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "follow_r_p_i_interval").b("follow_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgU = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "friend_r_p_i_interval").b("friend_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgV = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "hot_r_p_i_interval").b("hot_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "nearby_r_p_i_interval").b("nearby_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "follow_n_r_p_i_interval").b("follow_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "friend_n_r_p_i_interval").b("friend_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      AgZ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "hot_n_r_p_i_interval").b("hot_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      Aha = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "nearby_n_r_p_i_interval").b("nearby_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      Ahb = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "tab_inner_hot_prefetch_switch").b("tab_inner_hot_prefetch_switch", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "默认", "true", "false" }));
      Ahc = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "tab_preload_new_mode").b("tab_preload_new_mode", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "新", "旧" }));
      Ahd = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否本地调整点赞头像顺序").d(b.a.vHY).b("ADJUST_AVATAR_ORDER_LIKE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Ahe = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "引导用户点赞自己的视频").d(b.a.vYi).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "支持" }));
      Ahf = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "引导用户点赞后评论").d(b.a.vLI).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "支持" }));
      Ahg = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置profile展示微信资料页提示", (kotlin.g.a.b)d.ap.Aku);
      Ahh = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "专栏布局样式大小").b("STREAM_CARD_LAYOUT", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })), j.listOf(new String[] { "不支持", "大大大 ", " 小小小 " }));
      Ahi = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "feed播放一段时间后，出评论输入框").d(b.a.vLJ).b("FEED_COMMENT_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Ahj = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "原创帐号开关").b("ORIGIN_ACCOUNT_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Ahk = new com.tencent.mm.plugin.findersdk.d.a.a.c("原创帐号发表提示和红点重置", (kotlin.g.a.b)d.ak.Akp);
      Ahl = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "朋友的外显评论是否显示头像").d(b.a.vLK).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Ahm = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "强制所有feed都为新闻类").b("FEED_ALL_FORCE_NEWS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Ahn = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10, "首次打开热门预加载请求随机数").d(b.a.vLL).b("FIRST_HOT_TAB_PRELOAD_RANDOM", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(10) })), j.listOf(new String[] { "重置first", "关闭", "50%", "20%", "10%" })).R((kotlin.g.a.b)d.af.Akk);
      Aho = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "3天2天总开关").d(b.a.vLM).b("THREE_DAY_TWO_DAY_ENABLE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Ahp = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(259200000, "3天超时阈值").d(b.a.vLN).b("THREE_DAY_THRESHOLD", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(259200000), Integer.valueOf(30000), Integer.valueOf(180000) })), j.listOf(new String[] { "3天", "30 秒", "3 分钟" }));
      Ahq = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(172800000, "2天不出阈值").d(b.a.vLO).b("TWO_DAY_THRESHOLD", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(172800000), Integer.valueOf(20000), Integer.valueOf(120000) })), j.listOf(new String[] { "2天", "20 秒", "2 分钟" })).d(b.a.vLI).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "支持" }));
      Ahr = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "展示热门搜索标签").d(b.a.vLP).b("展示热门搜索标签", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "不展示", "展示" }));
      Ahs = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号暂停新样式是否开启").b("FINDER_PAUSE_CHANGE_ENABLE_SWITCH", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      Aht = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "朋友圈直播一键清除").d(b.a.vyf).b("FINDER_SNS_CLEAR_BTN", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      Ahu = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "X实验设置浮评初始默认开关", (m)d.l.AjS).d(b.a.vKi).b("FINDER_BULLET_SUBTITLE_EXPT_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "无", "默认关闭", "默认打开" })).aGU("T32");
      Ahv = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除记录的浮评X实验默认配置", (kotlin.g.a.b)d.m.AjT);
      Ahw = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "音乐跟拍入口").d(b.a.vJa).b("FINDER_FOLLOW_PAT_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      Ahx = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否支持分享专辑").d(b.a.vLQ).b("IS_ENABLE_SHARE_ALBUM", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Ahy = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否支持分享专辑预加载").d(b.a.vLR).b("IS_ENABLE_SHARE_ALBUM_PRELOAD", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      Ahz = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否开启智能滤镜").b("USERINFO_FINDER_ENABLE_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "开", "关" }));
      AhA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "展示智能滤镜场景").b("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "开", "关" }));
      AhB = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "展示智能滤镜人脸关键点").b("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "开", "关" }));
      AhC = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "长视频发表入口").d(b.a.vLS).b("MEGA_VIDEO_POST_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhD = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "开启hevc编码").b("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "关", "vcode", "系统硬编" }));
      AhE = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(0L, "长视频第一阶段预加载size").d(b.a.vLT).b("MEGA_VIDEO_PRELOAD_FIRST_SIZE", j.listOf(new Long[] { Long.valueOf(2097152L), Long.valueOf(2048L) }), j.listOf(new String[] { "2M", "200K" }));
      AhF = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(0L, "长视频第二阶段预加载size").d(b.a.vLU).b("MEGA_VIDEO_PRELOAD_SECOND_SIZE", j.listOf(new Long[] { Long.valueOf(2097152L), Long.valueOf(2048L) }), j.listOf(new String[] { "2M", "200K" }));
      AhG = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(1L, "无spec时，视频码率默认选择").d(b.a.vLV).b("WITHOUT_SPEC_DEFAULT_BIT_RATE", j.listOf(new Long[] { Long.valueOf(0L), Long.valueOf(1L) }), j.listOf(new String[] { "xVO", "xV2/xV1" }));
      AhH = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "长视频浏览入口").d(b.a.vLW).b("MEGA_VIDEO_POST_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhI = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "长视频点赞、收藏和profile tab开关").b("MEGA_VIDEO_TAB_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AhJ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "分享流跳转视频号默认Tab").d(b.a.vMz).b("debugShareJumpHomeDefaultTab", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "关注", "朋友", "推荐" }));
      AhK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "分享流视频播放完后是否弹出下拉引导").d(b.a.vMB).b("debugSharePopupPullTipsLayout", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhL = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "分享流视频完播是否弹出视频号入口").d(b.a.vME).b("debugSharePopupEntrance", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhM = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "半屏分享流视频播放完后是否弹出下拉引导").d(b.a.vMC).b("debugSharePopupPullTipsHalfScreenLayout", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhN = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "全屏分享流视频播放完后是否弹出下拉引导").d(b.a.vMD).b("debugSharePopupPullTipsFullScreenLayout", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhO = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "推荐 TL snap 滑动体验").b("TIMELINE_SNAP", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhP = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "全局 TL snap 滑动体验").d(b.a.vMl).b("TIMELINE_SNAP_GLOBAL", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhQ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(600, "snap 敏感度").b("TIMELINE_SNAP_THRESHOLD", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(300), Integer.valueOf(600), Integer.valueOf(1200), Integer.valueOf(2400), Integer.valueOf(4800), Integer.valueOf(6000) }), j.listOf(new String[] { "1", "300", "600", "1200", "2400", "4800", "6000" }));
      AhR = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "优化找最合适规格播放开关").d(b.a.vMm).b("OPT_FIND_BEST_VIDEO_ENABLE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhS = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "修复reinit selector").d(b.a.vMn).b("FIX_REINIT_SELECTOR_ENABLE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhT = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "尝试转h265").d(b.a.vMo).b("TRT_TO_TRAN_265_IF_CAN", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhU = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否支持解码器复用").d(b.a.vuA).b("ENABLE_MEDIA_CODEC_REUSE", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      AhV = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否打开视频预加载").b("ENABLE_VIDEO_PRELOAD", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" }));
      AhW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否打开帐号详情入口").d(b.a.vMp).b("IF_SHOW_ACCOUTN_DETAIL", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
      AhX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "发表强制触发软编压缩").b("FINDER_POST_FORCE_ZIP", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "默认", "开" }));
      AhY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否允许软编回退").b("USERINFO_FINDER_ENABLE_SOFT_ENCODE_FALLBACK_INT_SYNC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" }));
      AhZ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否支持横屏预览").d(b.a.vYV).b("FINDER_ENABLE_HORIZONTAL_PREVIEWING", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aia = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "开启完播跟赞").d(b.a.vYU).b("FINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aib = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "开启全局全屏体验").d(b.a.vYT).b("FINDER_GLOBAL_FULLSCREEN_ENJOY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aic = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "开启推荐流全屏体验").d(b.a.vYS).b("FINDER_HOT_FULLSCREEN_ENJOY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aid = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "开启关注流全屏体验").d(b.a.vYO).b("FINDER_FOLLOW_FULLSCREEN_ENJOY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aie = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "开启朋友流全屏体验").d(b.a.vYP).b("FINDER_FRIEND_FULLSCREEN_ENJOY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aif = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "开启其他场景全屏体验").d(b.a.vYQ).b("FINDER_OTHER_FULLSCREEN_ENJOY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aig = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "开启分享流全屏体验").d(b.a.vYR).b("FINDER_SHARE_FULLSCREEN_ENJOY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aih = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "编辑页关闭半屏预览").d(b.a.vYW).b("FINDER_POST_DISABLE_HALF_SCREEN", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aii = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "编辑页允许铺满全屏").d(b.a.vYX).b("FINDER_EDIT_ALLOW_FILLING_FULL_SCREEN", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aij = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "分享流完播自动下滚").d(b.a.vYY).b("FINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关", "开" })).aGU("T5");
      Aik = new com.tencent.mm.plugin.findersdk.d.a.b.c("全屏视频撑满比例（高/宽）").d(b.a.vYZ).b("FINDER_FULLSCREEN_INSIDE_RADIO", j.listOf(new Float[] { Float.valueOf(1.773F), Float.valueOf(1.333F), Float.valueOf(2.0F) }), j.listOf(new String[] { "16:9", "4:3", "2:1" })).aGU("T5");
      Ail = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否过滤TAB内的热门红点").b("FINDER_FILTER_HOT_REDDOT_IN_HOT_TAB", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" })).d(b.a.vZb);
      Aim = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否过滤TAB内的朋友红点").b("FINDER_FILTER_FRIEND_REDDOT_IN_FRIEND_TAB", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" })).d(b.a.vZc);
      Ain = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否过滤TAB内的关注红点").b("FINDER_FILTER_FOLLOW_REDDOT_IN_FOLLOW_TAB", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), j.listOf(new String[] { "关闭", "打开" })).d(b.a.vZd);
      Aio = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "创作者服务中心URL").b("FINDER_POSTER_SERVICE_URL", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "使用后台下发url", "TEST", "REAL" })).aGU("T32");
      Aip = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "活动分享使用的业务分享type").b("FINDER_ACTIVITY_SHARE_BUSINESS_TYPE", j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(100000001) }), j.listOf(new String[] { "默认值", "100000001" }));
      Aiq = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "热门搜索推荐").d(b.a.vLk).b("FINDER_SEARCH_HOT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T42");
      Air = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除全屏引导标志", (kotlin.g.a.b)d.o.AjV).aGU("T5");
      Ais = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除发表后引导点赞标志", (kotlin.g.a.b)d.ac.Aki).aGU("T5");
      Ait = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除私密赞标志", (kotlin.g.a.b)d.n.AjU).aGU("T5");
      Aiu = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除全屏点赞引导标志", (kotlin.g.a.b)d.p.AjW).aGU("T5");
      Aiv = new com.tencent.mm.plugin.findersdk.d.a.a.c("清除设置状态引导标志", (kotlin.g.a.b)d.aa.Akg);
      Aiw = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "全屏左滑引导无限次数").b("FINDER_FULL_LEFT_SLIDE_GUIDE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Aix = new com.tencent.mm.plugin.findersdk.d.a.a.c("最近赞过开关-打开", (kotlin.g.a.b)d.w.Akc).aGU("T5");
      Aiy = new com.tencent.mm.plugin.findersdk.d.a.a.c("最近赞过开关-关闭", (kotlin.g.a.b)d.v.Akb).aGU("T5");
      Aiz = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "进入Finder点击时提前加载").d(b.a.vZk).b("FINDER_FINDER_ENTER_LOAD_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "默认", "打开", "关闭" }));
      AiA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号朋友赞列表大头像").d(b.a.vZa).b("FINDER_FRIEND_LIKE_BIG_AVATAR", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AiB = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置红包入口关闭标志", (kotlin.g.a.b)d.x.Akd);
      AiC = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置是否进入过红包小程序标志", (kotlin.g.a.b)d.y.Ake);
      AiD = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(true, "朋友圈poi点击是否跳转新详情页").d(b.a.vZm);
      AiE = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(true, "视频号feed中的poi点击是否跳转poi详情页").d(b.a.vZn);
      AiF = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(true, "poi详情页单流页是同步流").d(b.a.vZo);
      AiG = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否开启视频preparing").d(b.a.vZq).b("FINDER_VIDEO_TP_PREPARE_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T5");
      AiH = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频显示居中策略").b("MEDIA_CENTER_ADJUST_SELECT", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })), j.listOf(new String[] { "现网", "靠顶", "靠底" })).aGU("T6");
      AiI = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "使用 Flutter UI").b("DEBUG_FLUTTER_UI", (List)new ArrayList((Collection)j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), j.listOf(new String[] { "打开", "关闭" }));
      AiJ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10, "长视频添加进历史准入时间偏移").d(b.a.vLX);
      AiK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10, "长视频从历史删除准出时间偏移").d(b.a.vLY);
      AiL = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "是否展示粉丝数", "FINDER_SHOW_FANS_COUNT");
      AiM = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(180, "活动结束时间支持用户选择最近x天").d(b.a.vMi);
      AiN = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号私信红点个人中心展现样式").d(b.a.vMj).b("FINDER_PRIVATE_MESSAGE_RED_DOT_STYLE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "普通红点", "数字红点" }));
      AiO = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否加载互选广告").d(b.a.vMk).b("FINDER_MUTUAL_AD_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "不加载", "加载" }));
      AiP = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "红包封面小程序是否用体验版", "FINDER_RED_PACKET_IS_Trial_Version");
      AiQ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否打开附近双流预加载").d(b.a.vMQ).b("FINDER_NEARBY_FEED_STREAM_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "否", "是" })).aGU("T6");
      AiR = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(7, "附近双流预加载阈值").d(b.a.vMR).b("FINDER_NEARBY_FEED_STREAM_PRELOAD_THRESHLOD_COUNT", j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(9) }), j.listOf(new String[] { "3", "5", "7", "9" })).aGU("T6");
      AiS = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "长视频视频浮窗开关").b("FINDER_MEGA_VIDEO_FLOAT_VIDEO", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vLZ);
      AiT = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置海外提示半屏", (kotlin.g.a.b)u.Aka);
      AiU = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "强制海外用户", "FINDER_HARDCODE_OVER_SEA");
      AiV = new d.s("新版feed视觉（不维护了）").b("FINDER_NEW_FEED_UI", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vJh);
      AiW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-红点触发预加载").b("FINDER_NEARBY_REDDOT_START_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMb);
      AiX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-根据指定条件触发预加载").b("FINDER_NEARBY_INVOKE_START_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMc);
      AiY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-预加载直播广场tab列表").b("FINDER_NEARBY_SQUARE_TABS_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMd);
      AiZ = new d.ad("是否支持分享到状态").d(b.a.vLt).b("FINDER_SUPPORT_SHARE_TEXT_STATUS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("2021T1");
      Aja = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "推荐页滑动就绪提前判定").d(b.a.vLv).b("FINDER_SCROLL_READY_FORWARD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("2021T1");
      Ajb = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(30, "长视频弹幕字数限制").b("MEGA_VIDEO_BULLET_TEXT_LIMIT", j.listOf(new Integer[] { Integer.valueOf(15), Integer.valueOf(30) }), j.listOf(new String[] { "长视频弹幕字数限制15", "长视频弹幕字数限制30" })).d(b.a.vMa);
      Ajc = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "是否允许查询收入并显示红点").d(b.a.vLz).b("FINDER_CHECK_REWARD_INSERT_REDDOT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "不允许", "允许" })).aGU("2021T1");
      Ajd = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "是否每次从profile私信都选择身份", "FINDER_MSG_CHOOSE_ID_EVERY_TIME");
      Aje = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "profile页商店tab开关").aGT("FinderProfileProductWindowSwitch").b("FINDER_PROFILE_SHOP_TAB_SWITCH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Ajf = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "profile认证详情小程序是否打开体验版", "FINDER_AUTH_MINI_APP_TYPE");
      Ajg = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "是否可重复走'老版本session转换逻辑'", "FINDER_IGNORE_HAS_TRANS_OLD_SESSION");
      Ajh = new com.tencent.mm.plugin.findersdk.d.a.a.c("转换老版本的conv和session", (kotlin.g.a.b)ae.Akj);
      Aji = new com.tencent.mm.plugin.findersdk.d.a.a.c("重置海外用户询问保存手机半屏", (kotlin.g.a.b)d.t.AjZ);
      Ajj = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "海外用户可以创建用户").d(b.a.vLB).b("FINDER_OVER_SEA_CAN_CREATE_ACCOUNT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "不允许", "允许" })).aGU("2021T1");
      Ajk = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否绕开创建帐号/发表所有预检查").d(b.a.vLC).b("FINDER_POST_CREATE_ACCOUNT_PRECHECK_IGNORE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "否", "是" })).aGU("2021T2");
      Ajl = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "用户手机绑定状态开关").b("FINDER_BIND_PHONE_STATUS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "真实判断", "hardcode已绑定", "hardcode未绑定" }));
      Ajm = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "用户实名状态开关").b("FINDER_REAL_NAME_STATUS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "真实判断", "hardcode已实名", "hardcode未实名" }));
      Ajn = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "左滑引导推荐tab").d(b.a.vLw).b("FINDER_FRIEND_GUIDE_JUMP_HOT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Ajo = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "朋友tab强引流推荐").d(b.a.vLx).b("FINDER_FRIEND_GUIDE_JUMP_HOT_NEW", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Ajp = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "非wifi流量提示每日次数限制").b("FINDER_SHOW_NOT_WIFI_HINT_TIMES_LIMIT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(2147483647) }), j.listOf(new String[] { "0次(关闭)", "1次", "2次", "3次", "无限制" })).d(b.a.vLD);
      Ajq = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号3tab界面切换网络流量提示开关").d(b.a.vLE);
      Ajr = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "担保认证人用假数据", "FINDER_AUTH_GUARANTOR_FAKE_DATE");
      Ajs = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "微信profile页视频号认证使用假数据", "FINDER_WX_PROFILE_AUTH_FAKE_DATE");
      Ajt = new d.ab("聊天分享气泡样式").d(b.a.vLy).b("FINDER_SHARE_CHATTING_STYLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "新样式", "老样式" }));
      Aju = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播feed展示连麦信息开关").d(b.a.vJx);
      Ajv = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "直播任务开播入口用大图url", "FINDER_LIVE_TASK_HARDCODE_BIG_IMG");
      Ajw = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "直播间进入广告前，删掉uxinfo", "FINDER_LIVE_DEL_OUTHER_UXINFO_WHEN_ENDER_AS");
      Ajx = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "微信profile是否显示视频号认证").aGT("FinderWXProfileAuthInfoSwitch").b("WX_PROFILE_SHOW_FINDER_AUTH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      Ajy = new com.tencent.mm.plugin.findersdk.d.a.a.c("带特定标签跳去开播页", (kotlin.g.a.b)d.q.AjX);
      Ajz = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10, "MarkRead已读上报feed数量阈值").d(b.a.vJy);
      AjA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "LIVE堆栈").b("FINDER_LIVE_TRACKER_DEBUG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "off", "on" }));
      AjB = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "热门loading时不展示本地缓存占位").d(b.a.vMU).b("FINDER_HOT_SHOW_NO_CACHE_WHEN_LOADING", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AjC = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "热门有预拉取的时不展示本地缓存占位").d(b.a.vMV).b("FINDER_HOT_SHOW_NO_CACHE_WHEN_PRELOAD_EXIST", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AjD = new com.tencent.mm.plugin.findersdk.d.a.a.c("左滑推荐次数重置", (kotlin.g.a.b)d.z.Akf);
      AjE = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "本地hardcode强化流是否开启").b("FINDER_HOT_ENHANCE_ENABLE_TEST", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AjF = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "强化流是否开启").d(b.a.vMW).b("FINDER_HOT_ENHANCE_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" }));
      AjG = new com.tencent.mm.plugin.findersdk.d.a.a.c("视频号直播数据规范测试页面", (kotlin.g.a.b)d.r.AjY);
      AppMethodBeat.o(166903);
      return;
      localObject = i.O(0.857142857142857D);
      break;
      label17022:
      i = 0;
      break label3903;
    }
  }
  
  public static void Qa(int paramInt)
  {
    AeC = paramInt;
  }
  
  public static void Qb(int paramInt)
  {
    AppMethodBeat.i(258255);
    Log.i("FinderConfig", "set REPLY_SCENE value:".concat(String.valueOf(paramInt)));
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VBK, Integer.valueOf(paramInt));
    AppMethodBeat.o(258255);
  }
  
  public static void Qc(int paramInt)
  {
    AppMethodBeat.i(258275);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAO, Integer.valueOf(paramInt));
    AppMethodBeat.o(258275);
  }
  
  public static void Qd(int paramInt)
  {
    AppMethodBeat.i(258277);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAU, Integer.valueOf(paramInt));
    AppMethodBeat.o(258277);
  }
  
  public static void Qe(int paramInt)
  {
    AppMethodBeat.i(258286);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAS, Integer.valueOf(paramInt));
    AppMethodBeat.o(258286);
  }
  
  public static void Qf(int paramInt)
  {
    AppMethodBeat.i(258288);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VAT, Integer.valueOf(paramInt));
    AppMethodBeat.o(258288);
  }
  
  public static void Qg(int paramInt)
  {
    AppMethodBeat.i(258298);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzy, Integer.valueOf(paramInt));
    AppMethodBeat.o(258298);
  }
  
  public static String bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(258258);
    p.k(paramString, "defaultStr");
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
      com.tencent.mm.kernel.f localf;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(258258);
        return "";
        paramString = MMApplicationContext.getContext().getString(a.a.finder_tab_friend);
        p.j(paramString, "MMApplicationContext.get…string.finder_tab_friend)");
        continue;
        paramString = MMApplicationContext.getContext().getString(a.a.finder_tab_follow);
        p.j(paramString, "MMApplicationContext.get…string.finder_tab_follow)");
        continue;
        paramString = MMApplicationContext.getContext().getString(a.a.finder_tab_machine);
        p.j(paramString, "MMApplicationContext.get…tring.finder_tab_machine)");
        break;
      case 1: 
        localf = com.tencent.mm.kernel.h.aHG();
        p.j(localf, "MMKernel.storage()");
        paramString = localf.aHp().get(ar.a.VzH, paramString);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(258258);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(258258);
        return paramString;
      case 3: 
        localf = com.tencent.mm.kernel.h.aHG();
        p.j(localf, "MMKernel.storage()");
        paramString = localf.aHp().get(ar.a.VzJ, paramString);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(258258);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(258258);
        return paramString;
      case 4: 
        localf = com.tencent.mm.kernel.h.aHG();
        p.j(localf, "MMKernel.storage()");
        paramString = localf.aHp().get(ar.a.VzI, paramString);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(258258);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(258258);
        return paramString;
      }
    }
  }
  
  public static int dRE()
  {
    return AdY;
  }
  
  public static float dRF()
  {
    return AdZ;
  }
  
  public static int dRG()
  {
    return Aea;
  }
  
  public static void dRH()
  {
    Aea = 1;
  }
  
  public static VideoTransPara dRI()
  {
    AppMethodBeat.i(166904);
    Object localObject = com.tencent.mm.plugin.vlog.model.n.NlN;
    if (com.tencent.mm.plugin.vlog.model.n.gsU())
    {
      localObject = com.tencent.mm.plugin.vlog.model.n.NlN;
      VideoTransPara localVideoTransPara = com.tencent.mm.plugin.vlog.model.n.gsV();
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = com.tencent.mm.modelcontrol.e.bkp();
        p.j(localObject, "SubCoreVideoControl.getCore()");
        localObject = ((com.tencent.mm.modelcontrol.e)localObject).bku();
        p.j(localObject, "SubCoreVideoControl.getC…e().finderRecordVideoPara");
      }
      AppMethodBeat.o(166904);
      return localObject;
    }
    localObject = com.tencent.mm.modelcontrol.e.bkp();
    p.j(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bku();
    p.j(localObject, "SubCoreVideoControl.getC…e().finderRecordVideoPara");
    AppMethodBeat.o(166904);
    return localObject;
  }
  
  public static VideoTransPara dRJ()
  {
    AppMethodBeat.i(166905);
    Object localObject = com.tencent.mm.plugin.vlog.model.n.NlN;
    if (com.tencent.mm.plugin.vlog.model.n.gsU())
    {
      localObject = com.tencent.mm.plugin.vlog.model.n.NlN;
      VideoTransPara localVideoTransPara = com.tencent.mm.plugin.vlog.model.n.gsV();
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = com.tencent.mm.modelcontrol.e.bkp();
        p.j(localObject, "SubCoreVideoControl.getCore()");
        localObject = ((com.tencent.mm.modelcontrol.e)localObject).bkv();
        p.j(localObject, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
      }
      AppMethodBeat.o(166905);
      return localObject;
    }
    localObject = com.tencent.mm.modelcontrol.e.bkp();
    p.j(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bkv();
    p.j(localObject, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
    AppMethodBeat.o(166905);
    return localObject;
  }
  
  public static int dRK()
  {
    AppMethodBeat.i(166906);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHJ, 300);
    AppMethodBeat.o(166906);
    return i;
  }
  
  public static boolean dRL()
  {
    AppMethodBeat.i(166907);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJC, 1) == 1)
    {
      AppMethodBeat.o(166907);
      return true;
    }
    AppMethodBeat.o(166907);
    return false;
  }
  
  public static int dRM()
  {
    return Aeb;
  }
  
  public static boolean dRN()
  {
    AppMethodBeat.i(258220);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKF, 1) == 1)
    {
      AppMethodBeat.o(258220);
      return true;
    }
    AppMethodBeat.o(258220);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dRO()
  {
    return Aec;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dRP()
  {
    return Aed;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dRQ()
  {
    return Aee;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dRR()
  {
    return Aef;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dRS()
  {
    return Aeg;
  }
  
  public static boolean dRT()
  {
    AppMethodBeat.i(258224);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKE, 0) == 1)
    {
      AppMethodBeat.o(258224);
      return true;
    }
    AppMethodBeat.o(258224);
    return false;
  }
  
  public static boolean dRU()
  {
    AppMethodBeat.i(258225);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKG, 0) == 1)
    {
      AppMethodBeat.o(258225);
      return true;
    }
    AppMethodBeat.o(258225);
    return false;
  }
  
  public static long dRV()
  {
    AppMethodBeat.i(258226);
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKj, 28L * AdY);
    AppMethodBeat.o(258226);
    return l;
  }
  
  public static long dRW()
  {
    AppMethodBeat.i(258227);
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKk, 450L * AdY);
    AppMethodBeat.o(258227);
    return l;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> dRX()
  {
    return Aek;
  }
  
  public static long dRY()
  {
    AppMethodBeat.i(258228);
    if ((((Number)Aek.aSr()).longValue() > 0L) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      l1 = ((Number)Aek.aSr()).longValue();
      AppMethodBeat.o(258228);
      return l1;
    }
    long l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKl, 100L * AdY);
    long l2 = dRW();
    AppMethodBeat.o(258228);
    return l1 + l2;
  }
  
  public static int dRZ()
  {
    AppMethodBeat.i(258229);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKp, AdY * 28);
    AppMethodBeat.o(258229);
    return i;
  }
  
  public static long dSA()
  {
    AppMethodBeat.i(166922);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vId, 1024L) * AdY) * dSw());
    AppMethodBeat.o(166922);
    return l;
  }
  
  public static long dSB()
  {
    AppMethodBeat.i(166923);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIe, 500L) * AdY) * dSw());
    AppMethodBeat.o(166923);
    return l;
  }
  
  public static long dSC()
  {
    AppMethodBeat.i(166924);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIf, 500L) * AdY) * dSw());
    AppMethodBeat.o(166924);
    return l;
  }
  
  public static long dSD()
  {
    AppMethodBeat.i(166925);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIg, 100L) * AdY) * dSw());
    AppMethodBeat.o(166925);
    return l;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dSE()
  {
    return AeK;
  }
  
  public static int dSF()
  {
    AppMethodBeat.i(166929);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderTimelineEntry", 0);
    AppMethodBeat.o(166929);
    return i;
  }
  
  public static boolean dSG()
  {
    AppMethodBeat.i(166930);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHD, 1) == 1)
    {
      AppMethodBeat.o(166930);
      return true;
    }
    AppMethodBeat.o(166930);
    return false;
  }
  
  public static boolean dSH()
  {
    AppMethodBeat.i(166932);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHE, 1) == 1)
    {
      AppMethodBeat.o(166932);
      return true;
    }
    AppMethodBeat.o(166932);
    return false;
  }
  
  public static boolean dSI()
  {
    AppMethodBeat.i(166933);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHK, 1) == 1)
    {
      AppMethodBeat.o(166933);
      return true;
    }
    AppMethodBeat.o(166933);
    return false;
  }
  
  public static boolean dSJ()
  {
    AppMethodBeat.i(166934);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHL, 1) == 1)
    {
      AppMethodBeat.o(166934);
      return true;
    }
    AppMethodBeat.o(166934);
    return false;
  }
  
  public static boolean dSK()
  {
    AppMethodBeat.i(166935);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderShareDetailCommentListShow", 1) == 1)
    {
      AppMethodBeat.o(166935);
      return true;
    }
    AppMethodBeat.o(166935);
    return false;
  }
  
  public static boolean dSL()
  {
    AppMethodBeat.i(166936);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderShareDetailCommentButtonShow", 1) == 1)
    {
      AppMethodBeat.o(166936);
      return true;
    }
    AppMethodBeat.o(166936);
    return false;
  }
  
  public static boolean dSM()
  {
    AppMethodBeat.i(258241);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderFeedCameraShowPostEducation", 1) == 1)
    {
      AppMethodBeat.o(258241);
      return true;
    }
    AppMethodBeat.o(258241);
    return false;
  }
  
  public static String dSN()
  {
    AppMethodBeat.i(258243);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.Vyt, "");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(258243);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(258243);
      return "视频号逐步开放中，请耐心等待";
    }
    AppMethodBeat.o(258243);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dSO()
  {
    return AeL;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dSP()
  {
    return AeM;
  }
  
  public static String dSQ()
  {
    AppMethodBeat.i(258245);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.Vyu, "");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(258245);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(258245);
      return "";
    }
    AppMethodBeat.o(258245);
    return localObject;
  }
  
  private static boolean dSR()
  {
    AppMethodBeat.i(258246);
    long l2 = System.currentTimeMillis();
    Object localObject1 = ((Iterable)j.listOf(new b.a[] { b.a.vwz, b.a.vwA, b.a.vwB, b.a.vwC, b.a.vwD, b.a.vwE, b.a.vwF, b.a.vwG, b.a.vwH, b.a.vwI })).iterator();
    boolean bool1 = false;
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (b.a)((Iterator)localObject1).next();
      localObject2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a((b.a)localObject2, "{mode:1,whitelist:[],apilevel:[],company:[],blacklist:[]}");
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        bool3 = bool1;
        if (((JSONObject)localObject2).getInt("mode") == 1)
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("whitelist");
          int j = ((JSONArray)localObject2).length();
          int i = 0;
          bool2 = bool1;
          if (i < j)
          {
            String str = ((JSONArray)localObject2).getString(i);
            Log.d("FinderConfig", "checkEnableCodecReuse modelName:".concat(String.valueOf(str)));
            bool2 = kotlin.n.n.L(Build.MODEL, str, true);
            if (bool2) {
              bool2 = true;
            }
          }
          else
          {
            bool3 = bool2;
            if (!bool2) {
              continue;
            }
            localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
            if (!bool2) {
              break label364;
            }
            l1 = 1L;
            ((com.tencent.mm.plugin.report.service.h)localObject1).p(1505L, 9L, l1);
            Log.i("FinderConfig", "checkEnableCodecReuse enableCodecReuse:" + bool2 + " duration:" + (System.currentTimeMillis() - l2));
            AppMethodBeat.o(258246);
            return bool2;
          }
          i += 1;
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("FinderConfig", localThrowable, "", new Object[0]);
        boolean bool3 = bool1;
        bool1 = bool3;
      }
      label364:
      long l1 = 0L;
      continue;
      boolean bool2 = bool1;
    }
  }
  
  public static boolean dSS()
  {
    AppMethodBeat.i(258248);
    boolean bool = ((Boolean)AeN.getValue()).booleanValue();
    AppMethodBeat.o(258248);
    return bool;
  }
  
  private static boolean[] dST()
  {
    AppMethodBeat.i(166939);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIr, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] JSON=".concat(String.valueOf(localObject1)));
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
          Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] name=" + (String)localObject2 + " model=" + str + " version=" + k + " isEnableImage=" + bool1 + " isEnableVideo=" + bool2 + " | this device=" + (String)localObject3 + " version=" + Build.VERSION.SDK_INT);
          if (k < Build.VERSION.SDK_INT) {
            break label471;
          }
          CharSequence localCharSequence = (CharSequence)localObject3;
          p.j(localObject2, "name");
          if (!kotlin.n.n.a(localCharSequence, (CharSequence)localObject2, true)) {
            break label471;
          }
          localObject2 = (CharSequence)localObject3;
          p.j(str, "model");
          if (!kotlin.n.n.a((CharSequence)localObject2, (CharSequence)str, true)) {
            break label471;
          }
          AppMethodBeat.o(166939);
          return new boolean[] { bool1, bool2 };
        }
        boolean bool1 = ((JSONObject)localObject1).getBoolean("isEnableImage");
        boolean bool2 = ((JSONObject)localObject1).getBoolean("isEnableVideo");
        Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] isEnableImage=" + bool1 + " isEnableVideo=" + bool2);
        AppMethodBeat.o(166939);
        return new boolean[] { bool1, bool2 };
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("FinderConfig", (Throwable)localException, "", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(166939);
        return new boolean[] { true, true };
        Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] json is Empty! just pass!");
      }
      label471:
      i += 1;
    }
  }
  
  public static boolean dSU()
  {
    boolean bool2 = true;
    AppMethodBeat.i(258249);
    boolean bool1;
    if (((Number)AhV.aSr()).intValue() == 1)
    {
      bool1 = true;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIn, 1) != 1) {
        break label73;
      }
    }
    for (;;)
    {
      if ((!BuildInfo.DEBUG) && (!BuildInfo.DEBUG)) {
        break label78;
      }
      AppMethodBeat.o(258249);
      return bool1;
      bool1 = false;
      break;
      label73:
      bool2 = false;
    }
    label78:
    AppMethodBeat.o(258249);
    return bool2;
  }
  
  public static boolean dSV()
  {
    AppMethodBeat.i(258250);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIo, 1) == 1)
    {
      AppMethodBeat.o(258250);
      return true;
    }
    AppMethodBeat.o(258250);
    return false;
  }
  
  public static o<Integer, Boolean> dSW()
  {
    AppMethodBeat.i(258251);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIi, 4);
    try
    {
      Object localObject1 = Build.MODEL;
      p.j(localObject1, "Build.MODEL");
      localObject3 = Locale.getDefault();
      p.j(localObject3, "Locale.getDefault()");
      if (localObject1 != null) {
        break label111;
      }
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(258251);
      throw ((Throwable)localObject1);
    }
    catch (Throwable localThrowable1)
    {
      bool = false;
    }
    Log.printErrStackTrace("FinderConfig", localThrowable1, "", new Object[0]);
    Object localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
    AppMethodBeat.o(258251);
    return localObject2;
    label111:
    localObject2 = ((String)localObject2).toLowerCase((Locale)localObject3);
    p.j(localObject2, "(this as java.lang.String).toLowerCase(locale)");
    Object localObject3 = Build.BRAND;
    p.j(localObject3, "Build.BRAND");
    Object localObject4 = Locale.getDefault();
    p.j(localObject4, "Locale.getDefault()");
    if (localObject3 == null)
    {
      localObject2 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(258251);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
    p.j(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    localObject4 = "API#" + Build.VERSION.SDK_INT;
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIk, "");
    if (!Util.isNullOrNil(str))
    {
      p.j(str, "waitForRelease");
      if ((kotlin.n.n.g((CharSequence)str, (CharSequence)localObject2)) || (kotlin.n.n.g((CharSequence)str, (CharSequence)localObject3)) || (kotlin.n.n.g((CharSequence)str, (CharSequence)localObject4))) {
        Log.i("FinderConfig", "[getVideoViewConfig#waitForRelease] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
      }
    }
    for (boolean bool = true;; bool = false) {
      label520:
      for (;;)
      {
        try
        {
          str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIj, "");
          if (Util.isNullOrNil(str)) {
            break label520;
          }
          p.j(str, "videoSingleCount");
          if ((!kotlin.n.n.g((CharSequence)str, (CharSequence)localObject2)) && (!kotlin.n.n.g((CharSequence)str, (CharSequence)localObject3)) && (!kotlin.n.n.g((CharSequence)str, (CharSequence)localObject4))) {
            break label520;
          }
          Log.i("FinderConfig", "[getVideoViewConfig#videoSingleCount] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
          i = 1;
          try
          {
            localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
            AppMethodBeat.o(258251);
            return localObject2;
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
        break;
      }
    }
  }
  
  public static int dSX()
  {
    AppMethodBeat.i(166942);
    int i = ((Number)AeR.getValue()).intValue();
    AppMethodBeat.o(166942);
    return i;
  }
  
  public static boolean dSY()
  {
    AppMethodBeat.i(258252);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWp, 1) == 1) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(258252);
      return true;
    }
    AppMethodBeat.o(258252);
    return false;
  }
  
  public static boolean dSZ()
  {
    AppMethodBeat.i(258253);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWr, 1) == 1)
    {
      AppMethodBeat.o(258253);
      return true;
    }
    AppMethodBeat.o(258253);
    return false;
  }
  
  public static int dSa()
  {
    return Aem;
  }
  
  public static int dSb()
  {
    AppMethodBeat.i(166908);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166908);
      return 1280;
    }
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166908);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt((String)kotlin.n.n.a((CharSequence)kotlin.n.n.bb((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166908);
    return i;
  }
  
  public static int dSc()
  {
    AppMethodBeat.i(166909);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderFeedCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166909);
      return 1080;
    }
    Log.d("FinderConfig", "FinderFeedCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166909);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt((String)kotlin.n.n.a((CharSequence)kotlin.n.n.bb((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166909);
    return i;
  }
  
  public static int dSd()
  {
    AppMethodBeat.i(166910);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderFeedCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166910);
      return 90;
    }
    Log.d("FinderConfig", "FinderFeedCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166910);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt(kotlin.n.n.bb((CharSequence)localObject).toString());
    AppMethodBeat.o(166910);
    return i;
  }
  
  public static String dSe()
  {
    AppMethodBeat.i(258231);
    Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)localObject1).axc().getValue("FinderHeadIconFormat");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    Log.v("FinderConfig", "AVATAR_URL_FORMAT_JSON FinderAvatarUrlFormat: dynamic config json = ".concat(String.valueOf(localObject1)));
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = "{\"small\":\"64\",\"medium\":\"132\",\"origin\":\"0\"}";
    }
    AppMethodBeat.o(258231);
    return localObject2;
  }
  
  public static int dSf()
  {
    return Aeq;
  }
  
  public static int dSg()
  {
    AppMethodBeat.i(166911);
    int i = Aer;
    AppMethodBeat.o(166911);
    return i;
  }
  
  public static int dSh()
  {
    AppMethodBeat.i(166912);
    int i = Aes;
    AppMethodBeat.o(166912);
    return i;
  }
  
  public static int dSi()
  {
    AppMethodBeat.i(166913);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderHeadCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166913);
      return 90;
    }
    Log.i("FinderConfig", "FinderHeadCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166913);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt(kotlin.n.n.bb((CharSequence)localObject).toString());
    AppMethodBeat.o(166913);
    return i;
  }
  
  public static int dSj()
  {
    AppMethodBeat.i(166914);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166914);
      return 1080;
    }
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166914);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt((String)kotlin.n.n.a((CharSequence)kotlin.n.n.bb((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166914);
    return i;
  }
  
  public static int dSk()
  {
    AppMethodBeat.i(166915);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderProfileBgImgCompressResolution");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166915);
      return 1080;
    }
    Log.i("FinderConfig", "FinderHeadCompressResolution=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166915);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt((String)kotlin.n.n.a((CharSequence)kotlin.n.n.bb((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166915);
    return i;
  }
  
  public static int dSl()
  {
    AppMethodBeat.i(166916);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderProfileBgImgCompressPicLevel");
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166916);
      return 70;
    }
    Log.i("FinderConfig", "FinderProfileBgImgCompressPicLevel=".concat(String.valueOf(localObject)));
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(166916);
      throw ((Throwable)localObject);
    }
    i = Util.safeParseInt(kotlin.n.n.bb((CharSequence)localObject).toString());
    AppMethodBeat.o(166916);
    return i;
  }
  
  public static int dSm()
  {
    AppMethodBeat.i(258234);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).axc().getInt("FinderCoverCompressPicLevel", 50);
    AppMethodBeat.o(258234);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dSn()
  {
    return Aey;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dSo()
  {
    return Aez;
  }
  
  public static int dSp()
  {
    return AeA;
  }
  
  public static int dSq()
  {
    return AeC;
  }
  
  public static int dSr()
  {
    return AeD;
  }
  
  public static int dSs()
  {
    return AeE;
  }
  
  public static boolean dSt()
  {
    return AeG;
  }
  
  public static boolean dSu()
  {
    return AeH;
  }
  
  public static long dSv()
  {
    AppMethodBeat.i(166917);
    if ((AeI > 0L) && (Log.getLogLevel() <= 1))
    {
      l = AeI;
      AppMethodBeat.o(166917);
      return l;
    }
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHZ, 86400L);
    AppMethodBeat.o(166917);
    return l * 1000L;
  }
  
  private static float dSw()
  {
    AppMethodBeat.i(166918);
    Log.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + AeJ);
    if (AeJ < 10L)
    {
      AppMethodBeat.o(166918);
      return 0.5F;
    }
    if (AeJ < 20L)
    {
      AppMethodBeat.o(166918);
      return 1.0F;
    }
    AppMethodBeat.o(166918);
    return 2.0F;
  }
  
  public static long dSx()
  {
    AppMethodBeat.i(166919);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIa, 1024L) * AdY) * dSw());
    AppMethodBeat.o(166919);
    return l;
  }
  
  public static long dSy()
  {
    AppMethodBeat.i(166920);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIb, 100L) * AdY) * dSw());
    AppMethodBeat.o(166920);
    return l;
  }
  
  public static long dSz()
  {
    AppMethodBeat.i(166921);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIc, 500L) * AdY) * dSw());
    AppMethodBeat.o(166921);
    return l;
  }
  
  public static boolean dTA()
  {
    AppMethodBeat.i(258263);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vya, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isEnablePreloadStreamRefresh=".concat(String.valueOf(bool)));
      AppMethodBeat.o(258263);
      return bool;
    }
  }
  
  public static boolean dTB()
  {
    AppMethodBeat.i(258264);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyb, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isEnablePreloadVideoForPreloadStream=".concat(String.valueOf(bool)));
      AppMethodBeat.o(258264);
      return bool;
    }
  }
  
  public static kotlin.k.b<Double> dTC()
  {
    return Afg;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTD()
  {
    return Afh;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTE()
  {
    return Afi;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTF()
  {
    return Afj;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTG()
  {
    return Afk;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTH()
  {
    return Afl;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTI()
  {
    return Afm;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTJ()
  {
    return Afn;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dTK()
  {
    return Afo;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTL()
  {
    return Afp;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dTM()
  {
    return Afq;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTN()
  {
    return Afr;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTO()
  {
    return Afs;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTP()
  {
    return Aft;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTQ()
  {
    return Afu;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dTR()
  {
    return Afv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTS()
  {
    return Afw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTT()
  {
    return Afx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTU()
  {
    return Afy;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTV()
  {
    return Afz;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTW()
  {
    return AfA;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dTX()
  {
    return AfB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTY()
  {
    return AfC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTZ()
  {
    return AfD;
  }
  
  public static String dTa()
  {
    AppMethodBeat.i(166943);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJA, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
    AppMethodBeat.o(166943);
    return str;
  }
  
  public static boolean dTb()
  {
    AppMethodBeat.i(166944);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1)
    {
      AppMethodBeat.o(166944);
      return true;
    }
    AppMethodBeat.o(166944);
    return false;
  }
  
  public static boolean dTc()
  {
    AppMethodBeat.i(166945);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJB, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(bool)));
      AppMethodBeat.o(166945);
      return bool;
    }
  }
  
  public static boolean dTd()
  {
    AppMethodBeat.i(166948);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJE, 1) == 1)
    {
      AppMethodBeat.o(166948);
      return true;
    }
    AppMethodBeat.o(166948);
    return false;
  }
  
  public static boolean dTe()
  {
    AppMethodBeat.i(258254);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderMaxMentionSbCount", 1000) > 0)
    {
      AppMethodBeat.o(258254);
      return true;
    }
    AppMethodBeat.o(258254);
    return false;
  }
  
  public static boolean dTf()
  {
    AppMethodBeat.i(166950);
    if ((AeS == 0) && (Log.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166950);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderPoiJumpTopicSwitch", 0) == 1)
    {
      AppMethodBeat.o(166950);
      return true;
    }
    AppMethodBeat.o(166950);
    return false;
  }
  
  public static boolean dTg()
  {
    AppMethodBeat.i(166952);
    if ((AeT) && (Log.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166952);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJL, 1) == 1)
    {
      AppMethodBeat.o(166952);
      return true;
    }
    AppMethodBeat.o(166952);
    return false;
  }
  
  public static int dTh()
  {
    AppMethodBeat.i(178407);
    if ((AeU != 5) && (Log.getLogLevel() <= 1))
    {
      i = AeU;
      AppMethodBeat.o(178407);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJN, AeU);
    AppMethodBeat.o(178407);
    return i;
  }
  
  public static int dTi()
  {
    AppMethodBeat.i(178412);
    if (((Number)AfL.aSr()).intValue() == 1)
    {
      com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
      p.j(localf, "MMKernel.storage()");
      int i = localf.aHp().getInt(ar.a.VBK, AeV);
      if (i <= 0)
      {
        i = AeV;
        AppMethodBeat.o(178412);
        return i;
      }
      AppMethodBeat.o(178412);
      return i;
    }
    AppMethodBeat.o(178412);
    return 2;
  }
  
  public static int dTj()
  {
    return AeV;
  }
  
  public static boolean dTk()
  {
    AppMethodBeat.i(178413);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderCommentShowBlacklist", 0) == 1)
    {
      AppMethodBeat.o(178413);
      return true;
    }
    AppMethodBeat.o(178413);
    return false;
  }
  
  public static boolean dTl()
  {
    AppMethodBeat.i(178416);
    if ((AeX == 1) && (Log.getLogLevel() <= 1))
    {
      AppMethodBeat.o(178416);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKw, 0) == 1)
    {
      AppMethodBeat.o(178416);
      return true;
    }
    AppMethodBeat.o(178416);
    return false;
  }
  
  public static int dTm()
  {
    AppMethodBeat.i(178417);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKx, 10000000);
    AppMethodBeat.o(178417);
    return i;
  }
  
  public static int dTn()
  {
    AppMethodBeat.i(178418);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderCommentNickNameMaxLength", 6);
    AppMethodBeat.o(178418);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTo()
  {
    return AeY;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dTp()
  {
    return AeZ;
  }
  
  public static long dTq()
  {
    return Afa;
  }
  
  public static boolean dTr()
  {
    AppMethodBeat.i(258256);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHO, 1) == 1)
    {
      AppMethodBeat.o(258256);
      return true;
    }
    AppMethodBeat.o(258256);
    return false;
  }
  
  public static boolean dTs()
  {
    return Afb;
  }
  
  public static int dTt()
  {
    return Afc;
  }
  
  public static int dTu()
  {
    return Afd;
  }
  
  public static boolean dTw()
  {
    AppMethodBeat.i(258260);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHV, 1) == 1)
    {
      AppMethodBeat.o(258260);
      return true;
    }
    AppMethodBeat.o(258260);
    return false;
  }
  
  public static int dTx()
  {
    return Afe;
  }
  
  public static boolean dTy()
  {
    AppMethodBeat.i(258261);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vxZ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isEnableStoreLastTabType=".concat(String.valueOf(bool)));
      AppMethodBeat.o(258261);
      return bool;
    }
  }
  
  public static void dTz()
  {
    AppMethodBeat.i(258262);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VzM, Integer.valueOf(1));
    Aff = false;
    AppMethodBeat.o(258262);
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dUA()
  {
    return Agc;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUB()
  {
    return Agd;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUC()
  {
    return Age;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUD()
  {
    return Agf;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dUE()
  {
    return Agg;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUF()
  {
    return Agh;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUG()
  {
    return Agi;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUH()
  {
    return Agj;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> dUI()
  {
    return Agk;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUJ()
  {
    return Agm;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUK()
  {
    return Agn;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUL()
  {
    return Ago;
  }
  
  public static List<o<Integer, String>> dUM()
  {
    return Agp;
  }
  
  public static boolean dUN()
  {
    AppMethodBeat.i(258282);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).axc().getInt("FinderStatsReportControl", 1) == 1)
    {
      AppMethodBeat.o(258282);
      return true;
    }
    AppMethodBeat.o(258282);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUO()
  {
    return Agr;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUP()
  {
    return Ags;
  }
  
  public static int dUQ()
  {
    AppMethodBeat.i(258283);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKq, 0);
    AppMethodBeat.o(258283);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUR()
  {
    return Agt;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUS()
  {
    return Agu;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUT()
  {
    return Agv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUU()
  {
    return Agw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dUV()
  {
    return Agx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUW()
  {
    return Agy;
  }
  
  public static int dUX()
  {
    AppMethodBeat.i(258285);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VAS, 3);
    AppMethodBeat.o(258285);
    return i;
  }
  
  public static int dUY()
  {
    AppMethodBeat.i(258287);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VAT, 3);
    AppMethodBeat.o(258287);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUZ()
  {
    return AgA;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUa()
  {
    return AfE;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUb()
  {
    return AfF;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUc()
  {
    return AfG;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUd()
  {
    return AfH;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUe()
  {
    return AfI;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUf()
  {
    return AfJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUg()
  {
    return AfK;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUh()
  {
    return AfL;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUi()
  {
    return AfM;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUj()
  {
    return AfN;
  }
  
  public static int dUk()
  {
    AppMethodBeat.i(258274);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VAO, 4);
    AppMethodBeat.o(258274);
    return i;
  }
  
  public static int dUl()
  {
    AppMethodBeat.i(258276);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VAU, 0);
    AppMethodBeat.o(258276);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUm()
  {
    return AfO;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dUn()
  {
    return AfP;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUo()
  {
    return AfQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUp()
  {
    return AfR;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dUq()
  {
    return AfS;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUr()
  {
    return AfT;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUs()
  {
    return AfU;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUt()
  {
    return AfV;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUu()
  {
    return AfW;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUv()
  {
    return AfX;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUw()
  {
    return AfY;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dUx()
  {
    return AfZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dUy()
  {
    return Aga;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dUz()
  {
    return Agb;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVA()
  {
    return Aha;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVB()
  {
    return Ahb;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVC()
  {
    return Ahc;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVD()
  {
    return Ahd;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVE()
  {
    return Ahe;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVF()
  {
    return Ahf;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dVG()
  {
    return Ahg;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVH()
  {
    return Ahi;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVI()
  {
    return Ahj;
  }
  
  public static String dVJ()
  {
    AppMethodBeat.i(258296);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).axc().getValue("FinderShowOriginalCertificationUrl");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(258296);
      return "https://support.weixin.qq.com/cgi-bin/mmfindersupport-bin/newreadtemplate?t=page/outer_page/original_plan&wechat_real_lang=zh_CN";
    }
    p.j(localObject, "url");
    AppMethodBeat.o(258296);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dVK()
  {
    return Ahk;
  }
  
  public static int dVL()
  {
    AppMethodBeat.i(258297);
    com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.Vzy, 1);
    AppMethodBeat.o(258297);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVM()
  {
    return Ahl;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVN()
  {
    return Ahm;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVO()
  {
    return Ahn;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVP()
  {
    return Aho;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVQ()
  {
    return Ahp;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVR()
  {
    return Ahq;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVS()
  {
    return Ahr;
  }
  
  public static List<String> dVT()
  {
    AppMethodBeat.i(258299);
    Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)localObject1).axc().getValue("FinderTopicInputStopTokenList");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    if ((localObject1 != null) && ((p.h(localObject1, "") ^ true)))
    {
      localObject2 = (Iterable)kotlin.n.n.a((CharSequence)localObject1, new String[] { "_" });
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label148:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (!Util.isNullOrNil((String)localObject3)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label148;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      Log.i("FinderConfig", "endchars: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(258299);
      return localObject1;
    }
    localObject1 = j.listOf(new String[] { "\\s", "\\n", "#", "@", "\\t" });
    AppMethodBeat.o(258299);
    return localObject1;
  }
  
  public static List<String> dVU()
  {
    AppMethodBeat.i(258300);
    Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)localObject1).axc().getValue("FinderMentionInputStopTokenList");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    if ((localObject1 != null) && ((p.h(localObject1, "") ^ true)))
    {
      localObject2 = (Iterable)kotlin.n.n.a((CharSequence)localObject1, new String[] { "_" });
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label148:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (!Util.isNullOrNil((String)localObject3)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label148;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = (List)localObject1;
      Log.i("FinderConfig", "endchars: ".concat(String.valueOf(localObject1)));
      AppMethodBeat.o(258300);
      return localObject1;
    }
    localObject1 = j.listOf(new String[] { "\\s", "\\n", "#", "@", "\\t" });
    AppMethodBeat.o(258300);
    return localObject1;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVV()
  {
    return Ahu;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dVW()
  {
    return Ahv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVX()
  {
    return Ahw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVY()
  {
    return Ahx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVZ()
  {
    return Ahy;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dVa()
  {
    return AgB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVb()
  {
    return AgC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVc()
  {
    return AgD;
  }
  
  public static boolean dVd()
  {
    AppMethodBeat.i(258289);
    if (((Number)AgD.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(258289);
      return true;
    }
    AppMethodBeat.o(258289);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVe()
  {
    return AgE;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVf()
  {
    return AgF;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVg()
  {
    return AgG;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVh()
  {
    return AgH;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVi()
  {
    return AgI;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dVj()
  {
    return AgJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVk()
  {
    return AgK;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVl()
  {
    return AgL;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVm()
  {
    return AgM;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVn()
  {
    return AgN;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVo()
  {
    return AgO;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVp()
  {
    return AgP;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVq()
  {
    return AgQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVr()
  {
    return AgR;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVs()
  {
    return AgS;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVt()
  {
    return AgT;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVu()
  {
    return AgU;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVv()
  {
    return AgV;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVw()
  {
    return AgW;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVx()
  {
    return AgX;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVy()
  {
    return AgY;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dVz()
  {
    return AgZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWA()
  {
    return AhZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWB()
  {
    return Aia;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWC()
  {
    return Aib;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWD()
  {
    return Aic;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWE()
  {
    return Aid;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWF()
  {
    return Aie;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWG()
  {
    return Aif;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWH()
  {
    return Aig;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWI()
  {
    return Aih;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWJ()
  {
    return Aii;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWK()
  {
    return Aij;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Float> dWL()
  {
    return Aik;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWM()
  {
    return Ail;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWN()
  {
    return Aim;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWO()
  {
    return Ain;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWP()
  {
    return Aio;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWQ()
  {
    return Aip;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWR()
  {
    return Aiq;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dWS()
  {
    return Air;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dWT()
  {
    return Ais;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dWU()
  {
    return Ait;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dWV()
  {
    return Aiu;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dWW()
  {
    return Aiv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWX()
  {
    return Aiw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dWY()
  {
    return Aix;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> dWZ()
  {
    return Aiy;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWa()
  {
    return Ahz;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWb()
  {
    return AhA;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWc()
  {
    return AhB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWd()
  {
    return AhC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWe()
  {
    return AhD;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> dWf()
  {
    return AhE;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> dWg()
  {
    return AhF;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> dWh()
  {
    return AhG;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWi()
  {
    return AhH;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWj()
  {
    return AhI;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWk()
  {
    return AhJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWl()
  {
    return AhK;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWm()
  {
    return AhL;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWn()
  {
    return AhM;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWo()
  {
    return AhN;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWp()
  {
    return AhO;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWq()
  {
    return AhP;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWr()
  {
    return AhQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWs()
  {
    return AhR;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWt()
  {
    return AhS;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWu()
  {
    return AhT;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWv()
  {
    return AhU;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWw()
  {
    return AhV;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWx()
  {
    return AhW;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWy()
  {
    return AhX;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dWz()
  {
    return AhY;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXA()
  {
    return AiY;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXB()
  {
    return AiZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXC()
  {
    return Aja;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXD()
  {
    return Ajb;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXE()
  {
    return Ajc;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXF()
  {
    return Ajd;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXG()
  {
    return Aje;
  }
  
  public static boolean dXH()
  {
    AppMethodBeat.i(258307);
    if (((Number)Aje.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(258307);
      return true;
    }
    AppMethodBeat.o(258307);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXI()
  {
    return Ajf;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXJ()
  {
    return Ajg;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dXK()
  {
    return Ajh;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dXL()
  {
    return Aji;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXM()
  {
    return Ajj;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXN()
  {
    return Ajk;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXO()
  {
    return Ajl;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXP()
  {
    return Ajm;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXQ()
  {
    return Ajn;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXR()
  {
    return Ajo;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXS()
  {
    return Ajp;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXT()
  {
    return Ajr;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXU()
  {
    return Ajs;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXV()
  {
    return Ajt;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXW()
  {
    return Aju;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXX()
  {
    return Ajv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXY()
  {
    return Ajw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXZ()
  {
    return Ajx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXa()
  {
    return Aiz;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXb()
  {
    return AiA;
  }
  
  public static boolean dXc()
  {
    AppMethodBeat.i(258306);
    if (((Number)Aiz.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(258306);
      return true;
    }
    AppMethodBeat.o(258306);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dXd()
  {
    return AiB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dXe()
  {
    return AiC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> dXf()
  {
    return AiD;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> dXg()
  {
    return AiE;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> dXh()
  {
    return AiF;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXi()
  {
    return AiG;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXj()
  {
    return AiH;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXk()
  {
    return AiI;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXl()
  {
    return AiJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXm()
  {
    return AiK;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXn()
  {
    return AiL;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXo()
  {
    return AiM;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXp()
  {
    return AiN;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXq()
  {
    return AiO;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXr()
  {
    return AiP;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXs()
  {
    return AiQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXt()
  {
    return AiR;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXu()
  {
    return AiS;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dXv()
  {
    return AiT;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a dXw()
  {
    return AiU;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXx()
  {
    return AiV;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXy()
  {
    return AiW;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dXz()
  {
    return AiX;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dYa()
  {
    return Ajy;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dYb()
  {
    return Ajz;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dYc()
  {
    return AjA;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dYd()
  {
    return AjB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dYe()
  {
    return AjC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dYf()
  {
    return AjD;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dYg()
  {
    return AjE;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> dYh()
  {
    return AjF;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.c dYi()
  {
    return AjG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final a AjI;
    
    static
    {
      AppMethodBeat.i(258184);
      AjI = new a();
      AppMethodBeat.o(258184);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class ae
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final ae Akj;
    
    static
    {
      AppMethodBeat.i(258068);
      Akj = new ae();
      AppMethodBeat.o(258068);
    }
    
    ae()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class ag
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final ag Akl;
    
    static
    {
      AppMethodBeat.i(258498);
      Akl = new ag();
      AppMethodBeat.o(258498);
    }
    
    ag()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class ar
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final ar Akw;
    
    static
    {
      AppMethodBeat.i(258821);
      Akw = new ar();
      AppMethodBeat.o(258821);
    }
    
    ar()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class as
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final as Akx;
    
    static
    {
      AppMethodBeat.i(259529);
      Akx = new as();
      AppMethodBeat.o(259529);
    }
    
    as()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class at
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final at Aky;
    
    static
    {
      AppMethodBeat.i(166900);
      Aky = new at();
      AppMethodBeat.o(166900);
    }
    
    at()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class au
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final au Akz;
    
    static
    {
      AppMethodBeat.i(166902);
      Akz = new au();
      AppMethodBeat.o(166902);
    }
    
    au()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final b AjJ;
    
    static
    {
      AppMethodBeat.i(263686);
      AjJ = new b();
      AppMethodBeat.o(263686);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final e AjM;
    
    static
    {
      AppMethodBeat.i(259131);
      AjM = new e();
      AppMethodBeat.o(259131);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final i AjQ;
    
    static
    {
      AppMethodBeat.i(262764);
      AjQ = new i();
      AppMethodBeat.o(262764);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final u Aka;
    
    static
    {
      AppMethodBeat.i(259028);
      Aka = new u();
      AppMethodBeat.o(259028);
    }
    
    u()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.d
 * JD-Core Version:    0.7.0.1
 */