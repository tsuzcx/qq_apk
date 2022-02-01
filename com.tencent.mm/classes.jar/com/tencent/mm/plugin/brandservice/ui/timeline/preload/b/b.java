package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g;
import d.g.b.q;
import d.v;
import d.z;
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
import kotlinx.coroutines.ah;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager;", "", "()V", "HARDCODE_URL", "", "MIN_CHECK_TIME", "", "PPREFIX_MP", "PREFIX", "SUPPORT_TMPL_TYPES", "", "getSUPPORT_TMPL_TYPES", "()[Ljava/lang/Integer;", "SUPPORT_TMPL_TYPES$delegate", "Lkotlin/Lazy;", "TAG", "checkTmplList", "Ljava/util/ArrayList;", "expireTime", "", "expireTime$annotations", "getExpireTime", "()J", "lastCheckTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "keyDownloadTime", "getKeyDownloadTime", "(I)Ljava/lang/String;", "checkTmpl", "", "openScene", "netType", "tmplTypes", "", "checkTmplInner", "typeInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplClientTypeInfo;", "cleanInvalidTmpl", "cleanInvalidTmplInner", "clear", "createTmplParam", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplType", "download", "url", "tmplInfo", "Lcom/tencent/mm/protocal/protobuf/TmplInfo;", "httpHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onSuccess", "Lkotlin/Function0;", "downloadFile", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "reportId", "downloadUrl", "headers", "", "filePath", "downloadTmpl", "getHARDCODE_URL", "getLatestTmplInfo", "getPrefix", "getSaveDir", "getTmplByte", "Ljava/io/InputStream;", "file", "getTmplInfo", "skipUid", "getUrlWithA8key", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectRecord", "tmplParams", "success", "", "isTmplInfoExist", "needCheck", "processPatch", "result", "md5", "Lcom/tencent/mm/vfs/VFSFile;", "patchBase", "processTmplInfo", "saveCheckTimeColdDown", "coldDown", "unzip", "dir", "updateTmplInfo", "verify", "standard", "verifyMD5", "verifyVersion", "appendToList", "key", "debugInfo", "parseFrom", "type", "uid", "DownloadResult", "plugin-brandservice_release"})
public final class b
{
  private static final String PREFIX = "https://mp.weixin.qq.com/__tmpl__/";
  private static final d.f orP;
  private static final int orQ = 60000;
  private static final ConcurrentHashMap<Integer, Long> orR;
  private static final ArrayList<Integer> orS;
  public static final b orT;
  
  static
  {
    AppMethodBeat.i(6840);
    orT = new b();
    PREFIX = "https://mp.weixin.qq.com/__tmpl__/";
    orP = g.O((d.g.a.a)b.orW);
    orQ = 60000;
    orR = new ConcurrentHashMap();
    orS = new ArrayList();
    AppMethodBeat.o(6840);
  }
  
  /* Error */
  private static a a(int paramInt, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    // Byte code:
    //   0: sipush 6862
    //   3: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a
    //   9: dup
    //   10: invokespecial 188	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:<init>	()V
    //   13: astore 7
    //   15: new 190	com/tencent/mm/vfs/k
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 193	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   23: astore 8
    //   25: aload 8
    //   27: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   30: ifeq +9 -> 39
    //   33: aload 8
    //   35: invokevirtual 200	com/tencent/mm/vfs/k:delete	()Z
    //   38: pop
    //   39: new 202	java/net/URL
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 203	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 207	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnonnull +98 -> 152
    //   57: new 209	d/v
    //   60: dup
    //   61: ldc 211
    //   63: invokespecial 212	d/v:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: sipush 6862
    //   70: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_2
    //   74: athrow
    //   75: astore_2
    //   76: ldc 214
    //   78: aload_2
    //   79: checkcast 187	java/lang/Throwable
    //   82: new 216	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 218
    //   88: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_3
    //   92: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 225
    //   97: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 235	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 7
    //   116: aload_2
    //   117: checkcast 237	java/lang/Exception
    //   120: putfield 241	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   123: iload_0
    //   124: bipush 7
    //   126: invokestatic 247	com/tencent/mm/plugin/webview/g/a:gi	(II)V
    //   129: aload 8
    //   131: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   134: ifeq +9 -> 143
    //   137: aload 8
    //   139: invokevirtual 200	com/tencent/mm/vfs/k:delete	()Z
    //   142: pop
    //   143: sipush 6862
    //   146: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 7
    //   151: areturn
    //   152: aload 6
    //   154: checkcast 249	java/net/HttpURLConnection
    //   157: astore 9
    //   159: aload 9
    //   161: ldc 251
    //   163: ldc 253
    //   165: invokevirtual 257	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 9
    //   170: ldc 251
    //   172: ldc_w 259
    //   175: invokevirtual 257	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 9
    //   180: iconst_0
    //   181: invokevirtual 263	java/net/HttpURLConnection:setDefaultUseCaches	(Z)V
    //   184: aload_2
    //   185: ifnull +218 -> 403
    //   188: aload_2
    //   189: invokeinterface 268 1 0
    //   194: ifne +203 -> 397
    //   197: iconst_1
    //   198: istore 4
    //   200: iload 4
    //   202: ifeq +201 -> 403
    //   205: ldc 214
    //   207: ldc_w 270
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_2
    //   217: invokeinterface 274 1 0
    //   222: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 283	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload_2
    //   230: invokeinterface 287 1 0
    //   235: invokeinterface 293 1 0
    //   240: astore 6
    //   242: aload 6
    //   244: invokeinterface 298 1 0
    //   249: ifeq +154 -> 403
    //   252: aload 6
    //   254: invokeinterface 302 1 0
    //   259: checkcast 304	java/lang/String
    //   262: astore 10
    //   264: aload 9
    //   266: aload 10
    //   268: aload_2
    //   269: aload 10
    //   271: invokeinterface 308 2 0
    //   276: checkcast 304	java/lang/String
    //   279: invokevirtual 257	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: goto -40 -> 242
    //   285: astore_2
    //   286: sipush 6862
    //   289: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_2
    //   293: athrow
    //   294: astore_2
    //   295: aload 9
    //   297: invokevirtual 312	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   300: astore 6
    //   302: aload 6
    //   304: ifnull +8 -> 312
    //   307: aload 6
    //   309: invokevirtual 317	java/io/InputStream:close	()V
    //   312: aload 9
    //   314: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   317: sipush 6862
    //   320: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: aload_2
    //   324: athrow
    //   325: astore_2
    //   326: ldc 214
    //   328: aload_2
    //   329: checkcast 187	java/lang/Throwable
    //   332: new 216	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 322
    //   339: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: aload_3
    //   343: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 225
    //   348: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_1
    //   352: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 235	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload 7
    //   367: aload_2
    //   368: checkcast 237	java/lang/Exception
    //   371: putfield 241	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:exception	Ljava/lang/Exception;
    //   374: iload_0
    //   375: bipush 7
    //   377: invokestatic 247	com/tencent/mm/plugin/webview/g/a:gi	(II)V
    //   380: aload 8
    //   382: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   385: ifeq -242 -> 143
    //   388: aload 8
    //   390: invokevirtual 200	com/tencent/mm/vfs/k:delete	()Z
    //   393: pop
    //   394: goto -251 -> 143
    //   397: iconst_0
    //   398: istore 4
    //   400: goto -200 -> 200
    //   403: aload 9
    //   405: iconst_0
    //   406: invokevirtual 325	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   409: aload 9
    //   411: ldc_w 327
    //   414: invokevirtual 330	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   417: aload 9
    //   419: sipush 10000
    //   422: invokevirtual 333	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   425: aload 9
    //   427: sipush 3000
    //   430: invokevirtual 336	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   433: aload 9
    //   435: invokevirtual 339	java/net/HttpURLConnection:connect	()V
    //   438: aload 9
    //   440: invokevirtual 342	java/net/HttpURLConnection:getResponseCode	()I
    //   443: istore 4
    //   445: iload 4
    //   447: sipush 200
    //   450: if_icmpne +219 -> 669
    //   453: aload 8
    //   455: invokevirtual 345	com/tencent/mm/vfs/k:createNewFile	()Z
    //   458: pop
    //   459: sipush 8192
    //   462: newarray byte
    //   464: astore_2
    //   465: new 347	d/g/b/y$d
    //   468: dup
    //   469: invokespecial 348	d/g/b/y$d:<init>	()V
    //   472: astore 11
    //   474: aload 8
    //   476: invokestatic 354	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   479: checkcast 356	java/io/Closeable
    //   482: astore 10
    //   484: aconst_null
    //   485: astore 6
    //   487: aload 10
    //   489: checkcast 358	java/io/OutputStream
    //   492: astore 12
    //   494: aload 9
    //   496: invokevirtual 312	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   499: aload_2
    //   500: invokevirtual 362	java/io/InputStream:read	([B)I
    //   503: istore 4
    //   505: aload 11
    //   507: iload 4
    //   509: putfield 365	d/g/b/y$d:NiW	I
    //   512: iload 4
    //   514: iconst_m1
    //   515: if_icmpeq +45 -> 560
    //   518: aload 12
    //   520: aload_2
    //   521: iconst_0
    //   522: aload 11
    //   524: getfield 365	d/g/b/y$d:NiW	I
    //   527: invokevirtual 369	java/io/OutputStream:write	([BII)V
    //   530: goto -36 -> 494
    //   533: astore 6
    //   535: sipush 6862
    //   538: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: aload 6
    //   543: athrow
    //   544: astore_2
    //   545: aload 10
    //   547: aload 6
    //   549: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   552: sipush 6862
    //   555: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_2
    //   559: athrow
    //   560: getstatic 380	d/z:Nhr	Ld/z;
    //   563: astore_2
    //   564: aload 10
    //   566: aconst_null
    //   567: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   570: aload 7
    //   572: iconst_1
    //   573: putfield 383	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:success	Z
    //   576: aload 7
    //   578: aload 9
    //   580: ldc_w 385
    //   583: invokevirtual 389	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   586: putfield 392	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:orU	Ljava/lang/String;
    //   589: aload 7
    //   591: aload 9
    //   593: ldc_w 394
    //   596: invokevirtual 389	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   599: putfield 397	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:orV	Ljava/lang/String;
    //   602: aload 9
    //   604: ldc_w 399
    //   607: invokevirtual 389	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   610: astore_2
    //   611: aload_2
    //   612: ifnull +51 -> 663
    //   615: ldc_w 401
    //   618: aload_2
    //   619: invokestatic 406	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   622: iconst_1
    //   623: ixor
    //   624: ifeq +39 -> 663
    //   627: iconst_1
    //   628: istore 5
    //   630: aload 7
    //   632: iload 5
    //   634: putfield 409	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b/b$a:ooD	Z
    //   637: getstatic 380	d/z:Nhr	Ld/z;
    //   640: astore_2
    //   641: aload 9
    //   643: invokevirtual 312	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   646: astore_2
    //   647: aload_2
    //   648: ifnull +7 -> 655
    //   651: aload_2
    //   652: invokevirtual 317	java/io/InputStream:close	()V
    //   655: aload 9
    //   657: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   660: goto -517 -> 143
    //   663: iconst_0
    //   664: istore 5
    //   666: goto -36 -> 630
    //   669: ldc 214
    //   671: ldc_w 411
    //   674: iload 4
    //   676: invokestatic 413	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   679: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   682: invokestatic 419	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: iload 4
    //   687: sipush 500
    //   690: if_icmple +12 -> 702
    //   693: iload_0
    //   694: bipush 11
    //   696: invokestatic 247	com/tencent/mm/plugin/webview/g/a:gi	(II)V
    //   699: goto -62 -> 637
    //   702: iload 4
    //   704: sipush 400
    //   707: if_icmple -70 -> 637
    //   710: iload_0
    //   711: bipush 10
    //   713: invokestatic 247	com/tencent/mm/plugin/webview/g/a:gi	(II)V
    //   716: goto -79 -> 637
    //   719: astore 6
    //   721: goto -409 -> 312
    //   724: astore_2
    //   725: goto -70 -> 655
    //   728: astore_2
    //   729: goto -184 -> 545
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	paramInt	int
    //   0	732	1	paramString1	String
    //   0	732	2	paramMap	Map<String, String>
    //   0	732	3	paramString2	String
    //   198	510	4	i	int
    //   628	37	5	bool	boolean
    //   50	436	6	localObject1	Object
    //   533	15	6	localThrowable1	Throwable
    //   719	1	6	localThrowable2	Throwable
    //   13	618	7	locala	a
    //   23	452	8	localk	com.tencent.mm.vfs.k
    //   157	499	9	localHttpURLConnection	java.net.HttpURLConnection
    //   262	303	10	localObject2	Object
    //   472	51	11	locald	d.g.b.y.d
    //   492	27	12	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   39	52	75	java/io/FileNotFoundException
    //   57	75	75	java/io/FileNotFoundException
    //   152	159	75	java/io/FileNotFoundException
    //   295	302	75	java/io/FileNotFoundException
    //   307	312	75	java/io/FileNotFoundException
    //   312	325	75	java/io/FileNotFoundException
    //   641	647	75	java/io/FileNotFoundException
    //   651	655	75	java/io/FileNotFoundException
    //   655	660	75	java/io/FileNotFoundException
    //   159	184	285	java/lang/Throwable
    //   188	197	285	java/lang/Throwable
    //   205	242	285	java/lang/Throwable
    //   242	282	285	java/lang/Throwable
    //   403	445	285	java/lang/Throwable
    //   453	484	285	java/lang/Throwable
    //   545	560	285	java/lang/Throwable
    //   564	611	285	java/lang/Throwable
    //   615	627	285	java/lang/Throwable
    //   630	637	285	java/lang/Throwable
    //   637	641	285	java/lang/Throwable
    //   669	685	285	java/lang/Throwable
    //   693	699	285	java/lang/Throwable
    //   710	716	285	java/lang/Throwable
    //   159	184	294	finally
    //   188	197	294	finally
    //   205	242	294	finally
    //   242	282	294	finally
    //   286	294	294	finally
    //   403	445	294	finally
    //   453	484	294	finally
    //   545	560	294	finally
    //   564	611	294	finally
    //   615	627	294	finally
    //   630	637	294	finally
    //   637	641	294	finally
    //   669	685	294	finally
    //   693	699	294	finally
    //   710	716	294	finally
    //   39	52	325	java/io/IOException
    //   57	75	325	java/io/IOException
    //   152	159	325	java/io/IOException
    //   295	302	325	java/io/IOException
    //   307	312	325	java/io/IOException
    //   312	325	325	java/io/IOException
    //   641	647	325	java/io/IOException
    //   651	655	325	java/io/IOException
    //   655	660	325	java/io/IOException
    //   487	494	533	java/lang/Throwable
    //   494	512	533	java/lang/Throwable
    //   518	530	533	java/lang/Throwable
    //   560	564	533	java/lang/Throwable
    //   535	544	544	finally
    //   295	302	719	java/lang/Throwable
    //   307	312	719	java/lang/Throwable
    //   641	647	724	java/lang/Throwable
    //   651	655	724	java/lang/Throwable
    //   487	494	728	finally
    //   494	512	728	finally
    //   518	530	728	finally
    //   560	564	728	finally
  }
  
  private static dof a(dof paramdof, int paramInt, String paramString)
  {
    AppMethodBeat.i(6848);
    paramdof.nJA = paramInt;
    paramdof.GMr = paramString;
    byte[] arrayOfByte = s.bQG().decodeBytes(s.e(paramdof));
    int i;
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {}
      try
      {
        paramdof.parseFrom(arrayOfByte);
        AppMethodBeat.o(6848);
        return paramdof;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Preload.TmplInfoManager", (Throwable)localException, "decode TmplInfo:" + paramInt + ", " + paramString, new Object[0]);
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
        d.g.b.p.h(paramString, "netType");
        d.g.b.p.h(paramVarArgs, "tmplTypes");
        if (az.is2G(ak.getContext()))
        {
          ae.w("MicroMsg.Preload.TmplInfoManager", "[checkTmpl] not check, because network is 2g");
          AppMethodBeat.o(6844);
          return;
        }
        paramVarArgs = com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.oph;
        if ((!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) && (com.tencent.mm.plugin.brandservice.ui.timeline.preload.i.bGK().getInt("preload_type", 1) == 3))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.eQ("MicroMsg.Preload.TmplInfoManager", "use local file, ignore");
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
      orR.clear();
    }
    final LinkedList localLinkedList = new LinkedList();
    paramVarArgs = bRg();
    Object localObject1 = (Collection)new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    label150:
    Object localObject2;
    if (i < j)
    {
      int m = paramVarArgs[i];
      int k = ((Number)m).intValue();
      localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.oph;
      boolean bool;
      if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.i.bGK().getBoolean("preload_tmpl_always_check_tmpl_ver", false)) {
        bool = true;
      }
      while (bool)
      {
        ((Collection)localObject1).add(m);
        break;
        long l = 0L;
        if (orR.containsKey(Integer.valueOf(k)))
        {
          localObject2 = orR.get(Integer.valueOf(k));
          if (localObject2 == null) {
            d.g.b.p.gkB();
          }
          l = ((Number)localObject2).longValue();
        }
        if (orS.contains(Integer.valueOf(k)))
        {
          ae.v("MicroMsg.Preload.TmplInfoManager", "[checkTmplVer] %d already check", new Object[] { Integer.valueOf(k) });
          bool = false;
        }
        else
        {
          bool = at.ax(l, s.bQG().getLong("_check_time_colddown", orQ));
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
      yd localyd;
      if (((Iterator)localObject1).hasNext())
      {
        i = ((Number)((Iterator)localObject1).next()).intValue();
        orS.add(Integer.valueOf(i));
        ((Map)orR).put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        localyd = new yd();
        localyd.nJA = i;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.zl(101)) {
          localyd.Gqf = s.bQF();
        }
        localLinkedList.add(localyd);
        paramVarArgs = zX(i);
        if (!s.a(paramVarArgs)) {
          continue;
        }
        if (s.Yn(s.b(paramVarArgs))) {
          localyd.Gqe = paramVarArgs.GMr;
        }
        localObject2 = s.bQG().getStringSet(s.h(paramVarArgs), null);
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
          dof localdof = new dof();
          d.g.b.p.g(str, "it");
          if (a(a(localdof, i, str), paramVarArgs)) {
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
        localyd.Gqd.addAll((Collection)paramVarArgs);
        break label336;
        if (!((Collection)localLinkedList).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.plugin.webview.g.a.md(0);
            new a(localLinkedList, paramInt, paramString).aET().g((com.tencent.mm.vending.c.a)new c(paramInt, localLinkedList));
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
  
  public static void a(dog paramdog, boolean paramBoolean)
  {
    AppMethodBeat.i(208968);
    d.g.b.p.h(paramdog, "tmplParams");
    String str = "_tmpl_info_inject_fail_-" + paramdog.opt + '-' + paramdog.AXc;
    if (paramBoolean)
    {
      s.bQG().removeValueForKey(str);
      AppMethodBeat.o(208968);
      return;
    }
    int i = s.bQG().getInt(str, 0) + 1;
    s.bQG().putInt(str, i);
    ae.e("MicroMsg.Preload.TmplInfoManager", "store tmpl inject fail:" + paramdog.opt + ',' + paramdog.AXc + ',' + i);
    if (i > 2)
    {
      com.tencent.mm.plugin.webview.g.a.md(219);
      ae.e("MicroMsg.Preload.TmplInfoManager", "clear tmpl for too many inject fail:" + paramdog.opt + ',' + paramdog.AXc + ',' + i);
    }
    AppMethodBeat.o(208968);
  }
  
  private static boolean a(dof paramdof1, dof paramdof2)
  {
    AppMethodBeat.i(6849);
    if (s.Ym(s.b(paramdof1)).exists())
    {
      if (b(paramdof1, paramdof2))
      {
        s.bQG().putString(s.f(paramdof1), paramdof1.GMr);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.b(s.bQG(), s.g(paramdof1));
        AppMethodBeat.o(6849);
        return true;
      }
      if (d.g.b.p.i(s.e(paramdof1), s.bQG().getString(s.f(paramdof1), null)))
      {
        s.bQG().removeValueForKey(s.f(paramdof1));
        s.bQG().removeValueForKey(s.g(paramdof1));
      }
      s.bQG().remove(s.e(paramdof1));
      paramdof2 = s.h(paramdof2);
      Set localSet = s.bQG().getStringSet(paramdof2, null);
      if (localSet != null)
      {
        localSet.remove(paramdof1.GMr);
        s.bQG().putStringSet(paramdof2, localSet);
      }
      ae.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramdof1.GMr + " is invalid");
    }
    for (;;)
    {
      AppMethodBeat.o(6849);
      return false;
      ae.i("MicroMsg.Preload.TmplInfoManager", "no tmpl file:" + paramdof1.GMr);
    }
  }
  
  private static dof aD(int paramInt, String paramString)
  {
    AppMethodBeat.i(6852);
    dof localdof1 = zW(paramInt);
    if (s.a(localdof1))
    {
      if ((s.Yn(s.b(localdof1))) && ((d.g.b.p.i(localdof1.GMr, paramString) ^ true)))
      {
        AppMethodBeat.o(6852);
        return localdof1;
      }
      Object localObject1 = s.bQG().getString(s.f(localdof1), null);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new dof();
        d.g.b.p.g(localObject1, "it");
        localObject1 = a((dof)localObject2, paramInt, (String)localObject1);
        if ((localObject1 != null) && (s.a((dof)localObject1)) && (!s.i((dof)localObject1)) && (s.Yn(s.b((dof)localObject1))) && ((d.g.b.p.i(((dof)localObject1).GMr, paramString) ^ true)))
        {
          AppMethodBeat.o(6852);
          return localObject1;
        }
      }
      localObject1 = s.bQG().getStringSet(s.h(localdof1), null);
      if (localObject1 != null)
      {
        localObject1 = (Iterable)localObject1;
        d.g.b.p.h(localObject1, "$this$sortedDescending");
        localObject2 = d.b.f.NhP;
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
            if ((d.g.b.p.i(localObject2, paramString) ^ true))
            {
              dof localdof2 = new dof();
              d.g.b.p.g(localObject2, "uid");
              localObject2 = a(localdof2, paramInt, (String)localObject2);
              if (a((dof)localObject2, localdof1))
              {
                AppMethodBeat.o(6852);
                return localObject2;
              }
            }
          }
        }
      }
    }
    paramString = new dof();
    AppMethodBeat.o(6852);
    return paramString;
  }
  
  private static boolean b(dof paramdof1, dof paramdof2)
  {
    AppMethodBeat.i(6850);
    if ((d.g.b.p.i(paramdof1, paramdof2)) && (paramdof1.Version != 0))
    {
      AppMethodBeat.o(6850);
      return true;
    }
    int i = paramdof2.Gqi;
    Object localObject;
    if (ae.getLogLevel() == 0)
    {
      localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.oph;
      int j = h.a.bQr();
      if (j > 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (paramdof1.Version < i)
      {
        ae.e("MicroMsg.Preload.TmplInfoManager", "tmpl " + paramdof1.GMr + " version:" + paramdof1.Version + " < " + i);
        AppMethodBeat.o(6850);
        return false;
      }
      paramdof2 = paramdof2.HVf;
      d.g.b.p.g(paramdof2, "standard.VersionControlList");
      paramdof2 = ((Iterable)paramdof2).iterator();
      while (paramdof2.hasNext())
      {
        localObject = (doh)paramdof2.next();
        if (d.g.b.p.i(((doh)localObject).GMr, paramdof1.GMr))
        {
          ae.i("MicroMsg.Preload.TmplInfoManager", "tmpl " + ((doh)localObject).GMr + " matchControls in forceH5:" + ((doh)localObject).HVj);
          if (!((doh)localObject).HVj)
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
  
  public static Integer[] bRg()
  {
    AppMethodBeat.i(6841);
    Integer[] arrayOfInteger = (Integer[])orP.getValue();
    AppMethodBeat.o(6841);
    return arrayOfInteger;
  }
  
  public static final void bRh()
  {
    AppMethodBeat.i(6855);
    com.tencent.e.h.MqF.f((Runnable)d.orY, "tmplPreload");
    AppMethodBeat.o(6855);
  }
  
  public static final String bRi()
  {
    AppMethodBeat.i(6857);
    String str = com.tencent.mm.loader.j.b.asb() + "webview_tmpl/";
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.oph;
    if (h.a.bQq())
    {
      str = com.tencent.mm.loader.j.b.asj();
      d.g.b.p.g(str, "CConstants.DATAROOT_SDCARD_PATH()");
    }
    localObject = str;
    if (!d.n.n.nG(str, "/")) {
      localObject = str + "/";
    }
    str = (String)localObject + "tmpls/";
    com.tencent.mm.sdk.platformtools.n.aMy(str);
    AppMethodBeat.o(6857);
    return str;
  }
  
  public static final String bRj()
  {
    return "https://mp.weixin.qq.com/__tmpl__/";
  }
  
  private static boolean c(String paramString, com.tencent.mm.vfs.k paramk)
  {
    AppMethodBeat.i(175496);
    if ((!bu.isNullOrNil(paramString)) && (d.g.b.p.i(paramString, o.aRh(paramk.getPath()))))
    {
      AppMethodBeat.o(175496);
      return true;
    }
    ae.e("MicroMsg.Preload.TmplInfoManager", "checkTmpl %s, MD5 not match", new Object[] { paramk.getAbsolutePath() });
    AppMethodBeat.o(175496);
    return false;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(6845);
    s.bQG().clear();
    o.dd(bRi(), true);
    o.deleteDir(com.tencent.mm.loader.j.b.asb() + "/jscache/");
    AppMethodBeat.o(6845);
  }
  
  /* Error */
  private static boolean eT(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 6861
    //   3: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1217	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 1218	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: checkcast 356	java/io/Closeable
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 1217	java/util/zip/ZipFile
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 1222	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   27: astore 6
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 7
    //   36: new 347	d/g/b/y$d
    //   39: dup
    //   40: invokespecial 348	d/g/b/y$d:<init>	()V
    //   43: astore 8
    //   45: aload 6
    //   47: invokeinterface 1227 1 0
    //   52: ifeq +349 -> 401
    //   55: aload 6
    //   57: invokeinterface 1230 1 0
    //   62: checkcast 1232	java/util/zip/ZipEntry
    //   65: astore 4
    //   67: aload 4
    //   69: ldc_w 1234
    //   72: invokestatic 490	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload 4
    //   77: invokevirtual 1235	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ldc_w 1237
    //   87: invokestatic 490	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload 5
    //   92: checkcast 764	java/lang/CharSequence
    //   95: ldc_w 1239
    //   98: iconst_0
    //   99: iconst_0
    //   100: bipush 6
    //   102: invokestatic 1242	d/n/n:a	(Ljava/lang/CharSequence;Ljava/lang/String;IZI)I
    //   105: iconst_m1
    //   106: if_icmpeq +46 -> 152
    //   109: ldc 214
    //   111: ldc_w 1244
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload 5
    //   122: aastore
    //   123: invokestatic 960	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: goto -81 -> 45
    //   129: astore_1
    //   130: sipush 6861
    //   133: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_0
    //   139: aload_3
    //   140: aload_1
    //   141: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   144: sipush 6861
    //   147: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: athrow
    //   152: new 190	com/tencent/mm/vfs/k
    //   155: dup
    //   156: new 216	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 755	java/lang/StringBuilder:<init>	()V
    //   163: aload_1
    //   164: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 5
    //   169: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 193	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   178: astore 5
    //   180: new 190	com/tencent/mm/vfs/k
    //   183: dup
    //   184: aload 5
    //   186: invokevirtual 1247	com/tencent/mm/vfs/k:getParent	()Ljava/lang/String;
    //   189: invokespecial 193	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   192: astore 9
    //   194: aload 9
    //   196: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   199: ifne +9 -> 208
    //   202: aload 9
    //   204: invokevirtual 1250	com/tencent/mm/vfs/k:mkdirs	()Z
    //   207: pop
    //   208: aload 4
    //   210: invokevirtual 1251	java/util/zip/ZipEntry:isDirectory	()Z
    //   213: ifeq +20 -> 233
    //   216: aload 5
    //   218: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   221: ifne -176 -> 45
    //   224: aload 5
    //   226: invokevirtual 1254	com/tencent/mm/vfs/k:mkdir	()Z
    //   229: pop
    //   230: goto -185 -> 45
    //   233: aload 5
    //   235: invokevirtual 197	com/tencent/mm/vfs/k:exists	()Z
    //   238: ifne +9 -> 247
    //   241: aload 5
    //   243: invokevirtual 345	com/tencent/mm/vfs/k:createNewFile	()Z
    //   246: pop
    //   247: aload_0
    //   248: aload 4
    //   250: invokevirtual 1257	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   253: checkcast 356	java/io/Closeable
    //   256: astore 4
    //   258: aload 4
    //   260: checkcast 314	java/io/InputStream
    //   263: astore 9
    //   265: new 1259	java/io/BufferedOutputStream
    //   268: dup
    //   269: aload 5
    //   271: invokestatic 354	com/tencent/mm/vfs/o:aj	(Lcom/tencent/mm/vfs/k;)Ljava/io/OutputStream;
    //   274: invokespecial 1262	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   277: checkcast 356	java/io/Closeable
    //   280: astore 5
    //   282: aload 5
    //   284: checkcast 1259	java/io/BufferedOutputStream
    //   287: astore 10
    //   289: aload 9
    //   291: aload 7
    //   293: invokevirtual 362	java/io/InputStream:read	([B)I
    //   296: istore_2
    //   297: aload 8
    //   299: iload_2
    //   300: putfield 365	d/g/b/y$d:NiW	I
    //   303: iload_2
    //   304: ifle +67 -> 371
    //   307: aload 10
    //   309: aload 7
    //   311: iconst_0
    //   312: aload 8
    //   314: getfield 365	d/g/b/y$d:NiW	I
    //   317: invokevirtual 1263	java/io/BufferedOutputStream:write	([BII)V
    //   320: goto -31 -> 289
    //   323: astore_1
    //   324: sipush 6861
    //   327: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_1
    //   331: athrow
    //   332: astore_0
    //   333: aload 5
    //   335: aload_1
    //   336: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   339: sipush 6861
    //   342: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: aload_0
    //   346: athrow
    //   347: astore_1
    //   348: sipush 6861
    //   351: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload_1
    //   355: athrow
    //   356: astore_0
    //   357: aload 4
    //   359: aload_1
    //   360: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   363: sipush 6861
    //   366: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: aload_0
    //   370: athrow
    //   371: aload 10
    //   373: invokevirtual 1266	java/io/BufferedOutputStream:flush	()V
    //   376: getstatic 380	d/z:Nhr	Ld/z;
    //   379: astore 9
    //   381: aload 5
    //   383: aconst_null
    //   384: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   387: getstatic 380	d/z:Nhr	Ld/z;
    //   390: astore 5
    //   392: aload 4
    //   394: aconst_null
    //   395: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   398: goto -353 -> 45
    //   401: aload_3
    //   402: aconst_null
    //   403: invokestatic 374	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   406: sipush 6861
    //   409: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   43	270	8	locald	d.g.b.y.d
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
  
  public static final void j(dof paramdof)
  {
    AppMethodBeat.i(6847);
    d.g.b.p.h(paramdof, "tmplInfo");
    Object localObject1 = s.e(paramdof);
    Object localObject2 = paramdof.GMr;
    s.bQG().putString(s.zR(paramdof.nJA), (String)localObject2);
    s.bQG().removeValueForKey(s.f(paramdof));
    s.bQG().removeValueForKey(s.g(paramdof));
    s.bQG().encode((String)localObject1, paramdof.toByteArray());
    String str = s.h(paramdof);
    ay localay = s.bQG();
    localObject2 = s.bQG().getStringSet(str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Set)new HashSet();
    }
    ((Set)localObject1).add(paramdof.GMr);
    localay.putStringSet(str, (Set)localObject1);
    AppMethodBeat.o(6847);
  }
  
  private static final boolean k(dof paramdof)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6854);
        if (paramdof == null)
        {
          ae.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is null, return false");
          AppMethodBeat.o(6854);
          return bool;
        }
        if (!s.a(paramdof))
        {
          ae.e("MicroMsg.Preload.TmplInfoManager", "isTmplInfoExist() tmplInfo is invalid, return false");
          AppMethodBeat.o(6854);
          continue;
        }
        if (zW(paramdof.nJA).Version == paramdof.Version) {
          break label90;
        }
      }
      finally {}
      AppMethodBeat.o(6854);
      continue;
      label90:
      if (!s.Yn(s.b(paramdof)))
      {
        ae.w("MicroMsg.Preload.TmplInfoManager", "[isTmplInfoExist]file isn't exist, may be delete");
        AppMethodBeat.o(6854);
      }
      else
      {
        bool = true;
        AppMethodBeat.o(6854);
      }
    }
  }
  
  private static String l(dof paramdof)
  {
    AppMethodBeat.i(6858);
    paramdof = "Type:" + paramdof.nJA + " Version:" + paramdof.Version + " CdnUrl:" + paramdof.GaE + " Md5:" + paramdof.Md5;
    AppMethodBeat.o(6858);
    return paramdof;
  }
  
  private static String zU(int paramInt)
  {
    AppMethodBeat.i(6842);
    String str = "_tmpl_download_time_".concat(String.valueOf(paramInt));
    AppMethodBeat.o(6842);
    return str;
  }
  
  public static final void zV(int paramInt)
  {
    AppMethodBeat.i(6846);
    s.bQG().putLong("_check_time_colddown", paramInt * 1000);
    AppMethodBeat.o(6846);
  }
  
  public static final dof zW(int paramInt)
  {
    AppMethodBeat.i(6851);
    dof localdof = new dof();
    String str = s.bQG().getString(s.zR(paramInt), null);
    if (str != null)
    {
      d.g.b.p.g(str, "uid");
      a(localdof, paramInt, str);
    }
    AppMethodBeat.o(6851);
    return localdof;
  }
  
  public static final dog zY(int paramInt)
  {
    AppMethodBeat.i(208969);
    Object localObject2 = zX(paramInt);
    if (!s.a((dof)localObject2))
    {
      ae.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]type:" + paramInt + " localTmplInfo is null");
      com.tencent.mm.plugin.webview.g.a.md(100);
      AppMethodBeat.o(208969);
      return null;
    }
    Object localObject1 = s.c((dof)localObject2);
    if (!s.Yn((String)localObject1))
    {
      ae.e("MicroMsg.Preload.TmplInfoManager", "[createTmplParams]filePath:" + (String)localObject1 + " is null");
      com.tencent.mm.plugin.webview.g.a.gi(((dof)localObject2).HHc, 100);
      AppMethodBeat.o(208969);
      return null;
    }
    dog localdog = new dog();
    localdog.opt = paramInt;
    localdog.version = ((dof)localObject2).Version;
    localdog.md5 = ((dof)localObject2).Md5;
    localdog.HVh = ((String)localObject1);
    Object localObject3 = new StringBuilder("https://mp.weixin.qq.com/__tmpl__/").append(paramInt).append('_').append(((dof)localObject2).GMr).append(".html");
    if ((d.g.b.p.i(PREFIX, "https://mp.weixin.qq.com/__tmpl__/") ^ true)) {}
    for (localObject1 = "?prefix=" + URLEncoder.encode(PREFIX);; localObject1 = "")
    {
      localdog.EfF = ((String)localObject1);
      localdog.reportId = ((dof)localObject2).HHc;
      localdog.zFz = s.bQG().getLong(zU(((dof)localObject2).nJA), 0L);
      localdog.AXc = ((dof)localObject2).GMr;
      localObject1 = ((dof)localObject2).HVd;
      d.g.b.p.g(localObject1, "tmplInfo.HttpHeaderList");
      localObject2 = (Iterable)localObject1;
      localObject1 = new StringBuilder();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (doe)((Iterator)localObject2).next();
        localObject1 = ((StringBuilder)localObject1).append("\n" + ((doe)localObject3).uuW + ':' + ((doe)localObject3).yxn);
        d.g.b.p.g(localObject1, "sb.append(\"\\n${header.Key}:${header.Value}\")");
      }
    }
    localdog.HVi = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(208969);
    return localdog;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$DownloadResult;", "", "()V", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "isZip", "", "()Z", "setZip", "(Z)V", "patchBase", "", "getPatchBase", "()Ljava/lang/String;", "setPatchBase", "(Ljava/lang/String;)V", "patchMD5", "getPatchMD5", "setPatchMD5", "success", "getSuccess", "setSuccess", "plugin-brandservice_release"})
  public static final class a
  {
    Exception exception;
    boolean ooD;
    String orU;
    String orV;
    boolean success;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Integer;"})
  static final class b
    extends q
    implements d.g.a.a<Integer[]>
  {
    public static final b orW;
    
    static
    {
      AppMethodBeat.i(6828);
      orW = new b();
      AppMethodBeat.o(6828);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "checkTmplVerRespCgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CheckTmplVerResp;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<Void, a.a<yf>>
  {
    c(int paramInt, LinkedList paramLinkedList) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    public static final d orY;
    
    static
    {
      AppMethodBeat.i(6831);
      orY = new d();
      AppMethodBeat.o(6831);
    }
    
    public final void run()
    {
      AppMethodBeat.i(6830);
      b.bRl();
      AppMethodBeat.o(6830);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"isIncludeFile", "", "Ljava/util/ArrayList;", "", "file", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
  static final class e
    extends q
    implements d.g.a.m<ArrayList<String>, com.tencent.mm.vfs.k, Boolean>
  {
    public static final e orZ;
    
    static
    {
      AppMethodBeat.i(6834);
      orZ = new e();
      AppMethodBeat.o(6834);
    }
    
    e()
    {
      super();
    }
    
    public static boolean a(ArrayList<String> paramArrayList, com.tencent.mm.vfs.k paramk)
    {
      AppMethodBeat.i(6833);
      d.g.b.p.h(paramArrayList, "$this$isIncludeFile");
      d.g.b.p.h(paramk, "file");
      StringBuilder localStringBuilder = new StringBuilder().append(paramk.getAbsolutePath());
      if (paramk.isDirectory()) {}
      for (paramk = "/";; paramk = "")
      {
        boolean bool = paramArrayList.contains(paramk);
        AppMethodBeat.o(6833);
        return bool;
      }
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.resdownload.LocalTmplInfoManager$downloadTmpl$1", f="LocalTmplInfoManager.kt", gkn={585}, m="invokeSuspend")
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends d.d.b.a.j
    implements d.g.a.m<ah, d.d.d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    Object oqW;
    Object oqX;
    
    f(dof paramdof, int paramInt, d.g.a.a parama, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(6836);
      d.g.b.p.h(paramd, "completion");
      paramd = new f(this.osa, this.obr, this.osb, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(6836);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(6835);
      d.d.a.a locala = d.d.a.a.Nif;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(6835);
        throw paramObject;
      case 0: 
        localObject2 = this.ocz;
        paramObject = new HashMap();
        localObject1 = this.osa.GaE;
        Object localObject3 = this.osa.HVd;
        d.g.b.p.g(localObject3, "tmplInfo.HttpHeaderList");
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (doe)((Iterator)localObject3).next();
          Object localObject5 = (CharSequence)((doe)localObject4).uuW;
          if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
          {
            i = 1;
            if (i != 0) {
              continue;
            }
            localObject5 = (CharSequence)((doe)localObject4).yxn;
            if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
              break label242;
            }
          }
          for (i = 1; i == 0; i = 0)
          {
            localObject5 = (Map)paramObject;
            String str = ((doe)localObject4).uuW;
            d.g.b.p.g(str, "it.Key");
            localObject4 = ((doe)localObject4).yxn;
            d.g.b.p.g(localObject4, "it.Value");
            ((Map)localObject5).put(str, localObject4);
            break;
            i = 0;
            break label153;
          }
        }
        if (!this.osa.HVe) {
          break label396;
        }
        localObject3 = b.orT;
        d.g.b.p.g(localObject1, "downloadUrl");
        this.ocA = localObject2;
        this.oqW = paramObject;
        this.oqX = localObject1;
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
        localObject2 = (HashMap)this.oqW;
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
        localObject2 = b.orT;
        b.a((String)localObject1, this.osa, paramObject, this.obr, this.osb);
      }
      for (;;)
      {
        paramObject = z.Nhr;
        AppMethodBeat.o(6835);
        return paramObject;
        label396:
        break;
        i = 0;
        break label358;
        label404:
        paramObject = new StringBuilder("url is null or empty:");
        localObject1 = b.orT;
        ae.e("MicroMsg.Preload.TmplInfoManager", b.m(this.osa));
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(6837);
      paramObject1 = ((f)a(paramObject1, (d.d.d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(6837);
      return paramObject1;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/resdownload/LocalTmplInfoManager$getUrlWithA8key$2$1"})
  static final class g
    implements com.tencent.mm.ak.f
  {
    g(d.d.d paramd, String paramString, HashMap paramHashMap) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(6838);
      ae.i("MicroMsg.Preload.TmplInfoManager", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
            ae.e("MicroMsg.Preload.TmplInfoManager", "NetSceneGetA8Key ex " + paramString.getMessage());
            AppMethodBeat.o(6838);
            return;
          }
        }
        paramString = (com.tencent.mm.modelsimple.l)paramn;
        paramn = paramString.aKV();
        d.g.b.p.g(paramn, "netSceneGetA8Key.httpHeader");
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
          localObject1 = (bpk)paramn.next();
          localObject2 = (CharSequence)((bpk)localObject1).uuW;
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
          localObject2 = (CharSequence)((bpk)localObject1).yxn;
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
          localObject2 = (Map)this.osc;
          String str = ((bpk)localObject1).uuW;
          d.g.b.p.g(str, "it.Key");
          localObject1 = ((bpk)localObject1).yxn;
          d.g.b.p.g(localObject1, "it.Value");
          ((Map)localObject2).put(str, localObject1);
          break;
          paramn = this.oqN;
          paramString = paramString.aKO();
          localObject1 = d.p.Nhh;
          paramn.eQ(d.p.eO(paramString));
          AppMethodBeat.o(6838);
          return;
          paramString = this.oqN;
          paramn = d.p.Nhh;
          paramString.eQ(d.p.eO(""));
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
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