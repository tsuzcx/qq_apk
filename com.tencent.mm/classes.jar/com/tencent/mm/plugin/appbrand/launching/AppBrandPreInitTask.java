package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Locale;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient AppBrandPreInitTask.a ijH;
  private ActivityStarterIpcDelegate ijI;
  private LaunchParcel ijJ;
  private AppBrandInitConfigWC ijK;
  private String ijL;
  
  static
  {
    AppMethodBeat.i(131728);
    CREATOR = new AppBrandPreInitTask.3();
    AppMethodBeat.o(131728);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, String paramString, AppBrandPreInitTask.a parama)
  {
    AppMethodBeat.i(131721);
    this.ijJ = paramLaunchParcel;
    this.ijL = paramString;
    this.ijH = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.ijI = new ActivityStarterIpcDelegate((Activity)paramContext);; this.ijI = null)
    {
      this.ijJ.ijQ = this.ijI;
      AppMethodBeat.o(131721);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(131726);
    f(paramParcel);
    AppMethodBeat.o(131726);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(131723);
    e locale = new e(this.ijJ, this.ijL, new d.a() {});
    String str = this.ijJ.appId;
    int i = this.ijJ.hcr;
    new al(String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { str, Integer.valueOf(i) })).ac(new AppBrandPreInitTask.2(this, locale));
    AppMethodBeat.o(131723);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(131722);
    if (this.ijH != null) {
      this.ijH.b(this.ijK);
    }
    aBk();
    AppMethodBeat.o(131722);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(131725);
    this.ijJ = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    this.ijL = paramParcel.readString();
    this.ijK = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.ijI = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
    AppMethodBeat.o(131725);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131724);
    paramParcel.writeParcelable(this.ijJ, paramInt);
    paramParcel.writeString(this.ijL);
    paramParcel.writeParcelable(this.ijK, paramInt);
    paramParcel.writeParcelable(this.ijI, paramInt);
    AppMethodBeat.o(131724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */