package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/BatchSyncVersionUtils;", "", "()V", "TAG", "", "collectPreDownloadWhiteListReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "database", "Lcom/tencent/mm/storagebase/SqliteDB;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a nIQ;
  
  static
  {
    AppMethodBeat.i(278934);
    nIQ = new a();
    AppMethodBeat.o(278934);
  }
  
  /* Error */
  public static final java.util.Map<String, com.tencent.mm.protocal.protobuf.epy> b(com.tencent.mm.storagebase.h paramh)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 50
    //   8: invokestatic 56	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: new 58	java/util/HashMap
    //   14: dup
    //   15: invokespecial 59	java/util/HashMap:<init>	()V
    //   18: astore 11
    //   20: invokestatic 65	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLe	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   23: astore 12
    //   25: aload 12
    //   27: ldc 67
    //   29: invokestatic 70	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: new 72	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 74
    //   38: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: astore 13
    //   43: aload 12
    //   45: getfield 81	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   48: getfield 87	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:nXW	Landroid/util/LongSparseArray;
    //   51: astore 10
    //   53: aload 10
    //   55: ifnull +188 -> 243
    //   58: aload 10
    //   60: invokevirtual 93	android/util/LongSparseArray:toString	()Ljava/lang/String;
    //   63: astore 10
    //   65: ldc 95
    //   67: aload 13
    //   69: aload 10
    //   71: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 12
    //   82: getfield 81	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   85: getfield 87	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:nXW	Landroid/util/LongSparseArray;
    //   88: astore 10
    //   90: aload 10
    //   92: ifnull +138 -> 230
    //   95: aload 10
    //   97: invokevirtual 109	android/util/LongSparseArray:size	()I
    //   100: istore_3
    //   101: iconst_0
    //   102: istore_1
    //   103: iload_1
    //   104: iload_3
    //   105: if_icmpge +125 -> 230
    //   108: aload 10
    //   110: iload_1
    //   111: invokevirtual 113	android/util/LongSparseArray:keyAt	(I)J
    //   114: lstore 4
    //   116: aload 10
    //   118: iload_1
    //   119: invokevirtual 117	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   122: checkcast 119	java/util/List
    //   125: checkcast 121	java/lang/Iterable
    //   128: astore 13
    //   130: new 123	java/util/ArrayList
    //   133: dup
    //   134: invokespecial 124	java/util/ArrayList:<init>	()V
    //   137: checkcast 126	java/util/Collection
    //   140: astore 12
    //   142: aload 13
    //   144: invokeinterface 130 1 0
    //   149: astore 13
    //   151: aload 13
    //   153: invokeinterface 136 1 0
    //   158: ifeq +96 -> 254
    //   161: aload 13
    //   163: invokeinterface 140 1 0
    //   168: astore 14
    //   170: aload 14
    //   172: checkcast 142	java/lang/String
    //   175: checkcast 144	java/lang/CharSequence
    //   178: astore 15
    //   180: aload 15
    //   182: ifnull +492 -> 674
    //   185: aload 15
    //   187: invokeinterface 147 1 0
    //   192: ifne +57 -> 249
    //   195: goto +479 -> 674
    //   198: iload_2
    //   199: ifne -48 -> 151
    //   202: aload 12
    //   204: aload 14
    //   206: invokeinterface 151 2 0
    //   211: pop
    //   212: goto -61 -> 151
    //   215: astore_0
    //   216: ldc 95
    //   218: ldc 153
    //   220: aload_0
    //   221: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   224: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 11
    //   232: checkcast 166	java/util/Map
    //   235: astore_0
    //   236: ldc 49
    //   238: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_0
    //   242: areturn
    //   243: aconst_null
    //   244: astore 10
    //   246: goto -181 -> 65
    //   249: iconst_0
    //   250: istore_2
    //   251: goto -53 -> 198
    //   254: aload 12
    //   256: checkcast 119	java/util/List
    //   259: astore 13
    //   261: aload 13
    //   263: invokeinterface 169 1 0
    //   268: ifne +357 -> 625
    //   271: invokestatic 175	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   274: lstore 6
    //   276: lconst_0
    //   277: lload 4
    //   279: invokestatic 181	java/lang/Math:max	(JJ)J
    //   282: lstore 8
    //   284: new 72	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 183
    //   290: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: lload 6
    //   295: lload 8
    //   297: lsub
    //   298: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: bipush 32
    //   303: invokevirtual 189	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   306: ldc 191
    //   308: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 13
    //   313: checkcast 121	java/lang/Iterable
    //   316: ldc 193
    //   318: checkcast 144	java/lang/CharSequence
    //   321: aconst_null
    //   322: aconst_null
    //   323: iconst_0
    //   324: aconst_null
    //   325: getstatic 197	com/tencent/mm/plugin/appbrand/appcache/predownload/a$a:nIR	Lcom/tencent/mm/plugin/appbrand/appcache/predownload/a$a;
    //   328: checkcast 199	kotlin/g/a/b
    //   331: bipush 30
    //   333: invokestatic 205	kotlin/a/j:a	(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/g/a/b;I)Ljava/lang/String;
    //   336: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: bipush 41
    //   341: invokevirtual 189	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   344: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: astore 12
    //   349: ldc 95
    //   351: ldc 207
    //   353: aload 12
    //   355: invokestatic 157	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   358: invokevirtual 161	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 13
    //   366: checkcast 126	java/util/Collection
    //   369: iconst_0
    //   370: anewarray 142	java/lang/String
    //   373: invokeinterface 211 2 0
    //   378: astore 13
    //   380: aload 13
    //   382: ifnonnull +20 -> 402
    //   385: new 213	kotlin/t
    //   388: dup
    //   389: ldc 215
    //   391: invokespecial 216	kotlin/t:<init>	(Ljava/lang/String;)V
    //   394: astore_0
    //   395: ldc 49
    //   397: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload_0
    //   401: athrow
    //   402: aload_0
    //   403: aload 12
    //   405: aload 13
    //   407: checkcast 218	[Ljava/lang/String;
    //   410: iconst_2
    //   411: invokevirtual 224	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   414: astore 12
    //   416: aload 12
    //   418: ifnull +207 -> 625
    //   421: aload 12
    //   423: checkcast 226	java/io/Closeable
    //   426: astore 12
    //   428: aload 12
    //   430: checkcast 228	android/database/Cursor
    //   433: astore 13
    //   435: aload 13
    //   437: invokeinterface 231 1 0
    //   442: ifeq +172 -> 614
    //   445: aload 13
    //   447: iconst_0
    //   448: invokeinterface 235 2 0
    //   453: astore 14
    //   455: aload 13
    //   457: iconst_1
    //   458: invokeinterface 235 2 0
    //   463: astore 15
    //   465: aload 14
    //   467: checkcast 144	java/lang/CharSequence
    //   470: astore 16
    //   472: aload 16
    //   474: ifnull +205 -> 679
    //   477: aload 16
    //   479: invokeinterface 147 1 0
    //   484: ifne +148 -> 632
    //   487: goto +192 -> 679
    //   490: iload_2
    //   491: ifne +113 -> 604
    //   494: aload 11
    //   496: checkcast 166	java/util/Map
    //   499: astore 16
    //   501: new 237	com/tencent/mm/protocal/protobuf/epy
    //   504: dup
    //   505: invokespecial 238	com/tencent/mm/protocal/protobuf/epy:<init>	()V
    //   508: astore 17
    //   510: aload 17
    //   512: aload 14
    //   514: putfield 242	com/tencent/mm/protocal/protobuf/epy:Txp	Ljava/lang/String;
    //   517: aload 13
    //   519: iconst_2
    //   520: invokeinterface 235 2 0
    //   525: invokestatic 248	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:afv	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   528: astore 18
    //   530: aload 18
    //   532: ifnull +105 -> 637
    //   535: aload 18
    //   537: getfield 252	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   540: istore_2
    //   541: aload 17
    //   543: iload_2
    //   544: putfield 255	com/tencent/mm/protocal/protobuf/epy:Usv	I
    //   547: aload 16
    //   549: aload 14
    //   551: aload 17
    //   553: invokeinterface 259 3 0
    //   558: pop
    //   559: ldc 95
    //   561: new 72	java/lang/StringBuilder
    //   564: dup
    //   565: ldc_w 261
    //   568: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   571: aload 14
    //   573: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 263
    //   579: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 15
    //   584: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc_w 265
    //   590: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: lload 4
    //   595: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 105	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload 13
    //   606: invokeinterface 268 1 0
    //   611: ifne -166 -> 445
    //   614: getstatic 274	kotlin/x:aazN	Lkotlin/x;
    //   617: astore 13
    //   619: aload 12
    //   621: aconst_null
    //   622: invokestatic 279	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   625: iload_1
    //   626: iconst_1
    //   627: iadd
    //   628: istore_1
    //   629: goto -526 -> 103
    //   632: iconst_0
    //   633: istore_2
    //   634: goto -144 -> 490
    //   637: iconst_0
    //   638: istore_2
    //   639: goto -98 -> 541
    //   642: astore 10
    //   644: ldc 49
    //   646: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   649: aload 10
    //   651: athrow
    //   652: astore_0
    //   653: aload 12
    //   655: aload 10
    //   657: invokestatic 279	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   660: ldc 49
    //   662: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: aload_0
    //   666: athrow
    //   667: astore_0
    //   668: aconst_null
    //   669: astore 10
    //   671: goto -18 -> 653
    //   674: iconst_1
    //   675: istore_2
    //   676: goto -478 -> 198
    //   679: iconst_1
    //   680: istore_2
    //   681: goto -191 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	paramh	com.tencent.mm.storagebase.h
    //   102	527	1	i	int
    //   198	483	2	j	int
    //   100	6	3	k	int
    //   114	480	4	l1	long
    //   274	20	6	l2	long
    //   282	14	8	l3	long
    //   51	194	10	localObject1	Object
    //   642	14	10	localThrowable	java.lang.Throwable
    //   669	1	10	localObject2	Object
    //   18	477	11	localHashMap	java.util.HashMap
    //   23	631	12	localObject3	Object
    //   41	577	13	localObject4	Object
    //   168	404	14	localObject5	Object
    //   178	405	15	localObject6	Object
    //   470	78	16	localObject7	Object
    //   508	44	17	localepy	com.tencent.mm.protocal.protobuf.epy
    //   528	8	18	localWxaVersionInfo	com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo
    // Exception table:
    //   from	to	target	type
    //   80	90	215	java/lang/Exception
    //   95	101	215	java/lang/Exception
    //   108	151	215	java/lang/Exception
    //   151	180	215	java/lang/Exception
    //   185	195	215	java/lang/Exception
    //   202	212	215	java/lang/Exception
    //   254	380	215	java/lang/Exception
    //   385	402	215	java/lang/Exception
    //   402	416	215	java/lang/Exception
    //   421	428	215	java/lang/Exception
    //   619	625	215	java/lang/Exception
    //   653	667	215	java/lang/Exception
    //   428	445	642	java/lang/Throwable
    //   445	472	642	java/lang/Throwable
    //   477	487	642	java/lang/Throwable
    //   494	530	642	java/lang/Throwable
    //   535	541	642	java/lang/Throwable
    //   541	604	642	java/lang/Throwable
    //   604	614	642	java/lang/Throwable
    //   614	619	642	java/lang/Throwable
    //   644	652	652	finally
    //   428	445	667	finally
    //   445	472	667	finally
    //   477	487	667	finally
    //   494	530	667	finally
    //   535	541	667	finally
    //   541	604	667	finally
    //   604	614	667	finally
    //   614	619	667	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "invoke"})
  static final class a
    extends q
    implements b<String, String>
  {
    public static final a nIR;
    
    static
    {
      AppMethodBeat.i(244713);
      nIR = new a();
      AppMethodBeat.o(244713);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.a
 * JD-Core Version:    0.7.0.1
 */