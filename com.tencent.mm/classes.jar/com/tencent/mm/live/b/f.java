package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/CloseLiveMicInfo;", "", "liveId", "", "audience", "", "micId", "(JLjava/lang/String;Ljava/lang/String;)V", "getAudience", "()Ljava/lang/String;", "getLiveId", "()J", "getMicId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-logic_release"})
public final class f
{
  public final String hFJ;
  public final String hFz;
  public final long liveId;
  
  public f(long paramLong, String paramString1, String paramString2)
  {
    this.liveId = paramLong;
    this.hFJ = paramString1;
    this.hFz = paramString2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207563);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((this.liveId != paramObject.liveId) || (!p.j(this.hFJ, paramObject.hFJ)) || (!p.j(this.hFz, paramObject.hFz))) {}
      }
    }
    else
    {
      AppMethodBeat.o(207563);
      return true;
    }
    AppMethodBeat.o(207563);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(207562);
    long l = this.liveId;
    int k = (int)(l ^ l >>> 32);
    String str = this.hFJ;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.hFz;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(207562);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207561);
    String str = "CloseLiveMicInfo(liveId=" + this.liveId + ", audience=" + this.hFJ + ", micId=" + this.hFz + ")";
    AppMethodBeat.o(207561);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.f
 * JD-Core Version:    0.7.0.1
 */