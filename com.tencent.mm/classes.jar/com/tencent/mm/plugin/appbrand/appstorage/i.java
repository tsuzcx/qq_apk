package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileFilter;

public final class i
{
  /* Error */
  public static int a(java.util.zip.ZipInputStream paramZipInputStream, String paramString)
  {
    // Byte code:
    //   0: sipush 16384
    //   3: newarray byte
    //   5: astore 5
    //   7: aload_0
    //   8: invokevirtual 20	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnull +262 -> 275
    //   16: aload_3
    //   17: invokevirtual 26	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 28
    //   26: invokevirtual 34	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   29: ifne -22 -> 7
    //   32: aload 4
    //   34: ldc 36
    //   36: invokevirtual 34	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   39: ifne -32 -> 7
    //   42: aload_3
    //   43: invokevirtual 40	java/util/zip/ZipEntry:isDirectory	()Z
    //   46: ifeq +74 -> 120
    //   49: aload 4
    //   51: iconst_0
    //   52: aload 4
    //   54: invokevirtual 44	java/lang/String:length	()I
    //   57: iconst_1
    //   58: isub
    //   59: invokevirtual 48	java/lang/String:substring	(II)Ljava/lang/String;
    //   62: astore_3
    //   63: new 50	java/io/File
    //   66: dup
    //   67: new 52	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   74: aload_1
    //   75: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 64	java/io/File:separator	Ljava/lang/String;
    //   81: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_3
    //   85: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 73	java/io/File:mkdirs	()Z
    //   97: pop
    //   98: goto -91 -> 7
    //   101: astore_1
    //   102: ldc 75
    //   104: aload_1
    //   105: ldc 77
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   118: iconst_m1
    //   119: ireturn
    //   120: new 50	java/io/File
    //   123: dup
    //   124: new 52	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   131: aload_1
    //   132: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: getstatic 64	java/io/File:separator	Ljava/lang/String;
    //   138: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 4
    //   143: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore_3
    //   153: aload_3
    //   154: invokevirtual 93	java/io/File:getParentFile	()Ljava/io/File;
    //   157: invokevirtual 73	java/io/File:mkdirs	()Z
    //   160: pop
    //   161: aload_3
    //   162: invokevirtual 96	java/io/File:createNewFile	()Z
    //   165: pop
    //   166: new 98	java/io/FileOutputStream
    //   169: dup
    //   170: aload_3
    //   171: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   174: astore 4
    //   176: aload 4
    //   178: astore_3
    //   179: aload_0
    //   180: aload 5
    //   182: invokevirtual 105	java/util/zip/ZipInputStream:read	([B)I
    //   185: istore_2
    //   186: iload_2
    //   187: iconst_m1
    //   188: if_icmpeq +59 -> 247
    //   191: aload 4
    //   193: astore_3
    //   194: aload 4
    //   196: aload 5
    //   198: iconst_0
    //   199: iload_2
    //   200: invokevirtual 109	java/io/FileOutputStream:write	([BII)V
    //   203: aload 4
    //   205: astore_3
    //   206: aload 4
    //   208: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   211: goto -35 -> 176
    //   214: astore_1
    //   215: aload 4
    //   217: astore_3
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: aload_3
    //   222: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: ldc 75
    //   230: aload_1
    //   231: ldc 77
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: aload_0
    //   241: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   244: bipush 254
    //   246: ireturn
    //   247: aload 4
    //   249: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   252: goto -245 -> 7
    //   255: astore_1
    //   256: ldc 75
    //   258: aload_1
    //   259: ldc 77
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload_0
    //   269: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   272: bipush 253
    //   274: ireturn
    //   275: aload_0
    //   276: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_1
    //   282: aload_0
    //   283: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_3
    //   291: goto -70 -> 221
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_3
    //   297: goto -79 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramZipInputStream	java.util.zip.ZipInputStream
    //   0	300	1	paramString	String
    //   185	15	2	i	int
    //   11	286	3	localObject1	Object
    //   20	228	4	localObject2	Object
    //   5	192	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	7	101	java/io/FileNotFoundException
    //   7	12	101	java/io/FileNotFoundException
    //   16	98	101	java/io/FileNotFoundException
    //   120	166	101	java/io/FileNotFoundException
    //   221	227	101	java/io/FileNotFoundException
    //   247	252	101	java/io/FileNotFoundException
    //   179	186	214	java/lang/Exception
    //   194	203	214	java/lang/Exception
    //   206	211	214	java/lang/Exception
    //   179	186	220	finally
    //   194	203	220	finally
    //   206	211	220	finally
    //   218	220	220	finally
    //   0	7	227	java/io/IOException
    //   7	12	227	java/io/IOException
    //   16	98	227	java/io/IOException
    //   120	166	227	java/io/IOException
    //   221	227	227	java/io/IOException
    //   247	252	227	java/io/IOException
    //   0	7	255	java/lang/OutOfMemoryError
    //   7	12	255	java/lang/OutOfMemoryError
    //   16	98	255	java/lang/OutOfMemoryError
    //   120	166	255	java/lang/OutOfMemoryError
    //   221	227	255	java/lang/OutOfMemoryError
    //   247	252	255	java/lang/OutOfMemoryError
    //   0	7	281	finally
    //   7	12	281	finally
    //   16	98	281	finally
    //   102	114	281	finally
    //   120	166	281	finally
    //   221	227	281	finally
    //   228	240	281	finally
    //   247	252	281	finally
    //   256	268	281	finally
    //   166	176	288	finally
    //   166	176	294	java/lang/Exception
  }
  
  static void a(File paramFile, FileFilter paramFileFilter)
  {
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
  }
  
  public static String rA(String paramString)
  {
    int i = 0;
    y.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return "";
    }
    paramString = paramString.trim();
    if (!paramString.startsWith("/")) {
      return "/" + paramString;
    }
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    return "/" + paramString.substring(i);
  }
  
  public static String rz(String paramString)
  {
    if (bk.bl(paramString)) {
      return paramString;
    }
    int i = 0;
    while ((i < paramString.length()) && ('/' == paramString.charAt(i))) {
      i += 1;
    }
    return paramString.substring(i);
  }
  
  public static long t(File paramFile)
  {
    long l1 = 0L;
    paramFile = paramFile.listFiles();
    long l2;
    if (paramFile == null) {
      l2 = l1;
    }
    int j;
    int i;
    do
    {
      return l2;
      j = paramFile.length;
      i = 0;
      l2 = l1;
    } while (i >= j);
    File localFile = paramFile[i];
    if (localFile.isFile()) {}
    for (l1 += localFile.length();; l1 += t(localFile))
    {
      i += 1;
      break;
    }
  }
  
  /* Error */
  static java.nio.ByteBuffer u(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +17 -> 18
    //   4: aload_0
    //   5: invokevirtual 172	java/io/File:exists	()Z
    //   8: ifeq +10 -> 18
    //   11: aload_0
    //   12: invokevirtual 160	java/io/File:isFile	()Z
    //   15: ifne +8 -> 23
    //   18: iconst_0
    //   19: invokestatic 178	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   22: areturn
    //   23: aload_0
    //   24: invokevirtual 163	java/io/File:length	()J
    //   27: l2i
    //   28: istore_1
    //   29: iload_1
    //   30: ifge +8 -> 38
    //   33: iconst_0
    //   34: invokestatic 178	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   37: areturn
    //   38: iload_1
    //   39: invokestatic 178	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   42: astore 4
    //   44: new 180	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: sipush 4096
    //   58: newarray byte
    //   60: astore 5
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: aload 5
    //   67: iconst_0
    //   68: sipush 4096
    //   71: invokevirtual 184	java/io/FileInputStream:read	([BII)I
    //   74: istore_1
    //   75: iload_1
    //   76: iconst_m1
    //   77: if_icmpeq +49 -> 126
    //   80: aload_3
    //   81: astore_2
    //   82: aload 4
    //   84: aload 5
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 188	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   91: pop
    //   92: goto -30 -> 62
    //   95: astore_0
    //   96: aload_3
    //   97: astore_2
    //   98: ldc 75
    //   100: aload_0
    //   101: ldc 190
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 83	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_3
    //   111: astore_2
    //   112: aload 4
    //   114: invokestatic 196	com/tencent/luggage/j/a:f	(Ljava/nio/ByteBuffer;)V
    //   117: aload_3
    //   118: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   121: iconst_0
    //   122: invokestatic 178	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   125: areturn
    //   126: aload_3
    //   127: astore_2
    //   128: aload 4
    //   130: invokevirtual 200	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   133: pop
    //   134: aload_3
    //   135: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   138: aload 4
    //   140: areturn
    //   141: astore_2
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_3
    //   145: astore_2
    //   146: ldc 75
    //   148: ldc 202
    //   150: iconst_2
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_0
    //   157: invokevirtual 163	java/io/File:length	()J
    //   160: invokestatic 208	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: aload 4
    //   168: invokevirtual 211	java/nio/ByteBuffer:capacity	()I
    //   171: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aastore
    //   175: invokestatic 219	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload_3
    //   179: astore_2
    //   180: aload 4
    //   182: invokestatic 196	com/tencent/luggage/j/a:f	(Ljava/nio/ByteBuffer;)V
    //   185: aload_3
    //   186: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   189: goto -68 -> 121
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_2
    //   195: aload_2
    //   196: invokestatic 89	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: athrow
    //   201: astore_0
    //   202: goto -7 -> 195
    //   205: astore_2
    //   206: goto -62 -> 144
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_3
    //   212: goto -116 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramFile	File
    //   28	60	1	i	int
    //   54	74	2	localFileInputStream1	java.io.FileInputStream
    //   141	1	2	localBufferOverflowException1	java.nio.BufferOverflowException
    //   145	51	2	localFileInputStream2	java.io.FileInputStream
    //   205	1	2	localBufferOverflowException2	java.nio.BufferOverflowException
    //   52	160	3	localFileInputStream3	java.io.FileInputStream
    //   42	139	4	localByteBuffer	java.nio.ByteBuffer
    //   60	25	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   55	62	95	java/io/IOException
    //   64	75	95	java/io/IOException
    //   82	92	95	java/io/IOException
    //   128	134	95	java/io/IOException
    //   44	53	141	java/nio/BufferOverflowException
    //   44	53	192	finally
    //   55	62	201	finally
    //   64	75	201	finally
    //   82	92	201	finally
    //   98	110	201	finally
    //   112	117	201	finally
    //   128	134	201	finally
    //   146	178	201	finally
    //   180	185	201	finally
    //   55	62	205	java/nio/BufferOverflowException
    //   64	75	205	java/nio/BufferOverflowException
    //   82	92	205	java/nio/BufferOverflowException
    //   128	134	205	java/nio/BufferOverflowException
    //   44	53	209	java/io/IOException
  }
  
  public static void v(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    while (!paramFile.exists()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          v(localFile);
        }
        localFile.delete();
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public static boolean w(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("file should not be NULL");
    }
    if (!paramFile.exists()) {}
    for (;;)
    {
      return false;
      try
      {
        FileStructStat localFileStructStat = new FileStructStat();
        if (FileStat.stat(paramFile.getAbsolutePath(), localFileStructStat) == 0)
        {
          y.i("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(localFileStructStat.st_mode) });
          boolean bool = localFileStructStat.isSymLink();
          return bool;
        }
      }
      catch (Exception paramFile)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil[ZIP]", paramFile, "", new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.i
 * JD-Core Version:    0.7.0.1
 */