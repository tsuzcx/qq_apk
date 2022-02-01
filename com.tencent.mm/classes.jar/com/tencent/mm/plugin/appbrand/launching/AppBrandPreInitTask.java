package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AccountScopedMainProcessTask;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.report.quality.o;
import com.tencent.mm.plugin.appbrand.report.x;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Objects;

public final class AppBrandPreInitTask
  extends AccountScopedMainProcessTask
{
  public static final Parcelable.Creator<AppBrandPreInitTask> CREATOR;
  private transient Context context;
  private transient a pRo;
  private ActivityStarterIpcDelegate pRp;
  private LaunchParcel pRq;
  private boolean pRr;
  private AppBrandInitConfigWC pRs;
  private boolean pRt;
  private boolean pRu;
  
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
    AppMethodBeat.i(257806);
    this.context = paramContext;
    this.pRq = paramLaunchParcel;
    this.pRr = paramBoolean;
    this.pRo = parama;
    if ((paramContext instanceof Activity)) {}
    for (this.pRp = new ActivityStarterIpcDelegate((Activity)paramContext);; this.pRp = null)
    {
      this.pRq.pRy = this.pRp;
      AppMethodBeat.o(257806);
      return;
    }
  }
  
  private AppBrandPreInitTask(Parcel paramParcel)
  {
    AppMethodBeat.i(47077);
    f(paramParcel);
    AppMethodBeat.o(47077);
  }
  
  public final void bPb()
  {
    AppMethodBeat.i(257815);
    Object localObject1 = g.c(this.pRq, (String)Objects.requireNonNull(this.pRq.appId));
    Object localObject2 = x.qKl;
    x.b(this.pRq, (String)localObject1);
    if (o.civ())
    {
      localObject2 = o.qOt;
      o.eW(this.pRq.appId, (String)localObject1);
      c.d(KSProcessWeAppLaunch.class, this.pRq.appId);
      c.a(KSProcessWeAppLaunch.class, this.pRq.appId, String.format("Network:%s", new Object[] { NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()) }));
    }
    localObject1 = new e(this.pRq, (String)localObject1, this.pRr, new d.a() {});
    localObject2 = this.pRq.appId;
    final int i = this.pRq.cBU;
    com.tencent.e.h.ZvG.bg(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        AppMethodBeat.i(284259);
        String str = String.format(Locale.US, "AppBrandPreInitTask-%s|%d", new Object[] { this.val$appId, Integer.valueOf(i) });
        AppMethodBeat.o(284259);
        return str;
      }
      
      public final void run()
      {
        AppMethodBeat.i(47069);
        this.pRw.run();
        AppMethodBeat.o(47069);
      }
    });
    AppMethodBeat.o(257815);
  }
  
  public final void bPc()
  {
    AppMethodBeat.i(257812);
    AccountScopedMainProcessTask.bPd();
    this.pRu = true;
    bPt();
    AppMethodBeat.o(257812);
  }
  
  public final void bZw()
  {
    AppMethodBeat.i(47072);
    if (this.pRq.pZk == 0L) {
      this.pRq.pZk = Util.nowMilliSecond();
    }
    bsM();
    AppMethodBeat.o(47072);
  }
  
  /* Error */
  public final void bsK()
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 207	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRu	Z
    //   9: ifeq +37 -> 46
    //   12: aload_0
    //   13: getfield 56	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:context	Landroid/content/Context;
    //   16: instanceof 64
    //   19: ifeq +17 -> 36
    //   22: getstatic 230	com/tencent/mm/plugin/appbrand/ui/o:qYS	Lcom/tencent/mm/plugin/appbrand/ui/o;
    //   25: astore_1
    //   26: aload_0
    //   27: getfield 56	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:context	Landroid/content/Context;
    //   30: checkcast 64	android/app/Activity
    //   33: invokestatic 233	com/tencent/mm/plugin/appbrand/ui/o:H	(Landroid/app/Activity;)V
    //   36: aload_0
    //   37: invokevirtual 236	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:bPk	()V
    //   40: ldc 224
    //   42: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: aload_0
    //   47: getfield 62	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRo	Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$a;
    //   50: ifnull +38 -> 88
    //   53: aload_0
    //   54: getfield 91	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRt	Z
    //   57: ifeq +41 -> 98
    //   60: aload_0
    //   61: getfield 62	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRo	Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$a;
    //   64: aconst_null
    //   65: aconst_null
    //   66: invokeinterface 239 3 0
    //   71: ldc 241
    //   73: invokestatic 247	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   76: checkcast 241	com/tencent/mm/plugin/teenmode/a/b
    //   79: aload_0
    //   80: getfield 56	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:context	Landroid/content/Context;
    //   83: invokeinterface 251 2 0
    //   88: aload_0
    //   89: invokevirtual 236	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:bPk	()V
    //   92: ldc 224
    //   94: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: return
    //   98: aload_0
    //   99: getfield 62	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRo	Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$a;
    //   102: aload_0
    //   103: getfield 87	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRs	Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   106: aload_0
    //   107: getfield 58	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:pRq	Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;
    //   110: getfield 255	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:pdk	Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;
    //   113: invokeinterface 239 3 0
    //   118: goto -30 -> 88
    //   121: astore_1
    //   122: aload_0
    //   123: invokevirtual 236	com/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask:bPk	()V
    //   126: ldc 224
    //   128: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	AppBrandPreInitTask
    //   25	1	1	localo	com.tencent.mm.plugin.appbrand.ui.o
    //   121	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	36	121	finally
    //   46	88	121	finally
    //   98	118	121	finally
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool2 = true;
    AppMethodBeat.i(47076);
    this.pRq = ((LaunchParcel)paramParcel.readParcelable(LaunchParcel.class.getClassLoader()));
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.pRr = bool1;
      this.pRs = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      this.pRp = ((ActivityStarterIpcDelegate)paramParcel.readParcelable(ActivityStarterIpcDelegate.class.getClassLoader()));
      if (paramParcel.readByte() == 0) {
        break label111;
      }
      bool1 = true;
      label80:
      this.pRt = bool1;
      if (paramParcel.readByte() <= 0) {
        break label116;
      }
    }
    label111:
    label116:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pRu = bool1;
      AppMethodBeat.o(47076);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(47075);
    paramParcel.writeParcelable(this.pRq, paramInt);
    int i;
    byte b;
    if (this.pRr)
    {
      i = 1;
      paramParcel.writeByte((byte)i);
      paramParcel.writeParcelable(this.pRs, paramInt);
      paramParcel.writeParcelable(this.pRp, paramInt);
      if (!this.pRt) {
        break label96;
      }
      b = 1;
      label62:
      paramParcel.writeByte(b);
      if (!this.pRu) {
        break label101;
      }
    }
    label96:
    label101:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(47075);
      return;
      i = 0;
      break;
      b = 0;
      break label62;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask
 * JD-Core Version:    0.7.0.1
 */