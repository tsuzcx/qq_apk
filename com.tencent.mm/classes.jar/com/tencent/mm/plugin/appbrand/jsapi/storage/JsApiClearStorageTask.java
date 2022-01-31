package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiClearStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiClearStorageTask> CREATOR;
  public String appId;
  public int ias;
  
  static
  {
    AppMethodBeat.i(102033);
    CREATOR = new JsApiClearStorageTask.1();
    AppMethodBeat.o(102033);
  }
  
  public JsApiClearStorageTask() {}
  
  public JsApiClearStorageTask(Parcel paramParcel)
  {
    AppMethodBeat.i(102029);
    f(paramParcel);
    AppMethodBeat.o(102029);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(102030);
    if (e.q(com.tencent.luggage.sdk.customize.b.class) == null) {}
    for (com.tencent.mm.plugin.appbrand.appstorage.b localb = null; localb == null; localb = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wf())
    {
      AppMethodBeat.o(102030);
      return;
    }
    localb.I(this.ias, this.appId);
    AppMethodBeat.o(102030);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(102031);
    this.appId = paramParcel.readString();
    this.ias = paramParcel.readInt();
    AppMethodBeat.o(102031);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102032);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.ias);
    AppMethodBeat.o(102032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask
 * JD-Core Version:    0.7.0.1
 */