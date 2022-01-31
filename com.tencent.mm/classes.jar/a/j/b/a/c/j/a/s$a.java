package a.j.b.a.c.j.a;

import a.f.b.j;
import a.j.b.a.c.b.am;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.c.b;
import a.j.b.a.c.e.a.b.a;
import a.j.b.a.c.e.a.b.c;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s$a
  extends s
{
  public final a BUp;
  public final boolean BWA;
  private final a.c Cys;
  public final a.c.b Czk;
  public final a Czl;
  
  public s$a(a.c paramc, c paramc1, h paramh, am paramam, a parama)
  {
    super(paramc1, paramh, paramam, (byte)0);
    AppMethodBeat.i(122296);
    this.Cys = paramc;
    this.Czl = parama;
    this.BUp = r.a(paramc1, this.Cys.Clb);
    paramc1 = (a.c.b)a.j.b.a.c.e.a.b.Col.get(this.Cys.CkK);
    paramc = paramc1;
    if (paramc1 == null) {
      paramc = a.c.b.Clt;
    }
    this.Czk = paramc;
    paramc = a.j.b.a.c.e.a.b.Com.Vo(this.Cys.CkK);
    j.p(paramc, "Flags.IS_INNER.get(classProto.flags)");
    this.BWA = paramc.booleanValue();
    AppMethodBeat.o(122296);
  }
  
  public final a.j.b.a.c.f.b eop()
  {
    AppMethodBeat.i(122295);
    a.j.b.a.c.f.b localb = this.BUp.emc();
    j.p(localb, "classId.asSingleFqName()");
    AppMethodBeat.o(122295);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.j.a.s.a
 * JD-Core Version:    0.7.0.1
 */