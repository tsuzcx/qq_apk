package a.j.b.a.c.i.c;

import a.aa;
import a.f.b.u.d;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.y;
import a.j.b.a.c.i.d;
import a.j.b.a.c.l.an;
import a.j.b.a.c.n.b.a;
import a.j.b.a.c.n.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public final class a
{
  private static final a.j.b.a.c.f.f CwK;
  
  static
  {
    AppMethodBeat.i(122153);
    a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT("value");
    a.f.b.j.p(localf, "Name.identifier(\"value\")");
    CwK = localf;
    AppMethodBeat.o(122153);
  }
  
  public static final Collection<e> A(e parame)
  {
    AppMethodBeat.i(122150);
    a.f.b.j.q(parame, "sealedClass");
    if (parame.ecC() != a.j.b.a.c.b.w.BWq)
    {
      parame = (Collection)a.a.v.BMx;
      AppMethodBeat.o(122150);
      return parame;
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a.a locala = new a.a(parame, localLinkedHashSet);
    l locall = parame.ecv();
    a.f.b.j.p(locall, "sealedClass.containingDeclaration");
    if ((locall instanceof ab)) {
      locala.a(((ab)locall).ecq(), false);
    }
    parame = parame.edJ();
    a.f.b.j.p(parame, "sealedClass.unsubstitutedInnerClassesScope");
    locala.a(parame, true);
    parame = (Collection)localLinkedHashSet;
    AppMethodBeat.o(122150);
    return parame;
  }
  
  public static final y F(l paraml)
  {
    AppMethodBeat.i(122140);
    a.f.b.j.q(paraml, "receiver$0");
    paraml = d.s(paraml);
    a.f.b.j.p(paraml, "DescriptorUtils.getContainingModule(this)");
    AppMethodBeat.o(122140);
    return paraml;
  }
  
  public static final g G(l paraml)
  {
    AppMethodBeat.i(122144);
    a.f.b.j.q(paraml, "receiver$0");
    paraml = F(paraml).eec();
    AppMethodBeat.o(122144);
    return paraml;
  }
  
  public static final a.k.h<l> H(l paraml)
  {
    AppMethodBeat.i(122146);
    a.f.b.j.q(paraml, "receiver$0");
    a.f.b.j.q(paraml, "receiver$0");
    paraml = a.k.i.a(paraml, (a.f.a.b)a.f.CwR);
    a.f.b.j.q(paraml, "receiver$0");
    if ((paraml instanceof a.k.c))
    {
      paraml = ((a.k.c)paraml).eph();
      AppMethodBeat.o(122146);
      return paraml;
    }
    paraml = (a.k.h)new a.k.b(paraml, 1);
    AppMethodBeat.o(122146);
    return paraml;
  }
  
  public static final a.j.b.a.c.f.b I(l paraml)
  {
    AppMethodBeat.i(122148);
    a.f.b.j.q(paraml, "receiver$0");
    paraml = q(paraml);
    if (paraml.eme()) {}
    while (paraml != null)
    {
      paraml = paraml.emf();
      AppMethodBeat.o(122148);
      return paraml;
      paraml = null;
    }
    AppMethodBeat.o(122148);
    return null;
  }
  
  public static final e b(y paramy, a.j.b.a.c.f.b paramb, a.j.b.a.c.c.a.a parama)
  {
    AppMethodBeat.i(122141);
    a.f.b.j.q(paramy, "receiver$0");
    a.f.b.j.q(paramb, "topLevelClassFqName");
    a.f.b.j.q(parama, "location");
    if (!paramb.isRoot()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramy = (Throwable)new AssertionError("Assertion failed");
      AppMethodBeat.o(122141);
      throw paramy;
    }
    a.j.b.a.c.f.b localb = paramb.emd();
    a.f.b.j.p(localb, "topLevelClassFqName.parent()");
    paramy = paramy.g(localb).ecq();
    paramb = paramb.CqE.emh();
    a.f.b.j.p(paramb, "topLevelClassFqName.shortName()");
    paramb = paramy.c(paramb, parama);
    paramy = paramb;
    if (!(paramb instanceof e)) {
      paramy = null;
    }
    paramy = (e)paramy;
    AppMethodBeat.o(122141);
    return paramy;
  }
  
  public static final boolean b(au paramau)
  {
    AppMethodBeat.i(122145);
    a.f.b.j.q(paramau, "receiver$0");
    paramau = a.j.b.a.c.n.b.a((Collection)a.a.j.listOf(paramau), (b.b)a.b.CwN, (a.f.a.b)a.c.CwO);
    a.f.b.j.p(paramau, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
    boolean bool = paramau.booleanValue();
    AppMethodBeat.o(122145);
    return bool;
  }
  
  public static final a.j.b.a.c.f.a c(a.j.b.a.c.b.h paramh)
  {
    AppMethodBeat.i(122142);
    if (paramh != null)
    {
      Object localObject = paramh.ecv();
      if (localObject != null)
      {
        if ((localObject instanceof ab))
        {
          paramh = new a.j.b.a.c.f.a(((ab)localObject).eee(), paramh.edF());
          AppMethodBeat.o(122142);
          return paramh;
        }
        if ((localObject instanceof a.j.b.a.c.b.i))
        {
          localObject = c((a.j.b.a.c.b.h)localObject);
          if (localObject != null)
          {
            paramh = ((a.j.b.a.c.f.a)localObject).p(paramh.edF());
            AppMethodBeat.o(122142);
            return paramh;
          }
        }
        AppMethodBeat.o(122142);
        return null;
      }
    }
    AppMethodBeat.o(122142);
    return null;
  }
  
  public static final e l(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(122151);
    a.f.b.j.q(paramc, "receiver$0");
    a.j.b.a.c.b.h localh = paramc.eer().enU().ecR();
    paramc = localh;
    if (!(localh instanceof e)) {
      paramc = null;
    }
    paramc = (e)paramc;
    AppMethodBeat.o(122151);
    return paramc;
  }
  
  public static final a.j.b.a.c.i.b.f<?> m(a.j.b.a.c.b.a.c paramc)
  {
    AppMethodBeat.i(122152);
    a.f.b.j.q(paramc, "receiver$0");
    paramc = (a.j.b.a.c.i.b.f)a.a.j.f((Iterable)paramc.eeG().values());
    AppMethodBeat.o(122152);
    return paramc;
  }
  
  public static final a.j.b.a.c.f.b o(l paraml)
  {
    AppMethodBeat.i(122139);
    a.f.b.j.q(paraml, "receiver$0");
    paraml = d.o(paraml);
    a.f.b.j.p(paraml, "DescriptorUtils.getFqNameSafe(this)");
    AppMethodBeat.o(122139);
    return paraml;
  }
  
  public static final a.j.b.a.c.f.c q(l paraml)
  {
    AppMethodBeat.i(122138);
    a.f.b.j.q(paraml, "receiver$0");
    paraml = d.n(paraml);
    a.f.b.j.p(paraml, "DescriptorUtils.getFqName(this)");
    AppMethodBeat.o(122138);
    return paraml;
  }
  
  public static final a.j.b.a.c.b.b x(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(122147);
    a.f.b.j.q(paramb, "receiver$0");
    if ((paramb instanceof ag))
    {
      paramb = ((ag)paramb).eeg();
      a.f.b.j.p(paramb, "correspondingProperty");
      paramb = (a.j.b.a.c.b.b)paramb;
      AppMethodBeat.o(122147);
      return paramb;
    }
    AppMethodBeat.o(122147);
    return paramb;
  }
  
  public static final e z(e parame)
  {
    AppMethodBeat.i(122143);
    a.f.b.j.q(parame, "receiver$0");
    parame = parame.edE().enU().eeO().iterator();
    while (parame.hasNext())
    {
      Object localObject = (a.j.b.a.c.l.w)parame.next();
      if (!g.A((a.j.b.a.c.l.w)localObject))
      {
        localObject = ((a.j.b.a.c.l.w)localObject).enU().ecR();
        if (d.B((l)localObject))
        {
          if (localObject == null)
          {
            parame = new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(122143);
            throw parame;
          }
          parame = (e)localObject;
          AppMethodBeat.o(122143);
          return parame;
        }
      }
    }
    AppMethodBeat.o(122143);
    return null;
  }
  
  static final class d<N>
    implements b.b<N>
  {}
  
  public static final class e
    extends b.a<a.j.b.a.c.b.b, a.j.b.a.c.b.b>
  {
    e(u.d paramd, a.f.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.i.c.a
 * JD-Core Version:    0.7.0.1
 */