package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.task.g;

public class AppBrandProcessSuicideLogic$ProcessRestartTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ProcessRestartTask> CREATOR = new AppBrandProcessSuicideLogic.ProcessRestartTask.1();
  public String dIA;
  public String fAR;
  
  public final void Zu()
  {
    b.jr(this.dIA);
    g.wn(this.fAR);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.dIA = paramParcel.readString();
    this.fAR = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.dIA);
    paramParcel.writeString(this.fAR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.ProcessRestartTask
 * JD-Core Version:    0.7.0.1
 */