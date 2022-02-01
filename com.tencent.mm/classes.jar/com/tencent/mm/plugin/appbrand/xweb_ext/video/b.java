package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/video/AppBrandVideoProfileReportWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/report/AppBrandVideoProfileReport;", "()V", "fromErrorInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "errorWhat", "", "errorExtra", "fromThumbErrorInfo", "isThumbMediaPlayer", "", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.ai.e.c.a
{
  public final c eJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272597);
    c localc;
    if (-10000 >= paramInt1) {
      switch (paramInt1 - 10000)
      {
      default: 
        localc = c.pzL;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "fromErrorInfo, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2 + ", errorType: " + localc);
      AppMethodBeat.o(272597);
      return localc;
      localc = c.pzE;
      continue;
      localc = c.pzF;
      continue;
      localc = c.pzH;
      continue;
      localc = c.pzI;
      continue;
      localc = c.pzJ;
      continue;
      localc = c.pzK;
      continue;
      localc = super.eJ(paramInt1, paramInt2);
    }
  }
  
  public final boolean h(e parame)
  {
    return parame instanceof com.tencent.mm.plugin.appbrand.ae.a.a.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.b
 * JD-Core Version:    0.7.0.1
 */