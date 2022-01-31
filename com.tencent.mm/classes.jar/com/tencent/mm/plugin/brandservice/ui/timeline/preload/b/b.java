package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import a.f.b.t;
import a.j.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.TmplParams.a;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "tmplType", "download", "url", "tmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Ljava/io/File;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", "dir", "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"})
public final class b
{
  private static final String PREFIX = "https://mp.weixin.qq.com/tmpl/";
  private static final a.f kcA;
  private static final int kcB = 60000;
  private static final ConcurrentHashMap<Integer, Long> kcC;
  private static final ArrayList<Integer> kcD;
  public static final b kcE;
  
  static
  {
    AppMethodBeat.i(15003);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(b.class), "SUPPORT_TMPL_TYPES", "getSUPPORT_TMPL_TYPES()[Ljava/lang/Integer;")) };
    kcE = new b();
    PREFIX = "https://mp.weixin.qq.com/tmpl/";
    kcA = a.g.j((a.f.a.a)b.b.kcH);
    kcB = 60000;
    kcC = new ConcurrentHashMap();
    kcD = new ArrayList();
    AppMethodBeat.o(15003);
  }
  
  /* Error */
  private static b.a a(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a
    //   8: dup
    //   9: invokespecial 199	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:<init>	()V
    //   12: astore 7
    //   14: new 201	java/io/File
    //   17: dup
    //   18: aload_3
    //   19: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: invokevirtual 208	java/io/File:exists	()Z
    //   29: ifeq +9 -> 38
    //   32: aload 8
    //   34: invokevirtual 211	java/io/File:delete	()Z
    //   37: pop
    //   38: new 213	java/net/URL
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 214	java/net/URL:<init>	(Ljava/lang/String;)V
    //   46: invokevirtual 218	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   49: astore 6
    //   51: aload 6
    //   53: ifnonnull +96 -> 149
    //   56: new 220	a/v
    //   59: dup
    //   60: ldc 222
    //   62: invokespecial 223	a/v:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: ldc 198
    //   68: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: athrow
    //   73: astore_2
    //   74: ldc 225
    //   76: aload_2
    //   77: checkcast 197	java/lang/Throwable
    //   80: new 227	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 229
    //   86: invokespecial 230	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_3
    //   90: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 236
    //   95: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload 7
    //   114: aload_2
    //   115: checkcast 248	java/lang/Exception
    //   118: putfield 252	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   121: iload_0
    //   122: bipush 7
    //   124: invokestatic 258	com/tencent/mm/plugin/webview/preload/a:gK	(II)V
    //   127: aload 8
    //   129: invokevirtual 208	java/io/File:exists	()Z
    //   132: ifeq +9 -> 141
    //   135: aload 8
    //   137: invokevirtual 211	java/io/File:delete	()Z
    //   140: pop
    //   141: ldc 198
    //   143: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload 7
    //   148: areturn
    //   149: aload 6
    //   151: checkcast 260	java/net/HttpURLConnection
    //   154: astore 9
    //   156: aload 9
    //   158: ldc_w 262
    //   161: ldc_w 264
    //   164: invokevirtual 268	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 9
    //   169: ldc_w 262
    //   172: ldc_w 270
    //   175: invokevirtual 268	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 9
    //   180: iconst_0
    //   181: invokevirtual 274	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   184: aload_2
    //   185: ifnull +216 -> 401
    //   188: aload_2
    //   189: invokeinterface 279 1 0
    //   194: ifne +201 -> 395
    //   197: iconst_1
    //   198: istore 4
    //   200: iload 4
    //   202: ifeq +199 -> 401
    //   205: ldc 225
    //   207: ldc_w 281
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_2
    //   217: invokeinterface 285 1 0
    //   222: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 294	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload_2
    //   230: invokeinterface 298 1 0
    //   235: invokeinterface 304 1 0
    //   240: astore 6
    //   242: aload 6
    //   244: invokeinterface 309 1 0
    //   249: ifeq +152 -> 401
    //   252: aload 6
    //   254: invokeinterface 313 1 0
    //   259: checkcast 315	java/lang/String
    //   262: astore 10
    //   264: aload 9
    //   266: aload 10
    //   268: aload_2
    //   269: aload 10
    //   271: invokeinterface 319 2 0
    //   276: checkcast 315	java/lang/String
    //   279: invokevirtual 268	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: goto -40 -> 242
    //   285: astore_2
    //   286: ldc 198
    //   288: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_2
    //   292: athrow
    //   293: astore_2
    //   294: aload 9
    //   296: invokevirtual 323	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   299: astore 6
    //   301: aload 6
    //   303: ifnull +8 -> 311
    //   306: aload 6
    //   308: invokevirtual 328	java/io/InputStream:close	()V
    //   311: aload 9
    //   313: invokevirtual 331	java/net/HttpURLConnection:disconnect	()V
    //   316: ldc 198
    //   318: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload_2
    //   322: athrow
    //   323: astore_2
    //   324: ldc 225
    //   326: aload_2
    //   327: checkcast 197	java/lang/Throwable
    //   330: new 227	java/lang/StringBuilder
    //   333: dup
    //   334: ldc_w 333
    //   337: invokespecial 230	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload_3
    //   341: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 236
    //   346: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_1
    //   350: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: iconst_0
    //   357: anewarray 4	java/lang/Object
    //   360: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   363: aload 7
    //   365: aload_2
    //   366: checkcast 248	java/lang/Exception
    //   369: putfield 252	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   372: iload_0
    //   373: bipush 7
    //   375: invokestatic 258	com/tencent/mm/plugin/webview/preload/a:gK	(II)V
    //   378: aload 8
    //   380: invokevirtual 208	java/io/File:exists	()Z
    //   383: ifeq -242 -> 141
    //   386: aload 8
    //   388: invokevirtual 211	java/io/File:delete	()Z
    //   391: pop
    //   392: goto -251 -> 141
    //   395: iconst_0
    //   396: istore 4
    //   398: goto -198 -> 200
    //   401: aload 9
    //   403: iconst_0
    //   404: invokevirtual 336	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   407: aload 9
    //   409: ldc_w 338
    //   412: invokevirtual 341	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   415: aload 9
    //   417: sipush 10000
    //   420: invokevirtual 344	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   423: aload 9
    //   425: sipush 3000
    //   428: invokevirtual 347	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   431: aload 9
    //   433: invokevirtual 350	java/net/HttpURLConnection:connect	()V
    //   436: aload 9
    //   438: invokevirtual 353	java/net/HttpURLConnection:getResponseCode	()I
    //   441: istore 4
    //   443: iload 4
    //   445: sipush 200
    //   448: if_icmpne +221 -> 669
    //   451: aload 8
    //   453: invokevirtual 356	java/io/File:createNewFile	()Z
    //   456: pop
    //   457: sipush 8192
    //   460: newarray byte
    //   462: astore_2
    //   463: new 358	a/f/b/u$c
    //   466: dup
    //   467: invokespecial 359	a/f/b/u$c:<init>	()V
    //   470: astore 11
    //   472: new 361	java/io/FileOutputStream
    //   475: dup
    //   476: aload 8
    //   478: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   481: checkcast 366	java/io/Closeable
    //   484: astore 10
    //   486: aconst_null
    //   487: astore 6
    //   489: aload 10
    //   491: checkcast 361	java/io/FileOutputStream
    //   494: astore 12
    //   496: aload 9
    //   498: invokevirtual 323	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   501: aload_2
    //   502: invokevirtual 370	java/io/InputStream:read	([B)I
    //   505: istore 4
    //   507: aload 11
    //   509: iload 4
    //   511: putfield 373	a/f/b/u$c:BNp	I
    //   514: iload 4
    //   516: iconst_m1
    //   517: if_icmpeq +43 -> 560
    //   520: aload 12
    //   522: aload_2
    //   523: iconst_0
    //   524: aload 11
    //   526: getfield 373	a/f/b/u$c:BNp	I
    //   529: invokevirtual 377	java/io/FileOutputStream:write	([BII)V
    //   532: goto -36 -> 496
    //   535: astore 6
    //   537: ldc 198
    //   539: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload 6
    //   544: athrow
    //   545: astore_2
    //   546: aload 10
    //   548: aload 6
    //   550: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   553: ldc 198
    //   555: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_2
    //   559: athrow
    //   560: getstatic 388	a/y:BMg	La/y;
    //   563: astore_2
    //   564: aload 10
    //   566: aconst_null
    //   567: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   570: aload 7
    //   572: iconst_1
    //   573: putfield 391	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:success	Z
    //   576: aload 7
    //   578: aload 9
    //   580: ldc_w 393
    //   583: invokevirtual 397	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   586: putfield 400	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:kcF	Ljava/lang/String;
    //   589: aload 7
    //   591: aload 9
    //   593: ldc_w 402
    //   596: invokevirtual 397	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   599: putfield 405	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:kcG	Ljava/lang/String;
    //   602: aload 9
    //   604: ldc_w 407
    //   607: invokevirtual 397	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   610: astore_2
    //   611: aload_2
    //   612: ifnull +51 -> 663
    //   615: ldc_w 409
    //   618: aload_2
    //   619: invokestatic 415	a/f/b/j:e	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   622: iconst_1
    //   623: ixor
    //   624: ifeq +39 -> 663
    //   627: iconst_1
    //   628: istore 5
    //   630: aload 7
    //   632: iload 5
    //   634: putfield 418	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:kaS	Z
    //   637: getstatic 388	a/y:BMg	La/y;
    //   640: astore_2
    //   641: aload 9
    //   643: invokevirtual 323	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   646: astore_2
    //   647: aload_2
    //   648: ifnull +7 -> 655
    //   651: aload_2
    //   652: invokevirtual 328	java/io/InputStream:close	()V
    //   655: aload 9
    //   657: invokevirtual 331	java/net/HttpURLConnection:disconnect	()V
    //   660: goto -519 -> 141
    //   663: iconst_0
    //   664: istore 5
    //   666: goto -36 -> 630
    //   669: ldc 225
    //   671: ldc_w 420
    //   674: iload 4
    //   676: invokestatic 422	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   679: invokevirtual 425	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   682: invokestatic 427	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: iload 4
    //   687: sipush 500
    //   690: if_icmple +12 -> 702
    //   693: iload_0
    //   694: bipush 11
    //   696: invokestatic 258	com/tencent/mm/plugin/webview/preload/a:gK	(II)V
    //   699: goto -62 -> 637
    //   702: iload 4
    //   704: sipush 400
    //   707: if_icmple -70 -> 637
    //   710: iload_0
    //   711: bipush 10
    //   713: invokestatic 258	com/tencent/mm/plugin/webview/preload/a:gK	(II)V
    //   716: goto -79 -> 637
    //   719: astore 6
    //   721: goto -410 -> 311
    //   724: astore_2
    //   725: goto -70 -> 655
    //   728: astore_2
    //   729: goto -183 -> 546
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	paramInt	int
    //   0	732	1	paramString1	String
    //   0	732	2	paramMap	Map<String, String>
    //   0	732	3	paramString2	String
    //   198	510	4	i	int
    //   628	37	5	bool	boolean
    //   49	439	6	localObject1	Object
    //   535	14	6	localThrowable1	Throwable
    //   719	1	6	localThrowable2	Throwable
    //   12	619	7	locala	b.a
    //   22	455	8	localFile	File
    //   154	502	9	localHttpURLConnection	java.net.HttpURLConnection
    //   262	303	10	localObject2	Object
    //   470	55	11	localc	a.f.b.u.c
    //   494	27	12	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   38	51	73	java/io/FileNotFoundException
    //   56	73	73	java/io/FileNotFoundException
    //   149	156	73	java/io/FileNotFoundException
    //   294	301	73	java/io/FileNotFoundException
    //   306	311	73	java/io/FileNotFoundException
    //   311	323	73	java/io/FileNotFoundException
    //   641	647	73	java/io/FileNotFoundException
    //   651	655	73	java/io/FileNotFoundException
    //   655	660	73	java/io/FileNotFoundException
    //   156	184	285	java/lang/Throwable
    //   188	197	285	java/lang/Throwable
    //   205	242	285	java/lang/Throwable
    //   242	282	285	java/lang/Throwable
    //   401	443	285	java/lang/Throwable
    //   451	486	285	java/lang/Throwable
    //   546	560	285	java/lang/Throwable
    //   564	611	285	java/lang/Throwable
    //   615	627	285	java/lang/Throwable
    //   630	637	285	java/lang/Throwable
    //   637	641	285	java/lang/Throwable
    //   669	685	285	java/lang/Throwable
    //   693	699	285	java/lang/Throwable
    //   710	716	285	java/lang/Throwable
    //   156	184	293	finally
    //   188	197	293	finally
    //   205	242	293	finally
    //   242	282	293	finally
    //   286	293	293	finally
    //   401	443	293	finally
    //   451	486	293	finally
    //   546	560	293	finally
    //   564	611	293	finally
    //   615	627	293	finally
    //   630	637	293	finally
    //   637	641	293	finally
    //   669	685	293	finally
    //   693	699	293	finally
    //   710	716	293	finally
    //   38	51	323	java/io/IOException
    //   56	73	323	java/io/IOException
    //   149	156	323	java/io/IOException
    //   294	301	323	java/io/IOException
    //   306	311	323	java/io/IOException
    //   311	323	323	java/io/IOException
    //   641	647	323	java/io/IOException
    //   651	655	323	java/io/IOException
    //   655	660	323	java/io/IOException
    //   489	496	535	java/lang/Throwable
    //   496	514	535	java/lang/Throwable
    //   520	532	535	java/lang/Throwable
    //   560	564	535	java/lang/Throwable
    //   537	545	545	finally
    //   294	301	719	java/lang/Throwable
    //   306	311	719	java/lang/Throwable
    //   641	647	724	java/lang/Throwable
    //   651	655	724	java/lang/Throwable
    //   489	496	728	finally
    //   496	514	728	finally
    //   520	532	728	finally
    //   560	564	728	finally
  }
  
  private static ckj a(ckj paramckj, int paramInt, String paramString)
  {
    AppMethodBeat.i(14993);
    paramckj.jKs = paramInt;
    paramckj.wXS = paramString;
    byte[] arrayOfByte = o.aXO().decodeBytes(o.e(paramckj));
    int i;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {}
      try
      {
        paramckj.parseFrom(arrayOfByte);
        AppMethodBeat.o(14993);
        return paramckj;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", (Throwable)localException, "decode TmplInfo:" + paramInt + ", " + paramString, new Object[0]);
        }
      }
    }
  }
  
  public static final void a(int paramInt, String paramString, int... paramVarArgs)
  {
    AppMethodBeat.i(14989);
    a.f.b.j.q(paramString, "netType");
    a.f.b.j.q(paramVarArgs, "tmplTypes");
    if (at.is2G(ah.getContext()))
    {
      ab.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
      AppMethodBeat.o(14989);
      return;
    }
    paramVarArgs = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.kbz;
    if ((!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) && (h.aSs().getInt("preload_type", 1) == 3)) {}
    for (int i = 1; i != 0; i = 0)
    {
      i.di("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
      AppMethodBeat.o(14989);
      return;
    }
    if (paramInt == -1) {
      kcC.clear();
    }
    LinkedList localLinkedList = new LinkedList();
    paramVarArgs = aXP();
    Object localObject1 = (Collection)new ArrayList();
    int j = paramVarArgs.length;
    i = 0;
    Object localObject2;
    if (i < j)
    {
      int m = paramVarArgs[i];
      int k = ((Number)m).intValue();
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.kbz;
      boolean bool;
      if (h.aSs().getBoolean("preload_tmpl_always_check_tmpl_ver", false)) {
        bool = true;
      }
      for (;;)
      {
        if (bool) {
          ((Collection)localObject1).add(m);
        }
        i += 1;
        break;
        long l = 0L;
        if (kcC.containsKey(Integer.valueOf(k)))
        {
          localObject2 = kcC.get(Integer.valueOf(k));
          if (localObject2 == null) {
            a.f.b.j.ebi();
          }
          l = ((Number)localObject2).longValue();
        }
        if (kcD.contains(Integer.valueOf(k)))
        {
          ab.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(k) });
          bool = false;
        }
        else
        {
          bool = com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.E(l, o.aXO().getLong("_check_time_colddown", kcB));
        }
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    label576:
    label624:
    label627:
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Number)((Iterator)localObject1).next()).intValue();
      kcD.add(Integer.valueOf(i));
      ((Map)kcC).put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
      sy localsy = new sy();
      localsy.jKs = i;
      if (PreloadLogic.rU(101)) {
        localsy.wLu = o.aXN();
      }
      localLinkedList.add(localsy);
      paramVarArgs = sv(i);
      if (o.a(paramVarArgs))
      {
        if (o.Ha(o.b(paramVarArgs))) {
          localsy.wLt = paramVarArgs.wXS;
        }
        localObject2 = o.aXO().getStringSet(o.h(paramVarArgs), null);
        if (localObject2 != null)
        {
          Object localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            String str = (String)localObject4;
            ckj localckj = new ckj();
            a.f.b.j.p(str, "it");
            if (a(a(localckj, i, str), paramVarArgs)) {
              ((Collection)localObject2).add(localObject4);
            }
          }
          paramVarArgs = (List)localObject2;
          localObject2 = (Collection)paramVarArgs;
          if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
            break label624;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label627;
          }
          localsy.wLs.addAll((Collection)paramVarArgs);
          break;
          paramVarArgs = null;
          break label576;
        }
      }
    }
    if (!((Collection)localLinkedList).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.webview.preload.a.kS(0);
        new a(localLinkedList, paramInt, paramString).adl().g((com.tencent.mm.vending.c.a)new b.c(paramInt, localLinkedList));
      }
      AppMethodBeat.o(14989);
      return;
    }
  }
  
  public static void a(TmplParams paramTmplParams, boolean paramBoolean)
  {
    AppMethodBeat.i(14988);
    a.f.b.j.q(paramTmplParams, "tmplParams");
    String str = "_tmpl_info_inject_fail_-" + paramTmplParams.kbM + '-' + paramTmplParams.kbP;
    if (paramBoolean)
    {
      o.aXO().removeValueForKey(str);
      AppMethodBeat.o(14988);
      return;
    }
    int i = o.aXO().getInt(str, 0) + 1;
    o.aXO().putInt(str, i);
    ab.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + paramTmplParams.kbM + ',' + paramTmplParams.kbP + ',' + i);
    if (i > 2)
    {
      com.tencent.mm.plugin.webview.preload.a.kS(219);
      ab.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + paramTmplParams.kbM + ',' + paramTmplParams.kbP + ',' + i);
    }
    AppMethodBeat.o(14988);
  }
  
  private static boolean a(ckj paramckj1, ckj paramckj2)
  {
    AppMethodBeat.i(14994);
    if (o.GZ(o.b(paramckj1)).exists())
    {
      if (b(paramckj1, paramckj2))
      {
        o.aXO().putString(o.f(paramckj1), paramckj1.wXS);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a(o.aXO(), o.g(paramckj1));
        AppMethodBeat.o(14994);
        return true;
      }
      if (a.f.b.j.e(o.e(paramckj1), o.aXO().getString(o.f(paramckj1), null)))
      {
        o.aXO().removeValueForKey(o.f(paramckj1));
        o.aXO().removeValueForKey(o.g(paramckj1));
      }
      o.aXO().remove(o.e(paramckj1));
      paramckj2 = o.h(paramckj2);
      Set localSet = o.aXO().getStringSet(paramckj2, null);
      if (localSet != null)
      {
        localSet.remove(paramckj1.wXS);
        o.aXO().putStringSet(paramckj2, localSet);
      }
      ab.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramckj1.wXS + " is invalid");
    }
    for (;;)
    {
      AppMethodBeat.o(14994);
      return false;
      ab.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + paramckj1.wXS);
    }
  }
  
  public static Integer[] aXP()
  {
    AppMethodBeat.i(152716);
    Integer[] arrayOfInteger = (Integer[])kcA.getValue();
    AppMethodBeat.o(152716);
    return arrayOfInteger;
  }
  
  public static final void aXQ()
  {
    AppMethodBeat.i(15000);
    com.tencent.mm.sdk.g.d.ysm.b((Runnable)b.d.kcJ, "tmplPreload");
    AppMethodBeat.o(15000);
  }
  
  public static final String aXR()
  {
    AppMethodBeat.i(15002);
    String str = com.tencent.mm.compatible.util.e.eQv + "webview_tmpl/";
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.kbz;
    if (g.a.aXx())
    {
      str = com.tencent.mm.compatible.util.e.eQz;
      a.f.b.j.p(str, "CConstants.DATAROOT_SDCARD_PATH");
    }
    localObject = str;
    if (!m.jx(str, "/")) {
      localObject = str + "/";
    }
    str = (String)localObject + "tmpls/";
    com.tencent.mm.sdk.platformtools.j.akQ(str);
    AppMethodBeat.o(15002);
    return str;
  }
  
  public static final String aXS()
  {
    return "https://mp.weixin.qq.com/tmpl/";
  }
  
  private static ckj an(int paramInt, String paramString)
  {
    AppMethodBeat.i(14997);
    ckj localckj1 = su(paramInt);
    if (o.a(localckj1))
    {
      if ((o.Ha(o.b(localckj1))) && ((a.f.b.j.e(localckj1.wXS, paramString) ^ true)))
      {
        AppMethodBeat.o(14997);
        return localckj1;
      }
      Object localObject1 = o.aXO().getString(o.f(localckj1), null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new ckj();
        a.f.b.j.p(localObject1, "it");
        localObject1 = a((ckj)localObject2, paramInt, (String)localObject1);
        if ((localObject1 != null) && (o.a((ckj)localObject1)) && (!o.i((ckj)localObject1)) && (o.Ha(o.b((ckj)localObject1))) && ((a.f.b.j.e(((ckj)localObject1).wXS, paramString) ^ true)))
        {
          AppMethodBeat.o(14997);
          return localObject1;
        }
      }
      localObject1 = o.aXO().getStringSet(o.h(localckj1), null);
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        a.f.b.j.q(localObject1, "receiver$0");
        localObject2 = a.b.f.BME;
        if (localObject2 == null)
        {
          paramString = new a.v("null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
          AppMethodBeat.o(14997);
          throw paramString;
        }
        localObject2 = (Comparator)localObject2;
        a.f.b.j.q(localObject1, "receiver$0");
        a.f.b.j.q(localObject2, "comparator");
        if ((localObject1 instanceof Collection)) {
          if (((Collection)localObject1).size() <= 1) {
            localObject1 = a.a.j.m((Iterable)localObject1);
          }
        }
        while (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (String)((Iterator)localObject1).next();
            } while (!(a.f.b.j.e(localObject2, paramString) ^ true));
            ckj localckj2 = new ckj();
            a.f.b.j.p(localObject2, "uid");
            localObject2 = a(localckj2, paramInt, (String)localObject2);
          } while (!a((ckj)localObject2, localckj1));
          AppMethodBeat.o(14997);
          return localObject2;
          localObject1 = ((Collection)localObject1).toArray(new Object[0]);
          if (localObject1 == null)
          {
            paramString = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(14997);
            throw paramString;
          }
          if (localObject1 == null)
          {
            paramString = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(14997);
            throw paramString;
          }
          a.a.e.a((Object[])localObject1, (Comparator)localObject2);
          localObject1 = a.a.e.asList((Object[])localObject1);
          continue;
          localObject1 = a.a.j.n((Iterable)localObject1);
          a.a.j.a((List)localObject1, (Comparator)localObject2);
        }
      }
    }
    paramString = new ckj();
    AppMethodBeat.o(14997);
    return paramString;
  }
  
  private static boolean b(ckj paramckj1, ckj paramckj2)
  {
    AppMethodBeat.i(14995);
    if ((a.f.b.j.e(paramckj1, paramckj2)) && (paramckj1.Version != 0))
    {
      AppMethodBeat.o(14995);
      return true;
    }
    int i = paramckj2.wLx;
    Object localObject;
    if (ab.getLogLevel() == 0)
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.kbz;
      int j = g.a.aXy();
      if (j > 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (paramckj1.Version < i)
      {
        ab.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramckj1.wXS + " version:" + paramckj1.Version + " < " + i);
        AppMethodBeat.o(14995);
        return false;
      }
      paramckj2 = paramckj2.xUo;
      a.f.b.j.p(paramckj2, "standard.VersionControlList");
      paramckj2 = ((Iterable)paramckj2).iterator();
      while (paramckj2.hasNext())
      {
        localObject = (ckk)paramckj2.next();
        if (a.f.b.j.e(((ckk)localObject).wXS, paramckj1.wXS))
        {
          ab.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + ((ckk)localObject).wXS + " matchControls in forceH5:" + ((ckk)localObject).xUq);
          if (!((ckk)localObject).xUq)
          {
            AppMethodBeat.o(14995);
            return true;
          }
          AppMethodBeat.o(14995);
          return false;
        }
      }
      AppMethodBeat.o(14995);
      return true;
    }
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(14990);
    o.aXO().clear();
    com.tencent.mm.a.e.o(o.GZ(aXR()));
    com.tencent.mm.a.e.cO(com.tencent.mm.loader.j.b.eQv + "/jscache/");
    AppMethodBeat.o(14990);
  }
  
  private static boolean d(String paramString, File paramFile)
  {
    AppMethodBeat.i(152718);
    if ((!bo.isNullOrNil(paramString)) && (a.f.b.j.e(paramString, com.tencent.mm.a.g.q(paramFile))))
    {
      AppMethodBeat.o(152718);
      return true;
    }
    ab.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", new Object[] { paramFile.getAbsolutePath() });
    AppMethodBeat.o(152718);
    return false;
  }
  
  /* Error */
  private static boolean dl(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 1281
    //   3: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1283	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1284	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: checkcast 366	java/io/Closeable
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 1283	java/util/zip/ZipFile
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 1288	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   27: astore 6
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 7
    //   36: new 358	a/f/b/u$c
    //   39: dup
    //   40: invokespecial 359	a/f/b/u$c:<init>	()V
    //   43: astore 8
    //   45: aload 6
    //   47: invokeinterface 1293 1 0
    //   52: ifeq +356 -> 408
    //   55: aload 6
    //   57: invokeinterface 1296 1 0
    //   62: checkcast 1298	java/util/zip/ZipEntry
    //   65: astore 4
    //   67: aload 4
    //   69: ldc_w 1300
    //   72: invokestatic 499	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 4
    //   77: invokevirtual 1301	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ldc_w 1303
    //   87: invokestatic 499	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload 5
    //   92: checkcast 825	java/lang/CharSequence
    //   95: ldc_w 1305
    //   98: iconst_0
    //   99: iconst_0
    //   100: bipush 6
    //   102: invokestatic 1308	a/l/m:a	(Ljava/lang/CharSequence;Ljava/lang/String;IZI)I
    //   105: iconst_m1
    //   106: if_icmpeq +46 -> 152
    //   109: ldc 225
    //   111: ldc_w 1310
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 5
    //   122: aastore
    //   123: invokestatic 993	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -81 -> 45
    //   129: astore_1
    //   130: ldc_w 1281
    //   133: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_3
    //   140: aload_1
    //   141: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: ldc_w 1281
    //   147: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: new 201	java/io/File
    //   155: dup
    //   156: new 227	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 814	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: new 201	java/io/File
    //   183: dup
    //   184: aload 5
    //   186: invokevirtual 1313	java/io/File:getParent	()Ljava/lang/String;
    //   189: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 9
    //   194: aload 9
    //   196: invokevirtual 208	java/io/File:exists	()Z
    //   199: ifne +9 -> 208
    //   202: aload 9
    //   204: invokevirtual 1316	java/io/File:mkdirs	()Z
    //   207: pop
    //   208: aload 4
    //   210: invokevirtual 1317	java/util/zip/ZipEntry:isDirectory	()Z
    //   213: ifeq +20 -> 233
    //   216: aload 5
    //   218: invokevirtual 208	java/io/File:exists	()Z
    //   221: ifne -176 -> 45
    //   224: aload 5
    //   226: invokevirtual 1320	java/io/File:mkdir	()Z
    //   229: pop
    //   230: goto -185 -> 45
    //   233: aload 5
    //   235: invokevirtual 208	java/io/File:exists	()Z
    //   238: ifne +9 -> 247
    //   241: aload 5
    //   243: invokevirtual 356	java/io/File:createNewFile	()Z
    //   246: pop
    //   247: aload_0
    //   248: aload 4
    //   250: invokevirtual 1323	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   253: checkcast 366	java/io/Closeable
    //   256: astore 4
    //   258: aload 4
    //   260: checkcast 325	java/io/InputStream
    //   263: astore 9
    //   265: new 1325	java/io/BufferedOutputStream
    //   268: dup
    //   269: new 361	java/io/FileOutputStream
    //   272: dup
    //   273: aload 5
    //   275: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   278: checkcast 1327	java/io/OutputStream
    //   281: invokespecial 1330	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   284: checkcast 366	java/io/Closeable
    //   287: astore 5
    //   289: aload 5
    //   291: checkcast 1325	java/io/BufferedOutputStream
    //   294: astore 10
    //   296: aload 9
    //   298: aload 7
    //   300: invokevirtual 370	java/io/InputStream:read	([B)I
    //   303: istore_2
    //   304: aload 8
    //   306: iload_2
    //   307: putfield 373	a/f/b/u$c:BNp	I
    //   310: iload_2
    //   311: ifle +67 -> 378
    //   314: aload 10
    //   316: aload 7
    //   318: iconst_0
    //   319: aload 8
    //   321: getfield 373	a/f/b/u$c:BNp	I
    //   324: invokevirtual 1331	java/io/BufferedOutputStream:write	([BII)V
    //   327: goto -31 -> 296
    //   330: astore_1
    //   331: ldc_w 1281
    //   334: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: aload_1
    //   338: athrow
    //   339: astore_0
    //   340: aload 5
    //   342: aload_1
    //   343: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   346: ldc_w 1281
    //   349: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload_0
    //   353: athrow
    //   354: astore_1
    //   355: ldc_w 1281
    //   358: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: aload_1
    //   362: athrow
    //   363: astore_0
    //   364: aload 4
    //   366: aload_1
    //   367: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   370: ldc_w 1281
    //   373: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: aload_0
    //   377: athrow
    //   378: aload 10
    //   380: invokevirtual 1334	java/io/BufferedOutputStream:flush	()V
    //   383: getstatic 388	a/y:BMg	La/y;
    //   386: astore 9
    //   388: aload 5
    //   390: aconst_null
    //   391: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   394: getstatic 388	a/y:BMg	La/y;
    //   397: astore 5
    //   399: aload 4
    //   401: aconst_null
    //   402: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   405: goto -360 -> 45
    //   408: aload_3
    //   409: aconst_null
    //   410: invokestatic 382	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   413: ldc_w 1281
    //   416: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: iconst_1
    //   420: ireturn
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_1
    //   424: goto -60 -> 364
    //   427: astore_0
    //   428: aconst_null
    //   429: astore_1
    //   430: goto -90 -> 340
    //   433: astore_0
    //   434: aconst_null
    //   435: astore_1
    //   436: goto -297 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	paramString1	String
    //   0	439	1	paramString2	String
    //   303	8	2	i	int
    //   17	392	3	localCloseable	java.io.Closeable
    //   65	335	4	localObject1	Object
    //   80	318	5	localObject2	Object
    //   27	29	6	localEnumeration	java.util.Enumeration
    //   34	283	7	arrayOfByte	byte[]
    //   43	277	8	localc	a.f.b.u.c
    //   192	195	9	localObject3	Object
    //   294	85	10	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	45	129	java/lang/Throwable
    //   45	126	129	java/lang/Throwable
    //   152	208	129	java/lang/Throwable
    //   208	230	129	java/lang/Throwable
    //   233	247	129	java/lang/Throwable
    //   247	258	129	java/lang/Throwable
    //   364	378	129	java/lang/Throwable
    //   399	405	129	java/lang/Throwable
    //   130	138	138	finally
    //   289	296	330	java/lang/Throwable
    //   296	310	330	java/lang/Throwable
    //   314	327	330	java/lang/Throwable
    //   378	388	330	java/lang/Throwable
    //   331	339	339	finally
    //   258	289	354	java/lang/Throwable
    //   340	354	354	java/lang/Throwable
    //   388	399	354	java/lang/Throwable
    //   355	363	363	finally
    //   258	289	421	finally
    //   340	354	421	finally
    //   388	399	421	finally
    //   289	296	427	finally
    //   296	310	427	finally
    //   314	327	427	finally
    //   378	388	427	finally
    //   18	45	433	finally
    //   45	126	433	finally
    //   152	208	433	finally
    //   208	230	433	finally
    //   233	247	433	finally
    //   247	258	433	finally
    //   364	378	433	finally
    //   399	405	433	finally
  }
  
  public static final String getPrefix()
  {
    return PREFIX;
  }
  
  public static final void j(ckj paramckj)
  {
    AppMethodBeat.i(14992);
    a.f.b.j.q(paramckj, "tmplInfo");
    Object localObject1 = o.e(paramckj);
    Object localObject2 = paramckj.wXS;
    o.aXO().putString(o.sr(paramckj.jKs), (String)localObject2);
    o.aXO().removeValueForKey(o.f(paramckj));
    o.aXO().removeValueForKey(o.g(paramckj));
    o.aXO().encode((String)localObject1, paramckj.toByteArray());
    String str = o.h(paramckj);
    as localas = o.aXO();
    localObject2 = o.aXO().getStringSet(str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Set)new HashSet();
    }
    ((Set)localObject1).add(paramckj.wXS);
    localas.putStringSet(str, (Set)localObject1);
    AppMethodBeat.o(14992);
  }
  
  private static final boolean k(ckj paramckj)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(14999);
        if (paramckj == null)
        {
          ab.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
          AppMethodBeat.o(14999);
          return bool;
        }
        if (!o.a(paramckj))
        {
          ab.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
          AppMethodBeat.o(14999);
          continue;
        }
        if (su(paramckj.jKs).Version == paramckj.Version) {
          break label90;
        }
      }
      finally {}
      AppMethodBeat.o(14999);
      continue;
      label90:
      if (!o.Ha(o.b(paramckj)))
      {
        ab.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
        AppMethodBeat.o(14999);
      }
      else
      {
        bool = true;
        AppMethodBeat.o(14999);
      }
    }
  }
  
  private static String ss(int paramInt)
  {
    AppMethodBeat.i(14987);
    String str = "_tmpl_download_time_".concat(String.valueOf(paramInt));
    AppMethodBeat.o(14987);
    return str;
  }
  
  public static final void st(int paramInt)
  {
    AppMethodBeat.i(14991);
    o.aXO().putLong("_check_time_colddown", paramInt * 1000);
    AppMethodBeat.o(14991);
  }
  
  public static final ckj su(int paramInt)
  {
    AppMethodBeat.i(14996);
    ckj localckj = new ckj();
    String str = o.aXO().getString(o.sr(paramInt), null);
    if (str != null)
    {
      a.f.b.j.p(str, "uid");
      a(localckj, paramInt, str);
    }
    AppMethodBeat.o(14996);
    return localckj;
  }
  
  public static final TmplParams sw(int paramInt)
  {
    AppMethodBeat.i(15001);
    Object localObject2 = sv(paramInt);
    if (!o.a((ckj)localObject2))
    {
      ab.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + paramInt + " localTmplInfo is null");
      com.tencent.mm.plugin.webview.preload.a.kS(100);
      AppMethodBeat.o(15001);
      return null;
    }
    Object localObject1 = o.c((ckj)localObject2);
    if (!o.Ha((String)localObject1))
    {
      ab.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + (String)localObject1 + " is null");
      com.tencent.mm.plugin.webview.preload.a.gK(((ckj)localObject2).xIP, 100);
      AppMethodBeat.o(15001);
      return null;
    }
    TmplParams.a locala = new TmplParams.a().Kb(paramInt).Kc(((ckj)localObject2).Version).ahG(((ckj)localObject2).Md5).ahF((String)localObject1);
    Object localObject3 = new StringBuilder("https://mp.weixin.qq.com/tmpl/").append(paramInt).append('_').append(((ckj)localObject2).wXS).append(".html");
    if ((a.f.b.j.e(PREFIX, "https://mp.weixin.qq.com/tmpl/") ^ true)) {}
    for (localObject1 = "?prefix=" + URLEncoder.encode(PREFIX);; localObject1 = "")
    {
      locala = locala.ahE((String)localObject1).Kd(((ckj)localObject2).xIP).no(o.aXO().getLong(ss(((ckj)localObject2).jKs), 0L)).ahH(((ckj)localObject2).wXS);
      localObject1 = ((ckj)localObject2).xUm;
      a.f.b.j.p(localObject1, "tmplInfo.HttpHeaderList");
      localObject2 = (Iterable)localObject1;
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cki)((Iterator)localObject2).next();
        localObject1 = ((StringBuilder)localObject1).append("\n" + ((cki)localObject3).wxP + ':' + ((cki)localObject3).qsu);
        a.f.b.j.p(localObject1, "sb.append(\"\\n${header.Key}:${header.Value}\")");
      }
    }
    localObject1 = locala.ahI(((StringBuilder)localObject1).toString()).dcR();
    AppMethodBeat.o(15001);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b
 * JD-Core Version:    0.7.0.1
 */