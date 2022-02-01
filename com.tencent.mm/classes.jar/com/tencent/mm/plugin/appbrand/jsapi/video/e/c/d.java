package com.tencent.mm.plugin.appbrand.jsapi.video.e.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/ContentContentTypeInferer3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/exo/IContentTypeInferer;", "()V", "infer", "", "videoCacheService", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/IVideoCacheService;", "uri", "Landroid/net/Uri;", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
  implements l
{
  public static final d sFK;
  
  static
  {
    AppMethodBeat.i(328699);
    sFK = new d();
    AppMethodBeat.o(328699);
  }
  
  public final int a(f paramf, final Uri paramUri)
  {
    AppMethodBeat.i(328707);
    Log.i("MicroMsg.ExoContentTypeInferer", s.X("infer#ContentContentTypeInferer3, uri: ", paramUri));
    if (paramUri == null)
    {
      AppMethodBeat.o(328707);
      return 3;
    }
    paramf = new c((b)new a(paramf, paramUri));
    paramUri = paramUri.toString();
    s.s(paramUri, "uri.toString()");
    if (paramf.acp(paramUri)) {}
    for (int i = 2;; i = 3)
    {
      Log.i("MicroMsg.ExoContentTypeInferer", s.X("infer#ContentContentTypeInferer3, type: ", Integer.valueOf(i)));
      AppMethodBeat.o(328707);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/io/InputStream;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<String, InputStream>
  {
    a(f paramf, Uri paramUri)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c.d
 * JD-Core Version:    0.7.0.1
 */