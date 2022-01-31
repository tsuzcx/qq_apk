package a.j.b.a.c.l;

import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.h.c;
import a.j.b.a.c.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends q
  implements aw
{
  private final q CBr;
  private final w CBs;
  
  public s(q paramq, w paramw)
  {
    super(paramq.CBm, paramq.CBn);
    AppMethodBeat.i(122590);
    this.CBr = paramq;
    this.CBs = paramw;
    AppMethodBeat.o(122590);
  }
  
  public final String a(c paramc, i parami)
  {
    AppMethodBeat.i(122588);
    j.q(paramc, "renderer");
    j.q(parami, "options");
    if (parami.enr())
    {
      paramc = paramc.b(this.CBs);
      AppMethodBeat.o(122588);
      return paramc;
    }
    paramc = this.CBr.a(paramc, parami);
    AppMethodBeat.o(122588);
    return paramc;
  }
  
  public final az b(g paramg)
  {
    AppMethodBeat.i(122586);
    j.q(paramg, "newAnnotations");
    paramg = ax.b(this.CBr.b(paramg), this.CBs);
    AppMethodBeat.o(122586);
    return paramg;
  }
  
  public final ad efX()
  {
    AppMethodBeat.i(122589);
    ad localad = this.CBr.efX();
    AppMethodBeat.o(122589);
    return localad;
  }
  
  public final w eoJ()
  {
    return this.CBs;
  }
  
  public final az sr(boolean paramBoolean)
  {
    AppMethodBeat.i(122587);
    az localaz = ax.b(this.CBr.sr(paramBoolean), (w)this.CBs.eoL().sr(paramBoolean));
    AppMethodBeat.o(122587);
    return localaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.l.s
 * JD-Core Version:    0.7.0.1
 */