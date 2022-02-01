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
  String dJW;
  String dki;
  int hQh;
  String iconUrl;
  int jXI;
  String krn;
  int kro;
  boolean krp;
  int scene;
  int subType;
  String title;
  String username;
  int version;
  
  static
  {
    AppMethodBeat.i(188251);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(188251);
  }
  
  protected JsApiAddToFavorites$IPCFavRequest() {}
  
  protected JsApiAddToFavorites$IPCFavRequest(Parcel paramParcel)
  {
    AppMethodBeat.i(188249);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.dki = paramParcel.readString();
    this.iconUrl = paramParcel.readString();
    this.version = paramParcel.readInt();
    this.hQh = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.krn = paramParcel.readString();
    this.kro = paramParcel.readInt();
    this.jXI = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    this.dJW = paramParcel.readString();
    this.subType = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.krp = bool;
      AppMethodBeat.o(188249);
      return;
      bool = false;
    }
  }
  
  public final Class<? extends AppBrandProxyUIProcessTask> bgN()
  {
    return JsApiAddToFavorites.a.class;
  }
  
  public final boolean bhU()
  {
    return this.krp;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(188250);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.dki);
    paramParcel.writeString(this.iconUrl);
    paramParcel.writeInt(this.version);
    paramParcel.writeInt(this.hQh);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.krn);
    paramParcel.writeInt(this.kro);
    paramParcel.writeInt(this.jXI);
    paramParcel.writeInt(this.scene);
    paramParcel.writeString(this.dJW);
    paramParcel.writeInt(this.subType);
    if (this.krp) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(188250);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.IPCFavRequest
 * JD-Core Version:    0.7.0.1
 */