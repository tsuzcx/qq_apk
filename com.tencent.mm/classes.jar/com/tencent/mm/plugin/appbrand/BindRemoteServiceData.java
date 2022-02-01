package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "Landroid/os/Parcelable;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;I)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getLoaderId", "()I", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class BindRemoteServiceData
  implements Parcelable
{
  public static final Parcelable.Creator<BindRemoteServiceData> CREATOR;
  final AppBrandInitConfigWC initConfig;
  final AppBrandStatObject qxv;
  final int qxw;
  
  static
  {
    AppMethodBeat.i(316894);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(316894);
  }
  
  public BindRemoteServiceData(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt)
  {
    AppMethodBeat.i(316888);
    this.initConfig = paramAppBrandInitConfigWC;
    this.qxv = paramAppBrandStatObject;
    this.qxw = paramInt;
    AppMethodBeat.o(316888);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(316908);
    if (this == paramObject)
    {
      AppMethodBeat.o(316908);
      return true;
    }
    if (!(paramObject instanceof BindRemoteServiceData))
    {
      AppMethodBeat.o(316908);
      return false;
    }
    paramObject = (BindRemoteServiceData)paramObject;
    if (!s.p(this.initConfig, paramObject.initConfig))
    {
      AppMethodBeat.o(316908);
      return false;
    }
    if (!s.p(this.qxv, paramObject.qxv))
    {
      AppMethodBeat.o(316908);
      return false;
    }
    if (this.qxw != paramObject.qxw)
    {
      AppMethodBeat.o(316908);
      return false;
    }
    AppMethodBeat.o(316908);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(316903);
    int i = this.initConfig.hashCode();
    int j = this.qxv.hashCode();
    int k = this.qxw;
    AppMethodBeat.o(316903);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(316899);
    String str = "BindRemoteServiceData(initConfig=" + this.initConfig + ", stat=" + this.qxv + ", loaderId=" + this.qxw + ')';
    AppMethodBeat.o(316899);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(316919);
    s.u(paramParcel, "out");
    paramParcel.writeParcelable((Parcelable)this.initConfig, paramInt);
    paramParcel.writeParcelable((Parcelable)this.qxv, paramInt);
    paramParcel.writeInt(this.qxw);
    AppMethodBeat.o(316919);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<BindRemoteServiceData>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.BindRemoteServiceData
 * JD-Core Version:    0.7.0.1
 */