package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.report.h.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  private static volatile Object eVv;
  public volatile boolean eVu;
  private final h.a eVw;
  
  public a(h.a parama)
  {
    this.eVw = parama;
  }
  
  public static boolean axT()
  {
    try
    {
      Object localObject2 = Class.forName("dalvik.system.CloseGuard");
      Method localMethod = ((Class)localObject2).getDeclaredMethod("setReporter", new Class[] { Class.forName("dalvik.system.CloseGuard$Reporter") });
      localObject2 = ((Class)localObject2).getDeclaredMethod("setEnabled", new Class[] { Boolean.TYPE });
      localMethod.invoke(null, new Object[] { eVv });
      ((Method)localObject2).invoke(null, new Object[] { Boolean.FALSE });
      c.setEnabled(false);
      return true;
    }
    finally
    {
      com.tencent.matrix.e.c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", new Object[] { localObject1 });
    }
    return false;
  }
  
  public final boolean axS()
  {
    try
    {
      Object localObject3 = Class.forName("dalvik.system.CloseGuard");
      Class localClass = Class.forName("dalvik.system.CloseGuard$Reporter");
      Object localObject2 = ((Class)localObject3).getDeclaredMethod("getReporter", new Class[0]);
      Method localMethod = ((Class)localObject3).getDeclaredMethod("setReporter", new Class[] { localClass });
      localObject3 = ((Class)localObject3).getDeclaredMethod("setEnabled", new Class[] { Boolean.TYPE });
      eVv = ((Method)localObject2).invoke(null, new Object[0]);
      ((Method)localObject3).invoke(null, new Object[] { Boolean.TRUE });
      c.setEnabled(true);
      localObject2 = localClass.getClassLoader();
      if (localObject2 == null) {
        return false;
      }
      localObject3 = new b(this.eVw, eVv);
      localMethod.invoke(null, new Object[] { Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { localClass }, (InvocationHandler)localObject3) });
      return true;
    }
    finally
    {
      com.tencent.matrix.e.c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", new Object[] { localObject1 });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.iocanary.b.a
 * JD-Core Version:    0.7.0.1
 */