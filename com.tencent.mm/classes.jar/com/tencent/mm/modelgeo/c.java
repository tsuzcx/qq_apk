package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c
  implements i
{
  public static String TAG;
  private static c lLv;
  private static final String lLw;
  private HashMap<String, CopyOnWriteArrayList<WeakReference<a>>> bqq;
  private boolean lLA;
  private c lLx;
  private CopyOnWriteArrayList<c> lLy;
  private QueueWorkerThread lLz;
  
  static
  {
    AppMethodBeat.i(194454);
    TAG = "MicroMsg.LocationAddr";
    lLw = "http://" + WeChatHosts.domainString(c.h.host_location_desc_map_qq_com) + "/rgeoc?lnglat=%f,%f";
    AppMethodBeat.o(194454);
  }
  
  private c()
  {
    AppMethodBeat.i(150467);
    this.lLx = null;
    this.lLy = new CopyOnWriteArrayList();
    this.bqq = new HashMap();
    this.lLz = new QueueWorkerThread(1, "addr_worker");
    this.lLA = true;
    AppMethodBeat.o(150467);
  }
  
  /* Error */
  private static Addr a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 118	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   8: astore 12
    //   10: new 120	com/tencent/mm/modelgeo/Addr
    //   13: dup
    //   14: invokespecial 121	com/tencent/mm/modelgeo/Addr:<init>	()V
    //   17: astore 11
    //   19: iload 4
    //   21: ifeq +302 -> 323
    //   24: ldc 123
    //   26: iconst_3
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: dload_0
    //   33: invokestatic 129	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: dload_2
    //   40: invokestatic 129	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: aload 12
    //   48: aastore
    //   49: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 6
    //   54: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   57: ldc 137
    //   59: aload 6
    //   61: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: astore 10
    //   73: aconst_null
    //   74: astore 9
    //   76: aconst_null
    //   77: astore 7
    //   79: aload 6
    //   81: aconst_null
    //   82: invokestatic 155	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 7
    //   91: aload 6
    //   93: astore 10
    //   95: aload 6
    //   97: astore 9
    //   99: aload 6
    //   101: sipush 10000
    //   104: invokevirtual 160	com/tencent/mm/network/x:xz	(I)V
    //   107: aload 6
    //   109: astore 7
    //   111: aload 6
    //   113: astore 10
    //   115: aload 6
    //   117: astore 9
    //   119: aload 6
    //   121: ldc 162
    //   123: invokevirtual 165	com/tencent/mm/network/x:Zu	(Ljava/lang/String;)V
    //   126: aload 6
    //   128: astore 7
    //   130: aload 6
    //   132: astore 10
    //   134: aload 6
    //   136: astore 9
    //   138: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   141: new 47	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 167
    //   147: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 6
    //   152: invokevirtual 171	com/tencent/mm/network/x:getResponseCode	()I
    //   155: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 6
    //   166: astore 7
    //   168: aload 6
    //   170: astore 10
    //   172: aload 6
    //   174: astore 9
    //   176: new 176	java/io/InputStreamReader
    //   179: dup
    //   180: aload 6
    //   182: invokevirtual 180	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   185: invokespecial 183	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   188: astore 8
    //   190: aload 6
    //   192: astore 7
    //   194: new 185	java/io/BufferedReader
    //   197: dup
    //   198: aload 8
    //   200: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   203: astore 9
    //   205: aload 6
    //   207: astore 7
    //   209: new 190	java/lang/StringBuffer
    //   212: dup
    //   213: invokespecial 191	java/lang/StringBuffer:<init>	()V
    //   216: astore 10
    //   218: aload 6
    //   220: astore 7
    //   222: aload 9
    //   224: invokevirtual 194	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   227: astore 13
    //   229: aload 13
    //   231: ifnull +125 -> 356
    //   234: aload 6
    //   236: astore 7
    //   238: aload 10
    //   240: aload 13
    //   242: invokevirtual 197	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: goto -28 -> 218
    //   249: astore 10
    //   251: aload 6
    //   253: astore 7
    //   255: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   258: ldc 199
    //   260: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 6
    //   265: astore 7
    //   267: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   270: ldc 201
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 10
    //   280: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   283: aastore
    //   284: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 8
    //   289: astore 7
    //   291: aload 6
    //   293: ifnull +12 -> 305
    //   296: aload 6
    //   298: invokevirtual 214	com/tencent/mm/network/x:disconnect	()V
    //   301: aload 8
    //   303: astore 7
    //   305: aload 7
    //   307: ifnull +8 -> 315
    //   310: aload 7
    //   312: invokevirtual 217	java/io/InputStreamReader:close	()V
    //   315: ldc 113
    //   317: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 11
    //   322: areturn
    //   323: ldc 123
    //   325: iconst_3
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: dload_0
    //   332: invokestatic 129	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: dload_2
    //   339: invokestatic 129	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   342: aastore
    //   343: dup
    //   344: iconst_2
    //   345: ldc 219
    //   347: aastore
    //   348: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   351: astore 6
    //   353: goto -299 -> 54
    //   356: aload 6
    //   358: astore 7
    //   360: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   363: new 47	java/lang/StringBuilder
    //   366: dup
    //   367: ldc 221
    //   369: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   372: aload 10
    //   374: invokevirtual 222	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   377: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 6
    //   388: astore 7
    //   390: new 224	org/json/JSONObject
    //   393: dup
    //   394: aload 10
    //   396: invokevirtual 222	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   399: invokespecial 225	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   402: ldc 227
    //   404: invokevirtual 231	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   407: astore 10
    //   409: aload 6
    //   411: astore 7
    //   413: aload 10
    //   415: iconst_0
    //   416: invokevirtual 237	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   419: astore 9
    //   421: aload 6
    //   423: astore 7
    //   425: aload 11
    //   427: aload 9
    //   429: ldc 239
    //   431: invokevirtual 242	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: putfield 245	com/tencent/mm/modelgeo/Addr:lLg	Ljava/lang/String;
    //   437: aload 6
    //   439: astore 7
    //   441: aload 10
    //   443: iconst_0
    //   444: invokevirtual 237	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   447: ldc 247
    //   449: invokevirtual 231	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   452: astore 13
    //   454: iconst_0
    //   455: istore 5
    //   457: aload 6
    //   459: astore 7
    //   461: iload 5
    //   463: aload 13
    //   465: invokevirtual 250	org/json/JSONArray:length	()I
    //   468: if_icmpge +269 -> 737
    //   471: aload 6
    //   473: astore 7
    //   475: aload 13
    //   477: iload 5
    //   479: invokevirtual 237	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   482: astore 14
    //   484: aload 6
    //   486: astore 7
    //   488: aload 14
    //   490: ldc 252
    //   492: invokevirtual 242	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   495: astore 10
    //   497: aload 6
    //   499: astore 7
    //   501: aload 14
    //   503: ldc 254
    //   505: invokevirtual 231	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   508: iconst_0
    //   509: invokevirtual 256	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   512: astore 14
    //   514: aload 6
    //   516: astore 7
    //   518: aload 14
    //   520: ldc_w 258
    //   523: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifeq +17 -> 543
    //   529: aload 6
    //   531: astore 7
    //   533: aload 11
    //   535: aload 10
    //   537: putfield 265	com/tencent/mm/modelgeo/Addr:lLh	Ljava/lang/String;
    //   540: goto +561 -> 1101
    //   543: aload 6
    //   545: astore 7
    //   547: aload 14
    //   549: ldc_w 267
    //   552: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   555: ifeq +17 -> 572
    //   558: aload 6
    //   560: astore 7
    //   562: aload 11
    //   564: aload 10
    //   566: putfield 270	com/tencent/mm/modelgeo/Addr:lLi	Ljava/lang/String;
    //   569: goto +532 -> 1101
    //   572: aload 6
    //   574: astore 7
    //   576: aload 14
    //   578: ldc_w 272
    //   581: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   584: ifeq +37 -> 621
    //   587: aload 6
    //   589: astore 7
    //   591: aload 11
    //   593: aload 10
    //   595: putfield 275	com/tencent/mm/modelgeo/Addr:lLk	Ljava/lang/String;
    //   598: goto +503 -> 1101
    //   601: astore 6
    //   603: aload 7
    //   605: ifnull +8 -> 613
    //   608: aload 7
    //   610: invokevirtual 214	com/tencent/mm/network/x:disconnect	()V
    //   613: ldc 113
    //   615: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: aload 6
    //   620: athrow
    //   621: aload 6
    //   623: astore 7
    //   625: aload 14
    //   627: ldc_w 277
    //   630: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   633: ifeq +17 -> 650
    //   636: aload 6
    //   638: astore 7
    //   640: aload 11
    //   642: aload 10
    //   644: putfield 280	com/tencent/mm/modelgeo/Addr:lLl	Ljava/lang/String;
    //   647: goto +454 -> 1101
    //   650: aload 6
    //   652: astore 7
    //   654: aload 14
    //   656: ldc_w 282
    //   659: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   662: ifeq +17 -> 679
    //   665: aload 6
    //   667: astore 7
    //   669: aload 11
    //   671: aload 10
    //   673: putfield 285	com/tencent/mm/modelgeo/Addr:lLm	Ljava/lang/String;
    //   676: goto +425 -> 1101
    //   679: aload 6
    //   681: astore 7
    //   683: aload 14
    //   685: ldc_w 287
    //   688: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   691: ifeq +17 -> 708
    //   694: aload 6
    //   696: astore 7
    //   698: aload 11
    //   700: aload 10
    //   702: putfield 290	com/tencent/mm/modelgeo/Addr:lLn	Ljava/lang/String;
    //   705: goto +396 -> 1101
    //   708: aload 6
    //   710: astore 7
    //   712: aload 14
    //   714: ldc_w 292
    //   717: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   720: ifeq +381 -> 1101
    //   723: aload 6
    //   725: astore 7
    //   727: aload 11
    //   729: aload 10
    //   731: putfield 294	com/tencent/mm/modelgeo/Addr:country	Ljava/lang/String;
    //   734: goto +367 -> 1101
    //   737: aload 6
    //   739: astore 7
    //   741: aload 11
    //   743: getfield 245	com/tencent/mm/modelgeo/Addr:lLg	Ljava/lang/String;
    //   746: ldc_w 296
    //   749: invokestatic 302	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   752: astore 10
    //   754: aload 6
    //   756: astore 7
    //   758: aload 13
    //   760: invokevirtual 303	org/json/JSONArray:toString	()Ljava/lang/String;
    //   763: ldc_w 296
    //   766: invokestatic 302	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   769: astore 13
    //   771: aload 6
    //   773: astore 7
    //   775: aload 9
    //   777: ldc_w 305
    //   780: invokevirtual 308	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   783: invokevirtual 309	org/json/JSONObject:toString	()Ljava/lang/String;
    //   786: ldc_w 296
    //   789: invokestatic 302	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore 14
    //   794: aload 6
    //   796: astore 7
    //   798: aload 9
    //   800: ldc_w 311
    //   803: invokevirtual 242	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   806: ldc_w 296
    //   809: invokestatic 302	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   812: astore 15
    //   814: aload 6
    //   816: astore 7
    //   818: aload 9
    //   820: ldc 254
    //   822: invokevirtual 231	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   825: invokevirtual 303	org/json/JSONArray:toString	()Ljava/lang/String;
    //   828: ldc_w 296
    //   831: invokestatic 302	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   834: astore 9
    //   836: aload 6
    //   838: astore 7
    //   840: ldc_w 313
    //   843: iconst_2
    //   844: anewarray 4	java/lang/Object
    //   847: dup
    //   848: iconst_0
    //   849: dload_0
    //   850: invokestatic 129	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   853: aastore
    //   854: dup
    //   855: iconst_1
    //   856: dload_2
    //   857: invokestatic 129	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   860: aastore
    //   861: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   864: ldc_w 296
    //   867: invokestatic 302	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   870: astore 16
    //   872: aload 6
    //   874: astore 7
    //   876: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   879: ldc_w 315
    //   882: bipush 7
    //   884: anewarray 4	java/lang/Object
    //   887: dup
    //   888: iconst_0
    //   889: aload 10
    //   891: aastore
    //   892: dup
    //   893: iconst_1
    //   894: aload 13
    //   896: aastore
    //   897: dup
    //   898: iconst_2
    //   899: aload 14
    //   901: aastore
    //   902: dup
    //   903: iconst_3
    //   904: aload 15
    //   906: aastore
    //   907: dup
    //   908: iconst_4
    //   909: aload 9
    //   911: aastore
    //   912: dup
    //   913: iconst_5
    //   914: aload 16
    //   916: aastore
    //   917: dup
    //   918: bipush 6
    //   920: aload 12
    //   922: aastore
    //   923: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   926: aload 6
    //   928: astore 7
    //   930: getstatic 323	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   933: sipush 12886
    //   936: bipush 7
    //   938: anewarray 4	java/lang/Object
    //   941: dup
    //   942: iconst_0
    //   943: aload 13
    //   945: aastore
    //   946: dup
    //   947: iconst_1
    //   948: aload 10
    //   950: aastore
    //   951: dup
    //   952: iconst_2
    //   953: aload 14
    //   955: aastore
    //   956: dup
    //   957: iconst_3
    //   958: aload 15
    //   960: aastore
    //   961: dup
    //   962: iconst_4
    //   963: aload 9
    //   965: aastore
    //   966: dup
    //   967: iconst_5
    //   968: aload 16
    //   970: aastore
    //   971: dup
    //   972: bipush 6
    //   974: aload 12
    //   976: aastore
    //   977: invokevirtual 326	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   980: aload 6
    //   982: invokevirtual 214	com/tencent/mm/network/x:disconnect	()V
    //   985: aload 8
    //   987: astore 7
    //   989: goto -684 -> 305
    //   992: astore 9
    //   994: aconst_null
    //   995: astore 8
    //   997: aload 10
    //   999: astore 6
    //   1001: aload 6
    //   1003: astore 7
    //   1005: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1008: ldc_w 328
    //   1011: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1014: aload 6
    //   1016: astore 7
    //   1018: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1021: ldc 201
    //   1023: iconst_1
    //   1024: anewarray 4	java/lang/Object
    //   1027: dup
    //   1028: iconst_0
    //   1029: aload 9
    //   1031: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1034: aastore
    //   1035: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1038: aload 8
    //   1040: astore 7
    //   1042: aload 6
    //   1044: ifnull -739 -> 305
    //   1047: aload 6
    //   1049: invokevirtual 214	com/tencent/mm/network/x:disconnect	()V
    //   1052: aload 8
    //   1054: astore 7
    //   1056: goto -751 -> 305
    //   1059: astore 6
    //   1061: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1064: ldc 201
    //   1066: iconst_1
    //   1067: anewarray 4	java/lang/Object
    //   1070: dup
    //   1071: iconst_0
    //   1072: aload 6
    //   1074: invokestatic 207	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1077: aastore
    //   1078: invokestatic 211	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: goto -766 -> 315
    //   1084: astore 9
    //   1086: goto -85 -> 1001
    //   1089: astore 10
    //   1091: aconst_null
    //   1092: astore 8
    //   1094: aload 9
    //   1096: astore 6
    //   1098: goto -847 -> 251
    //   1101: iload 5
    //   1103: iconst_1
    //   1104: iadd
    //   1105: istore 5
    //   1107: goto -650 -> 457
    //   1110: astore 7
    //   1112: goto -11 -> 1101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1115	0	paramDouble1	double
    //   0	1115	2	paramDouble2	double
    //   0	1115	4	paramBoolean	boolean
    //   455	651	5	i	int
    //   52	536	6	localObject1	Object
    //   601	380	6	localObject2	Object
    //   999	49	6	localObject3	Object
    //   1059	14	6	localIOException1	java.io.IOException
    //   1096	1	6	localObject4	Object
    //   77	978	7	localObject5	Object
    //   1110	1	7	localException1	java.lang.Exception
    //   188	905	8	localInputStreamReader	java.io.InputStreamReader
    //   74	890	9	localObject6	Object
    //   992	38	9	localException2	java.lang.Exception
    //   1084	11	9	localException3	java.lang.Exception
    //   71	168	10	localObject7	Object
    //   249	146	10	localIOException2	java.io.IOException
    //   407	591	10	localObject8	Object
    //   1089	1	10	localIOException3	java.io.IOException
    //   17	725	11	localAddr	Addr
    //   8	967	12	str1	String
    //   227	717	13	localObject9	Object
    //   482	472	14	localObject10	Object
    //   812	147	15	str2	String
    //   870	99	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   194	205	249	java/io/IOException
    //   209	218	249	java/io/IOException
    //   222	229	249	java/io/IOException
    //   238	246	249	java/io/IOException
    //   360	386	249	java/io/IOException
    //   390	409	249	java/io/IOException
    //   413	421	249	java/io/IOException
    //   425	437	249	java/io/IOException
    //   441	454	249	java/io/IOException
    //   461	471	249	java/io/IOException
    //   475	484	249	java/io/IOException
    //   488	497	249	java/io/IOException
    //   501	514	249	java/io/IOException
    //   518	529	249	java/io/IOException
    //   533	540	249	java/io/IOException
    //   547	558	249	java/io/IOException
    //   562	569	249	java/io/IOException
    //   576	587	249	java/io/IOException
    //   591	598	249	java/io/IOException
    //   625	636	249	java/io/IOException
    //   640	647	249	java/io/IOException
    //   654	665	249	java/io/IOException
    //   669	676	249	java/io/IOException
    //   683	694	249	java/io/IOException
    //   698	705	249	java/io/IOException
    //   712	723	249	java/io/IOException
    //   727	734	249	java/io/IOException
    //   741	754	249	java/io/IOException
    //   758	771	249	java/io/IOException
    //   775	794	249	java/io/IOException
    //   798	814	249	java/io/IOException
    //   818	836	249	java/io/IOException
    //   840	872	249	java/io/IOException
    //   876	926	249	java/io/IOException
    //   930	980	249	java/io/IOException
    //   79	87	601	finally
    //   99	107	601	finally
    //   119	126	601	finally
    //   138	164	601	finally
    //   176	190	601	finally
    //   194	205	601	finally
    //   209	218	601	finally
    //   222	229	601	finally
    //   238	246	601	finally
    //   255	263	601	finally
    //   267	287	601	finally
    //   360	386	601	finally
    //   390	409	601	finally
    //   413	421	601	finally
    //   425	437	601	finally
    //   441	454	601	finally
    //   461	471	601	finally
    //   475	484	601	finally
    //   488	497	601	finally
    //   501	514	601	finally
    //   518	529	601	finally
    //   533	540	601	finally
    //   547	558	601	finally
    //   562	569	601	finally
    //   576	587	601	finally
    //   591	598	601	finally
    //   625	636	601	finally
    //   640	647	601	finally
    //   654	665	601	finally
    //   669	676	601	finally
    //   683	694	601	finally
    //   698	705	601	finally
    //   712	723	601	finally
    //   727	734	601	finally
    //   741	754	601	finally
    //   758	771	601	finally
    //   775	794	601	finally
    //   798	814	601	finally
    //   818	836	601	finally
    //   840	872	601	finally
    //   876	926	601	finally
    //   930	980	601	finally
    //   1005	1014	601	finally
    //   1018	1038	601	finally
    //   79	87	992	java/lang/Exception
    //   99	107	992	java/lang/Exception
    //   119	126	992	java/lang/Exception
    //   138	164	992	java/lang/Exception
    //   176	190	992	java/lang/Exception
    //   310	315	1059	java/io/IOException
    //   194	205	1084	java/lang/Exception
    //   209	218	1084	java/lang/Exception
    //   222	229	1084	java/lang/Exception
    //   238	246	1084	java/lang/Exception
    //   360	386	1084	java/lang/Exception
    //   390	409	1084	java/lang/Exception
    //   413	421	1084	java/lang/Exception
    //   425	437	1084	java/lang/Exception
    //   441	454	1084	java/lang/Exception
    //   461	471	1084	java/lang/Exception
    //   475	484	1084	java/lang/Exception
    //   741	754	1084	java/lang/Exception
    //   758	771	1084	java/lang/Exception
    //   775	794	1084	java/lang/Exception
    //   798	814	1084	java/lang/Exception
    //   818	836	1084	java/lang/Exception
    //   840	872	1084	java/lang/Exception
    //   876	926	1084	java/lang/Exception
    //   930	980	1084	java/lang/Exception
    //   79	87	1089	java/io/IOException
    //   99	107	1089	java/io/IOException
    //   119	126	1089	java/io/IOException
    //   138	164	1089	java/io/IOException
    //   176	190	1089	java/io/IOException
    //   488	497	1110	java/lang/Exception
    //   501	514	1110	java/lang/Exception
    //   518	529	1110	java/lang/Exception
    //   533	540	1110	java/lang/Exception
    //   547	558	1110	java/lang/Exception
    //   562	569	1110	java/lang/Exception
    //   576	587	1110	java/lang/Exception
    //   591	598	1110	java/lang/Exception
    //   625	636	1110	java/lang/Exception
    //   640	647	1110	java/lang/Exception
    //   654	665	1110	java/lang/Exception
    //   669	676	1110	java/lang/Exception
    //   683	694	1110	java/lang/Exception
    //   698	705	1110	java/lang/Exception
    //   712	723	1110	java/lang/Exception
    //   727	734	1110	java/lang/Exception
  }
  
  private void a(Addr paramAddr)
  {
    AppMethodBeat.i(150476);
    if (this.lLx == null)
    {
      AppMethodBeat.o(150476);
      return;
    }
    Addr localAddr = paramAddr;
    if (paramAddr == null) {
      localAddr = new Addr();
    }
    if (this.lLx.tag == null) {}
    for (paramAddr = new Object();; paramAddr = this.lLx.tag)
    {
      localAddr.tag = paramAddr;
      localAddr.lLr = ((float)this.lLx.lat);
      localAddr.lLs = ((float)this.lLx.lng);
      paramAddr = (CopyOnWriteArrayList)this.bqq.get(this.lLx.toString());
      if (paramAddr == null) {
        break;
      }
      paramAddr = paramAddr.iterator();
      while (paramAddr.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)paramAddr.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((a)localWeakReference.get()).b(localAddr);
        }
      }
    }
    this.bqq.remove(this.lLx.toString());
    Log.d(TAG, "postexecute2 listeners %d", new Object[] { Integer.valueOf(this.bqq.size()) });
    this.lLx = null;
    blo();
    if ((this.lLx == null) && (this.lLy.size() > 0))
    {
      h.aGY().b(655, this);
      h.aGY().b(4005, this);
    }
    AppMethodBeat.o(150476);
  }
  
  private static boolean a(CopyOnWriteArrayList<WeakReference<a>> paramCopyOnWriteArrayList, a parama)
  {
    AppMethodBeat.i(150470);
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramCopyOnWriteArrayList.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(150470);
        return true;
      }
    }
    AppMethodBeat.o(150470);
    return false;
  }
  
  private static boolean b(CopyOnWriteArrayList<WeakReference<a>> paramCopyOnWriteArrayList, a parama)
  {
    AppMethodBeat.i(150471);
    if (paramCopyOnWriteArrayList == null)
    {
      AppMethodBeat.o(150471);
      return false;
    }
    Iterator localIterator = paramCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        paramCopyOnWriteArrayList.remove(localWeakReference);
        AppMethodBeat.o(150471);
        return true;
      }
    }
    AppMethodBeat.o(150471);
    return false;
  }
  
  public static c bln()
  {
    AppMethodBeat.i(150468);
    if (lLv == null) {
      lLv = new c();
    }
    c localc = lLv;
    AppMethodBeat.o(150468);
    return localc;
  }
  
  private void blo()
  {
    AppMethodBeat.i(150474);
    if ((this.lLx == null) && (this.lLy != null) && (this.lLy.size() > 0))
    {
      this.lLx = ((c)this.lLy.remove(0));
      blp();
    }
    AppMethodBeat.o(150474);
  }
  
  private void blp()
  {
    AppMethodBeat.i(150475);
    if (Util.isOverseasUser(MMApplicationContext.getContext()))
    {
      this.lLz.add(new b());
      AppMethodBeat.o(150475);
      return;
    }
    h.aGY().a(655, this);
    h.aGY().a(4005, this);
    if (this.lLx.lLD)
    {
      h.aGY().a(new f(this.lLx.lat, this.lLx.lng), 0);
      AppMethodBeat.o(150475);
      return;
    }
    h.aGY().a(new e(this.lLx.lat, this.lLx.lng), 0);
    AppMethodBeat.o(150475);
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, a parama)
  {
    AppMethodBeat.i(150473);
    boolean bool = a(paramDouble1, paramDouble2, parama, null);
    AppMethodBeat.o(150473);
    return bool;
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, a parama, Object paramObject)
  {
    AppMethodBeat.i(150472);
    boolean bool = a(paramDouble1, paramDouble2, parama, paramObject, false);
    AppMethodBeat.o(150472);
    return bool;
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, a parama, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(194437);
    if (paramObject != null)
    {
      localObject = this.lLy.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        if ((localc != null) && (localc.tag != null) && (localc.tag.equals(paramObject))) {
          this.lLy.remove(localc);
        }
      }
    }
    c localc = new c(paramDouble1, paramDouble2, paramObject, paramBoolean);
    Object localObject = (CopyOnWriteArrayList)this.bqq.get(localc.toString());
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new CopyOnWriteArrayList();
    }
    if (!a(paramObject, parama)) {
      paramObject.add(new WeakReference(parama));
    }
    this.bqq.put(localc.toString(), paramObject);
    parama = this.lLy.iterator();
    while (parama.hasNext()) {
      if (((c)parama.next()).equals(localc))
      {
        blo();
        AppMethodBeat.o(194437);
        return false;
      }
    }
    if ((this.lLx != null) && (localc.equals(this.lLx)))
    {
      AppMethodBeat.o(194437);
      return false;
    }
    this.lLy.add(localc);
    Log.i(TAG, "push task size %d listeners %d", new Object[] { Integer.valueOf(this.lLy.size()), Integer.valueOf(this.bqq.size()) });
    while (this.lLy.size() > 30)
    {
      Log.i(TAG, "force remove task");
      parama = (c)this.lLy.remove(0);
      if (parama != null) {
        this.bqq.remove(parama.toString());
      }
    }
    blo();
    AppMethodBeat.o(194437);
    return true;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150469);
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    Object localObject3 = this.bqq.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.bqq.get(str);
      b(localCopyOnWriteArrayList, parama);
      this.bqq.put(str, localCopyOnWriteArrayList);
      if ((localCopyOnWriteArrayList == null) || (localCopyOnWriteArrayList.size() == 0)) {
        ((LinkedList)localObject2).add(str);
      }
    }
    parama = ((LinkedList)localObject2).iterator();
    while (parama.hasNext())
    {
      localObject2 = (String)parama.next();
      this.bqq.remove(localObject2);
    }
    parama = this.lLy.iterator();
    while (parama.hasNext())
    {
      localObject2 = (c)parama.next();
      localObject3 = (CopyOnWriteArrayList)this.bqq.get(((c)localObject2).toString());
      if ((localObject3 == null) || (((CopyOnWriteArrayList)localObject3).size() == 0))
      {
        ((LinkedList)localObject1).add(localObject2);
        this.bqq.remove(((c)localObject2).toString());
      }
    }
    parama = ((LinkedList)localObject1).iterator();
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.lLy.remove(localObject1);
    }
    Log.i(TAG, "remove taskLists %d listeners size %d", new Object[] { Integer.valueOf(this.lLy.size()), Integer.valueOf(this.bqq.size()) });
    AppMethodBeat.o(150469);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150478);
    paramString = null;
    if (paramq.getType() == 4005) {
      paramString = ((f)paramq).blt();
    }
    while ((paramString == null) || (paramString.lLg == null) || (paramString.lLg.equals("")))
    {
      this.lLz.add(new b());
      AppMethodBeat.o(150478);
      return;
      if (paramq.getType() == 655) {
        paramString = ((e)paramq).blt();
      }
    }
    a(paramString);
    AppMethodBeat.o(150478);
  }
  
  public static abstract interface a
  {
    public abstract void b(Addr paramAddr);
  }
  
  final class b
    implements QueueWorkerThread.ThreadObject
  {
    private Addr lLB = null;
    
    public b() {}
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150463);
      if (c.a(c.this) == null)
      {
        AppMethodBeat.o(150463);
        return false;
      }
      if ((this.lLB == null) || (this.lLB.lLg == null) || (this.lLB.lLg.equals(""))) {
        this.lLB = c.b(c.a(c.this).lat, c.a(c.this).lng, c.b(c.this));
      }
      AppMethodBeat.o(150463);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150464);
      c.c(c.this);
      c.a(c.this, this.lLB);
      AppMethodBeat.o(150464);
      return true;
    }
  }
  
  final class c
  {
    boolean lLD;
    double lat;
    double lng;
    Object tag = "";
    
    public c(double paramDouble1, double paramDouble2, Object paramObject, boolean paramBoolean)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.tag = paramObject;
      this.lLD = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(150466);
      if ((paramObject == null) || (!(paramObject instanceof c)))
      {
        AppMethodBeat.o(150466);
        return false;
      }
      boolean bool = ((c)paramObject).toString().equals(toString());
      AppMethodBeat.o(150466);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(150465);
      StringBuilder localStringBuilder = new StringBuilder().append((int)(this.lat * 1000000.0D)).append((int)(this.lng * 1000000.0D));
      String str;
      if (this.tag == null) {
        str = "";
      }
      for (;;)
      {
        str = str;
        AppMethodBeat.o(150465);
        return str;
        if (((this.tag instanceof Integer)) || ((this.tag instanceof Long)) || ((this.tag instanceof Double)) || ((this.tag instanceof Float)) || ((this.tag instanceof String))) {
          str = this.tag;
        } else {
          str = this.tag.toString();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c
 * JD-Core Version:    0.7.0.1
 */