package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.headers.EmptyHeadersInjector;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
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

public class HttpUrlSource
  implements Source
{
  private static final int MAX_REDIRECTS = 5;
  private HttpURLConnection connection;
  private final HeaderInjector headerInjector;
  private InputStream inputStream;
  private SourceInfo sourceInfo;
  private final SourceInfoStorage sourceInfoStorage;
  
  public HttpUrlSource(HttpUrlSource paramHttpUrlSource)
  {
    this.sourceInfo = paramHttpUrlSource.sourceInfo;
    this.sourceInfoStorage = paramHttpUrlSource.sourceInfoStorage;
    this.headerInjector = paramHttpUrlSource.headerInjector;
  }
  
  public HttpUrlSource(String paramString)
  {
    this(paramString, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    AppMethodBeat.i(215860);
    AppMethodBeat.o(215860);
  }
  
  public HttpUrlSource(String paramString, SourceInfoStorage paramSourceInfoStorage)
  {
    this(paramString, paramSourceInfoStorage, new EmptyHeadersInjector());
    AppMethodBeat.i(215861);
    AppMethodBeat.o(215861);
  }
  
  public HttpUrlSource(String paramString, SourceInfoStorage paramSourceInfoStorage, HeaderInjector paramHeaderInjector)
  {
    AppMethodBeat.i(183583);
    this.sourceInfoStorage = ((SourceInfoStorage)Preconditions.checkNotNull(paramSourceInfoStorage));
    this.headerInjector = ((HeaderInjector)Preconditions.checkNotNull(paramHeaderInjector));
    paramSourceInfoStorage = paramSourceInfoStorage.get(paramString);
    if (paramSourceInfoStorage != null) {}
    for (paramString = paramSourceInfoStorage;; paramString = new SourceInfo(paramString, -2147483648L, ProxyCacheUtils.getSupposablyMime(paramString)))
    {
      this.sourceInfo = paramString;
      AppMethodBeat.o(183583);
      return;
    }
  }
  
  /* Error */
  private void fetchContentInfo()
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 92	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 94
    //   11: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   18: getfield 100	com/danikula/videocache/SourceInfo:url	Ljava/lang/String;
    //   21: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 113	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: lconst_0
    //   32: sipush 10000
    //   35: invokespecial 117	com/danikula/videocache/HttpUrlSource:openConnection	(JI)Ljava/net/HttpURLConnection;
    //   38: astore_3
    //   39: aload_0
    //   40: aload_3
    //   41: invokespecial 121	com/danikula/videocache/HttpUrlSource:getContentLength	(Ljava/net/HttpURLConnection;)J
    //   44: lstore_1
    //   45: aload_3
    //   46: invokevirtual 126	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   49: astore 7
    //   51: aload_3
    //   52: invokevirtual 130	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   55: astore 4
    //   57: aload 4
    //   59: astore 6
    //   61: aload_3
    //   62: astore 5
    //   64: aload_0
    //   65: new 75	com/danikula/videocache/SourceInfo
    //   68: dup
    //   69: aload_0
    //   70: getfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   73: getfield 100	com/danikula/videocache/SourceInfo:url	Ljava/lang/String;
    //   76: lload_1
    //   77: aload 7
    //   79: invokespecial 86	com/danikula/videocache/SourceInfo:<init>	(Ljava/lang/String;JLjava/lang/String;)V
    //   82: putfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   85: aload 4
    //   87: astore 6
    //   89: aload_3
    //   90: astore 5
    //   92: aload_0
    //   93: getfield 28	com/danikula/videocache/HttpUrlSource:sourceInfoStorage	Lcom/danikula/videocache/sourcestorage/SourceInfoStorage;
    //   96: aload_0
    //   97: getfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   100: getfield 100	com/danikula/videocache/SourceInfo:url	Ljava/lang/String;
    //   103: aload_0
    //   104: getfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   107: invokeinterface 134 3 0
    //   112: aload 4
    //   114: astore 6
    //   116: aload_3
    //   117: astore 5
    //   119: new 92	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 136
    //   125: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   132: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 113	com/danikula/videocache/Logger:debug	(Ljava/lang/String;)V
    //   141: aload 4
    //   143: invokestatic 143	com/danikula/videocache/ProxyCacheUtils:close	(Ljava/io/Closeable;)V
    //   146: aload_3
    //   147: ifnull +98 -> 245
    //   150: aload_3
    //   151: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   154: ldc 90
    //   156: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: return
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: aconst_null
    //   165: astore_3
    //   166: aload 4
    //   168: astore 6
    //   170: aload_3
    //   171: astore 5
    //   173: new 92	java/lang/StringBuilder
    //   176: dup
    //   177: ldc 148
    //   179: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload_0
    //   183: getfield 26	com/danikula/videocache/HttpUrlSource:sourceInfo	Lcom/danikula/videocache/SourceInfo;
    //   186: getfield 100	com/danikula/videocache/SourceInfo:url	Ljava/lang/String;
    //   189: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 151	com/danikula/videocache/Logger:error	(Ljava/lang/String;)V
    //   198: aload 4
    //   200: invokestatic 143	com/danikula/videocache/ProxyCacheUtils:close	(Ljava/io/Closeable;)V
    //   203: aload_3
    //   204: ifnull +41 -> 245
    //   207: aload_3
    //   208: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   211: ldc 90
    //   213: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: astore 4
    //   219: aconst_null
    //   220: astore 5
    //   222: aconst_null
    //   223: astore_3
    //   224: aload 5
    //   226: invokestatic 143	com/danikula/videocache/ProxyCacheUtils:close	(Ljava/io/Closeable;)V
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   237: ldc 90
    //   239: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload 4
    //   244: athrow
    //   245: ldc 90
    //   247: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: return
    //   251: astore 4
    //   253: aconst_null
    //   254: astore 5
    //   256: goto -32 -> 224
    //   259: astore 4
    //   261: aload 5
    //   263: astore_3
    //   264: aload 6
    //   266: astore 5
    //   268: goto -44 -> 224
    //   271: astore 4
    //   273: aconst_null
    //   274: astore 4
    //   276: goto -110 -> 166
    //   279: astore 5
    //   281: goto -115 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	HttpUrlSource
    //   44	33	1	l	long
    //   38	113	3	localHttpURLConnection	HttpURLConnection
    //   160	1	3	localIOException1	IOException
    //   165	99	3	localObject1	Object
    //   55	144	4	localInputStream1	InputStream
    //   217	26	4	localObject2	Object
    //   251	1	4	localObject3	Object
    //   259	1	4	localObject4	Object
    //   271	1	4	localIOException2	IOException
    //   274	1	4	localObject5	Object
    //   62	205	5	localObject6	Object
    //   279	1	5	localIOException3	IOException
    //   59	206	6	localInputStream2	InputStream
    //   49	29	7	str	String
    // Exception table:
    //   from	to	target	type
    //   30	39	160	java/io/IOException
    //   30	39	217	finally
    //   39	57	251	finally
    //   64	85	259	finally
    //   92	112	259	finally
    //   119	141	259	finally
    //   173	198	259	finally
    //   39	57	271	java/io/IOException
    //   64	85	279	java/io/IOException
    //   92	112	279	java/io/IOException
    //   119	141	279	java/io/IOException
  }
  
  private long getContentLength(HttpURLConnection paramHttpURLConnection)
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
  
  private void injectCustomHeaders(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    AppMethodBeat.i(215862);
    paramString = this.headerInjector.addHeaders(paramString).entrySet().iterator();
    while (paramString.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramString.next();
      paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    AppMethodBeat.o(215862);
  }
  
  private HttpURLConnection openConnection(long paramLong, int paramInt)
  {
    AppMethodBeat.i(183591);
    Object localObject1 = this.sourceInfo.url;
    int i = 0;
    Object localObject2;
    int j;
    label247:
    label253:
    do
    {
      StringBuilder localStringBuilder = new StringBuilder("Open connection ");
      if (paramLong > 0L)
      {
        localObject2 = " with offset ".concat(String.valueOf(paramLong));
        Logger.debug((String)localObject2 + " to " + (String)localObject1);
        localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
        injectCustomHeaders((HttpURLConnection)localObject2, (String)localObject1);
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
          break label247;
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
          break label253;
        }
        localObject1 = new ProxyCacheException("Too many redirects: ".concat(String.valueOf(k)));
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
  
  private long readSourceAvailableBytes(HttpURLConnection paramHttpURLConnection, long paramLong, int paramInt)
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
    paramLong = this.sourceInfo.length;
    AppMethodBeat.o(183586);
    return paramLong;
  }
  
  public void close()
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
      Logger.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
      AppMethodBeat.o(183588);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label28:
      break label28;
    }
  }
  
  public String getMime()
  {
    try
    {
      AppMethodBeat.i(183593);
      if (TextUtils.isEmpty(this.sourceInfo.mime)) {
        fetchContentInfo();
      }
      String str = this.sourceInfo.mime;
      AppMethodBeat.o(183593);
      return str;
    }
    finally {}
  }
  
  public String getUrl()
  {
    return this.sourceInfo.url;
  }
  
  public long length()
  {
    try
    {
      AppMethodBeat.i(183584);
      if (this.sourceInfo.length == -2147483648L) {
        fetchContentInfo();
      }
      long l = this.sourceInfo.length;
      AppMethodBeat.o(183584);
      return l;
    }
    finally {}
  }
  
  public void open(long paramLong)
  {
    AppMethodBeat.i(183585);
    try
    {
      this.connection = openConnection(paramLong, -1);
      String str = this.connection.getContentType();
      this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
      long l = readSourceAvailableBytes(this.connection, paramLong, this.connection.getResponseCode());
      this.sourceInfo = new SourceInfo(this.sourceInfo.url, l, str);
      this.sourceInfoStorage.put(this.sourceInfo.url, this.sourceInfo);
      AppMethodBeat.o(183585);
      return;
    }
    catch (IOException localIOException)
    {
      ProxyCacheException localProxyCacheException = new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + paramLong, localIOException);
      AppMethodBeat.o(183585);
      throw localProxyCacheException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(183589);
    if (this.inputStream == null)
    {
      paramArrayOfByte = new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
    try
    {
      int i = this.inputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
      AppMethodBeat.o(183589);
      return i;
    }
    catch (InterruptedIOException paramArrayOfByte)
    {
      paramArrayOfByte = new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", paramArrayOfByte);
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new ProxyCacheException("Error reading data from " + this.sourceInfo.url, paramArrayOfByte);
      AppMethodBeat.o(183589);
      throw paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(183594);
    String str = "HttpUrlSource{sourceInfo='" + this.sourceInfo + "}";
    AppMethodBeat.o(183594);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.HttpUrlSource
 * JD-Core Version:    0.7.0.1
 */