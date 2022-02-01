package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class c
  extends a<q>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public final void a(final q paramq, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(177329);
    aa localaa = paramq.getCurrentPageView();
    if (localaa == null)
    {
      if ((paramq.getRuntime() != null) && (!paramq.getRuntime().isDestroyed()) && (!paramq.getRuntime().mInitialized))
      {
        ad.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
        paramq.getRuntime().L(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138262);
            ad.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
            c.this.a(paramq, paramJSONObject, paramInt);
            AppMethodBeat.o(138262);
          }
        });
        AppMethodBeat.o(177329);
        return;
      }
      ad.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
      paramq.h(paramInt, e("fail:page don't exist", null));
      AppMethodBeat.o(177329);
      return;
    }
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("confirmText", paramq.getContext().getString(2131761022));
    String str3 = paramJSONObject.optString("cancelText", paramq.getContext().getString(2131761020));
    boolean bool = paramJSONObject.optBoolean("showCancel", true);
    int i;
    if (i.cqA.isDarkMode()) {
      i = g.cg(paramJSONObject.optString("confirmColorDark", ""), aj.getContext().getResources().getColor(2131100035));
    }
    for (int j = g.cg(paramJSONObject.optString("cancelColorDark", ""), aj.getContext().getResources().getColor(2131100018));; j = g.cg(paramJSONObject.optString("cancelColor", ""), aj.getContext().getResources().getColor(2131100018)))
    {
      paramJSONObject = paramJSONObject.optString("content");
      ad.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramq.getAppId(), str1, paramJSONObject });
      paramq.M(new c.2(this, paramq, localaa, str1, paramJSONObject, str2, paramInt, bool, str3, i, j));
      AppMethodBeat.o(177329);
      return;
      i = g.cg(paramJSONObject.optString("confirmColor", ""), aj.getContext().getResources().getColor(2131100035));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.c
 * JD-Core Version:    0.7.0.1
 */