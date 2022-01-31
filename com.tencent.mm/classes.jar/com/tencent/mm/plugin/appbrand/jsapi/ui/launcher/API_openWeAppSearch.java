package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import a.f.a.b;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.pointers.PBool;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_AppBrandSearchUIParamsPrepareRequest", "IPC_AppBrandSearchUIParamsPrepareResult", "IPC_AppBrandSearchUIParamsPrepareTask", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch
  extends a<d>
{
  public static final int CTRL_INDEX = 647;
  public static final String NAME = "openWeAppSearch";
  @Deprecated
  public static final API_openWeAppSearch.a ibj;
  
  static
  {
    AppMethodBeat.i(143898);
    ibj = new API_openWeAppSearch.a((byte)0);
    AppMethodBeat.o(143898);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
  public static final class IPC_AppBrandSearchUIParamsPrepareRequest$b
    implements Parcelable.Creator<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest>
  {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"performCallback", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "invoke"})
  static final class b$a
    extends k
    implements b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult, y>
  {
    b$a(PBool paramPBool, c paramc)
    {
      super();
    }
    
    public final void a(API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
    {
      AppMethodBeat.i(143891);
      j.q(paramIPC_AppBrandSearchUIParamsPrepareResult, "result");
      if (this.ibn.value)
      {
        AppMethodBeat.o(143891);
        return;
      }
      this.ibo.ad(paramIPC_AppBrandSearchUIParamsPrepareResult);
      this.ibn.value = true;
      AppMethodBeat.o(143891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch
 * JD-Core Version:    0.7.0.1
 */