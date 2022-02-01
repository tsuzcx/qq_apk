package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class a
{
  public a BJn;
  public boolean BJo;
  public List<a> ayS;
  public int end;
  public int start;
  
  public a(int paramInt1, int paramInt2, a parama)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.BJn = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131719);
    if (this.BJn == null)
    {
      str = String.format("[%d,%d]", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.end) });
      AppMethodBeat.o(131719);
      return str;
    }
    String str = String.format("%s [%d,%d]", new Object[] { this.BJn, Integer.valueOf(this.start), Integer.valueOf(this.end) });
    AppMethodBeat.o(131719);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.a
 * JD-Core Version:    0.7.0.1
 */