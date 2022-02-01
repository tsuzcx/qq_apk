package com.tencent.mobileqq.troop.utils;

public class TroopFileTransferManager$TaskHttpDownload
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskHttpDownload(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 3);
    this.jdField_b_of_type_Boolean = true;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, long paramLong1, long paramLong2, java.lang.String paramString4, java.lang.String paramString5, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 25	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   7: lload 4
    //   9: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12: ldc 34
    //   14: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: lload 6
    //   19: lconst_1
    //   20: lsub
    //   21: invokevirtual 32	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 11
    //   29: lload 4
    //   31: lconst_0
    //   32: lcmp
    //   33: ifne +92 -> 125
    //   36: new 25	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   43: ldc 43
    //   45: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 45
    //   54: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 47
    //   63: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokestatic 52	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   70: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 9
    //   75: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   86: aload_1
    //   87: putfield 61	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   94: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   97: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
    //   100: new 73	java/net/URL
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 76	java/net/URL:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 80	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   113: checkcast 82	java/net/HttpURLConnection
    //   116: astore_2
    //   117: aload_2
    //   118: ifnonnull +89 -> 207
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: areturn
    //   125: new 25	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   132: ldc 43
    //   134: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 45
    //   143: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_2
    //   147: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 47
    //   152: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_3
    //   156: invokestatic 52	com/tencent/mobileqq/utils/HexUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 84
    //   164: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 11
    //   169: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 9
    //   174: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: goto -99 -> 82
    //   184: astore_1
    //   185: iload 10
    //   187: ifeq +18 -> 205
    //   190: aload_0
    //   191: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   194: aload_0
    //   195: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   198: bipush 10
    //   200: bipush 102
    //   202: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   205: aconst_null
    //   206: areturn
    //   207: aload_2
    //   208: sipush 30000
    //   211: invokevirtual 93	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   214: aload_2
    //   215: sipush 30000
    //   218: invokevirtual 96	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   221: aload_2
    //   222: ldc 98
    //   224: invokevirtual 101	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   227: aload_2
    //   228: ldc 103
    //   230: ldc 105
    //   232: invokevirtual 109	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: lload 6
    //   237: lconst_0
    //   238: lcmp
    //   239: ifeq +29 -> 268
    //   242: aload_2
    //   243: ldc 111
    //   245: new 25	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   252: ldc 113
    //   254: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 11
    //   259: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokevirtual 109	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload_2
    //   269: ldc 115
    //   271: ldc 117
    //   273: invokevirtual 109	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_2
    //   277: ldc 119
    //   279: new 25	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   286: ldc 121
    //   288: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 8
    //   293: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokevirtual 109	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload_2
    //   305: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   308: sipush 200
    //   311: if_icmpeq -188 -> 123
    //   314: aload_2
    //   315: astore_1
    //   316: aload_2
    //   317: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   320: sipush 206
    //   323: if_icmpeq -200 -> 123
    //   326: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +31 -> 360
    //   332: ldc 133
    //   334: iconst_2
    //   335: new 25	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   342: ldc 135
    //   344: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_2
    //   348: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   351: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aconst_null
    //   361: areturn
    //   362: astore_1
    //   363: aload_1
    //   364: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   367: aconst_null
    //   368: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	TaskHttpDownload
    //   0	369	1	paramString1	java.lang.String
    //   0	369	2	paramString2	java.lang.String
    //   0	369	3	paramString3	java.lang.String
    //   0	369	4	paramLong1	long
    //   0	369	6	paramLong2	long
    //   0	369	8	paramString4	java.lang.String
    //   0	369	9	paramString5	java.lang.String
    //   0	369	10	paramBoolean	boolean
    //   27	231	11	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   100	109	184	java/net/MalformedURLException
    //   109	117	362	java/io/IOException
    //   207	235	362	java/io/IOException
    //   242	268	362	java/io/IOException
    //   268	302	362	java/io/IOException
    //   304	314	362	java/io/IOException
    //   316	360	362	java/io/IOException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: invokestatic 156	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 133
    //   23: iconst_4
    //   24: ldc 158
    //   26: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: invokestatic 165	com/tencent/open/appcommon/Common:a	()Z
    //   32: ifne +20 -> 52
    //   35: aload_0
    //   36: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   39: aload_0
    //   40: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   43: bipush 10
    //   45: sipush 308
    //   48: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   51: return
    //   52: new 167	java/io/File
    //   55: dup
    //   56: getstatic 172	com/tencent/mobileqq/app/AppConstants:aS	Ljava/lang/String;
    //   59: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 176	java/io/File:exists	()Z
    //   69: ifne +9 -> 78
    //   72: aload 5
    //   74: invokevirtual 179	java/io/File:mkdir	()Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   82: new 25	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   89: getstatic 172	com/tencent/mobileqq/app/AppConstants:aS	Ljava/lang/String;
    //   92: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   99: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   102: invokevirtual 188	java/lang/String:getBytes	()[B
    //   105: invokestatic 191	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   108: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 193
    //   113: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: putfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   122: new 167	java/io/File
    //   125: dup
    //   126: aload_0
    //   127: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   130: getfield 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
    //   133: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 8
    //   138: aload 8
    //   140: invokevirtual 176	java/io/File:exists	()Z
    //   143: ifne +9 -> 152
    //   146: aload 8
    //   148: invokevirtual 199	java/io/File:createNewFile	()Z
    //   151: pop
    //   152: aload_0
    //   153: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   156: aload 8
    //   158: invokevirtual 202	java/io/File:length	()J
    //   161: putfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   164: iconst_0
    //   165: istore_1
    //   166: aload_0
    //   167: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   170: iconst_0
    //   171: putfield 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   174: iload_1
    //   175: istore_2
    //   176: aload_0
    //   177: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   180: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   183: aload_0
    //   184: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   187: getfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   190: lcmp
    //   191: ifgt +17 -> 208
    //   194: aload_0
    //   195: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   198: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   201: lconst_0
    //   202: lcmp
    //   203: ifne +1012 -> 1215
    //   206: iload_1
    //   207: istore_2
    //   208: iload_2
    //   209: iconst_3
    //   210: if_icmplt +75 -> 285
    //   213: aload_0
    //   214: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   217: aload_0
    //   218: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   221: bipush 10
    //   223: bipush 105
    //   225: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   228: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq -217 -> 14
    //   234: ldc 133
    //   236: iconst_2
    //   237: new 25	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   244: ldc 214
    //   246: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   253: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   256: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: return
    //   266: astore 5
    //   268: aload_0
    //   269: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   272: aload_0
    //   273: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   276: bipush 10
    //   278: sipush 303
    //   281: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   284: return
    //   285: iload_2
    //   286: ifle +100 -> 386
    //   289: invokestatic 223	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   292: invokestatic 229	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   295: ifne +19 -> 314
    //   298: aload_0
    //   299: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   302: aload_0
    //   303: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   306: bipush 10
    //   308: bipush 106
    //   310: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   313: return
    //   314: iconst_0
    //   315: istore_1
    //   316: iload_1
    //   317: iload_2
    //   318: bipush 100
    //   320: imul
    //   321: if_icmpge +65 -> 386
    //   324: ldc2_w 230
    //   327: invokestatic 237	java/lang/Thread:sleep	(J)V
    //   330: aload_0
    //   331: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   334: aload_0
    //   335: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   338: invokevirtual 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   341: ifne -327 -> 14
    //   344: invokestatic 223	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   347: invokestatic 229	com/tencent/mobileqq/utils/NetworkUtil:f	(Landroid/content/Context;)Z
    //   350: ifne +29 -> 379
    //   353: aload_0
    //   354: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   357: aload_0
    //   358: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   361: bipush 10
    //   363: bipush 106
    //   365: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   368: return
    //   369: astore 5
    //   371: aload 5
    //   373: invokevirtual 238	java/lang/InterruptedException:printStackTrace	()V
    //   376: goto -46 -> 330
    //   379: iload_1
    //   380: iconst_1
    //   381: iadd
    //   382: istore_1
    //   383: goto -67 -> 316
    //   386: aload_0
    //   387: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   390: aload_0
    //   391: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   394: invokevirtual 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   397: ifne -383 -> 14
    //   400: iload_2
    //   401: iconst_1
    //   402: iadd
    //   403: istore_1
    //   404: aload_0
    //   405: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   408: iload_1
    //   409: putfield 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   412: aconst_null
    //   413: astore 7
    //   415: aconst_null
    //   416: astore 6
    //   418: aload 7
    //   420: astore 5
    //   422: aload_0
    //   423: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   426: invokevirtual 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   429: ifnull +235 -> 664
    //   432: aload_0
    //   433: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   436: invokevirtual 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
    //   439: iconst_5
    //   440: invokeinterface 247 2 0
    //   445: astore 9
    //   447: aload 7
    //   449: astore 5
    //   451: aload 9
    //   453: ifnull +211 -> 664
    //   456: aload 7
    //   458: astore 5
    //   460: aload 9
    //   462: invokeinterface 252 1 0
    //   467: ifne +197 -> 664
    //   470: aload 9
    //   472: invokeinterface 256 1 0
    //   477: astore 7
    //   479: aload 6
    //   481: astore 5
    //   483: aload 7
    //   485: invokeinterface 261 1 0
    //   490: ifeq +174 -> 664
    //   493: aload 7
    //   495: invokeinterface 265 1 0
    //   500: checkcast 267	mqq/manager/ProxyIpManager$ProxyIp
    //   503: astore 5
    //   505: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +38 -> 546
    //   511: ldc 133
    //   513: iconst_2
    //   514: ldc_w 269
    //   517: iconst_2
    //   518: anewarray 271	java/lang/Object
    //   521: dup
    //   522: iconst_0
    //   523: aload 5
    //   525: getfield 274	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   528: aastore
    //   529: dup
    //   530: iconst_1
    //   531: aload 5
    //   533: getfield 277	mqq/manager/ProxyIpManager$ProxyIp:port	I
    //   536: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aastore
    //   540: invokestatic 287	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   543: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: ldc_w 289
    //   549: iconst_2
    //   550: anewarray 271	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: aload_0
    //   556: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   559: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   562: aastore
    //   563: dup
    //   564: iconst_1
    //   565: bipush 80
    //   567: invokestatic 283	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: aastore
    //   571: invokestatic 287	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   574: astore 6
    //   576: aload_0
    //   577: aload 5
    //   579: getfield 274	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
    //   582: aload_0
    //   583: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   586: getfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   589: aload_0
    //   590: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   593: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   596: aload_0
    //   597: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   600: getfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   603: aload_0
    //   604: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   607: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   610: aload_0
    //   611: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   614: getfield 295	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   617: aload 6
    //   619: iconst_0
    //   620: invokespecial 297	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   623: astore 6
    //   625: aload 6
    //   627: astore 5
    //   629: aload 6
    //   631: ifnull -148 -> 483
    //   634: aload 6
    //   636: astore 5
    //   638: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq +23 -> 664
    //   644: ldc 133
    //   646: iconst_2
    //   647: ldc_w 299
    //   650: iconst_0
    //   651: anewarray 271	java/lang/Object
    //   654: invokestatic 287	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   657: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: aload 6
    //   662: astore 5
    //   664: aload 5
    //   666: astore 6
    //   668: aload 5
    //   670: ifnonnull +165 -> 835
    //   673: aload_0
    //   674: aload_0
    //   675: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   678: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   681: aload_0
    //   682: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   685: getfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   688: aload_0
    //   689: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   692: getfield 182	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   695: aload_0
    //   696: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   699: getfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   702: aload_0
    //   703: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   706: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   709: aload_0
    //   710: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   713: getfield 295	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
    //   716: ldc_w 301
    //   719: iconst_1
    //   720: invokespecial 297	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   723: astore 5
    //   725: aload 5
    //   727: ifnonnull +78 -> 805
    //   730: iload_1
    //   731: istore_2
    //   732: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq -527 -> 208
    //   738: new 25	java/lang/StringBuilder
    //   741: dup
    //   742: ldc_w 303
    //   745: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   748: astore 5
    //   750: aload 5
    //   752: iload_1
    //   753: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: ldc_w 306
    //   759: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   766: getfield 217	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
    //   769: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: ldc_w 308
    //   775: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_0
    //   779: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   782: getfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
    //   785: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: ldc 133
    //   791: iconst_2
    //   792: aload 5
    //   794: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: iload_1
    //   801: istore_2
    //   802: goto -594 -> 208
    //   805: aload 5
    //   807: astore 6
    //   809: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +23 -> 835
    //   815: ldc 133
    //   817: iconst_2
    //   818: ldc_w 310
    //   821: iconst_0
    //   822: anewarray 271	java/lang/Object
    //   825: invokestatic 287	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   828: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: aload 5
    //   833: astore 6
    //   835: aload 6
    //   837: invokevirtual 314	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   840: astore 7
    //   842: aload_0
    //   843: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   846: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   849: lconst_0
    //   850: lcmp
    //   851: ifne +16 -> 867
    //   854: aload_0
    //   855: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   858: aload 6
    //   860: invokevirtual 317	java/net/HttpURLConnection:getContentLength	()I
    //   863: i2l
    //   864: putfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   867: new 319	java/io/FileOutputStream
    //   870: dup
    //   871: aload 8
    //   873: iconst_1
    //   874: invokespecial 322	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   877: astore 6
    //   879: sipush 4096
    //   882: newarray byte
    //   884: astore 5
    //   886: iload_1
    //   887: istore_2
    //   888: iload_2
    //   889: istore_1
    //   890: aload 7
    //   892: aload 5
    //   894: invokevirtual 328	java/io/InputStream:read	([B)I
    //   897: istore_3
    //   898: iload_3
    //   899: iconst_m1
    //   900: if_icmpeq +305 -> 1205
    //   903: iload_2
    //   904: istore_1
    //   905: aload_0
    //   906: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   909: getfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   912: iload_3
    //   913: i2l
    //   914: ladd
    //   915: aload_0
    //   916: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   919: getfield 212	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   922: lcmp
    //   923: ifle +95 -> 1018
    //   926: iload_2
    //   927: istore_1
    //   928: aload_0
    //   929: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   932: aload_0
    //   933: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   936: bipush 10
    //   938: sipush 305
    //   941: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   944: aload 7
    //   946: invokevirtual 331	java/io/InputStream:close	()V
    //   949: aload 6
    //   951: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   954: return
    //   955: astore 5
    //   957: return
    //   958: astore 5
    //   960: aload_0
    //   961: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   964: aload_0
    //   965: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   968: bipush 10
    //   970: sipush 304
    //   973: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   976: return
    //   977: astore 5
    //   979: iload_1
    //   980: istore_2
    //   981: invokestatic 156	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   984: ifeq -776 -> 208
    //   987: ldc 133
    //   989: iconst_4
    //   990: new 25	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   997: ldc_w 334
    //   1000: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: iload_1
    //   1004: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1013: iload_1
    //   1014: istore_2
    //   1015: goto -807 -> 208
    //   1018: iload_2
    //   1019: istore_1
    //   1020: aload 6
    //   1022: aload 5
    //   1024: iconst_0
    //   1025: iload_3
    //   1026: invokevirtual 338	java/io/FileOutputStream:write	([BII)V
    //   1029: iload_2
    //   1030: istore_1
    //   1031: aload_0
    //   1032: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1035: astore 9
    //   1037: iload_2
    //   1038: istore_1
    //   1039: aload 9
    //   1041: aload 9
    //   1043: getfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1046: iload_3
    //   1047: i2l
    //   1048: ladd
    //   1049: putfield 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   1052: iload_2
    //   1053: istore_1
    //   1054: aload_0
    //   1055: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1058: astore 9
    //   1060: iload_2
    //   1061: istore_1
    //   1062: aload 9
    //   1064: aload 9
    //   1066: getfield 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1069: iload_3
    //   1070: i2l
    //   1071: ladd
    //   1072: putfield 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
    //   1075: iload_2
    //   1076: istore_1
    //   1077: aload_0
    //   1078: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1081: iconst_1
    //   1082: iload_3
    //   1083: i2l
    //   1084: invokevirtual 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(IJ)V
    //   1087: iload_2
    //   1088: istore_1
    //   1089: aload_0
    //   1090: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1093: aload_0
    //   1094: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1097: invokevirtual 153	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   1100: istore 4
    //   1102: iload 4
    //   1104: ifeq +51 -> 1155
    //   1107: aload 7
    //   1109: invokevirtual 331	java/io/InputStream:close	()V
    //   1112: aload 6
    //   1114: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   1117: return
    //   1118: astore 5
    //   1120: return
    //   1121: astore 5
    //   1123: iload_2
    //   1124: istore_1
    //   1125: aload_0
    //   1126: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1129: aload_0
    //   1130: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1133: bipush 10
    //   1135: sipush 306
    //   1138: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1141: aload 7
    //   1143: invokevirtual 331	java/io/InputStream:close	()V
    //   1146: aload 6
    //   1148: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   1151: return
    //   1152: astore 5
    //   1154: return
    //   1155: iconst_0
    //   1156: istore_3
    //   1157: iconst_0
    //   1158: istore_2
    //   1159: iload_3
    //   1160: istore_1
    //   1161: aload_0
    //   1162: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1165: iconst_0
    //   1166: putfield 209	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
    //   1169: iload_3
    //   1170: istore_1
    //   1171: aload_0
    //   1172: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1175: aload_0
    //   1176: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1179: invokevirtual 347	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   1182: goto -294 -> 888
    //   1185: astore 5
    //   1187: aload 7
    //   1189: invokevirtual 331	java/io/InputStream:close	()V
    //   1192: aload 6
    //   1194: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   1197: aload 5
    //   1199: athrow
    //   1200: astore 5
    //   1202: goto -223 -> 979
    //   1205: aload 7
    //   1207: invokevirtual 331	java/io/InputStream:close	()V
    //   1210: aload 6
    //   1212: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   1215: aload_0
    //   1216: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1219: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1222: invokevirtual 352	java/lang/String:length	()I
    //   1225: bipush 85
    //   1227: if_icmple +62 -> 1289
    //   1230: aload_0
    //   1231: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1234: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1237: bipush 46
    //   1239: invokevirtual 356	java/lang/String:lastIndexOf	(I)I
    //   1242: istore_2
    //   1243: iload_2
    //   1244: istore_1
    //   1245: iload_2
    //   1246: ifge +5 -> 1251
    //   1249: iconst_0
    //   1250: istore_1
    //   1251: aload_0
    //   1252: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1255: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1258: invokevirtual 352	java/lang/String:length	()I
    //   1261: bipush 85
    //   1263: isub
    //   1264: istore_2
    //   1265: iload_1
    //   1266: ifne +229 -> 1495
    //   1269: aload_0
    //   1270: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1273: aload_0
    //   1274: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1277: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1280: iconst_0
    //   1281: bipush 85
    //   1283: invokevirtual 360	java/lang/String:substring	(II)Ljava/lang/String;
    //   1286: putfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1289: aload_0
    //   1290: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1293: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1296: astore 6
    //   1298: aload 6
    //   1300: astore 5
    //   1302: aload_0
    //   1303: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1306: getfield 363	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1309: invokestatic 368	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1312: ifne +27 -> 1339
    //   1315: aload 6
    //   1317: astore 5
    //   1319: aload_0
    //   1320: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1323: getfield 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
    //   1326: iconst_2
    //   1327: if_icmpne +12 -> 1339
    //   1330: aload_0
    //   1331: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1334: getfield 363	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
    //   1337: astore 5
    //   1339: iconst_0
    //   1340: istore_1
    //   1341: iload_1
    //   1342: sipush 1000
    //   1345: if_icmpge +243 -> 1588
    //   1348: iload_1
    //   1349: ifle +206 -> 1555
    //   1352: aload 5
    //   1354: bipush 46
    //   1356: invokevirtual 356	java/lang/String:lastIndexOf	(I)I
    //   1359: istore_3
    //   1360: iload_3
    //   1361: istore_2
    //   1362: iload_3
    //   1363: ifge +5 -> 1368
    //   1366: iconst_0
    //   1367: istore_2
    //   1368: new 25	java/lang/StringBuilder
    //   1371: dup
    //   1372: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1375: getstatic 374	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   1378: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: aload 5
    //   1383: iconst_0
    //   1384: iload_2
    //   1385: invokevirtual 360	java/lang/String:substring	(II)Ljava/lang/String;
    //   1388: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: ldc_w 376
    //   1394: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: iload_1
    //   1398: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1401: ldc_w 378
    //   1404: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: aload 5
    //   1409: iload_2
    //   1410: invokevirtual 381	java/lang/String:substring	(I)Ljava/lang/String;
    //   1413: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1419: astore 6
    //   1421: new 167	java/io/File
    //   1424: dup
    //   1425: aload 6
    //   1427: invokespecial 173	java/io/File:<init>	(Ljava/lang/String;)V
    //   1430: astore 7
    //   1432: aload 7
    //   1434: invokevirtual 176	java/io/File:exists	()Z
    //   1437: ifne +144 -> 1581
    //   1440: aload 8
    //   1442: aload 7
    //   1444: invokevirtual 385	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1447: ifeq +134 -> 1581
    //   1450: aload_0
    //   1451: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1454: aload 6
    //   1456: putfield 388	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   1459: aload_0
    //   1460: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1463: aload_0
    //   1464: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1467: bipush 11
    //   1469: invokevirtual 391	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   1472: aload_0
    //   1473: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1476: aload_0
    //   1477: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1480: aload_0
    //   1481: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1484: getfield 394	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   1487: invokevirtual 398	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1490: iconst_0
    //   1491: invokevirtual 401	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Z)V
    //   1494: return
    //   1495: iload_1
    //   1496: iload_2
    //   1497: if_icmple -208 -> 1289
    //   1500: new 25	java/lang/StringBuilder
    //   1503: dup
    //   1504: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1507: aload_0
    //   1508: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1511: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1514: iconst_0
    //   1515: iload_1
    //   1516: iload_2
    //   1517: isub
    //   1518: invokevirtual 360	java/lang/String:substring	(II)Ljava/lang/String;
    //   1521: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload_0
    //   1525: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1528: getfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1531: iload_1
    //   1532: invokevirtual 381	java/lang/String:substring	(I)Ljava/lang/String;
    //   1535: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1541: astore 5
    //   1543: aload_0
    //   1544: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1547: aload 5
    //   1549: putfield 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   1552: goto -263 -> 1289
    //   1555: new 25	java/lang/StringBuilder
    //   1558: dup
    //   1559: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   1562: getstatic 374	com/tencent/mobileqq/app/AppConstants:aP	Ljava/lang/String;
    //   1565: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload 5
    //   1570: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1576: astore 6
    //   1578: goto -157 -> 1421
    //   1581: iload_1
    //   1582: iconst_1
    //   1583: iadd
    //   1584: istore_1
    //   1585: goto -244 -> 1341
    //   1588: aload_0
    //   1589: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1592: aload_0
    //   1593: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   1596: bipush 10
    //   1598: sipush 307
    //   1601: invokevirtual 89	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   1604: return
    //   1605: astore 5
    //   1607: goto -658 -> 949
    //   1610: astore 5
    //   1612: goto -466 -> 1146
    //   1615: astore 5
    //   1617: goto -505 -> 1112
    //   1620: astore 5
    //   1622: goto -412 -> 1210
    //   1625: astore 5
    //   1627: goto -412 -> 1215
    //   1630: astore 7
    //   1632: goto -440 -> 1192
    //   1635: astore 6
    //   1637: goto -440 -> 1197
    //   1640: astore 5
    //   1642: goto -455 -> 1187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1645	0	this	TaskHttpDownload
    //   165	1420	1	i	int
    //   175	1343	2	j	int
    //   897	466	3	k	int
    //   1100	3	4	bool	boolean
    //   62	11	5	localFile1	java.io.File
    //   266	1	5	localIOException1	java.io.IOException
    //   369	3	5	localInterruptedException	java.lang.InterruptedException
    //   420	473	5	localObject1	java.lang.Object
    //   955	1	5	localIOException2	java.io.IOException
    //   958	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   977	46	5	localIOException3	java.io.IOException
    //   1118	1	5	localIOException4	java.io.IOException
    //   1121	1	5	localIOException5	java.io.IOException
    //   1152	1	5	localIOException6	java.io.IOException
    //   1185	13	5	localObject2	java.lang.Object
    //   1200	1	5	localIOException7	java.io.IOException
    //   1300	269	5	localObject3	java.lang.Object
    //   1605	1	5	localIOException8	java.io.IOException
    //   1610	1	5	localIOException9	java.io.IOException
    //   1615	1	5	localIOException10	java.io.IOException
    //   1620	1	5	localIOException11	java.io.IOException
    //   1625	1	5	localIOException12	java.io.IOException
    //   1640	1	5	localObject4	java.lang.Object
    //   416	1161	6	localObject5	java.lang.Object
    //   1635	1	6	localIOException13	java.io.IOException
    //   413	1030	7	localObject6	java.lang.Object
    //   1630	1	7	localIOException14	java.io.IOException
    //   136	1305	8	localFile2	java.io.File
    //   445	620	9	localObject7	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   146	152	266	java/io/IOException
    //   324	330	369	java/lang/InterruptedException
    //   949	954	955	java/io/IOException
    //   867	879	958	java/io/FileNotFoundException
    //   835	867	977	java/io/IOException
    //   867	879	977	java/io/IOException
    //   960	976	977	java/io/IOException
    //   1112	1117	1118	java/io/IOException
    //   1020	1029	1121	java/io/IOException
    //   1146	1151	1152	java/io/IOException
    //   890	898	1185	finally
    //   905	926	1185	finally
    //   928	944	1185	finally
    //   1020	1029	1185	finally
    //   1031	1037	1185	finally
    //   1039	1052	1185	finally
    //   1054	1060	1185	finally
    //   1062	1075	1185	finally
    //   1077	1087	1185	finally
    //   1089	1102	1185	finally
    //   1125	1141	1185	finally
    //   1161	1169	1185	finally
    //   1171	1182	1185	finally
    //   1197	1200	1200	java/io/IOException
    //   944	949	1605	java/io/IOException
    //   1141	1146	1610	java/io/IOException
    //   1107	1112	1615	java/io/IOException
    //   1205	1210	1620	java/io/IOException
    //   1210	1215	1625	java/io/IOException
    //   1187	1192	1630	java/io/IOException
    //   1192	1197	1635	java/io/IOException
    //   879	886	1640	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */