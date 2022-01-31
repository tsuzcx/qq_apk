package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeResult
  implements Parcelable
{
  public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR;
  private String blZ;
  private int cpE;
  private int cpF;
  private String filePath;
  private String hAq;
  private String result;
  
  static
  {
    AppMethodBeat.i(130605);
    CREATOR = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.1();
    AppMethodBeat.o(130605);
  }
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeResult() {}
  
  protected JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeResult(Parcel paramParcel)
  {
    AppMethodBeat.i(130603);
    this.result = paramParcel.readString();
    this.filePath = paramParcel.readString();
    this.cpE = paramParcel.readInt();
    this.cpF = paramParcel.readInt();
    this.blZ = paramParcel.readString();
    this.hAq = paramParcel.readString();
    AppMethodBeat.o(130603);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130604);
    paramParcel.writeString(this.result);
    paramParcel.writeString(this.filePath);
    paramParcel.writeInt(this.cpE);
    paramParcel.writeInt(this.cpF);
    paramParcel.writeString(this.blZ);
    paramParcel.writeString(this.hAq);
    AppMethodBeat.o(130604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult
 * JD-Core Version:    0.7.0.1
 */