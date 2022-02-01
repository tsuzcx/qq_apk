package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "(I)V", "getErrCode", "()I", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class OpenChannelsLiveCollectionResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int errCode;
  
  static
  {
    AppMethodBeat.i(327949);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327949);
  }
  
  public OpenChannelsLiveCollectionResult(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public OpenChannelsLiveCollectionResult(Parcel paramParcel)
  {
    this(paramParcel.readInt());
    AppMethodBeat.i(327943);
    AppMethodBeat.o(327943);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327955);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    AppMethodBeat.o(327955);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsLiveCollectionResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OpenChannelsLiveCollectionResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsLiveCollectionResult
 * JD-Core Version:    0.7.0.1
 */