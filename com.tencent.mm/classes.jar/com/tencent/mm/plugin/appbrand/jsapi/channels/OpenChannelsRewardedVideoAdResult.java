package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.protocal.protobuf.bzh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "openResult", "Lcom/tencent/mm/protocal/protobuf/FinderWxaAdResult;", "(ILcom/tencent/mm/protocal/protobuf/FinderWxaAdResult;)V", "getErrCode", "()I", "getOpenResult", "()Lcom/tencent/mm/protocal/protobuf/FinderWxaAdResult;", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class OpenChannelsRewardedVideoAdResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int errCode;
  final bzh rRS;
  
  static
  {
    AppMethodBeat.i(327921);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(327921);
  }
  
  public OpenChannelsRewardedVideoAdResult(int paramInt, bzh parambzh)
  {
    this.errCode = paramInt;
    this.rRS = parambzh;
  }
  
  public OpenChannelsRewardedVideoAdResult(Parcel paramParcel) {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(327928);
    s.u(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    Object localObject = this.rRS;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bzh)localObject).toByteArray())
    {
      paramParcel.writeByteArray((byte[])localObject);
      AppMethodBeat.o(327928);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/OpenChannelsRewardedVideoAdResult;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<OpenChannelsRewardedVideoAdResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.OpenChannelsRewardedVideoAdResult
 * JD-Core Version:    0.7.0.1
 */