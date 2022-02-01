package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.b;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a<com.tencent.mm.plugin.appbrand.widget.input.d.e>
{
  public static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  
  static void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    AppMethodBeat.i(190966);
    try
    {
      paramInt2 = com.tencent.mm.plugin.appbrand.z.g.vH(paramInt2);
      paramaa.c("onKeyboardShow", com.tencent.mm.ac.h.ain().Q("inputId", paramInt1).Q("height", paramInt2).toString(), 0);
      AppMethodBeat.o(190966);
      return;
    }
    catch (com.tencent.mm.ac.g paramaa)
    {
      ad.e("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramaa.getMessage() });
      AppMethodBeat.o(190966);
    }
  }
  
  protected i a(final WeakReference<com.tencent.mm.plugin.appbrand.page.aa> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136286);
    paramWeakReference = new i()
    {
      private void bky()
      {
        AppMethodBeat.i(136284);
        com.tencent.mm.plugin.appbrand.page.aa localaa = (com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get();
        if ((localaa == null) || (localaa.lYc == null))
        {
          AppMethodBeat.o(136284);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bDY().e(localaa.lYc);
        AppMethodBeat.o(136284);
      }
      
      public final void PE(String paramAnonymousString)
      {
        AppMethodBeat.i(136283);
        com.tencent.mm.plugin.appbrand.page.aa localaa = (com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get();
        if (localaa == null)
        {
          AppMethodBeat.o(136283);
          return;
        }
        try
        {
          int i = this.ndw;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.e.Vb(paramAnonymousString)).put("data", h.td(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localaa.getRuntime().Ew(), localaa.aXC()).Ph(paramAnonymousString.toString()).bir();
          AppMethodBeat.o(136283);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136283);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136280);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.e.Vb(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.ndw).put("cursor", paramAnonymousInt).toString();
          if (paramAnonymousBoolean1) {
            ((com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get()).c("onKeyboardConfirm", paramAnonymousString, 0);
          }
          if (!paramAnonymousBoolean2) {
            ((com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get()).c("onKeyboardComplete", paramAnonymousString, 0);
          }
        }
        catch (JSONException paramAnonymousString)
        {
          for (;;)
          {
            ad.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[] { bt.n(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bky();
        }
        AppMethodBeat.o(136280);
      }
      
      public final void bkw()
      {
        AppMethodBeat.i(136281);
        if (paramWeakReference.get() != null)
        {
          int i = this.ndw;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get()).h(paramInt, h.this.m("ok", localHashMap));
          h.ai(i, paramString);
          h.a(i, (com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get());
        }
        AppMethodBeat.o(136281);
      }
      
      public final void bkx()
      {
        AppMethodBeat.i(136282);
        if (paramWeakReference.get() != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get()).h(paramInt, h.this.e("fail", null));
          bky();
        }
        AppMethodBeat.o(136282);
      }
    };
    AppMethodBeat.o(136286);
    return paramWeakReference;
  }
  
  public void a(final com.tencent.mm.plugin.appbrand.page.aa paramaa, JSONObject paramJSONObject, final int paramInt)
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
        if (!bku()) {
          break;
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136275);
            if (o.a(paramaa, k, i, j))
            {
              paramaa.h(paramInt, h.this.e("ok", null));
              AppMethodBeat.o(136275);
              return;
            }
            paramaa.h(paramInt, h.this.e("fail:invalid data", null));
            AppMethodBeat.o(136275);
          }
        });
        AppMethodBeat.o(136285);
        return;
      }
      catch (JSONException localJSONException)
      {
        final com.tencent.mm.plugin.appbrand.widget.input.d.e locale = new com.tencent.mm.plugin.appbrand.widget.input.d.e();
        if (a(locale, paramJSONObject, paramaa, paramInt)) {
          break label137;
        }
        AppMethodBeat.o(136285);
        return;
        if (paramJSONObject.has("inputId")) {
          break label209;
        }
        long l = System.nanoTime();
        locale.ncO = (paramaa.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        a(locale.ncO, 0, paramaa);
        com.tencent.mm.plugin.appbrand.z.m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136276);
            h.a(h.this, paramaa, i, j, this.kNY, locale, paramInt);
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
  
  protected boolean a(com.tencent.mm.plugin.appbrand.widget.input.d.e parame, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.page.aa paramaa, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(136287);
    if (!super.a(parame, paramJSONObject, paramaa, paramInt))
    {
      AppMethodBeat.o(136287);
      return false;
    }
    parame.niR = paramJSONObject.optInt("parentId");
    parame.ncO = paramJSONObject.optInt("inputId");
    parame.niW = Integer.valueOf(Math.max(0, parame.niW.intValue()));
    if (parame.niX == null) {}
    for (int i = 0;; i = Math.max(0, parame.niX.intValue()))
    {
      parame.niX = Integer.valueOf(i);
      parame.cvH = paramJSONObject.optString("type", "text");
      if (o.new.contains(parame.cvH)) {
        break;
      }
      paramaa.h(paramInt, e("fail:unsupported input type", null));
      AppMethodBeat.o(136287);
      return false;
    }
    if (parame.njt == null) {
      parame.njt = Boolean.TRUE;
    }
    parame.cvK = paramJSONObject.optBoolean("password");
    parame.njB = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (bkv())
    {
      paramaa = paramJSONObject.optJSONObject("dropdown");
      if (paramaa != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.niC = paramaa.optInt("marginLeft");
        paramJSONObject.niD = paramaa.optInt("marginRight");
        paramJSONObject.niE = paramaa.optString("width");
        paramaa = paramaa.optJSONArray("options");
        if ((paramaa != null) && (paramaa.length() > 0))
        {
          paramJSONObject.niF = new ArrayList();
          paramInt = j;
          while (paramInt < paramaa.length())
          {
            Object localObject = paramaa.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
              {
                a.b localb = new a.b();
                localb.id = str1;
                localb.title = str2;
                localb.content = ((String)localObject);
                paramJSONObject.niF.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.niU = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(136287);
    return true;
  }
  
  protected boolean bku()
  {
    return true;
  }
  
  protected boolean bkv()
  {
    return true;
  }
  
  public static final class a
    extends p
  {
    public static final int CTRL_INDEX = 78;
    public static final String NAME = "onKeyboardValueChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.h
 * JD-Core Version:    0.7.0.1
 */