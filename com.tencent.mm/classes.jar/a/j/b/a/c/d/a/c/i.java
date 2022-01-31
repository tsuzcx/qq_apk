package a.j.b.a.c.d.a.c;

import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.l;
import a.j.b.a.c.d.a.c.a.n;
import a.j.b.a.c.d.a.e.w;
import a.j.b.a.c.d.a.e.x;
import a.j.b.a.c.k.d;
import a.j.b.a.c.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class i
  implements m
{
  final l BZh;
  final h Cfb;
  final Map<w, Integer> Cfm;
  private final d<w, n> Cfn;
  final int Cfo;
  
  public i(h paramh, l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(119845);
    this.Cfb = paramh;
    this.BZh = paraml;
    this.Cfo = paramInt;
    this.Cfm = a.y((Iterable)paramx.edr());
    this.Cfn = this.Cfb.Cfj.BRT.j((a.f.a.b)new i.a(this));
    AppMethodBeat.o(119845);
  }
  
  public final ar a(w paramw)
  {
    AppMethodBeat.i(119844);
    j.q(paramw, "javaTypeParameter");
    n localn = (n)this.Cfn.S(paramw);
    if (localn != null)
    {
      paramw = (ar)localn;
      AppMethodBeat.o(119844);
      return paramw;
    }
    paramw = this.Cfb.Cfk.a(paramw);
    AppMethodBeat.o(119844);
    return paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */