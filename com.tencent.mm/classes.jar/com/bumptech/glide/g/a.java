package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
  private static final AtomicReference<byte[]> aNK;
  
  static
  {
    AppMethodBeat.i(77721);
    aNK = new AtomicReference();
    AppMethodBeat.o(77721);
  }
  
  /* Error */
  public static void b(ByteBuffer paramByteBuffer, java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 36
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_0
    //   7: invokevirtual 42	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   10: pop
    //   11: new 44	java/io/RandomAccessFile
    //   14: dup
    //   15: aload_1
    //   16: ldc 46
    //   18: invokespecial 49	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 53	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 59	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   32: pop
    //   33: aload_1
    //   34: iconst_0
    //   35: invokevirtual 63	java/nio/channels/FileChannel:force	(Z)V
    //   38: aload_1
    //   39: invokevirtual 66	java/nio/channels/FileChannel:close	()V
    //   42: aload_2
    //   43: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_1
    //   51: invokevirtual 66	java/nio/channels/FileChannel:close	()V
    //   54: aload_2
    //   55: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   58: ldc 36
    //   60: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_0
    //   65: ldc 36
    //   67: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: astore_0
    //   72: aconst_null
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 66	java/nio/channels/FileChannel:close	()V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   92: ldc 36
    //   94: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: goto -46 -> 54
    //   103: astore_1
    //   104: goto -20 -> 84
    //   107: astore_1
    //   108: goto -16 -> 92
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -38 -> 76
    //   117: astore_0
    //   118: goto -42 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramByteBuffer	ByteBuffer
    //   0	121	1	paramFile	java.io.File
    //   21	68	2	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   54	58	64	java/io/IOException
    //   11	22	71	finally
    //   50	54	99	java/io/IOException
    //   80	84	103	java/io/IOException
    //   88	92	107	java/io/IOException
    //   22	27	111	finally
    //   27	46	117	finally
  }
  
  public static byte[] c(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(77719);
    Object localObject;
    if ((!paramByteBuffer.isReadOnly()) && (paramByteBuffer.hasArray()))
    {
      localObject = new b(paramByteBuffer.array(), paramByteBuffer.arrayOffset(), paramByteBuffer.limit());
      if ((localObject == null) || (((b)localObject).offset != 0) || (((b)localObject).limit != ((b)localObject).data.length)) {
        break label79;
      }
      paramByteBuffer = paramByteBuffer.array();
    }
    for (;;)
    {
      AppMethodBeat.o(77719);
      return paramByteBuffer;
      localObject = null;
      break;
      label79:
      localObject = paramByteBuffer.asReadOnlyBuffer();
      paramByteBuffer = new byte[((ByteBuffer)localObject).limit()];
      ((ByteBuffer)localObject).position(0);
      ((ByteBuffer)localObject).get(paramByteBuffer);
    }
  }
  
  public static InputStream d(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(77720);
    paramByteBuffer = new a.a(paramByteBuffer);
    AppMethodBeat.o(77720);
    return paramByteBuffer;
  }
  
  /* Error */
  public static ByteBuffer v(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 124	java/io/File:length	()J
    //   9: lstore_1
    //   10: lload_1
    //   11: ldc2_w 125
    //   14: lcmp
    //   15: ifle +51 -> 66
    //   18: new 35	java/io/IOException
    //   21: dup
    //   22: ldc 128
    //   24: invokespecial 131	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   27: astore_0
    //   28: ldc 118
    //   30: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: athrow
    //   35: astore_0
    //   36: aconst_null
    //   37: astore_3
    //   38: aconst_null
    //   39: astore 4
    //   41: aload_3
    //   42: ifnull +7 -> 49
    //   45: aload_3
    //   46: invokevirtual 66	java/nio/channels/FileChannel:close	()V
    //   49: aload 4
    //   51: ifnull +8 -> 59
    //   54: aload 4
    //   56: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   59: ldc 118
    //   61: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: athrow
    //   66: lload_1
    //   67: lconst_0
    //   68: lcmp
    //   69: ifne +20 -> 89
    //   72: new 35	java/io/IOException
    //   75: dup
    //   76: ldc 133
    //   78: invokespecial 131	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   81: astore_0
    //   82: ldc 118
    //   84: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_0
    //   88: athrow
    //   89: new 44	java/io/RandomAccessFile
    //   92: dup
    //   93: aload_0
    //   94: ldc 135
    //   96: invokespecial 49	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 53	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   104: astore_3
    //   105: aload_3
    //   106: getstatic 141	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   109: lconst_0
    //   110: lload_1
    //   111: invokevirtual 145	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   114: invokevirtual 151	java/nio/MappedByteBuffer:load	()Ljava/nio/MappedByteBuffer;
    //   117: astore 4
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 66	java/nio/channels/FileChannel:close	()V
    //   127: aload_0
    //   128: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   131: ldc 118
    //   133: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload 4
    //   138: areturn
    //   139: astore_3
    //   140: goto -13 -> 127
    //   143: astore_0
    //   144: goto -13 -> 131
    //   147: astore_3
    //   148: goto -99 -> 49
    //   151: astore_3
    //   152: goto -93 -> 59
    //   155: astore_3
    //   156: aconst_null
    //   157: astore 5
    //   159: aload_0
    //   160: astore 4
    //   162: aload_3
    //   163: astore_0
    //   164: aload 5
    //   166: astore_3
    //   167: goto -126 -> 41
    //   170: astore 5
    //   172: aload_0
    //   173: astore 4
    //   175: aload 5
    //   177: astore_0
    //   178: goto -137 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramFile	java.io.File
    //   9	102	1	l	long
    //   37	87	3	localFileChannel	java.nio.channels.FileChannel
    //   139	1	3	localIOException1	java.io.IOException
    //   147	1	3	localIOException2	java.io.IOException
    //   151	1	3	localIOException3	java.io.IOException
    //   155	8	3	localObject1	Object
    //   166	1	3	localObject2	Object
    //   39	135	4	localObject3	Object
    //   157	8	5	localObject4	Object
    //   170	6	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   5	10	35	finally
    //   18	35	35	finally
    //   72	89	35	finally
    //   89	100	35	finally
    //   123	127	139	java/io/IOException
    //   127	131	143	java/io/IOException
    //   45	49	147	java/io/IOException
    //   54	59	151	java/io/IOException
    //   100	105	155	finally
    //   105	119	170	finally
  }
  
  static final class b
  {
    final byte[] data;
    final int limit;
    final int offset;
    
    b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.data = paramArrayOfByte;
      this.offset = paramInt1;
      this.limit = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.g.a
 * JD-Core Version:    0.7.0.1
 */