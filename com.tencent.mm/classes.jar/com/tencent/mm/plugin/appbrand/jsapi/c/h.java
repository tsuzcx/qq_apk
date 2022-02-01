package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.b;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
    AppMethodBeat.i(200724);
    try
    {
      paramInt2 = com.tencent.mm.plugin.appbrand.z.g.vc(paramInt2);
      paramaa.c("onKeyboardShow", com.tencent.mm.ab.h.afB().N("inputId", paramInt1).N("height", paramInt2).toString(), 0);
      AppMethodBeat.o(200724);
      return;
    }
    catch (com.tencent.mm.ab.g paramaa)
    {
      ac.e("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramaa.getMessage() });
      AppMethodBeat.o(200724);
    }
  }
  
  protected i a(final WeakReference<com.tencent.mm.plugin.appbrand.page.aa> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136286);
    paramWeakReference = new i()
    {
      private void bgT()
      {
        AppMethodBeat.i(136284);
        com.tencent.mm.plugin.appbrand.page.aa localaa = (com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get();
        if ((localaa == null) || (localaa.lyE == null))
        {
          AppMethodBeat.o(136284);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.bzW().e(localaa.lyE);
        AppMethodBeat.o(136284);
      }
      
      public final void Mi(String paramAnonymousString)
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
          int i = this.mCW;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", com.tencent.mm.plugin.appbrand.utils.e.Rv(paramAnonymousString)).put("data", h.sB(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localaa.getRuntime().CX(), localaa.aUT()).LN(paramAnonymousString.toString()).beN();
          AppMethodBeat.o(136283);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136283);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136280);
        if (paramWeakReference.get() != null) {}
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.appbrand.utils.e.Rv(paramAnonymousString);
          paramAnonymousString = new JSONObject().put("value", paramAnonymousString).put("inputId", this.mCW).put("cursor", paramAnonymousInt).toString();
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
            ac.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[] { bs.m(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bgT();
        }
        AppMethodBeat.o(136280);
      }
      
      public final void bgR()
      {
        AppMethodBeat.i(136281);
        if (paramWeakReference.get() != null)
        {
          int i = this.mCW;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get()).h(paramInt, h.this.k("ok", localHashMap));
          h.ag(i, paramString);
          h.a(i, (com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get());
        }
        AppMethodBeat.o(136281);
      }
      
      public final void bgS()
      {
        AppMethodBeat.i(136282);
        if (paramWeakReference.get() != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.aa)paramWeakReference.get()).h(paramInt, h.this.e("fail", null));
          bgT();
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
        if (!bgP()) {
          break;
        }
        ap.f(new Runnable()
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
        locale.mCo = (paramaa.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        a(locale.mCo, 0, paramaa);
        com.tencent.mm.plugin.appbrand.z.l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136276);
            h.a(h.this, paramaa, i, j, this.ksC, locale, paramInt);
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
    parame.mIu = paramJSONObject.optInt("parentId");
    parame.mCo = paramJSONObject.optInt("inputId");
    parame.mIz = Integer.valueOf(Math.max(0, parame.mIz.intValue()));
    if (parame.mIA == null) {}
    for (int i = 0;; i = Math.max(0, parame.mIA.intValue()))
    {
      parame.mIA = Integer.valueOf(i);
      parame.clf = paramJSONObject.optString("type", "text");
      if (o.mDX.contains(parame.clf)) {
        break;
      }
      paramaa.h(paramInt, e("fail:unsupported input type", null));
      AppMethodBeat.o(136287);
      return false;
    }
    if (parame.mIX == null) {
      parame.mIX = Boolean.TRUE;
    }
    parame.cli = paramJSONObject.optBoolean("password");
    parame.mJf = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (bgQ())
    {
      paramaa = paramJSONObject.optJSONObject("dropdown");
      if (paramaa != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.mIf = paramaa.optInt("marginLeft");
        paramJSONObject.mIg = paramaa.optInt("marginRight");
        paramJSONObject.mIh = paramaa.optString("width");
        paramaa = paramaa.optJSONArray("options");
        if ((paramaa != null) && (paramaa.length() > 0))
        {
          paramJSONObject.mIi = new ArrayList();
          paramInt = j;
          while (paramInt < paramaa.length())
          {
            Object localObject = paramaa.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str2)))
              {
                a.b localb = new a.b();
                localb.id = str1;
                localb.title = str2;
                localb.content = ((String)localObject);
                paramJSONObject.mIi.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.mIx = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(136287);
    return true;
  }
  
  protected boolean bgP()
  {
    return true;
  }
  
  protected boolean bgQ()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.c.h
 * JD-Core Version:    0.7.0.1
 */