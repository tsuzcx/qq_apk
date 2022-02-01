package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMultiMedia$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR;
  int resultCode;
  String sgs;
  
  static
  {
    AppMethodBeat.i(46505);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46505);
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
  
  public final void readParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(46503);
    this.resultCode = paramParcel.readInt();
    this.sgs = paramParcel.readString();
    AppMethodBeat.o(46503);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46504);
    paramParcel.writeInt(this.resultCode);
    paramParcel.writeString(this.sgs);
    AppMethodBeat.o(46504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.ChooseResult
 * JD-Core Version:    0.7.0.1
 */