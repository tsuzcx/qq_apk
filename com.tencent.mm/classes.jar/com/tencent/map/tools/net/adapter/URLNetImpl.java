package com.tencent.map.tools.net.adapter;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.map.tools.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;

public class URLNetImpl
  extends AbsNetImpl
{
  private static final boolean DEBUG = false;
  private static final String TAG = "URLNetImpl";
  private HttpURLConnection mCurrentConnect;
  
  private void disableConnectionReuseIfNecessary()
  {
    AppMethodBeat.i(180933);
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    AppMethodBeat.o(180933);
  }
  
  public boolean cancel()
  {
    AppMethodBeat.i(180934);
    if (this.mCurrentConnect != null)
    {
      this.mCurrentConnect.disconnect();
      AppMethodBeat.o(180934);
      return true;
    }
    AppMethodBeat.o(180934);
    return false;
  }
  
  protected void onCreateNet(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(180928);
    disableConnectionReuseIfNecessary();
    AppMethodBeat.o(180928);
  }
  
  /* Error */
  protected com.tencent.map.tools.net.NetResponse onGetRequest(String paramString1, String paramString2, int paramInt1, int paramInt2, java.util.HashMap<String, String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 8
    //   8: new 87	java/net/URL
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: astore 11
    //   18: aload 8
    //   20: astore_1
    //   21: new 12	com/tencent/map/tools/net/adapter/URLNetImpl$a
    //   24: dup
    //   25: aload_0
    //   26: iload_3
    //   27: invokespecial 93	com/tencent/map/tools/net/adapter/URLNetImpl$a:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;I)V
    //   30: astore 13
    //   32: aload 13
    //   34: invokevirtual 95	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	()Z
    //   37: ifeq +609 -> 646
    //   40: iconst_0
    //   41: istore 7
    //   43: iconst_0
    //   44: istore_3
    //   45: aload 11
    //   47: ifnull +639 -> 686
    //   50: aload 11
    //   52: invokevirtual 99	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   55: checkcast 68	java/net/HttpURLConnection
    //   58: astore 8
    //   60: aload 8
    //   62: astore 9
    //   64: iload 7
    //   66: istore_3
    //   67: aload 8
    //   69: ldc 101
    //   71: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   74: iload 4
    //   76: ifle +17 -> 93
    //   79: aload 8
    //   81: astore 9
    //   83: iload 7
    //   85: istore_3
    //   86: aload 8
    //   88: iload 4
    //   90: invokevirtual 107	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   93: aload 5
    //   95: ifnull +207 -> 302
    //   98: aload 8
    //   100: astore 9
    //   102: iload 7
    //   104: istore_3
    //   105: aload 5
    //   107: invokevirtual 112	java/util/HashMap:isEmpty	()Z
    //   110: ifne +192 -> 302
    //   113: aload 8
    //   115: astore 9
    //   117: iload 7
    //   119: istore_3
    //   120: aload 5
    //   122: invokevirtual 116	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   125: invokeinterface 122 1 0
    //   130: astore 10
    //   132: aload 8
    //   134: astore 9
    //   136: iload 7
    //   138: istore_3
    //   139: aload 10
    //   141: invokeinterface 127 1 0
    //   146: ifeq +156 -> 302
    //   149: aload 8
    //   151: astore 9
    //   153: iload 7
    //   155: istore_3
    //   156: aload 10
    //   158: invokeinterface 131 1 0
    //   163: checkcast 133	java/util/Map$Entry
    //   166: astore 14
    //   168: aload 8
    //   170: astore 9
    //   172: iload 7
    //   174: istore_3
    //   175: aload 14
    //   177: invokeinterface 136 1 0
    //   182: checkcast 138	java/lang/String
    //   185: astore 12
    //   187: aload 8
    //   189: astore 9
    //   191: iload 7
    //   193: istore_3
    //   194: aload 14
    //   196: invokeinterface 141 1 0
    //   201: checkcast 138	java/lang/String
    //   204: astore 14
    //   206: aload 8
    //   208: astore 9
    //   210: iload 7
    //   212: istore_3
    //   213: aload 12
    //   215: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifne -86 -> 132
    //   221: aload 8
    //   223: astore 9
    //   225: iload 7
    //   227: istore_3
    //   228: aload 14
    //   230: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifne -101 -> 132
    //   236: aload 8
    //   238: astore 9
    //   240: iload 7
    //   242: istore_3
    //   243: aload 8
    //   245: aload 12
    //   247: aload 14
    //   249: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -120 -> 132
    //   255: astore 9
    //   257: aload 8
    //   259: astore 10
    //   261: aload 10
    //   263: astore 9
    //   265: aload 13
    //   267: invokevirtual 153	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   270: aload_1
    //   271: astore 8
    //   273: aload 10
    //   275: ifnull +365 -> 640
    //   278: aload 10
    //   280: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   283: goto -251 -> 32
    //   286: astore_1
    //   287: new 155	com/tencent/map/tools/net/NetResponse
    //   290: dup
    //   291: aload_1
    //   292: invokespecial 158	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   295: astore_1
    //   296: aconst_null
    //   297: astore 11
    //   299: goto -278 -> 21
    //   302: aload 8
    //   304: astore 9
    //   306: iload 7
    //   308: istore_3
    //   309: aload_2
    //   310: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +18 -> 331
    //   316: aload 8
    //   318: astore 9
    //   320: iload 7
    //   322: istore_3
    //   323: aload 8
    //   325: ldc 160
    //   327: aload_2
    //   328: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 6
    //   333: ifnull +39 -> 372
    //   336: aload 8
    //   338: astore 9
    //   340: iload 7
    //   342: istore_3
    //   343: aload 6
    //   345: aload_0
    //   346: new 6	com/tencent/map/tools/net/adapter/URLNetImpl$1
    //   349: dup
    //   350: aload_0
    //   351: aload 13
    //   353: invokespecial 163	com/tencent/map/tools/net/adapter/URLNetImpl$1:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;Lcom/tencent/map/tools/net/adapter/URLNetImpl$a;)V
    //   356: invokevirtual 169	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   359: aload 8
    //   361: astore 9
    //   363: iload 7
    //   365: istore_3
    //   366: aload_0
    //   367: aload 8
    //   369: putfield 31	com/tencent/map/tools/net/adapter/URLNetImpl:mCurrentConnect	Ljava/net/HttpURLConnection;
    //   372: aload 8
    //   374: astore 9
    //   376: iload 7
    //   378: istore_3
    //   379: aload 8
    //   381: invokevirtual 172	java/net/HttpURLConnection:connect	()V
    //   384: aload 8
    //   386: astore 9
    //   388: iload 7
    //   390: istore_3
    //   391: aload 8
    //   393: invokevirtual 176	java/net/HttpURLConnection:getResponseCode	()I
    //   396: istore 7
    //   398: aload 8
    //   400: astore 9
    //   402: iload 7
    //   404: istore_3
    //   405: new 155	com/tencent/map/tools/net/NetResponse
    //   408: dup
    //   409: invokespecial 177	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   412: astore 12
    //   414: aload 8
    //   416: astore 9
    //   418: iload 7
    //   420: istore_3
    //   421: aload 12
    //   423: iload 7
    //   425: putfield 181	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   428: aload 8
    //   430: astore 9
    //   432: iload 7
    //   434: istore_3
    //   435: aload 12
    //   437: aload 8
    //   439: invokevirtual 185	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   442: invokestatic 189	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 192	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   448: iload 7
    //   450: sipush 200
    //   453: if_icmpne +72 -> 525
    //   456: aload 8
    //   458: astore 9
    //   460: iload 7
    //   462: istore_3
    //   463: aload 12
    //   465: iconst_0
    //   466: putfield 195	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   469: aload 8
    //   471: astore 9
    //   473: iload 7
    //   475: istore_3
    //   476: aload 12
    //   478: aload 8
    //   480: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   483: invokestatic 205	com/tencent/map/tools/net/NetUtil:toBytes	(Ljava/io/InputStream;)[B
    //   486: putfield 209	com/tencent/map/tools/net/NetResponse:data	[B
    //   489: aload 8
    //   491: astore 9
    //   493: iload 7
    //   495: istore_3
    //   496: aload 13
    //   498: iconst_0
    //   499: putfield 211	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	Z
    //   502: aload 12
    //   504: astore_1
    //   505: aload 8
    //   507: astore 9
    //   509: aload_1
    //   510: astore 8
    //   512: aload 9
    //   514: ifnull +126 -> 640
    //   517: aload 9
    //   519: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   522: goto -490 -> 32
    //   525: aload 8
    //   527: astore 9
    //   529: iload 7
    //   531: istore_3
    //   532: aload 12
    //   534: aload 8
    //   536: invokevirtual 214	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   539: invokestatic 205	com/tencent/map/tools/net/NetUtil:toBytes	(Ljava/io/InputStream;)[B
    //   542: putfield 217	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   545: aload 8
    //   547: astore 9
    //   549: iload 7
    //   551: istore_3
    //   552: aload 13
    //   554: invokevirtual 153	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   557: aload 8
    //   559: astore 9
    //   561: aload 12
    //   563: astore_1
    //   564: goto -55 -> 509
    //   567: astore_1
    //   568: aload 8
    //   570: astore 10
    //   572: aload 12
    //   574: astore_1
    //   575: goto -314 -> 261
    //   578: astore 8
    //   580: aconst_null
    //   581: astore_1
    //   582: new 155	com/tencent/map/tools/net/NetResponse
    //   585: dup
    //   586: aload 8
    //   588: invokespecial 158	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   591: astore 9
    //   593: aload 9
    //   595: iload_3
    //   596: putfield 181	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   599: aload 13
    //   601: invokevirtual 153	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   604: aload 9
    //   606: astore 8
    //   608: aload_1
    //   609: ifnull +31 -> 640
    //   612: aload_1
    //   613: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   616: aload 9
    //   618: astore_1
    //   619: goto -587 -> 32
    //   622: astore_2
    //   623: aconst_null
    //   624: astore_1
    //   625: aload_1
    //   626: ifnull +7 -> 633
    //   629: aload_1
    //   630: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   633: ldc 85
    //   635: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   638: aload_2
    //   639: athrow
    //   640: aload 8
    //   642: astore_1
    //   643: goto -611 -> 32
    //   646: ldc 85
    //   648: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   651: aload_1
    //   652: areturn
    //   653: astore_2
    //   654: aload 9
    //   656: astore_1
    //   657: goto -32 -> 625
    //   660: astore_2
    //   661: goto -36 -> 625
    //   664: astore_1
    //   665: aload 8
    //   667: astore 9
    //   669: aload_1
    //   670: astore 8
    //   672: aload 9
    //   674: astore_1
    //   675: goto -93 -> 582
    //   678: astore 8
    //   680: aconst_null
    //   681: astore 10
    //   683: goto -422 -> 261
    //   686: aconst_null
    //   687: astore 9
    //   689: goto -180 -> 509
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	692	0	this	URLNetImpl
    //   0	692	1	paramString1	String
    //   0	692	2	paramString2	String
    //   0	692	3	paramInt1	int
    //   0	692	4	paramInt2	int
    //   0	692	5	paramHashMap	java.util.HashMap<String, String>
    //   0	692	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   41	509	7	i	int
    //   6	563	8	localObject1	Object
    //   578	9	8	localIOException	java.io.IOException
    //   606	65	8	localObject2	Object
    //   678	1	8	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   62	177	9	localObject3	Object
    //   255	1	9	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   263	425	9	localObject4	Object
    //   130	552	10	localObject5	Object
    //   16	282	11	localURL	java.net.URL
    //   185	388	12	localObject6	Object
    //   30	570	13	locala	a
    //   166	82	14	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   67	74	255	java/net/SocketTimeoutException
    //   86	93	255	java/net/SocketTimeoutException
    //   105	113	255	java/net/SocketTimeoutException
    //   120	132	255	java/net/SocketTimeoutException
    //   139	149	255	java/net/SocketTimeoutException
    //   156	168	255	java/net/SocketTimeoutException
    //   175	187	255	java/net/SocketTimeoutException
    //   194	206	255	java/net/SocketTimeoutException
    //   213	221	255	java/net/SocketTimeoutException
    //   228	236	255	java/net/SocketTimeoutException
    //   243	252	255	java/net/SocketTimeoutException
    //   309	316	255	java/net/SocketTimeoutException
    //   323	331	255	java/net/SocketTimeoutException
    //   343	359	255	java/net/SocketTimeoutException
    //   366	372	255	java/net/SocketTimeoutException
    //   379	384	255	java/net/SocketTimeoutException
    //   391	398	255	java/net/SocketTimeoutException
    //   405	414	255	java/net/SocketTimeoutException
    //   8	18	286	java/net/MalformedURLException
    //   421	428	567	java/net/SocketTimeoutException
    //   435	448	567	java/net/SocketTimeoutException
    //   463	469	567	java/net/SocketTimeoutException
    //   476	489	567	java/net/SocketTimeoutException
    //   496	502	567	java/net/SocketTimeoutException
    //   532	545	567	java/net/SocketTimeoutException
    //   552	557	567	java/net/SocketTimeoutException
    //   50	60	578	java/io/IOException
    //   50	60	622	finally
    //   67	74	653	finally
    //   86	93	653	finally
    //   105	113	653	finally
    //   120	132	653	finally
    //   139	149	653	finally
    //   156	168	653	finally
    //   175	187	653	finally
    //   194	206	653	finally
    //   213	221	653	finally
    //   228	236	653	finally
    //   243	252	653	finally
    //   265	270	653	finally
    //   309	316	653	finally
    //   323	331	653	finally
    //   343	359	653	finally
    //   366	372	653	finally
    //   379	384	653	finally
    //   391	398	653	finally
    //   405	414	653	finally
    //   421	428	653	finally
    //   435	448	653	finally
    //   463	469	653	finally
    //   476	489	653	finally
    //   496	502	653	finally
    //   532	545	653	finally
    //   552	557	653	finally
    //   582	604	660	finally
    //   67	74	664	java/io/IOException
    //   86	93	664	java/io/IOException
    //   105	113	664	java/io/IOException
    //   120	132	664	java/io/IOException
    //   139	149	664	java/io/IOException
    //   156	168	664	java/io/IOException
    //   175	187	664	java/io/IOException
    //   194	206	664	java/io/IOException
    //   213	221	664	java/io/IOException
    //   228	236	664	java/io/IOException
    //   243	252	664	java/io/IOException
    //   309	316	664	java/io/IOException
    //   323	331	664	java/io/IOException
    //   343	359	664	java/io/IOException
    //   366	372	664	java/io/IOException
    //   379	384	664	java/io/IOException
    //   391	398	664	java/io/IOException
    //   405	414	664	java/io/IOException
    //   421	428	664	java/io/IOException
    //   435	448	664	java/io/IOException
    //   463	469	664	java/io/IOException
    //   476	489	664	java/io/IOException
    //   496	502	664	java/io/IOException
    //   532	545	664	java/io/IOException
    //   552	557	664	java/io/IOException
    //   50	60	678	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected com.tencent.map.tools.net.NetResponse onPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 222
    //   8: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 87	java/net/URL
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aconst_null
    //   21: astore 6
    //   23: aload_1
    //   24: ifnull +371 -> 395
    //   27: aload_1
    //   28: invokevirtual 99	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   31: checkcast 68	java/net/HttpURLConnection
    //   34: astore_1
    //   35: aload_1
    //   36: ldc 224
    //   38: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: iconst_1
    //   43: invokevirtual 228	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   46: aload_2
    //   47: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +10 -> 60
    //   53: aload_1
    //   54: ldc 160
    //   56: aload_2
    //   57: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokevirtual 232	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   64: astore_2
    //   65: iload 5
    //   67: istore 4
    //   69: aload_3
    //   70: aload_2
    //   71: invokestatic 236	com/tencent/map/tools/net/NetUtil:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   74: iload 5
    //   76: istore 4
    //   78: aload_1
    //   79: invokevirtual 172	java/net/HttpURLConnection:connect	()V
    //   82: iload 5
    //   84: istore 4
    //   86: aload_1
    //   87: invokevirtual 176	java/net/HttpURLConnection:getResponseCode	()I
    //   90: istore 5
    //   92: iload 5
    //   94: istore 4
    //   96: new 155	com/tencent/map/tools/net/NetResponse
    //   99: dup
    //   100: invokespecial 177	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   103: astore_3
    //   104: iload 5
    //   106: istore 4
    //   108: aload_3
    //   109: iload 5
    //   111: putfield 181	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   114: iload 5
    //   116: istore 4
    //   118: aload_3
    //   119: aload_1
    //   120: invokevirtual 185	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   123: invokestatic 189	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   126: putfield 192	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   129: iload 5
    //   131: sipush 200
    //   134: if_icmpne +68 -> 202
    //   137: iload 5
    //   139: istore 4
    //   141: aload_3
    //   142: iconst_0
    //   143: putfield 195	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   146: iload 5
    //   148: istore 4
    //   150: aload_3
    //   151: aload_1
    //   152: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   155: invokestatic 205	com/tencent/map/tools/net/NetUtil:toBytes	(Ljava/io/InputStream;)[B
    //   158: putfield 209	com/tencent/map/tools/net/NetResponse:data	[B
    //   161: aload_3
    //   162: astore 6
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   172: aload_2
    //   173: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   176: aload 6
    //   178: astore_1
    //   179: ldc 222
    //   181: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: areturn
    //   186: astore_1
    //   187: new 155	com/tencent/map/tools/net/NetResponse
    //   190: dup
    //   191: aload_1
    //   192: invokespecial 158	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   195: astore 6
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -176 -> 23
    //   202: iload 5
    //   204: istore 4
    //   206: aload_3
    //   207: aload_1
    //   208: invokevirtual 214	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   211: invokestatic 205	com/tencent/map/tools/net/NetUtil:toBytes	(Ljava/io/InputStream;)[B
    //   214: putfield 217	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   217: aload_3
    //   218: astore 6
    //   220: goto -56 -> 164
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_1
    //   226: aconst_null
    //   227: astore_2
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   236: aload_1
    //   237: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   240: aload 6
    //   242: astore_1
    //   243: goto -64 -> 179
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_2
    //   251: new 155	com/tencent/map/tools/net/NetResponse
    //   254: dup
    //   255: aload_3
    //   256: invokespecial 158	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   259: astore_3
    //   260: aload_3
    //   261: iload 4
    //   263: putfield 181	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   274: aload_1
    //   275: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   278: aload_3
    //   279: astore_1
    //   280: goto -101 -> 179
    //   283: astore_3
    //   284: aconst_null
    //   285: astore_1
    //   286: aconst_null
    //   287: astore_2
    //   288: aload_2
    //   289: ifnull +7 -> 296
    //   292: aload_2
    //   293: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   296: aload_1
    //   297: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   300: ldc 222
    //   302: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_3
    //   306: athrow
    //   307: astore_3
    //   308: aconst_null
    //   309: astore 6
    //   311: aload_1
    //   312: astore_2
    //   313: aload 6
    //   315: astore_1
    //   316: goto -28 -> 288
    //   319: astore_3
    //   320: aload_1
    //   321: astore 6
    //   323: aload_2
    //   324: astore_1
    //   325: aload 6
    //   327: astore_2
    //   328: goto -40 -> 288
    //   331: astore_3
    //   332: goto -44 -> 288
    //   335: astore_3
    //   336: aconst_null
    //   337: astore 6
    //   339: aload_1
    //   340: astore_2
    //   341: aload 6
    //   343: astore_1
    //   344: goto -93 -> 251
    //   347: astore_3
    //   348: aload_1
    //   349: astore 6
    //   351: aload_2
    //   352: astore_1
    //   353: aload 6
    //   355: astore_2
    //   356: goto -105 -> 251
    //   359: astore_2
    //   360: aconst_null
    //   361: astore_3
    //   362: aload_1
    //   363: astore_2
    //   364: aload_3
    //   365: astore_1
    //   366: goto -138 -> 228
    //   369: astore_3
    //   370: aload_2
    //   371: astore_3
    //   372: aload_1
    //   373: astore_2
    //   374: aload_3
    //   375: astore_1
    //   376: goto -148 -> 228
    //   379: astore 6
    //   381: aload_2
    //   382: astore 7
    //   384: aload_1
    //   385: astore_2
    //   386: aload_3
    //   387: astore 6
    //   389: aload 7
    //   391: astore_1
    //   392: goto -164 -> 228
    //   395: aconst_null
    //   396: astore_2
    //   397: aconst_null
    //   398: astore_1
    //   399: goto -235 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	this	URLNetImpl
    //   0	402	1	paramString1	String
    //   0	402	2	paramString2	String
    //   0	402	3	paramArrayOfByte	byte[]
    //   4	258	4	i	int
    //   1	202	5	j	int
    //   21	333	6	localObject	Object
    //   379	1	6	localSocketTimeoutException	java.net.SocketTimeoutException
    //   387	1	6	arrayOfByte	byte[]
    //   382	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   11	20	186	java/net/MalformedURLException
    //   27	35	223	java/net/SocketTimeoutException
    //   27	35	246	java/io/IOException
    //   27	35	283	finally
    //   35	60	307	finally
    //   60	65	307	finally
    //   69	74	319	finally
    //   78	82	319	finally
    //   86	92	319	finally
    //   96	104	319	finally
    //   108	114	319	finally
    //   118	129	319	finally
    //   141	146	319	finally
    //   150	161	319	finally
    //   206	217	319	finally
    //   251	266	331	finally
    //   35	60	335	java/io/IOException
    //   60	65	335	java/io/IOException
    //   69	74	347	java/io/IOException
    //   78	82	347	java/io/IOException
    //   86	92	347	java/io/IOException
    //   96	104	347	java/io/IOException
    //   108	114	347	java/io/IOException
    //   118	129	347	java/io/IOException
    //   141	146	347	java/io/IOException
    //   150	161	347	java/io/IOException
    //   206	217	347	java/io/IOException
    //   35	60	359	java/net/SocketTimeoutException
    //   60	65	359	java/net/SocketTimeoutException
    //   69	74	369	java/net/SocketTimeoutException
    //   78	82	369	java/net/SocketTimeoutException
    //   86	92	369	java/net/SocketTimeoutException
    //   96	104	369	java/net/SocketTimeoutException
    //   108	114	379	java/net/SocketTimeoutException
    //   118	129	379	java/net/SocketTimeoutException
    //   141	146	379	java/net/SocketTimeoutException
    //   150	161	379	java/net/SocketTimeoutException
    //   206	217	379	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected com.tencent.map.tools.net.NetResponse onPostRequest(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, java.util.HashMap<String, String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler, int paramInt2)
  {
    // Byte code:
    //   0: ldc 243
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 9
    //   8: new 87	java/net/URL
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: astore 13
    //   18: aload 9
    //   20: astore_1
    //   21: new 12	com/tencent/map/tools/net/adapter/URLNetImpl$a
    //   24: dup
    //   25: aload_0
    //   26: iload 4
    //   28: invokespecial 93	com/tencent/map/tools/net/adapter/URLNetImpl$a:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;I)V
    //   31: astore 15
    //   33: aload 15
    //   35: invokevirtual 95	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	()Z
    //   38: ifeq +555 -> 593
    //   41: aconst_null
    //   42: astore 12
    //   44: aconst_null
    //   45: astore 11
    //   47: aconst_null
    //   48: astore 10
    //   50: iconst_0
    //   51: istore 4
    //   53: aload 13
    //   55: ifnull +643 -> 698
    //   58: aload 13
    //   60: invokevirtual 99	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   63: checkcast 68	java/net/HttpURLConnection
    //   66: astore 9
    //   68: aload 9
    //   70: ldc 224
    //   72: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   75: aload 9
    //   77: iconst_1
    //   78: invokevirtual 228	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   81: iload 7
    //   83: ifle +10 -> 93
    //   86: aload 9
    //   88: iload 7
    //   90: invokevirtual 107	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   93: aload 5
    //   95: ifnull +149 -> 244
    //   98: aload 5
    //   100: invokevirtual 112	java/util/HashMap:isEmpty	()Z
    //   103: ifne +141 -> 244
    //   106: aload 5
    //   108: invokevirtual 116	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   111: invokeinterface 122 1 0
    //   116: astore 11
    //   118: aload 11
    //   120: invokeinterface 127 1 0
    //   125: ifeq +119 -> 244
    //   128: aload 11
    //   130: invokeinterface 131 1 0
    //   135: checkcast 133	java/util/Map$Entry
    //   138: astore 14
    //   140: aload 14
    //   142: invokeinterface 136 1 0
    //   147: checkcast 138	java/lang/String
    //   150: astore 12
    //   152: aload 14
    //   154: invokeinterface 141 1 0
    //   159: checkcast 138	java/lang/String
    //   162: astore 14
    //   164: aload 12
    //   166: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne -51 -> 118
    //   172: aload 14
    //   174: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne -59 -> 118
    //   180: aload 9
    //   182: aload 12
    //   184: aload 14
    //   186: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -71 -> 118
    //   192: astore 10
    //   194: aconst_null
    //   195: astore 10
    //   197: aload 9
    //   199: astore 11
    //   201: aload 10
    //   203: astore 12
    //   205: aload 15
    //   207: invokevirtual 153	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   210: aload 9
    //   212: ifnull +8 -> 220
    //   215: aload 9
    //   217: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   220: aload 10
    //   222: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   225: goto -192 -> 33
    //   228: astore_1
    //   229: new 155	com/tencent/map/tools/net/NetResponse
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 158	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   237: astore_1
    //   238: aconst_null
    //   239: astore 13
    //   241: goto -220 -> 21
    //   244: aload_2
    //   245: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +11 -> 259
    //   251: aload 9
    //   253: ldc 160
    //   255: aload_2
    //   256: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 6
    //   261: ifnull +25 -> 286
    //   264: aload 6
    //   266: aload_0
    //   267: new 8	com/tencent/map/tools/net/adapter/URLNetImpl$2
    //   270: dup
    //   271: aload_0
    //   272: aload 15
    //   274: invokespecial 244	com/tencent/map/tools/net/adapter/URLNetImpl$2:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;Lcom/tencent/map/tools/net/adapter/URLNetImpl$a;)V
    //   277: invokevirtual 169	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   280: aload_0
    //   281: aload 9
    //   283: putfield 31	com/tencent/map/tools/net/adapter/URLNetImpl:mCurrentConnect	Ljava/net/HttpURLConnection;
    //   286: aload 9
    //   288: invokevirtual 232	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   291: astore 11
    //   293: aload 11
    //   295: astore 10
    //   297: aload 9
    //   299: astore 11
    //   301: aload 10
    //   303: astore 12
    //   305: aload_3
    //   306: aload 10
    //   308: invokestatic 236	com/tencent/map/tools/net/NetUtil:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   311: aload 9
    //   313: astore 11
    //   315: aload 10
    //   317: astore 12
    //   319: aload 9
    //   321: invokevirtual 172	java/net/HttpURLConnection:connect	()V
    //   324: aload 9
    //   326: astore 11
    //   328: aload 10
    //   330: astore 12
    //   332: aload 9
    //   334: invokevirtual 176	java/net/HttpURLConnection:getResponseCode	()I
    //   337: istore 8
    //   339: aload 9
    //   341: astore 11
    //   343: aload 10
    //   345: astore 12
    //   347: new 155	com/tencent/map/tools/net/NetResponse
    //   350: dup
    //   351: invokespecial 177	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   354: astore 14
    //   356: aload 9
    //   358: astore 11
    //   360: aload 10
    //   362: astore 12
    //   364: aload 14
    //   366: iload 8
    //   368: putfield 181	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   371: aload 9
    //   373: astore 11
    //   375: aload 10
    //   377: astore 12
    //   379: aload 14
    //   381: aload 9
    //   383: invokevirtual 185	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   386: invokestatic 189	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   389: putfield 192	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   392: iload 8
    //   394: sipush 200
    //   397: if_icmpne +73 -> 470
    //   400: aload 9
    //   402: astore 11
    //   404: aload 10
    //   406: astore 12
    //   408: aload 14
    //   410: iconst_0
    //   411: putfield 195	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   414: aload 9
    //   416: astore 11
    //   418: aload 10
    //   420: astore 12
    //   422: aload 14
    //   424: aload 9
    //   426: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   429: invokestatic 205	com/tencent/map/tools/net/NetUtil:toBytes	(Ljava/io/InputStream;)[B
    //   432: putfield 209	com/tencent/map/tools/net/NetResponse:data	[B
    //   435: aload 9
    //   437: astore 11
    //   439: aload 10
    //   441: astore 12
    //   443: aload 15
    //   445: iconst_0
    //   446: putfield 211	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	Z
    //   449: aload 14
    //   451: astore_1
    //   452: aload 9
    //   454: ifnull +8 -> 462
    //   457: aload 9
    //   459: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   462: aload 10
    //   464: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   467: goto -434 -> 33
    //   470: aload 9
    //   472: astore 11
    //   474: aload 10
    //   476: astore 12
    //   478: aload 14
    //   480: aload 9
    //   482: invokevirtual 214	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   485: invokestatic 205	com/tencent/map/tools/net/NetUtil:toBytes	(Ljava/io/InputStream;)[B
    //   488: putfield 217	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   491: aload 9
    //   493: astore 11
    //   495: aload 10
    //   497: astore 12
    //   499: aload 15
    //   501: invokevirtual 153	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   504: aload 14
    //   506: astore_1
    //   507: goto -55 -> 452
    //   510: astore_1
    //   511: aload 14
    //   513: astore_1
    //   514: goto -317 -> 197
    //   517: astore 10
    //   519: aconst_null
    //   520: astore 9
    //   522: aload 11
    //   524: astore_1
    //   525: new 155	com/tencent/map/tools/net/NetResponse
    //   528: dup
    //   529: aload 10
    //   531: invokespecial 158	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   534: astore 10
    //   536: aload 10
    //   538: iload 4
    //   540: putfield 181	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   543: aload 15
    //   545: invokevirtual 153	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   548: aload_1
    //   549: ifnull +7 -> 556
    //   552: aload_1
    //   553: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   556: aload 9
    //   558: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   561: aload 10
    //   563: astore_1
    //   564: goto -531 -> 33
    //   567: astore_2
    //   568: aload 12
    //   570: astore_1
    //   571: aload 10
    //   573: astore_3
    //   574: aload_1
    //   575: ifnull +7 -> 582
    //   578: aload_1
    //   579: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   582: aload_3
    //   583: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   586: ldc 243
    //   588: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: aload_2
    //   592: athrow
    //   593: ldc 243
    //   595: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   598: aload_1
    //   599: areturn
    //   600: astore_2
    //   601: aload 9
    //   603: astore_1
    //   604: aload 10
    //   606: astore_3
    //   607: goto -33 -> 574
    //   610: astore_2
    //   611: aload 12
    //   613: astore_3
    //   614: aload 11
    //   616: astore_1
    //   617: goto -43 -> 574
    //   620: astore_2
    //   621: aload 9
    //   623: astore_3
    //   624: goto -50 -> 574
    //   627: astore 10
    //   629: aconst_null
    //   630: astore 11
    //   632: aload 9
    //   634: astore_1
    //   635: aload 11
    //   637: astore 9
    //   639: goto -114 -> 525
    //   642: astore_1
    //   643: aload 10
    //   645: astore 11
    //   647: aload_1
    //   648: astore 10
    //   650: aload 9
    //   652: astore_1
    //   653: aload 11
    //   655: astore 9
    //   657: goto -132 -> 525
    //   660: astore_1
    //   661: iload 8
    //   663: istore 4
    //   665: aload 10
    //   667: astore 11
    //   669: aload_1
    //   670: astore 10
    //   672: aload 9
    //   674: astore_1
    //   675: aload 11
    //   677: astore 9
    //   679: goto -154 -> 525
    //   682: astore 9
    //   684: aconst_null
    //   685: astore 10
    //   687: aconst_null
    //   688: astore 9
    //   690: goto -493 -> 197
    //   693: astore 11
    //   695: goto -498 -> 197
    //   698: aconst_null
    //   699: astore 10
    //   701: aconst_null
    //   702: astore 9
    //   704: goto -252 -> 452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	URLNetImpl
    //   0	707	1	paramString1	String
    //   0	707	2	paramString2	String
    //   0	707	3	paramArrayOfByte	byte[]
    //   0	707	4	paramInt1	int
    //   0	707	5	paramHashMap	java.util.HashMap<String, String>
    //   0	707	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   0	707	7	paramInt2	int
    //   337	325	8	i	int
    //   6	672	9	localObject1	Object
    //   682	1	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   688	15	9	localObject2	Object
    //   48	1	10	localObject3	Object
    //   192	1	10	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   195	301	10	localObject4	Object
    //   517	13	10	localIOException1	java.io.IOException
    //   534	71	10	localNetResponse	com.tencent.map.tools.net.NetResponse
    //   627	17	10	localIOException2	java.io.IOException
    //   648	52	10	str	String
    //   45	631	11	localObject5	Object
    //   693	1	11	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   42	570	12	localObject6	Object
    //   16	224	13	localURL	java.net.URL
    //   138	374	14	localObject7	Object
    //   31	513	15	locala	a
    // Exception table:
    //   from	to	target	type
    //   68	81	192	java/net/SocketTimeoutException
    //   86	93	192	java/net/SocketTimeoutException
    //   98	118	192	java/net/SocketTimeoutException
    //   118	189	192	java/net/SocketTimeoutException
    //   244	259	192	java/net/SocketTimeoutException
    //   264	286	192	java/net/SocketTimeoutException
    //   286	293	192	java/net/SocketTimeoutException
    //   8	18	228	java/net/MalformedURLException
    //   364	371	510	java/net/SocketTimeoutException
    //   379	392	510	java/net/SocketTimeoutException
    //   408	414	510	java/net/SocketTimeoutException
    //   422	435	510	java/net/SocketTimeoutException
    //   443	449	510	java/net/SocketTimeoutException
    //   478	491	510	java/net/SocketTimeoutException
    //   499	504	510	java/net/SocketTimeoutException
    //   58	68	517	java/io/IOException
    //   58	68	567	finally
    //   68	81	600	finally
    //   86	93	600	finally
    //   98	118	600	finally
    //   118	189	600	finally
    //   244	259	600	finally
    //   264	286	600	finally
    //   286	293	600	finally
    //   205	210	610	finally
    //   305	311	610	finally
    //   319	324	610	finally
    //   332	339	610	finally
    //   347	356	610	finally
    //   364	371	610	finally
    //   379	392	610	finally
    //   408	414	610	finally
    //   422	435	610	finally
    //   443	449	610	finally
    //   478	491	610	finally
    //   499	504	610	finally
    //   525	548	620	finally
    //   68	81	627	java/io/IOException
    //   86	93	627	java/io/IOException
    //   98	118	627	java/io/IOException
    //   118	189	627	java/io/IOException
    //   244	259	627	java/io/IOException
    //   264	286	627	java/io/IOException
    //   286	293	627	java/io/IOException
    //   305	311	642	java/io/IOException
    //   319	324	642	java/io/IOException
    //   332	339	642	java/io/IOException
    //   347	356	660	java/io/IOException
    //   364	371	660	java/io/IOException
    //   379	392	660	java/io/IOException
    //   408	414	660	java/io/IOException
    //   422	435	660	java/io/IOException
    //   443	449	660	java/io/IOException
    //   478	491	660	java/io/IOException
    //   499	504	660	java/io/IOException
    //   58	68	682	java/net/SocketTimeoutException
    //   305	311	693	java/net/SocketTimeoutException
    //   319	324	693	java/net/SocketTimeoutException
    //   332	339	693	java/net/SocketTimeoutException
    //   347	356	693	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected void onRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
  {
    // Byte code:
    //   0: ldc 248
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 87	java/net/URL
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +355 -> 370
    //   18: aload_1
    //   19: invokevirtual 99	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 68	java/net/HttpURLConnection
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 224
    //   29: invokevirtual 104	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: iconst_1
    //   34: invokevirtual 228	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   37: aload_1
    //   38: ldc 160
    //   40: ldc 250
    //   42: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: ldc 252
    //   48: aload_3
    //   49: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc 254
    //   55: aload 4
    //   57: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: ldc_w 256
    //   64: aload 5
    //   66: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: ldc_w 258
    //   73: new 260	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 262
    //   80: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload 6
    //   85: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 269
    //   91: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokevirtual 150	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 7
    //   102: ifnull +22 -> 124
    //   105: aload 7
    //   107: aload_0
    //   108: new 10	com/tencent/map/tools/net/adapter/URLNetImpl$3
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 275	com/tencent/map/tools/net/adapter/URLNetImpl$3:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;)V
    //   116: invokevirtual 169	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   119: aload_0
    //   120: aload_1
    //   121: putfield 31	com/tencent/map/tools/net/adapter/URLNetImpl:mCurrentConnect	Ljava/net/HttpURLConnection;
    //   124: aload_1
    //   125: invokevirtual 232	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   128: astore_3
    //   129: aload_2
    //   130: aload_3
    //   131: invokestatic 236	com/tencent/map/tools/net/NetUtil:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   134: aload_1
    //   135: invokevirtual 172	java/net/HttpURLConnection:connect	()V
    //   138: aload_1
    //   139: invokevirtual 176	java/net/HttpURLConnection:getResponseCode	()I
    //   142: istore 8
    //   144: aload_1
    //   145: invokevirtual 185	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   148: invokestatic 189	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   151: pop
    //   152: iload 8
    //   154: sipush 200
    //   157: if_icmpne +117 -> 274
    //   160: aload_1
    //   161: ldc_w 277
    //   164: invokevirtual 280	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore_2
    //   168: aload_2
    //   169: invokestatic 50	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   172: istore 8
    //   174: iload 8
    //   176: ifeq +98 -> 274
    //   179: iload 8
    //   181: bipush 254
    //   183: if_icmpne +45 -> 228
    //   186: new 282	com/tencent/map/tools/net/exception/FileUploadResetException
    //   189: dup
    //   190: invokespecial 283	com/tencent/map/tools/net/exception/FileUploadResetException:<init>	()V
    //   193: astore_2
    //   194: ldc 248
    //   196: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_2
    //   200: athrow
    //   201: astore_2
    //   202: aload_3
    //   203: astore_2
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   212: aload_2
    //   213: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   216: ldc 248
    //   218: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: astore_1
    //   223: aconst_null
    //   224: astore_1
    //   225: goto -211 -> 14
    //   228: new 285	java/lang/Exception
    //   231: dup
    //   232: ldc_w 287
    //   235: aload_2
    //   236: invokestatic 291	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   239: invokevirtual 294	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   242: invokespecial 295	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   245: astore_2
    //   246: ldc 248
    //   248: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: aload_2
    //   252: athrow
    //   253: astore_2
    //   254: aload_3
    //   255: astore_2
    //   256: aload_1
    //   257: ifnull +7 -> 264
    //   260: aload_1
    //   261: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   264: aload_2
    //   265: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   268: ldc 248
    //   270: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: return
    //   274: aload_3
    //   275: astore_2
    //   276: aload_1
    //   277: ifnull +7 -> 284
    //   280: aload_1
    //   281: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   284: aload_2
    //   285: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   288: ldc 248
    //   290: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: return
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aconst_null
    //   298: astore_3
    //   299: aload_3
    //   300: ifnull +7 -> 307
    //   303: aload_3
    //   304: invokevirtual 71	java/net/HttpURLConnection:disconnect	()V
    //   307: aload_2
    //   308: invokestatic 240	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   311: ldc 248
    //   313: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_1
    //   317: athrow
    //   318: astore 4
    //   320: aconst_null
    //   321: astore_2
    //   322: aload_1
    //   323: astore_3
    //   324: aload 4
    //   326: astore_1
    //   327: goto -28 -> 299
    //   330: astore 4
    //   332: aload_3
    //   333: astore_2
    //   334: aload_1
    //   335: astore_3
    //   336: aload 4
    //   338: astore_1
    //   339: goto -40 -> 299
    //   342: astore_1
    //   343: aconst_null
    //   344: astore_2
    //   345: aconst_null
    //   346: astore_1
    //   347: goto -91 -> 256
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_2
    //   353: goto -97 -> 256
    //   356: astore_1
    //   357: aconst_null
    //   358: astore_2
    //   359: aconst_null
    //   360: astore_1
    //   361: goto -157 -> 204
    //   364: astore_2
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -163 -> 204
    //   370: aconst_null
    //   371: astore_2
    //   372: aconst_null
    //   373: astore_1
    //   374: goto -98 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	URLNetImpl
    //   0	377	1	paramString1	String
    //   0	377	2	paramArrayOfByte	byte[]
    //   0	377	3	paramString2	String
    //   0	377	4	paramString3	String
    //   0	377	5	paramString4	String
    //   0	377	6	paramString5	String
    //   0	377	7	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   142	42	8	i	int
    // Exception table:
    //   from	to	target	type
    //   129	152	201	java/net/SocketTimeoutException
    //   160	174	201	java/net/SocketTimeoutException
    //   186	201	201	java/net/SocketTimeoutException
    //   228	253	201	java/net/SocketTimeoutException
    //   5	14	222	java/net/MalformedURLException
    //   129	152	253	java/io/IOException
    //   160	174	253	java/io/IOException
    //   186	201	253	java/io/IOException
    //   228	253	253	java/io/IOException
    //   18	26	294	finally
    //   26	100	318	finally
    //   105	124	318	finally
    //   124	129	318	finally
    //   129	152	330	finally
    //   160	174	330	finally
    //   186	201	330	finally
    //   228	253	330	finally
    //   18	26	342	java/io/IOException
    //   26	100	350	java/io/IOException
    //   105	124	350	java/io/IOException
    //   124	129	350	java/io/IOException
    //   18	26	356	java/net/SocketTimeoutException
    //   26	100	364	java/net/SocketTimeoutException
    //   105	124	364	java/net/SocketTimeoutException
    //   124	129	364	java/net/SocketTimeoutException
  }
  
  final class a
  {
    boolean a;
    private int c;
    
    a(int paramInt)
    {
      AppMethodBeat.i(180927);
      this.a = true;
      this.c = paramInt;
      if (this.c > 3) {
        this.c = 3;
      }
      if (this.c <= 0) {
        this.c = 1;
      }
      AppMethodBeat.o(180927);
    }
    
    final boolean a()
    {
      return (this.a) && (this.c > 0);
    }
    
    final void b()
    {
      this.c -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.adapter.URLNetImpl
 * JD-Core Version:    0.7.0.1
 */