package a.j.b.a.c.j.a.a;

import a.j.b.a.c.a.g;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.ap.a;
import a.j.b.a.c.b.c.b;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.ae;
import a.j.b.a.c.e.a.ae.b;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.f.f;
import a.j.b.a.c.j.a.k;
import a.j.b.a.c.j.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class l
  extends b
{
  private final a CAs;
  final a.ae CAt;
  final k CyY;
  
  public l(k paramk, a.ae paramae, int paramInt)
  {
    super(locali, locall, localf, t.b((a.ae.b)localObject), paramae.Cnq, paramInt, am.BWF, (ap)ap.a.BWH);
    AppMethodBeat.i(122430);
    this.CyY = paramk;
    this.CAt = paramae;
    this.CAs = new a(this.CyY.CiZ.BRT, (a.f.a.a)new l.a(this));
    AppMethodBeat.o(122430);
  }
  
  public final List<a.j.b.a.c.l.w> eeP()
  {
    AppMethodBeat.i(122428);
    Object localObject4 = this.CAt;
    Object localObject3 = this.CyY.BOd;
    a.f.b.j.q(localObject4, "receiver$0");
    a.f.b.j.q(localObject3, "typeTable");
    Object localObject1 = ((a.ae)localObject4).Cns;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label155;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label165;
      }
      localObject1 = ((a.ae)localObject4).Cnt;
      a.f.b.j.p(localObject1, "upperBoundIdList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject2).next();
        a.f.b.j.p(localObject4, "it");
        ((Collection)localObject1).add(((h)localObject3).Vs(((Integer)localObject4).intValue()));
      }
      i = 0;
      break;
      label155:
      localObject1 = null;
    }
    Object localObject2 = (List)localObject1;
    label165:
    if (((List)localObject2).isEmpty())
    {
      localObject1 = a.a.j.listOf(a.j.b.a.c.i.c.a.G((a.j.b.a.c.b.l)this).ecm());
      AppMethodBeat.o(122428);
      return localObject1;
    }
    localObject3 = (Iterable)localObject2;
    localObject1 = this.CyY.CyQ;
    localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((a.j.b.a.c.j.a.w)localObject1).r((a.aa)((Iterator)localObject3).next()));
    }
    localObject1 = (List)localObject2;
    AppMethodBeat.o(122428);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.l
 * JD-Core Version:    0.7.0.1
 */