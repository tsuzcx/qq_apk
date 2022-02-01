package com.tencent.e.e;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class e<P>
{
  static g Mrm;
  static g Mrn;
  static g Mro;
  private static final a Mrp;
  P Mrq;
  g Mrr;
  volatile a Mrs;
  a<Throwable, ?> Mrt;
  volatile e Mru;
  volatile e Mrv;
  private volatile boolean Mrw;
  private final Object lock;
  AtomicBoolean opk;
  
  static
  {
    AppMethodBeat.i(183301);
    Mrm = new c();
    Mrn = new b();
    Mro = new i();
    Mrp = new a();
    AppMethodBeat.o(183301);
  }
  
  e()
  {
    AppMethodBeat.i(183293);
    this.lock = new Object();
    this.Mrw = false;
    this.opk = new AtomicBoolean(false);
    AppMethodBeat.o(183293);
  }
  
  e(P paramP)
  {
    AppMethodBeat.i(183294);
    this.lock = new Object();
    this.Mrw = false;
    this.opk = new AtomicBoolean(false);
    this.Mrq = paramP;
    AppMethodBeat.o(183294);
  }
  
  public static <T> e<T> ez(T paramT)
  {
    AppMethodBeat.i(183290);
    paramT = new e(paramT);
    AppMethodBeat.o(183290);
    return paramT;
  }
  
  public static e<a> gab()
  {
    AppMethodBeat.i(183291);
    e locale = new e(Mrp);
    AppMethodBeat.o(183291);
    return locale;
  }
  
  public static f<a> gac()
  {
    AppMethodBeat.i(183292);
    f localf = new f(Mrp);
    AppMethodBeat.o(183292);
    return localf;
  }
  
  private void gae()
  {
    AppMethodBeat.i(183297);
    if (this.Mrw) {
      synchronized (this.lock)
      {
        if (this.Mrw) {
          this.lock.notifyAll();
        }
        AppMethodBeat.o(183297);
        return;
      }
    }
    AppMethodBeat.o(183297);
  }
  
  public <R> e<R> a(a<P, R> parama)
  {
    AppMethodBeat.i(183295);
    Objects.requireNonNull(parama);
    e locale = new e();
    locale.Mrr = gag();
    locale.Mru = null;
    this.Mrv = locale;
    this.Mrs = parama;
    this.opk.compareAndSet(false, true);
    b(parama);
    AppMethodBeat.o(183295);
    return locale;
  }
  
  final void b(final a parama)
  {
    AppMethodBeat.i(183296);
    if (parama == null)
    {
      gae();
      AppMethodBeat.o(183296);
      return;
    }
    parama = new h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(183288);
        String str = parama.toString();
        AppMethodBeat.o(183288);
        return str;
      }
      
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 44
        //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   9: getfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   12: aload_0
        //   13: getfield 21	com/tencent/e/e/e$1:Mrx	Lcom/tencent/e/e/a;
        //   16: aload_0
        //   17: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   20: getfield 51	com/tencent/e/e/e:Mrq	Ljava/lang/Object;
        //   23: invokeinterface 57 2 0
        //   28: putfield 51	com/tencent/e/e/e:Mrq	Ljava/lang/Object;
        //   31: aload_0
        //   32: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   35: getfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   38: aload_0
        //   39: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   42: getfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   45: getfield 60	com/tencent/e/e/e:Mrs	Lcom/tencent/e/e/a;
        //   48: invokevirtual 61	com/tencent/e/e/e:b	(Lcom/tencent/e/e/a;)V
        //   51: aload_0
        //   52: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   55: invokestatic 65	com/tencent/e/e/e:a	(Lcom/tencent/e/e/e;)V
        //   58: aload_0
        //   59: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   62: aconst_null
        //   63: putfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   66: aload_0
        //   67: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   70: aconst_null
        //   71: putfield 68	com/tencent/e/e/e:Mru	Lcom/tencent/e/e/e;
        //   74: aload_0
        //   75: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   78: aconst_null
        //   79: putfield 60	com/tencent/e/e/e:Mrs	Lcom/tencent/e/e/a;
        //   82: aload_0
        //   83: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   86: aconst_null
        //   87: putfield 71	com/tencent/e/e/e:Mrt	Lcom/tencent/e/e/a;
        //   90: ldc 44
        //   92: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   95: return
        //   96: astore_2
        //   97: aload_0
        //   98: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   101: invokevirtual 75	com/tencent/e/e/e:gad	()Lcom/tencent/e/e/a;
        //   104: astore_1
        //   105: aload_1
        //   106: ifnonnull +61 -> 167
        //   109: ldc 44
        //   111: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   114: aload_2
        //   115: athrow
        //   116: astore_1
        //   117: aload_2
        //   118: ifnonnull +127 -> 245
        //   121: aload_0
        //   122: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   125: invokestatic 65	com/tencent/e/e/e:a	(Lcom/tencent/e/e/e;)V
        //   128: aload_0
        //   129: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   132: aconst_null
        //   133: putfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   136: aload_0
        //   137: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   140: aconst_null
        //   141: putfield 68	com/tencent/e/e/e:Mru	Lcom/tencent/e/e/e;
        //   144: aload_0
        //   145: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   148: aconst_null
        //   149: putfield 60	com/tencent/e/e/e:Mrs	Lcom/tencent/e/e/a;
        //   152: aload_0
        //   153: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   156: aconst_null
        //   157: putfield 71	com/tencent/e/e/e:Mrt	Lcom/tencent/e/e/a;
        //   160: ldc 44
        //   162: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   165: aload_1
        //   166: athrow
        //   167: aload_1
        //   168: aload_2
        //   169: invokeinterface 57 2 0
        //   174: astore_3
        //   175: aload_0
        //   176: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   179: astore_1
        //   180: aload_1
        //   181: getfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   184: ifnull +11 -> 195
        //   187: aload_1
        //   188: getfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   191: astore_1
        //   192: goto -12 -> 180
        //   195: aload_1
        //   196: aload_3
        //   197: putfield 51	com/tencent/e/e/e:Mrq	Ljava/lang/Object;
        //   200: aload_0
        //   201: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   204: invokestatic 77	com/tencent/e/e/e:b	(Lcom/tencent/e/e/e;)V
        //   207: aload_0
        //   208: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   211: aconst_null
        //   212: putfield 47	com/tencent/e/e/e:Mrv	Lcom/tencent/e/e/e;
        //   215: aload_0
        //   216: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   219: aconst_null
        //   220: putfield 68	com/tencent/e/e/e:Mru	Lcom/tencent/e/e/e;
        //   223: aload_0
        //   224: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   227: aconst_null
        //   228: putfield 60	com/tencent/e/e/e:Mrs	Lcom/tencent/e/e/a;
        //   231: aload_0
        //   232: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   235: aconst_null
        //   236: putfield 71	com/tencent/e/e/e:Mrt	Lcom/tencent/e/e/a;
        //   239: ldc 44
        //   241: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   244: return
        //   245: aload_0
        //   246: getfield 19	com/tencent/e/e/e$1:Mry	Lcom/tencent/e/e/e;
        //   249: invokestatic 77	com/tencent/e/e/e:b	(Lcom/tencent/e/e/e;)V
        //   252: goto -124 -> 128
        //   255: astore_1
        //   256: aconst_null
        //   257: astore_2
        //   258: goto -141 -> 117
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	261	0	this	1
        //   104	2	1	locala	a
        //   116	52	1	localObject1	Object
        //   179	17	1	locale	e
        //   255	1	1	localObject2	Object
        //   96	73	2	localThrowable	Throwable
        //   257	1	2	localObject3	Object
        //   174	23	3	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   5	51	96	java/lang/Throwable
        //   97	105	116	finally
        //   109	116	116	finally
        //   167	180	116	finally
        //   180	192	116	finally
        //   195	200	116	finally
        //   5	51	255	finally
      }
    };
    if (this.Mrq != null)
    {
      if (this.Mrr == null)
      {
        parama.run();
        AppMethodBeat.o(183296);
        return;
      }
      this.Mrr.execute(parama);
    }
    AppMethodBeat.o(183296);
  }
  
  a<Throwable, ?> gad()
  {
    return null;
  }
  
  public e<P> gaf()
  {
    this.Mrr = Mro;
    return this;
  }
  
  public g gag()
  {
    return this.Mrr;
  }
  
  public P take()
  {
    AppMethodBeat.i(183298);
    for (;;)
    {
      try
      {
        if (this.Mrq != null) {}
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      synchronized (this.lock)
      {
        if (this.Mrq == null)
        {
          this.Mrw = true;
          this.lock.wait();
          this.Mrw = false;
        }
        ??? = this.Mrq;
        AppMethodBeat.o(183298);
        return ???;
      }
    }
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.e
 * JD-Core Version:    0.7.0.1
 */