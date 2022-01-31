package com.tencent.mm.plugin.fts.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class a
{
  public List<a> aWy;
  public int end;
  public a mTm;
  public boolean mTn;
  public int start;
  
  public a(int paramInt1, int paramInt2, a parama)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.mTm = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114283);
    if (this.mTm == null)
    {
      str = String.format("[%d,%d]", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.end) });
      AppMethodBeat.o(114283);
      return str;
    }
    String str = String.format("%s [%d,%d]", new Object[] { this.mTm, Integer.valueOf(this.start), Integer.valueOf(this.end) });
    AppMethodBeat.o(114283);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.a
 * JD-Core Version:    0.7.0.1
 */