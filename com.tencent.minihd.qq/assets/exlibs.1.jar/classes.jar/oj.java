import com.qqreader.QRBridgeActivity;

public class oj
  implements Runnable
{
  public oj(QRBridgeActivity paramQRBridgeActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   9: getfield 25	com/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 30	com/tencent/mobileqq/app/QQAppInterface:a	()[B
    //   15: ifnonnull +18 -> 33
    //   18: invokestatic 36	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   21: ifeq +11 -> 32
    //   24: ldc 38
    //   26: iconst_4
    //   27: ldc 40
    //   29: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: return
    //   33: aload_3
    //   34: astore_2
    //   35: new 46	java/lang/String
    //   38: dup
    //   39: aload_0
    //   40: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   43: getfield 25	com/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: invokevirtual 30	com/tencent/mobileqq/app/QQAppInterface:a	()[B
    //   49: ldc 48
    //   51: invokespecial 51	java/lang/String:<init>	([BLjava/lang/String;)V
    //   54: astore 4
    //   56: aload_3
    //   57: astore_2
    //   58: new 53	java/net/URL
    //   61: dup
    //   62: new 55	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   69: ldc 58
    //   71: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 4
    //   76: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokespecial 69	java/net/URL:<init>	(Ljava/lang/String;)V
    //   85: invokevirtual 73	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   88: checkcast 75	java/net/HttpURLConnection
    //   91: astore_3
    //   92: aload_3
    //   93: sipush 10000
    //   96: invokevirtual 79	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   99: new 55	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   106: ldc 81
    //   108: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   115: getfield 25	com/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: invokevirtual 83	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   121: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 85
    //   126: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   133: getfield 25	com/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 83	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   139: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 87
    //   144: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 4
    //   149: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore_2
    //   156: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +28 -> 187
    //   162: ldc 38
    //   164: iconst_2
    //   165: new 55	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   172: ldc 92
    //   174: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_2
    //   178: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_3
    //   188: ldc 94
    //   190: aload_2
    //   191: invokevirtual 98	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_3
    //   195: invokevirtual 102	java/net/HttpURLConnection:getResponseCode	()I
    //   198: sipush 200
    //   201: if_icmpne +295 -> 496
    //   204: new 104	java/io/BufferedReader
    //   207: dup
    //   208: new 106	java/io/InputStreamReader
    //   211: dup
    //   212: aload_3
    //   213: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   216: invokespecial 113	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   219: invokespecial 116	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   222: astore_2
    //   223: new 118	java/lang/StringBuffer
    //   226: dup
    //   227: invokespecial 119	java/lang/StringBuffer:<init>	()V
    //   230: astore 4
    //   232: aload_2
    //   233: invokevirtual 122	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   236: astore 5
    //   238: aload 5
    //   240: ifnull +32 -> 272
    //   243: aload 4
    //   245: aload 5
    //   247: invokevirtual 125	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   250: pop
    //   251: goto -19 -> 232
    //   254: astore 4
    //   256: aload_3
    //   257: astore_2
    //   258: aload 4
    //   260: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   263: aload_3
    //   264: ifnull -232 -> 32
    //   267: aload_3
    //   268: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   271: return
    //   272: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +32 -> 307
    //   278: ldc 38
    //   280: iconst_2
    //   281: new 55	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   288: ldc 133
    //   290: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 4
    //   295: invokevirtual 134	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   298: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: new 136	org/json/JSONObject
    //   310: dup
    //   311: aload 4
    //   313: invokevirtual 134	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   316: invokespecial 137	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   319: astore_2
    //   320: aload_0
    //   321: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   324: getfield 140	com/qqreader/QRBridgeActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   327: ifnull +169 -> 496
    //   330: aload_0
    //   331: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   334: aload_2
    //   335: ldc 142
    //   337: invokevirtual 146	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   340: putfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   343: aload_0
    //   344: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   347: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   350: ldc 151
    //   352: invokevirtual 155	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   355: istore_1
    //   356: iload_1
    //   357: ifne +12 -> 369
    //   360: aload_3
    //   361: ifnull -329 -> 32
    //   364: aload_3
    //   365: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   368: return
    //   369: aload_0
    //   370: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   373: aload_0
    //   374: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   377: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   380: ldc 151
    //   382: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   385: putfield 163	com/qqreader/QRBridgeActivity:o	Ljava/lang/String;
    //   388: aload_0
    //   389: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   392: aload_0
    //   393: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   396: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   399: ldc 165
    //   401: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   404: putfield 168	com/qqreader/QRBridgeActivity:k	Ljava/lang/String;
    //   407: aload_0
    //   408: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   411: aload_0
    //   412: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   415: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   418: ldc 170
    //   420: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   423: putfield 173	com/qqreader/QRBridgeActivity:l	Ljava/lang/String;
    //   426: aload_0
    //   427: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   430: aload_0
    //   431: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   434: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   437: ldc 175
    //   439: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   442: putfield 178	com/qqreader/QRBridgeActivity:m	Ljava/lang/String;
    //   445: aload_0
    //   446: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   449: aload_0
    //   450: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   453: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   456: ldc 180
    //   458: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield 183	com/qqreader/QRBridgeActivity:n	Ljava/lang/String;
    //   464: aload_0
    //   465: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   468: aload_0
    //   469: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   472: getfield 149	com/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   475: ldc 185
    //   477: invokevirtual 189	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   480: putfield 193	com/qqreader/QRBridgeActivity:h	I
    //   483: aload_0
    //   484: getfield 12	oj:a	Lcom/qqreader/QRBridgeActivity;
    //   487: getfield 196	com/qqreader/QRBridgeActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   490: bipush 100
    //   492: invokevirtual 202	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   495: pop
    //   496: aload_3
    //   497: ifnull -465 -> 32
    //   500: aload_3
    //   501: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   504: return
    //   505: astore 4
    //   507: aload_2
    //   508: astore_3
    //   509: aload 4
    //   511: astore_2
    //   512: aload_3
    //   513: ifnull +7 -> 520
    //   516: aload_3
    //   517: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   520: aload_2
    //   521: athrow
    //   522: astore_2
    //   523: goto -11 -> 512
    //   526: astore 4
    //   528: aload 5
    //   530: astore_3
    //   531: goto -275 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	oj
    //   355	2	1	bool	boolean
    //   34	487	2	localObject1	Object
    //   522	1	2	localObject2	Object
    //   1	530	3	localObject3	Object
    //   54	190	4	localObject4	Object
    //   254	58	4	localException1	java.lang.Exception
    //   505	5	4	localObject5	Object
    //   526	1	4	localException2	java.lang.Exception
    //   3	526	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   92	187	254	java/lang/Exception
    //   187	232	254	java/lang/Exception
    //   232	238	254	java/lang/Exception
    //   243	251	254	java/lang/Exception
    //   272	307	254	java/lang/Exception
    //   307	356	254	java/lang/Exception
    //   369	496	254	java/lang/Exception
    //   35	56	505	finally
    //   58	92	505	finally
    //   258	263	505	finally
    //   92	187	522	finally
    //   187	232	522	finally
    //   232	238	522	finally
    //   243	251	522	finally
    //   272	307	522	finally
    //   307	356	522	finally
    //   369	496	522	finally
    //   35	56	526	java/lang/Exception
    //   58	92	526	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     oj
 * JD-Core Version:    0.7.0.1
 */