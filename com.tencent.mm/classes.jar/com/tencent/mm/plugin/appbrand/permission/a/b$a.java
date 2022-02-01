package com.tencent.mm.plugin.appbrand.permission.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory;", "", "()V", "DEFAULT_IMPL", "com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
public final class b$a
{
  private static final a nyy;
  public static final a nyz;
  
  static
  {
    AppMethodBeat.i(230127);
    nyz = new a();
    nyy = new a();
    AppMethodBeat.o(230127);
  }
  
  public static final b a(d paramd, b.c paramc)
  {
    AppMethodBeat.i(230126);
    p.h(paramd, "component");
    p.h(paramc, "listener");
    b.b localb = (b.b)paramd.M(b.b.class);
    if (localb != null)
    {
      paramd = localb.a(paramd, paramc);
      AppMethodBeat.o(230126);
      return paramd;
    }
    paramd = nyy.a(paramd, paramc);
    AppMethodBeat.o(230126);
    return paramd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Factory$DEFAULT_IMPL$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$FactoryInterface;", "createPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "luggage-wechat-full-sdk_release"})
  public static final class a
    implements b.b
  {
    public final b a(d paramd, b.c paramc)
    {
      AppMethodBeat.i(230125);
      p.h(paramd, "component");
      p.h(paramc, "listener");
      Object localObject = paramd.getRuntime();
      if (localObject != null)
      {
        localObject = ((AppBrandRuntime)localObject).getWindowAndroid();
        if (localObject != null) {}
      }
      else
      {
        localObject = paramd.getWindowAndroid();
      }
      for (;;)
      {
        if (localObject == null) {
          p.hyc();
        }
        p.g(localObject, "(component.runtime?.wind…omponent.windowAndroid)!!");
        boolean bool = ((c)localObject).OD();
        Context localContext = paramd.getContext();
        paramd = localContext;
        if (localContext == null)
        {
          paramd = MMApplicationContext.getContext();
          p.g(paramd, "MMApplicationContext.getContext()");
        }
        paramd = new h(paramd, paramc, bool);
        if ((!bool) && (((c)localObject).bsj())) {
          paramd.setPosition(1);
        }
        paramd = (b)paramd;
        AppMethodBeat.o(230125);
        return paramd;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.b.a
 * JD-Core Version:    0.7.0.1
 */