package a.j.b.a.c.d.a.c;

import a.d;
import a.f;
import a.j.b.a.c.b.ac;
import a.j.b.a.c.d.a.e.t;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements ac
{
  final h Cfb;
  private final a.j.b.a.c.k.a<a.j.b.a.c.f.b, a.j.b.a.c.d.a.c.a.h> Cfe;
  
  public g(b paramb)
  {
    AppMethodBeat.i(119839);
    this.Cfb = new h(paramb, (m)m.a.Cft, (f)new d(null));
    this.Cfe = this.Cfb.Cfj.BRT.eoC();
    AppMethodBeat.o(119839);
  }
  
  private final a.j.b.a.c.d.a.c.a.h l(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119836);
    t localt = this.Cfb.Cfj.CeF.a(paramb);
    a.f.b.j.p(localt, "c.components.finder.find…ge(fqName) ?: return null");
    paramb = (a.j.b.a.c.d.a.c.a.h)this.Cfe.b(paramb, (a.f.a.a)new g.a(this, localt));
    AppMethodBeat.o(119836);
    return paramb;
  }
  
  public final List<a.j.b.a.c.d.a.c.a.h> h(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(119837);
    a.f.b.j.q(paramb, "fqName");
    paramb = a.a.j.df(l(paramb));
    AppMethodBeat.o(119837);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.g
 * JD-Core Version:    0.7.0.1
 */