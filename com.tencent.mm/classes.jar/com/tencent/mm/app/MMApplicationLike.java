package com.tencent.mm.app;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
    if (ai.getResources() == null)
    {
      AppMethodBeat.o(123472);
      return paramResources;
    }
    paramResources = ai.getResources();
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
    //   18: aload_1
    //   19: invokestatic 73	com/tencent/mm/app/ac:bu	(Landroid/content/Context;)Landroid/os/Bundle;
    //   22: astore 8
    //   24: aload 8
    //   26: ifnonnull +217 -> 243
    //   29: ldc 75
    //   31: ldc 77
    //   33: invokestatic 83	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: iconst_0
    //   37: putstatic 89	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   40: ldc 91
    //   42: putstatic 94	com/tencent/mm/sdk/platformtools/h:BUILD_TAG	Ljava/lang/String;
    //   45: ldc 96
    //   47: putstatic 99	com/tencent/mm/sdk/platformtools/h:OWNER	Ljava/lang/String;
    //   50: ldc 101
    //   52: putstatic 104	com/tencent/mm/sdk/platformtools/h:HOSTNAME	Ljava/lang/String;
    //   55: ldc 106
    //   57: putstatic 109	com/tencent/mm/sdk/platformtools/h:TIME	Ljava/lang/String;
    //   60: ldc 111
    //   62: putstatic 114	com/tencent/mm/sdk/platformtools/h:COMMAND	Ljava/lang/String;
    //   65: ldc 116
    //   67: putstatic 119	com/tencent/mm/sdk/platformtools/h:REV	Ljava/lang/String;
    //   70: ldc 121
    //   72: putstatic 124	com/tencent/mm/sdk/platformtools/h:SVNPATH	Ljava/lang/String;
    //   75: getstatic 129	com/tencent/mm/loader/j/a:gMM	Z
    //   78: ifeq +173 -> 251
    //   81: ldc 131
    //   83: astore 8
    //   85: aload 8
    //   87: putstatic 134	com/tencent/mm/sdk/platformtools/h:gMJ	Ljava/lang/String;
    //   90: aload 8
    //   92: invokestatic 140	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   95: invokevirtual 143	java/lang/Integer:intValue	()I
    //   98: putstatic 147	com/tencent/mm/sdk/platformtools/h:GqE	I
    //   101: iconst_0
    //   102: putstatic 150	com/tencent/mm/sdk/platformtools/h:ENABLE_FPS_ANALYSE	Z
    //   105: iconst_1
    //   106: putstatic 153	com/tencent/mm/sdk/platformtools/h:ENABLE_MATRIX	Z
    //   109: iconst_0
    //   110: putstatic 156	com/tencent/mm/sdk/platformtools/h:ENABLE_MATRIX_TRACE	Z
    //   113: iconst_0
    //   114: putstatic 159	com/tencent/mm/sdk/platformtools/h:EX_DEVICE_LOGIN	Z
    //   117: iconst_0
    //   118: putstatic 162	com/tencent/mm/sdk/platformtools/h:PRE_RELEASE	Z
    //   121: iconst_0
    //   122: putstatic 165	com/tencent/mm/sdk/platformtools/h:REDESIGN_ENTRANCE	Z
    //   125: iconst_0
    //   126: putstatic 168	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_RED	Z
    //   129: iconst_0
    //   130: putstatic 171	com/tencent/mm/sdk/platformtools/h:IS_FLAVOR_PURPLE	Z
    //   133: ldc 173
    //   135: putstatic 176	com/tencent/mm/sdk/platformtools/h:MATRIX_VERSION	Ljava/lang/String;
    //   138: getstatic 129	com/tencent/mm/loader/j/a:gMM	Z
    //   141: putstatic 177	com/tencent/mm/sdk/platformtools/h:gMM	Z
    //   144: ldc 179
    //   146: putstatic 182	com/tencent/mm/sdk/platformtools/h:KINDA_DEFAULT	Ljava/lang/String;
    //   149: ldc 184
    //   151: putstatic 187	com/tencent/mm/sdk/platformtools/h:TINKER_VERSION	Ljava/lang/String;
    //   154: iconst_0
    //   155: putstatic 190	com/tencent/mm/sdk/platformtools/h:IS_UAT	Z
    //   158: new 192	android/util/ArrayMap
    //   161: dup
    //   162: invokespecial 194	android/util/ArrayMap:<init>	()V
    //   165: astore 8
    //   167: ldc 196
    //   169: invokevirtual 202	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   172: astore 9
    //   174: aload 9
    //   176: arraylength
    //   177: istore_3
    //   178: iconst_0
    //   179: istore_2
    //   180: iload_2
    //   181: iload_3
    //   182: if_icmpge +94 -> 276
    //   185: aload 9
    //   187: iload_2
    //   188: aaload
    //   189: astore 10
    //   191: ldc 75
    //   193: ldc 204
    //   195: iconst_2
    //   196: anewarray 206	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: aload 10
    //   203: invokevirtual 212	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: aload 10
    //   211: aconst_null
    //   212: invokevirtual 216	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   215: aastore
    //   216: invokestatic 219	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload 8
    //   221: aload 10
    //   223: invokevirtual 212	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   226: aload 10
    //   228: aconst_null
    //   229: invokevirtual 216	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: invokevirtual 223	android/util/ArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: iload_2
    //   237: iconst_1
    //   238: iadd
    //   239: istore_2
    //   240: goto -60 -> 180
    //   243: aload 8
    //   245: invokestatic 227	com/tencent/mm/loader/j/a:r	(Landroid/os/Bundle;)V
    //   248: goto -212 -> 36
    //   251: ldc 229
    //   253: astore 8
    //   255: goto -170 -> 85
    //   258: astore 10
    //   260: ldc 75
    //   262: aload 10
    //   264: ldc 231
    //   266: iconst_0
    //   267: anewarray 206	java/lang/Object
    //   270: invokestatic 235	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: goto -37 -> 236
    //   276: getstatic 239	com/tencent/mm/sdk/platformtools/h:GqF	Lcom/tencent/mm/sdk/platformtools/t;
    //   279: astore 9
    //   281: aload 9
    //   283: getfield 244	com/tencent/mm/sdk/platformtools/t:GqZ	Z
    //   286: ifne +13 -> 299
    //   289: aload 9
    //   291: getfield 248	com/tencent/mm/sdk/platformtools/t:GqY	Landroid/util/ArrayMap;
    //   294: aload 8
    //   296: invokevirtual 252	android/util/ArrayMap:putAll	(Landroid/util/ArrayMap;)V
    //   299: getstatic 239	com/tencent/mm/sdk/platformtools/h:GqF	Lcom/tencent/mm/sdk/platformtools/t;
    //   302: iconst_1
    //   303: putfield 244	com/tencent/mm/sdk/platformtools/t:GqZ	Z
    //   306: invokestatic 258	com/tencent/mm/app/l:Ks	()Lcom/tencent/mm/app/l;
    //   309: invokestatic 264	com/tencent/stubs/logger/Log:setLogger	(Lcom/tencent/stubs/logger/Log$Logger;)V
    //   312: aload_0
    //   313: aload_1
    //   314: invokespecial 266	com/tencent/tinker/entry/DefaultApplicationLike:onBaseContextAttached	(Landroid/content/Context;)V
    //   317: aload_1
    //   318: invokestatic 272	com/tencent/mm/app/aa:bt	(Landroid/content/Context;)Z
    //   321: ifeq +9 -> 330
    //   324: ldc 63
    //   326: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: aload_0
    //   331: getfield 41	com/tencent/mm/app/MMApplicationLike:mMMApplicationLikeImpl	Lcom/tencent/mm/app/r;
    //   334: astore 9
    //   336: aload_1
    //   337: invokestatic 277	android/os/Process:myPid	()I
    //   340: invokestatic 281	com/tencent/mm/app/r:getProcessNameByPid	(Landroid/content/Context;I)Ljava/lang/String;
    //   343: astore 10
    //   345: aload 10
    //   347: putstatic 286	com/tencent/mm/app/d:csT	Ljava/lang/String;
    //   350: invokestatic 289	com/tencent/mm/sdk/platformtools/ai:eVc	()Z
    //   353: ifne +18 -> 371
    //   356: getstatic 295	com/tencent/mm/app/ag$a:cJV	Lcom/tencent/mm/app/ag;
    //   359: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   362: invokevirtual 304	com/tencent/mm/app/ag:b	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   365: getstatic 295	com/tencent/mm/app/ag$a:cJV	Lcom/tencent/mm/app/ag;
    //   368: invokevirtual 307	com/tencent/mm/app/ag:KU	()V
    //   371: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   374: astore 8
    //   376: aload 8
    //   378: ifnull +11 -> 389
    //   381: aload 8
    //   383: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   386: ifnonnull +21 -> 407
    //   389: new 315	com/tencent/tinker/loader/TinkerRuntimeException
    //   392: dup
    //   393: ldc_w 317
    //   396: invokespecial 320	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   399: astore_1
    //   400: ldc 63
    //   402: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aload_1
    //   406: athrow
    //   407: aload 8
    //   409: invokevirtual 323	com/tencent/tinker/entry/ApplicationLike:getTinkerFlags	()I
    //   412: invokestatic 329	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:isTinkerEnabledForNativeLib	(I)Z
    //   415: ifeq +49 -> 464
    //   418: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   421: invokestatic 335	com/tencent/tinker/lib/e/b:c	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
    //   424: ifeq +40 -> 464
    //   427: getstatic 129	com/tencent/mm/loader/j/a:gMM	Z
    //   430: ifeq +962 -> 1392
    //   433: ldc_w 337
    //   436: invokestatic 341	com/tencent/mm/app/r:eo	(Ljava/lang/String;)Ljava/lang/String;
    //   439: astore 8
    //   441: aload 8
    //   443: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   446: ifne +8 -> 454
    //   449: aload 8
    //   451: invokestatic 352	com/tencent/mm/compatible/util/j:sA	(Ljava/lang/String;)V
    //   454: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   457: ldc_w 337
    //   460: invokestatic 358	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   463: pop
    //   464: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   467: invokevirtual 362	com/tencent/tinker/entry/ApplicationLike:getApplicationStartMillisTime	()J
    //   470: putstatic 366	com/tencent/mm/app/d:cIh	J
    //   473: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   476: invokestatic 368	com/tencent/mm/app/r:a	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   479: new 370	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   486: getstatic 374	com/tencent/mm/app/r:cIK	Ljava/lang/String;
    //   489: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 380
    //   495: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload 9
    //   500: invokevirtual 383	java/lang/Object:hashCode	()I
    //   503: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: putstatic 374	com/tencent/mm/app/r:cIK	Ljava/lang/String;
    //   512: iconst_0
    //   513: invokestatic 393	com/tencent/mm/sdk/platformtools/ai:vU	(Z)V
    //   516: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   519: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   522: invokestatic 396	com/tencent/mm/sdk/platformtools/ai:setContext	(Landroid/content/Context;)V
    //   525: iconst_0
    //   526: invokestatic 399	com/tencent/mm/sdk/platformtools/ac:Ys	(I)V
    //   529: getstatic 89	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   532: ifne +24 -> 556
    //   535: ldc_w 401
    //   538: ldc_w 403
    //   541: invokestatic 83	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   547: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   550: aload 10
    //   552: invokestatic 408	com/tencent/mm/app/k:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   555: pop
    //   556: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   559: lstore 4
    //   561: new 415	com/tencent/mm/app/q
    //   564: dup
    //   565: new 370	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   572: invokestatic 420	com/tencent/mm/loader/j/b:aoZ	()Ljava/lang/String;
    //   575: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 422
    //   581: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokespecial 423	com/tencent/mm/app/q:<init>	(Ljava/lang/String;)V
    //   590: astore 11
    //   592: aload 11
    //   594: getfield 427	com/tencent/mm/app/q:cIJ	Ljava/util/Properties;
    //   597: ifnull +860 -> 1457
    //   600: aload 11
    //   602: getfield 427	com/tencent/mm/app/q:cIJ	Ljava/util/Properties;
    //   605: ldc_w 429
    //   608: invokevirtual 435	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   611: ifeq +846 -> 1457
    //   614: aload 11
    //   616: getfield 427	com/tencent/mm/app/q:cIJ	Ljava/util/Properties;
    //   619: ldc_w 429
    //   622: invokevirtual 438	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   625: astore 8
    //   627: aload 9
    //   629: aload 8
    //   631: putfield 441	com/tencent/mm/app/r:cIL	Ljava/lang/String;
    //   634: aload 9
    //   636: getstatic 134	com/tencent/mm/sdk/platformtools/h:gMJ	Ljava/lang/String;
    //   639: putfield 444	com/tencent/mm/app/r:cIM	Ljava/lang/String;
    //   642: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   645: lstore 6
    //   647: aload 9
    //   649: lload 6
    //   651: lload 4
    //   653: lsub
    //   654: putfield 447	com/tencent/mm/app/r:cIN	J
    //   657: aload 9
    //   659: lconst_0
    //   660: putfield 450	com/tencent/mm/app/r:cIO	J
    //   663: aload 9
    //   665: getfield 444	com/tencent/mm/app/r:cIM	Ljava/lang/String;
    //   668: aload 9
    //   670: getfield 441	com/tencent/mm/app/r:cIL	Ljava/lang/String;
    //   673: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifne +181 -> 857
    //   679: iconst_1
    //   680: putstatic 458	com/tencent/mm/sdk/platformtools/ai:GrM	Z
    //   683: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   686: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   689: ldc_w 460
    //   692: iconst_0
    //   693: invokevirtual 466	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   696: invokestatic 470	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   699: pop
    //   700: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   703: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   706: ldc_w 472
    //   709: iconst_0
    //   710: invokevirtual 466	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   713: invokestatic 470	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   716: pop
    //   717: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   720: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   723: ldc_w 474
    //   726: iconst_0
    //   727: invokevirtual 466	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   730: invokestatic 470	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   733: pop
    //   734: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   737: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   740: ldc_w 476
    //   743: iconst_0
    //   744: invokevirtual 466	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   747: invokestatic 470	com/tencent/mm/app/r:D	(Ljava/io/File;)Z
    //   750: pop
    //   751: getstatic 477	com/tencent/mm/loader/j/a:gMJ	Ljava/lang/String;
    //   754: getstatic 134	com/tencent/mm/sdk/platformtools/h:gMJ	Ljava/lang/String;
    //   757: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   760: ifeq +44 -> 804
    //   763: ldc_w 401
    //   766: ldc_w 479
    //   769: iconst_3
    //   770: anewarray 206	java/lang/Object
    //   773: dup
    //   774: iconst_0
    //   775: aload 9
    //   777: getfield 441	com/tencent/mm/app/r:cIL	Ljava/lang/String;
    //   780: aastore
    //   781: dup
    //   782: iconst_1
    //   783: aload 9
    //   785: getfield 444	com/tencent/mm/app/r:cIM	Ljava/lang/String;
    //   788: aastore
    //   789: dup
    //   790: iconst_2
    //   791: getstatic 477	com/tencent/mm/loader/j/a:gMJ	Ljava/lang/String;
    //   794: aastore
    //   795: invokestatic 219	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   798: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   801: invokestatic 481	com/tencent/tinker/lib/e/b:e	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   804: aload 11
    //   806: ldc_w 429
    //   809: aload 9
    //   811: getfield 444	com/tencent/mm/app/r:cIM	Ljava/lang/String;
    //   814: invokevirtual 485	com/tencent/mm/app/q:M	(Ljava/lang/String;Ljava/lang/String;)Z
    //   817: pop
    //   818: aload 9
    //   820: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   823: lload 6
    //   825: lsub
    //   826: putfield 450	com/tencent/mm/app/r:cIO	J
    //   829: ldc_w 401
    //   832: ldc_w 487
    //   835: iconst_2
    //   836: anewarray 206	java/lang/Object
    //   839: dup
    //   840: iconst_0
    //   841: getstatic 374	com/tencent/mm/app/r:cIK	Ljava/lang/String;
    //   844: aastore
    //   845: dup
    //   846: iconst_1
    //   847: invokestatic 493	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
    //   850: invokevirtual 496	com/tencent/mm/sdk/platformtools/as:toString	()Ljava/lang/String;
    //   853: aastore
    //   854: invokestatic 499	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   857: ldc_w 401
    //   860: ldc_w 501
    //   863: iconst_4
    //   864: anewarray 206	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: aload 9
    //   871: getfield 441	com/tencent/mm/app/r:cIL	Ljava/lang/String;
    //   874: aastore
    //   875: dup
    //   876: iconst_1
    //   877: aload 9
    //   879: getfield 444	com/tencent/mm/app/r:cIM	Ljava/lang/String;
    //   882: aastore
    //   883: dup
    //   884: iconst_2
    //   885: aload 9
    //   887: getfield 447	com/tencent/mm/app/r:cIN	J
    //   890: invokestatic 507	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   893: aastore
    //   894: dup
    //   895: iconst_3
    //   896: aload 9
    //   898: getfield 450	com/tencent/mm/app/r:cIO	J
    //   901: invokestatic 507	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   904: aastore
    //   905: invokestatic 219	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   908: getstatic 89	com/tencent/mm/sdk/platformtools/h:DEBUG	Z
    //   911: ifne +9 -> 920
    //   914: getstatic 162	com/tencent/mm/sdk/platformtools/h:PRE_RELEASE	Z
    //   917: ifeq +24 -> 941
    //   920: ldc_w 401
    //   923: ldc_w 509
    //   926: invokestatic 83	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   932: invokevirtual 313	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   935: aload 10
    //   937: invokestatic 408	com/tencent/mm/app/k:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   940: pop
    //   941: getstatic 286	com/tencent/mm/app/d:csT	Ljava/lang/String;
    //   944: astore 8
    //   946: aload 8
    //   948: aload_1
    //   949: invokevirtual 514	android/content/Context:getPackageName	()Ljava/lang/String;
    //   952: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   955: ifeq +424 -> 1379
    //   958: ldc 8
    //   960: ldc_w 516
    //   963: iconst_0
    //   964: anewarray 206	java/lang/Object
    //   967: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   970: aload_0
    //   971: invokestatic 335	com/tencent/tinker/lib/e/b:c	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
    //   974: ifeq +546 -> 1520
    //   977: aload_1
    //   978: invokestatic 526	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchDirectory	(Landroid/content/Context;)Ljava/io/File;
    //   981: astore 12
    //   983: aload 12
    //   985: invokevirtual 531	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   988: invokestatic 535	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchInfoFile	(Ljava/lang/String;)Ljava/io/File;
    //   991: astore 9
    //   993: aload 12
    //   995: invokevirtual 531	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   998: invokestatic 538	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchInfoLockFile	(Ljava/lang/String;)Ljava/io/File;
    //   1001: astore 10
    //   1003: aload 9
    //   1005: aload 10
    //   1007: invokestatic 544	com/tencent/tinker/loader/shareutil/SharePatchInfo:readAndCheckPropertyWithLock	(Ljava/io/File;Ljava/io/File;)Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;
    //   1010: astore 11
    //   1012: ldc_w 546
    //   1015: aload 11
    //   1017: getfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1020: invokevirtual 455	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1023: ifeq +482 -> 1505
    //   1026: ldc 8
    //   1028: ldc_w 551
    //   1031: iconst_4
    //   1032: anewarray 206	java/lang/Object
    //   1035: dup
    //   1036: iconst_0
    //   1037: aload 11
    //   1039: getfield 554	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1042: aastore
    //   1043: dup
    //   1044: iconst_1
    //   1045: aload 11
    //   1047: getfield 557	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1050: aastore
    //   1051: dup
    //   1052: iconst_2
    //   1053: aload 11
    //   1055: getfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1058: aastore
    //   1059: dup
    //   1060: iconst_3
    //   1061: aload 11
    //   1063: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1066: aastore
    //   1067: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1070: iconst_3
    //   1071: anewarray 206	java/lang/Object
    //   1074: dup
    //   1075: iconst_0
    //   1076: iconst_2
    //   1077: invokestatic 563	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1080: aastore
    //   1081: dup
    //   1082: iconst_1
    //   1083: aload 8
    //   1085: aastore
    //   1086: dup
    //   1087: iconst_2
    //   1088: ldc_w 565
    //   1091: iconst_4
    //   1092: anewarray 206	java/lang/Object
    //   1095: dup
    //   1096: iconst_0
    //   1097: aload 11
    //   1099: getfield 554	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1102: aastore
    //   1103: dup
    //   1104: iconst_1
    //   1105: aload 11
    //   1107: getfield 557	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1110: aastore
    //   1111: dup
    //   1112: iconst_2
    //   1113: aload 11
    //   1115: getfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1118: aastore
    //   1119: dup
    //   1120: iconst_3
    //   1121: aload 11
    //   1123: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1126: aastore
    //   1127: invokestatic 569	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1130: aastore
    //   1131: invokestatic 573	com/tencent/mm/app/x:g	([Ljava/lang/Object;)V
    //   1134: new 528	java/io/File
    //   1137: dup
    //   1138: aload 12
    //   1140: aload 11
    //   1142: getfield 557	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1145: invokestatic 576	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getPatchVersionDirectory	(Ljava/lang/String;)Ljava/lang/String;
    //   1148: invokespecial 579	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1151: astore 13
    //   1153: new 528	java/io/File
    //   1156: dup
    //   1157: aload 13
    //   1159: ldc_w 581
    //   1162: invokespecial 579	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1165: astore 12
    //   1167: new 528	java/io/File
    //   1170: dup
    //   1171: aload 13
    //   1173: ldc_w 583
    //   1176: invokespecial 579	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1179: astore 13
    //   1181: new 528	java/io/File
    //   1184: dup
    //   1185: aload 12
    //   1187: ldc_w 585
    //   1190: invokespecial 579	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1193: astore 12
    //   1195: new 528	java/io/File
    //   1198: dup
    //   1199: aload 13
    //   1201: ldc_w 585
    //   1204: invokespecial 579	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1207: astore 13
    //   1209: aload 12
    //   1211: invokevirtual 588	java/io/File:exists	()Z
    //   1214: ifeq +249 -> 1463
    //   1217: aload 12
    //   1219: invokevirtual 591	java/io/File:canRead	()Z
    //   1222: ifeq +241 -> 1463
    //   1225: aload 11
    //   1227: ldc_w 581
    //   1230: putfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1233: iconst_3
    //   1234: anewarray 206	java/lang/Object
    //   1237: dup
    //   1238: iconst_0
    //   1239: iconst_2
    //   1240: invokestatic 563	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1243: aastore
    //   1244: dup
    //   1245: iconst_1
    //   1246: aload 8
    //   1248: aastore
    //   1249: dup
    //   1250: iconst_2
    //   1251: ldc_w 593
    //   1254: iconst_4
    //   1255: anewarray 206	java/lang/Object
    //   1258: dup
    //   1259: iconst_0
    //   1260: aload 11
    //   1262: getfield 554	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1265: aastore
    //   1266: dup
    //   1267: iconst_1
    //   1268: aload 11
    //   1270: getfield 557	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1273: aastore
    //   1274: dup
    //   1275: iconst_2
    //   1276: aload 11
    //   1278: getfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1281: aastore
    //   1282: dup
    //   1283: iconst_3
    //   1284: aload 11
    //   1286: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1289: aastore
    //   1290: invokestatic 569	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1293: aastore
    //   1294: invokestatic 573	com/tencent/mm/app/x:g	([Ljava/lang/Object;)V
    //   1297: ldc 8
    //   1299: ldc_w 595
    //   1302: iconst_4
    //   1303: anewarray 206	java/lang/Object
    //   1306: dup
    //   1307: iconst_0
    //   1308: aload 11
    //   1310: getfield 554	com/tencent/tinker/loader/shareutil/SharePatchInfo:oldVersion	Ljava/lang/String;
    //   1313: aastore
    //   1314: dup
    //   1315: iconst_1
    //   1316: aload 11
    //   1318: getfield 557	com/tencent/tinker/loader/shareutil/SharePatchInfo:newVersion	Ljava/lang/String;
    //   1321: aastore
    //   1322: dup
    //   1323: iconst_2
    //   1324: aload 11
    //   1326: getfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1329: aastore
    //   1330: dup
    //   1331: iconst_3
    //   1332: aload 11
    //   1334: getfield 560	com/tencent/tinker/loader/shareutil/SharePatchInfo:fingerPrint	Ljava/lang/String;
    //   1337: aastore
    //   1338: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1341: aload 9
    //   1343: aload 11
    //   1345: aload 10
    //   1347: invokestatic 599	com/tencent/tinker/loader/shareutil/SharePatchInfo:rewritePatchInfoFileWithLock	(Ljava/io/File;Lcom/tencent/tinker/loader/shareutil/SharePatchInfo;Ljava/io/File;)Z
    //   1350: pop
    //   1351: ldc 8
    //   1353: ldc_w 601
    //   1356: iconst_0
    //   1357: anewarray 206	java/lang/Object
    //   1360: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1363: aload_1
    //   1364: invokestatic 604	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:killProcessExceptMain	(Landroid/content/Context;)V
    //   1367: ldc 8
    //   1369: ldc_w 606
    //   1372: iconst_0
    //   1373: anewarray 206	java/lang/Object
    //   1376: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1379: aload_1
    //   1380: invokestatic 611	com/tencent/mm/app/j:bo	(Landroid/content/Context;)Z
    //   1383: ifeq +152 -> 1535
    //   1386: ldc 63
    //   1388: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1391: return
    //   1392: ldc_w 613
    //   1395: invokestatic 341	com/tencent/mm/app/r:eo	(Ljava/lang/String;)Ljava/lang/String;
    //   1398: astore 8
    //   1400: aload 8
    //   1402: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1405: ifne +8 -> 1413
    //   1408: aload 8
    //   1410: invokestatic 352	com/tencent/mm/compatible/util/j:sA	(Ljava/lang/String;)V
    //   1413: ldc_w 615
    //   1416: invokestatic 341	com/tencent/mm/app/r:eo	(Ljava/lang/String;)Ljava/lang/String;
    //   1419: astore 8
    //   1421: aload 8
    //   1423: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1426: ifne +8 -> 1434
    //   1429: aload 8
    //   1431: invokestatic 352	com/tencent/mm/compatible/util/j:sA	(Ljava/lang/String;)V
    //   1434: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   1437: ldc_w 613
    //   1440: invokestatic 358	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   1443: pop
    //   1444: getstatic 299	com/tencent/mm/app/r:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
    //   1447: ldc_w 615
    //   1450: invokestatic 358	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   1453: pop
    //   1454: goto -990 -> 464
    //   1457: aconst_null
    //   1458: astore 8
    //   1460: goto -833 -> 627
    //   1463: aload 13
    //   1465: invokevirtual 588	java/io/File:exists	()Z
    //   1468: ifeq -235 -> 1233
    //   1471: aload 13
    //   1473: invokevirtual 591	java/io/File:canRead	()Z
    //   1476: ifeq -243 -> 1233
    //   1479: aload 11
    //   1481: ldc_w 583
    //   1484: putfield 549	com/tencent/tinker/loader/shareutil/SharePatchInfo:oatDir	Ljava/lang/String;
    //   1487: goto -254 -> 1233
    //   1490: astore 9
    //   1492: ldc 8
    //   1494: aload 9
    //   1496: ldc_w 617
    //   1499: invokestatic 620	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1502: goto -123 -> 1379
    //   1505: ldc 8
    //   1507: ldc_w 622
    //   1510: iconst_0
    //   1511: anewarray 206	java/lang/Object
    //   1514: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1517: goto -138 -> 1379
    //   1520: ldc 8
    //   1522: ldc_w 624
    //   1525: iconst_0
    //   1526: anewarray 206	java/lang/Object
    //   1529: invokestatic 520	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1532: goto -153 -> 1379
    //   1535: invokestatic 289	com/tencent/mm/sdk/platformtools/ai:eVc	()Z
    //   1538: ifeq +86 -> 1624
    //   1541: aload_0
    //   1542: new 370	java/lang/StringBuilder
    //   1545: dup
    //   1546: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   1549: invokestatic 625	com/tencent/mm/sdk/platformtools/ai:getPackageName	()Ljava/lang/String;
    //   1552: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: ldc_w 627
    //   1558: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: invokestatic 631	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1567: iconst_2
    //   1568: anewarray 198	java/lang/Class
    //   1571: dup
    //   1572: iconst_0
    //   1573: ldc_w 309
    //   1576: aastore
    //   1577: dup
    //   1578: iconst_1
    //   1579: ldc_w 452
    //   1582: aastore
    //   1583: invokevirtual 635	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1586: iconst_2
    //   1587: anewarray 206	java/lang/Object
    //   1590: dup
    //   1591: iconst_0
    //   1592: aload_0
    //   1593: aastore
    //   1594: dup
    //   1595: iconst_1
    //   1596: aload 8
    //   1598: aastore
    //   1599: invokevirtual 641	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1602: checkcast 643	com/tencent/tinker/entry/ApplicationLifeCycle
    //   1605: putfield 645	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1608: aload_0
    //   1609: getfield 645	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1612: aload_1
    //   1613: invokeinterface 646 2 0
    //   1618: ldc 63
    //   1620: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1623: return
    //   1624: aload_0
    //   1625: new 370	java/lang/StringBuilder
    //   1628: dup
    //   1629: invokespecial 371	java/lang/StringBuilder:<init>	()V
    //   1632: invokestatic 625	com/tencent/mm/sdk/platformtools/ai:getPackageName	()Ljava/lang/String;
    //   1635: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: ldc_w 648
    //   1641: invokevirtual 378	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: invokevirtual 389	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1647: invokestatic 631	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1650: iconst_2
    //   1651: anewarray 198	java/lang/Class
    //   1654: dup
    //   1655: iconst_0
    //   1656: ldc_w 309
    //   1659: aastore
    //   1660: dup
    //   1661: iconst_1
    //   1662: ldc_w 452
    //   1665: aastore
    //   1666: invokevirtual 635	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   1669: iconst_2
    //   1670: anewarray 206	java/lang/Object
    //   1673: dup
    //   1674: iconst_0
    //   1675: aload_0
    //   1676: aastore
    //   1677: dup
    //   1678: iconst_1
    //   1679: aload 8
    //   1681: aastore
    //   1682: invokevirtual 641	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1685: checkcast 643	com/tencent/tinker/entry/ApplicationLifeCycle
    //   1688: putfield 645	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1691: goto -83 -> 1608
    //   1694: astore_1
    //   1695: ldc 8
    //   1697: aload_1
    //   1698: ldc_w 650
    //   1701: iconst_0
    //   1702: anewarray 206	java/lang/Object
    //   1705: invokestatic 235	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1708: new 652	java/lang/RuntimeException
    //   1711: dup
    //   1712: ldc_w 650
    //   1715: aload_1
    //   1716: invokespecial 655	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1719: astore_1
    //   1720: ldc 63
    //   1722: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1725: aload_1
    //   1726: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1727	0	this	MMApplicationLike
    //   0	1727	1	paramContext	android.content.Context
    //   179	61	2	i	int
    //   177	6	3	j	int
    //   559	93	4	l1	long
    //   645	179	6	l2	long
    //   22	1658	8	localObject1	Object
    //   172	1170	9	localObject2	Object
    //   1490	5	9	localThrowable	java.lang.Throwable
    //   189	38	10	localObject3	Object
    //   258	5	10	localIllegalAccessException	java.lang.IllegalAccessException
    //   343	1003	10	localObject4	Object
    //   590	890	11	localObject5	Object
    //   981	237	12	localFile1	java.io.File
    //   1151	321	13	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   191	236	258	java/lang/IllegalAccessException
    //   970	1233	1490	java/lang/Throwable
    //   1233	1379	1490	java/lang/Throwable
    //   1463	1487	1490	java/lang/Throwable
    //   1505	1517	1490	java/lang/Throwable
    //   1520	1532	1490	java/lang/Throwable
    //   1535	1608	1694	java/lang/Exception
    //   1608	1618	1694	java/lang/Exception
    //   1624	1691	1694	java/lang/Exception
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(123471);
    ac.d("MicroMsg.MMApplication", "configuration changed");
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