package com.tencent.mm.modelvoice;

final class i$a
  implements Runnable
{
  private i$a(i parami) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: bipush 240
    //   2: invokestatic 31	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   9: invokestatic 35	com/tencent/mm/modelvoice/i:g	(Lcom/tencent/mm/modelvoice/i;)I
    //   12: iconst_2
    //   13: iconst_2
    //   14: invokestatic 41	android/media/AudioTrack:getMinBufferSize	(III)I
    //   17: iconst_2
    //   18: imul
    //   19: istore_2
    //   20: iload_2
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_0
    //   25: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   28: invokestatic 35	com/tencent/mm/modelvoice/i:g	(Lcom/tencent/mm/modelvoice/i;)I
    //   31: bipush 20
    //   33: imul
    //   34: sipush 1000
    //   37: idiv
    //   38: i2s
    //   39: istore_1
    //   40: ldc 43
    //   42: ldc 45
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: iload_1
    //   51: invokestatic 51	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: iload_2
    //   58: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: invokestatic 62	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: ldc 43
    //   67: ldc 64
    //   69: invokestatic 68	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   76: invokestatic 71	com/tencent/mm/modelvoice/i:h	(Lcom/tencent/mm/modelvoice/i;)I
    //   79: iconst_1
    //   80: if_icmpeq +14 -> 94
    //   83: aload_0
    //   84: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   87: invokestatic 71	com/tencent/mm/modelvoice/i:h	(Lcom/tencent/mm/modelvoice/i;)I
    //   90: iconst_2
    //   91: if_icmpne +779 -> 870
    //   94: invokestatic 75	com/tencent/mm/modelvoice/i:Tb	()Ljava/lang/Object;
    //   97: astore 4
    //   99: aload 4
    //   101: monitorenter
    //   102: invokestatic 79	com/tencent/mm/modelvoice/i:Tc	()I
    //   105: aload_0
    //   106: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   109: invokestatic 81	com/tencent/mm/modelvoice/i:i	(Lcom/tencent/mm/modelvoice/i;)I
    //   112: if_icmpeq +50 -> 162
    //   115: ldc 43
    //   117: ldc 83
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_0
    //   126: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   129: invokestatic 81	com/tencent/mm/modelvoice/i:i	(Lcom/tencent/mm/modelvoice/i;)I
    //   132: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: invokestatic 79	com/tencent/mm/modelvoice/i:Tc	()I
    //   141: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 85	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   152: aload_0
    //   153: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   156: invokestatic 89	com/tencent/mm/modelvoice/i:e	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   159: invokestatic 92	com/tencent/mm/modelvoice/i:a	(Lcom/tencent/mm/modelvoice/i;Ljava/lang/String;)V
    //   162: aload 4
    //   164: monitorexit
    //   165: aload_0
    //   166: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   169: invokestatic 96	com/tencent/mm/modelvoice/i:j	(Lcom/tencent/mm/modelvoice/i;)Z
    //   172: ifeq +201 -> 373
    //   175: ldc 43
    //   177: ldc 98
    //   179: invokestatic 100	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc2_w 101
    //   185: invokestatic 108	java/lang/Thread:sleep	(J)V
    //   188: goto -23 -> 165
    //   191: astore_3
    //   192: getstatic 114	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   195: ldc2_w 115
    //   198: lconst_0
    //   199: lconst_1
    //   200: iconst_0
    //   201: invokevirtual 119	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   204: ldc 43
    //   206: ldc 121
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_3
    //   215: invokestatic 126	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: aload_0
    //   223: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   226: invokestatic 132	com/tencent/mm/modelvoice/i:o	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/MediaPlayer$OnErrorListener;
    //   229: ifnull +19 -> 248
    //   232: aload_0
    //   233: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   236: invokestatic 132	com/tencent/mm/modelvoice/i:o	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/MediaPlayer$OnErrorListener;
    //   239: aconst_null
    //   240: iconst_0
    //   241: iconst_0
    //   242: invokeinterface 138 4 0
    //   247: pop
    //   248: aload_0
    //   249: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   252: iconst_0
    //   253: invokestatic 141	com/tencent/mm/modelvoice/i:a	(Lcom/tencent/mm/modelvoice/i;I)I
    //   256: pop
    //   257: invokestatic 75	com/tencent/mm/modelvoice/i:Tb	()Ljava/lang/Object;
    //   260: astore_3
    //   261: aload_3
    //   262: monitorenter
    //   263: invokestatic 79	com/tencent/mm/modelvoice/i:Tc	()I
    //   266: aload_0
    //   267: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   270: invokestatic 81	com/tencent/mm/modelvoice/i:i	(Lcom/tencent/mm/modelvoice/i;)I
    //   273: if_icmpne +35 -> 308
    //   276: invokestatic 146	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	()I
    //   279: pop
    //   280: ldc 43
    //   282: ldc 148
    //   284: iconst_1
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: aload_0
    //   291: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   294: invokestatic 81	com/tencent/mm/modelvoice/i:i	(Lcom/tencent/mm/modelvoice/i;)I
    //   297: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: aastore
    //   301: invokestatic 85	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: invokestatic 151	com/tencent/mm/modelvoice/i:Td	()I
    //   307: pop
    //   308: aload_3
    //   309: monitorexit
    //   310: aload_0
    //   311: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   314: invokestatic 71	com/tencent/mm/modelvoice/i:h	(Lcom/tencent/mm/modelvoice/i;)I
    //   317: iconst_3
    //   318: if_icmpeq +579 -> 897
    //   321: aload_0
    //   322: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   325: invokestatic 155	com/tencent/mm/modelvoice/i:p	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/modelvoice/d$a;
    //   328: ifnull +15 -> 343
    //   331: aload_0
    //   332: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   335: invokestatic 155	com/tencent/mm/modelvoice/i:p	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/modelvoice/d$a;
    //   338: invokeinterface 160 1 0
    //   343: aload_0
    //   344: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   347: invokestatic 164	com/tencent/mm/modelvoice/i:q	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/MediaPlayer$OnCompletionListener;
    //   350: ifnull +16 -> 366
    //   353: aload_0
    //   354: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   357: invokestatic 164	com/tencent/mm/modelvoice/i:q	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/MediaPlayer$OnCompletionListener;
    //   360: aconst_null
    //   361: invokeinterface 170 2 0
    //   366: return
    //   367: astore_3
    //   368: aload 4
    //   370: monitorexit
    //   371: aload_3
    //   372: athrow
    //   373: aload_3
    //   374: iload_1
    //   375: invokestatic 174	com/tencent/mm/modelvoice/MediaRecorder:SilkDoDec	([BS)I
    //   378: istore_2
    //   379: iload_2
    //   380: ifge +98 -> 478
    //   383: aload_0
    //   384: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   387: iconst_0
    //   388: invokestatic 141	com/tencent/mm/modelvoice/i:a	(Lcom/tencent/mm/modelvoice/i;I)I
    //   391: pop
    //   392: getstatic 114	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   395: ldc2_w 115
    //   398: lconst_0
    //   399: lconst_1
    //   400: iconst_0
    //   401: invokevirtual 119	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   404: getstatic 114	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   407: ldc2_w 115
    //   410: ldc2_w 175
    //   413: lconst_1
    //   414: iconst_0
    //   415: invokevirtual 119	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   418: ldc 43
    //   420: ldc 178
    //   422: iconst_2
    //   423: anewarray 4	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: aload_0
    //   429: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   432: invokestatic 81	com/tencent/mm/modelvoice/i:i	(Lcom/tencent/mm/modelvoice/i;)I
    //   435: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: dup
    //   440: iconst_1
    //   441: iload_2
    //   442: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: aload_0
    //   450: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   453: invokestatic 182	com/tencent/mm/modelvoice/i:k	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/f/c/b;
    //   456: ifnull -384 -> 72
    //   459: getstatic 188	com/tencent/mm/platformtools/ae:eTt	Z
    //   462: ifeq -390 -> 72
    //   465: aload_0
    //   466: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   469: invokestatic 182	com/tencent/mm/modelvoice/i:k	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/f/c/b;
    //   472: invokevirtual 193	com/tencent/mm/f/c/b:uG	()V
    //   475: goto -403 -> 72
    //   478: getstatic 188	com/tencent/mm/platformtools/ae:eTt	Z
    //   481: ifeq +28 -> 509
    //   484: aload_0
    //   485: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   488: invokestatic 182	com/tencent/mm/modelvoice/i:k	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/f/c/b;
    //   491: ifnull +18 -> 509
    //   494: aload_0
    //   495: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   498: invokestatic 182	com/tencent/mm/modelvoice/i:k	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/f/c/b;
    //   501: aload_3
    //   502: iload_1
    //   503: iconst_2
    //   504: imul
    //   505: invokevirtual 197	com/tencent/mm/f/c/b:v	([BI)Z
    //   508: pop
    //   509: aload_0
    //   510: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   513: invokestatic 201	com/tencent/mm/modelvoice/i:c	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/AudioTrack;
    //   516: aload_3
    //   517: iconst_0
    //   518: iload_1
    //   519: iconst_2
    //   520: imul
    //   521: invokevirtual 205	android/media/AudioTrack:write	([BII)I
    //   524: pop
    //   525: aload_0
    //   526: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   529: invokestatic 208	com/tencent/mm/modelvoice/i:l	(Lcom/tencent/mm/modelvoice/i;)I
    //   532: pop
    //   533: iload_2
    //   534: ifne +126 -> 660
    //   537: aload_0
    //   538: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   541: iconst_0
    //   542: invokestatic 141	com/tencent/mm/modelvoice/i:a	(Lcom/tencent/mm/modelvoice/i;I)I
    //   545: pop
    //   546: ldc 43
    //   548: ldc 210
    //   550: iconst_1
    //   551: anewarray 4	java/lang/Object
    //   554: dup
    //   555: iconst_0
    //   556: aload_0
    //   557: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   560: invokestatic 81	com/tencent/mm/modelvoice/i:i	(Lcom/tencent/mm/modelvoice/i;)I
    //   563: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: aastore
    //   567: invokestatic 85	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   570: aload_0
    //   571: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   574: invokestatic 182	com/tencent/mm/modelvoice/i:k	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/f/c/b;
    //   577: ifnull -505 -> 72
    //   580: getstatic 188	com/tencent/mm/platformtools/ae:eTt	Z
    //   583: ifeq -511 -> 72
    //   586: aload_0
    //   587: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   590: invokestatic 182	com/tencent/mm/modelvoice/i:k	(Lcom/tencent/mm/modelvoice/i;)Lcom/tencent/mm/f/c/b;
    //   593: invokevirtual 193	com/tencent/mm/f/c/b:uG	()V
    //   596: new 212	com/tencent/mm/modelvoice/i$a$1
    //   599: dup
    //   600: aload_0
    //   601: invokespecial 215	com/tencent/mm/modelvoice/i$a$1:<init>	(Lcom/tencent/mm/modelvoice/i$a;)V
    //   604: invokestatic 220	com/tencent/mm/sdk/platformtools/ai:d	(Ljava/lang/Runnable;)V
    //   607: goto -535 -> 72
    //   610: astore 4
    //   612: ldc 43
    //   614: ldc 222
    //   616: iconst_1
    //   617: anewarray 4	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: aload 4
    //   624: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   627: aastore
    //   628: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   631: getstatic 114	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   634: ldc2_w 115
    //   637: lconst_0
    //   638: lconst_1
    //   639: iconst_0
    //   640: invokevirtual 119	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   643: getstatic 114	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   646: ldc2_w 115
    //   649: ldc2_w 227
    //   652: lconst_1
    //   653: iconst_0
    //   654: invokevirtual 119	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   657: goto -132 -> 525
    //   660: aload_0
    //   661: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   664: invokestatic 71	com/tencent/mm/modelvoice/i:h	(Lcom/tencent/mm/modelvoice/i;)I
    //   667: iconst_2
    //   668: if_icmpne +144 -> 812
    //   671: aload_0
    //   672: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   675: invokestatic 231	com/tencent/mm/modelvoice/i:m	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   678: astore 4
    //   680: aload 4
    //   682: monitorenter
    //   683: ldc 43
    //   685: ldc 233
    //   687: invokestatic 235	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: aload_0
    //   691: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   694: invokestatic 231	com/tencent/mm/modelvoice/i:m	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   697: invokevirtual 238	java/lang/Object:notify	()V
    //   700: ldc 43
    //   702: ldc 240
    //   704: invokestatic 235	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   707: aload 4
    //   709: monitorexit
    //   710: aload_0
    //   711: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   714: invokestatic 243	com/tencent/mm/modelvoice/i:n	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   717: astore 4
    //   719: aload 4
    //   721: monitorenter
    //   722: ldc 43
    //   724: ldc 245
    //   726: invokestatic 235	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   729: aload_0
    //   730: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   733: invokestatic 243	com/tencent/mm/modelvoice/i:n	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   736: invokevirtual 248	java/lang/Object:wait	()V
    //   739: ldc 43
    //   741: ldc 250
    //   743: invokestatic 235	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload 4
    //   748: monitorexit
    //   749: goto -677 -> 72
    //   752: astore_3
    //   753: aload 4
    //   755: monitorexit
    //   756: aload_3
    //   757: athrow
    //   758: astore 5
    //   760: ldc 43
    //   762: ldc 121
    //   764: iconst_1
    //   765: anewarray 4	java/lang/Object
    //   768: dup
    //   769: iconst_0
    //   770: aload 5
    //   772: invokestatic 126	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   775: aastore
    //   776: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   779: goto -72 -> 707
    //   782: astore_3
    //   783: aload 4
    //   785: monitorexit
    //   786: aload_3
    //   787: athrow
    //   788: astore 5
    //   790: ldc 43
    //   792: ldc 121
    //   794: iconst_1
    //   795: anewarray 4	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload 5
    //   802: invokestatic 126	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   805: aastore
    //   806: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   809: goto -63 -> 746
    //   812: aload_0
    //   813: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   816: invokestatic 231	com/tencent/mm/modelvoice/i:m	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   819: astore 4
    //   821: aload 4
    //   823: monitorenter
    //   824: aload_0
    //   825: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   828: invokestatic 231	com/tencent/mm/modelvoice/i:m	(Lcom/tencent/mm/modelvoice/i;)Ljava/lang/String;
    //   831: invokevirtual 238	java/lang/Object:notify	()V
    //   834: aload 4
    //   836: monitorexit
    //   837: goto -765 -> 72
    //   840: astore_3
    //   841: aload 4
    //   843: monitorexit
    //   844: aload_3
    //   845: athrow
    //   846: astore 5
    //   848: ldc 43
    //   850: ldc 121
    //   852: iconst_1
    //   853: anewarray 4	java/lang/Object
    //   856: dup
    //   857: iconst_0
    //   858: aload 5
    //   860: invokestatic 126	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   863: aastore
    //   864: invokestatic 128	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   867: goto -33 -> 834
    //   870: aload_0
    //   871: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   874: invokestatic 71	com/tencent/mm/modelvoice/i:h	(Lcom/tencent/mm/modelvoice/i;)I
    //   877: iconst_3
    //   878: if_icmpeq -621 -> 257
    //   881: ldc2_w 251
    //   884: invokestatic 108	java/lang/Thread:sleep	(J)V
    //   887: goto -630 -> 257
    //   890: astore 4
    //   892: aload_3
    //   893: monitorexit
    //   894: aload 4
    //   896: athrow
    //   897: aload_0
    //   898: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   901: invokestatic 201	com/tencent/mm/modelvoice/i:c	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/AudioTrack;
    //   904: ifnull -538 -> 366
    //   907: ldc 43
    //   909: ldc 254
    //   911: invokestatic 68	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload_0
    //   915: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   918: invokestatic 201	com/tencent/mm/modelvoice/i:c	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/AudioTrack;
    //   921: invokevirtual 257	android/media/AudioTrack:stop	()V
    //   924: aload_0
    //   925: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   928: invokestatic 201	com/tencent/mm/modelvoice/i:c	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/AudioTrack;
    //   931: invokevirtual 260	android/media/AudioTrack:release	()V
    //   934: aload_0
    //   935: getfield 15	com/tencent/mm/modelvoice/i$a:eKx	Lcom/tencent/mm/modelvoice/i;
    //   938: invokestatic 262	com/tencent/mm/modelvoice/i:d	(Lcom/tencent/mm/modelvoice/i;)Landroid/media/AudioTrack;
    //   941: pop
    //   942: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	943	0	this	a
    //   39	482	1	s	short
    //   19	515	2	i	int
    //   23	1	3	arrayOfByte1	byte[]
    //   191	24	3	localException1	java.lang.Exception
    //   260	49	3	localObject1	Object
    //   367	150	3	arrayOfByte2	byte[]
    //   752	5	3	localObject2	Object
    //   782	5	3	localObject3	Object
    //   840	53	3	localObject4	Object
    //   97	272	4	localObject5	Object
    //   610	13	4	localException2	java.lang.Exception
    //   890	5	4	localObject6	Object
    //   758	13	5	localException3	java.lang.Exception
    //   788	13	5	localException4	java.lang.Exception
    //   846	13	5	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	72	191	java/lang/Exception
    //   72	94	191	java/lang/Exception
    //   94	102	191	java/lang/Exception
    //   165	188	191	java/lang/Exception
    //   371	373	191	java/lang/Exception
    //   373	379	191	java/lang/Exception
    //   383	475	191	java/lang/Exception
    //   478	509	191	java/lang/Exception
    //   525	533	191	java/lang/Exception
    //   537	607	191	java/lang/Exception
    //   612	657	191	java/lang/Exception
    //   660	683	191	java/lang/Exception
    //   710	722	191	java/lang/Exception
    //   756	758	191	java/lang/Exception
    //   786	788	191	java/lang/Exception
    //   812	824	191	java/lang/Exception
    //   844	846	191	java/lang/Exception
    //   870	887	191	java/lang/Exception
    //   102	162	367	finally
    //   162	165	367	finally
    //   368	371	367	finally
    //   509	525	610	java/lang/Exception
    //   722	746	752	finally
    //   746	749	752	finally
    //   753	756	752	finally
    //   790	809	752	finally
    //   683	707	758	java/lang/Exception
    //   683	707	782	finally
    //   707	710	782	finally
    //   760	779	782	finally
    //   783	786	782	finally
    //   722	746	788	java/lang/Exception
    //   824	834	840	finally
    //   834	837	840	finally
    //   841	844	840	finally
    //   848	867	840	finally
    //   824	834	846	java/lang/Exception
    //   263	308	890	finally
    //   308	310	890	finally
    //   892	894	890	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.i.a
 * JD-Core Version:    0.7.0.1
 */