package a.j.b.a.c.d.a;

import a.aa;
import a.j.b.a.c.f.f;
import a.j.b.a.c.m.a.a;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class s
{
  private static final f a(f paramf, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(119724);
    if (paramf.CqN)
    {
      AppMethodBeat.o(119724);
      return null;
    }
    String str = paramf.emk();
    a.f.b.j.p(str, "methodName.identifier");
    if (!m.jw(str, paramString1))
    {
      AppMethodBeat.o(119724);
      return null;
    }
    if (str.length() == paramString1.length())
    {
      AppMethodBeat.o(119724);
      return null;
    }
    int i = str.charAt(paramString1.length());
    if (97 > i) {}
    while (paramString2 != null) {
      if ((aa.BMh) && (!paramBoolean))
      {
        paramf = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(119724);
        throw paramf;
        if (122 >= i)
        {
          AppMethodBeat.o(119724);
          return null;
        }
      }
      else
      {
        paramf = f.ayT(paramString2 + m.b(str, (CharSequence)paramString1));
        AppMethodBeat.o(119724);
        return paramf;
      }
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(119724);
      return paramf;
    }
    paramf = a.azn(m.b(str, (CharSequence)paramString1));
    if (!f.ayU(paramf))
    {
      AppMethodBeat.o(119724);
      return null;
    }
    paramf = f.ayT(paramf);
    AppMethodBeat.o(119724);
    return paramf;
  }
  
  private static f a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(119723);
    a.f.b.j.q(paramf, "methodName");
    if (paramBoolean) {}
    for (String str = "is";; str = null)
    {
      paramf = a(paramf, "set", false, str, 4);
      AppMethodBeat.o(119723);
      return paramf;
    }
  }
  
  public static final List<f> j(f paramf)
  {
    AppMethodBeat.i(119726);
    a.f.b.j.q(paramf, "name");
    Object localObject = paramf.name;
    a.f.b.j.p(localObject, "name.asString()");
    if (o.ayD((String)localObject))
    {
      a.f.b.j.q(paramf, "methodName");
      f localf = a(paramf, "get", false, null, 12);
      localObject = localf;
      if (localf == null) {
        localObject = a(paramf, "is", false, null, 8);
      }
      paramf = a.a.j.df(localObject);
      AppMethodBeat.o(119726);
      return paramf;
    }
    if (o.ayE((String)localObject))
    {
      a.f.b.j.q(paramf, "methodName");
      paramf = a.a.j.k((Iterable)a.a.j.listOf(new f[] { a(paramf, false), a(paramf, true) }));
      AppMethodBeat.o(119726);
      return paramf;
    }
    localObject = e.CcN;
    paramf = e.i(paramf);
    AppMethodBeat.o(119726);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.s
 * JD-Core Version:    0.7.0.1
 */