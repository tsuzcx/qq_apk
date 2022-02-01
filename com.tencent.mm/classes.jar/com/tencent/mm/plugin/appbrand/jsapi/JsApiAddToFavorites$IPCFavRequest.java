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
  String dLl;
  String dlk;
  int hSZ;
  String iconUrl;
  int kaX;
  String kuD;
  int kuE;
  boolean kuF;
  int scene;
  int subType;
  String title;
  String username;
  int version;
  
  static
  {
    AppMethodBeat.i(222377);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(222377);
  }
  
  protected JsApiAddToFavorites$IPCFavRequest() {}
  
  protected JsApiAddToFavorites$IPCFavRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(222375);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.dlk = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.hSZ = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.kuD = paramParcel.readString();
    this.kuE = paramParcel.readInt();
    this.kaX = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.dLl = paramParcel.readString();
    this.subType = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.kuF = bool;
      AppMethodBeat.o(222375);
      return;
      bool = false;
    }
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> bhv()
  {
    return JsApiAddToFavorites.a.class;
  }
  
  public final boolean biD()
  {
    return this.kuF;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(222376);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dlk);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.hSZ);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.kuD);
    paramParcel.writeInt(this.kuE);
    paramParcel.writeInt(this.kaX);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.dLl);
    paramParcel.writeInt(this.subType);
    if (this.kuF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(222376);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavRequest
 * JD-Core Version:    0.7.0.1
 */