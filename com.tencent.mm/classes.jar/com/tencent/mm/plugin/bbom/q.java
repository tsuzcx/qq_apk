package com.tencent.mm.plugin.bbom;

import com.tencent.mm.plugin.zero.a.c;

public final class q
  implements c
{
  /* Error */
  public final void a(com.tencent.mm.booter.NotifyReceiver.NotifyService paramNotifyService, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong)
  {
    // Byte code:
    //   0: sipush 22380
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_2
    //   7: lookupswitch	default:+97->104, 10:+104->111, 102:+587->594, 120:+196->203, 174:+540->547, 192:+601->608, 241:+692->699, 271:+1332->1339, 318:+931->938, 319:+818->825, 3941:+1438->1445, 268369923:+632->639
    //   105: pop
    //   106: idiv
    //   107: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: ldc 28
    //   113: ldc 30
    //   115: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: new 38	com/tencent/mm/protocal/p$b
    //   121: dup
    //   122: invokespecial 39	com/tencent/mm/protocal/p$b:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 45	com/tencent/mm/compatible/deviceinfo/q:aoG	()Ljava/lang/String;
    //   130: putfield 49	com/tencent/mm/protocal/p$b:deviceID	Ljava/lang/String;
    //   133: new 51	com/tencent/mm/ak/z
    //   136: dup
    //   137: aload_1
    //   138: bipush 10
    //   140: invokespecial 54	com/tencent/mm/ak/z:<init>	(Lcom/tencent/mm/protocal/l$e;I)V
    //   143: astore 4
    //   145: aload 4
    //   147: bipush 10
    //   149: aload_3
    //   150: aconst_null
    //   151: lconst_0
    //   152: invokevirtual 57	com/tencent/mm/ak/z:a	(I[B[BJ)Z
    //   155: ifeq +21 -> 176
    //   158: invokestatic 63	com/tencent/mm/model/bg:azz	()Lcom/tencent/mm/ak/t;
    //   161: iconst_0
    //   162: iconst_0
    //   163: ldc 65
    //   165: new 67	com/tencent/mm/modelsimple/j
    //   168: dup
    //   169: aload_1
    //   170: invokespecial 70	com/tencent/mm/modelsimple/j:<init>	(Lcom/tencent/mm/protocal/l$e;)V
    //   173: invokevirtual 76	com/tencent/mm/ak/t:onSceneEnd	(IILjava/lang/String;Lcom/tencent/mm/ak/q;)V
    //   176: sipush 22380
    //   179: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_1
    //   184: ldc 28
    //   186: aload_1
    //   187: ldc 65
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 80	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: sipush 22380
    //   199: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: ldc 82
    //   205: invokestatic 88	com/tencent/mm/booter/NotifyReceiver$NotifyService:CP	(Ljava/lang/String;)V
    //   208: new 90	com/tencent/mm/g/a/xq
    //   211: dup
    //   212: invokespecial 91	com/tencent/mm/g/a/xq:<init>	()V
    //   215: astore_1
    //   216: aload_1
    //   217: getfield 95	com/tencent/mm/g/a/xq:edR	Lcom/tencent/mm/g/a/xq$a;
    //   220: iconst_1
    //   221: putfield 101	com/tencent/mm/g/a/xq$a:edT	Z
    //   224: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   227: aload_1
    //   228: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   231: pop
    //   232: aload_1
    //   233: getfield 115	com/tencent/mm/g/a/xq:edS	Lcom/tencent/mm/g/a/xq$b;
    //   236: getfield 120	com/tencent/mm/g/a/xq$b:edV	Ljava/lang/String;
    //   239: astore_1
    //   240: aload_1
    //   241: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   244: ifne +41 -> 285
    //   247: ldc 28
    //   249: ldc 128
    //   251: aload_1
    //   252: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   255: invokevirtual 138	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   258: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: new 90	com/tencent/mm/g/a/xq
    //   264: dup
    //   265: invokespecial 91	com/tencent/mm/g/a/xq:<init>	()V
    //   268: astore_1
    //   269: aload_1
    //   270: getfield 95	com/tencent/mm/g/a/xq:edR	Lcom/tencent/mm/g/a/xq$a;
    //   273: iconst_1
    //   274: putfield 144	com/tencent/mm/g/a/xq$a:edU	Z
    //   277: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   280: aload_1
    //   281: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   284: pop
    //   285: aload_3
    //   286: ifnull -182 -> 104
    //   289: aload_3
    //   290: arraylength
    //   291: ifle -187 -> 104
    //   294: aload_3
    //   295: iconst_0
    //   296: baload
    //   297: iconst_1
    //   298: if_icmpne +49 -> 347
    //   301: ldc 28
    //   303: ldc 146
    //   305: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: new 148	com/tencent/mm/g/a/zj
    //   311: dup
    //   312: invokespecial 149	com/tencent/mm/g/a/zj:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   320: iconst_3
    //   321: putfield 159	com/tencent/mm/g/a/zj$a:dKy	I
    //   324: aload_1
    //   325: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   328: aload_3
    //   329: putfield 163	com/tencent/mm/g/a/zj$a:efs	[B
    //   332: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   335: aload_1
    //   336: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   339: pop
    //   340: sipush 22380
    //   343: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: return
    //   347: aload_3
    //   348: iconst_0
    //   349: baload
    //   350: bipush 101
    //   352: if_icmpne +41 -> 393
    //   355: ldc 28
    //   357: ldc 165
    //   359: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: new 167	com/tencent/mm/g/a/kx
    //   365: dup
    //   366: invokespecial 168	com/tencent/mm/g/a/kx:<init>	()V
    //   369: astore_1
    //   370: aload_1
    //   371: getfield 172	com/tencent/mm/g/a/kx:dPZ	Lcom/tencent/mm/g/a/kx$a;
    //   374: aload_3
    //   375: putfield 177	com/tencent/mm/g/a/kx$a:dQa	[B
    //   378: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   381: aload_1
    //   382: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   385: pop
    //   386: sipush 22380
    //   389: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: return
    //   393: aload_3
    //   394: iconst_0
    //   395: baload
    //   396: iconst_3
    //   397: if_icmpne +50 -> 447
    //   400: ldc 28
    //   402: ldc 179
    //   404: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: new 148	com/tencent/mm/g/a/zj
    //   410: dup
    //   411: invokespecial 149	com/tencent/mm/g/a/zj:<init>	()V
    //   414: astore_1
    //   415: aload_1
    //   416: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   419: bipush 9
    //   421: putfield 159	com/tencent/mm/g/a/zj$a:dKy	I
    //   424: aload_1
    //   425: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   428: aload_3
    //   429: putfield 163	com/tencent/mm/g/a/zj$a:efs	[B
    //   432: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   435: aload_1
    //   436: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   439: pop
    //   440: sipush 22380
    //   443: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: return
    //   447: aload_3
    //   448: iconst_0
    //   449: baload
    //   450: iconst_2
    //   451: if_icmpne +50 -> 501
    //   454: ldc 28
    //   456: ldc 181
    //   458: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: new 148	com/tencent/mm/g/a/zj
    //   464: dup
    //   465: invokespecial 149	com/tencent/mm/g/a/zj:<init>	()V
    //   468: astore_1
    //   469: aload_1
    //   470: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   473: bipush 10
    //   475: putfield 159	com/tencent/mm/g/a/zj$a:dKy	I
    //   478: aload_1
    //   479: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   482: aload_3
    //   483: putfield 163	com/tencent/mm/g/a/zj$a:efs	[B
    //   486: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   489: aload_1
    //   490: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   493: pop
    //   494: sipush 22380
    //   497: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   500: return
    //   501: aload_3
    //   502: iconst_0
    //   503: baload
    //   504: bipush 102
    //   506: if_icmpne -402 -> 104
    //   509: ldc 28
    //   511: ldc 181
    //   513: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: new 183	com/tencent/mm/g/a/zg
    //   519: dup
    //   520: invokespecial 184	com/tencent/mm/g/a/zg:<init>	()V
    //   523: astore_1
    //   524: aload_1
    //   525: getfield 188	com/tencent/mm/g/a/zg:efr	Lcom/tencent/mm/g/a/zg$a;
    //   528: aload_3
    //   529: putfield 191	com/tencent/mm/g/a/zg$a:efs	[B
    //   532: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   535: aload_1
    //   536: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   539: pop
    //   540: sipush 22380
    //   543: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: return
    //   547: ldc 28
    //   549: ldc 193
    //   551: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: new 148	com/tencent/mm/g/a/zj
    //   557: dup
    //   558: invokespecial 149	com/tencent/mm/g/a/zj:<init>	()V
    //   561: astore_1
    //   562: aload_1
    //   563: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   566: bipush 6
    //   568: putfield 159	com/tencent/mm/g/a/zj$a:dKy	I
    //   571: aload_1
    //   572: getfield 153	com/tencent/mm/g/a/zj:efx	Lcom/tencent/mm/g/a/zj$a;
    //   575: aload_3
    //   576: putfield 163	com/tencent/mm/g/a/zj$a:efs	[B
    //   579: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   582: aload_1
    //   583: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   586: pop
    //   587: sipush 22380
    //   590: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   593: return
    //   594: ldc 28
    //   596: ldc 197
    //   598: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: sipush 22380
    //   604: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: return
    //   608: new 199	com/tencent/mm/g/a/gz
    //   611: dup
    //   612: invokespecial 200	com/tencent/mm/g/a/gz:<init>	()V
    //   615: astore_1
    //   616: aload_1
    //   617: getfield 204	com/tencent/mm/g/a/gz:dLh	Lcom/tencent/mm/g/a/gz$a;
    //   620: aload_3
    //   621: putfield 209	com/tencent/mm/g/a/gz$a:dLi	[B
    //   624: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   627: aload_1
    //   628: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   631: pop
    //   632: sipush 22380
    //   635: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   638: return
    //   639: ldc 82
    //   641: invokestatic 88	com/tencent/mm/booter/NotifyReceiver$NotifyService:CP	(Ljava/lang/String;)V
    //   644: aload_3
    //   645: invokestatic 212	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   648: ifne -544 -> 104
    //   651: new 130	java/lang/String
    //   654: dup
    //   655: aload_3
    //   656: invokespecial 215	java/lang/String:<init>	([B)V
    //   659: astore_1
    //   660: new 217	com/tencent/mm/g/a/ar
    //   663: dup
    //   664: invokespecial 218	com/tencent/mm/g/a/ar:<init>	()V
    //   667: astore_3
    //   668: aload_3
    //   669: getfield 222	com/tencent/mm/g/a/ar:dDD	Lcom/tencent/mm/g/a/ar$a;
    //   672: iconst_4
    //   673: putfield 227	com/tencent/mm/g/a/ar$a:type	I
    //   676: aload_3
    //   677: getfield 222	com/tencent/mm/g/a/ar:dDD	Lcom/tencent/mm/g/a/ar$a;
    //   680: aload_1
    //   681: putfield 230	com/tencent/mm/g/a/ar$a:event	Ljava/lang/String;
    //   684: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   687: aload_3
    //   688: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   691: pop
    //   692: sipush 22380
    //   695: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   698: return
    //   699: ldc 28
    //   701: ldc 232
    //   703: invokestatic 195	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: aload_3
    //   707: arraylength
    //   708: bipush 8
    //   710: if_icmplt +108 -> 818
    //   713: iconst_4
    //   714: newarray byte
    //   716: astore_1
    //   717: iconst_4
    //   718: newarray byte
    //   720: astore 4
    //   722: aload_3
    //   723: iconst_0
    //   724: aload_1
    //   725: iconst_0
    //   726: iconst_4
    //   727: invokestatic 238	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   730: aload_3
    //   731: iconst_4
    //   732: aload 4
    //   734: iconst_0
    //   735: iconst_4
    //   736: invokestatic 238	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   739: new 240	com/tencent/mm/g/a/no
    //   742: dup
    //   743: invokespecial 241	com/tencent/mm/g/a/no:<init>	()V
    //   746: astore_3
    //   747: aload_3
    //   748: getfield 245	com/tencent/mm/g/a/no:dTI	Lcom/tencent/mm/g/a/no$a;
    //   751: aload_1
    //   752: iconst_0
    //   753: invokestatic 250	com/tencent/mm/b/o:v	([BI)I
    //   756: putfield 255	com/tencent/mm/g/a/no$a:dTJ	I
    //   759: aload_3
    //   760: getfield 245	com/tencent/mm/g/a/no:dTI	Lcom/tencent/mm/g/a/no$a;
    //   763: aload 4
    //   765: iconst_0
    //   766: invokestatic 250	com/tencent/mm/b/o:v	([BI)I
    //   769: putfield 258	com/tencent/mm/g/a/no$a:dTK	I
    //   772: ldc 28
    //   774: ldc_w 260
    //   777: iconst_2
    //   778: anewarray 4	java/lang/Object
    //   781: dup
    //   782: iconst_0
    //   783: aload_3
    //   784: getfield 245	com/tencent/mm/g/a/no:dTI	Lcom/tencent/mm/g/a/no$a;
    //   787: getfield 255	com/tencent/mm/g/a/no$a:dTJ	I
    //   790: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   793: aastore
    //   794: dup
    //   795: iconst_1
    //   796: aload_3
    //   797: getfield 245	com/tencent/mm/g/a/no:dTI	Lcom/tencent/mm/g/a/no$a;
    //   800: getfield 258	com/tencent/mm/g/a/no$a:dTK	I
    //   803: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   806: aastore
    //   807: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   810: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   813: aload_3
    //   814: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   817: pop
    //   818: sipush 22380
    //   821: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   824: return
    //   825: aload_3
    //   826: ifnonnull +73 -> 899
    //   829: iconst_m1
    //   830: istore_2
    //   831: ldc 28
    //   833: ldc_w 270
    //   836: iconst_1
    //   837: anewarray 4	java/lang/Object
    //   840: dup
    //   841: iconst_0
    //   842: iload_2
    //   843: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   846: aastore
    //   847: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   850: aload_3
    //   851: ifnull -747 -> 104
    //   854: new 272	com/tencent/mm/protocal/protobuf/sp
    //   857: dup
    //   858: invokespecial 273	com/tencent/mm/protocal/protobuf/sp:<init>	()V
    //   861: astore_1
    //   862: aload_1
    //   863: aload_3
    //   864: invokevirtual 277	com/tencent/mm/protocal/protobuf/sp:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   867: pop
    //   868: new 279	com/tencent/mm/g/a/au
    //   871: dup
    //   872: invokespecial 280	com/tencent/mm/g/a/au:<init>	()V
    //   875: astore_3
    //   876: aload_3
    //   877: getfield 284	com/tencent/mm/g/a/au:dDQ	Lcom/tencent/mm/g/a/au$a;
    //   880: aload_1
    //   881: putfield 290	com/tencent/mm/g/a/au$a:dDR	Lcom/tencent/mm/protocal/protobuf/sp;
    //   884: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   887: aload_3
    //   888: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   891: pop
    //   892: sipush 22380
    //   895: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   898: return
    //   899: aload_3
    //   900: arraylength
    //   901: istore_2
    //   902: goto -71 -> 831
    //   905: astore_1
    //   906: ldc 28
    //   908: new 292	java/lang/StringBuilder
    //   911: dup
    //   912: ldc_w 294
    //   915: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   918: aload_1
    //   919: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   922: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   931: sipush 22380
    //   934: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: return
    //   938: aload_3
    //   939: ifnonnull +262 -> 1201
    //   942: iconst_m1
    //   943: istore_2
    //   944: ldc 28
    //   946: ldc_w 311
    //   949: iconst_1
    //   950: anewarray 4	java/lang/Object
    //   953: dup
    //   954: iconst_0
    //   955: iload_2
    //   956: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   959: aastore
    //   960: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   963: aconst_null
    //   964: astore 8
    //   966: aconst_null
    //   967: astore_1
    //   968: getstatic 317	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
    //   971: ldc2_w 318
    //   974: ldc2_w 320
    //   977: lconst_1
    //   978: iconst_0
    //   979: invokevirtual 325	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   982: aload_3
    //   983: ifnull +163 -> 1146
    //   986: new 327	com/tencent/mm/protocal/protobuf/dte
    //   989: dup
    //   990: invokespecial 328	com/tencent/mm/protocal/protobuf/dte:<init>	()V
    //   993: astore_1
    //   994: aload_1
    //   995: aload_3
    //   996: invokevirtual 329	com/tencent/mm/protocal/protobuf/dte:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   999: pop
    //   1000: ldc 28
    //   1002: ldc_w 331
    //   1005: bipush 6
    //   1007: anewarray 4	java/lang/Object
    //   1010: dup
    //   1011: iconst_0
    //   1012: aload_1
    //   1013: getfield 334	com/tencent/mm/protocal/protobuf/dte:MVl	I
    //   1016: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1019: aastore
    //   1020: dup
    //   1021: iconst_1
    //   1022: aload_1
    //   1023: getfield 337	com/tencent/mm/protocal/protobuf/dte:MVm	I
    //   1026: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: aastore
    //   1030: dup
    //   1031: iconst_2
    //   1032: aload_1
    //   1033: getfield 340	com/tencent/mm/protocal/protobuf/dte:MVn	I
    //   1036: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1039: aastore
    //   1040: dup
    //   1041: iconst_3
    //   1042: aload_1
    //   1043: getfield 343	com/tencent/mm/protocal/protobuf/dte:MVo	I
    //   1046: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1049: aastore
    //   1050: dup
    //   1051: iconst_4
    //   1052: aload_1
    //   1053: getfield 346	com/tencent/mm/protocal/protobuf/dte:MVp	I
    //   1056: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1059: aastore
    //   1060: dup
    //   1061: iconst_5
    //   1062: aload_1
    //   1063: getfield 349	com/tencent/mm/protocal/protobuf/dte:MVq	I
    //   1066: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1069: aastore
    //   1070: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1073: aload_1
    //   1074: getfield 334	com/tencent/mm/protocal/protobuf/dte:MVl	I
    //   1077: bipush 13
    //   1079: if_icmpne +141 -> 1220
    //   1082: invokestatic 355	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   1085: pop
    //   1086: invokestatic 359	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   1089: iconst_3
    //   1090: invokevirtual 365	com/tencent/mm/kernel/b:qe	(I)[B
    //   1093: astore_3
    //   1094: aload_3
    //   1095: aload_1
    //   1096: getfield 369	com/tencent/mm/protocal/protobuf/dte:LrK	Lcom/tencent/mm/bw/b;
    //   1099: getfield 374	com/tencent/mm/bw/b:zy	[B
    //   1102: invokestatic 380	com/tencent/mm/jni/utils/UtilsJni:AesGcmDecryptWithUncompress	([B[B)[B
    //   1105: astore_1
    //   1106: aload_3
    //   1107: ifnonnull +100 -> 1207
    //   1110: iconst_m1
    //   1111: istore_2
    //   1112: aload_1
    //   1113: ifnonnull +100 -> 1213
    //   1116: iconst_m1
    //   1117: istore 7
    //   1119: ldc 28
    //   1121: ldc_w 382
    //   1124: iconst_2
    //   1125: anewarray 4	java/lang/Object
    //   1128: dup
    //   1129: iconst_0
    //   1130: iload_2
    //   1131: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1134: aastore
    //   1135: dup
    //   1136: iconst_1
    //   1137: iload 7
    //   1139: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1142: aastore
    //   1143: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1146: aload_1
    //   1147: ifnull +163 -> 1310
    //   1150: ldc 28
    //   1152: ldc_w 384
    //   1155: iconst_1
    //   1156: anewarray 4	java/lang/Object
    //   1159: dup
    //   1160: iconst_0
    //   1161: aload_1
    //   1162: arraylength
    //   1163: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1166: aastore
    //   1167: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1170: new 386	com/tencent/mm/g/a/ux
    //   1173: dup
    //   1174: invokespecial 387	com/tencent/mm/g/a/ux:<init>	()V
    //   1177: astore_3
    //   1178: aload_3
    //   1179: getfield 391	com/tencent/mm/g/a/ux:ebm	Lcom/tencent/mm/g/a/ux$a;
    //   1182: aload_1
    //   1183: putfield 396	com/tencent/mm/g/a/ux$a:data	[B
    //   1186: getstatic 107	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1189: aload_3
    //   1190: invokevirtual 111	com/tencent/mm/sdk/event/EventCenter:publish	(Lcom/tencent/mm/sdk/event/IEvent;)Z
    //   1193: pop
    //   1194: sipush 22380
    //   1197: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1200: return
    //   1201: aload_3
    //   1202: arraylength
    //   1203: istore_2
    //   1204: goto -260 -> 944
    //   1207: aload_3
    //   1208: arraylength
    //   1209: istore_2
    //   1210: goto -98 -> 1112
    //   1213: aload_1
    //   1214: arraylength
    //   1215: istore 7
    //   1217: goto -98 -> 1119
    //   1220: aload 4
    //   1222: aload_1
    //   1223: getfield 334	com/tencent/mm/protocal/protobuf/dte:MVl	I
    //   1226: aload_1
    //   1227: getfield 337	com/tencent/mm/protocal/protobuf/dte:MVm	I
    //   1230: aload_1
    //   1231: getfield 340	com/tencent/mm/protocal/protobuf/dte:MVn	I
    //   1234: aload_1
    //   1235: getfield 343	com/tencent/mm/protocal/protobuf/dte:MVo	I
    //   1238: aload_1
    //   1239: getfield 346	com/tencent/mm/protocal/protobuf/dte:MVp	I
    //   1242: aload_1
    //   1243: getfield 349	com/tencent/mm/protocal/protobuf/dte:MVq	I
    //   1246: aload_1
    //   1247: getfield 399	com/tencent/mm/protocal/protobuf/dte:MVr	I
    //   1250: aload_1
    //   1251: getfield 369	com/tencent/mm/protocal/protobuf/dte:LrK	Lcom/tencent/mm/bw/b;
    //   1254: getfield 374	com/tencent/mm/bw/b:zy	[B
    //   1257: invokestatic 405	com/tencent/mm/protocal/MMProtocalJni:decodeSecureNotifyData	([BIIIIIII[B)[B
    //   1260: astore_1
    //   1261: goto -115 -> 1146
    //   1264: astore_3
    //   1265: aload 8
    //   1267: astore_1
    //   1268: ldc 28
    //   1270: new 292	java/lang/StringBuilder
    //   1273: dup
    //   1274: ldc_w 407
    //   1277: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1280: aload_3
    //   1281: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1284: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1290: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1293: getstatic 317	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
    //   1296: ldc2_w 318
    //   1299: ldc2_w 408
    //   1302: lconst_1
    //   1303: iconst_0
    //   1304: invokevirtual 325	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   1307: goto -161 -> 1146
    //   1310: ldc 28
    //   1312: ldc_w 411
    //   1315: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1318: getstatic 317	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
    //   1321: ldc2_w 318
    //   1324: ldc2_w 412
    //   1327: lconst_1
    //   1328: iconst_0
    //   1329: invokevirtual 325	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   1332: sipush 22380
    //   1335: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1338: return
    //   1339: new 415	com/tencent/mm/protocal/protobuf/ecb
    //   1342: dup
    //   1343: invokespecial 416	com/tencent/mm/protocal/protobuf/ecb:<init>	()V
    //   1346: astore_1
    //   1347: aload_1
    //   1348: aload_3
    //   1349: invokevirtual 417	com/tencent/mm/protocal/protobuf/ecb:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   1352: pop
    //   1353: new 419	com/tencent/mm/bn/a
    //   1356: dup
    //   1357: aload_1
    //   1358: getfield 422	com/tencent/mm/protocal/protobuf/ecb:Mpw	Lcom/tencent/mm/bw/b;
    //   1361: aload_1
    //   1362: getfield 425	com/tencent/mm/protocal/protobuf/ecb:Ncf	I
    //   1365: aload_1
    //   1366: getfield 428	com/tencent/mm/protocal/protobuf/ecb:Ncg	I
    //   1369: aload_1
    //   1370: getfield 431	com/tencent/mm/protocal/protobuf/ecb:Nch	I
    //   1373: aload_1
    //   1374: getfield 434	com/tencent/mm/protocal/protobuf/ecb:Nci	I
    //   1377: aload_1
    //   1378: getfield 438	com/tencent/mm/protocal/protobuf/ecb:Nck	Lcom/tencent/mm/protocal/protobuf/ebz;
    //   1381: aload_1
    //   1382: getfield 441	com/tencent/mm/protocal/protobuf/ecb:Ncj	Lcom/tencent/mm/protocal/protobuf/ebz;
    //   1385: aload_1
    //   1386: getfield 444	com/tencent/mm/protocal/protobuf/ecb:Ncc	Ljava/lang/String;
    //   1389: invokespecial 447	com/tencent/mm/bn/a:<init>	(Lcom/tencent/mm/bw/b;IIIILcom/tencent/mm/protocal/protobuf/ebz;Lcom/tencent/mm/protocal/protobuf/ebz;Ljava/lang/String;)V
    //   1392: astore_1
    //   1393: invokestatic 359	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   1396: getfield 451	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   1399: aload_1
    //   1400: iconst_0
    //   1401: invokevirtual 454	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   1404: pop
    //   1405: sipush 22380
    //   1408: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1411: return
    //   1412: astore_1
    //   1413: ldc 28
    //   1415: new 292	java/lang/StringBuilder
    //   1418: dup
    //   1419: ldc_w 456
    //   1422: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1425: aload_1
    //   1426: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1429: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1438: sipush 22380
    //   1441: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1444: return
    //   1445: ldc 28
    //   1447: ldc_w 458
    //   1450: invokestatic 36	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1453: invokestatic 359	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   1456: getfield 451	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   1459: new 460	com/tencent/mm/modelsimple/c
    //   1462: dup
    //   1463: invokespecial 461	com/tencent/mm/modelsimple/c:<init>	()V
    //   1466: iconst_0
    //   1467: invokevirtual 454	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   1470: pop
    //   1471: goto -1367 -> 104
    //   1474: astore_3
    //   1475: goto -207 -> 1268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1478	0	this	q
    //   0	1478	1	paramNotifyService	com.tencent.mm.booter.NotifyReceiver.NotifyService
    //   0	1478	2	paramInt	int
    //   0	1478	3	paramArrayOfByte1	byte[]
    //   0	1478	4	paramArrayOfByte2	byte[]
    //   0	1478	5	paramLong	long
    //   1117	99	7	i	int
    //   964	302	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   145	176	183	android/os/RemoteException
    //   862	892	905	java/lang/Exception
    //   994	1106	1264	java/lang/Exception
    //   1220	1261	1264	java/lang/Exception
    //   1347	1353	1412	java/lang/Exception
    //   1119	1146	1474	java/lang/Exception
    //   1207	1210	1474	java/lang/Exception
    //   1213	1217	1474	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.q
 * JD-Core Version:    0.7.0.1
 */