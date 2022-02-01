package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "filePath", "", "fileExt", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "getFileName", "getFilePath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class ShareFileToConversationRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String fileName;
  final String filePath;
  final String jmx;
  
  static
  {
    AppMethodBeat.i(259356);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(259356);
  }
  
  public ShareFileToConversationRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(259353);
    AppMethodBeat.o(259353);
  }
  
  public ShareFileToConversationRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(259349);
    this.filePath = paramString1;
    this.jmx = paramString2;
    this.fileName = paramString3;
    AppMethodBeat.o(259349);
  }
  
  public final Class<w> bOe()
  {
    return w.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(259345);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.jmx);
    paramParcel.writeString(this.fileName);
    AppMethodBeat.o(259345);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<ShareFileToConversationRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ShareFileToConversationRequest
 * JD-Core Version:    0.7.0.1
 */