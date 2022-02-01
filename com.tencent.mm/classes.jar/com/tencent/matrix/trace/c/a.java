package com.tencent.matrix.trace.c;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
{
  private static long dfC = 0L;
  private static long dfD = 0L;
  public static AppMethodBeat.a dfE = new AppMethodBeat.a();
  public static AppMethodBeat.a dfF = new AppMethodBeat.a();
  public static int dfG = -2147483648;
  private static boolean dfH = false;
  private static final HashSet<b> listeners = new HashSet();
  
  public static void Yb()
  {
    try
    {
      dfC = SystemClock.uptimeMillis();
      dfF = AppMethodBeat.getInstance().maskIndex("ApplicationCreateBeginMethodIndex");
      Object localObject1 = Class.forName("android.app.ActivityThread");
      Object localObject2 = ((Class)localObject1).getDeclaredField("sCurrentActivityThread");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localObject1);
      localObject1 = ((Class)localObject1).getDeclaredField("mH");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(localObject2);
      localObject2 = localObject1.getClass().getSuperclass();
      if (localObject2 != null)
      {
        localObject2 = ((Class)localObject2).getDeclaredField("mCallback");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(localObject1, new a((Handler.Callback)((Field)localObject2).get(localObject1)));
      }
      c.i("Matrix.ActivityThreadHacker", "hook system handler completed. start:%s SDK_INT:%s", new Object[] { Long.valueOf(dfC), Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    catch (Exception localException)
    {
      c.e("Matrix.ActivityThreadHacker", "hook system handler err! %s", new Object[] { localException.getCause().toString() });
    }
  }
  
  public static long Yc()
  {
    return dfD - dfC;
  }
  
  public static long Yd()
  {
    return dfC;
  }
  
  public static boolean Ye()
  {
    return dfH;
  }
  
  public static void a(b paramb)
  {
    synchronized (listeners)
    {
      listeners.add(paramb);
      return;
    }
  }
  
  static final class a
    implements Handler.Callback
  {
    private static boolean dfI = false;
    private static int dfJ = 2147483647;
    private final Handler.Callback dfK;
    private Method method = null;
    
    a(Handler.Callback paramCallback)
    {
      this.dfK = paramCallback;
    }
    
    private boolean g(Message paramMessage)
    {
      if (Build.VERSION.SDK_INT > 27)
      {
        if ((paramMessage.what == 159) && (paramMessage.obj != null)) {
          try
          {
            if (this.method == null)
            {
              this.method = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
              this.method.setAccessible(true);
            }
            List localList = (List)this.method.invoke(paramMessage.obj, new Object[0]);
            if (!localList.isEmpty())
            {
              boolean bool = localList.get(0).getClass().getName().endsWith(".LaunchActivityItem");
              return bool;
            }
          }
          catch (Exception localException)
          {
            c.e("Matrix.ActivityThreadHacker", "[isLaunchActivity] %s", new Object[] { localException });
          }
        }
        return paramMessage.what == 100;
      }
      return (paramMessage.what == 100) || (paramMessage.what == 126);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT <= 25) && ((paramMessage.what == 115) || (paramMessage.what == 116) || (paramMessage.what == 103) || (paramMessage.what == 104) || (paramMessage.what == 137))) {
        c.i("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] start to fix msg.waht=" + paramMessage.what, new Object[0]);
      }
      try
      {
        Field localField = Class.forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");
        if (localField != null)
        {
          localField.setAccessible(true);
          ((ConcurrentLinkedQueue)localField.get(null)).clear();
          c.i("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] sPendingWorkFinishers.clear successful", new Object[0]);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] ClassNotFoundException = " + localClassNotFoundException.getMessage(), new Object[0]);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] IllegalAccessException =" + localIllegalAccessException.getMessage(), new Object[0]);
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] NoSuchFieldException = " + localNoSuchFieldException.getMessage(), new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          c.e("Matrix.ActivityThreadHacker", "[Matrix.fix.sp.apply] Exception = " + localException.getMessage(), new Object[0]);
        }
      }
      if (!AppMethodBeat.isRealTrace()) {
        return (this.dfK != null) && (this.dfK.handleMessage(paramMessage));
      }
      boolean bool = g(paramMessage);
      if (dfJ > 0)
      {
        c.i("Matrix.ActivityThreadHacker", "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s SDK_INT=%s", new Object[] { Integer.valueOf(paramMessage.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        dfJ -= 1;
      }
      if ((!dfI) && ((bool) || (paramMessage.what == 114) || (paramMessage.what == 113)))
      {
        a.bq(SystemClock.uptimeMillis());
        a.dfG = paramMessage.what;
        dfI = true;
        a.access$102(bool);
        c.i("Matrix.ActivityThreadHacker", "application create end, sApplicationCreateScene:%d, isLaunchActivity:%s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(bool) });
        synchronized (a.Yf())
        {
          Iterator localIterator = a.Yf().iterator();
          if (localIterator.hasNext()) {
            ((a.b)localIterator.next()).Yg();
          }
        }
      }
      return (this.dfK != null) && (this.dfK.handleMessage(paramMessage));
    }
  }
  
  public static abstract interface b
  {
    public abstract void Yg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.c.a
 * JD-Core Version:    0.7.0.1
 */