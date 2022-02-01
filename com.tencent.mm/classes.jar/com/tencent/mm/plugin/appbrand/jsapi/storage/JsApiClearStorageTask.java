package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiClearStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiClearStorageTask> CREATOR;
  public String appId;
  public int svX;
  
  static
  {
    AppMethodBeat.i(147239);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147239);
  }
  
  public JsApiClearStorageTask() {}
  
  public JsApiClearStorageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(147235);
    h(paramParcel);
    AppMethodBeat.o(147235);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(147236);
    if (e.T(a.class) == null) {}
    for (g localg = null; localg == null; localg = ((a)e.T(a.class)).aqR())
    {
      AppMethodBeat.o(147236);
      return;
    }
    localg.ai(this.svX, this.appId);
    AppMethodBeat.o(147236);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(147237);
    this.appId = paramParcel.readString();
    this.svX = paramParcel.readInt();
    AppMethodBeat.o(147237);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147238);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.svX);
    AppMethodBeat.o(147238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask
 * JD-Core Version:    0.7.0.1
 */