package com.google.d;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class l
  implements dv
{
  private final k dIQ;
  
  l(k paramk)
  {
    this.dIQ = ((k)bj.c(paramk, "output"));
    this.dIQ.dJn = this;
  }
  
  private <V> void a(int paramInt, boolean paramBoolean, V paramV, bu.a<Boolean, V> parama)
  {
    this.dIQ.cE(paramInt, 2);
    this.dIQ.ke(bu.a(parama, Boolean.valueOf(paramBoolean), paramV));
    bu.a(this.dIQ, parama, Boolean.valueOf(paramBoolean), paramV);
  }
  
  public final void I(int paramInt, boolean paramBoolean)
  {
    this.dIQ.I(paramInt, paramBoolean);
  }
  
  public final <K, V> void a(int paramInt, bu.a<K, V> parama, Map<K, V> paramMap)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    Object localObject1;
    if (this.dIQ.dJo) {
      switch (1.dJl[parama.dTB.ordinal()])
      {
      default: 
        throw new IllegalArgumentException("does not support key type: " + parama.dTB);
      case 1: 
        localObject1 = paramMap.get(Boolean.FALSE);
        if (localObject1 != null) {
          a(paramInt, false, localObject1, parama);
        }
        paramMap = paramMap.get(Boolean.TRUE);
        if (paramMap != null) {
          a(paramInt, true, paramMap, parama);
        }
        break;
      }
    }
    for (;;)
    {
      return;
      localObject1 = new int[paramMap.size()];
      Object localObject2 = paramMap.keySet().iterator();
      int i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((Integer)((Iterator)localObject2).next()).intValue();
        i += 1;
      }
      Arrays.sort((int[])localObject1);
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        j = localObject1[i];
        localObject2 = paramMap.get(Integer.valueOf(j));
        this.dIQ.cE(paramInt, 2);
        this.dIQ.ke(bu.a(parama, Integer.valueOf(j), localObject2));
        bu.a(this.dIQ, parama, Integer.valueOf(j), localObject2);
        i += 1;
      }
      continue;
      localObject1 = new long[paramMap.size()];
      localObject2 = paramMap.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((Long)((Iterator)localObject2).next()).longValue();
        i += 1;
      }
      Arrays.sort((long[])localObject1);
      j = localObject1.length;
      i = k;
      while (i < j)
      {
        long l = localObject1[i];
        localObject2 = paramMap.get(Long.valueOf(l));
        this.dIQ.cE(paramInt, 2);
        this.dIQ.ke(bu.a(parama, Long.valueOf(l), localObject2));
        bu.a(this.dIQ, parama, Long.valueOf(l), localObject2);
        i += 1;
      }
      continue;
      localObject1 = new String[paramMap.size()];
      localObject2 = paramMap.keySet().iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[i] = ((String)((Iterator)localObject2).next());
        i += 1;
      }
      Arrays.sort((Object[])localObject1);
      j = localObject1.length;
      i = m;
      while (i < j)
      {
        localObject2 = localObject1[i];
        Object localObject3 = paramMap.get(localObject2);
        this.dIQ.cE(paramInt, 2);
        this.dIQ.ke(bu.a(parama, localObject2, localObject3));
        bu.a(this.dIQ, parama, localObject2, localObject3);
        i += 1;
      }
      continue;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject1 = (Map.Entry)paramMap.next();
        this.dIQ.cE(paramInt, 2);
        this.dIQ.ke(bu.a(parama, ((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue()));
        bu.a(this.dIQ, parama, ((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
      }
    }
  }
  
  public final void a(int paramInt, h paramh)
  {
    this.dIQ.a(paramInt, paramh);
  }
  
  public final void a(int paramInt, Object paramObject, dc paramdc)
  {
    this.dIQ.a(paramInt, (ce)paramObject, paramdc);
  }
  
  public final void a(int paramInt, List<String> paramList)
  {
    int i = 0;
    if ((paramList instanceof bp))
    {
      bp localbp = (bp)paramList;
      i = 0;
      if (i < paramList.size())
      {
        Object localObject = localbp.getRaw(i);
        if ((localObject instanceof String)) {
          this.dIQ.g(paramInt, (String)localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          this.dIQ.a(paramInt, (h)localObject);
        }
      }
    }
    else
    {
      while (i < paramList.size())
      {
        this.dIQ.g(paramInt, (String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public final void a(int paramInt, List<?> paramList, dc paramdc)
  {
    int i = 0;
    while (i < paramList.size())
    {
      a(paramInt, paramList.get(i), paramdc);
      i += 1;
    }
  }
  
  public final void a(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.kp(((Integer)paramList.get(i)).intValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.kd(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.cF(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final dv.a aaP()
  {
    return dv.a.dXp;
  }
  
  public final void b(int paramInt, Object paramObject, dc paramdc)
  {
    k localk = this.dIQ;
    paramObject = (ce)paramObject;
    localk.cE(paramInt, 3);
    paramdc.a(paramObject, localk.dJn);
    localk.cE(paramInt, 4);
  }
  
  public final void b(int paramInt, List<h> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      this.dIQ.a(paramInt, (h)paramList.get(i));
      i += 1;
    }
  }
  
  public final void b(int paramInt, List<?> paramList, dc paramdc)
  {
    int i = 0;
    while (i < paramList.size())
    {
      b(paramInt, paramList.get(i), paramdc);
      i += 1;
    }
  }
  
  public final void b(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Integer)paramList.get(i)).intValue();
        int k = k.aaF();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.kg(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.cI(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void c(int paramInt, List<?> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      v(paramInt, paramList.get(i));
      i += 1;
    }
  }
  
  public final void c(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.cS(((Long)paramList.get(i)).longValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.cP(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.n(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.dIQ.cF(paramInt1, paramInt2);
  }
  
  public final void cG(int paramInt1, int paramInt2)
  {
    this.dIQ.cG(paramInt1, paramInt2);
  }
  
  public final void cH(int paramInt1, int paramInt2)
  {
    this.dIQ.cH(paramInt1, paramInt2);
  }
  
  public final void cI(int paramInt1, int paramInt2)
  {
    this.dIQ.cI(paramInt1, paramInt2);
  }
  
  public final void cO(int paramInt1, int paramInt2)
  {
    this.dIQ.cI(paramInt1, paramInt2);
  }
  
  public final void cP(int paramInt1, int paramInt2)
  {
    this.dIQ.cF(paramInt1, paramInt2);
  }
  
  public final void d(int paramInt, double paramDouble)
  {
    this.dIQ.d(paramInt, paramDouble);
  }
  
  public final void d(int paramInt, List<?> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      w(paramInt, paramList.get(i));
      i += 1;
    }
  }
  
  public final void d(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.cT(((Long)paramList.get(i)).longValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.cP(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.n(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void e(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Long)paramList.get(i)).longValue();
        int k = k.aaH();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.cR(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.p(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void f(int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Float)paramList.get(i)).floatValue();
        int k = k.aaJ();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.bd(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.l(paramInt, ((Float)paramList.get(i)).floatValue());
      i += 1;
    }
  }
  
  public final void g(int paramInt, String paramString)
  {
    this.dIQ.g(paramInt, paramString);
  }
  
  public final void g(int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Double)paramList.get(i)).doubleValue();
        int k = k.aaK();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.u(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.d(paramInt, ((Double)paramList.get(i)).doubleValue());
      i += 1;
    }
  }
  
  public final void h(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.ks(((Integer)paramList.get(i)).intValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.kd(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.cF(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void i(int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Boolean)paramList.get(i)).booleanValue();
        int k = k.aaL();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.bZ(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.I(paramInt, ((Boolean)paramList.get(i)).booleanValue());
      i += 1;
    }
  }
  
  public final void j(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.kq(((Integer)paramList.get(i)).intValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.ke(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.cG(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void k(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Integer)paramList.get(i)).intValue();
        int k = k.aaG();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.kg(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.cI(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void kA(int paramInt)
  {
    this.dIQ.cE(paramInt, 4);
  }
  
  public final void kz(int paramInt)
  {
    this.dIQ.cE(paramInt, 3);
  }
  
  public final void l(int paramInt, float paramFloat)
  {
    this.dIQ.l(paramInt, paramFloat);
  }
  
  public final void l(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        ((Long)paramList.get(i)).longValue();
        int k = k.aaI();
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.cR(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.p(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void m(int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.kr(((Integer)paramList.get(i)).intValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.kf(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.cH(paramInt, ((Integer)paramList.get(i)).intValue());
      i += 1;
    }
  }
  
  public final void n(int paramInt, long paramLong)
  {
    this.dIQ.n(paramInt, paramLong);
  }
  
  public final void n(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (paramBoolean)
    {
      this.dIQ.cE(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (i < paramList.size())
      {
        int k = k.cU(((Long)paramList.get(i)).longValue());
        i += 1;
        paramInt = k + paramInt;
      }
      this.dIQ.ke(paramInt);
      paramInt = j;
      while (paramInt < paramList.size())
      {
        this.dIQ.cQ(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
    }
    while (i < paramList.size())
    {
      this.dIQ.o(paramInt, ((Long)paramList.get(i)).longValue());
      i += 1;
    }
  }
  
  public final void o(int paramInt, long paramLong)
  {
    this.dIQ.o(paramInt, paramLong);
  }
  
  public final void p(int paramInt, long paramLong)
  {
    this.dIQ.p(paramInt, paramLong);
  }
  
  public final void t(int paramInt, long paramLong)
  {
    this.dIQ.n(paramInt, paramLong);
  }
  
  public final void u(int paramInt, long paramLong)
  {
    this.dIQ.p(paramInt, paramLong);
  }
  
  public final void v(int paramInt, Object paramObject)
  {
    this.dIQ.a(paramInt, (ce)paramObject);
  }
  
  public final void w(int paramInt, Object paramObject)
  {
    this.dIQ.e(paramInt, (ce)paramObject);
  }
  
  public final void x(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof h))
    {
      this.dIQ.b(paramInt, (h)paramObject);
      return;
    }
    this.dIQ.b(paramInt, (ce)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.l
 * JD-Core Version:    0.7.0.1
 */