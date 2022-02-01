package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

final class JsApiChooseMedia$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR;
  int bRZ;
  String jWY;
  String type;
  
  static
  {
    AppMethodBeat.i(46441);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46441);
  }
  
  JsApiChooseMedia$ChooseResult() {}
  
  JsApiChooseMedia$ChooseResult(Parcel paramParcel)
  {
    AppMethodBeat.i(46440);
    j(paramParcel);
    AppMethodBeat.o(46440);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(46438);
    this.bRZ = paramParcel.readInt();
    this.type = paramParcel.readString();
    this.jWY = paramParcel.readString();
    AppMethodBeat.o(46438);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46439);
    paramParcel.writeInt(this.bRZ);
    paramParcel.writeString(this.type);
    paramParcel.writeString(this.jWY);
    AppMethodBeat.o(46439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseResult
 * JD-Core Version:    0.7.0.1
 */