package com.tencent.mm.plugin.appbrand.headless;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/headless/BindRemoteServiceData;", "Landroid/os/Parcelable;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "requestId", "", "taskOnStartSuccessClassName", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;ILjava/lang/String;)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getRequestId", "()I", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getTaskOnStartSuccessClassName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class BindRemoteServiceData
  implements Parcelable
{
  public static final Parcelable.Creator<BindRemoteServiceData> CREATOR;
  final AppBrandInitConfigWC initConfig;
  final AppBrandStatObject qxv;
  final int requestId;
  final String run;
  
  static
  {
    AppMethodBeat.i(317550);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(317550);
  }
  
  public BindRemoteServiceData(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(317547);
    this.initConfig = paramAppBrandInitConfigWC;
    this.qxv = paramAppBrandStatObject;
    this.requestId = paramInt;
    this.run = paramString;
    AppMethodBeat.o(317547);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(317578);
    if (this == paramObject)
    {
      AppMethodBeat.o(317578);
      return true;
    }
    if (!(paramObject instanceof BindRemoteServiceData))
    {
      AppMethodBeat.o(317578);
      return false;
    }
    paramObject = (BindRemoteServiceData)paramObject;
    if (!s.p(this.initConfig, paramObject.initConfig))
    {
      AppMethodBeat.o(317578);
      return false;
    }
    if (!s.p(this.qxv, paramObject.qxv))
    {
      AppMethodBeat.o(317578);
      return false;
    }
    if (this.requestId != paramObject.requestId)
    {
      AppMethodBeat.o(317578);
      return false;
    }
    if (!s.p(this.run, paramObject.run))
    {
      AppMethodBeat.o(317578);
      return false;
    }
    AppMethodBeat.o(317578);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(317563);
    int j = this.initConfig.hashCode();
    int k = this.qxv.hashCode();
    int m = this.requestId;
    if (this.run == null) {}
    for (int i = 0;; i = this.run.hashCode())
    {
      AppMethodBeat.o(317563);
      return i + ((j * 31 + k) * 31 + m) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(317558);
    String str = "BindRemoteServiceData(initConfig=" + this.initConfig + ", stat=" + this.qxv + ", requestId=" + this.requestId + ", taskOnStartSuccessClassName=" + this.run + ')';
    AppMethodBeat.o(317558);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(317592);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.initConfig, paramInt);
    paramParcel.writeParcelable((Parcelable)this.qxv, paramInt);
    paramParcel.writeInt(this.requestId);
    paramParcel.writeString(this.run);
    AppMethodBeat.o(317592);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<BindRemoteServiceData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.headless.BindRemoteServiceData
 * JD-Core Version:    0.7.0.1
 */