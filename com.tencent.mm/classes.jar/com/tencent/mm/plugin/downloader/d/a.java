package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a
{
  /* Error */
  public static boolean asR(String paramString)
  {
    // Byte code:
    //   0: ldc 13
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 12
    //   8: aload_0
    //   9: iconst_0
    //   10: invokestatic 25	com/tencent/mm/vfs/u:dO	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   13: astore_0
    //   14: aload_0
    //   15: invokestatic 29	com/tencent/mm/plugin/downloader/d/a:g	(Ljava/io/RandomAccessFile;)Landroid/util/Pair;
    //   18: astore 13
    //   20: aload 13
    //   22: getfield 35	android/util/Pair:first	Ljava/lang/Object;
    //   25: checkcast 37	java/nio/ByteBuffer
    //   28: astore 12
    //   30: aload 13
    //   32: getfield 40	android/util/Pair:second	Ljava/lang/Object;
    //   35: checkcast 42	java/lang/Long
    //   38: invokevirtual 46	java/lang/Long:longValue	()J
    //   41: lstore 4
    //   43: aload_0
    //   44: lload 4
    //   46: invokestatic 52	com/tencent/mm/plugin/downloader/d/h:c	(Ljava/io/RandomAccessFile;J)Z
    //   49: ifeq +39 -> 88
    //   52: new 9	com/tencent/mm/plugin/downloader/d/a$b
    //   55: dup
    //   56: ldc 54
    //   58: invokespecial 58	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   61: astore 12
    //   63: ldc 13
    //   65: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload 12
    //   70: athrow
    //   71: astore 12
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   81: ldc 13
    //   83: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_0
    //   87: ireturn
    //   88: aload 12
    //   90: lload 4
    //   92: invokestatic 70	com/tencent/mm/plugin/downloader/d/a:b	(Ljava/nio/ByteBuffer;J)J
    //   95: lstore 6
    //   97: aload_0
    //   98: lload 6
    //   100: invokestatic 73	com/tencent/mm/plugin/downloader/d/a:b	(Ljava/io/RandomAccessFile;J)Landroid/util/Pair;
    //   103: astore 13
    //   105: aload 13
    //   107: getfield 35	android/util/Pair:first	Ljava/lang/Object;
    //   110: checkcast 37	java/nio/ByteBuffer
    //   113: astore 14
    //   115: aload 13
    //   117: getfield 40	android/util/Pair:second	Ljava/lang/Object;
    //   120: checkcast 42	java/lang/Long
    //   123: invokevirtual 46	java/lang/Long:longValue	()J
    //   126: lstore 8
    //   128: aload 14
    //   130: invokestatic 77	com/tencent/mm/plugin/downloader/d/a:z	(Ljava/nio/ByteBuffer;)V
    //   133: aload 14
    //   135: aload 14
    //   137: invokevirtual 81	java/nio/ByteBuffer:capacity	()I
    //   140: bipush 24
    //   142: isub
    //   143: invokestatic 84	com/tencent/mm/plugin/downloader/d/a:c	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   146: astore 13
    //   148: iconst_0
    //   149: istore_1
    //   150: aload 13
    //   152: invokevirtual 88	java/nio/ByteBuffer:hasRemaining	()Z
    //   155: ifeq +265 -> 420
    //   158: iload_1
    //   159: iconst_1
    //   160: iadd
    //   161: istore_1
    //   162: aload 13
    //   164: invokevirtual 91	java/nio/ByteBuffer:remaining	()I
    //   167: bipush 8
    //   169: if_icmpge +47 -> 216
    //   172: new 9	com/tencent/mm/plugin/downloader/d/a$b
    //   175: dup
    //   176: ldc 93
    //   178: iload_1
    //   179: invokestatic 99	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   182: invokevirtual 103	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokespecial 58	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   188: astore 12
    //   190: ldc 13
    //   192: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload 12
    //   197: athrow
    //   198: astore 12
    //   200: aload_0
    //   201: ifnull +7 -> 208
    //   204: aload_0
    //   205: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   208: ldc 13
    //   210: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload 12
    //   215: athrow
    //   216: aload 13
    //   218: invokevirtual 106	java/nio/ByteBuffer:getLong	()J
    //   221: lstore 10
    //   223: lload 10
    //   225: ldc2_w 107
    //   228: lcmp
    //   229: iflt +12 -> 241
    //   232: lload 10
    //   234: ldc2_w 109
    //   237: lcmp
    //   238: ifle +46 -> 284
    //   241: new 9	com/tencent/mm/plugin/downloader/d/a$b
    //   244: dup
    //   245: new 112	java/lang/StringBuilder
    //   248: dup
    //   249: ldc 114
    //   251: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: iload_1
    //   255: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc 121
    //   260: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: lload 10
    //   265: invokevirtual 127	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   268: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokespecial 58	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   274: astore 12
    //   276: ldc 13
    //   278: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload 12
    //   283: athrow
    //   284: lload 10
    //   286: l2i
    //   287: istore_2
    //   288: aload 13
    //   290: invokevirtual 134	java/nio/ByteBuffer:position	()I
    //   293: istore_3
    //   294: iload_2
    //   295: aload 13
    //   297: invokevirtual 91	java/nio/ByteBuffer:remaining	()I
    //   300: if_icmple +58 -> 358
    //   303: new 9	com/tencent/mm/plugin/downloader/d/a$b
    //   306: dup
    //   307: new 112	java/lang/StringBuilder
    //   310: dup
    //   311: ldc 114
    //   313: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: iload_1
    //   317: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc 121
    //   322: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload_2
    //   326: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: ldc 136
    //   331: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 13
    //   336: invokevirtual 91	java/nio/ByteBuffer:remaining	()I
    //   339: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokespecial 58	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   348: astore 12
    //   350: ldc 13
    //   352: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   355: aload 12
    //   357: athrow
    //   358: aload 13
    //   360: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   363: ldc 140
    //   365: if_icmpne +43 -> 408
    //   368: new 6	com/tencent/mm/plugin/downloader/d/a$a
    //   371: dup
    //   372: aload 13
    //   374: iload_2
    //   375: iconst_4
    //   376: isub
    //   377: invokestatic 143	com/tencent/mm/plugin/downloader/d/a:d	(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;
    //   380: lload 8
    //   382: lload 6
    //   384: lload 4
    //   386: aload 12
    //   388: iconst_0
    //   389: invokespecial 146	com/tencent/mm/plugin/downloader/d/a$a:<init>	(Ljava/nio/ByteBuffer;JJJLjava/nio/ByteBuffer;B)V
    //   392: pop
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 67	java/io/RandomAccessFile:close	()V
    //   401: ldc 13
    //   403: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   406: iconst_1
    //   407: ireturn
    //   408: aload 13
    //   410: iload_3
    //   411: iload_2
    //   412: iadd
    //   413: invokevirtual 149	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   416: pop
    //   417: goto -267 -> 150
    //   420: new 9	com/tencent/mm/plugin/downloader/d/a$b
    //   423: dup
    //   424: ldc 151
    //   426: invokespecial 58	com/tencent/mm/plugin/downloader/d/a$b:<init>	(Ljava/lang/String;)V
    //   429: astore 12
    //   431: ldc 13
    //   433: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: aload 12
    //   438: athrow
    //   439: astore 12
    //   441: aconst_null
    //   442: astore_0
    //   443: goto -243 -> 200
    //   446: astore_0
    //   447: aload 12
    //   449: astore_0
    //   450: goto -377 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramString	String
    //   149	168	1	i	int
    //   287	126	2	j	int
    //   293	120	3	k	int
    //   41	344	4	l1	long
    //   95	288	6	l2	long
    //   126	255	8	l3	long
    //   221	64	10	l4	long
    //   6	63	12	localObject1	Object
    //   71	18	12	localb1	b
    //   188	8	12	localb2	b
    //   198	16	12	localObject2	Object
    //   274	163	12	localb3	b
    //   439	9	12	localObject3	Object
    //   18	391	13	localObject4	Object
    //   113	23	14	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   14	71	71	com/tencent/mm/plugin/downloader/d/a$b
    //   88	148	71	com/tencent/mm/plugin/downloader/d/a$b
    //   150	158	71	com/tencent/mm/plugin/downloader/d/a$b
    //   162	198	71	com/tencent/mm/plugin/downloader/d/a$b
    //   216	223	71	com/tencent/mm/plugin/downloader/d/a$b
    //   241	284	71	com/tencent/mm/plugin/downloader/d/a$b
    //   288	358	71	com/tencent/mm/plugin/downloader/d/a$b
    //   358	393	71	com/tencent/mm/plugin/downloader/d/a$b
    //   408	417	71	com/tencent/mm/plugin/downloader/d/a$b
    //   420	439	71	com/tencent/mm/plugin/downloader/d/a$b
    //   14	71	198	finally
    //   88	148	198	finally
    //   150	158	198	finally
    //   162	198	198	finally
    //   216	223	198	finally
    //   241	284	198	finally
    //   288	358	198	finally
    //   358	393	198	finally
    //   408	417	198	finally
    //   420	439	198	finally
    //   8	14	439	finally
    //   8	14	446	com/tencent/mm/plugin/downloader/d/a$b
  }
  
  public static long b(ByteBuffer paramByteBuffer, long paramLong)
  {
    AppMethodBeat.i(88852);
    long l = h.B(paramByteBuffer);
    if (l >= paramLong)
    {
      paramByteBuffer = new b("ZIP Central Directory offset out of range: " + l + ". ZIP End of Central Directory offset: " + paramLong);
      AppMethodBeat.o(88852);
      throw paramByteBuffer;
    }
    if (h.C(paramByteBuffer) + l != paramLong)
    {
      paramByteBuffer = new b("ZIP Central Directory is not immediately followed by End of Central Directory");
      AppMethodBeat.o(88852);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(88852);
    return l;
  }
  
  public static Pair<ByteBuffer, Long> b(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    AppMethodBeat.i(88855);
    if (paramLong < 32L)
    {
      paramRandomAccessFile = new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(88855);
      throw paramRandomAccessFile;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(24);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    paramRandomAccessFile.seek(paramLong - localByteBuffer.capacity());
    paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
    if ((localByteBuffer.getLong(8) != 2334950737559900225L) || (localByteBuffer.getLong(16) != 3617552046287187010L))
    {
      paramRandomAccessFile = new b("No APK Signing Block before ZIP Central Directory");
      AppMethodBeat.o(88855);
      throw paramRandomAccessFile;
    }
    long l1 = localByteBuffer.getLong(0);
    if ((l1 < localByteBuffer.capacity()) || (l1 > 2147483639L))
    {
      paramRandomAccessFile = new b("APK Signing Block size out of range: ".concat(String.valueOf(l1)));
      AppMethodBeat.o(88855);
      throw paramRandomAccessFile;
    }
    int i = (int)(8L + l1);
    paramLong -= i;
    if (paramLong < 0L)
    {
      paramRandomAccessFile = new b("APK Signing Block offset out of range: ".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(88855);
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
      AppMethodBeat.o(88855);
      throw paramRandomAccessFile;
    }
    paramRandomAccessFile = Pair.create(localByteBuffer, Long.valueOf(paramLong));
    AppMethodBeat.o(88855);
    return paramRandomAccessFile;
  }
  
  public static ByteBuffer c(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(88853);
    if (paramInt < 8)
    {
      paramByteBuffer = new IllegalArgumentException("end < start: " + paramInt + " < 8");
      AppMethodBeat.o(88853);
      throw paramByteBuffer;
    }
    int i = paramByteBuffer.capacity();
    if (paramInt > paramByteBuffer.capacity())
    {
      paramByteBuffer = new IllegalArgumentException("end > capacity: " + paramInt + " > " + i);
      AppMethodBeat.o(88853);
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
      AppMethodBeat.o(88853);
    }
  }
  
  public static ByteBuffer d(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(88854);
    if (paramInt < 0)
    {
      paramByteBuffer = new IllegalArgumentException("size: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(88854);
      throw paramByteBuffer;
    }
    int i = paramByteBuffer.limit();
    int j = paramByteBuffer.position();
    paramInt = j + paramInt;
    if ((paramInt < j) || (paramInt > i))
    {
      paramByteBuffer = new BufferUnderflowException();
      AppMethodBeat.o(88854);
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
      AppMethodBeat.o(88854);
    }
  }
  
  public static Pair<ByteBuffer, Long> g(RandomAccessFile paramRandomAccessFile)
  {
    AppMethodBeat.i(88851);
    paramRandomAccessFile = h.h(paramRandomAccessFile);
    if (paramRandomAccessFile == null)
    {
      paramRandomAccessFile = new b("Not an APK file: ZIP End of Central Directory record not found");
      AppMethodBeat.o(88851);
      throw paramRandomAccessFile;
    }
    AppMethodBeat.o(88851);
    return paramRandomAccessFile;
  }
  
  public static void z(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(88857);
    if (paramByteBuffer.order() != ByteOrder.LITTLE_ENDIAN)
    {
      paramByteBuffer = new IllegalArgumentException("ByteBuffer byte order must be little endian");
      AppMethodBeat.o(88857);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(88857);
  }
  
  static final class a
  {
    private final ByteBuffer ugv;
    private final long ugw;
    private final long ugx;
    private final long ugy;
    private final ByteBuffer ugz;
    
    private a(ByteBuffer paramByteBuffer1, long paramLong1, long paramLong2, long paramLong3, ByteBuffer paramByteBuffer2)
    {
      this.ugv = paramByteBuffer1;
      this.ugw = paramLong1;
      this.ugx = paramLong2;
      this.ugy = paramLong3;
      this.ugz = paramByteBuffer2;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.a
 * JD-Core Version:    0.7.0.1
 */