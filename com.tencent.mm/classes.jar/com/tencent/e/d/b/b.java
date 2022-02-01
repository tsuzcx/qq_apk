package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b
{
  private static final byte[] ahtG = { 127, 69, 76, 70 };
  
  public static boolean bFw(String paramString)
  {
    AppMethodBeat.i(138356);
    byte[] arrayOfByte = new byte[ahtG.length];
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      try
      {
        if (localFileInputStream.read(arrayOfByte, 0, ahtG.length) == arrayOfByte.length) {
          break label87;
        }
        paramString = new IOException("Read bytes less than " + arrayOfByte.length);
        AppMethodBeat.o(138356);
        throw paramString;
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        int i;
        FileInputStream localFileInputStream = null;
      }
    }
    c.closeQuietly(localFileInputStream);
    AppMethodBeat.o(138356);
    throw paramString;
    label87:
    i = 0;
    while (i < ahtG.length)
    {
      int j = ahtG[i];
      int k = arrayOfByte[i];
      if (j != k)
      {
        c.closeQuietly(localFileInputStream);
        AppMethodBeat.o(138356);
        return false;
      }
      i += 1;
    }
    c.closeQuietly(localFileInputStream);
    AppMethodBeat.o(138356);
    return true;
  }
  
  /* Error */
  public static byte[] bgq(String paramString)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 26	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 66	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokevirtual 70	java/io/FileInputStream:available	()I
    //   22: invokespecial 72	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: invokestatic 76	com/tencent/e/d/b/c:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   31: pop2
    //   32: aload_1
    //   33: invokevirtual 80	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +18 -> 56
    //   41: aload_2
    //   42: invokestatic 61	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   45: aload_1
    //   46: invokestatic 61	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   49: ldc 64
    //   51: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: areturn
    //   56: ldc 82
    //   58: invokevirtual 87	java/lang/String:getBytes	()[B
    //   61: astore_0
    //   62: goto -21 -> 41
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: invokestatic 61	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   74: aload_1
    //   75: invokestatic 61	com/tencent/e/d/b/c:closeQuietly	(Ljava/io/Closeable;)V
    //   78: ldc 64
    //   80: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -18 -> 70
    //   91: astore_0
    //   92: goto -22 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramString	String
    //   25	63	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   13	58	2	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   5	14	65	finally
    //   14	26	85	finally
    //   26	37	91	finally
    //   56	62	91	finally
  }
  
  public static byte[] jr(String paramString, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(138358);
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(138358);
      return null;
    }
    try
    {
      localFileInputStream = new FileInputStream(paramString);
    }
    finally
    {
      label44:
      int k;
      int j;
      byte[] arrayOfByte;
      label114:
      paramString = null;
      c.closeQuietly(paramString);
      AppMethodBeat.o(138358);
      return null;
    }
    try
    {
      paramString = new byte[paramInt];
      k = localFileInputStream.read(paramString, i, paramInt - i);
      j = i;
      if (k != -1)
      {
        j = i + k;
        i = j;
        if (j < paramInt) {
          break label44;
        }
      }
      if (j == 0)
      {
        c.closeQuietly(localFileInputStream);
        AppMethodBeat.o(138358);
        return null;
      }
      if (j >= paramInt) {
        break label147;
      }
      arrayOfByte = new byte[j];
      System.arraycopy(paramString, 0, arrayOfByte, 0, j);
      paramString = arrayOfByte;
    }
    finally
    {
      paramString = localFileInputStream;
      break label129;
      break label114;
    }
    c.closeQuietly(localFileInputStream);
    AppMethodBeat.o(138358);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.b.b
 * JD-Core Version:    0.7.0.1
 */