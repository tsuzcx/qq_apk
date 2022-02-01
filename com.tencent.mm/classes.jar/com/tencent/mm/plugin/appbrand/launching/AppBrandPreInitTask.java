package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.f.i;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Objects;

public final class AppBrandPreInitTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private Context context;
  private transient a mQt;
  private ActivityStarterIpcDelegate mQu;
  private LaunchParcel mQv;
  private boolean mQw;
  private AppBrandInitConfigWC mQx;
  private boolean mQy;
  
  static
  {
    AppMethodBeat.i(47079);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(47079);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, a parama)
  {
    this(paramContext, paramLaunchParcel, false, parama);
  }
  
  public AppBrandPreInitTask(Context paramContext, LaunchParcel paramLaunchParcel, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(227054);
    this.context = paramContext;
    this.mQv = paramLaunchParcel;
    this.mQw = paramBoolean;
    this.mQt = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.mQu = new ActivityStarterIpcDelegate((Activity)paramContext);; this.mQu = null)
    {
      this.mQv.mQC = this.mQu;
      AppMethodBeat.o(227054);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47077);
    f(paramParcel);
    AppMethodBeat.o(47077);
  }
  
  public final void bNf()
  {
    AppMethodBeat.i(47072);
    if (this.mQv.mYM == 0L) {
      this.mQv.mYM = Util.nowMilliSecond();
    }
    bDJ();
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(47072);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(47074);
    Object localObject1 = com.tencent.mm.plugin.appbrand.report.quality.g.c(this.mQv, (String)Objects.requireNonNull(this.mQv.appId));
    Object localObject2 = w.nHZ;
    w.b(this.mQv, (String)localObject1);
    if (o.bVk())
    {
      localObject2 = o.nMe;
      o.eI(this.mQv.appId, (String)localObject1);
      c.e(KSProcessWeAppLaunch.class, this.mQv.appId);
      c.a(KSProcessWeAppLaunch.class, this.mQv.appId, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(this.context) }));
    }
    localObject1 = new f(this.mQv, (String)localObject1, this.mQw, new e.a() {});
    localObject2 = this.mQv.appId;
    final int i = this.mQv.iOo;
    com.tencent.f.h.RTc.aZ(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(227053);
        String str = String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { this.val$appId, Integer.valueOf(i) });
        AppMethodBeat.o(227053);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(47069);
        this.mQA.run();
        AppMethodBeat.o(47069);
      }
    });
    AppMethodBeat.o(47074);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(47073);
    if (this.mQt != null)
    {
      if (!this.mQy) {
        break label57;
      }
      this.mQt.a(null, null);
      ((b)com.tencent.mm.kernel.g.af(b.class)).hr(this.context);
    }
    for (;;)
    {
      bDK();
      AppMethodBeat.o(47073);
      return;
      label57:
      this.mQt.a(this.mQx, this.mQv.mYK);
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47076);
    this.mQv = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.mQw = bool1;
      this.mQx = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.mQu = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label95;
      }
    }
    label95:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mQy = bool1;
      AppMethodBeat.o(47076);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b = 1;
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.mQv, paramInt);
    int i;
    if (this.mQw)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.mQx, paramInt);
      paramParcel.writeParcelable(this.mQu, paramInt);
      if (!this.mQy) {
        break label77;
      }
    }
    for (;;)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(47075);
      return;
      i = 0;
      break;
      label77:
      b = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */