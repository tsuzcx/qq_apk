package com.tencent.mm.cc;

import android.arch.a.c.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public class h
{
  private static d NDA;
  private static g NDB;
  private static String NDC;
  private static boolean NDD;
  private static boolean NDE;
  private static a<String, Boolean> NDF;
  private static final List<String> NDx;
  private static h NDy;
  private static i NDz;
  
  static
  {
    AppMethodBeat.i(141263);
    NDx = Arrays.asList(new String[] { "zh_CN", "en" });
    NDC = "";
    NDD = false;
    NDE = true;
    NDF = new a() {};
    AppMethodBeat.o(141263);
  }
  
  private static int a(DataInputStream paramDataInputStream, SparseArray<d.a> paramSparseArray, int paramInt1, int paramInt2)
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
      paramSparseArray.append(paramInt1, new d.a(paramInt1, arrayOfInt1, arrayOfInt2));
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
  
  public static CharSequence an(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    return paramCharSequence;
  }
  
  private static boolean bhE(String paramString)
  {
    AppMethodBeat.i(141250);
    if (NDx.contains(paramString))
    {
      AppMethodBeat.o(141250);
      return false;
    }
    AppMethodBeat.o(141250);
    return true;
  }
  
  /* Error */
  private static void c(AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: ldc 124
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +16 -> 25
    //   12: ldc 94
    //   14: ldc 129
    //   16: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 124
    //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_1
    //   26: getstatic 52	com/tencent/mm/cc/h:NDC	Ljava/lang/String;
    //   29: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +24 -> 56
    //   35: ldc 94
    //   37: ldc 138
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 124
    //   52: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: aload_1
    //   57: ldc 142
    //   59: invokevirtual 146	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   62: istore_2
    //   63: aload_1
    //   64: astore 12
    //   66: iload_2
    //   67: ifle +48 -> 115
    //   70: aload_1
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 150	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: astore 10
    //   78: aload_1
    //   79: astore 12
    //   81: aload 10
    //   83: ldc 152
    //   85: invokevirtual 155	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   88: ifne +27 -> 115
    //   91: ldc 94
    //   93: ldc 157
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload 10
    //   107: aastore
    //   108: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload 10
    //   113: astore 12
    //   115: invokestatic 163	com/tencent/mm/cc/h:clean	()V
    //   118: aload 12
    //   120: putstatic 52	com/tencent/mm/cc/h:NDC	Ljava/lang/String;
    //   123: ldc 94
    //   125: ldc 165
    //   127: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   133: lstore 8
    //   135: aconst_null
    //   136: astore 10
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_0
    //   141: new 175	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 177
    //   147: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 12
    //   152: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 185
    //   157: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 195	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   166: astore_0
    //   167: aload_0
    //   168: astore_1
    //   169: aload_0
    //   170: astore 10
    //   172: new 73	java/io/DataInputStream
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 198	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   180: astore 11
    //   182: aload 11
    //   184: astore 10
    //   186: aload_0
    //   187: astore_1
    //   188: aload 11
    //   190: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   193: pop
    //   194: aload 11
    //   196: astore 10
    //   198: aload_0
    //   199: astore_1
    //   200: aload 11
    //   202: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   205: pop
    //   206: aload 11
    //   208: astore 10
    //   210: aload_0
    //   211: astore_1
    //   212: aload 11
    //   214: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   217: istore 5
    //   219: aload 11
    //   221: astore 10
    //   223: aload_0
    //   224: astore_1
    //   225: ldc 94
    //   227: ldc 204
    //   229: iload 5
    //   231: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 212	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload 11
    //   242: astore 10
    //   244: aload_0
    //   245: astore_1
    //   246: new 214	android/util/SparseIntArray
    //   249: dup
    //   250: iload 5
    //   252: invokespecial 216	android/util/SparseIntArray:<init>	(I)V
    //   255: astore 13
    //   257: aload 11
    //   259: astore 10
    //   261: aload_0
    //   262: astore_1
    //   263: aload 11
    //   265: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   268: istore 4
    //   270: iconst_0
    //   271: istore_2
    //   272: iconst_0
    //   273: istore_3
    //   274: iload_2
    //   275: iload 5
    //   277: if_icmpge +54 -> 331
    //   280: aload 11
    //   282: astore 10
    //   284: aload_0
    //   285: astore_1
    //   286: iload 4
    //   288: aload 11
    //   290: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   293: iadd
    //   294: istore 4
    //   296: aload 11
    //   298: astore 10
    //   300: aload_0
    //   301: astore_1
    //   302: aload 13
    //   304: iload 4
    //   306: iload_3
    //   307: invokevirtual 219	android/util/SparseIntArray:append	(II)V
    //   310: aload 11
    //   312: astore 10
    //   314: aload_0
    //   315: astore_1
    //   316: iload_3
    //   317: aload 11
    //   319: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   322: iadd
    //   323: istore_3
    //   324: iload_2
    //   325: iconst_1
    //   326: iadd
    //   327: istore_2
    //   328: goto -54 -> 274
    //   331: aload 11
    //   333: astore 10
    //   335: aload_0
    //   336: astore_1
    //   337: aload 13
    //   339: aload 11
    //   341: iload_3
    //   342: invokestatic 224	com/tencent/mm/cc/i:a	(Landroid/util/SparseIntArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/i;
    //   345: putstatic 226	com/tencent/mm/cc/h:NDz	Lcom/tencent/mm/cc/i;
    //   348: iconst_0
    //   349: istore_2
    //   350: aload 11
    //   352: astore 10
    //   354: aload_0
    //   355: astore_1
    //   356: aload 11
    //   358: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   361: istore 5
    //   363: aload 11
    //   365: astore 10
    //   367: aload_0
    //   368: astore_1
    //   369: ldc 94
    //   371: ldc 228
    //   373: iconst_1
    //   374: anewarray 4	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: iload 5
    //   381: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: iload 5
    //   390: ifle +100 -> 490
    //   393: aload 11
    //   395: astore 10
    //   397: aload_0
    //   398: astore_1
    //   399: new 88	android/util/SparseArray
    //   402: dup
    //   403: iload 5
    //   405: invokespecial 234	android/util/SparseArray:<init>	(I)V
    //   408: astore 13
    //   410: aload 11
    //   412: astore 10
    //   414: aload_0
    //   415: astore_1
    //   416: aload 11
    //   418: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   421: istore 4
    //   423: iconst_0
    //   424: istore_3
    //   425: iload_2
    //   426: iload 5
    //   428: if_icmpge +45 -> 473
    //   431: aload 11
    //   433: astore 10
    //   435: aload_0
    //   436: astore_1
    //   437: iload 4
    //   439: aload 11
    //   441: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   444: iadd
    //   445: istore 4
    //   447: aload 11
    //   449: astore 10
    //   451: aload_0
    //   452: astore_1
    //   453: iload_3
    //   454: aload 11
    //   456: aload 13
    //   458: iload 4
    //   460: iload_3
    //   461: invokestatic 236	com/tencent/mm/cc/h:a	(Ljava/io/DataInputStream;Landroid/util/SparseArray;II)I
    //   464: iadd
    //   465: istore_3
    //   466: iload_2
    //   467: iconst_1
    //   468: iadd
    //   469: istore_2
    //   470: goto -45 -> 425
    //   473: aload 11
    //   475: astore 10
    //   477: aload_0
    //   478: astore_1
    //   479: aload 13
    //   481: aload 11
    //   483: iload_3
    //   484: invokestatic 241	com/tencent/mm/cc/d:a	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/d;
    //   487: putstatic 243	com/tencent/mm/cc/h:NDA	Lcom/tencent/mm/cc/d;
    //   490: aload 11
    //   492: astore 10
    //   494: aload_0
    //   495: astore_1
    //   496: aload 11
    //   498: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   501: istore 6
    //   503: aload 11
    //   505: astore 10
    //   507: aload_0
    //   508: astore_1
    //   509: aload 11
    //   511: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   514: istore 4
    //   516: aload 11
    //   518: astore 10
    //   520: aload_0
    //   521: astore_1
    //   522: ldc 94
    //   524: ldc 245
    //   526: iconst_1
    //   527: anewarray 4	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: iload 6
    //   534: invokestatic 233	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: invokestatic 140	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   541: iload 6
    //   543: ifle +162 -> 705
    //   546: aload 11
    //   548: astore 10
    //   550: aload_0
    //   551: astore_1
    //   552: new 88	android/util/SparseArray
    //   555: dup
    //   556: iload 6
    //   558: invokespecial 234	android/util/SparseArray:<init>	(I)V
    //   561: astore 13
    //   563: iconst_0
    //   564: istore_3
    //   565: iconst_0
    //   566: istore_2
    //   567: iload_2
    //   568: iload 6
    //   570: if_icmpge +118 -> 688
    //   573: aload 11
    //   575: astore 10
    //   577: aload_0
    //   578: astore_1
    //   579: aload 11
    //   581: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   584: iload 4
    //   586: iadd
    //   587: istore 5
    //   589: aload 11
    //   591: astore 10
    //   593: aload_0
    //   594: astore_1
    //   595: aload 11
    //   597: invokevirtual 202	java/io/DataInputStream:readInt	()I
    //   600: istore 7
    //   602: aload 11
    //   604: astore 10
    //   606: aload_0
    //   607: astore_1
    //   608: iload 7
    //   610: newarray int
    //   612: astore 14
    //   614: iconst_0
    //   615: istore 4
    //   617: iload 4
    //   619: iload 7
    //   621: if_icmpge +32 -> 653
    //   624: aload 14
    //   626: iload 4
    //   628: iload_3
    //   629: iastore
    //   630: aload 11
    //   632: astore 10
    //   634: aload_0
    //   635: astore_1
    //   636: iload_3
    //   637: aload 11
    //   639: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   642: iadd
    //   643: istore_3
    //   644: iload 4
    //   646: iconst_1
    //   647: iadd
    //   648: istore 4
    //   650: goto -33 -> 617
    //   653: aload 11
    //   655: astore 10
    //   657: aload_0
    //   658: astore_1
    //   659: aload 13
    //   661: iload 5
    //   663: new 247	com/tencent/mm/cc/g$a
    //   666: dup
    //   667: iload 5
    //   669: aload 14
    //   671: invokespecial 250	com/tencent/mm/cc/g$a:<init>	(I[I)V
    //   674: invokevirtual 92	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   677: iload_2
    //   678: iconst_1
    //   679: iadd
    //   680: istore_2
    //   681: iload 5
    //   683: istore 4
    //   685: goto -118 -> 567
    //   688: aload 11
    //   690: astore 10
    //   692: aload_0
    //   693: astore_1
    //   694: aload 13
    //   696: aload 11
    //   698: iload_3
    //   699: invokestatic 256	com/tencent/mm/cc/g:b	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cc/g;
    //   702: putstatic 258	com/tencent/mm/cc/h:NDB	Lcom/tencent/mm/cc/g;
    //   705: aload_0
    //   706: ifnull +7 -> 713
    //   709: aload_0
    //   710: invokevirtual 263	java/io/InputStream:close	()V
    //   713: aload 11
    //   715: invokevirtual 264	java/io/DataInputStream:close	()V
    //   718: ldc 94
    //   720: new 175	java/lang/StringBuilder
    //   723: dup
    //   724: ldc_w 266
    //   727: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   730: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   733: lload 8
    //   735: lsub
    //   736: invokevirtual 269	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   739: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: ldc 124
    //   747: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: return
    //   751: astore_0
    //   752: ldc 94
    //   754: ldc 96
    //   756: iconst_1
    //   757: anewarray 4	java/lang/Object
    //   760: dup
    //   761: iconst_0
    //   762: aload_0
    //   763: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   766: aastore
    //   767: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   770: goto -57 -> 713
    //   773: astore_0
    //   774: ldc 94
    //   776: ldc 96
    //   778: iconst_1
    //   779: anewarray 4	java/lang/Object
    //   782: dup
    //   783: iconst_0
    //   784: aload_0
    //   785: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   788: aastore
    //   789: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   792: goto -74 -> 718
    //   795: astore 13
    //   797: aconst_null
    //   798: astore 11
    //   800: aload_1
    //   801: astore_0
    //   802: aload 11
    //   804: astore 10
    //   806: aload_0
    //   807: astore_1
    //   808: ldc 94
    //   810: aload 13
    //   812: ldc_w 271
    //   815: iconst_1
    //   816: anewarray 4	java/lang/Object
    //   819: dup
    //   820: iconst_0
    //   821: aload 12
    //   823: aastore
    //   824: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   827: aload_0
    //   828: ifnull +7 -> 835
    //   831: aload_0
    //   832: invokevirtual 263	java/io/InputStream:close	()V
    //   835: aload 11
    //   837: ifnull -119 -> 718
    //   840: aload 11
    //   842: invokevirtual 264	java/io/DataInputStream:close	()V
    //   845: goto -127 -> 718
    //   848: astore_0
    //   849: ldc 94
    //   851: ldc 96
    //   853: iconst_1
    //   854: anewarray 4	java/lang/Object
    //   857: dup
    //   858: iconst_0
    //   859: aload_0
    //   860: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   863: aastore
    //   864: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   867: goto -149 -> 718
    //   870: astore_0
    //   871: ldc 94
    //   873: ldc 96
    //   875: iconst_1
    //   876: anewarray 4	java/lang/Object
    //   879: dup
    //   880: iconst_0
    //   881: aload_0
    //   882: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   885: aastore
    //   886: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   889: goto -54 -> 835
    //   892: astore_0
    //   893: aconst_null
    //   894: astore 11
    //   896: aload 10
    //   898: astore_1
    //   899: aload 11
    //   901: astore 10
    //   903: aload_1
    //   904: ifnull +7 -> 911
    //   907: aload_1
    //   908: invokevirtual 263	java/io/InputStream:close	()V
    //   911: aload 10
    //   913: ifnull +8 -> 921
    //   916: aload 10
    //   918: invokevirtual 264	java/io/DataInputStream:close	()V
    //   921: ldc 124
    //   923: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   926: aload_0
    //   927: athrow
    //   928: astore_1
    //   929: ldc 94
    //   931: ldc 96
    //   933: iconst_1
    //   934: anewarray 4	java/lang/Object
    //   937: dup
    //   938: iconst_0
    //   939: aload_1
    //   940: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   943: aastore
    //   944: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   947: goto -36 -> 911
    //   950: astore_1
    //   951: ldc 94
    //   953: ldc 96
    //   955: iconst_1
    //   956: anewarray 4	java/lang/Object
    //   959: dup
    //   960: iconst_0
    //   961: aload_1
    //   962: invokestatic 102	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   965: aastore
    //   966: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   969: goto -48 -> 921
    //   972: astore_0
    //   973: goto -70 -> 903
    //   976: astore 13
    //   978: goto -176 -> 802
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	981	0	paramAssetManager	AssetManager
    //   0	981	1	paramString	String
    //   62	619	2	i	int
    //   273	426	3	j	int
    //   268	416	4	k	int
    //   217	465	5	m	int
    //   501	70	6	n	int
    //   600	22	7	i1	int
    //   133	601	8	l	long
    //   76	841	10	localObject1	Object
    //   180	720	11	localDataInputStream	DataInputStream
    //   64	758	12	localObject2	Object
    //   255	440	13	localObject3	Object
    //   795	16	13	localIOException1	IOException
    //   976	1	13	localIOException2	IOException
    //   612	58	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   709	713	751	java/io/IOException
    //   713	718	773	java/io/IOException
    //   140	167	795	java/io/IOException
    //   172	182	795	java/io/IOException
    //   840	845	848	java/io/IOException
    //   831	835	870	java/io/IOException
    //   140	167	892	finally
    //   172	182	892	finally
    //   907	911	928	java/io/IOException
    //   916	921	950	java/io/IOException
    //   188	194	972	finally
    //   200	206	972	finally
    //   212	219	972	finally
    //   225	240	972	finally
    //   246	257	972	finally
    //   263	270	972	finally
    //   286	296	972	finally
    //   302	310	972	finally
    //   316	324	972	finally
    //   337	348	972	finally
    //   356	363	972	finally
    //   369	388	972	finally
    //   399	410	972	finally
    //   416	423	972	finally
    //   437	447	972	finally
    //   453	466	972	finally
    //   479	490	972	finally
    //   496	503	972	finally
    //   509	516	972	finally
    //   522	541	972	finally
    //   552	563	972	finally
    //   579	589	972	finally
    //   595	602	972	finally
    //   608	614	972	finally
    //   636	644	972	finally
    //   659	677	972	finally
    //   694	705	972	finally
    //   808	827	972	finally
    //   188	194	976	java/io/IOException
    //   200	206	976	java/io/IOException
    //   212	219	976	java/io/IOException
    //   225	240	976	java/io/IOException
    //   246	257	976	java/io/IOException
    //   263	270	976	java/io/IOException
    //   286	296	976	java/io/IOException
    //   302	310	976	java/io/IOException
    //   316	324	976	java/io/IOException
    //   337	348	976	java/io/IOException
    //   356	363	976	java/io/IOException
    //   369	388	976	java/io/IOException
    //   399	410	976	java/io/IOException
    //   416	423	976	java/io/IOException
    //   437	447	976	java/io/IOException
    //   453	466	976	java/io/IOException
    //   479	490	976	java/io/IOException
    //   496	503	976	java/io/IOException
    //   509	516	976	java/io/IOException
    //   522	541	976	java/io/IOException
    //   552	563	976	java/io/IOException
    //   579	589	976	java/io/IOException
    //   595	602	976	java/io/IOException
    //   608	614	976	java/io/IOException
    //   636	644	976	java/io/IOException
    //   659	677	976	java/io/IOException
    //   694	705	976	java/io/IOException
  }
  
  private static void clean()
  {
    AppMethodBeat.i(141251);
    Object localObject;
    if (NDz != null)
    {
      localObject = NDz;
      if (((i)localObject).NDG != null) {
        ((i)localObject).NDG.clear();
      }
      if (((i)localObject).NDH != null) {
        ((i)localObject).NDH = null;
      }
    }
    if (NDA != null)
    {
      localObject = NDA;
      if (((d)localObject).NDr != null) {
        ((d)localObject).NDr.clear();
      }
      if (((d)localObject).mData != null) {
        ((d)localObject).mData = null;
      }
    }
    if (NDB != null)
    {
      localObject = NDB;
      if (((g)localObject).NDv != null) {
        ((g)localObject).NDv.clear();
      }
      if (((g)localObject).mData != null) {
        ((g)localObject).mData = null;
      }
    }
    AppMethodBeat.o(141251);
  }
  
  public static h cw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141253);
    if (paramContext.getResources() == null)
    {
      Log.e("MicroMsg.language.StringResouces", "the resource is null! why?");
      AppMethodBeat.o(141253);
      return null;
    }
    AssetManager localAssetManager = paramContext.getAssets();
    if (localAssetManager != null) {
      gvF();
    }
    if (localAssetManager != null)
    {
      gvF();
      if (NDE) {}
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
      gvF();
      boolean bool = bhE(paramContext);
      NDD = bool;
      if (!bool) {
        break;
      }
      gvF();
      c(localAssetManager, paramContext);
      paramContext = gvF();
      AppMethodBeat.o(141253);
      return paramContext;
    }
    clean();
    NDC = paramContext;
    AppMethodBeat.o(141253);
    return null;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141258);
    if (NDA == null)
    {
      AppMethodBeat.o(141258);
      return null;
    }
    String str = NDA.getQuantityString(paramInt1, paramInt2, new Object[0]);
    AppMethodBeat.o(141258);
    return str;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141259);
    if (NDA == null)
    {
      AppMethodBeat.o(141259);
      return null;
    }
    paramVarArgs = NDA.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(141259);
    return paramVarArgs;
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(141257);
    if (NDz == null)
    {
      AppMethodBeat.o(141257);
      return null;
    }
    String str = NDz.getString(paramInt);
    AppMethodBeat.o(141257);
    return str;
  }
  
  public static String[] getStringArray(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(141260);
    if (NDB == null)
    {
      AppMethodBeat.o(141260);
      return null;
    }
    g localg = NDB;
    int j = localg.NDv.indexOfKey(paramInt);
    if (j < 0)
    {
      AppMethodBeat.o(141260);
      return null;
    }
    g.a locala;
    String[] arrayOfString;
    if (j < localg.NDv.size() - 1)
    {
      paramInt = ((g.a)localg.NDv.valueAt(j + 1)).NDw[0];
      locala = (g.a)localg.NDv.valueAt(j);
      j = locala.NDw.length;
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
      arrayOfString[i] = new String(localg.mData, locala.NDw[i], locala.NDw[(i + 1)] - locala.NDw[i]);
    }
    for (;;)
    {
      i += 1;
      break label113;
      paramInt = localg.mData.length;
      break;
      label181:
      arrayOfString[i] = new String(localg.mData, locala.NDw[i], paramInt - locala.NDw[i]);
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
  
  public static h gvF()
  {
    AppMethodBeat.i(141249);
    try
    {
      if (NDy == null) {
        NDy = new h();
      }
      h localh = NDy;
      return localh;
    }
    finally
    {
      AppMethodBeat.o(141249);
    }
  }
  
  public static boolean gvG()
  {
    AppMethodBeat.i(141256);
    if ((!NDE) || (!NDD))
    {
      AppMethodBeat.o(141256);
      return false;
    }
    AppMethodBeat.o(141256);
    return true;
  }
  
  public static boolean gvz()
  {
    return NDE;
  }
  
  public static h jq(Context paramContext)
  {
    AppMethodBeat.i(141252);
    paramContext = cw(paramContext, LocaleUtil.loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext));
    AppMethodBeat.o(141252);
    return paramContext;
  }
  
  public static String jr(Context paramContext)
  {
    AppMethodBeat.i(205095);
    if (BuildInfo.IS_FLAVOR_BLUE)
    {
      paramContext = paramContext.getString(2131755428);
      AppMethodBeat.o(205095);
      return paramContext;
    }
    if (com.tencent.mm.protocal.d.KyR)
    {
      paramContext = paramContext.getString(2131755298);
      AppMethodBeat.o(205095);
      return paramContext;
    }
    AppMethodBeat.o(205095);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cc.h
 * JD-Core Version:    0.7.0.1
 */