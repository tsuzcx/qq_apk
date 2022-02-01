package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import java.nio.ByteBuffer;

public final class t
{
  public static String Ws(String paramString)
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
  
  public static String Wt(String paramString)
  {
    AppMethodBeat.i(370020);
    paramString = as(paramString, true);
    AppMethodBeat.o(370020);
    return paramString;
  }
  
  public static String Wu(String paramString)
  {
    AppMethodBeat.i(323288);
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(323288);
      return str;
    }
    int i = 0;
    while ((i < str.length()) && ('/' == str.charAt(i))) {
      i += 1;
    }
    paramString = str.substring(i);
    AppMethodBeat.o(323288);
    return paramString;
  }
  
  /* Error */
  public static int a(java.util.zip.ZipInputStream paramZipInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 16384
    //   8: newarray byte
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 72	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +306 -> 324
    //   21: aload_3
    //   22: invokevirtual 77	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   25: astore 4
    //   27: aload 4
    //   29: ldc 79
    //   31: invokevirtual 82	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   34: ifne -22 -> 12
    //   37: aload 4
    //   39: ldc 84
    //   41: invokevirtual 82	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifne -32 -> 12
    //   47: aload_3
    //   48: invokevirtual 88	java/util/zip/ZipEntry:isDirectory	()Z
    //   51: ifeq +78 -> 129
    //   54: aload 4
    //   56: iconst_0
    //   57: aload 4
    //   59: invokevirtual 28	java/lang/String:length	()I
    //   62: iconst_1
    //   63: isub
    //   64: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   67: astore_3
    //   68: new 93	com/tencent/mm/vfs/u
    //   71: dup
    //   72: new 95	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 105
    //   85: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 111	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 114	com/tencent/mm/vfs/u:jKY	()Z
    //   101: pop
    //   102: goto -90 -> 12
    //   105: astore_1
    //   106: ldc 116
    //   108: aload_1
    //   109: ldc 118
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   122: ldc 66
    //   124: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_m1
    //   128: ireturn
    //   129: new 93	com/tencent/mm/vfs/u
    //   132: dup
    //   133: new 95	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 105
    //   146: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 4
    //   151: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 111	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   160: astore 5
    //   162: aload 5
    //   164: invokevirtual 132	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   167: invokevirtual 114	com/tencent/mm/vfs/u:jKY	()Z
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 135	com/tencent/mm/vfs/u:jKZ	()Z
    //   176: pop
    //   177: aconst_null
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload 5
    //   184: invokestatic 141	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   187: astore 5
    //   189: aload 5
    //   191: astore_3
    //   192: aload 5
    //   194: astore 4
    //   196: aload_0
    //   197: aload 6
    //   199: invokevirtual 145	java/util/zip/ZipInputStream:read	([B)I
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
    //   221: invokevirtual 151	java/io/OutputStream:write	([BII)V
    //   224: aload 5
    //   226: astore_3
    //   227: aload 5
    //   229: astore 4
    //   231: aload 5
    //   233: invokevirtual 154	java/io/OutputStream:flush	()V
    //   236: goto -47 -> 189
    //   239: astore_1
    //   240: aload_3
    //   241: astore 4
    //   243: ldc 66
    //   245: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_3
    //   249: astore 4
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: aload 4
    //   256: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   259: ldc 66
    //   261: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: ldc 116
    //   269: aload_1
    //   270: ldc 118
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload_0
    //   280: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   283: ldc 66
    //   285: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: bipush 254
    //   290: ireturn
    //   291: aload 5
    //   293: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   296: goto -284 -> 12
    //   299: astore_1
    //   300: ldc 116
    //   302: aload_1
    //   303: ldc 118
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_0
    //   313: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   316: ldc 66
    //   318: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: bipush 253
    //   323: ireturn
    //   324: aload_0
    //   325: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   328: ldc 66
    //   330: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_1
    //   336: aload_0
    //   337: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   340: ldc 66
    //   342: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static r a(String paramString1, com.tencent.mm.plugin.appbrand.af.k<java.util.Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 158	java/util/HashMap
    //   8: dup
    //   9: invokespecial 159	java/util/HashMap:<init>	()V
    //   12: astore 12
    //   14: new 68	java/util/zip/ZipInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokestatic 163	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 166	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 10
    //   27: aload 10
    //   29: astore_0
    //   30: sipush 16384
    //   33: newarray byte
    //   35: astore 14
    //   37: aload 10
    //   39: astore_0
    //   40: aload 10
    //   42: invokevirtual 72	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   45: astore 11
    //   47: aload 11
    //   49: ifnull +338 -> 387
    //   52: aload 10
    //   54: astore_0
    //   55: aload 11
    //   57: invokevirtual 77	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   60: astore 13
    //   62: aload 10
    //   64: astore_0
    //   65: aload 13
    //   67: ldc 79
    //   69: invokevirtual 82	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   72: ifne -35 -> 37
    //   75: aload 10
    //   77: astore_0
    //   78: aload 13
    //   80: ldc 84
    //   82: invokevirtual 82	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   85: ifne -48 -> 37
    //   88: aload 10
    //   90: astore_0
    //   91: aload_2
    //   92: invokestatic 19	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   95: ifne +15 -> 110
    //   98: aload 10
    //   100: astore_0
    //   101: aload 13
    //   103: aload_2
    //   104: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq -70 -> 37
    //   110: aload 10
    //   112: astore_0
    //   113: aload 11
    //   115: invokevirtual 88	java/util/zip/ZipEntry:isDirectory	()Z
    //   118: ifne -81 -> 37
    //   121: aload 10
    //   123: astore_0
    //   124: new 172	java/io/ByteArrayOutputStream
    //   127: dup
    //   128: invokespecial 173	java/io/ByteArrayOutputStream:<init>	()V
    //   131: astore 11
    //   133: aload 10
    //   135: aload 14
    //   137: invokevirtual 145	java/util/zip/ZipInputStream:read	([B)I
    //   140: istore 7
    //   142: iload 7
    //   144: iconst_m1
    //   145: if_icmpeq +70 -> 215
    //   148: aload 11
    //   150: aload 14
    //   152: iconst_0
    //   153: iload 7
    //   155: invokevirtual 174	java/io/ByteArrayOutputStream:write	([BII)V
    //   158: goto -25 -> 133
    //   161: astore_1
    //   162: aload 11
    //   164: invokevirtual 177	java/io/ByteArrayOutputStream:close	()V
    //   167: aload 10
    //   169: astore_0
    //   170: ldc 156
    //   172: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload 10
    //   177: astore_0
    //   178: aload_1
    //   179: athrow
    //   180: astore_2
    //   181: aload 10
    //   183: astore_1
    //   184: aload_1
    //   185: astore_0
    //   186: ldc 116
    //   188: aload_2
    //   189: ldc 179
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_1
    //   199: astore_0
    //   200: getstatic 185	com/tencent/mm/plugin/appbrand/appstorage/r:qMM	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
    //   203: astore_2
    //   204: aload_1
    //   205: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   208: ldc 156
    //   210: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_2
    //   214: areturn
    //   215: aload_2
    //   216: invokestatic 19	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   219: ifne +190 -> 409
    //   222: aload 13
    //   224: aload_2
    //   225: invokevirtual 170	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifeq +181 -> 409
    //   231: lload 5
    //   233: lstore 8
    //   235: lload 5
    //   237: ldc2_w 186
    //   240: lcmp
    //   241: ifne +13 -> 254
    //   244: aload 11
    //   246: invokevirtual 190	java/io/ByteArrayOutputStream:size	()I
    //   249: i2l
    //   250: lload_3
    //   251: lsub
    //   252: lstore 8
    //   254: lload_3
    //   255: l2i
    //   256: ifge +40 -> 296
    //   259: lload_3
    //   260: aload 11
    //   262: invokevirtual 190	java/io/ByteArrayOutputStream:size	()I
    //   265: iconst_1
    //   266: isub
    //   267: i2l
    //   268: lcmp
    //   269: ifle +27 -> 296
    //   272: getstatic 193	com/tencent/mm/plugin/appbrand/appstorage/r:qMW	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
    //   275: astore_1
    //   276: aload 10
    //   278: astore_0
    //   279: aload 11
    //   281: invokevirtual 177	java/io/ByteArrayOutputStream:close	()V
    //   284: aload 10
    //   286: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   289: ldc 156
    //   291: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload_1
    //   295: areturn
    //   296: lload 8
    //   298: l2i
    //   299: ifle +17 -> 316
    //   302: lload 8
    //   304: aload 11
    //   306: invokevirtual 190	java/io/ByteArrayOutputStream:size	()I
    //   309: i2l
    //   310: lload_3
    //   311: lsub
    //   312: lcmp
    //   313: ifle +27 -> 340
    //   316: getstatic 196	com/tencent/mm/plugin/appbrand/appstorage/r:qMX	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
    //   319: astore_1
    //   320: aload 10
    //   322: astore_0
    //   323: aload 11
    //   325: invokevirtual 177	java/io/ByteArrayOutputStream:close	()V
    //   328: aload 10
    //   330: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   333: ldc 156
    //   335: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_1
    //   339: areturn
    //   340: lload 8
    //   342: l2i
    //   343: istore 7
    //   345: iload 7
    //   347: newarray byte
    //   349: astore_0
    //   350: aload 11
    //   352: invokevirtual 200	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   355: lload_3
    //   356: l2i
    //   357: aload_0
    //   358: iconst_0
    //   359: lload 8
    //   361: l2i
    //   362: invokestatic 206	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   365: aload 12
    //   367: aload 13
    //   369: aload_0
    //   370: invokestatic 212	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   373: invokeinterface 218 3 0
    //   378: pop
    //   379: aload 10
    //   381: astore_0
    //   382: aload 11
    //   384: invokevirtual 177	java/io/ByteArrayOutputStream:close	()V
    //   387: aload 10
    //   389: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   392: aload_1
    //   393: aload 12
    //   395: putfield 224	com/tencent/mm/plugin/appbrand/af/k:value	Ljava/lang/Object;
    //   398: getstatic 227	com/tencent/mm/plugin/appbrand/appstorage/r:qML	Lcom/tencent/mm/plugin/appbrand/appstorage/r;
    //   401: astore_0
    //   402: ldc 156
    //   404: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: aload_0
    //   408: areturn
    //   409: aload 12
    //   411: aload 13
    //   413: aload 11
    //   415: invokevirtual 200	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   418: invokestatic 212	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   421: invokeinterface 218 3 0
    //   426: pop
    //   427: aload 10
    //   429: astore_0
    //   430: aload 11
    //   432: invokevirtual 177	java/io/ByteArrayOutputStream:close	()V
    //   435: goto -398 -> 37
    //   438: astore_2
    //   439: aload_0
    //   440: astore_1
    //   441: aload_2
    //   442: astore_0
    //   443: aload_1
    //   444: invokestatic 128	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   447: ldc 156
    //   449: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload_0
    //   453: athrow
    //   454: astore_2
    //   455: aload 10
    //   457: astore_0
    //   458: aload_1
    //   459: aload_2
    //   460: invokevirtual 233	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   463: goto -296 -> 167
    //   466: astore_0
    //   467: aconst_null
    //   468: astore_1
    //   469: goto -26 -> 443
    //   472: astore_2
    //   473: aconst_null
    //   474: astore_1
    //   475: goto -291 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	paramString1	String
    //   0	478	1	paramk	com.tencent.mm.plugin.appbrand.af.k<java.util.Map<String, ByteBuffer>>
    //   0	478	2	paramString2	String
    //   0	478	3	paramLong1	long
    //   0	478	5	paramLong2	long
    //   140	206	7	i	int
    //   233	127	8	l	long
    //   25	431	10	localZipInputStream	java.util.zip.ZipInputStream
    //   45	386	11	localObject	Object
    //   12	398	12	localHashMap	java.util.HashMap
    //   60	352	13	str	String
    //   35	116	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   133	142	161	finally
    //   148	158	161	finally
    //   215	231	161	finally
    //   244	254	161	finally
    //   259	276	161	finally
    //   302	316	161	finally
    //   316	320	161	finally
    //   345	379	161	finally
    //   409	427	161	finally
    //   30	37	180	java/lang/Exception
    //   40	47	180	java/lang/Exception
    //   55	62	180	java/lang/Exception
    //   65	75	180	java/lang/Exception
    //   78	88	180	java/lang/Exception
    //   91	98	180	java/lang/Exception
    //   101	110	180	java/lang/Exception
    //   113	121	180	java/lang/Exception
    //   124	133	180	java/lang/Exception
    //   170	175	180	java/lang/Exception
    //   178	180	180	java/lang/Exception
    //   279	284	180	java/lang/Exception
    //   323	328	180	java/lang/Exception
    //   382	387	180	java/lang/Exception
    //   430	435	180	java/lang/Exception
    //   458	463	180	java/lang/Exception
    //   30	37	438	finally
    //   40	47	438	finally
    //   55	62	438	finally
    //   65	75	438	finally
    //   78	88	438	finally
    //   91	98	438	finally
    //   101	110	438	finally
    //   113	121	438	finally
    //   124	133	438	finally
    //   170	175	438	finally
    //   178	180	438	finally
    //   186	198	438	finally
    //   200	204	438	finally
    //   279	284	438	finally
    //   323	328	438	finally
    //   382	387	438	finally
    //   430	435	438	finally
    //   458	463	438	finally
    //   162	167	454	finally
    //   14	27	466	finally
    //   14	27	472	java/lang/Exception
  }
  
  /* Error */
  static ByteBuffer a(u paramu, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 239
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: invokevirtual 242	com/tencent/mm/vfs/u:jKS	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 245	com/tencent/mm/vfs/u:jKV	()Z
    //   20: ifne +15 -> 35
    //   23: iconst_0
    //   24: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   27: astore_0
    //   28: ldc 239
    //   30: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 252	com/tencent/mm/vfs/u:length	()J
    //   39: l2i
    //   40: istore 5
    //   42: iload 5
    //   44: ifge +15 -> 59
    //   47: iconst_0
    //   48: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   51: astore_0
    //   52: ldc 239
    //   54: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   74: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   77: astore_0
    //   78: ldc 239
    //   80: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: areturn
    //   85: iload 5
    //   87: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   90: astore 8
    //   92: iload 5
    //   94: i2l
    //   95: lstore 6
    //   97: lload_3
    //   98: lconst_0
    //   99: lcmp
    //   100: iflt +225 -> 325
    //   103: aload_0
    //   104: invokevirtual 256	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   107: invokestatic 262	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   110: iconst_0
    //   111: invokestatic 266	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   114: astore 9
    //   116: aload 9
    //   118: invokevirtual 272	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   121: aload 8
    //   123: invokevirtual 277	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   126: pop
    //   127: aload 8
    //   129: invokevirtual 281	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
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
    //   147: aload 9
    //   149: ifnull +8 -> 157
    //   152: aload 9
    //   154: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   157: ldc 239
    //   159: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload 8
    //   164: areturn
    //   165: lload_3
    //   166: l2i
    //   167: istore 5
    //   169: iload 5
    //   171: newarray byte
    //   173: astore 10
    //   175: aload 8
    //   177: lload_1
    //   178: l2i
    //   179: invokevirtual 286	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   182: pop
    //   183: aload 8
    //   185: aload 10
    //   187: iconst_0
    //   188: lload_3
    //   189: l2i
    //   190: invokevirtual 290	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   193: pop
    //   194: aload 10
    //   196: invokestatic 212	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   199: astore 10
    //   201: aload 9
    //   203: ifnull +8 -> 211
    //   206: aload 9
    //   208: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   211: ldc 239
    //   213: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload 10
    //   218: areturn
    //   219: astore 10
    //   221: aload 9
    //   223: ifnull +8 -> 231
    //   226: aload 9
    //   228: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   231: ldc 239
    //   233: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload 10
    //   238: athrow
    //   239: astore_0
    //   240: ldc 116
    //   242: aload_0
    //   243: ldc_w 292
    //   246: iconst_0
    //   247: anewarray 4	java/lang/Object
    //   250: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload 8
    //   255: invokestatic 298	com/tencent/luggage/l/a:l	(Ljava/nio/ByteBuffer;)V
    //   258: iconst_0
    //   259: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   262: astore_0
    //   263: ldc 239
    //   265: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_0
    //   269: areturn
    //   270: astore 9
    //   272: aload 10
    //   274: aload 9
    //   276: invokevirtual 233	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   279: goto -48 -> 231
    //   282: astore 9
    //   284: ldc 116
    //   286: ldc_w 300
    //   289: iconst_2
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload_0
    //   296: invokevirtual 252	com/tencent/mm/vfs/u:length	()J
    //   299: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   302: aastore
    //   303: dup
    //   304: iconst_1
    //   305: aload 8
    //   307: invokevirtual 309	java/nio/ByteBuffer:capacity	()I
    //   310: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload 8
    //   319: invokestatic 298	com/tencent/luggage/l/a:l	(Ljava/nio/ByteBuffer;)V
    //   322: goto -64 -> 258
    //   325: lload 6
    //   327: lstore_3
    //   328: goto -225 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramu	u
    //   0	331	1	paramLong1	long
    //   0	331	3	paramLong2	long
    //   40	130	5	i	int
    //   95	231	6	l	long
    //   90	228	8	localByteBuffer	ByteBuffer
    //   114	113	9	localRandomAccessFile	java.io.RandomAccessFile
    //   270	5	9	localThrowable	java.lang.Throwable
    //   282	1	9	localBufferOverflowException	java.nio.BufferOverflowException
    //   173	44	10	localObject1	Object
    //   219	54	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   116	133	219	finally
    //   169	201	219	finally
    //   103	116	239	java/io/IOException
    //   152	157	239	java/io/IOException
    //   206	211	239	java/io/IOException
    //   231	239	239	java/io/IOException
    //   272	279	239	java/io/IOException
    //   226	231	270	finally
    //   103	116	282	java/nio/BufferOverflowException
    //   152	157	282	java/nio/BufferOverflowException
    //   206	211	282	java/nio/BufferOverflowException
    //   231	239	282	java/nio/BufferOverflowException
    //   272	279	282	java/nio/BufferOverflowException
  }
  
  static void a(u paramu, w paramw)
  {
    AppMethodBeat.i(175571);
    paramu = paramu.a(paramw);
    if (paramu != null)
    {
      int j = paramu.length;
      int i = 0;
      while (i < j)
      {
        u localu = paramu[i];
        if (localu.isDirectory()) {
          a(localu, paramw);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(175571);
  }
  
  public static String as(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(323287);
    if (paramBoolean) {
      Log.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    }
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(323287);
      return "";
    }
    paramString = paramString.trim();
    if (!paramString.startsWith("/"))
    {
      paramString = "/".concat(String.valueOf(paramString));
      AppMethodBeat.o(323287);
      return paramString;
    }
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = "/" + paramString.substring(i);
    AppMethodBeat.o(323287);
    return paramString;
  }
  
  public static long q(u paramu)
  {
    long l = 0L;
    AppMethodBeat.i(175568);
    if (paramu == null)
    {
      AppMethodBeat.o(175568);
      return -1L;
    }
    paramu = paramu.jKX();
    if (paramu == null)
    {
      AppMethodBeat.o(175568);
      return 0L;
    }
    int j = paramu.length;
    int i = 0;
    if (i < j)
    {
      u localu = paramu[i];
      if (localu.jKV()) {}
      for (l += localu.length();; l += q(localu))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(175568);
    return l;
  }
  
  public static long r(u paramu)
  {
    long l = 0L;
    AppMethodBeat.i(134329);
    if (paramu == null)
    {
      AppMethodBeat.o(134329);
      return -1L;
    }
    paramu = paramu.jKX();
    if (paramu == null)
    {
      AppMethodBeat.o(134329);
      return 0L;
    }
    int j = paramu.length;
    int i = 0;
    if (i < j)
    {
      u localu = paramu[i];
      if (localu.jKV()) {}
      for (l += localu.length();; l += r(localu))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(134329);
    return l;
  }
  
  static ByteBuffer s(u paramu)
  {
    AppMethodBeat.i(175570);
    paramu = a(paramu, 0L, -1L);
    AppMethodBeat.o(175570);
    return paramu;
  }
  
  public static void t(u paramu)
  {
    AppMethodBeat.i(175572);
    if ((paramu == null) || (!paramu.isDirectory()))
    {
      AppMethodBeat.o(175572);
      return;
    }
    if (paramu.jKS())
    {
      u[] arrayOfu = paramu.jKX();
      if (arrayOfu != null)
      {
        int j = arrayOfu.length;
        int i = 0;
        while (i < j)
        {
          u localu = arrayOfu[i];
          if (localu.isDirectory()) {
            t(localu);
          }
          localu.diJ();
          i += 1;
        }
      }
      paramu.diJ();
    }
    AppMethodBeat.o(175572);
  }
  
  public static boolean u(u paramu)
  {
    AppMethodBeat.i(175573);
    if (paramu == null)
    {
      paramu = new NullPointerException("file should not be NULL");
      AppMethodBeat.o(175573);
      throw paramu;
    }
    if (!paramu.jKS())
    {
      AppMethodBeat.o(175573);
      return false;
    }
    try
    {
      FileStructStat localFileStructStat = new FileStructStat();
      if (FileStat.b(ah.v(paramu.jKT()), localFileStructStat) == 0)
      {
        Log.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { ah.v(paramu.jKT()), Integer.valueOf(localFileStructStat.st_mode) });
        boolean bool = localFileStructStat.isSymLink();
        AppMethodBeat.o(175573);
        return bool;
      }
    }
    catch (Exception paramu)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", paramu, "", new Object[0]);
      AppMethodBeat.o(175573);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.t
 * JD-Core Version:    0.7.0.1
 */