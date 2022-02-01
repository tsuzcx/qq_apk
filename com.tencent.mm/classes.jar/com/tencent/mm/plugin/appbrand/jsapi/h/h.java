package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.ac;
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
  
  static void a(int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(230570);
    try
    {
      paramInt2 = com.tencent.mm.plugin.appbrand.ac.g.zB(paramInt2);
      paramac.c("onKeyboardShow", com.tencent.mm.ab.h.ayS().T("inputId", paramInt1).T("height", paramInt2).toString(), 0);
      AppMethodBeat.o(230570);
      return;
    }
    catch (com.tencent.mm.ab.g paramac)
    {
      Log.e("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramac.getMessage() });
      AppMethodBeat.o(230570);
    }
  }
  
  protected i a(final WeakReference<ac> paramWeakReference, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(136286);
    paramWeakReference = new i()
    {
      private void bGE()
      {
        AppMethodBeat.i(136284);
        ac localac = (ac)paramWeakReference.get();
        if ((localac == null) || (localac.nmX == null))
        {
          AppMethodBeat.o(136284);
          return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.h.cbe().e(localac.nmX);
        AppMethodBeat.o(136284);
      }
      
      public final void ZN(String paramAnonymousString)
      {
        AppMethodBeat.i(136283);
        ac localac = (ac)paramWeakReference.get();
        if (localac == null)
        {
          AppMethodBeat.o(136283);
          return;
        }
        try
        {
          int i = this.osn;
          h.a locala = new h.a();
          paramAnonymousString = new JSONObject().put("value", f.afI(paramAnonymousString)).put("data", h.xc(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
          locala.a(localac.getRuntime().NY(), localac.getComponentId()).Zg(paramAnonymousString.toString()).bEo();
          AppMethodBeat.o(136283);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.JsApiShowKeyboard", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(136283);
        }
      }
      
      public final void a(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(136280);
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
            Log.e("MicroMsg.JsApiShowKeyboard", "dispatch input done, exp = %s", new Object[] { Util.stackTraceToString(paramAnonymousString) });
          }
        }
        if (!paramAnonymousBoolean2) {
          bGE();
        }
        AppMethodBeat.o(136280);
      }
      
      public final void bGC()
      {
        AppMethodBeat.i(136281);
        if (paramWeakReference.get() != null)
        {
          int i = this.osn;
          HashMap localHashMap = new HashMap(1);
          localHashMap.put("inputId", Integer.valueOf(i));
          ((ac)paramWeakReference.get()).i(paramInt, h.this.n("ok", localHashMap));
          h.al(i, paramString);
          h.a(i, (ac)paramWeakReference.get());
        }
        AppMethodBeat.o(136281);
      }
      
      public final void bGD()
      {
        AppMethodBeat.i(136282);
        if (paramWeakReference.get() != null)
        {
          ((ac)paramWeakReference.get()).i(paramInt, h.this.h("fail", null));
          bGE();
        }
        AppMethodBeat.o(136282);
      }
    };
    AppMethodBeat.o(136286);
    return paramWeakReference;
  }
  
  public void a(final ac paramac, JSONObject paramJSONObject, final int paramInt)
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
        if (!bGA()) {
          break;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136275);
            if (o.a(paramac, k, i, j))
            {
              paramac.i(paramInt, h.this.h("ok", null));
              AppMethodBeat.o(136275);
              return;
            }
            paramac.i(paramInt, h.this.h("fail:invalid data", null));
            AppMethodBeat.o(136275);
          }
        });
        AppMethodBeat.o(136285);
        return;
      }
      catch (JSONException localJSONException)
      {
        final e locale = new e();
        if (a(locale, paramJSONObject, paramac, paramInt)) {
          break label137;
        }
        AppMethodBeat.o(136285);
        return;
        if (paramJSONObject.has("inputId")) {
          break label209;
        }
        long l = System.nanoTime();
        locale.orE = (paramac.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        a(locale.orE, 0, paramac);
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(136276);
            h.a(h.this, paramac, i, j, this.lWC, locale, paramInt);
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
  
  protected boolean a(e parame, JSONObject paramJSONObject, ac paramac, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(136287);
    if (!super.a(parame, paramJSONObject, paramac, paramInt))
    {
      AppMethodBeat.o(136287);
      return false;
    }
    parame.oxF = paramJSONObject.optInt("parentId");
    parame.orE = paramJSONObject.optInt("inputId");
    parame.oxK = Integer.valueOf(Math.max(0, parame.oxK.intValue()));
    if (parame.oxL == null) {}
    for (int i = 0;; i = Math.max(0, parame.oxL.intValue()))
    {
      parame.oxL = Integer.valueOf(i);
      parame.cKo = paramJSONObject.optString("type", "text");
      if (o.otm.contains(parame.cKo)) {
        break;
      }
      paramac.i(paramInt, h("fail:unsupported input type", null));
      AppMethodBeat.o(136287);
      return false;
    }
    if (parame.oyh == null) {
      parame.oyh = Boolean.TRUE;
    }
    parame.cKr = paramJSONObject.optBoolean("password");
    parame.oyp = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (paramJSONObject.has("showCoverView")) {
      parame.oyq = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    }
    if (bGB())
    {
      paramac = paramJSONObject.optJSONObject("dropdown");
      if (paramac != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.oxq = paramac.optInt("marginLeft");
        paramJSONObject.oxr = paramac.optInt("marginRight");
        paramJSONObject.oxs = paramac.optString("width");
        paramac = paramac.optJSONArray("options");
        if ((paramac != null) && (paramac.length() > 0))
        {
          paramJSONObject.oxt = new ArrayList();
          paramInt = j;
          while (paramInt < paramac.length())
          {
            Object localObject = paramac.optJSONObject(paramInt);
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
                paramJSONObject.oxt.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.oxI = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(136287);
    return true;
  }
  
  protected boolean bGA()
  {
    return true;
  }
  
  protected boolean bGB()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.h
 * JD-Core Version:    0.7.0.1
 */