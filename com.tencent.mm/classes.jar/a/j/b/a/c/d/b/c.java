package a.j.b.a.c.d.b;

import a.f.b.j;
import a.j.b.a.c.b.aa;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.s;
import a.j.b.a.c.b.y;
import a.j.b.a.c.i.b.f;
import a.j.b.a.c.k.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c
  extends a<a.j.b.a.c.b.a.c, f<?>>
{
  private final aa BUa;
  private final y BUv;
  private final a.j.b.a.c.j.a.c CiQ;
  
  public c(y paramy, aa paramaa, i parami, m paramm)
  {
    super(parami, paramm);
    AppMethodBeat.i(120248);
    this.BUv = paramy;
    this.BUa = paramaa;
    this.CiQ = new a.j.b.a.c.j.a.c(this.BUv, this.BUa);
    AppMethodBeat.o(120248);
  }
  
  private final e f(a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(120247);
    parama = s.a(this.BUv, parama, this.BUa);
    AppMethodBeat.o(120247);
    return parama;
  }
  
  protected final n.a a(a.j.b.a.c.f.a parama, am paramam, List<a.j.b.a.c.b.a.c> paramList)
  {
    AppMethodBeat.i(120246);
    j.q(parama, "annotationClassId");
    j.q(paramam, "source");
    j.q(paramList, "result");
    parama = (n.a)new c.a(this, f(parama), paramList, paramam);
    AppMethodBeat.o(120246);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.d.b.c
 * JD-Core Version:    0.7.0.1
 */