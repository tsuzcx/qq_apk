package com.google.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

final class bt
{
  private static final Class<?> bYW = ;
  private static final cb<?, ?> bYX = bG(false);
  private static final cb<?, ?> bYY = bG(true);
  private static final cb<?, ?> bYZ = new ce();
  
  public static cb<?, ?> Hp()
  {
    return bYX;
  }
  
  public static cb<?, ?> Hq()
  {
    return bYY;
  }
  
  public static cb<?, ?> Hr()
  {
    return bYZ;
  }
  
  private static Class<?> Hs()
  {
    try
    {
      Class localClass = Class.forName("com.google.a.ac");
      return localClass;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static Class<?> Ht()
  {
    try
    {
      Class localClass = Class.forName("com.google.a.cf");
      return localClass;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static void I(Class<?> paramClass)
  {
    if ((!ab.class.isAssignableFrom(paramClass)) && (bYW != null) && (!bYW.isAssignableFrom(paramClass))) {
      throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }
  }
  
  static <T> void a(ap paramap, T paramT1, T paramT2, long paramLong)
  {
    ch.a(paramT1, paramLong, paramap.m(ch.k(paramT1, paramLong), ch.k(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void a(cb<UT, UB> paramcb, T paramT1, T paramT2)
  {
    paramcb.p(paramT1, paramcb.q(paramcb.aw(paramT1), paramcb.aw(paramT2)));
  }
  
  static <T, FT extends x.a<FT>> void a(s<FT> params, T paramT1, T paramT2)
  {
    paramT2 = params.an(paramT2);
    if (!paramT2.bUB.isEmpty()) {
      params.ao(paramT1).a(paramT2);
    }
  }
  
  private static cb<?, ?> bG(boolean paramBoolean)
  {
    try
    {
      Object localObject = Ht();
      if (localObject == null) {
        return null;
      }
      localObject = (cb)((Class)localObject).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  static Object d(Class<?> paramClass, String paramString)
  {
    Field[] arrayOfField;
    try
    {
      arrayOfField = Class.forName(paramClass.getName() + "$" + g(paramString, true) + "DefaultEntryHolder").getDeclaredFields();
      if (arrayOfField.length != 1) {
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + paramString + " in " + paramClass.getName());
      }
    }
    catch (Throwable paramClass)
    {
      throw new RuntimeException(paramClass);
    }
    paramClass = ch.b(arrayOfField[0]);
    return paramClass;
  }
  
  private static String g(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (('a' <= c) && (c <= 'z')) {
        if (paramBoolean)
        {
          localStringBuilder.append((char)(c - ' '));
          label52:
          paramBoolean = false;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(c);
        break label52;
        if (('A' <= c) && (c <= 'Z'))
        {
          if ((i == 0) && (!paramBoolean)) {
            localStringBuilder.append((char)(c + ' '));
          }
          for (;;)
          {
            paramBoolean = false;
            break;
            localStringBuilder.append(c);
          }
        }
        if (('0' <= c) && (c <= '9')) {
          localStringBuilder.append(c);
        }
        paramBoolean = true;
      }
    }
    return localStringBuilder.toString();
  }
  
  static boolean o(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.bt
 * JD-Core Version:    0.7.0.1
 */