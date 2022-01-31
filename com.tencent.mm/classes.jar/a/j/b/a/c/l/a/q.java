package a.j.b.a.c.l.a;

import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.i.c.a;
import a.j.b.a.c.l.am;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class q
{
  private final r CCM;
  
  static
  {
    AppMethodBeat.i(122801);
    if (!q.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(122801);
      return;
    }
  }
  
  public q(r paramr)
  {
    this.CCM = paramr;
  }
  
  private static w a(ar paramar, ap paramap)
  {
    AppMethodBeat.i(122792);
    if ((paramap.eoO() == ba.CBY) || (paramar.edG() == ba.CBY)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramar = a.G(paramar).ecm();
      AppMethodBeat.o(122792);
      return paramar;
    }
    paramar = paramap.eer();
    AppMethodBeat.o(122792);
    return paramar;
  }
  
  private static boolean a(ap paramap1, ap paramap2, ar paramar)
  {
    AppMethodBeat.i(122800);
    if (paramar.edG() != ba.CBX)
    {
      AppMethodBeat.o(122800);
      return false;
    }
    if ((paramap1.eoO() != ba.CBX) && (paramap2.eoO() == ba.CBX))
    {
      paramap2.eer();
      AppMethodBeat.o(122800);
      return false;
    }
    AppMethodBeat.o(122800);
    return false;
  }
  
  private static w b(ar paramar, ap paramap)
  {
    AppMethodBeat.i(122793);
    if ((paramap.eoO() == ba.CBZ) || (paramar.edG() == ba.CBZ)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramar = a.G(paramar).eck();
      AppMethodBeat.o(122793);
      return paramar;
    }
    paramar = paramap.eer();
    AppMethodBeat.o(122793);
    return paramar;
  }
  
  private static q.a c(ar paramar, ap paramap)
  {
    AppMethodBeat.i(122796);
    paramar = paramar.edG();
    paramap = paramap.eoO();
    if (paramap == ba.CBX) {}
    for (;;)
    {
      if ((paramap == ba.CBY) && (paramar == ba.CBZ))
      {
        paramar = q.a.CCR;
        AppMethodBeat.o(122796);
        return paramar;
      }
      if ((paramap == ba.CBZ) && (paramar == ba.CBY))
      {
        paramar = q.a.CCR;
        AppMethodBeat.o(122796);
        return paramar;
      }
      paramar = q.a.a(paramar);
      AppMethodBeat.o(122796);
      return paramar;
      ar localar = paramar;
      paramar = paramap;
      paramap = localar;
    }
  }
  
  public static w e(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122791);
    paramw1 = t.a(paramw1, paramw2, new p());
    AppMethodBeat.o(122791);
    return paramw1;
  }
  
  private boolean f(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122795);
    if ((!$assertionsDisabled) && (a.j.b.a.c.l.t.ai(paramw1)))
    {
      paramw1 = new AssertionError("Only inflexible types are allowed here: ".concat(String.valueOf(paramw1)));
      AppMethodBeat.o(122795);
      throw paramw1;
    }
    if ((c(a.j.b.a.c.l.t.aj(paramw2).CBm, paramw1)) && (c(paramw1, a.j.b.a.c.l.t.aj(paramw2).CBn)))
    {
      AppMethodBeat.o(122795);
      return true;
    }
    AppMethodBeat.o(122795);
    return false;
  }
  
  private boolean g(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122798);
    if ((y.an(paramw1)) || (y.an(paramw2)))
    {
      AppMethodBeat.o(122798);
      return true;
    }
    if ((!paramw2.egH()) && (paramw1.egH()))
    {
      AppMethodBeat.o(122798);
      return false;
    }
    if (g.z(paramw1))
    {
      AppMethodBeat.o(122798);
      return true;
    }
    paramw1 = t.a(paramw1, paramw2, this.CCM);
    if (paramw1 == null)
    {
      AppMethodBeat.o(122798);
      return false;
    }
    if ((!paramw2.egH()) && (paramw1.egH()))
    {
      AppMethodBeat.o(122798);
      return false;
    }
    boolean bool = h(paramw1, paramw2);
    AppMethodBeat.o(122798);
    return bool;
  }
  
  private boolean h(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122799);
    Object localObject1 = paramw1.enU();
    paramw1 = paramw1.enR();
    paramw2 = paramw2.enR();
    if (paramw1.size() != paramw2.size())
    {
      AppMethodBeat.o(122799);
      return false;
    }
    localObject1 = ((an)localObject1).getParameters();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (ar)((List)localObject1).get(i);
      ap localap1 = (ap)paramw2.get(i);
      ap localap2 = (ap)paramw1.get(i);
      if (!localap1.eoN())
      {
        a(localap2, localap1, (ar)localObject2);
        if ((y.an(localap2.eer())) || (y.an(localap1.eer()))) {}
        for (int j = 1; (j == 0) && (((ar)localObject2).edG() == ba.CBX) && (localap2.eoO() == ba.CBX) && (localap1.eoO() == ba.CBX); j = 0)
        {
          if (this.CCM.a(localap2.eer(), localap1.eer(), this)) {
            break label363;
          }
          AppMethodBeat.o(122799);
          return false;
        }
        w localw1 = a((ar)localObject2, localap1);
        w localw2 = a((ar)localObject2, localap2);
        if (!this.CCM.b(localw2, localw1, this))
        {
          AppMethodBeat.o(122799);
          return false;
        }
        localw1 = b((ar)localObject2, localap1);
        localObject2 = b((ar)localObject2, localap2);
        if (localap1.eoO() != ba.CBZ)
        {
          if (!this.CCM.b(localw1, (w)localObject2, this))
          {
            AppMethodBeat.o(122799);
            return false;
          }
        }
        else if ((!$assertionsDisabled) && (!g.y(localw1)))
        {
          paramw1 = new AssertionError("In component must be Nothing for out-projection");
          AppMethodBeat.o(122799);
          throw paramw1;
        }
      }
      label363:
      i += 1;
    }
    AppMethodBeat.o(122799);
    return true;
  }
  
  public final boolean c(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122797);
    for (;;)
    {
      if (am.b(paramw1, paramw2))
      {
        if ((!paramw1.egH()) || (paramw2.egH()))
        {
          AppMethodBeat.o(122797);
          return true;
        }
        AppMethodBeat.o(122797);
        return false;
      }
      w localw1 = am.as(paramw1);
      w localw2 = am.at(paramw2);
      if ((localw1 == paramw1) && (localw2 == paramw2)) {
        break;
      }
      paramw2 = localw2;
      paramw1 = localw1;
    }
    boolean bool = g(paramw1, paramw2);
    AppMethodBeat.o(122797);
    return bool;
  }
  
  public final boolean d(w paramw1, w paramw2)
  {
    AppMethodBeat.i(122794);
    if (paramw1 == paramw2)
    {
      AppMethodBeat.o(122794);
      return true;
    }
    boolean bool;
    if (a.j.b.a.c.l.t.ai(paramw1))
    {
      if (a.j.b.a.c.l.t.ai(paramw2))
      {
        if ((!y.an(paramw1)) && (!y.an(paramw2)) && (c(paramw1, paramw2)) && (c(paramw2, paramw1)))
        {
          AppMethodBeat.o(122794);
          return true;
        }
        AppMethodBeat.o(122794);
        return false;
      }
      bool = f(paramw2, paramw1);
      AppMethodBeat.o(122794);
      return bool;
    }
    if (a.j.b.a.c.l.t.ai(paramw2))
    {
      bool = f(paramw1, paramw2);
      AppMethodBeat.o(122794);
      return bool;
    }
    if (paramw1.egH() != paramw2.egH())
    {
      AppMethodBeat.o(122794);
      return false;
    }
    if (paramw1.egH())
    {
      bool = this.CCM.a(av.aA(paramw1), av.aA(paramw2), this);
      AppMethodBeat.o(122794);
      return bool;
    }
    an localan1 = paramw1.enU();
    an localan2 = paramw2.enU();
    if (!this.CCM.b(localan1, localan2))
    {
      AppMethodBeat.o(122794);
      return false;
    }
    paramw1 = paramw1.enR();
    paramw2 = paramw2.enR();
    if (paramw1.size() != paramw2.size())
    {
      AppMethodBeat.o(122794);
      return false;
    }
    int i = 0;
    while (i < paramw1.size())
    {
      ap localap1 = (ap)paramw1.get(i);
      ap localap2 = (ap)paramw2.get(i);
      if ((!localap1.eoN()) || (!localap2.eoN()))
      {
        ar localar1 = (ar)localan1.getParameters().get(i);
        ar localar2 = (ar)localan2.getParameters().get(i);
        a(localap1, localap2, localar1);
        if (c(localar1, localap1) != c(localar2, localap2))
        {
          AppMethodBeat.o(122794);
          return false;
        }
        if (!this.CCM.a(localap1.eer(), localap2.eer(), this))
        {
          AppMethodBeat.o(122794);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(122794);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.l.a.q
 * JD-Core Version:    0.7.0.1
 */