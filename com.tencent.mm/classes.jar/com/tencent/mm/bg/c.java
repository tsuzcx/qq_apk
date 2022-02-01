package com.tencent.mm.bg;

import android.os.HandlerThread;
import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements INetworkApi, com.tencent.mm.al.g
{
  private float dpb;
  private float dqQ;
  private int dqR;
  private int dqS;
  private String dqT;
  private String dqU;
  private a hqT;
  private byte[] hqU;
  private int hqV;
  private Object lock;
  private int scene;
  private av timerHandler;
  
  public c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150905);
    this.lock = new Object();
    com.tencent.mm.kernel.g.afC();
    this.timerHandler = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150904);
        ad.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
        if (c.a(c.this) != null) {
          com.tencent.mm.kernel.g.afA().gcy.a(c.a(c.this));
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
    this.dqQ = paramFloat1;
    this.dpb = paramFloat2;
    this.dqR = paramInt1;
    this.dqS = paramInt2;
    this.dqT = paramString1;
    this.dqU = paramString2;
    this.hqV = paramInt3;
    this.scene = paramInt4;
    com.tencent.mm.kernel.g.afA().gcy.a(752, this);
    AppMethodBeat.o(150905);
  }
  
  private void aAo()
  {
    AppMethodBeat.i(150907);
    com.tencent.mm.kernel.g.afA().gcy.b(752, this);
    AppMethodBeat.o(150907);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(150906);
    this.timerHandler.stopTimer();
    if (this.hqT != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(this.hqT);
    }
    this.hqT = null;
    this.hqU = null;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      aAo();
      AppMethodBeat.o(150906);
      return;
    }
  }
  
  public final byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150908);
    ad.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
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
        ad.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(???)));
        this.hqU = null;
        this.hqT = new a(this.dqQ, this.dpb, this.dqR, this.dqS, this.dqT, this.dqU, this.hqV, this.scene, ???);
        com.tencent.mm.kernel.g.afA().gcy.a(this.hqT, 0);
        this.timerHandler.av(60000L, 60000L);
      }
      catch (Exception ???)
      {
        ad.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", ???, "", new Object[0]);
        ad.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + ???.toString());
        continue;
      }
      synchronized (this.lock)
      {
        this.lock.wait();
        ad.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[] { Boolean.valueOf(bt.cw(this.hqU)) });
        ??? = this.hqU;
        AppMethodBeat.o(150909);
        return ???;
      }
    }
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.al.n paramn)
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 75	com/tencent/mm/bg/c:timerHandler	Lcom/tencent/mm/sdk/platformtools/av;
    //   9: invokevirtual 130	com/tencent/mm/sdk/platformtools/av:stopTimer	()V
    //   12: iload_1
    //   13: ifne +140 -> 153
    //   16: iload_2
    //   17: ifne +136 -> 153
    //   20: aload 4
    //   22: instanceof 176
    //   25: ifeq +108 -> 133
    //   28: aload 4
    //   30: checkcast 176	com/tencent/mm/bg/a
    //   33: getfield 238	com/tencent/mm/bg/a:hqu	Ljava/lang/String;
    //   36: ldc 209
    //   38: invokestatic 242	com/tencent/mm/sdk/platformtools/bt:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: ldc 143
    //   44: ldc 244
    //   46: aload_3
    //   47: invokestatic 168	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_3
    //   58: ldc 159
    //   60: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   63: putfield 123	com/tencent/mm/bg/c:hqU	[B
    //   66: aload_0
    //   67: getfield 43	com/tencent/mm/bg/c:lock	Ljava/lang/Object;
    //   70: astore_3
    //   71: aload_3
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 43	com/tencent/mm/bg/c:lock	Ljava/lang/Object;
    //   77: invokevirtual 136	java/lang/Object:notifyAll	()V
    //   80: aload_3
    //   81: monitorexit
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 114	com/tencent/mm/bg/c:hqT	Lcom/tencent/mm/bg/a;
    //   87: ldc 235
    //   89: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore_3
    //   94: ldc 143
    //   96: aload_3
    //   97: ldc 209
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: ldc 143
    //   108: new 215	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 250
    //   114: invokespecial 220	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: invokevirtual 224	java/lang/Exception:toString	()Ljava/lang/String;
    //   121: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -64 -> 66
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 123	com/tencent/mm/bg/c:hqU	[B
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
    //   179: invokestatic 259	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 123	com/tencent/mm/bg/c:hqU	[B
    //   187: aload_0
    //   188: getfield 43	com/tencent/mm/bg/c:lock	Ljava/lang/Object;
    //   191: astore_3
    //   192: aload_3
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 43	com/tencent/mm/bg/c:lock	Ljava/lang/Object;
    //   198: invokevirtual 136	java/lang/Object:notifyAll	()V
    //   201: aload_3
    //   202: monitorexit
    //   203: invokestatic 265	com/tencent/mm/bg/b:aAe	()Lcom/tencent/mm/bg/b;
    //   206: invokevirtual 268	com/tencent/mm/bg/b:aAg	()V
    //   209: getstatic 274	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
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
    //   0	238	4	paramn	com.tencent.mm.al.n
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
 * Qualified Name:     com.tencent.mm.bg.c
 * JD-Core Version:    0.7.0.1
 */