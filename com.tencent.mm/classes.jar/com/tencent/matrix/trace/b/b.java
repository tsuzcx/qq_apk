package com.tencent.matrix.trace.b;

import android.os.Handler.Callback;
import com.tencent.matrix.trace.core.MethodBeat;
import java.lang.reflect.Field;

public final class b
{
  public static boolean brh = false;
  public static long bri = 0L;
  public static int brj = 0;
  public static long brk = 0L;
  public static int brl = 0;
  public static int brm = -100;
  
  public static void rp()
  {
    try
    {
      bri = System.currentTimeMillis();
      brj = MethodBeat.getCurIndex();
      Object localObject1 = Class.forName("android.app.ActivityThread");
      Object localObject2 = ((Class)localObject1).getDeclaredField("sCurrentActivityThread");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localObject1);
      localObject1 = ((Class)localObject1).getDeclaredField("mH");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(localObject2);
      localObject2 = localObject1.getClass().getSuperclass().getDeclaredField("mCallback");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(localObject1, new a((Handler.Callback)((Field)localObject2).get(localObject1)));
      com.tencent.matrix.d.b.i("Matrix.Hacker", "hook system handler completed. start:%s", new Object[] { Long.valueOf(bri) });
      return;
    }
    catch (Exception localException)
    {
      com.tencent.matrix.d.b.e("Matrix.Hacker", "hook system handler err! %s", new Object[] { localException.getCause().toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.b.b
 * JD-Core Version:    0.7.0.1
 */