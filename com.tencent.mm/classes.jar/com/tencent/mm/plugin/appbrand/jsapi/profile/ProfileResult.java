package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "okFlag", "", "getOkFlag$plugin_appbrand_integration_release", "()I", "setOkFlag$plugin_appbrand_integration_release", "(I)V", "resultCode", "getResultCode$plugin_appbrand_integration_release", "setResultCode$plugin_appbrand_integration_release", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class ProfileResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  int mnH;
  int resultCode;
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
    k(paramParcel);
    AppMethodBeat.o(50652);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(50650);
    p.h(paramParcel, "parcel");
    this.resultCode = paramParcel.readInt();
    this.mnH = paramParcel.readInt();
    this.username = paramParcel.readString();
    AppMethodBeat.o(50650);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50651);
    p.h(paramParcel, "dest");
    paramParcel.writeInt(this.resultCode);
    paramParcel.writeInt(this.mnH);
    paramParcel.writeString(this.username);
    AppMethodBeat.o(50651);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ProfileResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileResult
 * JD-Core Version:    0.7.0.1
 */