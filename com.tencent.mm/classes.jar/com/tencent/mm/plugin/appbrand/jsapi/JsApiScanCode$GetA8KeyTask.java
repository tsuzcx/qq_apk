package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.w;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class JsApiScanCode$GetA8KeyTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetA8KeyTask> CREATOR;
  public int actionCode;
  public int cpE;
  public int cpF;
  public String hzI;
  public String hzJ;
  public Runnable hzK;
  
  static
  {
    AppMethodBeat.i(130565);
    CREATOR = new JsApiScanCode.GetA8KeyTask.2();
    AppMethodBeat.o(130565);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130559);
    j localj = new j(this.hzI, 36, this.cpE, this.cpF, null, (int)System.currentTimeMillis(), new byte[0]);
    w.a(localj.rr, new JsApiScanCode.GetA8KeyTask.1(this, localj), true);
    AppMethodBeat.o(130559);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130560);
    if (this.hzK != null) {
      this.hzK.run();
    }
    AppMethodBeat.o(130560);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130562);
    this.hzI = paramParcel.readString();
    this.actionCode = paramParcel.readInt();
    this.hzJ = paramParcel.readString();
    this.cpE = paramParcel.readInt();
    this.cpF = paramParcel.readInt();
    AppMethodBeat.o(130562);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130561);
    paramParcel.writeString(this.hzI);
    paramParcel.writeInt(this.actionCode);
    paramParcel.writeString(this.hzJ);
    paramParcel.writeInt(this.cpE);
    paramParcel.writeInt(this.cpF);
    AppMethodBeat.o(130561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask
 * JD-Core Version:    0.7.0.1
 */