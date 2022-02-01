package com.tencent.mm.plugin.forcenotify.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "forcePushId", "", "avatarUrl", "nickname", "wording", "feedId", "liveId", "nonceId", "authIconUrl", "subject", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthIconUrl", "()Ljava/lang/String;", "getAvatarUrl", "getFeedId", "getLiveId", "getNickname", "getNonceId", "getSubject", "getWording", "getItemId", "", "getItemType", "", "plugin-force-notify_release"})
public final class g
  extends e
{
  public final String BDX;
  public final String authIconUrl;
  public final String feedId;
  public final String kwM;
  public final String nfY;
  public final String nickname;
  public final String nonceId;
  public final String wording;
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    super(paramString1);
    AppMethodBeat.i(253062);
    this.nfY = paramString2;
    this.nickname = paramString3;
    this.wording = paramString4;
    this.feedId = paramString5;
    this.kwM = paramString6;
    this.nonceId = paramString7;
    this.authIconUrl = paramString8;
    this.BDX = paramString9;
    AppMethodBeat.o(253062);
  }
  
  public final int bAQ()
  {
    return 1;
  }
  
  public final long mf()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.g
 * JD-Core Version:    0.7.0.1
 */