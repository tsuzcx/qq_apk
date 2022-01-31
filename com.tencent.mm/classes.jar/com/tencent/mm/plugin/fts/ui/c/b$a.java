package com.tencent.mm.plugin.fts.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  public String feA;
  public int itemType;
  public long mZT;
  public long naC;
  public int position;
  
  public b$a(b paramb) {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(152165);
    a locala = (a)paramObject;
    if ((this.feA != null) && (this.feA.equals(locala.feA)))
    {
      AppMethodBeat.o(152165);
      return true;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(152165);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.c.b.a
 * JD-Core Version:    0.7.0.1
 */