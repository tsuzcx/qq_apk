package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumberWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "()V", "onNeedShowPrivacyInfo", "", "env", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d
{
  public final boolean a(ad paramad, d.b paramb)
  {
    AppMethodBeat.i(326630);
    s.u(paramad, "env");
    if ((paramad instanceof ah)) {}
    for (boolean bool = ((ah)paramad).getRuntime().getInitConfig().qAT.isEnable(); (super.a(paramad, paramb)) && (!bool); bool = false)
    {
      AppMethodBeat.o(326630);
      return true;
    }
    AppMethodBeat.o(326630);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.e
 * JD-Core Version:    0.7.0.1
 */