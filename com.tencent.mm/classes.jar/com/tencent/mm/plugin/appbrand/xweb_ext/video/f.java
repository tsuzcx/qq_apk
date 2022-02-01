package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/video/VideoPluginHandlerWC;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/VideoPluginHandler;", "()V", "doSetSurfaceSize", "", "plugin-appbrand-integration_release"})
public final class f
  extends com.tencent.luggage.xweb_ext.extendplugin.component.video.c
{
  public final boolean Uf()
  {
    AppMethodBeat.i(277358);
    if (5 == com.tencent.mm.plugin.appbrand.utils.c.cmd()) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(getLogTag(), "doSetSurfaceSize: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(277358);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.f
 * JD-Core Version:    0.7.0.1
 */