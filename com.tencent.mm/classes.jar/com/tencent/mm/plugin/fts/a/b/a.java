package com.tencent.mm.plugin.fts.a.b;

import java.util.List;

final class a
{
  public List<a> aPf;
  public int end;
  public a kxx;
  public boolean kxy;
  public int start;
  
  public a(int paramInt1, int paramInt2, a parama)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.kxx = parama;
  }
  
  public final String toString()
  {
    if (this.kxx == null) {
      return String.format("[%d,%d]", new Object[] { Integer.valueOf(this.start), Integer.valueOf(this.end) });
    }
    return String.format("%s [%d,%d]", new Object[] { this.kxx, Integer.valueOf(this.start), Integer.valueOf(this.end) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.b.a
 * JD-Core Version:    0.7.0.1
 */