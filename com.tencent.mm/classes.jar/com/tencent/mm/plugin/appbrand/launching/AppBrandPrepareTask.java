package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
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
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  public volatile transient boolean jzS;
  public PrepareParams lEx;
  public volatile transient at<AppBrandSysConfigWC> lEy;
  volatile transient WeakReference<Activity> lEz;
  
  public AppBrandPrepareTask(Activity paramActivity, o paramo)
  {
    AppMethodBeat.i(47107);
    this.jzS = false;
    AppBrandStatObject localAppBrandStatObject = paramo.Fb().cmC;
    this.lEx = new PrepareParams();
    this.lEz = new WeakReference(paramActivity);
    this.lEx.mAppId = paramo.mAppId;
    this.lEx.lEN = paramo.aXc().username;
    PrepareParams.a(this.lEx, paramo.jwG.dPf);
    paramActivity = this.lEx;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.lEx;
      if (localAppBrandStatObject != null) {
        break label294;
      }
    }
    label294:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.iYN = i;
      this.lEx.lEM = paramo.aXc().jCN;
      PrepareParams.a(this.lEx, paramo.aXc().cmv);
      PrepareParams.a(this.lEx, paramo.aXc().Ec());
      this.lEx.lEU = paramo.aVF();
      this.lEx.lEQ = paramo.aXc().cmy;
      this.lEx.ciC = paramo.Eb();
      PrepareParams.a(this.lEx, paramo.aXc().cmB);
      this.lEx.lET = paramo.aXc().jXD;
      PrepareParams.a(this.lEx, paramo.aXc().jCZ);
      PrepareParams.a(this.lEx, paramo.aXc().startTime);
      PrepareParams.b(this.lEx, paramo.aXc().jXK);
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.dJQ;
      break;
    }
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(188589);
    Object localObject;
    if (this.lEx == null)
    {
      localObject = null;
      if (this.lEx != null) {
        break label80;
      }
    }
    label80:
    for (int i = -1;; i = PrepareParams.a(this.lEx))
    {
      ad.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
      this.jzS = true;
      localObject = this.lEy;
      if (localObject != null) {
        ((at)localObject).dead();
      }
      AppMethodBeat.o(188589);
      return;
      localObject = this.lEx.mAppId;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean ciC;
    int iYN;
    private AppBrandLaunchFromNotifyReferrer jCZ;
    private int lEL;
    String lEM;
    String lEN;
    private AppBrandLaunchReferrer lEO;
    private String lEP;
    WxaAttributes.WxaVersionInfo lEQ;
    boolean lER;
    private boolean lES;
    QualitySession lET;
    public ICommLibReader lEU;
    private long lEV;
    private boolean lEW;
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
      this.lEL = paramParcel.readInt();
      this.iYN = paramParcel.readInt();
      this.lEM = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.lEN = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.lEO = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.lEP = paramParcel.readString();
      this.lEQ = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.ciC = bool1;
        if (paramParcel.readInt() <= 0) {
          break label215;
        }
        bool1 = true;
        label123:
        this.lER = bool1;
        if (paramParcel.readInt() <= 0) {
          break label220;
        }
        bool1 = true;
        label137:
        this.lES = bool1;
        this.lET = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.lEU = ICommLibReader.b.g(paramParcel);
        this.jCZ = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
        this.lEV = paramParcel.readLong();
        if (paramParcel.readByte() <= 0) {
          break label225;
        }
      }
      label215:
      label220:
      label225:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lEW = bool1;
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
      paramParcel.writeInt(this.lEL);
      paramParcel.writeInt(this.iYN);
      paramParcel.writeString(this.lEM);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.lEN);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.lEO, paramInt);
      paramParcel.writeString(this.lEP);
      paramParcel.writeParcelable(this.lEQ, paramInt);
      int i;
      if (this.ciC)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.lER) {
          break label186;
        }
        i = 1;
        label105:
        paramParcel.writeInt(i);
        if (!this.lES) {
          break label191;
        }
        i = 1;
        label119:
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.lET, paramInt);
        ICommLibReader.b.a(this.lEU, paramParcel, paramInt);
        paramParcel.writeParcelable(this.jCZ, paramInt);
        paramParcel.writeLong(this.lEV);
        if (!this.lEW) {
          break label196;
        }
      }
      label186:
      label191:
      label196:
      for (paramInt = j;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
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
    private int iBy;
    private AppBrandLaunchErrorAction lEX;
    private AppBrandSysConfigWC lEY;
    private AppStartupPerformanceReportBundle lEZ;
    private int lFa;
    private long lFb;
    private com.tencent.mm.plugin.appbrand.jsapi.y.b lFc;
    private String lFd;
    private int lFe;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.lFe = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.lFe = 0;
      this.iBy = paramParcel.readInt();
      this.lEX = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.lEY = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.lFa = paramParcel.readInt();
      this.lFb = paramParcel.readLong();
      this.lEZ = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.lFe = paramParcel.readInt();
      if (this.iBy == 5)
      {
        this.lFc = com.tencent.mm.plugin.appbrand.jsapi.y.b.QC(paramParcel.readString());
        this.lFd = paramParcel.readString();
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
      ad.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", new Object[] { Integer.valueOf(this.iBy) });
      paramParcel.writeInt(this.iBy);
      paramParcel.writeParcelable(this.lEX, paramInt);
      paramParcel.writeParcelable(this.lEY, paramInt);
      paramParcel.writeInt(this.lFa);
      paramParcel.writeLong(this.lFb);
      paramParcel.writeParcelable(this.lEZ, paramInt);
      paramParcel.writeInt(this.lFe);
      if (this.iBy == 5)
      {
        paramParcel.writeString(this.lFc.toString());
        paramParcel.writeString(this.lFd);
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
    
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.y.b paramb, String paramString);
    
    public abstract void aXo();
    
    public abstract void aXp();
    
    public abstract void aXq();
    
    public abstract void rD(int paramInt);
    
    public abstract void sC(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */