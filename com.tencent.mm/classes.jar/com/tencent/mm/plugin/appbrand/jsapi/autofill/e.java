package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumberWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "()V", "onNeedShowPrivacyInfo", "", "env", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "plugin-appbrand-integration_release"})
public final class e
  extends d
{
  public final boolean a(ad paramad, d.b paramb)
  {
    AppMethodBeat.i(281656);
    p.k(paramad, "env");
    t localt;
    if ((paramad instanceof ah))
    {
      localt = ((ah)paramad).getRuntime();
      p.j(localt, "env.runtime");
    }
    for (boolean bool = localt.bDy().nBE.isEnable(); (super.a(paramad, paramb)) && (!bool); bool = false)
    {
      AppMethodBeat.o(281656);
      return true;
    }
    AppMethodBeat.o(281656);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.e
 * JD-Core Version:    0.7.0.1
 */