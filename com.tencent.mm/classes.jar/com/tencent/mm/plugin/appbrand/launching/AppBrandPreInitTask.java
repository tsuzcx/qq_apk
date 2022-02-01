package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient a lEg;
  private ActivityStarterIpcDelegate lEh;
  private LaunchParcel lEi;
  private boolean lEj;
  private AppBrandInitConfigWC lEk;
  private String lEl;
  
  static
  {
    AppMethodBeat.i(47079);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47079);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, String paramString, a parama)
  {
    this(paramContext, paramLaunchParcel, paramString, false, parama);
    AppMethodBeat.i(47071);
    AppMethodBeat.o(47071);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(188582);
    this.lEi = paramLaunchParcel;
    this.lEl = paramString;
    this.lEj = paramBoolean;
    this.lEg = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.lEh = new ActivityStarterIpcDelegate((Activity)paramContext);; this.lEh = null)
    {
      this.lEi.lEq = this.lEh;
      AppMethodBeat.o(188582);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47077);
    e(paramParcel);
    AppMethodBeat.o(47077);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(47074);
    final f localf = new f(this.lEi, this.lEl, this.lEj, new e.a() {});
    final String str = this.lEi.appId;
    final int i = this.lEi.hQh;
    com.tencent.e.h.LTJ.aT(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(188581);
        String str = String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(188581);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(47069);
        localf.run();
        AppMethodBeat.o(47069);
      }
    });
    AppMethodBeat.o(47074);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(47073);
    if (this.lEg != null) {
      this.lEg.a(this.lEk, this.lEi.lMZ);
    }
    bhO();
    AppMethodBeat.o(47073);
  }
  
  public final void bqK()
  {
    AppMethodBeat.i(47072);
    if (this.lEi.lNb == 0L) {
      this.lEi.lNb = bt.flT();
    }
    bhN();
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
    this.lEi = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    this.lEl = paramParcel.readString();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.lEj = bool;
      this.lEk = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.lEh = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
      AppMethodBeat.o(47076);
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.lEi, paramInt);
    paramParcel.writeString(this.lEl);
    if (this.lEj) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.lEk, paramInt);
      paramParcel.writeParcelable(this.lEh, paramInt);
      AppMethodBeat.o(47075);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */