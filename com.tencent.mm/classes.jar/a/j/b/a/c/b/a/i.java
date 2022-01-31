package a.j.b.a.c.b.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static final g a(g paramg1, g paramg2)
  {
    AppMethodBeat.i(119342);
    j.q(paramg1, "first");
    j.q(paramg2, "second");
    if (paramg1.isEmpty())
    {
      AppMethodBeat.o(119342);
      return paramg2;
    }
    if (paramg2.isEmpty())
    {
      AppMethodBeat.o(119342);
      return paramg1;
    }
    paramg1 = (g)new k(new g[] { paramg1, paramg2 });
    AppMethodBeat.o(119342);
    return paramg1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.b.a.i
 * JD-Core Version:    0.7.0.1
 */