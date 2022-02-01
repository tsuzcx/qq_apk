package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.protocal.protobuf.dci;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import d.g.a.m;
import d.g.b.u;
import d.g.b.w;
import d.p;
import d.v;
import d.y;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplType", "download", "url", "tmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Lcom/tencent/mm/vfs/VFSFile;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", "dir", "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "debugInfo", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"})
public final class b
{
  private static final String PREFIX = "https://mp.weixin.qq.com/__tmpl__/";
  private static final d.f ngD;
  private static final int ngE = 60000;
  private static final ConcurrentHashMap<Integer, Long> ngF;
  private static final ArrayList<Integer> ngG;
  public static final b ngH;
  
  static
  {
    AppMethodBeat.i(6840);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(b.class), "SUPPORT_TMPL_TYPES", "getSUPPORT_TMPL_TYPES()[Ljava/lang/Integer;")) };
    ngH = new b();
    PREFIX = "https://mp.weixin.qq.com/__tmpl__/";
    ngD = d.g.E((d.g.a.a)b.ngK);
    ngE = 60000;
    ngF = new ConcurrentHashMap();
    ngG = new ArrayList();
    AppMethodBeat.o(6840);
  }
  
  /* Error */
  private static a a(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: sipush 6862
    //   3: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a
    //   9: dup
    //   10: invokespecial 211	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:<init>	()V
    //   13: astore 7
    //   15: new 213	com/tencent/mm/vfs/e
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 216	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   23: astore 8
    //   25: aload 8
    //   27: invokevirtual 220	com/tencent/mm/vfs/e:exists	()Z
    //   30: ifeq +9 -> 39
    //   33: aload 8
    //   35: invokevirtual 223	com/tencent/mm/vfs/e:delete	()Z
    //   38: pop
    //   39: new 225	java/net/URL
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 226	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 230	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnonnull +98 -> 152
    //   57: new 232	d/v
    //   60: dup
    //   61: ldc 234
    //   63: invokespecial 235	d/v:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: sipush 6862
    //   70: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_2
    //   74: athrow
    //   75: astore_2
    //   76: ldc 237
    //   78: aload_2
    //   79: checkcast 210	java/lang/Throwable
    //   82: new 239	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 241
    //   88: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_3
    //   92: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 248
    //   97: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 258	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 7
    //   116: aload_2
    //   117: checkcast 260	java/lang/Exception
    //   120: putfield 264	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   123: iload_0
    //   124: bipush 7
    //   126: invokestatic 270	com/tencent/mm/plugin/webview/g/a:fL	(II)V
    //   129: aload 8
    //   131: invokevirtual 220	com/tencent/mm/vfs/e:exists	()Z
    //   134: ifeq +9 -> 143
    //   137: aload 8
    //   139: invokevirtual 223	com/tencent/mm/vfs/e:delete	()Z
    //   142: pop
    //   143: sipush 6862
    //   146: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 7
    //   151: areturn
    //   152: aload 6
    //   154: checkcast 272	java/net/HttpURLConnection
    //   157: astore 9
    //   159: aload 9
    //   161: ldc_w 274
    //   164: ldc_w 276
    //   167: invokevirtual 280	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 9
    //   172: ldc_w 274
    //   175: ldc_w 282
    //   178: invokevirtual 280	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload 9
    //   183: iconst_0
    //   184: invokevirtual 286	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   187: aload_2
    //   188: ifnull +218 -> 406
    //   191: aload_2
    //   192: invokeinterface 291 1 0
    //   197: ifne +203 -> 400
    //   200: iconst_1
    //   201: istore 4
    //   203: iload 4
    //   205: ifeq +201 -> 406
    //   208: ldc 237
    //   210: ldc_w 293
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_2
    //   220: invokeinterface 297 1 0
    //   225: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: aastore
    //   229: invokestatic 306	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_2
    //   233: invokeinterface 310 1 0
    //   238: invokeinterface 316 1 0
    //   243: astore 6
    //   245: aload 6
    //   247: invokeinterface 321 1 0
    //   252: ifeq +154 -> 406
    //   255: aload 6
    //   257: invokeinterface 325 1 0
    //   262: checkcast 327	java/lang/String
    //   265: astore 10
    //   267: aload 9
    //   269: aload 10
    //   271: aload_2
    //   272: aload 10
    //   274: invokeinterface 331 2 0
    //   279: checkcast 327	java/lang/String
    //   282: invokevirtual 280	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: goto -40 -> 245
    //   288: astore_2
    //   289: sipush 6862
    //   292: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload_2
    //   296: athrow
    //   297: astore_2
    //   298: aload 9
    //   300: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   303: astore 6
    //   305: aload 6
    //   307: ifnull +8 -> 315
    //   310: aload 6
    //   312: invokevirtual 340	java/io/InputStream:close	()V
    //   315: aload 9
    //   317: invokevirtual 343	java/net/HttpURLConnection:disconnect	()V
    //   320: sipush 6862
    //   323: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_2
    //   327: athrow
    //   328: astore_2
    //   329: ldc 237
    //   331: aload_2
    //   332: checkcast 210	java/lang/Throwable
    //   335: new 239	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 345
    //   342: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload_3
    //   346: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc 248
    //   351: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_1
    //   355: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 258	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: aload 7
    //   370: aload_2
    //   371: checkcast 260	java/lang/Exception
    //   374: putfield 264	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   377: iload_0
    //   378: bipush 7
    //   380: invokestatic 270	com/tencent/mm/plugin/webview/g/a:fL	(II)V
    //   383: aload 8
    //   385: invokevirtual 220	com/tencent/mm/vfs/e:exists	()Z
    //   388: ifeq -245 -> 143
    //   391: aload 8
    //   393: invokevirtual 223	com/tencent/mm/vfs/e:delete	()Z
    //   396: pop
    //   397: goto -254 -> 143
    //   400: iconst_0
    //   401: istore 4
    //   403: goto -200 -> 203
    //   406: aload 9
    //   408: iconst_0
    //   409: invokevirtual 348	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   412: aload 9
    //   414: ldc_w 350
    //   417: invokevirtual 353	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   420: aload 9
    //   422: sipush 10000
    //   425: invokevirtual 356	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   428: aload 9
    //   430: sipush 3000
    //   433: invokevirtual 359	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   436: aload 9
    //   438: invokevirtual 362	java/net/HttpURLConnection:connect	()V
    //   441: aload 9
    //   443: invokevirtual 365	java/net/HttpURLConnection:getResponseCode	()I
    //   446: istore 4
    //   448: iload 4
    //   450: sipush 200
    //   453: if_icmpne +219 -> 672
    //   456: aload 8
    //   458: invokevirtual 368	com/tencent/mm/vfs/e:createNewFile	()Z
    //   461: pop
    //   462: sipush 8192
    //   465: newarray byte
    //   467: astore_2
    //   468: new 370	d/g/b/v$c
    //   471: dup
    //   472: invokespecial 371	d/g/b/v$c:<init>	()V
    //   475: astore 11
    //   477: aload 8
    //   479: invokestatic 377	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   482: checkcast 379	java/io/Closeable
    //   485: astore 10
    //   487: aconst_null
    //   488: astore 6
    //   490: aload 10
    //   492: checkcast 381	java/io/OutputStream
    //   495: astore 12
    //   497: aload 9
    //   499: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   502: aload_2
    //   503: invokevirtual 385	java/io/InputStream:read	([B)I
    //   506: istore 4
    //   508: aload 11
    //   510: iload 4
    //   512: putfield 388	d/g/b/v$c:Jhu	I
    //   515: iload 4
    //   517: iconst_m1
    //   518: if_icmpeq +45 -> 563
    //   521: aload 12
    //   523: aload_2
    //   524: iconst_0
    //   525: aload 11
    //   527: getfield 388	d/g/b/v$c:Jhu	I
    //   530: invokevirtual 392	java/io/OutputStream:write	([BII)V
    //   533: goto -36 -> 497
    //   536: astore 6
    //   538: sipush 6862
    //   541: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   544: aload 6
    //   546: athrow
    //   547: astore_2
    //   548: aload 10
    //   550: aload 6
    //   552: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   555: sipush 6862
    //   558: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   561: aload_2
    //   562: athrow
    //   563: getstatic 403	d/y:JfV	Ld/y;
    //   566: astore_2
    //   567: aload 10
    //   569: aconst_null
    //   570: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   573: aload 7
    //   575: iconst_1
    //   576: putfield 406	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:success	Z
    //   579: aload 7
    //   581: aload 9
    //   583: ldc_w 408
    //   586: invokevirtual 412	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   589: putfield 415	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:ngI	Ljava/lang/String;
    //   592: aload 7
    //   594: aload 9
    //   596: ldc_w 417
    //   599: invokevirtual 412	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   602: putfield 420	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:ngJ	Ljava/lang/String;
    //   605: aload 9
    //   607: ldc_w 422
    //   610: invokevirtual 412	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   613: astore_2
    //   614: aload_2
    //   615: ifnull +51 -> 666
    //   618: ldc_w 424
    //   621: aload_2
    //   622: invokestatic 430	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   625: iconst_1
    //   626: ixor
    //   627: ifeq +39 -> 666
    //   630: iconst_1
    //   631: istore 5
    //   633: aload 7
    //   635: iload 5
    //   637: putfield 433	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:ndo	Z
    //   640: getstatic 403	d/y:JfV	Ld/y;
    //   643: astore_2
    //   644: aload 9
    //   646: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   649: astore_2
    //   650: aload_2
    //   651: ifnull +7 -> 658
    //   654: aload_2
    //   655: invokevirtual 340	java/io/InputStream:close	()V
    //   658: aload 9
    //   660: invokevirtual 343	java/net/HttpURLConnection:disconnect	()V
    //   663: goto -520 -> 143
    //   666: iconst_0
    //   667: istore 5
    //   669: goto -36 -> 633
    //   672: ldc 237
    //   674: ldc_w 435
    //   677: iload 4
    //   679: invokestatic 437	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   682: invokevirtual 440	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   685: invokestatic 443	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: iload 4
    //   690: sipush 500
    //   693: if_icmple +12 -> 705
    //   696: iload_0
    //   697: bipush 11
    //   699: invokestatic 270	com/tencent/mm/plugin/webview/g/a:fL	(II)V
    //   702: goto -62 -> 640
    //   705: iload 4
    //   707: sipush 400
    //   710: if_icmple -70 -> 640
    //   713: iload_0
    //   714: bipush 10
    //   716: invokestatic 270	com/tencent/mm/plugin/webview/g/a:fL	(II)V
    //   719: goto -79 -> 640
    //   722: astore 6
    //   724: goto -409 -> 315
    //   727: astore_2
    //   728: goto -70 -> 658
    //   731: astore_2
    //   732: goto -184 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	735	0	paramInt	int
    //   0	735	1	paramString1	String
    //   0	735	2	paramMap	Map<String, String>
    //   0	735	3	paramString2	String
    //   201	510	4	i	int
    //   631	37	5	bool	boolean
    //   50	439	6	localObject1	Object
    //   536	15	6	localThrowable1	Throwable
    //   722	1	6	localThrowable2	Throwable
    //   13	621	7	locala	a
    //   23	455	8	locale	e
    //   157	502	9	localHttpURLConnection	java.net.HttpURLConnection
    //   265	303	10	localObject2	Object
    //   475	51	11	localc	d.g.b.v.c
    //   495	27	12	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   39	52	75	java/io/FileNotFoundException
    //   57	75	75	java/io/FileNotFoundException
    //   152	159	75	java/io/FileNotFoundException
    //   298	305	75	java/io/FileNotFoundException
    //   310	315	75	java/io/FileNotFoundException
    //   315	328	75	java/io/FileNotFoundException
    //   644	650	75	java/io/FileNotFoundException
    //   654	658	75	java/io/FileNotFoundException
    //   658	663	75	java/io/FileNotFoundException
    //   159	187	288	java/lang/Throwable
    //   191	200	288	java/lang/Throwable
    //   208	245	288	java/lang/Throwable
    //   245	285	288	java/lang/Throwable
    //   406	448	288	java/lang/Throwable
    //   456	487	288	java/lang/Throwable
    //   548	563	288	java/lang/Throwable
    //   567	614	288	java/lang/Throwable
    //   618	630	288	java/lang/Throwable
    //   633	640	288	java/lang/Throwable
    //   640	644	288	java/lang/Throwable
    //   672	688	288	java/lang/Throwable
    //   696	702	288	java/lang/Throwable
    //   713	719	288	java/lang/Throwable
    //   159	187	297	finally
    //   191	200	297	finally
    //   208	245	297	finally
    //   245	285	297	finally
    //   289	297	297	finally
    //   406	448	297	finally
    //   456	487	297	finally
    //   548	563	297	finally
    //   567	614	297	finally
    //   618	630	297	finally
    //   633	640	297	finally
    //   640	644	297	finally
    //   672	688	297	finally
    //   696	702	297	finally
    //   713	719	297	finally
    //   39	52	328	java/io/IOException
    //   57	75	328	java/io/IOException
    //   152	159	328	java/io/IOException
    //   298	305	328	java/io/IOException
    //   310	315	328	java/io/IOException
    //   315	328	328	java/io/IOException
    //   644	650	328	java/io/IOException
    //   654	658	328	java/io/IOException
    //   658	663	328	java/io/IOException
    //   490	497	536	java/lang/Throwable
    //   497	515	536	java/lang/Throwable
    //   521	533	536	java/lang/Throwable
    //   563	567	536	java/lang/Throwable
    //   538	547	547	finally
    //   298	305	722	java/lang/Throwable
    //   310	315	722	java/lang/Throwable
    //   644	650	727	java/lang/Throwable
    //   654	658	727	java/lang/Throwable
    //   490	497	731	finally
    //   497	515	731	finally
    //   521	533	731	finally
    //   563	567	731	finally
  }
  
  private static dcg a(dcg paramdcg, int paramInt, String paramString)
  {
    AppMethodBeat.i(6848);
    paramdcg.mBH = paramInt;
    paramdcg.DoR = paramString;
    byte[] arrayOfByte = r.bDU().decodeBytes(r.e(paramdcg));
    int i;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {}
      try
      {
        paramdcg.parseFrom(arrayOfByte);
        AppMethodBeat.o(6848);
        return paramdcg;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", (Throwable)localException, "decode TmplInfo:" + paramInt + ", " + paramString, new Object[0]);
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
        d.g.b.k.h(paramString, "netType");
        d.g.b.k.h(paramVarArgs, "tmplTypes");
        if (ay.is2G(aj.getContext()))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
          AppMethodBeat.o(6844);
          return;
        }
        paramVarArgs = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.ndS;
        if ((!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) && (com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.buO().getInt("preload_type", 1) == 3))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.er("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
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
      ngF.clear();
    }
    final LinkedList localLinkedList = new LinkedList();
    paramVarArgs = bEq();
    Object localObject1 = (Collection)new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    label150:
    Object localObject2;
    if (i < j)
    {
      int m = paramVarArgs[i];
      int k = ((Number)m).intValue();
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.ndS;
      boolean bool;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.buO().getBoolean("preload_tmpl_always_check_tmpl_ver", false)) {
        bool = true;
      }
      while (bool)
      {
        ((Collection)localObject1).add(m);
        break;
        long l = 0L;
        if (ngF.containsKey(Integer.valueOf(k)))
        {
          localObject2 = ngF.get(Integer.valueOf(k));
          if (localObject2 == null) {
            d.g.b.k.fvU();
          }
          l = ((Number)localObject2).longValue();
        }
        if (ngG.contains(Integer.valueOf(k)))
        {
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(k) });
          bool = false;
        }
        else
        {
          bool = as.au(l, r.bDU().getLong("_check_time_colddown", ngE));
        }
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    label586:
    label715:
    label718:
    for (;;)
    {
      label336:
      vr localvr;
      if (((Iterator)localObject1).hasNext())
      {
        i = ((Number)((Iterator)localObject1).next()).intValue();
        ngG.add(Integer.valueOf(i));
        ((Map)ngF).put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        localvr = new vr();
        localvr.mBH = i;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.j.xA(101)) {
          localvr.CXM = r.bDT();
        }
        localLinkedList.add(localvr);
        paramVarArgs = yn(i);
        if (!r.a(paramVarArgs)) {
          continue;
        }
        if (r.PH(r.b(paramVarArgs))) {
          localvr.CXL = paramVarArgs.DoR;
        }
        localObject2 = r.bDU().getStringSet(r.h(paramVarArgs), null);
        if (localObject2 == null) {
          break label710;
        }
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          String str = (String)localObject4;
          dcg localdcg = new dcg();
          d.g.b.k.g(str, "it");
          if (a(a(localdcg, i, str), paramVarArgs)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        paramVarArgs = (List)localObject2;
        localObject2 = (Collection)paramVarArgs;
        if (localObject2 == null) {
          break label705;
        }
        if (!((Collection)localObject2).isEmpty()) {
          break label715;
        }
        break label705;
      }
      for (;;)
      {
        if (i != 0) {
          break label718;
        }
        localvr.CXK.addAll((Collection)paramVarArgs);
        break label336;
        if (!((Collection)localLinkedList).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.plugin.webview.g.a.lI(0);
            new a(localLinkedList, paramInt, paramString).auK().g((com.tencent.mm.vending.c.a)new c(paramInt, localLinkedList));
          }
          AppMethodBeat.o(6844);
          break;
        }
        i += 1;
        break label150;
        i = 1;
        continue;
        paramVarArgs = null;
        break label586;
        i = 0;
      }
    }
  }
  
  public static void a(dch paramdch, boolean paramBoolean)
  {
    AppMethodBeat.i(193230);
    d.g.b.k.h(paramdch, "tmplParams");
    String str = "_tmpl_info_inject_fail_-" + paramdch.nee + '-' + paramdch.yaG;
    if (paramBoolean)
    {
      r.bDU().removeValueForKey(str);
      AppMethodBeat.o(193230);
      return;
    }
    int i = r.bDU().getInt(str, 0) + 1;
    r.bDU().putInt(str, i);
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + paramdch.nee + ',' + paramdch.yaG + ',' + i);
    if (i > 2)
    {
      com.tencent.mm.plugin.webview.g.a.lI(219);
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + paramdch.nee + ',' + paramdch.yaG + ',' + i);
    }
    AppMethodBeat.o(193230);
  }
  
  private static boolean a(dcg paramdcg1, dcg paramdcg2)
  {
    AppMethodBeat.i(6849);
    if (r.PG(r.b(paramdcg1)).exists())
    {
      if (b(paramdcg1, paramdcg2))
      {
        r.bDU().putString(r.f(paramdcg1), paramdcg1.DoR);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.b(r.bDU(), r.g(paramdcg1));
        AppMethodBeat.o(6849);
        return true;
      }
      if (d.g.b.k.g(r.e(paramdcg1), r.bDU().getString(r.f(paramdcg1), null)))
      {
        r.bDU().removeValueForKey(r.f(paramdcg1));
        r.bDU().removeValueForKey(r.g(paramdcg1));
      }
      r.bDU().remove(r.e(paramdcg1));
      paramdcg2 = r.h(paramdcg2);
      Set localSet = r.bDU().getStringSet(paramdcg2, null);
      if (localSet != null)
      {
        localSet.remove(paramdcg1.DoR);
        r.bDU().putStringSet(paramdcg2, localSet);
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramdcg1.DoR + " is invalid");
    }
    for (;;)
    {
      AppMethodBeat.o(6849);
      return false;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + paramdcg1.DoR);
    }
  }
  
  private static dcg aA(int paramInt, String paramString)
  {
    AppMethodBeat.i(6852);
    dcg localdcg1 = ym(paramInt);
    if (r.a(localdcg1))
    {
      if ((r.PH(r.b(localdcg1))) && ((d.g.b.k.g(localdcg1.DoR, paramString) ^ true)))
      {
        AppMethodBeat.o(6852);
        return localdcg1;
      }
      Object localObject1 = r.bDU().getString(r.f(localdcg1), null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new dcg();
        d.g.b.k.g(localObject1, "it");
        localObject1 = a((dcg)localObject2, paramInt, (String)localObject1);
        if ((localObject1 != null) && (r.a((dcg)localObject1)) && (!r.i((dcg)localObject1)) && (r.PH(r.b((dcg)localObject1))) && ((d.g.b.k.g(((dcg)localObject1).DoR, paramString) ^ true)))
        {
          AppMethodBeat.o(6852);
          return localObject1;
        }
      }
      localObject1 = r.bDU().getStringSet(r.h(localdcg1), null);
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        d.g.b.k.h(localObject1, "$this$sortedDescending");
        localObject2 = d.b.f.Jgt;
        if (localObject2 == null)
        {
          paramString = new v("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
          AppMethodBeat.o(6852);
          throw paramString;
        }
        localObject1 = d.a.j.a((Iterable)localObject1, (Comparator)localObject2);
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if ((d.g.b.k.g(localObject2, paramString) ^ true))
            {
              dcg localdcg2 = new dcg();
              d.g.b.k.g(localObject2, "uid");
              localObject2 = a(localdcg2, paramInt, (String)localObject2);
              if (a((dcg)localObject2, localdcg1))
              {
                AppMethodBeat.o(6852);
                return localObject2;
              }
            }
          }
        }
      }
    }
    paramString = new dcg();
    AppMethodBeat.o(6852);
    return paramString;
  }
  
  private static boolean b(dcg paramdcg1, dcg paramdcg2)
  {
    AppMethodBeat.i(6850);
    if ((d.g.b.k.g(paramdcg1, paramdcg2)) && (paramdcg1.Version != 0))
    {
      AppMethodBeat.o(6850);
      return true;
    }
    int i = paramdcg2.CXP;
    Object localObject;
    if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() == 0)
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.ndS;
      int j = g.a.bDF();
      if (j > 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (paramdcg1.Version < i)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramdcg1.DoR + " version:" + paramdcg1.Version + " < " + i);
        AppMethodBeat.o(6850);
        return false;
      }
      paramdcg2 = paramdcg2.EtK;
      d.g.b.k.g(paramdcg2, "standard.VersionControlList");
      paramdcg2 = ((Iterable)paramdcg2).iterator();
      while (paramdcg2.hasNext())
      {
        localObject = (dci)paramdcg2.next();
        if (d.g.b.k.g(((dci)localObject).DoR, paramdcg1.DoR))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + ((dci)localObject).DoR + " matchControls in forceH5:" + ((dci)localObject).EtO);
          if (!((dci)localObject).EtO)
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
  
  public static Integer[] bEq()
  {
    AppMethodBeat.i(6841);
    Integer[] arrayOfInteger = (Integer[])ngD.getValue();
    AppMethodBeat.o(6841);
    return arrayOfInteger;
  }
  
  public static final void bEr()
  {
    AppMethodBeat.i(6855);
    com.tencent.e.h.Iye.f((Runnable)d.ngM, "tmplPreload");
    AppMethodBeat.o(6855);
  }
  
  public static final String bEs()
  {
    AppMethodBeat.i(6857);
    String str = com.tencent.mm.loader.j.b.ahZ() + "webview_tmpl/";
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.ndS;
    if (g.a.bDE())
    {
      str = com.tencent.mm.loader.j.b.aih();
      d.g.b.k.g(str, "CConstants.DATAROOT_SDCARD_PATH()");
    }
    localObject = str;
    if (!d.n.n.mB(str, "/")) {
      localObject = str + "/";
    }
    str = (String)localObject + "tmpls/";
    com.tencent.mm.sdk.platformtools.l.aAk(str);
    AppMethodBeat.o(6857);
    return str;
  }
  
  public static final String bEt()
  {
    return "https://mp.weixin.qq.com/__tmpl__/";
  }
  
  private static boolean c(String paramString, e parame)
  {
    AppMethodBeat.i(175496);
    if ((!bt.isNullOrNil(paramString)) && (d.g.b.k.g(paramString, com.tencent.mm.vfs.i.aEN(parame.getPath()))))
    {
      AppMethodBeat.o(175496);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", new Object[] { parame.getAbsolutePath() });
    AppMethodBeat.o(175496);
    return false;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(6845);
    r.bDU().clear();
    com.tencent.mm.vfs.i.cO(bEs(), true);
    com.tencent.mm.vfs.i.deleteDir(com.tencent.mm.loader.j.b.ahZ() + "/jscache/");
    AppMethodBeat.o(6845);
  }
  
  /* Error */
  private static boolean eu(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 6861
    //   3: invokestatic 144	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1238	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1239	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: checkcast 379	java/io/Closeable
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 1238	java/util/zip/ZipFile
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 1243	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   27: astore 6
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 7
    //   36: new 370	d/g/b/v$c
    //   39: dup
    //   40: invokespecial 371	d/g/b/v$c:<init>	()V
    //   43: astore 8
    //   45: aload 6
    //   47: invokeinterface 1248 1 0
    //   52: ifeq +349 -> 401
    //   55: aload 6
    //   57: invokeinterface 1251 1 0
    //   62: checkcast 1253	java/util/zip/ZipEntry
    //   65: astore 4
    //   67: aload 4
    //   69: ldc_w 1255
    //   72: invokestatic 513	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 4
    //   77: invokevirtual 1256	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ldc_w 1258
    //   87: invokestatic 513	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload 5
    //   92: checkcast 783	java/lang/CharSequence
    //   95: ldc_w 1260
    //   98: iconst_0
    //   99: iconst_0
    //   100: bipush 6
    //   102: invokestatic 1263	d/n/n:a	(Ljava/lang/CharSequence;Ljava/lang/String;IZI)I
    //   105: iconst_m1
    //   106: if_icmpeq +46 -> 152
    //   109: ldc 237
    //   111: ldc_w 1265
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 5
    //   122: aastore
    //   123: invokestatic 979	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -81 -> 45
    //   129: astore_1
    //   130: sipush 6861
    //   133: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_3
    //   140: aload_1
    //   141: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: sipush 6861
    //   147: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: new 213	com/tencent/mm/vfs/e
    //   155: dup
    //   156: new 239	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 774	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 216	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: new 213	com/tencent/mm/vfs/e
    //   183: dup
    //   184: aload 5
    //   186: invokevirtual 1268	com/tencent/mm/vfs/e:getParent	()Ljava/lang/String;
    //   189: invokespecial 216	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   192: astore 9
    //   194: aload 9
    //   196: invokevirtual 220	com/tencent/mm/vfs/e:exists	()Z
    //   199: ifne +9 -> 208
    //   202: aload 9
    //   204: invokevirtual 1271	com/tencent/mm/vfs/e:mkdirs	()Z
    //   207: pop
    //   208: aload 4
    //   210: invokevirtual 1272	java/util/zip/ZipEntry:isDirectory	()Z
    //   213: ifeq +20 -> 233
    //   216: aload 5
    //   218: invokevirtual 220	com/tencent/mm/vfs/e:exists	()Z
    //   221: ifne -176 -> 45
    //   224: aload 5
    //   226: invokevirtual 1275	com/tencent/mm/vfs/e:mkdir	()Z
    //   229: pop
    //   230: goto -185 -> 45
    //   233: aload 5
    //   235: invokevirtual 220	com/tencent/mm/vfs/e:exists	()Z
    //   238: ifne +9 -> 247
    //   241: aload 5
    //   243: invokevirtual 368	com/tencent/mm/vfs/e:createNewFile	()Z
    //   246: pop
    //   247: aload_0
    //   248: aload 4
    //   250: invokevirtual 1278	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   253: checkcast 379	java/io/Closeable
    //   256: astore 4
    //   258: aload 4
    //   260: checkcast 337	java/io/InputStream
    //   263: astore 9
    //   265: new 1280	java/io/BufferedOutputStream
    //   268: dup
    //   269: aload 5
    //   271: invokestatic 377	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   274: invokespecial 1283	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   277: checkcast 379	java/io/Closeable
    //   280: astore 5
    //   282: aload 5
    //   284: checkcast 1280	java/io/BufferedOutputStream
    //   287: astore 10
    //   289: aload 9
    //   291: aload 7
    //   293: invokevirtual 385	java/io/InputStream:read	([B)I
    //   296: istore_2
    //   297: aload 8
    //   299: iload_2
    //   300: putfield 388	d/g/b/v$c:Jhu	I
    //   303: iload_2
    //   304: ifle +67 -> 371
    //   307: aload 10
    //   309: aload 7
    //   311: iconst_0
    //   312: aload 8
    //   314: getfield 388	d/g/b/v$c:Jhu	I
    //   317: invokevirtual 1284	java/io/BufferedOutputStream:write	([BII)V
    //   320: goto -31 -> 289
    //   323: astore_1
    //   324: sipush 6861
    //   327: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_1
    //   331: athrow
    //   332: astore_0
    //   333: aload 5
    //   335: aload_1
    //   336: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   339: sipush 6861
    //   342: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: aload_0
    //   346: athrow
    //   347: astore_1
    //   348: sipush 6861
    //   351: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload_1
    //   355: athrow
    //   356: astore_0
    //   357: aload 4
    //   359: aload_1
    //   360: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   363: sipush 6861
    //   366: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: aload_0
    //   370: athrow
    //   371: aload 10
    //   373: invokevirtual 1287	java/io/BufferedOutputStream:flush	()V
    //   376: getstatic 403	d/y:JfV	Ld/y;
    //   379: astore 9
    //   381: aload 5
    //   383: aconst_null
    //   384: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   387: getstatic 403	d/y:JfV	Ld/y;
    //   390: astore 5
    //   392: aload 4
    //   394: aconst_null
    //   395: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   398: goto -353 -> 45
    //   401: aload_3
    //   402: aconst_null
    //   403: invokestatic 397	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   406: sipush 6861
    //   409: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: iconst_1
    //   413: ireturn
    //   414: astore_0
    //   415: aconst_null
    //   416: astore_1
    //   417: goto -60 -> 357
    //   420: astore_0
    //   421: aconst_null
    //   422: astore_1
    //   423: goto -90 -> 333
    //   426: astore_0
    //   427: aconst_null
    //   428: astore_1
    //   429: goto -290 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramString1	String
    //   0	432	1	paramString2	String
    //   296	8	2	i	int
    //   17	385	3	localCloseable	java.io.Closeable
    //   65	328	4	localObject1	Object
    //   80	311	5	localObject2	Object
    //   27	29	6	localEnumeration	java.util.Enumeration
    //   34	276	7	arrayOfByte	byte[]
    //   43	270	8	localc	d.g.b.v.c
    //   192	188	9	localObject3	Object
    //   287	85	10	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	45	129	java/lang/Throwable
    //   45	126	129	java/lang/Throwable
    //   152	208	129	java/lang/Throwable
    //   208	230	129	java/lang/Throwable
    //   233	247	129	java/lang/Throwable
    //   247	258	129	java/lang/Throwable
    //   357	371	129	java/lang/Throwable
    //   392	398	129	java/lang/Throwable
    //   130	138	138	finally
    //   282	289	323	java/lang/Throwable
    //   289	303	323	java/lang/Throwable
    //   307	320	323	java/lang/Throwable
    //   371	381	323	java/lang/Throwable
    //   324	332	332	finally
    //   258	282	347	java/lang/Throwable
    //   333	347	347	java/lang/Throwable
    //   381	392	347	java/lang/Throwable
    //   348	356	356	finally
    //   258	282	414	finally
    //   333	347	414	finally
    //   381	392	414	finally
    //   282	289	420	finally
    //   289	303	420	finally
    //   307	320	420	finally
    //   371	381	420	finally
    //   18	45	426	finally
    //   45	126	426	finally
    //   152	208	426	finally
    //   208	230	426	finally
    //   233	247	426	finally
    //   247	258	426	finally
    //   357	371	426	finally
    //   392	398	426	finally
  }
  
  public static final String getPrefix()
  {
    return PREFIX;
  }
  
  public static final void j(dcg paramdcg)
  {
    AppMethodBeat.i(6847);
    d.g.b.k.h(paramdcg, "tmplInfo");
    Object localObject1 = r.e(paramdcg);
    Object localObject2 = paramdcg.DoR;
    r.bDU().putString(r.yh(paramdcg.mBH), (String)localObject2);
    r.bDU().removeValueForKey(r.f(paramdcg));
    r.bDU().removeValueForKey(r.g(paramdcg));
    r.bDU().encode((String)localObject1, paramdcg.toByteArray());
    String str = r.h(paramdcg);
    ax localax = r.bDU();
    localObject2 = r.bDU().getStringSet(str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Set)new HashSet();
    }
    ((Set)localObject1).add(paramdcg.DoR);
    localax.putStringSet(str, (Set)localObject1);
    AppMethodBeat.o(6847);
  }
  
  private static final boolean k(dcg paramdcg)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6854);
        if (paramdcg == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
          AppMethodBeat.o(6854);
          return bool;
        }
        if (!r.a(paramdcg))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
          AppMethodBeat.o(6854);
          continue;
        }
        if (ym(paramdcg.mBH).Version == paramdcg.Version) {
          break label90;
        }
      }
      finally {}
      AppMethodBeat.o(6854);
      continue;
      label90:
      if (!r.PH(r.b(paramdcg)))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
        AppMethodBeat.o(6854);
      }
      else
      {
        bool = true;
        AppMethodBeat.o(6854);
      }
    }
  }
  
  private static String l(dcg paramdcg)
  {
    AppMethodBeat.i(6858);
    paramdcg = "Type:" + paramdcg.mBH + " Version:" + paramdcg.Version + " CdnUrl:" + paramdcg.CJK + " Md5:" + paramdcg.Md5;
    AppMethodBeat.o(6858);
    return paramdcg;
  }
  
  private static String yk(int paramInt)
  {
    AppMethodBeat.i(6842);
    String str = "_tmpl_download_time_".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6842);
    return str;
  }
  
  public static final void yl(int paramInt)
  {
    AppMethodBeat.i(6846);
    r.bDU().putLong("_check_time_colddown", paramInt * 1000);
    AppMethodBeat.o(6846);
  }
  
  public static final dcg ym(int paramInt)
  {
    AppMethodBeat.i(6851);
    dcg localdcg = new dcg();
    String str = r.bDU().getString(r.yh(paramInt), null);
    if (str != null)
    {
      d.g.b.k.g(str, "uid");
      a(localdcg, paramInt, str);
    }
    AppMethodBeat.o(6851);
    return localdcg;
  }
  
  public static final dch yo(int paramInt)
  {
    AppMethodBeat.i(193231);
    Object localObject2 = yn(paramInt);
    if (!r.a((dcg)localObject2))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + paramInt + " localTmplInfo is null");
      com.tencent.mm.plugin.webview.g.a.lI(100);
      AppMethodBeat.o(193231);
      return null;
    }
    Object localObject1 = r.c((dcg)localObject2);
    if (!r.PH((String)localObject1))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + (String)localObject1 + " is null");
      com.tencent.mm.plugin.webview.g.a.fL(((dcg)localObject2).Egp, 100);
      AppMethodBeat.o(193231);
      return null;
    }
    dch localdch = new dch();
    localdch.nee = paramInt;
    localdch.version = ((dcg)localObject2).Version;
    localdch.md5 = ((dcg)localObject2).Md5;
    localdch.EtM = ((String)localObject1);
    Object localObject3 = new StringBuilder("https://mp.weixin.qq.com/__tmpl__/").append(paramInt).append('_').append(((dcg)localObject2).DoR).append(".html");
    if ((d.g.b.k.g(PREFIX, "https://mp.weixin.qq.com/__tmpl__/") ^ true)) {}
    for (localObject1 = "?prefix=" + URLEncoder.encode(PREFIX);; localObject1 = "")
    {
      localdch.ASo = ((String)localObject1);
      localdch.reportId = ((dcg)localObject2).Egp;
      localdch.wLF = r.bDU().getLong(yk(((dcg)localObject2).mBH), 0L);
      localdch.yaG = ((dcg)localObject2).DoR;
      localObject1 = ((dcg)localObject2).EtI;
      d.g.b.k.g(localObject1, "tmplInfo.HttpHeaderList");
      localObject2 = (Iterable)localObject1;
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (dcf)((Iterator)localObject2).next();
        localObject1 = ((StringBuilder)localObject1).append("\n" + ((dcf)localObject3).sdv + ':' + ((dcf)localObject3).vJI);
        d.g.b.k.g(localObject1, "sb.append(\"\\n${header.Key}:${header.Value}\")");
      }
    }
    localdch.EtN = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(193231);
    return localdch;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "", "()V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "isZip", "", "()Z", "setZip", "(Z)V", "patchBase", "", "getPatchBase", "()Ljava/lang/String;", "setPatchBase", "(Ljava/lang/String;)V", "patchMD5", "getPatchMD5", "setPatchMD5", "success", "getSuccess", "setSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    Exception exception;
    boolean ndo;
    String ngI;
    String ngJ;
    boolean success;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Integer;"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Integer[]>
  {
    public static final b ngK;
    
    static
    {
      AppMethodBeat.i(6828);
      ngK = new b();
      AppMethodBeat.o(6828);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "checkTmplVerRespCgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplVerResp;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<Void, c.a<vt>>
  {
    c(int paramInt, LinkedList paramLinkedList) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d ngM;
    
    static
    {
      AppMethodBeat.i(6831);
      ngM = new d();
      AppMethodBeat.o(6831);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6830);
      b.bEv();
      AppMethodBeat.o(6830);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
  static final class e
    extends d.g.b.l
    implements m<ArrayList<String>, e, Boolean>
  {
    public static final e ngN;
    
    static
    {
      AppMethodBeat.i(6834);
      ngN = new e();
      AppMethodBeat.o(6834);
    }
    
    e()
    {
      super();
    }
    
    public static boolean a(ArrayList<String> paramArrayList, e parame)
    {
      AppMethodBeat.i(6833);
      d.g.b.k.h(paramArrayList, "$this$isIncludeFile");
      d.g.b.k.h(parame, "file");
      StringBuilder localStringBuilder = new StringBuilder().append(parame.getAbsolutePath());
      if (parame.isDirectory()) {}
      for (parame = "/";; parame = "")
      {
        boolean bool = paramArrayList.contains(parame);
        AppMethodBeat.o(6833);
        return bool;
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.resdownload.LocalTmplInfoManager$downloadTmpl$1", f="LocalTmplInfoManager.kt", l={585}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    Object nfO;
    Object nfP;
    
    f(dcg paramdcg, int paramInt, d.g.a.a parama, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6836);
      d.g.b.k.h(paramd, "completion");
      paramd = new f(this.ngO, this.mSb, this.ngP, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(6836);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(6835);
      d.d.a.a locala = d.d.a.a.JgJ;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6835);
        throw paramObject;
      case 0: 
        localObject2 = this.mTa;
        paramObject = new HashMap();
        localObject1 = this.ngO.CJK;
        Object localObject3 = this.ngO.EtI;
        d.g.b.k.g(localObject3, "tmplInfo.HttpHeaderList");
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (dcf)((Iterator)localObject3).next();
          Object localObject5 = (CharSequence)((dcf)localObject4).sdv;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject5 = (CharSequence)((dcf)localObject4).vJI;
            if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
              break label242;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject5 = (Map)paramObject;
            String str = ((dcf)localObject4).sdv;
            d.g.b.k.g(str, "it.Key");
            localObject4 = ((dcf)localObject4).vJI;
            d.g.b.k.g(localObject4, "it.Value");
            ((Map)localObject5).put(str, localObject4);
            break;
            i = 0;
            break label153;
          }
        }
        if (!this.ngO.EtJ) {
          break label396;
        }
        localObject3 = b.ngH;
        d.g.b.k.g(localObject1, "downloadUrl");
        this.mTb = localObject2;
        this.nfO = paramObject;
        this.nfP = localObject1;
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
        label153:
        label242:
        localObject2 = (HashMap)this.nfO;
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      Object localObject1 = (String)localObject1;
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        i = 1;
        label358:
        if (i != 0) {
          break label404;
        }
        localObject2 = b.ngH;
        b.a((String)localObject1, this.ngO, paramObject, this.mSb, this.ngP);
      }
      for (;;)
      {
        paramObject = y.JfV;
        AppMethodBeat.o(6835);
        return paramObject;
        label396:
        break;
        i = 0;
        break label358;
        label404:
        paramObject = new StringBuilder("url is null or empty:");
        localObject1 = b.ngH;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", b.m(this.ngO));
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6837);
      paramObject1 = ((f)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(6837);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$getUrlWithA8key$2$1"})
  static final class g
    implements com.tencent.mm.al.g
  {
    g(d.d.d paramd, String paramString, HashMap paramHashMap) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(6838);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramn.setHasCallbackToQueue(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null) {
          try
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.modelsimple.NetSceneGetA8Key");
            AppMethodBeat.o(6838);
            throw paramString;
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Preload.TmplInfoManager", "NetSceneGetA8Key ex " + paramString.getMessage());
            AppMethodBeat.o(6838);
            return;
          }
        }
        paramString = (com.tencent.mm.modelsimple.k)paramn;
        paramn = paramString.aAx();
        d.g.b.k.g(paramn, "netSceneGetA8Key.httpHeader");
        paramn = ((Iterable)paramn).iterator();
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
        if (paramn.hasNext())
        {
          localObject1 = (bgq)paramn.next();
          localObject2 = (CharSequence)((bgq)localObject1).sdv;
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
          localObject2 = (CharSequence)((bgq)localObject1).vJI;
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
          localObject2 = (Map)this.ngQ;
          String str = ((bgq)localObject1).sdv;
          d.g.b.k.g(str, "it.Key");
          localObject1 = ((bgq)localObject1).vJI;
          d.g.b.k.g(localObject1, "it.Value");
          ((Map)localObject2).put(str, localObject1);
          break;
          paramn = this.nfF;
          paramString = paramString.aAq();
          localObject1 = p.JfM;
          paramn.eH(p.eF(paramString));
          AppMethodBeat.o(6838);
          return;
          paramString = this.nfF;
          paramn = p.JfM;
          paramString.eH(p.eF(""));
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b
 * JD-Core Version:    0.7.0.1
 */