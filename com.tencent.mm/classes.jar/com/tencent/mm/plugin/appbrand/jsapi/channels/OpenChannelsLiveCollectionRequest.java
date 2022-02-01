package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "openChannelsParams", "", "(Ljava/lang/String;)V", "getOpenChannelsParams", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class OpenChannelsLiveCollectionRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String rRR;
  
  static
  {
    AppMethodBeat.i(327969);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327969);
  }
  
  public OpenChannelsLiveCollectionRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(327967);
    AppMethodBeat.o(327967);
  }
  
  public OpenChannelsLiveCollectionRequest(String paramString)
  {
    AppMethodBeat.i(327962);
    this.rRR = paramString;
    AppMethodBeat.o(327962);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<n> getTaskClass()
  {
    return n.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327972);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.rRR);
    AppMethodBeat.o(327972);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OpenChannelsLiveCollectionRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsLiveCollectionRequest
 * JD-Core Version:    0.7.0.1
 */