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
  int bRZ;
  AppBrandLocalVideoObject jXD;
  
  static
  {
    AppMethodBeat.i(46556);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46556);
  }
  
  JsApiChooseVideo$ChooseResult() {}
  
  JsApiChooseVideo$ChooseResult(Parcel paramParcel)
  {
    AppMethodBeat.i(46555);
    j(paramParcel);
    AppMethodBeat.o(46555);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(46553);
    this.bRZ = paramParcel.readInt();
    this.jXD = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
    AppMethodBeat.o(46553);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46554);
    paramParcel.writeInt(this.bRZ);
    paramParcel.writeParcelable(this.jXD, paramInt);
    AppMethodBeat.o(46554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult
 * JD-Core Version:    0.7.0.1
 */