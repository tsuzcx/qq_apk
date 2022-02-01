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
  int cBU;
  String fXg;
  String fve;
  String iconUrl;
  int nYp;
  String otD;
  int otE;
  boolean otF;
  int scene;
  int subType;
  String title;
  String username;
  int version;
  
  static
  {
    AppMethodBeat.i(276402);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(276402);
  }
  
  protected JsApiAddToFavorites$IPCFavRequest() {}
  
  protected JsApiAddToFavorites$IPCFavRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(276399);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.fve = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.cBU = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.otD = paramParcel.readString();
    this.otE = paramParcel.readInt();
    this.nYp = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.fXg = paramParcel.readString();
    this.subType = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.otF = bool;
      AppMethodBeat.o(276399);
      return;
      bool = false;
    }
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> bOe()
  {
    return JsApiAddToFavorites.a.class;
  }
  
  public final boolean bPq()
  {
    return this.otF;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(276400);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.fve);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.otD);
    paramParcel.writeInt(this.otE);
    paramParcel.writeInt(this.nYp);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.fXg);
    paramParcel.writeInt(this.subType);
    if (this.otF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(276400);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavRequest
 * JD-Core Version:    0.7.0.1
 */