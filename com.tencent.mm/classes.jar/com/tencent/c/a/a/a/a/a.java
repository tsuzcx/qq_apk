package com.tencent.c.a.a.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.c.a.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.d.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/config/FinderLiveConfig;", "", "()V", "DEBUG_LIVE_ANCHOR_MUSIC_GUIDE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getDEBUG_LIVE_ANCHOR_MUSIC_GUIDE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "setDEBUG_LIVE_ANCHOR_MUSIC_GUIDE", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;)V", "DEBUG_LIVE_BEAUTY_CONFIG", "Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "getDEBUG_LIVE_BEAUTY_CONFIG", "()Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;", "setDEBUG_LIVE_BEAUTY_CONFIG", "(Lcom/tencent/mm/plugin/findersdk/storage/config/item/booleantype/FinderBooleanConfig;)V", "DEBUG_LIVE_LICENSE", "getDEBUG_LIVE_LICENSE", "setDEBUG_LIVE_LICENSE", "DEBUG_LIVE_POST_FACE_VERIFY", "getDEBUG_LIVE_POST_FACE_VERIFY", "setDEBUG_LIVE_POST_FACE_VERIFY", "DEBUG_PROFILE_SHOP_OP_GUIDE", "getDEBUG_PROFILE_SHOP_OP_GUIDE", "setDEBUG_PROFILE_SHOP_OP_GUIDE", "DEBUG_RESET_LIVE_MODE_GUIDE", "getDEBUG_RESET_LIVE_MODE_GUIDE", "setDEBUG_RESET_LIVE_MODE_GUIDE", "DEBUG_RESET_LIVE_VISITOR_ROLE_GUIDE", "getDEBUG_RESET_LIVE_VISITOR_ROLE_GUIDE", "setDEBUG_RESET_LIVE_VISITOR_ROLE_GUIDE", "FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "FINDER_LIVE", "", "getFINDER_LIVE", "()Z", "FINDER_LIVE_ADD_TO_HISTORY_OFFSET", "getFINDER_LIVE_ADD_TO_HISTORY_OFFSET", "FINDER_LIVE_ADJUST_GIFT_NAME", "getFINDER_LIVE_ADJUST_GIFT_NAME", "setFINDER_LIVE_ADJUST_GIFT_NAME", "(Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;)V", "FINDER_LIVE_ANCHOR_MUSIC_CLICK_TEST", "getFINDER_LIVE_ANCHOR_MUSIC_CLICK_TEST", "FINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", "getFINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", "setFINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", "FINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", "getFINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", "setFINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", "FINDER_LIVE_ASYCN_LOAD_PAG", "getFINDER_LIVE_ASYCN_LOAD_PAG", "FINDER_LIVE_AUDIO_MODE_ENABLE", "getFINDER_LIVE_AUDIO_MODE_ENABLE", "FINDER_LIVE_BEAUTY_ENABLE", "getFINDER_LIVE_BEAUTY_ENABLE", "FINDER_LIVE_BULLET_COMMENT_LIMIT_NUM", "getFINDER_LIVE_BULLET_COMMENT_LIMIT_NUM", "()I", "FINDER_LIVE_CAST_SCREEN_ENABLE", "getFINDER_LIVE_CAST_SCREEN_ENABLE", "FINDER_LIVE_COMMENT_SIZE_LIMIT", "getFINDER_LIVE_COMMENT_SIZE_LIMIT", "FINDER_LIVE_ENABLE_ANCHOR_MUSIC", "getFINDER_LIVE_ENABLE_ANCHOR_MUSIC", "FINDER_LIVE_ENABLE_PRELOAD", "getFINDER_LIVE_ENABLE_PRELOAD", "FINDER_LIVE_ENABLE_SHOPPING", "getFINDER_LIVE_ENABLE_SHOPPING", "FINDER_LIVE_FEED_CACHE_DURATION", "getFINDER_LIVE_FEED_CACHE_DURATION", "FINDER_LIVE_FEED_FLOW_VALID_WATCH_TIME_THRESHOLD", "getFINDER_LIVE_FEED_FLOW_VALID_WATCH_TIME_THRESHOLD", "FINDER_LIVE_FILTER_ANCHOR_EXT_FLAG", "getFINDER_LIVE_FILTER_ANCHOR_EXT_FLAG", "FINDER_LIVE_FILTER_ENABLE", "getFINDER_LIVE_FILTER_ENABLE", "FINDER_LIVE_FILTER_OUTDATED_RESP", "getFINDER_LIVE_FILTER_OUTDATED_RESP", "setFINDER_LIVE_FILTER_OUTDATED_RESP", "FINDER_LIVE_FILTER_VISITOR_RESET_ONLOIN_VALUE", "getFINDER_LIVE_FILTER_VISITOR_RESET_ONLOIN_VALUE", "FINDER_LIVE_FILTER_VISITOR_ZERO_LIKE_VALUE", "getFINDER_LIVE_FILTER_VISITOR_ZERO_LIKE_VALUE", "FINDER_LIVE_FIT_LANDSCAPE_VIDEO", "getFINDER_LIVE_FIT_LANDSCAPE_VIDEO", "FINDER_LIVE_FORCE_HAS_OVERLAPPING_RENDERING", "getFINDER_LIVE_FORCE_HAS_OVERLAPPING_RENDERING", "FINDER_LIVE_FRONT_RENDER_MIRROR", "getFINDER_LIVE_FRONT_RENDER_MIRROR", "FINDER_LIVE_GETLIVEMSG_TEST", "getFINDER_LIVE_GETLIVEMSG_TEST", "FINDER_LIVE_GET_COMMENT_DURATION", "getFINDER_LIVE_GET_COMMENT_DURATION", "FINDER_LIVE_GIFT_ANIM_STAY_DURATION", "getFINDER_LIVE_GIFT_ANIM_STAY_DURATION", "FINDER_LIVE_GIFT_COMBOID_LIVE_TIME", "getFINDER_LIVE_GIFT_COMBOID_LIVE_TIME", "FINDER_LIVE_GIFT_FULL_PAG_DEFAULT_DURATION", "", "getFINDER_LIVE_GIFT_FULL_PAG_DEFAULT_DURATION", "FINDER_LIVE_GIFT_QUEUE_MAX_SIZE", "getFINDER_LIVE_GIFT_QUEUE_MAX_SIZE", "FINDER_LIVE_GIFT_QUEUE_NICKNAME_LENGTH", "getFINDER_LIVE_GIFT_QUEUE_NICKNAME_LENGTH", "FINDER_LIVE_GUIDE_ENABLE", "getFINDER_LIVE_GUIDE_ENABLE", "FINDER_LIVE_HEART_BEAT_GUARD_INTERVAL", "getFINDER_LIVE_HEART_BEAT_GUARD_INTERVAL", "setFINDER_LIVE_HEART_BEAT_GUARD_INTERVAL", "FINDER_LIVE_HEAT_USE_NEW", "getFINDER_LIVE_HEAT_USE_NEW", "FINDER_LIVE_HEVC_ENC_ENABLE_SWITCH", "getFINDER_LIVE_HEVC_ENC_ENABLE_SWITCH", "FINDER_LIVE_HIDE_LOADING_PROGRESS", "getFINDER_LIVE_HIDE_LOADING_PROGRESS", "setFINDER_LIVE_HIDE_LOADING_PROGRESS", "FINDER_LIVE_KEEP_ALIVE_GUARD_ENABLE", "getFINDER_LIVE_KEEP_ALIVE_GUARD_ENABLE", "setFINDER_LIVE_KEEP_ALIVE_GUARD_ENABLE", "FINDER_LIVE_LANDSCAPE", "getFINDER_LIVE_LANDSCAPE", "FINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", "getFINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", "setFINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", "FINDER_LIVE_LINK_MIC_ENABLE", "getFINDER_LIVE_LINK_MIC_ENABLE", "FINDER_LIVE_LIST_AUTO_PLAY", "getFINDER_LIVE_LIST_AUTO_PLAY", "setFINDER_LIVE_LIST_AUTO_PLAY", "FINDER_LIVE_LIST_CREATE_DEBUG_DATA", "getFINDER_LIVE_LIST_CREATE_DEBUG_DATA", "FINDER_LIVE_LIST_ENABLE_MORE_LIVE", "getFINDER_LIVE_LIST_ENABLE_MORE_LIVE", "FINDER_LIVE_LIST_PRELOAD_THRESHOLD", "getFINDER_LIVE_LIST_PRELOAD_THRESHOLD", "FINDER_LIVE_LOTTERY", "getFINDER_LIVE_LOTTERY", "FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", "getFINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", "FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", "getFINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", "FINDER_LIVE_LOTTERY_DURATION", "getFINDER_LIVE_LOTTERY_DURATION", "FINDER_LIVE_LOTTERY_SAVEID_SIZE", "getFINDER_LIVE_LOTTERY_SAVEID_SIZE", "FINDER_LIVE_LOTTERY_UPDATE_STRATEGY", "getFINDER_LIVE_LOTTERY_UPDATE_STRATEGY", "FINDER_LIVE_LUCKY_MONEY_CHATROOM_ENTRANCE_GUIDE", "", "getFINDER_LIVE_LUCKY_MONEY_CHATROOM_ENTRANCE_GUIDE", "setFINDER_LIVE_LUCKY_MONEY_CHATROOM_ENTRANCE_GUIDE", "FINDER_LIVE_LUCKY_MONEY_CHATROOM_TEST", "getFINDER_LIVE_LUCKY_MONEY_CHATROOM_TEST", "setFINDER_LIVE_LUCKY_MONEY_CHATROOM_TEST", "FINDER_LIVE_LUCKY_MONEY_FINDER_CONFIRM_GUIDE", "getFINDER_LIVE_LUCKY_MONEY_FINDER_CONFIRM_GUIDE", "setFINDER_LIVE_LUCKY_MONEY_FINDER_CONFIRM_GUIDE", "FINDER_LIVE_MANUAL_CRASH", "getFINDER_LIVE_MANUAL_CRASH", "FINDER_LIVE_MANUAL_MINI_WINDOW", "getFINDER_LIVE_MANUAL_MINI_WINDOW", "setFINDER_LIVE_MANUAL_MINI_WINDOW", "FINDER_LIVE_MAX_NUM", "getFINDER_LIVE_MAX_NUM", "FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", "getFINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", "FINDER_LIVE_MINIPRO_PRE_RENDER_LEVEL", "getFINDER_LIVE_MINIPRO_PRE_RENDER_LEVEL", "FINDER_LIVE_MSG_BADGE_DEBUG", "getFINDER_LIVE_MSG_BADGE_DEBUG", "FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", "getFINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", "FINDER_LIVE_MSG_SEND_LOCAL_GIFT", "getFINDER_LIVE_MSG_SEND_LOCAL_GIFT", "FINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG", "getFINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG", "FINDER_LIVE_NEW_GUIDE_SHOW_ALWAYS", "getFINDER_LIVE_NEW_GUIDE_SHOW_ALWAYS", "FINDER_LIVE_NOTICE_TIME", "getFINDER_LIVE_NOTICE_TIME", "FINDER_LIVE_POOR_NETWORK_QUALITY_THRESHOLD", "getFINDER_LIVE_POOR_NETWORK_QUALITY_THRESHOLD", "FINDER_LIVE_PRECHECK_ENTRANCE", "getFINDER_LIVE_PRECHECK_ENTRANCE", "FINDER_LIVE_PRELOAD_OTHERS_WEAPP", "getFINDER_LIVE_PRELOAD_OTHERS_WEAPP", "setFINDER_LIVE_PRELOAD_OTHERS_WEAPP", "FINDER_LIVE_REFRESH_DURATION", "getFINDER_LIVE_REFRESH_DURATION", "FINDER_LIVE_REWARD_MEMBER", "getFINDER_LIVE_REWARD_MEMBER", "FINDER_LIVE_RV_FEED_ENABLE_PRELOAD", "getFINDER_LIVE_RV_FEED_ENABLE_PRELOAD", "FINDER_LIVE_SEI_ENABLE_SWITCH", "getFINDER_LIVE_SEI_ENABLE_SWITCH", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE", "getFINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE", "FINDER_LIVE_SHOPPING_HEIGHT_PERCENT", "getFINDER_LIVE_SHOPPING_HEIGHT_PERCENT", "FINDER_LIVE_SHOPPING_PICTURE_MAX_SIZE", "getFINDER_LIVE_SHOPPING_PICTURE_MAX_SIZE", "setFINDER_LIVE_SHOPPING_PICTURE_MAX_SIZE", "(I)V", "FINDER_LIVE_SHOPPING_REFRESH_FREQUENCY", "getFINDER_LIVE_SHOPPING_REFRESH_FREQUENCY", "FINDER_LIVE_SHOPPING_THREAD_PARTY_STRATEGY", "getFINDER_LIVE_SHOPPING_THREAD_PARTY_STRATEGY", "FINDER_LIVE_SHPOPPING_PICTURE_CONFIG", "getFINDER_LIVE_SHPOPPING_PICTURE_CONFIG", "FINDER_LIVE_STATISTICS_FREQUENCY", "getFINDER_LIVE_STATISTICS_FREQUENCY", "FINDER_LIVE_TICKLE_ENABLE", "getFINDER_LIVE_TICKLE_ENABLE", "FINDER_LIVE_VISIBLITY_DEBUG_DATA", "getFINDER_LIVE_VISIBLITY_DEBUG_DATA", "FINDER_LIVE_VISIBLITY_ENTRANCE", "getFINDER_LIVE_VISIBLITY_ENTRANCE", "FINDER_LIVE_VISITOR_MAX_RETRY_COUNT", "getFINDER_LIVE_VISITOR_MAX_RETRY_COUNT", "FINDER_LIVE_VISITOR_MODE", "getFINDER_LIVE_VISITOR_MODE", "FINDER_LIVE_VISITOR_RETRY_TINTERVAL", "getFINDER_LIVE_VISITOR_RETRY_TINTERVAL", "FINDER_LIVE_VISITOR_ROLE_ENTRANCE", "getFINDER_LIVE_VISITOR_ROLE_ENTRANCE", "FINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", "getFINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", "FINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", "getFINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", "FINDER_NEARBY_INVOKE_START_PRELOAD", "getFINDER_NEARBY_INVOKE_START_PRELOAD", "FINDER_NEARBY_LIVE_AUTO_PLAY_MUTE", "getFINDER_NEARBY_LIVE_AUTO_PLAY_MUTE", "FINDER_NEARBY_LIVE_AUTO_PLAY_TEST", "getFINDER_NEARBY_LIVE_AUTO_PLAY_TEST", "FINDER_NEARBY_LIVE_AUTO_PLAY_TEST_NEW", "getFINDER_NEARBY_LIVE_AUTO_PLAY_TEST_NEW", "FINDER_NEARBY_LIVE_CARD_AUTO_PLAY", "getFINDER_NEARBY_LIVE_CARD_AUTO_PLAY", "FINDER_NEARBY_LIVE_FRIENDS", "getFINDER_NEARBY_LIVE_FRIENDS", "FINDER_NEARBY_LIVE_FRIENDS_NEW_DOT_CONFIG", "getFINDER_NEARBY_LIVE_FRIENDS_NEW_DOT_CONFIG", "FINDER_NEARBY_LIVE_FRIENDS_TOTAL", "getFINDER_NEARBY_LIVE_FRIENDS_TOTAL", "FINDER_NEARBY_LIVE_PAGES_PRELOAD", "getFINDER_NEARBY_LIVE_PAGES_PRELOAD", "FINDER_NEARBY_LIVE_PULL_SIMILAR", "getFINDER_NEARBY_LIVE_PULL_SIMILAR", "FINDER_NEARBY_REDDOT_START_PRELOAD", "getFINDER_NEARBY_REDDOT_START_PRELOAD", "FINDER_NEARBY_REDDOT_TO_TARGET_LIVE_ROOM", "getFINDER_NEARBY_REDDOT_TO_TARGET_LIVE_ROOM", "FINDER_NEARBY_SQUARE_TABS_PRELOAD", "getFINDER_NEARBY_SQUARE_TABS_PRELOAD", "FINDER_RESET_LIVE_FIRST_REWARD", "getFINDER_RESET_LIVE_FIRST_REWARD", "Finder_LIVE_GIFT_ENABLE", "getFinder_LIVE_GIFT_ENABLE", "setFinder_LIVE_GIFT_ENABLE", "value", "LIVE_GAME_LICENSE", "getLIVE_GAME_LICENSE", "setLIVE_GAME_LICENSE", "LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "getLIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "setLIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", "LIVE_GIFT_DEBUG", "getLIVE_GIFT_DEBUG", "setLIVE_GIFT_DEBUG", "LIVE_GIFT_MOCK_DEBUG", "getLIVE_GIFT_MOCK_DEBUG", "setLIVE_GIFT_MOCK_DEBUG", "LIVE_LICENSE", "getLIVE_LICENSE", "setLIVE_LICENSE", "LIVE_POST_TIPS", "getLIVE_POST_TIPS", "LIVE_TASK_TIPS_RESET", "getLIVE_TASK_TIPS_RESET", "LIVE_USER_MAX_COUNT", "getLIVE_USER_MAX_COUNT", "LIVE_USER_VISIBILITY", "getLIVE_USER_VISIBILITY", "TAG", "debugFinderLive", "getDebugFinderLive", "debugFinderLiveLandscape", "getDebugFinderLiveLandscape", "debugFinderLiveLottery", "getDebugFinderLiveLottery", "debugFinderLiveMiniProTest", "getDebugFinderLiveMiniProTest", "debugFinderLiveShoppingEnable", "getDebugFinderLiveShoppingEnable", "debugFinderLiveThreadPartyShoppingStrategy", "getDebugFinderLiveThreadPartyShoppingStrategy", "debugLandscapeVideoFit", "getDebugLandscapeVideoFit", "plugin-finder-live-api_release"})
public final class a
{
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> AiY;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjA;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjB;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjC;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjD;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjF;
  private static c ZjG;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjH;
  private static final c ZjI;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjK;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjM;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjN;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjO;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjP;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<String> ZjQ;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a ZjR;
  private static final c ZjS;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjT;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjU;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjV;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZjZ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zjt;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zju;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zjv;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<String> Zjw;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<String> Zjx;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<String> Zjy;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> Zjz;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkA;
  private static int ZkB;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a ZkC;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkD;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkE;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkF;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkG;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkH;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkI;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkJ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkK;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkL;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkM;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkN;
  private static c ZkO;
  private static c ZkP;
  private static c ZkQ;
  private static c ZkR;
  private static c ZkS;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkT;
  private static com.tencent.mm.plugin.findersdk.d.a.b.a.a ZkU;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkV;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkW;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkX;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkY;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ZkZ;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zka;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkb;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkc;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> Zkd;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zke;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkf;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkg;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkh;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zki;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkj;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Long> Zkk;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkl;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkm;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkn;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zko;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkp;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkq;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkr;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zks;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkt;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zku;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkv;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkw;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkx;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zky;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zkz;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zla;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlb;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlc;
  private static final c Zld;
  private static final c Zle;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlf;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlg;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlh;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zli;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlj;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlk;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Zll;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlm;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zln;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlo;
  private static final com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlp;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlq;
  private static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> Zlr;
  private static final com.tencent.mm.plugin.findersdk.d.a.b.a.a Zls;
  public static final a Zlt;
  
  static
  {
    AppMethodBeat.i(230872);
    Zlt = new a();
    Zjt = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(15, "直播添加进历史准入时间偏移").d(b.a.vMh);
    Zju = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播间红包入口").b("FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), j.listOf(new String[] { "默认", "不允许", "允许-非节日", "允许-节日" }));
    Zjv = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否用新热度值").d(b.a.vuC).b("FINDER_LIVE_HEAT_USE_NEW", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "否", "是" })).aGU("T6");
    Zjw = new c("重置直播红包H5", (kotlin.g.a.b)a.g.ZlA).aGU("T5");
    Zjx = new c("直播红包测试", (kotlin.g.a.b)a.h.ZlB).aGU("T5");
    Zjy = new c("重置身份确认半屏", (kotlin.g.a.b)a.i.ZlC).aGU("T5");
    Zjz = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(10000L, "直播心跳手动复苏时间间隔").d(b.a.vJc);
    ZjA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播保活手动复苏开关").d(b.a.vJd);
    ZjB = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否允许主播开启音乐").d(b.a.vuD).b("FINDER_LIVE_ENABLE_ANCHOR_MUSIC", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZjC = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "主播音量调节快捷区域test").d(b.a.vuE).b("FINDER_LIVE_ANCHOR_MUSIC_CLICK_TEST", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZjD = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1000, "主播音乐数量上限").d(b.a.vuG).b("FINDER_LIVE_ANCHOR_MUSIC_MAX_SIZE", j.listOf(new Integer[] { Integer.valueOf(50), Integer.valueOf(100), Integer.valueOf(1000) }), j.listOf(new String[] { "50首", "100首", "1000首" }));
    ZjE = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(40, "主播背景音乐初始音量").d(b.a.vuH).b("FINDER_LIVE_ANCHOR_MUSIC_INIT_VOLUME", j.listOf(new Integer[] { Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(60) }), j.listOf(new String[] { "20", "40", "60" }));
    ZjF = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否异步load pag").d(b.a.vuF).b("FINDER_LIVE_ASYCN_LOAD_PAG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZjG = new c("重置直播模式选择教育页", (kotlin.g.a.b)a.e.Zly);
    ZjH = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号直播音频模式开关").d(b.a.vJg);
    ZjI = new c("重置是否第一次获得直播打赏", (kotlin.g.a.b)a.l.ZlF);
    ZjJ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号直播投屏开关").d(b.a.vJf);
    ZjK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-直播卡片自动播放").b("FINDER_NEARBY_LIVE_CARD_AUTO_PLAY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMg);
    ZjL = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-点击红点跳转直播间").b("FINDER_NEARBY_REDDOT_TO_TARGET_LIVE_ROOM", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMf);
    AiW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-红点触发预加载").b("FINDER_NEARBY_REDDOT_START_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMb);
    AiX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-根据指定条件触发预加载").b("FINDER_NEARBY_INVOKE_START_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMc);
    AiY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-预加载直播广场tab列表").b("FINDER_NEARBY_SQUARE_TABS_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMd);
    ZjM = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-在直播广场当前页加载好后，预加载直播广场其他页").b("FINDER_NEARBY_LIVE_PAGES_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "开启" })).d(b.a.vMe);
    ZjN = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-自动播放实验组").d(b.a.vLl).b("FINDER_NEARBY_LIVE_AUTO_PLAY_TEST", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5) }), j.listOf(new String[] { "实验1", "实验2", "实验3", "实验4", "实验5" })).aGU("2021T1");
    ZjO = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-自动播放实验组").d(b.a.vLm).b("FINDER_NEARBY_LIVE_AUTO_PLAY_TEST", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "实验1", "实验2" })).aGU("2021T1");
    ZjP = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播和附近-直播是否打开声音").b("FINDER_NEARBY_LIVE_AUTO_PLAY_MUTE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).d(b.a.vLn);
    ZjQ = new c("清除附近的直播和人的NEW红点", (kotlin.g.a.b)a.k.ZlE).aGU("T32");
    ZjR = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "直播新手引导一直出", "FINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG");
    ZjS = new c("清除直播新手引导标记", (kotlin.g.a.b)a.j.ZlD);
    ZjT = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播上滑新手引导开关").d(b.a.vMP).b("FINDER_LIVE_GUIDE_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32_next");
    ZjU = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号直播前置摄像头渲染镜像开关").d(b.a.vYM).aGU("T32");
    ZjV = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播是否打开拍一拍").d(b.a.vMF).b("FINDER_LIVE_TICKLE_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    ZjW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播美颜开关").d(b.a.vMH).b("FINDER_LIVE_BEAUTY_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    ZjX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播滤镜开关").d(b.a.vMI).b("FINDER_LIVE_FILTER_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    ZjY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播连麦是否打开").d(b.a.vMJ).b("FINDER_LIVE_LINK_MIC_ENABLE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    ZjZ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "打开附近的直播和人").d(b.a.vMK).b("FINDER_NEARBY_LIVE_FRIENDS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    Zka = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "打开附近的直播和人-强制").d(b.a.vML).b("FINDER_NEARBY_LIVE_FRIENDS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    Zkb = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播Feed下拉出相似流").d(b.a.vMM).b("FINDER_NEARBY_LIVE_PULL_SIMILAR", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "关闭", "打开" })).aGU("T32");
    Zkc = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播礼物连击生成相同comboId").b("FINDER_LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    Zkd = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "直播礼物打赏mock工具是否打开").b("FINDER_LIVE_GIFT_MOCK_DEBUG", j.listOf(new Boolean[] { Boolean.TRUE, Boolean.FALSE }), j.listOf(new String[] { "打开", "关闭" }));
    Zke = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播礼物debug").b("FINDER_LIVE_GIFT_DEBUG", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    Zkf = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播礼物开关").d(b.a.vZe).b("FINDER_LIVE_GIFT_ENABLE", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" })).aGU("T32");
    Zkg = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "抽奖时长上限(秒)").d(b.a.vZf).b("FINDER_LIVE_GIFT_ANIM_STAY_DURATION", j.listOf(new Integer[] { Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(10), Integer.valueOf(30) }), j.listOf(new String[] { "3秒", "1秒", "10秒", "30秒" })).aGU("T32");
    Zkh = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播送礼通知昵称长度").d(b.a.vZg);
    Zki = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10000, "视频号直播送礼队列最大缓存长度").d(b.a.vZh);
    Zkj = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10, "视频号直播送礼队列聚合id延迟消失时长/秒").d(b.a.vZi);
    Zkk = new com.tencent.mm.plugin.findersdk.d.a.b.c.a(9000L, "视频号直播送礼大礼物默认播放时长").d(b.a.vZj);
    Zkl = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播打赏模拟上榜").d(b.a.vZr).b("FINDER_LIVE_MSG_BADGE_DEBUG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(9) }), j.listOf(new String[] { "不上榜", "榜1", "榜2", "榜3", "榜9" }));
    Zkm = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "观众打赏榜单自动刷新间隔/秒").d(b.a.vZs).b("FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(-1) }), j.listOf(new String[] { "0秒", "1秒", "2秒", "3秒", "5秒", "10秒", "不自动刷新" }));
    Zkn = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "过滤观众端因为复用问题的0在线人数").d(b.a.vZt).b("FINDER_LIVE_FILTER_VISITOR_RESET_ONLOIN_VALUE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zko = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "过滤观众端0人点赞数").d(b.a.vZu).b("FINDER_LIVE_FILTER_VISITOR_ZERO_LIKE_VALUE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zkp = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播打赏是否本地假插").d(b.a.vZv).b("FINDER_LIVE_MSG_SEND_LOCAL_GIFT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zkq = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "评论列表是否保留自己不超过一半上限的评论数据").d(b.a.vZw).b("FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Object localObject = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(-1, "视频号直播观众模式");
    e.b localb = e.b.kjz;
    int i = e.b.aJJ();
    localb = e.b.kjz;
    Zkr = ((com.tencent.mm.plugin.findersdk.d.a.b.b.a)localObject).b("FINDER_LIVE_VISITOR_MODE", j.listOf(new Integer[] { Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(e.b.aJK()) }), j.listOf(new String[] { "跟随后台", "TRTC", "CDN" })).d(b.a.vMr);
    Zks = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1000, "直播评论长度限制").d(b.a.vMq).b("FINDER_LIVE_COMMENT_SIZE_LIMIT", j.listOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(10) }), j.listOf(new String[] { "限制5条", "限制10条" }));
    Zkt = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否使用本地时间创建直播预告").b("FINDER_LIVE_NOTICE_TIME", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "使用服务器时间", "使用本地时间" }));
    Zku = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否展示开播分组入口").d(b.a.vMs).b("FINDER_LIVE_VISIBLITY_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zkv = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "开播分组分组是否插入假数据").b("FINDER_LIVE_VISIBLITY_DEBUG_DATA", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "否", "是" }));
    Zkw = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否打开观看直播的身份的入口").d(b.a.vMt).b("FINDER_LIVE_VISITOR_ROLE_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "打开", "非release打开", "关闭" }));
    Zkx = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否打开主播开播安全引导页的入口").d(b.a.vMu).b("FINDER_LIVE_PRECHECK_ENTRANCE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "打开", "非release打开", "关闭" }));
    Zky = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(28, "观看直播的身份昵称最大长度").d(b.a.vMv).b("FINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", j.listOf(new Integer[] { Integer.valueOf(14), Integer.valueOf(28), Integer.valueOf(32), Integer.valueOf(50) }), j.listOf(new String[] { "14", "28", "32", "50" }));
    Zkz = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "是否过滤自己的头像").d(b.a.vMw).b("FINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZkA = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播购物讲解图片大小").d(b.a.vMx).b("FINDER_LIVE_SHPOPPING_PICTURE_CONFIG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), j.listOf(new String[] { "10A", "12A", "20A", "30A" }));
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    ZkB = ((Context)localObject).getResources().getDimensionPixelSize(c.a.Edge_12A);
    ZkC = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "直播分享打开单流", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE");
    ZkD = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "横屏视频自动适配").d(b.a.vIJ).b("debugLandscapeVideoFit", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    ZkE = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "直播抽奖入口").d(b.a.vIK).b("debugFinderLiveLottery", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    ZkF = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(60, "抽奖气泡展示时长(秒)").d(b.a.vIL).b("FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", j.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(5), Integer.valueOf(30), Integer.valueOf(100) }), j.listOf(new String[] { "60秒", "5秒", "30秒", "100秒" })).aGU("T32");
    ZkG = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(60, "抽奖中气泡展示时长(秒)").d(b.a.vIM).b("FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", j.listOf(new Integer[] { Integer.valueOf(60), Integer.valueOf(5), Integer.valueOf(30), Integer.valueOf(200) }), j.listOf(new String[] { "60秒", "5秒", "30秒", "200秒" })).aGU("T32");
    ZkH = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "抽奖是否使用本地过滤策略(默认使用)").d(b.a.vIO);
    ZkI = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(10, "抽奖本地缓存的已看过抽奖个数").d(b.a.vIP);
    ZkJ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(5, "视频号直播feed缓存时间").d(b.a.vIQ);
    ZkK = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播是否预加载").d(b.a.vIR).b("FINDER_LIVE_ENABLE_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZkL = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(2, "视频号直播间切换预加载门槛").d(b.a.vIS).b("FINDER_LIVE_LIST_PRELOAD_SIZE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), j.listOf(new String[] { "0", "1", "2", "3" }));
    ZkM = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播getLiveMsg优化test").d(b.a.vIT).b("FINDER_LIVE_GETLIVEMSG_TEST", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZkN = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播是否本地过滤后台下发的extFlag").d(b.a.vIU).b("FINDER_LIVE_FILTER_ANCHOR_EXT_FLAG", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    ZkO = new c("重置直播勾选协议", (kotlin.g.a.b)a.b.Zlv);
    ZkP = new c("重置实名认证缓存", (kotlin.g.a.b)a.c.Zlw);
    ZkQ = new c("重置主播音乐引导缓存", (kotlin.g.a.b)a.a.Zlu);
    ZkR = new c("重置profile页商品绑定引导缓存", (kotlin.g.a.b)a.d.Zlx);
    ZkS = new c("重置直播多身份教育页", (kotlin.g.a.b)a.f.Zlz);
    ZkT = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播间列表是否增加额外的child空间").d(b.a.vJl).b("FINDER_LIVE_LAYOUT_ENABLE_EXTRA_SPACE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "允许", "不允许" }));
    ZkU = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "打开美颜实时调节器", "FINDER_LIVE_BEAUTY_DEBUG");
    ZkV = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号发布直播").d(b.a.vIs).b("debugFinderLive", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    ZkW = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播购物").d(b.a.vIt).b("debugFinderLiveShoppingEnable", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    ZkX = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播第三方购物").d(b.a.vIv).b("debugFinderLiveThreadPartyShoppingStrategy", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "中间页（实验状态）", "详情页（非实验状态）" }));
    ZkY = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "直播购物讲解气泡位置刷新频率").d(b.a.vIx);
    ZkZ = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "购物小程序版本").b("FINDER_LIVE_USING_DEBUG_MINIPRO", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) }), j.listOf(new String[] { "正式版", "测试版", "体验版" }));
    Zla = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "横向直播").d(b.a.vIu).b("debugFinderLiveLandscape", j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(0) }), j.listOf(new String[] { "打开", "关闭" }));
    Zlb = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播最多可选可见人数").b("LIVE_USER_MAX_COUNT", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(500) }), j.listOf(new String[] { "不启动", "3", "500" })).aGU("T5");
    Zlc = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播拉取评论时间间隔").d(b.a.vWq);
    Zld = new c("主播任务红点重置", (kotlin.g.a.b)a.n.ZlH);
    Zle = new c("直播发起红点重置", (kotlin.g.a.b)a.m.ZlG);
    Zlf = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播间测试过滤过时的cgi响应").d(b.a.vJr).b("FINDER_LIVE_FILTER_OUTDATED_RESP", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "过滤", "不过滤" }));
    Zlg = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "视频号直播清屏动画优化").d(b.a.vJu);
    Zlh = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(2147483647, "视频号直播网络质量弱网阈值").d(b.a.vJv);
    Zli = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(3, "feed流中观看直播可以计入uv的观看时间阈值").d(b.a.vJw);
    Zlj = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(1, "有封面url时隐藏loading").d(b.a.vJm).b("FINDER_LIVE_HIDE_LOADING_PROGRESS", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "隐藏loading", "不隐藏loading" }));
    Zlk = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "新版电商是否允许手动切换小窗").d(b.a.vJn).b("FINDER_LIVE_MANUAL_MINI_WINDOW", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zll = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "朋友tab直播列表mock数据", "FINDER_LIVE_LIST_CREATE_DEBUG_DATA");
    Zlm = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "朋友tab直播列表是否加入更多直播item").d(b.a.vIz).b("FINDER_LIVE_LIST_ENABLE_MORE_LIVE", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zln = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "视频号直播上下切换是否预热feed").d(b.a.vIV).b("FINDER_LIVE_RV_FEED_ENABLE_PRELOAD", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zlo = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播列表是否允许自动播放").d(b.a.vJo).b("FINDER_LIVE_LIST_AUTO_PLAY", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zlp = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "最近打赏列表人数").b("FINDER_LIVE_REWARD_MEMBER", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }), j.listOf(new String[] { "不设置", "3个", "14个", "40个" }));
    Zlq = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播购物预热第三方").d(b.a.vJp).b("FINDER_LIVE_PRELOAD_OTHERS_WEAPP", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zlr = new com.tencent.mm.plugin.findersdk.d.a.b.b.a(0, "直播送礼名称调整").d(b.a.vJq).b("FINDER_LIVE_ADJUST_GIFT_NAME", j.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), j.listOf(new String[] { "是", "否" }));
    Zls = new com.tencent.mm.plugin.findersdk.d.a.b.a.a(false, "开播后5s触发一个crash", "FINDER_LIVE_MANUAL_CRASH");
    AppMethodBeat.o(230872);
  }
  
  public static void aAh(int paramInt)
  {
    AppMethodBeat.i(230833);
    Log.i("Finder.FinderLiveConfig", "set LIVE_LICENSE value:".concat(String.valueOf(paramInt)));
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VDm, Integer.valueOf(paramInt));
    AppMethodBeat.o(230833);
  }
  
  public static void aAi(int paramInt)
  {
    AppMethodBeat.i(230853);
    Log.i("Finder.FinderLiveConfig", "set LIVE_LICENSE value:".concat(String.valueOf(paramInt)));
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VDn, Integer.valueOf(paramInt));
    AppMethodBeat.o(230853);
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilA()
  {
    return ZjM;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilB()
  {
    return ZjO;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilC()
  {
    return ZjP;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> ilD()
  {
    return ZjQ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a ilE()
  {
    return ZjR;
  }
  
  public static c ilF()
  {
    return ZjS;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilG()
  {
    return ZjT;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilH()
  {
    return ZjU;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilI()
  {
    return ZjV;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilJ()
  {
    return ZjW;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilK()
  {
    return ZjX;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilL()
  {
    return ZjZ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilM()
  {
    return Zka;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilN()
  {
    return Zkb;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilO()
  {
    return Zkc;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Boolean> ilP()
  {
    return Zkd;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilQ()
  {
    return Zkg;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilR()
  {
    return Zkh;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilS()
  {
    return Zki;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilT()
  {
    return Zkj;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> ilU()
  {
    return Zkk;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilV()
  {
    return Zkl;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilW()
  {
    return Zkm;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilX()
  {
    return Zkn;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilY()
  {
    return Zko;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilZ()
  {
    return Zkp;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilh()
  {
    return Zjt;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ili()
  {
    return Zju;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilj()
  {
    return Zjv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> ilk()
  {
    return Zjw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> ill()
  {
    return Zjx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<String> ilm()
  {
    return Zjy;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Long> iln()
  {
    return Zjz;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilo()
  {
    return ZjA;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilp()
  {
    return ZjB;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilq()
  {
    return ZjC;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilr()
  {
    return ZjD;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ils()
  {
    return ZjE;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilt()
  {
    return ZjF;
  }
  
  public static c ilu()
  {
    return ZjG;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilv()
  {
    return ZjH;
  }
  
  public static c ilw()
  {
    return ZjI;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilx()
  {
    return ZjJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ily()
  {
    return ZjK;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ilz()
  {
    return ZjL;
  }
  
  public static c imA()
  {
    return ZkO;
  }
  
  public static c imB()
  {
    return ZkP;
  }
  
  public static c imC()
  {
    return ZkQ;
  }
  
  public static c imD()
  {
    return ZkR;
  }
  
  public static c imE()
  {
    return ZkS;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imF()
  {
    return ZkT;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a imG()
  {
    return ZkU;
  }
  
  public static int imH()
  {
    AppMethodBeat.i(230831);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VDm, 0);
    AppMethodBeat.o(230831);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imI()
  {
    return ZkV;
  }
  
  public static boolean imJ()
  {
    AppMethodBeat.i(230834);
    if (((Number)ZkV.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(230834);
      return true;
    }
    AppMethodBeat.o(230834);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imK()
  {
    return ZkW;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imL()
  {
    return ZkX;
  }
  
  public static boolean imM()
  {
    AppMethodBeat.i(230835);
    if (((Number)ZkX.aSr()).intValue() == 0)
    {
      AppMethodBeat.o(230835);
      return true;
    }
    AppMethodBeat.o(230835);
    return false;
  }
  
  public static int imN()
  {
    AppMethodBeat.i(230836);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIw, 75);
    AppMethodBeat.o(230836);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imO()
  {
    return ZkY;
  }
  
  public static int imP()
  {
    AppMethodBeat.i(230837);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIE, 10);
    AppMethodBeat.o(230837);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imQ()
  {
    return ZkZ;
  }
  
  public static int imR()
  {
    AppMethodBeat.i(230839);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIF, 10);
    AppMethodBeat.o(230839);
    return i;
  }
  
  public static int imS()
  {
    AppMethodBeat.i(230840);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIG, 60);
    AppMethodBeat.o(230840);
    return i;
  }
  
  public static int imT()
  {
    AppMethodBeat.i(230841);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vID, 4000);
    AppMethodBeat.o(230841);
    return i;
  }
  
  public static int imU()
  {
    AppMethodBeat.i(230842);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIB, 100);
    AppMethodBeat.o(230842);
    return i;
  }
  
  public static int imV()
  {
    AppMethodBeat.i(230843);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIC, 3);
    AppMethodBeat.o(230843);
    return i;
  }
  
  public static boolean imW()
  {
    AppMethodBeat.i(230844);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIW, 1) == 1)
    {
      AppMethodBeat.o(230844);
      return true;
    }
    AppMethodBeat.o(230844);
    return false;
  }
  
  public static boolean imX()
  {
    AppMethodBeat.i(230845);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJb, 0) == 1)
    {
      AppMethodBeat.o(230845);
      return true;
    }
    AppMethodBeat.o(230845);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imY()
  {
    return Zla;
  }
  
  public static boolean imZ()
  {
    AppMethodBeat.i(230848);
    if (((Number)Zla.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(230848);
      return true;
    }
    AppMethodBeat.o(230848);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ima()
  {
    return Zkq;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imb()
  {
    return Zkr;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imc()
  {
    return Zks;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imd()
  {
    return Zkt;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ime()
  {
    return Zku;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imf()
  {
    return Zkv;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> img()
  {
    return Zkw;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imh()
  {
    return Zkx;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imi()
  {
    return Zky;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imj()
  {
    return Zkz;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imk()
  {
    return ZkA;
  }
  
  public static int iml()
  {
    AppMethodBeat.i(230815);
    switch (((Number)ZkA.aSr()).intValue())
    {
    default: 
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      i = localContext.getResources().getDimensionPixelSize(c.a.Edge_10A);
      AppMethodBeat.o(230815);
      return i;
    case 1: 
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      i = localContext.getResources().getDimensionPixelSize(c.a.Edge_12A);
      AppMethodBeat.o(230815);
      return i;
    case 2: 
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      i = localContext.getResources().getDimensionPixelSize(c.a.Edge_20A);
      AppMethodBeat.o(230815);
      return i;
    }
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    int i = localContext.getResources().getDimensionPixelSize(c.a.Edge_30A);
    AppMethodBeat.o(230815);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a imm()
  {
    return ZkC;
  }
  
  public static boolean imn()
  {
    AppMethodBeat.i(230821);
    if (((Number)ZkD.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(230821);
      return true;
    }
    AppMethodBeat.o(230821);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imo()
  {
    return ZkE;
  }
  
  public static boolean imp()
  {
    AppMethodBeat.i(230825);
    if (((Number)ZkE.aSr()).intValue() == 1)
    {
      AppMethodBeat.o(230825);
      return true;
    }
    AppMethodBeat.o(230825);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imq()
  {
    return ZkF;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imr()
  {
    return ZkG;
  }
  
  public static int ims()
  {
    AppMethodBeat.i(230827);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIN, 15);
    AppMethodBeat.o(230827);
    return i;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imt()
  {
    return ZkH;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imu()
  {
    return ZkI;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imv()
  {
    return ZkJ;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imw()
  {
    return ZkK;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imx()
  {
    return ZkL;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imy()
  {
    return ZkM;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> imz()
  {
    return ZkN;
  }
  
  public static boolean ina()
  {
    AppMethodBeat.i(230849);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vJD, 1) == 1)
    {
      AppMethodBeat.o(230849);
      return true;
    }
    AppMethodBeat.o(230849);
    return false;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inb()
  {
    return Zlb;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inc()
  {
    return Zlc;
  }
  
  public static int ind()
  {
    AppMethodBeat.i(230851);
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    int i = localf.aHp().getInt(ar.a.VDn, 0);
    AppMethodBeat.o(230851);
    return i;
  }
  
  public static c ine()
  {
    return Zld;
  }
  
  public static c inf()
  {
    return Zle;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ing()
  {
    return Zlf;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inh()
  {
    return Zlg;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ini()
  {
    return Zlh;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inj()
  {
    return Zli;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ink()
  {
    return Zlj;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inl()
  {
    return Zlk;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a inm()
  {
    return Zll;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inn()
  {
    return Zlm;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ino()
  {
    return Zln;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inp()
  {
    return Zlo;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inq()
  {
    return Zlp;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> inr()
  {
    return Zlq;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.a.b<Integer> ins()
  {
    return Zlr;
  }
  
  public static com.tencent.mm.plugin.findersdk.d.a.b.a.a jdMethod_int()
  {
    return Zls;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */