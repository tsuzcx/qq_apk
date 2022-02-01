package com.squareup.okhttp.internal;

import android.util.Log;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.tls.AndroidTrustRootIndex;
import com.squareup.okhttp.internal.tls.RealTrustRootIndex;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class Platform
{
  private static final Platform PLATFORM = ;
  
  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
    }
    return localBuffer.readByteArray();
  }
  
  /* Error */
  private static Platform findPlatform()
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 4
    //   7: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   10: dup
    //   11: aconst_null
    //   12: ldc 90
    //   14: iconst_1
    //   15: anewarray 82	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: getstatic 96	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   23: aastore
    //   24: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   27: astore 8
    //   29: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   32: dup
    //   33: aconst_null
    //   34: ldc 101
    //   36: iconst_1
    //   37: anewarray 82	java/lang/Class
    //   40: dup
    //   41: iconst_0
    //   42: ldc 57
    //   44: aastore
    //   45: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   48: astore 9
    //   50: aconst_null
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_1
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 6
    //   60: aload_3
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: ldc 103
    //   66: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   69: astore 10
    //   71: aload_3
    //   72: astore_2
    //   73: aload_1
    //   74: astore_0
    //   75: aload 10
    //   77: ldc 105
    //   79: iconst_1
    //   80: anewarray 82	java/lang/Class
    //   83: dup
    //   84: iconst_0
    //   85: ldc 107
    //   87: aastore
    //   88: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   91: astore 5
    //   93: aload 5
    //   95: astore_2
    //   96: aload_1
    //   97: astore_0
    //   98: aload 10
    //   100: ldc 113
    //   102: iconst_1
    //   103: anewarray 82	java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: ldc 107
    //   110: aastore
    //   111: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   114: astore_1
    //   115: aload 5
    //   117: astore_2
    //   118: aload_1
    //   119: astore_0
    //   120: ldc 115
    //   122: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   125: pop
    //   126: aload 5
    //   128: astore_2
    //   129: aload_1
    //   130: astore_0
    //   131: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   134: dup
    //   135: ldc 117
    //   137: ldc 119
    //   139: iconst_0
    //   140: anewarray 82	java/lang/Class
    //   143: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   146: astore_3
    //   147: new 88	com/squareup/okhttp/internal/OptionalMethod
    //   150: dup
    //   151: aconst_null
    //   152: ldc 121
    //   154: iconst_1
    //   155: anewarray 82	java/lang/Class
    //   158: dup
    //   159: iconst_0
    //   160: ldc 117
    //   162: aastore
    //   163: invokespecial 99	com/squareup/okhttp/internal/OptionalMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   166: astore_0
    //   167: aload_3
    //   168: astore_2
    //   169: aload_0
    //   170: astore_3
    //   171: aload_2
    //   172: astore_0
    //   173: aload 5
    //   175: astore_2
    //   176: new 6	com/squareup/okhttp/internal/Platform$Android
    //   179: dup
    //   180: aload 4
    //   182: aload 8
    //   184: aload 9
    //   186: aload_2
    //   187: aload_1
    //   188: aload_0
    //   189: aload_3
    //   190: invokespecial 124	com/squareup/okhttp/internal/Platform$Android:<init>	(Ljava/lang/Class;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/OptionalMethod;Lcom/squareup/okhttp/internal/OptionalMethod;)V
    //   193: areturn
    //   194: astore_0
    //   195: ldc 126
    //   197: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   200: astore 4
    //   202: goto -195 -> 7
    //   205: astore_0
    //   206: ldc 128
    //   208: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   211: astore_0
    //   212: ldc 130
    //   214: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   217: astore_1
    //   218: new 132	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   225: ldc 130
    //   227: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 139
    //   232: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   241: astore_2
    //   242: new 132	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   249: ldc 130
    //   251: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc 142
    //   256: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   265: astore_3
    //   266: new 132	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   273: ldc 130
    //   275: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 144
    //   280: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   289: astore 4
    //   291: new 12	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   294: dup
    //   295: aload_0
    //   296: aload_1
    //   297: ldc 146
    //   299: iconst_2
    //   300: anewarray 82	java/lang/Class
    //   303: dup
    //   304: iconst_0
    //   305: ldc 148
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: aload_2
    //   311: aastore
    //   312: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   315: aload_1
    //   316: ldc 149
    //   318: iconst_1
    //   319: anewarray 82	java/lang/Class
    //   322: dup
    //   323: iconst_0
    //   324: ldc 148
    //   326: aastore
    //   327: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   330: aload_1
    //   331: ldc 151
    //   333: iconst_1
    //   334: anewarray 82	java/lang/Class
    //   337: dup
    //   338: iconst_0
    //   339: ldc 148
    //   341: aastore
    //   342: invokevirtual 111	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   345: aload_3
    //   346: aload 4
    //   348: invokespecial 154	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   351: astore_1
    //   352: aload_1
    //   353: areturn
    //   354: astore_1
    //   355: new 9	com/squareup/okhttp/internal/Platform$JdkPlatform
    //   358: dup
    //   359: aload_0
    //   360: invokespecial 157	com/squareup/okhttp/internal/Platform$JdkPlatform:<init>	(Ljava/lang/Class;)V
    //   363: astore_0
    //   364: aload_0
    //   365: areturn
    //   366: astore_0
    //   367: new 2	com/squareup/okhttp/internal/Platform
    //   370: dup
    //   371: invokespecial 158	com/squareup/okhttp/internal/Platform:<init>	()V
    //   374: areturn
    //   375: astore_1
    //   376: aload_0
    //   377: astore_1
    //   378: aload 7
    //   380: astore_0
    //   381: aload 6
    //   383: astore_3
    //   384: goto -208 -> 176
    //   387: astore_0
    //   388: aload_3
    //   389: astore_0
    //   390: aload 5
    //   392: astore_2
    //   393: aload 6
    //   395: astore_3
    //   396: goto -220 -> 176
    //   399: astore_0
    //   400: aload 5
    //   402: astore_2
    //   403: aload 7
    //   405: astore_0
    //   406: aload 6
    //   408: astore_3
    //   409: goto -233 -> 176
    //   412: astore_0
    //   413: aload_3
    //   414: astore_0
    //   415: aload 5
    //   417: astore_2
    //   418: aload 6
    //   420: astore_3
    //   421: goto -245 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   63	126	0	localObject1	Object
    //   194	1	0	localClassNotFoundException1	ClassNotFoundException
    //   205	1	0	localClassNotFoundException2	ClassNotFoundException
    //   211	154	0	localObject2	Object
    //   366	11	0	localClassNotFoundException3	ClassNotFoundException
    //   380	1	0	localObject3	Object
    //   387	1	0	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   389	1	0	localObject4	Object
    //   399	1	0	localClassNotFoundException4	ClassNotFoundException
    //   405	1	0	localObject5	Object
    //   412	1	0	localClassNotFoundException5	ClassNotFoundException
    //   414	1	0	localObject6	Object
    //   53	300	1	localObject7	Object
    //   354	1	1	localClassNotFoundException6	ClassNotFoundException
    //   375	1	1	localClassNotFoundException7	ClassNotFoundException
    //   377	1	1	localObject8	Object
    //   61	357	2	localObject9	Object
    //   51	370	3	localObject10	Object
    //   5	342	4	localClass1	Class
    //   91	325	5	localMethod	Method
    //   58	361	6	localObject11	Object
    //   55	349	7	localObject12	Object
    //   27	156	8	localOptionalMethod1	OptionalMethod
    //   48	137	9	localOptionalMethod2	OptionalMethod
    //   69	30	10	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   0	7	194	java/lang/ClassNotFoundException
    //   7	50	205	java/lang/ClassNotFoundException
    //   176	194	205	java/lang/ClassNotFoundException
    //   195	202	205	java/lang/ClassNotFoundException
    //   212	352	354	java/lang/ClassNotFoundException
    //   212	352	354	java/lang/NoSuchMethodException
    //   206	212	366	java/lang/ClassNotFoundException
    //   355	364	366	java/lang/ClassNotFoundException
    //   64	71	375	java/lang/ClassNotFoundException
    //   64	71	375	java/lang/NoSuchMethodException
    //   75	93	375	java/lang/ClassNotFoundException
    //   75	93	375	java/lang/NoSuchMethodException
    //   98	115	375	java/lang/ClassNotFoundException
    //   98	115	375	java/lang/NoSuchMethodException
    //   120	126	375	java/lang/NoSuchMethodException
    //   131	147	375	java/lang/NoSuchMethodException
    //   147	167	387	java/lang/NoSuchMethodException
    //   120	126	399	java/lang/ClassNotFoundException
    //   131	147	399	java/lang/ClassNotFoundException
    //   147	167	412	java/lang/ClassNotFoundException
  }
  
  public static Platform get()
  {
    return PLATFORM;
  }
  
  static <T> T readFieldOrNull(Object paramObject, Class<T> paramClass, String paramString)
  {
    Object localObject3 = null;
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject1 = localClass.getDeclaredField(paramString);
        ((Field)localObject1).setAccessible(true);
        Object localObject4 = ((Field)localObject1).get(paramObject);
        localObject1 = localObject3;
        if (localObject4 == null) {
          break label123;
        }
        if (!paramClass.isInstance(localObject4)) {
          return null;
        }
        localObject1 = paramClass.cast(localObject4);
        return localObject1;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    Object localObject2 = localObject3;
    if (!paramString.equals("delegate"))
    {
      paramObject = readFieldOrNull(paramObject, Object.class, "delegate");
      localObject2 = localObject3;
      if (paramObject != null) {
        localObject2 = readFieldOrNull(paramObject, paramClass, paramString);
      }
    }
    label123:
    return localObject2;
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket) {}
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public String getPrefix()
  {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void log(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void logW(String paramString)
  {
    System.out.println(paramString);
  }
  
  public void tagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    return null;
  }
  
  public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
  {
    return new RealTrustRootIndex(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public void untagSocket(Socket paramSocket)
    throws SocketException
  {}
  
  private static class Android
    extends Platform
  {
    private static final int MAX_LOG_LENGTH = 4000;
    private final OptionalMethod<Socket> getAlpnSelectedProtocol;
    private final OptionalMethod<Socket> setAlpnProtocols;
    private final OptionalMethod<Socket> setHostname;
    private final OptionalMethod<Socket> setUseSessionTickets;
    private final Class<?> sslParametersClass;
    private final Method trafficStatsTagSocket;
    private final Method trafficStatsUntagSocket;
    
    public Android(Class<?> paramClass, OptionalMethod<Socket> paramOptionalMethod1, OptionalMethod<Socket> paramOptionalMethod2, Method paramMethod1, Method paramMethod2, OptionalMethod<Socket> paramOptionalMethod3, OptionalMethod<Socket> paramOptionalMethod4)
    {
      this.sslParametersClass = paramClass;
      this.setUseSessionTickets = paramOptionalMethod1;
      this.setHostname = paramOptionalMethod2;
      this.trafficStatsTagSocket = paramMethod1;
      this.trafficStatsUntagSocket = paramMethod2;
      this.getAlpnSelectedProtocol = paramOptionalMethod3;
      this.setAlpnProtocols = paramOptionalMethod4;
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      if (paramString != null)
      {
        this.setUseSessionTickets.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
        this.setHostname.invokeOptionalWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
      if ((this.setAlpnProtocols != null) && (this.setAlpnProtocols.isSupported(paramSSLSocket)))
      {
        paramString = concatLengthPrefixed(paramList);
        this.setAlpnProtocols.invokeWithoutCheckedException(paramSSLSocket, new Object[] { paramString });
      }
    }
    
    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (AssertionError paramSocket)
      {
        if (Util.isAndroidGetsocknameError(paramSocket)) {
          throw new IOException(paramSocket);
        }
        throw paramSocket;
      }
      catch (SecurityException paramSocket)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (this.getAlpnSelectedProtocol == null) {}
      while (!this.getAlpnSelectedProtocol.isSupported(paramSSLSocket)) {
        return null;
      }
      paramSSLSocket = (byte[])this.getAlpnSelectedProtocol.invokeWithoutCheckedException(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null) {}
      for (paramSSLSocket = new String(paramSSLSocket, Util.UTF_8);; paramSSLSocket = null) {
        return paramSSLSocket;
      }
    }
    
    public void log(String paramString)
    {
      int i = 0;
      int m = paramString.length();
      if (i < m)
      {
        int j = paramString.indexOf('\n', i);
        if (j != -1) {}
        for (;;)
        {
          int k = Math.min(j, i + 4000);
          Log.d("OkHttp", paramString.substring(i, k));
          i = k;
          if (k >= j)
          {
            i = k + 1;
            break;
            j = m;
          }
        }
      }
    }
    
    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsTagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      Object localObject2 = readFieldOrNull(paramSSLSocketFactory, this.sslParametersClass, "sslParameters");
      Object localObject1 = localObject2;
      if (localObject2 == null) {}
      try
      {
        localObject1 = readFieldOrNull(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
        paramSSLSocketFactory = (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "x509TrustManager");
        if (paramSSLSocketFactory != null) {
          return paramSSLSocketFactory;
        }
      }
      catch (ClassNotFoundException paramSSLSocketFactory)
      {
        return null;
      }
      return (X509TrustManager)readFieldOrNull(localObject1, X509TrustManager.class, "trustManager");
    }
    
    public TrustRootIndex trustRootIndex(X509TrustManager paramX509TrustManager)
    {
      TrustRootIndex localTrustRootIndex = AndroidTrustRootIndex.get(paramX509TrustManager);
      if (localTrustRootIndex != null) {
        return localTrustRootIndex;
      }
      return super.trustRootIndex(paramX509TrustManager);
    }
    
    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsUntagSocket == null) {
        return;
      }
      try
      {
        this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException paramSocket)
      {
        throw new RuntimeException(paramSocket);
      }
      catch (InvocationTargetException paramSocket)
      {
        throw new RuntimeException(paramSocket.getCause());
      }
    }
  }
  
  private static class JdkPlatform
    extends Platform
  {
    private final Class<?> sslContextClass;
    
    public JdkPlatform(Class<?> paramClass)
    {
      this.sslContextClass = paramClass;
    }
    
    public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
    {
      paramSSLSocketFactory = readFieldOrNull(paramSSLSocketFactory, this.sslContextClass, "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      return (X509TrustManager)readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
    }
  }
  
  private static class JdkWithJettyBootPlatform
    extends Platform.JdkPlatform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;
    
    public JdkWithJettyBootPlatform(Class<?> paramClass1, Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass2, Class<?> paramClass3)
    {
      super();
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.removeMethod = paramMethod3;
      this.clientProviderClass = paramClass2;
      this.serverProviderClass = paramClass3;
    }
    
    public void afterHandshake(SSLSocket paramSSLSocket)
    {
      try
      {
        this.removeMethod.invoke(null, new Object[] { paramSSLSocket });
        return;
      }
      catch (IllegalAccessException|InvocationTargetException paramSSLSocket)
      {
        throw new AssertionError();
      }
    }
    
    public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
    {
      paramString = new ArrayList(paramList.size());
      int i = 0;
      int j = paramList.size();
      Object localObject;
      if (i < j)
      {
        localObject = (Protocol)paramList.get(i);
        if (localObject == Protocol.HTTP_1_0) {}
        for (;;)
        {
          i += 1;
          break;
          paramString.add(((Protocol)localObject).toString());
        }
      }
      try
      {
        paramList = Platform.class.getClassLoader();
        localObject = this.clientProviderClass;
        Class localClass = this.serverProviderClass;
        paramString = new Platform.JettyNegoProvider(paramString);
        paramString = Proxy.newProxyInstance(paramList, new Class[] { localObject, localClass }, paramString);
        this.putMethod.invoke(null, new Object[] { paramSSLSocket, paramString });
        return;
      }
      catch (InvocationTargetException|IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError(paramSSLSocket);
      }
    }
    
    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        paramSSLSocket = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$000(paramSSLSocket)) && (Platform.JettyNegoProvider.access$100(paramSSLSocket) == null))
        {
          Internal.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$000(paramSSLSocket))
        {
          paramSSLSocket = Platform.JettyNegoProvider.access$100(paramSSLSocket);
          return paramSSLSocket;
        }
      }
      catch (InvocationTargetException|IllegalAccessException paramSSLSocket)
      {
        throw new AssertionError();
      }
      return null;
    }
  }
  
  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;
    
    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = Util.EMPTY_STRING_ARRAY;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.protocols;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int i = 0;
        int j = paramObject.size();
        while (i < j)
        {
          if (this.protocols.contains(paramObject.get(i)))
          {
            paramObject = (String)paramObject.get(i);
            this.selected = paramObject;
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.protocols.get(0);
        this.selected = paramObject;
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.selected = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.Platform
 * JD-Core Version:    0.7.0.1
 */