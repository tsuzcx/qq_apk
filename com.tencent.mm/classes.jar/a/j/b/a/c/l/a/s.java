package a.j.b.a.c.l.a;

import a.aa;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<+La.j.b.a.c.l.ad;>;
import java.util.Set;

public final class s
{
  public static final s CCT;
  
  static
  {
    AppMethodBeat.i(122808);
    CCT = new s();
    AppMethodBeat.o(122808);
  }
  
  public static ad gj(List<? extends ad> paramList)
  {
    AppMethodBeat.i(122806);
    a.f.b.j.q(paramList, "types");
    if (paramList.size() > 1) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("Size should be at least 2, but it is " + paramList.size());
      AppMethodBeat.o(122806);
      throw paramList;
    }
    Object localObject2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    Object localObject3;
    while (localIterator1.hasNext())
    {
      localObject3 = (ad)localIterator1.next();
      if ((((ad)localObject3).enU() instanceof a.j.b.a.c.l.v))
      {
        paramList = ((ad)localObject3).enU().eeO();
        a.f.b.j.p(paramList, "type.constructor.supertypes");
        paramList = (Iterable)paramList;
        Collection localCollection = (Collection)new ArrayList(a.a.j.d(paramList));
        Iterator localIterator2 = paramList.iterator();
        while (localIterator2.hasNext())
        {
          paramList = (w)localIterator2.next();
          a.f.b.j.p(paramList, "it");
          localObject1 = t.al(paramList);
          paramList = (List<? extends ad>)localObject1;
          if (((ad)localObject3).egH()) {
            paramList = ((ad)localObject1).ss(true);
          }
          localCollection.add(paramList);
        }
        ((ArrayList)localObject2).addAll((Collection)localCollection);
      }
      else
      {
        ((ArrayList)localObject2).add(localObject3);
      }
    }
    paramList = (Iterable)localObject2;
    Object localObject1 = s.a.CCU;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localObject1 = ((s.a)localObject1).f((az)paramList.next());
    }
    paramList = (Iterable)localObject2;
    localObject2 = (Collection)new LinkedHashSet();
    localIterator1 = paramList.iterator();
    if (localIterator1.hasNext())
    {
      paramList = (ad)localIterator1.next();
      if (localObject1 == s.a.CCX)
      {
        a.f.b.j.q(paramList, "receiver$0");
        localObject3 = a.j.b.a.c.l.g.CAX;
        localObject3 = a.j.b.a.c.l.g.a.a((az)paramList);
        if (localObject3 != null) {
          paramList = (ad)localObject3;
        }
      }
      for (;;)
      {
        ((Collection)localObject2).add(paramList);
        break;
        paramList = paramList.ss(false);
      }
    }
    paramList = o((Set)localObject2);
    AppMethodBeat.o(122806);
    return paramList;
  }
  
  private static ad o(Set<? extends ad> paramSet)
  {
    AppMethodBeat.i(122807);
    if (paramSet.size() == 1)
    {
      paramSet = (ad)a.a.j.h((Iterable)paramSet);
      AppMethodBeat.o(122807);
      return paramSet;
    }
    Object localObject1 = new ArrayList((Collection)paramSet);
    Object localObject2 = ((ArrayList)localObject1).iterator();
    a.f.b.j.p(localObject2, "filteredSuperAndEqualTypes.iterator()");
    label104:
    label241:
    label244:
    label249:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ad)((Iterator)localObject2).next();
      Object localObject4 = (Iterable)localObject1;
      if (!((Collection)localObject4).isEmpty())
      {
        localObject4 = ((Iterable)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          ad localad = (ad)((Iterator)localObject4).next();
          if (localad != localObject3)
          {
            a.f.b.j.p(localad, "lower");
            w localw1 = (w)localad;
            a.f.b.j.p(localObject3, "upper");
            w localw2 = (w)localObject3;
            h localh = h.CCq;
            if ((localh.c(localw1, localw2)) && (!localh.c(localw2, localw1)))
            {
              i = 1;
              if ((i == 0) && (!h.CCq.d((w)localad, (w)localObject3))) {
                break label241;
              }
              i = 1;
              if (i == 0) {
                break label244;
              }
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label249;
        }
        ((Iterator)localObject2).remove();
        break;
        i = 0;
        break label192;
        i = 0;
        break label217;
        break label104;
      }
    }
    label192:
    label217:
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramSet = (Throwable)new AssertionError("This collections cannot be empty! input types: " + a.a.j.a((Iterable)paramSet, null, null, null, 0, null, null, 63));
      AppMethodBeat.o(122807);
      throw paramSet;
    }
    if (((ArrayList)localObject1).size() < 2)
    {
      paramSet = a.a.j.fU((List)localObject1);
      a.f.b.j.p(paramSet, "filteredSuperAndEqualTypes.single()");
      paramSet = (ad)paramSet;
      AppMethodBeat.o(122807);
      return paramSet;
    }
    paramSet = new a.j.b.a.c.l.v((Collection)paramSet);
    localObject1 = a.j.b.a.c.b.a.g.BXx;
    localObject1 = a.j.b.a.c.b.a.g.a.eeH();
    localObject2 = (an)paramSet;
    Object localObject3 = (List)a.a.v.BMx;
    paramSet = paramSet.eoK();
    a.f.b.j.p(paramSet, "constructor.createScopeForKotlinType()");
    paramSet = x.a((a.j.b.a.c.b.a.g)localObject1, (an)localObject2, (List)localObject3, false, paramSet);
    AppMethodBeat.o(122807);
    return paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.a.s
 * JD-Core Version:    0.7.0.1
 */