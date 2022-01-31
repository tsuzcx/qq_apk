package a.j.b.a.c.m.a;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class a
{
  public static final String azn(String paramString)
  {
    AppMethodBeat.i(122910);
    j.q(paramString, "receiver$0");
    Object localObject2 = new a(paramString);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; (i != 0) || (!((a)localObject2).VW(0)); i = 0)
    {
      AppMethodBeat.o(122910);
      return paramString;
    }
    if ((paramString.length() == 1) || (!((a)localObject2).VW(1)))
    {
      j.q(paramString, "receiver$0");
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if (i == 0)
        {
          c = paramString.charAt(0);
          if ('A' <= c) {
            break label125;
          }
        }
      }
      label125:
      while ('Z' < c)
      {
        AppMethodBeat.o(122910);
        return paramString;
        i = 0;
        break;
      }
      char c = Character.toLowerCase(c);
      paramString = paramString.substring(1);
      j.p(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = String.valueOf(c) + paramString;
      AppMethodBeat.o(122910);
      return paramString;
    }
    b localb = new b();
    Iterator localIterator = ((Iterable)m.aq((CharSequence)paramString)).iterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!((a)localObject2).VW(((Number)localObject1).intValue()))
      {
        i = 1;
        label238:
        if (i == 0) {
          break label324;
        }
      }
    }
    for (;;)
    {
      localObject1 = (Integer)localObject1;
      if (localObject1 == null) {
        break label331;
      }
      i = ((Integer)localObject1).intValue() - 1;
      localObject1 = new StringBuilder();
      localObject2 = paramString.substring(0, i);
      j.p(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = ((StringBuilder)localObject1).append(localb.azq((String)localObject2));
      paramString = paramString.substring(i);
      j.p(paramString, "(this as java.lang.String).substring(startIndex)");
      paramString = paramString;
      AppMethodBeat.o(122910);
      return paramString;
      i = 0;
      break label238;
      label324:
      break;
      localObject1 = null;
    }
    label331:
    paramString = localb.azq(paramString);
    AppMethodBeat.o(122910);
    return paramString;
  }
  
  public static final String azo(String paramString)
  {
    AppMethodBeat.i(122911);
    j.q(paramString, "receiver$0");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(122911);
      return paramString;
    }
    char c = paramString.charAt(0);
    if ('a' > c) {}
    while ('z' < c)
    {
      AppMethodBeat.o(122911);
      return paramString;
    }
    c = Character.toUpperCase(c);
    paramString = paramString.substring(1);
    j.p(paramString, "(this as java.lang.String).substring(startIndex)");
    paramString = String.valueOf(c) + paramString;
    AppMethodBeat.o(122911);
    return paramString;
  }
  
  public static final String azp(String paramString)
  {
    AppMethodBeat.i(122912);
    j.q(paramString, "receiver$0");
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ('A' > c) {}
      for (;;)
      {
        localStringBuilder.append(c);
        i += 1;
        break;
        if ('Z' >= c) {
          c = Character.toLowerCase(c);
        }
      }
    }
    paramString = localStringBuilder.toString();
    j.p(paramString, "builder.toString()");
    AppMethodBeat.o(122912);
    return paramString;
  }
  
  static final class a
    extends k
    implements b<Integer, Boolean>
  {
    a(String paramString)
    {
      super();
    }
    
    public final boolean VW(int paramInt)
    {
      AppMethodBeat.i(122907);
      char c = this.CEy.charAt(paramInt);
      if (this.CEz)
      {
        if ('A' > c) {}
        while ('Z' < c)
        {
          AppMethodBeat.o(122907);
          return false;
        }
        AppMethodBeat.o(122907);
        return true;
      }
      boolean bool = Character.isUpperCase(c);
      AppMethodBeat.o(122907);
      return bool;
    }
  }
  
  static final class b
    extends k
    implements b<String, String>
  {
    b()
    {
      super();
    }
    
    public final String azq(String paramString)
    {
      AppMethodBeat.i(122909);
      j.q(paramString, "string");
      if (this.CEz)
      {
        paramString = a.azp(paramString);
        AppMethodBeat.o(122909);
        return paramString;
      }
      paramString = paramString.toLowerCase();
      j.p(paramString, "(this as java.lang.String).toLowerCase()");
      AppMethodBeat.o(122909);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.m.a.a
 * JD-Core Version:    0.7.0.1
 */