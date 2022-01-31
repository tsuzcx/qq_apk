package a.j.b.a.c.d.a.f;

import a.aa;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.h;
import a.j.b.a.c.d.a.p;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ax;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.c.a;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.j.b.a.c.l.y;
import a.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class s
{
  private static final b CiA;
  private static final b Ciz;
  
  static
  {
    AppMethodBeat.i(120210);
    a.j.b.a.c.f.b localb = p.Cdj;
    a.f.b.j.p(localb, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    Ciz = new b(localb);
    localb = p.Cdk;
    a.f.b.j.p(localb, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
    CiA = new b(localb);
    AppMethodBeat.o(120210);
  }
  
  public static final boolean U(w paramw)
  {
    AppMethodBeat.i(120201);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.ecM();
    a.j.b.a.c.f.b localb = p.Cdj;
    a.f.b.j.p(localb, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
    if (paramw.i(localb) != null)
    {
      AppMethodBeat.o(120201);
      return true;
    }
    AppMethodBeat.o(120201);
    return false;
  }
  
  private static final c<h> a(h paramh, d paramd, q paramq)
  {
    AppMethodBeat.i(120208);
    if (!a(paramq))
    {
      paramh = dx(paramh);
      AppMethodBeat.o(120208);
      return paramh;
    }
    if (!(paramh instanceof e))
    {
      paramh = dx(paramh);
      AppMethodBeat.o(120208);
      return paramh;
    }
    a.j.b.a.c.a.b.c localc = a.j.b.a.c.a.b.c.BVe;
    paramd = paramd.Chq;
    if (paramd == null) {}
    do
    {
      do
      {
        for (;;)
        {
          paramh = dx(paramh);
          AppMethodBeat.o(120208);
          return paramh;
          switch (t.bLo[paramd.ordinal()])
          {
          }
        }
      } while ((paramq != q.Civ) || (!a.j.b.a.c.a.b.c.h((e)paramh)));
      paramh = dz(a.j.b.a.c.a.b.c.j((e)paramh));
      AppMethodBeat.o(120208);
      return paramh;
    } while ((paramq != q.Ciw) || (!a.j.b.a.c.a.b.c.i((e)paramh)));
    paramh = dz(a.j.b.a.c.a.b.c.k((e)paramh));
    AppMethodBeat.o(120208);
    return paramh;
  }
  
  private static final c<Boolean> a(w paramw, d paramd, q paramq)
  {
    AppMethodBeat.i(120209);
    if (!a(paramq))
    {
      paramw = dx(Boolean.valueOf(paramw.egH()));
      AppMethodBeat.o(120209);
      return paramw;
    }
    paramd = paramd.Chp;
    if (paramd == null) {}
    for (;;)
    {
      paramw = dx(Boolean.valueOf(paramw.egH()));
      AppMethodBeat.o(120209);
      return paramw;
      switch (t.pRV[paramd.ordinal()])
      {
      }
    }
    paramw = dy(Boolean.TRUE);
    AppMethodBeat.o(120209);
    return paramw;
    paramw = dy(Boolean.FALSE);
    AppMethodBeat.o(120209);
    return paramw;
  }
  
  private static final k a(az paramaz, a.f.a.b<? super Integer, d> paramb, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(120202);
    if (y.an((w)paramaz))
    {
      paramaz = new k((w)paramaz, 1, false);
      AppMethodBeat.o(120202);
      return paramaz;
    }
    o localo1;
    o localo2;
    if ((paramaz instanceof a.j.b.a.c.l.q))
    {
      localo1 = a(((a.j.b.a.c.l.q)paramaz).CBm, paramb, paramInt, q.Civ);
      localo2 = a(((a.j.b.a.c.l.q)paramaz).CBn, paramb, paramInt, q.Ciw);
      if (localo1.ChV == localo2.ChV) {}
      for (paramInt = 1; (aa.BMh) && (paramInt == 0); paramInt = 0)
      {
        paramaz = (Throwable)new AssertionError("Different tree sizes of bounds: lower = (" + ((a.j.b.a.c.l.q)paramaz).CBm + ", " + localo1.ChV + "), upper = (" + ((a.j.b.a.c.l.q)paramaz).CBn + ", " + localo2.ChV + ')');
        AppMethodBeat.o(120202);
        throw paramaz;
      }
      if ((localo1.ChW) || (localo2.ChW)) {
        bool = true;
      }
      paramb = ax.aG((w)localo1.Cit);
      if (paramb != null) {
        break label369;
      }
      paramb = ax.aG((w)localo2.Cit);
    }
    label369:
    for (;;)
    {
      if (!bool)
      {
        paramaz = new k((w)paramaz, localo1.ChV, bool);
        AppMethodBeat.o(120202);
        return paramaz;
      }
      if ((paramaz instanceof a.j.b.a.c.d.a.c.b.g)) {}
      for (paramaz = (az)new a.j.b.a.c.d.a.c.b.g(localo1.Cit, localo2.Cit);; paramaz = x.a(localo1.Cit, localo2.Cit))
      {
        paramaz = ax.b(paramaz, paramb);
        break;
      }
      if ((paramaz instanceof ad))
      {
        paramaz = (k)a((ad)paramaz, paramb, paramInt, q.Cix);
        AppMethodBeat.o(120202);
        return paramaz;
      }
      paramaz = new m();
      AppMethodBeat.o(120202);
      throw paramaz;
    }
  }
  
  private static final o a(ad paramad, a.f.a.b<? super Integer, d> paramb, int paramInt, q paramq)
  {
    AppMethodBeat.i(120203);
    if ((!a(paramq)) && (paramad.enR().isEmpty()))
    {
      paramad = new o(paramad, 1, false);
      AppMethodBeat.o(120203);
      return paramad;
    }
    Object localObject1 = paramad.enU().ecR();
    if (localObject1 == null)
    {
      paramad = new o(paramad, 1, false);
      AppMethodBeat.o(120203);
      return paramad;
    }
    a.f.b.j.p(localObject1, "constructor.declarationD…pleResult(this, 1, false)");
    d locald = (d)paramb.S(Integer.valueOf(paramInt));
    localObject1 = a((h)localObject1, locald, paramq);
    h localh = (h)((c)localObject1).result;
    a.j.b.a.c.b.a.g localg = ((c)localObject1).Cho;
    an localan = localh.ecx();
    a.f.b.j.p(localan, "enhancedClassifier.typeConstructor");
    if (localg != null) {}
    Collection localCollection;
    int j;
    int k;
    int m;
    for (int i = 1;; i = 0)
    {
      localObject1 = (Iterable)paramad.enR();
      localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      j = 0;
      k = paramInt + 1;
      m = i;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label430;
        }
        localObject1 = localIterator.next();
        if (j < 0) {
          a.a.j.eaS();
        }
        localObject1 = (ap)localObject1;
        if (!((ap)localObject1).eoN()) {
          break;
        }
        i = k + 1;
        localObject1 = localh.ecx();
        a.f.b.j.p(localObject1, "enhancedClassifier.typeConstructor");
        localObject1 = av.e((ar)((an)localObject1).getParameters().get(j));
        localCollection.add(localObject1);
        j += 1;
        k = i;
      }
    }
    Object localObject2 = a(((ap)localObject1).eer().eoL(), paramb, k);
    if ((m != 0) || (((k)localObject2).ChW)) {}
    for (i = 1;; i = 0)
    {
      k = ((k)localObject2).ChV + k;
      localObject2 = ((k)localObject2).eer();
      localObject1 = ((ap)localObject1).eoO();
      a.f.b.j.p(localObject1, "arg.projectionKind");
      localObject1 = a.a((w)localObject2, (ba)localObject1, (ar)localan.getParameters().get(j));
      m = i;
      i = k;
      break;
    }
    label430:
    paramb = (List)localCollection;
    paramq = a((w)paramad, locald, paramq);
    boolean bool = ((Boolean)paramq.result).booleanValue();
    paramq = paramq.Cho;
    if ((m != 0) || (paramq != null)) {}
    for (i = 1;; i = 0)
    {
      j = k - paramInt;
      if (i != 0) {
        break;
      }
      paramad = new o(paramad, j, false);
      AppMethodBeat.o(120203);
      return paramad;
    }
    paramb = x.c(ge(a.a.j.k((Iterable)a.a.j.listOf(new a.j.b.a.c.b.a.g[] { paramad.ecM(), localg, paramq }))), localan, paramb, bool);
    if (locald.Chr)
    {
      paramb = (ad)new f(paramb);
      if ((paramq == null) || (!locald.Chs)) {
        break label630;
      }
      paramInt = 1;
      label588:
      if (paramInt == 0) {
        break label635;
      }
    }
    label630:
    label635:
    for (paramad = ax.b((az)paramad, (w)paramb);; paramad = (az)paramb)
    {
      if (paramad != null) {
        break label643;
      }
      paramad = new v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(120203);
      throw paramad;
      break;
      paramInt = 0;
      break label588;
    }
    label643:
    paramad = new o((ad)paramad, j, true);
    AppMethodBeat.o(120203);
    return paramad;
  }
  
  public static final w a(w paramw, a.f.a.b<? super Integer, d> paramb)
  {
    AppMethodBeat.i(120200);
    a.f.b.j.q(paramw, "receiver$0");
    a.f.b.j.q(paramb, "qualifiers");
    paramw = a(paramw.eoL(), paramb, 0);
    paramb = paramw.eer();
    if (paramw.ChW)
    {
      AppMethodBeat.o(120200);
      return paramb;
    }
    AppMethodBeat.o(120200);
    return null;
  }
  
  private static final boolean a(q paramq)
  {
    return paramq != q.Cix;
  }
  
  private static final <T> c<T> dx(T paramT)
  {
    AppMethodBeat.i(120205);
    paramT = new c(paramT, null);
    AppMethodBeat.o(120205);
    return paramT;
  }
  
  private static final <T> c<T> dy(T paramT)
  {
    AppMethodBeat.i(120206);
    paramT = new c(paramT, (a.j.b.a.c.b.a.g)Ciz);
    AppMethodBeat.o(120206);
    return paramT;
  }
  
  private static final <T> c<T> dz(T paramT)
  {
    AppMethodBeat.i(120207);
    paramT = new c(paramT, (a.j.b.a.c.b.a.g)CiA);
    AppMethodBeat.o(120207);
    return paramT;
  }
  
  private static final a.j.b.a.c.b.a.g ge(List<? extends a.j.b.a.c.b.a.g> paramList)
  {
    AppMethodBeat.i(120204);
    switch (paramList.size())
    {
    default: 
      paramList = (a.j.b.a.c.b.a.g)new a.j.b.a.c.b.a.k(a.a.j.m((Iterable)paramList));
      AppMethodBeat.o(120204);
      return paramList;
    case 0: 
      paramList = (Throwable)new IllegalStateException("At least one Annotations object expected".toString());
      AppMethodBeat.o(120204);
      throw paramList;
    }
    paramList = (a.j.b.a.c.b.a.g)a.a.j.fU(paramList);
    AppMethodBeat.o(120204);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.s
 * JD-Core Version:    0.7.0.1
 */