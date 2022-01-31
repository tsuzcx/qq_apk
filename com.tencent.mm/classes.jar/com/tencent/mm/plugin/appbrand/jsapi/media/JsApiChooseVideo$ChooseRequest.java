package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseVideo$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR = new JsApiChooseVideo.ChooseRequest.1();
  String appId;
  boolean gvV;
  boolean gvm;
  boolean gvn;
  int maxDuration;
  
  JsApiChooseVideo$ChooseRequest() {}
  
  JsApiChooseVideo$ChooseRequest(Parcel paramParcel)
  {
    h(paramParcel);
  }
  
  protected final boolean ahF()
  {
    return true;
  }
  
  protected final String ahG()
  {
    return "GalleryChooseVideo";
  }
  
  protected final Class<? extends AppBrandProxyUIProcessTask> ahH()
  {
    return JsApiChooseVideo.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final void h(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.appId = paramParcel.readString();
    this.maxDuration = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.gvm = bool1;
      if (paramParcel.readByte() == 0) {
        break label66;
      }
      bool1 = true;
      label41:
      this.gvn = bool1;
      if (paramParcel.readByte() == 0) {
        break label71;
      }
    }
    label66:
    label71:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gvV = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label41;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.maxDuration);
    if (this.gvm)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.gvn) {
        break label68;
      }
      b1 = 1;
      label42:
      paramParcel.writeByte(b1);
      if (!this.gvV) {
        break label73;
      }
    }
    label68:
    label73:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */