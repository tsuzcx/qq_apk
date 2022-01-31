package com.tencent.map.lib.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil
{
  public static byte[] deflate(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98234);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(98234);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(98234);
    }
    return null;
  }
  
  public static byte[] inflate(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(98235);
    paramArrayOfByte = inflate(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(98235);
    return paramArrayOfByte;
  }
  
  /* Error */
  public static byte[] inflate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 58	java/util/zip/InflaterInputStream
    //   8: dup
    //   9: new 60	java/io/ByteArrayInputStream
    //   12: dup
    //   13: aload_0
    //   14: iload_1
    //   15: iload_2
    //   16: invokespecial 62	java/io/ByteArrayInputStream:<init>	([BII)V
    //   19: invokespecial 65	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_3
    //   23: new 22	java/io/ByteArrayOutputStream
    //   26: dup
    //   27: invokespecial 23	java/io/ByteArrayOutputStream:<init>	()V
    //   30: astore_0
    //   31: sipush 1024
    //   34: newarray byte
    //   36: astore 4
    //   38: aload_3
    //   39: aload 4
    //   41: invokevirtual 69	java/util/zip/InflaterInputStream:read	([B)I
    //   44: istore_1
    //   45: iload_1
    //   46: ifle +11 -> 57
    //   49: aload_0
    //   50: aload 4
    //   52: iconst_0
    //   53: iload_1
    //   54: invokevirtual 70	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: iload_1
    //   58: ifgt -20 -> 38
    //   61: aload_3
    //   62: invokevirtual 71	java/util/zip/InflaterInputStream:close	()V
    //   65: aload_0
    //   66: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   69: astore_3
    //   70: aload_0
    //   71: invokevirtual 72	java/io/ByteArrayOutputStream:close	()V
    //   74: ldc 56
    //   76: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_3
    //   80: areturn
    //   81: astore_0
    //   82: aload_3
    //   83: invokevirtual 71	java/util/zip/InflaterInputStream:close	()V
    //   86: ldc 56
    //   88: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: goto -8 -> 86
    //   97: astore_3
    //   98: goto -33 -> 65
    //   101: astore_0
    //   102: goto -28 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramArrayOfByte	byte[]
    //   0	105	1	paramInt1	int
    //   0	105	2	paramInt2	int
    //   22	61	3	localObject	Object
    //   97	1	3	localIOException	java.io.IOException
    //   36	15	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	45	81	java/io/IOException
    //   82	86	93	java/io/IOException
    //   61	65	97	java/io/IOException
    //   70	74	101	java/io/IOException
  }
  
  public static void upZipFile(File paramFile, String paramString)
  {
    AppMethodBeat.i(98233);
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = new byte[49152];
    Enumeration localEnumeration = paramFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject3 = (ZipEntry)localEnumeration.nextElement();
      Object localObject2 = ((ZipEntry)localObject3).getName();
      if ((localObject2 == null) || (!((String)localObject2).contains("../"))) {
        if (((ZipEntry)localObject3).isDirectory())
        {
          new File(paramString + File.separator + ((ZipEntry)localObject3).getName()).mkdir();
        }
        else
        {
          localObject2 = paramFile.getInputStream((ZipEntry)localObject3);
          localObject3 = new File(paramString + File.separator + ((ZipEntry)localObject3).getName());
          if (!((File)localObject3).exists())
          {
            File localFile = ((File)localObject3).getParentFile();
            if (!localFile.exists()) {
              localFile.mkdirs();
            }
            ((File)localObject3).createNewFile();
          }
          localObject3 = new FileOutputStream((File)localObject3);
          for (;;)
          {
            int i = ((InputStream)localObject2).read((byte[])localObject1);
            if (i <= 0) {
              break;
            }
            ((OutputStream)localObject3).write((byte[])localObject1, 0, i);
          }
          ((OutputStream)localObject3).flush();
          ((InputStream)localObject2).close();
          ((OutputStream)localObject3).close();
        }
      }
    }
    paramFile.close();
    AppMethodBeat.o(98233);
  }
  
  public static void upZipFileFromInputStream(InputStream paramInputStream, File paramFile)
  {
    AppMethodBeat.i(98238);
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
    AppMethodBeat.o(98238);
  }
  
  public static void upZipFiles(File paramFile, String paramString)
  {
    AppMethodBeat.i(98237);
    try
    {
      upZipFileFromInputStream(new FileInputStream(paramFile), new File(paramString));
      AppMethodBeat.o(98237);
      return;
    }
    catch (Exception paramFile)
    {
      AppMethodBeat.o(98237);
    }
  }
  
  public static void zipFile(File paramFile, String paramString)
  {
    AppMethodBeat.i(98232);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      AppMethodBeat.o(98232);
      return;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new byte[49152];
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    paramString = new ZipOutputStream(new FileOutputStream(new File(paramString, paramFile.getName() + ".zip")));
    paramString.setLevel(9);
    paramString.setMethod(8);
    paramString.putNextEntry(new ZipEntry(paramFile.getName()));
    for (;;)
    {
      int i = localFileInputStream.read((byte[])localObject);
      if (i == -1) {
        break;
      }
      paramString.write((byte[])localObject, 0, i);
    }
    paramString.finish();
    paramString.close();
    localFileInputStream.close();
    AppMethodBeat.o(98232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */