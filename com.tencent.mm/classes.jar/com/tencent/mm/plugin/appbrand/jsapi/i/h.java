package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ae;
import com.tencent.mm.plugin.appbrand.widget.input.au;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.b;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a<e>
{
  public static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  
  static void a(int paramInt1, int paramInt2, ad paramad)
  {
    AppMethodBeat.i(214890);
    try
    {
      paramInt2 = com.tencent.mm.plugin.appbrand.ac.g.Dg(paramInt2);
      paramad.ct("onKeyboardShow", com.tencent.mm.ad.h.aGm().ak("inputId", paramInt1).ak("height", paramInt2).toString());
      AppMethodBeat.o(214890);
      return;
    }
    catch (com.tencent.mm.ad.g paramad)
    {
      Log.e("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramad.getMessage() });
      AppMethodBeat.o(214890);
    }
  }
  
  protected i a(final WeakReference<ad> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136286);
    paramWeakReference = new i()
    {
      private void bSl()
      {
        AppMethodBeat.i(136284);
        ad localad = (ad)paramWeakReference.get();
        if ((localad == null) || (localad.qoF == null))
        {
          AppMethodBeat.o(136284);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.cop().e(localad.qoF);
        AppMethodBeat.o(136284);
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136280);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.h.ank(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.ruw).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((ad)paramWeakReference.get()).ct("onKeyboardConfirm", paramAnonymousString);
          }
          if (!paramAnonymousBoolean2) {
            ((ad)paramWeakReference.get()).ct("onKeyboardComplete", paramAnonymousString);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            Log.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bSl();
        }
        AppMethodBeat.o(136280);
      }
      
      public final void ahD(String paramAnonymousString)
      {
        AppMethodBeat.i(136283);
        ad localad = (ad)paramWeakReference.get();
        if (localad == null)
        {
          AppMethodBeat.o(136283);
          return;
        }
        try
        {
          int i = this.ruw;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.h.ank(paramAnonymousString)).put("data", h.Ay(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localad.getRuntime().QW(), localad.getComponentId()).agT(paramAnonymousString.toString()).bPO();
          AppMethodBeat.o(136283);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136283);
        }
      }
      
      public final void bSj()
      {
        AppMethodBeat.i(136281);
        if (paramWeakReference.get() != null)
        {
          int i = this.ruw;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((ad)paramWeakReference.get()).j(paramInt, h.this.m("ok", localHashMap));
          h.an(i, paramString);
          h.a(i, (ad)paramWeakReference.get());
        }
        AppMethodBeat.o(136281);
      }
      
      public final void bSk()
      {
        AppMethodBeat.i(136282);
        if (paramWeakReference.get() != null)
        {
          ((ad)paramWeakReference.get()).j(paramInt, h.this.h("fail", null));
          bSl();
        }
        AppMethodBeat.o(136282);
      }
    };
    AppMethodBeat.o(136286);
    return paramWeakReference;
  }
  
  public void a(final ad paramad, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136285);
    final int i = paramJSONObject.optInt("cursor", -2);
    if ((paramJSONObject.has("selectionStart")) || (paramJSONObject.has("selectionEnd"))) {
      i = paramJSONObject.optInt("selectionStart", -2);
    }
    for (final int j = paramJSONObject.optInt("selectionEnd", -2);; j = i) {
      try
      {
        final int k = paramJSONObject.getInt("inputId");
        if (!bSh()) {
          break;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136275);
            if (com.tencent.mm.plugin.appbrand.widget.input.o.a(paramad, k, i, j))
            {
              paramad.j(paramInt, h.this.h("ok", null));
              AppMethodBeat.o(136275);
              return;
            }
            paramad.j(paramInt, h.this.h("fail:invalid data", null));
            AppMethodBeat.o(136275);
          }
        });
        AppMethodBeat.o(136285);
        return;
      }
      catch (JSONException localJSONException)
      {
        final e locale = new e();
        if (a(locale, paramJSONObject, paramad, paramInt)) {
          break label137;
        }
        AppMethodBeat.o(136285);
        return;
        if (paramJSONObject.has("inputId")) {
          break label209;
        }
        long l = System.nanoTime();
        locale.rtN = (paramad.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        a(locale.rtN, 0, paramad);
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136276);
            h.a(h.this, paramad, i, j, this.oUn, locale, paramInt);
            AppMethodBeat.o(136276);
          }
        });
        AppMethodBeat.o(136285);
      }
    }
    label137:
    label209:
    return;
  }
  
  protected void a(i parami) {}
  
  protected boolean a(e parame, JSONObject paramJSONObject, ad paramad, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(136287);
    if (!super.a(parame, paramJSONObject, paramad, paramInt))
    {
      AppMethodBeat.o(136287);
      return false;
    }
    parame.rAd = paramJSONObject.optInt("parentId");
    parame.rtN = paramJSONObject.optInt("inputId");
    parame.rAj = Integer.valueOf(Math.max(0, parame.rAj.intValue()));
    if (parame.rAk == null) {}
    for (int i = 0;; i = Math.max(0, parame.rAk.intValue()))
    {
      parame.rAk = Integer.valueOf(i);
      parame.cKU = paramJSONObject.optString("type", "text");
      if (com.tencent.mm.plugin.appbrand.widget.input.o.rvw.contains(parame.cKU)) {
        break;
      }
      paramad.j(paramInt, h("fail:unsupported input type", null));
      AppMethodBeat.o(136287);
      return false;
    }
    if (parame.rAG == null) {
      parame.rAG = Boolean.TRUE;
    }
    parame.cKX = paramJSONObject.optBoolean("password");
    parame.rAP = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (paramJSONObject.has("showCoverView")) {
      parame.rAQ = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    }
    au.a(paramJSONObject, parame);
    if (bSi())
    {
      paramad = paramJSONObject.optJSONObject("dropdown");
      if (paramad != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.rzO = paramad.optInt("marginLeft");
        paramJSONObject.rzP = paramad.optInt("marginRight");
        paramJSONObject.rzQ = paramad.optString("width");
        paramad = paramad.optJSONArray("options");
        if ((paramad != null) && (paramad.length() > 0))
        {
          paramJSONObject.rzR = new ArrayList();
          paramInt = j;
          while (paramInt < paramad.length())
          {
            Object localObject = paramad.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)))
              {
                a.b localb = new a.b();
                localb.id = str1;
                localb.title = str2;
                localb.content = ((String)localObject);
                paramJSONObject.rzR.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.rAg = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(136287);
    return true;
  }
  
  protected boolean bSh()
  {
    return true;
  }
  
  protected boolean bSi()
  {
    return true;
  }
  
  public static final class a
    extends r
  {
    public static final int CTRL_INDEX = 78;
    public static final String NAME = "onKeyboardValueChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.h
 * JD-Core Version:    0.7.0.1
 */