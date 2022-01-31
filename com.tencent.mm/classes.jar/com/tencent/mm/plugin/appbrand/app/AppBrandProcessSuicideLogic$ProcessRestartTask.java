package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.h;

public class AppBrandProcessSuicideLogic$ProcessRestartTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ProcessRestartTask> CREATOR;
  public String gSG;
  public String mProcessName;
  
  static
  {
    AppMethodBeat.i(129201);
    CREATOR = new AppBrandProcessSuicideLogic.ProcessRestartTask.1();
    AppMethodBeat.o(129201);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(129198);
    b.qf(this.mProcessName);
    h.EV(this.gSG);
    AppMethodBeat.o(129198);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(129200);
    this.mProcessName = paramParcel.readString();
    this.gSG = paramParcel.readString();
    AppMethodBeat.o(129200);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(129199);
    paramParcel.writeString(this.mProcessName);
    paramParcel.writeString(this.gSG);
    AppMethodBeat.o(129199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.ProcessRestartTask
 * JD-Core Version:    0.7.0.1
 */