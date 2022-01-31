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
    //   2: ldc 24
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 32	com/tencent/liteav/audio/impl/Play/d$1:a	()V
    //   11: aload_0
    //   12: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   15: invokestatic 35	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   18: iconst_1
    //   19: if_icmpne +443 -> 462
    //   22: iconst_2
    //   23: istore_1
    //   24: aload_0
    //   25: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   28: invokestatic 37	com/tencent/liteav/audio/impl/Play/d:b	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   31: bipush 8
    //   33: if_icmpne +424 -> 457
    //   36: aload_0
    //   37: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   40: invokestatic 40	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   43: iload_1
    //   44: iload_2
    //   45: invokestatic 46	android/media/AudioTrack:getMinBufferSize	(III)I
    //   48: istore_3
    //   49: new 42	android/media/AudioTrack
    //   52: dup
    //   53: iconst_3
    //   54: aload_0
    //   55: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   58: invokestatic 40	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   61: iload_1
    //   62: iload_2
    //   63: iload_3
    //   64: iconst_1
    //   65: invokespecial 49	android/media/AudioTrack:<init>	(IIIIII)V
    //   68: astore 5
    //   70: invokestatic 53	com/tencent/liteav/audio/impl/Play/d:e	()Ljava/lang/String;
    //   73: new 55	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 57
    //   79: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_0
    //   83: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   86: invokestatic 40	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   89: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 66
    //   94: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   101: invokestatic 35	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   104: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc 71
    //   109: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_0
    //   113: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   116: invokestatic 37	com/tencent/liteav/audio/impl/Play/d:b	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   119: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 79	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload 5
    //   130: invokevirtual 82	android/media/AudioTrack:play	()V
    //   133: aload_0
    //   134: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   137: iconst_1
    //   138: invokestatic 85	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;Z)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   146: aload_0
    //   147: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   150: invokestatic 89	com/tencent/liteav/audio/impl/Play/d:d	(Lcom/tencent/liteav/audio/impl/Play/d;)Landroid/content/Context;
    //   153: aload_0
    //   154: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   157: invokestatic 91	com/tencent/liteav/audio/impl/Play/d:e	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   160: invokevirtual 94	com/tencent/liteav/audio/impl/Play/d:a	(Landroid/content/Context;I)V
    //   163: bipush 100
    //   165: istore_1
    //   166: iconst_0
    //   167: istore_2
    //   168: aload_0
    //   169: getfield 97	com/tencent/liteav/audio/impl/Play/d$1:b	Z
    //   172: ifeq +246 -> 418
    //   175: aload_0
    //   176: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   179: invokestatic 35	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   182: sipush 2048
    //   185: imul
    //   186: invokestatic 103	com/tencent/liteav/audio/impl/Play/b:nativeGetMixedTracksData	(I)[B
    //   189: astore 6
    //   191: aload 6
    //   193: lconst_0
    //   194: aload_0
    //   195: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   198: invokestatic 40	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   201: aload_0
    //   202: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   205: invokestatic 35	com/tencent/liteav/audio/impl/Play/d:a	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   208: invokestatic 109	com/tencent/liteav/audio/impl/Play/TXCAudioBasePlayController:onCorePlayPcmData	([BJII)V
    //   211: aload 6
    //   213: ifnull +191 -> 404
    //   216: aload 6
    //   218: arraylength
    //   219: ifle +185 -> 404
    //   222: aload_0
    //   223: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   226: invokestatic 113	com/tencent/liteav/audio/impl/Play/d:f	(Lcom/tencent/liteav/audio/impl/Play/d;)Z
    //   229: ifeq +9 -> 238
    //   232: aload 6
    //   234: iconst_0
    //   235: invokestatic 119	java/util/Arrays:fill	([BB)V
    //   238: iload_1
    //   239: istore 4
    //   241: iload_2
    //   242: istore_3
    //   243: iload_1
    //   244: ifeq +140 -> 384
    //   247: iload_1
    //   248: istore 4
    //   250: iload_2
    //   251: istore_3
    //   252: iload_2
    //   253: sipush 800
    //   256: if_icmpge +128 -> 384
    //   259: aload 6
    //   261: arraylength
    //   262: iconst_2
    //   263: idiv
    //   264: newarray short
    //   266: astore 7
    //   268: aload 6
    //   270: invokestatic 125	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   273: getstatic 131	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   276: invokevirtual 135	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   279: invokevirtual 139	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   282: aload 7
    //   284: invokevirtual 145	java/nio/ShortBuffer:get	([S)Ljava/nio/ShortBuffer;
    //   287: pop
    //   288: iconst_0
    //   289: istore_3
    //   290: iload_3
    //   291: aload 7
    //   293: arraylength
    //   294: if_icmpge +37 -> 331
    //   297: aload 7
    //   299: iload_3
    //   300: aload 7
    //   302: iload_3
    //   303: saload
    //   304: iload_1
    //   305: idiv
    //   306: i2s
    //   307: sastore
    //   308: iload_3
    //   309: iconst_1
    //   310: iadd
    //   311: istore_3
    //   312: goto -22 -> 290
    //   315: astore 5
    //   317: ldc 24
    //   319: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: return
    //   323: astore 5
    //   325: ldc 24
    //   327: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: return
    //   331: aload 6
    //   333: invokestatic 125	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   336: getstatic 131	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   339: invokevirtual 135	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   342: invokevirtual 139	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   345: aload 7
    //   347: invokevirtual 151	java/nio/ShortBuffer:put	([S)Ljava/nio/ShortBuffer;
    //   350: pop
    //   351: iload_2
    //   352: aload 6
    //   354: arraylength
    //   355: aload_0
    //   356: getfield 15	com/tencent/liteav/audio/impl/Play/d$1:a	Lcom/tencent/liteav/audio/impl/Play/d;
    //   359: invokestatic 40	com/tencent/liteav/audio/impl/Play/d:c	(Lcom/tencent/liteav/audio/impl/Play/d;)I
    //   362: iconst_2
    //   363: imul
    //   364: sipush 1000
    //   367: idiv
    //   368: idiv
    //   369: iadd
    //   370: istore_3
    //   371: iload_1
    //   372: sipush 800
    //   375: iload_3
    //   376: isub
    //   377: imul
    //   378: sipush 800
    //   381: idiv
    //   382: istore 4
    //   384: aload 5
    //   386: aload 6
    //   388: iconst_0
    //   389: aload 6
    //   391: arraylength
    //   392: invokevirtual 155	android/media/AudioTrack:write	([BII)I
    //   395: pop
    //   396: iload 4
    //   398: istore_1
    //   399: iload_3
    //   400: istore_2
    //   401: goto -233 -> 168
    //   404: ldc2_w 156
    //   407: invokestatic 161	com/tencent/liteav/audio/impl/Play/d$1:sleep	(J)V
    //   410: goto -242 -> 168
    //   413: astore 6
    //   415: goto -247 -> 168
    //   418: aload 5
    //   420: invokevirtual 164	android/media/AudioTrack:pause	()V
    //   423: aload 5
    //   425: invokevirtual 167	android/media/AudioTrack:flush	()V
    //   428: aload 5
    //   430: invokevirtual 170	android/media/AudioTrack:stop	()V
    //   433: aload 5
    //   435: invokevirtual 173	android/media/AudioTrack:release	()V
    //   438: invokestatic 53	com/tencent/liteav/audio/impl/Play/d:e	()Ljava/lang/String;
    //   441: ldc 175
    //   443: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: ldc 24
    //   448: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: return
    //   452: astore 5
    //   454: goto -16 -> 438
    //   457: iconst_2
    //   458: istore_2
    //   459: goto -423 -> 36
    //   462: iconst_3
    //   463: istore_1
    //   464: goto -440 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	1
    //   23	441	1	i	int
    //   1	458	2	j	int
    //   48	352	3	k	int
    //   239	158	4	m	int
    //   68	61	5	localAudioTrack	android.media.AudioTrack
    //   315	1	5	localException1	java.lang.Exception
    //   323	111	5	localException2	java.lang.Exception
    //   452	1	5	localException3	java.lang.Exception
    //   189	201	6	arrayOfByte	byte[]
    //   413	1	6	localInterruptedException	java.lang.InterruptedException
    //   266	80	7	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   11	22	315	java/lang/Exception
    //   24	36	315	java/lang/Exception
    //   36	128	315	java/lang/Exception
    //   128	133	323	java/lang/Exception
    //   404	410	413	java/lang/InterruptedException
    //   418	438	452	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.d.1
 * JD-Core Version:    0.7.0.1
 */