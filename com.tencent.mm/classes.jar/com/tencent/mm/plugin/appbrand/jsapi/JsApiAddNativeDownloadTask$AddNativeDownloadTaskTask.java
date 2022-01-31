package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AddNativeDownloadTaskTask> CREATOR;
  public int bsY = 0;
  public long cmm = 0L;
  private c hxo;
  Runnable hxp;
  
  static
  {
    AppMethodBeat.i(130389);
    CREATOR = new JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask.2();
    AppMethodBeat.o(130389);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130382);
    ab.i("MicroMsg.JsApiAddNativeDownloadTask", "runInMainProcess flag:%d", new Object[] { Integer.valueOf(this.bsY) });
    this.hxo = new JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask.1(this);
    a.ymk.b(this.hxo);
    AppMethodBeat.o(130382);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130383);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(130383);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130384);
    this.bsY = paramParcel.readInt();
    this.cmm = paramParcel.readLong();
    AppMethodBeat.o(130384);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130385);
    paramParcel.writeInt(this.bsY);
    paramParcel.writeLong(this.cmm);
    AppMethodBeat.o(130385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask
 * JD-Core Version:    0.7.0.1
 */