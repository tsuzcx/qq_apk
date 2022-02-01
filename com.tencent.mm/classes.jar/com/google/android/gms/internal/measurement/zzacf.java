package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzacf
{
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
  {
    AppMethodBeat.i(40307);
    int i;
    int j;
    if (paramObject != null)
    {
      if ((paramObject instanceof zzace))
      {
        int m = paramStringBuffer1.length();
        if (paramString != null)
        {
          paramStringBuffer2.append(paramStringBuffer1).append(zzfn(paramString)).append(" <\n");
          paramStringBuffer1.append("  ");
        }
        Class localClass = paramObject.getClass();
        Object localObject1 = localClass.getFields();
        int n = localObject1.length;
        i = 0;
        Object localObject3;
        while (i < n)
        {
          Object localObject4 = localObject1[i];
          j = localObject4.getModifiers();
          localObject2 = localObject4.getName();
          if ((!"cachedSize".equals(localObject2)) && ((j & 0x1) == 1) && ((j & 0x8) != 8) && (!((String)localObject2).startsWith("_")) && (!((String)localObject2).endsWith("_")))
          {
            localObject3 = localObject4.getType();
            localObject4 = localObject4.get(paramObject);
            if ((((Class)localObject3).isArray()) && (((Class)localObject3).getComponentType() != Byte.TYPE))
            {
              if (localObject4 == null) {}
              for (j = 0;; j = Array.getLength(localObject4))
              {
                int k = 0;
                while (k < j)
                {
                  zza((String)localObject2, Array.get(localObject4, k), paramStringBuffer1, paramStringBuffer2);
                  k += 1;
                }
              }
            }
            zza((String)localObject2, localObject4, paramStringBuffer1, paramStringBuffer2);
          }
          i += 1;
        }
        Object localObject2 = localClass.getMethods();
        j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject1 = localObject2[i].getName();
          if (((String)localObject1).startsWith("set")) {
            localObject3 = ((String)localObject1).substring(3);
          }
          for (;;)
          {
            try
            {
              localObject1 = String.valueOf(localObject3);
              if (((String)localObject1).length() != 0)
              {
                localObject1 = "has".concat((String)localObject1);
                localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
                if (!((Boolean)((Method)localObject1).invoke(paramObject, new Object[0])).booleanValue()) {}
              }
            }
            catch (NoSuchMethodException localNoSuchMethodException1)
            {
              continue;
              String str = new String("get");
              continue;
            }
            try
            {
              localObject1 = String.valueOf(localObject3);
              if (((String)localObject1).length() == 0) {
                continue;
              }
              localObject1 = "get".concat((String)localObject1);
              localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
              zza((String)localObject3, ((Method)localObject1).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
            }
            catch (NoSuchMethodException localNoSuchMethodException2)
            {
              continue;
            }
            i += 1;
            break;
            localObject1 = new String("has");
          }
        }
        if (paramString != null)
        {
          paramStringBuffer1.setLength(m);
          paramStringBuffer2.append(paramStringBuffer1).append(">\n");
        }
        AppMethodBeat.o(40307);
        return;
      }
      paramString = zzfn(paramString);
      paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
      if (!(paramObject instanceof String)) {
        break label694;
      }
      paramObject = (String)paramObject;
      paramString = paramObject;
      if (!paramObject.startsWith("http"))
      {
        paramString = paramObject;
        if (paramObject.length() > 200) {
          paramString = String.valueOf(paramObject.substring(0, 200)).concat("[...]");
        }
      }
      j = paramString.length();
      paramObject = new StringBuilder(j);
      i = 0;
      if (i < j)
      {
        char c = paramString.charAt(i);
        if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
          paramObject.append(c);
        }
        for (;;)
        {
          i += 1;
          break;
          paramObject.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
      }
      paramString = paramObject.toString();
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      AppMethodBeat.o(40307);
      return;
      label694:
      if ((paramObject instanceof byte[]))
      {
        paramString = (byte[])paramObject;
        if (paramString == null)
        {
          paramStringBuffer2.append("\"\"");
        }
        else
        {
          paramStringBuffer2.append('"');
          i = 0;
          if (i < paramString.length)
          {
            j = paramString[i] & 0xFF;
            if ((j == 92) || (j == 34)) {
              paramStringBuffer2.append('\\').append((char)j);
            }
            for (;;)
            {
              i += 1;
              break;
              if ((j >= 32) && (j < 127)) {
                paramStringBuffer2.append((char)j);
              } else {
                paramStringBuffer2.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
              }
            }
          }
          paramStringBuffer2.append('"');
        }
      }
      else
      {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  public static <T extends zzace> String zzc(T paramT)
  {
    AppMethodBeat.i(40306);
    if (paramT == null)
    {
      AppMethodBeat.o(40306);
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      zza(null, paramT, new StringBuffer(), localStringBuffer);
      paramT = localStringBuffer.toString();
      AppMethodBeat.o(40306);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      paramT = String.valueOf(paramT.getMessage());
      if (paramT.length() != 0)
      {
        paramT = "Error printing proto: ".concat(paramT);
        AppMethodBeat.o(40306);
        return paramT;
      }
      paramT = new String("Error printing proto: ");
      AppMethodBeat.o(40306);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = String.valueOf(paramT.getMessage());
      if (paramT.length() != 0)
      {
        paramT = "Error printing proto: ".concat(paramT);
        AppMethodBeat.o(40306);
        return paramT;
      }
      paramT = new String("Error printing proto: ");
      AppMethodBeat.o(40306);
    }
    return paramT;
  }
  
  private static String zzfn(String paramString)
  {
    AppMethodBeat.i(40308);
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
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(40308);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzacf
 * JD-Core Version:    0.7.0.1
 */