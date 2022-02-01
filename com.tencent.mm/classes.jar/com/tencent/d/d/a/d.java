package com.tencent.d.d.a;

import com.tencent.d.d.b.e.a;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  private final HashSet<Integer> ZoW;
  private final List<e.a> ZoX;
  
  public d()
  {
    AppMethodBeat.i(138347);
    this.ZoW = new HashSet();
    this.ZoX = new ArrayList();
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
    if ((parama.Zpc == 1) && (!"/sbin/adbd".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer parent : ").append(parama.toString());
      h.hEQ();
      this.ZoW.add(Integer.valueOf(parama.pid));
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.Zpc > 1) && ("sh".equals(parama.name)) && ("/system/bin/sh".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer child : ").append(parama.toString());
      h.hEQ();
      this.ZoX.add(parama);
    }
    AppMethodBeat.o(138348);
  }
  
  public final boolean inU()
  {
    AppMethodBeat.i(138349);
    Iterator localIterator = this.ZoX.iterator();
    while (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      if (this.ZoW.contains(Integer.valueOf(locala.Zpc)))
      {
        new StringBuilder("ProcessRelationAnalyzer match : ").append(locala.toString());
        h.iop();
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