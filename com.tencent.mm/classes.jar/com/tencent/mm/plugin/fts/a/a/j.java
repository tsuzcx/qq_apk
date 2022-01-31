package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public final class j
{
  public int aYY;
  public i ktu;
  public g kwi;
  public a kxg;
  public List<l> kxh = new ArrayList();
  
  public j(i parami)
  {
    this.ktu = parami;
  }
  
  public final String toString()
  {
    int i = 0;
    int j = this.aYY;
    if (this.kxh == null) {}
    for (;;)
    {
      return String.format("{resultCode: %d, resultSize: %d}", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      i = this.kxh.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.j
 * JD-Core Version:    0.7.0.1
 */