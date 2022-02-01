package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.s;
import com.tencent.mm.am.z;
import com.tencent.mm.app.q.a;
import com.tencent.mm.b.g;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.ez;
import com.tencent.mm.protocal.protobuf.fqh;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static q.a appForegroundListener;
  private static Map<String, e> vrO;
  private static Intent vrP;
  public static final Set<Long> vrQ;
  private static int vrR;
  private static boolean vrS;
  private static long vrT;
  private static boolean vrU;
  private static final String[] vrV;
  private static final com.tencent.mm.b.f<String, Long> vrW;
  
  static
  {
    AppMethodBeat.i(22242);
    vrO = new HashMap();
    vrQ = new HashSet();
    vrR = -1;
    appForegroundListener = null;
    vrS = false;
    vrT = 0L;
    vrU = true;
    vrV = new String[] { "sdk_openAppProfile", "sdk_openFeedback", "sdk_openGrowthCare", "sdk_navigateToMiniProgram" };
    vrW = new com.tencent.mm.b.h(50);
    AppMethodBeat.o(22242);
  }
  
  public static void GG(int paramInt)
  {
    AppMethodBeat.i(22238);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1194L, paramInt, 1L, false);
    AppMethodBeat.o(22238);
  }
  
  public static void GH(int paramInt)
  {
    AppMethodBeat.i(269061);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1674L, paramInt, 1L, false);
    AppMethodBeat.o(269061);
  }
  
  static void GI(int paramInt)
  {
    AppMethodBeat.i(269079);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1405, paramInt);
    AppMethodBeat.o(269079);
  }
  
  public static MatrixCursor a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(22235);
    paramContext = a(paramContext, paramArrayOfString1, paramArrayOfString2, paramBoolean1, paramBoolean2, paramBoolean3, false);
    AppMethodBeat.o(22235);
    return paramContext;
  }
  
  /* Error */
  public static MatrixCursor a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    // Byte code:
    //   0: ldc 176
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 178
    //   11: ldc 180
    //   13: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 176
    //   18: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_2
    //   24: ifnull +1535 -> 1559
    //   27: aload_2
    //   28: arraylength
    //   29: ifle +1530 -> 1559
    //   32: aload_2
    //   33: iconst_0
    //   34: aaload
    //   35: astore 22
    //   37: aload_0
    //   38: aload_2
    //   39: iconst_0
    //   40: aaload
    //   41: invokestatic 192	com/tencent/mm/pluginsdk/model/app/u:cG	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   44: iconst_0
    //   45: aaload
    //   46: invokevirtual 198	android/content/pm/Signature:toByteArray	()[B
    //   49: invokestatic 204	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   52: astore 21
    //   54: ldc 178
    //   56: ldc 206
    //   58: iconst_2
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload 22
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload 21
    //   71: aastore
    //   72: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: ifnull +9 -> 85
    //   79: aload_1
    //   80: arraylength
    //   81: iconst_2
    //   82: if_icmpge +17 -> 99
    //   85: ldc 178
    //   87: ldc 211
    //   89: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: ldc 176
    //   94: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aconst_null
    //   98: areturn
    //   99: getstatic 217	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:GlobalAppbrand	Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries;
    //   102: aload_0
    //   103: invokevirtual 221	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:checkAvailable	(Landroid/content/Context;)Z
    //   106: ifne +10 -> 116
    //   109: ldc 176
    //   111: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aconst_null
    //   115: areturn
    //   116: aload_1
    //   117: iconst_0
    //   118: aaload
    //   119: astore 25
    //   121: iload 6
    //   123: ifne +387 -> 510
    //   126: aload_1
    //   127: iconst_1
    //   128: aaload
    //   129: astore 23
    //   131: ldc 223
    //   133: astore 16
    //   135: iconst_0
    //   136: istore 8
    //   138: ldc 223
    //   140: astore 15
    //   142: iload 5
    //   144: ifeq +373 -> 517
    //   147: iconst_3
    //   148: istore 7
    //   150: ldc 223
    //   152: astore_2
    //   153: ldc 223
    //   155: astore 14
    //   157: ldc 223
    //   159: astore 24
    //   161: aload_1
    //   162: arraylength
    //   163: iconst_2
    //   164: if_icmple +8 -> 172
    //   167: aload_1
    //   168: iconst_2
    //   169: aaload
    //   170: astore 16
    //   172: aload_1
    //   173: arraylength
    //   174: iconst_3
    //   175: if_icmple +12 -> 187
    //   178: aload_1
    //   179: iconst_3
    //   180: aaload
    //   181: iconst_0
    //   182: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   185: istore 8
    //   187: aload_1
    //   188: arraylength
    //   189: iconst_4
    //   190: if_icmple +1359 -> 1549
    //   193: aload_1
    //   194: iconst_4
    //   195: aaload
    //   196: astore_1
    //   197: aload 15
    //   199: astore 17
    //   201: aload 15
    //   203: astore 18
    //   205: aload_1
    //   206: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   209: ifne +314 -> 523
    //   212: aload 15
    //   214: astore 17
    //   216: aload 15
    //   218: astore 18
    //   220: ldc 178
    //   222: ldc 235
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_1
    //   231: aastore
    //   232: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload 15
    //   237: astore 17
    //   239: aload 15
    //   241: astore 18
    //   243: new 240	com/tencent/mm/ad/i
    //   246: dup
    //   247: aload_1
    //   248: ldc 242
    //   250: invokestatic 248	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   253: invokespecial 251	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   256: astore 20
    //   258: aload 15
    //   260: astore 17
    //   262: aload 15
    //   264: astore 18
    //   266: aload 20
    //   268: ldc 253
    //   270: invokevirtual 257	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   273: ldc 242
    //   275: invokestatic 262	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_1
    //   279: aload_1
    //   280: astore 17
    //   282: aload_1
    //   283: astore 18
    //   285: aload 20
    //   287: ldc_w 264
    //   290: invokevirtual 257	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   293: iconst_0
    //   294: invokestatic 229	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   297: istore 9
    //   299: iload 9
    //   301: istore 7
    //   303: aload 14
    //   305: astore 18
    //   307: aload_2
    //   308: astore 15
    //   310: aload 14
    //   312: astore 19
    //   314: aload_2
    //   315: astore 17
    //   317: aload 20
    //   319: ldc_w 266
    //   322: invokevirtual 257	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   325: astore_2
    //   326: aload 14
    //   328: astore 18
    //   330: aload_2
    //   331: astore 15
    //   333: aload 14
    //   335: astore 19
    //   337: aload_2
    //   338: astore 17
    //   340: aload 20
    //   342: ldc_w 268
    //   345: invokevirtual 257	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: astore 14
    //   350: aload 14
    //   352: astore 18
    //   354: aload_2
    //   355: astore 15
    //   357: aload 14
    //   359: astore 19
    //   361: aload_2
    //   362: astore 17
    //   364: aload 20
    //   366: ldc_w 270
    //   369: invokevirtual 257	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   372: astore 20
    //   374: ldc 178
    //   376: ldc_w 272
    //   379: iconst_5
    //   380: anewarray 4	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: aload_1
    //   386: aastore
    //   387: dup
    //   388: iconst_1
    //   389: iload 7
    //   391: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: dup
    //   396: iconst_2
    //   397: aload_2
    //   398: aastore
    //   399: dup
    //   400: iconst_3
    //   401: aload 14
    //   403: aastore
    //   404: dup
    //   405: iconst_4
    //   406: aload 20
    //   408: aastore
    //   409: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: aload_1
    //   413: astore 15
    //   415: aload 20
    //   417: astore_1
    //   418: aload 16
    //   420: astore 17
    //   422: aload 16
    //   424: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   427: ifne +10 -> 437
    //   430: aload 16
    //   432: invokestatic 280	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   435: astore 17
    //   437: ldc 178
    //   439: ldc_w 282
    //   442: iconst_4
    //   443: anewarray 4	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: aload 25
    //   450: aastore
    //   451: dup
    //   452: iconst_1
    //   453: aload 23
    //   455: aastore
    //   456: dup
    //   457: iconst_2
    //   458: aload 17
    //   460: aastore
    //   461: dup
    //   462: iconst_3
    //   463: iload 8
    //   465: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   472: iload 6
    //   474: ifeq +164 -> 638
    //   477: ldc_w 284
    //   480: aload 25
    //   482: aload 23
    //   484: aload 17
    //   486: ldc2_w 285
    //   489: invokestatic 289	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z
    //   492: ifne +183 -> 675
    //   495: ldc 178
    //   497: ldc_w 291
    //   500: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: ldc 176
    //   505: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   508: aconst_null
    //   509: areturn
    //   510: ldc 223
    //   512: astore 23
    //   514: goto -383 -> 131
    //   517: iconst_0
    //   518: istore 7
    //   520: goto -370 -> 150
    //   523: aload 15
    //   525: astore 17
    //   527: aload 15
    //   529: astore 18
    //   531: ldc 178
    //   533: ldc_w 295
    //   536: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: ldc 223
    //   541: astore_1
    //   542: ldc 223
    //   544: astore 14
    //   546: goto -128 -> 418
    //   549: astore 19
    //   551: aload 17
    //   553: astore 15
    //   555: aload 24
    //   557: astore 18
    //   559: ldc 178
    //   561: aload 19
    //   563: ldc 223
    //   565: iconst_0
    //   566: anewarray 4	java/lang/Object
    //   569: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: aload 18
    //   574: astore_1
    //   575: goto -157 -> 418
    //   578: astore_1
    //   579: aload 18
    //   581: astore 15
    //   583: aload_1
    //   584: astore 18
    //   586: aload 24
    //   588: astore 17
    //   590: ldc 178
    //   592: aload 18
    //   594: ldc 223
    //   596: iconst_0
    //   597: anewarray 4	java/lang/Object
    //   600: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: aload 17
    //   605: astore_1
    //   606: goto -188 -> 418
    //   609: astore 16
    //   611: ldc 178
    //   613: ldc_w 301
    //   616: iconst_1
    //   617: anewarray 4	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: aload 16
    //   624: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   627: aastore
    //   628: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: ldc 223
    //   633: astore 17
    //   635: goto -198 -> 437
    //   638: iload_3
    //   639: ifeq +36 -> 675
    //   642: ldc_w 309
    //   645: aload 25
    //   647: aload 23
    //   649: aload 17
    //   651: ldc2_w 310
    //   654: invokestatic 289	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Z
    //   657: ifne +18 -> 675
    //   660: ldc 178
    //   662: ldc_w 313
    //   665: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: ldc 176
    //   670: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: aconst_null
    //   674: areturn
    //   675: iload 6
    //   677: ifne +99 -> 776
    //   680: ldc_w 315
    //   683: bipush 8
    //   685: anewarray 4	java/lang/Object
    //   688: dup
    //   689: iconst_0
    //   690: aload 25
    //   692: aastore
    //   693: dup
    //   694: iconst_1
    //   695: aload 23
    //   697: aastore
    //   698: dup
    //   699: iconst_2
    //   700: aload 17
    //   702: aastore
    //   703: dup
    //   704: iconst_3
    //   705: aload 15
    //   707: aastore
    //   708: dup
    //   709: iconst_4
    //   710: iload 7
    //   712: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   715: aastore
    //   716: dup
    //   717: iconst_5
    //   718: aload_2
    //   719: aastore
    //   720: dup
    //   721: bipush 6
    //   723: aload 14
    //   725: aastore
    //   726: dup
    //   727: bipush 7
    //   729: aload_1
    //   730: aastore
    //   731: invokestatic 319	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   734: astore_1
    //   735: ldc 178
    //   737: ldc_w 321
    //   740: iconst_1
    //   741: anewarray 4	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload_1
    //   747: aastore
    //   748: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   751: iload_3
    //   752: ifeq +43 -> 795
    //   755: aload_1
    //   756: aload 22
    //   758: aload 21
    //   760: iload 8
    //   762: iconst_1
    //   763: iload 4
    //   765: invokestatic 324	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   768: astore_0
    //   769: ldc 176
    //   771: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   774: aload_0
    //   775: areturn
    //   776: ldc_w 326
    //   779: iconst_1
    //   780: anewarray 4	java/lang/Object
    //   783: dup
    //   784: iconst_0
    //   785: aload 25
    //   787: aastore
    //   788: invokestatic 319	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   791: astore_1
    //   792: goto -57 -> 735
    //   795: iload 6
    //   797: ifeq +265 -> 1062
    //   800: aload 22
    //   802: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   805: ifne +11 -> 816
    //   808: aload 21
    //   810: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   813: ifeq +18 -> 831
    //   816: ldc 178
    //   818: ldc_w 328
    //   821: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: ldc 176
    //   826: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   829: aconst_null
    //   830: areturn
    //   831: new 330	java/util/LinkedList
    //   834: dup
    //   835: invokespecial 331	java/util/LinkedList:<init>	()V
    //   838: astore_0
    //   839: new 333	com/tencent/mm/protocal/protobuf/ez
    //   842: dup
    //   843: invokespecial 334	com/tencent/mm/protocal/protobuf/ez:<init>	()V
    //   846: astore_2
    //   847: ldc 178
    //   849: ldc_w 336
    //   852: iconst_2
    //   853: anewarray 4	java/lang/Object
    //   856: dup
    //   857: iconst_0
    //   858: aload 22
    //   860: aastore
    //   861: dup
    //   862: iconst_1
    //   863: iconst_3
    //   864: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: aastore
    //   868: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   871: aload_2
    //   872: aload 22
    //   874: putfield 339	com/tencent/mm/protocal/protobuf/ez:xlr	Ljava/lang/String;
    //   877: aload_2
    //   878: aload 21
    //   880: putfield 342	com/tencent/mm/protocal/protobuf/ez:signature	Ljava/lang/String;
    //   883: aload_0
    //   884: aload_2
    //   885: invokevirtual 346	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   888: pop
    //   889: new 348	com/tencent/mm/am/c$a
    //   892: dup
    //   893: invokespecial 349	com/tencent/mm/am/c$a:<init>	()V
    //   896: astore_2
    //   897: aload_2
    //   898: new 351	com/tencent/mm/protocal/protobuf/fqh
    //   901: dup
    //   902: invokespecial 352	com/tencent/mm/protocal/protobuf/fqh:<init>	()V
    //   905: putfield 356	com/tencent/mm/am/c$a:otE	Lcom/tencent/mm/bx/a;
    //   908: aload_2
    //   909: new 358	com/tencent/mm/protocal/protobuf/fqi
    //   912: dup
    //   913: invokespecial 359	com/tencent/mm/protocal/protobuf/fqi:<init>	()V
    //   916: putfield 362	com/tencent/mm/am/c$a:otF	Lcom/tencent/mm/bx/a;
    //   919: aload_2
    //   920: ldc_w 364
    //   923: putfield 367	com/tencent/mm/am/c$a:uri	Ljava/lang/String;
    //   926: aload_2
    //   927: sipush 1200
    //   930: putfield 370	com/tencent/mm/am/c$a:funcId	I
    //   933: aload_2
    //   934: invokevirtual 374	com/tencent/mm/am/c$a:bEF	()Lcom/tencent/mm/am/c;
    //   937: astore_2
    //   938: aload_2
    //   939: getfield 380	com/tencent/mm/am/c:otB	Lcom/tencent/mm/am/c$b;
    //   942: invokestatic 385	com/tencent/mm/am/c$b:b	(Lcom/tencent/mm/am/c$b;)Lcom/tencent/mm/bx/a;
    //   945: checkcast 351	com/tencent/mm/protocal/protobuf/fqh
    //   948: astore 14
    //   950: aload 14
    //   952: new 387	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 388	java/lang/StringBuilder:<init>	()V
    //   959: aload_1
    //   960: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: ldc_w 394
    //   966: invokevirtual 392	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: invokevirtual 397	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   972: putfield 400	com/tencent/mm/protocal/protobuf/fqh:link	Ljava/lang/String;
    //   975: aload 14
    //   977: iconst_1
    //   978: putfield 403	com/tencent/mm/protocal/protobuf/fqh:scene	I
    //   981: aload 14
    //   983: aload_0
    //   984: putfield 407	com/tencent/mm/protocal/protobuf/fqh:abQd	Ljava/util/LinkedList;
    //   987: ldc 178
    //   989: ldc_w 409
    //   992: iconst_1
    //   993: anewarray 4	java/lang/Object
    //   996: dup
    //   997: iconst_0
    //   998: aload 14
    //   1000: getfield 400	com/tencent/mm/protocal/protobuf/fqh:link	Ljava/lang/String;
    //   1003: aastore
    //   1004: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: new 411	android/database/MatrixCursor
    //   1010: dup
    //   1011: iconst_4
    //   1012: anewarray 62	java/lang/String
    //   1015: dup
    //   1016: iconst_0
    //   1017: ldc_w 413
    //   1020: aastore
    //   1021: dup
    //   1022: iconst_1
    //   1023: ldc_w 415
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_2
    //   1029: ldc_w 417
    //   1032: aastore
    //   1033: dup
    //   1034: iconst_3
    //   1035: ldc_w 419
    //   1038: aastore
    //   1039: invokespecial 422	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   1042: astore_0
    //   1043: aload_2
    //   1044: new 424	com/tencent/mm/plugin/base/stub/f$3
    //   1047: dup
    //   1048: invokespecial 425	com/tencent/mm/plugin/base/stub/f$3:<init>	()V
    //   1051: invokestatic 430	com/tencent/mm/am/z:a	(Lcom/tencent/mm/am/c;Lcom/tencent/mm/am/z$a;)Lcom/tencent/mm/am/c;
    //   1054: pop
    //   1055: ldc 176
    //   1057: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1060: aload_0
    //   1061: areturn
    //   1062: aload_1
    //   1063: iconst_1
    //   1064: aload 22
    //   1066: aload 21
    //   1068: iload 8
    //   1070: invokestatic 434	com/tencent/mm/plugin/base/stub/f:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1073: astore_2
    //   1074: getstatic 45	com/tencent/mm/plugin/base/stub/f:vrO	Ljava/util/Map;
    //   1077: aload_2
    //   1078: invokeinterface 440 2 0
    //   1083: checkcast 442	com/tencent/mm/plugin/base/stub/e
    //   1086: astore 14
    //   1088: aload 14
    //   1090: ifnull +24 -> 1114
    //   1093: aload 14
    //   1095: astore_2
    //   1096: invokestatic 448	java/lang/System:currentTimeMillis	()J
    //   1099: aload 14
    //   1101: getfield 451	com/tencent/mm/plugin/base/stub/e:vrk	J
    //   1104: lsub
    //   1105: aload 14
    //   1107: getfield 454	com/tencent/mm/plugin/base/stub/e:oEj	J
    //   1110: lcmp
    //   1111: ifle +5 -> 1116
    //   1114: aconst_null
    //   1115: astore_2
    //   1116: aload_2
    //   1117: ifnull +150 -> 1267
    //   1120: aload_2
    //   1121: getfield 457	com/tencent/mm/plugin/base/stub/e:vrj	Ljava/lang/String;
    //   1124: invokestatic 233	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1127: ifne +140 -> 1267
    //   1130: ldc 178
    //   1132: ldc_w 459
    //   1135: invokestatic 293	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1138: invokestatic 126	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1141: aload_2
    //   1142: getfield 457	com/tencent/mm/plugin/base/stub/e:vrj	Ljava/lang/String;
    //   1145: aload_1
    //   1146: invokestatic 463	com/tencent/mm/pluginsdk/g:aa	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   1149: pop
    //   1150: aload_1
    //   1151: aload 22
    //   1153: aload 21
    //   1155: iload 8
    //   1157: iconst_2
    //   1158: iconst_0
    //   1159: invokestatic 324	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   1162: pop
    //   1163: getstatic 56	com/tencent/mm/plugin/base/stub/f:vrS	Z
    //   1166: ifeq +311 -> 1477
    //   1169: invokestatic 468	android/os/SystemClock:elapsedRealtime	()J
    //   1172: getstatic 58	com/tencent/mm/plugin/base/stub/f:vrT	J
    //   1175: lsub
    //   1176: lstore 10
    //   1178: lload 10
    //   1180: lconst_0
    //   1181: lcmp
    //   1182: iflt +16 -> 1198
    //   1185: lload 10
    //   1187: lstore 12
    //   1189: lload 10
    //   1191: ldc2_w 469
    //   1194: lcmp
    //   1195: ifle +6 -> 1201
    //   1198: lconst_0
    //   1199: lstore 12
    //   1201: lload 12
    //   1203: ldc2_w 471
    //   1206: lcmp
    //   1207: ifle +8 -> 1215
    //   1210: bipush 20
    //   1212: invokestatic 88	com/tencent/mm/plugin/base/stub/f:GG	(I)V
    //   1215: getstatic 94	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1218: sipush 19218
    //   1221: iconst_5
    //   1222: anewarray 4	java/lang/Object
    //   1225: dup
    //   1226: iconst_0
    //   1227: aload 25
    //   1229: aastore
    //   1230: dup
    //   1231: iconst_1
    //   1232: aload 22
    //   1234: aastore
    //   1235: dup
    //   1236: iconst_2
    //   1237: aload 21
    //   1239: aastore
    //   1240: dup
    //   1241: iconst_3
    //   1242: aload 23
    //   1244: aastore
    //   1245: dup
    //   1246: iconst_4
    //   1247: lload 12
    //   1249: ldc2_w 473
    //   1252: ldiv
    //   1253: invokestatic 479	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1256: aastore
    //   1257: invokevirtual 482	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1260: ldc 176
    //   1262: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1265: aconst_null
    //   1266: areturn
    //   1267: new 114	android/content/Intent
    //   1270: dup
    //   1271: aload_0
    //   1272: ldc_w 484
    //   1275: invokespecial 487	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1278: astore_2
    //   1279: aload_2
    //   1280: aload_1
    //   1281: invokestatic 493	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1284: invokevirtual 497	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1287: pop
    //   1288: aload_2
    //   1289: ldc 116
    //   1291: invokevirtual 500	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1294: pop
    //   1295: aload_2
    //   1296: ldc_w 502
    //   1299: aload 25
    //   1301: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1304: pop
    //   1305: aload_2
    //   1306: ldc_w 504
    //   1309: aload 23
    //   1311: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1314: pop
    //   1315: aload_2
    //   1316: ldc_w 506
    //   1319: aload 22
    //   1321: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1324: pop
    //   1325: aload_2
    //   1326: ldc_w 508
    //   1329: iconst_1
    //   1330: invokevirtual 511	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1333: pop
    //   1334: aload_2
    //   1335: ldc_w 513
    //   1338: aload 21
    //   1340: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1343: pop
    //   1344: iload 5
    //   1346: ifeq +118 -> 1464
    //   1349: aload_2
    //   1350: ldc_w 515
    //   1353: iconst_1
    //   1354: invokevirtual 149	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1357: pop
    //   1358: aload_2
    //   1359: ldc_w 517
    //   1362: aload 23
    //   1364: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1367: pop
    //   1368: aload_2
    //   1369: ldc_w 519
    //   1372: bipush 29
    //   1374: invokevirtual 511	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1377: pop
    //   1378: invokestatic 525	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   1381: ldc_w 527
    //   1384: iconst_1
    //   1385: invokevirtual 531	com/tencent/mm/model/ad:M	(Ljava/lang/String;Z)Lcom/tencent/mm/model/ad$b;
    //   1388: astore_1
    //   1389: aload_1
    //   1390: ldc_w 506
    //   1393: aload 22
    //   1395: invokevirtual 537	com/tencent/mm/model/ad$b:q	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1398: pop
    //   1399: aload_1
    //   1400: ldc_w 513
    //   1403: aload 21
    //   1405: invokevirtual 537	com/tencent/mm/model/ad$b:q	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1408: pop
    //   1409: aload_1
    //   1410: ldc_w 539
    //   1413: iload 8
    //   1415: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1418: invokevirtual 537	com/tencent/mm/model/ad$b:q	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1421: pop
    //   1422: ldc 178
    //   1424: ldc_w 541
    //   1427: iconst_3
    //   1428: anewarray 4	java/lang/Object
    //   1431: dup
    //   1432: iconst_0
    //   1433: aload 22
    //   1435: aastore
    //   1436: dup
    //   1437: iconst_1
    //   1438: aload 21
    //   1440: aastore
    //   1441: dup
    //   1442: iconst_2
    //   1443: iload 8
    //   1445: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1448: aastore
    //   1449: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1452: iconst_2
    //   1453: invokestatic 88	com/tencent/mm/plugin/base/stub/f:GG	(I)V
    //   1456: aload_2
    //   1457: aload_0
    //   1458: invokestatic 545	com/tencent/mm/plugin/base/stub/f:t	(Landroid/content/Intent;Landroid/content/Context;)V
    //   1461: goto -298 -> 1163
    //   1464: aload_2
    //   1465: ldc_w 519
    //   1468: bipush 19
    //   1470: invokevirtual 511	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1473: pop
    //   1474: goto -96 -> 1378
    //   1477: lconst_0
    //   1478: lstore 10
    //   1480: goto -302 -> 1178
    //   1483: astore_2
    //   1484: aload 24
    //   1486: astore 17
    //   1488: aload 18
    //   1490: astore 14
    //   1492: aload_2
    //   1493: astore 18
    //   1495: aload 15
    //   1497: astore_2
    //   1498: aload_1
    //   1499: astore 15
    //   1501: goto -911 -> 590
    //   1504: astore 18
    //   1506: aload 20
    //   1508: astore 17
    //   1510: aload_1
    //   1511: astore 15
    //   1513: goto -923 -> 590
    //   1516: astore_2
    //   1517: aload 24
    //   1519: astore 18
    //   1521: aload 19
    //   1523: astore 14
    //   1525: aload_2
    //   1526: astore 19
    //   1528: aload 17
    //   1530: astore_2
    //   1531: aload_1
    //   1532: astore 15
    //   1534: goto -975 -> 559
    //   1537: astore 19
    //   1539: aload 20
    //   1541: astore 18
    //   1543: aload_1
    //   1544: astore 15
    //   1546: goto -987 -> 559
    //   1549: ldc 223
    //   1551: astore_1
    //   1552: ldc 223
    //   1554: astore 14
    //   1556: goto -1138 -> 418
    //   1559: aconst_null
    //   1560: astore 21
    //   1562: aconst_null
    //   1563: astore 22
    //   1565: goto -1511 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1568	0	paramContext	Context
    //   0	1568	1	paramArrayOfString1	String[]
    //   0	1568	2	paramArrayOfString2	String[]
    //   0	1568	3	paramBoolean1	boolean
    //   0	1568	4	paramBoolean2	boolean
    //   0	1568	5	paramBoolean3	boolean
    //   0	1568	6	paramBoolean4	boolean
    //   148	563	7	i	int
    //   136	1308	8	j	int
    //   297	3	9	k	int
    //   1176	303	10	l1	long
    //   1187	61	12	l2	long
    //   155	1400	14	localObject1	Object
    //   140	1405	15	localObject2	Object
    //   133	298	16	str1	String
    //   609	14	16	localException	Exception
    //   199	1330	17	localObject3	Object
    //   203	1291	18	localObject4	Object
    //   1504	1	18	localUnsupportedEncodingException	UnsupportedEncodingException
    //   1519	23	18	localObject5	Object
    //   312	48	19	localObject6	Object
    //   549	973	19	localg1	com.tencent.mm.ad.g
    //   1526	1	19	arrayOfString	String[]
    //   1537	1	19	localg2	com.tencent.mm.ad.g
    //   256	1284	20	localObject7	Object
    //   52	1509	21	str2	String
    //   35	1529	22	str3	String
    //   129	1234	23	str4	String
    //   159	1359	24	str5	String
    //   119	1181	25	str6	String
    // Exception table:
    //   from	to	target	type
    //   205	212	549	com/tencent/mm/ad/g
    //   220	235	549	com/tencent/mm/ad/g
    //   243	258	549	com/tencent/mm/ad/g
    //   266	279	549	com/tencent/mm/ad/g
    //   285	299	549	com/tencent/mm/ad/g
    //   531	539	549	com/tencent/mm/ad/g
    //   205	212	578	java/io/UnsupportedEncodingException
    //   220	235	578	java/io/UnsupportedEncodingException
    //   243	258	578	java/io/UnsupportedEncodingException
    //   266	279	578	java/io/UnsupportedEncodingException
    //   285	299	578	java/io/UnsupportedEncodingException
    //   531	539	578	java/io/UnsupportedEncodingException
    //   430	437	609	java/lang/Exception
    //   317	326	1483	java/io/UnsupportedEncodingException
    //   340	350	1483	java/io/UnsupportedEncodingException
    //   364	374	1483	java/io/UnsupportedEncodingException
    //   374	412	1504	java/io/UnsupportedEncodingException
    //   317	326	1516	com/tencent/mm/ad/g
    //   340	350	1516	com/tencent/mm/ad/g
    //   364	374	1516	com/tencent/mm/ad/g
    //   374	412	1537	com/tencent/mm/ad/g
  }
  
  private static MatrixCursor a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(22239);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      Log.e("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink:packageName or signature null");
      AppMethodBeat.o(22239);
      return null;
    }
    Object localObject2 = new LinkedList();
    Object localObject1 = new ez();
    Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink package name = %s, cgiType=%d", new Object[] { paramString2, Integer.valueOf(paramInt2) });
    ((ez)localObject1).xlr = paramString2;
    ((ez)localObject1).signature = paramString3;
    ((LinkedList)localObject2).add(localObject1);
    localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = new fqh();
    ((com.tencent.mm.am.c.a)localObject1).otF = new fqi();
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((com.tencent.mm.am.c.a)localObject1).funcId = 1200;
    com.tencent.mm.am.c localc = ((com.tencent.mm.am.c.a)localObject1).bEF();
    fqh localfqh = (fqh)c.b.b(localc.otB);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (1 == paramInt2) {
      localObject1 = "&preload=1";
    }
    for (;;)
    {
      localfqh.link = ((String)localObject1);
      localStringBuilder = new StringBuilder().append(localfqh.link);
      if (2 == paramInt2)
      {
        localObject1 = "&jsForReport=1";
        localfqh.link = ((String)localObject1);
        localfqh.scene = 1;
        localfqh.abQd = ((LinkedList)localObject2);
        localObject2 = new CountDownLatch(1);
        localObject1 = new MatrixCursor(new String[] { "downloadUrl", "fileMd5", "expireTime", "extraBytes" });
        z.a(localc, new f.2(paramInt2, paramString1, paramString2, paramString3, paramInt1, paramBoolean, (MatrixCursor)localObject1, (CountDownLatch)localObject2));
        if (!paramBoolean) {}
      }
      try
      {
        ((CountDownLatch)localObject2).await(10L, TimeUnit.SECONDS);
        if (paramBoolean)
        {
          AppMethodBeat.o(22239);
          return localObject1;
          localObject1 = "";
          continue;
          localObject1 = "";
        }
      }
      catch (InterruptedException paramString1)
      {
        for (;;)
        {
          Log.e("MicroMsg.WXBizLogic", paramString1.getMessage());
        }
        AppMethodBeat.o(22239);
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Uri paramUri, int paramInt, String paramString1, String paramString2, Runnable paramRunnable)
  {
    AppMethodBeat.i(22231);
    Log.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[] { paramString1, paramString2 });
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
      AppMethodBeat.o(22231);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    ez localez = new ez();
    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { paramString1 });
    localez.xlr = paramString1;
    localez.signature = paramString2;
    localLinkedList.add(localez);
    paramUri = new com.tencent.mm.modelsimple.ad(paramUri.toString(), paramInt, localLinkedList);
    paramActivity = new f.1(paramActivity, paramRunnable);
    bh.aZW().a(1200, paramActivity);
    bh.aZW().a(paramUri, 0);
    AppMethodBeat.o(22231);
  }
  
  static void a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(269085);
    WXLaunchWxaRedirectingPage.Resp localResp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
    localResp.invokeTicket = paramReq.invokeTicket;
    localResp.callbackActivity = paramReq.callbackActivity;
    localResp.errCode = paramInt;
    localResp.errStr = paramString2;
    paramReq = new Bundle();
    localResp.toBundle(paramReq);
    u.bS(paramReq);
    u.bT(paramReq);
    paramString2 = new MMessageActV2.Args();
    paramString2.targetPkgName = paramString1;
    paramString2.bundle = paramReq;
    MMessageActV2.send(paramContext, paramString2);
    if ((paramContext instanceof WXBizEntryActivity)) {
      ((WXBizEntryActivity)paramContext).finish();
    }
    AppMethodBeat.o(269085);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong)
  {
    AppMethodBeat.i(22236);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(22236);
      return;
    }
    paramString1 = c(paramString1, paramInt1, paramString2, paramString3, paramInt2);
    paramString2 = new e();
    paramString2.oEj = System.currentTimeMillis();
    paramString2.vrj = paramString4;
    if (paramLong > 0L) {
      paramString2.vrk = (1000L * paramLong);
    }
    vrO.put(paramString1, paramString2);
    AppMethodBeat.o(22236);
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(22232);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(22232);
      return false;
    }
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str1 = str2;
    if (paramArrayOfString2 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (paramArrayOfString2.length > 0)
      {
        str1 = paramArrayOfString2[0];
        localObject1 = g.getMessageDigest(u.cG(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    Log.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", new Object[] { str1, localObject1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22232);
      return false;
    }
    str2 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22232);
      return false;
    }
    int i = Util.getInt(paramArrayOfString1[1], 0);
    if (i <= 0)
    {
      Log.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(22232);
      return false;
    }
    paramArrayOfString2 = Util.nullAsNil(paramArrayOfString1[2]);
    Log.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString2 });
    paramArrayOfString1 = "";
    try
    {
      paramArrayOfString2 = URLEncoder.encode(Util.nullAsNil(paramArrayOfString2), "UTF-8");
      paramArrayOfString1 = paramArrayOfString2;
    }
    catch (UnsupportedEncodingException paramArrayOfString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WXBizLogic", paramArrayOfString2, "", new Object[0]);
      }
    }
    paramArrayOfString1 = String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString1 });
    Log.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", new Object[] { paramArrayOfString1 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("key_app_id", str2);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", (String)localObject1);
    paramArrayOfString2.putExtra("key_command_id", 25);
    t(paramArrayOfString2, paramContext);
    AppMethodBeat.o(22232);
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(269090);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append(paramString2).append(paramString3);
    if (!Util.isNullOrNil(paramString4))
    {
      paramString1 = paramString4.split("\\?");
      if (paramString1.length > 0) {
        localStringBuilder.append(paramString1[0]);
      }
    }
    paramString1 = localStringBuilder.toString();
    long l1 = System.currentTimeMillis();
    if (vrW.checkAndUpTime(paramString1))
    {
      long l2 = l1 - ((Long)vrW.get(paramString1)).longValue();
      if (l2 < paramLong)
      {
        Log.w("MicroMsg.WXBizLogic", "checkIfCanPreloadMiniProgram cannot preload, key:%s, interval duration:%d , intervalDuration:%d", new Object[] { paramString1, Long.valueOf(l2), Long.valueOf(paramLong) });
        AppMethodBeat.o(269090);
        return false;
      }
    }
    Log.i("MicroMsg.WXBizLogic", "checkIfCanPreloadMiniProgram can preload, key:%s, currentTimeMillis:%d , intervalDuration:%d", new Object[] { paramString1, Long.valueOf(l1), Long.valueOf(paramLong) });
    vrW.put(paramString1, Long.valueOf(l1));
    AppMethodBeat.o(269090);
    return true;
  }
  
  private static void ae(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161302);
      if (daa())
      {
        GG(31);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry saveWXBizEntryIntent enterId=%d", new Object[] { Long.valueOf(l) });
        paramIntent.putExtra("__BIZ_ENTRY_ENTER_ID", l);
        vrP = paramIntent;
        dac();
      }
      AppMethodBeat.o(161302);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void af(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 776
    //   6: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 762	com/tencent/mm/plugin/base/stub/f:daa	()Z
    //   12: ifne +13 -> 25
    //   15: ldc_w 776
    //   18: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: ldc_w 766
    //   29: lconst_0
    //   30: invokevirtual 780	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +16 -> 53
    //   40: getstatic 50	com/tencent/mm/plugin/base/stub/f:vrQ	Ljava/util/Set;
    //   43: lload_1
    //   44: invokestatic 479	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokeinterface 783 2 0
    //   52: pop
    //   53: invokestatic 786	com/tencent/mm/plugin/base/stub/f:dab	()V
    //   56: ldc 178
    //   58: ldc_w 788
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 479	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 582	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: ldc_w 776
    //   78: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -60 -> 21
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramIntent	Intent
    //   33	35	1	l	long
    // Exception table:
    //   from	to	target	type
    //   3	21	84	finally
    //   25	34	84	finally
    //   40	53	84	finally
    //   53	81	84	finally
  }
  
  public static boolean ag(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161306);
      long l = paramIntent.getLongExtra("__BIZ_ENTRY_ENTER_ID", 0L);
      Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry isInConsumedSet %d", new Object[] { Long.valueOf(l) });
      boolean bool = vrQ.contains(Long.valueOf(l));
      AppMethodBeat.o(161306);
      return bool;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  public static boolean b(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(22233);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(22233);
      return false;
    }
    Object localObject2 = null;
    String str2 = null;
    String str1 = str2;
    Object localObject1 = localObject2;
    if (paramArrayOfString2 != null)
    {
      str1 = str2;
      localObject1 = localObject2;
      if (paramArrayOfString2.length > 0)
      {
        localObject1 = paramArrayOfString2[0];
        str1 = g.getMessageDigest(u.cG(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    Log.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", new Object[] { localObject1, str1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 4))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str4 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str5 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str5))
    {
      Log.e("MicroMsg.WXBizLogic", "businessType isEmpty");
      AppMethodBeat.o(22233);
      return false;
    }
    str2 = Util.nullAsNil(paramArrayOfString1[2]);
    String str3 = Util.nullAsNil(paramArrayOfString1[3]);
    if (paramArrayOfString1.length > 4) {
      com.tencent.mm.pluginsdk.ui.tools.n.YtV = paramArrayOfString1[4];
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length > 5)
    {
      paramArrayOfString1 = paramArrayOfString1[5];
      paramArrayOfString2 = paramArrayOfString1;
      if (com.tencent.mm.kernel.h.baz())
      {
        com.tencent.mm.pluginsdk.model.app.h.s(str4, true, false);
        paramArrayOfString2 = paramArrayOfString1;
      }
    }
    boolean bool = str5.startsWith("native");
    localObject2 = "";
    paramArrayOfString1 = (String[])localObject2;
    if (!Util.isNullOrNil(str3))
    {
      paramArrayOfString1 = (String[])localObject2;
      if (!str3.startsWith("{")) {}
    }
    try
    {
      paramArrayOfString1 = URLEncoder.encode(new i(str3).optString("extData"), "utf-8");
      if (bool)
      {
        localObject2 = "openNativeView";
        paramArrayOfString1 = String.format("weixin://dl/%s/?appid=%s&businessType=%s&extdata=%s", new Object[] { localObject2, str4, str5, paramArrayOfString1 });
        Log.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", new Object[] { paramArrayOfString1, str2, str3 });
        if ("nativeOpenAdCanvas".equals(str5)) {
          com.tencent.mm.plugin.sns.ad.i.a.gN(com.tencent.mm.plugin.sns.ad.i.a.lO(str4, str3), 1);
        }
        if ((bool) || (Util.isNullOrNil(str3))) {
          break label635;
        }
      }
    }
    catch (Exception paramArrayOfString1)
    {
      for (;;)
      {
        try
        {
          int j = new i(str3).optInt("miniProgramType", 0);
          if (j >= 0)
          {
            i = j;
            if (j <= 2) {}
          }
          else
          {
            i = 0;
          }
          localObject2 = new Intent(paramContext, WXBizEntryActivity.class);
          ((Intent)localObject2).setData(Uri.parse(paramArrayOfString1));
          ((Intent)localObject2).addFlags(268435456);
          ((Intent)localObject2).putExtra("key_package_name", (String)localObject1);
          ((Intent)localObject2).putExtra("key_app_id", str4);
          ((Intent)localObject2).putExtra("key_business_type", str5);
          ((Intent)localObject2).putExtra("translate_link_scene", 1);
          ((Intent)localObject2).putExtra("key_package_signature", str1);
          ((Intent)localObject2).putExtra("key_command_id", 26);
          t((Intent)localObject2, paramContext);
          paramContext = com.tencent.mm.model.ad.bCb().M("key_data_center_session_id", true);
          paramContext.q("key_launch_miniprogram_type", Integer.valueOf(i));
          paramContext.q("key_launch_miniprogram_query_info", str2);
          paramContext.q("key_open_business_view_ext_info", str3);
          paramContext.q("key_launch_mini_program_open_id", paramArrayOfString2);
          AppMethodBeat.o(22233);
          return true;
        }
        catch (Exception localException) {}
        paramArrayOfString1 = paramArrayOfString1;
        Log.e("MicroMsg.WXBizLogic", "openBusinessView ex", new Object[] { paramArrayOfString1.getMessage() });
        paramArrayOfString1 = (String[])localObject2;
        continue;
        localObject2 = "jumpFakeWxa";
        continue;
        label635:
        int i = 0;
      }
    }
  }
  
  private static String c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(22237);
    paramString1 = MD5Util.getMD5String(String.format("%s_%d_%s_%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(22237);
    return paramString1;
  }
  
  public static boolean c(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269022);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(269022);
      return false;
    }
    String str4 = null;
    String str3 = null;
    String str2 = str3;
    String str1 = str4;
    if (paramArrayOfString2 != null)
    {
      str2 = str3;
      str1 = str4;
      if (paramArrayOfString2.length > 0)
      {
        str4 = paramArrayOfString2[0];
        paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
        str2 = str3;
        str1 = str4;
        if (paramArrayOfString2 != null)
        {
          str2 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
          str1 = str4;
        }
      }
    }
    Log.i("MicroMsg.WXBizLogic", "finderShareVideo packageName = %s, sig = %s", new Object[] { str1, str2 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(269022);
      return false;
    }
    String str7 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str7))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(269022);
      return false;
    }
    String str8 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str8))
    {
      Log.e("MicroMsg.WXBizLogic", "videoPath isEmpty");
      AppMethodBeat.o(269022);
      return false;
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length >= 3) {
      paramArrayOfString2 = paramArrayOfString1[2];
    }
    str3 = "";
    if (paramArrayOfString1.length >= 4) {
      str3 = paramArrayOfString1[3];
    }
    str4 = "";
    if (paramArrayOfString1.length >= 5) {
      str4 = paramArrayOfString1[4];
    }
    String str5 = "";
    if (paramArrayOfString1.length >= 6) {
      str5 = paramArrayOfString1[5];
    }
    paramArrayOfString1 = "";
    localObject3 = "";
    try
    {
      localObject1 = URLEncoder.encode(paramArrayOfString2, "UTF-8");
      paramArrayOfString1 = (String[])localObject1;
      String str6 = URLEncoder.encode(str3, "UTF-8");
      paramArrayOfString1 = str6;
      localObject3 = localObject1;
      localObject1 = paramArrayOfString1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject1;
        Log.printErrStackTrace("MicroMsg.WXBizLogic", localUnsupportedEncodingException, "", new Object[0]);
        Object localObject2 = localObject3;
        localObject3 = paramArrayOfString1;
      }
    }
    paramArrayOfString1 = String.format("weixin://dl/channels/shareVideo/?appid=%s&title=%s&url=%s", new Object[] { str7, localObject3, localObject1 });
    Log.i("MicroMsg.WXBizLogic", "finderShareVideo: appid = %s, videoPath = %s, title = %s, url = %s, extData = %s, jumpInfoString = %s", new Object[] { str7, str8, paramArrayOfString2, str3, str4, str5 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_app_id", str7);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", str2);
    paramArrayOfString2.putExtra("key_command_id", 33);
    paramArrayOfString2.putExtra("key_finder_video_path", str8);
    paramArrayOfString2.putExtra("key_finder_share_video_jump_info_string", str5);
    paramArrayOfString2.putExtra("key_finder_share_video_jump_info_extra_data", str4);
    t(paramArrayOfString2, paramContext);
    AppMethodBeat.o(269022);
    return true;
  }
  
  public static void cZX()
  {
    AppMethodBeat.i(179576);
    Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetCallingPackageNull");
    com.tencent.mm.plugin.report.service.h.OAn.p(1194L, 50L, 1L);
    AppMethodBeat.o(179576);
  }
  
  public static void cZY()
  {
    AppMethodBeat.i(179577);
    Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetPackagesForUidMoreThanOne");
    com.tencent.mm.plugin.report.service.h.OAn.p(1194L, 51L, 1L);
    AppMethodBeat.o(179577);
  }
  
  public static void cZZ()
  {
    AppMethodBeat.i(269065);
    com.tencent.mm.plugin.report.service.h.OAn.b(1194, new Object[] { Integer.valueOf(60), Integer.valueOf(1) });
    AppMethodBeat.o(269065);
  }
  
  public static boolean d(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269025);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(269025);
      return false;
    }
    String str1;
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      str1 = paramArrayOfString2[0];
      paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
      if (paramArrayOfString2 != null) {
        paramArrayOfString2 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WXBizLogic", "finderOpenProfile packageName = %s, sig = %s", new Object[] { str1, paramArrayOfString2 });
      if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
      {
        Log.e("MicroMsg.WXBizLogic", "args is null");
        AppMethodBeat.o(269025);
        return false;
      }
      String str2 = paramArrayOfString1[0];
      if (Util.isNullOrNil(str2))
      {
        Log.e("MicroMsg.WXBizLogic", "appId is null");
        AppMethodBeat.o(269025);
        return false;
      }
      String str3 = paramArrayOfString1[1];
      if (Util.isNullOrNil(str3))
      {
        Log.e("MicroMsg.WXBizLogic", "username isEmpty");
        AppMethodBeat.o(269025);
        return false;
      }
      paramArrayOfString1 = "";
      try
      {
        localObject = URLEncoder.encode(str3, "UTF-8");
        paramArrayOfString1 = (String[])localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject;
          Log.printErrStackTrace("MicroMsg.WXBizLogic", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      paramArrayOfString1 = String.format("weixin://dl/channels/profile/?appid=%s&username=%s", new Object[] { str2, paramArrayOfString1 });
      Log.i("MicroMsg.WXBizLogic", "finderOpenProfile: appid = %s, username = %s", new Object[] { str2, str3 });
      localObject = new Intent(paramContext, WXBizEntryActivity.class);
      ((Intent)localObject).setData(Uri.parse(paramArrayOfString1));
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("key_app_id", str2);
      ((Intent)localObject).putExtra("key_package_name", str1);
      ((Intent)localObject).putExtra("translate_link_scene", 1);
      ((Intent)localObject).putExtra("key_package_signature", paramArrayOfString2);
      ((Intent)localObject).putExtra("key_command_id", 34);
      t((Intent)localObject, paramContext);
      AppMethodBeat.o(269025);
      return true;
      paramArrayOfString2 = null;
      continue;
      paramArrayOfString2 = null;
      str1 = null;
    }
  }
  
  public static boolean daa()
  {
    AppMethodBeat.i(161300);
    if (vrR != -1)
    {
      if (vrR == 1)
      {
        AppMethodBeat.o(161300);
        return true;
      }
      AppMethodBeat.o(161300);
      return false;
    }
    if (BuildInfo.DEBUG)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(161300);
      return false;
    }
    vrR = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yOo, 1);
    Log.i("MicroMsg.WXBizLogic", "reTryOpenWXBizEntry open %d", new Object[] { Integer.valueOf(vrR) });
    if (vrR == 1)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    AppMethodBeat.o(161300);
    return false;
  }
  
  private static void dab()
  {
    try
    {
      vrP = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void dac()
  {
    AppMethodBeat.i(169736);
    if (appForegroundListener == null)
    {
      q.a local6 = new q.a()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          AppMethodBeat.i(269033);
          Log.d("MicroMsg.WXBizLogic", "turn onAppBackground");
          f.mE(false);
          AppMethodBeat.o(269033);
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          AppMethodBeat.i(269031);
          f.mE(true);
          f.jB(SystemClock.elapsedRealtime());
          Log.d("MicroMsg.WXBizLogic", "turn onAppForeground");
          if ((f.dai() != null) && (com.tencent.mm.kernel.h.baz()))
          {
            Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry onAppForeground");
            f.dae();
          }
          AppMethodBeat.o(269031);
        }
      };
      appForegroundListener = local6;
      local6.alive();
    }
    AppMethodBeat.o(169736);
  }
  
  public static void dad()
  {
    AppMethodBeat.i(161303);
    vrS = true;
    vrT = SystemClock.elapsedRealtime();
    dae();
    AppMethodBeat.o(161303);
  }
  
  public static void dae()
  {
    AppMethodBeat.i(169737);
    dac();
    if ((vrP == null) || (!daa()))
    {
      AppMethodBeat.o(169737);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269027);
        f.daf();
        AppMethodBeat.o(269027);
      }
    }, 50L);
    AppMethodBeat.o(169737);
  }
  
  /* Error */
  public static void daf()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 955
    //   6: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 178
    //   11: ldc_w 957
    //   14: invokestatic 959	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 771	com/tencent/mm/plugin/base/stub/f:vrP	Landroid/content/Intent;
    //   20: ifnonnull +13 -> 33
    //   23: ldc_w 955
    //   26: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: getstatic 771	com/tencent/mm/plugin/base/stub/f:vrP	Landroid/content/Intent;
    //   36: ldc_w 766
    //   39: lconst_0
    //   40: invokevirtual 780	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   43: lstore_0
    //   44: invokestatic 448	java/lang/System:currentTimeMillis	()J
    //   47: lload_0
    //   48: lsub
    //   49: lstore_0
    //   50: getstatic 771	com/tencent/mm/plugin/base/stub/f:vrP	Landroid/content/Intent;
    //   53: invokestatic 961	com/tencent/mm/plugin/base/stub/f:ag	(Landroid/content/Intent;)Z
    //   56: ifne +132 -> 188
    //   59: lload_0
    //   60: invokestatic 967	java/lang/Math:abs	(J)J
    //   63: ldc2_w 471
    //   66: lcmp
    //   67: ifge +121 -> 188
    //   70: ldc 178
    //   72: ldc_w 969
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_0
    //   82: invokestatic 479	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 209	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: getstatic 771	com/tencent/mm/plugin/base/stub/f:vrP	Landroid/content/Intent;
    //   92: ldc_w 971
    //   95: iconst_1
    //   96: invokevirtual 149	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   99: pop
    //   100: invokestatic 126	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   103: astore_2
    //   104: getstatic 771	com/tencent/mm/plugin/base/stub/f:vrP	Landroid/content/Intent;
    //   107: astore_3
    //   108: new 973	com/tencent/mm/hellhoundlib/b/a
    //   111: dup
    //   112: invokespecial 974	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   115: aload_3
    //   116: invokevirtual 977	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   119: astore_3
    //   120: aload_2
    //   121: aload_3
    //   122: invokevirtual 981	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   125: ldc_w 983
    //   128: ldc_w 985
    //   131: ldc_w 986
    //   134: ldc_w 988
    //   137: ldc_w 990
    //   140: ldc_w 991
    //   143: invokestatic 996	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_3
    //   148: iconst_0
    //   149: invokevirtual 1000	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   152: checkcast 114	android/content/Intent
    //   155: invokevirtual 1004	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   158: aload_2
    //   159: ldc_w 983
    //   162: ldc_w 985
    //   165: ldc_w 986
    //   168: ldc_w 988
    //   171: ldc_w 990
    //   174: ldc_w 991
    //   177: invokestatic 1007	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokestatic 786	com/tencent/mm/plugin/base/stub/f:dab	()V
    //   183: bipush 30
    //   185: invokestatic 88	com/tencent/mm/plugin/base/stub/f:GG	(I)V
    //   188: ldc_w 955
    //   191: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: goto -165 -> 29
    //   197: astore_2
    //   198: ldc 2
    //   200: monitorexit
    //   201: aload_2
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	39	0	l	long
    //   103	56	2	localContext	Context
    //   197	5	2	localObject1	Object
    //   107	41	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	29	197	finally
    //   33	188	197	finally
    //   188	194	197	finally
  }
  
  public static void dag()
  {
    AppMethodBeat.i(179578);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yME, 1);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        vrU = bool;
        Log.i("MicroMsg.WXBizLogic", "alvinluo updateGetCallingPackageStatus config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(vrU) });
        AppMethodBeat.o(179578);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WXBizLogic", localException, "alvinluo updateGetCallingPackageStatus exception", new Object[0]);
      vrU = true;
      AppMethodBeat.o(179578);
    }
  }
  
  public static boolean dah()
  {
    return vrU;
  }
  
  public static boolean e(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269028);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(269028);
      return false;
    }
    String str2 = null;
    localObject2 = null;
    Object localObject1 = localObject2;
    String str1 = str2;
    if (paramArrayOfString2 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (paramArrayOfString2.length > 0)
      {
        str2 = paramArrayOfString2[0];
        paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
        localObject1 = localObject2;
        str1 = str2;
        if (paramArrayOfString2 != null)
        {
          localObject1 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
          str1 = str2;
        }
      }
    }
    Log.i("MicroMsg.WXBizLogic", "finderOpenLive packageName = %s, sig = %s", new Object[] { str1, localObject1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(269028);
      return false;
    }
    String str3 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str3))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(269028);
      return false;
    }
    String str4 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.WXBizLogic", "feedID isEmpty");
      AppMethodBeat.o(269028);
      return false;
    }
    String str5 = paramArrayOfString1[2];
    if (Util.isNullOrNil(str5))
    {
      Log.e("MicroMsg.WXBizLogic", "nonceID isEmpty");
      AppMethodBeat.o(269028);
      return false;
    }
    paramArrayOfString1 = "";
    localObject2 = "";
    try
    {
      paramArrayOfString2 = URLEncoder.encode(str4, "UTF-8");
      paramArrayOfString1 = paramArrayOfString2;
      str2 = URLEncoder.encode(str5, "UTF-8");
      paramArrayOfString1 = str2;
      localObject2 = paramArrayOfString2;
      paramArrayOfString2 = paramArrayOfString1;
    }
    catch (UnsupportedEncodingException paramArrayOfString2)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WXBizLogic", paramArrayOfString2, "", new Object[0]);
        paramArrayOfString2 = (String[])localObject2;
        localObject2 = paramArrayOfString1;
      }
    }
    paramArrayOfString1 = String.format("weixin://dl/channels/live/?appid=%s&feedID=%s&nonceID=%s", new Object[] { str3, localObject2, paramArrayOfString2 });
    Log.i("MicroMsg.WXBizLogic", "finderOpenLive: appid = %s, feedID = %s, nonceID = %s", new Object[] { str3, str4, str5 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_app_id", str3);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", (String)localObject1);
    paramArrayOfString2.putExtra("key_command_id", 35);
    t(paramArrayOfString2, paramContext);
    AppMethodBeat.o(269028);
    return true;
  }
  
  public static boolean f(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269032);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(269032);
      return false;
    }
    String str2 = null;
    localObject2 = null;
    Object localObject1 = localObject2;
    String str1 = str2;
    if (paramArrayOfString2 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (paramArrayOfString2.length > 0)
      {
        str2 = paramArrayOfString2[0];
        paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
        localObject1 = localObject2;
        str1 = str2;
        if (paramArrayOfString2 != null)
        {
          localObject1 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
          str1 = str2;
        }
      }
    }
    Log.i("MicroMsg.WXBizLogic", "finderOpenFeed packageName = %s, sig = %s", new Object[] { str1, localObject1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(269032);
      return false;
    }
    String str3 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str3))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(269032);
      return false;
    }
    String str4 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.WXBizLogic", "username isEmpty");
      AppMethodBeat.o(269032);
      return false;
    }
    String str5 = paramArrayOfString1[2];
    if (Util.isNullOrNil(str5))
    {
      Log.e("MicroMsg.WXBizLogic", "eventId isEmpty");
      AppMethodBeat.o(269032);
      return false;
    }
    paramArrayOfString1 = "";
    localObject2 = "";
    try
    {
      paramArrayOfString2 = URLEncoder.encode(str4, "UTF-8");
      paramArrayOfString1 = paramArrayOfString2;
      str2 = URLEncoder.encode(str5, "UTF-8");
      paramArrayOfString1 = str2;
      localObject2 = paramArrayOfString2;
      paramArrayOfString2 = paramArrayOfString1;
    }
    catch (UnsupportedEncodingException paramArrayOfString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.WXBizLogic", paramArrayOfString2.getMessage());
        paramArrayOfString2 = (String[])localObject2;
        localObject2 = paramArrayOfString1;
      }
    }
    paramArrayOfString1 = String.format("%s?appid=%s&username=%s&eventId=%s", new Object[] { "weixin://dl/channels/openEvent/", str3, localObject2, paramArrayOfString2 });
    Log.i("MicroMsg.WXBizLogic", "finderOpenFeed: appid = %s, username = %s, eventId = %s", new Object[] { str3, str4, str5 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_app_id", str3);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", (String)localObject1);
    paramArrayOfString2.putExtra("key_command_id", 41);
    t(paramArrayOfString2, paramContext);
    AppMethodBeat.o(269032);
    return true;
  }
  
  public static boolean g(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269039);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(269039);
      return false;
    }
    localObject5 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    Object localObject1 = localObject5;
    if (paramArrayOfString2 != null)
    {
      localObject2 = localObject3;
      localObject1 = localObject5;
      if (paramArrayOfString2.length > 0)
      {
        localObject5 = paramArrayOfString2[0];
        paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (paramArrayOfString2 != null)
        {
          localObject2 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
          localObject1 = localObject5;
        }
      }
    }
    Log.i("MicroMsg.WXBizLogic", "finderOpenFeed packageName = %s, sig = %s", new Object[] { localObject1, localObject2 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(269039);
      return false;
    }
    String str2 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(269039);
      return false;
    }
    String str3 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str3))
    {
      Log.e("MicroMsg.WXBizLogic", "feedID isEmpty");
      AppMethodBeat.o(269039);
      return false;
    }
    String str4 = paramArrayOfString1[2];
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.WXBizLogic", "nonceID isEmpty");
      AppMethodBeat.o(269039);
      return false;
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length > 3) {
      paramArrayOfString2 = paramArrayOfString1[3];
    }
    if (paramArrayOfString2.equals("true")) {}
    for (int i = 1;; i = 0)
    {
      paramArrayOfString1 = "";
      localObject5 = "";
      try
      {
        localObject3 = URLEncoder.encode(str3, "UTF-8");
        paramArrayOfString1 = (String[])localObject3;
        String str1 = URLEncoder.encode(str4, "UTF-8");
        paramArrayOfString1 = str1;
        localObject5 = localObject3;
        localObject3 = paramArrayOfString1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WXBizLogic", localUnsupportedEncodingException, "", new Object[0]);
          Object localObject4 = localObject5;
          localObject5 = paramArrayOfString1;
        }
      }
      paramArrayOfString1 = String.format("weixin://dl/channels/feed/?appid=%s&feedID=%s&nonceID=%s&nonGetRelatedList=%d", new Object[] { str2, localObject5, localObject3, Integer.valueOf(i) });
      Log.i("MicroMsg.WXBizLogic", "finderOpenFeed: appid = %s, feedID = %s, nonceID = %s, nonGetRelatedList", new Object[] { str2, str3, str4, paramArrayOfString2 });
      paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
      paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
      paramArrayOfString2.addFlags(268435456);
      paramArrayOfString2.putExtra("key_app_id", str2);
      paramArrayOfString2.putExtra("key_package_name", localObject1);
      paramArrayOfString2.putExtra("translate_link_scene", 1);
      paramArrayOfString2.putExtra("key_package_signature", (String)localObject2);
      paramArrayOfString2.putExtra("key_command_id", 36);
      t(paramArrayOfString2, paramContext);
      AppMethodBeat.o(269039);
      return true;
    }
  }
  
  public static boolean h(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269042);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(269042);
      return false;
    }
    String str1;
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      str1 = paramArrayOfString2[0];
      paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
      if (paramArrayOfString2 != null) {
        paramArrayOfString2 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WXBizLogic", "openCustomerServiceChat packageName = %s, sig = %s", new Object[] { str1, paramArrayOfString2 });
      if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
      {
        Log.e("MicroMsg.WXBizLogic", "args is null");
        AppMethodBeat.o(269042);
        return false;
      }
      String str2 = paramArrayOfString1[0];
      if (Util.isNullOrNil(str2))
      {
        Log.e("MicroMsg.WXBizLogic", "appId is null");
        AppMethodBeat.o(269042);
        return false;
      }
      Object localObject = paramArrayOfString1[1];
      if (Util.isNullOrNil((String)localObject))
      {
        Log.e("MicroMsg.WXBizLogic", "corpId is null");
        AppMethodBeat.o(269042);
        return false;
      }
      paramArrayOfString1 = paramArrayOfString1[2];
      if (Util.isNullOrNil(paramArrayOfString1))
      {
        Log.e("MicroMsg.WXBizLogic", "url is null");
        AppMethodBeat.o(269042);
        return false;
      }
      paramArrayOfString1 = String.format("weixin://dl/customerService/?appid=%s&corpid=%s&kfurl=%s", new Object[] { str2, localObject, paramArrayOfString1 });
      Log.i("MicroMsg.WXBizLogic", "openCustomerServiceChat uri: %s", new Object[] { paramArrayOfString1 });
      localObject = new Intent(paramContext, WXBizEntryActivity.class);
      ((Intent)localObject).setData(Uri.parse(paramArrayOfString1));
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("key_app_id", str2);
      ((Intent)localObject).putExtra("key_package_name", str1);
      ((Intent)localObject).putExtra("translate_link_scene", 1);
      ((Intent)localObject).putExtra("key_package_signature", paramArrayOfString2);
      ((Intent)localObject).putExtra("key_command_id", 37);
      t((Intent)localObject, paramContext);
      AppMethodBeat.o(269042);
      return true;
      paramArrayOfString2 = null;
      continue;
      paramArrayOfString2 = null;
      str1 = null;
    }
  }
  
  public static boolean i(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269043);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "openQRCodePay context is null");
      AppMethodBeat.o(269043);
      return false;
    }
    String str1;
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      str1 = paramArrayOfString2[0];
      paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
      if (paramArrayOfString2 != null) {
        paramArrayOfString2 = g.getMessageDigest(paramArrayOfString2[0].toByteArray());
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.WXBizLogic", "openQRCodePay packageName = %s, sig = %s", new Object[] { str1, paramArrayOfString2 });
      if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
      {
        Log.e("MicroMsg.WXBizLogic", "args is null");
        AppMethodBeat.o(269043);
        return false;
      }
      String str2 = paramArrayOfString1[0];
      if (Util.isNullOrNil(str2))
      {
        Log.e("MicroMsg.WXBizLogic", "openQRCodePay appId is null");
        AppMethodBeat.o(269043);
        return false;
      }
      String str3 = paramArrayOfString1[1];
      if (Util.isNullOrNil(str3))
      {
        Log.e("MicroMsg.WXBizLogic", "openQRCodePay codeContent is null");
        AppMethodBeat.o(269043);
        return false;
      }
      paramArrayOfString1 = paramArrayOfString1[2];
      if (Util.isNullOrNil(paramArrayOfString1)) {
        Log.e("MicroMsg.WXBizLogic", "extraMsg is null");
      }
      Intent localIntent = new Intent(paramContext, WXBizEntryActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("key_app_id", str2);
      localIntent.putExtra("key_package_name", str1);
      localIntent.putExtra("key_package_signature", paramArrayOfString2);
      localIntent.putExtra("key_command_id", 38);
      localIntent.putExtra("key_qr_code_pay_code_centent", str3);
      localIntent.putExtra("key_qr_code_pay_extra_msg", paramArrayOfString1);
      t(localIntent, paramContext);
      AppMethodBeat.o(269043);
      return true;
      paramArrayOfString2 = null;
      continue;
      paramArrayOfString2 = null;
      str1 = null;
    }
  }
  
  static void j(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(269082);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WXBizLogic", "doLaunchWxaRedirectingPage, context==null[%b], args[%s], packages[%s]", new Object[] { Boolean.valueOf(bool), Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      GI(1);
      if ((paramContext != null) && (paramArrayOfString2 != null) && (paramArrayOfString2[0].length() > 0)) {
        break;
      }
      GI(2);
      AppMethodBeat.o(269082);
      return;
    }
    WXLaunchWxaRedirectingPage.Req localReq = new WXLaunchWxaRedirectingPage.Req();
    String str = paramArrayOfString1[0];
    try
    {
      if (TextUtils.isEmpty(str))
      {
        GI(2);
        AppMethodBeat.o(269082);
        return;
      }
      localReq.fromArray((String[])org.apache.commons.c.a.p(paramArrayOfString1, paramArrayOfString1.length));
      paramArrayOfString1 = new Intent(paramContext, WXBizEntryActivity.class);
      paramArrayOfString1.setData(Uri.parse(String.format(Locale.ENGLISH, "weixin://dl/wmpf/sdk?appid=%s&ticket=%s", new Object[] { str, localReq.invokeTicket })));
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.putExtra("translate_link_scene", 1);
      paramArrayOfString1.putExtra("key_package_name", paramArrayOfString2[0]);
      paramArrayOfString2 = u.cG(paramContext, paramArrayOfString2[0]);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {
        paramArrayOfString1.putExtra("key_package_signature", g.getMessageDigest(paramArrayOfString2[0].toByteArray()));
      }
      paramArrayOfString2 = new Bundle();
      localReq.toBundle(paramArrayOfString2);
      paramArrayOfString1.putExtra("key_launch_wxa_redirecting_page_req", paramArrayOfString2);
      paramArrayOfString1.putExtra("key_command_id", 30);
      t(paramArrayOfString1, paramContext);
      AppMethodBeat.o(269082);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.WXBizLogic", paramContext, "doLaunchWxaFRedirectingPage args[%s] packages[%s]", new Object[] { Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      GI(2);
      AppMethodBeat.o(269082);
    }
  }
  
  public static void t(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(161301);
      ae(paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(161301);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  public static boolean u(String[] paramArrayOfString)
  {
    AppMethodBeat.i(22234);
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 6) && (Util.getBoolean(paramArrayOfString[5], false)))
    {
      AppMethodBeat.o(22234);
      return true;
    }
    AppMethodBeat.o(22234);
    return false;
  }
  
  static MatrixCursor v(String[] paramArrayOfString)
  {
    AppMethodBeat.i(269088);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramArrayOfString = new MatrixCursor(new String[0], 0);
      AppMethodBeat.o(269088);
      return paramArrayOfString;
    }
    int i = paramArrayOfString.length;
    MatrixCursor localMatrixCursor = new MatrixCursor(new String[] { "feature", "support" }, i);
    int j = paramArrayOfString.length;
    i = 0;
    String[] arrayOfString;
    if (i < j)
    {
      localObject = paramArrayOfString[i];
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        arrayOfString = new String[2];
        arrayOfString[0] = localObject;
      }
    }
    label166:
    for (Object localObject = arrayOfString;; localObject = arrayOfString)
    {
      String str = "0";
      for (;;)
      {
        localObject[1] = str;
        localMatrixCursor.addRow(arrayOfString);
        i += 1;
        break;
        arrayOfString = new String[2];
        arrayOfString[0] = localObject;
        if (!org.apache.commons.c.a.contains(vrV, localObject)) {
          break label166;
        }
        str = "1";
        localObject = arrayOfString;
      }
      AppMethodBeat.o(269088);
      return localMatrixCursor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f
 * JD-Core Version:    0.7.0.1
 */