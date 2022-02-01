package com.tencent.mm.aq;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class f
  implements be
{
  private a lIN;
  private b lIO;
  private com.tencent.mm.an.f lIP;
  private long lIQ;
  private MMHandler lIR;
  private com.tencent.mm.an.i lIS;
  
  public f()
  {
    AppMethodBeat.i(150435);
    this.lIN = null;
    this.lIO = null;
    this.lIQ = 0L;
    this.lIR = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(150433);
        if (paramAnonymousMessage.what != 1)
        {
          AppMethodBeat.o(150433);
          return;
        }
        if (f.a(f.this) == 0L)
        {
          AppMethodBeat.o(150433);
          return;
        }
        int i = paramAnonymousMessage.arg1;
        Log.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(f.a(f.this)), Long.valueOf(Util.milliSecondsToNow(f.a(f.this))) });
        com.tencent.mm.kernel.h.aGY().a(new d(i), 0);
        AppMethodBeat.o(150433);
      }
    };
    this.lIS = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(150434);
        if (!(paramAnonymousq instanceof d))
        {
          Log.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
          AppMethodBeat.o(150434);
          return;
        }
        Log.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(f.a(f.this)) });
        if ("doScene failed".equals(paramAnonymousString))
        {
          Log.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(150434);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, paramAnonymousInt1 + 10, 1L, true);
        if (paramAnonymousInt1 == 0)
        {
          if (f.a(f.this) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, 52L, 1L, true);
            f.a(f.this, 0L);
          }
          AppMethodBeat.o(150434);
          return;
        }
        if (paramAnonymousInt1 != 4)
        {
          if (f.a(f.this) == 0L)
          {
            paramAnonymousInt1 = ((d)paramAnonymousq).scene;
            f.a(f.this, Util.nowMilliSecond());
            f.b(f.this).removeMessages(1);
            f.b(f.this).sendMessageDelayed(f.b(f.this).obtainMessage(1, paramAnonymousInt1, 0), 30000L);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, 50L, 1L, true);
            AppMethodBeat.o(150434);
            return;
          }
          f.a(f.this, 0L);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(546L, 51L, 1L, true);
          AppMethodBeat.o(150434);
          return;
        }
        AppMethodBeat.o(150434);
      }
    };
    AppMethodBeat.o(150435);
  }
  
  public static f bkd()
  {
    try
    {
      AppMethodBeat.i(150436);
      f localf = (f)y.as(f.class);
      AppMethodBeat.o(150436);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String bke()
  {
    AppMethodBeat.i(150437);
    com.tencent.mm.kernel.h.aHE().aGH();
    String str = com.tencent.mm.kernel.h.aHG().cachePath + "cdndnsinfo/";
    AppMethodBeat.o(150437);
    return str;
  }
  
  public static com.tencent.mm.an.f bkf()
  {
    AppMethodBeat.i(150438);
    com.tencent.mm.an.f localf = bkd().lIP;
    AppMethodBeat.o(150438);
    return localf;
  }
  
  public static b bkg()
  {
    AppMethodBeat.i(150440);
    if (bkd().lIO == null) {}
    try
    {
      if (bkd().lIO == null) {
        bkd().lIO = new b();
      }
      b localb = bkd().lIO;
      AppMethodBeat.o(150440);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(150440);
    }
  }
  
  /* Error */
  public static a bkh()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 129
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 118	com/tencent/mm/aq/f:bkd	()Lcom/tencent/mm/aq/f;
    //   11: getfield 39	com/tencent/mm/aq/f:lIN	Lcom/tencent/mm/aq/a;
    //   14: ifnonnull +35 -> 49
    //   17: invokestatic 86	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
    //   20: pop
    //   21: invokestatic 133	com/tencent/mm/kernel/b:aGL	()Z
    //   24: ifeq +42 -> 66
    //   27: invokestatic 118	com/tencent/mm/aq/f:bkd	()Lcom/tencent/mm/aq/f;
    //   30: new 135	com/tencent/mm/aq/a
    //   33: dup
    //   34: invokestatic 98	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   37: getfield 104	com/tencent/mm/kernel/f:cachePath	Ljava/lang/String;
    //   40: invokestatic 137	com/tencent/mm/aq/f:bkg	()Lcom/tencent/mm/aq/b;
    //   43: invokespecial 140	com/tencent/mm/aq/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   46: putfield 39	com/tencent/mm/aq/f:lIN	Lcom/tencent/mm/aq/a;
    //   49: invokestatic 118	com/tencent/mm/aq/f:bkd	()Lcom/tencent/mm/aq/f;
    //   52: getfield 39	com/tencent/mm/aq/f:lIN	Lcom/tencent/mm/aq/a;
    //   55: astore_0
    //   56: ldc 129
    //   58: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: new 93	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 142
    //   72: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: new 147	java/util/Random
    //   78: dup
    //   79: invokespecial 148	java/util/Random:<init>	()V
    //   82: invokevirtual 152	java/util/Random:nextLong	()J
    //   85: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 161	java/lang/String:getBytes	()[B
    //   94: invokestatic 167	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   97: astore_0
    //   98: new 93	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 172	com/tencent/mm/storage/ar:Vgb	Ljava/lang/String;
    //   108: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 174
    //   117: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 176
    //   126: ldc 178
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: aastore
    //   136: invokestatic 184	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: invokestatic 118	com/tencent/mm/aq/f:bkd	()Lcom/tencent/mm/aq/f;
    //   142: new 135	com/tencent/mm/aq/a
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 137	com/tencent/mm/aq/f:bkg	()Lcom/tencent/mm/aq/b;
    //   150: invokespecial 140	com/tencent/mm/aq/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   153: putfield 39	com/tencent/mm/aq/f:lIN	Lcom/tencent/mm/aq/a;
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
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150439);
    onAccountRelease();
    com.tencent.mm.kernel.h.aHE().aGH();
    if (bkd().lIO == null)
    {
      bkd().lIO = new b();
      Log.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[] { Integer.valueOf(bkd().lIO.hashCode()) });
    }
    com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(bke());
    if (!localq.ifE()) {
      localq.ifK();
    }
    this.lIP = new com.tencent.mm.an.f()
    {
      public final void a(te paramAnonymouste1, te paramAnonymouste2, te paramAnonymouste3)
      {
        AppMethodBeat.i(150432);
        Log.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramAnonymouste1.toString() + " getCore().engine:" + f.bkh());
        if (f.bkh() != null)
        {
          f.bkh().a(paramAnonymouste1, paramAnonymouste2, paramAnonymouste3, null, null, null);
          com.tencent.e.h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(150430);
              if (f.bkg() != null) {
                f.bkg().go(false);
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
    com.tencent.mm.kernel.h.aGY().a(379, this.lIS);
    Log.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
    vS(1);
    AppMethodBeat.o(150439);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150442);
    this.lIP = null;
    Object localObject;
    if (this.lIN != null)
    {
      localObject = this.lIN;
      CdnLogic.UnInitialize();
      ((a)localObject).lHF = null;
      ((a)localObject).lHG = null;
      ((a)localObject).lHy = null;
      this.lIN = null;
    }
    if (this.lIO != null)
    {
      localObject = this.lIO;
      if (((b)localObject).lHO != null) {
        ((b)localObject).lHO.clear();
      }
      if (com.tencent.mm.kernel.h.aHE().aGM()) {
        com.tencent.mm.kernel.h.aHG().aHp().remove((MStorageEx.IOnStorageChange)localObject);
      }
      ((b)localObject).lHJ.removeCallbacksAndMessages(null);
      com.tencent.mm.kernel.h.aHF().b(((b)localObject).lHL);
      com.tencent.mm.kernel.h.aHF().kcd.b(379, (com.tencent.mm.an.i)localObject);
      EventCenter.instance.removeListener(((b)localObject).lHK);
      ((b)localObject).appForegroundListener.dead();
      ((b)localObject).lHN.stopTimer();
      this.lIO = null;
    }
    this.lIQ = 0L;
    this.lIR.removeCallbacksAndMessages(null);
    com.tencent.mm.kernel.h.aGY().b(379, this.lIS);
    AppMethodBeat.o(150442);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final void vS(int paramInt)
  {
    AppMethodBeat.i(150443);
    this.lIQ = 0L;
    this.lIR.removeMessages(1);
    com.tencent.mm.kernel.h.aGY().a(new d(paramInt), 0);
    AppMethodBeat.o(150443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aq.f
 * JD-Core Version:    0.7.0.1
 */