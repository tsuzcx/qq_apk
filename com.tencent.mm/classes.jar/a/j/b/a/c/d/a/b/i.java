package a.j.b.a.c.d.a.b;

import a.aa;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.c.ai;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.l.w;
import a.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class i
{
  public static final List<au> a(Collection<j> paramCollection, Collection<? extends au> paramCollection1, a.j.b.a.c.b.a parama)
  {
    AppMethodBeat.i(119813);
    a.f.b.j.q(paramCollection, "newValueParametersTypes");
    a.f.b.j.q(paramCollection1, "oldValueParameters");
    a.f.b.j.q(parama, "newOwner");
    if (paramCollection.size() == paramCollection1.size()) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Different value parameters sizes: Enhanced = " + paramCollection.size() + ", Old = " + paramCollection1.size());
      AppMethodBeat.o(119813);
      throw paramCollection;
    }
    paramCollection = (Iterable)a.a.j.a((Iterable)paramCollection, (Iterable)paramCollection1);
    paramCollection1 = (Collection)new ArrayList(a.a.j.d(paramCollection));
    Iterator localIterator = paramCollection.iterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = (o)localIterator.next();
      paramCollection = (j)((o)localObject1).first;
      Object localObject2 = (au)((o)localObject1).second;
      i = ((au)localObject2).getIndex();
      localObject1 = ((au)localObject2).ecM();
      f localf = ((au)localObject2).edF();
      a.f.b.j.p(localf, "oldParameter.name");
      w localw = paramCollection.BPZ;
      boolean bool1 = paramCollection.CeA;
      boolean bool2 = ((au)localObject2).eew();
      boolean bool3 = ((au)localObject2).eex();
      if (((au)localObject2).eeu() != null) {}
      for (paramCollection = a.j.b.a.c.i.c.a.F((a.j.b.a.c.b.l)parama).eec().l(paramCollection.BPZ);; paramCollection = null)
      {
        localObject2 = ((au)localObject2).ecN();
        a.f.b.j.p(localObject2, "oldParameter.source");
        paramCollection1.add(new ai(parama, null, i, (a.j.b.a.c.b.a.g)localObject1, localf, localw, bool1, bool2, bool3, paramCollection, (am)localObject2));
        break;
      }
    }
    paramCollection = (List)paramCollection1;
    AppMethodBeat.o(119813);
    return paramCollection;
  }
  
  public static final a.j.b.a.c.d.a.c.a.l s(e parame)
  {
    AppMethodBeat.i(119814);
    h localh;
    do
    {
      a.f.b.j.q(parame, "receiver$0");
      parame = a.j.b.a.c.i.c.a.z(parame);
      if (parame == null)
      {
        AppMethodBeat.o(119814);
        return null;
      }
      localh = parame.ecw();
      a.f.b.j.p(localh, "superClassDescriptor.staticScope");
    } while (!(localh instanceof a.j.b.a.c.d.a.c.a.l));
    parame = (a.j.b.a.c.d.a.c.a.l)localh;
    AppMethodBeat.o(119814);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.b.i
 * JD-Core Version:    0.7.0.1
 */