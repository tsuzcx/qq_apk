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
  private final com.b.a.c.b aFb;
  private final com.b.a.b.b aFc;
  q aFv;
  private InputStream aFw;
  private HttpURLConnection connection;
  
  public h(h paramh)
  {
    this.aFv = paramh.aFv;
    this.aFb = paramh.aFb;
    this.aFc = paramh.aFc;
  }
  
  public h(String paramString, com.b.a.c.b paramb, com.b.a.b.b paramb1)
  {
    AppMethodBeat.i(183583);
    this.aFb = ((com.b.a.c.b)l.checkNotNull(paramb));
    this.aFc = ((com.b.a.b.b)l.checkNotNull(paramb1));
    paramb = paramb.aX(paramString);
    if (paramb != null)
    {
      paramString = paramb;
      this.aFv = paramString;
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
  
  private static long a(HttpURLConnection paramHttpURLConnection)
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
  
  private long a(HttpURLConnection paramHttpURLConnection, long paramLong, int paramInt)
  {
    AppMethodBeat.i(183586);
    long l = a(paramHttpURLConnection);
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
    paramLong = this.aFv.aFL;
    AppMethodBeat.o(183586);
    return paramLong;
  }
  
  private HttpURLConnection b(long paramLong, int paramInt)
  {
    AppMethodBeat.i(183591);
    Object localObject1 = this.aFv.url;
    int i = 0;
    Object localObject2;
    int j;
    label242:
    label248:
    do
    {
      StringBuilder localStringBuilder = new StringBuilder("Open connection ");
      if (paramLong > 0L)
      {
        localObject2 = " with offset ".concat(String.valueOf(paramLong));
        localStringBuilder.append((String)localObject2).append(" to ").append((String)localObject1);
        k.pn();
        localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
        b((HttpURLConnection)localObject2);
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
          break label242;
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
          break label248;
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
  
  private void b(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(183592);
    Iterator localIterator = this.aFc.pt().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(183592);
  }
  
  /* Error */
  private void pl()
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 114	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 234
    //   11: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   18: getfield 112	com/b/a/q:url	Ljava/lang/String;
    //   21: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: invokestatic 141	com/b/a/k:pn	()V
    //   28: aload_0
    //   29: lconst_0
    //   30: sipush 10000
    //   33: invokespecial 236	com/b/a/h:b	(JI)Ljava/net/HttpURLConnection;
    //   36: astore_3
    //   37: aload_3
    //   38: invokestatic 101	com/b/a/h:a	(Ljava/net/HttpURLConnection;)J
    //   41: lstore_1
    //   42: aload_3
    //   43: invokevirtual 239	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   46: astore 7
    //   48: aload_3
    //   49: invokevirtual 243	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   52: astore 4
    //   54: aload 4
    //   56: astore 6
    //   58: aload_3
    //   59: astore 5
    //   61: aload_0
    //   62: new 71	com/b/a/q
    //   65: dup
    //   66: aload_0
    //   67: getfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   70: getfield 112	com/b/a/q:url	Ljava/lang/String;
    //   73: lload_1
    //   74: aload 7
    //   76: invokespecial 76	com/b/a/q:<init>	(Ljava/lang/String;JLjava/lang/String;)V
    //   79: putfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   82: aload 4
    //   84: astore 6
    //   86: aload_3
    //   87: astore 5
    //   89: aload_0
    //   90: getfield 25	com/b/a/h:aFb	Lcom/b/a/c/b;
    //   93: aload_0
    //   94: getfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   97: getfield 112	com/b/a/q:url	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   104: invokeinterface 246 3 0
    //   109: aload 4
    //   111: astore 6
    //   113: aload_3
    //   114: astore 5
    //   116: new 114	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 248
    //   122: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: getfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   129: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 4
    //   135: astore 6
    //   137: aload_3
    //   138: astore 5
    //   140: invokestatic 141	com/b/a/k:pn	()V
    //   143: aload 4
    //   145: invokestatic 257	com/b/a/o:close	(Ljava/io/Closeable;)V
    //   148: aload_3
    //   149: ifnull +104 -> 253
    //   152: aload_3
    //   153: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   156: ldc 232
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
    //   175: new 114	java/lang/StringBuilder
    //   178: dup
    //   179: ldc_w 259
    //   182: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_0
    //   186: getfield 23	com/b/a/h:aFv	Lcom/b/a/q;
    //   189: getfield 112	com/b/a/q:url	Ljava/lang/String;
    //   192: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore 6
    //   200: aload_3
    //   201: astore 5
    //   203: invokestatic 262	com/b/a/k:pq	()V
    //   206: aload 4
    //   208: invokestatic 257	com/b/a/o:close	(Ljava/io/Closeable;)V
    //   211: aload_3
    //   212: ifnull +41 -> 253
    //   215: aload_3
    //   216: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   219: ldc 232
    //   221: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: astore 4
    //   227: aconst_null
    //   228: astore 5
    //   230: aconst_null
    //   231: astore_3
    //   232: aload 5
    //   234: invokestatic 257	com/b/a/o:close	(Ljava/io/Closeable;)V
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   245: ldc 232
    //   247: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload 4
    //   252: athrow
    //   253: ldc 232
    //   255: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: return
    //   259: astore 4
    //   261: aconst_null
    //   262: astore 5
    //   264: goto -32 -> 232
    //   267: astore 4
    //   269: aload 5
    //   271: astore_3
    //   272: aload 6
    //   274: astore 5
    //   276: goto -44 -> 232
    //   279: astore 4
    //   281: aconst_null
    //   282: astore 4
    //   284: goto -116 -> 168
    //   287: astore 5
    //   289: goto -121 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	h
    //   41	33	1	l	long
    //   36	117	3	localHttpURLConnection	HttpURLConnection
    //   162	1	3	localIOException1	IOException
    //   167	105	3	localObject1	Object
    //   52	155	4	localInputStream1	InputStream
    //   225	26	4	localObject2	Object
    //   259	1	4	localObject3	Object
    //   267	1	4	localObject4	Object
    //   279	1	4	localIOException2	IOException
    //   282	1	4	localObject5	Object
    //   59	216	5	localObject6	Object
    //   287	1	5	localIOException3	IOException
    //   56	217	6	localInputStream2	InputStream
    //   46	29	7	str	String
    // Exception table:
    //   from	to	target	type
    //   28	37	162	java/io/IOException
    //   28	37	225	finally
    //   37	54	259	finally
    //   61	82	267	finally
    //   89	109	267	finally
    //   116	133	267	finally
    //   140	143	267	finally
    //   175	196	267	finally
    //   203	206	267	finally
    //   37	54	279	java/io/IOException
    //   61	82	287	java/io/IOException
    //   89	109	287	java/io/IOException
    //   116	133	287	java/io/IOException
    //   140	143	287	java/io/IOException
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
      k.pq();
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
      if (this.aFv.aFL == -2147483648L) {
        pl();
      }
      long l = this.aFv.aFL;
      AppMethodBeat.o(183584);
      return l;
    }
    finally {}
  }
  
  public final String pm()
  {
    try
    {
      AppMethodBeat.i(183593);
      if (TextUtils.isEmpty(this.aFv.aFM)) {
        pl();
      }
      String str = this.aFv.aFM;
      AppMethodBeat.o(183593);
      return str;
    }
    finally {}
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183589);
    if (this.aFw == null)
    {
      paramArrayOfByte = new n("Error reading data from " + this.aFv.url + ": connection is absent!");
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
    try
    {
      int i = this.aFw.read(paramArrayOfByte, 0, 8192);
      AppMethodBeat.o(183589);
      return i;
    }
    catch (InterruptedIOException paramArrayOfByte)
    {
      paramArrayOfByte = new j("Reading source " + this.aFv.url + " is interrupted", paramArrayOfByte);
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new n("Error reading data from " + this.aFv.url, paramArrayOfByte);
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
  }
  
  public final void s(long paramLong)
  {
    AppMethodBeat.i(183585);
    try
    {
      this.connection = b(paramLong, -1);
      String str = this.connection.getContentType();
      this.aFw = new BufferedInputStream(this.connection.getInputStream(), 8192);
      long l = a(this.connection, paramLong, this.connection.getResponseCode());
      this.aFv = new q(this.aFv.url, l, str);
      this.aFb.a(this.aFv.url, this.aFv);
      AppMethodBeat.o(183585);
      return;
    }
    catch (IOException localIOException)
    {
      n localn = new n("Error opening connection for " + this.aFv.url + " with offset " + paramLong, localIOException);
      AppMethodBeat.o(183585);
      throw localn;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183594);
    String str = "HttpUrlSource{sourceInfo='" + this.aFv + "}";
    AppMethodBeat.o(183594);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.h
 * JD-Core Version:    0.7.0.1
 */