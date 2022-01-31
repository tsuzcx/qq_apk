package a.j.b.a.c.i.e;

import a.a.x;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.i;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class b
  implements h
{
  public static final b.a Cxj;
  private final String Cqu;
  private final List<h> Cxi;
  
  static
  {
    AppMethodBeat.i(122175);
    Cxj = new b.a((byte)0);
    AppMethodBeat.o(122175);
  }
  
  public b(String paramString, List<? extends h> paramList)
  {
    AppMethodBeat.i(122174);
    this.Cqu = paramString;
    this.Cxi = paramList;
    AppMethodBeat.o(122174);
  }
  
  public final Collection<ah> a(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122169);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    Object localObject = this.Cxi;
    if (((List)localObject).isEmpty())
    {
      paramf = (Collection)x.BMz;
      AppMethodBeat.o(122169);
      return paramf;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = a.j.b.a.c.m.b.a.b((Collection)localObject, ((h)localIterator.next()).a(paramf, parama))) {}
    if (localObject == null) {}
    for (paramf = (Collection)x.BMz;; paramf = (f)localObject)
    {
      AppMethodBeat.o(122169);
      return paramf;
    }
  }
  
  public final Collection<l> a(d paramd, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(122171);
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    Object localObject = this.Cxi;
    if (((List)localObject).isEmpty())
    {
      paramd = (Collection)x.BMz;
      AppMethodBeat.o(122171);
      return paramd;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = a.j.b.a.c.m.b.a.b((Collection)localObject, ((h)localIterator.next()).a(paramd, paramb))) {}
    if (localObject == null) {}
    for (paramd = (Collection)x.BMz;; paramd = (d)localObject)
    {
      AppMethodBeat.o(122171);
      return paramd;
    }
  }
  
  public final Collection<al> b(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122170);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    Object localObject = this.Cxi;
    if (((List)localObject).isEmpty())
    {
      paramf = (Collection)x.BMz;
      AppMethodBeat.o(122170);
      return paramf;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = a.j.b.a.c.m.b.a.b((Collection)localObject, ((h)localIterator.next()).b(paramf, parama))) {}
    if (localObject == null) {}
    for (paramf = (Collection)x.BMz;; paramf = (f)localObject)
    {
      AppMethodBeat.o(122170);
      return paramf;
    }
  }
  
  public final a.j.b.a.c.b.h c(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122168);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    Iterator localIterator = this.Cxi.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      a.j.b.a.c.b.h localh = ((h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof i)) && (((i)localh).ecJ()))
        {
          if (localObject == null) {
            localObject = localh;
          }
        }
        else
        {
          AppMethodBeat.o(122168);
          return localh;
        }
      }
    }
    AppMethodBeat.o(122168);
    return localObject;
  }
  
  public final Set<f> eeT()
  {
    AppMethodBeat.i(122172);
    Object localObject2 = (Iterable)this.Cxi;
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((h)((Iterator)localObject2).next()).eeT());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(122172);
    return localObject1;
  }
  
  public final Set<f> eeU()
  {
    AppMethodBeat.i(122173);
    Object localObject2 = (Iterable)this.Cxi;
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((h)((Iterator)localObject2).next()).eeU());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(122173);
    return localObject1;
  }
  
  public final String toString()
  {
    return this.Cqu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.e.b
 * JD-Core Version:    0.7.0.1
 */