package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ShareGifToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String path;
  
  static
  {
    AppMethodBeat.i(326459);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(326459);
  }
  
  public ShareGifToConversationRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(326455);
    AppMethodBeat.o(326455);
  }
  
  public ShareGifToConversationRequest(String paramString)
  {
    AppMethodBeat.i(326453);
    this.path = paramString;
    AppMethodBeat.o(326453);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<w> getTaskClass()
  {
    return w.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326462);
    s.u(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.path);
    AppMethodBeat.o(326462);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareGifToConversationRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ShareGifToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareGifToConversationRequest
 * JD-Core Version:    0.7.0.1
 */