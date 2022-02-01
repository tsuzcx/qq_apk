package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "statObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getStatObj", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "copy", "equals", "", "other", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyTask;", "hashCode", "", "oneShotForeground", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class MiniProgramNavigatorUglyLogic$ProxyRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
  implements Parcelable
{
  public static final a CREATOR;
  final AppBrandInitConfigWC initConfig;
  final AppBrandStatObject siB;
  
  static
  {
    AppMethodBeat.i(326239);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(326239);
  }
  
  public MiniProgramNavigatorUglyLogic$ProxyRequest(Parcel paramParcel)
  {
    this((AppBrandInitConfigWC)localObject, (AppBrandStatObject)paramParcel);
    AppMethodBeat.i(326234);
    AppMethodBeat.o(326234);
  }
  
  public MiniProgramNavigatorUglyLogic$ProxyRequest(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(326231);
    this.initConfig = paramAppBrandInitConfigWC;
    this.siB = paramAppBrandStatObject;
    AppMethodBeat.o(326231);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(326266);
    if (this == paramObject)
    {
      AppMethodBeat.o(326266);
      return true;
    }
    if (!(paramObject instanceof ProxyRequest))
    {
      AppMethodBeat.o(326266);
      return false;
    }
    paramObject = (ProxyRequest)paramObject;
    if (!s.p(this.initConfig, paramObject.initConfig))
    {
      AppMethodBeat.o(326266);
      return false;
    }
    if (!s.p(this.siB, paramObject.siB))
    {
      AppMethodBeat.o(326266);
      return false;
    }
    AppMethodBeat.o(326266);
    return true;
  }
  
  public final Class<MiniProgramNavigatorUglyLogic.a> getTaskClass()
  {
    return MiniProgramNavigatorUglyLogic.a.class;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(326259);
    int i = this.initConfig.hashCode();
    int j = this.siB.hashCode();
    AppMethodBeat.o(326259);
    return i * 31 + j;
  }
  
  public final boolean oneShotForeground()
  {
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(326254);
    String str = "ProxyRequest(initConfig=" + this.initConfig + ", statObj=" + this.siB + ')';
    AppMethodBeat.o(326254);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326249);
    s.u(paramParcel, "dest");
    paramParcel.writeParcelable((Parcelable)this.initConfig, paramInt);
    paramParcel.writeParcelable((Parcelable)this.siB, paramInt);
    AppMethodBeat.o(326249);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic$ProxyRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MiniProgramNavigatorUglyLogic.ProxyRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.MiniProgramNavigatorUglyLogic.ProxyRequest
 * JD-Core Version:    0.7.0.1
 */