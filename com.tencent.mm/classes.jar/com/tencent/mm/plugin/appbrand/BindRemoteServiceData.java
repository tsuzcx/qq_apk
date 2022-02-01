package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "Landroid/os/Parcelable;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;I)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getLoaderId", "()I", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
final class BindRemoteServiceData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final AppBrandInitConfigWC nyg;
  final AppBrandStatObject nyh;
  final int nyi;
  
  static
  {
    AppMethodBeat.i(243156);
    CREATOR = new a();
    AppMethodBeat.o(243156);
  }
  
  public BindRemoteServiceData(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt)
  {
    AppMethodBeat.i(243147);
    this.nyg = paramAppBrandInitConfigWC;
    this.nyh = paramAppBrandStatObject;
    this.nyi = paramInt;
    AppMethodBeat.o(243147);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(243153);
    if (this != paramObject)
    {
      if ((paramObject instanceof BindRemoteServiceData))
      {
        paramObject = (BindRemoteServiceData)paramObject;
        if ((!p.h(this.nyg, paramObject.nyg)) || (!p.h(this.nyh, paramObject.nyh)) || (this.nyi != paramObject.nyi)) {}
      }
    }
    else
    {
      AppMethodBeat.o(243153);
      return true;
    }
    AppMethodBeat.o(243153);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(243151);
    Object localObject = this.nyg;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.nyh;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      int k = this.nyi;
      AppMethodBeat.o(243151);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243149);
    String str = "BindRemoteServiceData(initConfig=" + this.nyg + ", stat=" + this.nyh + ", loaderId=" + this.nyi + ")";
    AppMethodBeat.o(243149);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(243155);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable(this.nyg, paramInt);
    this.nyh.writeToParcel(paramParcel, 0);
    paramParcel.writeInt(this.nyi);
    AppMethodBeat.o(243155);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(252594);
      p.k(paramParcel, "in");
      paramParcel = new BindRemoteServiceData((AppBrandInitConfigWC)paramParcel.readParcelable(BindRemoteServiceData.class.getClassLoader()), (AppBrandStatObject)AppBrandStatObject.CREATOR.createFromParcel(paramParcel), paramParcel.readInt());
      AppMethodBeat.o(252594);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new BindRemoteServiceData[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.BindRemoteServiceData
 * JD-Core Version:    0.7.0.1
 */