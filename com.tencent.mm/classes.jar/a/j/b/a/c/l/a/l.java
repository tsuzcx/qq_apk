package a.j.b.a.c.l.a;

import a.aa;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ag;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.t;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class l
{
  public static final l CCr;
  
  static
  {
    AppMethodBeat.i(122758);
    CCr = new l();
    AppMethodBeat.o(122758);
  }
  
  private static boolean a(o paramo, ad paramad, o.c paramc)
  {
    AppMethodBeat.i(122756);
    if (((j.c(paramad)) && (!paramad.egH())) || (ag.ap((w)paramad))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122756);
      return true;
    }
    paramo.initialize();
    ArrayDeque localArrayDeque = paramo.CCw;
    if (localArrayDeque == null) {
      a.f.b.j.ebi();
    }
    Set localSet = paramo.CCx;
    if (localSet == null) {
      a.f.b.j.ebi();
    }
    localArrayDeque.push(paramad);
    label228:
    label241:
    label371:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label373;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramo = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramad + ". Supertypes = " + a.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(122756);
        throw paramo;
      }
      Object localObject1 = (ad)localArrayDeque.pop();
      a.f.b.j.p(localObject1, "current");
      if (localSet.add(localObject1))
      {
        o.c localc;
        if (((ad)localObject1).egH())
        {
          localc = (o.c)o.c.c.CCK;
          if (!(a.f.b.j.e(localc, o.c.c.CCK) ^ true)) {
            break label351;
          }
          if (localc == null) {
            break label355;
          }
          localObject1 = ((ad)localObject1).enU().eeO().iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label371;
          }
          Object localObject2 = (w)((Iterator)localObject1).next();
          a.f.b.j.p(localObject2, "supertype");
          localObject2 = localc.aJ((w)localObject2);
          if (((j.c((ad)localObject2)) && (!((ad)localObject2).egH())) || (ag.ap((w)localObject2))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label362;
            }
            paramo.clear();
            AppMethodBeat.o(122756);
            return true;
            localc = paramc;
            break label228;
            localc = null;
            break label241;
            break;
          }
          localArrayDeque.add(localObject2);
        }
      }
    }
    label351:
    label355:
    label362:
    label373:
    paramo.clear();
    AppMethodBeat.o(122756);
    return false;
  }
  
  public static boolean c(o paramo, ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(122754);
    a.f.b.j.q(paramo, "context");
    a.f.b.j.q(paramad1, "subType");
    a.f.b.j.q(paramad2, "superType");
    if ((j.e(paramad1)) || (j.d(paramad1)) || (paramo.e((az)paramad1))) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramo = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(paramad2)));
      AppMethodBeat.o(122754);
      throw paramo;
    }
    if ((j.d(paramad2)) || (paramo.e((az)paramad2))) {}
    for (i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramo = (Throwable)new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(paramad2)));
      AppMethodBeat.o(122754);
      throw paramo;
    }
    if (paramad2.egH())
    {
      AppMethodBeat.o(122754);
      return true;
    }
    if (ag.ap((w)paramad1))
    {
      AppMethodBeat.o(122754);
      return true;
    }
    if (a(paramo, paramad1, (o.c)o.c.a.CCJ))
    {
      AppMethodBeat.o(122754);
      return true;
    }
    if (ag.ap((w)paramad2))
    {
      AppMethodBeat.o(122754);
      return false;
    }
    if (a(paramo, paramad2, (o.c)o.c.d.CCL))
    {
      AppMethodBeat.o(122754);
      return false;
    }
    if (j.c(paramad1))
    {
      AppMethodBeat.o(122754);
      return false;
    }
    boolean bool = d(paramo, paramad1, paramad2.enU());
    AppMethodBeat.o(122754);
    return bool;
  }
  
  private static boolean d(o paramo, ad paramad, an paraman)
  {
    AppMethodBeat.i(122757);
    if ((!paramad.egH()) && (a.f.b.j.e(paramad.enU(), paraman))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122757);
      return true;
    }
    paramo.initialize();
    ArrayDeque localArrayDeque = paramo.CCw;
    if (localArrayDeque == null) {
      a.f.b.j.ebi();
    }
    Set localSet = paramo.CCx;
    if (localSet == null) {
      a.f.b.j.ebi();
    }
    localArrayDeque.push(paramad);
    label222:
    label354:
    label363:
    for (;;)
    {
      if (!((Collection)localArrayDeque).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label365;
        }
        if (localSet.size() <= 1000) {
          break;
        }
        paramo = (Throwable)new IllegalStateException(("Too many supertypes for type: " + paramad + ". Supertypes = " + a.a.j.a((Iterable)localSet, null, null, null, 0, null, null, 63)).toString());
        AppMethodBeat.o(122757);
        throw paramo;
      }
      Object localObject1 = (ad)localArrayDeque.pop();
      a.f.b.j.p(localObject1, "current");
      if (localSet.add(localObject1))
      {
        o.c localc;
        if (((ad)localObject1).egH())
        {
          localc = (o.c)o.c.c.CCK;
          if (!(a.f.b.j.e(localc, o.c.c.CCK) ^ true)) {
            break label343;
          }
          label235:
          if (localc == null) {
            break label347;
          }
          localObject1 = ((ad)localObject1).enU().eeO().iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label363;
          }
          Object localObject2 = (w)((Iterator)localObject1).next();
          a.f.b.j.p(localObject2, "supertype");
          localObject2 = localc.aJ((w)localObject2);
          if ((!((ad)localObject2).egH()) && (a.f.b.j.e(((ad)localObject2).enU(), paraman))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label354;
            }
            paramo.clear();
            AppMethodBeat.o(122757);
            return true;
            localc = (o.c)o.c.a.CCJ;
            break label222;
            localc = null;
            break label235;
            break;
          }
          localArrayDeque.add(localObject2);
        }
      }
    }
    label343:
    label347:
    label365:
    paramo.clear();
    AppMethodBeat.o(122757);
    return false;
  }
  
  public static boolean d(az paramaz)
  {
    AppMethodBeat.i(122755);
    a.f.b.j.q(paramaz, "type");
    boolean bool = a(new o(false, (byte)0), t.ak((w)paramaz), (o.c)o.c.a.CCJ);
    AppMethodBeat.o(122755);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.a.l
 * JD-Core Version:    0.7.0.1
 */