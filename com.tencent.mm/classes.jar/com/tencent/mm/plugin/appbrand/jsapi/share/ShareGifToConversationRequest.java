package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class ShareGifToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String path;
  
  static
  {
    AppMethodBeat.i(277087);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(277087);
  }
  
  public ShareGifToConversationRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(277085);
    AppMethodBeat.o(277085);
  }
  
  public ShareGifToConversationRequest(String paramString)
  {
    AppMethodBeat.i(277084);
    this.path = paramString;
    AppMethodBeat.o(277084);
  }
  
  public final Class<y> bOe()
  {
    return y.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(277083);
    p.k(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.path);
    AppMethodBeat.o(277083);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ShareGifToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareGifToConversationRequest
 * JD-Core Version:    0.7.0.1
 */