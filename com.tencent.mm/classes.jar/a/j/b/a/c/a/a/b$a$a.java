package a.j.b.a.c.a.a;

import a.f.a.m;
import a.f.b.k;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.e;
import a.j.b.a.c.c.a.a;
import a.j.b.a.c.c.a.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class b$a$a
  extends k
  implements m<ab, f, y>
{
  b$a$a(b.a parama, ArrayList paramArrayList)
  {
    super(2);
  }
  
  public final void a(ab paramab, f paramf)
  {
    AppMethodBeat.i(119139);
    a.f.b.j.q(paramab, "packageFragment");
    a.f.b.j.q(paramf, "name");
    Object localObject2 = paramab.ecq().c(paramf, (a)c.Cbw);
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject1 = (e)localObject1;
    if (localObject1 == null)
    {
      paramab = (Throwable)new IllegalStateException(("Class " + paramf + " not found in " + paramab).toString());
      AppMethodBeat.o(119139);
      throw paramab;
    }
    paramab = ((e)localObject1).ecx();
    a.f.b.j.p(paramab, "descriptor.typeConstructor");
    paramf = (Iterable)a.a.j.x(this.BUE.getParameters(), paramab.getParameters().size());
    paramab = (Collection)new ArrayList(a.a.j.d(paramf));
    paramf = paramf.iterator();
    while (paramf.hasNext()) {
      paramab.add(new a.j.b.a.c.l.ar((w)((a.j.b.a.c.b.ar)paramf.next()).edE()));
    }
    paramab = (List)paramab;
    paramf = this.BUD;
    localObject2 = g.BXx;
    paramf.add(x.a(g.a.eeH(), (e)localObject1, paramab));
    AppMethodBeat.o(119139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */