package midas.x;

import android.app.Activity;
import com.tencent.midas.comm.APLog;
import java.lang.reflect.Method;

public class vd
{
  public static Object a(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
    throws Exception
  {
    paramClass = paramClass.getMethod(paramString, a(paramArrayOfObject));
    paramClass.setAccessible(true);
    return paramClass.invoke(null, paramArrayOfObject);
  }
  
  public static Object a(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeStatic2 enter methodName:");
    localStringBuilder.append(paramString);
    APLog.i("APReflectUtils", localStringBuilder.toString());
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfObject.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invokeStatic2 param | ");
      localStringBuilder.append(paramArrayOfObject[i]);
      APLog.i("APReflectUtils", localStringBuilder.toString());
      i += 1;
    }
    while (j < paramArrayOfClass.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invokeStatic2 paramTypes | ");
      localStringBuilder.append(paramArrayOfClass[j]);
      APLog.i("APReflectUtils", localStringBuilder.toString());
      j += 1;
    }
    paramString = paramClass.getMethod(paramString, paramArrayOfClass);
    paramArrayOfClass = new StringBuilder();
    paramArrayOfClass.append("invokeStatic2 method:");
    paramArrayOfClass.append(paramString);
    APLog.i("APReflectUtils", paramArrayOfClass.toString());
    paramArrayOfClass = new StringBuilder();
    paramArrayOfClass.append("invokeStatic2 cls:");
    paramArrayOfClass.append(paramClass);
    APLog.i("APReflectUtils", paramArrayOfClass.toString());
    paramString.setAccessible(true);
    paramClass = paramString.invoke(paramClass, paramArrayOfObject);
    paramString = new StringBuilder();
    paramString.append("invokeStatic2 ob:");
    paramString.append(paramClass);
    APLog.i("APReflectUtils", paramString.toString());
    return paramClass;
  }
  
  public static Object a(String paramString)
    throws Exception
  {
    return Class.forName(paramString).newInstance();
  }
  
  public static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject)
    throws Exception
  {
    return a(Class.forName(paramString1), paramString2, paramArrayOfObject);
  }
  
  public static Class<?>[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass2 = new Class[paramArrayOfObject.length];
      int i = 0;
      for (;;)
      {
        arrayOfClass1 = arrayOfClass2;
        if (i >= arrayOfClass2.length) {
          break;
        }
        if (Activity.class.isAssignableFrom(paramArrayOfObject[i].getClass())) {
          arrayOfClass2[i] = Activity.class;
        } else {
          arrayOfClass2[i] = paramArrayOfObject[i].getClass();
        }
        i += 1;
      }
    }
    Class[] arrayOfClass1 = null;
    return arrayOfClass1;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = Class.forName(paramString);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    finally {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.vd
 * JD-Core Version:    0.7.0.1
 */