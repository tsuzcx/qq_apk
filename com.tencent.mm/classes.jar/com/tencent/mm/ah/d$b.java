package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;

public final class d$b
{
  static boolean remove(String paramString)
  {
    AppMethodBeat.i(77877);
    e.deleteFile(paramString + ".bm");
    e.deleteFile(paramString);
    AppMethodBeat.o(77877);
    return true;
  }
  
  /* Error */
  public static boolean rf(String paramString)
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 49	com/tencent/mm/ah/d$b:rg	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +11 -> 24
    //   16: aload 4
    //   18: invokevirtual 55	android/graphics/Bitmap:isRecycled	()Z
    //   21: ifeq +10 -> 31
    //   24: ldc 45
    //   26: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aconst_null
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: iconst_0
    //   37: invokestatic 59	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   40: astore_3
    //   41: aload_3
    //   42: astore_1
    //   43: aload_3
    //   44: astore_2
    //   45: aload 4
    //   47: getstatic 65	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   50: bipush 100
    //   52: aload_3
    //   53: invokevirtual 69	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   56: pop
    //   57: aload_3
    //   58: astore_1
    //   59: aload_3
    //   60: astore_2
    //   61: new 18	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   68: aload_0
    //   69: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 28
    //   74: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 37	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   83: pop
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 74	java/io/OutputStream:close	()V
    //   92: ldc 45
    //   94: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_3
    //   100: aload_1
    //   101: astore_2
    //   102: ldc 76
    //   104: aload_3
    //   105: ldc 78
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: aastore
    //   115: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 74	java/io/OutputStream:close	()V
    //   126: ldc 45
    //   128: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 74	java/io/OutputStream:close	()V
    //   142: ldc 45
    //   144: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: goto -58 -> 92
    //   153: astore_0
    //   154: goto -28 -> 126
    //   157: astore_1
    //   158: goto -16 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   34	89	1	localObject1	Object
    //   157	1	1	localIOException1	java.io.IOException
    //   32	107	2	localObject2	Object
    //   40	49	3	localOutputStream	java.io.OutputStream
    //   99	6	3	localIOException2	java.io.IOException
    //   9	37	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   35	41	99	java/io/IOException
    //   45	57	99	java/io/IOException
    //   61	84	99	java/io/IOException
    //   35	41	133	finally
    //   45	57	133	finally
    //   61	84	133	finally
    //   102	118	133	finally
    //   88	92	149	java/io/IOException
    //   122	126	153	java/io/IOException
    //   138	142	157	java/io/IOException
  }
  
  /* Error */
  public static android.graphics.Bitmap rg(String paramString)
  {
    // Byte code:
    //   0: ldc 89
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 18	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 28
    //   18: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore 10
    //   26: iconst_1
    //   27: istore_2
    //   28: aconst_null
    //   29: astore 7
    //   31: aconst_null
    //   32: astore 9
    //   34: aconst_null
    //   35: astore 8
    //   37: aconst_null
    //   38: astore 6
    //   40: aload 10
    //   42: invokestatic 92	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   45: ifne +26 -> 71
    //   48: ldc 76
    //   50: ldc 94
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload 10
    //   60: aastore
    //   61: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: ldc 89
    //   66: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 10
    //   73: invokestatic 102	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   76: l2i
    //   77: istore_1
    //   78: iload_1
    //   79: ifle +15 -> 94
    //   82: iload_1
    //   83: ldc 103
    //   85: if_icmpeq +44 -> 129
    //   88: iload_1
    //   89: ldc 104
    //   91: if_icmpeq +38 -> 129
    //   94: aload_0
    //   95: invokestatic 106	com/tencent/mm/ah/d$b:remove	(Ljava/lang/String;)Z
    //   98: pop
    //   99: ldc 76
    //   101: ldc 108
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: iload_1
    //   110: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload 10
    //   118: aastore
    //   119: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: ldc 89
    //   124: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aconst_null
    //   128: areturn
    //   129: aload 10
    //   131: invokestatic 121	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   134: astore 5
    //   136: aload 9
    //   138: astore 6
    //   140: aload 8
    //   142: astore 7
    //   144: aload 5
    //   146: invokestatic 127	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
    //   149: astore 8
    //   151: aload 8
    //   153: astore 6
    //   155: aload 8
    //   157: astore 7
    //   159: ldc 103
    //   161: invokestatic 133	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   164: astore 9
    //   166: aload 8
    //   168: astore 6
    //   170: aload 8
    //   172: astore 7
    //   174: aload 8
    //   176: aload 9
    //   178: invokeinterface 139 2 0
    //   183: pop
    //   184: aload 8
    //   186: astore 6
    //   188: aload 8
    //   190: astore 7
    //   192: aload 9
    //   194: iconst_0
    //   195: invokevirtual 143	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   198: pop
    //   199: iload_1
    //   200: ldc 104
    //   202: if_icmpne +145 -> 347
    //   205: aload 8
    //   207: astore 6
    //   209: aload 8
    //   211: astore 7
    //   213: bipush 16
    //   215: invokestatic 133	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   218: astore 11
    //   220: aload 8
    //   222: astore 6
    //   224: aload 8
    //   226: astore 7
    //   228: aload 8
    //   230: aload 11
    //   232: invokeinterface 139 2 0
    //   237: pop
    //   238: aload 8
    //   240: astore 6
    //   242: aload 8
    //   244: astore 7
    //   246: aload 11
    //   248: iconst_0
    //   249: invokevirtual 147	java/nio/ByteBuffer:getLong	(I)J
    //   252: lstore_3
    //   253: lload_3
    //   254: lconst_1
    //   255: lcmp
    //   256: ifeq +89 -> 345
    //   259: aload 8
    //   261: astore 6
    //   263: aload 8
    //   265: astore 7
    //   267: ldc 76
    //   269: ldc 149
    //   271: iconst_3
    //   272: anewarray 4	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: lload_3
    //   278: invokestatic 154	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: iload_1
    //   285: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: aload 10
    //   293: aastore
    //   294: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: aload 8
    //   299: astore 6
    //   301: aload 8
    //   303: astore 7
    //   305: aload 8
    //   307: invokeinterface 155 1 0
    //   312: aload 8
    //   314: astore 6
    //   316: aload 8
    //   318: astore 7
    //   320: aload 5
    //   322: invokevirtual 158	java/io/InputStream:close	()V
    //   325: aload 8
    //   327: astore 6
    //   329: aload 8
    //   331: astore 7
    //   333: aload_0
    //   334: invokestatic 106	com/tencent/mm/ah/d$b:remove	(Ljava/lang/String;)Z
    //   337: pop
    //   338: ldc 89
    //   340: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aconst_null
    //   344: areturn
    //   345: iconst_0
    //   346: istore_2
    //   347: aload 8
    //   349: astore 6
    //   351: aload 8
    //   353: astore 7
    //   355: ldc 76
    //   357: ldc 160
    //   359: iconst_3
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: iload_1
    //   366: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: iload_2
    //   373: invokestatic 165	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   376: aastore
    //   377: dup
    //   378: iconst_2
    //   379: aload 10
    //   381: aastore
    //   382: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: aload 8
    //   387: astore 6
    //   389: aload 8
    //   391: astore 7
    //   393: aload 8
    //   395: invokeinterface 155 1 0
    //   400: aload 5
    //   402: astore 6
    //   404: aload 5
    //   406: astore 7
    //   408: aload 5
    //   410: invokevirtual 158	java/io/InputStream:close	()V
    //   413: aconst_null
    //   414: astore 5
    //   416: aconst_null
    //   417: astore_0
    //   418: aload_0
    //   419: astore 6
    //   421: aload 5
    //   423: astore 7
    //   425: bipush 96
    //   427: bipush 96
    //   429: getstatic 171	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   432: invokestatic 175	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   435: astore 8
    //   437: aload_0
    //   438: astore 6
    //   440: aload 5
    //   442: astore 7
    //   444: aload 8
    //   446: aload 9
    //   448: invokevirtual 179	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   451: iload_2
    //   452: ifeq +71 -> 523
    //   455: aload_0
    //   456: astore 6
    //   458: aload 5
    //   460: astore 7
    //   462: aload 8
    //   464: bipush 9
    //   466: bipush 9
    //   468: bipush 78
    //   470: bipush 78
    //   472: invokestatic 182	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   475: astore 9
    //   477: aload_0
    //   478: astore 6
    //   480: aload 5
    //   482: astore 7
    //   484: ldc 76
    //   486: ldc 184
    //   488: iconst_1
    //   489: anewarray 4	java/lang/Object
    //   492: dup
    //   493: iconst_0
    //   494: aload 8
    //   496: invokevirtual 185	java/lang/Object:toString	()Ljava/lang/String;
    //   499: aastore
    //   500: invokestatic 187	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   503: aload_0
    //   504: astore 6
    //   506: aload 5
    //   508: astore 7
    //   510: aload 8
    //   512: invokevirtual 190	android/graphics/Bitmap:recycle	()V
    //   515: ldc 89
    //   517: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   520: aload 9
    //   522: areturn
    //   523: ldc 89
    //   525: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload 8
    //   530: areturn
    //   531: astore 7
    //   533: aconst_null
    //   534: astore 5
    //   536: aload 6
    //   538: astore_0
    //   539: aload 7
    //   541: astore 6
    //   543: ldc 76
    //   545: ldc 192
    //   547: iconst_2
    //   548: anewarray 4	java/lang/Object
    //   551: dup
    //   552: iconst_0
    //   553: aload 6
    //   555: invokevirtual 195	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   558: aastore
    //   559: dup
    //   560: iconst_1
    //   561: aload 10
    //   563: aastore
    //   564: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   567: aload_0
    //   568: ifnull +9 -> 577
    //   571: aload_0
    //   572: invokeinterface 155 1 0
    //   577: aload 5
    //   579: ifnull +8 -> 587
    //   582: aload 5
    //   584: invokevirtual 158	java/io/InputStream:close	()V
    //   587: ldc 89
    //   589: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   592: aconst_null
    //   593: areturn
    //   594: astore 6
    //   596: aconst_null
    //   597: astore 5
    //   599: aload 7
    //   601: astore_0
    //   602: aload 6
    //   604: astore 7
    //   606: ldc 76
    //   608: ldc 197
    //   610: iconst_2
    //   611: anewarray 4	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: aload 7
    //   618: invokevirtual 198	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   621: aastore
    //   622: dup
    //   623: iconst_1
    //   624: aload 10
    //   626: aastore
    //   627: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   630: goto -63 -> 567
    //   633: astore_0
    //   634: goto -47 -> 587
    //   637: astore 7
    //   639: aload 6
    //   641: astore_0
    //   642: goto -36 -> 606
    //   645: astore 7
    //   647: aconst_null
    //   648: astore_0
    //   649: aload 6
    //   651: astore 5
    //   653: goto -47 -> 606
    //   656: astore 6
    //   658: aload 7
    //   660: astore_0
    //   661: goto -118 -> 543
    //   664: astore 6
    //   666: aconst_null
    //   667: astore_0
    //   668: aload 7
    //   670: astore 5
    //   672: goto -129 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	paramString	String
    //   77	289	1	i	int
    //   27	425	2	bool	boolean
    //   252	26	3	l	long
    //   134	537	5	localObject1	Object
    //   38	516	6	localObject2	Object
    //   594	56	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   656	1	6	localException1	java.lang.Exception
    //   664	1	6	localException2	java.lang.Exception
    //   29	480	7	localObject3	Object
    //   531	69	7	localException3	java.lang.Exception
    //   604	13	7	localObject4	Object
    //   637	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   645	24	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   35	494	8	localObject5	Object
    //   32	489	9	localObject6	Object
    //   24	601	10	str	String
    //   218	29	11	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   40	64	531	java/lang/Exception
    //   71	78	531	java/lang/Exception
    //   94	122	531	java/lang/Exception
    //   129	136	531	java/lang/Exception
    //   40	64	594	java/lang/OutOfMemoryError
    //   71	78	594	java/lang/OutOfMemoryError
    //   94	122	594	java/lang/OutOfMemoryError
    //   129	136	594	java/lang/OutOfMemoryError
    //   571	577	633	java/lang/Exception
    //   582	587	633	java/lang/Exception
    //   144	151	637	java/lang/OutOfMemoryError
    //   159	166	637	java/lang/OutOfMemoryError
    //   174	184	637	java/lang/OutOfMemoryError
    //   192	199	637	java/lang/OutOfMemoryError
    //   213	220	637	java/lang/OutOfMemoryError
    //   228	238	637	java/lang/OutOfMemoryError
    //   246	253	637	java/lang/OutOfMemoryError
    //   267	297	637	java/lang/OutOfMemoryError
    //   305	312	637	java/lang/OutOfMemoryError
    //   320	325	637	java/lang/OutOfMemoryError
    //   333	338	637	java/lang/OutOfMemoryError
    //   355	385	637	java/lang/OutOfMemoryError
    //   393	400	637	java/lang/OutOfMemoryError
    //   408	413	645	java/lang/OutOfMemoryError
    //   425	437	645	java/lang/OutOfMemoryError
    //   444	451	645	java/lang/OutOfMemoryError
    //   462	477	645	java/lang/OutOfMemoryError
    //   484	503	645	java/lang/OutOfMemoryError
    //   510	515	645	java/lang/OutOfMemoryError
    //   144	151	656	java/lang/Exception
    //   159	166	656	java/lang/Exception
    //   174	184	656	java/lang/Exception
    //   192	199	656	java/lang/Exception
    //   213	220	656	java/lang/Exception
    //   228	238	656	java/lang/Exception
    //   246	253	656	java/lang/Exception
    //   267	297	656	java/lang/Exception
    //   305	312	656	java/lang/Exception
    //   320	325	656	java/lang/Exception
    //   333	338	656	java/lang/Exception
    //   355	385	656	java/lang/Exception
    //   393	400	656	java/lang/Exception
    //   408	413	664	java/lang/Exception
    //   425	437	664	java/lang/Exception
    //   444	451	664	java/lang/Exception
    //   462	477	664	java/lang/Exception
    //   484	503	664	java/lang/Exception
    //   510	515	664	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.d.b
 * JD-Core Version:    0.7.0.1
 */