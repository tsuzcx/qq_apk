package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class c$a
{
  public Queue<c.b> aGt;
  
  public c$a()
  {
    AppMethodBeat.i(140006);
    this.aGt = new LinkedList();
    AppMethodBeat.o(140006);
  }
  
  public final c.b Gu()
  {
    AppMethodBeat.i(140007);
    c.b localb = (c.b)this.aGt.poll();
    if (localb == null)
    {
      localb = new c.b();
      AppMethodBeat.o(140007);
      return localb;
    }
    AppMethodBeat.o(140007);
    return localb;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(140008);
    this.aGt.offer(paramb);
    AppMethodBeat.o(140008);
  }
  
  public final void c(ArrayList<c.b> paramArrayList)
  {
    AppMethodBeat.i(140009);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(140009);
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      c.b localb = (c.b)localIterator.next();
      this.aGt.offer(localb);
    }
    paramArrayList.clear();
    AppMethodBeat.o(140009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.c.a
 * JD-Core Version:    0.7.0.1
 */