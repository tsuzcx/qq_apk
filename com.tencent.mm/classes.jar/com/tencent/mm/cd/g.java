package com.tencent.mm.cd;

import android.arch.a.c.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class g
{
  private static final List<String> Gkg;
  private static g Gkh;
  private static h Gki;
  private static d Gkj;
  private static f Gkk;
  private static String Gkl;
  private static boolean Gkm;
  private static boolean Gkn;
  private static a<String, Boolean> Gko;
  
  static
  {
    AppMethodBeat.i(141263);
    Gkg = Arrays.asList(new String[] { "zh_CN", "en" });
    Gkl = "";
    Gkm = false;
    Gkn = true;
    Gko = new a() {};
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
      ac.e("MicroMsg.language.StringResouces", "exception:%s", new Object[] { bs.m(paramDataInputStream) });
      AppMethodBeat.o(141261);
    }
    return 0;
  }
  
  private static boolean aJY(String paramString)
  {
    AppMethodBeat.i(141250);
    if (Gkg.contains(paramString))
    {
      AppMethodBeat.o(141250);
      return false;
    }
    AppMethodBeat.o(141250);
    return true;
  }
  
  public static CharSequence ai(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    return paramCharSequence;
  }
  
  public static g bW(Context paramContext, String paramString)
  {
    AppMethodBeat.i(141253);
    if (paramContext.getResources() == null)
    {
      ac.e("MicroMsg.language.StringResouces", "the resource is null! why?");
      AppMethodBeat.o(141253);
      return null;
    }
    AssetManager localAssetManager = paramContext.getAssets();
    if (localAssetManager != null) {
      eSH();
    }
    if (localAssetManager != null)
    {
      eSH();
      if (Gkn) {}
    }
    else
    {
      AppMethodBeat.o(141253);
      return null;
    }
    if ((bs.isNullOrNil(paramString)) || (paramString.equalsIgnoreCase("language_default")))
    {
      paramString = Locale.getDefault();
      ab.a(paramContext, paramString);
    }
    for (paramContext = paramString;; paramContext = ab.aKK(paramString))
    {
      paramContext = paramContext.toString();
      eSH();
      boolean bool = aJY(paramContext);
      Gkm = bool;
      if (!bool) {
        break;
      }
      eSH();
      c(localAssetManager, paramContext);
      paramContext = eSH();
      AppMethodBeat.o(141253);
      return paramContext;
    }
    clean();
    Gkl = paramContext;
    AppMethodBeat.o(141253);
    return null;
  }
  
  /* Error */
  private static void c(AssetManager paramAssetManager, String paramString)
  {
    // Byte code:
    //   0: ldc 180
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 146	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +16 -> 25
    //   12: ldc 94
    //   14: ldc 182
    //   16: invokestatic 185	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 180
    //   21: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_1
    //   26: getstatic 52	com/tencent/mm/cd/g:Gkl	Ljava/lang/String;
    //   29: invokevirtual 188	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +24 -> 56
    //   35: ldc 94
    //   37: ldc 190
    //   39: iconst_1
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 192	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 180
    //   52: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: aload_1
    //   57: ldc 194
    //   59: invokevirtual 198	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   62: istore_2
    //   63: aload_1
    //   64: astore 12
    //   66: iload_2
    //   67: ifle +48 -> 115
    //   70: aload_1
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 202	java/lang/String:substring	(II)Ljava/lang/String;
    //   76: astore 10
    //   78: aload_1
    //   79: astore 12
    //   81: aload 10
    //   83: ldc 204
    //   85: invokevirtual 151	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   88: ifne +27 -> 115
    //   91: ldc 94
    //   93: ldc 206
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
    //   108: invokestatic 209	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload 10
    //   113: astore 12
    //   115: invokestatic 179	com/tencent/mm/cd/g:clean	()V
    //   118: aload 12
    //   120: putstatic 52	com/tencent/mm/cd/g:Gkl	Ljava/lang/String;
    //   123: ldc 94
    //   125: ldc 211
    //   127: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   133: lstore 8
    //   135: aconst_null
    //   136: astore 10
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_0
    //   141: new 221	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 223
    //   147: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 12
    //   152: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 231
    //   157: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 238	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   166: astore_0
    //   167: aload_0
    //   168: astore_1
    //   169: aload_0
    //   170: astore 10
    //   172: new 73	java/io/DataInputStream
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 241	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   180: astore 11
    //   182: aload 11
    //   184: astore 10
    //   186: aload_0
    //   187: astore_1
    //   188: aload 11
    //   190: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   193: pop
    //   194: aload 11
    //   196: astore 10
    //   198: aload_0
    //   199: astore_1
    //   200: aload 11
    //   202: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   205: pop
    //   206: aload 11
    //   208: astore 10
    //   210: aload_0
    //   211: astore_1
    //   212: aload 11
    //   214: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   217: istore 5
    //   219: aload 11
    //   221: astore 10
    //   223: aload_0
    //   224: astore_1
    //   225: ldc 94
    //   227: ldc 247
    //   229: iload 5
    //   231: invokestatic 251	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 255	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload 11
    //   242: astore 10
    //   244: aload_0
    //   245: astore_1
    //   246: new 257	android/util/SparseIntArray
    //   249: dup
    //   250: iload 5
    //   252: invokespecial 259	android/util/SparseIntArray:<init>	(I)V
    //   255: astore 13
    //   257: aload 11
    //   259: astore 10
    //   261: aload_0
    //   262: astore_1
    //   263: aload 11
    //   265: invokevirtual 245	java/io/DataInputStream:readInt	()I
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
    //   307: invokevirtual 262	android/util/SparseIntArray:append	(II)V
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
    //   342: invokestatic 267	com/tencent/mm/cd/h:a	(Landroid/util/SparseIntArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cd/h;
    //   345: putstatic 269	com/tencent/mm/cd/g:Gki	Lcom/tencent/mm/cd/h;
    //   348: iconst_0
    //   349: istore_2
    //   350: aload 11
    //   352: astore 10
    //   354: aload_0
    //   355: astore_1
    //   356: aload 11
    //   358: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   361: istore 5
    //   363: aload 11
    //   365: astore 10
    //   367: aload_0
    //   368: astore_1
    //   369: ldc 94
    //   371: ldc_w 271
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: iload 5
    //   382: invokestatic 276	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: aastore
    //   386: invokestatic 192	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: iload 5
    //   391: ifle +100 -> 491
    //   394: aload 11
    //   396: astore 10
    //   398: aload_0
    //   399: astore_1
    //   400: new 88	android/util/SparseArray
    //   403: dup
    //   404: iload 5
    //   406: invokespecial 277	android/util/SparseArray:<init>	(I)V
    //   409: astore 13
    //   411: aload 11
    //   413: astore 10
    //   415: aload_0
    //   416: astore_1
    //   417: aload 11
    //   419: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   422: istore 4
    //   424: iconst_0
    //   425: istore_3
    //   426: iload_2
    //   427: iload 5
    //   429: if_icmpge +45 -> 474
    //   432: aload 11
    //   434: astore 10
    //   436: aload_0
    //   437: astore_1
    //   438: iload 4
    //   440: aload 11
    //   442: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   445: iadd
    //   446: istore 4
    //   448: aload 11
    //   450: astore 10
    //   452: aload_0
    //   453: astore_1
    //   454: iload_3
    //   455: aload 11
    //   457: aload 13
    //   459: iload 4
    //   461: iload_3
    //   462: invokestatic 279	com/tencent/mm/cd/g:a	(Ljava/io/DataInputStream;Landroid/util/SparseArray;II)I
    //   465: iadd
    //   466: istore_3
    //   467: iload_2
    //   468: iconst_1
    //   469: iadd
    //   470: istore_2
    //   471: goto -45 -> 426
    //   474: aload 11
    //   476: astore 10
    //   478: aload_0
    //   479: astore_1
    //   480: aload 13
    //   482: aload 11
    //   484: iload_3
    //   485: invokestatic 284	com/tencent/mm/cd/d:a	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cd/d;
    //   488: putstatic 286	com/tencent/mm/cd/g:Gkj	Lcom/tencent/mm/cd/d;
    //   491: aload 11
    //   493: astore 10
    //   495: aload_0
    //   496: astore_1
    //   497: aload 11
    //   499: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   502: istore 6
    //   504: aload 11
    //   506: astore 10
    //   508: aload_0
    //   509: astore_1
    //   510: aload 11
    //   512: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   515: istore 4
    //   517: aload 11
    //   519: astore 10
    //   521: aload_0
    //   522: astore_1
    //   523: ldc 94
    //   525: ldc_w 288
    //   528: iconst_1
    //   529: anewarray 4	java/lang/Object
    //   532: dup
    //   533: iconst_0
    //   534: iload 6
    //   536: invokestatic 276	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aastore
    //   540: invokestatic 192	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   543: iload 6
    //   545: ifle +162 -> 707
    //   548: aload 11
    //   550: astore 10
    //   552: aload_0
    //   553: astore_1
    //   554: new 88	android/util/SparseArray
    //   557: dup
    //   558: iload 6
    //   560: invokespecial 277	android/util/SparseArray:<init>	(I)V
    //   563: astore 13
    //   565: iconst_0
    //   566: istore_3
    //   567: iconst_0
    //   568: istore_2
    //   569: iload_2
    //   570: iload 6
    //   572: if_icmpge +118 -> 690
    //   575: aload 11
    //   577: astore 10
    //   579: aload_0
    //   580: astore_1
    //   581: aload 11
    //   583: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   586: iload 4
    //   588: iadd
    //   589: istore 5
    //   591: aload 11
    //   593: astore 10
    //   595: aload_0
    //   596: astore_1
    //   597: aload 11
    //   599: invokevirtual 245	java/io/DataInputStream:readInt	()I
    //   602: istore 7
    //   604: aload 11
    //   606: astore 10
    //   608: aload_0
    //   609: astore_1
    //   610: iload 7
    //   612: newarray int
    //   614: astore 14
    //   616: iconst_0
    //   617: istore 4
    //   619: iload 4
    //   621: iload 7
    //   623: if_icmpge +32 -> 655
    //   626: aload 14
    //   628: iload 4
    //   630: iload_3
    //   631: iastore
    //   632: aload 11
    //   634: astore 10
    //   636: aload_0
    //   637: astore_1
    //   638: iload_3
    //   639: aload 11
    //   641: invokevirtual 81	java/io/DataInputStream:readShort	()S
    //   644: iadd
    //   645: istore_3
    //   646: iload 4
    //   648: iconst_1
    //   649: iadd
    //   650: istore 4
    //   652: goto -33 -> 619
    //   655: aload 11
    //   657: astore 10
    //   659: aload_0
    //   660: astore_1
    //   661: aload 13
    //   663: iload 5
    //   665: new 290	com/tencent/mm/cd/f$a
    //   668: dup
    //   669: iload 5
    //   671: aload 14
    //   673: invokespecial 293	com/tencent/mm/cd/f$a:<init>	(I[I)V
    //   676: invokevirtual 92	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   679: iload_2
    //   680: iconst_1
    //   681: iadd
    //   682: istore_2
    //   683: iload 5
    //   685: istore 4
    //   687: goto -118 -> 569
    //   690: aload 11
    //   692: astore 10
    //   694: aload_0
    //   695: astore_1
    //   696: aload 13
    //   698: aload 11
    //   700: iload_3
    //   701: invokestatic 299	com/tencent/mm/cd/f:b	(Landroid/util/SparseArray;Ljava/io/InputStream;I)Lcom/tencent/mm/cd/f;
    //   704: putstatic 301	com/tencent/mm/cd/g:Gkk	Lcom/tencent/mm/cd/f;
    //   707: aload_0
    //   708: ifnull +7 -> 715
    //   711: aload_0
    //   712: invokevirtual 306	java/io/InputStream:close	()V
    //   715: aload 11
    //   717: invokevirtual 307	java/io/DataInputStream:close	()V
    //   720: ldc 94
    //   722: new 221	java/lang/StringBuilder
    //   725: dup
    //   726: ldc_w 309
    //   729: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   735: lload 8
    //   737: lsub
    //   738: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   741: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 213	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: ldc 180
    //   749: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   752: return
    //   753: astore_0
    //   754: ldc 94
    //   756: ldc 96
    //   758: iconst_1
    //   759: anewarray 4	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: aload_0
    //   765: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   768: aastore
    //   769: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   772: goto -57 -> 715
    //   775: astore_0
    //   776: ldc 94
    //   778: ldc 96
    //   780: iconst_1
    //   781: anewarray 4	java/lang/Object
    //   784: dup
    //   785: iconst_0
    //   786: aload_0
    //   787: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   790: aastore
    //   791: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   794: goto -74 -> 720
    //   797: astore 13
    //   799: aconst_null
    //   800: astore 11
    //   802: aload_1
    //   803: astore_0
    //   804: aload 11
    //   806: astore 10
    //   808: aload_0
    //   809: astore_1
    //   810: ldc 94
    //   812: aload 13
    //   814: ldc_w 314
    //   817: iconst_1
    //   818: anewarray 4	java/lang/Object
    //   821: dup
    //   822: iconst_0
    //   823: aload 12
    //   825: aastore
    //   826: invokestatic 318	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   829: aload_0
    //   830: ifnull +7 -> 837
    //   833: aload_0
    //   834: invokevirtual 306	java/io/InputStream:close	()V
    //   837: aload 11
    //   839: ifnull -119 -> 720
    //   842: aload 11
    //   844: invokevirtual 307	java/io/DataInputStream:close	()V
    //   847: goto -127 -> 720
    //   850: astore_0
    //   851: ldc 94
    //   853: ldc 96
    //   855: iconst_1
    //   856: anewarray 4	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: aload_0
    //   862: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   865: aastore
    //   866: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   869: goto -149 -> 720
    //   872: astore_0
    //   873: ldc 94
    //   875: ldc 96
    //   877: iconst_1
    //   878: anewarray 4	java/lang/Object
    //   881: dup
    //   882: iconst_0
    //   883: aload_0
    //   884: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   887: aastore
    //   888: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   891: goto -54 -> 837
    //   894: astore_0
    //   895: aconst_null
    //   896: astore 11
    //   898: aload 10
    //   900: astore_1
    //   901: aload 11
    //   903: astore 10
    //   905: aload_1
    //   906: ifnull +7 -> 913
    //   909: aload_1
    //   910: invokevirtual 306	java/io/InputStream:close	()V
    //   913: aload 10
    //   915: ifnull +8 -> 923
    //   918: aload 10
    //   920: invokevirtual 307	java/io/DataInputStream:close	()V
    //   923: ldc 180
    //   925: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   928: aload_0
    //   929: athrow
    //   930: astore_1
    //   931: ldc 94
    //   933: ldc 96
    //   935: iconst_1
    //   936: anewarray 4	java/lang/Object
    //   939: dup
    //   940: iconst_0
    //   941: aload_1
    //   942: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   945: aastore
    //   946: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   949: goto -36 -> 913
    //   952: astore_1
    //   953: ldc 94
    //   955: ldc 96
    //   957: iconst_1
    //   958: anewarray 4	java/lang/Object
    //   961: dup
    //   962: iconst_0
    //   963: aload_1
    //   964: invokestatic 102	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   967: aastore
    //   968: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   971: goto -48 -> 923
    //   974: astore_0
    //   975: goto -70 -> 905
    //   978: astore 13
    //   980: goto -176 -> 804
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	983	0	paramAssetManager	AssetManager
    //   0	983	1	paramString	String
    //   62	621	2	i	int
    //   273	428	3	j	int
    //   268	418	4	k	int
    //   217	467	5	m	int
    //   502	71	6	n	int
    //   602	22	7	i1	int
    //   133	603	8	l	long
    //   76	843	10	localObject1	Object
    //   180	722	11	localDataInputStream	DataInputStream
    //   64	760	12	localObject2	Object
    //   255	442	13	localObject3	Object
    //   797	16	13	localIOException1	IOException
    //   978	1	13	localIOException2	IOException
    //   614	58	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   711	715	753	java/io/IOException
    //   715	720	775	java/io/IOException
    //   140	167	797	java/io/IOException
    //   172	182	797	java/io/IOException
    //   842	847	850	java/io/IOException
    //   833	837	872	java/io/IOException
    //   140	167	894	finally
    //   172	182	894	finally
    //   909	913	930	java/io/IOException
    //   918	923	952	java/io/IOException
    //   188	194	974	finally
    //   200	206	974	finally
    //   212	219	974	finally
    //   225	240	974	finally
    //   246	257	974	finally
    //   263	270	974	finally
    //   286	296	974	finally
    //   302	310	974	finally
    //   316	324	974	finally
    //   337	348	974	finally
    //   356	363	974	finally
    //   369	389	974	finally
    //   400	411	974	finally
    //   417	424	974	finally
    //   438	448	974	finally
    //   454	467	974	finally
    //   480	491	974	finally
    //   497	504	974	finally
    //   510	517	974	finally
    //   523	543	974	finally
    //   554	565	974	finally
    //   581	591	974	finally
    //   597	604	974	finally
    //   610	616	974	finally
    //   638	646	974	finally
    //   661	679	974	finally
    //   696	707	974	finally
    //   810	829	974	finally
    //   188	194	978	java/io/IOException
    //   200	206	978	java/io/IOException
    //   212	219	978	java/io/IOException
    //   225	240	978	java/io/IOException
    //   246	257	978	java/io/IOException
    //   263	270	978	java/io/IOException
    //   286	296	978	java/io/IOException
    //   302	310	978	java/io/IOException
    //   316	324	978	java/io/IOException
    //   337	348	978	java/io/IOException
    //   356	363	978	java/io/IOException
    //   369	389	978	java/io/IOException
    //   400	411	978	java/io/IOException
    //   417	424	978	java/io/IOException
    //   438	448	978	java/io/IOException
    //   454	467	978	java/io/IOException
    //   480	491	978	java/io/IOException
    //   497	504	978	java/io/IOException
    //   510	517	978	java/io/IOException
    //   523	543	978	java/io/IOException
    //   554	565	978	java/io/IOException
    //   581	591	978	java/io/IOException
    //   597	604	978	java/io/IOException
    //   610	616	978	java/io/IOException
    //   638	646	978	java/io/IOException
    //   661	679	978	java/io/IOException
    //   696	707	978	java/io/IOException
  }
  
  private static void clean()
  {
    AppMethodBeat.i(141251);
    Object localObject;
    if (Gki != null)
    {
      localObject = Gki;
      if (((h)localObject).Gkp != null) {
        ((h)localObject).Gkp.clear();
      }
      if (((h)localObject).Gkq != null) {
        ((h)localObject).Gkq = null;
      }
    }
    if (Gkj != null)
    {
      localObject = Gkj;
      if (((d)localObject).Gka != null) {
        ((d)localObject).Gka.clear();
      }
      if (((d)localObject).mData != null) {
        ((d)localObject).mData = null;
      }
    }
    if (Gkk != null)
    {
      localObject = Gkk;
      if (((f)localObject).Gke != null) {
        ((f)localObject).Gke.clear();
      }
      if (((f)localObject).mData != null) {
        ((f)localObject).mData = null;
      }
    }
    AppMethodBeat.o(141251);
  }
  
  public static boolean eSC()
  {
    return Gkn;
  }
  
  public static g eSH()
  {
    AppMethodBeat.i(141249);
    try
    {
      if (Gkh == null) {
        Gkh = new g();
      }
      g localg = Gkh;
      return localg;
    }
    finally
    {
      AppMethodBeat.o(141249);
    }
  }
  
  public static boolean eSI()
  {
    AppMethodBeat.i(141256);
    if ((!Gkn) || (!Gkm))
    {
      AppMethodBeat.o(141256);
      return false;
    }
    AppMethodBeat.o(141256);
    return true;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141258);
    if (Gkj == null)
    {
      AppMethodBeat.o(141258);
      return null;
    }
    String str = Gkj.getQuantityString(paramInt1, paramInt2, new Object[0]);
    AppMethodBeat.o(141258);
    return str;
  }
  
  public static String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(141259);
    if (Gkj == null)
    {
      AppMethodBeat.o(141259);
      return null;
    }
    paramVarArgs = Gkj.getQuantityString(paramInt1, paramInt2, paramVarArgs);
    AppMethodBeat.o(141259);
    return paramVarArgs;
  }
  
  public static String getString(int paramInt)
  {
    AppMethodBeat.i(141257);
    if (Gki == null)
    {
      AppMethodBeat.o(141257);
      return null;
    }
    String str = Gki.getString(paramInt);
    AppMethodBeat.o(141257);
    return str;
  }
  
  public static String[] getStringArray(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(141260);
    if (Gkk == null)
    {
      AppMethodBeat.o(141260);
      return null;
    }
    f localf = Gkk;
    int j = localf.Gke.indexOfKey(paramInt);
    if (j < 0)
    {
      AppMethodBeat.o(141260);
      return null;
    }
    f.a locala;
    String[] arrayOfString;
    if (j < localf.Gke.size() - 1)
    {
      paramInt = ((f.a)localf.Gke.valueAt(j + 1)).Gkf[0];
      locala = (f.a)localf.Gke.valueAt(j);
      j = locala.Gkf.length;
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
      arrayOfString[i] = new String(localf.mData, locala.Gkf[i], locala.Gkf[(i + 1)] - locala.Gkf[i]);
    }
    for (;;)
    {
      i += 1;
      break label113;
      paramInt = localf.mData.length;
      break;
      label181:
      arrayOfString[i] = new String(localf.mData, locala.Gkf[i], paramInt - locala.Gkf[i]);
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
  
  public static g ii(Context paramContext)
  {
    AppMethodBeat.i(141252);
    paramContext = bW(paramContext, ab.f(paramContext.getSharedPreferences(ai.eUX(), 0)));
    AppMethodBeat.o(141252);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cd.g
 * JD-Core Version:    0.7.0.1
 */