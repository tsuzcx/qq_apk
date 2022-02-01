package com.tencent.matrix.strategy;

import com.tencent.mm.am.p;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends p
  implements m
{
  private static boolean Uz = false;
  private static Object lock = new Object();
  private com.tencent.mm.am.h callback;
  private cdl fdk;
  private a fdl;
  private com.tencent.mm.am.c rr;
  
  public c(byte[] paramArrayOfByte, final a parama)
  {
    this.fdl = parama;
    dL(true);
    aj localaj = new aj();
    this.fdk = new cdl();
    try
    {
      localaj.parseFrom(paramArrayOfByte);
      this.fdk.aanP = localaj;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("Matrix.NetSceneGetMatrixStrategy", "parse data error");
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          parama.onStrategyResp(3, -1, null);
        }
      });
    }
  }
  
  private static void dL(boolean paramBoolean)
  {
    synchronized (lock)
    {
      Uz = paramBoolean;
      return;
    }
  }
  
  public static boolean isRunning()
  {
    synchronized (lock)
    {
      boolean bool = Uz;
      return bool;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    int j = -1;
    this.callback = paramh;
    int i;
    if ((paramg != null) && (paramg.bGg() != null) && (paramg.bGg().bGa()))
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
      paramh = new com.tencent.mm.am.c.a();
      paramh.otH = false;
      paramh.otE = this.fdk;
      paramh.otF = new cdm();
      paramh.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
      paramh.funcId = getType();
      this.rr = paramh.bEF();
      j = dispatch(paramg, this.rr, this);
      i = j;
    } while (j >= 0);
    Log.i("Matrix.NetSceneGetMatrixStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    try
    {
      this.fdl.onStrategyResp(3, -1, null);
      dL(false);
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
    //   0: invokestatic 187	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   3: getfield 193	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   6: ifnull +15 -> 21
    //   9: invokestatic 187	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   12: getfield 193	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   15: getfield 199	com/tencent/mm/am/s:oun	Lcom/tencent/mm/network/g;
    //   18: ifnonnull +29 -> 47
    //   21: ldc 63
    //   23: ldc 201
    //   25: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 96	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/am/h;
    //   32: iload_2
    //   33: iload_3
    //   34: aload 4
    //   36: aload_0
    //   37: invokeinterface 210 5 0
    //   42: iconst_0
    //   43: invokestatic 45	com/tencent/matrix/strategy/c:dL	(Z)V
    //   46: return
    //   47: iload_2
    //   48: ifeq +64 -> 112
    //   51: ldc 63
    //   53: new 212	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 214
    //   59: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: iload_2
    //   63: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc 223
    //   68: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_3
    //   72: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 41	com/tencent/matrix/strategy/c:fdl	Lcom/tencent/matrix/strategy/c$a;
    //   85: iload_2
    //   86: iload_3
    //   87: aconst_null
    //   88: invokeinterface 168 4 0
    //   93: aload_0
    //   94: getfield 96	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/am/h;
    //   97: iload_2
    //   98: iload_3
    //   99: aload 4
    //   101: aload_0
    //   102: invokeinterface 210 5 0
    //   107: iconst_0
    //   108: invokestatic 45	com/tencent/matrix/strategy/c:dL	(Z)V
    //   111: return
    //   112: ldc 63
    //   114: ldc 232
    //   116: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: getfield 148	com/tencent/matrix/strategy/c:rr	Lcom/tencent/mm/am/c;
    //   123: getfield 241	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
    //   126: invokestatic 247	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
    //   129: checkcast 124	com/tencent/mm/protocal/protobuf/cdm
    //   132: astore 5
    //   134: aload_0
    //   135: getfield 41	com/tencent/matrix/strategy/c:fdl	Lcom/tencent/matrix/strategy/c$a;
    //   138: iconst_0
    //   139: iconst_0
    //   140: aload 5
    //   142: getfield 251	com/tencent/mm/protocal/protobuf/cdm:aanQ	Lcom/tencent/mm/protocal/protobuf/ak;
    //   145: invokevirtual 257	com/tencent/mm/protocal/protobuf/ak:toByteArray	()[B
    //   148: invokeinterface 168 4 0
    //   153: aload_0
    //   154: getfield 96	com/tencent/matrix/strategy/c:callback	Lcom/tencent/mm/am/h;
    //   157: iload_2
    //   158: iload_3
    //   159: aload 4
    //   161: aload_0
    //   162: invokeinterface 210 5 0
    //   167: iconst_0
    //   168: invokestatic 45	com/tencent/matrix/strategy/c:dL	(Z)V
    //   171: return
    //   172: astore 5
    //   174: ldc 63
    //   176: ldc_w 259
    //   179: iconst_2
    //   180: anewarray 29	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: invokevirtual 173	java/lang/Object:hashCode	()I
    //   189: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload 5
    //   197: invokestatic 179	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -51 -> 153
    //   207: astore 4
    //   209: iconst_0
    //   210: invokestatic 45	com/tencent/matrix/strategy/c:dL	(Z)V
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