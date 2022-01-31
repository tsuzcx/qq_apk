package a.j.b.a.c.a;

import a.aa;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.c.ah;
import a.j.b.a.c.b.c.m;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.c;
import a.j.b.a.c.i.d;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.c.a;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class k
{
  private static final a.j.b.a.c.b.c.w BUh;
  private static final a.j.b.a.c.b.c.w BUi;
  
  static
  {
    AppMethodBeat.i(119114);
    Object localObject1 = p.eoH();
    a.f.b.j.p(localObject1, "ErrorUtils.getErrorModule()");
    Object localObject2 = d.CvI;
    a.f.b.j.p(localObject2, "DescriptorUtils.COROUTIN…KAGE_FQ_NAME_EXPERIMENTAL");
    localObject1 = new a.j.b.a.c.b.c.w((l)new m((y)localObject1, (a.j.b.a.c.f.b)localObject2), a.j.b.a.c.b.f.BWg, d.CvK.CqE.emh(), am.BWF, a.j.b.a.c.k.b.CAv);
    ((a.j.b.a.c.b.c.w)localObject1).b(a.j.b.a.c.b.w.BWs);
    ((a.j.b.a.c.b.c.w)localObject1).BZE = ay.BWO;
    localObject2 = (l)localObject1;
    g.a locala = a.j.b.a.c.b.a.g.BXx;
    ((a.j.b.a.c.b.c.w)localObject1).gc(a.a.j.listOf(ah.a((l)localObject2, g.a.eeH(), ba.CBY, a.j.b.a.c.f.f.ayT("T"), 0)));
    ((a.j.b.a.c.b.c.w)localObject1).efe();
    BUh = (a.j.b.a.c.b.c.w)localObject1;
    localObject1 = p.eoH();
    a.f.b.j.p(localObject1, "ErrorUtils.getErrorModule()");
    localObject2 = d.CvH;
    a.f.b.j.p(localObject2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE");
    localObject1 = new a.j.b.a.c.b.c.w((l)new m((y)localObject1, (a.j.b.a.c.f.b)localObject2), a.j.b.a.c.b.f.BWg, d.CvL.CqE.emh(), am.BWF, a.j.b.a.c.k.b.CAv);
    ((a.j.b.a.c.b.c.w)localObject1).b(a.j.b.a.c.b.w.BWs);
    ((a.j.b.a.c.b.c.w)localObject1).BZE = ay.BWO;
    localObject2 = (l)localObject1;
    locala = a.j.b.a.c.b.a.g.BXx;
    ((a.j.b.a.c.b.c.w)localObject1).gc(a.a.j.listOf(ah.a((l)localObject2, g.a.eeH(), ba.CBY, a.j.b.a.c.f.f.ayT("T"), 0)));
    ((a.j.b.a.c.b.c.w)localObject1).efe();
    BUi = (a.j.b.a.c.b.c.w)localObject1;
    AppMethodBeat.o(119114);
  }
  
  public static final ad F(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(119112);
    a.f.b.j.q(paramw, "suspendFunType");
    boolean bool = f.e(paramw);
    if ((aa.BMh) && (!bool))
    {
      paramw = (Throwable)new AssertionError("This type should be suspend function type: ".concat(String.valueOf(paramw)));
      AppMethodBeat.o(119112);
      throw paramw;
    }
    g localg = a.aL(paramw);
    a.j.b.a.c.b.a.g localg1 = paramw.ecM();
    a.j.b.a.c.l.w localw = f.h(paramw);
    Object localObject2 = (Iterable)f.j(paramw);
    Object localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ap)((Iterator)localObject2).next()).eer());
    }
    localObject1 = (Collection)localObject1;
    localObject2 = a.j.b.a.c.b.a.g.BXx;
    localObject2 = g.a.eeH();
    an localan = BUh.ecx();
    a.f.b.j.p(localan, "if (isReleaseCoroutines)…ERIMENTAL.typeConstructor");
    localObject1 = a.a.j.a((Collection)localObject1, x.c((a.j.b.a.c.b.a.g)localObject2, localan, a.a.j.listOf(a.aM(f.i(paramw))), false));
    localObject2 = a.aL(paramw).ecm();
    a.f.b.j.p(localObject2, "suspendFunType.builtIns.nullableAnyType");
    paramw = f.a(localg, localg1, localw, (List)localObject1, (a.j.b.a.c.l.w)localObject2).ss(paramw.egH());
    AppMethodBeat.o(119112);
    return paramw;
  }
  
  public static final boolean a(a.j.b.a.c.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(119113);
    if (paramBoolean)
    {
      paramBoolean = a.f.b.j.e(paramb, d.CvL);
      AppMethodBeat.o(119113);
      return paramBoolean;
    }
    paramBoolean = a.f.b.j.e(paramb, d.CvK);
    AppMethodBeat.o(119113);
    return paramBoolean;
  }
  
  public static final a.j.b.a.c.b.c.w ect()
  {
    return BUh;
  }
  
  public static final a.j.b.a.c.b.c.w ecu()
  {
    return BUi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.a.k
 * JD-Core Version:    0.7.0.1
 */