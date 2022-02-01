package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "args", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "(Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)V", "getArgs", "()Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyTask;", "oneShotForeground", "", "writeToParcel", "", "dest", "flags", "", "CREATOR", "plugin-appbrand-integration_release"})
final class NavigatorInterceptor$MMLaunchEntryProxyRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final LaunchParcel pdr;
  
  static
  {
    AppMethodBeat.i(283292);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(283292);
  }
  
  public NavigatorInterceptor$MMLaunchEntryProxyRequest(Parcel paramParcel)
  {
    this((LaunchParcel)paramParcel);
    AppMethodBeat.i(283291);
    AppMethodBeat.o(283291);
  }
  
  public NavigatorInterceptor$MMLaunchEntryProxyRequest(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(283290);
    this.pdr = paramLaunchParcel;
    AppMethodBeat.o(283290);
  }
  
  public final Class<NavigatorInterceptor.a> bOe()
  {
    return NavigatorInterceptor.a.class;
  }
  
  public final boolean bPn()
  {
    return true;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(283289);
    p.k(paramParcel, "dest");
    paramParcel.writeParcelable((Parcelable)this.pdr, paramInt);
    AppMethodBeat.o(283289);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<NavigatorInterceptor.MMLaunchEntryProxyRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.MMLaunchEntryProxyRequest
 * JD-Core Version:    0.7.0.1
 */