package midas.x;

import android.app.Activity;
import java.lang.reflect.Method;

public class g1
{
  public static Object a(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
    throws Exception
  {
    paramClass = paramClass.getMethod(paramString, a(paramArrayOfObject));
    paramClass.setAccessible(true);
    return paramClass.invoke(null, paramArrayOfObject);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.g1
 * JD-Core Version:    0.7.0.1
 */