package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsTopicRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "openChannelsParams", "", "(Ljava/lang/String;)V", "getOpenChannelsParams", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsTopicTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class OpenChannelsTopicRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String rRR;
  
  static
  {
    AppMethodBeat.i(327867);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327867);
  }
  
  public OpenChannelsTopicRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(327861);
    AppMethodBeat.o(327861);
  }
  
  public OpenChannelsTopicRequest(String paramString)
  {
    AppMethodBeat.i(327855);
    this.rRR = paramString;
    AppMethodBeat.o(327855);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<q> getTaskClass()
  {
    return q.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327878);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.rRR);
    AppMethodBeat.o(327878);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsTopicRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsTopicRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsTopicRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OpenChannelsTopicRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsTopicRequest
 * JD-Core Version:    0.7.0.1
 */