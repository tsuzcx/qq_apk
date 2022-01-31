package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMedia$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR;
  int bpE;
  String hQZ;
  String type;
  
  static
  {
    AppMethodBeat.i(131167);
    CREATOR = new JsApiChooseMedia.ChooseResult.1();
    AppMethodBeat.o(131167);
  }
  
  JsApiChooseMedia$ChooseResult() {}
  
  JsApiChooseMedia$ChooseResult(Parcel paramParcel)
  {
    AppMethodBeat.i(131166);
    j(paramParcel);
    AppMethodBeat.o(131166);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(131164);
    this.bpE = paramParcel.readInt();
    this.type = paramParcel.readString();
    this.hQZ = paramParcel.readString();
    AppMethodBeat.o(131164);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131165);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.hQZ);
    AppMethodBeat.o(131165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseResult
 * JD-Core Version:    0.7.0.1
 */