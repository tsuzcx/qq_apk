package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.protocal.protobuf.flb;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.protocal.protobuf.lu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends com.tencent.mm.am.b<lu>
{
  private static final LongSparseArray<Object> qII;
  private static final LongSparseArray<Object> qIJ;
  private final c rr;
  
  static
  {
    AppMethodBeat.i(320421);
    qII = new LongSparseArray();
    qIJ = new LongSparseArray();
    AppMethodBeat.o(320421);
  }
  
  private b(List<flb> paramList)
  {
    AppMethodBeat.i(44371);
    c.a locala = new c.a();
    lt locallt = new lt();
    locallt.YMH.addAll(paramList);
    locala.otE = locallt;
    locala.otF = new lu();
    locala.funcId = 2763;
    locala.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
    paramList = locala.bEF();
    this.rr = paramList;
    c(paramList);
    AppMethodBeat.o(44371);
  }
  
  public static void chm()
  {
    AppMethodBeat.i(320398);
    long l = System.nanoTime();
    synchronized (qII)
    {
      qII.put(l, qII);
      ??? = new Runnable()
      {
        private void cL(List<flb> paramAnonymousList)
        {
          AppMethodBeat.i(44369);
          a locala = a.qJY;
          a.ac(0L, 0L);
          new b(paramAnonymousList, (byte)0).bFJ().a(com.tencent.mm.vending.h.d.LOGIC, new d.b() {}).a(com.tencent.mm.vending.h.d.LOGIC, new d.a()
          {
            public final void onInterrupt(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(320418);
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1422, 2);
              paramAnonymous2Object = a.qJY;
              a.ac(0L, 2L);
              AppMethodBeat.o(320418);
            }
          });
          AppMethodBeat.o(44369);
        }
        
        public final void run()
        {
          AppMethodBeat.i(44368);
          int i;
          synchronized (b.cho())
          {
            b.cho().remove(this.qIK);
            i = b.cho().size();
            if (i > 0) {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(1422, 12);
            }
            if ((!com.tencent.mm.kernel.h.baC().mBZ) || (n.ceY() == null) || (n.cfm() == null))
            {
              AppMethodBeat.o(44368);
              return;
            }
          }
          long l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNK, Long.valueOf(0L))).longValue();
          long l2 = AppBrandGlobalSystemConfig.ckD().qXi.qXS;
          long l3 = Util.nowSecond();
          if (l3 >= l1 + l2) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acNK, Long.valueOf(l3));
            }
            try
            {
              ??? = b.access$100();
              if (Util.isNullOrNil((List)???))
              {
                Log.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
                AppMethodBeat.o(44368);
                return;
                if (l1 > l2 + l3)
                {
                  i = 1;
                  continue;
                }
                i = 0;
                continue;
                AppMethodBeat.o(44368);
                return;
              }
            }
            catch (com.tencent.wcdb.database.SQLiteDiskIOException localSQLiteDiskIOException)
            {
              Object localObject2;
              for (;;)
              {
                Log.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit::collectReqInfoList, e=%s", new Object[] { localSQLiteDiskIOException });
                localObject2 = null;
              }
              Log.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, collectReqInfoList.size=%d", new Object[] { Integer.valueOf(localObject2.size()) });
              int k = AppBrandGlobalSystemConfig.ckD().qXi.qXV;
              i = 0;
              int j = 0;
              while (i < localObject2.size() / k)
              {
                int m = i * k;
                j = m + k;
                cL(localObject2.subList(m, j));
                i += 1;
              }
              if (j < localObject2.size()) {
                cL(localObject2.subList(j, localObject2.size()));
              }
              AppMethodBeat.o(44368);
              return;
            }
            catch (android.database.sqlite.SQLiteDiskIOException localSQLiteDiskIOException1)
            {
              label217:
              break label217;
            }
          }
        }
      };
      com.tencent.threadpool.h.ahAA.g((Runnable)???, "MicroMsg.AppBrand.CgiBatchSyncPkgVersion");
      AppMethodBeat.o(320398);
      return;
    }
  }
  
  /* Error */
  private static List<flb> chn()
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 135	com/tencent/mm/plugin/appbrand/app/n:ceY	()Lcom/tencent/mm/platformtools/o$a;
    //   8: astore 7
    //   10: invokestatic 141	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckD	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   13: getfield 145	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qXi	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   16: getfield 150	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:qXU	I
    //   19: istore_1
    //   20: invokestatic 155	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   23: invokestatic 141	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ckD	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   26: getfield 145	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:qXi	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   29: getfield 159	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:qXT	J
    //   32: lsub
    //   33: lstore 4
    //   35: invokestatic 165	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   38: ldc 167
    //   40: iconst_0
    //   41: invokeinterface 173 3 0
    //   46: ifne +370 -> 416
    //   49: iconst_1
    //   50: istore_0
    //   51: iload_0
    //   52: ifeq +232 -> 284
    //   55: ldc 175
    //   57: invokestatic 179	com/tencent/mm/plugin/appbrand/app/n:ag	(Ljava/lang/Class;)Ljava/lang/Object;
    //   60: checkcast 175	com/tencent/mm/plugin/appbrand/appusage/j
    //   63: astore 8
    //   65: aload 8
    //   67: getfield 183	com/tencent/mm/plugin/appbrand/appusage/j:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   70: instanceof 185
    //   73: ifeq +577 -> 650
    //   76: aload 8
    //   78: getfield 183	com/tencent/mm/plugin/appbrand/appusage/j:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   81: checkcast 185	com/tencent/mm/sdk/storage/ISQLiteDatabaseEx
    //   84: invokestatic 191	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 194	java/lang/Thread:getId	()J
    //   90: invokeinterface 198 3 0
    //   95: lstore_2
    //   96: aload 8
    //   98: getfield 183	com/tencent/mm/plugin/appbrand/appusage/j:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   101: ldc 200
    //   103: aconst_null
    //   104: ldc 202
    //   106: iconst_1
    //   107: anewarray 204	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: lload 4
    //   114: invokestatic 208	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: aastore
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokeinterface 214 8 0
    //   126: astore 9
    //   128: aload 9
    //   130: ifnull +80 -> 210
    //   133: aload 9
    //   135: invokeinterface 220 1 0
    //   140: ifne +70 -> 210
    //   143: aload 9
    //   145: invokeinterface 223 1 0
    //   150: ifeq +60 -> 210
    //   153: new 225	com/tencent/mm/plugin/appbrand/appusage/b
    //   156: dup
    //   157: invokespecial 226	com/tencent/mm/plugin/appbrand/appusage/b:<init>	()V
    //   160: astore 10
    //   162: aload 10
    //   164: aload 9
    //   166: invokevirtual 230	com/tencent/mm/plugin/appbrand/appusage/b:convertFrom	(Landroid/database/Cursor;)V
    //   169: aload 10
    //   171: getfield 233	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   174: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +19 -> 196
    //   180: aload 8
    //   182: aload 10
    //   184: getfield 233	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   187: aload 10
    //   189: getfield 242	com/tencent/mm/plugin/appbrand/appusage/b:field_updateTime	J
    //   192: invokevirtual 246	com/tencent/mm/plugin/appbrand/appusage/j:U	(Ljava/lang/String;J)Z
    //   195: pop
    //   196: aload 9
    //   198: invokeinterface 249 1 0
    //   203: istore 6
    //   205: iload 6
    //   207: ifne -45 -> 162
    //   210: aload 9
    //   212: ifnull +10 -> 222
    //   215: aload 9
    //   217: invokeinterface 252 1 0
    //   222: aload 8
    //   224: getfield 183	com/tencent/mm/plugin/appbrand/appusage/j:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   227: ldc 200
    //   229: ldc 254
    //   231: invokeinterface 258 3 0
    //   236: pop
    //   237: aload 8
    //   239: getfield 183	com/tencent/mm/plugin/appbrand/appusage/j:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   242: instanceof 185
    //   245: ifeq +18 -> 263
    //   248: aload 8
    //   250: getfield 183	com/tencent/mm/plugin/appbrand/appusage/j:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   253: checkcast 185	com/tencent/mm/sdk/storage/ISQLiteDatabaseEx
    //   256: lload_2
    //   257: invokeinterface 262 3 0
    //   262: pop
    //   263: invokestatic 165	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   266: invokeinterface 266 1 0
    //   271: ldc 167
    //   273: iconst_1
    //   274: invokeinterface 272 3 0
    //   279: invokeinterface 275 1 0
    //   284: ldc 122
    //   286: ldc_w 277
    //   289: iconst_1
    //   290: anewarray 279	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: lload 4
    //   297: invokestatic 282	com/tencent/mm/sdk/platformtools/Util:formatUnixTime	(J)Ljava/lang/String;
    //   300: aastore
    //   301: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: new 54	java/util/LinkedList
    //   307: dup
    //   308: invokespecial 288	java/util/LinkedList:<init>	()V
    //   311: astore 8
    //   313: aload 7
    //   315: invokestatic 294	com/tencent/mm/plugin/appbrand/appcache/predownload/a:b	(Lcom/tencent/mm/storagebase/h;)Ljava/util/Map;
    //   318: astore 9
    //   320: aload 9
    //   322: invokeinterface 298 1 0
    //   327: ifne +18 -> 345
    //   330: aload 8
    //   332: aload 9
    //   334: invokeinterface 302 1 0
    //   339: invokeinterface 305 2 0
    //   344: pop
    //   345: aload 7
    //   347: new 307	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 309
    //   354: invokespecial 312	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: lload 4
    //   359: invokevirtual 316	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   362: ldc_w 318
    //   365: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload_1
    //   369: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: ldc_w 326
    //   375: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 330	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: aconst_null
    //   382: iconst_2
    //   383: invokevirtual 336	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   386: astore 10
    //   388: aload 10
    //   390: ifnull +13 -> 403
    //   393: aload 10
    //   395: invokeinterface 220 1 0
    //   400: ifeq +55 -> 455
    //   403: invokestatic 341	java/util/Collections:emptyList	()Ljava/util/List;
    //   406: astore 7
    //   408: ldc 129
    //   410: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: aload 7
    //   415: areturn
    //   416: iconst_0
    //   417: istore_0
    //   418: goto -367 -> 51
    //   421: astore 10
    //   423: aload 9
    //   425: ifnull +10 -> 435
    //   428: aload 9
    //   430: invokeinterface 252 1 0
    //   435: ldc 129
    //   437: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload 10
    //   442: athrow
    //   443: astore 9
    //   445: aload 10
    //   447: aload 9
    //   449: invokevirtual 347	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   452: goto -17 -> 435
    //   455: aload 10
    //   457: invokeinterface 223 1 0
    //   462: ifeq +106 -> 568
    //   465: new 349	com/tencent/mm/plugin/appbrand/config/WxaAttributes
    //   468: dup
    //   469: invokespecial 350	com/tencent/mm/plugin/appbrand/config/WxaAttributes:<init>	()V
    //   472: astore 11
    //   474: aload 10
    //   476: iconst_0
    //   477: invokeinterface 354 2 0
    //   482: astore 12
    //   484: aload 12
    //   486: invokestatic 358	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   489: ifne +69 -> 558
    //   492: aload 9
    //   494: aload 12
    //   496: invokeinterface 362 2 0
    //   501: ifne +57 -> 558
    //   504: aload 11
    //   506: aload 10
    //   508: invokevirtual 363	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   511: new 365	com/tencent/mm/protocal/protobuf/flb
    //   514: dup
    //   515: invokespecial 366	com/tencent/mm/protocal/protobuf/flb:<init>	()V
    //   518: astore 13
    //   520: aload 13
    //   522: aload 12
    //   524: putfield 369	com/tencent/mm/protocal/protobuf/flb:aaLU	Ljava/lang/String;
    //   527: aload 11
    //   529: invokevirtual 373	com/tencent/mm/plugin/appbrand/config/WxaAttributes:clf	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   532: ifnull +16 -> 548
    //   535: aload 13
    //   537: aload 11
    //   539: invokevirtual 373	com/tencent/mm/plugin/appbrand/config/WxaAttributes:clf	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   542: getfield 378	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   545: putfield 381	com/tencent/mm/protocal/protobuf/flb:abLC	I
    //   548: aload 8
    //   550: aload 13
    //   552: invokeinterface 384 2 0
    //   557: pop
    //   558: aload 10
    //   560: invokeinterface 249 1 0
    //   565: ifne -91 -> 474
    //   568: aload 10
    //   570: invokeinterface 252 1 0
    //   575: aload 7
    //   577: ldc_w 386
    //   580: ldc_w 388
    //   583: iconst_1
    //   584: anewarray 204	java/lang/String
    //   587: dup
    //   588: iconst_0
    //   589: lload 4
    //   591: invokestatic 208	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   594: aastore
    //   595: invokevirtual 392	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   598: istore_0
    //   599: ldc 122
    //   601: ldc_w 394
    //   604: iconst_2
    //   605: anewarray 279	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: lload 4
    //   612: invokestatic 282	com/tencent/mm/sdk/platformtools/Util:formatUnixTime	(J)Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload_0
    //   619: invokestatic 399	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   626: aload 8
    //   628: invokestatic 404	com/tencent/mm/plugin/appbrand/appcache/predownload/export/a:chv	()Ljava/util/List;
    //   631: invokeinterface 305 2 0
    //   636: pop
    //   637: ldc 129
    //   639: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   642: aload 8
    //   644: areturn
    //   645: astore 9
    //   647: goto -410 -> 237
    //   650: lconst_0
    //   651: lstore_2
    //   652: goto -556 -> 96
    //   655: astore 9
    //   657: goto -435 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	569	0	i	int
    //   19	350	1	j	int
    //   95	557	2	l1	long
    //   33	578	4	l2	long
    //   203	3	6	bool	boolean
    //   8	568	7	localObject1	Object
    //   63	580	8	localObject2	Object
    //   126	303	9	localObject3	Object
    //   443	50	9	localThrowable	java.lang.Throwable
    //   645	1	9	localObject4	Object
    //   655	1	9	localObject5	Object
    //   160	234	10	localObject6	Object
    //   421	148	10	localCursor	android.database.Cursor
    //   472	66	11	localWxaAttributes	com.tencent.mm.plugin.appbrand.config.WxaAttributes
    //   482	41	12	str	java.lang.String
    //   518	33	13	localflb	flb
    // Exception table:
    //   from	to	target	type
    //   133	162	421	finally
    //   162	196	421	finally
    //   196	205	421	finally
    //   428	435	443	finally
    //   222	237	645	finally
    //   96	128	655	finally
    //   215	222	655	finally
    //   435	443	655	finally
    //   445	452	655	finally
  }
  
  public final com.tencent.mm.cp.f<b.a<lu>> bFJ()
  {
    try
    {
      AppMethodBeat.i(320424);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1422, 3);
      com.tencent.mm.cp.f localf = super.bFJ();
      AppMethodBeat.o(320424);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b
 * JD-Core Version:    0.7.0.1
 */