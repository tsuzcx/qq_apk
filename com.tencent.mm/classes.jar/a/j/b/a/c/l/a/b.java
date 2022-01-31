package a.j.b.a.c.l.a;

import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.n;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.q;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.j.b.a.c.l.y;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b
{
  public static final az gi(List<? extends az> paramList)
  {
    AppMethodBeat.i(122714);
    a.f.b.j.q(paramList, "types");
    int i;
    int j;
    switch (paramList.size())
    {
    default: 
      localObject1 = (Iterable)paramList;
      localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      i = 0;
      j = 0;
      if (!localIterator.hasNext()) {
        break label229;
      }
      localObject1 = (az)localIterator.next();
      if ((i != 0) || (y.an((w)localObject1)))
      {
        i = 1;
        label110:
        if (!(localObject1 instanceof ad)) {
          break label177;
        }
        localObject1 = (ad)localObject1;
      }
      break;
    }
    for (;;)
    {
      ((Collection)localObject2).add(localObject1);
      break;
      paramList = (Throwable)new IllegalStateException("Expected some types".toString());
      AppMethodBeat.o(122714);
      throw paramList;
      paramList = (az)a.a.j.fU(paramList);
      AppMethodBeat.o(122714);
      return paramList;
      i = 0;
      break label110;
      label177:
      if (!(localObject1 instanceof q)) {
        break label214;
      }
      if (n.ag((w)localObject1))
      {
        AppMethodBeat.o(122714);
        return localObject1;
      }
      localObject1 = ((q)localObject1).CBm;
      j = 1;
    }
    label214:
    paramList = new m();
    AppMethodBeat.o(122714);
    throw paramList;
    label229:
    Object localObject1 = (List)localObject2;
    if (i != 0)
    {
      paramList = p.azj("Intersection of error types: ".concat(String.valueOf(paramList)));
      a.f.b.j.p(paramList, "ErrorUtils.createErrorTy… of error types: $types\")");
      paramList = (az)paramList;
      AppMethodBeat.o(122714);
      return paramList;
    }
    if (j == 0)
    {
      paramList = s.CCT;
      paramList = (az)s.gj((List)localObject1);
      AppMethodBeat.o(122714);
      return paramList;
    }
    Object localObject2 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add(t.al((w)((Iterator)localObject2).next()));
    }
    paramList = (List)paramList;
    localObject2 = s.CCT;
    localObject1 = s.gj((List)localObject1);
    localObject2 = s.CCT;
    paramList = x.a((ad)localObject1, s.gj(paramList));
    AppMethodBeat.o(122714);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.l.a.b
 * JD-Core Version:    0.7.0.1
 */