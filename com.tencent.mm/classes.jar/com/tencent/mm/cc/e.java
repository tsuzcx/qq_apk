package com.tencent.mm.cc;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e
{
  private static final List<String> ubd = Arrays.asList(new String[] { "zh_CN" });
  private static e ube;
  private static f ubf;
  private static b ubg;
  private static d ubh;
  private static String ubi = "";
  private static boolean ubj = false;
  private static boolean ubk = true;
  private static ArrayList<Integer> ubl = new ArrayList();
  
  private static int a(DataInputStream paramDataInputStream, SparseArray<b.a> paramSparseArray, int paramInt1, int paramInt2)
  {
    try
    {
      int m = paramDataInputStream.readByte();
      if (m < 0) {
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
      paramSparseArray.append(paramInt1, new b.a(paramInt1, arrayOfInt1, arrayOfInt2));
      return j;
    }
    catch (IOException paramDataInputStream)
    {
      y.e("MicroMsg.language.StringResouces", "exception:%s", new Object[] { bk.j(paramDataInputStream) });
    }
    return 0;
  }
  
  /* Error */
  private static void a(android.content.res.AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 102	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +11 -> 15
    //   7: ldc 81
    //   9: ldc 104
    //   11: invokestatic 108	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: return
    //   15: aload_1
    //   16: getstatic 41	com/tencent/mm/cc/e:ubi	Ljava/lang/String;
    //   19: invokevirtual 112	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +19 -> 41
    //   25: ldc 81
    //   27: ldc 114
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: invokestatic 117	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: return
    //   41: aload_1
    //   42: ldc 119
    //   44: invokevirtual 123	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   47: istore_2
    //   48: aload_1
    //   49: astore 12
    //   51: iload_2
    //   52: ifle +48 -> 100
    //   55: aload_1
    //   56: iconst_0
    //   57: iload_2
    //   58: invokevirtual 127	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: astore 10
    //   63: aload_1
    //   64: astore 12
    //   66: aload 10
    //   68: ldc 129
    //   70: invokevirtual 132	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   73: ifne +27 -> 100
    //   76: ldc 81
    //   78: ldc 134
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload 10
    //   92: aastore
    //   93: invokestatic 137	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload 10
    //   98: astore 12
    //   100: invokestatic 140	com/tencent/mm/cc/e:clean	()V
    //   103: aload 12
    //   105: putstatic 41	com/tencent/mm/cc/e:ubi	Ljava/lang/String;
    //   108: ldc 81
    //   110: ldc 142
    //   112: invokestatic 144	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   118: lstore 8
    //   120: aconst_null
    //   121: astore 10
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_0
    //   126: new 152	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 154
    //   132: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload 12
    //   137: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 162
    //   142: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokevirtual 172	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   151: astore_0
    //   152: aload_0
    //   153: astore_1
    //   154: aload_0
    //   155: astore 10
    //   157: new 60	java/io/DataInputStream
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 175	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   165: astore 11
    //   167: aload 11
    //   169: astore 10
    //   171: aload_0
    //   172: astore_1
    //   173: aload 11
    //   175: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   178: pop
    //   179: aload 11
    //   181: astore 10
    //   183: aload_0
    //   184: astore_1
    //   185: aload 11
    //   187: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   190: pop
    //   191: aload 11
    //   193: astore 10
    //   195: aload_0
    //   196: astore_1
    //   197: aload 11
    //   199: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   202: istore 5
    //   204: aload 11
    //   206: astore 10
    //   208: aload_0
    //   209: astore_1
    //   210: ldc 81
    //   212: new 152	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 181
    //   218: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: iload 5
    //   223: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 144	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 11
    //   234: astore 10
    //   236: aload_0
    //   237: astore_1
    //   238: new 186	android/util/SparseIntArray
    //   241: dup
    //   242: iload 5
    //   244: invokespecial 189	android/util/SparseIntArray:<init>	(I)V
    //   247: astore 13
    //   249: aload 11
    //   251: astore 10
    //   253: aload_0
    //   254: astore_1
    //   255: aload 11
    //   257: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   260: istore 4
    //   262: iconst_0
    //   263: istore_2
    //   264: iconst_0
    //   265: istore_3
    //   266: iload_2
    //   267: iload 5
    //   269: if_icmpge +54 -> 323
    //   272: aload 11
    //   274: astore 10
    //   276: aload_0
    //   277: astore_1
    //   278: iload 4
    //   280: aload 11
    //   282: invokevirtual 68	java/io/DataInputStream:readShort	()S
    //   285: iadd
    //   286: istore 4
    //   288: aload 11
    //   290: astore 10
    //   292: aload_0
    //   293: astore_1
    //   294: aload 13
    //   296: iload 4
    //   298: iload_3
    //   299: invokevirtual 192	android/util/SparseIntArray:append	(II)V
    //   302: aload 11
    //   304: astore 10
    //   306: aload_0
    //   307: astore_1
    //   308: iload_3
    //   309: aload 11
    //   311: invokevirtual 68	java/io/DataInputStream:readShort	()S
    //   314: iadd
    //   315: istore_3
    //   316: iload_2
    //   317: iconst_1
    //   318: iadd
    //   319: istore_2
    //   320: goto -54 -> 266
    //   323: aload 11
    //   325: astore 10
    //   327: aload_0
    //   328: astore_1
    //   329: aload 13
    //   331: aload 11
    //   333: iload_3
    //   334: invokestatic 197	com/tencent/mm/cc/f:a	(Landroid/util/SparseIntArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/f;
    //   337: putstatic 199	com/tencent/mm/cc/e:ubf	Lcom/tencent/mm/cc/f;
    //   340: iconst_0
    //   341: istore_2
    //   342: aload 11
    //   344: astore 10
    //   346: aload_0
    //   347: astore_1
    //   348: aload 11
    //   350: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   353: istore 5
    //   355: aload 11
    //   357: astore 10
    //   359: aload_0
    //   360: astore_1
    //   361: ldc 81
    //   363: ldc 201
    //   365: iconst_1
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: iload 5
    //   373: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   376: aastore
    //   377: invokestatic 117	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: iload 5
    //   382: ifle +100 -> 482
    //   385: aload 11
    //   387: astore 10
    //   389: aload_0
    //   390: astore_1
    //   391: new 75	android/util/SparseArray
    //   394: dup
    //   395: iload 5
    //   397: invokespecial 208	android/util/SparseArray:<init>	(I)V
    //   400: astore 13
    //   402: aload 11
    //   404: astore 10
    //   406: aload_0
    //   407: astore_1
    //   408: aload 11
    //   410: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   413: istore 4
    //   415: iconst_0
    //   416: istore_3
    //   417: iload_2
    //   418: iload 5
    //   420: if_icmpge +45 -> 465
    //   423: aload 11
    //   425: astore 10
    //   427: aload_0
    //   428: astore_1
    //   429: iload 4
    //   431: aload 11
    //   433: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   436: iadd
    //   437: istore 4
    //   439: aload 11
    //   441: astore 10
    //   443: aload_0
    //   444: astore_1
    //   445: iload_3
    //   446: aload 11
    //   448: aload 13
    //   450: iload 4
    //   452: iload_3
    //   453: invokestatic 210	com/tencent/mm/cc/e:a	(Ljava/io/DataInputStream;Landroid/util/SparseArray;II)I
    //   456: iadd
    //   457: istore_3
    //   458: iload_2
    //   459: iconst_1
    //   460: iadd
    //   461: istore_2
    //   462: goto -45 -> 417
    //   465: aload 11
    //   467: astore 10
    //   469: aload_0
    //   470: astore_1
    //   471: aload 13
    //   473: aload 11
    //   475: iload_3
    //   476: invokestatic 215	com/tencent/mm/cc/b:a	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/b;
    //   479: putstatic 217	com/tencent/mm/cc/e:ubg	Lcom/tencent/mm/cc/b;
    //   482: aload 11
    //   484: astore 10
    //   486: aload_0
    //   487: astore_1
    //   488: aload 11
    //   490: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   493: istore 6
    //   495: aload 11
    //   497: astore 10
    //   499: aload_0
    //   500: astore_1
    //   501: aload 11
    //   503: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   506: istore 4
    //   508: aload 11
    //   510: astore 10
    //   512: aload_0
    //   513: astore_1
    //   514: ldc 81
    //   516: ldc 219
    //   518: iconst_1
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: iload 6
    //   526: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aastore
    //   530: invokestatic 117	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   533: iload 6
    //   535: ifle +162 -> 697
    //   538: aload 11
    //   540: astore 10
    //   542: aload_0
    //   543: astore_1
    //   544: new 75	android/util/SparseArray
    //   547: dup
    //   548: iload 6
    //   550: invokespecial 208	android/util/SparseArray:<init>	(I)V
    //   553: astore 13
    //   555: iconst_0
    //   556: istore_3
    //   557: iconst_0
    //   558: istore_2
    //   559: iload_2
    //   560: iload 6
    //   562: if_icmpge +118 -> 680
    //   565: aload 11
    //   567: astore 10
    //   569: aload_0
    //   570: astore_1
    //   571: aload 11
    //   573: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   576: iload 4
    //   578: iadd
    //   579: istore 5
    //   581: aload 11
    //   583: astore 10
    //   585: aload_0
    //   586: astore_1
    //   587: aload 11
    //   589: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   592: istore 7
    //   594: aload 11
    //   596: astore 10
    //   598: aload_0
    //   599: astore_1
    //   600: iload 7
    //   602: newarray int
    //   604: astore 14
    //   606: iconst_0
    //   607: istore 4
    //   609: iload 4
    //   611: iload 7
    //   613: if_icmpge +32 -> 645
    //   616: aload 14
    //   618: iload 4
    //   620: iload_3
    //   621: iastore
    //   622: aload 11
    //   624: astore 10
    //   626: aload_0
    //   627: astore_1
    //   628: iload_3
    //   629: aload 11
    //   631: invokevirtual 68	java/io/DataInputStream:readShort	()S
    //   634: iadd
    //   635: istore_3
    //   636: iload 4
    //   638: iconst_1
    //   639: iadd
    //   640: istore 4
    //   642: goto -33 -> 609
    //   645: aload 11
    //   647: astore 10
    //   649: aload_0
    //   650: astore_1
    //   651: aload 13
    //   653: iload 5
    //   655: new 221	com/tencent/mm/cc/d$a
    //   658: dup
    //   659: iload 5
    //   661: aload 14
    //   663: invokespecial 224	com/tencent/mm/cc/d$a:<init>	(I[I)V
    //   666: invokevirtual 79	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   669: iload_2
    //   670: iconst_1
    //   671: iadd
    //   672: istore_2
    //   673: iload 5
    //   675: istore 4
    //   677: goto -118 -> 559
    //   680: aload 11
    //   682: astore 10
    //   684: aload_0
    //   685: astore_1
    //   686: aload 13
    //   688: aload 11
    //   690: iload_3
    //   691: invokestatic 230	com/tencent/mm/cc/d:b	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/d;
    //   694: putstatic 232	com/tencent/mm/cc/e:ubh	Lcom/tencent/mm/cc/d;
    //   697: aload_0
    //   698: ifnull +7 -> 705
    //   701: aload_0
    //   702: invokevirtual 237	java/io/InputStream:close	()V
    //   705: aload 11
    //   707: invokevirtual 238	java/io/DataInputStream:close	()V
    //   710: ldc 81
    //   712: new 152	java/lang/StringBuilder
    //   715: dup
    //   716: ldc 240
    //   718: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   721: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   724: lload 8
    //   726: lsub
    //   727: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   730: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 144	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   736: return
    //   737: astore_0
    //   738: ldc 81
    //   740: ldc 83
    //   742: iconst_1
    //   743: anewarray 4	java/lang/Object
    //   746: dup
    //   747: iconst_0
    //   748: aload_0
    //   749: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   752: aastore
    //   753: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   756: goto -51 -> 705
    //   759: astore_0
    //   760: ldc 81
    //   762: ldc 83
    //   764: iconst_1
    //   765: anewarray 4	java/lang/Object
    //   768: dup
    //   769: iconst_0
    //   770: aload_0
    //   771: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   774: aastore
    //   775: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   778: goto -68 -> 710
    //   781: astore 13
    //   783: aconst_null
    //   784: astore 11
    //   786: aload_1
    //   787: astore_0
    //   788: aload 11
    //   790: astore 10
    //   792: aload_0
    //   793: astore_1
    //   794: ldc 81
    //   796: aload 13
    //   798: ldc 245
    //   800: iconst_1
    //   801: anewarray 4	java/lang/Object
    //   804: dup
    //   805: iconst_0
    //   806: aload 12
    //   808: aastore
    //   809: invokestatic 249	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: aload_0
    //   813: ifnull +7 -> 820
    //   816: aload_0
    //   817: invokevirtual 237	java/io/InputStream:close	()V
    //   820: aload 11
    //   822: ifnull -112 -> 710
    //   825: aload 11
    //   827: invokevirtual 238	java/io/DataInputStream:close	()V
    //   830: goto -120 -> 710
    //   833: astore_0
    //   834: ldc 81
    //   836: ldc 83
    //   838: iconst_1
    //   839: anewarray 4	java/lang/Object
    //   842: dup
    //   843: iconst_0
    //   844: aload_0
    //   845: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   848: aastore
    //   849: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   852: goto -142 -> 710
    //   855: astore_0
    //   856: ldc 81
    //   858: ldc 83
    //   860: iconst_1
    //   861: anewarray 4	java/lang/Object
    //   864: dup
    //   865: iconst_0
    //   866: aload_0
    //   867: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   870: aastore
    //   871: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   874: goto -54 -> 820
    //   877: astore_0
    //   878: aconst_null
    //   879: astore 11
    //   881: aload 10
    //   883: astore_1
    //   884: aload 11
    //   886: astore 10
    //   888: aload_1
    //   889: ifnull +7 -> 896
    //   892: aload_1
    //   893: invokevirtual 237	java/io/InputStream:close	()V
    //   896: aload 10
    //   898: ifnull +8 -> 906
    //   901: aload 10
    //   903: invokevirtual 238	java/io/DataInputStream:close	()V
    //   906: aload_0
    //   907: athrow
    //   908: astore_1
    //   909: ldc 81
    //   911: ldc 83
    //   913: iconst_1
    //   914: anewarray 4	java/lang/Object
    //   917: dup
    //   918: iconst_0
    //   919: aload_1
    //   920: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   923: aastore
    //   924: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   927: goto -31 -> 896
    //   930: astore_1
    //   931: ldc 81
    //   933: ldc 83
    //   935: iconst_1
    //   936: anewarray 4	java/lang/Object
    //   939: dup
    //   940: iconst_0
    //   941: aload_1
    //   942: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   945: aastore
    //   946: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   949: goto -43 -> 906
    //   952: astore_0
    //   953: goto -65 -> 888
    //   956: astore 13
    //   958: goto -170 -> 788
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	961	0	paramAssetManager	android.content.res.AssetManager
    //   0	961	1	paramString	String
    //   47	626	2	i	int
    //   265	426	3	j	int
    //   260	416	4	k	int
    //   202	472	5	m	int
    //   493	70	6	n	int
    //   592	22	7	i1	int
    //   118	607	8	l	long
    //   61	841	10	localObject1	Object
    //   165	720	11	localDataInputStream	DataInputStream
    //   49	758	12	localObject2	Object
    //   247	440	13	localObject3	Object
    //   781	16	13	localIOException1	IOException
    //   956	1	13	localIOException2	IOException
    //   604	58	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   701	705	737	java/io/IOException
    //   705	710	759	java/io/IOException
    //   125	152	781	java/io/IOException
    //   157	167	781	java/io/IOException
    //   825	830	833	java/io/IOException
    //   816	820	855	java/io/IOException
    //   125	152	877	finally
    //   157	167	877	finally
    //   892	896	908	java/io/IOException
    //   901	906	930	java/io/IOException
    //   173	179	952	finally
    //   185	191	952	finally
    //   197	204	952	finally
    //   210	232	952	finally
    //   238	249	952	finally
    //   255	262	952	finally
    //   278	288	952	finally
    //   294	302	952	finally
    //   308	316	952	finally
    //   329	340	952	finally
    //   348	355	952	finally
    //   361	380	952	finally
    //   391	402	952	finally
    //   408	415	952	finally
    //   429	439	952	finally
    //   445	458	952	finally
    //   471	482	952	finally
    //   488	495	952	finally
    //   501	508	952	finally
    //   514	533	952	finally
    //   544	555	952	finally
    //   571	581	952	finally
    //   587	594	952	finally
    //   600	606	952	finally
    //   628	636	952	finally
    //   651	669	952	finally
    //   686	697	952	finally
    //   794	812	952	finally
    //   173	179	956	java/io/IOException
    //   185	191	956	java/io/IOException
    //   197	204	956	java/io/IOException
    //   210	232	956	java/io/IOException
    //   238	249	956	java/io/IOException
    //   255	262	956	java/io/IOException
    //   278	288	956	java/io/IOException
    //   294	302	956	java/io/IOException
    //   308	316	956	java/io/IOException
    //   329	340	956	java/io/IOException
    //   348	355	956	java/io/IOException
    //   361	380	956	java/io/IOException
    //   391	402	956	java/io/IOException
    //   408	415	956	java/io/IOException
    //   429	439	956	java/io/IOException
    //   445	458	956	java/io/IOException
    //   471	482	956	java/io/IOException
    //   488	495	956	java/io/IOException
    //   501	508	956	java/io/IOException
    //   514	533	956	java/io/IOException
    //   544	555	956	java/io/IOException
    //   571	581	956	java/io/IOException
    //   587	594	956	java/io/IOException
    //   600	606	956	java/io/IOException
    //   628	636	956	java/io/IOException
    //   651	669	956	java/io/IOException
    //   686	697	956	java/io/IOException
  }
  
  /* Error */
  public static e br(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 257	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: ifnonnull +13 -> 17
    //   7: ldc 81
    //   9: ldc_w 259
    //   12: invokestatic 261	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 265	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: astore 10
    //   23: aload 10
    //   25: ifnull +246 -> 271
    //   28: invokestatic 269	com/tencent/mm/cc/e:cpw	()Lcom/tencent/mm/cc/e;
    //   31: pop
    //   32: ldc 81
    //   34: ldc_w 271
    //   37: invokestatic 144	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: getstatic 52	com/tencent/mm/cc/e:ubl	Ljava/util/ArrayList;
    //   43: ifnonnull +13 -> 56
    //   46: new 47	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 50	java/util/ArrayList:<init>	()V
    //   53: putstatic 52	com/tencent/mm/cc/e:ubl	Ljava/util/ArrayList;
    //   56: getstatic 52	com/tencent/mm/cc/e:ubl	Ljava/util/ArrayList;
    //   59: invokevirtual 274	java/util/ArrayList:clear	()V
    //   62: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   65: lstore_3
    //   66: aconst_null
    //   67: astore 7
    //   69: aconst_null
    //   70: astore 8
    //   72: aload 10
    //   74: ldc_w 276
    //   77: invokevirtual 172	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   80: astore 6
    //   82: aload 6
    //   84: astore 8
    //   86: aload 6
    //   88: astore 7
    //   90: new 60	java/io/DataInputStream
    //   93: dup
    //   94: aload 6
    //   96: invokespecial 175	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 9
    //   101: aload 9
    //   103: astore 8
    //   105: aload 6
    //   107: astore 7
    //   109: aload 9
    //   111: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   114: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: astore 11
    //   119: aload 9
    //   121: astore 8
    //   123: aload 6
    //   125: astore 7
    //   127: ldc 81
    //   129: ldc_w 278
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload 11
    //   140: aastore
    //   141: invokestatic 137	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_0
    //   145: istore_2
    //   146: aload 9
    //   148: astore 8
    //   150: aload 6
    //   152: astore 7
    //   154: iload_2
    //   155: aload 11
    //   157: invokevirtual 281	java/lang/Integer:intValue	()I
    //   160: if_icmpge +70 -> 230
    //   163: aload 9
    //   165: astore 8
    //   167: aload 6
    //   169: astore 7
    //   171: aload 9
    //   173: invokevirtual 179	java/io/DataInputStream:readInt	()I
    //   176: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: astore 12
    //   181: aload 9
    //   183: astore 8
    //   185: aload 6
    //   187: astore 7
    //   189: getstatic 52	com/tencent/mm/cc/e:ubl	Ljava/util/ArrayList;
    //   192: aload 12
    //   194: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   197: pop
    //   198: aload 9
    //   200: astore 8
    //   202: aload 6
    //   204: astore 7
    //   206: ldc 81
    //   208: ldc_w 286
    //   211: iconst_1
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload 12
    //   219: aastore
    //   220: invokestatic 137	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -81 -> 146
    //   230: aload 6
    //   232: ifnull +8 -> 240
    //   235: aload 6
    //   237: invokevirtual 237	java/io/InputStream:close	()V
    //   240: aload 9
    //   242: invokevirtual 238	java/io/DataInputStream:close	()V
    //   245: ldc 81
    //   247: new 152	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 288
    //   254: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   260: lload_3
    //   261: lsub
    //   262: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 144	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload 10
    //   273: ifnull +13 -> 286
    //   276: invokestatic 269	com/tencent/mm/cc/e:cpw	()Lcom/tencent/mm/cc/e;
    //   279: pop
    //   280: getstatic 45	com/tencent/mm/cc/e:ubk	Z
    //   283: ifne +218 -> 501
    //   286: aconst_null
    //   287: areturn
    //   288: astore 6
    //   290: ldc 81
    //   292: ldc 83
    //   294: iconst_1
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: aload 6
    //   302: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   305: aastore
    //   306: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: goto -69 -> 240
    //   312: astore 6
    //   314: ldc 81
    //   316: ldc 83
    //   318: iconst_1
    //   319: anewarray 4	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: aload 6
    //   326: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   329: aastore
    //   330: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: goto -88 -> 245
    //   336: astore 6
    //   338: aconst_null
    //   339: astore 9
    //   341: aload 8
    //   343: astore 6
    //   345: aload 9
    //   347: astore 8
    //   349: aload 6
    //   351: astore 7
    //   353: ldc 81
    //   355: ldc_w 290
    //   358: invokestatic 108	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 6
    //   363: ifnull +8 -> 371
    //   366: aload 6
    //   368: invokevirtual 237	java/io/InputStream:close	()V
    //   371: aload 9
    //   373: ifnull -128 -> 245
    //   376: aload 9
    //   378: invokevirtual 238	java/io/DataInputStream:close	()V
    //   381: goto -136 -> 245
    //   384: astore 6
    //   386: ldc 81
    //   388: ldc 83
    //   390: iconst_1
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload 6
    //   398: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   401: aastore
    //   402: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: goto -160 -> 245
    //   408: astore 6
    //   410: ldc 81
    //   412: ldc 83
    //   414: iconst_1
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: aload 6
    //   422: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: goto -58 -> 371
    //   432: astore_0
    //   433: aconst_null
    //   434: astore_1
    //   435: aload 7
    //   437: ifnull +8 -> 445
    //   440: aload 7
    //   442: invokevirtual 237	java/io/InputStream:close	()V
    //   445: aload_1
    //   446: ifnull +7 -> 453
    //   449: aload_1
    //   450: invokevirtual 238	java/io/DataInputStream:close	()V
    //   453: aload_0
    //   454: athrow
    //   455: astore 6
    //   457: ldc 81
    //   459: ldc 83
    //   461: iconst_1
    //   462: anewarray 4	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload 6
    //   469: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   472: aastore
    //   473: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   476: goto -31 -> 445
    //   479: astore_1
    //   480: ldc 81
    //   482: ldc 83
    //   484: iconst_1
    //   485: anewarray 4	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: aload_1
    //   491: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   494: aastore
    //   495: invokestatic 95	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   498: goto -45 -> 453
    //   501: aload_1
    //   502: invokestatic 102	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   505: ifne +13 -> 518
    //   508: aload_1
    //   509: ldc_w 292
    //   512: invokevirtual 132	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   515: ifeq +62 -> 577
    //   518: invokestatic 298	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   521: astore_1
    //   522: aload_0
    //   523: aload_1
    //   524: invokestatic 303	com/tencent/mm/sdk/platformtools/x:a	(Landroid/content/Context;Ljava/util/Locale;)V
    //   527: aload_1
    //   528: astore_0
    //   529: aload_0
    //   530: invokevirtual 304	java/util/Locale:toString	()Ljava/lang/String;
    //   533: astore_0
    //   534: invokestatic 269	com/tencent/mm/cc/e:cpw	()Lcom/tencent/mm/cc/e;
    //   537: pop
    //   538: getstatic 37	com/tencent/mm/cc/e:ubd	Ljava/util/List;
    //   541: aload_0
    //   542: invokeinterface 309 2 0
    //   547: ifeq +38 -> 585
    //   550: iconst_0
    //   551: istore 5
    //   553: iload 5
    //   555: putstatic 43	com/tencent/mm/cc/e:ubj	Z
    //   558: iload 5
    //   560: ifeq +31 -> 591
    //   563: invokestatic 269	com/tencent/mm/cc/e:cpw	()Lcom/tencent/mm/cc/e;
    //   566: pop
    //   567: aload 10
    //   569: aload_0
    //   570: invokestatic 311	com/tencent/mm/cc/e:a	(Landroid/content/res/AssetManager;Ljava/lang/String;)V
    //   573: invokestatic 269	com/tencent/mm/cc/e:cpw	()Lcom/tencent/mm/cc/e;
    //   576: areturn
    //   577: aload_1
    //   578: invokestatic 315	com/tencent/mm/sdk/platformtools/x:Zi	(Ljava/lang/String;)Ljava/util/Locale;
    //   581: astore_0
    //   582: goto -53 -> 529
    //   585: iconst_1
    //   586: istore 5
    //   588: goto -35 -> 553
    //   591: invokestatic 140	com/tencent/mm/cc/e:clean	()V
    //   594: aload_0
    //   595: putstatic 41	com/tencent/mm/cc/e:ubi	Ljava/lang/String;
    //   598: aconst_null
    //   599: areturn
    //   600: astore_0
    //   601: aload 8
    //   603: astore_1
    //   604: goto -169 -> 435
    //   607: astore 7
    //   609: goto -264 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	paramContext	Context
    //   0	612	1	paramString	String
    //   145	82	2	i	int
    //   65	196	3	l	long
    //   551	36	5	bool	boolean
    //   80	156	6	localInputStream	java.io.InputStream
    //   288	13	6	localIOException1	IOException
    //   312	13	6	localIOException2	IOException
    //   336	1	6	localIOException3	IOException
    //   343	24	6	localObject1	Object
    //   384	13	6	localIOException4	IOException
    //   408	13	6	localIOException5	IOException
    //   455	13	6	localIOException6	IOException
    //   67	374	7	localObject2	Object
    //   607	1	7	localIOException7	IOException
    //   70	532	8	localObject3	Object
    //   99	278	9	localDataInputStream	DataInputStream
    //   21	547	10	localAssetManager	android.content.res.AssetManager
    //   117	39	11	localInteger1	Integer
    //   179	39	12	localInteger2	Integer
    // Exception table:
    //   from	to	target	type
    //   235	240	288	java/io/IOException
    //   240	245	312	java/io/IOException
    //   72	82	336	java/io/IOException
    //   90	101	336	java/io/IOException
    //   376	381	384	java/io/IOException
    //   366	371	408	java/io/IOException
    //   72	82	432	finally
    //   90	101	432	finally
    //   440	445	455	java/io/IOException
    //   449	453	479	java/io/IOException
    //   109	119	600	finally
    //   127	144	600	finally
    //   154	163	600	finally
    //   171	181	600	finally
    //   189	198	600	finally
    //   206	223	600	finally
    //   353	361	600	finally
    //   109	119	607	java/io/IOException
    //   127	144	607	java/io/IOException
    //   154	163	607	java/io/IOException
    //   171	181	607	java/io/IOException
    //   189	198	607	java/io/IOException
    //   206	223	607	java/io/IOException
  }
  
  private static void clean()
  {
    Object localObject;
    if (ubf != null)
    {
      localObject = ubf;
      if (((f)localObject).ubm != null) {
        ((f)localObject).ubm.clear();
      }
      if (((f)localObject).ubn != null) {
        ((f)localObject).ubn = null;
      }
    }
    if (ubg != null)
    {
      localObject = ubg;
      if (((b)localObject).uaW != null) {
        ((b)localObject).uaW.clear();
      }
      if (((b)localObject).mData != null) {
        ((b)localObject).mData = null;
      }
    }
    if (ubh != null)
    {
      localObject = ubh;
      if (((d)localObject).ubb != null) {
        ((d)localObject).ubb.clear();
      }
      if (((d)localObject).mData != null) {
        ((d)localObject).mData = null;
      }
    }
  }
  
  public static boolean cpv()
  {
    return ubk;
  }
  
  public static e cpw()
  {
    try
    {
      if (ube == null) {
        ube = new e();
      }
      e locale = ube;
      return locale;
    }
    finally {}
  }
  
  public static boolean cpx()
  {
    boolean bool = false;
    if ((!ubk) || (!ubj)) {
      if ((ubl == null) || (ubl.isEmpty())) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static CharSequence d(int paramInt, CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while ((ubl == null) || (ubl.isEmpty()) || (!ubl.contains(Integer.valueOf(paramInt)))) {
      return paramCharSequence;
    }
    return a.q(paramCharSequence.toString(), g.o("lucky".getBytes()).substring(0, 16));
  }
  
  public static e fl(Context paramContext)
  {
    return br(paramContext, x.d(paramContext.getSharedPreferences(ae.cqR(), 0)));
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2)
  {
    if (ubg == null) {
      return null;
    }
    return ubg.getQuantityString(paramInt1, paramInt2, new Object[0]);
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (ubg == null) {
      return null;
    }
    return ubg.getQuantityString(paramInt1, paramInt2, paramVarArgs);
  }
  
  public static String getString(int paramInt)
  {
    if (ubf == null) {
      return null;
    }
    return ubf.getString(paramInt);
  }
  
  public static String[] getStringArray(int paramInt)
  {
    int i = 0;
    if (ubh == null) {}
    d locald;
    int j;
    do
    {
      return null;
      locald = ubh;
      j = locald.ubb.indexOfKey(paramInt);
    } while (j < 0);
    d.a locala;
    String[] arrayOfString;
    if (j < locald.ubb.size() - 1)
    {
      paramInt = ((d.a)locald.ubb.valueAt(j + 1)).ubc[0];
      locala = (d.a)locald.ubb.valueAt(j);
      j = locala.ubc.length;
      if (j <= 0) {
        break label197;
      }
      arrayOfString = new String[j];
      label93:
      if (i >= j) {
        break label195;
      }
      if (i >= j - 1) {
        break label161;
      }
      arrayOfString[i] = new String(locald.mData, locala.ubc[i], locala.ubc[(i + 1)] - locala.ubc[i]);
    }
    for (;;)
    {
      i += 1;
      break label93;
      paramInt = locald.mData.length;
      break;
      label161:
      arrayOfString[i] = new String(locald.mData, locala.ubc[i], paramInt - locala.ubc[i]);
    }
    for (;;)
    {
      label195:
      return arrayOfString;
      label197:
      arrayOfString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.e
 * JD-Core Version:    0.7.0.1
 */