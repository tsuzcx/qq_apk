package a.j.b.a.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements Comparable<f>
{
  public final boolean CqN;
  public final String name;
  
  private f(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.CqN = paramBoolean;
  }
  
  public static f ayT(String paramString)
  {
    AppMethodBeat.i(121393);
    paramString = new f(paramString, false);
    AppMethodBeat.o(121393);
    return paramString;
  }
  
  public static boolean ayU(String paramString)
  {
    AppMethodBeat.i(121394);
    if ((paramString.isEmpty()) || (paramString.startsWith("<")))
    {
      AppMethodBeat.o(121394);
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j == 46) || (j == 47) || (j == 92))
      {
        AppMethodBeat.o(121394);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(121394);
    return true;
  }
  
  public static f ayV(String paramString)
  {
    AppMethodBeat.i(121395);
    if (!paramString.startsWith("<"))
    {
      paramString = new IllegalArgumentException("special name must start with '<': ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(121395);
      throw paramString;
    }
    paramString = new f(paramString, true);
    AppMethodBeat.o(121395);
    return paramString;
  }
  
  public static f ayW(String paramString)
  {
    AppMethodBeat.i(121396);
    if (paramString.startsWith("<"))
    {
      paramString = ayV(paramString);
      AppMethodBeat.o(121396);
      return paramString;
    }
    paramString = ayT(paramString);
    AppMethodBeat.o(121396);
    return paramString;
  }
  
  public final String emk()
  {
    AppMethodBeat.i(121391);
    if (this.CqN)
    {
      localObject = new IllegalStateException("not identifier: ".concat(String.valueOf(this)));
      AppMethodBeat.o(121391);
      throw ((Throwable)localObject);
    }
    Object localObject = this.name;
    AppMethodBeat.o(121391);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121397);
    if (this == paramObject)
    {
      AppMethodBeat.o(121397);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(121397);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.CqN != paramObject.CqN)
    {
      AppMethodBeat.o(121397);
      return false;
    }
    if (!this.name.equals(paramObject.name))
    {
      AppMethodBeat.o(121397);
      return false;
    }
    AppMethodBeat.o(121397);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121398);
    int j = this.name.hashCode();
    if (this.CqN) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(121398);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    return this.name;
  }
  
  public final int v(f paramf)
  {
    AppMethodBeat.i(121392);
    int i = this.name.compareTo(paramf.name);
    AppMethodBeat.o(121392);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.f.f
 * JD-Core Version:    0.7.0.1
 */