package a.j.b.a.c.d.a.c;

import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.a.g.b;
import a.j.b.a.c.d.a.e.a;
import a.k.f;
import a.k.l.a;
import a.k.l.b;
import a.k.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;

public final class e
  implements a.j.b.a.c.b.a.g
{
  private final a.j.b.a.c.k.d<a, a.j.b.a.c.b.a.c> Cfa;
  private final h Cfb;
  private final a.j.b.a.c.d.a.e.d Cfc;
  
  public e(h paramh, a.j.b.a.c.d.a.e.d paramd)
  {
    AppMethodBeat.i(119832);
    this.Cfb = paramh;
    this.Cfc = paramd;
    this.Cfa = this.Cfb.Cfj.BRT.j((a.f.a.b)new e.a(this));
    AppMethodBeat.o(119832);
  }
  
  public final a.j.b.a.c.b.a.c i(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119829);
    a.f.b.j.q(paramb, "fqName");
    Object localObject = this.Cfc.m(paramb);
    if (localObject != null)
    {
      a.j.b.a.c.b.a.c localc = (a.j.b.a.c.b.a.c)((a.f.a.b)this.Cfa).S(localObject);
      localObject = localc;
      if (localc != null) {}
    }
    else
    {
      localObject = a.j.b.a.c.d.a.a.c.CdT;
      localObject = a.j.b.a.c.d.a.a.c.a(paramb, this.Cfc, this.Cfb);
    }
    AppMethodBeat.o(119829);
    return localObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(119831);
    if (this.Cfc.egb().isEmpty())
    {
      AppMethodBeat.o(119831);
      return true;
    }
    AppMethodBeat.o(119831);
    return false;
  }
  
  public final Iterator<a.j.b.a.c.b.a.c> iterator()
  {
    AppMethodBeat.i(119830);
    Object localObject1 = a.k.i.d(a.a.j.t((Iterable)this.Cfc.egb()), (a.f.a.b)this.Cfa);
    Object localObject2 = a.j.b.a.c.d.a.a.c.CdT;
    localObject2 = a.j.b.a.c.a.g.BRU.BSy;
    a.f.b.j.p(localObject2, "KotlinBuiltIns.FQ_NAMES.deprecated");
    localObject2 = a.j.b.a.c.d.a.a.c.a((a.j.b.a.c.f.b)localObject2, this.Cfc, this.Cfb);
    a.f.b.j.q(localObject1, "receiver$0");
    localObject2 = a.k.i.aa(new a.k.h[] { localObject1, a.k.i.aa(new Object[] { localObject2 }) });
    a.f.b.j.q(localObject2, "receiver$0");
    localObject1 = (a.f.a.b)l.a.CGw;
    if ((localObject2 instanceof p))
    {
      localObject2 = (p)localObject2;
      a.f.b.j.q(localObject1, "iterator");
    }
    for (localObject1 = (a.k.h)new f(((p)localObject2).CGh, ((p)localObject2).CGp, (a.f.a.b)localObject1);; localObject1 = (a.k.h)new f((a.k.h)localObject2, (a.f.a.b)l.b.CGx, (a.f.a.b)localObject1))
    {
      localObject1 = a.k.i.b((a.k.h)localObject1).iterator();
      AppMethodBeat.o(119830);
      return localObject1;
    }
  }
  
  public final boolean j(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119833);
    a.f.b.j.q(paramb, "fqName");
    boolean bool = g.b.b(this, paramb);
    AppMethodBeat.o(119833);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.e
 * JD-Core Version:    0.7.0.1
 */