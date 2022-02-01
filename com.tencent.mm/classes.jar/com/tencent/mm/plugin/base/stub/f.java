package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.az;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static n.a appForegroundListener;
  private static Map<String, e> nmO;
  private static Intent nmP;
  public static final Set<Long> nmQ;
  private static int nmR;
  private static boolean nmS;
  private static long nmT;
  private static boolean nmU;
  
  static
  {
    AppMethodBeat.i(22242);
    nmO = new HashMap();
    nmQ = new HashSet();
    nmR = -1;
    appForegroundListener = null;
    nmS = false;
    nmT = 0L;
    nmU = true;
    AppMethodBeat.o(22242);
  }
  
  /* Error */
  public static MatrixCursor a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: sipush 22235
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +18 -> 25
    //   10: ldc 125
    //   12: ldc 127
    //   14: invokestatic 133	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: sipush 22235
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: aconst_null
    //   26: astore 13
    //   28: aconst_null
    //   29: astore 14
    //   31: aload 13
    //   33: astore 21
    //   35: aload 14
    //   37: astore 20
    //   39: aload_2
    //   40: ifnull +38 -> 78
    //   43: aload 13
    //   45: astore 21
    //   47: aload 14
    //   49: astore 20
    //   51: aload_2
    //   52: arraylength
    //   53: ifle +25 -> 78
    //   56: aload_2
    //   57: iconst_0
    //   58: aaload
    //   59: astore 21
    //   61: aload_0
    //   62: aload_2
    //   63: iconst_0
    //   64: aaload
    //   65: invokestatic 139	com/tencent/mm/pluginsdk/model/app/q:bK	(Landroid/content/Context;Ljava/lang/String;)[Landroid/content/pm/Signature;
    //   68: iconst_0
    //   69: aaload
    //   70: invokevirtual 145	android/content/pm/Signature:toByteArray	()[B
    //   73: invokestatic 151	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   76: astore 20
    //   78: ldc 125
    //   80: ldc 153
    //   82: iconst_2
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload 21
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload 20
    //   95: aastore
    //   96: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: ifnull +9 -> 109
    //   103: aload_1
    //   104: arraylength
    //   105: iconst_2
    //   106: if_icmpge +18 -> 124
    //   109: ldc 125
    //   111: ldc 158
    //   113: invokestatic 133	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: sipush 22235
    //   119: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aconst_null
    //   123: areturn
    //   124: aload_1
    //   125: iconst_0
    //   126: aaload
    //   127: astore 22
    //   129: aload_1
    //   130: iconst_1
    //   131: aaload
    //   132: astore 23
    //   134: ldc 160
    //   136: astore 14
    //   138: iload 5
    //   140: ifeq +420 -> 560
    //   143: iconst_3
    //   144: istore 6
    //   146: ldc 160
    //   148: astore 13
    //   150: ldc 160
    //   152: astore_2
    //   153: aload_1
    //   154: arraylength
    //   155: iconst_2
    //   156: if_icmple +1016 -> 1172
    //   159: aload_1
    //   160: iconst_2
    //   161: aaload
    //   162: astore 15
    //   164: aload_1
    //   165: arraylength
    //   166: iconst_3
    //   167: if_icmple +999 -> 1166
    //   170: aload_1
    //   171: iconst_3
    //   172: aaload
    //   173: iconst_0
    //   174: invokestatic 166	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   177: istore 7
    //   179: aload_1
    //   180: arraylength
    //   181: iconst_4
    //   182: if_icmple +978 -> 1160
    //   185: aload_1
    //   186: iconst_4
    //   187: aaload
    //   188: astore_1
    //   189: aload 14
    //   191: astore 16
    //   193: aload 14
    //   195: astore 17
    //   197: aload_1
    //   198: invokestatic 170	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   201: ifne +365 -> 566
    //   204: aload 14
    //   206: astore 16
    //   208: aload 14
    //   210: astore 17
    //   212: ldc 125
    //   214: ldc 172
    //   216: iconst_1
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload_1
    //   223: aastore
    //   224: invokestatic 175	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload 14
    //   229: astore 16
    //   231: aload 14
    //   233: astore 17
    //   235: new 177	com/tencent/mm/ab/i
    //   238: dup
    //   239: aload_1
    //   240: ldc 179
    //   242: invokestatic 185	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   245: invokespecial 188	com/tencent/mm/ab/i:<init>	(Ljava/lang/String;)V
    //   248: astore 24
    //   250: aload 14
    //   252: astore 16
    //   254: aload 14
    //   256: astore 17
    //   258: aload 24
    //   260: ldc 190
    //   262: invokevirtual 194	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   265: ldc 179
    //   267: invokestatic 199	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: astore_1
    //   271: aload_1
    //   272: astore 16
    //   274: aload_1
    //   275: astore 17
    //   277: aload 24
    //   279: ldc 201
    //   281: invokevirtual 194	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   284: iconst_0
    //   285: invokestatic 166	com/tencent/mm/sdk/platformtools/bs:getInt	(Ljava/lang/String;I)I
    //   288: istore 8
    //   290: iload 8
    //   292: istore 6
    //   294: aload_2
    //   295: astore 17
    //   297: aload 13
    //   299: astore 16
    //   301: aload_2
    //   302: astore 18
    //   304: aload 13
    //   306: astore 19
    //   308: aload 24
    //   310: ldc 203
    //   312: invokevirtual 194	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   315: astore 13
    //   317: aload_2
    //   318: astore 17
    //   320: aload 13
    //   322: astore 16
    //   324: aload_2
    //   325: astore 18
    //   327: aload 13
    //   329: astore 19
    //   331: aload 24
    //   333: ldc 205
    //   335: invokevirtual 194	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore_2
    //   339: aload_2
    //   340: astore 17
    //   342: aload 13
    //   344: astore 16
    //   346: aload_2
    //   347: astore 18
    //   349: aload 13
    //   351: astore 19
    //   353: aload 24
    //   355: ldc 207
    //   357: invokevirtual 194	com/tencent/mm/ab/i:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   360: astore 14
    //   362: ldc 125
    //   364: ldc 209
    //   366: iconst_5
    //   367: anewarray 4	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: aload_1
    //   373: aastore
    //   374: dup
    //   375: iconst_1
    //   376: iload 6
    //   378: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_2
    //   384: aload 13
    //   386: aastore
    //   387: dup
    //   388: iconst_3
    //   389: aload_2
    //   390: aastore
    //   391: dup
    //   392: iconst_4
    //   393: aload 14
    //   395: aastore
    //   396: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   399: aload 14
    //   401: astore 16
    //   403: aload_1
    //   404: astore 14
    //   406: aload 16
    //   408: astore_1
    //   409: aload 15
    //   411: astore 16
    //   413: aload 15
    //   415: invokestatic 170	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   418: ifne +10 -> 428
    //   421: aload 15
    //   423: invokestatic 217	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   426: astore 16
    //   428: ldc 125
    //   430: ldc 219
    //   432: iconst_4
    //   433: anewarray 4	java/lang/Object
    //   436: dup
    //   437: iconst_0
    //   438: aload 22
    //   440: aastore
    //   441: dup
    //   442: iconst_1
    //   443: aload 23
    //   445: aastore
    //   446: dup
    //   447: iconst_2
    //   448: aload 16
    //   450: aastore
    //   451: dup
    //   452: iconst_3
    //   453: iload 7
    //   455: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: aastore
    //   459: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: ldc 221
    //   464: bipush 8
    //   466: anewarray 4	java/lang/Object
    //   469: dup
    //   470: iconst_0
    //   471: aload 22
    //   473: aastore
    //   474: dup
    //   475: iconst_1
    //   476: aload 23
    //   478: aastore
    //   479: dup
    //   480: iconst_2
    //   481: aload 16
    //   483: aastore
    //   484: dup
    //   485: iconst_3
    //   486: aload 14
    //   488: aastore
    //   489: dup
    //   490: iconst_4
    //   491: iload 6
    //   493: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: dup
    //   498: iconst_5
    //   499: aload 13
    //   501: aastore
    //   502: dup
    //   503: bipush 6
    //   505: aload_2
    //   506: aastore
    //   507: dup
    //   508: bipush 7
    //   510: aload_1
    //   511: aastore
    //   512: invokestatic 227	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   515: astore 13
    //   517: ldc 125
    //   519: ldc 229
    //   521: iconst_1
    //   522: anewarray 4	java/lang/Object
    //   525: dup
    //   526: iconst_0
    //   527: aload 13
    //   529: aastore
    //   530: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   533: iload_3
    //   534: ifeq +139 -> 673
    //   537: aload 13
    //   539: aload 21
    //   541: aload 20
    //   543: iload 7
    //   545: iconst_1
    //   546: iload 4
    //   548: invokestatic 232	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   551: astore_0
    //   552: sipush 22235
    //   555: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload_0
    //   559: areturn
    //   560: iconst_0
    //   561: istore 6
    //   563: goto -417 -> 146
    //   566: aload 14
    //   568: astore 16
    //   570: aload 14
    //   572: astore 17
    //   574: ldc 125
    //   576: ldc 234
    //   578: invokestatic 133	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: ldc 160
    //   583: astore_1
    //   584: goto -175 -> 409
    //   587: astore_1
    //   588: ldc 160
    //   590: astore 14
    //   592: ldc 125
    //   594: aload_1
    //   595: ldc 160
    //   597: iconst_0
    //   598: anewarray 4	java/lang/Object
    //   601: invokestatic 238	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   604: aload 14
    //   606: astore_1
    //   607: aload 16
    //   609: astore 14
    //   611: goto -202 -> 409
    //   614: astore_1
    //   615: ldc 160
    //   617: astore 14
    //   619: aload 17
    //   621: astore 16
    //   623: ldc 125
    //   625: aload_1
    //   626: ldc 160
    //   628: iconst_0
    //   629: anewarray 4	java/lang/Object
    //   632: invokestatic 238	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload 14
    //   637: astore_1
    //   638: aload 16
    //   640: astore 14
    //   642: goto -233 -> 409
    //   645: astore 15
    //   647: ldc 125
    //   649: ldc 240
    //   651: iconst_1
    //   652: anewarray 4	java/lang/Object
    //   655: dup
    //   656: iconst_0
    //   657: aload 15
    //   659: invokevirtual 244	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   662: aastore
    //   663: invokestatic 246	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   666: ldc 160
    //   668: astore 16
    //   670: goto -242 -> 428
    //   673: aload 13
    //   675: iconst_1
    //   676: aload 21
    //   678: aload 20
    //   680: iload 7
    //   682: invokestatic 250	com/tencent/mm/plugin/base/stub/f:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   685: astore_1
    //   686: getstatic 46	com/tencent/mm/plugin/base/stub/f:nmO	Ljava/util/Map;
    //   689: aload_1
    //   690: invokeinterface 256 2 0
    //   695: checkcast 258	com/tencent/mm/plugin/base/stub/e
    //   698: astore_2
    //   699: aload_2
    //   700: ifnull +21 -> 721
    //   703: aload_2
    //   704: astore_1
    //   705: invokestatic 264	java/lang/System:currentTimeMillis	()J
    //   708: aload_2
    //   709: getfield 267	com/tencent/mm/plugin/base/stub/e:nmt	J
    //   712: lsub
    //   713: aload_2
    //   714: getfield 270	com/tencent/mm/plugin/base/stub/e:hES	J
    //   717: lcmp
    //   718: ifle +5 -> 723
    //   721: aconst_null
    //   722: astore_1
    //   723: aload_1
    //   724: ifnull +153 -> 877
    //   727: aload_1
    //   728: getfield 274	com/tencent/mm/plugin/base/stub/e:nms	Ljava/lang/String;
    //   731: invokestatic 170	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   734: ifne +143 -> 877
    //   737: ldc 125
    //   739: ldc_w 276
    //   742: invokestatic 278	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: invokestatic 81	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   748: aload_1
    //   749: getfield 274	com/tencent/mm/plugin/base/stub/e:nms	Ljava/lang/String;
    //   752: aload 13
    //   754: invokestatic 284	com/tencent/mm/pluginsdk/f:G	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   757: pop
    //   758: aload 13
    //   760: aload 21
    //   762: aload 20
    //   764: iload 7
    //   766: iconst_2
    //   767: iconst_0
    //   768: invokestatic 232	com/tencent/mm/plugin/base/stub/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Landroid/database/MatrixCursor;
    //   771: pop
    //   772: getstatic 57	com/tencent/mm/plugin/base/stub/f:nmS	Z
    //   775: ifeq +313 -> 1088
    //   778: invokestatic 289	android/os/SystemClock:elapsedRealtime	()J
    //   781: getstatic 59	com/tencent/mm/plugin/base/stub/f:nmT	J
    //   784: lsub
    //   785: lstore 9
    //   787: lload 9
    //   789: lconst_0
    //   790: lcmp
    //   791: iflt +16 -> 807
    //   794: lload 9
    //   796: lstore 11
    //   798: lload 9
    //   800: ldc2_w 290
    //   803: lcmp
    //   804: ifle +6 -> 810
    //   807: lconst_0
    //   808: lstore 11
    //   810: lload 11
    //   812: ldc2_w 292
    //   815: lcmp
    //   816: ifle +8 -> 824
    //   819: bipush 20
    //   821: invokestatic 296	com/tencent/mm/plugin/base/stub/f:yf	(I)V
    //   824: getstatic 302	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   827: sipush 19218
    //   830: iconst_5
    //   831: anewarray 4	java/lang/Object
    //   834: dup
    //   835: iconst_0
    //   836: aload 22
    //   838: aastore
    //   839: dup
    //   840: iconst_1
    //   841: aload 21
    //   843: aastore
    //   844: dup
    //   845: iconst_2
    //   846: aload 20
    //   848: aastore
    //   849: dup
    //   850: iconst_3
    //   851: aload 23
    //   853: aastore
    //   854: dup
    //   855: iconst_4
    //   856: lload 11
    //   858: ldc2_w 303
    //   861: ldiv
    //   862: invokestatic 309	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   865: aastore
    //   866: invokevirtual 313	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   869: sipush 22235
    //   872: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   875: aconst_null
    //   876: areturn
    //   877: new 69	android/content/Intent
    //   880: dup
    //   881: aload_0
    //   882: ldc_w 315
    //   885: invokespecial 318	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   888: astore_1
    //   889: aload_1
    //   890: aload 13
    //   892: invokestatic 324	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   895: invokevirtual 328	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   898: pop
    //   899: aload_1
    //   900: ldc 71
    //   902: invokevirtual 331	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   905: pop
    //   906: aload_1
    //   907: ldc_w 333
    //   910: aload 22
    //   912: invokevirtual 95	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   915: pop
    //   916: aload_1
    //   917: ldc_w 335
    //   920: aload 23
    //   922: invokevirtual 95	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   925: pop
    //   926: aload_1
    //   927: ldc_w 337
    //   930: aload 21
    //   932: invokevirtual 95	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   935: pop
    //   936: aload_1
    //   937: ldc_w 339
    //   940: iconst_1
    //   941: invokevirtual 342	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   944: pop
    //   945: aload_1
    //   946: ldc_w 344
    //   949: aload 20
    //   951: invokevirtual 95	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   954: pop
    //   955: iload 5
    //   957: ifeq +118 -> 1075
    //   960: aload_1
    //   961: ldc_w 346
    //   964: iconst_1
    //   965: invokevirtual 100	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   968: pop
    //   969: aload_1
    //   970: ldc_w 348
    //   973: aload 23
    //   975: invokevirtual 95	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   978: pop
    //   979: aload_1
    //   980: ldc_w 350
    //   983: bipush 29
    //   985: invokevirtual 342	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   988: pop
    //   989: invokestatic 356	com/tencent/mm/model/y:ayq	()Lcom/tencent/mm/model/y;
    //   992: ldc_w 358
    //   995: iconst_1
    //   996: invokevirtual 362	com/tencent/mm/model/y:F	(Ljava/lang/String;Z)Lcom/tencent/mm/model/y$b;
    //   999: astore_2
    //   1000: aload_2
    //   1001: ldc_w 337
    //   1004: aload 21
    //   1006: invokevirtual 368	com/tencent/mm/model/y$b:l	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/y$b;
    //   1009: pop
    //   1010: aload_2
    //   1011: ldc_w 344
    //   1014: aload 20
    //   1016: invokevirtual 368	com/tencent/mm/model/y$b:l	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/y$b;
    //   1019: pop
    //   1020: aload_2
    //   1021: ldc_w 370
    //   1024: iload 7
    //   1026: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: invokevirtual 368	com/tencent/mm/model/y$b:l	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/model/y$b;
    //   1032: pop
    //   1033: ldc 125
    //   1035: ldc_w 372
    //   1038: iconst_3
    //   1039: anewarray 4	java/lang/Object
    //   1042: dup
    //   1043: iconst_0
    //   1044: aload 21
    //   1046: aastore
    //   1047: dup
    //   1048: iconst_1
    //   1049: aload 20
    //   1051: aastore
    //   1052: dup
    //   1053: iconst_2
    //   1054: iload 7
    //   1056: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1059: aastore
    //   1060: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1063: iconst_2
    //   1064: invokestatic 296	com/tencent/mm/plugin/base/stub/f:yf	(I)V
    //   1067: aload_1
    //   1068: aload_0
    //   1069: invokestatic 375	com/tencent/mm/plugin/base/stub/f:v	(Landroid/content/Intent;Landroid/content/Context;)V
    //   1072: goto -300 -> 772
    //   1075: aload_1
    //   1076: ldc_w 350
    //   1079: bipush 19
    //   1081: invokevirtual 342	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1084: pop
    //   1085: goto -96 -> 989
    //   1088: lconst_0
    //   1089: lstore 9
    //   1091: goto -304 -> 787
    //   1094: astore 18
    //   1096: ldc 160
    //   1098: astore 14
    //   1100: aload 17
    //   1102: astore_2
    //   1103: aload 16
    //   1105: astore 13
    //   1107: aload_1
    //   1108: astore 16
    //   1110: aload 18
    //   1112: astore_1
    //   1113: goto -490 -> 623
    //   1116: astore 17
    //   1118: aload_1
    //   1119: astore 16
    //   1121: aload 17
    //   1123: astore_1
    //   1124: goto -501 -> 623
    //   1127: astore 17
    //   1129: ldc 160
    //   1131: astore 14
    //   1133: aload 18
    //   1135: astore_2
    //   1136: aload 19
    //   1138: astore 13
    //   1140: aload_1
    //   1141: astore 16
    //   1143: aload 17
    //   1145: astore_1
    //   1146: goto -554 -> 592
    //   1149: astore 17
    //   1151: aload_1
    //   1152: astore 16
    //   1154: aload 17
    //   1156: astore_1
    //   1157: goto -565 -> 592
    //   1160: ldc 160
    //   1162: astore_1
    //   1163: goto -754 -> 409
    //   1166: iconst_0
    //   1167: istore 7
    //   1169: goto -990 -> 179
    //   1172: ldc 160
    //   1174: astore 15
    //   1176: goto -1012 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1179	0	paramContext	Context
    //   0	1179	1	paramArrayOfString1	String[]
    //   0	1179	2	paramArrayOfString2	String[]
    //   0	1179	3	paramBoolean1	boolean
    //   0	1179	4	paramBoolean2	boolean
    //   0	1179	5	paramBoolean3	boolean
    //   144	418	6	i	int
    //   177	991	7	j	int
    //   288	3	8	k	int
    //   785	305	9	l1	long
    //   796	61	11	l2	long
    //   26	1113	13	localObject1	Object
    //   29	1103	14	localObject2	Object
    //   162	260	15	str1	String
    //   645	13	15	localException	Exception
    //   1174	1	15	str2	String
    //   191	962	16	localObject3	Object
    //   195	906	17	localObject4	Object
    //   1116	6	17	localUnsupportedEncodingException1	UnsupportedEncodingException
    //   1127	17	17	localg1	com.tencent.mm.ab.g
    //   1149	6	17	localg2	com.tencent.mm.ab.g
    //   302	46	18	arrayOfString	String[]
    //   1094	40	18	localUnsupportedEncodingException2	UnsupportedEncodingException
    //   306	831	19	localObject5	Object
    //   37	1013	20	localObject6	Object
    //   33	1012	21	localObject7	Object
    //   127	784	22	str3	String
    //   132	842	23	str4	String
    //   248	106	24	locali	com.tencent.mm.ab.i
    // Exception table:
    //   from	to	target	type
    //   197	204	587	com/tencent/mm/ab/g
    //   212	227	587	com/tencent/mm/ab/g
    //   235	250	587	com/tencent/mm/ab/g
    //   258	271	587	com/tencent/mm/ab/g
    //   277	290	587	com/tencent/mm/ab/g
    //   574	581	587	com/tencent/mm/ab/g
    //   197	204	614	java/io/UnsupportedEncodingException
    //   212	227	614	java/io/UnsupportedEncodingException
    //   235	250	614	java/io/UnsupportedEncodingException
    //   258	271	614	java/io/UnsupportedEncodingException
    //   277	290	614	java/io/UnsupportedEncodingException
    //   574	581	614	java/io/UnsupportedEncodingException
    //   421	428	645	java/lang/Exception
    //   308	317	1094	java/io/UnsupportedEncodingException
    //   331	339	1094	java/io/UnsupportedEncodingException
    //   353	362	1094	java/io/UnsupportedEncodingException
    //   362	399	1116	java/io/UnsupportedEncodingException
    //   308	317	1127	com/tencent/mm/ab/g
    //   331	339	1127	com/tencent/mm/ab/g
    //   353	362	1127	com/tencent/mm/ab/g
    //   362	399	1149	com/tencent/mm/ab/g
  }
  
  private static MatrixCursor a(final String paramString1, final String paramString2, final String paramString3, final int paramInt1, int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(22239);
    if ((bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString3)))
    {
      ac.e("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink:packageName or signature null");
      AppMethodBeat.o(22239);
      return null;
    }
    Object localObject2 = new LinkedList();
    Object localObject1 = new dt();
    ac.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink package name = %s, cgiType=%d", new Object[] { paramString2, Integer.valueOf(paramInt2) });
    ((dt)localObject1).oGB = paramString2;
    ((dt)localObject1).signature = paramString3;
    ((LinkedList)localObject2).add(localObject1);
    localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).hvt = new dkf();
    ((com.tencent.mm.ak.b.a)localObject1).hvu = new dkg();
    ((com.tencent.mm.ak.b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/translatelink";
    ((com.tencent.mm.ak.b.a)localObject1).funcId = 1200;
    com.tencent.mm.ak.b localb = ((com.tencent.mm.ak.b.a)localObject1).aAz();
    dkf localdkf = (dkf)localb.hvr.hvw;
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (1 == paramInt2) {
      localObject1 = "&preload=1";
    }
    for (;;)
    {
      localdkf.link = ((String)localObject1);
      localStringBuilder = new StringBuilder().append(localdkf.link);
      if (2 == paramInt2)
      {
        localObject1 = "&jsForReport=1";
        localdkf.link = ((String)localObject1);
        localdkf.scene = 1;
        localdkf.FTk = ((LinkedList)localObject2);
        localObject2 = new CountDownLatch(1);
        localObject1 = new MatrixCursor(new String[] { "downloadUrl", "fileMd5", "expireTime", "extraBytes" });
        x.a(localb, new x.a()
        {
          public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
          {
            AppMethodBeat.i(22228);
            ac.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(this.nmX) });
            if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
            {
              f.yf(12);
              AppMethodBeat.o(22228);
              return 0;
            }
            f.yf(11);
            paramAnonymousString = ((dkg)paramAnonymousb.hvs.hvw).FTl;
            paramAnonymousb = Uri.parse(paramAnonymousString);
            paramAnonymousb.getQueryParameter("appid");
            paramAnonymousn = paramAnonymousb.getQueryParameter("userName");
            String str = paramAnonymousb.getQueryParameter("path");
            long l = bs.aLz(paramAnonymousb.getQueryParameter("validTime"));
            f.a(paramString1, this.nmZ, paramString2, paramString3, paramInt1, paramAnonymousString, l);
            if (this.nmX != 1)
            {
              AppMethodBeat.o(22228);
              return 0;
            }
            ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).dJ(paramAnonymousn, str);
            ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.i.class)).HK("");
            if (paramBoolean) {
              f.a(paramAnonymousn, str, this.nnc, this.nnd);
            }
            for (;;)
            {
              AppMethodBeat.o(22228);
              return 0;
              ((com.tencent.mm.plugin.appbrand.launching.b.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).Ox(paramAnonymousn);
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
          ac.e("MicroMsg.WXBizLogic", paramString1.getMessage());
        }
        AppMethodBeat.o(22239);
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, Uri paramUri, int paramInt, String paramString1, String paramString2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(22231);
    ac.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[] { paramString1, paramString2 });
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
      AppMethodBeat.o(22231);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    dt localdt = new dt();
    ac.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[] { paramString1 });
    localdt.oGB = paramString1;
    localdt.signature = paramString2;
    localLinkedList.add(localdt);
    paramUri = new ab(paramUri.toString(), paramInt, localLinkedList);
    paramActivity = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(22227);
        az.agi().b(1200, this);
        ac.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
          f.K(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousString = ((ab)paramAnonymousn).aHR();
        ac.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", new Object[] { paramAnonymousString });
        try
        {
          paramAnonymousString = Uri.parse(paramAnonymousString);
          if (paramAnonymousString == null)
          {
            ac.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
            f.K(this.val$activity);
            AppMethodBeat.o(22227);
            return;
          }
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", new Object[] { paramAnonymousString });
          f.K(this.val$activity);
          AppMethodBeat.o(22227);
          return;
        }
        paramAnonymousn = paramAnonymousString.getQueryParameter("result");
        if (paramAnonymousn != null)
        {
          paramAnonymousn = URLDecoder.decode(paramAnonymousn);
          ac.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", new Object[] { paramAnonymousn });
          cl localcl = new cl();
          localcl.dbW.activity = this.val$activity;
          localcl.dbW.dam = paramAnonymousn;
          localcl.dbW.dbX = 19;
          localcl.dbW.from = 3;
          localcl.dbW.dbZ = paramAnonymousString.getQueryParameter("appid");
          localcl.dbW.dcb = this.val$activity.getIntent().getBundleExtra("_stat_obj");
          com.tencent.mm.sdk.b.a.GpY.l(localcl);
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          ap.n(new Runnable()
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
    az.agi().a(1200, paramActivity);
    az.agi().a(paramUri, 0);
    AppMethodBeat.o(22231);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong)
  {
    AppMethodBeat.i(22236);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(22236);
      return;
    }
    paramString1 = c(paramString1, paramInt1, paramString2, paramString3, paramInt2);
    paramString2 = new e();
    paramString2.hES = System.currentTimeMillis();
    paramString2.nms = paramString4;
    if (paramLong > 0L) {
      paramString2.nmt = (1000L * paramLong);
    }
    nmO.put(paramString1, paramString2);
    AppMethodBeat.o(22236);
  }
  
  public static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(22232);
    if (paramContext == null)
    {
      ac.e("MicroMsg.WXBizLogic", "context is null");
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
        localObject1 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.bK(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    ac.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", new Object[] { str1, localObject1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
    {
      ac.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22232);
      return false;
    }
    str2 = paramArrayOfString1[0];
    if (bs.isNullOrNil(str2))
    {
      ac.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22232);
      return false;
    }
    int i = bs.getInt(paramArrayOfString1[1], 0);
    if (i <= 0)
    {
      ac.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(22232);
      return false;
    }
    paramArrayOfString2 = bs.nullAsNil(paramArrayOfString1[2]);
    ac.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString2 });
    paramArrayOfString1 = "";
    try
    {
      paramArrayOfString2 = URLEncoder.encode(bs.nullAsNil(paramArrayOfString2), "UTF-8");
      paramArrayOfString1 = paramArrayOfString2;
    }
    catch (UnsupportedEncodingException paramArrayOfString2)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.WXBizLogic", paramArrayOfString2, "", new Object[0]);
      }
    }
    paramArrayOfString1 = String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString1 });
    ac.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", new Object[] { paramArrayOfString1 });
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
  
  private static void aa(Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(161302);
      if (bHS())
      {
        yf(31);
        long l = System.currentTimeMillis();
        ac.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry saveWXBizEntryIntent enterId=%d", new Object[] { Long.valueOf(l) });
        paramIntent.putExtra("__BIZ_ENTRY_ENTER_ID", l);
        nmP = paramIntent;
        bHU();
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
    //   3: ldc_w 608
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 595	com/tencent/mm/plugin/base/stub/f:bHS	()Z
    //   12: ifne +13 -> 25
    //   15: ldc_w 608
    //   18: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: ldc_w 599
    //   29: lconst_0
    //   30: invokevirtual 612	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifeq +16 -> 53
    //   40: getstatic 51	com/tencent/mm/plugin/base/stub/f:nmQ	Ljava/util/Set;
    //   43: lload_1
    //   44: invokestatic 309	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: invokeinterface 615 2 0
    //   52: pop
    //   53: invokestatic 618	com/tencent/mm/plugin/base/stub/f:bHT	()V
    //   56: ldc 125
    //   58: ldc_w 620
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 309	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 504	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: ldc_w 608
    //   78: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      ac.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry isInConsumedSet %d", new Object[] { Long.valueOf(l) });
      boolean bool = nmQ.contains(Long.valueOf(l));
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
      ac.e("MicroMsg.WXBizLogic", "context is null");
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
        str2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.bK(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    ac.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", new Object[] { str1, str2 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 4))
    {
      ac.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str5 = paramArrayOfString1[0];
    if (bs.isNullOrNil(str5))
    {
      ac.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(22233);
      return false;
    }
    String str6 = paramArrayOfString1[1];
    if (bs.isNullOrNil(str6))
    {
      ac.e("MicroMsg.WXBizLogic", "businessType isEmpty");
      AppMethodBeat.o(22233);
      return false;
    }
    str3 = bs.nullAsNil(paramArrayOfString1[2]);
    str4 = bs.nullAsNil(paramArrayOfString1[3]);
    if (paramArrayOfString1.length > 4) {
      com.tencent.mm.pluginsdk.ui.tools.l.DFK = paramArrayOfString1[4];
    }
    paramArrayOfString2 = "";
    if (paramArrayOfString1.length > 5)
    {
      paramArrayOfString2 = paramArrayOfString1[5];
      com.tencent.mm.pluginsdk.model.app.h.k(str5, true, false);
    }
    boolean bool = str6.startsWith("native");
    if (bool)
    {
      paramArrayOfString1 = "openNativeView";
      paramArrayOfString1 = String.format("weixin://dl/%s/?appid=%s&businessType=%s", new Object[] { paramArrayOfString1, str5, str6 });
      ac.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", new Object[] { paramArrayOfString1, str3, str4 });
      if ((bool) || (bs.isNullOrNil(str4))) {
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
        v(localIntent, paramContext);
        paramContext = y.ayq().F("key_data_center_session_id", true);
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
  
  public static void bHQ()
  {
    AppMethodBeat.i(179576);
    ac.i("MicroMsg.WXBizLogic", "alvinluo reportGetCallingPackageNull");
    com.tencent.mm.plugin.report.service.h.wUl.n(1194L, 50L, 1L);
    AppMethodBeat.o(179576);
  }
  
  public static void bHR()
  {
    AppMethodBeat.i(179577);
    ac.i("MicroMsg.WXBizLogic", "alvinluo reportGetPackagesForUidMoreThanOne");
    com.tencent.mm.plugin.report.service.h.wUl.n(1194L, 51L, 1L);
    AppMethodBeat.o(179577);
  }
  
  public static boolean bHS()
  {
    AppMethodBeat.i(161300);
    if (nmR != -1)
    {
      if (nmR == 1)
      {
        AppMethodBeat.o(161300);
        return true;
      }
      AppMethodBeat.o(161300);
      return false;
    }
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(161300);
      return false;
    }
    nmR = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pQf, 1);
    ac.i("MicroMsg.WXBizLogic", "reTryOpenWXBizEntry open %d", new Object[] { Integer.valueOf(nmR) });
    if (nmR == 1)
    {
      AppMethodBeat.o(161300);
      return true;
    }
    AppMethodBeat.o(161300);
    return false;
  }
  
  private static void bHT()
  {
    try
    {
      nmP = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void bHU()
  {
    AppMethodBeat.i(169736);
    if (appForegroundListener == null)
    {
      n.a local5 = new n.a()
      {
        public final void onAppBackground(String paramAnonymousString)
        {
          AppMethodBeat.i(169735);
          ac.d("MicroMsg.WXBizLogic", "turn onAppBackground");
          f.access$202(false);
          AppMethodBeat.o(169735);
        }
        
        public final void onAppForeground(String paramAnonymousString)
        {
          AppMethodBeat.i(161298);
          f.access$202(true);
          f.rh(SystemClock.elapsedRealtime());
          ac.d("MicroMsg.WXBizLogic", "turn onAppForeground");
          if ((f.bIa() != null) && (com.tencent.mm.kernel.g.agM()))
          {
            ac.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry onAppForeground");
            f.bHW();
          }
          AppMethodBeat.o(161298);
        }
      };
      appForegroundListener = local5;
      local5.alive();
    }
    AppMethodBeat.o(169736);
  }
  
  public static void bHV()
  {
    AppMethodBeat.i(161303);
    nmS = true;
    nmT = SystemClock.elapsedRealtime();
    bHW();
    AppMethodBeat.o(161303);
  }
  
  public static void bHW()
  {
    AppMethodBeat.i(169737);
    bHU();
    if ((nmP == null) || (!bHS()))
    {
      AppMethodBeat.o(169737);
      return;
    }
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(161299);
        f.bHX();
        AppMethodBeat.o(161299);
      }
    }, 50L);
    AppMethodBeat.o(169737);
  }
  
  /* Error */
  public static void bHX()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 734
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 125
    //   11: ldc_w 736
    //   14: invokestatic 738	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 604	com/tencent/mm/plugin/base/stub/f:nmP	Landroid/content/Intent;
    //   20: ifnonnull +13 -> 33
    //   23: ldc_w 734
    //   26: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: return
    //   33: getstatic 604	com/tencent/mm/plugin/base/stub/f:nmP	Landroid/content/Intent;
    //   36: ldc_w 599
    //   39: lconst_0
    //   40: invokevirtual 612	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   43: lstore_0
    //   44: invokestatic 264	java/lang/System:currentTimeMillis	()J
    //   47: lload_0
    //   48: lsub
    //   49: lstore_0
    //   50: getstatic 604	com/tencent/mm/plugin/base/stub/f:nmP	Landroid/content/Intent;
    //   53: invokestatic 740	com/tencent/mm/plugin/base/stub/f:ac	(Landroid/content/Intent;)Z
    //   56: ifne +132 -> 188
    //   59: lload_0
    //   60: invokestatic 746	java/lang/Math:abs	(J)J
    //   63: ldc2_w 292
    //   66: lcmp
    //   67: ifge +121 -> 188
    //   70: ldc 125
    //   72: ldc_w 748
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: lload_0
    //   82: invokestatic 309	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: aastore
    //   86: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: getstatic 604	com/tencent/mm/plugin/base/stub/f:nmP	Landroid/content/Intent;
    //   92: ldc_w 750
    //   95: iconst_1
    //   96: invokevirtual 100	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   99: pop
    //   100: invokestatic 81	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   103: astore_2
    //   104: getstatic 604	com/tencent/mm/plugin/base/stub/f:nmP	Landroid/content/Intent;
    //   107: astore_3
    //   108: new 752	com/tencent/mm/hellhoundlib/b/a
    //   111: dup
    //   112: invokespecial 753	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   115: aload_3
    //   116: invokevirtual 757	com/tencent/mm/hellhoundlib/b/a:ba	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   119: astore_3
    //   120: aload_2
    //   121: aload_3
    //   122: invokevirtual 761	com/tencent/mm/hellhoundlib/b/a:aeD	()[Ljava/lang/Object;
    //   125: ldc_w 763
    //   128: ldc_w 765
    //   131: ldc_w 766
    //   134: ldc_w 768
    //   137: ldc_w 770
    //   140: ldc_w 771
    //   143: invokestatic 776	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: aload_3
    //   148: iconst_0
    //   149: invokevirtual 780	com/tencent/mm/hellhoundlib/b/a:lR	(I)Ljava/lang/Object;
    //   152: checkcast 69	android/content/Intent
    //   155: invokevirtual 784	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   158: aload_2
    //   159: ldc_w 763
    //   162: ldc_w 765
    //   165: ldc_w 766
    //   168: ldc_w 768
    //   171: ldc_w 770
    //   174: ldc_w 771
    //   177: invokestatic 787	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   180: invokestatic 618	com/tencent/mm/plugin/base/stub/f:bHT	()V
    //   183: bipush 30
    //   185: invokestatic 296	com/tencent/mm/plugin/base/stub/f:yf	(I)V
    //   188: ldc_w 734
    //   191: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void bHY()
  {
    AppMethodBeat.i(179578);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPx, 1);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        nmU = bool;
        ac.i("MicroMsg.WXBizLogic", "alvinluo updateGetCallingPackageStatus config: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(nmU) });
        AppMethodBeat.o(179578);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WXBizLogic", localException, "alvinluo updateGetCallingPackageStatus exception", new Object[0]);
      nmU = true;
      AppMethodBeat.o(179578);
    }
  }
  
  public static boolean bHZ()
  {
    return nmU;
  }
  
  private static String c(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(22237);
    paramString1 = ah.dg(String.format("%s_%d_%s_%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2) }));
    AppMethodBeat.o(22237);
    return paramString1;
  }
  
  public static boolean s(String[] paramArrayOfString)
  {
    AppMethodBeat.i(22234);
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 6) && (bs.getBoolean(paramArrayOfString[5], false)))
    {
      AppMethodBeat.o(22234);
      return true;
    }
    AppMethodBeat.o(22234);
    return false;
  }
  
  public static void v(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(161301);
      aa(paramIntent);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.lR(0));
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
  
  public static void yf(int paramInt)
  {
    AppMethodBeat.i(22238);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1194L, paramInt, 1L, false);
    AppMethodBeat.o(22238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f
 * JD-Core Version:    0.7.0.1
 */