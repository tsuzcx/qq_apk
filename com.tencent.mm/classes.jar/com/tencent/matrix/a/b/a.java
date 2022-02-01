package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static boolean cXl;
  private static j.b cXm = new j.b()
  {
    public final Object b(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      c.v("Matrix.battery.AlarmHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      a.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static j cXn = new j("alarm", "android.app.IAlarmManager", cXm);
  private static List<b> cXo = new ArrayList();
  
  public static void a(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (cXo.contains(paramb)) {
          continue;
        }
        cXo.add(paramb);
        if ((cXl) || (cXo.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.AlarmHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(cXn.doHook()) });
        cXl = true;
      }
      finally {}
    }
  }
  
  public static void b(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        cXo.remove(paramb);
        if ((!cXl) || (!cXo.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.AlarmHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(cXn.doUnHook()) });
        cXl = false;
      }
      finally {}
    }
  }
  
  static final class a
  {
    PendingIntent cXp;
    AlarmManager.OnAlarmListener cXq;
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
    
    public abstract void a(PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
  }
  
  static final class c
  {
    long cUM;
    long cUN;
    long cUO;
    PendingIntent cXp;
    AlarmManager.OnAlarmListener cXq;
    int flags;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.a
 * JD-Core Version:    0.7.0.1
 */