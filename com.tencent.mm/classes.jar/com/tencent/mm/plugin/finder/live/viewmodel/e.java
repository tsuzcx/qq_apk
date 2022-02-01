package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "", "sdkUserId", "", "headUrl", "username", "nickname", "micType", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getHeadUrl", "()Ljava/lang/String;", "getMicType", "()I", "getNickname", "getSdkUserId", "getSessionId", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class e
{
  public final String headUrl;
  public final String nickname;
  public final String sessionId;
  public final String uCo;
  public final int uCx;
  public final String username;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    this.uCo = paramString1;
    this.headUrl = paramString2;
    this.username = paramString3;
    this.nickname = paramString4;
    this.uCx = paramInt;
    this.sessionId = paramString5;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(247888);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.j(this.uCo, paramObject.uCo)) || (!p.j(this.headUrl, paramObject.headUrl)) || (!p.j(this.username, paramObject.username)) || (!p.j(this.nickname, paramObject.nickname)) || (this.uCx != paramObject.uCx) || (!p.j(this.sessionId, paramObject.sessionId))) {}
      }
    }
    else
    {
      AppMethodBeat.o(247888);
      return true;
    }
    AppMethodBeat.o(247888);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(247887);
    String str = this.uCo;
    int i;
    int j;
    label42:
    int k;
    if (str != null)
    {
      i = str.hashCode();
      str = this.headUrl;
      if (str == null) {
        break label141;
      }
      j = str.hashCode();
      str = this.username;
      if (str == null) {
        break label146;
      }
      k = str.hashCode();
      label59:
      str = this.nickname;
      if (str == null) {
        break label151;
      }
    }
    label141:
    label146:
    label151:
    for (int m = str.hashCode();; m = 0)
    {
      int i1 = this.uCx;
      str = this.sessionId;
      if (str != null) {
        n = str.hashCode();
      }
      AppMethodBeat.o(247887);
      return ((m + (k + (j + i * 31) * 31) * 31) * 31 + i1) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label59;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247886);
    String str = "FinderLiveLinkMicUser(sdkUserId=" + this.uCo + ", headUrl=" + this.headUrl + ", username=" + this.username + ", nickname=" + this.nickname + ", micType=" + this.uCx + ", sessionId=" + this.sessionId + ")";
    AppMethodBeat.o(247886);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.e
 * JD-Core Version:    0.7.0.1
 */