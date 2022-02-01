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
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.protocal.protobuf.ecj;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams liw;
  
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
    this.liw = paramLaunchCheckParams;
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(47113);
    if ((!g.agP().ggT) || (a.afS()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    this.liw.getClass();
    Object localObject = this.liw.liu.cce;
    ecj localecj = d.b((AppBrandLaunchReferrer)localObject);
    localObject = d.c((AppBrandLaunchReferrer)localObject);
    dzp localdzp = new dzp();
    localdzp.FbR = this.liw.liu.joY;
    localdzp.Eae = this.liw.pkgVersion;
    localdzp.Scene = this.liw.liv.scene;
    localdzp.Fhn = this.liw.liu.jjf;
    localdzp.Fhm = 1;
    localdzp.Fhl = this.liw.liv.dxE;
    new b(this.liw.liu.appId, false, localdzp, localecj, (ebf)localObject, this.liw.cbY, this.liw.khA, this.liw.jDH, "", this.liw.liu.jjr).bnW();
    AppMethodBeat.o(47113);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47115);
    this.liw = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.liw, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */