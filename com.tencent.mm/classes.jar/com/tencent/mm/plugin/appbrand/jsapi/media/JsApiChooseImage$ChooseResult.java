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
  int resultCode;
  ArrayList<AppBrandLocalMediaObject> resultList;
  
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
  
  public final void readParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(46405);
    this.resultCode = paramParcel.readInt();
    this.resultList = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
    AppMethodBeat.o(46405);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(46406);
    paramParcel.writeInt(this.resultCode);
    paramParcel.writeTypedList(this.resultList);
    AppMethodBeat.o(46406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult
 * JD-Core Version:    0.7.0.1
 */