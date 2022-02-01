package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "setTextStatusParams", "Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;)V", "getSetTextStatusParams", "()Lcom/tencent/mm/plugin/appbrand/jsapi/SetTextStatusParams;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class DoSetTextStatusRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final SetTextStatusParams osS;
  
  static
  {
    AppMethodBeat.i(274825);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(274825);
  }
  
  public DoSetTextStatusRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(274824);
    AppMethodBeat.o(274824);
  }
  
  public DoSetTextStatusRequest(SetTextStatusParams paramSetTextStatusParams)
  {
    AppMethodBeat.i(274823);
    this.osS = paramSetTextStatusParams;
    AppMethodBeat.o(274823);
  }
  
  public final Class<ad> bOe()
  {
    return ad.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(274822);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.osS, paramInt);
    AppMethodBeat.o(274822);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/DoSetTextStatusRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<DoSetTextStatusRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.DoSetTextStatusRequest
 * JD-Core Version:    0.7.0.1
 */