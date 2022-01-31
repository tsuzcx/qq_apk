package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "okFlag", "", "getOkFlag$plugin_appbrand_integration_release", "()I", "setOkFlag$plugin_appbrand_integration_release", "(I)V", "resultCode", "getResultCode$plugin_appbrand_integration_release", "setResultCode$plugin_appbrand_integration_release", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class ProfileResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  int bpE;
  int hXn;
  String username;
  
  static
  {
    AppMethodBeat.i(134705);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(134705);
  }
  
  public ProfileResult() {}
  
  public ProfileResult(Parcel paramParcel)
  {
    AppMethodBeat.i(134704);
    j(paramParcel);
    AppMethodBeat.o(134704);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(134702);
    j.q(paramParcel, "parcel");
    this.bpE = paramParcel.readInt();
    this.hXn = paramParcel.readInt();
    this.username = paramParcel.readString();
    AppMethodBeat.o(134702);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134703);
    j.q(paramParcel, "dest");
    paramParcel.writeInt(this.bpE);
    paramParcel.writeInt(this.hXn);
    paramParcel.writeString(this.username);
    AppMethodBeat.o(134703);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ProfileResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileResult
 * JD-Core Version:    0.7.0.1
 */