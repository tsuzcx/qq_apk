package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
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
  private static c iVc;
  private static final String iVd;
  private HashMap<String, CopyOnWriteArrayList<WeakReference<a>>> bGH;
  private c iVe;
  private CopyOnWriteArrayList<c> iVf;
  private QueueWorkerThread iVg;
  private boolean iVh;
  
  static
  {
    AppMethodBeat.i(223568);
    TAG = "MicroMsg.LocationAddr";
    iVd = "http://" + WeChatHosts.domainString(2131761716) + "/rgeoc?lnglat=%f,%f";
    AppMethodBeat.o(223568);
  }
  
  private c()
  {
    AppMethodBeat.i(150467);
    this.iVe = null;
    this.iVf = new CopyOnWriteArrayList();
    this.bGH = new HashMap();
    this.iVg = new QueueWorkerThread(1, "addr_worker");
    this.iVh = true;
    AppMethodBeat.o(150467);
  }
  
  /* Error */
  private static Addr a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 113	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   8: astore 12
    //   10: new 115	com/tencent/mm/modelgeo/Addr
    //   13: dup
    //   14: invokespecial 116	com/tencent/mm/modelgeo/Addr:<init>	()V
    //   17: astore 11
    //   19: iload 4
    //   21: ifeq +302 -> 323
    //   24: ldc 118
    //   26: iconst_3
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: dload_0
    //   33: invokestatic 124	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: dload_2
    //   40: invokestatic 124	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: aload 12
    //   48: aastore
    //   49: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 6
    //   54: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   57: ldc 132
    //   59: aload 6
    //   61: invokestatic 135	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: astore 10
    //   73: aconst_null
    //   74: astore 9
    //   76: aconst_null
    //   77: astore 7
    //   79: aload 6
    //   81: aconst_null
    //   82: invokestatic 150	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 7
    //   91: aload 6
    //   93: astore 10
    //   95: aload 6
    //   97: astore 9
    //   99: aload 6
    //   101: sipush 10000
    //   104: invokevirtual 155	com/tencent/mm/network/x:setConnectTimeout	(I)V
    //   107: aload 6
    //   109: astore 7
    //   111: aload 6
    //   113: astore 10
    //   115: aload 6
    //   117: astore 9
    //   119: aload 6
    //   121: ldc 157
    //   123: invokevirtual 160	com/tencent/mm/network/x:setRequestMethod	(Ljava/lang/String;)V
    //   126: aload 6
    //   128: astore 7
    //   130: aload 6
    //   132: astore 10
    //   134: aload 6
    //   136: astore 9
    //   138: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   141: new 47	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 162
    //   147: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 6
    //   152: invokevirtual 166	com/tencent/mm/network/x:getResponseCode	()I
    //   155: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 6
    //   166: astore 7
    //   168: aload 6
    //   170: astore 10
    //   172: aload 6
    //   174: astore 9
    //   176: new 171	java/io/InputStreamReader
    //   179: dup
    //   180: aload 6
    //   182: invokevirtual 175	com/tencent/mm/network/x:getInputStream	()Ljava/io/InputStream;
    //   185: invokespecial 178	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   188: astore 8
    //   190: aload 6
    //   192: astore 7
    //   194: new 180	java/io/BufferedReader
    //   197: dup
    //   198: aload 8
    //   200: invokespecial 183	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   203: astore 9
    //   205: aload 6
    //   207: astore 7
    //   209: new 185	java/lang/StringBuffer
    //   212: dup
    //   213: invokespecial 186	java/lang/StringBuffer:<init>	()V
    //   216: astore 10
    //   218: aload 6
    //   220: astore 7
    //   222: aload 9
    //   224: invokevirtual 189	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   227: astore 13
    //   229: aload 13
    //   231: ifnull +125 -> 356
    //   234: aload 6
    //   236: astore 7
    //   238: aload 10
    //   240: aload 13
    //   242: invokevirtual 192	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: goto -28 -> 218
    //   249: astore 10
    //   251: aload 6
    //   253: astore 7
    //   255: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   258: ldc 194
    //   260: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 6
    //   265: astore 7
    //   267: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   270: ldc 196
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 10
    //   280: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   283: aastore
    //   284: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 8
    //   289: astore 7
    //   291: aload 6
    //   293: ifnull +12 -> 305
    //   296: aload 6
    //   298: invokevirtual 209	com/tencent/mm/network/x:disconnect	()V
    //   301: aload 8
    //   303: astore 7
    //   305: aload 7
    //   307: ifnull +8 -> 315
    //   310: aload 7
    //   312: invokevirtual 212	java/io/InputStreamReader:close	()V
    //   315: ldc 108
    //   317: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 11
    //   322: areturn
    //   323: ldc 118
    //   325: iconst_3
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: dload_0
    //   332: invokestatic 124	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: dload_2
    //   339: invokestatic 124	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   342: aastore
    //   343: dup
    //   344: iconst_2
    //   345: ldc 214
    //   347: aastore
    //   348: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   351: astore 6
    //   353: goto -299 -> 54
    //   356: aload 6
    //   358: astore 7
    //   360: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   363: new 47	java/lang/StringBuilder
    //   366: dup
    //   367: ldc 216
    //   369: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   372: aload 10
    //   374: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   377: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 6
    //   388: astore 7
    //   390: new 219	org/json/JSONObject
    //   393: dup
    //   394: aload 10
    //   396: invokevirtual 217	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   399: invokespecial 220	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   402: ldc 222
    //   404: invokevirtual 226	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   407: astore 10
    //   409: aload 6
    //   411: astore 7
    //   413: aload 10
    //   415: iconst_0
    //   416: invokevirtual 232	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   419: astore 9
    //   421: aload 6
    //   423: astore 7
    //   425: aload 11
    //   427: aload 9
    //   429: ldc 234
    //   431: invokevirtual 237	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: putfield 240	com/tencent/mm/modelgeo/Addr:iUO	Ljava/lang/String;
    //   437: aload 6
    //   439: astore 7
    //   441: aload 10
    //   443: iconst_0
    //   444: invokevirtual 232	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   447: ldc 242
    //   449: invokevirtual 226	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   452: astore 13
    //   454: iconst_0
    //   455: istore 5
    //   457: aload 6
    //   459: astore 7
    //   461: iload 5
    //   463: aload 13
    //   465: invokevirtual 245	org/json/JSONArray:length	()I
    //   468: if_icmpge +268 -> 736
    //   471: aload 6
    //   473: astore 7
    //   475: aload 13
    //   477: iload 5
    //   479: invokevirtual 232	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   482: astore 14
    //   484: aload 6
    //   486: astore 7
    //   488: aload 14
    //   490: ldc 247
    //   492: invokevirtual 237	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   495: astore 10
    //   497: aload 6
    //   499: astore 7
    //   501: aload 14
    //   503: ldc 249
    //   505: invokevirtual 226	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   508: iconst_0
    //   509: invokevirtual 251	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   512: astore 14
    //   514: aload 6
    //   516: astore 7
    //   518: aload 14
    //   520: ldc 253
    //   522: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   525: ifeq +17 -> 542
    //   528: aload 6
    //   530: astore 7
    //   532: aload 11
    //   534: aload 10
    //   536: putfield 260	com/tencent/mm/modelgeo/Addr:iUP	Ljava/lang/String;
    //   539: goto +561 -> 1100
    //   542: aload 6
    //   544: astore 7
    //   546: aload 14
    //   548: ldc_w 262
    //   551: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   554: ifeq +17 -> 571
    //   557: aload 6
    //   559: astore 7
    //   561: aload 11
    //   563: aload 10
    //   565: putfield 265	com/tencent/mm/modelgeo/Addr:iUQ	Ljava/lang/String;
    //   568: goto +532 -> 1100
    //   571: aload 6
    //   573: astore 7
    //   575: aload 14
    //   577: ldc_w 267
    //   580: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   583: ifeq +37 -> 620
    //   586: aload 6
    //   588: astore 7
    //   590: aload 11
    //   592: aload 10
    //   594: putfield 270	com/tencent/mm/modelgeo/Addr:iUS	Ljava/lang/String;
    //   597: goto +503 -> 1100
    //   600: astore 6
    //   602: aload 7
    //   604: ifnull +8 -> 612
    //   607: aload 7
    //   609: invokevirtual 209	com/tencent/mm/network/x:disconnect	()V
    //   612: ldc 108
    //   614: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   617: aload 6
    //   619: athrow
    //   620: aload 6
    //   622: astore 7
    //   624: aload 14
    //   626: ldc_w 272
    //   629: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   632: ifeq +17 -> 649
    //   635: aload 6
    //   637: astore 7
    //   639: aload 11
    //   641: aload 10
    //   643: putfield 275	com/tencent/mm/modelgeo/Addr:iUT	Ljava/lang/String;
    //   646: goto +454 -> 1100
    //   649: aload 6
    //   651: astore 7
    //   653: aload 14
    //   655: ldc_w 277
    //   658: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   661: ifeq +17 -> 678
    //   664: aload 6
    //   666: astore 7
    //   668: aload 11
    //   670: aload 10
    //   672: putfield 280	com/tencent/mm/modelgeo/Addr:iUU	Ljava/lang/String;
    //   675: goto +425 -> 1100
    //   678: aload 6
    //   680: astore 7
    //   682: aload 14
    //   684: ldc_w 282
    //   687: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   690: ifeq +17 -> 707
    //   693: aload 6
    //   695: astore 7
    //   697: aload 11
    //   699: aload 10
    //   701: putfield 285	com/tencent/mm/modelgeo/Addr:iUV	Ljava/lang/String;
    //   704: goto +396 -> 1100
    //   707: aload 6
    //   709: astore 7
    //   711: aload 14
    //   713: ldc_w 287
    //   716: invokevirtual 257	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   719: ifeq +381 -> 1100
    //   722: aload 6
    //   724: astore 7
    //   726: aload 11
    //   728: aload 10
    //   730: putfield 289	com/tencent/mm/modelgeo/Addr:country	Ljava/lang/String;
    //   733: goto +367 -> 1100
    //   736: aload 6
    //   738: astore 7
    //   740: aload 11
    //   742: getfield 240	com/tencent/mm/modelgeo/Addr:iUO	Ljava/lang/String;
    //   745: ldc_w 291
    //   748: invokestatic 297	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   751: astore 10
    //   753: aload 6
    //   755: astore 7
    //   757: aload 13
    //   759: invokevirtual 298	org/json/JSONArray:toString	()Ljava/lang/String;
    //   762: ldc_w 291
    //   765: invokestatic 297	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   768: astore 13
    //   770: aload 6
    //   772: astore 7
    //   774: aload 9
    //   776: ldc_w 300
    //   779: invokevirtual 303	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   782: invokevirtual 304	org/json/JSONObject:toString	()Ljava/lang/String;
    //   785: ldc_w 291
    //   788: invokestatic 297	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   791: astore 14
    //   793: aload 6
    //   795: astore 7
    //   797: aload 9
    //   799: ldc_w 306
    //   802: invokevirtual 237	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   805: ldc_w 291
    //   808: invokestatic 297	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   811: astore 15
    //   813: aload 6
    //   815: astore 7
    //   817: aload 9
    //   819: ldc 249
    //   821: invokevirtual 226	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   824: invokevirtual 298	org/json/JSONArray:toString	()Ljava/lang/String;
    //   827: ldc_w 291
    //   830: invokestatic 297	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   833: astore 9
    //   835: aload 6
    //   837: astore 7
    //   839: ldc_w 308
    //   842: iconst_2
    //   843: anewarray 4	java/lang/Object
    //   846: dup
    //   847: iconst_0
    //   848: dload_0
    //   849: invokestatic 124	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: dload_2
    //   856: invokestatic 124	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   859: aastore
    //   860: invokestatic 130	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   863: ldc_w 291
    //   866: invokestatic 297	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   869: astore 16
    //   871: aload 6
    //   873: astore 7
    //   875: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   878: ldc_w 310
    //   881: bipush 7
    //   883: anewarray 4	java/lang/Object
    //   886: dup
    //   887: iconst_0
    //   888: aload 10
    //   890: aastore
    //   891: dup
    //   892: iconst_1
    //   893: aload 13
    //   895: aastore
    //   896: dup
    //   897: iconst_2
    //   898: aload 14
    //   900: aastore
    //   901: dup
    //   902: iconst_3
    //   903: aload 15
    //   905: aastore
    //   906: dup
    //   907: iconst_4
    //   908: aload 9
    //   910: aastore
    //   911: dup
    //   912: iconst_5
    //   913: aload 16
    //   915: aastore
    //   916: dup
    //   917: bipush 6
    //   919: aload 12
    //   921: aastore
    //   922: invokestatic 312	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   925: aload 6
    //   927: astore 7
    //   929: getstatic 318	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   932: sipush 12886
    //   935: bipush 7
    //   937: anewarray 4	java/lang/Object
    //   940: dup
    //   941: iconst_0
    //   942: aload 13
    //   944: aastore
    //   945: dup
    //   946: iconst_1
    //   947: aload 10
    //   949: aastore
    //   950: dup
    //   951: iconst_2
    //   952: aload 14
    //   954: aastore
    //   955: dup
    //   956: iconst_3
    //   957: aload 15
    //   959: aastore
    //   960: dup
    //   961: iconst_4
    //   962: aload 9
    //   964: aastore
    //   965: dup
    //   966: iconst_5
    //   967: aload 16
    //   969: aastore
    //   970: dup
    //   971: bipush 6
    //   973: aload 12
    //   975: aastore
    //   976: invokevirtual 321	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   979: aload 6
    //   981: invokevirtual 209	com/tencent/mm/network/x:disconnect	()V
    //   984: aload 8
    //   986: astore 7
    //   988: goto -683 -> 305
    //   991: astore 9
    //   993: aconst_null
    //   994: astore 8
    //   996: aload 10
    //   998: astore 6
    //   1000: aload 6
    //   1002: astore 7
    //   1004: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1007: ldc_w 323
    //   1010: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1013: aload 6
    //   1015: astore 7
    //   1017: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1020: ldc 196
    //   1022: iconst_1
    //   1023: anewarray 4	java/lang/Object
    //   1026: dup
    //   1027: iconst_0
    //   1028: aload 9
    //   1030: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1033: aastore
    //   1034: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1037: aload 8
    //   1039: astore 7
    //   1041: aload 6
    //   1043: ifnull -738 -> 305
    //   1046: aload 6
    //   1048: invokevirtual 209	com/tencent/mm/network/x:disconnect	()V
    //   1051: aload 8
    //   1053: astore 7
    //   1055: goto -750 -> 305
    //   1058: astore 6
    //   1060: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1063: ldc 196
    //   1065: iconst_1
    //   1066: anewarray 4	java/lang/Object
    //   1069: dup
    //   1070: iconst_0
    //   1071: aload 6
    //   1073: invokestatic 202	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1076: aastore
    //   1077: invokestatic 206	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1080: goto -765 -> 315
    //   1083: astore 9
    //   1085: goto -85 -> 1000
    //   1088: astore 10
    //   1090: aconst_null
    //   1091: astore 8
    //   1093: aload 9
    //   1095: astore 6
    //   1097: goto -846 -> 251
    //   1100: iload 5
    //   1102: iconst_1
    //   1103: iadd
    //   1104: istore 5
    //   1106: goto -649 -> 457
    //   1109: astore 7
    //   1111: goto -11 -> 1100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1114	0	paramDouble1	double
    //   0	1114	2	paramDouble2	double
    //   0	1114	4	paramBoolean	boolean
    //   455	650	5	i	int
    //   52	535	6	localObject1	Object
    //   600	380	6	localObject2	Object
    //   998	49	6	localObject3	Object
    //   1058	14	6	localIOException1	java.io.IOException
    //   1095	1	6	localObject4	Object
    //   77	977	7	localObject5	Object
    //   1109	1	7	localException1	java.lang.Exception
    //   188	904	8	localInputStreamReader	java.io.InputStreamReader
    //   74	889	9	localObject6	Object
    //   991	38	9	localException2	java.lang.Exception
    //   1083	11	9	localException3	java.lang.Exception
    //   71	168	10	localObject7	Object
    //   249	146	10	localIOException2	java.io.IOException
    //   407	590	10	localObject8	Object
    //   1088	1	10	localIOException3	java.io.IOException
    //   17	724	11	localAddr	Addr
    //   8	966	12	str1	String
    //   227	716	13	localObject9	Object
    //   482	471	14	localObject10	Object
    //   811	147	15	str2	String
    //   869	99	16	str3	String
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
    //   518	528	249	java/io/IOException
    //   532	539	249	java/io/IOException
    //   546	557	249	java/io/IOException
    //   561	568	249	java/io/IOException
    //   575	586	249	java/io/IOException
    //   590	597	249	java/io/IOException
    //   624	635	249	java/io/IOException
    //   639	646	249	java/io/IOException
    //   653	664	249	java/io/IOException
    //   668	675	249	java/io/IOException
    //   682	693	249	java/io/IOException
    //   697	704	249	java/io/IOException
    //   711	722	249	java/io/IOException
    //   726	733	249	java/io/IOException
    //   740	753	249	java/io/IOException
    //   757	770	249	java/io/IOException
    //   774	793	249	java/io/IOException
    //   797	813	249	java/io/IOException
    //   817	835	249	java/io/IOException
    //   839	871	249	java/io/IOException
    //   875	925	249	java/io/IOException
    //   929	979	249	java/io/IOException
    //   79	87	600	finally
    //   99	107	600	finally
    //   119	126	600	finally
    //   138	164	600	finally
    //   176	190	600	finally
    //   194	205	600	finally
    //   209	218	600	finally
    //   222	229	600	finally
    //   238	246	600	finally
    //   255	263	600	finally
    //   267	287	600	finally
    //   360	386	600	finally
    //   390	409	600	finally
    //   413	421	600	finally
    //   425	437	600	finally
    //   441	454	600	finally
    //   461	471	600	finally
    //   475	484	600	finally
    //   488	497	600	finally
    //   501	514	600	finally
    //   518	528	600	finally
    //   532	539	600	finally
    //   546	557	600	finally
    //   561	568	600	finally
    //   575	586	600	finally
    //   590	597	600	finally
    //   624	635	600	finally
    //   639	646	600	finally
    //   653	664	600	finally
    //   668	675	600	finally
    //   682	693	600	finally
    //   697	704	600	finally
    //   711	722	600	finally
    //   726	733	600	finally
    //   740	753	600	finally
    //   757	770	600	finally
    //   774	793	600	finally
    //   797	813	600	finally
    //   817	835	600	finally
    //   839	871	600	finally
    //   875	925	600	finally
    //   929	979	600	finally
    //   1004	1013	600	finally
    //   1017	1037	600	finally
    //   79	87	991	java/lang/Exception
    //   99	107	991	java/lang/Exception
    //   119	126	991	java/lang/Exception
    //   138	164	991	java/lang/Exception
    //   176	190	991	java/lang/Exception
    //   310	315	1058	java/io/IOException
    //   194	205	1083	java/lang/Exception
    //   209	218	1083	java/lang/Exception
    //   222	229	1083	java/lang/Exception
    //   238	246	1083	java/lang/Exception
    //   360	386	1083	java/lang/Exception
    //   390	409	1083	java/lang/Exception
    //   413	421	1083	java/lang/Exception
    //   425	437	1083	java/lang/Exception
    //   441	454	1083	java/lang/Exception
    //   461	471	1083	java/lang/Exception
    //   475	484	1083	java/lang/Exception
    //   740	753	1083	java/lang/Exception
    //   757	770	1083	java/lang/Exception
    //   774	793	1083	java/lang/Exception
    //   797	813	1083	java/lang/Exception
    //   817	835	1083	java/lang/Exception
    //   839	871	1083	java/lang/Exception
    //   875	925	1083	java/lang/Exception
    //   929	979	1083	java/lang/Exception
    //   79	87	1088	java/io/IOException
    //   99	107	1088	java/io/IOException
    //   119	126	1088	java/io/IOException
    //   138	164	1088	java/io/IOException
    //   176	190	1088	java/io/IOException
    //   488	497	1109	java/lang/Exception
    //   501	514	1109	java/lang/Exception
    //   518	528	1109	java/lang/Exception
    //   532	539	1109	java/lang/Exception
    //   546	557	1109	java/lang/Exception
    //   561	568	1109	java/lang/Exception
    //   575	586	1109	java/lang/Exception
    //   590	597	1109	java/lang/Exception
    //   624	635	1109	java/lang/Exception
    //   639	646	1109	java/lang/Exception
    //   653	664	1109	java/lang/Exception
    //   668	675	1109	java/lang/Exception
    //   682	693	1109	java/lang/Exception
    //   697	704	1109	java/lang/Exception
    //   711	722	1109	java/lang/Exception
    //   726	733	1109	java/lang/Exception
  }
  
  private void a(Addr paramAddr)
  {
    AppMethodBeat.i(150476);
    if (this.iVe == null)
    {
      AppMethodBeat.o(150476);
      return;
    }
    Addr localAddr = paramAddr;
    if (paramAddr == null) {
      localAddr = new Addr();
    }
    if (this.iVe.tag == null) {}
    for (paramAddr = new Object();; paramAddr = this.iVe.tag)
    {
      localAddr.tag = paramAddr;
      localAddr.iUY = ((float)this.iVe.lat);
      localAddr.iUZ = ((float)this.iVe.lng);
      paramAddr = (CopyOnWriteArrayList)this.bGH.get(this.iVe.toString());
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
    this.bGH.remove(this.iVe.toString());
    Log.d(TAG, "postexecute2 listeners %d", new Object[] { Integer.valueOf(this.bGH.size()) });
    this.iVe = null;
    bbY();
    if ((this.iVe == null) && (this.iVf.size() > 0)) {
      g.azz().b(655, this);
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
  
  public static c bbX()
  {
    AppMethodBeat.i(150468);
    if (iVc == null) {
      iVc = new c();
    }
    c localc = iVc;
    AppMethodBeat.o(150468);
    return localc;
  }
  
  private void bbY()
  {
    AppMethodBeat.i(150474);
    if ((this.iVe == null) && (this.iVf != null) && (this.iVf.size() > 0))
    {
      this.iVe = ((c)this.iVf.remove(0));
      bbZ();
    }
    AppMethodBeat.o(150474);
  }
  
  private void bbZ()
  {
    AppMethodBeat.i(150475);
    if (Util.isOverseasUser(MMApplicationContext.getContext()))
    {
      this.iVg.add(new b());
      AppMethodBeat.o(150475);
      return;
    }
    g.azz().a(655, this);
    g.azz().a(new e(this.iVe.lat, this.iVe.lng), 0);
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
    if (paramObject != null)
    {
      localObject = this.iVf.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        if ((localc != null) && (localc.tag != null) && (localc.tag.equals(paramObject))) {
          this.iVf.remove(localc);
        }
      }
    }
    c localc = new c(paramDouble1, paramDouble2, paramObject);
    Object localObject = (CopyOnWriteArrayList)this.bGH.get(localc.toString());
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new CopyOnWriteArrayList();
    }
    if (!a(paramObject, parama)) {
      paramObject.add(new WeakReference(parama));
    }
    this.bGH.put(localc.toString(), paramObject);
    parama = this.iVf.iterator();
    while (parama.hasNext()) {
      if (((c)parama.next()).equals(localc))
      {
        bbY();
        AppMethodBeat.o(150472);
        return false;
      }
    }
    if ((this.iVe != null) && (localc.equals(this.iVe)))
    {
      AppMethodBeat.o(150472);
      return false;
    }
    this.iVf.add(localc);
    Log.i(TAG, "push task size %d listeners %d", new Object[] { Integer.valueOf(this.iVf.size()), Integer.valueOf(this.bGH.size()) });
    while (this.iVf.size() > 30)
    {
      Log.i(TAG, "force remove task");
      parama = (c)this.iVf.remove(0);
      if (parama != null) {
        this.bGH.remove(parama.toString());
      }
    }
    bbY();
    AppMethodBeat.o(150472);
    return true;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150469);
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    Object localObject3 = this.bGH.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.bGH.get(str);
      b(localCopyOnWriteArrayList, parama);
      this.bGH.put(str, localCopyOnWriteArrayList);
      if ((localCopyOnWriteArrayList == null) || (localCopyOnWriteArrayList.size() == 0)) {
        ((LinkedList)localObject2).add(str);
      }
    }
    parama = ((LinkedList)localObject2).iterator();
    while (parama.hasNext())
    {
      localObject2 = (String)parama.next();
      this.bGH.remove(localObject2);
    }
    parama = this.iVf.iterator();
    while (parama.hasNext())
    {
      localObject2 = (c)parama.next();
      localObject3 = (CopyOnWriteArrayList)this.bGH.get(((c)localObject2).toString());
      if ((localObject3 == null) || (((CopyOnWriteArrayList)localObject3).size() == 0))
      {
        ((LinkedList)localObject1).add(localObject2);
        this.bGH.remove(((c)localObject2).toString());
      }
    }
    parama = ((LinkedList)localObject1).iterator();
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.iVf.remove(localObject1);
    }
    Log.i(TAG, "remove taskLists %d listeners size %d", new Object[] { Integer.valueOf(this.iVf.size()), Integer.valueOf(this.bGH.size()) });
    AppMethodBeat.o(150469);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150478);
    if (paramq.getType() == 655)
    {
      paramString = ((e)paramq).bce();
      if ((paramString == null) || (paramString.iUO == null) || (paramString.iUO.equals("")))
      {
        this.iVg.add(new b());
        AppMethodBeat.o(150478);
        return;
      }
      a(paramString);
    }
    AppMethodBeat.o(150478);
  }
  
  public static abstract interface a
  {
    public abstract void b(Addr paramAddr);
  }
  
  final class b
    implements QueueWorkerThread.ThreadObject
  {
    private Addr iVi = null;
    
    public b() {}
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150463);
      if (c.a(c.this) == null)
      {
        AppMethodBeat.o(150463);
        return false;
      }
      if ((this.iVi == null) || (this.iVi.iUO == null) || (this.iVi.iUO.equals(""))) {
        this.iVi = c.b(c.a(c.this).lat, c.a(c.this).lng, c.b(c.this));
      }
      AppMethodBeat.o(150463);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150464);
      c.c(c.this);
      c.a(c.this, this.iVi);
      AppMethodBeat.o(150464);
      return true;
    }
  }
  
  final class c
  {
    double lat;
    double lng;
    Object tag = "";
    
    public c(double paramDouble1, double paramDouble2, Object paramObject)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.tag = paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c
 * JD-Core Version:    0.7.0.1
 */