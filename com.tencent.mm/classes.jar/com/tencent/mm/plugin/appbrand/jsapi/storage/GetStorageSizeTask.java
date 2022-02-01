package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class GetStorageSizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetStorageSizeTask> CREATOR;
  public String appId;
  public Runnable rxj;
  public int size;
  
  static
  {
    AppMethodBeat.i(147227);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147227);
  }
  
  public GetStorageSizeTask() {}
  
  protected GetStorageSizeTask(Parcel paramParcel)
  {
    AppMethodBeat.i(147226);
    h(paramParcel);
    AppMethodBeat.o(147226);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(147222);
    if (e.T(a.class) == null) {}
    for (g localg = null; localg == null; localg = ((a)e.T(a.class)).aqR())
    {
      cpA();
      AppMethodBeat.o(147222);
      return;
    }
    this.size = localg.VT(this.appId);
    cpA();
    AppMethodBeat.o(147222);
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(147223);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(147223);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(147225);
    this.appId = paramParcel.readString();
    this.size = paramParcel.readInt();
    AppMethodBeat.o(147225);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147224);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.size);
    AppMethodBeat.o(147224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */