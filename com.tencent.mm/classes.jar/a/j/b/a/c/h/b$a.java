package a.j.b.a.c.h;

import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.h;
import a.j.b.a.c.b.l;
import a.j.b.a.c.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
  implements b
{
  public static final a Ctr;
  
  static
  {
    AppMethodBeat.i(121700);
    Ctr = new a();
    AppMethodBeat.o(121700);
  }
  
  public final String a(h paramh, c paramc)
  {
    AppMethodBeat.i(121699);
    j.q(paramh, "classifier");
    j.q(paramc, "renderer");
    if ((paramh instanceof ar))
    {
      paramh = ((ar)paramh).edF();
      j.p(paramh, "classifier.name");
      paramh = paramc.b(paramh, false);
      AppMethodBeat.o(121699);
      return paramh;
    }
    paramh = d.n((l)paramh);
    j.p(paramh, "DescriptorUtils.getFqName(classifier)");
    paramh = paramc.f(paramh);
    AppMethodBeat.o(121699);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.h.b.a
 * JD-Core Version:    0.7.0.1
 */