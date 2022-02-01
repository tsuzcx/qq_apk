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
  private final HashSet<Integer> MjP;
  private final List<d.a> MjQ;
  
  public d()
  {
    AppMethodBeat.i(138347);
    this.MjP = new HashSet();
    this.MjQ = new ArrayList();
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
    if ((parama.MjV == 1) && (!"/sbin/adbd".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer parent : ").append(parama.toString());
      h.fyp();
      this.MjP.add(Integer.valueOf(parama.pid));
      AppMethodBeat.o(138348);
      return;
    }
    if ((parama.MjV > 1) && ("sh".equals(parama.name)) && ("/system/bin/sh".equals(parama.name)))
    {
      new StringBuilder("ProcessRelationAnalyzer child : ").append(parama.toString());
      h.fyp();
      this.MjQ.add(parama);
    }
    AppMethodBeat.o(138348);
  }
  
  public final boolean fYk()
  {
    AppMethodBeat.i(138349);
    Iterator localIterator = this.MjQ.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if (this.MjP.contains(Integer.valueOf(locala.MjV)))
      {
        new StringBuilder("ProcessRelationAnalyzer match : ").append(locala.toString());
        h.fYF();
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