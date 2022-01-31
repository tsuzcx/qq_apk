package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.clr;
import com.tencent.mm.protocal.c.cmu;
import com.tencent.mm.protocal.c.cnk;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR = new AppBrandTaskUsageRecorder.UpdateTask.1();
  AppBrandTaskUsageRecorder.LaunchCheckParams gJP;
  
  AppBrandTaskUsageRecorder$UpdateTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public AppBrandTaskUsageRecorder$UpdateTask(AppBrandTaskUsageRecorder.LaunchCheckParams paramLaunchCheckParams)
  {
    this.gJP = paramLaunchCheckParams;
  }
  
  public final void Zu()
  {
    if ((!g.DN().dJH) || (com.tencent.mm.kernel.a.CW())) {
      return;
    }
    this.gJP.getClass();
    Object localObject = this.gJP.gJN.fPr;
    cnk localcnk = b.b((AppBrandLaunchReferrer)localObject);
    localObject = b.c((AppBrandLaunchReferrer)localObject);
    clr localclr = new clr();
    localclr.tmZ = this.gJP.gJN.fEL;
    localclr.sCy = this.gJP.fEN;
    localclr.pyo = this.gJP.gJO.scene;
    localclr.tqN = this.gJP.gJN.fPq;
    localclr.tqM = 1;
    localclr.tqL = this.gJP.gJO.caB;
    new com.tencent.mm.plugin.appbrand.launching.a.a(this.gJP.gJN.appId, false, localclr, localcnk, (cmu)localObject, this.gJP.fJO, this.gJP.glj, this.gJP.fPC).alT();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gJP = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.gJP, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */