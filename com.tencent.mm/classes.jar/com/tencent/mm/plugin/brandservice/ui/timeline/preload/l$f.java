package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.ab.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/MpWebPrefetcherJsEngineInterceptor$onConfigClient$2", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "cacheVideo", "", "data", "", "plugin-brandservice_release"})
public final class l$f
  implements s
{
  public final void cacheVideo(String paramString)
  {
    AppMethodBeat.i(195608);
    p.h(paramString, "data");
    Log.d("MicroMsg.MpWebPrefetcherJsEngineInterceptor", "[TRACE_VIDEO_PRELOAD] cacheVideo, data = ".concat(String.valueOf(paramString)));
    e locale = e.pAN;
    p.h(paramString, "data");
    try
    {
      f localf = new f(paramString);
      int i = 0;
      int j = localf.length();
      if (i < j)
      {
        paramString = localf.pY(i);
        String str = paramString.optString("url");
        long l1 = paramString.optLong("position");
        int k = paramString.optInt("preloadType");
        long l2 = j.aM(j.aN(paramString.optLong("length"), 10485760L), 512000L);
        if (Util.isNullOrNil(str))
        {
          Log.w("MicroMsg.BizVideoPreloadLogic", "cacheVideo url is null");
          AppMethodBeat.o(195608);
          return;
        }
        if (k == 0) {}
        for (paramString = ToolsMpProcessIPCService.dkO;; paramString = Appbrand0IPCService.dkO)
        {
          p.g(paramString, "processName");
          p.g(str, "url");
          locale.c(paramString, str, l1, l2);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.BizVideoPreloadLogic", "cacheVideo ex " + paramString.getMessage());
      AppMethodBeat.o(195608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.l.f
 * JD-Core Version:    0.7.0.1
 */