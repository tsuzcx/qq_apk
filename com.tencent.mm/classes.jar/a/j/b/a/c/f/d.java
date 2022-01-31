package a.j.b.a.c.f;

import a.f.b.j;
import a.l.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static boolean a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(121389);
    j.q(paramb1, "receiver$0");
    j.q(paramb2, "packageName");
    if (j.e(paramb1, paramb2))
    {
      AppMethodBeat.o(121389);
      return true;
    }
    if (paramb2.isRoot())
    {
      AppMethodBeat.o(121389);
      return true;
    }
    paramb1 = paramb1.CqE.CqJ;
    j.p(paramb1, "this.asString()");
    paramb2 = paramb2.CqE.CqJ;
    j.p(paramb2, "packageName.asString()");
    if ((m.jw(paramb1, paramb2)) && (paramb1.charAt(paramb2.length()) == '.'))
    {
      AppMethodBeat.o(121389);
      return true;
    }
    AppMethodBeat.o(121389);
    return false;
  }
  
  public static final b b(b paramb1, b paramb2)
  {
    AppMethodBeat.i(121390);
    j.q(paramb1, "receiver$0");
    j.q(paramb2, "prefix");
    if ((!a(paramb1, paramb2)) || (paramb2.isRoot()))
    {
      AppMethodBeat.o(121390);
      return paramb1;
    }
    if (j.e(paramb1, paramb2))
    {
      paramb1 = b.CqD;
      j.p(paramb1, "FqName.ROOT");
      AppMethodBeat.o(121390);
      return paramb1;
    }
    paramb1 = paramb1.CqE.CqJ;
    j.p(paramb1, "asString()");
    int i = paramb2.CqE.CqJ.length();
    if (paramb1 == null)
    {
      paramb1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(121390);
      throw paramb1;
    }
    paramb1 = paramb1.substring(i + 1);
    j.p(paramb1, "(this as java.lang.String).substring(startIndex)");
    paramb1 = new b(paramb1);
    AppMethodBeat.o(121390);
    return paramb1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.f.d
 * JD-Core Version:    0.7.0.1
 */