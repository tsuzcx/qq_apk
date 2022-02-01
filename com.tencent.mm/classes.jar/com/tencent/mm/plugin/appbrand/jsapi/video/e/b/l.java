package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/UrlContentTypeInferer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "()V", "infer", "", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"})
public final class l
  implements h
{
  public static final l mCK;
  
  static
  {
    AppMethodBeat.i(235246);
    mCK = new l();
    AppMethodBeat.o(235246);
  }
  
  public final int r(Uri paramUri)
  {
    AppMethodBeat.i(235245);
    if ((paramUri != null) && (com.tencent.mm.plugin.appbrand.jsapi.video.l.aaW(paramUri.toString())))
    {
      AppMethodBeat.o(235245);
      return 2;
    }
    AppMethodBeat.o(235245);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.l
 * JD-Core Version:    0.7.0.1
 */