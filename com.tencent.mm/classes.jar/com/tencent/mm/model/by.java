package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class by
{
  private by.a fnQ;
  private long fnR;
  private long fnS;
  private String fnT;
  private int fnU;
  
  public by(by.a parama)
  {
    AppMethodBeat.i(58130);
    this.fnQ = null;
    this.fnR = 0L;
    this.fnS = 0L;
    this.fnT = "";
    this.fnU = 1;
    Assert.assertTrue(true);
    this.fnQ = parama;
    abh();
    AppMethodBeat.o(58130);
  }
  
  private void abh()
  {
    this.fnU = 1;
    this.fnR = 0L;
    this.fnS = 0L;
    this.fnT = "";
  }
  
  private void abl()
  {
    try
    {
      AppMethodBeat.i(58134);
      if ((this.fnU != 1) && (this.fnR + this.fnS < bo.aoy())) {
        abj();
      }
      AppMethodBeat.o(58134);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean abi()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 66
    //   6: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 60	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: invokestatic 70	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   18: invokevirtual 76	com/tencent/mm/sdk/platformtools/an:toString	()Ljava/lang/String;
    //   21: putfield 37	com/tencent/mm/model/by:fnT	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 39	com/tencent/mm/model/by:fnU	I
    //   28: iconst_1
    //   29: if_icmpne +73 -> 102
    //   32: aload_0
    //   33: lload 4
    //   35: putfield 33	com/tencent/mm/model/by:fnS	J
    //   38: aload_0
    //   39: ldc2_w 77
    //   42: putfield 31	com/tencent/mm/model/by:fnR	J
    //   45: ldc 80
    //   47: ldc 82
    //   49: iconst_2
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: ldc2_w 77
    //   58: invokestatic 88	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_0
    //   65: getfield 37	com/tencent/mm/model/by:fnT	Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: iconst_2
    //   74: putfield 39	com/tencent/mm/model/by:fnU	I
    //   77: aload_0
    //   78: getfield 29	com/tencent/mm/model/by:fnQ	Lcom/tencent/mm/model/by$a;
    //   81: invokeinterface 96 1 0
    //   86: ifeq +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 99	com/tencent/mm/model/by:abk	()V
    //   93: ldc 66
    //   95: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: iload_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 33	com/tencent/mm/model/by:fnS	J
    //   106: aload_0
    //   107: getfield 31	com/tencent/mm/model/by:fnR	J
    //   110: ladd
    //   111: lstore_2
    //   112: lload 4
    //   114: ldc2_w 77
    //   117: ladd
    //   118: lstore 4
    //   120: lload 4
    //   122: lload_2
    //   123: lcmp
    //   124: ifle +16 -> 140
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 31	com/tencent/mm/model/by:fnR	J
    //   132: lload 4
    //   134: lload_2
    //   135: lsub
    //   136: ladd
    //   137: putfield 31	com/tencent/mm/model/by:fnR	J
    //   140: ldc 80
    //   142: ldc 101
    //   144: iconst_5
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: getfield 39	com/tencent/mm/model/by:fnU	I
    //   154: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: ldc2_w 77
    //   163: invokestatic 88	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: lload 4
    //   171: lload_2
    //   172: lsub
    //   173: invokestatic 88	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: aload_0
    //   180: getfield 31	com/tencent/mm/model/by:fnR	J
    //   183: invokestatic 88	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_4
    //   189: aload_0
    //   190: getfield 37	com/tencent/mm/model/by:fnT	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 93	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 66
    //   199: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	214	0	this	by
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
  public final void abj()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 107
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 80
    //   9: ldc 109
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 39	com/tencent/mm/model/by:fnU	I
    //   21: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 70	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   30: aastore
    //   31: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 39	com/tencent/mm/model/by:fnU	I
    //   38: iconst_1
    //   39: if_icmpne +28 -> 67
    //   42: ldc 80
    //   44: ldc 114
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: invokestatic 70	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   55: aastore
    //   56: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: ldc 107
    //   61: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: invokespecial 48	com/tencent/mm/model/by:abh	()V
    //   71: new 116	com/tencent/mm/g/a/th
    //   74: dup
    //   75: invokespecial 117	com/tencent/mm/g/a/th:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: getfield 121	com/tencent/mm/g/a/th:cJL	Lcom/tencent/mm/g/a/th$a;
    //   83: iconst_1
    //   84: putfield 126	com/tencent/mm/g/a/th$a:status	I
    //   87: getstatic 132	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   90: aload_1
    //   91: invokevirtual 136	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   94: pop
    //   95: ldc 107
    //   97: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -36 -> 64
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	by
    //   78	13	1	localth	com.tencent.mm.g.a.th
    //   103	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	103	finally
    //   67	100	103	finally
  }
  
  /* Error */
  public final void abk()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 137
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 39	com/tencent/mm/model/by:fnU	I
    //   11: iconst_2
    //   12: if_icmpeq +38 -> 50
    //   15: ldc 80
    //   17: ldc 139
    //   19: iconst_2
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 39	com/tencent/mm/model/by:fnU	I
    //   29: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: invokestatic 70	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   38: aastore
    //   39: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: ldc 137
    //   44: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: ldc 80
    //   52: ldc 144
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 33	com/tencent/mm/model/by:fnS	J
    //   64: invokestatic 148	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   67: invokestatic 88	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: invokestatic 70	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   76: aastore
    //   77: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 39	com/tencent/mm/model/by:fnU	I
    //   85: new 116	com/tencent/mm/g/a/th
    //   88: dup
    //   89: invokespecial 117	com/tencent/mm/g/a/th:<init>	()V
    //   92: astore_1
    //   93: aload_1
    //   94: getfield 121	com/tencent/mm/g/a/th:cJL	Lcom/tencent/mm/g/a/th$a;
    //   97: iconst_3
    //   98: putfield 126	com/tencent/mm/g/a/th$a:status	I
    //   101: getstatic 132	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   104: aload_1
    //   105: invokevirtual 136	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   108: pop
    //   109: ldc 137
    //   111: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: goto -67 -> 47
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	by
    //   92	13	1	localth	com.tencent.mm.g.a.th
    //   117	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	117	finally
    //   50	114	117	finally
  }
  
  /* Error */
  public final boolean abm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 150
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 152	com/tencent/mm/model/by:abl	()V
    //   11: aload_0
    //   12: getfield 39	com/tencent/mm/model/by:fnU	I
    //   15: iconst_2
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 150
    //   23: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 150
    //   34: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	by
    //   20	12	1	bool	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   21	26	40	finally
    //   32	37	40	finally
  }
  
  /* Error */
  public final boolean abn()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 154
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 152	com/tencent/mm/model/by:abl	()V
    //   11: aload_0
    //   12: getfield 39	com/tencent/mm/model/by:fnU	I
    //   15: iconst_3
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 154
    //   23: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 154
    //   34: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	by
    //   20	12	1	bool	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   21	26	40	finally
    //   32	37	40	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.by
 * JD-Core Version:    0.7.0.1
 */