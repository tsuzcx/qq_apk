package com.tencent.mm.plugin.appbrand.jsapi.x;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.l.k;
import com.tencent.luggage.wxa.c.a.b;
import com.tencent.luggage.wxa.c.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<y>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public final void a(final y paramy, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(177329);
    ad localad = paramy.getCurrentPageView();
    if (localad == null)
    {
      if ((paramy.getRuntime() != null) && (!paramy.getRuntime().qsE.get()) && (!paramy.getRuntime().mInitialized))
      {
        Log.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramy.getAppId(), Integer.valueOf(paramInt) });
        paramy.getRuntime().U(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138262);
            Log.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { paramy.getAppId(), Integer.valueOf(paramInt) });
            c.this.a(paramy, paramJSONObject, paramInt);
            AppMethodBeat.o(138262);
          }
        });
        AppMethodBeat.o(177329);
        return;
      }
      Log.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { paramy.getAppId(), Integer.valueOf(paramInt) });
      paramy.callback(paramInt, ZP("fail:page don't exist"));
      AppMethodBeat.o(177329);
      return;
    }
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("confirmText", paramy.getContext().getString(a.g.luggage_wxa_app_ok));
    String str3 = paramJSONObject.optString("cancelText", paramy.getContext().getString(a.g.luggage_wxa_app_cancel));
    boolean bool1 = paramJSONObject.optBoolean("showCancel", true);
    boolean bool2 = paramJSONObject.optBoolean("editable", false);
    int i;
    if (k.exm.fJ(paramy.getAppId())) {
      i = i.dq(paramJSONObject.optString("confirmColorDark", ""), MMApplicationContext.getContext().getResources().getColor(a.b.brand_text_color));
    }
    for (int j = i.dq(paramJSONObject.optString("cancelColorDark", ""), MMApplicationContext.getContext().getResources().getColor(a.b.black_color));; j = i.dq(paramJSONObject.optString("cancelColor", ""), MMApplicationContext.getContext().getResources().getColor(a.b.black_color)))
    {
      String str4 = paramJSONObject.optString("content");
      Log.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramy.getAppId(), str1, str4 });
      paramy.V(new c.2(this, paramy, localad, str1, str4, bool2, str2, paramInt, bool1, str3, i, j, paramJSONObject));
      AppMethodBeat.o(177329);
      return;
      i = i.dq(paramJSONObject.optString("confirmColor", ""), MMApplicationContext.getContext().getResources().getColor(a.b.brand_text_color));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.c
 * JD-Core Version:    0.7.0.1
 */