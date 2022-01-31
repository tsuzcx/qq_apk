package a.j.b.a.c.i.e;

import a.f.a.b;
import a.f.b.j;
import a.f.b.t;
import a.g;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.ao;
import a.j.b.a.c.i.a.a.c;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.au;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class l
  implements h
{
  private final h CxQ;
  private final au CxZ;
  private Map<a.j.b.a.c.b.l, a.j.b.a.c.b.l> Cya;
  private final a.f Cyb;
  
  static
  {
    AppMethodBeat.i(122208);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(l.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;")) };
    AppMethodBeat.o(122208);
  }
  
  public l(h paramh, au paramau)
  {
    AppMethodBeat.i(122217);
    this.CxQ = paramh;
    paramh = paramau.BZY;
    j.p(paramh, "givenSubstitutor.substitution");
    this.CxZ = c.c(paramh).eoP();
    this.Cyb = g.j((a.f.a.a)new l.a(this));
    AppMethodBeat.o(122217);
  }
  
  private final <D extends a.j.b.a.c.b.l> D J(D paramD)
  {
    AppMethodBeat.i(122209);
    if (this.CxZ.BZY.isEmpty())
    {
      AppMethodBeat.o(122209);
      return paramD;
    }
    if (this.Cya == null) {
      this.Cya = ((Map)new HashMap());
    }
    Map localMap = this.Cya;
    if (localMap == null) {
      j.ebi();
    }
    Object localObject2 = localMap.get(paramD);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((paramD instanceof ao))
      {
        localObject1 = ((ao)paramD).f(this.CxZ);
        if (localObject1 == null)
        {
          paramD = (Throwable)new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + paramD + " substitution fails");
          AppMethodBeat.o(122209);
          throw paramD;
        }
        localObject1 = (a.j.b.a.c.b.l)localObject1;
        localMap.put(paramD, localObject1);
      }
    }
    else
    {
      paramD = (a.j.b.a.c.b.l)localObject1;
      if (paramD != null) {
        break label210;
      }
      paramD = new a.v("null cannot be cast to non-null type D");
      AppMethodBeat.o(122209);
      throw paramD;
    }
    paramD = (Throwable)new IllegalStateException("Unknown descriptor in scope: ".concat(String.valueOf(paramD)).toString());
    AppMethodBeat.o(122209);
    throw paramD;
    label210:
    AppMethodBeat.o(122209);
    return paramD;
  }
  
  private final <D extends a.j.b.a.c.b.l> Collection<D> m(Collection<? extends D> paramCollection)
  {
    AppMethodBeat.i(122210);
    if (this.CxZ.BZY.isEmpty())
    {
      AppMethodBeat.o(122210);
      return paramCollection;
    }
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(122210);
      return paramCollection;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(a.j.b.a.c.n.a.VZ(paramCollection.size()));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localLinkedHashSet.add(J((a.j.b.a.c.b.l)paramCollection.next()));
    }
    paramCollection = (Collection)localLinkedHashSet;
    AppMethodBeat.o(122210);
    return paramCollection;
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122211);
    j.q(paramf, "name");
    j.q(parama, "location");
    paramf = m(this.CxQ.a(paramf, parama));
    AppMethodBeat.o(122211);
    return paramf;
  }
  
  public final Collection<a.j.b.a.c.b.l> a(d paramd, b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(122214);
    j.q(paramd, "kindFilter");
    j.q(paramb, "nameFilter");
    paramd = (Collection)this.Cyb.getValue();
    AppMethodBeat.o(122214);
    return paramd;
  }
  
  public final Collection<al> b(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122213);
    j.q(paramf, "name");
    j.q(parama, "location");
    paramf = m(this.CxQ.b(paramf, parama));
    AppMethodBeat.o(122213);
    return paramf;
  }
  
  public final a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122212);
    j.q(paramf, "name");
    j.q(parama, "location");
    paramf = this.CxQ.c(paramf, parama);
    if (paramf != null)
    {
      paramf = (a.j.b.a.c.b.h)J((a.j.b.a.c.b.l)paramf);
      AppMethodBeat.o(122212);
      return paramf;
    }
    AppMethodBeat.o(122212);
    return null;
  }
  
  public final Set<a.j.b.a.c.f.f> eeT()
  {
    AppMethodBeat.i(122215);
    Set localSet = this.CxQ.eeT();
    AppMethodBeat.o(122215);
    return localSet;
  }
  
  public final Set<a.j.b.a.c.f.f> eeU()
  {
    AppMethodBeat.i(122216);
    Set localSet = this.CxQ.eeU();
    AppMethodBeat.o(122216);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.e.l
 * JD-Core Version:    0.7.0.1
 */