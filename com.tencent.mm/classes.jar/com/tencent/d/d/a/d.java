package com.tencent.d.d.a;

import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  private final HashSet<Integer> LMQ;
  private final List<d.a> LMR;
  
  public d()
  {
    AppMethodBeat.i(138347);
    this.LMQ = new HashSet();
    this.LMR = new ArrayList();
    AppMethodBeat.o(138347);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(138348);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.LMW == 1) && (!"/sbin/adbd".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer parent : ").append(parama.toString());
      h.fuo();
      this.LMQ.add(Integer.valueOf(parama.pid));
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.LMW > 1) && ("sh".equals(parama.name)) && ("/system/bin/sh".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer child : ").append(parama.toString());
      h.fuo();
      this.LMR.add(parama);
    }
    AppMethodBeat.o(138348);
  }
  
  public final boolean fTK()
  {
    AppMethodBeat.i(138349);
    Iterator localIterator = this.LMR.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if (this.LMQ.contains(Integer.valueOf(locala.LMW)))
      {
        new StringBuilder("ProcessRelationAnalyzer match : ").append(locala.toString());
        h.fUg();
        AppMethodBeat.o(138349);
        return true;
      }
    }
    AppMethodBeat.o(138349);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.a.d
 * JD-Core Version:    0.7.0.1
 */