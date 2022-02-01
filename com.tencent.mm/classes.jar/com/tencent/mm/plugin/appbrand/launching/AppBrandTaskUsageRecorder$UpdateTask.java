package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.e;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.fnd;
import com.tencent.mm.protocal.protobuf.fot;
import com.tencent.mm.protocal.protobuf.fqa;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams pSJ;
  
  static
  {
    AppMethodBeat.i(47117);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47117);
  }
  
  AppBrandTaskUsageRecorder$UpdateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47114);
    f(paramParcel);
    AppMethodBeat.o(47114);
  }
  
  public AppBrandTaskUsageRecorder$UpdateTask(AppBrandTaskUsageRecorder.LaunchCheckParams paramLaunchCheckParams)
  {
    this.pSJ = paramLaunchCheckParams;
  }
  
  public final void RW()
  {
    AppMethodBeat.i(47113);
    if ((!h.aHE().kbT) || (com.tencent.mm.kernel.b.aGE()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    this.pSJ.getClass();
    Object localObject = this.pSJ.nyg.cwV;
    fqa localfqa = e.b((AppBrandLaunchReferrer)localObject);
    fot localfot = e.c((AppBrandLaunchReferrer)localObject);
    fnd localfnd = new fnd();
    localfnd.TuP = this.pSJ.nyg.cBI;
    localfnd.RTb = this.pSJ.pkgVersion;
    localfnd.CPw = this.pSJ.pSI.scene;
    localfnd.TBH = this.pSJ.nyg.nBq;
    localfnd.TBG = 1;
    localfnd.TBF = this.pSJ.pSI.fXa;
    localObject = null;
    if (1173 == this.pSJ.pSI.scene) {
      localObject = a.alj(this.pSJ.nyg.nYf);
    }
    ack localack = new ack();
    localack.fOu = this.pSJ.pSI.scene;
    if (this.pSJ.nyg.cxe == com.tencent.luggage.sdk.launching.b.cBf) {}
    for (boolean bool = true;; bool = false)
    {
      localack.SnY = bool;
      localack.SnZ = 1;
      new com.tencent.mm.plugin.appbrand.launching.a.b(this.pSJ.nyg.appId, false, localfnd, localfqa, localfot, this.pSJ.cwP, this.pSJ.oGx, this.pSJ.nYk, "", this.pSJ.nyg.nBB, (String)localObject, localack, this.pSJ.nyg.launchMode).caq();
      AppMethodBeat.o(47113);
      return;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(47115);
    this.pSJ = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.pSJ, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */