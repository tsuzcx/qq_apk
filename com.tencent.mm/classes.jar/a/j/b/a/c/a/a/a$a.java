package a.j.b.a.c.a.a;

import a.f.b.j;
import a.j.b.a.c.f.b;
import a.l.m;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  static a.b a(String paramString, b paramb)
  {
    AppMethodBeat.i(119124);
    b.b.a locala = b.b.BUM;
    j.q(paramb, "packageFqName");
    j.q(paramString, "className");
    b.b[] arrayOfb = b.b.values();
    int k = arrayOfb.length;
    int i = 0;
    int j;
    if (i < k)
    {
      locala = arrayOfb[i];
      if ((j.e(locala.BUK, paramb)) && (m.jw(paramString, locala.BUL)))
      {
        j = 1;
        label72:
        if (j == 0) {
          break label95;
        }
      }
    }
    for (paramb = locala;; paramb = null)
    {
      if (paramb != null) {
        break label107;
      }
      AppMethodBeat.o(119124);
      return null;
      j = 0;
      break label72;
      label95:
      i += 1;
      break;
    }
    label107:
    i = paramb.BUL.length();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(119124);
      throw paramString;
    }
    paramString = paramString.substring(i);
    j.p(paramString, "(this as java.lang.String).substring(startIndex)");
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label197;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString == null) {
        break label263;
      }
      paramString = new a.b(paramb, paramString.intValue());
      AppMethodBeat.o(119124);
      return paramString;
      i = 0;
      break;
      label197:
      k = paramString.length();
      j = 0;
      int m;
      for (i = 0;; i = m + i * 10)
      {
        if (j >= k) {
          break label255;
        }
        m = paramString.charAt(j) - '0';
        if ((m < 0) || (9 < m))
        {
          paramString = null;
          break;
        }
        j += 1;
      }
      label255:
      paramString = Integer.valueOf(i);
    }
    label263:
    AppMethodBeat.o(119124);
    return null;
  }
  
  public static b.b b(String paramString, b paramb)
  {
    AppMethodBeat.i(119125);
    j.q(paramString, "className");
    j.q(paramb, "packageFqName");
    paramString = a(paramString, paramb);
    if (paramString != null)
    {
      paramString = paramString.BUx;
      AppMethodBeat.o(119125);
      return paramString;
    }
    AppMethodBeat.o(119125);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */