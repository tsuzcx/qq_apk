package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c
  implements com.tencent.mm.al.g
{
  public static String TAG = "MicroMsg.LocationAddr";
  private static c hef;
  private HashMap<String, CopyOnWriteArrayList<WeakReference<a>>> byu;
  private c heg;
  private CopyOnWriteArrayList<c> heh;
  private be hei;
  private boolean hej;
  
  private c()
  {
    AppMethodBeat.i(150467);
    this.heg = null;
    this.heh = new CopyOnWriteArrayList();
    this.byu = new HashMap();
    this.hei = new be(1, "addr_worker");
    this.hej = true;
    AppMethodBeat.o(150467);
  }
  
  /* Error */
  private static Addr a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 86	com/tencent/mm/sdk/platformtools/ac:eFu	()Ljava/lang/String;
    //   8: astore 12
    //   10: new 88	com/tencent/mm/modelgeo/Addr
    //   13: dup
    //   14: invokespecial 89	com/tencent/mm/modelgeo/Addr:<init>	()V
    //   17: astore 11
    //   19: iload 4
    //   21: ifeq +302 -> 323
    //   24: ldc 91
    //   26: iconst_3
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: dload_0
    //   33: invokestatic 97	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: dload_2
    //   40: invokestatic 97	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: aload 12
    //   48: aastore
    //   49: invokestatic 103	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 6
    //   54: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   57: ldc 105
    //   59: aload 6
    //   61: invokestatic 108	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual 112	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: astore 10
    //   73: aconst_null
    //   74: astore 9
    //   76: aconst_null
    //   77: astore 7
    //   79: aload 6
    //   81: aconst_null
    //   82: invokestatic 123	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 7
    //   91: aload 6
    //   93: astore 10
    //   95: aload 6
    //   97: astore 9
    //   99: aload 6
    //   101: sipush 10000
    //   104: invokevirtual 128	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   107: aload 6
    //   109: astore 7
    //   111: aload 6
    //   113: astore 10
    //   115: aload 6
    //   117: astore 9
    //   119: aload 6
    //   121: ldc 130
    //   123: invokevirtual 134	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   126: aload 6
    //   128: astore 7
    //   130: aload 6
    //   132: astore 10
    //   134: aload 6
    //   136: astore 9
    //   138: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   141: new 136	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 138
    //   147: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 6
    //   152: invokevirtual 144	com/tencent/mm/network/v:getResponseCode	()I
    //   155: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload 6
    //   166: astore 7
    //   168: aload 6
    //   170: astore 10
    //   172: aload 6
    //   174: astore 9
    //   176: new 153	java/io/InputStreamReader
    //   179: dup
    //   180: aload 6
    //   182: invokevirtual 157	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   185: invokespecial 160	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   188: astore 8
    //   190: aload 6
    //   192: astore 7
    //   194: new 162	java/io/BufferedReader
    //   197: dup
    //   198: aload 8
    //   200: invokespecial 165	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   203: astore 9
    //   205: aload 6
    //   207: astore 7
    //   209: new 167	java/lang/StringBuffer
    //   212: dup
    //   213: invokespecial 168	java/lang/StringBuffer:<init>	()V
    //   216: astore 10
    //   218: aload 6
    //   220: astore 7
    //   222: aload 9
    //   224: invokevirtual 171	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   227: astore 13
    //   229: aload 13
    //   231: ifnull +125 -> 356
    //   234: aload 6
    //   236: astore 7
    //   238: aload 10
    //   240: aload 13
    //   242: invokevirtual 174	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: goto -28 -> 218
    //   249: astore 10
    //   251: aload 6
    //   253: astore 7
    //   255: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   258: ldc 176
    //   260: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 6
    //   265: astore 7
    //   267: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   270: ldc 178
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload 10
    //   280: invokestatic 184	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   283: aastore
    //   284: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload 8
    //   289: astore 7
    //   291: aload 6
    //   293: ifnull +12 -> 305
    //   296: aload 6
    //   298: invokevirtual 191	com/tencent/mm/network/v:disconnect	()V
    //   301: aload 8
    //   303: astore 7
    //   305: aload 7
    //   307: ifnull +8 -> 315
    //   310: aload 7
    //   312: invokevirtual 194	java/io/InputStreamReader:close	()V
    //   315: ldc 80
    //   317: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload 11
    //   322: areturn
    //   323: ldc 91
    //   325: iconst_3
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: dload_0
    //   332: invokestatic 97	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: dload_2
    //   339: invokestatic 97	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   342: aastore
    //   343: dup
    //   344: iconst_2
    //   345: ldc 196
    //   347: aastore
    //   348: invokestatic 103	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   351: astore 6
    //   353: goto -299 -> 54
    //   356: aload 6
    //   358: astore 7
    //   360: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   363: new 136	java/lang/StringBuilder
    //   366: dup
    //   367: ldc 198
    //   369: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   372: aload 10
    //   374: invokevirtual 199	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   377: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: aload 6
    //   388: astore 7
    //   390: new 204	org/json/JSONObject
    //   393: dup
    //   394: aload 10
    //   396: invokevirtual 199	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   399: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   402: ldc 207
    //   404: invokevirtual 211	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   407: astore 10
    //   409: aload 6
    //   411: astore 7
    //   413: aload 10
    //   415: iconst_0
    //   416: invokevirtual 217	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   419: astore 9
    //   421: aload 6
    //   423: astore 7
    //   425: aload 11
    //   427: aload 9
    //   429: ldc 219
    //   431: invokevirtual 222	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: putfield 225	com/tencent/mm/modelgeo/Addr:hdQ	Ljava/lang/String;
    //   437: aload 6
    //   439: astore 7
    //   441: aload 10
    //   443: iconst_0
    //   444: invokevirtual 217	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   447: ldc 227
    //   449: invokevirtual 211	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   452: astore 13
    //   454: iconst_0
    //   455: istore 5
    //   457: aload 6
    //   459: astore 7
    //   461: iload 5
    //   463: aload 13
    //   465: invokevirtual 230	org/json/JSONArray:length	()I
    //   468: if_icmpge +266 -> 734
    //   471: aload 6
    //   473: astore 7
    //   475: aload 13
    //   477: iload 5
    //   479: invokevirtual 217	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   482: astore 14
    //   484: aload 6
    //   486: astore 7
    //   488: aload 14
    //   490: ldc 232
    //   492: invokevirtual 222	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   495: astore 10
    //   497: aload 6
    //   499: astore 7
    //   501: aload 14
    //   503: ldc 234
    //   505: invokevirtual 211	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   508: iconst_0
    //   509: invokevirtual 237	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   512: astore 14
    //   514: aload 6
    //   516: astore 7
    //   518: aload 14
    //   520: ldc 239
    //   522: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   525: ifeq +17 -> 542
    //   528: aload 6
    //   530: astore 7
    //   532: aload 11
    //   534: aload 10
    //   536: putfield 246	com/tencent/mm/modelgeo/Addr:hdR	Ljava/lang/String;
    //   539: goto +559 -> 1098
    //   542: aload 6
    //   544: astore 7
    //   546: aload 14
    //   548: ldc 248
    //   550: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   553: ifeq +17 -> 570
    //   556: aload 6
    //   558: astore 7
    //   560: aload 11
    //   562: aload 10
    //   564: putfield 251	com/tencent/mm/modelgeo/Addr:hdS	Ljava/lang/String;
    //   567: goto +531 -> 1098
    //   570: aload 6
    //   572: astore 7
    //   574: aload 14
    //   576: ldc 253
    //   578: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   581: ifeq +37 -> 618
    //   584: aload 6
    //   586: astore 7
    //   588: aload 11
    //   590: aload 10
    //   592: putfield 256	com/tencent/mm/modelgeo/Addr:hdU	Ljava/lang/String;
    //   595: goto +503 -> 1098
    //   598: astore 6
    //   600: aload 7
    //   602: ifnull +8 -> 610
    //   605: aload 7
    //   607: invokevirtual 191	com/tencent/mm/network/v:disconnect	()V
    //   610: ldc 80
    //   612: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   615: aload 6
    //   617: athrow
    //   618: aload 6
    //   620: astore 7
    //   622: aload 14
    //   624: ldc_w 258
    //   627: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   630: ifeq +17 -> 647
    //   633: aload 6
    //   635: astore 7
    //   637: aload 11
    //   639: aload 10
    //   641: putfield 261	com/tencent/mm/modelgeo/Addr:hdV	Ljava/lang/String;
    //   644: goto +454 -> 1098
    //   647: aload 6
    //   649: astore 7
    //   651: aload 14
    //   653: ldc_w 263
    //   656: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   659: ifeq +17 -> 676
    //   662: aload 6
    //   664: astore 7
    //   666: aload 11
    //   668: aload 10
    //   670: putfield 266	com/tencent/mm/modelgeo/Addr:hdW	Ljava/lang/String;
    //   673: goto +425 -> 1098
    //   676: aload 6
    //   678: astore 7
    //   680: aload 14
    //   682: ldc_w 268
    //   685: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   688: ifeq +17 -> 705
    //   691: aload 6
    //   693: astore 7
    //   695: aload 11
    //   697: aload 10
    //   699: putfield 271	com/tencent/mm/modelgeo/Addr:hdX	Ljava/lang/String;
    //   702: goto +396 -> 1098
    //   705: aload 6
    //   707: astore 7
    //   709: aload 14
    //   711: ldc_w 273
    //   714: invokevirtual 243	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   717: ifeq +381 -> 1098
    //   720: aload 6
    //   722: astore 7
    //   724: aload 11
    //   726: aload 10
    //   728: putfield 275	com/tencent/mm/modelgeo/Addr:country	Ljava/lang/String;
    //   731: goto +367 -> 1098
    //   734: aload 6
    //   736: astore 7
    //   738: aload 11
    //   740: getfield 225	com/tencent/mm/modelgeo/Addr:hdQ	Ljava/lang/String;
    //   743: ldc_w 277
    //   746: invokestatic 283	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   749: astore 10
    //   751: aload 6
    //   753: astore 7
    //   755: aload 13
    //   757: invokevirtual 284	org/json/JSONArray:toString	()Ljava/lang/String;
    //   760: ldc_w 277
    //   763: invokestatic 283	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   766: astore 13
    //   768: aload 6
    //   770: astore 7
    //   772: aload 9
    //   774: ldc_w 286
    //   777: invokevirtual 289	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   780: invokevirtual 290	org/json/JSONObject:toString	()Ljava/lang/String;
    //   783: ldc_w 277
    //   786: invokestatic 283	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   789: astore 14
    //   791: aload 6
    //   793: astore 7
    //   795: aload 9
    //   797: ldc_w 292
    //   800: invokevirtual 222	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   803: ldc_w 277
    //   806: invokestatic 283	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   809: astore 15
    //   811: aload 6
    //   813: astore 7
    //   815: aload 9
    //   817: ldc 234
    //   819: invokevirtual 211	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   822: invokevirtual 284	org/json/JSONArray:toString	()Ljava/lang/String;
    //   825: ldc_w 277
    //   828: invokestatic 283	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   831: astore 9
    //   833: aload 6
    //   835: astore 7
    //   837: ldc_w 294
    //   840: iconst_2
    //   841: anewarray 4	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: dload_0
    //   847: invokestatic 97	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: dload_2
    //   854: invokestatic 97	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   857: aastore
    //   858: invokestatic 103	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   861: ldc_w 277
    //   864: invokestatic 283	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   867: astore 16
    //   869: aload 6
    //   871: astore 7
    //   873: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   876: ldc_w 296
    //   879: bipush 7
    //   881: anewarray 4	java/lang/Object
    //   884: dup
    //   885: iconst_0
    //   886: aload 10
    //   888: aastore
    //   889: dup
    //   890: iconst_1
    //   891: aload 13
    //   893: aastore
    //   894: dup
    //   895: iconst_2
    //   896: aload 14
    //   898: aastore
    //   899: dup
    //   900: iconst_3
    //   901: aload 15
    //   903: aastore
    //   904: dup
    //   905: iconst_4
    //   906: aload 9
    //   908: aastore
    //   909: dup
    //   910: iconst_5
    //   911: aload 16
    //   913: aastore
    //   914: dup
    //   915: bipush 6
    //   917: aload 12
    //   919: aastore
    //   920: invokestatic 298	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   923: aload 6
    //   925: astore 7
    //   927: getstatic 304	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   930: sipush 12886
    //   933: bipush 7
    //   935: anewarray 4	java/lang/Object
    //   938: dup
    //   939: iconst_0
    //   940: aload 13
    //   942: aastore
    //   943: dup
    //   944: iconst_1
    //   945: aload 10
    //   947: aastore
    //   948: dup
    //   949: iconst_2
    //   950: aload 14
    //   952: aastore
    //   953: dup
    //   954: iconst_3
    //   955: aload 15
    //   957: aastore
    //   958: dup
    //   959: iconst_4
    //   960: aload 9
    //   962: aastore
    //   963: dup
    //   964: iconst_5
    //   965: aload 16
    //   967: aastore
    //   968: dup
    //   969: bipush 6
    //   971: aload 12
    //   973: aastore
    //   974: invokevirtual 308	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   977: aload 6
    //   979: invokevirtual 191	com/tencent/mm/network/v:disconnect	()V
    //   982: aload 8
    //   984: astore 7
    //   986: goto -681 -> 305
    //   989: astore 9
    //   991: aconst_null
    //   992: astore 8
    //   994: aload 10
    //   996: astore 6
    //   998: aload 6
    //   1000: astore 7
    //   1002: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1005: ldc_w 310
    //   1008: invokestatic 118	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: aload 6
    //   1013: astore 7
    //   1015: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1018: ldc 178
    //   1020: iconst_1
    //   1021: anewarray 4	java/lang/Object
    //   1024: dup
    //   1025: iconst_0
    //   1026: aload 9
    //   1028: invokestatic 184	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1031: aastore
    //   1032: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1035: aload 8
    //   1037: astore 7
    //   1039: aload 6
    //   1041: ifnull -736 -> 305
    //   1044: aload 6
    //   1046: invokevirtual 191	com/tencent/mm/network/v:disconnect	()V
    //   1049: aload 8
    //   1051: astore 7
    //   1053: goto -748 -> 305
    //   1056: astore 6
    //   1058: getstatic 37	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1061: ldc 178
    //   1063: iconst_1
    //   1064: anewarray 4	java/lang/Object
    //   1067: dup
    //   1068: iconst_0
    //   1069: aload 6
    //   1071: invokestatic 184	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1074: aastore
    //   1075: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1078: goto -763 -> 315
    //   1081: astore 9
    //   1083: goto -85 -> 998
    //   1086: astore 10
    //   1088: aconst_null
    //   1089: astore 8
    //   1091: aload 9
    //   1093: astore 6
    //   1095: goto -844 -> 251
    //   1098: iload 5
    //   1100: iconst_1
    //   1101: iadd
    //   1102: istore 5
    //   1104: goto -647 -> 457
    //   1107: astore 7
    //   1109: goto -11 -> 1098
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1112	0	paramDouble1	double
    //   0	1112	2	paramDouble2	double
    //   0	1112	4	paramBoolean	boolean
    //   455	648	5	i	int
    //   52	533	6	localObject1	Object
    //   598	380	6	localObject2	Object
    //   996	49	6	localObject3	Object
    //   1056	14	6	localIOException1	java.io.IOException
    //   1093	1	6	localObject4	Object
    //   77	975	7	localObject5	Object
    //   1107	1	7	localException1	java.lang.Exception
    //   188	902	8	localInputStreamReader	java.io.InputStreamReader
    //   74	887	9	localObject6	Object
    //   989	38	9	localException2	java.lang.Exception
    //   1081	11	9	localException3	java.lang.Exception
    //   71	168	10	localObject7	Object
    //   249	146	10	localIOException2	java.io.IOException
    //   407	588	10	localObject8	Object
    //   1086	1	10	localIOException3	java.io.IOException
    //   17	722	11	localAddr	Addr
    //   8	964	12	str1	String
    //   227	714	13	localObject9	Object
    //   482	469	14	localObject10	Object
    //   809	147	15	str2	String
    //   867	99	16	str3	String
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
    //   546	556	249	java/io/IOException
    //   560	567	249	java/io/IOException
    //   574	584	249	java/io/IOException
    //   588	595	249	java/io/IOException
    //   622	633	249	java/io/IOException
    //   637	644	249	java/io/IOException
    //   651	662	249	java/io/IOException
    //   666	673	249	java/io/IOException
    //   680	691	249	java/io/IOException
    //   695	702	249	java/io/IOException
    //   709	720	249	java/io/IOException
    //   724	731	249	java/io/IOException
    //   738	751	249	java/io/IOException
    //   755	768	249	java/io/IOException
    //   772	791	249	java/io/IOException
    //   795	811	249	java/io/IOException
    //   815	833	249	java/io/IOException
    //   837	869	249	java/io/IOException
    //   873	923	249	java/io/IOException
    //   927	977	249	java/io/IOException
    //   79	87	598	finally
    //   99	107	598	finally
    //   119	126	598	finally
    //   138	164	598	finally
    //   176	190	598	finally
    //   194	205	598	finally
    //   209	218	598	finally
    //   222	229	598	finally
    //   238	246	598	finally
    //   255	263	598	finally
    //   267	287	598	finally
    //   360	386	598	finally
    //   390	409	598	finally
    //   413	421	598	finally
    //   425	437	598	finally
    //   441	454	598	finally
    //   461	471	598	finally
    //   475	484	598	finally
    //   488	497	598	finally
    //   501	514	598	finally
    //   518	528	598	finally
    //   532	539	598	finally
    //   546	556	598	finally
    //   560	567	598	finally
    //   574	584	598	finally
    //   588	595	598	finally
    //   622	633	598	finally
    //   637	644	598	finally
    //   651	662	598	finally
    //   666	673	598	finally
    //   680	691	598	finally
    //   695	702	598	finally
    //   709	720	598	finally
    //   724	731	598	finally
    //   738	751	598	finally
    //   755	768	598	finally
    //   772	791	598	finally
    //   795	811	598	finally
    //   815	833	598	finally
    //   837	869	598	finally
    //   873	923	598	finally
    //   927	977	598	finally
    //   1002	1011	598	finally
    //   1015	1035	598	finally
    //   79	87	989	java/lang/Exception
    //   99	107	989	java/lang/Exception
    //   119	126	989	java/lang/Exception
    //   138	164	989	java/lang/Exception
    //   176	190	989	java/lang/Exception
    //   310	315	1056	java/io/IOException
    //   194	205	1081	java/lang/Exception
    //   209	218	1081	java/lang/Exception
    //   222	229	1081	java/lang/Exception
    //   238	246	1081	java/lang/Exception
    //   360	386	1081	java/lang/Exception
    //   390	409	1081	java/lang/Exception
    //   413	421	1081	java/lang/Exception
    //   425	437	1081	java/lang/Exception
    //   441	454	1081	java/lang/Exception
    //   461	471	1081	java/lang/Exception
    //   475	484	1081	java/lang/Exception
    //   738	751	1081	java/lang/Exception
    //   755	768	1081	java/lang/Exception
    //   772	791	1081	java/lang/Exception
    //   795	811	1081	java/lang/Exception
    //   815	833	1081	java/lang/Exception
    //   837	869	1081	java/lang/Exception
    //   873	923	1081	java/lang/Exception
    //   927	977	1081	java/lang/Exception
    //   79	87	1086	java/io/IOException
    //   99	107	1086	java/io/IOException
    //   119	126	1086	java/io/IOException
    //   138	164	1086	java/io/IOException
    //   176	190	1086	java/io/IOException
    //   488	497	1107	java/lang/Exception
    //   501	514	1107	java/lang/Exception
    //   518	528	1107	java/lang/Exception
    //   532	539	1107	java/lang/Exception
    //   546	556	1107	java/lang/Exception
    //   560	567	1107	java/lang/Exception
    //   574	584	1107	java/lang/Exception
    //   588	595	1107	java/lang/Exception
    //   622	633	1107	java/lang/Exception
    //   637	644	1107	java/lang/Exception
    //   651	662	1107	java/lang/Exception
    //   666	673	1107	java/lang/Exception
    //   680	691	1107	java/lang/Exception
    //   695	702	1107	java/lang/Exception
    //   709	720	1107	java/lang/Exception
    //   724	731	1107	java/lang/Exception
  }
  
  private void a(Addr paramAddr)
  {
    AppMethodBeat.i(150476);
    if (this.heg == null)
    {
      AppMethodBeat.o(150476);
      return;
    }
    Addr localAddr = paramAddr;
    if (paramAddr == null) {
      localAddr = new Addr();
    }
    if (this.heg.tag == null) {}
    for (paramAddr = new Object();; paramAddr = this.heg.tag)
    {
      localAddr.tag = paramAddr;
      localAddr.heb = ((float)this.heg.lat);
      localAddr.hec = ((float)this.heg.lng);
      paramAddr = (CopyOnWriteArrayList)this.byu.get(this.heg.toString());
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
    this.byu.remove(this.heg.toString());
    ad.d(TAG, "postexecute2 listeners %d", new Object[] { Integer.valueOf(this.byu.size()) });
    this.heg = null;
    axR();
    if ((this.heg == null) && (this.heh.size() > 0)) {
      com.tencent.mm.kernel.g.aeS().b(655, this);
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
  
  public static c axQ()
  {
    AppMethodBeat.i(150468);
    if (hef == null) {
      hef = new c();
    }
    c localc = hef;
    AppMethodBeat.o(150468);
    return localc;
  }
  
  private void axR()
  {
    AppMethodBeat.i(150474);
    if ((this.heg == null) && (this.heh != null) && (this.heh.size() > 0))
    {
      this.heg = ((c)this.heh.remove(0));
      axS();
    }
    AppMethodBeat.o(150474);
  }
  
  private void axS()
  {
    AppMethodBeat.i(150475);
    if (bt.iP(aj.getContext()))
    {
      this.hei.c(new b());
      AppMethodBeat.o(150475);
      return;
    }
    com.tencent.mm.kernel.g.aeS().a(655, this);
    com.tencent.mm.kernel.g.aeS().a(new e(this.heg.lat, this.heg.lng), 0);
    AppMethodBeat.o(150475);
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
      localObject = this.heh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        if ((localc != null) && (localc.tag != null) && (localc.tag.equals(paramObject))) {
          this.heh.remove(localc);
        }
      }
    }
    c localc = new c(paramDouble1, paramDouble2, paramObject);
    Object localObject = (CopyOnWriteArrayList)this.byu.get(localc.toString());
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new CopyOnWriteArrayList();
    }
    if (!a(paramObject, parama)) {
      paramObject.add(new WeakReference(parama));
    }
    this.byu.put(localc.toString(), paramObject);
    parama = this.heh.iterator();
    while (parama.hasNext()) {
      if (((c)parama.next()).equals(localc))
      {
        axR();
        AppMethodBeat.o(150472);
        return false;
      }
    }
    if ((this.heg != null) && (localc.equals(this.heg)))
    {
      AppMethodBeat.o(150472);
      return false;
    }
    this.heh.add(localc);
    ad.i(TAG, "push task size %d listeners %d", new Object[] { Integer.valueOf(this.heh.size()), Integer.valueOf(this.byu.size()) });
    while (this.heh.size() > 30)
    {
      ad.i(TAG, "force remove task");
      parama = (c)this.heh.remove(0);
      if (parama != null) {
        this.byu.remove(parama.toString());
      }
    }
    axR();
    AppMethodBeat.o(150472);
    return true;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150469);
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    Object localObject3 = this.byu.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.byu.get(str);
      b(localCopyOnWriteArrayList, parama);
      this.byu.put(str, localCopyOnWriteArrayList);
      if ((localCopyOnWriteArrayList == null) || (localCopyOnWriteArrayList.size() == 0)) {
        ((LinkedList)localObject2).add(str);
      }
    }
    parama = ((LinkedList)localObject2).iterator();
    while (parama.hasNext())
    {
      localObject2 = (String)parama.next();
      this.byu.remove(localObject2);
    }
    parama = this.heh.iterator();
    while (parama.hasNext())
    {
      localObject2 = (c)parama.next();
      localObject3 = (CopyOnWriteArrayList)this.byu.get(((c)localObject2).toString());
      if ((localObject3 == null) || (((CopyOnWriteArrayList)localObject3).size() == 0))
      {
        ((LinkedList)localObject1).add(localObject2);
        this.byu.remove(((c)localObject2).toString());
      }
    }
    parama = ((LinkedList)localObject1).iterator();
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.heh.remove(localObject1);
    }
    ad.i(TAG, "remove taskLists %d listeners size %d", new Object[] { Integer.valueOf(this.heh.size()), Integer.valueOf(this.byu.size()) });
    AppMethodBeat.o(150469);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150478);
    if (paramn.getType() == 655)
    {
      paramString = ((e)paramn).axW();
      if ((paramString == null) || (paramString.hdQ == null) || (paramString.hdQ.equals("")))
      {
        this.hei.c(new b());
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
    implements be.a
  {
    private Addr hek = null;
    
    public b() {}
    
    public final boolean aus()
    {
      AppMethodBeat.i(150463);
      if (c.a(c.this) == null)
      {
        AppMethodBeat.o(150463);
        return false;
      }
      if ((this.hek == null) || (this.hek.hdQ == null) || (this.hek.hdQ.equals(""))) {
        this.hek = c.b(c.a(c.this).lat, c.a(c.this).lng, c.b(c.this));
      }
      AppMethodBeat.o(150463);
      return true;
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150464);
      c.c(c.this);
      c.a(c.this, this.hek);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c
 * JD-Core Version:    0.7.0.1
 */