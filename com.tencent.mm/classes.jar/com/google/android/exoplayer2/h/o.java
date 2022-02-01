package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
  implements s
{
  private static final Pattern bxa;
  private static final AtomicReference<byte[]> bxb;
  private j bml;
  private final x<? super o> bws;
  private final boolean bxc;
  private final int bxd;
  private final int bxe;
  private final com.google.android.exoplayer2.i.o<String> bxf;
  private final s.f bxg;
  private final s.f bxh;
  private long bxi;
  private long bxj;
  private long bxk;
  private long bxl;
  private HttpURLConnection connection;
  private InputStream inputStream;
  private boolean opened;
  private final String userAgent;
  
  static
  {
    AppMethodBeat.i(93077);
    bxa = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    bxb = new AtomicReference();
    AppMethodBeat.o(93077);
  }
  
  public o(String paramString, x<? super o> paramx, int paramInt1, int paramInt2, boolean paramBoolean, s.f paramf)
  {
    AppMethodBeat.i(93069);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(93069);
      throw paramString;
    }
    this.userAgent = paramString;
    this.bxf = null;
    this.bws = paramx;
    this.bxh = new s.f();
    this.bxd = paramInt1;
    this.bxe = paramInt2;
    this.bxc = paramBoolean;
    this.bxg = paramf;
    AppMethodBeat.o(93069);
  }
  
  private HttpURLConnection a(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93074);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.bxd);
    localHttpURLConnection.setReadTimeout(this.bxe);
    Object localObject;
    if (this.bxg != null)
    {
      paramURL = this.bxg.vq().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.bxh.vq().entrySet().iterator();
    while (paramURL.hasNext())
    {
      localObject = (Map.Entry)paramURL.next();
      localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
    }
    if ((paramLong1 != 0L) || (paramLong2 != -1L))
    {
      localObject = "bytes=" + paramLong1 + "-";
      paramURL = (URL)localObject;
      if (paramLong2 != -1L) {
        paramURL = (String)localObject + (paramLong1 + paramLong2 - 1L);
      }
      localHttpURLConnection.setRequestProperty("Range", paramURL);
    }
    localHttpURLConnection.setRequestProperty("User-Agent", this.userAgent);
    if (!paramBoolean1) {
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
    }
    localHttpURLConnection.setInstanceFollowRedirects(paramBoolean2);
    if (paramArrayOfByte != null)
    {
      paramBoolean1 = true;
      localHttpURLConnection.setDoOutput(paramBoolean1);
      if (paramArrayOfByte == null) {
        break label357;
      }
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length == 0) {
        break label357;
      }
      localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      localHttpURLConnection.connect();
      paramURL = localHttpURLConnection.getOutputStream();
      paramURL.write(paramArrayOfByte);
      paramURL.close();
    }
    for (;;)
    {
      AppMethodBeat.o(93074);
      return localHttpURLConnection;
      paramBoolean1 = false;
      break;
      label357:
      localHttpURLConnection.connect();
    }
  }
  
  private static long getContentLength(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(93075);
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
        localMatcher = bxa.matcher(paramHttpURLConnection);
        l2 = l1;
        if (!localMatcher.find()) {}
      }
      try
      {
        l2 = Long.parseLong(localMatcher.group(2));
        l3 = Long.parseLong(localMatcher.group(1));
        l3 = l2 - l3 + 1L;
        if (l1 >= 0L) {
          break label153;
        }
        l2 = l3;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          long l3;
          b.e("DefaultHttpDataSource", "Unexpected Content-Range [" + paramHttpURLConnection + "]", new Object[0]);
          l2 = l1;
        }
      }
      AppMethodBeat.o(93075);
      return l2;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;)
      {
        b.e("DefaultHttpDataSource", "Unexpected Content-Length [" + str + "]", new Object[0]);
        l1 = l2;
        continue;
        label153:
        l2 = l1;
        if (l1 != l3)
        {
          b.w("DefaultHttpDataSource", "Inconsistent headers [" + str + "] [" + paramHttpURLConnection + "]", new Object[0]);
          l2 = Math.max(l1, l3);
        }
      }
    }
  }
  
  private void vp()
  {
    AppMethodBeat.i(93076);
    if (this.connection != null) {}
    try
    {
      this.connection.disconnect();
      this.connection = null;
      AppMethodBeat.o(93076);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.e("DefaultHttpDataSource", "Unexpected error while disconnecting", new Object[] { localException });
      }
    }
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(93071);
    this.bml = paramj;
    this.bxl = 0L;
    this.bxk = 0L;
    long l1;
    Object localObject3;
    int j;
    try
    {
      localObject1 = new URL(paramj.uri.toString());
      arrayOfByte = paramj.bwy;
      l1 = paramj.position;
      l2 = paramj.length;
      bool = paramj.fh(1);
      if (!this.bxc)
      {
        localObject3 = a((URL)localObject1, arrayOfByte, l1, l2, bool, true);
        this.connection = ((HttpURLConnection)localObject3);
      }
    }
    catch (IOException localIOException1)
    {
      Object localObject1;
      byte[] arrayOfByte;
      long l2;
      boolean bool;
      paramj = new s.c("Unable to connect to " + paramj.uri.toString(), localIOException1, paramj);
      AppMethodBeat.o(93071);
      throw paramj;
    }
    try
    {
      i = this.connection.getResponseCode();
      b.i("DefaultHttpDataSource", "open, responseCode:%d", new Object[] { Integer.valueOf(i) });
      if ((i < 200) || (i > 299))
      {
        localObject1 = this.connection.getHeaderFields();
        vp();
        paramj = new s.e(i, (Map)localObject1, paramj);
        if (i == 416) {
          paramj.initCause(new h());
        }
        AppMethodBeat.o(93071);
        throw paramj;
      }
    }
    catch (IOException localIOException2)
    {
      vp();
      paramj = new s.c("Unable to connect to " + paramj.uri.toString(), localIOException2, paramj);
      AppMethodBeat.o(93071);
      throw paramj;
    }
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (i <= 20)
      {
        HttpURLConnection localHttpURLConnection = a((URL)localObject1, arrayOfByte, l1, l2, bool, false);
        i = localHttpURLConnection.getResponseCode();
        if ((i != 300) && (i != 301) && (i != 302) && (i != 303))
        {
          localObject3 = localHttpURLConnection;
          if (arrayOfByte != null) {
            break;
          }
          if (i != 307)
          {
            localObject3 = localHttpURLConnection;
            if (i != 308) {
              break;
            }
          }
        }
        arrayOfByte = null;
        localObject3 = localHttpURLConnection.getHeaderField("Location");
        localHttpURLConnection.disconnect();
        if (localObject3 == null)
        {
          localObject1 = new ProtocolException("Null location redirect");
          AppMethodBeat.o(93071);
          throw ((Throwable)localObject1);
        }
        localObject2 = new URL(localIOException1, (String)localObject3);
        localObject3 = ((URL)localObject2).getProtocol();
        if (("https".equals(localObject3)) || ("http".equals(localObject3))) {
          continue;
        }
        localObject2 = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(localObject3)));
        AppMethodBeat.o(93071);
        throw ((Throwable)localObject2);
      }
      Object localObject2 = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(j)));
      AppMethodBeat.o(93071);
      throw ((Throwable)localObject2);
      String str = this.connection.getContentType();
      if ((this.bxf != null) && (!this.bxf.ae(str)))
      {
        vp();
        paramj = new s.d(str, paramj);
        AppMethodBeat.o(93071);
        throw paramj;
      }
      if ((i == 200) && (paramj.position != 0L))
      {
        l1 = paramj.position;
        this.bxi = l1;
        if (paramj.fh(1)) {
          break label715;
        }
        if (paramj.length == -1L) {
          break label671;
        }
        this.bxj = paramj.length;
      }
      for (;;)
      {
        try
        {
          this.inputStream = this.connection.getInputStream();
          this.opened = true;
          if (this.bws != null) {
            this.bws.vl();
          }
          l1 = this.bxj;
          AppMethodBeat.o(93071);
          return l1;
        }
        catch (IOException localIOException3)
        {
          label671:
          label715:
          vp();
          paramj = new s.c(localIOException3, paramj, 1);
          AppMethodBeat.o(93071);
          throw paramj;
        }
        l1 = 0L;
        break;
        l1 = getContentLength(this.connection);
        if (l1 != -1L)
        {
          l1 -= this.bxi;
          this.bxj = l1;
        }
        else
        {
          l1 = -1L;
          continue;
          this.bxj = paramj.length;
        }
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(93073);
    try
    {
      Object localObject1;
      long l1;
      int i;
      if (this.inputStream != null)
      {
        localObject1 = this.connection;
        if (this.bxj != -1L) {
          break label130;
        }
        l1 = this.bxj;
        if (com.google.android.exoplayer2.i.x.SDK_INT != 19)
        {
          i = com.google.android.exoplayer2.i.x.SDK_INT;
          if (i != 20) {
            break label79;
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = ((HttpURLConnection)localObject1).getInputStream();
          if (l1 == -1L)
          {
            i = ((InputStream)localObject1).read();
            if (i != -1) {
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          label79:
          long l2;
          label130:
          Object localObject3;
          continue;
        }
        try
        {
          this.inputStream.close();
          return;
        }
        catch (IOException localIOException)
        {
          s.c localc = new s.c(localIOException, this.bml, 3);
          AppMethodBeat.o(93073);
          throw localc;
        }
        l1 = this.bxj;
        l2 = this.bxl;
        l1 -= l2;
        break;
        if (l1 > 2048L)
        {
          localObject3 = localObject1.getClass().getName();
          if ((((String)localObject3).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) || (((String)localObject3).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")))
          {
            localObject3 = localObject1.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
            ((Method)localObject3).setAccessible(true);
            ((Method)localObject3).invoke(localObject1, new Object[0]);
          }
        }
      }
      AppMethodBeat.o(93073);
    }
    finally
    {
      this.inputStream = null;
      vp();
      if (this.opened)
      {
        this.opened = false;
        if (this.bws != null) {
          this.bws.vm();
        }
      }
      AppMethodBeat.o(93073);
    }
  }
  
  public final Uri getUri()
  {
    AppMethodBeat.i(93070);
    if (this.connection == null)
    {
      AppMethodBeat.o(93070);
      return null;
    }
    Uri localUri = Uri.parse(this.connection.getURL().toString());
    AppMethodBeat.o(93070);
    return localUri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93072);
    byte[] arrayOfByte1;
    for (;;)
    {
      try
      {
        if (this.bxk == this.bxi) {
          break label199;
        }
        byte[] arrayOfByte2 = (byte[])bxb.getAndSet(null);
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          arrayOfByte1 = new byte[4096];
        }
        if (this.bxk == this.bxi) {
          break;
        }
        i = (int)Math.min(this.bxi - this.bxk, arrayOfByte1.length);
        i = this.inputStream.read(arrayOfByte1, 0, i);
        if (Thread.interrupted())
        {
          paramArrayOfByte = new InterruptedIOException();
          AppMethodBeat.o(93072);
          throw paramArrayOfByte;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new s.c(paramArrayOfByte, this.bml, 2);
        AppMethodBeat.o(93072);
        throw paramArrayOfByte;
      }
      if (i == -1)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(93072);
        throw paramArrayOfByte;
      }
      this.bxk += i;
      if (this.bws != null) {
        this.bws.fj(i);
      }
    }
    bxb.set(arrayOfByte1);
    label199:
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(93072);
      return 0;
    }
    int i = paramInt2;
    if (this.bxj != -1L)
    {
      long l = this.bxj - this.bxl;
      if (l == 0L)
      {
        AppMethodBeat.o(93072);
        return -1;
      }
      i = (int)Math.min(paramInt2, l);
    }
    paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 == -1)
    {
      if (this.bxj != -1L)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(93072);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(93072);
      return -1;
    }
    this.bxl += paramInt1;
    if (this.bws != null) {
      this.bws.fj(paramInt1);
    }
    AppMethodBeat.o(93072);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.o
 * JD-Core Version:    0.7.0.1
 */