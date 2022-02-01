package com.squareup.okhttp.internal.io;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedConnection.Builder;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.squareup.okhttp.ConnectionSpec;>;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection
  implements Connection
{
  private static SSLSocketFactory lastSslSocketFactory;
  private static TrustRootIndex lastTrustRootIndex;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  public volatile FramedConnection framedConnection;
  private Handshake handshake;
  public long idleAtNanos = 9223372036854775807L;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  public BufferedSink sink;
  public Socket socket;
  public BufferedSource source;
  public int streamCount;
  
  public RealConnection(Route paramRoute)
  {
    this.route = paramRoute;
  }
  
  private void connectSocket(int paramInt1, int paramInt2, int paramInt3, ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    this.rawSocket.setSoTimeout(paramInt2);
    for (;;)
    {
      try
      {
        Platform.get().connectSocket(this.rawSocket, this.route.getSocketAddress(), paramInt1);
        this.source = Okio.buffer(Okio.source(this.rawSocket));
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        if (this.route.getAddress().getSslSocketFactory() != null)
        {
          connectTls(paramInt2, paramInt3, paramConnectionSpecSelector);
          if ((this.protocol == Protocol.SPDY_3) || (this.protocol == Protocol.HTTP_2))
          {
            this.socket.setSoTimeout(0);
            paramConnectionSpecSelector = new FramedConnection.Builder(true).socket(this.socket, this.route.getAddress().url().host(), this.source, this.sink).protocol(this.protocol).build();
            paramConnectionSpecSelector.sendConnectionPreface();
            this.framedConnection = paramConnectionSpecSelector;
          }
          return;
        }
      }
      catch (ConnectException paramConnectionSpecSelector)
      {
        throw new ConnectException("Failed to connect to " + this.route.getSocketAddress());
      }
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    }
  }
  
  /* Error */
  private void connectTls(int paramInt1, int paramInt2, ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/squareup/okhttp/internal/io/RealConnection:route	Lcom/squareup/okhttp/Route;
    //   4: invokevirtual 187	com/squareup/okhttp/Route:requiresTunnel	()Z
    //   7: ifeq +9 -> 16
    //   10: aload_0
    //   11: iload_1
    //   12: iload_2
    //   13: invokespecial 191	com/squareup/okhttp/internal/io/RealConnection:createTunnel	(II)V
    //   16: aload_0
    //   17: getfield 50	com/squareup/okhttp/internal/io/RealConnection:route	Lcom/squareup/okhttp/Route;
    //   20: invokevirtual 103	com/squareup/okhttp/Route:getAddress	()Lcom/squareup/okhttp/Address;
    //   23: astore 8
    //   25: aload 8
    //   27: invokevirtual 109	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   30: astore 6
    //   32: aconst_null
    //   33: astore 5
    //   35: aconst_null
    //   36: astore 4
    //   38: aload 6
    //   40: aload_0
    //   41: getfield 59	com/squareup/okhttp/internal/io/RealConnection:rawSocket	Ljava/net/Socket;
    //   44: aload 8
    //   46: invokevirtual 194	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   49: aload 8
    //   51: invokevirtual 198	com/squareup/okhttp/Address:getUriPort	()I
    //   54: iconst_1
    //   55: invokevirtual 204	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   58: checkcast 206	javax/net/ssl/SSLSocket
    //   61: astore 6
    //   63: aload 6
    //   65: astore 4
    //   67: aload 6
    //   69: astore 5
    //   71: aload 6
    //   73: iconst_3
    //   74: anewarray 208	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc 210
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: ldc 212
    //   86: aastore
    //   87: dup
    //   88: iconst_2
    //   89: ldc 214
    //   91: aastore
    //   92: invokevirtual 218	javax/net/ssl/SSLSocket:setEnabledProtocols	([Ljava/lang/String;)V
    //   95: aload 6
    //   97: astore 4
    //   99: aload 6
    //   101: astore 5
    //   103: aload_3
    //   104: aload 6
    //   106: invokevirtual 224	com/squareup/okhttp/internal/ConnectionSpecSelector:configureSecureSocket	(Ljavax/net/ssl/SSLSocket;)Lcom/squareup/okhttp/ConnectionSpec;
    //   109: astore 9
    //   111: aload 6
    //   113: astore 4
    //   115: aload 6
    //   117: astore 5
    //   119: aload 8
    //   121: invokevirtual 194	com/squareup/okhttp/Address:getUriHost	()Ljava/lang/String;
    //   124: astore 7
    //   126: aload 7
    //   128: astore_3
    //   129: aload 6
    //   131: astore 4
    //   133: aload 6
    //   135: astore 5
    //   137: aload 9
    //   139: invokevirtual 229	com/squareup/okhttp/ConnectionSpec:supportsTlsExtensions	()Z
    //   142: ifeq +103 -> 245
    //   145: aload 7
    //   147: astore_3
    //   148: aload 6
    //   150: astore 4
    //   152: aload 6
    //   154: astore 5
    //   156: aload 8
    //   158: getfield 233	com/squareup/okhttp/Address:headerHost	Ljava/lang/String;
    //   161: ifnull +62 -> 223
    //   164: aload 7
    //   166: astore_3
    //   167: aload 6
    //   169: astore 4
    //   171: aload 6
    //   173: astore 5
    //   175: aload 8
    //   177: getfield 233	com/squareup/okhttp/Address:headerHost	Ljava/lang/String;
    //   180: ldc 235
    //   182: if_acmpeq +41 -> 223
    //   185: aload 7
    //   187: astore_3
    //   188: aload 6
    //   190: astore 4
    //   192: aload 6
    //   194: astore 5
    //   196: aload 8
    //   198: getfield 233	com/squareup/okhttp/Address:headerHost	Ljava/lang/String;
    //   201: aload 7
    //   203: invokevirtual 239	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne +17 -> 223
    //   209: aload 6
    //   211: astore 4
    //   213: aload 6
    //   215: astore 5
    //   217: aload 8
    //   219: getfield 233	com/squareup/okhttp/Address:headerHost	Ljava/lang/String;
    //   222: astore_3
    //   223: aload 6
    //   225: astore 4
    //   227: aload 6
    //   229: astore 5
    //   231: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   234: aload 6
    //   236: aload_3
    //   237: aload 8
    //   239: invokevirtual 243	com/squareup/okhttp/Address:getProtocols	()Ljava/util/List;
    //   242: invokevirtual 247	com/squareup/okhttp/internal/Platform:configureTlsExtensions	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   245: aload 6
    //   247: astore 4
    //   249: aload 6
    //   251: astore 5
    //   253: aload 6
    //   255: invokevirtual 250	javax/net/ssl/SSLSocket:startHandshake	()V
    //   258: aload 6
    //   260: astore 4
    //   262: aload 6
    //   264: astore 5
    //   266: aload 6
    //   268: invokevirtual 254	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   271: invokestatic 259	com/squareup/okhttp/Handshake:get	(Ljavax/net/ssl/SSLSession;)Lcom/squareup/okhttp/Handshake;
    //   274: astore 7
    //   276: aload 6
    //   278: astore 4
    //   280: aload 6
    //   282: astore 5
    //   284: aload 8
    //   286: invokevirtual 263	com/squareup/okhttp/Address:getHostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   289: aload_3
    //   290: aload 6
    //   292: invokevirtual 254	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   295: invokeinterface 269 3 0
    //   300: ifne +166 -> 466
    //   303: aload 6
    //   305: astore 4
    //   307: aload 6
    //   309: astore 5
    //   311: aload 7
    //   313: invokevirtual 272	com/squareup/okhttp/Handshake:peerCertificates	()Ljava/util/List;
    //   316: iconst_0
    //   317: invokeinterface 277 2 0
    //   322: checkcast 279	java/security/cert/X509Certificate
    //   325: astore 7
    //   327: aload 6
    //   329: astore 4
    //   331: aload 6
    //   333: astore 5
    //   335: new 281	javax/net/ssl/SSLPeerUnverifiedException
    //   338: dup
    //   339: new 159	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 283
    //   349: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_3
    //   353: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc_w 285
    //   359: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: ldc_w 287
    //   365: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: aload 7
    //   370: invokestatic 293	com/squareup/okhttp/CertificatePinner:pin	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   373: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w 295
    //   379: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 7
    //   384: invokevirtual 299	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   387: invokeinterface 304 1 0
    //   392: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 306
    //   398: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 7
    //   403: invokestatic 312	com/squareup/okhttp/internal/tls/OkHostnameVerifier:allSubjectAltNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   406: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokespecial 313	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   415: athrow
    //   416: astore_3
    //   417: aload 4
    //   419: astore 5
    //   421: aload_3
    //   422: invokestatic 319	com/squareup/okhttp/internal/Util:isAndroidGetsocknameError	(Ljava/lang/AssertionError;)Z
    //   425: ifeq +290 -> 715
    //   428: aload 4
    //   430: astore 5
    //   432: new 55	java/io/IOException
    //   435: dup
    //   436: aload_3
    //   437: invokespecial 322	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   440: athrow
    //   441: astore_3
    //   442: aload 5
    //   444: ifnull +11 -> 455
    //   447: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   450: aload 5
    //   452: invokevirtual 326	com/squareup/okhttp/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   455: iconst_0
    //   456: ifne +8 -> 464
    //   459: aload 5
    //   461: invokestatic 330	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   464: aload_3
    //   465: athrow
    //   466: aload 6
    //   468: astore 4
    //   470: aload 6
    //   472: astore 5
    //   474: aload 8
    //   476: invokevirtual 334	com/squareup/okhttp/Address:getCertificatePinner	()Lcom/squareup/okhttp/CertificatePinner;
    //   479: getstatic 338	com/squareup/okhttp/CertificatePinner:DEFAULT	Lcom/squareup/okhttp/CertificatePinner;
    //   482: if_acmpeq +55 -> 537
    //   485: aload 6
    //   487: astore 4
    //   489: aload 6
    //   491: astore 5
    //   493: new 340	com/squareup/okhttp/internal/tls/CertificateChainCleaner
    //   496: dup
    //   497: aload 8
    //   499: invokevirtual 109	com/squareup/okhttp/Address:getSslSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   502: invokestatic 344	com/squareup/okhttp/internal/io/RealConnection:trustRootIndex	(Ljavax/net/ssl/SSLSocketFactory;)Lcom/squareup/okhttp/internal/tls/TrustRootIndex;
    //   505: invokespecial 347	com/squareup/okhttp/internal/tls/CertificateChainCleaner:<init>	(Lcom/squareup/okhttp/internal/tls/TrustRootIndex;)V
    //   508: aload 7
    //   510: invokevirtual 272	com/squareup/okhttp/Handshake:peerCertificates	()Ljava/util/List;
    //   513: invokevirtual 351	com/squareup/okhttp/internal/tls/CertificateChainCleaner:clean	(Ljava/util/List;)Ljava/util/List;
    //   516: astore 10
    //   518: aload 6
    //   520: astore 4
    //   522: aload 6
    //   524: astore 5
    //   526: aload 8
    //   528: invokevirtual 334	com/squareup/okhttp/Address:getCertificatePinner	()Lcom/squareup/okhttp/CertificatePinner;
    //   531: aload_3
    //   532: aload 10
    //   534: invokevirtual 355	com/squareup/okhttp/CertificatePinner:check	(Ljava/lang/String;Ljava/util/List;)V
    //   537: aload 6
    //   539: astore 4
    //   541: aload 6
    //   543: astore 5
    //   545: aload 9
    //   547: invokevirtual 229	com/squareup/okhttp/ConnectionSpec:supportsTlsExtensions	()Z
    //   550: ifeq +145 -> 695
    //   553: aload 6
    //   555: astore 4
    //   557: aload 6
    //   559: astore 5
    //   561: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   564: aload 6
    //   566: invokevirtual 359	com/squareup/okhttp/internal/Platform:getSelectedProtocol	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   569: astore_3
    //   570: aload 6
    //   572: astore 4
    //   574: aload 6
    //   576: astore 5
    //   578: aload_0
    //   579: aload 6
    //   581: putfield 125	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   584: aload 6
    //   586: astore 4
    //   588: aload 6
    //   590: astore 5
    //   592: aload_0
    //   593: aload_0
    //   594: getfield 125	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   597: invokestatic 85	okio/Okio:source	(Ljava/net/Socket;)Lokio/Source;
    //   600: invokestatic 89	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   603: putfield 91	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   606: aload 6
    //   608: astore 4
    //   610: aload 6
    //   612: astore 5
    //   614: aload_0
    //   615: aload_0
    //   616: getfield 125	com/squareup/okhttp/internal/io/RealConnection:socket	Ljava/net/Socket;
    //   619: invokestatic 94	okio/Okio:sink	(Ljava/net/Socket;)Lokio/Sink;
    //   622: invokestatic 97	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   625: putfield 99	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   628: aload 6
    //   630: astore 4
    //   632: aload 6
    //   634: astore 5
    //   636: aload_0
    //   637: aload 7
    //   639: putfield 361	com/squareup/okhttp/internal/io/RealConnection:handshake	Lcom/squareup/okhttp/Handshake;
    //   642: aload_3
    //   643: ifnull +57 -> 700
    //   646: aload 6
    //   648: astore 4
    //   650: aload 6
    //   652: astore 5
    //   654: aload_3
    //   655: invokestatic 364	com/squareup/okhttp/Protocol:get	(Ljava/lang/String;)Lcom/squareup/okhttp/Protocol;
    //   658: astore_3
    //   659: aload 6
    //   661: astore 4
    //   663: aload 6
    //   665: astore 5
    //   667: aload_0
    //   668: aload_3
    //   669: putfield 115	com/squareup/okhttp/internal/io/RealConnection:protocol	Lcom/squareup/okhttp/Protocol;
    //   672: aload 6
    //   674: ifnull +11 -> 685
    //   677: invokestatic 71	com/squareup/okhttp/internal/Platform:get	()Lcom/squareup/okhttp/internal/Platform;
    //   680: aload 6
    //   682: invokevirtual 326	com/squareup/okhttp/internal/Platform:afterHandshake	(Ljavax/net/ssl/SSLSocket;)V
    //   685: iconst_1
    //   686: ifne +8 -> 694
    //   689: aload 6
    //   691: invokestatic 330	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/net/Socket;)V
    //   694: return
    //   695: aconst_null
    //   696: astore_3
    //   697: goto -127 -> 570
    //   700: aload 6
    //   702: astore 4
    //   704: aload 6
    //   706: astore 5
    //   708: getstatic 178	com/squareup/okhttp/Protocol:HTTP_1_1	Lcom/squareup/okhttp/Protocol;
    //   711: astore_3
    //   712: goto -53 -> 659
    //   715: aload 4
    //   717: astore 5
    //   719: aload_3
    //   720: athrow
    //   721: astore 4
    //   723: goto -628 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	726	0	this	RealConnection
    //   0	726	1	paramInt1	int
    //   0	726	2	paramInt2	int
    //   0	726	3	paramConnectionSpecSelector	ConnectionSpecSelector
    //   36	680	4	localObject1	Object
    //   721	1	4	localException	java.lang.Exception
    //   33	685	5	localObject2	Object
    //   30	675	6	localObject3	Object
    //   124	514	7	localObject4	Object
    //   23	504	8	localAddress	Address
    //   109	437	9	localConnectionSpec	ConnectionSpec
    //   516	17	10	localList	List
    // Exception table:
    //   from	to	target	type
    //   38	63	416	java/lang/AssertionError
    //   71	95	416	java/lang/AssertionError
    //   103	111	416	java/lang/AssertionError
    //   119	126	416	java/lang/AssertionError
    //   137	145	416	java/lang/AssertionError
    //   156	164	416	java/lang/AssertionError
    //   175	185	416	java/lang/AssertionError
    //   196	209	416	java/lang/AssertionError
    //   217	223	416	java/lang/AssertionError
    //   231	245	416	java/lang/AssertionError
    //   253	258	416	java/lang/AssertionError
    //   266	276	416	java/lang/AssertionError
    //   284	303	416	java/lang/AssertionError
    //   311	327	416	java/lang/AssertionError
    //   335	416	416	java/lang/AssertionError
    //   474	485	416	java/lang/AssertionError
    //   493	518	416	java/lang/AssertionError
    //   526	537	416	java/lang/AssertionError
    //   545	553	416	java/lang/AssertionError
    //   561	570	416	java/lang/AssertionError
    //   578	584	416	java/lang/AssertionError
    //   592	606	416	java/lang/AssertionError
    //   614	628	416	java/lang/AssertionError
    //   636	642	416	java/lang/AssertionError
    //   654	659	416	java/lang/AssertionError
    //   667	672	416	java/lang/AssertionError
    //   708	712	416	java/lang/AssertionError
    //   38	63	441	finally
    //   71	95	441	finally
    //   103	111	441	finally
    //   119	126	441	finally
    //   137	145	441	finally
    //   156	164	441	finally
    //   175	185	441	finally
    //   196	209	441	finally
    //   217	223	441	finally
    //   231	245	441	finally
    //   253	258	441	finally
    //   266	276	441	finally
    //   284	303	441	finally
    //   311	327	441	finally
    //   335	416	441	finally
    //   421	428	441	finally
    //   432	441	441	finally
    //   474	485	441	finally
    //   493	518	441	finally
    //   526	537	441	finally
    //   545	553	441	finally
    //   561	570	441	finally
    //   578	584	441	finally
    //   592	606	441	finally
    //   614	628	441	finally
    //   636	642	441	finally
    //   654	659	441	finally
    //   667	672	441	finally
    //   708	712	441	finally
    //   719	721	441	finally
    //   71	95	721	java/lang/Exception
  }
  
  private void createTunnel(int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = createTunnelRequest();
    Object localObject2 = ((Request)localObject1).httpUrl();
    String str = "CONNECT " + ((HttpUrl)localObject2).host() + ":" + ((HttpUrl)localObject2).port() + " HTTP/1.1";
    do
    {
      localObject2 = new Http1xStream(null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      ((Http1xStream)localObject2).writeRequest(((Request)localObject1).headers(), str);
      ((Http1xStream)localObject2).finishRequest();
      localObject1 = ((Http1xStream)localObject2).readResponse().request((Request)localObject1).build();
      long l2 = OkHeaders.contentLength((Response)localObject1);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject2 = ((Http1xStream)localObject2).newFixedLengthSource(l1);
      Util.skipAll((Source)localObject2, 2147483647, TimeUnit.MILLISECONDS);
      ((Source)localObject2).close();
      switch (((Response)localObject1).code())
      {
      default: 
        throw new IOException("Unexpected response code for CONNECT: " + ((Response)localObject1).code());
      case 200: 
        if ((this.source.buffer().exhausted()) && (this.sink.buffer().exhausted())) {
          break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407: 
        localObject2 = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), (Response)localObject1, this.route.getProxy());
        localObject1 = localObject2;
      }
    } while (localObject2 != null);
    throw new IOException("Failed to authenticate with proxy");
  }
  
  private Request createTunnelRequest()
    throws IOException
  {
    return new Request.Builder().url(this.route.getAddress().url()).header("Host", Util.hostHeader(this.route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }
  
  private static TrustRootIndex trustRootIndex(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      if (paramSSLSocketFactory != lastSslSocketFactory)
      {
        X509TrustManager localX509TrustManager = Platform.get().trustManager(paramSSLSocketFactory);
        lastTrustRootIndex = Platform.get().trustRootIndex(localX509TrustManager);
        lastSslSocketFactory = paramSSLSocketFactory;
      }
      paramSSLSocketFactory = lastTrustRootIndex;
      return paramSSLSocketFactory;
    }
    finally {}
  }
  
  public int allocationLimit()
  {
    FramedConnection localFramedConnection = this.framedConnection;
    if (localFramedConnection != null) {
      return localFramedConnection.maxConcurrentStreams();
    }
    return 1;
  }
  
  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, List<ConnectionSpec> paramList, boolean paramBoolean)
    throws RouteException
  {
    if (this.protocol != null) {
      throw new IllegalStateException("already connected");
    }
    Object localObject2 = null;
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector(paramList);
    Proxy localProxy = this.route.getProxy();
    Address localAddress = this.route.getAddress();
    Object localObject1 = localObject2;
    if (this.route.getAddress().getSslSocketFactory() == null)
    {
      localObject1 = localObject2;
      if (!paramList.contains(ConnectionSpec.CLEARTEXT)) {
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + paramList));
      }
    }
    for (;;)
    {
      try
      {
        paramList = new Socket(localProxy);
        this.rawSocket = paramList;
        connectSocket(paramInt1, paramInt2, paramInt3, localConnectionSpecSelector);
      }
      catch (IOException localIOException)
      {
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        if (localObject1 != null) {
          continue;
        }
        paramList = new RouteException(localIOException);
        if (!paramBoolean) {
          continue;
        }
        localObject1 = paramList;
        if (localConnectionSpecSelector.connectionFailed(localIOException)) {
          continue;
        }
        throw paramList;
        ((RouteException)localObject1).addConnectException(localIOException);
        paramList = (List<ConnectionSpec>)localObject1;
        continue;
      }
      if (this.protocol != null) {
        return;
      }
      if ((localProxy.type() == Proxy.Type.DIRECT) || (localProxy.type() == Proxy.Type.HTTP)) {
        paramList = localAddress.getSocketFactory().createSocket();
      }
    }
  }
  
  public Handshake getHandshake()
  {
    return this.handshake;
  }
  
  public Protocol getProtocol()
  {
    if (this.protocol != null) {
      return this.protocol;
    }
    return Protocol.HTTP_1_1;
  }
  
  public Route getRoute()
  {
    return this.route;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  boolean isConnected()
  {
    return this.protocol != null;
  }
  
  public boolean isHealthy(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.framedConnection != null);
      bool1 = bool2;
    } while (!paramBoolean);
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        paramBoolean = this.source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
      return true;
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException) {}
  }
  
  public boolean isMultiplexed()
  {
    return this.framedConnection != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.getAddress().url().host()).append(":").append(this.route.getAddress().url().port()).append(", proxy=").append(this.route.getProxy()).append(" hostAddress=").append(this.route.getSocketAddress()).append(" cipherSuite=");
    if (this.handshake != null) {}
    for (String str = this.handshake.cipherSuite();; str = "none") {
      return str + " protocol=" + this.protocol + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.io.RealConnection
 * JD-Core Version:    0.7.0.1
 */