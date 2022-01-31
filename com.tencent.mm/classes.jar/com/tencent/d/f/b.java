package com.tencent.d.f;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public final class b
{
  /* Error */
  public static byte[] bO(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 12	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 16	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_0
    //   9: new 18	java/util/zip/InflaterInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 21	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: new 23	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 26	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 30	java/util/zip/InflaterInputStream:read	()I
    //   30: istore_1
    //   31: iload_1
    //   32: iconst_m1
    //   33: if_icmpeq +47 -> 80
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 34	java/io/ByteArrayOutputStream:write	(I)V
    //   41: goto -15 -> 26
    //   44: astore 4
    //   46: new 36	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 38
    //   52: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload 4
    //   57: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 55	com/tencent/d/f/h:co	(Ljava/lang/Object;)V
    //   66: aload_0
    //   67: invokevirtual 58	java/io/ByteArrayInputStream:close	()V
    //   70: aload_2
    //   71: invokevirtual 59	java/util/zip/InflaterInputStream:close	()V
    //   74: aload_3
    //   75: invokevirtual 60	java/io/ByteArrayOutputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_3
    //   81: invokevirtual 64	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   84: astore 4
    //   86: aload_0
    //   87: invokevirtual 58	java/io/ByteArrayInputStream:close	()V
    //   90: aload_2
    //   91: invokevirtual 59	java/util/zip/InflaterInputStream:close	()V
    //   94: aload_3
    //   95: invokevirtual 60	java/io/ByteArrayOutputStream:close	()V
    //   98: aload 4
    //   100: areturn
    //   101: astore_0
    //   102: aload 4
    //   104: areturn
    //   105: astore 4
    //   107: aload_0
    //   108: invokevirtual 58	java/io/ByteArrayInputStream:close	()V
    //   111: aload_2
    //   112: invokevirtual 59	java/util/zip/InflaterInputStream:close	()V
    //   115: aload_3
    //   116: invokevirtual 60	java/io/ByteArrayOutputStream:close	()V
    //   119: aload 4
    //   121: athrow
    //   122: astore_0
    //   123: goto -4 -> 119
    //   126: astore_0
    //   127: goto -49 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramArrayOfByte	byte[]
    //   30	8	1	i	int
    //   17	95	2	localInflaterInputStream	java.util.zip.InflaterInputStream
    //   25	91	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   44	12	4	localException	Exception
    //   84	19	4	arrayOfByte	byte[]
    //   105	15	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	31	44	java/lang/Exception
    //   36	41	44	java/lang/Exception
    //   80	86	44	java/lang/Exception
    //   86	98	101	java/io/IOException
    //   26	31	105	finally
    //   36	41	105	finally
    //   46	66	105	finally
    //   80	86	105	finally
    //   107	119	122	java/io/IOException
    //   66	78	126	java/io/IOException
  }
  
  public static byte[] l(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.finish();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label69:
      label80:
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      h.co("deflater(), exception: " + paramArrayOfByte);
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDeflaterOutputStream.close();
        return null;
        paramArrayOfByte = finally;
        try
        {
          localByteArrayOutputStream.close();
          localDeflaterOutputStream.close();
          throw paramArrayOfByte;
        }
        catch (IOException localIOException1)
        {
          break label80;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        break label69;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.f.b
 * JD-Core Version:    0.7.0.1
 */