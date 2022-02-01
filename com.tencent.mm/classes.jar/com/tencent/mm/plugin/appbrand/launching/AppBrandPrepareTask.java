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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  private boolean cbn;
  public volatile transient boolean iGP;
  public PrepareParams kGd;
  public volatile transient ar<AppBrandSysConfigWC> kGe;
  volatile transient WeakReference<Activity> kGf;
  
  public AppBrandPrepareTask(Activity paramActivity, o paramo)
  {
    AppMethodBeat.i(47107);
    this.iGP = false;
    AppBrandStatObject localAppBrandStatObject = paramo.DZ().cfo;
    this.kGd = new PrepareParams();
    this.kGf = new WeakReference(paramActivity);
    this.kGd.mAppId = paramo.mAppId;
    this.kGd.kGt = paramo.aNc().username;
    PrepareParams.a(this.kGd, paramo.iDx.iOP);
    paramActivity = this.kGd;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.kGd;
      if (localAppBrandStatObject != null) {
        break label272;
      }
    }
    label272:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.ifv = i;
      this.kGd.kGs = paramo.aNc().iJb;
      PrepareParams.a(this.kGd, paramo.aNc().cfi);
      PrepareParams.a(this.kGd, paramo.aNc().Da());
      this.kGd.kGA = paramo.aLC();
      this.kGd.kGw = paramo.aNc().cfl;
      this.kGd.cbn = paramo.CZ();
      PrepareParams.a(this.kGd, paramo.aNc().cfn);
      this.kGd.kGz = paramo.aNc().jdu;
      PrepareParams.a(this.kGd, paramo.aNc().iJn);
      this.cbn = paramo.CZ();
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.dzS;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean cbn;
    private AppBrandLaunchFromNotifyReferrer iJn;
    int ifv;
    public ICommLibReader kGA;
    private int kGr;
    String kGs;
    String kGt;
    private AppBrandLaunchReferrer kGu;
    private String kGv;
    WxaAttributes.WxaVersionInfo kGw;
    boolean kGx;
    private boolean kGy;
    QualitySession kGz;
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
      this.kGr = paramParcel.readInt();
      this.ifv = paramParcel.readInt();
      this.kGs = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.kGt = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.kGu = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.kGv = paramParcel.readString();
      this.kGw = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.cbn = bool1;
        if (paramParcel.readInt() <= 0) {
          break label193;
        }
        bool1 = true;
        label123:
        this.kGx = bool1;
        if (paramParcel.readInt() <= 0) {
          break label198;
        }
      }
      label193:
      label198:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kGy = bool1;
        this.kGz = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.kGA = ICommLibReader.b.g(paramParcel);
        this.iJn = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
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
      paramParcel.writeInt(this.kGr);
      paramParcel.writeInt(this.ifv);
      paramParcel.writeString(this.kGs);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.kGt);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.kGu, paramInt);
      paramParcel.writeString(this.kGv);
      paramParcel.writeParcelable(this.kGw, paramInt);
      if (this.cbn)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.kGx) {
          break label163;
        }
        i = 1;
        label105:
        paramParcel.writeInt(i);
        if (!this.kGy) {
          break label168;
        }
      }
      label163:
      label168:
      for (int i = j;; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.kGz, paramInt);
        ICommLibReader.b.a(this.kGA, paramParcel, paramInt);
        paramParcel.writeParcelable(this.iJn, paramInt);
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
    private int hHC;
    private AppBrandLaunchErrorAction kGB;
    private AppBrandSysConfigWC kGC;
    private AppStartupPerformanceReportBundle kGD;
    private int kGE;
    private long kGF;
    private com.tencent.mm.plugin.appbrand.jsapi.w.b kGG;
    private int kGH;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.kGH = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.kGH = 0;
      this.hHC = paramParcel.readInt();
      this.kGB = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.kGC = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.kGE = paramParcel.readInt();
      this.kGF = paramParcel.readLong();
      this.kGD = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.kGH = paramParcel.readInt();
      if (this.hHC == 5) {
        this.kGG = com.tencent.mm.plugin.appbrand.jsapi.w.b.Jb(paramParcel.readString());
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
      ad.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", new Object[] { Integer.valueOf(this.hHC) });
      paramParcel.writeInt(this.hHC);
      paramParcel.writeParcelable(this.kGB, paramInt);
      paramParcel.writeParcelable(this.kGC, paramInt);
      paramParcel.writeInt(this.kGE);
      paramParcel.writeLong(this.kGF);
      paramParcel.writeParcelable(this.kGD, paramInt);
      paramParcel.writeInt(this.kGH);
      if (this.hHC == 5) {
        paramParcel.writeString(this.kGG.toString());
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
    
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.w.b paramb);
    
    public abstract void aNq();
    
    public abstract void aNr();
    
    public abstract void mP(long paramLong);
    
    public abstract void qq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */