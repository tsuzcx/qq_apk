package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bh;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
        ad.w("MicroMsg.JsApiShowModal", "invoke with appId[%s] callbackId[%d] runtime !initialized, retry", new Object[] { paramq.getAppId(), Integer.valueOf(paramInt) });
        paramq.getRuntime().K(new Runnable()
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
    final String str1 = paramJSONObject.optString("title");
    final String str2 = paramJSONObject.optString("confirmText", paramq.getContext().getString(2131761022));
    final String str3 = paramJSONObject.optString("cancelText", paramq.getContext().getString(2131761020));
    final boolean bool = paramJSONObject.optBoolean("showCancel", true);
    final int i;
    if (i.cjn.Eq()) {
      i = g.bY(paramJSONObject.optString("confirmColorDark", ""), aj.getContext().getResources().getColor(2131100035));
    }
    for (final int j = g.bY(paramJSONObject.optString("cancelColorDark", ""), aj.getContext().getResources().getColor(2131100018));; j = g.bY(paramJSONObject.optString("cancelColor", ""), aj.getContext().getResources().getColor(2131100018)))
    {
      paramJSONObject = paramJSONObject.optString("content");
      ad.i("MicroMsg.JsApiShowModal", "showModal appId[%s] title[%s] content[%s]", new Object[] { paramq.getAppId(), str1, paramJSONObject });
      paramq.L(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(177328);
          if (!paramq.isRunning())
          {
            AppMethodBeat.o(177328);
            return;
          }
          localaa.laX.a(bb.leY);
          b localb = new b(paramq.getContext());
          if (!bt.isNullOrNil(str1))
          {
            if (!bt.isNullOrNil(paramJSONObject)) {
              break label195;
            }
            localb.setMessage(str1);
          }
          for (;;)
          {
            if (!bt.isNullOrNil(paramJSONObject)) {
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
                c.2.this.ccA.h(c.2.this.ccB, c.this.k("ok", paramAnonymous2DialogInterface));
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
                  c.2.this.ccA.h(c.2.this.ccB, c.this.k("ok", localHashMap));
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
                c.2.this.ccA.h(c.2.this.ccB, c.this.k("ok", paramAnonymous2DialogInterface));
                AppMethodBeat.o(177327);
              }
            });
            localb.Wc(i);
            if (bool) {
              localb.Wd(j);
            }
            paramq.getRuntime().hKb.b(localb);
            AppMethodBeat.o(177328);
            return;
            label195:
            localb.setTitle(str1);
          }
        }
      });
      AppMethodBeat.o(177329);
      return;
      i = g.bY(paramJSONObject.optString("confirmColor", ""), aj.getContext().getResources().getColor(2131100035));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c
 * JD-Core Version:    0.7.0.1
 */