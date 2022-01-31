package a.j.b.a.c.d.a.c.b;

import a.f.b.j;
import a.f.b.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$a
  extends k
  implements a.f.a.m<String, String, Boolean>
{
  public static final a Chf;
  
  static
  {
    AppMethodBeat.i(120065);
    Chf = new a();
    AppMethodBeat.o(120065);
  }
  
  g$a()
  {
    super(2);
  }
  
  public static boolean jm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(120064);
    j.q(paramString1, "first");
    j.q(paramString2, "second");
    if ((j.e(paramString1, a.l.m.b(paramString2, (CharSequence)"out "))) || (j.e(paramString2, "*")))
    {
      AppMethodBeat.o(120064);
      return true;
    }
    AppMethodBeat.o(120064);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.b.g.a
 * JD-Core Version:    0.7.0.1
 */