package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchScene", "", "getSearchScene", "()I", "setSearchScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest
  implements Parcelable
{
  public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> CREATOR;
  public static final API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest.a ibl;
  int ibk;
  
  static
  {
    AppMethodBeat.i(143885);
    ibl = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest.a((byte)0);
    CREATOR = (Parcelable.Creator)new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest.b();
    AppMethodBeat.o(143885);
  }
  
  public API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest() {}
  
  public API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(143884);
    this.ibk = paramParcel.readInt();
    AppMethodBeat.o(143884);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(143883);
    j.q(paramParcel, "dest");
    paramParcel.writeInt(this.ibk);
    AppMethodBeat.o(143883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest
 * JD-Core Version:    0.7.0.1
 */