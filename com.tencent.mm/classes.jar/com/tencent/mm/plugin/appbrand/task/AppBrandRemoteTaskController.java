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
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR;
  private static long mxM;
  private static boolean mxQ;
  private String jDE;
  private g jyj = null;
  private d jzy = null;
  public String mAppId;
  int mDebugType;
  private int mxH = -1;
  @Deprecated
  private long mxI = 0L;
  public a mxJ = a.mxT;
  private int mxK;
  private long mxL;
  private e mxN = e.myi;
  String mxO;
  private transient boolean mxP = false;
  
  static
  {
    AppMethodBeat.i(48428);
    mxQ = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48428);
  }
  
  private void Uy(String paramString)
  {
    AppMethodBeat.i(188779);
    i locali = f.UE(this.jDE);
    if (locali == null)
    {
      ad.e("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, task==null, reason:%s, class:%s appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.jDE, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.mxH), this.mxO });
      AppMethodBeat.o(188779);
      return;
    }
    ad.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, reason:%s, class:%s, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { paramString, this.jDE, this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.mxH), this.mxO });
    locali.a(this.mAppId, this.mDebugType, this);
    locali.mxH = this.mxH;
    f.a(locali);
    f.a(this.mAppId, this);
    AppMethodBeat.o(188779);
  }
  
  private void Uz(String paramString)
  {
    try
    {
      AppMethodBeat.i(48423);
      ad.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
      this.mxP = true;
      f.UA(paramString);
      this.mxP = false;
      AppMethodBeat.o(48423);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void byD()
  {
    AppMethodBeat.i(48422);
    if (f.en(this.mAppId, this.jDE) == null)
    {
      f.a(this.mAppId, this);
      AppMethodBeat.o(48422);
      return;
    }
    f.UH(this.mAppId);
    AppMethodBeat.o(48422);
  }
  
  public final void Uw(String paramString)
  {
    AppMethodBeat.i(48414);
    this.mxJ = a.mxW;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48414);
  }
  
  final void Ux(String paramString)
  {
    AppMethodBeat.i(48417);
    ad.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", new Object[] { paramString, Boolean.valueOf(this.mxP), Log.getStackTraceString(new Throwable()) });
    if (this.mxP)
    {
      ad.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
      AppMethodBeat.o(48417);
      return;
    }
    this.mxJ = a.mxW;
    this.mAppId = paramString;
    byD();
    bhX();
    AppMethodBeat.o(48417);
  }
  
  public final void a(g paramg, d paramd)
  {
    AppMethodBeat.i(48412);
    this.jDE = paramg.getActivity().getClass().getName();
    this.jyj = paramg;
    this.jzy = paramd;
    AppMethodBeat.o(48412);
  }
  
  public final void a(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(48413);
    this.mxJ = a.mxU;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.mxN = parame;
    this.mxO = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(paramString).lEv;
    paramString = com.tencent.mm.plugin.appbrand.a.Kj(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label78;
      }
    }
    label78:
    for (paramInt = -1;; paramInt = paramString.aZp())
    {
      this.mxH = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(48413);
      return;
      paramString = paramString.aVF();
      break;
    }
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(48420);
    switch (3.mxS[this.mxJ.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48420);
      return;
      Uy("REGISTER");
      try
      {
        long l;
        if (mxM == 0L)
        {
          l = System.currentTimeMillis();
          mxM = l;
        }
        try
        {
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          ad.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
          this.mxL = mxM;
          bhX();
          AppMethodBeat.o(48420);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "updateTimestamp(%d)", new Object[] { Long.valueOf(l) });
          }
        }
        Uy("UPDATE");
      }
      finally
      {
        AppMethodBeat.o(48420);
      }
      AppMethodBeat.o(48420);
      return;
      byD();
      AppMethodBeat.o(48420);
      return;
      f.vu(this.mxK);
      AppMethodBeat.o(48420);
      return;
      Uz(this.mAppId);
      AppMethodBeat.o(48420);
      return;
      f.a(this.mxN, true);
      AppMethodBeat.o(48420);
      return;
      Object localObject2 = com.tencent.mm.plugin.appbrand.report.model.e.msA;
      String str = this.mAppId;
      localObject2 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject2).msB.get(str);
      if (localObject2 != null) {
        ((e.a)localObject2).msD = bt.flT();
      }
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(48424);
    switch (3.mxS[this.mxJ.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48424);
      return;
      this.jzy.rE(hashCode());
      AppMethodBeat.o(48424);
      return;
      switch (this.mxK)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(48424);
        return;
        b.BZ(aj.getProcessName());
        this.jyj.finish();
        if (this.mxK == 0) {
          hz(true);
        }
        com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/task/AppBrandRemoteTaskController", "killImplByClientProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(48424);
        return;
        this.jyj.a(new g.a()
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
      this.jzy.onNetworkChange(hashCode());
    }
  }
  
  public final void bW(String paramString, int paramInt)
  {
    AppMethodBeat.i(188778);
    this.mxJ = a.mxV;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.mxO = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(paramString).lEv;
    paramString = com.tencent.mm.plugin.appbrand.a.Kj(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label75;
      }
    }
    label75:
    for (paramInt = -1;; paramInt = paramString.aZp())
    {
      this.mxH = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(188778);
      return;
      paramString = paramString.aVF();
      break;
    }
  }
  
  final boolean byC()
  {
    AppMethodBeat.i(48419);
    this.mxJ = a.mya;
    boolean bool = bhX();
    AppMethodBeat.o(48419);
    return bool;
  }
  
  public final void e(Parcel paramParcel)
  {
    Object localObject2 = null;
    AppMethodBeat.i(48426);
    this.mAppId = paramParcel.readString();
    this.mDebugType = paramParcel.readInt();
    this.jDE = paramParcel.readString();
    this.mxI = paramParcel.readLong();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      localObject1 = null;
      this.mxJ = ((a)localObject1);
      this.mxK = paramParcel.readInt();
      this.mxL = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i != -1) {
        break label124;
      }
    }
    label124:
    for (Object localObject1 = localObject2;; localObject1 = e.values()[i])
    {
      this.mxN = ((e)localObject1);
      this.mxO = paramParcel.readString();
      this.mxH = paramParcel.readInt();
      AppMethodBeat.o(48426);
      return;
      localObject1 = a.values()[i];
      break;
    }
  }
  
  public final void gl(boolean paramBoolean)
  {
    AppMethodBeat.i(180368);
    if (!paramBoolean) {
      ad.e("MicroMsg.AppBrandRemoteTaskController", "onCallbackResult failed, mOp[%s], mAppId[%s], mClsName[%s]", new Object[] { this.mxJ, this.mAppId, this.jDE });
    }
    AppMethodBeat.o(180368);
  }
  
  public final void hz(boolean paramBoolean)
  {
    AppMethodBeat.i(48416);
    if ((mxQ) && (!paramBoolean))
    {
      AppMethodBeat.o(48416);
      return;
    }
    this.mxJ = a.myd;
    AppBrandMainProcessService.a(this);
    mxQ = true;
    AppMethodBeat.o(48416);
  }
  
  final void vs(int paramInt)
  {
    AppMethodBeat.i(48418);
    ad.i("MicroMsg.AppBrandRemoteTaskController", "killForMainProcess(%d), class[%s] appId[%s] debugType[%d]", new Object[] { Integer.valueOf(paramInt), this.jDE, this.mAppId, Integer.valueOf(this.mDebugType) });
    this.mxJ = a.mxX;
    this.mxK = paramInt;
    bhX();
    AppMethodBeat.o(48418);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(48425);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.mDebugType);
    paramParcel.writeString(this.jDE);
    paramParcel.writeLong(this.mxI);
    if (this.mxJ == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.mxK);
      paramParcel.writeLong(this.mxL);
      if (this.mxN != null) {
        break label118;
      }
    }
    label118:
    for (paramInt = i;; paramInt = this.mxN.ordinal())
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.mxO);
      paramParcel.writeInt(this.mxH);
      AppMethodBeat.o(48425);
      return;
      paramInt = this.mxJ.ordinal();
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(48411);
      mxT = new a("NONE", 0);
      mxU = new a("REGISTER", 1);
      mxV = new a("UPDATE", 2);
      mxW = new a("REMOVE", 3);
      mxX = new a("KILL", 4);
      mxY = new a("KILL_ALL", 5);
      mxZ = new a("ASSERT", 6);
      mya = new a("CHECK_ALIVE", 7);
      myb = new a("NETWORK_CHANGE", 8);
      myc = new a("CLEAR_DUPLICATED", 9);
      myd = new a("PRELOAD", 10);
      mye = new a("NOTIFY_PAUSE", 11);
      myf = new a[] { mxT, mxU, mxV, mxW, mxX, mxY, mxZ, mya, myb, myc, myd, mye };
      AppMethodBeat.o(48411);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */