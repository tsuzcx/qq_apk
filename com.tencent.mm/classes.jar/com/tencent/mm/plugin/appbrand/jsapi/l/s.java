package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.c.e;
import com.tencent.mm.plugin.appbrand.page.t;
import d.g.b.k;
import d.g.b.v.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class s
  extends a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 772;
  public static final String NAME = "setNavigateBackConfirmDialog";
  public static final a kew;
  
  static
  {
    AppMethodBeat.i(177324);
    kew = new a((byte)0);
    AppMethodBeat.o(177324);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(s params, com.tencent.mm.plugin.appbrand.page.q paramq, com.tencent.mm.plugin.appbrand.q paramq1, boolean paramBoolean, v.e parame, int paramInt) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(177322);
      Object localObject = this.kez;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.appbrand.page.q)localObject).getCurrentUrl();; localObject = null)
      {
        CharSequence localCharSequence = (CharSequence)localObject;
        localObject = this.keA.getRuntime();
        k.g(localObject, "env.runtime");
        localObject = ((AppBrandRuntime)localObject).aLK();
        k.g(localObject, "env.runtime.pageContainer");
        com.tencent.mm.plugin.appbrand.page.q localq = ((t)localObject).getCurrentPage();
        localObject = str;
        if (localq != null) {
          localObject = localq.getCurrentUrl();
        }
        if (TextUtils.equals(localCharSequence, (CharSequence)localObject)) {
          break;
        }
        AppMethodBeat.o(177322);
        return;
      }
      localObject = this.keA.getRuntime();
      k.g(localObject, "env.runtime");
      localObject = ((AppBrandRuntime)localObject).aLK();
      k.g(localObject, "env.runtime.pageContainer");
      localObject = ((t)localObject).getCurrentPage();
      if (localObject != null)
      {
        boolean bool = this.keB;
        str = (String)this.keC.Jhw;
        k.g(str, "content");
        ((com.tencent.mm.plugin.appbrand.page.q)localObject).setNetNavigateBackInterceptionInfo(new e(bool, str));
      }
      this.keA.h(this.jxb, this.kex.HI("ok"));
      AppMethodBeat.o(177322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.s
 * JD-Core Version:    0.7.0.1
 */