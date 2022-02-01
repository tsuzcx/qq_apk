package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.b;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  
  static void a(int paramInt1, int paramInt2, z paramz)
  {
    AppMethodBeat.i(221714);
    try
    {
      paramInt2 = com.tencent.mm.plugin.appbrand.y.g.vM(paramInt2);
      paramz.c("onKeyboardShow", com.tencent.mm.ab.h.aiC().R("inputId", paramInt1).R("height", paramInt2).toString(), 0);
      AppMethodBeat.o(221714);
      return;
    }
    catch (com.tencent.mm.ab.g paramz)
    {
      ae.e("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramz.getMessage() });
      AppMethodBeat.o(221714);
    }
  }
  
  protected i a(final WeakReference<z> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136286);
    paramWeakReference = new i()
    {
      private void bli()
      {
        AppMethodBeat.i(136284);
        z localz = (z)paramWeakReference.get();
        if ((localz == null) || (localz.mcJ == null))
        {
          AppMethodBeat.o(136284);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bEQ().e(localz.mcJ);
        AppMethodBeat.o(136284);
      }
      
      public final void Qm(String paramAnonymousString)
      {
        AppMethodBeat.i(136283);
        z localz = (z)paramWeakReference.get();
        if (localz == null)
        {
          AppMethodBeat.o(136283);
          return;
        }
        try
        {
          int i = this.niF;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", f.VM(paramAnonymousString)).put("data", h.tg(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localz.getRuntime().Ey(), localz.aXX()).PP(paramAnonymousString.toString()).bja();
          AppMethodBeat.o(136283);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136283);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136280);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = f.VM(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.niF).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((z)paramWeakReference.get()).c("onKeyboardConfirm", paramAnonymousString, 0);
          }
          if (!paramAnonymousBoolean2) {
            ((z)paramWeakReference.get()).c("onKeyboardComplete", paramAnonymousString, 0);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ae.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[] { bu.o(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bli();
        }
        AppMethodBeat.o(136280);
      }
      
      public final void blg()
      {
        AppMethodBeat.i(136281);
        if (paramWeakReference.get() != null)
        {
          int i = this.niF;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((z)paramWeakReference.get()).h(paramInt, h.this.n("ok", localHashMap));
          h.ai(i, paramString);
          h.a(i, (z)paramWeakReference.get());
        }
        AppMethodBeat.o(136281);
      }
      
      public final void blh()
      {
        AppMethodBeat.i(136282);
        if (paramWeakReference.get() != null)
        {
          ((z)paramWeakReference.get()).h(paramInt, h.this.e("fail", null));
          bli();
        }
        AppMethodBeat.o(136282);
      }
    };
    AppMethodBeat.o(136286);
    return paramWeakReference;
  }
  
  public void a(final z paramz, JSONObject paramJSONObject, final int paramInt)
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
        if (!ble()) {
          break;
        }
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136275);
            if (o.a(paramz, k, i, j))
            {
              paramz.h(paramInt, h.this.e("ok", null));
              AppMethodBeat.o(136275);
              return;
            }
            paramz.h(paramInt, h.this.e("fail:invalid data", null));
            AppMethodBeat.o(136275);
          }
        });
        AppMethodBeat.o(136285);
        return;
      }
      catch (JSONException localJSONException)
      {
        final e locale = new e();
        if (a(locale, paramJSONObject, paramz, paramInt)) {
          break label137;
        }
        AppMethodBeat.o(136285);
        return;
        if (paramJSONObject.has("inputId")) {
          break label209;
        }
        long l = System.nanoTime();
        locale.nhX = (paramz.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        a(locale.nhX, 0, paramz);
        com.tencent.mm.plugin.appbrand.y.m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136276);
            h.a(h.this, paramz, i, j, this.kRA, locale, paramInt);
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
  
  protected boolean a(e parame, JSONObject paramJSONObject, z paramz, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(136287);
    if (!super.a(parame, paramJSONObject, paramz, paramInt))
    {
      AppMethodBeat.o(136287);
      return false;
    }
    parame.nnZ = paramJSONObject.optInt("parentId");
    parame.nhX = paramJSONObject.optInt("inputId");
    parame.noe = Integer.valueOf(Math.max(0, parame.noe.intValue()));
    if (parame.nof == null) {}
    for (int i = 0;; i = Math.max(0, parame.nof.intValue()))
    {
      parame.nof = Integer.valueOf(i);
      parame.cwl = paramJSONObject.optString("type", "text");
      if (o.njE.contains(parame.cwl)) {
        break;
      }
      paramz.h(paramInt, e("fail:unsupported input type", null));
      AppMethodBeat.o(136287);
      return false;
    }
    if (parame.noB == null) {
      parame.noB = Boolean.TRUE;
    }
    parame.cwo = paramJSONObject.optBoolean("password");
    parame.noJ = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (blf())
    {
      paramz = paramJSONObject.optJSONObject("dropdown");
      if (paramz != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.nnK = paramz.optInt("marginLeft");
        paramJSONObject.nnL = paramz.optInt("marginRight");
        paramJSONObject.nnM = paramz.optString("width");
        paramz = paramz.optJSONArray("options");
        if ((paramz != null) && (paramz.length() > 0))
        {
          paramJSONObject.nnN = new ArrayList();
          paramInt = j;
          while (paramInt < paramz.length())
          {
            Object localObject = paramz.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!bu.isNullOrNil(str1)) && (!bu.isNullOrNil(str2)))
              {
                a.b localb = new a.b();
                localb.id = str1;
                localb.title = str2;
                localb.content = ((String)localObject);
                paramJSONObject.nnN.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.noc = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(136287);
    return true;
  }
  
  protected boolean ble()
  {
    return true;
  }
  
  protected boolean blf()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.h
 * JD-Core Version:    0.7.0.1
 */