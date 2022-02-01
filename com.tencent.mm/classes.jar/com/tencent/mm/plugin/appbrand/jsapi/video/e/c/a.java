package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.h.s.f;
import com.google.android.exoplayer2.h.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.EOFException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ByteRangeFixHttpDataSource;", "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource;", "userAgent", "", "contentTypePredicate", "Lcom/google/android/exoplayer2/util/Predicate;", "listener", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "connectTimeoutMillis", "", "readTimeoutMillis", "allowCrossProtocolRedirects", "", "defaultRequestProperties", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$RequestProperties;", "(Ljava/lang/String;Lcom/google/android/exoplayer2/util/Predicate;Lcom/google/android/exoplayer2/upstream/TransferListener;IIZLcom/google/android/exoplayer2/upstream/HttpDataSource$RequestProperties;)V", "bytesSkipped", "", "bytesToSkip", "myTag", "calculateBytesToSkip", "", "startReadPos", "open", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "read", "buffer", "", "offset", "readLength", "skipInternal", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
  extends o
{
  public static final a.a sFG;
  private static final Pattern sFH;
  private static final AtomicReference<byte[]> sFI;
  private long bytesSkipped;
  private long bytesToSkip;
  private final String djQ;
  
  static
  {
    AppMethodBeat.i(328734);
    sFG = new a.a((byte)0);
    sFH = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    sFI = new AtomicReference();
    AppMethodBeat.o(328734);
  }
  
  public a(String paramString, w<? super o> paramw, int paramInt1, int paramInt2, boolean paramBoolean, s.f paramf)
  {
    super(paramString, paramw, paramInt1, paramInt2, paramBoolean, paramf);
    AppMethodBeat.i(328727);
    this.djQ = s.X("MicroMsg.AppBrand.ByteRangeFixHttpDataSource#", Integer.valueOf(hashCode()));
    AppMethodBeat.o(328727);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(328741);
    long l5 = super.a(paramj);
    long l4;
    if (paramj == null)
    {
      l4 = 0L;
      Log.i(this.djQ, s.X("calculateBytesToSkip, startReadPos: ", Long.valueOf(l4)));
      paramj = getConnection();
      if (paramj != null) {
        break label74;
      }
      Log.w(((a)this).djQ, "calculateBytesToSkip, connection is null");
    }
    label386:
    label389:
    for (;;)
    {
      AppMethodBeat.o(328741);
      return l5;
      l4 = paramj.position;
      break;
      label74:
      int i = paramj.getResponseCode();
      Log.i(this.djQ, s.X("calculateBytesToSkip, responseCode: ", Integer.valueOf(i)));
      if (206 == i)
      {
        paramj = paramj.getHeaderField("Content-Range");
        if (paramj == null)
        {
          Log.i(((a)this).djQ, "calculateBytesToSkip, contentRange is null");
        }
        else
        {
          Log.i(this.djQ, s.X("calculateBytesToSkip, contentRange: ", paramj));
          paramj = sFH.matcher((CharSequence)paramj);
          if ((paramj.matches()) && (3 == paramj.groupCount()))
          {
            Object localObject = paramj.group(1);
            long l1;
            label181:
            long l2;
            label196:
            long l3;
            if (localObject == null)
            {
              l1 = 0L;
              localObject = paramj.group(2);
              if (localObject != null) {
                break label329;
              }
              l2 = 0L;
              paramj = paramj.group(3);
              if (paramj != null) {
                break label357;
              }
              l3 = 0L;
              label209:
              Log.i(this.djQ, "calculateBytesToSkip, startPos: " + l1 + ", endPos: " + l2 + ", totalCount: " + l3);
              if (l1 > l4) {
                break label386;
              }
              if (l4 > l2) {
                break label381;
              }
              i = 1;
            }
            for (;;)
            {
              if (i == 0) {
                break label389;
              }
              this.bytesToSkip = (l4 - l1);
              Log.i(this.djQ, s.X("calculateBytesToSkip, bytesToSkip: ", Long.valueOf(this.bytesToSkip)));
              break;
              localObject = n.bJH((String)localObject);
              if (localObject == null)
              {
                l1 = 0L;
                break label181;
              }
              l1 = ((Long)localObject).longValue();
              break label181;
              label329:
              localObject = n.bJH((String)localObject);
              if (localObject == null)
              {
                l2 = 0L;
                break label196;
              }
              l2 = ((Long)localObject).longValue();
              break label196;
              label357:
              paramj = n.bJH(paramj);
              if (paramj == null)
              {
                l3 = 0L;
                break label209;
              }
              l3 = paramj.longValue();
              break label209;
              label381:
              i = 0;
              continue;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328751);
    Log.d(this.djQ, "skipInternal, bytesToSkip: " + this.bytesToSkip + ", bytesSkipped: " + this.bytesSkipped);
    Object localObject = getConnection();
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label99;
      }
      Log.w(((a)this).djQ, "skipInternal, inputStream is null");
    }
    for (;;)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(328751);
      return paramInt1;
      localObject = ((HttpURLConnection)localObject).getInputStream();
      break;
      label99:
      if (this.bytesSkipped != this.bytesToSkip)
      {
        byte[] arrayOfByte2 = (byte[])sFI.getAndSet(null);
        byte[] arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte2 == null) {
          arrayOfByte1 = new byte[4096];
        }
        while (this.bytesSkipped != this.bytesToSkip)
        {
          int i = ((InputStream)localObject).read(arrayOfByte1, 0, (int)k.bS(this.bytesToSkip - this.bytesSkipped, arrayOfByte1.length));
          if (Thread.interrupted())
          {
            paramArrayOfByte = new InterruptedIOException();
            AppMethodBeat.o(328751);
            throw paramArrayOfByte;
          }
          if (-1 == i)
          {
            paramArrayOfByte = new EOFException();
            AppMethodBeat.o(328751);
            throw paramArrayOfByte;
          }
          long l = this.bytesSkipped;
          this.bytesSkipped = (i + l);
        }
        sFI.set(arrayOfByte1);
        Log.i(this.djQ, "skipInternal, skip done");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
 * JD-Core Version:    0.7.0.1
 */