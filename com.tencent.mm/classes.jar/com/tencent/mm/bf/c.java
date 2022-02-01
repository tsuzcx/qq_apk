package com.tencent.mm.bf;

import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  implements INetworkApi, i
{
  private float dTj;
  private int dTk;
  private int dTl;
  private String dTm;
  private String dTn;
  private a jiK;
  private byte[] jiL;
  private int jiM;
  private float latitude;
  private Object lock;
  private int scene;
  private MTimerHandler timerHandler;
  
  public c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(150905);
    this.lock = new Object();
    g.aAi();
    this.timerHandler = new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150904);
        Log.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
        if (c.a(c.this) != null) {
          g.aAg().hqi.a(c.a(c.this));
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
    this.dTj = paramFloat1;
    this.latitude = paramFloat2;
    this.dTk = paramInt1;
    this.dTl = paramInt2;
    this.dTm = paramString1;
    this.dTn = paramString2;
    this.jiM = paramInt3;
    this.scene = paramInt4;
    g.aAg().hqi.a(752, this);
    AppMethodBeat.o(150905);
  }
  
  private void unRegister()
  {
    AppMethodBeat.i(150907);
    g.aAg().hqi.b(752, this);
    AppMethodBeat.o(150907);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(150906);
    this.timerHandler.stopTimer();
    if (this.jiK != null) {
      g.aAg().hqi.a(this.jiK);
    }
    this.jiK = null;
    this.jiL = null;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      unRegister();
      AppMethodBeat.o(150906);
      return;
    }
  }
  
  public final byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150908);
    Log.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
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
        Log.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : ".concat(String.valueOf(???)));
        this.jiL = null;
        this.jiK = new a(this.dTj, this.latitude, this.dTk, this.dTl, this.dTm, this.dTn, this.jiM, this.scene, ???);
        g.aAg().hqi.a(this.jiK, 0);
        this.timerHandler.startTimer(60000L);
      }
      catch (Exception ???)
      {
        Log.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", ???, "", new Object[0]);
        Log.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + ???.toString());
        continue;
      }
      synchronized (this.lock)
      {
        this.lock.wait();
        Log.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[] { Boolean.valueOf(Util.isNullOrNil(this.jiL)) });
        ??? = this.jiL;
        AppMethodBeat.o(150909);
        return ???;
      }
    }
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ak.q paramq)
  {
    // Byte code:
    //   0: ldc 229
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 69	com/tencent/mm/bf/c:timerHandler	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   9: invokevirtual 124	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   12: iload_1
    //   13: ifne +140 -> 153
    //   16: iload_2
    //   17: ifne +136 -> 153
    //   20: aload 4
    //   22: instanceof 170
    //   25: ifeq +108 -> 133
    //   28: aload 4
    //   30: checkcast 170	com/tencent/mm/bf/a
    //   33: getfield 232	com/tencent/mm/bf/a:jil	Ljava/lang/String;
    //   36: ldc 203
    //   38: invokestatic 236	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: astore_3
    //   42: ldc 137
    //   44: ldc 238
    //   46: aload_3
    //   47: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_3
    //   58: ldc 153
    //   60: invokevirtual 242	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   63: putfield 113	com/tencent/mm/bf/c:jiL	[B
    //   66: aload_0
    //   67: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   70: astore_3
    //   71: aload_3
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   77: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   80: aload_3
    //   81: monitorexit
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 108	com/tencent/mm/bf/c:jiK	Lcom/tencent/mm/bf/a;
    //   87: ldc 229
    //   89: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore_3
    //   94: ldc 137
    //   96: aload_3
    //   97: ldc 203
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: ldc 137
    //   108: new 209	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 244
    //   114: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   121: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -64 -> 66
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 113	com/tencent/mm/bf/c:jiL	[B
    //   138: goto -72 -> 66
    //   141: astore 4
    //   143: aload_3
    //   144: monitorexit
    //   145: ldc 229
    //   147: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 4
    //   152: athrow
    //   153: ldc 137
    //   155: ldc 246
    //   157: iconst_3
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: iload_1
    //   164: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: iload_2
    //   171: invokestatic 251	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_2
    //   177: aload_3
    //   178: aastore
    //   179: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: aconst_null
    //   184: putfield 113	com/tencent/mm/bf/c:jiL	[B
    //   187: aload_0
    //   188: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   191: astore_3
    //   192: aload_3
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 43	com/tencent/mm/bf/c:lock	Ljava/lang/Object;
    //   198: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   201: aload_3
    //   202: monitorexit
    //   203: invokestatic 259	com/tencent/mm/bf/b:beB	()Lcom/tencent/mm/bf/b;
    //   206: invokevirtual 262	com/tencent/mm/bf/b:beD	()V
    //   209: getstatic 268	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   212: ldc2_w 269
    //   215: ldc2_w 271
    //   218: lconst_1
    //   219: iconst_0
    //   220: invokevirtual 276	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   223: goto -141 -> 82
    //   226: astore 4
    //   228: aload_3
    //   229: monitorexit
    //   230: ldc 229
    //   232: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload 4
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	c
    //   0	238	1	paramInt1	int
    //   0	238	2	paramInt2	int
    //   0	238	4	paramq	com.tencent.mm.ak.q
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