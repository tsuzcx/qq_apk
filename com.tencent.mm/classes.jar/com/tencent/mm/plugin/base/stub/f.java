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
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.launching.b.a.a.a;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.euu;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static o.a appForegroundListener;
  private static Map<String, e> sfX;
  private static Intent sfY;
  public static final Set<Long> sfZ;
  private static int sga;
  private static boolean sgb;
  private static long sgc;
  private static boolean sgd;
  private static final String[] sge;
  
  static
  {
    AppMethodBeat.i(22242);
    sfX = new HashMap();
    sfZ = new HashSet();
    sga = -1;
    appForegroundListener = null;
    sgb = false;
    sgc = 0L;
    sgd = true;
    sge = new String[] { "sdk_openAppProfile", "sdk_openFeedback", "sdk_openGrowthCare", "sdk_navigateToMiniProgram" };
    AppMethodBeat.o(22242);
  }
  
  public static void Gh(int paramInt)
  {
    AppMethodBeat.i(22238);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1194L, paramInt, 1L, false);
    AppMethodBeat.o(22238);
  }
  
  public static void Gi(int paramInt)
  {
    AppMethodBeat.i(291823);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1674L, paramInt, 1L, false);
    AppMethodBeat.o(291823);
  }
  
  static void Gj(int paramInt)
  {
    AppMethodBeat.i(291828);
    com.tencent.mm.plugin.report.service.h.IzE.el(1405, paramInt);
    AppMethodBeat.o(291828);
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
    //   0: ldc 183
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 185
    //   11: ldc 187
    //   13: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 183
    //   18: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: aconst_null
    //   24: astore 14
    //   26: aconst_null
    //   27: astore 15
    //   29: aload 14
    //   31: astore 22
    //   33: aload 15
    //   35: astore 21
    //   37: aload_2
    //   38: ifnull +38 -> 76
    //   41: aload 14
    //   43: astore 22
    //   45: aload 15
    //   47: astore 21
    //   49: aload_2
    //   50: arraylength
    //   51: ifle +25 -> 76
    //   54: aload_2
    //   55: iconst_0
    //   56: aaload
    //   57: astore 22
    //   59: aload_0
    //   60: aload_2
    //   61: iconst_0
    //   62: aaload
    //   63: invokestatic 199	com/tencent/mm/pluginsdk/model/app/q:cv	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   66: iconst_0
    //   67: aaload
    //   68: invokevirtual 205	android/content/pm/Signature:toByteArray	()[B
    //   71: invokestatic 211	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   74: astore 21
    //   76: ldc 185
    //   78: ldc 213
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload 22
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload 21
    //   93: aastore
    //   94: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: ifnull +9 -> 107
    //   101: aload_1
    //   102: arraylength
    //   103: iconst_2
    //   104: if_icmpge +17 -> 121
    //   107: ldc 185
    //   109: ldc 218
    //   111: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: ldc 183
    //   116: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aconst_null
    //   120: areturn
    //   121: getstatic 224	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:GlobalAppbrand	Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries;
    //   124: aload_0
    //   125: invokevirtual 228	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:checkAvailable	(Landroid/content/Context;)Z
    //   128: ifne +10 -> 138
    //   131: ldc 183
    //   133: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: aload_1
    //   139: iconst_0
    //   140: aaload
    //   141: astore 24
    //   143: iload 6
    //   145: ifne +444 -> 589
    //   148: aload_1
    //   149: iconst_1
    //   150: aaload
    //   151: astore 23
    //   153: ldc 230
    //   155: astore 15
    //   157: iload 5
    //   159: ifeq +437 -> 596
    //   162: iconst_3
    //   163: istore 7
    //   165: ldc 230
    //   167: astore 14
    //   169: ldc 230
    //   171: astore_2
    //   172: aload_1
    //   173: arraylength
    //   174: iconst_2
    //   175: if_icmple +1321 -> 1496
    //   178: aload_1
    //   179: iconst_2
    //   180: aaload
    //   181: astore 16
    //   183: aload_1
    //   184: arraylength
    //   185: iconst_3
    //   186: if_icmple +1304 -> 1490
    //   189: aload_1
    //   190: iconst_3
    //   191: aaload
    //   192: iconst_0
    //   193: invokestatic 236	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   196: istore 8
    //   198: aload_1
    //   199: arraylength
    //   200: iconst_4
    //   201: if_icmple +1283 -> 1484
    //   204: aload_1
    //   205: iconst_4
    //   206: aaload
    //   207: astore_1
    //   208: aload 15
    //   210: astore 17
    //   212: aload 15
    //   214: astore 18
    //   216: aload_1
    //   217: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   220: ifne +382 -> 602
    //   223: aload 15
    //   225: astore 17
    //   227: aload 15
    //   229: astore 18
    //   231: ldc 185
    //   233: ldc 242
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: aastore
    //   243: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload 15
    //   248: astore 17
    //   250: aload 15
    //   252: astore 18
    //   254: new 247	com/tencent/mm/ad/i
    //   257: dup
    //   258: aload_1
    //   259: ldc 249
    //   261: invokestatic 255	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   264: invokespecial 258	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   267: astore 25
    //   269: aload 15
    //   271: astore 17
    //   273: aload 15
    //   275: astore 18
    //   277: aload 25
    //   279: ldc_w 260
    //   282: invokevirtual 264	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: ldc 249
    //   287: invokestatic 269	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   290: astore_1
    //   291: aload_1
    //   292: astore 17
    //   294: aload_1
    //   295: astore 18
    //   297: aload 25
    //   299: ldc_w 271
    //   302: invokevirtual 264	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   305: iconst_0
    //   306: invokestatic 236	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   309: istore 9
    //   311: iload 9
    //   313: istore 7
    //   315: aload_2
    //   316: astore 18
    //   318: aload 14
    //   320: astore 17
    //   322: aload_2
    //   323: astore 19
    //   325: aload 14
    //   327: astore 20
    //   329: aload 25
    //   331: ldc_w 273
    //   334: invokevirtual 264	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   337: astore 14
    //   339: aload_2
    //   340: astore 18
    //   342: aload 14
    //   344: astore 17
    //   346: aload_2
    //   347: astore 19
    //   349: aload 14
    //   351: astore 20
    //   353: aload 25
    //   355: ldc_w 275
    //   358: invokevirtual 264	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore_2
    //   362: aload_2
    //   363: astore 18
    //   365: aload 14
    //   367: astore 17
    //   369: aload_2
    //   370: astore 19
    //   372: aload 14
    //   374: astore 20
    //   376: aload 25
    //   378: ldc_w 277
    //   381: invokevirtual 264	com/tencent/mm/ad/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore 15
    //   386: ldc 185
    //   388: ldc_w 279
    //   391: iconst_5
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload_1
    //   398: aastore
    //   399: dup
    //   400: iconst_1
    //   401: iload 7
    //   403: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   406: aastore
    //   407: dup
    //   408: iconst_2
    //   409: aload 14
    //   411: aastore
    //   412: dup
    //   413: iconst_3
    //   414: aload_2
    //   415: aastore
    //   416: dup
    //   417: iconst_4
    //   418: aload 15
    //   420: aastore
    //   421: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   424: aload 15
    //   426: astore 17
    //   428: aload_1
    //   429: astore 15
    //   431: aload 17
    //   433: astore_1
    //   434: aload 16
    //   436: astore 17
    //   438: aload 16
    //   440: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   443: ifne +10 -> 453
    //   446: aload 16
    //   448: invokestatic 287	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   451: astore 17
    //   453: ldc 185
    //   455: ldc_w 289
    //   458: iconst_4
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: aload 24
    //   466: aastore
    //   467: dup
    //   468: iconst_1
    //   469: aload 23
    //   471: aastore
    //   472: dup
    //   473: iconst_2
    //   474: aload 17
    //   476: aastore
    //   477: dup
    //   478: iconst_3
    //   479: iload 8
    //   481: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   484: aastore
    //   485: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   488: iload 6
    //   490: ifne +221 -> 711
    //   493: ldc_w 291
    //   496: bipush 8
    //   498: anewarray 4	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: aload 24
    //   505: aastore
    //   506: dup
    //   507: iconst_1
    //   508: aload 23
    //   510: aastore
    //   511: dup
    //   512: iconst_2
    //   513: aload 17
    //   515: aastore
    //   516: dup
    //   517: iconst_3
    //   518: aload 15
    //   520: aastore
    //   521: dup
    //   522: iconst_4
    //   523: iload 7
    //   525: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: aastore
    //   529: dup
    //   530: iconst_5
    //   531: aload 14
    //   533: aastore
    //   534: dup
    //   535: bipush 6
    //   537: aload_2
    //   538: aastore
    //   539: dup
    //   540: bipush 7
    //   542: aload_1
    //   543: aastore
    //   544: invokestatic 295	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   547: astore_1
    //   548: ldc 185
    //   550: ldc_w 297
    //   553: iconst_1
    //   554: anewarray 4	java/lang/Object
    //   557: dup
    //   558: iconst_0
    //   559: aload_1
    //   560: aastore
    //   561: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   564: iload_3
    //   565: ifeq +165 -> 730
    //   568: aload_1
    //   569: aload 22
    //   571: aload 21
    //   573: iload 8
    //   575: iconst_1
    //   576: iload 4
    //   578: invokestatic 300	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   581: astore_0
    //   582: ldc 183
    //   584: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: aload_0
    //   588: areturn
    //   589: ldc 230
    //   591: astore 23
    //   593: goto -440 -> 153
    //   596: iconst_0
    //   597: istore 7
    //   599: goto -434 -> 165
    //   602: aload 15
    //   604: astore 17
    //   606: aload 15
    //   608: astore 18
    //   610: ldc 185
    //   612: ldc_w 302
    //   615: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: ldc 230
    //   620: astore_1
    //   621: goto -187 -> 434
    //   624: astore_1
    //   625: ldc 230
    //   627: astore 15
    //   629: ldc 185
    //   631: aload_1
    //   632: ldc 230
    //   634: iconst_0
    //   635: anewarray 4	java/lang/Object
    //   638: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   641: aload 15
    //   643: astore_1
    //   644: aload 17
    //   646: astore 15
    //   648: goto -214 -> 434
    //   651: astore_1
    //   652: ldc 230
    //   654: astore 15
    //   656: aload 18
    //   658: astore 17
    //   660: ldc 185
    //   662: aload_1
    //   663: ldc 230
    //   665: iconst_0
    //   666: anewarray 4	java/lang/Object
    //   669: invokestatic 306	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload 15
    //   674: astore_1
    //   675: aload 17
    //   677: astore 15
    //   679: goto -245 -> 434
    //   682: astore 16
    //   684: ldc 185
    //   686: ldc_w 308
    //   689: iconst_1
    //   690: anewarray 4	java/lang/Object
    //   693: dup
    //   694: iconst_0
    //   695: aload 16
    //   697: invokevirtual 312	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   700: aastore
    //   701: invokestatic 314	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: ldc 230
    //   706: astore 17
    //   708: goto -255 -> 453
    //   711: ldc_w 316
    //   714: iconst_1
    //   715: anewarray 4	java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: aload 24
    //   722: aastore
    //   723: invokestatic 295	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   726: astore_1
    //   727: goto -179 -> 548
    //   730: iload 6
    //   732: ifeq +265 -> 997
    //   735: aload 22
    //   737: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   740: ifne +11 -> 751
    //   743: aload 21
    //   745: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   748: ifeq +18 -> 766
    //   751: ldc 185
    //   753: ldc_w 318
    //   756: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: ldc 183
    //   761: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   764: aconst_null
    //   765: areturn
    //   766: new 320	java/util/LinkedList
    //   769: dup
    //   770: invokespecial 321	java/util/LinkedList:<init>	()V
    //   773: astore_0
    //   774: new 323	com/tencent/mm/protocal/protobuf/ef
    //   777: dup
    //   778: invokespecial 324	com/tencent/mm/protocal/protobuf/ef:<init>	()V
    //   781: astore_2
    //   782: ldc 185
    //   784: ldc_w 326
    //   787: iconst_2
    //   788: anewarray 4	java/lang/Object
    //   791: dup
    //   792: iconst_0
    //   793: aload 22
    //   795: aastore
    //   796: dup
    //   797: iconst_1
    //   798: iconst_3
    //   799: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   802: aastore
    //   803: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   806: aload_2
    //   807: aload 22
    //   809: putfield 329	com/tencent/mm/protocal/protobuf/ef:ufq	Ljava/lang/String;
    //   812: aload_2
    //   813: aload 21
    //   815: putfield 332	com/tencent/mm/protocal/protobuf/ef:signature	Ljava/lang/String;
    //   818: aload_0
    //   819: aload_2
    //   820: invokevirtual 336	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   823: pop
    //   824: new 338	com/tencent/mm/an/d$a
    //   827: dup
    //   828: invokespecial 339	com/tencent/mm/an/d$a:<init>	()V
    //   831: astore_2
    //   832: aload_2
    //   833: new 341	com/tencent/mm/protocal/protobuf/euu
    //   836: dup
    //   837: invokespecial 342	com/tencent/mm/protocal/protobuf/euu:<init>	()V
    //   840: putfield 346	com/tencent/mm/an/d$a:lBU	Lcom/tencent/mm/cd/a;
    //   843: aload_2
    //   844: new 348	com/tencent/mm/protocal/protobuf/euv
    //   847: dup
    //   848: invokespecial 349	com/tencent/mm/protocal/protobuf/euv:<init>	()V
    //   851: putfield 352	com/tencent/mm/an/d$a:lBV	Lcom/tencent/mm/cd/a;
    //   854: aload_2
    //   855: ldc_w 354
    //   858: putfield 357	com/tencent/mm/an/d$a:uri	Ljava/lang/String;
    //   861: aload_2
    //   862: sipush 1200
    //   865: putfield 360	com/tencent/mm/an/d$a:funcId	I
    //   868: aload_2
    //   869: invokevirtual 364	com/tencent/mm/an/d$a:bgN	()Lcom/tencent/mm/an/d;
    //   872: astore_2
    //   873: aload_2
    //   874: getfield 370	com/tencent/mm/an/d:lBR	Lcom/tencent/mm/an/d$b;
    //   877: invokestatic 375	com/tencent/mm/an/d$b:b	(Lcom/tencent/mm/an/d$b;)Lcom/tencent/mm/cd/a;
    //   880: checkcast 341	com/tencent/mm/protocal/protobuf/euu
    //   883: astore 14
    //   885: aload 14
    //   887: new 377	java/lang/StringBuilder
    //   890: dup
    //   891: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   894: aload_1
    //   895: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc_w 384
    //   901: invokevirtual 382	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: putfield 390	com/tencent/mm/protocal/protobuf/euu:link	Ljava/lang/String;
    //   910: aload 14
    //   912: iconst_1
    //   913: putfield 393	com/tencent/mm/protocal/protobuf/euu:scene	I
    //   916: aload 14
    //   918: aload_0
    //   919: putfield 397	com/tencent/mm/protocal/protobuf/euu:Uwx	Ljava/util/LinkedList;
    //   922: ldc 185
    //   924: ldc_w 399
    //   927: iconst_1
    //   928: anewarray 4	java/lang/Object
    //   931: dup
    //   932: iconst_0
    //   933: aload 14
    //   935: getfield 390	com/tencent/mm/protocal/protobuf/euu:link	Ljava/lang/String;
    //   938: aastore
    //   939: invokestatic 245	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   942: new 401	android/database/MatrixCursor
    //   945: dup
    //   946: iconst_4
    //   947: anewarray 73	java/lang/String
    //   950: dup
    //   951: iconst_0
    //   952: ldc_w 403
    //   955: aastore
    //   956: dup
    //   957: iconst_1
    //   958: ldc_w 405
    //   961: aastore
    //   962: dup
    //   963: iconst_2
    //   964: ldc_w 407
    //   967: aastore
    //   968: dup
    //   969: iconst_3
    //   970: ldc_w 409
    //   973: aastore
    //   974: invokespecial 412	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   977: astore_0
    //   978: aload_2
    //   979: new 14	com/tencent/mm/plugin/base/stub/f$3
    //   982: dup
    //   983: invokespecial 413	com/tencent/mm/plugin/base/stub/f$3:<init>	()V
    //   986: invokestatic 418	com/tencent/mm/an/aa:a	(Lcom/tencent/mm/an/d;Lcom/tencent/mm/an/aa$a;)Lcom/tencent/mm/an/d;
    //   989: pop
    //   990: ldc 183
    //   992: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   995: aload_0
    //   996: areturn
    //   997: aload_1
    //   998: iconst_1
    //   999: aload 22
    //   1001: aload 21
    //   1003: iload 8
    //   1005: invokestatic 422	com/tencent/mm/plugin/base/stub/f:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1008: astore_2
    //   1009: getstatic 56	com/tencent/mm/plugin/base/stub/f:sfX	Ljava/util/Map;
    //   1012: aload_2
    //   1013: invokeinterface 428 2 0
    //   1018: checkcast 430	com/tencent/mm/plugin/base/stub/e
    //   1021: astore 14
    //   1023: aload 14
    //   1025: ifnull +24 -> 1049
    //   1028: aload 14
    //   1030: astore_2
    //   1031: invokestatic 436	java/lang/System:currentTimeMillis	()J
    //   1034: aload 14
    //   1036: getfield 439	com/tencent/mm/plugin/base/stub/e:sfw	J
    //   1039: lsub
    //   1040: aload 14
    //   1042: getfield 442	com/tencent/mm/plugin/base/stub/e:lLH	J
    //   1045: lcmp
    //   1046: ifle +5 -> 1051
    //   1049: aconst_null
    //   1050: astore_2
    //   1051: aload_2
    //   1052: ifnull +150 -> 1202
    //   1055: aload_2
    //   1056: getfield 445	com/tencent/mm/plugin/base/stub/e:sfv	Ljava/lang/String;
    //   1059: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1062: ifne +140 -> 1202
    //   1065: ldc 185
    //   1067: ldc_w 447
    //   1070: invokestatic 449	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1073: invokestatic 133	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1076: aload_2
    //   1077: getfield 445	com/tencent/mm/plugin/base/stub/e:sfv	Ljava/lang/String;
    //   1080: aload_1
    //   1081: invokestatic 453	com/tencent/mm/pluginsdk/g:W	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   1084: pop
    //   1085: aload_1
    //   1086: aload 22
    //   1088: aload 21
    //   1090: iload 8
    //   1092: iconst_2
    //   1093: iconst_0
    //   1094: invokestatic 300	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   1097: pop
    //   1098: getstatic 67	com/tencent/mm/plugin/base/stub/f:sgb	Z
    //   1101: ifeq +311 -> 1412
    //   1104: invokestatic 458	android/os/SystemClock:elapsedRealtime	()J
    //   1107: getstatic 69	com/tencent/mm/plugin/base/stub/f:sgc	J
    //   1110: lsub
    //   1111: lstore 10
    //   1113: lload 10
    //   1115: lconst_0
    //   1116: lcmp
    //   1117: iflt +16 -> 1133
    //   1120: lload 10
    //   1122: lstore 12
    //   1124: lload 10
    //   1126: ldc2_w 459
    //   1129: lcmp
    //   1130: ifle +6 -> 1136
    //   1133: lconst_0
    //   1134: lstore 12
    //   1136: lload 12
    //   1138: ldc2_w 461
    //   1141: lcmp
    //   1142: ifle +8 -> 1150
    //   1145: bipush 20
    //   1147: invokestatic 93	com/tencent/mm/plugin/base/stub/f:Gh	(I)V
    //   1150: getstatic 99	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1153: sipush 19218
    //   1156: iconst_5
    //   1157: anewarray 4	java/lang/Object
    //   1160: dup
    //   1161: iconst_0
    //   1162: aload 24
    //   1164: aastore
    //   1165: dup
    //   1166: iconst_1
    //   1167: aload 22
    //   1169: aastore
    //   1170: dup
    //   1171: iconst_2
    //   1172: aload 21
    //   1174: aastore
    //   1175: dup
    //   1176: iconst_3
    //   1177: aload 23
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_4
    //   1182: lload 12
    //   1184: ldc2_w 463
    //   1187: ldiv
    //   1188: invokestatic 469	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1191: aastore
    //   1192: invokevirtual 472	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1195: ldc 183
    //   1197: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1200: aconst_null
    //   1201: areturn
    //   1202: new 121	android/content/Intent
    //   1205: dup
    //   1206: aload_0
    //   1207: ldc_w 474
    //   1210: invokespecial 477	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1213: astore_2
    //   1214: aload_2
    //   1215: aload_1
    //   1216: invokestatic 483	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1219: invokevirtual 487	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1222: pop
    //   1223: aload_2
    //   1224: ldc 123
    //   1226: invokevirtual 490	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1229: pop
    //   1230: aload_2
    //   1231: ldc_w 492
    //   1234: aload 24
    //   1236: invokevirtual 151	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1239: pop
    //   1240: aload_2
    //   1241: ldc_w 494
    //   1244: aload 23
    //   1246: invokevirtual 151	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1249: pop
    //   1250: aload_2
    //   1251: ldc_w 496
    //   1254: aload 22
    //   1256: invokevirtual 151	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1259: pop
    //   1260: aload_2
    //   1261: ldc_w 498
    //   1264: iconst_1
    //   1265: invokevirtual 501	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1268: pop
    //   1269: aload_2
    //   1270: ldc_w 503
    //   1273: aload 21
    //   1275: invokevirtual 151	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1278: pop
    //   1279: iload 5
    //   1281: ifeq +118 -> 1399
    //   1284: aload_2
    //   1285: ldc_w 505
    //   1288: iconst_1
    //   1289: invokevirtual 156	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1292: pop
    //   1293: aload_2
    //   1294: ldc_w 507
    //   1297: aload 23
    //   1299: invokevirtual 151	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1302: pop
    //   1303: aload_2
    //   1304: ldc_w 509
    //   1307: bipush 29
    //   1309: invokevirtual 501	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1312: pop
    //   1313: invokestatic 515	com/tencent/mm/model/ad:beh	()Lcom/tencent/mm/model/ad;
    //   1316: ldc_w 517
    //   1319: iconst_1
    //   1320: invokevirtual 520	com/tencent/mm/model/ad:I	(Ljava/lang/String;Z)Lcom/tencent/mm/model/ad$b;
    //   1323: astore_1
    //   1324: aload_1
    //   1325: ldc_w 496
    //   1328: aload 22
    //   1330: invokevirtual 526	com/tencent/mm/model/ad$b:k	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1333: pop
    //   1334: aload_1
    //   1335: ldc_w 503
    //   1338: aload 21
    //   1340: invokevirtual 526	com/tencent/mm/model/ad$b:k	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1343: pop
    //   1344: aload_1
    //   1345: ldc_w 528
    //   1348: iload 8
    //   1350: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1353: invokevirtual 526	com/tencent/mm/model/ad$b:k	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1356: pop
    //   1357: ldc 185
    //   1359: ldc_w 530
    //   1362: iconst_3
    //   1363: anewarray 4	java/lang/Object
    //   1366: dup
    //   1367: iconst_0
    //   1368: aload 22
    //   1370: aastore
    //   1371: dup
    //   1372: iconst_1
    //   1373: aload 21
    //   1375: aastore
    //   1376: dup
    //   1377: iconst_2
    //   1378: iload 8
    //   1380: invokestatic 285	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1383: aastore
    //   1384: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1387: iconst_2
    //   1388: invokestatic 93	com/tencent/mm/plugin/base/stub/f:Gh	(I)V
    //   1391: aload_2
    //   1392: aload_0
    //   1393: invokestatic 534	com/tencent/mm/plugin/base/stub/f:t	(Landroid/content/Intent;Landroid/content/Context;)V
    //   1396: goto -298 -> 1098
    //   1399: aload_2
    //   1400: ldc_w 509
    //   1403: bipush 19
    //   1405: invokevirtual 501	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1408: pop
    //   1409: goto -96 -> 1313
    //   1412: lconst_0
    //   1413: lstore 10
    //   1415: goto -302 -> 1113
    //   1418: astore 19
    //   1420: ldc 230
    //   1422: astore 15
    //   1424: aload 18
    //   1426: astore_2
    //   1427: aload 17
    //   1429: astore 14
    //   1431: aload_1
    //   1432: astore 17
    //   1434: aload 19
    //   1436: astore_1
    //   1437: goto -777 -> 660
    //   1440: astore 18
    //   1442: aload_1
    //   1443: astore 17
    //   1445: aload 18
    //   1447: astore_1
    //   1448: goto -788 -> 660
    //   1451: astore 18
    //   1453: ldc 230
    //   1455: astore 15
    //   1457: aload 19
    //   1459: astore_2
    //   1460: aload 20
    //   1462: astore 14
    //   1464: aload_1
    //   1465: astore 17
    //   1467: aload 18
    //   1469: astore_1
    //   1470: goto -841 -> 629
    //   1473: astore 18
    //   1475: aload_1
    //   1476: astore 17
    //   1478: aload 18
    //   1480: astore_1
    //   1481: goto -852 -> 629
    //   1484: ldc 230
    //   1486: astore_1
    //   1487: goto -1053 -> 434
    //   1490: iconst_0
    //   1491: istore 8
    //   1493: goto -1295 -> 198
    //   1496: ldc 230
    //   1498: astore 16
    //   1500: goto -1317 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1503	0	paramContext	Context
    //   0	1503	1	paramArrayOfString1	String[]
    //   0	1503	2	paramArrayOfString2	String[]
    //   0	1503	3	paramBoolean1	boolean
    //   0	1503	4	paramBoolean2	boolean
    //   0	1503	5	paramBoolean3	boolean
    //   0	1503	6	paramBoolean4	boolean
    //   163	435	7	i	int
    //   196	1296	8	j	int
    //   309	3	9	k	int
    //   1111	303	10	l1	long
    //   1122	61	12	l2	long
    //   24	1439	14	localObject1	Object
    //   27	1429	15	localObject2	Object
    //   181	266	16	str1	String
    //   682	14	16	localException	Exception
    //   1498	1	16	str2	String
    //   210	1267	17	localObject3	Object
    //   214	1211	18	localObject4	Object
    //   1440	6	18	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   1451	17	18	localg1	com.tencent.mm.ad.g
    //   1473	6	18	localg2	com.tencent.mm.ad.g
    //   323	48	19	arrayOfString	String[]
    //   1418	40	19	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   327	1134	20	localObject5	Object
    //   35	1339	21	localObject6	Object
    //   31	1338	22	localObject7	Object
    //   151	1147	23	str3	String
    //   141	1094	24	str4	String
    //   267	110	25	locali	com.tencent.mm.ad.i
    // Exception table:
    //   from	to	target	type
    //   216	223	624	com/tencent/mm/ad/g
    //   231	246	624	com/tencent/mm/ad/g
    //   254	269	624	com/tencent/mm/ad/g
    //   277	291	624	com/tencent/mm/ad/g
    //   297	311	624	com/tencent/mm/ad/g
    //   610	618	624	com/tencent/mm/ad/g
    //   216	223	651	java/io/UnsupportedEncodingException
    //   231	246	651	java/io/UnsupportedEncodingException
    //   254	269	651	java/io/UnsupportedEncodingException
    //   277	291	651	java/io/UnsupportedEncodingException
    //   297	311	651	java/io/UnsupportedEncodingException
    //   610	618	651	java/io/UnsupportedEncodingException
    //   446	453	682	java/lang/Exception
    //   329	339	1418	java/io/UnsupportedEncodingException
    //   353	362	1418	java/io/UnsupportedEncodingException
    //   376	386	1418	java/io/UnsupportedEncodingException
    //   386	424	1440	java/io/UnsupportedEncodingException
    //   329	339	1451	com/tencent/mm/ad/g
    //   353	362	1451	com/tencent/mm/ad/g
    //   376	386	1451	com/tencent/mm/ad/g
    //   386	424	1473	com/tencent/mm/ad/g
  }
  
  private static MatrixCursor a(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(22239);
    if ((Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      Log.e("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink:packageName or signature null");
      AppMethodBeat.o(22239);
      return null;
    }
    Object localObject2 = new LinkedList();
    Object localObject1 = new ef();
    Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink package name = %s, cgiType=%d", new Object[] { paramString2, Integer.valueOf(paramInt2) });
    ((ef)localObject1).ufq = paramString2;
    ((ef)localObject1).signature = paramString3;
    ((LinkedList)localObject2).add(localObject1);
    localObject1 = new com.tencent.mm.an.d.a();
    ((com.tencent.mm.an.d.a)localObject1).lBU = new euu();
    ((com.tencent.mm.an.d.a)localObject1).lBV = new euv();
    ((com.tencent.mm.an.d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((com.tencent.mm.an.d.a)localObject1).funcId = 1200;
    d locald = ((com.tencent.mm.an.d.a)localObject1).bgN();
    euu localeuu = (euu)com.tencent.mm.an.d.b.b(locald.lBR);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (1 == paramInt2) {
      localObject1 = "&preload=1";
    }
    for (;;)
    {
      localeuu.link = ((String)localObject1);
      localStringBuilder = new StringBuilder().append(localeuu.link);
      if (2 == paramInt2)
      {
        localObject1 = "&jsForReport=1";
        localeuu.link = ((String)localObject1);
        localeuu.scene = 1;
        localeuu.Uwx = ((LinkedList)localObject2);
        localObject2 = new CountDownLatch(1);
        localObject1 = new MatrixCursor(new String[] { "downloadUrl", "fileMd5", "expireTime", "extraBytes" });
        aa.a(locald, new aa.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
          {
            AppMethodBeat.i(22228);
            Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(this.sgh) });
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              f.E(false, this.sgh);
              AppMethodBeat.o(22228);
              return 0;
            }
            f.E(true, this.sgh);
            paramAnonymousString = ((euv)d.c.b(paramAnonymousd.lBS)).Uwy;
            paramAnonymousd = Uri.parse(paramAnonymousString);
            paramAnonymousd.getQueryParameter("appid");
            paramAnonymousq = paramAnonymousd.getQueryParameter("userName");
            String str = paramAnonymousd.getQueryParameter("path");
            long l = Util.safeParseLong(paramAnonymousd.getQueryParameter("validTime"));
            f.a(paramString1, this.sgj, paramString2, paramString3, paramInt1, paramAnonymousString, l);
            if (this.sgh != 1)
            {
              AppMethodBeat.o(22228);
              return 0;
            }
            ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).ey(paramAnonymousq, str);
            if (paramBoolean) {
              f.a(paramAnonymousq, str, this.sgm, this.val$countDownLatch);
            }
            for (;;)
            {
              AppMethodBeat.o(22228);
              return 0;
              ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).a(paramAnonymousq, new androidx.a.a.c.a()
              {
                private static Void l(WxaAttributes paramAnonymous2WxaAttributes)
                {
                  AppMethodBeat.i(281108);
                  if (paramAnonymous2WxaAttributes != null) {}
                  try
                  {
                    if (paramAnonymous2WxaAttributes.bLF().Qv()) {
                      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).c(z.qOZ);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(281108);
                      return null;
                      if (!paramAnonymous2WxaAttributes.bLF().bLL()) {
                        break;
                      }
                      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.qOZ);
                    }
                  }
                  catch (Exception paramAnonymous2WxaAttributes)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.WXBizLogic", paramAnonymous2WxaAttributes, "prefetchWxaAttrs-preloadEnv", new Object[0]);
                      continue;
                      ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).b(z.qOZ);
                    }
                  }
                }
              });
            }
          }
        });
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
  
  public static void a(Activity paramActivity, Uri paramUri, int paramInt, String paramString1, String paramString2, final Runnable paramRunnable)
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
    ef localef = new ef();
    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { paramString1 });
    localef.ufq = paramString1;
    localef.signature = paramString2;
    localLinkedList.add(localef);
    paramUri = new ac(paramUri.toString(), paramInt, localLinkedList);
    paramActivity = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
      {
        AppMethodBeat.i(22227);
        bh.aGY().b(1200, this);
        Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
          f.M(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousString = ((ac)paramAnonymousq).boS();
        Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramAnonymousString });
        try
        {
          paramAnonymousString = Uri.parse(paramAnonymousString);
          if (paramAnonymousString == null)
          {
            Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
            f.M(this.val$activity);
            AppMethodBeat.o(22227);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramAnonymousString });
          f.M(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousq = paramAnonymousString.getQueryParameter("result");
        if (paramAnonymousq != null)
        {
          paramAnonymousq = URLDecoder.decode(paramAnonymousq);
          Log.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramAnonymousq });
          cv localcv = new cv();
          localcv.fyr.activity = this.val$activity;
          localcv.fyr.fwI = paramAnonymousq;
          localcv.fyr.fys = 19;
          localcv.fyr.from = 3;
          localcv.fyr.fyu = paramAnonymousString.getQueryParameter("appid");
          localcv.fyr.fyw = this.val$activity.getIntent().getBundleExtra("_stat_obj");
          EventCenter.instance.publish(localcv);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22226);
              f.1.this.val$activity.finish();
              AppMethodBeat.o(22226);
            }
          }, 100L);
        }
        AppMethodBeat.o(22227);
      }
    };
    bh.aGY().a(1200, paramActivity);
    bh.aGY().a(paramUri, 0);
    AppMethodBeat.o(22231);
  }
  
  static void a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(291830);
    WXLaunchWxaRedirectingPage.Resp localResp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
    localResp.invokeTicket = paramReq.invokeTicket;
    localResp.callbackActivity = paramReq.callbackActivity;
    localResp.errCode = paramInt;
    localResp.errStr = paramString2;
    paramReq = new Bundle();
    localResp.toBundle(paramReq);
    com.tencent.mm.pluginsdk.model.app.q.bm(paramReq);
    com.tencent.mm.pluginsdk.model.app.q.bn(paramReq);
    paramString2 = new MMessageActV2.Args();
    paramString2.targetPkgName = paramString1;
    paramString2.bundle = paramReq;
    MMessageActV2.send(paramContext, paramString2);
    if ((paramContext instanceof WXBizEntryActivity)) {
      ((WXBizEntryActivity)paramContext).finish();
    }
    AppMethodBeat.o(291830);
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
    paramString2.lLH = System.currentTimeMillis();
    paramString2.sfv = paramString4;
    if (paramLong > 0L) {
      paramString2.sfw = (1000L * paramLong);
    }
    sfX.put(paramString1, paramString2);
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
        localObject1 = g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0])[0].toByteArray());
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
  
  private static void aa(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161302);
      if (cxm())
      {
        Gh(31);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry saveWXBizEntryIntent enterId=%d", new Object[] { Long.valueOf(l) });
        paramIntent.putExtra("__BIZ_ENTRY_ENTER_ID", l);
        sfY = paramIntent;
        cxo();
      }
      AppMethodBeat.o(161302);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void ab(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 732
    //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 718	com/tencent/mm/plugin/base/stub/f:cxm	()Z
    //   12: ifne +13 -> 25
    //   15: ldc_w 732
    //   18: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: ldc_w 722
    //   29: lconst_0
    //   30: invokevirtual 736	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +16 -> 53
    //   40: getstatic 61	com/tencent/mm/plugin/base/stub/f:sfZ	Ljava/util/Set;
    //   43: lload_1
    //   44: invokestatic 469	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokeinterface 739 2 0
    //   52: pop
    //   53: invokestatic 742	com/tencent/mm/plugin/base/stub/f:cxn	()V
    //   56: ldc 185
    //   58: ldc_w 744
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 469	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 570	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: ldc_w 732
    //   78: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean ac(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161306);
      long l = paramIntent.getLongExtra("__BIZ_ENTRY_ENTER_ID", 0L);
      Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry isInConsumedSet %d", new Object[] { Long.valueOf(l) });
      boolean bool = sfZ.contains(Long.valueOf(l));
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
        str1 = g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0])[0].toByteArray());
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
      com.tencent.mm.pluginsdk.ui.tools.o.RxF = paramArrayOfString1[4];
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length > 5)
    {
      paramArrayOfString1 = paramArrayOfString1[5];
      paramArrayOfString2 = paramArrayOfString1;
      if (com.tencent.mm.kernel.h.aHB())
      {
        com.tencent.mm.pluginsdk.model.app.h.o(str4, true, false);
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
      paramArrayOfString1 = URLEncoder.encode(new com.tencent.mm.ad.i(str3).optString("extData"), "utf-8");
      if (bool)
      {
        localObject2 = "openNativeView";
        paramArrayOfString1 = String.format("weixin://dl/%s/?appid=%s&businessType=%s&extdata=%s", new Object[] { localObject2, str4, str5, paramArrayOfString1 });
        Log.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", new Object[] { paramArrayOfString1, str2, str3 });
        if ("nativeOpenAdCanvas".equals(str5)) {
          com.tencent.mm.plugin.sns.ad.h.a.fU(com.tencent.mm.plugin.sns.ad.h.a.ko(str4, str3), 1);
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
          int j = new com.tencent.mm.ad.i(str3).optInt("miniProgramType", 0);
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
          paramContext = ad.beh().I("key_data_center_session_id", true);
          paramContext.k("key_launch_miniprogram_type", Integer.valueOf(i));
          paramContext.k("key_launch_miniprogram_query_info", str2);
          paramContext.k("key_open_business_view_ext_info", str3);
          paramContext.k("key_launch_mini_program_open_id", paramArrayOfString2);
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
    AppMethodBeat.i(291817);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(291817);
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
        paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0]);
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
      AppMethodBeat.o(291817);
      return false;
    }
    String str6 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str6))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(291817);
      return false;
    }
    String str7 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str7))
    {
      Log.e("MicroMsg.WXBizLogic", "videoPath isEmpty");
      AppMethodBeat.o(291817);
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
    paramArrayOfString1 = "";
    localObject3 = "";
    try
    {
      localObject1 = URLEncoder.encode(paramArrayOfString2, "UTF-8");
      paramArrayOfString1 = (String[])localObject1;
      String str5 = URLEncoder.encode(str3, "UTF-8");
      paramArrayOfString1 = str5;
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
    paramArrayOfString1 = String.format("weixin://dl/channels/shareVideo/?appid=%s&title=%s&url=%s", new Object[] { str6, localObject3, localObject1 });
    Log.i("MicroMsg.WXBizLogic", "finderShareVideo: appid = %s, videoPath = %s, title = %s, url = %s, extData = %s", new Object[] { str6, str7, paramArrayOfString2, str3, str4 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_app_id", str6);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", str2);
    paramArrayOfString2.putExtra("key_command_id", 33);
    paramArrayOfString2.putExtra("key_finder_video_path", str7);
    t(paramArrayOfString2, paramContext);
    AppMethodBeat.o(291817);
    return true;
  }
  
  public static void cxj()
  {
    AppMethodBeat.i(179576);
    Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetCallingPackageNull");
    com.tencent.mm.plugin.report.service.h.IzE.p(1194L, 50L, 1L);
    AppMethodBeat.o(179576);
  }
  
  public static void cxk()
  {
    AppMethodBeat.i(179577);
    Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetPackagesForUidMoreThanOne");
    com.tencent.mm.plugin.report.service.h.IzE.p(1194L, 51L, 1L);
    AppMethodBeat.o(179577);
  }
  
  public static void cxl()
  {
    AppMethodBeat.i(291824);
    com.tencent.mm.plugin.report.service.h.IzE.a(1194, new Object[] { Integer.valueOf(60), Integer.valueOf(1) });
    AppMethodBeat.o(291824);
  }
  
  public static boolean cxm()
  {
    AppMethodBeat.i(161300);
    if (sga != -1)
    {
      if (sga == 1)
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
    sga = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vAy, 1);
    Log.i("MicroMsg.WXBizLogic", "reTryOpenWXBizEntry open %d", new Object[] { Integer.valueOf(sga) });
    if (sga == 1)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    AppMethodBeat.o(161300);
    return false;
  }
  
  private static void cxn()
  {
    try
    {
      sfY = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void cxo()
  {
    AppMethodBeat.i(169736);
    if (appForegroundListener == null)
    {
      o.a local6 = new o.a()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          AppMethodBeat.i(279469);
          Log.d("MicroMsg.WXBizLogic", "turn onAppBackground");
          f.lm(false);
          AppMethodBeat.o(279469);
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          AppMethodBeat.i(279468);
          f.lm(true);
          f.Hl(SystemClock.elapsedRealtime());
          Log.d("MicroMsg.WXBizLogic", "turn onAppForeground");
          if ((f.cxu() != null) && (com.tencent.mm.kernel.h.aHB()))
          {
            Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry onAppForeground");
            f.cxq();
          }
          AppMethodBeat.o(279468);
        }
      };
      appForegroundListener = local6;
      local6.alive();
    }
    AppMethodBeat.o(169736);
  }
  
  public static void cxp()
  {
    AppMethodBeat.i(161303);
    sgb = true;
    sgc = SystemClock.elapsedRealtime();
    cxq();
    AppMethodBeat.o(161303);
  }
  
  public static void cxq()
  {
    AppMethodBeat.i(169737);
    cxo();
    if ((sfY == null) || (!cxm()))
    {
      AppMethodBeat.o(169737);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(274226);
        f.cxr();
        AppMethodBeat.o(274226);
      }
    }, 50L);
    AppMethodBeat.o(169737);
  }
  
  /* Error */
  public static void cxr()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 897
    //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 185
    //   11: ldc_w 899
    //   14: invokestatic 901	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 727	com/tencent/mm/plugin/base/stub/f:sfY	Landroid/content/Intent;
    //   20: ifnonnull +13 -> 33
    //   23: ldc_w 897
    //   26: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: getstatic 727	com/tencent/mm/plugin/base/stub/f:sfY	Landroid/content/Intent;
    //   36: ldc_w 722
    //   39: lconst_0
    //   40: invokevirtual 736	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   43: lstore_0
    //   44: invokestatic 436	java/lang/System:currentTimeMillis	()J
    //   47: lload_0
    //   48: lsub
    //   49: lstore_0
    //   50: getstatic 727	com/tencent/mm/plugin/base/stub/f:sfY	Landroid/content/Intent;
    //   53: invokestatic 903	com/tencent/mm/plugin/base/stub/f:ac	(Landroid/content/Intent;)Z
    //   56: ifne +132 -> 188
    //   59: lload_0
    //   60: invokestatic 908	java/lang/Math:abs	(J)J
    //   63: ldc2_w 461
    //   66: lcmp
    //   67: ifge +121 -> 188
    //   70: ldc 185
    //   72: ldc_w 910
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_0
    //   82: invokestatic 469	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: getstatic 727	com/tencent/mm/plugin/base/stub/f:sfY	Landroid/content/Intent;
    //   92: ldc_w 912
    //   95: iconst_1
    //   96: invokevirtual 156	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   99: pop
    //   100: invokestatic 133	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   103: astore_2
    //   104: getstatic 727	com/tencent/mm/plugin/base/stub/f:sfY	Landroid/content/Intent;
    //   107: astore_3
    //   108: new 914	com/tencent/mm/hellhoundlib/b/a
    //   111: dup
    //   112: invokespecial 915	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   115: aload_3
    //   116: invokevirtual 918	com/tencent/mm/hellhoundlib/b/a:bm	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   119: astore_3
    //   120: aload_2
    //   121: aload_3
    //   122: invokevirtual 922	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   125: ldc_w 924
    //   128: ldc_w 926
    //   131: ldc_w 927
    //   134: ldc_w 929
    //   137: ldc_w 931
    //   140: ldc_w 932
    //   143: invokestatic 937	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_3
    //   148: iconst_0
    //   149: invokevirtual 941	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   152: checkcast 121	android/content/Intent
    //   155: invokevirtual 945	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   158: aload_2
    //   159: ldc_w 924
    //   162: ldc_w 926
    //   165: ldc_w 927
    //   168: ldc_w 929
    //   171: ldc_w 931
    //   174: ldc_w 932
    //   177: invokestatic 948	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokestatic 742	com/tencent/mm/plugin/base/stub/f:cxn	()V
    //   183: bipush 30
    //   185: invokestatic 93	com/tencent/mm/plugin/base/stub/f:Gh	(I)V
    //   188: ldc_w 897
    //   191: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void cxs()
  {
    AppMethodBeat.i(179578);
    try
    {
      int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vyX, 1);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        sgd = bool;
        Log.i("MicroMsg.WXBizLogic", "alvinluo updateGetCallingPackageStatus config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(sgd) });
        AppMethodBeat.o(179578);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WXBizLogic", localException, "alvinluo updateGetCallingPackageStatus exception", new Object[0]);
      sgd = true;
      AppMethodBeat.o(179578);
    }
  }
  
  public static boolean cxt()
  {
    return sgd;
  }
  
  public static boolean d(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(291819);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(291819);
      return false;
    }
    String str1;
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      str1 = paramArrayOfString2[0];
      paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0]);
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
        AppMethodBeat.o(291819);
        return false;
      }
      String str2 = paramArrayOfString1[0];
      if (Util.isNullOrNil(str2))
      {
        Log.e("MicroMsg.WXBizLogic", "appId is null");
        AppMethodBeat.o(291819);
        return false;
      }
      String str3 = paramArrayOfString1[1];
      if (Util.isNullOrNil(str3))
      {
        Log.e("MicroMsg.WXBizLogic", "username isEmpty");
        AppMethodBeat.o(291819);
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
      AppMethodBeat.o(291819);
      return true;
      paramArrayOfString2 = null;
      continue;
      paramArrayOfString2 = null;
      str1 = null;
    }
  }
  
  public static boolean e(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(291820);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(291820);
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
        paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0]);
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
      AppMethodBeat.o(291820);
      return false;
    }
    String str3 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str3))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(291820);
      return false;
    }
    String str4 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.WXBizLogic", "feedID isEmpty");
      AppMethodBeat.o(291820);
      return false;
    }
    String str5 = paramArrayOfString1[2];
    if (Util.isNullOrNil(str5))
    {
      Log.e("MicroMsg.WXBizLogic", "nonceID isEmpty");
      AppMethodBeat.o(291820);
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
    AppMethodBeat.o(291820);
    return true;
  }
  
  public static boolean f(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(291821);
    if (paramContext == null)
    {
      Log.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(291821);
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
        paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0]);
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
      AppMethodBeat.o(291821);
      return false;
    }
    String str2 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(291821);
      return false;
    }
    String str3 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str3))
    {
      Log.e("MicroMsg.WXBizLogic", "feedID isEmpty");
      AppMethodBeat.o(291821);
      return false;
    }
    String str4 = paramArrayOfString1[2];
    if (Util.isNullOrNil(str4))
    {
      Log.e("MicroMsg.WXBizLogic", "nonceID isEmpty");
      AppMethodBeat.o(291821);
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
      AppMethodBeat.o(291821);
      return true;
    }
  }
  
  static void g(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(291829);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WXBizLogic", "doLaunchWxaRedirectingPage, context==null[%b], args[%s], packages[%s]", new Object[] { Boolean.valueOf(bool), Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      Gj(1);
      if ((paramContext != null) && (paramArrayOfString2 != null) && (paramArrayOfString2[0].length() > 0)) {
        break;
      }
      Gj(2);
      AppMethodBeat.o(291829);
      return;
    }
    WXLaunchWxaRedirectingPage.Req localReq = new WXLaunchWxaRedirectingPage.Req();
    String str = paramArrayOfString1[0];
    try
    {
      if (TextUtils.isEmpty(str))
      {
        Gj(2);
        AppMethodBeat.o(291829);
        return;
      }
      localReq.fromArray((String[])org.apache.commons.b.a.h(paramArrayOfString1, paramArrayOfString1.length));
      paramArrayOfString1 = new Intent(paramContext, WXBizEntryActivity.class);
      paramArrayOfString1.setData(Uri.parse(String.format(Locale.ENGLISH, "weixin://dl/wmpf/sdk?appid=%s&ticket=%s", new Object[] { str, localReq.invokeTicket })));
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.putExtra("translate_link_scene", 1);
      paramArrayOfString1.putExtra("key_package_name", paramArrayOfString2[0]);
      paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.cv(paramContext, paramArrayOfString2[0]);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {
        paramArrayOfString1.putExtra("key_package_signature", g.getMessageDigest(paramArrayOfString2[0].toByteArray()));
      }
      paramArrayOfString2 = new Bundle();
      localReq.toBundle(paramArrayOfString2);
      paramArrayOfString1.putExtra("key_launch_wxa_redirecting_page_req", paramArrayOfString2);
      paramArrayOfString1.putExtra("key_command_id", 30);
      t(paramArrayOfString1, paramContext);
      AppMethodBeat.o(291829);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.WXBizLogic", paramContext, "doLaunchWxaFRedirectingPage args[%s] packages[%s]", new Object[] { Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      Gj(2);
      AppMethodBeat.o(291829);
    }
  }
  
  public static void t(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(161301);
      aa(paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
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
  
  public static boolean t(String[] paramArrayOfString)
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
  
  static MatrixCursor u(String[] paramArrayOfString)
  {
    AppMethodBeat.i(291831);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramArrayOfString = new MatrixCursor(new String[0], 0);
      AppMethodBeat.o(291831);
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
        if (!org.apache.commons.b.a.contains(sge, localObject)) {
          break label166;
        }
        str = "1";
        localObject = arrayOfString;
      }
      AppMethodBeat.o(291831);
      return localMatrixCursor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f
 * JD-Core Version:    0.7.0.1
 */