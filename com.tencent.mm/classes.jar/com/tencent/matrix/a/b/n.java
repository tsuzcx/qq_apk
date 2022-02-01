package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.IInterface;
import com.tencent.matrix.e.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class n
{
  private final String eUk;
  private final b eUl;
  private IBinder eUm;
  private IBinder eUn;
  private final String mServiceName;
  
  public n(String paramString1, String paramString2, b paramb)
  {
    this.mServiceName = paramString1;
    this.eUk = paramString2;
    this.eUl = paramb;
  }
  
  public final boolean doHook()
  {
    c.i("Matrix.battery.SystemServiceBinderHooker", "doHook: serviceName:%s, serviceClsName:%s", new Object[] { this.mServiceName, this.eUk });
    try
    {
      a locala = new a(this.mServiceName, this.eUk, this.eUl);
      localObject1 = Class.forName("android.os.ServiceManager");
      localObject2 = ((Class)localObject1).getClassLoader();
      if (localObject2 == null) {
        throw new IllegalStateException("Can not get ClassLoader of " + ((Class)localObject1).getName());
      }
    }
    finally
    {
      c.e("Matrix.battery.SystemServiceBinderHooker", "#doHook exp: " + localInvocationHandler.getLocalizedMessage(), new Object[0]);
      return false;
    }
    Object localObject1 = (IBinder)Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { IBinder.class }, localInvocationHandler);
    Object localObject2 = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
    ((Field)localObject2).setAccessible(true);
    ((Map)((Field)localObject2).get(null)).put(this.mServiceName, localObject1);
    this.eUn = ((IBinder)localObject1);
    this.eUm = localInvocationHandler.eUo;
    return true;
  }
  
  public final boolean doUnHook()
  {
    if (this.eUm == null)
    {
      c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mOriginServiceBinder null", new Object[0]);
      return false;
    }
    if (this.eUn == null)
    {
      c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder null", new Object[0]);
      return false;
    }
    try
    {
      Object localObject1 = a.gA(this.mServiceName);
      if (this.eUn != localObject1)
      {
        c.w("Matrix.battery.SystemServiceBinderHooker", "#doUnHook mDelegateServiceBinder != currentBinder", new Object[0]);
        return false;
      }
      localObject1 = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
      ((Field)localObject1).setAccessible(true);
      ((Map)((Field)localObject1).get(null)).put(this.mServiceName, this.eUm);
      return true;
    }
    finally
    {
      c.e("Matrix.battery.SystemServiceBinderHooker", "#doUnHook exp: " + localObject2.getLocalizedMessage(), new Object[0]);
    }
    return false;
  }
  
  static final class a
    implements InvocationHandler
  {
    final IBinder eUo;
    private final Object eUp;
    
    a(String paramString1, String paramString2, n.b paramb)
    {
      this.eUo = gA(paramString1);
      IBinder localIBinder = this.eUo;
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
          if (this.eUq != null)
          {
            this.eUq.b(paramAnonymousMethod, paramAnonymousArrayOfObject);
            paramAnonymousObject = this.eUq.a(this.eUr, paramAnonymousMethod, paramAnonymousArrayOfObject);
            if (paramAnonymousObject != null) {
              return paramAnonymousObject;
            }
          }
          return paramAnonymousMethod.invoke(this.eUr, paramAnonymousArrayOfObject);
        }
      };
      this.eUp = Proxy.newProxyInstance(paramString2, new Class[] { IBinder.class, IInterface.class, paramString1 }, paramb);
    }
    
    static IBinder gA(String paramString)
    {
      return (IBinder)Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { paramString });
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if ("queryLocalInterface".equals(paramMethod.getName())) {
        return this.eUp;
      }
      return paramMethod.invoke(this.eUo, paramArrayOfObject);
    }
  }
  
  public static abstract interface b
  {
    public abstract Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
    
    public abstract void b(Method paramMethod, Object[] paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.n
 * JD-Core Version:    0.7.0.1
 */