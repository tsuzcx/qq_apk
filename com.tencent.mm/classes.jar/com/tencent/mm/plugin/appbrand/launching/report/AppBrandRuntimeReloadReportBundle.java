package com.tencent.mm.plugin.appbrand.launching.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/report/AppBrandRuntimeReloadReportBundle;", "Landroid/os/Parcelable;", "refererInstanceId", "", "reloadReason", "(Ljava/lang/String;Ljava/lang/String;)V", "getRefererInstanceId", "()Ljava/lang/String;", "setRefererInstanceId", "(Ljava/lang/String;)V", "getReloadReason", "setReloadReason", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandRuntimeReloadReportBundle
  implements Parcelable
{
  public static final Parcelable.Creator<AppBrandRuntimeReloadReportBundle> CREATOR;
  public String teY;
  public String teZ;
  
  static
  {
    AppMethodBeat.i(321202);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(321202);
  }
  
  public AppBrandRuntimeReloadReportBundle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321192);
    this.teY = paramString1;
    this.teZ = paramString2;
    AppMethodBeat.o(321192);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(321221);
    if (this == paramObject)
    {
      AppMethodBeat.o(321221);
      return true;
    }
    if (!(paramObject instanceof AppBrandRuntimeReloadReportBundle))
    {
      AppMethodBeat.o(321221);
      return false;
    }
    paramObject = (AppBrandRuntimeReloadReportBundle)paramObject;
    if (!s.p(this.teY, paramObject.teY))
    {
      AppMethodBeat.o(321221);
      return false;
    }
    if (!s.p(this.teZ, paramObject.teZ))
    {
      AppMethodBeat.o(321221);
      return false;
    }
    AppMethodBeat.o(321221);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(321216);
    int j = this.teY.hashCode();
    if (this.teZ == null) {}
    for (int i = 0;; i = this.teZ.hashCode())
    {
      AppMethodBeat.o(321216);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(321210);
    String str = "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.teY + ", reloadReason=" + this.teZ + ')';
    AppMethodBeat.o(321210);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(321229);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.teY);
    paramParcel.writeString(this.teZ);
    AppMethodBeat.o(321229);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandRuntimeReloadReportBundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle
 * JD-Core Version:    0.7.0.1
 */