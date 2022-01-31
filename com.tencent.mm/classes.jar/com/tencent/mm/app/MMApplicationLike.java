package com.tencent.mm.app;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.DefaultApplicationLike;

public class MMApplicationLike
  extends DefaultApplicationLike
{
  private static final String TAG = "MicroMsg.MMApplication";
  private static MMApplicationLike sSafeguardInstance = null;
  private static byte[] sSafeguardLock = new byte[0];
  private l mMMApplicationLikeImpl;
  private ApplicationLifeCycle wrapper;
  
  public MMApplicationLike(Application paramApplication, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    super(paramApplication, paramInt, paramBoolean, paramLong1, paramLong2, paramIntent);
    AppMethodBeat.i(3232);
    this.mMMApplicationLikeImpl = new l(this);
    AppMethodBeat.o(3232);
  }
  
  public Resources getResources(Resources paramResources)
  {
    AppMethodBeat.i(3237);
    if (ah.getResources() == null)
    {
      AppMethodBeat.o(3237);
      return paramResources;
    }
    paramResources = ah.getResources();
    AppMethodBeat.o(3237);
    return paramResources;
  }
  
  /* Error */
  public void onBaseContextAttached(android.content.Context paramContext)
  {
    // Byte code:
    //   0: sipush 3233
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 60	com/tencent/mm/app/MMApplicationLike:safeguard	()Z
    //   10: ifeq +10 -> 20
    //   13: sipush 3233
    //   16: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_1
    //   21: invokestatic 66	com/tencent/mm/app/t:bd	(Landroid/content/Context;)Landroid/os/Bundle;
    //   24: astore 8
    //   26: aload 8
    //   28: ifnonnull +182 -> 210
    //   31: ldc 68
    //   33: ldc 70
    //   35: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: iconst_0
    //   39: putstatic 82	com/tencent/mm/sdk/platformtools/f:DEBUG	Z
    //   42: ldc 84
    //   44: putstatic 87	com/tencent/mm/sdk/platformtools/f:BUILD_TAG	Ljava/lang/String;
    //   47: ldc 89
    //   49: putstatic 92	com/tencent/mm/sdk/platformtools/f:OWNER	Ljava/lang/String;
    //   52: ldc 94
    //   54: putstatic 97	com/tencent/mm/sdk/platformtools/f:HOSTNAME	Ljava/lang/String;
    //   57: ldc 99
    //   59: putstatic 102	com/tencent/mm/sdk/platformtools/f:TIME	Ljava/lang/String;
    //   62: ldc 104
    //   64: putstatic 107	com/tencent/mm/sdk/platformtools/f:COMMAND	Ljava/lang/String;
    //   67: ldc 109
    //   69: putstatic 112	com/tencent/mm/sdk/platformtools/f:REV	Ljava/lang/String;
    //   72: ldc 114
    //   74: putstatic 117	com/tencent/mm/sdk/platformtools/f:SVNPATH	Ljava/lang/String;
    //   77: ldc 119
    //   79: putstatic 122	com/tencent/mm/sdk/platformtools/f:CLIENT_VERSION	Ljava/lang/String;
    //   82: ldc 119
    //   84: invokestatic 128	java/lang/Integer:decode	(Ljava/lang/String;)Ljava/lang/Integer;
    //   87: invokevirtual 132	java/lang/Integer:intValue	()I
    //   90: putstatic 136	com/tencent/mm/sdk/platformtools/f:ymG	I
    //   93: iconst_0
    //   94: putstatic 139	com/tencent/mm/sdk/platformtools/f:ENABLE_FPS_ANALYSE	Z
    //   97: iconst_1
    //   98: putstatic 142	com/tencent/mm/sdk/platformtools/f:ENABLE_MATRIX	Z
    //   101: iconst_0
    //   102: putstatic 145	com/tencent/mm/sdk/platformtools/f:ENABLE_MATRIX_TRACE	Z
    //   105: iconst_0
    //   106: putstatic 148	com/tencent/mm/sdk/platformtools/f:EX_DEVICE_LOGIN	Z
    //   109: iconst_0
    //   110: putstatic 151	com/tencent/mm/sdk/platformtools/f:PRE_RELEASE	Z
    //   113: iconst_0
    //   114: putstatic 154	com/tencent/mm/sdk/platformtools/f:REDESIGN_ENTRANCE	Z
    //   117: iconst_0
    //   118: putstatic 157	com/tencent/mm/sdk/platformtools/f:IS_FLAVOR_RED	Z
    //   121: iconst_0
    //   122: putstatic 160	com/tencent/mm/sdk/platformtools/f:IS_FLAVOR_PURPLE	Z
    //   125: new 162	android/util/ArrayMap
    //   128: dup
    //   129: invokespecial 164	android/util/ArrayMap:<init>	()V
    //   132: astore 8
    //   134: ldc 166
    //   136: invokevirtual 172	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   139: astore 9
    //   141: aload 9
    //   143: arraylength
    //   144: istore_3
    //   145: iconst_0
    //   146: istore_2
    //   147: iload_2
    //   148: iload_3
    //   149: if_icmpge +87 -> 236
    //   152: aload 9
    //   154: iload_2
    //   155: aaload
    //   156: astore 10
    //   158: ldc 68
    //   160: ldc 174
    //   162: iconst_2
    //   163: anewarray 176	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload 10
    //   170: invokevirtual 182	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: aload 10
    //   178: aconst_null
    //   179: invokevirtual 186	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: aastore
    //   183: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload 8
    //   188: aload 10
    //   190: invokevirtual 182	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   193: aload 10
    //   195: aconst_null
    //   196: invokevirtual 186	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: invokevirtual 193	android/util/ArrayMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: iload_2
    //   204: iconst_1
    //   205: iadd
    //   206: istore_2
    //   207: goto -60 -> 147
    //   210: aload 8
    //   212: invokestatic 199	com/tencent/mm/loader/j/a:p	(Landroid/os/Bundle;)V
    //   215: goto -177 -> 38
    //   218: astore 10
    //   220: ldc 68
    //   222: aload 10
    //   224: ldc 201
    //   226: iconst_0
    //   227: anewarray 176	java/lang/Object
    //   230: invokestatic 205	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: goto -30 -> 203
    //   236: getstatic 209	com/tencent/mm/sdk/platformtools/f:ymH	Lcom/tencent/mm/sdk/platformtools/s;
    //   239: astore 9
    //   241: aload 9
    //   243: getfield 214	com/tencent/mm/sdk/platformtools/s:ymW	Z
    //   246: ifne +13 -> 259
    //   249: aload 9
    //   251: getfield 218	com/tencent/mm/sdk/platformtools/s:ymV	Landroid/util/ArrayMap;
    //   254: aload 8
    //   256: invokevirtual 222	android/util/ArrayMap:putAll	(Landroid/util/ArrayMap;)V
    //   259: getstatic 209	com/tencent/mm/sdk/platformtools/f:ymH	Lcom/tencent/mm/sdk/platformtools/s;
    //   262: iconst_1
    //   263: putfield 214	com/tencent/mm/sdk/platformtools/s:ymW	Z
    //   266: getstatic 228	com/tencent/mm/app/i$a:bXZ	Lcom/tencent/mm/app/i;
    //   269: invokestatic 234	com/tencent/f/a/b:a	(Lcom/tencent/f/a/b$a;)V
    //   272: aload_0
    //   273: aload_1
    //   274: invokespecial 236	com/tencent/tinker/entry/DefaultApplicationLike:onBaseContextAttached	(Landroid/content/Context;)V
    //   277: aload_0
    //   278: getfield 40	com/tencent/mm/app/MMApplicationLike:mMMApplicationLikeImpl	Lcom/tencent/mm/app/l;
    //   281: astore 8
    //   283: aload_1
    //   284: invokestatic 241	android/os/Process:myPid	()I
    //   287: invokestatic 247	com/tencent/mm/sdk/platformtools/bo:az	(Landroid/content/Context;I)Ljava/lang/String;
    //   290: astore 9
    //   292: aload 9
    //   294: putstatic 252	com/tencent/mm/app/b:bNv	Ljava/lang/String;
    //   297: invokestatic 255	com/tencent/mm/sdk/platformtools/ah:dsV	()Z
    //   300: ifne +18 -> 318
    //   303: getstatic 261	com/tencent/mm/app/y$a:bZh	Lcom/tencent/mm/app/y;
    //   306: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   309: invokevirtual 270	com/tencent/mm/app/y:b	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   312: getstatic 261	com/tencent/mm/app/y$a:bZh	Lcom/tencent/mm/app/y;
    //   315: invokevirtual 273	com/tencent/mm/app/y:Bz	()V
    //   318: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   321: astore 10
    //   323: aload 10
    //   325: ifnull +11 -> 336
    //   328: aload 10
    //   330: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   333: ifnonnull +22 -> 355
    //   336: new 281	com/tencent/tinker/loader/TinkerRuntimeException
    //   339: dup
    //   340: ldc_w 283
    //   343: invokespecial 286	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;)V
    //   346: astore_1
    //   347: sipush 3233
    //   350: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: aload_1
    //   354: athrow
    //   355: aload 10
    //   357: invokevirtual 289	com/tencent/tinker/entry/ApplicationLike:getTinkerFlags	()I
    //   360: invokestatic 295	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:Tf	(I)Z
    //   363: ifeq +32 -> 395
    //   366: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   369: invokestatic 301	com/tencent/tinker/lib/e/b:c	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
    //   372: ifeq +23 -> 395
    //   375: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   378: ldc_w 303
    //   381: invokestatic 308	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   384: pop
    //   385: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   388: ldc_w 310
    //   391: invokestatic 308	com/tencent/tinker/lib/a/a:a	(Lcom/tencent/tinker/entry/ApplicationLike;Ljava/lang/String;)Z
    //   394: pop
    //   395: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   398: invokevirtual 314	com/tencent/tinker/entry/ApplicationLike:getApplicationStartMillisTime	()J
    //   401: putstatic 318	com/tencent/mm/app/b:bXE	J
    //   404: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   407: invokestatic 320	com/tencent/mm/app/l:a	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   410: new 322	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   417: getstatic 326	com/tencent/mm/app/l:bYf	Ljava/lang/String;
    //   420: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 332
    //   426: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 8
    //   431: invokevirtual 335	java/lang/Object:hashCode	()I
    //   434: invokevirtual 338	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: putstatic 326	com/tencent/mm/app/l:bYf	Ljava/lang/String;
    //   443: iconst_0
    //   444: invokestatic 345	com/tencent/mm/sdk/platformtools/ah:pI	(Z)V
    //   447: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   450: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   453: invokestatic 348	com/tencent/mm/sdk/platformtools/ah:setContext	(Landroid/content/Context;)V
    //   456: iconst_0
    //   457: invokestatic 351	com/tencent/mm/sdk/platformtools/ab:Ne	(I)V
    //   460: getstatic 82	com/tencent/mm/sdk/platformtools/f:DEBUG	Z
    //   463: ifne +24 -> 487
    //   466: ldc_w 353
    //   469: ldc_w 355
    //   472: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   478: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   481: aload 9
    //   483: invokestatic 360	com/tencent/mm/app/h:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   486: pop
    //   487: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   490: lstore 4
    //   492: new 367	com/tencent/mm/sdk/e/a
    //   495: dup
    //   496: new 322	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   503: getstatic 372	com/tencent/mm/loader/j/b:eQv	Ljava/lang/String;
    //   506: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc_w 374
    //   512: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokespecial 375	com/tencent/mm/sdk/e/a:<init>	(Ljava/lang/String;)V
    //   521: astore 10
    //   523: aload 8
    //   525: aload 10
    //   527: ldc_w 377
    //   530: invokevirtual 381	com/tencent/mm/sdk/e/a:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   533: putfield 384	com/tencent/mm/app/l:bYg	Ljava/lang/String;
    //   536: aload 8
    //   538: getstatic 122	com/tencent/mm/sdk/platformtools/f:CLIENT_VERSION	Ljava/lang/String;
    //   541: putfield 387	com/tencent/mm/app/l:bYh	Ljava/lang/String;
    //   544: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   547: lstore 6
    //   549: aload 8
    //   551: lload 6
    //   553: lload 4
    //   555: lsub
    //   556: putfield 390	com/tencent/mm/app/l:bYi	J
    //   559: aload 8
    //   561: lconst_0
    //   562: putfield 393	com/tencent/mm/app/l:bYj	J
    //   565: aload 8
    //   567: getfield 387	com/tencent/mm/app/l:bYh	Ljava/lang/String;
    //   570: aload 8
    //   572: getfield 384	com/tencent/mm/app/l:bYg	Ljava/lang/String;
    //   575: invokevirtual 399	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifne +181 -> 759
    //   581: iconst_1
    //   582: putstatic 402	com/tencent/mm/sdk/platformtools/ah:ynK	Z
    //   585: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   588: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   591: ldc_w 404
    //   594: iconst_0
    //   595: invokevirtual 410	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   598: invokestatic 415	com/tencent/mm/a/e:p	(Ljava/io/File;)Z
    //   601: pop
    //   602: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   605: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   608: ldc_w 417
    //   611: iconst_0
    //   612: invokevirtual 410	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   615: invokestatic 415	com/tencent/mm/a/e:p	(Ljava/io/File;)Z
    //   618: pop
    //   619: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   622: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   625: ldc_w 419
    //   628: iconst_0
    //   629: invokevirtual 410	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   632: invokestatic 415	com/tencent/mm/a/e:p	(Ljava/io/File;)Z
    //   635: pop
    //   636: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   639: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   642: ldc_w 421
    //   645: iconst_0
    //   646: invokevirtual 410	android/app/Application:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   649: invokestatic 415	com/tencent/mm/a/e:p	(Ljava/io/File;)Z
    //   652: pop
    //   653: getstatic 422	com/tencent/mm/loader/j/a:CLIENT_VERSION	Ljava/lang/String;
    //   656: getstatic 122	com/tencent/mm/sdk/platformtools/f:CLIENT_VERSION	Ljava/lang/String;
    //   659: invokevirtual 399	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   662: ifeq +44 -> 706
    //   665: ldc_w 353
    //   668: ldc_w 424
    //   671: iconst_3
    //   672: anewarray 176	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: aload 8
    //   679: getfield 384	com/tencent/mm/app/l:bYg	Ljava/lang/String;
    //   682: aastore
    //   683: dup
    //   684: iconst_1
    //   685: aload 8
    //   687: getfield 387	com/tencent/mm/app/l:bYh	Ljava/lang/String;
    //   690: aastore
    //   691: dup
    //   692: iconst_2
    //   693: getstatic 422	com/tencent/mm/loader/j/a:CLIENT_VERSION	Ljava/lang/String;
    //   696: aastore
    //   697: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   700: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   703: invokestatic 426	com/tencent/tinker/lib/e/b:e	(Lcom/tencent/tinker/entry/ApplicationLike;)V
    //   706: aload 10
    //   708: ldc_w 377
    //   711: aload 8
    //   713: getfield 387	com/tencent/mm/app/l:bYh	Ljava/lang/String;
    //   716: invokevirtual 430	com/tencent/mm/sdk/e/a:ij	(Ljava/lang/String;Ljava/lang/String;)Z
    //   719: pop
    //   720: aload 8
    //   722: invokestatic 365	java/lang/System:currentTimeMillis	()J
    //   725: lload 6
    //   727: lsub
    //   728: putfield 393	com/tencent/mm/app/l:bYj	J
    //   731: ldc_w 353
    //   734: ldc_w 432
    //   737: iconst_2
    //   738: anewarray 176	java/lang/Object
    //   741: dup
    //   742: iconst_0
    //   743: getstatic 326	com/tencent/mm/app/l:bYf	Ljava/lang/String;
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: invokestatic 436	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   752: invokevirtual 439	com/tencent/mm/sdk/platformtools/an:toString	()Ljava/lang/String;
    //   755: aastore
    //   756: invokestatic 442	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   759: ldc_w 353
    //   762: ldc_w 444
    //   765: iconst_4
    //   766: anewarray 176	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: aload 8
    //   773: getfield 384	com/tencent/mm/app/l:bYg	Ljava/lang/String;
    //   776: aastore
    //   777: dup
    //   778: iconst_1
    //   779: aload 8
    //   781: getfield 387	com/tencent/mm/app/l:bYh	Ljava/lang/String;
    //   784: aastore
    //   785: dup
    //   786: iconst_2
    //   787: aload 8
    //   789: getfield 390	com/tencent/mm/app/l:bYi	J
    //   792: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   795: aastore
    //   796: dup
    //   797: iconst_3
    //   798: aload 8
    //   800: getfield 393	com/tencent/mm/app/l:bYj	J
    //   803: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   806: aastore
    //   807: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   810: getstatic 82	com/tencent/mm/sdk/platformtools/f:DEBUG	Z
    //   813: ifne +9 -> 822
    //   816: getstatic 151	com/tencent/mm/sdk/platformtools/f:PRE_RELEASE	Z
    //   819: ifeq +24 -> 843
    //   822: ldc_w 353
    //   825: ldc_w 452
    //   828: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: getstatic 265	com/tencent/mm/app/l:bXD	Lcom/tencent/tinker/entry/ApplicationLike;
    //   834: invokevirtual 279	com/tencent/tinker/entry/ApplicationLike:getApplication	()Landroid/app/Application;
    //   837: aload 9
    //   839: invokestatic 360	com/tencent/mm/app/h:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   842: pop
    //   843: getstatic 252	com/tencent/mm/app/b:bNv	Ljava/lang/String;
    //   846: astore 8
    //   848: invokestatic 255	com/tencent/mm/sdk/platformtools/ah:dsV	()Z
    //   851: ifeq +87 -> 938
    //   854: aload_0
    //   855: new 322	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   862: invokestatic 455	com/tencent/mm/sdk/platformtools/ah:getPackageName	()Ljava/lang/String;
    //   865: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: ldc_w 457
    //   871: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokestatic 461	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   880: iconst_2
    //   881: anewarray 168	java/lang/Class
    //   884: dup
    //   885: iconst_0
    //   886: ldc_w 275
    //   889: aastore
    //   890: dup
    //   891: iconst_1
    //   892: ldc_w 395
    //   895: aastore
    //   896: invokevirtual 465	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   899: iconst_2
    //   900: anewarray 176	java/lang/Object
    //   903: dup
    //   904: iconst_0
    //   905: aload_0
    //   906: aastore
    //   907: dup
    //   908: iconst_1
    //   909: aload 8
    //   911: aastore
    //   912: invokevirtual 471	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   915: checkcast 473	com/tencent/tinker/entry/ApplicationLifeCycle
    //   918: putfield 475	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   921: aload_0
    //   922: getfield 475	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   925: aload_1
    //   926: invokeinterface 476 2 0
    //   931: sipush 3233
    //   934: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: return
    //   938: aload_0
    //   939: new 322	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 323	java/lang/StringBuilder:<init>	()V
    //   946: invokestatic 455	com/tencent/mm/sdk/platformtools/ah:getPackageName	()Ljava/lang/String;
    //   949: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: ldc_w 478
    //   955: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 461	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   964: iconst_2
    //   965: anewarray 168	java/lang/Class
    //   968: dup
    //   969: iconst_0
    //   970: ldc_w 275
    //   973: aastore
    //   974: dup
    //   975: iconst_1
    //   976: ldc_w 395
    //   979: aastore
    //   980: invokevirtual 465	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   983: iconst_2
    //   984: anewarray 176	java/lang/Object
    //   987: dup
    //   988: iconst_0
    //   989: aload_0
    //   990: aastore
    //   991: dup
    //   992: iconst_1
    //   993: aload 8
    //   995: aastore
    //   996: invokevirtual 471	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   999: checkcast 473	com/tencent/tinker/entry/ApplicationLifeCycle
    //   1002: putfield 475	com/tencent/mm/app/MMApplicationLike:wrapper	Lcom/tencent/tinker/entry/ApplicationLifeCycle;
    //   1005: goto -84 -> 921
    //   1008: astore_1
    //   1009: ldc 8
    //   1011: aload_1
    //   1012: ldc_w 480
    //   1015: iconst_0
    //   1016: anewarray 176	java/lang/Object
    //   1019: invokestatic 205	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1022: new 482	java/lang/RuntimeException
    //   1025: dup
    //   1026: ldc_w 480
    //   1029: aload_1
    //   1030: invokespecial 485	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1033: astore_1
    //   1034: sipush 3233
    //   1037: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1040: aload_1
    //   1041: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1042	0	this	MMApplicationLike
    //   0	1042	1	paramContext	android.content.Context
    //   146	61	2	i	int
    //   144	6	3	j	int
    //   490	64	4	l1	long
    //   547	179	6	l2	long
    //   24	970	8	localObject1	Object
    //   139	699	9	localObject2	Object
    //   156	38	10	localObject3	Object
    //   218	5	10	localIllegalAccessException	java.lang.IllegalAccessException
    //   321	386	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   158	203	218	java/lang/IllegalAccessException
    //   848	921	1008	java/lang/Exception
    //   921	931	1008	java/lang/Exception
    //   938	1005	1008	java/lang/Exception
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(3236);
    ab.d("MicroMsg.MMApplication", "configuration changed");
    super.onConfigurationChanged(paramConfiguration);
    if (this.wrapper != null) {
      this.wrapper.onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(3236);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(3234);
    if (this.wrapper != null) {
      this.wrapper.onCreate();
    }
    AppMethodBeat.o(3234);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(3238);
    super.onLowMemory();
    if (this.wrapper != null) {
      this.wrapper.onLowMemory();
    }
    AppMethodBeat.o(3238);
  }
  
  public void onTerminate()
  {
    AppMethodBeat.i(3235);
    super.onTerminate();
    if (this.wrapper != null) {
      this.wrapper.onTerminate();
    }
    AppMethodBeat.o(3235);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(3239);
    super.onTrimMemory(paramInt);
    if (this.wrapper != null) {
      this.wrapper.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(3239);
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