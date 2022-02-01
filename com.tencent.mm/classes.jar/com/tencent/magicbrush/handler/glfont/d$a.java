package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class d$a
{
  public Queue<d.b> eJb;
  
  public d$a()
  {
    AppMethodBeat.i(140006);
    this.eJb = new LinkedList();
    AppMethodBeat.o(140006);
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(140008);
    this.eJb.offer(paramb);
    AppMethodBeat.o(140008);
  }
  
  public final d.b avL()
  {
    AppMethodBeat.i(140007);
    d.b localb = (d.b)this.eJb.poll();
    if (localb == null)
    {
      localb = new d.b();
      AppMethodBeat.o(140007);
      return localb;
    }
    AppMethodBeat.o(140007);
    return localb;
  }
  
  public final void i(ArrayList<d.b> paramArrayList)
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
      d.b localb = (d.b)localIterator.next();
      this.eJb.offer(localb);
    }
    paramArrayList.clear();
    AppMethodBeat.o(140009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.d.a
 * JD-Core Version:    0.7.0.1
 */