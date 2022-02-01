package com.tencent.mobileqq.msf.core.net;

class o
  extends Thread
{
  o(h paramh) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   4: iconst_0
    //   5: putfield 23	com/tencent/mobileqq/msf/core/net/h:B	I
    //   8: aload_0
    //   9: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   12: iconst_0
    //   13: putfield 27	com/tencent/mobileqq/msf/core/net/h:C	Z
    //   16: ldc 29
    //   18: invokevirtual 35	java/lang/String:getBytes	()[B
    //   21: astore 7
    //   23: sipush 128
    //   26: newarray byte
    //   28: astore 9
    //   30: aconst_null
    //   31: astore 6
    //   33: aconst_null
    //   34: astore 8
    //   36: aload 6
    //   38: astore 5
    //   40: new 37	java/net/URL
    //   43: dup
    //   44: ldc 39
    //   46: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   49: astore 10
    //   51: aload 6
    //   53: astore 5
    //   55: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   58: lstore_3
    //   59: aload 6
    //   61: astore 5
    //   63: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +15 -> 81
    //   69: aload 6
    //   71: astore 5
    //   73: ldc 56
    //   75: iconst_2
    //   76: ldc 58
    //   78: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 6
    //   83: astore 5
    //   85: aload 10
    //   87: invokevirtual 66	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 68	java/net/HttpURLConnection
    //   93: astore 6
    //   95: aload 6
    //   97: iconst_1
    //   98: invokevirtual 72	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   101: aload 6
    //   103: ldc 74
    //   105: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 6
    //   110: sipush 10000
    //   113: invokevirtual 81	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   116: aload 6
    //   118: sipush 10000
    //   121: invokevirtual 84	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   124: aload 6
    //   126: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   129: aload 7
    //   131: invokevirtual 94	java/io/OutputStream:write	([B)V
    //   134: aload 6
    //   136: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   139: invokevirtual 97	java/io/OutputStream:flush	()V
    //   142: aload 6
    //   144: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   147: invokevirtual 100	java/io/OutputStream:close	()V
    //   150: aload 6
    //   152: invokevirtual 104	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   155: aload 9
    //   157: invokevirtual 110	java/io/InputStream:read	([B)I
    //   160: istore_1
    //   161: aload 6
    //   163: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   166: istore_2
    //   167: iload_2
    //   168: sipush 200
    //   171: if_icmpne +112 -> 283
    //   174: aload 10
    //   176: invokevirtual 118	java/net/URL:getHost	()Ljava/lang/String;
    //   179: aload 6
    //   181: invokevirtual 122	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   184: invokevirtual 118	java/net/URL:getHost	()Ljava/lang/String;
    //   187: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +93 -> 283
    //   193: ldc 56
    //   195: iconst_1
    //   196: new 128	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   203: ldc 131
    //   205: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload_2
    //   209: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc 140
    //   214: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   220: lload_3
    //   221: lsub
    //   222: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: ldc 145
    //   227: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_1
    //   231: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   244: iload_2
    //   245: putfield 23	com/tencent/mobileqq/msf/core/net/h:B	I
    //   248: aload_0
    //   249: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   252: iconst_1
    //   253: putfield 27	com/tencent/mobileqq/msf/core/net/h:C	Z
    //   256: aload 6
    //   258: ifnull +8 -> 266
    //   261: aload 6
    //   263: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   266: aload_0
    //   267: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   270: astore 5
    //   272: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   275: lstore_3
    //   276: aload 5
    //   278: lload_3
    //   279: putfield 155	com/tencent/mobileqq/msf/core/net/h:E	J
    //   282: return
    //   283: new 128	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   290: ldc 157
    //   292: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload_2
    //   296: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   299: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: pop
    //   303: ldc 56
    //   305: iconst_1
    //   306: new 128	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   313: ldc 159
    //   315: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: iload_2
    //   319: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc 145
    //   324: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload_1
    //   328: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: goto -81 -> 256
    //   340: astore 7
    //   342: aload 6
    //   344: astore 5
    //   346: aload 7
    //   348: invokevirtual 160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   351: astore 8
    //   353: aload 6
    //   355: astore 5
    //   357: aload_0
    //   358: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   361: iconst_0
    //   362: putfield 23	com/tencent/mobileqq/msf/core/net/h:B	I
    //   365: aload 6
    //   367: astore 5
    //   369: aload_0
    //   370: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   373: iconst_0
    //   374: putfield 27	com/tencent/mobileqq/msf/core/net/h:C	Z
    //   377: aload 6
    //   379: astore 5
    //   381: ldc 56
    //   383: iconst_1
    //   384: new 128	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   391: ldc 162
    //   393: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 8
    //   398: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: aload 7
    //   406: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   409: aload 6
    //   411: ifnull +8 -> 419
    //   414: aload 6
    //   416: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   419: aload_0
    //   420: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   423: astore 5
    //   425: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   428: lstore_3
    //   429: goto -153 -> 276
    //   432: astore 7
    //   434: aload 5
    //   436: astore 6
    //   438: aload 7
    //   440: astore 5
    //   442: aload 6
    //   444: ifnull +8 -> 452
    //   447: aload 6
    //   449: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   452: aload_0
    //   453: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   456: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   459: putfield 155	com/tencent/mobileqq/msf/core/net/h:E	J
    //   462: aload 5
    //   464: athrow
    //   465: astore 5
    //   467: goto -25 -> 442
    //   470: astore 7
    //   472: aload 8
    //   474: astore 6
    //   476: goto -134 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	o
    //   160	168	1	i	int
    //   166	153	2	j	int
    //   58	371	3	l	long
    //   38	425	5	localObject1	java.lang.Object
    //   465	1	5	localObject2	java.lang.Object
    //   31	444	6	localObject3	java.lang.Object
    //   21	109	7	arrayOfByte1	byte[]
    //   340	65	7	localThrowable1	java.lang.Throwable
    //   432	7	7	localObject4	java.lang.Object
    //   470	1	7	localThrowable2	java.lang.Throwable
    //   34	439	8	str	java.lang.String
    //   28	128	9	arrayOfByte2	byte[]
    //   49	126	10	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   95	167	340	java/lang/Throwable
    //   174	256	340	java/lang/Throwable
    //   283	337	340	java/lang/Throwable
    //   40	51	432	finally
    //   55	59	432	finally
    //   63	69	432	finally
    //   73	81	432	finally
    //   85	95	432	finally
    //   346	353	432	finally
    //   357	365	432	finally
    //   369	377	432	finally
    //   381	409	432	finally
    //   95	167	465	finally
    //   174	256	465	finally
    //   283	337	465	finally
    //   40	51	470	java/lang/Throwable
    //   55	59	470	java/lang/Throwable
    //   63	69	470	java/lang/Throwable
    //   73	81	470	java/lang/Throwable
    //   85	95	470	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.o
 * JD-Core Version:    0.7.0.1
 */