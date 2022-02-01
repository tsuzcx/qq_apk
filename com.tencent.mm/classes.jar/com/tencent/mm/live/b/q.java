package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "", "liveId", "", "audience", "", "headImg", "nickName", "sdkUid", "micId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "getHeadImg", "getLiveId", "()J", "getMicId", "getNickName", "getSdkUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class q
{
  public final String hFG;
  public final String hFJ;
  public final String hFz;
  public final String hIc;
  public final long liveId;
  public final String nickName;
  
  public q(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.liveId = paramLong;
    this.hFJ = paramString1;
    this.hIc = paramString2;
    this.nickName = paramString3;
    this.hFG = paramString4;
    this.hFz = paramString5;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207655);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.j(this.hFJ, paramObject.hFJ)) || (!p.j(this.hIc, paramObject.hIc)) || (!p.j(this.nickName, paramObject.nickName)) || (!p.j(this.hFG, paramObject.hFG)) || (!p.j(this.hFz, paramObject.hFz))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207655);
      return true;
    }
    AppMethodBeat.o(207655);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(207654);
    long l = this.liveId;
    int i1 = (int)(l ^ l >>> 32);
    String str = this.hFJ;
    int i;
    int j;
    label59:
    int k;
    if (str != null)
    {
      i = str.hashCode();
      str = this.hIc;
      if (str == null) {
        break label152;
      }
      j = str.hashCode();
      str = this.nickName;
      if (str == null) {
        break label157;
      }
      k = str.hashCode();
      label76:
      str = this.hFG;
      if (str == null) {
        break label162;
      }
    }
    label152:
    label157:
    label162:
    for (int m = str.hashCode();; m = 0)
    {
      str = this.hFz;
      if (str != null) {
        n = str.hashCode();
      }
      AppMethodBeat.o(207654);
      return (m + (k + (j + (i + i1 * 31) * 31) * 31) * 31) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label59;
      k = 0;
      break label76;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207653);
    String str = "LiveMicSuccessInfo(liveId=" + this.liveId + ", audience=" + this.hFJ + ", headImg=" + this.hIc + ", nickName=" + this.nickName + ", sdkUid=" + this.hFG + ", micId=" + this.hFz + ")";
    AppMethodBeat.o(207653);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.q
 * JD-Core Version:    0.7.0.1
 */