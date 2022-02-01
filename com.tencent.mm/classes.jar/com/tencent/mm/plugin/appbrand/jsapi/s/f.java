package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 84;
  public static final String NAME = "showDatePickerView";
  
  public final void b(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137580);
    String str = paramJSONObject.optString("mode");
    if ("date".equals(str))
    {
      new b().a(this, paramg, paramJSONObject, paramInt, bTV());
      AppMethodBeat.o(137580);
      return;
    }
    if ("time".equals(str))
    {
      new k().a(this, paramg, paramJSONObject, paramInt, bTV());
      AppMethodBeat.o(137580);
      return;
    }
    paramg.j(paramInt, h("fail:invalid data", null));
    AppMethodBeat.o(137580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.f
 * JD-Core Version:    0.7.0.1
 */