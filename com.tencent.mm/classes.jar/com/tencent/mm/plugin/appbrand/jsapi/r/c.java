package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
  extends a<r>
{
  private static final int CTRL_INDEX = 104;
  private static final String NAME = "showModal";
  
  public final void a(final r paramr, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(177329);
    final z localz = paramr.getCurrentPageView();
    if (localz == null)
    {
      if ((paramr.getRuntime() != null) && (!paramr.getRuntime().isDestroyed()) && (!paramr.getRuntime().mInitialized))
      {
        ae.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramr.getAppId(), Integer.valueOf(paramInt) });
        paramr.getRuntime().J(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(138262);
            ae.i("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { paramr.getAppId(), Integer.valueOf(paramInt) });
            c.this.a(paramr, paramJSONObject, paramInt);
            AppMethodBeat.o(138262);
          }
        });
        AppMethodBeat.o(177329);
        return;
      }
      ae.w("MicroMsg.JsApiShowModal", "invoke failed with appId[%s] callbackId[%d], current page view is null.", new Object[] { paramr.getAppId(), Integer.valueOf(paramInt) });
      paramr.h(paramInt, e("fail:page don't exist", null));
      AppMethodBeat.o(177329);
      return;
    }
    final String str1 = paramJSONObject.optString("title");
    final String str2 = paramJSONObject.optString("confirmText", paramr.getContext().getString(2131761022));
    final String str3 = paramJSONObject.optString("cancelText", paramr.getContext().getString(2131761020));
    final boolean bool = paramJSONObject.optBoolean("showCancel", true);
    final int i;
    if (i.cre.isDarkMode()) {
      i = g.ck(paramJSONObject.optString("confirmColorDark", ""), ak.getContext().getResources().getColor(2131100035));
    }
    for (final int j = g.ck(paramJSONObject.optString("cancelColorDark", ""), ak.getContext().getResources().getColor(2131100018));; j = g.ck(paramJSONObject.optString("cancelColor", ""), ak.getContext().getResources().getColor(2131100018)))
    {
      paramJSONObject = paramJSONObject.optString("content");
      ae.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramr.getAppId(), str1, paramJSONObject });
      paramr.K(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(177328);
          if (!paramr.isRunning())
          {
            AppMethodBeat.o(177328);
            return;
          }
          localz.mgq.a(av.miM);
          b localb = new b(paramr.getContext());
          if (!bu.isNullOrNil(str1))
          {
            if (!bu.isNullOrNil(paramJSONObject)) {
              break label195;
            }
            localb.setMessage(str1);
          }
          for (;;)
          {
            if (!bu.isNullOrNil(paramJSONObject)) {
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
                c.2.this.cjR.h(c.2.this.cjS, c.this.n("ok", paramAnonymous2DialogInterface));
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
                  c.2.this.cjR.h(c.2.this.cjS, c.this.n("ok", localHashMap));
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
                c.2.this.cjR.h(c.2.this.cjS, c.this.n("ok", paramAnonymous2DialogInterface));
                AppMethodBeat.o(177327);
              }
            });
            localb.aaW(i);
            if (bool) {
              localb.aaX(j);
            }
            paramr.getRuntime().iGI.b(localb);
            AppMethodBeat.o(177328);
            return;
            label195:
            localb.setTitle(str1);
          }
        }
      });
      AppMethodBeat.o(177329);
      return;
      i = g.ck(paramJSONObject.optString("confirmColor", ""), ak.getContext().getResources().getColor(2131100035));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.c
 * JD-Core Version:    0.7.0.1
 */