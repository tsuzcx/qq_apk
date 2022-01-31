package a.j.b.a.c.d.a.c.b;

import a.j.b.a.c.d.a.a.l;
import a.j.b.a.c.d.a.c.h;
import a.j.b.a.c.d.a.c.m;
import a.j.b.a.c.d.a.e.u;
import a.j.b.a.c.d.a.e.v;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private final h Cfb;
  private final m Cfk;
  
  public c(h paramh, m paramm)
  {
    AppMethodBeat.i(120049);
    this.Cfb = paramh;
    this.Cfk = paramm;
    AppMethodBeat.o(120049);
  }
  
  private final a.j.b.a.c.b.e a(a.j.b.a.c.d.a.e.j paramj, a parama, a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(120044);
    if ((parama.CgM) && (a.f.b.j.e(paramb, d.efW())))
    {
      paramj = this.Cfb.Cfj.CeR.ecr();
      AppMethodBeat.o(120044);
      return paramj;
    }
    a.j.b.a.c.a.b.c localc = a.j.b.a.c.a.b.c.BVe;
    paramb = a.j.b.a.c.a.b.c.a(paramb, this.Cfb.Cfj.BUv.eec());
    if (paramb == null)
    {
      AppMethodBeat.o(120044);
      return null;
    }
    if ((a.j.b.a.c.a.b.c.i(paramb)) && ((parama.CgL == b.CgQ) || (parama.CgK == l.Cej) || (a(paramj, paramb))))
    {
      paramj = a.j.b.a.c.a.b.c.k(paramb);
      AppMethodBeat.o(120044);
      return paramj;
    }
    AppMethodBeat.o(120044);
    return paramb;
  }
  
  private final ad a(a.j.b.a.c.d.a.e.j paramj, a parama, ad paramad)
  {
    AppMethodBeat.i(120041);
    Object localObject1;
    if (paramad != null)
    {
      localObject2 = paramad.ecM();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = (a.j.b.a.c.b.a.g)new a.j.b.a.c.d.a.c.e(this.Cfb, (a.j.b.a.c.d.a.e.d)paramj);
    }
    an localan = b(paramj, parama);
    if (localan == null)
    {
      AppMethodBeat.o(120041);
      return null;
    }
    boolean bool = a(parama);
    if (paramad != null) {}
    for (Object localObject2 = paramad.enU(); (a.f.b.j.e(localObject2, localan)) && (!paramj.egm()) && (bool); localObject2 = null)
    {
      paramj = paramad.ss(true);
      AppMethodBeat.o(120041);
      return paramj;
    }
    paramj = x.c((a.j.b.a.c.b.a.g)localObject1, localan, a(paramj, parama, localan), bool);
    AppMethodBeat.o(120041);
    return paramj;
  }
  
  private final an a(a.j.b.a.c.d.a.e.j paramj)
  {
    AppMethodBeat.i(120043);
    paramj = a.j.b.a.c.f.a.n(new a.j.b.a.c.f.b(paramj.egn()));
    a.f.b.j.p(paramj, "ClassId.topLevel(FqName(…classifierQualifiedName))");
    paramj = this.Cfb.Cfj.CeH.egO().BUa.a(paramj, a.a.j.listOf(Integer.valueOf(0))).ecx();
    a.f.b.j.p(paramj, "c.components.deserialize…istOf(0)).typeConstructor");
    AppMethodBeat.o(120043);
    return paramj;
  }
  
  private final ap a(v paramv, a parama, a.j.b.a.c.b.ar paramar)
  {
    AppMethodBeat.i(120047);
    if ((paramv instanceof a.j.b.a.c.d.a.e.z))
    {
      v localv = ((a.j.b.a.c.d.a.e.z)paramv).egC();
      if (((a.j.b.a.c.d.a.e.z)paramv).egD()) {}
      for (paramv = ba.CBZ; (localv == null) || (a(paramv, paramar)); paramv = ba.CBY)
      {
        paramv = d.a(paramar, parama);
        AppMethodBeat.o(120047);
        return paramv;
      }
      paramv = a.j.b.a.c.l.c.a.a(a(localv, d.a(l.Cek, false, null, 3)), paramv, paramar);
      AppMethodBeat.o(120047);
      return paramv;
    }
    paramv = (ap)new a.j.b.a.c.l.ar(ba.CBX, a(paramv, parama));
    AppMethodBeat.o(120047);
    return paramv;
  }
  
  private final a.j.b.a.c.l.w a(a.j.b.a.c.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(120040);
    c.c localc = new c.c(paramj);
    if ((!parama.CgM) && (parama.CgK != l.Cej)) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = paramj.egm();
      if ((bool) || (i != 0)) {
        break label99;
      }
      paramj = a(paramj, parama, null);
      if (paramj == null) {
        break;
      }
      paramj = (a.j.b.a.c.l.w)paramj;
      AppMethodBeat.o(120040);
      return paramj;
    }
    paramj = (a.j.b.a.c.l.w)localc.efV();
    AppMethodBeat.o(120040);
    return paramj;
    label99:
    ad localad = a(paramj, parama.a(b.CgQ), null);
    if (localad == null)
    {
      paramj = (a.j.b.a.c.l.w)localc.efV();
      AppMethodBeat.o(120040);
      return paramj;
    }
    paramj = a(paramj, parama.a(b.CgP), localad);
    if (paramj == null)
    {
      paramj = (a.j.b.a.c.l.w)localc.efV();
      AppMethodBeat.o(120040);
      return paramj;
    }
    if (bool)
    {
      paramj = (a.j.b.a.c.l.w)new g(localad, paramj);
      AppMethodBeat.o(120040);
      return paramj;
    }
    paramj = (a.j.b.a.c.l.w)x.a(localad, paramj);
    AppMethodBeat.o(120040);
    return paramj;
  }
  
  private final List<ap> a(a.j.b.a.c.d.a.e.j paramj, a parama, an paraman)
  {
    AppMethodBeat.i(120046);
    boolean bool = paramj.egm();
    int i;
    Object localObject1;
    Object localObject2;
    label101:
    Object localObject3;
    a.j.b.a.c.l.z localz;
    if ((bool) || ((paramj.egl().isEmpty()) && (!paraman.getParameters().isEmpty())))
    {
      i = 1;
      localObject1 = paraman.getParameters();
      a.f.b.j.p(localObject1, "constructor.parameters");
      if (i == 0) {
        break label237;
      }
      paramj = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(a.a.j.d(paramj));
      localObject2 = paramj.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label217;
      }
      localObject3 = (a.j.b.a.c.b.ar)((Iterator)localObject2).next();
      localz = new a.j.b.a.c.l.z(this.Cfb.Cfj.BRT, (a.f.a.a)new c.b((a.j.b.a.c.b.ar)localObject3, this, parama, paraman, bool));
      paramj = e.Che;
      a.f.b.j.p(localObject3, "parameter");
      if (!bool) {
        break label206;
      }
    }
    label206:
    for (paramj = parama;; paramj = parama.a(b.CgO))
    {
      ((Collection)localObject1).add(e.a((a.j.b.a.c.b.ar)localObject3, paramj, (a.j.b.a.c.l.w)localz));
      break label101;
      i = 0;
      break;
    }
    label217:
    paramj = a.a.j.m((Iterable)localObject1);
    AppMethodBeat.o(120046);
    return paramj;
    label237:
    if (((List)localObject1).size() != paramj.egl().size())
    {
      parama = (Iterable)localObject1;
      paramj = (Collection)new ArrayList(a.a.j.d(parama));
      parama = parama.iterator();
      while (parama.hasNext())
      {
        paraman = (a.j.b.a.c.b.ar)parama.next();
        a.f.b.j.p(paraman, "p");
        paramj.add(new a.j.b.a.c.l.ar((a.j.b.a.c.l.w)p.azj(paraman.edF().name)));
      }
      paramj = a.a.j.m((Iterable)paramj);
      AppMethodBeat.o(120046);
      return paramj;
    }
    parama = a.a.j.p((Iterable)paramj.egl());
    paramj = (Collection)new ArrayList(a.a.j.d(parama));
    parama = parama.iterator();
    while (parama.hasNext())
    {
      paraman = (a.a.y)parama.next();
      int j = paraman.index;
      paraman = (v)paraman.value;
      if (j < ((List)localObject1).size()) {}
      for (i = 1; (a.aa.BMh) && (i == 0); i = 0)
      {
        paramj = (Throwable)new AssertionError("Argument index should be less then type parameters count, but " + j + " > " + ((List)localObject1).size());
        AppMethodBeat.o(120046);
        throw paramj;
      }
      localObject2 = (a.j.b.a.c.b.ar)((List)localObject1).get(j);
      localObject3 = d.a(l.Cek, false, null, 3);
      a.f.b.j.p(localObject2, "parameter");
      paramj.add(a(paraman, (a)localObject3, (a.j.b.a.c.b.ar)localObject2));
    }
    paramj = a.a.j.m((Iterable)paramj);
    AppMethodBeat.o(120046);
    return paramj;
  }
  
  private static boolean a(a parama)
  {
    if (parama.CgL == b.CgQ) {}
    while ((parama.CgM) || (parama.CgK == l.Cej)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(a.j.b.a.c.d.a.e.j paramj, a.j.b.a.c.b.e parame)
  {
    AppMethodBeat.i(120045);
    c.a locala = c.a.CgS;
    if (!c.a.a((v)a.a.j.fT(paramj.egl())))
    {
      AppMethodBeat.o(120045);
      return false;
    }
    paramj = a.j.b.a.c.a.b.c.BVe;
    paramj = a.j.b.a.c.a.b.c.k(parame).ecx();
    a.f.b.j.p(paramj, "JavaToKotlinClassMap.con…         .typeConstructor");
    paramj = paramj.getParameters();
    a.f.b.j.p(paramj, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
    paramj = (a.j.b.a.c.b.ar)a.a.j.fT(paramj);
    if (paramj != null)
    {
      paramj = paramj.edG();
      if (paramj != null) {}
    }
    else
    {
      AppMethodBeat.o(120045);
      return false;
    }
    a.f.b.j.p(paramj, "JavaToKotlinClassMap.con….variance ?: return false");
    if (paramj != ba.CBZ)
    {
      AppMethodBeat.o(120045);
      return true;
    }
    AppMethodBeat.o(120045);
    return false;
  }
  
  private static boolean a(ba paramba, a.j.b.a.c.b.ar paramar)
  {
    AppMethodBeat.i(120048);
    if (paramar.edG() == ba.CBX)
    {
      AppMethodBeat.o(120048);
      return false;
    }
    if (paramba != paramar.edG())
    {
      AppMethodBeat.o(120048);
      return true;
    }
    AppMethodBeat.o(120048);
    return false;
  }
  
  private final an b(a.j.b.a.c.d.a.e.j paramj, a parama)
  {
    AppMethodBeat.i(120042);
    a.j.b.a.c.d.a.e.i locali = paramj.egk();
    if (locali == null)
    {
      paramj = a(paramj);
      AppMethodBeat.o(120042);
      return paramj;
    }
    if ((locali instanceof a.j.b.a.c.d.a.e.g))
    {
      Object localObject = ((a.j.b.a.c.d.a.e.g)locali).eee();
      if (localObject == null)
      {
        paramj = (Throwable)new AssertionError("Class type should have a FQ name: ".concat(String.valueOf(locali)));
        AppMethodBeat.o(120042);
        throw paramj;
      }
      localObject = a(paramj, parama, (a.j.b.a.c.f.b)localObject);
      parama = (a)localObject;
      if (localObject == null) {
        parama = this.Cfb.Cfj.CeO.b((a.j.b.a.c.d.a.e.g)locali);
      }
      if (parama != null)
      {
        parama = parama.ecx();
        if (parama != null) {}
      }
      else
      {
        paramj = a(paramj);
        AppMethodBeat.o(120042);
        return paramj;
      }
    }
    else
    {
      if ((locali instanceof a.j.b.a.c.d.a.e.w))
      {
        paramj = this.Cfk.a((a.j.b.a.c.d.a.e.w)locali);
        if (paramj != null)
        {
          paramj = paramj.ecx();
          AppMethodBeat.o(120042);
          return paramj;
        }
        AppMethodBeat.o(120042);
        return null;
      }
      paramj = (Throwable)new IllegalStateException("Unknown classifier kind: ".concat(String.valueOf(locali)));
      AppMethodBeat.o(120042);
      throw paramj;
    }
    AppMethodBeat.o(120042);
    return parama;
  }
  
  public final a.j.b.a.c.l.w a(a.j.b.a.c.d.a.e.f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(120039);
    a.f.b.j.q(paramf, "arrayType");
    a.f.b.j.q(parama, "attr");
    Object localObject = paramf.egd();
    if (!(localObject instanceof u)) {}
    for (paramf = null;; paramf = (a.j.b.a.c.d.a.e.f)localObject)
    {
      paramf = (u)paramf;
      if (paramf != null) {
        paramf = paramf.egz();
      }
      while (paramf != null)
      {
        paramf = this.Cfb.Cfj.BUv.eec().b(paramf);
        a.f.b.j.p(paramf, "c.module.builtIns.getPri…KotlinType(primitiveType)");
        if (parama.CgM)
        {
          paramf = (a.j.b.a.c.l.w)paramf;
          AppMethodBeat.o(120039);
          return paramf;
          paramf = null;
        }
        else
        {
          paramf = (a.j.b.a.c.l.w)x.a(paramf, paramf.ss(true));
          AppMethodBeat.o(120039);
          return paramf;
        }
      }
      localObject = a((v)localObject, d.a(l.Cek, parama.CgM, null, 2));
      if (parama.CgM)
      {
        if (paramBoolean) {}
        for (paramf = ba.CBZ;; paramf = ba.CBX)
        {
          paramf = this.Cfb.Cfj.BUv.eec().a(paramf, (a.j.b.a.c.l.w)localObject);
          a.f.b.j.p(paramf, "c.module.builtIns.getArr…ctionKind, componentType)");
          paramf = (a.j.b.a.c.l.w)paramf;
          AppMethodBeat.o(120039);
          return paramf;
        }
      }
      paramf = this.Cfb.Cfj.BUv.eec().a(ba.CBX, (a.j.b.a.c.l.w)localObject);
      a.f.b.j.p(paramf, "c.module.builtIns.getArr…INVARIANT, componentType)");
      paramf = (a.j.b.a.c.l.w)x.a(paramf, this.Cfb.Cfj.BUv.eec().a(ba.CBZ, (a.j.b.a.c.l.w)localObject).ss(true));
      AppMethodBeat.o(120039);
      return paramf;
    }
  }
  
  public final a.j.b.a.c.l.w a(v paramv, a parama)
  {
    AppMethodBeat.i(120038);
    a.f.b.j.q(paramv, "javaType");
    a.f.b.j.q(parama, "attr");
    if ((paramv instanceof u))
    {
      paramv = ((u)paramv).egz();
      if (paramv != null) {}
      for (paramv = this.Cfb.Cfj.BUv.eec().a(paramv);; paramv = this.Cfb.Cfj.BUv.eec().ecn())
      {
        a.f.b.j.p(paramv, "if (primitiveType != nul….module.builtIns.unitType");
        paramv = (a.j.b.a.c.l.w)paramv;
        AppMethodBeat.o(120038);
        return paramv;
      }
    }
    if ((paramv instanceof a.j.b.a.c.d.a.e.j))
    {
      paramv = a((a.j.b.a.c.d.a.e.j)paramv, parama);
      AppMethodBeat.o(120038);
      return paramv;
    }
    if ((paramv instanceof a.j.b.a.c.d.a.e.f))
    {
      paramv = a((a.j.b.a.c.d.a.e.f)paramv, parama, false);
      AppMethodBeat.o(120038);
      return paramv;
    }
    if ((paramv instanceof a.j.b.a.c.d.a.e.z))
    {
      paramv = ((a.j.b.a.c.d.a.e.z)paramv).egC();
      if (paramv != null)
      {
        paramv = a(paramv, parama);
        if (paramv != null) {}
      }
      else
      {
        paramv = this.Cfb.Cfj.BUv.eec().ecm();
        a.f.b.j.p(paramv, "c.module.builtIns.defaultBound");
        paramv = (a.j.b.a.c.l.w)paramv;
        AppMethodBeat.o(120038);
        return paramv;
      }
    }
    else
    {
      paramv = (Throwable)new UnsupportedOperationException("Unsupported type: ".concat(String.valueOf(paramv)));
      AppMethodBeat.o(120038);
      throw paramv;
    }
    AppMethodBeat.o(120038);
    return paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */