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

public final class v
  extends x<Long>
{
  public v(long paramLong)
  {
    super(Long.valueOf(paramLong));
    AppMethodBeat.i(122122);
    AppMethodBeat.o(122122);
  }
  
  public final w b(y paramy)
  {
    AppMethodBeat.i(122120);
    j.q(paramy, "module");
    a locala = g.BRU.BTs;
    j.p(locala, "KotlinBuiltIns.FQ_NAMES.uLong");
    paramy = s.a(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.edE();
      if (paramy != null)
      {
        paramy = (w)paramy;
        AppMethodBeat.o(122120);
        return paramy;
      }
    }
    paramy = p.azj("Unsigned type ULong not found");
    j.p(paramy, "ErrorUtils.createErrorTy…ed type ULong not found\")");
    paramy = (w)paramy;
    AppMethodBeat.o(122120);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122121);
    String str = ((Number)getValue()).longValue() + ".toULong()";
    AppMethodBeat.o(122121);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.i.b.v
 * JD-Core Version:    0.7.0.1
 */