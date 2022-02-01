package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.ab.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/AdWebPrefetcherJsEngineInterceptor$onConfigClient$3", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "key", "replaceAdData", "data", "plugin-brandservice_release"})
public final class a$j
  implements e
{
  public final void deleteAd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195538);
    p.h(paramString, "msgId");
    long l = Util.safeParseLong(paramString);
    if (l == 0L)
    {
      AppMethodBeat.o(195538);
      return;
    }
    if (paramBoolean)
    {
      ag.ban().MX(l);
      AppMethodBeat.o(195538);
      return;
    }
    paramString = ag.ban().MM(l);
    if (paramString != null)
    {
      if (paramString.field_isRead != 1) {
        ag.ban().MX(l);
      }
      AppMethodBeat.o(195538);
      return;
    }
    AppMethodBeat.o(195538);
  }
  
  public final String getAdContext(int paramInt)
  {
    AppMethodBeat.i(195537);
    Object localObject = r.NPl;
    localObject = r.ajQ(paramInt);
    AppMethodBeat.o(195537);
    return localObject;
  }
  
  public final void replaceAdData(String paramString)
  {
    AppMethodBeat.i(195536);
    p.h(paramString, "data");
    r localr = r.NPl;
    r.replaceAdData(paramString);
    AppMethodBeat.o(195536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.j
 * JD-Core Version:    0.7.0.1
 */