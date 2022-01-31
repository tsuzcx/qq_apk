package a.j.b.a.c.d.a.c.a;

import a.a.x;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.d.a.b.i;
import a.j.b.a.c.d.a.e.g;
import a.j.b.a.c.n.b.b;
import a.j.b.a.c.n.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  extends m
{
  private final g Cfx;
  private final f CgA;
  
  public l(a.j.b.a.c.d.a.c.h paramh, g paramg, f paramf)
  {
    super(paramh);
    AppMethodBeat.i(120018);
    this.Cfx = paramg;
    this.CgA = paramf;
    AppMethodBeat.o(120018);
  }
  
  private static <R> Set<R> a(e parame, Set<R> paramSet, a.f.a.b<? super a.j.b.a.c.i.e.h, ? extends Collection<? extends R>> paramb)
  {
    AppMethodBeat.i(120016);
    a.j.b.a.c.n.b.a((Collection)a.a.j.listOf(parame), (b.b)d.CgD, (b.c)new l.e(parame, paramSet, paramb));
    AppMethodBeat.o(120016);
    return paramSet;
  }
  
  private final ah f(ah paramah)
  {
    AppMethodBeat.i(120017);
    Object localObject = paramah.edy();
    a.f.b.j.p(localObject, "this.kind");
    if (((b.a)localObject).edz())
    {
      AppMethodBeat.o(120017);
      return paramah;
    }
    paramah = paramah.edw();
    a.f.b.j.p(paramah, "this.overriddenDescriptors");
    localObject = (Iterable)paramah;
    paramah = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ah localah = (ah)((Iterator)localObject).next();
      a.f.b.j.p(localah, "it");
      paramah.add(f(localah));
    }
    paramah = (Iterable)paramah;
    a.f.b.j.q(paramah, "receiver$0");
    paramah = (ah)a.a.j.fU(a.a.j.m((Iterable)a.a.j.q(paramah)));
    AppMethodBeat.o(120017);
    return paramah;
  }
  
  protected final Set<a.j.b.a.c.f.f> a(a.j.b.a.c.i.e.d paramd)
  {
    AppMethodBeat.i(120011);
    a.f.b.j.q(paramd, "kindFilter");
    paramd = a.a.j.q((Iterable)((b)this.Cgq.invoke()).efN());
    a((e)this.CgA, paramd, (a.f.a.b)l.c.CgC);
    AppMethodBeat.o(120011);
    return paramd;
  }
  
  protected final void a(a.j.b.a.c.f.f paramf, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(120015);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramCollection, "result");
    paramf = a((e)this.CgA, (Set)new LinkedHashSet(), (a.f.a.b)new l.b(paramf));
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramf = a.j.b.a.c.d.a.a.a.b((Collection)paramf, paramCollection, (e)this.CgA, this.Cfb.Cfj.CeJ);
      a.f.b.j.p(paramf, "resolveOverridesForStati…rorReporter\n            )");
      paramCollection.addAll(paramf);
      AppMethodBeat.o(120015);
      return;
    }
    paramf = (Iterable)paramf;
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramf.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      ah localah = f((ah)localObject2);
      localObject1 = localMap.get(localah);
      paramf = (a.j.b.a.c.f.f)localObject1;
      if (localObject1 == null)
      {
        paramf = new ArrayList();
        localMap.put(localah, paramf);
      }
      ((List)paramf).add(localObject2);
    }
    paramf = (Collection)new ArrayList();
    Object localObject1 = localMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      a.a.j.a(paramf, (Iterable)a.j.b.a.c.d.a.a.a.b((Collection)((Map.Entry)((Iterator)localObject1).next()).getValue(), paramCollection, (e)this.CgA, this.Cfb.Cfj.CeJ));
    }
    paramCollection.addAll((Collection)paramf);
    AppMethodBeat.o(120015);
  }
  
  protected final void a(Collection<al> paramCollection, a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(120014);
    a.f.b.j.q(paramCollection, "result");
    a.f.b.j.q(paramf, "name");
    Object localObject = i.s((e)this.CgA);
    if (localObject == null) {}
    for (localObject = (Set)x.BMz;; localObject = a.a.j.o((Iterable)((l)localObject).b(paramf, (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbH)))
    {
      localObject = a.j.b.a.c.d.a.a.a.b((Collection)localObject, paramCollection, (e)this.CgA, this.Cfb.Cfj.CeJ);
      a.f.b.j.p(localObject, "resolveOverridesForStati…components.errorReporter)");
      paramCollection.addAll((Collection)localObject);
      if (!this.Cfx.isEnum()) {
        break label193;
      }
      if (!a.f.b.j.e(paramf, a.j.b.a.c.i.d.CvG)) {
        break;
      }
      paramf = a.j.b.a.c.i.c.w((e)this.CgA);
      a.f.b.j.p(paramf, "createEnumValueOfMethod(ownerDescriptor)");
      paramCollection.add(paramf);
      AppMethodBeat.o(120014);
      return;
    }
    if (a.f.b.j.e(paramf, a.j.b.a.c.i.d.CvF))
    {
      paramf = a.j.b.a.c.i.c.v((e)this.CgA);
      a.f.b.j.p(paramf, "createEnumValuesMethod(ownerDescriptor)");
      paramCollection.add(paramf);
    }
    label193:
    AppMethodBeat.o(120014);
  }
  
  protected final Set<a.j.b.a.c.f.f> b(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(120010);
    a.f.b.j.q(paramd, "kindFilter");
    Set localSet = a.a.j.q((Iterable)((b)this.Cgq.invoke()).efM());
    paramd = i.s((e)this.CgA);
    if (paramd != null) {}
    for (paramd = paramd.eeT();; paramd = null)
    {
      paramb = paramd;
      if (paramd == null) {
        paramb = (Set)x.BMz;
      }
      localSet.addAll((Collection)paramb);
      if (this.Cfx.isEnum()) {
        localSet.addAll((Collection)a.a.j.listOf(new a.j.b.a.c.f.f[] { a.j.b.a.c.i.d.CvG, a.j.b.a.c.i.d.CvF }));
      }
      AppMethodBeat.o(120010);
      return localSet;
    }
  }
  
  public final a.j.b.a.c.b.h c(a.j.b.a.c.f.f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(120013);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    AppMethodBeat.o(120013);
    return null;
  }
  
  protected final Set<a.j.b.a.c.f.f> c(a.j.b.a.c.i.e.d paramd, a.f.a.b<? super a.j.b.a.c.f.f, Boolean> paramb)
  {
    AppMethodBeat.i(120012);
    a.f.b.j.q(paramd, "kindFilter");
    paramd = (Set)x.BMz;
    AppMethodBeat.o(120012);
    return paramd;
  }
  
  static final class d<N>
    implements b.b<N>
  {
    public static final d CgD;
    
    static
    {
      AppMethodBeat.i(120007);
      CgD = new d();
      AppMethodBeat.o(120007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.l
 * JD-Core Version:    0.7.0.1
 */