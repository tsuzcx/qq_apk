package com.tencent.magicbrush.engine;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Keep
public class JsClassUtils
{
  private static final int BOOLEAN = 1;
  private static final int BYTE = 3;
  private static final int CHAR = 2;
  private static final int DOUBLE = 8;
  private static final int FLOAT = 6;
  private static final int INT = 5;
  private static final int LONG = 7;
  private static final int SHORT = 4;
  private static final String TAG = "MicroMsg.JsClassUtils";
  private static final int VOID = 0;
  public static final int log_type_d = 0;
  public static final int log_type_e = 2;
  public static final int log_type_i = 1;
  private static final int string = 9;
  private static final int unknown = 10;
  
  private static void getDescriptor(StringBuilder paramStringBuilder, Class<?> paramClass)
  {
    AppMethodBeat.i(139981);
    char c1;
    for (;;)
    {
      if (paramClass.isPrimitive())
      {
        if (paramClass == Integer.TYPE) {
          c1 = 'I';
        }
        for (;;)
        {
          paramStringBuilder.append(c1);
          AppMethodBeat.o(139981);
          return;
          if (paramClass == Void.TYPE) {
            c1 = 'V';
          } else if (paramClass == Boolean.TYPE) {
            c1 = 'Z';
          } else if (paramClass == Byte.TYPE) {
            c1 = 'B';
          } else if (paramClass == Character.TYPE) {
            c1 = 'C';
          } else if (paramClass == Short.TYPE) {
            c1 = 'S';
          } else if (paramClass == Double.TYPE) {
            c1 = 'D';
          } else if (paramClass == Float.TYPE) {
            c1 = 'F';
          } else {
            c1 = 'J';
          }
        }
      }
      if (!paramClass.isArray()) {
        break;
      }
      paramStringBuilder.append('[');
      paramClass = paramClass.getComponentType();
    }
    paramStringBuilder.append('L');
    paramClass = paramClass.getName();
    int j = paramClass.length();
    int i = 0;
    while (i < j)
    {
      char c2 = paramClass.charAt(i);
      c1 = c2;
      if (c2 == '.') {
        c1 = '/';
      }
      paramStringBuilder.append(c1);
      i += 1;
    }
    paramStringBuilder.append(';');
    AppMethodBeat.o(139981);
  }
  
  private static int getJavaType(Class<?> paramClass)
  {
    AppMethodBeat.i(139982);
    if (paramClass == Integer.TYPE)
    {
      AppMethodBeat.o(139982);
      return 5;
    }
    if (paramClass == Void.TYPE)
    {
      AppMethodBeat.o(139982);
      return 0;
    }
    if (paramClass == Boolean.TYPE)
    {
      AppMethodBeat.o(139982);
      return 1;
    }
    if (paramClass == Byte.TYPE)
    {
      AppMethodBeat.o(139982);
      return 3;
    }
    if (paramClass == Character.TYPE)
    {
      AppMethodBeat.o(139982);
      return 2;
    }
    if (paramClass == Short.TYPE)
    {
      AppMethodBeat.o(139982);
      return 4;
    }
    if (paramClass == Double.TYPE)
    {
      AppMethodBeat.o(139982);
      return 8;
    }
    if (paramClass == Float.TYPE)
    {
      AppMethodBeat.o(139982);
      return 6;
    }
    if (paramClass.getCanonicalName().equals("java.lang.String"))
    {
      AppMethodBeat.o(139982);
      return 9;
    }
    AppMethodBeat.o(139982);
    return 10;
  }
  
  @Keep
  public static Method[] getJavascriptInterfaceMethod(Object paramObject)
  {
    AppMethodBeat.i(139978);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramObject = paramObject.getClass().getMethods();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramObject[i];
        if (localObject.isAnnotationPresent(JavascriptInterface.class)) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject = (Method[])localArrayList.toArray(new Method[localArrayList.size()]);
      AppMethodBeat.o(139978);
    }
  }
  
  @Keep
  public static String getMethodName(Method paramMethod)
  {
    AppMethodBeat.i(139980);
    paramMethod = paramMethod.getName();
    AppMethodBeat.o(139980);
    return paramMethod;
  }
  
  @Keep
  public static String getMethodSignature(Method paramMethod)
  {
    AppMethodBeat.i(139979);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    int i = 0;
    while (i < arrayOfClass.length)
    {
      getDescriptor(localStringBuilder, arrayOfClass[i]);
      i += 1;
    }
    localStringBuilder.append(')');
    getDescriptor(localStringBuilder, paramMethod.getReturnType());
    paramMethod = localStringBuilder.toString();
    AppMethodBeat.o(139979);
    return paramMethod;
  }
  
  @Keep
  public static int[] getMethodType(Method paramMethod)
  {
    int i = 0;
    AppMethodBeat.i(139983);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int[] arrayOfInt = new int[arrayOfClass.length + 2];
    arrayOfInt[0] = arrayOfClass.length;
    arrayOfInt[1] = getJavaType(paramMethod.getReturnType());
    while (i < arrayOfClass.length)
    {
      arrayOfInt[(i + 2)] = getJavaType(arrayOfClass[i]);
      i += 1;
    }
    AppMethodBeat.o(139983);
    return arrayOfInt;
  }
  
  @Keep
  public static byte[] getStringUtf8(String paramString)
  {
    AppMethodBeat.i(139985);
    try
    {
      paramString = paramString.getBytes("UTF-8");
      AppMethodBeat.o(139985);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      AppMethodBeat.o(139985);
    }
    return null;
  }
  
  public static boolean hasJavascriptInterface(Object paramObject)
  {
    AppMethodBeat.i(139977);
    try
    {
      paramObject = paramObject.getClass().getMethods();
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramObject[i].isAnnotationPresent(JavascriptInterface.class);
        if (bool)
        {
          AppMethodBeat.o(139977);
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramObject)
    {
      AppMethodBeat.o(139977);
    }
  }
  
  @Keep
  public static void jsLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(139984);
    switch (paramInt)
    {
    default: 
      c.c.d("MicroMsg.JsClassUtils", paramString, new Object[0]);
      AppMethodBeat.o(139984);
      return;
    case 1: 
      c.c.i("MicroMsg.JsClassUtils", paramString, new Object[0]);
      AppMethodBeat.o(139984);
      return;
    }
    c.c.e("MicroMsg.JsClassUtils", paramString, new Object[0]);
    AppMethodBeat.o(139984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsClassUtils
 * JD-Core Version:    0.7.0.1
 */