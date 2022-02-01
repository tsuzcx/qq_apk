package com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.protocal.protobuf.esf;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "kotlin.jvm.PlatformType", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplType", "download", "url", "tmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Lcom/tencent/mm/vfs/VFSFile;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", "dir", "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "debugInfo", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"})
public final class b
{
  private static final String sQA;
  private static final String sQB;
  private static final kotlin.f sQC;
  private static final int sQD = 60000;
  private static final ConcurrentHashMap<Integer, Long> sQE;
  private static final ArrayList<Integer> sQF;
  public static final b sQG;
  
  static
  {
    AppMethodBeat.i(6840);
    sQG = new b();
    String str = com.tencent.mm.plugin.webview.h.a.sQA;
    sQA = str;
    sQB = str;
    sQC = g.ar((kotlin.g.a.a)b.sQJ);
    sQD = 60000;
    sQE = new ConcurrentHashMap();
    sQF = new ArrayList();
    int i = 0;
    if (i <= 2)
    {
      str = "_webview_tmpl_cache_slot_".concat(String.valueOf(i));
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(str);
      long l = localMultiProcessMMKV.totalSize();
      if (l > 0L)
      {
        String[] arrayOfString = localMultiProcessMMKV.allKeys();
        if (arrayOfString != null)
        {
          if (arrayOfString.length != 0) {
            break label178;
          }
          j = 1;
          label125:
          if (j == 0) {
            break label183;
          }
        }
      }
      label178:
      label183:
      for (int j = 1;; j = 0)
      {
        if (j == 0)
        {
          localMultiProcessMMKV.clearAll();
          Log.i("MicroMsg.Preload.TmplInfoManager", "clear " + str + " totalSize:" + l);
        }
        i += 1;
        break;
        j = 0;
        break label125;
      }
    }
    AppMethodBeat.o(6840);
  }
  
  private static String Hj(int paramInt)
  {
    AppMethodBeat.i(6842);
    String str = "_tmpl_download_time_".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6842);
    return str;
  }
  
  public static final void Hk(int paramInt)
  {
    AppMethodBeat.i(6846);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().putLong("_check_time_colddown", paramInt * 1000);
    AppMethodBeat.o(6846);
  }
  
  public static final esd Hl(int paramInt)
  {
    AppMethodBeat.i(6851);
    esd localesd = new esd();
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.Hg(paramInt), null);
    if (str != null)
    {
      p.j(str, "uid");
      a(localesd, paramInt, str);
    }
    AppMethodBeat.o(6851);
    return localesd;
  }
  
  public static final ese Hn(int paramInt)
  {
    AppMethodBeat.i(264782);
    Object localObject2 = Hm(paramInt);
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a((esd)localObject2))
    {
      Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + paramInt + " localTmplInfo is null");
      com.tencent.mm.plugin.webview.h.a.rE(100);
      AppMethodBeat.o(264782);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.c((esd)localObject2);
    if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.apZ((String)localObject1))
    {
      Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + (String)localObject1 + " is null");
      if (((esd)localObject2).Uet > 0) {
        com.tencent.mm.plugin.webview.h.a.gU(((esd)localObject2).Uet, 100);
      }
      AppMethodBeat.o(264782);
      return null;
    }
    ese localese = new ese();
    localese.sNh = paramInt;
    localese.version = ((esd)localObject2).rWt;
    localese.md5 = ((esd)localObject2).Md5;
    localese.UtX = ((String)localObject1);
    Object localObject3 = new StringBuilder().append(sQA).append(paramInt).append('_').append(((esd)localObject2).SYY).append(".html");
    if ((p.h(sQB, sQA) ^ true)) {}
    for (localObject1 = "?prefix=" + URLEncoder.encode(sQB);; localObject1 = "")
    {
      localese.POG = ((String)localObject1);
      localese.smT = ((esd)localObject2).RVF;
      localese.reportId = ((esd)localObject2).Uet;
      localese.KcG = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getLong(Hj(((esd)localObject2).rWu), 0L);
      localese.ktM = ((esd)localObject2).SYY;
      localObject1 = ((esd)localObject2).UtT;
      p.j(localObject1, "tmplInfo.HttpHeaderList");
      localObject2 = (Iterable)localObject1;
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (esc)((Iterator)localObject2).next();
        localObject1 = ((StringBuilder)localObject1).append("\n" + ((esc)localObject3).CRg + ':' + ((esc)localObject3).Izj);
        p.j(localObject1, "sb.append(\"\\n${header.Key}:${header.Value}\")");
      }
    }
    localese.UtY = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(264782);
    return localese;
  }
  
  /* Error */
  private static a a(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: sipush 6862
    //   3: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a
    //   9: dup
    //   10: invokespecial 436	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:<init>	()V
    //   13: astore 7
    //   15: new 438	com/tencent/mm/vfs/q
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 439	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   23: astore 8
    //   25: aload 8
    //   27: invokevirtual 442	com/tencent/mm/vfs/q:ifE	()Z
    //   30: ifeq +9 -> 39
    //   33: aload 8
    //   35: invokevirtual 445	com/tencent/mm/vfs/q:cFq	()Z
    //   38: pop
    //   39: new 447	java/net/URL
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 448	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 452	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnonnull +101 -> 155
    //   57: new 454	kotlin/t
    //   60: dup
    //   61: ldc_w 456
    //   64: invokespecial 457	kotlin/t:<init>	(Ljava/lang/String;)V
    //   67: astore_2
    //   68: sipush 6862
    //   71: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: ldc 210
    //   79: aload_2
    //   80: checkcast 435	java/lang/Throwable
    //   83: new 212	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 459
    //   90: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 461
    //   100: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 7
    //   119: aload_2
    //   120: checkcast 467	java/lang/Exception
    //   123: putfield 471	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:exception	Ljava/lang/Exception;
    //   126: iload_0
    //   127: bipush 7
    //   129: invokestatic 324	com/tencent/mm/plugin/webview/h/a:gU	(II)V
    //   132: aload 8
    //   134: invokevirtual 442	com/tencent/mm/vfs/q:ifE	()Z
    //   137: ifeq +9 -> 146
    //   140: aload 8
    //   142: invokevirtual 445	com/tencent/mm/vfs/q:cFq	()Z
    //   145: pop
    //   146: sipush 6862
    //   149: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 7
    //   154: areturn
    //   155: aload 6
    //   157: checkcast 473	java/net/HttpURLConnection
    //   160: astore 9
    //   162: aload 9
    //   164: ldc_w 475
    //   167: ldc_w 477
    //   170: invokevirtual 480	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 9
    //   175: ldc_w 475
    //   178: ldc_w 482
    //   181: invokevirtual 480	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 9
    //   186: iconst_0
    //   187: invokevirtual 486	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   190: aload_2
    //   191: ifnull +219 -> 410
    //   194: aload_2
    //   195: invokeinterface 491 1 0
    //   200: ifne +204 -> 404
    //   203: iconst_1
    //   204: istore 4
    //   206: iload 4
    //   208: ifeq +202 -> 410
    //   211: ldc 210
    //   213: ldc_w 493
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_2
    //   223: invokeinterface 497 1 0
    //   228: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 505	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_2
    //   236: invokeinterface 509 1 0
    //   241: invokeinterface 512 1 0
    //   246: astore 6
    //   248: aload 6
    //   250: invokeinterface 408 1 0
    //   255: ifeq +155 -> 410
    //   258: aload 6
    //   260: invokeinterface 412 1 0
    //   265: checkcast 185	java/lang/String
    //   268: astore 10
    //   270: aload 9
    //   272: aload 10
    //   274: aload_2
    //   275: aload 10
    //   277: invokeinterface 516 2 0
    //   282: checkcast 185	java/lang/String
    //   285: invokevirtual 480	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -40 -> 248
    //   291: astore_2
    //   292: sipush 6862
    //   295: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_2
    //   299: athrow
    //   300: astore_2
    //   301: aload 9
    //   303: invokevirtual 520	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   306: astore 6
    //   308: aload 6
    //   310: ifnull +8 -> 318
    //   313: aload 6
    //   315: invokevirtual 525	java/io/InputStream:close	()V
    //   318: aload 9
    //   320: invokevirtual 528	java/net/HttpURLConnection:disconnect	()V
    //   323: sipush 6862
    //   326: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload_2
    //   330: athrow
    //   331: astore_2
    //   332: ldc 210
    //   334: aload_2
    //   335: checkcast 435	java/lang/Throwable
    //   338: new 212	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 530
    //   345: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload_3
    //   349: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 461
    //   355: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: aload 7
    //   374: aload_2
    //   375: checkcast 467	java/lang/Exception
    //   378: putfield 471	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:exception	Ljava/lang/Exception;
    //   381: iload_0
    //   382: bipush 7
    //   384: invokestatic 324	com/tencent/mm/plugin/webview/h/a:gU	(II)V
    //   387: aload 8
    //   389: invokevirtual 442	com/tencent/mm/vfs/q:ifE	()Z
    //   392: ifeq -246 -> 146
    //   395: aload 8
    //   397: invokevirtual 445	com/tencent/mm/vfs/q:cFq	()Z
    //   400: pop
    //   401: goto -255 -> 146
    //   404: iconst_0
    //   405: istore 4
    //   407: goto -201 -> 206
    //   410: aload 9
    //   412: iconst_0
    //   413: invokevirtual 533	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   416: aload 9
    //   418: ldc_w 535
    //   421: invokevirtual 538	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   424: aload 9
    //   426: sipush 10000
    //   429: invokevirtual 541	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   432: aload 9
    //   434: sipush 3000
    //   437: invokevirtual 544	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   440: aload 9
    //   442: invokevirtual 547	java/net/HttpURLConnection:connect	()V
    //   445: aload 9
    //   447: invokevirtual 550	java/net/HttpURLConnection:getResponseCode	()I
    //   450: istore 4
    //   452: iload 4
    //   454: sipush 200
    //   457: if_icmpne +219 -> 676
    //   460: aload 8
    //   462: invokevirtual 553	com/tencent/mm/vfs/q:ifM	()Z
    //   465: pop
    //   466: sipush 8192
    //   469: newarray byte
    //   471: astore_2
    //   472: new 555	kotlin/g/b/aa$d
    //   475: dup
    //   476: invokespecial 556	kotlin/g/b/aa$d:<init>	()V
    //   479: astore 11
    //   481: aload 8
    //   483: invokestatic 562	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   486: checkcast 564	java/io/Closeable
    //   489: astore 10
    //   491: aconst_null
    //   492: astore 6
    //   494: aload 10
    //   496: checkcast 566	java/io/OutputStream
    //   499: astore 12
    //   501: aload 9
    //   503: invokevirtual 520	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   506: aload_2
    //   507: invokevirtual 570	java/io/InputStream:read	([B)I
    //   510: istore 4
    //   512: aload 11
    //   514: iload 4
    //   516: putfield 573	kotlin/g/b/aa$d:aaBA	I
    //   519: iload 4
    //   521: iconst_m1
    //   522: if_icmpeq +45 -> 567
    //   525: aload 12
    //   527: aload_2
    //   528: iconst_0
    //   529: aload 11
    //   531: getfield 573	kotlin/g/b/aa$d:aaBA	I
    //   534: invokevirtual 577	java/io/OutputStream:write	([BII)V
    //   537: goto -36 -> 501
    //   540: astore 6
    //   542: sipush 6862
    //   545: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: aload 6
    //   550: athrow
    //   551: astore_2
    //   552: aload 10
    //   554: aload 6
    //   556: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   559: sipush 6862
    //   562: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload_2
    //   566: athrow
    //   567: getstatic 588	kotlin/x:aazN	Lkotlin/x;
    //   570: astore_2
    //   571: aload 10
    //   573: aconst_null
    //   574: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   577: aload 7
    //   579: iconst_1
    //   580: putfield 591	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:success	Z
    //   583: aload 7
    //   585: aload 9
    //   587: ldc_w 593
    //   590: invokevirtual 596	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   593: putfield 599	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:sQH	Ljava/lang/String;
    //   596: aload 7
    //   598: aload 9
    //   600: ldc_w 601
    //   603: invokevirtual 596	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   606: putfield 604	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:sQI	Ljava/lang/String;
    //   609: aload 9
    //   611: ldc_w 606
    //   614: invokevirtual 596	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   617: astore_2
    //   618: aload_2
    //   619: ifnull +51 -> 670
    //   622: ldc_w 608
    //   625: aload_2
    //   626: invokestatic 357	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   629: iconst_1
    //   630: ixor
    //   631: ifeq +39 -> 670
    //   634: iconst_1
    //   635: istore 5
    //   637: aload 7
    //   639: iload 5
    //   641: putfield 611	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:npI	Z
    //   644: getstatic 588	kotlin/x:aazN	Lkotlin/x;
    //   647: astore_2
    //   648: aload 9
    //   650: invokevirtual 520	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   653: astore_2
    //   654: aload_2
    //   655: ifnull +7 -> 662
    //   658: aload_2
    //   659: invokevirtual 525	java/io/InputStream:close	()V
    //   662: aload 9
    //   664: invokevirtual 528	java/net/HttpURLConnection:disconnect	()V
    //   667: goto -521 -> 146
    //   670: iconst_0
    //   671: istore 5
    //   673: goto -36 -> 637
    //   676: ldc 210
    //   678: ldc_w 613
    //   681: iload 4
    //   683: invokestatic 188	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   686: invokevirtual 192	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   689: invokestatic 302	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: iload 4
    //   694: sipush 500
    //   697: if_icmple +12 -> 709
    //   700: iload_0
    //   701: bipush 11
    //   703: invokestatic 324	com/tencent/mm/plugin/webview/h/a:gU	(II)V
    //   706: goto -62 -> 644
    //   709: iload 4
    //   711: sipush 400
    //   714: if_icmple -70 -> 644
    //   717: iload_0
    //   718: bipush 10
    //   720: invokestatic 324	com/tencent/mm/plugin/webview/h/a:gU	(II)V
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
    //   23	459	8	localq	com.tencent.mm.vfs.q
    //   160	503	9	localHttpURLConnection	java.net.HttpURLConnection
    //   268	304	10	localObject2	Object
    //   479	51	11	locald	kotlin.g.b.aa.d
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
  
  private static esd a(esd paramesd, int paramInt, String paramString)
  {
    AppMethodBeat.i(6848);
    paramesd.rWu = paramInt;
    paramesd.SYY = paramString;
    byte[] arrayOfByte = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().decodeBytes(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.e(paramesd));
    int i;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {}
      try
      {
        paramesd.parseFrom(arrayOfByte);
        AppMethodBeat.o(6848);
        return paramesd;
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
        p.k(paramString, "netType");
        p.k(paramVarArgs, "tmplTypes");
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          Log.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
          AppMethodBeat.o(6844);
          return;
        }
        paramVarArgs = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.sMO;
        if ((!BuildInfo.IS_FLAVOR_RED) && (k.cqu().getInt("preload_type", 1) == 3))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          o.fv("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
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
      sQE.clear();
    }
    final LinkedList localLinkedList = new LinkedList();
    paramVarArgs = cDm();
    Object localObject1 = (Collection)new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    label150:
    Object localObject2;
    if (i < j)
    {
      int m = paramVarArgs[i];
      int k = ((Number)m).intValue();
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.sMO;
      boolean bool;
      if (k.cqu().getBoolean("preload_tmpl_always_check_tmpl_ver", false)) {
        bool = true;
      }
      while (bool)
      {
        ((Collection)localObject1).add(m);
        break;
        long l = 0L;
        if (sQE.containsKey(Integer.valueOf(k)))
        {
          localObject2 = sQE.get(Integer.valueOf(k));
          if (localObject2 == null) {
            p.iCn();
          }
          l = ((Number)localObject2).longValue();
        }
        if (sQF.contains(Integer.valueOf(k)))
        {
          Log.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(k) });
          bool = false;
        }
        else
        {
          bool = MMSlotKt.isExpire(l, com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getLong("_check_time_colddown", sQD));
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
      zv localzv;
      if (((Iterator)localObject1).hasNext())
      {
        i = ((Number)((Iterator)localObject1).next()).intValue();
        sQF.add(Integer.valueOf(i));
        ((Map)sQE).put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        localzv = new zv();
        localzv.rWu = i;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.Gw(101)) {
          localzv.Smg = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCs();
        }
        localLinkedList.add(localzv);
        paramVarArgs = Hm(i);
        if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(paramVarArgs)) {
          continue;
        }
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.apZ(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.b(paramVarArgs))) {
          localzv.Smf = paramVarArgs.SYY;
        }
        localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getStringSet(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.h(paramVarArgs), null);
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
          esd localesd = new esd();
          p.j(str, "it");
          if (a(a(localesd, i, str), paramVarArgs)) {
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
        localzv.Sme.addAll((Collection)paramVarArgs);
        break label335;
        if (!((Collection)localLinkedList).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.plugin.webview.h.a.rE(0);
            new a(localLinkedList, paramInt, paramString).bhW().g((com.tencent.mm.vending.c.a)new c(paramInt, localLinkedList));
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
  
  public static void a(ese paramese, boolean paramBoolean)
  {
    AppMethodBeat.i(264779);
    p.k(paramese, "tmplParams");
    String str = "_tmpl_info_inject_fail_-" + paramese.sNh + '-' + paramese.ktM;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().removeValueForKey(str);
      AppMethodBeat.o(264779);
      return;
    }
    int i = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getInt(str, 0) + 1;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().putInt(str, i);
    Log.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + paramese.sNh + ',' + paramese.ktM + ',' + i);
    if (i > 2)
    {
      com.tencent.mm.plugin.webview.h.a.rE(219);
      Log.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + paramese.sNh + ',' + paramese.ktM + ',' + i);
    }
    AppMethodBeat.o(264779);
  }
  
  private static boolean a(esd paramesd1, esd paramesd2)
  {
    AppMethodBeat.i(6849);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.apY(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.b(paramesd1)).ifE())
    {
      if (b(paramesd1, paramesd2))
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().putString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.f(paramesd1), paramesd1.SYY);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt(), com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.g(paramesd1));
        AppMethodBeat.o(6849);
        return true;
      }
      if (p.h(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.e(paramesd1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.f(paramesd1), null)))
      {
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.f(paramesd1));
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.g(paramesd1));
      }
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().remove(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.e(paramesd1));
      paramesd2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.h(paramesd2);
      Set localSet = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getStringSet(paramesd2, null);
      if (localSet != null)
      {
        localSet.remove(paramesd1.SYY);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().putStringSet(paramesd2, localSet);
      }
      Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramesd1.SYY + " is invalid");
    }
    for (;;)
    {
      AppMethodBeat.o(6849);
      return false;
      Log.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + paramesd1.SYY);
    }
  }
  
  private static esd aK(int paramInt, String paramString)
  {
    AppMethodBeat.i(6852);
    esd localesd1 = Hl(paramInt);
    if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(localesd1))
    {
      if ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.apZ(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.b(localesd1))) && ((p.h(localesd1.SYY, paramString) ^ true)))
      {
        AppMethodBeat.o(6852);
        return localesd1;
      }
      Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.f(localesd1), null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new esd();
        p.j(localObject1, "it");
        localObject1 = a((esd)localObject2, paramInt, (String)localObject1);
        if ((localObject1 != null) && (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a((esd)localObject1)) && (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.i((esd)localObject1)) && (com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.apZ(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.b((esd)localObject1))) && ((p.h(((esd)localObject1).SYY, paramString) ^ true)))
        {
          AppMethodBeat.o(6852);
          return localObject1;
        }
      }
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getStringSet(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.h(localesd1), null);
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        p.k(localObject1, "$this$sortedDescending");
        localObject2 = kotlin.b.f.aaAk;
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
            if ((p.h(localObject2, paramString) ^ true))
            {
              esd localesd2 = new esd();
              p.j(localObject2, "uid");
              localObject2 = a(localesd2, paramInt, (String)localObject2);
              if (a((esd)localObject2, localesd1))
              {
                AppMethodBeat.o(6852);
                return localObject2;
              }
            }
          }
        }
      }
    }
    paramString = new esd();
    AppMethodBeat.o(6852);
    return paramString;
  }
  
  private static boolean b(esd paramesd1, esd paramesd2)
  {
    AppMethodBeat.i(6850);
    if ((p.h(paramesd1, paramesd2)) && (paramesd1.rWt != 0))
    {
      AppMethodBeat.o(6850);
      return true;
    }
    int i = paramesd2.Smj;
    Object localObject;
    if (Log.getLogLevel() == 0)
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.sMO;
      int j = j.a.cCf();
      if (j > 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (paramesd1.rWt < i)
      {
        Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramesd1.SYY + " version:" + paramesd1.rWt + " < " + i);
        AppMethodBeat.o(6850);
        return false;
      }
      paramesd2 = paramesd2.UtV;
      p.j(paramesd2, "standard.VersionControlList");
      paramesd2 = ((Iterable)paramesd2).iterator();
      while (paramesd2.hasNext())
      {
        localObject = (esf)paramesd2.next();
        if (p.h(((esf)localObject).SYY, paramesd1.SYY))
        {
          Log.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + ((esf)localObject).SYY + " matchControls in forceH5:" + ((esf)localObject).UtZ);
          if (!((esf)localObject).UtZ)
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
  
  public static Integer[] cDm()
  {
    AppMethodBeat.i(6841);
    Integer[] arrayOfInteger = (Integer[])sQC.getValue();
    AppMethodBeat.o(6841);
    return arrayOfInteger;
  }
  
  public static final void cDn()
  {
    AppMethodBeat.i(6855);
    h.ZvG.d((Runnable)d.sQL, "tmplPreload");
    AppMethodBeat.o(6855);
  }
  
  public static final String cDo()
  {
    AppMethodBeat.i(6857);
    String str = com.tencent.mm.loader.j.b.aSD() + "webview_tmpl/";
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.sMO;
    if (j.a.cCe())
    {
      str = com.tencent.mm.loader.j.b.aSL();
      p.j(str, "CConstants.DATAROOT_SDCARD_PATH()");
    }
    localObject = str;
    if (!n.pu(str, "/")) {
      localObject = str + "/";
    }
    str = (String)localObject + "tmpls/";
    FilePathGenerator.checkMkdir(str);
    AppMethodBeat.o(6857);
    return str;
  }
  
  public static final String cDp()
  {
    AppMethodBeat.i(264783);
    String str = sQA;
    p.j(str, "HARDCODE_URL");
    AppMethodBeat.o(264783);
    return str;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(6845);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().clear();
    u.dK(cDo(), true);
    u.deleteDir(com.tencent.mm.loader.j.b.aSD() + "/jscache/");
    AppMethodBeat.o(6845);
  }
  
  private static boolean e(String paramString, com.tencent.mm.vfs.q paramq)
  {
    AppMethodBeat.i(175496);
    if ((!Util.isNullOrNil(paramString)) && (p.h(paramString, u.buc(paramq.getPath()))))
    {
      AppMethodBeat.o(175496);
      return true;
    }
    Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", new Object[] { paramq.bOF() });
    AppMethodBeat.o(175496);
    return false;
  }
  
  /* Error */
  private static boolean fA(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 6861
    //   3: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1328	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1329	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: checkcast 564	java/io/Closeable
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 1328	java/util/zip/ZipFile
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 1333	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   27: astore 6
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 7
    //   36: new 555	kotlin/g/b/aa$d
    //   39: dup
    //   40: invokespecial 556	kotlin/g/b/aa$d:<init>	()V
    //   43: astore 8
    //   45: aload 6
    //   47: invokeinterface 1338 1 0
    //   52: ifeq +361 -> 413
    //   55: aload 6
    //   57: invokeinterface 1341 1 0
    //   62: checkcast 1343	java/util/zip/ZipEntry
    //   65: astore 4
    //   67: aload 4
    //   69: ldc_w 1345
    //   72: invokestatic 275	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 4
    //   77: invokevirtual 1346	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ldc_w 1348
    //   87: invokestatic 275	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload 5
    //   92: checkcast 901	java/lang/CharSequence
    //   95: ldc_w 1350
    //   98: iconst_0
    //   99: iconst_0
    //   100: bipush 6
    //   102: invokestatic 1353	kotlin/n/n:a	(Ljava/lang/CharSequence;Ljava/lang/String;IZI)I
    //   105: iconst_m1
    //   106: if_icmpeq +46 -> 152
    //   109: ldc 210
    //   111: ldc_w 1355
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 5
    //   122: aastore
    //   123: invokestatic 1072	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -81 -> 45
    //   129: astore_1
    //   130: sipush 6861
    //   133: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_3
    //   140: aload_1
    //   141: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: sipush 6861
    //   147: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: new 438	com/tencent/mm/vfs/q
    //   155: dup
    //   156: new 212	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 345	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 439	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: aload 5
    //   182: invokevirtual 1358	com/tencent/mm/vfs/q:ifA	()Ljava/lang/String;
    //   185: astore 9
    //   187: aload 9
    //   189: ifnonnull +6 -> 195
    //   192: invokestatic 796	kotlin/g/b/p:iCn	()V
    //   195: new 438	com/tencent/mm/vfs/q
    //   198: dup
    //   199: aload 9
    //   201: invokespecial 439	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   204: astore 9
    //   206: aload 9
    //   208: invokevirtual 442	com/tencent/mm/vfs/q:ifE	()Z
    //   211: ifne +9 -> 220
    //   214: aload 9
    //   216: invokevirtual 1361	com/tencent/mm/vfs/q:ifL	()Z
    //   219: pop
    //   220: aload 4
    //   222: invokevirtual 1362	java/util/zip/ZipEntry:isDirectory	()Z
    //   225: ifeq +20 -> 245
    //   228: aload 5
    //   230: invokevirtual 442	com/tencent/mm/vfs/q:ifE	()Z
    //   233: ifne -188 -> 45
    //   236: aload 5
    //   238: invokevirtual 1365	com/tencent/mm/vfs/q:ifK	()Z
    //   241: pop
    //   242: goto -197 -> 45
    //   245: aload 5
    //   247: invokevirtual 442	com/tencent/mm/vfs/q:ifE	()Z
    //   250: ifne +9 -> 259
    //   253: aload 5
    //   255: invokevirtual 553	com/tencent/mm/vfs/q:ifM	()Z
    //   258: pop
    //   259: aload_0
    //   260: aload 4
    //   262: invokevirtual 1368	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   265: checkcast 564	java/io/Closeable
    //   268: astore 4
    //   270: aload 4
    //   272: checkcast 522	java/io/InputStream
    //   275: astore 9
    //   277: new 1370	java/io/BufferedOutputStream
    //   280: dup
    //   281: aload 5
    //   283: invokestatic 562	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   286: invokespecial 1373	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   289: checkcast 564	java/io/Closeable
    //   292: astore 5
    //   294: aload 5
    //   296: checkcast 1370	java/io/BufferedOutputStream
    //   299: astore 10
    //   301: aload 9
    //   303: aload 7
    //   305: invokevirtual 570	java/io/InputStream:read	([B)I
    //   308: istore_2
    //   309: aload 8
    //   311: iload_2
    //   312: putfield 573	kotlin/g/b/aa$d:aaBA	I
    //   315: iload_2
    //   316: ifle +67 -> 383
    //   319: aload 10
    //   321: aload 7
    //   323: iconst_0
    //   324: aload 8
    //   326: getfield 573	kotlin/g/b/aa$d:aaBA	I
    //   329: invokevirtual 1374	java/io/BufferedOutputStream:write	([BII)V
    //   332: goto -31 -> 301
    //   335: astore_1
    //   336: sipush 6861
    //   339: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aload_1
    //   343: athrow
    //   344: astore_0
    //   345: aload 5
    //   347: aload_1
    //   348: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   351: sipush 6861
    //   354: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aload_0
    //   358: athrow
    //   359: astore_1
    //   360: sipush 6861
    //   363: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: astore_0
    //   369: aload 4
    //   371: aload_1
    //   372: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   375: sipush 6861
    //   378: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_0
    //   382: athrow
    //   383: aload 10
    //   385: invokevirtual 1377	java/io/BufferedOutputStream:flush	()V
    //   388: getstatic 588	kotlin/x:aazN	Lkotlin/x;
    //   391: astore 9
    //   393: aload 5
    //   395: aconst_null
    //   396: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   399: getstatic 588	kotlin/x:aazN	Lkotlin/x;
    //   402: astore 5
    //   404: aload 4
    //   406: aconst_null
    //   407: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   410: goto -365 -> 45
    //   413: aload_3
    //   414: aconst_null
    //   415: invokestatic 582	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   418: sipush 6861
    //   421: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   43	282	8	locald	kotlin.g.b.aa.d
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
    AppMethodBeat.i(264784);
    String str = sQB;
    p.j(str, "PREFIX");
    AppMethodBeat.o(264784);
    return str;
  }
  
  public static final void j(esd paramesd)
  {
    AppMethodBeat.i(6847);
    p.k(paramesd, "tmplInfo");
    Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.e(paramesd);
    Object localObject2 = paramesd.SYY;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().putString(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.Hg(paramesd.rWu), (String)localObject2);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.f(paramesd));
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().removeValueForKey(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.g(paramesd));
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().encode((String)localObject1, paramesd.toByteArray());
    String str = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.h(paramesd);
    MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt();
    localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.cCt().getStringSet(str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Set)new HashSet();
    }
    ((Set)localObject1).add(paramesd.SYY);
    localMultiProcessMMKV.putStringSet(str, (Set)localObject1);
    AppMethodBeat.o(6847);
  }
  
  private static final boolean k(esd paramesd)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6854);
        if (paramesd == null)
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
          AppMethodBeat.o(6854);
          return bool;
        }
        if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(paramesd))
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
          AppMethodBeat.o(6854);
          continue;
        }
        if (Hl(paramesd.rWu).rWt == paramesd.rWt) {
          break label90;
        }
      }
      finally {}
      AppMethodBeat.o(6854);
      continue;
      label90:
      if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.apZ(com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.b(paramesd)))
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
  
  private static String l(esd paramesd)
  {
    AppMethodBeat.i(6858);
    paramesd = "Type:" + paramesd.rWu + " Version:" + paramesd.rWt + " CdnUrl:" + paramesd.RVF + " Md5:" + paramesd.Md5;
    AppMethodBeat.o(6858);
    return paramesd;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "", "()V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "isZip", "", "()Z", "setZip", "(Z)V", "patchBase", "", "getPatchBase", "()Ljava/lang/String;", "setPatchBase", "(Ljava/lang/String;)V", "patchMD5", "getPatchMD5", "setPatchMD5", "success", "getSuccess", "setSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    Exception exception;
    boolean npI;
    String sQH;
    String sQI;
    boolean success;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Integer;"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer[]>
  {
    public static final b sQJ;
    
    static
    {
      AppMethodBeat.i(6828);
      sQJ = new b();
      AppMethodBeat.o(6828);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "checkTmplVerRespCgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplVerResp;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<Void, c.a<zx>>
  {
    c(int paramInt, LinkedList paramLinkedList) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d sQL;
    
    static
    {
      AppMethodBeat.i(6831);
      sQL = new d();
      AppMethodBeat.o(6831);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6830);
      b.cDr();
      AppMethodBeat.o(6830);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.m<ArrayList<String>, com.tencent.mm.vfs.q, Boolean>
  {
    public static final e sQM;
    
    static
    {
      AppMethodBeat.i(6834);
      sQM = new e();
      AppMethodBeat.o(6834);
    }
    
    e()
    {
      super();
    }
    
    public static boolean a(ArrayList<String> paramArrayList, com.tencent.mm.vfs.q paramq)
    {
      AppMethodBeat.i(6833);
      p.k(paramArrayList, "$this$isIncludeFile");
      p.k(paramq, "file");
      StringBuilder localStringBuilder = new StringBuilder().append(paramq.bOF());
      if (paramq.isDirectory()) {}
      for (paramq = "/";; paramq = "")
      {
        boolean bool = paramArrayList.contains(paramq);
        AppMethodBeat.o(6833);
        return bool;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    
    f(esd paramesd, int paramInt, kotlin.g.a.a parama, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6836);
      p.k(paramd, "completion");
      paramd = new f(this.sQN, this.soG, this.nJy, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(6836);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6837);
      paramObject1 = ((f)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(6837);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6835);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6835);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject2 = this.p$;
        paramObject = new HashMap();
        localObject1 = this.sQN.RVF;
        Object localObject3 = this.sQN.UtT;
        p.j(localObject3, "tmplInfo.HttpHeaderList");
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (esc)((Iterator)localObject3).next();
          Object localObject5 = (CharSequence)((esc)localObject4).CRg;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject5 = (CharSequence)((esc)localObject4).Izj;
            if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
              break label246;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject5 = (Map)paramObject;
            String str = ((esc)localObject4).CRg;
            p.j(str, "it.Key");
            localObject4 = ((esc)localObject4).Izj;
            p.j(localObject4, "it.Value");
            ((Map)localObject5).put(str, localObject4);
            break;
            i = 0;
            break label157;
          }
        }
        if (!this.sQN.UtU) {
          break label404;
        }
        localObject3 = b.sQG;
        p.j(localObject1, "downloadUrl");
        this.L$0 = localObject2;
        this.oDA = paramObject;
        this.pGq = localObject1;
        this.label = 1;
        localObject2 = b.a((String)localObject1, paramObject, this);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(6835);
          return locala;
        }
        break;
      case 1: 
        label157:
        label246:
        localObject2 = (HashMap)this.oDA;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      Object localObject1 = (String)localObject1;
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        label366:
        if (i != 0) {
          break label412;
        }
        localObject2 = b.sQG;
        b.a((String)localObject1, this.sQN, paramObject, this.soG, this.nJy);
      }
      for (;;)
      {
        paramObject = x.aazN;
        AppMethodBeat.o(6835);
        return paramObject;
        label404:
        break;
        i = 0;
        break label366;
        label412:
        paramObject = new StringBuilder("url is null or empty:");
        localObject1 = b.sQG;
        Log.e("MicroMsg.Preload.TmplInfoManager", b.m(this.sQN));
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$getUrlWithA8key$2$1"})
  static final class g
    implements com.tencent.mm.an.i
  {
    g(d paramd, String paramString, HashMap paramHashMap) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(6838);
      Log.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramq.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null) {
          try
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelsimple.NetSceneGetA8Key");
            AppMethodBeat.o(6838);
            throw paramString;
          }
          catch (Exception paramString)
          {
            Log.e("MicroMsg.Preload.TmplInfoManager", "NetSceneGetA8Key ex " + paramString.getMessage());
            AppMethodBeat.o(6838);
            return;
          }
        }
        paramString = (com.tencent.mm.modelsimple.l)paramq;
        paramq = paramString.bom();
        p.j(paramq, "netSceneGetA8Key.httpHeader");
        paramq = ((Iterable)paramq).iterator();
      }
      label185:
      label335:
      label340:
      label345:
      label348:
      label350:
      label353:
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (paramq.hasNext())
        {
          localObject1 = (ckf)paramq.next();
          localObject2 = (CharSequence)((ckf)localObject1).CRg;
          if (localObject2 == null) {
            break label335;
          }
          if (((CharSequence)localObject2).length() != 0) {
            break label345;
          }
          break label335;
          if (paramInt1 != 0) {
            break label348;
          }
          localObject2 = (CharSequence)((ckf)localObject1).Izj;
          if (localObject2 == null) {
            break label340;
          }
          if (((CharSequence)localObject2).length() != 0) {
            break label350;
          }
          break label340;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            break label353;
          }
          localObject2 = (Map)this.sQO;
          String str = ((ckf)localObject1).CRg;
          p.j(str, "it.Key");
          localObject1 = ((ckf)localObject1).Izj;
          p.j(localObject1, "it.Value");
          ((Map)localObject2).put(str, localObject1);
          break;
          paramq = this.sOD;
          paramString = paramString.bof();
          localObject1 = Result.Companion;
          paramq.resumeWith(Result.constructor-impl(paramString));
          AppMethodBeat.o(6838);
          return;
          paramString = this.sOD;
          paramq = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(""));
          AppMethodBeat.o(6838);
          return;
          paramInt1 = 1;
          break label185;
          paramInt1 = 1;
          continue;
          paramInt1 = 0;
          break label185;
          break;
          paramInt1 = 0;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b
 * JD-Core Version:    0.7.0.1
 */