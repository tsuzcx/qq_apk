package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/CloseLiveInfo;", "", "liveId", "", "(J)V", "getLiveId", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-logic_release"})
public final class e
{
  public final long liveId;
  
  public e(long paramLong)
  {
    this.liveId = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if (this.liveId != paramObject.liveId) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.liveId;
    return (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207560);
    String str = "CloseLiveInfo(liveId=" + this.liveId + ")";
    AppMethodBeat.o(207560);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.e
 * JD-Core Version:    0.7.0.1
 */