package com.tencent.matrix.a.b;

import android.os.IBinder;
import android.os.WorkSource;
import com.tencent.matrix.a.d.b;
import com.tencent.matrix.a.d.b.b;
import com.tencent.matrix.g.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class e
{
  private static boolean cBZ;
  private static b.b cCa = new b.b()
  {
    public final void b(Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
    {
      c.v("Matrix.PowerManagerServiceHooker", "onServiceMethodInvoke: method name %s", new Object[] { paramAnonymousMethod.getName() });
      e.a(paramAnonymousMethod, paramAnonymousArrayOfObject);
    }
  };
  private static b cCb = new b("power", "android.os.IPowerManager", cCa);
  private static List<b> cCc = new ArrayList();
  
  /* Error */
  public static void a(b paramb)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 33	com/tencent/matrix/a/b/e:cCc	Ljava/util/List;
    //   6: aload_0
    //   7: invokeinterface 56 2 0
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: getstatic 33	com/tencent/matrix/a/b/e:cCc	Ljava/util/List;
    //   24: aload_0
    //   25: invokeinterface 59 2 0
    //   30: pop
    //   31: getstatic 61	com/tencent/matrix/a/b/e:cBZ	Z
    //   34: ifne -17 -> 17
    //   37: getstatic 33	com/tencent/matrix/a/b/e:cCc	Ljava/util/List;
    //   40: invokeinterface 65 1 0
    //   45: ifne -28 -> 17
    //   48: ldc 67
    //   50: ldc 69
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: getstatic 47	com/tencent/matrix/a/b/e:cCb	Lcom/tencent/matrix/a/d/b;
    //   61: invokevirtual 72	com/tencent/matrix/a/d/b:doHook	()Z
    //   64: invokestatic 78	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: aastore
    //   68: invokestatic 84	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: iconst_1
    //   72: putstatic 61	com/tencent/matrix/a/b/e:cBZ	Z
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
      cCc.remove(paramb);
      if ((cBZ) && (cCc.isEmpty()))
      {
        c.i("Matrix.PowerManagerServiceHooker", "checkUnHook unHookRet:%b", new Object[] { Boolean.valueOf(cCb.doUnHook()) });
        cBZ = false;
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
    WorkSource cCx;
    String cCy;
    int flags;
    String packageName;
    String tag;
    IBinder token;
  }
  
  public static abstract interface b
  {
    public abstract void a(IBinder paramIBinder, int paramInt);
    
    public abstract void a(IBinder paramIBinder, int paramInt, String paramString1, String paramString2, WorkSource paramWorkSource, String paramString3);
  }
  
  static final class c
  {
    int flags;
    IBinder token;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.b.e
 * JD-Core Version:    0.7.0.1
 */