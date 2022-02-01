package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/ApplyLiveMicInfo;", "", "liveId", "", "micId", "", "uid", "roomId", "sdkUid", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLiveId", "()J", "getMicId", "()Ljava/lang/String;", "getRoomId", "getSdkUid", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class b
{
  public final String hFF;
  public final String hFG;
  public final String hFz;
  public final long liveId;
  public final String roomId;
  
  public b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.liveId = paramLong;
    this.hFz = paramString1;
    this.hFF = paramString2;
    this.roomId = paramString3;
    this.hFG = paramString4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207555);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.j(this.hFz, paramObject.hFz)) || (!p.j(this.hFF, paramObject.hFF)) || (!p.j(this.roomId, paramObject.roomId)) || (!p.j(this.hFG, paramObject.hFG))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207555);
      return true;
    }
    AppMethodBeat.o(207555);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(207554);
    long l = this.liveId;
    int n = (int)(l ^ l >>> 32);
    String str = this.hFz;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.hFF;
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
      str = this.hFG;
      if (str != null) {
        m = str.hashCode();
      }
      AppMethodBeat.o(207554);
      return (k + (j + (i + n * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label59;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207553);
    String str = "ApplyLiveMicInfo(liveId=" + this.liveId + ", micId=" + this.hFz + ", uid=" + this.hFF + ", roomId=" + this.roomId + ", sdkUid=" + this.hFG + ")";
    AppMethodBeat.o(207553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.b
 * JD-Core Version:    0.7.0.1
 */