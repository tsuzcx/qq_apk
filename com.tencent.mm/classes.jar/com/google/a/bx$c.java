package com.google.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class bx$c
{
  static final c bZC = new c(true);
  static final c bZD = new c(false);
  private final boolean bZE;
  
  private bx$c(boolean paramBoolean)
  {
    this.bZE = paramBoolean;
  }
  
  private static void a(int paramInt1, int paramInt2, List<?> paramList, bx.d paramd)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      paramd.u(String.valueOf(paramInt1));
      paramd.u(": ");
      bx.a(paramInt2, localObject, paramd);
      paramd.HI();
    }
  }
  
  private void a(az paramaz, bx.d paramd)
  {
    Iterator localIterator = paramaz.FS().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      l.f localf = (l.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localf.FJ())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          a(localf, ((Iterator)localObject).next(), paramd);
        }
      }
      else
      {
        a(localf, localObject, paramd);
      }
    }
    a(paramaz.Ax(), paramd);
  }
  
  private void a(cc paramcc, bx.d paramd)
  {
    paramcc = paramcc.bZN.entrySet().iterator();
    while (paramcc.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramcc.next();
      int i = ((Integer)localEntry.getKey()).intValue();
      Object localObject = (cc.b)localEntry.getValue();
      a(i, 0, ((cc.b)localObject).bZT, paramd);
      a(i, 5, ((cc.b)localObject).bZU, paramd);
      a(i, 1, ((cc.b)localObject).bZV, paramd);
      a(i, 2, ((cc.b)localObject).bZW, paramd);
      localObject = ((cc.b)localObject).bZX.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cc localcc = (cc)((Iterator)localObject).next();
        paramd.u(((Integer)localEntry.getKey()).toString());
        paramd.u(" {");
        paramd.HI();
        paramd.HG();
        a(localcc, paramd);
        paramd.HH();
        paramd.u("}");
        paramd.HI();
      }
    }
  }
  
  private void a(l.f paramf, Object paramObject, bx.d paramd)
  {
    if (paramf.bSP.Cp())
    {
      paramd.u("[");
      if ((paramf.bSs.bSq.AG().bRt) && (paramf.bSS == l.f.b.bTr) && (paramf.FI()) && (paramf.FM() == paramf.FN()))
      {
        paramd.u(paramf.FN().fullName);
        paramd.u("]");
        label77:
        if (paramf.bSS.bTz != l.f.a.bTe) {
          break label191;
        }
        paramd.u(" {");
        paramd.HI();
        paramd.HG();
      }
    }
    for (;;)
    {
      b(paramf, paramObject, paramd);
      if (paramf.bSS.bTz == l.f.a.bTe)
      {
        paramd.HH();
        paramd.u("}");
      }
      paramd.HI();
      return;
      paramd.u(paramf.fullName);
      break;
      if (paramf.bSS == l.f.b.bTq)
      {
        paramd.u(paramf.FN().bSq.getName());
        break label77;
      }
      paramd.u(paramf.bSP.getName());
      break label77;
      label191:
      paramd.u(": ");
    }
  }
  
  private void b(l.f paramf, Object paramObject, bx.d paramd)
  {
    switch (bx.1.bNG[paramf.bSS.ordinal()])
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      paramd.u(((Integer)paramObject).toString());
      return;
    case 4: 
    case 5: 
    case 6: 
      paramd.u(((Long)paramObject).toString());
      return;
    case 7: 
      paramd.u(((Boolean)paramObject).toString());
      return;
    case 8: 
      paramd.u(((Float)paramObject).toString());
      return;
    case 9: 
      paramd.u(((Double)paramObject).toString());
      return;
    case 10: 
    case 11: 
      paramd.u(bx.gP(((Integer)paramObject).intValue()));
      return;
    case 12: 
    case 13: 
      paramd.u(bx.aG(((Long)paramObject).longValue()));
      return;
    case 14: 
      paramd.u("\"");
      if (this.bZE) {}
      for (paramf = by.e(g.bZ((String)paramObject));; paramf = bx.cl((String)paramObject).replace("\n", "\\n"))
      {
        paramd.u(paramf);
        paramd.u("\"");
        return;
      }
    case 15: 
      paramd.u("\"");
      if ((paramObject instanceof g)) {
        paramd.u(bx.e((g)paramObject));
      }
      for (;;)
      {
        paramd.u("\"");
        return;
        paramd.u(bx.H((byte[])paramObject));
      }
    case 16: 
      paramd.u(((l.e)paramObject).bSM.getName());
      return;
    }
    a((at)paramObject, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.bx.c
 * JD-Core Version:    0.7.0.1
 */