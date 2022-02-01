package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "", "liveId", "", "micId", "", "uid", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLiveId", "()J", "getMicId", "()Ljava/lang/String;", "getRoomId", "getSdkUid", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class b
{
  public final String ktE;
  public final String ktM;
  public final String ktN;
  public final long liveId;
  public final String roomId;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.liveId = paramLong;
    this.ktE = paramString1;
    this.ktM = paramString2;
    this.roomId = paramString3;
    this.ktN = paramString4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197488);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.h(this.ktE, paramObject.ktE)) || (!p.h(this.ktM, paramObject.ktM)) || (!p.h(this.roomId, paramObject.roomId)) || (!p.h(this.ktN, paramObject.ktN))) {}
      }
    }
    else
    {
      AppMethodBeat.o(197488);
      return true;
    }
    AppMethodBeat.o(197488);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(197484);
    long l = this.liveId;
    int n = (int)(l ^ l >>> 32);
    String str = this.ktE;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.ktM;
      if (str == null) {
        break label128;
      }
      j = str.hashCode();
      label59:
      str = this.roomId;
      if (str == null) {
        break label133;
      }
    }
    label128:
    label133:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.ktN;
      if (str != null) {
        m = str.hashCode();
      }
      AppMethodBeat.o(197484);
      return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label59;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197481);
    String str = "ApplyLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.ktE + ", uid=" + this.ktM + ", roomId=" + this.roomId + ", sdkUid=" + this.ktN + ")";
    AppMethodBeat.o(197481);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.b
 * JD-Core Version:    0.7.0.1
 */