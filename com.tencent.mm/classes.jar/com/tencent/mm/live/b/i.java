package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/FinderLiveCloseLiveMicInfo;", "", "liveId", "", "objectId", "liveMicId", "", "seq", "businessType", "", "(JJLjava/lang/String;Ljava/lang/String;I)V", "getBusinessType", "()I", "getLiveId", "()J", "getLiveMicId", "()Ljava/lang/String;", "getObjectId", "getSeq", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class i
{
  private final int businessType;
  private final long hFK;
  public final String hFO;
  private final long liveId;
  private final String seq;
  
  public i(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.hFO = paramString1;
    this.seq = paramString2;
    this.businessType = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207572);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((this.liveId != paramObject.liveId) || (this.hFK != paramObject.hFK) || (!p.j(this.hFO, paramObject.hFO)) || (!p.j(this.seq, paramObject.seq)) || (this.businessType != paramObject.businessType)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207572);
      return true;
    }
    AppMethodBeat.o(207572);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(207571);
    long l = this.liveId;
    int k = (int)(l ^ l >>> 32);
    l = this.hFK;
    int m = (int)(l ^ l >>> 32);
    String str = this.hFO;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.seq;
      if (str != null) {
        j = str.hashCode();
      }
      int n = this.businessType;
      AppMethodBeat.o(207571);
      return ((i + (k * 31 + m) * 31) * 31 + j) * 31 + n;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207570);
    String str = "FinderLiveCloseLiveMicInfo(liveId=" + this.liveId + ", objectId=" + this.hFK + ", liveMicId=" + this.hFO + ", seq=" + this.seq + ", businessType=" + this.businessType + ")";
    AppMethodBeat.o(207570);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.i
 * JD-Core Version:    0.7.0.1
 */