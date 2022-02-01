package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.protocal.protobuf.aeo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler$ICheckAppHandlerErrorPromptDelegate;", "Lcom/tencent/mm/plugin/appbrand/launching/ILaunchStep;", "appId", "", "versionType", "", "isGame", "", "enterPath", "entryModule", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "canShowErrorPrompt", "isFromRemoteDebug", "()Z", "setFromRemoteDebug", "(Z)V", "preDownloadCalled", "call", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "callPreDownload", "", "onDownloadProgress", "progress", "postDownload", "preDownload", "setCanShowErrorPrompt", "can", "showDevPkgNoRecordPrompt", "toast", "resId", "error", "fillReadyPkgList", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ad
  implements aa, x, x.a
{
  private static final ad.a taH;
  private final String appId;
  private final boolean ekt;
  private final String eoR;
  private final int euz;
  private final String qAF;
  private WxaAttributes.WxaVersionInfo rbC;
  private final ICommLibReader sXT;
  boolean sXU;
  private final aeo sYL;
  private final QualitySession taI;
  private boolean taJ;
  private boolean taK;
  
  static
  {
    AppMethodBeat.i(180616);
    taH = new ad.a((byte)0);
    AppMethodBeat.o(180616);
  }
  
  public ad(String paramString1, int paramInt, boolean paramBoolean, String paramString2, String paramString3, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, aeo paramaeo)
  {
    AppMethodBeat.i(320684);
    this.appId = paramString1;
    this.euz = paramInt;
    this.ekt = paramBoolean;
    this.qAF = paramString2;
    this.eoR = paramString3;
    this.rbC = paramWxaVersionInfo;
    this.sXT = paramICommLibReader;
    this.taI = paramQualitySession;
    this.sYL = paramaeo;
    this.taJ = true;
    AppMethodBeat.o(320684);
  }
  
  private final void cAi()
  {
    AppMethodBeat.i(320687);
    if (this.euz == 1) {}
    for (String str = l.getMMString(ba.i.app_brand_launching_dev_pkg_expired, new Object[0]);; str = l.getMMString(ba.i.app_brand_preparing_pkg_manifest_null, new Object[] { e.zm(this.euz) }))
    {
      adc(str);
      AppMethodBeat.o(320687);
      return;
    }
  }
  
  /* Error */
  private WxaPkgWrappingInfo cnT()
  {
    // Byte code:
    //   0: ldc 231
    //   2: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   9: invokestatic 237	com/tencent/mm/plugin/appbrand/appcache/k$a:vK	(I)Z
    //   12: ifeq +116 -> 128
    //   15: aload_0
    //   16: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   19: getfield 242	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   22: ifeq +106 -> 128
    //   25: ldc 244
    //   27: invokestatic 250	com/tencent/mm/plugin/appbrand/app/n:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   30: checkcast 244	com/tencent/mm/plugin/appbrand/launching/t
    //   33: aload_0
    //   34: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   41: invokevirtual 254	com/tencent/mm/plugin/appbrand/launching/t:cR	(Ljava/lang/String;I)Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnonnull +69 -> 115
    //   49: aconst_null
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +71 -> 123
    //   55: aload_0
    //   56: checkcast 2	com/tencent/mm/plugin/appbrand/launching/ad
    //   59: astore_2
    //   60: aload_2
    //   61: invokespecial 256	com/tencent/mm/plugin/appbrand/launching/ad:cAi	()V
    //   64: ldc_w 258
    //   67: new 260	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 262
    //   74: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   81: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 270
    //   87: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   94: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: bipush 93
    //   99: invokevirtual 276	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   102: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: ldc 231
    //   110: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aconst_null
    //   114: areturn
    //   115: aload_2
    //   116: invokestatic 292	com/tencent/mm/plugin/appbrand/config/aj:Ya	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   119: astore_2
    //   120: goto -69 -> 51
    //   123: aload_0
    //   124: aload_2
    //   125: putfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   128: new 189	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   131: dup
    //   132: invokespecial 293	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:<init>	()V
    //   135: astore_3
    //   136: aload_3
    //   137: aload_0
    //   138: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   141: getfield 242	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   144: putfield 296	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:pkgVersion	I
    //   147: aload_3
    //   148: aload_0
    //   149: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   152: putfield 299	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHO	I
    //   155: aload_3
    //   156: aload_0
    //   157: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   160: getfield 302	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:rcl	Ljava/lang/String;
    //   163: putfield 303	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:md5	Ljava/lang/String;
    //   166: aload_3
    //   167: new 195	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap
    //   170: dup
    //   171: invokespecial 304	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:<init>	()V
    //   174: putfield 193	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHT	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   177: getstatic 310	com/tencent/mm/plugin/appbrand/launching/ac:tas	Lcom/tencent/mm/plugin/appbrand/launching/ac;
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   185: astore_2
    //   186: aload_0
    //   187: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   190: astore 4
    //   192: getstatic 310	com/tencent/mm/plugin/appbrand/launching/ac:tas	Lcom/tencent/mm/plugin/appbrand/launching/ac;
    //   195: astore 5
    //   197: aload_2
    //   198: aload 4
    //   200: aload_0
    //   201: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   204: aload_0
    //   205: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   208: aload_0
    //   209: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   212: getfield 242	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   215: invokestatic 314	com/tencent/mm/plugin/appbrand/launching/ac:W	(Ljava/lang/String;II)Z
    //   218: invokestatic 317	com/tencent/mm/plugin/appbrand/launching/ac:a	(Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Ljava/lang/String;Z)Ljava/util/Map;
    //   221: astore 4
    //   223: aload 4
    //   225: invokeinterface 323 1 0
    //   230: invokeinterface 326 1 0
    //   235: astore 5
    //   237: aload 5
    //   239: invokeinterface 160 1 0
    //   244: ifeq +292 -> 536
    //   247: aload 5
    //   249: invokeinterface 164 1 0
    //   254: checkcast 328	java/util/Map$Entry
    //   257: astore_2
    //   258: aload_2
    //   259: invokestatic 334	com/tencent/mm/plugin/appbrand/launching/o:j	(Ljava/util/Map$Entry;)Ljava/lang/Object;
    //   262: checkcast 336	java/lang/String
    //   265: astore 6
    //   267: aload_2
    //   268: invokestatic 338	com/tencent/mm/plugin/appbrand/launching/o:k	(Ljava/util/Map$Entry;)Ljava/lang/Object;
    //   271: checkcast 340	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo
    //   274: astore 7
    //   276: ldc_w 342
    //   279: aload 6
    //   281: invokestatic 175	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   284: ifne +145 -> 429
    //   287: aload_3
    //   288: getfield 346	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHR	Ljava/util/LinkedList;
    //   291: astore 8
    //   293: new 168	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo
    //   296: dup
    //   297: invokespecial 347	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo:<init>	()V
    //   300: astore 9
    //   302: aload_0
    //   303: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   306: getfield 351	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:moduleList	Ljava/util/List;
    //   309: astore_2
    //   310: aload_2
    //   311: ldc_w 353
    //   314: invokestatic 356	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   317: aload_2
    //   318: checkcast 151	java/lang/Iterable
    //   321: invokeinterface 155 1 0
    //   326: astore 10
    //   328: aload 10
    //   330: invokeinterface 160 1 0
    //   335: ifeq +191 -> 526
    //   338: aload 10
    //   340: invokeinterface 164 1 0
    //   345: astore_2
    //   346: aload 6
    //   348: aload_2
    //   349: checkcast 358	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo
    //   352: getfield 359	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:name	Ljava/lang/String;
    //   355: invokestatic 175	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   358: ifeq -30 -> 328
    //   361: aload_2
    //   362: invokestatic 179	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   365: aload_2
    //   366: checkcast 358	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo
    //   369: astore_2
    //   370: aload 9
    //   372: aload 6
    //   374: putfield 171	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo:name	Ljava/lang/String;
    //   377: aload 9
    //   379: aload 7
    //   381: getfield 362	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo:rcF	Ljava/lang/String;
    //   384: putfield 185	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo:md5	Ljava/lang/String;
    //   387: aload 9
    //   389: aload_2
    //   390: getfield 365	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:independent	Z
    //   393: putfield 366	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo:independent	Z
    //   396: aload 9
    //   398: aload_2
    //   399: getfield 370	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:aliases	[Ljava/lang/String;
    //   402: putfield 371	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo:aliases	[Ljava/lang/String;
    //   405: aload 9
    //   407: aload_0
    //   408: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   411: getfield 242	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   414: putfield 372	com/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo:pkgVersion	I
    //   417: getstatic 378	kotlin/ah:aiuX	Lkotlin/ah;
    //   420: astore_2
    //   421: aload 8
    //   423: aload 9
    //   425: invokevirtual 384	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   428: pop
    //   429: aload 7
    //   431: getfield 387	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo:rcG	Ljava/util/List;
    //   434: checkcast 389	java/util/Collection
    //   437: astore_2
    //   438: aload_2
    //   439: ifnull +12 -> 451
    //   442: aload_2
    //   443: invokeinterface 392 1 0
    //   448: ifeq +83 -> 531
    //   451: iconst_1
    //   452: istore_1
    //   453: iload_1
    //   454: ifne -217 -> 237
    //   457: aload_3
    //   458: getfield 193	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHT	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   461: astore_2
    //   462: aload_2
    //   463: invokestatic 179	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   466: aload 7
    //   468: getfield 387	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo:rcG	Ljava/util/List;
    //   471: invokestatic 396	com/tencent/mm/plugin/appbrand/launching/o:dx	(Ljava/util/List;)Ljava/util/List;
    //   474: astore 7
    //   476: aload 6
    //   478: ldc_w 398
    //   481: invokestatic 119	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   484: aload 7
    //   486: ifnull -249 -> 237
    //   489: aload 7
    //   491: invokeinterface 401 1 0
    //   496: ifne -259 -> 237
    //   499: aload_2
    //   500: getfield 405	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:qIc	Landroid/util/ArrayMap;
    //   503: checkcast 319	java/util/Map
    //   506: new 407	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$c$a
    //   509: dup
    //   510: aload 6
    //   512: invokespecial 408	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap$c$a:<init>	(Ljava/lang/String;)V
    //   515: aload 7
    //   517: invokeinterface 412 3 0
    //   522: pop
    //   523: goto -286 -> 237
    //   526: aconst_null
    //   527: astore_2
    //   528: goto -167 -> 361
    //   531: iconst_0
    //   532: istore_1
    //   533: goto -80 -> 453
    //   536: aload_3
    //   537: getfield 193	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:qHT	Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;
    //   540: astore_2
    //   541: aload_2
    //   542: ifnull +7 -> 549
    //   545: aload_2
    //   546: invokevirtual 415	com/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap:che	()V
    //   549: aload_0
    //   550: getfield 131	com/tencent/mm/plugin/appbrand/launching/ad:ekt	Z
    //   553: ifeq +40 -> 593
    //   556: aload_0
    //   557: getfield 133	com/tencent/mm/plugin/appbrand/launching/ad:qAF	Ljava/lang/String;
    //   560: astore_2
    //   561: aload_2
    //   562: ifnull +26 -> 588
    //   565: aload_2
    //   566: ldc_w 417
    //   569: invokevirtual 421	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   572: ifeq +16 -> 588
    //   575: iconst_1
    //   576: istore_1
    //   577: iload_1
    //   578: ifeq +15 -> 593
    //   581: ldc 231
    //   583: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: aload_3
    //   587: areturn
    //   588: iconst_0
    //   589: istore_1
    //   590: goto -13 -> 577
    //   593: aload_0
    //   594: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   597: getfield 424	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:rcq	Z
    //   600: ifeq +427 -> 1027
    //   603: aload_0
    //   604: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   607: getfield 351	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:moduleList	Ljava/util/List;
    //   610: invokestatic 430	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/util/List;)Z
    //   613: ifne +414 -> 1027
    //   616: new 380	java/util/LinkedList
    //   619: dup
    //   620: invokespecial 431	java/util/LinkedList:<init>	()V
    //   623: astore 5
    //   625: aload_0
    //   626: getfield 133	com/tencent/mm/plugin/appbrand/launching/ad:qAF	Ljava/lang/String;
    //   629: invokestatic 437	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:Wu	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokestatic 442	com/tencent/luggage/l/m:fL	(Ljava/lang/String;)Ljava/lang/String;
    //   635: astore_2
    //   636: aload_2
    //   637: checkcast 444	java/lang/CharSequence
    //   640: astore 6
    //   642: aload 6
    //   644: ifnull +13 -> 657
    //   647: aload 6
    //   649: invokeinterface 448 1 0
    //   654: ifne +230 -> 884
    //   657: iconst_1
    //   658: istore_1
    //   659: iload_1
    //   660: ifeq +303 -> 963
    //   663: aload_0
    //   664: getfield 135	com/tencent/mm/plugin/appbrand/launching/ad:eoR	Ljava/lang/String;
    //   667: astore_2
    //   668: aload_2
    //   669: checkcast 444	java/lang/CharSequence
    //   672: astore 6
    //   674: aload 6
    //   676: ifnull +13 -> 689
    //   679: aload 6
    //   681: invokeinterface 448 1 0
    //   686: ifne +203 -> 889
    //   689: iconst_1
    //   690: istore_1
    //   691: iload_1
    //   692: ifeq +11 -> 703
    //   695: aload_0
    //   696: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   699: getfield 451	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:rcr	Ljava/lang/String;
    //   702: astore_2
    //   703: aload_2
    //   704: checkcast 444	java/lang/CharSequence
    //   707: astore 6
    //   709: aload 6
    //   711: ifnull +13 -> 724
    //   714: aload 6
    //   716: invokeinterface 448 1 0
    //   721: ifne +173 -> 894
    //   724: iconst_1
    //   725: istore_1
    //   726: iload_1
    //   727: ifeq +172 -> 899
    //   730: aconst_null
    //   731: astore_2
    //   732: aload_2
    //   733: ifnull +13 -> 746
    //   736: aload 5
    //   738: aload_2
    //   739: getfield 359	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:name	Ljava/lang/String;
    //   742: invokevirtual 384	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   745: pop
    //   746: aload_2
    //   747: ifnull +23 -> 770
    //   750: aload_2
    //   751: getfield 365	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:independent	Z
    //   754: ifne +25 -> 779
    //   757: ldc_w 342
    //   760: aload_2
    //   761: getfield 359	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo:name	Ljava/lang/String;
    //   764: invokestatic 175	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   767: ifne +12 -> 779
    //   770: aload 5
    //   772: ldc_w 342
    //   775: invokevirtual 384	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   778: pop
    //   779: aload 5
    //   781: checkcast 400	java/util/List
    //   784: astore_2
    //   785: new 453	java/util/concurrent/CountDownLatch
    //   788: dup
    //   789: iconst_1
    //   790: invokespecial 455	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   793: astore 6
    //   795: new 457	java/util/concurrent/atomic/AtomicReference
    //   798: dup
    //   799: invokespecial 458	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   802: astore 5
    //   804: new 260	java/lang/StringBuilder
    //   807: dup
    //   808: ldc_w 460
    //   811: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   814: aload_0
    //   815: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   818: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: bipush 124
    //   823: invokevirtual 276	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   826: aload_0
    //   827: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   830: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   833: bipush 93
    //   835: invokevirtual 276	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   838: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: new 14	com/tencent/mm/plugin/appbrand/launching/ad$b
    //   844: dup
    //   845: aload_0
    //   846: aload_2
    //   847: aload 4
    //   849: aload_3
    //   850: aload 5
    //   852: aload 6
    //   854: invokespecial 463	com/tencent/mm/plugin/appbrand/launching/ad$b:<init>	(Lcom/tencent/mm/plugin/appbrand/launching/ad;Ljava/util/List;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/CountDownLatch;)V
    //   857: checkcast 465	kotlin/g/a/a
    //   860: invokestatic 471	com/tencent/mm/ae/d:d	(Ljava/lang/String;Lkotlin/g/a/a;)V
    //   863: aload 6
    //   865: invokevirtual 474	java/util/concurrent/CountDownLatch:await	()V
    //   868: aload 5
    //   870: invokevirtual 477	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   873: checkcast 189	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo
    //   876: astore_2
    //   877: ldc 231
    //   879: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   882: aload_2
    //   883: areturn
    //   884: iconst_0
    //   885: istore_1
    //   886: goto -227 -> 659
    //   889: iconst_0
    //   890: istore_1
    //   891: goto -200 -> 691
    //   894: iconst_0
    //   895: istore_1
    //   896: goto -170 -> 726
    //   899: aload_0
    //   900: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   903: getfield 351	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:moduleList	Ljava/util/List;
    //   906: astore 6
    //   908: aload 6
    //   910: ldc_w 353
    //   913: invokestatic 356	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   916: aload 6
    //   918: aload_2
    //   919: new 260	java/lang/StringBuilder
    //   922: dup
    //   923: ldc_w 479
    //   926: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   929: aload_0
    //   930: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   933: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: ldc_w 481
    //   939: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload_0
    //   943: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   946: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   949: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: iconst_4
    //   953: invokestatic 486	com/tencent/mm/plugin/appbrand/q/g:a	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Object;
    //   956: checkcast 358	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo
    //   959: astore_2
    //   960: goto -228 -> 732
    //   963: aload_0
    //   964: getfield 137	com/tencent/mm/plugin/appbrand/launching/ad:rbC	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   967: getfield 351	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:moduleList	Ljava/util/List;
    //   970: astore 6
    //   972: aload 6
    //   974: ldc_w 353
    //   977: invokestatic 356	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   980: aload 6
    //   982: aload_2
    //   983: new 260	java/lang/StringBuilder
    //   986: dup
    //   987: ldc_w 488
    //   990: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   993: aload_0
    //   994: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   997: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: ldc_w 481
    //   1003: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload_0
    //   1007: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   1010: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: iconst_4
    //   1017: invokestatic 486	com/tencent/mm/plugin/appbrand/q/g:a	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Object;
    //   1020: checkcast 358	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionModuleInfo
    //   1023: astore_2
    //   1024: goto -292 -> 732
    //   1027: iconst_1
    //   1028: anewarray 336	java/lang/String
    //   1031: dup
    //   1032: iconst_0
    //   1033: ldc_w 342
    //   1036: aastore
    //   1037: invokestatic 494	kotlin/a/p:al	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   1040: checkcast 400	java/util/List
    //   1043: astore_2
    //   1044: goto -259 -> 785
    //   1047: astore_2
    //   1048: ldc_w 258
    //   1051: new 260	java/lang/StringBuilder
    //   1054: dup
    //   1055: ldc_w 496
    //   1058: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1061: aload_0
    //   1062: getfield 127	com/tencent/mm/plugin/appbrand/launching/ad:appId	Ljava/lang/String;
    //   1065: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: ldc_w 498
    //   1071: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: aload_0
    //   1075: getfield 129	com/tencent/mm/plugin/appbrand/launching/ad:euz	I
    //   1078: invokevirtual 273	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1081: bipush 41
    //   1083: invokevirtual 276	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1086: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1089: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1092: goto -224 -> 868
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1095	0	this	ad
    //   452	444	1	i	int
    //   44	1000	2	localObject1	Object
    //   1047	1	2	localObject2	Object
    //   135	715	3	localWxaPkgWrappingInfo	WxaPkgWrappingInfo
    //   190	658	4	localObject3	Object
    //   195	674	5	localObject4	Object
    //   265	716	6	localObject5	Object
    //   274	242	7	localObject6	Object
    //   291	131	8	localLinkedList	java.util.LinkedList
    //   300	124	9	localModulePkgInfo	com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo
    //   326	13	10	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   863	868	1047	finally
  }
  
  public final void adc(String paramString)
  {
    AppMethodBeat.i(180612);
    if (this.taJ)
    {
      ax.a(paramString, (aa)this);
      AppMethodBeat.o(180612);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "silent toast:error=" + paramString + ", stack=" + android.util.Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(180612);
  }
  
  public final boolean czJ()
  {
    return this.taJ;
  }
  
  public void czK() {}
  
  public final void jY(boolean paramBoolean)
  {
    this.taJ = paramBoolean;
  }
  
  public void onDownloadProgress(int paramInt) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(ad paramad, List<String> paramList, Map<String, ? extends WxaAttributes.WxaWidgetInfo> paramMap, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, AtomicReference<WxaPkgWrappingInfo> paramAtomicReference, CountDownLatch paramCountDownLatch)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ad
 * JD-Core Version:    0.7.0.1
 */