package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import java.util.ArrayList;

final class JsApiChooseImage$ChooseResult
  extends AppBrandProxyUIProcessTask.ProcessResult
{
  public static final Parcelable.Creator<ChooseResult> CREATOR;
  int bRZ;
  ArrayList<AppBrandLocalMediaObject> jWB;
  
  static
  {
    AppMethodBeat.i(46407);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(46407);
  }
  
  JsApiChooseImage$ChooseResult() {}
  
  JsApiChooseImage$ChooseResult(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    AppMethodBeat.i(46405);
    this.bRZ = paramParcel.readInt();
    this.jWB = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
    AppMethodBeat.o(46405);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46406);
    paramParcel.writeInt(this.bRZ);
    paramParcel.writeTypedList(this.jWB);
    AppMethodBeat.o(46406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult
 * JD-Core Version:    0.7.0.1
 */