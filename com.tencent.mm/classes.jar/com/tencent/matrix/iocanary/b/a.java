package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.c.c.a;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public final class a
{
  private static volatile Object boy;
  public volatile boolean bow;
  private final c.a boz;
  
  public a(c.a parama)
  {
    this.boz = parama;
  }
  
  public static boolean rd()
  {
    try
    {
      Object localObject = Class.forName("dalvik.system.CloseGuard");
      Field localField = ((Class)localObject).getDeclaredField("REPORTER");
      localField.setAccessible(true);
      localField.set(null, boy);
      localObject = ((Class)localObject).getDeclaredField("ENABLED");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(null, Boolean.valueOf(false));
      localField.setAccessible(false);
      c.setEnabled(false);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.d.b.e("Matrix.CloseGuardHooker", "tryHook exp=%s", new Object[] { localThrowable });
    }
    return false;
  }
  
  public final boolean rc()
  {
    try
    {
      Object localObject = Class.forName("dalvik.system.CloseGuard");
      Class localClass = Class.forName("dalvik.system.CloseGuard$Reporter");
      Field localField = ((Class)localObject).getDeclaredField("REPORTER");
      localObject = ((Class)localObject).getDeclaredField("ENABLED");
      localField.setAccessible(true);
      ((Field)localObject).setAccessible(true);
      boy = localField.get(null);
      ((Field)localObject).set(null, Boolean.valueOf(true));
      c.setEnabled(true);
      localObject = localClass.getClassLoader();
      if (localObject == null) {
        return false;
      }
      b localb = new b(this.boz, boy);
      localField.set(null, Proxy.newProxyInstance((ClassLoader)localObject, new Class[] { localClass }, localb));
      localField.setAccessible(false);
      return true;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.d.b.e("Matrix.CloseGuardHooker", "tryHook exp=%s", new Object[] { localThrowable });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.b.a
 * JD-Core Version:    0.7.0.1
 */