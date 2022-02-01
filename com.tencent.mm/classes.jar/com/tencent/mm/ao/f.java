package com.tencent.mm.ao;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class f
  implements aw
{
  private com.tencent.mm.al.d hbA;
  private long hbB;
  private ap hbC;
  private com.tencent.mm.al.g hbD;
  private a hby;
  private b hbz;
  
  public f()
  {
    AppMethodBeat.i(150435);
    this.hby = null;
    this.hbz = null;
    this.hbB = 0L;
    this.hbC = new ap(Looper.getMainLooper())
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
        ad.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(f.a(f.this)), Long.valueOf(bt.vM(f.a(f.this))) });
        com.tencent.mm.kernel.g.aeS().a(new d(i), 0);
        AppMethodBeat.o(150433);
      }
    };
    this.hbD = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(150434);
        if (!(paramAnonymousn instanceof d))
        {
          ad.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
          AppMethodBeat.o(150434);
          return;
        }
        ad.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(f.a(f.this)) });
        if ("doScene failed".equals(paramAnonymousString))
        {
          ad.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(150434);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(546L, paramAnonymousInt1 + 10, 1L, true);
        if (paramAnonymousInt1 == 0)
        {
          if (f.a(f.this) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(546L, 52L, 1L, true);
            f.a(f.this, 0L);
          }
          AppMethodBeat.o(150434);
          return;
        }
        if (paramAnonymousInt1 != 4)
        {
          if (f.a(f.this) == 0L)
          {
            paramAnonymousInt1 = ((d)paramAnonymousn).scene;
            f.a(f.this, bt.eGO());
            f.b(f.this).removeMessages(1);
            f.b(f.this).sendMessageDelayed(f.b(f.this).obtainMessage(1, paramAnonymousInt1, 0), 30000L);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(546L, 50L, 1L, true);
            AppMethodBeat.o(150434);
            return;
          }
          f.a(f.this, 0L);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(546L, 51L, 1L, true);
          AppMethodBeat.o(150434);
          return;
        }
        AppMethodBeat.o(150434);
      }
    };
    AppMethodBeat.o(150435);
  }
  
  public static f awI()
  {
    try
    {
      AppMethodBeat.i(150436);
      f localf = (f)t.ap(f.class);
      AppMethodBeat.o(150436);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String awJ()
  {
    AppMethodBeat.i(150437);
    com.tencent.mm.kernel.g.afz().aeD();
    String str = com.tencent.mm.kernel.g.afB().cachePath + "cdndnsinfo/";
    AppMethodBeat.o(150437);
    return str;
  }
  
  public static com.tencent.mm.al.d awK()
  {
    AppMethodBeat.i(150438);
    com.tencent.mm.al.d locald = awI().hbA;
    AppMethodBeat.o(150438);
    return locald;
  }
  
  public static b awL()
  {
    AppMethodBeat.i(150440);
    if (awI().hbz == null) {}
    try
    {
      if (awI().hbz == null) {
        awI().hbz = new b();
      }
      b localb = awI().hbz;
      AppMethodBeat.o(150440);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(150440);
    }
  }
  
  /* Error */
  public static a awM()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 127
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 116	com/tencent/mm/ao/f:awI	()Lcom/tencent/mm/ao/f;
    //   11: getfield 39	com/tencent/mm/ao/f:hby	Lcom/tencent/mm/ao/a;
    //   14: ifnonnull +35 -> 49
    //   17: invokestatic 84	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
    //   20: pop
    //   21: invokestatic 131	com/tencent/mm/kernel/a:aeH	()Z
    //   24: ifeq +42 -> 66
    //   27: invokestatic 116	com/tencent/mm/ao/f:awI	()Lcom/tencent/mm/ao/f;
    //   30: new 133	com/tencent/mm/ao/a
    //   33: dup
    //   34: invokestatic 96	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   37: getfield 102	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   40: invokestatic 135	com/tencent/mm/ao/f:awL	()Lcom/tencent/mm/ao/b;
    //   43: invokespecial 138	com/tencent/mm/ao/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   46: putfield 39	com/tencent/mm/ao/f:hby	Lcom/tencent/mm/ao/a;
    //   49: invokestatic 116	com/tencent/mm/ao/f:awI	()Lcom/tencent/mm/ao/f;
    //   52: getfield 39	com/tencent/mm/ao/f:hby	Lcom/tencent/mm/ao/a;
    //   55: astore_0
    //   56: ldc 127
    //   58: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: areturn
    //   66: new 91	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 140
    //   72: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: new 145	java/util/Random
    //   78: dup
    //   79: invokespecial 146	java/util/Random:<init>	()V
    //   82: invokevirtual 150	java/util/Random:nextLong	()J
    //   85: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 159	java/lang/String:getBytes	()[B
    //   94: invokestatic 165	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   97: astore_0
    //   98: new 91	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   105: getstatic 170	com/tencent/mm/storage/ae:FfH	Ljava/lang/String;
    //   108: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 172
    //   117: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: ldc 174
    //   126: ldc 176
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_0
    //   135: aastore
    //   136: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: invokestatic 116	com/tencent/mm/ao/f:awI	()Lcom/tencent/mm/ao/f;
    //   142: new 133	com/tencent/mm/ao/a
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 135	com/tencent/mm/ao/f:awL	()Lcom/tencent/mm/ao/b;
    //   150: invokespecial 138	com/tencent/mm/ao/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   153: putfield 39	com/tencent/mm/ao/f:hby	Lcom/tencent/mm/ao/a;
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
  
  public final void nN(int paramInt)
  {
    AppMethodBeat.i(150443);
    this.hbB = 0L;
    this.hbC.removeMessages(1);
    com.tencent.mm.kernel.g.aeS().a(new d(paramInt), 0);
    AppMethodBeat.o(150443);
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150439);
    onAccountRelease();
    com.tencent.mm.kernel.g.afz().aeD();
    if (awI().hbz == null)
    {
      awI().hbz = new b();
      ad.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[] { Integer.valueOf(awI().hbz.hashCode()) });
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(awJ());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    this.hbA = new com.tencent.mm.al.d()
    {
      public final void a(pw paramAnonymouspw1, pw paramAnonymouspw2, pw paramAnonymouspw3)
      {
        AppMethodBeat.i(150432);
        ad.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramAnonymouspw1.toString() + " getCore().engine:" + f.awM());
        if (f.awM() != null)
        {
          f.awM().a(paramAnonymouspw1, paramAnonymouspw2, paramAnonymouspw3, null, null, null);
          com.tencent.e.h.Iye.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(150430);
              if (f.awL() != null) {
                f.awL().eo(false);
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
    com.tencent.mm.kernel.g.aeS().a(379, this.hbD);
    ad.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
    nN(1);
    AppMethodBeat.o(150439);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150442);
    this.hbA = null;
    Object localObject;
    if (this.hby != null)
    {
      localObject = this.hby;
      CdnLogic.UnInitialize();
      ((a)localObject).KCb = null;
      ((a)localObject).haC = null;
      ((a)localObject).hax = null;
      this.hby = null;
    }
    if (this.hbz != null)
    {
      localObject = this.hbz;
      if (com.tencent.mm.kernel.g.afz().aeI()) {
        com.tencent.mm.kernel.g.afB().afk().b((n.b)localObject);
      }
      ((b)localObject).haF.removeCallbacksAndMessages(null);
      com.tencent.mm.kernel.g.afA().b(((b)localObject).haH);
      com.tencent.mm.kernel.g.afA().gcy.b(379, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.sdk.b.a.ESL.d(((b)localObject).haG);
      this.hbz = null;
    }
    this.hbB = 0L;
    this.hbC.removeCallbacksAndMessages(null);
    com.tencent.mm.kernel.g.aeS().b(379, this.hbD);
    AppMethodBeat.o(150442);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ao.f
 * JD-Core Version:    0.7.0.1
 */