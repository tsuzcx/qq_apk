package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.qg;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class f
  implements aw
{
  private a hCa;
  private b hCb;
  private com.tencent.mm.ak.d hCc;
  private long hCd;
  private ao hCe;
  private com.tencent.mm.ak.g hCf;
  
  public f()
  {
    AppMethodBeat.i(150435);
    this.hCa = null;
    this.hCb = null;
    this.hCd = 0L;
    this.hCe = new ao(Looper.getMainLooper())
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
        ac.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(f.a(f.this)), Long.valueOf(bs.Ap(f.a(f.this))) });
        com.tencent.mm.kernel.g.agi().a(new d(i), 0);
        AppMethodBeat.o(150433);
      }
    };
    this.hCf = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(150434);
        if (!(paramAnonymousn instanceof d))
        {
          ac.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
          AppMethodBeat.o(150434);
          return;
        }
        ac.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Long.valueOf(f.a(f.this)) });
        if ("doScene failed".equals(paramAnonymousString))
        {
          ac.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", new Object[] { Integer.valueOf(hashCode()) });
          AppMethodBeat.o(150434);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(546L, paramAnonymousInt1 + 10, 1L, true);
        if (paramAnonymousInt1 == 0)
        {
          if (f.a(f.this) > 0L)
          {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(546L, 52L, 1L, true);
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
            f.a(f.this, bs.eWj());
            f.b(f.this).removeMessages(1);
            f.b(f.this).sendMessageDelayed(f.b(f.this).obtainMessage(1, paramAnonymousInt1, 0), 30000L);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(546L, 50L, 1L, true);
            AppMethodBeat.o(150434);
            return;
          }
          f.a(f.this, 0L);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(546L, 51L, 1L, true);
          AppMethodBeat.o(150434);
          return;
        }
        AppMethodBeat.o(150434);
      }
    };
    AppMethodBeat.o(150435);
  }
  
  public static f aDA()
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
  
  public static String aDB()
  {
    AppMethodBeat.i(150437);
    com.tencent.mm.kernel.g.agP().afT();
    String str = com.tencent.mm.kernel.g.agR().cachePath + "cdndnsinfo/";
    AppMethodBeat.o(150437);
    return str;
  }
  
  public static com.tencent.mm.ak.d aDC()
  {
    AppMethodBeat.i(150438);
    com.tencent.mm.ak.d locald = aDA().hCc;
    AppMethodBeat.o(150438);
    return locald;
  }
  
  public static b aDD()
  {
    AppMethodBeat.i(150440);
    if (aDA().hCb == null) {}
    try
    {
      if (aDA().hCb == null) {
        aDA().hCb = new b();
      }
      b localb = aDA().hCb;
      AppMethodBeat.o(150440);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(150440);
    }
  }
  
  /* Error */
  public static a aDE()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 127
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 116	com/tencent/mm/an/f:aDA	()Lcom/tencent/mm/an/f;
    //   11: getfield 39	com/tencent/mm/an/f:hCa	Lcom/tencent/mm/an/a;
    //   14: ifnonnull +35 -> 49
    //   17: invokestatic 84	com/tencent/mm/kernel/g:agP	()Lcom/tencent/mm/kernel/a;
    //   20: pop
    //   21: invokestatic 131	com/tencent/mm/kernel/a:afX	()Z
    //   24: ifeq +42 -> 66
    //   27: invokestatic 116	com/tencent/mm/an/f:aDA	()Lcom/tencent/mm/an/f;
    //   30: new 133	com/tencent/mm/an/a
    //   33: dup
    //   34: invokestatic 96	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   37: getfield 102	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   40: invokestatic 135	com/tencent/mm/an/f:aDD	()Lcom/tencent/mm/an/b;
    //   43: invokespecial 138	com/tencent/mm/an/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   46: putfield 39	com/tencent/mm/an/f:hCa	Lcom/tencent/mm/an/a;
    //   49: invokestatic 116	com/tencent/mm/an/f:aDA	()Lcom/tencent/mm/an/f;
    //   52: getfield 39	com/tencent/mm/an/f:hCa	Lcom/tencent/mm/an/a;
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
    //   105: getstatic 170	com/tencent/mm/storage/ah:GDu	Ljava/lang/String;
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
    //   136: invokestatic 182	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: invokestatic 116	com/tencent/mm/an/f:aDA	()Lcom/tencent/mm/an/f;
    //   142: new 133	com/tencent/mm/an/a
    //   145: dup
    //   146: aload_0
    //   147: invokestatic 135	com/tencent/mm/an/f:aDD	()Lcom/tencent/mm/an/b;
    //   150: invokespecial 138	com/tencent/mm/an/a:<init>	(Ljava/lang/String;Lcom/tencent/mm/i/b$a;)V
    //   153: putfield 39	com/tencent/mm/an/f:hCa	Lcom/tencent/mm/an/a;
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
  
  public final void oB(int paramInt)
  {
    AppMethodBeat.i(150443);
    this.hCd = 0L;
    this.hCe.removeMessages(1);
    com.tencent.mm.kernel.g.agi().a(new d(paramInt), 0);
    AppMethodBeat.o(150443);
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150439);
    onAccountRelease();
    com.tencent.mm.kernel.g.agP().afT();
    if (aDA().hCb == null)
    {
      aDA().hCb = new b();
      ac.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", new Object[] { Integer.valueOf(aDA().hCb.hashCode()) });
    }
    com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(aDB());
    if (!locale.exists()) {
      locale.mkdirs();
    }
    this.hCc = new com.tencent.mm.ak.d()
    {
      public final void a(qg paramAnonymousqg1, qg paramAnonymousqg2, qg paramAnonymousqg3)
      {
        AppMethodBeat.i(150432);
        ac.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + paramAnonymousqg1.toString() + " getCore().engine:" + f.aDE());
        if (f.aDE() != null)
        {
          f.aDE().a(paramAnonymousqg1, paramAnonymousqg2, paramAnonymousqg3, null, null, null);
          com.tencent.e.h.JZN.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(150430);
              if (f.aDD() != null) {
                f.aDD().eJ(false);
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
    com.tencent.mm.kernel.g.agi().a(379, this.hCf);
    ac.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
    oB(1);
    AppMethodBeat.o(150439);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150442);
    this.hCc = null;
    Object localObject;
    if (this.hCa != null)
    {
      localObject = this.hCa;
      CdnLogic.UnInitialize();
      ((a)localObject).hBc = null;
      ((a)localObject).hBd = null;
      ((a)localObject).hAX = null;
      this.hCa = null;
    }
    if (this.hCb != null)
    {
      localObject = this.hCb;
      if (com.tencent.mm.kernel.g.agP().afY()) {
        com.tencent.mm.kernel.g.agR().agA().b((n.b)localObject);
      }
      ((b)localObject).hBg.removeCallbacksAndMessages(null);
      com.tencent.mm.kernel.g.agQ().b(((b)localObject).hBi);
      com.tencent.mm.kernel.g.agQ().ghe.b(379, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.sdk.b.a.GpY.d(((b)localObject).hBh);
      this.hCb = null;
    }
    this.hCd = 0L;
    this.hCe.removeCallbacksAndMessages(null);
    com.tencent.mm.kernel.g.agi().b(379, this.hCf);
    AppMethodBeat.o(150442);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.f
 * JD-Core Version:    0.7.0.1
 */