package com.google.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

final class cr
{
  private static final cz<?, ?> caA = bT(false);
  private static final cz<?, ?> caB = bT(true);
  private static final cz<?, ?> caC = new dc();
  private static final Class<?> caz = ;
  
  public static void G(Class<?> paramClass)
  {
    if ((!az.class.isAssignableFrom(paramClass)) && (caz != null) && (!caz.isAssignableFrom(paramClass))) {
      throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }
  }
  
  public static cz<?, ?> IP()
  {
    return caA;
  }
  
  public static cz<?, ?> IQ()
  {
    return caB;
  }
  
  public static cz<?, ?> IR()
  {
    return caC;
  }
  
  private static Class<?> IS()
  {
    try
    {
      Class localClass = Class.forName("com.google.b.bb");
      return localClass;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static Class<?> IT()
  {
    try
    {
      Class localClass = Class.forName("com.google.b.dd");
      return localClass;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  private static cz<?, ?> bT(boolean paramBoolean)
  {
    try
    {
      Object localObject = IT();
      if (localObject == null) {
        return null;
      }
      localObject = (cz)((Class)localObject).getConstructor(new Class[] { Boolean.TYPE }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  static Object c(Class<?> paramClass, String paramString)
  {
    Field[] arrayOfField;
    try
    {
      arrayOfField = Class.forName(paramClass.getName() + "$" + h(paramString, true) + "DefaultEntryHolder").getDeclaredFields();
      if (arrayOfField.length != 1) {
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + paramString + " in " + paramClass.getName());
      }
    }
    catch (Throwable paramClass)
    {
      throw new RuntimeException(paramClass);
    }
    paramClass = df.d(arrayOfField[0]);
    return paramClass;
  }
  
  private static String h(String paramString, boolean paramBoolean)
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
  
  static boolean j(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.cr
 * JD-Core Version:    0.7.0.1
 */