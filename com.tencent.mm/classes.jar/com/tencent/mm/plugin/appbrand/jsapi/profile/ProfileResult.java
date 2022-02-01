package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "okFlag", "", "getOkFlag$plugin_appbrand_integration_release", "()I", "setOkFlag$plugin_appbrand_integration_release", "(I)V", "resultCode", "getResultCode$plugin_appbrand_integration_release", "setResultCode$plugin_appbrand_integration_release", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ProfileResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  int resultCode;
  int sqJ;
  String username;
  
  static
  {
    AppMethodBeat.i(50653);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50653);
  }
  
  public ProfileResult() {}
  
  public ProfileResult(Parcel paramParcel)
  {
    AppMethodBeat.i(50652);
    readParcel(paramParcel);
    AppMethodBeat.o(50652);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(50650);
    s.u(paramParcel, "parcel");
    this.resultCode = paramParcel.readInt();
    this.sqJ = paramParcel.readInt();
    this.username = paramParcel.readString();
    AppMethodBeat.o(50650);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50651);
    s.u(paramParcel, "dest");
    paramParcel.writeInt(this.resultCode);
    paramParcel.writeInt(this.sqJ);
    paramParcel.writeString(this.username);
    AppMethodBeat.o(50651);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ProfileResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileResult
 * JD-Core Version:    0.7.0.1
 */