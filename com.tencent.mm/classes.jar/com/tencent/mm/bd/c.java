package com.tencent.mm.bd;

import android.os.HandlerThread;
import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements INetworkApi, f
{
  private float bRt;
  private float bTc;
  private int bTd;
  private int bTe;
  private String bTf;
  private String bTg;
  private a eyj;
  private byte[] eyk;
  private am eyl;
  private int eym;
  private Object lock = new Object();
  private int scene;
  
  public c(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    g.DQ();
    this.eyl = new am(g.DS().mnU.getLooper(), new c.1(this), false);
    this.bTc = paramFloat1;
    this.bRt = paramFloat2;
    this.bTd = paramInt1;
    this.bTe = paramInt2;
    this.bTf = paramString1;
    this.bTg = paramString2;
    this.eym = paramInt3;
    this.scene = paramInt4;
    g.DO().dJT.a(752, this);
  }
  
  public final void finish()
  {
    this.eyl.stopTimer();
    if (this.eyj != null) {
      g.DO().dJT.c(this.eyj);
    }
    this.eyj = null;
    this.eyk = null;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      g.DO().dJT.b(752, this);
      return;
    }
  }
  
  public final byte[] httpRequest(String paramString, byte[] paramArrayOfByte)
  {
    y.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
    return new byte[0];
  }
  
  public final byte[] httpRequest(byte[] arg1)
  {
    for (;;)
    {
      try
      {
        ??? = new String(???, "UTF-8");
        y.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : " + ???);
        this.eyk = null;
        this.eyj = new a(this.bTc, this.bRt, this.bTd, this.bTe, this.bTf, this.bTg, this.eym, this.scene, ???);
        g.DO().dJT.a(this.eyj, 0);
        this.eyl.S(60000L, 60000L);
      }
      catch (Exception ???)
      {
        y.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", ???, "", new Object[0]);
        y.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + ???.toString());
        continue;
      }
      synchronized (this.lock)
      {
        this.lock.wait();
        y.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[] { Boolean.valueOf(bk.bE(this.eyk)) });
        return this.eyk;
      }
    }
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String arg3, com.tencent.mm.ah.m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/tencent/mm/bd/c:eyl	Lcom/tencent/mm/sdk/platformtools/am;
    //   4: invokevirtual 115	com/tencent/mm/sdk/platformtools/am:stopTimer	()V
    //   7: iload_1
    //   8: ifne +137 -> 145
    //   11: iload_2
    //   12: ifne +133 -> 145
    //   15: aload 4
    //   17: instanceof 164
    //   20: ifeq +110 -> 130
    //   23: aload 4
    //   25: checkcast 164	com/tencent/mm/bd/a
    //   28: getfield 214	com/tencent/mm/bd/a:exJ	Ljava/lang/String;
    //   31: ldc 199
    //   33: invokestatic 218	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_3
    //   37: ldc 127
    //   39: new 147	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 220
    //   45: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_3
    //   49: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 162	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: aload_3
    //   60: ldc 142
    //   62: invokevirtual 224	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   65: putfield 109	com/tencent/mm/bd/c:eyk	[B
    //   68: aload_0
    //   69: getfield 34	com/tencent/mm/bd/c:lock	Ljava/lang/Object;
    //   72: astore_3
    //   73: aload_3
    //   74: monitorenter
    //   75: aload_0
    //   76: getfield 34	com/tencent/mm/bd/c:lock	Ljava/lang/Object;
    //   79: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   82: aload_3
    //   83: monitorexit
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 104	com/tencent/mm/bd/c:eyj	Lcom/tencent/mm/bd/a;
    //   89: return
    //   90: astore_3
    //   91: ldc 127
    //   93: aload_3
    //   94: ldc 199
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 203	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: ldc 127
    //   105: new 147	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 226
    //   111: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_3
    //   115: invokevirtual 206	java/lang/Exception:toString	()Ljava/lang/String;
    //   118: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 209	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: goto -59 -> 68
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 109	com/tencent/mm/bd/c:eyk	[B
    //   135: goto -67 -> 68
    //   138: astore 4
    //   140: aload_3
    //   141: monitorexit
    //   142: aload 4
    //   144: athrow
    //   145: ldc 127
    //   147: ldc 228
    //   149: iconst_3
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: iload_1
    //   156: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: iload_2
    //   163: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: aload_3
    //   170: aastore
    //   171: invokestatic 235	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 109	com/tencent/mm/bd/c:eyk	[B
    //   179: aload_0
    //   180: getfield 34	com/tencent/mm/bd/c:lock	Ljava/lang/Object;
    //   183: astore_3
    //   184: aload_3
    //   185: monitorenter
    //   186: aload_0
    //   187: getfield 34	com/tencent/mm/bd/c:lock	Ljava/lang/Object;
    //   190: invokevirtual 121	java/lang/Object:notifyAll	()V
    //   193: aload_3
    //   194: monitorexit
    //   195: invokestatic 241	com/tencent/mm/bd/b:PQ	()Lcom/tencent/mm/bd/b;
    //   198: invokevirtual 244	com/tencent/mm/bd/b:PS	()V
    //   201: getstatic 250	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   204: ldc2_w 251
    //   207: ldc2_w 253
    //   210: lconst_1
    //   211: iconst_0
    //   212: invokevirtual 257	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   215: goto -131 -> 84
    //   218: astore 4
    //   220: aload_3
    //   221: monitorexit
    //   222: aload 4
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	c
    //   0	225	1	paramInt1	int
    //   0	225	2	paramInt2	int
    //   0	225	4	paramm	com.tencent.mm.ah.m
    // Exception table:
    //   from	to	target	type
    //   58	68	90	java/lang/Exception
    //   75	84	138	finally
    //   140	142	138	finally
    //   186	195	218	finally
    //   220	222	218	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bd.c
 * JD-Core Version:    0.7.0.1
 */