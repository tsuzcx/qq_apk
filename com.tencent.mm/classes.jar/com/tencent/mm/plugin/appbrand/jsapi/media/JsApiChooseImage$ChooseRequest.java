package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseImage$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR = new JsApiChooseImage.ChooseRequest.1();
  String appId;
  int count;
  boolean gvm;
  boolean gvn;
  boolean gvo;
  boolean gvp;
  
  JsApiChooseImage$ChooseRequest() {}
  
  JsApiChooseImage$ChooseRequest(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  protected final boolean ahF()
  {
    return true;
  }
  
  protected final String ahG()
  {
    return "GalleryChooseImage";
  }
  
  protected final Class<? extends AppBrandProxyUIProcessTask> ahH()
  {
    return JsApiChooseImage.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.appId = paramParcel.readString();
    this.count = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.gvm = bool1;
      if (paramParcel.readByte() == 0) {
        break label80;
      }
      bool1 = true;
      label41:
      this.gvn = bool1;
      if (paramParcel.readByte() == 0) {
        break label85;
      }
      bool1 = true;
      label55:
      this.gvo = bool1;
      if (paramParcel.readByte() == 0) {
        break label90;
      }
    }
    label80:
    label85:
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gvp = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label41;
      bool1 = false;
      break label55;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.count);
    if (this.gvm)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.gvn) {
        break label82;
      }
      b1 = 1;
      label42:
      paramParcel.writeByte(b1);
      if (!this.gvo) {
        break label87;
      }
      b1 = 1;
      label56:
      paramParcel.writeByte(b1);
      if (!this.gvp) {
        break label92;
      }
    }
    label82:
    label87:
    label92:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label42;
      b1 = 0;
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */