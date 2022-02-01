package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/FallbackContainerFormatInferer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IContainerFormatInferer;", "()V", "isHls", "", "src", "", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d sEK;
  
  static
  {
    AppMethodBeat.i(328660);
    sEK = new d();
    AppMethodBeat.o(328660);
  }
  
  public static boolean acp(String paramString)
  {
    AppMethodBeat.i(328655);
    s.u(paramString, "src");
    b localb = b.sEI;
    boolean bool = b.aco(paramString);
    AppMethodBeat.o(328655);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.d
 * JD-Core Version:    0.7.0.1
 */