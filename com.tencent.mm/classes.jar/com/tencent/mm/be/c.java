package com.tencent.mm.be;

import android.os.HandlerThread;
import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  implements INetworkApi, f
{
  private float cAH;
  private int cAI;
  private int cAJ;
  private String cAK;
  private String cAL;
  private float cyV;
  private a fNX;
  private byte[] fNY;
  private int fNZ;
  private Object lock;
  private int scene;
  private ap timerHandler;
  
  public c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(78556);
    this.lock = new Object();
    g.RM();
    this.timerHandler = new ap(g.RO().oNc.getLooper(), new c.1(this), false);
    this.cAH = paramFloat1;
    this.cyV = paramFloat2;
    this.cAI = paramInt1;
    this.cAJ = paramInt2;
    this.cAK = paramString1;
    this.cAL = paramString2;
    this.fNZ = paramInt3;
    this.scene = paramInt4;
    g.RK().eHt.a(752, this);
    AppMethodBeat.o(78556);
  }
  
  private void ajf()
  {
    AppMethodBeat.i(78558);
    g.RK().eHt.b(752, this);
    AppMethodBeat.o(78558);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(78557);
    this.timerHandler.stopTimer();
    if (this.fNX != null) {
      g.RK().eHt.a(this.fNX);
    }
    this.fNX = null;
    this.fNY = null;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      ajf();
      AppMethodBeat.o(78557);
      return;
    }
  }
  
  public final byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78559);
    ab.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
    AppMethodBeat.o(78559);
    return new byte[0];
  }
  
  public final byte[] httpRequest(byte[] arg1)
  {
    AppMethodBeat.i(78560);
    for (;;)
    {
      try
      {
        ??? = new String(???, "UTF-8");
        ab.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(???)));
        this.fNY = null;
        this.fNX = new a(this.cAH, this.cyV, this.cAI, this.cAJ, this.cAK, this.cAL, this.fNZ, this.scene, ???);
        g.RK().eHt.a(this.fNX, 0);
        this.timerHandler.ag(60000L, 60000L);
      }
      catch (Exception ???)
      {
        ab.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", ???, "", new Object[0]);
        ab.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + ???.toString());
        continue;
      }
      synchronized (this.lock)
      {
        this.lock.wait();
        ab.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[] { Boolean.valueOf(bo.ce(this.fNY)) });
        ??? = this.fNY;
        AppMethodBeat.o(78560);
        return ???;
      }
    }
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ai.m paramm)
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 75	com/tencent/mm/be/c:timerHandler	Lcom/tencent/mm/sdk/platformtools/ap;
    //   9: invokevirtual 130	com/tencent/mm/sdk/platformtools/ap:stopTimer	()V
    //   12: iload_1
    //   13: ifne +140 -> 153
    //   16: iload_2
    //   17: ifne +136 -> 153
    //   20: aload 4
    //   22: instanceof 176
    //   25: ifeq +108 -> 133
    //   28: aload 4
    //   30: checkcast 176	com/tencent/mm/be/a
    //   33: getfield 238	com/tencent/mm/be/a:fNy	Ljava/lang/String;
    //   36: ldc 209
    //   38: invokestatic 242	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: ldc 143
    //   44: ldc 244
    //   46: aload_3
    //   47: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 174	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_3
    //   58: ldc 159
    //   60: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   63: putfield 123	com/tencent/mm/be/c:fNY	[B
    //   66: aload_0
    //   67: getfield 41	com/tencent/mm/be/c:lock	Ljava/lang/Object;
    //   70: astore_3
    //   71: aload_3
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 41	com/tencent/mm/be/c:lock	Ljava/lang/Object;
    //   77: invokevirtual 136	java/lang/Object:notifyAll	()V
    //   80: aload_3
    //   81: monitorexit
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 114	com/tencent/mm/be/c:fNX	Lcom/tencent/mm/be/a;
    //   87: ldc 235
    //   89: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore_3
    //   94: ldc 143
    //   96: aload_3
    //   97: ldc 209
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 213	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: ldc 143
    //   108: new 215	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 250
    //   114: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   121: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 232	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -64 -> 66
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 123	com/tencent/mm/be/c:fNY	[B
    //   138: goto -72 -> 66
    //   141: astore 4
    //   143: aload_3
    //   144: monitorexit
    //   145: ldc 235
    //   147: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 4
    //   152: athrow
    //   153: ldc 143
    //   155: ldc 252
    //   157: iconst_3
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: iload_1
    //   164: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: iload_2
    //   171: invokestatic 257	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_2
    //   177: aload_3
    //   178: aastore
    //   179: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 123	com/tencent/mm/be/c:fNY	[B
    //   187: aload_0
    //   188: getfield 41	com/tencent/mm/be/c:lock	Ljava/lang/Object;
    //   191: astore_3
    //   192: aload_3
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 41	com/tencent/mm/be/c:lock	Ljava/lang/Object;
    //   198: invokevirtual 136	java/lang/Object:notifyAll	()V
    //   201: aload_3
    //   202: monitorexit
    //   203: invokestatic 265	com/tencent/mm/be/b:aiV	()Lcom/tencent/mm/be/b;
    //   206: invokevirtual 268	com/tencent/mm/be/b:aiX	()V
    //   209: getstatic 274	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   212: ldc2_w 275
    //   215: ldc2_w 277
    //   218: lconst_1
    //   219: iconst_0
    //   220: invokevirtual 282	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   223: goto -141 -> 82
    //   226: astore 4
    //   228: aload_3
    //   229: monitorexit
    //   230: ldc 235
    //   232: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload 4
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	c
    //   0	238	1	paramInt1	int
    //   0	238	2	paramInt2	int
    //   0	238	4	paramm	com.tencent.mm.ai.m
    // Exception table:
    //   from	to	target	type
    //   56	66	93	java/lang/Exception
    //   73	82	141	finally
    //   143	145	141	finally
    //   194	203	226	finally
    //   228	230	226	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.c
 * JD-Core Version:    0.7.0.1
 */