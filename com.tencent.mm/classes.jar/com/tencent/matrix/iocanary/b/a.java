package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.report.d.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a
{
  private static volatile Object cvV;
  public volatile boolean cvU;
  private final d.a cvW;
  
  public a(d.a parama)
  {
    this.cvW = parama;
  }
  
  public static boolean Hn()
  {
    try
    {
      Object localObject = Class.forName("dalvik.system.CloseGuard");
      Method localMethod = ((Class)localObject).getDeclaredMethod("setReporter", new Class[] { Class.forName("dalvik.system.CloseGuard$Reporter") });
      localObject = ((Class)localObject).getDeclaredMethod("setEnabled", new Class[] { Boolean.TYPE });
      localMethod.invoke(null, new Object[] { cvV });
      ((Method)localObject).invoke(null, new Object[] { Boolean.FALSE });
      c.setEnabled(false);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.g.c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", new Object[] { localThrowable });
    }
    return false;
  }
  
  public final boolean Hm()
  {
    try
    {
      Object localObject2 = Class.forName("dalvik.system.CloseGuard");
      Class localClass = Class.forName("dalvik.system.CloseGuard$Reporter");
      Object localObject1 = ((Class)localObject2).getDeclaredMethod("getReporter", new Class[0]);
      Method localMethod = ((Class)localObject2).getDeclaredMethod("setReporter", new Class[] { localClass });
      localObject2 = ((Class)localObject2).getDeclaredMethod("setEnabled", new Class[] { Boolean.TYPE });
      cvV = ((Method)localObject1).invoke(null, new Object[0]);
      ((Method)localObject2).invoke(null, new Object[] { Boolean.TRUE });
      c.setEnabled(true);
      localObject1 = localClass.getClassLoader();
      if (localObject1 == null) {
        return false;
      }
      localObject2 = new b(this.cvW, cvV);
      localMethod.invoke(null, new Object[] { Proxy.newProxyInstance((ClassLoader)localObject1, new Class[] { localClass }, (InvocationHandler)localObject2) });
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.g.c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", new Object[] { localThrowable });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.b.a
 * JD-Core Version:    0.7.0.1
 */