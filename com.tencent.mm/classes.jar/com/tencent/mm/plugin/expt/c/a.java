package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class a
{
  private static MMHandler mHandler;
  private static DateFormat zxC;
  
  static
  {
    AppMethodBeat.i(299514);
    zxC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    mHandler = new MMHandler("ILogHttpReporter#mHandler");
    AppMethodBeat.o(299514);
  }
  
  public static void bm(final int paramInt, String paramString)
  {
    AppMethodBeat.i(299498);
    long l1 = System.currentTimeMillis();
    long l2 = l1 / 1000L;
    mHandler.post(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 36
        //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 22	com/tencent/mm/plugin/expt/c/a$1:zxD	J
        //   9: invokestatic 48	java/lang/String:valueOf	(J)Ljava/lang/String;
        //   12: astore 6
        //   14: ldc 50
        //   16: iconst_3
        //   17: anewarray 4	java/lang/Object
        //   20: dup
        //   21: iconst_0
        //   22: ldc 52
        //   24: aastore
        //   25: dup
        //   26: iconst_1
        //   27: ldc 54
        //   29: aastore
        //   30: dup
        //   31: iconst_2
        //   32: aload 6
        //   34: aastore
        //   35: invokestatic 58	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   38: invokestatic 62	com/tencent/mm/plugin/expt/c/a:md5HexDigest	(Ljava/lang/String;)Ljava/lang/String;
        //   41: invokestatic 67	org/apache/commons/c/i:bLi	(Ljava/lang/String;)Ljava/lang/String;
        //   44: astore 7
        //   46: new 69	org/json/JSONArray
        //   49: dup
        //   50: invokespecial 70	org/json/JSONArray:<init>	()V
        //   53: astore 4
        //   55: new 72	org/json/JSONObject
        //   58: dup
        //   59: invokespecial 73	org/json/JSONObject:<init>	()V
        //   62: astore_2
        //   63: aload_2
        //   64: ldc 75
        //   66: invokestatic 79	com/tencent/mm/plugin/expt/c/a:dHS	()Ljava/text/DateFormat;
        //   69: new 81	java/util/Date
        //   72: dup
        //   73: aload_0
        //   74: getfield 24	com/tencent/mm/plugin/expt/c/a$1:zxE	J
        //   77: invokespecial 84	java/util/Date:<init>	(J)V
        //   80: invokevirtual 89	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
        //   83: invokevirtual 93	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   86: pop
        //   87: invokestatic 99	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
        //   90: pop
        //   91: aload_2
        //   92: ldc 101
        //   94: invokestatic 107	com/tencent/mm/kernel/b:getUin	()I
        //   97: invokestatic 113	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
        //   100: invokestatic 119	java/lang/Long:parseLong	(Ljava/lang/String;)J
        //   103: invokevirtual 122	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   106: pop
        //   107: aload_2
        //   108: ldc 124
        //   110: getstatic 129	com/tencent/mm/protocal/d:YwZ	I
        //   113: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   116: pop
        //   117: aload_2
        //   118: ldc 134
        //   120: getstatic 137	com/tencent/mm/protocal/d:Yxh	I
        //   123: invokestatic 139	java/lang/String:valueOf	(I)Ljava/lang/String;
        //   126: invokevirtual 93	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   129: pop
        //   130: aload_2
        //   131: ldc 141
        //   133: aload_0
        //   134: getfield 26	com/tencent/mm/plugin/expt/c/a$1:zxF	I
        //   137: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   140: pop
        //   141: aload_2
        //   142: ldc 143
        //   144: aload_0
        //   145: getfield 28	com/tencent/mm/plugin/expt/c/a$1:val$data	Ljava/lang/String;
        //   148: invokevirtual 93	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   151: pop
        //   152: aload 4
        //   154: aload_2
        //   155: invokevirtual 146	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
        //   158: pop
        //   159: aconst_null
        //   160: astore_2
        //   161: aconst_null
        //   162: astore 5
        //   164: new 148	java/net/URL
        //   167: dup
        //   168: ldc 150
        //   170: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
        //   173: invokevirtual 157	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   176: checkcast 159	java/net/HttpURLConnection
        //   179: astore_3
        //   180: aload_3
        //   181: ifnull +243 -> 424
        //   184: aload_3
        //   185: ldc 161
        //   187: invokevirtual 164	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   190: aload_3
        //   191: ldc 166
        //   193: aload 6
        //   195: invokevirtual 170	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   198: aload_3
        //   199: ldc 172
        //   201: ldc 52
        //   203: invokevirtual 170	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   206: aload_3
        //   207: ldc 174
        //   209: aload 7
        //   211: invokevirtual 170	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   214: aload_3
        //   215: iconst_1
        //   216: invokevirtual 178	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   219: new 180	java/io/DataOutputStream
        //   222: dup
        //   223: aload_3
        //   224: invokevirtual 184	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   227: invokespecial 187	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   230: astore_2
        //   231: aload_2
        //   232: aload 4
        //   234: invokevirtual 191	org/json/JSONArray:toString	()Ljava/lang/String;
        //   237: invokevirtual 194	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
        //   240: aload_2
        //   241: invokevirtual 197	java/io/DataOutputStream:flush	()V
        //   244: aload_2
        //   245: invokevirtual 200	java/io/DataOutputStream:close	()V
        //   248: aload_3
        //   249: invokevirtual 203	java/net/HttpURLConnection:getResponseCode	()I
        //   252: istore_1
        //   253: new 205	java/lang/StringBuilder
        //   256: dup
        //   257: invokespecial 206	java/lang/StringBuilder:<init>	()V
        //   260: astore_2
        //   261: aload_3
        //   262: invokevirtual 210	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   265: astore 4
        //   267: aload 4
        //   269: ifnull +124 -> 393
        //   272: new 212	java/io/BufferedReader
        //   275: dup
        //   276: new 214	java/io/InputStreamReader
        //   279: dup
        //   280: aload 4
        //   282: invokespecial 217	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   285: invokespecial 220	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   288: astore 5
        //   290: aload 5
        //   292: invokevirtual 223	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   295: astore 6
        //   297: aload 6
        //   299: ifnull +84 -> 383
        //   302: aload_2
        //   303: aload 6
        //   305: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   308: pop
        //   309: goto -19 -> 290
        //   312: astore 4
        //   314: aload_3
        //   315: astore_2
        //   316: ldc 229
        //   318: new 205	java/lang/StringBuilder
        //   321: dup
        //   322: ldc 231
        //   324: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   327: aload 4
        //   329: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   332: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   335: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   338: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   341: aload_3
        //   342: ifnull +112 -> 454
        //   345: aload_3
        //   346: invokevirtual 244	java/net/HttpURLConnection:disconnect	()V
        //   349: ldc 36
        //   351: invokestatic 247	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   354: return
        //   355: astore_2
        //   356: ldc 229
        //   358: new 205	java/lang/StringBuilder
        //   361: dup
        //   362: ldc 249
        //   364: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   367: aload_2
        //   368: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   371: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   374: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   377: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   380: goto -221 -> 159
        //   383: aload 5
        //   385: invokevirtual 250	java/io/BufferedReader:close	()V
        //   388: aload 4
        //   390: invokevirtual 253	java/io/InputStream:close	()V
        //   393: ldc 229
        //   395: new 205	java/lang/StringBuilder
        //   398: dup
        //   399: ldc 255
        //   401: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   404: iload_1
        //   405: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   408: ldc_w 260
        //   411: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   414: aload_2
        //   415: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   418: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   421: invokestatic 266	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   424: aload_3
        //   425: ifnull +29 -> 454
        //   428: aload_3
        //   429: invokevirtual 244	java/net/HttpURLConnection:disconnect	()V
        //   432: ldc 36
        //   434: invokestatic 247	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   437: return
        //   438: astore_3
        //   439: aload_2
        //   440: ifnull +7 -> 447
        //   443: aload_2
        //   444: invokevirtual 244	java/net/HttpURLConnection:disconnect	()V
        //   447: ldc 36
        //   449: invokestatic 247	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   452: aload_3
        //   453: athrow
        //   454: ldc 36
        //   456: invokestatic 247	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   459: return
        //   460: astore 4
        //   462: aload_3
        //   463: astore_2
        //   464: aload 4
        //   466: astore_3
        //   467: goto -28 -> 439
        //   470: astore 4
        //   472: aload 5
        //   474: astore_3
        //   475: goto -161 -> 314
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	478	0	this	1
        //   252	153	1	i	int
        //   62	254	2	localObject1	Object
        //   355	89	2	localException1	Exception
        //   463	1	2	localObject2	Object
        //   179	250	3	localHttpURLConnection	java.net.HttpURLConnection
        //   438	25	3	localObject3	Object
        //   466	9	3	localObject4	Object
        //   53	228	4	localObject5	Object
        //   312	77	4	localException2	Exception
        //   460	5	4	localObject6	Object
        //   470	1	4	localException3	Exception
        //   162	311	5	localBufferedReader	java.io.BufferedReader
        //   12	292	6	str1	String
        //   44	166	7	str2	String
        // Exception table:
        //   from	to	target	type
        //   184	267	312	java/lang/Exception
        //   272	290	312	java/lang/Exception
        //   290	297	312	java/lang/Exception
        //   302	309	312	java/lang/Exception
        //   383	393	312	java/lang/Exception
        //   393	424	312	java/lang/Exception
        //   55	159	355	java/lang/Exception
        //   164	180	438	finally
        //   316	341	438	finally
        //   184	267	460	finally
        //   272	290	460	finally
        //   290	297	460	finally
        //   302	309	460	finally
        //   383	393	460	finally
        //   393	424	460	finally
        //   164	180	470	java/lang/Exception
      }
    });
    AppMethodBeat.o(299498);
  }
  
  public static String md5HexDigest(String paramString)
  {
    AppMethodBeat.i(299505);
    char[] arrayOfChar = new char[16];
    char[] tmp13_11 = arrayOfChar;
    tmp13_11[0] = 48;
    char[] tmp18_13 = tmp13_11;
    tmp18_13[1] = 49;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[2] = 50;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[3] = 51;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[4] = 52;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[5] = 53;
    char[] tmp43_38 = tmp38_33;
    tmp43_38[6] = 54;
    char[] tmp49_43 = tmp43_38;
    tmp49_43[7] = 55;
    char[] tmp55_49 = tmp49_43;
    tmp55_49[8] = 56;
    char[] tmp61_55 = tmp55_49;
    tmp61_55[9] = 57;
    char[] tmp67_61 = tmp61_55;
    tmp67_61[10] = 65;
    char[] tmp73_67 = tmp67_61;
    tmp73_67[11] = 66;
    char[] tmp79_73 = tmp73_67;
    tmp79_73[12] = 67;
    char[] tmp85_79 = tmp79_73;
    tmp85_79[13] = 68;
    char[] tmp91_85 = tmp85_79;
    tmp91_85[14] = 69;
    char[] tmp97_91 = tmp91_85;
    tmp97_91[15] = 70;
    tmp97_91;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramString)
      {
        paramString = null;
        continue;
      }
      paramString = new String((char[])localObject);
      AppMethodBeat.o(299505);
      return paramString;
      while (i < 16)
      {
        int m = paramString[i];
        int k = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        localObject[k] = arrayOfChar[(m & 0xF)];
        i += 1;
        j = k + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.a
 * JD-Core Version:    0.7.0.1
 */