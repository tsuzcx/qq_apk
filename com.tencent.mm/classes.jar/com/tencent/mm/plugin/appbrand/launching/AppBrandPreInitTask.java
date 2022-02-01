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
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient a lIF;
  private ActivityStarterIpcDelegate lIG;
  private LaunchParcel lIH;
  private boolean lII;
  private AppBrandInitConfigWC lIJ;
  private String lIK;
  
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
    AppMethodBeat.i(222741);
    this.lIH = paramLaunchParcel;
    this.lIK = paramString;
    this.lII = paramBoolean;
    this.lIF = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.lIG = new ActivityStarterIpcDelegate((Activity)paramContext);; this.lIG = null)
    {
      this.lIH.lIP = this.lIG;
      AppMethodBeat.o(222741);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47077);
    e(paramParcel);
    AppMethodBeat.o(47077);
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(47074);
    final f localf = new f(this.lIH, this.lIK, this.lII, new e.a() {});
    final String str = this.lIH.appId;
    final int i = this.lIH.hSZ;
    com.tencent.e.h.MqF.aQ(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(222740);
        String str = String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(222740);
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
  
  public final void aOY()
  {
    AppMethodBeat.i(47073);
    if (this.lIF != null) {
      this.lIF.a(this.lIJ, this.lIH.lRA);
    }
    bix();
    AppMethodBeat.o(47073);
  }
  
  public final void bru()
  {
    AppMethodBeat.i(47072);
    if (this.lIH.lRC == 0L) {
      this.lIH.lRC = bu.fpO();
    }
    biw();
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
    this.lIH = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    this.lIK = paramParcel.readString();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.lII = bool;
      this.lIJ = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.lIG = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
      AppMethodBeat.o(47076);
      return;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.lIH, paramInt);
    paramParcel.writeString(this.lIK);
    if (this.lII) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.lIJ, paramInt);
      paramParcel.writeParcelable(this.lIG, paramInt);
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