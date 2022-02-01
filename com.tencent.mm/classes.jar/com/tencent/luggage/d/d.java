package com.tencent.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  final LinkedList<Class<? extends a>> bZX;
  
  public d()
  {
    AppMethodBeat.i(140371);
    this.bZX = new LinkedList();
    AppMethodBeat.o(140371);
  }
  
  public final void J(List<Class<? extends a>> paramList)
  {
    AppMethodBeat.i(140372);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Class localClass = (Class)paramList.next();
      this.bZX.add(localClass);
    }
    AppMethodBeat.o(140372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.d
 * JD-Core Version:    0.7.0.1
 */