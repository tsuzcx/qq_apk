package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;

public final class m
{
  public static String EU(String paramString)
  {
    AppMethodBeat.i(134336);
    if (bt.isNullOrNil(paramString))
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
  
  public static String EV(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(134337);
    ad.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
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
  
  public static String EW(String paramString)
  {
    AppMethodBeat.i(192578);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(192578);
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(192578);
    return paramString;
  }
  
  /* Error */
  public static int a(java.util.zip.ZipInputStream paramZipInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc 99
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 16384
    //   8: newarray byte
    //   10: astore 6
    //   12: aload_0
    //   13: invokevirtual 105	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +306 -> 324
    //   21: aload_3
    //   22: invokevirtual 110	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   25: astore 4
    //   27: aload 4
    //   29: ldc 112
    //   31: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   34: ifne -22 -> 12
    //   37: aload 4
    //   39: ldc 117
    //   41: invokevirtual 115	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifne -32 -> 12
    //   47: aload_3
    //   48: invokevirtual 121	java/util/zip/ZipEntry:isDirectory	()Z
    //   51: ifeq +78 -> 129
    //   54: aload 4
    //   56: iconst_0
    //   57: aload 4
    //   59: invokevirtual 28	java/lang/String:length	()I
    //   62: iconst_1
    //   63: isub
    //   64: invokevirtual 124	java/lang/String:substring	(II)Ljava/lang/String;
    //   67: astore_3
    //   68: new 126	com/tencent/mm/vfs/e
    //   71: dup
    //   72: new 69	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 57
    //   85: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 130	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 133	com/tencent/mm/vfs/e:mkdirs	()Z
    //   101: pop
    //   102: goto -90 -> 12
    //   105: astore_1
    //   106: ldc 41
    //   108: aload_1
    //   109: ldc 135
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 139	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_0
    //   119: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   122: ldc 99
    //   124: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_m1
    //   128: ireturn
    //   129: new 126	com/tencent/mm/vfs/e
    //   132: dup
    //   133: new 69	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   140: aload_1
    //   141: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 57
    //   146: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 4
    //   151: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 130	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   160: astore 5
    //   162: aload 5
    //   164: invokevirtual 146	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   167: invokevirtual 133	com/tencent/mm/vfs/e:mkdirs	()Z
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 149	com/tencent/mm/vfs/e:createNewFile	()Z
    //   176: pop
    //   177: aconst_null
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_3
    //   182: aload 5
    //   184: invokestatic 155	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   187: astore 5
    //   189: aload 5
    //   191: astore_3
    //   192: aload 5
    //   194: astore 4
    //   196: aload_0
    //   197: aload 6
    //   199: invokevirtual 159	java/util/zip/ZipInputStream:read	([B)I
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
    //   221: invokevirtual 165	java/io/OutputStream:write	([BII)V
    //   224: aload 5
    //   226: astore_3
    //   227: aload 5
    //   229: astore 4
    //   231: aload 5
    //   233: invokevirtual 168	java/io/OutputStream:flush	()V
    //   236: goto -47 -> 189
    //   239: astore_1
    //   240: aload_3
    //   241: astore 4
    //   243: ldc 99
    //   245: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_3
    //   249: astore 4
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: aload 4
    //   256: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   259: ldc 99
    //   261: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: ldc 41
    //   269: aload_1
    //   270: ldc 135
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 139	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: aload_0
    //   280: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   283: ldc 99
    //   285: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: bipush 254
    //   290: ireturn
    //   291: aload 5
    //   293: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   296: goto -284 -> 12
    //   299: astore_1
    //   300: ldc 41
    //   302: aload_1
    //   303: ldc 135
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 139	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: aload_0
    //   313: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   316: ldc 99
    //   318: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: bipush 253
    //   323: ireturn
    //   324: aload_0
    //   325: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   328: ldc 99
    //   330: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_1
    //   336: aload_0
    //   337: invokestatic 142	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   340: ldc 99
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
  static ByteBuffer a(e parame, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 174
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: invokevirtual 177	com/tencent/mm/vfs/e:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 180	com/tencent/mm/vfs/e:isFile	()Z
    //   20: ifne +15 -> 35
    //   23: iconst_0
    //   24: invokestatic 186	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   27: astore_0
    //   28: ldc 174
    //   30: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 189	com/tencent/mm/vfs/e:length	()J
    //   39: l2i
    //   40: istore 5
    //   42: iload 5
    //   44: ifge +15 -> 59
    //   47: iconst_0
    //   48: invokestatic 186	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   51: astore_0
    //   52: ldc 174
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
    //   74: invokestatic 186	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   77: astore_0
    //   78: ldc 174
    //   80: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: areturn
    //   85: iload 5
    //   87: invokestatic 186	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   90: astore 10
    //   92: iload 5
    //   94: i2l
    //   95: lstore 6
    //   97: lload_3
    //   98: lconst_0
    //   99: lcmp
    //   100: iflt +254 -> 354
    //   103: aload_0
    //   104: invokevirtual 193	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   107: invokestatic 199	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   110: iconst_0
    //   111: invokestatic 203	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   114: astore 11
    //   116: aconst_null
    //   117: astore 9
    //   119: aload 11
    //   121: invokevirtual 209	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   124: aload 10
    //   126: invokevirtual 214	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   129: pop
    //   130: aload 10
    //   132: invokevirtual 218	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   135: pop
    //   136: lload_1
    //   137: lconst_0
    //   138: lcmp
    //   139: ifne +29 -> 168
    //   142: lload_3
    //   143: iload 5
    //   145: i2l
    //   146: lcmp
    //   147: ifne +21 -> 168
    //   150: aload 11
    //   152: ifnull +8 -> 160
    //   155: aload 11
    //   157: invokevirtual 221	java/io/RandomAccessFile:close	()V
    //   160: ldc 174
    //   162: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 10
    //   167: areturn
    //   168: lload_3
    //   169: l2i
    //   170: istore 5
    //   172: iload 5
    //   174: newarray byte
    //   176: astore 8
    //   178: aload 10
    //   180: lload_1
    //   181: l2i
    //   182: invokevirtual 225	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   185: pop
    //   186: aload 10
    //   188: aload 8
    //   190: iconst_0
    //   191: lload_3
    //   192: l2i
    //   193: invokevirtual 229	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   196: pop
    //   197: aload 8
    //   199: invokestatic 233	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   202: astore 8
    //   204: aload 11
    //   206: ifnull +8 -> 214
    //   209: aload 11
    //   211: invokevirtual 221	java/io/RandomAccessFile:close	()V
    //   214: ldc 174
    //   216: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload 8
    //   221: areturn
    //   222: astore 9
    //   224: ldc 174
    //   226: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload 9
    //   231: athrow
    //   232: astore 8
    //   234: aload 11
    //   236: ifnull +13 -> 249
    //   239: aload 9
    //   241: ifnull +100 -> 341
    //   244: aload 11
    //   246: invokevirtual 221	java/io/RandomAccessFile:close	()V
    //   249: ldc 174
    //   251: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload 8
    //   256: athrow
    //   257: astore_0
    //   258: ldc 41
    //   260: aload_0
    //   261: ldc 235
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 139	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload 10
    //   272: invokestatic 240	com/tencent/luggage/h/a:i	(Ljava/nio/ByteBuffer;)V
    //   275: iconst_0
    //   276: invokestatic 186	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   279: astore_0
    //   280: ldc 174
    //   282: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_0
    //   286: areturn
    //   287: astore 11
    //   289: aload 9
    //   291: aload 11
    //   293: invokevirtual 244	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   296: goto -47 -> 249
    //   299: astore 8
    //   301: ldc 41
    //   303: ldc 246
    //   305: iconst_2
    //   306: anewarray 4	java/lang/Object
    //   309: dup
    //   310: iconst_0
    //   311: aload_0
    //   312: invokevirtual 189	com/tencent/mm/vfs/e:length	()J
    //   315: invokestatic 251	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 10
    //   323: invokevirtual 254	java/nio/ByteBuffer:capacity	()I
    //   326: invokestatic 259	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: aastore
    //   330: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: aload 10
    //   335: invokestatic 240	com/tencent/luggage/h/a:i	(Ljava/nio/ByteBuffer;)V
    //   338: goto -63 -> 275
    //   341: aload 11
    //   343: invokevirtual 221	java/io/RandomAccessFile:close	()V
    //   346: goto -97 -> 249
    //   349: astore 8
    //   351: goto -117 -> 234
    //   354: lload 6
    //   356: lstore_3
    //   357: goto -254 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	parame	e
    //   0	360	1	paramLong1	long
    //   0	360	3	paramLong2	long
    //   40	133	5	i	int
    //   95	260	6	l	long
    //   176	44	8	localObject1	Object
    //   232	23	8	localObject2	Object
    //   299	1	8	localBufferOverflowException	java.nio.BufferOverflowException
    //   349	1	8	localObject3	Object
    //   117	1	9	localObject4	Object
    //   222	68	9	localThrowable1	java.lang.Throwable
    //   90	244	10	localByteBuffer	ByteBuffer
    //   114	131	11	localRandomAccessFile	java.io.RandomAccessFile
    //   287	55	11	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   119	136	222	java/lang/Throwable
    //   172	204	222	java/lang/Throwable
    //   224	232	232	finally
    //   103	116	257	java/io/IOException
    //   155	160	257	java/io/IOException
    //   209	214	257	java/io/IOException
    //   244	249	257	java/io/IOException
    //   249	257	257	java/io/IOException
    //   289	296	257	java/io/IOException
    //   341	346	257	java/io/IOException
    //   244	249	287	java/lang/Throwable
    //   103	116	299	java/nio/BufferOverflowException
    //   155	160	299	java/nio/BufferOverflowException
    //   209	214	299	java/nio/BufferOverflowException
    //   244	249	299	java/nio/BufferOverflowException
    //   249	257	299	java/nio/BufferOverflowException
    //   289	296	299	java/nio/BufferOverflowException
    //   341	346	299	java/nio/BufferOverflowException
    //   119	136	349	finally
    //   172	204	349	finally
  }
  
  static void a(e parame, g paramg)
  {
    AppMethodBeat.i(175571);
    parame = parame.a(paramg);
    if (parame != null)
    {
      int j = parame.length;
      int i = 0;
      while (i < j)
      {
        e locale = parame[i];
        if (locale.isDirectory()) {
          a(locale, paramg);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(175571);
  }
  
  public static long r(e parame)
  {
    long l = 0L;
    AppMethodBeat.i(175568);
    if (parame == null)
    {
      AppMethodBeat.o(175568);
      return -1L;
    }
    parame = parame.fhW();
    if (parame == null)
    {
      AppMethodBeat.o(175568);
      return 0L;
    }
    int j = parame.length;
    int i = 0;
    if (i < j)
    {
      e locale = parame[i];
      if (locale.isFile()) {}
      for (l += locale.length();; l += r(locale))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(175568);
    return l;
  }
  
  public static long s(e parame)
  {
    long l = 0L;
    AppMethodBeat.i(134329);
    if (parame == null)
    {
      AppMethodBeat.o(134329);
      return -1L;
    }
    parame = parame.fhW();
    if (parame == null)
    {
      AppMethodBeat.o(134329);
      return 0L;
    }
    int j = parame.length;
    int i = 0;
    if (i < j)
    {
      e locale = parame[i];
      if (locale.isFile()) {}
      for (l += locale.length();; l += s(locale))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(134329);
    return l;
  }
  
  static ByteBuffer t(e parame)
  {
    AppMethodBeat.i(175570);
    parame = a(parame, 0L, -1L);
    AppMethodBeat.o(175570);
    return parame;
  }
  
  static void u(e parame)
  {
    AppMethodBeat.i(175572);
    if ((parame == null) || (!parame.isDirectory()))
    {
      AppMethodBeat.o(175572);
      return;
    }
    if (parame.exists())
    {
      e[] arrayOfe = parame.fhW();
      if (arrayOfe != null)
      {
        int j = arrayOfe.length;
        int i = 0;
        while (i < j)
        {
          e locale = arrayOfe[i];
          if (locale.isDirectory()) {
            u(locale);
          }
          locale.delete();
          i += 1;
        }
      }
      parame.delete();
    }
    AppMethodBeat.o(175572);
  }
  
  public static boolean v(e parame)
  {
    AppMethodBeat.i(175573);
    if (parame == null)
    {
      parame = new NullPointerException("file should not be NULL");
      AppMethodBeat.o(175573);
      throw parame;
    }
    if (!parame.exists())
    {
      AppMethodBeat.o(175573);
      return false;
    }
    try
    {
      FileStructStat localFileStructStat = new FileStructStat();
      if (FileStat.b(q.B(parame.fhU()), localFileStructStat) == 0)
      {
        ad.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { q.B(parame.fhU()), Integer.valueOf(localFileStructStat.st_mode) });
        boolean bool = localFileStructStat.isSymLink();
        AppMethodBeat.o(175573);
        return bool;
      }
    }
    catch (Exception parame)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", parame, "", new Object[0]);
      AppMethodBeat.o(175573);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.m
 * JD-Core Version:    0.7.0.1
 */