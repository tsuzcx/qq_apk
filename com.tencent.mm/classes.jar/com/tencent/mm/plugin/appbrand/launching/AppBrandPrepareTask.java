package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.openmaterial.model.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  public volatile transient boolean qwA;
  public PrepareParams sWs;
  public volatile transient ag<AppBrandSysConfigWC> sWt;
  volatile transient com.tencent.mm.ipcinvoker.f<?> sWu;
  volatile transient WeakReference<Activity> sWv;
  
  public AppBrandPrepareTask(Activity paramActivity, w paramw)
  {
    AppMethodBeat.i(47107);
    this.qwA = false;
    AppBrandStatObject localAppBrandStatObject = paramw.asA().epn;
    this.sWs = new PrepareParams();
    this.sWv = new WeakReference(paramActivity);
    this.sWs.mAppId = paramw.mAppId;
    this.sWs.sWX = paramw.getInitConfig().username;
    PrepareParams.a(this.sWs, paramw.qsh.eul);
    paramActivity = this.sWs;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.sWs;
      if (localAppBrandStatObject != null) {
        break label385;
      }
    }
    label385:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.pNJ = i;
      this.sWs.sWV = paramw.getInitConfig().qAF;
      this.sWs.sWW = paramw.getInitConfig().eoR;
      PrepareParams.a(this.sWs, paramw.getInitConfig().eoV);
      PrepareParams.a(this.sWs, paramw.getInitConfig().eoP);
      this.sWs.sXe = paramw.cbl();
      this.sWs.sXa = paramw.getInitConfig().epa;
      this.sWs.ekt = paramw.aqJ();
      PrepareParams.a(this.sWs, paramw.getInitConfig().epl);
      this.sWs.sXd = paramw.getInitConfig().qYm;
      PrepareParams.a(this.sWs, paramw.getInitConfig().qAQ);
      PrepareParams.a(this.sWs, paramw.getInitConfig().startTime);
      PrepareParams.b(this.sWs, paramw.getInitConfig().qYs);
      this.sWs.sWq = paramw.getInitConfig().epm;
      this.sWs.sXi = paramw.getInitConfig().launchMode;
      this.sWs.qYu = paramw.getInitConfig().qYu;
      paramActivity = null;
      if (1173 == this.sWs.pNJ) {
        paramActivity = a.aeq(paramw.getInitConfig().qYh);
      }
      PrepareParams.b(this.sWs, paramActivity);
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.icZ;
      break;
    }
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(320879);
    Object localObject;
    if (this.sWs == null)
    {
      localObject = null;
      if (this.sWs != null) {
        break label103;
      }
    }
    label103:
    for (int i = -1;; i = PrepareParams.a(this.sWs))
    {
      Log.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
      this.qwA = true;
      localObject = this.sWt;
      if (localObject != null) {
        ((ag)localObject).dead();
      }
      if (this.sWu != null)
      {
        XIPCInvoker.a(this.sWu);
        this.sWu = null;
      }
      AppMethodBeat.o(320879);
      return;
      localObject = this.sWs.mAppId;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean ekt;
    public String mAppId;
    private int mDebugType;
    int pNJ;
    private AppBrandLaunchFromNotifyReferrer qAQ;
    AppBrandRuntimeReloadReportBundle qYu;
    private int sWU;
    String sWV;
    String sWW;
    String sWX;
    private AppBrandLaunchReferrer sWY;
    private String sWZ;
    e sWq;
    WxaAttributes.WxaVersionInfo sXa;
    boolean sXb;
    private boolean sXc;
    QualitySession sXd;
    public ICommLibReader sXe;
    private long sXf;
    private boolean sXg;
    private String sXh;
    int sXi;
    
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
      this.sWU = paramParcel.readInt();
      this.pNJ = paramParcel.readInt();
      this.sWV = paramParcel.readString();
      this.sWW = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.sWX = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.sWY = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.sWZ = paramParcel.readString();
      this.sXa = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.ekt = bool1;
        if (paramParcel.readInt() <= 0) {
          break label263;
        }
        bool1 = true;
        label131:
        this.sXb = bool1;
        if (paramParcel.readInt() <= 0) {
          break label268;
        }
        bool1 = true;
        label145:
        this.sXc = bool1;
        this.sXd = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.sXe = ICommLibReader.b.j(paramParcel);
        this.qAQ = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
        this.sXf = paramParcel.readLong();
        if (paramParcel.readByte() <= 0) {
          break label273;
        }
      }
      label263:
      label268:
      label273:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.sXg = bool1;
        this.sWq = e.d(paramParcel);
        this.sXh = paramParcel.readString();
        this.sXi = paramParcel.readInt();
        this.qYu = ((AppBrandRuntimeReloadReportBundle)paramParcel.readParcelable(AppBrandRuntimeReloadReportBundle.class.getClassLoader()));
        AppMethodBeat.o(47101);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label131;
        bool1 = false;
        break label145;
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
      paramParcel.writeInt(this.sWU);
      paramParcel.writeInt(this.pNJ);
      paramParcel.writeString(this.sWV);
      paramParcel.writeString(this.sWW);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.sWX);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.sWY, paramInt);
      paramParcel.writeString(this.sWZ);
      paramParcel.writeParcelable(this.sXa, paramInt);
      if (this.ekt)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.sXb) {
          break label227;
        }
        i = 1;
        label113:
        paramParcel.writeInt(i);
        if (!this.sXc) {
          break label232;
        }
        i = 1;
        label127:
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.sXd, paramInt);
        ICommLibReader.b.a(this.sXe, paramParcel, paramInt);
        paramParcel.writeParcelable(this.qAQ, paramInt);
        paramParcel.writeLong(this.sXf);
        if (!this.sXg) {
          break label237;
        }
      }
      label227:
      label232:
      label237:
      for (int i = j;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        e.a(this.sWq, paramParcel);
        paramParcel.writeString(this.sXh);
        paramParcel.writeInt(this.sXi);
        paramParcel.writeParcelable(this.qYu, paramInt);
        AppMethodBeat.o(47100);
        return;
        i = 0;
        break;
        i = 0;
        break label113;
        i = 0;
        break label127;
      }
    }
  }
  
  static final class PrepareResult
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareResult> CREATOR;
    private AppBrandPrepareTask.c sXj;
    private AppBrandLaunchErrorAction sXk;
    private AppBrandSysConfigWC sXl;
    private AppStartupPerformanceReportBundle sXm;
    private int sXn;
    private long sXo;
    private c sXp;
    private String sXq;
    private int sXr;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.sXr = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.sXr = 0;
      this.sXj = AppBrandPrepareTask.c.BU(paramParcel.readInt());
      this.sXk = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.sXl = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.sXn = paramParcel.readInt();
      this.sXo = paramParcel.readLong();
      this.sXm = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.sXr = paramParcel.readInt();
      if (this.sXj == AppBrandPrepareTask.c.sWM)
      {
        this.sXp = c.abI(paramParcel.readString());
        this.sXq = paramParcel.readString();
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
      Log.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%s]", new Object[] { this.sXj });
      if (this.sXj != null) {}
      for (int i = this.sXj.ordinal() + 1;; i = -1)
      {
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.sXk, paramInt);
        paramParcel.writeParcelable(this.sXl, paramInt);
        paramParcel.writeInt(this.sXn);
        paramParcel.writeLong(this.sXo);
        paramParcel.writeParcelable(this.sXm, paramInt);
        paramParcel.writeInt(this.sXr);
        if (this.sXj == AppBrandPrepareTask.c.sWM)
        {
          paramParcel.writeString(this.sXp.toString());
          paramParcel.writeString(this.sXq);
        }
        AppMethodBeat.o(47104);
        return;
      }
    }
  }
  
  public static final class a
    implements com.tencent.mm.ipcinvoker.d<AppBrandPrepareTask.PrepareParams, AppBrandPrepareTask.PrepareResult>
  {}
  
  public static abstract interface b<C extends AppBrandSysConfigLU>
    extends q
  {
    public abstract void a(C paramC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void a(c paramc, String paramString);
    
    public abstract void cda();
    
    public abstract void cdb();
    
    public abstract void cdc();
    
    public abstract void cdd();
    
    public abstract void cde();
    
    public abstract void jy(long paramLong);
    
    public abstract void yV(int paramInt);
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(321142);
      sWI = new c("EVENT_NEED_DOWNLOAD", 0);
      sWJ = new c("EVENT_PREPARE_DONE", 1);
      sWK = new c("EVENT_KILL_CLIENT_PROCESS", 2);
      sWL = new c("EVENT_DOWNLOAD_PROGRESS", 3);
      sWM = new c("EVENT_NOTIFY_SILENT_UPDATE_STATE", 4);
      sWN = new c("EVENT_ON_SYNC_LAUNCH_START", 5);
      sWO = new c("EVENT_DATA_TRANSFER_STATS", 6);
      sWP = new c("EVENT_ON_SYNC_JSAPIINFO_START", 7);
      sWQ = new c("EVENT_ON_LAUNCH_TIMEOUT_FALLBACK_BACKUP_WXAATTRS_RELOAD_REQUESTED", 8);
      sWR = new c("EVENT_ON_SYNC_APPID_ABTEST_INFO_START", 9);
      sWS = new c("EVENT_NOTIFY_APP_RESTART_ON_LAUNCH_REQUESTED", 10);
      sWT = new c[] { sWI, sWJ, sWK, sWL, sWM, sWN, sWO, sWP, sWQ, sWR, sWS };
      AppMethodBeat.o(321142);
    }
    
    private c() {}
    
    public static c BU(int paramInt)
    {
      AppMethodBeat.i(321134);
      c[] arrayOfc = values();
      int j = arrayOfc.length;
      int i = 0;
      while (i < j)
      {
        c localc = arrayOfc[i];
        if (paramInt == localc.ordinal() + 1)
        {
          AppMethodBeat.o(321134);
          return localc;
        }
        i += 1;
      }
      AppMethodBeat.o(321134);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */