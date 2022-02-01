package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.PkgReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic;", "", "()V", "TAG", "", "clearCache", "", "appId", "versionType", "", "evictExpiredCache", "getCommLibVersionId", "useRelease", "", "getWxaAttrVersion", "toCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "transaction", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"})
public final class d
{
  public static final d qyh;
  
  static
  {
    AppMethodBeat.i(50968);
    qyh = new d();
    AppMethodBeat.o(50968);
  }
  
  public static final void cB(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(50967);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50967);
      return;
    }
    Object localObject3 = (c)m.W(c.class);
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new aa.f();
        ((aa.f)localObject1).aaBC = "  appId=? ";
        switch (paramInt)
        {
        case 1: 
          localObject2 = new LinkedList();
          localObject3 = ((c)localObject3).nHd;
          localObject1 = (b)new a((aa.f)localObject1, (LinkedList)localObject2, paramInt, paramString);
          Thread localThread = Thread.currentThread();
          p.j(localThread, "Thread.currentThread()");
          long l = ((ISQLiteDatabaseEx)localObject3).beginTransaction(localThread.getId());
          ((b)localObject1).invoke(localObject3);
          ((ISQLiteDatabaseEx)localObject3).endTransaction(l);
          localObject1 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label337;
          }
          u.deleteFile((String)((Iterator)localObject1).next());
          continue;
          localObject2 = (String)localException.aaBC;
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "clearCache with appId[" + paramString + "] versionType[" + paramInt + "], e=" + localException);
        AppMethodBeat.o(50967);
        return;
      }
      localException.aaBC = ((String)localObject2 + " and appVersionId = TEST");
      continue;
      Object localObject2 = (String)localException.aaBC;
      localException.aaBC = ((String)localObject2 + " and appVersionId = DEMO");
      continue;
      label337:
      AppMethodBeat.o(50967);
      return;
      AppMethodBeat.o(50967);
      return;
    }
  }
  
  /* Error */
  public static final void cfJ()
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 197	com/tencent/mm/vfs/q
    //   8: dup
    //   9: invokestatic 202	com/tencent/mm/plugin/appbrand/page/web_renderingcache/g:cfL	()Ljava/lang/String;
    //   12: invokespecial 203	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   15: astore 7
    //   17: aload 7
    //   19: invokevirtual 206	com/tencent/mm/vfs/q:ifE	()Z
    //   22: ifeq +11 -> 33
    //   25: aload 7
    //   27: invokevirtual 209	com/tencent/mm/vfs/q:isDirectory	()Z
    //   30: ifne +15 -> 45
    //   33: aload 7
    //   35: invokevirtual 212	com/tencent/mm/vfs/q:cFq	()Z
    //   38: pop
    //   39: ldc 195
    //   41: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: ldc 155
    //   47: ldc 214
    //   49: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: ldc 71
    //   54: invokestatic 77	com/tencent/mm/plugin/appbrand/app/m:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   57: checkcast 71	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c
    //   60: astore 6
    //   62: aload 6
    //   64: ifnull +785 -> 849
    //   67: new 88	java/util/LinkedList
    //   70: dup
    //   71: invokespecial 89	java/util/LinkedList:<init>	()V
    //   74: astore 8
    //   76: iconst_1
    //   77: invokestatic 220	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d:jn	(Z)Ljava/lang/String;
    //   80: astore 9
    //   82: aload 9
    //   84: ifnull +11 -> 95
    //   87: aload 8
    //   89: aload 9
    //   91: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   94: pop
    //   95: iconst_0
    //   96: invokestatic 220	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d:jn	(Z)Ljava/lang/String;
    //   99: astore 9
    //   101: aload 9
    //   103: ifnull +11 -> 114
    //   106: aload 8
    //   108: aload 9
    //   110: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload 8
    //   116: invokevirtual 227	java/util/LinkedList:isEmpty	()Z
    //   119: ifne +61 -> 180
    //   122: aload 8
    //   124: checkcast 131	java/lang/Iterable
    //   127: ldc 229
    //   129: checkcast 65	java/lang/CharSequence
    //   132: aconst_null
    //   133: aconst_null
    //   134: iconst_0
    //   135: aconst_null
    //   136: getstatic 233	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d$c:qyo	Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/d$c;
    //   139: checkcast 97	kotlin/g/a/b
    //   142: bipush 30
    //   144: invokestatic 239	kotlin/a/j:a	(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   147: astore 9
    //   149: aload 8
    //   151: iconst_0
    //   152: anewarray 147	java/lang/String
    //   155: invokevirtual 243	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   158: checkcast 245	[Ljava/lang/String;
    //   161: astore 8
    //   163: aload 6
    //   165: getfield 92	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   168: ldc 247
    //   170: aload 9
    //   172: aload 8
    //   174: invokeinterface 251 4 0
    //   179: pop
    //   180: new 88	java/util/LinkedList
    //   183: dup
    //   184: invokespecial 89	java/util/LinkedList:<init>	()V
    //   187: astore 9
    //   189: aload 6
    //   191: getfield 92	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   194: ldc 253
    //   196: aconst_null
    //   197: iconst_2
    //   198: invokeinterface 257 4 0
    //   203: checkcast 259	java/io/Closeable
    //   206: astore 8
    //   208: aload 8
    //   210: checkcast 261	android/database/Cursor
    //   213: astore 10
    //   215: aload 10
    //   217: ifnull +37 -> 254
    //   220: aload 10
    //   222: invokeinterface 264 1 0
    //   227: ifeq +27 -> 254
    //   230: aload 9
    //   232: aload 10
    //   234: iconst_0
    //   235: invokeinterface 268 2 0
    //   240: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   243: pop
    //   244: aload 10
    //   246: invokeinterface 271 1 0
    //   251: ifne -21 -> 230
    //   254: getstatic 277	kotlin/x:aazN	Lkotlin/x;
    //   257: astore 10
    //   259: aload 8
    //   261: aconst_null
    //   262: invokestatic 282	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   265: aload 9
    //   267: checkcast 131	java/lang/Iterable
    //   270: invokeinterface 135 1 0
    //   275: astore 8
    //   277: aload 8
    //   279: invokeinterface 141 1 0
    //   284: ifeq +172 -> 456
    //   287: aload 8
    //   289: invokeinterface 145 1 0
    //   294: checkcast 147	java/lang/String
    //   297: astore 9
    //   299: getstatic 288	com/tencent/mm/plugin/appbrand/task/i:qRL	Lcom/tencent/mm/plugin/appbrand/task/i$a;
    //   302: astore 10
    //   304: invokestatic 294	com/tencent/mm/plugin/appbrand/task/i$a:cjb	()Lcom/tencent/mm/plugin/appbrand/task/i;
    //   307: aload 9
    //   309: invokestatic 299	com/tencent/luggage/sdk/processes/d:a	(Lcom/tencent/luggage/sdk/processes/d;Ljava/lang/String;)Z
    //   312: ifne -35 -> 277
    //   315: invokestatic 303	com/tencent/mm/plugin/appbrand/app/m:bFF	()Lcom/tencent/mm/plugin/appbrand/config/z;
    //   318: astore 10
    //   320: aload 10
    //   322: ifnull +128 -> 450
    //   325: aload 10
    //   327: aload 9
    //   329: iconst_1
    //   330: anewarray 147	java/lang/String
    //   333: dup
    //   334: iconst_0
    //   335: ldc_w 305
    //   338: aastore
    //   339: invokevirtual 311	com/tencent/mm/plugin/appbrand/config/z:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   342: astore 10
    //   344: aload 10
    //   346: ifnull +104 -> 450
    //   349: aload 10
    //   351: invokevirtual 317	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLH	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   354: astore 10
    //   356: aload 10
    //   358: ifnull +92 -> 450
    //   361: aload 10
    //   363: getfield 323	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   366: istore 4
    //   368: iload 4
    //   370: iconst_m1
    //   371: if_icmpeq -94 -> 277
    //   374: aload 6
    //   376: getfield 92	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   379: ldc 247
    //   381: new 157	java/lang/StringBuilder
    //   384: dup
    //   385: ldc_w 325
    //   388: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: iload 4
    //   393: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: ldc_w 327
    //   399: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: iconst_1
    //   406: anewarray 147	java/lang/String
    //   409: dup
    //   410: iconst_0
    //   411: aload 9
    //   413: aastore
    //   414: invokeinterface 251 4 0
    //   419: pop
    //   420: goto -143 -> 277
    //   423: astore 7
    //   425: ldc 195
    //   427: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: aload 7
    //   432: athrow
    //   433: astore 6
    //   435: aload 8
    //   437: aload 7
    //   439: invokestatic 282	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   442: ldc 195
    //   444: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aload 6
    //   449: athrow
    //   450: iconst_m1
    //   451: istore 4
    //   453: goto -85 -> 368
    //   456: new 8	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d$b
    //   459: dup
    //   460: aload 6
    //   462: aload 7
    //   464: invokespecial 330	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d$b:<init>	(Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/c;Lcom/tencent/mm/vfs/q;)V
    //   467: astore 8
    //   469: aload 7
    //   471: getstatic 334	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d$d:qyp	Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/d$d;
    //   474: checkcast 336	com/tencent/mm/vfs/s
    //   477: invokevirtual 339	com/tencent/mm/vfs/q:a	(Lcom/tencent/mm/vfs/s;)[Lcom/tencent/mm/vfs/q;
    //   480: astore 9
    //   482: aload 9
    //   484: ifnull +61 -> 545
    //   487: aload 9
    //   489: arraylength
    //   490: istore 5
    //   492: iconst_0
    //   493: istore 4
    //   495: iload 4
    //   497: iload 5
    //   499: if_icmpge +46 -> 545
    //   502: aload 9
    //   504: iload 4
    //   506: aaload
    //   507: astore 10
    //   509: aload 10
    //   511: ldc_w 341
    //   514: invokestatic 111	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   517: aload 8
    //   519: aload 10
    //   521: invokevirtual 344	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   524: invokevirtual 347	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d$b:alX	(Ljava/lang/String;)Z
    //   527: ifne +9 -> 536
    //   530: aload 10
    //   532: invokevirtual 212	com/tencent/mm/vfs/q:cFq	()Z
    //   535: pop
    //   536: iload 4
    //   538: iconst_1
    //   539: iadd
    //   540: istore 4
    //   542: goto -47 -> 495
    //   545: aload 7
    //   547: invokestatic 353	com/tencent/mm/plugin/appbrand/appstorage/o:q	(Lcom/tencent/mm/vfs/q;)J
    //   550: l2d
    //   551: ldc2_w 354
    //   554: ddiv
    //   555: dstore_0
    //   556: dload_0
    //   557: invokestatic 361	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLe	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   560: getfield 364	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXx	I
    //   563: i2d
    //   564: dcmpl
    //   565: ifle +278 -> 843
    //   568: ldc 155
    //   570: new 157	java/lang/StringBuilder
    //   573: dup
    //   574: ldc_w 366
    //   577: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   580: dload_0
    //   581: invokevirtual 369	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   584: ldc_w 371
    //   587: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: invokestatic 361	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLe	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   599: getfield 364	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXx	I
    //   602: i2d
    //   603: dstore_2
    //   604: new 88	java/util/LinkedList
    //   607: dup
    //   608: invokespecial 89	java/util/LinkedList:<init>	()V
    //   611: astore 7
    //   613: aload 6
    //   615: getfield 92	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   618: ldc_w 373
    //   621: aconst_null
    //   622: iconst_2
    //   623: invokeinterface 257 4 0
    //   628: checkcast 259	java/io/Closeable
    //   631: astore 8
    //   633: aload 8
    //   635: checkcast 261	android/database/Cursor
    //   638: astore 9
    //   640: aload 9
    //   642: ifnull +47 -> 689
    //   645: aload 9
    //   647: invokeinterface 264 1 0
    //   652: ifeq +37 -> 689
    //   655: new 375	com/tencent/mm/plugin/appbrand/page/web_renderingcache/b
    //   658: dup
    //   659: invokespecial 376	com/tencent/mm/plugin/appbrand/page/web_renderingcache/b:<init>	()V
    //   662: astore 10
    //   664: aload 10
    //   666: aload 9
    //   668: invokevirtual 380	com/tencent/mm/plugin/appbrand/page/web_renderingcache/b:convertFrom	(Landroid/database/Cursor;)V
    //   671: aload 7
    //   673: aload 10
    //   675: invokevirtual 224	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   678: pop
    //   679: aload 9
    //   681: invokeinterface 271 1 0
    //   686: ifne -31 -> 655
    //   689: getstatic 277	kotlin/x:aazN	Lkotlin/x;
    //   692: astore 9
    //   694: aload 8
    //   696: aconst_null
    //   697: invokestatic 282	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   700: aload 7
    //   702: invokevirtual 381	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   705: astore 7
    //   707: dload_0
    //   708: dload_2
    //   709: dsub
    //   710: ldc2_w 382
    //   713: dmul
    //   714: ldc2_w 382
    //   717: dmul
    //   718: dstore_0
    //   719: aload 7
    //   721: invokeinterface 141 1 0
    //   726: ifeq +117 -> 843
    //   729: aload 7
    //   731: invokeinterface 145 1 0
    //   736: checkcast 375	com/tencent/mm/plugin/appbrand/page/web_renderingcache/b
    //   739: astore 8
    //   741: getstatic 288	com/tencent/mm/plugin/appbrand/task/i:qRL	Lcom/tencent/mm/plugin/appbrand/task/i$a;
    //   744: astore 9
    //   746: invokestatic 294	com/tencent/mm/plugin/appbrand/task/i$a:cjb	()Lcom/tencent/mm/plugin/appbrand/task/i;
    //   749: astore 9
    //   751: aload 8
    //   753: getfield 387	com/tencent/mm/plugin/appbrand/page/web_renderingcache/b:field_appId	Ljava/lang/String;
    //   756: astore 10
    //   758: aload 10
    //   760: ldc_w 389
    //   763: invokestatic 111	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   766: dload_0
    //   767: dstore_2
    //   768: aload 9
    //   770: aload 10
    //   772: invokestatic 299	com/tencent/luggage/sdk/processes/d:a	(Lcom/tencent/luggage/sdk/processes/d;Ljava/lang/String;)Z
    //   775: ifne +36 -> 811
    //   778: dload_0
    //   779: dconst_0
    //   780: dcmpg
    //   781: ifle +62 -> 843
    //   784: dload_0
    //   785: aload 8
    //   787: getfield 392	com/tencent/mm/plugin/appbrand/page/web_renderingcache/b:field_cacheFilePath	Ljava/lang/String;
    //   790: invokestatic 396	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   793: l2d
    //   794: dsub
    //   795: dstore_2
    //   796: aload 6
    //   798: aload 8
    //   800: checkcast 398	com/tencent/mm/sdk/storage/IAutoDBItem
    //   803: iconst_0
    //   804: anewarray 147	java/lang/String
    //   807: invokevirtual 401	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:delete	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;[Ljava/lang/String;)Z
    //   810: pop
    //   811: dload_2
    //   812: dstore_0
    //   813: goto -94 -> 719
    //   816: astore 7
    //   818: ldc 195
    //   820: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   823: aload 7
    //   825: athrow
    //   826: astore 6
    //   828: aload 8
    //   830: aload 7
    //   832: invokestatic 282	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   835: ldc 195
    //   837: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   840: aload 6
    //   842: athrow
    //   843: ldc 195
    //   845: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   848: return
    //   849: ldc 195
    //   851: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: return
    //   855: astore 6
    //   857: aconst_null
    //   858: astore 7
    //   860: goto -32 -> 828
    //   863: astore 6
    //   865: aconst_null
    //   866: astore 7
    //   868: goto -433 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   555	258	0	d1	double
    //   603	209	2	d2	double
    //   366	175	4	i	int
    //   490	10	5	j	int
    //   60	315	6	localc1	c
    //   433	364	6	localc2	c
    //   826	15	6	localObject1	Object
    //   855	1	6	localObject2	Object
    //   863	1	6	localObject3	Object
    //   15	19	7	localq	com.tencent.mm.vfs.q
    //   423	123	7	localThrowable1	java.lang.Throwable
    //   611	119	7	localObject4	Object
    //   816	15	7	localThrowable2	java.lang.Throwable
    //   858	9	7	localObject5	Object
    //   74	755	8	localObject6	Object
    //   80	689	9	localObject7	Object
    //   213	558	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   208	215	423	java/lang/Throwable
    //   220	230	423	java/lang/Throwable
    //   230	254	423	java/lang/Throwable
    //   254	259	423	java/lang/Throwable
    //   425	433	433	finally
    //   633	640	816	java/lang/Throwable
    //   645	655	816	java/lang/Throwable
    //   655	689	816	java/lang/Throwable
    //   689	694	816	java/lang/Throwable
    //   818	826	826	finally
    //   633	640	855	finally
    //   645	655	855	finally
    //   655	689	855	finally
    //   689	694	855	finally
    //   208	215	863	finally
    //   220	230	863	finally
    //   230	254	863	finally
    //   254	259	863	finally
  }
  
  private static String jn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(269804);
    Object localObject = m.bFP();
    p.j(localObject, "SubCoreAppBrand.getAppWxaPkgStorage()");
    int i;
    if (paramBoolean)
    {
      i = 0;
      localObject = ax.a((bm)localObject, i);
      if (localObject == null) {
        break label132;
      }
      localObject = ax.b((bh)localObject);
      if (!((WxaPkgWrappingInfo)localObject).nIa)
      {
        CharSequence localCharSequence = (CharSequence)((WxaPkgWrappingInfo)localObject).pkgPath;
        if (localCharSequence != null)
        {
          i = j;
          if (localCharSequence.length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i == 0) {
          break label117;
        }
      }
      localObject = AssetReader.nEa;
      p.j(localObject, "AssetReader.INSTANCE");
    }
    label117:
    for (localObject = (ICommLibReader)localObject;; localObject = (ICommLibReader)new WxaCommLibRuntimeReader.PkgReader((WxaPkgWrappingInfo)localObject))
    {
      localObject = ((ICommLibReader)localObject).bGh();
      AppMethodBeat.o(269804);
      return localObject;
      i = 999;
      break;
    }
    label132:
    if (paramBoolean)
    {
      localObject = AssetReader.nEa.bGh();
      AppMethodBeat.o(269804);
      return localObject;
    }
    AppMethodBeat.o(269804);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$clearCache$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements b<ISQLiteDatabaseEx, x>
  {
    a(aa.f paramf, LinkedList paramLinkedList, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"isCacheFileRecorded", "", "filePath", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$3$1", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$$special$$inlined$run$lambda$1"})
  static final class b
    extends kotlin.g.b.q
    implements b<String, Boolean>
  {
    b(c paramc, com.tencent.mm.vfs.q paramq)
    {
      super();
    }
    
    /* Error */
    public final boolean alX(String paramString)
    {
      // Byte code:
      //   0: ldc 44
      //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: checkcast 51	java/lang/CharSequence
      //   9: astore 4
      //   11: aload 4
      //   13: ifnull +13 -> 26
      //   16: aload 4
      //   18: invokeinterface 55 1 0
      //   23: ifne +16 -> 39
      //   26: iconst_1
      //   27: istore_2
      //   28: iload_2
      //   29: ifeq +15 -> 44
      //   32: ldc 44
      //   34: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: iconst_0
      //   38: ireturn
      //   39: iconst_0
      //   40: istore_2
      //   41: goto -13 -> 28
      //   44: aload_0
      //   45: getfield 33	com/tencent/mm/plugin/appbrand/page/web_renderingcache/d$b:qym	Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/c;
      //   48: getfield 64	com/tencent/mm/plugin/appbrand/page/web_renderingcache/c:nHd	Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
      //   51: ldc 66
      //   53: iconst_1
      //   54: anewarray 68	java/lang/String
      //   57: dup
      //   58: iconst_0
      //   59: aload_1
      //   60: aastore
      //   61: iconst_2
      //   62: invokeinterface 74 4 0
      //   67: checkcast 76	java/io/Closeable
      //   70: astore 5
      //   72: aload 5
      //   74: checkcast 78	android/database/Cursor
      //   77: astore_1
      //   78: aload_1
      //   79: ifnull +39 -> 118
      //   82: aload_1
      //   83: invokeinterface 82 1 0
      //   88: ifeq +30 -> 118
      //   91: aload_1
      //   92: iconst_0
      //   93: invokeinterface 86 2 0
      //   98: istore_2
      //   99: iload_2
      //   100: ifle +18 -> 118
      //   103: iconst_1
      //   104: istore_3
      //   105: aload 5
      //   107: aconst_null
      //   108: invokestatic 92	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   111: ldc 44
      //   113: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: iload_3
      //   117: ireturn
      //   118: iconst_0
      //   119: istore_3
      //   120: goto -15 -> 105
      //   123: astore 4
      //   125: ldc 44
      //   127: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aload 4
      //   132: athrow
      //   133: astore_1
      //   134: aload 5
      //   136: aload 4
      //   138: invokestatic 92	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   141: ldc 44
      //   143: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   146: aload_1
      //   147: athrow
      //   148: astore_1
      //   149: aconst_null
      //   150: astore 4
      //   152: goto -18 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	155	0	this	b
      //   0	155	1	paramString	String
      //   27	73	2	i	int
      //   104	16	3	bool	boolean
      //   9	8	4	localCharSequence	CharSequence
      //   123	14	4	localThrowable	java.lang.Throwable
      //   150	1	4	localObject	Object
      //   70	65	5	localCloseable	java.io.Closeable
      // Exception table:
      //   from	to	target	type
      //   72	78	123	java/lang/Throwable
      //   82	99	123	java/lang/Throwable
      //   125	133	133	finally
      //   72	78	148	finally
      //   82	99	148	finally
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<String, String>
  {
    public static final c qyo;
    
    static
    {
      AppMethodBeat.i(50961);
      qyo = new c();
      AppMethodBeat.o(50961);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "f", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
  static final class d
    implements s
  {
    public static final d qyp;
    
    static
    {
      AppMethodBeat.i(50965);
      qyp = new d();
      AppMethodBeat.o(50965);
    }
    
    public final boolean accept(com.tencent.mm.vfs.q paramq)
    {
      AppMethodBeat.i(50964);
      p.k(paramq, "f");
      if ((paramq.ifE()) && (paramq.ifH()))
      {
        AppMethodBeat.o(50964);
        return true;
      }
      AppMethodBeat.o(50964);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.d
 * JD-Core Version:    0.7.0.1
 */