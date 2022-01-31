package a.j.b.a.c.d.a.c.a;

import a.a.x;
import a.f.b.v;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.l;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class d
  implements a.j.b.a.c.i.e.h
{
  final j CfB;
  private final a.j.b.a.c.k.f CfC;
  private final h CfD;
  private final a.j.b.a.c.d.a.c.h Cfb;
  
  static
  {
    AppMethodBeat.i(119864);
    eOJ = new k[] { (k)v.a(new a.f.b.t(v.aG(d.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;")) };
    AppMethodBeat.o(119864);
  }
  
  public d(a.j.b.a.c.d.a.c.h paramh, a.j.b.a.c.d.a.e.t paramt, h paramh1)
  {
    AppMethodBeat.i(119873);
    this.Cfb = paramh;
    this.CfD = paramh1;
    this.CfB = new j(this.Cfb, paramt, this.CfD);
    this.CfC = this.Cfb.Cfj.BRT.l((a.f.a.a)new d.a(this));
    AppMethodBeat.o(119873);
  }
  
  private void d(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119872);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    a.j.b.a.c.c.a.a(this.Cfb.Cfj.CeQ, parama, (ab)this.CfD, paramf);
    AppMethodBeat.o(119872);
  }
  
  private final List<a.j.b.a.c.i.e.h> efO()
  {
    AppMethodBeat.i(119865);
    List localList = (List)a.j.b.a.c.k.h.a(this.CfC, eOJ[0]);
    AppMethodBeat.o(119865);
    return localList;
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119867);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.CfB;
    Object localObject2 = efO();
    localObject1 = ((a.j.b.a.c.i.e.h)localObject1).a(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = a.j.b.a.c.m.b.a.b((Collection)localObject1, ((a.j.b.a.c.i.e.h)((Iterator)localObject2).next()).a(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)x.BMz;; paramf = (a.j.b.a.c.f.f)localObject1)
    {
      AppMethodBeat.o(119867);
      return paramf;
    }
  }
  
  public final Collection<l> a(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(119869);
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    Object localObject1 = this.CfB;
    Object localObject2 = efO();
    localObject1 = ((a.j.b.a.c.i.e.h)localObject1).a(paramd, paramb);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = a.j.b.a.c.m.b.a.b((Collection)localObject1, ((a.j.b.a.c.i.e.h)((Iterator)localObject2).next()).a(paramd, paramb));
    }
    if (localObject1 == null) {}
    for (paramd = (Collection)x.BMz;; paramd = (a.j.b.a.c.i.e.d)localObject1)
    {
      AppMethodBeat.o(119869);
      return paramd;
    }
  }
  
  public final Collection<al> b(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119868);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    Object localObject1 = this.CfB;
    Object localObject2 = efO();
    localObject1 = ((a.j.b.a.c.i.e.h)localObject1).b(paramf, parama);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localObject1 = a.j.b.a.c.m.b.a.b((Collection)localObject1, ((a.j.b.a.c.i.e.h)((Iterator)localObject2).next()).b(paramf, parama));
    }
    if (localObject1 == null) {}
    for (paramf = (Collection)x.BMz;; paramf = (a.j.b.a.c.f.f)localObject1)
    {
      AppMethodBeat.o(119868);
      return paramf;
    }
  }
  
  public final a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(119866);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    Object localObject = this.CfB.e(paramf, parama);
    if (localObject != null)
    {
      paramf = (a.j.b.a.c.b.h)localObject;
      AppMethodBeat.o(119866);
      return paramf;
    }
    Iterator localIterator = efO().iterator();
    localObject = null;
    while (localIterator.hasNext())
    {
      a.j.b.a.c.b.h localh = ((a.j.b.a.c.i.e.h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof a.j.b.a.c.b.i)) && (((a.j.b.a.c.b.i)localh).ecJ()))
        {
          if (localObject == null) {
            localObject = localh;
          }
        }
        else
        {
          AppMethodBeat.o(119866);
          return localh;
        }
      }
    }
    AppMethodBeat.o(119866);
    return localObject;
  }
  
  public final Set<a.j.b.a.c.f.f> eeT()
  {
    AppMethodBeat.i(119870);
    Object localObject2 = (Iterable)efO();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((a.j.b.a.c.i.e.h)((Iterator)localObject2).next()).eeT());
    }
    ((Set)localObject1).addAll((Collection)this.CfB.eeT());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(119870);
    return localObject1;
  }
  
  public final Set<a.j.b.a.c.f.f> eeU()
  {
    AppMethodBeat.i(119871);
    Object localObject2 = (Iterable)efO();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((a.j.b.a.c.i.e.h)((Iterator)localObject2).next()).eeU());
    }
    ((Set)localObject1).addAll((Collection)this.CfB.eeU());
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(119871);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */