package com.tencent.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  final LinkedList<Class<? extends a>> byH;
  
  public d()
  {
    AppMethodBeat.i(90770);
    this.byH = new LinkedList();
    AppMethodBeat.o(90770);
  }
  
  public final void z(List<Class<? extends a>> paramList)
  {
    AppMethodBeat.i(90771);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Class localClass = (Class)paramList.next();
      this.byH.add(localClass);
    }
    AppMethodBeat.o(90771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.d.d
 * JD-Core Version:    0.7.0.1
 */