package com.tencent.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  final LinkedList<Class<? extends b>> ctd;
  
  public e()
  {
    AppMethodBeat.i(140371);
    this.ctd = new LinkedList();
    AppMethodBeat.o(140371);
  }
  
  public final void E(List<Class<? extends b>> paramList)
  {
    AppMethodBeat.i(140372);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Class localClass = (Class)paramList.next();
      this.ctd.add(localClass);
    }
    AppMethodBeat.o(140372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.e
 * JD-Core Version:    0.7.0.1
 */