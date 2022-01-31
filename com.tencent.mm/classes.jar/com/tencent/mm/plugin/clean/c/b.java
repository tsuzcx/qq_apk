package com.tencent.mm.plugin.clean.c;

import java.util.ArrayList;
import java.util.Iterator;

public final class b
  implements Comparable<b>
{
  public long hFz;
  public ArrayList<a> iBu;
  public String username;
  
  public final boolean aDG()
  {
    this.hFz = 0L;
    Iterator localIterator = this.iBu.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.hFz += locala.size;
    }
    return this.iBu.size() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.b
 * JD-Core Version:    0.7.0.1
 */