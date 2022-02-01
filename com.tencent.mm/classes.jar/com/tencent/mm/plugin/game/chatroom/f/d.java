package com.tencent.mm.plugin.game.chatroom.f;

import com.tencent.mm.kernel.c.a;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "Lcom/tencent/mm/kernel/service/IService;", "deleteAll", "", "chatroomName", "", "insertAll", "users", "", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "query", "userName", "limitCnt", "", "queryByLike", "keyword", "queryByUserNames", "userNameList", "queryMemberNum", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
  extends a
{
  public abstract List<c> SV(String paramString);
  
  public abstract long aFw(String paramString);
  
  public abstract List<c> aFx(String paramString);
  
  public abstract void aFy(String paramString);
  
  public abstract List<c> iP(String paramString1, String paramString2);
  
  public abstract List<c> y(List<String> paramList, String paramString);
  
  public abstract void z(List<? extends c> paramList, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.d
 * JD-Core Version:    0.7.0.1
 */