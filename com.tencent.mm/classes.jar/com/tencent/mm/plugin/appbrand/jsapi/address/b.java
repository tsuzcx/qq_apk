package com.tencent.mm.plugin.appbrand.jsapi.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/JsApiShowAddressPickerView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "toJson", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectResponse;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<g>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "showAddressPickerView";
  public static final b.a rCf;
  
  static
  {
    AppMethodBeat.i(326496);
    rCf = new b.a((byte)0);
    AppMethodBeat.o(326496);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<AddressSelectorContract.SelectResponse, ah>
  {
    b(g paramg, int paramInt, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(g paramg, int paramInt, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.b
 * JD-Core Version:    0.7.0.1
 */