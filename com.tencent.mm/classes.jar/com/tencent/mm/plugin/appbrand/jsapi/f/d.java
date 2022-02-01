package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.c;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  
  protected final i a(final WeakReference<com.tencent.mm.plugin.appbrand.page.z> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136267);
    paramWeakReference = new x()
    {
      private void bli()
      {
        AppMethodBeat.i(136263);
        com.tencent.mm.plugin.appbrand.page.z localz = (com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get();
        if ((localz == null) || (localz.mcJ == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bEQ().e(localz.mcJ);
        AppMethodBeat.o(136263);
      }
      
      public final void Qm(String paramAnonymousString)
      {
        AppMethodBeat.i(136261);
        com.tencent.mm.plugin.appbrand.page.z localz = (com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get();
        if (localz == null)
        {
          AppMethodBeat.o(136261);
          return;
        }
        try
        {
          int i = this.niF;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", f.VM(paramAnonymousString)).put("data", d.tg(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localz.getRuntime().Ey(), localz.aXX()).PP(paramAnonymousString.toString()).bja();
          AppMethodBeat.o(136261);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136261);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136259);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = f.VM(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.niF).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get()).c("onKeyboardConfirm", paramAnonymousString, 0);
          }
          if (!paramAnonymousBoolean2) {
            ((com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get()).c("onKeyboardComplete", paramAnonymousString, 0);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ae.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { bu.o(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bli();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void blg()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.niF;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get()).h(paramInt, d.this.n("ok", localHashMap));
          d.ai(i, paramString);
          d.a(i, (com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void blh()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.z)paramWeakReference.get()).h(paramInt, d.this.e("fail", null));
          bli();
        }
        AppMethodBeat.o(136262);
      }
    };
    AppMethodBeat.o(136267);
    return paramWeakReference;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.z paramz, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136264);
    super.a(paramz, paramJSONObject, paramInt);
    AppMethodBeat.o(136264);
  }
  
  protected final void a(final i parami)
  {
    AppMethodBeat.i(136266);
    super.a(parami);
    parami.niC = new i.c()
    {
      public final void dR(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(136258);
        int i = parami.niF;
        Object localObject = com.tencent.mm.model.z.aBG().Bp("AppBrandJsInput@".concat(String.valueOf(i)));
        if (localObject == null) {
          localObject = null;
        }
        while ((localObject == null) || (!((com.tencent.mm.plugin.appbrand.page.z)localObject).isRunning()))
        {
          AppMethodBeat.o(136258);
          return;
          localObject = (WeakReference)((z.b)localObject).get("webview_reference", null);
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = (com.tencent.mm.plugin.appbrand.page.z)((WeakReference)localObject).get();
          }
        }
        d.a locala = new d.a((byte)0);
        HashMap localHashMap = new HashMap();
        localHashMap.put("height", Integer.valueOf(g.vN(paramAnonymousInt2)));
        localHashMap.put("lineCount", Integer.valueOf(paramAnonymousInt1));
        localHashMap.put("inputId", Integer.valueOf(i));
        locala.g((c)localObject).H(localHashMap).bja();
        AppMethodBeat.o(136258);
      }
    };
    AppMethodBeat.o(136266);
  }
  
  protected final boolean a(e parame, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.z paramz, int paramInt)
  {
    AppMethodBeat.i(136265);
    if (!super.a(parame, paramJSONObject, paramz, paramInt))
    {
      AppMethodBeat.o(136265);
      return false;
    }
    parame.nou = Boolean.TRUE;
    parame.cwl = "emoji";
    parame.cwo = false;
    parame.noa = false;
    parame.noA = Boolean.FALSE;
    parame.nov = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean ble()
  {
    return false;
  }
  
  protected final boolean blf()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.d
 * JD-Core Version:    0.7.0.1
 */