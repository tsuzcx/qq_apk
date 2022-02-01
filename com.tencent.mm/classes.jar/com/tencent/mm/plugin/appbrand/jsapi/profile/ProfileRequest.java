package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scene", "", "getScene$plugin_appbrand_integration_release", "()I", "setScene$plugin_appbrand_integration_release", "(I)V", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ProfileRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  int scene;
  String username;
  
  static
  {
    AppMethodBeat.i(50648);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50648);
  }
  
  public ProfileRequest()
  {
    this.scene = 122;
  }
  
  public ProfileRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(50647);
    this.scene = 122;
    readParcel(paramParcel);
    AppMethodBeat.o(50647);
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
  {
    return d.class;
  }
  
  public final void readParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(50645);
    s.u(paramParcel, "parcel");
    this.username = paramParcel.readString();
    this.scene = paramParcel.readInt();
    AppMethodBeat.o(50645);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50646);
    s.u(paramParcel, "dest");
    paramParcel.writeString(this.username);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(50646);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ProfileRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileRequest
 * JD-Core Version:    0.7.0.1
 */