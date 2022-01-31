package a.j.b.a.c.l;

import a.a.ad;
import a.j.b.a.c.b.ar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ao$a
{
  public static as a(an paraman, List<? extends ap> paramList)
  {
    AppMethodBeat.i(122654);
    a.f.b.j.q(paraman, "typeConstructor");
    a.f.b.j.q(paramList, "arguments");
    Object localObject = paraman.getParameters();
    a.f.b.j.p(localObject, "typeConstructor.parameters");
    ar localar = (ar)a.a.j.fT((List)localObject);
    boolean bool;
    if (localar != null) {
      bool = localar.edA();
    }
    while (bool)
    {
      paraman = paraman.getParameters();
      a.f.b.j.p(paraman, "typeConstructor.parameters");
      localObject = (Iterable)paraman;
      paraman = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
      localObject = ((Iterable)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          localar = (ar)((Iterator)localObject).next();
          a.f.b.j.p(localar, "it");
          paraman.add(localar.ecx());
          continue;
          bool = false;
          break;
        }
      }
      paraman = (as)bd(ad.w((Iterable)a.a.j.a((Iterable)paraman, (Iterable)paramList)));
      AppMethodBeat.o(122654);
      return paraman;
    }
    paraman = (as)new u((List)localObject, paramList);
    AppMethodBeat.o(122654);
    return paraman;
  }
  
  public static as au(w paramw)
  {
    AppMethodBeat.i(122653);
    a.f.b.j.q(paramw, "kotlinType");
    paramw = a(paramw.enU(), paramw.enR());
    AppMethodBeat.o(122653);
    return paramw;
  }
  
  public static ao bd(Map<an, ? extends ap> paramMap)
  {
    AppMethodBeat.i(122652);
    a.f.b.j.q(paramMap, "map");
    paramMap = (ao)new ao.a.a(paramMap);
    AppMethodBeat.o(122652);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.ao.a
 * JD-Core Version:    0.7.0.1
 */