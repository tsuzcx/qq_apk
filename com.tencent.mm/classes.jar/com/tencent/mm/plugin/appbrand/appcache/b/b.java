package com.tencent.mm.plugin.appbrand.appcache.b;

import android.util.LongSparseArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.protocal.protobuf.ki;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends com.tencent.mm.ak.a<ki>
{
  private static final LongSparseArray<Object> jpN;
  private static final LongSparseArray<Object> jpO;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(186332);
    jpN = new LongSparseArray();
    jpO = new LongSparseArray();
    AppMethodBeat.o(186332);
  }
  
  private b(List<dfy> paramList)
  {
    AppMethodBeat.i(44371);
    b.a locala = new b.a();
    kh localkh = new kh();
    localkh.DWX.addAll(paramList);
    locala.hvt = localkh;
    locala.hvu = new ki();
    locala.funcId = 2763;
    locala.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
    paramList = locala.aAz();
    this.rr = paramList;
    this.rr = paramList;
    AppMethodBeat.o(44371);
  }
  
  public static void aXx()
  {
    AppMethodBeat.i(186329);
    long l = System.nanoTime();
    synchronized (jpN)
    {
      jpN.put(l, jpN);
      ??? = new Runnable()
      {
        private void aU(List<dfy> paramAnonymousList)
        {
          AppMethodBeat.i(44369);
          com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(0L, 0L);
          new b(paramAnonymousList, (byte)0).aBB().a(com.tencent.mm.vending.h.d.Jrh, new d.b() {}).a(com.tencent.mm.vending.h.d.Jrh, new d.a()
          {
            public final void cc(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(186327);
              com.tencent.mm.plugin.report.service.h.wUl.dB(1422, 2);
              paramAnonymous2Object = com.tencent.mm.plugin.appbrand.appcache.b.c.a.jqG;
              com.tencent.mm.plugin.appbrand.appcache.b.c.a.A(0L, 2L);
              AppMethodBeat.o(186327);
            }
          });
          AppMethodBeat.o(44369);
        }
        
        public final void run()
        {
          AppMethodBeat.i(44368);
          int i;
          synchronized (b.aXz())
          {
            b.aXz().remove(this.jpP);
            i = b.aXz().size();
            if (i > 0) {
              com.tencent.mm.plugin.report.service.h.wUl.dB(1422, 12);
            }
            if ((!g.agP().ggT) || (j.aVq() == null) || (j.aVC() == null))
            {
              AppMethodBeat.o(44368);
              return;
            }
          }
          long l1 = ((Long)g.agR().agA().get(ah.a.GJy, Long.valueOf(0L))).longValue();
          long l2 = AppBrandGlobalSystemConfig.bat().jCV.jDq;
          long l3 = bs.aNx();
          if (l3 >= l1 + l2) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0) {
              g.agR().agA().set(ah.a.GJy, Long.valueOf(l3));
            }
            try
            {
              ??? = b.aXA();
              if (bs.gY((List)???))
              {
                ac.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
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
                ac.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit::collectReqInfoList, e=%s", new Object[] { localSQLiteDiskIOException });
                localObject2 = null;
              }
              ac.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, collectReqInfoList.size=%d", new Object[] { Integer.valueOf(localObject2.size()) });
              int k = AppBrandGlobalSystemConfig.bat().jCV.jDt;
              i = 0;
              int j = 0;
              while (i < localObject2.size() / k)
              {
                int m = i * k;
                j = m + k;
                aU(localObject2.subList(m, j));
                i += 1;
              }
              if (j < localObject2.size()) {
                aU(localObject2.subList(j, localObject2.size()));
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
      com.tencent.e.h.JZN.f((Runnable)???, "MicroMsg.AppBrand.CgiBatchSyncPkgVersion");
      AppMethodBeat.o(186329);
      return;
    }
  }
  
  /* Error */
  private static List<dfy> aXy()
  {
    // Byte code:
    //   0: ldc 128
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 134	com/tencent/mm/plugin/appbrand/app/j:aVq	()Lcom/tencent/mm/platformtools/r$a;
    //   8: astore 9
    //   10: invokestatic 140	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bat	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   13: getfield 144	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jCV	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   16: getfield 149	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:jDs	I
    //   19: istore_1
    //   20: invokestatic 154	com/tencent/mm/sdk/platformtools/bs:aNx	()J
    //   23: invokestatic 140	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:bat	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   26: getfield 144	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jCV	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   29: getfield 158	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:jDr	J
    //   32: lsub
    //   33: lstore 4
    //   35: invokestatic 164	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   38: ldc 166
    //   40: iconst_0
    //   41: invokeinterface 172 3 0
    //   46: ifne +332 -> 378
    //   49: iconst_1
    //   50: istore_0
    //   51: iload_0
    //   52: ifeq +235 -> 287
    //   55: ldc 174
    //   57: invokestatic 178	com/tencent/mm/plugin/appbrand/app/j:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   60: checkcast 174	com/tencent/mm/plugin/appbrand/appusage/k
    //   63: astore 10
    //   65: aload 10
    //   67: getfield 182	com/tencent/mm/plugin/appbrand/appusage/k:jnc	Lcom/tencent/mm/sdk/e/e;
    //   70: instanceof 184
    //   73: ifeq +566 -> 639
    //   76: aload 10
    //   78: getfield 182	com/tencent/mm/plugin/appbrand/appusage/k:jnc	Lcom/tencent/mm/sdk/e/e;
    //   81: checkcast 184	com/tencent/mm/sdk/e/f
    //   84: invokestatic 190	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 193	java/lang/Thread:getId	()J
    //   90: invokeinterface 197 3 0
    //   95: lstore_2
    //   96: aload 10
    //   98: getfield 182	com/tencent/mm/plugin/appbrand/appusage/k:jnc	Lcom/tencent/mm/sdk/e/e;
    //   101: ldc 199
    //   103: aconst_null
    //   104: ldc 201
    //   106: iconst_1
    //   107: anewarray 203	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: lload 4
    //   114: invokestatic 207	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: aastore
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokeinterface 213 8 0
    //   126: astore 11
    //   128: aconst_null
    //   129: astore 8
    //   131: aload 11
    //   133: ifnull +80 -> 213
    //   136: aload 11
    //   138: invokeinterface 219 1 0
    //   143: ifne +70 -> 213
    //   146: aload 11
    //   148: invokeinterface 222 1 0
    //   153: ifeq +60 -> 213
    //   156: new 224	com/tencent/mm/plugin/appbrand/appusage/b
    //   159: dup
    //   160: invokespecial 225	com/tencent/mm/plugin/appbrand/appusage/b:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: aload 11
    //   169: invokevirtual 229	com/tencent/mm/plugin/appbrand/appusage/b:convertFrom	(Landroid/database/Cursor;)V
    //   172: aload 7
    //   174: getfield 232	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   177: invokestatic 238	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +19 -> 199
    //   183: aload 10
    //   185: aload 7
    //   187: getfield 232	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   190: aload 7
    //   192: getfield 241	com/tencent/mm/plugin/appbrand/appusage/b:field_updateTime	J
    //   195: invokevirtual 244	com/tencent/mm/plugin/appbrand/appusage/k:I	(Ljava/lang/String;J)Z
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
    //   227: getfield 182	com/tencent/mm/plugin/appbrand/appusage/k:jnc	Lcom/tencent/mm/sdk/e/e;
    //   230: ldc 199
    //   232: ldc 252
    //   234: invokeinterface 256 3 0
    //   239: pop
    //   240: aload 10
    //   242: getfield 182	com/tencent/mm/plugin/appbrand/appusage/k:jnc	Lcom/tencent/mm/sdk/e/e;
    //   245: instanceof 184
    //   248: ifeq +18 -> 266
    //   251: aload 10
    //   253: getfield 182	com/tencent/mm/plugin/appbrand/appusage/k:jnc	Lcom/tencent/mm/sdk/e/e;
    //   256: checkcast 184	com/tencent/mm/sdk/e/f
    //   259: lload_2
    //   260: invokeinterface 260 3 0
    //   265: pop
    //   266: invokestatic 164	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   269: invokeinterface 264 1 0
    //   274: ldc 166
    //   276: iconst_1
    //   277: invokeinterface 270 3 0
    //   282: invokeinterface 273 1 0
    //   287: ldc 119
    //   289: ldc_w 275
    //   292: iconst_1
    //   293: anewarray 277	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: lload 4
    //   300: invokestatic 280	com/tencent/mm/sdk/platformtools/bs:Am	(J)Ljava/lang/String;
    //   303: aastore
    //   304: invokestatic 285	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   345: invokevirtual 316	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   348: astore 7
    //   350: aload 7
    //   352: ifnull +13 -> 365
    //   355: aload 7
    //   357: invokeinterface 219 1 0
    //   362: ifeq +80 -> 442
    //   365: invokestatic 321	java/util/Collections:emptyList	()Ljava/util/List;
    //   368: astore 7
    //   370: ldc 128
    //   372: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload 7
    //   377: areturn
    //   378: iconst_0
    //   379: istore_0
    //   380: goto -329 -> 51
    //   383: astore 8
    //   385: ldc 128
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
    //   412: ldc 128
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
    //   453: invokeinterface 222 1 0
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
    //   482: invokestatic 337	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   485: ifne +57 -> 542
    //   488: aload 10
    //   490: aload 7
    //   492: invokevirtual 338	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   495: new 340	com/tencent/mm/protocal/protobuf/dfy
    //   498: dup
    //   499: invokespecial 341	com/tencent/mm/protocal/protobuf/dfy:<init>	()V
    //   502: astore 12
    //   504: aload 12
    //   506: aload 11
    //   508: putfield 344	com/tencent/mm/protocal/protobuf/dfy:Fed	Ljava/lang/String;
    //   511: aload 10
    //   513: invokevirtual 348	com/tencent/mm/plugin/appbrand/config/WxaAttributes:baN	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   516: ifnull +16 -> 532
    //   519: aload 12
    //   521: aload 10
    //   523: invokevirtual 348	com/tencent/mm/plugin/appbrand/config/WxaAttributes:baN	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   526: getfield 353	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:aBM	I
    //   529: putfield 356	com/tencent/mm/protocal/protobuf/dfy:FPk	I
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
    //   568: anewarray 203	java/lang/String
    //   571: dup
    //   572: iconst_0
    //   573: lload 4
    //   575: invokestatic 207	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   578: aastore
    //   579: invokevirtual 370	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   582: istore_0
    //   583: ldc 119
    //   585: ldc_w 372
    //   588: iconst_2
    //   589: anewarray 277	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: lload 4
    //   596: invokestatic 280	com/tencent/mm/sdk/platformtools/bs:Am	(J)Ljava/lang/String;
    //   599: aastore
    //   600: dup
    //   601: iconst_1
    //   602: iload_0
    //   603: invokestatic 377	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   606: aastore
    //   607: invokestatic 285	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload 8
    //   612: invokestatic 382	com/tencent/mm/plugin/appbrand/config/a/c:baU	()Ljava/util/List;
    //   615: invokeinterface 383 2 0
    //   620: pop
    //   621: ldc 128
    //   623: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   626: aload 8
    //   628: areturn
    //   629: astore 7
    //   631: goto -391 -> 240
    //   634: astore 7
    //   636: goto -241 -> 395
    //   639: lconst_0
    //   640: lstore_2
    //   641: goto -545 -> 96
    //   644: astore 7
    //   646: goto -421 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	553	0	i	int
    //   19	312	1	j	int
    //   95	546	2	l1	long
    //   33	562	4	l2	long
    //   206	3	6	bool	boolean
    //   163	213	7	localObject1	Object
    //   393	160	7	localCursor1	android.database.Cursor
    //   629	1	7	localThrowable1	java.lang.Throwable
    //   634	1	7	localObject2	Object
    //   644	1	7	localThrowable2	java.lang.Throwable
    //   129	1	8	localObject3	Object
    //   383	40	8	localThrowable3	java.lang.Throwable
    //   449	178	8	localLinkedList	LinkedList
    //   8	552	9	locala	com.tencent.mm.platformtools.r.a
    //   63	459	10	localObject4	Object
    //   126	280	11	localCursor2	android.database.Cursor
    //   420	13	11	localThrowable4	java.lang.Throwable
    //   478	29	11	str	java.lang.String
    //   502	33	12	localdfy	dfy
    // Exception table:
    //   from	to	target	type
    //   136	165	383	java/lang/Throwable
    //   165	199	383	java/lang/Throwable
    //   199	208	383	java/lang/Throwable
    //   385	393	393	finally
    //   405	412	420	java/lang/Throwable
    //   225	240	629	java/lang/Throwable
    //   136	165	634	finally
    //   165	199	634	finally
    //   199	208	634	finally
    //   96	128	644	java/lang/Throwable
    //   218	225	644	java/lang/Throwable
    //   412	420	644	java/lang/Throwable
    //   422	429	644	java/lang/Throwable
    //   432	439	644	java/lang/Throwable
  }
  
  public final f<a.a<ki>> aBB()
  {
    try
    {
      AppMethodBeat.i(186330);
      com.tencent.mm.plugin.report.service.h.wUl.dB(1422, 3);
      f localf = super.aBB();
      AppMethodBeat.o(186330);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b
 * JD-Core Version:    0.7.0.1
 */