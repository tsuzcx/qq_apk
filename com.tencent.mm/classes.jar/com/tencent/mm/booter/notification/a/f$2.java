package com.tencent.mm.booter.notification.a;

final class f$2
  implements Runnable
{
  f$2(f paramf, String paramString) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 16025
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 21	com/tencent/mm/booter/notification/a/f$2:ebw	Lcom/tencent/mm/booter/notification/a/f;
    //   10: astore 14
    //   12: aload_0
    //   13: getfield 23	com/tencent/mm/booter/notification/a/f$2:ebx	Ljava/lang/String;
    //   16: astore 15
    //   18: aload_0
    //   19: getfield 25	com/tencent/mm/booter/notification/a/f$2:eby	Z
    //   22: istore 8
    //   24: aload 14
    //   26: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   29: ifnonnull +11 -> 40
    //   32: aload 14
    //   34: invokestatic 52	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   37: putfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   40: aload 14
    //   42: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   45: ifnonnull +17 -> 62
    //   48: ldc 54
    //   50: ldc 56
    //   52: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: sipush 16025
    //   58: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload 14
    //   64: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   67: ldc 67
    //   69: invokevirtual 73	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   72: checkcast 75	android/media/AudioManager
    //   75: astore 16
    //   77: aload 16
    //   79: iconst_5
    //   80: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
    //   83: istore 7
    //   85: iload 7
    //   87: ifne +10 -> 97
    //   90: sipush 16025
    //   93: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: aload 14
    //   99: getfield 83	com/tencent/mm/booter/notification/a/f:ebu	Lcom/tencent/mm/sdk/platformtools/ak;
    //   102: ldc 84
    //   104: invokevirtual 89	com/tencent/mm/sdk/platformtools/ak:removeMessages	(I)V
    //   107: aload 14
    //   109: getfield 83	com/tencent/mm/booter/notification/a/f:ebu	Lcom/tencent/mm/sdk/platformtools/ak;
    //   112: ldc 84
    //   114: ldc2_w 90
    //   117: invokevirtual 95	com/tencent/mm/sdk/platformtools/ak:sendEmptyMessageDelayed	(IJ)Z
    //   120: pop
    //   121: ldc 54
    //   123: ldc 97
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload 14
    //   133: getfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   136: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   139: aastore
    //   140: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload 14
    //   145: getfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   148: istore 9
    //   150: iload 9
    //   152: ifeq +66 -> 218
    //   155: aload 14
    //   157: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   160: ifnull +52 -> 212
    //   163: aload 14
    //   165: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   168: invokevirtual 119	android/media/MediaPlayer:isPlaying	()Z
    //   171: ifeq +11 -> 182
    //   174: aload 14
    //   176: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   179: invokevirtual 122	android/media/MediaPlayer:stop	()V
    //   182: aload 14
    //   184: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   187: invokevirtual 125	android/media/MediaPlayer:release	()V
    //   190: ldc 54
    //   192: ldc 127
    //   194: iconst_1
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload 14
    //   202: getfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   205: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   208: aastore
    //   209: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload 14
    //   214: iconst_0
    //   215: putfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   218: aload 14
    //   220: new 129	com/tencent/mm/compatible/b/k
    //   223: dup
    //   224: invokespecial 130	com/tencent/mm/compatible/b/k:<init>	()V
    //   227: putfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   230: ldc 54
    //   232: ldc 132
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 14
    //   242: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   245: aastore
    //   246: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: aload 14
    //   251: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   254: astore 17
    //   256: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   259: lstore 11
    //   261: aload 15
    //   263: invokestatic 144	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   266: ifeq +476 -> 742
    //   269: iconst_2
    //   270: invokestatic 150	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
    //   273: astore 13
    //   275: aload 13
    //   277: ifnull +15 -> 292
    //   280: aload 17
    //   282: aload 14
    //   284: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   287: aload 13
    //   289: invokevirtual 154	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   292: ldc 54
    //   294: ldc 156
    //   296: iconst_2
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: invokestatic 162	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   305: invokevirtual 165	java/lang/Thread:getId	()J
    //   308: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   311: aastore
    //   312: dup
    //   313: iconst_1
    //   314: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   317: lload 11
    //   319: lsub
    //   320: invokestatic 170	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: aload 16
    //   329: invokevirtual 173	android/media/AudioManager:isWiredHeadsetOn	()Z
    //   332: ifeq +567 -> 899
    //   335: invokestatic 179	com/tencent/mm/compatible/b/g:KJ	()I
    //   338: pop
    //   339: ldc 54
    //   341: ldc 181
    //   343: iconst_1
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: iconst_0
    //   350: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aastore
    //   354: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload 16
    //   359: iconst_0
    //   360: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
    //   363: i2f
    //   364: fstore_1
    //   365: aload 16
    //   367: iconst_3
    //   368: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
    //   371: i2f
    //   372: fstore 5
    //   374: aload 16
    //   376: iconst_0
    //   377: invokevirtual 192	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   380: i2f
    //   381: fstore_2
    //   382: aload 16
    //   384: iconst_3
    //   385: invokevirtual 192	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   388: i2f
    //   389: fstore 6
    //   391: fload_1
    //   392: fload_2
    //   393: fdiv
    //   394: fstore_3
    //   395: fload 5
    //   397: fload 6
    //   399: fdiv
    //   400: fstore 4
    //   402: ldc 54
    //   404: ldc 194
    //   406: iconst_3
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: fload_1
    //   413: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: fload_2
    //   420: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   423: aastore
    //   424: dup
    //   425: iconst_2
    //   426: fload_3
    //   427: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   430: aastore
    //   431: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   434: ldc 54
    //   436: ldc 201
    //   438: iconst_3
    //   439: anewarray 4	java/lang/Object
    //   442: dup
    //   443: iconst_0
    //   444: fload 5
    //   446: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: fload 6
    //   454: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   457: aastore
    //   458: dup
    //   459: iconst_2
    //   460: fload 4
    //   462: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   465: aastore
    //   466: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: fload_3
    //   470: fload 4
    //   472: fcmpl
    //   473: ifle +26 -> 499
    //   476: fload_2
    //   477: fload 4
    //   479: fmul
    //   480: fstore_1
    //   481: ldc 54
    //   483: ldc 203
    //   485: iconst_1
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: fload_1
    //   492: invokestatic 199	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   495: aastore
    //   496: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   499: ldc 54
    //   501: ldc 205
    //   503: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload 16
    //   508: iconst_0
    //   509: invokevirtual 211	android/media/AudioManager:setSpeakerphoneOn	(Z)V
    //   512: ldc 54
    //   514: ldc 213
    //   516: iconst_1
    //   517: anewarray 4	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: getstatic 219	com/tencent/mm/compatible/e/ac:erF	Lcom/tencent/mm/compatible/e/k;
    //   525: getfield 225	com/tencent/mm/compatible/e/k:epG	I
    //   528: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: getstatic 219	com/tencent/mm/compatible/e/ac:erF	Lcom/tencent/mm/compatible/e/k;
    //   538: getfield 225	com/tencent/mm/compatible/e/k:epG	I
    //   541: iconst_1
    //   542: if_icmpne +320 -> 862
    //   545: ldc 54
    //   547: ldc 227
    //   549: invokestatic 207	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload 16
    //   554: invokevirtual 230	android/media/AudioManager:getMode	()I
    //   557: ifne +9 -> 566
    //   560: aload 16
    //   562: iconst_3
    //   563: invokevirtual 233	android/media/AudioManager:setMode	(I)V
    //   566: aload 14
    //   568: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   571: new 235	com/tencent/mm/booter/notification/a/f$3
    //   574: dup
    //   575: aload 14
    //   577: aload 16
    //   579: invokespecial 238	com/tencent/mm/booter/notification/a/f$3:<init>	(Lcom/tencent/mm/booter/notification/a/f;Landroid/media/AudioManager;)V
    //   582: invokevirtual 242	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   585: aload 14
    //   587: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   590: new 244	com/tencent/mm/booter/notification/a/f$4
    //   593: dup
    //   594: aload 14
    //   596: aload 16
    //   598: invokespecial 245	com/tencent/mm/booter/notification/a/f$4:<init>	(Lcom/tencent/mm/booter/notification/a/f;Landroid/media/AudioManager;)V
    //   601: invokevirtual 249	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   604: aload 14
    //   606: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   609: iconst_0
    //   610: invokevirtual 252	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   613: aload 14
    //   615: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   618: iconst_1
    //   619: invokevirtual 255	android/media/MediaPlayer:setLooping	(Z)V
    //   622: aload 14
    //   624: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   627: invokevirtual 258	android/media/MediaPlayer:prepare	()V
    //   630: aload 14
    //   632: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   635: fload_1
    //   636: fload_2
    //   637: fdiv
    //   638: fload_1
    //   639: fload_2
    //   640: fdiv
    //   641: invokevirtual 262	android/media/MediaPlayer:setVolume	(FF)V
    //   644: aload 14
    //   646: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   649: iconst_0
    //   650: invokevirtual 255	android/media/MediaPlayer:setLooping	(Z)V
    //   653: aload 14
    //   655: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   658: invokevirtual 265	android/media/MediaPlayer:start	()V
    //   661: aload 14
    //   663: iconst_1
    //   664: putfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   667: sipush 16025
    //   670: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: return
    //   674: astore 13
    //   676: ldc 54
    //   678: aload 13
    //   680: ldc_w 267
    //   683: iconst_0
    //   684: anewarray 4	java/lang/Object
    //   687: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   690: aload 14
    //   692: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   695: ifnull +11 -> 706
    //   698: aload 14
    //   700: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   703: invokevirtual 125	android/media/MediaPlayer:release	()V
    //   706: sipush 16025
    //   709: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: return
    //   713: astore 13
    //   715: ldc 54
    //   717: ldc_w 273
    //   720: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   723: aload 14
    //   725: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   728: ifnull -516 -> 212
    //   731: aload 14
    //   733: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   736: invokevirtual 125	android/media/MediaPlayer:release	()V
    //   739: goto -527 -> 212
    //   742: iload 8
    //   744: ifeq +49 -> 793
    //   747: aload 14
    //   749: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   752: invokevirtual 277	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   755: aload 15
    //   757: invokevirtual 283	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   760: astore 13
    //   762: aload 17
    //   764: aload 13
    //   766: invokevirtual 289	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   769: aload 13
    //   771: invokevirtual 292	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   774: aload 13
    //   776: invokevirtual 295	android/content/res/AssetFileDescriptor:getLength	()J
    //   779: invokevirtual 298	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   782: aload 13
    //   784: invokevirtual 301	android/content/res/AssetFileDescriptor:close	()V
    //   787: aconst_null
    //   788: astore 13
    //   790: goto -515 -> 275
    //   793: aload 15
    //   795: invokestatic 307	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   798: astore 13
    //   800: goto -525 -> 275
    //   803: astore 13
    //   805: aload 15
    //   807: invokestatic 144	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   810: ifne +24 -> 834
    //   813: iconst_2
    //   814: invokestatic 150	android/media/RingtoneManager:getDefaultUri	(I)Landroid/net/Uri;
    //   817: astore 13
    //   819: aload 17
    //   821: aload 14
    //   823: getfield 46	com/tencent/mm/booter/notification/a/f:context	Landroid/content/Context;
    //   826: aload 13
    //   828: invokevirtual 154	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   831: goto -539 -> 292
    //   834: ldc 54
    //   836: ldc_w 309
    //   839: iconst_2
    //   840: anewarray 4	java/lang/Object
    //   843: dup
    //   844: iconst_0
    //   845: aload 15
    //   847: aastore
    //   848: dup
    //   849: iconst_1
    //   850: iload 8
    //   852: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   855: aastore
    //   856: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   859: goto -567 -> 292
    //   862: aload 14
    //   864: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   867: new 311	com/tencent/mm/booter/notification/a/f$5
    //   870: dup
    //   871: aload 14
    //   873: invokespecial 314	com/tencent/mm/booter/notification/a/f$5:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
    //   876: invokevirtual 242	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   879: aload 14
    //   881: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   884: new 316	com/tencent/mm/booter/notification/a/f$6
    //   887: dup
    //   888: aload 14
    //   890: invokespecial 317	com/tencent/mm/booter/notification/a/f$6:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
    //   893: invokevirtual 249	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   896: goto -292 -> 604
    //   899: ldc 54
    //   901: ldc_w 319
    //   904: iconst_2
    //   905: anewarray 4	java/lang/Object
    //   908: dup
    //   909: iconst_0
    //   910: aload 16
    //   912: iconst_5
    //   913: invokevirtual 79	android/media/AudioManager:getStreamVolume	(I)I
    //   916: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   919: aastore
    //   920: dup
    //   921: iconst_1
    //   922: aload 15
    //   924: aastore
    //   925: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   928: aload 14
    //   930: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   933: new 321	com/tencent/mm/booter/notification/a/f$7
    //   936: dup
    //   937: aload 14
    //   939: invokespecial 322	com/tencent/mm/booter/notification/a/f$7:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
    //   942: invokevirtual 242	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   945: aload 14
    //   947: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   950: new 324	com/tencent/mm/booter/notification/a/f$8
    //   953: dup
    //   954: aload 14
    //   956: invokespecial 325	com/tencent/mm/booter/notification/a/f$8:<init>	(Lcom/tencent/mm/booter/notification/a/f;)V
    //   959: invokevirtual 249	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   962: aload 14
    //   964: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   967: iconst_5
    //   968: invokevirtual 252	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   971: aload 14
    //   973: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   976: iconst_1
    //   977: invokevirtual 255	android/media/MediaPlayer:setLooping	(Z)V
    //   980: aload 14
    //   982: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   985: invokevirtual 258	android/media/MediaPlayer:prepare	()V
    //   988: aload 14
    //   990: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   993: iconst_0
    //   994: invokevirtual 255	android/media/MediaPlayer:setLooping	(Z)V
    //   997: aload 14
    //   999: getfield 113	com/tencent/mm/booter/notification/a/f:ebt	Landroid/media/MediaPlayer;
    //   1002: invokevirtual 265	android/media/MediaPlayer:start	()V
    //   1005: aload 14
    //   1007: iconst_1
    //   1008: putfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   1011: aload 14
    //   1013: getfield 100	com/tencent/mm/booter/notification/a/f:ebs	Z
    //   1016: istore 10
    //   1018: invokestatic 331	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   1021: ifnull +58 -> 1079
    //   1024: iconst_1
    //   1025: istore 8
    //   1027: invokestatic 334	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1030: ifnull +55 -> 1085
    //   1033: iconst_1
    //   1034: istore 9
    //   1036: ldc 54
    //   1038: ldc_w 336
    //   1041: iconst_3
    //   1042: anewarray 4	java/lang/Object
    //   1045: dup
    //   1046: iconst_0
    //   1047: iload 10
    //   1049: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1052: aastore
    //   1053: dup
    //   1054: iconst_1
    //   1055: iload 8
    //   1057: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1060: aastore
    //   1061: dup
    //   1062: iconst_2
    //   1063: iload 9
    //   1065: invokestatic 106	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1068: aastore
    //   1069: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1072: sipush 16025
    //   1075: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1078: return
    //   1079: iconst_0
    //   1080: istore 8
    //   1082: goto -55 -> 1027
    //   1085: iconst_0
    //   1086: istore 9
    //   1088: goto -52 -> 1036
    //   1091: astore 13
    //   1093: ldc 54
    //   1095: aload 13
    //   1097: ldc_w 338
    //   1100: iconst_0
    //   1101: anewarray 4	java/lang/Object
    //   1104: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1107: sipush 16025
    //   1110: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1113: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1114	0	this	2
    //   364	275	1	f1	float
    //   381	259	2	f2	float
    //   394	76	3	f3	float
    //   400	78	4	f4	float
    //   372	73	5	f5	float
    //   389	64	6	f6	float
    //   83	3	7	i	int
    //   22	1059	8	bool1	boolean
    //   148	939	9	bool2	boolean
    //   1016	32	10	bool3	boolean
    //   259	59	11	l	long
    //   273	15	13	localUri1	android.net.Uri
    //   674	5	13	localException1	java.lang.Exception
    //   713	1	13	localIllegalStateException	java.lang.IllegalStateException
    //   760	39	13	localObject	Object
    //   803	1	13	localIOException	java.io.IOException
    //   817	10	13	localUri2	android.net.Uri
    //   1091	5	13	localException2	java.lang.Exception
    //   10	1002	14	localf	f
    //   16	907	15	str	String
    //   75	836	16	localAudioManager	android.media.AudioManager
    //   254	566	17	localMediaPlayer	android.media.MediaPlayer
    // Exception table:
    //   from	to	target	type
    //   62	85	674	java/lang/Exception
    //   97	150	674	java/lang/Exception
    //   155	182	674	java/lang/Exception
    //   182	212	674	java/lang/Exception
    //   212	218	674	java/lang/Exception
    //   218	275	674	java/lang/Exception
    //   280	292	674	java/lang/Exception
    //   292	469	674	java/lang/Exception
    //   481	499	674	java/lang/Exception
    //   499	566	674	java/lang/Exception
    //   566	604	674	java/lang/Exception
    //   604	673	674	java/lang/Exception
    //   715	739	674	java/lang/Exception
    //   747	787	674	java/lang/Exception
    //   793	800	674	java/lang/Exception
    //   805	831	674	java/lang/Exception
    //   834	859	674	java/lang/Exception
    //   862	896	674	java/lang/Exception
    //   899	1024	674	java/lang/Exception
    //   1027	1033	674	java/lang/Exception
    //   1036	1072	674	java/lang/Exception
    //   155	182	713	java/lang/IllegalStateException
    //   182	212	713	java/lang/IllegalStateException
    //   280	292	803	java/io/IOException
    //   690	706	1091	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.f.2
 * JD-Core Version:    0.7.0.1
 */