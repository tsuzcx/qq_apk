package com.tencent.map.tools.net.adapter;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.map.tools.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class URLNetImpl
  extends AbsNetImpl
{
  private static final int BUF_SIZE = 4096;
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
  
  public static final void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(180935);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(180935);
        return;
      }
      catch (IOException paramCloseable) {}
    }
    AppMethodBeat.o(180935);
  }
  
  /* Error */
  public static byte[] toBytes(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 81
    //   11: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: new 83	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 84	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: sipush 4096
    //   27: newarray byte
    //   29: astore_3
    //   30: aload_0
    //   31: aload_3
    //   32: iconst_0
    //   33: sipush 4096
    //   36: invokevirtual 90	java/io/InputStream:read	([BII)I
    //   39: istore_1
    //   40: iload_1
    //   41: iconst_m1
    //   42: if_icmpeq +25 -> 67
    //   45: aload_2
    //   46: aload_3
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 94	java/io/ByteArrayOutputStream:write	([BII)V
    //   52: goto -22 -> 30
    //   55: astore_0
    //   56: aload_2
    //   57: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   60: ldc 81
    //   62: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload_2
    //   68: invokevirtual 99	java/io/ByteArrayOutputStream:flush	()V
    //   71: aload_2
    //   72: invokevirtual 103	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   80: ldc 81
    //   82: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   94: ldc 81
    //   96: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: goto -12 -> 90
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_2
    //   108: goto -52 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramInputStream	java.io.InputStream
    //   39	10	1	i	int
    //   23	85	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   29	18	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	30	55	java/lang/Throwable
    //   30	40	55	java/lang/Throwable
    //   45	52	55	java/lang/Throwable
    //   67	76	55	java/lang/Throwable
    //   16	24	87	finally
    //   24	30	101	finally
    //   30	40	101	finally
    //   45	52	101	finally
    //   67	76	101	finally
    //   16	24	105	java/lang/Throwable
  }
  
  public static void writeBytesWithoutClose(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(180937);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramOutputStream == null))
    {
      AppMethodBeat.o(180937);
      return;
    }
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      AppMethodBeat.o(180937);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      AppMethodBeat.o(180937);
    }
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
    //   0: ldc 131
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 8
    //   8: new 133	java/net/URL
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: astore 11
    //   18: aload 8
    //   20: astore_1
    //   21: new 12	com/tencent/map/tools/net/adapter/URLNetImpl$a
    //   24: dup
    //   25: aload_0
    //   26: iload_3
    //   27: invokespecial 139	com/tencent/map/tools/net/adapter/URLNetImpl$a:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;I)V
    //   30: astore 13
    //   32: aload 13
    //   34: invokevirtual 141	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	()Z
    //   37: ifeq +609 -> 646
    //   40: iconst_0
    //   41: istore 7
    //   43: iconst_0
    //   44: istore_3
    //   45: aload 11
    //   47: ifnull +639 -> 686
    //   50: aload 11
    //   52: invokevirtual 145	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   55: checkcast 116	java/net/HttpURLConnection
    //   58: astore 8
    //   60: aload 8
    //   62: astore 9
    //   64: iload 7
    //   66: istore_3
    //   67: aload 8
    //   69: ldc 147
    //   71: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   74: iload 4
    //   76: ifle +17 -> 93
    //   79: aload 8
    //   81: astore 9
    //   83: iload 7
    //   85: istore_3
    //   86: aload 8
    //   88: iload 4
    //   90: invokevirtual 153	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   93: aload 5
    //   95: ifnull +207 -> 302
    //   98: aload 8
    //   100: astore 9
    //   102: iload 7
    //   104: istore_3
    //   105: aload 5
    //   107: invokevirtual 158	java/util/HashMap:isEmpty	()Z
    //   110: ifne +192 -> 302
    //   113: aload 8
    //   115: astore 9
    //   117: iload 7
    //   119: istore_3
    //   120: aload 5
    //   122: invokevirtual 162	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   125: invokeinterface 168 1 0
    //   130: astore 10
    //   132: aload 8
    //   134: astore 9
    //   136: iload 7
    //   138: istore_3
    //   139: aload 10
    //   141: invokeinterface 173 1 0
    //   146: ifeq +156 -> 302
    //   149: aload 8
    //   151: astore 9
    //   153: iload 7
    //   155: istore_3
    //   156: aload 10
    //   158: invokeinterface 177 1 0
    //   163: checkcast 179	java/util/Map$Entry
    //   166: astore 14
    //   168: aload 8
    //   170: astore 9
    //   172: iload 7
    //   174: istore_3
    //   175: aload 14
    //   177: invokeinterface 182 1 0
    //   182: checkcast 184	java/lang/String
    //   185: astore 12
    //   187: aload 8
    //   189: astore 9
    //   191: iload 7
    //   193: istore_3
    //   194: aload 14
    //   196: invokeinterface 187 1 0
    //   201: checkcast 184	java/lang/String
    //   204: astore 14
    //   206: aload 8
    //   208: astore 9
    //   210: iload 7
    //   212: istore_3
    //   213: aload 12
    //   215: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifne -86 -> 132
    //   221: aload 8
    //   223: astore 9
    //   225: iload 7
    //   227: istore_3
    //   228: aload 14
    //   230: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifne -101 -> 132
    //   236: aload 8
    //   238: astore 9
    //   240: iload 7
    //   242: istore_3
    //   243: aload 8
    //   245: aload 12
    //   247: aload 14
    //   249: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -120 -> 132
    //   255: astore 9
    //   257: aload 8
    //   259: astore 10
    //   261: aload 10
    //   263: astore 9
    //   265: aload 13
    //   267: invokevirtual 199	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   270: aload_1
    //   271: astore 8
    //   273: aload 10
    //   275: ifnull +365 -> 640
    //   278: aload 10
    //   280: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   283: goto -251 -> 32
    //   286: astore_1
    //   287: new 201	com/tencent/map/tools/net/NetResponse
    //   290: dup
    //   291: aload_1
    //   292: invokespecial 204	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   295: astore_1
    //   296: aconst_null
    //   297: astore 11
    //   299: goto -278 -> 21
    //   302: aload 8
    //   304: astore 9
    //   306: iload 7
    //   308: istore_3
    //   309: aload_2
    //   310: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +18 -> 331
    //   316: aload 8
    //   318: astore 9
    //   320: iload 7
    //   322: istore_3
    //   323: aload 8
    //   325: ldc 206
    //   327: aload_2
    //   328: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   353: invokespecial 209	com/tencent/map/tools/net/adapter/URLNetImpl$1:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;Lcom/tencent/map/tools/net/adapter/URLNetImpl$a;)V
    //   356: invokevirtual 215	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   359: aload 8
    //   361: astore 9
    //   363: iload 7
    //   365: istore_3
    //   366: aload_0
    //   367: aload 8
    //   369: putfield 34	com/tencent/map/tools/net/adapter/URLNetImpl:mCurrentConnect	Ljava/net/HttpURLConnection;
    //   372: aload 8
    //   374: astore 9
    //   376: iload 7
    //   378: istore_3
    //   379: aload 8
    //   381: invokevirtual 218	java/net/HttpURLConnection:connect	()V
    //   384: aload 8
    //   386: astore 9
    //   388: iload 7
    //   390: istore_3
    //   391: aload 8
    //   393: invokevirtual 222	java/net/HttpURLConnection:getResponseCode	()I
    //   396: istore 7
    //   398: aload 8
    //   400: astore 9
    //   402: iload 7
    //   404: istore_3
    //   405: new 201	com/tencent/map/tools/net/NetResponse
    //   408: dup
    //   409: invokespecial 223	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   412: astore 12
    //   414: aload 8
    //   416: astore 9
    //   418: iload 7
    //   420: istore_3
    //   421: aload 12
    //   423: iload 7
    //   425: putfield 226	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   428: aload 8
    //   430: astore 9
    //   432: iload 7
    //   434: istore_3
    //   435: aload 12
    //   437: aload 8
    //   439: invokevirtual 230	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   442: invokestatic 234	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 237	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   448: iload 7
    //   450: sipush 200
    //   453: if_icmpne +72 -> 525
    //   456: aload 8
    //   458: astore 9
    //   460: iload 7
    //   462: istore_3
    //   463: aload 12
    //   465: iconst_0
    //   466: putfield 240	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   469: aload 8
    //   471: astore 9
    //   473: iload 7
    //   475: istore_3
    //   476: aload 12
    //   478: aload 8
    //   480: invokevirtual 244	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   483: invokestatic 246	com/tencent/map/tools/net/adapter/URLNetImpl:toBytes	(Ljava/io/InputStream;)[B
    //   486: putfield 250	com/tencent/map/tools/net/NetResponse:data	[B
    //   489: aload 8
    //   491: astore 9
    //   493: iload 7
    //   495: istore_3
    //   496: aload 13
    //   498: iconst_0
    //   499: putfield 252	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	Z
    //   502: aload 12
    //   504: astore_1
    //   505: aload 8
    //   507: astore 9
    //   509: aload_1
    //   510: astore 8
    //   512: aload 9
    //   514: ifnull +126 -> 640
    //   517: aload 9
    //   519: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   522: goto -490 -> 32
    //   525: aload 8
    //   527: astore 9
    //   529: iload 7
    //   531: istore_3
    //   532: aload 12
    //   534: aload 8
    //   536: invokevirtual 255	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   539: invokestatic 246	com/tencent/map/tools/net/adapter/URLNetImpl:toBytes	(Ljava/io/InputStream;)[B
    //   542: putfield 258	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   545: aload 8
    //   547: astore 9
    //   549: iload 7
    //   551: istore_3
    //   552: aload 13
    //   554: invokevirtual 199	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
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
    //   582: new 201	com/tencent/map/tools/net/NetResponse
    //   585: dup
    //   586: aload 8
    //   588: invokespecial 204	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   591: astore 9
    //   593: aload 9
    //   595: iload_3
    //   596: putfield 226	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   599: aload 13
    //   601: invokevirtual 199	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   604: aload 9
    //   606: astore 8
    //   608: aload_1
    //   609: ifnull +31 -> 640
    //   612: aload_1
    //   613: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   616: aload 9
    //   618: astore_1
    //   619: goto -587 -> 32
    //   622: astore_2
    //   623: aconst_null
    //   624: astore_1
    //   625: aload_1
    //   626: ifnull +7 -> 633
    //   629: aload_1
    //   630: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   633: ldc 131
    //   635: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   638: aload_2
    //   639: athrow
    //   640: aload 8
    //   642: astore_1
    //   643: goto -611 -> 32
    //   646: ldc 131
    //   648: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   578	9	8	localIOException	IOException
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
    //   6: ldc_w 263
    //   9: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: new 133	java/net/URL
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aconst_null
    //   22: astore 6
    //   24: aload_1
    //   25: ifnull +374 -> 399
    //   28: aload_1
    //   29: invokevirtual 145	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   32: checkcast 116	java/net/HttpURLConnection
    //   35: astore_1
    //   36: aload_1
    //   37: ldc_w 265
    //   40: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: iconst_1
    //   45: invokevirtual 269	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   48: aload_2
    //   49: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifne +10 -> 62
    //   55: aload_1
    //   56: ldc 206
    //   58: aload_2
    //   59: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_1
    //   63: invokevirtual 273	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   66: astore_2
    //   67: iload 5
    //   69: istore 4
    //   71: aload_3
    //   72: aload_2
    //   73: invokestatic 275	com/tencent/map/tools/net/adapter/URLNetImpl:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   76: iload 5
    //   78: istore 4
    //   80: aload_1
    //   81: invokevirtual 218	java/net/HttpURLConnection:connect	()V
    //   84: iload 5
    //   86: istore 4
    //   88: aload_1
    //   89: invokevirtual 222	java/net/HttpURLConnection:getResponseCode	()I
    //   92: istore 5
    //   94: iload 5
    //   96: istore 4
    //   98: new 201	com/tencent/map/tools/net/NetResponse
    //   101: dup
    //   102: invokespecial 223	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   105: astore_3
    //   106: iload 5
    //   108: istore 4
    //   110: aload_3
    //   111: iload 5
    //   113: putfield 226	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   116: iload 5
    //   118: istore 4
    //   120: aload_3
    //   121: aload_1
    //   122: invokevirtual 230	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   125: invokestatic 234	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   128: putfield 237	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   131: iload 5
    //   133: sipush 200
    //   136: if_icmpne +69 -> 205
    //   139: iload 5
    //   141: istore 4
    //   143: aload_3
    //   144: iconst_0
    //   145: putfield 240	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   148: iload 5
    //   150: istore 4
    //   152: aload_3
    //   153: aload_1
    //   154: invokevirtual 244	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   157: invokestatic 246	com/tencent/map/tools/net/adapter/URLNetImpl:toBytes	(Ljava/io/InputStream;)[B
    //   160: putfield 250	com/tencent/map/tools/net/NetResponse:data	[B
    //   163: aload_3
    //   164: astore 6
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   174: aload_2
    //   175: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   178: aload 6
    //   180: astore_1
    //   181: ldc_w 263
    //   184: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_1
    //   188: areturn
    //   189: astore_1
    //   190: new 201	com/tencent/map/tools/net/NetResponse
    //   193: dup
    //   194: aload_1
    //   195: invokespecial 204	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   198: astore 6
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -178 -> 24
    //   205: iload 5
    //   207: istore 4
    //   209: aload_3
    //   210: aload_1
    //   211: invokevirtual 255	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   214: invokestatic 246	com/tencent/map/tools/net/adapter/URLNetImpl:toBytes	(Ljava/io/InputStream;)[B
    //   217: putfield 258	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   220: aload_3
    //   221: astore 6
    //   223: goto -57 -> 166
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   239: aload_1
    //   240: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   243: aload 6
    //   245: astore_1
    //   246: goto -65 -> 181
    //   249: astore_3
    //   250: aconst_null
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_2
    //   254: new 201	com/tencent/map/tools/net/NetResponse
    //   257: dup
    //   258: aload_3
    //   259: invokespecial 204	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   262: astore_3
    //   263: aload_3
    //   264: iload 4
    //   266: putfield 226	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   277: aload_1
    //   278: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   281: aload_3
    //   282: astore_1
    //   283: goto -102 -> 181
    //   286: astore_3
    //   287: aconst_null
    //   288: astore_1
    //   289: aconst_null
    //   290: astore_2
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_1
    //   300: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   303: ldc_w 263
    //   306: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_3
    //   310: athrow
    //   311: astore_3
    //   312: aconst_null
    //   313: astore 6
    //   315: aload_1
    //   316: astore_2
    //   317: aload 6
    //   319: astore_1
    //   320: goto -29 -> 291
    //   323: astore_3
    //   324: aload_1
    //   325: astore 6
    //   327: aload_2
    //   328: astore_1
    //   329: aload 6
    //   331: astore_2
    //   332: goto -41 -> 291
    //   335: astore_3
    //   336: goto -45 -> 291
    //   339: astore_3
    //   340: aconst_null
    //   341: astore 6
    //   343: aload_1
    //   344: astore_2
    //   345: aload 6
    //   347: astore_1
    //   348: goto -94 -> 254
    //   351: astore_3
    //   352: aload_1
    //   353: astore 6
    //   355: aload_2
    //   356: astore_1
    //   357: aload 6
    //   359: astore_2
    //   360: goto -106 -> 254
    //   363: astore_2
    //   364: aconst_null
    //   365: astore_3
    //   366: aload_1
    //   367: astore_2
    //   368: aload_3
    //   369: astore_1
    //   370: goto -139 -> 231
    //   373: astore_3
    //   374: aload_2
    //   375: astore_3
    //   376: aload_1
    //   377: astore_2
    //   378: aload_3
    //   379: astore_1
    //   380: goto -149 -> 231
    //   383: astore 6
    //   385: aload_2
    //   386: astore 7
    //   388: aload_1
    //   389: astore_2
    //   390: aload_3
    //   391: astore 6
    //   393: aload 7
    //   395: astore_1
    //   396: goto -165 -> 231
    //   399: aconst_null
    //   400: astore_2
    //   401: aconst_null
    //   402: astore_1
    //   403: goto -237 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	URLNetImpl
    //   0	406	1	paramString1	String
    //   0	406	2	paramString2	String
    //   0	406	3	paramArrayOfByte	byte[]
    //   4	261	4	i	int
    //   1	205	5	j	int
    //   22	336	6	localObject	Object
    //   383	1	6	localSocketTimeoutException	java.net.SocketTimeoutException
    //   391	1	6	arrayOfByte	byte[]
    //   386	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   12	21	189	java/net/MalformedURLException
    //   28	36	226	java/net/SocketTimeoutException
    //   28	36	249	java/io/IOException
    //   28	36	286	finally
    //   36	62	311	finally
    //   62	67	311	finally
    //   71	76	323	finally
    //   80	84	323	finally
    //   88	94	323	finally
    //   98	106	323	finally
    //   110	116	323	finally
    //   120	131	323	finally
    //   143	148	323	finally
    //   152	163	323	finally
    //   209	220	323	finally
    //   254	269	335	finally
    //   36	62	339	java/io/IOException
    //   62	67	339	java/io/IOException
    //   71	76	351	java/io/IOException
    //   80	84	351	java/io/IOException
    //   88	94	351	java/io/IOException
    //   98	106	351	java/io/IOException
    //   110	116	351	java/io/IOException
    //   120	131	351	java/io/IOException
    //   143	148	351	java/io/IOException
    //   152	163	351	java/io/IOException
    //   209	220	351	java/io/IOException
    //   36	62	363	java/net/SocketTimeoutException
    //   62	67	363	java/net/SocketTimeoutException
    //   71	76	373	java/net/SocketTimeoutException
    //   80	84	373	java/net/SocketTimeoutException
    //   88	94	373	java/net/SocketTimeoutException
    //   98	106	373	java/net/SocketTimeoutException
    //   110	116	383	java/net/SocketTimeoutException
    //   120	131	383	java/net/SocketTimeoutException
    //   143	148	383	java/net/SocketTimeoutException
    //   152	163	383	java/net/SocketTimeoutException
    //   209	220	383	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected com.tencent.map.tools.net.NetResponse onPostRequest(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, java.util.HashMap<String, String> paramHashMap, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 278
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 9
    //   9: new 133	java/net/URL
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: astore 13
    //   19: aload 9
    //   21: astore_1
    //   22: new 12	com/tencent/map/tools/net/adapter/URLNetImpl$a
    //   25: dup
    //   26: aload_0
    //   27: iload 4
    //   29: invokespecial 139	com/tencent/map/tools/net/adapter/URLNetImpl$a:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;I)V
    //   32: astore 15
    //   34: aload 15
    //   36: invokevirtual 141	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	()Z
    //   39: ifeq +557 -> 596
    //   42: aconst_null
    //   43: astore 12
    //   45: aconst_null
    //   46: astore 11
    //   48: aconst_null
    //   49: astore 10
    //   51: iconst_0
    //   52: istore 4
    //   54: aload 13
    //   56: ifnull +646 -> 702
    //   59: aload 13
    //   61: invokevirtual 145	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   64: checkcast 116	java/net/HttpURLConnection
    //   67: astore 9
    //   69: aload 9
    //   71: ldc_w 265
    //   74: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   77: aload 9
    //   79: iconst_1
    //   80: invokevirtual 269	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   83: iload 7
    //   85: ifle +10 -> 95
    //   88: aload 9
    //   90: iload 7
    //   92: invokevirtual 153	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   95: aload 5
    //   97: ifnull +149 -> 246
    //   100: aload 5
    //   102: invokevirtual 158	java/util/HashMap:isEmpty	()Z
    //   105: ifne +141 -> 246
    //   108: aload 5
    //   110: invokevirtual 162	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   113: invokeinterface 168 1 0
    //   118: astore 11
    //   120: aload 11
    //   122: invokeinterface 173 1 0
    //   127: ifeq +119 -> 246
    //   130: aload 11
    //   132: invokeinterface 177 1 0
    //   137: checkcast 179	java/util/Map$Entry
    //   140: astore 14
    //   142: aload 14
    //   144: invokeinterface 182 1 0
    //   149: checkcast 184	java/lang/String
    //   152: astore 12
    //   154: aload 14
    //   156: invokeinterface 187 1 0
    //   161: checkcast 184	java/lang/String
    //   164: astore 14
    //   166: aload 12
    //   168: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   171: ifne -51 -> 120
    //   174: aload 14
    //   176: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne -59 -> 120
    //   182: aload 9
    //   184: aload 12
    //   186: aload 14
    //   188: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto -71 -> 120
    //   194: astore 10
    //   196: aconst_null
    //   197: astore 10
    //   199: aload 9
    //   201: astore 11
    //   203: aload 10
    //   205: astore 12
    //   207: aload 15
    //   209: invokevirtual 199	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   212: aload 9
    //   214: ifnull +8 -> 222
    //   217: aload 9
    //   219: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   222: aload 10
    //   224: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   227: goto -193 -> 34
    //   230: astore_1
    //   231: new 201	com/tencent/map/tools/net/NetResponse
    //   234: dup
    //   235: aload_1
    //   236: invokespecial 204	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   239: astore_1
    //   240: aconst_null
    //   241: astore 13
    //   243: goto -221 -> 22
    //   246: aload_2
    //   247: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifne +11 -> 261
    //   253: aload 9
    //   255: ldc 206
    //   257: aload_2
    //   258: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 6
    //   263: ifnull +25 -> 288
    //   266: aload 6
    //   268: aload_0
    //   269: new 8	com/tencent/map/tools/net/adapter/URLNetImpl$2
    //   272: dup
    //   273: aload_0
    //   274: aload 15
    //   276: invokespecial 279	com/tencent/map/tools/net/adapter/URLNetImpl$2:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;Lcom/tencent/map/tools/net/adapter/URLNetImpl$a;)V
    //   279: invokevirtual 215	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   282: aload_0
    //   283: aload 9
    //   285: putfield 34	com/tencent/map/tools/net/adapter/URLNetImpl:mCurrentConnect	Ljava/net/HttpURLConnection;
    //   288: aload 9
    //   290: invokevirtual 273	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   293: astore 11
    //   295: aload 11
    //   297: astore 10
    //   299: aload 9
    //   301: astore 11
    //   303: aload 10
    //   305: astore 12
    //   307: aload_3
    //   308: aload 10
    //   310: invokestatic 275	com/tencent/map/tools/net/adapter/URLNetImpl:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   313: aload 9
    //   315: astore 11
    //   317: aload 10
    //   319: astore 12
    //   321: aload 9
    //   323: invokevirtual 218	java/net/HttpURLConnection:connect	()V
    //   326: aload 9
    //   328: astore 11
    //   330: aload 10
    //   332: astore 12
    //   334: aload 9
    //   336: invokevirtual 222	java/net/HttpURLConnection:getResponseCode	()I
    //   339: istore 8
    //   341: aload 9
    //   343: astore 11
    //   345: aload 10
    //   347: astore 12
    //   349: new 201	com/tencent/map/tools/net/NetResponse
    //   352: dup
    //   353: invokespecial 223	com/tencent/map/tools/net/NetResponse:<init>	()V
    //   356: astore 14
    //   358: aload 9
    //   360: astore 11
    //   362: aload 10
    //   364: astore 12
    //   366: aload 14
    //   368: iload 8
    //   370: putfield 226	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   373: aload 9
    //   375: astore 11
    //   377: aload 10
    //   379: astore 12
    //   381: aload 14
    //   383: aload 9
    //   385: invokevirtual 230	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   388: invokestatic 234	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   391: putfield 237	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   394: iload 8
    //   396: sipush 200
    //   399: if_icmpne +73 -> 472
    //   402: aload 9
    //   404: astore 11
    //   406: aload 10
    //   408: astore 12
    //   410: aload 14
    //   412: iconst_0
    //   413: putfield 240	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   416: aload 9
    //   418: astore 11
    //   420: aload 10
    //   422: astore 12
    //   424: aload 14
    //   426: aload 9
    //   428: invokevirtual 244	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   431: invokestatic 246	com/tencent/map/tools/net/adapter/URLNetImpl:toBytes	(Ljava/io/InputStream;)[B
    //   434: putfield 250	com/tencent/map/tools/net/NetResponse:data	[B
    //   437: aload 9
    //   439: astore 11
    //   441: aload 10
    //   443: astore 12
    //   445: aload 15
    //   447: iconst_0
    //   448: putfield 252	com/tencent/map/tools/net/adapter/URLNetImpl$a:a	Z
    //   451: aload 14
    //   453: astore_1
    //   454: aload 9
    //   456: ifnull +8 -> 464
    //   459: aload 9
    //   461: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   464: aload 10
    //   466: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   469: goto -435 -> 34
    //   472: aload 9
    //   474: astore 11
    //   476: aload 10
    //   478: astore 12
    //   480: aload 14
    //   482: aload 9
    //   484: invokevirtual 255	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   487: invokestatic 246	com/tencent/map/tools/net/adapter/URLNetImpl:toBytes	(Ljava/io/InputStream;)[B
    //   490: putfield 258	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   493: aload 9
    //   495: astore 11
    //   497: aload 10
    //   499: astore 12
    //   501: aload 15
    //   503: invokevirtual 199	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   506: aload 14
    //   508: astore_1
    //   509: goto -55 -> 454
    //   512: astore_1
    //   513: aload 14
    //   515: astore_1
    //   516: goto -317 -> 199
    //   519: astore 10
    //   521: aconst_null
    //   522: astore 9
    //   524: aload 11
    //   526: astore_1
    //   527: new 201	com/tencent/map/tools/net/NetResponse
    //   530: dup
    //   531: aload 10
    //   533: invokespecial 204	com/tencent/map/tools/net/NetResponse:<init>	(Ljava/lang/Exception;)V
    //   536: astore 10
    //   538: aload 10
    //   540: iload 4
    //   542: putfield 226	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   545: aload 15
    //   547: invokevirtual 199	com/tencent/map/tools/net/adapter/URLNetImpl$a:b	()V
    //   550: aload_1
    //   551: ifnull +7 -> 558
    //   554: aload_1
    //   555: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   558: aload 9
    //   560: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   563: aload 10
    //   565: astore_1
    //   566: goto -532 -> 34
    //   569: astore_2
    //   570: aload 12
    //   572: astore_1
    //   573: aload 10
    //   575: astore_3
    //   576: aload_1
    //   577: ifnull +7 -> 584
    //   580: aload_1
    //   581: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   584: aload_3
    //   585: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   588: ldc_w 278
    //   591: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: aload_2
    //   595: athrow
    //   596: ldc_w 278
    //   599: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   602: aload_1
    //   603: areturn
    //   604: astore_2
    //   605: aload 9
    //   607: astore_1
    //   608: aload 10
    //   610: astore_3
    //   611: goto -35 -> 576
    //   614: astore_2
    //   615: aload 12
    //   617: astore_3
    //   618: aload 11
    //   620: astore_1
    //   621: goto -45 -> 576
    //   624: astore_2
    //   625: aload 9
    //   627: astore_3
    //   628: goto -52 -> 576
    //   631: astore 10
    //   633: aconst_null
    //   634: astore 11
    //   636: aload 9
    //   638: astore_1
    //   639: aload 11
    //   641: astore 9
    //   643: goto -116 -> 527
    //   646: astore_1
    //   647: aload 10
    //   649: astore 11
    //   651: aload_1
    //   652: astore 10
    //   654: aload 9
    //   656: astore_1
    //   657: aload 11
    //   659: astore 9
    //   661: goto -134 -> 527
    //   664: astore_1
    //   665: iload 8
    //   667: istore 4
    //   669: aload 10
    //   671: astore 11
    //   673: aload_1
    //   674: astore 10
    //   676: aload 9
    //   678: astore_1
    //   679: aload 11
    //   681: astore 9
    //   683: goto -156 -> 527
    //   686: astore 9
    //   688: aconst_null
    //   689: astore 10
    //   691: aconst_null
    //   692: astore 9
    //   694: goto -495 -> 199
    //   697: astore 11
    //   699: goto -500 -> 199
    //   702: aconst_null
    //   703: astore 10
    //   705: aconst_null
    //   706: astore 9
    //   708: goto -254 -> 454
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	this	URLNetImpl
    //   0	711	1	paramString1	String
    //   0	711	2	paramString2	String
    //   0	711	3	paramArrayOfByte	byte[]
    //   0	711	4	paramInt1	int
    //   0	711	5	paramHashMap	java.util.HashMap<String, String>
    //   0	711	6	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   0	711	7	paramInt2	int
    //   339	327	8	i	int
    //   7	675	9	localObject1	Object
    //   686	1	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   692	15	9	localObject2	Object
    //   49	1	10	localObject3	Object
    //   194	1	10	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   197	301	10	localObject4	Object
    //   519	13	10	localIOException1	IOException
    //   536	73	10	localNetResponse	com.tencent.map.tools.net.NetResponse
    //   631	17	10	localIOException2	IOException
    //   652	52	10	str	String
    //   46	634	11	localObject5	Object
    //   697	1	11	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   43	573	12	localObject6	Object
    //   17	225	13	localURL	java.net.URL
    //   140	374	14	localObject7	Object
    //   32	514	15	locala	a
    // Exception table:
    //   from	to	target	type
    //   69	83	194	java/net/SocketTimeoutException
    //   88	95	194	java/net/SocketTimeoutException
    //   100	120	194	java/net/SocketTimeoutException
    //   120	191	194	java/net/SocketTimeoutException
    //   246	261	194	java/net/SocketTimeoutException
    //   266	288	194	java/net/SocketTimeoutException
    //   288	295	194	java/net/SocketTimeoutException
    //   9	19	230	java/net/MalformedURLException
    //   366	373	512	java/net/SocketTimeoutException
    //   381	394	512	java/net/SocketTimeoutException
    //   410	416	512	java/net/SocketTimeoutException
    //   424	437	512	java/net/SocketTimeoutException
    //   445	451	512	java/net/SocketTimeoutException
    //   480	493	512	java/net/SocketTimeoutException
    //   501	506	512	java/net/SocketTimeoutException
    //   59	69	519	java/io/IOException
    //   59	69	569	finally
    //   69	83	604	finally
    //   88	95	604	finally
    //   100	120	604	finally
    //   120	191	604	finally
    //   246	261	604	finally
    //   266	288	604	finally
    //   288	295	604	finally
    //   207	212	614	finally
    //   307	313	614	finally
    //   321	326	614	finally
    //   334	341	614	finally
    //   349	358	614	finally
    //   366	373	614	finally
    //   381	394	614	finally
    //   410	416	614	finally
    //   424	437	614	finally
    //   445	451	614	finally
    //   480	493	614	finally
    //   501	506	614	finally
    //   527	550	624	finally
    //   69	83	631	java/io/IOException
    //   88	95	631	java/io/IOException
    //   100	120	631	java/io/IOException
    //   120	191	631	java/io/IOException
    //   246	261	631	java/io/IOException
    //   266	288	631	java/io/IOException
    //   288	295	631	java/io/IOException
    //   307	313	646	java/io/IOException
    //   321	326	646	java/io/IOException
    //   334	341	646	java/io/IOException
    //   349	358	664	java/io/IOException
    //   366	373	664	java/io/IOException
    //   381	394	664	java/io/IOException
    //   410	416	664	java/io/IOException
    //   424	437	664	java/io/IOException
    //   445	451	664	java/io/IOException
    //   480	493	664	java/io/IOException
    //   501	506	664	java/io/IOException
    //   59	69	686	java/net/SocketTimeoutException
    //   307	313	697	java/net/SocketTimeoutException
    //   321	326	697	java/net/SocketTimeoutException
    //   334	341	697	java/net/SocketTimeoutException
    //   349	358	697	java/net/SocketTimeoutException
  }
  
  /* Error */
  protected void onRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, com.tencent.map.tools.net.http.HttpCanceler paramHttpCanceler)
  {
    // Byte code:
    //   0: ldc_w 283
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 133	java/net/URL
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 136	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +365 -> 381
    //   19: aload_1
    //   20: invokevirtual 145	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 116	java/net/HttpURLConnection
    //   26: astore_1
    //   27: aload_1
    //   28: ldc_w 265
    //   31: invokevirtual 150	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: iconst_1
    //   36: invokevirtual 269	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   39: aload_1
    //   40: ldc 206
    //   42: ldc_w 285
    //   45: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: ldc_w 287
    //   52: aload_3
    //   53: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_1
    //   57: ldc_w 289
    //   60: aload 4
    //   62: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_1
    //   66: ldc_w 291
    //   69: aload 5
    //   71: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_1
    //   75: ldc_w 293
    //   78: new 295	java/lang/StringBuilder
    //   81: dup
    //   82: ldc_w 297
    //   85: invokespecial 298	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload 6
    //   90: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc_w 304
    //   96: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 196	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 7
    //   107: ifnull +22 -> 129
    //   110: aload 7
    //   112: aload_0
    //   113: new 10	com/tencent/map/tools/net/adapter/URLNetImpl$3
    //   116: dup
    //   117: aload_0
    //   118: invokespecial 310	com/tencent/map/tools/net/adapter/URLNetImpl$3:<init>	(Lcom/tencent/map/tools/net/adapter/URLNetImpl;)V
    //   121: invokevirtual 215	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   124: aload_0
    //   125: aload_1
    //   126: putfield 34	com/tencent/map/tools/net/adapter/URLNetImpl:mCurrentConnect	Ljava/net/HttpURLConnection;
    //   129: aload_1
    //   130: invokevirtual 273	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   133: astore_3
    //   134: aload_2
    //   135: aload_3
    //   136: invokestatic 275	com/tencent/map/tools/net/adapter/URLNetImpl:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   139: aload_1
    //   140: invokevirtual 218	java/net/HttpURLConnection:connect	()V
    //   143: aload_1
    //   144: invokevirtual 222	java/net/HttpURLConnection:getResponseCode	()I
    //   147: istore 8
    //   149: aload_1
    //   150: invokevirtual 230	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   153: invokestatic 234	com/tencent/map/tools/net/adapter/URLNetImpl:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   156: pop
    //   157: iload 8
    //   159: sipush 200
    //   162: if_icmpne +121 -> 283
    //   165: aload_1
    //   166: ldc_w 312
    //   169: invokevirtual 315	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   172: astore_2
    //   173: aload_2
    //   174: invokestatic 53	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   177: istore 8
    //   179: iload 8
    //   181: ifeq +102 -> 283
    //   184: iload 8
    //   186: bipush 254
    //   188: if_icmpne +47 -> 235
    //   191: new 317	com/tencent/map/tools/net/exception/FileUploadResetException
    //   194: dup
    //   195: invokespecial 318	com/tencent/map/tools/net/exception/FileUploadResetException:<init>	()V
    //   198: astore_2
    //   199: ldc_w 283
    //   202: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_2
    //   206: athrow
    //   207: astore_2
    //   208: aload_3
    //   209: astore_2
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   218: aload_2
    //   219: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   222: ldc_w 283
    //   225: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_1
    //   232: goto -217 -> 15
    //   235: new 320	java/lang/Exception
    //   238: dup
    //   239: ldc_w 322
    //   242: aload_2
    //   243: invokestatic 326	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   246: invokevirtual 329	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   249: invokespecial 330	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   252: astore_2
    //   253: ldc_w 283
    //   256: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_2
    //   260: athrow
    //   261: astore_2
    //   262: aload_3
    //   263: astore_2
    //   264: aload_1
    //   265: ifnull +7 -> 272
    //   268: aload_1
    //   269: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   272: aload_2
    //   273: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   276: ldc_w 283
    //   279: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: aload_3
    //   284: astore_2
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   293: aload_2
    //   294: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   297: ldc_w 283
    //   300: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: astore_1
    //   305: aconst_null
    //   306: astore_2
    //   307: aconst_null
    //   308: astore_3
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 119	java/net/HttpURLConnection:disconnect	()V
    //   317: aload_2
    //   318: invokestatic 96	com/tencent/map/tools/net/adapter/URLNetImpl:safeClose	(Ljava/io/Closeable;)V
    //   321: ldc_w 283
    //   324: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_1
    //   328: athrow
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_2
    //   333: aload_1
    //   334: astore_3
    //   335: aload 4
    //   337: astore_1
    //   338: goto -29 -> 309
    //   341: astore 4
    //   343: aload_3
    //   344: astore_2
    //   345: aload_1
    //   346: astore_3
    //   347: aload 4
    //   349: astore_1
    //   350: goto -41 -> 309
    //   353: astore_1
    //   354: aconst_null
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_1
    //   358: goto -94 -> 264
    //   361: astore_2
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -100 -> 264
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -162 -> 210
    //   375: astore_2
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -168 -> 210
    //   381: aconst_null
    //   382: astore_2
    //   383: aconst_null
    //   384: astore_1
    //   385: goto -100 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	URLNetImpl
    //   0	388	1	paramString1	String
    //   0	388	2	paramArrayOfByte	byte[]
    //   0	388	3	paramString2	String
    //   0	388	4	paramString3	String
    //   0	388	5	paramString4	String
    //   0	388	6	paramString5	String
    //   0	388	7	paramHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   147	42	8	i	int
    // Exception table:
    //   from	to	target	type
    //   134	157	207	java/net/SocketTimeoutException
    //   165	179	207	java/net/SocketTimeoutException
    //   191	207	207	java/net/SocketTimeoutException
    //   235	261	207	java/net/SocketTimeoutException
    //   6	15	229	java/net/MalformedURLException
    //   134	157	261	java/io/IOException
    //   165	179	261	java/io/IOException
    //   191	207	261	java/io/IOException
    //   235	261	261	java/io/IOException
    //   19	27	304	finally
    //   27	105	329	finally
    //   110	129	329	finally
    //   129	134	329	finally
    //   134	157	341	finally
    //   165	179	341	finally
    //   191	207	341	finally
    //   235	261	341	finally
    //   19	27	353	java/io/IOException
    //   27	105	361	java/io/IOException
    //   110	129	361	java/io/IOException
    //   129	134	361	java/io/IOException
    //   19	27	367	java/net/SocketTimeoutException
    //   27	105	375	java/net/SocketTimeoutException
    //   110	129	375	java/net/SocketTimeoutException
    //   129	134	375	java/net/SocketTimeoutException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.tools.net.adapter.URLNetImpl
 * JD-Core Version:    0.7.0.1
 */