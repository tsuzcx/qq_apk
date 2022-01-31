package com.tencent.d.d.a;

import com.tencent.d.d.b.d.a;
import com.tencent.d.f.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d
  implements b
{
  private final HashSet<Integer> wMN = new HashSet();
  private final List<d.a> wMO = new ArrayList();
  
  public final void a(d.a parama)
  {
    if (parama.uid != 0) {}
    do
    {
      return;
      if ((parama.wMT == 1) && (!"/sbin/adbd".equals(parama.name)))
      {
        h.d("ProcessRelationAnalyzer parent : " + parama.toString());
        this.wMN.add(Integer.valueOf(parama.pid));
        return;
      }
    } while ((parama.wMT <= 1) || (!"sh".equals(parama.name)) || (!"/system/bin/sh".equals(parama.name)));
    h.d("ProcessRelationAnalyzer child : " + parama.toString());
    this.wMO.add(parama);
  }
  
  public final boolean cOI()
  {
    Iterator localIterator = this.wMO.iterator();
    while (localIterator.hasNext())
    {
      d.a locala = (d.a)localIterator.next();
      if (this.wMN.contains(Integer.valueOf(locala.wMT)))
      {
        h.i("ProcessRelationAnalyzer match : " + locala.toString());
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.a.d
 * JD-Core Version:    0.7.0.1
 */