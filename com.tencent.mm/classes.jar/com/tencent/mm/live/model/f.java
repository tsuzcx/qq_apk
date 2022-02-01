package com.tencent.mm.live.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "", "liveId", "", "audience", "", "micId", "sdkUserId", "micType", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAudience", "()Ljava/lang/String;", "getLiveId", "()J", "getMicId", "getMicType", "()I", "getSdkUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public final long liveId;
  public final String mXK;
  public final String mXL;
  public final int mXM;
  public final String mXx;
  
  public f(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.liveId = paramLong;
    this.mXK = paramString1;
    this.mXx = paramString2;
    this.mXL = paramString3;
    this.mXM = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246569);
    if (this == paramObject)
    {
      AppMethodBeat.o(246569);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(246569);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(246569);
      return false;
    }
    if (!s.p(this.mXK, paramObject.mXK))
    {
      AppMethodBeat.o(246569);
      return false;
    }
    if (!s.p(this.mXx, paramObject.mXx))
    {
      AppMethodBeat.o(246569);
      return false;
    }
    if (!s.p(this.mXL, paramObject.mXL))
    {
      AppMethodBeat.o(246569);
      return false;
    }
    if (this.mXM != paramObject.mXM)
    {
      AppMethodBeat.o(246569);
      return false;
    }
    AppMethodBeat.o(246569);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(246561);
    int m = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int i;
    int j;
    if (this.mXK == null)
    {
      i = 0;
      if (this.mXx != null) {
        break label87;
      }
      j = 0;
      label34:
      if (this.mXL != null) {
        break label98;
      }
    }
    for (;;)
    {
      int n = this.mXM;
      AppMethodBeat.o(246561);
      return ((j + (i + m * 31) * 31) * 31 + k) * 31 + n;
      i = this.mXK.hashCode();
      break;
      label87:
      j = this.mXx.hashCode();
      break label34;
      label98:
      k = this.mXL.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246554);
    String str = "CloseLiveMicInfo(liveId=" + this.liveId + ", audience=" + this.mXK + ", micId=" + this.mXx + ", sdkUserId=" + this.mXL + ", micType=" + this.mXM + ')';
    AppMethodBeat.o(246554);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.f
 * JD-Core Version:    0.7.0.1
 */