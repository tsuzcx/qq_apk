package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.o;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension$Companion;", "", "()V", "CmdId_GetFansCount", "", "CmdId_GetFollowCount", "CmdId_GetFollower", "CmdId_GetMention", "CmdId_GetMentionCount", "CmdId_GetMyAcct", "CmdId_GetNotInterestedConfig", "CmdId_GetRedDot", "CmdId_GetSpamObject", "CmdId_GetWxMentionCount", "CmdId_PRE_FETCH", "CmdId_REVOKE_TAB_TIPS", "CmdId_ReInit", "CmdId_TAB_TIPS", "SELECTOR_ALL", "SELECTOR_ALL_MSG", "SELECTOR_ARRAY", "", "Lkotlin/Pair;", "", "getSELECTOR_ARRAY", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "SELECTOR_FANS_COUNT", "SELECTOR_FOLLOWER", "SELECTOR_FOLLOW_COUNT", "SELECTOR_MENTION_COUNT", "SELECTOR_NOT_INTERESTED_CONFIG", "SELECTOR_OTHERS", "SELECTOR_PRE_FETCH", "SELECTOR_REDDOT", "SELECTOR_REINT", "SELECTOR_SPAM_OBJECT", "SELECTOR_TAB_REVOKE_TAB_TIPS", "SELECTOR_TAB_TIPS", "SELECTOR_WX_MENTION_COUNT", "SYNC_SCENE_FROM_ENTER_TL", "SYNC_SCENE_FROM_INIT", "SYNC_SCENE_FROM_LOOP", "SYNC_SCENE_FROM_MIN_SYNC", "SYNC_SCENE_FROM_MIN_SYNC_2", "SYNC_SCENE_FROM_START", "SYNC_SCENE_FROM_UI_PROFILE", "plugin-finder_release"})
public final class d$a
{
  private static final o<Integer, String>[] qWx;
  
  static
  {
    AppMethodBeat.i(165146);
    qWy = new a();
    qWx = new o[] { new o(Integer.valueOf(1), "MENTION_COUNT"), new o(Integer.valueOf(4), "FOLLOWER"), new o(Integer.valueOf(8), "REDDOT"), new o(Integer.valueOf(16), "FOLLOW_COUNT"), new o(Integer.valueOf(32), "FANS_COUNT"), new o(Integer.valueOf(64), "SPAM_OBJECT"), new o(Integer.valueOf(128), "WX_MENTION_COUNT"), new o(Integer.valueOf(256), "NOT_INTERESTED_CONFIG"), new o(Integer.valueOf(2048), "SELECTOR_PRE_FETCH"), new o(Integer.valueOf(4096), "SELECTOR_TAB_TIPS") };
    AppMethodBeat.o(165146);
  }
  
  public static o<Integer, String>[] crY()
  {
    return qWx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.d.a
 * JD-Core Version:    0.7.0.1
 */