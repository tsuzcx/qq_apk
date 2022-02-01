package com.tencent.mm.plugin.appbrand.xweb_ext.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/video/AppBrandVideoProfileReportWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/report/AppBrandVideoProfileReport;", "()V", "fromErrorInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "errorWhat", "", "errorExtra", "fromThumbErrorInfo", "isThumbMediaPlayer", "", "mediaPlayer", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public final e fD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(317160);
    e locale;
    if (-10000 >= paramInt1) {
      switch (paramInt1 - 10000)
      {
      default: 
        locale = e.sET;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoProfileReport", "fromErrorInfo, errorWhat: " + paramInt1 + ", errorExtra: " + paramInt2 + ", errorType: " + locale);
      AppMethodBeat.o(317160);
      return locale;
      locale = e.sEM;
      continue;
      locale = e.sEN;
      continue;
      locale = e.sEP;
      continue;
      locale = e.sEQ;
      continue;
      locale = e.sER;
      continue;
      locale = e.sES;
      continue;
      locale = super.fD(paramInt1, paramInt2);
    }
  }
  
  public final boolean g(g paramg)
  {
    AppMethodBeat.i(317153);
    if ((paramg != null) && (3 == paramg.getPlayerType()))
    {
      AppMethodBeat.o(317153);
      return true;
    }
    AppMethodBeat.o(317153);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.video.b
 * JD-Core Version:    0.7.0.1
 */