package com.tencent.mm.modelvoice;

final class l$3
  implements Runnable
{
  l$3(l paraml) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 240
    //   7: invokestatic 37	android/os/Process:setThreadPriority	(I)V
    //   10: aload_0
    //   11: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   14: aload_0
    //   15: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   18: getfield 41	com/tencent/mm/modelvoice/l:fileName	Ljava/lang/String;
    //   21: invokestatic 47	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: putfield 51	com/tencent/mm/modelvoice/l:gaq	Ljava/io/InputStream;
    //   27: aload_0
    //   28: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   31: getfield 55	com/tencent/mm/modelvoice/l:status	I
    //   34: iconst_1
    //   35: if_icmpeq +14 -> 49
    //   38: aload_0
    //   39: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   42: getfield 55	com/tencent/mm/modelvoice/l:status	I
    //   45: iconst_2
    //   46: if_icmpne +743 -> 789
    //   49: aload_0
    //   50: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   53: aload_0
    //   54: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   57: getfield 51	com/tencent/mm/modelvoice/l:gaq	Ljava/io/InputStream;
    //   60: aload_0
    //   61: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   64: getfield 59	com/tencent/mm/modelvoice/l:gao	[B
    //   67: invokevirtual 65	java/io/InputStream:read	([B)I
    //   70: putfield 68	com/tencent/mm/modelvoice/l:gap	I
    //   73: aload_0
    //   74: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   77: getfield 68	com/tencent/mm/modelvoice/l:gap	I
    //   80: iconst_m1
    //   81: if_icmpeq +576 -> 657
    //   84: aload_0
    //   85: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   88: getfield 72	com/tencent/mm/modelvoice/l:gak	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   97: getfield 59	com/tencent/mm/modelvoice/l:gao	[B
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   105: getfield 68	com/tencent/mm/modelvoice/l:gap	I
    //   108: istore_1
    //   109: aload 4
    //   111: getfield 77	com/tencent/qqpinyin/voicerecoapi/a:BhL	I
    //   114: ifne +199 -> 313
    //   117: new 79	com/tencent/qqpinyin/voicerecoapi/b
    //   120: dup
    //   121: bipush 154
    //   123: invokespecial 81	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
    //   126: astore_3
    //   127: ldc 26
    //   129: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_3
    //   133: athrow
    //   134: astore_3
    //   135: ldc 86
    //   137: ldc 88
    //   139: iconst_1
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_3
    //   146: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   149: aastore
    //   150: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   157: getfield 104	com/tencent/mm/modelvoice/l:gac	Landroid/media/MediaPlayer$OnErrorListener;
    //   160: ifnull +19 -> 179
    //   163: aload_0
    //   164: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   167: getfield 104	com/tencent/mm/modelvoice/l:gac	Landroid/media/MediaPlayer$OnErrorListener;
    //   170: aconst_null
    //   171: iconst_0
    //   172: iconst_0
    //   173: invokeinterface 110 4 0
    //   178: pop
    //   179: aload_0
    //   180: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   183: iconst_0
    //   184: putfield 55	com/tencent/mm/modelvoice/l:status	I
    //   187: aload_0
    //   188: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   191: getfield 51	com/tencent/mm/modelvoice/l:gaq	Ljava/io/InputStream;
    //   194: ifnull +21 -> 215
    //   197: aload_0
    //   198: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   201: getfield 51	com/tencent/mm/modelvoice/l:gaq	Ljava/io/InputStream;
    //   204: invokevirtual 113	java/io/InputStream:close	()V
    //   207: aload_0
    //   208: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   211: aconst_null
    //   212: putfield 51	com/tencent/mm/modelvoice/l:gaq	Ljava/io/InputStream;
    //   215: aload_0
    //   216: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   219: getfield 72	com/tencent/mm/modelvoice/l:gak	Lcom/tencent/qqpinyin/voicerecoapi/a;
    //   222: astore_3
    //   223: aload_3
    //   224: getfield 77	com/tencent/qqpinyin/voicerecoapi/a:BhL	I
    //   227: ifne +604 -> 831
    //   230: bipush 154
    //   232: istore_1
    //   233: aload_0
    //   234: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   237: getfield 55	com/tencent/mm/modelvoice/l:status	I
    //   240: iconst_3
    //   241: if_icmpeq +615 -> 856
    //   244: aload_0
    //   245: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   248: getfield 117	com/tencent/mm/modelvoice/l:gaf	Lcom/tencent/mm/modelvoice/d$a;
    //   251: ifnull +15 -> 266
    //   254: aload_0
    //   255: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   258: getfield 117	com/tencent/mm/modelvoice/l:gaf	Lcom/tencent/mm/modelvoice/d$a;
    //   261: invokeinterface 122 1 0
    //   266: aload_0
    //   267: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   270: getfield 126	com/tencent/mm/modelvoice/l:gab	Landroid/media/MediaPlayer$OnCompletionListener;
    //   273: ifnull +16 -> 289
    //   276: aload_0
    //   277: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   280: getfield 126	com/tencent/mm/modelvoice/l:gab	Landroid/media/MediaPlayer$OnCompletionListener;
    //   283: aconst_null
    //   284: invokeinterface 132 2 0
    //   289: iload_1
    //   290: ifeq +17 -> 307
    //   293: ldc 86
    //   295: ldc 134
    //   297: iload_1
    //   298: invokestatic 140	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   301: invokevirtual 144	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   304: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: ldc 26
    //   309: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: return
    //   313: aload_3
    //   314: ifnull +8 -> 322
    //   317: aload_3
    //   318: arraylength
    //   319: ifne +20 -> 339
    //   322: new 79	com/tencent/qqpinyin/voicerecoapi/b
    //   325: dup
    //   326: bipush 152
    //   328: invokespecial 81	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
    //   331: astore_3
    //   332: ldc 26
    //   334: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: aload_3
    //   338: athrow
    //   339: aload 4
    //   341: getfield 151	com/tencent/qqpinyin/voicerecoapi/a:BhM	Lcom/tencent/qqpinyin/voicerecoapi/TRSpeexNative;
    //   344: aload 4
    //   346: getfield 77	com/tencent/qqpinyin/voicerecoapi/a:BhL	I
    //   349: aload_3
    //   350: iconst_0
    //   351: iload_1
    //   352: aload 4
    //   354: getfield 154	com/tencent/qqpinyin/voicerecoapi/a:BhJ	[B
    //   357: invokevirtual 160	com/tencent/qqpinyin/voicerecoapi/TRSpeexNative:nativeTRSpeexDecode	(I[BII[B)I
    //   360: istore_1
    //   361: iload_1
    //   362: ifge +508 -> 870
    //   365: new 79	com/tencent/qqpinyin/voicerecoapi/b
    //   368: dup
    //   369: iload_1
    //   370: invokespecial 81	com/tencent/qqpinyin/voicerecoapi/b:<init>	(I)V
    //   373: astore_3
    //   374: ldc 26
    //   376: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: aload_3
    //   380: athrow
    //   381: aload_0
    //   382: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   385: iconst_0
    //   386: putfield 55	com/tencent/mm/modelvoice/l:status	I
    //   389: goto -362 -> 27
    //   392: iload_1
    //   393: newarray byte
    //   395: astore_3
    //   396: aload 4
    //   398: getfield 154	com/tencent/qqpinyin/voicerecoapi/a:BhJ	[B
    //   401: iconst_0
    //   402: aload_3
    //   403: iconst_0
    //   404: iload_1
    //   405: invokestatic 166	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   408: goto +468 -> 876
    //   411: aload_3
    //   412: arraylength
    //   413: istore_1
    //   414: iconst_0
    //   415: istore_2
    //   416: iload_1
    //   417: aload_0
    //   418: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   421: getfield 169	com/tencent/mm/modelvoice/l:gar	I
    //   424: if_icmplt +96 -> 520
    //   427: aload_0
    //   428: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   431: getfield 55	com/tencent/mm/modelvoice/l:status	I
    //   434: iconst_1
    //   435: if_icmpne +85 -> 520
    //   438: aload_0
    //   439: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   442: getfield 173	com/tencent/mm/modelvoice/l:gan	Z
    //   445: ifeq +12 -> 457
    //   448: ldc2_w 174
    //   451: invokestatic 181	java/lang/Thread:sleep	(J)V
    //   454: goto -38 -> 416
    //   457: aload_0
    //   458: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   461: getfield 185	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   464: ifnull -48 -> 416
    //   467: aload_0
    //   468: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   471: getfield 173	com/tencent/mm/modelvoice/l:gan	Z
    //   474: ifne -58 -> 416
    //   477: aload_0
    //   478: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   481: getfield 185	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   484: aload_3
    //   485: iload_2
    //   486: aload_0
    //   487: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   490: getfield 169	com/tencent/mm/modelvoice/l:gar	I
    //   493: invokevirtual 191	android/media/AudioTrack:write	([BII)I
    //   496: pop
    //   497: iload_2
    //   498: aload_0
    //   499: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   502: getfield 169	com/tencent/mm/modelvoice/l:gar	I
    //   505: iadd
    //   506: istore_2
    //   507: iload_1
    //   508: aload_0
    //   509: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   512: getfield 169	com/tencent/mm/modelvoice/l:gar	I
    //   515: isub
    //   516: istore_1
    //   517: goto -101 -> 416
    //   520: iload_1
    //   521: aload_0
    //   522: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   525: getfield 169	com/tencent/mm/modelvoice/l:gar	I
    //   528: if_icmpge +31 -> 559
    //   531: iload_1
    //   532: ifle +27 -> 559
    //   535: aload_0
    //   536: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   539: getfield 185	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   542: ifnull +17 -> 559
    //   545: aload_0
    //   546: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   549: getfield 185	com/tencent/mm/modelvoice/l:ayN	Landroid/media/AudioTrack;
    //   552: aload_3
    //   553: iload_2
    //   554: iload_1
    //   555: invokevirtual 191	android/media/AudioTrack:write	([BII)I
    //   558: pop
    //   559: aload_0
    //   560: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   563: getfield 55	com/tencent/mm/modelvoice/l:status	I
    //   566: iconst_2
    //   567: if_icmpne +161 -> 728
    //   570: aload_0
    //   571: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   574: getfield 194	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   577: astore_3
    //   578: aload_3
    //   579: monitorenter
    //   580: ldc 86
    //   582: ldc 196
    //   584: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   587: aload_0
    //   588: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   591: getfield 194	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   594: invokevirtual 202	java/lang/Object:notify	()V
    //   597: ldc 86
    //   599: ldc 204
    //   601: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload_3
    //   605: monitorexit
    //   606: aload_0
    //   607: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   610: getfield 207	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   613: astore_3
    //   614: aload_3
    //   615: monitorenter
    //   616: ldc 86
    //   618: ldc 209
    //   620: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload_0
    //   624: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   627: getfield 207	com/tencent/mm/modelvoice/l:fZP	Ljava/lang/String;
    //   630: invokevirtual 212	java/lang/Object:wait	()V
    //   633: ldc 86
    //   635: ldc 214
    //   637: invokestatic 199	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload_3
    //   641: monitorexit
    //   642: goto -615 -> 27
    //   645: astore 4
    //   647: aload_3
    //   648: monitorexit
    //   649: ldc 26
    //   651: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   654: aload 4
    //   656: athrow
    //   657: aload_0
    //   658: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   661: iconst_0
    //   662: putfield 55	com/tencent/mm/modelvoice/l:status	I
    //   665: goto -106 -> 559
    //   668: astore 4
    //   670: ldc 86
    //   672: ldc 88
    //   674: iconst_1
    //   675: anewarray 4	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: aload 4
    //   682: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   685: aastore
    //   686: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   689: goto -85 -> 604
    //   692: astore 4
    //   694: aload_3
    //   695: monitorexit
    //   696: ldc 26
    //   698: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   701: aload 4
    //   703: athrow
    //   704: astore 4
    //   706: ldc 86
    //   708: ldc 88
    //   710: iconst_1
    //   711: anewarray 4	java/lang/Object
    //   714: dup
    //   715: iconst_0
    //   716: aload 4
    //   718: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   721: aastore
    //   722: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: goto -85 -> 640
    //   728: aload_0
    //   729: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   732: getfield 194	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   735: astore_3
    //   736: aload_3
    //   737: monitorenter
    //   738: aload_0
    //   739: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   742: getfield 194	com/tencent/mm/modelvoice/l:fZQ	Ljava/lang/String;
    //   745: invokevirtual 202	java/lang/Object:notify	()V
    //   748: aload_3
    //   749: monitorexit
    //   750: goto -723 -> 27
    //   753: astore 4
    //   755: aload_3
    //   756: monitorexit
    //   757: ldc 26
    //   759: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   762: aload 4
    //   764: athrow
    //   765: astore 4
    //   767: ldc 86
    //   769: ldc 88
    //   771: iconst_1
    //   772: anewarray 4	java/lang/Object
    //   775: dup
    //   776: iconst_0
    //   777: aload 4
    //   779: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   782: aastore
    //   783: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   786: goto -38 -> 748
    //   789: aload_0
    //   790: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   793: getfield 55	com/tencent/mm/modelvoice/l:status	I
    //   796: iconst_3
    //   797: if_icmpeq -610 -> 187
    //   800: ldc2_w 215
    //   803: invokestatic 181	java/lang/Thread:sleep	(J)V
    //   806: goto -619 -> 187
    //   809: astore_3
    //   810: ldc 86
    //   812: ldc 88
    //   814: iconst_1
    //   815: anewarray 4	java/lang/Object
    //   818: dup
    //   819: iconst_0
    //   820: aload_3
    //   821: invokestatic 94	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   824: aastore
    //   825: invokestatic 100	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   828: goto -621 -> 207
    //   831: aload_3
    //   832: aconst_null
    //   833: putfield 154	com/tencent/qqpinyin/voicerecoapi/a:BhJ	[B
    //   836: aload_3
    //   837: getfield 151	com/tencent/qqpinyin/voicerecoapi/a:BhM	Lcom/tencent/qqpinyin/voicerecoapi/TRSpeexNative;
    //   840: aload_3
    //   841: getfield 77	com/tencent/qqpinyin/voicerecoapi/a:BhL	I
    //   844: invokevirtual 220	com/tencent/qqpinyin/voicerecoapi/TRSpeexNative:nativeTRSpeexDecodeRelease	(I)I
    //   847: istore_1
    //   848: aload_3
    //   849: iconst_0
    //   850: putfield 77	com/tencent/qqpinyin/voicerecoapi/a:BhL	I
    //   853: goto -620 -> 233
    //   856: aload_0
    //   857: getfield 17	com/tencent/mm/modelvoice/l$3:gas	Lcom/tencent/mm/modelvoice/l;
    //   860: invokevirtual 223	com/tencent/mm/modelvoice/l:amp	()V
    //   863: goto -574 -> 289
    //   866: astore_3
    //   867: goto -578 -> 289
    //   870: iload_1
    //   871: ifne -479 -> 392
    //   874: aconst_null
    //   875: astore_3
    //   876: aload_3
    //   877: ifnull -496 -> 381
    //   880: iload_1
    //   881: ifne -470 -> 411
    //   884: goto -503 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	887	0	this	3
    //   108	773	1	i	int
    //   415	139	2	j	int
    //   100	33	3	localObject1	Object
    //   134	12	3	localException1	java.lang.Exception
    //   809	40	3	localIOException	java.io.IOException
    //   866	1	3	localException2	java.lang.Exception
    //   875	2	3	localObject3	Object
    //   91	306	4	locala	com.tencent.qqpinyin.voicerecoapi.a
    //   645	10	4	localObject4	Object
    //   668	13	4	localException3	java.lang.Exception
    //   692	10	4	localObject5	Object
    //   704	13	4	localException4	java.lang.Exception
    //   753	10	4	localObject6	Object
    //   765	13	4	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	27	134	java/lang/Exception
    //   27	49	134	java/lang/Exception
    //   49	134	134	java/lang/Exception
    //   317	322	134	java/lang/Exception
    //   322	339	134	java/lang/Exception
    //   339	361	134	java/lang/Exception
    //   365	381	134	java/lang/Exception
    //   381	389	134	java/lang/Exception
    //   392	408	134	java/lang/Exception
    //   411	414	134	java/lang/Exception
    //   416	454	134	java/lang/Exception
    //   457	517	134	java/lang/Exception
    //   520	531	134	java/lang/Exception
    //   535	559	134	java/lang/Exception
    //   559	580	134	java/lang/Exception
    //   606	616	134	java/lang/Exception
    //   649	657	134	java/lang/Exception
    //   657	665	134	java/lang/Exception
    //   696	704	134	java/lang/Exception
    //   728	738	134	java/lang/Exception
    //   757	765	134	java/lang/Exception
    //   789	806	134	java/lang/Exception
    //   616	640	645	finally
    //   640	642	645	finally
    //   647	649	645	finally
    //   706	725	645	finally
    //   580	604	668	java/lang/Exception
    //   580	604	692	finally
    //   604	606	692	finally
    //   670	689	692	finally
    //   694	696	692	finally
    //   616	640	704	java/lang/Exception
    //   738	748	753	finally
    //   748	750	753	finally
    //   755	757	753	finally
    //   767	786	753	finally
    //   738	748	765	java/lang/Exception
    //   197	207	809	java/io/IOException
    //   856	863	866	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.l.3
 * JD-Core Version:    0.7.0.1
 */