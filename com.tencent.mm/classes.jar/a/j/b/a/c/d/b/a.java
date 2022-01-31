package a.j.b.a.c.d.b;

import a.f.b.k;
import a.j.b.a.c.b.am;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.ae;
import a.j.b.a.c.e.a.ai;
import a.j.b.a.c.e.a.c.b;
import a.j.b.a.c.e.a.k;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.a.u;
import a.j.b.a.c.e.a.b.a;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.e.b.b.e;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.f;
import a.j.b.a.c.j.a.s;
import a.j.b.a.c.j.a.s.a;
import a.j.b.a.c.j.a.s.b;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a<A, C>
  implements a.j.b.a.c.j.a.b<A, C>
{
  private static final Set<a.j.b.a.c.f.a> CiC;
  private static final a.a CiD = new a.a((byte)0);
  private final m CeG;
  private final a.j.b.a.c.k.c<n, c<A, C>> CiB;
  
  static
  {
    Object localObject = (Iterable)a.a.j.listOf(new a.j.b.a.c.f.b[] { a.j.b.a.c.d.a.p.CcZ, a.j.b.a.c.d.a.p.Cdc, a.j.b.a.c.d.a.p.Cdd, new a.j.b.a.c.f.b("java.lang.annotation.Target"), new a.j.b.a.c.f.b("java.lang.annotation.Retention"), new a.j.b.a.c.f.b("java.lang.annotation.Documented") });
    Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(a.j.b.a.c.f.a.n((a.j.b.a.c.f.b)((Iterator)localObject).next()));
    }
    CiC = a.a.j.o((Iterable)localCollection);
  }
  
  public a(a.j.b.a.c.k.i parami, m paramm)
  {
    this.CeG = paramm;
    this.CiB = parami.i((a.f.a.b)new f(this));
  }
  
  private static n a(s.a parama)
  {
    Object localObject1 = null;
    Object localObject2 = parama.BXe;
    parama = (s.a)localObject2;
    if (!(localObject2 instanceof p)) {
      parama = null;
    }
    localObject2 = (p)parama;
    parama = localObject1;
    if (localObject2 != null) {
      parama = ((p)localObject2).Cjv;
    }
    return parama;
  }
  
  private static n a(s params, n paramn)
  {
    if (paramn != null) {
      return paramn;
    }
    if ((params instanceof s.a)) {
      return a((s.a)params);
    }
    return null;
  }
  
  private final n a(s params, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (paramBoolean == null) {
        throw ((Throwable)new IllegalStateException(("isConst should not be null for property (container=" + params + ')').toString()));
      }
      if (((params instanceof s.a)) && (((s.a)params).Czk == a.c.b.Clu))
      {
        paramBoolean = this.CeG;
        params = ((s.a)params).BUp.p(a.j.b.a.c.f.f.ayT("DefaultImpls"));
        a.f.b.j.p(params, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
        return paramBoolean.b(params);
      }
      if ((paramBoolean.booleanValue()) && ((params instanceof s.b)))
      {
        am localam = params.BXe;
        paramBoolean = localam;
        if (!(localam instanceof i)) {
          paramBoolean = null;
        }
        paramBoolean = (i)paramBoolean;
        if (paramBoolean != null) {}
        for (paramBoolean = paramBoolean.Cjm; paramBoolean != null; paramBoolean = null)
        {
          params = this.CeG;
          paramBoolean = paramBoolean.Cjr;
          a.f.b.j.p(paramBoolean, "facadeClassName.internalName");
          paramBoolean = a.j.b.a.c.f.a.n(new a.j.b.a.c.f.b(a.l.m.a(paramBoolean, '/', '.')));
          a.f.b.j.p(paramBoolean, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
          return params.b(paramBoolean);
        }
      }
    }
    if ((paramBoolean2) && ((params instanceof s.a)) && (((s.a)params).Czk == a.c.b.Clz))
    {
      paramBoolean = ((s.a)params).Czl;
      if ((paramBoolean != null) && ((paramBoolean.Czk == a.c.b.Clt) || (paramBoolean.Czk == a.c.b.Clv) || ((paramBoolean3) && ((paramBoolean.Czk == a.c.b.Clu) || (paramBoolean.Czk == a.c.b.Clx))))) {
        return a(paramBoolean);
      }
    }
    if (((params instanceof s.b)) && ((params.BXe instanceof i)))
    {
      params = params.BXe;
      if (params == null) {
        throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
      }
      params = (i)params;
      paramBoolean = params.Cjp;
      if (paramBoolean == null) {
        return this.CeG.b(params.ebx());
      }
    }
    else
    {
      return null;
    }
    return paramBoolean;
  }
  
  private static q a(a.u paramu, a.j.b.a.c.e.a.c paramc, h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = (i.c)paramu;
    i.f localf = a.j.b.a.c.e.b.b.Cpq;
    a.f.b.j.p(localf, "propertySignature");
    localObject = (b.e)a.j.b.a.c.e.a.f.a((i.c)localObject, localf);
    if (localObject == null) {
      return null;
    }
    if (paramBoolean1)
    {
      localObject = a.j.b.a.c.e.b.a.j.Cqr;
      paramu = a.j.b.a.c.e.b.a.j.a(paramu, paramc, paramh, paramBoolean3);
      if (paramu == null) {
        return null;
      }
      paramc = q.Cjw;
      return q.a.a((a.j.b.a.c.e.b.a.f)paramu);
    }
    if ((paramBoolean2) && (((b.e)localObject).elw()))
    {
      paramu = q.Cjw;
      paramu = ((b.e)localObject).CpF;
      a.f.b.j.p(paramu, "signature.syntheticMethod");
      return q.a.a(paramc, paramu);
    }
    return null;
  }
  
  private static q a(a.j.b.a.c.g.q paramq, a.j.b.a.c.e.a.c paramc, h paramh, a.j.b.a.c.j.a.a parama, boolean paramBoolean)
  {
    if ((paramq instanceof a.j.b.a.c.e.a.e))
    {
      parama = q.Cjw;
      parama = a.j.b.a.c.e.b.a.j.Cqr;
      paramq = a.j.b.a.c.e.b.a.j.a((a.j.b.a.c.e.a.e)paramq, paramc, paramh);
      if (paramq != null) {
        return q.a.a((a.j.b.a.c.e.b.a.f)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.o))
    {
      parama = q.Cjw;
      parama = a.j.b.a.c.e.b.a.j.Cqr;
      paramq = a.j.b.a.c.e.b.a.j.a((a.o)paramq, paramc, paramh);
      if (paramq != null) {
        return q.a.a((a.j.b.a.c.e.b.a.f)paramq);
      }
      return null;
    }
    if ((paramq instanceof a.u))
    {
      Object localObject = (i.c)paramq;
      i.f localf = a.j.b.a.c.e.b.b.Cpq;
      a.f.b.j.p(localf, "propertySignature");
      localObject = (b.e)a.j.b.a.c.e.a.f.a((i.c)localObject, localf);
      if (localObject == null) {
        return null;
      }
      switch (b.bLo[parama.ordinal()])
      {
      default: 
        return null;
      case 1: 
        if (((b.e)localObject).elx())
        {
          paramq = q.Cjw;
          paramq = ((b.e)localObject).CpG;
          a.f.b.j.p(paramq, "signature.getter");
          return q.a.a(paramc, paramq);
        }
        return null;
      case 2: 
        if (((b.e)localObject).ely())
        {
          paramq = q.Cjw;
          paramq = ((b.e)localObject).CpH;
          a.f.b.j.p(paramq, "signature.setter");
          return q.a.a(paramc, paramq);
        }
        return null;
      }
      return a((a.u)paramq, paramc, paramh, true, true, paramBoolean);
    }
    return null;
  }
  
  private final List<A> a(s params, q paramq, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    params = a(params, a(params, paramBoolean1, paramBoolean2, paramBoolean, paramBoolean3));
    if (params == null) {
      params = (List)a.a.v.BMx;
    }
    do
    {
      return params;
      paramq = (List)((c)this.CiB.S(params)).CiI.get(paramq);
      params = paramq;
    } while (paramq != null);
    return (List)a.a.v.BMx;
  }
  
  private final List<A> a(s params, a.u paramu, a.b paramb)
  {
    Boolean localBoolean = a.j.b.a.c.e.a.b.CoD.Vo(paramu.CkK);
    a.f.b.j.p(localBoolean, "Flags.IS_CONST.get(proto.flags)");
    boolean bool2 = localBoolean.booleanValue();
    boolean bool3 = a.j.b.a.c.e.b.a.j.f(paramu);
    if (paramb == a.b.CiE)
    {
      paramu = a(paramu, params.BOc, params.BOd, false, true, false, 40);
      if (paramu == null) {
        return (List)a.a.v.BMx;
      }
      return a(this, params, paramu, true, Boolean.valueOf(bool2), bool3, 8);
    }
    paramu = a(paramu, params.BOc, params.BOd, true, false, false, 48);
    if (paramu == null) {
      return (List)a.a.v.BMx;
    }
    boolean bool4 = a.l.m.a((CharSequence)paramu.signature, (CharSequence)"$delegate", false);
    if (paramb == a.b.CiG) {}
    for (boolean bool1 = true; bool4 != bool1; bool1 = false) {
      return (List)a.a.v.BMx;
    }
    return a(params, paramu, true, true, Boolean.valueOf(bool2), bool3);
  }
  
  protected abstract n.a a(a.j.b.a.c.f.a parama, am paramam, List<A> paramList);
  
  protected abstract A a(a.j.b.a.c.e.a.a parama, a.j.b.a.c.e.a.c paramc);
  
  public final C a(s params, a.u paramu, w paramw)
  {
    boolean bool2 = true;
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramu, "proto");
    a.f.b.j.q(paramw, "expectedType");
    n localn = a(params, a(params, true, true, a.j.b.a.c.e.a.b.CoD.Vo(paramu.CkK), a.j.b.a.c.e.b.a.j.f(paramu)));
    if (localn == null) {
      params = null;
    }
    do
    {
      return params;
      a.j.b.a.c.e.b.a.g localg = localn.ebZ().CjR;
      Object localObject = e.Cjf;
      localObject = (a.j.b.a.c.e.a.a)e.egQ();
      a.f.b.j.q(localObject, "version");
      int i = ((a.j.b.a.c.e.a.a)localObject).major;
      int j = ((a.j.b.a.c.e.a.a)localObject).minor;
      int k = ((a.j.b.a.c.e.a.a)localObject).Cod;
      boolean bool1;
      if (localg.major > i) {
        bool1 = bool2;
      }
      for (;;)
      {
        params = a((a.j.b.a.c.g.q)paramu, params.BOc, params.BOd, a.j.b.a.c.j.a.a.Cyo, bool1);
        if (params != null) {
          break;
        }
        return null;
        if (localg.major >= i)
        {
          bool1 = bool2;
          if (localg.minor > j) {
            continue;
          }
          if (localg.minor >= j)
          {
            bool1 = bool2;
            if (localg.Cod >= k) {
              continue;
            }
          }
        }
        bool1 = false;
      }
      paramu = ((c)this.CiB.S(localn)).CiJ.get(params);
      if (paramu == null) {
        return null;
      }
      params = a.j.b.a.c.a.m.BUu;
      params = paramu;
    } while (!a.j.b.a.c.a.m.G(paramw));
    return dA(paramu);
  }
  
  public final List<A> a(a.aa paramaa, a.j.b.a.c.e.a.c paramc)
  {
    a.f.b.j.q(paramaa, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    paramaa = paramaa.e(a.j.b.a.c.e.b.b.Cps);
    a.f.b.j.p(paramaa, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
    Object localObject = (Iterable)paramaa;
    paramaa = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.j.b.a.c.e.a.a locala = (a.j.b.a.c.e.a.a)((Iterator)localObject).next();
      a.f.b.j.p(locala, "it");
      paramaa.add(a(locala, paramc));
    }
    return (List)paramaa;
  }
  
  public final List<A> a(a.ae paramae, a.j.b.a.c.e.a.c paramc)
  {
    a.f.b.j.q(paramae, "proto");
    a.f.b.j.q(paramc, "nameResolver");
    paramae = paramae.e(a.j.b.a.c.e.b.b.Cpu);
    a.f.b.j.p(paramae, "proto.getExtension(JvmPr….typeParameterAnnotation)");
    Object localObject = (Iterable)paramae;
    paramae = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.j.b.a.c.e.a.a locala = (a.j.b.a.c.e.a.a)((Iterator)localObject).next();
      a.f.b.j.p(locala, "it");
      paramae.add(a(locala, paramc));
    }
    return (List)paramae;
  }
  
  public final List<A> a(s params, a.k paramk)
  {
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramk, "proto");
    Object localObject = q.Cjw;
    paramk = params.BOc.getString(paramk.ClT);
    localObject = ((s.a)params).BUp.mk();
    a.f.b.j.p(localObject, "(container as ProtoConta…Class).classId.asString()");
    return a(this, params, q.a.jp(paramk, a.j.b.a.c.e.b.a.c.ayR((String)localObject)), false, null, false, 60);
  }
  
  public final List<A> a(s params, a.u paramu)
  {
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramu, "proto");
    return a(params, paramu, a.b.CiF);
  }
  
  public final List<A> a(s params, a.j.b.a.c.g.q paramq, a.j.b.a.c.j.a.a parama)
  {
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramq, "proto");
    a.f.b.j.q(parama, "kind");
    if (parama == a.j.b.a.c.j.a.a.Cyo) {
      return a(params, (a.u)paramq, a.b.CiE);
    }
    paramq = a(paramq, params.BOc, params.BOd, parama);
    if (paramq == null) {
      return (List)a.a.v.BMx;
    }
    return a(this, params, paramq, false, null, false, 60);
  }
  
  public final List<A> a(s params, a.j.b.a.c.g.q paramq, a.j.b.a.c.j.a.a parama, int paramInt, a.ai paramai)
  {
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramq, "callableProto");
    a.f.b.j.q(parama, "kind");
    a.f.b.j.q(paramai, "proto");
    parama = a(paramq, params.BOc, params.BOd, parama);
    if (parama != null)
    {
      int i;
      if ((paramq instanceof a.o)) {
        if (a.j.b.a.c.e.a.g.f((a.o)paramq)) {
          i = 1;
        }
      }
      for (;;)
      {
        paramq = q.Cjw;
        return a(this, params, q.a.a(parama, i + paramInt), false, null, false, 60);
        i = 0;
        continue;
        if ((paramq instanceof a.u))
        {
          if (a.j.b.a.c.e.a.g.e((a.u)paramq)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else
        {
          if (!(paramq instanceof a.j.b.a.c.e.a.e)) {
            break;
          }
          if (params == null) {
            throw new a.v("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
          }
          if (((s.a)params).Czk == a.c.b.Clv) {
            i = 2;
          } else if (((s.a)params).BWA) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      throw ((Throwable)new UnsupportedOperationException("Unsupported message: " + paramq.getClass()));
    }
    return (List)a.a.v.BMx;
  }
  
  public final List<A> b(s.a parama)
  {
    a.f.b.j.q(parama, "container");
    n localn = a(parama);
    if (localn == null) {
      throw ((Throwable)new IllegalStateException(("Class for loading annotations is not found: " + parama.eop()).toString()));
    }
    parama = new ArrayList(1);
    n.c localc = (n.c)new a.e(this, parama);
    a.f.b.j.q(localn, "kotlinClass");
    localn.a(localc);
    return (List)parama;
  }
  
  public final List<A> b(s params, a.u paramu)
  {
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramu, "proto");
    return a(params, paramu, a.b.CiG);
  }
  
  public final List<A> b(s params, a.j.b.a.c.g.q paramq, a.j.b.a.c.j.a.a parama)
  {
    a.f.b.j.q(params, "container");
    a.f.b.j.q(paramq, "proto");
    a.f.b.j.q(parama, "kind");
    paramq = a(paramq, params.BOc, params.BOd, parama);
    if (paramq != null)
    {
      parama = q.Cjw;
      return a(this, params, q.a.a(paramq, 0), false, null, false, 60);
    }
    return (List)a.a.v.BMx;
  }
  
  protected abstract C dA(C paramC);
  
  static final class c<A, C>
  {
    final Map<q, List<A>> CiI;
    final Map<q, C> CiJ;
    
    public c(Map<q, ? extends List<? extends A>> paramMap, Map<q, ? extends C> paramMap1)
    {
      AppMethodBeat.i(120214);
      this.CiI = paramMap;
      this.CiJ = paramMap1;
      AppMethodBeat.o(120214);
    }
  }
  
  public static final class d
    implements n.e
  {
    d(HashMap paramHashMap1, HashMap paramHashMap2) {}
    
    public final n.f a(a.j.b.a.c.f.f paramf, String paramString)
    {
      AppMethodBeat.i(120221);
      a.f.b.j.q(paramf, "name");
      a.f.b.j.q(paramString, "desc");
      q.a locala = q.Cjw;
      paramf = paramf.name;
      a.f.b.j.p(paramf, "name.asString()");
      paramf = (n.f)new a(q.a.jo(paramf, paramString));
      AppMethodBeat.o(120221);
      return paramf;
    }
    
    public final n.c b(a.j.b.a.c.f.f paramf, String paramString)
    {
      AppMethodBeat.i(120222);
      a.f.b.j.q(paramf, "name");
      a.f.b.j.q(paramString, "desc");
      q.a locala = q.Cjw;
      paramf = paramf.name;
      a.f.b.j.p(paramf, "name.asString()");
      paramf = (n.c)new a.d.b(this, q.a.jp(paramf, paramString));
      AppMethodBeat.o(120222);
      return paramf;
    }
    
    public final class a
      extends a.d.b
      implements n.f
    {
      public a()
      {
        super(localObject);
        AppMethodBeat.i(120217);
        AppMethodBeat.o(120217);
      }
      
      public final n.a a(int paramInt, a.j.b.a.c.f.a parama, am paramam)
      {
        AppMethodBeat.i(120216);
        a.f.b.j.q(parama, "classId");
        a.f.b.j.q(paramam, "source");
        Object localObject = q.Cjw;
        q localq = q.a.a(this.CiP, paramInt);
        List localList = (List)a.d.this.CiL.get(localq);
        localObject = localList;
        if (localList == null)
        {
          localObject = (List)new ArrayList();
          ((Map)a.d.this.CiL).put(localq, localObject);
        }
        parama = a.a(a.d.this.CiK, parama, paramam, (List)localObject);
        AppMethodBeat.o(120216);
        return parama;
      }
    }
  }
  
  static final class f
    extends k
    implements a.f.a.b<n, a.c<? extends A, ? extends C>>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.b.a
 * JD-Core Version:    0.7.0.1
 */