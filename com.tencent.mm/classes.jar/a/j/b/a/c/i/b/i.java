package a.j.b.a.c.i.b;

import a.f.b.j;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.s;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.a;
import a.j.b.a.c.i.d;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.w;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends f<o<? extends a, ? extends a.j.b.a.c.f.f>>
{
  private final a CwG;
  public final a.j.b.a.c.f.f CwH;
  
  public i(a parama, a.j.b.a.c.f.f paramf)
  {
    super(u.F(parama, paramf));
    AppMethodBeat.i(122089);
    this.CwG = parama;
    this.CwH = paramf;
    AppMethodBeat.o(122089);
  }
  
  public final w b(y paramy)
  {
    AppMethodBeat.i(122087);
    j.q(paramy, "module");
    paramy = s.a(paramy, this.CwG);
    if (paramy != null)
    {
      if (d.y((l)paramy)) {}
      while (paramy != null)
      {
        paramy = paramy.edE();
        if (paramy == null) {
          break;
        }
        paramy = (w)paramy;
        AppMethodBeat.o(122087);
        return paramy;
        paramy = null;
      }
    }
    paramy = p.azj("Containing class for error-class based enum entry " + this.CwG + '.' + this.CwH);
    j.p(paramy, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
    paramy = (w)paramy;
    AppMethodBeat.o(122087);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122088);
    String str = this.CwG.elZ() + '.' + this.CwH;
    AppMethodBeat.o(122088);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.i.b.i
 * JD-Core Version:    0.7.0.1
 */