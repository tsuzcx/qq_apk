package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extInfoWrapper", "", "(Ljava/lang/String;)V", "getExtInfoWrapper", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class EnterFinderRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String lRv;
  
  static
  {
    AppMethodBeat.i(228375);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228375);
  }
  
  public EnterFinderRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(228374);
    AppMethodBeat.o(228374);
  }
  
  public EnterFinderRequest(String paramString)
  {
    AppMethodBeat.i(228373);
    this.lRv = paramString;
    AppMethodBeat.o(228373);
  }
  
  public final Class<a> bCJ()
  {
    return a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228372);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.lRv);
    AppMethodBeat.o(228372);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<EnterFinderRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.EnterFinderRequest
 * JD-Core Version:    0.7.0.1
 */