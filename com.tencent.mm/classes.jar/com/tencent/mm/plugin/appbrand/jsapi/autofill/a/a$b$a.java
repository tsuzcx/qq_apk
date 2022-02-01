package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b$a
  implements a.c
{
  public final a e(g paramg)
  {
    AppMethodBeat.i(326629);
    s.u(paramg, "component");
    Object localObject2 = paramg.getContext();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MMApplicationContext.getContext();
    }
    s.s(localObject1, "component.context ?: MMA…ationContext.getContext()");
    localObject2 = paramg.getAppId();
    s.s(localObject2, "component.appId");
    v localv = new v((Context)localObject1, (String)localObject2);
    localObject1 = paramg.getRuntime();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((AppBrandRuntime)localObject1).getWindowAndroid())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramg.getWindowAndroid();
      }
      s.checkNotNull(localObject2);
      s.s(localObject2, "component.runtime?.windo…omponent.windowAndroid)!!");
      if ((!((c)localObject2).asq()) && (((c)localObject2).asu())) {
        localv.setPosition(1);
      }
      paramg = (a)localv;
      AppMethodBeat.o(326629);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */