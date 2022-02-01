package com.tencent.mm.plugin.appbrand.appcache.predownload;

import android.util.LongSparseArray;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.g.d.b;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends c<li>
{
  private static final LongSparseArray<Object> kON;
  private static final LongSparseArray<Object> kOO;
  private final com.tencent.mm.ak.d rr;
  
  static
  {
    AppMethodBeat.i(226376);
    kON = new LongSparseArray();
    kOO = new LongSparseArray();
    AppMethodBeat.o(226376);
  }
  
  private b(List<efw> paramList)
  {
    AppMethodBeat.i(44371);
    com.tencent.mm.ak.d.a locala = new com.tencent.mm.ak.d.a();
    lh locallh = new lh();
    locallh.KOw.addAll(paramList);
    locala.iLN = locallh;
    locala.iLO = new li();
    locala.funcId = 2763;
    locala.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
    paramList = locala.aXF();
    this.rr = paramList;
    c(paramList);
    AppMethodBeat.o(44371);
  }
  
  public static void bwH()
  {
    AppMethodBeat.i(226373);
    long l = System.nanoTime();
    synchronized (kON)
    {
      kON.put(l, kON);
      ??? = new Runnable()
      {
        private void bf(List<efw> paramAnonymousList)
        {
          AppMethodBeat.i(44369);
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a locala = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
          com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(0L, 0L);
          new b(paramAnonymousList, (byte)0).aYI().a(com.tencent.mm.vending.h.d.LOGIC, new d.b() {}).a(com.tencent.mm.vending.h.d.LOGIC, new com.tencent.mm.vending.g.d.a()
          {
            public final void cn(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(226371);
              com.tencent.mm.plugin.report.service.h.CyF.dN(1422, 2);
              paramAnonymous2Object = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.kQt;
              com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F(0L, 2L);
              AppMethodBeat.o(226371);
            }
          });
          AppMethodBeat.o(44369);
        }
        
        public final void run()
        {
          AppMethodBeat.i(44368);
          int i;
          synchronized (b.bwJ())
          {
            b.bwJ().remove(this.kOP);
            i = b.bwJ().size();
            if (i > 0) {
              com.tencent.mm.plugin.report.service.h.CyF.dN(1422, 12);
            }
            if ((!g.aAf().hpY) || (n.buy() == null) || (n.buL() == null))
            {
              AppMethodBeat.o(44368);
              return;
            }
          }
          long l1 = ((Long)g.aAh().azQ().get(ar.a.NYp, Long.valueOf(0L))).longValue();
          long l2 = AppBrandGlobalSystemConfig.bzP().ldj.ldF;
          long l3 = Util.nowSecond();
          if (l3 >= l1 + l2) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              g.aAh().azQ().set(ar.a.NYp, Long.valueOf(l3));
            }
            try
            {
              ??? = b.bwK();
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
              int k = AppBrandGlobalSystemConfig.bzP().ldj.ldI;
              i = 0;
              int j = 0;
              while (i < localObject2.size() / k)
              {
                int m = i * k;
                j = m + k;
                bf(localObject2.subList(m, j));
                i += 1;
              }
              if (j < localObject2.size()) {
                bf(localObject2.subList(j, localObject2.size()));
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
      com.tencent.f.h.RTc.b((Runnable)???, "MicroMsg.AppBrand.CgiBatchSyncPkgVersion");
      AppMethodBeat.o(226373);
      return;
    }
  }
  
  /* Error */
  private static List<efw> bwI()
  {
    // Byte code:
    //   0: ldc 127
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 133	com/tencent/mm/plugin/appbrand/app/n:buy	()Lcom/tencent/mm/platformtools/r$a;
    //   8: astore 9
    //   10: invokestatic 139	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bzP	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   13: getfield 143	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ldj	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   16: getfield 148	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:ldH	I
    //   19: istore_1
    //   20: invokestatic 153	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   23: invokestatic 139	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bzP	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   26: getfield 143	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:ldj	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   29: getfield 157	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:ldG	J
    //   32: lsub
    //   33: lstore 4
    //   35: invokestatic 163	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   38: ldc 165
    //   40: iconst_0
    //   41: invokeinterface 171 3 0
    //   46: ifne +332 -> 378
    //   49: iconst_1
    //   50: istore_0
    //   51: iload_0
    //   52: ifeq +235 -> 287
    //   55: ldc 173
    //   57: invokestatic 177	com/tencent/mm/plugin/appbrand/app/n:W	(Ljava/lang/Class;)Ljava/lang/Object;
    //   60: checkcast 173	com/tencent/mm/plugin/appbrand/appusage/k
    //   63: astore 10
    //   65: aload 10
    //   67: getfield 181	com/tencent/mm/plugin/appbrand/appusage/k:kLX	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   70: instanceof 183
    //   73: ifeq +577 -> 650
    //   76: aload 10
    //   78: getfield 181	com/tencent/mm/plugin/appbrand/appusage/k:kLX	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   81: checkcast 183	com/tencent/mm/sdk/storage/ISQLiteDatabaseEx
    //   84: invokestatic 189	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 192	java/lang/Thread:getId	()J
    //   90: invokeinterface 196 3 0
    //   95: lstore_2
    //   96: aload 10
    //   98: getfield 181	com/tencent/mm/plugin/appbrand/appusage/k:kLX	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   101: ldc 198
    //   103: aconst_null
    //   104: ldc 200
    //   106: iconst_1
    //   107: anewarray 202	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: lload 4
    //   114: invokestatic 206	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: aastore
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokeinterface 212 8 0
    //   126: astore 11
    //   128: aconst_null
    //   129: astore 8
    //   131: aload 11
    //   133: ifnull +80 -> 213
    //   136: aload 11
    //   138: invokeinterface 218 1 0
    //   143: ifne +70 -> 213
    //   146: aload 11
    //   148: invokeinterface 221 1 0
    //   153: ifeq +60 -> 213
    //   156: new 223	com/tencent/mm/plugin/appbrand/appusage/b
    //   159: dup
    //   160: invokespecial 224	com/tencent/mm/plugin/appbrand/appusage/b:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: aload 11
    //   169: invokevirtual 228	com/tencent/mm/plugin/appbrand/appusage/b:convertFrom	(Landroid/database/Cursor;)V
    //   172: aload 7
    //   174: getfield 231	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   177: invokestatic 237	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +19 -> 199
    //   183: aload 10
    //   185: aload 7
    //   187: getfield 231	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   190: aload 7
    //   192: getfield 240	com/tencent/mm/plugin/appbrand/appusage/b:field_updateTime	J
    //   195: invokevirtual 244	com/tencent/mm/plugin/appbrand/appusage/k:P	(Ljava/lang/String;J)Z
    //   198: pop
    //   199: aload 11
    //   201: invokeinterface 247 1 0
    //   206: istore 6
    //   208: iload 6
    //   210: ifne -45 -> 165
    //   213: aload 11
    //   215: ifnull +10 -> 225
    //   218: aload 11
    //   220: invokeinterface 250 1 0
    //   225: aload 10
    //   227: getfield 181	com/tencent/mm/plugin/appbrand/appusage/k:kLX	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   230: ldc 198
    //   232: ldc 252
    //   234: invokeinterface 256 3 0
    //   239: pop
    //   240: aload 10
    //   242: getfield 181	com/tencent/mm/plugin/appbrand/appusage/k:kLX	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   245: instanceof 183
    //   248: ifeq +18 -> 266
    //   251: aload 10
    //   253: getfield 181	com/tencent/mm/plugin/appbrand/appusage/k:kLX	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   256: checkcast 183	com/tencent/mm/sdk/storage/ISQLiteDatabaseEx
    //   259: lload_2
    //   260: invokeinterface 260 3 0
    //   265: pop
    //   266: invokestatic 163	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   269: invokeinterface 264 1 0
    //   274: ldc 165
    //   276: iconst_1
    //   277: invokeinterface 270 3 0
    //   282: invokeinterface 273 1 0
    //   287: ldc 116
    //   289: ldc_w 275
    //   292: iconst_1
    //   293: anewarray 277	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: lload 4
    //   300: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:formatUnixTime	(J)Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload 9
    //   309: new 287	java/lang/StringBuilder
    //   312: dup
    //   313: ldc_w 289
    //   316: invokespecial 292	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: lload 4
    //   321: invokevirtual 296	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: ldc_w 298
    //   327: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload_1
    //   331: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc_w 306
    //   337: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: aconst_null
    //   344: iconst_2
    //   345: invokevirtual 316	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   348: astore 7
    //   350: aload 7
    //   352: ifnull +13 -> 365
    //   355: aload 7
    //   357: invokeinterface 218 1 0
    //   362: ifeq +80 -> 442
    //   365: invokestatic 321	java/util/Collections:emptyList	()Ljava/util/List;
    //   368: astore 7
    //   370: ldc 127
    //   372: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload 7
    //   377: areturn
    //   378: iconst_0
    //   379: istore_0
    //   380: goto -329 -> 51
    //   383: astore 8
    //   385: ldc 127
    //   387: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: aload 8
    //   392: athrow
    //   393: astore 7
    //   395: aload 11
    //   397: ifnull +15 -> 412
    //   400: aload 8
    //   402: ifnull +30 -> 432
    //   405: aload 11
    //   407: invokeinterface 250 1 0
    //   412: ldc 127
    //   414: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload 7
    //   419: athrow
    //   420: astore 11
    //   422: aload 8
    //   424: aload 11
    //   426: invokevirtual 325	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   429: goto -17 -> 412
    //   432: aload 11
    //   434: invokeinterface 250 1 0
    //   439: goto -27 -> 412
    //   442: new 54	java/util/LinkedList
    //   445: dup
    //   446: invokespecial 326	java/util/LinkedList:<init>	()V
    //   449: astore 8
    //   451: aload 7
    //   453: invokeinterface 221 1 0
    //   458: ifeq +94 -> 552
    //   461: new 328	com/tencent/mm/plugin/appbrand/config/WxaAttributes
    //   464: dup
    //   465: invokespecial 329	com/tencent/mm/plugin/appbrand/config/WxaAttributes:<init>	()V
    //   468: astore 10
    //   470: aload 7
    //   472: iconst_0
    //   473: invokeinterface 333 2 0
    //   478: astore 11
    //   480: aload 11
    //   482: invokestatic 337	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   485: ifne +57 -> 542
    //   488: aload 10
    //   490: aload 7
    //   492: invokevirtual 338	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   495: new 340	com/tencent/mm/protocal/protobuf/efw
    //   498: dup
    //   499: invokespecial 341	com/tencent/mm/protocal/protobuf/efw:<init>	()V
    //   502: astore 12
    //   504: aload 12
    //   506: aload 11
    //   508: putfield 344	com/tencent/mm/protocal/protobuf/efw:Mmv	Ljava/lang/String;
    //   511: aload 10
    //   513: invokevirtual 348	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAp	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   516: ifnull +16 -> 532
    //   519: aload 12
    //   521: aload 10
    //   523: invokevirtual 348	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAp	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   526: getfield 353	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:appVersion	I
    //   529: putfield 356	com/tencent/mm/protocal/protobuf/efw:NfQ	I
    //   532: aload 8
    //   534: aload 12
    //   536: invokeinterface 362 2 0
    //   541: pop
    //   542: aload 7
    //   544: invokeinterface 247 1 0
    //   549: ifne -79 -> 470
    //   552: aload 7
    //   554: invokeinterface 250 1 0
    //   559: aload 9
    //   561: ldc_w 364
    //   564: ldc_w 366
    //   567: iconst_1
    //   568: anewarray 202	java/lang/String
    //   571: dup
    //   572: iconst_0
    //   573: lload 4
    //   575: invokestatic 206	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   578: aastore
    //   579: invokevirtual 370	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   582: istore_0
    //   583: ldc 116
    //   585: ldc_w 372
    //   588: iconst_2
    //   589: anewarray 277	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: lload 4
    //   596: invokestatic 280	com/tencent/mm/sdk/platformtools/Util:formatUnixTime	(J)Ljava/lang/String;
    //   599: aastore
    //   600: dup
    //   601: iconst_1
    //   602: iload_0
    //   603: invokestatic 377	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   606: aastore
    //   607: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload 8
    //   612: invokestatic 382	com/tencent/mm/plugin/appbrand/config/a/c:bwS	()Ljava/util/List;
    //   615: invokeinterface 383 2 0
    //   620: pop
    //   621: aload 8
    //   623: invokestatic 386	com/tencent/mm/plugin/appbrand/appcache/predownload/export/a:bwS	()Ljava/util/List;
    //   626: invokeinterface 383 2 0
    //   631: pop
    //   632: ldc 127
    //   634: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   637: aload 8
    //   639: areturn
    //   640: astore 7
    //   642: goto -402 -> 240
    //   645: astore 7
    //   647: goto -252 -> 395
    //   650: lconst_0
    //   651: lstore_2
    //   652: goto -556 -> 96
    //   655: astore 7
    //   657: goto -432 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	553	0	i	int
    //   19	312	1	j	int
    //   95	557	2	l1	long
    //   33	562	4	l2	long
    //   206	3	6	bool	boolean
    //   163	213	7	localObject1	Object
    //   393	160	7	localCursor1	android.database.Cursor
    //   640	1	7	localThrowable1	java.lang.Throwable
    //   645	1	7	localObject2	Object
    //   655	1	7	localThrowable2	java.lang.Throwable
    //   129	1	8	localObject3	Object
    //   383	40	8	localThrowable3	java.lang.Throwable
    //   449	189	8	localLinkedList	LinkedList
    //   8	552	9	locala	com.tencent.mm.platformtools.r.a
    //   63	459	10	localObject4	Object
    //   126	280	11	localCursor2	android.database.Cursor
    //   420	13	11	localThrowable4	java.lang.Throwable
    //   478	29	11	str	java.lang.String
    //   502	33	12	localefw	efw
    // Exception table:
    //   from	to	target	type
    //   136	165	383	java/lang/Throwable
    //   165	199	383	java/lang/Throwable
    //   199	208	383	java/lang/Throwable
    //   385	393	393	finally
    //   405	412	420	java/lang/Throwable
    //   225	240	640	java/lang/Throwable
    //   136	165	645	finally
    //   165	199	645	finally
    //   199	208	645	finally
    //   96	128	655	java/lang/Throwable
    //   218	225	655	java/lang/Throwable
    //   412	420	655	java/lang/Throwable
    //   422	429	655	java/lang/Throwable
    //   432	439	655	java/lang/Throwable
  }
  
  public final f<c.a<li>> aYI()
  {
    try
    {
      AppMethodBeat.i(226374);
      com.tencent.mm.plugin.report.service.h.CyF.dN(1422, 3);
      f localf = super.aYI();
      AppMethodBeat.o(226374);
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b
 * JD-Core Version:    0.7.0.1
 */