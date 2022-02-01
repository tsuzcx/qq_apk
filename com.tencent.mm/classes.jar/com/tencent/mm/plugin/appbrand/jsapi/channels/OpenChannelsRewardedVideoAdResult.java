package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.protocal.protobuf.blq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "openResult", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdResult;", "(ILcom/tencent/mm/protocal/protobuf/FinderWxaAdResult;)V", "getErrCode", "()I", "getOpenResult", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdResult;", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class OpenChannelsRewardedVideoAdResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int errCode;
  final blq oOf;
  
  static
  {
    AppMethodBeat.i(278595);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(278595);
  }
  
  public OpenChannelsRewardedVideoAdResult(int paramInt, blq paramblq)
  {
    this.errCode = paramInt;
    this.oOf = paramblq;
  }
  
  public OpenChannelsRewardedVideoAdResult(Parcel paramParcel) {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(278591);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    Object localObject = this.oOf;
    if (localObject != null) {}
    for (localObject = ((blq)localObject).toByteArray();; localObject = null)
    {
      paramParcel.writeByteArray((byte[])localObject);
      AppMethodBeat.o(278591);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<OpenChannelsRewardedVideoAdResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsRewardedVideoAdResult
 * JD-Core Version:    0.7.0.1
 */