package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import com.tencent.matrix.e.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static boolean eTs;
  private static n.b eTt = new n.b()
  {
    public final Object a(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      return null;
    }
    
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      c.v("Matrix.battery.AlarmHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      a.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static n eTu = new n("alarm", "android.app.IAlarmManager", eTt);
  private static List<b> eTv = new ArrayList();
  
  public static void a(b paramb)
  {
    if (paramb == null) {}
    for (;;)
    {
      return;
      try
      {
        if (eTv.contains(paramb)) {
          continue;
        }
        eTv.add(paramb);
        if ((eTs) || (eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.AlarmHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(eTu.doHook()) });
        eTs = true;
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
        eTv.remove(paramb);
        if ((!eTs) || (!eTv.isEmpty())) {
          continue;
        }
        c.i("Matrix.battery.AlarmHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(eTu.doUnHook()) });
        eTs = false;
      }
      finally {}
    }
  }
  
  static final class a
  {
    PendingIntent eTw;
    AlarmManager.OnAlarmListener eTx;
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
    
    public abstract void a(PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
  }
  
  static final class c
  {
    long eQm;
    long eQn;
    long eQo;
    PendingIntent eTw;
    AlarmManager.OnAlarmListener eTx;
    int flags;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.a
 * JD-Core Version:    0.7.0.1
 */