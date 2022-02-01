package com.tencent.beacon.upload;

import android.content.Context;
import android.net.Proxy;
import com.tencent.beacon.d.b;
import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public abstract class e
{
  private static e a = null;
  
  public static e a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public abstract byte[] a(String paramString, byte[] paramArrayOfByte, d paramd, a parama);
  
  public static final class a
    extends e
  {
    private Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    /* Error */
    private HttpResponse a(String paramString1, byte[] paramArrayOfByte, String paramString2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: aload_1
      //   7: ifnonnull +17 -> 24
      //   10: ldc 21
      //   12: iconst_0
      //   13: anewarray 23	java/lang/Object
      //   16: invokestatic 29	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   19: aload 4
      //   21: astore_1
      //   22: aload_1
      //   23: areturn
      //   24: aload_2
      //   25: ifnull +80 -> 105
      //   28: new 31	org/apache/http/entity/ByteArrayEntity
      //   31: dup
      //   32: aload_2
      //   33: invokespecial 34	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
      //   36: astore_2
      //   37: aload_0
      //   38: aload_3
      //   39: invokespecial 37	com/tencent/beacon/upload/e$a:a	(Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
      //   42: astore 4
      //   44: aload 4
      //   46: ifnonnull +90 -> 136
      //   49: ldc 39
      //   51: iconst_0
      //   52: anewarray 23	java/lang/Object
      //   55: invokestatic 29	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   58: aconst_null
      //   59: areturn
      //   60: astore 4
      //   62: aconst_null
      //   63: astore_3
      //   64: aload 5
      //   66: astore_2
      //   67: aload_3
      //   68: astore_1
      //   69: aload 4
      //   71: invokevirtual 42	java/lang/Throwable:printStackTrace	()V
      //   74: aload_3
      //   75: astore_1
      //   76: ldc 44
      //   78: iconst_1
      //   79: anewarray 23	java/lang/Object
      //   82: dup
      //   83: iconst_0
      //   84: aload 4
      //   86: invokevirtual 48	java/lang/Throwable:toString	()Ljava/lang/String;
      //   89: aastore
      //   90: invokestatic 29	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   93: aload_2
      //   94: astore_1
      //   95: aload_3
      //   96: ifnull -74 -> 22
      //   99: aload_3
      //   100: invokevirtual 53	org/apache/http/client/methods/HttpPost:abort	()V
      //   103: aload_2
      //   104: areturn
      //   105: new 31	org/apache/http/entity/ByteArrayEntity
      //   108: dup
      //   109: ldc 55
      //   111: invokevirtual 61	java/lang/String:getBytes	()[B
      //   114: invokespecial 34	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
      //   117: astore_2
      //   118: goto -81 -> 37
      //   121: astore_1
      //   122: aconst_null
      //   123: astore_3
      //   124: aload_1
      //   125: astore_2
      //   126: aload_3
      //   127: ifnull +7 -> 134
      //   130: aload_3
      //   131: invokevirtual 53	org/apache/http/client/methods/HttpPost:abort	()V
      //   134: aload_2
      //   135: athrow
      //   136: new 50	org/apache/http/client/methods/HttpPost
      //   139: dup
      //   140: aload_1
      //   141: invokespecial 64	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
      //   144: astore_3
      //   145: aload_3
      //   146: astore_1
      //   147: aload_3
      //   148: ldc 66
      //   150: ldc 68
      //   152: invokevirtual 72	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   155: aload_3
      //   156: astore_1
      //   157: aload_3
      //   158: ldc 74
      //   160: ldc 76
      //   162: invokevirtual 72	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
      //   165: aload_3
      //   166: astore_1
      //   167: aload_3
      //   168: aload_2
      //   169: invokevirtual 80	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
      //   172: aload_3
      //   173: astore_1
      //   174: new 82	org/apache/http/protocol/BasicHttpContext
      //   177: dup
      //   178: invokespecial 83	org/apache/http/protocol/BasicHttpContext:<init>	()V
      //   181: astore 6
      //   183: aload_3
      //   184: astore_1
      //   185: aload 4
      //   187: aload_3
      //   188: aload 6
      //   190: invokeinterface 89 3 0
      //   195: astore_2
      //   196: aload_3
      //   197: astore_1
      //   198: ldc 91
      //   200: iconst_1
      //   201: anewarray 23	java/lang/Object
      //   204: dup
      //   205: iconst_0
      //   206: aload 6
      //   208: ldc 93
      //   210: invokeinterface 99 2 0
      //   215: checkcast 101	org/apache/http/HttpRequest
      //   218: invokeinterface 105 1 0
      //   223: invokevirtual 106	java/lang/Object:toString	()Ljava/lang/String;
      //   226: aastore
      //   227: invokestatic 109	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   230: aload_3
      //   231: invokevirtual 53	org/apache/http/client/methods/HttpPost:abort	()V
      //   234: aload_2
      //   235: areturn
      //   236: astore_2
      //   237: aload_1
      //   238: astore_3
      //   239: goto -113 -> 126
      //   242: astore 4
      //   244: aload 5
      //   246: astore_2
      //   247: goto -180 -> 67
      //   250: astore 4
      //   252: goto -185 -> 67
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	255	0	this	a
      //   0	255	1	paramString1	String
      //   0	255	2	paramArrayOfByte	byte[]
      //   0	255	3	paramString2	String
      //   4	41	4	localHttpClient	HttpClient
      //   60	126	4	localThrowable1	Throwable
      //   242	1	4	localThrowable2	Throwable
      //   250	1	4	localThrowable3	Throwable
      //   1	244	5	localObject	Object
      //   181	26	6	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
      // Exception table:
      //   from	to	target	type
      //   28	37	60	java/lang/Throwable
      //   37	44	60	java/lang/Throwable
      //   49	58	60	java/lang/Throwable
      //   105	118	60	java/lang/Throwable
      //   136	145	60	java/lang/Throwable
      //   28	37	121	finally
      //   37	44	121	finally
      //   49	58	121	finally
      //   105	118	121	finally
      //   136	145	121	finally
      //   69	74	236	finally
      //   76	93	236	finally
      //   147	155	236	finally
      //   157	165	236	finally
      //   167	172	236	finally
      //   174	183	236	finally
      //   185	196	236	finally
      //   198	230	236	finally
      //   147	155	242	java/lang/Throwable
      //   157	165	242	java/lang/Throwable
      //   167	172	242	java/lang/Throwable
      //   174	183	242	java/lang/Throwable
      //   185	196	242	java/lang/Throwable
      //   198	230	250	java/lang/Throwable
    }
    
    private HttpClient a(String paramString)
    {
      try
      {
        Object localObject = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject, 10000);
        HttpConnectionParams.setSocketBufferSize((HttpParams)localObject, 2000);
        ((BasicHttpParams)localObject).setBooleanParameter("http.protocol.handle-redirects", false);
        localObject = new DefaultHttpClient((HttpParams)localObject);
        ((DefaultHttpClient)localObject).setHttpRequestRetryHandler(new HttpRequestRetryHandler()
        {
          public final boolean retryRequest(IOException paramAnonymousIOException, int paramAnonymousInt, HttpContext paramAnonymousHttpContext)
          {
            return false;
          }
        });
        if ((paramString != null) && (paramString.toLowerCase(Locale.US).contains("wap")))
        {
          com.tencent.beacon.d.a.a("use proxy: %s", new Object[] { paramString });
          paramString = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort());
          ((DefaultHttpClient)localObject).getParams().setParameter("http.route.default-proxy", paramString);
          return localObject;
        }
        ((DefaultHttpClient)localObject).getParams().removeParameter("http.route.default-proxy");
        return localObject;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        com.tencent.beacon.d.a.d("httpclient error!", new Object[0]);
      }
      return null;
    }
    
    /* Error */
    private static byte[] a(HttpResponse paramHttpResponse)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnonnull +5 -> 6
      //   4: aconst_null
      //   5: areturn
      //   6: aload_0
      //   7: invokeinterface 201 1 0
      //   12: invokeinterface 206 1 0
      //   17: istore_1
      //   18: iload_1
      //   19: sipush 200
      //   22: if_icmpeq +30 -> 52
      //   25: ldc 208
      //   27: iconst_2
      //   28: anewarray 23	java/lang/Object
      //   31: dup
      //   32: iconst_0
      //   33: iload_1
      //   34: invokestatic 214	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   37: aastore
      //   38: dup
      //   39: iconst_1
      //   40: aload_0
      //   41: invokeinterface 201 1 0
      //   46: aastore
      //   47: invokestatic 217	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   50: aconst_null
      //   51: areturn
      //   52: aload_0
      //   53: invokeinterface 221 1 0
      //   58: astore_0
      //   59: aload_0
      //   60: ifnonnull +14 -> 74
      //   63: ldc 223
      //   65: iconst_0
      //   66: anewarray 23	java/lang/Object
      //   69: invokestatic 29	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   72: aconst_null
      //   73: areturn
      //   74: new 225	java/io/BufferedInputStream
      //   77: dup
      //   78: new 227	java/io/DataInputStream
      //   81: dup
      //   82: aload_0
      //   83: invokeinterface 233 1 0
      //   88: invokespecial 236	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   91: invokespecial 237	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   94: astore_2
      //   95: aload_2
      //   96: astore_0
      //   97: new 239	java/io/ByteArrayOutputStream
      //   100: dup
      //   101: invokespecial 240	java/io/ByteArrayOutputStream:<init>	()V
      //   104: astore_3
      //   105: aload_2
      //   106: astore_0
      //   107: aload_2
      //   108: invokevirtual 243	java/io/BufferedInputStream:read	()I
      //   111: istore_1
      //   112: iload_1
      //   113: iconst_m1
      //   114: if_icmpeq +55 -> 169
      //   117: aload_2
      //   118: astore_0
      //   119: aload_3
      //   120: iload_1
      //   121: invokevirtual 247	java/io/ByteArrayOutputStream:write	(I)V
      //   124: goto -19 -> 105
      //   127: astore_3
      //   128: aload_2
      //   129: astore_0
      //   130: aload_3
      //   131: invokevirtual 42	java/lang/Throwable:printStackTrace	()V
      //   134: aload_2
      //   135: astore_0
      //   136: ldc 249
      //   138: iconst_1
      //   139: anewarray 23	java/lang/Object
      //   142: dup
      //   143: iconst_0
      //   144: aload_3
      //   145: invokevirtual 48	java/lang/Throwable:toString	()Ljava/lang/String;
      //   148: aastore
      //   149: invokestatic 29	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   152: aload_2
      //   153: ifnull -149 -> 4
      //   156: aload_2
      //   157: invokevirtual 252	java/io/BufferedInputStream:close	()V
      //   160: aconst_null
      //   161: areturn
      //   162: astore_0
      //   163: aload_0
      //   164: invokevirtual 42	java/lang/Throwable:printStackTrace	()V
      //   167: aconst_null
      //   168: areturn
      //   169: aload_2
      //   170: astore_0
      //   171: aload_3
      //   172: invokevirtual 255	java/io/ByteArrayOutputStream:flush	()V
      //   175: aload_2
      //   176: astore_0
      //   177: aload_3
      //   178: invokevirtual 258	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   181: astore_3
      //   182: aload_2
      //   183: invokevirtual 252	java/io/BufferedInputStream:close	()V
      //   186: aload_3
      //   187: areturn
      //   188: astore_0
      //   189: aload_0
      //   190: invokevirtual 42	java/lang/Throwable:printStackTrace	()V
      //   193: aload_3
      //   194: areturn
      //   195: astore_2
      //   196: aconst_null
      //   197: astore_0
      //   198: aload_0
      //   199: ifnull +7 -> 206
      //   202: aload_0
      //   203: invokevirtual 252	java/io/BufferedInputStream:close	()V
      //   206: aload_2
      //   207: athrow
      //   208: astore_0
      //   209: aload_0
      //   210: invokevirtual 42	java/lang/Throwable:printStackTrace	()V
      //   213: goto -7 -> 206
      //   216: astore_2
      //   217: goto -19 -> 198
      //   220: astore_3
      //   221: aconst_null
      //   222: astore_2
      //   223: goto -95 -> 128
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	226	0	paramHttpResponse	HttpResponse
      //   17	104	1	i	int
      //   94	89	2	localBufferedInputStream	java.io.BufferedInputStream
      //   195	12	2	localObject1	Object
      //   216	1	2	localObject2	Object
      //   222	1	2	localObject3	Object
      //   104	16	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   127	51	3	localThrowable1	Throwable
      //   181	13	3	arrayOfByte	byte[]
      //   220	1	3	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   97	105	127	java/lang/Throwable
      //   107	112	127	java/lang/Throwable
      //   119	124	127	java/lang/Throwable
      //   171	175	127	java/lang/Throwable
      //   177	182	127	java/lang/Throwable
      //   156	160	162	java/lang/Throwable
      //   182	186	188	java/lang/Throwable
      //   74	95	195	finally
      //   202	206	208	java/lang/Throwable
      //   97	105	216	finally
      //   107	112	216	finally
      //   119	124	216	finally
      //   130	134	216	finally
      //   136	152	216	finally
      //   171	175	216	finally
      //   177	182	216	finally
      //   74	95	220	java/lang/Throwable
    }
    
    public final byte[] a(String paramString, byte[] paramArrayOfByte, d paramd, a parama)
    {
      if (paramString == null)
      {
        com.tencent.beacon.d.a.d("no destUrl!", new Object[0]);
        return null;
      }
      int j = 0;
      int i = 0;
      long l2;
      int k;
      int m;
      label79:
      HttpResponse localHttpResponse;
      int n;
      if (paramArrayOfByte == null)
      {
        l2 = 0L;
        com.tencent.beacon.d.a.h("start req: %s sz:%d", new Object[] { paramString, Long.valueOf(l2) });
        k = 0;
        m = j + 1;
        if ((j >= 3) || (i >= 2)) {
          break label500;
        }
        if (k == 0) {
          break label198;
        }
        j = 0;
        Object localObject = b.c(this.a);
        if (paramd != null) {
          paramd.a(paramString, l2, (String)localObject);
        }
        localHttpResponse = a(paramString, paramArrayOfByte, (String)localObject);
        if (localHttpResponse == null) {
          break label480;
        }
        localObject = localHttpResponse.getEntity();
        n = localHttpResponse.getStatusLine().getStatusCode();
        com.tencent.beacon.d.a.h("response code:%d ", new Object[] { Integer.valueOf(n) });
        if (n != 200) {
          break label289;
        }
        paramString = a(localHttpResponse);
        if (paramd != null) {
          if (paramString != null) {
            break label281;
          }
        }
      }
      label281:
      for (long l1 = 0L;; l1 = paramString.length)
      {
        for (;;)
        {
          paramd.a(l1);
          return paramString;
          l2 = paramArrayOfByte.length;
          break;
          label198:
          j = k;
          if (m <= 1) {
            break label79;
          }
          com.tencent.beacon.d.a.h("try time:" + m, new Object[0]);
          if ((m == 2) && (parama.c() == 2)) {
            parama.b(false);
          }
          try
          {
            Thread.sleep(5000L);
            j = k;
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            j = k;
          }
        }
        break label79;
      }
      label289:
      if ((n == 301) || (n == 302) || (n == 303) || (n == 307)) {
        k = 1;
      }
      while (k != 0)
      {
        k = 1;
        paramString = localHttpResponse.getFirstHeader("Location");
        if (paramString == null)
        {
          com.tencent.beacon.d.a.d("redirect code:" + n + " Location is null! return", new Object[0]);
          return null;
          k = 0;
        }
        else
        {
          j = i + 1;
          i = 0;
          paramString = paramString.getValue();
          com.tencent.beacon.d.a.h("redirect code:%d , to:%s", new Object[] { Integer.valueOf(n), paramString });
        }
      }
      for (;;)
      {
        l1 = 0L;
        if (localInterruptedException != null)
        {
          long l3 = localInterruptedException.getContentLength();
          l1 = l3;
          if (l3 < 0L) {
            l1 = 0L;
          }
        }
        if (paramd != null) {
          paramd.a(l1);
        }
        m = i;
        i = j;
        j = m;
        break;
        label480:
        if (paramd != null) {
          paramd.a(0L);
        }
        k = j;
        j = m;
        break;
        label500:
        return null;
        k = j;
        j = i;
        i = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.e
 * JD-Core Version:    0.7.0.1
 */