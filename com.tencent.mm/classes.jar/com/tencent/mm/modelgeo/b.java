package com.tencent.mm.modelgeo;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class b
  implements f
{
  public static String TAG = "MicroMsg.LocationAddr";
  private static b elm;
  private c eln = null;
  private LinkedList<c> elo = new LinkedList();
  private HashMap<String, LinkedList<WeakReference<a>>> elp = new HashMap();
  private av elq = new av(1, "addr_worker");
  private boolean elr = true;
  
  public static b NZ()
  {
    if (elm == null) {
      elm = new b();
    }
    return elm;
  }
  
  private void Oa()
  {
    if ((this.eln == null) && (this.elo != null) && (this.elo.size() > 0))
    {
      this.eln = ((c)this.elo.removeFirst());
      if (bk.fV(ae.getContext())) {
        this.elq.c(new b());
      }
    }
    else
    {
      return;
    }
    g.Dk().a(655, this);
    g.Dk().a(new d(this.eln.lat, this.eln.lng), 0);
  }
  
  private void a(Addr paramAddr)
  {
    if (this.eln == null) {}
    label251:
    do
    {
      return;
      Addr localAddr = paramAddr;
      if (paramAddr == null) {
        localAddr = new Addr();
      }
      if (this.eln.tag == null)
      {
        paramAddr = new Object();
        localAddr.tag = paramAddr;
        localAddr.elk = ((float)this.eln.lat);
        localAddr.ell = ((float)this.eln.lng);
        if (!bk.bl(localAddr.elb))
        {
          paramAddr = ae.getContext().getResources().getString(a.h.filter_city_name);
          y.d(TAG, "city %s", new Object[] { paramAddr });
          if ((bk.fV(ae.getContext())) || (bk.bl(paramAddr)) || (!localAddr.elb.endsWith(paramAddr))) {
            break label251;
          }
          localAddr.elc = localAddr.elb;
          localAddr.elb = localAddr.elb.substring(0, localAddr.elb.length() - paramAddr.length());
        }
      }
      for (;;)
      {
        paramAddr = (LinkedList)this.elp.get(this.eln.toString());
        if (paramAddr == null) {
          break label317;
        }
        paramAddr = paramAddr.iterator();
        while (paramAddr.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)paramAddr.next();
          if ((localWeakReference != null) && (localWeakReference.get() != null)) {
            ((a)localWeakReference.get()).b(localAddr);
          }
        }
        paramAddr = this.eln.tag;
        break;
        if ((!bk.fV(ae.getContext())) && (!bk.bl(paramAddr)) && (localAddr.ekZ.indexOf(paramAddr) >= 0)) {
          localAddr.elc = (localAddr.elb + paramAddr);
        } else {
          localAddr.elc = localAddr.elb;
        }
      }
      this.elp.remove(this.eln.toString());
      y.d(TAG, "postexecute2 listeners %d", new Object[] { Integer.valueOf(this.elp.size()) });
      this.eln = null;
      Oa();
    } while ((this.eln != null) || (this.elo.size() <= 0));
    label317:
    g.Dk().b(655, this);
  }
  
  private static boolean a(LinkedList<WeakReference<a>> paramLinkedList, a parama)
  {
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramLinkedList.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private static Addr b(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 265	com/tencent/mm/sdk/platformtools/x:cqJ	()Ljava/lang/String;
    //   3: astore 12
    //   5: new 126	com/tencent/mm/modelgeo/Addr
    //   8: dup
    //   9: invokespecial 127	com/tencent/mm/modelgeo/Addr:<init>	()V
    //   12: astore 11
    //   14: iload 4
    //   16: ifeq +313 -> 329
    //   19: ldc_w 267
    //   22: iconst_3
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: dload_0
    //   29: invokestatic 272	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: dload_2
    //   36: invokestatic 272	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: aload 12
    //   44: aastore
    //   45: invokestatic 276	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore 6
    //   50: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   53: new 223	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 278
    //   60: invokespecial 281	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 6
    //   65: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 284	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aconst_null
    //   75: astore 10
    //   77: aconst_null
    //   78: astore 9
    //   80: aconst_null
    //   81: astore 7
    //   83: aload 6
    //   85: aconst_null
    //   86: invokestatic 289	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
    //   89: astore 6
    //   91: aload 6
    //   93: astore 7
    //   95: aload 6
    //   97: astore 10
    //   99: aload 6
    //   101: astore 9
    //   103: aload 6
    //   105: sipush 10000
    //   108: invokevirtual 295	com/tencent/mm/network/u:setConnectTimeout	(I)V
    //   111: aload 6
    //   113: astore 7
    //   115: aload 6
    //   117: astore 10
    //   119: aload 6
    //   121: astore 9
    //   123: aload 6
    //   125: ldc_w 297
    //   128: invokevirtual 300	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
    //   131: aload 6
    //   133: astore 7
    //   135: aload 6
    //   137: astore 10
    //   139: aload 6
    //   141: astore 9
    //   143: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   146: new 223	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 302
    //   153: invokespecial 281	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload 6
    //   158: invokevirtual 305	com/tencent/mm/network/u:getResponseCode	()I
    //   161: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 284	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 6
    //   172: astore 7
    //   174: aload 6
    //   176: astore 10
    //   178: aload 6
    //   180: astore 9
    //   182: new 310	java/io/InputStreamReader
    //   185: dup
    //   186: aload 6
    //   188: invokevirtual 314	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
    //   191: invokespecial 317	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   194: astore 8
    //   196: aload 6
    //   198: astore 7
    //   200: new 319	java/io/BufferedReader
    //   203: dup
    //   204: aload 8
    //   206: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   209: astore 9
    //   211: aload 6
    //   213: astore 7
    //   215: new 324	java/lang/StringBuffer
    //   218: dup
    //   219: invokespecial 325	java/lang/StringBuffer:<init>	()V
    //   222: astore 10
    //   224: aload 6
    //   226: astore 7
    //   228: aload 9
    //   230: invokevirtual 328	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   233: astore 13
    //   235: aload 13
    //   237: ifnull +127 -> 364
    //   240: aload 6
    //   242: astore 7
    //   244: aload 10
    //   246: aload 13
    //   248: invokevirtual 331	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: pop
    //   252: goto -28 -> 224
    //   255: astore 10
    //   257: aload 6
    //   259: astore 7
    //   261: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   264: ldc_w 333
    //   267: invokestatic 284	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 6
    //   272: astore 7
    //   274: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   277: ldc_w 335
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 10
    //   288: invokestatic 339	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   291: aastore
    //   292: invokestatic 342	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: aload 8
    //   297: astore 7
    //   299: aload 6
    //   301: ifnull +15 -> 316
    //   304: aload 6
    //   306: getfield 346	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   309: invokevirtual 351	java/net/HttpURLConnection:disconnect	()V
    //   312: aload 8
    //   314: astore 7
    //   316: aload 7
    //   318: ifnull +8 -> 326
    //   321: aload 7
    //   323: invokevirtual 354	java/io/InputStreamReader:close	()V
    //   326: aload 11
    //   328: areturn
    //   329: ldc_w 267
    //   332: iconst_3
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: dload_0
    //   339: invokestatic 272	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: dload_2
    //   346: invokestatic 272	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   349: aastore
    //   350: dup
    //   351: iconst_2
    //   352: ldc_w 356
    //   355: aastore
    //   356: invokestatic 276	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   359: astore 6
    //   361: goto -311 -> 50
    //   364: aload 6
    //   366: astore 7
    //   368: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   371: new 223	java/lang/StringBuilder
    //   374: dup
    //   375: ldc_w 358
    //   378: invokespecial 281	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload 10
    //   383: invokevirtual 359	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   386: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 284	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 6
    //   397: astore 7
    //   399: new 361	org/json/JSONObject
    //   402: dup
    //   403: aload 10
    //   405: invokevirtual 359	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   408: invokespecial 362	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   411: ldc_w 364
    //   414: invokevirtual 368	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   417: astore 10
    //   419: aload 6
    //   421: astore 7
    //   423: aload 10
    //   425: iconst_0
    //   426: invokevirtual 374	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   429: astore 9
    //   431: aload 6
    //   433: astore 7
    //   435: aload 11
    //   437: aload 9
    //   439: ldc_w 376
    //   442: invokevirtual 379	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 217	com/tencent/mm/modelgeo/Addr:ekZ	Ljava/lang/String;
    //   448: aload 6
    //   450: astore 7
    //   452: aload 10
    //   454: iconst_0
    //   455: invokevirtual 374	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   458: ldc_w 381
    //   461: invokevirtual 368	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   464: astore 13
    //   466: iconst_0
    //   467: istore 5
    //   469: aload 6
    //   471: astore 7
    //   473: iload 5
    //   475: aload 13
    //   477: invokevirtual 382	org/json/JSONArray:length	()I
    //   480: if_icmpge +269 -> 749
    //   483: aload 6
    //   485: astore 7
    //   487: aload 13
    //   489: iload 5
    //   491: invokevirtual 374	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   494: astore 14
    //   496: aload 6
    //   498: astore 7
    //   500: aload 14
    //   502: ldc_w 384
    //   505: invokevirtual 379	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   508: astore 10
    //   510: aload 6
    //   512: astore 7
    //   514: aload 14
    //   516: ldc_w 386
    //   519: invokevirtual 368	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   522: iconst_0
    //   523: invokevirtual 387	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   526: astore 14
    //   528: aload 6
    //   530: astore 7
    //   532: aload 14
    //   534: ldc_w 389
    //   537: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   540: ifeq +17 -> 557
    //   543: aload 6
    //   545: astore 7
    //   547: aload 11
    //   549: aload 10
    //   551: putfield 393	com/tencent/mm/modelgeo/Addr:ela	Ljava/lang/String;
    //   554: goto +568 -> 1122
    //   557: aload 6
    //   559: astore 7
    //   561: aload 14
    //   563: ldc_w 395
    //   566: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   569: ifeq +17 -> 586
    //   572: aload 6
    //   574: astore 7
    //   576: aload 11
    //   578: aload 10
    //   580: putfield 142	com/tencent/mm/modelgeo/Addr:elb	Ljava/lang/String;
    //   583: goto +539 -> 1122
    //   586: aload 6
    //   588: astore 7
    //   590: aload 14
    //   592: ldc_w 397
    //   595: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +35 -> 633
    //   601: aload 6
    //   603: astore 7
    //   605: aload 11
    //   607: aload 10
    //   609: putfield 400	com/tencent/mm/modelgeo/Addr:eld	Ljava/lang/String;
    //   612: goto +510 -> 1122
    //   615: astore 6
    //   617: aload 7
    //   619: ifnull +11 -> 630
    //   622: aload 7
    //   624: getfield 346	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   627: invokevirtual 351	java/net/HttpURLConnection:disconnect	()V
    //   630: aload 6
    //   632: athrow
    //   633: aload 6
    //   635: astore 7
    //   637: aload 14
    //   639: ldc_w 402
    //   642: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   645: ifeq +17 -> 662
    //   648: aload 6
    //   650: astore 7
    //   652: aload 11
    //   654: aload 10
    //   656: putfield 405	com/tencent/mm/modelgeo/Addr:ele	Ljava/lang/String;
    //   659: goto +463 -> 1122
    //   662: aload 6
    //   664: astore 7
    //   666: aload 14
    //   668: ldc_w 407
    //   671: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   674: ifeq +17 -> 691
    //   677: aload 6
    //   679: astore 7
    //   681: aload 11
    //   683: aload 10
    //   685: putfield 410	com/tencent/mm/modelgeo/Addr:elf	Ljava/lang/String;
    //   688: goto +434 -> 1122
    //   691: aload 6
    //   693: astore 7
    //   695: aload 14
    //   697: ldc_w 412
    //   700: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: ifeq +17 -> 720
    //   706: aload 6
    //   708: astore 7
    //   710: aload 11
    //   712: aload 10
    //   714: putfield 415	com/tencent/mm/modelgeo/Addr:elg	Ljava/lang/String;
    //   717: goto +405 -> 1122
    //   720: aload 6
    //   722: astore 7
    //   724: aload 14
    //   726: ldc_w 417
    //   729: invokevirtual 390	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   732: ifeq +390 -> 1122
    //   735: aload 6
    //   737: astore 7
    //   739: aload 11
    //   741: aload 10
    //   743: putfield 419	com/tencent/mm/modelgeo/Addr:country	Ljava/lang/String;
    //   746: goto +376 -> 1122
    //   749: aload 6
    //   751: astore 7
    //   753: aload 11
    //   755: getfield 217	com/tencent/mm/modelgeo/Addr:ekZ	Ljava/lang/String;
    //   758: ldc_w 421
    //   761: invokestatic 427	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   764: astore 10
    //   766: aload 6
    //   768: astore 7
    //   770: aload 13
    //   772: invokevirtual 428	org/json/JSONArray:toString	()Ljava/lang/String;
    //   775: ldc_w 421
    //   778: invokestatic 427	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   781: astore 13
    //   783: aload 6
    //   785: astore 7
    //   787: aload 9
    //   789: ldc_w 430
    //   792: invokevirtual 433	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   795: invokevirtual 434	org/json/JSONObject:toString	()Ljava/lang/String;
    //   798: ldc_w 421
    //   801: invokestatic 427	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   804: astore 14
    //   806: aload 6
    //   808: astore 7
    //   810: aload 9
    //   812: ldc_w 436
    //   815: invokevirtual 379	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   818: ldc_w 421
    //   821: invokestatic 427	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   824: astore 15
    //   826: aload 6
    //   828: astore 7
    //   830: aload 9
    //   832: ldc_w 386
    //   835: invokevirtual 368	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   838: invokevirtual 428	org/json/JSONArray:toString	()Ljava/lang/String;
    //   841: ldc_w 421
    //   844: invokestatic 427	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   847: astore 9
    //   849: aload 6
    //   851: astore 7
    //   853: ldc_w 438
    //   856: iconst_2
    //   857: anewarray 4	java/lang/Object
    //   860: dup
    //   861: iconst_0
    //   862: dload_0
    //   863: invokestatic 272	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   866: aastore
    //   867: dup
    //   868: iconst_1
    //   869: dload_2
    //   870: invokestatic 272	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   873: aastore
    //   874: invokestatic 276	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   877: ldc_w 421
    //   880: invokestatic 427	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   883: astore 16
    //   885: aload 6
    //   887: astore 7
    //   889: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   892: ldc_w 440
    //   895: bipush 7
    //   897: anewarray 4	java/lang/Object
    //   900: dup
    //   901: iconst_0
    //   902: aload 10
    //   904: aastore
    //   905: dup
    //   906: iconst_1
    //   907: aload 13
    //   909: aastore
    //   910: dup
    //   911: iconst_2
    //   912: aload 14
    //   914: aastore
    //   915: dup
    //   916: iconst_3
    //   917: aload 15
    //   919: aastore
    //   920: dup
    //   921: iconst_4
    //   922: aload 9
    //   924: aastore
    //   925: dup
    //   926: iconst_5
    //   927: aload 16
    //   929: aastore
    //   930: dup
    //   931: bipush 6
    //   933: aload 12
    //   935: aastore
    //   936: invokestatic 172	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   939: aload 6
    //   941: astore 7
    //   943: getstatic 446	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   946: sipush 12886
    //   949: bipush 7
    //   951: anewarray 4	java/lang/Object
    //   954: dup
    //   955: iconst_0
    //   956: aload 13
    //   958: aastore
    //   959: dup
    //   960: iconst_1
    //   961: aload 10
    //   963: aastore
    //   964: dup
    //   965: iconst_2
    //   966: aload 14
    //   968: aastore
    //   969: dup
    //   970: iconst_3
    //   971: aload 15
    //   973: aastore
    //   974: dup
    //   975: iconst_4
    //   976: aload 9
    //   978: aastore
    //   979: dup
    //   980: iconst_5
    //   981: aload 16
    //   983: aastore
    //   984: dup
    //   985: bipush 6
    //   987: aload 12
    //   989: aastore
    //   990: invokevirtual 450	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   993: aload 6
    //   995: getfield 346	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   998: invokevirtual 351	java/net/HttpURLConnection:disconnect	()V
    //   1001: aload 8
    //   1003: astore 7
    //   1005: goto -689 -> 316
    //   1008: astore 9
    //   1010: aconst_null
    //   1011: astore 8
    //   1013: aload 10
    //   1015: astore 6
    //   1017: aload 6
    //   1019: astore 7
    //   1021: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   1024: ldc_w 452
    //   1027: invokestatic 284	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1030: aload 6
    //   1032: astore 7
    //   1034: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   1037: ldc_w 335
    //   1040: iconst_1
    //   1041: anewarray 4	java/lang/Object
    //   1044: dup
    //   1045: iconst_0
    //   1046: aload 9
    //   1048: invokestatic 339	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1051: aastore
    //   1052: invokestatic 342	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1055: aload 8
    //   1057: astore 7
    //   1059: aload 6
    //   1061: ifnull -745 -> 316
    //   1064: aload 6
    //   1066: getfield 346	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   1069: invokevirtual 351	java/net/HttpURLConnection:disconnect	()V
    //   1072: aload 8
    //   1074: astore 7
    //   1076: goto -760 -> 316
    //   1079: astore 6
    //   1081: getstatic 37	com/tencent/mm/modelgeo/b:TAG	Ljava/lang/String;
    //   1084: ldc_w 335
    //   1087: iconst_1
    //   1088: anewarray 4	java/lang/Object
    //   1091: dup
    //   1092: iconst_0
    //   1093: aload 6
    //   1095: invokestatic 339	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1098: aastore
    //   1099: invokestatic 342	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1102: aload 11
    //   1104: areturn
    //   1105: astore 9
    //   1107: goto -90 -> 1017
    //   1110: astore 10
    //   1112: aconst_null
    //   1113: astore 8
    //   1115: aload 9
    //   1117: astore 6
    //   1119: goto -862 -> 257
    //   1122: iload 5
    //   1124: iconst_1
    //   1125: iadd
    //   1126: istore 5
    //   1128: goto -659 -> 469
    //   1131: astore 7
    //   1133: goto -11 -> 1122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	paramDouble1	double
    //   0	1136	2	paramDouble2	double
    //   0	1136	4	paramBoolean	boolean
    //   467	660	5	i	int
    //   48	554	6	localObject1	Object
    //   615	379	6	localObject2	Object
    //   1015	50	6	localObject3	Object
    //   1079	15	6	localIOException1	java.io.IOException
    //   1117	1	6	localObject4	Object
    //   81	994	7	localObject5	Object
    //   1131	1	7	localException1	java.lang.Exception
    //   194	920	8	localInputStreamReader	java.io.InputStreamReader
    //   78	899	9	localObject6	Object
    //   1008	39	9	localException2	java.lang.Exception
    //   1105	11	9	localException3	java.lang.Exception
    //   75	170	10	localObject7	Object
    //   255	149	10	localIOException2	java.io.IOException
    //   417	597	10	localObject8	Object
    //   1110	1	10	localIOException3	java.io.IOException
    //   12	1091	11	localAddr	Addr
    //   3	985	12	str1	String
    //   233	724	13	localObject9	Object
    //   494	473	14	localObject10	Object
    //   824	148	15	str2	String
    //   883	99	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   200	211	255	java/io/IOException
    //   215	224	255	java/io/IOException
    //   228	235	255	java/io/IOException
    //   244	252	255	java/io/IOException
    //   368	395	255	java/io/IOException
    //   399	419	255	java/io/IOException
    //   423	431	255	java/io/IOException
    //   435	448	255	java/io/IOException
    //   452	466	255	java/io/IOException
    //   473	483	255	java/io/IOException
    //   487	496	255	java/io/IOException
    //   500	510	255	java/io/IOException
    //   514	528	255	java/io/IOException
    //   532	543	255	java/io/IOException
    //   547	554	255	java/io/IOException
    //   561	572	255	java/io/IOException
    //   576	583	255	java/io/IOException
    //   590	601	255	java/io/IOException
    //   605	612	255	java/io/IOException
    //   637	648	255	java/io/IOException
    //   652	659	255	java/io/IOException
    //   666	677	255	java/io/IOException
    //   681	688	255	java/io/IOException
    //   695	706	255	java/io/IOException
    //   710	717	255	java/io/IOException
    //   724	735	255	java/io/IOException
    //   739	746	255	java/io/IOException
    //   753	766	255	java/io/IOException
    //   770	783	255	java/io/IOException
    //   787	806	255	java/io/IOException
    //   810	826	255	java/io/IOException
    //   830	849	255	java/io/IOException
    //   853	885	255	java/io/IOException
    //   889	939	255	java/io/IOException
    //   943	993	255	java/io/IOException
    //   83	91	615	finally
    //   103	111	615	finally
    //   123	131	615	finally
    //   143	170	615	finally
    //   182	196	615	finally
    //   200	211	615	finally
    //   215	224	615	finally
    //   228	235	615	finally
    //   244	252	615	finally
    //   261	270	615	finally
    //   274	295	615	finally
    //   368	395	615	finally
    //   399	419	615	finally
    //   423	431	615	finally
    //   435	448	615	finally
    //   452	466	615	finally
    //   473	483	615	finally
    //   487	496	615	finally
    //   500	510	615	finally
    //   514	528	615	finally
    //   532	543	615	finally
    //   547	554	615	finally
    //   561	572	615	finally
    //   576	583	615	finally
    //   590	601	615	finally
    //   605	612	615	finally
    //   637	648	615	finally
    //   652	659	615	finally
    //   666	677	615	finally
    //   681	688	615	finally
    //   695	706	615	finally
    //   710	717	615	finally
    //   724	735	615	finally
    //   739	746	615	finally
    //   753	766	615	finally
    //   770	783	615	finally
    //   787	806	615	finally
    //   810	826	615	finally
    //   830	849	615	finally
    //   853	885	615	finally
    //   889	939	615	finally
    //   943	993	615	finally
    //   1021	1030	615	finally
    //   1034	1055	615	finally
    //   83	91	1008	java/lang/Exception
    //   103	111	1008	java/lang/Exception
    //   123	131	1008	java/lang/Exception
    //   143	170	1008	java/lang/Exception
    //   182	196	1008	java/lang/Exception
    //   321	326	1079	java/io/IOException
    //   200	211	1105	java/lang/Exception
    //   215	224	1105	java/lang/Exception
    //   228	235	1105	java/lang/Exception
    //   244	252	1105	java/lang/Exception
    //   368	395	1105	java/lang/Exception
    //   399	419	1105	java/lang/Exception
    //   423	431	1105	java/lang/Exception
    //   435	448	1105	java/lang/Exception
    //   452	466	1105	java/lang/Exception
    //   473	483	1105	java/lang/Exception
    //   487	496	1105	java/lang/Exception
    //   753	766	1105	java/lang/Exception
    //   770	783	1105	java/lang/Exception
    //   787	806	1105	java/lang/Exception
    //   810	826	1105	java/lang/Exception
    //   830	849	1105	java/lang/Exception
    //   853	885	1105	java/lang/Exception
    //   889	939	1105	java/lang/Exception
    //   943	993	1105	java/lang/Exception
    //   83	91	1110	java/io/IOException
    //   103	111	1110	java/io/IOException
    //   123	131	1110	java/io/IOException
    //   143	170	1110	java/io/IOException
    //   182	196	1110	java/io/IOException
    //   500	510	1131	java/lang/Exception
    //   514	528	1131	java/lang/Exception
    //   532	543	1131	java/lang/Exception
    //   547	554	1131	java/lang/Exception
    //   561	572	1131	java/lang/Exception
    //   576	583	1131	java/lang/Exception
    //   590	601	1131	java/lang/Exception
    //   605	612	1131	java/lang/Exception
    //   637	648	1131	java/lang/Exception
    //   652	659	1131	java/lang/Exception
    //   666	677	1131	java/lang/Exception
    //   681	688	1131	java/lang/Exception
    //   695	706	1131	java/lang/Exception
    //   710	717	1131	java/lang/Exception
    //   724	735	1131	java/lang/Exception
    //   739	746	1131	java/lang/Exception
  }
  
  private static boolean b(LinkedList<WeakReference<a>> paramLinkedList, a parama)
  {
    if (paramLinkedList == null) {
      return false;
    }
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama)))
      {
        paramLinkedList.remove(localWeakReference);
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, a parama)
  {
    return a(paramDouble1, paramDouble2, parama, null);
  }
  
  public final boolean a(double paramDouble1, double paramDouble2, a parama, Object paramObject)
  {
    if (paramObject != null)
    {
      localObject = this.elo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localc = (c)((Iterator)localObject).next();
        if ((localc != null) && (localc.tag != null) && (localc.tag.equals(paramObject))) {
          this.elo.remove(localc);
        }
      }
    }
    c localc = new c(paramDouble1, paramDouble2, paramObject);
    Object localObject = (LinkedList)this.elp.get(localc.toString());
    paramObject = localObject;
    if (localObject == null) {
      paramObject = new LinkedList();
    }
    if (!a(paramObject, parama)) {
      paramObject.add(new WeakReference(parama));
    }
    this.elp.put(localc.toString(), paramObject);
    parama = this.elo.iterator();
    while (parama.hasNext()) {
      if (((c)parama.next()).equals(localc))
      {
        Oa();
        return false;
      }
    }
    if ((this.eln != null) && (localc.equals(this.eln))) {
      return false;
    }
    this.elo.add(localc);
    y.i(TAG, "push task size %d listeners %d", new Object[] { Integer.valueOf(this.elo.size()), Integer.valueOf(this.elp.size()) });
    while (this.elo.size() > 30)
    {
      y.i(TAG, "force remove task");
      parama = (c)this.elo.removeFirst();
      if (parama != null) {
        this.elp.remove(parama.toString());
      }
    }
    Oa();
    return true;
  }
  
  public final boolean a(a parama)
  {
    Object localObject1 = new LinkedList();
    Object localObject2 = new LinkedList();
    Object localObject3 = this.elp.keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      LinkedList localLinkedList = (LinkedList)this.elp.get(str);
      b(localLinkedList, parama);
      this.elp.put(str, localLinkedList);
      if ((localLinkedList == null) || (localLinkedList.size() == 0)) {
        ((LinkedList)localObject2).add(str);
      }
    }
    parama = ((LinkedList)localObject2).iterator();
    while (parama.hasNext())
    {
      localObject2 = (String)parama.next();
      this.elp.remove(localObject2);
    }
    parama = this.elo.iterator();
    while (parama.hasNext())
    {
      localObject2 = (c)parama.next();
      localObject3 = (LinkedList)this.elp.get(((c)localObject2).toString());
      if ((localObject3 == null) || (((LinkedList)localObject3).size() == 0))
      {
        ((LinkedList)localObject1).add(localObject2);
        this.elp.remove(((c)localObject2).toString());
      }
    }
    parama = ((LinkedList)localObject1).iterator();
    while (parama.hasNext())
    {
      localObject1 = (c)parama.next();
      this.elo.remove(localObject1);
    }
    y.i(TAG, "remove taskLists %d listeners size %d", new Object[] { Integer.valueOf(this.elo.size()), Integer.valueOf(this.elp.size()) });
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 655)
    {
      paramString = ((d)paramm).Of();
      if ((paramString == null) || (paramString.ekZ == null) || (paramString.ekZ.equals(""))) {
        this.elq.c(new b());
      }
    }
    else
    {
      return;
    }
    a(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void b(Addr paramAddr);
  }
  
  private final class b
    implements av.a
  {
    private Addr els = null;
    
    public b() {}
    
    public final boolean JS()
    {
      if (b.a(b.this) == null) {
        return false;
      }
      if ((this.els == null) || (this.els.ekZ == null) || (this.els.ekZ.equals(""))) {
        this.els = b.c(b.a(b.this).lat, b.a(b.this).lng, b.b(b.this));
      }
      return true;
    }
    
    public final boolean JT()
    {
      b.c(b.this);
      b.a(b.this, this.els);
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
      if ((paramObject == null) || (!(paramObject instanceof c))) {
        return false;
      }
      return ((c)paramObject).toString().equals(toString());
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append((int)(this.lat * 1000000.0D)).append((int)(this.lng * 1000000.0D));
      String str;
      if (this.tag == null) {
        str = "";
      }
      for (;;)
      {
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
 * Qualified Name:     com.tencent.mm.modelgeo.b
 * JD-Core Version:    0.7.0.1
 */