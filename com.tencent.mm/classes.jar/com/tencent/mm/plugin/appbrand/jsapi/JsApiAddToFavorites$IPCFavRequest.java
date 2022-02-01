package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

final class JsApiAddToFavorites$IPCFavRequest
  extends AppBrandProxyUIProcessTask.ProcessRequest
{
  public static final Parcelable.Creator<IPCFavRequest> CREATOR;
  String appId;
  int euz;
  String hzy;
  String iconUrl;
  String idf;
  int nOX;
  String rxr;
  int rxs;
  boolean rxt;
  int scene;
  int subType;
  String title;
  String username;
  int version;
  
  static
  {
    AppMethodBeat.i(325615);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(325615);
  }
  
  protected JsApiAddToFavorites$IPCFavRequest() {}
  
  protected JsApiAddToFavorites$IPCFavRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(325610);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.hzy = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.euz = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.rxr = paramParcel.readString();
    this.rxs = paramParcel.readInt();
    this.nOX = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.idf = paramParcel.readString();
    this.subType = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.rxt = bool;
      AppMethodBeat.o(325610);
      return;
      bool = false;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
  {
    return JsApiAddToFavorites.a.class;
  }
  
  public final boolean useLandscape()
  {
    return this.rxt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(325622);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hzy);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.euz);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.rxr);
    paramParcel.writeInt(this.rxs);
    paramParcel.writeInt(this.nOX);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.idf);
    paramParcel.writeInt(this.subType);
    if (this.rxt) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(325622);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavRequest
 * JD-Core Version:    0.7.0.1
 */