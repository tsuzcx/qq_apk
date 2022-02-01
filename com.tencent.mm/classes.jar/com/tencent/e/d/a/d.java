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
  private final HashSet<Integer> ahtE;
  private final List<e.a> ahtF;
  
  public d()
  {
    AppMethodBeat.i(138347);
    this.ahtE = new HashSet();
    this.ahtF = new ArrayList();
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
    if ((parama.ahtK == 1) && (!"/sbin/adbd".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer parent : ").append(parama.toString());
      h.jhd();
      this.ahtE.add(Integer.valueOf(parama.pid));
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.ahtK > 1) && ("sh".equals(parama.name)) && ("/system/bin/sh".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer child : ").append(parama.toString());
      h.jhd();
      this.ahtF.add(parama);
    }
    AppMethodBeat.o(138348);
  }
  
  public final boolean jXf()
  {
    AppMethodBeat.i(138349);
    Iterator localIterator = this.ahtF.iterator();
    while (localIterator.hasNext())
    {
      e.a locala = (e.a)localIterator.next();
      if (this.ahtE.contains(Integer.valueOf(locala.ahtK)))
      {
        new StringBuilder("ProcessRelationAnalyzer match : ").append(locala.toString());
        h.jXC();
        AppMethodBeat.o(138349);
        return true;
      }
    }
    AppMethodBeat.o(138349);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.d.a.d
 * JD-Core Version:    0.7.0.1
 */