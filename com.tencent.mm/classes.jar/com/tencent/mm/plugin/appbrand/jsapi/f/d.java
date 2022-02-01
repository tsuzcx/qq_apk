package com.tencent.mm.plugin.appbrand.jsapi.f;

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
      private void bky()
      {
        AppMethodBeat.i(136263);
        aa localaa = (aa)paramWeakReference.get();
        if ((localaa == null) || (localaa.lYc == null))
        {
          AppMethodBeat.o(136263);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bDY().e(localaa.lYc);
        AppMethodBeat.o(136263);
      }
      
      public final void PE(String paramAnonymousString)
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
          int i = this.ndw;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.e.Vb(paramAnonymousString)).put("data", d.td(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localaa.getRuntime().Ew(), localaa.aXC()).Ph(paramAnonymousString.toString()).bir();
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
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.e.Vb(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.ndw).put("cursor", paramAnonymousInt).toString();
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
            ad.e("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { bt.n(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bky();
        }
        AppMethodBeat.o(136259);
      }
      
      public final void bkw()
      {
        AppMethodBeat.i(136260);
        if (paramWeakReference.get() != null)
        {
          int i = this.ndw;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((aa)paramWeakReference.get()).h(paramInt, d.this.m("ok", localHashMap));
          d.ai(i, paramString);
          d.a(i, (aa)paramWeakReference.get());
        }
        AppMethodBeat.o(136260);
      }
      
      public final void bkx()
      {
        AppMethodBeat.i(136262);
        if (paramWeakReference.get() != null)
        {
          ((aa)paramWeakReference.get()).h(paramInt, d.this.e("fail", null));
          bky();
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
    parami.sZT = new d.1(this, parami);
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
    parame.njm = Boolean.TRUE;
    parame.cvH = "emoji";
    parame.cvK = false;
    parame.niS = false;
    parame.njs = Boolean.FALSE;
    parame.njn = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    AppMethodBeat.o(136265);
    return true;
  }
  
  protected final boolean bku()
  {
    return false;
  }
  
  protected final boolean bkv()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.d
 * JD-Core Version:    0.7.0.1
 */