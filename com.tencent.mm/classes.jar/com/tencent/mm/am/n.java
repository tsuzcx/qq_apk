package com.tencent.mm.am;

import androidx.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exs;
import com.tencent.mm.protocal.protobuf.ext;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class n
  extends com.tencent.mm.an.q
  implements m
{
  private int bPt;
  private i callback;
  private String fKH;
  private int lAW;
  private int lAX;
  private String lBm;
  private String lBn;
  private String username;
  
  public n(int paramInt, String paramString)
  {
    this(1, paramString, (byte)0);
  }
  
  public n(int paramInt, String paramString, byte paramByte)
  {
    AppMethodBeat.i(211566);
    this.username = null;
    if (Util.isNullOrNil(null))
    {
      this.username = z.bcZ();
      if (paramInt == 2) {
        this.username = as.bvW(this.username);
      }
    }
    q.bhz();
    this.lBm = f.O(this.username, true);
    String str = this.lBm + ".tmp";
    if (bi(paramString, str) == 0)
    {
      this.fKH = str;
      this.lAX = paramInt;
      q.bhz();
      this.lBn = com.tencent.mm.b.g.getMessageDigest(u.aY(f.N(this.username, true), 0, -1));
      this.lAW = 0;
      this.bPt = 0;
    }
    AppMethodBeat.o(211566);
  }
  
  private static boolean TU(String paramString)
  {
    AppMethodBeat.i(211560);
    try
    {
      Object localObject = new a(paramString);
      paramString = ((a)localObject).I("GPSLongitude");
      String str1 = ((a)localObject).I("GPSLatitude");
      String str2 = ((a)localObject).I("GPSLongitudeRef");
      String str3 = ((a)localObject).I("GPSLatitudeRef");
      String str4 = ((a)localObject).I("GPSDestLongitude");
      localObject = ((a)localObject).I("GPSDestLongitudeRef");
      if ((paramString != null) || (str1 != null) || (str2 != null) || (str3 != null) || (str4 != null) || (localObject != null))
      {
        AppMethodBeat.o(211560);
        return true;
      }
      AppMethodBeat.o(211560);
      return false;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(211560);
    }
    return false;
  }
  
  /* Error */
  private static int bi(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 137
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 143	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   9: astore 12
    //   11: new 145	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 146	java/util/ArrayList:<init>	()V
    //   18: astore 11
    //   20: aload 11
    //   22: new 148	com/tencent/mars/smc/IDKey
    //   25: dup
    //   26: sipush 1515
    //   29: iconst_0
    //   30: iconst_1
    //   31: invokespecial 151	com/tencent/mars/smc/IDKey:<init>	(III)V
    //   34: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload 12
    //   40: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   43: sipush 640
    //   46: if_icmpge +187 -> 233
    //   49: aload 12
    //   51: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: sipush 640
    //   57: if_icmpge +176 -> 233
    //   60: iconst_1
    //   61: istore 4
    //   63: aload_0
    //   64: invokestatic 165	com/tencent/mm/am/n:TU	(Ljava/lang/String;)Z
    //   67: istore 10
    //   69: iload 4
    //   71: ifeq +174 -> 245
    //   74: iload 10
    //   76: ifeq +163 -> 239
    //   79: iconst_1
    //   80: istore 4
    //   82: aload 11
    //   84: new 148	com/tencent/mars/smc/IDKey
    //   87: dup
    //   88: sipush 1515
    //   91: iload 4
    //   93: iconst_1
    //   94: invokespecial 151	com/tencent/mars/smc/IDKey:<init>	(III)V
    //   97: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: getstatic 171	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   104: aload 11
    //   106: iconst_0
    //   107: invokevirtual 175	com/tencent/mm/plugin/report/f:b	(Ljava/util/ArrayList;Z)V
    //   110: aload 12
    //   112: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   115: sipush 640
    //   118: if_icmpge +144 -> 262
    //   121: aload 12
    //   123: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   126: sipush 640
    //   129: if_icmpge +133 -> 262
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 179	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   137: pop2
    //   138: new 117	androidx/e/a/a
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 120	androidx/e/a/a:<init>	(Ljava/lang/String;)V
    //   146: astore_0
    //   147: aload_0
    //   148: ldc 122
    //   150: aconst_null
    //   151: invokevirtual 183	androidx/e/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_0
    //   155: ldc 126
    //   157: aconst_null
    //   158: invokevirtual 183	androidx/e/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_0
    //   162: ldc 128
    //   164: aconst_null
    //   165: invokevirtual 183	androidx/e/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: ldc 130
    //   171: aconst_null
    //   172: invokevirtual 183	androidx/e/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_0
    //   176: ldc 132
    //   178: aconst_null
    //   179: invokevirtual 183	androidx/e/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: ldc 134
    //   185: aconst_null
    //   186: invokevirtual 183	androidx/e/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: invokevirtual 186	androidx/e/a/a:ib	()V
    //   193: ldc 188
    //   195: ldc 190
    //   197: iconst_2
    //   198: anewarray 192	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload 12
    //   205: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   208: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload 12
    //   216: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   219: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: ldc 137
    //   228: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: iconst_0
    //   232: ireturn
    //   233: iconst_0
    //   234: istore 4
    //   236: goto -173 -> 63
    //   239: iconst_2
    //   240: istore 4
    //   242: goto -160 -> 82
    //   245: iload 10
    //   247: ifeq +9 -> 256
    //   250: iconst_3
    //   251: istore 4
    //   253: goto -171 -> 82
    //   256: iconst_4
    //   257: istore 4
    //   259: goto -177 -> 82
    //   262: bipush 50
    //   264: istore 4
    //   266: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   269: invokestatic 215	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   272: ifeq +431 -> 703
    //   275: ldc 217
    //   277: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   280: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   283: invokeinterface 227 1 0
    //   288: ldc 229
    //   290: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   293: bipush 50
    //   295: invokestatic 238	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   298: istore 5
    //   300: iload 5
    //   302: istore 4
    //   304: iconst_0
    //   305: istore 7
    //   307: iconst_0
    //   308: istore 6
    //   310: iload 6
    //   312: istore 5
    //   314: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   317: invokestatic 215	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   320: ifeq +500 -> 820
    //   323: iload 6
    //   325: istore 5
    //   327: ldc 217
    //   329: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   332: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   335: invokeinterface 227 1 0
    //   340: ldc 240
    //   342: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 11
    //   347: iload 6
    //   349: istore 5
    //   351: aload 11
    //   353: ldc 242
    //   355: invokevirtual 248	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   358: istore 8
    //   360: iload 7
    //   362: istore 5
    //   364: iconst_m1
    //   365: iload 8
    //   367: if_icmpeq +565 -> 932
    //   370: iload 6
    //   372: istore 5
    //   374: aload 11
    //   376: iconst_0
    //   377: iload 8
    //   379: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   382: invokestatic 255	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   385: invokevirtual 259	java/lang/Integer:intValue	()I
    //   388: istore 6
    //   390: iload 6
    //   392: istore 5
    //   394: aload 11
    //   396: iload 8
    //   398: iconst_1
    //   399: iadd
    //   400: invokevirtual 262	java/lang/String:substring	(I)Ljava/lang/String;
    //   403: invokestatic 255	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   406: invokevirtual 259	java/lang/Integer:intValue	()I
    //   409: istore 7
    //   411: iload 6
    //   413: istore 5
    //   415: iload 7
    //   417: istore 6
    //   419: iload 5
    //   421: ifgt +519 -> 940
    //   424: iload 6
    //   426: ifgt +514 -> 940
    //   429: iconst_0
    //   430: istore 6
    //   432: sipush 1080
    //   435: istore 5
    //   437: aload 12
    //   439: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   442: aload 12
    //   444: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   447: if_icmple +536 -> 983
    //   450: aload 12
    //   452: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   455: istore 7
    //   457: aload 12
    //   459: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   462: aload 12
    //   464: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   467: if_icmpge +526 -> 993
    //   470: aload 12
    //   472: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   475: istore 8
    //   477: ldc 188
    //   479: ldc_w 264
    //   482: iconst_5
    //   483: anewarray 192	java/lang/Object
    //   486: dup
    //   487: iconst_0
    //   488: iload 6
    //   490: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: iload 5
    //   498: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_2
    //   504: iload 4
    //   506: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: iconst_3
    //   512: aload 12
    //   514: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   517: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: aastore
    //   521: dup
    //   522: iconst_4
    //   523: aload 12
    //   525: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   528: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: iload 5
    //   537: ifle +466 -> 1003
    //   540: iload 8
    //   542: iload 5
    //   544: idiv
    //   545: istore 7
    //   547: aload 12
    //   549: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   552: iload 5
    //   554: imul
    //   555: iload 8
    //   557: idiv
    //   558: istore 6
    //   560: iload 5
    //   562: aload 12
    //   564: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   567: imul
    //   568: iload 8
    //   570: idiv
    //   571: istore 5
    //   573: iload 6
    //   575: istore 9
    //   577: iload 5
    //   579: istore 8
    //   581: iload 6
    //   583: iload 5
    //   585: imul
    //   586: ldc_w 265
    //   589: if_icmple +33 -> 622
    //   592: ldc2_w 266
    //   595: iload 6
    //   597: iload 5
    //   599: imul
    //   600: i2d
    //   601: ddiv
    //   602: invokestatic 273	java/lang/Math:sqrt	(D)D
    //   605: dstore_2
    //   606: iload 6
    //   608: i2d
    //   609: dload_2
    //   610: ddiv
    //   611: d2i
    //   612: istore 9
    //   614: iload 5
    //   616: i2d
    //   617: dload_2
    //   618: ddiv
    //   619: d2i
    //   620: istore 8
    //   622: new 157	android/graphics/BitmapFactory$Options
    //   625: dup
    //   626: invokespecial 274	android/graphics/BitmapFactory$Options:<init>	()V
    //   629: astore 11
    //   631: aload 11
    //   633: getstatic 280	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   636: putfield 283	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   639: iload 7
    //   641: iconst_2
    //   642: if_icmplt +10 -> 652
    //   645: aload 11
    //   647: iload 7
    //   649: putfield 286	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   652: aload_0
    //   653: aload 11
    //   655: invokestatic 290	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   658: astore 13
    //   660: aload 13
    //   662: ifnonnull +389 -> 1051
    //   665: ldc 188
    //   667: ldc_w 292
    //   670: iconst_1
    //   671: anewarray 192	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: aload 11
    //   678: getfield 286	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   681: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aastore
    //   685: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: invokestatic 300	com/tencent/mm/compatible/util/f:getLine	()I
    //   691: istore 4
    //   693: ldc 137
    //   695: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   698: iconst_0
    //   699: iload 4
    //   701: isub
    //   702: ireturn
    //   703: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   706: invokestatic 303	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   709: ifeq +36 -> 745
    //   712: ldc 217
    //   714: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   717: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   720: invokeinterface 227 1 0
    //   725: ldc_w 305
    //   728: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   731: bipush 50
    //   733: invokestatic 238	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   736: istore 5
    //   738: iload 5
    //   740: istore 4
    //   742: goto -438 -> 304
    //   745: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   748: invokestatic 308	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   751: ifeq +36 -> 787
    //   754: ldc 217
    //   756: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   759: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   762: invokeinterface 227 1 0
    //   767: ldc_w 310
    //   770: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   773: bipush 50
    //   775: invokestatic 238	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   778: istore 5
    //   780: iload 5
    //   782: istore 4
    //   784: goto -480 -> 304
    //   787: ldc 217
    //   789: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   792: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   795: invokeinterface 227 1 0
    //   800: ldc_w 312
    //   803: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   806: bipush 50
    //   808: invokestatic 238	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   811: istore 5
    //   813: iload 5
    //   815: istore 4
    //   817: goto -513 -> 304
    //   820: iload 6
    //   822: istore 5
    //   824: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   827: invokestatic 303	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   830: ifeq +31 -> 861
    //   833: iload 6
    //   835: istore 5
    //   837: ldc 217
    //   839: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   842: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   845: invokeinterface 227 1 0
    //   850: ldc_w 314
    //   853: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   856: astore 11
    //   858: goto -511 -> 347
    //   861: iload 6
    //   863: istore 5
    //   865: invokestatic 209	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   868: invokestatic 308	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   871: ifeq +31 -> 902
    //   874: iload 6
    //   876: istore 5
    //   878: ldc 217
    //   880: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   883: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   886: invokeinterface 227 1 0
    //   891: ldc_w 316
    //   894: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   897: astore 11
    //   899: goto -552 -> 347
    //   902: iload 6
    //   904: istore 5
    //   906: ldc 217
    //   908: invokestatic 223	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   911: checkcast 217	com/tencent/mm/plugin/zero/b/a
    //   914: invokeinterface 227 1 0
    //   919: ldc_w 318
    //   922: invokevirtual 234	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   925: astore 11
    //   927: goto -580 -> 347
    //   930: astore 11
    //   932: sipush 1080
    //   935: istore 6
    //   937: goto -518 -> 419
    //   940: iload 6
    //   942: sipush 2160
    //   945: if_icmplt +14 -> 959
    //   948: iconst_0
    //   949: istore 6
    //   951: sipush 1080
    //   954: istore 5
    //   956: goto -519 -> 437
    //   959: iload 6
    //   961: ifgt +439 -> 1400
    //   964: iload 5
    //   966: sipush 3240
    //   969: if_icmple +431 -> 1400
    //   972: sipush 1620
    //   975: istore 6
    //   977: iconst_0
    //   978: istore 5
    //   980: goto -543 -> 437
    //   983: aload 12
    //   985: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   988: istore 7
    //   990: goto -533 -> 457
    //   993: aload 12
    //   995: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   998: istore 8
    //   1000: goto -523 -> 477
    //   1003: iload 7
    //   1005: iload 6
    //   1007: idiv
    //   1008: istore 8
    //   1010: aload 12
    //   1012: getfield 160	android/graphics/BitmapFactory$Options:outHeight	I
    //   1015: iload 6
    //   1017: imul
    //   1018: iload 7
    //   1020: idiv
    //   1021: istore 5
    //   1023: iload 6
    //   1025: aload 12
    //   1027: getfield 163	android/graphics/BitmapFactory$Options:outWidth	I
    //   1030: imul
    //   1031: iload 7
    //   1033: idiv
    //   1034: istore 7
    //   1036: iload 5
    //   1038: istore 6
    //   1040: iload 7
    //   1042: istore 5
    //   1044: iload 8
    //   1046: istore 7
    //   1048: goto -475 -> 573
    //   1051: ldc 188
    //   1053: ldc_w 320
    //   1056: iconst_2
    //   1057: anewarray 192	java/lang/Object
    //   1060: dup
    //   1061: iconst_0
    //   1062: aload 13
    //   1064: invokevirtual 325	android/graphics/Bitmap:getWidth	()I
    //   1067: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1070: aastore
    //   1071: dup
    //   1072: iconst_1
    //   1073: aload 13
    //   1075: invokevirtual 328	android/graphics/Bitmap:getHeight	()I
    //   1078: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1081: aastore
    //   1082: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1085: iload 7
    //   1087: iconst_1
    //   1088: if_icmple +79 -> 1167
    //   1091: aload 13
    //   1093: iload 8
    //   1095: iload 9
    //   1097: iconst_1
    //   1098: invokestatic 335	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   1101: astore 11
    //   1103: aload 13
    //   1105: aload 11
    //   1107: if_acmpeq +28 -> 1135
    //   1110: ldc 188
    //   1112: ldc_w 337
    //   1115: iconst_1
    //   1116: anewarray 192	java/lang/Object
    //   1119: dup
    //   1120: iconst_0
    //   1121: aload 13
    //   1123: invokevirtual 338	java/lang/Object:toString	()Ljava/lang/String;
    //   1126: aastore
    //   1127: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1130: aload 13
    //   1132: invokevirtual 341	android/graphics/Bitmap:recycle	()V
    //   1135: aload 11
    //   1137: astore 13
    //   1139: aload 11
    //   1141: ifnonnull +26 -> 1167
    //   1144: ldc 188
    //   1146: ldc_w 343
    //   1149: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1152: invokestatic 300	com/tencent/mm/compatible/util/f:getLine	()I
    //   1155: istore 4
    //   1157: ldc 137
    //   1159: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1162: iconst_0
    //   1163: iload 4
    //   1165: isub
    //   1166: ireturn
    //   1167: aconst_null
    //   1168: astore 12
    //   1170: aconst_null
    //   1171: astore 11
    //   1173: aload_1
    //   1174: invokestatic 349	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   1177: astore 14
    //   1179: aload 14
    //   1181: astore 11
    //   1183: aload 14
    //   1185: astore 12
    //   1187: aload 13
    //   1189: getstatic 355	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1192: iload 4
    //   1194: aload 14
    //   1196: invokevirtual 359	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1199: pop
    //   1200: aload 14
    //   1202: ifnull +8 -> 1210
    //   1205: aload 14
    //   1207: invokevirtual 364	java/io/OutputStream:close	()V
    //   1210: ldc 188
    //   1212: ldc_w 366
    //   1215: iconst_3
    //   1216: anewarray 192	java/lang/Object
    //   1219: dup
    //   1220: iconst_0
    //   1221: aload 13
    //   1223: invokevirtual 338	java/lang/Object:toString	()Ljava/lang/String;
    //   1226: aastore
    //   1227: dup
    //   1228: iconst_1
    //   1229: aload_0
    //   1230: invokestatic 370	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   1233: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1236: aastore
    //   1237: dup
    //   1238: iconst_2
    //   1239: aload_1
    //   1240: invokestatic 370	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   1243: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1246: aastore
    //   1247: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1250: aload 13
    //   1252: invokevirtual 341	android/graphics/Bitmap:recycle	()V
    //   1255: ldc 137
    //   1257: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1260: iconst_0
    //   1261: ireturn
    //   1262: astore_0
    //   1263: aload 11
    //   1265: astore 12
    //   1267: ldc 188
    //   1269: ldc_w 377
    //   1272: invokestatic 345	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1275: aload 11
    //   1277: astore 12
    //   1279: ldc 188
    //   1281: ldc_w 379
    //   1284: iconst_1
    //   1285: anewarray 192	java/lang/Object
    //   1288: dup
    //   1289: iconst_0
    //   1290: aload_0
    //   1291: invokestatic 383	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1294: aastore
    //   1295: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1298: aload 11
    //   1300: astore 12
    //   1302: ldc 188
    //   1304: ldc_w 337
    //   1307: iconst_1
    //   1308: anewarray 192	java/lang/Object
    //   1311: dup
    //   1312: iconst_0
    //   1313: aload 13
    //   1315: invokevirtual 338	java/lang/Object:toString	()Ljava/lang/String;
    //   1318: aastore
    //   1319: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1322: aload 11
    //   1324: astore 12
    //   1326: aload 13
    //   1328: invokevirtual 341	android/graphics/Bitmap:recycle	()V
    //   1331: aload 11
    //   1333: astore 12
    //   1335: invokestatic 300	com/tencent/mm/compatible/util/f:getLine	()I
    //   1338: istore 4
    //   1340: aload 11
    //   1342: ifnull +8 -> 1350
    //   1345: aload 11
    //   1347: invokevirtual 364	java/io/OutputStream:close	()V
    //   1350: ldc 137
    //   1352: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1355: iconst_0
    //   1356: iload 4
    //   1358: isub
    //   1359: ireturn
    //   1360: astore_0
    //   1361: aload 12
    //   1363: ifnull +8 -> 1371
    //   1366: aload 12
    //   1368: invokevirtual 364	java/io/OutputStream:close	()V
    //   1371: ldc 137
    //   1373: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1376: aload_0
    //   1377: athrow
    //   1378: astore 11
    //   1380: goto -170 -> 1210
    //   1383: astore_0
    //   1384: goto -34 -> 1350
    //   1387: astore_1
    //   1388: goto -17 -> 1371
    //   1391: astore 11
    //   1393: goto -1089 -> 304
    //   1396: astore_0
    //   1397: goto -1204 -> 193
    //   1400: iload 5
    //   1402: istore 7
    //   1404: iload 6
    //   1406: istore 5
    //   1408: iload 7
    //   1410: istore 6
    //   1412: goto -975 -> 437
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1415	0	paramString1	String
    //   0	1415	1	paramString2	String
    //   605	13	2	d	double
    //   61	1298	4	i	int
    //   298	1109	5	j	int
    //   308	1103	6	k	int
    //   305	1104	7	m	int
    //   358	736	8	n	int
    //   575	521	9	i1	int
    //   67	179	10	bool	boolean
    //   18	908	11	localObject1	Object
    //   930	1	11	localException1	Exception
    //   1101	245	11	localObject2	Object
    //   1378	1	11	localIOException	IOException
    //   1391	1	11	localException2	Exception
    //   9	1358	12	localObject3	Object
    //   658	669	13	localObject4	Object
    //   1177	29	14	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   314	323	930	java/lang/Exception
    //   327	347	930	java/lang/Exception
    //   351	360	930	java/lang/Exception
    //   374	390	930	java/lang/Exception
    //   394	411	930	java/lang/Exception
    //   824	833	930	java/lang/Exception
    //   837	858	930	java/lang/Exception
    //   865	874	930	java/lang/Exception
    //   878	899	930	java/lang/Exception
    //   906	927	930	java/lang/Exception
    //   1173	1179	1262	java/lang/Exception
    //   1187	1200	1262	java/lang/Exception
    //   1173	1179	1360	finally
    //   1187	1200	1360	finally
    //   1267	1275	1360	finally
    //   1279	1298	1360	finally
    //   1302	1322	1360	finally
    //   1326	1331	1360	finally
    //   1335	1340	1360	finally
    //   1205	1210	1378	java/io/IOException
    //   1345	1350	1383	java/io/IOException
    //   1366	1371	1387	java/io/IOException
    //   266	300	1391	java/lang/Exception
    //   703	738	1391	java/lang/Exception
    //   745	780	1391	java/lang/Exception
    //   787	813	1391	java/lang/Exception
    //   138	193	1396	java/io/IOException
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150309);
    super.cancel();
    AppMethodBeat.o(150309);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150306);
    this.callback = parami;
    if ((this.fKH == null) || (this.fKH.length() == 0))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      AppMethodBeat.o(150306);
      return -1;
    }
    if (!u.agG(this.fKH))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.fKH);
      AppMethodBeat.o(150306);
      return -1;
    }
    if (this.lAW == 0) {
      this.lAW = ((int)u.bBQ(this.fKH));
    }
    int i = Math.min(this.lAW - this.bPt, 8192);
    Object localObject = u.aY(this.fKH, this.bPt, i);
    if (localObject == null)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      AppMethodBeat.o(150306);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(this.lAW) });
    parami = new d.a();
    parami.lBU = new exs();
    parami.lBV = new ext();
    parami.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    parami.funcId = 157;
    parami.lBW = 46;
    parami.respCmdId = 1000000046;
    parami = parami.bgN();
    exs localexs = (exs)d.b.b(parami.lBR);
    localexs.HmZ = this.lAW;
    localexs.Hna = this.bPt;
    localexs.Tfx = this.lAX;
    localexs.Hnc = new eae().dc((byte[])localObject);
    localexs.UxW = this.lBn;
    localexs.UserName = this.username;
    try
    {
      localObject = new fgr();
      ((fgr)localObject).UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
      localexs.RMN = new eae().dc(((fgr)localObject).toByteArray());
      label374:
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(150306);
      return i;
    }
    catch (Throwable localThrowable)
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
    paramArrayOfByte = (ext)d.c.b(((com.tencent.mm.an.d)params).lBS);
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
    this.bPt = paramArrayOfByte.Hna;
    if (this.bPt < this.lAW)
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
      u.oo(this.fKH, this.lBm);
      h.aHG().aHp().i(12297, paramArrayOfByte.UxX);
      q.bhz().e(this.username, BitmapUtil.getBitmapNative(this.lBm));
      params = z.bcZ();
      if (!Util.isNullOrNil(params))
      {
        paramArrayOfByte = new j();
        paramArrayOfByte.username = params;
        paramArrayOfByte.gg(true);
        paramArrayOfByte.cUP = 32;
        paramArrayOfByte.hDc = 3;
        paramArrayOfByte.cUP = 34;
        q.bhP().b(paramArrayOfByte);
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
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(150307);
    if ((this.fKH == null) || (this.fKH.length() == 0))
    {
      params = q.b.lCy;
      AppMethodBeat.o(150307);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(150307);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.n
 * JD-Core Version:    0.7.0.1
 */