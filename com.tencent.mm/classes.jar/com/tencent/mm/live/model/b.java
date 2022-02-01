package com.tencent.mm.live.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "", "liveId", "", "micId", "", "uid", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLiveId", "()J", "getMicId", "()Ljava/lang/String;", "getRoomId", "getSdkUid", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public final long liveId;
  public final String mXG;
  public final String mXH;
  public final String mXx;
  public final String roomId;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.liveId = paramLong;
    this.mXx = paramString1;
    this.mXG = paramString2;
    this.roomId = paramString3;
    this.mXH = paramString4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246605);
    if (this == paramObject)
    {
      AppMethodBeat.o(246605);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(246605);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(246605);
      return false;
    }
    if (!s.p(this.mXx, paramObject.mXx))
    {
      AppMethodBeat.o(246605);
      return false;
    }
    if (!s.p(this.mXG, paramObject.mXG))
    {
      AppMethodBeat.o(246605);
      return false;
    }
    if (!s.p(this.roomId, paramObject.roomId))
    {
      AppMethodBeat.o(246605);
      return false;
    }
    if (!s.p(this.mXH, paramObject.mXH))
    {
      AppMethodBeat.o(246605);
      return false;
    }
    AppMethodBeat.o(246605);
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(246595);
    int n = q.a..ExternalSyntheticBackport0.m(this.liveId);
    int i;
    int j;
    label35:
    int k;
    if (this.mXx == null)
    {
      i = 0;
      if (this.mXG != null) {
        break label91;
      }
      j = 0;
      if (this.roomId != null) {
        break label102;
      }
      k = 0;
      label44:
      if (this.mXH != null) {
        break label113;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(246595);
      return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
      i = this.mXx.hashCode();
      break;
      label91:
      j = this.mXG.hashCode();
      break label35;
      label102:
      k = this.roomId.hashCode();
      break label44;
      label113:
      m = this.mXH.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246585);
    String str = "ApplyLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.mXx + ", uid=" + this.mXG + ", roomId=" + this.roomId + ", sdkUid=" + this.mXH + ')';
    AppMethodBeat.o(246585);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.model.b
 * JD-Core Version:    0.7.0.1
 */