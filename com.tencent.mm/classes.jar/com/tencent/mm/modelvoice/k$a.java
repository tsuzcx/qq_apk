package com.tencent.mm.modelvoice;

final class k$a
  implements Runnable
{
  private k$a(k paramk) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 240
    //   7: invokestatic 37	android/os/Process:setThreadPriority	(I)V
    //   10: aload_0
    //   11: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   14: invokestatic 41	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
    //   17: iconst_2
    //   18: iconst_2
    //   19: invokestatic 47	android/media/AudioTrack:getMinBufferSize	(III)I
    //   22: iconst_2
    //   23: imul
    //   24: istore_2
    //   25: iload_2
    //   26: newarray byte
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   33: invokestatic 41	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
    //   36: bipush 20
    //   38: imul
    //   39: sipush 1000
    //   42: idiv
    //   43: i2s
    //   44: istore_1
    //   45: ldc 49
    //   47: ldc 51
    //   49: iconst_2
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: iload_1
    //   56: invokestatic 57	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: iload_2
    //   63: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: ldc 49
    //   72: ldc 70
    //   74: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   81: invokestatic 76	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
    //   84: iconst_1
    //   85: if_icmpeq +14 -> 99
    //   88: aload_0
    //   89: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   92: invokestatic 76	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
    //   95: iconst_2
    //   96: if_icmpne +948 -> 1044
    //   99: invokestatic 80	com/tencent/mm/modelvoice/k:access$800	()Ljava/lang/Object;
    //   102: astore 4
    //   104: aload 4
    //   106: monitorenter
    //   107: invokestatic 84	com/tencent/mm/modelvoice/k:amn	()I
    //   110: aload_0
    //   111: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   114: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   117: if_icmpeq +83 -> 200
    //   120: ldc 49
    //   122: ldc 88
    //   124: iconst_2
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_0
    //   131: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   134: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   137: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: invokestatic 84	com/tencent/mm/modelvoice/k:amn	()I
    //   146: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: aastore
    //   150: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   157: invokestatic 93	com/tencent/mm/modelvoice/k:j	(Lcom/tencent/mm/modelvoice/k;)I
    //   160: pop
    //   161: aload_0
    //   162: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   165: invokestatic 96	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)I
    //   168: iconst_3
    //   169: if_icmple +17 -> 186
    //   172: getstatic 102	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   175: ldc2_w 103
    //   178: ldc2_w 105
    //   181: lconst_1
    //   182: iconst_0
    //   183: invokevirtual 110	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   186: aload_0
    //   187: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   190: aload_0
    //   191: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   194: invokestatic 114	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   197: invokestatic 117	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;Ljava/lang/String;)V
    //   200: aload 4
    //   202: monitorexit
    //   203: aload_0
    //   204: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   207: invokestatic 121	com/tencent/mm/modelvoice/k:l	(Lcom/tencent/mm/modelvoice/k;)Z
    //   210: ifeq +239 -> 449
    //   213: ldc 49
    //   215: ldc 123
    //   217: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: ldc2_w 126
    //   223: invokestatic 133	java/lang/Thread:sleep	(J)V
    //   226: goto -23 -> 203
    //   229: astore_3
    //   230: getstatic 102	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   233: ldc2_w 103
    //   236: lconst_0
    //   237: lconst_1
    //   238: iconst_0
    //   239: invokevirtual 110	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   242: ldc 49
    //   244: ldc 135
    //   246: iconst_1
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload_3
    //   253: invokestatic 140	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   256: aastore
    //   257: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_0
    //   261: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   264: invokestatic 146	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
    //   267: ifnull +19 -> 286
    //   270: aload_0
    //   271: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   274: invokestatic 146	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
    //   277: aconst_null
    //   278: iconst_0
    //   279: iconst_0
    //   280: invokeinterface 152 4 0
    //   285: pop
    //   286: aload_0
    //   287: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   290: iconst_0
    //   291: invokestatic 155	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
    //   294: pop
    //   295: invokestatic 80	com/tencent/mm/modelvoice/k:access$800	()Ljava/lang/Object;
    //   298: astore_3
    //   299: aload_3
    //   300: monitorenter
    //   301: invokestatic 84	com/tencent/mm/modelvoice/k:amn	()I
    //   304: aload_0
    //   305: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   308: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   311: if_icmpne +63 -> 374
    //   314: aload_0
    //   315: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   318: invokestatic 159	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
    //   321: ifnull +53 -> 374
    //   324: aload_0
    //   325: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   328: invokestatic 159	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
    //   331: getfield 165	com/tencent/mm/modelvoice/h:fZH	J
    //   334: invokestatic 171	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
    //   337: pop
    //   338: ldc 49
    //   340: ldc 173
    //   342: iconst_1
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload_0
    //   349: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   352: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   355: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: aastore
    //   359: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: invokestatic 176	com/tencent/mm/modelvoice/k:amo	()I
    //   365: pop
    //   366: aload_0
    //   367: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   370: invokestatic 179	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)I
    //   373: pop
    //   374: aload_3
    //   375: monitorexit
    //   376: aload_0
    //   377: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   380: invokestatic 76	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
    //   383: iconst_3
    //   384: if_icmpeq +692 -> 1076
    //   387: aload_0
    //   388: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   391: invokestatic 183	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$a;
    //   394: ifnull +15 -> 409
    //   397: aload_0
    //   398: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   401: invokestatic 183	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$a;
    //   404: invokeinterface 188 1 0
    //   409: aload_0
    //   410: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   413: invokestatic 192	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnCompletionListener;
    //   416: ifnull +706 -> 1122
    //   419: aload_0
    //   420: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   423: invokestatic 192	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnCompletionListener;
    //   426: aconst_null
    //   427: invokeinterface 198 2 0
    //   432: ldc 26
    //   434: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: return
    //   438: astore_3
    //   439: aload 4
    //   441: monitorexit
    //   442: ldc 26
    //   444: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aload_3
    //   448: athrow
    //   449: aload_0
    //   450: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   453: invokestatic 159	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
    //   456: ifnull +115 -> 571
    //   459: aload_0
    //   460: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   463: invokestatic 159	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
    //   466: aload_3
    //   467: iload_1
    //   468: invokevirtual 204	com/tencent/mm/modelvoice/h:a	([BS)I
    //   471: istore_2
    //   472: iload_2
    //   473: ifge +160 -> 633
    //   476: aload_0
    //   477: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   480: iconst_0
    //   481: invokestatic 155	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
    //   484: pop
    //   485: getstatic 102	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   488: ldc2_w 103
    //   491: lconst_0
    //   492: lconst_1
    //   493: iconst_0
    //   494: invokevirtual 110	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   497: getstatic 102	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   500: ldc2_w 103
    //   503: ldc2_w 205
    //   506: lconst_1
    //   507: iconst_0
    //   508: invokevirtual 110	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   511: ldc 49
    //   513: ldc 208
    //   515: iconst_2
    //   516: anewarray 4	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload_0
    //   522: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   525: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   528: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: dup
    //   533: iconst_1
    //   534: iload_2
    //   535: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: aload_0
    //   543: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   546: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   549: ifnull -472 -> 77
    //   552: getstatic 218	com/tencent/mm/platformtools/ae:glo	Z
    //   555: ifeq -478 -> 77
    //   558: aload_0
    //   559: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   562: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   565: invokevirtual 223	com/tencent/mm/audio/e/b:EZ	()V
    //   568: goto -491 -> 77
    //   571: aload_0
    //   572: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   575: iconst_0
    //   576: invokestatic 155	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
    //   579: pop
    //   580: ldc 49
    //   582: ldc 225
    //   584: iconst_1
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload_0
    //   591: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   594: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   597: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   600: aastore
    //   601: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   604: aload_0
    //   605: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   608: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   611: ifnull -534 -> 77
    //   614: getstatic 218	com/tencent/mm/platformtools/ae:glo	Z
    //   617: ifeq -540 -> 77
    //   620: aload_0
    //   621: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   624: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   627: invokevirtual 223	com/tencent/mm/audio/e/b:EZ	()V
    //   630: goto -553 -> 77
    //   633: getstatic 218	com/tencent/mm/platformtools/ae:glo	Z
    //   636: ifeq +28 -> 664
    //   639: aload_0
    //   640: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   643: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   646: ifnull +18 -> 664
    //   649: aload_0
    //   650: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   653: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   656: aload_3
    //   657: iload_1
    //   658: iconst_2
    //   659: imul
    //   660: invokevirtual 229	com/tencent/mm/audio/e/b:x	([BI)Z
    //   663: pop
    //   664: aload_0
    //   665: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   668: invokestatic 233	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
    //   671: aload_3
    //   672: iconst_0
    //   673: iload_1
    //   674: iconst_2
    //   675: imul
    //   676: invokevirtual 237	android/media/AudioTrack:write	([BII)I
    //   679: pop
    //   680: aload_0
    //   681: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   684: invokestatic 239	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)I
    //   687: pop
    //   688: iload_2
    //   689: ifne +126 -> 815
    //   692: aload_0
    //   693: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   696: iconst_0
    //   697: invokestatic 155	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
    //   700: pop
    //   701: ldc 49
    //   703: ldc 241
    //   705: iconst_1
    //   706: anewarray 4	java/lang/Object
    //   709: dup
    //   710: iconst_0
    //   711: aload_0
    //   712: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   715: invokestatic 86	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
    //   718: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   721: aastore
    //   722: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: aload_0
    //   726: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   729: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   732: ifnull -655 -> 77
    //   735: getstatic 218	com/tencent/mm/platformtools/ae:glo	Z
    //   738: ifeq -661 -> 77
    //   741: aload_0
    //   742: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   745: invokestatic 212	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
    //   748: invokevirtual 223	com/tencent/mm/audio/e/b:EZ	()V
    //   751: new 243	com/tencent/mm/modelvoice/k$a$1
    //   754: dup
    //   755: aload_0
    //   756: invokespecial 246	com/tencent/mm/modelvoice/k$a$1:<init>	(Lcom/tencent/mm/modelvoice/k$a;)V
    //   759: invokestatic 251	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   762: goto -685 -> 77
    //   765: astore 4
    //   767: ldc 49
    //   769: ldc 253
    //   771: iconst_1
    //   772: anewarray 4	java/lang/Object
    //   775: dup
    //   776: iconst_0
    //   777: aload 4
    //   779: invokevirtual 257	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   782: aastore
    //   783: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   786: getstatic 102	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   789: ldc2_w 103
    //   792: lconst_0
    //   793: lconst_1
    //   794: iconst_0
    //   795: invokevirtual 110	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   798: getstatic 102	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   801: ldc2_w 103
    //   804: ldc2_w 258
    //   807: lconst_1
    //   808: iconst_0
    //   809: invokevirtual 110	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   812: goto -132 -> 680
    //   815: aload_0
    //   816: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   819: invokestatic 76	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
    //   822: iconst_2
    //   823: if_icmpne +158 -> 981
    //   826: aload_0
    //   827: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   830: invokestatic 262	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   833: astore 4
    //   835: aload 4
    //   837: monitorenter
    //   838: ldc 49
    //   840: ldc_w 264
    //   843: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   846: aload_0
    //   847: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   850: invokestatic 262	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   853: invokevirtual 270	java/lang/Object:notify	()V
    //   856: ldc 49
    //   858: ldc_w 272
    //   861: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: aload 4
    //   866: monitorexit
    //   867: aload_0
    //   868: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   871: invokestatic 275	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   874: astore 4
    //   876: aload 4
    //   878: monitorenter
    //   879: ldc 49
    //   881: ldc_w 277
    //   884: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   887: aload_0
    //   888: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   891: invokestatic 275	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   894: invokevirtual 280	java/lang/Object:wait	()V
    //   897: ldc 49
    //   899: ldc_w 282
    //   902: invokestatic 267	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   905: aload 4
    //   907: monitorexit
    //   908: goto -831 -> 77
    //   911: astore_3
    //   912: aload 4
    //   914: monitorexit
    //   915: ldc 26
    //   917: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   920: aload_3
    //   921: athrow
    //   922: astore 5
    //   924: ldc 49
    //   926: ldc 135
    //   928: iconst_1
    //   929: anewarray 4	java/lang/Object
    //   932: dup
    //   933: iconst_0
    //   934: aload 5
    //   936: invokestatic 140	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   939: aastore
    //   940: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   943: goto -79 -> 864
    //   946: astore_3
    //   947: aload 4
    //   949: monitorexit
    //   950: ldc 26
    //   952: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   955: aload_3
    //   956: athrow
    //   957: astore 5
    //   959: ldc 49
    //   961: ldc 135
    //   963: iconst_1
    //   964: anewarray 4	java/lang/Object
    //   967: dup
    //   968: iconst_0
    //   969: aload 5
    //   971: invokestatic 140	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   974: aastore
    //   975: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   978: goto -73 -> 905
    //   981: aload_0
    //   982: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   985: invokestatic 262	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   988: astore 4
    //   990: aload 4
    //   992: monitorenter
    //   993: aload_0
    //   994: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   997: invokestatic 262	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
    //   1000: invokevirtual 270	java/lang/Object:notify	()V
    //   1003: aload 4
    //   1005: monitorexit
    //   1006: goto -929 -> 77
    //   1009: astore_3
    //   1010: aload 4
    //   1012: monitorexit
    //   1013: ldc 26
    //   1015: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1018: aload_3
    //   1019: athrow
    //   1020: astore 5
    //   1022: ldc 49
    //   1024: ldc 135
    //   1026: iconst_1
    //   1027: anewarray 4	java/lang/Object
    //   1030: dup
    //   1031: iconst_0
    //   1032: aload 5
    //   1034: invokestatic 140	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1037: aastore
    //   1038: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1041: goto -38 -> 1003
    //   1044: aload_0
    //   1045: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   1048: invokestatic 76	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
    //   1051: iconst_3
    //   1052: if_icmpeq -757 -> 295
    //   1055: ldc2_w 283
    //   1058: invokestatic 133	java/lang/Thread:sleep	(J)V
    //   1061: goto -766 -> 295
    //   1064: astore 4
    //   1066: aload_3
    //   1067: monitorexit
    //   1068: ldc 26
    //   1070: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1073: aload 4
    //   1075: athrow
    //   1076: aload_0
    //   1077: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   1080: invokestatic 233	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
    //   1083: ifnull +39 -> 1122
    //   1086: ldc 49
    //   1088: ldc_w 286
    //   1091: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1094: aload_0
    //   1095: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   1098: invokestatic 233	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
    //   1101: invokevirtual 289	android/media/AudioTrack:stop	()V
    //   1104: aload_0
    //   1105: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   1108: invokestatic 233	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
    //   1111: invokevirtual 292	android/media/AudioTrack:release	()V
    //   1114: aload_0
    //   1115: getfield 15	com/tencent/mm/modelvoice/k$a:gad	Lcom/tencent/mm/modelvoice/k;
    //   1118: invokestatic 294	com/tencent/mm/modelvoice/k:d	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
    //   1121: pop
    //   1122: ldc 26
    //   1124: invokestatic 201	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1127: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1128	0	this	a
    //   44	632	1	s	short
    //   24	665	2	i	int
    //   28	1	3	arrayOfByte1	byte[]
    //   229	24	3	localException1	java.lang.Exception
    //   298	77	3	localObject1	Object
    //   438	234	3	arrayOfByte2	byte[]
    //   911	10	3	localObject2	Object
    //   946	10	3	localObject3	Object
    //   1009	58	3	localObject4	Object
    //   102	338	4	localObject5	Object
    //   765	13	4	localException2	java.lang.Exception
    //   1064	10	4	localObject6	Object
    //   922	13	5	localException3	java.lang.Exception
    //   957	13	5	localException4	java.lang.Exception
    //   1020	13	5	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	77	229	java/lang/Exception
    //   77	99	229	java/lang/Exception
    //   99	107	229	java/lang/Exception
    //   203	226	229	java/lang/Exception
    //   442	449	229	java/lang/Exception
    //   449	472	229	java/lang/Exception
    //   476	568	229	java/lang/Exception
    //   571	630	229	java/lang/Exception
    //   633	664	229	java/lang/Exception
    //   680	688	229	java/lang/Exception
    //   692	762	229	java/lang/Exception
    //   767	812	229	java/lang/Exception
    //   815	838	229	java/lang/Exception
    //   867	879	229	java/lang/Exception
    //   915	922	229	java/lang/Exception
    //   950	957	229	java/lang/Exception
    //   981	993	229	java/lang/Exception
    //   1013	1020	229	java/lang/Exception
    //   1044	1061	229	java/lang/Exception
    //   107	186	438	finally
    //   186	200	438	finally
    //   200	203	438	finally
    //   439	442	438	finally
    //   664	680	765	java/lang/Exception
    //   879	905	911	finally
    //   905	908	911	finally
    //   912	915	911	finally
    //   959	978	911	finally
    //   838	864	922	java/lang/Exception
    //   838	864	946	finally
    //   864	867	946	finally
    //   924	943	946	finally
    //   947	950	946	finally
    //   879	905	957	java/lang/Exception
    //   993	1003	1009	finally
    //   1003	1006	1009	finally
    //   1010	1013	1009	finally
    //   1022	1041	1009	finally
    //   993	1003	1020	java/lang/Exception
    //   301	374	1064	finally
    //   374	376	1064	finally
    //   1066	1068	1064	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k.a
 * JD-Core Version:    0.7.0.1
 */