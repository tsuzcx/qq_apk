package a.j.b.a.c.d.a;

import a.aa;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.c.p;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.d.b.j.c;
import a.j.b.a.c.d.b.r;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class m$a
{
  private static a.j.b.a.c.d.b.j a(t paramt, au paramau)
  {
    AppMethodBeat.i(119697);
    if ((r.b((a.j.b.a.c.b.a)paramt)) || (f(paramt)))
    {
      paramt = paramau.eer();
      a.f.b.j.p(paramt, "valueParameterDescriptor.type");
      paramt = r.V(a.j.b.a.c.l.c.a.az(paramt));
      AppMethodBeat.o(119697);
      return paramt;
    }
    paramt = paramau.eer();
    a.f.b.j.p(paramt, "valueParameterDescriptor.type");
    paramt = r.V(paramt);
    AppMethodBeat.o(119697);
    return paramt;
  }
  
  public static boolean a(a.j.b.a.c.b.a parama1, a.j.b.a.c.b.a parama2)
  {
    AppMethodBeat.i(119696);
    a.f.b.j.q(parama1, "superDescriptor");
    a.f.b.j.q(parama2, "subDescriptor");
    if ((!(parama2 instanceof a.j.b.a.c.d.a.b.e)) || (!(parama1 instanceof t)))
    {
      AppMethodBeat.o(119696);
      return false;
    }
    if (((a.j.b.a.c.d.a.b.e)parama2).BZA.size() == ((t)parama1).edu().size()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      parama1 = (Throwable)new AssertionError("External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size");
      AppMethodBeat.o(119696);
      throw parama1;
    }
    Object localObject1 = ((a.j.b.a.c.d.a.b.e)parama2).efj();
    a.f.b.j.p(localObject1, "subDescriptor.original");
    localObject1 = ((al)localObject1).edu();
    a.f.b.j.p(localObject1, "subDescriptor.original.valueParameters");
    localObject1 = (Iterable)localObject1;
    Object localObject2 = ((t)parama1).edO();
    a.f.b.j.p(localObject2, "superDescriptor.original");
    localObject2 = ((t)localObject2).edu();
    a.f.b.j.p(localObject2, "superDescriptor.original.valueParameters");
    localObject1 = a.a.j.a((Iterable)localObject1, (Iterable)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (o)((Iterator)localObject1).next();
      localObject2 = (au)((o)localObject3).first;
      localObject3 = (au)((o)localObject3).second;
      t localt = (t)parama2;
      a.f.b.j.p(localObject2, "subParameter");
      boolean bool = a(localt, (au)localObject2) instanceof j.c;
      localObject2 = (t)parama1;
      a.f.b.j.p(localObject3, "superParameter");
      if (bool != a((t)localObject2, (au)localObject3) instanceof j.c)
      {
        AppMethodBeat.o(119696);
        return true;
      }
    }
    AppMethodBeat.o(119696);
    return false;
  }
  
  private static boolean f(t paramt)
  {
    AppMethodBeat.i(119698);
    if (paramt.edu().size() != 1)
    {
      AppMethodBeat.o(119698);
      return false;
    }
    Object localObject2 = paramt.ecv();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof a.j.b.a.c.b.e)) {
      localObject1 = null;
    }
    localObject2 = (a.j.b.a.c.b.e)localObject1;
    if (localObject2 == null)
    {
      AppMethodBeat.o(119698);
      return false;
    }
    paramt = paramt.edu();
    a.f.b.j.p(paramt, "f.valueParameters");
    paramt = a.a.j.fU(paramt);
    a.f.b.j.p(paramt, "f.valueParameters.single()");
    localObject1 = ((au)paramt).eer().enU().ecR();
    paramt = (t)localObject1;
    if (!(localObject1 instanceof a.j.b.a.c.b.e)) {
      paramt = null;
    }
    paramt = (a.j.b.a.c.b.e)paramt;
    if (paramt == null)
    {
      AppMethodBeat.o(119698);
      return false;
    }
    if ((g.d((a.j.b.a.c.b.e)localObject2)) && (a.f.b.j.e(a.j.b.a.c.i.c.a.o((l)localObject2), a.j.b.a.c.i.c.a.o((l)paramt))))
    {
      AppMethodBeat.o(119698);
      return true;
    }
    AppMethodBeat.o(119698);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.m.a
 * JD-Core Version:    0.7.0.1
 */