package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMultiMedia$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR;
  int bpE;
  String hRx;
  
  static
  {
    AppMethodBeat.i(131229);
    CREATOR = new JsApiChooseMultiMedia.ChooseResult.1();
    AppMethodBeat.o(131229);
  }
  
  JsApiChooseMultiMedia$ChooseResult() {}
  
  JsApiChooseMultiMedia$ChooseResult(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(131227);
    this.bpE = paramParcel.readInt();
    this.hRx = paramParcel.readString();
    AppMethodBeat.o(131227);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131228);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeString(this.hRx);
    AppMethodBeat.o(131228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.ChooseResult
 * JD-Core Version:    0.7.0.1
 */