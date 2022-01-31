package com.tencent.liteav.audio.impl.Play;

class d$1
  extends d.a
{
  d$1(d paramd, String paramString)
  {
    super(paramd, paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 25	com/tencent/liteav/audio/impl/Play/d$1:a	()V
    //   6: aload_0
    //   7: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   10: invokestatic 28	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   13: iconst_1
    //   14: if_icmpne +408 -> 422
    //   17: iconst_2
    //   18: istore_1
    //   19: aload_0
    //   20: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   23: invokestatic 30	com/tencent/liteav/audio/impl/Play/d:b	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   26: bipush 8
    //   28: if_icmpne +389 -> 417
    //   31: aload_0
    //   32: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   35: invokestatic 33	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   38: iload_1
    //   39: iload_2
    //   40: invokestatic 39	android/media/AudioTrack:getMinBufferSize	(III)I
    //   43: istore_3
    //   44: new 35	android/media/AudioTrack
    //   47: dup
    //   48: iconst_3
    //   49: aload_0
    //   50: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   53: invokestatic 33	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   56: iload_1
    //   57: iload_2
    //   58: iload_3
    //   59: iconst_1
    //   60: invokespecial 42	android/media/AudioTrack:<init>	(IIIIII)V
    //   63: astore 5
    //   65: invokestatic 46	com/tencent/liteav/audio/impl/Play/d:e	()Ljava/lang/String;
    //   68: new 48	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 50
    //   74: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   81: invokestatic 33	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   84: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: ldc 59
    //   89: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   96: invokestatic 28	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   99: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc 64
    //   104: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   111: invokestatic 30	com/tencent/liteav/audio/impl/Play/d:b	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   114: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 73	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 5
    //   125: invokevirtual 76	android/media/AudioTrack:play	()V
    //   128: aload_0
    //   129: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   132: iconst_1
    //   133: invokestatic 79	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;Z)Z
    //   136: pop
    //   137: aload_0
    //   138: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   141: aload_0
    //   142: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   145: invokestatic 83	com/tencent/liteav/audio/impl/Play/d:d	(Lcom/tencent/liteav/audio/impl/Play/d;)Landroid/content/Context;
    //   148: aload_0
    //   149: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   152: invokestatic 85	com/tencent/liteav/audio/impl/Play/d:e	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   155: invokevirtual 88	com/tencent/liteav/audio/impl/Play/d:a	(Landroid/content/Context;I)V
    //   158: bipush 100
    //   160: istore_1
    //   161: iconst_0
    //   162: istore_2
    //   163: aload_0
    //   164: getfield 91	com/tencent/liteav/audio/impl/Play/d$1:b	Z
    //   167: ifeq +210 -> 377
    //   170: aload_0
    //   171: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   174: invokestatic 28	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   177: sipush 2048
    //   180: imul
    //   181: invokestatic 97	com/tencent/liteav/audio/impl/Play/b:nativeGetMixedTracksData	(I)[B
    //   184: astore 6
    //   186: aload 6
    //   188: ifnull +175 -> 363
    //   191: aload 6
    //   193: arraylength
    //   194: ifle +169 -> 363
    //   197: aload_0
    //   198: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   201: invokestatic 101	com/tencent/liteav/audio/impl/Play/d:f	(Lcom/tencent/liteav/audio/impl/Play/d;)Z
    //   204: ifeq +9 -> 213
    //   207: aload 6
    //   209: iconst_0
    //   210: invokestatic 107	java/util/Arrays:fill	([BB)V
    //   213: iload_1
    //   214: istore 4
    //   216: iload_2
    //   217: istore_3
    //   218: iload_1
    //   219: ifeq +124 -> 343
    //   222: iload_1
    //   223: istore 4
    //   225: iload_2
    //   226: istore_3
    //   227: iload_2
    //   228: sipush 800
    //   231: if_icmpge +112 -> 343
    //   234: aload 6
    //   236: arraylength
    //   237: iconst_2
    //   238: idiv
    //   239: newarray short
    //   241: astore 7
    //   243: aload 6
    //   245: invokestatic 113	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   248: getstatic 119	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   251: invokevirtual 123	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   254: invokevirtual 127	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   257: aload 7
    //   259: invokevirtual 133	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   262: pop
    //   263: iconst_0
    //   264: istore_3
    //   265: iload_3
    //   266: aload 7
    //   268: arraylength
    //   269: if_icmpge +21 -> 290
    //   272: aload 7
    //   274: iload_3
    //   275: aload 7
    //   277: iload_3
    //   278: saload
    //   279: iload_1
    //   280: idiv
    //   281: i2s
    //   282: sastore
    //   283: iload_3
    //   284: iconst_1
    //   285: iadd
    //   286: istore_3
    //   287: goto -22 -> 265
    //   290: aload 6
    //   292: invokestatic 113	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   295: getstatic 119	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   298: invokevirtual 123	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   301: invokevirtual 127	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   304: aload 7
    //   306: invokevirtual 136	java/nio/ShortBuffer:put	([S)Ljava/nio/ShortBuffer;
    //   309: pop
    //   310: iload_2
    //   311: aload 6
    //   313: arraylength
    //   314: aload_0
    //   315: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   318: invokestatic 33	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   321: iconst_2
    //   322: imul
    //   323: sipush 1000
    //   326: idiv
    //   327: idiv
    //   328: iadd
    //   329: istore_3
    //   330: iload_1
    //   331: sipush 800
    //   334: iload_3
    //   335: isub
    //   336: imul
    //   337: sipush 800
    //   340: idiv
    //   341: istore 4
    //   343: aload 5
    //   345: aload 6
    //   347: iconst_0
    //   348: aload 6
    //   350: arraylength
    //   351: invokevirtual 140	android/media/AudioTrack:write	([BII)I
    //   354: pop
    //   355: iload 4
    //   357: istore_1
    //   358: iload_3
    //   359: istore_2
    //   360: goto -197 -> 163
    //   363: ldc2_w 141
    //   366: invokestatic 146	com/tencent/liteav/audio/impl/Play/d$1:sleep	(J)V
    //   369: goto -206 -> 163
    //   372: astore 6
    //   374: goto -211 -> 163
    //   377: aload 5
    //   379: invokevirtual 149	android/media/AudioTrack:pause	()V
    //   382: aload 5
    //   384: invokevirtual 152	android/media/AudioTrack:flush	()V
    //   387: aload 5
    //   389: invokevirtual 155	android/media/AudioTrack:stop	()V
    //   392: aload 5
    //   394: invokevirtual 158	android/media/AudioTrack:release	()V
    //   397: invokestatic 46	com/tencent/liteav/audio/impl/Play/d:e	()Ljava/lang/String;
    //   400: ldc 160
    //   402: invokestatic 162	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: return
    //   406: astore 5
    //   408: return
    //   409: astore 5
    //   411: goto -14 -> 397
    //   414: astore 5
    //   416: return
    //   417: iconst_2
    //   418: istore_2
    //   419: goto -388 -> 31
    //   422: iconst_3
    //   423: istore_1
    //   424: goto -405 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	1
    //   18	406	1	i	int
    //   1	418	2	j	int
    //   43	316	3	k	int
    //   214	142	4	m	int
    //   63	330	5	localAudioTrack	android.media.AudioTrack
    //   406	1	5	localException1	java.lang.Exception
    //   409	1	5	localException2	java.lang.Exception
    //   414	1	5	localException3	java.lang.Exception
    //   184	165	6	arrayOfByte	byte[]
    //   372	1	6	localInterruptedException	java.lang.InterruptedException
    //   241	64	7	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   363	369	372	java/lang/InterruptedException
    //   123	128	406	java/lang/Exception
    //   377	397	409	java/lang/Exception
    //   6	17	414	java/lang/Exception
    //   19	31	414	java/lang/Exception
    //   31	123	414	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.d.1
 * JD-Core Version:    0.7.0.1
 */