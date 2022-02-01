package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownloadThumbnail
  extends TroopFileTransferManager.Task
{
  public int f = 0;
  
  public TroopFileTransferManager$TaskHttpDownloadThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    super(paramTroopFileTransferManager, paramItem, 4);
    this.f = paramInt;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 35
    //   8: iconst_4
    //   9: ldc 37
    //   11: invokestatic 41	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 43	java/io/File
    //   17: dup
    //   18: getstatic 49	com/tencent/mobileqq/app/AppConstants:aS	Ljava/lang/String;
    //   21: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 55	java/io/File:exists	()Z
    //   31: ifne +9 -> 40
    //   34: aload 5
    //   36: invokevirtual 58	java/io/File:mkdir	()Z
    //   39: pop
    //   40: aload_0
    //   41: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   44: aload_0
    //   45: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   48: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   51: aload_0
    //   52: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   55: invokevirtual 74	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
    //   58: astore 9
    //   60: new 76	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   67: aload 9
    //   69: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 84
    //   74: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 10
    //   82: iconst_0
    //   83: istore_1
    //   84: new 76	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   91: ldc 90
    //   93: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   100: getfield 93	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   103: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 95
    //   108: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   115: getfield 98	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 100
    //   123: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   130: getfield 103	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   133: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 105
    //   138: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   145: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc 110
    //   150: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   157: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 5
    //   165: new 112	java/net/URL
    //   168: dup
    //   169: aload 5
    //   171: invokespecial 113	java/net/URL:<init>	(Ljava/lang/String;)V
    //   174: astore 11
    //   176: iload_1
    //   177: sipush 1000
    //   180: imul
    //   181: i2l
    //   182: lstore_3
    //   183: lload_3
    //   184: invokestatic 119	java/lang/Thread:sleep	(J)V
    //   187: new 43	java/io/File
    //   190: dup
    //   191: aload 10
    //   193: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   196: astore 8
    //   198: aload 8
    //   200: invokevirtual 122	java/io/File:delete	()Z
    //   203: pop
    //   204: iload_1
    //   205: iconst_1
    //   206: iadd
    //   207: istore_1
    //   208: iload_1
    //   209: iconst_3
    //   210: if_icmple +121 -> 331
    //   213: aload_0
    //   214: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   217: sipush 128
    //   220: if_icmpne +92 -> 312
    //   223: aload_0
    //   224: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   227: iconst_0
    //   228: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   231: return
    //   232: astore 5
    //   234: aload_0
    //   235: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   238: sipush 128
    //   241: if_icmpne +12 -> 253
    //   244: aload_0
    //   245: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   248: iconst_0
    //   249: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   252: return
    //   253: aload_0
    //   254: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   257: sipush 640
    //   260: if_icmpne -29 -> 231
    //   263: aload_0
    //   264: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   267: iconst_0
    //   268: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   271: return
    //   272: astore 5
    //   274: aload_0
    //   275: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   278: sipush 128
    //   281: if_icmpne +12 -> 293
    //   284: aload_0
    //   285: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   288: iconst_0
    //   289: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   292: return
    //   293: aload_0
    //   294: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   297: sipush 640
    //   300: if_icmpne -69 -> 231
    //   303: aload_0
    //   304: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   307: iconst_0
    //   308: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   311: return
    //   312: aload_0
    //   313: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   316: sipush 640
    //   319: if_icmpne -88 -> 231
    //   322: aload_0
    //   323: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   326: iconst_0
    //   327: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   330: return
    //   331: aload 8
    //   333: invokevirtual 132	java/io/File:createNewFile	()Z
    //   336: pop
    //   337: aconst_null
    //   338: astore 7
    //   340: aload 11
    //   342: invokevirtual 136	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   345: checkcast 138	java/net/HttpURLConnection
    //   348: astore 5
    //   350: aload 5
    //   352: sipush 30000
    //   355: invokevirtual 142	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   358: aload 5
    //   360: ldc 144
    //   362: invokevirtual 147	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   365: aload 5
    //   367: ldc 149
    //   369: ldc 151
    //   371: invokevirtual 155	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload 5
    //   376: ldc 157
    //   378: ldc 159
    //   380: invokevirtual 155	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 5
    //   385: ldc 161
    //   387: new 76	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   394: ldc 163
    //   396: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_0
    //   400: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   403: getfield 166	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   406: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 155	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: aload 5
    //   417: invokevirtual 170	java/net/HttpURLConnection:getResponseCode	()I
    //   420: sipush 200
    //   423: if_icmpeq +14 -> 437
    //   426: aload 5
    //   428: invokevirtual 170	java/net/HttpURLConnection:getResponseCode	()I
    //   431: sipush 206
    //   434: if_icmpne +497 -> 931
    //   437: aload 5
    //   439: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   442: astore 12
    //   444: new 176	java/io/FileOutputStream
    //   447: dup
    //   448: aload 8
    //   450: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   453: astore 7
    //   455: sipush 4096
    //   458: newarray byte
    //   460: astore 6
    //   462: aload 12
    //   464: aload 6
    //   466: invokevirtual 185	java/io/InputStream:read	([B)I
    //   469: istore_2
    //   470: iload_2
    //   471: iconst_m1
    //   472: if_icmpeq +238 -> 710
    //   475: aload 7
    //   477: aload 6
    //   479: iconst_0
    //   480: iload_2
    //   481: invokevirtual 189	java/io/FileOutputStream:write	([BII)V
    //   484: aload_0
    //   485: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   488: iconst_1
    //   489: iload_2
    //   490: i2l
    //   491: invokevirtual 192	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   494: iconst_0
    //   495: istore_1
    //   496: goto -34 -> 462
    //   499: astore 5
    //   501: aload_0
    //   502: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   505: sipush 128
    //   508: if_icmpne +12 -> 520
    //   511: aload_0
    //   512: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   515: iconst_0
    //   516: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   519: return
    //   520: aload_0
    //   521: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   524: sipush 640
    //   527: if_icmpne -296 -> 231
    //   530: aload_0
    //   531: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   534: iconst_0
    //   535: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   538: return
    //   539: astore 6
    //   541: aload_0
    //   542: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   545: sipush 128
    //   548: if_icmpne +28 -> 576
    //   551: aload_0
    //   552: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   555: iconst_0
    //   556: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   559: aload 5
    //   561: ifnull +8 -> 569
    //   564: aload 5
    //   566: invokevirtual 195	java/net/HttpURLConnection:disconnect	()V
    //   569: aload 8
    //   571: invokevirtual 122	java/io/File:delete	()Z
    //   574: pop
    //   575: return
    //   576: aload_0
    //   577: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   580: sipush 640
    //   583: if_icmpne -24 -> 559
    //   586: aload_0
    //   587: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   590: iconst_0
    //   591: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   594: goto -35 -> 559
    //   597: astore 6
    //   599: aload 5
    //   601: ifnull +8 -> 609
    //   604: aload 5
    //   606: invokevirtual 195	java/net/HttpURLConnection:disconnect	()V
    //   609: aload 8
    //   611: invokevirtual 122	java/io/File:delete	()Z
    //   614: pop
    //   615: goto -439 -> 176
    //   618: astore 6
    //   620: aload_0
    //   621: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   624: sipush 128
    //   627: if_icmpne +38 -> 665
    //   630: aload_0
    //   631: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   634: iconst_0
    //   635: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   638: aload 12
    //   640: invokevirtual 198	java/io/InputStream:close	()V
    //   643: aload 7
    //   645: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   648: aload 5
    //   650: ifnull +8 -> 658
    //   653: aload 5
    //   655: invokevirtual 195	java/net/HttpURLConnection:disconnect	()V
    //   658: aload 8
    //   660: invokevirtual 122	java/io/File:delete	()Z
    //   663: pop
    //   664: return
    //   665: aload_0
    //   666: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   669: sipush 640
    //   672: if_icmpne -34 -> 638
    //   675: aload_0
    //   676: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   679: iconst_0
    //   680: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   683: goto -45 -> 638
    //   686: astore 6
    //   688: aload 12
    //   690: invokevirtual 198	java/io/InputStream:close	()V
    //   693: aload 7
    //   695: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   698: iload_1
    //   699: istore_2
    //   700: aload 6
    //   702: athrow
    //   703: astore 6
    //   705: iload_2
    //   706: istore_1
    //   707: goto -108 -> 599
    //   710: aload 12
    //   712: invokevirtual 198	java/io/InputStream:close	()V
    //   715: aload 7
    //   717: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   720: iload_1
    //   721: istore_2
    //   722: new 43	java/io/File
    //   725: dup
    //   726: aload 10
    //   728: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   731: astore 6
    //   733: iload_1
    //   734: istore_2
    //   735: aload 6
    //   737: new 43	java/io/File
    //   740: dup
    //   741: aload 9
    //   743: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   746: invokevirtual 203	java/io/File:renameTo	(Ljava/io/File;)Z
    //   749: pop
    //   750: iload_1
    //   751: istore_2
    //   752: aload 6
    //   754: invokevirtual 206	java/io/File:deleteOnExit	()V
    //   757: iload_1
    //   758: istore_2
    //   759: aload_0
    //   760: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   763: astore 6
    //   765: iload_1
    //   766: istore_2
    //   767: aload 6
    //   769: monitorenter
    //   770: aload_0
    //   771: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   774: sipush 128
    //   777: if_icmpne +87 -> 864
    //   780: aload_0
    //   781: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   784: iconst_0
    //   785: putfield 126	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
    //   788: aload_0
    //   789: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   792: aload_0
    //   793: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   796: sipush 128
    //   799: invokevirtual 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   802: pop
    //   803: aload_0
    //   804: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   807: lconst_0
    //   808: putfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
    //   811: aload_0
    //   812: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   815: getfield 215	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	Ljava/util/Map;
    //   818: aload_0
    //   819: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   822: getfield 219	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   825: invokeinterface 225 2 0
    //   830: ifeq +14 -> 844
    //   833: aload_0
    //   834: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   837: aload_0
    //   838: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   841: invokevirtual 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   844: aload 6
    //   846: monitorexit
    //   847: aload 5
    //   849: ifnull +8 -> 857
    //   852: aload 5
    //   854: invokevirtual 195	java/net/HttpURLConnection:disconnect	()V
    //   857: aload 8
    //   859: invokevirtual 122	java/io/File:delete	()Z
    //   862: pop
    //   863: return
    //   864: aload_0
    //   865: getfield 16	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:f	I
    //   868: sipush 640
    //   871: if_icmpne -68 -> 803
    //   874: aload_0
    //   875: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   878: iconst_0
    //   879: putfield 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
    //   882: aload_0
    //   883: getfield 12	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   886: aload_0
    //   887: getfield 62	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   890: sipush 640
    //   893: invokevirtual 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
    //   896: pop
    //   897: goto -94 -> 803
    //   900: astore 7
    //   902: aload 6
    //   904: monitorexit
    //   905: iload_1
    //   906: istore_2
    //   907: aload 7
    //   909: athrow
    //   910: astore 6
    //   912: aload 5
    //   914: ifnull +8 -> 922
    //   917: aload 5
    //   919: invokevirtual 195	java/net/HttpURLConnection:disconnect	()V
    //   922: aload 8
    //   924: invokevirtual 122	java/io/File:delete	()Z
    //   927: pop
    //   928: aload 6
    //   930: athrow
    //   931: aload 5
    //   933: ifnull +8 -> 941
    //   936: aload 5
    //   938: invokevirtual 195	java/net/HttpURLConnection:disconnect	()V
    //   941: aload 8
    //   943: invokevirtual 122	java/io/File:delete	()Z
    //   946: pop
    //   947: goto -771 -> 176
    //   950: astore 6
    //   952: goto -309 -> 643
    //   955: astore 6
    //   957: goto -309 -> 648
    //   960: astore 6
    //   962: goto -247 -> 715
    //   965: astore 6
    //   967: goto -247 -> 720
    //   970: astore 12
    //   972: goto -279 -> 693
    //   975: astore 7
    //   977: goto -279 -> 698
    //   980: astore 6
    //   982: aload 7
    //   984: astore 5
    //   986: goto -74 -> 912
    //   989: astore 5
    //   991: aconst_null
    //   992: astore 5
    //   994: goto -395 -> 599
    //   997: astore 6
    //   999: goto -311 -> 688
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1002	0	this	TaskHttpDownloadThumbnail
    //   83	823	1	i	int
    //   469	438	2	j	int
    //   182	2	3	l	long
    //   24	146	5	localObject1	java.lang.Object
    //   232	1	5	localMalformedURLException	java.net.MalformedURLException
    //   272	1	5	localInterruptedException	java.lang.InterruptedException
    //   348	90	5	localHttpURLConnection	java.net.HttpURLConnection
    //   499	438	5	localIOException1	java.io.IOException
    //   984	1	5	localObject2	java.lang.Object
    //   989	1	5	localIOException2	java.io.IOException
    //   992	1	5	localObject3	java.lang.Object
    //   460	18	6	arrayOfByte	byte[]
    //   539	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   597	1	6	localIOException3	java.io.IOException
    //   618	1	6	localIOException4	java.io.IOException
    //   686	15	6	localObject4	java.lang.Object
    //   703	1	6	localIOException5	java.io.IOException
    //   731	172	6	localObject5	java.lang.Object
    //   910	19	6	localObject6	java.lang.Object
    //   950	1	6	localIOException6	java.io.IOException
    //   955	1	6	localIOException7	java.io.IOException
    //   960	1	6	localIOException8	java.io.IOException
    //   965	1	6	localIOException9	java.io.IOException
    //   980	1	6	localObject7	java.lang.Object
    //   997	1	6	localObject8	java.lang.Object
    //   338	378	7	localFileOutputStream	java.io.FileOutputStream
    //   900	8	7	localObject9	java.lang.Object
    //   975	8	7	localIOException10	java.io.IOException
    //   196	746	8	localFile	java.io.File
    //   58	684	9	str1	java.lang.String
    //   80	647	10	str2	java.lang.String
    //   174	167	11	localURL	java.net.URL
    //   442	269	12	localInputStream	java.io.InputStream
    //   970	1	12	localIOException11	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   165	176	232	java/net/MalformedURLException
    //   183	187	272	java/lang/InterruptedException
    //   331	337	499	java/io/IOException
    //   444	455	539	java/io/FileNotFoundException
    //   350	437	597	java/io/IOException
    //   437	444	597	java/io/IOException
    //   444	455	597	java/io/IOException
    //   541	559	597	java/io/IOException
    //   576	594	597	java/io/IOException
    //   475	494	618	java/io/IOException
    //   462	470	686	finally
    //   475	494	686	finally
    //   620	638	686	finally
    //   665	683	686	finally
    //   700	703	703	java/io/IOException
    //   722	733	703	java/io/IOException
    //   735	750	703	java/io/IOException
    //   752	757	703	java/io/IOException
    //   759	765	703	java/io/IOException
    //   767	770	703	java/io/IOException
    //   907	910	703	java/io/IOException
    //   770	803	900	finally
    //   803	844	900	finally
    //   844	847	900	finally
    //   864	897	900	finally
    //   902	905	900	finally
    //   350	437	910	finally
    //   437	444	910	finally
    //   444	455	910	finally
    //   541	559	910	finally
    //   576	594	910	finally
    //   638	643	910	finally
    //   643	648	910	finally
    //   688	693	910	finally
    //   693	698	910	finally
    //   700	703	910	finally
    //   710	715	910	finally
    //   715	720	910	finally
    //   722	733	910	finally
    //   735	750	910	finally
    //   752	757	910	finally
    //   759	765	910	finally
    //   767	770	910	finally
    //   907	910	910	finally
    //   638	643	950	java/io/IOException
    //   643	648	955	java/io/IOException
    //   710	715	960	java/io/IOException
    //   715	720	965	java/io/IOException
    //   688	693	970	java/io/IOException
    //   693	698	975	java/io/IOException
    //   340	350	980	finally
    //   340	350	989	java/io/IOException
    //   455	462	997	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownloadThumbnail
 * JD-Core Version:    0.7.0.1
 */