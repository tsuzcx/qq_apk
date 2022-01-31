package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;

public final class e
{
  private static boolean isSoLoaded = false;
  
  public static boolean aSK()
  {
    return (c.aSB()) && (aSZ()) && (isSoLoaded);
  }
  
  public static String aSU()
  {
    return m.bKU();
  }
  
  public static void aSV()
  {
    g.DQ();
    g.DP().Dz().c(ac.a.upv, Boolean.valueOf(true));
  }
  
  public static boolean aSW()
  {
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.upv, Boolean.valueOf(false));
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static void aSX()
  {
    g.DQ();
    g.DP().Dz().c(ac.a.upw, Boolean.valueOf(true));
  }
  
  public static boolean aSY()
  {
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.upy, Boolean.FALSE);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static boolean aSZ()
  {
    g.DQ();
    Object localObject = g.DP().Dz().get(ac.a.upz, Boolean.valueOf(false));
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public static boolean aTa()
  {
    return isSoLoaded;
  }
  
  public static boolean aTb()
  {
    y.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
    if (aSY())
    {
      y.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
      return false;
    }
    if (!c.aSB())
    {
      y.e("MicroMsg.FingerPrintUtil", "device is not support");
      return false;
    }
    if ((o.bVs().bVK()) || (o.bVs().bVO()))
    {
      y.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
      return false;
    }
    if (!o.bVs().bVR().bVH())
    {
      y.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
      return false;
    }
    new c();
    Object localObject;
    if (!c.aSD())
    {
      g.DQ();
      localObject = g.DP().Dz().get(ac.a.upw, Boolean.valueOf(false));
      if (localObject == null) {
        break label147;
      }
    }
    label147:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (!bool)
      {
        y.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
        return true;
      }
      return false;
    }
  }
  
  public static final String dj(Context paramContext)
  {
    return paramContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
  }
  
  /* Error */
  public static int dk(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: invokestatic 179	com/tencent/mm/plugin/fingerprint/b/e:dj	(Landroid/content/Context;)Ljava/lang/String;
    //   13: astore 10
    //   15: new 159	java/io/File
    //   18: dup
    //   19: aload 10
    //   21: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 11
    //   26: aload 11
    //   28: invokevirtual 185	java/io/File:exists	()Z
    //   31: ifne +179 -> 210
    //   34: iconst_1
    //   35: istore_1
    //   36: aconst_null
    //   37: astore_2
    //   38: iload_1
    //   39: ifeq +807 -> 846
    //   42: aload_0
    //   43: invokevirtual 189	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   46: ldc 191
    //   48: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore_0
    //   52: aload_0
    //   53: astore_2
    //   54: aload 9
    //   56: astore_3
    //   57: new 199	java/io/FileOutputStream
    //   60: dup
    //   61: aload 11
    //   63: invokespecial 202	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: astore 4
    //   68: sipush 1024
    //   71: newarray byte
    //   73: astore_2
    //   74: aload_0
    //   75: aload_2
    //   76: invokevirtual 208	java/io/InputStream:read	([B)I
    //   79: istore_1
    //   80: iload_1
    //   81: iconst_m1
    //   82: if_icmpeq +376 -> 458
    //   85: aload 4
    //   87: aload_2
    //   88: iconst_0
    //   89: iload_1
    //   90: invokevirtual 212	java/io/FileOutputStream:write	([BII)V
    //   93: goto -19 -> 74
    //   96: astore_2
    //   97: aload 4
    //   99: astore 5
    //   101: aload_2
    //   102: astore 4
    //   104: aload_0
    //   105: astore_2
    //   106: aload 5
    //   108: astore_3
    //   109: ldc 90
    //   111: aload 4
    //   113: ldc 214
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: astore_2
    //   124: aload 5
    //   126: astore_3
    //   127: ldc 90
    //   129: new 146	java/lang/StringBuilder
    //   132: dup
    //   133: ldc 220
    //   135: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload 4
    //   140: invokevirtual 224	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 227	java/io/InputStream:close	()V
    //   160: aload 5
    //   162: ifnull +679 -> 841
    //   165: aload 5
    //   167: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   170: iconst_m1
    //   171: istore_1
    //   172: invokestatic 234	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   175: new 146	java/lang/StringBuilder
    //   178: dup
    //   179: ldc 236
    //   181: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload 10
    //   186: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokevirtual 240	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   195: invokevirtual 246	java/lang/Process:waitFor	()I
    //   198: ifne +559 -> 757
    //   201: ldc 90
    //   203: ldc 248
    //   205: invokestatic 98	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iload_1
    //   209: ireturn
    //   210: aload 11
    //   212: invokestatic 254	com/tencent/mm/a/g:m	(Ljava/io/File;)Ljava/lang/String;
    //   215: astore 12
    //   217: ldc 214
    //   219: astore 5
    //   221: aload_0
    //   222: invokevirtual 189	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   225: ldc 191
    //   227: invokevirtual 197	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   230: astore_2
    //   231: aload 5
    //   233: astore_3
    //   234: aload_2
    //   235: ifnull +17 -> 252
    //   238: aload_2
    //   239: astore_3
    //   240: aload_2
    //   241: sipush 1024
    //   244: invokestatic 258	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   247: astore 4
    //   249: aload 4
    //   251: astore_3
    //   252: aload_3
    //   253: astore 6
    //   255: aload_2
    //   256: astore 4
    //   258: aload_2
    //   259: ifnull +13 -> 272
    //   262: aload_2
    //   263: invokevirtual 227	java/io/InputStream:close	()V
    //   266: aload_2
    //   267: astore 4
    //   269: aload_3
    //   270: astore 6
    //   272: aload 12
    //   274: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   277: ifne +149 -> 426
    //   280: aload 6
    //   282: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifne +141 -> 426
    //   288: aload 12
    //   290: aload 6
    //   292: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +131 -> 426
    //   298: iconst_0
    //   299: istore_1
    //   300: aload 4
    //   302: astore_2
    //   303: goto -265 -> 38
    //   306: astore 4
    //   308: ldc 90
    //   310: aload 4
    //   312: ldc 214
    //   314: iconst_0
    //   315: anewarray 4	java/lang/Object
    //   318: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload_3
    //   322: astore 6
    //   324: aload_2
    //   325: astore 4
    //   327: goto -55 -> 272
    //   330: astore 4
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_2
    //   335: astore_3
    //   336: ldc 90
    //   338: aload 4
    //   340: ldc 214
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload 5
    //   351: astore 6
    //   353: aload_2
    //   354: astore 4
    //   356: aload_2
    //   357: ifnull -85 -> 272
    //   360: aload_2
    //   361: invokevirtual 227	java/io/InputStream:close	()V
    //   364: aload 5
    //   366: astore 6
    //   368: aload_2
    //   369: astore 4
    //   371: goto -99 -> 272
    //   374: astore_3
    //   375: ldc 90
    //   377: aload_3
    //   378: ldc 214
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload 5
    //   389: astore 6
    //   391: aload_2
    //   392: astore 4
    //   394: goto -122 -> 272
    //   397: astore_0
    //   398: aconst_null
    //   399: astore_3
    //   400: aload_3
    //   401: ifnull +7 -> 408
    //   404: aload_3
    //   405: invokevirtual 227	java/io/InputStream:close	()V
    //   408: aload_0
    //   409: athrow
    //   410: astore_2
    //   411: ldc 90
    //   413: aload_2
    //   414: ldc 214
    //   416: iconst_0
    //   417: anewarray 4	java/lang/Object
    //   420: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -15 -> 408
    //   426: aload 12
    //   428: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   431: ifne +19 -> 450
    //   434: aload 6
    //   436: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifeq +11 -> 450
    //   442: iconst_0
    //   443: istore_1
    //   444: aload 4
    //   446: astore_2
    //   447: goto -409 -> 38
    //   450: iconst_1
    //   451: istore_1
    //   452: aload 4
    //   454: astore_2
    //   455: goto -417 -> 38
    //   458: aload 4
    //   460: invokevirtual 273	java/io/FileOutputStream:flush	()V
    //   463: aload_0
    //   464: ifnull +7 -> 471
    //   467: aload_0
    //   468: invokevirtual 227	java/io/InputStream:close	()V
    //   471: aload 4
    //   473: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   476: iconst_0
    //   477: istore_1
    //   478: goto -306 -> 172
    //   481: astore_0
    //   482: ldc 90
    //   484: aload_0
    //   485: ldc 214
    //   487: iconst_0
    //   488: anewarray 4	java/lang/Object
    //   491: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   494: ldc 90
    //   496: new 146	java/lang/StringBuilder
    //   499: dup
    //   500: ldc_w 275
    //   503: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   506: aload_0
    //   507: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   510: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: goto -48 -> 471
    //   522: astore_0
    //   523: ldc 90
    //   525: aload_0
    //   526: ldc 214
    //   528: iconst_0
    //   529: anewarray 4	java/lang/Object
    //   532: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: ldc 90
    //   537: new 146	java/lang/StringBuilder
    //   540: dup
    //   541: ldc_w 278
    //   544: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   547: aload_0
    //   548: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   551: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: iconst_0
    //   561: istore_1
    //   562: goto -390 -> 172
    //   565: astore_0
    //   566: ldc 90
    //   568: aload_0
    //   569: ldc 214
    //   571: iconst_0
    //   572: anewarray 4	java/lang/Object
    //   575: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: ldc 90
    //   580: new 146	java/lang/StringBuilder
    //   583: dup
    //   584: ldc_w 275
    //   587: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   590: aload_0
    //   591: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: goto -443 -> 160
    //   606: astore_0
    //   607: ldc 90
    //   609: aload_0
    //   610: ldc 214
    //   612: iconst_0
    //   613: anewarray 4	java/lang/Object
    //   616: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   619: ldc 90
    //   621: new 146	java/lang/StringBuilder
    //   624: dup
    //   625: ldc_w 278
    //   628: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   631: aload_0
    //   632: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   635: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: iconst_m1
    //   645: istore_1
    //   646: goto -474 -> 172
    //   649: astore 4
    //   651: aload_2
    //   652: astore_0
    //   653: aload 8
    //   655: astore_3
    //   656: aload_0
    //   657: ifnull +7 -> 664
    //   660: aload_0
    //   661: invokevirtual 227	java/io/InputStream:close	()V
    //   664: aload_3
    //   665: ifnull +7 -> 672
    //   668: aload_3
    //   669: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   672: aload 4
    //   674: athrow
    //   675: astore_0
    //   676: ldc 90
    //   678: aload_0
    //   679: ldc 214
    //   681: iconst_0
    //   682: anewarray 4	java/lang/Object
    //   685: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: ldc 90
    //   690: new 146	java/lang/StringBuilder
    //   693: dup
    //   694: ldc_w 275
    //   697: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   700: aload_0
    //   701: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   704: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: goto -49 -> 664
    //   716: astore_0
    //   717: ldc 90
    //   719: aload_0
    //   720: ldc 214
    //   722: iconst_0
    //   723: anewarray 4	java/lang/Object
    //   726: invokestatic 218	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   729: ldc 90
    //   731: new 146	java/lang/StringBuilder
    //   734: dup
    //   735: ldc_w 278
    //   738: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   741: aload_0
    //   742: invokevirtual 276	java/io/IOException:getMessage	()Ljava/lang/String;
    //   745: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   754: goto -82 -> 672
    //   757: ldc 90
    //   759: ldc_w 280
    //   762: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   765: iload_1
    //   766: ireturn
    //   767: astore_0
    //   768: ldc 90
    //   770: new 146	java/lang/StringBuilder
    //   773: dup
    //   774: ldc_w 282
    //   777: invokespecial 221	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   780: aload_0
    //   781: invokevirtual 224	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   784: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 98	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: iload_1
    //   794: ireturn
    //   795: astore 4
    //   797: aload_2
    //   798: astore_0
    //   799: goto -143 -> 656
    //   802: astore_2
    //   803: aload 4
    //   805: astore_3
    //   806: aload_2
    //   807: astore 4
    //   809: goto -153 -> 656
    //   812: astore 4
    //   814: aload_2
    //   815: astore_0
    //   816: aload 7
    //   818: astore 5
    //   820: goto -716 -> 104
    //   823: astore 4
    //   825: aload 7
    //   827: astore 5
    //   829: goto -725 -> 104
    //   832: astore_0
    //   833: goto -433 -> 400
    //   836: astore 4
    //   838: goto -504 -> 334
    //   841: iconst_m1
    //   842: istore_1
    //   843: goto -671 -> 172
    //   846: iconst_0
    //   847: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	848	0	paramContext	Context
    //   35	808	1	i	int
    //   37	51	2	localObject1	Object
    //   96	6	2	localException1	java.lang.Exception
    //   105	287	2	localObject2	Object
    //   410	4	2	localIOException1	java.io.IOException
    //   446	352	2	localObject3	Object
    //   802	13	2	localObject4	Object
    //   56	280	3	localObject5	Object
    //   374	4	3	localIOException2	java.io.IOException
    //   399	407	3	localObject6	Object
    //   66	235	4	localObject7	Object
    //   306	5	4	localIOException3	java.io.IOException
    //   325	1	4	localObject8	Object
    //   330	9	4	localIOException4	java.io.IOException
    //   354	118	4	localObject9	Object
    //   649	24	4	localObject10	Object
    //   795	9	4	localObject11	Object
    //   807	1	4	localObject12	Object
    //   812	1	4	localException2	java.lang.Exception
    //   823	1	4	localException3	java.lang.Exception
    //   836	1	4	localIOException5	java.io.IOException
    //   99	729	5	localObject13	Object
    //   253	182	6	localObject14	Object
    //   7	819	7	localObject15	Object
    //   1	653	8	localObject16	Object
    //   4	51	9	localObject17	Object
    //   13	172	10	str1	String
    //   24	187	11	localFile	File
    //   215	212	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   68	74	96	java/lang/Exception
    //   74	80	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
    //   458	463	96	java/lang/Exception
    //   262	266	306	java/io/IOException
    //   221	231	330	java/io/IOException
    //   360	364	374	java/io/IOException
    //   221	231	397	finally
    //   404	408	410	java/io/IOException
    //   467	471	481	java/io/IOException
    //   471	476	522	java/io/IOException
    //   156	160	565	java/io/IOException
    //   165	170	606	java/io/IOException
    //   42	52	649	finally
    //   660	664	675	java/io/IOException
    //   668	672	716	java/io/IOException
    //   172	208	767	java/lang/Exception
    //   757	765	767	java/lang/Exception
    //   57	68	795	finally
    //   109	122	795	finally
    //   127	152	795	finally
    //   68	74	802	finally
    //   74	80	802	finally
    //   85	93	802	finally
    //   458	463	802	finally
    //   42	52	812	java/lang/Exception
    //   57	68	823	java/lang/Exception
    //   240	249	832	finally
    //   336	349	832	finally
    //   240	249	836	java/io/IOException
  }
  
  public static String getUserId()
  {
    String str = com.tencent.mm.wallet_core.ui.e.getUsername();
    return ad.bB(ad.bB(str) + ad.bB(q.zg()));
  }
  
  public static void gh(boolean paramBoolean)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.upy, Boolean.valueOf(paramBoolean));
  }
  
  public static void gi(boolean paramBoolean)
  {
    g.DQ();
    g.DP().Dz().c(ac.a.upz, Boolean.valueOf(paramBoolean));
  }
  
  public static void gj(boolean paramBoolean)
  {
    isSoLoaded = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.e
 * JD-Core Version:    0.7.0.1
 */