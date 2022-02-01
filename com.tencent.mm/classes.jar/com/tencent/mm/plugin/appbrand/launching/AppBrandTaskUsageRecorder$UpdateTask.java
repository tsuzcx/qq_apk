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
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.ekg;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams lJY;
  
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
    this.lJY = paramLaunchCheckParams;
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(47113);
    if ((!g.ajP().gDk) || (a.aiT()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    this.lJY.getClass();
    Object localObject = this.lJY.lJW.cmx;
    ekg localekg = d.b((AppBrandLaunchReferrer)localObject);
    localObject = d.c((AppBrandLaunchReferrer)localObject);
    ehk localehk = new ehk();
    localehk.HeR = this.lJY.lJW.dQv;
    localehk.FYj = this.lJY.pkgVersion;
    localehk.Scene = this.lJY.lJX.scene;
    localehk.Hkq = this.lJY.lJW.jFL;
    localehk.Hkp = 1;
    localehk.Hko = this.lJY.lJX.dLf;
    new b(this.lJY.lJW.appId, false, localehk, localekg, (eja)localObject, this.lJY.cmr, this.lJY.kFG, this.lJY.kaS, "", this.lJY.lJW.jFX).bsA();
    AppMethodBeat.o(47113);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47115);
    this.lJY = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.lJY, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */