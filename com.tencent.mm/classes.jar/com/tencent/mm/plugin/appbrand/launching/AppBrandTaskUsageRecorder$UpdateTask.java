package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fez;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams mRN;
  
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
    this.mRN = paramLaunchCheckParams;
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(47113);
    if ((!g.aAf().hpY) || (com.tencent.mm.kernel.a.azj()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    this.mRN.getClass();
    Object localObject = this.mRN.kEG.cys;
    fez localfez = d.b((AppBrandLaunchReferrer)localObject);
    fds localfds = d.c((AppBrandLaunchReferrer)localObject);
    fcc localfcc = new fcc();
    localfcc.MjZ = this.mRN.kEG.eix;
    localfcc.KSa = this.mRN.pkgVersion;
    localfcc.Scene = this.mRN.mRM.scene;
    localfcc.MqE = this.mRN.kEG.kHw;
    localfcc.MqD = 1;
    localfcc.MqC = this.mRN.mRM.ecU;
    localObject = null;
    if (1173 == this.mRN.mRM.scene) {
      localObject = com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(this.mRN.kEG.ldR);
    }
    acc localacc = new acc();
    localacc.dUS = this.mRN.mRM.scene;
    if (this.mRN.kEG.cyz == com.tencent.luggage.sdk.launching.b.cBC) {}
    for (boolean bool = true;; bool = false)
    {
      localacc.LmF = bool;
      localacc.LmG = 1;
      new com.tencent.mm.plugin.appbrand.launching.a.b(this.mRN.kEG.appId, false, localfcc, localfez, localfds, this.mRN.cym, this.mRN.lKh, this.mRN.ldW, "", this.mRN.kEG.kHI, (String)localObject, localacc).bNW();
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
    this.mRN = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.mRN, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */