package a.j.b.a.c.d.a.c.b;

import a.f.a.b;
import a.f.b.k;
import a.j.b.a.c.h.c;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class g$b
  extends k
  implements b<w, List<? extends String>>
{
  g$b(c paramc)
  {
    super(1);
  }
  
  public final List<String> Q(w paramw)
  {
    AppMethodBeat.i(120067);
    a.f.b.j.q(paramw, "type");
    Object localObject = (Iterable)paramw.enR();
    paramw = (Collection)new ArrayList(a.a.j.d((Iterable)localObject));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ap localap = (ap)((Iterator)localObject).next();
      paramw.add(this.Chg.a(localap));
    }
    paramw = (List)paramw;
    AppMethodBeat.o(120067);
    return paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.g.b
 * JD-Core Version:    0.7.0.1
 */