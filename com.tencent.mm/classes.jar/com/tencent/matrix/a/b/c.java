package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static boolean eTs;
  private static n.b eTt = new n.b()
  {
    public final Object a(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      if ("registerAdapter".equals(paramAnonymousMethod.getName()))
      {
        paramAnonymousObject = paramAnonymousMethod.invoke(paramAnonymousObject, paramAnonymousArrayOfObject);
        paramAnonymousMethod = c.cm(paramAnonymousObject);
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
        paramAnonymousMethod = c.cn(paramAnonymousObject);
      } while (paramAnonymousMethod == null);
      return paramAnonymousMethod;
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject) {}
  };
  private static n eTu = new n("bluetooth_manager", "android.bluetooth.IBluetoothManager", eTt);
  private static List<a> eTv = new ArrayList();
  
  public static void a(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        if (eTv.contains(parama)) {
          continue;
        }
        eTv.add(parama);
        if ((eTs) || (eTv.isEmpty())) {
          continue;
        }
        com.tencent.matrix.e.c.i("Matrix.battery.BluetoothHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(eTu.doHook()) });
        eTs = true;
      }
      finally {}
    }
  }
  
  private static Object b(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      if (paramObject != null) {
        return paramObject;
      }
    }
    finally
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
  
  public static void b(a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      try
      {
        eTv.remove(parama);
        if ((!eTs) || (!eTv.isEmpty())) {
          continue;
        }
        com.tencent.matrix.e.c.i("Matrix.battery.BluetoothHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(eTu.doUnHook()) });
        eTs = false;
      }
      finally {}
    }
  }
  
  private static Object ck(Object paramObject)
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
            paramAnonymousObject = c.c(this.eTE, paramAnonymousMethod, paramAnonymousArrayOfObject);
            return paramAnonymousObject;
          }
          finally
          {
            com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramAnonymousObject, "invokeBluetooth fail", new Object[0]);
          }
          return null;
        }
      };
      paramObject = Proxy.newProxyInstance(localClassLoader, new Class[] { IBinder.class, IInterface.class, localClass }, paramObject);
      return paramObject;
    }
    finally
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramObject, "proxyBluetooth fail", new Object[0]);
    }
    return null;
  }
  
  private static Object cl(Object paramObject)
  {
    try
    {
      Class localClass = Class.forName("android.bluetooth.IBluetoothGatt");
      ClassLoader localClassLoader = paramObject.getClass().getClassLoader();
      paramObject = new InvocationHandler()
      {
        /* Error */
        public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        {
          // Byte code:
          //   0: ldc 25
          //   2: aload_2
          //   3: invokevirtual 31	java/lang/reflect/Method:getName	()Ljava/lang/String;
          //   6: invokevirtual 37	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   9: ifeq +18 -> 27
          //   12: invokestatic 40	com/tencent/matrix/a/b/c:access$400	()V
          //   15: aload_0
          //   16: getfield 17	com/tencent/matrix/a/b/c$3:eTE	Ljava/lang/Object;
          //   19: aload_2
          //   20: aload_3
          //   21: invokestatic 43	com/tencent/matrix/a/b/c:c	(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
          //   24: astore_1
          //   25: aload_1
          //   26: areturn
          //   27: ldc 45
          //   29: aload_2
          //   30: invokevirtual 31	java/lang/reflect/Method:getName	()Ljava/lang/String;
          //   33: invokevirtual 37	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   36: ifeq +52 -> 88
          //   39: iconst_m1
          //   40: istore 4
          //   42: iload 4
          //   44: istore 5
          //   46: aload_3
          //   47: arraylength
          //   48: ifle +32 -> 80
          //   51: aload_3
          //   52: iconst_0
          //   53: aaload
          //   54: instanceof 47
          //   57: ifeq +14 -> 71
          //   60: aload_3
          //   61: iconst_0
          //   62: aaload
          //   63: checkcast 47	java/lang/Integer
          //   66: invokevirtual 51	java/lang/Integer:intValue	()I
          //   69: istore 4
          //   71: getstatic 57	android/os/Build$VERSION:SDK_INT	I
          //   74: istore 5
          //   76: iload 4
          //   78: istore 5
          //   80: iload 5
          //   82: invokestatic 61	com/tencent/matrix/a/b/c:nc	(I)V
          //   85: goto -70 -> 15
          //   88: ldc 63
          //   90: aload_2
          //   91: invokevirtual 31	java/lang/reflect/Method:getName	()Ljava/lang/String;
          //   94: invokevirtual 37	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   97: ifeq -82 -> 15
          //   100: getstatic 57	android/os/Build$VERSION:SDK_INT	I
          //   103: istore 4
          //   105: invokestatic 66	com/tencent/matrix/a/b/c:axs	()V
          //   108: goto -93 -> 15
          //   111: astore_1
          //   112: ldc 68
          //   114: aload_1
          //   115: ldc 70
          //   117: iconst_0
          //   118: anewarray 4	java/lang/Object
          //   121: invokestatic 76	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   124: aconst_null
          //   125: areturn
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	126	0	this	3
          //   0	126	1	paramAnonymousObject	Object
          //   0	126	2	paramAnonymousMethod	Method
          //   0	126	3	paramAnonymousArrayOfObject	Object[]
          //   40	64	4	i	int
          //   44	37	5	j	int
          // Exception table:
          //   from	to	target	type
          //   15	25	111	finally
        }
      };
      paramObject = Proxy.newProxyInstance(localClassLoader, new Class[] { IBinder.class, IInterface.class, localClass }, paramObject);
      return paramObject;
    }
    finally
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.BluetoothHooker", paramObject, "proxyBluetoothGatt fail", new Object[0]);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void awT();
    
    public abstract void awU();
    
    public abstract void awV();
    
    public abstract void mV(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.c
 * JD-Core Version:    0.7.0.1
 */