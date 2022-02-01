package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(ac paramac, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136292);
    h localh = new h();
    if (!a(localh, paramJSONObject, paramac, paramInt))
    {
      AppMethodBeat.o(136292);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("inputId");
      if ((localh.oxK != null) && (localh.oxK.intValue() < 0)) {
        localh.oxK = Integer.valueOf(0);
      }
      if ((localh.oxL != null) && (localh.oxL.intValue() < 0)) {
        localh.oxL = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        al(i, paramJSONObject);
      }
      m.runOnUiThread(new i.1(this, paramac, i, localh, paramInt));
      AppMethodBeat.o(136292);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramac.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(136292);
    }
  }
  
  protected final boolean bGz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h.i
 * JD-Core Version:    0.7.0.1
 */