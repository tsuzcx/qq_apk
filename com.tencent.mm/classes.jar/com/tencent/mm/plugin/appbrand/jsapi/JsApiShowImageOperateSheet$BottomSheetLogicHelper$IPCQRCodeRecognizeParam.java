package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeParam
  implements Parcelable
{
  public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR;
  private String hAo;
  private String hAp;
  
  static
  {
    AppMethodBeat.i(130601);
    CREATOR = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.1();
    AppMethodBeat.o(130601);
  }
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeParam() {}
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeParam(Parcel paramParcel)
  {
    AppMethodBeat.i(130599);
    this.hAo = paramParcel.readString();
    this.hAp = paramParcel.readString();
    AppMethodBeat.o(130599);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130600);
    paramParcel.writeString(this.hAo);
    paramParcel.writeString(this.hAp);
    AppMethodBeat.o(130600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam
 * JD-Core Version:    0.7.0.1
 */