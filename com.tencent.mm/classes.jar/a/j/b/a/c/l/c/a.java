package a.j.b.a.c.l.c;

import a.j.b.a.c.l.a.c;
import a.j.b.a.c.l.a.e;
import a.j.b.a.c.l.a.k;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ah;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.at;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ax;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.q;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static final boolean A(w paramw)
  {
    AppMethodBeat.i(122819);
    a.f.b.j.q(paramw, "receiver$0");
    boolean bool = a.j.b.a.c.a.g.A(paramw);
    AppMethodBeat.o(122819);
    return bool;
  }
  
  public static final ap a(w paramw, ba paramba, a.j.b.a.c.b.ar paramar)
  {
    AppMethodBeat.i(122823);
    a.f.b.j.q(paramw, "type");
    a.f.b.j.q(paramba, "projectionKind");
    if (paramar != null) {}
    for (paramar = paramar.edG();; paramar = null)
    {
      ba localba = paramba;
      if (paramar == paramba) {
        localba = ba.CBX;
      }
      paramw = (ap)new a.j.b.a.c.l.ar(localba, paramw);
      AppMethodBeat.o(122823);
      return paramw;
    }
  }
  
  public static final w a(w paramw, a.j.b.a.c.b.a.g paramg)
  {
    AppMethodBeat.i(122822);
    a.f.b.j.q(paramw, "receiver$0");
    a.f.b.j.q(paramg, "newAnnotations");
    if ((paramw.ecM().isEmpty()) && (paramg.isEmpty()))
    {
      AppMethodBeat.o(122822);
      return paramw;
    }
    paramw = (w)paramw.eoL().b(paramg);
    AppMethodBeat.o(122822);
    return paramw;
  }
  
  public static final w aA(w paramw)
  {
    AppMethodBeat.i(122818);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = av.aA(paramw);
    a.f.b.j.p(paramw, "TypeUtils.makeNotNullable(this)");
    AppMethodBeat.o(122818);
    return paramw;
  }
  
  public static final boolean aE(w paramw)
  {
    AppMethodBeat.i(122820);
    a.f.b.j.q(paramw, "receiver$0");
    boolean bool = av.aE(paramw);
    AppMethodBeat.o(122820);
    return bool;
  }
  
  public static final a.j.b.a.c.a.g aL(w paramw)
  {
    AppMethodBeat.i(122816);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.enU().eec();
    a.f.b.j.p(paramw, "constructor.builtIns");
    AppMethodBeat.o(122816);
    return paramw;
  }
  
  public static final ap aM(w paramw)
  {
    AppMethodBeat.i(122824);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = (ap)new a.j.b.a.c.l.ar(paramw);
    AppMethodBeat.o(122824);
    return paramw;
  }
  
  public static final w aN(w paramw)
  {
    AppMethodBeat.i(122825);
    a.f.b.j.q(paramw, "receiver$0");
    az localaz = paramw.eoL();
    ad localad;
    Object localObject1;
    if ((localaz instanceof q))
    {
      localad = ((q)localaz).CBm;
      paramw = localad;
      if (!localad.enU().getParameters().isEmpty())
      {
        if (localad.enU().ecR() == null) {
          paramw = localad;
        }
      }
      else
      {
        localad = ((q)localaz).CBn;
        if ((!localad.enU().getParameters().isEmpty()) && (localad.enU().ecR() != null)) {
          break label216;
        }
      }
      for (;;)
      {
        paramw = x.a(paramw, localad);
        paramw = (w)ax.a(paramw, (w)localaz);
        AppMethodBeat.o(122825);
        return paramw;
        paramw = localad.enU().getParameters();
        a.f.b.j.p(paramw, "constructor.parameters");
        localObject1 = (Iterable)paramw;
        paramw = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramw.add(new ah((a.j.b.a.c.b.ar)((Iterator)localObject1).next()));
        }
        paramw = at.a(localad, (List)paramw);
        break;
        label216:
        localObject1 = localad.enU().getParameters();
        a.f.b.j.p(localObject1, "constructor.parameters");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new ah((a.j.b.a.c.b.ar)((Iterator)localObject2).next()));
        }
        localad = at.a(localad, (List)localObject1);
      }
    }
    if ((localaz instanceof ad))
    {
      localad = (ad)localaz;
      paramw = localad;
      if (!localad.enU().getParameters().isEmpty()) {
        if (localad.enU().ecR() != null) {
          break label365;
        }
      }
      for (paramw = localad;; paramw = at.a(localad, (List)paramw))
      {
        paramw = (az)paramw;
        break;
        label365:
        paramw = localad.enU().getParameters();
        a.f.b.j.p(paramw, "constructor.parameters");
        localObject1 = (Iterable)paramw;
        paramw = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramw.add(new ah((a.j.b.a.c.b.ar)((Iterator)localObject1).next()));
        }
      }
    }
    paramw = new m();
    AppMethodBeat.o(122825);
    throw paramw;
  }
  
  public static final w az(w paramw)
  {
    AppMethodBeat.i(122817);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = av.az(paramw);
    a.f.b.j.p(paramw, "TypeUtils.makeNullable(this)");
    AppMethodBeat.o(122817);
    return paramw;
  }
  
  public static final boolean c(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122821);
    a.f.b.j.q(paramw1, "receiver$0");
    a.f.b.j.q(paramw2, "superType");
    boolean bool = c.CCi.c(paramw1, paramw2);
    AppMethodBeat.o(122821);
    return bool;
  }
  
  public static final boolean h(az paramaz)
  {
    AppMethodBeat.i(122826);
    a.f.b.j.q(paramaz, "receiver$0");
    if (((paramaz.enU() instanceof k)) || ((paramaz.enU().ecR() instanceof a.j.b.a.c.b.ar)) || ((paramaz instanceof e)))
    {
      AppMethodBeat.o(122826);
      return true;
    }
    AppMethodBeat.o(122826);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.c.a
 * JD-Core Version:    0.7.0.1
 */