package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.i.x;
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
  private static final Pattern boT;
  private static final AtomicReference<byte[]> boU;
  private InputStream aFw;
  private j bgL;
  private final boolean boV;
  private final int boW;
  private final int boX;
  private final com.google.android.exoplayer2.i.o<String> boY;
  private final s.f boZ;
  private final w<? super o> bol;
  private final s.f bpa;
  private long bpb;
  private long bpc;
  private long bpd;
  private long bpe;
  private HttpURLConnection connection;
  private boolean opened;
  private final String userAgent;
  
  static
  {
    AppMethodBeat.i(93077);
    boT = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    boU = new AtomicReference();
    AppMethodBeat.o(93077);
  }
  
  public o(String paramString, w<? super o> paramw, int paramInt1, int paramInt2, boolean paramBoolean, s.f paramf)
  {
    AppMethodBeat.i(93069);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException();
      AppMethodBeat.o(93069);
      throw paramString;
    }
    this.userAgent = paramString;
    this.boY = null;
    this.bol = paramw;
    this.bpa = new s.f();
    this.boW = paramInt1;
    this.boX = paramInt2;
    this.boV = paramBoolean;
    this.boZ = paramf;
    AppMethodBeat.o(93069);
  }
  
  private static long a(HttpURLConnection paramHttpURLConnection)
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
          break label151;
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
        label151:
        l2 = l1;
        if (l1 != l3)
        {
          b.w("DefaultHttpDataSource", "Inconsistent headers [" + str + "] [" + paramHttpURLConnection + "]", new Object[0]);
          l2 = Math.max(l1, l3);
        }
      }
    }
  }
  
  private HttpURLConnection a(URL paramURL, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(93074);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(this.boW);
    localHttpURLConnection.setReadTimeout(this.boX);
    Object localObject;
    if (this.boZ != null)
    {
      paramURL = this.boZ.uN().entrySet().iterator();
      while (paramURL.hasNext())
      {
        localObject = (Map.Entry)paramURL.next();
        localHttpURLConnection.setRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    paramURL = this.bpa.uN().entrySet().iterator();
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
        break label358;
      }
      localHttpURLConnection.setRequestMethod("POST");
      if (paramArrayOfByte.length == 0) {
        break label358;
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
      label358:
      localHttpURLConnection.connect();
    }
  }
  
  private void uM()
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
    this.bgL = paramj;
    this.bpe = 0L;
    this.bpd = 0L;
    long l1;
    Object localObject3;
    int j;
    try
    {
      localObject1 = new URL(paramj.uri.toString());
      arrayOfByte = paramj.bor;
      l1 = paramj.position;
      l2 = paramj.aFL;
      bool = paramj.fp(1);
      if (!this.boV)
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
        uM();
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
      uM();
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
      if ((this.boY != null) && (!this.boY.ab(str)))
      {
        uM();
        paramj = new s.d(str, paramj);
        AppMethodBeat.o(93071);
        throw paramj;
      }
      if ((i == 200) && (paramj.position != 0L))
      {
        l1 = paramj.position;
        this.bpb = l1;
        if (paramj.fp(1)) {
          break label717;
        }
        if (paramj.aFL == -1L) {
          break label673;
        }
        this.bpc = paramj.aFL;
      }
      for (;;)
      {
        try
        {
          this.aFw = this.connection.getInputStream();
          this.opened = true;
          if (this.bol != null) {
            this.bol.a(this, paramj);
          }
          l1 = this.bpc;
          AppMethodBeat.o(93071);
          return l1;
        }
        catch (IOException localIOException3)
        {
          label673:
          label717:
          uM();
          paramj = new s.c(localIOException3, paramj, 1);
          AppMethodBeat.o(93071);
          throw paramj;
        }
        l1 = 0L;
        break;
        l1 = a(this.connection);
        if (l1 != -1L)
        {
          l1 -= this.bpb;
          this.bpc = l1;
        }
        else
        {
          l1 = -1L;
          continue;
          this.bpc = paramj.aFL;
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
      if (this.aFw != null)
      {
        localObject1 = this.connection;
        if (this.bpc != -1L) {
          break label131;
        }
        l1 = this.bpc;
        if (x.SDK_INT != 19)
        {
          i = x.SDK_INT;
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
          label131:
          Object localObject3;
          continue;
        }
        try
        {
          this.aFw.close();
          return;
        }
        catch (IOException localIOException)
        {
          s.c localc = new s.c(localIOException, this.bgL, 3);
          AppMethodBeat.o(93073);
          throw localc;
        }
        l1 = this.bpc;
        l2 = this.bpe;
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
      this.aFw = null;
      uM();
      if (this.opened)
      {
        this.opened = false;
        if (this.bol != null) {
          this.bol.aa(this);
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
        if (this.bpd == this.bpb) {
          break label200;
        }
        byte[] arrayOfByte2 = (byte[])boU.getAndSet(null);
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          arrayOfByte1 = new byte[4096];
        }
        if (this.bpd == this.bpb) {
          break;
        }
        i = (int)Math.min(this.bpb - this.bpd, arrayOfByte1.length);
        i = this.aFw.read(arrayOfByte1, 0, i);
        if (Thread.interrupted())
        {
          paramArrayOfByte = new InterruptedIOException();
          AppMethodBeat.o(93072);
          throw paramArrayOfByte;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new s.c(paramArrayOfByte, this.bgL, 2);
        AppMethodBeat.o(93072);
        throw paramArrayOfByte;
      }
      if (i == -1)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(93072);
        throw paramArrayOfByte;
      }
      this.bpd += i;
      if (this.bol != null) {
        this.bol.e(this, i);
      }
    }
    boU.set(arrayOfByte1);
    label200:
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(93072);
      return 0;
    }
    int i = paramInt2;
    if (this.bpc != -1L)
    {
      long l = this.bpc - this.bpe;
      if (l == 0L)
      {
        AppMethodBeat.o(93072);
        return -1;
      }
      i = (int)Math.min(paramInt2, l);
    }
    paramInt1 = this.aFw.read(paramArrayOfByte, paramInt1, i);
    if (paramInt1 == -1)
    {
      if (this.bpc != -1L)
      {
        paramArrayOfByte = new EOFException();
        AppMethodBeat.o(93072);
        throw paramArrayOfByte;
      }
      AppMethodBeat.o(93072);
      return -1;
    }
    this.bpe += paramInt1;
    if (this.bol != null) {
      this.bol.e(this, paramInt1);
    }
    AppMethodBeat.o(93072);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.o
 * JD-Core Version:    0.7.0.1
 */