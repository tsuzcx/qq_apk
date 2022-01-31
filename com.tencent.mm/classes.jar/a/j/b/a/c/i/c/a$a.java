package a.j.b.a.c.i.c;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.i.e.j.a;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

final class a$a
  extends k
  implements m<h, Boolean, y>
{
  a$a(e parame, LinkedHashSet paramLinkedHashSet)
  {
    super(2);
  }
  
  public final void a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(122127);
    j.q(paramh, "scope");
    paramh = j.a.a(paramh, a.j.b.a.c.i.e.d.CxF, null, 2).iterator();
    while (paramh.hasNext())
    {
      Object localObject = (l)paramh.next();
      if ((localObject instanceof e))
      {
        if (a.j.b.a.c.i.d.b((e)localObject, this.CwL)) {
          this.CwM.add(localObject);
        }
        if (paramBoolean)
        {
          a locala = (a)this;
          localObject = ((e)localObject).edJ();
          j.p(localObject, "descriptor.unsubstitutedInnerClassesScope");
          locala.a((h)localObject, paramBoolean);
        }
      }
    }
    AppMethodBeat.o(122127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.i.c.a.a
 * JD-Core Version:    0.7.0.1
 */