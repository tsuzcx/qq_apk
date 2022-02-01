package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "", "addSyncHandler", "", "cmdId", "", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "doSync", "selector", "scene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "register", "activity", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "unregister", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j
{
  public static final a Axh = a.Axi;
  
  public abstract void a(int paramInt1, int paramInt2, bui parambui);
  
  public abstract void a(int paramInt, k paramk);
  
  public abstract void b(int paramInt, k paramk);
  
  public abstract void c(MMFinderUI paramMMFinderUI);
  
  public abstract void d(MMFinderUI paramMMFinderUI);
  
  public abstract void ho(int paramInt1, int paramInt2);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension$Companion;", "", "()V", "CmdId_GetAliasInfo", "", "CmdId_GetFansCount", "CmdId_GetFollowCount", "CmdId_GetFollower", "CmdId_GetMention", "CmdId_GetMentionCount", "CmdId_GetMyAcct", "CmdId_GetNotInterestedConfig", "CmdId_GetRedDot", "CmdId_GetSpamObject", "CmdId_GetWxMentionCount", "CmdId_ObjectWordingConfig", "CmdId_PRE_FETCH", "CmdId_REVOKE_TAB_TIPS", "CmdId_ReInit", "CmdId_RevokeRedDot", "CmdId_TAB_TIPS", "MMFinder_Sync_Selctor_HotTabTitle", "SELECTOR_ALL", "SELECTOR_ALL_MSG", "SELECTOR_ARRAY", "", "Lkotlin/Pair;", "", "getSELECTOR_ARRAY", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "SELECTOR_FANS_COUNT", "SELECTOR_FOLLOWER", "SELECTOR_FOLLOW_COUNT", "SELECTOR_MENTION_COUNT", "SELECTOR_NOT_INTERESTED_CONFIG", "SELECTOR_OTHERS", "SELECTOR_PRE_FETCH", "SELECTOR_REDDOT", "SELECTOR_REINT", "SELECTOR_SPAM_OBJECT", "SELECTOR_SYNC_FINDER_ALIAS", "SELECTOR_TAB_REVOKE_TAB_TIPS", "SELECTOR_TAB_TIPS", "SELECTOR_TAB_TIPS_HOT", "SELECTOR_WX_MENTION_COUNT", "SYNC_SCENE_EXPOSE_REPLACE", "SYNC_SCENE_FROM_ALIAS_CHECK", "SYNC_SCENE_FROM_BYP_ACTION_NOTIFY_FINDER_REDDOT", "SYNC_SCENE_FROM_ENTER_TL", "SYNC_SCENE_FROM_EXPIRED_CHECK", "SYNC_SCENE_FROM_INIT", "SYNC_SCENE_FROM_LOOP", "SYNC_SCENE_FROM_MIN_SYNC", "SYNC_SCENE_FROM_MIN_SYNC_2", "SYNC_SCENE_FROM_START", "SYNC_SCENE_FROM_UI_PROFILE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final r<Integer, String>[] Axj;
    
    static
    {
      AppMethodBeat.i(165146);
      Axi = new a();
      Axj = new r[] { new r(Integer.valueOf(1), "MENTION_COUNT"), new r(Integer.valueOf(4), "FOLLOWER"), new r(Integer.valueOf(8), "REDDOT"), new r(Integer.valueOf(16), "FOLLOW_COUNT"), new r(Integer.valueOf(32), "FANS_COUNT"), new r(Integer.valueOf(64), "SPAM_OBJECT"), new r(Integer.valueOf(128), "WX_MENTION_COUNT"), new r(Integer.valueOf(256), "NOT_INTERESTED_CONFIG"), new r(Integer.valueOf(2048), "SELECTOR_PRE_FETCH"), new r(Integer.valueOf(4096), "SELECTOR_TAB_TIPS"), new r(Integer.valueOf(32768), "SELECTOR_TAB_TIPS_HOT") };
      AppMethodBeat.o(165146);
    }
    
    public static r<Integer, String>[] dUp()
    {
      return Axj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.api.j
 * JD-Core Version:    0.7.0.1
 */