package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Locale;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient a lhi;
  private ActivityStarterIpcDelegate lhj;
  private LaunchParcel lhk;
  private AppBrandInitConfigWC lhl;
  private String lhm;
  
  static
  {
    AppMethodBeat.i(47079);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47079);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, String paramString, a parama)
  {
    AppMethodBeat.i(47071);
    this.lhk = paramLaunchParcel;
    this.lhm = paramString;
    this.lhi = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.lhj = new ActivityStarterIpcDelegate((Activity)paramContext);; this.lhj = null)
    {
      this.lhk.lhq = this.lhj;
      AppMethodBeat.o(47071);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47077);
    e(paramParcel);
    AppMethodBeat.o(47077);
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(47074);
    final f localf = new f(this.lhk, this.lhm, new e.a() {});
    String str = this.lhk.appId;
    int i = this.lhk.hxM;
    new ao(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { str, Integer.valueOf(i) })).postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47069);
        localf.run();
        AppMethodBeat.o(47069);
      }
    });
    AppMethodBeat.o(47074);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(47073);
    if (this.lhi != null) {
      this.lhi.f(this.lhl);
    }
    bek();
    AppMethodBeat.o(47073);
  }
  
  public final void bmZ()
  {
    AppMethodBeat.i(47072);
    bej();
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(47072);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(47076);
    this.lhk = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    this.lhm = paramParcel.readString();
    this.lhl = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.lhj = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    AppMethodBeat.o(47076);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.lhk, paramInt);
    paramParcel.writeString(this.lhm);
    paramParcel.writeParcelable(this.lhl, paramInt);
    paramParcel.writeParcelable(this.lhj, paramInt);
    AppMethodBeat.o(47075);
  }
  
  public static abstract interface a
  {
    public abstract void f(AppBrandInitConfigWC paramAppBrandInitConfigWC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */