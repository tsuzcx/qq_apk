package a.j.b.a.c.j.a.a;

import a.j.b.a.c.b.aa.b;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.ap.a;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.e;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.f.c;
import a.j.b.a.c.j.a.k;
import a.j.b.a.c.j.a.m;
import a.j.b.a.c.l.an;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class d$b
  extends a.j.b.a.c.l.b
{
  private final a.j.b.a.c.k.f<List<ar>> CfR;
  
  public d$b()
  {
    super(localObject.CyY.CiZ.BRT);
    AppMethodBeat.i(122366);
    this.CfR = localObject.CyY.CiZ.BRT.l((a.f.a.a)new d.b.a(this));
    AppMethodBeat.o(122366);
  }
  
  public final Collection<a.j.b.a.c.l.w> ecQ()
  {
    AppMethodBeat.i(122363);
    Object localObject4 = this.CzN.Cys;
    Object localObject3 = this.CzN.CyY.BOd;
    a.f.b.j.q(localObject4, "receiver$0");
    a.f.b.j.q(localObject3, "typeTable");
    Object localObject1 = ((a.c)localObject4).Cle;
    int i;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label161;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label171;
      }
      localObject1 = ((a.c)localObject4).Clf;
      a.f.b.j.p(localObject1, "supertypeIdList");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Integer)((Iterator)localObject2).next();
        a.f.b.j.p(localObject4, "it");
        ((Collection)localObject1).add(((a.j.b.a.c.e.a.h)localObject3).Vs(((Integer)localObject4).intValue()));
      }
      i = 0;
      break;
      label161:
      localObject1 = null;
    }
    Object localObject2 = (List)localObject1;
    label171:
    localObject2 = (Iterable)localObject2;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (a.aa)((Iterator)localObject2).next();
      ((Collection)localObject1).add(this.CzN.CyY.CyQ.r((a.aa)localObject3));
    }
    localObject3 = a.a.j.b((Collection)localObject1, (Iterable)this.CzN.CyY.CiZ.CyM.l((e)this.CzN));
    localObject1 = (Iterable)localObject3;
    localObject4 = (Collection)new ArrayList();
    Object localObject5 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      localObject2 = ((a.j.b.a.c.l.w)((Iterator)localObject5).next()).enU().ecR();
      localObject1 = localObject2;
      if (!(localObject2 instanceof aa.b)) {
        localObject1 = null;
      }
      localObject1 = (aa.b)localObject1;
      if (localObject1 != null) {
        ((Collection)localObject4).add(localObject1);
      }
    }
    localObject1 = (List)localObject4;
    if (!((Collection)localObject1).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label541;
      }
      localObject2 = this.CzN.CyY.CiZ.CeJ;
      localObject4 = (e)this.CzN;
      localObject1 = (Iterable)localObject1;
      localObject5 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      label446:
      if (!localIterator.hasNext()) {
        break label528;
      }
      aa.b localb = (aa.b)localIterator.next();
      localObject1 = a.j.b.a.c.i.c.a.c((a.j.b.a.c.b.h)localb);
      if (localObject1 != null)
      {
        localObject1 = ((a.j.b.a.c.f.a)localObject1).emc();
        if (localObject1 != null)
        {
          localObject1 = ((a.j.b.a.c.f.b)localObject1).CqE.CqJ;
          if (localObject1 != null) {
            break label560;
          }
        }
      }
      localObject1 = localb.BYN.name;
    }
    label528:
    label541:
    label560:
    for (;;)
    {
      ((Collection)localObject5).add(localObject1);
      break label446;
      i = 0;
      break;
      ((m)localObject2).a((e)localObject4, (List)localObject5);
      localObject1 = (Collection)a.a.j.m((Iterable)localObject3);
      AppMethodBeat.o(122363);
      return localObject1;
    }
  }
  
  public final boolean ecT()
  {
    return true;
  }
  
  public final ap ecU()
  {
    return (ap)ap.a.BWH;
  }
  
  public final List<ar> getParameters()
  {
    AppMethodBeat.i(122364);
    List localList = (List)this.CfR.invoke();
    AppMethodBeat.o(122364);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122365);
    String str = this.CzN.BYN.toString();
    a.f.b.j.p(str, "name.toString()");
    AppMethodBeat.o(122365);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.d.b
 * JD-Core Version:    0.7.0.1
 */