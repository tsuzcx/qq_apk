package com.tencent.mm.plugin.appbrand.launching.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReportBundle;", "Landroid/os/Parcelable;", "refererInstanceId", "", "reloadReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefererInstanceId", "()Ljava/lang/String;", "setRefererInstanceId", "(Ljava/lang/String;)V", "getReloadReason", "setReloadReason", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeReloadReportBundle
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public String lNE;
  public String lNF;
  
  static
  {
    AppMethodBeat.i(189340);
    CREATOR = new a();
    AppMethodBeat.o(189340);
  }
  
  public AppBrandRuntimeReloadReportBundle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189335);
    this.lNE = paramString1;
    this.lNF = paramString2;
    AppMethodBeat.o(189335);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189338);
    if (this != paramObject)
    {
      if ((paramObject instanceof AppBrandRuntimeReloadReportBundle))
      {
        paramObject = (AppBrandRuntimeReloadReportBundle)paramObject;
        if ((!p.i(this.lNE, paramObject.lNE)) || (!p.i(this.lNF, paramObject.lNF))) {}
      }
    }
    else
    {
      AppMethodBeat.o(189338);
      return true;
    }
    AppMethodBeat.o(189338);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(189337);
    String str = this.lNE;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.lNF;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(189337);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189336);
    String str = "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.lNE + ", reloadReason=" + this.lNF + ")";
    AppMethodBeat.o(189336);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(189339);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.lNE);
    paramParcel.writeString(this.lNF);
    AppMethodBeat.o(189339);
  }
  
  @l(gfx={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(189334);
      p.h(paramParcel, "in");
      paramParcel = new AppBrandRuntimeReloadReportBundle(paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(189334);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandRuntimeReloadReportBundle[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle
 * JD-Core Version:    0.7.0.1
 */