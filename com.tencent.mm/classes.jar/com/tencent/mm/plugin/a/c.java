package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c
{
  public static long A(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(117834);
    byte[] arrayOfByte = new byte[8];
    Arrays.fill(arrayOfByte, (byte)0);
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 4, 4);
    long l = ae(arrayOfByte);
    AppMethodBeat.o(117834);
    return l;
  }
  
  public static a a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(117835);
    try
    {
      i = paramRandomAccessFile.read(paramArrayOfByte);
      if (i >= 8)
      {
        j = readInt(paramArrayOfByte, 0);
        k = readInt(paramArrayOfByte, 4);
        if (k == paramInt)
        {
          l = paramRandomAccessFile.getFilePointer() - i;
          if (k == a.aES) {}
          for (paramRandomAccessFile = new i(j, l, k);; paramRandomAccessFile = new e(j, l, k))
          {
            AppMethodBeat.o(117835);
            return paramRandomAccessFile;
            if (k != a.aET) {
              break;
            }
          }
        }
      }
    }
    catch (Exception paramRandomAccessFile)
    {
      for (;;)
      {
        int i;
        int j;
        int k;
        long l;
        ab.printErrStackTrace("MicroMsg.AtomUtil", paramRandomAccessFile, "", new Object[0]);
        ab.e("MicroMsg.AtomUtil", "find Atom error: " + paramRandomAccessFile.toString());
        paramRandomAccessFile = null;
        continue;
        if (k == a.aEV)
        {
          paramRandomAccessFile = new h(j, l, k);
        }
        else
        {
          paramRandomAccessFile = new a(j, l, k, 0L);
          continue;
          if ((k == a.aEQ) || (k == a.aEU)) {
            i = paramRandomAccessFile.read(paramArrayOfByte);
          } else if (a(paramRandomAccessFile, j - 8)) {
            i = paramRandomAccessFile.read(paramArrayOfByte);
          } else {
            paramRandomAccessFile = null;
          }
        }
      }
    }
  }
  
  public static boolean a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    AppMethodBeat.i(117836);
    long l = 0L;
    while (paramLong > 2147483647L)
    {
      l += paramRandomAccessFile.skipBytes(2147483647);
      paramLong -= 2147483647L;
    }
    l += paramRandomAccessFile.skipBytes((int)paramLong);
    if (l != paramLong)
    {
      ab.w("MicroMsg.AtomUtil", "can not skip.skip: " + paramLong + " trueSkip : " + l);
      AppMethodBeat.o(117836);
      return false;
    }
    AppMethodBeat.o(117836);
    return true;
  }
  
  public static int aS(String paramString)
  {
    AppMethodBeat.i(117833);
    int k = paramString.length();
    int j = 0;
    int m;
    for (int i = 0; j < k; i = i << 8 | m)
    {
      m = paramString.charAt(j);
      j += 1;
    }
    AppMethodBeat.o(117833);
    return i;
  }
  
  public static long ae(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 56 | (paramArrayOfByte[1] & 0xFF) << 48 | (paramArrayOfByte[2] & 0xFF) << 40 | (paramArrayOfByte[3] & 0xFF) << 32 | (paramArrayOfByte[4] & 0xFF) << 24 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[6] & 0xFF) << 8 | paramArrayOfByte[7] & 0xFF;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    AppMethodBeat.i(117832);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(117832);
      return true;
    }
    AppMethodBeat.o(117832);
    return false;
  }
  
  public static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    return (paramArrayOfByte[i] & 0xFF) << 16 | (paramInt & 0xFF) << 24 | (paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[(j + 1)] & 0xFF;
  }
  
  /* Error */
  public static boolean wE(String paramString)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 160	com/tencent/mm/plugin/a/c:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 158
    //   14: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: new 162	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: astore_0
    //   32: bipush 8
    //   34: newarray byte
    //   36: astore 5
    //   38: aload 4
    //   40: astore_0
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: bipush 8
    //   48: invokevirtual 168	java/io/InputStream:read	([BII)I
    //   51: istore_1
    //   52: iload_1
    //   53: bipush 8
    //   55: if_icmpge +31 -> 86
    //   58: aload 4
    //   60: invokevirtual 172	java/io/InputStream:close	()V
    //   63: ldc 158
    //   65: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iconst_0
    //   69: ireturn
    //   70: astore_0
    //   71: ldc 72
    //   73: aload_0
    //   74: ldc 74
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: goto -20 -> 63
    //   86: aload 4
    //   88: astore_0
    //   89: aload 5
    //   91: iconst_0
    //   92: invokestatic 48	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   95: istore_1
    //   96: aload 4
    //   98: astore_0
    //   99: aload 5
    //   101: iconst_4
    //   102: invokestatic 48	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   105: istore_2
    //   106: aload 4
    //   108: astore_0
    //   109: getstatic 175	com/tencent/mm/plugin/a/a:aEp	I
    //   112: istore_3
    //   113: iload_2
    //   114: iload_3
    //   115: if_icmpne +35 -> 150
    //   118: iload_1
    //   119: ifle +31 -> 150
    //   122: aload 4
    //   124: invokevirtual 172	java/io/InputStream:close	()V
    //   127: ldc 158
    //   129: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_0
    //   135: ldc 72
    //   137: aload_0
    //   138: ldc 74
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: goto -20 -> 127
    //   150: aload 4
    //   152: invokevirtual 172	java/io/InputStream:close	()V
    //   155: ldc 158
    //   157: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_0
    //   163: ldc 72
    //   165: aload_0
    //   166: ldc 74
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   175: goto -20 -> 155
    //   178: astore 5
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: astore_0
    //   186: ldc 72
    //   188: aload 5
    //   190: ldc 74
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aload 4
    //   201: ifnull +8 -> 209
    //   204: aload 4
    //   206: invokevirtual 172	java/io/InputStream:close	()V
    //   209: ldc 158
    //   211: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: iconst_0
    //   215: ireturn
    //   216: astore_0
    //   217: ldc 72
    //   219: aload_0
    //   220: ldc 74
    //   222: iconst_0
    //   223: anewarray 4	java/lang/Object
    //   226: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: goto -20 -> 209
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +7 -> 244
    //   240: aload_0
    //   241: invokevirtual 172	java/io/InputStream:close	()V
    //   244: ldc 158
    //   246: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload 4
    //   251: athrow
    //   252: astore_0
    //   253: ldc 72
    //   255: aload_0
    //   256: ldc 74
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 80	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: goto -21 -> 244
    //   268: astore 4
    //   270: goto -34 -> 236
    //   273: astore 5
    //   275: goto -92 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString	String
    //   51	68	1	i	int
    //   105	11	2	j	int
    //   112	4	3	k	int
    //   27	178	4	localFileInputStream	java.io.FileInputStream
    //   232	18	4	localObject1	Object
    //   268	1	4	localObject2	Object
    //   36	64	5	arrayOfByte	byte[]
    //   178	11	5	localException1	Exception
    //   273	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   58	63	70	java/io/IOException
    //   122	127	134	java/io/IOException
    //   150	155	162	java/io/IOException
    //   19	29	178	java/lang/Exception
    //   204	209	216	java/io/IOException
    //   19	29	232	finally
    //   240	244	252	java/io/IOException
    //   32	38	268	finally
    //   41	52	268	finally
    //   89	96	268	finally
    //   99	106	268	finally
    //   109	113	268	finally
    //   186	199	268	finally
    //   32	38	273	java/lang/Exception
    //   41	52	273	java/lang/Exception
    //   89	96	273	java/lang/Exception
    //   99	106	273	java/lang/Exception
    //   109	113	273	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.c
 * JD-Core Version:    0.7.0.1
 */