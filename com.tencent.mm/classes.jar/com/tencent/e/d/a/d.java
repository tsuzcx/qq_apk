package com.tencent.e.d.a;

import com.tencent.e.d.b.e.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  private final HashSet<Integer> RMq;
  private final List<e.a> RMr;
  
  public d()
  {
    AppMethodBeat.i(138347);
    this.RMq = new HashSet();
    this.RMr = new ArrayList();
    AppMethodBeat.o(138347);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(138348);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.RMw == 1) && (!"/sbin/adbd".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer parent : ").append(parama.toString());
      h.gGd();
      this.RMq.add(Integer.valueOf(parama.pid));
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.RMw > 1) && ("sh".equals(parama.name)) && ("/system/bin/sh".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer child : ").append(parama.toString());
      h.gGd();
      this.RMr.add(parama);
    }
    AppMethodBeat.o(138348);
  }
  
  public final boolean hkw()
  {
    AppMethodBeat.i(138349);
    Iterator localIterator = this.RMr.iterator();
    while (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      if (this.RMq.contains(Integer.valueOf(locala.RMw)))
      {
        new StringBuilder("ProcessRelationAnalyzer match : ").append(locala.toString());
        h.hkR();
        AppMethodBeat.o(138349);
        return true;
      }
    }
    AppMethodBeat.o(138349);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.d.a.d
 * JD-Core Version:    0.7.0.1
 */