package a.j.b.a.e;

import a.a.v;
import a.f.b.j;
import a.j.b.a.c.f.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

@l(eaO={1, 1, 13})
public final class f$a
{
  public static c a(f paramf, b paramb)
  {
    AppMethodBeat.i(123034);
    j.q(paramb, "fqName");
    paramf = paramf.epf();
    if (paramf != null)
    {
      paramf = paramf.getDeclaredAnnotations();
      if (paramf != null)
      {
        paramf = g.a(paramf, paramb);
        AppMethodBeat.o(123034);
        return paramf;
      }
    }
    AppMethodBeat.o(123034);
    return null;
  }
  
  public static List<c> a(f paramf)
  {
    AppMethodBeat.i(123033);
    paramf = paramf.epf();
    if (paramf != null)
    {
      paramf = paramf.getDeclaredAnnotations();
      if (paramf != null)
      {
        paramf = g.a(paramf);
        AppMethodBeat.o(123033);
        return paramf;
      }
    }
    paramf = (List)v.BMx;
    AppMethodBeat.o(123033);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.e.f.a
 * JD-Core Version:    0.7.0.1
 */