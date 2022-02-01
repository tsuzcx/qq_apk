package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "setTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;)V", "getSetTextStatusParams", "()Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class DoSetTextStatusRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final SetTextStatusParams rwR;
  
  static
  {
    AppMethodBeat.i(325666);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(325666);
  }
  
  public DoSetTextStatusRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(325664);
    AppMethodBeat.o(325664);
  }
  
  public DoSetTextStatusRequest(SetTextStatusParams paramSetTextStatusParams)
  {
    AppMethodBeat.i(325662);
    this.rwR = paramSetTextStatusParams;
    AppMethodBeat.o(325662);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<af> getTaskClass()
  {
    return af.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325671);
    s.u(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.rwR, paramInt);
    AppMethodBeat.o(325671);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<DoSetTextStatusRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.DoSetTextStatusRequest
 * JD-Core Version:    0.7.0.1
 */