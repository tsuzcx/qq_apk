package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveConfig;", "", "micWaveThresHolder", "", "(I)V", "getMicWaveThresHolder", "()I", "setMicWaveThresHolder", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-core_release"})
public final class b
{
  public int klD = 0;
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (this.klD != paramObject.klD) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.klD;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199918);
    String str = "LiveConfig(micWaveThresHolder=" + this.klD + ")";
    AppMethodBeat.o(199918);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.b
 * JD-Core Version:    0.7.0.1
 */