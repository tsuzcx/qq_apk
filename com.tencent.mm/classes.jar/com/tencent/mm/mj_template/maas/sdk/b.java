package com.tencent.mm.mj_template.maas.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class b
{
  /* Error */
  public static int a(java.io.File paramFile1, java.io.File paramFile2, java.io.File paramFile3)
  {
    // Byte code:
    //   0: ldc 7
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 19	java/io/File:length	()J
    //   9: lconst_0
    //   10: lcmp
    //   11: ifgt +10 -> 21
    //   14: ldc 7
    //   16: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_3
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 19	java/io/File:length	()J
    //   25: lconst_0
    //   26: lcmp
    //   27: ifgt +10 -> 37
    //   30: ldc 7
    //   32: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_2
    //   36: ireturn
    //   37: new 24	java/io/BufferedInputStream
    //   40: dup
    //   41: new 26	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 33	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore 4
    //   54: aload_2
    //   55: invokevirtual 19	java/io/File:length	()J
    //   58: l2i
    //   59: newarray byte
    //   61: astore 5
    //   63: new 26	java/io/FileInputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: astore_2
    //   72: aload_2
    //   73: aload 5
    //   75: iconst_0
    //   76: aload 5
    //   78: arraylength
    //   79: invokestatic 38	com/tencent/mm/mj_template/maas/sdk/a:a	(Ljava/io/InputStream;[BII)Z
    //   82: pop
    //   83: aload_2
    //   84: invokevirtual 44	java/io/InputStream:close	()V
    //   87: aload_0
    //   88: invokevirtual 19	java/io/File:length	()J
    //   91: l2i
    //   92: istore_3
    //   93: iload_3
    //   94: newarray byte
    //   96: astore_0
    //   97: aload 4
    //   99: aload_0
    //   100: iconst_0
    //   101: iload_3
    //   102: invokestatic 38	com/tencent/mm/mj_template/maas/sdk/a:a	(Ljava/io/InputStream;[BII)Z
    //   105: pop
    //   106: aload 4
    //   108: invokevirtual 44	java/io/InputStream:close	()V
    //   111: aload_0
    //   112: iload_3
    //   113: aload 5
    //   115: invokestatic 47	com/tencent/mm/mj_template/maas/sdk/b:a	([BI[B)[B
    //   118: astore_0
    //   119: new 49	java/io/FileOutputStream
    //   122: dup
    //   123: aload_1
    //   124: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: astore_1
    //   128: aload_1
    //   129: aload_0
    //   130: invokevirtual 56	java/io/OutputStream:write	([B)V
    //   133: aload_1
    //   134: invokevirtual 57	java/io/OutputStream:close	()V
    //   137: ldc 7
    //   139: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: iconst_1
    //   143: ireturn
    //   144: astore_0
    //   145: aload_2
    //   146: invokevirtual 44	java/io/InputStream:close	()V
    //   149: ldc 7
    //   151: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: aload_1
    //   158: invokevirtual 57	java/io/OutputStream:close	()V
    //   161: ldc 7
    //   163: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramFile1	java.io.File
    //   0	168	1	paramFile2	java.io.File
    //   0	168	2	paramFile3	java.io.File
    //   92	21	3	i	int
    //   52	55	4	localBufferedInputStream	java.io.BufferedInputStream
    //   61	53	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	83	144	finally
    //   128	133	156	finally
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(240078);
    if (paramArrayOfByte2.length < 32)
    {
      paramArrayOfByte1 = new IOException("Header.len < 32");
      AppMethodBeat.o(240078);
      throw paramArrayOfByte1;
    }
    if ((paramArrayOfByte2[0] != 66) || (paramArrayOfByte2[1] != 83) || (paramArrayOfByte2[2] != 68) || (paramArrayOfByte2[3] != 73) || (paramArrayOfByte2[4] != 70) || (paramArrayOfByte2[5] != 70) || (paramArrayOfByte2[6] != 52) || (paramArrayOfByte2[7] != 48))
    {
      paramArrayOfByte1 = new IOException("Invalid header signature");
      AppMethodBeat.o(240078);
      throw paramArrayOfByte1;
    }
    long l1 = a.z(paramArrayOfByte2, 8);
    long l2 = a.z(paramArrayOfByte2, 16);
    long l3 = a.z(paramArrayOfByte2, 24);
    if ((l1 < 0L) || (l2 < 0L) || (l3 < 0L))
    {
      paramArrayOfByte1 = new IOException("Invalid header lengths");
      AppMethodBeat.o(240078);
      throw paramArrayOfByte1;
    }
    InputStream localInputStream1 = a.a(paramArrayOfByte2, 32L, l1);
    InputStream localInputStream2 = a.a(paramArrayOfByte2, 32L + l1, l2);
    paramArrayOfByte2 = a.a(paramArrayOfByte2, l1 + 32L + l2, -1L);
    byte[] arrayOfByte1 = new byte[(int)l3];
    int i = 0;
    int[] arrayOfInt = new int[3];
    byte[] arrayOfByte2 = new byte[8];
    int j = 0;
    while (j < l3)
    {
      int k = 0;
      while (k <= 2)
      {
        if (a.a(localInputStream1, arrayOfByte2) < 8L)
        {
          paramArrayOfByte1 = new IOException("Failed to read control data");
          AppMethodBeat.o(240078);
          throw paramArrayOfByte1;
        }
        arrayOfInt[k] = ((int)a.z(arrayOfByte2, 0));
        k += 1;
      }
      if (arrayOfInt[0] + j > l3)
      {
        paramArrayOfByte1 = new IOException("Corrupt by wrong patch file.");
        AppMethodBeat.o(240078);
        throw paramArrayOfByte1;
      }
      if (!a.a(localInputStream2, arrayOfByte1, j, arrayOfInt[0]))
      {
        paramArrayOfByte1 = new IOException("Corrupt by wrong patch file.");
        AppMethodBeat.o(240078);
        throw paramArrayOfByte1;
      }
      k = 0;
      while (k < arrayOfInt[0])
      {
        if ((i + k >= 0) && (i + k < paramInt))
        {
          m = j + k;
          arrayOfByte1[m] = ((byte)(arrayOfByte1[m] + paramArrayOfByte1[(i + k)]));
        }
        k += 1;
      }
      j = arrayOfInt[0] + j;
      int m = arrayOfInt[0];
      if (arrayOfInt[1] + j > l3)
      {
        paramArrayOfByte1 = new IOException("Corrupt by wrong patch file.");
        AppMethodBeat.o(240078);
        throw paramArrayOfByte1;
      }
      if (!a.a(paramArrayOfByte2, arrayOfByte1, j, arrayOfInt[1]))
      {
        paramArrayOfByte1 = new IOException("Corrupt by wrong patch file.");
        AppMethodBeat.o(240078);
        throw paramArrayOfByte1;
      }
      k = arrayOfInt[1];
      i = arrayOfInt[2] + (m + i);
      j += k;
    }
    localInputStream1.close();
    localInputStream2.close();
    paramArrayOfByte2.close();
    AppMethodBeat.o(240078);
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.sdk.b
 * JD-Core Version:    0.7.0.1
 */