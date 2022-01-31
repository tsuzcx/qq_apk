package a.j.b.a.c.d.a;

import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.e;
import a.j.b.a.c.c.a.c;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.w;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public static final l a(w paramw, String paramString)
  {
    AppMethodBeat.i(119743);
    j.q(paramw, "receiver$0");
    j.q(paramString, "value");
    Object localObject = paramw.enU().ecR();
    if (((localObject instanceof e)) && (((e)localObject).ecB() == a.j.b.a.c.b.f.BWh))
    {
      paramw = ((e)localObject).edJ();
      paramString = a.j.b.a.c.f.f.ayT(paramString);
      j.p(paramString, "Name.identifier(value)");
      paramw = paramw.c(paramString, (a.j.b.a.c.c.a.a)c.Cbu);
      if (((paramw instanceof e)) && (((e)paramw).ecB() == a.j.b.a.c.b.f.BWi))
      {
        paramw = (l)new h((e)paramw);
        AppMethodBeat.o(119743);
        return paramw;
      }
      AppMethodBeat.o(119743);
      return null;
    }
    localObject = a.j.b.a.c.l.c.a.aA(paramw);
    j.q(paramString, "value");
    String str;
    int i;
    if ((m.jw(paramString, "0x")) || (m.jw(paramString, "0X")))
    {
      paramw = paramString.substring(2);
      j.p(paramw, "(this as java.lang.String).substring(startIndex)");
      paramw = new a.j.b.a.c.n.f(paramw, 16);
      str = paramw.uCl;
      i = paramw.CEY;
    }
    for (;;)
    {
      try
      {
        if (!g.q((w)localObject)) {
          continue;
        }
        bool = Boolean.parseBoolean(paramString);
        paramString = Boolean.valueOf(bool);
      }
      catch (IllegalArgumentException paramw)
      {
        boolean bool;
        paramString = null;
        continue;
        AppMethodBeat.o(119743);
        return null;
      }
      if (paramString != null)
      {
        paramw = (l)new f(paramString);
        AppMethodBeat.o(119743);
        return paramw;
        if ((m.jw(paramString, "0b")) || (m.jw(paramString, "0B")))
        {
          paramw = paramString.substring(2);
          j.p(paramw, "(this as java.lang.String).substring(startIndex)");
          paramw = new a.j.b.a.c.n.f(paramw, 2);
          break;
        }
        paramw = new a.j.b.a.c.n.f(paramString, 10);
        break;
        if (g.r((w)localObject))
        {
          paramw = (CharSequence)paramString;
          j.q(paramw, "receiver$0");
          if (paramw.length() != 1) {
            break label552;
          }
          paramString = Character.valueOf(paramw.charAt(0));
          continue;
        }
        if (g.t((w)localObject))
        {
          j.q(str, "receiver$0");
          paramw = m.fn(str, i);
          if (paramw != null)
          {
            i = paramw.intValue();
            if ((i < -128) || (i > 127)) {
              break label557;
            }
            paramString = Byte.valueOf((byte)i);
          }
        }
        else if (g.v((w)localObject))
        {
          j.q(str, "receiver$0");
          paramw = m.fn(str, i);
          if (paramw != null)
          {
            i = paramw.intValue();
            if ((i < -32768) || (i > 32767)) {
              break label562;
            }
            paramString = Short.valueOf((short)i);
          }
        }
        else
        {
          if (g.s((w)localObject))
          {
            paramString = m.fn(str, i);
            continue;
          }
          if (g.u((w)localObject))
          {
            paramString = m.fo(str, i);
            continue;
          }
          if (g.w((w)localObject))
          {
            paramString = m.azs(paramString);
            continue;
          }
          if (g.x((w)localObject))
          {
            paramString = m.azt(paramString);
            continue;
          }
          bool = g.E((w)localObject);
          if (bool) {
            continue;
          }
        }
        paramString = null;
        continue;
      }
      label552:
      paramString = null;
      continue;
      label557:
      paramString = null;
      continue;
      label562:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.u
 * JD-Core Version:    0.7.0.1
 */