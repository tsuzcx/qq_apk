package a.j.b.a.c.d.b;

import a.f.b.j;
import a.j.b.a.c.e.a.aa;
import a.j.b.a.c.e.b.b;
import a.j.b.a.c.j.a.n;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.p;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements n
{
  public static final g Cjh;
  
  static
  {
    AppMethodBeat.i(120264);
    Cjh = new g();
    AppMethodBeat.o(120264);
  }
  
  public final w a(a.aa paramaa, String paramString, ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(120263);
    j.q(paramaa, "proto");
    j.q(paramString, "flexibleId");
    j.q(paramad1, "lowerBound");
    j.q(paramad2, "upperBound");
    if ((j.e(paramString, "kotlin.jvm.PlatformType") ^ true))
    {
      paramaa = p.azj("Error java flexible type with id: " + paramString + ". (" + paramad1 + ".." + paramad2 + ')');
      j.p(paramaa, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
      paramaa = (w)paramaa;
      AppMethodBeat.o(120263);
      return paramaa;
    }
    if (paramaa.c(b.Cpt))
    {
      paramaa = (w)new a.j.b.a.c.d.a.c.b.g(paramad1, paramad2);
      AppMethodBeat.o(120263);
      return paramaa;
    }
    paramaa = (w)x.a(paramad1, paramad2);
    AppMethodBeat.o(120263);
    return paramaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.b.g
 * JD-Core Version:    0.7.0.1
 */