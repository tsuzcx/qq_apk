package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "openChannelsParams", "", "(Ljava/lang/String;)V", "getOpenChannelsParams", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class OpenChannelsRewardedVideoAdRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String oOe;
  
  static
  {
    AppMethodBeat.i(279207);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(279207);
  }
  
  public OpenChannelsRewardedVideoAdRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(279206);
    AppMethodBeat.o(279206);
  }
  
  public OpenChannelsRewardedVideoAdRequest(String paramString)
  {
    AppMethodBeat.i(279205);
    this.oOe = paramString;
    AppMethodBeat.o(279205);
  }
  
  public final Class<k> bOe()
  {
    return k.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(279204);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.oOe);
    AppMethodBeat.o(279204);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<OpenChannelsRewardedVideoAdRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsRewardedVideoAdRequest
 * JD-Core Version:    0.7.0.1
 */