package com.google.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f
{
  private static void a(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof e)) {
        break label395;
      }
      int m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(bg(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      Class localClass = paramObject.getClass();
      Object localObject1 = localClass.getFields();
      int n = localObject1.length;
      int i = 0;
      String str;
      Object localObject2;
      while (i < n)
      {
        Object localObject3 = localObject1[i];
        j = localObject3.getModifiers();
        str = localObject3.getName();
        if (((j & 0x1) == 1) && ((j & 0x8) != 8) && (!str.startsWith("_")) && (!str.endsWith("_")))
        {
          localObject2 = localObject3.getType();
          localObject3 = localObject3.get(paramObject);
          if ((((Class)localObject2).isArray()) && (((Class)localObject2).getComponentType() != Byte.TYPE))
          {
            if (localObject3 == null) {}
            for (j = 0;; j = Array.getLength(localObject3))
            {
              int k = 0;
              while (k < j)
              {
                a(str, Array.get(localObject3, k), paramStringBuffer1, paramStringBuffer2);
                k += 1;
              }
            }
          }
          a(str, localObject3, paramStringBuffer1, paramStringBuffer2);
        }
        i += 1;
      }
      localObject1 = localClass.getMethods();
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        str = localObject1[i].getName();
        if (str.startsWith("set")) {
          str = str.substring(3);
        }
        for (;;)
        {
          try
          {
            localObject2 = localClass.getMethod("has".concat(String.valueOf(str)), new Class[0]);
            if (!((Boolean)((Method)localObject2).invoke(paramObject, new Object[0])).booleanValue()) {}
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            continue;
          }
          try
          {
            localObject2 = localClass.getMethod("get".concat(String.valueOf(str)), new Class[0]);
            a(str, ((Method)localObject2).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        i += 1;
      }
      if (paramString != null)
      {
        paramStringBuffer1.setLength(m);
        paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      }
    }
    return;
    label395:
    paramString = bg(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      paramString = paramObject;
      if (!paramObject.startsWith("http"))
      {
        paramString = paramObject;
        if (paramObject.length() > 200) {
          paramString = paramObject.substring(0, 200) + "[...]";
        }
      }
      paramString = escapeString(paramString);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      return;
      if ((paramObject instanceof byte[])) {
        a((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      if ((j == 92) || (j == 34)) {
        paramStringBuffer.append('\\').append((char)j);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((j >= 32) && (j < 127)) {
          paramStringBuffer.append((char)j);
        } else {
          paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
        }
      }
    }
    paramStringBuffer.append('"');
  }
  
  private static String bg(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static <T extends e> String c(T paramT)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      a(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramT)
    {
      return "Error printing proto: " + paramT.getMessage();
    }
    catch (InvocationTargetException paramT) {}
    return "Error printing proto: " + paramT.getMessage();
  }
  
  private static String escapeString(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.a.a.f
 * JD-Core Version:    0.7.0.1
 */