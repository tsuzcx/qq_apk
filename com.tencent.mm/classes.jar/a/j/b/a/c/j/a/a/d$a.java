package a.j.b.a.c.j.a.a;

import a.a.v;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.j.a.k;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d$a
  extends g
{
  private final a.j.b.a.c.k.f<Collection<l>> BZu = this.CyY.CiZ.BRT.l((a.f.a.a)new d.a.b(this));
  
  public d$a()
  {
    super(localk, (Collection)localObject1, (Collection)localObject2, (Collection)localObject3, (a.f.a.a)new d.a.a((List)localCollection));
    AppMethodBeat.o(122361);
  }
  
  private final <D extends a.j.b.a.c.b.b> void a(Collection<? extends D> paramCollection, Collection<D> paramCollection1)
  {
    AppMethodBeat.i(122354);
    a.j.b.a.c.i.j.a(paramCollection, (Collection)new ArrayList(paramCollection1), (e)this.CzN, (a.j.b.a.c.i.i)new d.a.d(paramCollection1));
    AppMethodBeat.o(122354);
  }
  
  protected final a.j.b.a.c.f.a A(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(122358);
    a.f.b.j.q(paramf, "name");
    paramf = d.c(this.CzN).p(paramf);
    a.f.b.j.p(paramf, "classId.createNestedClassId(name)");
    AppMethodBeat.o(122358);
    return paramf;
  }
  
  public final Collection<ah> a(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122351);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    paramf = super.a(paramf, parama);
    AppMethodBeat.o(122351);
    return paramf;
  }
  
  public final Collection<l> a(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(122349);
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    paramd = (Collection)this.BZu.invoke();
    AppMethodBeat.o(122349);
    return paramd;
  }
  
  protected final void a(a.j.b.a.c.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(122353);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramCollection, "descriptors");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CzN.ecx().eeO().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((w)localIterator.next()).ecq().a(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbE));
    }
    a((Collection)localArrayList, paramCollection);
    AppMethodBeat.o(122353);
  }
  
  public final Collection<al> b(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122350);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    paramf = super.b(paramf, parama);
    AppMethodBeat.o(122350);
    return paramf;
  }
  
  protected final void b(a.j.b.a.c.f.f paramf, Collection<al> paramCollection)
  {
    AppMethodBeat.i(122352);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramCollection, "functions");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CzN.ecx().eeO().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((w)localIterator.next()).ecq().b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbE));
    }
    a.a.j.a((Iterable)paramCollection, (a.f.a.b)new d.a.c(this));
    paramCollection.addAll(this.CyY.CiZ.CyM.a(paramf, (e)this.CzN));
    a((Collection)localArrayList, paramCollection);
    AppMethodBeat.o(122352);
  }
  
  public final a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122357);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    d(paramf, parama);
    Object localObject = d.b(this.CzN);
    if (localObject != null)
    {
      localObject = ((d.c)localObject).B(paramf);
      if (localObject != null)
      {
        paramf = (a.j.b.a.c.b.h)localObject;
        AppMethodBeat.o(122357);
        return paramf;
      }
    }
    paramf = super.c(paramf, parama);
    AppMethodBeat.o(122357);
    return paramf;
  }
  
  protected final void c(Collection<l> paramCollection, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(122359);
    a.f.b.j.q(paramCollection, "result");
    a.f.b.j.q(paramb, "nameFilter");
    paramb = d.b(this.CzN);
    Object localObject1;
    if (paramb != null)
    {
      Object localObject2 = (Iterable)paramb.CzR.keySet();
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        e locale = paramb.B((a.j.b.a.c.f.f)((Iterator)localObject2).next());
        if (locale != null) {
          ((Collection)localObject1).add(locale);
        }
      }
    }
    for (paramb = (Collection)localObject1;; paramb = null)
    {
      localObject1 = paramb;
      if (paramb == null) {
        localObject1 = (Collection)v.BMx;
      }
      paramCollection.addAll((Collection)localObject1);
      AppMethodBeat.o(122359);
      return;
    }
  }
  
  public final void d(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122360);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    a.j.b.a.c.c.a.a(this.CyY.CiZ.CeQ, parama, (e)this.CzN, paramf);
    AppMethodBeat.o(122360);
  }
  
  protected final Set<a.j.b.a.c.f.f> eow()
  {
    AppMethodBeat.i(122355);
    Object localObject2 = (Iterable)d.a(this.CzN).eoF();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((w)((Iterator)localObject2).next()).ecq().eeT());
    }
    ((LinkedHashSet)localObject1).addAll(this.CyY.CiZ.CyM.m((e)this.CzN));
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(122355);
    return localObject1;
  }
  
  protected final Set<a.j.b.a.c.f.f> eox()
  {
    AppMethodBeat.i(122356);
    Object localObject2 = (Iterable)d.a(this.CzN).eoF();
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      a.a.j.a((Collection)localObject1, (Iterable)((w)((Iterator)localObject2).next()).ecq().eeU());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(122356);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.d.a
 * JD-Core Version:    0.7.0.1
 */