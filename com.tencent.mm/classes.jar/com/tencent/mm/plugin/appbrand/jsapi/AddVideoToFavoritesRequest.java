package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoPath", "", "thumbPath", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbPath", "()Ljava/lang/String;", "getVideoPath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class AddVideoToFavoritesRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String thumbPath;
  final String videoPath;
  
  static
  {
    AppMethodBeat.i(228256);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228256);
  }
  
  public AddVideoToFavoritesRequest(Parcel paramParcel)
  {
    this(str1, paramParcel.readString());
    AppMethodBeat.i(228255);
    AppMethodBeat.o(228255);
  }
  
  public AddVideoToFavoritesRequest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228254);
    this.videoPath = paramString1;
    this.thumbPath = paramString2;
    AppMethodBeat.o(228254);
  }
  
  public final Class<c> bCJ()
  {
    return c.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228253);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.videoPath);
    paramParcel.writeString(this.thumbPath);
    AppMethodBeat.o(228253);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/AddVideoToFavoritesRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AddVideoToFavoritesRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.AddVideoToFavoritesRequest
 * JD-Core Version:    0.7.0.1
 */