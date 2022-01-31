package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

public final class r
{
  public static byte[] A(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    Object localObject = null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte, 0, localInflater.inflate(arrayOfByte));
      }
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Zlib", localException, "exception when loop read byte", new Object[0]);
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          if (localException == null) {
            break;
          }
          throw new Exception(localException);
          arrayOfByte = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException2)
          {
            ab.printErrStackTrace("MicroMsg.Zlib", localIOException2, "", new Object[0]);
          }
        }
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Zlib", localIOException3, "", new Object[0]);
        }
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.Zlib", localIOException1, "", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 71	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 72	java/util/zip/Deflater:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 73	java/util/zip/Deflater:reset	()V
    //   14: aload 4
    //   16: aload_0
    //   17: invokevirtual 74	java/util/zip/Deflater:setInput	([B)V
    //   20: aload 4
    //   22: invokevirtual 77	java/util/zip/Deflater:finish	()V
    //   25: new 25	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: aload_0
    //   30: arraylength
    //   31: invokespecial 28	java/io/ByteArrayOutputStream:<init>	(I)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: sipush 1024
    //   40: newarray byte
    //   42: astore_3
    //   43: aload_2
    //   44: astore_1
    //   45: aload 4
    //   47: invokevirtual 78	java/util/zip/Deflater:finished	()Z
    //   50: ifne +54 -> 104
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: aload_3
    //   57: iconst_0
    //   58: aload 4
    //   60: aload_3
    //   61: invokevirtual 81	java/util/zip/Deflater:deflate	([B)I
    //   64: invokevirtual 40	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -24 -> 43
    //   70: astore_3
    //   71: aload_2
    //   72: astore_1
    //   73: ldc 42
    //   75: aload_3
    //   76: ldc 65
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 50	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   95: aload_0
    //   96: astore_1
    //   97: aload 4
    //   99: invokevirtual 82	java/util/zip/Deflater:end	()V
    //   102: aload_1
    //   103: areturn
    //   104: aload_2
    //   105: astore_1
    //   106: aload_2
    //   107: invokevirtual 63	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: astore_3
    //   111: aload_3
    //   112: astore_1
    //   113: aload_2
    //   114: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   117: goto -20 -> 97
    //   120: astore_0
    //   121: ldc 42
    //   123: aload_0
    //   124: ldc 65
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 50	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: goto -36 -> 97
    //   136: astore_1
    //   137: ldc 42
    //   139: aload_1
    //   140: ldc 65
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 50	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: astore_1
    //   151: goto -54 -> 97
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_1
    //   157: new 69	java/lang/OutOfMemoryError
    //   160: dup
    //   161: new 84	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 86
    //   167: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: arraylength
    //   172: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 98	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   181: athrow
    //   182: astore_0
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 53	java/io/ByteArrayOutputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: ldc 42
    //   196: aload_1
    //   197: ldc 65
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 50	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -15 -> 191
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -29 -> 183
    //   215: astore_1
    //   216: aload_2
    //   217: astore_1
    //   218: goto -61 -> 157
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_2
    //   224: goto -153 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramArrayOfByte	byte[]
    //   36	77	1	localObject1	Object
    //   136	4	1	localIOException1	IOException
    //   150	1	1	arrayOfByte1	byte[]
    //   154	1	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   156	32	1	localObject2	Object
    //   193	4	1	localIOException2	IOException
    //   211	1	1	localObject3	Object
    //   215	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   217	1	1	localByteArrayOutputStream1	ByteArrayOutputStream
    //   34	190	2	localByteArrayOutputStream2	ByteArrayOutputStream
    //   42	19	3	arrayOfByte2	byte[]
    //   70	6	3	localException1	Exception
    //   110	2	3	arrayOfByte3	byte[]
    //   221	1	3	localException2	Exception
    //   7	91	4	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   37	43	70	java/lang/Exception
    //   45	53	70	java/lang/Exception
    //   55	67	70	java/lang/Exception
    //   106	111	70	java/lang/Exception
    //   113	117	120	java/io/IOException
    //   91	95	136	java/io/IOException
    //   25	35	154	java/lang/OutOfMemoryError
    //   37	43	182	finally
    //   45	53	182	finally
    //   55	67	182	finally
    //   73	85	182	finally
    //   106	111	182	finally
    //   157	182	182	finally
    //   187	191	193	java/io/IOException
    //   25	35	209	finally
    //   37	43	215	java/lang/OutOfMemoryError
    //   45	53	215	java/lang/OutOfMemoryError
    //   55	67	215	java/lang/OutOfMemoryError
    //   106	111	215	java/lang/OutOfMemoryError
    //   25	35	221	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.r
 * JD-Core Version:    0.7.0.1
 */