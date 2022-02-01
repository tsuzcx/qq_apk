package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cmw;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.e;
import d.a.j;
import d.g.b.k;
import d.n.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"domainHashMap", "Ljava/util/HashMap;", "", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", "getDomainHashMap", "()Ljava/util/HashMap;", "setDomainHashMap", "(Ljava/util/HashMap;)V", "urlHashCache", "getUrlHashCache", "setUrlHashCache", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "clearDomain", "", "domain", "clearDomainCache", "getContentId", "url", "getDomainId", "fetch", "", "getInfoId", "getInvalidId", "getManifestId", "getShortUrlId", "getStrip", "", "openScene", "getUrlId", "getWebId", "prefetch", "getWebResId", "resUrl", "hashUrl", "mpDataMmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setShortUrlId", "shortUrl", "longUrl", "contains", "Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "contentId", "create", "Lcom/tencent/mm/vfs/VFSFile;", "findContentFile", "getContentFile", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "getContentPath", "plugin-brandservice_release"})
public final class b
{
  private static HashMap<String, String> nbZ;
  private static HashMap<String, LinkedList<String>> nca;
  
  static
  {
    AppMethodBeat.i(6575);
    nbZ = new HashMap();
    nca = new HashMap();
    AppMethodBeat.o(6575);
  }
  
  public static final e E(e parame)
  {
    AppMethodBeat.i(175480);
    k.h(parame, "$this$create");
    if (!parame.exists())
    {
      new e(parame.getParent()).mkdirs();
      parame.createNewFile();
    }
    AppMethodBeat.o(175480);
    return parame;
  }
  
  public static final String PA(String paramString)
  {
    AppMethodBeat.i(6573);
    k.h(paramString, "url");
    paramString = aB(paramString, false);
    AppMethodBeat.o(6573);
    return paramString;
  }
  
  public static final void Pq(String paramString)
  {
    AppMethodBeat.i(193076);
    k.h(paramString, "domain");
    String str1 = Pv(paramString);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = (LinkedList)nca.get(str1);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        str2 = (String)nbZ.remove(str2);
        if (str2 != null) {
          localLinkedList.add(str2);
        }
      }
    }
    ad.i("AppMsgContextEx", "clearDomain:" + paramString + '#' + str1 + ", [" + j.a((Iterable)localLinkedList, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    AppMethodBeat.o(193076);
  }
  
  public static final void Pr(String paramString)
  {
    try
    {
      AppMethodBeat.i(6557);
      k.h(paramString, "domain");
      com.tencent.mm.ipcinvoker.a.a("com.tencent.mm", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)a.ncb, null);
      com.tencent.mm.ipcinvoker.a.a("com.tencent.mm:tools", (Parcelable)new IPCString(paramString), (com.tencent.mm.ipcinvoker.b)b.ncc, null);
      AppMethodBeat.o(6557);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static final String Ps(String paramString)
  {
    AppMethodBeat.i(6560);
    k.h(paramString, "url");
    paramString = "_info_" + aB(paramString, false);
    AppMethodBeat.o(6560);
    return paramString;
  }
  
  public static final String Pt(String paramString)
  {
    AppMethodBeat.i(6561);
    k.h(paramString, "$this$host");
    try
    {
      paramString = Uri.parse(UrlExKt.getWithProtocol(paramString));
      k.g(paramString, "Uri.parse(this.withProtocol)");
      String str = paramString.getHost();
      paramString = str;
      if (str == null) {
        paramString = "unknow";
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "unknow";
      }
    }
    AppMethodBeat.o(6561);
    return paramString;
  }
  
  private static String Pv(String paramString)
  {
    AppMethodBeat.i(193080);
    k.h(paramString, "domain");
    paramString = "_domain_" + paramString.hashCode();
    AppMethodBeat.o(193080);
    return paramString;
  }
  
  public static final String Px(String paramString)
  {
    AppMethodBeat.i(193081);
    k.h(paramString, "host");
    paramString = "_manifest_" + paramString.hashCode();
    AppMethodBeat.o(193081);
    return paramString;
  }
  
  public static final String Py(String paramString)
  {
    AppMethodBeat.i(6568);
    k.h(paramString, "url");
    paramString = "_content_" + aB(paramString, false);
    AppMethodBeat.o(6568);
    return paramString;
  }
  
  public static final String Pz(String paramString)
  {
    AppMethodBeat.i(6569);
    k.h(paramString, "url");
    paramString = "_invalid_" + aB(paramString, false);
    AppMethodBeat.o(6569);
    return paramString;
  }
  
  public static final e a(ao paramao, String paramString)
  {
    AppMethodBeat.i(175483);
    k.h(paramao, "$this$getContentFile");
    k.h(paramString, "contentId");
    paramao = d((e)paramao.eEX(), paramString);
    AppMethodBeat.o(175483);
    return paramao;
  }
  
  public static final String a(eu parameu)
  {
    AppMethodBeat.i(6570);
    k.h(parameu, "$this$getContentId");
    parameu = parameu.Url;
    k.g(parameu, "this.Url");
    parameu = Py(parameu);
    AppMethodBeat.o(6570);
    return parameu;
  }
  
  /* Error */
  private static final String aB(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 306
    //   8: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 308
    //   15: invokestatic 314	d/n/n:mD	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: iconst_4
    //   19: anewarray 157	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 316
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc_w 318
    //   33: aastore
    //   34: dup
    //   35: iconst_2
    //   36: ldc_w 320
    //   39: aastore
    //   40: dup
    //   41: iconst_3
    //   42: ldc_w 322
    //   45: aastore
    //   46: invokestatic 326	com/tencent/mm/plugin/brandservice/ui/timeline/preload/UrlExKt:clearUrlParams	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   49: astore 4
    //   51: new 168	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   58: aload 4
    //   60: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: bipush 45
    //   65: invokevirtual 178	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   68: iload_1
    //   69: invokevirtual 330	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   72: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore_3
    //   76: getstatic 85	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nbZ	Ljava/util/HashMap;
    //   79: aload_3
    //   80: invokevirtual 333	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   83: ifeq +28 -> 111
    //   86: getstatic 85	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nbZ	Ljava/util/HashMap;
    //   89: checkcast 335	java/util/Map
    //   92: aload_3
    //   93: invokestatic 341	d/a/ae:e	(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 157	java/lang/String
    //   99: astore_0
    //   100: ldc_w 306
    //   103: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: areturn
    //   111: aload 4
    //   113: invokestatic 343	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:Pt	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 133	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:Pv	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 5
    //   121: new 10	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b$c
    //   124: dup
    //   125: iload_1
    //   126: aload 4
    //   128: invokespecial 346	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b$c:<init>	(ZLjava/lang/String;)V
    //   131: astore 6
    //   133: new 168	java/lang/StringBuilder
    //   136: dup
    //   137: ldc_w 348
    //   140: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: astore_0
    //   144: iload_2
    //   145: iconst_3
    //   146: if_icmpge +313 -> 459
    //   149: iconst_3
    //   150: anewarray 157	java/lang/String
    //   153: dup
    //   154: iconst_0
    //   155: ldc_w 350
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: ldc_w 352
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: ldc_w 354
    //   170: aastore
    //   171: iload_2
    //   172: aaload
    //   173: astore 7
    //   175: aload 4
    //   177: aload 7
    //   179: invokestatic 357	com/tencent/mm/plugin/brandservice/ui/timeline/preload/UrlExKt:getUrlParam	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore 8
    //   184: aload 8
    //   186: ifnonnull +231 -> 417
    //   189: aload 4
    //   191: invokestatic 360	com/tencent/mm/plugin/brandservice/ui/timeline/preload/UrlExKt:clearShortUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 7
    //   196: aload 7
    //   198: ldc 123
    //   200: invokestatic 102	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   203: invokestatic 364	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:bDi	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   206: ldc_w 366
    //   209: aload 7
    //   211: invokestatic 370	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   214: invokevirtual 373	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   217: ldc_w 374
    //   220: invokevirtual 379	com/tencent/mm/sdk/platformtools/ax:decodeString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_0
    //   224: aload_0
    //   225: ldc_w 381
    //   228: invokestatic 247	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   231: aload_0
    //   232: invokestatic 387	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   235: ifne +27 -> 262
    //   238: getstatic 85	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nbZ	Ljava/util/HashMap;
    //   241: checkcast 335	java/util/Map
    //   244: aload 4
    //   246: aload_0
    //   247: invokeinterface 391 3 0
    //   252: pop
    //   253: ldc_w 306
    //   256: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: goto -153 -> 106
    //   262: ldc_w 393
    //   265: aload 6
    //   267: aload 7
    //   269: invokevirtual 397	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b$c:PB	(Ljava/lang/String;)I
    //   272: invokestatic 400	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   275: invokevirtual 373	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   278: invokevirtual 263	java/lang/String:hashCode	()I
    //   281: bipush 16
    //   283: invokestatic 406	d/n/a:agb	(I)I
    //   286: invokestatic 411	java/lang/Integer:toString	(II)Ljava/lang/String;
    //   289: astore_0
    //   290: aload_0
    //   291: ldc_w 413
    //   294: invokestatic 247	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   297: iload_1
    //   298: ifeq +110 -> 408
    //   301: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nca	Ljava/util/HashMap;
    //   304: aload 5
    //   306: invokevirtual 333	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   309: ifne +24 -> 333
    //   312: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nca	Ljava/util/HashMap;
    //   315: checkcast 335	java/util/Map
    //   318: aload 5
    //   320: new 135	java/util/LinkedList
    //   323: dup
    //   324: invokespecial 136	java/util/LinkedList:<init>	()V
    //   327: invokeinterface 391 3 0
    //   332: pop
    //   333: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nca	Ljava/util/HashMap;
    //   336: aload 5
    //   338: invokevirtual 140	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   341: astore 5
    //   343: aload 5
    //   345: ifnonnull +6 -> 351
    //   348: invokestatic 416	d/g/b/k:fvU	()V
    //   351: aload 5
    //   353: checkcast 135	java/util/LinkedList
    //   356: aload_3
    //   357: invokevirtual 164	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   360: pop
    //   361: getstatic 85	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nbZ	Ljava/util/HashMap;
    //   364: checkcast 335	java/util/Map
    //   367: aload_3
    //   368: aload_0
    //   369: invokeinterface 391 3 0
    //   374: pop
    //   375: ldc 166
    //   377: new 168	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 308
    //   384: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload_0
    //   388: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc_w 418
    //   394: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 4
    //   399: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: ldc_w 306
    //   411: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: goto -308 -> 106
    //   417: aload_0
    //   418: new 168	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 327	java/lang/StringBuilder:<init>	()V
    //   425: aload 7
    //   427: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: bipush 58
    //   432: invokevirtual 178	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   435: aload 8
    //   437: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: bipush 45
    //   442: invokevirtual 178	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   445: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: iload_2
    //   453: iconst_1
    //   454: iadd
    //   455: istore_2
    //   456: goto -312 -> 144
    //   459: aload_0
    //   460: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: astore_0
    //   464: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nca	Ljava/util/HashMap;
    //   467: aload 5
    //   469: invokevirtual 333	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   472: ifne +24 -> 496
    //   475: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nca	Ljava/util/HashMap;
    //   478: checkcast 335	java/util/Map
    //   481: aload 5
    //   483: new 135	java/util/LinkedList
    //   486: dup
    //   487: invokespecial 136	java/util/LinkedList:<init>	()V
    //   490: invokeinterface 391 3 0
    //   495: pop
    //   496: getstatic 87	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nca	Ljava/util/HashMap;
    //   499: aload 5
    //   501: invokevirtual 140	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   504: astore 4
    //   506: aload 4
    //   508: ifnonnull +6 -> 514
    //   511: invokestatic 416	d/g/b/k:fvU	()V
    //   514: aload 4
    //   516: checkcast 135	java/util/LinkedList
    //   519: aload_3
    //   520: invokevirtual 164	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   523: pop
    //   524: getstatic 85	com/tencent/mm/plugin/brandservice/ui/timeline/preload/b:nbZ	Ljava/util/HashMap;
    //   527: checkcast 335	java/util/Map
    //   530: astore 4
    //   532: aload_0
    //   533: ldc_w 422
    //   536: invokestatic 247	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   539: aload 4
    //   541: aload_3
    //   542: aload_0
    //   543: invokeinterface 391 3 0
    //   548: pop
    //   549: aload_0
    //   550: ldc_w 424
    //   553: invokestatic 247	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   556: ldc_w 306
    //   559: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: goto -456 -> 106
    //   565: astore_0
    //   566: ldc 2
    //   568: monitorexit
    //   569: aload_0
    //   570: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	paramString	String
    //   0	571	1	paramBoolean	boolean
    //   1	455	2	i	int
    //   75	467	3	str1	String
    //   49	491	4	localObject1	Object
    //   119	381	5	localObject2	Object
    //   131	135	6	localc	c
    //   173	253	7	str2	String
    //   182	254	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   5	106	565	finally
    //   111	144	565	finally
    //   149	184	565	finally
    //   189	259	565	finally
    //   262	297	565	finally
    //   301	333	565	finally
    //   333	343	565	finally
    //   348	351	565	finally
    //   351	408	565	finally
    //   408	414	565	finally
    //   417	452	565	finally
    //   459	496	565	finally
    //   496	506	565	finally
    //   511	514	565	finally
    //   514	562	565	finally
  }
  
  public static final String aC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(193078);
    k.h(paramString, "url");
    paramString = "_web_" + aB(n.mD(paramString, "#"), paramBoolean);
    AppMethodBeat.o(193078);
    return paramString;
  }
  
  public static final e b(ao paramao, String paramString)
  {
    AppMethodBeat.i(175484);
    k.h(paramao, "$this$findContentFile");
    k.h(paramString, "contentId");
    paramao = (e)paramao.aFe(paramString);
    if (paramao != null)
    {
      paramao = d(paramao, paramString);
      AppMethodBeat.o(175484);
      return paramao;
    }
    AppMethodBeat.o(175484);
    return null;
  }
  
  public static final HashMap<String, String> bDg()
  {
    return nbZ;
  }
  
  public static final HashMap<String, LinkedList<String>> bDh()
  {
    return nca;
  }
  
  private static ax bDi()
  {
    AppMethodBeat.i(6572);
    if (aj.cbe()) {
      k.g(g.afz(), "MMKernel.account()");
    }
    for (int i = com.tencent.mm.kernel.a.getUin();; i = com.tencent.mm.kernel.a.aeL())
    {
      ax localax = ax.fF("mpRelateData_".concat(String.valueOf(i)), 2);
      k.g(localax, "MultiProcessMMKV.getMMKV…sMMKV.MULTI_PROCESS_MODE)");
      AppMethodBeat.o(6572);
      return localax;
    }
  }
  
  public static final boolean c(ao paramao, String paramString)
  {
    AppMethodBeat.i(6556);
    k.h(paramao, "$this$contains");
    k.h(paramString, "contentId");
    if (paramao.aFe(paramString) != null)
    {
      AppMethodBeat.o(6556);
      return true;
    }
    AppMethodBeat.o(6556);
    return false;
  }
  
  private static final e d(e parame, String paramString)
  {
    AppMethodBeat.i(175482);
    parame = new e(parame.getPath() + '/' + paramString);
    AppMethodBeat.o(175482);
    return parame;
  }
  
  public static final String ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6564);
    k.h(paramString1, "host");
    k.h(paramString2, "resUrl");
    paramString1 = paramString1 + "/_web_res_" + aB(paramString2, false);
    AppMethodBeat.o(6564);
    return paramString1;
  }
  
  public static final void eq(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(6574);
      k.h(paramString1, "shortUrl");
      k.h(paramString2, "longUrl");
      paramString1 = UrlExKt.clearShortUrl(paramString1);
      paramString2 = PA(paramString2);
      String str = "short_url_".concat(String.valueOf(paramString1));
      bDi().encode(str, paramString2);
      nbZ.put(paramString1, paramString2);
      AppMethodBeat.o(6574);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static final int xW(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(6571);
    Object localObject1 = r.bDU().decodeBytes("_msg_scene_strip");
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {}
      Object localObject2;
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          j = 1;
        }
        if (j != 1) {
          break label210;
        }
        localObject2 = new cmx();
        ((cmx)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((cmx)localObject2).CEC;
        k.g(localObject1, "SceneControlSets().apply…(buff) }.SceneControlList");
        localObject1 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label210;
          }
          localObject2 = (cmw)((Iterator)localObject1).next();
          if (((cmw)localObject2).Scene == paramInt)
          {
            if (((cmw)localObject2).EhG > 0) {
              break;
            }
            ad.e("MicroMsg.AppMsgContextEx", "strip error " + paramInt + ':' + ((cmw)localObject2).EhG);
          }
        }
      }
      ad.i("MicroMsg.AppMsgContextEx", "strip " + paramInt + ':' + ((cmw)localObject2).EhG);
      paramInt = ((cmw)localObject2).EhG;
      AppMethodBeat.o(6571);
      return paramInt;
    }
    label210:
    AppMethodBeat.o(6571);
    return 10;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final a ncb;
    
    static
    {
      AppMethodBeat.i(193071);
      ncb = new a();
      AppMethodBeat.o(193071);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ipcDomain", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid>
  {
    public static final b ncc;
    
    static
    {
      AppMethodBeat.i(193073);
      ncc = new b();
      AppMethodBeat.o(193073);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"toHash", "", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<String, Integer>
  {
    c(boolean paramBoolean, String paramString)
    {
      super();
    }
    
    public final int PB(String paramString)
    {
      AppMethodBeat.i(193075);
      k.h(paramString, "$this$toHash");
      for (;;)
      {
        try
        {
          localObject = Uri.parse(paramString);
          if (!this.ncd) {
            continue;
          }
          String str = ((Uri)localObject).getScheme();
          if ((str == null) || (c.a(str, "http", true) != true)) {
            continue;
          }
          localObject = v.ngi;
          localObject = v.PO(this.keu);
          if (localObject != null)
          {
            str = v.ngi.a(this.keu, (i)localObject);
            localObject = str;
            if (str != null) {}
          }
          else
          {
            localObject = this.keu;
          }
          i = ((String)localObject).hashCode();
        }
        catch (Exception localException)
        {
          Object localObject;
          ad.printErrStackTrace("hashUrl", (Throwable)localException, "hash url".concat(String.valueOf(paramString)), new Object[0]);
          int i = 0;
          continue;
        }
        AppMethodBeat.o(193075);
        return i;
        localObject = ((Uri)localObject).toString();
        k.g(localObject, "toString()");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b
 * JD-Core Version:    0.7.0.1
 */