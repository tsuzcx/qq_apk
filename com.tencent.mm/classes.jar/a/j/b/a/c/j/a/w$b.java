package a.j.b.a.c.j.a;

import a.a.v;
import a.f.a.b;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.a.aa.a;
import a.j.b.a.c.e.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

final class w$b
  extends a.f.b.k
  implements b<a.aa, List<? extends a.aa.a>>
{
  w$b(w paramw)
  {
    super(1);
  }
  
  public final List<a.aa.a> u(a.aa paramaa)
  {
    AppMethodBeat.i(122309);
    a.f.b.j.q(paramaa, "receiver$0");
    Object localObject = paramaa.Ckt;
    a.f.b.j.p(localObject, "argumentList");
    Collection localCollection = (Collection)localObject;
    paramaa = g.b(paramaa, this.Czx.CyY.BOd);
    if (paramaa != null) {}
    for (paramaa = u(paramaa);; paramaa = null)
    {
      localObject = paramaa;
      if (paramaa == null) {
        localObject = (List)v.BMx;
      }
      paramaa = a.a.j.b(localCollection, (Iterable)localObject);
      AppMethodBeat.o(122309);
      return paramaa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.j.a.w.b
 * JD-Core Version:    0.7.0.1
 */