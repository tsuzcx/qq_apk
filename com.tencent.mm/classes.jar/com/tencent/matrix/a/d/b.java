package com.tencent.matrix.a.d;

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
  private final String cEx;
  private final b cEy;
  private IBinder cEz;
  private final String mServiceName;
  
  public b(String paramString1, String paramString2, b paramb)
  {
    this.mServiceName = paramString1;
    this.cEx = paramString2;
    this.cEy = paramb;
  }
  
  private Object Iv()
  {
    try
    {
      Object localObject1 = Class.forName(this.cEx);
      Object localObject3 = Class.forName(String.format("%s$Stub", new Object[] { this.cEx }));
      Object localObject2 = ((Class)localObject3).getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.cEz });
      localObject3 = ((Class)localObject3).getClassLoader();
      if (localObject3 == null)
      {
        c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return Boolean.FALSE;
      }
      localObject2 = new c(localObject2, this.cEy);
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
    c.i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.mServiceName, this.cEx });
    try
    {
      Object localObject1 = Class.forName("android.os.ServiceManager");
      this.cEz = ((IBinder)((Class)localObject1).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { this.mServiceName }));
      Object localObject2 = ((Class)localObject1).getClassLoader();
      if (localObject2 == null)
      {
        c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return false;
      }
      b.a locala = new b.a(this.cEz, Iv());
      localObject2 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, locala);
      localObject1 = ((Class)localObject1).getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      ((Map)((Field)localObject1).get(null)).put(this.mServiceName, localObject2);
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
    if (this.cEz == null)
    {
      c.i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
      return false;
    }
    try
    {
      Field localField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      localField.setAccessible(true);
      ((Map)localField.get(null)).put(this.mServiceName, this.cEz);
      return true;
    }
    catch (Throwable localThrowable)
    {
      c.e("Matrix.SystemServiceBinderHooker", "doUnHook exp : " + localThrowable.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  public static abstract interface b
  {
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
  
  static final class c
    implements InvocationHandler
  {
    final Object cEC;
    final b.b cED;
    
    c(Object paramObject, b.b paramb)
    {
      this.cEC = paramObject;
      this.cED = paramb;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (this.cED != null) {
        this.cED.b(paramMethod, paramArrayOfObject);
      }
      return paramMethod.invoke(this.cEC, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.d.b
 * JD-Core Version:    0.7.0.1
 */