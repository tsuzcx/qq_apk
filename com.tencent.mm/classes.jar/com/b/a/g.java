package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class g
{
  private final c aFo;
  final AtomicInteger aFs;
  volatile e aFt;
  private final b aFu;
  private final List<b> listeners;
  private final String url;
  
  public g(String paramString, c paramc)
  {
    AppMethodBeat.i(183580);
    this.aFs = new AtomicInteger(0);
    this.listeners = new CopyOnWriteArrayList();
    this.url = ((String)l.checkNotNull(paramString));
    this.aFo = ((c)l.checkNotNull(paramc));
    this.aFu = new g.a(paramString, this.listeners);
    AppMethodBeat.o(183580);
  }
  
  /* Error */
  final void pj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 67
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 69	com/b/a/g:aFt	Lcom/b/a/e;
    //   11: ifnonnull +106 -> 117
    //   14: new 71	com/b/a/h
    //   17: dup
    //   18: aload_0
    //   19: getfield 52	com/b/a/g:url	Ljava/lang/String;
    //   22: aload_0
    //   23: getfield 56	com/b/a/g:aFo	Lcom/b/a/c;
    //   26: getfield 75	com/b/a/c:aFb	Lcom/b/a/c/b;
    //   29: aload_0
    //   30: getfield 56	com/b/a/g:aFo	Lcom/b/a/c;
    //   33: getfield 79	com/b/a/c:aFc	Lcom/b/a/b/b;
    //   36: invokespecial 82	com/b/a/h:<init>	(Ljava/lang/String;Lcom/b/a/c/b;Lcom/b/a/b/b;)V
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 56	com/b/a/g:aFo	Lcom/b/a/c;
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 52	com/b/a/g:url	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_2
    //   51: getfield 86	com/b/a/c:aEZ	Lcom/b/a/a/c;
    //   54: aload_3
    //   55: invokeinterface 92 2 0
    //   60: astore_3
    //   61: new 94	com/b/a/e
    //   64: dup
    //   65: aload_1
    //   66: new 96	com/b/a/a/b
    //   69: dup
    //   70: new 98	java/io/File
    //   73: dup
    //   74: aload_2
    //   75: getfield 102	com/b/a/c:aEY	Ljava/io/File;
    //   78: aload_3
    //   79: invokespecial 105	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   82: aload_0
    //   83: getfield 56	com/b/a/g:aFo	Lcom/b/a/c;
    //   86: getfield 109	com/b/a/c:aFa	Lcom/b/a/a/a;
    //   89: invokespecial 112	com/b/a/a/b:<init>	(Ljava/io/File;Lcom/b/a/a/a;)V
    //   92: invokespecial 115	com/b/a/e:<init>	(Lcom/b/a/h;Lcom/b/a/a/b;)V
    //   95: astore_1
    //   96: aload_1
    //   97: aload_0
    //   98: getfield 61	com/b/a/g:aFu	Lcom/b/a/b;
    //   101: putfield 118	com/b/a/e:aFi	Lcom/b/a/b;
    //   104: aload_0
    //   105: aload_1
    //   106: putfield 69	com/b/a/g:aFt	Lcom/b/a/e;
    //   109: ldc 67
    //   111: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_0
    //   115: monitorexit
    //   116: return
    //   117: aload_0
    //   118: getfield 69	com/b/a/g:aFt	Lcom/b/a/e;
    //   121: astore_1
    //   122: goto -18 -> 104
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	g
    //   39	83	1	localObject1	Object
    //   125	4	1	localObject2	Object
    //   44	31	2	localc	c
    //   49	30	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	104	125	finally
    //   104	114	125	finally
    //   117	122	125	finally
  }
  
  /* Error */
  final void pk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 122
    //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 37	com/b/a/g:aFs	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 126	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   14: ifgt +70 -> 84
    //   17: aload_0
    //   18: getfield 69	com/b/a/g:aFt	Lcom/b/a/e;
    //   21: astore_2
    //   22: aload_2
    //   23: getfield 132	com/b/a/m:aFF	Ljava/lang/Object;
    //   26: astore_1
    //   27: aload_1
    //   28: monitorenter
    //   29: new 134	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 136
    //   35: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: getfield 143	com/b/a/m:aFC	Lcom/b/a/p;
    //   42: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: invokestatic 152	com/b/a/k:pn	()V
    //   49: aload_2
    //   50: iconst_1
    //   51: putfield 156	com/b/a/m:aFI	Z
    //   54: aload_2
    //   55: getfield 160	com/b/a/m:aFH	Ljava/lang/Thread;
    //   58: ifnull +10 -> 68
    //   61: aload_2
    //   62: getfield 160	com/b/a/m:aFH	Ljava/lang/Thread;
    //   65: invokevirtual 165	java/lang/Thread:interrupt	()V
    //   68: aload_2
    //   69: getfield 169	com/b/a/m:aFD	Lcom/b/a/a;
    //   72: invokeinterface 174 1 0
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 69	com/b/a/g:aFt	Lcom/b/a/e;
    //   84: ldc 122
    //   86: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: astore_2
    //   93: aload_2
    //   94: invokestatic 178	com/b/a/m:c	(Ljava/lang/Throwable;)V
    //   97: goto -20 -> 77
    //   100: astore_2
    //   101: aload_1
    //   102: monitorexit
    //   103: ldc 122
    //   105: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	g
    //   110	4	1	localObject2	Object
    //   21	48	2	locale	e
    //   92	2	2	localn	n
    //   100	9	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	68	92	com/b/a/n
    //   68	77	92	com/b/a/n
    //   29	49	100	finally
    //   49	68	100	finally
    //   68	77	100	finally
    //   77	79	100	finally
    //   93	97	100	finally
    //   2	29	110	finally
    //   79	84	110	finally
    //   84	89	110	finally
    //   101	110	110	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.g
 * JD-Core Version:    0.7.0.1
 */