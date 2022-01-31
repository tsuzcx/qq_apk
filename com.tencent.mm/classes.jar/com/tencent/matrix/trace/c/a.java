package com.tencent.matrix.trace.c;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class a
{
  private static long bRD = 0L;
  private static long bRE = 0L;
  private static long bRF = 0L;
  public static AppMethodBeat.a bRG = new AppMethodBeat.a();
  public static AppMethodBeat.a bRH = new AppMethodBeat.a();
  public static int bRI = -100;
  
  public static void zu()
  {
    try
    {
      bRD = SystemClock.uptimeMillis();
      bRH = AppMethodBeat.getInstance().maskIndex("ApplicationCreateBeginMethodIndex");
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
      c.i("Matrix.ActivityThreadHacker", "hook system handler completed. start:%s SDK_INT:%s", new Object[] { Long.valueOf(bRD), Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    catch (Exception localException)
    {
      c.e("Matrix.ActivityThreadHacker", "hook system handler err! %s", new Object[] { localException.getCause().toString() });
    }
  }
  
  public static long zv()
  {
    return bRE - bRD;
  }
  
  public static long zw()
  {
    return bRD;
  }
  
  public static long zx()
  {
    return bRF;
  }
  
  static final class a
    implements Handler.Callback
  {
    private static boolean bRJ = false;
    private static int bRK = 10;
    private final Handler.Callback bRL;
    private Method method = null;
    
    a(Handler.Callback paramCallback)
    {
      this.bRL = paramCallback;
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
      return paramMessage.what == 100;
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      if (!AppMethodBeat.isRealTrace()) {
        if (this.bRL != null) {}
      }
      do
      {
        return false;
        return this.bRL.handleMessage(paramMessage);
        boolean bool = g(paramMessage);
        if (bRK > 0)
        {
          c.i("Matrix.ActivityThreadHacker", "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s", new Object[] { Integer.valueOf(paramMessage.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(bool) });
          bRK -= 1;
        }
        if (bool)
        {
          a.ax(SystemClock.uptimeMillis());
          a.bRG = AppMethodBeat.getInstance().maskIndex("LastLaunchActivityMethodIndex");
        }
        if ((!bRJ) && ((bool) || (paramMessage.what == 114) || (paramMessage.what == 113)))
        {
          a.ay(SystemClock.uptimeMillis());
          a.bRI = paramMessage.what;
          bRJ = true;
        }
      } while (this.bRL == null);
      return this.bRL.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.c.a
 * JD-Core Version:    0.7.0.1
 */