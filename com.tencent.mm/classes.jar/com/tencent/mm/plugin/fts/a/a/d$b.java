package com.tencent.mm.plugin.fts.a.a;

public final class d$b
  implements Comparable<b>
{
  public g.c kww;
  public int kwx = -1;
  public int kwy = -1;
  
  public final boolean isAvailable()
  {
    return (this.kwx != -1) && (this.kwy != -1);
  }
  
  public final String toString()
  {
    if (this.kww == null) {}
    for (String str = "";; str = this.kww.aVz().replaceAll("​", ",")) {
      return String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.kwx), Integer.valueOf(this.kwy) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d.b
 * JD-Core Version:    0.7.0.1
 */