package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;

public final class o
{
  /* Error */
  public static int a(java.util.zip.ZipInputStream paramZipInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 16384
    //   8: newarray byte
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 27	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +306 -> 324
    //   21: aload_3
    //   22: invokevirtual 33	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   25: astore 4
    //   27: aload 4
    //   29: ldc 35
    //   31: invokevirtual 41	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   34: ifne -22 -> 12
    //   37: aload 4
    //   39: ldc 43
    //   41: invokevirtual 41	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifne -32 -> 12
    //   47: aload_3
    //   48: invokevirtual 47	java/util/zip/ZipEntry:isDirectory	()Z
    //   51: ifeq +78 -> 129
    //   54: aload 4
    //   56: iconst_0
    //   57: aload 4
    //   59: invokevirtual 51	java/lang/String:length	()I
    //   62: iconst_1
    //   63: isub
    //   64: invokevirtual 55	java/lang/String:substring	(II)Ljava/lang/String;
    //   67: astore_3
    //   68: new 57	com/tencent/mm/vfs/q
    //   71: dup
    //   72: new 59	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 69
    //   85: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 75	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 78	com/tencent/mm/vfs/q:ifL	()Z
    //   101: pop
    //   102: goto -90 -> 12
    //   105: astore_1
    //   106: ldc 80
    //   108: aload_1
    //   109: ldc 82
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   122: ldc 15
    //   124: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_m1
    //   128: ireturn
    //   129: new 57	com/tencent/mm/vfs/q
    //   132: dup
    //   133: new 59	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 69
    //   146: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 4
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 75	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   160: astore 5
    //   162: aload 5
    //   164: invokevirtual 101	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   167: invokevirtual 78	com/tencent/mm/vfs/q:ifL	()Z
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 104	com/tencent/mm/vfs/q:ifM	()Z
    //   176: pop
    //   177: aconst_null
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload 5
    //   184: invokestatic 110	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   187: astore 5
    //   189: aload 5
    //   191: astore_3
    //   192: aload 5
    //   194: astore 4
    //   196: aload_0
    //   197: aload 6
    //   199: invokevirtual 114	java/util/zip/ZipInputStream:read	([B)I
    //   202: istore_2
    //   203: iload_2
    //   204: iconst_m1
    //   205: if_icmpeq +86 -> 291
    //   208: aload 5
    //   210: astore_3
    //   211: aload 5
    //   213: astore 4
    //   215: aload 5
    //   217: aload 6
    //   219: iconst_0
    //   220: iload_2
    //   221: invokevirtual 120	java/io/OutputStream:write	([BII)V
    //   224: aload 5
    //   226: astore_3
    //   227: aload 5
    //   229: astore 4
    //   231: aload 5
    //   233: invokevirtual 123	java/io/OutputStream:flush	()V
    //   236: goto -47 -> 189
    //   239: astore_1
    //   240: aload_3
    //   241: astore 4
    //   243: ldc 15
    //   245: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_3
    //   249: astore 4
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: aload 4
    //   256: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   259: ldc 15
    //   261: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: ldc 80
    //   269: aload_1
    //   270: ldc 82
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload_0
    //   280: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   283: ldc 15
    //   285: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: bipush 254
    //   290: ireturn
    //   291: aload 5
    //   293: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   296: goto -284 -> 12
    //   299: astore_1
    //   300: ldc 80
    //   302: aload_1
    //   303: ldc 82
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_0
    //   313: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   316: ldc 15
    //   318: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: bipush 253
    //   323: ireturn
    //   324: aload_0
    //   325: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   328: ldc 15
    //   330: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_1
    //   336: aload_0
    //   337: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   340: ldc 15
    //   342: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: aload_1
    //   346: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramZipInputStream	java.util.zip.ZipInputStream
    //   0	347	1	paramString	String
    //   202	19	2	i	int
    //   16	233	3	localObject1	Object
    //   25	230	4	localObject2	Object
    //   160	132	5	localObject3	Object
    //   10	208	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	12	105	java/io/FileNotFoundException
    //   12	17	105	java/io/FileNotFoundException
    //   21	102	105	java/io/FileNotFoundException
    //   129	177	105	java/io/FileNotFoundException
    //   254	266	105	java/io/FileNotFoundException
    //   291	296	105	java/io/FileNotFoundException
    //   182	189	239	java/lang/Exception
    //   196	203	239	java/lang/Exception
    //   215	224	239	java/lang/Exception
    //   231	236	239	java/lang/Exception
    //   182	189	253	finally
    //   196	203	253	finally
    //   215	224	253	finally
    //   231	236	253	finally
    //   243	248	253	finally
    //   251	253	253	finally
    //   5	12	266	java/io/IOException
    //   12	17	266	java/io/IOException
    //   21	102	266	java/io/IOException
    //   129	177	266	java/io/IOException
    //   254	266	266	java/io/IOException
    //   291	296	266	java/io/IOException
    //   5	12	299	java/lang/OutOfMemoryError
    //   12	17	299	java/lang/OutOfMemoryError
    //   21	102	299	java/lang/OutOfMemoryError
    //   129	177	299	java/lang/OutOfMemoryError
    //   254	266	299	java/lang/OutOfMemoryError
    //   291	296	299	java/lang/OutOfMemoryError
    //   5	12	335	finally
    //   12	17	335	finally
    //   21	102	335	finally
    //   106	118	335	finally
    //   129	177	335	finally
    //   254	266	335	finally
    //   267	279	335	finally
    //   291	296	335	finally
    //   300	312	335	finally
  }
  
  /* Error */
  public static m a(String paramString1, com.tencent.mm.plugin.appbrand.ac.i<java.util.Map<String, ByteBuffer>> parami, String paramString2, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 128
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 130	java/util/HashMap
    //   8: dup
    //   9: invokespecial 131	java/util/HashMap:<init>	()V
    //   12: astore 12
    //   14: aconst_null
    //   15: astore 10
    //   17: new 23	java/util/zip/ZipInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokestatic 135	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: invokespecial 138	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_0
    //   29: sipush 16384
    //   32: newarray byte
    //   34: astore 14
    //   36: aload_0
    //   37: invokevirtual 27	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   40: astore 10
    //   42: aload 10
    //   44: ifnull +307 -> 351
    //   47: aload 10
    //   49: invokevirtual 33	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   52: astore 13
    //   54: aload 13
    //   56: ldc 35
    //   58: invokevirtual 41	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: ifne -25 -> 36
    //   64: aload 13
    //   66: ldc 43
    //   68: invokevirtual 41	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   71: ifne -35 -> 36
    //   74: aload_2
    //   75: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   78: ifne +12 -> 90
    //   81: aload 13
    //   83: aload_2
    //   84: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifeq -51 -> 36
    //   90: aload 10
    //   92: invokevirtual 47	java/util/zip/ZipEntry:isDirectory	()Z
    //   95: ifne -59 -> 36
    //   98: new 148	java/io/ByteArrayOutputStream
    //   101: dup
    //   102: invokespecial 149	java/io/ByteArrayOutputStream:<init>	()V
    //   105: astore 11
    //   107: aconst_null
    //   108: astore 10
    //   110: aload_0
    //   111: aload 14
    //   113: invokevirtual 114	java/util/zip/ZipInputStream:read	([B)I
    //   116: istore 7
    //   118: iload 7
    //   120: iconst_m1
    //   121: if_icmpeq +69 -> 190
    //   124: aload 11
    //   126: aload 14
    //   128: iconst_0
    //   129: iload 7
    //   131: invokevirtual 150	java/io/ByteArrayOutputStream:write	([BII)V
    //   134: goto -24 -> 110
    //   137: astore_2
    //   138: ldc 128
    //   140: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +278 -> 425
    //   150: aload 11
    //   152: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   155: ldc 128
    //   157: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: ldc 80
    //   165: aload_1
    //   166: ldc 155
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: getstatic 161	com/tencent/mm/plugin/appbrand/appstorage/m:nMS	Lcom/tencent/mm/plugin/appbrand/appstorage/m;
    //   178: astore_1
    //   179: aload_0
    //   180: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   183: ldc 128
    //   185: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_1
    //   189: areturn
    //   190: aload_2
    //   191: invokestatic 142	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   194: ifne +178 -> 372
    //   197: aload 13
    //   199: aload_2
    //   200: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   203: ifeq +169 -> 372
    //   206: lload 5
    //   208: lstore 8
    //   210: lload 5
    //   212: ldc2_w 162
    //   215: lcmp
    //   216: ifne +13 -> 229
    //   219: aload 11
    //   221: invokevirtual 166	java/io/ByteArrayOutputStream:size	()I
    //   224: i2l
    //   225: lload_3
    //   226: lsub
    //   227: lstore 8
    //   229: lload_3
    //   230: l2i
    //   231: ifge +36 -> 267
    //   234: lload_3
    //   235: aload 11
    //   237: invokevirtual 166	java/io/ByteArrayOutputStream:size	()I
    //   240: iconst_1
    //   241: isub
    //   242: i2l
    //   243: lcmp
    //   244: ifle +23 -> 267
    //   247: getstatic 169	com/tencent/mm/plugin/appbrand/appstorage/m:nNc	Lcom/tencent/mm/plugin/appbrand/appstorage/m;
    //   250: astore_1
    //   251: aload 11
    //   253: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   256: aload_0
    //   257: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   260: ldc 128
    //   262: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_1
    //   266: areturn
    //   267: lload 8
    //   269: l2i
    //   270: ifle +17 -> 287
    //   273: lload 8
    //   275: aload 11
    //   277: invokevirtual 166	java/io/ByteArrayOutputStream:size	()I
    //   280: i2l
    //   281: lload_3
    //   282: lsub
    //   283: lcmp
    //   284: ifle +23 -> 307
    //   287: getstatic 172	com/tencent/mm/plugin/appbrand/appstorage/m:nNd	Lcom/tencent/mm/plugin/appbrand/appstorage/m;
    //   290: astore_1
    //   291: aload 11
    //   293: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   296: aload_0
    //   297: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   300: ldc 128
    //   302: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_1
    //   306: areturn
    //   307: lload 8
    //   309: l2i
    //   310: istore 7
    //   312: iload 7
    //   314: newarray byte
    //   316: astore_2
    //   317: aload 11
    //   319: invokevirtual 176	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   322: lload_3
    //   323: l2i
    //   324: aload_2
    //   325: iconst_0
    //   326: lload 8
    //   328: l2i
    //   329: invokestatic 182	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   332: aload 12
    //   334: aload 13
    //   336: aload_2
    //   337: invokestatic 188	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   340: invokeinterface 194 3 0
    //   345: pop
    //   346: aload 11
    //   348: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   351: aload_0
    //   352: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   355: aload_1
    //   356: aload 12
    //   358: putfield 200	com/tencent/mm/plugin/appbrand/ac/i:value	Ljava/lang/Object;
    //   361: getstatic 203	com/tencent/mm/plugin/appbrand/appstorage/m:nMR	Lcom/tencent/mm/plugin/appbrand/appstorage/m;
    //   364: astore_0
    //   365: ldc 128
    //   367: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: aload_0
    //   371: areturn
    //   372: aload 12
    //   374: aload 13
    //   376: aload 11
    //   378: invokevirtual 176	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   381: invokestatic 188	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   384: invokeinterface 194 3 0
    //   389: pop
    //   390: aload 11
    //   392: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   395: goto -359 -> 36
    //   398: astore_2
    //   399: aload_0
    //   400: astore_1
    //   401: aload_2
    //   402: astore_0
    //   403: aload_1
    //   404: invokestatic 94	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   407: ldc 128
    //   409: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_0
    //   413: athrow
    //   414: astore 10
    //   416: aload_2
    //   417: aload 10
    //   419: invokevirtual 207	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   422: goto -267 -> 155
    //   425: aload 11
    //   427: invokevirtual 153	java/io/ByteArrayOutputStream:close	()V
    //   430: goto -275 -> 155
    //   433: astore_0
    //   434: aconst_null
    //   435: astore_1
    //   436: goto -33 -> 403
    //   439: astore_2
    //   440: aload_0
    //   441: astore_1
    //   442: aload_2
    //   443: astore_0
    //   444: goto -41 -> 403
    //   447: astore_1
    //   448: aload 10
    //   450: astore_0
    //   451: goto -288 -> 163
    //   454: astore_1
    //   455: aload 10
    //   457: astore_2
    //   458: goto -312 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramString1	String
    //   0	461	1	parami	com.tencent.mm.plugin.appbrand.ac.i<java.util.Map<String, ByteBuffer>>
    //   0	461	2	paramString2	String
    //   0	461	3	paramLong1	long
    //   0	461	5	paramLong2	long
    //   116	197	7	i	int
    //   208	119	8	l	long
    //   15	94	10	localZipEntry	java.util.zip.ZipEntry
    //   414	42	10	localThrowable	java.lang.Throwable
    //   105	321	11	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   12	361	12	localHashMap	java.util.HashMap
    //   52	323	13	str	String
    //   34	93	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   110	118	137	java/lang/Throwable
    //   124	134	137	java/lang/Throwable
    //   190	206	137	java/lang/Throwable
    //   219	229	137	java/lang/Throwable
    //   234	251	137	java/lang/Throwable
    //   273	287	137	java/lang/Throwable
    //   287	291	137	java/lang/Throwable
    //   312	346	137	java/lang/Throwable
    //   372	390	137	java/lang/Throwable
    //   138	145	145	finally
    //   29	36	162	java/lang/Exception
    //   36	42	162	java/lang/Exception
    //   47	90	162	java/lang/Exception
    //   90	107	162	java/lang/Exception
    //   150	155	162	java/lang/Exception
    //   155	162	162	java/lang/Exception
    //   251	256	162	java/lang/Exception
    //   291	296	162	java/lang/Exception
    //   346	351	162	java/lang/Exception
    //   390	395	162	java/lang/Exception
    //   416	422	162	java/lang/Exception
    //   425	430	162	java/lang/Exception
    //   29	36	398	finally
    //   36	42	398	finally
    //   47	90	398	finally
    //   90	107	398	finally
    //   150	155	398	finally
    //   155	162	398	finally
    //   251	256	398	finally
    //   291	296	398	finally
    //   346	351	398	finally
    //   390	395	398	finally
    //   416	422	398	finally
    //   425	430	398	finally
    //   150	155	414	java/lang/Throwable
    //   17	29	433	finally
    //   163	179	439	finally
    //   17	29	447	java/lang/Exception
    //   110	118	454	finally
    //   124	134	454	finally
    //   190	206	454	finally
    //   219	229	454	finally
    //   234	251	454	finally
    //   273	287	454	finally
    //   287	291	454	finally
    //   312	346	454	finally
    //   372	390	454	finally
  }
  
  /* Error */
  static ByteBuffer a(q paramq, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 213
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: invokevirtual 216	com/tencent/mm/vfs/q:ifE	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 219	com/tencent/mm/vfs/q:ifH	()Z
    //   20: ifne +15 -> 35
    //   23: iconst_0
    //   24: invokestatic 223	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   27: astore_0
    //   28: ldc 213
    //   30: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 226	com/tencent/mm/vfs/q:length	()J
    //   39: l2i
    //   40: istore 5
    //   42: iload 5
    //   44: ifge +15 -> 59
    //   47: iconst_0
    //   48: invokestatic 223	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   51: astore_0
    //   52: ldc 213
    //   54: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: areturn
    //   59: lload_1
    //   60: lload_3
    //   61: ladd
    //   62: lconst_1
    //   63: lsub
    //   64: iload 5
    //   66: iconst_1
    //   67: isub
    //   68: i2l
    //   69: lcmp
    //   70: ifle +15 -> 85
    //   73: iconst_0
    //   74: invokestatic 223	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   77: astore_0
    //   78: ldc 213
    //   80: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: areturn
    //   85: iload 5
    //   87: invokestatic 223	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   90: astore 10
    //   92: iload 5
    //   94: i2l
    //   95: lstore 6
    //   97: lload_3
    //   98: lconst_0
    //   99: lcmp
    //   100: iflt +253 -> 353
    //   103: aload_0
    //   104: invokevirtual 229	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   107: iconst_0
    //   108: invokestatic 233	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   111: astore 11
    //   113: aconst_null
    //   114: astore 9
    //   116: aload 11
    //   118: invokevirtual 239	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   121: aload 10
    //   123: invokevirtual 244	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   126: pop
    //   127: aload 10
    //   129: invokevirtual 248	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   132: pop
    //   133: lload_1
    //   134: lconst_0
    //   135: lcmp
    //   136: ifne +29 -> 165
    //   139: lload_3
    //   140: iload 5
    //   142: i2l
    //   143: lcmp
    //   144: ifne +21 -> 165
    //   147: aload 11
    //   149: ifnull +8 -> 157
    //   152: aload 11
    //   154: invokevirtual 249	java/io/RandomAccessFile:close	()V
    //   157: ldc 213
    //   159: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload 10
    //   164: areturn
    //   165: lload_3
    //   166: l2i
    //   167: istore 5
    //   169: iload 5
    //   171: newarray byte
    //   173: astore 8
    //   175: aload 10
    //   177: lload_1
    //   178: l2i
    //   179: invokevirtual 253	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   182: pop
    //   183: aload 10
    //   185: aload 8
    //   187: iconst_0
    //   188: lload_3
    //   189: l2i
    //   190: invokevirtual 257	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   193: pop
    //   194: aload 8
    //   196: invokestatic 188	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   199: astore 8
    //   201: aload 11
    //   203: ifnull +8 -> 211
    //   206: aload 11
    //   208: invokevirtual 249	java/io/RandomAccessFile:close	()V
    //   211: ldc 213
    //   213: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload 8
    //   218: areturn
    //   219: astore 9
    //   221: ldc 213
    //   223: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 9
    //   228: athrow
    //   229: astore 8
    //   231: aload 11
    //   233: ifnull +13 -> 246
    //   236: aload 9
    //   238: ifnull +102 -> 340
    //   241: aload 11
    //   243: invokevirtual 249	java/io/RandomAccessFile:close	()V
    //   246: ldc 213
    //   248: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload 8
    //   253: athrow
    //   254: astore_0
    //   255: ldc 80
    //   257: aload_0
    //   258: ldc_w 259
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload 10
    //   270: invokestatic 265	com/tencent/luggage/k/a:f	(Ljava/nio/ByteBuffer;)V
    //   273: iconst_0
    //   274: invokestatic 223	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   277: astore_0
    //   278: ldc 213
    //   280: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: aload_0
    //   284: areturn
    //   285: astore 11
    //   287: aload 9
    //   289: aload 11
    //   291: invokevirtual 207	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   294: goto -48 -> 246
    //   297: astore 8
    //   299: ldc 80
    //   301: ldc_w 267
    //   304: iconst_2
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload_0
    //   311: invokevirtual 226	com/tencent/mm/vfs/q:length	()J
    //   314: invokestatic 273	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload 10
    //   322: invokevirtual 276	java/nio/ByteBuffer:capacity	()I
    //   325: invokestatic 281	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: aastore
    //   329: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload 10
    //   334: invokestatic 265	com/tencent/luggage/k/a:f	(Ljava/nio/ByteBuffer;)V
    //   337: goto -64 -> 273
    //   340: aload 11
    //   342: invokevirtual 249	java/io/RandomAccessFile:close	()V
    //   345: goto -99 -> 246
    //   348: astore 8
    //   350: goto -119 -> 231
    //   353: lload 6
    //   355: lstore_3
    //   356: goto -253 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramq	q
    //   0	359	1	paramLong1	long
    //   0	359	3	paramLong2	long
    //   40	130	5	i	int
    //   95	259	6	l	long
    //   173	44	8	localObject1	Object
    //   229	23	8	localObject2	Object
    //   297	1	8	localBufferOverflowException	java.nio.BufferOverflowException
    //   348	1	8	localObject3	Object
    //   114	1	9	localObject4	Object
    //   219	69	9	localThrowable1	java.lang.Throwable
    //   90	243	10	localByteBuffer	ByteBuffer
    //   111	131	11	localRandomAccessFile	java.io.RandomAccessFile
    //   285	56	11	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   116	133	219	java/lang/Throwable
    //   169	201	219	java/lang/Throwable
    //   221	229	229	finally
    //   103	113	254	java/io/IOException
    //   152	157	254	java/io/IOException
    //   206	211	254	java/io/IOException
    //   241	246	254	java/io/IOException
    //   246	254	254	java/io/IOException
    //   287	294	254	java/io/IOException
    //   340	345	254	java/io/IOException
    //   241	246	285	java/lang/Throwable
    //   103	113	297	java/nio/BufferOverflowException
    //   152	157	297	java/nio/BufferOverflowException
    //   206	211	297	java/nio/BufferOverflowException
    //   241	246	297	java/nio/BufferOverflowException
    //   246	254	297	java/nio/BufferOverflowException
    //   287	294	297	java/nio/BufferOverflowException
    //   340	345	297	java/nio/BufferOverflowException
    //   116	133	348	finally
    //   169	201	348	finally
  }
  
  static void a(q paramq, s params)
  {
    AppMethodBeat.i(175571);
    paramq = paramq.a(params);
    if (paramq != null)
    {
      int j = paramq.length;
      int i = 0;
      while (i < j)
      {
        q localq = paramq[i];
        if (localq.isDirectory()) {
          a(localq, params);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(175571);
  }
  
  public static String adR(String paramString)
  {
    AppMethodBeat.i(134336);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134336);
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(134336);
    return paramString;
  }
  
  public static String adS(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(134337);
    Log.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134337);
      return "";
    }
    paramString = paramString.trim();
    if (!paramString.startsWith("/"))
    {
      paramString = "/".concat(String.valueOf(paramString));
      AppMethodBeat.o(134337);
      return paramString;
    }
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = "/" + paramString.substring(i);
    AppMethodBeat.o(134337);
    return paramString;
  }
  
  public static String adT(String paramString)
  {
    AppMethodBeat.i(224852);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(224852);
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(224852);
    return paramString;
  }
  
  public static long p(q paramq)
  {
    long l = 0L;
    AppMethodBeat.i(175568);
    if (paramq == null)
    {
      AppMethodBeat.o(175568);
      return -1L;
    }
    paramq = paramq.ifJ();
    if (paramq == null)
    {
      AppMethodBeat.o(175568);
      return 0L;
    }
    int j = paramq.length;
    int i = 0;
    if (i < j)
    {
      q localq = paramq[i];
      if (localq.ifH()) {}
      for (l += localq.length();; l += p(localq))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(175568);
    return l;
  }
  
  public static long q(q paramq)
  {
    long l = 0L;
    AppMethodBeat.i(134329);
    if (paramq == null)
    {
      AppMethodBeat.o(134329);
      return -1L;
    }
    paramq = paramq.ifJ();
    if (paramq == null)
    {
      AppMethodBeat.o(134329);
      return 0L;
    }
    int j = paramq.length;
    int i = 0;
    if (i < j)
    {
      q localq = paramq[i];
      if (localq.ifH()) {}
      for (l += localq.length();; l += q(localq))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(134329);
    return l;
  }
  
  static ByteBuffer r(q paramq)
  {
    AppMethodBeat.i(175570);
    paramq = a(paramq, 0L, -1L);
    AppMethodBeat.o(175570);
    return paramq;
  }
  
  public static void s(q paramq)
  {
    AppMethodBeat.i(175572);
    if ((paramq == null) || (!paramq.isDirectory()))
    {
      AppMethodBeat.o(175572);
      return;
    }
    if (paramq.ifE())
    {
      q[] arrayOfq = paramq.ifJ();
      if (arrayOfq != null)
      {
        int j = arrayOfq.length;
        int i = 0;
        while (i < j)
        {
          q localq = arrayOfq[i];
          if (localq.isDirectory()) {
            s(localq);
          }
          localq.cFq();
          i += 1;
        }
      }
      paramq.cFq();
    }
    AppMethodBeat.o(175572);
  }
  
  public static boolean t(q paramq)
  {
    AppMethodBeat.i(175573);
    if (paramq == null)
    {
      paramq = new NullPointerException("file should not be NULL");
      AppMethodBeat.o(175573);
      throw paramq;
    }
    if (!paramq.ifE())
    {
      AppMethodBeat.o(175573);
      return false;
    }
    try
    {
      FileStructStat localFileStructStat = new FileStructStat();
      if (FileStat.b(paramq.bOF(), localFileStructStat) == 0)
      {
        Log.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { paramq.bOF(), Integer.valueOf(localFileStructStat.st_mode) });
        boolean bool = localFileStructStat.isSymLink();
        AppMethodBeat.o(175573);
        return bool;
      }
    }
    catch (Exception paramq)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", paramq, "", new Object[0]);
      AppMethodBeat.o(175573);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */