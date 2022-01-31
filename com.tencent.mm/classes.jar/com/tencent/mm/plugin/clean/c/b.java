package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b
  implements Comparable<b>
{
  public long jyU;
  public ArrayList<a> kGB;
  public String username;
  
  public final boolean bgG()
  {
    AppMethodBeat.i(18666);
    this.jyU = 0L;
    Iterator localIterator = this.kGB.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      this.jyU += locala.size;
    }
    if (this.kGB.size() == 0)
    {
      AppMethodBeat.o(18666);
      return false;
    }
    AppMethodBeat.o(18666);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.b
 * JD-Core Version:    0.7.0.1
 */