package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveConfig;", "", "micWaveThresHolder", "", "(I)V", "getMicWaveThresHolder", "()I", "setMicWaveThresHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public int mMI = 0;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
    } while (this.mMI == paramObject.mMI);
    return false;
  }
  
  public final int hashCode()
  {
    return this.mMI;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(247917);
    String str = "LiveConfig(micWaveThresHolder=" + this.mMI + ')';
    AppMethodBeat.o(247917);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.c
 * JD-Core Version:    0.7.0.1
 */