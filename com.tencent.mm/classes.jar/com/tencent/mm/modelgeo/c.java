package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
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
  implements com.tencent.mm.am.h
{
  public static String TAG;
  private static c oDX;
  private static final String oDY;
  private HashMap<String, CopyOnWriteArrayList<WeakReference<a>>> djU;
  private c oDZ;
  private CopyOnWriteArrayList<c> oEa;
  private QueueWorkerThread oEb;
  private boolean oEc;
  
  static
  {
    AppMethodBeat.i(231764);
    TAG = "MicroMsg.LocationAddr";
    oDY = "http://" + WeChatHosts.domainString(c.h.host_location_desc_map_qq_com) + "/rgeoc?lnglat=%f,%f";
    AppMethodBeat.o(231764);
  }
  
  private c()
  {
    AppMethodBeat.i(150467);
    this.oDZ = null;
    this.oEa = new CopyOnWriteArrayList();
    this.djU = new HashMap();
    this.oEb = new QueueWorkerThread(1, "addr_worker");
    this.oEc = true;
    AppMethodBeat.o(150467);
  }
  
  private void a(Addr paramAddr)
  {
    AppMethodBeat.i(150476);
    if (this.oDZ == null)
    {
      AppMethodBeat.o(150476);
      return;
    }
    Addr localAddr = paramAddr;
    if (paramAddr == null) {
      localAddr = new Addr();
    }
    if (this.oDZ.tag == null) {}
    for (paramAddr = new Object();; paramAddr = this.oDZ.tag)
    {
      localAddr.tag = paramAddr;
      localAddr.oDT = ((float)this.oDZ.lat);
      localAddr.oDU = ((float)this.oDZ.lng);
      paramAddr = (CopyOnWriteArrayList)this.djU.get(this.oDZ.toString());
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
    this.djU.remove(this.oDZ.toString());
    Log.d(TAG, "postexecute2 listeners %d", new Object[] { Integer.valueOf(this.djU.size()) });
    this.oDZ = null;
    bJi();
    if ((this.oDZ == null) && (this.oEa.size() > 0))
    {
      com.tencent.mm.kernel.h.aZW().b(655, this);
      com.tencent.mm.kernel.h.aZW().b(4005, this);
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
  
  /* Error */
  private static Addr b(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 211
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 216	com/tencent/mm/sdk/platformtools/LocaleUtil:getApplicationLanguage	()Ljava/lang/String;
    //   8: astore 12
    //   10: new 112	com/tencent/mm/modelgeo/Addr
    //   13: dup
    //   14: invokespecial 113	com/tencent/mm/modelgeo/Addr:<init>	()V
    //   17: astore 11
    //   19: iload 4
    //   21: ifeq +305 -> 326
    //   24: ldc 218
    //   26: iconst_3
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: dload_0
    //   33: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: dload_2
    //   40: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: aload 12
    //   48: aastore
    //   49: invokestatic 229	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 6
    //   54: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   57: ldc 231
    //   59: aload 6
    //   61: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: astore 10
    //   73: aconst_null
    //   74: astore 9
    //   76: aconst_null
    //   77: astore 7
    //   79: aload 6
    //   81: aconst_null
    //   82: invokestatic 246	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 7
    //   91: aload 6
    //   93: astore 10
    //   95: aload 6
    //   97: astore 9
    //   99: aload 6
    //   101: sipush 10000
    //   104: invokevirtual 251	com/tencent/mm/network/y:xx	(I)V
    //   107: aload 6
    //   109: astore 7
    //   111: aload 6
    //   113: astore 10
    //   115: aload 6
    //   117: astore 9
    //   119: aload 6
    //   121: ldc 253
    //   123: invokevirtual 256	com/tencent/mm/network/y:Rx	(Ljava/lang/String;)V
    //   126: aload 6
    //   128: astore 7
    //   130: aload 6
    //   132: astore 10
    //   134: aload 6
    //   136: astore 9
    //   138: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   141: new 47	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 258
    //   148: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload 6
    //   153: invokevirtual 261	com/tencent/mm/network/y:getResponseCode	()I
    //   156: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 6
    //   167: astore 7
    //   169: aload 6
    //   171: astore 10
    //   173: aload 6
    //   175: astore 9
    //   177: new 266	java/io/InputStreamReader
    //   180: dup
    //   181: aload 6
    //   183: invokevirtual 270	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   186: invokespecial 273	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   189: astore 8
    //   191: aload 6
    //   193: astore 7
    //   195: new 275	java/io/BufferedReader
    //   198: dup
    //   199: aload 8
    //   201: invokespecial 278	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   204: astore 9
    //   206: aload 6
    //   208: astore 7
    //   210: new 280	java/lang/StringBuffer
    //   213: dup
    //   214: invokespecial 281	java/lang/StringBuffer:<init>	()V
    //   217: astore 10
    //   219: aload 6
    //   221: astore 7
    //   223: aload 9
    //   225: invokevirtual 284	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   228: astore 13
    //   230: aload 13
    //   232: ifnull +128 -> 360
    //   235: aload 6
    //   237: astore 7
    //   239: aload 10
    //   241: aload 13
    //   243: invokevirtual 287	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   246: pop
    //   247: goto -28 -> 219
    //   250: astore 10
    //   252: aload 6
    //   254: astore 7
    //   256: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   259: ldc_w 289
    //   262: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 6
    //   267: astore 7
    //   269: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   272: ldc_w 291
    //   275: iconst_1
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload 10
    //   283: invokestatic 297	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   286: aastore
    //   287: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: aload 8
    //   292: astore 7
    //   294: aload 6
    //   296: ifnull +12 -> 308
    //   299: aload 6
    //   301: invokevirtual 303	com/tencent/mm/network/y:disconnect	()V
    //   304: aload 8
    //   306: astore 7
    //   308: aload 7
    //   310: ifnull +8 -> 318
    //   313: aload 7
    //   315: invokevirtual 306	java/io/InputStreamReader:close	()V
    //   318: ldc 211
    //   320: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: aload 11
    //   325: areturn
    //   326: ldc 218
    //   328: iconst_3
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: dload_0
    //   335: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   338: aastore
    //   339: dup
    //   340: iconst_1
    //   341: dload_2
    //   342: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   345: aastore
    //   346: dup
    //   347: iconst_2
    //   348: ldc_w 308
    //   351: aastore
    //   352: invokestatic 229	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   355: astore 6
    //   357: goto -303 -> 54
    //   360: aload 6
    //   362: astore 7
    //   364: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   367: new 47	java/lang/StringBuilder
    //   370: dup
    //   371: ldc_w 310
    //   374: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   377: aload 10
    //   379: invokevirtual 311	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   382: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload 6
    //   393: astore 7
    //   395: new 313	org/json/JSONObject
    //   398: dup
    //   399: aload 10
    //   401: invokevirtual 311	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   404: invokespecial 314	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   407: ldc_w 316
    //   410: invokevirtual 320	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   413: astore 10
    //   415: aload 6
    //   417: astore 7
    //   419: aload 10
    //   421: iconst_0
    //   422: invokevirtual 326	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   425: astore 9
    //   427: aload 6
    //   429: astore 7
    //   431: aload 11
    //   433: aload 9
    //   435: ldc_w 328
    //   438: invokevirtual 331	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   441: putfield 334	com/tencent/mm/modelgeo/Addr:oDI	Ljava/lang/String;
    //   444: aload 6
    //   446: astore 7
    //   448: aload 10
    //   450: iconst_0
    //   451: invokevirtual 326	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   454: ldc_w 336
    //   457: invokevirtual 320	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   460: astore 13
    //   462: iconst_0
    //   463: istore 5
    //   465: aload 6
    //   467: astore 7
    //   469: iload 5
    //   471: aload 13
    //   473: invokevirtual 339	org/json/JSONArray:length	()I
    //   476: if_icmpge +271 -> 747
    //   479: aload 6
    //   481: astore 7
    //   483: aload 13
    //   485: iload 5
    //   487: invokevirtual 326	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   490: astore 14
    //   492: aload 6
    //   494: astore 7
    //   496: aload 14
    //   498: ldc_w 341
    //   501: invokevirtual 331	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   504: astore 10
    //   506: aload 6
    //   508: astore 7
    //   510: aload 14
    //   512: ldc_w 343
    //   515: invokevirtual 320	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   518: iconst_0
    //   519: invokevirtual 345	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   522: astore 14
    //   524: aload 6
    //   526: astore 7
    //   528: aload 14
    //   530: ldc_w 347
    //   533: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   536: ifeq +17 -> 553
    //   539: aload 6
    //   541: astore 7
    //   543: aload 11
    //   545: aload 10
    //   547: putfield 351	com/tencent/mm/modelgeo/Addr:oDJ	Ljava/lang/String;
    //   550: goto +573 -> 1123
    //   553: aload 6
    //   555: astore 7
    //   557: aload 14
    //   559: ldc_w 353
    //   562: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifeq +17 -> 582
    //   568: aload 6
    //   570: astore 7
    //   572: aload 11
    //   574: aload 10
    //   576: putfield 356	com/tencent/mm/modelgeo/Addr:oDK	Ljava/lang/String;
    //   579: goto +544 -> 1123
    //   582: aload 6
    //   584: astore 7
    //   586: aload 14
    //   588: ldc_w 358
    //   591: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   594: ifeq +37 -> 631
    //   597: aload 6
    //   599: astore 7
    //   601: aload 11
    //   603: aload 10
    //   605: putfield 361	com/tencent/mm/modelgeo/Addr:oDM	Ljava/lang/String;
    //   608: goto +515 -> 1123
    //   611: astore 6
    //   613: aload 7
    //   615: ifnull +8 -> 623
    //   618: aload 7
    //   620: invokevirtual 303	com/tencent/mm/network/y:disconnect	()V
    //   623: ldc 211
    //   625: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   628: aload 6
    //   630: athrow
    //   631: aload 6
    //   633: astore 7
    //   635: aload 14
    //   637: ldc_w 363
    //   640: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   643: ifeq +17 -> 660
    //   646: aload 6
    //   648: astore 7
    //   650: aload 11
    //   652: aload 10
    //   654: putfield 366	com/tencent/mm/modelgeo/Addr:oDN	Ljava/lang/String;
    //   657: goto +466 -> 1123
    //   660: aload 6
    //   662: astore 7
    //   664: aload 14
    //   666: ldc_w 368
    //   669: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   672: ifeq +17 -> 689
    //   675: aload 6
    //   677: astore 7
    //   679: aload 11
    //   681: aload 10
    //   683: putfield 371	com/tencent/mm/modelgeo/Addr:oDO	Ljava/lang/String;
    //   686: goto +437 -> 1123
    //   689: aload 6
    //   691: astore 7
    //   693: aload 14
    //   695: ldc_w 373
    //   698: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   701: ifeq +17 -> 718
    //   704: aload 6
    //   706: astore 7
    //   708: aload 11
    //   710: aload 10
    //   712: putfield 376	com/tencent/mm/modelgeo/Addr:oDP	Ljava/lang/String;
    //   715: goto +408 -> 1123
    //   718: aload 6
    //   720: astore 7
    //   722: aload 14
    //   724: ldc_w 378
    //   727: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   730: ifeq +393 -> 1123
    //   733: aload 6
    //   735: astore 7
    //   737: aload 11
    //   739: aload 10
    //   741: putfield 380	com/tencent/mm/modelgeo/Addr:country	Ljava/lang/String;
    //   744: goto +379 -> 1123
    //   747: aload 6
    //   749: astore 7
    //   751: aload 11
    //   753: getfield 334	com/tencent/mm/modelgeo/Addr:oDI	Ljava/lang/String;
    //   756: ldc_w 382
    //   759: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   762: astore 10
    //   764: aload 6
    //   766: astore 7
    //   768: aload 13
    //   770: invokevirtual 389	org/json/JSONArray:toString	()Ljava/lang/String;
    //   773: ldc_w 382
    //   776: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   779: astore 13
    //   781: aload 6
    //   783: astore 7
    //   785: aload 9
    //   787: ldc_w 391
    //   790: invokevirtual 394	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   793: invokevirtual 395	org/json/JSONObject:toString	()Ljava/lang/String;
    //   796: ldc_w 382
    //   799: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   802: astore 14
    //   804: aload 6
    //   806: astore 7
    //   808: aload 9
    //   810: ldc_w 397
    //   813: invokevirtual 331	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   816: ldc_w 382
    //   819: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   822: astore 15
    //   824: aload 6
    //   826: astore 7
    //   828: aload 9
    //   830: ldc_w 343
    //   833: invokevirtual 320	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   836: invokevirtual 389	org/json/JSONArray:toString	()Ljava/lang/String;
    //   839: ldc_w 382
    //   842: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   845: astore 9
    //   847: aload 6
    //   849: astore 7
    //   851: ldc_w 399
    //   854: iconst_2
    //   855: anewarray 4	java/lang/Object
    //   858: dup
    //   859: iconst_0
    //   860: dload_0
    //   861: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   864: aastore
    //   865: dup
    //   866: iconst_1
    //   867: dload_2
    //   868: invokestatic 223	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   871: aastore
    //   872: invokestatic 229	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   875: ldc_w 382
    //   878: invokestatic 388	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   881: astore 16
    //   883: aload 6
    //   885: astore 7
    //   887: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   890: ldc_w 401
    //   893: bipush 7
    //   895: anewarray 4	java/lang/Object
    //   898: dup
    //   899: iconst_0
    //   900: aload 10
    //   902: aastore
    //   903: dup
    //   904: iconst_1
    //   905: aload 13
    //   907: aastore
    //   908: dup
    //   909: iconst_2
    //   910: aload 14
    //   912: aastore
    //   913: dup
    //   914: iconst_3
    //   915: aload 15
    //   917: aastore
    //   918: dup
    //   919: iconst_4
    //   920: aload 9
    //   922: aastore
    //   923: dup
    //   924: iconst_5
    //   925: aload 16
    //   927: aastore
    //   928: dup
    //   929: bipush 6
    //   931: aload 12
    //   933: aastore
    //   934: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: aload 6
    //   939: astore 7
    //   941: getstatic 407	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   944: sipush 12886
    //   947: bipush 7
    //   949: anewarray 4	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: aload 13
    //   956: aastore
    //   957: dup
    //   958: iconst_1
    //   959: aload 10
    //   961: aastore
    //   962: dup
    //   963: iconst_2
    //   964: aload 14
    //   966: aastore
    //   967: dup
    //   968: iconst_3
    //   969: aload 15
    //   971: aastore
    //   972: dup
    //   973: iconst_4
    //   974: aload 9
    //   976: aastore
    //   977: dup
    //   978: iconst_5
    //   979: aload 16
    //   981: aastore
    //   982: dup
    //   983: bipush 6
    //   985: aload 12
    //   987: aastore
    //   988: invokevirtual 410	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   991: aload 8
    //   993: astore 7
    //   995: aload 6
    //   997: ifnull -689 -> 308
    //   1000: aload 6
    //   1002: invokevirtual 303	com/tencent/mm/network/y:disconnect	()V
    //   1005: aload 8
    //   1007: astore 7
    //   1009: goto -701 -> 308
    //   1012: astore 9
    //   1014: aconst_null
    //   1015: astore 8
    //   1017: aload 10
    //   1019: astore 6
    //   1021: aload 6
    //   1023: astore 7
    //   1025: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1028: ldc_w 412
    //   1031: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1034: aload 6
    //   1036: astore 7
    //   1038: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1041: ldc_w 291
    //   1044: iconst_1
    //   1045: anewarray 4	java/lang/Object
    //   1048: dup
    //   1049: iconst_0
    //   1050: aload 9
    //   1052: invokestatic 297	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1055: aastore
    //   1056: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1059: aload 8
    //   1061: astore 7
    //   1063: aload 6
    //   1065: ifnull -757 -> 308
    //   1068: aload 6
    //   1070: invokevirtual 303	com/tencent/mm/network/y:disconnect	()V
    //   1073: aload 8
    //   1075: astore 7
    //   1077: goto -769 -> 308
    //   1080: astore 6
    //   1082: getstatic 45	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1085: ldc_w 291
    //   1088: iconst_1
    //   1089: anewarray 4	java/lang/Object
    //   1092: dup
    //   1093: iconst_0
    //   1094: aload 6
    //   1096: invokestatic 297	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1099: aastore
    //   1100: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1103: goto -785 -> 318
    //   1106: astore 9
    //   1108: goto -87 -> 1021
    //   1111: astore 10
    //   1113: aconst_null
    //   1114: astore 8
    //   1116: aload 9
    //   1118: astore 6
    //   1120: goto -868 -> 252
    //   1123: iload 5
    //   1125: iconst_1
    //   1126: iadd
    //   1127: istore 5
    //   1129: goto -664 -> 465
    //   1132: astore 7
    //   1134: goto -11 -> 1123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	paramDouble1	double
    //   0	1137	2	paramDouble2	double
    //   0	1137	4	paramBoolean	boolean
    //   463	665	5	i	int
    //   52	546	6	localObject1	Object
    //   611	390	6	localObject2	Object
    //   1019	50	6	localObject3	Object
    //   1080	15	6	localIOException1	java.io.IOException
    //   1118	1	6	localObject4	Object
    //   77	999	7	localObject5	Object
    //   1132	1	7	localException1	java.lang.Exception
    //   189	926	8	localInputStreamReader	java.io.InputStreamReader
    //   74	901	9	localObject6	Object
    //   1012	39	9	localException2	java.lang.Exception
    //   1106	11	9	localException3	java.lang.Exception
    //   71	169	10	localObject7	Object
    //   250	150	10	localIOException2	java.io.IOException
    //   413	605	10	localObject8	Object
    //   1111	1	10	localIOException3	java.io.IOException
    //   17	735	11	localAddr	Addr
    //   8	978	12	str1	String
    //   228	727	13	localObject9	Object
    //   490	475	14	localObject10	Object
    //   822	148	15	str2	String
    //   881	99	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   195	206	250	java/io/IOException
    //   210	219	250	java/io/IOException
    //   223	230	250	java/io/IOException
    //   239	247	250	java/io/IOException
    //   364	391	250	java/io/IOException
    //   395	415	250	java/io/IOException
    //   419	427	250	java/io/IOException
    //   431	444	250	java/io/IOException
    //   448	462	250	java/io/IOException
    //   469	479	250	java/io/IOException
    //   483	492	250	java/io/IOException
    //   496	506	250	java/io/IOException
    //   510	524	250	java/io/IOException
    //   528	539	250	java/io/IOException
    //   543	550	250	java/io/IOException
    //   557	568	250	java/io/IOException
    //   572	579	250	java/io/IOException
    //   586	597	250	java/io/IOException
    //   601	608	250	java/io/IOException
    //   635	646	250	java/io/IOException
    //   650	657	250	java/io/IOException
    //   664	675	250	java/io/IOException
    //   679	686	250	java/io/IOException
    //   693	704	250	java/io/IOException
    //   708	715	250	java/io/IOException
    //   722	733	250	java/io/IOException
    //   737	744	250	java/io/IOException
    //   751	764	250	java/io/IOException
    //   768	781	250	java/io/IOException
    //   785	804	250	java/io/IOException
    //   808	824	250	java/io/IOException
    //   828	847	250	java/io/IOException
    //   851	883	250	java/io/IOException
    //   887	937	250	java/io/IOException
    //   941	991	250	java/io/IOException
    //   79	87	611	finally
    //   99	107	611	finally
    //   119	126	611	finally
    //   138	165	611	finally
    //   177	191	611	finally
    //   195	206	611	finally
    //   210	219	611	finally
    //   223	230	611	finally
    //   239	247	611	finally
    //   256	265	611	finally
    //   269	290	611	finally
    //   364	391	611	finally
    //   395	415	611	finally
    //   419	427	611	finally
    //   431	444	611	finally
    //   448	462	611	finally
    //   469	479	611	finally
    //   483	492	611	finally
    //   496	506	611	finally
    //   510	524	611	finally
    //   528	539	611	finally
    //   543	550	611	finally
    //   557	568	611	finally
    //   572	579	611	finally
    //   586	597	611	finally
    //   601	608	611	finally
    //   635	646	611	finally
    //   650	657	611	finally
    //   664	675	611	finally
    //   679	686	611	finally
    //   693	704	611	finally
    //   708	715	611	finally
    //   722	733	611	finally
    //   737	744	611	finally
    //   751	764	611	finally
    //   768	781	611	finally
    //   785	804	611	finally
    //   808	824	611	finally
    //   828	847	611	finally
    //   851	883	611	finally
    //   887	937	611	finally
    //   941	991	611	finally
    //   1025	1034	611	finally
    //   1038	1059	611	finally
    //   79	87	1012	java/lang/Exception
    //   99	107	1012	java/lang/Exception
    //   119	126	1012	java/lang/Exception
    //   138	165	1012	java/lang/Exception
    //   177	191	1012	java/lang/Exception
    //   313	318	1080	java/io/IOException
    //   195	206	1106	java/lang/Exception
    //   210	219	1106	java/lang/Exception
    //   223	230	1106	java/lang/Exception
    //   239	247	1106	java/lang/Exception
    //   364	391	1106	java/lang/Exception
    //   395	415	1106	java/lang/Exception
    //   419	427	1106	java/lang/Exception
    //   431	444	1106	java/lang/Exception
    //   448	462	1106	java/lang/Exception
    //   469	479	1106	java/lang/Exception
    //   483	492	1106	java/lang/Exception
    //   751	764	1106	java/lang/Exception
    //   768	781	1106	java/lang/Exception
    //   785	804	1106	java/lang/Exception
    //   808	824	1106	java/lang/Exception
    //   828	847	1106	java/lang/Exception
    //   851	883	1106	java/lang/Exception
    //   887	937	1106	java/lang/Exception
    //   941	991	1106	java/lang/Exception
    //   79	87	1111	java/io/IOException
    //   99	107	1111	java/io/IOException
    //   119	126	1111	java/io/IOException
    //   138	165	1111	java/io/IOException
    //   177	191	1111	java/io/IOException
    //   496	506	1132	java/lang/Exception
    //   510	524	1132	java/lang/Exception
    //   528	539	1132	java/lang/Exception
    //   543	550	1132	java/lang/Exception
    //   557	568	1132	java/lang/Exception
    //   572	579	1132	java/lang/Exception
    //   586	597	1132	java/lang/Exception
    //   601	608	1132	java/lang/Exception
    //   635	646	1132	java/lang/Exception
    //   650	657	1132	java/lang/Exception
    //   664	675	1132	java/lang/Exception
    //   679	686	1132	java/lang/Exception
    //   693	704	1132	java/lang/Exception
    //   708	715	1132	java/lang/Exception
    //   722	733	1132	java/lang/Exception
    //   737	744	1132	java/lang/Exception
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
  
  public static c bJh()
  {
    AppMethodBeat.i(150468);
    if (oDX == null) {
      oDX = new c();
    }
    c localc = oDX;
    AppMethodBeat.o(150468);
    return localc;
  }
  
  private void bJi()
  {
    AppMethodBeat.i(150474);
    if ((this.oDZ == null) && (this.oEa != null) && (this.oEa.size() > 0))
    {
      this.oDZ = ((c)this.oEa.remove(0));
      bJj();
    }
    AppMethodBeat.o(150474);
  }
  
  private void bJj()
  {
    AppMethodBeat.i(150475);
    if (Util.isOverseasUser(MMApplicationContext.getContext()))
    {
      this.oEb.add(new b());
      AppMethodBeat.o(150475);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(655, this);
    com.tencent.mm.kernel.h.aZW().a(4005, this);
    if (this.oDZ.oEf)
    {
      com.tencent.mm.kernel.h.aZW().a(new f(this.oDZ.lat, this.oDZ.lng), 0);
      AppMethodBeat.o(150475);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(new e(this.oDZ.lat, this.oDZ.lng), 0);
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
    AppMethodBeat.i(231779);
    if (paramObject != null)
    {
      localObject = this.oEa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        if ((localc != null) && (localc.tag != null) && (localc.tag.equals(paramObject))) {
          this.oEa.remove(localc);
        }
      }
    }
    c localc = new c(paramDouble1, paramDouble2, paramObject, paramBoolean);
    Object localObject = (CopyOnWriteArrayList)this.djU.get(localc.toString());
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new CopyOnWriteArrayList();
    }
    if (!a(paramObject, parama)) {
      paramObject.add(new WeakReference(parama));
    }
    this.djU.put(localc.toString(), paramObject);
    parama = this.oEa.iterator();
    while (parama.hasNext()) {
      if (((c)parama.next()).equals(localc))
      {
        bJi();
        AppMethodBeat.o(231779);
        return false;
      }
    }
    if ((this.oDZ != null) && (localc.equals(this.oDZ)))
    {
      AppMethodBeat.o(231779);
      return false;
    }
    this.oEa.add(localc);
    Log.i(TAG, "push task size %d listeners %d", new Object[] { Integer.valueOf(this.oEa.size()), Integer.valueOf(this.djU.size()) });
    while (this.oEa.size() > 30)
    {
      Log.i(TAG, "force remove task");
      parama = (c)this.oEa.remove(0);
      if (parama != null) {
        this.djU.remove(parama.toString());
      }
    }
    bJi();
    AppMethodBeat.o(231779);
    return true;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(150469);
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    Object localObject3 = this.djU.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.djU.get(str);
      b(localCopyOnWriteArrayList, parama);
      this.djU.put(str, localCopyOnWriteArrayList);
      if ((localCopyOnWriteArrayList == null) || (localCopyOnWriteArrayList.size() == 0)) {
        ((LinkedList)localObject2).add(str);
      }
    }
    parama = ((LinkedList)localObject2).iterator();
    while (parama.hasNext())
    {
      localObject2 = (String)parama.next();
      this.djU.remove(localObject2);
    }
    parama = this.oEa.iterator();
    while (parama.hasNext())
    {
      localObject2 = (c)parama.next();
      localObject3 = (CopyOnWriteArrayList)this.djU.get(((c)localObject2).toString());
      if ((localObject3 == null) || (((CopyOnWriteArrayList)localObject3).size() == 0))
      {
        ((LinkedList)localObject1).add(localObject2);
        this.djU.remove(((c)localObject2).toString());
      }
    }
    parama = ((LinkedList)localObject1).iterator();
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.oEa.remove(localObject1);
    }
    Log.i(TAG, "remove taskLists %d listeners size %d", new Object[] { Integer.valueOf(this.oEa.size()), Integer.valueOf(this.djU.size()) });
    AppMethodBeat.o(150469);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(150478);
    paramString = null;
    if (paramp.getType() == 4005) {
      paramString = ((f)paramp).bJo();
    }
    while ((paramString == null) || (paramString.oDI == null) || (paramString.oDI.equals("")))
    {
      this.oEb.add(new b());
      AppMethodBeat.o(150478);
      return;
      if (paramp.getType() == 655) {
        paramString = ((e)paramp).bJo();
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
    private Addr oEd = null;
    
    public b() {}
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150463);
      if (c.a(c.this) == null)
      {
        AppMethodBeat.o(150463);
        return false;
      }
      if ((this.oEd == null) || (this.oEd.oDI == null) || (this.oEd.oDI.equals(""))) {
        this.oEd = c.c(c.a(c.this).lat, c.a(c.this).lng, c.b(c.this));
      }
      AppMethodBeat.o(150463);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150464);
      c.c(c.this);
      c.a(c.this, this.oEd);
      AppMethodBeat.o(150464);
      return true;
    }
  }
  
  final class c
  {
    double lat;
    double lng;
    boolean oEf;
    Object tag = "";
    
    public c(double paramDouble1, double paramDouble2, Object paramObject, boolean paramBoolean)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.tag = paramObject;
      this.oEf = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelgeo.c
 * JD-Core Version:    0.7.0.1
 */