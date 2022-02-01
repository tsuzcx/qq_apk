package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiAddToFavorites$IPCFavResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<IPCFavResult> CREATOR;
  int ret;
  
  static
  {
    AppMethodBeat.i(188256);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(188256);
  }
  
  protected JsApiAddToFavorites$IPCFavResult() {}
  
  protected JsApiAddToFavorites$IPCFavResult(Parcel paramParcel)
  {
    AppMethodBeat.i(188253);
    j(paramParcel);
    AppMethodBeat.o(188253);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(188254);
    this.ret = paramParcel.readInt();
    AppMethodBeat.o(188254);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(188255);
    paramParcel.writeInt(this.ret);
    AppMethodBeat.o(188255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavResult
 * JD-Core Version:    0.7.0.1
 */