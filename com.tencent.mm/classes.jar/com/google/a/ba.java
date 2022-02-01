package com.google.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ba
{
  static int a(at paramat, Map<l.f, Object> paramMap)
  {
    boolean bool = paramat.AS().bSq.AG().bRt;
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      l.f localf = (l.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localf.bSP.Cp()) && (localf.bSS == l.f.b.bTr) && (!localf.FJ())) {
        i = i.d(localf.bSP.bPE, (at)localObject) + i;
      } else {
        i = x.c(localf, localObject) + i;
      }
    }
    paramat = paramat.Ax();
    if (bool) {
      return paramat.HL() + i;
    }
    return paramat.yC() + i;
  }
  
  private static String a(String paramString, l.f paramf, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    if (paramf.bSP.Cp()) {
      paramString.append('(').append(paramf.fullName).append(')');
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramString.append('[').append(paramInt).append(']');
      }
      paramString.append('.');
      return paramString.toString();
      paramString.append(paramf.bSP.getName());
    }
  }
  
  static void a(at paramat, Map<l.f, Object> paramMap, i parami)
  {
    boolean bool = paramat.AS().bSq.AG().bRt;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      l.f localf = (l.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localf.bSP.Cp()) && (localf.bSS == l.f.b.bTr) && (!localf.FJ())) {
        parami.b(localf.bSP.bPE, (at)localObject);
      } else {
        x.a(localf, localObject, parami);
      }
    }
    paramat = paramat.Ax();
    if (bool)
    {
      paramat.c(parami);
      return;
    }
    paramat.a(parami);
  }
  
  static void a(az paramaz, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramaz.AS().getFields().iterator();
    l.f localf;
    while (localIterator.hasNext())
    {
      localf = (l.f)localIterator.next();
      if ((localf.FH()) && (!paramaz.e(localf))) {
        paramList.add(paramString + localf.bSP.getName());
      }
    }
    localIterator = paramaz.FS().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localf = (l.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localf.bSS.bTz == l.f.a.bTe) {
        if (localf.FJ())
        {
          int i = 0;
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a((az)((Iterator)localObject).next(), a(paramString, localf, i), paramList);
            i += 1;
          }
        }
        else if (paramaz.e(localf))
        {
          a((az)localObject, a(paramString, localf, -1), paramList);
        }
      }
    }
  }
  
  private static void a(g paramg, p.b paramb, r paramr, c paramc)
  {
    l.f localf = paramb.bUd;
    if ((paramc.e(localf)) || (r.Gc()))
    {
      paramc.ac(localf, paramc.a(paramg, paramr, localf, paramb.bUe));
      return;
    }
    paramc.ac(localf, new ah(paramb.bUe, paramr, paramg));
  }
  
  private static void a(h paramh, cc.a parama, r paramr, l.a parama1, c paramc)
  {
    int i = 0;
    p.b localb = null;
    g localg = null;
    int j;
    do
    {
      for (;;)
      {
        j = paramh.yT();
        if (j == 0) {
          break label134;
        }
        if (j == cj.caA)
        {
          j = paramh.zc();
          i = j;
          if (j != 0)
          {
            i = j;
            if ((paramr instanceof p))
            {
              localb = paramc.a((p)paramr, parama1, j);
              i = j;
            }
          }
        }
        else
        {
          if (j != cj.caB) {
            break;
          }
          if ((i != 0) && (localb != null) && (r.Gc()))
          {
            a(paramh, localb, paramr, paramc);
            localg = null;
          }
          else
          {
            localg = paramh.zb();
          }
        }
      }
    } while (paramh.fG(j));
    label134:
    paramh.fF(cj.caz);
    if ((localg != null) && (i != 0))
    {
      if (localb == null) {
        break label167;
      }
      a(localg, localb, paramr, paramc);
    }
    label167:
    while ((localg == null) || (parama == null)) {
      return;
    }
    parama.a(i, cc.b.HO().h(localg).HQ());
  }
  
  private static void a(h paramh, p.b paramb, r paramr, c paramc)
  {
    l.f localf = paramb.bUd;
    paramc.ac(localf, paramc.b(paramh, paramr, localf, paramb.bUe));
  }
  
  static boolean a(h paramh, cc.a parama, r paramr, l.a parama1, c paramc, int paramInt)
  {
    if ((parama1.bSq.AG().bRt) && (paramInt == cj.cay))
    {
      a(paramh, parama, paramr, parama1, paramc);
      return true;
    }
    int i = cj.gX(paramInt);
    int k = cj.gY(paramInt);
    Object localObject;
    int j;
    if (parama1.gy(k)) {
      if ((paramr instanceof p))
      {
        localObject = paramc.a((p)paramr, parama1, k);
        if (localObject == null) {
          break label216;
        }
        parama1 = ((p.b)localObject).bUd;
        localObject = ((p.b)localObject).bUe;
        if ((localObject == null) && (parama1.bSS.bTz == l.f.a.bTe)) {
          throw new IllegalStateException("Message-typed extension lacked default instance: " + parama1.fullName);
        }
        if (parama1 == null) {
          break label253;
        }
        if (i != x.a(parama1.FE(), false)) {
          break label224;
        }
        i = 0;
        j = 0;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        if (parama != null)
        {
          return parama.a(paramInt, paramh);
          localObject = null;
          parama1 = null;
          break;
          if (paramc.Hh() == ba.c.a.bYk)
          {
            parama1 = parama1.gz(k);
            localObject = null;
            break;
          }
          label216:
          localObject = null;
          parama1 = null;
          break;
          label224:
          if ((parama1.FL()) && (i == x.a(parama1.FE(), true)))
          {
            i = 1;
            j = 0;
            continue;
          }
          label253:
          i = 0;
          j = 1;
          continue;
        }
        return paramh.fG(paramInt);
      }
    }
    if (i != 0)
    {
      paramInt = paramh.fH(paramh.zi());
      if (parama1.FE() == cj.a.caP) {
        while (paramh.zk() > 0)
        {
          i = paramh.zd();
          if (parama1.bSr.FR())
          {
            paramc.ad(parama1, parama1.FO().gB(i));
          }
          else
          {
            paramr = parama1.FO().gA(i);
            if (paramr == null)
            {
              if (parama != null) {
                parama.bx(k, i);
              }
            }
            else {
              paramc.ad(parama1, paramr);
            }
          }
        }
      }
      while (paramh.zk() > 0) {
        paramc.ad(parama1, cj.a(paramh, parama1.FE(), paramc.j(parama1)));
      }
      paramh.fI(paramInt);
    }
    for (;;)
    {
      return true;
      switch (1.bNG[parama1.bSS.ordinal()])
      {
      default: 
        paramh = cj.a(paramh, parama1.FE(), paramc.j(parama1));
      }
      for (;;)
      {
        if (parama1.FJ())
        {
          paramc.ad(parama1, paramh);
          break;
          paramh = paramc.a(paramh, paramr, parama1, (at)localObject);
          continue;
          paramh = paramc.b(paramh, paramr, parama1, (at)localObject);
          continue;
          paramInt = paramh.zd();
          if (parama1.bSr.FR())
          {
            paramh = parama1.FO().gB(paramInt);
          }
          else
          {
            paramr = parama1.FO().gA(paramInt);
            paramh = paramr;
            if (paramr == null)
            {
              if (parama != null) {
                parama.bx(k, paramInt);
              }
              return true;
            }
          }
        }
      }
      paramc.ac(parama1, paramh);
    }
  }
  
  static final class a
    implements ba.c
  {
    private final at.a bYj;
    
    public a(at.a parama)
    {
      this.bYj = parama;
    }
    
    private Object f(l.f paramf)
    {
      return this.bYj.f(paramf);
    }
    
    public final ba.c.a Hh()
    {
      return ba.c.a.bYk;
    }
    
    public final p.b a(p paramp, l.a parama, int paramInt)
    {
      return paramp.a(parama, paramInt);
    }
    
    public final Object a(g paramg, r paramr, l.f paramf, at paramat)
    {
      if (paramat != null) {}
      for (paramat = paramat.AM();; paramat = this.bYj.h(paramf))
      {
        if (!paramf.FJ())
        {
          paramf = (at)f(paramf);
          if (paramf != null) {
            paramat.c(paramf);
          }
        }
        paramat.c(paramg, paramr);
        return paramat.Bm();
      }
    }
    
    public final Object a(h paramh, r paramr, l.f paramf, at paramat)
    {
      if (paramat != null) {}
      for (paramat = paramat.AM();; paramat = this.bYj.h(paramf))
      {
        if (!paramf.FJ())
        {
          at localat = (at)f(paramf);
          if (localat != null) {
            paramat.c(localat);
          }
        }
        paramh.a(paramf.bSP.bPE, paramat, paramr);
        return paramat.Bm();
      }
    }
    
    public final ba.c ac(l.f paramf, Object paramObject)
    {
      this.bYj.f(paramf, paramObject);
      return this;
    }
    
    public final ba.c ad(l.f paramf, Object paramObject)
    {
      this.bYj.e(paramf, paramObject);
      return this;
    }
    
    public final Object b(h paramh, r paramr, l.f paramf, at paramat)
    {
      if (paramat != null) {}
      for (paramat = paramat.AM();; paramat = this.bYj.h(paramf))
      {
        if (!paramf.FJ())
        {
          paramf = (at)f(paramf);
          if (paramf != null) {
            paramat.c(paramf);
          }
        }
        paramh.a(paramat, paramr);
        return paramat.Bm();
      }
    }
    
    public final boolean e(l.f paramf)
    {
      return this.bYj.e(paramf);
    }
    
    public final cj.c j(l.f paramf)
    {
      if (paramf.FF()) {
        return cj.c.cbi;
      }
      if ((!paramf.FJ()) && ((this.bYj instanceof z.a))) {
        return cj.c.cbj;
      }
      return cj.c.cbh;
    }
  }
  
  static final class b
    implements ba.c
  {
    private final x<l.f> bWd;
    
    b(x<l.f> paramx)
    {
      this.bWd = paramx;
    }
    
    private Object f(l.f paramf)
    {
      return this.bWd.b(paramf);
    }
    
    public final ba.c.a Hh()
    {
      return ba.c.a.bYl;
    }
    
    public final p.b a(p paramp, l.a parama, int paramInt)
    {
      return paramp.a(parama, paramInt);
    }
    
    public final Object a(g paramg, r paramr, l.f paramf, at paramat)
    {
      paramat = paramat.AM();
      if (!paramf.FJ())
      {
        paramf = (at)f(paramf);
        if (paramf != null) {
          paramat.c(paramf);
        }
      }
      paramat.c(paramg, paramr);
      return paramat.Bm();
    }
    
    public final Object a(h paramh, r paramr, l.f paramf, at paramat)
    {
      paramat = paramat.AM();
      if (!paramf.FJ())
      {
        at localat = (at)f(paramf);
        if (localat != null) {
          paramat.c(localat);
        }
      }
      paramh.a(paramf.bSP.bPE, paramat, paramr);
      return paramat.Bm();
    }
    
    public final ba.c ac(l.f paramf, Object paramObject)
    {
      this.bWd.a(paramf, paramObject);
      return this;
    }
    
    public final ba.c ad(l.f paramf, Object paramObject)
    {
      this.bWd.b(paramf, paramObject);
      return this;
    }
    
    public final Object b(h paramh, r paramr, l.f paramf, at paramat)
    {
      paramat = paramat.AM();
      if (!paramf.FJ())
      {
        paramf = (at)f(paramf);
        if (paramf != null) {
          paramat.c(paramf);
        }
      }
      paramh.a(paramat, paramr);
      return paramat.Bm();
    }
    
    public final boolean e(l.f paramf)
    {
      return this.bWd.a(paramf);
    }
    
    public final cj.c j(l.f paramf)
    {
      if (paramf.FF()) {
        return cj.c.cbi;
      }
      return cj.c.cbh;
    }
  }
  
  static abstract interface c
  {
    public abstract ba.c.a Hh();
    
    public abstract p.b a(p paramp, l.a parama, int paramInt);
    
    public abstract Object a(g paramg, r paramr, l.f paramf, at paramat);
    
    public abstract Object a(h paramh, r paramr, l.f paramf, at paramat);
    
    public abstract c ac(l.f paramf, Object paramObject);
    
    public abstract c ad(l.f paramf, Object paramObject);
    
    public abstract Object b(h paramh, r paramr, l.f paramf, at paramat);
    
    public abstract boolean e(l.f paramf);
    
    public abstract cj.c j(l.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.ba
 * JD-Core Version:    0.7.0.1
 */