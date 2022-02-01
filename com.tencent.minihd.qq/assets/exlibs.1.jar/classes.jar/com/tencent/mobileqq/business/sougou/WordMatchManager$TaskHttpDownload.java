package com.tencent.mobileqq.business.sougou;

public class WordMatchManager$TaskHttpDownload
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  
  public WordMatchManager$TaskHttpDownload(WordMatchManager paramWordMatchManager, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  private java.net.HttpURLConnection a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   4: iload_1
    //   5: invokevirtual 30	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(I)Ljava/lang/String;
    //   8: astore 4
    //   10: new 32	java/net/URL
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 35	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 39	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 41	java/net/HttpURLConnection
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +42 -> 71
    //   32: aconst_null
    //   33: astore_2
    //   34: aload_2
    //   35: areturn
    //   36: astore_2
    //   37: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +29 -> 69
    //   43: ldc 49
    //   45: iconst_2
    //   46: new 51	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   53: ldc 54
    //   55: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 4
    //   60: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_3
    //   72: sipush 30000
    //   75: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   83: iload_1
    //   84: invokevirtual 73	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)J
    //   87: invokevirtual 77	java/net/HttpURLConnection:setIfModifiedSince	(J)V
    //   90: aload_3
    //   91: sipush 30000
    //   94: invokevirtual 80	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   97: aload_3
    //   98: ldc 82
    //   100: invokevirtual 85	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   103: aload_3
    //   104: astore_2
    //   105: aload_3
    //   106: invokevirtual 89	java/net/HttpURLConnection:getResponseCode	()I
    //   109: sipush 200
    //   112: if_icmpeq -78 -> 34
    //   115: aload_3
    //   116: invokevirtual 89	java/net/HttpURLConnection:getResponseCode	()I
    //   119: istore_1
    //   120: aload_3
    //   121: astore_2
    //   122: iload_1
    //   123: sipush 206
    //   126: if_icmpeq -92 -> 34
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +29 -> 164
    //   138: ldc 49
    //   140: iconst_2
    //   141: new 51	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   148: ldc 91
    //   150: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 4
    //   155: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aconst_null
    //   165: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	TaskHttpDownload
    //   0	166	1	paramInt	int
    //   19	16	2	localURL	java.net.URL
    //   36	1	2	localMalformedURLException	java.net.MalformedURLException
    //   104	18	2	localObject	Object
    //   131	1	2	localIOException	java.io.IOException
    //   27	94	3	localHttpURLConnection	java.net.HttpURLConnection
    //   8	146	4	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   10	20	36	java/net/MalformedURLException
    //   20	28	131	java/io/IOException
    //   71	103	131	java/io/IOException
    //   105	120	131	java/io/IOException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 97	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +42 -> 47
    //   8: ldc 49
    //   10: iconst_4
    //   11: new 51	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   18: ldc 99
    //   20: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   27: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 104
    //   32: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   38: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: invokestatic 117	com/tencent/open/appcommon/Common:a	()Z
    //   50: ifne +105 -> 155
    //   53: iload_3
    //   54: istore_2
    //   55: invokestatic 97	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   58: ifeq +51 -> 109
    //   61: ldc 49
    //   63: iconst_4
    //   64: new 51	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   71: ldc 119
    //   73: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_0
    //   77: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   80: invokevirtual 102	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc 121
    //   85: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_2
    //   89: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: ldc 104
    //   94: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   100: invokevirtual 113	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   103: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iload_2
    //   110: ifeq +488 -> 598
    //   113: aload_0
    //   114: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   117: iconst_1
    //   118: if_icmpne +447 -> 565
    //   121: aload_0
    //   122: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   125: aload_0
    //   126: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   129: getfield 127	com/tencent/mobileqq/business/sougou/WordMatchManager:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   132: invokevirtual 130	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;)V
    //   135: aload_0
    //   136: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   139: iconst_1
    //   140: putfield 134	com/tencent/mobileqq/business/sougou/WordMatchManager:e	Z
    //   143: aload_0
    //   144: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   147: aload_0
    //   148: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   151: invokevirtual 136	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)V
    //   154: return
    //   155: new 138	java/io/File
    //   158: dup
    //   159: getstatic 142	com/tencent/mobileqq/business/sougou/WordMatchManager:c	Ljava/lang/String;
    //   162: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore 4
    //   167: aload 4
    //   169: invokevirtual 146	java/io/File:exists	()Z
    //   172: ifne +9 -> 181
    //   175: aload 4
    //   177: invokevirtual 149	java/io/File:mkdir	()Z
    //   180: pop
    //   181: new 51	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   188: aload_0
    //   189: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   192: aload_0
    //   193: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   196: invokevirtual 151	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   199: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 153
    //   204: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore 4
    //   212: new 138	java/io/File
    //   215: dup
    //   216: aload 4
    //   218: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   221: astore 6
    //   223: aload 6
    //   225: invokevirtual 146	java/io/File:exists	()Z
    //   228: ifeq +56 -> 284
    //   231: aload 6
    //   233: invokevirtual 156	java/io/File:delete	()Z
    //   236: ifne +42 -> 278
    //   239: iload_3
    //   240: istore_2
    //   241: invokestatic 97	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   244: ifeq -189 -> 55
    //   247: ldc 49
    //   249: iconst_4
    //   250: new 51	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   257: ldc 158
    //   259: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 4
    //   264: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: iload_3
    //   274: istore_2
    //   275: goto -220 -> 55
    //   278: aload 6
    //   280: invokevirtual 161	java/io/File:createNewFile	()Z
    //   283: pop
    //   284: iload_3
    //   285: istore_2
    //   286: invokestatic 167	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   289: invokestatic 172	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Landroid/content/Context;)I
    //   292: iconst_2
    //   293: if_icmpne -238 -> 55
    //   296: aload_0
    //   297: aload_0
    //   298: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   301: invokespecial 174	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:a	(I)Ljava/net/HttpURLConnection;
    //   304: astore 5
    //   306: iload_3
    //   307: istore_2
    //   308: aload 5
    //   310: ifnull -255 -> 55
    //   313: iload_3
    //   314: istore_2
    //   315: aload 5
    //   317: invokevirtual 89	java/net/HttpURLConnection:getResponseCode	()I
    //   320: sipush 200
    //   323: if_icmpne -268 -> 55
    //   326: aload 5
    //   328: invokevirtual 178	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   331: astore 7
    //   333: new 180	java/io/FileOutputStream
    //   336: dup
    //   337: aload 6
    //   339: iconst_1
    //   340: invokespecial 183	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   343: astore 6
    //   345: sipush 4096
    //   348: newarray byte
    //   350: astore 8
    //   352: aload 7
    //   354: aload 8
    //   356: invokevirtual 189	java/io/InputStream:read	([B)I
    //   359: istore_1
    //   360: iload_1
    //   361: iconst_m1
    //   362: if_icmpeq +49 -> 411
    //   365: aload 6
    //   367: aload 8
    //   369: iconst_0
    //   370: iload_1
    //   371: invokevirtual 193	java/io/FileOutputStream:write	([BII)V
    //   374: goto -22 -> 352
    //   377: astore 8
    //   379: invokestatic 97	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   382: ifeq +29 -> 411
    //   385: ldc 49
    //   387: iconst_4
    //   388: new 51	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   395: ldc 195
    //   397: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 4
    //   402: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 7
    //   413: invokevirtual 198	java/io/InputStream:close	()V
    //   416: aload 6
    //   418: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   421: iload_3
    //   422: istore_2
    //   423: aload 4
    //   425: aload_0
    //   426: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   429: aload_0
    //   430: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   433: invokevirtual 151	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   436: invokestatic 204	com/tencent/mobileqq/business/sougou/DictFileUtil:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   439: ifeq -384 -> 55
    //   442: aload_0
    //   443: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   446: aload_0
    //   447: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   450: aload 5
    //   452: invokevirtual 207	java/net/HttpURLConnection:getLastModified	()J
    //   455: invokevirtual 210	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(IJ)V
    //   458: iconst_1
    //   459: istore_2
    //   460: goto -405 -> 55
    //   463: astore 5
    //   465: iload_3
    //   466: istore_2
    //   467: invokestatic 97	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   470: ifeq -415 -> 55
    //   473: ldc 49
    //   475: iconst_4
    //   476: new 51	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   483: ldc 212
    //   485: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 4
    //   490: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: iload_3
    //   500: istore_2
    //   501: goto -446 -> 55
    //   504: astore 6
    //   506: iload_3
    //   507: istore_2
    //   508: invokestatic 97	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   511: ifeq -456 -> 55
    //   514: ldc 49
    //   516: iconst_4
    //   517: new 51	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   524: ldc 214
    //   526: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload 4
    //   531: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: iload_3
    //   541: istore_2
    //   542: goto -487 -> 55
    //   545: astore 6
    //   547: goto -126 -> 421
    //   550: astore 8
    //   552: aload 7
    //   554: invokevirtual 198	java/io/InputStream:close	()V
    //   557: aload 6
    //   559: invokevirtual 199	java/io/FileOutputStream:close	()V
    //   562: aload 8
    //   564: athrow
    //   565: aload_0
    //   566: getfield 18	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_Int	I
    //   569: iconst_2
    //   570: if_icmpne -427 -> 143
    //   573: aload_0
    //   574: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   577: aload_0
    //   578: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   581: getfield 216	com/tencent/mobileqq/business/sougou/WordMatchManager:b	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;
    //   584: invokevirtual 130	com/tencent/mobileqq/business/sougou/WordMatchManager:b	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;)V
    //   587: aload_0
    //   588: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   591: iconst_1
    //   592: putfield 134	com/tencent/mobileqq/business/sougou/WordMatchManager:e	Z
    //   595: goto -452 -> 143
    //   598: aload_0
    //   599: getfield 13	com/tencent/mobileqq/business/sougou/WordMatchManager$TaskHttpDownload:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   602: iload_2
    //   603: invokevirtual 219	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   606: return
    //   607: astore 7
    //   609: goto -193 -> 416
    //   612: astore 6
    //   614: goto -193 -> 421
    //   617: astore 7
    //   619: goto -62 -> 557
    //   622: astore 6
    //   624: goto -62 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	TaskHttpDownload
    //   359	12	1	i	int
    //   54	549	2	bool1	boolean
    //   1	540	3	bool2	boolean
    //   165	365	4	localObject1	Object
    //   304	147	5	localHttpURLConnection	java.net.HttpURLConnection
    //   463	1	5	localIOException1	java.io.IOException
    //   221	196	6	localObject2	Object
    //   504	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   545	13	6	localIOException2	java.io.IOException
    //   612	1	6	localIOException3	java.io.IOException
    //   622	1	6	localIOException4	java.io.IOException
    //   331	222	7	localInputStream	java.io.InputStream
    //   607	1	7	localIOException5	java.io.IOException
    //   617	1	7	localIOException6	java.io.IOException
    //   350	18	8	arrayOfByte	byte[]
    //   377	1	8	localIOException7	java.io.IOException
    //   550	13	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   365	374	377	java/io/IOException
    //   278	284	463	java/io/IOException
    //   333	345	504	java/io/FileNotFoundException
    //   315	333	545	java/io/IOException
    //   333	345	545	java/io/IOException
    //   508	540	545	java/io/IOException
    //   562	565	545	java/io/IOException
    //   345	352	550	finally
    //   352	360	550	finally
    //   365	374	550	finally
    //   379	411	550	finally
    //   411	416	607	java/io/IOException
    //   416	421	612	java/io/IOException
    //   552	557	617	java/io/IOException
    //   557	562	622	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.TaskHttpDownload
 * JD-Core Version:    0.7.0.1
 */