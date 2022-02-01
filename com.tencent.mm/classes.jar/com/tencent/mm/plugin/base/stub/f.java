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
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.ekq;
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
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static o.a appForegroundListener;
  private static Map<String, e> pdU;
  private static Intent pdV;
  public static final Set<Long> pdW;
  private static int pdX;
  private static boolean pdY;
  private static long pdZ;
  private static boolean pea;
  private static final String[] peb;
  
  static
  {
    AppMethodBeat.i(22242);
    pdU = new HashMap();
    pdW = new HashSet();
    pdX = -1;
    appForegroundListener = null;
    pdY = false;
    pdZ = 0L;
    pea = true;
    peb = new String[] { "sdk_openAppProfile", "sdk_openFeedback", "sdk_openGrowthCare", "sdk_navigateToMiniProgram" };
    AppMethodBeat.o(22242);
  }
  
  public static void CD(int paramInt)
  {
    AppMethodBeat.i(22238);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1194L, paramInt, 1L, false);
    AppMethodBeat.o(22238);
  }
  
  static void CE(int paramInt)
  {
    AppMethodBeat.i(231620);
    com.tencent.mm.plugin.report.service.h.CyF.dN(1405, paramInt);
    AppMethodBeat.o(231620);
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
    //   0: ldc 164
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 166
    //   11: ldc 168
    //   13: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 164
    //   18: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   63: invokestatic 180	com/tencent/mm/pluginsdk/model/app/q:cj	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   66: iconst_0
    //   67: aaload
    //   68: invokevirtual 186	android/content/pm/Signature:toByteArray	()[B
    //   71: invokestatic 192	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   74: astore 21
    //   76: ldc 166
    //   78: ldc 194
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
    //   94: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: ifnull +9 -> 107
    //   101: aload_1
    //   102: arraylength
    //   103: iconst_2
    //   104: if_icmpge +17 -> 121
    //   107: ldc 166
    //   109: ldc 199
    //   111: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: ldc 164
    //   116: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aconst_null
    //   120: areturn
    //   121: getstatic 205	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:GlobalAppbrand	Lcom/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries;
    //   124: aload_0
    //   125: invokevirtual 209	com/tencent/mm/sdk/platformtools/WeChatBrands$Business$Entries:checkAvailable	(Landroid/content/Context;)Z
    //   128: ifne +10 -> 138
    //   131: ldc 164
    //   133: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: aload_1
    //   139: iconst_0
    //   140: aaload
    //   141: astore 24
    //   143: iload 6
    //   145: ifne +441 -> 586
    //   148: aload_1
    //   149: iconst_1
    //   150: aaload
    //   151: astore 23
    //   153: ldc 211
    //   155: astore 15
    //   157: iload 5
    //   159: ifeq +434 -> 593
    //   162: iconst_3
    //   163: istore 7
    //   165: ldc 211
    //   167: astore 14
    //   169: ldc 211
    //   171: astore_2
    //   172: aload_1
    //   173: arraylength
    //   174: iconst_2
    //   175: if_icmple +1318 -> 1493
    //   178: aload_1
    //   179: iconst_2
    //   180: aaload
    //   181: astore 16
    //   183: aload_1
    //   184: arraylength
    //   185: iconst_3
    //   186: if_icmple +1301 -> 1487
    //   189: aload_1
    //   190: iconst_3
    //   191: aaload
    //   192: iconst_0
    //   193: invokestatic 217	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   196: istore 8
    //   198: aload_1
    //   199: arraylength
    //   200: iconst_4
    //   201: if_icmple +1280 -> 1481
    //   204: aload_1
    //   205: iconst_4
    //   206: aaload
    //   207: astore_1
    //   208: aload 15
    //   210: astore 17
    //   212: aload 15
    //   214: astore 18
    //   216: aload_1
    //   217: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   220: ifne +379 -> 599
    //   223: aload 15
    //   225: astore 17
    //   227: aload 15
    //   229: astore 18
    //   231: ldc 166
    //   233: ldc 223
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: aastore
    //   243: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload 15
    //   248: astore 17
    //   250: aload 15
    //   252: astore 18
    //   254: new 228	com/tencent/mm/ab/i
    //   257: dup
    //   258: aload_1
    //   259: ldc 230
    //   261: invokestatic 236	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   264: invokespecial 239	com/tencent/mm/ab/i:<init>	(Ljava/lang/String;)V
    //   267: astore 25
    //   269: aload 15
    //   271: astore 17
    //   273: aload 15
    //   275: astore 18
    //   277: aload 25
    //   279: ldc 241
    //   281: invokevirtual 245	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: ldc 230
    //   286: invokestatic 250	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   289: astore_1
    //   290: aload_1
    //   291: astore 17
    //   293: aload_1
    //   294: astore 18
    //   296: aload 25
    //   298: ldc 252
    //   300: invokevirtual 245	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: iconst_0
    //   304: invokestatic 217	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   307: istore 9
    //   309: iload 9
    //   311: istore 7
    //   313: aload_2
    //   314: astore 18
    //   316: aload 14
    //   318: astore 17
    //   320: aload_2
    //   321: astore 19
    //   323: aload 14
    //   325: astore 20
    //   327: aload 25
    //   329: ldc 254
    //   331: invokevirtual 245	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: astore 14
    //   336: aload_2
    //   337: astore 18
    //   339: aload 14
    //   341: astore 17
    //   343: aload_2
    //   344: astore 19
    //   346: aload 14
    //   348: astore 20
    //   350: aload 25
    //   352: ldc_w 256
    //   355: invokevirtual 245	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   358: astore_2
    //   359: aload_2
    //   360: astore 18
    //   362: aload 14
    //   364: astore 17
    //   366: aload_2
    //   367: astore 19
    //   369: aload 14
    //   371: astore 20
    //   373: aload 25
    //   375: ldc_w 258
    //   378: invokevirtual 245	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   381: astore 15
    //   383: ldc 166
    //   385: ldc_w 260
    //   388: iconst_5
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload_1
    //   395: aastore
    //   396: dup
    //   397: iconst_1
    //   398: iload 7
    //   400: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: dup
    //   405: iconst_2
    //   406: aload 14
    //   408: aastore
    //   409: dup
    //   410: iconst_3
    //   411: aload_2
    //   412: aastore
    //   413: dup
    //   414: iconst_4
    //   415: aload 15
    //   417: aastore
    //   418: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: aload 15
    //   423: astore 17
    //   425: aload_1
    //   426: astore 15
    //   428: aload 17
    //   430: astore_1
    //   431: aload 16
    //   433: astore 17
    //   435: aload 16
    //   437: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   440: ifne +10 -> 450
    //   443: aload 16
    //   445: invokestatic 268	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   448: astore 17
    //   450: ldc 166
    //   452: ldc_w 270
    //   455: iconst_4
    //   456: anewarray 4	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: aload 24
    //   463: aastore
    //   464: dup
    //   465: iconst_1
    //   466: aload 23
    //   468: aastore
    //   469: dup
    //   470: iconst_2
    //   471: aload 17
    //   473: aastore
    //   474: dup
    //   475: iconst_3
    //   476: iload 8
    //   478: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   481: aastore
    //   482: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   485: iload 6
    //   487: ifne +221 -> 708
    //   490: ldc_w 272
    //   493: bipush 8
    //   495: anewarray 4	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload 24
    //   502: aastore
    //   503: dup
    //   504: iconst_1
    //   505: aload 23
    //   507: aastore
    //   508: dup
    //   509: iconst_2
    //   510: aload 17
    //   512: aastore
    //   513: dup
    //   514: iconst_3
    //   515: aload 15
    //   517: aastore
    //   518: dup
    //   519: iconst_4
    //   520: iload 7
    //   522: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: iconst_5
    //   528: aload 14
    //   530: aastore
    //   531: dup
    //   532: bipush 6
    //   534: aload_2
    //   535: aastore
    //   536: dup
    //   537: bipush 7
    //   539: aload_1
    //   540: aastore
    //   541: invokestatic 276	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   544: astore_1
    //   545: ldc 166
    //   547: ldc_w 278
    //   550: iconst_1
    //   551: anewarray 4	java/lang/Object
    //   554: dup
    //   555: iconst_0
    //   556: aload_1
    //   557: aastore
    //   558: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   561: iload_3
    //   562: ifeq +165 -> 727
    //   565: aload_1
    //   566: aload 22
    //   568: aload 21
    //   570: iload 8
    //   572: iconst_1
    //   573: iload 4
    //   575: invokestatic 281	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   578: astore_0
    //   579: ldc 164
    //   581: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   584: aload_0
    //   585: areturn
    //   586: ldc 211
    //   588: astore 23
    //   590: goto -437 -> 153
    //   593: iconst_0
    //   594: istore 7
    //   596: goto -431 -> 165
    //   599: aload 15
    //   601: astore 17
    //   603: aload 15
    //   605: astore 18
    //   607: ldc 166
    //   609: ldc_w 283
    //   612: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: ldc 211
    //   617: astore_1
    //   618: goto -187 -> 431
    //   621: astore_1
    //   622: ldc 211
    //   624: astore 15
    //   626: ldc 166
    //   628: aload_1
    //   629: ldc 211
    //   631: iconst_0
    //   632: anewarray 4	java/lang/Object
    //   635: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   638: aload 15
    //   640: astore_1
    //   641: aload 17
    //   643: astore 15
    //   645: goto -214 -> 431
    //   648: astore_1
    //   649: ldc 211
    //   651: astore 15
    //   653: aload 18
    //   655: astore 17
    //   657: ldc 166
    //   659: aload_1
    //   660: ldc 211
    //   662: iconst_0
    //   663: anewarray 4	java/lang/Object
    //   666: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   669: aload 15
    //   671: astore_1
    //   672: aload 17
    //   674: astore 15
    //   676: goto -245 -> 431
    //   679: astore 16
    //   681: ldc 166
    //   683: ldc_w 289
    //   686: iconst_1
    //   687: anewarray 4	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: aload 16
    //   694: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   697: aastore
    //   698: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   701: ldc 211
    //   703: astore 17
    //   705: goto -255 -> 450
    //   708: ldc_w 297
    //   711: iconst_1
    //   712: anewarray 4	java/lang/Object
    //   715: dup
    //   716: iconst_0
    //   717: aload 24
    //   719: aastore
    //   720: invokestatic 276	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   723: astore_1
    //   724: goto -179 -> 545
    //   727: iload 6
    //   729: ifeq +265 -> 994
    //   732: aload 22
    //   734: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   737: ifne +11 -> 748
    //   740: aload 21
    //   742: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   745: ifeq +18 -> 763
    //   748: ldc 166
    //   750: ldc_w 299
    //   753: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: ldc 164
    //   758: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   761: aconst_null
    //   762: areturn
    //   763: new 301	java/util/LinkedList
    //   766: dup
    //   767: invokespecial 302	java/util/LinkedList:<init>	()V
    //   770: astore_0
    //   771: new 304	com/tencent/mm/protocal/protobuf/eg
    //   774: dup
    //   775: invokespecial 305	com/tencent/mm/protocal/protobuf/eg:<init>	()V
    //   778: astore_2
    //   779: ldc 166
    //   781: ldc_w 307
    //   784: iconst_2
    //   785: anewarray 4	java/lang/Object
    //   788: dup
    //   789: iconst_0
    //   790: aload 22
    //   792: aastore
    //   793: dup
    //   794: iconst_1
    //   795: iconst_3
    //   796: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   799: aastore
    //   800: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   803: aload_2
    //   804: aload 22
    //   806: putfield 310	com/tencent/mm/protocal/protobuf/eg:qGp	Ljava/lang/String;
    //   809: aload_2
    //   810: aload 21
    //   812: putfield 313	com/tencent/mm/protocal/protobuf/eg:signature	Ljava/lang/String;
    //   815: aload_0
    //   816: aload_2
    //   817: invokevirtual 317	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   820: pop
    //   821: new 319	com/tencent/mm/ak/d$a
    //   824: dup
    //   825: invokespecial 320	com/tencent/mm/ak/d$a:<init>	()V
    //   828: astore_2
    //   829: aload_2
    //   830: new 322	com/tencent/mm/protocal/protobuf/ekp
    //   833: dup
    //   834: invokespecial 323	com/tencent/mm/protocal/protobuf/ekp:<init>	()V
    //   837: putfield 327	com/tencent/mm/ak/d$a:iLN	Lcom/tencent/mm/bw/a;
    //   840: aload_2
    //   841: new 329	com/tencent/mm/protocal/protobuf/ekq
    //   844: dup
    //   845: invokespecial 330	com/tencent/mm/protocal/protobuf/ekq:<init>	()V
    //   848: putfield 333	com/tencent/mm/ak/d$a:iLO	Lcom/tencent/mm/bw/a;
    //   851: aload_2
    //   852: ldc_w 335
    //   855: putfield 338	com/tencent/mm/ak/d$a:uri	Ljava/lang/String;
    //   858: aload_2
    //   859: sipush 1200
    //   862: putfield 341	com/tencent/mm/ak/d$a:funcId	I
    //   865: aload_2
    //   866: invokevirtual 345	com/tencent/mm/ak/d$a:aXF	()Lcom/tencent/mm/ak/d;
    //   869: astore_2
    //   870: aload_2
    //   871: getfield 351	com/tencent/mm/ak/d:iLK	Lcom/tencent/mm/ak/d$b;
    //   874: getfield 356	com/tencent/mm/ak/d$b:iLR	Lcom/tencent/mm/bw/a;
    //   877: checkcast 322	com/tencent/mm/protocal/protobuf/ekp
    //   880: astore 14
    //   882: aload 14
    //   884: new 358	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 359	java/lang/StringBuilder:<init>	()V
    //   891: aload_1
    //   892: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc_w 365
    //   898: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 368	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: putfield 371	com/tencent/mm/protocal/protobuf/ekp:link	Ljava/lang/String;
    //   907: aload 14
    //   909: iconst_1
    //   910: putfield 374	com/tencent/mm/protocal/protobuf/ekp:scene	I
    //   913: aload 14
    //   915: aload_0
    //   916: putfield 378	com/tencent/mm/protocal/protobuf/ekp:NjP	Ljava/util/LinkedList;
    //   919: ldc 166
    //   921: ldc_w 380
    //   924: iconst_1
    //   925: anewarray 4	java/lang/Object
    //   928: dup
    //   929: iconst_0
    //   930: aload 14
    //   932: getfield 371	com/tencent/mm/protocal/protobuf/ekp:link	Ljava/lang/String;
    //   935: aastore
    //   936: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   939: new 382	android/database/MatrixCursor
    //   942: dup
    //   943: iconst_4
    //   944: anewarray 63	java/lang/String
    //   947: dup
    //   948: iconst_0
    //   949: ldc_w 384
    //   952: aastore
    //   953: dup
    //   954: iconst_1
    //   955: ldc_w 386
    //   958: aastore
    //   959: dup
    //   960: iconst_2
    //   961: ldc_w 388
    //   964: aastore
    //   965: dup
    //   966: iconst_3
    //   967: ldc_w 390
    //   970: aastore
    //   971: invokespecial 393	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   974: astore_0
    //   975: aload_2
    //   976: new 395	com/tencent/mm/plugin/base/stub/f$3
    //   979: dup
    //   980: invokespecial 396	com/tencent/mm/plugin/base/stub/f$3:<init>	()V
    //   983: invokestatic 401	com/tencent/mm/ak/aa:a	(Lcom/tencent/mm/ak/d;Lcom/tencent/mm/ak/aa$a;)Lcom/tencent/mm/ak/d;
    //   986: pop
    //   987: ldc 164
    //   989: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   992: aload_0
    //   993: areturn
    //   994: aload_1
    //   995: iconst_1
    //   996: aload 22
    //   998: aload 21
    //   1000: iload 8
    //   1002: invokestatic 405	com/tencent/mm/plugin/base/stub/f:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   1005: astore_2
    //   1006: getstatic 46	com/tencent/mm/plugin/base/stub/f:pdU	Ljava/util/Map;
    //   1009: aload_2
    //   1010: invokeinterface 411 2 0
    //   1015: checkcast 413	com/tencent/mm/plugin/base/stub/e
    //   1018: astore 14
    //   1020: aload 14
    //   1022: ifnull +24 -> 1046
    //   1025: aload 14
    //   1027: astore_2
    //   1028: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   1031: aload 14
    //   1033: getfield 422	com/tencent/mm/plugin/base/stub/e:pdu	J
    //   1036: lsub
    //   1037: aload 14
    //   1039: getfield 425	com/tencent/mm/plugin/base/stub/e:iVn	J
    //   1042: lcmp
    //   1043: ifle +5 -> 1048
    //   1046: aconst_null
    //   1047: astore_2
    //   1048: aload_2
    //   1049: ifnull +150 -> 1199
    //   1052: aload_2
    //   1053: getfield 428	com/tencent/mm/plugin/base/stub/e:pdt	Ljava/lang/String;
    //   1056: invokestatic 221	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1059: ifne +140 -> 1199
    //   1062: ldc 166
    //   1064: ldc_w 430
    //   1067: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1070: invokestatic 114	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1073: aload_2
    //   1074: getfield 428	com/tencent/mm/plugin/base/stub/e:pdt	Ljava/lang/String;
    //   1077: aload_1
    //   1078: invokestatic 436	com/tencent/mm/pluginsdk/g:O	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   1081: pop
    //   1082: aload_1
    //   1083: aload 22
    //   1085: aload 21
    //   1087: iload 8
    //   1089: iconst_2
    //   1090: iconst_0
    //   1091: invokestatic 281	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   1094: pop
    //   1095: getstatic 57	com/tencent/mm/plugin/base/stub/f:pdY	Z
    //   1098: ifeq +311 -> 1409
    //   1101: invokestatic 441	android/os/SystemClock:elapsedRealtime	()J
    //   1104: getstatic 59	com/tencent/mm/plugin/base/stub/f:pdZ	J
    //   1107: lsub
    //   1108: lstore 10
    //   1110: lload 10
    //   1112: lconst_0
    //   1113: lcmp
    //   1114: iflt +16 -> 1130
    //   1117: lload 10
    //   1119: lstore 12
    //   1121: lload 10
    //   1123: ldc2_w 442
    //   1126: lcmp
    //   1127: ifle +6 -> 1133
    //   1130: lconst_0
    //   1131: lstore 12
    //   1133: lload 12
    //   1135: ldc2_w 444
    //   1138: lcmp
    //   1139: ifle +8 -> 1147
    //   1142: bipush 20
    //   1144: invokestatic 447	com/tencent/mm/plugin/base/stub/f:CD	(I)V
    //   1147: getstatic 86	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   1150: sipush 19218
    //   1153: iconst_5
    //   1154: anewarray 4	java/lang/Object
    //   1157: dup
    //   1158: iconst_0
    //   1159: aload 24
    //   1161: aastore
    //   1162: dup
    //   1163: iconst_1
    //   1164: aload 22
    //   1166: aastore
    //   1167: dup
    //   1168: iconst_2
    //   1169: aload 21
    //   1171: aastore
    //   1172: dup
    //   1173: iconst_3
    //   1174: aload 23
    //   1176: aastore
    //   1177: dup
    //   1178: iconst_4
    //   1179: lload 12
    //   1181: ldc2_w 448
    //   1184: ldiv
    //   1185: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1188: aastore
    //   1189: invokevirtual 457	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   1192: ldc 164
    //   1194: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1197: aconst_null
    //   1198: areturn
    //   1199: new 102	android/content/Intent
    //   1202: dup
    //   1203: aload_0
    //   1204: ldc_w 459
    //   1207: invokespecial 462	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1210: astore_2
    //   1211: aload_2
    //   1212: aload_1
    //   1213: invokestatic 468	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1216: invokevirtual 472	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1219: pop
    //   1220: aload_2
    //   1221: ldc 104
    //   1223: invokevirtual 475	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1226: pop
    //   1227: aload_2
    //   1228: ldc_w 477
    //   1231: aload 24
    //   1233: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1236: pop
    //   1237: aload_2
    //   1238: ldc_w 479
    //   1241: aload 23
    //   1243: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1246: pop
    //   1247: aload_2
    //   1248: ldc_w 481
    //   1251: aload 22
    //   1253: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1256: pop
    //   1257: aload_2
    //   1258: ldc_w 483
    //   1261: iconst_1
    //   1262: invokevirtual 486	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1265: pop
    //   1266: aload_2
    //   1267: ldc_w 488
    //   1270: aload 21
    //   1272: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1275: pop
    //   1276: iload 5
    //   1278: ifeq +118 -> 1396
    //   1281: aload_2
    //   1282: ldc_w 490
    //   1285: iconst_1
    //   1286: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1289: pop
    //   1290: aload_2
    //   1291: ldc_w 492
    //   1294: aload 23
    //   1296: invokevirtual 132	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1299: pop
    //   1300: aload_2
    //   1301: ldc_w 494
    //   1304: bipush 29
    //   1306: invokevirtual 486	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1309: pop
    //   1310: invokestatic 500	com/tencent/mm/model/ad:aVe	()Lcom/tencent/mm/model/ad;
    //   1313: ldc_w 502
    //   1316: iconst_1
    //   1317: invokevirtual 506	com/tencent/mm/model/ad:G	(Ljava/lang/String;Z)Lcom/tencent/mm/model/ad$b;
    //   1320: astore_1
    //   1321: aload_1
    //   1322: ldc_w 481
    //   1325: aload 22
    //   1327: invokevirtual 512	com/tencent/mm/model/ad$b:l	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1330: pop
    //   1331: aload_1
    //   1332: ldc_w 488
    //   1335: aload 21
    //   1337: invokevirtual 512	com/tencent/mm/model/ad$b:l	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1340: pop
    //   1341: aload_1
    //   1342: ldc_w 514
    //   1345: iload 8
    //   1347: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1350: invokevirtual 512	com/tencent/mm/model/ad$b:l	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/ad$b;
    //   1353: pop
    //   1354: ldc 166
    //   1356: ldc_w 516
    //   1359: iconst_3
    //   1360: anewarray 4	java/lang/Object
    //   1363: dup
    //   1364: iconst_0
    //   1365: aload 22
    //   1367: aastore
    //   1368: dup
    //   1369: iconst_1
    //   1370: aload 21
    //   1372: aastore
    //   1373: dup
    //   1374: iconst_2
    //   1375: iload 8
    //   1377: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1380: aastore
    //   1381: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1384: iconst_2
    //   1385: invokestatic 447	com/tencent/mm/plugin/base/stub/f:CD	(I)V
    //   1388: aload_2
    //   1389: aload_0
    //   1390: invokestatic 520	com/tencent/mm/plugin/base/stub/f:u	(Landroid/content/Intent;Landroid/content/Context;)V
    //   1393: goto -298 -> 1095
    //   1396: aload_2
    //   1397: ldc_w 494
    //   1400: bipush 19
    //   1402: invokevirtual 486	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1405: pop
    //   1406: goto -96 -> 1310
    //   1409: lconst_0
    //   1410: lstore 10
    //   1412: goto -302 -> 1110
    //   1415: astore 19
    //   1417: ldc 211
    //   1419: astore 15
    //   1421: aload 18
    //   1423: astore_2
    //   1424: aload 17
    //   1426: astore 14
    //   1428: aload_1
    //   1429: astore 17
    //   1431: aload 19
    //   1433: astore_1
    //   1434: goto -777 -> 657
    //   1437: astore 18
    //   1439: aload_1
    //   1440: astore 17
    //   1442: aload 18
    //   1444: astore_1
    //   1445: goto -788 -> 657
    //   1448: astore 18
    //   1450: ldc 211
    //   1452: astore 15
    //   1454: aload 19
    //   1456: astore_2
    //   1457: aload 20
    //   1459: astore 14
    //   1461: aload_1
    //   1462: astore 17
    //   1464: aload 18
    //   1466: astore_1
    //   1467: goto -841 -> 626
    //   1470: astore 18
    //   1472: aload_1
    //   1473: astore 17
    //   1475: aload 18
    //   1477: astore_1
    //   1478: goto -852 -> 626
    //   1481: ldc 211
    //   1483: astore_1
    //   1484: goto -1053 -> 431
    //   1487: iconst_0
    //   1488: istore 8
    //   1490: goto -1292 -> 198
    //   1493: ldc 211
    //   1495: astore 16
    //   1497: goto -1314 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1500	0	paramContext	Context
    //   0	1500	1	paramArrayOfString1	String[]
    //   0	1500	2	paramArrayOfString2	String[]
    //   0	1500	3	paramBoolean1	boolean
    //   0	1500	4	paramBoolean2	boolean
    //   0	1500	5	paramBoolean3	boolean
    //   0	1500	6	paramBoolean4	boolean
    //   163	432	7	i	int
    //   196	1293	8	j	int
    //   307	3	9	k	int
    //   1108	303	10	l1	long
    //   1119	61	12	l2	long
    //   24	1436	14	localObject1	Object
    //   27	1426	15	localObject2	Object
    //   181	263	16	str1	String
    //   679	14	16	localException	Exception
    //   1495	1	16	str2	String
    //   210	1264	17	localObject3	Object
    //   214	1208	18	localObject4	Object
    //   1437	6	18	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   1448	17	18	localg1	com.tencent.mm.ab.g
    //   1470	6	18	localg2	com.tencent.mm.ab.g
    //   321	47	19	arrayOfString	String[]
    //   1415	40	19	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   325	1133	20	localObject5	Object
    //   35	1336	21	localObject6	Object
    //   31	1335	22	localObject7	Object
    //   151	1144	23	str3	String
    //   141	1091	24	str4	String
    //   267	107	25	locali	com.tencent.mm.ab.i
    // Exception table:
    //   from	to	target	type
    //   216	223	621	com/tencent/mm/ab/g
    //   231	246	621	com/tencent/mm/ab/g
    //   254	269	621	com/tencent/mm/ab/g
    //   277	290	621	com/tencent/mm/ab/g
    //   296	309	621	com/tencent/mm/ab/g
    //   607	615	621	com/tencent/mm/ab/g
    //   216	223	648	java/io/UnsupportedEncodingException
    //   231	246	648	java/io/UnsupportedEncodingException
    //   254	269	648	java/io/UnsupportedEncodingException
    //   277	290	648	java/io/UnsupportedEncodingException
    //   296	309	648	java/io/UnsupportedEncodingException
    //   607	615	648	java/io/UnsupportedEncodingException
    //   443	450	679	java/lang/Exception
    //   327	336	1415	java/io/UnsupportedEncodingException
    //   350	359	1415	java/io/UnsupportedEncodingException
    //   373	383	1415	java/io/UnsupportedEncodingException
    //   383	421	1437	java/io/UnsupportedEncodingException
    //   327	336	1448	com/tencent/mm/ab/g
    //   350	359	1448	com/tencent/mm/ab/g
    //   373	383	1448	com/tencent/mm/ab/g
    //   383	421	1470	com/tencent/mm/ab/g
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
    Object localObject1 = new eg();
    Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink package name = %s, cgiType=%d", new Object[] { paramString2, Integer.valueOf(paramInt2) });
    ((eg)localObject1).qGp = paramString2;
    ((eg)localObject1).signature = paramString3;
    ((LinkedList)localObject2).add(localObject1);
    localObject1 = new d.a();
    ((d.a)localObject1).iLN = new ekp();
    ((d.a)localObject1).iLO = new ekq();
    ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((d.a)localObject1).funcId = 1200;
    d locald = ((d.a)localObject1).aXF();
    ekp localekp = (ekp)locald.iLK.iLR;
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (1 == paramInt2) {
      localObject1 = "&preload=1";
    }
    for (;;)
    {
      localekp.link = ((String)localObject1);
      localStringBuilder = new StringBuilder().append(localekp.link);
      if (2 == paramInt2)
      {
        localObject1 = "&jsForReport=1";
        localekp.link = ((String)localObject1);
        localekp.scene = 1;
        localekp.NjP = ((LinkedList)localObject2);
        localObject2 = new CountDownLatch(1);
        localObject1 = new MatrixCursor(new String[] { "downloadUrl", "fileMd5", "expireTime", "extraBytes" });
        aa.a(locald, new f.2(paramInt2, paramString1, paramString2, paramString3, paramInt1, paramBoolean, (MatrixCursor)localObject1, (CountDownLatch)localObject2));
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
    eg localeg = new eg();
    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { paramString1 });
    localeg.qGp = paramString1;
    localeg.signature = paramString2;
    localLinkedList.add(localeg);
    paramUri = new ac(paramUri.toString(), paramInt, localLinkedList);
    paramActivity = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(22227);
        bg.azz().b(1200, this);
        Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
          f.L(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousString = ((ac)paramAnonymousq).bfC();
        Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramAnonymousString });
        try
        {
          paramAnonymousString = Uri.parse(paramAnonymousString);
          if (paramAnonymousString == null)
          {
            Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
            f.L(this.val$activity);
            AppMethodBeat.o(22227);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramAnonymousString });
          f.L(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousq = paramAnonymousString.getQueryParameter("result");
        if (paramAnonymousq != null)
        {
          paramAnonymousq = URLDecoder.decode(paramAnonymousq);
          Log.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramAnonymousq });
          cr localcr = new cr();
          localcr.dFK.activity = this.val$activity;
          localcr.dFK.dDX = paramAnonymousq;
          localcr.dFK.dFL = 19;
          localcr.dFK.from = 3;
          localcr.dFK.dFN = paramAnonymousString.getQueryParameter("appid");
          localcr.dFK.dFP = this.val$activity.getIntent().getBundleExtra("_stat_obj");
          EventCenter.instance.publish(localcr);
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
    bg.azz().a(1200, paramActivity);
    bg.azz().a(paramUri, 0);
    AppMethodBeat.o(22231);
  }
  
  static void a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(231622);
    WXLaunchWxaRedirectingPage.Resp localResp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
    localResp.invokeTicket = paramReq.invokeTicket;
    localResp.callbackActivity = paramReq.callbackActivity;
    localResp.errCode = paramInt;
    localResp.errStr = paramString2;
    paramReq = new Bundle();
    localResp.toBundle(paramReq);
    com.tencent.mm.pluginsdk.model.app.q.bo(paramReq);
    com.tencent.mm.pluginsdk.model.app.q.bp(paramReq);
    paramString2 = new MMessageActV2.Args();
    paramString2.targetPkgName = paramString1;
    paramString2.bundle = paramReq;
    MMessageActV2.send(paramContext, paramString2);
    if ((paramContext instanceof WXBizEntryActivity)) {
      ((WXBizEntryActivity)paramContext).finish();
    }
    AppMethodBeat.o(231622);
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
    paramString2.iVn = System.currentTimeMillis();
    paramString2.pdt = paramString4;
    if (paramLong > 0L) {
      paramString2.pdu = (1000L * paramLong);
    }
    pdU.put(paramString1, paramString2);
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
        localObject1 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.cj(paramContext, paramArrayOfString2[0])[0].toByteArray());
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
    u(paramArrayOfString2, paramContext);
    AppMethodBeat.o(22232);
    return true;
  }
  
  private static void ac(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161302);
      if (cjV())
      {
        CD(31);
        long l = System.currentTimeMillis();
        Log.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry saveWXBizEntryIntent enterId=%d", new Object[] { Long.valueOf(l) });
        paramIntent.putExtra("__BIZ_ENTRY_ENTER_ID", l);
        pdV = paramIntent;
        cjX();
      }
      AppMethodBeat.o(161302);
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void ad(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 724
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 710	com/tencent/mm/plugin/base/stub/f:cjV	()Z
    //   12: ifne +13 -> 25
    //   15: ldc_w 724
    //   18: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: ldc_w 714
    //   29: lconst_0
    //   30: invokevirtual 728	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +16 -> 53
    //   40: getstatic 51	com/tencent/mm/plugin/base/stub/f:pdW	Ljava/util/Set;
    //   43: lload_1
    //   44: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokeinterface 731 2 0
    //   52: pop
    //   53: invokestatic 734	com/tencent/mm/plugin/base/stub/f:cjW	()V
    //   56: ldc 166
    //   58: ldc_w 736
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: ldc_w 724
    //   78: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean ae(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161306);
      long l = paramIntent.getLongExtra("__BIZ_ENTRY_ENTER_ID", 0L);
      Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry isInConsumedSet %d", new Object[] { Long.valueOf(l) });
      boolean bool = pdW.contains(Long.valueOf(l));
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
    String str3 = null;
    String str4 = null;
    String str2 = str4;
    String str1 = str3;
    if (paramArrayOfString2 != null)
    {
      str2 = str4;
      str1 = str3;
      if (paramArrayOfString2.length > 0)
      {
        str1 = paramArrayOfString2[0];
        str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.cj(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    Log.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", new Object[] { str1, str2 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 4))
    {
      Log.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str5 = paramArrayOfString1[0];
    if (Util.isNullOrNil(str5))
    {
      Log.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str6 = paramArrayOfString1[1];
    if (Util.isNullOrNil(str6))
    {
      Log.e("MicroMsg.WXBizLogic", "businessType isEmpty");
      AppMethodBeat.o(22233);
      return false;
    }
    str3 = Util.nullAsNil(paramArrayOfString1[2]);
    str4 = Util.nullAsNil(paramArrayOfString1[3]);
    if (paramArrayOfString1.length > 4) {
      com.tencent.mm.pluginsdk.ui.tools.n.Kwp = paramArrayOfString1[4];
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length > 5)
    {
      paramArrayOfString2 = paramArrayOfString1[5];
      com.tencent.mm.pluginsdk.model.app.h.o(str5, true, false);
    }
    boolean bool = str6.startsWith("native");
    if (bool)
    {
      paramArrayOfString1 = "openNativeView";
      paramArrayOfString1 = String.format("weixin://dl/%s/?appid=%s&businessType=%s", new Object[] { paramArrayOfString1, str5, str6 });
      Log.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", new Object[] { paramArrayOfString1, str3, str4 });
      if ((bool) || (Util.isNullOrNil(str4))) {
        break label520;
      }
    }
    for (;;)
    {
      try
      {
        int j = new com.tencent.mm.ab.i(str4).optInt("miniProgramType", 0);
        if (j >= 0)
        {
          i = j;
          if (j <= 2) {}
        }
        else
        {
          i = 0;
        }
        Intent localIntent = new Intent(paramContext, WXBizEntryActivity.class);
        localIntent.setData(Uri.parse(paramArrayOfString1));
        localIntent.addFlags(268435456);
        localIntent.putExtra("key_package_name", str1);
        localIntent.putExtra("key_app_id", str5);
        localIntent.putExtra("key_business_type", str6);
        localIntent.putExtra("translate_link_scene", 1);
        localIntent.putExtra("key_package_signature", str2);
        localIntent.putExtra("key_command_id", 26);
        u(localIntent, paramContext);
        paramContext = ad.aVe().G("key_data_center_session_id", true);
        paramContext.l("key_launch_miniprogram_type", Integer.valueOf(i));
        paramContext.l("key_launch_miniprogram_query_info", str3);
        paramContext.l("key_open_business_view_ext_info", str4);
        paramContext.l("key_launch_mini_program_open_id", paramArrayOfString2);
        AppMethodBeat.o(22233);
        return true;
      }
      catch (Exception localException) {}
      paramArrayOfString1 = "jumpFakeWxa";
      break;
      label520:
      int i = 0;
    }
  }
  
  private static String c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(22237);
    paramString1 = MD5Util.getMD5String(String.format("%s_%d_%s_%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(22237);
    return paramString1;
  }
  
  static void c(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(231621);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WXBizLogic", "doLaunchWxaRedirectingPage, context==null[%b], args[%s], packages[%s]", new Object[] { Boolean.valueOf(bool), Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      CE(1);
      if ((paramContext != null) && (paramArrayOfString2 != null) && (paramArrayOfString2[0].length() > 0)) {
        break;
      }
      CE(2);
      AppMethodBeat.o(231621);
      return;
    }
    WXLaunchWxaRedirectingPage.Req localReq = new WXLaunchWxaRedirectingPage.Req();
    String str = paramArrayOfString1[0];
    try
    {
      if (TextUtils.isEmpty(str))
      {
        CE(2);
        AppMethodBeat.o(231621);
        return;
      }
      localReq.fromArray((String[])org.apache.commons.b.a.g(paramArrayOfString1, paramArrayOfString1.length));
      paramArrayOfString1 = new Intent(paramContext, WXBizEntryActivity.class);
      paramArrayOfString1.setData(Uri.parse(String.format(Locale.ENGLISH, "weixin://dl/wmpf/sdk?appid=%s&ticket=%s", new Object[] { str, localReq.invokeTicket })));
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.putExtra("translate_link_scene", 1);
      paramArrayOfString1.putExtra("key_package_name", paramArrayOfString2[0]);
      paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.cj(paramContext, paramArrayOfString2[0]);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {
        paramArrayOfString1.putExtra("key_package_signature", com.tencent.mm.b.g.getMessageDigest(paramArrayOfString2[0].toByteArray()));
      }
      paramArrayOfString2 = new Bundle();
      localReq.toBundle(paramArrayOfString2);
      paramArrayOfString1.putExtra("key_launch_wxa_redirecting_page_req", paramArrayOfString2);
      paramArrayOfString1.putExtra("key_command_id", 30);
      u(paramArrayOfString1, paramContext);
      AppMethodBeat.o(231621);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.WXBizLogic", paramContext, "doLaunchWxaFRedirectingPage args[%s] packages[%s]", new Object[] { Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      CE(2);
      AppMethodBeat.o(231621);
    }
  }
  
  public static void cjS()
  {
    AppMethodBeat.i(179576);
    Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetCallingPackageNull");
    com.tencent.mm.plugin.report.service.h.CyF.n(1194L, 50L, 1L);
    AppMethodBeat.o(179576);
  }
  
  public static void cjT()
  {
    AppMethodBeat.i(179577);
    Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetPackagesForUidMoreThanOne");
    com.tencent.mm.plugin.report.service.h.CyF.n(1194L, 51L, 1L);
    AppMethodBeat.o(179577);
  }
  
  public static void cjU()
  {
    AppMethodBeat.i(231619);
    com.tencent.mm.plugin.report.service.h.CyF.a(1194, new Object[] { Integer.valueOf(60), Integer.valueOf(1) });
    AppMethodBeat.o(231619);
  }
  
  public static boolean cjV()
  {
    AppMethodBeat.i(161300);
    if (pdX != -1)
    {
      if (pdX == 1)
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
    pdX = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rTS, 1);
    Log.i("MicroMsg.WXBizLogic", "reTryOpenWXBizEntry open %d", new Object[] { Integer.valueOf(pdX) });
    if (pdX == 1)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    AppMethodBeat.o(161300);
    return false;
  }
  
  private static void cjW()
  {
    try
    {
      pdV = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void cjX()
  {
    AppMethodBeat.i(169736);
    if (appForegroundListener == null)
    {
      o.a local6 = new o.a()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          AppMethodBeat.i(231616);
          Log.d("MicroMsg.WXBizLogic", "turn onAppBackground");
          f.kb(false);
          AppMethodBeat.o(231616);
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          AppMethodBeat.i(231615);
          f.kb(true);
          f.AZ(SystemClock.elapsedRealtime());
          Log.d("MicroMsg.WXBizLogic", "turn onAppForeground");
          if ((f.ckd() != null) && (com.tencent.mm.kernel.g.aAc()))
          {
            Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry onAppForeground");
            f.cjZ();
          }
          AppMethodBeat.o(231615);
        }
      };
      appForegroundListener = local6;
      local6.alive();
    }
    AppMethodBeat.o(169736);
  }
  
  public static void cjY()
  {
    AppMethodBeat.i(161303);
    pdY = true;
    pdZ = SystemClock.elapsedRealtime();
    cjZ();
    AppMethodBeat.o(161303);
  }
  
  public static void cjZ()
  {
    AppMethodBeat.i(169737);
    cjX();
    if ((pdV == null) || (!cjV()))
    {
      AppMethodBeat.o(169737);
      return;
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231617);
        f.cka();
        AppMethodBeat.o(231617);
      }
    }, 50L);
    AppMethodBeat.o(169737);
  }
  
  /* Error */
  public static void cka()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 911
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 166
    //   11: ldc_w 913
    //   14: invokestatic 915	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 719	com/tencent/mm/plugin/base/stub/f:pdV	Landroid/content/Intent;
    //   20: ifnonnull +13 -> 33
    //   23: ldc_w 911
    //   26: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: getstatic 719	com/tencent/mm/plugin/base/stub/f:pdV	Landroid/content/Intent;
    //   36: ldc_w 714
    //   39: lconst_0
    //   40: invokevirtual 728	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   43: lstore_0
    //   44: invokestatic 419	java/lang/System:currentTimeMillis	()J
    //   47: lload_0
    //   48: lsub
    //   49: lstore_0
    //   50: getstatic 719	com/tencent/mm/plugin/base/stub/f:pdV	Landroid/content/Intent;
    //   53: invokestatic 917	com/tencent/mm/plugin/base/stub/f:ae	(Landroid/content/Intent;)Z
    //   56: ifne +132 -> 188
    //   59: lload_0
    //   60: invokestatic 922	java/lang/Math:abs	(J)J
    //   63: ldc2_w 444
    //   66: lcmp
    //   67: ifge +121 -> 188
    //   70: ldc 166
    //   72: ldc_w 924
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_0
    //   82: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: getstatic 719	com/tencent/mm/plugin/base/stub/f:pdV	Landroid/content/Intent;
    //   92: ldc_w 926
    //   95: iconst_1
    //   96: invokevirtual 137	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   99: pop
    //   100: invokestatic 114	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   103: astore_2
    //   104: getstatic 719	com/tencent/mm/plugin/base/stub/f:pdV	Landroid/content/Intent;
    //   107: astore_3
    //   108: new 928	com/tencent/mm/hellhoundlib/b/a
    //   111: dup
    //   112: invokespecial 929	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   115: aload_3
    //   116: invokevirtual 933	com/tencent/mm/hellhoundlib/b/a:bl	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   119: astore_3
    //   120: aload_2
    //   121: aload_3
    //   122: invokevirtual 937	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   125: ldc_w 939
    //   128: ldc_w 941
    //   131: ldc_w 942
    //   134: ldc_w 944
    //   137: ldc_w 946
    //   140: ldc_w 947
    //   143: invokestatic 952	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_3
    //   148: iconst_0
    //   149: invokevirtual 956	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   152: checkcast 102	android/content/Intent
    //   155: invokevirtual 960	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   158: aload_2
    //   159: ldc_w 939
    //   162: ldc_w 941
    //   165: ldc_w 942
    //   168: ldc_w 944
    //   171: ldc_w 946
    //   174: ldc_w 947
    //   177: invokestatic 963	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokestatic 734	com/tencent/mm/plugin/base/stub/f:cjW	()V
    //   183: bipush 30
    //   185: invokestatic 447	com/tencent/mm/plugin/base/stub/f:CD	(I)V
    //   188: ldc_w 911
    //   191: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void ckb()
  {
    AppMethodBeat.i(179578);
    try
    {
      int i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rSy, 1);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        pea = bool;
        Log.i("MicroMsg.WXBizLogic", "alvinluo updateGetCallingPackageStatus config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(pea) });
        AppMethodBeat.o(179578);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WXBizLogic", localException, "alvinluo updateGetCallingPackageStatus exception", new Object[0]);
      pea = true;
      AppMethodBeat.o(179578);
    }
  }
  
  public static boolean ckc()
  {
    return pea;
  }
  
  public static void u(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(161301);
      ac(paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    AppMethodBeat.i(231623);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramArrayOfString = new MatrixCursor(new String[0], 0);
      AppMethodBeat.o(231623);
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
        if (!org.apache.commons.b.a.contains(peb, localObject)) {
          break label166;
        }
        str = "1";
        localObject = arrayOfString;
      }
      AppMethodBeat.o(231623);
      return localMatrixCursor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f
 * JD-Core Version:    0.7.0.1
 */