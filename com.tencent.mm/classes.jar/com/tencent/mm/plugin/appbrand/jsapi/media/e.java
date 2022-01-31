package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 532;
  public static final String NAME = "chooseMessageFile";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131216);
    if (paramJSONObject == null)
    {
      d.e("MicroMsg.JsApiChooseMessageFile", "data is null");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131216);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof MMActivity)))
    {
      d.e("MicroMsg.JsApiChooseMessageFile", "context is null");
      paramc.h(paramInt, j("fail:internal error invalid android context", null));
      AppMethodBeat.o(131216);
      return;
    }
    d.i("MicroMsg.JsApiChooseMessageFile", "chooseMsgFile data:%s", new Object[] { paramJSONObject });
    String str1 = paramJSONObject.optString("type", "all");
    String str2 = paramJSONObject.optString("extension", "");
    int i = paramJSONObject.optInt("count", 9);
    ((com.tencent.mm.choosemsgfile.compat.a)g.E(com.tencent.mm.choosemsgfile.compat.a.class)).a((MMActivity)localContext, str1, i, str2, new e.1(this, paramc, paramInt));
    AppMethodBeat.o(131216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.e
 * JD-Core Version:    0.7.0.1
 */