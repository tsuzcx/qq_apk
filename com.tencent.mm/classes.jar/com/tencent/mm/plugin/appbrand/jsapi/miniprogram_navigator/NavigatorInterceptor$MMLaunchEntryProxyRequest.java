package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "args", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "(Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)V", "getArgs", "()Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyTask;", "oneShotForeground", "", "writeToParcel", "", "dest", "flags", "", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class NavigatorInterceptor$MMLaunchEntryProxyRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final LaunchParcel siI;
  
  static
  {
    AppMethodBeat.i(326248);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(326248);
  }
  
  public NavigatorInterceptor$MMLaunchEntryProxyRequest(Parcel paramParcel)
  {
    this((LaunchParcel)paramParcel);
    AppMethodBeat.i(326243);
    AppMethodBeat.o(326243);
  }
  
  public NavigatorInterceptor$MMLaunchEntryProxyRequest(LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(326241);
    this.siI = paramLaunchParcel;
    AppMethodBeat.o(326241);
  }
  
  public final Class<NavigatorInterceptor.a> getTaskClass()
  {
    return NavigatorInterceptor.a.class;
  }
  
  public final boolean oneShotForeground()
  {
    return true;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326267);
    s.u(paramParcel, "dest");
    paramParcel.writeParcelable((Parcelable)this.siI, paramInt);
    AppMethodBeat.o(326267);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/NavigatorInterceptor$MMLaunchEntryProxyRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<NavigatorInterceptor.MMLaunchEntryProxyRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.MMLaunchEntryProxyRequest
 * JD-Core Version:    0.7.0.1
 */