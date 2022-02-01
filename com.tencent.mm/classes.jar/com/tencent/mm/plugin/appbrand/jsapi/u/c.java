package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.k.j;
import com.tencent.luggage.wxa.c.a.a;
import com.tencent.luggage.wxa.c.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<v>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public final void a(final v paramv, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(177329);
    ad localad = paramv.getCurrentPageView();
    if (localad == null)
    {
      if ((paramv.getRuntime() != null) && (!paramv.getRuntime().ntU.get()) && (!paramv.getRuntime().mInitialized))
      {
        Log.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramv.getAppId(), Integer.valueOf(paramInt) });
        paramv.getRuntime().O(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138262);
            Log.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { paramv.getAppId(), Integer.valueOf(paramInt) });
            c.this.a(paramv, paramJSONObject, paramInt);
            AppMethodBeat.o(138262);
          }
        });
        AppMethodBeat.o(177329);
        return;
      }
      Log.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { paramv.getAppId(), Integer.valueOf(paramInt) });
      paramv.j(paramInt, h("fail:page don't exist", null));
      AppMethodBeat.o(177329);
      return;
    }
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("confirmText", paramv.getContext().getString(a.f.luggage_wxa_app_ok));
    String str3 = paramJSONObject.optString("cancelText", paramv.getContext().getString(a.f.luggage_wxa_app_cancel));
    boolean bool1 = paramJSONObject.optBoolean("showCancel", true);
    boolean bool2 = paramJSONObject.optBoolean("editable", false);
    int i;
    if (j.cEc.em(paramv.getAppId())) {
      i = g.cO(paramJSONObject.optString("confirmColorDark", ""), MMApplicationContext.getContext().getResources().getColor(a.a.brand_text_color));
    }
    for (int j = g.cO(paramJSONObject.optString("cancelColorDark", ""), MMApplicationContext.getContext().getResources().getColor(a.a.black_color));; j = g.cO(paramJSONObject.optString("cancelColor", ""), MMApplicationContext.getContext().getResources().getColor(a.a.black_color)))
    {
      String str4 = paramJSONObject.optString("content");
      Log.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramv.getAppId(), str1, str4 });
      paramv.P(new c.2(this, paramv, localad, str1, str4, bool2, str2, paramInt, bool1, str3, i, j, paramJSONObject));
      AppMethodBeat.o(177329);
      return;
      i = g.cO(paramJSONObject.optString("confirmColor", ""), MMApplicationContext.getContext().getResources().getColor(a.a.brand_text_color));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.c
 * JD-Core Version:    0.7.0.1
 */