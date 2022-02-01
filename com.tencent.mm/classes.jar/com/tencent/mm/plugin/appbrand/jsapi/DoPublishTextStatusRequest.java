package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "publishTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusParams;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusParams;)V", "getPublishTextStatusParams", "()Lcom/tencent/mm/plugin/appbrand/jsapi/PublishTextStatusParams;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class DoPublishTextStatusRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final PublishTextStatusParams rwP;
  
  static
  {
    AppMethodBeat.i(325697);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(325697);
  }
  
  public DoPublishTextStatusRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(325693);
    AppMethodBeat.o(325693);
  }
  
  public DoPublishTextStatusRequest(PublishTextStatusParams paramPublishTextStatusParams)
  {
    AppMethodBeat.i(325691);
    this.rwP = paramPublishTextStatusParams;
    AppMethodBeat.o(325691);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<ae> getTaskClass()
  {
    return ae.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325702);
    s.u(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.rwP, paramInt);
    AppMethodBeat.o(325702);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/DoPublishTextStatusRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<DoPublishTextStatusRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.DoPublishTextStatusRequest
 * JD-Core Version:    0.7.0.1
 */