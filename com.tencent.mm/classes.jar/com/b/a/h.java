package com.b.a;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class h
  implements p
{
  private final com.b.a.c.b cAN;
  private final com.b.a.b.b cAO;
  q cBh;
  private HttpURLConnection connection;
  private InputStream inputStream;
  
  public h(h paramh)
  {
    this.cBh = paramh.cBh;
    this.cAN = paramh.cAN;
    this.cAO = paramh.cAO;
  }
  
  public h(String paramString, com.b.a.c.b paramb, com.b.a.b.b paramb1)
  {
    AppMethodBeat.i(183583);
    this.cAN = ((com.b.a.c.b)l.checkNotNull(paramb));
    this.cAO = ((com.b.a.b.b)l.checkNotNull(paramb1));
    paramb = paramb.ck(paramString);
    if (paramb != null)
    {
      paramString = paramb;
      this.cBh = paramString;
      AppMethodBeat.o(183583);
      return;
    }
    paramb = MimeTypeMap.getSingleton();
    paramb1 = MimeTypeMap.getFileExtensionFromUrl(paramString);
    if (TextUtils.isEmpty(paramb1)) {}
    for (paramb = null;; paramb = paramb.getMimeTypeFromExtension(paramb1))
    {
      paramString = new q(paramString, -2147483648L, paramb);
      break;
    }
  }
  
  /* Error */
  private void OS()
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 85	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 87
    //   11: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   18: getfield 94	com/b/a/q:url	Ljava/lang/String;
    //   21: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: invokestatic 103	com/b/a/k:OU	()V
    //   28: aload_0
    //   29: lconst_0
    //   30: sipush 10000
    //   33: invokespecial 106	com/b/a/h:i	(JI)Ljava/net/HttpURLConnection;
    //   36: astore_3
    //   37: aload_3
    //   38: invokestatic 110	com/b/a/h:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   41: lstore_1
    //   42: aload_3
    //   43: invokevirtual 116	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   46: astore 7
    //   48: aload_3
    //   49: invokevirtual 120	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   52: astore 4
    //   54: aload 4
    //   56: astore 6
    //   58: aload_3
    //   59: astore 5
    //   61: aload_0
    //   62: new 71	com/b/a/q
    //   65: dup
    //   66: aload_0
    //   67: getfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   70: getfield 94	com/b/a/q:url	Ljava/lang/String;
    //   73: lload_1
    //   74: aload 7
    //   76: invokespecial 76	com/b/a/q:<init>	(Ljava/lang/String;JLjava/lang/String;)V
    //   79: putfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   82: aload 4
    //   84: astore 6
    //   86: aload_3
    //   87: astore 5
    //   89: aload_0
    //   90: getfield 25	com/b/a/h:cAN	Lcom/b/a/c/b;
    //   93: aload_0
    //   94: getfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   97: getfield 94	com/b/a/q:url	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   104: invokeinterface 124 3 0
    //   109: aload 4
    //   111: astore 6
    //   113: aload_3
    //   114: astore 5
    //   116: new 85	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 126
    //   122: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   129: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: astore 6
    //   137: aload_3
    //   138: astore 5
    //   140: invokestatic 103	com/b/a/k:OU	()V
    //   143: aload 4
    //   145: invokestatic 135	com/b/a/o:close	(Ljava/io/Closeable;)V
    //   148: aload_3
    //   149: ifnull +103 -> 252
    //   152: aload_3
    //   153: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   156: ldc 83
    //   158: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: astore_3
    //   163: aconst_null
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_3
    //   168: aload 4
    //   170: astore 6
    //   172: aload_3
    //   173: astore 5
    //   175: new 85	java/lang/StringBuilder
    //   178: dup
    //   179: ldc 140
    //   181: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield 23	com/b/a/h:cBh	Lcom/b/a/q;
    //   188: getfield 94	com/b/a/q:url	Ljava/lang/String;
    //   191: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 4
    //   197: astore 6
    //   199: aload_3
    //   200: astore 5
    //   202: invokestatic 143	com/b/a/k:OX	()V
    //   205: aload 4
    //   207: invokestatic 135	com/b/a/o:close	(Ljava/io/Closeable;)V
    //   210: aload_3
    //   211: ifnull +41 -> 252
    //   214: aload_3
    //   215: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   218: ldc 83
    //   220: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: return
    //   224: astore 4
    //   226: aconst_null
    //   227: astore 5
    //   229: aconst_null
    //   230: astore_3
    //   231: aload 5
    //   233: invokestatic 135	com/b/a/o:close	(Ljava/io/Closeable;)V
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 138	java/net/HttpURLConnection:disconnect	()V
    //   244: ldc 83
    //   246: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload 4
    //   251: athrow
    //   252: ldc 83
    //   254: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: return
    //   258: astore 4
    //   260: aconst_null
    //   261: astore 5
    //   263: goto -32 -> 231
    //   266: astore 4
    //   268: aload 5
    //   270: astore_3
    //   271: aload 6
    //   273: astore 5
    //   275: goto -44 -> 231
    //   278: astore 4
    //   280: aconst_null
    //   281: astore 4
    //   283: goto -115 -> 168
    //   286: astore 5
    //   288: goto -120 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	h
    //   41	33	1	l	long
    //   36	117	3	localHttpURLConnection	HttpURLConnection
    //   162	1	3	localIOException1	IOException
    //   167	104	3	localObject1	Object
    //   52	154	4	localInputStream1	InputStream
    //   224	26	4	localObject2	Object
    //   258	1	4	localObject3	Object
    //   266	1	4	localObject4	Object
    //   278	1	4	localIOException2	IOException
    //   281	1	4	localObject5	Object
    //   59	215	5	localObject6	Object
    //   286	1	5	localIOException3	IOException
    //   56	216	6	localInputStream2	InputStream
    //   46	29	7	str	String
    // Exception table:
    //   from	to	target	type
    //   28	37	162	java/io/IOException
    //   28	37	224	finally
    //   37	54	258	finally
    //   61	82	266	finally
    //   89	109	266	finally
    //   116	133	266	finally
    //   140	143	266	finally
    //   175	195	266	finally
    //   202	205	266	finally
    //   37	54	278	java/io/IOException
    //   61	82	286	java/io/IOException
    //   89	109	286	java/io/IOException
    //   116	133	286	java/io/IOException
    //   140	143	286	java/io/IOException
  }
  
  private long a(HttpURLConnection paramHttpURLConnection, long paramLong, int paramInt)
  {
    AppMethodBeat.i(183586);
    long l = getContentLength(paramHttpURLConnection);
    if (paramInt == 200)
    {
      AppMethodBeat.o(183586);
      return l;
    }
    if (paramInt == 206)
    {
      AppMethodBeat.o(183586);
      return l + paramLong;
    }
    paramLong = this.cBh.length;
    AppMethodBeat.o(183586);
    return paramLong;
  }
  
  private void a(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(183592);
    Iterator localIterator = this.cAO.Pa().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(183592);
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(183587);
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Length");
    if (paramHttpURLConnection == null)
    {
      AppMethodBeat.o(183587);
      return -1L;
    }
    long l = Long.parseLong(paramHttpURLConnection);
    AppMethodBeat.o(183587);
    return l;
  }
  
  private HttpURLConnection i(long paramLong, int paramInt)
  {
    AppMethodBeat.i(183591);
    Object localObject1 = this.cBh.url;
    int i = 0;
    Object localObject2;
    int j;
    label244:
    label250:
    do
    {
      StringBuilder localStringBuilder = new StringBuilder("Open connection ");
      if (paramLong > 0L)
      {
        localObject2 = " with offset ".concat(String.valueOf(paramLong));
        localStringBuilder.append((String)localObject2).append(" to ").append((String)localObject1);
        k.OU();
        localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
        a((HttpURLConnection)localObject2);
        if (paramLong > 0L) {
          ((HttpURLConnection)localObject2).setRequestProperty("Range", "bytes=" + paramLong + "-");
        }
        if (paramInt > 0)
        {
          ((HttpURLConnection)localObject2).setConnectTimeout(paramInt);
          ((HttpURLConnection)localObject2).setReadTimeout(paramInt);
        }
        j = ((HttpURLConnection)localObject2).getResponseCode();
        if ((j != 301) && (j != 302) && (j != 303)) {
          break label244;
        }
      }
      int k;
      for (j = 1;; j = 0)
      {
        k = i;
        if (j != 0)
        {
          localObject1 = ((HttpURLConnection)localObject2).getHeaderField("Location");
          k = i + 1;
          ((HttpURLConnection)localObject2).disconnect();
        }
        if (k <= 5) {
          break label250;
        }
        localObject1 = new n("Too many redirects: ".concat(String.valueOf(k)));
        AppMethodBeat.o(183591);
        throw ((Throwable)localObject1);
        localObject2 = "";
        break;
      }
      i = k;
    } while (j != 0);
    AppMethodBeat.o(183591);
    return localObject2;
  }
  
  public final String OT()
  {
    try
    {
      AppMethodBeat.i(183593);
      if (TextUtils.isEmpty(this.cBh.cBw)) {
        OS();
      }
      String str = this.cBh.cBw;
      AppMethodBeat.o(183593);
      return str;
    }
    finally {}
  }
  
  public final void bF(long paramLong)
  {
    AppMethodBeat.i(183585);
    try
    {
      this.connection = i(paramLong, -1);
      String str = this.connection.getContentType();
      this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
      long l = a(this.connection, paramLong, this.connection.getResponseCode());
      this.cBh = new q(this.cBh.url, l, str);
      this.cAN.a(this.cBh.url, this.cBh);
      AppMethodBeat.o(183585);
      return;
    }
    catch (IOException localIOException)
    {
      n localn = new n("Error opening connection for " + this.cBh.url + " with offset " + paramLong, localIOException);
      AppMethodBeat.o(183585);
      throw localn;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(183588);
    if (this.connection != null) {}
    try
    {
      this.connection.disconnect();
      AppMethodBeat.o(183588);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", localNullPointerException);
      AppMethodBeat.o(183588);
      throw localRuntimeException;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      k.OX();
      AppMethodBeat.o(183588);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label28:
      break label28;
    }
  }
  
  public final long length()
  {
    try
    {
      AppMethodBeat.i(183584);
      if (this.cBh.length == -2147483648L) {
        OS();
      }
      long l = this.cBh.length;
      AppMethodBeat.o(183584);
      return l;
    }
    finally {}
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183589);
    if (this.inputStream == null)
    {
      paramArrayOfByte = new n("Error reading data from " + this.cBh.url + ": connection is absent!");
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
    try
    {
      int i = this.inputStream.read(paramArrayOfByte, 0, 8192);
      AppMethodBeat.o(183589);
      return i;
    }
    catch (InterruptedIOException paramArrayOfByte)
    {
      paramArrayOfByte = new j("Reading source " + this.cBh.url + " is interrupted", paramArrayOfByte);
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new n("Error reading data from " + this.cBh.url, paramArrayOfByte);
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183594);
    String str = "HttpUrlSource{sourceInfo='" + this.cBh + "}";
    AppMethodBeat.o(183594);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.h
 * JD-Core Version:    0.7.0.1
 */