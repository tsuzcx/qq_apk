package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.co;
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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  public volatile transient boolean kDW;
  public PrepareParams mQJ;
  public volatile transient al<AppBrandSysConfigWC> mQK;
  volatile transient WeakReference<Activity> mQL;
  
  public AppBrandPrepareTask(Activity paramActivity, com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(47107);
    this.kDW = false;
    AppBrandStatObject localAppBrandStatObject = paramq.ON().cyA;
    this.mQJ = new PrepareParams();
    this.mQL = new WeakReference(paramActivity);
    this.mQJ.mAppId = paramq.mAppId;
    this.mQJ.mRa = paramq.bsC().username;
    PrepareParams.a(this.mQJ, paramq.kAq.eix);
    paramActivity = this.mQJ;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.mQJ;
      if (localAppBrandStatObject != null) {
        break label343;
      }
    }
    label343:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.jZJ = i;
      this.mQJ.mQZ = paramq.bsC().kHw;
      PrepareParams.a(this.mQJ, paramq.bsC().cys);
      PrepareParams.a(this.mQJ, paramq.bsC().cym);
      this.mQJ.mRh = paramq.bqZ();
      this.mQJ.mRd = paramq.bsC().cyv;
      this.mQJ.cuy = paramq.NA();
      PrepareParams.a(this.mQJ, paramq.bsC().cyy);
      this.mQJ.mRg = paramq.bsC().ldW;
      PrepareParams.a(this.mQJ, paramq.bsC().kHI);
      PrepareParams.a(this.mQJ, paramq.bsC().startTime);
      PrepareParams.b(this.mQJ, paramq.bsC().led);
      this.mQJ.mQH = paramq.bsC().cyz;
      paramActivity = null;
      if (1173 == this.mQJ.jZJ) {
        paramActivity = com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(paramq.bsC().ldR);
      }
      PrepareParams.b(this.mQJ, paramActivity);
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.ecU;
      break;
    }
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(227062);
    Object localObject;
    if (this.mQJ == null)
    {
      localObject = null;
      if (this.mQJ != null) {
        break label80;
      }
    }
    label80:
    for (int i = -1;; i = PrepareParams.a(this.mQJ))
    {
      Log.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
      this.kDW = true;
      localObject = this.mQK;
      if (localObject != null) {
        ((al)localObject).dead();
      }
      AppMethodBeat.o(227062);
      return;
      localObject = this.mQJ.mAppId;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean cuy;
    int jZJ;
    private AppBrandLaunchFromNotifyReferrer kHI;
    public String mAppId;
    private int mDebugType;
    com.tencent.luggage.sdk.launching.b mQH;
    private int mQY;
    String mQZ;
    String mRa;
    private AppBrandLaunchReferrer mRb;
    private String mRc;
    WxaAttributes.WxaVersionInfo mRd;
    boolean mRe;
    private boolean mRf;
    QualitySession mRg;
    public ICommLibReader mRh;
    private long mRi;
    private boolean mRj;
    private String mRk;
    
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
      this.mQY = paramParcel.readInt();
      this.jZJ = paramParcel.readInt();
      this.mQZ = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mRa = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.mRb = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.mRc = paramParcel.readString();
      this.mRd = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.cuy = bool1;
        if (paramParcel.readInt() <= 0) {
          break label231;
        }
        bool1 = true;
        label123:
        this.mRe = bool1;
        if (paramParcel.readInt() <= 0) {
          break label236;
        }
        bool1 = true;
        label137:
        this.mRf = bool1;
        this.mRg = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.mRh = ICommLibReader.b.h(paramParcel);
        this.kHI = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
        this.mRi = paramParcel.readLong();
        if (paramParcel.readByte() <= 0) {
          break label241;
        }
      }
      label231:
      label236:
      label241:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.mRj = bool1;
        this.mQH = com.tencent.luggage.sdk.launching.b.b(paramParcel);
        this.mRk = paramParcel.readString();
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
      paramParcel.writeInt(this.mQY);
      paramParcel.writeInt(this.jZJ);
      paramParcel.writeString(this.mQZ);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mRa);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.mRb, paramInt);
      paramParcel.writeString(this.mRc);
      paramParcel.writeParcelable(this.mRd, paramInt);
      int i;
      if (this.cuy)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.mRe) {
          break label202;
        }
        i = 1;
        label105:
        paramParcel.writeInt(i);
        if (!this.mRf) {
          break label207;
        }
        i = 1;
        label119:
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.mRg, paramInt);
        ICommLibReader.b.a(this.mRh, paramParcel, paramInt);
        paramParcel.writeParcelable(this.kHI, paramInt);
        paramParcel.writeLong(this.mRi);
        if (!this.mRj) {
          break label212;
        }
      }
      label202:
      label207:
      label212:
      for (paramInt = j;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        com.tencent.luggage.sdk.launching.b.a(this.mQH, paramParcel);
        paramParcel.writeString(this.mRk);
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
    private int mRl;
    private AppBrandLaunchErrorAction mRm;
    private AppBrandSysConfigWC mRn;
    private AppStartupPerformanceReportBundle mRo;
    private int mRp;
    private long mRq;
    private com.tencent.mm.plugin.appbrand.jsapi.ab.b mRr;
    private String mRs;
    private int mRt;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.mRt = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.mRt = 0;
      this.mRl = paramParcel.readInt();
      this.mRm = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.mRn = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.mRp = paramParcel.readInt();
      this.mRq = paramParcel.readLong();
      this.mRo = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.mRt = paramParcel.readInt();
      if (this.mRl == 5)
      {
        this.mRr = com.tencent.mm.plugin.appbrand.jsapi.ab.b.aaQ(paramParcel.readString());
        this.mRs = paramParcel.readString();
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
      Log.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", new Object[] { Integer.valueOf(this.mRl) });
      paramParcel.writeInt(this.mRl);
      paramParcel.writeParcelable(this.mRm, paramInt);
      paramParcel.writeParcelable(this.mRn, paramInt);
      paramParcel.writeInt(this.mRp);
      paramParcel.writeLong(this.mRq);
      paramParcel.writeParcelable(this.mRo, paramInt);
      paramParcel.writeInt(this.mRt);
      if (this.mRl == 5)
      {
        paramParcel.writeString(this.mRr.toString());
        paramParcel.writeString(this.mRs);
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
    public abstract void AW(long paramLong);
    
    public abstract void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.ab.b paramb, String paramString);
    
    public abstract void bsQ();
    
    public abstract void bsR();
    
    public abstract void bsS();
    
    public abstract void vz(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */