package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static boolean bmY;
  private static com.tencent.matrix.a.c.b.b bmZ = new com.tencent.matrix.a.c.b.b()
  {
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      com.tencent.matrix.d.b.v("Matrix.AlarmManagerServiceHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      b.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static com.tencent.matrix.a.c.b bna = new com.tencent.matrix.a.c.b("alarm", "android.app.IAlarmManager", bmZ);
  private static List<c> bnb = new ArrayList();
  private static Class bnc;
  private static Field bnd;
  
  static
  {
    try
    {
      Object localObject = Class.forName("android.app.AlarmManager$ListenerWrapper");
      bnc = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("mListener");
      bnd = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", new Object[] { localClassNotFoundException });
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", new Object[] { localNoSuchFieldException });
    }
  }
  
  public static void a(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      try
      {
        if (bnb.contains(paramc)) {
          continue;
        }
        bnb.add(paramc);
        if ((bmY) || (bnb.isEmpty())) {
          continue;
        }
        com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "checkHook hookRet:%b", new Object[] { Boolean.valueOf(bna.doHook()) });
        bmY = true;
      }
      finally {}
    }
  }
  
  public static void b(c paramc)
  {
    if (paramc == null) {}
    for (;;)
    {
      return;
      try
      {
        bnb.remove(paramc);
        if ((!bmY) || (!bnb.isEmpty())) {
          continue;
        }
        com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(bna.doUnHook()) });
        bmY = false;
      }
      finally {}
    }
  }
  
  private static final class a
  {
    AlarmManager.OnAlarmListener bmM;
    PendingIntent bmU;
  }
  
  private static final class b
  {
    static b.a d(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length != 2)
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args length invalid : %d", new Object[] { Integer.valueOf(paramArrayOfObject.length) });
        return null;
      }
      b.a locala = new b.a((byte)0);
      if ((paramArrayOfObject[0] != null) && (!(paramArrayOfObject[0] instanceof PendingIntent)))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", new Object[] { paramArrayOfObject[0] });
        return null;
      }
      locala.bmU = ((PendingIntent)paramArrayOfObject[0]);
      if ((b.qT() == null) || (b.qU() == null))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
        return null;
      }
      if ((paramArrayOfObject[1] != null) && (!b.qT().isInstance(paramArrayOfObject[1])))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not ListenerWrapper, %s", new Object[] { paramArrayOfObject[1] });
        return null;
      }
      if (paramArrayOfObject[1] != null) {}
      try
      {
        locala.bmM = ((AlarmManager.OnAlarmListener)b.qU().get(paramArrayOfObject[1]));
        return locala;
      }
      catch (IllegalAccessException paramArrayOfObject)
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 init exp:%s", new Object[] { paramArrayOfObject.getLocalizedMessage() });
      }
      return null;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
    
    public abstract void a(PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
  }
  
  private static final class d
  {
    long bmJ;
    long bmK;
    AlarmManager.OnAlarmListener bmM;
    PendingIntent bmU;
    long bne;
    int flags;
    int type;
  }
  
  private static final class e
  {
    static b.d e(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length != 11)
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", new Object[] { Integer.valueOf(paramArrayOfObject.length) });
        return null;
      }
      b.d locald = new b.d((byte)0);
      if (!(paramArrayOfObject[1] instanceof Integer))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Integer, %s", new Object[] { paramArrayOfObject[1] });
        return null;
      }
      locald.type = ((Integer)paramArrayOfObject[1]).intValue();
      if (!(paramArrayOfObject[2] instanceof Long))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", new Object[] { paramArrayOfObject[2] });
        return null;
      }
      locald.bmJ = ((Long)paramArrayOfObject[2]).longValue();
      if (!(paramArrayOfObject[3] instanceof Long))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", new Object[] { paramArrayOfObject[3] });
        return null;
      }
      locald.bne = ((Long)paramArrayOfObject[3]).longValue();
      if (!(paramArrayOfObject[4] instanceof Long))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Long, %s", new Object[] { paramArrayOfObject[4] });
        return null;
      }
      locald.bmK = ((Long)paramArrayOfObject[4]).longValue();
      if (!(paramArrayOfObject[5] instanceof Integer))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not Integer, %s", new Object[] { paramArrayOfObject[5] });
        return null;
      }
      locald.flags = ((Integer)paramArrayOfObject[5]).intValue();
      if ((paramArrayOfObject[6] != null) && (!(paramArrayOfObject[6] instanceof PendingIntent)))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 6 not PendingIntent, %s", new Object[] { paramArrayOfObject[6] });
        return null;
      }
      locald.bmU = ((PendingIntent)paramArrayOfObject[6]);
      if ((b.qT() == null) || (b.qU() == null))
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
        return null;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        if ((paramArrayOfObject[7] != null) && (!b.qT().isInstance(paramArrayOfObject[7])))
        {
          com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 not ListenerWrapper, %s", new Object[] { paramArrayOfObject[7] });
          return null;
        }
        if (paramArrayOfObject[7] == null) {}
      }
      try
      {
        locald.bmM = ((AlarmManager.OnAlarmListener)b.qU().get(paramArrayOfObject[7]));
        return locald;
      }
      catch (IllegalAccessException paramArrayOfObject)
      {
        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 init exp:%s", new Object[] { paramArrayOfObject.getLocalizedMessage() });
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.b
 * JD-Core Version:    0.7.0.1
 */