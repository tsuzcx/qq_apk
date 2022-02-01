package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ShareVideoToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String thumbPath;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(326431);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(326431);
  }
  
  public ShareVideoToConversationRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString());
    AppMethodBeat.i(326426);
    AppMethodBeat.o(326426);
  }
  
  public ShareVideoToConversationRequest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(326419);
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    AppMethodBeat.o(326419);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<ac> getTaskClass()
  {
    return ac.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326443);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    AppMethodBeat.o(326443);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ShareVideoToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareVideoToConversationRequest
 * JD-Core Version:    0.7.0.1
 */