package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(aa paramaa, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136292);
    h localh = new h();
    if (!a(localh, paramJSONObject, paramaa, paramInt))
    {
      AppMethodBeat.o(136292);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("inputId");
      if ((localh.niW != null) && (localh.niW.intValue() < 0)) {
        localh.niW = Integer.valueOf(0);
      }
      if ((localh.niX != null) && (localh.niX.intValue() < 0)) {
        localh.niX = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        ai(i, paramJSONObject);
      }
      com.tencent.mm.plugin.appbrand.z.m.runOnUiThread(new i.1(this, paramaa, i, localh, paramInt));
      AppMethodBeat.o(136292);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramaa.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(136292);
    }
  }
  
  protected final boolean bkt()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.i
 * JD-Core Version:    0.7.0.1
 */