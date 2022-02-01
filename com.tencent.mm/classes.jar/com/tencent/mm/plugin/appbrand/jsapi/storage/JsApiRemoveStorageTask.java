package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiRemoveStorageTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiRemoveStorageTask> CREATOR;
  public String appId;
  public String key;
  public int svX;
  
  static
  {
    AppMethodBeat.i(147277);
    CREATOR = new JsApiRemoveStorageTask.1();
    AppMethodBeat.o(147277);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(147274);
    if (e.T(a.class) == null) {}
    for (g localg = null; localg == null; localg = ((a)e.T(a.class)).aqR())
    {
      AppMethodBeat.o(147274);
      return;
    }
    localg.o(this.svX, this.appId, this.key);
    AppMethodBeat.o(147274);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(147276);
    this.appId = paramParcel.readString();
    this.svX = paramParcel.readInt();
    this.key = paramParcel.readString();
    AppMethodBeat.o(147276);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147275);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.svX);
    paramParcel.writeString(this.key);
    AppMethodBeat.o(147275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiRemoveStorageTask
 * JD-Core Version:    0.7.0.1
 */