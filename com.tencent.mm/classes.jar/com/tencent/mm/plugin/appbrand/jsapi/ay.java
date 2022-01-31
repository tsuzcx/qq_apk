package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ay
  extends a
{
  public static final int CTRL_INDEX = 643;
  public static final String NAME = "openWCCertHomePage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143254);
    paramJSONObject = paramc.getContext();
    if (!(paramJSONObject instanceof MMActivity))
    {
      paramc.h(paramInt, j("fail", null));
      ab.e("MicroMsg.JsApiOpenCertCardHomePage", "mmActivity is null, invoke fail!");
      AppMethodBeat.o(143254);
      return;
    }
    d.b(paramJSONObject, "card", ".ui.v2.CardTicketListUI", new Intent());
    AppMethodBeat.o(143254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ay
 * JD-Core Version:    0.7.0.1
 */