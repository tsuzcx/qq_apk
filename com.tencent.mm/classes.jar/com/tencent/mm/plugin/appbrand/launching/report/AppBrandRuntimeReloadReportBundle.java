package com.tencent.mm.plugin.appbrand.launching.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReportBundle;", "Landroid/os/Parcelable;", "refererInstanceId", "", "reloadReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefererInstanceId", "()Ljava/lang/String;", "setRefererInstanceId", "(Ljava/lang/String;)V", "getReloadReason", "setReloadReason", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeReloadReportBundle
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public String mZr;
  public String mZs;
  
  static
  {
    AppMethodBeat.i(228761);
    CREATOR = new a();
    AppMethodBeat.o(228761);
  }
  
  public AppBrandRuntimeReloadReportBundle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228756);
    this.mZr = paramString1;
    this.mZs = paramString2;
    AppMethodBeat.o(228756);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(228759);
    if (this != paramObject)
    {
      if ((paramObject instanceof AppBrandRuntimeReloadReportBundle))
      {
        paramObject = (AppBrandRuntimeReloadReportBundle)paramObject;
        if ((!p.j(this.mZr, paramObject.mZr)) || (!p.j(this.mZs, paramObject.mZs))) {}
      }
    }
    else
    {
      AppMethodBeat.o(228759);
      return true;
    }
    AppMethodBeat.o(228759);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(228758);
    String str = this.mZr;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.mZs;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(228758);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(228757);
    String str = "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.mZr + ", reloadReason=" + this.mZs + ")";
    AppMethodBeat.o(228757);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228760);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.mZr);
    paramParcel.writeString(this.mZs);
    AppMethodBeat.o(228760);
  }
  
  @l(hxD={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(228755);
      p.h(paramParcel, "in");
      paramParcel = new AppBrandRuntimeReloadReportBundle(paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(228755);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandRuntimeReloadReportBundle[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle
 * JD-Core Version:    0.7.0.1
 */