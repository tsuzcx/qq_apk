package com.tencent.mm.plugin.forcenotify.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "forcePushId", "", "username", "nickname", "wording", "createTime", "", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getCreateTime", "()J", "getNickname", "getUsername", "getWording", "getItemId", "getItemType", "", "plugin-force-notify_release"})
public final class h
  extends e
{
  public final long createTime;
  public final String nfY;
  public final String nickname;
  public final String username;
  public final String wording;
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    super(paramString1);
    AppMethodBeat.i(253947);
    this.username = paramString2;
    this.nickname = paramString3;
    this.wording = paramString4;
    this.createTime = paramLong;
    this.nfY = paramString5;
    AppMethodBeat.o(253947);
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.h
 * JD-Core Version:    0.7.0.1
 */