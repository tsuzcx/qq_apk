package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  private boolean bYk;
  public volatile transient boolean jgS;
  public PrepareParams lhw;
  public volatile transient ar<AppBrandSysConfigWC> lhx;
  volatile transient WeakReference<Activity> lhy;
  
  public AppBrandPrepareTask(Activity paramActivity, o paramo)
  {
    AppMethodBeat.i(47107);
    this.jgS = false;
    AppBrandStatObject localAppBrandStatObject = paramo.DC().ccl;
    this.lhw = new PrepareParams();
    this.lhy = new WeakReference(paramActivity);
    this.lhw.mAppId = paramo.mAppId;
    this.lhw.lhM = paramo.aTS().username;
    PrepareParams.a(this.lhw, paramo.jdx.joY);
    paramActivity = this.lhw;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.lhw;
      if (localAppBrandStatObject != null) {
        break label272;
      }
    }
    label272:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.iFE = i;
      this.lhw.lhL = paramo.aTS().jjf;
      PrepareParams.a(this.lhw, paramo.aTS().cce);
      PrepareParams.a(this.lhw, paramo.aTS().CD());
      this.lhw.lhT = paramo.aSt();
      this.lhw.lhP = paramo.aTS().cch;
      this.lhw.bYk = paramo.CC();
      PrepareParams.a(this.lhw, paramo.aTS().cck);
      this.lhw.lhS = paramo.aTS().jDH;
      PrepareParams.a(this.lhw, paramo.aTS().jjr);
      this.bYk = paramo.CC();
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.dxE;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean bYk;
    int iFE;
    private AppBrandLaunchFromNotifyReferrer jjr;
    private int lhK;
    String lhL;
    String lhM;
    private AppBrandLaunchReferrer lhN;
    private String lhO;
    WxaAttributes.WxaVersionInfo lhP;
    boolean lhQ;
    private boolean lhR;
    QualitySession lhS;
    public ICommLibReader lhT;
    public String mAppId;
    private int mDebugType;
    
    static
    {
      AppMethodBeat.i(47102);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47102);
    }
    
    PrepareParams() {}
    
    PrepareParams(Parcel paramParcel)
    {
      AppMethodBeat.i(47101);
      this.lhK = paramParcel.readInt();
      this.iFE = paramParcel.readInt();
      this.lhL = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.lhM = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.lhN = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.lhO = paramParcel.readString();
      this.lhP = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.bYk = bool1;
        if (paramParcel.readInt() <= 0) {
          break label193;
        }
        bool1 = true;
        label123:
        this.lhQ = bool1;
        if (paramParcel.readInt() <= 0) {
          break label198;
        }
      }
      label193:
      label198:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lhR = bool1;
        this.lhS = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.lhT = ICommLibReader.b.g(paramParcel);
        this.jjr = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
        AppMethodBeat.o(47101);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label123;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 1;
      AppMethodBeat.i(47100);
      paramParcel.writeInt(this.lhK);
      paramParcel.writeInt(this.iFE);
      paramParcel.writeString(this.lhL);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.lhM);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.lhN, paramInt);
      paramParcel.writeString(this.lhO);
      paramParcel.writeParcelable(this.lhP, paramInt);
      if (this.bYk)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.lhQ) {
          break label163;
        }
        i = 1;
        label105:
        paramParcel.writeInt(i);
        if (!this.lhR) {
          break label168;
        }
      }
      label163:
      label168:
      for (int i = j;; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.lhS, paramInt);
        ICommLibReader.b.a(this.lhT, paramParcel, paramInt);
        paramParcel.writeParcelable(this.jjr, paramInt);
        AppMethodBeat.o(47100);
        return;
        i = 0;
        break;
        i = 0;
        break label105;
      }
    }
  }
  
  static final class PrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareResult> CREATOR;
    private int iie;
    private AppBrandLaunchErrorAction lhU;
    private AppBrandSysConfigWC lhV;
    private AppStartupPerformanceReportBundle lhW;
    private int lhX;
    private long lhY;
    private com.tencent.mm.plugin.appbrand.jsapi.v.b lhZ;
    private String lia;
    private int lib;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.lib = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.lib = 0;
      this.iie = paramParcel.readInt();
      this.lhU = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.lhV = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.lhX = paramParcel.readInt();
      this.lhY = paramParcel.readLong();
      this.lhW = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.lib = paramParcel.readInt();
      if (this.iie == 5)
      {
        this.lhZ = com.tencent.mm.plugin.appbrand.jsapi.v.b.Nf(paramParcel.readString());
        this.lia = paramParcel.readString();
      }
      AppMethodBeat.o(47105);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(47104);
      ac.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", new Object[] { Integer.valueOf(this.iie) });
      paramParcel.writeInt(this.iie);
      paramParcel.writeParcelable(this.lhU, paramInt);
      paramParcel.writeParcelable(this.lhV, paramInt);
      paramParcel.writeInt(this.lhX);
      paramParcel.writeLong(this.lhY);
      paramParcel.writeParcelable(this.lhW, paramInt);
      paramParcel.writeInt(this.lib);
      if (this.iie == 5)
      {
        paramParcel.writeString(this.lhZ.toString());
        paramParcel.writeString(this.lia);
      }
      AppMethodBeat.o(47104);
    }
  }
  
  public static final class a
    implements com.tencent.mm.ipcinvoker.b<AppBrandPrepareTask.PrepareParams, AppBrandPrepareTask.PrepareResult>
  {}
  
  public static abstract interface b<C extends AppBrandSysConfigLU>
    extends q
  {
    public abstract void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.v.b paramb, String paramString);
    
    public abstract void aUg();
    
    public abstract void aUh();
    
    public abstract void qE(long paramLong);
    
    public abstract void rd(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */