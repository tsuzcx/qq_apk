package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public long HsA;
  public long HsB;
  public int HsC;
  public String HsD;
  public String HsE;
  public long HsF;
  public String hTs;
  public int index;
  public int itemType;
  public int position;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(131671);
    e locale = (e)paramObject;
    if ((this.hTs != null) && (this.hTs.equals(locale.hTs)))
    {
      AppMethodBeat.o(131671);
      return true;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(131671);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.e
 * JD-Core Version:    0.7.0.1
 */