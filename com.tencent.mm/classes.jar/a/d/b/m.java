package a.d.b;

import a.f.b;
import a.f.f;

public final class m
{
  private static final n xow;
  private static final b[] xox;
  
  static
  {
    try
    {
      n localn1 = (n)Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
      if (localn1 != null)
      {
        xow = localn1;
        xox = new b[0];
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        Object localObject3 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        n localn2 = null;
        continue;
        localn2 = new n();
      }
    }
  }
  
  public static f a(j paramj)
  {
    return paramj;
  }
  
  public static String a(h paramh)
  {
    String str = paramh.getClass().getGenericInterfaces()[0].toString();
    paramh = str;
    if (str.startsWith("kotlin.jvm.functions.")) {
      paramh = str.substring(21);
    }
    return paramh;
  }
  
  public static b ak(Class paramClass)
  {
    return new c(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.d.b.m
 * JD-Core Version:    0.7.0.1
 */