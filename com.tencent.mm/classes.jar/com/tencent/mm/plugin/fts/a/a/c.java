package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public long BHT;
  public long BHU;
  public int BHV;
  public String BHW;
  public String fND;
  public int fNO;
  public int index;
  public int position;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(131671);
    c localc = (c)paramObject;
    if ((this.fND != null) && (this.fND.equals(localc.fND)))
    {
      AppMethodBeat.o(131671);
      return true;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(131671);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.c
 * JD-Core Version:    0.7.0.1
 */