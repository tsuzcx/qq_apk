package com.tencent.luggage.sdk.b.a.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.util.ArrayList;

public final class a
{
  private static void a(ArrayList<String> paramArrayList, File paramFile, ArrayList<File> paramArrayList1)
  {
    AppMethodBeat.i(220357);
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      Log.e("Luggage.WxAudioLoadSoHandler", "checkSoLibMatch apiFolder has none subfile, path:%s", new Object[] { paramFile.getAbsolutePath() });
      AppMethodBeat.o(220357);
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      Log.i("Luggage.WxAudioLoadSoHandler", "checkSoLibMatch file path:%s", new Object[] { arrayOfFile[i].getAbsolutePath() });
      if ((arrayOfFile[i].getName().contains("libwxWtf.so")) && (a(paramArrayList, arrayOfFile[i]))) {
        paramArrayList1.add(0, arrayOfFile[i]);
      }
      if ((arrayOfFile[i].getName().contains("libmmwebaudio.so")) && (a(paramArrayList, arrayOfFile[i]))) {
        paramArrayList1.add(arrayOfFile[i]);
      }
      i += 1;
    }
    AppMethodBeat.o(220357);
  }
  
  private static boolean a(ArrayList<String> paramArrayList, File paramFile)
  {
    AppMethodBeat.i(220362);
    paramFile = y.bub(paramFile.getPath());
    if (TextUtils.isEmpty(paramFile))
    {
      AppMethodBeat.o(220362);
      return false;
    }
    boolean bool = paramArrayList.contains(paramFile);
    AppMethodBeat.o(220362);
    return bool;
  }
  
  /* Error */
  public static boolean bp(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 93
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 21
    //   7: ldc 95
    //   9: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: new 15	java/io/File
    //   15: dup
    //   16: new 100	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: invokevirtual 110	android/content/Context:getFilesDir	()Ljava/io/File;
    //   27: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   30: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 116
    //   35: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 126	java/io/File:exists	()Z
    //   49: ifne +17 -> 66
    //   52: ldc 21
    //   54: ldc 128
    //   56: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 93
    //   61: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_0
    //   65: ireturn
    //   66: aload_0
    //   67: invokevirtual 131	java/io/File:isDirectory	()Z
    //   70: ifne +17 -> 87
    //   73: ldc 21
    //   75: ldc 133
    //   77: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 93
    //   82: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload_0
    //   88: invokevirtual 19	java/io/File:listFiles	()[Ljava/io/File;
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +8 -> 101
    //   96: aload_0
    //   97: arraylength
    //   98: ifne +17 -> 115
    //   101: ldc 21
    //   103: ldc 135
    //   105: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: ldc 93
    //   110: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: new 56	java/util/ArrayList
    //   118: dup
    //   119: iconst_2
    //   120: invokespecial 137	java/util/ArrayList:<init>	(I)V
    //   123: astore 4
    //   125: ldc 21
    //   127: ldc 139
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: arraylength
    //   137: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_0
    //   145: istore_1
    //   146: iload_1
    //   147: aload_0
    //   148: arraylength
    //   149: if_icmpge +466 -> 615
    //   152: ldc 21
    //   154: ldc 147
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_0
    //   163: iload_1
    //   164: aaload
    //   165: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: aload_0
    //   173: iload_1
    //   174: aaload
    //   175: invokevirtual 131	java/io/File:isDirectory	()Z
    //   178: ifeq +51 -> 229
    //   181: new 15	java/io/File
    //   184: dup
    //   185: new 100	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   192: aload_0
    //   193: iload_1
    //   194: aaload
    //   195: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   198: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 149
    //   203: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 5
    //   214: aload 5
    //   216: invokevirtual 126	java/io/File:exists	()Z
    //   219: ifne +17 -> 236
    //   222: ldc 21
    //   224: ldc 151
    //   226: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: goto -87 -> 146
    //   236: aload 5
    //   238: invokevirtual 131	java/io/File:isDirectory	()Z
    //   241: ifne +13 -> 254
    //   244: ldc 21
    //   246: ldc 155
    //   248: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -22 -> 229
    //   254: aload 5
    //   256: invokevirtual 19	java/io/File:listFiles	()[Ljava/io/File;
    //   259: astore 5
    //   261: aload 5
    //   263: ifnull -34 -> 229
    //   266: aload 5
    //   268: arraylength
    //   269: ifeq -40 -> 229
    //   272: new 56	java/util/ArrayList
    //   275: dup
    //   276: iconst_2
    //   277: invokespecial 137	java/util/ArrayList:<init>	(I)V
    //   280: astore 6
    //   282: iconst_0
    //   283: istore_2
    //   284: iload_2
    //   285: aload 5
    //   287: arraylength
    //   288: if_icmpge -59 -> 229
    //   291: aload 6
    //   293: invokevirtual 158	java/util/ArrayList:clear	()V
    //   296: aload 4
    //   298: invokevirtual 158	java/util/ArrayList:clear	()V
    //   301: ldc 21
    //   303: ldc 147
    //   305: iconst_1
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload 5
    //   313: iload_2
    //   314: aaload
    //   315: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   318: aastore
    //   319: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: getstatic 164	com/tencent/mm/sdk/platformtools/BuildInfo:IS_ARM64	Z
    //   325: ifeq +163 -> 488
    //   328: aload 5
    //   330: iload_2
    //   331: aaload
    //   332: invokevirtual 43	java/io/File:getName	()Ljava/lang/String;
    //   335: ldc 166
    //   337: invokevirtual 51	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   340: ifeq +148 -> 488
    //   343: aload 6
    //   345: ldc 168
    //   347: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   350: pop
    //   351: aload 6
    //   353: ldc 170
    //   355: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   358: pop
    //   359: aload 6
    //   361: aload 5
    //   363: iload_2
    //   364: aaload
    //   365: aload 4
    //   367: invokestatic 172	com/tencent/luggage/sdk/b/a/e/a:a	(Ljava/util/ArrayList;Ljava/io/File;Ljava/util/ArrayList;)V
    //   370: aload 4
    //   372: invokevirtual 176	java/util/ArrayList:size	()I
    //   375: iconst_1
    //   376: if_icmple +232 -> 608
    //   379: ldc 21
    //   381: ldc 178
    //   383: iconst_1
    //   384: anewarray 4	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: aload 4
    //   391: iconst_0
    //   392: invokevirtual 182	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   395: checkcast 15	java/io/File
    //   398: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   401: aastore
    //   402: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: ldc 21
    //   407: ldc 184
    //   409: iconst_1
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload 4
    //   417: iconst_1
    //   418: invokevirtual 182	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   421: checkcast 15	java/io/File
    //   424: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   427: aastore
    //   428: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload 4
    //   433: iconst_0
    //   434: invokevirtual 182	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   437: checkcast 15	java/io/File
    //   440: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   443: invokestatic 189	java/lang/System:load	(Ljava/lang/String;)V
    //   446: aload 4
    //   448: iconst_1
    //   449: invokevirtual 182	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   452: checkcast 15	java/io/File
    //   455: invokevirtual 27	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   458: invokestatic 189	java/lang/System:load	(Ljava/lang/String;)V
    //   461: iconst_1
    //   462: istore_3
    //   463: ldc 21
    //   465: ldc 191
    //   467: iconst_1
    //   468: anewarray 4	java/lang/Object
    //   471: dup
    //   472: iconst_0
    //   473: iload_3
    //   474: invokestatic 196	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   477: aastore
    //   478: invokestatic 40	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: ldc 93
    //   483: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   486: iload_3
    //   487: ireturn
    //   488: getstatic 164	com/tencent/mm/sdk/platformtools/BuildInfo:IS_ARM64	Z
    //   491: ifne -121 -> 370
    //   494: aload 5
    //   496: iload_2
    //   497: aaload
    //   498: invokevirtual 43	java/io/File:getName	()Ljava/lang/String;
    //   501: ldc 198
    //   503: invokevirtual 51	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   506: ifeq -136 -> 370
    //   509: aload 6
    //   511: ldc 200
    //   513: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   516: pop
    //   517: aload 6
    //   519: ldc 202
    //   521: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   524: pop
    //   525: aload 6
    //   527: aload 5
    //   529: iload_2
    //   530: aaload
    //   531: aload 4
    //   533: invokestatic 172	com/tencent/luggage/sdk/b/a/e/a:a	(Ljava/util/ArrayList;Ljava/io/File;Ljava/util/ArrayList;)V
    //   536: goto -166 -> 370
    //   539: astore_0
    //   540: ldc 21
    //   542: aload_0
    //   543: ldc 204
    //   545: iconst_1
    //   546: anewarray 4	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: ldc 206
    //   553: aastore
    //   554: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: iconst_0
    //   558: istore_3
    //   559: goto -96 -> 463
    //   562: astore_0
    //   563: ldc 21
    //   565: aload_0
    //   566: ldc 204
    //   568: iconst_1
    //   569: anewarray 4	java/lang/Object
    //   572: dup
    //   573: iconst_0
    //   574: ldc 206
    //   576: aastore
    //   577: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: iconst_0
    //   581: istore_3
    //   582: goto -119 -> 463
    //   585: astore_0
    //   586: ldc 21
    //   588: aload_0
    //   589: ldc 204
    //   591: iconst_1
    //   592: anewarray 4	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: ldc 206
    //   599: aastore
    //   600: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: iconst_0
    //   604: istore_3
    //   605: goto -142 -> 463
    //   608: iload_2
    //   609: iconst_1
    //   610: iadd
    //   611: istore_2
    //   612: goto -328 -> 284
    //   615: ldc 21
    //   617: ldc 212
    //   619: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: ldc 93
    //   624: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   627: iconst_0
    //   628: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	paramContext	android.content.Context
    //   145	88	1	i	int
    //   283	329	2	j	int
    //   462	143	3	bool	boolean
    //   123	409	4	localArrayList1	ArrayList
    //   212	316	5	localObject	Object
    //   280	246	6	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   431	461	539	java/lang/UnsatisfiedLinkError
    //   431	461	562	java/lang/SecurityException
    //   431	461	585	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */