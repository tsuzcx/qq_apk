package com.tencent.e.d.a;

import com.tencent.e.d.b.d.a;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  private final HashSet<Integer> Bkm;
  private final List<d.a> Bkn;
  
  public d()
  {
    AppMethodBeat.i(114506);
    this.Bkm = new HashSet();
    this.Bkn = new ArrayList();
    AppMethodBeat.o(114506);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(114507);
    if (parama.uid != 0)
    {
      AppMethodBeat.o(114507);
      return;
    }
    if ((parama.Bks == 1) && (!"/sbin/adbd".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer parent : ").append(parama.toString());
      h.dUU();
      this.Bkm.add(Integer.valueOf(parama.pid));
      AppMethodBeat.o(114507);
      return;
    }
    if ((parama.Bks > 1) && ("sh".equals(parama.name)) && ("/system/bin/sh".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer child : ").append(parama.toString());
      h.dUU();
      this.Bkn.add(parama);
    }
    AppMethodBeat.o(114507);
  }
  
  public final boolean dUx()
  {
    AppMethodBeat.i(114508);
    Iterator localIterator = this.Bkn.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if (this.Bkm.contains(Integer.valueOf(locala.Bks)))
      {
        new StringBuilder("ProcessRelationAnalyzer match : ").append(locala.toString());
        h.dUT();
        AppMethodBeat.o(114508);
        return true;
      }
    }
    AppMethodBeat.o(114508);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.e.d.a.d
 * JD-Core Version:    0.7.0.1
 */