package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "filePath", "", "fileExt", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "getFileName", "getFilePath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class AddFileToFavoritesRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String fileName;
  final String filePath;
  final String gCr;
  
  static
  {
    AppMethodBeat.i(228232);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228232);
  }
  
  public AddFileToFavoritesRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString(), paramParcel.readString());
    AppMethodBeat.i(228231);
    AppMethodBeat.o(228231);
  }
  
  public AddFileToFavoritesRequest(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228230);
    this.filePath = paramString1;
    this.gCr = paramString2;
    this.fileName = paramString3;
    AppMethodBeat.o(228230);
  }
  
  public final Class<a> bCJ()
  {
    return a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228229);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.filePath);
    paramParcel.writeString(this.gCr);
    paramParcel.writeString(this.fileName);
    AppMethodBeat.o(228229);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/AddFileToFavoritesRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AddFileToFavoritesRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.AddFileToFavoritesRequest
 * JD-Core Version:    0.7.0.1
 */