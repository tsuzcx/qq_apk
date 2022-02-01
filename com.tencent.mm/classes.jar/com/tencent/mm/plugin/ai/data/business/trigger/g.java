package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class g
{
  private static g qnw;
  public HashSet<c> qnx;
  
  private g()
  {
    AppMethodBeat.i(267604);
    this.qnx = new HashSet();
    this.qnx.add(new b());
    this.qnx.add(new a());
    this.qnx.add(new e());
    this.qnx.add(new d());
    this.qnx.add(new f());
    this.qnx.add(new com.tencent.mm.plugin.ai.data.business.trigger.edge.b());
    this.qnx.add(new com.tencent.mm.plugin.ai.data.business.trigger.edge.e());
    this.qnx.add(new com.tencent.mm.plugin.ai.data.business.trigger.sns.a());
    this.qnx.add(new com.tencent.mm.plugin.ai.data.business.trigger.chatting.a());
    AppMethodBeat.o(267604);
  }
  
  public static g cat()
  {
    AppMethodBeat.i(267594);
    if (qnw == null) {
      qnw = new g();
    }
    g localg = qnw;
    AppMethodBeat.o(267594);
    return localg;
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267612);
    Iterator localIterator = this.qnx.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).aoW();
    }
    AppMethodBeat.o(267612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.g
 * JD-Core Version:    0.7.0.1
 */