package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "imagePath", "", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class AddImageToFavoritesRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  final String imagePath;
  
  static
  {
    AppMethodBeat.i(228241);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228241);
  }
  
  public AddImageToFavoritesRequest(Parcel paramParcel)
  {
    this(paramParcel);
    AppMethodBeat.i(228240);
    AppMethodBeat.o(228240);
  }
  
  public AddImageToFavoritesRequest(String paramString)
  {
    AppMethodBeat.i(228239);
    this.imagePath = paramString;
    AppMethodBeat.o(228239);
  }
  
  public final Class<b> bCJ()
  {
    return b.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228238);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.imagePath);
    AppMethodBeat.o(228238);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/AddImageToFavoritesRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AddImageToFavoritesRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.AddImageToFavoritesRequest
 * JD-Core Version:    0.7.0.1
 */