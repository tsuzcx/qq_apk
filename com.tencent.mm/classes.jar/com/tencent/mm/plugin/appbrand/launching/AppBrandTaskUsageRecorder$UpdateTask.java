package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dbs;

public final class AppBrandTaskUsageRecorder$UpdateTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UpdateTask> CREATOR;
  AppBrandTaskUsageRecorder.LaunchCheckParams ikB;
  
  static
  {
    AppMethodBeat.i(131769);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(131769);
  }
  
  AppBrandTaskUsageRecorder$UpdateTask(Parcel paramParcel)
  {
    AppMethodBeat.i(131766);
    f(paramParcel);
    AppMethodBeat.o(131766);
  }
  
  public AppBrandTaskUsageRecorder$UpdateTask(AppBrandTaskUsageRecorder.LaunchCheckParams paramLaunchCheckParams)
  {
    this.ikB = paramLaunchCheckParams;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(131765);
    if ((!g.RJ().eHg) || (com.tencent.mm.kernel.a.QP()))
    {
      AppMethodBeat.o(131765);
      return;
    }
    this.ikB.getClass();
    Object localObject = this.ikB.ikz.hiz;
    dbs localdbs = b.b((AppBrandLaunchReferrer)localObject);
    localObject = b.c((AppBrandLaunchReferrer)localObject);
    czi localczi = new czi();
    localczi.xmQ = this.ikB.ikz.gXd;
    localczi.wwX = this.ikB.gXf;
    localczi.Scene = this.ikB.ikA.scene;
    localczi.xqN = this.ikB.ikz.hiw;
    localczi.xqM = 1;
    localczi.xqL = this.ikB.ikA.cJb;
    new com.tencent.mm.plugin.appbrand.launching.a.a(this.ikB.ikz.appId, false, localczi, localdbs, (das)localObject, this.ikB.bCU, this.ikB.hEZ, this.ikB.hiI).aHn();
    AppMethodBeat.o(131765);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(131767);
    this.ikB = ((AppBrandTaskUsageRecorder.LaunchCheckParams)paramParcel.readParcelable(AppBrandTaskUsageRecorder.LaunchCheckParams.class.getClassLoader()));
    AppMethodBeat.o(131767);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131768);
    paramParcel.writeParcelable(this.ikB, paramInt);
    AppMethodBeat.o(131768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask
 * JD-Core Version:    0.7.0.1
 */