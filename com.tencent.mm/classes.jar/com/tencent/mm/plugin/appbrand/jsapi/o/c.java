package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.bc;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a<q>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public final void a(final q paramq, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(177329);
    final aa localaa = paramq.getCurrentPageView();
    if (localaa == null)
    {
      if ((paramq.getRuntime() != null) && (!paramq.getRuntime().isDestroyed()) && (!paramq.getRuntime().mInitialized))
      {
        ac.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
        paramq.getRuntime().M(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138262);
            ac.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
            c.this.a(paramq, paramJSONObject, paramInt);
            AppMethodBeat.o(138262);
          }
        });
        AppMethodBeat.o(177329);
        return;
      }
      ac.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
      paramq.h(paramInt, e("fail:page don't exist", null));
      AppMethodBeat.o(177329);
      return;
    }
    final String str1 = paramJSONObject.optString("title");
    final String str2 = paramJSONObject.optString("confirmText", paramq.getContext().getString(2131761022));
    final String str3 = paramJSONObject.optString("cancelText", paramq.getContext().getString(2131761020));
    final boolean bool = paramJSONObject.optBoolean("showCancel", true);
    final int i;
    if (i.cgk.DT()) {
      i = g.cd(paramJSONObject.optString("confirmColorDark", ""), ai.getContext().getResources().getColor(2131100035));
    }
    for (final int j = g.cd(paramJSONObject.optString("cancelColorDark", ""), ai.getContext().getResources().getColor(2131100018));; j = g.cd(paramJSONObject.optString("cancelColor", ""), ai.getContext().getResources().getColor(2131100018)))
    {
      paramJSONObject = paramJSONObject.optString("content");
      ac.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramq.getAppId(), str1, paramJSONObject });
      paramq.N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(177328);
          if (!paramq.isRunning())
          {
            AppMethodBeat.o(177328);
            return;
          }
          localaa.lCw.a(aw.lEO);
          b localb = new b(paramq.getContext());
          if (!bs.isNullOrNil(str1))
          {
            if (!bs.isNullOrNil(paramJSONObject)) {
              break label195;
            }
            localb.setMessage(str1);
          }
          for (;;)
          {
            if (!bs.isNullOrNil(paramJSONObject)) {
              localb.setMessage(paramJSONObject);
            }
            localb.a(str2, true, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(177325);
                paramAnonymous2DialogInterface = new HashMap();
                paramAnonymous2DialogInterface.put("confirm", Boolean.TRUE);
                paramAnonymous2DialogInterface.put("cancel", Boolean.FALSE);
                c.2.this.bZx.h(c.2.this.bZy, c.this.k("ok", paramAnonymous2DialogInterface));
                AppMethodBeat.o(177325);
              }
            });
            if (bool) {
              localb.b(str3, false, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(177326);
                  HashMap localHashMap = new HashMap();
                  localHashMap.put("confirm", Boolean.FALSE);
                  localHashMap.put("cancel", Boolean.TRUE);
                  paramAnonymous2DialogInterface.dismiss();
                  c.2.this.bZx.h(c.2.this.bZy, c.this.k("ok", localHashMap));
                  AppMethodBeat.o(177326);
                }
              });
            }
            localb.setOnCancelListener(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(177327);
                paramAnonymous2DialogInterface = new HashMap();
                paramAnonymous2DialogInterface.put("confirm", Boolean.FALSE);
                paramAnonymous2DialogInterface.put("cancel", Boolean.TRUE);
                c.2.this.bZx.h(c.2.this.bZy, c.this.k("ok", paramAnonymous2DialogInterface));
                AppMethodBeat.o(177327);
              }
            });
            localb.Yl(i);
            if (bool) {
              localb.Ym(j);
            }
            paramq.getRuntime().iky.b(localb);
            AppMethodBeat.o(177328);
            return;
            label195:
            localb.setTitle(str1);
          }
        }
      });
      AppMethodBeat.o(177329);
      return;
      i = g.cd(paramJSONObject.optString("confirmColor", ""), ai.getContext().getResources().getColor(2131100035));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c
 * JD-Core Version:    0.7.0.1
 */