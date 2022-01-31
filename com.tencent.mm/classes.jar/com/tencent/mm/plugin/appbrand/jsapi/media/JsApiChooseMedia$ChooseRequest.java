package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseMedia$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR;
  String appId;
  int count;
  boolean hQF;
  boolean hQG;
  boolean hQV;
  boolean hQW;
  boolean hQX;
  boolean hQY;
  boolean isFront;
  int maxDuration;
  
  static
  {
    AppMethodBeat.i(131162);
    CREATOR = new JsApiChooseMedia.ChooseRequest.1();
    AppMethodBeat.o(131162);
  }
  
  JsApiChooseMedia$ChooseRequest() {}
  
  JsApiChooseMedia$ChooseRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(131161);
    j(paramParcel);
    AppMethodBeat.o(131161);
  }
  
  public final boolean aBm()
  {
    return true;
  }
  
  public final String aBn()
  {
    return "GalleryChooseMedia";
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return JsApiChooseMedia.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(131159);
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hQV = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
      bool1 = true;
      label38:
      this.hQW = bool1;
      if (paramParcel.readByte() == 0) {
        break label145;
      }
      bool1 = true;
      label52:
      this.hQX = bool1;
      if (paramParcel.readByte() == 0) {
        break label150;
      }
      bool1 = true;
      label66:
      this.hQY = bool1;
      if (paramParcel.readByte() == 0) {
        break label155;
      }
      bool1 = true;
      label80:
      this.isFront = bool1;
      this.maxDuration = paramParcel.readInt();
      this.count = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label160;
      }
      bool1 = true;
      label110:
      this.hQF = bool1;
      if (paramParcel.readByte() == 0) {
        break label165;
      }
    }
    label140:
    label145:
    label150:
    label155:
    label160:
    label165:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hQG = bool1;
      AppMethodBeat.o(131159);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label38;
      bool1 = false;
      break label52;
      bool1 = false;
      break label66;
      bool1 = false;
      break label80;
      bool1 = false;
      break label110;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(131160);
    paramParcel.writeString(this.appId);
    if (this.hQV)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.hQW) {
        break label142;
      }
      b1 = 1;
      label39:
      paramParcel.writeByte(b1);
      if (!this.hQX) {
        break label147;
      }
      b1 = 1;
      label53:
      paramParcel.writeByte(b1);
      if (!this.hQY) {
        break label152;
      }
      b1 = 1;
      label67:
      paramParcel.writeByte(b1);
      if (!this.isFront) {
        break label157;
      }
      b1 = 1;
      label81:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.maxDuration);
      paramParcel.writeInt(this.count);
      if (!this.hQF) {
        break label162;
      }
      b1 = 1;
      label111:
      paramParcel.writeByte(b1);
      if (!this.hQG) {
        break label167;
      }
    }
    label142:
    label147:
    label152:
    label157:
    label162:
    label167:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(131160);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label39;
      b1 = 0;
      break label53;
      b1 = 0;
      break label67;
      b1 = 0;
      break label81;
      b1 = 0;
      break label111;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */