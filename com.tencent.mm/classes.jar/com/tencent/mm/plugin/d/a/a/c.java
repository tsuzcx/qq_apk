package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class c
{
  public String cDv = "";
  String nom = null;
  public e non = null;
  public double noo = 0.0D;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(22438);
    if ((this.non == null) || (paramObject == null))
    {
      AppMethodBeat.o(22438);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(22438);
      return true;
    }
    boolean bool = Arrays.equals(((c)paramObject).non.nor.noS, this.non.nor.noS);
    AppMethodBeat.o(22438);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(22437);
    if (this.non == null)
    {
      AppMethodBeat.o(22437);
      return 0;
    }
    int i = Arrays.hashCode(this.non.nor.noS);
    AppMethodBeat.o(22437);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */