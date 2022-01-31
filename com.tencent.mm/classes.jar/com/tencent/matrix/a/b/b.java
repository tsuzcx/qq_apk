package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static com.tencent.matrix.a.c.b bMA;
  private static List<c> bMB;
  private static Class bMC;
  private static Field bMD;
  private static boolean bMy;
  private static com.tencent.matrix.a.c.b.b bMz = new com.tencent.matrix.a.c.b.b()
  {
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      c.v("Matrix.AlarmManagerServiceHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      b.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  
  static
  {
    bMA = new com.tencent.matrix.a.c.b("alarm", "android.app.IAlarmManager", bMz);
    bMB = new ArrayList();
    try
    {
      Object localObject = Class.forName("android.app.AlarmManager$ListenerWrapper");
      bMC = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("mListener");
      bMD = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      c.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", new Object[] { localClassNotFoundException });
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      c.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", new Object[] { localNoSuchFieldException });
    }
  }
  
  /* Error */
  public static void a(c paramc)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 61	com/tencent/matrix/a/b/b:bMB	Ljava/util/List;
    //   6: aload_0
    //   7: invokeinterface 104 2 0
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: getstatic 61	com/tencent/matrix/a/b/b:bMB	Ljava/util/List;
    //   24: aload_0
    //   25: invokeinterface 107 2 0
    //   30: pop
    //   31: getstatic 109	com/tencent/matrix/a/b/b:bMy	Z
    //   34: ifne -17 -> 17
    //   37: getstatic 61	com/tencent/matrix/a/b/b:bMB	Ljava/util/List;
    //   40: invokeinterface 113 1 0
    //   45: ifne -28 -> 17
    //   48: ldc 87
    //   50: ldc 115
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: getstatic 56	com/tencent/matrix/a/b/b:bMA	Lcom/tencent/matrix/a/c/b;
    //   61: invokevirtual 118	com/tencent/matrix/a/c/b:doHook	()Z
    //   64: invokestatic 124	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: aastore
    //   68: invokestatic 127	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: iconst_1
    //   72: putstatic 109	com/tencent/matrix/a/b/b:bMy	Z
    //   75: goto -58 -> 17
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramc	c
    //   12	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	13	78	finally
    //   21	75	78	finally
  }
  
  public static void b(c paramc)
  {
    try
    {
      bMB.remove(paramc);
      if ((bMy) && (bMB.isEmpty()))
      {
        c.i("Matrix.AlarmManagerServiceHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(bMA.doUnHook()) });
        bMy = false;
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  static final class a
  {
    AlarmManager.OnAlarmListener bMm;
    PendingIntent bMu;
  }
  
  static final class b
  {
    static b.a e(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length != 2)
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args length invalid : %d", new Object[] { Integer.valueOf(paramArrayOfObject.length) });
        return null;
      }
      b.a locala = new b.a((byte)0);
      if ((paramArrayOfObject[0] != null) && (!(paramArrayOfObject[0] instanceof PendingIntent)))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", new Object[] { paramArrayOfObject[0] });
        return null;
      }
      locala.bMu = ((PendingIntent)paramArrayOfObject[0]);
      if ((b.yL() == null) || (b.yM() == null))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
        return null;
      }
      if ((paramArrayOfObject[1] != null) && (!b.yL().isInstance(paramArrayOfObject[1])))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not ListenerWrapper, %s", new Object[] { paramArrayOfObject[1] });
        return null;
      }
      if (paramArrayOfObject[1] != null) {}
      try
      {
        locala.bMm = ((AlarmManager.OnAlarmListener)b.yM().get(paramArrayOfObject[1]));
        return locala;
      }
      catch (IllegalAccessException paramArrayOfObject)
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 init exp:%s", new Object[] { paramArrayOfObject.getLocalizedMessage() });
      }
      return null;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
    
    public abstract void a(PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
  }
  
  static final class d
  {
    long bME;
    long bMj;
    long bMk;
    AlarmManager.OnAlarmListener bMm;
    PendingIntent bMu;
    int flags;
    int type;
  }
  
  static final class e
  {
    static b.d f(Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject.length != 11)
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", new Object[] { Integer.valueOf(paramArrayOfObject.length) });
        return null;
      }
      b.d locald = new b.d((byte)0);
      if (!(paramArrayOfObject[1] instanceof Integer))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Integer, %s", new Object[] { paramArrayOfObject[1] });
        return null;
      }
      locald.type = ((Integer)paramArrayOfObject[1]).intValue();
      if (!(paramArrayOfObject[2] instanceof Long))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", new Object[] { paramArrayOfObject[2] });
        return null;
      }
      locald.bMj = ((Long)paramArrayOfObject[2]).longValue();
      if (!(paramArrayOfObject[3] instanceof Long))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", new Object[] { paramArrayOfObject[3] });
        return null;
      }
      locald.bME = ((Long)paramArrayOfObject[3]).longValue();
      if (!(paramArrayOfObject[4] instanceof Long))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Long, %s", new Object[] { paramArrayOfObject[4] });
        return null;
      }
      locald.bMk = ((Long)paramArrayOfObject[4]).longValue();
      if (!(paramArrayOfObject[5] instanceof Integer))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not Integer, %s", new Object[] { paramArrayOfObject[5] });
        return null;
      }
      locald.flags = ((Integer)paramArrayOfObject[5]).intValue();
      if ((paramArrayOfObject[6] != null) && (!(paramArrayOfObject[6] instanceof PendingIntent)))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 6 not PendingIntent, %s", new Object[] { paramArrayOfObject[6] });
        return null;
      }
      locald.bMu = ((PendingIntent)paramArrayOfObject[6]);
      if ((b.yL() == null) || (b.yM() == null))
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
        return null;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        if ((paramArrayOfObject[7] != null) && (!b.yL().isInstance(paramArrayOfObject[7])))
        {
          c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 not ListenerWrapper, %s", new Object[] { paramArrayOfObject[7] });
          return null;
        }
        if (paramArrayOfObject[7] == null) {}
      }
      try
      {
        locald.bMm = ((AlarmManager.OnAlarmListener)b.yM().get(paramArrayOfObject[7]));
        return locald;
      }
      catch (IllegalAccessException paramArrayOfObject)
      {
        c.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 init exp:%s", new Object[] { paramArrayOfObject.getLocalizedMessage() });
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.b
 * JD-Core Version:    0.7.0.1
 */