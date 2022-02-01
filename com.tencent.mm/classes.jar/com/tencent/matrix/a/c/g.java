package com.tencent.matrix.a.c;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class g
{
  private final String cUn;
  private final b cUo;
  private IBinder cUp;
  private IBinder cUq;
  private final String mServiceName;
  
  public g(String paramString1, String paramString2, b paramb)
  {
    this.mServiceName = paramString1;
    this.cUn = paramString2;
    this.cUo = paramb;
  }
  
  public final boolean doHook()
  {
    c.i("Matrix.battery.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.mServiceName, this.cUn });
    try
    {
      a locala = new a(this.mServiceName, this.cUn, this.cUo);
      localObject1 = Class.forName("android.os.ServiceManager");
      localObject2 = ((Class)localObject1).getClassLoader();
      if (localObject2 == null) {
        throw new IllegalStateException("Can not get ClassLoader of " + ((Class)localObject1).getName());
      }
    }
    catch (Throwable localThrowable)
    {
      c.e("Matrix.battery.SystemServiceBinderHooker", "#doHook exp: " + localThrowable.getLocalizedMessage(), new Object[0]);
      return false;
    }
    Object localObject1 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, localThrowable);
    Object localObject2 = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
    ((Field)localObject2).setAccessible(true);
    ((Map)((Field)localObject2).get(null)).put(this.mServiceName, localObject1);
    this.cUq = ((IBinder)localObject1);
    this.cUp = localThrowable.cUr;
    return true;
  }
  
  public final boolean doUnHook()
  {
    if (this.cUp == null)
    {
      c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mOriginServiceBinder null", new Object[0]);
      return false;
    }
    if (this.cUq == null)
    {
      c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder null", new Object[0]);
      return false;
    }
    try
    {
      Object localObject = a.ew(this.mServiceName);
      if (this.cUq != localObject)
      {
        c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder != currentBinder", new Object[0]);
        return false;
      }
      localObject = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      ((Field)localObject).setAccessible(true);
      ((Map)((Field)localObject).get(null)).put(this.mServiceName, this.cUp);
      return true;
    }
    catch (Throwable localThrowable)
    {
      c.e("Matrix.battery.SystemServiceBinderHooker", "#doUnHook exp: " + localThrowable.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  static final class a
    implements InvocationHandler
  {
    final IBinder cUr;
    private final Object cUs;
    
    a(String paramString1, String paramString2, g.b paramb)
    {
      this.cUr = ew(paramString1);
      IBinder localIBinder = this.cUr;
      paramString1 = Class.forName(paramString2);
      Class localClass = Class.forName(paramString2 + "$Stub");
      paramString2 = localClass.getClassLoader();
      if (paramString2 == null) {
        throw new IllegalStateException("get service manager ClassLoader fail!");
      }
      paramb = new InvocationHandler()
      {
        public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          if (this.cUt != null) {
            this.cUt.b(paramAnonymousMethod, paramAnonymousArrayOfObject);
          }
          return paramAnonymousMethod.invoke(this.cUu, paramAnonymousArrayOfObject);
        }
      };
      this.cUs = Proxy.newProxyInstance(paramString2, new Class[] { IBinder.class, IInterface.class, paramString1 }, paramb);
    }
    
    static IBinder ew(String paramString)
    {
      return (IBinder)Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { paramString });
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("queryLocalInterface".equals(paramMethod.getName())) {
        return this.cUs;
      }
      return paramMethod.invoke(this.cUr, paramArrayOfObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.c.g
 * JD-Core Version:    0.7.0.1
 */