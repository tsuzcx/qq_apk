package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import com.tencent.matrix.g.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static boolean cCG;
  private static com.tencent.matrix.a.d.b.b cCH = new com.tencent.matrix.a.d.b.b()
  {
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      c.v("Matrix.AlarmManagerServiceHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      b.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static com.tencent.matrix.a.d.b cCI = new com.tencent.matrix.a.d.b("alarm", "android.app.IAlarmManager", cCH);
  private static List<b> cCJ = new ArrayList();
  
  /* Error */
  public static void a(b paramb)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/tencent/matrix/a/b/b:cCJ	Ljava/util/List;
    //   6: aload_0
    //   7: invokeinterface 56 2 0
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: getstatic 47	com/tencent/matrix/a/b/b:cCJ	Ljava/util/List;
    //   24: aload_0
    //   25: invokeinterface 59 2 0
    //   30: pop
    //   31: getstatic 61	com/tencent/matrix/a/b/b:cCG	Z
    //   34: ifne -17 -> 17
    //   37: getstatic 47	com/tencent/matrix/a/b/b:cCJ	Ljava/util/List;
    //   40: invokeinterface 65 1 0
    //   45: ifne -28 -> 17
    //   48: ldc 67
    //   50: ldc 69
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: getstatic 42	com/tencent/matrix/a/b/b:cCI	Lcom/tencent/matrix/a/d/b;
    //   61: invokevirtual 72	com/tencent/matrix/a/d/b:doHook	()Z
    //   64: invokestatic 78	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: aastore
    //   68: invokestatic 84	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: iconst_1
    //   72: putstatic 61	com/tencent/matrix/a/b/b:cCG	Z
    //   75: goto -58 -> 17
    //   78: astore_0
    //   79: ldc 2
    //   81: monitorexit
    //   82: aload_0
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramb	b
    //   12	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	13	78	finally
    //   21	75	78	finally
  }
  
  public static void b(b paramb)
  {
    try
    {
      cCJ.remove(paramb);
      if ((cCG) && (cCJ.isEmpty()))
      {
        c.i("Matrix.AlarmManagerServiceHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(cCI.doUnHook()) });
        cCG = false;
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  static final class a
  {
    PendingIntent cCC;
    AlarmManager.OnAlarmListener cCu;
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
    
    public abstract void a(PendingIntent paramPendingIntent, AlarmManager.OnAlarmListener paramOnAlarmListener);
  }
  
  static final class c
  {
    PendingIntent cCC;
    long cCK;
    long cCr;
    long cCs;
    AlarmManager.OnAlarmListener cCu;
    int flags;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.b
 * JD-Core Version:    0.7.0.1
 */