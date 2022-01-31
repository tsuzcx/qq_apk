package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiChooseVideo$ChooseRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<ChooseRequest> CREATOR;
  String appId;
  boolean hQD;
  boolean hQE;
  boolean hRG;
  int maxDuration;
  
  static
  {
    AppMethodBeat.i(131276);
    CREATOR = new JsApiChooseVideo.ChooseRequest.1();
    AppMethodBeat.o(131276);
  }
  
  JsApiChooseVideo$ChooseRequest() {}
  
  JsApiChooseVideo$ChooseRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(131275);
    j(paramParcel);
    AppMethodBeat.o(131275);
  }
  
  public final boolean aBm()
  {
    return true;
  }
  
  public final String aBn()
  {
    return "GalleryChooseVideo";
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> aBo()
  {
    return JsApiChooseVideo.a.class;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void j(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(131273);
    this.appId = paramParcel.readString();
    this.maxDuration = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.hQD = bool1;
      if (paramParcel.readByte() == 0) {
        break label76;
      }
      bool1 = true;
      label46:
      this.hQE = bool1;
      if (paramParcel.readByte() == 0) {
        break label81;
      }
    }
    label76:
    label81:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hRG = bool1;
      AppMethodBeat.o(131273);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label46;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(131274);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.maxDuration);
    if (this.hQD)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.hQE) {
        break label78;
      }
      b1 = 1;
      label47:
      paramParcel.writeByte(b1);
      if (!this.hRG) {
        break label83;
      }
    }
    label78:
    label83:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(131274);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseRequest
 * JD-Core Version:    0.7.0.1
 */