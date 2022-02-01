package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "", "liveId", "", "audience", "", "micId", "sdkUserId", "micType", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAudience", "()Ljava/lang/String;", "getLiveId", "()J", "getMicId", "getMicType", "()I", "getSdkUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class f
{
  public final String ktE;
  public final String ktQ;
  public final String ktR;
  public final int ktS;
  public final long liveId;
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.liveId = paramLong;
    this.ktQ = paramString1;
    this.ktE = paramString2;
    this.ktR = paramString3;
    this.ktS = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199124);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.h(this.ktQ, paramObject.ktQ)) || (!p.h(this.ktE, paramObject.ktE)) || (!p.h(this.ktR, paramObject.ktR)) || (this.ktS != paramObject.ktS)) {}
      }
    }
    else
    {
      AppMethodBeat.o(199124);
      return true;
    }
    AppMethodBeat.o(199124);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(199120);
    long l = this.liveId;
    int m = (int)(l ^ l >>> 32);
    String str = this.ktQ;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.ktE;
      if (str == null) {
        break label115;
      }
    }
    label115:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.ktR;
      if (str != null) {
        k = str.hashCode();
      }
      int n = this.ktS;
      AppMethodBeat.o(199120);
      return ((j + (i + m * 31) * 31) * 31 + k) * 31 + n;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199117);
    String str = "CloseLiveMicInfo(liveId=" + this.liveId + ", audience=" + this.ktQ + ", micId=" + this.ktE + ", sdkUserId=" + this.ktR + ", micType=" + this.ktS + ")";
    AppMethodBeat.o(199117);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.f
 * JD-Core Version:    0.7.0.1
 */