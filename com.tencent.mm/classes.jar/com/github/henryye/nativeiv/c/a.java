package com.github.henryye.nativeiv.c;

public final class a
{
  /* Error */
  public static java.nio.ByteBuffer f(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 13
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: astore 6
    //   8: aload_0
    //   9: invokevirtual 25	java/io/InputStream:markSupported	()Z
    //   12: ifne +16 -> 28
    //   15: aload_0
    //   16: invokestatic 31	com/github/henryye/nativeiv/c/e:h	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   19: astore 6
    //   21: aload 6
    //   23: ldc 32
    //   25: invokevirtual 35	java/io/InputStream:mark	(I)V
    //   28: aload 6
    //   30: ifnonnull +10 -> 40
    //   33: ldc 13
    //   35: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aconst_null
    //   39: areturn
    //   40: sipush 10000
    //   43: newarray byte
    //   45: astore 8
    //   47: ldc 39
    //   49: invokestatic 45	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   52: astore_0
    //   53: aload_0
    //   54: invokestatic 51	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   57: invokevirtual 55	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   60: pop
    //   61: ldc 39
    //   63: istore_2
    //   64: iconst_0
    //   65: istore_3
    //   66: iconst_0
    //   67: istore_1
    //   68: aload 6
    //   70: aload 8
    //   72: invokevirtual 59	java/io/InputStream:read	([B)I
    //   75: istore 4
    //   77: iload_3
    //   78: iload 4
    //   80: iadd
    //   81: istore_3
    //   82: iload_3
    //   83: iload_2
    //   84: if_icmple +249 -> 333
    //   87: aload_0
    //   88: invokevirtual 63	java/nio/ByteBuffer:capacity	()I
    //   91: ldc 39
    //   93: iadd
    //   94: invokestatic 45	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   97: astore 7
    //   99: aload 7
    //   101: invokestatic 51	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   104: invokevirtual 55	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   107: pop
    //   108: aload_0
    //   109: iconst_0
    //   110: invokevirtual 67	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   113: pop
    //   114: aload 7
    //   116: aload_0
    //   117: invokevirtual 71	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   120: pop
    //   121: aload 7
    //   123: astore 5
    //   125: aload 7
    //   127: invokevirtual 63	java/nio/ByteBuffer:capacity	()I
    //   130: istore_2
    //   131: aload 7
    //   133: astore_0
    //   134: iload 4
    //   136: iflt +33 -> 169
    //   139: aload_0
    //   140: astore 5
    //   142: aload_0
    //   143: iload_1
    //   144: invokevirtual 67	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   147: pop
    //   148: aload_0
    //   149: astore 5
    //   151: aload_0
    //   152: aload 8
    //   154: iconst_0
    //   155: iload 4
    //   157: invokevirtual 74	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   160: pop
    //   161: iload_1
    //   162: iload 4
    //   164: iadd
    //   165: istore_1
    //   166: goto -98 -> 68
    //   169: aload_0
    //   170: astore 5
    //   172: aload_0
    //   173: iconst_0
    //   174: invokevirtual 67	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   177: pop
    //   178: aload 6
    //   180: invokevirtual 78	java/io/InputStream:reset	()V
    //   183: ldc 13
    //   185: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   188: aload_0
    //   189: areturn
    //   190: astore 5
    //   192: ldc 80
    //   194: aload 5
    //   196: ldc 82
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 88	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: goto -22 -> 183
    //   208: astore_0
    //   209: ldc 80
    //   211: aload_0
    //   212: ldc 90
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 88	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: aload 6
    //   223: invokevirtual 78	java/io/InputStream:reset	()V
    //   226: ldc 13
    //   228: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: ldc 80
    //   236: aload_0
    //   237: ldc 82
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 88	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: goto -20 -> 226
    //   249: astore 7
    //   251: aload_0
    //   252: astore 5
    //   254: ldc 80
    //   256: aload 7
    //   258: ldc 92
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 88	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: aload 6
    //   269: invokevirtual 78	java/io/InputStream:reset	()V
    //   272: aload 5
    //   274: astore_0
    //   275: goto -92 -> 183
    //   278: astore_0
    //   279: ldc 80
    //   281: aload_0
    //   282: ldc 82
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 88	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload 5
    //   293: astore_0
    //   294: goto -111 -> 183
    //   297: astore_0
    //   298: aload 6
    //   300: invokevirtual 78	java/io/InputStream:reset	()V
    //   303: ldc 13
    //   305: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload_0
    //   309: athrow
    //   310: astore 5
    //   312: ldc 80
    //   314: aload 5
    //   316: ldc 82
    //   318: iconst_0
    //   319: anewarray 4	java/lang/Object
    //   322: invokestatic 88	com/github/henryye/nativeiv/a/b:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -22 -> 303
    //   328: astore 7
    //   330: goto -76 -> 254
    //   333: goto -199 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramInputStream	java.io.InputStream
    //   67	99	1	i	int
    //   63	68	2	j	int
    //   65	20	3	k	int
    //   75	90	4	m	int
    //   123	48	5	localObject	Object
    //   190	5	5	localException1	java.lang.Exception
    //   252	40	5	localInputStream1	java.io.InputStream
    //   310	5	5	localException2	java.lang.Exception
    //   6	293	6	localInputStream2	java.io.InputStream
    //   97	35	7	localByteBuffer	java.nio.ByteBuffer
    //   249	8	7	localBufferOverflowException1	java.nio.BufferOverflowException
    //   328	1	7	localBufferOverflowException2	java.nio.BufferOverflowException
    //   45	108	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   178	183	190	java/lang/Exception
    //   68	77	208	java/io/IOException
    //   87	121	208	java/io/IOException
    //   125	131	208	java/io/IOException
    //   142	148	208	java/io/IOException
    //   151	161	208	java/io/IOException
    //   172	178	208	java/io/IOException
    //   221	226	233	java/lang/Exception
    //   68	77	249	java/nio/BufferOverflowException
    //   87	121	249	java/nio/BufferOverflowException
    //   267	272	278	java/lang/Exception
    //   68	77	297	finally
    //   87	121	297	finally
    //   125	131	297	finally
    //   142	148	297	finally
    //   151	161	297	finally
    //   172	178	297	finally
    //   209	221	297	finally
    //   254	267	297	finally
    //   298	303	310	java/lang/Exception
    //   125	131	328	java/nio/BufferOverflowException
    //   142	148	328	java/nio/BufferOverflowException
    //   151	161	328	java/nio/BufferOverflowException
    //   172	178	328	java/nio/BufferOverflowException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.github.henryye.nativeiv.c.a
 * JD-Core Version:    0.7.0.1
 */