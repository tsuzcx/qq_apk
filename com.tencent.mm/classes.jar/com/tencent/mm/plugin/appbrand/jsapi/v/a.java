package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/picker/BasePickerJsapi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "()V", "isEnableNewPicker", "", "()Z", "setEnableNewPicker", "(Z)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends c<h>
{
  public static final a spM;
  private boolean spN = true;
  
  static
  {
    AppMethodBeat.i(138163);
    spM = new a((byte)0);
    AppMethodBeat.o(138163);
  }
  
  public void b(h paramh, JSONObject paramJSONObject, int paramInt) {}
  
  public final boolean cui()
  {
    AppMethodBeat.i(138162);
    boolean bool = this.spN;
    AppMethodBeat.o(138162);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/picker/BasePickerJsapi$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a
 * JD-Core Version:    0.7.0.1
 */