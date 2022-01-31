package a.j.b.a.c.i.e;

import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.k;
import a.j.b.a.c.l.w;
import a.o;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class m
  extends a
{
  public static final m.a Cye;
  private final b Cyd;
  
  static
  {
    AppMethodBeat.i(122228);
    Cye = new m.a((byte)0);
    AppMethodBeat.o(122228);
  }
  
  private m(b paramb)
  {
    this.Cyd = paramb;
  }
  
  public static final h a(String paramString, Collection<? extends w> paramCollection)
  {
    AppMethodBeat.i(122229);
    a.f.b.j.q(paramString, "message");
    a.f.b.j.q(paramCollection, "types");
    Object localObject = (Iterable)paramCollection;
    Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((w)((Iterator)localObject).next()).ecq());
    }
    paramString = new b(paramString, (List)localCollection);
    if (paramCollection.size() <= 1)
    {
      paramString = (h)paramString;
      AppMethodBeat.o(122229);
      return paramString;
    }
    paramString = (h)new m(paramString, (byte)0);
    AppMethodBeat.o(122229);
    return paramString;
  }
  
  public final Collection<ah> a(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122226);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    paramf = k.b(super.a(paramf, parama), (a.f.a.b)m.d.Cyh);
    AppMethodBeat.o(122226);
    return paramf;
  }
  
  public final Collection<l> a(d paramd, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(122227);
    a.f.b.j.q(paramd, "kindFilter");
    a.f.b.j.q(paramb, "nameFilter");
    Object localObject1 = (Iterable)super.a(paramd, paramb);
    paramd = new ArrayList();
    paramb = new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((l)localObject2 instanceof a.j.b.a.c.b.a)) {
        paramd.add(localObject2);
      } else {
        paramb.add(localObject2);
      }
    }
    paramb = new o(paramd, paramb);
    paramd = (List)paramb.first;
    paramb = (List)paramb.second;
    if (paramd == null)
    {
      paramd = new v("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
      AppMethodBeat.o(122227);
      throw paramd;
    }
    paramd = (Collection)a.a.j.b(k.b((Collection)paramd, (a.f.a.b)m.b.Cyf), (Iterable)paramb);
    AppMethodBeat.o(122227);
    return paramd;
  }
  
  public final Collection<al> b(f paramf, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122225);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "location");
    paramf = k.b(super.b(paramf, parama), (a.f.a.b)m.c.Cyg);
    AppMethodBeat.o(122225);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.e.m
 * JD-Core Version:    0.7.0.1
 */