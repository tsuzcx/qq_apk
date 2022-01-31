package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseMedia$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR = new Parcelable.Creator() {};
  String appId;
  int count;
  boolean gvE;
  boolean gvF;
  boolean gvG;
  boolean gvH;
  boolean gvo;
  boolean gvp;
  boolean isFront;
  int maxDuration;
  
  JsApiChooseMedia$ChooseRequest() {}
  
  JsApiChooseMedia$ChooseRequest(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  protected final boolean ahF()
  {
    return true;
  }
  
  protected final String ahG()
  {
    return "GalleryChooseMedia";
  }
  
  protected final Class<? extends AppBrandProxyUIProcessTask> ahH()
  {
    return JsApiChooseMedia.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.appId = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.gvE = bool1;
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label33:
      this.gvF = bool1;
      if (paramParcel.readByte() == 0) {
        break label135;
      }
      bool1 = true;
      label47:
      this.gvG = bool1;
      if (paramParcel.readByte() == 0) {
        break label140;
      }
      bool1 = true;
      label61:
      this.gvH = bool1;
      if (paramParcel.readByte() == 0) {
        break label145;
      }
      bool1 = true;
      label75:
      this.isFront = bool1;
      this.maxDuration = paramParcel.readInt();
      this.count = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label150;
      }
      bool1 = true;
      label105:
      this.gvo = bool1;
      if (paramParcel.readByte() == 0) {
        break label155;
      }
    }
    label130:
    label135:
    label140:
    label145:
    label150:
    label155:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gvp = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label33;
      bool1 = false;
      break label47;
      bool1 = false;
      break label61;
      bool1 = false;
      break label75;
      bool1 = false;
      break label105;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.appId);
    if (this.gvE)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.gvF) {
        break label132;
      }
      b1 = 1;
      label34:
      paramParcel.writeByte(b1);
      if (!this.gvG) {
        break label137;
      }
      b1 = 1;
      label48:
      paramParcel.writeByte(b1);
      if (!this.gvH) {
        break label142;
      }
      b1 = 1;
      label62:
      paramParcel.writeByte(b1);
      if (!this.isFront) {
        break label147;
      }
      b1 = 1;
      label76:
      paramParcel.writeByte(b1);
      paramParcel.writeInt(this.maxDuration);
      paramParcel.writeInt(this.count);
      if (!this.gvo) {
        break label152;
      }
      b1 = 1;
      label106:
      paramParcel.writeByte(b1);
      if (!this.gvp) {
        break label157;
      }
    }
    label132:
    label137:
    label142:
    label147:
    label152:
    label157:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label34;
      b1 = 0;
      break label48;
      b1 = 0;
      break label62;
      b1 = 0;
      break label76;
      b1 = 0;
      break label106;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */