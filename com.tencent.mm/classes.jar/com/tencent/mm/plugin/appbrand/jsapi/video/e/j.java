package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/UrlContentTypeInferer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IContentTypeInferer;", "()V", "infer", "", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"})
public final class j
  implements d
{
  public static final j pAg;
  
  static
  {
    AppMethodBeat.i(227022);
    pAg = new j();
    AppMethodBeat.o(227022);
  }
  
  public final int a(f paramf, Uri paramUri)
  {
    AppMethodBeat.i(227020);
    if ((paramUri != null) && (k.aiP(paramUri.toString())))
    {
      AppMethodBeat.o(227020);
      return 2;
    }
    AppMethodBeat.o(227020);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.j
 * JD-Core Version:    0.7.0.1
 */