package com.tencent.mm.plugin.appbrand.jsapi.contact;

import a.l;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/contact/JsApiChooseContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  @Deprecated
  public static final d.a hKo;
  
  static
  {
    AppMethodBeat.i(145985);
    hKo = new d.a((byte)0);
    AppMethodBeat.o(145985);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145984);
    if (paramc == null)
    {
      AppMethodBeat.o(145984);
      return;
    }
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(145984);
      return;
    }
    paramJSONObject = com.tencent.mm.sdk.f.a.hr(paramc.getContext());
    if (paramJSONObject == null)
    {
      ((a.f.a.a)new d.b(paramc, paramInt)).invoke();
      AppMethodBeat.o(145984);
      return;
    }
    paramJSONObject = e.at((Context)paramJSONObject);
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("vnd.android.cursor.dir/phone_v2");
    paramJSONObject.a(localIntent, (e.a)new d.c(this, paramc, paramInt));
    AppMethodBeat.o(145984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.d
 * JD-Core Version:    0.7.0.1
 */