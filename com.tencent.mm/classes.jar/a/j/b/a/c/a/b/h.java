package a.j.b.a.c.a.b;

import a.a.ad;
import a.aa;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.l.ao;
import a.j.b.a.c.l.ao.a;
import a.j.b.a.c.l.c.a;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class h
{
  public static final ao a(e parame1, e parame2)
  {
    AppMethodBeat.i(119243);
    a.f.b.j.q(parame1, "from");
    a.f.b.j.q(parame2, "to");
    if (parame1.ecP().size() == parame2.ecP().size()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      parame1 = (Throwable)new AssertionError(parame1 + " and " + parame2 + " should have same number of type parameters, but " + parame1.ecP().size() + " / " + parame2.ecP().size() + " found");
      AppMethodBeat.o(119243);
      throw parame1;
    }
    Object localObject1 = ao.CBF;
    parame1 = parame1.ecP();
    a.f.b.j.p(parame1, "from.declaredTypeParameters");
    localObject1 = (Iterable)parame1;
    parame1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      parame1.add(((ar)((Iterator)localObject1).next()).ecx());
    }
    parame1 = (Iterable)parame1;
    parame2 = parame2.ecP();
    a.f.b.j.p(parame2, "to.declaredTypeParameters");
    localObject1 = (Iterable)parame2;
    parame2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ar)((Iterator)localObject1).next();
      a.f.b.j.p(localObject2, "it");
      localObject2 = ((ar)localObject2).edE();
      a.f.b.j.p(localObject2, "it.defaultType");
      parame2.add(a.aM((w)localObject2));
    }
    parame1 = ao.a.bd(ad.w((Iterable)a.a.j.a(parame1, (Iterable)parame2)));
    AppMethodBeat.o(119243);
    return parame1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.a.b.h
 * JD-Core Version:    0.7.0.1
 */