package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.input.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ae;
import com.tencent.mm.plugin.appbrand.widget.input.au;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.e.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.e.e;
import com.tencent.mm.plugin.appbrand.widget.input.i.b;
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
    AppMethodBeat.i(326125);
    try
    {
      paramInt2 = com.tencent.mm.plugin.appbrand.af.i.DA(paramInt2);
      paramad.cJ("onKeyboardShow", com.tencent.mm.ad.h.aZn().at("inputId", paramInt1).at("height", paramInt2).toString());
      AppMethodBeat.o(326125);
      return;
    }
    catch (g paramad)
    {
      Log.e("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramad.getMessage() });
      AppMethodBeat.o(326125);
    }
  }
  
  protected com.tencent.mm.plugin.appbrand.widget.input.i a(final WeakReference<ad> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136286);
    paramWeakReference = new com.tencent.mm.plugin.appbrand.widget.input.i()
    {
      private void csq()
      {
        AppMethodBeat.i(136284);
        ad localad = (ad)paramWeakReference.get();
        if ((localad == null) || (localad.tti == null))
        {
          AppMethodBeat.o(136284);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.cQR().e(localad.tti);
        AppMethodBeat.o(136284);
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136280);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.l.agE(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.uFB).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((ad)paramWeakReference.get()).cJ("onKeyboardConfirm", paramAnonymousString);
          }
          if (!paramAnonymousBoolean2) {
            ((ad)paramWeakReference.get()).cJ("onKeyboardComplete", paramAnonymousString);
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
          csq();
        }
        AppMethodBeat.o(136280);
      }
      
      public final void aaA(String paramAnonymousString)
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
          int i = this.uFB;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.l.agE(paramAnonymousString)).put("data", h.AL(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localad.getRuntime().ari(), localad.getComponentId()).ZQ(paramAnonymousString.toString()).cpV();
          AppMethodBeat.o(136283);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136283);
        }
      }
      
      public final void cso()
      {
        AppMethodBeat.i(136281);
        if (paramWeakReference.get() != null)
        {
          int i = this.uFB;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((ad)paramWeakReference.get()).callback(paramInt, h.this.m("ok", localHashMap));
          h.ax(i, paramString);
          h.a(i, (ad)paramWeakReference.get());
        }
        AppMethodBeat.o(136281);
      }
      
      public final void csp()
      {
        AppMethodBeat.i(136282);
        if (paramWeakReference.get() != null)
        {
          ((ad)paramWeakReference.get()).callback(paramInt, h.this.ZP("fail"));
          csq();
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
        if (!csm()) {
          break;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136275);
            if (com.tencent.mm.plugin.appbrand.widget.input.o.a(paramad, k, i, j))
            {
              paramad.callback(paramInt, h.this.ZP("ok"));
              AppMethodBeat.o(136275);
              return;
            }
            paramad.callback(paramInt, h.this.ZP("fail:invalid data"));
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
        locale.uES = (paramad.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        a(locale.uES, 0, paramad);
        com.tencent.mm.plugin.appbrand.af.o.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136276);
            h.a(h.this, paramad, i, j, this.rZC, locale, paramInt);
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
  
  protected void a(com.tencent.mm.plugin.appbrand.widget.input.i parami) {}
  
  protected boolean a(e parame, JSONObject paramJSONObject, ad paramad, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(136287);
    if (!super.a(parame, paramJSONObject, paramad, paramInt))
    {
      AppMethodBeat.o(136287);
      return false;
    }
    parame.uLu = paramJSONObject.optInt("parentId");
    parame.uES = paramJSONObject.optInt("inputId");
    parame.uLz = Integer.valueOf(Math.max(0, parame.uLz.intValue()));
    if (parame.uLA == null) {}
    for (int i = 0;; i = Math.max(0, parame.uLA.intValue()))
    {
      parame.uLA = Integer.valueOf(i);
      parame.eEF = paramJSONObject.optString("type", "text");
      if (com.tencent.mm.plugin.appbrand.widget.input.o.uGB.contains(parame.eEF)) {
        break;
      }
      paramad.callback(paramInt, ZP("fail:unsupported input type"));
      AppMethodBeat.o(136287);
      return false;
    }
    if (parame.uLW == null) {
      parame.uLW = Boolean.TRUE;
    }
    parame.eEI = paramJSONObject.optBoolean("password");
    parame.uMf = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (paramJSONObject.has("showCoverView")) {
      parame.uMg = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    }
    au.a(paramJSONObject, parame);
    if (csn())
    {
      paramad = paramJSONObject.optJSONObject("dropdown");
      if (paramad != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.uLf = paramad.optInt("marginLeft");
        paramJSONObject.uLg = paramad.optInt("marginRight");
        paramJSONObject.uLh = paramad.optString("width");
        paramad = paramad.optJSONArray("options");
        if ((paramad != null) && (paramad.length() > 0))
        {
          paramJSONObject.uLi = new ArrayList();
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
                paramJSONObject.uLi.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.uLx = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(136287);
    return true;
  }
  
  protected boolean csm()
  {
    return true;
  }
  
  protected boolean csn()
  {
    return true;
  }
  
  public static final class a
    extends s
  {
    public static final int CTRL_INDEX = 78;
    public static final String NAME = "onKeyboardValueChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.h
 * JD-Core Version:    0.7.0.1
 */