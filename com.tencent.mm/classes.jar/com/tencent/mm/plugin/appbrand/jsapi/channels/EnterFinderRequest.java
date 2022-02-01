package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extInfoWrapper", "", "(Ljava/lang/String;)V", "getExtInfoWrapper", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class EnterFinderRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String rRG;
  
  static
  {
    AppMethodBeat.i(327856);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327856);
  }
  
  public EnterFinderRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(327850);
    AppMethodBeat.o(327850);
  }
  
  public EnterFinderRequest(String paramString)
  {
    AppMethodBeat.i(327849);
    this.rRG = paramString;
    AppMethodBeat.o(327849);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<a> getTaskClass()
  {
    return a.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327866);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.rRG);
    AppMethodBeat.o(327866);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<EnterFinderRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.EnterFinderRequest
 * JD-Core Version:    0.7.0.1
 */