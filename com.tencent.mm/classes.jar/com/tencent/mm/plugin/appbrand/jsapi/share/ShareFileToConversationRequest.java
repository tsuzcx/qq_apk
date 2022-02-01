package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "filePath", "", "fileExt", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "getFileName", "getFilePath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ShareFileToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String fileName;
  final String filePath;
  final String lPJ;
  
  static
  {
    AppMethodBeat.i(326438);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(326438);
  }
  
  public ShareFileToConversationRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(326436);
    AppMethodBeat.o(326436);
  }
  
  public ShareFileToConversationRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(326432);
    this.filePath = paramString1;
    this.lPJ = paramString2;
    this.fileName = paramString3;
    AppMethodBeat.o(326432);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<u> getTaskClass()
  {
    return u.class;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326446);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.lPJ);
    paramParcel.writeString(this.fileName);
    AppMethodBeat.o(326446);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<ShareFileToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareFileToConversationRequest
 * JD-Core Version:    0.7.0.1
 */