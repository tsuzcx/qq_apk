package a.j.b.a.c.i.b;

import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.s;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.a;
import a.j.b.a.c.l.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends x<Short>
{
  public w(short paramShort)
  {
    super(Short.valueOf(paramShort));
    AppMethodBeat.i(122125);
    AppMethodBeat.o(122125);
  }
  
  public final a.j.b.a.c.l.w b(y paramy)
  {
    AppMethodBeat.i(122123);
    j.q(paramy, "module");
    a locala = g.BRU.BTq;
    j.p(locala, "KotlinBuiltIns.FQ_NAMES.uShort");
    paramy = s.a(paramy, locala);
    if (paramy != null)
    {
      paramy = paramy.edE();
      if (paramy != null)
      {
        paramy = (a.j.b.a.c.l.w)paramy;
        AppMethodBeat.o(122123);
        return paramy;
      }
    }
    paramy = p.azj("Unsigned type UShort not found");
    j.p(paramy, "ErrorUtils.createErrorTy…d type UShort not found\")");
    paramy = (a.j.b.a.c.l.w)paramy;
    AppMethodBeat.o(122123);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122124);
    String str = ((Number)getValue()).shortValue() + ".toUShort()";
    AppMethodBeat.o(122124);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.i.b.w
 * JD-Core Version:    0.7.0.1
 */