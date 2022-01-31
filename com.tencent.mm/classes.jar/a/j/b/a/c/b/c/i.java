package a.j.b.a.c.b.c;

import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.ac;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class i
  implements ac
{
  private final List<ac> BZp;
  
  public i(List<? extends ac> paramList)
  {
    AppMethodBeat.i(119430);
    this.BZp = paramList;
    AppMethodBeat.o(119430);
  }
  
  public final Collection<a.j.b.a.c.f.b> a(a.j.b.a.c.f.b paramb, a.f.a.b<? super f, Boolean> paramb1)
  {
    AppMethodBeat.i(119429);
    a.f.b.j.q(paramb, "fqName");
    a.f.b.j.q(paramb1, "nameFilter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.BZp.iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll(((ac)localIterator.next()).a(paramb, paramb1));
    }
    paramb = (Collection)localHashSet;
    AppMethodBeat.o(119429);
    return paramb;
  }
  
  public final List<ab> h(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119428);
    a.f.b.j.q(paramb, "fqName");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.BZp.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)((ac)localIterator.next()).h(paramb));
    }
    paramb = a.a.j.m((Iterable)localArrayList);
    AppMethodBeat.o(119428);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.b.c.i
 * JD-Core Version:    0.7.0.1
 */