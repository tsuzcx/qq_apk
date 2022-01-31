package a.j.b.a.c.d.a.a;

import a.a.ad;
import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.d.a.e.d;
import a.j.b.a.c.f.f;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;

public final class c
{
  private static final a.j.b.a.c.f.b CdJ;
  private static final a.j.b.a.c.f.b CdK;
  private static final a.j.b.a.c.f.b CdL;
  private static final a.j.b.a.c.f.b CdM;
  private static final a.j.b.a.c.f.b CdN;
  private static final f CdO;
  private static final f CdP;
  private static final f CdQ;
  private static final Map<a.j.b.a.c.f.b, a.j.b.a.c.f.b> CdR;
  private static final Map<a.j.b.a.c.f.b, a.j.b.a.c.f.b> CdS;
  public static final c CdT;
  
  static
  {
    AppMethodBeat.i(119758);
    CdT = new c();
    CdJ = new a.j.b.a.c.f.b(Target.class.getCanonicalName());
    CdK = new a.j.b.a.c.f.b(Retention.class.getCanonicalName());
    CdL = new a.j.b.a.c.f.b(Deprecated.class.getCanonicalName());
    CdM = new a.j.b.a.c.f.b(Documented.class.getCanonicalName());
    CdN = new a.j.b.a.c.f.b("java.lang.annotation.Repeatable");
    f localf = f.ayT("message");
    j.p(localf, "Name.identifier(\"message\")");
    CdO = localf;
    localf = f.ayT("allowedTargets");
    j.p(localf, "Name.identifier(\"allowedTargets\")");
    CdP = localf;
    localf = f.ayT("value");
    j.p(localf, "Name.identifier(\"value\")");
    CdQ = localf;
    CdR = ad.a(new o[] { u.F(g.BRU.BSE, CdJ), u.F(g.BRU.BSH, CdK), u.F(g.BRU.BSI, CdN), u.F(g.BRU.BSJ, CdM) });
    CdS = ad.a(new o[] { u.F(CdJ, g.BRU.BSE), u.F(CdK, g.BRU.BSH), u.F(CdL, g.BRU.BSy), u.F(CdN, g.BRU.BSI), u.F(CdM, g.BRU.BSJ) });
    AppMethodBeat.o(119758);
  }
  
  public static a.j.b.a.c.b.a.c a(a.j.b.a.c.d.a.e.a parama, a.j.b.a.c.d.a.c.h paramh)
  {
    AppMethodBeat.i(119756);
    j.q(parama, "annotation");
    j.q(paramh, "c");
    Object localObject = parama.ebx();
    if (j.e(localObject, a.j.b.a.c.f.a.n(CdJ)))
    {
      parama = (a.j.b.a.c.b.a.c)new i(parama, paramh);
      AppMethodBeat.o(119756);
      return parama;
    }
    if (j.e(localObject, a.j.b.a.c.f.a.n(CdK)))
    {
      parama = (a.j.b.a.c.b.a.c)new h(parama, paramh);
      AppMethodBeat.o(119756);
      return parama;
    }
    if (j.e(localObject, a.j.b.a.c.f.a.n(CdN)))
    {
      localObject = g.BRU.BSI;
      j.p(localObject, "KotlinBuiltIns.FQ_NAMES.repeatable");
      parama = (a.j.b.a.c.b.a.c)new b(paramh, parama, (a.j.b.a.c.f.b)localObject);
      AppMethodBeat.o(119756);
      return parama;
    }
    if (j.e(localObject, a.j.b.a.c.f.a.n(CdM)))
    {
      localObject = g.BRU.BSJ;
      j.p(localObject, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
      parama = (a.j.b.a.c.b.a.c)new b(paramh, parama, (a.j.b.a.c.f.b)localObject);
      AppMethodBeat.o(119756);
      return parama;
    }
    if (j.e(localObject, a.j.b.a.c.f.a.n(CdL)))
    {
      AppMethodBeat.o(119756);
      return null;
    }
    parama = (a.j.b.a.c.b.a.c)new a.j.b.a.c.d.a.c.a.e(paramh, parama);
    AppMethodBeat.o(119756);
    return parama;
  }
  
  public static a.j.b.a.c.b.a.c a(a.j.b.a.c.f.b paramb, d paramd, a.j.b.a.c.d.a.c.h paramh)
  {
    AppMethodBeat.i(119757);
    j.q(paramb, "kotlinName");
    j.q(paramd, "annotationOwner");
    j.q(paramh, "c");
    if (j.e(paramb, g.BRU.BSy))
    {
      a.j.b.a.c.d.a.e.a locala = paramd.m(CdL);
      if (locala != null)
      {
        paramb = (a.j.b.a.c.b.a.c)new e(locala, paramh);
        AppMethodBeat.o(119757);
        return paramb;
      }
    }
    paramb = (a.j.b.a.c.f.b)CdR.get(paramb);
    if (paramb != null)
    {
      paramb = paramd.m(paramb);
      if (paramb != null)
      {
        paramb = a(paramb, paramh);
        AppMethodBeat.o(119757);
        return paramb;
      }
      AppMethodBeat.o(119757);
      return null;
    }
    AppMethodBeat.o(119757);
    return null;
  }
  
  public static f efH()
  {
    return CdO;
  }
  
  public static f efI()
  {
    return CdP;
  }
  
  public static f efJ()
  {
    return CdQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.a.c
 * JD-Core Version:    0.7.0.1
 */