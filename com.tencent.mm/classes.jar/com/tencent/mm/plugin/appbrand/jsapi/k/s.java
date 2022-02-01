package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.c.e;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import d.g.b.k;
import d.g.b.v.f;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class s
  extends a<q>
{
  public static final int CTRL_INDEX = 772;
  public static final String NAME = "setNavigateBackConfirmDialog";
  public static final a kFo;
  
  static
  {
    AppMethodBeat.i(177324);
    kFo = new a((byte)0);
    AppMethodBeat.o(177324);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiSetNavigateBackConfirmDialog$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wxa-app-jsapi_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(s params, r paramr, q paramq, boolean paramBoolean, v.f paramf, int paramInt) {}
    
    public final void run()
    {
      String str = null;
      AppMethodBeat.i(177322);
      Object localObject = this.kFq;
      if (localObject != null) {}
      for (localObject = ((r)localObject).getCurrentUrl();; localObject = null)
      {
        CharSequence localCharSequence = (CharSequence)localObject;
        localObject = this.kFr.getRuntime();
        k.g(localObject, "env.runtime");
        localObject = ((AppBrandRuntime)localObject).aSA();
        k.g(localObject, "env.runtime.pageContainer");
        r localr = ((u)localObject).getCurrentPage();
        localObject = str;
        if (localr != null) {
          localObject = localr.getCurrentUrl();
        }
        if (TextUtils.equals(localCharSequence, (CharSequence)localObject)) {
          break;
        }
        AppMethodBeat.o(177322);
        return;
      }
      localObject = this.kFr.getRuntime();
      k.g(localObject, "env.runtime");
      localObject = ((AppBrandRuntime)localObject).aSA();
      k.g(localObject, "env.runtime.pageContainer");
      localObject = ((u)localObject).getCurrentPage();
      if (localObject != null)
      {
        boolean bool = this.gxn;
        str = (String)this.kFs.KUQ;
        k.g(str, "content");
        ((r)localObject).setNetNavigateBackInterceptionInfo(new e(bool, str));
      }
      this.kFr.h(this.jXx, this.kFp.LM("ok"));
      AppMethodBeat.o(177322);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.s
 * JD-Core Version:    0.7.0.1
 */