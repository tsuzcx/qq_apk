package com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a;

import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/AppBrandExoVideoCacheService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "()V", "cache", "", "url", "", "kotlin.jvm.PlatformType", "position", "", "length", "checkCached", "", "getCachedBytes", "getDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "getInterruptCacheDataSourceFactory", "getProxyUrl", "name", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  public static final a sGW;
  
  static
  {
    AppMethodBeat.i(328758);
    sGW = new a();
    AppMethodBeat.o(328758);
  }
  
  private a()
  {
    AppMethodBeat.i(328753);
    if (b.sGY) {}
    for (Object localObject = (f)e.sHk;; localObject = (f)localObject)
    {
      this.sGX = ((f)localObject);
      AppMethodBeat.o(328753);
      return;
      localObject = d.cwX();
      s.s(localObject, "getInstance()");
    }
  }
  
  public final String cd(String paramString)
  {
    AppMethodBeat.i(328795);
    paramString = this.sGX.cd(paramString);
    AppMethodBeat.o(328795);
    return paramString;
  }
  
  public final g.a cvB()
  {
    AppMethodBeat.i(328789);
    g.a locala = this.sGX.cvB();
    AppMethodBeat.o(328789);
    return locala;
  }
  
  public final g.a cvC()
  {
    AppMethodBeat.i(328767);
    g.a locala = this.sGX.cvC();
    AppMethodBeat.o(328767);
    return locala;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328780);
    paramLong1 = this.sGX.f(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(328780);
    return paramLong1;
  }
  
  public final void q(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(328773);
    this.sGX.q(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(328773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a.a
 * JD-Core Version:    0.7.0.1
 */