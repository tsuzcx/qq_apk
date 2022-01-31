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
  int bpE;
  ArrayList<AppBrandLocalMediaObject> hQH;
  
  static
  {
    AppMethodBeat.i(131134);
    CREATOR = new JsApiChooseImage.ChooseResult.1();
    AppMethodBeat.o(131134);
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
    AppMethodBeat.i(131132);
    this.bpE = paramParcel.readInt();
    this.hQH = paramParcel.createTypedArrayList(AppBrandLocalMediaObject.CREATOR);
    AppMethodBeat.o(131132);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131133);
    paramParcel.writeInt(this.bpE);
    paramParcel.writeTypedList(this.hQH);
    AppMethodBeat.o(131133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult
 * JD-Core Version:    0.7.0.1
 */