package com.tencent.mm.plugin.appbrand.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class AppBrandProcessSuicideLogic$RebootProcessAndTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<RebootProcessAndTask> CREATOR;
  public String fas;
  public String mProcessName;
  public AppBrandInitConfigWC qBH;
  public AppBrandStatObject qxv;
  
  static
  {
    AppMethodBeat.i(317744);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(317744);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(317751);
    c.bEE();
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317648);
        Toast.makeText(MMApplicationContext.getContext(), AppBrandProcessSuicideLogic.RebootProcessAndTask.this.fas, 1).show();
        n localn = new n(AppBrandProcessSuicideLogic.RebootProcessAndTask.this.qBH, AppBrandProcessSuicideLogic.RebootProcessAndTask.this.qxv);
        i.cJV().a(MMApplicationContext.getContext(), localn);
        AppMethodBeat.o(317648);
      }
    }, 500L);
    AppMethodBeat.o(317751);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(317760);
    this.mProcessName = paramParcel.readString();
    this.qBH = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
    this.qxv = ((AppBrandStatObject)paramParcel.readParcelable(AppBrandStatObject.class.getClassLoader()));
    this.fas = paramParcel.readString();
    AppMethodBeat.o(317760);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(317757);
    paramParcel.writeString(this.mProcessName);
    paramParcel.writeParcelable(this.qBH, paramInt);
    paramParcel.writeParcelable(this.qxv, paramInt);
    paramParcel.writeString(this.fas);
    AppMethodBeat.o(317757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.RebootProcessAndTask
 * JD-Core Version:    0.7.0.1
 */