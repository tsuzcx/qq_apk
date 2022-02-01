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
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.protocal.protobuf.dws;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams kHc;
  
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
    this.kHc = paramLaunchCheckParams;
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(47113);
    if ((!g.afz().gcn) || (a.aeC()))
    {
      AppMethodBeat.o(47113);
      return;
    }
    this.kHc.getClass();
    Object localObject = this.kHc.kHa.cfi;
    dws localdws = d.b((AppBrandLaunchReferrer)localObject);
    localObject = d.c((AppBrandLaunchReferrer)localObject);
    dty localdty = new dty();
    localdty.DGx = this.kHc.kHa.iOP;
    localdty.CHC = this.kHc.pkgVersion;
    localdty.Scene = this.kHc.kHb.scene;
    localdty.DKY = this.kHc.kHa.iJb;
    localdty.DKX = 1;
    localdty.DKW = this.kHc.kHb.dzS;
    new b(this.kHc.kHa.appId, false, localdty, localdws, (dvo)localObject, this.kHc.cfb, this.kHc.jHb, this.kHc.jdu, "", this.kHc.kHa.iJn).bhc();
    AppMethodBeat.o(47113);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47115);
    this.kHc = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(47115);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47116);
    paramParcel.writeParcelable(this.kHc, paramInt);
    AppMethodBeat.o(47116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */