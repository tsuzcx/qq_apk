package com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a;

import com.google.android.exoplayer2.h.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/cache/AppBrandExoVideoCacheService;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "()V", "cache", "", "url", "", "kotlin.jvm.PlatformType", "position", "", "length", "checkCached", "", "getCachedBytes", "getDataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "getInterruptCacheDataSourceFactory", "getProxyUrl", "name", "luggage-commons-jsapi-video-ext_release"})
public final class a
  implements f
{
  public static final a pBH;
  
  static
  {
    AppMethodBeat.i(227911);
    pBH = new a();
    AppMethodBeat.o(227911);
  }
  
  private a()
  {
    AppMethodBeat.i(227909);
    if (b.pBJ) {}
    for (Object localObject = (f)e.pBX;; localObject = (f)localObject)
    {
      this.pBI = ((f)localObject);
      AppMethodBeat.o(227909);
      return;
      localObject = d.bWK();
      p.j(localObject, "ExoVideoCacheHandler.getInstance()");
    }
  }
  
  public final String aQ(String paramString)
  {
    AppMethodBeat.i(227917);
    paramString = this.pBI.aQ(paramString);
    AppMethodBeat.o(227917);
    return paramString;
  }
  
  public final g.a bVl()
  {
    AppMethodBeat.i(227915);
    g.a locala = this.pBI.bVl();
    AppMethodBeat.o(227915);
    return locala;
  }
  
  public final g.a bVm()
  {
    AppMethodBeat.i(227916);
    g.a locala = this.pBI.bVm();
    AppMethodBeat.o(227916);
    return locala;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227913);
    paramLong1 = this.pBI.f(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(227913);
    return paramLong1;
  }
  
  public final void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227912);
    this.pBI.o(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(227912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a.a
 * JD-Core Version:    0.7.0.1
 */