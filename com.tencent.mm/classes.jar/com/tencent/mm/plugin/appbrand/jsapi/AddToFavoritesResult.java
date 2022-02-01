package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "success", "", "(Z)V", "getSuccess", "()Z", "describeContents", "", "readParcel", "", "in", "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class AddToFavoritesResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final a CREATOR;
  final boolean success;
  
  static
  {
    AppMethodBeat.i(228251);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(228251);
  }
  
  public AddToFavoritesResult(Parcel paramParcel) {}
  
  public AddToFavoritesResult(boolean paramBoolean)
  {
    this.success = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel) {}
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228249);
    p.h(paramParcel, "parcel");
    if (this.success) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(228249);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<AddToFavoritesResult>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.AddToFavoritesResult
 * JD-Core Version:    0.7.0.1
 */