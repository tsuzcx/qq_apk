package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class k
  implements be
{
  private d oBn;
  private g oBo;
  private FakePluginCdn oBp;
  private com.tencent.mm.am.e oBq;
  private long oBr;
  private MMHandler oBs;
  private com.tencent.mm.am.h oBt;
  
  public k()
  {
    AppMethodBeat.i(150435);
    this.oBn = null;
    this.oBo = null;
    this.oBp = null;
    this.oBr = 0L;
    this.oBs = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(150433);
        if (paramAnonymousMessage.what != 1)
        {
          AppMethodBeat.o(150433);
          return;
        }
        if (k.a(k.this) == 0L)
        {
          AppMethodBeat.o(150433);
          return;
        }
        int i = paramAnonymousMessage.arg1;
        Log.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(k.a(k.this)), Long.valueOf(Util.milliSecondsToNow(k.a(k.this))) });
        com.tencent.mm.kernel.h.aZW().a(new i(i), 0);
        AppMethodBeat.o(150433);
      }
    };
    this.oBt = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(150434);
        if (!(paramAnonymousp instanceof i))
        {
          Log.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
          AppMethodBeat.o(150434);
          return;
        }
        Log.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(k.a(k.this)) });
        if ("doScene failed".equals(paramAnonymousString))
        {
          Log.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(150434);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, paramAnonymousInt1 + 10, 1L, true);
        if (paramAnonymousInt1 == 0)
        {
          if (k.a(k.this) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, 52L, 1L, true);
            k.a(k.this, 0L);
          }
          AppMethodBeat.o(150434);
          return;
        }
        if (paramAnonymousInt1 != 4)
        {
          if (k.a(k.this) == 0L)
          {
            paramAnonymousInt1 = ((i)paramAnonymousp).scene;
            k.a(k.this, Util.nowMilliSecond());
            k.b(k.this).removeMessages(1);
            k.b(k.this).sendMessageDelayed(k.b(k.this).obtainMessage(1, paramAnonymousInt1, 0), 30000L);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, 50L, 1L, true);
            AppMethodBeat.o(150434);
            return;
          }
          k.a(k.this, 0L);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(546L, 51L, 1L, true);
          AppMethodBeat.o(150434);
          return;
        }
        AppMethodBeat.o(150434);
      }
    };
    AppMethodBeat.o(150435);
  }
  
  public static k bHT()
  {
    try
    {
      AppMethodBeat.i(150436);
      k localk = (k)y.aL(k.class);
      AppMethodBeat.o(150436);
      return localk;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bHU()
  {
    AppMethodBeat.i(150437);
    com.tencent.mm.kernel.h.baC().aZJ();
    String str = com.tencent.mm.kernel.h.baE().cachePath + "cdndnsinfo/";
    AppMethodBeat.o(150437);
    return str;
  }
  
  public static com.tencent.mm.am.e bHV()
  {
    AppMethodBeat.i(150438);
    com.tencent.mm.am.e locale = bHT().oBq;
    AppMethodBeat.o(150438);
    return locale;
  }
  
  public static g bHW()
  {
    AppMethodBeat.i(150440);
    if (bHT().oBo == null) {}
    try
    {
      if (bHT().oBo == null) {
        bHT().oBo = new g();
      }
      g localg = bHT().oBo;
      AppMethodBeat.o(150440);
      return localg;
    }
    finally
    {
      AppMethodBeat.o(150440);
    }
  }
  
  /* Error */
  public static d bHX()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 133
    //   5: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 122	com/tencent/mm/modelcdntran/k:bHT	()Lcom/tencent/mm/modelcdntran/k;
    //   11: getfield 41	com/tencent/mm/modelcdntran/k:oBn	Lcom/tencent/mm/modelcdntran/d;
    //   14: ifnonnull +35 -> 49
    //   17: invokestatic 90	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
    //   20: pop
    //   21: invokestatic 137	com/tencent/mm/kernel/b:aZM	()Z
    //   24: ifeq +42 -> 66
    //   27: invokestatic 122	com/tencent/mm/modelcdntran/k:bHT	()Lcom/tencent/mm/modelcdntran/k;
    //   30: new 139	com/tencent/mm/modelcdntran/d
    //   33: dup
    //   34: invokestatic 102	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   37: getfield 108	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
    //   40: invokestatic 141	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   43: invokespecial 144	com/tencent/mm/modelcdntran/d:<init>	(Ljava/lang/String;Lcom/tencent/mm/g/b$a;)V
    //   46: putfield 41	com/tencent/mm/modelcdntran/k:oBn	Lcom/tencent/mm/modelcdntran/d;
    //   49: invokestatic 122	com/tencent/mm/modelcdntran/k:bHT	()Lcom/tencent/mm/modelcdntran/k;
    //   52: getfield 41	com/tencent/mm/modelcdntran/k:oBn	Lcom/tencent/mm/modelcdntran/d;
    //   55: astore_0
    //   56: ldc 133
    //   58: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: new 97	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 146
    //   72: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: new 151	java/util/Random
    //   78: dup
    //   79: invokespecial 152	java/util/Random:<init>	()V
    //   82: invokevirtual 156	java/util/Random:nextLong	()J
    //   85: invokevirtual 159	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 165	java/lang/String:getBytes	()[B
    //   94: invokestatic 171	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   97: astore_0
    //   98: new 97	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 176	com/tencent/mm/storage/at:acHq	Ljava/lang/String;
    //   108: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 178
    //   117: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 180
    //   126: ldc 182
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: aastore
    //   136: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: invokestatic 122	com/tencent/mm/modelcdntran/k:bHT	()Lcom/tencent/mm/modelcdntran/k;
    //   142: new 139	com/tencent/mm/modelcdntran/d
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 141	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   150: invokespecial 144	com/tencent/mm/modelcdntran/d:<init>	(Ljava/lang/String;Lcom/tencent/mm/g/b$a;)V
    //   153: putfield 41	com/tencent/mm/modelcdntran/k:oBn	Lcom/tencent/mm/modelcdntran/d;
    //   156: goto -107 -> 49
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	92	0	localObject1	Object
    //   159	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	49	159	finally
    //   49	61	159	finally
    //   66	156	159	finally
  }
  
  public static a bHY()
  {
    AppMethodBeat.i(237891);
    if (bHT().oBp != null)
    {
      a locala = (a)com.tencent.mm.kernel.mvvm.e.a(bHT().oBp, a.class);
      AppMethodBeat.o(237891);
      return locala;
    }
    AppMethodBeat.o(237891);
    return null;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150439);
    onAccountRelease();
    com.tencent.mm.kernel.h.baC().aZJ();
    if (bHT().oBo == null)
    {
      bHT().oBo = new g();
      Log.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[] { Integer.valueOf(bHT().oBo.hashCode()) });
    }
    if (bHT().oBp == null)
    {
      bHT().oBp = new FakePluginCdn();
      localObject = new f.c();
      ((f.c)localObject).mDg = paramBoolean;
      bHT().oBp.onAccountInitialized((f.c)localObject);
    }
    Object localObject = new u(bHU());
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    this.oBq = new com.tencent.mm.am.e()
    {
      public final void a(uu paramAnonymousuu1, uu paramAnonymousuu2, uu paramAnonymousuu3)
      {
        AppMethodBeat.i(150432);
        Log.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramAnonymousuu1.toString() + " getCore().engine:" + k.bHX());
        if (k.bHX() != null)
        {
          k.bHX().a(paramAnonymousuu1, paramAnonymousuu2, paramAnonymousuu3, null, null, null);
          com.tencent.threadpool.h.ahAA.g(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(150430);
              if (k.bHW() != null) {
                k.bHW().hf(false);
              }
              AppMethodBeat.o(150430);
            }
            
            public final String toString()
            {
              AppMethodBeat.i(150431);
              String str = super.toString() + "|infoUpdate";
              AppMethodBeat.o(150431);
              return str;
            }
          }, "MicroMsg.Cdn.ThreadName");
        }
        AppMethodBeat.o(150432);
      }
    };
    com.tencent.mm.kernel.h.aZW().a(379, this.oBt);
    Log.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
    vX(1);
    AppMethodBeat.o(150439);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150442);
    this.oBq = null;
    Object localObject;
    if (this.oBn != null)
    {
      localObject = this.oBn;
      CdnLogic.UnInitialize();
      ((d)localObject).ozG = null;
      ((d)localObject).ozH = null;
      ((d)localObject).ozy = null;
      this.oBn = null;
    }
    if (this.oBo != null)
    {
      localObject = this.oBo;
      if (((g)localObject).oAn != null) {
        ((g)localObject).oAn.clear();
      }
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        com.tencent.mm.kernel.h.baE().ban().remove((MStorageEx.IOnStorageChange)localObject);
      }
      ((g)localObject).oAi.removeCallbacksAndMessages(null);
      com.tencent.mm.kernel.h.baD().b(((g)localObject).oAk);
      com.tencent.mm.kernel.h.baD().mCm.b(379, (com.tencent.mm.am.h)localObject);
      ((g)localObject).oAj.dead();
      ((g)localObject).appForegroundListener.dead();
      ((g)localObject).oAm.stopTimer();
      this.oBo = null;
    }
    if (this.oBp != null)
    {
      this.oBp.onAccountRelease();
      this.oBp = null;
    }
    this.oBr = 0L;
    this.oBs.removeCallbacksAndMessages(null);
    com.tencent.mm.kernel.h.aZW().b(379, this.oBt);
    AppMethodBeat.o(150442);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final void vX(int paramInt)
  {
    AppMethodBeat.i(150443);
    this.oBr = 0L;
    this.oBs.removeMessages(1);
    com.tencent.mm.kernel.h.aZW().a(new i(paramInt), 0);
    AppMethodBeat.o(150443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.k
 * JD-Core Version:    0.7.0.1
 */