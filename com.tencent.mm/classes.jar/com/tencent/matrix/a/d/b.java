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
  private final String cDQ;
  private final b cDR;
  private IBinder cDS;
  private final String mServiceName;
  
  public b(String paramString1, String paramString2, b paramb)
  {
    this.mServiceName = paramString1;
    this.cDQ = paramString2;
    this.cDR = paramb;
  }
  
  private Object In()
  {
    try
    {
      Object localObject1 = Class.forName(this.cDQ);
      Object localObject3 = Class.forName(String.format("%s$Stub", new Object[] { this.cDQ }));
      Object localObject2 = ((Class)localObject3).getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.cDS });
      localObject3 = ((Class)localObject3).getClassLoader();
      if (localObject3 == null)
      {
        c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return Boolean.FALSE;
      }
      localObject2 = new c(localObject2, this.cDR);
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
    c.i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.mServiceName, this.cDQ });
    try
    {
      Object localObject1 = Class.forName("android.os.ServiceManager");
      this.cDS = ((IBinder)((Class)localObject1).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { this.mServiceName }));
      Object localObject2 = ((Class)localObject1).getClassLoader();
      if (localObject2 == null)
      {
        c.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return false;
      }
      a locala = new a(this.cDS, In());
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
    if (this.cDS == null)
    {
      c.i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
      return false;
    }
    try
    {
      Field localField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      localField.setAccessible(true);
      ((Map)localField.get(null)).put(this.mServiceName, this.cDS);
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
    private final IBinder cDT;
    private final Object cDU;
    
    a(IBinder paramIBinder, Object paramObject)
    {
      this.cDT = paramIBinder;
      this.cDU = paramObject;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (("queryLocalInterface".equals(paramMethod.getName())) && (this.cDU != null)) {
        return this.cDU;
      }
      return paramMethod.invoke(this.cDT, paramArrayOfObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
  
  static final class c
    implements InvocationHandler
  {
    final Object cDV;
    final b.b cDW;
    
    c(Object paramObject, b.b paramb)
    {
      this.cDV = paramObject;
      this.cDW = paramb;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (this.cDW != null) {
        this.cDW.b(paramMethod, paramArrayOfObject);
      }
      return paramMethod.invoke(this.cDV, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.d.b
 * JD-Core Version:    0.7.0.1
 */