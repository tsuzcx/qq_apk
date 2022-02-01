package com.tencent.mm.plugin.appbrand.jsapi.autofill.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
public final class a$a
{
  private static final a lJN;
  public static final a lJO;
  
  static
  {
    AppMethodBeat.i(230081);
    lJO = new a();
    lJN = new a();
    AppMethodBeat.o(230081);
  }
  
  public static final a e(d paramd)
  {
    AppMethodBeat.i(230080);
    p.h(paramd, "component");
    a.b localb = (a.b)paramd.M(a.b.class);
    if (localb != null)
    {
      paramd = localb.e(paramd);
      AppMethodBeat.o(230080);
      return paramd;
    }
    paramd = lJN.e(paramd);
    AppMethodBeat.o(230080);
    return paramd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wechat-full-sdk_release"})
  public static final class a
    implements a.b
  {
    public final a e(d paramd)
    {
      AppMethodBeat.i(230079);
      p.h(paramd, "component");
      Object localObject2 = paramd.getContext();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
      }
      localObject2 = paramd.getAppId();
      p.g(localObject2, "component.appId");
      v localv = new v((Context)localObject1, (String)localObject2);
      localObject1 = paramd.getRuntime();
      if (localObject1 != null)
      {
        localObject2 = ((AppBrandRuntime)localObject1).getWindowAndroid();
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = paramd.getWindowAndroid();
      }
      if (localObject1 == null) {
        p.hyc();
      }
      p.g(localObject1, "(component.runtime?.wind…omponent.windowAndroid)!!");
      if ((!((c)localObject1).OD()) && (((c)localObject1).bsj())) {
        localv.setPosition(1);
      }
      paramd = (a)localv;
      AppMethodBeat.o(230079);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.a
 * JD-Core Version:    0.7.0.1
 */