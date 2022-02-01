package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.plugin.appbrand.launching.a.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.ehj;
import com.tencent.mm.protocal.protobuf.eip;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams lFz;
  
  static
  {
    AppMethodBeat.i(47117);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47117);
  }
  
  AppBrandTaskUsageRecorder$UpdateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47114);
    e(paramParcel);
    AppMethodBeat.o(47114);
  }
  
  public AppBrandTaskUsageRecorder$UpdateTask(AppBrandTaskUsageRecorder.LaunchCheckParams paramLaunchCheckParams)
  {
    this.lFz = paramLaunchCheckParams;
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(47113);
    if ((!g.ajA().gAD) || (a.aiE()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    this.lFz.getClass();
    Object localObject = this.lFz.lFx.cmv;
    eip localeip = d.b((AppBrandLaunchReferrer)localObject);
    localObject = d.c((AppBrandLaunchReferrer)localObject);
    eft localeft = new eft();
    localeft.GLq = this.lFz.lFx.dPf;
    localeft.FFN = this.lFz.pkgVersion;
    localeft.Scene = this.lFz.lFy.scene;
    localeft.GQP = this.lFz.lFx.jCN;
    localeft.GQO = 1;
    localeft.GQN = this.lFz.lFy.dJQ;
    new b(this.lFz.lFx.appId, false, localeft, localeip, (ehj)localObject, this.lFz.cmp, this.lFz.kCr, this.lFz.jXD, "", this.lFz.lFx.jCZ).brP();
    AppMethodBeat.o(47113);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47115);
    this.lFz = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.lFz, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */