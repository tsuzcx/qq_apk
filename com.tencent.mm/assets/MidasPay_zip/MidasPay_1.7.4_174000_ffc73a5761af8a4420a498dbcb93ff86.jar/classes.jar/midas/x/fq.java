package midas.x;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginStatic;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class fq
{
  public static Class<?> a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = ((DexClassLoader)APPluginStatic.getOrCreateClassLoader(paramContext, paramString1)).loadClass(paramString2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Object a(Context paramContext, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
    throws Exception
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMethod context\t\t=");
    localStringBuilder.append(paramContext);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMethod pluginName\t\t=");
    localStringBuilder.append(paramString1);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMethod interfaceClass\t=");
    localStringBuilder.append(paramString2);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMethod methodName\t\t=");
    localStringBuilder.append(paramString3);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMethod params\t\t\t=");
    localStringBuilder.append(paramArrayOfObject);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramContext = a(paramContext, paramString1, paramString2);
      if (paramContext == null)
      {
        APLog.e("APPluginHelper", "invokeMethod objClass is null");
        return null;
      }
      paramString1 = paramContext.getDeclaredMethod(paramString3, a(paramArrayOfObject));
      if (paramString1 == null)
      {
        APLog.e("APPluginHelper", "invokeMethod method is null");
        return null;
      }
      paramString1.setAccessible(true);
      paramContext = paramString1.invoke(paramContext, paramArrayOfObject);
      if (paramContext == null)
      {
        APLog.e("APPluginHelper", "initPluginInterface obj is null");
        return null;
      }
      return paramContext;
    }
    APLog.e("APPluginHelper", "invokeMethod params is null");
    return null;
  }
  
  public static Object a(Context paramContext, String paramString1, String paramString2, InvocationHandler paramInvocationHandler)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getcallbackObject pluginName=");
    localStringBuilder.append(paramString1);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getcallbackObject callbackClassName=");
    localStringBuilder.append(paramString2);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getcallbackObject invohandler=");
    localStringBuilder.append(paramInvocationHandler);
    APLog.i("APPluginHelper", localStringBuilder.toString());
    try
    {
      paramContext = a(paramContext, paramString1, paramString2);
      paramContext = Proxy.newProxyInstance(paramContext.getClassLoader(), new Class[] { paramContext }, paramInvocationHandler);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  static Class<?>[] a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfClass;
        if (i >= arrayOfClass.length) {
          break;
        }
        if (paramArrayOfObject[i] != null)
        {
          localObject = paramArrayOfObject[i].getClass();
          if (Activity.class.isAssignableFrom((Class)localObject)) {
            arrayOfClass[i] = Activity.class;
          } else if (Proxy.isProxyClass((Class)localObject)) {
            arrayOfClass[i] = localObject.getInterfaces()[0];
          } else {
            arrayOfClass[i] = paramArrayOfObject[i].getClass();
          }
        }
        i += 1;
      }
    }
    Object localObject = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fq
 * JD-Core Version:    0.7.0.1
 */