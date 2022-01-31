package com.tencent.matrix.a.c;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class b
{
  private final String bNw;
  private final String bNx;
  private final b bNy;
  private IBinder bNz;
  
  public b(String paramString1, String paramString2, b paramb)
  {
    this.bNw = paramString1;
    this.bNx = paramString2;
    this.bNy = paramb;
  }
  
  private Object yT()
  {
    try
    {
      Object localObject1 = Class.forName(this.bNx);
      Object localObject3 = Class.forName(String.format("%s$Stub", new Object[] { this.bNx }));
      Object localObject2 = ((Class)localObject3).getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.bNz });
      localObject3 = ((Class)localObject3).getClassLoader();
      if (localObject3 == null)
      {
        c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return Boolean.FALSE;
      }
      localObject2 = new c(localObject2, this.bNy);
      localObject1 = Proxy.newProxyInstance((ClassLoader)localObject3, new Class[] { IBinder.class, IInterface.class, localObject1 }, (InvocationHandler)localObject2);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      c.w("Matrix.SystemServiceBinderHooker", "createPowerManagerServiceProxy exp:%s", new Object[] { localThrowable.getLocalizedMessage() });
    }
    return null;
  }
  
  public final boolean doHook()
  {
    c.i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.bNw, this.bNx });
    try
    {
      Object localObject1 = Class.forName("android.os.ServiceManager");
      this.bNz = ((IBinder)((Class)localObject1).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { this.bNw }));
      Object localObject2 = ((Class)localObject1).getClassLoader();
      if (localObject2 == null)
      {
        c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return false;
      }
      a locala = new a(this.bNz, yT());
      localObject2 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, locala);
      localObject1 = ((Class)localObject1).getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      ((Map)((Field)localObject1).get(null)).put(this.bNw, localObject2);
      return true;
    }
    catch (Throwable localThrowable)
    {
      c.e("Matrix.SystemServiceBinderHooker", "doHook exp : " + localThrowable.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  public final boolean doUnHook()
  {
    if (this.bNz == null)
    {
      c.i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
      return false;
    }
    try
    {
      Field localField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      localField.setAccessible(true);
      ((Map)localField.get(null)).put(this.bNw, this.bNz);
      return true;
    }
    catch (Throwable localThrowable)
    {
      c.e("Matrix.SystemServiceBinderHooker", "doUnHook exp : " + localThrowable.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  static final class a
    implements InvocationHandler
  {
    private final IBinder bNA;
    private final Object bNB;
    
    a(IBinder paramIBinder, Object paramObject)
    {
      this.bNA = paramIBinder;
      this.bNB = paramObject;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (("queryLocalInterface".equals(paramMethod.getName())) && (this.bNB != null)) {
        return this.bNB;
      }
      return paramMethod.invoke(this.bNA, paramArrayOfObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
  
  static final class c
    implements InvocationHandler
  {
    final Object bNC;
    final b.b bND;
    
    c(Object paramObject, b.b paramb)
    {
      this.bNC = paramObject;
      this.bND = paramb;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (this.bND != null) {
        this.bND.b(paramMethod, paramArrayOfObject);
      }
      return paramMethod.invoke(this.bNC, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.c.b
 * JD-Core Version:    0.7.0.1
 */