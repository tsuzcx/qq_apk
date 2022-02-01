package com.tencent.matrix.strategy;

import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends n
  implements k
{
  private static boolean isRunning = false;
  private static Object lock = new Object();
  private avn cJa;
  private a cJb;
  private f callback;
  private b rr;
  
  public c(byte[] paramArrayOfByte, final a parama)
  {
    this.cJb = parama;
    setIsRunning(true);
    ah localah = new ah();
    this.cJa = new avn();
    try
    {
      localah.parseFrom(paramArrayOfByte);
      this.cJa.Gux = localah;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("Matrix.NetSceneGetMatrixStrategy", "parse data error");
      g.ajD();
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          parama.onStrategyResp(3, -1, null);
        }
      });
    }
  }
  
  public static boolean isRunning()
  {
    synchronized (lock)
    {
      boolean bool = isRunning;
      return bool;
    }
  }
  
  private static void setIsRunning(boolean paramBoolean)
  {
    synchronized (lock)
    {
      isRunning = paramBoolean;
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    int j = -1;
    this.callback = paramf;
    int i;
    if ((parame != null) && (parame.aFc() != null) && (parame.aFc().aEW()))
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
      ad.w("Matrix.NetSceneGetMatrixStrategy", "get mrs strategy must go after login");
      i = j;
    }
    label58:
    do
    {
      return i;
      i = 0;
      break;
      paramf = new b.a();
      paramf.hNP = false;
      paramf.hNM = this.cJa;
      paramf.hNN = new avo();
      paramf.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
      paramf.funcId = getType();
      this.rr = paramf.aDC();
      j = dispatch(parame, this.rr, this);
      i = j;
    } while (j >= 0);
    ad.i("Matrix.NetSceneGetMatrixStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    try
    {
      this.cJb.onStrategyResp(3, -1, null);
      setIsRunning(false);
      return j;
    }
    catch (Exception parame)
    {
      ad.e("Matrix.NetSceneGetMatrixStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bt.n(parame) });
    }
    return j;
  }
  
  public final int getType()
  {
    return 914;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 186	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   3: getfield 192	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   6: ifnull +15 -> 21
    //   9: invokestatic 186	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   12: getfield 192	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   15: getfield 198	com/tencent/mm/al/q:hOv	Lcom/tencent/mm/network/e;
    //   18: ifnonnull +29 -> 47
    //   21: ldc 63
    //   23: ldc 200
    //   25: invokestatic 203	com/tencent/mm/sdk/platformtools/ad:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 95	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/al/f;
    //   32: iload_2
    //   33: iload_3
    //   34: aload 4
    //   36: aload_0
    //   37: invokeinterface 209 5 0
    //   42: iconst_0
    //   43: invokestatic 45	com/tencent/matrix/strategy/c:setIsRunning	(Z)V
    //   46: return
    //   47: iload_2
    //   48: ifeq +64 -> 112
    //   51: ldc 63
    //   53: new 211	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 213
    //   59: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: iload_2
    //   63: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc 222
    //   68: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_3
    //   72: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 71	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 41	com/tencent/matrix/strategy/c:cJb	Lcom/tencent/matrix/strategy/c$a;
    //   85: iload_2
    //   86: iload_3
    //   87: aconst_null
    //   88: invokeinterface 167 4 0
    //   93: aload_0
    //   94: getfield 95	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/al/f;
    //   97: iload_2
    //   98: iload_3
    //   99: aload 4
    //   101: aload_0
    //   102: invokeinterface 209 5 0
    //   107: iconst_0
    //   108: invokestatic 45	com/tencent/matrix/strategy/c:setIsRunning	(Z)V
    //   111: return
    //   112: ldc 63
    //   114: ldc 231
    //   116: invokestatic 234	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 147	com/tencent/matrix/strategy/c:rr	Lcom/tencent/mm/al/b;
    //   123: getfield 240	com/tencent/mm/al/b:hNL	Lcom/tencent/mm/al/b$c;
    //   126: getfield 245	com/tencent/mm/al/b$c:hNQ	Lcom/tencent/mm/bx/a;
    //   129: checkcast 123	com/tencent/mm/protocal/protobuf/avo
    //   132: astore 5
    //   134: aload_0
    //   135: getfield 41	com/tencent/matrix/strategy/c:cJb	Lcom/tencent/matrix/strategy/c$a;
    //   138: iconst_0
    //   139: iconst_0
    //   140: aload 5
    //   142: getfield 249	com/tencent/mm/protocal/protobuf/avo:Guy	Lcom/tencent/mm/protocal/protobuf/ai;
    //   145: invokevirtual 255	com/tencent/mm/protocal/protobuf/ai:toByteArray	()[B
    //   148: invokeinterface 167 4 0
    //   153: aload_0
    //   154: getfield 95	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/al/f;
    //   157: iload_2
    //   158: iload_3
    //   159: aload 4
    //   161: aload_0
    //   162: invokeinterface 209 5 0
    //   167: iconst_0
    //   168: invokestatic 45	com/tencent/matrix/strategy/c:setIsRunning	(Z)V
    //   171: return
    //   172: astore 5
    //   174: ldc 63
    //   176: ldc_w 257
    //   179: iconst_2
    //   180: anewarray 29	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: invokevirtual 172	java/lang/Object:hashCode	()I
    //   189: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload 5
    //   197: invokestatic 178	com/tencent/mm/sdk/platformtools/bt:n	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 180	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -51 -> 153
    //   207: astore 4
    //   209: iconst_0
    //   210: invokestatic 45	com/tencent/matrix/strategy/c:setIsRunning	(Z)V
    //   213: aload 4
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	c
    //   0	216	1	paramInt1	int
    //   0	216	2	paramInt2	int
    //   0	216	3	paramInt3	int
    //   0	216	4	paramString	java.lang.String
    //   0	216	5	paramq	com.tencent.mm.network.q
    //   0	216	6	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	153	172	java/lang/Exception
    //   0	21	207	finally
    //   21	42	207	finally
    //   51	107	207	finally
    //   112	134	207	finally
    //   134	153	207	finally
    //   153	167	207	finally
    //   174	204	207	finally
  }
  
  public static abstract interface a
  {
    public abstract void onStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.strategy.c
 * JD-Core Version:    0.7.0.1
 */