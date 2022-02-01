package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q.a;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$getNicknameAsync$1", "Lcom/tencent/mm/plugin/appbrand/service/IWeAppInfoService$IGetWeAppInfoCallback;", "onGetWeAppInfo", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "plugin-appbrand-integration_release"})
public final class a$b
  implements q.a
{
  a$b(b paramb) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(268164);
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(268164);
      return;
    }
    this.jFa.invoke(paramWxaAttributes);
    AppMethodBeat.o(268164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.a.b
 * JD-Core Version:    0.7.0.1
 */