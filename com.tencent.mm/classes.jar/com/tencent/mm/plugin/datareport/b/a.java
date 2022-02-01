package com.tencent.mm.plugin.datareport.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.d.a.b;
import com.tencent.mm.plugin.datareport.f.c;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public final class a
{
  public c xgJ;
  private Deque<b> xgK;
  
  public a()
  {
    AppMethodBeat.i(262829);
    this.xgK = new ArrayDeque();
    AppMethodBeat.o(262829);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(262835);
    if (paramb == null)
    {
      AppMethodBeat.o(262835);
      return;
    }
    this.xgK.addLast(paramb);
    AppMethodBeat.o(262835);
  }
  
  public final void eG(Object paramObject)
  {
    AppMethodBeat.i(262840);
    if (paramObject == null)
    {
      AppMethodBeat.o(262840);
      return;
    }
    this.xgJ = new c(paramObject);
    AppMethodBeat.o(262840);
  }
  
  public final Iterator<b> iterator()
  {
    AppMethodBeat.i(262847);
    Iterator localIterator = this.xgK.iterator();
    AppMethodBeat.o(262847);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.b.a
 * JD-Core Version:    0.7.0.1
 */