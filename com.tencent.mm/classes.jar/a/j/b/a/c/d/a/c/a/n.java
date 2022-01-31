package a.j.b.a.c.d.a.c.a;

import a.j.b.a.c.a.g;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.y;
import a.j.b.a.c.d.a.c.b.c;
import a.j.b.a.c.d.a.c.e;
import a.j.b.a.c.d.a.c.h;
import a.j.b.a.c.d.a.e.v;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class n
  extends a.j.b.a.c.b.c.b
{
  private final h Cfb;
  private final e CgI;
  private final a.j.b.a.c.d.a.e.w CgJ;
  
  public n(h paramh, a.j.b.a.c.d.a.e.w paramw, int paramInt, a.j.b.a.c.b.l paraml)
  {
    super(paramh.Cfj.BRT, paraml, paramw.edF(), ba.CBX, false, paramInt, am.BWF, paramh.Cfj.BZf);
    AppMethodBeat.i(120021);
    this.Cfb = paramh;
    this.CgJ = paramw;
    this.CgI = new e(this.Cfb, (a.j.b.a.c.d.a.e.d)this.CgJ);
    AppMethodBeat.o(120021);
  }
  
  public final void J(a.j.b.a.c.l.w paramw)
  {
    AppMethodBeat.i(120020);
    a.f.b.j.q(paramw, "type");
    AppMethodBeat.o(120020);
  }
  
  public final List<a.j.b.a.c.l.w> eeP()
  {
    AppMethodBeat.i(120019);
    Object localObject1 = this.CgJ.egA();
    if (((Collection)localObject1).isEmpty())
    {
      localObject1 = this.Cfb.Cfj.BUv.eec().ecl();
      a.f.b.j.p(localObject1, "c.module.builtIns.anyType");
      localObject2 = this.Cfb.Cfj.BUv.eec().ecm();
      a.f.b.j.p(localObject2, "c.module.builtIns.nullableAnyType");
      localObject1 = a.a.j.listOf(x.a((ad)localObject1, (ad)localObject2));
      AppMethodBeat.o(120019);
      return localObject1;
    }
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.j.b.a.c.d.a.e.j localj = (a.j.b.a.c.d.a.e.j)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.Cfb.Cfi.a((v)localj, a.j.b.a.c.d.a.c.b.d.a(a.j.b.a.c.d.a.a.l.Cek, false, (ar)this, 1)));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(120019);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */