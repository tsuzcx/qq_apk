package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "success", "", "stateOrErrCode", "", "(ZI)V", "getStateOrErrCode", "()I", "getSuccess", "()Z", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ReserveChannelsLiveResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int rRT;
  final boolean success;
  
  static
  {
    AppMethodBeat.i(327930);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327930);
  }
  
  public ReserveChannelsLiveResult(Parcel paramParcel) {}
  
  public ReserveChannelsLiveResult(boolean paramBoolean, int paramInt)
  {
    this.success = paramBoolean;
    this.rRT = paramInt;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327933);
    s.u(paramParcel, "parcel");
    if (this.success) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.rRT);
      AppMethodBeat.o(327933);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/ReserveChannelsLiveResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ReserveChannelsLiveResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.ReserveChannelsLiveResult
 * JD-Core Version:    0.7.0.1
 */