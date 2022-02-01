package com.google.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class av
  extends au<am.f>
{
  private static final long dPX = ;
  
  private static <T> long ahM()
  {
    try
    {
      long l = ds.d(bg.d.class.getDeclaredField("dRL"));
      return l;
    }
    finally {}
  }
  
  final Object a(at paramat, ce paramce, int paramInt)
  {
    return ((ar)paramat).a(((cb)paramce).getDescriptorForType(), paramInt);
  }
  
  final void a(dv paramdv, Map.Entry<?, ?> paramEntry)
  {
    am.f localf = (am.f)paramEntry.getKey();
    if (localf.ahl())
    {
      switch (1.dJl[localf.ahg().ordinal()])
      {
      default: 
        return;
      case 1: 
        de.a(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 2: 
        de.b(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 3: 
        de.c(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 4: 
        de.d(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 5: 
        de.h(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 6: 
        de.f(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 7: 
        de.k(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 8: 
        de.n(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 15: 
        de.b(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv);
        return;
      case 9: 
        de.i(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 10: 
        de.l(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 11: 
        de.g(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 12: 
        de.j(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 13: 
        de.e(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv, localf.ahm());
        return;
      case 14: 
        Object localObject = (List)paramEntry.getValue();
        paramEntry = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramEntry.add(Integer.valueOf(((am.e)((Iterator)localObject).next()).dOy.dLq));
        }
        de.h(localf.dOB.dLq, paramEntry, paramdv, localf.ahm());
        return;
      case 16: 
        de.a(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv);
        return;
      case 17: 
        de.d(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv);
        return;
      }
      de.c(localf.dOB.dLq, (List)paramEntry.getValue(), paramdv);
      return;
    }
    switch (1.dJl[localf.ahg().ordinal()])
    {
    default: 
      return;
    case 1: 
      paramdv.d(localf.dOB.dLq, ((Double)paramEntry.getValue()).doubleValue());
      return;
    case 2: 
      paramdv.l(localf.dOB.dLq, ((Float)paramEntry.getValue()).floatValue());
      return;
    case 3: 
      paramdv.t(localf.dOB.dLq, ((Long)paramEntry.getValue()).longValue());
      return;
    case 4: 
      paramdv.n(localf.dOB.dLq, ((Long)paramEntry.getValue()).longValue());
      return;
    case 5: 
      paramdv.cF(localf.dOB.dLq, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 6: 
      paramdv.p(localf.dOB.dLq, ((Long)paramEntry.getValue()).longValue());
      return;
    case 7: 
      paramdv.cI(localf.dOB.dLq, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 8: 
      paramdv.I(localf.dOB.dLq, ((Boolean)paramEntry.getValue()).booleanValue());
      return;
    case 15: 
      paramdv.a(localf.dOB.dLq, (h)paramEntry.getValue());
      return;
    case 9: 
      paramdv.cG(localf.dOB.dLq, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 10: 
      paramdv.cO(localf.dOB.dLq, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 11: 
      paramdv.u(localf.dOB.dLq, ((Long)paramEntry.getValue()).longValue());
      return;
    case 12: 
      paramdv.cH(localf.dOB.dLq, ((Integer)paramEntry.getValue()).intValue());
      return;
    case 13: 
      paramdv.o(localf.dOB.dLq, ((Long)paramEntry.getValue()).longValue());
      return;
    case 14: 
      paramdv.cF(localf.dOB.dLq, ((am.e)paramEntry.getValue()).dOy.dLq);
      return;
    case 16: 
      paramdv.g(localf.dOB.dLq, (String)paramEntry.getValue());
      return;
    case 17: 
      paramdv.w(localf.dOB.dLq, paramEntry.getValue());
      return;
    }
    paramdv.v(localf.dOB.dLq, paramEntry.getValue());
  }
  
  final <UT, UB> UB ahK()
  {
    throw null;
  }
  
  final void ahL()
  {
    if (at.ahI()) {
      throw null;
    }
    throw null;
  }
  
  public final az<am.f> bs(Object paramObject)
  {
    return (az)ds.o(paramObject, dPX);
  }
  
  final az<am.f> bt(Object paramObject)
  {
    az localaz2 = bs(paramObject);
    az localaz1 = localaz2;
    if (localaz2.bRu)
    {
      localaz1 = localaz2.ahS();
      ds.a(paramObject, dPX, localaz1);
    }
    return localaz1;
  }
  
  final void bu(Object paramObject)
  {
    bs(paramObject).ZP();
  }
  
  final boolean d(ce paramce)
  {
    return paramce instanceof bg.d;
  }
  
  final int e(Map.Entry<?, ?> paramEntry)
  {
    return ((am.f)paramEntry.getKey()).dOB.dLq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.av
 * JD-Core Version:    0.7.0.1
 */