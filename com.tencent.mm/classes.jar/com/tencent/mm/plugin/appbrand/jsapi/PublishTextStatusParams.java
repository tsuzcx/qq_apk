package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusParams;", "Landroid/os/Parcelable;", "appId", "", "token", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getToken", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class PublishTextStatusParams
  implements Parcelable
{
  public static final Parcelable.Creator<PublishTextStatusParams> CREATOR;
  final String appId;
  final String token;
  
  static
  {
    AppMethodBeat.i(325440);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(325440);
  }
  
  private PublishTextStatusParams(byte paramByte)
  {
    this();
  }
  
  public PublishTextStatusParams(String paramString1, String paramString2)
  {
    AppMethodBeat.i(325428);
    this.appId = paramString1;
    this.token = paramString2;
    AppMethodBeat.o(325428);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(325442);
    String str = "PublishTextStatusParams(appId='" + this.appId + "', token='" + this.token + "')";
    AppMethodBeat.o(325442);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325450);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.token);
    AppMethodBeat.o(325450);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<PublishTextStatusParams>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.PublishTextStatusParams
 * JD-Core Version:    0.7.0.1
 */