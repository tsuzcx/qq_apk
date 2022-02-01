package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "params", "", "(Ljava/lang/String;)V", "getParams", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ReserveChannelsLiveRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String rRQ;
  
  static
  {
    AppMethodBeat.i(327966);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327966);
  }
  
  public ReserveChannelsLiveRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(327963);
    AppMethodBeat.o(327963);
  }
  
  public ReserveChannelsLiveRequest(String paramString)
  {
    AppMethodBeat.i(327957);
    this.rRQ = paramString;
    AppMethodBeat.o(327957);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<r> getTaskClass()
  {
    return r.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327970);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.rRQ);
    AppMethodBeat.o(327970);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ReserveChannelsLiveRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.ReserveChannelsLiveRequest
 * JD-Core Version:    0.7.0.1
 */