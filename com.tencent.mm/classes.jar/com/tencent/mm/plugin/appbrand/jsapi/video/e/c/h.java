package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ExoContentTypeInferer;", "", "()V", "inferer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "getInferer", "()Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "infer", "", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h sFX;
  
  static
  {
    AppMethodBeat.i(328715);
    sFX = new h();
    AppMethodBeat.o(328715);
  }
  
  public static int a(com.tencent.mm.plugin.appbrand.jsapi.video.f paramf, Uri paramUri)
  {
    AppMethodBeat.i(328713);
    boolean bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.f.cwx();
    Log.i("MicroMsg.ExoContentTypeInferer", s.X("inferer#get, useContentInferer: ", Boolean.valueOf(bool)));
    if (bool) {}
    for (l locall = (l)d.sFK;; locall = (l)p.sGV)
    {
      int i = locall.a(paramf, paramUri);
      AppMethodBeat.o(328713);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h
 * JD-Core Version:    0.7.0.1
 */