package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  public String bUD = "";
  String jMX = null;
  public e jMY = null;
  public double jMZ = 0.0D;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(18327);
    if ((this.jMY == null) || (paramObject == null))
    {
      AppMethodBeat.o(18327);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(18327);
      return true;
    }
    boolean bool = Arrays.equals(((c)paramObject).jMY.jNc.jND, this.jMY.jNc.jND);
    AppMethodBeat.o(18327);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(18326);
    if (this.jMY == null)
    {
      AppMethodBeat.o(18326);
      return 0;
    }
    int i = Arrays.hashCode(this.jMY.jNc.jND);
    AppMethodBeat.o(18326);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */