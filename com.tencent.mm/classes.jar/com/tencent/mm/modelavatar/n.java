package com.tencent.mm.modelavatar;

import androidx.f.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ftl;
import com.tencent.mm.protocal.protobuf.ftm;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public final class n
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int dIY;
  private String hQn;
  private String osW;
  private String osX;
  private int osy;
  private int osz;
  private String username;
  
  public n(int paramInt, String paramString)
  {
    this(1, paramString, (byte)0);
  }
  
  public n(int paramInt, String paramString, byte paramByte)
  {
    AppMethodBeat.i(231344);
    this.username = null;
    if (Util.isNullOrNil(null))
    {
      this.username = z.bAM();
      if (paramInt == 2) {
        this.username = au.bxd(this.username);
      }
    }
    q.bFp();
    this.osW = AvatarStorage.R(this.username, true);
    String str = this.osW + ".tmp";
    if (bt(paramString, str) == 0)
    {
      this.hQn = str;
      this.osz = paramInt;
      q.bFp();
      this.osX = com.tencent.mm.b.g.getMessageDigest(y.bi(AvatarStorage.Q(this.username, true), 0, -1));
      this.osy = 0;
      this.dIY = 0;
    }
    AppMethodBeat.o(231344);
  }
  
  private static boolean LU(String paramString)
  {
    AppMethodBeat.i(231340);
    try
    {
      Object localObject = new a(paramString);
      paramString = ((a)localObject).aC("GPSLongitude");
      String str1 = ((a)localObject).aC("GPSLatitude");
      String str2 = ((a)localObject).aC("GPSLongitudeRef");
      String str3 = ((a)localObject).aC("GPSLatitudeRef");
      String str4 = ((a)localObject).aC("GPSDestLongitude");
      localObject = ((a)localObject).aC("GPSDestLongitudeRef");
      if ((paramString != null) || (str1 != null) || (str2 != null) || (str3 != null) || (str4 != null) || (localObject != null))
      {
        AppMethodBeat.o(231340);
        return true;
      }
      AppMethodBeat.o(231340);
      return false;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(231340);
    }
    return false;
  }
  
  /* Error */
  private static int bt(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 144	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   9: astore 12
    //   11: new 146	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 147	java/util/ArrayList:<init>	()V
    //   18: astore 11
    //   20: aload 11
    //   22: new 149	com/tencent/mars/smc/IDKey
    //   25: dup
    //   26: sipush 1515
    //   29: iconst_0
    //   30: iconst_1
    //   31: invokespecial 152	com/tencent/mars/smc/IDKey:<init>	(III)V
    //   34: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload 12
    //   40: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   43: sipush 640
    //   46: if_icmpge +188 -> 234
    //   49: aload 12
    //   51: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: sipush 640
    //   57: if_icmpge +177 -> 234
    //   60: iconst_1
    //   61: istore 4
    //   63: aload_0
    //   64: invokestatic 166	com/tencent/mm/modelavatar/n:LU	(Ljava/lang/String;)Z
    //   67: istore 10
    //   69: iload 4
    //   71: ifeq +175 -> 246
    //   74: iload 10
    //   76: ifeq +164 -> 240
    //   79: iconst_1
    //   80: istore 4
    //   82: aload 11
    //   84: new 149	com/tencent/mars/smc/IDKey
    //   87: dup
    //   88: sipush 1515
    //   91: iload 4
    //   93: iconst_1
    //   94: invokespecial 152	com/tencent/mars/smc/IDKey:<init>	(III)V
    //   97: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: getstatic 172	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
    //   104: aload 11
    //   106: iconst_0
    //   107: invokevirtual 176	com/tencent/mm/plugin/report/f:b	(Ljava/util/ArrayList;Z)V
    //   110: aload 12
    //   112: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   115: sipush 640
    //   118: if_icmpge +145 -> 263
    //   121: aload 12
    //   123: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   126: sipush 640
    //   129: if_icmpge +134 -> 263
    //   132: aload_0
    //   133: aload_1
    //   134: iconst_0
    //   135: invokestatic 180	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   138: pop2
    //   139: new 117	androidx/f/a/a
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 120	androidx/f/a/a:<init>	(Ljava/lang/String;)V
    //   147: astore_0
    //   148: aload_0
    //   149: ldc 122
    //   151: aconst_null
    //   152: invokevirtual 184	androidx/f/a/a:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: ldc 127
    //   158: aconst_null
    //   159: invokevirtual 184	androidx/f/a/a:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_0
    //   163: ldc 129
    //   165: aconst_null
    //   166: invokevirtual 184	androidx/f/a/a:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: ldc 131
    //   172: aconst_null
    //   173: invokevirtual 184	androidx/f/a/a:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_0
    //   177: ldc 133
    //   179: aconst_null
    //   180: invokevirtual 184	androidx/f/a/a:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: ldc 135
    //   186: aconst_null
    //   187: invokevirtual 184	androidx/f/a/a:m	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_0
    //   191: invokevirtual 187	androidx/f/a/a:FM	()V
    //   194: ldc 189
    //   196: ldc 191
    //   198: iconst_2
    //   199: anewarray 193	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 12
    //   206: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   209: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: aload 12
    //   217: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   220: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: ldc 138
    //   229: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: iconst_0
    //   233: ireturn
    //   234: iconst_0
    //   235: istore 4
    //   237: goto -174 -> 63
    //   240: iconst_2
    //   241: istore 4
    //   243: goto -161 -> 82
    //   246: iload 10
    //   248: ifeq +9 -> 257
    //   251: iconst_3
    //   252: istore 4
    //   254: goto -172 -> 82
    //   257: iconst_4
    //   258: istore 4
    //   260: goto -178 -> 82
    //   263: bipush 50
    //   265: istore 4
    //   267: invokestatic 210	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   270: invokestatic 216	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   273: ifeq +431 -> 704
    //   276: ldc 218
    //   278: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   281: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   284: invokeinterface 228 1 0
    //   289: ldc 230
    //   291: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   294: bipush 50
    //   296: invokestatic 239	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   299: istore 5
    //   301: iload 5
    //   303: istore 4
    //   305: iconst_0
    //   306: istore 7
    //   308: iconst_0
    //   309: istore 6
    //   311: iload 6
    //   313: istore 5
    //   315: invokestatic 210	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   318: invokestatic 216	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   321: ifeq +500 -> 821
    //   324: iload 6
    //   326: istore 5
    //   328: ldc 218
    //   330: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   333: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   336: invokeinterface 228 1 0
    //   341: ldc 241
    //   343: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   346: astore 11
    //   348: iload 6
    //   350: istore 5
    //   352: aload 11
    //   354: ldc 243
    //   356: invokevirtual 249	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   359: istore 8
    //   361: iload 7
    //   363: istore 5
    //   365: iconst_m1
    //   366: iload 8
    //   368: if_icmpeq +565 -> 933
    //   371: iload 6
    //   373: istore 5
    //   375: aload 11
    //   377: iconst_0
    //   378: iload 8
    //   380: invokevirtual 253	java/lang/String:substring	(II)Ljava/lang/String;
    //   383: invokestatic 256	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   386: invokevirtual 260	java/lang/Integer:intValue	()I
    //   389: istore 6
    //   391: iload 6
    //   393: istore 5
    //   395: aload 11
    //   397: iload 8
    //   399: iconst_1
    //   400: iadd
    //   401: invokevirtual 263	java/lang/String:substring	(I)Ljava/lang/String;
    //   404: invokestatic 256	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   407: invokevirtual 260	java/lang/Integer:intValue	()I
    //   410: istore 7
    //   412: iload 6
    //   414: istore 5
    //   416: iload 7
    //   418: istore 6
    //   420: iload 5
    //   422: ifgt +519 -> 941
    //   425: iload 6
    //   427: ifgt +514 -> 941
    //   430: iconst_0
    //   431: istore 6
    //   433: sipush 1080
    //   436: istore 5
    //   438: aload 12
    //   440: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   443: aload 12
    //   445: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   448: if_icmple +536 -> 984
    //   451: aload 12
    //   453: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   456: istore 7
    //   458: aload 12
    //   460: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   463: aload 12
    //   465: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   468: if_icmpge +526 -> 994
    //   471: aload 12
    //   473: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   476: istore 8
    //   478: ldc 189
    //   480: ldc_w 265
    //   483: iconst_5
    //   484: anewarray 193	java/lang/Object
    //   487: dup
    //   488: iconst_0
    //   489: iload 6
    //   491: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   494: aastore
    //   495: dup
    //   496: iconst_1
    //   497: iload 5
    //   499: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   502: aastore
    //   503: dup
    //   504: iconst_2
    //   505: iload 4
    //   507: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: aastore
    //   511: dup
    //   512: iconst_3
    //   513: aload 12
    //   515: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   518: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: aastore
    //   522: dup
    //   523: iconst_4
    //   524: aload 12
    //   526: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   529: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   536: iload 5
    //   538: ifle +466 -> 1004
    //   541: iload 8
    //   543: iload 5
    //   545: idiv
    //   546: istore 7
    //   548: aload 12
    //   550: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   553: iload 5
    //   555: imul
    //   556: iload 8
    //   558: idiv
    //   559: istore 6
    //   561: iload 5
    //   563: aload 12
    //   565: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   568: imul
    //   569: iload 8
    //   571: idiv
    //   572: istore 5
    //   574: iload 6
    //   576: istore 9
    //   578: iload 5
    //   580: istore 8
    //   582: iload 6
    //   584: iload 5
    //   586: imul
    //   587: ldc_w 266
    //   590: if_icmple +33 -> 623
    //   593: ldc2_w 267
    //   596: iload 6
    //   598: iload 5
    //   600: imul
    //   601: i2d
    //   602: ddiv
    //   603: invokestatic 274	java/lang/Math:sqrt	(D)D
    //   606: dstore_2
    //   607: iload 6
    //   609: i2d
    //   610: dload_2
    //   611: ddiv
    //   612: d2i
    //   613: istore 9
    //   615: iload 5
    //   617: i2d
    //   618: dload_2
    //   619: ddiv
    //   620: d2i
    //   621: istore 8
    //   623: new 158	android/graphics/BitmapFactory$Options
    //   626: dup
    //   627: invokespecial 275	android/graphics/BitmapFactory$Options:<init>	()V
    //   630: astore 11
    //   632: aload 11
    //   634: getstatic 281	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   637: putfield 284	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   640: iload 7
    //   642: iconst_2
    //   643: if_icmplt +10 -> 653
    //   646: aload 11
    //   648: iload 7
    //   650: putfield 287	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   653: aload_0
    //   654: aload 11
    //   656: invokestatic 291	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   659: astore 13
    //   661: aload 13
    //   663: ifnonnull +389 -> 1052
    //   666: ldc 189
    //   668: ldc_w 293
    //   671: iconst_1
    //   672: anewarray 193	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: aload 11
    //   679: getfield 287	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   682: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   685: aastore
    //   686: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   689: invokestatic 301	com/tencent/mm/compatible/util/f:getLine	()I
    //   692: istore 4
    //   694: ldc 138
    //   696: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   699: iconst_0
    //   700: iload 4
    //   702: isub
    //   703: ireturn
    //   704: invokestatic 210	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   707: invokestatic 304	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   710: ifeq +36 -> 746
    //   713: ldc 218
    //   715: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   718: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   721: invokeinterface 228 1 0
    //   726: ldc_w 306
    //   729: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   732: bipush 50
    //   734: invokestatic 239	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   737: istore 5
    //   739: iload 5
    //   741: istore 4
    //   743: goto -438 -> 305
    //   746: invokestatic 210	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   749: invokestatic 309	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   752: ifeq +36 -> 788
    //   755: ldc 218
    //   757: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   760: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   763: invokeinterface 228 1 0
    //   768: ldc_w 311
    //   771: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   774: bipush 50
    //   776: invokestatic 239	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   779: istore 5
    //   781: iload 5
    //   783: istore 4
    //   785: goto -480 -> 305
    //   788: ldc 218
    //   790: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   793: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   796: invokeinterface 228 1 0
    //   801: ldc_w 313
    //   804: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   807: bipush 50
    //   809: invokestatic 239	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   812: istore 5
    //   814: iload 5
    //   816: istore 4
    //   818: goto -513 -> 305
    //   821: iload 6
    //   823: istore 5
    //   825: invokestatic 210	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   828: invokestatic 304	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   831: ifeq +31 -> 862
    //   834: iload 6
    //   836: istore 5
    //   838: ldc 218
    //   840: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   843: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   846: invokeinterface 228 1 0
    //   851: ldc_w 315
    //   854: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   857: astore 11
    //   859: goto -511 -> 348
    //   862: iload 6
    //   864: istore 5
    //   866: invokestatic 210	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   869: invokestatic 309	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   872: ifeq +31 -> 903
    //   875: iload 6
    //   877: istore 5
    //   879: ldc 218
    //   881: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   884: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   887: invokeinterface 228 1 0
    //   892: ldc_w 317
    //   895: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   898: astore 11
    //   900: goto -552 -> 348
    //   903: iload 6
    //   905: istore 5
    //   907: ldc 218
    //   909: invokestatic 224	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   912: checkcast 218	com/tencent/mm/plugin/zero/b/a
    //   915: invokeinterface 228 1 0
    //   920: ldc_w 319
    //   923: invokevirtual 235	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   926: astore 11
    //   928: goto -580 -> 348
    //   931: astore 11
    //   933: sipush 1080
    //   936: istore 6
    //   938: goto -518 -> 420
    //   941: iload 6
    //   943: sipush 2160
    //   946: if_icmplt +14 -> 960
    //   949: iconst_0
    //   950: istore 6
    //   952: sipush 1080
    //   955: istore 5
    //   957: goto -519 -> 438
    //   960: iload 6
    //   962: ifgt +440 -> 1402
    //   965: iload 5
    //   967: sipush 3240
    //   970: if_icmple +432 -> 1402
    //   973: sipush 1620
    //   976: istore 6
    //   978: iconst_0
    //   979: istore 5
    //   981: goto -543 -> 438
    //   984: aload 12
    //   986: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   989: istore 7
    //   991: goto -533 -> 458
    //   994: aload 12
    //   996: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   999: istore 8
    //   1001: goto -523 -> 478
    //   1004: iload 7
    //   1006: iload 6
    //   1008: idiv
    //   1009: istore 8
    //   1011: aload 12
    //   1013: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1016: iload 6
    //   1018: imul
    //   1019: iload 7
    //   1021: idiv
    //   1022: istore 5
    //   1024: iload 6
    //   1026: aload 12
    //   1028: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1031: imul
    //   1032: iload 7
    //   1034: idiv
    //   1035: istore 7
    //   1037: iload 5
    //   1039: istore 6
    //   1041: iload 7
    //   1043: istore 5
    //   1045: iload 8
    //   1047: istore 7
    //   1049: goto -475 -> 574
    //   1052: ldc 189
    //   1054: ldc_w 321
    //   1057: iconst_2
    //   1058: anewarray 193	java/lang/Object
    //   1061: dup
    //   1062: iconst_0
    //   1063: aload 13
    //   1065: invokevirtual 326	android/graphics/Bitmap:getWidth	()I
    //   1068: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1071: aastore
    //   1072: dup
    //   1073: iconst_1
    //   1074: aload 13
    //   1076: invokevirtual 329	android/graphics/Bitmap:getHeight	()I
    //   1079: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: aastore
    //   1083: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1086: iload 7
    //   1088: iconst_1
    //   1089: if_icmple +79 -> 1168
    //   1092: aload 13
    //   1094: iload 8
    //   1096: iload 9
    //   1098: iconst_1
    //   1099: invokestatic 336	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   1102: astore 11
    //   1104: aload 13
    //   1106: aload 11
    //   1108: if_acmpeq +28 -> 1136
    //   1111: ldc 189
    //   1113: ldc_w 338
    //   1116: iconst_1
    //   1117: anewarray 193	java/lang/Object
    //   1120: dup
    //   1121: iconst_0
    //   1122: aload 13
    //   1124: invokevirtual 339	java/lang/Object:toString	()Ljava/lang/String;
    //   1127: aastore
    //   1128: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1131: aload 13
    //   1133: invokevirtual 342	android/graphics/Bitmap:recycle	()V
    //   1136: aload 11
    //   1138: astore 13
    //   1140: aload 11
    //   1142: ifnonnull +26 -> 1168
    //   1145: ldc 189
    //   1147: ldc_w 344
    //   1150: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1153: invokestatic 301	com/tencent/mm/compatible/util/f:getLine	()I
    //   1156: istore 4
    //   1158: ldc 138
    //   1160: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: iconst_0
    //   1164: iload 4
    //   1166: isub
    //   1167: ireturn
    //   1168: aconst_null
    //   1169: astore 12
    //   1171: aconst_null
    //   1172: astore 11
    //   1174: aload_1
    //   1175: iconst_0
    //   1176: invokestatic 350	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1179: astore 14
    //   1181: aload 14
    //   1183: astore 11
    //   1185: aload 14
    //   1187: astore 12
    //   1189: aload 13
    //   1191: getstatic 356	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1194: iload 4
    //   1196: aload 14
    //   1198: invokevirtual 360	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1201: pop
    //   1202: aload 14
    //   1204: ifnull +8 -> 1212
    //   1207: aload 14
    //   1209: invokevirtual 365	java/io/OutputStream:close	()V
    //   1212: ldc 189
    //   1214: ldc_w 367
    //   1217: iconst_3
    //   1218: anewarray 193	java/lang/Object
    //   1221: dup
    //   1222: iconst_0
    //   1223: aload 13
    //   1225: invokevirtual 339	java/lang/Object:toString	()Ljava/lang/String;
    //   1228: aastore
    //   1229: dup
    //   1230: iconst_1
    //   1231: aload_0
    //   1232: invokestatic 371	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1235: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1238: aastore
    //   1239: dup
    //   1240: iconst_2
    //   1241: aload_1
    //   1242: invokestatic 371	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1245: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1248: aastore
    //   1249: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1252: aload 13
    //   1254: invokevirtual 342	android/graphics/Bitmap:recycle	()V
    //   1257: ldc 138
    //   1259: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1262: iconst_0
    //   1263: ireturn
    //   1264: astore_0
    //   1265: aload 11
    //   1267: astore 12
    //   1269: ldc 189
    //   1271: ldc_w 378
    //   1274: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1277: aload 11
    //   1279: astore 12
    //   1281: ldc 189
    //   1283: ldc_w 380
    //   1286: iconst_1
    //   1287: anewarray 193	java/lang/Object
    //   1290: dup
    //   1291: iconst_0
    //   1292: aload_0
    //   1293: invokestatic 384	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1296: aastore
    //   1297: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1300: aload 11
    //   1302: astore 12
    //   1304: ldc 189
    //   1306: ldc_w 338
    //   1309: iconst_1
    //   1310: anewarray 193	java/lang/Object
    //   1313: dup
    //   1314: iconst_0
    //   1315: aload 13
    //   1317: invokevirtual 339	java/lang/Object:toString	()Ljava/lang/String;
    //   1320: aastore
    //   1321: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1324: aload 11
    //   1326: astore 12
    //   1328: aload 13
    //   1330: invokevirtual 342	android/graphics/Bitmap:recycle	()V
    //   1333: aload 11
    //   1335: astore 12
    //   1337: invokestatic 301	com/tencent/mm/compatible/util/f:getLine	()I
    //   1340: istore 4
    //   1342: aload 11
    //   1344: ifnull +8 -> 1352
    //   1347: aload 11
    //   1349: invokevirtual 365	java/io/OutputStream:close	()V
    //   1352: ldc 138
    //   1354: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1357: iconst_0
    //   1358: iload 4
    //   1360: isub
    //   1361: ireturn
    //   1362: astore_0
    //   1363: aload 12
    //   1365: ifnull +8 -> 1373
    //   1368: aload 12
    //   1370: invokevirtual 365	java/io/OutputStream:close	()V
    //   1373: ldc 138
    //   1375: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1378: aload_0
    //   1379: athrow
    //   1380: astore 11
    //   1382: goto -170 -> 1212
    //   1385: astore_0
    //   1386: goto -34 -> 1352
    //   1389: astore_1
    //   1390: goto -17 -> 1373
    //   1393: astore 11
    //   1395: goto -1090 -> 305
    //   1398: astore_0
    //   1399: goto -1205 -> 194
    //   1402: iload 5
    //   1404: istore 7
    //   1406: iload 6
    //   1408: istore 5
    //   1410: iload 7
    //   1412: istore 6
    //   1414: goto -976 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1417	0	paramString1	String
    //   0	1417	1	paramString2	String
    //   606	13	2	d	double
    //   61	1300	4	i	int
    //   299	1110	5	j	int
    //   309	1104	6	k	int
    //   306	1105	7	m	int
    //   359	736	8	n	int
    //   576	521	9	i1	int
    //   67	180	10	bool	boolean
    //   18	909	11	localObject1	Object
    //   931	1	11	localException1	Exception
    //   1102	246	11	localObject2	Object
    //   1380	1	11	localIOException	IOException
    //   1393	1	11	localException2	Exception
    //   9	1360	12	localObject3	Object
    //   659	670	13	localObject4	Object
    //   1179	29	14	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   315	324	931	java/lang/Exception
    //   328	348	931	java/lang/Exception
    //   352	361	931	java/lang/Exception
    //   375	391	931	java/lang/Exception
    //   395	412	931	java/lang/Exception
    //   825	834	931	java/lang/Exception
    //   838	859	931	java/lang/Exception
    //   866	875	931	java/lang/Exception
    //   879	900	931	java/lang/Exception
    //   907	928	931	java/lang/Exception
    //   1174	1181	1264	java/lang/Exception
    //   1189	1202	1264	java/lang/Exception
    //   1174	1181	1362	finally
    //   1189	1202	1362	finally
    //   1269	1277	1362	finally
    //   1281	1300	1362	finally
    //   1304	1324	1362	finally
    //   1328	1333	1362	finally
    //   1337	1342	1362	finally
    //   1207	1212	1380	java/io/IOException
    //   1347	1352	1385	java/io/IOException
    //   1368	1373	1389	java/io/IOException
    //   267	301	1393	java/lang/Exception
    //   704	739	1393	java/lang/Exception
    //   746	781	1393	java/lang/Exception
    //   788	814	1393	java/lang/Exception
    //   139	194	1398	java/io/IOException
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150309);
    super.cancel();
    AppMethodBeat.o(150309);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150306);
    this.callback = paramh;
    if ((this.hQn == null) || (this.hQn.length() == 0))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      AppMethodBeat.o(150306);
      return -1;
    }
    if (!y.ZC(this.hQn))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.hQn);
      AppMethodBeat.o(150306);
      return -1;
    }
    if (this.osy == 0) {
      this.osy = ((int)y.bEl(this.hQn));
    }
    int i = Math.min(this.osy - this.dIY, 8192);
    Object localObject1 = y.bi(this.hQn, this.dIY, i);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      AppMethodBeat.o(150306);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(this.osy) });
    paramh = new c.a();
    paramh.otE = new ftl();
    paramh.otF = new ftm();
    paramh.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    paramh.funcId = 157;
    paramh.otG = 46;
    paramh.respCmdId = 1000000046;
    paramh = paramh.bEF();
    ftl localftl = (ftl)c.b.b(paramh.otB);
    localftl.NkN = this.osy;
    localftl.NkO = this.dIY;
    localftl.aasR = this.osz;
    localftl.NkQ = new gol().df((byte[])localObject1);
    localftl.abRD = this.osX;
    localftl.UserName = this.username;
    try
    {
      localObject1 = new gdd();
      ((gdd)localObject1).acaX = new gol().df(d.MtP.gtE());
      localftl.YKb = new gol().df(((gdd)localObject1).toByteArray());
      label374:
      i = dispatch(paramg, paramh, this);
      AppMethodBeat.o(150306);
      return i;
    }
    finally
    {
      break label374;
    }
  }
  
  public final int getType()
  {
    return 157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150308);
    paramArrayOfByte = (ftm)c.c.b(((c)params).otC);
    Log.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(150308);
      return;
    }
    paramInt1 = params.getRespObj().getRetCode();
    if (paramInt1 == -4) {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    this.dIY = paramArrayOfByte.NkO;
    if (this.dIY < this.osy)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      Log.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
      AppMethodBeat.o(150308);
      return;
    }
    try
    {
      y.qn(this.hQn, this.osW);
      com.tencent.mm.kernel.h.baE().ban().B(12297, paramArrayOfByte.abRE);
      q.bFp().e(this.username, BitmapUtil.getBitmapNative(this.osW));
      params = z.bAM();
      if (!Util.isNullOrNil(params))
      {
        paramArrayOfByte = new j();
        paramArrayOfByte.username = params;
        paramArrayOfByte.gX(true);
        paramArrayOfByte.eQp = 32;
        paramArrayOfByte.jZY = 3;
        paramArrayOfByte.eQp = 34;
        q.bFE().b(paramArrayOfByte);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + paramString.getMessage());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150308);
    }
  }
  
  public final int securityLimitCount()
  {
    return 200;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(150307);
    if ((this.hQn == null) || (this.hQn.length() == 0))
    {
      params = p.b.oui;
      AppMethodBeat.o(150307);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(150307);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.n
 * JD-Core Version:    0.7.0.1
 */