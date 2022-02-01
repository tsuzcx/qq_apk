package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class GetStorageSizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetStorageSizeTask> CREATOR;
  public String appId;
  public Runnable otv;
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
    f(paramParcel);
    AppMethodBeat.o(147226);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(147222);
    if (e.K(a.class) == null) {}
    for (d locald = null; locald == null; locald = ((a)e.K(a.class)).QF())
    {
      bPt();
      AppMethodBeat.o(147222);
      return;
    }
    this.size = locald.adw(this.appId);
    bPt();
    AppMethodBeat.o(147222);
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(147223);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(147223);
  }
  
  public final void f(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */