package com.tencent.matrix.strategy;

import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends q
  implements m
{
  private static boolean isRunning = false;
  private static Object lock = new Object();
  private i callback;
  private boy deA;
  private a deB;
  private d rr;
  
  public c(byte[] paramArrayOfByte, final a parama)
  {
    this.deB = parama;
    setIsRunning(true);
    ah localah = new ah();
    this.deA = new boy();
    try
    {
      localah.parseFrom(paramArrayOfByte);
      this.deA.TaN = localah;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("Matrix.NetSceneGetMatrixStrategy", "parse data error");
      h.aHH();
      h.aHJ().postToWorker(new Runnable()
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
  
  public final int doScene(g paramg, i parami)
  {
    int j = -1;
    this.callback = parami;
    int i;
    if ((paramg != null) && (paramg.biw() != null) && (paramg.biw().biq()))
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
      Log.w("Matrix.NetSceneGetMatrixStrategy", "get mrs strategy must go after login");
      i = j;
    }
    label58:
    do
    {
      return i;
      i = 0;
      break;
      parami = new d.a();
      parami.lBX = false;
      parami.lBU = this.deA;
      parami.lBV = new boz();
      parami.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
      parami.funcId = getType();
      this.rr = parami.bgN();
      j = dispatch(paramg, this.rr, this);
      i = j;
    } while (j >= 0);
    Log.i("Matrix.NetSceneGetMatrixStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    try
    {
      this.deB.onStrategyResp(3, -1, null);
      setIsRunning(false);
      return j;
    }
    catch (Exception paramg)
    {
      Log.e("Matrix.NetSceneGetMatrixStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), Util.stackTraceToString(paramg) });
    }
    return j;
  }
  
  public final int getType()
  {
    return 914;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 186	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   3: getfield 192	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   6: ifnull +15 -> 21
    //   9: invokestatic 186	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   12: getfield 192	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   15: getfield 198	com/tencent/mm/an/t:lCD	Lcom/tencent/mm/network/g;
    //   18: ifnonnull +29 -> 47
    //   21: ldc 63
    //   23: ldc 200
    //   25: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 95	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/an/i;
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
    //   78: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 41	com/tencent/matrix/strategy/c:deB	Lcom/tencent/matrix/strategy/c$a;
    //   85: iload_2
    //   86: iload_3
    //   87: aconst_null
    //   88: invokeinterface 167 4 0
    //   93: aload_0
    //   94: getfield 95	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/an/i;
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
    //   116: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 147	com/tencent/matrix/strategy/c:rr	Lcom/tencent/mm/an/d;
    //   123: getfield 240	com/tencent/mm/an/d:lBS	Lcom/tencent/mm/an/d$c;
    //   126: invokestatic 246	com/tencent/mm/an/d$c:b	(Lcom/tencent/mm/an/d$c;)Lcom/tencent/mm/cd/a;
    //   129: checkcast 123	com/tencent/mm/protocal/protobuf/boz
    //   132: astore 5
    //   134: aload_0
    //   135: getfield 41	com/tencent/matrix/strategy/c:deB	Lcom/tencent/matrix/strategy/c$a;
    //   138: iconst_0
    //   139: iconst_0
    //   140: aload 5
    //   142: getfield 250	com/tencent/mm/protocal/protobuf/boz:TaO	Lcom/tencent/mm/protocal/protobuf/ai;
    //   145: invokevirtual 256	com/tencent/mm/protocal/protobuf/ai:toByteArray	()[B
    //   148: invokeinterface 167 4 0
    //   153: aload_0
    //   154: getfield 95	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/an/i;
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
    //   176: ldc_w 258
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
    //   197: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	216	5	params	com.tencent.mm.network.s
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.strategy.c
 * JD-Core Version:    0.7.0.1
 */