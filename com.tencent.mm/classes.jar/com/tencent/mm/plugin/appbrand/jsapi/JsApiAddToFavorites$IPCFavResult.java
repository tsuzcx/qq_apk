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
    AppMethodBeat.i(325606);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(325606);
  }
  
  protected JsApiAddToFavorites$IPCFavResult() {}
  
  protected JsApiAddToFavorites$IPCFavResult(Parcel paramParcel)
  {
    AppMethodBeat.i(325601);
    readParcel(paramParcel);
    AppMethodBeat.o(325601);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(325612);
    this.ret = paramParcel.readInt();
    AppMethodBeat.o(325612);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325620);
    paramParcel.writeInt(this.ret);
    AppMethodBeat.o(325620);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavResult
 * JD-Core Version:    0.7.0.1
 */