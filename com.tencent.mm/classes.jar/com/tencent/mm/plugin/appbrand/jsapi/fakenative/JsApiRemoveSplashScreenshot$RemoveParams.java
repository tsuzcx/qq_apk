package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class JsApiRemoveSplashScreenshot$RemoveParams
  implements Parcelable
{
  public static final Parcelable.Creator<RemoveParams> CREATOR;
  final String appId;
  final int euz;
  
  static
  {
    AppMethodBeat.i(326583);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(326583);
  }
  
  public JsApiRemoveSplashScreenshot$RemoveParams(String paramString, int paramInt)
  {
    AppMethodBeat.i(326578);
    this.appId = paramString;
    this.euz = paramInt;
    AppMethodBeat.o(326578);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(326589);
    if (this == paramObject)
    {
      AppMethodBeat.o(326589);
      return true;
    }
    if (!(paramObject instanceof RemoveParams))
    {
      AppMethodBeat.o(326589);
      return false;
    }
    paramObject = (RemoveParams)paramObject;
    if (!s.p(this.appId, paramObject.appId))
    {
      AppMethodBeat.o(326589);
      return false;
    }
    if (this.euz != paramObject.euz)
    {
      AppMethodBeat.o(326589);
      return false;
    }
    AppMethodBeat.o(326589);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(326588);
    int i = this.appId.hashCode();
    int j = this.euz;
    AppMethodBeat.o(326588);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(326585);
    String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.euz + ')';
    AppMethodBeat.o(326585);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326593);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
    AppMethodBeat.o(326593);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<JsApiRemoveSplashScreenshot.RemoveParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot.RemoveParams
 * JD-Core Version:    0.7.0.1
 */