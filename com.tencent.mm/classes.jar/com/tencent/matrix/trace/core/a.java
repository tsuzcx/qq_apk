package com.tencent.matrix.trace.core;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.e.c;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements MessageQueue.IdleHandler
{
  private static final Map<Looper, a> dfc = new ConcurrentHashMap();
  private static final a dfd = b(Looper.getMainLooper());
  private static boolean dfg = false;
  private b dfe;
  private long dff = 0L;
  private final HashSet<a> listeners = new HashSet();
  private Looper looper;
  
  private a(Looper paramLooper)
  {
    Objects.requireNonNull(paramLooper);
    this.looper = paramLooper;
    XZ();
    d(paramLooper);
  }
  
  /* Error */
  private void XZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 50	com/tencent/matrix/trace/core/a:dfg	Z
    //   5: ifne +255 -> 260
    //   8: aload_0
    //   9: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   12: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   15: ldc 82
    //   17: aload_0
    //   18: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   21: invokestatic 87	com/tencent/matrix/e/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 89	android/util/Printer
    //   27: astore_2
    //   28: aload_2
    //   29: aload_0
    //   30: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   33: if_acmpne +15 -> 48
    //   36: aload_0
    //   37: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
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
    //   57: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   60: ifnull +87 -> 147
    //   63: aload_2
    //   64: astore_1
    //   65: aload_2
    //   66: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   69: invokevirtual 97	java/lang/Class:getName	()Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   76: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   79: invokevirtual 97	java/lang/Class:getName	()Ljava/lang/String;
    //   82: invokevirtual 103	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +62 -> 147
    //   88: ldc 105
    //   90: new 107	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 109
    //   96: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   103: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   106: invokevirtual 116	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   109: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: ldc 122
    //   114: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   121: invokevirtual 116	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   124: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 134	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -92 -> 45
    //   140: astore_1
    //   141: aload_2
    //   142: astore_1
    //   143: iconst_1
    //   144: putstatic 50	com/tencent/matrix/trace/core/a:dfg	Z
    //   147: aload_0
    //   148: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   151: ifnull +38 -> 189
    //   154: ldc 105
    //   156: ldc 136
    //   158: iconst_3
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload_0
    //   165: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   168: invokevirtual 140	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   171: invokevirtual 143	java/lang/Thread:getName	()Ljava/lang/String;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_0
    //   178: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   181: aastore
    //   182: dup
    //   183: iconst_2
    //   184: aload_1
    //   185: aastore
    //   186: invokestatic 134	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   193: astore_2
    //   194: new 11	com/tencent/matrix/trace/core/a$b
    //   197: dup
    //   198: aload_0
    //   199: aload_1
    //   200: invokespecial 146	com/tencent/matrix/trace/core/a$b:<init>	(Lcom/tencent/matrix/trace/core/a;Landroid/util/Printer;)V
    //   203: astore_3
    //   204: aload_0
    //   205: aload_3
    //   206: putfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   209: aload_2
    //   210: aload_3
    //   211: invokevirtual 150	android/os/Looper:setMessageLogging	(Landroid/util/Printer;)V
    //   214: aload_1
    //   215: ifnull -170 -> 45
    //   218: ldc 105
    //   220: ldc 152
    //   222: iconst_2
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload_1
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_0
    //   233: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   236: invokevirtual 140	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   239: invokevirtual 143	java/lang/Thread:getName	()Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 155	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: goto -201 -> 45
    //   249: astore_1
    //   250: aload_0
    //   251: monitorexit
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -114 -> 143
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -115 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	a
    //   40	25	1	localObject1	Object
    //   140	1	1	localException1	java.lang.Exception
    //   142	87	1	localObject2	Object
    //   249	4	1	localObject3	Object
    //   254	1	1	localException2	java.lang.Exception
    //   256	6	1	localObject4	Object
    //   27	183	2	localObject5	Object
    //   203	8	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   28	41	140	java/lang/Exception
    //   56	63	140	java/lang/Exception
    //   65	137	140	java/lang/Exception
    //   2	28	249	finally
    //   28	41	249	finally
    //   56	63	249	finally
    //   65	137	249	finally
    //   143	147	249	finally
    //   147	189	249	finally
    //   189	214	249	finally
    //   218	246	249	finally
    //   2	28	254	java/lang/Exception
  }
  
  public static void a(a parama)
  {
    dfd.c(parama);
  }
  
  public static a b(Looper paramLooper)
  {
    a locala2 = (a)dfc.get(paramLooper);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramLooper);
      dfc.put(paramLooper, locala1);
    }
    return locala1;
  }
  
  static void b(a parama)
  {
    a locala = dfd;
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
    //   2: getstatic 209	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmplt +14 -> 21
    //   10: aload_1
    //   11: invokevirtual 213	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   14: aload_0
    //   15: invokevirtual 219	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: ldc 221
    //   27: aload_1
    //   28: invokestatic 87	com/tencent/matrix/e/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 215	android/os/MessageQueue
    //   34: aload_0
    //   35: invokevirtual 219	android/os/MessageQueue:removeIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
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
  private void d(Looper paramLooper)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 209	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 23
    //   7: if_icmplt +14 -> 21
    //   10: aload_1
    //   11: invokevirtual 213	android/os/Looper:getQueue	()Landroid/os/MessageQueue;
    //   14: aload_0
    //   15: invokevirtual 224	android/os/MessageQueue:addIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 80	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: ldc 221
    //   27: aload_1
    //   28: invokestatic 87	com/tencent/matrix/e/f:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 215	android/os/MessageQueue
    //   34: aload_0
    //   35: invokevirtual 224	android/os/MessageQueue:addIdleHandler	(Landroid/os/MessageQueue$IdleHandler;)V
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
    //   3: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   6: ifnull +85 -> 91
    //   9: aload_0
    //   10: getfield 58	com/tencent/matrix/trace/core/a:listeners	Ljava/util/HashSet;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 58	com/tencent/matrix/trace/core/a:listeners	Ljava/util/HashSet;
    //   20: invokevirtual 231	java/util/HashSet:clear	()V
    //   23: aload_1
    //   24: monitorexit
    //   25: ldc 105
    //   27: ldc 233
    //   29: iconst_2
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   39: invokevirtual 140	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   42: invokevirtual 143	java/lang/Thread:getName	()Ljava/lang/String;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_0
    //   49: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   52: getfield 237	com/tencent/matrix/trace/core/a$b:dfi	Landroid/util/Printer;
    //   55: aastore
    //   56: invokestatic 240	com/tencent/matrix/e/c:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   63: aload_0
    //   64: getfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
    //   67: getfield 237	com/tencent/matrix/trace/core/a$b:dfi	Landroid/util/Printer;
    //   70: invokevirtual 150	android/os/Looper:setMessageLogging	(Landroid/util/Printer;)V
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   78: invokespecial 242	com/tencent/matrix/trace/core/a:c	(Landroid/os/Looper;)V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 68	com/tencent/matrix/trace/core/a:looper	Landroid/os/Looper;
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 91	com/tencent/matrix/trace/core/a:dfe	Lcom/tencent/matrix/trace/core/a$b;
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
    //   2	16	99	finally
    //   25	91	99	finally
    //   95	99	99	finally
  }
  
  public final boolean queueIdle()
  {
    if (SystemClock.uptimeMillis() - this.dff >= 60000L)
    {
      XZ();
      this.dff = SystemClock.uptimeMillis();
    }
    return true;
  }
  
  public static abstract class a
  {
    boolean dfh = false;
    
    public void dispatchEnd() {}
    
    public void dispatchStart() {}
    
    public void eV(String paramString)
    {
      this.dfh = true;
      dispatchStart();
    }
    
    public void eW(String paramString)
    {
      this.dfh = false;
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
    boolean cSY = false;
    public Printer dfi;
    boolean dfj = false;
    
    b(Printer paramPrinter)
    {
      this.dfi = paramPrinter;
    }
    
    public final void println(String paramString)
    {
      boolean bool2 = true;
      if (this.dfi != null)
      {
        this.dfi.println(paramString);
        if (this.dfi == this) {
          throw new RuntimeException("Matrix.LooperMonitor origin == this");
        }
      }
      if (!this.dfj)
      {
        if ((paramString.charAt(0) != '>') && (paramString.charAt(0) != '<')) {
          break label131;
        }
        bool1 = true;
        this.cSY = bool1;
        this.dfj = true;
        if (!this.cSY) {
          c.e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", new Object[] { paramString });
        }
      }
      a locala;
      if (this.cSY)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.core.a
 * JD-Core Version:    0.7.0.1
 */