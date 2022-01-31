package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

public final class a
{
  public Bitmap ebm;
  
  /* Error */
  public static Bitmap L(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: sipush 16005
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 29	com/tencent/mm/platformtools/ah:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: sipush 16005
    //   16: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 34	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   28: aload_1
    //   29: ldc 37
    //   31: aload_0
    //   32: invokevirtual 43	java/lang/String:getBytes	()[B
    //   35: invokestatic 49	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   38: ldc 51
    //   40: iconst_1
    //   41: invokestatic 57	com/tencent/mm/sdk/platformtools/j:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   44: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 63
    //   49: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore 9
    //   57: iconst_1
    //   58: istore_3
    //   59: aconst_null
    //   60: astore 6
    //   62: aconst_null
    //   63: astore 8
    //   65: aconst_null
    //   66: astore 7
    //   68: aconst_null
    //   69: astore_1
    //   70: new 69	java/io/File
    //   73: dup
    //   74: aload 9
    //   76: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 76	java/io/File:exists	()Z
    //   84: ifne +27 -> 111
    //   87: ldc 78
    //   89: ldc 80
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload 9
    //   99: aastore
    //   100: invokestatic 85	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: sipush 16005
    //   106: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: aload_0
    //   112: invokevirtual 89	java/io/File:length	()J
    //   115: l2i
    //   116: istore_2
    //   117: iload_2
    //   118: ifle +15 -> 133
    //   121: iload_2
    //   122: ldc 90
    //   124: if_icmpeq +40 -> 164
    //   127: iload_2
    //   128: ldc 91
    //   130: if_icmpeq +34 -> 164
    //   133: ldc 78
    //   135: ldc 93
    //   137: iconst_2
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: iload_2
    //   144: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload 9
    //   152: aastore
    //   153: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: sipush 16005
    //   159: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: new 104	java/io/FileInputStream
    //   167: dup
    //   168: aload 9
    //   170: invokespecial 105	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   173: astore_0
    //   174: aload 8
    //   176: astore_1
    //   177: aload 7
    //   179: astore 6
    //   181: aload_0
    //   182: invokevirtual 109	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   185: astore 7
    //   187: aload 7
    //   189: astore_1
    //   190: aload 7
    //   192: astore 6
    //   194: ldc 90
    //   196: invokestatic 115	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   199: astore 8
    //   201: aload 7
    //   203: astore_1
    //   204: aload 7
    //   206: astore 6
    //   208: aload 7
    //   210: aload 8
    //   212: invokevirtual 121	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   215: pop
    //   216: aload 7
    //   218: astore_1
    //   219: aload 7
    //   221: astore 6
    //   223: aload 8
    //   225: iconst_0
    //   226: invokevirtual 125	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   229: pop
    //   230: iload_2
    //   231: ldc 91
    //   233: if_icmpne +125 -> 358
    //   236: aload 7
    //   238: astore_1
    //   239: aload 7
    //   241: astore 6
    //   243: bipush 16
    //   245: invokestatic 115	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   248: astore 10
    //   250: aload 7
    //   252: astore_1
    //   253: aload 7
    //   255: astore 6
    //   257: aload 7
    //   259: aload 10
    //   261: invokevirtual 121	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   264: pop
    //   265: aload 7
    //   267: astore_1
    //   268: aload 7
    //   270: astore 6
    //   272: aload 10
    //   274: iconst_0
    //   275: invokevirtual 129	java/nio/ByteBuffer:getLong	(I)J
    //   278: lstore 4
    //   280: lload 4
    //   282: lconst_1
    //   283: lcmp
    //   284: ifeq +72 -> 356
    //   287: aload 7
    //   289: astore_1
    //   290: aload 7
    //   292: astore 6
    //   294: ldc 78
    //   296: ldc 131
    //   298: iconst_3
    //   299: anewarray 4	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: lload 4
    //   306: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   309: aastore
    //   310: dup
    //   311: iconst_1
    //   312: iload_2
    //   313: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   316: aastore
    //   317: dup
    //   318: iconst_2
    //   319: aload 9
    //   321: aastore
    //   322: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: aload 7
    //   327: astore_1
    //   328: aload 7
    //   330: astore 6
    //   332: aload 7
    //   334: invokevirtual 139	java/nio/channels/FileChannel:close	()V
    //   337: aload 7
    //   339: astore_1
    //   340: aload 7
    //   342: astore 6
    //   344: aload_0
    //   345: invokevirtual 140	java/io/FileInputStream:close	()V
    //   348: sipush 16005
    //   351: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aconst_null
    //   355: areturn
    //   356: iconst_0
    //   357: istore_3
    //   358: aload 7
    //   360: astore_1
    //   361: aload 7
    //   363: astore 6
    //   365: ldc 78
    //   367: ldc 142
    //   369: iconst_3
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: iload_2
    //   376: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: iconst_1
    //   382: iload_3
    //   383: invokestatic 147	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   386: aastore
    //   387: dup
    //   388: iconst_2
    //   389: aload 9
    //   391: aastore
    //   392: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: aload 7
    //   397: astore_1
    //   398: aload 7
    //   400: astore 6
    //   402: aload 7
    //   404: invokevirtual 139	java/nio/channels/FileChannel:close	()V
    //   407: aload_0
    //   408: astore 6
    //   410: aload_0
    //   411: astore 7
    //   413: aload_0
    //   414: invokevirtual 140	java/io/FileInputStream:close	()V
    //   417: aconst_null
    //   418: astore_1
    //   419: aconst_null
    //   420: astore_0
    //   421: aload_0
    //   422: astore 6
    //   424: aload_1
    //   425: astore 7
    //   427: bipush 96
    //   429: bipush 96
    //   431: getstatic 156	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   434: invokestatic 162	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   437: astore 10
    //   439: aload_0
    //   440: astore 6
    //   442: aload_1
    //   443: astore 7
    //   445: aload 10
    //   447: aload 8
    //   449: invokevirtual 166	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   452: iload_3
    //   453: ifeq +69 -> 522
    //   456: aload_0
    //   457: astore 6
    //   459: aload_1
    //   460: astore 7
    //   462: aload 10
    //   464: bipush 9
    //   466: bipush 9
    //   468: bipush 78
    //   470: bipush 78
    //   472: invokestatic 169	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   475: astore 8
    //   477: aload_0
    //   478: astore 6
    //   480: aload_1
    //   481: astore 7
    //   483: ldc 78
    //   485: ldc 171
    //   487: iconst_1
    //   488: anewarray 4	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: aload 10
    //   495: invokevirtual 172	java/lang/Object:toString	()Ljava/lang/String;
    //   498: aastore
    //   499: invokestatic 174	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: aload_0
    //   503: astore 6
    //   505: aload_1
    //   506: astore 7
    //   508: aload 10
    //   510: invokevirtual 177	android/graphics/Bitmap:recycle	()V
    //   513: sipush 16005
    //   516: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   519: aload 8
    //   521: areturn
    //   522: sipush 16005
    //   525: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload 10
    //   530: areturn
    //   531: astore 8
    //   533: aconst_null
    //   534: astore_0
    //   535: ldc 78
    //   537: ldc 179
    //   539: iconst_2
    //   540: anewarray 4	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload 8
    //   547: invokevirtual 182	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   550: aastore
    //   551: dup
    //   552: iconst_1
    //   553: aload 9
    //   555: aastore
    //   556: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   559: aload_1
    //   560: ifnull +7 -> 567
    //   563: aload_1
    //   564: invokevirtual 139	java/nio/channels/FileChannel:close	()V
    //   567: aload_0
    //   568: ifnull +7 -> 575
    //   571: aload_0
    //   572: invokevirtual 140	java/io/FileInputStream:close	()V
    //   575: sipush 16005
    //   578: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   581: aconst_null
    //   582: areturn
    //   583: astore 7
    //   585: aconst_null
    //   586: astore_0
    //   587: aload 6
    //   589: astore_1
    //   590: ldc 78
    //   592: ldc 184
    //   594: iconst_2
    //   595: anewarray 4	java/lang/Object
    //   598: dup
    //   599: iconst_0
    //   600: aload 7
    //   602: invokevirtual 185	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: aload 9
    //   610: aastore
    //   611: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: goto -55 -> 559
    //   617: astore_0
    //   618: goto -43 -> 575
    //   621: astore 7
    //   623: goto -33 -> 590
    //   626: astore 7
    //   628: aconst_null
    //   629: astore_1
    //   630: aload 6
    //   632: astore_0
    //   633: goto -43 -> 590
    //   636: astore 8
    //   638: aload 6
    //   640: astore_1
    //   641: goto -106 -> 535
    //   644: astore 8
    //   646: aconst_null
    //   647: astore_1
    //   648: aload 7
    //   650: astore_0
    //   651: goto -116 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	paramString1	java.lang.String
    //   0	654	1	paramString2	java.lang.String
    //   116	260	2	i	int
    //   58	395	3	bool	boolean
    //   278	27	4	l	long
    //   60	579	6	localObject1	Object
    //   66	441	7	localObject2	Object
    //   583	18	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   621	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   626	23	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   63	457	8	localObject3	Object
    //   531	15	8	localException1	java.lang.Exception
    //   636	1	8	localException2	java.lang.Exception
    //   644	1	8	localException3	java.lang.Exception
    //   55	554	9	str	java.lang.String
    //   248	281	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   70	103	531	java/lang/Exception
    //   111	117	531	java/lang/Exception
    //   133	156	531	java/lang/Exception
    //   164	174	531	java/lang/Exception
    //   70	103	583	java/lang/OutOfMemoryError
    //   111	117	583	java/lang/OutOfMemoryError
    //   133	156	583	java/lang/OutOfMemoryError
    //   164	174	583	java/lang/OutOfMemoryError
    //   563	567	617	java/lang/Exception
    //   571	575	617	java/lang/Exception
    //   181	187	621	java/lang/OutOfMemoryError
    //   194	201	621	java/lang/OutOfMemoryError
    //   208	216	621	java/lang/OutOfMemoryError
    //   223	230	621	java/lang/OutOfMemoryError
    //   243	250	621	java/lang/OutOfMemoryError
    //   257	265	621	java/lang/OutOfMemoryError
    //   272	280	621	java/lang/OutOfMemoryError
    //   294	325	621	java/lang/OutOfMemoryError
    //   332	337	621	java/lang/OutOfMemoryError
    //   344	348	621	java/lang/OutOfMemoryError
    //   365	395	621	java/lang/OutOfMemoryError
    //   402	407	621	java/lang/OutOfMemoryError
    //   413	417	626	java/lang/OutOfMemoryError
    //   427	439	626	java/lang/OutOfMemoryError
    //   445	452	626	java/lang/OutOfMemoryError
    //   462	477	626	java/lang/OutOfMemoryError
    //   483	502	626	java/lang/OutOfMemoryError
    //   508	513	626	java/lang/OutOfMemoryError
    //   181	187	636	java/lang/Exception
    //   194	201	636	java/lang/Exception
    //   208	216	636	java/lang/Exception
    //   223	230	636	java/lang/Exception
    //   243	250	636	java/lang/Exception
    //   257	265	636	java/lang/Exception
    //   272	280	636	java/lang/Exception
    //   294	325	636	java/lang/Exception
    //   332	337	636	java/lang/Exception
    //   344	348	636	java/lang/Exception
    //   365	395	636	java/lang/Exception
    //   402	407	636	java/lang/Exception
    //   413	417	644	java/lang/Exception
    //   427	439	644	java/lang/Exception
    //   445	452	644	java/lang/Exception
    //   462	477	644	java/lang/Exception
    //   483	502	644	java/lang/Exception
    //   508	513	644	java/lang/Exception
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    AppMethodBeat.i(16004);
    if ((paramContext == null) || (paramBitmap == null))
    {
      AppMethodBeat.o(16004);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      int i = paramContext.getResources().getDimensionPixelSize(17104902) - paramContext.getResources().getDimensionPixelSize(2131428575);
      paramContext = d.a(d.a(paramBitmap, i, i, false, false), false, paramContext.getResources().getDimensionPixelSize(2131428574));
      AppMethodBeat.o(16004);
      return paramContext;
    }
    AppMethodBeat.o(16004);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.a
 * JD-Core Version:    0.7.0.1
 */