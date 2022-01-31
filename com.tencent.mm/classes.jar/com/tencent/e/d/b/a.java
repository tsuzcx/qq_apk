package com.tencent.e.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  private static final byte[] Bko = { 127, 69, 76, 70 };
  
  /* Error */
  public static byte[] awB(String paramString)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 26	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: new 32	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokevirtual 36	java/io/FileInputStream:available	()I
    //   22: invokespecial 38	java/io/ByteArrayOutputStream:<init>	(I)V
    //   25: astore_1
    //   26: aload_2
    //   27: aload_1
    //   28: invokestatic 44	com/tencent/e/d/b/b:copyLarge	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   31: pop2
    //   32: aload_1
    //   33: invokevirtual 48	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +18 -> 56
    //   41: aload_2
    //   42: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   45: aload_1
    //   46: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   49: ldc 18
    //   51: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: areturn
    //   56: ldc 57
    //   58: invokevirtual 62	java/lang/String:getBytes	()[B
    //   61: astore_0
    //   62: goto -21 -> 41
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   74: aload_1
    //   75: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   78: ldc 18
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
  
  public static boolean awz(String paramString)
  {
    AppMethodBeat.i(114515);
    byte[] arrayOfByte = new byte[Bko.length];
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      try
      {
        if (localFileInputStream.read(arrayOfByte, 0, Bko.length) == arrayOfByte.length) {
          break label87;
        }
        paramString = new IOException("Read bytes less than " + arrayOfByte.length);
        AppMethodBeat.o(114515);
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
    b.closeQuietly(localFileInputStream);
    AppMethodBeat.o(114515);
    throw paramString;
    label87:
    i = 0;
    while (i < Bko.length)
    {
      int j = Bko[i];
      int k = arrayOfByte[i];
      if (j != k)
      {
        b.closeQuietly(localFileInputStream);
        AppMethodBeat.o(114515);
        return false;
      }
      i += 1;
    }
    b.closeQuietly(localFileInputStream);
    AppMethodBeat.o(114515);
    return true;
  }
  
  /* Error */
  public static byte[] fd(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 92
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 94	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 99	java/io/File:exists	()Z
    //   20: ifne +10 -> 30
    //   23: ldc 92
    //   25: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: new 26	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_0
    //   39: iload_1
    //   40: newarray byte
    //   42: astore 5
    //   44: aload_0
    //   45: aload 5
    //   47: iload_2
    //   48: iload_1
    //   49: iload_2
    //   50: isub
    //   51: invokevirtual 103	java/io/FileInputStream:read	([BII)I
    //   54: istore 4
    //   56: iload_2
    //   57: istore_3
    //   58: iload 4
    //   60: iconst_m1
    //   61: if_icmpeq +15 -> 76
    //   64: iload_2
    //   65: iload 4
    //   67: iadd
    //   68: istore_3
    //   69: iload_3
    //   70: istore_2
    //   71: iload_3
    //   72: iload_1
    //   73: if_icmplt -29 -> 44
    //   76: iload_3
    //   77: ifne +14 -> 91
    //   80: aload_0
    //   81: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   84: ldc 92
    //   86: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aconst_null
    //   90: areturn
    //   91: iload_3
    //   92: iload_1
    //   93: if_icmpge +74 -> 167
    //   96: iload_3
    //   97: newarray byte
    //   99: astore 6
    //   101: aload 5
    //   103: iconst_0
    //   104: aload 6
    //   106: iconst_0
    //   107: iload_3
    //   108: invokestatic 109	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   111: aload 6
    //   113: astore 5
    //   115: aload_0
    //   116: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   119: ldc 92
    //   121: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload 5
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   134: ldc 92
    //   136: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aconst_null
    //   140: areturn
    //   141: astore 5
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: invokestatic 52	com/tencent/e/d/b/b:closeQuietly	(Ljava/io/Closeable;)V
    //   149: ldc 92
    //   151: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload 5
    //   156: athrow
    //   157: astore 5
    //   159: goto -14 -> 145
    //   162: astore 5
    //   164: goto -34 -> 130
    //   167: goto -52 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString	String
    //   0	170	1	paramInt	int
    //   1	70	2	i	int
    //   57	51	3	j	int
    //   54	14	4	k	int
    //   42	83	5	localObject1	Object
    //   141	14	5	localObject2	Object
    //   157	1	5	localObject3	Object
    //   162	1	5	localThrowable	java.lang.Throwable
    //   99	13	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	39	127	java/lang/Throwable
    //   30	39	141	finally
    //   39	44	157	finally
    //   44	56	157	finally
    //   96	111	157	finally
    //   39	44	162	java/lang/Throwable
    //   44	56	162	java/lang/Throwable
    //   96	111	162	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.e.d.b.a
 * JD-Core Version:    0.7.0.1
 */