package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderConfig;", "", "()V", "ADJUST_AVATAR_ORDER_LIKE", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "getADJUST_AVATAR_ORDER_LIKE", "()Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "AT_END_CHAR", "", "", "getAT_END_CHAR", "()Ljava/util/List;", "AT_SWITCH", "", "getAT_SWITCH", "()Z", "AUTO_FEEDBACK", "Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "getAUTO_FEEDBACK", "()Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;", "AVATAR_COMPRESS_QUALITY", "getAVATAR_COMPRESS_QUALITY", "()I", "setAVATAR_COMPRESS_QUALITY", "(I)V", "AVATAR_MAX_HEIGHT", "getAVATAR_MAX_HEIGHT", "setAVATAR_MAX_HEIGHT", "AVATAR_MAX_THUMB_WIDTH", "AVATAR_MAX_WIDTH", "getAVATAR_MAX_WIDTH", "setAVATAR_MAX_WIDTH", "AVATAR_UPLOAD_MAX_SIZE", "getAVATAR_UPLOAD_MAX_SIZE", "BG_MERGE", "getBG_MERGE", "Big_File_LENGTH", "getBig_File_LENGTH", "setBig_File_LENGTH", "CAN_BAN_FINDER_COMMENT", "getCAN_BAN_FINDER_COMMENT", "CAN_SHOW_CHANGE_DISTRICT", "getCAN_SHOW_CHANGE_DISTRICT", "setCAN_SHOW_CHANGE_DISTRICT", "(Z)V", "CAN_SWITCH_SCENE", "getCAN_SWITCH_SCENE", "CDN_UPLOAD_CONTROL", "getCDN_UPLOAD_CONTROL", "CHANGE_TO_NO_FINDER_ENTRANCE", "Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "getCHANGE_TO_NO_FINDER_ENTRANCE", "()Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "setCHANGE_TO_NO_FINDER_ENTRANCE", "(Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;)V", "CHECK_FINDER_CACHE", "getCHECK_FINDER_CACHE", "CHECK_TAB_TIP_TEST", "getCHECK_TAB_TIP_TEST", "CLEAR_KEY_BUF", "getCLEAR_KEY_BUF", "setCLEAR_KEY_BUF", "CLEAR_KEY_BUF_DATA", "getCLEAR_KEY_BUF_DATA", "setCLEAR_KEY_BUF_DATA", "CLEAR_MSG_LAST_BUFF", "getCLEAR_MSG_LAST_BUFF", "CLEAR_MUTITAB_NEW_RED_DOT", "getCLEAR_MUTITAB_NEW_RED_DOT", "CLEAR_PNG_VIDEO_CACHE", "getCLEAR_PNG_VIDEO_CACHE", "setCLEAR_PNG_VIDEO_CACHE", "CLEAR_SIMILAR_TIPS", "getCLEAR_SIMILAR_TIPS", "COMMENT_EXPAND", "getCOMMENT_EXPAND", "COMMENT_FRIEND_CAN_CLICK", "getCOMMENT_FRIEND_CAN_CLICK", "COMMENT_FULL_SCREEN", "getCOMMENT_FULL_SCREEN", "COMMENT_PRELOAD_ENABLE", "getCOMMENT_PRELOAD_ENABLE", "COMMENT_PRELOAD_REMAIN_COUNT", "getCOMMENT_PRELOAD_REMAIN_COUNT", "COMMENT_TEXT_LIMIT", "getCOMMENT_TEXT_LIMIT", "COVER_COMPRESS_QUALITY", "getCOVER_COMPRESS_QUALITY", "setCOVER_COMPRESS_QUALITY", "COVER_MAX_HEIGHT", "getCOVER_MAX_HEIGHT", "setCOVER_MAX_HEIGHT", "COVER_MAX_WIDTH", "getCOVER_MAX_WIDTH", "setCOVER_MAX_WIDTH", "CP_TO_CLIPBOARD", "getCP_TO_CLIPBOARD", "Comment_Max_Length", "getComment_Max_Length", "DEBUG_CLEAR_FULL_SCREEN_TAB_RED_DOT_FLAG", "getDEBUG_CLEAR_FULL_SCREEN_TAB_RED_DOT_FLAG", "DEBUG_FAV_SIMILAR", "getDEBUG_FAV_SIMILAR", "DEBUG_INSERT_RED_DOT", "getDEBUG_INSERT_RED_DOT", "DEBUG_INSERT_RED_DOT_FLAG", "getDEBUG_INSERT_RED_DOT_FLAG", "DEBUG_LIVE_BEAUTY_CONFIG", "getDEBUG_LIVE_BEAUTY_CONFIG", "setDEBUG_LIVE_BEAUTY_CONFIG", "(Lcom/tencent/mm/plugin/finder/storage/config/item/booleantype/FinderBooleanConfig;)V", "DEBUG_LIVE_LICENSE", "getDEBUG_LIVE_LICENSE", "setDEBUG_LIVE_LICENSE", "DEBUG_LIVE_LIST_REPEAT", "getDEBUG_LIVE_LIST_REPEAT", "DEBUG_LIVE_POST_FACE_VERIFY", "getDEBUG_LIVE_POST_FACE_VERIFY", "setDEBUG_LIVE_POST_FACE_VERIFY", "DEBUG_POST_UPLOAD_BLOCK", "getDEBUG_POST_UPLOAD_BLOCK", "DEBUG_PRIVATE_LIKE_TIPS_COUNT", "getDEBUG_PRIVATE_LIKE_TIPS_COUNT", "setDEBUG_PRIVATE_LIKE_TIPS_COUNT", "DEBUG_SWITCH_SCENE_TIP", "getDEBUG_SWITCH_SCENE_TIP", "setDEBUG_SWITCH_SCENE_TIP", "DEFAULT_CODEC_REUSE_JSON", "DEFAULT_FAKE_VIDEO_CONFIG_JSON", "DEFAULT_GESTURE_PREVIEW_MEDIA_JSON", "DEFAULT_REPLY_SCENE", "getDEFAULT_REPLY_SCENE", "setDEFAULT_REPLY_SCENE", "DELAY_TIME", "getDELAY_TIME", "setDELAY_TIME", "DOUBLE_CLICK_RESET_FAV_RED_DOT", "getDOUBLE_CLICK_RESET_FAV_RED_DOT", "setDOUBLE_CLICK_RESET_FAV_RED_DOT", "DUMP_FILE_TIME_INTERVAL", "", "getDUMP_FILE_TIME_INTERVAL", "()J", "EDITOR_TRANSITION_MAGIC", "getEDITOR_TRANSITION_MAGIC", "EMPTY_FOOTER_IGNORE_CHECK", "getEMPTY_FOOTER_IGNORE_CHECK", "ENABLE_FINDER_MESSAGE", "getENABLE_FINDER_MESSAGE", "ENABLE_IMAGE_ENHANCEMENT_SETTING", "getENABLE_IMAGE_ENHANCEMENT_SETTING", "ENABLE_MEDIA_CODEC_REUSE", "getENABLE_MEDIA_CODEC_REUSE", "ENABLE_POST_43_RADIO_VIDEO", "getENABLE_POST_43_RADIO_VIDEO", "ENABLE_SHOW_OTHER_PROFILE_FANS", "getENABLE_SHOW_OTHER_PROFILE_FANS", "ENABLE_SOFT_ENCODE_FALLBACK", "getENABLE_SOFT_ENCODE_FALLBACK", "ENABLE_VIDEO_PRELOAD", "getENABLE_VIDEO_PRELOAD", "ENABLE_VIDEO_TEMPLTE", "getENABLE_VIDEO_TEMPLTE", "EXPOSE_COMMENTBTN_SHOW", "getEXPOSE_COMMENTBTN_SHOW", "EXPOSE_COMMENT_SHOW", "getEXPOSE_COMMENT_SHOW", "FAKE_CARD_JUMP_HOT_TAB_DATA", "getFAKE_CARD_JUMP_HOT_TAB_DATA", "FAKE_DATA_IN_SELF_SCENE", "getFAKE_DATA_IN_SELF_SCENE", "FAKE_LOADING_TOAST", "getFAKE_LOADING_TOAST", "FAKE_VIDEO_CONFIG_JSON", "kotlin.jvm.PlatformType", "getFAKE_VIDEO_CONFIG_JSON", "()Ljava/lang/String;", "FEED_ALL_FORCE_NEWS", "getFEED_ALL_FORCE_NEWS", "FEED_COMMENT_EDU", "getFEED_COMMENT_EDU", "FEED_ONLY_ME_VISIBLE", "getFEED_ONLY_ME_VISIBLE", "setFEED_ONLY_ME_VISIBLE", "FINDER_ACTIVITY_SHARE_BUSINESS_TYPE", "getFINDER_ACTIVITY_SHARE_BUSINESS_TYPE", "FINDER_BULLET_SUBTITLE_EXPT_SWITCH", "getFINDER_BULLET_SUBTITLE_EXPT_SWITCH", "FINDER_CLEAR_BULLET_SUBTITLE_EXPT_CONFIGURATION", "getFINDER_CLEAR_BULLET_SUBTITLE_EXPT_CONFIGURATION", "FINDER_CLEAR_CACHE", "getFINDER_CLEAR_CACHE", "FINDER_CLEAR_POST_TASK", "getFINDER_CLEAR_POST_TASK", "FINDER_CREATE_GUIDE_ENTRY", "getFINDER_CREATE_GUIDE_ENTRY", "FINDER_CREATE_WXNAME_SWITCH", "getFINDER_CREATE_WXNAME_SWITCH", "FINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "getFINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "setFINDER_DEBUG_CGI_BLOCK_LIMIT_LOG", "(Ljava/lang/String;)V", "FINDER_DEBUG_CGI_BLOCK_LIST_LOG", "getFINDER_DEBUG_CGI_BLOCK_LIST_LOG", "setFINDER_DEBUG_CGI_BLOCK_LIST_LOG", "FINDER_DEBUG_CGI_LOG", "getFINDER_DEBUG_CGI_LOG", "FINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", "getFINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", "FINDER_ENABLE_HORIZONTAL_PREVIEWING", "getFINDER_ENABLE_HORIZONTAL_PREVIEWING", "FINDER_FEED_GROUP_LIKE_GUIDE_CONFIG", "getFINDER_FEED_GROUP_LIKE_GUIDE_CONFIG", "FINDER_FILE_CLEAN_DEBUG_MODE", "getFINDER_FILE_CLEAN_DEBUG_MODE", "FINDER_FILTER_HOT_REDDOT_IN_FINDER", "getFINDER_FILTER_HOT_REDDOT_IN_FINDER", "FINDER_FINDER_ENTER_LOAD_SWITCH", "getFINDER_FINDER_ENTER_LOAD_SWITCH", "FINDER_FOLLOW_FULLSCREEN_ENJOY", "getFINDER_FOLLOW_FULLSCREEN_ENJOY", "FINDER_FOLLOW_PAT_ENTRANCE", "getFINDER_FOLLOW_PAT_ENTRANCE", "FINDER_FRIEND_FULLSCREEN_ENJOY", "getFINDER_FRIEND_FULLSCREEN_ENJOY", "FINDER_FULLSCREEN_INSIDE_RADIO", "", "getFINDER_FULLSCREEN_INSIDE_RADIO", "FINDER_FULL_FEED_GUIDE_CONFIG", "getFINDER_FULL_FEED_GUIDE_CONFIG", "FINDER_FULL_LIKE_FEED_GUIDE_CONFIG", "getFINDER_FULL_LIKE_FEED_GUIDE_CONFIG", "FINDER_GLOBAL_FULLSCREEN_ENJOY", "getFINDER_GLOBAL_FULLSCREEN_ENJOY", "FINDER_HOT_FULLSCREEN_ENJOY", "getFINDER_HOT_FULLSCREEN_ENJOY", "FINDER_LIVE", "getFINDER_LIVE", "FINDER_LIVE_ADD_TO_HISTORY_OFFSET", "getFINDER_LIVE_ADD_TO_HISTORY_OFFSET", "FINDER_LIVE_BEAUTY_ENABLE", "getFINDER_LIVE_BEAUTY_ENABLE", "FINDER_LIVE_BULLET_COMMENT_LIMIT_NUM", "getFINDER_LIVE_BULLET_COMMENT_LIMIT_NUM", "FINDER_LIVE_COMMENT_SIZE_LIMIT", "getFINDER_LIVE_COMMENT_SIZE_LIMIT", "FINDER_LIVE_COMMON_INFO_FROZEN", "getFINDER_LIVE_COMMON_INFO_FROZEN", "FINDER_LIVE_ENABLE_SHOPPING", "getFINDER_LIVE_ENABLE_SHOPPING", "FINDER_LIVE_FEED_CACHE_DURATION", "getFINDER_LIVE_FEED_CACHE_DURATION", "FINDER_LIVE_FILTER_ENABLE", "getFINDER_LIVE_FILTER_ENABLE", "FINDER_LIVE_FIT_LANDSCAPE_VIDEO", "getFINDER_LIVE_FIT_LANDSCAPE_VIDEO", "FINDER_LIVE_FRONT_RENDER_MIRROR", "getFINDER_LIVE_FRONT_RENDER_MIRROR", "FINDER_LIVE_GET_COMMENT_DURATION", "getFINDER_LIVE_GET_COMMENT_DURATION", "FINDER_LIVE_GIFT_ANIM_STAY_DURATION", "getFINDER_LIVE_GIFT_ANIM_STAY_DURATION", "FINDER_LIVE_GIFT_COMBOID_LIVE_TIME", "getFINDER_LIVE_GIFT_COMBOID_LIVE_TIME", "FINDER_LIVE_GIFT_FULL_PAG_DEFAULT_DURATION", "getFINDER_LIVE_GIFT_FULL_PAG_DEFAULT_DURATION", "FINDER_LIVE_GIFT_QUEUE_MAX_SIZE", "getFINDER_LIVE_GIFT_QUEUE_MAX_SIZE", "FINDER_LIVE_GIFT_QUEUE_NICKNAME_LENGTH", "getFINDER_LIVE_GIFT_QUEUE_NICKNAME_LENGTH", "FINDER_LIVE_GUIDE_ENABLE", "getFINDER_LIVE_GUIDE_ENABLE", "FINDER_LIVE_LANDSCAPE", "getFINDER_LIVE_LANDSCAPE", "FINDER_LIVE_LINK_MIC_ENABLE", "getFINDER_LIVE_LINK_MIC_ENABLE", "FINDER_LIVE_LOTTERY", "getFINDER_LIVE_LOTTERY", "FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", "getFINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", "FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", "getFINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", "FINDER_LIVE_LOTTERY_DURATION", "getFINDER_LIVE_LOTTERY_DURATION", "FINDER_LIVE_LOTTERY_SAVEID_SIZE", "getFINDER_LIVE_LOTTERY_SAVEID_SIZE", "FINDER_LIVE_LOTTERY_UPDATE_STRATEGY", "getFINDER_LIVE_LOTTERY_UPDATE_STRATEGY", "FINDER_LIVE_MAX_NUM", "getFINDER_LIVE_MAX_NUM", "FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", "getFINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", "FINDER_LIVE_MINIPRO_PRE_RENDER_LEVEL", "getFINDER_LIVE_MINIPRO_PRE_RENDER_LEVEL", "FINDER_LIVE_MINIPRO_TEST", "getFINDER_LIVE_MINIPRO_TEST", "FINDER_LIVE_MSG_BADGE_DEBUG", "getFINDER_LIVE_MSG_BADGE_DEBUG", "FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", "getFINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", "FINDER_LIVE_MSG_SEND_LOCAL_GIFT", "getFINDER_LIVE_MSG_SEND_LOCAL_GIFT", "FINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG", "getFINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG", "FINDER_LIVE_NEW_GUIDE_SHOW_ALWAYS", "getFINDER_LIVE_NEW_GUIDE_SHOW_ALWAYS", "FINDER_LIVE_NOTICE_TIME", "getFINDER_LIVE_NOTICE_TIME", "FINDER_LIVE_REFRESH_DURATION", "getFINDER_LIVE_REFRESH_DURATION", "FINDER_LIVE_REPLY_ENABLE", "getFINDER_LIVE_REPLY_ENABLE", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE", "getFINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE", "FINDER_LIVE_SHOPPING_HEIGHT_PERCENT", "getFINDER_LIVE_SHOPPING_HEIGHT_PERCENT", "FINDER_LIVE_SHOPPING_REFRESH_FREQUENCY", "getFINDER_LIVE_SHOPPING_REFRESH_FREQUENCY", "FINDER_LIVE_SHOPPING_THREAD_PARTY_STRATEGY", "getFINDER_LIVE_SHOPPING_THREAD_PARTY_STRATEGY", "FINDER_LIVE_STATISTICS_FREQUENCY", "getFINDER_LIVE_STATISTICS_FREQUENCY", "FINDER_LIVE_TICKLE_ENABLE", "getFINDER_LIVE_TICKLE_ENABLE", "FINDER_LIVE_VISIBLITY_DEBUG_DATA", "getFINDER_LIVE_VISIBLITY_DEBUG_DATA", "FINDER_LIVE_VISIBLITY_ENTRANCE", "getFINDER_LIVE_VISIBLITY_ENTRANCE", "FINDER_LIVE_VISITOR_MAX_RETRY_COUNT", "getFINDER_LIVE_VISITOR_MAX_RETRY_COUNT", "FINDER_LIVE_VISITOR_MODE", "getFINDER_LIVE_VISITOR_MODE", "FINDER_LIVE_VISITOR_RETRY_TINTERVAL", "getFINDER_LIVE_VISITOR_RETRY_TINTERVAL", "FINDER_MEGA_VIDEO_ADD_TO_HISTORY_OFFSET", "getFINDER_MEGA_VIDEO_ADD_TO_HISTORY_OFFSET", "FINDER_MEGA_VIDEO_DELETE_FROM_HISTORY_OFFSET", "getFINDER_MEGA_VIDEO_DELETE_FROM_HISTORY_OFFSET", "FINDER_NEARBY_LIVE_FRIENDS", "getFINDER_NEARBY_LIVE_FRIENDS", "FINDER_NEARBY_LIVE_FRIENDS_NEW_DOT_CONFIG", "getFINDER_NEARBY_LIVE_FRIENDS_NEW_DOT_CONFIG", "FINDER_NEARBY_LIVE_FRIENDS_TOTAL", "getFINDER_NEARBY_LIVE_FRIENDS_TOTAL", "FINDER_NEARBY_LIVE_PULL_SIMILAR", "getFINDER_NEARBY_LIVE_PULL_SIMILAR", "FINDER_NEARBY_LIVE_SQUARE_SCROLL_GUIDE", "getFINDER_NEARBY_LIVE_SQUARE_SCROLL_GUIDE", "FINDER_NOTIFY_RED_DOT", "getFINDER_NOTIFY_RED_DOT", "FINDER_NOTIFY_RED_DOT_VALUE", "Lkotlin/Pair;", "getFINDER_NOTIFY_RED_DOT_VALUE", "setFINDER_NOTIFY_RED_DOT_VALUE", "(Ljava/util/List;)V", "FINDER_OPEN_GESTURE", "getFINDER_OPEN_GESTURE", "FINDER_OPEN_PRELOAD_PREVIEW", "getFINDER_OPEN_PRELOAD_PREVIEW", "FINDER_OTHER_FULLSCREEN_ENJOY", "getFINDER_OTHER_FULLSCREEN_ENJOY", "FINDER_POI_REDIRECT_TO_NEW_PAGE", "getFINDER_POI_REDIRECT_TO_NEW_PAGE", "FINDER_POSTER_SERVICE_URL", "getFINDER_POSTER_SERVICE_URL", "FINDER_POST_DISABLE_HALF_SCREEN", "getFINDER_POST_DISABLE_HALF_SCREEN", "FINDER_POST_FAILED_IN_STAGE", "getFINDER_POST_FAILED_IN_STAGE", "FINDER_POST_FORCE_ZIP", "getFINDER_POST_FORCE_ZIP", "FINDER_RECENT_LIKE_SHOW_CLOSE_CONFIG", "getFINDER_RECENT_LIKE_SHOW_CLOSE_CONFIG", "FINDER_RECENT_LIKE_SHOW_CONFIG", "getFINDER_RECENT_LIKE_SHOW_CONFIG", "FINDER_REDPACK_CLOSE_TAG_CLEAR", "getFINDER_REDPACK_CLOSE_TAG_CLEAR", "FINDER_REDPACK_ENTER_TAG_CLEAR", "getFINDER_REDPACK_ENTER_TAG_CLEAR", "FINDER_REDPACK_REDDOR_PUSH", "getFINDER_REDPACK_REDDOR_PUSH", "FINDER_SEARCH_HOT", "getFINDER_SEARCH_HOT", "FINDER_SELF_STATE", "getFINDER_SELF_STATE", "FINDER_SETTING_WXPROFILE_SWITCH", "getFINDER_SETTING_WXPROFILE_SWITCH", "FINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", "getFINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", "FINDER_SHARE_FULLSCREEN_ENJOY", "getFINDER_SHARE_FULLSCREEN_ENJOY", "FINDER_SHARE_JUMP_HOME_DEFAULT_TAB", "getFINDER_SHARE_JUMP_HOME_DEFAULT_TAB", "FINDER_SHARE_MODE", "getFINDER_SHARE_MODE", "FINDER_SHARE_POPUP_PULL_TIPS_LAYOUT", "getFINDER_SHARE_POPUP_PULL_TIPS_LAYOUT", "FINDER_SHOW_SELF_FEED_LIKE_TIPS_CONFIG", "getFINDER_SHOW_SELF_FEED_LIKE_TIPS_CONFIG", "FINDER_SNS_CLEAR_BTN", "getFINDER_SNS_CLEAR_BTN", "FINDER_TIMELINE_REFRESH_EXPIRED", "getFINDER_TIMELINE_REFRESH_EXPIRED", "FINDER_TIMLINE_ENTRY", "getFINDER_TIMLINE_ENTRY", "FINDER_VIDEO_TP_PREPARE_ENABLE", "getFINDER_VIDEO_TP_PREPARE_ENABLE", "FIRST_HOT_TAB_PRELOAD_RANDOM", "getFIRST_HOT_TAB_PRELOAD_RANDOM", "FIX_REINIT_SELECTOR_ENABLE", "getFIX_REINIT_SELECTOR_ENABLE", "FLUTTER_VERSION", "getFLUTTER_VERSION", "FOLDED_MORE_ITEM_COUNT", "getFOLDED_MORE_ITEM_COUNT", "FOLDER_MAXSIZE_OF_AVATAR", "getFOLDER_MAXSIZE_OF_AVATAR", "FOLDER_MAXSIZE_OF_CAPTURE", "getFOLDER_MAXSIZE_OF_CAPTURE", "FOLDER_MAXSIZE_OF_COVERIMG", "getFOLDER_MAXSIZE_OF_COVERIMG", "FOLDER_MAXSIZE_OF_IMAGE", "getFOLDER_MAXSIZE_OF_IMAGE", "FOLDER_MAXSIZE_OF_POSTTMP", "getFOLDER_MAXSIZE_OF_POSTTMP", "FOLDER_MAXSIZE_OF_TMP", "getFOLDER_MAXSIZE_OF_TMP", "FOLDER_MAXSIZE_OF_VIDEO", "getFOLDER_MAXSIZE_OF_VIDEO", "FOLDER_SIZE_LEVEL", "getFOLDER_SIZE_LEVEL", "()F", "FRIEND_COMMENT_SHOW_HEADER", "getFRIEND_COMMENT_SHOW_HEADER", "Finder_LIVE_GIFT_ENABLE", "getFinder_LIVE_GIFT_ENABLE", "setFinder_LIVE_GIFT_ENABLE", "(Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;)V", "GAME_CENTER_JSAPI_DEBUG", "getGAME_CENTER_JSAPI_DEBUG", "GAME_CENTER_JSAPI_DEBUG_CONFIG", "getGAME_CENTER_JSAPI_DEBUG_CONFIG", "GRID_LAYOUT", "getGRID_LAYOUT", "HEVC_ENCODE_OPTION", "getHEVC_ENCODE_OPTION", "HIGH_RECORD_BITRATE", "getHIGH_RECORD_BITRATE", "IF_SHOW_ACCOUTN_DETAIL", "getIF_SHOW_ACCOUTN_DETAIL", "IMAGE_COMPRESS_QUALITY", "getIMAGE_COMPRESS_QUALITY", "setIMAGE_COMPRESS_QUALITY", "IMAGE_MAX_HEIGHT", "getIMAGE_MAX_HEIGHT", "setIMAGE_MAX_HEIGHT", "IMAGE_MAX_WIDTH", "getIMAGE_MAX_WIDTH", "setIMAGE_MAX_WIDTH", "IS_ADJUST_FEED_WHEN_OPEN_DRAWER", "getIS_ADJUST_FEED_WHEN_OPEN_DRAWER", "IS_ENABLE_SHARE_ALBUM", "getIS_ENABLE_SHARE_ALBUM", "IS_ENABLE_SHARE_ALBUM_PRELOAD", "getIS_ENABLE_SHARE_ALBUM_PRELOAD", "IS_SHOW_FAV_ANIM_UNLIMITED", "getIS_SHOW_FAV_ANIM_UNLIMITED", "IS_USE_VLOG_MODE", "getIS_USE_VLOG_MODE", "IS_VLOG_BACKGROUND_MUX", "getIS_VLOG_BACKGROUND_MUX", "Image_Max_Size", "getImage_Max_Size", "JSAPI_SWITCH", "getJSAPI_SWITCH", "LBS_CGI_ONLY_STREAM", "getLBS_CGI_ONLY_STREAM", "LBS_TAB_LOCATION_DURATION", "getLBS_TAB_LOCATION_DURATION", "LBS_TAB_WAIT_LOCATION_TIME", "getLBS_TAB_WAIT_LOCATION_TIME", "LIKE_COMMENT_EDU", "getLIKE_COMMENT_EDU", "LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "getLIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "setLIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "LIVE_GIFT_DEBUG", "getLIVE_GIFT_DEBUG", "setLIVE_GIFT_DEBUG", "LIVE_GIFT_MOCK_DEBUG", "getLIVE_GIFT_MOCK_DEBUG", "setLIVE_GIFT_MOCK_DEBUG", "value", "LIVE_LICENSE", "getLIVE_LICENSE", "setLIVE_LICENSE", "LIVE_POST_TIPS", "getLIVE_POST_TIPS", "LOAD_IMAGE_ANIM", "getLOAD_IMAGE_ANIM", "Long_Video_Expect_Max_Size", "getLong_Video_Expect_Max_Size", "Long_Video_Max_Size", "getLong_Video_Max_Size", "MAKE_POST_FAILED", "getMAKE_POST_FAILED", "setMAKE_POST_FAILED", "MAKE_POST_MEDIAPROCESS_BLOCKING", "getMAKE_POST_MEDIAPROCESS_BLOCKING", "setMAKE_POST_MEDIAPROCESS_BLOCKING", "MAKE_SEND_COMMENT_FAIL", "getMAKE_SEND_COMMENT_FAIL", "setMAKE_SEND_COMMENT_FAIL", "MARK_READ_OPEN", "getMARK_READ_OPEN", "MAX_AT_COUNT", "getMAX_AT_COUNT", "MAX_COMMENT_NAME_COUNT", "getMAX_COMMENT_NAME_COUNT", "MAX_POST_RETRY_COUNT", "getMAX_POST_RETRY_COUNT", "setMAX_POST_RETRY_COUNT", "MAX_TOPIC_COUNT", "getMAX_TOPIC_COUNT", "MAX_TOPIC_LENGTH", "getMAX_TOPIC_LENGTH", "MAX_VIDEO_PLAY_DURATION", "getMAX_VIDEO_PLAY_DURATION", "MAX_VIDEO_PLAY_DURATION$delegate", "Lkotlin/Lazy;", "MEDIA_PUBLISH_TEXT_LIMIT", "getMEDIA_PUBLISH_TEXT_LIMIT", "MEGA_VIDEO_BTN_ANIM_OFFSET", "getMEGA_VIDEO_BTN_ANIM_OFFSET", "MEGA_VIDEO_BTN_ANIM_OFFSET$delegate", "MEGA_VIDEO_POST_ENTRANCE", "getMEGA_VIDEO_POST_ENTRANCE", "MEGA_VIDEO_PRELOAD_FIRST_SIZE", "getMEGA_VIDEO_PRELOAD_FIRST_SIZE", "MEGA_VIDEO_PRELOAD_SECOND_SIZE", "getMEGA_VIDEO_PRELOAD_SECOND_SIZE", "MEGA_VIDEO_TAB_SWITCH", "getMEGA_VIDEO_TAB_SWITCH", "MEGA_VIDEO_VISIT_ENTRANCE", "getMEGA_VIDEO_VISIT_ENTRANCE", "ME_FINDER_ENTRY_DEBUG", "getME_FINDER_ENTRY_DEBUG", "ME_FINDER_ENTRY_SWITCH", "getME_FINDER_ENTRY_SWITCH", "MMFINDER_MORE_LOG", "getMMFINDER_MORE_LOG", "MP_REPUDUCE_SWITCH", "getMP_REPUDUCE_SWITCH", "ONE_WEEK", "ONLY_SEARCH_CONTACT", "getONLY_SEARCH_CONTACT", "ONLY_SEE_FEED_TYPE", "getONLY_SEE_FEED_TYPE", "OPEN_FOLLOW_LIST_SEARCH_FLAG", "getOPEN_FOLLOW_LIST_SEARCH_FLAG", "OPT_FIND_BEST_VIDEO_ENABLE", "getOPT_FIND_BEST_VIDEO_ENABLE", "ORIGIN_ACCOUNT_ENABLE", "getORIGIN_ACCOUNT_ENABLE", "ORIGIN_ACCOUNT_POST_TIPS", "getORIGIN_ACCOUNT_POST_TIPS", "ORIGIN_ACCOUNT_POST_TIPS_COUNT", "getORIGIN_ACCOUNT_POST_TIPS_COUNT", "setORIGIN_ACCOUNT_POST_TIPS_COUNT", "ORIGIN_H5_URL", "getORIGIN_H5_URL", "POST_EDUCATION_DESC", "getPOST_EDUCATION_DESC", "POST_EDUCATION_TITLE", "getPOST_EDUCATION_TITLE", "POST_ENTRANCE_OUTSIDE_ENABLE", "POST_ENTRANCE_OUTSIDE_ENABLE$annotations", "getPOST_ENTRANCE_OUTSIDE_ENABLE", "POST_PROGRESS_WEIGHT_MEDIA_PROCESS", "getPOST_PROGRESS_WEIGHT_MEDIA_PROCESS", "POST_PROGRESS_WEIGHT_NETSCENE", "getPOST_PROGRESS_WEIGHT_NETSCENE", "POST_PROGRESS_WEIGHT_UPLOAD", "getPOST_PROGRESS_WEIGHT_UPLOAD", "POST_VIDEO_COVER_COMPRESS_QUALITY", "getPOST_VIDEO_COVER_COMPRESS_QUALITY", "setPOST_VIDEO_COVER_COMPRESS_QUALITY", "PRELOAD_DURATION", "getPRELOAD_DURATION", "PRIVATE_ACCOUNT_ENABLE", "getPRIVATE_ACCOUNT_ENABLE", "PRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "getPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "setPRIVATE_ACCOUNT_LIKE_TIPS_COUNT", "PROFILE_SHOW_FANS_COUNT", "getPROFILE_SHOW_FANS_COUNT", "PURE_TEXT_LIMIT", "getPURE_TEXT_LIMIT", "PhoneRemainSpace", "getPhoneRemainSpace", "REAL_NAME_LIKE", "getREAL_NAME_LIKE", "REAL_NAME_LIKE_AVATAR_RADIUS", "getREAL_NAME_LIKE_AVATAR_RADIUS", "RECYCLERVIEW_SPEED", "getRECYCLERVIEW_SPEED", "REDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "getREDDOT_NUMBER_SHOW_AT_FINDMORE_TAB", "RED_DOT_NO_TIME_LIMIT", "getRED_DOT_NO_TIME_LIMIT", "REFUSE_ALL_PRIVATE_MSG_SWITCH", "getREFUSE_ALL_PRIVATE_MSG_SWITCH", "REMUX_WITH_ABAPARAMS", "getREMUX_WITH_ABAPARAMS", "REPLY_SCENE", "getREPLY_SCENE", "setREPLY_SCENE", "REPORT_QUALITY_INFO", "getREPORT_QUALITY_INFO", "REPORT_QUALITY_INFO_CONFIG", "getREPORT_QUALITY_INFO_CONFIG", "REPORT_WHEN_SCREEN_SHOT", "getREPORT_WHEN_SCREEN_SHOT", "RESET_CAMERA_RED_DOT", "getRESET_CAMERA_RED_DOT", "setRESET_CAMERA_RED_DOT", "RESET_FIRST_POST_QUALIFICASTION", "getRESET_FIRST_POST_QUALIFICASTION", "RESET_PRIVATE_LIKE_TIPS_COUNT", "getRESET_PRIVATE_LIKE_TIPS_COUNT", "RESET_QUIT_TL_TIME_TO_ZERO", "getRESET_QUIT_TL_TIME_TO_ZERO", "SELECT_DISTRICT", "getSELECT_DISTRICT", "setSELECT_DISTRICT", "SELF_LIKE_EDU", "getSELF_LIKE_EDU", "SELF_PRIVATE_LIKE", "getSELF_PRIVATE_LIKE", "setSELF_PRIVATE_LIKE", "SELF_PRIVATE_LIKE_TIPS_COUNT", "getSELF_PRIVATE_LIKE_TIPS_COUNT", "setSELF_PRIVATE_LIKE_TIPS_COUNT", "SETTING_TO_ME_FINDER_ENTRY_SWITCH", "getSETTING_TO_ME_FINDER_ENTRY_SWITCH", "SHARE_FEED_ENTRANCE", "getSHARE_FEED_ENTRANCE", "SHARE_POST_DEBUG", "getSHARE_POST_DEBUG", "SHARE_SDK_TEST", "getSHARE_SDK_TEST", "SHARE_SDK_TEST2", "getSHARE_SDK_TEST2", "SHARE_SDK_TEST3", "getSHARE_SDK_TEST3", "SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS", "getSHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS", "SHOW_IMAGE_ENHANCEMENT_SCENE", "getSHOW_IMAGE_ENHANCEMENT_SCENE", "SHOW_POST_EDUCATION", "getSHOW_POST_EDUCATION", "SHOW_SELF_FEED_LIKE_TIPS_TIMES", "getSHOW_SELF_FEED_LIKE_TIPS_TIMES", "setSHOW_SELF_FEED_LIKE_TIPS_TIMES", "SHOW_VIDEO_PARAMS", "getSHOW_VIDEO_PARAMS", "SIGNATURE_AT_END_CHAR", "getSIGNATURE_AT_END_CHAR", "SIZEABARatio", "getSIZEABARatio", "SIZE_KB", "getSIZE_KB", "SIZE_MB", "getSIZE_MB", "SNS_TO_FINDER_SWITCH", "getSNS_TO_FINDER_SWITCH", "STATS_REPORT_CONTROL", "getSTATS_REPORT_CONTROL", "setSTATS_REPORT_CONTROL", "STREAM_CARD_LAYOUT", "getSTREAM_CARD_LAYOUT", "STREAM_CDN_CONNECTION_COUNT", "getSTREAM_CDN_CONNECTION_COUNT", "setSTREAM_CDN_CONNECTION_COUNT", "SWITCH_FEED_TITLE_STYLE", "getSWITCH_FEED_TITLE_STYLE", "SWITCH_SCENE_TIP", "getSWITCH_SCENE_TIP", "setSWITCH_SCENE_TIP", "SWITC_VIEW_PAGE_TIME", "getSWITC_VIEW_PAGE_TIME", "SYNC_TIME_INTERVAL", "getSYNC_TIME_INTERVAL", "setSYNC_TIME_INTERVAL", "TAG", "THREE_DAY", "THREE_DAY_THRESHOLD", "getTHREE_DAY_THRESHOLD", "THREE_DAY_TWO_DAY_ENABLE", "getTHREE_DAY_TWO_DAY_ENABLE", "TIMELINE_CRASH", "getTIMELINE_CRASH", "setTIMELINE_CRASH", "TIMELINE_ENABLE_SUB_PAGE", "getTIMELINE_ENABLE_SUB_PAGE", "TIMELINE_LIKE_EVENT", "getTIMELINE_LIKE_EVENT", "TIMELINE_LOADING_EXPIRED_TIME", "getTIMELINE_LOADING_EXPIRED_TIME", "TIMELINE_REFRESH_EXPIRED_TIME", "getTIMELINE_REFRESH_EXPIRED_TIME", "TIMELINE_SNAP", "getTIMELINE_SNAP", "TIMELINE_SNAP_GLOBAL", "getTIMELINE_SNAP_GLOBAL", "TIMELINE_SNAP_THRESHOLD", "getTIMELINE_SNAP_THRESHOLD", "TIMELINE_SUB_PAGE_COUNT", "getTIMELINE_SUB_PAGE_COUNT", "TOPIC_END_CHAR", "getTOPIC_END_CHAR", "TOPIC_JUMP_POI_SWITCH", "getTOPIC_JUMP_POI_SWITCH", "TOPIC_SUGGEST_SWITCH", "getTOPIC_SUGGEST_SWITCH", "TOPIC_SWITCH", "getTOPIC_SWITCH", "TRAN_TO_TRAN_265_IF_CAN", "getTRAN_TO_TRAN_265_IF_CAN", "TWO_DAY", "TWO_DAY_THRESHOLD", "getTWO_DAY_THRESHOLD", "Thumb_Max_Size", "getThumb_Max_Size", "USE_DAEMON_RECORD", "getUSE_DAEMON_RECORD", "VIDEO_3_4_RATIO", "getVIDEO_3_4_RATIO", "VIDEO_THUMB_MAX_SIZE", "getVIDEO_THUMB_MAX_SIZE", "VideoQualityDefault", "getVideoQualityDefault", "Video_Max_Size", "getVideo_Max_Size", "setVideo_Max_Size", "(J)V", "Video_Remux_Max_Count", "getVideo_Remux_Max_Count", "WITHOUT_SPEC_DEFAULT_BIT_RATE", "getWITHOUT_SPEC_DEFAULT_BIT_RATE", "WXPROFILE_ENTRY_SETTING_EDU", "getWXPROFILE_ENTRY_SETTING_EDU", "debugDumpFileTimeInterval", "getDebugDumpFileTimeInterval", "setDebugDumpFileTimeInterval", "debugFinderLive", "getDebugFinderLive", "debugFinderLiveLandscape", "getDebugFinderLiveLandscape", "debugFinderLiveListRepeat", "getDebugFinderLiveListRepeat", "setDebugFinderLiveListRepeat", "debugFinderLiveLottery", "getDebugFinderLiveLottery", "debugFinderLiveMiniProTest", "getDebugFinderLiveMiniProTest", "debugFinderLiveShoppingEnable", "getDebugFinderLiveShoppingEnable", "debugFinderLiveThreadPartyShoppingStrategy", "getDebugFinderLiveThreadPartyShoppingStrategy", "debugLandscapeVideoFit", "getDebugLandscapeVideoFit", "debugLongVideoMaxSize", "getDebugLongVideoMaxSize", "setDebugLongVideoMaxSize", "debugPreloadComment", "getDebugPreloadComment", "setDebugPreloadComment", "debugPreloadCommentRemainCount", "getDebugPreloadCommentRemainCount", "setDebugPreloadCommentRemainCount", "debugTextLimit", "getDebugTextLimit", "setDebugTextLimit", "debugTopicJumpPoi", "getDebugTopicJumpPoi", "setDebugTopicJumpPoi", "follow_no_reddot_prefetch_inner_interval", "getFollow_no_reddot_prefetch_inner_interval", "follow_no_reddot_prefetch_outter_interval", "getFollow_no_reddot_prefetch_outter_interval", "follow_reddot_prefetch_inner_interval", "getFollow_reddot_prefetch_inner_interval", "follow_reddot_prefetch_outter_interval", "getFollow_reddot_prefetch_outter_interval", "friend_no_reddot_prefetch_inner_interval", "getFriend_no_reddot_prefetch_inner_interval", "friend_no_reddot_prefetch_outter_interval", "getFriend_no_reddot_prefetch_outter_interval", "friend_reddot_prefetch_inner_interval", "getFriend_reddot_prefetch_inner_interval", "friend_reddot_prefetch_outter_interval", "getFriend_reddot_prefetch_outter_interval", "hot_no_reddot_prefetch_inner_interval", "getHot_no_reddot_prefetch_inner_interval", "hot_no_reddot_prefetch_outter_interval", "getHot_no_reddot_prefetch_outter_interval", "hot_reddot_prefetch_inner_interval", "getHot_reddot_prefetch_inner_interval", "hot_reddot_prefetch_outter_interval", "getHot_reddot_prefetch_outter_interval", "isEnableCodecReuse", "isEnableCodecReuse$delegate", "isEnableGesturePreviewImage", "isEnableGesturePreviewImage$delegate", "isEnableGesturePreviewVideo", "isEnableGesturePreviewVideo$delegate", "isEnableGestureSeekBar", "isEnablePreloadStreamRefresh", "isEnablePreloadVideoForPreloadStream", "isEnableShowNew", "isEnableStoreLastTabType", "isGetGps", "isMoreTabEnable", "isNeverEnterMultiTab", "setNeverEnterMultiTab", "isOpenMultiBitRateDownload", "isPreloadImageEnable", "isPreloadVideoEnable", "isTestStreamFetch", "localEnableShowNew", "getLocalEnableShowNew", "setLocalEnableShowNew", "longVideoAlbumPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getLongVideoAlbumPara", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mp4ParserMode", "getMp4ParserMode", "msg", "getMsg", "nearby_no_reddot_prefetch_inner_interval", "getNearby_no_reddot_prefetch_inner_interval", "nearby_no_reddot_prefetch_outter_interval", "getNearby_no_reddot_prefetch_outter_interval", "nearby_reddot_prefetch_inner_interval", "getNearby_reddot_prefetch_inner_interval", "nearby_reddot_prefetch_outter_interval", "getNearby_reddot_prefetch_outter_interval", "tab_inner_hot_prefetch_switch", "getTab_inner_hot_prefetch_switch", "timelineShowTipsDuration", "getTimelineShowTipsDuration", "useDaemonRecord", "getUseDaemonRecord", "setUseDaemonRecord", "videoAlbumMaxSelectDuration", "getVideoAlbumMaxSelectDuration", "videoAlbumPara", "getVideoAlbumPara", "videoRatioRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getVideoRatioRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "videoRecordPara", "getVideoRecordPara", "checkEnableCodecReuse", "checkEnableGesturePreviewMedia", "", "getTabName", "tabType", "defaultStr", "getVideoViewConfig", "isFinderEnterLoadEnable", "plugin-finder_release"})
public final class c
{
  private static final String msg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAA;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAB;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAE;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vAF;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAH;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAI;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAJ;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vAK;
  private static com.tencent.mm.plugin.finder.storage.config.b<Boolean> vAL;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vAM;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vAN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAP;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAQ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAW;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAa;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAb;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAc;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAd;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAe;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAf;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAh;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAi;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAj;
  private static final com.tencent.mm.plugin.finder.storage.config.c vAk;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAl;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAm;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAn;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAo;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAp;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAq;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAr;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAs;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAt;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAu;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAv;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAw;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAx;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAy;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAz;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBA;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBB;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBE;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBF;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBH;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBI;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBJ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBK;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vBL;
  private static final com.tencent.mm.plugin.finder.storage.config.c vBM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBO;
  private static final com.tencent.mm.plugin.finder.storage.config.c vBP;
  private static final com.tencent.mm.plugin.finder.storage.config.c vBQ;
  private static final com.tencent.mm.plugin.finder.storage.config.c vBR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Boolean> vBT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBU;
  private static String vBV;
  private static String vBW;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBa;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBb;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBc;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBd;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBe;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBf;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBh;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBi;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBj;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBk;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBl;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBm;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBn;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBo;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Float> vBp;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBq;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBr;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBs;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBt;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBu;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBv;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBw;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBx;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBy;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBz;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vCa;
  public static final c vCb;
  private static final com.tencent.mm.plugin.finder.storage.config.c vwA;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vwB;
  private static final int vwC = 10485760;
  private static final int vwD = 1048576;
  private static long vwE = 0L;
  private static com.tencent.mm.plugin.finder.storage.config.b<Long> vwF;
  private static int vwG = 0;
  private static final int vwH = 300;
  private static int vwI = 0;
  private static int vwJ = 0;
  private static int vwK = 0;
  private static final int vwL = 143360;
  private static int vwM = 0;
  private static int vwN = 0;
  private static int vwO = 0;
  private static int vwP = 0;
  private static int vwQ = 0;
  private static int vwR = 0;
  private static int vwS = 0;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vwT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vwU;
  private static final int vwV = 3;
  private static final int vwW = 800;
  private static int vwX = 0;
  private static final int vwY = 45;
  private static final int vwZ = 45;
  private static final int vwu = 1024;
  private static final int vwv = 1048576;
  private static final float vww = 0.38F;
  private static int vwx = 0;
  private static final com.tencent.mm.plugin.finder.storage.config.c vwy;
  private static final int vwz = 40;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxA;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxB;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxE;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxF;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vxG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxH;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxI;
  private static final com.tencent.mm.plugin.finder.storage.config.c vxJ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxK;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxL;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxN;
  private static final com.tencent.mm.plugin.finder.storage.config.c vxO;
  private static final com.tencent.mm.plugin.finder.storage.config.c vxP;
  private static final com.tencent.mm.plugin.finder.storage.config.c vxQ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxW;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxZ;
  private static final int vxa = 10;
  private static boolean vxb = false;
  private static boolean vxc = false;
  private static long vxd = 0L;
  private static final long vxe;
  private static final kotlin.f vxf;
  private static final kotlin.f vxg;
  private static final kotlin.f vxh;
  public static final kotlin.f vxi;
  private static final kotlin.f vxj;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxk;
  private static int vxl = 0;
  private static boolean vxm = false;
  private static int vxn = 0;
  private static int vxo = 0;
  private static boolean vxp = false;
  private static int vxq = 0;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxr;
  private static final long vxs = 2000L;
  private static final boolean vxt = false;
  private static final int vxu = 300000;
  private static final int vxv = 5000;
  private static final int vxw;
  private static boolean vxx;
  private static final kotlin.k.b<Double> vxy;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxz;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyA;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyB;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyC;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyD;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyE;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyF;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vyH;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vyI;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyJ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyK;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyL;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyM;
  private static List<o<Integer, String>> vyN;
  private static boolean vyO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyP;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyQ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyR;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyS;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyT;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyU;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyW;
  private static com.tencent.mm.plugin.finder.storage.config.c vyX;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vyY;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vya;
  private static com.tencent.mm.plugin.finder.storage.config.c vyb;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyc;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyd;
  private static com.tencent.mm.plugin.finder.storage.config.c vye;
  private static com.tencent.mm.plugin.finder.storage.config.c vyf;
  private static com.tencent.mm.plugin.finder.storage.config.c vyg;
  private static com.tencent.mm.plugin.finder.storage.config.c vyh;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyi;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyj;
  private static com.tencent.mm.plugin.finder.storage.config.c vyk;
  private static com.tencent.mm.plugin.finder.storage.config.c vyl;
  private static com.tencent.mm.plugin.finder.storage.config.c vym;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyn;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyo;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyp;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyq;
  private static com.tencent.mm.plugin.finder.storage.config.c vyr;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vys;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyt;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyu;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyv;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyw;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyx;
  private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyy;
  private static final com.tencent.mm.plugin.finder.storage.config.c vyz;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzA;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzB;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzC;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzD;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzE;
  private static final com.tencent.mm.plugin.finder.storage.config.c vzF;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzG;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzH;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzI;
  private static final com.tencent.mm.plugin.finder.storage.config.c vzJ;
  private static final com.tencent.mm.plugin.finder.storage.config.c vzK;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzL;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzM;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzN;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzO;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzP;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzQ;
  private static com.tencent.mm.plugin.finder.storage.config.c vzR;
  private static com.tencent.mm.plugin.finder.storage.config.c vzS;
  private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vzT;
  private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vzU;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzV;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzW;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzX;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzY;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzZ;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vza;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzb;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzc;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzd;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vze;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzf;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzg;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzh;
  private static final com.tencent.mm.plugin.finder.storage.config.b<String> vzi;
  private static final com.tencent.mm.plugin.finder.storage.config.c vzj;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzk;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzl;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzm;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzn;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzo;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzp;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzq;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzr;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzs;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzt;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzu;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzv;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzw;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzx;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzy;
  private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzz;
  
  static
  {
    AppMethodBeat.i(166903);
    vCb = new c();
    vwu = 1024;
    vwv = 1048576;
    vww = 0.38F;
    vwx = 5;
    vwy = new com.tencent.mm.plugin.finder.storage.config.c("显示视频编码配置", (kotlin.g.a.b)ay.vDc);
    vwz = 40;
    vwA = new com.tencent.mm.plugin.finder.storage.config.c("测试游戏中心h5调直播", (kotlin.g.a.b)c.an.vCR);
    vwB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "测试游戏中心h5调直播调试设置").b("GAME_CENTER_JSAPI_DEBUG_CONFIG", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })), kotlin.a.j.listOf(new String[] { "默认(0)", "mock主播没开播", "mock直播已结束" }));
    vwC = vwv * 10;
    vwD = vwv * 1;
    vwE = 28L * vwv;
    vwF = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(0L, "长视频文件上限").b("debugLongVideoMaxSize", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Long[] { Long.valueOf(0L), Long.valueOf(20L * vwv), Long.valueOf(800L * vwv) })), kotlin.a.j.listOf(new String[] { "默认(0)", "20MB", "800MB" }));
    vwG = vwv * 28;
    vwH = 300;
    vwI = 1280;
    vwJ = 1080;
    vwK = 90;
    vwL = vwu * 140;
    vwM = 1080;
    vwN = 1080;
    vwO = 70;
    vwP = 1080;
    vwQ = 1080;
    vwR = 70;
    vwS = 50;
    vwT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "不再接收私信入口").avD("FinderPrivateRefuseAllMsgSwitch").b("REFUSE_ALL_PRIVATE_MSG_SWITCH", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "默认(0)", "打开入口(1)", "关闭入口(0)" }));
    vwU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表模拟失败").b("FINDER_POST_FAILED_IN_STAGE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), kotlin.a.j.listOf(new String[] { "关闭(0)", "裁剪失败", "上传失败", "cgi失败" }));
    vwV = 3;
    vwW = 800;
    vwX = 300000;
    vwY = 45;
    vwZ = 45;
    vxa = 10;
    vxd = -1L;
    vxe = Environment.getExternalStorageDirectory().getFreeSpace() / 1024L / 1024L / 1024L;
    msg = "\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + dru() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + drr() + " 后台处理\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量）\n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + drs() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + b.a.sao + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ";
    vxf = kotlin.g.ah((kotlin.g.a.a)c.bb.vDf);
    vxg = kotlin.g.ah((kotlin.g.a.a)bc.vDg);
    vxh = kotlin.g.ah((kotlin.g.a.a)bd.vDh);
    vxi = kotlin.g.ah((kotlin.g.a.a)c.aq.vCU);
    vxj = kotlin.g.ah((kotlin.g.a.a)c.ap.vCT);
    vxk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播拉取评论时间间隔").d(b.a.slD);
    vxl = 1;
    vxn = 5;
    vxo = 2;
    vxp = true;
    vxr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300000, "tab流自动刷新缓存时间").d(b.a.sav).b("AUTO_REEFRESH_CACHE_INTERVAL", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(300000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) }), kotlin.a.j.listOf(new String[] { "默认(5min)", "10s", "30s", "1min" }));
    vxs = 2000L;
    vxu = 300000;
    vxv = 5000;
    vxw = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skN, 0);
    vxx = true;
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.f.GHk;
    if (com.tencent.mm.plugin.vlog.ui.plugin.f.fDl())
    {
      localObject = kotlin.k.j.M(0.75D);
      vxy = (kotlin.k.b)localObject;
      vxz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "二级评论是否展开").avD("FinderCommentAutoExpandSubcommentList").b("COMMENT_EXPAND_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "是", "否" }));
      vxA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞").d(b.a.saA).b("REAL_NAME_LIKE_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "实名点赞", "非实名点赞" }));
      vxB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞头像").d(b.a.saC).b("REAL_NAME_LIKE_AVATAR_RADIUS_CONTROL", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "圆头像", "方头像" }));
      vxC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "评论全屏方案").d(b.a.saz).b("COMMENT_STYLE_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "全屏", "半屏" }));
      vxD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "圈外分享模式(仅预览)").d(b.a.saz).b("USERINFO_FINDER_FORWARD_DEBUG_TYPE_INT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "允许nickname", "过滤nickname" }));
      vxE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "附近tab使用瀑布流/卡片流开关").d(b.a.say).b("LBS_UI_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "瀑布流", "卡片流" }));
      vxF = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(20, "关注/点赞折叠超过x条后折叠").b("FOLLOW_LIKE_FOLD_MORE_THAN_X", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(20), Integer.valueOf(3) }), kotlin.a.j.listOf(new String[] { "20", "3" }));
      vxG = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "开启视频预加载预览View", "USERINFO_FINDER_PRELOAD_VIEW_BOOLEAN_SYNC");
      vxH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否开启手势切Tab").b("USERINFO_FINDER_GESTURE_TAB_INT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "默认(0)", "关闭(-1)", "打开(1)" }));
      vxI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "切换单Tab").d(b.a.sax).b("FINDER_TAB_STYLE_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "切换多tab", "切换单tab" }));
      vxJ = new com.tencent.mm.plugin.finder.storage.config.c("重置最后退出TL时间为0", (kotlin.g.a.b)c.av.vCZ);
      vxK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "评论字数限制10").avD("FinderCommentTextLimit").b("COMMENT_TEXT_LIMIT_CONFIG", kotlin.a.j.listOf(Integer.valueOf(10)), kotlin.a.j.listOf("评论字数限制10"));
      vxL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "Media字数限制15").avD("FinderMediaPublishTextLimit").b("MEDIA_TEXT_LIMIT_CONFIG", kotlin.a.j.listOf(Integer.valueOf(15)), kotlin.a.j.listOf("Media字数限制15"));
      vxM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "纯文本字数限制15").avD("FinderPureTextPublishTextLimit").b("PURE_TEXT_LIMIT_CONFIG", kotlin.a.j.listOf(Integer.valueOf(20)), kotlin.a.j.listOf("纯文本字数限制15"));
      vxN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "最大话题数改为3个").avD("FinderMaxTopicCount").b("MAX_TOPIC_CONFIG", kotlin.a.j.listOf(Integer.valueOf(3)), kotlin.a.j.listOf("最大话题数改为3个"));
      vxO = new com.tencent.mm.plugin.finder.storage.config.c("假菊花Toast", (kotlin.g.a.b)c.u.vCy);
      vxP = new com.tencent.mm.plugin.finder.storage.config.c("游戏sdk分享测试", (kotlin.g.a.b)aw.vDa);
      vxQ = new com.tencent.mm.plugin.finder.storage.config.c("秒剪sdk分享测试", (kotlin.g.a.b)ax.vDb);
      vxR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表跳转第三方app").b("SHARE_SDK_TEST3", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "默认", "秒剪测试" }));
      vxS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "sdk分享特殊情况").b("SHARE_POST_DEBUG", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), kotlin.a.j.listOf(new String[] { "默认", "无视频号浏览权限", "无视频号发表帐号权限", "发现页关闭了视频号" }));
      vxT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "我-视频入口控制").b("ME_FINDER_ENTRY_DEBUG", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), kotlin.a.j.listOf(new String[] { "默认", "青少年模式", "无视频号发表帐号权限", "命中安全打击/封禁" }));
      vxU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "A-我-视频入口开关").d(b.a.sbH).b("ME_FINDER_ENTRY_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vxV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "B-profile设置展示视频号，是否影响我-视频号").d(b.a.sbI).b("SETTING_TO_ME_FINDER_ENTRY_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "不影响", "影响" }));
      vxW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "C-设置页出“展示我的视频号”开关").d(b.a.sbJ).b("FINDER_SETTING_WXPROFILE_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vxX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "D-创建帐号-默认使用微信昵称").d(b.a.sbK).b("FINDER_CREATE_WXNAME_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vxY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(15, "话题最大长度改为10").avD("FinderTopicTextLimit").b("MAX_TOPIC_LENGTH_CONFIG", kotlin.a.j.listOf(Integer.valueOf(10)), kotlin.a.j.listOf("话题最大长度改为10"));
      vxZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "话题推荐开关").avD("FinderSuggestTagViewShow").b("TOPIC_RECOMMEND_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vya = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "打开切换身份评论").d(b.a.sbG).b("CAN_SWITCH_SCENE", kotlin.a.j.listOf(Integer.valueOf(1)), kotlin.a.j.listOf("打开"));
      vyb = new com.tencent.mm.plugin.finder.storage.config.c("重置切换身份提示", (kotlin.g.a.b)c.q.vCv);
      vyc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "最大at数改为3个").avD("FinderMaxMentionSbCount").b("MAX_AT_COUNT_CONFIG", kotlin.a.j.listOf(Integer.valueOf(3)), kotlin.a.j.listOf("最大at数改为3个"));
      vyd = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "发表feed/评论点赞固定失败");
      vye = new com.tencent.mm.plugin.finder.storage.config.c("评论点赞重试间隔改为1s", (kotlin.g.a.b)r.vCw);
      vyf = new com.tencent.mm.plugin.finder.storage.config.c("清除keybuf/账号数据", (kotlin.g.a.b)e.vCj);
      vyg = new com.tencent.mm.plugin.finder.storage.config.c("清除图片视频所有缓存", (kotlin.g.a.b)h.vCm);
      vyh = new com.tencent.mm.plugin.finder.storage.config.c("清空keybuf", (kotlin.g.a.b)d.vCi);
      vyi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(80, "RecyclerView滑动速度").b("RECYCLERVIEW_SPEED", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(80), Integer.valueOf(50), Integer.valueOf(60), Integer.valueOf(70), Integer.valueOf(80), Integer.valueOf(90), Integer.valueOf(100), Integer.valueOf(130) }), kotlin.a.j.listOf(new String[] { "默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍" }));
      vyj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300, "loadmore假菊花时长").avD("FinderFakeLoadingDurationMS").b("TIMELINE_LOADING_EXPIRED_TIME", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(100), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(500), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(3000) }), kotlin.a.j.listOf(new String[] { "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      vyk = new com.tencent.mm.plugin.finder.storage.config.c("把自己改成非白名单用户", (kotlin.g.a.b)a.vCc);
      vyl = new com.tencent.mm.plugin.finder.storage.config.c("把所有feed改为仅自己可见", (kotlin.g.a.b)v.vCz);
      vym = new com.tencent.mm.plugin.finder.storage.config.c("双击与展开教育/收藏红点重置", (kotlin.g.a.b)s.vCx);
      vyn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "红点不受配置时间限制").b("USERINFO_FINDER_TEST_RED_DOT_FACTOR_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(1000000000) }), kotlin.a.j.listOf(new String[] { "默认", "无限制" }));
      vyo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "后台合成").b("USERINFO_FINDER_VIDEO_REMUX_BACKGROUND_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "X实验配置", "否", "是" }));
      if ((!BuildInfo.IS_FLAVOR_PURPLE) && (!BuildInfo.DEBUG)) {
        break label16309;
      }
      i = 1;
      label3194:
      vyp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(i, "特效").b("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" }));
      vyq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "允许3:4视频比例").b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "开", "关" }));
      vyr = new com.tencent.mm.plugin.finder.storage.config.c("发表相机红点重置", (kotlin.g.a.b)as.vCW);
      vys = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "只看某个feed").b("USERINFO_FINDER_CARE_FEED_TYPE_INT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8) }), kotlin.a.j.listOf(new String[] { "DEFAULT", "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA" }));
      vyt = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "进入视频号Crash");
      vyu = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "输出视频号DEBUG日志", "USERINFO_FINDER_DEBUG_LOG_BOOLEAN_SYNC");
      vyv = new com.tencent.mm.plugin.finder.storage.config.c("清理首页文件缓存", (kotlin.g.a.b)y.vCC);
      vyw = new com.tencent.mm.plugin.finder.storage.config.c("清理发表队列", (kotlin.g.a.b)z.vCD);
      vyx = new com.tencent.mm.plugin.finder.storage.config.c("查看Finder缓存大小", (kotlin.g.a.b)c.b.vCd);
      vyy = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "资源清理调试模式");
      vyz = new com.tencent.mm.plugin.finder.storage.config.c("复制finder配置到剪贴板", (kotlin.g.a.b)j.vCo);
      vyA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "个人中心用户状态").b("FINDER_SELF_STATE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(-1) })), (List)new ArrayList((Collection)kotlin.a.j.listOf(new String[] { "无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "全网禁言", "reset" })));
      vyB = new com.tencent.mm.plugin.finder.storage.config.c("重置首次获得发表权限标志", (kotlin.g.a.b)c.at.vCX);
      vyC = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(true, "自动触发正例反馈");
      vyD = new com.tencent.mm.plugin.finder.storage.config.c("清空通知lastBuffer", (kotlin.g.a.b)f.vCk);
      vyE = new com.tencent.mm.plugin.finder.storage.config.c("清理New红点配置", (kotlin.g.a.b)c.g.vCl);
      vyF = new com.tencent.mm.plugin.finder.storage.config.c("清理更多相似动态状态", (kotlin.g.a.b)c.i.vCn);
      vyG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "打开评论抽屉是否调整feed位置").b("IS_ADJUST_FEED_WHEN_OPEN_DRAWER", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "默认模式(关闭)", "自动调整模式" }));
      vyH = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(100L, "refresh假菊花时长").d(b.a.rRH).b("TIMELINE_REFRESH_EXPIRED_TIME", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Long[] { Long.valueOf(500L), Long.valueOf(100L), Long.valueOf(200L), Long.valueOf(400L), Long.valueOf(500L), Long.valueOf(600L), Long.valueOf(700L), Long.valueOf(800L), Long.valueOf(1000L), Long.valueOf(3000L) })), kotlin.a.j.listOf(new String[] { "默认(500)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000" }));
      vyI = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(1200000L, "预加载debug轮询时长").d(b.a.rRG).b("PRELOAD_DURATION", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Long[] { Long.valueOf(1200000L), Long.valueOf(5000L), Long.valueOf(10000L), Long.valueOf(60000L) })), kotlin.a.j.listOf(new String[] { "默认(20min)", "5s", "10s", "1min" }));
      vyJ = new com.tencent.mm.plugin.finder.storage.config.c("生效一次，收到红点会去掉（朋友/关注）发现页红点", (kotlin.g.a.b)c.vCh);
      vyK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频模板").b("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" }));
      vyL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "点赞事件UI").b("TIMELINE_LIKE_EVENT_CONFIG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "卡片模式", "m+n模式" }));
      vyM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "FIDNER_RED_DOT_STYLE").b("FIDNER_RED_DOT_STYLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(7), Integer.valueOf(6), Integer.valueOf(-1) }), kotlin.a.j.listOf(new String[] { "4(ICON)+liked", "7(SQUARE_ICON)+liked", "11(ICON_WITH_RED_DOT)+liked", "12(SQUARE_ICON_WITH_RED_DOT)+liked", "liked+13(RIGHT_ICON_WITH_RED_DOT)", "liked+14(RIGHT_SQUARE_ICON_WITH_RED_DOT)", "4(ICON)", "7(SQUARE_ICON)", "default" }));
      vyN = kotlin.a.j.listOf(new o[] { new o(Integer.valueOf(4), "liked"), new o(Integer.valueOf(7), "liked"), new o(Integer.valueOf(11), "liked"), new o(Integer.valueOf(12), "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new o(Integer.valueOf(13), "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new o(Integer.valueOf(14), "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new o(Integer.valueOf(4), ""), new o(Integer.valueOf(7), ""), new o(Integer.valueOf(-1), "") });
      vyO = true;
      vyP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "MARK_READ_OPEN").avD("FinderMarkReadOpenControl").b("FinderMarkReadOpenControl", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "默认(1)", "打开入口(1)", "关闭入口(0)" }));
      vyQ = new t("是否打开私信入口").d(b.a.saF).b("ENABLE_FINDER_MESSAGE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "默认", "打开", "关闭" }));
      vyR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "截屏上报").d(b.a.scg).b("FINDER_REPORT_WHEN_SCREEN_SHOT", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vyS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否在朋友tab制造个假跳转热门数据").b("FAKE_CARD_JUMP_HOT_TAB_DATA", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      if (!BuildInfo.IS_FLAVOR_PURPLE) {
        break label16314;
      }
    }
    label16309:
    label16314:
    for (int i = 1;; i = 0)
    {
      vyT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(i, "加载图片渐现").b("LOAD_IMAGE_ANIM", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vyU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "切换ViewPage速度").b("SWITC_VIEW_PAGE_TIME", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(200), Integer.valueOf(400), Integer.valueOf(600), Integer.valueOf(700), Integer.valueOf(800), Integer.valueOf(1000), Integer.valueOf(1200), Integer.valueOf(1500) })), kotlin.a.j.listOf(new String[] { "默认", "200", "400", "600", "700", "800", "1000", "1200", "1500" }));
      vyV = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "是否在作者视角动态展示假数据");
      vyW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "私密帐号").d(b.a.scL).b("PRIVATE_ACCOUNT_ENABLE_DEBUG", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vyX = new com.tencent.mm.plugin.finder.storage.config.c("重置私密feed点赞提示次数", (kotlin.g.a.b)c.p.vCu);
      vyY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "支持匿名赞").d(b.a.sdT).b("USERINFO_SELF_PRIVATE_LIKE_INT_SYNC", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "默认", "支持", "不支持" }));
      vyZ = new com.tencent.mm.plugin.finder.storage.config.c("重置私密feed点赞和匿名赞提示次数", (kotlin.g.a.b)c.au.vCY);
      vza = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏动画开关").b("IS_SHOW_FAV_ANIM_UNLIMITED", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频质量分上报").d(b.a.scM).b("REPORT_QUALITY_INFO", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "选择 FeedHeadBar 样式").d(b.a.sch).b("SWITCH_FEED_TITLE_STYLE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2) })), kotlin.a.j.listOf(new String[] { "默认(0)", "沉浸式(1)", "非沉浸式(0)", "4:3 沉浸式(2)" }));
      vzd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表支持4:3").d(b.a.smW).b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "默认", "支持", "不支持" }));
      vze = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "TL导航栏icon样式").b("POST_ENTRANCE_OUTSIDE_ENABLE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) })), kotlin.a.j.listOf(new String[] { "[A]默认", "[B]发表右上角+热门加附近", "[C]搜索右上角+热门加附近", "[D]热门加附近" }));
      vzf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "切换朋友圈跳视频号入口类型", (kotlin.g.a.m)c.az.vDd).b("SNS_TO_FINDER_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "跳转方式1", "跳转方式2" }));
      vzg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表上传block").b("DEBUG_POST_UPLOAD_BLOCK", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(20) })), kotlin.a.j.listOf(new String[] { "不block", "block 20秒" }));
      vzh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "红点数据库插入数据count", (kotlin.g.a.m)l.vCq).b("DEBUG_FINDER_INSERT_RED_DOT_DB", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(30), Integer.valueOf(100), Integer.valueOf(500), Integer.valueOf(1000), Integer.valueOf(5000) })), kotlin.a.j.listOf(new String[] { "30", "100", "500", "1000", "5000" }));
      vzi = new com.tencent.mm.plugin.finder.storage.config.c("清除全屏tab红点标记", (kotlin.g.a.b)k.vCp).avE("T5");
      vzj = new com.tencent.mm.plugin.finder.storage.config.c("红点数据库插入数据标记位", (kotlin.g.a.b)c.m.vCr);
      vzk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏出相似流").b("DEBUG_FAV_SIMILAR", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "使用后台配置", "支持" }));
      vzl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_o_interval").b("follow_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_o_interval").b("friend_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_o_interval").b("hot_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_o_interval").b("nearby_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_o_interval").b("follow_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_o_interval").b("friend_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_o_interval").b("hot_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_o_interval").b("nearby_no_reddot_prefetch_outter_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_i_interval").b("follow_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_i_interval").b("friend_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_i_interval").b("hot_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_i_interval").b("nearby_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_i_interval").b("follow_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_i_interval").b("friend_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_i_interval").b("hot_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_i_interval").b("nearby_no_reddot_prefetch_inner_interval", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(10000), Integer.valueOf(10000), Integer.valueOf(30000), Integer.valueOf(60000) })), kotlin.a.j.listOf(new String[] { "默认", "0s", "10s", "20s", "30s", "1min" }));
      vzB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "tab_inner_hot_prefetch_switch").b("tab_inner_hot_prefetch_switch", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "默认", "true", "false" }));
      vzC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否本地调整点赞头像顺序").d(b.a.saG).b("ADJUST_AVATAR_ORDER_LIKE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "引导用户点赞自己的视频").d(b.a.sng).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "支持" }));
      vzE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "引导用户点赞后评论").d(b.a.scQ).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "支持" }));
      vzF = new com.tencent.mm.plugin.finder.storage.config.c("重置profile展示微信资料页提示", (kotlin.g.a.b)c.ba.vDe);
      vzG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "专栏布局样式大小").b("STREAM_CARD_LAYOUT", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) })), kotlin.a.j.listOf(new String[] { "不支持", "大大大 ", " 小小小 " }));
      vzH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "feed播放一段时间后，出评论输入框").d(b.a.scR).b("FEED_COMMENT_EDU", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "原创帐号开关").b("ORIGIN_ACCOUNT_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzJ = new com.tencent.mm.plugin.finder.storage.config.c("原创帐号发表提示和红点重置", (kotlin.g.a.b)c.ar.vCV);
      vzK = new com.tencent.mm.plugin.finder.storage.config.c("直播发起红点重置", (kotlin.g.a.b)c.ao.vCS);
      vzL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "朋友的外显评论是否显示头像").d(b.a.scS).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "强制所有feed都为新闻类").b("FEED_ALL_FORCE_NEWS", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "首次打开热门预加载请求随机数").d(b.a.scT).b("FIRST_HOT_TAB_PRELOAD_RANDOM", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(10) })), kotlin.a.j.listOf(new String[] { "重置first", "关闭", "50%", "20%", "10%" })).H((kotlin.g.a.b)c.am.vCQ);
      vzO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "3天2天总开关").d(b.a.scU).b("THREE_DAY_TWO_DAY_ENABLE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vzP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(259200000, "3天超时阈值").d(b.a.scV).b("THREE_DAY_THRESHOLD", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(259200000), Integer.valueOf(30000), Integer.valueOf(180000) })), kotlin.a.j.listOf(new String[] { "3天", "30 秒", "3 分钟" }));
      vzQ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(172800000, "2天不出阈值").d(b.a.scW).b("TWO_DAY_THRESHOLD", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(172800000), Integer.valueOf(20000), Integer.valueOf(120000) })), kotlin.a.j.listOf(new String[] { "2天", "20 秒", "2 分钟" })).d(b.a.scQ).b("DEBUG_SELF_LIKE_EDU", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "支持" }));
      vzR = new com.tencent.mm.plugin.finder.storage.config.c("重置直播勾选协议", (kotlin.g.a.b)c.n.vCs);
      vzS = new com.tencent.mm.plugin.finder.storage.config.c("重置实名认证缓存", (kotlin.g.a.b)c.o.vCt);
      vzT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播推荐列表是否允许重复").b("debugFinderLiveListRepeat", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "允许", "不允许" }));
      vzU = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "打开美颜实时调节器", "FINDER_LIVE_BEAUTY_DEBUG");
      vzV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号发布直播").d(b.a.sba).b("debugFinderLive", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vzW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播购物").d(b.a.sbb).b("debugFinderLiveShoppingEnable", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vzX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播第三方购物").d(b.a.sbd).b("debugFinderLiveThreadPartyShoppingStrategy", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "中间页（实验状态）", "详情页（非实验状态）" }));
      vzY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "直播购物讲解气泡位置刷新频率").d(b.a.sbf);
      vzZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "购物小程序版本").b("FINDER_LIVE_USING_DEBUG_MINIPRO", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "正式版", "测试版" }));
      vAa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "横向直播").d(b.a.sbc).b("debugFinderLiveLandscape", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "横屏视频自动适配").d(b.a.sbo).b("debugLandscapeVideoFit", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播抽奖入口").d(b.a.sbp).b("debugFinderLiveLottery", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(60, "抽奖气泡展示时长(秒)").d(b.a.sbq).b("FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(5), Integer.valueOf(30), Integer.valueOf(100) }), kotlin.a.j.listOf(new String[] { "60秒", "5秒", "30秒", "100秒" })).avE("T32");
      vAe = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(60, "抽奖中气泡展示时长(秒)").d(b.a.sbr).b("FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(5), Integer.valueOf(30), Integer.valueOf(200) }), kotlin.a.j.listOf(new String[] { "60秒", "5秒", "30秒", "200秒" })).avE("T32");
      vAf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "抽奖是否使用本地过滤策略(默认使用)").d(b.a.sbt);
      vAg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "抽奖本地缓存的已看过抽奖个数").d(b.a.sbu);
      vAh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(5, "视频号直播feed缓存时间").d(b.a.sbv);
      vAi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "朋友圈直播一键清除").d(b.a.rRJ).b("FINDER_SNS_CLEAR_BTN", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "X实验设置浮评初始默认开关", (kotlin.g.a.m)c.w.vCA).d(b.a.sbX).b("FINDER_BULLET_SUBTITLE_EXPT_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "无", "默认关闭", "默认打开" })).avE("T32");
      vAk = new com.tencent.mm.plugin.finder.storage.config.c("清除记录的浮评X实验默认配置", (kotlin.g.a.b)c.x.vCB);
      vAl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "音乐跟拍入口").d(b.a.sbw).b("FINDER_FOLLOW_PAT_ENTRANCE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持分享专辑").d(b.a.scX).b("IS_ENABLE_SHARE_ALBUM", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vAn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持分享专辑预加载").d(b.a.scY).b("IS_ENABLE_SHARE_ALBUM_PRELOAD", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vAo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否开启智能滤镜").b("USERINFO_FINDER_ENABLE_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "开", "关" }));
      vAp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "展示智能滤镜场景").b("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "开", "关" }));
      vAq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "展示智能滤镜人脸关键点").b("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "开", "关" }));
      vAr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "长视频发表入口").d(b.a.scZ).b("MEGA_VIDEO_POST_ENTRANCE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启hevc编码").b("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "关", "vcode", "系统硬编" }));
      vAt = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(0L, "长视频第一阶段预加载size").d(b.a.sda).b("MEGA_VIDEO_PRELOAD_FIRST_SIZE", kotlin.a.j.listOf(new Long[] { Long.valueOf(2097152L), Long.valueOf(2048L) }), kotlin.a.j.listOf(new String[] { "2M", "200K" }));
      vAu = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(0L, "长视频第二阶段预加载size").d(b.a.sdb).b("MEGA_VIDEO_PRELOAD_SECOND_SIZE", kotlin.a.j.listOf(new Long[] { Long.valueOf(2097152L), Long.valueOf(2048L) }), kotlin.a.j.listOf(new String[] { "2M", "200K" }));
      vAv = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(1L, "无spec时，视频码率默认选择").d(b.a.sdc).b("WITHOUT_SPEC_DEFAULT_BIT_RATE", kotlin.a.j.listOf(new Long[] { Long.valueOf(0L), Long.valueOf(1L) }), kotlin.a.j.listOf(new String[] { "xVO", "xV2/xV1" }));
      vAw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "长视频浏览入口").d(b.a.sdd).b("MEGA_VIDEO_POST_ENTRANCE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "长视频点赞、收藏和profile tab开关").b("MEGA_VIDEO_TAB_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vAy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "分享流跳转视频号默认Tab").d(b.a.sdq).b("debugShareJumpHomeDefaultTab", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "关注", "朋友", "推荐" }));
      vAz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "分享流视频播放完后是否弹出下拉引导").d(b.a.sds).b("debugSharePopupPullTipsLayout", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "推荐 TL snap 滑动体验").b("TIMELINE_SNAP", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "全局 TL snap 滑动体验").d(b.a.sdh).b("TIMELINE_SNAP_GLOBAL", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(600, "snap 敏感度").b("TIMELINE_SNAP_THRESHOLD", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(300), Integer.valueOf(600), Integer.valueOf(1200), Integer.valueOf(2400), Integer.valueOf(4800), Integer.valueOf(6000) }), kotlin.a.j.listOf(new String[] { "1", "300", "600", "1200", "2400", "4800", "6000" }));
      vAD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "优化找最合适规格播放开关").d(b.a.sdi).b("OPT_FIND_BEST_VIDEO_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "修复reinit selector").d(b.a.sdj).b("FIX_REINIT_SELECTOR_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAF = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "直播分享打开单流", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE");
      vAG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "尝试转h265").d(b.a.sdk).b("TRT_TO_TRAN_265_IF_CAN", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持解码器复用").d(b.a.rOF).b("ENABLE_MEDIA_CODEC_REUSE", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vAI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否打开视频预加载").b("ENABLE_VIDEO_PRELOAD", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" }));
      vAJ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否打开帐号详情入口").d(b.a.sdl).b("IF_SHOW_ACCOUTN_DETAIL", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播礼物连击生成相同comboId").b("FINDER_LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAL = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "直播礼物打赏mock工具是否打开").b("FINDER_LIVE_GIFT_MOCK_DEBUG", kotlin.a.j.listOf(new Boolean[] { Boolean.TRUE, Boolean.FALSE }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播礼物debug").b("FINDER_LIVE_GIFT_DEBUG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vAN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播礼物开关").d(b.a.snM).b("FINDER_LIVE_GIFT_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), kotlin.a.j.listOf(new String[] { "打开", "关闭" })).avE("T32");
      vAO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "抽奖时长上限(秒)").d(b.a.snN).b("FINDER_LIVE_GIFT_ANIM_STAY_DURATION", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(30) }), kotlin.a.j.listOf(new String[] { "3秒", "1秒", "10秒", "30秒" })).avE("T32");
      vAP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播送礼通知昵称长度").d(b.a.snO);
      vAQ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10000, "视频号直播送礼队列最大缓存长度").d(b.a.snP);
      vAR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "视频号直播送礼队列聚合id延迟消失时长/秒").d(b.a.snQ);
      vAS = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(9000L, "视频号直播送礼大礼物默认播放时长").d(b.a.snR);
      vAT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播打赏模拟上榜").d(b.a.snV).b("FINDER_LIVE_MSG_BADGE_DEBUG", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(9) }), kotlin.a.j.listOf(new String[] { "不上榜", "榜1", "榜2", "榜3", "榜9" }));
      vAU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "观众打赏榜单自动刷新间隔/秒").d(b.a.snW).b("FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(-1) }), kotlin.a.j.listOf(new String[] { "0秒", "1秒", "2秒", "3秒", "5秒", "10秒", "不自动刷新" }));
      vAV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "热度值是否在榜单展示时冻住").d(b.a.snX).b("FINDER_LIVE_COMMON_INFO_FROZEN", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "是", "否" }));
      vAW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播打赏是否本地假插").d(b.a.snY).b("FINDER_LIVE_MSG_SEND_LOCAL_GIFT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "是", "否" }));
      vAX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "评论列表是否保留自己不超过一半上限的评论数据").d(b.a.snZ).b("FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "是", "否" }));
      localObject = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "视频号直播观众模式");
      e.a locala = e.a.hxc;
      i = e.a.aCe();
      locala = e.a.hxc;
      vAY = ((com.tencent.mm.plugin.finder.storage.config.item.integer.a)localObject).b("FINDER_LIVE_VISITOR_MODE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(e.a.aCf()) }), kotlin.a.j.listOf(new String[] { "跟随后台", "TRTC", "CDN" })).d(b.a.sdn);
      vAZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "直播评论长度限制").d(b.a.sdm).b("FINDER_LIVE_COMMENT_SIZE_LIMIT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(10) }), kotlin.a.j.listOf(new String[] { "限制5条", "限制10条" }));
      vBa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否使用本地时间创建直播预告").b("FINDER_LIVE_NOTICE_TIME", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "使用服务器时间", "使用本地时间" }));
      vBb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否展示开播分组入口").d(b.a.sdo).b("FINDER_LIVE_VISIBLITY_ENTRANCE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "是", "否" }));
      vBc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开播分组分组是否插入假数据").b("FINDER_LIVE_VISIBLITY_DEBUG_DATA", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "否", "是" }));
      vBd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表强制触发软编压缩").b("FINDER_POST_FORCE_ZIP", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "默认", "开" }));
      vBe = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否允许软编回退").b("USERINFO_FINDER_ENABLE_SOFT_ENCODE_FALLBACK_INT_SYNC", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" }));
      vBf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持横屏预览").d(b.a.snI).b("FINDER_ENABLE_HORIZONTAL_PREVIEWING", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启完播跟赞").d(b.a.snH).b("FINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启全局全屏体验").d(b.a.snG).b("FINDER_GLOBAL_FULLSCREEN_ENJOY", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "开启推荐流全屏体验").d(b.a.snF).b("FINDER_HOT_FULLSCREEN_ENJOY", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启关注流全屏体验").d(b.a.snB).b("FINDER_FOLLOW_FULLSCREEN_ENJOY", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启朋友流全屏体验").d(b.a.snC).b("FINDER_FRIEND_FULLSCREEN_ENJOY", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "开启其他场景全屏体验").d(b.a.snD).b("FINDER_OTHER_FULLSCREEN_ENJOY", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "开启分享流全屏体验").d(b.a.snE).b("FINDER_SHARE_FULLSCREEN_ENJOY", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "关闭发表半屏预览").d(b.a.snJ).b("FINDER_POST_DISABLE_HALF_SCREEN", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "分享流完播自动下滚").d(b.a.RbP).b("FINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关", "开" })).avE("T5");
      vBp = new com.tencent.mm.plugin.finder.storage.config.item.c("全屏视频撑满比例（高/宽）").d(b.a.snK).b("FINDER_FULLSCREEN_INSIDE_RADIO", kotlin.a.j.listOf(new Float[] { Float.valueOf(1.773F), Float.valueOf(1.333F) }), kotlin.a.j.listOf(new String[] { "16:9", "4:3" })).avE("T5");
      vBq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频号直播前置摄像头渲染镜像开关").d(b.a.snz).avE("T32");
      vBr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否过滤视频号内的热门红点").b("FINDER_FILTER_HOT_REDDOT_IN_FINDER", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) })), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).d(b.a.snL);
      vBs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "创作者服务中心URL").b("FINDER_POSTER_SERVICE_URL", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "使用后台下发url", "TEST", "REAL" })).avE("T32");
      vBt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播是否打开拍一拍").d(b.a.sdt).b("FINDER_LIVE_TICKLE_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播是否打开回复").d(b.a.sdu).b("FINDER_LIVE_REPLY_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播美颜开关").d(b.a.sdv).b("FINDER_LIVE_BEAUTY_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播滤镜开关").d(b.a.sdw).b("FINDER_LIVE_FILTER_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播连麦是否打开").d(b.a.sdx).b("FINDER_LIVE_LINK_MIC_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "活动分享使用的业务分享type").b("FINDER_ACTIVITY_SHARE_BUSINESS_TYPE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(100000001) }), kotlin.a.j.listOf(new String[] { "默认值", "100000001" }));
      vBz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "打开附近的直播和人").d(b.a.sdy).b("FINDER_NEARBY_LIVE_FRIENDS", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "打开附近的直播和人-强制").d(b.a.sdz).b("FINDER_NEARBY_LIVE_FRIENDS", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播Feed下拉出相似流").d(b.a.sdA).b("FINDER_NEARBY_LIVE_PULL_SIMILAR", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32");
      vBC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "热门搜索推荐").d(b.a.scN).b("FINDER_SEARCH_HOT", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T42");
      vBD = new com.tencent.mm.plugin.finder.storage.config.c("清除全屏引导标志", (kotlin.g.a.b)c.ab.vCF).avE("T5");
      vBE = new com.tencent.mm.plugin.finder.storage.config.c("清除发表后引导点赞标志", (kotlin.g.a.b)c.al.vCP).avE("T5");
      vBF = new com.tencent.mm.plugin.finder.storage.config.c("清除私密赞标志", (kotlin.g.a.b)c.aa.vCE).avE("T5");
      vBG = new com.tencent.mm.plugin.finder.storage.config.c("清除全屏点赞引导标志", (kotlin.g.a.b)c.ac.vCG).avE("T5");
      vBH = new com.tencent.mm.plugin.finder.storage.config.c("清除直播广场的滑动引导", (kotlin.g.a.b)af.vCJ).avE("T5");
      vBI = new com.tencent.mm.plugin.finder.storage.config.c("清除附近的直播和人的NEW红点", (kotlin.g.a.b)c.ae.vCI).avE("T32");
      vBJ = new com.tencent.mm.plugin.finder.storage.config.c("最近赞过开关-打开", (kotlin.g.a.b)c.ah.vCL).avE("T5");
      vBK = new com.tencent.mm.plugin.finder.storage.config.c("最近赞过开关-关闭", (kotlin.g.a.b)c.ag.vCK).avE("T5");
      vBL = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "直播新手引导一直出", "FINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG");
      vBM = new com.tencent.mm.plugin.finder.storage.config.c("清除直播新手引导标记", (kotlin.g.a.b)c.ad.vCH);
      vBN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播上滑新手引导开关").d(b.a.sdC).b("FINDER_LIVE_GUIDE_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T32_next");
      vBO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "进入Finder点击时提前加载").d(b.a.snS).b("FINDER_FINDER_ENTER_LOAD_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "打开", "关闭" }));
      vBP = new com.tencent.mm.plugin.finder.storage.config.c("插入红包封面红点", (kotlin.g.a.b)ak.vCO);
      vBQ = new com.tencent.mm.plugin.finder.storage.config.c("重置红包入口关闭标志", (kotlin.g.a.b)c.ai.vCM);
      vBR = new com.tencent.mm.plugin.finder.storage.config.c("重置是否进入过红包小程序标志", (kotlin.g.a.b)c.aj.vCN);
      vBS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "cgi流水").b("FINDER_FINDER_CGI_DEBUG_SWITCH", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), kotlin.a.j.listOf(new String[] { "默认", "打开", "关闭" }));
      vBT = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(true, "朋友圈poi点击是否跳转新详情页").d(b.a.snT);
      vBU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否开启视频preparing").d(b.a.snU).b("FINDER_VIDEO_TP_PREPARE_ENABLE", kotlin.a.j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), kotlin.a.j.listOf(new String[] { "关闭", "打开" })).avE("T5");
      vBV = "";
      vBW = "100, 60, 1000, 60";
      vBX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "使用 Flutter UI").b("DEBUG_FLUTTER_UI", (List)new ArrayList((Collection)kotlin.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) })), kotlin.a.j.listOf(new String[] { "打开", "关闭" }));
      vBY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "长视频添加进历史准入时间偏移").d(b.a.sde);
      vBZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "长视频从历史删除准出时间偏移").d(b.a.sdf);
      vCa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(15, "直播添加进历史准入时间偏移").d(b.a.sdg);
      AppMethodBeat.o(166903);
      return;
      localObject = kotlin.k.j.M(0.857142857142857D);
      break;
      i = 0;
      break label3194;
    }
  }
  
  public static void KP(int paramInt)
  {
    vwX = paramInt;
  }
  
  public static void KQ(int paramInt)
  {
    AppMethodBeat.i(251650);
    Log.i("FinderConfig", "set REPLY_SCENE value:".concat(String.valueOf(paramInt)));
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OmL, Integer.valueOf(paramInt));
    AppMethodBeat.o(251650);
  }
  
  public static void KR(int paramInt)
  {
    AppMethodBeat.i(251660);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OlS, Integer.valueOf(paramInt));
    AppMethodBeat.o(251660);
  }
  
  public static void KS(int paramInt)
  {
    AppMethodBeat.i(251662);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OlY, Integer.valueOf(paramInt));
    AppMethodBeat.o(251662);
  }
  
  public static void KT(int paramInt)
  {
    AppMethodBeat.i(251666);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OlW, Integer.valueOf(paramInt));
    AppMethodBeat.o(251666);
  }
  
  public static void KU(int paramInt)
  {
    AppMethodBeat.i(251668);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OlX, Integer.valueOf(paramInt));
    AppMethodBeat.o(251668);
  }
  
  public static void KV(int paramInt)
  {
    AppMethodBeat.i(251672);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OkD, Integer.valueOf(paramInt));
    AppMethodBeat.o(251672);
  }
  
  public static void KW(int paramInt)
  {
    AppMethodBeat.i(251675);
    Log.i("FinderConfig", "set LIVE_LICENSE value:".concat(String.valueOf(paramInt)));
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OnW, Integer.valueOf(paramInt));
    AppMethodBeat.o(251675);
  }
  
  public static String bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(251652);
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
        AppMethodBeat.o(251652);
        return "";
        paramString = MMApplicationContext.getContext().getString(2131760614);
        p.g(paramString, "MMApplicationContext.get…string.finder_tab_friend)");
        continue;
        paramString = MMApplicationContext.getContext().getString(2131760613);
        p.g(paramString, "MMApplicationContext.get…string.finder_tab_follow)");
        continue;
        paramString = MMApplicationContext.getContext().getString(2131760616);
        p.g(paramString, "MMApplicationContext.get…tring.finder_tab_machine)");
        break;
      case 1: 
        locale = com.tencent.mm.kernel.g.aAh();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.azQ().get(ar.a.OkM, paramString);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(251652);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(251652);
        return paramString;
      case 3: 
        locale = com.tencent.mm.kernel.g.aAh();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.azQ().get(ar.a.OkO, paramString);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(251652);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(251652);
        return paramString;
      case 4: 
        locale = com.tencent.mm.kernel.g.aAh();
        p.g(locale, "MMKernel.storage()");
        paramString = locale.azQ().get(ar.a.OkN, paramString);
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(251652);
          throw paramString;
        }
        paramString = (String)paramString;
        AppMethodBeat.o(251652);
        return paramString;
      }
    }
  }
  
  public static int dqA()
  {
    AppMethodBeat.i(166906);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sas, 300);
    AppMethodBeat.o(166906);
    return i;
  }
  
  public static boolean dqB()
  {
    AppMethodBeat.i(166907);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbA, 1) == 1)
    {
      AppMethodBeat.o(166907);
      return true;
    }
    AppMethodBeat.o(166907);
    return false;
  }
  
  public static int dqC()
  {
    return vwz;
  }
  
  public static boolean dqD()
  {
    AppMethodBeat.i(251631);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sct, 1) == 1)
    {
      AppMethodBeat.o(251631);
      return true;
    }
    AppMethodBeat.o(251631);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dqE()
  {
    return vwA;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dqF()
  {
    return vwB;
  }
  
  public static boolean dqG()
  {
    AppMethodBeat.i(251632);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scs, 0) == 1)
    {
      AppMethodBeat.o(251632);
      return true;
    }
    AppMethodBeat.o(251632);
    return false;
  }
  
  public static boolean dqH()
  {
    AppMethodBeat.i(251633);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scu, 0) == 1)
    {
      AppMethodBeat.o(251633);
      return true;
    }
    AppMethodBeat.o(251633);
    return false;
  }
  
  public static long dqI()
  {
    AppMethodBeat.i(251634);
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbY, 28L * vwv);
    AppMethodBeat.o(251634);
    return l;
  }
  
  public static long dqJ()
  {
    AppMethodBeat.i(251635);
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbZ, 450L * vwv);
    AppMethodBeat.o(251635);
    return l;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> dqK()
  {
    return vwF;
  }
  
  public static long dqL()
  {
    AppMethodBeat.i(251636);
    if ((((Number)vwF.value()).longValue() > 0L) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)))
    {
      l1 = ((Number)vwF.value()).longValue();
      AppMethodBeat.o(251636);
      return l1;
    }
    long l1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sca, 100L * vwv);
    long l2 = dqJ();
    AppMethodBeat.o(251636);
    return l1 + l2;
  }
  
  public static int dqM()
  {
    AppMethodBeat.i(251637);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sce, vwv * 28);
    AppMethodBeat.o(251637);
    return i;
  }
  
  public static int dqN()
  {
    return vwH;
  }
  
  public static int dqO()
  {
    AppMethodBeat.i(166908);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderFeedCompressResolution");
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
    i = Util.safeParseInt((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166908);
    return i;
  }
  
  public static int dqP()
  {
    AppMethodBeat.i(166909);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderFeedCompressResolution");
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
    i = Util.safeParseInt((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166909);
    return i;
  }
  
  public static int dqQ()
  {
    AppMethodBeat.i(166910);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderFeedCompressPicLevel");
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
    i = Util.safeParseInt(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166910);
    return i;
  }
  
  public static int dqR()
  {
    return vwL;
  }
  
  public static int dqS()
  {
    AppMethodBeat.i(166911);
    int i = vwM;
    AppMethodBeat.o(166911);
    return i;
  }
  
  public static int dqT()
  {
    AppMethodBeat.i(166912);
    int i = vwN;
    AppMethodBeat.o(166912);
    return i;
  }
  
  public static int dqU()
  {
    AppMethodBeat.i(166913);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderHeadCompressPicLevel");
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
    i = Util.safeParseInt(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166913);
    return i;
  }
  
  public static int dqV()
  {
    AppMethodBeat.i(166914);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderProfileBgImgCompressResolution");
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
    i = Util.safeParseInt((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(0));
    AppMethodBeat.o(166914);
    return i;
  }
  
  public static int dqW()
  {
    AppMethodBeat.i(166915);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderProfileBgImgCompressResolution");
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
    i = Util.safeParseInt((String)n.a((CharSequence)n.trim((CharSequence)localObject).toString(), new String[] { "*" }).get(1));
    AppMethodBeat.o(166915);
    return i;
  }
  
  public static int dqX()
  {
    AppMethodBeat.i(166916);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderProfileBgImgCompressPicLevel");
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
    i = Util.safeParseInt(n.trim((CharSequence)localObject).toString());
    AppMethodBeat.o(166916);
    return i;
  }
  
  public static int dqY()
  {
    AppMethodBeat.i(251638);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    int i = ((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getInt("FinderCoverCompressPicLevel", 50);
    AppMethodBeat.o(251638);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dqZ()
  {
    return vwT;
  }
  
  public static int dqs()
  {
    return vwv;
  }
  
  public static float dqt()
  {
    return vww;
  }
  
  public static int dqu()
  {
    return vwx;
  }
  
  public static void dqv()
  {
    vwx = 1;
  }
  
  public static VideoTransPara dqw()
  {
    AppMethodBeat.i(166904);
    Object localObject = com.tencent.mm.plugin.vlog.model.m.Gyi;
    if (com.tencent.mm.plugin.vlog.model.m.fAU())
    {
      localObject = com.tencent.mm.plugin.vlog.model.m.Gyi;
      VideoTransPara localVideoTransPara = com.tencent.mm.plugin.vlog.model.m.fAV();
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = com.tencent.mm.modelcontrol.e.baZ();
        p.g(localObject, "SubCoreVideoControl.getCore()");
        localObject = ((com.tencent.mm.modelcontrol.e)localObject).bbe();
        p.g(localObject, "SubCoreVideoControl.getC…e().finderRecordVideoPara");
      }
      AppMethodBeat.o(166904);
      return localObject;
    }
    localObject = com.tencent.mm.modelcontrol.e.baZ();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bbe();
    p.g(localObject, "SubCoreVideoControl.getC…e().finderRecordVideoPara");
    AppMethodBeat.o(166904);
    return localObject;
  }
  
  public static VideoTransPara dqx()
  {
    AppMethodBeat.i(166905);
    Object localObject = com.tencent.mm.plugin.vlog.model.m.Gyi;
    if (com.tencent.mm.plugin.vlog.model.m.fAU())
    {
      localObject = com.tencent.mm.plugin.vlog.model.m.Gyi;
      VideoTransPara localVideoTransPara = com.tencent.mm.plugin.vlog.model.m.fAV();
      localObject = localVideoTransPara;
      if (localVideoTransPara == null)
      {
        localObject = com.tencent.mm.modelcontrol.e.baZ();
        p.g(localObject, "SubCoreVideoControl.getCore()");
        localObject = ((com.tencent.mm.modelcontrol.e)localObject).bbf();
        p.g(localObject, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
      }
      AppMethodBeat.o(166905);
      return localObject;
    }
    localObject = com.tencent.mm.modelcontrol.e.baZ();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bbf();
    p.g(localObject, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
    AppMethodBeat.o(166905);
    return localObject;
  }
  
  public static VideoTransPara dqy()
  {
    AppMethodBeat.i(251630);
    Object localObject = com.tencent.mm.modelcontrol.e.baZ();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bbg();
    p.g(localObject, "SubCoreVideoControl.getC….finderAlbumLongVideoPara");
    AppMethodBeat.o(251630);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dqz()
  {
    return vwy;
  }
  
  private static boolean drA()
  {
    AppMethodBeat.i(251642);
    long l2 = System.currentTimeMillis();
    Object localObject1 = ((Iterable)kotlin.a.j.listOf(new b.a[] { b.a.rQg, b.a.rQh, b.a.rQi, b.a.rQj, b.a.rQk, b.a.rQl, b.a.rQm, b.a.rQn, b.a.rQo, b.a.rQp })).iterator();
    boolean bool1 = false;
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (b.a)((Iterator)localObject1).next();
      localObject2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a((b.a)localObject2, "{mode:1,whitelist:[],apilevel:[],company:[],blacklist:[]}");
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
            bool2 = n.I(Build.MODEL, str, true);
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
            localObject1 = h.CyF;
            if (!bool2) {
              break label364;
            }
            l1 = 1L;
            ((h)localObject1).n(1505L, 9L, l1);
            Log.i("FinderConfig", "checkEnableCodecReuse enableCodecReuse:" + bool2 + " duration:" + (System.currentTimeMillis() - l2));
            AppMethodBeat.o(251642);
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
  
  public static boolean drB()
  {
    AppMethodBeat.i(251643);
    boolean bool = ((Boolean)vxf.getValue()).booleanValue();
    AppMethodBeat.o(251643);
    return bool;
  }
  
  private static boolean[] drC()
  {
    AppMethodBeat.i(166939);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saZ, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
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
  
  public static boolean drD()
  {
    boolean bool2 = true;
    AppMethodBeat.i(251644);
    boolean bool1;
    if (((Number)vAI.value()).intValue() == 1)
    {
      bool1 = true;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saV, 1) != 1) {
        break label73;
      }
    }
    for (;;)
    {
      if ((!BuildInfo.DEBUG) && (!BuildInfo.DEBUG)) {
        break label78;
      }
      AppMethodBeat.o(251644);
      return bool1;
      bool1 = false;
      break;
      label73:
      bool2 = false;
    }
    label78:
    AppMethodBeat.o(251644);
    return bool2;
  }
  
  public static boolean drE()
  {
    AppMethodBeat.i(251645);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saW, 1) == 1)
    {
      AppMethodBeat.o(251645);
      return true;
    }
    AppMethodBeat.o(251645);
    return false;
  }
  
  public static o<Integer, Boolean> drF()
  {
    AppMethodBeat.i(251646);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saQ, 3);
    try
    {
      Object localObject1 = Build.MODEL;
      p.g(localObject1, "Build.MODEL");
      localObject3 = Locale.getDefault();
      p.g(localObject3, "Locale.getDefault()");
      if (localObject1 != null) {
        break label111;
      }
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251646);
      throw ((Throwable)localObject1);
    }
    catch (Throwable localThrowable1)
    {
      bool = false;
    }
    Log.printErrStackTrace("FinderConfig", localThrowable1, "", new Object[0]);
    Object localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
    AppMethodBeat.o(251646);
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
      localObject2 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(251646);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).toLowerCase((Locale)localObject4);
    p.g(localObject3, "(this as java.lang.String).toLowerCase(locale)");
    localObject4 = "API#" + Build.VERSION.SDK_INT;
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saS, "");
    if (!Util.isNullOrNil(str))
    {
      p.g(str, "waitForRelease");
      if ((n.e((CharSequence)str, (CharSequence)localObject2)) || (n.e((CharSequence)str, (CharSequence)localObject3)) || (n.e((CharSequence)str, (CharSequence)localObject4))) {
        Log.i("FinderConfig", "[getVideoViewConfig#waitForRelease] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
      }
    }
    for (boolean bool = true;; bool = false) {
      label520:
      for (;;)
      {
        try
        {
          str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saR, "");
          if (Util.isNullOrNil(str)) {
            break label520;
          }
          p.g(str, "videoSingleCount");
          if ((!n.e((CharSequence)str, (CharSequence)localObject2)) && (!n.e((CharSequence)str, (CharSequence)localObject3)) && (!n.e((CharSequence)str, (CharSequence)localObject4))) {
            break label520;
          }
          Log.i("FinderConfig", "[getVideoViewConfig#videoSingleCount] brand=" + (String)localObject3 + " model=" + (String)localObject2 + " apiLevel=" + (String)localObject4 + ", expt=" + str);
          i = 1;
          try
          {
            localObject2 = new o(Integer.valueOf(i), Boolean.valueOf(bool));
            AppMethodBeat.o(251646);
            return localObject2;
          }
          catch (Throwable localThrowable2) {}
        }
        catch (Throwable localThrowable3) {}
        break;
      }
    }
  }
  
  public static int drG()
  {
    AppMethodBeat.i(166942);
    int i = ((Number)vxj.getValue()).intValue();
    AppMethodBeat.o(166942);
    return i;
  }
  
  public static boolean drH()
  {
    AppMethodBeat.i(251647);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slC, 1) == 1) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(251647);
      return true;
    }
    AppMethodBeat.o(251647);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> drI()
  {
    return vxk;
  }
  
  public static boolean drJ()
  {
    AppMethodBeat.i(251648);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slE, 1) == 1)
    {
      AppMethodBeat.o(251648);
      return true;
    }
    AppMethodBeat.o(251648);
    return false;
  }
  
  public static String drK()
  {
    AppMethodBeat.i(166943);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sby, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
    AppMethodBeat.o(166943);
    return str;
  }
  
  public static boolean drL()
  {
    AppMethodBeat.i(166944);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1)
    {
      AppMethodBeat.o(166944);
      return true;
    }
    AppMethodBeat.o(166944);
    return false;
  }
  
  public static boolean drM()
  {
    AppMethodBeat.i(166945);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbz, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(bool)));
      AppMethodBeat.o(166945);
      return bool;
    }
  }
  
  public static boolean drN()
  {
    AppMethodBeat.i(166948);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbB, 1) == 1)
    {
      AppMethodBeat.o(166948);
      return true;
    }
    AppMethodBeat.o(166948);
    return false;
  }
  
  public static boolean drO()
  {
    AppMethodBeat.i(251649);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderMaxMentionSbCount", 1000) > 0)
    {
      AppMethodBeat.o(251649);
      return true;
    }
    AppMethodBeat.o(251649);
    return false;
  }
  
  public static boolean drP()
  {
    AppMethodBeat.i(166950);
    if ((vxl == 0) && (Log.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166950);
      return false;
    }
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderPoiJumpTopicSwitch", 0) == 1)
    {
      AppMethodBeat.o(166950);
      return true;
    }
    AppMethodBeat.o(166950);
    return false;
  }
  
  public static boolean drQ()
  {
    AppMethodBeat.i(166952);
    if ((vxm) && (Log.getLogLevel() <= 1))
    {
      AppMethodBeat.o(166952);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbD, 1) == 1)
    {
      AppMethodBeat.o(166952);
      return true;
    }
    AppMethodBeat.o(166952);
    return false;
  }
  
  public static int drR()
  {
    AppMethodBeat.i(178407);
    if ((vxn != 5) && (Log.getLogLevel() <= 1))
    {
      i = vxn;
      AppMethodBeat.o(178407);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbF, vxn);
    AppMethodBeat.o(178407);
    return i;
  }
  
  public static int drS()
  {
    AppMethodBeat.i(178412);
    if (((Number)vya.value()).intValue() == 1)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
      p.g(locale, "MMKernel.storage()");
      int i = locale.azQ().getInt(ar.a.OmL, vxo);
      if (i <= 0)
      {
        i = vxo;
        AppMethodBeat.o(178412);
        return i;
      }
      AppMethodBeat.o(178412);
      return i;
    }
    AppMethodBeat.o(178412);
    return 2;
  }
  
  public static int drT()
  {
    return vxo;
  }
  
  public static boolean drU()
  {
    AppMethodBeat.i(178413);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderCommentShowBlacklist", 0) == 1)
    {
      AppMethodBeat.o(178413);
      return true;
    }
    AppMethodBeat.o(178413);
    return false;
  }
  
  public static int drV()
  {
    AppMethodBeat.i(178414);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scn, 0);
    AppMethodBeat.o(178414);
    return i;
  }
  
  public static boolean drW()
  {
    AppMethodBeat.i(178415);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    if (locale.azQ().a(ar.a.Oma, 0L) == 0L)
    {
      AppMethodBeat.o(178415);
      return true;
    }
    AppMethodBeat.o(178415);
    return false;
  }
  
  public static boolean drX()
  {
    AppMethodBeat.i(178416);
    if ((vxq == 1) && (Log.getLogLevel() <= 1))
    {
      AppMethodBeat.o(178416);
      return true;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scl, 0) == 1)
    {
      AppMethodBeat.o(178416);
      return true;
    }
    AppMethodBeat.o(178416);
    return false;
  }
  
  public static int drY()
  {
    AppMethodBeat.i(178417);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scm, 10000000);
    AppMethodBeat.o(178417);
    return i;
  }
  
  public static int drZ()
  {
    AppMethodBeat.i(178418);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderCommentNickNameMaxLength", 6);
    AppMethodBeat.o(178418);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dra()
  {
    return vwU;
  }
  
  public static int drb()
  {
    return vwV;
  }
  
  public static int drc()
  {
    return vwX;
  }
  
  public static int drd()
  {
    return vwY;
  }
  
  public static int dre()
  {
    return vwZ;
  }
  
  public static boolean drf()
  {
    return vxb;
  }
  
  public static boolean drg()
  {
    return vxc;
  }
  
  public static long drh()
  {
    AppMethodBeat.i(166917);
    if ((vxd > 0L) && (Log.getLogLevel() <= 1))
    {
      l = vxd;
      AppMethodBeat.o(166917);
      return l;
    }
    long l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saH, 86400L);
    AppMethodBeat.o(166917);
    return l * 1000L;
  }
  
  private static float dri()
  {
    AppMethodBeat.i(166918);
    Log.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + vxe);
    if (vxe < 10L)
    {
      AppMethodBeat.o(166918);
      return 0.5F;
    }
    if (vxe < 20L)
    {
      AppMethodBeat.o(166918);
      return 1.0F;
    }
    AppMethodBeat.o(166918);
    return 2.0F;
  }
  
  public static long drj()
  {
    AppMethodBeat.i(166919);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saI, 1024L) * vwv) * dri());
    AppMethodBeat.o(166919);
    return l;
  }
  
  public static long drk()
  {
    AppMethodBeat.i(166920);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saJ, 100L) * vwv) * dri());
    AppMethodBeat.o(166920);
    return l;
  }
  
  public static long drl()
  {
    AppMethodBeat.i(166921);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saK, 500L) * vwv) * dri());
    AppMethodBeat.o(166921);
    return l;
  }
  
  public static long drm()
  {
    AppMethodBeat.i(166922);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saL, 1024L) * vwv) * dri());
    AppMethodBeat.o(166922);
    return l;
  }
  
  public static long drn()
  {
    AppMethodBeat.i(166923);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saM, 500L) * vwv) * dri());
    AppMethodBeat.o(166923);
    return l;
  }
  
  public static long dro()
  {
    AppMethodBeat.i(166924);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saN, 500L) * vwv) * dri());
    AppMethodBeat.o(166924);
    return l;
  }
  
  public static long drp()
  {
    AppMethodBeat.i(166925);
    long l = ((float)(((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saO, 500L) * vwv) * dri());
    AppMethodBeat.o(166925);
    return l;
  }
  
  public static int drq()
  {
    AppMethodBeat.i(166929);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderTimelineEntry", 0);
    AppMethodBeat.o(166929);
    return i;
  }
  
  public static boolean drr()
  {
    AppMethodBeat.i(166930);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sam, 1) == 1)
    {
      AppMethodBeat.o(166930);
      return true;
    }
    AppMethodBeat.o(166930);
    return false;
  }
  
  public static boolean drs()
  {
    AppMethodBeat.i(166932);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.san, 1) == 1)
    {
      AppMethodBeat.o(166932);
      return true;
    }
    AppMethodBeat.o(166932);
    return false;
  }
  
  public static boolean drt()
  {
    AppMethodBeat.i(166933);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sat, 1) == 1)
    {
      AppMethodBeat.o(166933);
      return true;
    }
    AppMethodBeat.o(166933);
    return false;
  }
  
  public static boolean dru()
  {
    AppMethodBeat.i(166934);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sau, 1) == 1)
    {
      AppMethodBeat.o(166934);
      return true;
    }
    AppMethodBeat.o(166934);
    return false;
  }
  
  public static boolean drv()
  {
    AppMethodBeat.i(166935);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderShareDetailCommentListShow", 1) == 1)
    {
      AppMethodBeat.o(166935);
      return true;
    }
    AppMethodBeat.o(166935);
    return false;
  }
  
  public static boolean drw()
  {
    AppMethodBeat.i(166936);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderShareDetailCommentButtonShow", 1) == 1)
    {
      AppMethodBeat.o(166936);
      return true;
    }
    AppMethodBeat.o(166936);
    return false;
  }
  
  public static boolean drx()
  {
    AppMethodBeat.i(251639);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderFeedCameraShowPostEducation", 1) == 1)
    {
      AppMethodBeat.o(251639);
      return true;
    }
    AppMethodBeat.o(251639);
    return false;
  }
  
  public static String dry()
  {
    AppMethodBeat.i(251640);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.OjX, "");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(251640);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = MMApplicationContext.getContext().getString(2131760345);
      p.g(localObject, "MMApplicationContext.get…finder_no_post_edu_title)");
      AppMethodBeat.o(251640);
      return localObject;
    }
    AppMethodBeat.o(251640);
    return localObject;
  }
  
  public static String drz()
  {
    AppMethodBeat.i(251641);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.OjY, "");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(251641);
      throw ((Throwable)localObject);
    }
    localObject = (String)localObject;
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = MMApplicationContext.getContext().getString(2131760344);
      p.g(localObject, "MMApplicationContext.get….finder_no_post_edu_desc)");
      AppMethodBeat.o(251641);
      return localObject;
    }
    AppMethodBeat.o(251641);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsA()
  {
    return vxL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsB()
  {
    return vxM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsC()
  {
    return vxN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsD()
  {
    return vxO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsE()
  {
    return vxP;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsF()
  {
    return vxQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsG()
  {
    return vxR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsH()
  {
    return vxS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsI()
  {
    return vxT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsJ()
  {
    return vxU;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsK()
  {
    return vxV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsL()
  {
    return vxW;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsM()
  {
    return vxX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsN()
  {
    return vxY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsO()
  {
    return vxZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsP()
  {
    return vya;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsQ()
  {
    return vyb;
  }
  
  public static int dsR()
  {
    AppMethodBeat.i(251659);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OlS, 4);
    AppMethodBeat.o(251659);
    return i;
  }
  
  public static int dsS()
  {
    AppMethodBeat.i(251661);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OlY, 0);
    AppMethodBeat.o(251661);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsT()
  {
    return vyc;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dsU()
  {
    return vyd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsV()
  {
    return vye;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsW()
  {
    return vyf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsX()
  {
    return vyg;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsY()
  {
    return vyh;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsZ()
  {
    return vyi;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsa()
  {
    return vxr;
  }
  
  public static long dsb()
  {
    return vxs;
  }
  
  public static boolean dsc()
  {
    AppMethodBeat.i(251651);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saw, 1) == 1)
    {
      AppMethodBeat.o(251651);
      return true;
    }
    AppMethodBeat.o(251651);
    return false;
  }
  
  public static boolean dsd()
  {
    return vxt;
  }
  
  public static int dse()
  {
    return vxu;
  }
  
  public static int dsf()
  {
    return vxv;
  }
  
  public static boolean dsh()
  {
    AppMethodBeat.i(251654);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.saD, 1) == 1)
    {
      AppMethodBeat.o(251654);
      return true;
    }
    AppMethodBeat.o(251654);
    return false;
  }
  
  public static int dsi()
  {
    return vxw;
  }
  
  public static boolean dsj()
  {
    AppMethodBeat.i(251655);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRD, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isEnableStoreLastTabType=".concat(String.valueOf(bool)));
      AppMethodBeat.o(251655);
      return bool;
    }
  }
  
  public static void dsk()
  {
    AppMethodBeat.i(251656);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OkR, Integer.valueOf(1));
    vxx = false;
    AppMethodBeat.o(251656);
  }
  
  public static boolean dsl()
  {
    AppMethodBeat.i(251657);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRE, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isEnablePreloadStreamRefresh=".concat(String.valueOf(bool)));
      AppMethodBeat.o(251657);
      return bool;
    }
  }
  
  public static boolean dsm()
  {
    AppMethodBeat.i(251658);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRF, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderConfig", "[GET] isEnablePreloadVideoForPreloadStream=".concat(String.valueOf(bool)));
      AppMethodBeat.o(251658);
      return bool;
    }
  }
  
  public static kotlin.k.b<Double> dsn()
  {
    return vxy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dso()
  {
    return vxz;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsp()
  {
    return vxA;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsq()
  {
    return vxB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsr()
  {
    return vxC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dss()
  {
    return vxD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dst()
  {
    return vxE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsu()
  {
    return vxF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dsv()
  {
    return vxG;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsw()
  {
    return vxH;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsx()
  {
    return vxI;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dsy()
  {
    return vxJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsz()
  {
    return vxK;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtA()
  {
    return vyK;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtB()
  {
    return vyL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtC()
  {
    return vyM;
  }
  
  public static List<o<Integer, String>> dtD()
  {
    return vyN;
  }
  
  public static boolean dtE()
  {
    AppMethodBeat.i(251663);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(locala, "MMKernel.service<IConfig…onfigService::class.java)");
    if (((com.tencent.mm.plugin.zero.b.a)locala).aqJ().getInt("FinderStatsReportControl", 1) == 1)
    {
      AppMethodBeat.o(251663);
      return true;
    }
    AppMethodBeat.o(251663);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtF()
  {
    return vyP;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtG()
  {
    return vyQ;
  }
  
  public static int dtH()
  {
    AppMethodBeat.i(251664);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scf, 0);
    AppMethodBeat.o(251664);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtI()
  {
    return vyR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtJ()
  {
    return vyS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtK()
  {
    return vyT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtL()
  {
    return vyU;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtM()
  {
    return vyV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtN()
  {
    return vyW;
  }
  
  public static int dtO()
  {
    AppMethodBeat.i(251665);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OlW, 3);
    AppMethodBeat.o(251665);
    return i;
  }
  
  public static int dtP()
  {
    AppMethodBeat.i(251667);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OlX, 3);
    AppMethodBeat.o(251667);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtQ()
  {
    return vyY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtR()
  {
    return vyZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtS()
  {
    return vza;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtT()
  {
    return vzb;
  }
  
  public static boolean dtU()
  {
    AppMethodBeat.i(251669);
    if (((Number)vzb.value()).intValue() == 1)
    {
      AppMethodBeat.o(251669);
      return true;
    }
    AppMethodBeat.o(251669);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtV()
  {
    return vzc;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtW()
  {
    return vzd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtX()
  {
    return vze;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtY()
  {
    return vzf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtZ()
  {
    return vzg;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dta()
  {
    return vyj;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtb()
  {
    return vyk;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtc()
  {
    return vyl;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtd()
  {
    return vym;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dte()
  {
    return vyn;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtf()
  {
    return vyo;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtg()
  {
    return vyp;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dth()
  {
    return vyq;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dti()
  {
    return vyr;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtj()
  {
    return vys;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtk()
  {
    return vyt;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtl()
  {
    return vyu;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtm()
  {
    return vyv;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtn()
  {
    return vyw;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dto()
  {
    return vyx;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtp()
  {
    return vyy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtq()
  {
    return vyz;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtr()
  {
    return vyA;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dts()
  {
    return vyB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtt()
  {
    return vyC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtu()
  {
    return vyD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtv()
  {
    return vyE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtw()
  {
    return vyF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtx()
  {
    return vyG;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> dty()
  {
    return vyH;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dtz()
  {
    return vyJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duA()
  {
    return vzI;
  }
  
  public static String duB()
  {
    AppMethodBeat.i(251670);
    Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject, "MMKernel.service<IConfig…onfigService::class.java)");
    localObject = ((com.tencent.mm.plugin.zero.b.a)localObject).aqJ().getValue("FinderShowOriginalCertificationUrl");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(251670);
      return "https://support.weixin.qq.com/cgi-bin/mmfindersupport-bin/newreadtemplate?t=page/outer_page/original_plan&wechat_real_lang=zh_CN";
    }
    p.g(localObject, "url");
    AppMethodBeat.o(251670);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c duC()
  {
    return vzJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c duD()
  {
    return vzK;
  }
  
  public static int duE()
  {
    AppMethodBeat.i(251671);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OkD, 1);
    AppMethodBeat.o(251671);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duF()
  {
    return vzL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duG()
  {
    return vzM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duH()
  {
    return vzN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duI()
  {
    return vzO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duJ()
  {
    return vzP;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duK()
  {
    return vzQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c duL()
  {
    return vzR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c duM()
  {
    return vzS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duN()
  {
    return vzT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a duO()
  {
    return vzU;
  }
  
  public static boolean duP()
  {
    AppMethodBeat.i(251673);
    if (((Number)vzT.value()).intValue() == 1)
    {
      AppMethodBeat.o(251673);
      return true;
    }
    AppMethodBeat.o(251673);
    return false;
  }
  
  public static int duQ()
  {
    AppMethodBeat.i(251674);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    int i = locale.azQ().getInt(ar.a.OnW, 0);
    AppMethodBeat.o(251674);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duR()
  {
    return vzV;
  }
  
  public static boolean duS()
  {
    AppMethodBeat.i(251676);
    if (((Number)vzV.value()).intValue() == 1)
    {
      AppMethodBeat.o(251676);
      return true;
    }
    AppMethodBeat.o(251676);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duT()
  {
    return vzW;
  }
  
  public static boolean duU()
  {
    AppMethodBeat.i(251677);
    if (((Number)vzW.value()).intValue() == 1)
    {
      AppMethodBeat.o(251677);
      return true;
    }
    AppMethodBeat.o(251677);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duV()
  {
    return vzX;
  }
  
  public static boolean duW()
  {
    AppMethodBeat.i(251678);
    if (((Number)vzX.value()).intValue() == 0)
    {
      AppMethodBeat.o(251678);
      return true;
    }
    AppMethodBeat.o(251678);
    return false;
  }
  
  public static int duX()
  {
    AppMethodBeat.i(251679);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbe, 75);
    AppMethodBeat.o(251679);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duY()
  {
    return vzY;
  }
  
  public static int duZ()
  {
    AppMethodBeat.i(251680);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbg, 50);
    AppMethodBeat.o(251680);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dua()
  {
    return vzh;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dub()
  {
    return vzi;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c duc()
  {
    return vzj;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dud()
  {
    return vzk;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> due()
  {
    return vzl;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duf()
  {
    return vzm;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dug()
  {
    return vzn;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duh()
  {
    return vzo;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dui()
  {
    return vzp;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duj()
  {
    return vzq;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duk()
  {
    return vzr;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dul()
  {
    return vzs;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dum()
  {
    return vzt;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dun()
  {
    return vzu;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duo()
  {
    return vzv;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dup()
  {
    return vzw;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duq()
  {
    return vzx;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dur()
  {
    return vzy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dus()
  {
    return vzz;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dut()
  {
    return vzA;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duu()
  {
    return vzB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duv()
  {
    return vzC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duw()
  {
    return vzD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dux()
  {
    return vzE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c duy()
  {
    return vzF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duz()
  {
    return vzH;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvA()
  {
    return vAo;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvB()
  {
    return vAp;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvC()
  {
    return vAq;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvD()
  {
    return vAr;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvE()
  {
    return vAs;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> dvF()
  {
    return vAt;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> dvG()
  {
    return vAu;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> dvH()
  {
    return vAv;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvI()
  {
    return vAw;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvJ()
  {
    return vAx;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvK()
  {
    return vAy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvL()
  {
    return vAz;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvM()
  {
    return vAA;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvN()
  {
    return vAB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvO()
  {
    return vAC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvP()
  {
    return vAD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvQ()
  {
    return vAE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dvR()
  {
    return vAF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvS()
  {
    return vAG;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvT()
  {
    return vAH;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvU()
  {
    return vAI;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvV()
  {
    return vAJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvW()
  {
    return vAK;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Boolean> dvX()
  {
    return vAL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvY()
  {
    return vAO;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvZ()
  {
    return vAP;
  }
  
  public static int dva()
  {
    AppMethodBeat.i(251681);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbk, 10);
    AppMethodBeat.o(251681);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvb()
  {
    return vzZ;
  }
  
  public static boolean dvc()
  {
    AppMethodBeat.i(251682);
    if (((Number)vzZ.value()).intValue() == 0)
    {
      AppMethodBeat.o(251682);
      return true;
    }
    AppMethodBeat.o(251682);
    return false;
  }
  
  public static int dvd()
  {
    AppMethodBeat.i(251683);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbl, 10);
    AppMethodBeat.o(251683);
    return i;
  }
  
  public static int dve()
  {
    AppMethodBeat.i(251684);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbm, 60);
    AppMethodBeat.o(251684);
    return i;
  }
  
  public static int dvf()
  {
    AppMethodBeat.i(251685);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbj, 4000);
    AppMethodBeat.o(251685);
    return i;
  }
  
  public static int dvg()
  {
    AppMethodBeat.i(251686);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbh, 100);
    AppMethodBeat.o(251686);
    return i;
  }
  
  public static int dvh()
  {
    AppMethodBeat.i(251687);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbi, 3);
    AppMethodBeat.o(251687);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvi()
  {
    return vAa;
  }
  
  public static boolean dvj()
  {
    AppMethodBeat.i(251688);
    if (((Number)vAa.value()).intValue() == 1)
    {
      AppMethodBeat.o(251688);
      return true;
    }
    AppMethodBeat.o(251688);
    return false;
  }
  
  public static boolean dvk()
  {
    AppMethodBeat.i(251689);
    if (((Number)vAb.value()).intValue() == 1)
    {
      AppMethodBeat.o(251689);
      return true;
    }
    AppMethodBeat.o(251689);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvl()
  {
    return vAc;
  }
  
  public static boolean dvm()
  {
    AppMethodBeat.i(251690);
    if (((Number)vAc.value()).intValue() == 1)
    {
      AppMethodBeat.o(251690);
      return true;
    }
    AppMethodBeat.o(251690);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvn()
  {
    return vAd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvo()
  {
    return vAe;
  }
  
  public static int dvp()
  {
    AppMethodBeat.i(251691);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sbs, 15);
    AppMethodBeat.o(251691);
    return i;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvq()
  {
    return vAf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvr()
  {
    return vAg;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvs()
  {
    return vAh;
  }
  
  public static List<String> dvt()
  {
    AppMethodBeat.i(251692);
    Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)localObject1).aqJ().getValue("FinderTopicInputStopTokenList");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    if ((localObject1 != null) && ((p.j(localObject1, "") ^ true)))
    {
      localObject2 = (Iterable)n.a((CharSequence)localObject1, new String[] { "_" });
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
      AppMethodBeat.o(251692);
      return localObject1;
    }
    localObject1 = kotlin.a.j.listOf(new String[] { "\\s", "\\n", "#", "@", "\\t" });
    AppMethodBeat.o(251692);
    return localObject1;
  }
  
  public static List<String> dvu()
  {
    AppMethodBeat.i(251693);
    Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject1, "MMKernel.service<IConfig…onfigService::class.java)");
    Object localObject2 = ((com.tencent.mm.plugin.zero.b.a)localObject1).aqJ().getValue("FinderMentionInputStopTokenList");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    if ((localObject1 != null) && ((p.j(localObject1, "") ^ true)))
    {
      localObject2 = (Iterable)n.a((CharSequence)localObject1, new String[] { "_" });
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
      AppMethodBeat.o(251693);
      return localObject1;
    }
    localObject1 = kotlin.a.j.listOf(new String[] { "\\s", "\\n", "#", "@", "\\t" });
    AppMethodBeat.o(251693);
    return localObject1;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvv()
  {
    return vAj;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dvw()
  {
    return vAk;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvx()
  {
    return vAl;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvy()
  {
    return vAm;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvz()
  {
    return vAn;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwA()
  {
    return vBq;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwB()
  {
    return vBr;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwC()
  {
    return vBs;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwD()
  {
    return vBt;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwE()
  {
    return vBu;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwF()
  {
    return vBv;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwG()
  {
    return vBw;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwH()
  {
    return vBy;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwI()
  {
    return vBz;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwJ()
  {
    return vBA;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwK()
  {
    return vBB;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwL()
  {
    return vBC;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwM()
  {
    return vBD;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwN()
  {
    return vBE;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwO()
  {
    return vBF;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwP()
  {
    return vBG;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwQ()
  {
    return vBH;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwR()
  {
    return vBI;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwS()
  {
    return vBJ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<String> dwT()
  {
    return vBK;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dwU()
  {
    return vBL;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dwV()
  {
    return vBM;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwW()
  {
    return vBN;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwX()
  {
    return vBO;
  }
  
  public static boolean dwY()
  {
    AppMethodBeat.i(251694);
    if (((Number)vBO.value()).intValue() == 1)
    {
      AppMethodBeat.o(251694);
      return true;
    }
    AppMethodBeat.o(251694);
    return false;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dwZ()
  {
    return vBP;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwa()
  {
    return vAQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwb()
  {
    return vAR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Long> dwc()
  {
    return vAS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwd()
  {
    return vAT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwe()
  {
    return vAU;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwf()
  {
    return vAV;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwg()
  {
    return vAW;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwh()
  {
    return vAX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwi()
  {
    return vAY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwj()
  {
    return vAZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwk()
  {
    return vBa;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwl()
  {
    return vBb;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwm()
  {
    return vBc;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwn()
  {
    return vBd;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwo()
  {
    return vBe;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwp()
  {
    return vBf;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwq()
  {
    return vBg;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwr()
  {
    return vBh;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dws()
  {
    return vBi;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwt()
  {
    return vBj;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwu()
  {
    return vBk;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwv()
  {
    return vBl;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dww()
  {
    return vBm;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwx()
  {
    return vBn;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwy()
  {
    return vBo;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Float> dwz()
  {
    return vBp;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dxa()
  {
    return vBQ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.c dxb()
  {
    return vBR;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxc()
  {
    return vBS;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Boolean> dxd()
  {
    return vBT;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxe()
  {
    return vBU;
  }
  
  public static String dxf()
  {
    AppMethodBeat.i(251695);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scj, "");
    p.g(str, "MMKernel.service(IExptSe…finder_cgi_blocklist, \"\")");
    AppMethodBeat.o(251695);
    return str;
  }
  
  public static String dxg()
  {
    AppMethodBeat.i(251696);
    String str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sck, "200, 60, 1000, 60");
    p.g(str, "MMKernel.service(IExptSe…mit, \"200, 60, 1000, 60\")");
    AppMethodBeat.o(251696);
    return str;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxh()
  {
    return vBX;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxi()
  {
    return vBY;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxj()
  {
    return vBZ;
  }
  
  public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxk()
  {
    return vCa;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final a vCc;
    
    static
    {
      AppMethodBeat.i(251524);
      vCc = new a();
      AppMethodBeat.o(251524);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final af vCJ;
    
    static
    {
      AppMethodBeat.i(251587);
      vCJ = new af();
      AppMethodBeat.o(251587);
    }
    
    af()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class ak
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final ak vCO;
    
    static
    {
      AppMethodBeat.i(251597);
      vCO = new ak();
      AppMethodBeat.o(251597);
    }
    
    ak()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class as
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final as vCW;
    
    static
    {
      AppMethodBeat.i(251611);
      vCW = new as();
      AppMethodBeat.o(251611);
    }
    
    as()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class aw
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final aw vDa;
    
    static
    {
      AppMethodBeat.i(251619);
      vDa = new aw();
      AppMethodBeat.o(251619);
    }
    
    aw()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class ax
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final ax vDb;
    
    static
    {
      AppMethodBeat.i(251621);
      vDb = new ax();
      AppMethodBeat.o(251621);
    }
    
    ax()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class ay
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final ay vDc;
    
    static
    {
      AppMethodBeat.i(251623);
      vDc = new ay();
      AppMethodBeat.o(251623);
    }
    
    ay()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class bc
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final bc vDg;
    
    static
    {
      AppMethodBeat.i(166900);
      vDg = new bc();
      AppMethodBeat.o(166900);
    }
    
    bc()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class bd
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final bd vDh;
    
    static
    {
      AppMethodBeat.i(166902);
      vDh = new bd();
      AppMethodBeat.o(166902);
    }
    
    bd()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final c vCh;
    
    static
    {
      AppMethodBeat.i(251530);
      vCh = new c();
      AppMethodBeat.o(251530);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final d vCi;
    
    static
    {
      AppMethodBeat.i(251532);
      vCi = new d();
      AppMethodBeat.o(251532);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final e vCj;
    
    static
    {
      AppMethodBeat.i(251534);
      vCj = new e();
      AppMethodBeat.o(251534);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final f vCk;
    
    static
    {
      AppMethodBeat.i(251536);
      vCk = new f();
      AppMethodBeat.o(251536);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final h vCm;
    
    static
    {
      AppMethodBeat.i(251540);
      vCm = new h();
      AppMethodBeat.o(251540);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final j vCo;
    
    static
    {
      AppMethodBeat.i(251544);
      vCo = new j();
      AppMethodBeat.o(251544);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final k vCp;
    
    static
    {
      AppMethodBeat.i(251546);
      vCp = new k();
      AppMethodBeat.o(251546);
    }
    
    k()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "<anonymous parameter 1>", "Landroid/content/Context;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.m<Integer, Context, x>
  {
    public static final l vCq;
    
    static
    {
      AppMethodBeat.i(251548);
      vCq = new l();
      AppMethodBeat.o(251548);
    }
    
    l()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final r vCw;
    
    static
    {
      AppMethodBeat.i(251560);
      vCw = new r();
      AppMethodBeat.o(251560);
    }
    
    r()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final s vCx;
    
    static
    {
      AppMethodBeat.i(251562);
      vCx = new s();
      AppMethodBeat.o(251562);
    }
    
    s()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/storage/FinderConfig$ENABLE_FINDER_MESSAGE$1", "Lcom/tencent/mm/plugin/finder/storage/config/item/integer/FinderIntConfig;", "value", "", "()Ljava/lang/Integer;", "plugin-finder_release"})
  public static final class t
    extends com.tencent.mm.plugin.finder.storage.config.item.integer.a
  {
    t(String paramString)
    {
      super(paramString);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final v vCz;
    
    static
    {
      AppMethodBeat.i(251567);
      vCz = new v();
      AppMethodBeat.o(251567);
    }
    
    v()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final y vCC;
    
    static
    {
      AppMethodBeat.i(251573);
      vCC = new y();
      AppMethodBeat.o(251573);
    }
    
    y()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/app/Activity;", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.b<Activity, x>
  {
    public static final z vCD;
    
    static
    {
      AppMethodBeat.i(251575);
      vCD = new z();
      AppMethodBeat.o(251575);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.c
 * JD-Core Version:    0.7.0.1
 */