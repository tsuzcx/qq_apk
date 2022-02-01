package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/UrlContentTypeInferer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "()V", "infer", "", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
final class p
  implements l
{
  public static final p sGV;
  
  static
  {
    AppMethodBeat.i(328688);
    sGV = new p();
    AppMethodBeat.o(328688);
  }
  
  public final int a(f paramf, Uri paramUri)
  {
    AppMethodBeat.i(328694);
    if (paramUri != null)
    {
      paramf = d.sEK;
      paramf = paramUri.toString();
      s.s(paramf, "uri.toString()");
      if (d.acp(paramf))
      {
        AppMethodBeat.o(328694);
        return 2;
      }
    }
    AppMethodBeat.o(328694);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.p
 * JD-Core Version:    0.7.0.1
 */