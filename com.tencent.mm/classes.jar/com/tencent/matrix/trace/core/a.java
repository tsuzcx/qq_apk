package com.tencent.matrix.trace.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.e.b;
import com.tencent.matrix.e.c;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a
  implements MessageQueue.IdleHandler
{
  private static final Map<Looper, a> fei = new ConcurrentHashMap();
  private static final a fej = c(Looper.getMainLooper());
  private static final HandlerThread fek = b.T("historyMsgHandlerThread", 5);
  private static final Handler fel = new Handler(fek.getLooper());
  private static long fem = 0L;
  private static final Queue<c> fen = new ConcurrentLinkedQueue();
  private static final Queue<c> feo = new ConcurrentLinkedQueue();
  private static String fep = "";
  private static long feq = 0L;
  private static long fer = 0L;
  private static boolean feu = false;
  private b fes;
  private long fet = 0L;
  private final HashSet<a> listeners = new HashSet();
  private Looper looper;
  
  private a(Looper paramLooper)
  {
    Objects.requireNonNull(paramLooper);
    this.looper = paramLooper;
    azF();
    e(paramLooper);
  }
  
  public static void a(a parama)
  {
    fej.c(parama);
  }
  
  /* Error */
  private void azF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 109	com/tencent/matrix/trace/core/a:feu	Z
    //   5: ifne +256 -> 261
    //   8: aload_0
    //   9: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   12: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   15: ldc 194
    //   17: aload_0
    //   18: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   21: invokestatic 199	com/tencent/matrix/e/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 201	android/util/Printer
    //   27: astore_2
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   33: if_acmpne +15 -> 48
    //   36: aload_0
    //   37: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: ifnull +96 -> 147
    //   54: aload_2
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   60: ifnull +87 -> 147
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   69: invokevirtual 209	java/lang/Class:getName	()Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   76: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   79: invokevirtual 209	java/lang/Class:getName	()Ljava/lang/String;
    //   82: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +62 -> 147
    //   88: ldc 217
    //   90: new 219	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 221
    //   96: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   103: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   106: invokevirtual 227	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   109: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: ldc 233
    //   114: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: invokevirtual 227	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   124: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 245	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -92 -> 45
    //   140: astore_1
    //   141: aload_2
    //   142: astore_1
    //   143: iconst_1
    //   144: putstatic 109	com/tencent/matrix/trace/core/a:feu	Z
    //   147: aload_0
    //   148: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   151: ifnull +38 -> 189
    //   154: ldc 217
    //   156: ldc 247
    //   158: iconst_3
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   168: invokevirtual 251	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   171: invokevirtual 254	java/lang/Thread:getName	()Ljava/lang/String;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_0
    //   178: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   181: aastore
    //   182: dup
    //   183: iconst_2
    //   184: aload_1
    //   185: aastore
    //   186: invokestatic 245	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   193: astore_2
    //   194: new 15	com/tencent/matrix/trace/core/a$b
    //   197: dup
    //   198: aload_0
    //   199: aload_1
    //   200: invokespecial 257	com/tencent/matrix/trace/core/a$b:<init>	(Lcom/tencent/matrix/trace/core/a;Landroid/util/Printer;)V
    //   203: astore_3
    //   204: aload_0
    //   205: aload_3
    //   206: putfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   209: aload_2
    //   210: aload_3
    //   211: invokevirtual 261	android/os/Looper:setMessageLogging	(Landroid/util/Printer;)V
    //   214: aload_1
    //   215: ifnull -170 -> 45
    //   218: ldc 217
    //   220: ldc_w 263
    //   223: iconst_2
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: aload_0
    //   234: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   237: invokevirtual 251	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   240: invokevirtual 254	java/lang/Thread:getName	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 266	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -202 -> 45
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -115 -> 143
    //   261: aconst_null
    //   262: astore_1
    //   263: goto -116 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	a
    //   40	25	1	localObject1	Object
    //   140	1	1	localException1	java.lang.Exception
    //   142	88	1	localObject2	Object
    //   250	4	1	localObject3	Object
    //   255	1	1	localException2	java.lang.Exception
    //   257	6	1	localObject4	Object
    //   27	183	2	localObject5	Object
    //   203	8	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   28	41	140	java/lang/Exception
    //   56	63	140	java/lang/Exception
    //   65	137	140	java/lang/Exception
    //   2	28	250	finally
    //   28	41	250	finally
    //   56	63	250	finally
    //   65	137	250	finally
    //   143	147	250	finally
    //   147	189	250	finally
    //   189	214	250	finally
    //   218	247	250	finally
    //   2	28	255	java/lang/Exception
  }
  
  public static Queue<c> azG()
  {
    b(new c(fep, System.currentTimeMillis() - fem));
    return fen;
  }
  
  public static Queue<c> azH()
  {
    return feo;
  }
  
  public static void azI()
  {
    feo.clear();
    feq = 0L;
    fer = 0L;
  }
  
  public static long azJ()
  {
    return feq;
  }
  
  public static long azK()
  {
    return fer;
  }
  
  static void b(a parama)
  {
    a locala = fej;
    synchronized (locala.listeners)
    {
      locala.listeners.remove(parama);
      return;
    }
  }
  
  private static void b(c paramc)
  {
    if (fen.size() == 200) {
      fen.poll();
    }
    fen.offer(paramc);
  }
  
  public static a c(Looper paramLooper)
  {
    a locala2 = (a)fei.get(paramLooper);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramLooper);
      fei.put(paramLooper, locala1);
    }
    return locala1;
  }
  
  /* Error */
  private void d(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 313	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmplt +14 -> 21
    //   10: aload_1
    //   11: invokevirtual 317	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   14: aload_0
    //   15: invokevirtual 323	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: ldc_w 325
    //   28: aload_1
    //   29: invokestatic 199	com/tencent/matrix/e/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 319	android/os/MessageQueue
    //   35: aload_0
    //   36: invokevirtual 323	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   39: goto -21 -> 18
    //   42: astore_1
    //   43: goto -25 -> 18
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	a
    //   0	51	1	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   21	39	42	java/lang/Exception
    //   2	18	46	finally
    //   21	39	46	finally
  }
  
  /* Error */
  private void e(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 313	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmplt +14 -> 21
    //   10: aload_1
    //   11: invokevirtual 317	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   14: aload_0
    //   15: invokevirtual 330	android/os/MessageQueue:addIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: ldc_w 325
    //   28: aload_1
    //   29: invokestatic 199	com/tencent/matrix/e/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: checkcast 319	android/os/MessageQueue
    //   35: aload_0
    //   36: invokevirtual 330	android/os/MessageQueue:addIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   39: goto -21 -> 18
    //   42: astore_1
    //   43: goto -25 -> 18
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	a
    //   0	51	1	paramLooper	Looper
    // Exception table:
    //   from	to	target	type
    //   21	39	42	java/lang/Exception
    //   2	18	46	finally
    //   21	39	46	finally
  }
  
  public final void c(a parama)
  {
    synchronized (this.listeners)
    {
      this.listeners.add(parama);
      return;
    }
  }
  
  /* Error */
  public final void onRelease()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   6: ifnull +86 -> 92
    //   9: aload_0
    //   10: getfield 116	com/tencent/matrix/trace/core/a:listeners	Ljava/util/HashSet;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 116	com/tencent/matrix/trace/core/a:listeners	Ljava/util/HashSet;
    //   20: invokevirtual 335	java/util/HashSet:clear	()V
    //   23: aload_1
    //   24: monitorexit
    //   25: ldc 217
    //   27: ldc_w 337
    //   30: iconst_2
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_0
    //   37: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   40: invokevirtual 251	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   43: invokevirtual 254	java/lang/Thread:getName	()Ljava/lang/String;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   53: getfield 341	com/tencent/matrix/trace/core/a$b:few	Landroid/util/Printer;
    //   56: aastore
    //   57: invokestatic 344	com/tencent/matrix/e/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   64: aload_0
    //   65: getfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   68: getfield 341	com/tencent/matrix/trace/core/a$b:few	Landroid/util/Printer;
    //   71: invokevirtual 261	android/os/Looper:setMessageLogging	(Landroid/util/Printer;)V
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   79: invokespecial 346	com/tencent/matrix/trace/core/a:d	(Landroid/os/Looper;)V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 126	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 203	com/tencent/matrix/trace/core/a:fes	Lcom/tencent/matrix/trace/core/a$b;
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: astore_2
    //   96: aload_1
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	a
    //   100	4	1	localObject1	Object
    //   95	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	25	95	finally
    //   2	16	100	finally
    //   25	92	100	finally
    //   96	100	100	finally
  }
  
  public final boolean queueIdle()
  {
    if (SystemClock.uptimeMillis() - this.fet >= 60000L)
    {
      azF();
      this.fet = SystemClock.uptimeMillis();
    }
    return true;
  }
  
  public static abstract class a
  {
    boolean eLL = false;
    boolean fdT = false;
    boolean fev = false;
    
    public a() {}
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.fdT = paramBoolean1;
      this.eLL = paramBoolean2;
    }
    
    public void dispatchEnd() {}
    
    public void dispatchStart() {}
    
    public void gt(String paramString)
    {
      this.fev = true;
      dispatchStart();
    }
    
    public void gu(String paramString)
    {
      this.fev = false;
      dispatchEnd();
    }
    
    public boolean isValid()
    {
      return false;
    }
  }
  
  final class b
    implements Printer
  {
    boolean clZ = false;
    public Printer few;
    boolean fex = false;
    
    b(Printer paramPrinter)
    {
      this.few = paramPrinter;
    }
    
    public final void println(String paramString)
    {
      boolean bool2 = true;
      if (this.few != null)
      {
        this.few.println(paramString);
        if (this.few == this) {
          throw new RuntimeException("Matrix.LooperMonitor origin == this");
        }
      }
      if (!this.fex)
      {
        if ((paramString.charAt(0) != '>') && (paramString.charAt(0) != '<')) {
          break label131;
        }
        bool1 = true;
        this.clZ = bool1;
        this.fex = true;
        if (!this.clZ) {
          c.e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", new Object[] { paramString });
        }
      }
      a locala;
      if (this.clZ)
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
  
  public static final class c
  {
    public long d;
    public String l;
    
    c(String paramString, long paramLong)
    {
      this.l = paramString;
      this.d = paramLong;
    }
    
    public final String toString()
    {
      return "{" + this.l + " -> " + this.d + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.core.a
 * JD-Core Version:    0.7.0.1
 */