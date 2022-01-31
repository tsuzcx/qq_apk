package a.j.b.a.c.d.b;

import a.aa;
import a.f.b.j;
import a.j.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements a.j.b.a.c.j.a.f
{
  private final m CeG;
  private final e CeH;
  
  public f(m paramm, e parame)
  {
    AppMethodBeat.i(120262);
    this.CeG = paramm;
    this.CeH = parame;
    AppMethodBeat.o(120262);
  }
  
  public final a.j.b.a.c.j.a.e g(a parama)
  {
    AppMethodBeat.i(120261);
    j.q(parama, "classId");
    n localn = this.CeG.b(parama);
    if (localn == null)
    {
      AppMethodBeat.o(120261);
      return null;
    }
    boolean bool = j.e(localn.ebx(), parama);
    if ((aa.BMh) && (!bool))
    {
      parama = (Throwable)new AssertionError("Class with incorrect id found: expected " + parama + ", actual " + localn.ebx());
      AppMethodBeat.o(120261);
      throw parama;
    }
    parama = this.CeH.a(localn);
    AppMethodBeat.o(120261);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.b.f
 * JD-Core Version:    0.7.0.1
 */