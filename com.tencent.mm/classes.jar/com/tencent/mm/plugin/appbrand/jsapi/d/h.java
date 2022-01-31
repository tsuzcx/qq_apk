package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.i.b;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a<e>
{
  public static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  
  protected i a(WeakReference<v> paramWeakReference, String paramString, int paramInt)
  {
    AppMethodBeat.i(123556);
    paramWeakReference = new h.6(this, paramWeakReference, paramInt, paramString);
    AppMethodBeat.o(123556);
    return paramWeakReference;
  }
  
  public void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(123555);
    int i = paramJSONObject.optInt("cursor", -2);
    if ((paramJSONObject.has("selectionStart")) || (paramJSONObject.has("selectionEnd"))) {
      i = paramJSONObject.optInt("selectionStart", -2);
    }
    for (int j = paramJSONObject.optInt("selectionEnd", -2);; j = i) {
      try
      {
        int k = paramJSONObject.getInt("inputId");
        if (!aDa()) {
          break;
        }
        al.d(new h.1(this, paramv, k, i, j, paramInt));
        AppMethodBeat.o(123555);
        return;
      }
      catch (JSONException localJSONException)
      {
        e locale = new e();
        if (a(locale, paramJSONObject, paramv, paramInt)) {
          break label137;
        }
        AppMethodBeat.o(123555);
        return;
        if (paramJSONObject.has("inputId")) {
          break label199;
        }
        long l = System.nanoTime();
        locale.jkB = (paramv.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
        com.tencent.mm.plugin.appbrand.s.m.runOnUiThread(new h.2(this, paramv, i, j, paramJSONObject.optString("data"), locale, paramInt));
        AppMethodBeat.o(123555);
      }
    }
    label137:
    label199:
    return;
  }
  
  protected void a(i parami) {}
  
  protected boolean a(e parame, JSONObject paramJSONObject, v paramv, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(123557);
    if (!super.a(parame, paramJSONObject, paramv, paramInt))
    {
      AppMethodBeat.o(123557);
      return false;
    }
    parame.jqB = paramJSONObject.optInt("parentId");
    parame.jkB = paramJSONObject.optInt("inputId");
    parame.jqI = Integer.valueOf(Math.max(0, parame.jqI.intValue()));
    if (parame.jqJ == null) {}
    for (int i = 0;; i = Math.max(0, parame.jqJ.intValue()))
    {
      parame.jqJ = Integer.valueOf(i);
      parame.jqC = paramJSONObject.optString("type", "text");
      if (o.jmj.contains(parame.jqC)) {
        break;
      }
      paramv.h(paramInt, j("fail:unsupported input type", null));
      AppMethodBeat.o(123557);
      return false;
    }
    if (parame.jrf == null) {
      parame.jrf = Boolean.TRUE;
    }
    parame.jqD = paramJSONObject.optBoolean("password");
    parame.jrn = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (aDb())
    {
      paramv = paramJSONObject.optJSONObject("dropdown");
      if (paramv != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.jqn = paramv.optInt("marginLeft");
        paramJSONObject.jqo = paramv.optInt("marginRight");
        paramJSONObject.jqp = paramv.optString("width");
        paramv = paramv.optJSONArray("options");
        if ((paramv != null) && (paramv.length() > 0))
        {
          paramJSONObject.jqq = new ArrayList();
          paramInt = j;
          while (paramInt < paramv.length())
          {
            Object localObject = paramv.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2)))
              {
                a.b localb = new a.b();
                localb.id = str1;
                localb.title = str2;
                localb.content = ((String)localObject);
                paramJSONObject.jqq.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.jqG = paramJSONObject;
        }
      }
    }
    AppMethodBeat.o(123557);
    return true;
  }
  
  protected boolean aDa()
  {
    return true;
  }
  
  protected boolean aDb()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.h
 * JD-Core Version:    0.7.0.1
 */