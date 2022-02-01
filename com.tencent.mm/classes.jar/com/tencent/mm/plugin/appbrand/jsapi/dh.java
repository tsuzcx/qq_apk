package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.o;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsInvokeContext;", "ENV", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "invokeEnv", "data", "Lorg/json/JSONObject;", "privateData", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;Lorg/json/JSONObject;I)V", "getCallbackId", "()I", "getData", "()Lorg/json/JSONObject;", "getInvokeEnv", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "getPrivateData", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;Lorg/json/JSONObject;Lorg/json/JSONObject;I)Lcom/tencent/mm/plugin/appbrand/jsapi/JsInvokeContext;", "equals", "", "other", "hashCode", "toString", "", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dh<ENV extends f>
{
  public final JSONObject qxU;
  public final o rBu;
  public final ENV rBv;
  public final JSONObject rmi;
  public final int ror;
  
  public dh(o paramo, ENV paramENV, JSONObject paramJSONObject1, JSONObject paramJSONObject2, int paramInt)
  {
    AppMethodBeat.i(325483);
    this.rBu = paramo;
    this.rBv = paramENV;
    this.rmi = paramJSONObject1;
    this.qxU = paramJSONObject2;
    this.ror = paramInt;
    AppMethodBeat.o(325483);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(325496);
    if (this == paramObject)
    {
      AppMethodBeat.o(325496);
      return true;
    }
    if (!(paramObject instanceof dh))
    {
      AppMethodBeat.o(325496);
      return false;
    }
    paramObject = (dh)paramObject;
    if (!s.p(this.rBu, paramObject.rBu))
    {
      AppMethodBeat.o(325496);
      return false;
    }
    if (!s.p(this.rBv, paramObject.rBv))
    {
      AppMethodBeat.o(325496);
      return false;
    }
    if (!s.p(this.rmi, paramObject.rmi))
    {
      AppMethodBeat.o(325496);
      return false;
    }
    if (!s.p(this.qxU, paramObject.qxU))
    {
      AppMethodBeat.o(325496);
      return false;
    }
    if (this.ror != paramObject.ror)
    {
      AppMethodBeat.o(325496);
      return false;
    }
    AppMethodBeat.o(325496);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(325493);
    int i;
    int k;
    int m;
    if (this.rBu == null)
    {
      i = 0;
      k = this.rBv.hashCode();
      m = this.rmi.hashCode();
      if (this.qxU != null) {
        break label86;
      }
    }
    for (;;)
    {
      int n = this.ror;
      AppMethodBeat.o(325493);
      return (((i * 31 + k) * 31 + m) * 31 + j) * 31 + n;
      i = this.rBu.hashCode();
      break;
      label86:
      j = this.qxU.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(325490);
    String str = "JsInvokeContext(jsRuntime=" + this.rBu + ", invokeEnv=" + this.rBv + ", data=" + this.rmi + ", privateData=" + this.qxU + ", callbackId=" + this.ror + ')';
    AppMethodBeat.o(325490);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.dh
 * JD-Core Version:    0.7.0.1
 */