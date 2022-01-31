package a.b;

import a.d.b.g;
import a.h.e;
import a.k;

public final class c
{
  public static final b xom;
  
  static
  {
    int i = cUc();
    b localb;
    if (i >= 65544)
    {
      try
      {
        Object localObject1 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
        if (localObject1 != null) {
          break label125;
        }
        throw new k("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          Object localObject2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
          if (localObject2 != null) {
            break label133;
          }
          throw new k("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        catch (ClassNotFoundException localClassNotFoundException2) {}
      }
    }
    else
    {
      if (i >= 65543) {
        try
        {
          Object localObject3 = Class.forName("a.b.a.a").newInstance();
          if (localObject3 != null) {
            break label141;
          }
          throw new k("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        catch (ClassNotFoundException localClassNotFoundException3)
        {
          try
          {
            Object localObject4 = Class.forName("a.b.a").newInstance();
            if (localObject4 != null) {
              break label149;
            }
            throw new k("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
          }
          catch (ClassNotFoundException localClassNotFoundException4) {}
        }
      }
      localb = new b();
    }
    for (;;)
    {
      xom = localb;
      return;
      label125:
      localb = (b)localb;
      continue;
      label133:
      localb = (b)localb;
      continue;
      label141:
      localb = (b)localb;
      continue;
      label149:
      localb = (b)localb;
    }
  }
  
  private static final int cUc()
  {
    String str2 = System.getProperty("java.specification.version");
    if (str2 == null) {
      return 65542;
    }
    int k = e.b((CharSequence)str2, 0, 6);
    if (k < 0)
    {
      try
      {
        i = Integer.parseInt(str2);
        i *= 65536;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          i = 65542;
        }
      }
      return i;
    }
    int j = e.b((CharSequence)str2, k + 1, 4);
    int i = j;
    if (j < 0) {
      i = str2.length();
    }
    if (str2 == null) {
      throw new k("null cannot be cast to non-null type java.lang.String");
    }
    String str1 = str2.substring(0, k);
    g.j(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (str2 == null) {
      throw new k("null cannot be cast to non-null type java.lang.String");
    }
    str2 = str2.substring(k + 1, i);
    g.j(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    try
    {
      i = Integer.parseInt(str1);
      j = Integer.parseInt(str2);
      return i * 65536 + j;
    }
    catch (NumberFormatException localNumberFormatException2) {}
    return 65542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.b.c
 * JD-Core Version:    0.7.0.1
 */