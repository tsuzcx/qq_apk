package com.tencent.mm.app;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.DefaultApplicationLike;

public class MMApplicationLike
  extends DefaultApplicationLike
{
  private static final String TAG = "MicroMsg.MMApplication";
  private static MMApplicationLike sSafeguardInstance = null;
  private static byte[] sSafeguardLock = new byte[0];
  private r mMMApplicationLikeImpl;
  private ApplicationLifeCycle wrapper;
  
  public MMApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
    AppMethodBeat.i(123467);
    this.mMMApplicationLikeImpl = new r(this);
    AppMethodBeat.o(123467);
  }
  
  public Resources getResources(Resources paramResources)
  {
    AppMethodBeat.i(123472);
    if (aj.getResources() == null)
    {
      AppMethodBeat.o(123472);
      return paramResources;
    }
    paramResources = aj.getResources();
    AppMethodBeat.o(123472);
    return paramResources;
  }
  
  public int mzNightModeUseOf()
  {
    return 0;
  }
  
  /* Error */
  public void onBaseContextAttached(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 63
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 67	com/tencent/mm/app/MMApplicationLike:safeguard	()Z
    //   9: ifeq +9 -> 18
    //   12: ldc 63
    //   14: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: aload_0
    //   19: invokevirtual 71	com/tencent/mm/app/MMApplicationLike:getApplication	()Landroid/app/Application;
    //   22: invokestatic 77	com/tencent/mm/sdk/platformtools/d:p	(Landroid/app/Application;)V
    //   25: aload_1
    //   26: invokestatic 83	com/tencent/mm/app/ac:bt	(Landroid/content/Context;)Landroid/os/Bundle;
    //   29: astore 8
    //   31: aload 8
    //   33: ifnonnull +221 -> 254
    //   36: ldc 85
    //   38: ldc 87
    //   40: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: iconst_0
    //   44: putstatic 99	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   47: ldc 101
    //   49: putstatic 104	com/tencent/mm/sdk/platformtools/i:BUILD_TAG	Ljava/lang/String;
    //   52: ldc 106
    //   54: putstatic 109	com/tencent/mm/sdk/platformtools/i:OWNER	Ljava/lang/String;
    //   57: ldc 111
    //   59: putstatic 114	com/tencent/mm/sdk/platformtools/i:HOSTNAME	Ljava/lang/String;
    //   62: ldc 116
    //   64: putstatic 119	com/tencent/mm/sdk/platformtools/i:TIME	Ljava/lang/String;
    //   67: ldc 121
    //   69: putstatic 124	com/tencent/mm/sdk/platformtools/i:COMMAND	Ljava/lang/String;
    //   72: ldc 126
    //   74: putstatic 129	com/tencent/mm/sdk/platformtools/i:REV	Ljava/lang/String;
    //   77: ldc 131
    //   79: putstatic 134	com/tencent/mm/sdk/platformtools/i:SVNPATH	Ljava/lang/String;
    //   82: getstatic 139	com/tencent/mm/loader/j/a:hgJ	Z
    //   85: ifeq +177 -> 262
    //   88: ldc 141
    //   90: astore 8
    //   92: aload 8
    //   94: putstatic 144	com/tencent/mm/sdk/platformtools/i:hgG	Ljava/lang/String;
    //   97: aload 8
    //   99: invokestatic 150	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   102: invokevirtual 153	java/lang/Integer:intValue	()I
    //   105: putstatic 157	com/tencent/mm/sdk/platformtools/i:Ics	I
    //   108: iconst_0
    //   109: putstatic 160	com/tencent/mm/sdk/platformtools/i:ENABLE_FPS_ANALYSE	Z
    //   112: iconst_1
    //   113: putstatic 163	com/tencent/mm/sdk/platformtools/i:ENABLE_MATRIX	Z
    //   116: iconst_0
    //   117: putstatic 166	com/tencent/mm/sdk/platformtools/i:ENABLE_MATRIX_TRACE	Z
    //   120: iconst_0
    //   121: putstatic 169	com/tencent/mm/sdk/platformtools/i:EX_DEVICE_LOGIN	Z
    //   124: iconst_0
    //   125: putstatic 172	com/tencent/mm/sdk/platformtools/i:PRE_RELEASE	Z
    //   128: iconst_0
    //   129: putstatic 175	com/tencent/mm/sdk/platformtools/i:REDESIGN_ENTRANCE	Z
    //   132: iconst_0
    //   133: putstatic 178	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_RED	Z
    //   136: iconst_0
    //   137: putstatic 181	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_PURPLE	Z
    //   140: iconst_0
    //   141: putstatic 184	com/tencent/mm/sdk/platformtools/i:IS_FLAVOR_BLUE	Z
    //   144: ldc 186
    //   146: putstatic 189	com/tencent/mm/sdk/platformtools/i:MATRIX_VERSION	Ljava/lang/String;
    //   149: getstatic 139	com/tencent/mm/loader/j/a:hgJ	Z
    //   152: putstatic 190	com/tencent/mm/sdk/platformtools/i:hgJ	Z
    //   155: ldc 192
    //   157: putstatic 195	com/tencent/mm/sdk/platformtools/i:KINDA_DEFAULT	Ljava/lang/String;
    //   160: ldc 197
    //   162: putstatic 200	com/tencent/mm/sdk/platformtools/i:TINKER_VERSION	Ljava/lang/String;
    //   165: iconst_0
    //   166: putstatic 203	com/tencent/mm/sdk/platformtools/i:IS_UAT	Z
    //   169: new 205	android/util/ArrayMap
    //   172: dup
    //   173: invokespecial 207	android/util/ArrayMap:<init>	()V
    //   176: astore 8
    //   178: ldc 209
    //   180: invokevirtual 215	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   183: astore 9
    //   185: aload 9
    //   187: arraylength
    //   188: istore_3
    //   189: iconst_0
    //   190: istore_2
    //   191: iload_2
    //   192: iload_3
    //   193: if_icmpge +94 -> 287
    //   196: aload 9
    //   198: iload_2
    //   199: aaload
    //   200: astore 10
    //   202: ldc 85
    //   204: ldc 217
    //   206: iconst_2
    //   207: anewarray 219	java/lang/Object
    //   210: dup
    //   211: iconst_0
    //   212: aload 10
    //   214: invokevirtual 225	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: aload 10
    //   222: aconst_null
    //   223: invokevirtual 229	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: aastore
    //   227: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload 8
    //   232: aload 10
    //   234: invokevirtual 225	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   237: aload 10
    //   239: aconst_null
    //   240: invokevirtual 229	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   243: invokevirtual 236	android/util/ArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: iload_2
    //   248: iconst_1
    //   249: iadd
    //   250: istore_2
    //   251: goto -60 -> 191
    //   254: aload 8
    //   256: invokestatic 240	com/tencent/mm/loader/j/a:r	(Landroid/os/Bundle;)V
    //   259: goto -216 -> 43
    //   262: ldc 242
    //   264: astore 8
    //   266: goto -174 -> 92
    //   269: astore 10
    //   271: ldc 85
    //   273: aload 10
    //   275: ldc 244
    //   277: iconst_0
    //   278: anewarray 219	java/lang/Object
    //   281: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: goto -37 -> 247
    //   287: getstatic 252	com/tencent/mm/sdk/platformtools/i:Ict	Lcom/tencent/mm/sdk/platformtools/u;
    //   290: astore 9
    //   292: aload 9
    //   294: getfield 257	com/tencent/mm/sdk/platformtools/u:IcN	Z
    //   297: ifne +13 -> 310
    //   300: aload 9
    //   302: getfield 261	com/tencent/mm/sdk/platformtools/u:IcM	Landroid/util/ArrayMap;
    //   305: aload 8
    //   307: invokevirtual 265	android/util/ArrayMap:putAll	(Landroid/util/ArrayMap;)V
    //   310: getstatic 252	com/tencent/mm/sdk/platformtools/i:Ict	Lcom/tencent/mm/sdk/platformtools/u;
    //   313: iconst_1
    //   314: putfield 257	com/tencent/mm/sdk/platformtools/u:IcN	Z
    //   317: invokestatic 271	com/tencent/mm/app/l:LV	()Lcom/tencent/mm/app/l;
    //   320: invokestatic 277	com/tencent/stubs/logger/Log:setLogger	(Lcom/tencent/stubs/logger/Log$Logger;)V
    //   323: aload_0
    //   324: aload_1
    //   325: invokespecial 279	com/tencent/tinker/entry/DefaultApplicationLike:onBaseContextAttached	(Landroid/content/Context;)V
    //   328: aload_1
    //   329: invokestatic 284	android/os/Process:myPid	()I
    //   332: invokestatic 290	com/tencent/mm/sdk/platformtools/bt:getProcessNameByPid	(Landroid/content/Context;I)Ljava/lang/String;
    //   335: astore 9
    //   337: aload 9
    //   339: putstatic 295	com/tencent/mm/app/d:cDP	Ljava/lang/String;
    //   342: aload_1
    //   343: invokestatic 301	com/tencent/mm/app/aa:bs	(Landroid/content/Context;)Z
    //   346: ifeq +9 -> 355
    //   349: ldc 63
    //   351: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: aload_0
    //   356: getfield 41	com/tencent/mm/app/MMApplicationLike:mMMApplicationLikeImpl	Lcom/tencent/mm/app/r;
    //   359: astore 10
    //   361: getstatic 295	com/tencent/mm/app/d:cDP	Ljava/lang/String;
    //   364: astore 11
    //   366: invokestatic 304	com/tencent/mm/sdk/platformtools/aj:fkH	()Z
    //   369: ifne +18 -> 387
    //   372: getstatic 310	com/tencent/mm/app/ag$a:cVi	Lcom/tencent/mm/app/ag;
    //   375: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   378: invokevirtual 319	com/tencent/mm/app/ag:b	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   381: getstatic 310	com/tencent/mm/app/ag$a:cVi	Lcom/tencent/mm/app/ag;
    //   384: invokevirtual 322	com/tencent/mm/app/ag:MC	()V
    //   387: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   390: astore 8
    //   392: aload 8
    //   394: ifnull +11 -> 405
    //   397: aload 8
    //   399: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   402: ifnonnull +21 -> 423
    //   405: new 327	com/tencent/tinker/loader/TinkerRuntimeException
    //   408: dup
    //   409: ldc_w 329
    //   412: invokespecial 332	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   415: astore_1
    //   416: ldc 63
    //   418: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: aload_1
    //   422: athrow
    //   423: aload 8
    //   425: invokevirtual 335	com/tencent/tinker/entry/ApplicationLike:getTinkerFlags	()I
    //   428: invokestatic 341	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isTinkerEnabledForNativeLib	(I)Z
    //   431: ifeq +49 -> 480
    //   434: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   437: invokestatic 347	com/tencent/tinker/lib/e/b:d	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
    //   440: ifeq +40 -> 480
    //   443: getstatic 139	com/tencent/mm/loader/j/a:hgJ	Z
    //   446: ifeq +960 -> 1406
    //   449: ldc_w 349
    //   452: invokestatic 353	com/tencent/mm/app/r:fj	(Ljava/lang/String;)Ljava/lang/String;
    //   455: astore 8
    //   457: aload 8
    //   459: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +8 -> 470
    //   465: aload 8
    //   467: invokestatic 364	com/tencent/mm/compatible/util/j:vp	(Ljava/lang/String;)V
    //   470: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   473: ldc_w 349
    //   476: invokestatic 370	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   479: pop
    //   480: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   483: invokevirtual 374	com/tencent/tinker/entry/ApplicationLike:getApplicationStartMillisTime	()J
    //   486: putstatic 378	com/tencent/mm/app/d:cTp	J
    //   489: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   492: invokestatic 380	com/tencent/mm/app/r:a	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   495: new 382	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   502: getstatic 386	com/tencent/mm/app/r:cTS	Ljava/lang/String;
    //   505: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 392
    //   511: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 10
    //   516: invokevirtual 395	java/lang/Object:hashCode	()I
    //   519: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: putstatic 386	com/tencent/mm/app/r:cTS	Ljava/lang/String;
    //   528: iconst_0
    //   529: invokestatic 405	com/tencent/mm/sdk/platformtools/aj:wG	(Z)V
    //   532: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   535: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   538: invokestatic 408	com/tencent/mm/sdk/platformtools/aj:setContext	(Landroid/content/Context;)V
    //   541: iconst_0
    //   542: invokestatic 411	com/tencent/mm/sdk/platformtools/ad:aax	(I)V
    //   545: getstatic 99	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   548: ifne +24 -> 572
    //   551: ldc_w 413
    //   554: ldc_w 415
    //   557: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   563: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   566: aload 11
    //   568: invokestatic 420	com/tencent/mm/app/k:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   571: pop
    //   572: invokestatic 425	java/lang/System:currentTimeMillis	()J
    //   575: lstore 4
    //   577: new 427	com/tencent/mm/app/q
    //   580: dup
    //   581: new 382	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   588: invokestatic 432	com/tencent/mm/loader/j/b:arM	()Ljava/lang/String;
    //   591: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: ldc_w 434
    //   597: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokespecial 435	com/tencent/mm/app/q:<init>	(Ljava/lang/String;)V
    //   606: astore 12
    //   608: aload 12
    //   610: getfield 439	com/tencent/mm/app/q:cTR	Ljava/util/Properties;
    //   613: ifnull +858 -> 1471
    //   616: aload 12
    //   618: getfield 439	com/tencent/mm/app/q:cTR	Ljava/util/Properties;
    //   621: ldc_w 441
    //   624: invokevirtual 447	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   627: ifeq +844 -> 1471
    //   630: aload 12
    //   632: getfield 439	com/tencent/mm/app/q:cTR	Ljava/util/Properties;
    //   635: ldc_w 441
    //   638: invokevirtual 450	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   641: astore 8
    //   643: aload 10
    //   645: aload 8
    //   647: putfield 453	com/tencent/mm/app/r:cTT	Ljava/lang/String;
    //   650: aload 10
    //   652: getstatic 144	com/tencent/mm/sdk/platformtools/i:hgG	Ljava/lang/String;
    //   655: putfield 456	com/tencent/mm/app/r:cTU	Ljava/lang/String;
    //   658: invokestatic 425	java/lang/System:currentTimeMillis	()J
    //   661: lstore 6
    //   663: aload 10
    //   665: lload 6
    //   667: lload 4
    //   669: lsub
    //   670: putfield 459	com/tencent/mm/app/r:cTV	J
    //   673: aload 10
    //   675: lconst_0
    //   676: putfield 462	com/tencent/mm/app/r:cTW	J
    //   679: aload 10
    //   681: getfield 456	com/tencent/mm/app/r:cTU	Ljava/lang/String;
    //   684: aload 10
    //   686: getfield 453	com/tencent/mm/app/r:cTT	Ljava/lang/String;
    //   689: invokevirtual 467	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   692: ifne +181 -> 873
    //   695: iconst_1
    //   696: putstatic 470	com/tencent/mm/sdk/platformtools/aj:IdC	Z
    //   699: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   702: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   705: ldc_w 472
    //   708: iconst_0
    //   709: invokevirtual 478	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   712: invokestatic 482	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   715: pop
    //   716: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   719: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   722: ldc_w 484
    //   725: iconst_0
    //   726: invokevirtual 478	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   729: invokestatic 482	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   732: pop
    //   733: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   736: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   739: ldc_w 486
    //   742: iconst_0
    //   743: invokevirtual 478	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   746: invokestatic 482	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   749: pop
    //   750: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   753: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   756: ldc_w 488
    //   759: iconst_0
    //   760: invokevirtual 478	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   763: invokestatic 482	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   766: pop
    //   767: getstatic 489	com/tencent/mm/loader/j/a:hgG	Ljava/lang/String;
    //   770: getstatic 144	com/tencent/mm/sdk/platformtools/i:hgG	Ljava/lang/String;
    //   773: invokevirtual 467	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   776: ifeq +44 -> 820
    //   779: ldc_w 413
    //   782: ldc_w 491
    //   785: iconst_3
    //   786: anewarray 219	java/lang/Object
    //   789: dup
    //   790: iconst_0
    //   791: aload 10
    //   793: getfield 453	com/tencent/mm/app/r:cTT	Ljava/lang/String;
    //   796: aastore
    //   797: dup
    //   798: iconst_1
    //   799: aload 10
    //   801: getfield 456	com/tencent/mm/app/r:cTU	Ljava/lang/String;
    //   804: aastore
    //   805: dup
    //   806: iconst_2
    //   807: getstatic 489	com/tencent/mm/loader/j/a:hgG	Ljava/lang/String;
    //   810: aastore
    //   811: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   814: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   817: invokestatic 494	com/tencent/tinker/lib/e/b:f	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   820: aload 12
    //   822: ldc_w 441
    //   825: aload 10
    //   827: getfield 456	com/tencent/mm/app/r:cTU	Ljava/lang/String;
    //   830: invokevirtual 498	com/tencent/mm/app/q:N	(Ljava/lang/String;Ljava/lang/String;)Z
    //   833: pop
    //   834: aload 10
    //   836: invokestatic 425	java/lang/System:currentTimeMillis	()J
    //   839: lload 6
    //   841: lsub
    //   842: putfield 462	com/tencent/mm/app/r:cTW	J
    //   845: ldc_w 413
    //   848: ldc_w 500
    //   851: iconst_2
    //   852: anewarray 219	java/lang/Object
    //   855: dup
    //   856: iconst_0
    //   857: getstatic 386	com/tencent/mm/app/r:cTS	Ljava/lang/String;
    //   860: aastore
    //   861: dup
    //   862: iconst_1
    //   863: invokestatic 504	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   866: invokevirtual 507	com/tencent/mm/sdk/platformtools/at:toString	()Ljava/lang/String;
    //   869: aastore
    //   870: invokestatic 510	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   873: ldc_w 413
    //   876: ldc_w 512
    //   879: iconst_4
    //   880: anewarray 219	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload 10
    //   887: getfield 453	com/tencent/mm/app/r:cTT	Ljava/lang/String;
    //   890: aastore
    //   891: dup
    //   892: iconst_1
    //   893: aload 10
    //   895: getfield 456	com/tencent/mm/app/r:cTU	Ljava/lang/String;
    //   898: aastore
    //   899: dup
    //   900: iconst_2
    //   901: aload 10
    //   903: getfield 459	com/tencent/mm/app/r:cTV	J
    //   906: invokestatic 518	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   909: aastore
    //   910: dup
    //   911: iconst_3
    //   912: aload 10
    //   914: getfield 462	com/tencent/mm/app/r:cTW	J
    //   917: invokestatic 518	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   920: aastore
    //   921: invokestatic 232	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   924: getstatic 99	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   927: ifne +9 -> 936
    //   930: getstatic 172	com/tencent/mm/sdk/platformtools/i:PRE_RELEASE	Z
    //   933: ifeq +24 -> 957
    //   936: ldc_w 413
    //   939: ldc_w 520
    //   942: invokestatic 93	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   948: invokevirtual 325	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   951: aload 11
    //   953: invokestatic 420	com/tencent/mm/app/k:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   956: pop
    //   957: aload 9
    //   959: aload_1
    //   960: invokevirtual 525	android/content/Context:getPackageName	()Ljava/lang/String;
    //   963: invokevirtual 467	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   966: ifeq +424 -> 1390
    //   969: ldc 8
    //   971: ldc_w 527
    //   974: iconst_0
    //   975: anewarray 219	java/lang/Object
    //   978: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   981: aload_0
    //   982: invokestatic 347	com/tencent/tinker/lib/e/b:d	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
    //   985: ifeq +549 -> 1534
    //   988: aload_1
    //   989: invokestatic 537	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   992: astore 12
    //   994: aload 12
    //   996: invokevirtual 542	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   999: invokestatic 546	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchInfoFile	(Ljava/lang/String;)Ljava/io/File;
    //   1002: astore 8
    //   1004: aload 12
    //   1006: invokevirtual 542	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1009: invokestatic 549	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchInfoLockFile	(Ljava/lang/String;)Ljava/io/File;
    //   1012: astore 10
    //   1014: aload 8
    //   1016: aload 10
    //   1018: invokestatic 555	com/tencent/tinker/loader/shareutil/SharePatchInfo:readAndCheckPropertyWithLock	(Ljava/io/File;Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   1021: astore 11
    //   1023: ldc_w 557
    //   1026: aload 11
    //   1028: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1031: invokevirtual 467	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1034: ifeq +485 -> 1519
    //   1037: ldc 8
    //   1039: ldc_w 562
    //   1042: iconst_4
    //   1043: anewarray 219	java/lang/Object
    //   1046: dup
    //   1047: iconst_0
    //   1048: aload 11
    //   1050: getfield 565	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1053: aastore
    //   1054: dup
    //   1055: iconst_1
    //   1056: aload 11
    //   1058: getfield 568	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1061: aastore
    //   1062: dup
    //   1063: iconst_2
    //   1064: aload 11
    //   1066: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_3
    //   1072: aload 11
    //   1074: getfield 571	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1077: aastore
    //   1078: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: iconst_3
    //   1082: anewarray 219	java/lang/Object
    //   1085: dup
    //   1086: iconst_0
    //   1087: iconst_2
    //   1088: invokestatic 574	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1091: aastore
    //   1092: dup
    //   1093: iconst_1
    //   1094: aload 9
    //   1096: aastore
    //   1097: dup
    //   1098: iconst_2
    //   1099: ldc_w 576
    //   1102: iconst_4
    //   1103: anewarray 219	java/lang/Object
    //   1106: dup
    //   1107: iconst_0
    //   1108: aload 11
    //   1110: getfield 565	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1113: aastore
    //   1114: dup
    //   1115: iconst_1
    //   1116: aload 11
    //   1118: getfield 568	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1121: aastore
    //   1122: dup
    //   1123: iconst_2
    //   1124: aload 11
    //   1126: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1129: aastore
    //   1130: dup
    //   1131: iconst_3
    //   1132: aload 11
    //   1134: getfield 571	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1137: aastore
    //   1138: invokestatic 580	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1141: aastore
    //   1142: invokestatic 584	com/tencent/mm/app/x:g	([Ljava/lang/Object;)V
    //   1145: new 539	java/io/File
    //   1148: dup
    //   1149: aload 12
    //   1151: aload 11
    //   1153: getfield 568	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1156: invokestatic 587	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchVersionDirectory	(Ljava/lang/String;)Ljava/lang/String;
    //   1159: invokespecial 590	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1162: astore 13
    //   1164: new 539	java/io/File
    //   1167: dup
    //   1168: aload 13
    //   1170: ldc_w 592
    //   1173: invokespecial 590	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1176: astore 12
    //   1178: new 539	java/io/File
    //   1181: dup
    //   1182: aload 13
    //   1184: ldc_w 594
    //   1187: invokespecial 590	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1190: astore 13
    //   1192: new 539	java/io/File
    //   1195: dup
    //   1196: aload 12
    //   1198: ldc_w 596
    //   1201: invokespecial 590	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1204: astore 12
    //   1206: new 539	java/io/File
    //   1209: dup
    //   1210: aload 13
    //   1212: ldc_w 596
    //   1215: invokespecial 590	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1218: astore 13
    //   1220: aload 12
    //   1222: invokevirtual 599	java/io/File:exists	()Z
    //   1225: ifeq +252 -> 1477
    //   1228: aload 12
    //   1230: invokevirtual 602	java/io/File:canRead	()Z
    //   1233: ifeq +244 -> 1477
    //   1236: aload 11
    //   1238: ldc_w 592
    //   1241: putfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1244: iconst_3
    //   1245: anewarray 219	java/lang/Object
    //   1248: dup
    //   1249: iconst_0
    //   1250: iconst_2
    //   1251: invokestatic 574	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1254: aastore
    //   1255: dup
    //   1256: iconst_1
    //   1257: aload 9
    //   1259: aastore
    //   1260: dup
    //   1261: iconst_2
    //   1262: ldc_w 604
    //   1265: iconst_4
    //   1266: anewarray 219	java/lang/Object
    //   1269: dup
    //   1270: iconst_0
    //   1271: aload 11
    //   1273: getfield 565	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1276: aastore
    //   1277: dup
    //   1278: iconst_1
    //   1279: aload 11
    //   1281: getfield 568	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1284: aastore
    //   1285: dup
    //   1286: iconst_2
    //   1287: aload 11
    //   1289: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1292: aastore
    //   1293: dup
    //   1294: iconst_3
    //   1295: aload 11
    //   1297: getfield 571	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1300: aastore
    //   1301: invokestatic 580	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1304: aastore
    //   1305: invokestatic 584	com/tencent/mm/app/x:g	([Ljava/lang/Object;)V
    //   1308: ldc 8
    //   1310: ldc_w 606
    //   1313: iconst_4
    //   1314: anewarray 219	java/lang/Object
    //   1317: dup
    //   1318: iconst_0
    //   1319: aload 11
    //   1321: getfield 565	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1324: aastore
    //   1325: dup
    //   1326: iconst_1
    //   1327: aload 11
    //   1329: getfield 568	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1332: aastore
    //   1333: dup
    //   1334: iconst_2
    //   1335: aload 11
    //   1337: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1340: aastore
    //   1341: dup
    //   1342: iconst_3
    //   1343: aload 11
    //   1345: getfield 571	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1348: aastore
    //   1349: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1352: aload 8
    //   1354: aload 11
    //   1356: aload 10
    //   1358: invokestatic 610	com/tencent/tinker/loader/shareutil/SharePatchInfo:rewritePatchInfoFileWithLock	(Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;Ljava/io/File;)Z
    //   1361: pop
    //   1362: ldc 8
    //   1364: ldc_w 612
    //   1367: iconst_0
    //   1368: anewarray 219	java/lang/Object
    //   1371: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1374: aload_1
    //   1375: invokestatic 615	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:killProcessExceptMain	(Landroid/content/Context;)V
    //   1378: ldc 8
    //   1380: ldc_w 617
    //   1383: iconst_0
    //   1384: anewarray 219	java/lang/Object
    //   1387: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1390: aload_0
    //   1391: invokevirtual 71	com/tencent/mm/app/MMApplicationLike:getApplication	()Landroid/app/Application;
    //   1394: invokestatic 622	com/tencent/mm/app/j:e	(Landroid/app/Application;)Z
    //   1397: ifeq +152 -> 1549
    //   1400: ldc 63
    //   1402: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1405: return
    //   1406: ldc_w 624
    //   1409: invokestatic 353	com/tencent/mm/app/r:fj	(Ljava/lang/String;)Ljava/lang/String;
    //   1412: astore 8
    //   1414: aload 8
    //   1416: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1419: ifne +8 -> 1427
    //   1422: aload 8
    //   1424: invokestatic 364	com/tencent/mm/compatible/util/j:vp	(Ljava/lang/String;)V
    //   1427: ldc_w 626
    //   1430: invokestatic 353	com/tencent/mm/app/r:fj	(Ljava/lang/String;)Ljava/lang/String;
    //   1433: astore 8
    //   1435: aload 8
    //   1437: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1440: ifne +8 -> 1448
    //   1443: aload 8
    //   1445: invokestatic 364	com/tencent/mm/compatible/util/j:vp	(Ljava/lang/String;)V
    //   1448: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   1451: ldc_w 624
    //   1454: invokestatic 370	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   1457: pop
    //   1458: getstatic 314	com/tencent/mm/app/r:cTo	Lcom/tencent/tinker/entry/ApplicationLike;
    //   1461: ldc_w 626
    //   1464: invokestatic 370	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   1467: pop
    //   1468: goto -988 -> 480
    //   1471: aconst_null
    //   1472: astore 8
    //   1474: goto -831 -> 643
    //   1477: aload 13
    //   1479: invokevirtual 599	java/io/File:exists	()Z
    //   1482: ifeq -238 -> 1244
    //   1485: aload 13
    //   1487: invokevirtual 602	java/io/File:canRead	()Z
    //   1490: ifeq -246 -> 1244
    //   1493: aload 11
    //   1495: ldc_w 594
    //   1498: putfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1501: goto -257 -> 1244
    //   1504: astore 8
    //   1506: ldc 8
    //   1508: aload 8
    //   1510: ldc_w 628
    //   1513: invokestatic 631	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1516: goto -126 -> 1390
    //   1519: ldc 8
    //   1521: ldc_w 633
    //   1524: iconst_0
    //   1525: anewarray 219	java/lang/Object
    //   1528: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1531: goto -141 -> 1390
    //   1534: ldc 8
    //   1536: ldc_w 635
    //   1539: iconst_0
    //   1540: anewarray 219	java/lang/Object
    //   1543: invokestatic 531	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1546: goto -156 -> 1390
    //   1549: invokestatic 304	com/tencent/mm/sdk/platformtools/aj:fkH	()Z
    //   1552: ifeq +86 -> 1638
    //   1555: aload_0
    //   1556: new 382	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   1563: invokestatic 636	com/tencent/mm/sdk/platformtools/aj:getPackageName	()Ljava/lang/String;
    //   1566: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: ldc_w 638
    //   1572: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: invokestatic 642	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1581: iconst_2
    //   1582: anewarray 211	java/lang/Class
    //   1585: dup
    //   1586: iconst_0
    //   1587: ldc_w 324
    //   1590: aastore
    //   1591: dup
    //   1592: iconst_1
    //   1593: ldc_w 464
    //   1596: aastore
    //   1597: invokevirtual 646	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1600: iconst_2
    //   1601: anewarray 219	java/lang/Object
    //   1604: dup
    //   1605: iconst_0
    //   1606: aload_0
    //   1607: aastore
    //   1608: dup
    //   1609: iconst_1
    //   1610: aload 9
    //   1612: aastore
    //   1613: invokevirtual 652	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1616: checkcast 654	com/tencent/tinker/entry/ApplicationLifeCycle
    //   1619: putfield 656	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1622: aload_0
    //   1623: getfield 656	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1626: aload_1
    //   1627: invokeinterface 657 2 0
    //   1632: ldc 63
    //   1634: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1637: return
    //   1638: invokestatic 660	com/tencent/mm/sdk/platformtools/aj:fkN	()Z
    //   1641: ifeq +106 -> 1747
    //   1644: aload_0
    //   1645: new 382	java/lang/StringBuilder
    //   1648: dup
    //   1649: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   1652: invokestatic 663	com/tencent/mm/sdk/platformtools/aj:fkB	()Ljava/lang/String;
    //   1655: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: ldc_w 665
    //   1661: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1667: invokestatic 642	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1670: iconst_2
    //   1671: anewarray 211	java/lang/Class
    //   1674: dup
    //   1675: iconst_0
    //   1676: ldc_w 324
    //   1679: aastore
    //   1680: dup
    //   1681: iconst_1
    //   1682: ldc_w 464
    //   1685: aastore
    //   1686: invokevirtual 646	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1689: iconst_2
    //   1690: anewarray 219	java/lang/Object
    //   1693: dup
    //   1694: iconst_0
    //   1695: aload_0
    //   1696: aastore
    //   1697: dup
    //   1698: iconst_1
    //   1699: aload 9
    //   1701: aastore
    //   1702: invokevirtual 652	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1705: checkcast 654	com/tencent/tinker/entry/ApplicationLifeCycle
    //   1708: putfield 656	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1711: goto -89 -> 1622
    //   1714: astore_1
    //   1715: ldc 8
    //   1717: aload_1
    //   1718: ldc_w 667
    //   1721: iconst_0
    //   1722: anewarray 219	java/lang/Object
    //   1725: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1728: new 669	java/lang/RuntimeException
    //   1731: dup
    //   1732: ldc_w 667
    //   1735: aload_1
    //   1736: invokespecial 672	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1739: astore_1
    //   1740: ldc 63
    //   1742: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1745: aload_1
    //   1746: athrow
    //   1747: aload_0
    //   1748: new 382	java/lang/StringBuilder
    //   1751: dup
    //   1752: invokespecial 383	java/lang/StringBuilder:<init>	()V
    //   1755: invokestatic 636	com/tencent/mm/sdk/platformtools/aj:getPackageName	()Ljava/lang/String;
    //   1758: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: ldc_w 674
    //   1764: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1770: invokestatic 642	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1773: iconst_2
    //   1774: anewarray 211	java/lang/Class
    //   1777: dup
    //   1778: iconst_0
    //   1779: ldc_w 324
    //   1782: aastore
    //   1783: dup
    //   1784: iconst_1
    //   1785: ldc_w 464
    //   1788: aastore
    //   1789: invokevirtual 646	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1792: iconst_2
    //   1793: anewarray 219	java/lang/Object
    //   1796: dup
    //   1797: iconst_0
    //   1798: aload_0
    //   1799: aastore
    //   1800: dup
    //   1801: iconst_1
    //   1802: aload 9
    //   1804: aastore
    //   1805: invokevirtual 652	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1808: checkcast 654	com/tencent/tinker/entry/ApplicationLifeCycle
    //   1811: putfield 656	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1814: goto -192 -> 1622
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1817	0	this	MMApplicationLike
    //   0	1817	1	paramContext	android.content.Context
    //   190	61	2	i	int
    //   188	6	3	j	int
    //   575	93	4	l1	long
    //   661	179	6	l2	long
    //   29	1444	8	localObject1	Object
    //   1504	5	8	localThrowable	java.lang.Throwable
    //   183	1620	9	localObject2	Object
    //   200	38	10	localObject3	Object
    //   269	5	10	localIllegalAccessException	java.lang.IllegalAccessException
    //   359	998	10	localObject4	Object
    //   364	1130	11	localObject5	Object
    //   606	623	12	localObject6	Object
    //   1162	324	13	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   202	247	269	java/lang/IllegalAccessException
    //   981	1244	1504	java/lang/Throwable
    //   1244	1390	1504	java/lang/Throwable
    //   1477	1501	1504	java/lang/Throwable
    //   1519	1531	1504	java/lang/Throwable
    //   1534	1546	1504	java/lang/Throwable
    //   1549	1622	1714	java/lang/Exception
    //   1622	1632	1714	java/lang/Exception
    //   1638	1711	1714	java/lang/Exception
    //   1747	1814	1714	java/lang/Exception
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(123471);
    ad.d("MicroMsg.MMApplication", "configuration changed");
    super.onConfigurationChanged(paramConfiguration);
    if (this.wrapper != null) {
      this.wrapper.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(123471);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(123469);
    if (this.wrapper != null) {
      this.wrapper.onCreate();
    }
    AppMethodBeat.o(123469);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(123473);
    super.onLowMemory();
    if (this.wrapper != null) {
      this.wrapper.onLowMemory();
    }
    AppMethodBeat.o(123473);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(123470);
    super.onTerminate();
    if (this.wrapper != null) {
      this.wrapper.onTerminate();
    }
    AppMethodBeat.o(123470);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(123474);
    super.onTrimMemory(paramInt);
    if (this.wrapper != null) {
      this.wrapper.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(123474);
  }
  
  public boolean safeguard()
  {
    synchronized (sSafeguardLock)
    {
      if (sSafeguardInstance != this)
      {
        if (sSafeguardInstance == null) {
          sSafeguardInstance = this;
        }
      }
      else {
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.MMApplicationLike
 * JD-Core Version:    0.7.0.1
 */