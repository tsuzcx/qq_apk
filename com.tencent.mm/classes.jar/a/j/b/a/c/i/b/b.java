package a.j.b.a.c.i.b;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.y;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
  extends f<List<? extends f<?>>>
{
  private final a.f.a.b<y, w> CwC;
  
  public b(List<? extends f<?>> paramList, a.f.a.b<? super y, ? extends w> paramb)
  {
    super(paramList);
    AppMethodBeat.i(122069);
    this.CwC = paramb;
    AppMethodBeat.o(122069);
  }
  
  public final w b(y paramy)
  {
    AppMethodBeat.i(122068);
    j.q(paramy, "module");
    paramy = this.CwC.S(paramy);
    w localw = (w)paramy;
    if ((g.n(localw)) || (g.o(localw))) {}
    for (int i = 1; (aa.BMh) && (i == 0); i = 0)
    {
      paramy = (Throwable)new AssertionError("Type should be an array, but was " + localw + ": " + (List)getValue());
      AppMethodBeat.o(122068);
      throw paramy;
    }
    paramy = (w)paramy;
    AppMethodBeat.o(122068);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.i.b.b
 * JD-Core Version:    0.7.0.1
 */