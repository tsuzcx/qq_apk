package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "result", "", "(I)V", "getResult", "()I", "describeContents", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class ShareToConversationResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final int result;
  
  static
  {
    AppMethodBeat.i(270254);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(270254);
  }
  
  public ShareToConversationResult(int paramInt)
  {
    this.result = paramInt;
  }
  
  public ShareToConversationResult(Parcel paramParcel)
  {
    this(paramParcel.readInt());
    AppMethodBeat.i(270253);
    AppMethodBeat.o(270253);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(270251);
    p.k(paramParcel, "parcel");
    paramParcel.writeInt(this.result);
    AppMethodBeat.o(270251);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ShareToConversationResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareToConversationResult
 * JD-Core Version:    0.7.0.1
 */