package a.j.b.a.c.b;

import a.a.v;
import a.aa;
import a.f.a.b;
import a.f.b.k;
import a.j.b.a.c.i.d;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.w;
import a.k.h;
import a.k.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class as
{
  public static final af a(w paramw, i parami, int paramInt)
  {
    AppMethodBeat.i(119300);
    if ((parami == null) || (p.L((l)parami)))
    {
      AppMethodBeat.o(119300);
      return null;
    }
    int j = parami.ecP().size() + paramInt;
    if (!parami.ecG())
    {
      if ((j == paramw.enR().size()) || (d.m((l)parami))) {}
      for (int i = 1; (aa.BMh) && (i == 0); i = 0)
      {
        paramw = (Throwable)new AssertionError(paramw.enR().size() - j + " trailing arguments were found in " + paramw + " type");
        AppMethodBeat.o(119300);
        throw paramw;
      }
      paramw = new af(parami, paramw.enR().subList(paramInt, paramw.enR().size()), null);
      AppMethodBeat.o(119300);
      return paramw;
    }
    List localList = paramw.enR().subList(paramInt, j);
    l locall2 = parami.ecv();
    l locall1 = locall2;
    if (!(locall2 instanceof i)) {
      locall1 = null;
    }
    paramw = new af(parami, localList, a(paramw, (i)locall1, j));
    AppMethodBeat.o(119300);
    return paramw;
  }
  
  public static final List<ar> a(i parami)
  {
    Object localObject2 = null;
    AppMethodBeat.i(119299);
    a.f.b.j.q(parami, "receiver$0");
    List localList = parami.ecP();
    a.f.b.j.p(localList, "declaredTypeParameters");
    if ((!parami.ecG()) && (!(parami.ecv() instanceof a)))
    {
      AppMethodBeat.o(119299);
      return localList;
    }
    Object localObject1 = a.j.b.a.c.i.c.a.H((l)parami);
    Object localObject3 = (b)a.BWI;
    a.f.b.j.q(localObject1, "receiver$0");
    a.f.b.j.q(localObject3, "predicate");
    localObject3 = a.k.i.c(a.k.i.c((h)new o((h)localObject1, (b)localObject3), (b)b.BWJ));
    Object localObject4 = a.j.b.a.c.i.c.a.H((l)parami).iterator();
    do
    {
      if (!((Iterator)localObject4).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject4).next();
    } while (!(localObject1 instanceof e));
    for (;;)
    {
      localObject4 = (e)localObject1;
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject4 = ((e)localObject4).ecx();
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((an)localObject4).getParameters();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)v.BMx;
      }
      if ((!((List)localObject3).isEmpty()) || (!((List)localObject2).isEmpty())) {
        break;
      }
      parami = parami.ecP();
      a.f.b.j.p(parami, "declaredTypeParameters");
      AppMethodBeat.o(119299);
      return parami;
      localObject1 = null;
    }
    localObject2 = (Iterable)a.a.j.b((Collection)localObject3, (Iterable)localObject2);
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ar)((Iterator)localObject2).next();
      a.f.b.j.p(localObject3, "it");
      ((Collection)localObject1).add(new c((ar)localObject3, (l)parami, localList.size()));
    }
    parami = (List)localObject1;
    parami = a.a.j.b((Collection)localList, (Iterable)parami);
    AppMethodBeat.o(119299);
    return parami;
  }
  
  static final class a
    extends k
    implements b<l, Boolean>
  {
    public static final a BWI;
    
    static
    {
      AppMethodBeat.i(119296);
      BWI = new a();
      AppMethodBeat.o(119296);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends k
    implements b<l, h<? extends ar>>
  {
    public static final b BWJ;
    
    static
    {
      AppMethodBeat.i(119298);
      BWJ = new b();
      AppMethodBeat.o(119298);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.b.as
 * JD-Core Version:    0.7.0.1
 */