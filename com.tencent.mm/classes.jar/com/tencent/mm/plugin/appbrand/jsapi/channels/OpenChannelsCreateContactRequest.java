package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "params", "", "(Ljava/lang/String;)V", "getParams", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactTask;", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class OpenChannelsCreateContactRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String rRQ;
  
  static
  {
    AppMethodBeat.i(327951);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327951);
  }
  
  public OpenChannelsCreateContactRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(327947);
    AppMethodBeat.o(327947);
  }
  
  public OpenChannelsCreateContactRequest(String paramString)
  {
    AppMethodBeat.i(327940);
    this.rRQ = paramString;
    AppMethodBeat.o(327940);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<m> getTaskClass()
  {
    return m.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327961);
    if (paramParcel != null) {
      paramParcel.writeString(this.rRQ);
    }
    AppMethodBeat.o(327961);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsCreateContactRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OpenChannelsCreateContactRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsCreateContactRequest
 * JD-Core Version:    0.7.0.1
 */