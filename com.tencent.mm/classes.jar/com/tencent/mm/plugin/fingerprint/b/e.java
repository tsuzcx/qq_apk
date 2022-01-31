package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

public final class e
{
  private static boolean isSoLoaded = false;
  
  public static boolean bzf()
  {
    AppMethodBeat.i(41467);
    if ((c.byX()) && (bzu()) && (isSoLoaded))
    {
      AppMethodBeat.o(41467);
      return true;
    }
    AppMethodBeat.o(41467);
    return false;
  }
  
  public static String bzp()
  {
    AppMethodBeat.i(41459);
    String str = m.cyf();
    AppMethodBeat.o(41459);
    return str;
  }
  
  public static void bzq()
  {
    AppMethodBeat.i(41460);
    g.RM();
    g.RL().Ru().set(ac.a.yzr, Boolean.TRUE);
    AppMethodBeat.o(41460);
  }
  
  public static boolean bzr()
  {
    AppMethodBeat.i(41461);
    g.RM();
    Object localObject = g.RL().Ru().get(ac.a.yzr, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(41461);
      return bool;
    }
  }
  
  public static void bzs()
  {
    AppMethodBeat.i(41462);
    g.RM();
    g.RL().Ru().set(ac.a.yzs, Boolean.TRUE);
    AppMethodBeat.o(41462);
  }
  
  public static boolean bzt()
  {
    AppMethodBeat.i(41464);
    g.RM();
    Object localObject = g.RL().Ru().get(ac.a.yzu, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(41464);
      return bool;
    }
  }
  
  public static boolean bzu()
  {
    AppMethodBeat.i(41466);
    g.RM();
    Object localObject = g.RL().Ru().get(ac.a.yzv, Boolean.FALSE);
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      AppMethodBeat.o(41466);
      return bool;
    }
  }
  
  public static boolean bzv()
  {
    return isSoLoaded;
  }
  
  public static boolean bzw()
  {
    AppMethodBeat.i(41468);
    ab.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
    if (bzt())
    {
      ab.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
      AppMethodBeat.o(41468);
      return false;
    }
    if (!c.byX())
    {
      ab.e("MicroMsg.FingerPrintUtil", "device is not support");
      AppMethodBeat.o(41468);
      return false;
    }
    if ((t.cTN().cUn()) || (t.cTN().cUm()))
    {
      ab.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
      AppMethodBeat.o(41468);
      return false;
    }
    if (!t.cTN().cUt().cUd())
    {
      ab.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
      AppMethodBeat.o(41468);
      return false;
    }
    new c();
    Object localObject;
    if (!c.byY())
    {
      g.RM();
      localObject = g.RL().Ru().get(ac.a.yzs, Boolean.FALSE);
      if (localObject == null) {
        break label181;
      }
    }
    label181:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (!bool)
      {
        ab.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
        AppMethodBeat.o(41468);
        return true;
      }
      AppMethodBeat.o(41468);
      return false;
    }
  }
  
  public static final String dU(Context paramContext)
  {
    AppMethodBeat.i(41469);
    paramContext = paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    AppMethodBeat.o(41469);
    return paramContext;
  }
  
  /* Error */
  public static int dV(Context paramContext)
  {
    // Byte code:
    //   0: ldc 194
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: invokestatic 196	com/tencent/mm/plugin/fingerprint/b/e:dU	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 7
    //   15: new 175	java/io/File
    //   18: dup
    //   19: aload 7
    //   21: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 202	java/io/File:exists	()Z
    //   31: ifne +199 -> 230
    //   34: iconst_1
    //   35: istore_1
    //   36: aconst_null
    //   37: astore_2
    //   38: iload_1
    //   39: ifeq +804 -> 843
    //   42: aload_2
    //   43: astore_3
    //   44: aload_0
    //   45: invokevirtual 206	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc 208
    //   50: invokevirtual 214	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_0
    //   54: aload_0
    //   55: astore_3
    //   56: aload_0
    //   57: astore_2
    //   58: new 216	java/io/FileOutputStream
    //   61: dup
    //   62: aload 8
    //   64: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore 5
    //   69: aload 5
    //   71: astore_3
    //   72: aload_0
    //   73: astore_2
    //   74: sipush 1024
    //   77: newarray byte
    //   79: astore 4
    //   81: aload 5
    //   83: astore_3
    //   84: aload_0
    //   85: astore_2
    //   86: aload_0
    //   87: aload 4
    //   89: invokevirtual 225	java/io/InputStream:read	([B)I
    //   92: istore_1
    //   93: iload_1
    //   94: iconst_m1
    //   95: if_icmpeq +379 -> 474
    //   98: aload 5
    //   100: astore_3
    //   101: aload_0
    //   102: astore_2
    //   103: aload 5
    //   105: aload 4
    //   107: iconst_0
    //   108: iload_1
    //   109: invokevirtual 229	java/io/FileOutputStream:write	([BII)V
    //   112: goto -31 -> 81
    //   115: astore_2
    //   116: aload_0
    //   117: astore 4
    //   119: aload 5
    //   121: astore_0
    //   122: aload_2
    //   123: astore 5
    //   125: aload_0
    //   126: astore_3
    //   127: aload 4
    //   129: astore_2
    //   130: ldc 106
    //   132: aload 5
    //   134: ldc 231
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: astore_3
    //   145: aload 4
    //   147: astore_2
    //   148: ldc 106
    //   150: new 162	java/lang/StringBuilder
    //   153: dup
    //   154: ldc 237
    //   156: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload 5
    //   161: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 244	java/io/InputStream:close	()V
    //   183: aload_0
    //   184: ifnull +654 -> 838
    //   187: aload_0
    //   188: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   191: iconst_m1
    //   192: istore_1
    //   193: invokestatic 251	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   196: ldc 253
    //   198: aload 7
    //   200: invokestatic 259	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   203: invokevirtual 263	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokevirtual 267	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   209: invokevirtual 273	java/lang/Process:waitFor	()I
    //   212: ifne +572 -> 784
    //   215: ldc 106
    //   217: ldc_w 275
    //   220: invokestatic 113	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: ldc 194
    //   225: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: iload_1
    //   229: ireturn
    //   230: aload 8
    //   232: invokestatic 281	com/tencent/mm/a/g:r	(Ljava/io/File;)Ljava/lang/String;
    //   235: astore 9
    //   237: ldc 231
    //   239: astore 5
    //   241: aload_0
    //   242: invokevirtual 206	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   245: ldc 208
    //   247: invokevirtual 214	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   250: astore 4
    //   252: aload 5
    //   254: astore_3
    //   255: aload 4
    //   257: ifnull +22 -> 279
    //   260: aload 4
    //   262: astore_3
    //   263: aload 4
    //   265: astore_2
    //   266: aload 4
    //   268: sipush 1024
    //   271: invokestatic 285	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   274: astore 6
    //   276: aload 6
    //   278: astore_3
    //   279: aload_3
    //   280: astore 6
    //   282: aload 4
    //   284: astore_2
    //   285: aload 4
    //   287: ifnull +14 -> 301
    //   290: aload 4
    //   292: invokevirtual 244	java/io/InputStream:close	()V
    //   295: aload 4
    //   297: astore_2
    //   298: aload_3
    //   299: astore 6
    //   301: aload 9
    //   303: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifne +142 -> 448
    //   309: aload 6
    //   311: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifne +134 -> 448
    //   317: aload 9
    //   319: aload 6
    //   321: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifeq +124 -> 448
    //   327: iconst_0
    //   328: istore_1
    //   329: goto -291 -> 38
    //   332: astore_2
    //   333: ldc 106
    //   335: aload_2
    //   336: ldc 231
    //   338: iconst_0
    //   339: anewarray 4	java/lang/Object
    //   342: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: aload_3
    //   346: astore 6
    //   348: aload 4
    //   350: astore_2
    //   351: goto -50 -> 301
    //   354: astore 4
    //   356: aload_3
    //   357: astore_2
    //   358: ldc 106
    //   360: aload 4
    //   362: ldc 231
    //   364: iconst_0
    //   365: anewarray 4	java/lang/Object
    //   368: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload 5
    //   373: astore 6
    //   375: aload_3
    //   376: astore_2
    //   377: aload_3
    //   378: ifnull -77 -> 301
    //   381: aload_3
    //   382: invokevirtual 244	java/io/InputStream:close	()V
    //   385: aload 5
    //   387: astore 6
    //   389: aload_3
    //   390: astore_2
    //   391: goto -90 -> 301
    //   394: astore_2
    //   395: ldc 106
    //   397: aload_2
    //   398: ldc 231
    //   400: iconst_0
    //   401: anewarray 4	java/lang/Object
    //   404: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: aload 5
    //   409: astore 6
    //   411: aload_3
    //   412: astore_2
    //   413: goto -112 -> 301
    //   416: astore_0
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 244	java/io/InputStream:close	()V
    //   425: ldc 194
    //   427: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: aload_0
    //   431: athrow
    //   432: astore_2
    //   433: ldc 106
    //   435: aload_2
    //   436: ldc 231
    //   438: iconst_0
    //   439: anewarray 4	java/lang/Object
    //   442: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: goto -20 -> 425
    //   448: aload 9
    //   450: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   453: ifne +16 -> 469
    //   456: aload 6
    //   458: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifeq +8 -> 469
    //   464: iconst_0
    //   465: istore_1
    //   466: goto -428 -> 38
    //   469: iconst_1
    //   470: istore_1
    //   471: goto -433 -> 38
    //   474: aload 5
    //   476: astore_3
    //   477: aload_0
    //   478: astore_2
    //   479: aload 5
    //   481: invokevirtual 298	java/io/FileOutputStream:flush	()V
    //   484: aload_0
    //   485: ifnull +7 -> 492
    //   488: aload_0
    //   489: invokevirtual 244	java/io/InputStream:close	()V
    //   492: aload 5
    //   494: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   497: iconst_0
    //   498: istore_1
    //   499: goto -306 -> 193
    //   502: astore_0
    //   503: ldc 106
    //   505: aload_0
    //   506: ldc 231
    //   508: iconst_0
    //   509: anewarray 4	java/lang/Object
    //   512: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: ldc 106
    //   517: new 162	java/lang/StringBuilder
    //   520: dup
    //   521: ldc_w 300
    //   524: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   527: aload_0
    //   528: invokevirtual 301	java/io/IOException:getMessage	()Ljava/lang/String;
    //   531: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: goto -48 -> 492
    //   543: astore_0
    //   544: ldc 106
    //   546: aload_0
    //   547: ldc 231
    //   549: iconst_0
    //   550: anewarray 4	java/lang/Object
    //   553: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: ldc 106
    //   558: new 162	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 303
    //   565: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload_0
    //   569: invokevirtual 301	java/io/IOException:getMessage	()Ljava/lang/String;
    //   572: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: iconst_0
    //   582: istore_1
    //   583: goto -390 -> 193
    //   586: astore_2
    //   587: ldc 106
    //   589: aload_2
    //   590: ldc 231
    //   592: iconst_0
    //   593: anewarray 4	java/lang/Object
    //   596: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   599: ldc 106
    //   601: new 162	java/lang/StringBuilder
    //   604: dup
    //   605: ldc_w 300
    //   608: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   611: aload_2
    //   612: invokevirtual 301	java/io/IOException:getMessage	()Ljava/lang/String;
    //   615: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: goto -441 -> 183
    //   627: astore_0
    //   628: ldc 106
    //   630: aload_0
    //   631: ldc 231
    //   633: iconst_0
    //   634: anewarray 4	java/lang/Object
    //   637: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   640: ldc 106
    //   642: new 162	java/lang/StringBuilder
    //   645: dup
    //   646: ldc_w 303
    //   649: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   652: aload_0
    //   653: invokevirtual 301	java/io/IOException:getMessage	()Ljava/lang/String;
    //   656: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: iconst_m1
    //   666: istore_1
    //   667: goto -474 -> 193
    //   670: astore_0
    //   671: aconst_null
    //   672: astore 4
    //   674: aload_3
    //   675: astore_2
    //   676: aload 4
    //   678: astore_3
    //   679: aload_2
    //   680: ifnull +7 -> 687
    //   683: aload_2
    //   684: invokevirtual 244	java/io/InputStream:close	()V
    //   687: aload_3
    //   688: ifnull +7 -> 695
    //   691: aload_3
    //   692: invokevirtual 245	java/io/FileOutputStream:close	()V
    //   695: ldc 194
    //   697: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   700: aload_0
    //   701: athrow
    //   702: astore_2
    //   703: ldc 106
    //   705: aload_2
    //   706: ldc 231
    //   708: iconst_0
    //   709: anewarray 4	java/lang/Object
    //   712: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   715: ldc 106
    //   717: new 162	java/lang/StringBuilder
    //   720: dup
    //   721: ldc_w 300
    //   724: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   727: aload_2
    //   728: invokevirtual 301	java/io/IOException:getMessage	()Ljava/lang/String;
    //   731: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   740: goto -53 -> 687
    //   743: astore_2
    //   744: ldc 106
    //   746: aload_2
    //   747: ldc 231
    //   749: iconst_0
    //   750: anewarray 4	java/lang/Object
    //   753: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: ldc 106
    //   758: new 162	java/lang/StringBuilder
    //   761: dup
    //   762: ldc_w 303
    //   765: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   768: aload_2
    //   769: invokevirtual 301	java/io/IOException:getMessage	()Ljava/lang/String;
    //   772: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: goto -86 -> 695
    //   784: ldc 106
    //   786: ldc_w 305
    //   789: invokestatic 120	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: goto -569 -> 223
    //   795: astore_0
    //   796: ldc 106
    //   798: new 162	java/lang/StringBuilder
    //   801: dup
    //   802: ldc_w 307
    //   805: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   808: aload_0
    //   809: invokevirtual 241	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   812: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 113	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: goto -598 -> 223
    //   824: astore_0
    //   825: goto -146 -> 679
    //   828: astore 5
    //   830: aconst_null
    //   831: astore_0
    //   832: aload_2
    //   833: astore 4
    //   835: goto -710 -> 125
    //   838: iconst_m1
    //   839: istore_1
    //   840: goto -647 -> 193
    //   843: iconst_0
    //   844: istore_1
    //   845: goto -622 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	848	0	paramContext	Context
    //   35	810	1	i	int
    //   6	97	2	localContext1	Context
    //   115	8	2	localException1	java.lang.Exception
    //   129	169	2	localObject1	Object
    //   332	4	2	localIOException1	java.io.IOException
    //   350	41	2	localObject2	Object
    //   394	4	2	localIOException2	java.io.IOException
    //   412	10	2	localObject3	Object
    //   432	4	2	localIOException3	java.io.IOException
    //   478	1	2	localContext2	Context
    //   586	26	2	localIOException4	java.io.IOException
    //   675	9	2	localObject4	Object
    //   702	26	2	localIOException5	java.io.IOException
    //   743	90	2	localIOException6	java.io.IOException
    //   8	684	3	localObject5	Object
    //   79	270	4	localObject6	Object
    //   354	7	4	localIOException7	java.io.IOException
    //   672	162	4	localIOException8	java.io.IOException
    //   67	426	5	localObject7	Object
    //   828	1	5	localException2	java.lang.Exception
    //   274	183	6	localObject8	Object
    //   13	186	7	str1	String
    //   24	207	8	localFile	File
    //   235	214	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   74	81	115	java/lang/Exception
    //   86	93	115	java/lang/Exception
    //   103	112	115	java/lang/Exception
    //   479	484	115	java/lang/Exception
    //   290	295	332	java/io/IOException
    //   241	252	354	java/io/IOException
    //   266	276	354	java/io/IOException
    //   381	385	394	java/io/IOException
    //   241	252	416	finally
    //   266	276	416	finally
    //   358	371	416	finally
    //   421	425	432	java/io/IOException
    //   488	492	502	java/io/IOException
    //   492	497	543	java/io/IOException
    //   178	183	586	java/io/IOException
    //   187	191	627	java/io/IOException
    //   44	54	670	finally
    //   58	69	670	finally
    //   683	687	702	java/io/IOException
    //   691	695	743	java/io/IOException
    //   193	223	795	java/lang/Exception
    //   784	792	795	java/lang/Exception
    //   74	81	824	finally
    //   86	93	824	finally
    //   103	112	824	finally
    //   130	143	824	finally
    //   148	173	824	finally
    //   479	484	824	finally
    //   44	54	828	java/lang/Exception
    //   58	69	828	java/lang/Exception
  }
  
  public static String getUserId()
  {
    AppMethodBeat.i(41458);
    String str = com.tencent.mm.wallet_core.ui.e.getUsername();
    str = ag.cE(ag.cE(str) + ag.cE(q.LK()));
    AppMethodBeat.o(41458);
    return str;
  }
  
  public static void hJ(boolean paramBoolean)
  {
    AppMethodBeat.i(41463);
    g.RM();
    g.RL().Ru().set(ac.a.yzu, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(41463);
  }
  
  public static void hK(boolean paramBoolean)
  {
    AppMethodBeat.i(41465);
    g.RM();
    g.RL().Ru().set(ac.a.yzv, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(41465);
  }
  
  public static void hL(boolean paramBoolean)
  {
    isSoLoaded = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e
 * JD-Core Version:    0.7.0.1
 */