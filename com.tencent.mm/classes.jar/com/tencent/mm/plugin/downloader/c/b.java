package com.tencent.mm.plugin.downloader.c;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
{
  public static long b(ByteBuffer paramByteBuffer, long paramLong)
  {
    k.B(paramByteBuffer);
    long l = k.f(paramByteBuffer, paramByteBuffer.position() + 16);
    if (l >= paramLong) {
      throw new b.b("ZIP Central Directory offset out of range: " + l + ". ZIP End of Central Directory offset: " + paramLong);
    }
    k.B(paramByteBuffer);
    if (k.f(paramByteBuffer, paramByteBuffer.position() + 12) + l != paramLong) {
      throw new b.b("ZIP Central Directory is not immediately followed by End of Central Directory");
    }
    return l;
  }
  
  public static Pair<ByteBuffer, Long> b(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    if (paramLong < 32L) {
      throw new b.b("APK too small for APK Signing Block. ZIP Central Directory offset: " + paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    if ((localByteBuffer.getLong(8) != 2334950737559900225L) || (localByteBuffer.getLong(16) != 3617552046287187010L)) {
      throw new b.b("No APK Signing Block before ZIP Central Directory");
    }
    long l1 = localByteBuffer.getLong(0);
    if ((l1 < localByteBuffer.capacity()) || (l1 > 2147483639L)) {
      throw new b.b("APK Signing Block size out of range: " + l1);
    }
    int i = (int)(8L + l1);
    paramLong -= i;
    if (paramLong < 0L) {
      throw new b.b("APK Signing Block offset out of range: " + paramLong);
    }
    localByteBuffer = ByteBuffer.allocate(i);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong);
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    long l2 = localByteBuffer.getLong(0);
    if (l2 != l1) {
      throw new b.b("APK Signing Block sizes in header and footer do not match: " + l2 + " vs " + l1);
    }
    return Pair.create(localByteBuffer, Long.valueOf(paramLong));
  }
  
  public static ByteBuffer c(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt < 8) {
      throw new IllegalArgumentException("end < start: " + paramInt + " < 8");
    }
    int i = paramByteBuffer.capacity();
    if (paramInt > paramByteBuffer.capacity()) {
      throw new IllegalArgumentException("end > capacity: " + paramInt + " > " + i);
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
    }
  }
  
  public static ByteBuffer d(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("size: " + paramInt);
    }
    int i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    paramInt = j + paramInt;
    if ((paramInt < j) || (paramInt > i)) {
      throw new BufferUnderflowException();
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
    }
  }
  
  public static Pair<ByteBuffer, Long> e(RandomAccessFile paramRandomAccessFile)
  {
    Object localObject;
    if (paramRandomAccessFile.length() < 22L) {
      localObject = null;
    }
    while (localObject == null)
    {
      throw new b.b("Not an APK file: ZIP End of Central Directory record not found");
      Pair localPair = k.f(paramRandomAccessFile, 0);
      localObject = localPair;
      if (localPair == null) {
        localObject = k.f(paramRandomAccessFile, 65535);
      }
    }
    return localObject;
  }
  
  private static ByteBuffer x(ByteBuffer paramByteBuffer)
  {
    y(paramByteBuffer);
    paramByteBuffer = c(paramByteBuffer, paramByteBuffer.capacity() - 24);
    int i = 0;
    while (paramByteBuffer.hasRemaining())
    {
      i += 1;
      if (paramByteBuffer.remaining() < 8) {
        throw new b.b("Insufficient data to read size of APK Signing Block entry #" + i);
      }
      long l = paramByteBuffer.getLong();
      if ((l < 4L) || (l > 2147483647L)) {
        throw new b.b("APK Signing Block entry #" + i + " size out of range: " + l);
      }
      int j = (int)l;
      int k = paramByteBuffer.position();
      if (j > paramByteBuffer.remaining()) {
        throw new b.b("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + paramByteBuffer.remaining());
      }
      if (paramByteBuffer.getInt() == 1896449818) {
        return d(paramByteBuffer, j - 4);
      }
      paramByteBuffer.position(k + j);
    }
    throw new b.b("No APK Signature Scheme v2 block in APK Signing Block");
  }
  
  public static void y(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
      throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
  }
  
  /* Error */
  public static boolean zE(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 76	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_0
    //   8: ldc 223
    //   10: invokespecial 226	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 228	com/tencent/mm/plugin/downloader/c/b:e	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   18: astore 8
    //   20: aload 8
    //   22: getfield 232	android/util/Pair:first	Ljava/lang/Object;
    //   25: checkcast 19	java/nio/ByteBuffer
    //   28: astore 7
    //   30: aload 8
    //   32: getfield 235	android/util/Pair:second	Ljava/lang/Object;
    //   35: checkcast 115	java/lang/Long
    //   38: invokevirtual 238	java/lang/Long:longValue	()J
    //   41: lstore_1
    //   42: aload_0
    //   43: lload_1
    //   44: invokestatic 241	com/tencent/mm/plugin/downloader/c/k:c	(Ljava/io/RandomAccessFile;J)Z
    //   47: ifeq +25 -> 72
    //   50: new 9	com/tencent/mm/plugin/downloader/c/b$b
    //   53: dup
    //   54: ldc 243
    //   56: invokespecial 49	com/tencent/mm/plugin/downloader/c/b$b:<init>	(Ljava/lang/String;)V
    //   59: athrow
    //   60: astore 7
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 246	java/io/RandomAccessFile:close	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload 7
    //   74: lload_1
    //   75: invokestatic 248	com/tencent/mm/plugin/downloader/c/b:b	(Ljava/nio/ByteBuffer;J)J
    //   78: lstore_3
    //   79: aload_0
    //   80: lload_3
    //   81: invokestatic 250	com/tencent/mm/plugin/downloader/c/b:b	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   84: astore 8
    //   86: aload 8
    //   88: getfield 232	android/util/Pair:first	Ljava/lang/Object;
    //   91: checkcast 19	java/nio/ByteBuffer
    //   94: astore 9
    //   96: aload 8
    //   98: getfield 235	android/util/Pair:second	Ljava/lang/Object;
    //   101: checkcast 115	java/lang/Long
    //   104: invokevirtual 238	java/lang/Long:longValue	()J
    //   107: lstore 5
    //   109: new 6	com/tencent/mm/plugin/downloader/c/b$a
    //   112: dup
    //   113: aload 9
    //   115: invokestatic 252	com/tencent/mm/plugin/downloader/c/b:x	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   118: lload 5
    //   120: lload_3
    //   121: lload_1
    //   122: aload 7
    //   124: iconst_0
    //   125: invokespecial 255	com/tencent/mm/plugin/downloader/c/b$a:<init>	(Ljava/nio/ByteBuffer;JJJLjava/nio/ByteBuffer;B)V
    //   128: pop
    //   129: aload_0
    //   130: invokevirtual 246	java/io/RandomAccessFile:close	()V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore 7
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 246	java/io/RandomAccessFile:close	()V
    //   147: aload 7
    //   149: athrow
    //   150: astore 7
    //   152: goto -13 -> 139
    //   155: astore_0
    //   156: aload 7
    //   158: astore_0
    //   159: goto -97 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	java.lang.String
    //   41	81	1	l1	long
    //   78	43	3	l2	long
    //   107	12	5	l3	long
    //   1	28	7	localByteBuffer1	ByteBuffer
    //   60	63	7	localb	b.b
    //   135	13	7	localObject1	Object
    //   150	7	7	localObject2	Object
    //   18	79	8	localPair	Pair
    //   94	20	9	localByteBuffer2	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   14	60	60	com/tencent/mm/plugin/downloader/c/b$b
    //   72	129	60	com/tencent/mm/plugin/downloader/c/b$b
    //   3	14	135	finally
    //   14	60	150	finally
    //   72	129	150	finally
    //   3	14	155	com/tencent/mm/plugin/downloader/c/b$b
  }
  
  private static final class a
  {
    private final ByteBuffer iOG;
    private final long iOH;
    private final long iOI;
    private final long iOJ;
    private final ByteBuffer iOK;
    
    private a(ByteBuffer paramByteBuffer1, long paramLong1, long paramLong2, long paramLong3, ByteBuffer paramByteBuffer2)
    {
      this.iOG = paramByteBuffer1;
      this.iOH = paramLong1;
      this.iOI = paramLong2;
      this.iOJ = paramLong3;
      this.iOK = paramByteBuffer2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b
 * JD-Core Version:    0.7.0.1
 */