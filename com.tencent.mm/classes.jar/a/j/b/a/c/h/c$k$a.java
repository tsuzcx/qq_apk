package a.j.b.a.c.h;

import a.f.b.j;
import a.j.b.a.c.b.au;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$k$a
  implements c.k
{
  public static final a CtN;
  
  static
  {
    AppMethodBeat.i(121731);
    CtN = new a();
    AppMethodBeat.o(121731);
  }
  
  public final void a(au paramau, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121730);
    j.q(paramau, "parameter");
    j.q(paramStringBuilder, "builder");
    if (paramInt1 != paramInt2 - 1) {
      paramStringBuilder.append(", ");
    }
    AppMethodBeat.o(121730);
  }
  
  public final void a(au paramau, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121729);
    j.q(paramau, "parameter");
    j.q(paramStringBuilder, "builder");
    AppMethodBeat.o(121729);
  }
  
  public final void f(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121727);
    j.q(paramStringBuilder, "builder");
    paramStringBuilder.append("(");
    AppMethodBeat.o(121727);
  }
  
  public final void g(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121728);
    j.q(paramStringBuilder, "builder");
    paramStringBuilder.append(")");
    AppMethodBeat.o(121728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.h.c.k.a
 * JD-Core Version:    0.7.0.1
 */