package a.j.b.a.c.b.a;

import a.a.e;
import a.k.h;
import a.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class k
  implements g
{
  private final List<g> BXG;
  
  public k(List<? extends g> paramList)
  {
    AppMethodBeat.i(119355);
    this.BXG = paramList;
    AppMethodBeat.o(119355);
  }
  
  public k(g... paramVarArgs)
  {
    this(e.R(paramVarArgs));
    AppMethodBeat.i(119356);
    AppMethodBeat.o(119356);
  }
  
  public final c i(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119353);
    a.f.b.j.q(paramb, "fqName");
    paramb = i.e(a.a.j.t((Iterable)this.BXG), (a.f.a.b)new k.a(paramb));
    a.f.b.j.q(paramb, "receiver$0");
    paramb = paramb.iterator();
    if (!paramb.hasNext()) {}
    for (paramb = null;; paramb = paramb.next())
    {
      paramb = (c)paramb;
      AppMethodBeat.o(119353);
      return paramb;
    }
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(119351);
    Object localObject = (Iterable)this.BXG;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((g)((Iterator)localObject).next()).isEmpty())
        {
          AppMethodBeat.o(119351);
          return false;
        }
      }
    }
    AppMethodBeat.o(119351);
    return true;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(119354);
    Iterator localIterator = i.c(a.a.j.t((Iterable)this.BXG), (a.f.a.b)k.b.BXI).iterator();
    AppMethodBeat.o(119354);
    return localIterator;
  }
  
  public final boolean j(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119352);
    a.f.b.j.q(paramb, "fqName");
    Iterator localIterator = a.a.j.t((Iterable)this.BXG).iterator();
    while (localIterator.hasNext()) {
      if (((g)localIterator.next()).j(paramb))
      {
        AppMethodBeat.o(119352);
        return true;
      }
    }
    AppMethodBeat.o(119352);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.b.a.k
 * JD-Core Version:    0.7.0.1
 */