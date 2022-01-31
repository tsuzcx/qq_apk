package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseVideo$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR;
  int bpE;
  AppBrandLocalVideoObject hRH;
  
  static
  {
    AppMethodBeat.i(131281);
    CREATOR = new JsApiChooseVideo.ChooseResult.1();
    AppMethodBeat.o(131281);
  }
  
  JsApiChooseVideo$ChooseResult() {}
  
  JsApiChooseVideo$ChooseResult(Parcel paramParcel)
  {
    AppMethodBeat.i(131280);
    j(paramParcel);
    AppMethodBeat.o(131280);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(131278);
    this.bpE = paramParcel.readInt();
    this.hRH = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
    AppMethodBeat.o(131278);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131279);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeParcelable(this.hRH, paramInt);
    AppMethodBeat.o(131279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult
 * JD-Core Version:    0.7.0.1
 */