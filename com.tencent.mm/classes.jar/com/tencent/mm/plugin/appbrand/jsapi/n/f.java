package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 84;
  public static final String NAME = "showDatePickerView";
  
  public final void b(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137580);
    String str = paramJSONObject.optString("mode");
    if ("date".equals(str))
    {
      new b().a(this, parame, paramJSONObject, paramInt, this.kgn);
      AppMethodBeat.o(137580);
      return;
    }
    if ("time".equals(str))
    {
      new k().a(this, parame, paramJSONObject, paramInt, this.kgn);
      AppMethodBeat.o(137580);
      return;
    }
    parame.h(paramInt, e("fail:invalid data", null));
    AppMethodBeat.o(137580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.f
 * JD-Core Version:    0.7.0.1
 */