package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsPostPageRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsPostPageTask;", "CREATOR", "plugin-appbrand-integration_release"})
final class OpenChannelsPostPageRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(274362);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(274362);
  }
  
  public OpenChannelsPostPageRequest() {}
  
  public OpenChannelsPostPageRequest(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(274360);
    AppMethodBeat.o(274360);
  }
  
  public final Class<j> bOe()
  {
    return j.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsPostPageRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsPostPageRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsPostPageRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<OpenChannelsPostPageRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsPostPageRequest
 * JD-Core Version:    0.7.0.1
 */