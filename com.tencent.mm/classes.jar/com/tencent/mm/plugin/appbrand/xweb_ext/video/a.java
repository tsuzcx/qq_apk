package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/video/AppBrandVideoCustomHandlerWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCustomHandler;", "()V", "buildVideoProfileReporter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/report/AppBrandVideoProfileReport;", "isSupportGetCachedBytes", "", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "plugin-appbrand-integration_release"})
public final class a
  extends c
{
  public final com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a bYz()
  {
    AppMethodBeat.i(267729);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a locala = (com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a)new b();
    AppMethodBeat.o(267729);
    return locala;
  }
  
  public final boolean g(e parame)
  {
    AppMethodBeat.i(267730);
    if (!this.pLS.h(parame))
    {
      AppMethodBeat.o(267730);
      return true;
    }
    AppMethodBeat.o(267730);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.a
 * JD-Core Version:    0.7.0.1
 */