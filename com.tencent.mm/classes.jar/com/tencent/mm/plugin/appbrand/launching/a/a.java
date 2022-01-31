package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.b.a.ao;
import com.tencent.mm.h.b.a.ao.c;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.d;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.clr;
import com.tencent.mm.protocal.c.cmq;
import com.tencent.mm.protocal.c.cmu;
import com.tencent.mm.protocal.c.cnk;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.ah.a<ati>
{
  final b dmK;
  final String fJO;
  public volatile t gLO;
  private final ao gLP;
  public volatile boolean gLa = false;
  
  public a(String paramString1, boolean paramBoolean, clr paramclr, cnk paramcnk, cmu paramcmu, String paramString2, int paramInt, QualitySession paramQualitySession)
  {
    this.fJO = paramString2;
    this.gLP = d.b(paramQualitySession);
    paramQualitySession = this.gLP;
    if (paramBoolean) {
      paramString2 = ao.c.cou;
    }
    for (;;)
    {
      paramQualitySession.coh = paramString2;
      this.gLP.cis = d.getNetworkType();
      paramString2 = new ath();
      paramString2.euK = paramString1;
      paramString2.toO = paramclr;
      int i;
      if (paramBoolean)
      {
        i = 1;
        label85:
        paramString2.tgK = i;
        paramString2.toR = paramcnk;
        paramString2.toS = paramcmu;
        paramString1 = new cmq();
        paramString1.tqO = paramInt;
        if (paramInt > 0)
        {
          paramclr = com.tencent.mm.plugin.appbrand.app.e.abg();
          if (paramclr != null)
          {
            paramcnk = new u();
            paramcnk.field_key = "@LibraryAppId";
            paramcnk.field_version = paramInt;
            if (paramclr.b(paramcnk, new String[] { "key", "version" }))
            {
              paramString1.svy = ((int)paramcnk.field_updateTime);
              paramString1.tZr = paramcnk.field_scene;
            }
          }
        }
        paramString2.toQ = paramString1;
      }
      try
      {
        if (q.dyl.duL) {
          y.i("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", "DeviceInfo isLimit benchmarkLevel");
        }
        for (paramString2.toU = -2;; paramString2.toU = g.AA().getInt("ClientBenchmarkLevel", 0))
        {
          paramString1 = new b.a();
          paramString1.ecG = 1122;
          paramString1.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
          paramString1.ecH = paramString2;
          paramString1.ecI = new ati();
          paramString1 = paramString1.Kt();
          this.dmK = paramString1;
          this.dmK = paramString1;
          return;
          paramString2 = ao.c.cov;
          break;
          i = 2;
          break label85;
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp|func:1122", paramString1, "read performanceLevel", new Object[0]);
        }
      }
    }
  }
  
  private int aag()
  {
    return ((ath)this.dmK.ecE.ecN).toO.pyo;
  }
  
  private int alQ()
  {
    return ((ath)this.dmK.ecE.ecN).toO.tmZ;
  }
  
  private boolean alR()
  {
    return ((ath)this.dmK.ecE.ecN).toO.tqM > 0;
  }
  
  private ath alS()
  {
    return (ath)this.dmK.ecE.ecN;
  }
  
  private String getAppId()
  {
    return ((ath)this.dmK.ecE.ecN).euK;
  }
  
  /* Error */
  public final com.tencent.mm.ck.f<com.tencent.mm.ah.a.a<ati>> Km()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 239
    //   4: invokestatic 243	com/tencent/mm/plugin/appbrand/app/e:G	(Ljava/lang/Class;)Ljava/lang/Object;
    //   7: checkcast 239	com/tencent/mm/plugin/appbrand/appcache/b/d/e
    //   10: aload_0
    //   11: invokespecial 245	com/tencent/mm/plugin/appbrand/launching/a/a:getAppId	()Ljava/lang/String;
    //   14: aload_0
    //   15: invokespecial 247	com/tencent/mm/plugin/appbrand/launching/a/a:aag	()I
    //   18: invokevirtual 251	com/tencent/mm/plugin/appbrand/appcache/b/d/e:an	(Ljava/lang/String;I)Landroid/util/Pair;
    //   21: astore_3
    //   22: aload_3
    //   23: getfield 257	android/util/Pair:first	Ljava/lang/Object;
    //   26: ifnull +70 -> 96
    //   29: ldc 140
    //   31: ldc_w 259
    //   34: iconst_2
    //   35: anewarray 200	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: invokespecial 245	com/tencent/mm/plugin/appbrand/launching/a/a:getAppId	()Ljava/lang/String;
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_0
    //   48: invokespecial 247	com/tencent/mm/plugin/appbrand/launching/a/a:aag	()I
    //   51: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: invokestatic 268	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: getstatic 274	com/tencent/mm/plugin/appbrand/appcache/b/c/a:fFB	Lcom/tencent/mm/plugin/appbrand/appcache/b/c/a;
    //   61: astore 4
    //   63: aload_3
    //   64: getfield 277	android/util/Pair:second	Ljava/lang/Object;
    //   67: checkcast 279	java/lang/Long
    //   70: invokevirtual 283	java/lang/Long:longValue	()J
    //   73: ldc2_w 284
    //   76: invokestatic 289	com/tencent/mm/plugin/appbrand/appcache/b/c/a:s	(JJ)V
    //   79: new 291	com/tencent/mm/plugin/appbrand/launching/a/a$2
    //   82: dup
    //   83: aload_0
    //   84: aload_3
    //   85: invokespecial 294	com/tencent/mm/plugin/appbrand/launching/a/a$2:<init>	(Lcom/tencent/mm/plugin/appbrand/launching/a/a;Landroid/util/Pair;)V
    //   88: invokestatic 300	com/tencent/mm/ck/g:c	(Lcom/tencent/mm/vending/g/c$a;)Lcom/tencent/mm/ck/f;
    //   91: astore_3
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_3
    //   95: areturn
    //   96: aload_0
    //   97: getfield 26	com/tencent/mm/plugin/appbrand/launching/a/a:gLa	Z
    //   100: ifne +104 -> 204
    //   103: ldc_w 302
    //   106: invokestatic 243	com/tencent/mm/plugin/appbrand/app/e:G	(Ljava/lang/Class;)Ljava/lang/Object;
    //   109: checkcast 302	com/tencent/mm/plugin/appbrand/appcache/b/d/b
    //   112: aload_0
    //   113: invokespecial 245	com/tencent/mm/plugin/appbrand/launching/a/a:getAppId	()Ljava/lang/String;
    //   116: iconst_2
    //   117: aload_0
    //   118: invokespecial 247	com/tencent/mm/plugin/appbrand/launching/a/a:aag	()I
    //   121: invokevirtual 306	com/tencent/mm/plugin/appbrand/appcache/b/d/b:w	(Ljava/lang/String;II)Landroid/util/Pair;
    //   124: astore_3
    //   125: aload_3
    //   126: getfield 257	android/util/Pair:first	Ljava/lang/Object;
    //   129: checkcast 308	java/lang/Boolean
    //   132: invokevirtual 311	java/lang/Boolean:booleanValue	()Z
    //   135: ifeq +69 -> 204
    //   138: getstatic 274	com/tencent/mm/plugin/appbrand/appcache/b/c/a:fFB	Lcom/tencent/mm/plugin/appbrand/appcache/b/c/a;
    //   141: astore 4
    //   143: aload_3
    //   144: getfield 277	android/util/Pair:second	Ljava/lang/Object;
    //   147: checkcast 261	java/lang/Integer
    //   150: invokevirtual 314	java/lang/Integer:intValue	()I
    //   153: i2l
    //   154: ldc2_w 315
    //   157: invokestatic 289	com/tencent/mm/plugin/appbrand/appcache/b/c/a:s	(JJ)V
    //   160: ldc 140
    //   162: ldc_w 318
    //   165: iconst_2
    //   166: anewarray 200	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_0
    //   172: invokespecial 245	com/tencent/mm/plugin/appbrand/launching/a/a:getAppId	()Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_0
    //   179: invokespecial 247	com/tencent/mm/plugin/appbrand/launching/a/a:aag	()I
    //   182: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: invokestatic 268	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: new 320	com/tencent/mm/plugin/appbrand/launching/a/a$3
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 323	com/tencent/mm/plugin/appbrand/launching/a/a$3:<init>	(Lcom/tencent/mm/plugin/appbrand/launching/a/a;)V
    //   197: invokestatic 300	com/tencent/mm/ck/g:c	(Lcom/tencent/mm/vending/g/c$a;)Lcom/tencent/mm/ck/f;
    //   200: astore_3
    //   201: goto -109 -> 92
    //   204: invokestatic 328	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   207: lstore_1
    //   208: aload_0
    //   209: getfield 36	com/tencent/mm/plugin/appbrand/launching/a/a:gLP	Lcom/tencent/mm/h/b/a/ao;
    //   212: lload_1
    //   213: invokevirtual 332	com/tencent/mm/h/b/a/ao:aN	(J)Lcom/tencent/mm/h/b/a/ao;
    //   216: pop
    //   217: aload_0
    //   218: invokespecial 334	com/tencent/mm/ah/a:Km	()Lcom/tencent/mm/ck/f;
    //   221: astore_3
    //   222: goto -130 -> 92
    //   225: astore_3
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_3
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	a
    //   207	6	1	l	long
    //   21	201	3	localObject1	Object
    //   225	4	3	localObject2	Object
    //   61	81	4	locala	com.tencent.mm.plugin.appbrand.appcache.b.c.a
    // Exception table:
    //   from	to	target	type
    //   2	92	225	finally
    //   96	201	225	finally
    //   204	222	225	finally
  }
  
  public final void alT()
  {
    c.DS().O(new Runnable()
    {
      public final void run()
      {
        a.this.gLa = false;
        a.this.Km();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a.a
 * JD-Core Version:    0.7.0.1
 */