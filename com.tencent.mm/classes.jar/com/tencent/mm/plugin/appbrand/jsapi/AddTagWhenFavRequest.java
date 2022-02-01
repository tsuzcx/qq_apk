package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddTagWhenFavRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddTagWhenFavTask;", "CREATOR", "plugin-appbrand-integration_release"})
final class AddTagWhenFavRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final a CREATOR;
  
  static
  {
    AppMethodBeat.i(267286);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(267286);
  }
  
  public AddTagWhenFavRequest() {}
  
  public AddTagWhenFavRequest(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(267285);
    AppMethodBeat.o(267285);
  }
  
  public final Class<a> bOe()
  {
    return a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddTagWhenFavRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddTagWhenFavRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/AddTagWhenFavRequest;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AddTagWhenFavRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.AddTagWhenFavRequest
 * JD-Core Version:    0.7.0.1
 */