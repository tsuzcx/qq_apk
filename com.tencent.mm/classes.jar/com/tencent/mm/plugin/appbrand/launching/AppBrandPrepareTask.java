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
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class AppBrandPrepareTask
{
  public volatile transient boolean jCV;
  public PrepareParams lIW;
  public volatile transient at<AppBrandSysConfigWC> lIX;
  volatile transient WeakReference<Activity> lIY;
  
  public AppBrandPrepareTask(Activity paramActivity, com.tencent.mm.plugin.appbrand.p paramp)
  {
    AppMethodBeat.i(47107);
    this.jCV = false;
    AppBrandStatObject localAppBrandStatObject = paramp.Fg().cmE;
    this.lIW = new PrepareParams();
    this.lIY = new WeakReference(paramActivity);
    this.lIW.mAppId = paramp.mAppId;
    this.lIW.lJm = paramp.aXx().username;
    PrepareParams.a(this.lIW, paramp.jzC.dQv);
    paramActivity = this.lIW;
    if (localAppBrandStatObject == null)
    {
      i = 0;
      PrepareParams.b(paramActivity, i);
      paramActivity = this.lIW;
      if (localAppBrandStatObject != null) {
        break label294;
      }
    }
    label294:
    for (int i = j;; i = localAppBrandStatObject.scene)
    {
      paramActivity.jbG = i;
      this.lIW.lJl = paramp.aXx().jFL;
      PrepareParams.a(this.lIW, paramp.aXx().cmx);
      PrepareParams.a(this.lIW, paramp.aXx().Ef());
      this.lIW.lJt = paramp.aWe();
      this.lIW.lJp = paramp.aXx().cmA;
      this.lIW.ciE = paramp.Ee();
      PrepareParams.a(this.lIW, paramp.aXx().cmD);
      this.lIW.lJs = paramp.aXx().kaS;
      PrepareParams.a(this.lIW, paramp.aXx().jFX);
      PrepareParams.a(this.lIW, paramp.aXx().startTime);
      PrepareParams.b(this.lIW, paramp.aXx().kaZ);
      AppMethodBeat.o(47107);
      return;
      i = localAppBrandStatObject.dLf;
      break;
    }
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(222748);
    Object localObject;
    if (this.lIW == null)
    {
      localObject = null;
      if (this.lIW != null) {
        break label80;
      }
    }
    label80:
    for (int i = -1;; i = PrepareParams.a(this.lIW))
    {
      ae.i("MicroMsg.AppBrandPrepareTask", "interrupt() appId[%s] type[%d]", new Object[] { localObject, Integer.valueOf(i) });
      this.jCV = true;
      localObject = this.lIX;
      if (localObject != null) {
        ((at)localObject).dead();
      }
      AppMethodBeat.o(222748);
      return;
      localObject = this.lIW.mAppId;
      break;
    }
  }
  
  public static final class PrepareParams
    implements Parcelable
  {
    public static final Parcelable.Creator<PrepareParams> CREATOR;
    boolean ciE;
    private AppBrandLaunchFromNotifyReferrer jFX;
    int jbG;
    private int lJk;
    String lJl;
    String lJm;
    private AppBrandLaunchReferrer lJn;
    private String lJo;
    WxaAttributes.WxaVersionInfo lJp;
    boolean lJq;
    private boolean lJr;
    QualitySession lJs;
    public ICommLibReader lJt;
    private long lJu;
    private boolean lJv;
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
      this.lJk = paramParcel.readInt();
      this.jbG = paramParcel.readInt();
      this.lJl = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.lJm = paramParcel.readString();
      this.mDebugType = paramParcel.readInt();
      this.lJn = ((AppBrandLaunchReferrer)paramParcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader()));
      this.lJo = paramParcel.readString();
      this.lJp = ((WxaAttributes.WxaVersionInfo)paramParcel.readParcelable(WxaAttributes.WxaVersionInfo.class.getClassLoader()));
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.ciE = bool1;
        if (paramParcel.readInt() <= 0) {
          break label215;
        }
        bool1 = true;
        label123:
        this.lJq = bool1;
        if (paramParcel.readInt() <= 0) {
          break label220;
        }
        bool1 = true;
        label137:
        this.lJr = bool1;
        this.lJs = ((QualitySession)paramParcel.readParcelable(QualitySession.class.getClassLoader()));
        this.lJt = ICommLibReader.b.g(paramParcel);
        this.jFX = ((AppBrandLaunchFromNotifyReferrer)paramParcel.readParcelable(AppBrandLaunchFromNotifyReferrer.class.getClassLoader()));
        this.lJu = paramParcel.readLong();
        if (paramParcel.readByte() <= 0) {
          break label225;
        }
      }
      label215:
      label220:
      label225:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lJv = bool1;
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
      paramParcel.writeInt(this.lJk);
      paramParcel.writeInt(this.jbG);
      paramParcel.writeString(this.lJl);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.lJm);
      paramParcel.writeInt(this.mDebugType);
      paramParcel.writeParcelable(this.lJn, paramInt);
      paramParcel.writeString(this.lJo);
      paramParcel.writeParcelable(this.lJp, paramInt);
      int i;
      if (this.ciE)
      {
        i = 1;
        paramParcel.writeInt(i);
        if (!this.lJq) {
          break label186;
        }
        i = 1;
        label105:
        paramParcel.writeInt(i);
        if (!this.lJr) {
          break label191;
        }
        i = 1;
        label119:
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.lJs, paramInt);
        ICommLibReader.b.a(this.lJt, paramParcel, paramInt);
        paramParcel.writeParcelable(this.jFX, paramInt);
        paramParcel.writeLong(this.lJu);
        if (!this.lJv) {
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
    private int iEr;
    private long lJA;
    private com.tencent.mm.plugin.appbrand.jsapi.z.b lJB;
    private String lJC;
    private int lJD;
    private AppBrandLaunchErrorAction lJw;
    private AppBrandSysConfigWC lJx;
    private AppStartupPerformanceReportBundle lJy;
    private int lJz;
    
    static
    {
      AppMethodBeat.i(47106);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(47106);
    }
    
    PrepareResult()
    {
      this.lJD = 0;
    }
    
    PrepareResult(Parcel paramParcel)
    {
      AppMethodBeat.i(47105);
      this.lJD = 0;
      this.iEr = paramParcel.readInt();
      this.lJw = ((AppBrandLaunchErrorAction)paramParcel.readParcelable(AppBrandLaunchErrorAction.class.getClassLoader()));
      this.lJx = ((AppBrandSysConfigWC)paramParcel.readParcelable(AppBrandSysConfigWC.class.getClassLoader()));
      this.lJz = paramParcel.readInt();
      this.lJA = paramParcel.readLong();
      this.lJy = ((AppStartupPerformanceReportBundle)paramParcel.readParcelable(AppStartupPerformanceReportBundle.class.getClassLoader()));
      this.lJD = paramParcel.readInt();
      if (this.iEr == 5)
      {
        this.lJB = com.tencent.mm.plugin.appbrand.jsapi.z.b.Rl(paramParcel.readString());
        this.lJC = paramParcel.readString();
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
      ae.i("MicroMsg.AppBrandPrepareTask", "writeToParcel event[%d]", new Object[] { Integer.valueOf(this.iEr) });
      paramParcel.writeInt(this.iEr);
      paramParcel.writeParcelable(this.lJw, paramInt);
      paramParcel.writeParcelable(this.lJx, paramInt);
      paramParcel.writeInt(this.lJz);
      paramParcel.writeLong(this.lJA);
      paramParcel.writeParcelable(this.lJy, paramInt);
      paramParcel.writeInt(this.lJD);
      if (this.iEr == 5)
      {
        paramParcel.writeString(this.lJB.toString());
        paramParcel.writeString(this.lJC);
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
    
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.z.b paramb, String paramString);
    
    public abstract void aXJ();
    
    public abstract void aXK();
    
    public abstract void aXL();
    
    public abstract void rG(int paramInt);
    
    public abstract void sP(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask
 * JD-Core Version:    0.7.0.1
 */