package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int dpE;
  public String dpt;
  public int index;
  public int position;
  public long sxH;
  public long sxI;
  public int sxJ;
  public String sxK;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(131671);
    c localc = (c)paramObject;
    if ((this.dpt != null) && (this.dpt.equals(localc.dpt)))
    {
      AppMethodBeat.o(131671);
      return true;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(131671);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.c
 * JD-Core Version:    0.7.0.1
 */