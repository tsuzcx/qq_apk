package com.tencent.mm.bf;

import android.os.HandlerThread;
import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  implements INetworkApi, f
{
  private float dBu;
  private int dBv;
  private int dBw;
  private String dBx;
  private String dBy;
  private float dzE;
  private a inC;
  private byte[] inD;
  private int inE;
  private Object lock;
  private int scene;
  private aw timerHandler;
  
  public c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150905);
    this.lock = new Object();
    g.ajS();
    this.timerHandler = new aw(g.ajU().IxZ.getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150904);
        ae.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
        if (c.a(c.this) != null) {
          g.ajQ().gDv.a(c.a(c.this));
        }
        c.b(c.this);
        c.c(c.this);
        synchronized (c.d(c.this))
        {
          c.d(c.this).notifyAll();
          AppMethodBeat.o(150904);
          return false;
        }
      }
    }, false);
    this.dBu = paramFloat1;
    this.dzE = paramFloat2;
    this.dBv = paramInt1;
    this.dBw = paramInt2;
    this.dBx = paramString1;
    this.dBy = paramString2;
    this.inE = paramInt3;
    this.scene = paramInt4;
    g.ajQ().gDv.a(752, this);
    AppMethodBeat.o(150905);
  }
  
  private void aKI()
  {
    AppMethodBeat.i(150907);
    g.ajQ().gDv.b(752, this);
    AppMethodBeat.o(150907);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(150906);
    this.timerHandler.stopTimer();
    if (this.inC != null) {
      g.ajQ().gDv.a(this.inC);
    }
    this.inC = null;
    this.inD = null;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      aKI();
      AppMethodBeat.o(150906);
      return;
    }
  }
  
  public final byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150908);
    ae.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
    AppMethodBeat.o(150908);
    return new byte[0];
  }
  
  public final byte[] httpRequest(byte[] arg1)
  {
    AppMethodBeat.i(150909);
    for (;;)
    {
      try
      {
        ??? = new String(???, "UTF-8");
        ae.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(???)));
        this.inD = null;
        this.inC = new a(this.dBu, this.dzE, this.dBv, this.dBw, this.dBx, this.dBy, this.inE, this.scene, ???);
        g.ajQ().gDv.a(this.inC, 0);
        this.timerHandler.ay(60000L, 60000L);
      }
      catch (Exception ???)
      {
        ae.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", ???, "", new Object[0]);
        ae.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + ???.toString());
        continue;
      }
      synchronized (this.lock)
      {
        this.lock.wait();
        ae.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[] { Boolean.valueOf(bu.cF(this.inD)) });
        ??? = this.inD;
        AppMethodBeat.o(150909);
        return ???;
      }
    }
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.n paramn)
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 75	com/tencent/mm/bf/c:timerHandler	Lcom/tencent/mm/sdk/platformtools/aw;
    //   9: invokevirtual 130	com/tencent/mm/sdk/platformtools/aw:stopTimer	()V
    //   12: iload_1
    //   13: ifne +140 -> 153
    //   16: iload_2
    //   17: ifne +136 -> 153
    //   20: aload 4
    //   22: instanceof 176
    //   25: ifeq +108 -> 133
    //   28: aload 4
    //   30: checkcast 176	com/tencent/mm/bf/a
    //   33: getfield 238	com/tencent/mm/bf/a:ind	Ljava/lang/String;
    //   36: ldc 209
    //   38: invokestatic 242	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: ldc 143
    //   44: ldc 244
    //   46: aload_3
    //   47: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 174	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_3
    //   58: ldc 159
    //   60: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   63: putfield 123	com/tencent/mm/bf/c:inD	[B
    //   66: aload_0
    //   67: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   70: astore_3
    //   71: aload_3
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   77: invokevirtual 136	java/lang/Object:notifyAll	()V
    //   80: aload_3
    //   81: monitorexit
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 114	com/tencent/mm/bf/c:inC	Lcom/tencent/mm/bf/a;
    //   87: ldc 235
    //   89: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore_3
    //   94: ldc 143
    //   96: aload_3
    //   97: ldc 209
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 213	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: ldc 143
    //   108: new 215	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 250
    //   114: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   121: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 232	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -64 -> 66
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 123	com/tencent/mm/bf/c:inD	[B
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
    //   179: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 123	com/tencent/mm/bf/c:inD	[B
    //   187: aload_0
    //   188: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   191: astore_3
    //   192: aload_3
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   198: invokevirtual 136	java/lang/Object:notifyAll	()V
    //   201: aload_3
    //   202: monitorexit
    //   203: invokestatic 265	com/tencent/mm/bf/b:aKy	()Lcom/tencent/mm/bf/b;
    //   206: invokevirtual 268	com/tencent/mm/bf/b:aKA	()V
    //   209: getstatic 274	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   212: ldc2_w 275
    //   215: ldc2_w 277
    //   218: lconst_1
    //   219: iconst_0
    //   220: invokevirtual 282	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
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
    //   0	238	4	paramn	com.tencent.mm.ak.n
    // Exception table:
    //   from	to	target	type
    //   56	66	93	java/lang/Exception
    //   73	82	141	finally
    //   143	145	141	finally
    //   194	203	226	finally
    //   228	230	226	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bf.c
 * JD-Core Version:    0.7.0.1
 */