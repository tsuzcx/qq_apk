package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiRemoveStorageTask> CREATOR;
  public String appId;
  public int ias;
  public String key;
  
  static
  {
    AppMethodBeat.i(102071);
    CREATOR = new JsApiRemoveStorageTask.1();
    AppMethodBeat.o(102071);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(102068);
    if (e.q(com.tencent.luggage.sdk.customize.b.class) == null) {}
    for (com.tencent.mm.plugin.appbrand.appstorage.b localb = null; localb == null; localb = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wf())
    {
      AppMethodBeat.o(102068);
      return;
    }
    localb.l(this.ias, this.appId, this.key);
    AppMethodBeat.o(102068);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(102070);
    this.appId = paramParcel.readString();
    this.ias = paramParcel.readInt();
    this.key = paramParcel.readString();
    AppMethodBeat.o(102070);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102069);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.ias);
    paramParcel.writeString(this.key);
    AppMethodBeat.o(102069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiRemoveStorageTask
 * JD-Core Version:    0.7.0.1
 */