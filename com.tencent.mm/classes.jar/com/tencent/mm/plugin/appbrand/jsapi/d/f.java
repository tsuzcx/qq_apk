package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends a<e>
{
  public static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  
  protected AppBrandInputInvokeHandler a(WeakReference<q> paramWeakReference, String paramString, int paramInt)
  {
    return new f.5(this, paramWeakReference, paramInt, paramString);
  }
  
  public void a(q paramq, JSONObject paramJSONObject, int paramInt)
  {
    int i = paramJSONObject.optInt("cursor", -2);
    int j;
    if ((paramJSONObject.has("selectionStart")) || (paramJSONObject.has("selectionEnd")))
    {
      i = paramJSONObject.optInt("selectionStart", -2);
      j = paramJSONObject.optInt("selectionEnd", -2);
    }
    try
    {
      for (;;)
      {
        int k = paramJSONObject.getInt("inputId");
        if (!aiU()) {
          break;
        }
        ai.d(new f.1(this, paramq, k, i, j, paramInt));
        return;
        j = i;
      }
    }
    catch (JSONException localJSONException)
    {
      e locale;
      do
      {
        locale = new e();
      } while (!a(locale, paramJSONObject, paramq, paramInt));
      if (!paramJSONObject.has("inputId"))
      {
        long l = System.nanoTime();
        locale.hsX = (paramq.hashCode() + "#" + System.currentTimeMillis() + "#" + l).hashCode();
      }
      com.tencent.mm.plugin.appbrand.u.n.runOnUiThread(new f.2(this, paramq, i, j, paramJSONObject.optString("data"), locale, paramInt));
    }
  }
  
  protected void a(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  protected boolean a(e parame, JSONObject paramJSONObject, q paramq, int paramInt)
  {
    int j = 0;
    if (!super.a(parame, paramJSONObject, paramq, paramInt)) {
      return false;
    }
    parame.hyr = paramJSONObject.optInt("parentId");
    parame.hsX = paramJSONObject.optInt("inputId");
    parame.hyy = Integer.valueOf(Math.max(0, parame.hyy.intValue()));
    if (parame.hyz == null) {}
    for (int i = 0;; i = Math.max(0, parame.hyz.intValue()))
    {
      parame.hyz = Integer.valueOf(i);
      parame.hys = paramJSONObject.optString("type", "text");
      if (com.tencent.mm.plugin.appbrand.widget.input.n.hud.contains(parame.hys)) {
        break;
      }
      paramq.C(paramInt, h("fail:unsupported input type", null));
      return false;
    }
    if (parame.hyV == null) {
      parame.hyV = Boolean.valueOf(true);
    }
    parame.hyt = paramJSONObject.optBoolean("password");
    parame.hzd = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (aiV())
    {
      paramq = paramJSONObject.optJSONObject("dropdown");
      if (paramq != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.hyd = paramq.optInt("marginLeft");
        paramJSONObject.hye = paramq.optInt("marginRight");
        paramJSONObject.hyf = paramq.optString("width");
        paramq = paramq.optJSONArray("options");
        if ((paramq != null) && (paramq.length() > 0))
        {
          paramJSONObject.hyg = new ArrayList();
          paramInt = j;
          while (paramInt < paramq.length())
          {
            Object localObject = paramq.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!bk.bl(str1)) && (!bk.bl(str2)))
              {
                a.b localb = new a.b();
                localb.id = str1;
                localb.title = str2;
                localb.content = ((String)localObject);
                paramJSONObject.hyg.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.hyw = paramJSONObject;
        }
      }
    }
    return true;
  }
  
  protected boolean aiU()
  {
    return true;
  }
  
  protected boolean aiV()
  {
    return true;
  }
  
  protected boolean aiW()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.f
 * JD-Core Version:    0.7.0.1
 */