package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class ShareVideoToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String thumbPath;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(280099);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(280099);
  }
  
  public ShareVideoToConversationRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString());
    AppMethodBeat.i(280098);
    AppMethodBeat.o(280098);
  }
  
  public ShareVideoToConversationRequest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(280097);
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    AppMethodBeat.o(280097);
  }
  
  public final Class<ae> bOe()
  {
    return ae.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(280095);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    AppMethodBeat.o(280095);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ShareVideoToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareVideoToConversationRequest
 * JD-Core Version:    0.7.0.1
 */