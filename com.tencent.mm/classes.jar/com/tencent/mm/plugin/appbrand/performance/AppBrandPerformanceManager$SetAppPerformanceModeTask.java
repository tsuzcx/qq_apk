package com.tencent.mm.plugin.appbrand.performance;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class AppBrandPerformanceManager$SetAppPerformanceModeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetAppPerformanceModeTask> CREATOR;
  private String mAppId;
  private boolean mEnable;
  
  static
  {
    AppMethodBeat.i(147580);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(147580);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(147577);
    d locald = ((a)e.K(a.class)).Ej();
    String str2 = this.mAppId + "_PerformancePanelEnabled";
    if (this.mEnable) {}
    for (String str1 = "1";; str1 = "0")
    {
      locald.cx(str2, str1);
      AppMethodBeat.o(147577);
      return;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(147578);
    this.mAppId = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mEnable = bool;
      AppMethodBeat.o(147578);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(147579);
    paramParcel.writeString(this.mAppId);
    if (this.mEnable) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(147579);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.SetAppPerformanceModeTask
 * JD-Core Version:    0.7.0.1
 */