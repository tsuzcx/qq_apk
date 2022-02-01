package oicq.wlogin_sdk.tools;

public class c
{
  /* Error */
  public static int a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: new 10	java/net/URL
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 14	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 18	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 20	javax/net/ssl/HttpsURLConnection
    //   22: astore_0
    //   23: aload 5
    //   25: astore_3
    //   26: aload_0
    //   27: sipush 5000
    //   30: invokevirtual 24	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   33: aload 5
    //   35: astore_3
    //   36: aload_0
    //   37: sipush 5000
    //   40: invokevirtual 27	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   43: aload 5
    //   45: astore_3
    //   46: aload_0
    //   47: iconst_1
    //   48: invokevirtual 31	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   51: aload 5
    //   53: astore_3
    //   54: aload_0
    //   55: ldc 33
    //   57: invokevirtual 36	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   60: aload 5
    //   62: astore_3
    //   63: aload_0
    //   64: iconst_0
    //   65: invokevirtual 39	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   68: aload 5
    //   70: astore_3
    //   71: aload_0
    //   72: ldc 41
    //   74: ldc 43
    //   76: invokevirtual 47	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 5
    //   81: astore_3
    //   82: aload_0
    //   83: ldc 49
    //   85: ldc 51
    //   87: invokevirtual 47	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload 5
    //   92: astore_3
    //   93: aload_0
    //   94: invokevirtual 55	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: aload 4
    //   104: aload_1
    //   105: invokevirtual 61	java/lang/String:getBytes	()[B
    //   108: invokevirtual 67	java/io/OutputStream:write	([B)V
    //   111: aload 4
    //   113: astore_3
    //   114: aload 4
    //   116: invokevirtual 71	java/io/OutputStream:flush	()V
    //   119: aload 4
    //   121: astore_3
    //   122: aload_0
    //   123: invokevirtual 74	javax/net/ssl/HttpsURLConnection:connect	()V
    //   126: aload 4
    //   128: astore_3
    //   129: aload_0
    //   130: invokevirtual 78	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   133: istore_2
    //   134: aload 4
    //   136: ifnull +8 -> 144
    //   139: aload 4
    //   141: invokevirtual 81	java/io/OutputStream:close	()V
    //   144: aload_0
    //   145: ifnull +208 -> 353
    //   148: aload_0
    //   149: invokevirtual 84	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   152: iload_2
    //   153: sipush 200
    //   156: if_icmpeq +27 -> 183
    //   159: new 86	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   166: ldc 90
    //   168: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload_2
    //   172: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: ldc 103
    //   180: invokestatic 108	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload_2
    //   184: ireturn
    //   185: astore_1
    //   186: aload_1
    //   187: ldc 103
    //   189: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   192: goto -48 -> 144
    //   195: astore_0
    //   196: aload_0
    //   197: ldc 103
    //   199: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   202: goto -50 -> 152
    //   205: astore 4
    //   207: aconst_null
    //   208: astore_0
    //   209: aload_3
    //   210: astore_1
    //   211: aload 4
    //   213: astore_3
    //   214: aload_3
    //   215: ldc 103
    //   217: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 81	java/io/OutputStream:close	()V
    //   228: aload_1
    //   229: ifnull +119 -> 348
    //   232: aload_1
    //   233: invokevirtual 84	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   236: iconst_m1
    //   237: istore_2
    //   238: goto -86 -> 152
    //   241: astore_0
    //   242: aload_0
    //   243: ldc 103
    //   245: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   248: goto -20 -> 228
    //   251: astore_0
    //   252: aload_0
    //   253: ldc 103
    //   255: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   258: iconst_m1
    //   259: istore_2
    //   260: goto -108 -> 152
    //   263: astore_0
    //   264: aconst_null
    //   265: astore_1
    //   266: aload 4
    //   268: astore_3
    //   269: aload_3
    //   270: ifnull +7 -> 277
    //   273: aload_3
    //   274: invokevirtual 81	java/io/OutputStream:close	()V
    //   277: aload_1
    //   278: ifnull +7 -> 285
    //   281: aload_1
    //   282: invokevirtual 84	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   285: aload_0
    //   286: athrow
    //   287: astore_3
    //   288: aload_3
    //   289: ldc 103
    //   291: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   294: goto -17 -> 277
    //   297: astore_1
    //   298: aload_1
    //   299: ldc 103
    //   301: invokestatic 112	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   304: goto -19 -> 285
    //   307: astore 4
    //   309: aload_0
    //   310: astore_1
    //   311: aload 4
    //   313: astore_0
    //   314: goto -45 -> 269
    //   317: astore 4
    //   319: aload_0
    //   320: astore_3
    //   321: aload 4
    //   323: astore_0
    //   324: goto -55 -> 269
    //   327: astore_3
    //   328: aconst_null
    //   329: astore 4
    //   331: aload_0
    //   332: astore_1
    //   333: aload 4
    //   335: astore_0
    //   336: goto -122 -> 214
    //   339: astore_3
    //   340: aload_0
    //   341: astore_1
    //   342: aload 4
    //   344: astore_0
    //   345: goto -131 -> 214
    //   348: iconst_m1
    //   349: istore_2
    //   350: goto -198 -> 152
    //   353: goto -201 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString1	java.lang.String
    //   0	356	1	paramString2	java.lang.String
    //   133	217	2	i	int
    //   7	267	3	localObject1	Object
    //   287	2	3	localException1	java.lang.Exception
    //   320	1	3	str	java.lang.String
    //   327	1	3	localException2	java.lang.Exception
    //   339	1	3	localException3	java.lang.Exception
    //   1	139	4	localOutputStream	java.io.OutputStream
    //   205	62	4	localException4	java.lang.Exception
    //   307	5	4	localObject2	Object
    //   317	5	4	localObject3	Object
    //   329	14	4	localObject4	Object
    //   4	87	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   139	144	185	java/lang/Exception
    //   148	152	195	java/lang/Exception
    //   8	23	205	java/lang/Exception
    //   224	228	241	java/lang/Exception
    //   232	236	251	java/lang/Exception
    //   8	23	263	finally
    //   273	277	287	java/lang/Exception
    //   281	285	297	java/lang/Exception
    //   26	33	307	finally
    //   36	43	307	finally
    //   46	51	307	finally
    //   54	60	307	finally
    //   63	68	307	finally
    //   71	79	307	finally
    //   82	90	307	finally
    //   93	99	307	finally
    //   102	111	307	finally
    //   114	119	307	finally
    //   122	126	307	finally
    //   129	134	307	finally
    //   214	220	317	finally
    //   26	33	327	java/lang/Exception
    //   36	43	327	java/lang/Exception
    //   46	51	327	java/lang/Exception
    //   54	60	327	java/lang/Exception
    //   63	68	327	java/lang/Exception
    //   71	79	327	java/lang/Exception
    //   82	90	327	java/lang/Exception
    //   93	99	327	java/lang/Exception
    //   102	111	339	java/lang/Exception
    //   114	119	339	java/lang/Exception
    //   122	126	339	java/lang/Exception
    //   129	134	339	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.c
 * JD-Core Version:    0.7.0.1
 */