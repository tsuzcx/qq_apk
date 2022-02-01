package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiRemoveStorageTask> CREATOR;
  public String appId;
  public int kMr;
  public String key;
  
  static
  {
    AppMethodBeat.i(147277);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147277);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(147274);
    if (e.K(a.class) == null) {}
    for (d locald = null; locald == null; locald = ((a)e.K(a.class)).CJ())
    {
      AppMethodBeat.o(147274);
      return;
    }
    locald.l(this.kMr, this.appId, this.key);
    AppMethodBeat.o(147274);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147276);
    this.appId = paramParcel.readString();
    this.kMr = paramParcel.readInt();
    this.key = paramParcel.readString();
    AppMethodBeat.o(147276);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147275);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.kMr);
    paramParcel.writeString(this.key);
    AppMethodBeat.o(147275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiRemoveStorageTask
 * JD-Core Version:    0.7.0.1
 */