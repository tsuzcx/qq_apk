package a.j.b.a.c.j.a;

import a.a.ad;
import a.j.b.a.c.b.aa;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.y;
import a.j.b.a.c.e.a.a;
import a.j.b.a.c.e.a.a.a;
import a.j.b.a.c.e.a.a.a.b;
import a.j.b.a.c.e.a.b;
import a.j.b.a.c.e.a.b.a;
import a.j.b.a.c.i.b.i;
import a.j.b.a.c.i.b.j.a;
import a.j.b.a.c.i.b.k;
import a.j.b.a.c.i.b.t;
import a.j.b.a.c.i.b.u;
import a.j.b.a.c.i.b.v;
import a.j.b.a.c.l.ar;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  private final aa BUa;
  private final y BUv;
  
  public c(y paramy, aa paramaa)
  {
    AppMethodBeat.i(122247);
    this.BUv = paramy;
    this.BUa = paramaa;
    AppMethodBeat.o(122247);
  }
  
  private a.j.b.a.c.i.b.f<?> a(a.j.b.a.c.l.w paramw, a.a.a.b paramb, a.j.b.a.c.e.a.c paramc)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(122245);
    a.f.b.j.q(paramw, "expectedType");
    a.f.b.j.q(paramb, "value");
    a.f.b.j.q(paramc, "nameResolver");
    Object localObject1 = b.CoR.Vo(paramb.CkK);
    a.f.b.j.p(localObject1, "Flags.IS_UNSIGNED.get(value.flags)");
    boolean bool = ((Boolean)localObject1).booleanValue();
    localObject1 = paramb.CkA;
    if (localObject1 == null) {}
    for (;;)
    {
      paramw = (Throwable)new IllegalStateException(("Unsupported annotation argument type: " + paramb.CkA + " (expected " + paramw + ')').toString());
      AppMethodBeat.o(122245);
      throw paramw;
      switch (d.bLo[localObject1.ordinal()])
      {
      }
    }
    byte b = (byte)(int)paramb.CkB;
    if (bool)
    {
      paramc = new t(b);
      paramc = (a.j.b.a.c.i.b.f)paramc;
    }
    for (;;)
    {
      if (!a.j.b.a.c.l.c.a.c(paramc.b(this.BUv), paramw)) {
        break label1506;
      }
      AppMethodBeat.o(122245);
      return paramc;
      paramc = new a.j.b.a.c.i.b.d(b);
      break;
      paramc = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.e((char)(int)paramb.CkB);
      continue;
      short s = (short)(int)paramb.CkB;
      if (bool) {}
      for (paramc = new a.j.b.a.c.i.b.w(s);; paramc = new a.j.b.a.c.i.b.r(s))
      {
        paramc = (a.j.b.a.c.i.b.f)paramc;
        break;
      }
      i = (int)paramb.CkB;
      if (bool) {}
      for (paramc = new u(i);; paramc = new a.j.b.a.c.i.b.l(i))
      {
        paramc = (a.j.b.a.c.i.b.f)paramc;
        break;
      }
      long l = paramb.CkB;
      if (bool) {}
      for (paramc = new v(l);; paramc = new a.j.b.a.c.i.b.p(l))
      {
        paramc = (a.j.b.a.c.i.b.f)paramc;
        break;
      }
      paramc = (a.j.b.a.c.i.b.f)new k(paramb.CkC);
      continue;
      paramc = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.h(paramb.CkD);
      continue;
      if (paramb.CkB != 0L) {}
      for (bool = true;; bool = false)
      {
        paramc = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.c(bool);
        break;
      }
      paramc = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.s(paramc.getString(paramb.CkE));
      continue;
      paramc = r.a(paramc, paramb.CkF);
      j = paramb.CkJ;
      paramc = f(paramc).edE();
      a.f.b.j.p(paramc, "resolveClass(classId).defaultType");
      paramc = a.j.b.a.c.l.c.a.aN((a.j.b.a.c.l.w)paramc);
      while (i < j)
      {
        paramc = eec().a(ba.CBX, paramc);
        a.f.b.j.p(paramc, "builtIns.getArrayType(Variance.INVARIANT, type)");
        paramc = (a.j.b.a.c.l.w)paramc;
        i += 1;
      }
      localObject1 = a.j.b.a.c.f.a.n(a.j.b.a.c.a.g.BRU.BTc.emf());
      a.f.b.j.p(localObject1, "ClassId.topLevel(KotlinB…FQ_NAMES.kClass.toSafe())");
      localObject1 = f((a.j.b.a.c.f.a)localObject1);
      Object localObject2 = a.j.b.a.c.b.a.g.BXx;
      paramc = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.o((a.j.b.a.c.l.w)x.a(a.j.b.a.c.b.a.g.a.eeH(), (a.j.b.a.c.b.e)localObject1, a.a.j.listOf(new ar(paramc))));
      continue;
      paramc = (a.j.b.a.c.i.b.f)new i(r.a(paramc, paramb.CkF), r.b(paramc, paramb.CkG));
      continue;
      localObject1 = paramb.CkH;
      a.f.b.j.p(localObject1, "value.annotation");
      paramc = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.a(b((a.a)localObject1, paramc));
      continue;
      Object localObject3;
      label764:
      Object localObject4;
      if ((a.j.b.a.c.a.g.n(paramw)) || (a.j.b.a.c.a.g.o(paramw)))
      {
        i = 1;
        localObject3 = paramb.CkI;
        a.f.b.j.p(localObject3, "arrayElements");
        if (((Collection)localObject3).isEmpty()) {
          break label857;
        }
        if (j == 0) {
          break label1431;
        }
        localObject1 = a.a.j.fQ((List)localObject3);
        a.f.b.j.p(localObject1, "arrayElements.first()");
        localObject1 = (a.a.a.b)localObject1;
        localObject2 = eec();
        localObject4 = ((a.a.a.b)localObject1).CkA;
        if (localObject4 != null) {
          break label863;
        }
      }
      for (;;)
      {
        paramw = (Throwable)new IllegalStateException(("Unknown type: " + ((a.a.a.b)localObject1).CkA).toString());
        AppMethodBeat.o(122245);
        throw paramw;
        i = 0;
        break;
        label857:
        j = 0;
        break label764;
        label863:
        switch (d.pRV[localObject4.ordinal()])
        {
        }
      }
      localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTG);
      a.f.b.j.p(localObject1, "byteType");
      localObject2 = eec().m((a.j.b.a.c.l.w)localObject1);
      if (localObject2 != null)
      {
        localObject1 = (a.j.b.a.c.l.w)localObject2;
        label987:
        localObject4 = eec();
        if (i == 0) {
          break label1482;
        }
      }
      label1431:
      label1482:
      for (localObject2 = paramw;; localObject2 = localObject1)
      {
        localObject2 = ((a.j.b.a.c.a.g)localObject4).l((a.j.b.a.c.l.w)localObject2);
        a.f.b.j.p(localObject2, "builtIns.getArrayElement…ype else actualArrayType)");
        localObject4 = a.j.b.a.c.i.b.g.CwD;
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          a.a.a.b localb = (a.a.a.b)((Iterator)localObject4).next();
          a.f.b.j.p(localb, "it");
          ((Collection)localObject3).add(a((a.j.b.a.c.l.w)localObject2, localb, paramc));
        }
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTF);
        a.f.b.j.p(localObject1, "charType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTH);
        a.f.b.j.p(localObject1, "shortType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTI);
        a.f.b.j.p(localObject1, "intType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTK);
        a.f.b.j.p(localObject1, "longType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTJ);
        a.f.b.j.p(localObject1, "floatType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTL);
        a.f.b.j.p(localObject1, "doubleType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).a(a.j.b.a.c.a.h.BTE);
        a.f.b.j.p(localObject1, "booleanType");
        break;
        localObject1 = ((a.j.b.a.c.a.g)localObject2).eco();
        a.f.b.j.p(localObject1, "stringType");
        break;
        paramw = (Throwable)new IllegalStateException("Arrays of class literals are not supported yet".toString());
        AppMethodBeat.o(122245);
        throw paramw;
        localObject1 = f(r.a(paramc, ((a.a.a.b)localObject1).CkF)).edE();
        a.f.b.j.p(localObject1, "resolveClass(nameResolve…lue.classId)).defaultType");
        break;
        localObject1 = ((a.a.a.b)localObject1).CkH;
        a.f.b.j.p(localObject1, "value.annotation");
        localObject1 = f(r.a(paramc, ((a.a)localObject1).Cks)).edE();
        a.f.b.j.p(localObject1, "resolveClass(nameResolve…notation.id)).defaultType");
        break;
        paramw = (Throwable)new IllegalStateException("Array of arrays is impossible".toString());
        AppMethodBeat.o(122245);
        throw paramw;
        localObject1 = eec().a(ba.CBX, (a.j.b.a.c.l.w)localObject1);
        a.f.b.j.p(localObject1, "builtIns.getArrayType(Va…RIANT, actualElementType)");
        localObject1 = (a.j.b.a.c.l.w)localObject1;
        break label987;
        if (i != 0)
        {
          localObject1 = paramw;
          break label987;
        }
        localObject1 = eec().a(ba.CBX, (a.j.b.a.c.l.w)eec().ecl());
        a.f.b.j.p(localObject1, "builtIns.getArrayType(Va…ARIANT, builtIns.anyType)");
        localObject1 = (a.j.b.a.c.l.w)localObject1;
        break label987;
      }
      paramc = (a.j.b.a.c.i.b.f)a.j.b.a.c.i.b.g.a((List)localObject3, (a.j.b.a.c.l.w)localObject1);
    }
    label1506:
    localObject1 = a.j.b.a.c.i.b.j.CwI;
    paramw = (a.j.b.a.c.i.b.f)j.a.aze("Unexpected argument value: type " + paramc.b(this.BUv) + " is not a subtype of " + paramw + " (value.type = " + paramb.CkA + ')');
    AppMethodBeat.o(122245);
    return paramw;
  }
  
  private final a.o<a.j.b.a.c.f.f, a.j.b.a.c.i.b.f<?>> a(a.a.a parama, Map<a.j.b.a.c.f.f, ? extends au> paramMap, a.j.b.a.c.e.a.c paramc)
  {
    AppMethodBeat.i(122244);
    Object localObject = (au)paramMap.get(r.b(paramc, parama.Ckx));
    if (localObject == null)
    {
      AppMethodBeat.o(122244);
      return null;
    }
    paramMap = r.b(paramc, parama.Ckx);
    localObject = ((au)localObject).eer();
    a.f.b.j.p(localObject, "parameter.type");
    parama = parama.Cky;
    a.f.b.j.p(parama, "proto.value");
    parama = new a.o(paramMap, a((a.j.b.a.c.l.w)localObject, parama, paramc));
    AppMethodBeat.o(122244);
    return parama;
  }
  
  private final a.j.b.a.c.a.g eec()
  {
    AppMethodBeat.i(122242);
    a.j.b.a.c.a.g localg = this.BUv.eec();
    AppMethodBeat.o(122242);
    return localg;
  }
  
  private final a.j.b.a.c.b.e f(a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(122246);
    parama = a.j.b.a.c.b.s.a(this.BUv, parama, this.BUa);
    AppMethodBeat.o(122246);
    return parama;
  }
  
  public final a.j.b.a.c.b.a.c b(a.a parama, a.j.b.a.c.e.a.c paramc)
  {
    AppMethodBeat.i(122243);
    a.f.b.j.q(parama, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    a.j.b.a.c.b.e locale = f(r.a(paramc, parama.Cks));
    Object localObject1 = ad.emptyMap();
    if ((parama.getArgumentCount() != 0) && (!a.j.b.a.c.l.p.L((a.j.b.a.c.b.l)locale)) && (a.j.b.a.c.i.d.z((a.j.b.a.c.b.l)locale)))
    {
      Object localObject2 = locale.ecA();
      a.f.b.j.p(localObject2, "annotationClass.constructors");
      localObject2 = (a.j.b.a.c.b.d)a.a.j.i((Iterable)localObject2);
      if (localObject2 != null)
      {
        localObject1 = ((a.j.b.a.c.b.d)localObject2).edu();
        a.f.b.j.p(localObject1, "constructor.valueParameters");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Map)new LinkedHashMap(a.i.e.iE(ad.TQ(a.a.j.d((Iterable)localObject2)), 16));
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          au localau = (au)localObject3;
          a.f.b.j.p(localau, "it");
          ((Map)localObject1).put(localau.edF(), localObject3);
        }
        parama = parama.Ckt;
        a.f.b.j.p(parama, "proto.argumentList");
        localObject2 = (Iterable)parama;
        parama = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (a.a.a)((Iterator)localObject2).next();
          a.f.b.j.p(localObject3, "it");
          localObject3 = a((a.a.a)localObject3, (Map)localObject1, paramc);
          if (localObject3 != null) {
            parama.add(localObject3);
          }
        }
      }
    }
    for (parama = ad.w((Iterable)parama);; parama = (a.a)localObject1)
    {
      parama = (a.j.b.a.c.b.a.c)new a.j.b.a.c.b.a.d((a.j.b.a.c.l.w)locale.edE(), parama, am.BWF);
      AppMethodBeat.o(122243);
      return parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.j.a.c
 * JD-Core Version:    0.7.0.1
 */