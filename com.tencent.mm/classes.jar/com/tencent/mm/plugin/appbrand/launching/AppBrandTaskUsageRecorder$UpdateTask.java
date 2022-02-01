package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.gjw;
import com.tencent.mm.protocal.protobuf.glu;
import com.tencent.mm.protocal.protobuf.gnj;
import java.util.Objects;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams sXI;
  
  static
  {
    AppMethodBeat.i(47117);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47117);
  }
  
  AppBrandTaskUsageRecorder$UpdateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47114);
    h(paramParcel);
    AppMethodBeat.o(47114);
  }
  
  public AppBrandTaskUsageRecorder$UpdateTask(AppBrandTaskUsageRecorder.LaunchCheckParams paramLaunchCheckParams)
  {
    this.sXI = paramLaunchCheckParams;
  }
  
  public final void asn()
  {
    AppMethodBeat.i(47113);
    if ((!h.baC().mBZ) || (com.tencent.mm.kernel.b.aZG()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    Objects.requireNonNull(this.sXI);
    Object localObject = this.sXI.initConfig.eoV;
    gnj localgnj = com.tencent.mm.plugin.appbrand.launching.a.e.b((AppBrandLaunchReferrer)localObject);
    glu localglu = com.tencent.mm.plugin.appbrand.launching.a.e.c((AppBrandLaunchReferrer)localObject);
    gjw localgjw = new gjw();
    localgjw.aaJu = this.sXI.initConfig.eul;
    localgjw.YQB = this.sXI.pkgVersion;
    localgjw.IJG = this.sXI.sXH.scene;
    localgjw.aaQW = this.sXI.initConfig.qAF;
    localgjw.aaQV = 1;
    localgjw.aaQU = this.sXI.sXH.icZ;
    localObject = null;
    if (1173 == this.sXI.sXH.scene) {
      localObject = a.aeq(this.sXI.initConfig.qYh);
    }
    aeo localaeo = new aeo();
    localaeo.hUn = this.sXI.sXH.scene;
    this.sXI.initConfig.epm.a(localaeo);
    localaeo.ZmB = 1;
    new com.tencent.mm.plugin.appbrand.launching.a.b(this.sXI.initConfig.appId, false, localgjw, localgnj, localglu, this.sXI.eoP, this.sXI.rJw, this.sXI.qYm, "", this.sXI.initConfig.qAQ, (String)localObject, localaeo, this.sXI.initConfig.launchMode).asM();
    AppMethodBeat.o(47113);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(47115);
    this.sXI = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.sXI, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */