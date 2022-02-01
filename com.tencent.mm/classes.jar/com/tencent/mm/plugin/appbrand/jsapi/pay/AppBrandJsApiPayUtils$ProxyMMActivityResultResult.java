package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class AppBrandJsApiPayUtils$ProxyMMActivityResultResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(175178);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(175178);
  }
  
  public AppBrandJsApiPayUtils$ProxyMMActivityResultResult() {}
  
  public AppBrandJsApiPayUtils$ProxyMMActivityResultResult(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(175177);
    AppMethodBeat.o(175177);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(175176);
    p.h(paramParcel, "parcel");
    AppMethodBeat.o(175176);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AppBrandJsApiPayUtils.ProxyMMActivityResultResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils.ProxyMMActivityResultResult
 * JD-Core Version:    0.7.0.1
 */