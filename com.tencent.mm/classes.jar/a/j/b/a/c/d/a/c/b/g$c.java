package a.j.b.a.c.d.a.c.b;

import a.f.b.j;
import a.f.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$c
  extends k
  implements a.f.a.m<String, String, String>
{
  public static final c Chh;
  
  static
  {
    AppMethodBeat.i(120070);
    Chh = new c();
    AppMethodBeat.o(120070);
  }
  
  g$c()
  {
    super(2);
  }
  
  public static String jn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(120069);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "newArgs");
    if (!a.l.m.b((CharSequence)paramString1, '<'))
    {
      AppMethodBeat.o(120069);
      return paramString1;
    }
    paramString1 = a.l.m.jy(paramString1, paramString1) + '<' + paramString2 + '>' + a.l.m.a(paramString1, '>');
    AppMethodBeat.o(120069);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.g.c
 * JD-Core Version:    0.7.0.1
 */