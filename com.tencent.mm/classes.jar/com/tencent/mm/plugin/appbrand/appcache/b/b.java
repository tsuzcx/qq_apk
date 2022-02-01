package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends com.tencent.mm.al.a<kc>
{
  private final com.tencent.mm.al.b rr;
  
  private b(List<dam> paramList)
  {
    AppMethodBeat.i(44371);
    b.a locala = new b.a();
    kb localkb = new kb();
    localkb.CEx.addAll(paramList);
    locala.gUU = localkb;
    locala.gUV = new kc();
    locala.funcId = 2763;
    locala.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
    paramList = locala.atI();
    this.rr = paramList;
    this.rr = paramList;
    AppMethodBeat.o(44371);
  }
  
  /* Error */
  static List<dam> aQF()
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 86	com/tencent/mm/plugin/appbrand/app/j:aOy	()Lcom/tencent/mm/platformtools/r$a;
    //   8: astore 9
    //   10: invokestatic 92	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:aTv	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   13: getfield 96	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jcI	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   16: getfield 101	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:jdf	I
    //   19: istore_1
    //   20: invokestatic 107	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   23: invokestatic 92	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:aTv	()Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig;
    //   26: getfield 96	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig:jcI	Lcom/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting;
    //   29: getfield 111	com/tencent/mm/plugin/appbrand/config/AppBrandGlobalSystemConfig$WeAppSyncVersionSetting:jde	J
    //   32: lsub
    //   33: lstore 4
    //   35: invokestatic 117	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   38: ldc 119
    //   40: iconst_0
    //   41: invokeinterface 125 3 0
    //   46: ifne +329 -> 375
    //   49: iconst_1
    //   50: istore_0
    //   51: iload_0
    //   52: ifeq +235 -> 287
    //   55: ldc 127
    //   57: invokestatic 131	com/tencent/mm/plugin/appbrand/app/j:T	(Ljava/lang/Class;)Ljava/lang/Object;
    //   60: checkcast 127	com/tencent/mm/plugin/appbrand/appusage/k
    //   63: astore 10
    //   65: aload 10
    //   67: getfield 135	com/tencent/mm/plugin/appbrand/appusage/k:iMV	Lcom/tencent/mm/sdk/e/e;
    //   70: instanceof 137
    //   73: ifeq +563 -> 636
    //   76: aload 10
    //   78: getfield 135	com/tencent/mm/plugin/appbrand/appusage/k:iMV	Lcom/tencent/mm/sdk/e/e;
    //   81: checkcast 137	com/tencent/mm/sdk/e/f
    //   84: invokestatic 143	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   87: invokevirtual 146	java/lang/Thread:getId	()J
    //   90: invokeinterface 150 3 0
    //   95: lstore_2
    //   96: aload 10
    //   98: getfield 135	com/tencent/mm/plugin/appbrand/appusage/k:iMV	Lcom/tencent/mm/sdk/e/e;
    //   101: ldc 152
    //   103: aconst_null
    //   104: ldc 154
    //   106: iconst_1
    //   107: anewarray 156	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: lload 4
    //   114: invokestatic 160	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   117: aastore
    //   118: aconst_null
    //   119: aconst_null
    //   120: aconst_null
    //   121: invokeinterface 166 8 0
    //   126: astore 11
    //   128: aconst_null
    //   129: astore 8
    //   131: aload 11
    //   133: ifnull +80 -> 213
    //   136: aload 11
    //   138: invokeinterface 172 1 0
    //   143: ifne +70 -> 213
    //   146: aload 11
    //   148: invokeinterface 175 1 0
    //   153: ifeq +60 -> 213
    //   156: new 177	com/tencent/mm/plugin/appbrand/appusage/b
    //   159: dup
    //   160: invokespecial 178	com/tencent/mm/plugin/appbrand/appusage/b:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: aload 11
    //   169: invokevirtual 182	com/tencent/mm/plugin/appbrand/appusage/b:convertFrom	(Landroid/database/Cursor;)V
    //   172: aload 7
    //   174: getfield 185	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   177: invokestatic 191	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   180: ifne +19 -> 199
    //   183: aload 10
    //   185: aload 7
    //   187: getfield 185	com/tencent/mm/plugin/appbrand/appusage/b:field_username	Ljava/lang/String;
    //   190: aload 7
    //   192: getfield 194	com/tencent/mm/plugin/appbrand/appusage/b:field_updateTime	J
    //   195: invokevirtual 198	com/tencent/mm/plugin/appbrand/appusage/k:H	(Ljava/lang/String;J)Z
    //   198: pop
    //   199: aload 11
    //   201: invokeinterface 201 1 0
    //   206: istore 6
    //   208: iload 6
    //   210: ifne -45 -> 165
    //   213: aload 11
    //   215: ifnull +10 -> 225
    //   218: aload 11
    //   220: invokeinterface 204 1 0
    //   225: aload 10
    //   227: getfield 135	com/tencent/mm/plugin/appbrand/appusage/k:iMV	Lcom/tencent/mm/sdk/e/e;
    //   230: ldc 152
    //   232: ldc 206
    //   234: invokeinterface 210 3 0
    //   239: pop
    //   240: aload 10
    //   242: getfield 135	com/tencent/mm/plugin/appbrand/appusage/k:iMV	Lcom/tencent/mm/sdk/e/e;
    //   245: instanceof 137
    //   248: ifeq +18 -> 266
    //   251: aload 10
    //   253: getfield 135	com/tencent/mm/plugin/appbrand/appusage/k:iMV	Lcom/tencent/mm/sdk/e/e;
    //   256: checkcast 137	com/tencent/mm/sdk/e/f
    //   259: lload_2
    //   260: invokeinterface 214 3 0
    //   265: pop
    //   266: invokestatic 117	com/tencent/mm/plugin/appbrand/app/PluginAppBrand:getProcessSharedPrefs	()Landroid/content/SharedPreferences;
    //   269: invokeinterface 218 1 0
    //   274: ldc 119
    //   276: iconst_1
    //   277: invokeinterface 224 3 0
    //   282: invokeinterface 227 1 0
    //   287: ldc 229
    //   289: ldc 231
    //   291: iconst_1
    //   292: anewarray 233	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: lload 4
    //   299: invokestatic 236	com/tencent/mm/sdk/platformtools/bt:vJ	(J)Ljava/lang/String;
    //   302: aastore
    //   303: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: aload 9
    //   308: new 243	java/lang/StringBuilder
    //   311: dup
    //   312: ldc 245
    //   314: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: lload 4
    //   319: invokevirtual 252	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: ldc 254
    //   324: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_1
    //   328: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: ldc_w 262
    //   334: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: aconst_null
    //   341: iconst_2
    //   342: invokevirtual 272	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   345: astore 7
    //   347: aload 7
    //   349: ifnull +13 -> 362
    //   352: aload 7
    //   354: invokeinterface 172 1 0
    //   359: ifeq +80 -> 439
    //   362: invokestatic 277	java/util/Collections:emptyList	()Ljava/util/List;
    //   365: astore 7
    //   367: ldc 80
    //   369: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload 7
    //   374: areturn
    //   375: iconst_0
    //   376: istore_0
    //   377: goto -326 -> 51
    //   380: astore 8
    //   382: ldc 80
    //   384: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: aload 8
    //   389: athrow
    //   390: astore 7
    //   392: aload 11
    //   394: ifnull +15 -> 409
    //   397: aload 8
    //   399: ifnull +30 -> 429
    //   402: aload 11
    //   404: invokeinterface 204 1 0
    //   409: ldc 80
    //   411: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload 7
    //   416: athrow
    //   417: astore 11
    //   419: aload 8
    //   421: aload 11
    //   423: invokevirtual 281	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   426: goto -17 -> 409
    //   429: aload 11
    //   431: invokeinterface 204 1 0
    //   436: goto -27 -> 409
    //   439: new 35	java/util/LinkedList
    //   442: dup
    //   443: invokespecial 282	java/util/LinkedList:<init>	()V
    //   446: astore 8
    //   448: aload 7
    //   450: invokeinterface 175 1 0
    //   455: ifeq +94 -> 549
    //   458: new 284	com/tencent/mm/plugin/appbrand/config/WxaAttributes
    //   461: dup
    //   462: invokespecial 285	com/tencent/mm/plugin/appbrand/config/WxaAttributes:<init>	()V
    //   465: astore 10
    //   467: aload 7
    //   469: iconst_0
    //   470: invokeinterface 289 2 0
    //   475: astore 11
    //   477: aload 11
    //   479: invokestatic 293	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   482: ifne +57 -> 539
    //   485: aload 10
    //   487: aload 7
    //   489: invokevirtual 294	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   492: new 296	com/tencent/mm/protocal/protobuf/dam
    //   495: dup
    //   496: invokespecial 297	com/tencent/mm/protocal/protobuf/dam:<init>	()V
    //   499: astore 12
    //   501: aload 12
    //   503: aload 11
    //   505: putfield 300	com/tencent/mm/protocal/protobuf/dam:DII	Ljava/lang/String;
    //   508: aload 10
    //   510: invokevirtual 304	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTP	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   513: ifnull +16 -> 529
    //   516: aload 12
    //   518: aload 10
    //   520: invokevirtual 304	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTP	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   523: getfield 309	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:aAS	I
    //   526: putfield 312	com/tencent/mm/protocal/protobuf/dam:Esi	I
    //   529: aload 8
    //   531: aload 12
    //   533: invokeinterface 318 2 0
    //   538: pop
    //   539: aload 7
    //   541: invokeinterface 201 1 0
    //   546: ifne -79 -> 467
    //   549: aload 7
    //   551: invokeinterface 204 1 0
    //   556: aload 9
    //   558: ldc_w 320
    //   561: ldc_w 322
    //   564: iconst_1
    //   565: anewarray 156	java/lang/String
    //   568: dup
    //   569: iconst_0
    //   570: lload 4
    //   572: invokestatic 160	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   575: aastore
    //   576: invokevirtual 326	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   579: istore_0
    //   580: ldc 229
    //   582: ldc_w 328
    //   585: iconst_2
    //   586: anewarray 233	java/lang/Object
    //   589: dup
    //   590: iconst_0
    //   591: lload 4
    //   593: invokestatic 236	com/tencent/mm/sdk/platformtools/bt:vJ	(J)Ljava/lang/String;
    //   596: aastore
    //   597: dup
    //   598: iconst_1
    //   599: iload_0
    //   600: invokestatic 333	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: aastore
    //   604: invokestatic 241	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   607: aload 8
    //   609: invokestatic 338	com/tencent/mm/plugin/appbrand/config/a/c:aTW	()Ljava/util/List;
    //   612: invokeinterface 339 2 0
    //   617: pop
    //   618: ldc 80
    //   620: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   623: aload 8
    //   625: areturn
    //   626: astore 7
    //   628: goto -388 -> 240
    //   631: astore 7
    //   633: goto -241 -> 392
    //   636: lconst_0
    //   637: lstore_2
    //   638: goto -542 -> 96
    //   641: astore 7
    //   643: goto -418 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	550	0	i	int
    //   19	309	1	j	int
    //   95	543	2	l1	long
    //   33	559	4	l2	long
    //   206	3	6	bool	boolean
    //   163	210	7	localObject1	Object
    //   390	160	7	localCursor1	android.database.Cursor
    //   626	1	7	localThrowable1	java.lang.Throwable
    //   631	1	7	localObject2	Object
    //   641	1	7	localThrowable2	java.lang.Throwable
    //   129	1	8	localObject3	Object
    //   380	40	8	localThrowable3	java.lang.Throwable
    //   446	178	8	localLinkedList	LinkedList
    //   8	549	9	locala	com.tencent.mm.platformtools.r.a
    //   63	456	10	localObject4	Object
    //   126	277	11	localCursor2	android.database.Cursor
    //   417	13	11	localThrowable4	java.lang.Throwable
    //   475	29	11	str	java.lang.String
    //   499	33	12	localdam	dam
    // Exception table:
    //   from	to	target	type
    //   136	165	380	java/lang/Throwable
    //   165	199	380	java/lang/Throwable
    //   199	208	380	java/lang/Throwable
    //   382	390	390	finally
    //   402	409	417	java/lang/Throwable
    //   225	240	626	java/lang/Throwable
    //   136	165	631	finally
    //   165	199	631	finally
    //   199	208	631	finally
    //   96	128	641	java/lang/Throwable
    //   218	225	641	java/lang/Throwable
    //   409	417	641	java/lang/Throwable
    //   419	426	641	java/lang/Throwable
    //   429	436	641	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b
 * JD-Core Version:    0.7.0.1
 */