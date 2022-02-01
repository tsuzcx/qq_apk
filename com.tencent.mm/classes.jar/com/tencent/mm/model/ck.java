package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class ck
{
  private a onr;
  private long ons;
  private long ont;
  private String onu;
  private int onv;
  
  public ck(a parama)
  {
    AppMethodBeat.i(132274);
    this.onr = null;
    this.ons = 0L;
    this.ont = 0L;
    this.onu = "";
    this.onv = 1;
    Assert.assertTrue(true);
    this.onr = parama;
    bDm();
    AppMethodBeat.o(132274);
  }
  
  private void bDm()
  {
    this.onv = 1;
    this.ons = 0L;
    this.ont = 0L;
    this.onu = "";
  }
  
  private void bDq()
  {
    try
    {
      AppMethodBeat.i(132278);
      if ((this.onv != 1) && (this.ons + this.ont < Util.nowMilliSecond())) {
        bDo();
      }
      AppMethodBeat.o(132278);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean bDn()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 67
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   18: invokevirtual 77	com/tencent/mm/sdk/platformtools/MMStack:toString	()Ljava/lang/String;
    //   21: putfield 38	com/tencent/mm/model/ck:onu	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 40	com/tencent/mm/model/ck:onv	I
    //   28: iconst_1
    //   29: if_icmpne +73 -> 102
    //   32: aload_0
    //   33: lload 4
    //   35: putfield 34	com/tencent/mm/model/ck:ont	J
    //   38: aload_0
    //   39: ldc2_w 78
    //   42: putfield 32	com/tencent/mm/model/ck:ons	J
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
    //   65: getfield 38	com/tencent/mm/model/ck:onu	Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: iconst_2
    //   74: putfield 40	com/tencent/mm/model/ck:onv	I
    //   77: aload_0
    //   78: getfield 30	com/tencent/mm/model/ck:onr	Lcom/tencent/mm/model/ck$a;
    //   81: invokeinterface 97 1 0
    //   86: ifeq +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 100	com/tencent/mm/model/ck:bDp	()V
    //   93: ldc 67
    //   95: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: iload_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 34	com/tencent/mm/model/ck:ont	J
    //   106: aload_0
    //   107: getfield 32	com/tencent/mm/model/ck:ons	J
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
    //   129: getfield 32	com/tencent/mm/model/ck:ons	J
    //   132: lload 4
    //   134: lload_2
    //   135: lsub
    //   136: ladd
    //   137: putfield 32	com/tencent/mm/model/ck:ons	J
    //   140: ldc 81
    //   142: ldc 102
    //   144: iconst_5
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: getfield 40	com/tencent/mm/model/ck:onv	I
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
    //   180: getfield 32	com/tencent/mm/model/ck:ons	J
    //   183: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_4
    //   189: aload_0
    //   190: getfield 38	com/tencent/mm/model/ck:onu	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	214	0	this	ck
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
  public final void bDo()
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
    //   18: getfield 40	com/tencent/mm/model/ck:onv	I
    //   21: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   30: aastore
    //   31: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 40	com/tencent/mm/model/ck:onv	I
    //   38: iconst_1
    //   39: if_icmpne +28 -> 67
    //   42: ldc 81
    //   44: ldc 115
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   55: aastore
    //   56: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: ldc 108
    //   61: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: invokespecial 49	com/tencent/mm/model/ck:bDm	()V
    //   71: new 117	com/tencent/mm/autogen/a/aak
    //   74: dup
    //   75: invokespecial 118	com/tencent/mm/autogen/a/aak:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: getfield 122	com/tencent/mm/autogen/a/aak:idR	Lcom/tencent/mm/autogen/a/aak$a;
    //   83: iconst_1
    //   84: putfield 127	com/tencent/mm/autogen/a/aak$a:status	I
    //   87: aload_1
    //   88: invokevirtual 130	com/tencent/mm/autogen/a/aak:publish	()Z
    //   91: pop
    //   92: ldc 108
    //   94: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: goto -33 -> 64
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	ck
    //   78	10	1	localaak	com.tencent.mm.autogen.a.aak
    //   100	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	100	finally
    //   67	97	100	finally
  }
  
  /* Error */
  public final void bDp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 131
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 40	com/tencent/mm/model/ck:onv	I
    //   11: iconst_2
    //   12: if_icmpeq +38 -> 50
    //   15: ldc 81
    //   17: ldc 133
    //   19: iconst_2
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 40	com/tencent/mm/model/ck:onv	I
    //   29: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   38: aastore
    //   39: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: ldc 131
    //   44: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: ldc 81
    //   52: ldc 138
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 34	com/tencent/mm/model/ck:ont	J
    //   64: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   67: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: invokestatic 71	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   76: aastore
    //   77: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 40	com/tencent/mm/model/ck:onv	I
    //   85: new 117	com/tencent/mm/autogen/a/aak
    //   88: dup
    //   89: invokespecial 118	com/tencent/mm/autogen/a/aak:<init>	()V
    //   92: astore_1
    //   93: aload_1
    //   94: getfield 122	com/tencent/mm/autogen/a/aak:idR	Lcom/tencent/mm/autogen/a/aak$a;
    //   97: iconst_3
    //   98: putfield 127	com/tencent/mm/autogen/a/aak$a:status	I
    //   101: aload_1
    //   102: invokevirtual 130	com/tencent/mm/autogen/a/aak:publish	()Z
    //   105: pop
    //   106: ldc 131
    //   108: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -64 -> 47
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	ck
    //   92	10	1	localaak	com.tencent.mm.autogen.a.aak
    //   114	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	114	finally
    //   50	111	114	finally
  }
  
  /* Error */
  public final boolean bDr()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 144
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 146	com/tencent/mm/model/ck:bDq	()V
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/model/ck:onv	I
    //   15: iconst_2
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 144
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 144
    //   34: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ck
    //   20	12	1	bool	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   21	26	40	finally
    //   32	37	40	finally
  }
  
  /* Error */
  public final boolean bDs()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 148
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 146	com/tencent/mm/model/ck:bDq	()V
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/model/ck:onv	I
    //   15: iconst_3
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 148
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 148
    //   34: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	ck
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
    public abstract boolean bDt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ck
 * JD-Core Version:    0.7.0.1
 */