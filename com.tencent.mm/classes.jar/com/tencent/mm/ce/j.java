package com.tencent.mm.ce;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class j
{
  private static final List<String> acmj;
  private static j acmk;
  private static k acml;
  private static f acmm;
  private static i acmn;
  private static String acmo;
  private static boolean acmp;
  private static boolean acmq;
  
  static
  {
    AppMethodBeat.i(141263);
    acmj = Arrays.asList(new String[] { "zh_CN", "en" });
    acmo = "";
    acmp = false;
    acmq = true;
    AppMethodBeat.o(141263);
  }
  
  private static int a(DataInputStream paramDataInputStream, SparseArray<f.a> paramSparseArray, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141261);
    try
    {
      int m = paramDataInputStream.readByte();
      if (m < 0)
      {
        AppMethodBeat.o(141261);
        return 0;
      }
      int[] arrayOfInt1 = new int[m];
      int[] arrayOfInt2 = new int[m];
      int j = 0;
      int k = 0;
      int i = paramInt2;
      paramInt2 = k;
      while (paramInt2 < m)
      {
        arrayOfInt1[paramInt2] = paramDataInputStream.readByte();
        arrayOfInt2[paramInt2] = i;
        k = paramDataInputStream.readShort();
        j += k;
        i += k;
        paramInt2 += 1;
      }
      paramSparseArray.append(paramInt1, new f.a(paramInt1, arrayOfInt1, arrayOfInt2));
      AppMethodBeat.o(141261);
      return j;
    }
    catch (IOException paramDataInputStream)
    {
      Log.e("MicroMsg.language.StringResouces", "exception:%s", new Object[] { Util.stackTraceToString(paramDataInputStream) });
      AppMethodBeat.o(141261);
    }
    return 0;
  }
  
  public static CharSequence aP(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    return paramCharSequence;
  }
  
  /* Error */
  private static void b(AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +16 -> 25
    //   12: ldc 86
    //   14: ldc 113
    //   16: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 107
    //   21: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_1
    //   26: getstatic 47	com/tencent/mm/ce/j:acmo	Ljava/lang/String;
    //   29: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +24 -> 56
    //   35: ldc 86
    //   37: ldc 123
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 107
    //   52: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: invokestatic 131	com/tencent/mm/compatible/util/h:aQh	()Z
    //   59: ifne +16 -> 75
    //   62: ldc 86
    //   64: ldc 133
    //   66: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: ldc 107
    //   71: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: aload_1
    //   76: ldc 135
    //   78: invokevirtual 139	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   81: istore_2
    //   82: aload_1
    //   83: astore 12
    //   85: iload_2
    //   86: ifle +48 -> 134
    //   89: aload_1
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 143	java/lang/String:substring	(II)Ljava/lang/String;
    //   95: astore 10
    //   97: aload_1
    //   98: astore 12
    //   100: aload 10
    //   102: ldc 145
    //   104: invokevirtual 148	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   107: ifne +27 -> 134
    //   110: ldc 86
    //   112: ldc 150
    //   114: iconst_2
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload 10
    //   126: aastore
    //   127: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload 10
    //   132: astore 12
    //   134: invokestatic 156	com/tencent/mm/ce/j:clean	()V
    //   137: aload 12
    //   139: putstatic 47	com/tencent/mm/ce/j:acmo	Ljava/lang/String;
    //   142: ldc 86
    //   144: ldc 158
    //   146: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   152: lstore 8
    //   154: aconst_null
    //   155: astore 10
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_0
    //   160: new 168	java/lang/StringBuilder
    //   163: dup
    //   164: ldc 170
    //   166: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload 12
    //   171: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 178
    //   176: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 188	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   185: astore_0
    //   186: aload_0
    //   187: astore_1
    //   188: aload_0
    //   189: astore 10
    //   191: new 65	java/io/DataInputStream
    //   194: dup
    //   195: aload_0
    //   196: invokespecial 191	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   199: astore 11
    //   201: aload 11
    //   203: astore 10
    //   205: aload_0
    //   206: astore_1
    //   207: aload 11
    //   209: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   212: pop
    //   213: aload 11
    //   215: astore 10
    //   217: aload_0
    //   218: astore_1
    //   219: aload 11
    //   221: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   224: pop
    //   225: aload 11
    //   227: astore 10
    //   229: aload_0
    //   230: astore_1
    //   231: aload 11
    //   233: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   236: istore 5
    //   238: aload 11
    //   240: astore 10
    //   242: aload_0
    //   243: astore_1
    //   244: ldc 86
    //   246: ldc 197
    //   248: iload 5
    //   250: invokestatic 201	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   253: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 11
    //   261: astore 10
    //   263: aload_0
    //   264: astore_1
    //   265: new 207	android/util/SparseIntArray
    //   268: dup
    //   269: iload 5
    //   271: invokespecial 209	android/util/SparseIntArray:<init>	(I)V
    //   274: astore 13
    //   276: aload 11
    //   278: astore 10
    //   280: aload_0
    //   281: astore_1
    //   282: aload 11
    //   284: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   287: istore 4
    //   289: iconst_0
    //   290: istore_2
    //   291: iconst_0
    //   292: istore_3
    //   293: iload_2
    //   294: iload 5
    //   296: if_icmpge +54 -> 350
    //   299: aload 11
    //   301: astore 10
    //   303: aload_0
    //   304: astore_1
    //   305: iload 4
    //   307: aload 11
    //   309: invokevirtual 73	java/io/DataInputStream:readShort	()S
    //   312: iadd
    //   313: istore 4
    //   315: aload 11
    //   317: astore 10
    //   319: aload_0
    //   320: astore_1
    //   321: aload 13
    //   323: iload 4
    //   325: iload_3
    //   326: invokevirtual 212	android/util/SparseIntArray:append	(II)V
    //   329: aload 11
    //   331: astore 10
    //   333: aload_0
    //   334: astore_1
    //   335: iload_3
    //   336: aload 11
    //   338: invokevirtual 73	java/io/DataInputStream:readShort	()S
    //   341: iadd
    //   342: istore_3
    //   343: iload_2
    //   344: iconst_1
    //   345: iadd
    //   346: istore_2
    //   347: goto -54 -> 293
    //   350: aload 11
    //   352: astore 10
    //   354: aload_0
    //   355: astore_1
    //   356: aload 13
    //   358: aload 11
    //   360: iload_3
    //   361: invokestatic 217	com/tencent/mm/ce/k:a	(Landroid/util/SparseIntArray;Ljava/io/InputStream;I)Lcom/tencent/mm/ce/k;
    //   364: putstatic 219	com/tencent/mm/ce/j:acml	Lcom/tencent/mm/ce/k;
    //   367: iconst_0
    //   368: istore_2
    //   369: aload 11
    //   371: astore 10
    //   373: aload_0
    //   374: astore_1
    //   375: aload 11
    //   377: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   380: istore 5
    //   382: aload 11
    //   384: astore 10
    //   386: aload_0
    //   387: astore_1
    //   388: ldc 86
    //   390: ldc 221
    //   392: iconst_1
    //   393: anewarray 4	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: iload 5
    //   400: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: iload 5
    //   409: ifle +100 -> 509
    //   412: aload 11
    //   414: astore 10
    //   416: aload_0
    //   417: astore_1
    //   418: new 80	android/util/SparseArray
    //   421: dup
    //   422: iload 5
    //   424: invokespecial 227	android/util/SparseArray:<init>	(I)V
    //   427: astore 13
    //   429: aload 11
    //   431: astore 10
    //   433: aload_0
    //   434: astore_1
    //   435: aload 11
    //   437: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   440: istore 4
    //   442: iconst_0
    //   443: istore_3
    //   444: iload_2
    //   445: iload 5
    //   447: if_icmpge +45 -> 492
    //   450: aload 11
    //   452: astore 10
    //   454: aload_0
    //   455: astore_1
    //   456: iload 4
    //   458: aload 11
    //   460: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   463: iadd
    //   464: istore 4
    //   466: aload 11
    //   468: astore 10
    //   470: aload_0
    //   471: astore_1
    //   472: iload_3
    //   473: aload 11
    //   475: aload 13
    //   477: iload 4
    //   479: iload_3
    //   480: invokestatic 229	com/tencent/mm/ce/j:a	(Ljava/io/DataInputStream;Landroid/util/SparseArray;II)I
    //   483: iadd
    //   484: istore_3
    //   485: iload_2
    //   486: iconst_1
    //   487: iadd
    //   488: istore_2
    //   489: goto -45 -> 444
    //   492: aload 11
    //   494: astore 10
    //   496: aload_0
    //   497: astore_1
    //   498: aload 13
    //   500: aload 11
    //   502: iload_3
    //   503: invokestatic 234	com/tencent/mm/ce/f:a	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/ce/f;
    //   506: putstatic 236	com/tencent/mm/ce/j:acmm	Lcom/tencent/mm/ce/f;
    //   509: aload 11
    //   511: astore 10
    //   513: aload_0
    //   514: astore_1
    //   515: aload 11
    //   517: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   520: istore 6
    //   522: aload 11
    //   524: astore 10
    //   526: aload_0
    //   527: astore_1
    //   528: aload 11
    //   530: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   533: istore 4
    //   535: aload 11
    //   537: astore 10
    //   539: aload_0
    //   540: astore_1
    //   541: ldc 86
    //   543: ldc 238
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: iload 6
    //   553: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: aastore
    //   557: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   560: iload 6
    //   562: ifle +162 -> 724
    //   565: aload 11
    //   567: astore 10
    //   569: aload_0
    //   570: astore_1
    //   571: new 80	android/util/SparseArray
    //   574: dup
    //   575: iload 6
    //   577: invokespecial 227	android/util/SparseArray:<init>	(I)V
    //   580: astore 13
    //   582: iconst_0
    //   583: istore_3
    //   584: iconst_0
    //   585: istore_2
    //   586: iload_2
    //   587: iload 6
    //   589: if_icmpge +118 -> 707
    //   592: aload 11
    //   594: astore 10
    //   596: aload_0
    //   597: astore_1
    //   598: aload 11
    //   600: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   603: iload 4
    //   605: iadd
    //   606: istore 5
    //   608: aload 11
    //   610: astore 10
    //   612: aload_0
    //   613: astore_1
    //   614: aload 11
    //   616: invokevirtual 195	java/io/DataInputStream:readInt	()I
    //   619: istore 7
    //   621: aload 11
    //   623: astore 10
    //   625: aload_0
    //   626: astore_1
    //   627: iload 7
    //   629: newarray int
    //   631: astore 14
    //   633: iconst_0
    //   634: istore 4
    //   636: iload 4
    //   638: iload 7
    //   640: if_icmpge +32 -> 672
    //   643: aload 14
    //   645: iload 4
    //   647: iload_3
    //   648: iastore
    //   649: aload 11
    //   651: astore 10
    //   653: aload_0
    //   654: astore_1
    //   655: iload_3
    //   656: aload 11
    //   658: invokevirtual 73	java/io/DataInputStream:readShort	()S
    //   661: iadd
    //   662: istore_3
    //   663: iload 4
    //   665: iconst_1
    //   666: iadd
    //   667: istore 4
    //   669: goto -33 -> 636
    //   672: aload 11
    //   674: astore 10
    //   676: aload_0
    //   677: astore_1
    //   678: aload 13
    //   680: iload 5
    //   682: new 240	com/tencent/mm/ce/i$a
    //   685: dup
    //   686: iload 5
    //   688: aload 14
    //   690: invokespecial 243	com/tencent/mm/ce/i$a:<init>	(I[I)V
    //   693: invokevirtual 84	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   696: iload_2
    //   697: iconst_1
    //   698: iadd
    //   699: istore_2
    //   700: iload 5
    //   702: istore 4
    //   704: goto -118 -> 586
    //   707: aload 11
    //   709: astore 10
    //   711: aload_0
    //   712: astore_1
    //   713: aload 13
    //   715: aload 11
    //   717: iload_3
    //   718: invokestatic 248	com/tencent/mm/ce/i:b	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/ce/i;
    //   721: putstatic 250	com/tencent/mm/ce/j:acmn	Lcom/tencent/mm/ce/i;
    //   724: aload_0
    //   725: ifnull +7 -> 732
    //   728: aload_0
    //   729: invokevirtual 255	java/io/InputStream:close	()V
    //   732: aload 11
    //   734: invokevirtual 256	java/io/DataInputStream:close	()V
    //   737: ldc 86
    //   739: new 168	java/lang/StringBuilder
    //   742: dup
    //   743: ldc_w 258
    //   746: invokespecial 173	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   749: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   752: lload 8
    //   754: lsub
    //   755: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   758: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: ldc 107
    //   766: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   769: return
    //   770: astore_0
    //   771: ldc 86
    //   773: ldc 88
    //   775: iconst_1
    //   776: anewarray 4	java/lang/Object
    //   779: dup
    //   780: iconst_0
    //   781: aload_0
    //   782: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   785: aastore
    //   786: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   789: goto -57 -> 732
    //   792: astore_0
    //   793: ldc 86
    //   795: ldc 88
    //   797: iconst_1
    //   798: anewarray 4	java/lang/Object
    //   801: dup
    //   802: iconst_0
    //   803: aload_0
    //   804: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   807: aastore
    //   808: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   811: goto -74 -> 737
    //   814: astore 13
    //   816: aconst_null
    //   817: astore 11
    //   819: aload_1
    //   820: astore_0
    //   821: aload 11
    //   823: astore 10
    //   825: aload_0
    //   826: astore_1
    //   827: ldc 86
    //   829: aload 13
    //   831: ldc_w 263
    //   834: iconst_1
    //   835: anewarray 4	java/lang/Object
    //   838: dup
    //   839: iconst_0
    //   840: aload 12
    //   842: aastore
    //   843: invokestatic 267	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   846: aload_0
    //   847: ifnull +7 -> 854
    //   850: aload_0
    //   851: invokevirtual 255	java/io/InputStream:close	()V
    //   854: aload 11
    //   856: ifnull -119 -> 737
    //   859: aload 11
    //   861: invokevirtual 256	java/io/DataInputStream:close	()V
    //   864: goto -127 -> 737
    //   867: astore_0
    //   868: ldc 86
    //   870: ldc 88
    //   872: iconst_1
    //   873: anewarray 4	java/lang/Object
    //   876: dup
    //   877: iconst_0
    //   878: aload_0
    //   879: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   882: aastore
    //   883: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   886: goto -149 -> 737
    //   889: astore_0
    //   890: ldc 86
    //   892: ldc 88
    //   894: iconst_1
    //   895: anewarray 4	java/lang/Object
    //   898: dup
    //   899: iconst_0
    //   900: aload_0
    //   901: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   904: aastore
    //   905: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   908: goto -54 -> 854
    //   911: astore_0
    //   912: aconst_null
    //   913: astore 11
    //   915: aload 10
    //   917: astore_1
    //   918: aload 11
    //   920: astore 10
    //   922: aload_1
    //   923: ifnull +7 -> 930
    //   926: aload_1
    //   927: invokevirtual 255	java/io/InputStream:close	()V
    //   930: aload 10
    //   932: ifnull +8 -> 940
    //   935: aload 10
    //   937: invokevirtual 256	java/io/DataInputStream:close	()V
    //   940: ldc 107
    //   942: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   945: aload_0
    //   946: athrow
    //   947: astore_1
    //   948: ldc 86
    //   950: ldc 88
    //   952: iconst_1
    //   953: anewarray 4	java/lang/Object
    //   956: dup
    //   957: iconst_0
    //   958: aload_1
    //   959: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   962: aastore
    //   963: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   966: goto -36 -> 930
    //   969: astore_1
    //   970: ldc 86
    //   972: ldc 88
    //   974: iconst_1
    //   975: anewarray 4	java/lang/Object
    //   978: dup
    //   979: iconst_0
    //   980: aload_1
    //   981: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   984: aastore
    //   985: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   988: goto -48 -> 940
    //   991: astore_0
    //   992: goto -70 -> 922
    //   995: astore 13
    //   997: goto -176 -> 821
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	paramAssetManager	AssetManager
    //   0	1000	1	paramString	String
    //   81	619	2	i	int
    //   292	426	3	j	int
    //   287	416	4	k	int
    //   236	465	5	m	int
    //   520	70	6	n	int
    //   619	22	7	i1	int
    //   152	601	8	l	long
    //   95	841	10	localObject1	Object
    //   199	720	11	localDataInputStream	DataInputStream
    //   83	758	12	localObject2	Object
    //   274	440	13	localObject3	Object
    //   814	16	13	localIOException1	IOException
    //   995	1	13	localIOException2	IOException
    //   631	58	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   728	732	770	java/io/IOException
    //   732	737	792	java/io/IOException
    //   159	186	814	java/io/IOException
    //   191	201	814	java/io/IOException
    //   859	864	867	java/io/IOException
    //   850	854	889	java/io/IOException
    //   159	186	911	finally
    //   191	201	911	finally
    //   926	930	947	java/io/IOException
    //   935	940	969	java/io/IOException
    //   207	213	991	finally
    //   219	225	991	finally
    //   231	238	991	finally
    //   244	259	991	finally
    //   265	276	991	finally
    //   282	289	991	finally
    //   305	315	991	finally
    //   321	329	991	finally
    //   335	343	991	finally
    //   356	367	991	finally
    //   375	382	991	finally
    //   388	407	991	finally
    //   418	429	991	finally
    //   435	442	991	finally
    //   456	466	991	finally
    //   472	485	991	finally
    //   498	509	991	finally
    //   515	522	991	finally
    //   528	535	991	finally
    //   541	560	991	finally
    //   571	582	991	finally
    //   598	608	991	finally
    //   614	621	991	finally
    //   627	633	991	finally
    //   655	663	991	finally
    //   678	696	991	finally
    //   713	724	991	finally
    //   827	846	991	finally
    //   207	213	995	java/io/IOException
    //   219	225	995	java/io/IOException
    //   231	238	995	java/io/IOException
    //   244	259	995	java/io/IOException
    //   265	276	995	java/io/IOException
    //   282	289	995	java/io/IOException
    //   305	315	995	java/io/IOException
    //   321	329	995	java/io/IOException
    //   335	343	995	java/io/IOException
    //   356	367	995	java/io/IOException
    //   375	382	995	java/io/IOException
    //   388	407	995	java/io/IOException
    //   418	429	995	java/io/IOException
    //   435	442	995	java/io/IOException
    //   456	466	995	java/io/IOException
    //   472	485	995	java/io/IOException
    //   498	509	995	java/io/IOException
    //   515	522	995	java/io/IOException
    //   528	535	995	java/io/IOException
    //   541	560	995	java/io/IOException
    //   571	582	995	java/io/IOException
    //   598	608	995	java/io/IOException
    //   614	621	995	java/io/IOException
    //   627	633	995	java/io/IOException
    //   655	663	995	java/io/IOException
    //   678	696	995	java/io/IOException
    //   713	724	995	java/io/IOException
  }
  
  private static boolean btV(String paramString)
  {
    AppMethodBeat.i(141250);
    if (acmj.contains(paramString))
    {
      AppMethodBeat.o(141250);
      return false;
    }
    AppMethodBeat.o(141250);
    return true;
  }
  
  public static j cR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141253);
    if (paramContext.getResources() == null)
    {
      Log.e("MicroMsg.language.StringResouces", "the resource is null! why?");
      AppMethodBeat.o(141253);
      return null;
    }
    AssetManager localAssetManager = h.getAssets();
    if (localAssetManager != null) {
      iRR();
    }
    if (localAssetManager != null)
    {
      iRR();
      if (acmq) {}
    }
    else
    {
      AppMethodBeat.o(141253);
      return null;
    }
    if ((Util.isNullOrNil(paramString)) || (paramString.equalsIgnoreCase("language_default")))
    {
      paramString = Locale.getDefault();
      LocaleUtil.updateApplicationResourceLocale(paramContext, paramString);
    }
    for (paramContext = paramString;; paramContext = LocaleUtil.transLanguageToLocale(paramString))
    {
      paramContext = paramContext.toString();
      iRR();
      boolean bool = btV(paramContext);
      acmp = bool;
      if (!bool) {
        break;
      }
      iRR();
      b(localAssetManager, paramContext);
      paramContext = iRR();
      AppMethodBeat.o(141253);
      return paramContext;
    }
    clean();
    acmo = paramContext;
    AppMethodBeat.o(141253);
    return null;
  }
  
  private static void clean()
  {
    AppMethodBeat.i(141251);
    Object localObject;
    if (acml != null)
    {
      localObject = acml;
      if (((k)localObject).acmr != null) {
        ((k)localObject).acmr.clear();
      }
      if (((k)localObject).acms != null) {
        ((k)localObject).acms = null;
      }
    }
    if (acmm != null)
    {
      localObject = acmm;
      if (((f)localObject).acmd != null) {
        ((f)localObject).acmd.clear();
      }
      if (((f)localObject).mData != null) {
        ((f)localObject).mData = null;
      }
    }
    if (acmn != null)
    {
      localObject = acmn;
      if (((i)localObject).acmh != null) {
        ((i)localObject).acmh.clear();
      }
      if (((i)localObject).mData != null) {
        ((i)localObject).mData = null;
      }
    }
    AppMethodBeat.o(141251);
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141258);
    if (acmm == null)
    {
      AppMethodBeat.o(141258);
      return null;
    }
    String str = acmm.getQuantityString(paramInt1, paramInt2, new Object[0]);
    AppMethodBeat.o(141258);
    return str;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141259);
    if (acmm == null)
    {
      AppMethodBeat.o(141259);
      return null;
    }
    paramVarArgs = acmm.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(141259);
    return paramVarArgs;
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(141257);
    if (acml == null)
    {
      AppMethodBeat.o(141257);
      return null;
    }
    String str = acml.getString(paramInt);
    AppMethodBeat.o(141257);
    return str;
  }
  
  public static String[] getStringArray(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(141260);
    if (acmn == null)
    {
      AppMethodBeat.o(141260);
      return null;
    }
    i locali = acmn;
    int j = locali.acmh.indexOfKey(paramInt);
    if (j < 0)
    {
      AppMethodBeat.o(141260);
      return null;
    }
    i.a locala;
    String[] arrayOfString;
    if (j < locali.acmh.size() - 1)
    {
      paramInt = ((i.a)locali.acmh.valueAt(j + 1)).acmi[0];
      locala = (i.a)locali.acmh.valueAt(j);
      j = locala.acmi.length;
      if (j <= 0) {
        break label223;
      }
      arrayOfString = new String[j];
      label113:
      if (i >= j) {
        break label215;
      }
      if (i >= j - 1) {
        break label181;
      }
      arrayOfString[i] = new String(locali.mData, locala.acmi[i], locala.acmi[(i + 1)] - locala.acmi[i]);
    }
    for (;;)
    {
      i += 1;
      break label113;
      paramInt = locali.mData.length;
      break;
      label181:
      arrayOfString[i] = new String(locali.mData, locala.acmi[i], paramInt - locala.acmi[i]);
    }
    for (;;)
    {
      label215:
      AppMethodBeat.o(141260);
      return arrayOfString;
      label223:
      arrayOfString = null;
    }
  }
  
  public static boolean iRL()
  {
    return acmq;
  }
  
  public static j iRR()
  {
    AppMethodBeat.i(141249);
    try
    {
      if (acmk == null) {
        acmk = new j();
      }
      j localj = acmk;
      return localj;
    }
    finally
    {
      AppMethodBeat.o(141249);
    }
  }
  
  public static boolean iRS()
  {
    AppMethodBeat.i(141256);
    if ((!acmq) || (!acmp))
    {
      AppMethodBeat.o(141256);
      return false;
    }
    AppMethodBeat.o(141256);
    return true;
  }
  
  public static j mw(Context paramContext)
  {
    AppMethodBeat.i(141252);
    paramContext = cR(paramContext, LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext));
    AppMethodBeat.o(141252);
    return paramContext;
  }
  
  public static String mx(Context paramContext)
  {
    AppMethodBeat.i(233197);
    if (BuildInfo.IS_FLAVOR_BLUE)
    {
      paramContext = paramContext.getString(a.k.app_brand_developer_version_suffix);
      AppMethodBeat.o(233197);
      return paramContext;
    }
    if (d.Yxk)
    {
      paramContext = paramContext.getString(a.k.alpha_version_alpha);
      AppMethodBeat.o(233197);
      return paramContext;
    }
    AppMethodBeat.o(233197);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ce.j
 * JD-Core Version:    0.7.0.1
 */