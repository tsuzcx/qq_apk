package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveMicSuccessInfo;", "", "liveId", "", "audience", "", "headImg", "nickName", "sdkUid", "micId", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "getHeadImg", "getLiveId", "()J", "getMicId", "getNickName", "getSdkUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class n
{
  public final String ktE;
  public final String ktN;
  public final String ktQ;
  public final String kvw;
  public final long liveId;
  public final String nickName;
  
  public n(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.liveId = paramLong;
    this.ktQ = paramString1;
    this.kvw = paramString2;
    this.nickName = paramString3;
    this.ktN = paramString4;
    this.ktE = paramString5;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197577);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.h(this.ktQ, paramObject.ktQ)) || (!p.h(this.kvw, paramObject.kvw)) || (!p.h(this.nickName, paramObject.nickName)) || (!p.h(this.ktN, paramObject.ktN)) || (!p.h(this.ktE, paramObject.ktE))) {}
      }
    }
    else
    {
      AppMethodBeat.o(197577);
      return true;
    }
    AppMethodBeat.o(197577);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(197575);
    long l = this.liveId;
    int i1 = (int)(l ^ l >>> 32);
    String str = this.ktQ;
    int i;
    int j;
    label59:
    int k;
    if (str != null)
    {
      i = str.hashCode();
      str = this.kvw;
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
      str = this.ktN;
      if (str == null) {
        break label162;
      }
    }
    label152:
    label157:
    label162:
    for (int m = str.hashCode();; m = 0)
    {
      str = this.ktE;
      if (str != null) {
        n = str.hashCode();
      }
      AppMethodBeat.o(197575);
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
    AppMethodBeat.i(197571);
    String str = "LiveMicSuccessInfo(liveId=" + this.liveId + ", audience=" + this.ktQ + ", headImg=" + this.kvw + ", nickName=" + this.nickName + ", sdkUid=" + this.ktN + ", micId=" + this.ktE + ")";
    AppMethodBeat.o(197571);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.n
 * JD-Core Version:    0.7.0.1
 */