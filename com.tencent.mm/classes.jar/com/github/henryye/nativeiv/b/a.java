package com.github.henryye.nativeiv.b;

public final class a
{
  /* Error */
  public static java.nio.ByteBuffer c(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 18	java/io/InputStream:markSupported	()Z
    //   7: ifne +14 -> 21
    //   10: aload_0
    //   11: invokestatic 24	com/github/henryye/nativeiv/b/d:e	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   14: astore 6
    //   16: aload 6
    //   18: invokestatic 28	com/github/henryye/nativeiv/b/d:f	(Ljava/io/InputStream;)V
    //   21: aload 6
    //   23: ifnonnull +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: sipush 10000
    //   31: newarray byte
    //   33: astore 8
    //   35: ldc 29
    //   37: invokestatic 35	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   40: astore_0
    //   41: aload_0
    //   42: invokestatic 41	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   45: invokevirtual 45	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   48: pop
    //   49: ldc 29
    //   51: istore_2
    //   52: iconst_0
    //   53: istore_3
    //   54: iconst_0
    //   55: istore_1
    //   56: aload 6
    //   58: aload 8
    //   60: invokevirtual 49	java/io/InputStream:read	([B)I
    //   63: istore 4
    //   65: iload_3
    //   66: iload 4
    //   68: iadd
    //   69: istore_3
    //   70: iload_3
    //   71: iload_2
    //   72: if_icmple +227 -> 299
    //   75: aload_0
    //   76: invokevirtual 53	java/nio/ByteBuffer:capacity	()I
    //   79: ldc 29
    //   81: iadd
    //   82: invokestatic 35	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   85: astore 7
    //   87: aload 7
    //   89: invokestatic 41	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   92: invokevirtual 45	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   95: pop
    //   96: aload_0
    //   97: iconst_0
    //   98: invokevirtual 57	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   101: pop
    //   102: aload 7
    //   104: aload_0
    //   105: invokevirtual 61	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   108: pop
    //   109: aload 7
    //   111: astore 5
    //   113: aload 7
    //   115: invokevirtual 53	java/nio/ByteBuffer:capacity	()I
    //   118: istore_2
    //   119: aload 7
    //   121: astore_0
    //   122: iload 4
    //   124: iflt +33 -> 157
    //   127: aload_0
    //   128: astore 5
    //   130: aload_0
    //   131: iload_1
    //   132: invokevirtual 57	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   135: pop
    //   136: aload_0
    //   137: astore 5
    //   139: aload_0
    //   140: aload 8
    //   142: iconst_0
    //   143: iload 4
    //   145: invokevirtual 64	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   148: pop
    //   149: iload_1
    //   150: iload 4
    //   152: iadd
    //   153: istore_1
    //   154: goto -98 -> 56
    //   157: aload_0
    //   158: astore 5
    //   160: aload_0
    //   161: iconst_0
    //   162: invokevirtual 57	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   165: pop
    //   166: aload 6
    //   168: invokevirtual 68	java/io/InputStream:reset	()V
    //   171: aload_0
    //   172: areturn
    //   173: astore 5
    //   175: ldc 70
    //   177: aload 5
    //   179: ldc 72
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 78	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_0
    //   189: areturn
    //   190: astore_0
    //   191: ldc 70
    //   193: aload_0
    //   194: ldc 80
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 78	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload 6
    //   205: invokevirtual 68	java/io/InputStream:reset	()V
    //   208: aconst_null
    //   209: areturn
    //   210: astore_0
    //   211: ldc 70
    //   213: aload_0
    //   214: ldc 72
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 78	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: goto -15 -> 208
    //   226: astore 7
    //   228: aload_0
    //   229: astore 5
    //   231: ldc 70
    //   233: aload 7
    //   235: ldc 82
    //   237: iconst_0
    //   238: anewarray 4	java/lang/Object
    //   241: invokestatic 78	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload 6
    //   246: invokevirtual 68	java/io/InputStream:reset	()V
    //   249: aload 5
    //   251: areturn
    //   252: astore_0
    //   253: ldc 70
    //   255: aload_0
    //   256: ldc 72
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 78	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 5
    //   267: areturn
    //   268: astore_0
    //   269: aload 6
    //   271: invokevirtual 68	java/io/InputStream:reset	()V
    //   274: aload_0
    //   275: athrow
    //   276: astore 5
    //   278: ldc 70
    //   280: aload 5
    //   282: ldc 72
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 78	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: goto -17 -> 274
    //   294: astore 7
    //   296: goto -65 -> 231
    //   299: goto -177 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	paramInputStream	java.io.InputStream
    //   55	99	1	i	int
    //   51	68	2	j	int
    //   53	20	3	k	int
    //   63	90	4	m	int
    //   111	48	5	localObject	Object
    //   173	5	5	localException1	java.lang.Exception
    //   229	37	5	localInputStream1	java.io.InputStream
    //   276	5	5	localException2	java.lang.Exception
    //   1	269	6	localInputStream2	java.io.InputStream
    //   85	35	7	localByteBuffer	java.nio.ByteBuffer
    //   226	8	7	localBufferOverflowException1	java.nio.BufferOverflowException
    //   294	1	7	localBufferOverflowException2	java.nio.BufferOverflowException
    //   33	108	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   166	171	173	java/lang/Exception
    //   56	65	190	java/io/IOException
    //   75	109	190	java/io/IOException
    //   113	119	190	java/io/IOException
    //   130	136	190	java/io/IOException
    //   139	149	190	java/io/IOException
    //   160	166	190	java/io/IOException
    //   203	208	210	java/lang/Exception
    //   56	65	226	java/nio/BufferOverflowException
    //   75	109	226	java/nio/BufferOverflowException
    //   244	249	252	java/lang/Exception
    //   56	65	268	finally
    //   75	109	268	finally
    //   113	119	268	finally
    //   130	136	268	finally
    //   139	149	268	finally
    //   160	166	268	finally
    //   191	203	268	finally
    //   231	244	268	finally
    //   269	274	276	java/lang/Exception
    //   113	119	294	java/nio/BufferOverflowException
    //   130	136	294	java/nio/BufferOverflowException
    //   139	149	294	java/nio/BufferOverflowException
    //   160	166	294	java/nio/BufferOverflowException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.github.henryye.nativeiv.b.a
 * JD-Core Version:    0.7.0.1
 */