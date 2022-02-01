package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class cb
{
  private a hpS;
  private long hpT;
  private long hpU;
  private String hpV;
  private int hpW;
  
  public cb(a parama)
  {
    AppMethodBeat.i(132274);
    this.hpS = null;
    this.hpT = 0L;
    this.hpU = 0L;
    this.hpV = "";
    this.hpW = 1;
    Assert.assertTrue(true);
    this.hpS = parama;
    azz();
    AppMethodBeat.o(132274);
  }
  
  private void azD()
  {
    try
    {
      AppMethodBeat.i(132278);
      if ((this.hpW != 1) && (this.hpT + this.hpU < bs.eWj())) {
        azB();
      }
      AppMethodBeat.o(132278);
      return;
    }
    finally {}
  }
  
  private void azz()
  {
    this.hpW = 1;
    this.hpT = 0L;
    this.hpU = 0L;
    this.hpV = "";
  }
  
  /* Error */
  public final boolean azA()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 67
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 61	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   18: invokevirtual 77	com/tencent/mm/sdk/platformtools/as:toString	()Ljava/lang/String;
    //   21: putfield 38	com/tencent/mm/model/cb:hpV	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   28: iconst_1
    //   29: if_icmpne +73 -> 102
    //   32: aload_0
    //   33: lload 4
    //   35: putfield 34	com/tencent/mm/model/cb:hpU	J
    //   38: aload_0
    //   39: ldc2_w 78
    //   42: putfield 32	com/tencent/mm/model/cb:hpT	J
    //   45: ldc 81
    //   47: ldc 83
    //   49: iconst_2
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: ldc2_w 78
    //   58: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_0
    //   65: getfield 38	com/tencent/mm/model/cb:hpV	Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: iconst_2
    //   74: putfield 40	com/tencent/mm/model/cb:hpW	I
    //   77: aload_0
    //   78: getfield 30	com/tencent/mm/model/cb:hpS	Lcom/tencent/mm/model/cb$a;
    //   81: invokeinterface 97 1 0
    //   86: ifeq +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 100	com/tencent/mm/model/cb:azC	()V
    //   93: ldc 67
    //   95: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: iload_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 34	com/tencent/mm/model/cb:hpU	J
    //   106: aload_0
    //   107: getfield 32	com/tencent/mm/model/cb:hpT	J
    //   110: ladd
    //   111: lstore_2
    //   112: lload 4
    //   114: ldc2_w 78
    //   117: ladd
    //   118: lstore 4
    //   120: lload 4
    //   122: lload_2
    //   123: lcmp
    //   124: ifle +16 -> 140
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 32	com/tencent/mm/model/cb:hpT	J
    //   132: lload 4
    //   134: lload_2
    //   135: lsub
    //   136: ladd
    //   137: putfield 32	com/tencent/mm/model/cb:hpT	J
    //   140: ldc 81
    //   142: ldc 102
    //   144: iconst_5
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   154: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: ldc2_w 78
    //   163: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: lload 4
    //   171: lload_2
    //   172: lsub
    //   173: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: aload_0
    //   180: getfield 32	com/tencent/mm/model/cb:hpT	J
    //   183: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_4
    //   189: aload_0
    //   190: getfield 38	com/tencent/mm/model/cb:hpV	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 94	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 67
    //   199: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -106 -> 98
    //   207: astore 6
    //   209: aload_0
    //   210: monitorexit
    //   211: aload 6
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	cb
    //   1	203	1	bool	boolean
    //   111	61	2	l1	long
    //   12	158	4	l2	long
    //   207	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	93	207	finally
    //   93	98	207	finally
    //   102	112	207	finally
    //   127	140	207	finally
    //   140	202	207	finally
  }
  
  /* Error */
  public final void azB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 108
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 81
    //   9: ldc 110
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   21: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   30: aastore
    //   31: invokestatic 113	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   38: iconst_1
    //   39: if_icmpne +28 -> 67
    //   42: ldc 81
    //   44: ldc 115
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   55: aastore
    //   56: invokestatic 113	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: ldc 108
    //   61: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: invokespecial 49	com/tencent/mm/model/cb:azz	()V
    //   71: new 117	com/tencent/mm/g/a/vo
    //   74: dup
    //   75: invokespecial 118	com/tencent/mm/g/a/vo:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: getfield 122	com/tencent/mm/g/a/vo:dyr	Lcom/tencent/mm/g/a/vo$a;
    //   83: iconst_1
    //   84: putfield 127	com/tencent/mm/g/a/vo$a:status	I
    //   87: getstatic 133	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_1
    //   91: invokevirtual 137	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   94: pop
    //   95: ldc 108
    //   97: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -36 -> 64
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	cb
    //   78	13	1	localvo	com.tencent.mm.g.a.vo
    //   103	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	103	finally
    //   67	100	103	finally
  }
  
  /* Error */
  public final void azC()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   11: iconst_2
    //   12: if_icmpeq +38 -> 50
    //   15: ldc 81
    //   17: ldc 140
    //   19: iconst_2
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   29: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   38: aastore
    //   39: invokestatic 143	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: ldc 138
    //   44: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: ldc 81
    //   52: ldc 145
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 34	com/tencent/mm/model/cb:hpU	J
    //   64: invokestatic 149	com/tencent/mm/sdk/platformtools/bs:Ap	(J)J
    //   67: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: invokestatic 71	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   76: aastore
    //   77: invokestatic 113	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 40	com/tencent/mm/model/cb:hpW	I
    //   85: new 117	com/tencent/mm/g/a/vo
    //   88: dup
    //   89: invokespecial 118	com/tencent/mm/g/a/vo:<init>	()V
    //   92: astore_1
    //   93: aload_1
    //   94: getfield 122	com/tencent/mm/g/a/vo:dyr	Lcom/tencent/mm/g/a/vo$a;
    //   97: iconst_3
    //   98: putfield 127	com/tencent/mm/g/a/vo$a:status	I
    //   101: getstatic 133	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   104: aload_1
    //   105: invokevirtual 137	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   108: pop
    //   109: ldc 138
    //   111: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: goto -67 -> 47
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	cb
    //   92	13	1	localvo	com.tencent.mm.g.a.vo
    //   117	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	117	finally
    //   50	114	117	finally
  }
  
  /* Error */
  public final boolean azE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 151
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 153	com/tencent/mm/model/cb:azD	()V
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   15: iconst_2
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 151
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 151
    //   34: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	cb
    //   20	12	1	bool	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   21	26	40	finally
    //   32	37	40	finally
  }
  
  /* Error */
  public final boolean azF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 153	com/tencent/mm/model/cb:azD	()V
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/model/cb:hpW	I
    //   15: iconst_3
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 155
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 155
    //   34: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	cb
    //   20	12	1	bool	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   21	26	40	finally
    //   32	37	40	finally
  }
  
  public static abstract interface a
  {
    public abstract boolean azG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.cb
 * JD-Core Version:    0.7.0.1
 */