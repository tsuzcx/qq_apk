package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.x;
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
  
  protected final i a(final WeakReference<ac> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136267);
    paramWeakReference = new x()
    {
      private void bGE()
      {
        AppMethodBeat.i(136263);
        ac localac = (ac)paramWeakReference.get();
        if ((localac == null) || (localac.nmX == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.cbe().e(localac.nmX);
        AppMethodBeat.o(136263);
      }
      
      public final void ZN(String paramAnonymousString)
      {
        AppMethodBeat.i(136261);
        ac localac = (ac)paramWeakReference.get();
        if (localac == null)
        {
          AppMethodBeat.o(136261);
          return;
        }
        try
        {
          int i = this.osn;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", f.afI(paramAnonymousString)).put("data", d.xc(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localac.getRuntime().NY(), localac.getComponentId()).Zg(paramAnonymousString.toString()).bEo();
          AppMethodBeat.o(136261);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136261);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136259);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = f.afI(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.osn).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((ac)paramWeakReference.get()).c("onKeyboardConfirm", paramAnonymousString, 0);
          }
          if (!paramAnonymousBoolean2) {
            ((ac)paramWeakReference.get()).c("onKeyboardComplete", paramAnonymousString, 0);
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
          bGE();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void bGC()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.osn;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((ac)paramWeakReference.get()).i(paramInt, d.this.n("ok", localHashMap));
          d.al(i, paramString);
          d.a(i, (ac)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void bGD()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((ac)paramWeakReference.get()).i(paramInt, d.this.h("fail", null));
          bGE();
        }
        AppMethodBeat.o(136262);
      }
    };
    AppMethodBeat.o(136267);
    return paramWeakReference;
  }
  
  public final void a(ac paramac, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136264);
    super.a(paramac, paramJSONObject, paramInt);
    AppMethodBeat.o(136264);
  }
  
  protected final void a(i parami)
  {
    AppMethodBeat.i(136266);
    super.a(parami);
    parami.OrP = new d.1(this, parami);
    AppMethodBeat.o(136266);
  }
  
  protected final boolean a(e parame, JSONObject paramJSONObject, ac paramac, int paramInt)
  {
    AppMethodBeat.i(136265);
    if (!super.a(parame, paramJSONObject, paramac, paramInt))
    {
      AppMethodBeat.o(136265);
      return false;
    }
    parame.oya = Boolean.TRUE;
    parame.cKo = "emoji";
    parame.cKr = false;
    parame.oxG = false;
    parame.oyb = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    parame.oyq = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean bGA()
  {
    return false;
  }
  
  protected final boolean bGB()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.d
 * JD-Core Version:    0.7.0.1
 */