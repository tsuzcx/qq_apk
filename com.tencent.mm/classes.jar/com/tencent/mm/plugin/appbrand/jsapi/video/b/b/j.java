package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class j
  implements l
{
  private static final Pattern boT;
  private static final AtomicReference<byte[]> boU;
  protected String TAG;
  private InputStream aFw;
  private final boolean boV;
  private final int boW;
  private final int boX;
  private long bpb;
  private long bpc;
  private long bpd;
  private long bpe;
  private HttpURLConnection connection;
  private long contentLength;
  private String contentType;
  private long nHt;
  private boolean opened;
  public g pvN;
  protected String pvQ;
  private final i<String> pwB;
  private final HashMap<String, String> pwC;
  private final e<Map<String, List<String>>> pwD;
  private final s pwh;
  private final String userAgent;
  
  static
  {
    AppMethodBeat.i(228478);
    boT = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    boU = new AtomicReference();
    AppMethodBeat.o(228478);
  }
  
  public j(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private j(String paramString, byte paramByte)
  {
    this(paramString, null, null);
  }
  
  public j(String paramString, i<String> parami, s params, boolean paramBoolean, e<Map<String, List<String>>> parame)
  {
    AppMethodBeat.i(228413);
    this.TAG = "DefaultHttpDataSource";
    this.contentLength = -1L;
    this.nHt = -1L;
    this.pvQ = "";
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(228413);
      throw paramString;
    }
    this.userAgent = paramString;
    this.pwB = parami;
    this.pwh = params;
    this.pwC = new HashMap();
    this.boW = 30000;
    this.boX = 12000;
    this.boV = paramBoolean;
    this.pwD = parame;
    AppMethodBeat.o(228413);
  }
  
  private j(String paramString, i<String> parami, e<Map<String, List<String>>> parame)
  {
    this(paramString, null, null, false, null);
  }
  
  private static long a(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    long l3 = -1L;
    AppMethodBeat.i(228470);
    Object localObject = paramHttpURLConnection.getHeaderField("Content-Length");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      long l4;
      try
      {
        l2 = Long.parseLong((String)localObject);
        paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(paramHttpURLConnection)) {
          break label191;
        }
        localObject = boT.matcher(paramHttpURLConnection);
        l1 = l3;
        if (!((Matcher)localObject).find()) {}
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        h.log(6, paramString, "Unexpected Content-Length [" + (String)localObject + "]");
      }
      try
      {
        l4 = Long.parseLong(((Matcher)localObject).group(3));
        if (l2 >= 0L) {
          break label133;
        }
        l1 = l4;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        h.log(6, paramString, "Unexpected Content-Range [" + paramHttpURLConnection + "]");
        l1 = l3;
        continue;
      }
      AppMethodBeat.o(228470);
      return l1;
      long l2 = -1L;
      continue;
      label133:
      long l1 = l3;
      if (l2 != -1L)
      {
        l1 = Math.max(l2, l4);
        continue;
        label191:
        l1 = l2;
      }
    }
  }
  
  private HttpURLConnection a(URL paramURL, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(228465);
    if (h.b(paramURL)) {}
    Object localObject2;
    for (HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection(Proxy.NO_PROXY);; localHttpURLConnection = (HttpURLConnection)paramURL.openConnection())
    {
      localHttpURLConnection.setConnectTimeout(this.boW);
      localHttpURLConnection.setReadTimeout(this.boX);
      localHttpURLConnection.setDoOutput(false);
      if (((localHttpURLConnection instanceof HttpsURLConnection)) && (!a.bVt().pvD)) {
        k.a((HttpsURLConnection)localHttpURLConnection);
      }
      synchronized (this.pwC)
      {
        localObject2 = this.pwC.entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject2 = "bytes=" + paramLong1 + "-";
      ??? = localObject2;
      if (paramLong2 != -1L) {
        ??? = (String)localObject2 + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", (String)???);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    h.log(4, getLogTag(), h.ajm("send upstream request: \r\n" + localHttpURLConnection.getRequestMethod() + " " + paramURL + "\r\n" + f.M(localHttpURLConnection.getRequestProperties())));
    AppMethodBeat.o(228465);
    return localHttpURLConnection;
  }
  
  private static long b(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    AppMethodBeat.i(228472);
    l2 = -1L;
    String str = paramHttpURLConnection.getHeaderField("Content-Length");
    l1 = l2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l1 = Long.parseLong(str);
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Range");
      l2 = l1;
      Matcher localMatcher;
      if (!TextUtils.isEmpty(paramHttpURLConnection))
      {
        localMatcher = boT.matcher(paramHttpURLConnection);
        l2 = l1;
        if (!localMatcher.find()) {}
      }
      try
      {
        l2 = Long.parseLong(localMatcher.group(2));
        l3 = Long.parseLong(localMatcher.group(1));
        l3 = l2 - l3 + 1L;
        if (l1 >= 0L) {
          break label159;
        }
        l2 = l3;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          long l3;
          h.log(6, paramString, "Unexpected Content-Range [" + paramHttpURLConnection + "]");
          l2 = l1;
        }
      }
      AppMethodBeat.o(228472);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        h.log(6, paramString, "Unexpected Content-Length [" + str + "]");
        l1 = l2;
        continue;
        label159:
        l2 = l1;
        if (l1 != l3)
        {
          h.log(5, paramString, "Inconsistent headers [" + str + "] [" + paramHttpURLConnection + "]");
          l2 = Math.max(l1, l3);
        }
      }
    }
  }
  
  private HttpURLConnection c(g paramg)
  {
    AppMethodBeat.i(228451);
    Object localObject2 = new URL(paramg.uri.toString());
    long l1 = paramg.position;
    long l2 = paramg.aFL;
    if ((paramg.flags & 0x1) != 0) {}
    for (boolean bool = true; !this.boV; bool = false)
    {
      paramg = a((URL)localObject2, l1, l2, bool);
      AppMethodBeat.o(228451);
      return paramg;
    }
    ((URL)localObject2).toExternalForm();
    System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    int k;
    Object localObject1;
    for (;;)
    {
      k = j + 1;
      if (j > 20) {
        break label659;
      }
      localObject1 = a((URL)localObject2, l1, l2, bool);
      ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
      ((HttpURLConnection)localObject1).connect();
      try
      {
        localObject3 = m.a(new j.a((HttpURLConnection)localObject1), this.boX, "GetResponseCodeCallable", getLogTag());
        if (localObject3 == null)
        {
          closeConnection();
          paramg = new l.h("getResponseCode TimeoutException Unable to connect to " + paramg.uri.toString() + " within " + this.boX, new IOException("getResponseCode Timeout " + this.boX), paramg);
          AppMethodBeat.o(228451);
          throw paramg;
        }
      }
      catch (InterruptedException paramg)
      {
        Thread.currentThread().interrupt();
        h.log(4, getLogTag(), "GetResponseCodeCallable Interrupted");
        paramg = new l.b("GetResponseCodeCallable interrupted", this.pvN);
        AppMethodBeat.o(228451);
        throw paramg;
      }
      catch (ExecutionException paramg)
      {
        h.log(5, getLogTag(), "GetResponseCodeCallable ExecutionException " + h.i(paramg));
        paramg = new l.b("Failed To Execute GetResponseCodeCallable", this.pvN);
        AppMethodBeat.o(228451);
        throw paramg;
      }
      j = ((Integer)localObject3).intValue();
      if ((j != 300) && (j != 301) && (j != 302) && (j != 303) && (j != 307) && (j != 308)) {
        break;
      }
      i += 1;
      Object localObject3 = ((HttpURLConnection)localObject1).getHeaderField("Location");
      try
      {
        localArrayList.add(new URL((String)localObject3).getHost());
        ((HttpURLConnection)localObject1).disconnect();
        if (localObject3 == null)
        {
          paramg = new ProtocolException("Null location redirect");
          AppMethodBeat.o(228451);
          throw paramg;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          h.log(5, getLogTag(), "MalformedURLException url=".concat(String.valueOf(localObject3)));
        }
        if (URLUtil.isNetworkUrl((String)localObject3)) {}
        for (localObject1 = new URL((String)localObject3);; localObject1 = new URL((URL)localObject2, (String)localObject3))
        {
          localObject3 = ((URL)localObject1).getProtocol();
          if (("https".equals(localObject3)) || ("http".equals(localObject3))) {
            break;
          }
          paramg = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(localObject3)));
          AppMethodBeat.o(228451);
          throw paramg;
        }
        h.log(2, getLogTag(), "redirect to url=" + ((URL)localObject1).toString() + ", fromUrl=" + localObject2);
        j = k;
        localObject2 = localObject1;
      }
    }
    if ((i > 0) && (a.bVt().pvJ != null))
    {
      System.currentTimeMillis();
      a.bVt();
      h.bI(localArrayList);
    }
    AppMethodBeat.o(228451);
    return localObject1;
    label659:
    paramg = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(k)));
    AppMethodBeat.o(228451);
    throw paramg;
  }
  
  private void closeConnection()
  {
    AppMethodBeat.i(228473);
    if (this.connection != null)
    {
      this.connection.disconnect();
      this.connection = null;
    }
    AppMethodBeat.o(228473);
  }
  
  public long a(g paramg)
  {
    AppMethodBeat.i(228418);
    long l = b(paramg);
    AppMethodBeat.o(228418);
    return l;
  }
  
  public final long available()
  {
    return this.contentLength;
  }
  
  public final long b(g paramg)
  {
    AppMethodBeat.i(228423);
    this.pvN = paramg;
    this.bpe = 0L;
    this.bpd = 0L;
    int i;
    try
    {
      this.connection = c(paramg);
      Map localMap;
      str = this.connection.getContentType();
    }
    catch (InterruptedIOException localInterruptedIOException1)
    {
      try
      {
        i = this.connection.getResponseCode();
        h.log(4, getLogTag(), h.ajm("uri=" + paramg.toString() + ", response header: \r\n" + f.M(this.connection.getHeaderFields())));
        if ((i >= 200) && (i <= 299)) {
          break label427;
        }
        localMap = this.connection.getHeaderFields();
        closeConnection();
        paramg = new l.f(i, localMap, paramg);
        AppMethodBeat.o(228423);
        throw paramg;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        closeConnection();
        paramg = new l.h("getResponseCode SocketTimeoutException Unable to connect to " + paramg.uri.toString(), localSocketTimeoutException, paramg);
        AppMethodBeat.o(228423);
        throw paramg;
      }
      catch (InterruptedIOException localInterruptedIOException2)
      {
        closeConnection();
        paramg = new l.b("getResponseCode InterruptedIOException Interrupt connection to " + paramg.uri.toString(), localInterruptedIOException2, paramg);
        AppMethodBeat.o(228423);
        throw paramg;
      }
      catch (IOException localIOException2)
      {
        closeConnection();
        paramg = new l.h("getResponseCode IOException Unable to connect to " + paramg.uri.toString(), localIOException2, paramg);
        AppMethodBeat.o(228423);
        throw paramg;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        closeConnection();
        h.log(6, getLogTag(), h.i(localArrayIndexOutOfBoundsException));
        paramg = new l.g("getResponseCode Got malformed response when connect to " + paramg.uri.toString(), paramg);
        AppMethodBeat.o(228423);
        throw paramg;
      }
      localInterruptedIOException1 = localInterruptedIOException1;
      paramg = new l.b("makeConnection InterruptedIOException Interrupt connection to " + paramg.uri.toString(), localInterruptedIOException1, paramg);
      AppMethodBeat.o(228423);
      throw paramg;
    }
    catch (IOException localIOException1)
    {
      paramg = new l.h("makeConnection IOException Unable to connect to " + paramg.uri.toString(), localIOException1, paramg);
      AppMethodBeat.o(228423);
      throw paramg;
    }
    label427:
    String str;
    Object localObject = this.connection.getHeaderFields();
    if ((this.pwB != null) && (!this.pwB.ab(str)))
    {
      closeConnection();
      paramg = new l.e(str, (Map)localObject, paramg);
      AppMethodBeat.o(228423);
      throw paramg;
    }
    this.contentType = str;
    long l;
    if (this.pwD != null)
    {
      localObject = (d)this.pwD;
      str = this.contentType;
      if ((str.equals("application/octet-stream")) && (!TextUtils.isEmpty(((d)localObject).pym)))
      {
        h.log(5, ((d)localObject).pyl, "fix contentType from " + str + " to " + ((d)localObject).pym);
        str = ((d)localObject).pym;
        this.contentType = str;
      }
    }
    else
    {
      if ((i != 200) || (paramg.position == 0L)) {
        break label729;
      }
      l = paramg.position;
      label616:
      this.bpb = l;
      if ((paramg.flags & 0x1) != 0) {
        break label765;
      }
      this.contentLength = b(this.connection, getLogTag());
      this.nHt = a(this.connection, getLogTag());
      if (paramg.aFL == -1L) {
        break label734;
      }
      l = paramg.aFL;
      label676:
      this.bpc = l;
    }
    for (;;)
    {
      try
      {
        this.aFw = this.connection.getInputStream();
        this.opened = true;
        if (this.pwh != null) {
          this.pwh.onTransferStart();
        }
        l = this.bpc;
        AppMethodBeat.o(228423);
        return l;
      }
      catch (IOException localIOException3)
      {
        label729:
        label734:
        label765:
        closeConnection();
        paramg = new l.a(localIOException3, paramg);
        AppMethodBeat.o(228423);
        throw paramg;
      }
      break;
      l = 0L;
      break label616;
      if (this.contentLength != -1L)
      {
        l = this.contentLength - this.bpb;
        break label676;
      }
      l = -1L;
      break label676;
      this.bpc = paramg.aFL;
      this.contentLength = paramg.aFL;
      this.nHt = -1L;
    }
  }
  
  protected final long bVA()
  {
    return this.bpe;
  }
  
  public final i<String> bVB()
  {
    return this.pwB;
  }
  
  public final c bVy()
  {
    AppMethodBeat.i(228475);
    c localc = c.aiX(this.contentType);
    AppMethodBeat.o(228475);
    return localc;
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: ldc_w 630
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 603	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:aFw	Ljava/io/InputStream;
    //   10: ifnull +41 -> 51
    //   13: aload_0
    //   14: getfield 510	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:connection	Ljava/net/HttpURLConnection;
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 597	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:bpc	J
    //   22: ldc2_w 94
    //   25: lcmp
    //   26: ifne +64 -> 90
    //   29: aload_0
    //   30: getfield 597	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:bpc	J
    //   33: lstore_1
    //   34: aload_3
    //   35: lload_1
    //   36: invokestatic 633	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(Ljava/net/HttpURLConnection;J)V
    //   39: aload_0
    //   40: getfield 603	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:aFw	Ljava/io/InputStream;
    //   43: invokevirtual 637	java/io/InputStream:close	()V
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 603	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:aFw	Ljava/io/InputStream;
    //   51: aload_0
    //   52: getfield 605	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:opened	Z
    //   55: ifeq +24 -> 79
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 605	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:opened	Z
    //   63: aload_0
    //   64: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pwh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/s;
    //   67: ifnull +12 -> 79
    //   70: aload_0
    //   71: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pwh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/s;
    //   74: invokeinterface 640 1 0
    //   79: aload_0
    //   80: invokespecial 390	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:closeConnection	()V
    //   83: ldc_w 630
    //   86: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: return
    //   90: aload_0
    //   91: getfield 597	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:bpc	J
    //   94: aload_0
    //   95: getfield 524	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:bpe	J
    //   98: lsub
    //   99: lstore_1
    //   100: goto -66 -> 34
    //   103: astore_3
    //   104: new 612	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   107: dup
    //   108: aload_3
    //   109: aload_0
    //   110: getfield 424	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pvN	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;
    //   113: invokespecial 615	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:<init>	(Ljava/io/IOException;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;)V
    //   116: astore_3
    //   117: ldc_w 630
    //   120: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_3
    //   124: athrow
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 605	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:opened	Z
    //   130: ifeq +24 -> 154
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 605	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:opened	Z
    //   138: aload_0
    //   139: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pwh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/s;
    //   142: ifnull +12 -> 154
    //   145: aload_0
    //   146: getfield 118	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pwh	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/s;
    //   149: invokeinterface 640 1 0
    //   154: aload_0
    //   155: invokespecial 390	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:closeConnection	()V
    //   158: ldc_w 630
    //   161: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_3
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	j
    //   33	67	1	l	long
    //   17	18	3	localHttpURLConnection	HttpURLConnection
    //   103	6	3	localIOException	IOException
    //   116	8	3	locala	l.a
    //   125	40	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   39	46	103	java/io/IOException
    //   6	34	125	finally
    //   34	39	125	finally
    //   39	46	125	finally
    //   46	51	125	finally
    //   90	100	125	finally
    //   104	125	125	finally
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(228476);
    String str = this.pvQ + this.TAG;
    AppMethodBeat.o(228476);
    return str;
  }
  
  public final Map<String, List<String>> getResponseHeaders()
  {
    AppMethodBeat.i(228417);
    if (this.connection == null) {}
    for (Object localObject = null; this.pwD != null; localObject = this.connection.getHeaderFields())
    {
      localObject = (Map)this.pwD.cJ(localObject);
      AppMethodBeat.o(228417);
      return localObject;
    }
    AppMethodBeat.o(228417);
    return localObject;
  }
  
  public final long getTotalLength()
  {
    return this.nHt;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(228416);
    if (this.connection == null)
    {
      AppMethodBeat.o(228416);
      return null;
    }
    String str = this.connection.getURL().toString();
    AppMethodBeat.o(228416);
    return str;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228432);
    byte[] arrayOfByte1;
    for (;;)
    {
      int i;
      try
      {
        if (this.bpd == this.bpb) {
          break label295;
        }
        byte[] arrayOfByte2 = (byte[])boU.getAndSet(null);
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          arrayOfByte1 = new byte[4096];
        }
        getLogTag();
        new StringBuilder("bytes skipped ").append(this.bpd).append(", bytesToSkip ").append(this.bpb);
        if (this.bpd == this.bpb) {
          break;
        }
        i = (int)Math.min(this.bpb - this.bpd, arrayOfByte1.length);
        getLogTag();
        new StringBuilder("request skip ").append(i).append(" bytes");
        i = this.aFw.read(arrayOfByte1, 0, i);
        getLogTag();
        new StringBuilder("actual skip ").append(i).append(" bytes");
        if (Thread.interrupted())
        {
          paramArrayOfByte = new l.c("skipInternal interrupted", this.pvN);
          AppMethodBeat.o(228432);
          throw paramArrayOfByte;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new l.a(paramArrayOfByte, this.pvN);
        AppMethodBeat.o(228432);
        throw paramArrayOfByte;
      }
      if (i == -1)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(228432);
        throw paramArrayOfByte;
      }
      this.bpd += i;
      if (this.pwh != null) {
        this.pwh.AU(i);
      }
    }
    boU.set(arrayOfByte1);
    label295:
    if (this.bpc == -1L) {}
    while (paramInt2 == 0)
    {
      AppMethodBeat.o(228432);
      return -1;
      paramInt2 = (int)Math.min(paramInt2, this.bpc - this.bpe);
    }
    paramInt1 = this.aFw.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == -1)
    {
      if ((this.bpc != -1L) && (this.bpc != this.bpe))
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(228432);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(228432);
      return -1;
    }
    this.bpe += paramInt1;
    if (this.pwh != null) {
      this.pwh.AU(paramInt1);
    }
    AppMethodBeat.o(228432);
    return paramInt1;
  }
  
  public final void setLogTag(String paramString)
  {
    this.pvQ = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j
 * JD-Core Version:    0.7.0.1
 */