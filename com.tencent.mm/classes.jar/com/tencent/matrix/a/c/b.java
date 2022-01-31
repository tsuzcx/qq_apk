package com.tencent.matrix.a.c;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class b
{
  private final String bnY;
  private final String bnZ;
  private final b boa;
  private IBinder bob;
  
  public b(String paramString1, String paramString2, b paramb)
  {
    this.bnY = paramString1;
    this.bnZ = paramString2;
    this.boa = paramb;
  }
  
  private Object qZ()
  {
    try
    {
      Object localObject1 = Class.forName(this.bnZ);
      Object localObject3 = Class.forName(String.format("%s$Stub", new Object[] { this.bnZ }));
      Object localObject2 = ((Class)localObject3).getDeclaredMethod("asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.bob });
      localObject3 = ((Class)localObject3).getClassLoader();
      if (localObject3 == null)
      {
        com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return Boolean.valueOf(false);
      }
      localObject2 = new c(localObject2, this.boa);
      localObject1 = Proxy.newProxyInstance((ClassLoader)localObject3, new Class[] { IBinder.class, IInterface.class, localObject1 }, (InvocationHandler)localObject2);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.d.b.w("Matrix.SystemServiceBinderHooker", "createPowerManagerServiceProxy exp:%s", new Object[] { localThrowable.getLocalizedMessage() });
    }
    return null;
  }
  
  public final boolean doHook()
  {
    com.tencent.matrix.d.b.i("Matrix.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.bnY, this.bnZ });
    try
    {
      Object localObject1 = Class.forName("android.os.ServiceManager");
      this.bob = ((IBinder)((Class)localObject1).getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { this.bnY }));
      Object localObject2 = ((Class)localObject1).getClassLoader();
      if (localObject2 == null)
      {
        com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doHook exp classLoader null ", new Object[0]);
        return false;
      }
      a locala = new a(this.bob, qZ());
      localObject2 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, locala);
      localObject1 = ((Class)localObject1).getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      ((Map)((Field)localObject1).get(null)).put(this.bnY, localObject2);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doHook exp : " + localThrowable.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  public final boolean doUnHook()
  {
    if (this.bob == null)
    {
      com.tencent.matrix.d.b.i("Matrix.SystemServiceBinderHooker", "doUnHook sOriginPowerManagerService null", new Object[0]);
      return false;
    }
    try
    {
      Field localField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      localField.setAccessible(true);
      ((Map)localField.get(null)).put(this.bnY, this.bob);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.d.b.e("Matrix.SystemServiceBinderHooker", "doUnHook exp : " + localThrowable.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  private static final class a
    implements InvocationHandler
  {
    private final IBinder boc;
    private final Object bod;
    
    a(IBinder paramIBinder, Object paramObject)
    {
      this.boc = paramIBinder;
      this.bod = paramObject;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (("queryLocalInterface".equals(paramMethod.getName())) && (this.bod != null)) {
        return this.bod;
      }
      return paramMethod.invoke(this.boc, paramArrayOfObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
  
  private static final class c
    implements InvocationHandler
  {
    final Object boe;
    final b.b bof;
    
    c(Object paramObject, b.b paramb)
    {
      this.boe = paramObject;
      this.bof = paramb;
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (this.bof != null) {
        this.bof.b(paramMethod, paramArrayOfObject);
      }
      return paramMethod.invoke(this.boe, paramArrayOfObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.c.b
 * JD-Core Version:    0.7.0.1
 */