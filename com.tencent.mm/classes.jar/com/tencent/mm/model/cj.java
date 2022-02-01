package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class cj
{
  private a lvS;
  private long lvT;
  private long lvU;
  private String lvV;
  private int lvW;
  
  public cj(a parama)
  {
    AppMethodBeat.i(132274);
    this.lvS = null;
    this.lvT = 0L;
    this.lvU = 0L;
    this.lvV = "";
    this.lvW = 1;
    Assert.assertTrue(true);
    this.lvS = parama;
    bfu();
    AppMethodBeat.o(132274);
  }
  
  private void bfu()
  {
    this.lvW = 1;
    this.lvT = 0L;
    this.lvU = 0L;
    this.lvV = "";
  }
  
  private void bfy()
  {
    try
    {
      AppMethodBeat.i(132278);
      if ((this.lvW != 1) && (this.lvT + this.lvU < Util.nowMilliSecond())) {
        bfw();
      }
      AppMethodBeat.o(132278);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean bfA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 67
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 69	com/tencent/mm/model/cj:bfy	()V
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   15: iconst_3
    //   16: if_icmpne +14 -> 30
    //   19: iconst_1
    //   20: istore_1
    //   21: ldc 67
    //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_1
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_1
    //   32: ldc 67
    //   34: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: goto -11 -> 26
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	cj
    //   20	12	1	bool	boolean
    //   40	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	40	finally
    //   21	26	40	finally
    //   32	37	40	finally
  }
  
  /* Error */
  public final boolean bfv()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 71
    //   6: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   12: lstore 4
    //   14: aload_0
    //   15: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   18: invokevirtual 81	com/tencent/mm/sdk/platformtools/MMStack:toString	()Ljava/lang/String;
    //   21: putfield 38	com/tencent/mm/model/cj:lvV	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   28: iconst_1
    //   29: if_icmpne +73 -> 102
    //   32: aload_0
    //   33: lload 4
    //   35: putfield 34	com/tencent/mm/model/cj:lvU	J
    //   38: aload_0
    //   39: ldc2_w 82
    //   42: putfield 32	com/tencent/mm/model/cj:lvT	J
    //   45: ldc 85
    //   47: ldc 87
    //   49: iconst_2
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: ldc2_w 82
    //   58: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_0
    //   65: getfield 38	com/tencent/mm/model/cj:lvV	Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: iconst_2
    //   74: putfield 40	com/tencent/mm/model/cj:lvW	I
    //   77: aload_0
    //   78: getfield 30	com/tencent/mm/model/cj:lvS	Lcom/tencent/mm/model/cj$a;
    //   81: invokeinterface 101 1 0
    //   86: ifeq +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 104	com/tencent/mm/model/cj:bfx	()V
    //   93: ldc 71
    //   95: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: iload_1
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 34	com/tencent/mm/model/cj:lvU	J
    //   106: aload_0
    //   107: getfield 32	com/tencent/mm/model/cj:lvT	J
    //   110: ladd
    //   111: lstore_2
    //   112: lload 4
    //   114: ldc2_w 82
    //   117: ladd
    //   118: lstore 4
    //   120: lload 4
    //   122: lload_2
    //   123: lcmp
    //   124: ifle +16 -> 140
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 32	com/tencent/mm/model/cj:lvT	J
    //   132: lload 4
    //   134: lload_2
    //   135: lsub
    //   136: ladd
    //   137: putfield 32	com/tencent/mm/model/cj:lvT	J
    //   140: ldc 85
    //   142: ldc 106
    //   144: iconst_5
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   154: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: ldc2_w 82
    //   163: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: lload 4
    //   171: lload_2
    //   172: lsub
    //   173: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: aload_0
    //   180: getfield 32	com/tencent/mm/model/cj:lvT	J
    //   183: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: aastore
    //   187: dup
    //   188: iconst_4
    //   189: aload_0
    //   190: getfield 38	com/tencent/mm/model/cj:lvV	Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 71
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
    //   0	214	0	this	cj
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
  public final void bfw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 112
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 85
    //   9: ldc 114
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   21: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   30: aastore
    //   31: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   38: iconst_1
    //   39: if_icmpne +28 -> 67
    //   42: ldc 85
    //   44: ldc 119
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   55: aastore
    //   56: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: ldc 112
    //   61: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: invokespecial 49	com/tencent/mm/model/cj:bfu	()V
    //   71: new 121	com/tencent/mm/f/a/yr
    //   74: dup
    //   75: invokespecial 122	com/tencent/mm/f/a/yr:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: getfield 126	com/tencent/mm/f/a/yr:fXR	Lcom/tencent/mm/f/a/yr$a;
    //   83: iconst_1
    //   84: putfield 131	com/tencent/mm/f/a/yr$a:status	I
    //   87: getstatic 137	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   90: aload_1
    //   91: invokevirtual 141	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   94: pop
    //   95: ldc 112
    //   97: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: goto -36 -> 64
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	cj
    //   78	13	1	localyr	com.tencent.mm.f.a.yr
    //   103	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	103	finally
    //   67	100	103	finally
  }
  
  /* Error */
  public final void bfx()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 142
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   11: iconst_2
    //   12: if_icmpeq +38 -> 50
    //   15: ldc 85
    //   17: ldc 144
    //   19: iconst_2
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   29: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   38: aastore
    //   39: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: ldc 142
    //   44: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: ldc 85
    //   52: ldc 149
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 34	com/tencent/mm/model/cj:lvU	J
    //   64: invokestatic 153	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   67: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: invokestatic 75	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   76: aastore
    //   77: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 40	com/tencent/mm/model/cj:lvW	I
    //   85: new 121	com/tencent/mm/f/a/yr
    //   88: dup
    //   89: invokespecial 122	com/tencent/mm/f/a/yr:<init>	()V
    //   92: astore_1
    //   93: aload_1
    //   94: getfield 126	com/tencent/mm/f/a/yr:fXR	Lcom/tencent/mm/f/a/yr$a;
    //   97: iconst_3
    //   98: putfield 131	com/tencent/mm/f/a/yr$a:status	I
    //   101: getstatic 137	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   104: aload_1
    //   105: invokevirtual 141	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   108: pop
    //   109: ldc 142
    //   111: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: goto -67 -> 47
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	cj
    //   92	13	1	localyr	com.tencent.mm.f.a.yr
    //   117	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	117	finally
    //   50	114	117	finally
  }
  
  /* Error */
  public final boolean bfz()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 155
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 69	com/tencent/mm/model/cj:bfy	()V
    //   11: aload_0
    //   12: getfield 40	com/tencent/mm/model/cj:lvW	I
    //   15: iconst_2
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
    //   0	45	0	this	cj
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
    public abstract boolean bfB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.cj
 * JD-Core Version:    0.7.0.1
 */