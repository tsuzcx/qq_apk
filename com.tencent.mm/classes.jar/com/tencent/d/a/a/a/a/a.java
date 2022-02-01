package com.tencent.d.a.a.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/config/FinderLiveConfig;", "", "()V", "CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_CHUNXING", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getCLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_CHUNXING", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_FAJIXIAN", "getCLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_FAJIXIAN", "CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_NEW_SMOOTH_FACE", "getCLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_NEW_SMOOTH_FACE", "CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_SHOULIAN", "getCLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_SHOULIAN", "CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_XIABA", "getCLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_XIABA", "DEBUG_LIVE_ANCHOR_MUSIC_GUIDE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getDEBUG_LIVE_ANCHOR_MUSIC_GUIDE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "setDEBUG_LIVE_ANCHOR_MUSIC_GUIDE", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;)V", "DEBUG_LIVE_BEAUTY_CONFIG", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "getDEBUG_LIVE_BEAUTY_CONFIG", "()Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "setDEBUG_LIVE_BEAUTY_CONFIG", "(Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;)V", "DEBUG_LIVE_LICENSE", "getDEBUG_LIVE_LICENSE", "setDEBUG_LIVE_LICENSE", "DEBUG_LIVE_POST_FACE_VERIFY", "getDEBUG_LIVE_POST_FACE_VERIFY", "setDEBUG_LIVE_POST_FACE_VERIFY", "DEBUG_PROFILE_SHOP_OP_GUIDE", "getDEBUG_PROFILE_SHOP_OP_GUIDE", "setDEBUG_PROFILE_SHOP_OP_GUIDE", "DEBUG_RESET_LIVE_CHARGE_ANCHOR_LICENSE", "getDEBUG_RESET_LIVE_CHARGE_ANCHOR_LICENSE", "setDEBUG_RESET_LIVE_CHARGE_ANCHOR_LICENSE", "DEBUG_RESET_LIVE_CHARGE_VISITOR_LICENSE", "getDEBUG_RESET_LIVE_CHARGE_VISITOR_LICENSE", "setDEBUG_RESET_LIVE_CHARGE_VISITOR_LICENSE", "DEBUG_RESET_LIVE_FANS_CLUB_RED_DOT", "getDEBUG_RESET_LIVE_FANS_CLUB_RED_DOT", "setDEBUG_RESET_LIVE_FANS_CLUB_RED_DOT", "DEBUG_RESET_LIVE_MODE_GUIDE", "getDEBUG_RESET_LIVE_MODE_GUIDE", "setDEBUG_RESET_LIVE_MODE_GUIDE", "DEBUG_RESET_LIVE_VISITOR_GAME_RANK_GUIDE", "getDEBUG_RESET_LIVE_VISITOR_GAME_RANK_GUIDE", "setDEBUG_RESET_LIVE_VISITOR_GAME_RANK_GUIDE", "DEBUG_RESET_LIVE_VISITOR_GAME_RANK_PERMISSION", "getDEBUG_RESET_LIVE_VISITOR_GAME_RANK_PERMISSION", "setDEBUG_RESET_LIVE_VISITOR_GAME_RANK_PERMISSION", "DEBUG_RESET_LIVE_VISITOR_ROLE_GUIDE", "getDEBUG_RESET_LIVE_VISITOR_ROLE_GUIDE", "setDEBUG_RESET_LIVE_VISITOR_ROLE_GUIDE", "DEBUG_RESET_LIVE_VR_MODE_GUIDE", "getDEBUG_RESET_LIVE_VR_MODE_GUIDE", "setDEBUG_RESET_LIVE_VR_MODE_GUIDE", "DEBUG_RESET_LIVE_VR_TIP_GUIDE", "getDEBUG_RESET_LIVE_VR_TIP_GUIDE", "setDEBUG_RESET_LIVE_VR_TIP_GUIDE", "ERASE_LIVE_DECRYPT_BEFORE_PLAY", "getERASE_LIVE_DECRYPT_BEFORE_PLAY", "FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", "getFINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", "FINDER_ENTER_VISITOR_PRELOAD_CORE", "getFINDER_ENTER_VISITOR_PRELOAD_CORE", "FINDER_LIVE", "", "getFINDER_LIVE", "()Z", "FINDER_LIVE_ACTIVITY_AT_LIVE_ENTRANCE_CARD", "getFINDER_LIVE_ACTIVITY_AT_LIVE_ENTRANCE_CARD", "FINDER_LIVE_ACTIVITY_AT_LIVE_SHARED_CARD", "getFINDER_LIVE_ACTIVITY_AT_LIVE_SHARED_CARD", "FINDER_LIVE_ADD_TO_HISTORY_OFFSET", "getFINDER_LIVE_ADD_TO_HISTORY_OFFSET", "FINDER_LIVE_ANCHOR_AUDIO_BREAK_THRESHOLD", "getFINDER_LIVE_ANCHOR_AUDIO_BREAK_THRESHOLD", "FINDER_LIVE_ANCHOR_BATTERY_TEMPERATURE_THRESHOLD", "getFINDER_LIVE_ANCHOR_BATTERY_TEMPERATURE_THRESHOLD", "FINDER_LIVE_ANCHOR_BREAK_AUDIO_DURATION_THRESHOLD", "getFINDER_LIVE_ANCHOR_BREAK_AUDIO_DURATION_THRESHOLD", "FINDER_LIVE_ANCHOR_DRIECTOR_START_FROM_MINIWINDOW", "getFINDER_LIVE_ANCHOR_DRIECTOR_START_FROM_MINIWINDOW", "setFINDER_LIVE_ANCHOR_DRIECTOR_START_FROM_MINIWINDOW", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;)V", "FINDER_LIVE_ANCHOR_MUSIC_CLICK_TEST", "getFINDER_LIVE_ANCHOR_MUSIC_CLICK_TEST", "FINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", "getFINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", "setFINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", "FINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", "getFINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", "setFINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", "FINDER_LIVE_ANCHOR_NET_SPEED_TEST_INTERVAL", "getFINDER_LIVE_ANCHOR_NET_SPEED_TEST_INTERVAL", "FINDER_LIVE_ANCHOR_NET_SPEED_TEST_THRESHOLD", "getFINDER_LIVE_ANCHOR_NET_SPEED_TEST_THRESHOLD", "FINDER_LIVE_ANCHOR_OVERFLOW_AUDIO_DURATION_THRESHOLD", "getFINDER_LIVE_ANCHOR_OVERFLOW_AUDIO_DURATION_THRESHOLD", "FINDER_LIVE_ANCHOR_SILENT_AUDIO_DURATION_THRESHOLD", "getFINDER_LIVE_ANCHOR_SILENT_AUDIO_DURATION_THRESHOLD", "FINDER_LIVE_APPLAUD_LOCAL", "getFINDER_LIVE_APPLAUD_LOCAL", "FINDER_LIVE_APPLAUD_TIPS_ALWAYS", "getFINDER_LIVE_APPLAUD_TIPS_ALWAYS", "FINDER_LIVE_ASYCN_LOAD_PAG", "getFINDER_LIVE_ASYCN_LOAD_PAG", "FINDER_LIVE_AUDIO_MODE_ENABLE", "getFINDER_LIVE_AUDIO_MODE_ENABLE", "FINDER_LIVE_BEAUTY_ENABLE", "getFINDER_LIVE_BEAUTY_ENABLE", "FINDER_LIVE_BULLET_COMMENT_LIMIT_NUM", "getFINDER_LIVE_BULLET_COMMENT_LIMIT_NUM", "()I", "FINDER_LIVE_CAST_SCREEN_ENABLE", "getFINDER_LIVE_CAST_SCREEN_ENABLE", "FINDER_LIVE_CHARGE_FREE_TIME_SECOND", "getFINDER_LIVE_CHARGE_FREE_TIME_SECOND", "FINDER_LIVE_CHARGE_RESTART_AFTER_PAY", "getFINDER_LIVE_CHARGE_RESTART_AFTER_PAY", "FINDER_LIVE_CLICK_AVATAR_ENTER_APPLAUD", "getFINDER_LIVE_CLICK_AVATAR_ENTER_APPLAUD", "FINDER_LIVE_COMMENT_POI_SEND_MIN_INTERVAL", "", "getFINDER_LIVE_COMMENT_POI_SEND_MIN_INTERVAL", "FINDER_LIVE_COMMENT_SIZE_LIMIT", "getFINDER_LIVE_COMMENT_SIZE_LIMIT", "FINDER_LIVE_COUPLETS_TIP_RESET", "getFINDER_LIVE_COUPLETS_TIP_RESET", "setFINDER_LIVE_COUPLETS_TIP_RESET", "FINDER_LIVE_DECORATION_BG_INTERVAL", "getFINDER_LIVE_DECORATION_BG_INTERVAL", "setFINDER_LIVE_DECORATION_BG_INTERVAL", "FINDER_LIVE_DEFINITION_LEVEL", "getFINDER_LIVE_DEFINITION_LEVEL", "setFINDER_LIVE_DEFINITION_LEVEL", "FINDER_LIVE_ENABLE_ANCHOR_MUSIC", "getFINDER_LIVE_ENABLE_ANCHOR_MUSIC", "FINDER_LIVE_ENABLE_PRELOAD", "getFINDER_LIVE_ENABLE_PRELOAD", "FINDER_LIVE_EXPIRE_WATCH_HISTORY_DURATION", "getFINDER_LIVE_EXPIRE_WATCH_HISTORY_DURATION", "FINDER_LIVE_EXPIRE_WATCH_HISTORY_MAX_COUNT", "getFINDER_LIVE_EXPIRE_WATCH_HISTORY_MAX_COUNT", "FINDER_LIVE_FAST_COMMENT_ENABLE", "getFINDER_LIVE_FAST_COMMENT_ENABLE", "setFINDER_LIVE_FAST_COMMENT_ENABLE", "FINDER_LIVE_FEED_CACHE_DURATION", "getFINDER_LIVE_FEED_CACHE_DURATION", "FINDER_LIVE_FEED_FLOW_VALID_WATCH_TIME_THRESHOLD", "getFINDER_LIVE_FEED_FLOW_VALID_WATCH_TIME_THRESHOLD", "FINDER_LIVE_FEED_SECURE_SWITCH", "getFINDER_LIVE_FEED_SECURE_SWITCH", "setFINDER_LIVE_FEED_SECURE_SWITCH", "FINDER_LIVE_FILTER_ANCHOR_EXT_FLAG", "getFINDER_LIVE_FILTER_ANCHOR_EXT_FLAG", "FINDER_LIVE_FILTER_ENABLE", "getFINDER_LIVE_FILTER_ENABLE", "FINDER_LIVE_FILTER_OUTDATED_RESP", "getFINDER_LIVE_FILTER_OUTDATED_RESP", "setFINDER_LIVE_FILTER_OUTDATED_RESP", "FINDER_LIVE_FILTER_VISITOR_RESET_ONLOIN_VALUE", "getFINDER_LIVE_FILTER_VISITOR_RESET_ONLOIN_VALUE", "FINDER_LIVE_FILTER_VISITOR_ZERO_LIKE_VALUE", "getFINDER_LIVE_FILTER_VISITOR_ZERO_LIKE_VALUE", "FINDER_LIVE_FINDER_LIVE_ALLOWANCE_DEBUG", "getFINDER_LIVE_FINDER_LIVE_ALLOWANCE_DEBUG", "FINDER_LIVE_FORCE_HAS_OVERLAPPING_RENDERING", "getFINDER_LIVE_FORCE_HAS_OVERLAPPING_RENDERING", "FINDER_LIVE_FRONT_RENDER_MIRROR", "getFINDER_LIVE_FRONT_RENDER_MIRROR", "FINDER_LIVE_GAME_TEAM_SUBSCRIBE_CLEAR_CONFIG", "getFINDER_LIVE_GAME_TEAM_SUBSCRIBE_CLEAR_CONFIG", "FINDER_LIVE_GETLIVEMSG_TEST", "getFINDER_LIVE_GETLIVEMSG_TEST", "FINDER_LIVE_GET_COMMENT_DURATION", "getFINDER_LIVE_GET_COMMENT_DURATION", "FINDER_LIVE_GIFT_ANIM_STAY_DURATION", "getFINDER_LIVE_GIFT_ANIM_STAY_DURATION", "FINDER_LIVE_GIFT_COMBOID_LIVE_TIME", "getFINDER_LIVE_GIFT_COMBOID_LIVE_TIME", "FINDER_LIVE_GIFT_FULL_PAG_DEFAULT_DURATION", "getFINDER_LIVE_GIFT_FULL_PAG_DEFAULT_DURATION", "FINDER_LIVE_GIFT_HIDE_TIP_GUIDE", "getFINDER_LIVE_GIFT_HIDE_TIP_GUIDE", "setFINDER_LIVE_GIFT_HIDE_TIP_GUIDE", "FINDER_LIVE_GIFT_QUEUE_FLUSH_MAIN_THREAD_BELOW_API25", "getFINDER_LIVE_GIFT_QUEUE_FLUSH_MAIN_THREAD_BELOW_API25", "FINDER_LIVE_GIFT_QUEUE_MAX_SIZE", "getFINDER_LIVE_GIFT_QUEUE_MAX_SIZE", "FINDER_LIVE_GIFT_QUEUE_NICKNAME_LENGTH", "getFINDER_LIVE_GIFT_QUEUE_NICKNAME_LENGTH", "FINDER_LIVE_GUIDE_ENABLE", "getFINDER_LIVE_GUIDE_ENABLE", "FINDER_LIVE_HEART_BEAT_GUARD_INTERVAL", "getFINDER_LIVE_HEART_BEAT_GUARD_INTERVAL", "setFINDER_LIVE_HEART_BEAT_GUARD_INTERVAL", "FINDER_LIVE_HEAT_USE_NEW", "getFINDER_LIVE_HEAT_USE_NEW", "FINDER_LIVE_HEVC_ENC_ENABLE_SWITCH", "getFINDER_LIVE_HEVC_ENC_ENABLE_SWITCH", "FINDER_LIVE_HEVC_ENC_FORCE_MIXING", "getFINDER_LIVE_HEVC_ENC_FORCE_MIXING", "FINDER_LIVE_KEEP_ALIVE_GUARD_ENABLE", "getFINDER_LIVE_KEEP_ALIVE_GUARD_ENABLE", "setFINDER_LIVE_KEEP_ALIVE_GUARD_ENABLE", "FINDER_LIVE_LANDSCAPE", "getFINDER_LIVE_LANDSCAPE", "FINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", "getFINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", "setFINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", "FINDER_LIVE_LINK_MIC_ENABLE", "getFINDER_LIVE_LINK_MIC_ENABLE", "FINDER_LIVE_LIST_AUTO_PLAY", "getFINDER_LIVE_LIST_AUTO_PLAY", "setFINDER_LIVE_LIST_AUTO_PLAY", "FINDER_LIVE_LIST_CREATE_DEBUG_DATA", "getFINDER_LIVE_LIST_CREATE_DEBUG_DATA", "FINDER_LIVE_LIST_ENABLE_MORE_LIVE", "getFINDER_LIVE_LIST_ENABLE_MORE_LIVE", "FINDER_LIVE_LIST_PRELOAD_THRESHOLD", "getFINDER_LIVE_LIST_PRELOAD_THRESHOLD", "FINDER_LIVE_LOCAL_PUSH_STREAM_ENABLE", "getFINDER_LIVE_LOCAL_PUSH_STREAM_ENABLE", "setFINDER_LIVE_LOCAL_PUSH_STREAM_ENABLE", "FINDER_LIVE_LOTTERY", "getFINDER_LIVE_LOTTERY", "FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", "getFINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", "FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", "getFINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", "FINDER_LIVE_LOTTERY_DURATION", "getFINDER_LIVE_LOTTERY_DURATION", "FINDER_LIVE_LOTTERY_FOLLOW_TIPS", "getFINDER_LIVE_LOTTERY_FOLLOW_TIPS", "FINDER_LIVE_LOTTERY_SAVEID_SIZE", "getFINDER_LIVE_LOTTERY_SAVEID_SIZE", "FINDER_LIVE_LOTTERY_UPDATE_STRATEGY", "getFINDER_LIVE_LOTTERY_UPDATE_STRATEGY", "FINDER_LIVE_LUCKY_MONEY_CHATROOM_ENTRANCE_GUIDE", "", "getFINDER_LIVE_LUCKY_MONEY_CHATROOM_ENTRANCE_GUIDE", "setFINDER_LIVE_LUCKY_MONEY_CHATROOM_ENTRANCE_GUIDE", "FINDER_LIVE_LUCKY_MONEY_CHATROOM_TEST", "getFINDER_LIVE_LUCKY_MONEY_CHATROOM_TEST", "setFINDER_LIVE_LUCKY_MONEY_CHATROOM_TEST", "FINDER_LIVE_LUCKY_MONEY_FINDER_CONFIRM_GUIDE", "getFINDER_LIVE_LUCKY_MONEY_FINDER_CONFIRM_GUIDE", "setFINDER_LIVE_LUCKY_MONEY_FINDER_CONFIRM_GUIDE", "FINDER_LIVE_MANUAL_CRASH", "getFINDER_LIVE_MANUAL_CRASH", "FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", "getFINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", "FINDER_LIVE_MOCK_COUPLETS_SNS", "getFINDER_LIVE_MOCK_COUPLETS_SNS", "setFINDER_LIVE_MOCK_COUPLETS_SNS", "FINDER_LIVE_MOCK_GALA", "getFINDER_LIVE_MOCK_GALA", "setFINDER_LIVE_MOCK_GALA", "FINDER_LIVE_MORE_ACTION_BTN_STYLE", "getFINDER_LIVE_MORE_ACTION_BTN_STYLE", "FINDER_LIVE_MSG_BADGE_DEBUG", "getFINDER_LIVE_MSG_BADGE_DEBUG", "FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", "getFINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", "FINDER_LIVE_MSG_SEND_LOCAL_GIFT", "getFINDER_LIVE_MSG_SEND_LOCAL_GIFT", "FINDER_LIVE_MULTI_NOTICE_ENABLE", "getFINDER_LIVE_MULTI_NOTICE_ENABLE", "setFINDER_LIVE_MULTI_NOTICE_ENABLE", "FINDER_LIVE_NEW_ENTRANCE", "getFINDER_LIVE_NEW_ENTRANCE", "FINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG", "getFINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG", "FINDER_LIVE_NOTICE_TIME", "getFINDER_LIVE_NOTICE_TIME", "FINDER_LIVE_OLYMPIC_RESERVE_GUIDE_ENABLE", "getFINDER_LIVE_OLYMPIC_RESERVE_GUIDE_ENABLE", "FINDER_LIVE_POLLING_MERGE_INTERVAL", "getFINDER_LIVE_POLLING_MERGE_INTERVAL", "FINDER_LIVE_POOR_NETWORK_QUALITY_THRESHOLD", "getFINDER_LIVE_POOR_NETWORK_QUALITY_THRESHOLD", "FINDER_LIVE_PRECHECK_ENTRANCE", "getFINDER_LIVE_PRECHECK_ENTRANCE", "FINDER_LIVE_PRELOAD_LIVE_SDK_INFO", "getFINDER_LIVE_PRELOAD_LIVE_SDK_INFO", "setFINDER_LIVE_PRELOAD_LIVE_SDK_INFO", "FINDER_LIVE_PRE_PLAY", "getFINDER_LIVE_PRE_PLAY", "FINDER_LIVE_REAL_HISTORY_GUIDE_ENABLE", "getFINDER_LIVE_REAL_HISTORY_GUIDE_ENABLE", "FINDER_LIVE_RECORD_DURATION_LIMIT", "getFINDER_LIVE_RECORD_DURATION_LIMIT", "setFINDER_LIVE_RECORD_DURATION_LIMIT", "FINDER_LIVE_REFRESH_DURATION", "getFINDER_LIVE_REFRESH_DURATION", "FINDER_LIVE_REPLAY_RESTART_AFTER_PAY", "getFINDER_LIVE_REPLAY_RESTART_AFTER_PAY", "FINDER_LIVE_RESET_GAME_PROTOCOL", "getFINDER_LIVE_RESET_GAME_PROTOCOL", "setFINDER_LIVE_RESET_GAME_PROTOCOL", "FINDER_LIVE_REWARD_MEMBER", "getFINDER_LIVE_REWARD_MEMBER", "FINDER_LIVE_RV_FEED_ENABLE_PRELOAD", "getFINDER_LIVE_RV_FEED_ENABLE_PRELOAD", "FINDER_LIVE_SECURE_SWITCH", "getFINDER_LIVE_SECURE_SWITCH", "setFINDER_LIVE_SECURE_SWITCH", "FINDER_LIVE_SEI_ENABLE_SWITCH", "getFINDER_LIVE_SEI_ENABLE_SWITCH", "FINDER_LIVE_SEND_LOCATION_GUIDE_CONFIG", "getFINDER_LIVE_SEND_LOCATION_GUIDE_CONFIG", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE", "getFINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE", "FINDER_LIVE_SHOPPING_HEIGHT_PERCENT", "getFINDER_LIVE_SHOPPING_HEIGHT_PERCENT", "FINDER_LIVE_SHOPPING_PICTURE_MAX_SIZE", "getFINDER_LIVE_SHOPPING_PICTURE_MAX_SIZE", "setFINDER_LIVE_SHOPPING_PICTURE_MAX_SIZE", "(I)V", "FINDER_LIVE_SHOPPING_RECOMMEND_FILTER", "getFINDER_LIVE_SHOPPING_RECOMMEND_FILTER", "FINDER_LIVE_SHOPPING_SET_RECOMMEND", "getFINDER_LIVE_SHOPPING_SET_RECOMMEND", "FINDER_LIVE_SHOPPING_THREAD_PARTY_STRATEGY", "getFINDER_LIVE_SHOPPING_THREAD_PARTY_STRATEGY", "FINDER_LIVE_SHPOPPING_PICTURE_CONFIG", "getFINDER_LIVE_SHPOPPING_PICTURE_CONFIG", "FINDER_LIVE_SIDEBAR_SWITCH", "getFINDER_LIVE_SIDEBAR_SWITCH", "setFINDER_LIVE_SIDEBAR_SWITCH", "FINDER_LIVE_SKIP_REAL_NAME", "getFINDER_LIVE_SKIP_REAL_NAME", "setFINDER_LIVE_SKIP_REAL_NAME", "FINDER_LIVE_STATISTICS_FREQUENCY", "getFINDER_LIVE_STATISTICS_FREQUENCY", "FINDER_LIVE_TICKLE_ENABLE", "getFINDER_LIVE_TICKLE_ENABLE", "FINDER_LIVE_VISIBLITY_DEBUG_DATA", "getFINDER_LIVE_VISIBLITY_DEBUG_DATA", "FINDER_LIVE_VISIBLITY_ENTRANCE", "getFINDER_LIVE_VISIBLITY_ENTRANCE", "FINDER_LIVE_VISITOR_MAX_RETRY_COUNT", "getFINDER_LIVE_VISITOR_MAX_RETRY_COUNT", "FINDER_LIVE_VISITOR_MODE", "getFINDER_LIVE_VISITOR_MODE", "FINDER_LIVE_VISITOR_RETRY_TINTERVAL", "getFINDER_LIVE_VISITOR_RETRY_TINTERVAL", "FINDER_LIVE_VISITOR_ROLE_ENTRANCE", "getFINDER_LIVE_VISITOR_ROLE_ENTRANCE", "FINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", "getFINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", "FINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", "getFINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", "FINDER_LIVE_VR_MODE_ENABLE", "getFINDER_LIVE_VR_MODE_ENABLE", "FINDER_LIVE_WX_PAY_REAL_NAME", "getFINDER_LIVE_WX_PAY_REAL_NAME", "setFINDER_LIVE_WX_PAY_REAL_NAME", "FINDER_NEARBY_INVOKE_START_PRELOAD", "getFINDER_NEARBY_INVOKE_START_PRELOAD", "FINDER_NEARBY_LIVE_AUTO_PLAY_MUTE", "getFINDER_NEARBY_LIVE_AUTO_PLAY_MUTE", "FINDER_NEARBY_LIVE_AUTO_PLAY_TEST", "getFINDER_NEARBY_LIVE_AUTO_PLAY_TEST", "FINDER_NEARBY_LIVE_AUTO_PLAY_TEST_NEW", "getFINDER_NEARBY_LIVE_AUTO_PLAY_TEST_NEW", "FINDER_NEARBY_LIVE_CARD_AUTO_PLAY", "getFINDER_NEARBY_LIVE_CARD_AUTO_PLAY", "FINDER_NEARBY_LIVE_ENABLE_REDDOT_ANIMATION", "getFINDER_NEARBY_LIVE_ENABLE_REDDOT_ANIMATION", "FINDER_NEARBY_LIVE_FRIENDS", "getFINDER_NEARBY_LIVE_FRIENDS", "FINDER_NEARBY_LIVE_FRIENDS_NEW_DOT_CONFIG", "getFINDER_NEARBY_LIVE_FRIENDS_NEW_DOT_CONFIG", "FINDER_NEARBY_LIVE_FRIENDS_TOTAL", "getFINDER_NEARBY_LIVE_FRIENDS_TOTAL", "FINDER_NEARBY_LIVE_PAGES_PRELOAD", "getFINDER_NEARBY_LIVE_PAGES_PRELOAD", "FINDER_NEARBY_LIVE_PULL_SIMILAR", "getFINDER_NEARBY_LIVE_PULL_SIMILAR", "FINDER_NEARBY_REDDOT_START_PRELOAD", "getFINDER_NEARBY_REDDOT_START_PRELOAD", "FINDER_NEARBY_REDDOT_TO_TARGET_LIVE_ROOM", "getFINDER_NEARBY_REDDOT_TO_TARGET_LIVE_ROOM", "FINDER_NEARBY_SQUARE_TABS_PRELOAD", "getFINDER_NEARBY_SQUARE_TABS_PRELOAD", "FINDER_RESET_LIVE_FIRST_REWARD", "getFINDER_RESET_LIVE_FIRST_REWARD", "Finder_LIVE_GIFT_ENABLE", "getFinder_LIVE_GIFT_ENABLE", "setFinder_LIVE_GIFT_ENABLE", "GALA_HINT_CONFIG", "getGALA_HINT_CONFIG", "value", "LIVE_GAME_LICENSE", "getLIVE_GAME_LICENSE", "setLIVE_GAME_LICENSE", "LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "getLIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "setLIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "LIVE_GIFT_DEBUG", "getLIVE_GIFT_DEBUG", "setLIVE_GIFT_DEBUG", "LIVE_GIFT_MOCK_DEBUG", "getLIVE_GIFT_MOCK_DEBUG", "setLIVE_GIFT_MOCK_DEBUG", "LIVE_LICENSE", "getLIVE_LICENSE", "setLIVE_LICENSE", "LIVE_POST_TIPS", "getLIVE_POST_TIPS", "LIVE_TASK_TIPS_RESET", "getLIVE_TASK_TIPS_RESET", "LIVE_USER_MAX_COUNT", "getLIVE_USER_MAX_COUNT", "OLYMPICS_RES_VERSION_CONFIG", "getOLYMPICS_RES_VERSION_CONFIG", "TAG", "TIGER_LINK_STATUS", "getTIGER_LINK_STATUS", "setTIGER_LINK_STATUS", "TIGER_POST_STATUS", "getTIGER_POST_STATUS", "setTIGER_POST_STATUS", "debugFinderLive", "getDebugFinderLive", "debugFinderLiveGameWeAppTest", "getDebugFinderLiveGameWeAppTest", "debugFinderLiveLandscape", "getDebugFinderLiveLandscape", "debugFinderLiveLottery", "getDebugFinderLiveLottery", "debugFinderLiveMiniProTest", "getDebugFinderLiveMiniProTest", "debugFinderLiveThreadPartyShoppingStrategy", "getDebugFinderLiveThreadPartyShoppingStrategy", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> FGs;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> FGt;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> FGu;
  public static final a ahiX;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahiY;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahiZ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjA;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjB;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjC;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjD;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjE;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjF;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjG;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjH;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjI;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjJ;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjK;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Boolean> ahjL;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjM;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjN;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjO;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjP;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjQ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjR;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjS;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> ahjT;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjU;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjV;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjW;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjX;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjY;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjZ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahja;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> ahjb;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> ahjc;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> ahjd;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> ahje;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjf;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjg;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjh;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahji;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjj;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjk;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjl;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahjm;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjn;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahjo;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjp;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjq;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjr;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjs;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjt;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahju;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjv;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjw;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahjx;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<String> ahjy;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahjz;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkA;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkB;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkC;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkD;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkE;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkF;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkG;
  private static com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahkH;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkI;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkJ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkK;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkL;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkM;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkN;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkO;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkP;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkQ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahkR;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahkS;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahkT;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkU;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkV;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkW;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkX;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> ahkY;
  private static final com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahkZ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahka;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkb;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkc;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkd;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahke;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkf;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkg;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkh;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahki;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkj;
  private static int ahkk;
  private static final com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahkl;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkm;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkn;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahko;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkp;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkq;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkr;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahks;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkt;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahku;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahkv;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkw;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkx;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahky;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahkz;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlA;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlB;
  private static final com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahlC;
  private static final com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahlD;
  private static final com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahlE;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahlF;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahlG;
  private static com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahlH;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlI;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlJ;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahlK;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahlL;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlM;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlN;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c ahlO;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlP;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlQ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlR;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlS;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlT;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlU;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlV;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlW;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlX;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlY;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlZ;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahla;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlb;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlc;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahld;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahle;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlf;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlg;
  private static final com.tencent.mm.plugin.findersdk.storage.config.a.a.a ahlh;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahli;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlj;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlk;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahll;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlm;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahln;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlo;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlp;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlq;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlr;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahls;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlt;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlu;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlv;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlw;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahlx;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahly;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c ahlz;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> ahma;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahmb;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.c akmL;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.c akmM;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> akmN;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> akmO;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> akmP;
  private static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> akmQ;
  
  static
  {
    AppMethodBeat.i(218029);
    ahiX = new a();
    ahiY = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(15, "直播添加进历史准入时间偏移").d(com.tencent.mm.plugin.expt.b.c.a.zcM);
    ahiZ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播间红包入口").c("FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), p.listOf(new String[] { "默认", "不允许", "允许-非节日", "允许-节日" }));
    ahja = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否用新热度值").d(com.tencent.mm.plugin.expt.b.c.a.yHn).c("FINDER_LIVE_HEAT_USE_NEW", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "否", "是" })).aDm("T6");
    ahjb = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播红包H5", (kotlin.g.a.b)a.p.ahmr).aDm("T5");
    ahjc = new com.tencent.mm.plugin.findersdk.storage.config.base.c("直播红包测试", (kotlin.g.a.b)a.q.ahms).aDm("T5");
    ahjd = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置身份确认半屏", (kotlin.g.a.b)a.r.ahmt).aDm("T5");
    ahje = new com.tencent.mm.plugin.findersdk.storage.config.a.c.a(10000L, "直播心跳手动复苏时间间隔").d(com.tencent.mm.plugin.expt.b.c.a.yZg);
    ahjf = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播保活手动复苏开关").d(com.tencent.mm.plugin.expt.b.c.a.yZh);
    ahjg = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播快捷评论开关").d(com.tencent.mm.plugin.expt.b.c.a.yZi).c("FINDER_LIVE_FAST_COMMENT_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "否", "是" }));
    ahjh = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否允许主播开启音乐").d(com.tencent.mm.plugin.expt.b.c.a.yHo).c("FINDER_LIVE_ENABLE_ANCHOR_MUSIC", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahji = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "主播音量调节快捷区域test").d(com.tencent.mm.plugin.expt.b.c.a.yHp).c("FINDER_LIVE_ANCHOR_MUSIC_CLICK_TEST", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahjj = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1000, "主播音乐数量上限").d(com.tencent.mm.plugin.expt.b.c.a.yHr).c("FINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", p.listOf(new Integer[] { Integer.valueOf(50), Integer.valueOf(100), Integer.valueOf(1000) }), p.listOf(new String[] { "50首", "100首", "1000首" }));
    ahjk = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(40, "主播背景音乐初始音量").d(com.tencent.mm.plugin.expt.b.c.a.yHs).c("FINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", p.listOf(new Integer[] { Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(60) }), p.listOf(new String[] { "20", "40", "60" }));
    ahjl = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否异步load pag").d(com.tencent.mm.plugin.expt.b.c.a.yHq).c("FINDER_LIVE_ASYCN_LOAD_PAG", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahjm = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播模式选择教育页", (kotlin.g.a.b)a.h.ahmj);
    ahjn = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "视频号直播音频模式开关").d(com.tencent.mm.plugin.expt.b.c.a.yZl);
    ahjo = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置是否第一次获得直播打赏", (kotlin.g.a.b)a.x.ahmz);
    ahjp = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "视频号直播投屏开关").d(com.tencent.mm.plugin.expt.b.c.a.yZk);
    ahjq = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播冬奥开幕式预约指引开关").c("FINDER_LIVE_OLYMPIC_RESERVE_GUIDE_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" }));
    ahjr = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-直播卡片自动播放").c("FINDER_NEARBY_LIVE_CARD_AUTO_PLAY", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcK);
    ahjs = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-红点命中执行放大动画").c("FINDER_NEARBY_LIVE_ENABLE_REDDOT_ANIMATION", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcL);
    ahjt = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-点击红点跳转直播间").c("FINDER_NEARBY_REDDOT_TO_TARGET_LIVE_ROOM", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcJ);
    FGs = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-红点触发预加载").c("FINDER_NEARBY_REDDOT_START_PRELOAD", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcF);
    FGt = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-根据指定条件触发预加载").c("FINDER_NEARBY_INVOKE_START_PRELOAD", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcG);
    FGu = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-预加载直播广场tab列表").c("FINDER_NEARBY_SQUARE_TABS_PRELOAD", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcH);
    ahju = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-在直播广场当前页加载好后，预加载直播广场其他页").c("FINDER_NEARBY_LIVE_PAGES_PRELOAD", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "开启" })).d(com.tencent.mm.plugin.expt.b.c.a.zcI);
    ahjv = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-自动播放实验组").d(com.tencent.mm.plugin.expt.b.c.a.zbL).c("FINDER_NEARBY_LIVE_AUTO_PLAY_TEST", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }), p.listOf(new String[] { "实验1", "实验2", "实验3", "实验4", "实验5" })).aDm("2021T1");
    ahjw = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-自动播放实验组").d(com.tencent.mm.plugin.expt.b.c.a.zbM).c("FINDER_NEARBY_LIVE_AUTO_PLAY_TEST", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), p.listOf(new String[] { "实验1", "实验2" })).aDm("2021T1");
    ahjx = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播和附近-直播是否打开声音").c("FINDER_NEARBY_LIVE_AUTO_PLAY_MUTE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).d(com.tencent.mm.plugin.expt.b.c.a.zbN);
    ahjy = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除附近的直播和人的NEW红点", (kotlin.g.a.b)a.w.ahmy).aDm("T32");
    ahjz = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除直播新手引导标记(上滑&下滑)", (kotlin.g.a.b)a.s.ahmu);
    ahjA = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播上滑新手引导开关").d(com.tencent.mm.plugin.expt.b.c.a.zdv).c("FINDER_LIVE_GUIDE_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32_next");
    ahjB = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播下滑（进历史）新手引导开关").d(com.tencent.mm.plugin.expt.b.c.a.zdw).c("FINDER_LIVE_REAL_HISTORY_GUIDE_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" }));
    ahjC = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "视频号直播前置摄像头渲染镜像开关").d(com.tencent.mm.plugin.expt.b.c.a.zsg).aDm("T32");
    ahjD = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播是否打开拍一拍").d(com.tencent.mm.plugin.expt.b.c.a.zdl).c("FINDER_LIVE_TICKLE_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjE = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播美颜开关").d(com.tencent.mm.plugin.expt.b.c.a.zdn).c("FINDER_LIVE_BEAUTY_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjF = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播滤镜开关").d(com.tencent.mm.plugin.expt.b.c.a.zdo).c("FINDER_LIVE_FILTER_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjG = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播连麦是否打开").d(com.tencent.mm.plugin.expt.b.c.a.zdp).c("FINDER_LIVE_LINK_MIC_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjH = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "打开附近的直播和人").d(com.tencent.mm.plugin.expt.b.c.a.zdq).c("FINDER_NEARBY_LIVE_FRIENDS", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjI = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "打开附近的直播和人-强制").d(com.tencent.mm.plugin.expt.b.c.a.zdr).c("FINDER_NEARBY_LIVE_FRIENDS", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjJ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播Feed下拉出相似流").d(com.tencent.mm.plugin.expt.b.c.a.zds).c("FINDER_NEARBY_LIVE_PULL_SIMILAR", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("T32");
    ahjK = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播礼物连击生成相同comboId").c("FINDER_LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "打开", "关闭" }));
    ahjL = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "直播礼物打赏mock工具是否打开").c("FINDER_LIVE_GIFT_MOCK_DEBUG", p.listOf(new Boolean[] { Boolean.TRUE, Boolean.FALSE }), p.listOf(new String[] { "打开", "关闭" }));
    ahjM = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播礼物debug").c("FINDER_LIVE_GIFT_DEBUG", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "打开", "关闭" }));
    ahjN = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播礼物开关").d(com.tencent.mm.plugin.expt.b.c.a.zsA).c("FINDER_LIVE_GIFT_ENABLE", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "打开", "关闭" })).aDm("T32");
    ahjO = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(3, "抽奖时长上限(秒)").d(com.tencent.mm.plugin.expt.b.c.a.zsB).c("FINDER_LIVE_GIFT_ANIM_STAY_DURATION", p.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(30) }), p.listOf(new String[] { "3秒", "1秒", "10秒", "30秒" })).aDm("T32");
    ahjP = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播送礼通知昵称长度").d(com.tencent.mm.plugin.expt.b.c.a.zsC);
    ahjQ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播礼物小礼物pag flush在api25及以下机型中是否在主线程执行").d(com.tencent.mm.plugin.expt.b.c.a.zsD);
    ahjR = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(10000, "视频号直播送礼队列最大缓存长度").d(com.tencent.mm.plugin.expt.b.c.a.zsE);
    ahjS = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(10, "视频号直播送礼队列聚合id延迟消失时长/秒").d(com.tencent.mm.plugin.expt.b.c.a.zsF);
    ahjT = new com.tencent.mm.plugin.findersdk.storage.config.a.c.a(9000L, "视频号直播送礼大礼物默认播放时长").d(com.tencent.mm.plugin.expt.b.c.a.zsG);
    ahjU = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播打赏模拟上榜").d(com.tencent.mm.plugin.expt.b.c.a.zsS).c("FINDER_LIVE_MSG_BADGE_DEBUG", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(9) }), p.listOf(new String[] { "不上榜", "榜1", "榜2", "榜3", "榜9" }));
    ahjV = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(3, "观众打赏榜单自动刷新间隔/秒").d(com.tencent.mm.plugin.expt.b.c.a.zsT).c("FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(-1) }), p.listOf(new String[] { "0秒", "1秒", "2秒", "3秒", "5秒", "10秒", "不自动刷新" }));
    ahjW = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "过滤观众端因为复用问题的0在线人数").d(com.tencent.mm.plugin.expt.b.c.a.zsU).c("FINDER_LIVE_FILTER_VISITOR_RESET_ONLOIN_VALUE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahjX = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "过滤观众端0人点赞数").d(com.tencent.mm.plugin.expt.b.c.a.zsV).c("FINDER_LIVE_FILTER_VISITOR_ZERO_LIKE_VALUE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahjY = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播打赏是否本地假插").d(com.tencent.mm.plugin.expt.b.c.a.zsW).c("FINDER_LIVE_MSG_SEND_LOCAL_GIFT", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahjZ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "评论列表是否保留自己不超过一半上限的评论数据").d(com.tencent.mm.plugin.expt.b.c.a.zsX).c("FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    com.tencent.mm.plugin.findersdk.storage.config.a.b.a locala = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "视频号直播观众模式");
    e.b localb = e.b.mKf;
    int i = e.b.bct();
    localb = e.b.mKf;
    ahka = locala.c("FINDER_LIVE_VISITOR_MODE", p.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(e.b.bcu()) }), p.listOf(new String[] { "跟随后台", "TRTC", "CDN" })).d(com.tencent.mm.plugin.expt.b.c.a.zcX);
    ahkb = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1000, "直播评论长度限制").d(com.tencent.mm.plugin.expt.b.c.a.zcW).c("FINDER_LIVE_COMMENT_SIZE_LIMIT", p.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(10) }), p.listOf(new String[] { "限制5条", "限制10条" }));
    ahkc = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否使用本地时间创建直播预告").c("FINDER_LIVE_NOTICE_TIME", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "使用服务器时间", "使用本地时间" }));
    ahkd = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否展示开播分组入口").d(com.tencent.mm.plugin.expt.b.c.a.zcY).c("FINDER_LIVE_VISIBLITY_ENTRANCE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahke = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "开播分组分组是否插入假数据").c("FINDER_LIVE_VISIBLITY_DEBUG_DATA", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "否", "是" }));
    ahkf = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否打开观看直播的身份的入口").d(com.tencent.mm.plugin.expt.b.c.a.zcZ).c("FINDER_LIVE_VISITOR_ROLE_ENTRANCE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), p.listOf(new String[] { "打开", "非release打开", "关闭" }));
    ahkg = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否打开主播开播安全引导页的入口").d(com.tencent.mm.plugin.expt.b.c.a.zda).c("FINDER_LIVE_PRECHECK_ENTRANCE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), p.listOf(new String[] { "打开", "非release打开", "关闭" }));
    ahkh = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(28, "观看直播的身份昵称最大长度").d(com.tencent.mm.plugin.expt.b.c.a.zdb).c("FINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", p.listOf(new Integer[] { Integer.valueOf(14), Integer.valueOf(28), Integer.valueOf(32), Integer.valueOf(50) }), p.listOf(new String[] { "14", "28", "32", "50" }));
    ahki = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否过滤自己的头像").d(com.tencent.mm.plugin.expt.b.c.a.zdc).c("FINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahkj = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播购物讲解图片大小").d(com.tencent.mm.plugin.expt.b.c.a.zdd).c("FINDER_LIVE_SHPOPPING_PICTURE_CONFIG", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), p.listOf(new String[] { "10A", "12A", "20A", "30A" }));
    ahkk = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.d.a.a.a.c.a.Edge_12A);
    ahkl = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "直播分享打开单流", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE");
    ahkm = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播抽奖入口").d(com.tencent.mm.plugin.expt.b.c.a.yYO).c("debugFinderLiveLottery", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "打开", "关闭" }));
    ahkn = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(60, "抽奖气泡展示时长(秒)").d(com.tencent.mm.plugin.expt.b.c.a.yYP).c("FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", p.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(5), Integer.valueOf(30), Integer.valueOf(100) }), p.listOf(new String[] { "60秒", "5秒", "30秒", "100秒" })).aDm("T32");
    ahko = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(60, "抽奖中气泡展示时长(秒)").d(com.tencent.mm.plugin.expt.b.c.a.yYQ).c("FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", p.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(5), Integer.valueOf(30), Integer.valueOf(200) }), p.listOf(new String[] { "60秒", "5秒", "30秒", "200秒" })).aDm("T32");
    ahkp = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "抽奖是否使用本地过滤策略(默认使用)").d(com.tencent.mm.plugin.expt.b.c.a.yYS);
    ahkq = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(10, "抽奖本地缓存的已看过抽奖个数").d(com.tencent.mm.plugin.expt.b.c.a.yYT);
    ahkr = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(5, "视频号直播feed缓存时间").d(com.tencent.mm.plugin.expt.b.c.a.yYU);
    ahks = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播是否预加载").d(com.tencent.mm.plugin.expt.b.c.a.yYV).c("FINDER_LIVE_ENABLE_PRELOAD", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahkt = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(2, "视频号直播间切换预加载门槛").d(com.tencent.mm.plugin.expt.b.c.a.yYW).c("FINDER_LIVE_LIST_PRELOAD_SIZE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), p.listOf(new String[] { "0", "1", "2", "3" }));
    ahku = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播getLiveMsg优化test").d(com.tencent.mm.plugin.expt.b.c.a.yYX).c("FINDER_LIVE_GETLIVEMSG_TEST", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahkv = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播是否本地过滤后台下发的extFlag").d(com.tencent.mm.plugin.expt.b.c.a.yYY).c("FINDER_LIVE_FILTER_ANCHOR_EXT_FLAG", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahkw = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播勾选协议", (kotlin.g.a.b)a.b.ahmd);
    ahkx = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置实名认证缓存", (kotlin.g.a.b)a.c.ahme);
    ahky = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置主播音乐引导缓存", (kotlin.g.a.b)a.a.ahmc);
    ahkz = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置profile页商品绑定引导缓存", (kotlin.g.a.b)a.d.ahmf);
    ahkA = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播多身份教育页", (kotlin.g.a.b)a.k.ahmm);
    ahkB = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播粉丝团红点", (kotlin.g.a.b)a.g.ahmi);
    ahkC = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播段位教育页", (kotlin.g.a.b)a.i.ahmk);
    ahkD = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播段位授权页", (kotlin.g.a.b)a.j.ahml);
    ahkE = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置付费直播主播法务协议", (kotlin.g.a.b)a.e.ahmg);
    ahkF = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置付费直播观众法务协议", (kotlin.g.a.b)a.f.ahmh);
    ahkG = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播间列表是否增加额外的child空间").d(com.tencent.mm.plugin.expt.b.c.a.yZq).c("FINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "允许", "不允许" }));
    ahkH = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "打开美颜实时调节器", "FINDER_LIVE_BEAUTY_DEBUG");
    ahkI = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号发布直播").d(com.tencent.mm.plugin.expt.b.c.a.yYy).c("debugFinderLive", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "打开", "关闭" }));
    ahkJ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播第三方购物").d(com.tencent.mm.plugin.expt.b.c.a.yYA).c("debugFinderLiveThreadPartyShoppingStrategy", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "中间页（实验状态）", "详情页（非实验状态）" }));
    ahkK = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播电商设置推荐语").d(com.tencent.mm.plugin.expt.b.c.a.yYC).c("FINDER_LIVE_SHOPPING_SET_RECOMMEND", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahkL = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播电商推荐语过滤emoji").d(com.tencent.mm.plugin.expt.b.c.a.yYD).c("FINDER_LIVE_SHOPPING_RECOMMEND_FILTER", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahkM = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "购物小程序版本").c("FINDER_LIVE_USING_DEBUG_MINIPRO", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), p.listOf(new String[] { "正式版", "测试版", "体验版" }));
    ahkN = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "游戏仿原生版本").c("FINDER_LIVE_GAME_USING_DEBUG_MINIPRO", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), p.listOf(new String[] { "正式版", "测试版", "体验版" }));
    ahkO = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "横向直播").d(com.tencent.mm.plugin.expt.b.c.a.yYz).c("debugFinderLiveLandscape", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "打开", "关闭" }));
    ahkP = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播最多可选可见人数").c("LIVE_USER_MAX_COUNT", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(500) }), p.listOf(new String[] { "不启动", "3", "500" })).aDm("T5");
    ahkQ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播拉取评论时间间隔").d(com.tencent.mm.plugin.expt.b.c.a.zoV);
    ahkR = new com.tencent.mm.plugin.findersdk.storage.config.base.c("主播任务红点重置", (kotlin.g.a.b)a.z.ahmB);
    ahkS = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除直播评论地理位置引导", (kotlin.g.a.b)a.u.ahmw);
    ahkT = new com.tencent.mm.plugin.findersdk.storage.config.base.c("直播发起红点重置", (kotlin.g.a.b)a.y.ahmA);
    ahkU = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播间测试过滤过时的cgi响应").d(com.tencent.mm.plugin.expt.b.c.a.yZv).c("FINDER_LIVE_FILTER_OUTDATED_RESP", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "过滤", "不过滤" }));
    ahkV = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "视频号直播清屏动画优化").d(com.tencent.mm.plugin.expt.b.c.a.yZy);
    ahkW = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(3, "视频号直播网络质量弱网阈值").d(com.tencent.mm.plugin.expt.b.c.a.yZz);
    ahkX = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(3, "feed流中观看直播可以计入uv的观看时间阈值").d(com.tencent.mm.plugin.expt.b.c.a.yZA);
    ahkY = new com.tencent.mm.plugin.findersdk.storage.config.a.c.a(5000L, "直播评论中发送自己的城市位置的最小时间间隔").d(com.tencent.mm.plugin.expt.b.c.a.yZG);
    ahkZ = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "朋友tab直播列表mock数据", "FINDER_LIVE_LIST_CREATE_DEBUG_DATA");
    ahla = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "朋友tab直播列表是否加入更多直播item").d(com.tencent.mm.plugin.expt.b.c.a.yYF).c("FINDER_LIVE_LIST_ENABLE_MORE_LIVE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlb = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "视频号直播上下切换是否预热feed").d(com.tencent.mm.plugin.expt.b.c.a.yYZ).c("FINDER_LIVE_RV_FEED_ENABLE_PRELOAD", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlc = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(15, "视频号直播历史多少的停留时长能加入到历史列表(ms)").d(com.tencent.mm.plugin.expt.b.c.a.zww).c("FINDER_LIVE_EXPIRE_WATCH_HISTORY_DURATION", p.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(15), Integer.valueOf(30) }), p.listOf(new String[] { "5s", "15s", "30s" }));
    ahld = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(5, "视频号直播历史最多能有多少个历史直播").d(com.tencent.mm.plugin.expt.b.c.a.zwx).c("FINDER_LIVE_EXPIRE_WATCH_HISTORY_MAX_COUNT", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(5), Integer.valueOf(30) }), p.listOf(new String[] { "0个", "5个", "30个" }));
    ahle = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播列表是否允许自动播放").d(com.tencent.mm.plugin.expt.b.c.a.yZt).c("FINDER_LIVE_LIST_AUTO_PLAY", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlf = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "最近打赏列表人数").c("FINDER_LIVE_REWARD_MEMBER", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), p.listOf(new String[] { "不设置", "3个", "14个", "40个" }));
    ahlg = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播是否使用LiveSdkInfo预热").d(com.tencent.mm.plugin.expt.b.c.a.yZu).c("FINDER_LIVE_PRELOAD_LIVE_SDK_INFO", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlh = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "开播后5s触发一个crash", "FINDER_LIVE_MANUAL_CRASH");
    ahli = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "新广场首页开关").d(com.tencent.mm.plugin.expt.b.c.a.zwk).c("FINDER_LIVE_ACTIVITY_AT_LIVE_ENTRANCE_CARD", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahlj = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "活动状态 icon 是否在广场 feed 流中启用").d(com.tencent.mm.plugin.expt.b.c.a.zwl).c("FINDER_LIVE_ACTIVITY_AT_LIVE_ENTRANCE_CARD", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahlk = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "活动状态 icon 是否在分享场景中启用").d(com.tencent.mm.plugin.expt.b.c.a.zwm).c("FINDER_LIVE_ACTIVITY_AT_LIVE_SHARED_CARD", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahll = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "礼包掉落假开关。启用必现入口").d(com.tencent.mm.plugin.expt.b.c.a.zwn).c("FINDER_LIVE_FINDER_LIVE_ALLOWANCE_DEBUG", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "必现入口。测试看效果", "正常上线效果" }));
    ahlm = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "开播美颜下巴").d(com.tencent.mm.plugin.expt.b.c.a.zwo).c("CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_XIABA", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahln = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "开播美颜唇形").d(com.tencent.mm.plugin.expt.b.c.a.zwp).c("CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_CHUNXING", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahlo = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "开播美颜发际线").d(com.tencent.mm.plugin.expt.b.c.a.zwq).c("CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_FAJIXIAN", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahlp = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "开播美颜瘦脸").d(com.tencent.mm.plugin.expt.b.c.a.zwr).c("CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_SHOULIAN", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahlq = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "使用新磨皮").d(com.tencent.mm.plugin.expt.b.c.a.zws).c("CLICFG_FINDER_LIVE_ANCHOR_BEAUTY_ENABLE_NEW_SMOOTH_FACE", p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), p.listOf(new String[] { "是", "否" }));
    ahlr = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "设置关注抽奖时是否要提示主播").aDk("FinderLiveLotteryPromptAttendTypeCompatibility").c("FINDER_LIVE_LOTTERY_FOLLOW_TIPS", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" }));
    ahls = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(5, "视频号慢轮询请求合并间隔").aDk("FinderLiveSyncExtraInfoDefaultMergeIntervalSeconds");
    ahlt = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(180, "付费直播免费观看时长(秒)").d(com.tencent.mm.plugin.expt.b.c.a.zwP).c("FINDER_LIVE_CHARGE_FREE_TIME_SECOND", p.listOf(new Integer[] { Integer.valueOf(15), Integer.valueOf(30), Integer.valueOf(60), Integer.valueOf(90), Integer.valueOf(180) }), p.listOf(new String[] { "15s", "30s", "60s", "90s", "180s" }));
    ahlu = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "付费直播付费后是否重新进房").d(com.tencent.mm.plugin.expt.b.c.a.zwQ).c("FINDER_LIVE_CHARGE_RESTART_AFTER_PAY", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlv = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "播放前，擦除直播的解密数据").c("ERASE_LIVE_DECRYPT_BEFORE_PLAY", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "否", "是" }));
    ahlw = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "付费回放付费后是否重新进房").d(com.tencent.mm.plugin.expt.b.c.a.zwR).c("FINDER_LIVE_REPLAY_RESTART_AFTER_PAY", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlx = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播间更多按钮样式").d(com.tencent.mm.plugin.expt.b.c.a.yZF).c("FINDER_LIVE_MORE_ACTION_BTN_STYLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "转发icon", "三点icon" }));
    ahly = new com.tencent.mm.plugin.findersdk.storage.config.base.c("清除主播开始组队通知保持选择", (kotlin.g.a.b)a.n.ahmp);
    ahlz = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置冬奥cdn资源版本", (kotlin.g.a.b)a.aa.ahmC);
    akmL = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置春晚包厢引导提示", (kotlin.g.a.b)a.ac.akmS);
    ahlA = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "主播从小窗恢复时是否允许不重启摄像头").d(com.tencent.mm.plugin.expt.b.c.a.yZr).c("FINDER_LIVE_ANCHOR_DRIECTOR_START_FROM_MINIWINDOW", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlB = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "观众进入直播间提前加载core").d(com.tencent.mm.plugin.expt.b.c.a.yZs).c("FINDER_ENTER_VISITOR_PRELOAD_CORE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("2021T3");
    ahlC = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "直播间是否允许本地直接进鼓掌模式", "FINDER_LIVE_APPLAUD_LOCAL");
    ahlD = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "点击直播间主播头像进入可鼓掌状态", "FINDER_LIVE_CLICK_AVATAR_ENTER_APPLAUD");
    ahlE = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "鼓掌提示是否一直出", "FINDER_LIVE_APPLAUD_TIPS_ALWAYS");
    ahlF = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播间观众端礼物特效隐藏指引", (kotlin.g.a.b)a.o.ahmq);
    ahlG = new com.tencent.mm.plugin.findersdk.storage.config.base.c("跳支付实名认证", (kotlin.g.a.b)a.v.ahmx);
    ahlH = new com.tencent.mm.plugin.findersdk.storage.config.a.a.a(false, "开播绕过前面的实名检查", "FINDER_LIVE_SKIP_REAL_NAME");
    ahlI = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播观众是否展示分辨率等级").d(com.tencent.mm.plugin.expt.b.c.a.yZH).c("FINDER_LIVE_DEFINITION_LEVEL", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlJ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "视频号直播预播放").c("FINDER_LIVE_PRE_PLAY", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" })).aDm("2021T3").d(com.tencent.mm.plugin.expt.b.c.a.yZI);
    ahlK = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播VR模式教育页", (kotlin.g.a.b)a.l.ahmn);
    ahlL = new com.tencent.mm.plugin.findersdk.storage.config.base.c("重置直播VR提示气泡", (kotlin.g.a.b)a.m.ahmo);
    ahlM = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播VR开关").d(com.tencent.mm.plugin.expt.b.c.a.yHx).c("FINDER_LIVE_VR_MODE_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" }));
    ahlN = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "是否展示直播侧边栏").d(com.tencent.mm.plugin.expt.b.c.a.yZL).c("FINDER_LIVE_SIDEBAR_SWITCH", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlO = new com.tencent.mm.plugin.findersdk.storage.config.base.c("游戏直播全屏协议重置", (kotlin.g.a.b)a.t.ahmv);
    ahlP = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "主播开播温度过高提示阈值").d(com.tencent.mm.plugin.expt.b.c.a.yZO).c("FINDER_LIVE_ANCHOR_BATTERY_TEMPERATURE_THRESHOLD", p.listOf(new Integer[] { Integer.valueOf(15), Integer.valueOf(20), Integer.valueOf(25), Integer.valueOf(30), Integer.valueOf(35), Integer.valueOf(40), Integer.valueOf(45), Integer.valueOf(50) }), p.listOf(new String[] { "15度", "20度", "25度", "30度", "35度", "40度", "45度", "50度" }));
    ahlQ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "主播开播静音检测时长阈值").d(com.tencent.mm.plugin.expt.b.c.a.yZP).c("FINDER_LIVE_ANCHOR_SILENT_AUDIO_DURATION_THRESHOLD", p.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(10) }), p.listOf(new String[] { "10s", "20s" }));
    ahlR = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "主播开播破音检测时长阈值").d(com.tencent.mm.plugin.expt.b.c.a.yZQ).c("FINDER_LIVE_ANCHOR_OVERFLOW_AUDIO_DURATION_THRESHOLD", p.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(10) }), p.listOf(new String[] { "10s", "20s" }));
    ahlS = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "主播开播音频断续检测时长阈值").d(com.tencent.mm.plugin.expt.b.c.a.yZR).c("FINDER_LIVE_ANCHOR_BREAK_AUDIO_DURATION_THRESHOLD", p.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(10) }), p.listOf(new String[] { "10s", "20s" }));
    ahlT = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(5, "主播开播音频异常断续阈值").d(com.tencent.mm.plugin.expt.b.c.a.yHy);
    ahlU = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(680, "主播开播弱网测速阈值").c("FINDER_LIVE_ANCHOR_NET_SPEED_TEST_THRESHOLD", p.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(680), Integer.valueOf(6000), Integer.valueOf(60000) }), p.listOf(new String[] { "60kbps", "680kbps", "6000kbps", "60000kbps" }));
    ahlV = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(300000, "主播开播弱网测速弹窗间隔时间").c("FINDER_LIVE_ANCHOR_NET_SPEED_TEST_INTERVAL", p.listOf(new Integer[] { Integer.valueOf(60000), Integer.valueOf(300000) }), p.listOf(new String[] { "1分钟", "5分钟" }));
    ahlW = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "支持主播使用本地视频推流").d(com.tencent.mm.plugin.expt.b.c.a.yHz).c("FINDER_LIVE_LOCAL_PUSH_STREAM_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" }));
    ahlX = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "是否允许录屏").d(com.tencent.mm.plugin.expt.b.c.a.yZM).c("FINDER_LIVE_SECURE_SWITCH", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlY = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(1, "直播feed是否允许录屏").d(com.tencent.mm.plugin.expt.b.c.a.yZN).c("FINDER_LIVE_FEED_SECURE_SWITCH", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "是", "否" }));
    ahlZ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(30, "直播商品讲解录制时长上限（分钟）").c("FINDER_LIVE_RECORD_DURATION_LIMIT", p.listOf(new Integer[] { Integer.valueOf(30), Integer.valueOf(3), Integer.valueOf(1) }), p.listOf(new String[] { "30", "3", "1" }));
    ahma = new com.tencent.mm.plugin.findersdk.storage.config.a.c.a(300L, "直播纪念日背景装饰间隔时长").d(com.tencent.mm.plugin.expt.b.c.a.yHA).c("FINDER_LIVE_DECORATION_BG_INTERVAL", p.listOf(new Long[] { Long.valueOf(30L), Long.valueOf(300L) }), p.listOf(new String[] { "30s", "5min" }));
    ahmb = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "多场预约入口").d(com.tencent.mm.plugin.expt.b.c.a.yHB).c("FINDER_LIVE_MULTI_NOTICE_ENABLE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "关闭", "打开" }));
    akmM = new com.tencent.mm.plugin.findersdk.storage.config.base.c("春联提示重置", (kotlin.g.a.b)a.ab.akmR);
    akmN = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "所有直播都是春晚").c("FINDER_LIVE_MOCK_GALA", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "否", "是" }));
    akmO = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "朋友圈春晚发表入口控制").c("FINDER_LIVE_MOCK_GALA", p.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), p.listOf(new String[] { "后台配置", "禁用入口", "进过直播间的用户才能发表，带小尾巴", "所有用户开放入口，进过直播间才带小尾巴", "所有用户开放入口，发表都不带小尾巴" }));
    akmP = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(-1, "朋友圈春晚小尾巴状体").c("FINDER_LIVE_MOCK_GALA", p.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "后台配置", "显示", "隐藏" }));
    akmQ = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "强制打开春联活动").c("FINDER_LIVE_MOCK_COUPLETS_SNS", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "否", "是" }));
    AppMethodBeat.o(218029);
  }
  
  public static void aGT(int paramInt)
  {
    AppMethodBeat.i(217354);
    Log.i("Finder.FinderLiveConfig", s.X("set LIVE_LICENSE value:", Integer.valueOf(paramInt)));
    h.baE().ban().set(at.a.adgh, Integer.valueOf(paramInt));
    AppMethodBeat.o(217354);
  }
  
  public static void aGU(int paramInt)
  {
    AppMethodBeat.i(217592);
    Log.i("Finder.FinderLiveConfig", s.X("set LIVE_LICENSE value:", Integer.valueOf(paramInt)));
    h.baE().ban().set(at.a.adgi, Integer.valueOf(paramInt));
    AppMethodBeat.o(217592);
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRH()
  {
    return ahiY;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRI()
  {
    return ahiZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRJ()
  {
    return ahja;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> jRK()
  {
    return ahjb;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> jRL()
  {
    return ahjc;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> jRM()
  {
    return ahjd;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> jRN()
  {
    return ahje;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRO()
  {
    return ahjf;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRP()
  {
    return ahjg;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRQ()
  {
    return ahjh;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRR()
  {
    return ahji;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRS()
  {
    return ahjj;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRT()
  {
    return ahjk;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRU()
  {
    return ahjl;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jRV()
  {
    return ahjm;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRW()
  {
    return ahjn;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jRX()
  {
    return ahjo;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRY()
  {
    return ahjp;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jRZ()
  {
    return ahjr;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSA()
  {
    return ahjW;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSB()
  {
    return ahjX;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSC()
  {
    return ahjY;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSD()
  {
    return ahjZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSE()
  {
    return ahka;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSF()
  {
    return ahkb;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSG()
  {
    return ahkc;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSH()
  {
    return ahkd;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSI()
  {
    return ahke;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSJ()
  {
    return ahkf;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSK()
  {
    return ahkg;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSL()
  {
    return ahkh;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSM()
  {
    return ahki;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSN()
  {
    return ahkj;
  }
  
  public static int jSO()
  {
    AppMethodBeat.i(217048);
    switch (((Number)ahkj.bmg()).intValue())
    {
    default: 
      i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.d.a.a.a.c.a.Edge_10A);
      AppMethodBeat.o(217048);
      return i;
    case 1: 
      i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.d.a.a.a.c.a.Edge_12A);
      AppMethodBeat.o(217048);
      return i;
    case 2: 
      i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.d.a.a.a.c.a.Edge_20A);
      AppMethodBeat.o(217048);
      return i;
    }
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelSize(com.tencent.d.a.a.a.c.a.Edge_30A);
    AppMethodBeat.o(217048);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jSP()
  {
    return ahkl;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSQ()
  {
    return ahkm;
  }
  
  public static boolean jSR()
  {
    AppMethodBeat.i(217092);
    if (((Number)ahkm.bmg()).intValue() == 1)
    {
      AppMethodBeat.o(217092);
      return true;
    }
    AppMethodBeat.o(217092);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSS()
  {
    return ahkn;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jST()
  {
    return ahko;
  }
  
  public static int jSU()
  {
    AppMethodBeat.i(217119);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYR, 15);
    AppMethodBeat.o(217119);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSV()
  {
    return ahkp;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSW()
  {
    return ahkq;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSX()
  {
    return ahkr;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSY()
  {
    return ahks;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSZ()
  {
    return ahkt;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSa()
  {
    return ahjs;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSb()
  {
    return ahjt;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSc()
  {
    return ahju;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSd()
  {
    return ahjw;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSe()
  {
    return ahjx;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<String> jSf()
  {
    return ahjy;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jSg()
  {
    return ahjz;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSh()
  {
    return ahjA;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSi()
  {
    return ahjB;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSj()
  {
    return ahjC;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSk()
  {
    return ahjD;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSl()
  {
    return ahjE;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSm()
  {
    return ahjF;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSn()
  {
    return ahjH;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSo()
  {
    return ahjI;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSp()
  {
    return ahjJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSq()
  {
    return ahjK;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Boolean> jSr()
  {
    return ahjL;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSs()
  {
    return ahjO;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSt()
  {
    return ahjP;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSu()
  {
    return ahjQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSv()
  {
    return ahjR;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSw()
  {
    return ahjS;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> jSx()
  {
    return ahjT;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSy()
  {
    return ahjU;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jSz()
  {
    return ahjV;
  }
  
  public static int jTA()
  {
    AppMethodBeat.i(217460);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYI, 4000);
    AppMethodBeat.o(217460);
    return i;
  }
  
  public static int jTB()
  {
    AppMethodBeat.i(217472);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYG, 100);
    AppMethodBeat.o(217472);
    return i;
  }
  
  public static int jTC()
  {
    AppMethodBeat.i(217482);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYH, 3);
    AppMethodBeat.o(217482);
    return i;
  }
  
  public static boolean jTD()
  {
    AppMethodBeat.i(217495);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZa, 1) == 1)
    {
      AppMethodBeat.o(217495);
      return true;
    }
    AppMethodBeat.o(217495);
    return false;
  }
  
  public static boolean jTE()
  {
    AppMethodBeat.i(217507);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZf, 0) == 1)
    {
      AppMethodBeat.o(217507);
      return true;
    }
    AppMethodBeat.o(217507);
    return false;
  }
  
  public static boolean jTF()
  {
    AppMethodBeat.i(217521);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZD, 0) == 1)
    {
      AppMethodBeat.o(217521);
      return true;
    }
    AppMethodBeat.o(217521);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTG()
  {
    return ahkO;
  }
  
  public static boolean jTH()
  {
    AppMethodBeat.i(217545);
    if (((Number)ahkO.bmg()).intValue() == 1)
    {
      AppMethodBeat.o(217545);
      return true;
    }
    AppMethodBeat.o(217545);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTI()
  {
    return ahkP;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTJ()
  {
    return ahkQ;
  }
  
  public static int jTK()
  {
    AppMethodBeat.i(217580);
    int i = h.baE().ban().getInt(at.a.adgi, 0);
    AppMethodBeat.o(217580);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTL()
  {
    return ahkR;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTM()
  {
    return ahkS;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTN()
  {
    return ahkT;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTO()
  {
    return ahkU;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTP()
  {
    return ahkV;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTQ()
  {
    return ahkW;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTR()
  {
    return ahkX;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> jTS()
  {
    return ahkY;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jTT()
  {
    return ahkZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTU()
  {
    return ahla;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTV()
  {
    return ahlb;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTW()
  {
    return ahlc;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTX()
  {
    return ahld;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTY()
  {
    return ahle;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTZ()
  {
    return ahlf;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTa()
  {
    return ahku;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTb()
  {
    return ahkv;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTc()
  {
    return ahkw;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTd()
  {
    return ahkx;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTe()
  {
    return ahky;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTf()
  {
    return ahkz;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTg()
  {
    return ahkA;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTh()
  {
    return ahkB;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTi()
  {
    return ahkC;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTj()
  {
    return ahkD;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTk()
  {
    return ahkE;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jTl()
  {
    return ahkF;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTm()
  {
    return ahkG;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jTn()
  {
    return ahkH;
  }
  
  public static int jTo()
  {
    AppMethodBeat.i(217338);
    int i = h.baE().ban().getInt(at.a.adgh, 0);
    AppMethodBeat.o(217338);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTp()
  {
    return ahkI;
  }
  
  public static boolean jTq()
  {
    AppMethodBeat.i(217374);
    if (((Number)ahkI.bmg()).intValue() == 1)
    {
      AppMethodBeat.o(217374);
      return true;
    }
    AppMethodBeat.o(217374);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTr()
  {
    return ahkJ;
  }
  
  public static boolean jTs()
  {
    AppMethodBeat.i(217394);
    if (((Number)ahkJ.bmg()).intValue() == 0)
    {
      AppMethodBeat.o(217394);
      return true;
    }
    AppMethodBeat.o(217394);
    return false;
  }
  
  public static int jTt()
  {
    AppMethodBeat.i(217403);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYB, 75);
    AppMethodBeat.o(217403);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTu()
  {
    return ahkK;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTv()
  {
    return ahkL;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTw()
  {
    return ahkM;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jTx()
  {
    return ahkN;
  }
  
  public static int jTy()
  {
    AppMethodBeat.i(217444);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYJ, 10);
    AppMethodBeat.o(217444);
    return i;
  }
  
  public static int jTz()
  {
    AppMethodBeat.i(217450);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yYK, 60);
    AppMethodBeat.o(217450);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUA()
  {
    return ahlG;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jUB()
  {
    return ahlH;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUC()
  {
    return ahlI;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUD()
  {
    return ahlJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUE()
  {
    return ahlK;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUF()
  {
    return ahlL;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUG()
  {
    return ahlM;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUH()
  {
    return ahlN;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUI()
  {
    return ahlO;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUJ()
  {
    return ahlP;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUK()
  {
    return ahlQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUL()
  {
    return ahlR;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUM()
  {
    return ahlS;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUN()
  {
    return ahlT;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUO()
  {
    return ahlU;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUP()
  {
    return ahlV;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUQ()
  {
    return ahlW;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUR()
  {
    return ahlX;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUS()
  {
    return ahlY;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUT()
  {
    return ahlZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Long> jUU()
  {
    return ahma;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUV()
  {
    return ahmb;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUa()
  {
    return ahlg;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jUb()
  {
    return ahlh;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUc()
  {
    return ahli;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUd()
  {
    return ahlj;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUe()
  {
    return ahlk;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUf()
  {
    return ahll;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUg()
  {
    return ahlm;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUh()
  {
    return ahln;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUi()
  {
    return ahlo;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUj()
  {
    return ahlp;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUk()
  {
    return ahlq;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUl()
  {
    return ahlr;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUm()
  {
    return ahls;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUn()
  {
    return ahlt;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUo()
  {
    return ahlu;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUp()
  {
    return ahlv;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUq()
  {
    return ahlw;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUr()
  {
    return ahlx;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUs()
  {
    return ahly;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUt()
  {
    return ahlz;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUu()
  {
    return ahlA;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jUv()
  {
    return ahlB;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jUw()
  {
    return ahlC;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jUx()
  {
    return ahlD;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.a.a.a jUy()
  {
    return ahlE;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c jUz()
  {
    return ahlF;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c kMA()
  {
    return akmM;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> kMB()
  {
    return akmN;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> kMC()
  {
    return akmO;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> kMD()
  {
    return akmP;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> kME()
  {
    return akmQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.c kMz()
  {
    return akmL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.d.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */