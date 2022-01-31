package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthErrCode;

final class d$a
{
  public OAuthErrCode n;
  public String o;
  public String p;
  public String q;
  public int r;
  public String s;
  public byte[] t;
  
  /* Error */
  public static a a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 27
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 2	com/tencent/mm/opensdk/diffdev/a/d$a
    //   8: dup
    //   9: invokespecial 34	com/tencent/mm/opensdk/diffdev/a/d$a:<init>	()V
    //   12: astore_2
    //   13: aload_0
    //   14: ifnull +8 -> 22
    //   17: aload_0
    //   18: arraylength
    //   19: ifne +24 -> 43
    //   22: ldc 36
    //   24: ldc 38
    //   26: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_2
    //   30: getstatic 49	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NetworkErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   33: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   36: ldc 27
    //   38: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_2
    //   42: areturn
    //   43: new 55	java/lang/String
    //   46: dup
    //   47: aload_0
    //   48: ldc 57
    //   50: invokespecial 60	java/lang/String:<init>	([BLjava/lang/String;)V
    //   53: astore_0
    //   54: new 62	org/json/JSONObject
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 65	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   62: astore_0
    //   63: aload_0
    //   64: ldc 67
    //   66: invokevirtual 71	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifeq +89 -> 160
    //   74: ldc 36
    //   76: ldc 73
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: iload_1
    //   85: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 83	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_2
    //   96: getstatic 86	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NormalErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   99: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   102: aload_2
    //   103: iload_1
    //   104: putfield 88	com/tencent/mm/opensdk/diffdev/a/d$a:r	I
    //   107: aload_2
    //   108: aload_0
    //   109: ldc 90
    //   111: invokevirtual 94	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 96	com/tencent/mm/opensdk/diffdev/a/d$a:s	Ljava/lang/String;
    //   117: ldc 27
    //   119: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_2
    //   123: areturn
    //   124: astore_0
    //   125: ldc 36
    //   127: ldc 98
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 83	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   143: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: getstatic 86	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NormalErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   150: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   153: ldc 27
    //   155: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: areturn
    //   160: aload_0
    //   161: ldc 104
    //   163: invokevirtual 108	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   166: ldc 110
    //   168: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore_3
    //   172: aload_3
    //   173: ifnull +10 -> 183
    //   176: aload_3
    //   177: invokevirtual 117	java/lang/String:length	()I
    //   180: ifne +24 -> 204
    //   183: ldc 36
    //   185: ldc 119
    //   187: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_2
    //   191: getstatic 122	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_JsonDecodeErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   194: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   197: ldc 27
    //   199: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_2
    //   203: areturn
    //   204: aload_3
    //   205: iconst_0
    //   206: invokestatic 128	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   209: astore_3
    //   210: aload_3
    //   211: ifnull +8 -> 219
    //   214: aload_3
    //   215: arraylength
    //   216: ifne +24 -> 240
    //   219: ldc 36
    //   221: ldc 130
    //   223: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_2
    //   227: getstatic 122	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_JsonDecodeErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   230: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   233: ldc 27
    //   235: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_2
    //   239: areturn
    //   240: aload_2
    //   241: getstatic 133	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_OK	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   244: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   247: aload_2
    //   248: aload_3
    //   249: putfield 135	com/tencent/mm/opensdk/diffdev/a/d$a:t	[B
    //   252: aload_2
    //   253: aload_0
    //   254: ldc 137
    //   256: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: putfield 139	com/tencent/mm/opensdk/diffdev/a/d$a:o	Ljava/lang/String;
    //   262: aload_2
    //   263: aload_0
    //   264: ldc 141
    //   266: invokevirtual 113	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 143	com/tencent/mm/opensdk/diffdev/a/d$a:p	Ljava/lang/String;
    //   272: ldc 36
    //   274: ldc 145
    //   276: iconst_3
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload_2
    //   283: getfield 139	com/tencent/mm/opensdk/diffdev/a/d$a:o	Ljava/lang/String;
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_2
    //   290: getfield 143	com/tencent/mm/opensdk/diffdev/a/d$a:p	Ljava/lang/String;
    //   293: aastore
    //   294: dup
    //   295: iconst_2
    //   296: aload_2
    //   297: getfield 135	com/tencent/mm/opensdk/diffdev/a/d$a:t	[B
    //   300: arraylength
    //   301: invokestatic 79	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: aastore
    //   305: invokestatic 83	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   308: invokestatic 148	com/tencent/mm/opensdk/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: ldc 27
    //   313: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_2
    //   317: areturn
    //   318: astore_0
    //   319: ldc 36
    //   321: ldc 150
    //   323: iconst_1
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: aastore
    //   334: invokestatic 83	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   337: invokestatic 44	com/tencent/mm/opensdk/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload_2
    //   341: getstatic 86	com/tencent/mm/opensdk/diffdev/OAuthErrCode:WechatAuth_Err_NormalErr	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   344: putfield 51	com/tencent/mm/opensdk/diffdev/a/d$a:n	Lcom/tencent/mm/opensdk/diffdev/OAuthErrCode;
    //   347: ldc 27
    //   349: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload_2
    //   353: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramArrayOfByte	byte[]
    //   69	35	1	i	int
    //   12	341	2	locala	a
    //   171	78	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	54	124	java/lang/Exception
    //   54	70	318	java/lang/Exception
    //   74	117	318	java/lang/Exception
    //   160	172	318	java/lang/Exception
    //   176	183	318	java/lang/Exception
    //   183	197	318	java/lang/Exception
    //   204	210	318	java/lang/Exception
    //   214	219	318	java/lang/Exception
    //   219	233	318	java/lang/Exception
    //   240	311	318	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.a.d.a
 * JD-Core Version:    0.7.0.1
 */