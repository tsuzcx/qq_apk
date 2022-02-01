package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.h.s.a;
import com.google.android.exoplayer2.h.s.f;
import com.google.android.exoplayer2.h.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ByteRangeFixHttpDataSourceFactory;", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$BaseFactory;", "userAgent", "", "listener", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "Lcom/google/android/exoplayer2/upstream/DefaultHttpDataSource;", "connectTimeoutMillis", "", "readTimeoutMillis", "allowCrossProtocolRedirects", "", "(Ljava/lang/String;Lcom/google/android/exoplayer2/upstream/TransferListener;IIZ)V", "createDataSourceInternal", "Lcom/google/android/exoplayer2/upstream/HttpDataSource;", "defaultRequestProperties", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$RequestProperties;", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends s.a
{
  private final boolean allowCrossProtocolRedirects;
  private final int connectTimeoutMillis;
  private final w<? super o> did;
  private final int readTimeoutMillis;
  private final String userAgent;
  
  public b(String paramString, w<? super o> paramw)
  {
    this.userAgent = paramString;
    this.did = paramw;
    this.connectTimeoutMillis = 8000;
    this.readTimeoutMillis = 8000;
    this.allowCrossProtocolRedirects = true;
  }
  
  public final s a(s.f paramf)
  {
    AppMethodBeat.i(328729);
    if (c.cwF())
    {
      paramf = (s)new a(this.userAgent, this.did, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, paramf);
      AppMethodBeat.o(328729);
      return paramf;
    }
    paramf = (s)new o(this.userAgent, this.did, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, paramf);
    AppMethodBeat.o(328729);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b
 * JD-Core Version:    0.7.0.1
 */