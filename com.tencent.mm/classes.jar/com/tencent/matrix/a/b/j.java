package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.e.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class j
{
  private final String cXL;
  private final b cXM;
  private IBinder cXN;
  private IBinder cXO;
  private final String mServiceName;
  
  public j(String paramString1, String paramString2, b paramb)
  {
    this.mServiceName = paramString1;
    this.cXL = paramString2;
    this.cXM = paramb;
  }
  
  public final boolean doHook()
  {
    c.i("Matrix.battery.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.mServiceName, this.cXL });
    try
    {
      a locala = new a(this.mServiceName, this.cXL, this.cXM);
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
    this.cXO = ((IBinder)localObject1);
    this.cXN = localThrowable.cXP;
    return true;
  }
  
  public final boolean doUnHook()
  {
    if (this.cXN == null)
    {
      c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mOriginServiceBinder null", new Object[0]);
      return false;
    }
    if (this.cXO == null)
    {
      c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder null", new Object[0]);
      return false;
    }
    try
    {
      Object localObject = a.fc(this.mServiceName);
      if (this.cXO != localObject)
      {
        c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder != currentBinder", new Object[0]);
        return false;
      }
      localObject = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      ((Field)localObject).setAccessible(true);
      ((Map)((Field)localObject).get(null)).put(this.mServiceName, this.cXN);
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
    final IBinder cXP;
    private final Object cXQ;
    
    a(String paramString1, String paramString2, j.b paramb)
    {
      this.cXP = fc(paramString1);
      IBinder localIBinder = this.cXP;
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
          if (this.cXR != null)
          {
            this.cXR.b(paramAnonymousMethod, paramAnonymousArrayOfObject);
            paramAnonymousObject = this.cXR.b(this.cXS, paramAnonymousMethod, paramAnonymousArrayOfObject);
            if (paramAnonymousObject != null) {
              return paramAnonymousObject;
            }
          }
          return paramAnonymousMethod.invoke(this.cXS, paramAnonymousArrayOfObject);
        }
      };
      this.cXQ = Proxy.newProxyInstance(paramString2, new Class[] { IBinder.class, IInterface.class, paramString1 }, paramb);
    }
    
    static IBinder fc(String paramString)
    {
      return (IBinder)Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { paramString });
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("queryLocalInterface".equals(paramMethod.getName())) {
        return this.cXQ;
      }
      return paramMethod.invoke(this.cXP, paramArrayOfObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract Object b(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
    
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.j
 * JD-Core Version:    0.7.0.1
 */