package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  
  protected final i a(final WeakReference<aa> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136267);
    paramWeakReference = new x()
    {
      private void baa()
      {
        AppMethodBeat.i(136263);
        aa localaa = (aa)paramWeakReference.get();
        if ((localaa == null) || (localaa.kWU == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bsW().e(localaa.kWU);
        AppMethodBeat.o(136263);
      }
      
      public final void Id(String paramAnonymousString)
      {
        AppMethodBeat.i(136261);
        aa localaa = (aa)paramWeakReference.get();
        if (localaa == null)
        {
          AppMethodBeat.o(136261);
          return;
        }
        try
        {
          int i = this.mba;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.e.Nm(paramAnonymousString)).put("data", d.rL(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localaa.getRuntime().Du(), localaa.aOd()).HJ(paramAnonymousString.toString()).aXQ();
          AppMethodBeat.o(136261);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136261);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136259);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.e.Nm(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.mba).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((aa)paramWeakReference.get()).c("onKeyboardConfirm", paramAnonymousString, 0);
          }
          if (!paramAnonymousBoolean2) {
            ((aa)paramWeakReference.get()).c("onKeyboardComplete", paramAnonymousString, 0);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { bt.m(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          baa();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void aZY()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.mba;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((aa)paramWeakReference.get()).h(paramInt, d.this.k("ok", localHashMap));
          d.af(i, paramString);
          d.a(i, (aa)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void aZZ()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((aa)paramWeakReference.get()).h(paramInt, d.this.e("fail", null));
          baa();
        }
        AppMethodBeat.o(136262);
      }
    };
    AppMethodBeat.o(136267);
    return paramWeakReference;
  }
  
  public final void a(aa paramaa, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136264);
    super.a(paramaa, paramJSONObject, paramInt);
    AppMethodBeat.o(136264);
  }
  
  protected final void a(i parami)
  {
    AppMethodBeat.i(136266);
    super.a(parami);
    parami.KDG = new d.1(this, parami);
    AppMethodBeat.o(136266);
  }
  
  protected final boolean a(com.tencent.mm.plugin.appbrand.widget.input.d.e parame, JSONObject paramJSONObject, aa paramaa, int paramInt)
  {
    AppMethodBeat.i(136265);
    if (!super.a(parame, paramJSONObject, paramaa, paramInt))
    {
      AppMethodBeat.o(136265);
      return false;
    }
    parame.mgP = Boolean.TRUE;
    parame.cod = "emoji";
    parame.cog = false;
    parame.mgv = false;
    parame.mgV = Boolean.FALSE;
    parame.mgQ = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean aZW()
  {
    return false;
  }
  
  protected final boolean aZX()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.d
 * JD-Core Version:    0.7.0.1
 */