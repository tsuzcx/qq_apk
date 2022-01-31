package com.tencent.mm.plugin.appbrand;

import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public class AppBrandMainProcessPrepareTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandMainProcessPrepareTask> CREATOR = new AppBrandMainProcessPrepareTask.1();
  private Runnable fyh = null;
  
  AppBrandMainProcessPrepareTask()
  {
    ahC();
  }
  
  public final void Zu()
  {
    ahI();
  }
  
  public final void Zv()
  {
    if (this.fyh != null) {
      this.fyh.run();
    }
    ahD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandMainProcessPrepareTask
 * JD-Core Version:    0.7.0.1
 */