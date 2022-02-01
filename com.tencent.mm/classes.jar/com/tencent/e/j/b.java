package com.tencent.e.j;

import android.os.Handler;
import com.tencent.e.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements d.d, e.a
{
  private a KbJ;
  
  public b(a parama)
  {
    this.KbJ = parama;
  }
  
  /* Error */
  public final void a(a parama, e parame)
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: aconst_null
    //   7: putfield 35	com/tencent/e/j/e:KbY	Lcom/tencent/e/j/e$a;
    //   10: aload_1
    //   11: getfield 41	com/tencent/e/j/a:KbG	Lcom/tencent/e/j/d;
    //   14: astore_1
    //   15: aload_1
    //   16: getfield 47	com/tencent/e/j/d:Kar	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   19: invokevirtual 53	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   22: ifne +227 -> 249
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_1
    //   28: getfield 57	com/tencent/e/j/d:KbV	Ljava/util/LinkedList;
    //   31: invokevirtual 63	java/util/LinkedList:pollFirst	()Ljava/lang/Object;
    //   34: checkcast 31	com/tencent/e/j/e
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +27 -> 66
    //   42: aload_1
    //   43: getfield 67	com/tencent/e/j/d:KbT	Lcom/tencent/e/j/d$d;
    //   46: invokestatic 73	java/util/Objects:requireNonNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 6	com/tencent/e/j/d$d
    //   52: aload_2
    //   53: invokeinterface 76 2 0
    //   58: aload_1
    //   59: monitorexit
    //   60: ldc 23
    //   62: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: aload_1
    //   67: iconst_0
    //   68: putfield 83	com/tencent/e/j/d:isRunning	Z
    //   71: aload_1
    //   72: monitorenter
    //   73: aload_1
    //   74: getfield 86	com/tencent/e/j/d:KbW	Ljava/util/LinkedList;
    //   77: invokevirtual 90	java/util/LinkedList:size	()I
    //   80: istore 4
    //   82: iload 4
    //   84: ifle +37 -> 121
    //   87: aload_1
    //   88: getfield 94	com/tencent/e/j/d:KbX	[Lcom/tencent/e/j/d$c;
    //   91: ifnonnull +12 -> 103
    //   94: aload_1
    //   95: iload 4
    //   97: anewarray 96	com/tencent/e/j/d$c
    //   100: putfield 94	com/tencent/e/j/d:KbX	[Lcom/tencent/e/j/d$c;
    //   103: aload_1
    //   104: aload_1
    //   105: getfield 86	com/tencent/e/j/d:KbW	Ljava/util/LinkedList;
    //   108: aload_1
    //   109: getfield 94	com/tencent/e/j/d:KbX	[Lcom/tencent/e/j/d$c;
    //   112: invokevirtual 100	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   115: checkcast 101	[Lcom/tencent/e/j/d$c;
    //   118: putfield 94	com/tencent/e/j/d:KbX	[Lcom/tencent/e/j/d$c;
    //   121: aload_1
    //   122: monitorexit
    //   123: iconst_0
    //   124: istore_3
    //   125: iload_3
    //   126: iload 4
    //   128: if_icmpge +113 -> 241
    //   131: aload_1
    //   132: getfield 94	com/tencent/e/j/d:KbX	[Lcom/tencent/e/j/d$c;
    //   135: iload_3
    //   136: aaload
    //   137: astore_2
    //   138: aload_1
    //   139: getfield 94	com/tencent/e/j/d:KbX	[Lcom/tencent/e/j/d$c;
    //   142: iload_3
    //   143: aconst_null
    //   144: aastore
    //   145: aload_2
    //   146: invokeinterface 104 1 0
    //   151: istore 5
    //   153: iload 5
    //   155: ifne +16 -> 171
    //   158: aload_1
    //   159: monitorenter
    //   160: aload_1
    //   161: getfield 86	com/tencent/e/j/d:KbW	Ljava/util/LinkedList;
    //   164: aload_2
    //   165: invokevirtual 108	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: aload_1
    //   170: monitorexit
    //   171: iload_3
    //   172: iconst_1
    //   173: iadd
    //   174: istore_3
    //   175: goto -50 -> 125
    //   178: astore_2
    //   179: aload_1
    //   180: monitorexit
    //   181: ldc 23
    //   183: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_2
    //   187: athrow
    //   188: astore_2
    //   189: aload_1
    //   190: monitorexit
    //   191: ldc 23
    //   193: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_2
    //   197: athrow
    //   198: astore_2
    //   199: aload_1
    //   200: monitorexit
    //   201: ldc 23
    //   203: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_2
    //   207: athrow
    //   208: astore 6
    //   210: aload_1
    //   211: monitorenter
    //   212: aload_1
    //   213: getfield 86	com/tencent/e/j/d:KbW	Ljava/util/LinkedList;
    //   216: aload_2
    //   217: invokevirtual 108	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: aload_1
    //   222: monitorexit
    //   223: ldc 23
    //   225: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload 6
    //   230: athrow
    //   231: astore_2
    //   232: aload_1
    //   233: monitorexit
    //   234: ldc 23
    //   236: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_2
    //   240: athrow
    //   241: aload_1
    //   242: monitorexit
    //   243: ldc 23
    //   245: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: return
    //   249: ldc 23
    //   251: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	b
    //   0	255	1	parama	a
    //   0	255	2	parame	e
    //   124	51	3	i	int
    //   80	49	4	j	int
    //   151	3	5	bool	boolean
    //   208	21	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   73	82	178	finally
    //   87	103	178	finally
    //   103	121	178	finally
    //   121	123	178	finally
    //   179	181	178	finally
    //   27	38	188	finally
    //   42	60	188	finally
    //   66	73	188	finally
    //   131	145	188	finally
    //   158	160	188	finally
    //   181	188	188	finally
    //   189	191	188	finally
    //   201	208	188	finally
    //   210	212	188	finally
    //   223	231	188	finally
    //   234	241	188	finally
    //   241	243	188	finally
    //   160	171	198	finally
    //   199	201	198	finally
    //   145	153	208	finally
    //   212	223	231	finally
    //   232	234	231	finally
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(183408);
    parame.KbY = this;
    parame.Kby.h(parame);
    AppMethodBeat.o(183408);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(183410);
    synchronized (parame.GvQ.KbG)
    {
      if (???.KbU.remove(parame)) {
        ???.KbS.removeMessages(1, parame);
      }
      Iterator localIterator = ???.KbV.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale == parame)
        {
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
    }
    parame.KbY = null;
    AppMethodBeat.o(183410);
  }
  
  static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.j.b
 * JD-Core Version:    0.7.0.1
 */