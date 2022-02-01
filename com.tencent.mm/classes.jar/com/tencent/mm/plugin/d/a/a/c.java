package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  public String dfJ = "";
  String pfL = null;
  public e pfM = null;
  public double pfN = 0.0D;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(22438);
    if ((this.pfM == null) || (paramObject == null))
    {
      AppMethodBeat.o(22438);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(22438);
      return true;
    }
    boolean bool = Arrays.equals(((c)paramObject).pfM.pfQ.pgr, this.pfM.pfQ.pgr);
    AppMethodBeat.o(22438);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(22437);
    if (this.pfM == null)
    {
      AppMethodBeat.o(22437);
      return 0;
    }
    int i = Arrays.hashCode(this.pfM.pfQ.pgr);
    AppMethodBeat.o(22437);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */