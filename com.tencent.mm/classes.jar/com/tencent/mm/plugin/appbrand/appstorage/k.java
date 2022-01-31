package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;

public final class k
{
  /* Error */
  static java.nio.ByteBuffer A(File paramFile)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: invokevirtual 23	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 26	java/io/File:isFile	()Z
    //   20: ifne +15 -> 35
    //   23: iconst_0
    //   24: invokestatic 32	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   27: astore_0
    //   28: ldc 11
    //   30: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 39	java/io/File:length	()J
    //   39: l2i
    //   40: istore_1
    //   41: iload_1
    //   42: ifge +15 -> 57
    //   45: iconst_0
    //   46: invokestatic 32	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   49: astore_0
    //   50: ldc 11
    //   52: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_0
    //   56: areturn
    //   57: iload_1
    //   58: invokestatic 32	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   61: astore 4
    //   63: new 41	java/io/FileInputStream
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_3
    //   72: aload_3
    //   73: astore_2
    //   74: sipush 4096
    //   77: newarray byte
    //   79: astore 5
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: aload 5
    //   86: iconst_0
    //   87: sipush 4096
    //   90: invokevirtual 49	java/io/FileInputStream:read	([BII)I
    //   93: istore_1
    //   94: iload_1
    //   95: iconst_m1
    //   96: if_icmpeq +56 -> 152
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: aload 5
    //   105: iconst_0
    //   106: iload_1
    //   107: invokevirtual 53	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   110: pop
    //   111: goto -30 -> 81
    //   114: astore_0
    //   115: aload_3
    //   116: astore_2
    //   117: ldc 55
    //   119: aload_0
    //   120: ldc 57
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_3
    //   130: astore_2
    //   131: aload 4
    //   133: invokestatic 69	com/tencent/luggage/g/a:f	(Ljava/nio/ByteBuffer;)V
    //   136: aload_3
    //   137: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   140: iconst_0
    //   141: invokestatic 32	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   144: astore_0
    //   145: ldc 11
    //   147: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_0
    //   151: areturn
    //   152: aload_3
    //   153: astore_2
    //   154: aload 4
    //   156: invokevirtual 79	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   159: pop
    //   160: aload_3
    //   161: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   164: ldc 11
    //   166: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload 4
    //   171: areturn
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_3
    //   175: aload_3
    //   176: astore_2
    //   177: ldc 55
    //   179: ldc 81
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 39	java/io/File:length	()J
    //   191: invokestatic 87	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 4
    //   199: invokevirtual 91	java/nio/ByteBuffer:capacity	()I
    //   202: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload_3
    //   210: astore_2
    //   211: aload 4
    //   213: invokestatic 69	com/tencent/luggage/g/a:f	(Ljava/nio/ByteBuffer;)V
    //   216: aload_3
    //   217: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   220: goto -80 -> 140
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_2
    //   226: aload_2
    //   227: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   230: ldc 11
    //   232: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_0
    //   236: athrow
    //   237: astore_0
    //   238: goto -12 -> 226
    //   241: astore_2
    //   242: goto -67 -> 175
    //   245: astore_0
    //   246: aconst_null
    //   247: astore_3
    //   248: goto -133 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramFile	File
    //   40	67	1	i	int
    //   73	81	2	localFileInputStream1	java.io.FileInputStream
    //   172	1	2	localBufferOverflowException1	java.nio.BufferOverflowException
    //   176	51	2	localFileInputStream2	java.io.FileInputStream
    //   241	1	2	localBufferOverflowException2	java.nio.BufferOverflowException
    //   71	177	3	localFileInputStream3	java.io.FileInputStream
    //   61	151	4	localByteBuffer	java.nio.ByteBuffer
    //   79	25	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   74	81	114	java/io/IOException
    //   83	94	114	java/io/IOException
    //   101	111	114	java/io/IOException
    //   154	160	114	java/io/IOException
    //   63	72	172	java/nio/BufferOverflowException
    //   63	72	223	finally
    //   74	81	237	finally
    //   83	94	237	finally
    //   101	111	237	finally
    //   117	129	237	finally
    //   131	136	237	finally
    //   154	160	237	finally
    //   177	209	237	finally
    //   211	216	237	finally
    //   74	81	241	java/nio/BufferOverflowException
    //   83	94	241	java/nio/BufferOverflowException
    //   101	111	241	java/nio/BufferOverflowException
    //   154	160	241	java/nio/BufferOverflowException
    //   63	72	245	java/io/IOException
  }
  
  static void B(File paramFile)
  {
    AppMethodBeat.i(105370);
    if ((paramFile == null) || (!paramFile.isDirectory()))
    {
      AppMethodBeat.o(105370);
      return;
    }
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.isDirectory()) {
            B(localFile);
          }
          localFile.delete();
          i += 1;
        }
      }
      paramFile.delete();
    }
    AppMethodBeat.o(105370);
  }
  
  public static boolean C(File paramFile)
  {
    AppMethodBeat.i(105371);
    if (paramFile == null)
    {
      paramFile = new NullPointerException("file should not be NULL");
      AppMethodBeat.o(105371);
      throw paramFile;
    }
    if (!paramFile.exists())
    {
      AppMethodBeat.o(105371);
      return false;
    }
    try
    {
      FileStructStat localFileStructStat = new FileStructStat();
      if (FileStat.stat(paramFile.getAbsolutePath(), localFileStructStat) == 0)
      {
        ab.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(localFileStructStat.st_mode) });
        boolean bool = localFileStructStat.isSymLink();
        AppMethodBeat.o(105371);
        return bool;
      }
    }
    catch (Exception paramFile)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", paramFile, "", new Object[0]);
      AppMethodBeat.o(105371);
    }
    return false;
  }
  
  /* Error */
  public static int a(java.util.zip.ZipInputStream paramZipInputStream, String paramString)
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 16384
    //   8: newarray byte
    //   10: astore 5
    //   12: aload_0
    //   13: invokevirtual 168	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +295 -> 313
    //   21: aload_3
    //   22: invokevirtual 173	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   25: astore 4
    //   27: aload 4
    //   29: ldc 175
    //   31: invokevirtual 181	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   34: ifne -22 -> 12
    //   37: aload 4
    //   39: ldc 183
    //   41: invokevirtual 181	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifne -32 -> 12
    //   47: aload_3
    //   48: invokevirtual 184	java/util/zip/ZipEntry:isDirectory	()Z
    //   51: ifeq +79 -> 130
    //   54: aload 4
    //   56: iconst_0
    //   57: aload 4
    //   59: invokevirtual 186	java/lang/String:length	()I
    //   62: iconst_1
    //   63: isub
    //   64: invokevirtual 190	java/lang/String:substring	(II)Ljava/lang/String;
    //   67: astore_3
    //   68: new 19	java/io/File
    //   71: dup
    //   72: new 192	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   79: aload_1
    //   80: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 201	java/io/File:separator	Ljava/lang/String;
    //   86: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 208	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: goto -91 -> 12
    //   106: astore_1
    //   107: ldc 55
    //   109: aload_1
    //   110: ldc 210
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   123: ldc 162
    //   125: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_m1
    //   129: ireturn
    //   130: new 19	java/io/File
    //   133: dup
    //   134: new 192	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   141: aload_1
    //   142: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: getstatic 201	java/io/File:separator	Ljava/lang/String;
    //   148: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 4
    //   153: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokespecial 205	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore_3
    //   163: aload_3
    //   164: invokevirtual 214	java/io/File:getParentFile	()Ljava/io/File;
    //   167: invokevirtual 208	java/io/File:mkdirs	()Z
    //   170: pop
    //   171: aload_3
    //   172: invokevirtual 217	java/io/File:createNewFile	()Z
    //   175: pop
    //   176: new 219	java/io/FileOutputStream
    //   179: dup
    //   180: aload_3
    //   181: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   184: astore 4
    //   186: aload 4
    //   188: astore_3
    //   189: aload_0
    //   190: aload 5
    //   192: invokevirtual 223	java/util/zip/ZipInputStream:read	([B)I
    //   195: istore_2
    //   196: iload_2
    //   197: iconst_m1
    //   198: if_icmpeq +82 -> 280
    //   201: aload 4
    //   203: astore_3
    //   204: aload 4
    //   206: aload 5
    //   208: iconst_0
    //   209: iload_2
    //   210: invokevirtual 227	java/io/FileOutputStream:write	([BII)V
    //   213: aload 4
    //   215: astore_3
    //   216: aload 4
    //   218: invokevirtual 230	java/io/FileOutputStream:flush	()V
    //   221: goto -35 -> 186
    //   224: astore_3
    //   225: aload 4
    //   227: astore_1
    //   228: aload_3
    //   229: astore 4
    //   231: aload_1
    //   232: astore_3
    //   233: ldc 162
    //   235: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: astore_3
    //   240: aload 4
    //   242: athrow
    //   243: astore_1
    //   244: aload_3
    //   245: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   248: ldc 162
    //   250: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: ldc 55
    //   258: aload_1
    //   259: ldc 210
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload_0
    //   269: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   272: ldc 162
    //   274: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: bipush 254
    //   279: ireturn
    //   280: aload 4
    //   282: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   285: goto -273 -> 12
    //   288: astore_1
    //   289: ldc 55
    //   291: aload_1
    //   292: ldc 210
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: aload_0
    //   302: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   305: ldc 162
    //   307: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: bipush 253
    //   312: ireturn
    //   313: aload_0
    //   314: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   317: ldc 162
    //   319: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_0
    //   323: ireturn
    //   324: astore_1
    //   325: aload_0
    //   326: invokestatic 75	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   329: ldc 162
    //   331: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload_1
    //   335: athrow
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_3
    //   339: goto -95 -> 244
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_1
    //   346: goto -115 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramZipInputStream	java.util.zip.ZipInputStream
    //   0	349	1	paramString	String
    //   195	15	2	i	int
    //   16	200	3	localObject1	Object
    //   224	5	3	localException1	Exception
    //   232	107	3	str	String
    //   25	256	4	localObject2	Object
    //   342	1	4	localException2	Exception
    //   10	197	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	12	106	java/io/FileNotFoundException
    //   12	17	106	java/io/FileNotFoundException
    //   21	103	106	java/io/FileNotFoundException
    //   130	176	106	java/io/FileNotFoundException
    //   244	255	106	java/io/FileNotFoundException
    //   280	285	106	java/io/FileNotFoundException
    //   189	196	224	java/lang/Exception
    //   204	213	224	java/lang/Exception
    //   216	221	224	java/lang/Exception
    //   189	196	243	finally
    //   204	213	243	finally
    //   216	221	243	finally
    //   233	238	243	finally
    //   240	243	243	finally
    //   5	12	255	java/io/IOException
    //   12	17	255	java/io/IOException
    //   21	103	255	java/io/IOException
    //   130	176	255	java/io/IOException
    //   244	255	255	java/io/IOException
    //   280	285	255	java/io/IOException
    //   5	12	288	java/lang/OutOfMemoryError
    //   12	17	288	java/lang/OutOfMemoryError
    //   21	103	288	java/lang/OutOfMemoryError
    //   130	176	288	java/lang/OutOfMemoryError
    //   244	255	288	java/lang/OutOfMemoryError
    //   280	285	288	java/lang/OutOfMemoryError
    //   5	12	324	finally
    //   12	17	324	finally
    //   21	103	324	finally
    //   107	119	324	finally
    //   130	176	324	finally
    //   244	255	324	finally
    //   256	268	324	finally
    //   280	285	324	finally
    //   289	301	324	finally
    //   176	186	336	finally
    //   176	186	342	java/lang/Exception
  }
  
  static void a(File paramFile, FileFilter paramFileFilter)
  {
    AppMethodBeat.i(105369);
    paramFile = paramFile.listFiles(paramFileFilter);
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = paramFile[i];
        if (localFile.isDirectory()) {
          a(localFile, paramFileFilter);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(105369);
  }
  
  public static long z(File paramFile)
  {
    long l = 0L;
    AppMethodBeat.i(105366);
    if (paramFile == null)
    {
      AppMethodBeat.o(105366);
      return -1L;
    }
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      AppMethodBeat.o(105366);
      return 0L;
    }
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isFile()) {}
      for (l += localFile.length();; l += z(localFile))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(105366);
    return l;
  }
  
  public static String zk(String paramString)
  {
    AppMethodBeat.i(105372);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105372);
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(105372);
    return paramString;
  }
  
  public static String zl(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(105373);
    ab.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(105373);
      return "";
    }
    paramString = paramString.trim();
    if (!paramString.startsWith("/"))
    {
      paramString = "/".concat(String.valueOf(paramString));
      AppMethodBeat.o(105373);
      return paramString;
    }
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    paramString = "/" + paramString.substring(i);
    AppMethodBeat.o(105373);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.k
 * JD-Core Version:    0.7.0.1
 */