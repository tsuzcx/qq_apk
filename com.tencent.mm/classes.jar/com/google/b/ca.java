package com.google.b;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ca
{
  static int a(bt parambt, Map<aj.f, Object> paramMap)
  {
    boolean bool = parambt.Cv().bUp.Ck().bTs;
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      aj.f localf = (aj.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localf.bUO.DU()) && (localf.bUR == aj.f.b.bVr) && (!localf.Hp())) {
        i = i.d(localf.bUO.bRD, (bt)localObject) + i;
      } else {
        i = av.c(localf, localObject) + i;
      }
    }
    parambt = parambt.Ca();
    if (bool) {
      return parambt.Jl() + i;
    }
    return parambt.Ad() + i;
  }
  
  private static String a(String paramString, aj.f paramf, int paramInt)
  {
    paramString = new StringBuilder(paramString);
    if (paramf.bUO.DU()) {
      paramString.append('(').append(paramf.fullName).append(')');
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramString.append('[').append(paramInt).append(']');
      }
      paramString.append('.');
      return paramString.toString();
      paramString.append(paramf.bUO.getName());
    }
  }
  
  static void a(bt parambt, Map<aj.f, Object> paramMap, i parami)
  {
    boolean bool = parambt.Cv().bUp.Ck().bTs;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      aj.f localf = (aj.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((bool) && (localf.bUO.DU()) && (localf.bUR == aj.f.b.bVr) && (!localf.Hp())) {
        parami.b(localf.bUO.bRD, (bt)localObject);
      } else {
        av.a(localf, localObject, parami);
      }
    }
    parambt = parambt.Ca();
    if (bool)
    {
      parambt.c(parami);
      return;
    }
    parambt.a(parami);
  }
  
  static void a(bz parambz, String paramString, List<String> paramList)
  {
    Iterator localIterator = parambz.Cv().getFields().iterator();
    aj.f localf;
    while (localIterator.hasNext())
    {
      localf = (aj.f)localIterator.next();
      if ((localf.Hn()) && (!parambz.e(localf))) {
        paramList.add(paramString + localf.bUO.getName());
      }
    }
    localIterator = parambz.Hz().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localf = (aj.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if (localf.bUR.bVz == aj.f.a.bVe) {
        if (localf.Hp())
        {
          int i = 0;
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a((bz)((Iterator)localObject).next(), a(paramString, localf, i), paramList);
            i += 1;
          }
        }
        else if (parambz.e(localf))
        {
          a((bz)localObject, a(paramString, localf, -1), paramList);
        }
      }
    }
  }
  
  private static void a(h paramh, da.a parama, ap paramap, aj.a parama1, c paramc)
  {
    int i = 0;
    an.b localb = null;
    g localg = null;
    int j;
    do
    {
      for (;;)
      {
        j = paramh.Av();
        if (j == 0) {
          break label125;
        }
        if (j == dh.ccd)
        {
          j = paramh.AE();
          i = j;
          if (j != 0)
          {
            i = j;
            if ((paramap instanceof an))
            {
              localb = paramc.a((an)paramap, parama1, j);
              i = j;
            }
          }
        }
        else
        {
          if (j != dh.cce) {
            break;
          }
          if ((i != 0) && (localb != null) && (ap.HI())) {
            localg = null;
          } else {
            localg = paramh.AD();
          }
        }
      }
    } while (paramh.gz(j));
    label125:
    paramh.gy(dh.ccc);
    if ((localg == null) || (i == 0) || (localb != null)) {}
    while ((localg == null) || (parama == null)) {
      return;
    }
    parama.a(i, da.b.Jo().h(localg).Jq());
  }
  
  static boolean a(h paramh, da.a parama, ap paramap, aj.a parama1, c paramc, int paramInt)
  {
    if ((parama1.bUp.Ck().bTs) && (paramInt == dh.ccb))
    {
      a(paramh, parama, paramap, parama1, paramc);
      return true;
    }
    int i = dh.hO(paramInt);
    int k = dh.hP(paramInt);
    int j;
    if (parama1.hq(k))
    {
      if ((paramap instanceof an))
      {
        if (paramc.a((an)paramap, parama1, k) == null) {
          break label146;
        }
        throw null;
      }
      parama1 = null;
      if (parama1 == null) {
        break label180;
      }
      if (i != av.a(parama1.Hk(), false)) {
        break label151;
      }
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (j != 0)
      {
        if (parama != null)
        {
          return parama.a(paramInt, paramh);
          if (paramc.II() == ca.c.a.bZO)
          {
            parama1 = parama1.hr(k);
            break;
          }
          label146:
          parama1 = null;
          break;
          label151:
          if ((parama1.Hr()) && (i == av.a(parama1.Hk(), true)))
          {
            i = 1;
            j = 0;
            continue;
          }
          label180:
          i = 0;
          j = 1;
          continue;
        }
        return paramh.gz(paramInt);
      }
    }
    if (i != 0)
    {
      paramInt = paramh.gA(paramh.AK());
      if (parama1.Hk() == dh.a.ccs) {
        while (paramh.AM() > 0)
        {
          i = paramh.AF();
          if (parama1.bUq.Hy())
          {
            paramc.ad(parama1, parama1.Hv().ht(i));
          }
          else
          {
            paramap = parama1.Hv().hs(i);
            if (paramap == null)
            {
              if (parama != null) {
                parama.bQ(k, i);
              }
            }
            else {
              paramc.ad(parama1, paramap);
            }
          }
        }
      }
      while (paramh.AM() > 0) {
        paramc.ad(parama1, dh.a(paramh, parama1.Hk(), paramc.j(parama1)));
      }
      paramh.gB(paramInt);
    }
    for (;;)
    {
      return true;
      switch (1.bPF[parama1.bUR.ordinal()])
      {
      default: 
        paramh = dh.a(paramh, parama1.Hk(), paramc.j(parama1));
      }
      for (;;)
      {
        if (parama1.Hp())
        {
          paramc.ad(parama1, paramh);
          break;
          paramh = paramc.a(paramh, paramap, parama1);
          continue;
          paramh = paramc.b(paramh, paramap, parama1);
          continue;
          paramInt = paramh.AF();
          if (parama1.bUq.Hy())
          {
            paramh = parama1.Hv().ht(paramInt);
          }
          else
          {
            paramap = parama1.Hv().hs(paramInt);
            paramh = paramap;
            if (paramap == null)
            {
              if (parama != null) {
                parama.bQ(k, paramInt);
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
    implements ca.c
  {
    private final bt.a bZN;
    
    public a(bt.a parama)
    {
      this.bZN = parama;
    }
    
    private Object f(aj.f paramf)
    {
      return this.bZN.f(paramf);
    }
    
    public final ca.c.a II()
    {
      return ca.c.a.bZO;
    }
    
    public final an.b a(an paraman, aj.a parama, int paramInt)
    {
      return paraman.a(parama, paramInt);
    }
    
    public final Object a(h paramh, ap paramap, aj.f paramf)
    {
      bt.a locala = this.bZN.h(paramf);
      if (!paramf.Hp())
      {
        bt localbt = (bt)f(paramf);
        if (localbt != null) {
          locala.c(localbt);
        }
      }
      paramh.a(paramf.bUO.bRD, locala, paramap);
      return locala.CP();
    }
    
    public final ca.c ac(aj.f paramf, Object paramObject)
    {
      this.bZN.f(paramf, paramObject);
      return this;
    }
    
    public final ca.c ad(aj.f paramf, Object paramObject)
    {
      this.bZN.e(paramf, paramObject);
      return this;
    }
    
    public final Object b(h paramh, ap paramap, aj.f paramf)
    {
      bt.a locala = this.bZN.h(paramf);
      if (!paramf.Hp())
      {
        paramf = (bt)f(paramf);
        if (paramf != null) {
          locala.c(paramf);
        }
      }
      paramh.a(locala, paramap);
      return locala.CP();
    }
    
    public final dh.c j(aj.f paramf)
    {
      if (paramf.Hl()) {
        return dh.c.ccL;
      }
      if ((!paramf.Hp()) && ((this.bZN instanceof ax.a))) {
        return dh.c.ccM;
      }
      return dh.c.ccK;
    }
  }
  
  static final class b
    implements ca.c
  {
    private final av<aj.f> bXY;
    
    b(av<aj.f> paramav)
    {
      this.bXY = paramav;
    }
    
    private Object f(aj.f paramf)
    {
      return this.bXY.b(paramf);
    }
    
    public final ca.c.a II()
    {
      return ca.c.a.bZP;
    }
    
    public final an.b a(an paraman, aj.a parama, int paramInt)
    {
      return paraman.a(parama, paramInt);
    }
    
    public final Object a(h paramh, ap paramap, aj.f paramf)
    {
      throw new NullPointerException();
    }
    
    public final ca.c ac(aj.f paramf, Object paramObject)
    {
      this.bXY.a(paramf, paramObject);
      return this;
    }
    
    public final ca.c ad(aj.f paramf, Object paramObject)
    {
      this.bXY.b(paramf, paramObject);
      return this;
    }
    
    public final Object b(h paramh, ap paramap, aj.f paramf)
    {
      throw new NullPointerException();
    }
    
    public final dh.c j(aj.f paramf)
    {
      if (paramf.Hl()) {
        return dh.c.ccL;
      }
      return dh.c.ccK;
    }
  }
  
  static abstract interface c
  {
    public abstract ca.c.a II();
    
    public abstract an.b a(an paraman, aj.a parama, int paramInt);
    
    public abstract Object a(h paramh, ap paramap, aj.f paramf);
    
    public abstract c ac(aj.f paramf, Object paramObject);
    
    public abstract c ad(aj.f paramf, Object paramObject);
    
    public abstract Object b(h paramh, ap paramap, aj.f paramf);
    
    public abstract dh.c j(aj.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.ca
 * JD-Core Version:    0.7.0.1
 */