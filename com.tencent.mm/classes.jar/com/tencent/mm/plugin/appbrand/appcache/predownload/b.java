package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.util.LongSparseArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.protocal.protobuf.epy;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.g.d.b;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends c<ky>
{
  private static final LongSparseArray<Object> nIS;
  private static final LongSparseArray<Object> nIT;
  private final com.tencent.mm.an.d rr;
  
  static
  {
    AppMethodBeat.i(243040);
    nIS = new LongSparseArray();
    nIT = new LongSparseArray();
    AppMethodBeat.o(243040);
  }
  
  private b(List<epy> paramList)
  {
    AppMethodBeat.i(44371);
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    kx localkx = new kx();
    localkx.RPu.addAll(paramList);
    locala.lBU = localkx;
    locala.lBV = new ky();
    locala.funcId = 2763;
    locala.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
    paramList = locala.bgN();
    this.rr = paramList;
    c(paramList);
    AppMethodBeat.o(44371);
  }
  
  public static void bHP()
  {
    AppMethodBeat.i(243035);
    long l = System.nanoTime();
    synchronized (nIS)
    {
      nIS.put(l, nIS);
      ??? = new Runnable()
      {
        private void bd(List<epy> paramAnonymousList)
        {
          AppMethodBeat.i(44369);
          a locala = a.nKB;
          a.F(0L, 0L);
          new b(paramAnonymousList, (byte)0).bhW().a(com.tencent.mm.vending.h.d.LOGIC, new d.b() {}).a(com.tencent.mm.vending.h.d.LOGIC, new com.tencent.mm.vending.g.d.a()
          {
            public final void cm(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(270926);
              com.tencent.mm.plugin.report.service.h.IzE.el(1422, 2);
              paramAnonymous2Object = a.nKB;
              a.F(0L, 2L);
              AppMethodBeat.o(270926);
            }
          });
          AppMethodBeat.o(44369);
        }
        
        public final void run()
        {
          AppMethodBeat.i(44368);
          int i;
          synchronized (b.bHR())
          {
            b.bHR().remove(this.nIU);
            i = b.bHR().size();
            if (i > 0) {
              com.tencent.mm.plugin.report.service.h.IzE.el(1422, 12);
            }
            if ((!com.tencent.mm.kernel.h.aHE().kbT) || (m.bFB() == null) || (m.bFP() == null))
            {
              AppMethodBeat.o(44368);
              return;
            }
          }
          long l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vmp, Long.valueOf(0L))).longValue();
          long l2 = AppBrandGlobalSystemConfig.bLe().nXs.nXS;
          long l3 = Util.nowSecond();
          if (l3 >= l1 + l2) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vmp, Long.valueOf(l3));
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
              int k = AppBrandGlobalSystemConfig.bLe().nXs.nXV;
              i = 0;
              int j = 0;
              while (i < localObject2.size() / k)
              {
                int m = i * k;
                j = m + k;
                bd(localObject2.subList(m, j));
                i += 1;
              }
              if (j < localObject2.size()) {
                bd(localObject2.subList(j, localObject2.size()));
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
      com.tencent.e.h.ZvG.d((Runnable)???, "MicroMsg.AppBrand.CgiBatchSyncPkgVersion");
      AppMethodBeat.o(243035);
      return;
    }
  }
  
  /* Error */
  private static List<epy> bHQ()
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 137	com/tencent/mm/plugin/appbrand/app/m:bFB	()Lcom/tencent/mm/platformtools/r$a;
    //   8: astore 9
    //   10: invokestatic 143	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLe	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   13: getfield 147	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   16: getfield 152	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:nXU	I
    //   19: istore_1
    //   20: invokestatic 157	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   23: invokestatic 143	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bLe	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   26: getfield 147	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:nXs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   29: getfield 161	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:nXT	J
    //   32: lsub
    //   33: lstore 4
    //   35: invokestatic 167	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   38: ldc 169
    //   40: iconst_0
    //   41: invokeinterface 175 3 0
    //   46: ifne +374 -> 420
    //   49: iconst_1
    //   50: istore_0
    //   51: iload_0
    //   52: ifeq +236 -> 288
    //   55: ldc 177
    //   57: invokestatic 181	com/tencent/mm/plugin/appbrand/app/m:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   60: checkcast 177	com/tencent/mm/plugin/appbrand/appusage/k
    //   63: astore 10
    //   65: aload 10
    //   67: getfield 185	com/tencent/mm/plugin/appbrand/appusage/k:nFQ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   70: instanceof 187
    //   73: ifeq +622 -> 695
    //   76: aload 10
    //   78: getfield 185	com/tencent/mm/plugin/appbrand/appusage/k:nFQ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   81: checkcast 187	com/tencent/mm/sdk/storage/ISQLiteDatabaseEx
    //   84: invokestatic 193	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 196	java/lang/Thread:getId	()J
    //   90: invokeinterface 200 3 0
    //   95: lstore_2
    //   96: aload 10
    //   98: getfield 185	com/tencent/mm/plugin/appbrand/appusage/k:nFQ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   101: ldc 202
    //   103: aconst_null
    //   104: ldc 204
    //   106: iconst_1
    //   107: anewarray 206	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: lload 4
    //   114: invokestatic 210	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: aastore
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokeinterface 216 8 0
    //   126: astore 11
    //   128: aconst_null
    //   129: astore 8
    //   131: aload 11
    //   133: ifnull +80 -> 213
    //   136: aload 11
    //   138: invokeinterface 222 1 0
    //   143: ifne +70 -> 213
    //   146: aload 11
    //   148: invokeinterface 225 1 0
    //   153: ifeq +60 -> 213
    //   156: new 227	com/tencent/mm/plugin/appbrand/appusage/b
    //   159: dup
    //   160: invokespecial 228	com/tencent/mm/plugin/appbrand/appusage/b:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: aload 11
    //   169: invokevirtual 232	com/tencent/mm/plugin/appbrand/appusage/b:convertFrom	(Landroid/database/Cursor;)V
    //   172: aload 7
    //   174: getfield 235	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   177: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +19 -> 199
    //   183: aload 10
    //   185: aload 7
    //   187: getfield 235	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   190: aload 7
    //   192: getfield 244	com/tencent/mm/plugin/appbrand/appusage/b:field_updateTime	J
    //   195: invokevirtual 248	com/tencent/mm/plugin/appbrand/appusage/k:P	(Ljava/lang/String;J)Z
    //   198: pop
    //   199: aload 11
    //   201: invokeinterface 251 1 0
    //   206: istore 6
    //   208: iload 6
    //   210: ifne -45 -> 165
    //   213: aload 11
    //   215: ifnull +10 -> 225
    //   218: aload 11
    //   220: invokeinterface 254 1 0
    //   225: aload 10
    //   227: getfield 185	com/tencent/mm/plugin/appbrand/appusage/k:nFQ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   230: ldc 202
    //   232: ldc_w 256
    //   235: invokeinterface 260 3 0
    //   240: pop
    //   241: aload 10
    //   243: getfield 185	com/tencent/mm/plugin/appbrand/appusage/k:nFQ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   246: instanceof 187
    //   249: ifeq +18 -> 267
    //   252: aload 10
    //   254: getfield 185	com/tencent/mm/plugin/appbrand/appusage/k:nFQ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   257: checkcast 187	com/tencent/mm/sdk/storage/ISQLiteDatabaseEx
    //   260: lload_2
    //   261: invokeinterface 264 3 0
    //   266: pop
    //   267: invokestatic 167	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   270: invokeinterface 268 1 0
    //   275: ldc 169
    //   277: iconst_1
    //   278: invokeinterface 274 3 0
    //   283: invokeinterface 277 1 0
    //   288: ldc 122
    //   290: ldc_w 279
    //   293: iconst_1
    //   294: anewarray 281	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: lload 4
    //   301: invokestatic 284	com/tencent/mm/sdk/platformtools/Util:formatUnixTime	(J)Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: new 54	java/util/LinkedList
    //   311: dup
    //   312: invokespecial 290	java/util/LinkedList:<init>	()V
    //   315: astore 7
    //   317: aload 9
    //   319: invokestatic 296	com/tencent/mm/plugin/appbrand/appcache/predownload/a:b	(Lcom/tencent/mm/storagebase/h;)Ljava/util/Map;
    //   322: astore 8
    //   324: aload 8
    //   326: invokeinterface 300 1 0
    //   331: ifne +18 -> 349
    //   334: aload 7
    //   336: aload 8
    //   338: invokeinterface 304 1 0
    //   343: invokeinterface 307 2 0
    //   348: pop
    //   349: aload 9
    //   351: new 309	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 311
    //   358: invokespecial 314	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: lload 4
    //   363: invokevirtual 318	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   366: ldc_w 320
    //   369: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload_1
    //   373: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 328
    //   379: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: aconst_null
    //   386: iconst_2
    //   387: invokevirtual 338	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   390: astore 10
    //   392: aload 10
    //   394: ifnull +13 -> 407
    //   397: aload 10
    //   399: invokeinterface 222 1 0
    //   404: ifeq +80 -> 484
    //   407: invokestatic 343	java/util/Collections:emptyList	()Ljava/util/List;
    //   410: astore 7
    //   412: ldc 131
    //   414: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload 7
    //   419: areturn
    //   420: iconst_0
    //   421: istore_0
    //   422: goto -371 -> 51
    //   425: astore 8
    //   427: ldc 131
    //   429: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aload 8
    //   434: athrow
    //   435: astore 7
    //   437: aload 11
    //   439: ifnull +15 -> 454
    //   442: aload 8
    //   444: ifnull +30 -> 474
    //   447: aload 11
    //   449: invokeinterface 254 1 0
    //   454: ldc 131
    //   456: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: aload 7
    //   461: athrow
    //   462: astore 11
    //   464: aload 8
    //   466: aload 11
    //   468: invokevirtual 347	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   471: goto -17 -> 454
    //   474: aload 11
    //   476: invokeinterface 254 1 0
    //   481: goto -27 -> 454
    //   484: aload 10
    //   486: invokeinterface 225 1 0
    //   491: ifeq +106 -> 597
    //   494: new 349	com/tencent/mm/plugin/appbrand/config/WxaAttributes
    //   497: dup
    //   498: invokespecial 350	com/tencent/mm/plugin/appbrand/config/WxaAttributes:<init>	()V
    //   501: astore 11
    //   503: aload 10
    //   505: iconst_0
    //   506: invokeinterface 354 2 0
    //   511: astore 12
    //   513: aload 12
    //   515: invokestatic 358	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   518: ifne +69 -> 587
    //   521: aload 8
    //   523: aload 12
    //   525: invokeinterface 362 2 0
    //   530: ifne +57 -> 587
    //   533: aload 11
    //   535: aload 10
    //   537: invokevirtual 363	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   540: new 365	com/tencent/mm/protocal/protobuf/epy
    //   543: dup
    //   544: invokespecial 366	com/tencent/mm/protocal/protobuf/epy:<init>	()V
    //   547: astore 13
    //   549: aload 13
    //   551: aload 12
    //   553: putfield 369	com/tencent/mm/protocal/protobuf/epy:Txp	Ljava/lang/String;
    //   556: aload 11
    //   558: invokevirtual 373	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLH	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   561: ifnull +16 -> 577
    //   564: aload 13
    //   566: aload 11
    //   568: invokevirtual 373	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLH	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   571: getfield 378	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   574: putfield 381	com/tencent/mm/protocal/protobuf/epy:Usv	I
    //   577: aload 7
    //   579: aload 13
    //   581: invokeinterface 384 2 0
    //   586: pop
    //   587: aload 10
    //   589: invokeinterface 251 1 0
    //   594: ifne -91 -> 503
    //   597: aload 10
    //   599: invokeinterface 254 1 0
    //   604: aload 9
    //   606: ldc_w 386
    //   609: ldc_w 388
    //   612: iconst_1
    //   613: anewarray 206	java/lang/String
    //   616: dup
    //   617: iconst_0
    //   618: lload 4
    //   620: invokestatic 210	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   623: aastore
    //   624: invokevirtual 392	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   627: istore_0
    //   628: ldc 122
    //   630: ldc_w 394
    //   633: iconst_2
    //   634: anewarray 281	java/lang/Object
    //   637: dup
    //   638: iconst_0
    //   639: lload 4
    //   641: invokestatic 284	com/tencent/mm/sdk/platformtools/Util:formatUnixTime	(J)Ljava/lang/String;
    //   644: aastore
    //   645: dup
    //   646: iconst_1
    //   647: iload_0
    //   648: invokestatic 399	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   651: aastore
    //   652: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   655: aload 7
    //   657: invokestatic 404	com/tencent/mm/plugin/appbrand/config/a/c:bHZ	()Ljava/util/List;
    //   660: invokeinterface 307 2 0
    //   665: pop
    //   666: aload 7
    //   668: invokestatic 407	com/tencent/mm/plugin/appbrand/appcache/predownload/export/a:bHZ	()Ljava/util/List;
    //   671: invokeinterface 307 2 0
    //   676: pop
    //   677: ldc 131
    //   679: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   682: aload 7
    //   684: areturn
    //   685: astore 7
    //   687: goto -446 -> 241
    //   690: astore 7
    //   692: goto -255 -> 437
    //   695: lconst_0
    //   696: lstore_2
    //   697: goto -601 -> 96
    //   700: astore 7
    //   702: goto -477 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	598	0	i	int
    //   19	354	1	j	int
    //   95	602	2	l1	long
    //   33	607	4	l2	long
    //   206	3	6	bool	boolean
    //   163	255	7	localObject1	Object
    //   435	248	7	localList	List<epy>
    //   685	1	7	localThrowable1	java.lang.Throwable
    //   690	1	7	localObject2	Object
    //   700	1	7	localThrowable2	java.lang.Throwable
    //   129	208	8	localMap	java.util.Map
    //   425	97	8	localThrowable3	java.lang.Throwable
    //   8	597	9	locala	com.tencent.mm.platformtools.r.a
    //   63	535	10	localObject3	Object
    //   126	322	11	localCursor	android.database.Cursor
    //   462	13	11	localThrowable4	java.lang.Throwable
    //   501	66	11	localWxaAttributes	com.tencent.mm.plugin.appbrand.config.WxaAttributes
    //   511	41	12	str	java.lang.String
    //   547	33	13	localepy	epy
    // Exception table:
    //   from	to	target	type
    //   136	165	425	java/lang/Throwable
    //   165	199	425	java/lang/Throwable
    //   199	208	425	java/lang/Throwable
    //   427	435	435	finally
    //   447	454	462	java/lang/Throwable
    //   225	241	685	java/lang/Throwable
    //   136	165	690	finally
    //   165	199	690	finally
    //   199	208	690	finally
    //   96	128	700	java/lang/Throwable
    //   218	225	700	java/lang/Throwable
    //   454	462	700	java/lang/Throwable
    //   464	471	700	java/lang/Throwable
    //   474	481	700	java/lang/Throwable
  }
  
  public final com.tencent.mm.cw.f<c.a<ky>> bhW()
  {
    try
    {
      AppMethodBeat.i(243036);
      com.tencent.mm.plugin.report.service.h.IzE.el(1422, 3);
      com.tencent.mm.cw.f localf = super.bhW();
      AppMethodBeat.o(243036);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b
 * JD-Core Version:    0.7.0.1
 */