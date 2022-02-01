package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 84;
  public static final String NAME = "showDatePickerView";
  
  public final void b(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137580);
    String str = paramJSONObject.optString("mode");
    if ("date".equals(str))
    {
      new b().a(this, paramh, paramJSONObject, paramInt, cui());
      AppMethodBeat.o(137580);
      return;
    }
    if ("time".equals(str))
    {
      new k().a(this, paramh, paramJSONObject, paramInt, cui());
      AppMethodBeat.o(137580);
      return;
    }
    paramh.callback(paramInt, ZP("fail:invalid data"));
    AppMethodBeat.o(137580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.f
 * JD-Core Version:    0.7.0.1
 */