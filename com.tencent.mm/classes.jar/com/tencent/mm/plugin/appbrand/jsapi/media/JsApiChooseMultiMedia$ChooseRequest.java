package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseMultiMedia$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR;
  String appId;
  int count;
  String eSM;
  double fOc;
  int gNT;
  boolean hQD;
  boolean hQE;
  boolean hRu;
  boolean hRv;
  int hRw;
  double latitude;
  double longitude;
  
  static
  {
    AppMethodBeat.i(131225);
    CREATOR = new JsApiChooseMultiMedia.ChooseRequest.1();
    AppMethodBeat.o(131225);
  }
  
  JsApiChooseMultiMedia$ChooseRequest() {}
  
  JsApiChooseMultiMedia$ChooseRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(131224);
    j(paramParcel);
    AppMethodBeat.o(131224);
  }
  
  public final boolean aBm()
  {
    return true;
  }
  
  public final String aBn()
  {
    return "GalleryChooseMultiMedia";
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return JsApiChooseMultiMedia.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(131223);
    this.appId = paramParcel.readString();
    this.count = paramParcel.readInt();
    this.longitude = paramParcel.readDouble();
    this.latitude = paramParcel.readDouble();
    this.eSM = paramParcel.readString();
    this.fOc = paramParcel.readDouble();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hQD = bool1;
      if (paramParcel.readByte() == 0) {
        break label138;
      }
      bool1 = true;
      label78:
      this.hQE = bool1;
      this.gNT = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label143;
      }
      bool1 = true;
      label100:
      this.hRu = bool1;
      if (paramParcel.readByte() == 0) {
        break label148;
      }
    }
    label138:
    label143:
    label148:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hRv = bool1;
      this.hRw = paramParcel.readInt();
      AppMethodBeat.o(131223);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label78;
      bool1 = false;
      break label100;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(131222);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.count);
    paramParcel.writeDouble(this.longitude);
    paramParcel.writeDouble(this.latitude);
    paramParcel.writeString(this.eSM);
    paramParcel.writeDouble(this.fOc);
    if (this.hQD)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.hQE) {
        break label140;
      }
      b1 = 1;
      label79:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.gNT);
      if (!this.hRu) {
        break label145;
      }
      b1 = 1;
      label101:
      paramParcel.writeByte(b1);
      if (!this.hRv) {
        break label150;
      }
    }
    label140:
    label145:
    label150:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.hRw);
      AppMethodBeat.o(131222);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label79;
      b1 = 0;
      break label101;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */