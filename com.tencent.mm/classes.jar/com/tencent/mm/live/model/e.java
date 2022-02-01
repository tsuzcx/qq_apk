package com.tencent.mm.live.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/CloseLiveInfo;", "", "liveId", "", "(J)V", "getLiveId", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public final long liveId;
  
  public e(long paramLong)
  {
    this.liveId = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
    } while (this.liveId == paramObject.liveId);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(246592);
    int i = q.a..ExternalSyntheticBackport0.m(this.liveId);
    AppMethodBeat.o(246592);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246584);
    String str = "CloseLiveInfo(liveId=" + this.liveId + ')';
    AppMethodBeat.o(246584);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.model.e
 * JD-Core Version:    0.7.0.1
 */