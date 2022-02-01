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
    AppMethodBeat.i(264796);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(264796);
  }
  
  protected JsApiAddToFavorites$IPCFavResult() {}
  
  protected JsApiAddToFavorites$IPCFavResult(Parcel paramParcel)
  {
    AppMethodBeat.i(264793);
    k(paramParcel);
    AppMethodBeat.o(264793);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void k(Parcel paramParcel)
  {
    AppMethodBeat.i(264794);
    this.ret = paramParcel.readInt();
    AppMethodBeat.o(264794);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(264795);
    paramParcel.writeInt(this.ret);
    AppMethodBeat.o(264795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavResult
 * JD-Core Version:    0.7.0.1
 */