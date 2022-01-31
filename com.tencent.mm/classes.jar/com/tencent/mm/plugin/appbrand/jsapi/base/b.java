package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends e>
  extends d<c>
{
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (ai.isMainThread())
    {
      b(paramc, paramJSONObject, paramInt);
      return;
    }
    ai.d(new b.1(this, paramc, paramJSONObject, paramInt));
  }
  
  final void b(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    e locale = ((f)paramc.i(f.class)).a(paramc);
    if (locale == null)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { getName() });
      paramc.C(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    for (;;)
    {
      try
      {
        int i = p(paramJSONObject);
        View localView = locale.agW().mg(i);
        if (!locale.agW().mf(i)) {
          break label246;
        }
        boolean bool2 = locale.agW().mc(i);
        bool1 = bool2;
        if (bool2) {
          bool1 = b(locale, i, localView, paramJSONObject);
        }
        if (bool1) {
          locale.agW().mh(i);
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(paramJSONObject.optInt("parentId", 0)), Integer.valueOf(i), Boolean.valueOf(bool1) });
        if (bool1)
        {
          paramJSONObject = "ok";
          paramc.C(paramInt, h(paramJSONObject, null));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramJSONObject });
        paramc.C(paramInt, h("fail:view id do not exist", null));
        return;
      }
      paramJSONObject = "fail";
      continue;
      label246:
      boolean bool1 = false;
    }
  }
  
  public boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.b
 * JD-Core Version:    0.7.0.1
 */