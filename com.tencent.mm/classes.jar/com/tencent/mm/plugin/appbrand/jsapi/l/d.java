package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends h
{
  private static final int CTRL_INDEX = 110;
  private static final String NAME = "insertTextArea";
  
  protected final com.tencent.mm.plugin.appbrand.widget.input.i a(final WeakReference<com.tencent.mm.plugin.appbrand.page.ad> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136267);
    paramWeakReference = new ab()
    {
      private void csq()
      {
        AppMethodBeat.i(136263);
        com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get();
        if ((localad == null) || (localad.tti == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.cQR().e(localad.tti);
        AppMethodBeat.o(136263);
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136259);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = l.agE(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.uFB).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).cJ("onKeyboardConfirm", paramAnonymousString);
          }
          if (!paramAnonymousBoolean2) {
            ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).cJ("onKeyboardComplete", paramAnonymousString);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          csq();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void aaA(String paramAnonymousString)
      {
        AppMethodBeat.i(136261);
        com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get();
        if (localad == null)
        {
          AppMethodBeat.o(136261);
          return;
        }
        try
        {
          int i = this.uFB;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", l.agE(paramAnonymousString)).put("data", d.AL(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localad.getRuntime().ari(), localad.getComponentId()).ZQ(paramAnonymousString.toString()).cpV();
          AppMethodBeat.o(136261);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136261);
        }
      }
      
      public final void cso()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.uFB;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).callback(paramInt, d.this.m("ok", localHashMap));
          d.ax(i, paramString);
          d.a(i, (com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void csp()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).callback(paramInt, d.this.ZP("fail"));
          csq();
        }
        AppMethodBeat.o(136262);
      }
    };
    AppMethodBeat.o(136267);
    return paramWeakReference;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.ad paramad, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136264);
    super.a(paramad, paramJSONObject, paramInt);
    AppMethodBeat.o(136264);
  }
  
  protected final void a(final com.tencent.mm.plugin.appbrand.widget.input.i parami)
  {
    AppMethodBeat.i(136266);
    super.a(parami);
    parami.uFE = new i.c()
    {
      public final void fv(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136258);
        int i = parami.uFB;
        Object localObject = com.tencent.mm.model.ad.bCb().Jm("AppBrandJsInput@".concat(String.valueOf(i)));
        if (localObject == null) {
          localObject = null;
        }
        while ((localObject == null) || (!((com.tencent.mm.plugin.appbrand.page.ad)localObject).isRunning()))
        {
          AppMethodBeat.o(136258);
          return;
          localObject = (WeakReference)((ad.b)localObject).get("webview_reference", null);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = (com.tencent.mm.plugin.appbrand.page.ad)((WeakReference)localObject).get();
          }
        }
        d.a locala = new d.a((byte)0);
        HashMap localHashMap = new HashMap();
        localHashMap.put("height", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DB(paramAnonymousInt2)));
        localHashMap.put("lineCount", Integer.valueOf(paramAnonymousInt1));
        localHashMap.put("inputId", Integer.valueOf(i));
        locala.h((f)localObject).K(localHashMap).cpV();
        AppMethodBeat.o(136258);
      }
    };
    AppMethodBeat.o(136266);
  }
  
  protected final boolean a(e parame, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.ad paramad, int paramInt)
  {
    AppMethodBeat.i(136265);
    if (!super.a(parame, paramJSONObject, paramad, paramInt))
    {
      AppMethodBeat.o(136265);
      return false;
    }
    parame.uLP = Boolean.TRUE;
    parame.eEF = "textarea";
    parame.eEI = false;
    parame.uLv = false;
    parame.uLQ = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    parame.uMg = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    parame.uLX = paramJSONObject.optString("adjustKeyboardTo", "cursor");
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean csm()
  {
    return false;
  }
  
  protected final boolean csn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.d
 * JD-Core Version:    0.7.0.1
 */