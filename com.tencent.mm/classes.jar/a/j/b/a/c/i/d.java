package a.j.b.a.c.i;

import a.j.b.a.c.a.g;
import a.j.b.a.c.a.m;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ad;
import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.aj;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.aw;
import a.j.b.a.c.b.ay;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.o;
import a.j.b.a.c.l.av;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class d
{
  public static final a.j.b.a.c.f.f CvF;
  public static final a.j.b.a.c.f.f CvG;
  public static final a.j.b.a.c.f.b CvH;
  public static final a.j.b.a.c.f.b CvI;
  public static final a.j.b.a.c.f.b CvJ;
  public static final a.j.b.a.c.f.b CvK;
  public static final a.j.b.a.c.f.b CvL;
  public static final a.j.b.a.c.f.b CvM;
  public static final a.j.b.a.c.f.b CvN;
  
  static
  {
    AppMethodBeat.i(121975);
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      CvF = a.j.b.a.c.f.f.ayT("values");
      CvG = a.j.b.a.c.f.f.ayT("valueOf");
      a.j.b.a.c.f.b localb = new a.j.b.a.c.f.b("kotlin.coroutines");
      CvH = localb;
      localb = localb.q(a.j.b.a.c.f.f.ayT("experimental"));
      CvI = localb;
      CvJ = localb.q(a.j.b.a.c.f.f.ayT("intrinsics"));
      CvK = CvI.q(a.j.b.a.c.f.f.ayT("Continuation"));
      CvL = CvH.q(a.j.b.a.c.f.f.ayT("Continuation"));
      CvM = new a.j.b.a.c.f.b("kotlin.Result");
      CvN = new a.j.b.a.c.f.b("kotlin.jvm.JvmName");
      AppMethodBeat.o(121975);
      return;
    }
  }
  
  public static boolean A(l paraml)
  {
    AppMethodBeat.i(121961);
    boolean bool = a(paraml, a.j.b.a.c.b.f.BWg);
    AppMethodBeat.o(121961);
    return bool;
  }
  
  public static boolean B(l paraml)
  {
    AppMethodBeat.i(121962);
    if ((a(paraml, a.j.b.a.c.b.f.BWf)) || (a(paraml, a.j.b.a.c.b.f.BWh)))
    {
      AppMethodBeat.o(121962);
      return true;
    }
    AppMethodBeat.o(121962);
    return false;
  }
  
  public static a.j.b.a.c.b.an C(l paraml)
  {
    AppMethodBeat.i(121973);
    if ((paraml instanceof aj)) {
      paraml = ((aj)paraml).eeg();
    }
    for (;;)
    {
      if ((paraml instanceof o))
      {
        paraml = ((o)paraml).ecN().ebY();
        AppMethodBeat.o(121973);
        return paraml;
      }
      paraml = a.j.b.a.c.b.an.BWG;
      AppMethodBeat.o(121973);
      return paraml;
    }
  }
  
  public static a.j.b.a.c.b.y Y(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121948);
    paramw = paramw.enU().ecR();
    if (paramw == null)
    {
      AppMethodBeat.o(121948);
      return null;
    }
    paramw = t(paramw);
    AppMethodBeat.o(121948);
    return paramw;
  }
  
  public static e Z(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(156780);
    paramw = b(paramw.enU());
    AppMethodBeat.o(156780);
    return paramw;
  }
  
  public static <D extends l> D a(l paraml, Class<D> paramClass)
  {
    AppMethodBeat.i(121946);
    paraml = a(paraml, paramClass, true);
    AppMethodBeat.o(121946);
    return paraml;
  }
  
  public static <D extends l> D a(l paraml, Class<D> paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(121947);
    if (paraml == null)
    {
      AppMethodBeat.o(121947);
      return null;
    }
    if (paramBoolean) {
      paraml = paraml.ecv();
    }
    for (;;)
    {
      if (paraml != null)
      {
        if (paramClass.isInstance(paraml))
        {
          AppMethodBeat.o(121947);
          return paraml;
        }
        paraml = paraml.ecv();
      }
      else
      {
        AppMethodBeat.o(121947);
        return null;
      }
    }
  }
  
  public static <D extends a.j.b.a.c.b.p> D a(D paramD)
  {
    AppMethodBeat.i(121969);
    if ((paramD instanceof a.j.b.a.c.b.b))
    {
      paramD = u((a.j.b.a.c.b.b)paramD);
      AppMethodBeat.o(121969);
      return paramD;
    }
    AppMethodBeat.o(121969);
    return paramD;
  }
  
  private static <D extends a.j.b.a.c.b.a> void a(D paramD, Set<D> paramSet)
  {
    AppMethodBeat.i(121972);
    if (paramSet.contains(paramD))
    {
      AppMethodBeat.o(121972);
      return;
    }
    paramD = paramD.edt().edw().iterator();
    while (paramD.hasNext())
    {
      a.j.b.a.c.b.a locala = ((a.j.b.a.c.b.a)paramD.next()).edt();
      a(locala, paramSet);
      paramSet.add(locala);
    }
    AppMethodBeat.o(121972);
  }
  
  public static boolean a(aw paramaw, a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(121970);
    if ((paramaw.eey()) || (a.j.b.a.c.l.y.an(paramw)))
    {
      AppMethodBeat.o(121970);
      return false;
    }
    if (av.aC(paramw))
    {
      AppMethodBeat.o(121970);
      return true;
    }
    paramaw = a.j.b.a.c.i.c.a.G(paramaw);
    if ((!g.p(paramw)) && (!a.j.b.a.c.l.a.c.CCi.d(paramaw.eco(), paramw)) && (!a.j.b.a.c.l.a.c.CCi.d(paramaw.ayx("Number").edE(), paramw)) && (!a.j.b.a.c.l.a.c.CCi.d(paramaw.ecl(), paramw)))
    {
      paramaw = m.BUu;
      if (!m.G(paramw)) {}
    }
    else
    {
      AppMethodBeat.o(121970);
      return true;
    }
    AppMethodBeat.o(121970);
    return false;
  }
  
  private static boolean a(l paraml, a.j.b.a.c.b.f paramf)
  {
    AppMethodBeat.i(121963);
    if (((paraml instanceof e)) && (((e)paraml).ecB() == paramf))
    {
      AppMethodBeat.o(121963);
      return true;
    }
    AppMethodBeat.o(121963);
    return false;
  }
  
  private static boolean a(a.j.b.a.c.l.w paramw, l paraml)
  {
    AppMethodBeat.i(121953);
    paramw = paramw.enU().ecR();
    if (paramw != null)
    {
      paramw = paramw.edC();
      if (((paramw instanceof a.j.b.a.c.b.h)) && ((paraml instanceof a.j.b.a.c.b.h)) && (((a.j.b.a.c.b.h)paraml).ecx().equals(((a.j.b.a.c.b.h)paramw).ecx())))
      {
        AppMethodBeat.o(121953);
        return true;
      }
    }
    AppMethodBeat.o(121953);
    return false;
  }
  
  private static e b(a.j.b.a.c.l.an paraman)
  {
    AppMethodBeat.i(121966);
    a.j.b.a.c.b.h localh = paraman.ecR();
    if ((!$assertionsDisabled) && (!(localh instanceof e)))
    {
      paraman = new AssertionError("Classifier descriptor of a type should be of type ClassDescriptor: ".concat(String.valueOf(paraman)));
      AppMethodBeat.o(121966);
      throw paraman;
    }
    paraman = (e)localh;
    AppMethodBeat.o(121966);
    return paraman;
  }
  
  public static boolean b(e parame1, e parame2)
  {
    AppMethodBeat.i(121951);
    parame1 = parame1.ecx().eeO().iterator();
    while (parame1.hasNext()) {
      if (a((a.j.b.a.c.l.w)parame1.next(), parame2.edL()))
      {
        AppMethodBeat.o(121951);
        return true;
      }
    }
    AppMethodBeat.o(121951);
    return false;
  }
  
  public static boolean b(a.j.b.a.c.l.w paramw, l paraml)
  {
    AppMethodBeat.i(121954);
    if (a(paramw, paraml))
    {
      AppMethodBeat.o(121954);
      return true;
    }
    paramw = paramw.enU().eeO().iterator();
    while (paramw.hasNext()) {
      if (b((a.j.b.a.c.l.w)paramw.next(), paraml))
      {
        AppMethodBeat.o(121954);
        return true;
      }
    }
    AppMethodBeat.o(121954);
    return false;
  }
  
  public static boolean c(e parame1, e parame2)
  {
    AppMethodBeat.i(121952);
    boolean bool = b(parame1.edE(), parame2.edL());
    AppMethodBeat.o(121952);
    return bool;
  }
  
  public static <D extends a.j.b.a.c.b.a> Set<D> d(D paramD)
  {
    AppMethodBeat.i(121971);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(paramD.edt(), localLinkedHashSet);
    AppMethodBeat.o(121971);
    return localLinkedHashSet;
  }
  
  public static boolean e(l paraml1, l paraml2)
  {
    AppMethodBeat.i(121945);
    boolean bool = s(paraml1).equals(s(paraml2));
    AppMethodBeat.o(121945);
    return bool;
  }
  
  public static ak l(l paraml)
  {
    AppMethodBeat.i(121938);
    if ((paraml instanceof e))
    {
      paraml = ((e)paraml).edK();
      AppMethodBeat.o(121938);
      return paraml;
    }
    AppMethodBeat.o(121938);
    return null;
  }
  
  public static boolean m(l paraml)
  {
    AppMethodBeat.i(121939);
    while (paraml != null)
    {
      if (!w(paraml)) {
        if ((!(paraml instanceof a.j.b.a.c.b.p)) || (((a.j.b.a.c.b.p)paraml).ecE() != ay.BWP)) {
          break label53;
        }
      }
      label53:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(121939);
        return true;
      }
      paraml = paraml.ecv();
    }
    AppMethodBeat.o(121939);
    return false;
  }
  
  public static a.j.b.a.c.f.c n(l paraml)
  {
    AppMethodBeat.i(121940);
    a.j.b.a.c.f.b localb = p(paraml);
    if (localb != null)
    {
      paraml = localb.CqE;
      AppMethodBeat.o(121940);
      return paraml;
    }
    paraml = q(paraml);
    AppMethodBeat.o(121940);
    return paraml;
  }
  
  public static a.j.b.a.c.f.b o(l paraml)
  {
    AppMethodBeat.i(121941);
    a.j.b.a.c.f.b localb = p(paraml);
    if (localb != null)
    {
      AppMethodBeat.o(121941);
      return localb;
    }
    paraml = q(paraml).emf();
    AppMethodBeat.o(121941);
    return paraml;
  }
  
  private static a.j.b.a.c.f.b p(l paraml)
  {
    AppMethodBeat.i(121942);
    if (((paraml instanceof a.j.b.a.c.b.y)) || (a.j.b.a.c.l.p.L(paraml)))
    {
      paraml = a.j.b.a.c.f.b.CqD;
      AppMethodBeat.o(121942);
      return paraml;
    }
    if ((paraml instanceof ad))
    {
      paraml = ((ad)paraml).eee();
      AppMethodBeat.o(121942);
      return paraml;
    }
    if ((paraml instanceof ab))
    {
      paraml = ((ab)paraml).eee();
      AppMethodBeat.o(121942);
      return paraml;
    }
    AppMethodBeat.o(121942);
    return null;
  }
  
  private static a.j.b.a.c.f.c q(l paraml)
  {
    AppMethodBeat.i(121943);
    l locall = paraml.ecv();
    if ((!$assertionsDisabled) && (locall == null))
    {
      paraml = new AssertionError("Not package/module descriptor doesn't have containing declaration: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(121943);
      throw paraml;
    }
    paraml = n(locall).t(paraml.edF());
    AppMethodBeat.o(121943);
    return paraml;
  }
  
  public static boolean r(l paraml)
  {
    AppMethodBeat.i(121944);
    if ((paraml != null) && ((paraml.ecv() instanceof ab)))
    {
      AppMethodBeat.o(121944);
      return true;
    }
    AppMethodBeat.o(121944);
    return false;
  }
  
  public static a.j.b.a.c.b.y s(l paraml)
  {
    AppMethodBeat.i(121949);
    a.j.b.a.c.b.y localy = t(paraml);
    if ((!$assertionsDisabled) && (localy == null))
    {
      paraml = new AssertionError("Descriptor without a containing module: ".concat(String.valueOf(paraml)));
      AppMethodBeat.o(121949);
      throw paraml;
    }
    AppMethodBeat.o(121949);
    return localy;
  }
  
  private static a.j.b.a.c.b.y t(l paraml)
  {
    AppMethodBeat.i(121950);
    while (paraml != null)
    {
      if ((paraml instanceof a.j.b.a.c.b.y))
      {
        paraml = (a.j.b.a.c.b.y)paraml;
        AppMethodBeat.o(121950);
        return paraml;
      }
      if ((paraml instanceof ad))
      {
        paraml = ((ad)paraml).eef();
        AppMethodBeat.o(121950);
        return paraml;
      }
      paraml = paraml.ecv();
    }
    AppMethodBeat.o(121950);
    return null;
  }
  
  public static <D extends a.j.b.a.c.b.b> D u(D paramD)
  {
    AppMethodBeat.i(121968);
    while (paramD.edy() == b.a.BVY)
    {
      Collection localCollection = paramD.edw();
      if (localCollection.isEmpty())
      {
        paramD = new IllegalStateException("Fake override should have at least one overridden descriptor: ".concat(String.valueOf(paramD)));
        AppMethodBeat.o(121968);
        throw paramD;
      }
      paramD = (a.j.b.a.c.b.b)localCollection.iterator().next();
    }
    AppMethodBeat.o(121968);
    return paramD;
  }
  
  public static boolean u(l paraml)
  {
    AppMethodBeat.i(121955);
    if ((a(paraml, a.j.b.a.c.b.f.BWk)) && (((e)paraml).ecF()))
    {
      AppMethodBeat.o(121955);
      return true;
    }
    AppMethodBeat.o(121955);
    return false;
  }
  
  public static a.j.b.a.c.b.b v(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(121974);
    if ((paramb instanceof ag))
    {
      paramb = ((ag)paramb).eeg();
      AppMethodBeat.o(121974);
      return paramb;
    }
    AppMethodBeat.o(121974);
    return paramb;
  }
  
  public static boolean v(l paraml)
  {
    AppMethodBeat.i(121956);
    if ((a(paraml, a.j.b.a.c.b.f.BWf)) && (((e)paraml).ecC() == a.j.b.a.c.b.w.BWq))
    {
      AppMethodBeat.o(121956);
      return true;
    }
    AppMethodBeat.o(121956);
    return false;
  }
  
  private static boolean w(l paraml)
  {
    AppMethodBeat.i(121957);
    if ((a(paraml, a.j.b.a.c.b.f.BWf)) && (paraml.edF().equals(a.j.b.a.c.f.h.CqQ)))
    {
      AppMethodBeat.o(121957);
      return true;
    }
    AppMethodBeat.o(121957);
    return false;
  }
  
  public static e x(e parame)
  {
    AppMethodBeat.i(121964);
    parame = parame.ecx().eeO().iterator();
    while (parame.hasNext())
    {
      e locale = b(((a.j.b.a.c.l.w)parame.next()).enU());
      if (locale.ecB() != a.j.b.a.c.b.f.BWg)
      {
        AppMethodBeat.o(121964);
        return locale;
      }
    }
    AppMethodBeat.o(121964);
    return null;
  }
  
  public static boolean x(l paraml)
  {
    AppMethodBeat.i(121958);
    boolean bool = a(paraml, a.j.b.a.c.b.f.BWi);
    AppMethodBeat.o(121958);
    return bool;
  }
  
  public static az y(e parame)
  {
    AppMethodBeat.i(121967);
    a.j.b.a.c.b.f localf = parame.ecB();
    if ((localf == a.j.b.a.c.b.f.BWh) || (localf.edM()) || (v(parame)))
    {
      parame = ay.BWK;
      AppMethodBeat.o(121967);
      return parame;
    }
    if (w(parame))
    {
      parame = ay.BWV;
      AppMethodBeat.o(121967);
      return parame;
    }
    if ((!$assertionsDisabled) && (localf != a.j.b.a.c.b.f.BWf) && (localf != a.j.b.a.c.b.f.BWg) && (localf != a.j.b.a.c.b.f.BWj))
    {
      parame = new AssertionError();
      AppMethodBeat.o(121967);
      throw parame;
    }
    parame = ay.BWO;
    AppMethodBeat.o(121967);
    return parame;
  }
  
  public static boolean y(l paraml)
  {
    AppMethodBeat.i(121959);
    boolean bool = a(paraml, a.j.b.a.c.b.f.BWh);
    AppMethodBeat.o(121959);
    return bool;
  }
  
  public static boolean z(l paraml)
  {
    AppMethodBeat.i(121960);
    boolean bool = a(paraml, a.j.b.a.c.b.f.BWj);
    AppMethodBeat.o(121960);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.i.d
 * JD-Core Version:    0.7.0.1
 */