package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "", "addSyncHandler", "", "cmdId", "", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "doSync", "selector", "scene", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "unregister", "Companion", "plugin-finder-base_release"})
public abstract interface g
{
  public static final a wZX = a.wZZ;
  
  public abstract void a(int paramInt, h paramh);
  
  public abstract void a(MMFinderUI paramMMFinderUI);
  
  public abstract void b(int paramInt, h paramh);
  
  public abstract void b(MMFinderUI paramMMFinderUI);
  
  public abstract void gu(int paramInt1, int paramInt2);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension$Companion;", "", "()V", "CmdId_GetAliasInfo", "", "CmdId_GetFansCount", "CmdId_GetFollowCount", "CmdId_GetFollower", "CmdId_GetMention", "CmdId_GetMentionCount", "CmdId_GetMyAcct", "CmdId_GetNotInterestedConfig", "CmdId_GetRedDot", "CmdId_GetSpamObject", "CmdId_GetWxMentionCount", "CmdId_ObjectWordingConfig", "CmdId_PRE_FETCH", "CmdId_REVOKE_TAB_TIPS", "CmdId_ReInit", "CmdId_RevokeRedDot", "CmdId_TAB_TIPS", "MMFinder_Sync_Selctor_HotTabTitle", "SELECTOR_ALL", "SELECTOR_ALL_MSG", "SELECTOR_ARRAY", "", "Lkotlin/Pair;", "", "getSELECTOR_ARRAY", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "SELECTOR_FANS_COUNT", "SELECTOR_FOLLOWER", "SELECTOR_FOLLOW_COUNT", "SELECTOR_MENTION_COUNT", "SELECTOR_NOT_INTERESTED_CONFIG", "SELECTOR_OTHERS", "SELECTOR_PRE_FETCH", "SELECTOR_REDDOT", "SELECTOR_REINT", "SELECTOR_SPAM_OBJECT", "SELECTOR_SYNC_FINDER_ALIAS", "SELECTOR_TAB_REVOKE_TAB_TIPS", "SELECTOR_TAB_TIPS", "SELECTOR_TAB_TIPS_HOT", "SELECTOR_WX_MENTION_COUNT", "SYNC_SCENE_EXPOSE_REPLACE", "SYNC_SCENE_FROM_ALIAS_CHECK", "SYNC_SCENE_FROM_ENTER_TL", "SYNC_SCENE_FROM_EXPIRED_CHECK", "SYNC_SCENE_FROM_INIT", "SYNC_SCENE_FROM_LOOP", "SYNC_SCENE_FROM_MIN_SYNC", "SYNC_SCENE_FROM_MIN_SYNC_2", "SYNC_SCENE_FROM_START", "SYNC_SCENE_FROM_UI_PROFILE", "plugin-finder-base_release"})
  public static final class a
  {
    private static final o<Integer, String>[] wZY;
    
    static
    {
      AppMethodBeat.i(165146);
      wZZ = new a();
      wZY = new o[] { new o(Integer.valueOf(1), "MENTION_COUNT"), new o(Integer.valueOf(4), "FOLLOWER"), new o(Integer.valueOf(8), "REDDOT"), new o(Integer.valueOf(16), "FOLLOW_COUNT"), new o(Integer.valueOf(32), "FANS_COUNT"), new o(Integer.valueOf(64), "SPAM_OBJECT"), new o(Integer.valueOf(128), "WX_MENTION_COUNT"), new o(Integer.valueOf(256), "NOT_INTERESTED_CONFIG"), new o(Integer.valueOf(2048), "SELECTOR_PRE_FETCH"), new o(Integer.valueOf(4096), "SELECTOR_TAB_TIPS"), new o(Integer.valueOf(32768), "SELECTOR_TAB_TIPS_HOT") };
      AppMethodBeat.o(165146);
    }
    
    public static o<Integer, String>[] dnm()
    {
      return wZY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.g
 * JD-Core Version:    0.7.0.1
 */