package com.tencent.matrix.a.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static boolean cXl;
  private static j.b cXm = new j.b()
  {
    public final Object b(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      if ("registerAdapter".equals(paramAnonymousMethod.getName()))
      {
        paramAnonymousObject = paramAnonymousMethod.invoke(paramAnonymousObject, paramAnonymousArrayOfObject);
        paramAnonymousMethod = c.aQ(paramAnonymousObject);
        if (paramAnonymousMethod != null) {}
      }
      do
      {
        return paramAnonymousObject;
        return paramAnonymousMethod;
        if (!"getBluetoothGatt".equals(paramAnonymousMethod.getName())) {
          break;
        }
        paramAnonymousObject = paramAnonymousMethod.invoke(paramAnonymousObject, paramAnonymousArrayOfObject);
        paramAnonymousMethod = c.aR(paramAnonymousObject);
      } while (paramAnonymousMethod == null);
      return paramAnonymousMethod;
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject) {}
  };
  private static j cXn = new j("bluetooth_manager", "android.bluetooth.IBluetoothManager", cXm);
  private static List<a> cXo = new ArrayList();
  
  @TargetApi(21)
  public static void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        if (cXo.contains(parama)) {
          continue;
        }
        cXo.add(parama);
        if ((cXl) || (cXo.isEmpty())) {
          continue;
        }
        com.tencent.matrix.e.c.i("Matrix.battery.BluetoothHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(cXn.doHook()) });
        cXl = true;
      }
      finally {}
    }
  }
  
  private static Object aO(Object paramObject)
  {
    try
    {
      Class localClass = Class.forName("android.bluetooth.IBluetooth");
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      paramObject = new InvocationHandler()
      {
        public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          if ("startDiscovery".equals(paramAnonymousMethod.getName())) {
            c.access$200();
          }
          try
          {
            paramAnonymousObject = c.d(this.cXw, paramAnonymousMethod, paramAnonymousArrayOfObject);
            return paramAnonymousObject;
          }
          catch (Throwable paramAnonymousObject)
          {
            com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramAnonymousObject, "invokeBluetooth fail", new Object[0]);
          }
          return null;
        }
      };
      paramObject = Proxy.newProxyInstance(localClassLoader, new Class[] { IBinder.class, IInterface.class, localClass }, paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramObject, "proxyBluetooth fail", new Object[0]);
    }
    return null;
  }
  
  private static Object aP(Object paramObject)
  {
    try
    {
      Class localClass = Class.forName("android.bluetooth.IBluetoothGatt");
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      paramObject = new InvocationHandler()
      {
        public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          if ("registerScanner".equals(paramAnonymousMethod.getName())) {
            c.access$400();
          }
          for (;;)
          {
            try
            {
              paramAnonymousObject = c.d(this.cXw, paramAnonymousMethod, paramAnonymousArrayOfObject);
              return paramAnonymousObject;
            }
            catch (Throwable paramAnonymousObject)
            {
              int i;
              int j;
              com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramAnonymousObject, "invokeBluetoothGatt fail", new Object[0]);
            }
            if ("startScan".equals(paramAnonymousMethod.getName()))
            {
              i = -1;
              j = i;
              if (paramAnonymousArrayOfObject.length > 0)
              {
                if ((paramAnonymousArrayOfObject[0] instanceof Integer)) {
                  i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
                }
                j = Build.VERSION.SDK_INT;
                j = i;
              }
              c.jz(j);
            }
            else if ("startScanForIntent".equals(paramAnonymousMethod.getName()))
            {
              i = Build.VERSION.SDK_INT;
              c.WD();
            }
          }
          return null;
        }
      };
      paramObject = Proxy.newProxyInstance(localClassLoader, new Class[] { IBinder.class, IInterface.class, localClass }, paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramObject, "proxyBluetoothGatt fail", new Object[0]);
    }
    return null;
  }
  
  public static void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        cXo.remove(parama);
        if ((!cXl) || (!cXo.isEmpty())) {
          continue;
        }
        com.tencent.matrix.e.c.i("Matrix.battery.BluetoothHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(cXn.doUnHook()) });
        cXl = false;
      }
      finally {}
    }
  }
  
  private static Object c(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      if (paramObject != null) {
        return paramObject;
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramObject, "reflect invocation fail", new Object[0]);
        paramObject = null;
      }
      paramObject = paramMethod.getReturnType();
      if ((paramObject == null) || (!paramObject.isPrimitive())) {
        return null;
      }
      if ((paramObject == Byte.TYPE) || (paramObject == Short.TYPE) || (paramObject == Integer.TYPE)) {
        return Integer.valueOf(0);
      }
      if (paramObject == Long.TYPE) {
        return Long.valueOf(0L);
      }
      if (paramObject == Float.TYPE) {
        return Float.valueOf(0.0F);
      }
      if (paramObject == Double.TYPE) {
        return Double.valueOf(0.0D);
      }
      if (paramObject == Character.TYPE) {
        return Character.valueOf('\000');
      }
      if (paramObject == Boolean.TYPE) {
        return Boolean.FALSE;
      }
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void Wl();
    
    public abstract void Wm();
    
    @TargetApi(21)
    public abstract void Wn();
    
    @TargetApi(21)
    public abstract void jt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */