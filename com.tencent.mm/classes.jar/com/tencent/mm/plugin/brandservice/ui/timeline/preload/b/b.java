package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.u;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.eid;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "kotlin.jvm.PlatformType", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplType", "download", "url", "tmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Lcom/tencent/mm/vfs/VFSFile;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", "dir", "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "debugInfo", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"})
public final class b
{
  private static final String PREFIX;
  private static final String pFm;
  private static final kotlin.f pFn;
  private static final int pFo = 60000;
  private static final ConcurrentHashMap<Integer, Long> pFp;
  private static final ArrayList<Integer> pFq;
  public static final b pFr;
  
  static
  {
    AppMethodBeat.i(6840);
    pFr = new b();
    String str = com.tencent.mm.plugin.webview.h.a.pFm;
    pFm = str;
    PREFIX = str;
    pFn = g.ah((kotlin.g.a.a)b.b.pFu);
    pFo = 60000;
    pFp = new ConcurrentHashMap();
    pFq = new ArrayList();
    AppMethodBeat.o(6840);
  }
  
  private static String DA(int paramInt)
  {
    AppMethodBeat.i(6842);
    String str = "_tmpl_download_time_".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6842);
    return str;
  }
  
  public static final void DB(int paramInt)
  {
    AppMethodBeat.i(6846);
    u.coo().putLong("_check_time_colddown", paramInt * 1000);
    AppMethodBeat.o(6846);
  }
  
  public static final eib DC(int paramInt)
  {
    AppMethodBeat.i(6851);
    eib localeib = new eib();
    String str = u.coo().getString(u.Dx(paramInt), null);
    if (str != null)
    {
      p.g(str, "uid");
      a(localeib, paramInt, str);
    }
    AppMethodBeat.o(6851);
    return localeib;
  }
  
  public static final eic DE(int paramInt)
  {
    AppMethodBeat.i(195763);
    Object localObject2 = DD(paramInt);
    if (!u.a((eib)localObject2))
    {
      Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + paramInt + " localTmplInfo is null");
      com.tencent.mm.plugin.webview.h.a.pl(100);
      AppMethodBeat.o(195763);
      return null;
    }
    Object localObject1 = u.c((eib)localObject2);
    if (!u.ain((String)localObject1))
    {
      Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + (String)localObject1 + " is null");
      if (((eib)localObject2).MSm > 0) {
        com.tencent.mm.plugin.webview.h.a.gH(((eib)localObject2).MSm, 100);
      }
      AppMethodBeat.o(195763);
      return null;
    }
    eic localeic = new eic();
    localeic.pCV = paramInt;
    localeic.version = ((eib)localObject2).Version;
    localeic.md5 = ((eib)localObject2).Md5;
    localeic.Nhr = ((String)localObject1);
    Object localObject3 = new StringBuilder().append(pFm).append(paramInt).append('_').append(((eib)localObject2).LQx).append(".html");
    if ((p.j(PREFIX, pFm) ^ true)) {}
    for (localObject1 = "?prefix=" + URLEncoder.encode(PREFIX);; localObject1 = "")
    {
      localeic.ISo = ((String)localObject1);
      localeic.pkK = ((eib)localObject2).KUA;
      localeic.reportId = ((eib)localObject2).MSm;
      localeic.DPz = u.coo().getLong(DA(((eib)localObject2).oUv), 0L);
      localeic.hFF = ((eib)localObject2).LQx;
      localObject1 = ((eib)localObject2).Nhn;
      p.g(localObject1, "tmplInfo.HttpHeaderList");
      localObject2 = (Iterable)localObject1;
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (eia)((Iterator)localObject2).next();
        localObject1 = ((StringBuilder)localObject1).append("\n" + ((eia)localObject3).xMX + ':' + ((eia)localObject3).Cyk);
        p.g(localObject1, "sb.append(\"\\n${header.Key}:${header.Value}\")");
      }
    }
    localeic.Nhs = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(195763);
    return localeic;
  }
  
  /* Error */
  private static a a(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: sipush 6862
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a
    //   9: dup
    //   10: invokespecial 402	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:<init>	()V
    //   13: astore 7
    //   15: new 404	com/tencent/mm/vfs/o
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 405	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   23: astore 8
    //   25: aload 8
    //   27: invokevirtual 408	com/tencent/mm/vfs/o:exists	()Z
    //   30: ifeq +9 -> 39
    //   33: aload 8
    //   35: invokevirtual 411	com/tencent/mm/vfs/o:delete	()Z
    //   38: pop
    //   39: new 413	java/net/URL
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 414	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 418	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnonnull +101 -> 155
    //   57: new 420	kotlin/t
    //   60: dup
    //   61: ldc_w 422
    //   64: invokespecial 423	kotlin/t:<init>	(Ljava/lang/String;)V
    //   67: astore_2
    //   68: sipush 6862
    //   71: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: ldc 242
    //   79: aload_2
    //   80: checkcast 401	java/lang/Throwable
    //   83: new 244	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 425
    //   90: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 427
    //   100: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 431	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 7
    //   119: aload_2
    //   120: checkcast 433	java/lang/Exception
    //   123: putfield 437	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   126: iload_0
    //   127: bipush 7
    //   129: invokestatic 290	com/tencent/mm/plugin/webview/h/a:gH	(II)V
    //   132: aload 8
    //   134: invokevirtual 408	com/tencent/mm/vfs/o:exists	()Z
    //   137: ifeq +9 -> 146
    //   140: aload 8
    //   142: invokevirtual 411	com/tencent/mm/vfs/o:delete	()Z
    //   145: pop
    //   146: sipush 6862
    //   149: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 7
    //   154: areturn
    //   155: aload 6
    //   157: checkcast 439	java/net/HttpURLConnection
    //   160: astore 9
    //   162: aload 9
    //   164: ldc_w 441
    //   167: ldc_w 443
    //   170: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 9
    //   175: ldc_w 441
    //   178: ldc_w 448
    //   181: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 9
    //   186: iconst_0
    //   187: invokevirtual 452	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   190: aload_2
    //   191: ifnull +219 -> 410
    //   194: aload_2
    //   195: invokeinterface 457 1 0
    //   200: ifne +204 -> 404
    //   203: iconst_1
    //   204: istore 4
    //   206: iload 4
    //   208: ifeq +202 -> 410
    //   211: ldc 242
    //   213: ldc_w 459
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_2
    //   223: invokeinterface 463 1 0
    //   228: invokestatic 468	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 471	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_2
    //   236: invokeinterface 475 1 0
    //   241: invokeinterface 478 1 0
    //   246: astore 6
    //   248: aload 6
    //   250: invokeinterface 374 1 0
    //   255: ifeq +155 -> 410
    //   258: aload 6
    //   260: invokeinterface 378 1 0
    //   265: checkcast 182	java/lang/String
    //   268: astore 10
    //   270: aload 9
    //   272: aload 10
    //   274: aload_2
    //   275: aload 10
    //   277: invokeinterface 482 2 0
    //   282: checkcast 182	java/lang/String
    //   285: invokevirtual 446	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -40 -> 248
    //   291: astore_2
    //   292: sipush 6862
    //   295: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_2
    //   299: athrow
    //   300: astore_2
    //   301: aload 9
    //   303: invokevirtual 486	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   306: astore 6
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 491	java/io/InputStream:close	()V
    //   318: aload 9
    //   320: invokevirtual 494	java/net/HttpURLConnection:disconnect	()V
    //   323: sipush 6862
    //   326: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload_2
    //   330: athrow
    //   331: astore_2
    //   332: ldc 242
    //   334: aload_2
    //   335: checkcast 401	java/lang/Throwable
    //   338: new 244	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 496
    //   345: invokespecial 249	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload_3
    //   349: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 427
    //   355: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 431	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: aload 7
    //   374: aload_2
    //   375: checkcast 433	java/lang/Exception
    //   378: putfield 437	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   381: iload_0
    //   382: bipush 7
    //   384: invokestatic 290	com/tencent/mm/plugin/webview/h/a:gH	(II)V
    //   387: aload 8
    //   389: invokevirtual 408	com/tencent/mm/vfs/o:exists	()Z
    //   392: ifeq -246 -> 146
    //   395: aload 8
    //   397: invokevirtual 411	com/tencent/mm/vfs/o:delete	()Z
    //   400: pop
    //   401: goto -255 -> 146
    //   404: iconst_0
    //   405: istore 4
    //   407: goto -201 -> 206
    //   410: aload 9
    //   412: iconst_0
    //   413: invokevirtual 499	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   416: aload 9
    //   418: ldc_w 501
    //   421: invokevirtual 504	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   424: aload 9
    //   426: sipush 10000
    //   429: invokevirtual 507	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   432: aload 9
    //   434: sipush 3000
    //   437: invokevirtual 510	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   440: aload 9
    //   442: invokevirtual 513	java/net/HttpURLConnection:connect	()V
    //   445: aload 9
    //   447: invokevirtual 516	java/net/HttpURLConnection:getResponseCode	()I
    //   450: istore 4
    //   452: iload 4
    //   454: sipush 200
    //   457: if_icmpne +219 -> 676
    //   460: aload 8
    //   462: invokevirtual 519	com/tencent/mm/vfs/o:createNewFile	()Z
    //   465: pop
    //   466: sipush 8192
    //   469: newarray byte
    //   471: astore_2
    //   472: new 521	kotlin/g/b/z$d
    //   475: dup
    //   476: invokespecial 522	kotlin/g/b/z$d:<init>	()V
    //   479: astore 11
    //   481: aload 8
    //   483: invokestatic 528	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   486: checkcast 530	java/io/Closeable
    //   489: astore 10
    //   491: aconst_null
    //   492: astore 6
    //   494: aload 10
    //   496: checkcast 532	java/io/OutputStream
    //   499: astore 12
    //   501: aload 9
    //   503: invokevirtual 486	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   506: aload_2
    //   507: invokevirtual 536	java/io/InputStream:read	([B)I
    //   510: istore 4
    //   512: aload 11
    //   514: iload 4
    //   516: putfield 539	kotlin/g/b/z$d:SYE	I
    //   519: iload 4
    //   521: iconst_m1
    //   522: if_icmpeq +45 -> 567
    //   525: aload 12
    //   527: aload_2
    //   528: iconst_0
    //   529: aload 11
    //   531: getfield 539	kotlin/g/b/z$d:SYE	I
    //   534: invokevirtual 543	java/io/OutputStream:write	([BII)V
    //   537: goto -36 -> 501
    //   540: astore 6
    //   542: sipush 6862
    //   545: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: aload 6
    //   550: athrow
    //   551: astore_2
    //   552: aload 10
    //   554: aload 6
    //   556: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   559: sipush 6862
    //   562: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload_2
    //   566: athrow
    //   567: getstatic 554	kotlin/x:SXb	Lkotlin/x;
    //   570: astore_2
    //   571: aload 10
    //   573: aconst_null
    //   574: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   577: aload 7
    //   579: iconst_1
    //   580: putfield 557	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:success	Z
    //   583: aload 7
    //   585: aload 9
    //   587: ldc_w 559
    //   590: invokevirtual 562	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   593: putfield 565	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:pFs	Ljava/lang/String;
    //   596: aload 7
    //   598: aload 9
    //   600: ldc_w 567
    //   603: invokevirtual 562	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   606: putfield 570	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:pFt	Ljava/lang/String;
    //   609: aload 9
    //   611: ldc_w 572
    //   614: invokevirtual 562	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   617: astore_2
    //   618: aload_2
    //   619: ifnull +51 -> 670
    //   622: ldc_w 574
    //   625: aload_2
    //   626: invokestatic 323	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   629: iconst_1
    //   630: ixor
    //   631: ifeq +39 -> 670
    //   634: iconst_1
    //   635: istore 5
    //   637: aload 7
    //   639: iload 5
    //   641: putfield 577	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:kwO	Z
    //   644: getstatic 554	kotlin/x:SXb	Lkotlin/x;
    //   647: astore_2
    //   648: aload 9
    //   650: invokevirtual 486	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   653: astore_2
    //   654: aload_2
    //   655: ifnull +7 -> 662
    //   658: aload_2
    //   659: invokevirtual 491	java/io/InputStream:close	()V
    //   662: aload 9
    //   664: invokevirtual 494	java/net/HttpURLConnection:disconnect	()V
    //   667: goto -521 -> 146
    //   670: iconst_0
    //   671: istore 5
    //   673: goto -36 -> 637
    //   676: ldc 242
    //   678: ldc_w 579
    //   681: iload 4
    //   683: invokestatic 185	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   686: invokevirtual 189	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   689: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: iload 4
    //   694: sipush 500
    //   697: if_icmple +12 -> 709
    //   700: iload_0
    //   701: bipush 11
    //   703: invokestatic 290	com/tencent/mm/plugin/webview/h/a:gH	(II)V
    //   706: goto -62 -> 644
    //   709: iload 4
    //   711: sipush 400
    //   714: if_icmple -70 -> 644
    //   717: iload_0
    //   718: bipush 10
    //   720: invokestatic 290	com/tencent/mm/plugin/webview/h/a:gH	(II)V
    //   723: goto -79 -> 644
    //   726: astore 6
    //   728: goto -410 -> 318
    //   731: astore_2
    //   732: goto -70 -> 662
    //   735: astore_2
    //   736: goto -184 -> 552
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	739	0	paramInt	int
    //   0	739	1	paramString1	String
    //   0	739	2	paramMap	Map<String, String>
    //   0	739	3	paramString2	String
    //   204	511	4	i	int
    //   635	37	5	bool	boolean
    //   50	443	6	localObject1	Object
    //   540	15	6	localThrowable1	Throwable
    //   726	1	6	localThrowable2	Throwable
    //   13	625	7	locala	a
    //   23	459	8	localo	com.tencent.mm.vfs.o
    //   160	503	9	localHttpURLConnection	java.net.HttpURLConnection
    //   268	304	10	localObject2	Object
    //   479	51	11	locald	kotlin.g.b.z.d
    //   499	27	12	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   39	52	76	java/io/FileNotFoundException
    //   57	76	76	java/io/FileNotFoundException
    //   155	162	76	java/io/FileNotFoundException
    //   301	308	76	java/io/FileNotFoundException
    //   313	318	76	java/io/FileNotFoundException
    //   318	331	76	java/io/FileNotFoundException
    //   648	654	76	java/io/FileNotFoundException
    //   658	662	76	java/io/FileNotFoundException
    //   662	667	76	java/io/FileNotFoundException
    //   162	190	291	java/lang/Throwable
    //   194	203	291	java/lang/Throwable
    //   211	248	291	java/lang/Throwable
    //   248	288	291	java/lang/Throwable
    //   410	452	291	java/lang/Throwable
    //   460	491	291	java/lang/Throwable
    //   552	567	291	java/lang/Throwable
    //   571	618	291	java/lang/Throwable
    //   622	634	291	java/lang/Throwable
    //   637	644	291	java/lang/Throwable
    //   644	648	291	java/lang/Throwable
    //   676	692	291	java/lang/Throwable
    //   700	706	291	java/lang/Throwable
    //   717	723	291	java/lang/Throwable
    //   162	190	300	finally
    //   194	203	300	finally
    //   211	248	300	finally
    //   248	288	300	finally
    //   292	300	300	finally
    //   410	452	300	finally
    //   460	491	300	finally
    //   552	567	300	finally
    //   571	618	300	finally
    //   622	634	300	finally
    //   637	644	300	finally
    //   644	648	300	finally
    //   676	692	300	finally
    //   700	706	300	finally
    //   717	723	300	finally
    //   39	52	331	java/io/IOException
    //   57	76	331	java/io/IOException
    //   155	162	331	java/io/IOException
    //   301	308	331	java/io/IOException
    //   313	318	331	java/io/IOException
    //   318	331	331	java/io/IOException
    //   648	654	331	java/io/IOException
    //   658	662	331	java/io/IOException
    //   662	667	331	java/io/IOException
    //   494	501	540	java/lang/Throwable
    //   501	519	540	java/lang/Throwable
    //   525	537	540	java/lang/Throwable
    //   567	571	540	java/lang/Throwable
    //   542	551	551	finally
    //   301	308	726	java/lang/Throwable
    //   313	318	726	java/lang/Throwable
    //   648	654	731	java/lang/Throwable
    //   658	662	731	java/lang/Throwable
    //   494	501	735	finally
    //   501	519	735	finally
    //   525	537	735	finally
    //   567	571	735	finally
  }
  
  private static eib a(eib parameib, int paramInt, String paramString)
  {
    AppMethodBeat.i(6848);
    parameib.oUv = paramInt;
    parameib.LQx = paramString;
    byte[] arrayOfByte = u.coo().decodeBytes(u.e(parameib));
    int i;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {}
      try
      {
        parameib.parseFrom(arrayOfByte);
        AppMethodBeat.o(6848);
        return parameib;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", (Throwable)localException, "decode TmplInfo:" + paramInt + ", " + paramString, new Object[0]);
        }
      }
    }
  }
  
  public static final void a(int paramInt, String paramString, int... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6844);
        p.h(paramString, "netType");
        p.h(paramVarArgs, "tmplTypes");
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          Log.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
          AppMethodBeat.o(6844);
          return;
        }
        paramVarArgs = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.pCC;
        if ((!BuildInfo.IS_FLAVOR_RED) && (k.cdi().getInt("preload_type", 1) == 3))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.o.fh("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
          AppMethodBeat.o(6844);
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
    if (paramInt == -1) {
      pFp.clear();
    }
    LinkedList localLinkedList = new LinkedList();
    paramVarArgs = coQ();
    Object localObject1 = (Collection)new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    label150:
    Object localObject2;
    if (i < j)
    {
      int m = paramVarArgs[i];
      int k = ((Number)m).intValue();
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.pCC;
      boolean bool;
      if (k.cdi().getBoolean("preload_tmpl_always_check_tmpl_ver", false)) {
        bool = true;
      }
      while (bool)
      {
        ((Collection)localObject1).add(m);
        break;
        long l = 0L;
        if (pFp.containsKey(Integer.valueOf(k)))
        {
          localObject2 = pFp.get(Integer.valueOf(k));
          if (localObject2 == null) {
            p.hyc();
          }
          l = ((Number)localObject2).longValue();
        }
        if (pFq.contains(Integer.valueOf(k)))
        {
          Log.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(k) });
          bool = false;
        }
        else
        {
          bool = MMSlotKt.isExpire(l, u.coo().getLong("_check_time_colddown", pFo));
        }
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    label585:
    label714:
    label717:
    for (;;)
    {
      label335:
      zr localzr;
      if (((Iterator)localObject1).hasNext())
      {
        i = ((Number)((Iterator)localObject1).next()).intValue();
        pFq.add(Integer.valueOf(i));
        ((Map)pFp).put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        localzr = new zr();
        localzr.oUv = i;
        if (m.CR(101)) {
          localzr.LkX = u.con();
        }
        localLinkedList.add(localzr);
        paramVarArgs = DD(i);
        if (!u.a(paramVarArgs)) {
          continue;
        }
        if (u.ain(u.b(paramVarArgs))) {
          localzr.LkW = paramVarArgs.LQx;
        }
        localObject2 = u.coo().getStringSet(u.h(paramVarArgs), null);
        if (localObject2 == null) {
          break label709;
        }
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          String str = (String)localObject4;
          eib localeib = new eib();
          p.g(str, "it");
          if (a(a(localeib, i, str), paramVarArgs)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        paramVarArgs = (List)localObject2;
        localObject2 = (Collection)paramVarArgs;
        if (localObject2 == null) {
          break label704;
        }
        if (!((Collection)localObject2).isEmpty()) {
          break label714;
        }
        break label704;
      }
      for (;;)
      {
        if (i != 0) {
          break label717;
        }
        localzr.LkV.addAll((Collection)paramVarArgs);
        break label335;
        if (!((Collection)localLinkedList).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.plugin.webview.h.a.pl(0);
            new a(localLinkedList, paramInt, paramString).aYI().g((com.tencent.mm.vending.c.a)new b.c(paramInt, localLinkedList));
          }
          AppMethodBeat.o(6844);
          break;
        }
        i += 1;
        break label150;
        i = 1;
        continue;
        paramVarArgs = null;
        break label585;
        i = 0;
      }
    }
  }
  
  public static void a(eic parameic, boolean paramBoolean)
  {
    AppMethodBeat.i(195762);
    p.h(parameic, "tmplParams");
    String str = "_tmpl_info_inject_fail_-" + parameic.pCV + '-' + parameic.hFF;
    if (paramBoolean)
    {
      u.coo().removeValueForKey(str);
      AppMethodBeat.o(195762);
      return;
    }
    int i = u.coo().getInt(str, 0) + 1;
    u.coo().putInt(str, i);
    Log.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + parameic.pCV + ',' + parameic.hFF + ',' + i);
    if (i > 2)
    {
      com.tencent.mm.plugin.webview.h.a.pl(219);
      Log.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + parameic.pCV + ',' + parameic.hFF + ',' + i);
    }
    AppMethodBeat.o(195762);
  }
  
  private static boolean a(eib parameib1, eib parameib2)
  {
    AppMethodBeat.i(6849);
    if (u.aim(u.b(parameib1)).exists())
    {
      if (b(parameib1, parameib2))
      {
        u.coo().putString(u.f(parameib1), parameib1.LQx);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.b(u.coo(), u.g(parameib1));
        AppMethodBeat.o(6849);
        return true;
      }
      if (p.j(u.e(parameib1), u.coo().getString(u.f(parameib1), null)))
      {
        u.coo().removeValueForKey(u.f(parameib1));
        u.coo().removeValueForKey(u.g(parameib1));
      }
      u.coo().remove(u.e(parameib1));
      parameib2 = u.h(parameib2);
      Set localSet = u.coo().getStringSet(parameib2, null);
      if (localSet != null)
      {
        localSet.remove(parameib1.LQx);
        u.coo().putStringSet(parameib2, localSet);
      }
      Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + parameib1.LQx + " is invalid");
    }
    for (;;)
    {
      AppMethodBeat.o(6849);
      return false;
      Log.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + parameib1.LQx);
    }
  }
  
  private static eib aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(6852);
    eib localeib1 = DC(paramInt);
    if (u.a(localeib1))
    {
      if ((u.ain(u.b(localeib1))) && ((p.j(localeib1.LQx, paramString) ^ true)))
      {
        AppMethodBeat.o(6852);
        return localeib1;
      }
      Object localObject1 = u.coo().getString(u.f(localeib1), null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new eib();
        p.g(localObject1, "it");
        localObject1 = a((eib)localObject2, paramInt, (String)localObject1);
        if ((localObject1 != null) && (u.a((eib)localObject1)) && (!u.i((eib)localObject1)) && (u.ain(u.b((eib)localObject1))) && ((p.j(((eib)localObject1).LQx, paramString) ^ true)))
        {
          AppMethodBeat.o(6852);
          return localObject1;
        }
      }
      localObject1 = u.coo().getStringSet(u.h(localeib1), null);
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        p.h(localObject1, "$this$sortedDescending");
        localObject2 = kotlin.b.f.SXy;
        if (localObject2 == null)
        {
          paramString = new t("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
          AppMethodBeat.o(6852);
          throw paramString;
        }
        localObject1 = kotlin.a.j.a((Iterable)localObject1, (Comparator)localObject2);
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if ((p.j(localObject2, paramString) ^ true))
            {
              eib localeib2 = new eib();
              p.g(localObject2, "uid");
              localObject2 = a(localeib2, paramInt, (String)localObject2);
              if (a((eib)localObject2, localeib1))
              {
                AppMethodBeat.o(6852);
                return localObject2;
              }
            }
          }
        }
      }
    }
    paramString = new eib();
    AppMethodBeat.o(6852);
    return paramString;
  }
  
  private static boolean b(eib parameib1, eib parameib2)
  {
    AppMethodBeat.i(6850);
    if ((p.j(parameib1, parameib2)) && (parameib1.Version != 0))
    {
      AppMethodBeat.o(6850);
      return true;
    }
    int i = parameib2.Lla;
    Object localObject;
    if (Log.getLogLevel() == 0)
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.pCC;
      int j = j.a.cnZ();
      if (j > 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (parameib1.Version < i)
      {
        Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + parameib1.LQx + " version:" + parameib1.Version + " < " + i);
        AppMethodBeat.o(6850);
        return false;
      }
      parameib2 = parameib2.Nhp;
      p.g(parameib2, "standard.VersionControlList");
      parameib2 = ((Iterable)parameib2).iterator();
      while (parameib2.hasNext())
      {
        localObject = (eid)parameib2.next();
        if (p.j(((eid)localObject).LQx, parameib1.LQx))
        {
          Log.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + ((eid)localObject).LQx + " matchControls in forceH5:" + ((eid)localObject).Nht);
          if (!((eid)localObject).Nht)
          {
            AppMethodBeat.o(6850);
            return true;
          }
          AppMethodBeat.o(6850);
          return false;
        }
      }
      AppMethodBeat.o(6850);
      return true;
    }
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(6845);
    u.coo().clear();
    s.dy(coS(), true);
    s.deleteDir(com.tencent.mm.loader.j.b.aKB() + "/jscache/");
    AppMethodBeat.o(6845);
  }
  
  public static Integer[] coQ()
  {
    AppMethodBeat.i(6841);
    Integer[] arrayOfInteger = (Integer[])pFn.getValue();
    AppMethodBeat.o(6841);
    return arrayOfInteger;
  }
  
  public static final void coR()
  {
    AppMethodBeat.i(6855);
    h.RTc.b((Runnable)d.pFw, "tmplPreload");
    AppMethodBeat.o(6855);
  }
  
  public static final String coS()
  {
    AppMethodBeat.i(6857);
    String str = com.tencent.mm.loader.j.b.aKB() + "webview_tmpl/";
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.pCC;
    if (j.a.cnY())
    {
      str = com.tencent.mm.loader.j.b.aKJ();
      p.g(str, "CConstants.DATAROOT_SDCARD_PATH()");
    }
    localObject = str;
    if (!n.K(str, "/", false)) {
      localObject = str + "/";
    }
    str = (String)localObject + "tmpls/";
    FilePathGenerator.checkMkdir(str);
    AppMethodBeat.o(6857);
    return str;
  }
  
  public static final String coT()
  {
    AppMethodBeat.i(195764);
    String str = pFm;
    p.g(str, "HARDCODE_URL");
    AppMethodBeat.o(195764);
    return str;
  }
  
  private static boolean d(String paramString, com.tencent.mm.vfs.o paramo)
  {
    AppMethodBeat.i(175496);
    if ((!Util.isNullOrNil(paramString)) && (p.j(paramString, s.bhK(paramo.getPath()))))
    {
      AppMethodBeat.o(175496);
      return true;
    }
    Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", new Object[] { paramo.getAbsolutePath() });
    AppMethodBeat.o(175496);
    return false;
  }
  
  /* Error */
  private static boolean fk(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 6861
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1305	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1306	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: checkcast 530	java/io/Closeable
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 1305	java/util/zip/ZipFile
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 1310	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   27: astore 6
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 7
    //   36: new 521	kotlin/g/b/z$d
    //   39: dup
    //   40: invokespecial 522	kotlin/g/b/z$d:<init>	()V
    //   43: astore 8
    //   45: aload 6
    //   47: invokeinterface 1315 1 0
    //   52: ifeq +361 -> 413
    //   55: aload 6
    //   57: invokeinterface 1318 1 0
    //   62: checkcast 1320	java/util/zip/ZipEntry
    //   65: astore 4
    //   67: aload 4
    //   69: ldc_w 1322
    //   72: invokestatic 223	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 4
    //   77: invokevirtual 1323	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ldc_w 1325
    //   87: invokestatic 223	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload 5
    //   92: checkcast 871	java/lang/CharSequence
    //   95: ldc_w 1327
    //   98: iconst_0
    //   99: iconst_0
    //   100: bipush 6
    //   102: invokestatic 1330	kotlin/n/n:a	(Ljava/lang/CharSequence;Ljava/lang/String;IZI)I
    //   105: iconst_m1
    //   106: if_icmpeq +46 -> 152
    //   109: ldc 242
    //   111: ldc_w 1332
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 5
    //   122: aastore
    //   123: invokestatic 1047	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -81 -> 45
    //   129: astore_1
    //   130: sipush 6861
    //   133: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_3
    //   140: aload_1
    //   141: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: sipush 6861
    //   147: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: new 404	com/tencent/mm/vfs/o
    //   155: dup
    //   156: new 244	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 405	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: aload 5
    //   182: invokevirtual 1335	com/tencent/mm/vfs/o:getParent	()Ljava/lang/String;
    //   185: astore 9
    //   187: aload 9
    //   189: ifnonnull +6 -> 195
    //   192: invokestatic 764	kotlin/g/b/p:hyc	()V
    //   195: new 404	com/tencent/mm/vfs/o
    //   198: dup
    //   199: aload 9
    //   201: invokespecial 405	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   204: astore 9
    //   206: aload 9
    //   208: invokevirtual 408	com/tencent/mm/vfs/o:exists	()Z
    //   211: ifne +9 -> 220
    //   214: aload 9
    //   216: invokevirtual 1338	com/tencent/mm/vfs/o:mkdirs	()Z
    //   219: pop
    //   220: aload 4
    //   222: invokevirtual 1339	java/util/zip/ZipEntry:isDirectory	()Z
    //   225: ifeq +20 -> 245
    //   228: aload 5
    //   230: invokevirtual 408	com/tencent/mm/vfs/o:exists	()Z
    //   233: ifne -188 -> 45
    //   236: aload 5
    //   238: invokevirtual 1342	com/tencent/mm/vfs/o:mkdir	()Z
    //   241: pop
    //   242: goto -197 -> 45
    //   245: aload 5
    //   247: invokevirtual 408	com/tencent/mm/vfs/o:exists	()Z
    //   250: ifne +9 -> 259
    //   253: aload 5
    //   255: invokevirtual 519	com/tencent/mm/vfs/o:createNewFile	()Z
    //   258: pop
    //   259: aload_0
    //   260: aload 4
    //   262: invokevirtual 1345	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   265: checkcast 530	java/io/Closeable
    //   268: astore 4
    //   270: aload 4
    //   272: checkcast 488	java/io/InputStream
    //   275: astore 9
    //   277: new 1347	java/io/BufferedOutputStream
    //   280: dup
    //   281: aload 5
    //   283: invokestatic 528	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   286: invokespecial 1350	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   289: checkcast 530	java/io/Closeable
    //   292: astore 5
    //   294: aload 5
    //   296: checkcast 1347	java/io/BufferedOutputStream
    //   299: astore 10
    //   301: aload 9
    //   303: aload 7
    //   305: invokevirtual 536	java/io/InputStream:read	([B)I
    //   308: istore_2
    //   309: aload 8
    //   311: iload_2
    //   312: putfield 539	kotlin/g/b/z$d:SYE	I
    //   315: iload_2
    //   316: ifle +67 -> 383
    //   319: aload 10
    //   321: aload 7
    //   323: iconst_0
    //   324: aload 8
    //   326: getfield 539	kotlin/g/b/z$d:SYE	I
    //   329: invokevirtual 1351	java/io/BufferedOutputStream:write	([BII)V
    //   332: goto -31 -> 301
    //   335: astore_1
    //   336: sipush 6861
    //   339: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload_1
    //   343: athrow
    //   344: astore_0
    //   345: aload 5
    //   347: aload_1
    //   348: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   351: sipush 6861
    //   354: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aload_0
    //   358: athrow
    //   359: astore_1
    //   360: sipush 6861
    //   363: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: astore_0
    //   369: aload 4
    //   371: aload_1
    //   372: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   375: sipush 6861
    //   378: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_0
    //   382: athrow
    //   383: aload 10
    //   385: invokevirtual 1354	java/io/BufferedOutputStream:flush	()V
    //   388: getstatic 554	kotlin/x:SXb	Lkotlin/x;
    //   391: astore 9
    //   393: aload 5
    //   395: aconst_null
    //   396: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   399: getstatic 554	kotlin/x:SXb	Lkotlin/x;
    //   402: astore 5
    //   404: aload 4
    //   406: aconst_null
    //   407: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   410: goto -365 -> 45
    //   413: aload_3
    //   414: aconst_null
    //   415: invokestatic 548	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   418: sipush 6861
    //   421: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: iconst_1
    //   425: ireturn
    //   426: astore_0
    //   427: aconst_null
    //   428: astore_1
    //   429: goto -60 -> 369
    //   432: astore_0
    //   433: aconst_null
    //   434: astore_1
    //   435: goto -90 -> 345
    //   438: astore_0
    //   439: aconst_null
    //   440: astore_1
    //   441: goto -302 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	paramString1	String
    //   0	444	1	paramString2	String
    //   308	8	2	i	int
    //   17	397	3	localCloseable	java.io.Closeable
    //   65	340	4	localObject1	Object
    //   80	323	5	localObject2	Object
    //   27	29	6	localEnumeration	java.util.Enumeration
    //   34	288	7	arrayOfByte	byte[]
    //   43	282	8	locald	kotlin.g.b.z.d
    //   185	207	9	localObject3	Object
    //   299	85	10	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	45	129	java/lang/Throwable
    //   45	126	129	java/lang/Throwable
    //   152	187	129	java/lang/Throwable
    //   192	195	129	java/lang/Throwable
    //   195	220	129	java/lang/Throwable
    //   220	242	129	java/lang/Throwable
    //   245	259	129	java/lang/Throwable
    //   259	270	129	java/lang/Throwable
    //   369	383	129	java/lang/Throwable
    //   404	410	129	java/lang/Throwable
    //   130	138	138	finally
    //   294	301	335	java/lang/Throwable
    //   301	315	335	java/lang/Throwable
    //   319	332	335	java/lang/Throwable
    //   383	393	335	java/lang/Throwable
    //   336	344	344	finally
    //   270	294	359	java/lang/Throwable
    //   345	359	359	java/lang/Throwable
    //   393	404	359	java/lang/Throwable
    //   360	368	368	finally
    //   270	294	426	finally
    //   345	359	426	finally
    //   393	404	426	finally
    //   294	301	432	finally
    //   301	315	432	finally
    //   319	332	432	finally
    //   383	393	432	finally
    //   18	45	438	finally
    //   45	126	438	finally
    //   152	187	438	finally
    //   192	195	438	finally
    //   195	220	438	finally
    //   220	242	438	finally
    //   245	259	438	finally
    //   259	270	438	finally
    //   369	383	438	finally
    //   404	410	438	finally
  }
  
  public static final String getPrefix()
  {
    AppMethodBeat.i(195765);
    String str = PREFIX;
    p.g(str, "PREFIX");
    AppMethodBeat.o(195765);
    return str;
  }
  
  public static final void j(eib parameib)
  {
    AppMethodBeat.i(6847);
    p.h(parameib, "tmplInfo");
    Object localObject1 = u.e(parameib);
    Object localObject2 = parameib.LQx;
    u.coo().putString(u.Dx(parameib.oUv), (String)localObject2);
    u.coo().removeValueForKey(u.f(parameib));
    u.coo().removeValueForKey(u.g(parameib));
    u.coo().encode((String)localObject1, parameib.toByteArray());
    String str = u.h(parameib);
    MultiProcessMMKV localMultiProcessMMKV = u.coo();
    localObject2 = u.coo().getStringSet(str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Set)new HashSet();
    }
    ((Set)localObject1).add(parameib.LQx);
    localMultiProcessMMKV.putStringSet(str, (Set)localObject1);
    AppMethodBeat.o(6847);
  }
  
  private static final boolean k(eib parameib)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6854);
        if (parameib == null)
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
          AppMethodBeat.o(6854);
          return bool;
        }
        if (!u.a(parameib))
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
          AppMethodBeat.o(6854);
          continue;
        }
        if (DC(parameib.oUv).Version == parameib.Version) {
          break label90;
        }
      }
      finally {}
      AppMethodBeat.o(6854);
      continue;
      label90:
      if (!u.ain(u.b(parameib)))
      {
        Log.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
        AppMethodBeat.o(6854);
      }
      else
      {
        bool = true;
        AppMethodBeat.o(6854);
      }
    }
  }
  
  private static String l(eib parameib)
  {
    AppMethodBeat.i(6858);
    parameib = "Type:" + parameib.oUv + " Version:" + parameib.Version + " CdnUrl:" + parameib.KUA + " Md5:" + parameib.Md5;
    AppMethodBeat.o(6858);
    return parameib;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "", "()V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "isZip", "", "()Z", "setZip", "(Z)V", "patchBase", "", "getPatchBase", "()Ljava/lang/String;", "setPatchBase", "(Ljava/lang/String;)V", "patchMD5", "getPatchMD5", "setPatchMD5", "success", "getSuccess", "setSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    Exception exception;
    boolean kwO;
    String pFs;
    String pFt;
    boolean success;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d pFw;
    
    static
    {
      AppMethodBeat.i(6831);
      pFw = new d();
      AppMethodBeat.o(6831);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6830);
      b.coV();
      AppMethodBeat.o(6830);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b
 * JD-Core Version:    0.7.0.1
 */