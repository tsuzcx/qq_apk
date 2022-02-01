package com.bumptech.glide.load.b;

import com.bumptech.glide.g.a.a.c;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.a.b.a;
import com.bumptech.glide.g.e;
import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class l<R>
  implements a.c, h.a<R>
{
  private static final c aHx;
  private final com.bumptech.glide.load.b.c.a aCB;
  private final com.bumptech.glide.load.b.c.a aCu;
  private final com.bumptech.glide.load.b.c.a aCv;
  private com.bumptech.glide.load.g aFH;
  private boolean aFI;
  private v<?> aFJ;
  com.bumptech.glide.load.a aGD;
  private final b aGi;
  private final android.support.v4.e.l.a<l<?>> aGj;
  boolean aGr;
  private final AtomicInteger aHA;
  private boolean aHB;
  private boolean aHC;
  private boolean aHD;
  q aHE;
  private boolean aHF;
  p<?> aHG;
  private h<R> aHH;
  private final com.bumptech.glide.load.b.c.a aHp;
  private final m aHq;
  final e aHy;
  private final c aHz;
  private volatile boolean isCancelled;
  
  static
  {
    AppMethodBeat.i(77000);
    aHx = new c();
    AppMethodBeat.o(77000);
  }
  
  l(com.bumptech.glide.load.b.c.a parama1, com.bumptech.glide.load.b.c.a parama2, com.bumptech.glide.load.b.c.a parama3, com.bumptech.glide.load.b.c.a parama4, m paramm, android.support.v4.e.l.a<l<?>> parama)
  {
    this(parama1, parama2, parama3, parama4, paramm, parama, aHx);
  }
  
  private l(com.bumptech.glide.load.b.c.a parama1, com.bumptech.glide.load.b.c.a parama2, com.bumptech.glide.load.b.c.a parama3, com.bumptech.glide.load.b.c.a parama4, m paramm, android.support.v4.e.l.a<l<?>> parama, c paramc)
  {
    AppMethodBeat.i(76992);
    this.aHy = new e();
    this.aGi = new b.a();
    this.aHA = new AtomicInteger();
    this.aCv = parama1;
    this.aCu = parama2;
    this.aHp = parama3;
    this.aCB = parama4;
    this.aHq = paramm;
    this.aGj = parama;
    this.aHz = paramc;
    AppMethodBeat.o(76992);
  }
  
  private void dh(int paramInt)
  {
    try
    {
      AppMethodBeat.i(204476);
      j.checkArgument(isDone(), "Not yet complete!");
      if ((this.aHA.getAndAdd(paramInt) == 0) && (this.aHG != null)) {
        this.aHG.acquire();
      }
      AppMethodBeat.o(204476);
      return;
    }
    finally {}
  }
  
  private boolean isDone()
  {
    return (this.aHF) || (this.aHD) || (this.isCancelled);
  }
  
  private com.bumptech.glide.load.b.c.a oS()
  {
    if (this.aHB) {
      return this.aHp;
    }
    if (this.aHC) {
      return this.aCB;
    }
    return this.aCu;
  }
  
  private void release()
  {
    try
    {
      AppMethodBeat.i(204478);
      if (this.aFH == null)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.o(204478);
        throw localIllegalArgumentException;
      }
    }
    finally {}
    this.aHy.aHJ.clear();
    this.aFH = null;
    this.aHG = null;
    this.aFJ = null;
    this.aHF = false;
    this.isCancelled = false;
    this.aHD = false;
    h localh = this.aHH;
    if (localh.aGl.oM()) {
      localh.oE();
    }
    this.aHH = null;
    this.aHE = null;
    this.aGD = null;
    this.aGj.release(this);
    AppMethodBeat.o(204478);
  }
  
  final l<R> a(com.bumptech.glide.load.g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      this.aFH = paramg;
      this.aFI = paramBoolean1;
      this.aHB = paramBoolean2;
      this.aHC = paramBoolean3;
      this.aGr = paramBoolean4;
      return this;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  /* Error */
  final void a(com.bumptech.glide.e.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 210
    //   4: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: aload_0
    //   9: getfield 140	com/bumptech/glide/load/b/l:aHG	Lcom/bumptech/glide/load/b/p;
    //   12: aload_0
    //   13: getfield 195	com/bumptech/glide/load/b/l:aGD	Lcom/bumptech/glide/load/a;
    //   16: invokeinterface 215 3 0
    //   21: ldc 210
    //   23: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: new 217	com/bumptech/glide/load/b/b
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 220	com/bumptech/glide/load/b/b:<init>	(Ljava/lang/Throwable;)V
    //   38: astore_1
    //   39: ldc 210
    //   41: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	l
    //   0	51	1	paramg	com.bumptech.glide.e.g
    // Exception table:
    //   from	to	target	type
    //   7	21	29	java/lang/Throwable
    //   2	7	46	finally
    //   7	21	46	finally
    //   21	26	46	finally
    //   30	46	46	finally
  }
  
  final void a(com.bumptech.glide.e.g paramg, Executor paramExecutor)
  {
    boolean bool = true;
    try
    {
      AppMethodBeat.i(204472);
      this.aGi.qz();
      this.aHy.aHJ.add(new d(paramg, paramExecutor));
      if (this.aHD)
      {
        dh(1);
        paramExecutor.execute(new b(paramg));
        AppMethodBeat.o(204472);
      }
      for (;;)
      {
        return;
        if (!this.aHF) {
          break;
        }
        dh(1);
        paramExecutor.execute(new a(paramg));
        AppMethodBeat.o(204472);
      }
      if (this.isCancelled) {}
    }
    finally {}
    for (;;)
    {
      j.checkArgument(bool, "Cannot add callbacks to a cancelled EngineJob");
      AppMethodBeat.o(204472);
      break;
      bool = false;
    }
  }
  
  public final void a(h<?> paramh)
  {
    AppMethodBeat.i(76998);
    oS().execute(paramh);
    AppMethodBeat.o(76998);
  }
  
  /* Error */
  public final void a(q paramq)
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 193	com/bumptech/glide/load/b/l:aHE	Lcom/bumptech/glide/load/b/q;
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 100	com/bumptech/glide/load/b/l:aGi	Lcom/bumptech/glide/g/a/b;
    //   21: invokevirtual 227	com/bumptech/glide/g/a/b:qz	()V
    //   24: aload_0
    //   25: getfield 151	com/bumptech/glide/load/b/l:isCancelled	Z
    //   28: ifeq +27 -> 55
    //   31: aload_0
    //   32: invokespecial 258	com/bumptech/glide/load/b/l:release	()V
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc_w 256
    //   40: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: ldc_w 256
    //   50: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_1
    //   54: athrow
    //   55: aload_0
    //   56: getfield 95	com/bumptech/glide/load/b/l:aHy	Lcom/bumptech/glide/load/b/l$e;
    //   59: invokevirtual 261	com/bumptech/glide/load/b/l$e:isEmpty	()Z
    //   62: ifeq +33 -> 95
    //   65: new 263	java/lang/IllegalStateException
    //   68: dup
    //   69: ldc_w 265
    //   72: invokespecial 268	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: ldc_w 256
    //   79: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: ldc_w 256
    //   90: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    //   95: aload_0
    //   96: getfield 147	com/bumptech/glide/load/b/l:aHF	Z
    //   99: ifeq +22 -> 121
    //   102: new 263	java/lang/IllegalStateException
    //   105: dup
    //   106: ldc_w 270
    //   109: invokespecial 268	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   112: astore_1
    //   113: ldc_w 256
    //   116: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_1
    //   120: athrow
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield 147	com/bumptech/glide/load/b/l:aHF	Z
    //   126: aload_0
    //   127: getfield 161	com/bumptech/glide/load/b/l:aFH	Lcom/bumptech/glide/load/g;
    //   130: astore_1
    //   131: aload_0
    //   132: getfield 95	com/bumptech/glide/load/b/l:aHy	Lcom/bumptech/glide/load/b/l$e;
    //   135: invokevirtual 274	com/bumptech/glide/load/b/l$e:oU	()Lcom/bumptech/glide/load/b/l$e;
    //   138: astore_2
    //   139: aload_0
    //   140: aload_2
    //   141: invokevirtual 278	com/bumptech/glide/load/b/l$e:size	()I
    //   144: iconst_1
    //   145: iadd
    //   146: invokespecial 234	com/bumptech/glide/load/b/l:dh	(I)V
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_0
    //   152: getfield 115	com/bumptech/glide/load/b/l:aHq	Lcom/bumptech/glide/load/b/m;
    //   155: aload_0
    //   156: aload_1
    //   157: aconst_null
    //   158: invokeinterface 283 4 0
    //   163: aload_2
    //   164: invokevirtual 287	com/bumptech/glide/load/b/l$e:iterator	()Ljava/util/Iterator;
    //   167: astore_1
    //   168: aload_1
    //   169: invokeinterface 292 1 0
    //   174: ifeq +37 -> 211
    //   177: aload_1
    //   178: invokeinterface 296 1 0
    //   183: checkcast 20	com/bumptech/glide/load/b/l$d
    //   186: astore_2
    //   187: aload_2
    //   188: getfield 300	com/bumptech/glide/load/b/l$d:executor	Ljava/util/concurrent/Executor;
    //   191: new 11	com/bumptech/glide/load/b/l$a
    //   194: dup
    //   195: aload_0
    //   196: aload_2
    //   197: getfield 304	com/bumptech/glide/load/b/l$d:aHv	Lcom/bumptech/glide/e/g;
    //   200: invokespecial 244	com/bumptech/glide/load/b/l$a:<init>	(Lcom/bumptech/glide/load/b/l;Lcom/bumptech/glide/e/g;)V
    //   203: invokeinterface 243 2 0
    //   208: goto -40 -> 168
    //   211: aload_0
    //   212: invokevirtual 307	com/bumptech/glide/load/b/l:oT	()V
    //   215: ldc_w 256
    //   218: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	l
    //   0	222	1	paramq	q
    //   138	59	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	44	finally
    //   45	47	44	finally
    //   17	37	84	finally
    //   55	84	84	finally
    //   85	87	84	finally
    //   95	121	84	finally
    //   121	151	84	finally
  }
  
  /* Error */
  final void b(com.bumptech.glide.e.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 308
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 193	com/bumptech/glide/load/b/l:aHE	Lcom/bumptech/glide/load/b/q;
    //   13: invokeinterface 310 2 0
    //   18: ldc_w 308
    //   21: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: new 217	com/bumptech/glide/load/b/b
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 220	com/bumptech/glide/load/b/b:<init>	(Ljava/lang/Throwable;)V
    //   36: astore_1
    //   37: ldc_w 308
    //   40: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	l
    //   0	50	1	paramg	com.bumptech.glide.e.g
    // Exception table:
    //   from	to	target	type
    //   8	18	27	java/lang/Throwable
    //   2	8	45	finally
    //   8	18	45	finally
    //   18	24	45	finally
    //   28	45	45	finally
  }
  
  public final void b(h<R> paramh)
  {
    label79:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(204471);
        this.aHH = paramh;
        Object localObject = paramh.a(h.g.aGN);
        if (localObject != h.g.aGO)
        {
          if (localObject == h.g.aGP)
          {
            break label79;
            if (i != 0)
            {
              localObject = this.aCv;
              ((com.bumptech.glide.load.b.c.a)localObject).execute(paramh);
              AppMethodBeat.o(204471);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          localObject = oS();
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public final void c(com.bumptech.glide.e.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 328
    //   7: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 100	com/bumptech/glide/load/b/l:aGi	Lcom/bumptech/glide/g/a/b;
    //   14: invokevirtual 227	com/bumptech/glide/g/a/b:qz	()V
    //   17: aload_0
    //   18: getfield 95	com/bumptech/glide/load/b/l:aHy	Lcom/bumptech/glide/load/b/l$e;
    //   21: getfield 168	com/bumptech/glide/load/b/l$e:aHJ	Ljava/util/List;
    //   24: aload_1
    //   25: invokestatic 331	com/bumptech/glide/load/b/l$e:e	(Lcom/bumptech/glide/e/g;)Lcom/bumptech/glide/load/b/l$d;
    //   28: invokeinterface 334 2 0
    //   33: pop
    //   34: aload_0
    //   35: getfield 95	com/bumptech/glide/load/b/l:aHy	Lcom/bumptech/glide/load/b/l$e;
    //   38: invokevirtual 261	com/bumptech/glide/load/b/l$e:isEmpty	()Z
    //   41: ifeq +90 -> 131
    //   44: aload_0
    //   45: invokespecial 126	com/bumptech/glide/load/b/l:isDone	()Z
    //   48: ifne +47 -> 95
    //   51: aload_0
    //   52: iconst_1
    //   53: putfield 151	com/bumptech/glide/load/b/l:isCancelled	Z
    //   56: aload_0
    //   57: getfield 177	com/bumptech/glide/load/b/l:aHH	Lcom/bumptech/glide/load/b/h;
    //   60: astore_1
    //   61: aload_1
    //   62: iconst_1
    //   63: putfield 335	com/bumptech/glide/load/b/h:isCancelled	Z
    //   66: aload_1
    //   67: getfield 339	com/bumptech/glide/load/b/h:aGy	Lcom/bumptech/glide/load/b/f;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +9 -> 81
    //   75: aload_1
    //   76: invokeinterface 344 1 0
    //   81: aload_0
    //   82: getfield 115	com/bumptech/glide/load/b/l:aHq	Lcom/bumptech/glide/load/b/m;
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 161	com/bumptech/glide/load/b/l:aFH	Lcom/bumptech/glide/load/g;
    //   90: invokeinterface 347 3 0
    //   95: iload_3
    //   96: istore_2
    //   97: aload_0
    //   98: getfield 149	com/bumptech/glide/load/b/l:aHD	Z
    //   101: ifne +12 -> 113
    //   104: aload_0
    //   105: getfield 147	com/bumptech/glide/load/b/l:aHF	Z
    //   108: ifeq +32 -> 140
    //   111: iload_3
    //   112: istore_2
    //   113: iload_2
    //   114: ifeq +17 -> 131
    //   117: aload_0
    //   118: getfield 105	com/bumptech/glide/load/b/l:aHA	Ljava/util/concurrent/atomic/AtomicInteger;
    //   121: invokevirtual 350	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   124: ifne +7 -> 131
    //   127: aload_0
    //   128: invokespecial 258	com/bumptech/glide/load/b/l:release	()V
    //   131: ldc_w 328
    //   134: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: iconst_0
    //   141: istore_2
    //   142: goto -29 -> 113
    //   145: astore_1
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	l
    //   0	150	1	paramg	com.bumptech.glide.e.g
    //   96	46	2	i	int
    //   1	111	3	j	int
    // Exception table:
    //   from	to	target	type
    //   4	71	145	finally
    //   75	81	145	finally
    //   81	95	145	finally
    //   97	111	145	finally
    //   117	131	145	finally
    //   131	137	145	finally
  }
  
  /* Error */
  public final void c(v<R> paramv, com.bumptech.glide.load.a parama)
  {
    // Byte code:
    //   0: ldc_w 351
    //   3: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: aload_1
    //   10: putfield 175	com/bumptech/glide/load/b/l:aFJ	Lcom/bumptech/glide/load/b/v;
    //   13: aload_0
    //   14: aload_2
    //   15: putfield 195	com/bumptech/glide/load/b/l:aGD	Lcom/bumptech/glide/load/a;
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 100	com/bumptech/glide/load/b/l:aGi	Lcom/bumptech/glide/g/a/b;
    //   26: invokevirtual 227	com/bumptech/glide/g/a/b:qz	()V
    //   29: aload_0
    //   30: getfield 151	com/bumptech/glide/load/b/l:isCancelled	Z
    //   33: ifeq +36 -> 69
    //   36: aload_0
    //   37: getfield 175	com/bumptech/glide/load/b/l:aFJ	Lcom/bumptech/glide/load/b/v;
    //   40: invokeinterface 356 1 0
    //   45: aload_0
    //   46: invokespecial 258	com/bumptech/glide/load/b/l:release	()V
    //   49: aload_0
    //   50: monitorexit
    //   51: ldc_w 351
    //   54: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: ldc_w 351
    //   64: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_1
    //   68: athrow
    //   69: aload_0
    //   70: getfield 95	com/bumptech/glide/load/b/l:aHy	Lcom/bumptech/glide/load/b/l$e;
    //   73: invokevirtual 261	com/bumptech/glide/load/b/l$e:isEmpty	()Z
    //   76: ifeq +33 -> 109
    //   79: new 263	java/lang/IllegalStateException
    //   82: dup
    //   83: ldc_w 358
    //   86: invokespecial 268	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   89: astore_1
    //   90: ldc_w 351
    //   93: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: athrow
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 351
    //   104: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    //   109: aload_0
    //   110: getfield 149	com/bumptech/glide/load/b/l:aHD	Z
    //   113: ifeq +22 -> 135
    //   116: new 263	java/lang/IllegalStateException
    //   119: dup
    //   120: ldc_w 360
    //   123: invokespecial 268	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   126: astore_1
    //   127: ldc_w 351
    //   130: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    //   135: aload_0
    //   136: new 142	com/bumptech/glide/load/b/p
    //   139: dup
    //   140: aload_0
    //   141: getfield 175	com/bumptech/glide/load/b/l:aFJ	Lcom/bumptech/glide/load/b/v;
    //   144: aload_0
    //   145: getfield 203	com/bumptech/glide/load/b/l:aFI	Z
    //   148: iconst_1
    //   149: invokespecial 363	com/bumptech/glide/load/b/p:<init>	(Lcom/bumptech/glide/load/b/v;ZZ)V
    //   152: putfield 140	com/bumptech/glide/load/b/l:aHG	Lcom/bumptech/glide/load/b/p;
    //   155: aload_0
    //   156: iconst_1
    //   157: putfield 149	com/bumptech/glide/load/b/l:aHD	Z
    //   160: aload_0
    //   161: getfield 95	com/bumptech/glide/load/b/l:aHy	Lcom/bumptech/glide/load/b/l$e;
    //   164: invokevirtual 274	com/bumptech/glide/load/b/l$e:oU	()Lcom/bumptech/glide/load/b/l$e;
    //   167: astore_1
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 278	com/bumptech/glide/load/b/l$e:size	()I
    //   173: iconst_1
    //   174: iadd
    //   175: invokespecial 234	com/bumptech/glide/load/b/l:dh	(I)V
    //   178: aload_0
    //   179: getfield 161	com/bumptech/glide/load/b/l:aFH	Lcom/bumptech/glide/load/g;
    //   182: astore_2
    //   183: aload_0
    //   184: getfield 140	com/bumptech/glide/load/b/l:aHG	Lcom/bumptech/glide/load/b/p;
    //   187: astore_3
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_0
    //   191: getfield 115	com/bumptech/glide/load/b/l:aHq	Lcom/bumptech/glide/load/b/m;
    //   194: aload_0
    //   195: aload_2
    //   196: aload_3
    //   197: invokeinterface 283 4 0
    //   202: aload_1
    //   203: invokevirtual 287	com/bumptech/glide/load/b/l$e:iterator	()Ljava/util/Iterator;
    //   206: astore_1
    //   207: aload_1
    //   208: invokeinterface 292 1 0
    //   213: ifeq +37 -> 250
    //   216: aload_1
    //   217: invokeinterface 296 1 0
    //   222: checkcast 20	com/bumptech/glide/load/b/l$d
    //   225: astore_2
    //   226: aload_2
    //   227: getfield 300	com/bumptech/glide/load/b/l$d:executor	Ljava/util/concurrent/Executor;
    //   230: new 14	com/bumptech/glide/load/b/l$b
    //   233: dup
    //   234: aload_0
    //   235: aload_2
    //   236: getfield 304	com/bumptech/glide/load/b/l$d:aHv	Lcom/bumptech/glide/e/g;
    //   239: invokespecial 237	com/bumptech/glide/load/b/l$b:<init>	(Lcom/bumptech/glide/load/b/l;Lcom/bumptech/glide/e/g;)V
    //   242: invokeinterface 243 2 0
    //   247: goto -40 -> 207
    //   250: aload_0
    //   251: invokevirtual 307	com/bumptech/glide/load/b/l:oT	()V
    //   254: ldc_w 351
    //   257: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	l
    //   0	261	1	paramv	v<R>
    //   0	261	2	parama	com.bumptech.glide.load.a
    //   187	10	3	localp	p
    // Exception table:
    //   from	to	target	type
    //   8	20	58	finally
    //   59	61	58	finally
    //   22	51	98	finally
    //   69	98	98	finally
    //   99	101	98	finally
    //   109	135	98	finally
    //   135	190	98	finally
  }
  
  public final b oK()
  {
    return this.aGi;
  }
  
  /* Error */
  final void oT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 367
    //   5: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 100	com/bumptech/glide/load/b/l:aGi	Lcom/bumptech/glide/g/a/b;
    //   12: invokevirtual 227	com/bumptech/glide/g/a/b:qz	()V
    //   15: aload_0
    //   16: invokespecial 126	com/bumptech/glide/load/b/l:isDone	()Z
    //   19: ldc 128
    //   21: invokestatic 134	com/bumptech/glide/g/j:checkArgument	(ZLjava/lang/String;)V
    //   24: aload_0
    //   25: getfield 105	com/bumptech/glide/load/b/l:aHA	Ljava/util/concurrent/atomic/AtomicInteger;
    //   28: invokevirtual 370	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   31: istore_1
    //   32: iload_1
    //   33: iflt +43 -> 76
    //   36: iconst_1
    //   37: istore_2
    //   38: iload_2
    //   39: ldc_w 372
    //   42: invokestatic 134	com/bumptech/glide/g/j:checkArgument	(ZLjava/lang/String;)V
    //   45: iload_1
    //   46: ifne +21 -> 67
    //   49: aload_0
    //   50: getfield 140	com/bumptech/glide/load/b/l:aHG	Lcom/bumptech/glide/load/b/p;
    //   53: ifnull +10 -> 63
    //   56: aload_0
    //   57: getfield 140	com/bumptech/glide/load/b/l:aHG	Lcom/bumptech/glide/load/b/p;
    //   60: invokevirtual 373	com/bumptech/glide/load/b/p:release	()V
    //   63: aload_0
    //   64: invokespecial 258	com/bumptech/glide/load/b/l:release	()V
    //   67: ldc_w 367
    //   70: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -40 -> 38
    //   81: astore_3
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_3
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	l
    //   31	15	1	i	int
    //   37	41	2	bool	boolean
    //   81	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	81	finally
    //   38	45	81	finally
    //   49	63	81	finally
    //   63	67	81	finally
    //   67	73	81	finally
  }
  
  final class a
    implements Runnable
  {
    private final com.bumptech.glide.e.g aHv;
    
    a(com.bumptech.glide.e.g paramg)
    {
      this.aHv = paramg;
    }
    
    public final void run()
    {
      AppMethodBeat.i(204460);
      synchronized (l.this)
      {
        if (l.this.aHy.d(this.aHv)) {
          l.this.b(this.aHv);
        }
        l.this.oT();
        AppMethodBeat.o(204460);
        return;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private final com.bumptech.glide.e.g aHv;
    
    b(com.bumptech.glide.e.g paramg)
    {
      this.aHv = paramg;
    }
    
    public final void run()
    {
      AppMethodBeat.i(204461);
      synchronized (l.this)
      {
        if (l.this.aHy.d(this.aHv))
        {
          l.this.aHG.acquire();
          l.this.a(this.aHv);
          l.this.c(this.aHv);
        }
        l.this.oT();
        AppMethodBeat.o(204461);
        return;
      }
    }
  }
  
  static final class c {}
  
  static final class d
  {
    final com.bumptech.glide.e.g aHv;
    final Executor executor;
    
    d(com.bumptech.glide.e.g paramg, Executor paramExecutor)
    {
      this.aHv = paramg;
      this.executor = paramExecutor;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(204462);
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        boolean bool = this.aHv.equals(paramObject.aHv);
        AppMethodBeat.o(204462);
        return bool;
      }
      AppMethodBeat.o(204462);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(204463);
      int i = this.aHv.hashCode();
      AppMethodBeat.o(204463);
      return i;
    }
  }
  
  static final class e
    implements Iterable<l.d>
  {
    final List<l.d> aHJ;
    
    e()
    {
      this(new ArrayList(2));
      AppMethodBeat.i(204464);
      AppMethodBeat.o(204464);
    }
    
    private e(List<l.d> paramList)
    {
      this.aHJ = paramList;
    }
    
    static l.d e(com.bumptech.glide.e.g paramg)
    {
      AppMethodBeat.i(204469);
      paramg = new l.d(paramg, e.qs());
      AppMethodBeat.o(204469);
      return paramg;
    }
    
    final boolean d(com.bumptech.glide.e.g paramg)
    {
      AppMethodBeat.i(204465);
      boolean bool = this.aHJ.contains(e(paramg));
      AppMethodBeat.o(204465);
      return bool;
    }
    
    final boolean isEmpty()
    {
      AppMethodBeat.i(204466);
      boolean bool = this.aHJ.isEmpty();
      AppMethodBeat.o(204466);
      return bool;
    }
    
    public final Iterator<l.d> iterator()
    {
      AppMethodBeat.i(204470);
      Iterator localIterator = this.aHJ.iterator();
      AppMethodBeat.o(204470);
      return localIterator;
    }
    
    final e oU()
    {
      AppMethodBeat.i(204468);
      e locale = new e(new ArrayList(this.aHJ));
      AppMethodBeat.o(204468);
      return locale;
    }
    
    final int size()
    {
      AppMethodBeat.i(204467);
      int i = this.aHJ.size();
      AppMethodBeat.o(204467);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.l
 * JD-Core Version:    0.7.0.1
 */