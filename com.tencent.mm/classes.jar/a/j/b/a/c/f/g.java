package a.j.b.a.c.f;

import a.f.b.j;
import a.l.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
{
  private static final k CqO;
  public static final g CqP;
  
  static
  {
    AppMethodBeat.i(121401);
    CqP = new g();
    CqO = new k("[^\\p{L}\\p{Digit}]");
    AppMethodBeat.o(121401);
  }
  
  public static final String ayX(String paramString)
  {
    AppMethodBeat.i(121400);
    j.q(paramString, "name");
    k localk = CqO;
    paramString = (CharSequence)paramString;
    j.q(paramString, "input");
    j.q("_", "replacement");
    paramString = localk.CGU.matcher(paramString).replaceAll("_");
    j.p(paramString, "nativePattern.matcher(in…).replaceAll(replacement)");
    AppMethodBeat.o(121400);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.f.g
 * JD-Core Version:    0.7.0.1
 */