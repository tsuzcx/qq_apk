package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ax
  extends a
{
  public static final int CTRL_INDEX = 642;
  public static final String NAME = "openWCCardHomePage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143253);
    paramJSONObject = paramc.getContext();
    if (!(paramJSONObject instanceof MMActivity))
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenCardHomePage", "mmActivity is null, invoke fail!");
      AppMethodBeat.o(143253);
      return;
    }
    d.b(paramJSONObject, "card", ".ui.v2.CardHomePageNewUI", new Intent());
    AppMethodBeat.o(143253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */