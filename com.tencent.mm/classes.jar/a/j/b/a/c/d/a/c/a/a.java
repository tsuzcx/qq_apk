package a.j.b.a.c.d.a.c.a;

import a.a.v;
import a.j.b.a.c.d.a.e.g;
import a.j.b.a.c.d.a.e.n;
import a.j.b.a.c.d.a.e.p;
import a.j.b.a.c.d.a.e.q;
import a.j.b.a.c.f.f;
import a.k.h;
import a.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
  implements b
{
  private final a.f.a.b<q, Boolean> Cfu;
  private final Map<f, List<q>> Cfv;
  private final Map<f, n> Cfw;
  private final g Cfx;
  final a.f.a.b<p, Boolean> Cfy;
  
  public a(g paramg, a.f.a.b<? super p, Boolean> paramb)
  {
    AppMethodBeat.i(119858);
    this.Cfx = paramg;
    this.Cfy = paramb;
    this.Cfu = ((a.f.a.b)new a.a(this));
    paramg = i.a(a.a.j.t((Iterable)this.Cfx.egh()), this.Cfu);
    Object localObject1 = (Map)new LinkedHashMap();
    Iterator localIterator = paramg.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      f localf = ((q)localObject2).edF();
      paramb = ((Map)localObject1).get(localf);
      paramg = paramb;
      if (paramb == null)
      {
        paramg = new ArrayList();
        ((Map)localObject1).put(localf, paramg);
      }
      ((List)paramg).add(localObject2);
    }
    this.Cfv = ((Map)localObject1);
    paramb = i.a(a.a.j.t((Iterable)this.Cfx.egi()), this.Cfy);
    paramg = (Map)new LinkedHashMap();
    paramb = paramb.iterator();
    while (paramb.hasNext())
    {
      localObject1 = paramb.next();
      paramg.put(((n)localObject1).edF(), localObject1);
    }
    this.Cfw = paramg;
    AppMethodBeat.o(119858);
  }
  
  public final Set<f> efM()
  {
    AppMethodBeat.i(119855);
    Object localObject2 = i.a(a.a.j.t((Iterable)this.Cfx.egh()), this.Cfu);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((q)((Iterator)localObject2).next()).edF());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(119855);
    return localObject1;
  }
  
  public final Set<f> efN()
  {
    AppMethodBeat.i(119857);
    Object localObject2 = i.a(a.a.j.t((Iterable)this.Cfx.egi()), this.Cfy);
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((h)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((n)((Iterator)localObject2).next()).edF());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(119857);
    return localObject1;
  }
  
  public final Collection<q> k(f paramf)
  {
    AppMethodBeat.i(119854);
    a.f.b.j.q(paramf, "name");
    paramf = (List)this.Cfv.get(paramf);
    if (paramf != null)
    {
      paramf = (Collection)paramf;
      AppMethodBeat.o(119854);
      return paramf;
    }
    paramf = (Collection)v.BMx;
    AppMethodBeat.o(119854);
    return paramf;
  }
  
  public final n l(f paramf)
  {
    AppMethodBeat.i(119856);
    a.f.b.j.q(paramf, "name");
    paramf = (n)this.Cfw.get(paramf);
    AppMethodBeat.o(119856);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */