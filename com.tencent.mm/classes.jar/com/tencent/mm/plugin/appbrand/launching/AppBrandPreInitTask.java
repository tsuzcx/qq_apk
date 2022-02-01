package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AccountScopedMainProcessTask;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.teenmode.AppBrandTeenModeTempAuthMgr;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.f;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import com.tencent.mm.plugin.appbrand.report.y;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Locale;
import java.util.Objects;
import kotlin.ah;
import kotlin.g.a.m;

public final class AppBrandPreInitTask
  extends AccountScopedMainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient Context context;
  private transient a sWa;
  private ActivityStarterIpcDelegate sWb;
  private LaunchParcel sWc;
  private boolean sWd;
  public boolean sWe;
  private AppBrandInitConfigWC sWf;
  private boolean sWg;
  private boolean sWh;
  
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
    AppMethodBeat.i(320865);
    this.context = paramContext;
    this.sWc = paramLaunchParcel;
    this.sWd = paramBoolean;
    this.sWe = false;
    this.sWa = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.sWb = new ActivityStarterIpcDelegate((Activity)paramContext);; this.sWb = null)
    {
      this.sWc.sWl = this.sWb;
      AppMethodBeat.o(320865);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47077);
    h(paramParcel);
    AppMethodBeat.o(47077);
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(47073);
    try
    {
      Object localObject1;
      if (this.sWh)
      {
        if ((this.context instanceof Activity))
        {
          localObject1 = s.ueP;
          s.N((Activity)this.context);
        }
        return;
      }
      if (this.sWa != null)
      {
        if (!this.sWg) {
          break label107;
        }
        localObject1 = AppBrandTeenModeTempAuthMgr.tfe;
        AppBrandTeenModeTempAuthMgr.a(this.context, this.sWf, new m() {});
      }
      for (;;)
      {
        return;
        label107:
        this.sWa.onResult(this.sWf, this.sWc.siB);
      }
      AppMethodBeat.o(47073);
    }
    finally
    {
      if (!this.sWg) {
        cpx();
      }
      AppMethodBeat.o(47073);
    }
  }
  
  public final void cpq()
  {
    AppMethodBeat.i(320923);
    Object localObject1 = f.a(this.sWc, (String)Objects.requireNonNull(this.sWc.appId), this.sWe);
    Object localObject2 = y.tOP;
    y.b(this.sWc, (String)localObject1);
    if (n.cJm())
    {
      localObject2 = n.tTb;
      n.fn(this.sWc.appId, (String)localObject1);
      c.d(KSProcessWeAppLaunch.class, this.sWc.appId);
      c.a(KSProcessWeAppLaunch.class, this.sWc.appId, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()) }));
    }
    localObject1 = new g(this.sWc, (String)localObject1, this.sWd, new f.a() {});
    localObject2 = this.sWc.appId;
    final int i = this.sWc.euz;
    com.tencent.threadpool.h.ahAA.bo(new com.tencent.threadpool.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(320816);
        String str = String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { this.etl, Integer.valueOf(i) });
        AppMethodBeat.o(320816);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(320810);
        this.sWj.run();
        AppMethodBeat.o(320810);
      }
    });
    AppMethodBeat.o(320923);
  }
  
  public final void cpr()
  {
    AppMethodBeat.i(320918);
    AccountScopedMainProcessTask.cps();
    this.sWh = true;
    cpA();
    AppMethodBeat.o(320918);
  }
  
  public final void czH()
  {
    AppMethodBeat.i(47072);
    if (this.sWc.tdX == 0L) {
      this.sWc.tdX = Util.nowMilliSecond();
    }
    bQt();
    AppMethodBeat.o(47072);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void h(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47076);
    this.sWc = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.sWd = bool1;
      if (paramParcel.readByte() <= 0) {
        break label125;
      }
      bool1 = true;
      label47:
      this.sWe = bool1;
      this.sWf = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.sWb = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label130;
      }
      bool1 = true;
      label94:
      this.sWg = bool1;
      if (paramParcel.readByte() <= 0) {
        break label135;
      }
    }
    label130:
    label135:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.sWh = bool1;
      AppMethodBeat.o(47076);
      return;
      bool1 = false;
      break;
      label125:
      bool1 = false;
      break label47;
      bool1 = false;
      break label94;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.sWc, paramInt);
    int i;
    label45:
    byte b;
    if (this.sWd)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      if (!this.sWe) {
        break label113;
      }
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.sWf, paramInt);
      paramParcel.writeParcelable(this.sWb, paramInt);
      if (!this.sWg) {
        break label119;
      }
      b = 1;
      label79:
      paramParcel.writeByte(b);
      if (!this.sWh) {
        break label124;
      }
    }
    label113:
    label119:
    label124:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(47075);
      return;
      i = 0;
      break;
      i = 0;
      break label45;
      b = 0;
      break label79;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */