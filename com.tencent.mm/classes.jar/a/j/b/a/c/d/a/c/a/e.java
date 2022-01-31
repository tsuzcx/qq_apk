package a.j.b.a.c.d.a.c.a;

import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.au;
import a.j.b.a.c.d.a.c.b.d;
import a.j.b.a.c.d.a.e.m;
import a.j.b.a.c.i.b.q;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ar;
import a.j.b.a.c.l.av;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.j.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
  implements a.j.b.a.c.b.a.c
{
  private final a.j.b.a.c.k.f CdF;
  private final a.j.b.a.c.k.f CdY;
  private final a.j.b.a.c.k.g CfF;
  private final a.j.b.a.c.d.a.d.a CfG;
  private final a.j.b.a.c.d.a.e.a CfH;
  private final a.j.b.a.c.d.a.c.h Cfb;
  
  static
  {
    AppMethodBeat.i(119877);
    eOJ = new k[] { (k)v.a(new t(v.aG(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), (k)v.a(new t(v.aG(e.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), (k)v.a(new t(v.aG(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;")) };
    AppMethodBeat.o(119877);
  }
  
  public e(a.j.b.a.c.d.a.c.h paramh, a.j.b.a.c.d.a.e.a parama)
  {
    AppMethodBeat.i(119884);
    this.Cfb = paramh;
    this.CfH = parama;
    this.CfF = this.Cfb.Cfj.BRT.m((a.f.a.a)new e.b(this));
    this.CdF = this.Cfb.Cfj.BRT.l((a.f.a.a)new e.c(this));
    this.CfG = this.Cfb.Cfj.CeN.a((a.j.b.a.c.d.a.e.l)this.CfH);
    this.CdY = this.Cfb.Cfj.BRT.l((a.f.a.a)new e.a(this));
    AppMethodBeat.o(119884);
  }
  
  private final a.j.b.a.c.i.b.f<?> b(a.j.b.a.c.d.a.e.b paramb)
  {
    AppMethodBeat.i(119882);
    if ((paramb instanceof a.j.b.a.c.d.a.e.o))
    {
      paramb = a.j.b.a.c.i.b.g.CwD.dL(((a.j.b.a.c.d.a.e.o)paramb).getValue());
      AppMethodBeat.o(119882);
      return paramb;
    }
    Object localObject1;
    if ((paramb instanceof m))
    {
      localObject1 = ((m)paramb).egp();
      paramb = ((m)paramb).egq();
      if ((localObject1 == null) || (paramb == null))
      {
        AppMethodBeat.o(119882);
        return null;
      }
      paramb = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.i((a.j.b.a.c.f.a)localObject1, paramb);
      AppMethodBeat.o(119882);
      return paramb;
    }
    Object localObject2;
    if ((paramb instanceof a.j.b.a.c.d.a.e.e))
    {
      localObject2 = paramb.edF();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = a.j.b.a.c.d.a.p.Cdb;
        a.f.b.j.p(localObject1, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      localObject2 = ((a.j.b.a.c.d.a.e.e)paramb).egc();
      paramb = efP();
      a.f.b.j.p(paramb, "type");
      if (a.j.b.a.c.l.y.an((w)paramb)) {
        break label473;
      }
      paramb = a.j.b.a.c.i.c.a.l(this);
      if (paramb == null) {
        a.f.b.j.ebi();
      }
      paramb = a.j.b.a.c.d.a.a.a.b((a.j.b.a.c.f.f)localObject1, paramb);
      if (paramb != null)
      {
        paramb = paramb.eer();
        if (paramb != null) {
          break label525;
        }
      }
      paramb = (w)this.Cfb.Cfj.BUv.eec().a(ba.CBX, (w)a.j.b.a.c.l.p.azj("Unknown array element type"));
    }
    label525:
    for (;;)
    {
      a.f.b.j.p(paramb, "DescriptorResolverUtils.…e\")\n                    )");
      localObject1 = (Iterable)localObject2;
      Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = b((a.j.b.a.c.d.a.e.b)localIterator.next());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (a.j.b.a.c.i.b.f)new q();
        }
        localCollection.add(localObject1);
      }
      localObject1 = (List)localCollection;
      localObject2 = a.j.b.a.c.i.b.g.CwD;
      paramb = (a.j.b.a.c.i.b.f)a.j.b.a.c.i.b.g.a((List)localObject1, paramb);
      AppMethodBeat.o(119882);
      return paramb;
      if ((paramb instanceof a.j.b.a.c.d.a.e.c))
      {
        paramb = ((a.j.b.a.c.d.a.e.c)paramb).ega();
        paramb = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.a((a.j.b.a.c.b.a.c)new e(this.Cfb, paramb));
        AppMethodBeat.o(119882);
        return paramb;
      }
      if ((paramb instanceof a.j.b.a.c.d.a.e.h))
      {
        paramb = ((a.j.b.a.c.d.a.e.h)paramb).egj();
        localObject1 = av.aA(this.Cfb.Cfi.a(paramb, d.a(a.j.b.a.c.d.a.a.l.Cek, false, null, 3)));
        a.f.b.j.p(localObject1, "TypeUtils.makeNotNullabl…toAttributes())\n        )");
        paramb = a.j.b.a.c.i.c.a.b(this.Cfb.Cfj.BUv, new a.j.b.a.c.f.b("java.lang.Class"), (a.j.b.a.c.c.a.a)a.j.b.a.c.c.a.c.CbI);
        if (paramb != null) {}
      }
      else
      {
        label473:
        AppMethodBeat.o(119882);
        return null;
      }
      localObject1 = a.a.j.listOf(new ar((w)localObject1));
      localObject2 = a.j.b.a.c.b.a.g.BXx;
      paramb = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.o((w)x.a(g.a.eeH(), paramb, (List)localObject1));
      AppMethodBeat.o(119882);
      return paramb;
    }
  }
  
  private ad efP()
  {
    AppMethodBeat.i(119879);
    ad localad = (ad)a.j.b.a.c.k.h.a(this.CdF, eOJ[1]);
    AppMethodBeat.o(119879);
    return localad;
  }
  
  public final Map<a.j.b.a.c.f.f, a.j.b.a.c.i.b.f<?>> eeG()
  {
    AppMethodBeat.i(119881);
    Map localMap = (Map)a.j.b.a.c.k.h.a(this.CdY, eOJ[2]);
    AppMethodBeat.o(119881);
    return localMap;
  }
  
  public final a.j.b.a.c.f.b eee()
  {
    AppMethodBeat.i(119878);
    Object localObject = this.CfF;
    k localk = eOJ[0];
    a.f.b.j.q(localObject, "receiver$0");
    a.f.b.j.q(localk, "p");
    localObject = (a.j.b.a.c.f.b)((a.j.b.a.c.k.g)localObject).invoke();
    AppMethodBeat.o(119878);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119883);
    String str = a.j.b.a.c.h.c.a(a.j.b.a.c.h.c.Ctz, (a.j.b.a.c.b.a.c)this);
    AppMethodBeat.o(119883);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.e
 * JD-Core Version:    0.7.0.1
 */