package a.j.b.a.c.d.a;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ah;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.r;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  public static final a.j.b.a.c.f.b CcX;
  public static final a.j.b.a.c.f.a CcY;
  
  static
  {
    AppMethodBeat.i(119716);
    CcX = new a.j.b.a.c.f.b("kotlin.jvm.JvmField");
    CcY = a.j.b.a.c.f.a.n(new a.j.b.a.c.f.b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
    AppMethodBeat.o(119716);
  }
  
  public static boolean ayD(String paramString)
  {
    AppMethodBeat.i(119710);
    if ((paramString.startsWith("get")) || (paramString.startsWith("is")))
    {
      AppMethodBeat.o(119710);
      return true;
    }
    AppMethodBeat.o(119710);
    return false;
  }
  
  public static boolean ayE(String paramString)
  {
    AppMethodBeat.i(119711);
    boolean bool = paramString.startsWith("set");
    AppMethodBeat.o(119711);
    return bool;
  }
  
  public static String ayF(String paramString)
  {
    AppMethodBeat.i(119712);
    if (ayH(paramString))
    {
      AppMethodBeat.o(119712);
      return paramString;
    }
    paramString = "get" + a.j.b.a.c.m.a.a.azo(paramString);
    AppMethodBeat.o(119712);
    return paramString;
  }
  
  public static String ayG(String paramString)
  {
    AppMethodBeat.i(119713);
    StringBuilder localStringBuilder = new StringBuilder("set");
    if (ayH(paramString)) {}
    for (paramString = paramString.substring(2);; paramString = a.j.b.a.c.m.a.a.azo(paramString))
    {
      paramString = paramString;
      AppMethodBeat.o(119713);
      return paramString;
    }
  }
  
  private static boolean ayH(String paramString)
  {
    AppMethodBeat.i(119714);
    if (!paramString.startsWith("is"))
    {
      AppMethodBeat.o(119714);
      return false;
    }
    if (paramString.length() == 2)
    {
      AppMethodBeat.o(119714);
      return false;
    }
    int i = paramString.charAt(2);
    if ((97 > i) || (i > 122))
    {
      AppMethodBeat.o(119714);
      return true;
    }
    AppMethodBeat.o(119714);
    return false;
  }
  
  public static boolean d(ah paramah)
  {
    AppMethodBeat.i(119715);
    if (paramah.edy() == b.a.BVY)
    {
      AppMethodBeat.o(119715);
      return false;
    }
    Object localObject = paramah.ecv();
    if ((a.j.b.a.c.i.d.u((l)localObject)) && (a.j.b.a.c.i.d.B(((l)localObject).ecv())))
    {
      localObject = (e)localObject;
      a.j.b.a.c.a.d locald = a.j.b.a.c.a.d.BRE;
      if (a.j.b.a.c.a.d.b((e)localObject)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(119715);
      return true;
    }
    if (a.j.b.a.c.i.d.u(paramah.ecv()))
    {
      if ((paramah instanceof ah))
      {
        localObject = ((ah)paramah).eel();
        if ((localObject == null) || (!((r)localObject).ecM().j(CcX))) {}
      }
      for (boolean bool = true; bool; bool = paramah.ecM().j(CcX))
      {
        AppMethodBeat.o(119715);
        return true;
      }
    }
    AppMethodBeat.o(119715);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.o
 * JD-Core Version:    0.7.0.1
 */