package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactTask;", "CREATOR", "plugin-appbrand-integration_release"})
final class OpenChannelsCreateContactRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(281422);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(281422);
  }
  
  public OpenChannelsCreateContactRequest() {}
  
  public OpenChannelsCreateContactRequest(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(281420);
    AppMethodBeat.o(281420);
  }
  
  public final Class<i> bOe()
  {
    return i.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<OpenChannelsCreateContactRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsCreateContactRequest
 * JD-Core Version:    0.7.0.1
 */