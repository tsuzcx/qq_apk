package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class GetStorageSizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetStorageSizeTask> CREATOR;
  public String appId;
  public Runnable hxp;
  public int size;
  
  static
  {
    AppMethodBeat.i(102021);
    CREATOR = new GetStorageSizeTask.1();
    AppMethodBeat.o(102021);
  }
  
  public GetStorageSizeTask() {}
  
  protected GetStorageSizeTask(Parcel paramParcel)
  {
    AppMethodBeat.i(102020);
    f(paramParcel);
    AppMethodBeat.o(102020);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(102016);
    if (e.q(com.tencent.luggage.sdk.customize.b.class) == null) {}
    for (com.tencent.mm.plugin.appbrand.appstorage.b localb = null; localb == null; localb = ((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).wf())
    {
      aBp();
      AppMethodBeat.o(102016);
      return;
    }
    this.size = localb.yT(this.appId);
    aBp();
    AppMethodBeat.o(102016);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(102017);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(102017);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(102019);
    this.appId = paramParcel.readString();
    this.size = paramParcel.readInt();
    AppMethodBeat.o(102019);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(102018);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.size);
    AppMethodBeat.o(102018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */