package a.j.b.a.c.i.b;

import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.s;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.a;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends x<Integer>
{
  public u(int paramInt)
  {
    super(Integer.valueOf(paramInt));
    AppMethodBeat.i(122119);
    AppMethodBeat.o(122119);
  }
  
  public final w b(y paramy)
  {
    AppMethodBeat.i(122117);
    j.q(paramy, "module");
    a locala = g.BRU.BTr;
    j.p(locala, "KotlinBuiltIns.FQ_NAMES.uInt");
    paramy = s.a(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.edE();
      if (paramy != null)
      {
        paramy = (w)paramy;
        AppMethodBeat.o(122117);
        return paramy;
      }
    }
    paramy = p.azj("Unsigned type UInt not found");
    j.p(paramy, "ErrorUtils.createErrorTy…ned type UInt not found\")");
    paramy = (w)paramy;
    AppMethodBeat.o(122117);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122118);
    String str = ((Number)getValue()).intValue() + ".toUInt()";
    AppMethodBeat.o(122118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.i.b.u
 * JD-Core Version:    0.7.0.1
 */