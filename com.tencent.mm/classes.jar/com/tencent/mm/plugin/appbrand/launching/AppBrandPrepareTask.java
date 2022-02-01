package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cs;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.api.g;
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
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  public volatile transient boolean nxm;
  public PrepareParams pRF;
  public volatile transient af<AppBrandSysConfigWC> pRG;
  volatile transient WeakReference<Activity> pRH;
  
  public AppBrandPrepareTask(Activity paramActivity, t paramt)
  {
    AppMethodBeat.i(47107);
    this.nxm = false;
    AppBrandStatObject localAppBrandStatObject = paramt.Sk().cxf;
    this.pRF = new PrepareParams();
    this.pRH = new WeakReference(paramActivity);
    this.pRF.mAppId = paramt.mAppId;
    this.pRF.pRV = paramt.bDy().username;
    PrepareParams.a(this.pRF, paramt.ntz.cBI);
    paramActivity = this.pRF;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.pRF;
      if (localAppBrandStatObject != null) {
        break label357;
      }
    }
    label357:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.mRc = i;
      this.pRF.pRU = paramt.bDy().nBq;
      PrepareParams.a(this.pRF, paramt.bDy().cwV);
      PrepareParams.a(this.pRF, paramt.bDy().cwP);
      this.pRF.pSc = paramt.bBP();
      this.pRF.pRY = paramt.bDy().cwY;
      this.pRF.csz = paramt.Qv();
      PrepareParams.a(this.pRF, paramt.bDy().cxd);
      this.pRF.pSb = paramt.bDy().nYk;
      PrepareParams.a(this.pRF, paramt.bDy().nBB);
      PrepareParams.a(this.pRF, paramt.bDy().startTime);
      PrepareParams.b(this.pRF, paramt.bDy().nYr);
      this.pRF.pRD = paramt.bDy().cxe;
      this.pRF.pSg = paramt.bDy().launchMode;
      paramActivity = null;
      if (1173 == this.pRF.mRc) {
        paramActivity = a.alj(paramt.bDy().nYf);
      }
      PrepareParams.b(this.pRF, paramActivity);
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.fXa;
      break;
    }
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(242766);
    Object localObject;
    if (this.pRF == null)
    {
      localObject = null;
      if (this.pRF != null) {
        break label80;
      }
    }
    label80:
    for (int i = -1;; i = PrepareParams.a(this.pRF))
    {
      Log.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
      this.nxm = true;
      localObject = this.pRG;
      if (localObject != null) {
        ((af)localObject).dead();
      }
      AppMethodBeat.o(242766);
      return;
      localObject = this.pRF.mAppId;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean csz;
    public String mAppId;
    private int mDebugType;
    int mRc;
    private AppBrandLaunchFromNotifyReferrer nBB;
    com.tencent.luggage.sdk.launching.b pRD;
    private int pRT;
    String pRU;
    String pRV;
    private AppBrandLaunchReferrer pRW;
    private String pRX;
    WxaAttributes.WxaVersionInfo pRY;
    boolean pRZ;
    private boolean pSa;
    QualitySession pSb;
    public ICommLibReader pSc;
    private long pSd;
    private boolean pSe;
    private String pSf;
    int pSg;
    
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
      this.pRT = paramParcel.readInt();
      this.mRc = paramParcel.readInt();
      this.pRU = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.pRV = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.pRW = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.pRX = paramParcel.readString();
      this.pRY = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.csz = bool1;
        if (paramParcel.readInt() <= 0) {
          break label239;
        }
        bool1 = true;
        label123:
        this.pRZ = bool1;
        if (paramParcel.readInt() <= 0) {
          break label244;
        }
        bool1 = true;
        label137:
        this.pSa = bool1;
        this.pSb = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.pSc = ICommLibReader.b.h(paramParcel);
        this.nBB = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
        this.pSd = paramParcel.readLong();
        if (paramParcel.readByte() <= 0) {
          break label249;
        }
      }
      label239:
      label244:
      label249:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.pSe = bool1;
        this.pRD = com.tencent.luggage.sdk.launching.b.b(paramParcel);
        this.pSf = paramParcel.readString();
        this.pSg = paramParcel.readInt();
        AppMethodBeat.o(47101);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label123;
        bool1 = false;
        break label137;
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
      paramParcel.writeInt(this.pRT);
      paramParcel.writeInt(this.mRc);
      paramParcel.writeString(this.pRU);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.pRV);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.pRW, paramInt);
      paramParcel.writeString(this.pRX);
      paramParcel.writeParcelable(this.pRY, paramInt);
      int i;
      if (this.csz)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.pRZ) {
          break label210;
        }
        i = 1;
        label105:
        paramParcel.writeInt(i);
        if (!this.pSa) {
          break label215;
        }
        i = 1;
        label119:
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.pSb, paramInt);
        ICommLibReader.b.a(this.pSc, paramParcel, paramInt);
        paramParcel.writeParcelable(this.nBB, paramInt);
        paramParcel.writeLong(this.pSd);
        if (!this.pSe) {
          break label220;
        }
      }
      label210:
      label215:
      label220:
      for (paramInt = j;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        com.tencent.luggage.sdk.launching.b.a(this.pRD, paramParcel);
        paramParcel.writeString(this.pSf);
        paramParcel.writeInt(this.pSg);
        AppMethodBeat.o(47100);
        return;
        i = 0;
        break;
        i = 0;
        break label105;
        i = 0;
        break label119;
      }
    }
  }
  
  static final class PrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareResult> CREATOR;
    private int pSh;
    private AppBrandLaunchErrorAction pSi;
    private AppBrandSysConfigWC pSj;
    private AppStartupPerformanceReportBundle pSk;
    private int pSl;
    private long pSm;
    private com.tencent.mm.plugin.appbrand.jsapi.ad.b pSn;
    private String pSo;
    private int pSp;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.pSp = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.pSp = 0;
      this.pSh = paramParcel.readInt();
      this.pSi = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.pSj = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.pSl = paramParcel.readInt();
      this.pSm = paramParcel.readLong();
      this.pSk = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.pSp = paramParcel.readInt();
      if (this.pSh == 5)
      {
        this.pSn = com.tencent.mm.plugin.appbrand.jsapi.ad.b.aiI(paramParcel.readString());
        this.pSo = paramParcel.readString();
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
      Log.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", new Object[] { Integer.valueOf(this.pSh) });
      paramParcel.writeInt(this.pSh);
      paramParcel.writeParcelable(this.pSi, paramInt);
      paramParcel.writeParcelable(this.pSj, paramInt);
      paramParcel.writeInt(this.pSl);
      paramParcel.writeLong(this.pSm);
      paramParcel.writeParcelable(this.pSk, paramInt);
      paramParcel.writeInt(this.pSp);
      if (this.pSh == 5)
      {
        paramParcel.writeString(this.pSn.toString());
        paramParcel.writeString(this.pSo);
      }
      AppMethodBeat.o(47104);
    }
  }
  
  public static final class a
    implements com.tencent.mm.ipcinvoker.d<AppBrandPrepareTask.PrepareParams, AppBrandPrepareTask.PrepareResult>
  {}
  
  public static abstract interface b<C extends AppBrandSysConfigLU>
    extends p
  {
    public abstract void Hi(long paramLong);
    
    public abstract void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.ad.b paramb, String paramString);
    
    public abstract void bDN();
    
    public abstract void bDO();
    
    public abstract void bDP();
    
    public abstract void bDQ();
    
    public abstract void yM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */