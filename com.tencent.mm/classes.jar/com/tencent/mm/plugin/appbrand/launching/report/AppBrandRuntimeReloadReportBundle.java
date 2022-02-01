package com.tencent.mm.plugin.appbrand.launching.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReportBundle;", "Landroid/os/Parcelable;", "refererInstanceId", "", "reloadReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefererInstanceId", "()Ljava/lang/String;", "setRefererInstanceId", "(Ljava/lang/String;)V", "getReloadReason", "setReloadReason", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
public final class AppBrandRuntimeReloadReportBundle
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public String pZP;
  public String pZQ;
  
  static
  {
    AppMethodBeat.i(283270);
    CREATOR = new a();
    AppMethodBeat.o(283270);
  }
  
  public AppBrandRuntimeReloadReportBundle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(283264);
    this.pZP = paramString1;
    this.pZQ = paramString2;
    AppMethodBeat.o(283264);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(283267);
    if (this != paramObject)
    {
      if ((paramObject instanceof AppBrandRuntimeReloadReportBundle))
      {
        paramObject = (AppBrandRuntimeReloadReportBundle)paramObject;
        if ((!p.h(this.pZP, paramObject.pZP)) || (!p.h(this.pZQ, paramObject.pZQ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(283267);
      return true;
    }
    AppMethodBeat.o(283267);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(283266);
    String str = this.pZP;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.pZQ;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(283266);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(283265);
    String str = "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.pZP + ", reloadReason=" + this.pZQ + ")";
    AppMethodBeat.o(283265);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(283268);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.pZP);
    paramParcel.writeString(this.pZQ);
    AppMethodBeat.o(283268);
  }
  
  @l(iBK={1, 1, 16})
  public static final class a
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(269094);
      p.k(paramParcel, "in");
      paramParcel = new AppBrandRuntimeReloadReportBundle(paramParcel.readString(), paramParcel.readString());
      AppMethodBeat.o(269094);
      return paramParcel;
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new AppBrandRuntimeReloadReportBundle[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle
 * JD-Core Version:    0.7.0.1
 */