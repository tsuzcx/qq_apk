package a.j.b.a.c.l.a;

import a.a.v;
import a.f.b.j;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.az;
import a.j.b.a.c.l.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class e
  extends ad
{
  private final g BXb;
  private final a CCl;
  final f CCm;
  final az CCn;
  private final boolean Cwx;
  
  public e(a parama, f paramf, az paramaz, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(122726);
    this.CCl = parama;
    this.CCm = paramf;
    this.CCn = paramaz;
    this.BXb = paramg;
    this.Cwx = paramBoolean;
    AppMethodBeat.o(122726);
  }
  
  public e(a parama, az paramaz, ap paramap)
  {
    this(parama, new f(paramap), paramaz);
    AppMethodBeat.i(122728);
    AppMethodBeat.o(122728);
  }
  
  private e k(g paramg)
  {
    AppMethodBeat.i(122720);
    j.q(paramg, "newAnnotations");
    paramg = new e(this.CCl, this.CCm, this.CCn, paramg, this.Cwx);
    AppMethodBeat.o(122720);
    return paramg;
  }
  
  private e sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(122723);
    e locale = new e(this.CCl, this.CCm, this.CCn, this.BXb, paramBoolean);
    AppMethodBeat.o(122723);
    return locale;
  }
  
  public final g ecM()
  {
    return this.BXb;
  }
  
  public final h ecq()
  {
    AppMethodBeat.i(122719);
    h localh = p.cE("No member resolution should be done on captured type!", true);
    j.p(localh, "ErrorUtils.createErrorSc…on captured type!\", true)");
    AppMethodBeat.o(122719);
    return localh;
  }
  
  public final boolean egH()
  {
    return this.Cwx;
  }
  
  public final List<ap> enR()
  {
    return (List)v.BMx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.l.a.e
 * JD-Core Version:    0.7.0.1
 */