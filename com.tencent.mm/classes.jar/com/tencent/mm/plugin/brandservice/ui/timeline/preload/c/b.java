package com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.q;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.fnl;
import com.tencent.mm.protocal.protobuf.fnm;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.protocal.protobuf.fno;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "kotlin.jvm.PlatformType", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "cacheFileRegex", "Lkotlin/text/Regex;", "getCacheFileRegex", "()Lkotlin/text/Regex;", "cacheFileRegex$delegate", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "getExpireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "templateFallbackEnable", "", "getTemplateFallbackEnable", "()Z", "tmplKeepCount", "getTmplKeepCount", "()I", "tmplKeepCount$delegate", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkLocalVersionFileValid", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplType", "deleteInvalidCacheFile", "tmplInfo", "download", "url", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getLocalTypeInfoList", "forceGet", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Lcom/tencent/mm/vfs/VFSFile;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", "dir", "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "debugInfo", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b vVO;
  private static final String vVP;
  private static final String vVQ;
  private static final kotlin.j vVR;
  private static final int vVS;
  private static final ConcurrentHashMap<Integer, Long> vVT;
  private static final ArrayList<Integer> vVU;
  private static final kotlin.j vVV;
  private static final kotlin.j vVW;
  
  static
  {
    AppMethodBeat.i(6840);
    vVO = new b();
    String str = com.tencent.mm.plugin.webview.g.a.vVP;
    vVP = str;
    vVQ = str;
    vVR = kotlin.k.cm((kotlin.g.a.a)b.vVZ);
    vVS = 60000;
    vVT = new ConcurrentHashMap();
    vVU = new ArrayList();
    int j;
    label207:
    label212:
    label217:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      str = kotlin.g.b.s.X("_webview_tmpl_cache_slot_", Integer.valueOf(i));
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(str);
      long l = localMultiProcessMMKV.totalSize();
      if (l > 0L)
      {
        String[] arrayOfString = localMultiProcessMMKV.allKeys();
        if (arrayOfString != null)
        {
          if (arrayOfString.length != 0) {
            break label207;
          }
          i = 1;
          if (i == 0) {
            break label212;
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          localMultiProcessMMKV.clearAll();
          Log.i("MicroMsg.Preload.TmplInfoManager", "clear " + str + " totalSize:" + l);
        }
        if (j <= 2) {
          break label217;
        }
        vVV = kotlin.k.cm((kotlin.g.a.a)h.vWd);
        vVW = kotlin.k.cm((kotlin.g.a.a)c.vWa);
        AppMethodBeat.o(6840);
        return;
        i = 0;
        break;
      }
    }
  }
  
  private static String HM(int paramInt)
  {
    AppMethodBeat.i(6842);
    String str = kotlin.g.b.s.X("_tmpl_download_time_", Integer.valueOf(paramInt));
    AppMethodBeat.o(6842);
    return str;
  }
  
  private static final boolean HN(int paramInt)
  {
    AppMethodBeat.i(303072);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.vSB;
    if (j.a.dfr())
    {
      AppMethodBeat.o(303072);
      return true;
    }
    long l = 0L;
    if (vVT.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = vVT.get(Integer.valueOf(paramInt));
      kotlin.g.b.s.checkNotNull(localObject);
      kotlin.g.b.s.s(localObject, "lastCheckTimeMap[tmplType]!!");
      l = ((Number)localObject).longValue();
    }
    if (vVU.contains(Integer.valueOf(paramInt)))
    {
      Log.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(303072);
      return false;
    }
    boolean bool = MMSlotKt.isExpire(l, dgM());
    AppMethodBeat.o(303072);
    return bool;
  }
  
  public static final fnm HO(int paramInt)
  {
    AppMethodBeat.i(6851);
    fnm localfnm = new fnm();
    String str = q.dfF().getString(q.HF(paramInt), null);
    if (str != null) {
      a(localfnm, paramInt, str);
    }
    AppMethodBeat.o(6851);
    return localfnm;
  }
  
  public static final fnn HQ(int paramInt)
  {
    AppMethodBeat.i(303152);
    Object localObject2 = HP(paramInt);
    if (!q.a((fnm)localObject2))
    {
      Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + paramInt + " localTmplInfo is null");
      com.tencent.mm.plugin.webview.g.a.rG(100);
      AppMethodBeat.o(303152);
      return null;
    }
    Object localObject1 = q.c((fnm)localObject2);
    if (!q.ajA((String)localObject1))
    {
      Log.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + (String)localObject1 + " is null");
      if (((fnm)localObject2).xKa > 0) {
        com.tencent.mm.plugin.webview.g.a.ik(((fnm)localObject2).xKa, 100);
      }
      AppMethodBeat.o(303152);
      return null;
    }
    fnn localfnn = new fnn();
    localfnn.vST = paramInt;
    localfnn.version = ((fnm)localObject2).crz;
    localfnn.md5 = ((fnm)localObject2).Md5;
    localfnn.abNy = ((String)localObject1);
    Object localObject3 = new StringBuilder().append(vVP).append(paramInt).append('_').append(((fnm)localObject2).aalQ).append(".html");
    if (!kotlin.g.b.s.p(vVQ, vVP)) {}
    for (localObject1 = kotlin.g.b.s.X("?prefix=", URLEncoder.encode(vVQ));; localObject1 = "")
    {
      localfnn.WET = ((String)localObject1);
      localfnn.mOI = ((fnm)localObject2).YTj;
      localfnn.reportId = ((fnm)localObject2).xKa;
      localfnn.QzY = q.dfF().getLong(HM(((fnm)localObject2).vhJ), 0L);
      localfnn.mXG = ((fnm)localObject2).aalQ;
      localObject1 = ((fnm)localObject2).abNu;
      kotlin.g.b.s.s(localObject1, "tmplInfo.HttpHeaderList");
      localObject2 = (Iterable)localObject1;
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (fnl)((Iterator)localObject2).next();
        localObject1 = ((StringBuilder)localObject1).append("\n" + ((fnl)localObject3).ILw + ':' + ((fnl)localObject3).OzQ);
        kotlin.g.b.s.s(localObject1, "sb.append(\"\\n${header.Key}:${header.Value}\")");
      }
    }
    localfnn.abNz = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(303152);
    return localfnn;
  }
  
  /* Error */
  private static a a(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: sipush 6862
    //   3: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a
    //   9: dup
    //   10: invokespecial 526	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:<init>	()V
    //   13: astore 6
    //   15: new 528	com/tencent/mm/vfs/u
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 529	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   23: astore 7
    //   25: aload 7
    //   27: invokevirtual 532	com/tencent/mm/vfs/u:jKS	()Z
    //   30: ifeq +9 -> 39
    //   33: aload 7
    //   35: invokevirtual 535	com/tencent/mm/vfs/u:diJ	()Z
    //   38: pop
    //   39: new 537	java/net/URL
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 538	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 542	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: astore 8
    //   52: aload 8
    //   54: ifnonnull +101 -> 155
    //   57: new 544	java/lang/NullPointerException
    //   60: dup
    //   61: ldc_w 546
    //   64: invokespecial 547	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   67: astore_2
    //   68: sipush 6862
    //   71: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: ldc 249
    //   79: aload_2
    //   80: checkcast 549	java/lang/Throwable
    //   83: new 251	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 551
    //   90: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 553
    //   100: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_1
    //   104: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 557	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 6
    //   119: aload_2
    //   120: checkcast 559	java/lang/Exception
    //   123: putfield 563	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:exception	Ljava/lang/Exception;
    //   126: iload_0
    //   127: bipush 7
    //   129: invokestatic 412	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   132: aload 7
    //   134: invokevirtual 532	com/tencent/mm/vfs/u:jKS	()Z
    //   137: ifeq +9 -> 146
    //   140: aload 7
    //   142: invokevirtual 535	com/tencent/mm/vfs/u:diJ	()Z
    //   145: pop
    //   146: sipush 6862
    //   149: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 6
    //   154: areturn
    //   155: aload 8
    //   157: checkcast 565	java/net/HttpURLConnection
    //   160: astore 8
    //   162: aload 8
    //   164: ldc_w 567
    //   167: ldc_w 569
    //   170: invokevirtual 572	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 8
    //   175: ldc_w 567
    //   178: ldc_w 574
    //   181: invokevirtual 572	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 8
    //   186: iconst_0
    //   187: invokevirtual 578	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   190: aload_2
    //   191: ifnull +219 -> 410
    //   194: aload_2
    //   195: invokeinterface 583 1 0
    //   200: ifne +204 -> 404
    //   203: iconst_1
    //   204: istore 4
    //   206: iload 4
    //   208: ifeq +202 -> 410
    //   211: ldc 249
    //   213: ldc_w 585
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_2
    //   223: invokeinterface 588 1 0
    //   228: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 590	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_2
    //   236: invokeinterface 594 1 0
    //   241: invokeinterface 597 1 0
    //   246: astore 9
    //   248: aload 9
    //   250: invokeinterface 499 1 0
    //   255: ifeq +155 -> 410
    //   258: aload 9
    //   260: invokeinterface 503 1 0
    //   265: checkcast 599	java/lang/String
    //   268: astore 10
    //   270: aload 8
    //   272: aload 10
    //   274: aload_2
    //   275: aload 10
    //   277: invokeinterface 600 2 0
    //   282: checkcast 599	java/lang/String
    //   285: invokevirtual 572	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -40 -> 248
    //   291: astore_2
    //   292: sipush 6862
    //   295: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_2
    //   299: athrow
    //   300: astore_2
    //   301: aload 8
    //   303: invokevirtual 604	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   306: astore 9
    //   308: aload 9
    //   310: ifnull +8 -> 318
    //   313: aload 9
    //   315: invokevirtual 609	java/io/InputStream:close	()V
    //   318: aload 8
    //   320: invokevirtual 612	java/net/HttpURLConnection:disconnect	()V
    //   323: sipush 6862
    //   326: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload_2
    //   330: athrow
    //   331: astore_2
    //   332: ldc 249
    //   334: aload_2
    //   335: checkcast 549	java/lang/Throwable
    //   338: new 251	java/lang/StringBuilder
    //   341: dup
    //   342: ldc_w 614
    //   345: invokespecial 256	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: aload_3
    //   349: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 553
    //   355: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 557	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: aload 6
    //   374: aload_2
    //   375: checkcast 559	java/lang/Exception
    //   378: putfield 563	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:exception	Ljava/lang/Exception;
    //   381: iload_0
    //   382: bipush 7
    //   384: invokestatic 412	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   387: aload 7
    //   389: invokevirtual 532	com/tencent/mm/vfs/u:jKS	()Z
    //   392: ifeq -246 -> 146
    //   395: aload 7
    //   397: invokevirtual 535	com/tencent/mm/vfs/u:diJ	()Z
    //   400: pop
    //   401: goto -255 -> 146
    //   404: iconst_0
    //   405: istore 4
    //   407: goto -201 -> 206
    //   410: aload 8
    //   412: iconst_0
    //   413: invokevirtual 617	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   416: aload 8
    //   418: ldc_w 619
    //   421: invokevirtual 622	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   424: aload 8
    //   426: sipush 10000
    //   429: invokevirtual 625	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   432: aload 8
    //   434: sipush 3000
    //   437: invokevirtual 628	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   440: aload 8
    //   442: invokevirtual 631	java/net/HttpURLConnection:connect	()V
    //   445: aload 8
    //   447: invokevirtual 634	java/net/HttpURLConnection:getResponseCode	()I
    //   450: istore 4
    //   452: iload 4
    //   454: sipush 200
    //   457: if_icmpne +197 -> 654
    //   460: aload 7
    //   462: invokevirtual 637	com/tencent/mm/vfs/u:jKZ	()Z
    //   465: pop
    //   466: sipush 8192
    //   469: newarray byte
    //   471: astore 9
    //   473: aload 7
    //   475: invokestatic 643	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   478: checkcast 645	java/io/Closeable
    //   481: astore_2
    //   482: aload_2
    //   483: checkcast 647	java/io/OutputStream
    //   486: astore 10
    //   488: aload 8
    //   490: invokevirtual 604	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   493: aload 9
    //   495: invokevirtual 651	java/io/InputStream:read	([B)I
    //   498: istore 4
    //   500: iload 4
    //   502: iconst_m1
    //   503: if_icmpeq +44 -> 547
    //   506: aload 10
    //   508: aload 9
    //   510: iconst_0
    //   511: iload 4
    //   513: invokevirtual 655	java/io/OutputStream:write	([BII)V
    //   516: goto -28 -> 488
    //   519: astore 9
    //   521: sipush 6862
    //   524: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   527: aload 9
    //   529: athrow
    //   530: astore 10
    //   532: aload_2
    //   533: aload 9
    //   535: invokestatic 660	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   538: sipush 6862
    //   541: invokestatic 171	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   544: aload 10
    //   546: athrow
    //   547: getstatic 666	kotlin/ah:aiuX	Lkotlin/ah;
    //   550: astore 9
    //   552: aload_2
    //   553: aconst_null
    //   554: invokestatic 660	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   557: aload 6
    //   559: iconst_1
    //   560: putfield 669	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:success	Z
    //   563: aload 6
    //   565: aload 8
    //   567: ldc_w 671
    //   570: invokevirtual 674	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   573: putfield 677	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:vVX	Ljava/lang/String;
    //   576: aload 6
    //   578: aload 8
    //   580: ldc_w 679
    //   583: invokevirtual 674	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   586: putfield 682	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:vVY	Ljava/lang/String;
    //   589: aload 8
    //   591: ldc_w 684
    //   594: invokevirtual 674	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   597: astore_2
    //   598: aload_2
    //   599: ifnull +49 -> 648
    //   602: ldc_w 686
    //   605: aload_2
    //   606: invokestatic 448	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   609: ifne +39 -> 648
    //   612: iconst_1
    //   613: istore 5
    //   615: aload 6
    //   617: iload 5
    //   619: putfield 689	com/tencent/mm/plugin/brandservice/ui/timeline/preload/c/b$a:qon	Z
    //   622: getstatic 666	kotlin/ah:aiuX	Lkotlin/ah;
    //   625: astore_2
    //   626: aload 8
    //   628: invokevirtual 604	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   631: astore_2
    //   632: aload_2
    //   633: ifnull +7 -> 640
    //   636: aload_2
    //   637: invokevirtual 609	java/io/InputStream:close	()V
    //   640: aload 8
    //   642: invokevirtual 612	java/net/HttpURLConnection:disconnect	()V
    //   645: goto -499 -> 146
    //   648: iconst_0
    //   649: istore 5
    //   651: goto -36 -> 615
    //   654: ldc 249
    //   656: ldc_w 691
    //   659: iload 4
    //   661: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: invokestatic 231	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   667: invokestatic 390	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: iload 4
    //   672: sipush 500
    //   675: if_icmple +12 -> 687
    //   678: iload_0
    //   679: bipush 11
    //   681: invokestatic 412	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   684: goto -62 -> 622
    //   687: iload 4
    //   689: sipush 400
    //   692: if_icmple -70 -> 622
    //   695: iload_0
    //   696: bipush 10
    //   698: invokestatic 412	com/tencent/mm/plugin/webview/g/a:ik	(II)V
    //   701: goto -79 -> 622
    //   704: astore 9
    //   706: goto -388 -> 318
    //   709: astore_2
    //   710: goto -70 -> 640
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	paramInt	int
    //   0	713	1	paramString1	String
    //   0	713	2	paramMap	Map<String, String>
    //   0	713	3	paramString2	String
    //   204	489	4	i	int
    //   613	37	5	bool	boolean
    //   13	603	6	locala	a
    //   23	451	7	localu	com.tencent.mm.vfs.u
    //   50	591	8	localObject1	Object
    //   246	263	9	localObject2	Object
    //   519	15	9	localThrowable	Throwable
    //   550	1	9	localah	kotlin.ah
    //   704	1	9	localObject3	Object
    //   268	239	10	localObject4	Object
    //   530	15	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   39	52	76	java/io/FileNotFoundException
    //   57	76	76	java/io/FileNotFoundException
    //   155	162	76	java/io/FileNotFoundException
    //   318	331	76	java/io/FileNotFoundException
    //   640	645	76	java/io/FileNotFoundException
    //   162	190	291	finally
    //   194	203	291	finally
    //   211	248	291	finally
    //   248	288	291	finally
    //   410	452	291	finally
    //   460	482	291	finally
    //   532	547	291	finally
    //   552	598	291	finally
    //   602	612	291	finally
    //   615	622	291	finally
    //   622	626	291	finally
    //   654	670	291	finally
    //   678	684	291	finally
    //   695	701	291	finally
    //   292	300	300	finally
    //   39	52	331	java/io/IOException
    //   57	76	331	java/io/IOException
    //   155	162	331	java/io/IOException
    //   318	331	331	java/io/IOException
    //   640	645	331	java/io/IOException
    //   482	488	519	finally
    //   488	500	519	finally
    //   506	516	519	finally
    //   547	552	519	finally
    //   521	530	530	finally
    //   301	308	704	finally
    //   313	318	704	finally
    //   626	632	709	finally
    //   636	640	709	finally
  }
  
  private static fnm a(fnm paramfnm, int paramInt, String paramString)
  {
    AppMethodBeat.i(6848);
    paramfnm.vhJ = paramInt;
    paramfnm.aalQ = paramString;
    byte[] arrayOfByte = q.dfF().decodeBytes(q.e(paramfnm));
    int i;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {}
      try
      {
        paramfnm.parseFrom(arrayOfByte);
        AppMethodBeat.o(6848);
        return paramfnm;
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
  
  private static Object a(String paramString, final HashMap<String, String> paramHashMap, d<? super String> paramd)
  {
    AppMethodBeat.i(6859);
    kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    d locald = (d)localh;
    try
    {
      int i = new com.tencent.mm.modelsimple.n(paramString, "", 0, 8, com.tencent.mm.modelsimple.n.bMd(), new byte[0]).doScene(com.tencent.mm.kernel.h.baD().mCm.oun, (com.tencent.mm.am.h)new f(locald, paramHashMap));
      if (i < 0)
      {
        Log.e("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("NetSceneGetA8Key dispatch fail ", Integer.valueOf(i)));
        paramString = Result.Companion;
        locald.resumeWith(Result.constructor-impl(""));
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("getUrlWithA8key ex:", paramString.getMessage()));
      }
    }
    paramString = localh.kli();
    if (paramString == kotlin.d.a.a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(6859);
    return paramString;
  }
  
  private static final Void a(final int paramInt, LinkedList paramLinkedList, final com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(303206);
    kotlin.g.b.s.u(paramLinkedList, "$typeInfoList");
    Log.i("MicroMsg.Preload.TmplInfoManager", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
    {
      int i;
      if (((abx)parama.ott).Zkx > 0)
      {
        i = ((abx)parama.ott).Zkx;
        q.dfF().putLong("_check_time_colddown", i * 1000);
      }
      if ((((abx)parama.ott).Zkw != null) && (((abx)parama.ott).Zkw.size() <= 0))
      {
        Log.w("MicroMsg.Preload.TmplInfoManager", "cgi back tmplInfoList is empty, return");
        AppMethodBeat.o(303206);
        return null;
      }
      Iterator localIterator = ((abx)parama.ott).Zkw.iterator();
      while (localIterator.hasNext())
      {
        fnm localfnm = (fnm)localIterator.next();
        if (localfnm != null)
        {
          if (j(localfnm)) {
            o.fQ("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X(localfnm.aalQ, " exist, only see for debug"));
          }
          for (;;)
          {
            kotlin.g.b.s.u(localfnm, "tmplInfo");
            parama = q.e(localfnm);
            Object localObject = localfnm.aalQ;
            q.dfF().putString(q.HF(localfnm.vhJ), (String)localObject);
            q.dfF().removeValueForKey(q.f(localfnm));
            q.dfF().removeValueForKey(q.g(localfnm));
            q.dfF().encode(parama, localfnm.toByteArray());
            String str = q.h(localfnm);
            MultiProcessMMKV localMultiProcessMMKV = q.dfF();
            localObject = q.dfF().getStringSet(str, null);
            parama = (com.tencent.mm.am.b.a)localObject;
            if (localObject == null) {
              parama = (Set)new HashSet();
            }
            parama.add(localfnm.aalQ);
            localObject = kotlin.ah.aiuX;
            localMultiProcessMMKV.putStringSet(str, parama);
            break;
            parama = (kotlin.g.a.a)new g(localfnm.vhJ);
            localObject = (CharSequence)localfnm.YTj;
            if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label429;
              }
              Log.i("MicroMsg.Preload.TmplInfoManager", "[addDownloadTask] TmplInfo is null, return");
              break;
            }
            label429:
            Log.i("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("start download:", l(localfnm)));
            kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (kotlin.g.a.m)new e(localfnm, paramInt, parama, null), 2);
          }
        }
      }
      com.tencent.mm.plugin.webview.g.a.rG(1);
    }
    for (;;)
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        parama = (abv)paramLinkedList.next();
        vVU.remove(Integer.valueOf(parama.vhJ));
      }
      com.tencent.mm.plugin.webview.g.a.rG(2);
    }
    AppMethodBeat.o(303206);
    return null;
  }
  
  public static final void a(int paramInt, String paramString, int... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6844);
        kotlin.g.b.s.u(paramString, "netType");
        kotlin.g.b.s.u(paramVarArgs, "tmplTypes");
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          Log.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
          AppMethodBeat.o(6844);
          return;
        }
        paramVarArgs = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.vSB;
        if ((!BuildInfo.IS_FLAVOR_RED) && (com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.cTb().getInt("preload_type", 1) == 3))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          o.fQ("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
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
      vVT.clear();
    }
    paramVarArgs = mY(false);
    if (!((Collection)paramVarArgs).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.webview.g.a.rG(0);
        new a(paramVarArgs, paramInt, paramString).bFJ().g(new b..ExternalSyntheticLambda0(paramInt, paramVarArgs));
      }
      AppMethodBeat.o(6844);
      break;
    }
  }
  
  public static void a(fnn paramfnn, boolean paramBoolean)
  {
    AppMethodBeat.i(303049);
    kotlin.g.b.s.u(paramfnn, "tmplParams");
    String str = "_tmpl_info_inject_fail_-" + paramfnn.vST + '-' + paramfnn.mXG;
    if (paramBoolean)
    {
      q.dfF().removeValueForKey(str);
      AppMethodBeat.o(303049);
      return;
    }
    int i = q.dfF().getInt(str, 0) + 1;
    q.dfF().putInt(str, i);
    Log.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + paramfnn.vST + ',' + paramfnn.mXG + ',' + i);
    if (i > 2)
    {
      com.tencent.mm.plugin.webview.g.a.rG(219);
      Log.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + paramfnn.vST + ',' + paramfnn.mXG + ',' + i);
    }
    AppMethodBeat.o(303049);
  }
  
  private static boolean a(fnm paramfnm1, fnm paramfnm2)
  {
    AppMethodBeat.i(6849);
    if (q.isFileValid(q.b(paramfnm1)))
    {
      if (b(paramfnm1, paramfnm2))
      {
        q.dfF().putString(q.f(paramfnm1), paramfnm1.aalQ);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.b(q.dfF(), q.g(paramfnm1));
        AppMethodBeat.o(6849);
        return true;
      }
      if (kotlin.g.b.s.p(q.e(paramfnm1), q.dfF().getString(q.f(paramfnm1), null)))
      {
        q.dfF().removeValueForKey(q.f(paramfnm1));
        q.dfF().removeValueForKey(q.g(paramfnm1));
      }
      q.dfF().remove(q.e(paramfnm1));
      paramfnm2 = q.h(paramfnm2);
      Set localSet = q.dfF().getStringSet(paramfnm2, null);
      if (localSet != null)
      {
        localSet.remove(paramfnm1.aalQ);
        q.dfF().putStringSet(paramfnm2, localSet);
      }
      Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramfnm1.aalQ + " is invalid");
    }
    for (;;)
    {
      AppMethodBeat.o(6849);
      return false;
      Log.i("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("no tmpl file:", paramfnm1.aalQ));
    }
  }
  
  private static final boolean a(ArrayList<String> paramArrayList, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(303221);
    String str = com.tencent.mm.vfs.ah.v(paramu.jKT());
    if (paramu.isDirectory()) {}
    for (paramu = "/";; paramu = "")
    {
      boolean bool = paramArrayList.contains(kotlin.g.b.s.X(str, paramu));
      AppMethodBeat.o(303221);
      return bool;
    }
  }
  
  private static fnm aX(int paramInt, String paramString)
  {
    AppMethodBeat.i(6852);
    fnm localfnm1 = HO(paramInt);
    if ((localfnm1 != null) && (q.a(localfnm1)))
    {
      if ((q.isFileValid(q.b(localfnm1))) && (!kotlin.g.b.s.p(localfnm1.aalQ, paramString)))
      {
        AppMethodBeat.o(6852);
        return localfnm1;
      }
      Object localObject1 = q.dfF().getString(q.f(localfnm1), null);
      if (localObject1 != null)
      {
        localObject1 = a(new fnm(), paramInt, (String)localObject1);
        if ((localObject1 != null) && (q.a((fnm)localObject1)) && (!q.i((fnm)localObject1)) && (q.isFileValid(q.b((fnm)localObject1))) && (!kotlin.g.b.s.p(((fnm)localObject1).aalQ, paramString)))
        {
          AppMethodBeat.o(6852);
          return localObject1;
        }
      }
      localObject1 = q.dfF().getStringSet(q.h(localfnm1), null);
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        kotlin.g.b.s.u(localObject1, "$this$sortedDescending");
        Object localObject2 = kotlin.b.f.aivW;
        if (localObject2 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
          AppMethodBeat.o(6852);
          throw paramString;
        }
        localObject1 = kotlin.a.p.a((Iterable)localObject1, (Comparator)localObject2);
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (!kotlin.g.b.s.p(localObject2, paramString))
            {
              fnm localfnm2 = new fnm();
              kotlin.g.b.s.s(localObject2, "uid");
              localObject2 = a(localfnm2, paramInt, (String)localObject2);
              if (a((fnm)localObject2, localfnm1))
              {
                AppMethodBeat.o(6852);
                return localObject2;
              }
            }
          }
        }
      }
    }
    paramString = new fnm();
    AppMethodBeat.o(6852);
    return paramString;
  }
  
  private static boolean b(fnm paramfnm1, fnm paramfnm2)
  {
    AppMethodBeat.i(6850);
    if ((kotlin.g.b.s.p(paramfnm1, paramfnm2)) && (paramfnm1.crz != 0))
    {
      AppMethodBeat.o(6850);
      return true;
    }
    int i = paramfnm2.Zkv;
    Object localObject;
    if (Log.getLogLevel() == 0)
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.vSB;
      int j = j.a.dfq();
      if (j > 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (paramfnm1.crz < i)
      {
        Log.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramfnm1.aalQ + " version:" + paramfnm1.crz + " < " + i);
        AppMethodBeat.o(6850);
        return false;
      }
      paramfnm2 = paramfnm2.abNw;
      kotlin.g.b.s.s(paramfnm2, "standard.VersionControlList");
      paramfnm2 = ((Iterable)paramfnm2).iterator();
      while (paramfnm2.hasNext())
      {
        localObject = (fno)paramfnm2.next();
        if (kotlin.g.b.s.p(((fno)localObject).aalQ, paramfnm1.aalQ))
        {
          Log.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + ((fno)localObject).aalQ + " matchControls in forceH5:" + ((fno)localObject).abNA);
          if (!((fno)localObject).abNA)
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
    q.dfF().clear();
    y.ew(dgO(), true);
    y.ew(kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmr(), "/jscache/"), true);
    AppMethodBeat.o(6845);
  }
  
  public static Integer[] dgL()
  {
    AppMethodBeat.i(6841);
    Integer[] arrayOfInteger = (Integer[])vVR.getValue();
    AppMethodBeat.o(6841);
    return arrayOfInteger;
  }
  
  private static long dgM()
  {
    AppMethodBeat.i(303080);
    long l = q.dfF().getLong("_check_time_colddown", vVS);
    AppMethodBeat.o(303080);
    return l;
  }
  
  public static final void dgN()
  {
    AppMethodBeat.i(6855);
    com.tencent.threadpool.h.ahAA.g(b..ExternalSyntheticLambda1.INSTANCE, "tmplPreload");
    AppMethodBeat.o(6855);
  }
  
  public static final String dgO()
  {
    AppMethodBeat.i(6857);
    String str = kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmr(), "webview_tmpl/");
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.vSB;
    if (j.a.dfp())
    {
      str = com.tencent.mm.loader.i.b.bmz();
      kotlin.g.b.s.s(str, "DATAROOT_SDCARD_PATH()");
    }
    localObject = str;
    if (!kotlin.n.n.rs(str, "/")) {
      localObject = kotlin.g.b.s.X(str, "/");
    }
    str = kotlin.g.b.s.X((String)localObject, "tmpls/");
    FilePathGenerator.checkMkdir(str);
    AppMethodBeat.o(6857);
    return str;
  }
  
  public static final String dgP()
  {
    AppMethodBeat.i(303156);
    String str = vVP;
    kotlin.g.b.s.s(str, "HARDCODE_URL");
    AppMethodBeat.o(303156);
    return str;
  }
  
  private static final void dgQ()
  {
    AppMethodBeat.i(303216);
    Object localObject1 = dgO();
    Log.i("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl saveDir:%s", new Object[] { localObject1 });
    Object localObject2 = q.ajz((String)localObject1);
    if (!((com.tencent.mm.vfs.u)localObject2).jKS())
    {
      Log.w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not exist, err", new Object[] { localObject1 });
      AppMethodBeat.o(303216);
      return;
    }
    if (!((com.tencent.mm.vfs.u)localObject2).isDirectory())
    {
      Log.w("MicroMsg.Preload.TmplInfoManager", "fileDir:%s is not dir, err", new Object[] { localObject1 });
      AppMethodBeat.o(303216);
      return;
    }
    localObject2 = ((com.tencent.mm.vfs.u)localObject2).jKX();
    if (localObject2 != null)
    {
      int i;
      if (localObject2.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label209;
        }
        i = 1;
      }
      label209:
      for (;;)
      {
        label125:
        if (i != 0)
        {
          if (BuildInfo.DEBUG)
          {
            Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl oldCount %d", new Object[] { Integer.valueOf(localObject2.length) });
            localObject1 = kotlin.g.b.c.ao((Object[])localObject2);
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl file:%s", new Object[] { ((com.tencent.mm.vfs.u)((Iterator)localObject1).next()).getName() });
                continue;
                i = 0;
                break;
                i = 0;
                break label125;
              }
            }
          }
          localObject1 = new ArrayList();
          Object localObject3 = dgL();
          int j = localObject3.length;
          i = 0;
          Object localObject4;
          while (i < j)
          {
            int k = ((Number)localObject3[i]).intValue();
            localObject4 = HP(k);
            Object localObject5 = q.dfF().getStringSet(q.h(HO(k)), (Set)new HashSet());
            kotlin.g.b.s.checkNotNull(localObject5);
            kotlin.g.b.s.s(localObject5, "kvTmpl.getStringSet(\n   …keyVersions, HashSet())!!");
            Object localObject6 = (Iterable)kotlin.a.p.p((Iterable)localObject5);
            localObject5 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject6, 10));
            localObject6 = ((Iterable)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              Object localObject7 = (String)((Iterator)localObject6).next();
              fnm localfnm = new fnm();
              kotlin.g.b.s.s(localObject7, "it");
              localObject7 = a(localfnm, k, (String)localObject7);
              if (BuildInfo.DEBUG) {
                Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl tmplType=" + k + ", Version=" + ((fnm)localObject7).crz);
              }
              ((Collection)localObject5).add(localObject7);
            }
            localObject5 = ((Iterable)kotlin.a.p.c((Iterable)kotlin.a.p.a((Iterable)localObject5, (Comparator)new d()), ((Number)vVV.getValue()).intValue())).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (fnm)((Iterator)localObject5).next();
              if (q.a((fnm)localObject6)) {
                ((ArrayList)localObject1).add(q.b((fnm)localObject6));
              }
              if (((fnm)localObject4).crz != ((fnm)localObject6).crz) {
                k((fnm)localObject6);
              }
            }
            i += 1;
          }
          if (BuildInfo.DEBUG) {
            Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl curFilePaths size=" + ((ArrayList)localObject1).size() + " %s", new Object[] { localObject1 });
          }
          localObject3 = new ArrayList();
          localObject2 = kotlin.g.b.c.ao((Object[])localObject2);
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (com.tencent.mm.vfs.u)((Iterator)localObject2).next();
            long l = ((com.tencent.mm.vfs.u)localObject4).lastModified();
            if (MMSlotKt.isExpire(l, 604800000L))
            {
              kotlin.g.b.s.s(localObject4, "file");
              if (!a((ArrayList)localObject1, (com.tencent.mm.vfs.u)localObject4)) {
                ((ArrayList)localObject3).add(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject4).jKT()));
              }
            }
            if ((BuildInfo.DEBUG) && (MMSlotKt.isExpire(l, 60000L)))
            {
              kotlin.g.b.s.s(localObject4, "file");
              if (!a((ArrayList)localObject1, (com.tencent.mm.vfs.u)localObject4)) {
                ((ArrayList)localObject3).add(com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject4).jKT()));
              }
            }
          }
          if (1 >= Log.getLogLevel())
          {
            Log.v("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("cleanInvalidTmpl curFilePaths size=", Integer.valueOf(((ArrayList)localObject1).size())));
            Log.v("MicroMsg.Preload.TmplInfoManager", "cleanInvalidTmpl deleteFilePaths %s", new Object[] { localObject3 });
          }
          localObject1 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            kotlin.g.b.s.s(localObject2, "filePath");
            if (q.ajz((String)localObject2).isDirectory()) {
              y.ew((String)localObject2, true);
            } else {
              y.deleteFile((String)localObject2);
            }
          }
        }
      }
    }
    Log.w("MicroMsg.Preload.TmplInfoManager", "files is null");
    AppMethodBeat.o(303216);
  }
  
  private static boolean e(String paramString, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(175496);
    if ((!Util.isNullOrNil(paramString)) && (kotlin.g.b.s.p(paramString, y.bub(com.tencent.mm.vfs.ah.v(paramu.mUri)))))
    {
      AppMethodBeat.o(175496);
      return true;
    }
    Log.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", new Object[] { com.tencent.mm.vfs.ah.v(paramu.jKT()) });
    AppMethodBeat.o(175496);
    return false;
  }
  
  private static boolean ga(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6861);
    paramString1 = (Closeable)new ZipFile(paramString1);
    try
    {
      ZipFile localZipFile = (ZipFile)paramString1;
      Enumeration localEnumeration = localZipFile.entries();
      arrayOfByte = new byte[1024];
      for (;;)
      {
        if (!localEnumeration.hasMoreElements()) {
          break label370;
        }
        localObject4 = (ZipEntry)localEnumeration.nextElement();
        localObject5 = ((ZipEntry)localObject4).getName();
        kotlin.g.b.s.s(localObject5, "name");
        if (kotlin.n.n.a((CharSequence)localObject5, "../", 0, false, 6) == -1) {
          break;
        }
        Log.e("MicroMsg.Preload.TmplInfoManager", "skip unzip break through file:%s", new Object[] { localObject5 });
      }
    }
    finally
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Object localObject4;
        try
        {
          AppMethodBeat.o(6861);
          throw paramString2;
        }
        finally
        {
          kotlin.f.b.a(paramString1, paramString2);
          AppMethodBeat.o(6861);
        }
        Object localObject5 = new com.tencent.mm.vfs.u(kotlin.g.b.s.X(paramString2, localObject5));
        Object localObject6 = ((com.tencent.mm.vfs.u)localObject5).jKO();
        kotlin.g.b.s.checkNotNull(localObject6);
        localObject6 = new com.tencent.mm.vfs.u((String)localObject6);
        if (!((com.tencent.mm.vfs.u)localObject6).jKS()) {
          ((com.tencent.mm.vfs.u)localObject6).jKY();
        }
        if (((ZipEntry)localObject4).isDirectory())
        {
          if (!((com.tencent.mm.vfs.u)localObject5).jKS()) {
            ((com.tencent.mm.vfs.u)localObject5).jKY();
          }
        }
        else
        {
          if (!((com.tencent.mm.vfs.u)localObject5).jKS()) {
            ((com.tencent.mm.vfs.u)localObject5).jKZ();
          }
          localObject4 = (Closeable)localObject1.getInputStream((ZipEntry)localObject4);
          try
          {
            localObject6 = (InputStream)localObject4;
            localObject5 = (Closeable)new BufferedOutputStream(y.ap((com.tencent.mm.vfs.u)localObject5));
            BufferedOutputStream localBufferedOutputStream;
            try
            {
              localBufferedOutputStream = (BufferedOutputStream)localObject5;
              for (;;)
              {
                int i = ((InputStream)localObject6).read(arrayOfByte);
                if (i <= 0) {
                  break;
                }
                localBufferedOutputStream.write(arrayOfByte, 0, i);
              }
              paramString2 = finally;
            }
            finally
            {
              try
              {
                AppMethodBeat.o(6861);
                throw paramString2;
              }
              finally
              {
                kotlin.f.b.a((Closeable)localObject5, paramString2);
                AppMethodBeat.o(6861);
              }
            }
          }
          finally
          {
            try
            {
              AppMethodBeat.o(6861);
              throw paramString2;
            }
            finally
            {
              kotlin.f.b.a((Closeable)localObject4, paramString2);
              AppMethodBeat.o(6861);
            }
            localBufferedOutputStream.flush();
            localObject6 = kotlin.ah.aiuX;
            kotlin.f.b.a((Closeable)localObject5, null);
            localObject5 = kotlin.ah.aiuX;
            kotlin.f.b.a((Closeable)localObject4, null);
          }
        }
      }
      label370:
      kotlin.f.b.a(paramString1, null);
      AppMethodBeat.o(6861);
    }
    return true;
  }
  
  public static final String getPrefix()
  {
    AppMethodBeat.i(303164);
    String str = vVQ;
    kotlin.g.b.s.s(str, "PREFIX");
    AppMethodBeat.o(303164);
    return str;
  }
  
  private static final boolean j(fnm paramfnm)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6854);
        if (paramfnm == null)
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
          AppMethodBeat.o(6854);
          return bool;
        }
        if (!q.a(paramfnm))
        {
          Log.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
          AppMethodBeat.o(6854);
          continue;
        }
        if (HO(paramfnm.vhJ).crz == paramfnm.crz) {
          break label90;
        }
      }
      finally {}
      AppMethodBeat.o(6854);
      continue;
      label90:
      if (!q.isFileValid(q.b(paramfnm)))
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
  
  private static void k(fnm paramfnm)
  {
    int i = 0;
    AppMethodBeat.i(303143);
    if (paramfnm == null)
    {
      AppMethodBeat.o(303143);
      return;
    }
    paramfnm = q.b(paramfnm);
    com.tencent.mm.vfs.u localu = q.ajz(paramfnm);
    if (!localu.isDirectory())
    {
      Log.w("MicroMsg.Preload.TmplInfoManager", "deleteInvalidCacheFile fileDir:%s is not dir, err", new Object[] { paramfnm });
      AppMethodBeat.o(303143);
      return;
    }
    paramfnm = localu.jKX();
    if (paramfnm == null)
    {
      AppMethodBeat.o(303143);
      return;
    }
    int j = paramfnm.length;
    for (;;)
    {
      if (i < j)
      {
        localu = paramfnm[i];
        i += 1;
        Object localObject = com.tencent.mm.vfs.ah.v(localu.jKT());
        kotlin.g.b.s.s(localObject, "file.absolutePath");
        localObject = (CharSequence)localObject;
        if (!((kotlin.n.k)vVW.getValue()).bm((CharSequence)localObject))
        {
          localObject = com.tencent.mm.vfs.ah.v(localu.jKT());
          kotlin.g.b.s.s(localObject, "file.absolutePath");
          if (!kotlin.n.n.rs((String)localObject, ".js.utf16")) {}
        }
        else
        {
          localu.diJ();
          Log.d("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("deleteInvalidCacheFile file ", com.tencent.mm.vfs.ah.v(localu.mUri)));
        }
      }
      else
      {
        AppMethodBeat.o(303143);
        return;
      }
    }
  }
  
  private static String l(fnm paramfnm)
  {
    AppMethodBeat.i(6858);
    paramfnm = "Type:" + paramfnm.vhJ + " Version:" + paramfnm.crz + " CdnUrl:" + paramfnm.YTj + " Md5:" + paramfnm.Md5;
    AppMethodBeat.o(6858);
    return paramfnm;
  }
  
  public static final LinkedList<abv> mY(boolean paramBoolean)
  {
    AppMethodBeat.i(303064);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = dgL();
    Object localObject2 = (Collection)new ArrayList();
    int k = localObject1.length;
    int i = 0;
    Object localObject3;
    if (i < k)
    {
      localObject3 = localObject1[i];
      int j = ((Number)localObject3).intValue();
      if ((paramBoolean) || (HN(j))) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject2).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    label265:
    label420:
    label423:
    while (((Iterator)localObject2).hasNext())
    {
      i = ((Number)((Iterator)localObject2).next()).intValue();
      vVU.add(Integer.valueOf(i));
      ((Map)vVT).put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
      localObject3 = new abv();
      ((abv)localObject3).vhJ = i;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.GV(101)) {
        ((abv)localObject3).Zkt = q.dfE();
      }
      localLinkedList.add(localObject3);
      localObject1 = HP(i);
      if (q.a((fnm)localObject1))
      {
        if (q.isFileValid(q.b((fnm)localObject1))) {
          ((abv)localObject3).Zks = ((fnm)localObject1).aalQ;
        }
        Object localObject4 = q.dfF().getStringSet(q.h((fnm)localObject1), null);
        if (localObject4 == null)
        {
          localObject1 = null;
          localObject4 = (Collection)localObject1;
          if ((localObject4 != null) && (!((Collection)localObject4).isEmpty())) {
            break label420;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label423;
          }
          ((abv)localObject3).Zkr.addAll((Collection)localObject1);
          break;
          Object localObject5 = (Iterable)localObject4;
          localObject4 = (Collection)new ArrayList();
          localObject5 = ((Iterable)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            Object localObject6 = ((Iterator)localObject5).next();
            String str = (String)localObject6;
            fnm localfnm = new fnm();
            kotlin.g.b.s.s(str, "it");
            if (a(a(localfnm, i, str), (fnm)localObject1)) {
              ((Collection)localObject4).add(localObject6);
            }
          }
          localObject1 = (List)localObject4;
          break label265;
        }
      }
    }
    AppMethodBeat.o(303064);
    return localLinkedList;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "", "()V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "isZip", "", "()Z", "setZip", "(Z)V", "patchBase", "", "getPatchBase", "()Ljava/lang/String;", "setPatchBase", "(Ljava/lang/String;)V", "patchMD5", "getPatchMD5", "setPatchMD5", "success", "getSuccess", "setSuccess", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    Exception exception;
    boolean qon;
    boolean success;
    String vVX;
    String vVY;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer[]>
  {
    public static final b vVZ;
    
    static
    {
      AppMethodBeat.i(6828);
      vVZ = new b();
      AppMethodBeat.o(6828);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/text/Regex;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.n.k>
  {
    public static final c vWa;
    
    static
    {
      AppMethodBeat.i(303028);
      vWa = new c();
      AppMethodBeat.o(303028);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class d<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(303027);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((fnm)paramT2).crz), (Comparable)Integer.valueOf(((fnm)paramT1).crz));
      AppMethodBeat.o(303027);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super kotlin.ah>, Object>
  {
    Object L$0;
    int label;
    
    e(fnm paramfnm, int paramInt, kotlin.g.a.a<kotlin.ah> parama, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(6836);
      paramObject = (d)new e(this.vWb, paramInt, parama, paramd);
      AppMethodBeat.o(6836);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(6835);
      Object localObject3 = kotlin.d.a.a.aiwj;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6835);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new HashMap();
        localObject1 = this.vWb.YTj;
        localObject2 = this.vWb.abNu;
        kotlin.g.b.s.s(localObject2, "tmplInfo.HttpHeaderList");
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (fnl)((Iterator)localObject2).next();
          Object localObject5 = (CharSequence)((fnl)localObject4).ILw;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject5 = (CharSequence)((fnl)localObject4).OzQ;
            if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
              break label241;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject5 = (Map)paramObject;
            String str = ((fnl)localObject4).ILw;
            kotlin.g.b.s.s(str, "it.Key");
            localObject4 = ((fnl)localObject4).OzQ;
            kotlin.g.b.s.s(localObject4, "it.Value");
            ((Map)localObject5).put(str, localObject4);
            break;
            i = 0;
            break label152;
          }
        }
        if (!this.vWb.abNv) {
          break label420;
        }
        localObject2 = b.vVO;
        kotlin.g.b.s.s(localObject1, "downloadUrl");
        localObject2 = (d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = b.b((String)localObject1, paramObject, (d)localObject2);
        localObject1 = localObject2;
        if (localObject2 == localObject3)
        {
          AppMethodBeat.o(6835);
          return localObject3;
        }
        break;
      case 1: 
        label152:
        label241:
        localObject2 = (HashMap)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      Object localObject1 = (String)localObject1;
      Object localObject2 = this.vWb;
      int j = paramInt;
      localObject3 = parama;
      Object localObject4 = (CharSequence)localObject1;
      if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
      {
        i = 1;
        label381:
        if (i != 0) {
          break label428;
        }
        localObject4 = b.vVO;
        kotlin.g.b.s.s(localObject1, "fullUrl");
        b.a((String)localObject1, (fnm)localObject2, paramObject, j, (kotlin.g.a.a)localObject3);
      }
      for (;;)
      {
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(6835);
        return paramObject;
        label420:
        break;
        i = 0;
        break label381;
        label428:
        paramObject = b.vVO;
        Log.e("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("url is null or empty:", b.m((fnm)localObject2)));
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    implements com.tencent.mm.am.h
  {
    f(d<? super String> paramd, HashMap<String, String> paramHashMap) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(303041);
      Log.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramp.setHasCallbackToQueue(true);
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null) {
          try
          {
            paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelsimple.NetSceneGetA8Key");
            AppMethodBeat.o(303041);
            throw paramString;
          }
          catch (Exception paramString)
          {
            Log.e("MicroMsg.Preload.TmplInfoManager", kotlin.g.b.s.X("NetSceneGetA8Key ex ", paramString.getMessage()));
            AppMethodBeat.o(303041);
            return;
          }
        }
        paramString = (com.tencent.mm.modelsimple.n)paramp;
        paramp = paramString.bMb();
        kotlin.g.b.s.s(paramp, "netSceneGetA8Key.httpHeader");
        localObject1 = (Iterable)paramp;
        paramp = paramHashMap;
        localObject1 = ((Iterable)localObject1).iterator();
      }
      label182:
      label328:
      label333:
      label338:
      label341:
      label343:
      label346:
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dam)((Iterator)localObject1).next();
          localObject3 = (CharSequence)((dam)localObject2).ILw;
          if (localObject3 == null) {
            break label328;
          }
          if (((CharSequence)localObject3).length() != 0) {
            break label338;
          }
          break label328;
          if (paramInt1 != 0) {
            break label341;
          }
          localObject3 = (CharSequence)((dam)localObject2).OzQ;
          if (localObject3 == null) {
            break label333;
          }
          if (((CharSequence)localObject3).length() != 0) {
            break label343;
          }
          break label333;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            break label346;
          }
          localObject3 = (Map)paramp;
          String str = ((dam)localObject2).ILw;
          kotlin.g.b.s.s(str, "it.Key");
          localObject2 = ((dam)localObject2).OzQ;
          kotlin.g.b.s.s(localObject2, "it.Value");
          ((Map)localObject3).put(str, localObject2);
          break;
          paramp = this.ntL;
          paramString = paramString.bLT();
          localObject1 = Result.Companion;
          paramp.resumeWith(Result.constructor-impl(paramString));
          AppMethodBeat.o(303041);
          return;
          paramString = this.ntL;
          paramp = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(""));
          AppMethodBeat.o(303041);
          return;
          paramInt1 = 1;
          break label182;
          paramInt1 = 1;
          continue;
          paramInt1 = 0;
          break label182;
          break;
          paramInt1 = 0;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    g(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    public static final h vWd;
    
    static
    {
      AppMethodBeat.i(303024);
      vWd = new h();
      AppMethodBeat.o(303024);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.b
 * JD-Core Version:    0.7.0.1
 */