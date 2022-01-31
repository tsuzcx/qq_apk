package a.j.b.a.c.b.a;

import a.f.b.j;
import a.j.b.a.c.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class g$b
{
  public static c a(g paramg, b paramb)
  {
    AppMethodBeat.i(119334);
    j.q(paramb, "fqName");
    Iterator localIterator = ((Iterable)paramg).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramg = localIterator.next();
    } while (!j.e(((c)paramg).eee(), paramb));
    for (;;)
    {
      paramg = (c)paramg;
      AppMethodBeat.o(119334);
      return paramg;
      paramg = null;
    }
  }
  
  public static boolean b(g paramg, b paramb)
  {
    AppMethodBeat.i(119335);
    j.q(paramb, "fqName");
    if (paramg.i(paramb) != null)
    {
      AppMethodBeat.o(119335);
      return true;
    }
    AppMethodBeat.o(119335);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.a.g.b
 * JD-Core Version:    0.7.0.1
 */