package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseImage$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR;
  String appId;
  int count;
  boolean hQD;
  boolean hQE;
  boolean hQF;
  boolean hQG;
  
  static
  {
    AppMethodBeat.i(131130);
    CREATOR = new JsApiChooseImage.ChooseRequest.1();
    AppMethodBeat.o(131130);
  }
  
  JsApiChooseImage$ChooseRequest() {}
  
  JsApiChooseImage$ChooseRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(131129);
    j(paramParcel);
    AppMethodBeat.o(131129);
  }
  
  public final boolean aBm()
  {
    return true;
  }
  
  public final String aBn()
  {
    return "GalleryChooseImage";
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return JsApiChooseImage.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(131127);
    this.appId = paramParcel.readString();
    this.count = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hQD = bool1;
      if (paramParcel.readByte() == 0) {
        break label90;
      }
      bool1 = true;
      label46:
      this.hQE = bool1;
      if (paramParcel.readByte() == 0) {
        break label95;
      }
      bool1 = true;
      label60:
      this.hQF = bool1;
      if (paramParcel.readByte() == 0) {
        break label100;
      }
    }
    label90:
    label95:
    label100:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hQG = bool1;
      AppMethodBeat.o(131127);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label46;
      bool1 = false;
      break label60;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(131128);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.count);
    if (this.hQD)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.hQE) {
        break label92;
      }
      b1 = 1;
      label47:
      paramParcel.writeByte(b1);
      if (!this.hQF) {
        break label97;
      }
      b1 = 1;
      label61:
      paramParcel.writeByte(b1);
      if (!this.hQG) {
        break label102;
      }
    }
    label92:
    label97:
    label102:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(131128);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label47;
      b1 = 0;
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */