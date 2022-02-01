package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "result", "", "errCode", "", "errMsg", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getResult", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCgiPrefetchedResp
  implements Parcelable
{
  public static final a CREATOR;
  public final int errCode;
  private final String errMsg;
  public final String result;
  
  static
  {
    AppMethodBeat.i(320844);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(320844);
  }
  
  public AppBrandCgiPrefetchedResp(Parcel paramParcel)
  {
    this(str, i, paramParcel);
    AppMethodBeat.i(320839);
    AppMethodBeat.o(320839);
  }
  
  public AppBrandCgiPrefetchedResp(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(320833);
    this.result = paramString1;
    this.errCode = paramInt;
    this.errMsg = paramString2;
    AppMethodBeat.o(320833);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(320861);
    String str = "AppBrandCgiPrefetchedResp(result='" + this.result + "', errCode=" + this.errCode + ", errMsg='" + this.errMsg + "')";
    AppMethodBeat.o(320861);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320848);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.result);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(320848);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AppBrandCgiPrefetchedResp>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchedResp
 * JD-Core Version:    0.7.0.1
 */