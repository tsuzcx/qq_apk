package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c
  implements f
{
  public static String TAG = "MicroMsg.LocationAddr";
  private static c fBF;
  private HashMap<String, CopyOnWriteArrayList<WeakReference<c.a>>> bat;
  private c fBG;
  private CopyOnWriteArrayList<c> fBH;
  private az fBI;
  private boolean fBJ;
  
  private c()
  {
    AppMethodBeat.i(78110);
    this.fBG = null;
    this.fBH = new CopyOnWriteArrayList();
    this.bat = new HashMap();
    this.fBI = new az(1, "addr_worker");
    this.fBJ = true;
    AppMethodBeat.o(78110);
  }
  
  private void a(Addr paramAddr)
  {
    AppMethodBeat.i(78119);
    if (this.fBG == null)
    {
      AppMethodBeat.o(78119);
      return;
    }
    Addr localAddr = paramAddr;
    if (paramAddr == null) {
      localAddr = new Addr();
    }
    if (this.fBG.tag == null) {}
    for (paramAddr = new Object();; paramAddr = this.fBG.tag)
    {
      localAddr.tag = paramAddr;
      localAddr.fBB = ((float)this.fBG.lat);
      localAddr.fBC = ((float)this.fBG.lng);
      paramAddr = (CopyOnWriteArrayList)this.bat.get(this.fBG.toString());
      if (paramAddr == null) {
        break;
      }
      paramAddr = paramAddr.iterator();
      while (paramAddr.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)paramAddr.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((c.a)localWeakReference.get()).b(localAddr);
        }
      }
    }
    this.bat.remove(this.fBG.toString());
    ab.d(TAG, "postexecute2 listeners %d", new Object[] { Integer.valueOf(this.bat.size()) });
    this.fBG = null;
    agO();
    if ((this.fBG == null) && (this.fBH.size() > 0)) {
      g.Rc().b(655, this);
    }
    AppMethodBeat.o(78119);
  }
  
  private static boolean a(CopyOnWriteArrayList<WeakReference<c.a>> paramCopyOnWriteArrayList, c.a parama)
  {
    AppMethodBeat.i(78113);
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramCopyOnWriteArrayList.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((c.a)localWeakReference.get()).equals(parama)))
      {
        AppMethodBeat.o(78113);
        return true;
      }
    }
    AppMethodBeat.o(78113);
    return false;
  }
  
  public static c agN()
  {
    AppMethodBeat.i(78111);
    if (fBF == null) {
      fBF = new c();
    }
    c localc = fBF;
    AppMethodBeat.o(78111);
    return localc;
  }
  
  private void agO()
  {
    AppMethodBeat.i(78117);
    if ((this.fBG == null) && (this.fBH != null) && (this.fBH.size() > 0))
    {
      this.fBG = ((c)this.fBH.remove(0));
      agP();
    }
    AppMethodBeat.o(78117);
  }
  
  private void agP()
  {
    AppMethodBeat.i(78118);
    if (bo.hl(ah.getContext()))
    {
      this.fBI.e(new b());
      AppMethodBeat.o(78118);
      return;
    }
    g.Rc().a(655, this);
    g.Rc().a(new e(this.fBG.lat, this.fBG.lng), 0);
    AppMethodBeat.o(78118);
  }
  
  /* Error */
  private static Addr b(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 229	com/tencent/mm/sdk/platformtools/aa:dsG	()Ljava/lang/String;
    //   8: astore 12
    //   10: new 79	com/tencent/mm/modelgeo/Addr
    //   13: dup
    //   14: invokespecial 80	com/tencent/mm/modelgeo/Addr:<init>	()V
    //   17: astore 11
    //   19: iload 4
    //   21: ifeq +306 -> 327
    //   24: ldc 231
    //   26: iconst_3
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: dload_0
    //   33: invokestatic 236	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: dload_2
    //   40: invokestatic 236	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: aload 12
    //   48: aastore
    //   49: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore 6
    //   54: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   57: ldc 244
    //   59: aload 6
    //   61: invokestatic 247	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual 251	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aconst_null
    //   71: astore 10
    //   73: aconst_null
    //   74: astore 9
    //   76: aconst_null
    //   77: astore 7
    //   79: aload 6
    //   81: aconst_null
    //   82: invokestatic 259	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   85: astore 6
    //   87: aload 6
    //   89: astore 7
    //   91: aload 6
    //   93: astore 10
    //   95: aload 6
    //   97: astore 9
    //   99: aload 6
    //   101: sipush 10000
    //   104: invokevirtual 264	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   107: aload 6
    //   109: astore 7
    //   111: aload 6
    //   113: astore 10
    //   115: aload 6
    //   117: astore 9
    //   119: aload 6
    //   121: ldc_w 266
    //   124: invokevirtual 270	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   127: aload 6
    //   129: astore 7
    //   131: aload 6
    //   133: astore 10
    //   135: aload 6
    //   137: astore 9
    //   139: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   142: new 272	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 274
    //   149: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload 6
    //   154: invokevirtual 279	com/tencent/mm/network/v:getResponseCode	()I
    //   157: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload 6
    //   168: astore 7
    //   170: aload 6
    //   172: astore 10
    //   174: aload 6
    //   176: astore 9
    //   178: new 286	java/io/InputStreamReader
    //   181: dup
    //   182: aload 6
    //   184: invokevirtual 290	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   187: invokespecial 293	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   190: astore 8
    //   192: aload 6
    //   194: astore 7
    //   196: new 295	java/io/BufferedReader
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 298	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   205: astore 9
    //   207: aload 6
    //   209: astore 7
    //   211: new 300	java/lang/StringBuffer
    //   214: dup
    //   215: invokespecial 301	java/lang/StringBuffer:<init>	()V
    //   218: astore 10
    //   220: aload 6
    //   222: astore 7
    //   224: aload 9
    //   226: invokevirtual 304	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   229: astore 13
    //   231: aload 13
    //   233: ifnull +128 -> 361
    //   236: aload 6
    //   238: astore 7
    //   240: aload 10
    //   242: aload 13
    //   244: invokevirtual 307	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   247: pop
    //   248: goto -28 -> 220
    //   251: astore 10
    //   253: aload 6
    //   255: astore 7
    //   257: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   260: ldc_w 309
    //   263: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 6
    //   268: astore 7
    //   270: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   273: ldc_w 311
    //   276: iconst_1
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload 10
    //   284: invokestatic 315	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 317	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload 8
    //   293: astore 7
    //   295: aload 6
    //   297: ifnull +12 -> 309
    //   300: aload 6
    //   302: invokevirtual 320	com/tencent/mm/network/v:disconnect	()V
    //   305: aload 8
    //   307: astore 7
    //   309: aload 7
    //   311: ifnull +8 -> 319
    //   314: aload 7
    //   316: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   319: ldc 224
    //   321: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload 11
    //   326: areturn
    //   327: ldc 231
    //   329: iconst_3
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: dload_0
    //   336: invokestatic 236	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: dload_2
    //   343: invokestatic 236	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   346: aastore
    //   347: dup
    //   348: iconst_2
    //   349: ldc_w 325
    //   352: aastore
    //   353: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   356: astore 6
    //   358: goto -304 -> 54
    //   361: aload 6
    //   363: astore 7
    //   365: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   368: new 272	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 327
    //   375: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: aload 10
    //   380: invokevirtual 328	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   383: invokevirtual 331	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload 6
    //   394: astore 7
    //   396: new 333	org/json/JSONObject
    //   399: dup
    //   400: aload 10
    //   402: invokevirtual 328	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   405: invokespecial 334	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   408: ldc_w 336
    //   411: invokevirtual 340	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   414: astore 10
    //   416: aload 6
    //   418: astore 7
    //   420: aload 10
    //   422: iconst_0
    //   423: invokevirtual 346	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   426: astore 9
    //   428: aload 6
    //   430: astore 7
    //   432: aload 11
    //   434: aload 9
    //   436: ldc_w 348
    //   439: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   442: putfield 354	com/tencent/mm/modelgeo/Addr:fBq	Ljava/lang/String;
    //   445: aload 6
    //   447: astore 7
    //   449: aload 10
    //   451: iconst_0
    //   452: invokevirtual 346	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   455: ldc_w 356
    //   458: invokevirtual 340	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   461: astore 13
    //   463: iconst_0
    //   464: istore 5
    //   466: aload 6
    //   468: astore 7
    //   470: iload 5
    //   472: aload 13
    //   474: invokevirtual 359	org/json/JSONArray:length	()I
    //   477: if_icmpge +271 -> 748
    //   480: aload 6
    //   482: astore 7
    //   484: aload 13
    //   486: iload 5
    //   488: invokevirtual 346	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   491: astore 14
    //   493: aload 6
    //   495: astore 7
    //   497: aload 14
    //   499: ldc_w 361
    //   502: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore 10
    //   507: aload 6
    //   509: astore 7
    //   511: aload 14
    //   513: ldc_w 363
    //   516: invokevirtual 340	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   519: iconst_0
    //   520: invokevirtual 366	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   523: astore 14
    //   525: aload 6
    //   527: astore 7
    //   529: aload 14
    //   531: ldc_w 368
    //   534: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   537: ifeq +17 -> 554
    //   540: aload 6
    //   542: astore 7
    //   544: aload 11
    //   546: aload 10
    //   548: putfield 372	com/tencent/mm/modelgeo/Addr:fBr	Ljava/lang/String;
    //   551: goto +564 -> 1115
    //   554: aload 6
    //   556: astore 7
    //   558: aload 14
    //   560: ldc_w 374
    //   563: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   566: ifeq +17 -> 583
    //   569: aload 6
    //   571: astore 7
    //   573: aload 11
    //   575: aload 10
    //   577: putfield 377	com/tencent/mm/modelgeo/Addr:fBs	Ljava/lang/String;
    //   580: goto +535 -> 1115
    //   583: aload 6
    //   585: astore 7
    //   587: aload 14
    //   589: ldc_w 379
    //   592: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   595: ifeq +37 -> 632
    //   598: aload 6
    //   600: astore 7
    //   602: aload 11
    //   604: aload 10
    //   606: putfield 382	com/tencent/mm/modelgeo/Addr:fBu	Ljava/lang/String;
    //   609: goto +506 -> 1115
    //   612: astore 6
    //   614: aload 7
    //   616: ifnull +8 -> 624
    //   619: aload 7
    //   621: invokevirtual 320	com/tencent/mm/network/v:disconnect	()V
    //   624: ldc 224
    //   626: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: aload 6
    //   631: athrow
    //   632: aload 6
    //   634: astore 7
    //   636: aload 14
    //   638: ldc_w 384
    //   641: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +17 -> 661
    //   647: aload 6
    //   649: astore 7
    //   651: aload 11
    //   653: aload 10
    //   655: putfield 387	com/tencent/mm/modelgeo/Addr:fBv	Ljava/lang/String;
    //   658: goto +457 -> 1115
    //   661: aload 6
    //   663: astore 7
    //   665: aload 14
    //   667: ldc_w 389
    //   670: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   673: ifeq +17 -> 690
    //   676: aload 6
    //   678: astore 7
    //   680: aload 11
    //   682: aload 10
    //   684: putfield 392	com/tencent/mm/modelgeo/Addr:fBw	Ljava/lang/String;
    //   687: goto +428 -> 1115
    //   690: aload 6
    //   692: astore 7
    //   694: aload 14
    //   696: ldc_w 394
    //   699: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   702: ifeq +17 -> 719
    //   705: aload 6
    //   707: astore 7
    //   709: aload 11
    //   711: aload 10
    //   713: putfield 397	com/tencent/mm/modelgeo/Addr:fBx	Ljava/lang/String;
    //   716: goto +399 -> 1115
    //   719: aload 6
    //   721: astore 7
    //   723: aload 14
    //   725: ldc_w 399
    //   728: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   731: ifeq +384 -> 1115
    //   734: aload 6
    //   736: astore 7
    //   738: aload 11
    //   740: aload 10
    //   742: putfield 401	com/tencent/mm/modelgeo/Addr:country	Ljava/lang/String;
    //   745: goto +370 -> 1115
    //   748: aload 6
    //   750: astore 7
    //   752: aload 11
    //   754: getfield 354	com/tencent/mm/modelgeo/Addr:fBq	Ljava/lang/String;
    //   757: ldc_w 403
    //   760: invokestatic 409	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   763: astore 10
    //   765: aload 6
    //   767: astore 7
    //   769: aload 13
    //   771: invokevirtual 410	org/json/JSONArray:toString	()Ljava/lang/String;
    //   774: ldc_w 403
    //   777: invokestatic 409	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   780: astore 13
    //   782: aload 6
    //   784: astore 7
    //   786: aload 9
    //   788: ldc_w 412
    //   791: invokevirtual 415	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   794: invokevirtual 416	org/json/JSONObject:toString	()Ljava/lang/String;
    //   797: ldc_w 403
    //   800: invokestatic 409	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   803: astore 14
    //   805: aload 6
    //   807: astore 7
    //   809: aload 9
    //   811: ldc_w 418
    //   814: invokevirtual 351	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   817: ldc_w 403
    //   820: invokestatic 409	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   823: astore 15
    //   825: aload 6
    //   827: astore 7
    //   829: aload 9
    //   831: ldc_w 363
    //   834: invokevirtual 340	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   837: invokevirtual 410	org/json/JSONArray:toString	()Ljava/lang/String;
    //   840: ldc_w 403
    //   843: invokestatic 409	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   846: astore 9
    //   848: aload 6
    //   850: astore 7
    //   852: ldc_w 420
    //   855: iconst_2
    //   856: anewarray 4	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: dload_0
    //   862: invokestatic 236	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   865: aastore
    //   866: dup
    //   867: iconst_1
    //   868: dload_2
    //   869: invokestatic 236	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   872: aastore
    //   873: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   876: ldc_w 403
    //   879: invokestatic 409	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   882: astore 16
    //   884: aload 6
    //   886: astore 7
    //   888: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   891: ldc_w 422
    //   894: bipush 7
    //   896: anewarray 4	java/lang/Object
    //   899: dup
    //   900: iconst_0
    //   901: aload 10
    //   903: aastore
    //   904: dup
    //   905: iconst_1
    //   906: aload 13
    //   908: aastore
    //   909: dup
    //   910: iconst_2
    //   911: aload 14
    //   913: aastore
    //   914: dup
    //   915: iconst_3
    //   916: aload 15
    //   918: aastore
    //   919: dup
    //   920: iconst_4
    //   921: aload 9
    //   923: aastore
    //   924: dup
    //   925: iconst_5
    //   926: aload 16
    //   928: aastore
    //   929: dup
    //   930: bipush 6
    //   932: aload 12
    //   934: aastore
    //   935: invokestatic 148	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   938: aload 6
    //   940: astore 7
    //   942: getstatic 428	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   945: sipush 12886
    //   948: bipush 7
    //   950: anewarray 4	java/lang/Object
    //   953: dup
    //   954: iconst_0
    //   955: aload 13
    //   957: aastore
    //   958: dup
    //   959: iconst_1
    //   960: aload 10
    //   962: aastore
    //   963: dup
    //   964: iconst_2
    //   965: aload 14
    //   967: aastore
    //   968: dup
    //   969: iconst_3
    //   970: aload 15
    //   972: aastore
    //   973: dup
    //   974: iconst_4
    //   975: aload 9
    //   977: aastore
    //   978: dup
    //   979: iconst_5
    //   980: aload 16
    //   982: aastore
    //   983: dup
    //   984: bipush 6
    //   986: aload 12
    //   988: aastore
    //   989: invokevirtual 431	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   992: aload 6
    //   994: invokevirtual 320	com/tencent/mm/network/v:disconnect	()V
    //   997: aload 8
    //   999: astore 7
    //   1001: goto -692 -> 309
    //   1004: astore 9
    //   1006: aconst_null
    //   1007: astore 8
    //   1009: aload 10
    //   1011: astore 6
    //   1013: aload 6
    //   1015: astore 7
    //   1017: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1020: ldc_w 433
    //   1023: invokestatic 254	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1026: aload 6
    //   1028: astore 7
    //   1030: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1033: ldc_w 311
    //   1036: iconst_1
    //   1037: anewarray 4	java/lang/Object
    //   1040: dup
    //   1041: iconst_0
    //   1042: aload 9
    //   1044: invokestatic 315	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1047: aastore
    //   1048: invokestatic 317	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1051: aload 8
    //   1053: astore 7
    //   1055: aload 6
    //   1057: ifnull -748 -> 309
    //   1060: aload 6
    //   1062: invokevirtual 320	com/tencent/mm/network/v:disconnect	()V
    //   1065: aload 8
    //   1067: astore 7
    //   1069: goto -760 -> 309
    //   1072: astore 6
    //   1074: getstatic 36	com/tencent/mm/modelgeo/c:TAG	Ljava/lang/String;
    //   1077: ldc_w 311
    //   1080: iconst_1
    //   1081: anewarray 4	java/lang/Object
    //   1084: dup
    //   1085: iconst_0
    //   1086: aload 6
    //   1088: invokestatic 315	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1091: aastore
    //   1092: invokestatic 317	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1095: goto -776 -> 319
    //   1098: astore 9
    //   1100: goto -87 -> 1013
    //   1103: astore 10
    //   1105: aconst_null
    //   1106: astore 8
    //   1108: aload 9
    //   1110: astore 6
    //   1112: goto -859 -> 253
    //   1115: iload 5
    //   1117: iconst_1
    //   1118: iadd
    //   1119: istore 5
    //   1121: goto -655 -> 466
    //   1124: astore 7
    //   1126: goto -11 -> 1115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1129	0	paramDouble1	double
    //   0	1129	2	paramDouble2	double
    //   0	1129	4	paramBoolean	boolean
    //   464	656	5	i	int
    //   52	547	6	localObject1	Object
    //   612	381	6	localObject2	Object
    //   1011	50	6	localObject3	Object
    //   1072	15	6	localIOException1	java.io.IOException
    //   1110	1	6	localObject4	Object
    //   77	991	7	localObject5	Object
    //   1124	1	7	localException1	java.lang.Exception
    //   190	917	8	localInputStreamReader	java.io.InputStreamReader
    //   74	902	9	localObject6	Object
    //   1004	39	9	localException2	java.lang.Exception
    //   1098	11	9	localException3	java.lang.Exception
    //   71	170	10	localObject7	Object
    //   251	150	10	localIOException2	java.io.IOException
    //   414	596	10	localObject8	Object
    //   1103	1	10	localIOException3	java.io.IOException
    //   17	736	11	localAddr	Addr
    //   8	979	12	str1	String
    //   229	727	13	localObject9	Object
    //   491	475	14	localObject10	Object
    //   823	148	15	str2	String
    //   882	99	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   196	207	251	java/io/IOException
    //   211	220	251	java/io/IOException
    //   224	231	251	java/io/IOException
    //   240	248	251	java/io/IOException
    //   365	392	251	java/io/IOException
    //   396	416	251	java/io/IOException
    //   420	428	251	java/io/IOException
    //   432	445	251	java/io/IOException
    //   449	463	251	java/io/IOException
    //   470	480	251	java/io/IOException
    //   484	493	251	java/io/IOException
    //   497	507	251	java/io/IOException
    //   511	525	251	java/io/IOException
    //   529	540	251	java/io/IOException
    //   544	551	251	java/io/IOException
    //   558	569	251	java/io/IOException
    //   573	580	251	java/io/IOException
    //   587	598	251	java/io/IOException
    //   602	609	251	java/io/IOException
    //   636	647	251	java/io/IOException
    //   651	658	251	java/io/IOException
    //   665	676	251	java/io/IOException
    //   680	687	251	java/io/IOException
    //   694	705	251	java/io/IOException
    //   709	716	251	java/io/IOException
    //   723	734	251	java/io/IOException
    //   738	745	251	java/io/IOException
    //   752	765	251	java/io/IOException
    //   769	782	251	java/io/IOException
    //   786	805	251	java/io/IOException
    //   809	825	251	java/io/IOException
    //   829	848	251	java/io/IOException
    //   852	884	251	java/io/IOException
    //   888	938	251	java/io/IOException
    //   942	992	251	java/io/IOException
    //   79	87	612	finally
    //   99	107	612	finally
    //   119	127	612	finally
    //   139	166	612	finally
    //   178	192	612	finally
    //   196	207	612	finally
    //   211	220	612	finally
    //   224	231	612	finally
    //   240	248	612	finally
    //   257	266	612	finally
    //   270	291	612	finally
    //   365	392	612	finally
    //   396	416	612	finally
    //   420	428	612	finally
    //   432	445	612	finally
    //   449	463	612	finally
    //   470	480	612	finally
    //   484	493	612	finally
    //   497	507	612	finally
    //   511	525	612	finally
    //   529	540	612	finally
    //   544	551	612	finally
    //   558	569	612	finally
    //   573	580	612	finally
    //   587	598	612	finally
    //   602	609	612	finally
    //   636	647	612	finally
    //   651	658	612	finally
    //   665	676	612	finally
    //   680	687	612	finally
    //   694	705	612	finally
    //   709	716	612	finally
    //   723	734	612	finally
    //   738	745	612	finally
    //   752	765	612	finally
    //   769	782	612	finally
    //   786	805	612	finally
    //   809	825	612	finally
    //   829	848	612	finally
    //   852	884	612	finally
    //   888	938	612	finally
    //   942	992	612	finally
    //   1017	1026	612	finally
    //   1030	1051	612	finally
    //   79	87	1004	java/lang/Exception
    //   99	107	1004	java/lang/Exception
    //   119	127	1004	java/lang/Exception
    //   139	166	1004	java/lang/Exception
    //   178	192	1004	java/lang/Exception
    //   314	319	1072	java/io/IOException
    //   196	207	1098	java/lang/Exception
    //   211	220	1098	java/lang/Exception
    //   224	231	1098	java/lang/Exception
    //   240	248	1098	java/lang/Exception
    //   365	392	1098	java/lang/Exception
    //   396	416	1098	java/lang/Exception
    //   420	428	1098	java/lang/Exception
    //   432	445	1098	java/lang/Exception
    //   449	463	1098	java/lang/Exception
    //   470	480	1098	java/lang/Exception
    //   484	493	1098	java/lang/Exception
    //   752	765	1098	java/lang/Exception
    //   769	782	1098	java/lang/Exception
    //   786	805	1098	java/lang/Exception
    //   809	825	1098	java/lang/Exception
    //   829	848	1098	java/lang/Exception
    //   852	884	1098	java/lang/Exception
    //   888	938	1098	java/lang/Exception
    //   942	992	1098	java/lang/Exception
    //   79	87	1103	java/io/IOException
    //   99	107	1103	java/io/IOException
    //   119	127	1103	java/io/IOException
    //   139	166	1103	java/io/IOException
    //   178	192	1103	java/io/IOException
    //   497	507	1124	java/lang/Exception
    //   511	525	1124	java/lang/Exception
    //   529	540	1124	java/lang/Exception
    //   544	551	1124	java/lang/Exception
    //   558	569	1124	java/lang/Exception
    //   573	580	1124	java/lang/Exception
    //   587	598	1124	java/lang/Exception
    //   602	609	1124	java/lang/Exception
    //   636	647	1124	java/lang/Exception
    //   651	658	1124	java/lang/Exception
    //   665	676	1124	java/lang/Exception
    //   680	687	1124	java/lang/Exception
    //   694	705	1124	java/lang/Exception
    //   709	716	1124	java/lang/Exception
    //   723	734	1124	java/lang/Exception
    //   738	745	1124	java/lang/Exception
  }
  
  private static boolean b(CopyOnWriteArrayList<WeakReference<c.a>> paramCopyOnWriteArrayList, c.a parama)
  {
    AppMethodBeat.i(78114);
    if (paramCopyOnWriteArrayList == null)
    {
      AppMethodBeat.o(78114);
      return false;
    }
    Iterator localIterator = paramCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((c.a)localWeakReference.get()).equals(parama)))
      {
        paramCopyOnWriteArrayList.remove(localWeakReference);
        AppMethodBeat.o(78114);
        return true;
      }
    }
    AppMethodBeat.o(78114);
    return false;
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, c.a parama)
  {
    AppMethodBeat.i(78116);
    boolean bool = a(paramDouble1, paramDouble2, parama, null);
    AppMethodBeat.o(78116);
    return bool;
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, c.a parama, Object paramObject)
  {
    AppMethodBeat.i(78115);
    if (paramObject != null)
    {
      localObject = this.fBH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        if ((localc != null) && (localc.tag != null) && (localc.tag.equals(paramObject))) {
          this.fBH.remove(localc);
        }
      }
    }
    c localc = new c(paramDouble1, paramDouble2, paramObject);
    Object localObject = (CopyOnWriteArrayList)this.bat.get(localc.toString());
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new CopyOnWriteArrayList();
    }
    if (!a(paramObject, parama)) {
      paramObject.add(new WeakReference(parama));
    }
    this.bat.put(localc.toString(), paramObject);
    parama = this.fBH.iterator();
    while (parama.hasNext()) {
      if (((c)parama.next()).equals(localc))
      {
        agO();
        AppMethodBeat.o(78115);
        return false;
      }
    }
    if ((this.fBG != null) && (localc.equals(this.fBG)))
    {
      AppMethodBeat.o(78115);
      return false;
    }
    this.fBH.add(localc);
    ab.i(TAG, "push task size %d listeners %d", new Object[] { Integer.valueOf(this.fBH.size()), Integer.valueOf(this.bat.size()) });
    while (this.fBH.size() > 30)
    {
      ab.i(TAG, "force remove task");
      parama = (c)this.fBH.remove(0);
      if (parama != null) {
        this.bat.remove(parama.toString());
      }
    }
    agO();
    AppMethodBeat.o(78115);
    return true;
  }
  
  public final boolean a(c.a parama)
  {
    AppMethodBeat.i(78112);
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    Object localObject3 = this.bat.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.bat.get(str);
      b(localCopyOnWriteArrayList, parama);
      this.bat.put(str, localCopyOnWriteArrayList);
      if ((localCopyOnWriteArrayList == null) || (localCopyOnWriteArrayList.size() == 0)) {
        ((LinkedList)localObject2).add(str);
      }
    }
    parama = ((LinkedList)localObject2).iterator();
    while (parama.hasNext())
    {
      localObject2 = (String)parama.next();
      this.bat.remove(localObject2);
    }
    parama = this.fBH.iterator();
    while (parama.hasNext())
    {
      localObject2 = (c)parama.next();
      localObject3 = (CopyOnWriteArrayList)this.bat.get(((c)localObject2).toString());
      if ((localObject3 == null) || (((CopyOnWriteArrayList)localObject3).size() == 0))
      {
        ((LinkedList)localObject1).add(localObject2);
        this.bat.remove(((c)localObject2).toString());
      }
    }
    parama = ((LinkedList)localObject1).iterator();
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.fBH.remove(localObject1);
    }
    ab.i(TAG, "remove taskLists %d listeners size %d", new Object[] { Integer.valueOf(this.fBH.size()), Integer.valueOf(this.bat.size()) });
    AppMethodBeat.o(78112);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78121);
    if (paramm.getType() == 655)
    {
      paramString = ((e)paramm).agU();
      if ((paramString == null) || (paramString.fBq == null) || (paramString.fBq.equals("")))
      {
        this.fBI.e(new b());
        AppMethodBeat.o(78121);
        return;
      }
      a(paramString);
    }
    AppMethodBeat.o(78121);
  }
  
  final class b
    implements az.a
  {
    private Addr fBK = null;
    
    public b() {}
    
    public final boolean acS()
    {
      AppMethodBeat.i(78106);
      if (c.a(c.this) == null)
      {
        AppMethodBeat.o(78106);
        return false;
      }
      if ((this.fBK == null) || (this.fBK.fBq == null) || (this.fBK.fBq.equals(""))) {
        this.fBK = c.c(c.a(c.this).lat, c.a(c.this).lng, c.b(c.this));
      }
      AppMethodBeat.o(78106);
      return true;
    }
    
    public final boolean acT()
    {
      AppMethodBeat.i(78107);
      c.c(c.this);
      c.a(c.this, this.fBK);
      AppMethodBeat.o(78107);
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
      AppMethodBeat.i(78109);
      if ((paramObject == null) || (!(paramObject instanceof c)))
      {
        AppMethodBeat.o(78109);
        return false;
      }
      boolean bool = ((c)paramObject).toString().equals(toString());
      AppMethodBeat.o(78109);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(78108);
      StringBuilder localStringBuilder = new StringBuilder().append((int)(this.lat * 1000000.0D)).append((int)(this.lng * 1000000.0D));
      String str;
      if (this.tag == null) {
        str = "";
      }
      for (;;)
      {
        str = str;
        AppMethodBeat.o(78108);
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