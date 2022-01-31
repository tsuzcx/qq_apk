package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scene", "", "getScene$plugin_appbrand_integration_release", "()I", "setScene$plugin_appbrand_integration_release", "(I)V", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class ProfileRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final ProfileRequest.a CREATOR;
  int scene;
  String username;
  
  static
  {
    AppMethodBeat.i(134700);
    CREATOR = new ProfileRequest.a((byte)0);
    AppMethodBeat.o(134700);
  }
  
  public ProfileRequest()
  {
    this.scene = 122;
  }
  
  public ProfileRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(134699);
    this.scene = 122;
    j(paramParcel);
    AppMethodBeat.o(134699);
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return d.class;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(134697);
    j.q(paramParcel, "parcel");
    this.username = paramParcel.readString();
    this.scene = paramParcel.readInt();
    AppMethodBeat.o(134697);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(134698);
    j.q(paramParcel, "dest");
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(134698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileRequest
 * JD-Core Version:    0.7.0.1
 */