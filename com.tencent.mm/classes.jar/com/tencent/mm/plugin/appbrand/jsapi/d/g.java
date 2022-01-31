package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(q paramq, JSONObject paramJSONObject, int paramInt)
  {
    h localh = new h();
    if (!a(localh, paramJSONObject, paramq, paramInt)) {
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("inputId");
      if ((localh.hyy != null) && (localh.hyy.intValue() < 0)) {
        localh.hyy = Integer.valueOf(0);
      }
      if ((localh.hyz != null) && (localh.hyz.intValue() < 0)) {
        localh.hyz = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        I(i, paramJSONObject);
      }
      n.runOnUiThread(new g.1(this, paramq, i, localh, paramInt));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramq.C(paramInt, h("fail:invalid data", null));
    }
  }
  
  protected final boolean aiT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.g
 * JD-Core Version:    0.7.0.1
 */