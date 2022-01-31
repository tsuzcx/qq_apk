package com.tencent.map.lib.util;

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
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] inflate(byte[] paramArrayOfByte)
  {
    return inflate(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public static byte[] inflate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: new 46	java/util/zip/InflaterInputStream
    //   3: dup
    //   4: new 48	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: iload_1
    //   10: iload_2
    //   11: invokespecial 50	java/io/ByteArrayInputStream:<init>	([BII)V
    //   14: invokespecial 53	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: new 15	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 16	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_0
    //   26: sipush 1024
    //   29: newarray byte
    //   31: astore 4
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 57	java/util/zip/InflaterInputStream:read	([B)I
    //   39: istore_1
    //   40: iload_1
    //   41: ifle +11 -> 52
    //   44: aload_0
    //   45: aload 4
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 58	java/io/ByteArrayOutputStream:write	([BII)V
    //   52: iload_1
    //   53: ifgt -20 -> 33
    //   56: aload_3
    //   57: invokevirtual 59	java/util/zip/InflaterInputStream:close	()V
    //   60: aload_0
    //   61: invokevirtual 38	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: astore_3
    //   65: aload_0
    //   66: invokevirtual 60	java/io/ByteArrayOutputStream:close	()V
    //   69: aload_3
    //   70: areturn
    //   71: astore_0
    //   72: aload_3
    //   73: invokevirtual 59	java/util/zip/InflaterInputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: goto -3 -> 76
    //   82: astore_3
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: aload_3
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramArrayOfByte	byte[]
    //   0	89	1	paramInt1	int
    //   0	89	2	paramInt2	int
    //   17	56	3	localObject	Object
    //   82	6	3	localIOException	java.io.IOException
    //   31	15	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   33	40	71	java/io/IOException
    //   72	76	78	java/io/IOException
    //   56	60	82	java/io/IOException
    //   65	69	86	java/io/IOException
  }
  
  public static void upZipFile(File paramFile, String paramString)
  {
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
  }
  
  public static void upZipFileFromInputStream(InputStream paramInputStream, File paramFile)
  {
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
  }
  
  public static void upZipFiles(File paramFile, String paramString)
  {
    try
    {
      upZipFileFromInputStream(new FileInputStream(paramFile), new File(paramString));
      return;
    }
    catch (Exception paramFile) {}
  }
  
  public static void zipFile(File paramFile, String paramString)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.lib.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */