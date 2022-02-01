package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR;
  private static long mCJ;
  private static boolean mCN;
  private g jBk = null;
  private d jCA = null;
  private String jGC;
  public String mAppId;
  private int mCE = -1;
  @Deprecated
  private long mCF = 0L;
  public a mCG = a.mCQ;
  private int mCH;
  private long mCI;
  private e mCK = e.mDg;
  String mCL;
  private transient boolean mCM = false;
  int mDebugType;
  
  static
  {
    AppMethodBeat.i(48428);
    mCN = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48428);
  }
  
  private void Vj(String paramString)
  {
    AppMethodBeat.i(222999);
    i locali = f.Vp(this.jGC);
    if (locali == null)
    {
      ae.e("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, task==null, reason:%s, class:%s appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.jGC, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.mCE), this.mCL });
      AppMethodBeat.o(222999);
      return;
    }
    ae.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, reason:%s, class:%s, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.jGC, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.mCE), this.mCL });
    locali.a(this.mAppId, this.mDebugType, this);
    locali.mCE = this.mCE;
    f.a(locali);
    f.a(this.mAppId, this);
    AppMethodBeat.o(222999);
  }
  
  private void Vk(String paramString)
  {
    try
    {
      AppMethodBeat.i(48423);
      ae.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
      this.mCM = true;
      f.Vl(paramString);
      this.mCM = false;
      AppMethodBeat.o(48423);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void bzx()
  {
    AppMethodBeat.i(48422);
    if (f.eq(this.mAppId, this.jGC) == null)
    {
      f.a(this.mAppId, this);
      AppMethodBeat.o(48422);
      return;
    }
    f.Vs(this.mAppId);
    AppMethodBeat.o(48422);
  }
  
  public final void Vh(String paramString)
  {
    AppMethodBeat.i(48414);
    this.mCG = a.mCT;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48414);
  }
  
  final void Vi(String paramString)
  {
    AppMethodBeat.i(48417);
    ae.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", new Object[] { paramString, Boolean.valueOf(this.mCM), Log.getStackTraceString(new Throwable()) });
    if (this.mCM)
    {
      ae.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
      AppMethodBeat.o(48417);
      return;
    }
    this.mCG = a.mCT;
    this.mAppId = paramString;
    bzx();
    biG();
    AppMethodBeat.o(48417);
  }
  
  public final void a(g paramg, d paramd)
  {
    AppMethodBeat.i(48412);
    this.jGC = paramg.getActivity().getClass().getName();
    this.jBk = paramg;
    this.jCA = paramd;
    AppMethodBeat.o(48412);
  }
  
  public final void a(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(48413);
    this.mCG = a.mCR;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.mCK = parame;
    this.mCL = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(paramString).lIU;
    paramString = com.tencent.mm.plugin.appbrand.a.KI(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label78;
      }
    }
    label78:
    for (paramInt = -1;; paramInt = paramString.aZM())
    {
      this.mCE = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(48413);
      return;
      paramString = paramString.aWe();
      break;
    }
  }
  
  public final void aOX()
  {
    AppMethodBeat.i(48420);
    switch (3.mCP[this.mCG.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48420);
      return;
      Vj("REGISTER");
      try
      {
        long l;
        if (mCJ == 0L)
        {
          l = System.currentTimeMillis();
          mCJ = l;
        }
        try
        {
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          ae.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
          this.mCI = mCJ;
          biG();
          AppMethodBeat.o(48420);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "updateTimestamp(%d)", new Object[] { Long.valueOf(l) });
          }
        }
        Vj("UPDATE");
      }
      finally
      {
        AppMethodBeat.o(48420);
      }
      AppMethodBeat.o(48420);
      return;
      bzx();
      AppMethodBeat.o(48420);
      return;
      f.vz(this.mCH);
      AppMethodBeat.o(48420);
      return;
      Vk(this.mAppId);
      AppMethodBeat.o(48420);
      return;
      f.a(this.mCK, true);
      AppMethodBeat.o(48420);
      return;
      Object localObject2 = com.tencent.mm.plugin.appbrand.report.model.e.mxx;
      String str = this.mAppId;
      localObject2 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject2).mxy.get(str);
      if (localObject2 != null) {
        ((e.a)localObject2).mxA = bu.fpO();
      }
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(48424);
    switch (3.mCP[this.mCG.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48424);
      return;
      this.jCA.rH(hashCode());
      AppMethodBeat.o(48424);
      return;
      switch (this.mCH)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(48424);
        return;
        b.CB(ak.getProcessName());
        this.jBk.finish();
        if (this.mCH == 0) {
          hA(true);
        }
        com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(48424);
        return;
        this.jBk.a(new g.a()
        {
          public final void proceed()
          {
            AppMethodBeat.i(48406);
            AppBrandRemoteTaskController.a(AppBrandRemoteTaskController.this);
            AppMethodBeat.o(48406);
          }
        });
      }
      Assert.assertTrue("AppBrand Test Assert", false);
      AppMethodBeat.o(48424);
      return;
      this.jCA.onNetworkChange(hashCode());
    }
  }
  
  final boolean bzw()
  {
    AppMethodBeat.i(48419);
    this.mCG = a.mCX;
    boolean bool = biG();
    AppMethodBeat.o(48419);
    return bool;
  }
  
  public final void ca(String paramString, int paramInt)
  {
    AppMethodBeat.i(222998);
    this.mCG = a.mCS;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.mCL = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(paramString).lIU;
    paramString = com.tencent.mm.plugin.appbrand.a.KI(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label75;
      }
    }
    label75:
    for (paramInt = -1;; paramInt = paramString.aZM())
    {
      this.mCE = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(222998);
      return;
      paramString = paramString.aWe();
      break;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    Object localObject2 = null;
    AppMethodBeat.i(48426);
    this.mAppId = paramParcel.readString();
    this.mDebugType = paramParcel.readInt();
    this.jGC = paramParcel.readString();
    this.mCF = paramParcel.readLong();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      localObject1 = null;
      this.mCG = ((a)localObject1);
      this.mCH = paramParcel.readInt();
      this.mCI = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i != -1) {
        break label124;
      }
    }
    label124:
    for (Object localObject1 = localObject2;; localObject1 = e.values()[i])
    {
      this.mCK = ((e)localObject1);
      this.mCL = paramParcel.readString();
      this.mCE = paramParcel.readInt();
      AppMethodBeat.o(48426);
      return;
      localObject1 = a.values()[i];
      break;
    }
  }
  
  public final void gj(boolean paramBoolean)
  {
    AppMethodBeat.i(180368);
    if (!paramBoolean) {
      ae.e("MicroMsg.AppBrandRemoteTaskController", "onCallbackResult failed, mOp[%s], mAppId[%s], mClsName[%s]", new Object[] { this.mCG, this.mAppId, this.jGC });
    }
    AppMethodBeat.o(180368);
  }
  
  public final void hA(boolean paramBoolean)
  {
    AppMethodBeat.i(48416);
    if ((mCN) && (!paramBoolean))
    {
      AppMethodBeat.o(48416);
      return;
    }
    this.mCG = a.mDa;
    AppBrandMainProcessService.a(this);
    mCN = true;
    AppMethodBeat.o(48416);
  }
  
  final void vx(int paramInt)
  {
    AppMethodBeat.i(48418);
    ae.i("MicroMsg.AppBrandRemoteTaskController", "killForMainProcess(%d), class[%s] appId[%s] debugType[%d]", new Object[] { Integer.valueOf(paramInt), this.jGC, this.mAppId, Integer.valueOf(this.mDebugType) });
    this.mCG = a.mCU;
    this.mCH = paramInt;
    biG();
    AppMethodBeat.o(48418);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(48425);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.mDebugType);
    paramParcel.writeString(this.jGC);
    paramParcel.writeLong(this.mCF);
    if (this.mCG == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mCH);
      paramParcel.writeLong(this.mCI);
      if (this.mCK != null) {
        break label118;
      }
    }
    label118:
    for (paramInt = i;; paramInt = this.mCK.ordinal())
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mCL);
      paramParcel.writeInt(this.mCE);
      AppMethodBeat.o(48425);
      return;
      paramInt = this.mCG.ordinal();
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(48411);
      mCQ = new a("NONE", 0);
      mCR = new a("REGISTER", 1);
      mCS = new a("UPDATE", 2);
      mCT = new a("REMOVE", 3);
      mCU = new a("KILL", 4);
      mCV = new a("KILL_ALL", 5);
      mCW = new a("ASSERT", 6);
      mCX = new a("CHECK_ALIVE", 7);
      mCY = new a("NETWORK_CHANGE", 8);
      mCZ = new a("CLEAR_DUPLICATED", 9);
      mDa = new a("PRELOAD", 10);
      mDc = new a("NOTIFY_PAUSE", 11);
      mDd = new a[] { mCQ, mCR, mCS, mCT, mCU, mCV, mCW, mCX, mCY, mCZ, mDa, mDc };
      AppMethodBeat.o(48411);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */