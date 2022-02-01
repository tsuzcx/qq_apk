package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.i;
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
  
  protected final i a(final WeakReference<com.tencent.mm.plugin.appbrand.page.ad> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136267);
    paramWeakReference = new ab()
    {
      private void bSl()
      {
        AppMethodBeat.i(136263);
        com.tencent.mm.plugin.appbrand.page.ad localad = (com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get();
        if ((localad == null) || (localad.qoF == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.cop().e(localad.qoF);
        AppMethodBeat.o(136263);
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136259);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.h.ank(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.ruw).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).ct("onKeyboardConfirm", paramAnonymousString);
          }
          if (!paramAnonymousBoolean2) {
            ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).ct("onKeyboardComplete", paramAnonymousString);
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
          bSl();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void ahD(String paramAnonymousString)
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
          int i = this.ruw;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.h.ank(paramAnonymousString)).put("data", d.Ay(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localad.getRuntime().QW(), localad.getComponentId()).agT(paramAnonymousString.toString()).bPO();
          AppMethodBeat.o(136261);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136261);
        }
      }
      
      public final void bSj()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.ruw;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).j(paramInt, d.this.m("ok", localHashMap));
          d.an(i, paramString);
          d.a(i, (com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void bSk()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.ad)paramWeakReference.get()).j(paramInt, d.this.h("fail", null));
          bSl();
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
  
  protected final void a(final i parami)
  {
    AppMethodBeat.i(136266);
    super.a(parami);
    parami.rHc = new i.c()
    {
      public final void eB(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136258);
        int i = parami.ruw;
        Object localObject = com.tencent.mm.model.ad.beh().Rn("AppBrandJsInput@".concat(String.valueOf(i)));
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
        localHashMap.put("height", Integer.valueOf(g.Dh(paramAnonymousInt2)));
        localHashMap.put("lineCount", Integer.valueOf(paramAnonymousInt1));
        localHashMap.put("inputId", Integer.valueOf(i));
        locala.i((com.tencent.mm.plugin.appbrand.jsapi.e)localObject).D(localHashMap).bPO();
        AppMethodBeat.o(136258);
      }
    };
    AppMethodBeat.o(136266);
  }
  
  protected final boolean a(com.tencent.mm.plugin.appbrand.widget.input.e.e parame, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.ad paramad, int paramInt)
  {
    AppMethodBeat.i(136265);
    if (!super.a(parame, paramJSONObject, paramad, paramInt))
    {
      AppMethodBeat.o(136265);
      return false;
    }
    parame.rAz = Boolean.TRUE;
    parame.cKU = "textarea";
    parame.cKX = false;
    parame.rAe = false;
    parame.rAA = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    parame.rAQ = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    parame.rAH = paramJSONObject.optString("adjustKeyboardTo", "cursor");
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean bSh()
  {
    return false;
  }
  
  protected final boolean bSi()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d
 * JD-Core Version:    0.7.0.1
 */