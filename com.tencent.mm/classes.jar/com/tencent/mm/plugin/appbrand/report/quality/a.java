package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.luggage.g.d;
import com.tencent.luggage.game.d.g;
import com.tencent.luggage.game.d.g.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.g.b.a.cj.a;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.ck.a;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.g.b.a.cu.a;
import com.tencent.mm.g.b.a.cu.b;
import com.tencent.mm.g.b.a.cu.c;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class a
{
  private static final b iIj;
  private static final HashMap<String, QualitySessionRuntime> iIk;
  
  static
  {
    AppMethodBeat.i(132684);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      iIj = new b();
      iIk = new HashMap();
      AppMethodBeat.o(132684);
      return;
    }
  }
  
  public static QualitySessionRuntime EM(String paramString)
  {
    AppMethodBeat.i(132678);
    paramString = at(paramString, true);
    AppMethodBeat.o(132678);
    return paramString;
  }
  
  public static void a(String paramString, final AppBrandSysConfigWC paramAppBrandSysConfigWC, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle, o paramo)
  {
    long l2 = 0L;
    AppMethodBeat.i(132680);
    QualitySessionRuntime localQualitySessionRuntime = at(paramString, true);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(132680);
      return;
    }
    localQualitySessionRuntime.iIJ = System.currentTimeMillis();
    localQualitySessionRuntime.iIK = paramAppStartupPerformanceReportBundle;
    localQualitySessionRuntime.iIH = paramo.atS().startTime;
    AppStartupPerformanceReportBundle localAppStartupPerformanceReportBundle = (AppStartupPerformanceReportBundle)paramo.d(AppStartupPerformanceReportBundle.class, false);
    if (localAppStartupPerformanceReportBundle == null) {
      ab.e("MicroMsg.AppBrandQualitySystem", "ReportBundle == null in resourceReady");
    }
    do
    {
      com.tencent.mm.plugin.appbrand.s.m.runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132676);
          if (this.iIl.htX.mFinished)
          {
            AppMethodBeat.o(132676);
            return;
          }
          e locale;
          if (!this.iIl.bAa)
          {
            locale = this.iIl.iIN;
            QualitySessionRuntime localQualitySessionRuntime = this.iIl;
            AppBrandSysConfigWC localAppBrandSysConfigWC = paramAppBrandSysConfigWC;
            d.i("MicroMsg.AppBrandRuntimeEventReporter", "AppBrandRuntimeEventReporter.mayStartDependOnClientSampleRate");
            int i = localQualitySessionRuntime.htX.atS().uin;
            double d1 = localAppBrandSysConfigWC.bDI.hhV;
            double d2 = new Random(i ^ System.nanoTime()).nextDouble();
            if (d2 <= d1) {}
            for (boolean bool = true;; bool = false)
            {
              d.i("MicroMsg.AppBrandRuntimeEventReporter", "shouldEnableReport() returned: [%b], localRandom = [%f] serverPercent = [%f]", new Object[] { Boolean.valueOf(bool), Double.valueOf(d2), Double.valueOf(d1) });
              if (!bool) {
                break;
              }
              try
              {
                locale.a(localQualitySessionRuntime, localAppBrandSysConfigWC.bDI.hhW, e.a.iIv, false);
                return;
              }
              finally
              {
                AppMethodBeat.o(132676);
              }
            }
          }
          AppMethodBeat.o(132676);
        }
      });
      AppMethodBeat.o(132680);
      return;
      paramAppStartupPerformanceReportBundle = new cu();
      paramString = at(paramString, true);
    } while (paramString == null);
    paramAppStartupPerformanceReportBundle.hX(paramString.appId);
    paramAppStartupPerformanceReportBundle.hW(paramString.ikX);
    paramAppStartupPerformanceReportBundle.ddj = cu.a.hi(paramString.iIF);
    paramAppStartupPerformanceReportBundle.cZD = paramString.apptype;
    paramAppStartupPerformanceReportBundle.cRG = paramString.scene;
    paramAppStartupPerformanceReportBundle.cZB = paramString.iIG;
    paramAppStartupPerformanceReportBundle.fw(paramo.atS().startTime);
    paramAppStartupPerformanceReportBundle.Hh();
    paramAppStartupPerformanceReportBundle.fv(paramAppStartupPerformanceReportBundle.dav - paramo.atS().startTime);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramo.atR();
    AppBrandInitConfigWC localAppBrandInitConfigWC = paramo.atS();
    if (localAppStartupPerformanceReportBundle.ila)
    {
      paramString = cu.c.ddw;
      label227:
      paramAppStartupPerformanceReportBundle.ddl = paramString;
      if (!localAppBrandInitConfigWC.bDg) {
        break label349;
      }
      paramString = cu.b.ddt;
      label244:
      paramAppStartupPerformanceReportBundle.ddm = paramString;
      if (!paramo.gRo) {
        break label356;
      }
    }
    label349:
    label356:
    for (long l1 = 1L;; l1 = 0L)
    {
      paramAppStartupPerformanceReportBundle.ddn = l1;
      l1 = l2;
      if (paramo.gRo)
      {
        paramString = new File(localAppBrandSysConfigWC.hiX.gUy);
        l1 = l2;
        if (paramString.isFile())
        {
          l1 = l2;
          if (paramString.canRead()) {
            l1 = paramString.length();
          }
        }
      }
      paramAppStartupPerformanceReportBundle.ddk = l1;
      paramAppStartupPerformanceReportBundle.cTb = f.getNetworkType();
      paramAppStartupPerformanceReportBundle.ake();
      break;
      paramString = cu.c.ddx;
      break label227;
      paramString = cu.b.ddu;
      break label244;
    }
  }
  
  /* Error */
  public static void a(String paramString, o paramo)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: iconst_1
    //   8: invokestatic 58	com/tencent/mm/plugin/appbrand/report/quality/a:at	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   11: ifnonnull +10 -> 21
    //   14: ldc_w 265
    //   17: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: new 267	com/tencent/mm/g/b/a/cl
    //   24: dup
    //   25: invokespecial 268	com/tencent/mm/g/b/a/cl:<init>	()V
    //   28: astore 4
    //   30: aload_0
    //   31: iconst_1
    //   32: invokestatic 58	com/tencent/mm/plugin/appbrand/report/quality/a:at	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull +242 -> 281
    //   42: aload 4
    //   44: aload 5
    //   46: getfield 123	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   49: invokevirtual 272	com/tencent/mm/g/b/a/cl:hy	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cl;
    //   52: pop
    //   53: aload 4
    //   55: aload 5
    //   57: getfield 130	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ikX	Ljava/lang/String;
    //   60: invokevirtual 275	com/tencent/mm/g/b/a/cl:hx	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cl;
    //   63: pop
    //   64: aload 4
    //   66: aload 5
    //   68: getfield 137	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIF	I
    //   71: invokestatic 281	com/tencent/mm/g/b/a/cl$a:gY	(I)Lcom/tencent/mm/g/b/a/cl$a;
    //   74: putfield 285	com/tencent/mm/g/b/a/cl:dbv	Lcom/tencent/mm/g/b/a/cl$a;
    //   77: aload 4
    //   79: aload 5
    //   81: getfield 150	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   84: i2l
    //   85: putfield 286	com/tencent/mm/g/b/a/cl:cZD	J
    //   88: aload 4
    //   90: aload 5
    //   92: getfield 162	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIG	I
    //   95: i2l
    //   96: putfield 287	com/tencent/mm/g/b/a/cl:cZB	J
    //   99: aload 4
    //   101: aload 5
    //   103: getfield 156	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   106: i2l
    //   107: putfield 288	com/tencent/mm/g/b/a/cl:cRG	J
    //   110: aload 4
    //   112: aload_1
    //   113: invokevirtual 83	com/tencent/mm/plugin/appbrand/o:atS	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   116: getfield 88	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:startTime	J
    //   119: invokevirtual 292	com/tencent/mm/g/b/a/cl:eX	(J)Lcom/tencent/mm/g/b/a/cl;
    //   122: pop
    //   123: aload 4
    //   125: invokevirtual 296	com/tencent/mm/g/b/a/cl:Hc	()Lcom/tencent/mm/g/b/a/cl;
    //   128: pop
    //   129: aload 4
    //   131: aload 4
    //   133: getfield 297	com/tencent/mm/g/b/a/cl:dav	J
    //   136: aload 4
    //   138: getfield 300	com/tencent/mm/g/b/a/cl:dau	J
    //   141: lsub
    //   142: invokevirtual 303	com/tencent/mm/g/b/a/cl:eW	(J)Lcom/tencent/mm/g/b/a/cl;
    //   145: pop
    //   146: aload 4
    //   148: aload_1
    //   149: invokevirtual 307	com/tencent/mm/plugin/appbrand/o:atT	()Lcom/tencent/mm/plugin/appbrand/page/s;
    //   152: invokevirtual 313	com/tencent/mm/plugin/appbrand/page/s:getCurrentUrl	()Ljava/lang/String;
    //   155: invokestatic 319	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokevirtual 322	com/tencent/mm/g/b/a/cl:hz	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cl;
    //   161: pop
    //   162: aload_1
    //   163: getfield 212	com/tencent/mm/plugin/appbrand/o:gRo	Z
    //   166: ifeq +316 -> 482
    //   169: lconst_1
    //   170: lstore_2
    //   171: aload 4
    //   173: lload_2
    //   174: putfield 325	com/tencent/mm/g/b/a/cl:dad	J
    //   177: aload 5
    //   179: getfield 77	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIK	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   182: ifnull +310 -> 492
    //   185: aload 5
    //   187: getfield 77	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIK	Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;
    //   190: invokevirtual 328	com/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle:aGR	()Z
    //   193: ifeq +294 -> 487
    //   196: lconst_1
    //   197: lstore_2
    //   198: aload 4
    //   200: lload_2
    //   201: putfield 331	com/tencent/mm/g/b/a/cl:dbp	J
    //   204: aload 5
    //   206: getfield 334	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIQ	Z
    //   209: ifeq +308 -> 517
    //   212: ldc2_w 335
    //   215: lstore_2
    //   216: aload 4
    //   218: lload_2
    //   219: putfield 339	com/tencent/mm/g/b/a/cl:daa	J
    //   222: aload 4
    //   224: lconst_0
    //   225: putfield 342	com/tencent/mm/g/b/a/cl:dbw	J
    //   228: aload 4
    //   230: invokestatic 348	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   233: invokestatic 354	com/tencent/mm/plugin/appbrand/report/m:da	(Landroid/content/Context;)Ljava/lang/String;
    //   236: invokevirtual 357	com/tencent/mm/g/b/a/cl:hA	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cl;
    //   239: pop
    //   240: aload_1
    //   241: invokevirtual 183	com/tencent/mm/plugin/appbrand/o:atR	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;
    //   244: getfield 223	com/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC:hiX	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   247: getfield 363	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:gUA	[Lcom/tencent/mm/plugin/appbrand/appcache/PartialFile;
    //   250: astore 5
    //   252: invokestatic 368	com/tencent/mm/plugin/appbrand/appcache/r:avz	()Z
    //   255: ifeq +282 -> 537
    //   258: aload 5
    //   260: ifnull +277 -> 537
    //   263: aload 5
    //   265: arraylength
    //   266: ifle +271 -> 537
    //   269: aload 4
    //   271: lconst_1
    //   272: putfield 371	com/tencent/mm/g/b/a/cl:dbx	J
    //   275: aload 4
    //   277: invokevirtual 372	com/tencent/mm/g/b/a/cl:ake	()Z
    //   280: pop
    //   281: new 374	com/tencent/mm/g/b/a/cw
    //   284: dup
    //   285: invokespecial 375	com/tencent/mm/g/b/a/cw:<init>	()V
    //   288: astore 4
    //   290: aload_0
    //   291: iconst_1
    //   292: invokestatic 58	com/tencent/mm/plugin/appbrand/report/quality/a:at	(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;
    //   295: astore_0
    //   296: aload_0
    //   297: ifnull +152 -> 449
    //   300: aload 4
    //   302: aload_0
    //   303: getfield 123	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:appId	Ljava/lang/String;
    //   306: invokevirtual 379	com/tencent/mm/g/b/a/cw:ib	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cw;
    //   309: pop
    //   310: aload 4
    //   312: aload_0
    //   313: getfield 130	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:ikX	Ljava/lang/String;
    //   316: invokevirtual 382	com/tencent/mm/g/b/a/cw:ia	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cw;
    //   319: pop
    //   320: aload 4
    //   322: aload_0
    //   323: getfield 137	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIF	I
    //   326: invokestatic 388	com/tencent/mm/g/b/a/cw$a:hk	(I)Lcom/tencent/mm/g/b/a/cw$a;
    //   329: putfield 392	com/tencent/mm/g/b/a/cw:ddE	Lcom/tencent/mm/g/b/a/cw$a;
    //   332: aload 4
    //   334: aload_0
    //   335: getfield 150	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:apptype	I
    //   338: i2l
    //   339: putfield 393	com/tencent/mm/g/b/a/cw:cZD	J
    //   342: aload 4
    //   344: aload_0
    //   345: getfield 162	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIG	I
    //   348: i2l
    //   349: putfield 394	com/tencent/mm/g/b/a/cw:cZB	J
    //   352: aload 4
    //   354: aload_0
    //   355: getfield 156	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:scene	I
    //   358: i2l
    //   359: putfield 395	com/tencent/mm/g/b/a/cw:cRG	J
    //   362: aload 4
    //   364: aload_0
    //   365: getfield 73	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIJ	J
    //   368: invokevirtual 399	com/tencent/mm/g/b/a/cw:fA	(J)Lcom/tencent/mm/g/b/a/cw;
    //   371: pop
    //   372: aload 4
    //   374: invokevirtual 403	com/tencent/mm/g/b/a/cw:Hj	()Lcom/tencent/mm/g/b/a/cw;
    //   377: pop
    //   378: aload 4
    //   380: aload 4
    //   382: getfield 404	com/tencent/mm/g/b/a/cw:dav	J
    //   385: aload_0
    //   386: getfield 73	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIJ	J
    //   389: lsub
    //   390: invokevirtual 407	com/tencent/mm/g/b/a/cw:fz	(J)Lcom/tencent/mm/g/b/a/cw;
    //   393: pop
    //   394: aload_0
    //   395: getfield 334	com/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime:iIQ	Z
    //   398: ifeq +148 -> 546
    //   401: aload 4
    //   403: ldc2_w 335
    //   406: putfield 408	com/tencent/mm/g/b/a/cw:daa	J
    //   409: aload 4
    //   411: aload_1
    //   412: invokevirtual 307	com/tencent/mm/plugin/appbrand/o:atT	()Lcom/tencent/mm/plugin/appbrand/page/s;
    //   415: invokevirtual 313	com/tencent/mm/plugin/appbrand/page/s:getCurrentUrl	()Ljava/lang/String;
    //   418: invokestatic 319	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   421: invokevirtual 411	com/tencent/mm/g/b/a/cw:ic	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cw;
    //   424: pop
    //   425: aload 4
    //   427: lconst_0
    //   428: putfield 412	com/tencent/mm/g/b/a/cw:dbw	J
    //   431: aload 4
    //   433: invokestatic 348	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   436: invokestatic 354	com/tencent/mm/plugin/appbrand/report/m:da	(Landroid/content/Context;)Ljava/lang/String;
    //   439: invokevirtual 415	com/tencent/mm/g/b/a/cw:ie	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/cw;
    //   442: pop
    //   443: aload 4
    //   445: invokevirtual 416	com/tencent/mm/g/b/a/cw:ake	()Z
    //   448: pop
    //   449: ldc_w 265
    //   452: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: return
    //   456: astore 6
    //   458: ldc 99
    //   460: ldc_w 418
    //   463: iconst_2
    //   464: anewarray 4	java/lang/Object
    //   467: dup
    //   468: iconst_0
    //   469: aload_0
    //   470: aastore
    //   471: dup
    //   472: iconst_1
    //   473: aload 6
    //   475: aastore
    //   476: invokestatic 421	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   479: goto -317 -> 162
    //   482: lconst_0
    //   483: lstore_2
    //   484: goto -313 -> 171
    //   487: lconst_0
    //   488: lstore_2
    //   489: goto -291 -> 198
    //   492: getstatic 426	com/tencent/mm/sdk/platformtools/f:DEBUG	Z
    //   495: ifeq -291 -> 204
    //   498: new 428	java/lang/IllegalStateException
    //   501: dup
    //   502: ldc_w 430
    //   505: invokespecial 431	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   508: astore_0
    //   509: ldc_w 265
    //   512: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: aload_0
    //   516: athrow
    //   517: aload_1
    //   518: invokevirtual 435	com/tencent/mm/plugin/appbrand/o:atU	()Lcom/tencent/mm/plugin/appbrand/service/c;
    //   521: getfield 440	com/tencent/mm/plugin/appbrand/r:gRF	Z
    //   524: ifeq +8 -> 532
    //   527: lconst_1
    //   528: lstore_2
    //   529: goto -313 -> 216
    //   532: lconst_0
    //   533: lstore_2
    //   534: goto -318 -> 216
    //   537: aload 4
    //   539: lconst_0
    //   540: putfield 371	com/tencent/mm/g/b/a/cl:dbx	J
    //   543: goto -268 -> 275
    //   546: aload_1
    //   547: invokevirtual 435	com/tencent/mm/plugin/appbrand/o:atU	()Lcom/tencent/mm/plugin/appbrand/service/c;
    //   550: getfield 440	com/tencent/mm/plugin/appbrand/r:gRF	Z
    //   553: ifeq +14 -> 567
    //   556: lconst_1
    //   557: lstore_2
    //   558: aload 4
    //   560: lload_2
    //   561: putfield 408	com/tencent/mm/g/b/a/cw:daa	J
    //   564: goto -155 -> 409
    //   567: lconst_0
    //   568: lstore_2
    //   569: goto -11 -> 558
    //   572: astore_0
    //   573: goto -148 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	paramString	String
    //   0	576	1	paramo	o
    //   170	399	2	l	long
    //   28	531	4	localObject1	Object
    //   35	229	5	localObject2	Object
    //   456	18	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   146	162	456	java/lang/Exception
    //   409	425	572	java/lang/Exception
  }
  
  public static void a(String paramString, final com.tencent.mm.plugin.appbrand.report.b paramb)
  {
    AppMethodBeat.i(143520);
    com.tencent.mm.plugin.appbrand.s.m.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143519);
        QualitySessionRuntime localQualitySessionRuntime = a.EM(this.hye);
        if ((localQualitySessionRuntime != null) && (paramb != null) && (paramb.iFf != null) && (paramb.iFf.ygV != 0))
        {
          d.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(paramb.iFf.ygV), Integer.valueOf(paramb.iFf.ygW) });
          e.a locala = null;
          switch (paramb.iFf.ygV)
          {
          default: 
            d.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
          }
          for (;;)
          {
            if (locala != null) {
              localQualitySessionRuntime.iIN.a(localQualitySessionRuntime, paramb.iFf.ygW, locala, true);
            }
            AppMethodBeat.o(143519);
            return;
            locala = e.a.iIu;
            continue;
            locala = e.a.iIv;
          }
        }
        d.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
        AppMethodBeat.o(143519);
      }
    });
    AppMethodBeat.o(143520);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    AppMethodBeat.i(132682);
    QualitySessionRuntime localQualitySessionRuntime1 = at(paramString1, true);
    if (localQualitySessionRuntime1 == null)
    {
      AppMethodBeat.o(132682);
      return;
    }
    d.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject appId = [%s] session.runtime.hashCode = [%d] runtimeHashCode = [%d] name = [%s].", new Object[] { paramString1, Integer.valueOf(localQualitySessionRuntime1.htX.hashCode()), Integer.valueOf(paramInt), paramString2 });
    if (paramInt != localQualitySessionRuntime1.htX.hashCode())
    {
      d.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject runtime hashCode mismatch");
      if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.DEBUG))
      {
        paramString1 = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject runtime hashCode mismatch");
        AppMethodBeat.o(132682);
        throw paramString1;
      }
      AppMethodBeat.o(132682);
      return;
    }
    if (localQualitySessionRuntime1.htX.atU() == null)
    {
      d.e("MicroMsg.AppBrandQualitySystem", "[QualitySystem] onUserScriptInject getService == null");
      if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.DEBUG))
      {
        paramString1 = new IllegalStateException("[RED_FLAVOR_ONLY] [APPBRAND] onUserScriptInject getService == null");
        AppMethodBeat.o(132682);
        throw paramString1;
      }
      AppMethodBeat.o(132682);
      return;
    }
    paramInt = paramString3.length();
    paramString3 = new cj();
    QualitySessionRuntime localQualitySessionRuntime2 = at(paramString1, true);
    if (localQualitySessionRuntime2 != null)
    {
      paramString3.hr(localQualitySessionRuntime2.appId);
      paramString3.hq(localQualitySessionRuntime2.ikX);
      paramString3.dbh = cj.a.gW(localQualitySessionRuntime2.iIF);
      paramString3.cZD = localQualitySessionRuntime2.apptype;
      paramString3.cZB = localQualitySessionRuntime2.iIG;
      paramString3.cRG = localQualitySessionRuntime2.scene;
      paramString3.eT(paramLong);
      paramString3.Ha();
      paramString3.eS(paramString3.dav - paramLong);
      paramString3.dbi = paramInt;
      paramString3.hs(paramString2);
      paramString3.ake();
    }
    if ((!localQualitySessionRuntime1.iIM.iIo) && ((paramString2.endsWith("app-service.js")) || ("game.js".equals(paramString2))))
    {
      localQualitySessionRuntime1.iIM.iIo = true;
      paramString2 = localQualitySessionRuntime1.htX;
      paramString3 = new ck();
      localQualitySessionRuntime1 = at(paramString1, true);
      if (localQualitySessionRuntime1 != null)
      {
        paramString3.hu(localQualitySessionRuntime1.appId);
        paramString3.ht(localQualitySessionRuntime1.ikX);
        paramString3.dbo = ck.a.gX(localQualitySessionRuntime1.iIF);
        paramString3.cZD = localQualitySessionRuntime1.apptype;
        paramString3.cZB = localQualitySessionRuntime1.iIG;
        paramString3.cRG = localQualitySessionRuntime1.scene;
        paramString3.eV(localQualitySessionRuntime1.iIH);
        paramString3.Hb();
        paramString3.eU(paramString3.dav - localQualitySessionRuntime1.iIH);
      }
    }
    for (;;)
    {
      try
      {
        paramString3.hv(q.encode(paramString2.atT().getCurrentUrl()));
        if (paramString2.gRo)
        {
          paramLong = 1L;
          paramString3.dad = paramLong;
          if (localQualitySessionRuntime1.iIK == null) {
            continue;
          }
          if (!localQualitySessionRuntime1.iIK.aGR()) {
            continue;
          }
          paramLong = 1L;
          paramString3.dbp = paramLong;
          if (!localQualitySessionRuntime1.iIQ) {
            break label625;
          }
          paramLong = 2L;
          paramString3.daa = paramLong;
          paramString3.hw(com.tencent.mm.plugin.appbrand.report.m.da(ah.getContext()));
          paramString3.ake();
          AppMethodBeat.o(132682);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        ab.e("MicroMsg.AppBrandQualitySystem", "launchToJsInject appId %s getCurrentUrl npe = %s", new Object[] { paramString1, localNullPointerException });
        continue;
        paramLong = 0L;
        continue;
        paramLong = 0L;
        continue;
        if (!com.tencent.mm.sdk.platformtools.f.DEBUG) {
          continue;
        }
        paramString1 = new IllegalStateException("StartupBundle not registered.");
        AppMethodBeat.o(132682);
        throw paramString1;
      }
      label625:
      if (paramString2.atU().gRF) {
        paramLong = 1L;
      } else {
        paramLong = 0L;
      }
    }
  }
  
  public static b aLt()
  {
    return iIj;
  }
  
  private static QualitySessionRuntime at(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(132679);
    QualitySessionRuntime localQualitySessionRuntime;
    synchronized (iIk)
    {
      localQualitySessionRuntime = (QualitySessionRuntime)iIk.get(paramString);
      if (localQualitySessionRuntime != null) {
        break label108;
      }
      paramString = String.format(Locale.US, "QualitySession not open. appId=%s", new Object[] { paramString });
      if ((paramBoolean) && ((com.tencent.mm.sdk.platformtools.f.DEBUG) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)))
      {
        paramString = new IllegalStateException(paramString);
        AppMethodBeat.o(132679);
        throw paramString;
      }
    }
    d.printErrStackTrace("MicroMsg.AppBrandQualitySystem", new Throwable(), paramString, new Object[0]);
    label108:
    AppMethodBeat.o(132679);
    return localQualitySessionRuntime;
  }
  
  public static void q(o paramo)
  {
    AppMethodBeat.i(132677);
    d.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] startSession appId = [%s] runtime.hashCode = [%d]", new Object[] { paramo.mAppId, Integer.valueOf(paramo.hashCode()) });
    Object localObject2 = paramo.atS().hiI;
    ??? = localObject2;
    if (localObject2 == null)
    {
      d.e("MicroMsg.AppBrandQualitySystem", "startSession with NULL qualityReportSession in InitConfig");
      ??? = new QualitySession(f.pz(paramo.atS().uin), paramo.atS(), paramo.wS().bDh);
      paramo.atS().hiI = ((QualitySession)???);
    }
    localObject2 = f.c((QualitySession)???);
    ((QualitySessionRuntime)localObject2).htX = paramo;
    ((QualitySessionRuntime)localObject2).bAa = paramo.vY();
    ((QualitySessionRuntime)localObject2).iII = System.currentTimeMillis();
    ??? = g.bAQ;
    ((QualitySessionRuntime)localObject2).iIL = g.uL().bAS;
    synchronized (iIk)
    {
      if ((!$assertionsDisabled) && (iIk.get(paramo.mAppId) != null))
      {
        paramo = new AssertionError();
        AppMethodBeat.o(132677);
        throw paramo;
      }
    }
    iIk.put(((QualitySessionRuntime)localObject2).appId, localObject2);
    com.tencent.mm.plugin.appbrand.e.a(paramo.mAppId, new a.1(paramo));
    AppMethodBeat.o(132677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a
 * JD-Core Version:    0.7.0.1
 */