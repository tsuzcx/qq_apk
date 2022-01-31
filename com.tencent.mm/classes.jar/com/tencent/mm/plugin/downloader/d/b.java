package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
{
  /* Error */
  public static boolean JA(String paramString)
  {
    // Byte code:
    //   0: sipush 2302
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 7
    //   9: new 19	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_0
    //   14: ldc 21
    //   16: invokespecial 25	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: invokestatic 29	com/tencent/mm/plugin/downloader/d/b:e	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   24: astore 8
    //   26: aload 8
    //   28: getfield 35	android/util/Pair:first	Ljava/lang/Object;
    //   31: checkcast 37	java/nio/ByteBuffer
    //   34: astore 7
    //   36: aload 8
    //   38: getfield 40	android/util/Pair:second	Ljava/lang/Object;
    //   41: checkcast 42	java/lang/Long
    //   44: invokevirtual 46	java/lang/Long:longValue	()J
    //   47: lstore_1
    //   48: aload_0
    //   49: lload_1
    //   50: invokestatic 52	com/tencent/mm/plugin/downloader/d/k:c	(Ljava/io/RandomAccessFile;J)Z
    //   53: ifeq +41 -> 94
    //   56: new 8	com/tencent/mm/plugin/downloader/d/b$b
    //   59: dup
    //   60: ldc 54
    //   62: invokespecial 57	com/tencent/mm/plugin/downloader/d/b$b:<init>	(Ljava/lang/String;)V
    //   65: astore 7
    //   67: sipush 2302
    //   70: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload 7
    //   75: athrow
    //   76: astore 7
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   86: sipush 2302
    //   89: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload 7
    //   96: lload_1
    //   97: invokestatic 67	com/tencent/mm/plugin/downloader/d/b:b	(Ljava/nio/ByteBuffer;J)J
    //   100: lstore_3
    //   101: aload_0
    //   102: lload_3
    //   103: invokestatic 70	com/tencent/mm/plugin/downloader/d/b:b	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   106: astore 8
    //   108: aload 8
    //   110: getfield 35	android/util/Pair:first	Ljava/lang/Object;
    //   113: checkcast 37	java/nio/ByteBuffer
    //   116: astore 9
    //   118: aload 8
    //   120: getfield 40	android/util/Pair:second	Ljava/lang/Object;
    //   123: checkcast 42	java/lang/Long
    //   126: invokevirtual 46	java/lang/Long:longValue	()J
    //   129: lstore 5
    //   131: new 6	com/tencent/mm/plugin/downloader/d/b$a
    //   134: dup
    //   135: aload 9
    //   137: invokestatic 74	com/tencent/mm/plugin/downloader/d/b:y	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   140: lload 5
    //   142: lload_3
    //   143: lload_1
    //   144: aload 7
    //   146: iconst_0
    //   147: invokespecial 77	com/tencent/mm/plugin/downloader/d/b$a:<init>	(Ljava/nio/ByteBuffer;JJJLjava/nio/ByteBuffer;B)V
    //   150: pop
    //   151: aload_0
    //   152: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   155: sipush 2302
    //   158: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iconst_1
    //   162: ireturn
    //   163: astore 7
    //   165: aconst_null
    //   166: astore_0
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 64	java/io/RandomAccessFile:close	()V
    //   175: sipush 2302
    //   178: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload 7
    //   183: athrow
    //   184: astore 7
    //   186: goto -19 -> 167
    //   189: astore_0
    //   190: aload 7
    //   192: astore_0
    //   193: goto -115 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString	String
    //   47	97	1	l1	long
    //   100	43	3	l2	long
    //   129	12	5	l3	long
    //   7	67	7	localObject1	Object
    //   76	69	7	localb	b
    //   163	19	7	localObject2	Object
    //   184	7	7	localObject3	Object
    //   24	95	8	localPair	Pair
    //   116	20	9	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   20	76	76	com/tencent/mm/plugin/downloader/d/b$b
    //   94	151	76	com/tencent/mm/plugin/downloader/d/b$b
    //   9	20	163	finally
    //   20	76	184	finally
    //   94	151	184	finally
    //   9	20	189	com/tencent/mm/plugin/downloader/d/b$b
  }
  
  public static long b(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(2304);
    long l = k.C(paramByteBuffer);
    if (l >= paramLong)
    {
      paramByteBuffer = new b("ZIP Central Directory offset out of range: " + l + ". ZIP End of Central Directory offset: " + paramLong);
      AppMethodBeat.o(2304);
      throw paramByteBuffer;
    }
    if (k.D(paramByteBuffer) + l != paramLong)
    {
      paramByteBuffer = new b("ZIP Central Directory is not immediately followed by End of Central Directory");
      AppMethodBeat.o(2304);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(2304);
    return l;
  }
  
  public static Pair<ByteBuffer, Long> b(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    AppMethodBeat.i(2307);
    if (paramLong < 32L)
    {
      paramRandomAccessFile = new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(2307);
      throw paramRandomAccessFile;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    if ((localByteBuffer.getLong(8) != 2334950737559900225L) || (localByteBuffer.getLong(16) != 3617552046287187010L))
    {
      paramRandomAccessFile = new b("No APK Signing Block before ZIP Central Directory");
      AppMethodBeat.o(2307);
      throw paramRandomAccessFile;
    }
    long l1 = localByteBuffer.getLong(0);
    if ((l1 < localByteBuffer.capacity()) || (l1 > 2147483639L))
    {
      paramRandomAccessFile = new b("APK Signing Block size out of range: ".concat(String.valueOf(l1)));
      AppMethodBeat.o(2307);
      throw paramRandomAccessFile;
    }
    int i = (int)(8L + l1);
    paramLong -= i;
    if (paramLong < 0L)
    {
      paramRandomAccessFile = new b("APK Signing Block offset out of range: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(2307);
      throw paramRandomAccessFile;
    }
    localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    long l2 = localByteBuffer.getLong(0);
    if (l2 != l1)
    {
      paramRandomAccessFile = new b("APK Signing Block sizes in header and footer do not match: " + l2 + " vs " + l1);
      AppMethodBeat.o(2307);
      throw paramRandomAccessFile;
    }
    paramRandomAccessFile = Pair.create(localByteBuffer, Long.valueOf(paramLong));
    AppMethodBeat.o(2307);
    return paramRandomAccessFile;
  }
  
  public static ByteBuffer d(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(2305);
    if (paramInt < 8)
    {
      paramByteBuffer = new IllegalArgumentException("end < start: " + paramInt + " < 8");
      AppMethodBeat.o(2305);
      throw paramByteBuffer;
    }
    int i = paramByteBuffer.capacity();
    if (paramInt > paramByteBuffer.capacity())
    {
      paramByteBuffer = new IllegalArgumentException("end > capacity: " + paramInt + " > " + i);
      AppMethodBeat.o(2305);
      throw paramByteBuffer;
    }
    i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    try
    {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(paramInt);
      paramByteBuffer.position(8);
      ByteBuffer localByteBuffer = paramByteBuffer.slice();
      localByteBuffer.order(paramByteBuffer.order());
      return localByteBuffer;
    }
    finally
    {
      paramByteBuffer.position(0);
      paramByteBuffer.limit(i);
      paramByteBuffer.position(j);
      AppMethodBeat.o(2305);
    }
  }
  
  public static Pair<ByteBuffer, Long> e(RandomAccessFile paramRandomAccessFile)
  {
    AppMethodBeat.i(2303);
    paramRandomAccessFile = k.f(paramRandomAccessFile);
    if (paramRandomAccessFile == null)
    {
      paramRandomAccessFile = new b("Not an APK file: ZIP End of Central Directory record not found");
      AppMethodBeat.o(2303);
      throw paramRandomAccessFile;
    }
    AppMethodBeat.o(2303);
    return paramRandomAccessFile;
  }
  
  public static ByteBuffer e(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(2306);
    if (paramInt < 0)
    {
      paramByteBuffer = new IllegalArgumentException("size: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(2306);
      throw paramByteBuffer;
    }
    int i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    paramInt = j + paramInt;
    if ((paramInt < j) || (paramInt > i))
    {
      paramByteBuffer = new BufferUnderflowException();
      AppMethodBeat.o(2306);
      throw paramByteBuffer;
    }
    paramByteBuffer.limit(paramInt);
    try
    {
      ByteBuffer localByteBuffer = paramByteBuffer.slice();
      localByteBuffer.order(paramByteBuffer.order());
      paramByteBuffer.position(paramInt);
      return localByteBuffer;
    }
    finally
    {
      paramByteBuffer.limit(i);
      AppMethodBeat.o(2306);
    }
  }
  
  private static ByteBuffer y(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(2308);
    z(paramByteBuffer);
    paramByteBuffer = d(paramByteBuffer, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8)
      {
        paramByteBuffer = new b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
        AppMethodBeat.o(2308);
        throw paramByteBuffer;
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L))
      {
        paramByteBuffer = new b("APK Signing Block entry #" + i + " size out of range: " + l);
        AppMethodBeat.o(2308);
        throw paramByteBuffer;
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining())
      {
        paramByteBuffer = new b("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
        AppMethodBeat.o(2308);
        throw paramByteBuffer;
      }
      if (paramByteBuffer.getInt() == 1896449818)
      {
        paramByteBuffer = e(paramByteBuffer, j - 4);
        AppMethodBeat.o(2308);
        return paramByteBuffer;
      }
      paramByteBuffer.position(k + j);
    }
    paramByteBuffer = new b("No APK Signature Scheme v2 block in APK Signing Block");
    AppMethodBeat.o(2308);
    throw paramByteBuffer;
  }
  
  public static void z(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(2309);
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN)
    {
      paramByteBuffer = new IllegalArgumentException("ByteBuffer byte order must be little endian");
      AppMethodBeat.o(2309);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(2309);
  }
  
  public static final class b
    extends Exception
  {
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.b
 * JD-Core Version:    0.7.0.1
 */