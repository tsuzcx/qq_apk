package a.j.b.a.c.j.a.a;

import a.a.ad;
import a.f.a.a;
import a.f.a.b;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.k;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.j.a.k;
import a.j.b.a.c.j.a.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

final class d$c
{
  final a.j.b.a.c.k.f<Set<a.j.b.a.c.f.f>> BZr;
  final Map<a.j.b.a.c.f.f, a.k> CzR;
  private final a.j.b.a.c.k.d<a.j.b.a.c.f.f, a.j.b.a.c.b.e> CzS;
  
  public d$c()
  {
    AppMethodBeat.i(122371);
    Object localObject2 = localObject1.Cys.Cln;
    a.f.b.j.p(localObject2, "classProto.enumEntryList");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Map)new LinkedHashMap(a.i.e.iE(ad.TQ(a.a.j.d((Iterable)localObject3)), 16));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      a.k localk = (a.k)localObject4;
      c localc = this.CzN.CyY.BOc;
      a.f.b.j.p(localk, "it");
      ((Map)localObject2).put(r.b(localc, localk.ClT), localObject4);
    }
    this.CzR = ((Map)localObject2);
    this.CzS = localObject1.CyY.CiZ.BRT.j((b)new d.c.a(this));
    this.BZr = localObject1.CyY.CiZ.BRT.l((a)new d.c.b(this));
    AppMethodBeat.o(122371);
  }
  
  public final a.j.b.a.c.b.e B(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(122370);
    a.f.b.j.q(paramf, "name");
    paramf = (a.j.b.a.c.b.e)this.CzS.S(paramf);
    AppMethodBeat.o(122370);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.d.c
 * JD-Core Version:    0.7.0.1
 */