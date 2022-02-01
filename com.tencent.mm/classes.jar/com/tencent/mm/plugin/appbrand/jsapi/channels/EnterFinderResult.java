package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "(I)V", "getErrCode", "()I", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class EnterFinderResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int errCode;
  
  static
  {
    AppMethodBeat.i(228379);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228379);
  }
  
  public EnterFinderResult(int paramInt)
  {
    this.errCode = paramInt;
  }
  
  public EnterFinderResult(Parcel paramParcel)
  {
    this(paramParcel.readInt());
    AppMethodBeat.i(228378);
    AppMethodBeat.o(228378);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228377);
    p.h(paramParcel, "parcel");
    paramParcel.writeInt(this.errCode);
    AppMethodBeat.o(228377);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<EnterFinderResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.channels.EnterFinderResult
 * JD-Core Version:    0.7.0.1
 */