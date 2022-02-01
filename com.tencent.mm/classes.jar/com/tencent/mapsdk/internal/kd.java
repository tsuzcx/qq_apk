package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class kd
{
  private static final int a = 49152;
  
  public static File a(File paramFile, String paramString)
  {
    AppMethodBeat.i(224833);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(224833);
      return null;
    }
    File localFile = new File(paramString, paramFile.getName() + ".zip");
    paramString = new FileOutputStream(localFile);
    ZipOutputStream localZipOutputStream = new ZipOutputStream(paramString);
    try
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            a(arrayOfFile[i], localZipOutputStream, paramFile.getName());
            i += 1;
          }
        }
      }
      else
      {
        a(paramFile, localZipOutputStream, null);
      }
      paramString.flush();
      localZipOutputStream.finish();
      return localFile;
    }
    finally
    {
      paramString.close();
      localZipOutputStream.close();
      AppMethodBeat.o(224833);
    }
  }
  
  public static void a(File paramFile, String paramString, FilenameFilter paramFilenameFilter)
  {
    AppMethodBeat.i(224872);
    File localFile1 = new File(paramString);
    if (!localFile1.exists()) {
      localFile1.mkdirs();
    }
    paramFile = new ZipFile(paramFile);
    byte[] arrayOfByte = new byte[49152];
    Enumeration localEnumeration = paramFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject2 = (ZipEntry)localEnumeration.nextElement();
      Object localObject1 = ((ZipEntry)localObject2).getName();
      if (((localObject1 == null) || (!((String)localObject1).contains("../"))) && ((paramFilenameFilter == null) || (paramFilenameFilter.accept(localFile1, ((ZipEntry)localObject2).getName())))) {
        if (((ZipEntry)localObject2).isDirectory())
        {
          new File(paramString + File.separator + ((ZipEntry)localObject2).getName()).mkdir();
        }
        else
        {
          localObject1 = paramFile.getInputStream((ZipEntry)localObject2);
          localObject2 = new File(paramString + File.separator + ((ZipEntry)localObject2).getName());
          if (!((File)localObject2).exists())
          {
            File localFile2 = ((File)localObject2).getParentFile();
            if (!localFile2.exists()) {
              localFile2.mkdirs();
            }
            ((File)localObject2).createNewFile();
          }
          localObject2 = new FileOutputStream((File)localObject2);
          for (;;)
          {
            int i = ((InputStream)localObject1).read(arrayOfByte);
            if (i <= 0) {
              break;
            }
            ((OutputStream)localObject2).write(arrayOfByte, 0, i);
          }
          ((OutputStream)localObject2).flush();
          ((InputStream)localObject1).close();
          ((OutputStream)localObject2).close();
        }
      }
    }
    paramFile.close();
    AppMethodBeat.o(224872);
  }
  
  private static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(224846);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(224846);
      return;
    }
    if (paramFile.isDirectory())
    {
      localObject1 = paramFile.listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if (((File)localObject2).isDirectory()) {
            if (TextUtils.isEmpty(paramString)) {
              paramFile = ((File)localObject2).getName();
            }
          }
          for (;;)
          {
            a((File)localObject2, paramZipOutputStream, paramFile);
            i += 1;
            break;
            paramFile = paramString + File.separator + ((File)localObject2).getName();
            continue;
            paramFile = paramString;
          }
        }
      }
      AppMethodBeat.o(224846);
      return;
    }
    Object localObject1 = new byte[49152];
    Object localObject2 = new FileInputStream(paramFile);
    paramZipOutputStream.setLevel(9);
    paramZipOutputStream.setMethod(8);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramFile = paramFile.getName();; paramFile = paramString + File.separator + paramFile.getName())
    {
      paramZipOutputStream.putNextEntry(new ZipEntry(paramFile));
      for (;;)
      {
        i = ((FileInputStream)localObject2).read((byte[])localObject1);
        if (i == -1) {
          break;
        }
        paramZipOutputStream.write((byte[])localObject1, 0, i);
      }
    }
    paramZipOutputStream.closeEntry();
    ((FileInputStream)localObject2).close();
    AppMethodBeat.o(224846);
  }
  
  private static void a(InputStream paramInputStream, File paramFile)
  {
    AppMethodBeat.i(224915);
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    ZipInputStream localZipInputStream = new ZipInputStream(paramInputStream);
    byte[] arrayOfByte = new byte[49152];
    Object localObject = localZipInputStream.getNextEntry();
    if (localObject != null)
    {
      if (((ZipEntry)localObject).isDirectory())
      {
        localObject = ((ZipEntry)localObject).getName();
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1);
        new File(paramFile + File.separator + (String)localObject).mkdir();
      }
      for (;;)
      {
        localObject = localZipInputStream.getNextEntry();
        break;
        localObject = new File(paramFile, File.separator + ((ZipEntry)localObject).getName());
        if (!((File)localObject).exists())
        {
          File localFile = ((File)localObject).getParentFile();
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          ((File)localObject).createNewFile();
        }
        localObject = new FileOutputStream((File)localObject);
        for (;;)
        {
          int i = localZipInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          ((OutputStream)localObject).write(arrayOfByte, 0, i);
        }
        ((OutputStream)localObject).flush();
        ((OutputStream)localObject).close();
      }
    }
    paramInputStream.close();
    localZipInputStream.close();
    AppMethodBeat.o(224915);
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 211
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload 6
    //   10: istore 5
    //   12: aload_0
    //   13: ifnull +61 -> 74
    //   16: iload 6
    //   18: istore 5
    //   20: aload_0
    //   21: arraylength
    //   22: ifle +52 -> 74
    //   25: aload_1
    //   26: aload_2
    //   27: invokestatic 215	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   30: astore_2
    //   31: aload_0
    //   32: arraylength
    //   33: istore 4
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: iload 4
    //   40: if_icmpge +17 -> 57
    //   43: aload_0
    //   44: iload_3
    //   45: aaload
    //   46: aload_2
    //   47: invokestatic 219	com/tencent/mapsdk/internal/ka:b	(Ljava/io/File;Ljava/io/File;)V
    //   50: iload_3
    //   51: iconst_1
    //   52: iadd
    //   53: istore_3
    //   54: goto -17 -> 37
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 222	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   62: invokestatic 223	com/tencent/mapsdk/internal/kd:a	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   65: pop
    //   66: iconst_1
    //   67: istore 5
    //   69: aload_2
    //   70: invokestatic 227	com/tencent/mapsdk/internal/ka:f	(Ljava/io/File;)J
    //   73: pop2
    //   74: ldc 211
    //   76: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iload 5
    //   81: ireturn
    //   82: astore_0
    //   83: aload_2
    //   84: invokestatic 227	com/tencent/mapsdk/internal/ka:f	(Ljava/io/File;)J
    //   87: pop2
    //   88: iload 6
    //   90: istore 5
    //   92: goto -18 -> 74
    //   95: astore_0
    //   96: aload_2
    //   97: invokestatic 227	com/tencent/mapsdk/internal/ka:f	(Ljava/io/File;)J
    //   100: pop2
    //   101: ldc 211
    //   103: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramArrayOfFile	File[]
    //   0	108	1	paramFile	File
    //   0	108	2	paramString	String
    //   36	18	3	i	int
    //   33	8	4	j	int
    //   10	81	5	bool1	boolean
    //   1	88	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   57	66	82	java/lang/Exception
    //   57	66	95	finally
  }
  
  /* Error */
  public static byte[] a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 231
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ifnull +28 -> 36
    //   11: new 233	java/util/zip/GZIPInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 234	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 238	com/tencent/mapsdk/internal/kb:b	(Ljava/io/InputStream;)[B
    //   24: astore_1
    //   25: aload_0
    //   26: invokestatic 241	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   29: ldc 231
    //   31: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: areturn
    //   36: aconst_null
    //   37: invokestatic 241	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   40: ldc 231
    //   42: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: newarray byte
    //   48: areturn
    //   49: astore_0
    //   50: aload_1
    //   51: astore_0
    //   52: aload_0
    //   53: invokestatic 241	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   56: goto -16 -> 40
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 241	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   66: ldc 231
    //   68: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: astore_2
    //   76: aload_1
    //   77: astore_0
    //   78: aload_2
    //   79: astore_1
    //   80: goto -18 -> 62
    //   83: astore_1
    //   84: goto -32 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramInputStream	InputStream
    //   1	62	1	arrayOfByte	byte[]
    //   73	4	1	localObject1	Object
    //   79	1	1	localObject2	Object
    //   83	1	1	localIOException	java.io.IOException
    //   75	4	2	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   11	20	49	java/io/IOException
    //   11	20	59	finally
    //   20	25	73	finally
    //   20	25	83	java/io/IOException
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224880);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(224880);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(224880);
    }
    return null;
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 259
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 261	java/util/zip/InflaterInputStream
    //   9: dup
    //   10: new 263	java/io/ByteArrayInputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_0
    //   16: iload_1
    //   17: invokespecial 265	java/io/ByteArrayInputStream:<init>	([BII)V
    //   20: invokespecial 266	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: new 245	java/io/ByteArrayOutputStream
    //   27: dup
    //   28: invokespecial 246	java/io/ByteArrayOutputStream:<init>	()V
    //   31: astore_0
    //   32: sipush 1024
    //   35: newarray byte
    //   37: astore_3
    //   38: aload_2
    //   39: aload_3
    //   40: invokevirtual 267	java/util/zip/InflaterInputStream:read	([B)I
    //   43: istore_1
    //   44: iload_1
    //   45: ifle +10 -> 55
    //   48: aload_0
    //   49: aload_3
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 268	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: iload_1
    //   56: ifgt -18 -> 38
    //   59: aload_2
    //   60: invokevirtual 269	java/util/zip/InflaterInputStream:close	()V
    //   63: aload_0
    //   64: invokevirtual 257	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: astore_2
    //   68: aload_0
    //   69: invokevirtual 270	java/io/ByteArrayOutputStream:close	()V
    //   72: ldc_w 259
    //   75: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_2
    //   79: areturn
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 269	java/util/zip/InflaterInputStream:close	()V
    //   85: ldc_w 259
    //   88: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: goto -9 -> 85
    //   97: astore_2
    //   98: goto -35 -> 63
    //   101: astore_0
    //   102: goto -30 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramArrayOfByte	byte[]
    //   0	105	1	paramInt	int
    //   23	59	2	localObject	Object
    //   97	1	2	localIOException	java.io.IOException
    //   37	13	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	44	80	java/io/IOException
    //   81	85	93	java/io/IOException
    //   59	63	97	java/io/IOException
    //   68	72	101	java/io/IOException
  }
  
  public static void b(File paramFile, String paramString)
  {
    AppMethodBeat.i(224856);
    a(paramFile, paramString, null);
    AppMethodBeat.o(224856);
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224883);
    paramArrayOfByte = a(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(224883);
    return paramArrayOfByte;
  }
  
  private static void c(File paramFile, String paramString)
  {
    AppMethodBeat.i(224901);
    try
    {
      a(new FileInputStream(paramFile), new File(paramString));
      AppMethodBeat.o(224901);
      return;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(224901);
    }
  }
  
  private static byte[] c(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(224940);
    paramArrayOfByte = a(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(224940);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kd
 * JD-Core Version:    0.7.0.1
 */