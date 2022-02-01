package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "statObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getStatObj", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "copy", "equals", "", "other", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyTask;", "hashCode", "", "oneShotForeground", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class MiniProgramNavigatorUglyLogic$ProxyRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
  implements Parcelable
{
  public static final a CREATOR;
  final AppBrandInitConfigWC nyg;
  final AppBrandStatObject pdk;
  
  static
  {
    AppMethodBeat.i(242671);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(242671);
  }
  
  public MiniProgramNavigatorUglyLogic$ProxyRequest(Parcel paramParcel)
  {
    this((AppBrandInitConfigWC)localObject, (AppBrandStatObject)paramParcel);
    AppMethodBeat.i(242670);
    AppMethodBeat.o(242670);
  }
  
  public MiniProgramNavigatorUglyLogic$ProxyRequest(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(242668);
    this.nyg = paramAppBrandInitConfigWC;
    this.pdk = paramAppBrandStatObject;
    AppMethodBeat.o(242668);
  }
  
  public final Class<MiniProgramNavigatorUglyLogic.a> bOe()
  {
    return MiniProgramNavigatorUglyLogic.a.class;
  }
  
  public final boolean bPn()
  {
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242677);
    if (this != paramObject)
    {
      if ((paramObject instanceof ProxyRequest))
      {
        paramObject = (ProxyRequest)paramObject;
        if ((!p.h(this.nyg, paramObject.nyg)) || (!p.h(this.pdk, paramObject.pdk))) {}
      }
    }
    else
    {
      AppMethodBeat.o(242677);
      return true;
    }
    AppMethodBeat.o(242677);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(242675);
    Object localObject = this.nyg;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.pdk;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(242675);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(242672);
    String str = "ProxyRequest(initConfig=" + this.nyg + ", statObj=" + this.pdk + ")";
    AppMethodBeat.o(242672);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(242666);
    p.k(paramParcel, "dest");
    paramParcel.writeParcelable((Parcelable)this.nyg, paramInt);
    paramParcel.writeParcelable((Parcelable)this.pdk, paramInt);
    AppMethodBeat.o(242666);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MiniProgramNavigatorUglyLogic.ProxyRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.MiniProgramNavigatorUglyLogic.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */