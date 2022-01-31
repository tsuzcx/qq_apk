package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import org.json.JSONException;
import org.json.JSONObject;

public class i
  extends a<h>
{
  private static final int CTRL_INDEX = 112;
  private static final String NAME = "updateInput";
  
  public void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(123562);
    h localh = new h();
    if (!a(localh, paramJSONObject, paramv, paramInt))
    {
      AppMethodBeat.o(123562);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("inputId");
      if ((localh.jqI != null) && (localh.jqI.intValue() < 0)) {
        localh.jqI = Integer.valueOf(0);
      }
      if ((localh.jqJ != null) && (localh.jqJ.intValue() < 0)) {
        localh.jqJ = Integer.valueOf(0);
      }
      paramJSONObject = paramJSONObject.optString("data", null);
      if (paramJSONObject != null) {
        T(i, paramJSONObject);
      }
      com.tencent.mm.plugin.appbrand.s.m.runOnUiThread(new i.1(this, paramv, i, localh, paramInt));
      AppMethodBeat.o(123562);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramv.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(123562);
    }
  }
  
  protected final boolean aCZ()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.i
 * JD-Core Version:    0.7.0.1
 */