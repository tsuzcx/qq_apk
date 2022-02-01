package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "Landroid/os/Parcelable;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;I)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getLoaderId", "()I", "getStat", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
final class BindRemoteServiceData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  final AppBrandInitConfigWC kEG;
  final AppBrandStatObject kEH;
  final int kEI;
  
  static
  {
    AppMethodBeat.i(227902);
    CREATOR = new a();
    AppMethodBeat.o(227902);
  }
  
  public BindRemoteServiceData(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt)
  {
    AppMethodBeat.i(227897);
    this.kEG = paramAppBrandInitConfigWC;
    this.kEH = paramAppBrandStatObject;
    this.kEI = paramInt;
    AppMethodBeat.o(227897);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(227900);
    if (this != paramObject)
    {
      if ((paramObject instanceof BindRemoteServiceData))
      {
        paramObject = (BindRemoteServiceData)paramObject;
        if ((!p.j(this.kEG, paramObject.kEG)) || (!p.j(this.kEH, paramObject.kEH)) || (this.kEI != paramObject.kEI)) {}
      }
    }
    else
    {
      AppMethodBeat.o(227900);
      return true;
    }
    AppMethodBeat.o(227900);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(227899);
    Object localObject = this.kEG;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.kEH;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      int k = this.kEI;
      AppMethodBeat.o(227899);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(227898);
    String str = "BindRemoteServiceData(initConfig=" + this.kEG + ", stat=" + this.kEH + ", loaderId=" + this.kEI + ")";
    AppMethodBeat.o(227898);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(227901);
    p.h(paramParcel, "parcel");
    paramParcel.writeParcelable(this.kEG, paramInt);
    this.kEH.writeToParcel(paramParcel, 0);
    paramParcel.writeInt(this.kEI);
    AppMethodBeat.o(227901);
  }
  
  @l(hxD={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(227896);
      p.h(paramParcel, "in");
      paramParcel = new BindRemoteServiceData((AppBrandInitConfigWC)paramParcel.readParcelable(BindRemoteServiceData.class.getClassLoader()), (AppBrandStatObject)AppBrandStatObject.CREATOR.createFromParcel(paramParcel), paramParcel.readInt());
      AppMethodBeat.o(227896);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new BindRemoteServiceData[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.BindRemoteServiceData
 * JD-Core Version:    0.7.0.1
 */