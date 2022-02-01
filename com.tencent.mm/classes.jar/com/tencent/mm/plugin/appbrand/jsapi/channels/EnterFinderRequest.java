package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extInfoWrapper", "", "(Ljava/lang/String;)V", "getExtInfoWrapper", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class EnterFinderRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String oNQ;
  
  static
  {
    AppMethodBeat.i(269541);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(269541);
  }
  
  public EnterFinderRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(269540);
    AppMethodBeat.o(269540);
  }
  
  public EnterFinderRequest(String paramString)
  {
    AppMethodBeat.i(269539);
    this.oNQ = paramString;
    AppMethodBeat.o(269539);
  }
  
  public final Class<a> bOe()
  {
    return a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(269538);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.oNQ);
    AppMethodBeat.o(269538);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<EnterFinderRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.EnterFinderRequest
 * JD-Core Version:    0.7.0.1
 */