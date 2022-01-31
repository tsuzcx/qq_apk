package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bk;
import junit.framework.Assert;

public final class bw
{
  private bw.a dXL = null;
  private long dXM = 0L;
  private long dXN = 0L;
  private String dXO = "";
  private int dXP = 1;
  
  public bw(bw.a parama)
  {
    Assert.assertTrue(true);
    this.dXL = parama;
    Ik();
  }
  
  private void Ik()
  {
    this.dXP = 1;
    this.dXM = 0L;
    this.dXN = 0L;
    this.dXO = "";
  }
  
  private void Io()
  {
    try
    {
      if ((this.dXP != 1) && (this.dXM + this.dXN < bk.UY())) {
        Im();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean Il()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 49	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   7: lstore 5
    //   9: aload_0
    //   10: invokestatic 58	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   13: invokevirtual 64	com/tencent/mm/sdk/platformtools/ak:toString	()Ljava/lang/String;
    //   16: putfield 30	com/tencent/mm/model/bw:dXO	Ljava/lang/String;
    //   19: aload_0
    //   20: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   23: iconst_1
    //   24: if_icmpne +72 -> 96
    //   27: aload_0
    //   28: lload 5
    //   30: putfield 26	com/tencent/mm/model/bw:dXN	J
    //   33: aload_0
    //   34: ldc2_w 65
    //   37: putfield 24	com/tencent/mm/model/bw:dXM	J
    //   40: ldc 68
    //   42: ldc 70
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: ldc2_w 65
    //   53: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_0
    //   60: getfield 30	com/tencent/mm/model/bw:dXO	Ljava/lang/String;
    //   63: aastore
    //   64: invokestatic 82	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_0
    //   68: iconst_2
    //   69: putfield 32	com/tencent/mm/model/bw:dXP	I
    //   72: iload_2
    //   73: istore_1
    //   74: aload_0
    //   75: getfield 22	com/tencent/mm/model/bw:dXL	Lcom/tencent/mm/model/bw$a;
    //   78: invokeinterface 85 1 0
    //   83: ifeq +9 -> 92
    //   86: aload_0
    //   87: invokevirtual 88	com/tencent/mm/model/bw:In	()V
    //   90: iload_2
    //   91: istore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_1
    //   95: ireturn
    //   96: aload_0
    //   97: getfield 26	com/tencent/mm/model/bw:dXN	J
    //   100: aload_0
    //   101: getfield 24	com/tencent/mm/model/bw:dXM	J
    //   104: ladd
    //   105: lstore_3
    //   106: lload 5
    //   108: ldc2_w 65
    //   111: ladd
    //   112: lstore 5
    //   114: lload 5
    //   116: lload_3
    //   117: lcmp
    //   118: ifle +16 -> 134
    //   121: aload_0
    //   122: aload_0
    //   123: getfield 24	com/tencent/mm/model/bw:dXM	J
    //   126: lload 5
    //   128: lload_3
    //   129: lsub
    //   130: ladd
    //   131: putfield 24	com/tencent/mm/model/bw:dXM	J
    //   134: ldc 68
    //   136: ldc 90
    //   138: iconst_5
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   148: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: ldc2_w 65
    //   157: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   160: aastore
    //   161: dup
    //   162: iconst_2
    //   163: lload 5
    //   165: lload_3
    //   166: lsub
    //   167: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: aload_0
    //   174: getfield 24	com/tencent/mm/model/bw:dXM	J
    //   177: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: dup
    //   182: iconst_4
    //   183: aload_0
    //   184: getfield 30	com/tencent/mm/model/bw:dXO	Ljava/lang/String;
    //   187: aastore
    //   188: invokestatic 82	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: iconst_0
    //   192: istore_1
    //   193: goto -101 -> 92
    //   196: astore 7
    //   198: aload_0
    //   199: monitorexit
    //   200: aload 7
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	bw
    //   73	120	1	bool1	boolean
    //   1	90	2	bool2	boolean
    //   105	61	3	l1	long
    //   7	157	5	l2	long
    //   196	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	72	196	finally
    //   74	90	196	finally
    //   96	106	196	finally
    //   121	134	196	finally
    //   134	191	196	finally
  }
  
  /* Error */
  public final void Im()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 68
    //   4: ldc 97
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_0
    //   13: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   16: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: invokestatic 58	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   25: aastore
    //   26: invokestatic 100	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   33: iconst_1
    //   34: if_icmpne +23 -> 57
    //   37: ldc 68
    //   39: ldc 102
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: invokestatic 58	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   50: aastore
    //   51: invokestatic 100	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: invokespecial 41	com/tencent/mm/model/bw:Ik	()V
    //   61: new 104	com/tencent/mm/h/a/rq
    //   64: dup
    //   65: invokespecial 105	com/tencent/mm/h/a/rq:<init>	()V
    //   68: astore_1
    //   69: aload_1
    //   70: getfield 109	com/tencent/mm/h/a/rq:cbi	Lcom/tencent/mm/h/a/rq$a;
    //   73: iconst_1
    //   74: putfield 114	com/tencent/mm/h/a/rq$a:status	I
    //   77: getstatic 120	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   80: aload_1
    //   81: invokevirtual 124	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   84: pop
    //   85: goto -31 -> 54
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	bw
    //   68	13	1	localrq	com.tencent.mm.h.a.rq
    //   88	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	54	88	finally
    //   57	85	88	finally
  }
  
  /* Error */
  public final void In()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   6: iconst_2
    //   7: if_icmpeq +33 -> 40
    //   10: ldc 68
    //   12: ldc 126
    //   14: iconst_2
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   24: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: invokestatic 58	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   33: aastore
    //   34: invokestatic 129	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: ldc 68
    //   42: ldc 131
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: getfield 26	com/tencent/mm/model/bw:dXN	J
    //   54: invokestatic 135	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   57: invokestatic 76	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: invokestatic 58	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   66: aastore
    //   67: invokestatic 100	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_0
    //   71: iconst_3
    //   72: putfield 32	com/tencent/mm/model/bw:dXP	I
    //   75: new 104	com/tencent/mm/h/a/rq
    //   78: dup
    //   79: invokespecial 105	com/tencent/mm/h/a/rq:<init>	()V
    //   82: astore_1
    //   83: aload_1
    //   84: getfield 109	com/tencent/mm/h/a/rq:cbi	Lcom/tencent/mm/h/a/rq$a;
    //   87: iconst_3
    //   88: putfield 114	com/tencent/mm/h/a/rq$a:status	I
    //   91: getstatic 120	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   94: aload_1
    //   95: invokevirtual 124	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   98: pop
    //   99: goto -62 -> 37
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	bw
    //   82	13	1	localrq	com.tencent.mm.h.a.rq
    //   102	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	37	102	finally
    //   40	99	102	finally
  }
  
  /* Error */
  public final boolean Ip()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 138	com/tencent/mm/model/bw:Io	()V
    //   6: aload_0
    //   7: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   10: istore_1
    //   11: iload_1
    //   12: iconst_2
    //   13: if_icmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	bw
    //   10	4	1	i	int
    //   17	7	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  /* Error */
  public final boolean Iq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 138	com/tencent/mm/model/bw:Io	()V
    //   6: aload_0
    //   7: getfield 32	com/tencent/mm/model/bw:dXP	I
    //   10: istore_1
    //   11: iload_1
    //   12: iconst_3
    //   13: if_icmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_2
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_2
    //   24: goto -6 -> 18
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	bw
    //   10	4	1	i	int
    //   17	7	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */