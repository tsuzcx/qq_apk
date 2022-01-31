package a.j.b.a.c.d.a.f;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.j.b.a.c.d.a.a.a;
import a.j.b.a.c.d.a.c.a;
import a.j.b.a.c.d.a.c.d;
import a.j.b.a.c.d.a.c.h;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.w;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class l$b$f
  extends k
  implements m<w, h, y>
{
  l$b$f(ArrayList paramArrayList)
  {
    super(2);
  }
  
  public final void a(w paramw, h paramh)
  {
    AppMethodBeat.i(120157);
    j.q(paramw, "type");
    j.q(paramh, "ownerContext");
    h localh = a.b(paramh, paramw.ecM());
    Object localObject = this.Cil;
    paramh = localh.efL();
    if (paramh != null)
    {
      paramh = paramh.b(a.a.CbW);
      ((ArrayList)localObject).add(new p(paramw, paramh));
      paramw = paramw.enR().iterator();
    }
    for (;;)
    {
      if (!paramw.hasNext()) {
        break label173;
      }
      paramh = (ap)paramw.next();
      if (paramh.eoN())
      {
        localObject = this.Cil;
        paramh = paramh.eer();
        j.p(paramh, "arg.type");
        ((ArrayList)localObject).add(new p(paramh, null));
        continue;
        paramh = null;
        break;
      }
      localObject = (f)this;
      paramh = paramh.eer();
      j.p(paramh, "arg.type");
      ((f)localObject).a(paramh, localh);
    }
    label173:
    AppMethodBeat.o(120157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.l.b.f
 * JD-Core Version:    0.7.0.1
 */