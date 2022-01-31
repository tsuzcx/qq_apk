package a.j.b.a.c.b.c;

import a.a.v;
import a.f.b.j;
import a.j.b.a.c.b.ad;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.c.b;
import a.j.b.a.c.i.e.d;
import a.j.b.a.c.i.e.i;
import a.j.b.a.c.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ae
  extends i
{
  private final y BVj;
  private final a.j.b.a.c.f.b BXD;
  
  public ae(y paramy, a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119589);
    this.BVj = paramy;
    this.BXD = paramb;
    AppMethodBeat.o(119589);
  }
  
  public final Collection<l> a(d paramd, a.f.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(119588);
    j.q(paramd, "kindFilter");
    j.q(paramb, "nameFilter");
    Object localObject = d.CxM;
    if (!paramd.VQ(d.eoe()))
    {
      paramd = (Collection)v.BMx;
      AppMethodBeat.o(119588);
      return paramd;
    }
    if ((this.BXD.CqE.CqJ.isEmpty()) && (paramd.Cxo.contains(c.b.Cxm)))
    {
      paramd = (Collection)v.BMx;
      AppMethodBeat.o(119588);
      return paramd;
    }
    paramd = this.BVj.a(this.BXD, paramb);
    ArrayList localArrayList = new ArrayList(paramd.size());
    Iterator localIterator = paramd.iterator();
    while (localIterator.hasNext())
    {
      localObject = ((a.j.b.a.c.f.b)localIterator.next()).CqE.emh();
      j.p(localObject, "subFqName.shortName()");
      if (((Boolean)paramb.S(localObject)).booleanValue())
      {
        Collection localCollection = (Collection)localArrayList;
        j.q(localObject, "name");
        if (((f)localObject).CqN) {
          paramd = null;
        }
        for (;;)
        {
          a.b(localCollection, paramd);
          break;
          paramd = this.BVj;
          localObject = this.BXD.q((f)localObject);
          j.p(localObject, "fqName.child(name)");
          localObject = paramd.g((a.j.b.a.c.f.b)localObject);
          paramd = (d)localObject;
          if (((ad)localObject).isEmpty()) {
            paramd = null;
          }
        }
      }
    }
    paramd = (Collection)localArrayList;
    AppMethodBeat.o(119588);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.b.c.ae
 * JD-Core Version:    0.7.0.1
 */