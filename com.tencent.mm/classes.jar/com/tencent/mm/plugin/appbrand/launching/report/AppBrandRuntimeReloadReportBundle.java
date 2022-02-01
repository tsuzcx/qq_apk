package com.tencent.mm.plugin.appbrand.launching.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReportBundle;", "Landroid/os/Parcelable;", "refererInstanceId", "", "reloadReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefererInstanceId", "()Ljava/lang/String;", "setRefererInstanceId", "(Ljava/lang/String;)V", "getReloadReason", "setReloadReason", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeReloadReportBundle
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public String lSf;
  public String lSg;
  
  static
  {
    AppMethodBeat.i(223600);
    CREATOR = new a();
    AppMethodBeat.o(223600);
  }
  
  public AppBrandRuntimeReloadReportBundle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223595);
    this.lSf = paramString1;
    this.lSg = paramString2;
    AppMethodBeat.o(223595);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(223598);
    if (this != paramObject)
    {
      if ((paramObject instanceof AppBrandRuntimeReloadReportBundle))
      {
        paramObject = (AppBrandRuntimeReloadReportBundle)paramObject;
        if ((!p.i(this.lSf, paramObject.lSf)) || (!p.i(this.lSg, paramObject.lSg))) {}
      }
    }
    else
    {
      AppMethodBeat.o(223598);
      return true;
    }
    AppMethodBeat.o(223598);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(223597);
    String str = this.lSf;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.lSg;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(223597);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(223596);
    String str = "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.lSf + ", reloadReason=" + this.lSg + ")";
    AppMethodBeat.o(223596);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223599);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.lSf);
    paramParcel.writeString(this.lSg);
    AppMethodBeat.o(223599);
  }
  
  @l(gjZ={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(223594);
      p.h(paramParcel, "in");
      paramParcel = new AppBrandRuntimeReloadReportBundle(paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(223594);
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