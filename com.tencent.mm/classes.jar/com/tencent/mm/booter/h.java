package com.tencent.mm.booter;

public final class h
{
  /* Error */
  public static void run()
  {
    // Byte code:
    //   0: sipush 19885
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 18	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9: astore 4
    //   11: new 20	com/tencent/mm/booter/h$1
    //   14: dup
    //   15: invokespecial 23	com/tencent/mm/booter/h$1:<init>	()V
    //   18: astore 5
    //   20: aload 4
    //   22: ifnull +44 -> 66
    //   25: aload 4
    //   27: ldc 25
    //   29: iconst_4
    //   30: invokevirtual 31	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: astore 4
    //   35: aload 4
    //   37: ldc 33
    //   39: ldc 35
    //   41: invokeinterface 41 3 0
    //   46: ldc 43
    //   48: invokevirtual 49	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull +11 -> 66
    //   58: aload 6
    //   60: arraylength
    //   61: istore_0
    //   62: iload_0
    //   63: ifgt +274 -> 337
    //   66: invokestatic 18	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   69: astore 4
    //   71: invokestatic 55	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   74: ldc 57
    //   76: sipush 8192
    //   79: invokevirtual 63	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   82: istore_0
    //   83: aload 4
    //   85: ifnull +7 -> 92
    //   88: iload_0
    //   89: ifgt +1000 -> 1089
    //   92: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   95: pop
    //   96: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   99: getstatic 81	com/tencent/mm/storage/at$a:acHv	Lcom/tencent/mm/storage/at$a;
    //   102: aconst_null
    //   103: invokevirtual 87	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 89	java/lang/Long
    //   109: lconst_0
    //   110: invokestatic 95	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Long;J)J
    //   113: invokestatic 99	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   116: ldc2_w 100
    //   119: lcmp
    //   120: ifle +46 -> 166
    //   123: getstatic 107	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   126: ldc2_w 108
    //   129: invokestatic 55	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   132: ldc 111
    //   134: iconst_0
    //   135: invokevirtual 63	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   138: bipush 16
    //   140: irem
    //   141: i2l
    //   142: lconst_1
    //   143: iconst_0
    //   144: invokevirtual 115	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   147: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   150: pop
    //   151: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   154: getstatic 81	com/tencent/mm/storage/at$a:acHv	Lcom/tencent/mm/storage/at$a;
    //   157: invokestatic 119	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   160: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   163: invokevirtual 127	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   166: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   169: pop
    //   170: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   173: getstatic 130	com/tencent/mm/storage/at$a:acHw	Lcom/tencent/mm/storage/at$a;
    //   176: aconst_null
    //   177: invokevirtual 87	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: checkcast 89	java/lang/Long
    //   183: lconst_0
    //   184: invokestatic 95	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Long;J)J
    //   187: invokestatic 99	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   190: ldc2_w 100
    //   193: lcmp
    //   194: ifle +28 -> 222
    //   197: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   200: pop
    //   201: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   204: getstatic 130	com/tencent/mm/storage/at$a:acHw	Lcom/tencent/mm/storage/at$a;
    //   207: invokestatic 119	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   210: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: invokevirtual 127	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   216: invokestatic 136	com/tencent/mm/modelvideo/v:bOh	()Lcom/tencent/mm/modelvideo/aa;
    //   219: invokevirtual 141	com/tencent/mm/modelvideo/aa:bOF	()V
    //   222: invokestatic 146	com/tencent/mm/modelpackage/l:update	()V
    //   225: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   228: lstore_1
    //   229: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   232: pop
    //   233: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   236: ldc 152
    //   238: getstatic 158	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   241: invokevirtual 162	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   244: checkcast 154	java/lang/Boolean
    //   247: invokevirtual 166	java/lang/Boolean:booleanValue	()Z
    //   250: istore_3
    //   251: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   254: pop
    //   255: invokestatic 170	com/tencent/mm/model/c:bzA	()Lcom/tencent/mm/storage/bx;
    //   258: invokeinterface 176 1 0
    //   263: ifgt +890 -> 1153
    //   266: iload_3
    //   267: ifne +32 -> 299
    //   270: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   273: pop
    //   274: invokestatic 180	com/tencent/mm/model/c:bzG	()Lcom/tencent/mm/storage/by;
    //   277: ldc 182
    //   279: invokeinterface 188 2 0
    //   284: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   287: pop
    //   288: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   291: ldc 152
    //   293: getstatic 191	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   296: invokevirtual 195	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   299: invokestatic 201	com/tencent/mm/plugin/webwx/model/g:iDu	()Lcom/tencent/mm/plugin/webwx/model/g;
    //   302: invokevirtual 205	com/tencent/mm/plugin/webwx/model/g:iDw	()Lcom/tencent/mm/plugin/webwx/model/a;
    //   305: invokevirtual 210	com/tencent/mm/plugin/webwx/model/a:iDt	()V
    //   308: ldc 212
    //   310: ldc 214
    //   312: iconst_1
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   321: lload_1
    //   322: lsub
    //   323: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   326: aastore
    //   327: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: sipush 19885
    //   333: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: return
    //   337: aload 4
    //   339: invokeinterface 226 1 0
    //   344: astore 4
    //   346: aload 4
    //   348: ldc 33
    //   350: ldc 35
    //   352: invokeinterface 232 3 0
    //   357: pop
    //   358: aload 4
    //   360: invokeinterface 235 1 0
    //   365: pop
    //   366: iconst_0
    //   367: istore_0
    //   368: iload_0
    //   369: aload 6
    //   371: arraylength
    //   372: if_icmpge -306 -> 66
    //   375: aload 6
    //   377: iload_0
    //   378: aaload
    //   379: ifnonnull +42 -> 421
    //   382: aconst_null
    //   383: astore 4
    //   385: aload 4
    //   387: ifnull +788 -> 1175
    //   390: aload 4
    //   392: arraylength
    //   393: iconst_2
    //   394: if_icmplt +781 -> 1175
    //   397: aload 4
    //   399: iconst_1
    //   400: aaload
    //   401: ldc 237
    //   403: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifeq +29 -> 435
    //   409: aload 5
    //   411: bipush 10
    //   413: invokeinterface 246 2 0
    //   418: goto +757 -> 1175
    //   421: aload 6
    //   423: iload_0
    //   424: aaload
    //   425: ldc 248
    //   427: invokevirtual 49	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   430: astore 4
    //   432: goto -47 -> 385
    //   435: aload 5
    //   437: bipush 11
    //   439: invokeinterface 246 2 0
    //   444: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   447: aload 4
    //   449: iconst_0
    //   450: aaload
    //   451: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   454: ifeq +12 -> 466
    //   457: aload 5
    //   459: bipush 14
    //   461: invokeinterface 246 2 0
    //   466: new 254	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   473: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   476: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc_w 261
    //   482: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: aload 4
    //   490: iconst_0
    //   491: aaload
    //   492: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   495: ifeq +12 -> 507
    //   498: aload 5
    //   500: bipush 17
    //   502: invokeinterface 246 2 0
    //   507: new 254	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   514: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   517: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 266
    //   523: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: aload 4
    //   531: iconst_0
    //   532: aaload
    //   533: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   536: ifeq +12 -> 548
    //   539: aload 5
    //   541: bipush 20
    //   543: invokeinterface 246 2 0
    //   548: new 254	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   555: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   558: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 268
    //   564: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: aload 4
    //   572: iconst_0
    //   573: aaload
    //   574: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   577: ifeq +12 -> 589
    //   580: aload 5
    //   582: bipush 20
    //   584: invokeinterface 246 2 0
    //   589: aload 4
    //   591: iconst_1
    //   592: aaload
    //   593: ldc_w 270
    //   596: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   599: ifeq +157 -> 756
    //   602: aload 5
    //   604: bipush 12
    //   606: invokeinterface 246 2 0
    //   611: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   614: aload 4
    //   616: iconst_0
    //   617: aaload
    //   618: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   621: ifeq +12 -> 633
    //   624: aload 5
    //   626: bipush 15
    //   628: invokeinterface 246 2 0
    //   633: new 254	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   640: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   643: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc_w 261
    //   649: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: aload 4
    //   657: iconst_0
    //   658: aaload
    //   659: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   662: ifeq +12 -> 674
    //   665: aload 5
    //   667: bipush 18
    //   669: invokeinterface 246 2 0
    //   674: new 254	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   681: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   684: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: ldc_w 266
    //   690: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: aload 4
    //   698: iconst_0
    //   699: aaload
    //   700: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: ifeq +12 -> 715
    //   706: aload 5
    //   708: bipush 21
    //   710: invokeinterface 246 2 0
    //   715: new 254	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   722: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   725: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: ldc_w 268
    //   731: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: aload 4
    //   739: iconst_0
    //   740: aaload
    //   741: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   744: ifeq +12 -> 756
    //   747: aload 5
    //   749: bipush 21
    //   751: invokeinterface 246 2 0
    //   756: aload 4
    //   758: iconst_1
    //   759: aaload
    //   760: ldc_w 272
    //   763: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   766: ifeq +157 -> 923
    //   769: aload 5
    //   771: bipush 13
    //   773: invokeinterface 246 2 0
    //   778: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   781: aload 4
    //   783: iconst_0
    //   784: aaload
    //   785: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   788: ifeq +12 -> 800
    //   791: aload 5
    //   793: bipush 16
    //   795: invokeinterface 246 2 0
    //   800: new 254	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   807: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   810: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: ldc_w 261
    //   816: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: aload 4
    //   824: iconst_0
    //   825: aaload
    //   826: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   829: ifeq +12 -> 841
    //   832: aload 5
    //   834: bipush 19
    //   836: invokeinterface 246 2 0
    //   841: new 254	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   848: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   851: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: ldc_w 266
    //   857: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: aload 4
    //   865: iconst_0
    //   866: aaload
    //   867: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   870: ifeq +12 -> 882
    //   873: aload 5
    //   875: bipush 22
    //   877: invokeinterface 246 2 0
    //   882: new 254	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   889: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   892: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc_w 268
    //   898: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: aload 4
    //   906: iconst_0
    //   907: aaload
    //   908: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   911: ifeq +12 -> 923
    //   914: aload 5
    //   916: bipush 22
    //   918: invokeinterface 246 2 0
    //   923: aload 4
    //   925: iconst_1
    //   926: aaload
    //   927: ldc_w 274
    //   930: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   933: ifeq +242 -> 1175
    //   936: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   939: aload 4
    //   941: iconst_0
    //   942: aaload
    //   943: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   946: ifeq +12 -> 958
    //   949: aload 5
    //   951: bipush 23
    //   953: invokeinterface 246 2 0
    //   958: new 254	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   965: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   968: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: ldc_w 261
    //   974: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: aload 4
    //   982: iconst_0
    //   983: aaload
    //   984: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   987: ifeq +12 -> 999
    //   990: aload 5
    //   992: bipush 24
    //   994: invokeinterface 246 2 0
    //   999: new 254	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1006: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   1009: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: ldc_w 266
    //   1015: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1021: aload 4
    //   1023: iconst_0
    //   1024: aaload
    //   1025: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1028: ifeq +12 -> 1040
    //   1031: aload 5
    //   1033: bipush 25
    //   1035: invokeinterface 246 2 0
    //   1040: new 254	java/lang/StringBuilder
    //   1043: dup
    //   1044: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   1047: invokestatic 252	com/tencent/mm/sdk/platformtools/MMApplicationContext:getApplicationId	()Ljava/lang/String;
    //   1050: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: ldc_w 268
    //   1056: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: aload 4
    //   1064: iconst_0
    //   1065: aaload
    //   1066: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1069: ifeq +106 -> 1175
    //   1072: aload 5
    //   1074: bipush 25
    //   1076: invokeinterface 246 2 0
    //   1081: goto +94 -> 1175
    //   1084: astore 4
    //   1086: goto -1020 -> 66
    //   1089: aload 4
    //   1091: ldc 25
    //   1093: iconst_4
    //   1094: invokevirtual 31	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1097: astore 4
    //   1099: aload 4
    //   1101: ldc_w 276
    //   1104: sipush 8192
    //   1107: invokeinterface 277 3 0
    //   1112: iload_0
    //   1113: if_icmpeq -1021 -> 92
    //   1116: aload 4
    //   1118: invokeinterface 226 1 0
    //   1123: astore 4
    //   1125: aload 4
    //   1127: ldc_w 276
    //   1130: iload_0
    //   1131: invokeinterface 281 3 0
    //   1136: pop
    //   1137: aload 4
    //   1139: invokeinterface 235 1 0
    //   1144: pop
    //   1145: goto -1053 -> 92
    //   1148: astore 4
    //   1150: goto -1058 -> 92
    //   1153: iload_3
    //   1154: ifeq -855 -> 299
    //   1157: invokestatic 69	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   1160: pop
    //   1161: invokestatic 75	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   1164: ldc 152
    //   1166: getstatic 158	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1169: invokevirtual 195	com/tencent/mm/storage/aq:B	(ILjava/lang/Object;)V
    //   1172: goto -873 -> 299
    //   1175: iload_0
    //   1176: iconst_1
    //   1177: iadd
    //   1178: istore_0
    //   1179: goto -811 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   61	1118	0	i	int
    //   228	94	1	l	long
    //   250	904	3	bool	boolean
    //   9	1054	4	localObject1	Object
    //   1084	6	4	localObject2	Object
    //   1097	41	4	localObject3	Object
    //   1148	1	4	localObject4	Object
    //   18	1055	5	local1	h.1
    //   51	371	6	arrayOfString	java.lang.String[]
    // Exception table:
    //   from	to	target	type
    //   25	53	1084	finally
    //   58	62	1084	finally
    //   337	366	1084	finally
    //   368	375	1084	finally
    //   390	418	1084	finally
    //   421	432	1084	finally
    //   435	466	1084	finally
    //   466	507	1084	finally
    //   507	548	1084	finally
    //   548	589	1084	finally
    //   589	633	1084	finally
    //   633	674	1084	finally
    //   674	715	1084	finally
    //   715	756	1084	finally
    //   756	800	1084	finally
    //   800	841	1084	finally
    //   841	882	1084	finally
    //   882	923	1084	finally
    //   923	958	1084	finally
    //   958	999	1084	finally
    //   999	1040	1084	finally
    //   1040	1081	1084	finally
    //   1089	1145	1148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.h
 * JD-Core Version:    0.7.0.1
 */