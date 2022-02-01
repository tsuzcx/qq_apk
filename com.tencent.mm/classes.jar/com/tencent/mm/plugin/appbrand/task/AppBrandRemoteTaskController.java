package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR;
  private static long nPg;
  private static boolean nPl;
  int appType = 0;
  private transient k kCd = null;
  private transient f kDA = null;
  private String kIA;
  public String mAppId;
  int mDebugType;
  String mProcessName;
  private boolean nPb;
  private int nPc = -1;
  public a nPd = a.nPp;
  private int nPe;
  private long nPf;
  private g nPh = g.nPF;
  String nPi;
  private AppBrandInitConfigWC nPj;
  private transient boolean nPk = false;
  
  static
  {
    AppMethodBeat.i(48428);
    nPl = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48428);
  }
  
  private void afb(String paramString)
  {
    AppMethodBeat.i(227481);
    if (this.nPj != null)
    {
      if (com.tencent.mm.plugin.appbrand.config.h.bzT() == null) {
        break label105;
      }
      com.tencent.mm.plugin.appbrand.config.h.bzT().a(this.nPj.username, this.nPj);
    }
    while (!this.nPb)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, !mAttachedToUI, reason:%s, class:%s, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.kIA, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.nPc), this.nPi });
      AppMethodBeat.o(227481);
      return;
      label105:
      new IListener() {}.alive();
    }
    n localn = h.bWc().b(this.kIA, this.nPh);
    if (localn == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, task==null, reason:%s, class:%s appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.kIA, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.nPc), this.nPi });
      AppMethodBeat.o(227481);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, reason:%s, class:%s, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.kIA, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.nPc), this.nPi });
    localn.a(this.mAppId, this.mDebugType, this);
    localn.nPc = this.nPc;
    h.bWc().b(localn);
    h.bWb().a(this.mAppId, this);
    AppMethodBeat.o(227481);
  }
  
  private void afc(String paramString)
  {
    try
    {
      AppMethodBeat.i(48423);
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
      this.nPk = true;
      h.bWb().afe(paramString);
      this.nPk = false;
      AppMethodBeat.o(48423);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void bVU()
  {
    AppMethodBeat.i(48422);
    if (h.bWc().a(this.mAppId, this.kIA, this.nPh) == null)
    {
      h.bWb().a(this.mAppId, this);
      AppMethodBeat.o(48422);
      return;
    }
    h.bWc().afk(this.mAppId);
    AppMethodBeat.o(48422);
  }
  
  private void bVV()
  {
    AppMethodBeat.i(227482);
    this.kDA.vA(hashCode());
    AppMethodBeat.o(227482);
  }
  
  public final void M(q paramq)
  {
    AppMethodBeat.i(227477);
    this.mAppId = paramq.mAppId;
    this.mDebugType = paramq.kAq.eix;
    this.nPh = g.j(paramq.bsC());
    this.appType = (paramq.bsC().cyo + 1000);
    this.nPi = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(paramq.mAppId).kEY;
    ICommLibReader localICommLibReader = paramq.bqZ();
    if (localICommLibReader == null) {}
    for (int i = -1;; i = localICommLibReader.bvd())
    {
      this.nPc = i;
      this.nPj = paramq.bsC();
      AppMethodBeat.o(227477);
      return;
    }
  }
  
  public final void N(q paramq)
  {
    AppMethodBeat.i(227478);
    this.nPd = a.nPq;
    if (this.kCd != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.nPb = bool;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "registerForClientProcess appId:%s, type:%d, mAttachedToUI:%b, taskId:%s, stack:%s", new Object[] { paramq.mAppId, Integer.valueOf(paramq.kAq.eix), Boolean.valueOf(this.nPb), this.jEY, android.util.Log.getStackTraceString(new Throwable()) });
      M(paramq);
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(227478);
      return;
    }
  }
  
  public final void O(q paramq)
  {
    AppMethodBeat.i(227479);
    this.nPd = a.nPr;
    if (this.kCd != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.nPb = bool;
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "updateForClientProcess appId:%s, type:%d, mAttachedToUI:%b, taskId:%s, stack:%s", new Object[] { paramq.mAppId, Integer.valueOf(paramq.kAq.eix), Boolean.valueOf(this.nPb), this.jEY, android.util.Log.getStackTraceString(new Throwable()) });
      M(paramq);
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(227479);
      return;
    }
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(227476);
    this.mProcessName = MMApplicationContext.getProcessName();
    this.kIA = AppBrandPluginUI.class.getName();
    this.kDA = paramf;
    bDJ();
    AppMethodBeat.o(227476);
  }
  
  public final void a(k paramk, f paramf)
  {
    AppMethodBeat.i(48412);
    Activity localActivity = paramk.getActivity();
    this.mProcessName = MMApplicationContext.getProcessName();
    this.kIA = localActivity.getClass().getName();
    this.kCd = paramk;
    this.kDA = paramf;
    bDJ();
    AppMethodBeat.o(48412);
  }
  
  public final void aeZ(String paramString)
  {
    AppMethodBeat.i(48414);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "removeForClientProcess appId:%s, stack:%s", new Object[] { paramString, android.util.Log.getStackTraceString(new Throwable()) });
    this.nPd = a.nPs;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48414);
  }
  
  final void afa(String paramString)
  {
    AppMethodBeat.i(48417);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", new Object[] { paramString, Boolean.valueOf(this.nPk), android.util.Log.getStackTraceString(new Throwable()) });
    if (this.nPk)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
      AppMethodBeat.o(48417);
      return;
    }
    this.nPd = a.nPs;
    this.mAppId = paramString;
    bVU();
    bDU();
    AppMethodBeat.o(48417);
  }
  
  public final String aiv()
  {
    return this.nPi;
  }
  
  final boolean bVS()
  {
    AppMethodBeat.i(48419);
    this.nPd = a.nPw;
    boolean bool = bDU();
    AppMethodBeat.o(48419);
    return bool;
  }
  
  final void bVT()
  {
    AppMethodBeat.i(227480);
    this.nPd = a.nPx;
    bDU();
    AppMethodBeat.o(227480);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(48420);
    if (this.nPd == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRemoteTaskController", "runInMainProcess null==mOp");
      AppMethodBeat.o(48420);
      return;
    }
    switch (4.nPo[this.nPd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48420);
      return;
      afb("REGISTER");
      try
      {
        long l;
        if (nPg == 0L)
        {
          l = System.currentTimeMillis();
          nPg = l;
        }
        try
        {
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
          this.nPf = nPg;
          bDU();
          AppMethodBeat.o(48420);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "updateTimestamp(%d)", new Object[] { Long.valueOf(l) });
          }
        }
        afb("UPDATE");
      }
      finally
      {
        AppMethodBeat.o(48420);
      }
      AppMethodBeat.o(48420);
      return;
      bVU();
      AppMethodBeat.o(48420);
      return;
      h.bWb().zn(this.nPe);
      AppMethodBeat.o(48420);
      return;
      afc(this.mAppId);
      AppMethodBeat.o(48420);
      return;
      h.bWc().a(this.nPh, z.nMA, true);
      AppMethodBeat.o(48420);
      return;
      Object localObject2 = e.nIB;
      String str = this.mAppId;
      localObject2 = (e.a)((e)localObject2).nIC.get(str);
      if (localObject2 != null) {
        ((e.a)localObject2).nIE = Util.nowMilliSecond();
      }
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(48424);
    if (this.nPd == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRemoteTaskController", "runInClientProcess null==mOp");
      AppMethodBeat.o(48424);
      return;
    }
    switch (4.nPo[this.nPd.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48424);
      return;
      bVV();
      AppMethodBeat.o(48424);
      return;
      this.kDA.vB(hashCode());
      AppMethodBeat.o(48424);
      return;
      if (this.kCd == null) {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRemoteTaskController", "killImplByClientProcess mUIController==null, appId:%s, type:%d", new Object[] { this.mAppId, Integer.valueOf(this.mDebugType) });
      }
      switch (this.nPe)
      {
      case 1: 
      case 2: 
      default: 
        if (this.kCd != null)
        {
          this.kCd.a(new k.a()
          {
            public final void proceed()
            {
              AppMethodBeat.i(227473);
              AppBrandRemoteTaskController.a(AppBrandRemoteTaskController.this);
              AppMethodBeat.o(227473);
            }
          });
          AppMethodBeat.o(48424);
          return;
        }
        break;
      case 0: 
      case 3: 
        com.tencent.mm.modelappbrand.b.Lm(MMApplicationContext.getProcessName());
        if (this.kCd != null) {
          this.kCd.finish();
        }
        for (;;)
        {
          if (this.nPe == 0) {
            iC(true);
          }
          com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          Object localObject = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)locala.pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          AppMethodBeat.o(48424);
          return;
          bVV();
        }
      }
      bVV();
      AppMethodBeat.o(48424);
      return;
      Assert.assertTrue("AppBrand Test Assert", false);
      AppMethodBeat.o(48424);
      return;
      this.kDA.onNetworkChange(hashCode());
    }
  }
  
  public final int brf()
  {
    return this.mDebugType;
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(48426);
    this.mAppId = paramParcel.readString();
    this.mDebugType = paramParcel.readInt();
    this.kIA = paramParcel.readString();
    int i = paramParcel.readInt();
    Object localObject;
    if ((i == -1) || (i >= a.values().length))
    {
      localObject = null;
      this.nPd = ((a)localObject);
      this.nPe = paramParcel.readInt();
      this.nPf = paramParcel.readLong();
      i = paramParcel.readInt();
      if ((i != -1) && (i < g.values().length)) {
        break label181;
      }
      localObject = g.nPF;
      label96:
      this.nPh = ((g)localObject);
      this.nPi = paramParcel.readString();
      this.nPc = paramParcel.readInt();
      this.mProcessName = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label191;
      }
    }
    label181:
    label191:
    for (boolean bool = true;; bool = false)
    {
      this.nPb = bool;
      this.appType = paramParcel.readInt();
      this.nPj = ((AppBrandInitConfigWC)paramParcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader()));
      AppMethodBeat.o(48426);
      return;
      localObject = a.values()[i];
      break;
      localObject = g.values()[i];
      break label96;
    }
  }
  
  public final String getAppId()
  {
    return this.mAppId;
  }
  
  public final void hg(boolean paramBoolean)
  {
    AppMethodBeat.i(180368);
    if (!paramBoolean) {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRemoteTaskController", "onCallbackResult failed, mOp[%s], mAppId[%s], mClsName[%s]", new Object[] { this.nPd, this.mAppId, this.kIA });
    }
    AppMethodBeat.o(180368);
  }
  
  public final void iC(boolean paramBoolean)
  {
    AppMethodBeat.i(48416);
    if ((nPl) && (!paramBoolean))
    {
      AppMethodBeat.o(48416);
      return;
    }
    this.nPd = a.nPz;
    AppBrandMainProcessService.a(this);
    nPl = true;
    AppMethodBeat.o(48416);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(48425);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.mDebugType);
    paramParcel.writeString(this.kIA);
    if (this.nPd == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.nPe);
      paramParcel.writeLong(this.nPf);
      if (this.nPh != null) {
        break label150;
      }
      paramInt = i;
      label71:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.nPi);
      paramParcel.writeInt(this.nPc);
      paramParcel.writeString(this.mProcessName);
      if (!this.nPb) {
        break label161;
      }
    }
    label150:
    label161:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.appType);
      paramParcel.writeParcelable(this.nPj, 0);
      AppMethodBeat.o(48425);
      return;
      paramInt = this.nPd.ordinal();
      break;
      paramInt = this.nPh.ordinal();
      break label71;
    }
  }
  
  final void zl(int paramInt)
  {
    AppMethodBeat.i(48418);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRemoteTaskController", "killForMainProcess(%d), class[%s] appId[%s] debugType[%d]", new Object[] { Integer.valueOf(paramInt), this.kIA, this.mAppId, Integer.valueOf(this.mDebugType) });
    this.nPd = a.nPt;
    this.nPe = paramInt;
    bDU();
    AppMethodBeat.o(48418);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(48411);
      nPp = new a("NONE", 0);
      nPq = new a("REGISTER", 1);
      nPr = new a("UPDATE", 2);
      nPs = new a("REMOVE", 3);
      nPt = new a("KILL", 4);
      nPu = new a("KILL_ALL", 5);
      nPv = new a("ASSERT", 6);
      nPw = new a("CHECK_ALIVE", 7);
      nPx = new a("NETWORK_CHANGE", 8);
      nPy = new a("CLEAR_DUPLICATED", 9);
      nPz = new a("PRELOAD", 10);
      nPA = new a("NOTIFY_PAUSE", 11);
      nPB = new a("CLOSE", 12);
      nPC = new a[] { nPp, nPq, nPr, nPs, nPt, nPu, nPv, nPw, nPx, nPy, nPz, nPA, nPB };
      AppMethodBeat.o(48411);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */