package com.tencent.matrix.trace.core;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.g.c;
import com.tencent.matrix.g.f;
import java.util.HashSet;
import java.util.Objects;

public final class a
  implements MessageQueue.IdleHandler
{
  private static final a cJW = new a();
  private static boolean cJX = false;
  private b cJT;
  private Looper cJU;
  private long cJV = 0L;
  public final HashSet<a> listeners = new HashSet();
  
  private a()
  {
    this(Looper.getMainLooper());
  }
  
  public a(Looper paramLooper)
  {
    Objects.requireNonNull(paramLooper);
    this.cJU = paramLooper;
    IZ();
    c(paramLooper);
  }
  
  private void IZ()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Printer localPrinter;
        if (!cJX)
        {
          localPrinter = (Printer)f.a(this.cJU.getClass(), "mLogging", this.cJU);
          localObject1 = localPrinter;
        }
        b localb;
        Looper localLooper;
        Object localObject3 = null;
      }
      catch (Exception localException2)
      {
        localException2 = localException2;
        cJX = true;
        if (this.cJT != null) {
          c.w("Matrix.LooperMonitor", "maybe thread:%s printer[%s] was replace other[%s]!", new Object[] { this.cJU.getThread().getName(), this.cJT, localObject1 });
        }
        localLooper = this.cJU;
        localb = new b(localObject1);
        this.cJT = localb;
        localLooper.setMessageLogging(localb);
        if (localObject1 != null) {
          c.i("Matrix.LooperMonitor", "reset printer, originPrinter[%s] in %s", new Object[] { localObject1, this.cJU.getThread().getName() });
        }
      }
      finally {}
    }
  }
  
  public static void a(a parama)
  {
    a locala = cJW;
    synchronized (locala.listeners)
    {
      locala.listeners.add(parama);
      return;
    }
  }
  
  /* Error */
  private void b(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmplt +14 -> 21
    //   10: aload_1
    //   11: invokevirtual 158	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   14: aload_0
    //   15: invokevirtual 164	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 72	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: ldc 166
    //   27: aload_1
    //   28: invokestatic 79	com/tencent/matrix/g/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 160	android/os/MessageQueue
    //   34: aload_0
    //   35: invokevirtual 164	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   38: goto -20 -> 18
    //   41: astore_1
    //   42: goto -24 -> 18
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	a
    //   0	50	1	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   21	38	41	java/lang/Exception
    //   2	18	45	finally
    //   21	38	45	finally
  }
  
  static void b(a parama)
  {
    a locala = cJW;
    synchronized (locala.listeners)
    {
      locala.listeners.remove(parama);
      return;
    }
  }
  
  /* Error */
  private void c(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 154	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmplt +14 -> 21
    //   10: aload_1
    //   11: invokevirtual 158	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   14: aload_0
    //   15: invokevirtual 172	android/os/MessageQueue:addIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 72	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: ldc 166
    //   27: aload_1
    //   28: invokestatic 79	com/tencent/matrix/g/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 160	android/os/MessageQueue
    //   34: aload_0
    //   35: invokevirtual 172	android/os/MessageQueue:addIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   38: goto -20 -> 18
    //   41: astore_1
    //   42: goto -24 -> 18
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	a
    //   0	50	1	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   21	38	41	java/lang/Exception
    //   2	18	45	finally
    //   21	38	45	finally
  }
  
  /* Error */
  public final void onRelease()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/tencent/matrix/trace/core/a:cJT	Lcom/tencent/matrix/trace/core/a$b;
    //   6: ifnull +85 -> 91
    //   9: aload_0
    //   10: getfield 50	com/tencent/matrix/trace/core/a:listeners	Ljava/util/HashSet;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 50	com/tencent/matrix/trace/core/a:listeners	Ljava/util/HashSet;
    //   20: invokevirtual 176	java/util/HashSet:clear	()V
    //   23: aload_1
    //   24: monitorexit
    //   25: ldc 85
    //   27: ldc 178
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 60	com/tencent/matrix/trace/core/a:cJU	Landroid/os/Looper;
    //   39: invokevirtual 91	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   42: invokevirtual 97	java/lang/Thread:getName	()Ljava/lang/String;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_0
    //   49: getfield 83	com/tencent/matrix/trace/core/a:cJT	Lcom/tencent/matrix/trace/core/a$b;
    //   52: getfield 182	com/tencent/matrix/trace/core/a$b:cJZ	Landroid/util/Printer;
    //   55: aastore
    //   56: invokestatic 185	com/tencent/matrix/g/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 60	com/tencent/matrix/trace/core/a:cJU	Landroid/os/Looper;
    //   63: aload_0
    //   64: getfield 83	com/tencent/matrix/trace/core/a:cJT	Lcom/tencent/matrix/trace/core/a$b;
    //   67: getfield 182	com/tencent/matrix/trace/core/a$b:cJZ	Landroid/util/Printer;
    //   70: invokevirtual 110	android/os/Looper:setMessageLogging	(Landroid/util/Printer;)V
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 60	com/tencent/matrix/trace/core/a:cJU	Landroid/os/Looper;
    //   78: invokespecial 187	com/tencent/matrix/trace/core/a:b	(Landroid/os/Looper;)V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 60	com/tencent/matrix/trace/core/a:cJU	Landroid/os/Looper;
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 83	com/tencent/matrix/trace/core/a:cJT	Lcom/tencent/matrix/trace/core/a$b;
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_2
    //   95: aload_1
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   99	4	1	localObject1	Object
    //   94	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	25	94	finally
    //   95	97	94	finally
    //   2	16	99	finally
    //   25	91	99	finally
    //   97	99	99	finally
  }
  
  public final boolean queueIdle()
  {
    if (SystemClock.uptimeMillis() - this.cJV >= 60000L)
    {
      IZ();
      this.cJV = SystemClock.uptimeMillis();
    }
    return true;
  }
  
  public static abstract class a
  {
    boolean cJY = false;
    
    public void dN(String paramString)
    {
      this.cJY = true;
      dispatchStart();
    }
    
    public void dispatchEnd() {}
    
    public void dispatchStart() {}
    
    public boolean isValid()
    {
      return false;
    }
  }
  
  final class b
    implements Printer
  {
    boolean cJS = false;
    public Printer cJZ;
    boolean cKa = false;
    
    b(Printer paramPrinter)
    {
      this.cJZ = paramPrinter;
    }
    
    public final void println(String paramString)
    {
      boolean bool2 = true;
      if (this.cJZ != null)
      {
        this.cJZ.println(paramString);
        if (this.cJZ == this) {
          throw new RuntimeException("Matrix.LooperMonitor origin == this");
        }
      }
      if (!this.cKa)
      {
        if ((paramString.charAt(0) != '>') && (paramString.charAt(0) != '<')) {
          break label131;
        }
        bool1 = true;
        this.cJS = bool1;
        this.cKa = true;
        if (!this.cJS) {
          c.e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", new Object[] { paramString });
        }
      }
      a locala;
      if (this.cJS)
      {
        locala = a.this;
        if (paramString.charAt(0) != '>') {
          break label136;
        }
      }
      label131:
      label136:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        a.a(locala, bool1, paramString);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.a
 * JD-Core Version:    0.7.0.1
 */