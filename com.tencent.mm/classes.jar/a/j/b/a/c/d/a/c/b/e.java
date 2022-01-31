package a.j.b.a.c.d.a.c.b;

import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.j.b.a.c.l.y;
import a.m;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class e
  extends as
{
  private static final a Chc;
  private static final a Chd;
  public static final e Che;
  
  static
  {
    AppMethodBeat.i(120062);
    Che = new e();
    Chc = d.a(a.j.b.a.c.d.a.a.l.Cek, false, null, 3).a(b.CgQ);
    Chd = d.a(a.j.b.a.c.d.a.a.l.Cek, false, null, 3).a(b.CgP);
    AppMethodBeat.o(120062);
  }
  
  private final w P(w paramw)
  {
    AppMethodBeat.i(120058);
    Object localObject;
    for (;;)
    {
      localObject = paramw.enU().ecR();
      if (!(localObject instanceof a.j.b.a.c.b.ar)) {
        break;
      }
      paramw = d.b((a.j.b.a.c.b.ar)localObject);
    }
    if ((localObject instanceof a.j.b.a.c.b.e))
    {
      o localo = a(t.ak(paramw), (a.j.b.a.c.b.e)localObject, Chc);
      ad localad = (ad)localo.first;
      boolean bool1 = ((Boolean)localo.second).booleanValue();
      paramw = a(t.al(paramw), (a.j.b.a.c.b.e)localObject, Chd);
      localObject = (ad)paramw.first;
      boolean bool2 = ((Boolean)paramw.second).booleanValue();
      if ((bool1) || (bool2)) {}
      for (paramw = (az)new g(localad, (ad)localObject);; paramw = x.a(localad, (ad)localObject))
      {
        paramw = (w)paramw;
        AppMethodBeat.o(120058);
        return paramw;
      }
    }
    paramw = (Throwable)new IllegalStateException("Unexpected declaration kind: ".concat(String.valueOf(localObject)).toString());
    AppMethodBeat.o(120058);
    throw paramw;
  }
  
  public static ap a(a.j.b.a.c.b.ar paramar, a parama, w paramw)
  {
    AppMethodBeat.i(120060);
    a.f.b.j.q(paramar, "parameter");
    a.f.b.j.q(parama, "attr");
    a.f.b.j.q(paramw, "erasedUpperBound");
    Object localObject = parama.CgL;
    switch (f.bLo[localObject.ordinal()])
    {
    default: 
      paramar = new m();
      AppMethodBeat.o(120060);
      throw paramar;
    case 1: 
      paramar = (ap)new a.j.b.a.c.l.ar(ba.CBX, paramw);
      AppMethodBeat.o(120060);
      return paramar;
    }
    if (!paramar.edG().CCc)
    {
      paramar = (ap)new a.j.b.a.c.l.ar(ba.CBX, (w)a.j.b.a.c.i.c.a.G((a.j.b.a.c.b.l)paramar).eck());
      AppMethodBeat.o(120060);
      return paramar;
    }
    localObject = paramw.enU().getParameters();
    a.f.b.j.p(localObject, "erasedUpperBound.constructor.parameters");
    if (!((Collection)localObject).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramar = (ap)new a.j.b.a.c.l.ar(ba.CBZ, paramw);
      AppMethodBeat.o(120060);
      return paramar;
    }
    paramar = d.a(paramar, parama);
    AppMethodBeat.o(120060);
    return paramar;
  }
  
  private final o<ad, Boolean> a(ad paramad, a.j.b.a.c.b.e parame, a parama)
  {
    AppMethodBeat.i(120059);
    if (paramad.enU().getParameters().isEmpty())
    {
      paramad = u.F(paramad, Boolean.FALSE);
      AppMethodBeat.o(120059);
      return paramad;
    }
    if (a.j.b.a.c.a.g.n((w)paramad))
    {
      parama = (ap)paramad.enR().get(0);
      parame = parama.eoO();
      parama = parama.eer();
      a.f.b.j.p(parama, "componentTypeProjection.type");
      parame = a.a.j.listOf(new a.j.b.a.c.l.ar(parame, P(parama)));
      paramad = u.F(x.c(paramad.ecM(), paramad.enU(), parame, paramad.egH()), Boolean.FALSE);
      AppMethodBeat.o(120059);
      return paramad;
    }
    if (y.an((w)paramad))
    {
      paramad = u.F(p.azj("Raw error type: " + paramad.enU()), Boolean.FALSE);
      AppMethodBeat.o(120059);
      return paramad;
    }
    a.j.b.a.c.b.a.g localg = paramad.ecM();
    an localan = paramad.enU();
    Object localObject1 = paramad.enU().getParameters();
    a.f.b.j.p(localObject1, "type.constructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.j.b.a.c.b.ar localar = (a.j.b.a.c.b.ar)((Iterator)localObject2).next();
      a.f.b.j.p(localar, "parameter");
      ((Collection)localObject1).add(b(localar, parama));
    }
    parama = (List)localObject1;
    boolean bool = paramad.egH();
    paramad = parame.a((as)Che);
    a.f.b.j.p(paramad, "declaration.getMemberScope(RawSubstitution)");
    paramad = u.F(x.a(localg, localan, parama, bool, paramad), Boolean.TRUE);
    AppMethodBeat.o(120059);
    return paramad;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.e
 * JD-Core Version:    0.7.0.1
 */