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
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.co;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static n.a appForegroundListener;
  private static Map<String, e> nNB;
  private static Intent nNC;
  public static final Set<Long> nND;
  private static int nNE;
  private static boolean nNF;
  private static long nNG;
  private static boolean nNH;
  private static final String[] nNI;
  
  static
  {
    AppMethodBeat.i(22242);
    nNB = new HashMap();
    nND = new HashSet();
    nNE = -1;
    appForegroundListener = null;
    nNF = false;
    nNG = 0L;
    nNH = true;
    nNI = new String[] { "sdk_openAppProfile", "sdk_openFeedback", "sdk_openGrowthCare" };
    AppMethodBeat.o(22242);
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
    //   0: ldc 139
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +17 -> 23
    //   9: ldc 141
    //   11: ldc 143
    //   13: invokestatic 149	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 139
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
    //   63: invokestatic 155	com/tencent/mm/pluginsdk/model/app/q:bO	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   66: iconst_0
    //   67: aaload
    //   68: invokevirtual 161	android/content/pm/Signature:toByteArray	()[B
    //   71: invokestatic 167	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   74: astore 21
    //   76: ldc 141
    //   78: ldc 169
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
    //   94: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_1
    //   98: ifnull +9 -> 107
    //   101: aload_1
    //   102: arraylength
    //   103: iconst_2
    //   104: if_icmpge +17 -> 121
    //   107: ldc 141
    //   109: ldc 174
    //   111: invokestatic 149	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: ldc 139
    //   116: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aconst_null
    //   120: areturn
    //   121: aload_1
    //   122: iconst_0
    //   123: aaload
    //   124: astore 24
    //   126: iload 6
    //   128: ifne +435 -> 563
    //   131: aload_1
    //   132: iconst_1
    //   133: aaload
    //   134: astore 23
    //   136: ldc 176
    //   138: astore 15
    //   140: iload 5
    //   142: ifeq +428 -> 570
    //   145: iconst_3
    //   146: istore 7
    //   148: ldc 176
    //   150: astore 14
    //   152: ldc 176
    //   154: astore_2
    //   155: aload_1
    //   156: arraylength
    //   157: iconst_2
    //   158: if_icmple +1310 -> 1468
    //   161: aload_1
    //   162: iconst_2
    //   163: aaload
    //   164: astore 16
    //   166: aload_1
    //   167: arraylength
    //   168: iconst_3
    //   169: if_icmple +1293 -> 1462
    //   172: aload_1
    //   173: iconst_3
    //   174: aaload
    //   175: iconst_0
    //   176: invokestatic 182	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   179: istore 8
    //   181: aload_1
    //   182: arraylength
    //   183: iconst_4
    //   184: if_icmple +1272 -> 1456
    //   187: aload_1
    //   188: iconst_4
    //   189: aaload
    //   190: astore_1
    //   191: aload 15
    //   193: astore 17
    //   195: aload 15
    //   197: astore 18
    //   199: aload_1
    //   200: invokestatic 186	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   203: ifne +373 -> 576
    //   206: aload 15
    //   208: astore 17
    //   210: aload 15
    //   212: astore 18
    //   214: ldc 141
    //   216: ldc 188
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: aastore
    //   226: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload 15
    //   231: astore 17
    //   233: aload 15
    //   235: astore 18
    //   237: new 193	com/tencent/mm/ac/i
    //   240: dup
    //   241: aload_1
    //   242: ldc 195
    //   244: invokestatic 201	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   247: invokespecial 204	com/tencent/mm/ac/i:<init>	(Ljava/lang/String;)V
    //   250: astore 25
    //   252: aload 15
    //   254: astore 17
    //   256: aload 15
    //   258: astore 18
    //   260: aload 25
    //   262: ldc 206
    //   264: invokevirtual 210	com/tencent/mm/ac/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   267: ldc 195
    //   269: invokestatic 215	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_1
    //   273: aload_1
    //   274: astore 17
    //   276: aload_1
    //   277: astore 18
    //   279: aload 25
    //   281: ldc 217
    //   283: invokevirtual 210	com/tencent/mm/ac/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   286: iconst_0
    //   287: invokestatic 182	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   290: istore 9
    //   292: iload 9
    //   294: istore 7
    //   296: aload_2
    //   297: astore 18
    //   299: aload 14
    //   301: astore 17
    //   303: aload_2
    //   304: astore 19
    //   306: aload 14
    //   308: astore 20
    //   310: aload 25
    //   312: ldc 219
    //   314: invokevirtual 210	com/tencent/mm/ac/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   317: astore 14
    //   319: aload_2
    //   320: astore 18
    //   322: aload 14
    //   324: astore 17
    //   326: aload_2
    //   327: astore 19
    //   329: aload 14
    //   331: astore 20
    //   333: aload 25
    //   335: ldc 221
    //   337: invokevirtual 210	com/tencent/mm/ac/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: astore_2
    //   341: aload_2
    //   342: astore 18
    //   344: aload 14
    //   346: astore 17
    //   348: aload_2
    //   349: astore 19
    //   351: aload 14
    //   353: astore 20
    //   355: aload 25
    //   357: ldc 223
    //   359: invokevirtual 210	com/tencent/mm/ac/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore 15
    //   364: ldc 141
    //   366: ldc 225
    //   368: iconst_5
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: aload_1
    //   375: aastore
    //   376: dup
    //   377: iconst_1
    //   378: iload 7
    //   380: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: dup
    //   385: iconst_2
    //   386: aload 14
    //   388: aastore
    //   389: dup
    //   390: iconst_3
    //   391: aload_2
    //   392: aastore
    //   393: dup
    //   394: iconst_4
    //   395: aload 15
    //   397: aastore
    //   398: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: aload 15
    //   403: astore 17
    //   405: aload_1
    //   406: astore 15
    //   408: aload 17
    //   410: astore_1
    //   411: aload 16
    //   413: astore 17
    //   415: aload 16
    //   417: invokestatic 186	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   420: ifne +10 -> 430
    //   423: aload 16
    //   425: invokestatic 233	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 17
    //   430: ldc 141
    //   432: ldc 235
    //   434: iconst_4
    //   435: anewarray 4	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: aload 24
    //   442: aastore
    //   443: dup
    //   444: iconst_1
    //   445: aload 23
    //   447: aastore
    //   448: dup
    //   449: iconst_2
    //   450: aload 17
    //   452: aastore
    //   453: dup
    //   454: iconst_3
    //   455: iload 8
    //   457: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: iload 6
    //   466: ifne +217 -> 683
    //   469: ldc 237
    //   471: bipush 8
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: aload 24
    //   480: aastore
    //   481: dup
    //   482: iconst_1
    //   483: aload 23
    //   485: aastore
    //   486: dup
    //   487: iconst_2
    //   488: aload 17
    //   490: aastore
    //   491: dup
    //   492: iconst_3
    //   493: aload 15
    //   495: aastore
    //   496: dup
    //   497: iconst_4
    //   498: iload 7
    //   500: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   503: aastore
    //   504: dup
    //   505: iconst_5
    //   506: aload 14
    //   508: aastore
    //   509: dup
    //   510: bipush 6
    //   512: aload_2
    //   513: aastore
    //   514: dup
    //   515: bipush 7
    //   517: aload_1
    //   518: aastore
    //   519: invokestatic 241	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   522: astore_1
    //   523: ldc 141
    //   525: ldc 243
    //   527: iconst_1
    //   528: anewarray 4	java/lang/Object
    //   531: dup
    //   532: iconst_0
    //   533: aload_1
    //   534: aastore
    //   535: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: iload_3
    //   539: ifeq +163 -> 702
    //   542: aload_1
    //   543: aload 22
    //   545: aload 21
    //   547: iload 8
    //   549: iconst_1
    //   550: iload 4
    //   552: invokestatic 246	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   555: astore_0
    //   556: ldc 139
    //   558: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   561: aload_0
    //   562: areturn
    //   563: ldc 176
    //   565: astore 23
    //   567: goto -431 -> 136
    //   570: iconst_0
    //   571: istore 7
    //   573: goto -425 -> 148
    //   576: aload 15
    //   578: astore 17
    //   580: aload 15
    //   582: astore 18
    //   584: ldc 141
    //   586: ldc 248
    //   588: invokestatic 149	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: ldc 176
    //   593: astore_1
    //   594: goto -183 -> 411
    //   597: astore_1
    //   598: ldc 176
    //   600: astore 15
    //   602: ldc 141
    //   604: aload_1
    //   605: ldc 176
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: aload 15
    //   616: astore_1
    //   617: aload 17
    //   619: astore 15
    //   621: goto -210 -> 411
    //   624: astore_1
    //   625: ldc 176
    //   627: astore 15
    //   629: aload 18
    //   631: astore 17
    //   633: ldc 141
    //   635: aload_1
    //   636: ldc 176
    //   638: iconst_0
    //   639: anewarray 4	java/lang/Object
    //   642: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   645: aload 15
    //   647: astore_1
    //   648: aload 17
    //   650: astore 15
    //   652: goto -241 -> 411
    //   655: astore 16
    //   657: ldc 141
    //   659: ldc 254
    //   661: iconst_1
    //   662: anewarray 4	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: aload 16
    //   669: invokevirtual 258	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   672: aastore
    //   673: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   676: ldc 176
    //   678: astore 17
    //   680: goto -250 -> 430
    //   683: ldc_w 262
    //   686: iconst_1
    //   687: anewarray 4	java/lang/Object
    //   690: dup
    //   691: iconst_0
    //   692: aload 24
    //   694: aastore
    //   695: invokestatic 241	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   698: astore_1
    //   699: goto -176 -> 523
    //   702: iload 6
    //   704: ifeq +265 -> 969
    //   707: aload 22
    //   709: invokestatic 186	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   712: ifne +11 -> 723
    //   715: aload 21
    //   717: invokestatic 186	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   720: ifeq +18 -> 738
    //   723: ldc 141
    //   725: ldc_w 264
    //   728: invokestatic 149	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: ldc 139
    //   733: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: aconst_null
    //   737: areturn
    //   738: new 266	java/util/LinkedList
    //   741: dup
    //   742: invokespecial 267	java/util/LinkedList:<init>	()V
    //   745: astore_0
    //   746: new 269	com/tencent/mm/protocal/protobuf/du
    //   749: dup
    //   750: invokespecial 270	com/tencent/mm/protocal/protobuf/du:<init>	()V
    //   753: astore_2
    //   754: ldc 141
    //   756: ldc_w 272
    //   759: iconst_2
    //   760: anewarray 4	java/lang/Object
    //   763: dup
    //   764: iconst_0
    //   765: aload 22
    //   767: aastore
    //   768: dup
    //   769: iconst_1
    //   770: iconst_3
    //   771: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: aastore
    //   775: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   778: aload_2
    //   779: aload 22
    //   781: putfield 276	com/tencent/mm/protocal/protobuf/du:pkf	Ljava/lang/String;
    //   784: aload_2
    //   785: aload 21
    //   787: putfield 279	com/tencent/mm/protocal/protobuf/du:signature	Ljava/lang/String;
    //   790: aload_0
    //   791: aload_2
    //   792: invokevirtual 283	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   795: pop
    //   796: new 285	com/tencent/mm/al/b$a
    //   799: dup
    //   800: invokespecial 286	com/tencent/mm/al/b$a:<init>	()V
    //   803: astore_2
    //   804: aload_2
    //   805: new 288	com/tencent/mm/protocal/protobuf/dpw
    //   808: dup
    //   809: invokespecial 289	com/tencent/mm/protocal/protobuf/dpw:<init>	()V
    //   812: putfield 293	com/tencent/mm/al/b$a:hNM	Lcom/tencent/mm/bx/a;
    //   815: aload_2
    //   816: new 295	com/tencent/mm/protocal/protobuf/dpx
    //   819: dup
    //   820: invokespecial 296	com/tencent/mm/protocal/protobuf/dpx:<init>	()V
    //   823: putfield 299	com/tencent/mm/al/b$a:hNN	Lcom/tencent/mm/bx/a;
    //   826: aload_2
    //   827: ldc_w 301
    //   830: putfield 304	com/tencent/mm/al/b$a:uri	Ljava/lang/String;
    //   833: aload_2
    //   834: sipush 1200
    //   837: putfield 307	com/tencent/mm/al/b$a:funcId	I
    //   840: aload_2
    //   841: invokevirtual 311	com/tencent/mm/al/b$a:aDC	()Lcom/tencent/mm/al/b;
    //   844: astore_2
    //   845: aload_2
    //   846: getfield 317	com/tencent/mm/al/b:hNK	Lcom/tencent/mm/al/b$b;
    //   849: getfield 322	com/tencent/mm/al/b$b:hNQ	Lcom/tencent/mm/bx/a;
    //   852: checkcast 288	com/tencent/mm/protocal/protobuf/dpw
    //   855: astore 14
    //   857: aload 14
    //   859: new 324	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   866: aload_1
    //   867: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc_w 331
    //   873: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: putfield 337	com/tencent/mm/protocal/protobuf/dpw:link	Ljava/lang/String;
    //   882: aload 14
    //   884: iconst_1
    //   885: putfield 340	com/tencent/mm/protocal/protobuf/dpw:scene	I
    //   888: aload 14
    //   890: aload_0
    //   891: putfield 344	com/tencent/mm/protocal/protobuf/dpw:HDW	Ljava/util/LinkedList;
    //   894: ldc 141
    //   896: ldc_w 346
    //   899: iconst_1
    //   900: anewarray 4	java/lang/Object
    //   903: dup
    //   904: iconst_0
    //   905: aload 14
    //   907: getfield 337	com/tencent/mm/protocal/protobuf/dpw:link	Ljava/lang/String;
    //   910: aastore
    //   911: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   914: new 348	android/database/MatrixCursor
    //   917: dup
    //   918: iconst_4
    //   919: anewarray 65	java/lang/String
    //   922: dup
    //   923: iconst_0
    //   924: ldc_w 350
    //   927: aastore
    //   928: dup
    //   929: iconst_1
    //   930: ldc_w 352
    //   933: aastore
    //   934: dup
    //   935: iconst_2
    //   936: ldc_w 354
    //   939: aastore
    //   940: dup
    //   941: iconst_3
    //   942: ldc_w 356
    //   945: aastore
    //   946: invokespecial 359	android/database/MatrixCursor:<init>	([Ljava/lang/String;)V
    //   949: astore_0
    //   950: aload_2
    //   951: new 361	com/tencent/mm/plugin/base/stub/f$3
    //   954: dup
    //   955: invokespecial 362	com/tencent/mm/plugin/base/stub/f$3:<init>	()V
    //   958: invokestatic 367	com/tencent/mm/al/x:a	(Lcom/tencent/mm/al/b;Lcom/tencent/mm/al/x$a;)Lcom/tencent/mm/al/b;
    //   961: pop
    //   962: ldc 139
    //   964: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   967: aload_0
    //   968: areturn
    //   969: aload_1
    //   970: iconst_1
    //   971: aload 22
    //   973: aload 21
    //   975: iload 8
    //   977: invokestatic 371	com/tencent/mm/plugin/base/stub/f:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   980: astore_2
    //   981: getstatic 48	com/tencent/mm/plugin/base/stub/f:nNB	Ljava/util/Map;
    //   984: aload_2
    //   985: invokeinterface 377 2 0
    //   990: checkcast 379	com/tencent/mm/plugin/base/stub/e
    //   993: astore 14
    //   995: aload 14
    //   997: ifnull +24 -> 1021
    //   1000: aload 14
    //   1002: astore_2
    //   1003: invokestatic 385	java/lang/System:currentTimeMillis	()J
    //   1006: aload 14
    //   1008: getfield 388	com/tencent/mm/plugin/base/stub/e:nNa	J
    //   1011: lsub
    //   1012: aload 14
    //   1014: getfield 391	com/tencent/mm/plugin/base/stub/e:hXx	J
    //   1017: lcmp
    //   1018: ifle +5 -> 1023
    //   1021: aconst_null
    //   1022: astore_2
    //   1023: aload_2
    //   1024: ifnull +150 -> 1174
    //   1027: aload_2
    //   1028: getfield 394	com/tencent/mm/plugin/base/stub/e:nMZ	Ljava/lang/String;
    //   1031: invokestatic 186	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1034: ifne +140 -> 1174
    //   1037: ldc 141
    //   1039: ldc_w 396
    //   1042: invokestatic 398	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1045: invokestatic 93	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1048: aload_2
    //   1049: getfield 394	com/tencent/mm/plugin/base/stub/e:nMZ	Ljava/lang/String;
    //   1052: aload_1
    //   1053: invokestatic 403	com/tencent/mm/pluginsdk/g:J	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   1056: pop
    //   1057: aload_1
    //   1058: aload 22
    //   1060: aload 21
    //   1062: iload 8
    //   1064: iconst_2
    //   1065: iconst_0
    //   1066: invokestatic 246	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   1069: pop
    //   1070: getstatic 59	com/tencent/mm/plugin/base/stub/f:nNF	Z
    //   1073: ifeq +311 -> 1384
    //   1076: invokestatic 408	android/os/SystemClock:elapsedRealtime	()J
    //   1079: getstatic 61	com/tencent/mm/plugin/base/stub/f:nNG	J
    //   1082: lsub
    //   1083: lstore 10
    //   1085: lload 10
    //   1087: lconst_0
    //   1088: lcmp
    //   1089: iflt +16 -> 1105
    //   1092: lload 10
    //   1094: lstore 12
    //   1096: lload 10
    //   1098: ldc2_w 409
    //   1101: lcmp
    //   1102: ifle +6 -> 1108
    //   1105: lconst_0
    //   1106: lstore 12
    //   1108: lload 12
    //   1110: ldc2_w 411
    //   1113: lcmp
    //   1114: ifle +8 -> 1122
    //   1117: bipush 20
    //   1119: invokestatic 415	com/tencent/mm/plugin/base/stub/f:yO	(I)V
    //   1122: getstatic 421	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   1125: sipush 19218
    //   1128: iconst_5
    //   1129: anewarray 4	java/lang/Object
    //   1132: dup
    //   1133: iconst_0
    //   1134: aload 24
    //   1136: aastore
    //   1137: dup
    //   1138: iconst_1
    //   1139: aload 22
    //   1141: aastore
    //   1142: dup
    //   1143: iconst_2
    //   1144: aload 21
    //   1146: aastore
    //   1147: dup
    //   1148: iconst_3
    //   1149: aload 23
    //   1151: aastore
    //   1152: dup
    //   1153: iconst_4
    //   1154: lload 12
    //   1156: ldc2_w 422
    //   1159: ldiv
    //   1160: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1163: aastore
    //   1164: invokevirtual 432	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   1167: ldc 139
    //   1169: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1172: aconst_null
    //   1173: areturn
    //   1174: new 81	android/content/Intent
    //   1177: dup
    //   1178: aload_0
    //   1179: ldc_w 434
    //   1182: invokespecial 437	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1185: astore_2
    //   1186: aload_2
    //   1187: aload_1
    //   1188: invokestatic 443	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1191: invokevirtual 447	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1194: pop
    //   1195: aload_2
    //   1196: ldc 83
    //   1198: invokevirtual 450	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   1201: pop
    //   1202: aload_2
    //   1203: ldc_w 452
    //   1206: aload 24
    //   1208: invokevirtual 107	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1211: pop
    //   1212: aload_2
    //   1213: ldc_w 454
    //   1216: aload 23
    //   1218: invokevirtual 107	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1221: pop
    //   1222: aload_2
    //   1223: ldc_w 456
    //   1226: aload 22
    //   1228: invokevirtual 107	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1231: pop
    //   1232: aload_2
    //   1233: ldc_w 458
    //   1236: iconst_1
    //   1237: invokevirtual 461	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1240: pop
    //   1241: aload_2
    //   1242: ldc_w 463
    //   1245: aload 21
    //   1247: invokevirtual 107	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1250: pop
    //   1251: iload 5
    //   1253: ifeq +118 -> 1371
    //   1256: aload_2
    //   1257: ldc_w 465
    //   1260: iconst_1
    //   1261: invokevirtual 112	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1264: pop
    //   1265: aload_2
    //   1266: ldc_w 467
    //   1269: aload 23
    //   1271: invokevirtual 107	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1274: pop
    //   1275: aload_2
    //   1276: ldc_w 469
    //   1279: bipush 29
    //   1281: invokevirtual 461	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1284: pop
    //   1285: invokestatic 475	com/tencent/mm/model/y:aBq	()Lcom/tencent/mm/model/y;
    //   1288: ldc_w 477
    //   1291: iconst_1
    //   1292: invokevirtual 481	com/tencent/mm/model/y:F	(Ljava/lang/String;Z)Lcom/tencent/mm/model/y$b;
    //   1295: astore_1
    //   1296: aload_1
    //   1297: ldc_w 456
    //   1300: aload 22
    //   1302: invokevirtual 487	com/tencent/mm/model/y$b:k	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/y$b;
    //   1305: pop
    //   1306: aload_1
    //   1307: ldc_w 463
    //   1310: aload 21
    //   1312: invokevirtual 487	com/tencent/mm/model/y$b:k	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/y$b;
    //   1315: pop
    //   1316: aload_1
    //   1317: ldc_w 489
    //   1320: iload 8
    //   1322: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1325: invokevirtual 487	com/tencent/mm/model/y$b:k	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/y$b;
    //   1328: pop
    //   1329: ldc 141
    //   1331: ldc_w 491
    //   1334: iconst_3
    //   1335: anewarray 4	java/lang/Object
    //   1338: dup
    //   1339: iconst_0
    //   1340: aload 22
    //   1342: aastore
    //   1343: dup
    //   1344: iconst_1
    //   1345: aload 21
    //   1347: aastore
    //   1348: dup
    //   1349: iconst_2
    //   1350: iload 8
    //   1352: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1355: aastore
    //   1356: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1359: iconst_2
    //   1360: invokestatic 415	com/tencent/mm/plugin/base/stub/f:yO	(I)V
    //   1363: aload_2
    //   1364: aload_0
    //   1365: invokestatic 494	com/tencent/mm/plugin/base/stub/f:v	(Landroid/content/Intent;Landroid/content/Context;)V
    //   1368: goto -298 -> 1070
    //   1371: aload_2
    //   1372: ldc_w 469
    //   1375: bipush 19
    //   1377: invokevirtual 461	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1380: pop
    //   1381: goto -96 -> 1285
    //   1384: lconst_0
    //   1385: lstore 10
    //   1387: goto -302 -> 1085
    //   1390: astore 19
    //   1392: ldc 176
    //   1394: astore 15
    //   1396: aload 18
    //   1398: astore_2
    //   1399: aload 17
    //   1401: astore 14
    //   1403: aload_1
    //   1404: astore 17
    //   1406: aload 19
    //   1408: astore_1
    //   1409: goto -776 -> 633
    //   1412: astore 18
    //   1414: aload_1
    //   1415: astore 17
    //   1417: aload 18
    //   1419: astore_1
    //   1420: goto -787 -> 633
    //   1423: astore 18
    //   1425: ldc 176
    //   1427: astore 15
    //   1429: aload 19
    //   1431: astore_2
    //   1432: aload 20
    //   1434: astore 14
    //   1436: aload_1
    //   1437: astore 17
    //   1439: aload 18
    //   1441: astore_1
    //   1442: goto -840 -> 602
    //   1445: astore 18
    //   1447: aload_1
    //   1448: astore 17
    //   1450: aload 18
    //   1452: astore_1
    //   1453: goto -851 -> 602
    //   1456: ldc 176
    //   1458: astore_1
    //   1459: goto -1048 -> 411
    //   1462: iconst_0
    //   1463: istore 8
    //   1465: goto -1284 -> 181
    //   1468: ldc 176
    //   1470: astore 16
    //   1472: goto -1306 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1475	0	paramContext	Context
    //   0	1475	1	paramArrayOfString1	String[]
    //   0	1475	2	paramArrayOfString2	String[]
    //   0	1475	3	paramBoolean1	boolean
    //   0	1475	4	paramBoolean2	boolean
    //   0	1475	5	paramBoolean3	boolean
    //   0	1475	6	paramBoolean4	boolean
    //   146	426	7	i	int
    //   179	1285	8	j	int
    //   290	3	9	k	int
    //   1083	303	10	l1	long
    //   1094	61	12	l2	long
    //   24	1411	14	localObject1	Object
    //   27	1401	15	localObject2	Object
    //   164	260	16	str1	String
    //   655	13	16	localException	Exception
    //   1470	1	16	str2	String
    //   193	1256	17	localObject3	Object
    //   197	1200	18	localObject4	Object
    //   1412	6	18	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   1423	17	18	localg1	com.tencent.mm.ac.g
    //   1445	6	18	localg2	com.tencent.mm.ac.g
    //   304	46	19	arrayOfString	String[]
    //   1390	40	19	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   308	1125	20	localObject5	Object
    //   35	1311	21	localObject6	Object
    //   31	1310	22	localObject7	Object
    //   134	1136	23	str3	String
    //   124	1083	24	str4	String
    //   250	106	25	locali	com.tencent.mm.ac.i
    // Exception table:
    //   from	to	target	type
    //   199	206	597	com/tencent/mm/ac/g
    //   214	229	597	com/tencent/mm/ac/g
    //   237	252	597	com/tencent/mm/ac/g
    //   260	273	597	com/tencent/mm/ac/g
    //   279	292	597	com/tencent/mm/ac/g
    //   584	591	597	com/tencent/mm/ac/g
    //   199	206	624	java/io/UnsupportedEncodingException
    //   214	229	624	java/io/UnsupportedEncodingException
    //   237	252	624	java/io/UnsupportedEncodingException
    //   260	273	624	java/io/UnsupportedEncodingException
    //   279	292	624	java/io/UnsupportedEncodingException
    //   584	591	624	java/io/UnsupportedEncodingException
    //   423	430	655	java/lang/Exception
    //   310	319	1390	java/io/UnsupportedEncodingException
    //   333	341	1390	java/io/UnsupportedEncodingException
    //   355	364	1390	java/io/UnsupportedEncodingException
    //   364	401	1412	java/io/UnsupportedEncodingException
    //   310	319	1423	com/tencent/mm/ac/g
    //   333	341	1423	com/tencent/mm/ac/g
    //   355	364	1423	com/tencent/mm/ac/g
    //   364	401	1445	com/tencent/mm/ac/g
  }
  
  private static MatrixCursor a(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(22239);
    if ((bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
    {
      ad.e("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink:packageName or signature null");
      AppMethodBeat.o(22239);
      return null;
    }
    Object localObject2 = new LinkedList();
    Object localObject1 = new du();
    ad.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink package name = %s, cgiType=%d", new Object[] { paramString2, Integer.valueOf(paramInt2) });
    ((du)localObject1).pkf = paramString2;
    ((du)localObject1).signature = paramString3;
    ((LinkedList)localObject2).add(localObject1);
    localObject1 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject1).hNM = new dpw();
    ((com.tencent.mm.al.b.a)localObject1).hNN = new dpx();
    ((com.tencent.mm.al.b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((com.tencent.mm.al.b.a)localObject1).funcId = 1200;
    com.tencent.mm.al.b localb = ((com.tencent.mm.al.b.a)localObject1).aDC();
    dpw localdpw = (dpw)localb.hNK.hNQ;
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (1 == paramInt2) {
      localObject1 = "&preload=1";
    }
    for (;;)
    {
      localdpw.link = ((String)localObject1);
      localStringBuilder = new StringBuilder().append(localdpw.link);
      if (2 == paramInt2)
      {
        localObject1 = "&jsForReport=1";
        localdpw.link = ((String)localObject1);
        localdpw.scene = 1;
        localdpw.HDW = ((LinkedList)localObject2);
        localObject2 = new CountDownLatch(1);
        localObject1 = new MatrixCursor(new String[] { "downloadUrl", "fileMd5", "expireTime", "extraBytes" });
        x.a(localb, new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(22228);
            ad.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(this.nNL) });
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              f.x(false, this.nNL);
              AppMethodBeat.o(22228);
              return 0;
            }
            f.x(true, this.nNL);
            paramAnonymousString = ((dpx)paramAnonymousb.hNL.hNQ).HDX;
            paramAnonymousb = Uri.parse(paramAnonymousString);
            paramAnonymousb.getQueryParameter("appid");
            paramAnonymousn = paramAnonymousb.getQueryParameter("userName");
            String str = paramAnonymousb.getQueryParameter("path");
            long l = bt.aRf(paramAnonymousb.getQueryParameter("validTime"));
            f.a(paramString1, this.nNN, paramString2, paramString3, paramInt1, paramAnonymousString, l);
            if (this.nNL != 1)
            {
              AppMethodBeat.o(22228);
              return 0;
            }
            ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).dQ(paramAnonymousn, str);
            ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.i.class)).Lc("");
            if (paramBoolean) {
              f.a(paramAnonymousn, str, this.nNQ, this.val$countDownLatch);
            }
            for (;;)
            {
              AppMethodBeat.o(22228);
              return 0;
              ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).RX(paramAnonymousn);
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
          ad.e("MicroMsg.WXBizLogic", paramString1.getMessage());
        }
        AppMethodBeat.o(22239);
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Uri paramUri, int paramInt, String paramString1, String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(22231);
    ad.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[] { paramString1, paramString2 });
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
      AppMethodBeat.o(22231);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    du localdu = new du();
    ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { paramString1 });
    localdu.pkf = paramString1;
    localdu.signature = paramString2;
    localLinkedList.add(localdu);
    paramUri = new ab(paramUri.toString(), paramInt, localLinkedList);
    paramActivity = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(22227);
        ba.aiU().b(1200, this);
        ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
          f.K(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousString = ((ab)paramAnonymousn).aLc();
        ad.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramAnonymousString });
        try
        {
          paramAnonymousString = Uri.parse(paramAnonymousString);
          if (paramAnonymousString == null)
          {
            ad.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
            f.K(this.val$activity);
            AppMethodBeat.o(22227);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramAnonymousString });
          f.K(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousn = paramAnonymousString.getQueryParameter("result");
        if (paramAnonymousn != null)
        {
          paramAnonymousn = URLDecoder.decode(paramAnonymousn);
          ad.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramAnonymousn });
          co localco = new co();
          localco.dns.activity = this.val$activity;
          localco.dns.dlG = paramAnonymousn;
          localco.dns.dnt = 19;
          localco.dns.from = 3;
          localco.dns.dnv = paramAnonymousString.getQueryParameter("appid");
          localco.dns.dnx = this.val$activity.getIntent().getBundleExtra("_stat_obj");
          com.tencent.mm.sdk.b.a.IbL.l(localco);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          aq.o(new Runnable()
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
    ba.aiU().a(1200, paramActivity);
    ba.aiU().a(paramUri, 0);
    AppMethodBeat.o(22231);
  }
  
  static void a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(193157);
    WXLaunchWxaRedirectingPage.Resp localResp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
    localResp.invokeTicket = paramReq.invokeTicket;
    localResp.callbackActivity = paramReq.callbackActivity;
    localResp.errCode = paramInt;
    localResp.errStr = paramString2;
    paramReq = new Bundle();
    localResp.toBundle(paramReq);
    com.tencent.mm.pluginsdk.model.app.q.bb(paramReq);
    com.tencent.mm.pluginsdk.model.app.q.bc(paramReq);
    paramString2 = new MMessageActV2.Args();
    paramString2.targetPkgName = paramString1;
    paramString2.bundle = paramReq;
    MMessageActV2.send(paramContext, paramString2);
    if ((paramContext instanceof WXBizEntryActivity)) {
      ((WXBizEntryActivity)paramContext).finish();
    }
    AppMethodBeat.o(193157);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong)
  {
    AppMethodBeat.i(22236);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(22236);
      return;
    }
    paramString1 = c(paramString1, paramInt1, paramString2, paramString3, paramInt2);
    paramString2 = new e();
    paramString2.hXx = System.currentTimeMillis();
    paramString2.nMZ = paramString4;
    if (paramLong > 0L) {
      paramString2.nNa = (1000L * paramLong);
    }
    nNB.put(paramString1, paramString2);
    AppMethodBeat.o(22236);
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(22232);
    if (paramContext == null)
    {
      ad.e("MicroMsg.WXBizLogic", "context is null");
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
        localObject1 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.bO(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    ad.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", new Object[] { str1, localObject1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
    {
      ad.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22232);
      return false;
    }
    str2 = paramArrayOfString1[0];
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22232);
      return false;
    }
    int i = bt.getInt(paramArrayOfString1[1], 0);
    if (i <= 0)
    {
      ad.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(22232);
      return false;
    }
    paramArrayOfString2 = bt.nullAsNil(paramArrayOfString1[2]);
    ad.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString2 });
    paramArrayOfString1 = "";
    try
    {
      paramArrayOfString2 = URLEncoder.encode(bt.nullAsNil(paramArrayOfString2), "UTF-8");
      paramArrayOfString1 = paramArrayOfString2;
    }
    catch (UnsupportedEncodingException paramArrayOfString2)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WXBizLogic", paramArrayOfString2, "", new Object[0]);
      }
    }
    paramArrayOfString1 = String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString1 });
    ad.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", new Object[] { paramArrayOfString1 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("key_app_id", str2);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", (String)localObject1);
    paramArrayOfString2.putExtra("key_command_id", 25);
    v(paramArrayOfString2, paramContext);
    AppMethodBeat.o(22232);
    return true;
  }
  
  private static void ac(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161302);
      if (bMd())
      {
        yO(31);
        long l = System.currentTimeMillis();
        ad.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry saveWXBizEntryIntent enterId=%d", new Object[] { Long.valueOf(l) });
        paramIntent.putExtra("__BIZ_ENTRY_ENTER_ID", l);
        nNC = paramIntent;
        bMf();
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
    //   3: ldc_w 691
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 677	com/tencent/mm/plugin/base/stub/f:bMd	()Z
    //   12: ifne +13 -> 25
    //   15: ldc_w 691
    //   18: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: ldc_w 681
    //   29: lconst_0
    //   30: invokevirtual 695	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +16 -> 53
    //   40: getstatic 53	com/tencent/mm/plugin/base/stub/f:nND	Ljava/util/Set;
    //   43: lload_1
    //   44: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokeinterface 698 2 0
    //   52: pop
    //   53: invokestatic 701	com/tencent/mm/plugin/base/stub/f:bMe	()V
    //   56: ldc 141
    //   58: ldc_w 703
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 530	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: ldc_w 691
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
      ad.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry isInConsumedSet %d", new Object[] { Long.valueOf(l) });
      boolean bool = nND.contains(Long.valueOf(l));
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
      ad.e("MicroMsg.WXBizLogic", "context is null");
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
        str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.bO(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    ad.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", new Object[] { str1, str2 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 4))
    {
      ad.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str5 = paramArrayOfString1[0];
    if (bt.isNullOrNil(str5))
    {
      ad.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str6 = paramArrayOfString1[1];
    if (bt.isNullOrNil(str6))
    {
      ad.e("MicroMsg.WXBizLogic", "businessType isEmpty");
      AppMethodBeat.o(22233);
      return false;
    }
    str3 = bt.nullAsNil(paramArrayOfString1[2]);
    str4 = bt.nullAsNil(paramArrayOfString1[3]);
    if (paramArrayOfString1.length > 4) {
      com.tencent.mm.pluginsdk.ui.tools.l.FkP = paramArrayOfString1[4];
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length > 5)
    {
      paramArrayOfString2 = paramArrayOfString1[5];
      h.m(str5, true, false);
    }
    boolean bool = str6.startsWith("native");
    if (bool)
    {
      paramArrayOfString1 = "openNativeView";
      paramArrayOfString1 = String.format("weixin://dl/%s/?appid=%s&businessType=%s", new Object[] { paramArrayOfString1, str5, str6 });
      ad.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", new Object[] { paramArrayOfString1, str3, str4 });
      if ((bool) || (bt.isNullOrNil(str4))) {
        break label520;
      }
    }
    for (;;)
    {
      try
      {
        int j = new com.tencent.mm.ac.i(str4).optInt("miniProgramType", 0);
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
        v(localIntent, paramContext);
        paramContext = y.aBq().F("key_data_center_session_id", true);
        paramContext.k("key_launch_miniprogram_type", Integer.valueOf(i));
        paramContext.k("key_launch_miniprogram_query_info", str3);
        paramContext.k("key_open_business_view_ext_info", str4);
        paramContext.k("key_launch_mini_program_open_id", paramArrayOfString2);
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
  
  public static void bMb()
  {
    AppMethodBeat.i(179576);
    ad.i("MicroMsg.WXBizLogic", "alvinluo reportGetCallingPackageNull");
    com.tencent.mm.plugin.report.service.g.yhR.n(1194L, 50L, 1L);
    AppMethodBeat.o(179576);
  }
  
  public static void bMc()
  {
    AppMethodBeat.i(179577);
    ad.i("MicroMsg.WXBizLogic", "alvinluo reportGetPackagesForUidMoreThanOne");
    com.tencent.mm.plugin.report.service.g.yhR.n(1194L, 51L, 1L);
    AppMethodBeat.o(179577);
  }
  
  public static boolean bMd()
  {
    AppMethodBeat.i(161300);
    if (nNE != -1)
    {
      if (nNE == 1)
      {
        AppMethodBeat.o(161300);
        return true;
      }
      AppMethodBeat.o(161300);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.i.DEBUG)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(161300);
      return false;
    }
    nNE = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qus, 1);
    ad.i("MicroMsg.WXBizLogic", "reTryOpenWXBizEntry open %d", new Object[] { Integer.valueOf(nNE) });
    if (nNE == 1)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    AppMethodBeat.o(161300);
    return false;
  }
  
  private static void bMe()
  {
    try
    {
      nNC = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void bMf()
  {
    AppMethodBeat.i(169736);
    if (appForegroundListener == null)
    {
      n.a local6 = new n.a()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          AppMethodBeat.i(193152);
          ad.d("MicroMsg.WXBizLogic", "turn onAppBackground");
          f.je(false);
          AppMethodBeat.o(193152);
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          AppMethodBeat.i(193151);
          f.je(true);
          f.sG(SystemClock.elapsedRealtime());
          ad.d("MicroMsg.WXBizLogic", "turn onAppForeground");
          if ((f.bMl() != null) && (com.tencent.mm.kernel.g.ajx()))
          {
            ad.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry onAppForeground");
            f.bMh();
          }
          AppMethodBeat.o(193151);
        }
      };
      appForegroundListener = local6;
      local6.alive();
    }
    AppMethodBeat.o(169736);
  }
  
  public static void bMg()
  {
    AppMethodBeat.i(161303);
    nNF = true;
    nNG = SystemClock.elapsedRealtime();
    bMh();
    AppMethodBeat.o(161303);
  }
  
  public static void bMh()
  {
    AppMethodBeat.i(169737);
    bMf();
    if ((nNC == null) || (!bMd()))
    {
      AppMethodBeat.o(169737);
      return;
    }
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193153);
        f.bMi();
        AppMethodBeat.o(193153);
      }
    }, 50L);
    AppMethodBeat.o(169737);
  }
  
  /* Error */
  public static void bMi()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 815
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 141
    //   11: ldc_w 817
    //   14: invokestatic 819	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 686	com/tencent/mm/plugin/base/stub/f:nNC	Landroid/content/Intent;
    //   20: ifnonnull +13 -> 33
    //   23: ldc_w 815
    //   26: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: getstatic 686	com/tencent/mm/plugin/base/stub/f:nNC	Landroid/content/Intent;
    //   36: ldc_w 681
    //   39: lconst_0
    //   40: invokevirtual 695	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   43: lstore_0
    //   44: invokestatic 385	java/lang/System:currentTimeMillis	()J
    //   47: lload_0
    //   48: lsub
    //   49: lstore_0
    //   50: getstatic 686	com/tencent/mm/plugin/base/stub/f:nNC	Landroid/content/Intent;
    //   53: invokestatic 821	com/tencent/mm/plugin/base/stub/f:ae	(Landroid/content/Intent;)Z
    //   56: ifne +132 -> 188
    //   59: lload_0
    //   60: invokestatic 827	java/lang/Math:abs	(J)J
    //   63: ldc2_w 411
    //   66: lcmp
    //   67: ifge +121 -> 188
    //   70: ldc 141
    //   72: ldc_w 829
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_0
    //   82: invokestatic 428	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 172	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: getstatic 686	com/tencent/mm/plugin/base/stub/f:nNC	Landroid/content/Intent;
    //   92: ldc_w 831
    //   95: iconst_1
    //   96: invokevirtual 112	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   99: pop
    //   100: invokestatic 93	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   103: astore_2
    //   104: getstatic 686	com/tencent/mm/plugin/base/stub/f:nNC	Landroid/content/Intent;
    //   107: astore_3
    //   108: new 833	com/tencent/mm/hellhoundlib/b/a
    //   111: dup
    //   112: invokespecial 834	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   115: aload_3
    //   116: invokevirtual 837	com/tencent/mm/hellhoundlib/b/a:bc	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   119: astore_3
    //   120: aload_2
    //   121: aload_3
    //   122: invokevirtual 841	com/tencent/mm/hellhoundlib/b/a:ahp	()[Ljava/lang/Object;
    //   125: ldc_w 843
    //   128: ldc_w 845
    //   131: ldc_w 846
    //   134: ldc_w 848
    //   137: ldc_w 850
    //   140: ldc_w 851
    //   143: invokestatic 856	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_3
    //   148: iconst_0
    //   149: invokevirtual 860	com/tencent/mm/hellhoundlib/b/a:mq	(I)Ljava/lang/Object;
    //   152: checkcast 81	android/content/Intent
    //   155: invokevirtual 864	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   158: aload_2
    //   159: ldc_w 843
    //   162: ldc_w 845
    //   165: ldc_w 846
    //   168: ldc_w 848
    //   171: ldc_w 850
    //   174: ldc_w 851
    //   177: invokestatic 867	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokestatic 701	com/tencent/mm/plugin/base/stub/f:bMe	()V
    //   183: bipush 30
    //   185: invokestatic 415	com/tencent/mm/plugin/base/stub/f:yO	(I)V
    //   188: ldc_w 815
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
  
  public static void bMj()
  {
    AppMethodBeat.i(179578);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qtx, 1);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        nNH = bool;
        ad.i("MicroMsg.WXBizLogic", "alvinluo updateGetCallingPackageStatus config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(nNH) });
        AppMethodBeat.o(179578);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WXBizLogic", localException, "alvinluo updateGetCallingPackageStatus exception", new Object[0]);
      nNH = true;
      AppMethodBeat.o(179578);
    }
  }
  
  public static boolean bMk()
  {
    return nNH;
  }
  
  private static String c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(22237);
    paramString1 = ai.ee(String.format("%s_%d_%s_%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(22237);
    return paramString1;
  }
  
  static void c(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(193156);
    if (paramContext == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.WXBizLogic", "doLaunchWxaRedirectingPage, context==null[%b], args[%s], packages[%s]", new Object[] { Boolean.valueOf(bool), Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      yP(1);
      if ((paramContext != null) && (paramArrayOfString2 != null) && (paramArrayOfString2[0].length() > 0)) {
        break;
      }
      yP(2);
      AppMethodBeat.o(193156);
      return;
    }
    WXLaunchWxaRedirectingPage.Req localReq = new WXLaunchWxaRedirectingPage.Req();
    String str = paramArrayOfString1[0];
    try
    {
      if (TextUtils.isEmpty(str))
      {
        yP(2);
        AppMethodBeat.o(193156);
        return;
      }
      localReq.fromArray((String[])org.apache.commons.b.a.g(paramArrayOfString1, paramArrayOfString1.length));
      paramArrayOfString1 = new Intent(paramContext, WXBizEntryActivity.class);
      paramArrayOfString1.setData(Uri.parse(String.format(Locale.ENGLISH, "weixin://dl/wmpf/sdk?appid=%s&ticket=%s", new Object[] { str, localReq.invokeTicket })));
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.putExtra("translate_link_scene", 1);
      paramArrayOfString1.putExtra("key_package_name", paramArrayOfString2[0]);
      paramArrayOfString2 = com.tencent.mm.pluginsdk.model.app.q.bO(paramContext, paramArrayOfString2[0]);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0)) {
        paramArrayOfString1.putExtra("key_package_signature", com.tencent.mm.b.g.getMessageDigest(paramArrayOfString2[0].toByteArray()));
      }
      paramArrayOfString2 = new Bundle();
      localReq.toBundle(paramArrayOfString2);
      paramArrayOfString1.putExtra("key_launch_wxa_redirecting_page_req", paramArrayOfString2);
      paramArrayOfString1.putExtra("key_command_id", 30);
      v(paramArrayOfString1, paramContext);
      AppMethodBeat.o(193156);
      return;
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.WXBizLogic", paramContext, "doLaunchWxaFRedirectingPage args[%s] packages[%s]", new Object[] { Arrays.toString(paramArrayOfString1), Arrays.toString(paramArrayOfString2) });
      yP(2);
      AppMethodBeat.o(193156);
    }
  }
  
  public static boolean s(String[] paramArrayOfString)
  {
    AppMethodBeat.i(22234);
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 6) && (bt.getBoolean(paramArrayOfString[5], false)))
    {
      AppMethodBeat.o(22234);
      return true;
    }
    AppMethodBeat.o(22234);
    return false;
  }
  
  static MatrixCursor t(String[] paramArrayOfString)
  {
    AppMethodBeat.i(193158);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      paramArrayOfString = new MatrixCursor(new String[0], 0);
      AppMethodBeat.o(193158);
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
        if (!org.apache.commons.b.a.contains(nNI, localObject)) {
          break label166;
        }
        str = "1";
        localObject = arrayOfString;
      }
      AppMethodBeat.o(193158);
      return localMatrixCursor;
    }
  }
  
  public static void v(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(161301);
      ac(paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.mq(0));
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
  
  public static void yO(int paramInt)
  {
    AppMethodBeat.i(22238);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1194L, paramInt, 1L, false);
    AppMethodBeat.o(22238);
  }
  
  static void yP(int paramInt)
  {
    AppMethodBeat.i(193155);
    com.tencent.mm.plugin.report.service.g.yhR.dD(1405, paramInt);
    AppMethodBeat.o(193155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f
 * JD-Core Version:    0.7.0.1
 */