package com.tencent.mm.plugin.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  String vtU = null;
  public e vtV = null;
  public double vtW = 0.0D;
  public String vtX = "";
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(22438);
    if ((this.vtV == null) || (paramObject == null))
    {
      AppMethodBeat.o(22438);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(22438);
      return true;
    }
    boolean bool = Arrays.equals(((c)paramObject).vtV.vua.vuB, this.vtV.vua.vuB);
    AppMethodBeat.o(22438);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(22437);
    if (this.vtV == null)
    {
      AppMethodBeat.o(22437);
      return 0;
    }
    int i = Arrays.hashCode(this.vtV.vua.vuB);
    AppMethodBeat.o(22437);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.c
 * JD-Core Version:    0.7.0.1
 */