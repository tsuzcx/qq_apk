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
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Locale;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient a kFP;
  private ActivityStarterIpcDelegate kFQ;
  private LaunchParcel kFR;
  private AppBrandInitConfigWC kFS;
  private String kFT;
  
  static
  {
    AppMethodBeat.i(47079);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47079);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, String paramString, a parama)
  {
    AppMethodBeat.i(47071);
    this.kFR = paramLaunchParcel;
    this.kFT = paramString;
    this.kFP = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.kFQ = new ActivityStarterIpcDelegate((Activity)paramContext);; this.kFQ = null)
    {
      this.kFR.kFX = this.kFQ;
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
  
  public final void aEA()
  {
    AppMethodBeat.i(47073);
    if (this.kFP != null) {
      this.kFP.f(this.kFS);
    }
    aXn();
    AppMethodBeat.o(47073);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(47074);
    final f localf = new f(this.kFR, this.kFT, new e.a() {});
    String str = this.kFR.appId;
    int i = this.kFR.gXn;
    new ap(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { str, Integer.valueOf(i) })).postToWorker(new Runnable()
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
  
  public final void bgf()
  {
    AppMethodBeat.i(47072);
    aXm();
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
    this.kFR = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    this.kFT = paramParcel.readString();
    this.kFS = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.kFQ = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    AppMethodBeat.o(47076);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.kFR, paramInt);
    paramParcel.writeString(this.kFT);
    paramParcel.writeParcelable(this.kFS, paramInt);
    paramParcel.writeParcelable(this.kFQ, paramInt);
    AppMethodBeat.o(47075);
  }
  
  public static abstract interface a
  {
    public abstract void f(AppBrandInitConfigWC paramAppBrandInitConfigWC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */