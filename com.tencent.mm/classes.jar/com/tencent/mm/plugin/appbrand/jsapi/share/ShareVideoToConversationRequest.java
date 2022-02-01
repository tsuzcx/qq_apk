package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class ShareVideoToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String thumbPath;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(228571);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228571);
  }
  
  public ShareVideoToConversationRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString());
    AppMethodBeat.i(228570);
    AppMethodBeat.o(228570);
  }
  
  public ShareVideoToConversationRequest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228569);
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    AppMethodBeat.o(228569);
  }
  
  public final Class<ad> bCJ()
  {
    return ad.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228568);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    AppMethodBeat.o(228568);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ShareVideoToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareVideoToConversationRequest
 * JD-Core Version:    0.7.0.1
 */