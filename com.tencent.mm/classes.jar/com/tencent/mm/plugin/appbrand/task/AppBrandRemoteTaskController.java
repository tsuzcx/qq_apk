package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR;
  private static long lXX;
  private static boolean lYb;
  private g jfc = null;
  private d jgz = null;
  private String jjP;
  private int lXS = -1;
  @Deprecated
  private long lXT = 0L;
  public a lXU = a.lYe;
  private int lXV;
  private long lXW;
  private e lXY = e.lYt;
  String lXZ;
  private transient boolean lYa = false;
  String mAppId;
  int mDebugType;
  
  static
  {
    AppMethodBeat.i(48428);
    lYb = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48428);
  }
  
  private void QS(String paramString)
  {
    try
    {
      AppMethodBeat.i(48423);
      ac.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
      this.lYa = true;
      f.QT(paramString);
      this.lYa = false;
      AppMethodBeat.o(48423);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void buy()
  {
    AppMethodBeat.i(48421);
    i locali = f.QY(this.jjP);
    if (locali == null)
    {
      AppMethodBeat.o(48421);
      return;
    }
    ac.i("MicroMsg.AppBrandRemoteTaskController", "updateImplByMainProcess, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.lXS), this.lXZ });
    locali.a(this.mAppId, this.mDebugType, this);
    locali.lXS = this.lXS;
    f.a(locali);
    f.a(this.mAppId, this);
    AppMethodBeat.o(48421);
  }
  
  private void buz()
  {
    AppMethodBeat.i(48422);
    if (f.ee(this.mAppId, this.jjP) == null)
    {
      f.a(this.mAppId, this);
      AppMethodBeat.o(48422);
      return;
    }
    f.Rb(this.mAppId);
    AppMethodBeat.o(48422);
  }
  
  public final void QP(String paramString)
  {
    AppMethodBeat.i(48414);
    this.lXU = a.lYh;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48414);
  }
  
  public final void QQ(String paramString)
  {
    AppMethodBeat.i(48415);
    this.lXU = a.lYn;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48415);
  }
  
  final void QR(String paramString)
  {
    AppMethodBeat.i(48417);
    ac.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", new Object[] { paramString, Boolean.valueOf(this.lYa), Log.getStackTraceString(new Throwable()) });
    if (this.lYa)
    {
      ac.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
      AppMethodBeat.o(48417);
      return;
    }
    this.lXU = a.lYh;
    this.mAppId = paramString;
    buz();
    bet();
    AppMethodBeat.o(48417);
  }
  
  public final void a(g paramg, d paramd)
  {
    AppMethodBeat.i(48412);
    this.jjP = paramg.getActivity().getClass().getName();
    this.jfc = paramg;
    this.jgz = paramd;
    AppMethodBeat.o(48412);
  }
  
  public final void a(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(48413);
    this.lXU = a.lYf;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.lXY = parame;
    this.lXZ = com.tencent.mm.plugin.appbrand.report.quality.a.QN(paramString).lht;
    paramString = com.tencent.mm.plugin.appbrand.a.GU(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label78;
      }
    }
    label78:
    for (paramInt = -1;; paramInt = paramString.aVU())
    {
      this.lXS = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(48413);
      return;
      paramString = paramString.aSt();
      break;
    }
  }
  
  public final void aLq()
  {
    AppMethodBeat.i(48420);
    switch (3.lYd[this.lXU.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48420);
      return;
      ac.i("MicroMsg.AppBrandRemoteTaskController", "registerImplByMainProcess, appId:%s, versionType:%d, usedCommLibVersion:%d, instanceId:%s", new Object[] { this.mAppId, Integer.valueOf(this.mDebugType), Integer.valueOf(this.lXS), this.lXZ });
      buy();
      try
      {
        long l;
        if (lXX == 0L)
        {
          l = System.currentTimeMillis();
          lXX = l;
        }
        try
        {
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          ac.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
          this.lXW = lXX;
          bet();
          AppMethodBeat.o(48420);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "updateTimestamp(%d)", new Object[] { Long.valueOf(l) });
          }
        }
        buy();
      }
      finally
      {
        AppMethodBeat.o(48420);
      }
      AppMethodBeat.o(48420);
      return;
      buz();
      AppMethodBeat.o(48420);
      return;
      f.uP(this.lXV);
      AppMethodBeat.o(48420);
      return;
      QS(this.mAppId);
      AppMethodBeat.o(48420);
      return;
      f.a(this.lXY, true);
      AppMethodBeat.o(48420);
      return;
      Object localObject2 = com.tencent.mm.plugin.appbrand.report.model.e.lSJ;
      String str = this.mAppId;
      localObject2 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject2).lSK.get(str);
      if (localObject2 != null) {
        ((e.a)localObject2).lSM = bs.eWj();
      }
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(48424);
    switch (3.lYd[this.lXU.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48424);
      return;
      this.jgz.re(hashCode());
      AppMethodBeat.o(48424);
      return;
      switch (this.lXV)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(48424);
        return;
        b.za(ai.getProcessName());
        this.jfc.finish();
        if (this.lXV == 0) {
          hs(true);
        }
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(48424);
        return;
        this.jfc.a(new g.a()
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
      this.jgz.onNetworkChange(hashCode());
    }
  }
  
  public final void bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(186973);
    this.lXU = a.lYg;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.lXZ = com.tencent.mm.plugin.appbrand.report.quality.a.QN(paramString).lht;
    paramString = com.tencent.mm.plugin.appbrand.a.GU(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label75;
      }
    }
    label75:
    for (paramInt = -1;; paramInt = paramString.aVU())
    {
      this.lXS = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(186973);
      return;
      paramString = paramString.aSt();
      break;
    }
  }
  
  final boolean bux()
  {
    AppMethodBeat.i(48419);
    this.lXU = a.lYl;
    boolean bool = bet();
    AppMethodBeat.o(48419);
    return bool;
  }
  
  public final void e(Parcel paramParcel)
  {
    Object localObject2 = null;
    AppMethodBeat.i(48426);
    this.mAppId = paramParcel.readString();
    this.mDebugType = paramParcel.readInt();
    this.jjP = paramParcel.readString();
    this.lXT = paramParcel.readLong();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      localObject1 = null;
      this.lXU = ((a)localObject1);
      this.lXV = paramParcel.readInt();
      this.lXW = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i != -1) {
        break label124;
      }
    }
    label124:
    for (Object localObject1 = localObject2;; localObject1 = e.values()[i])
    {
      this.lXY = ((e)localObject1);
      this.lXZ = paramParcel.readString();
      this.lXS = paramParcel.readInt();
      AppMethodBeat.o(48426);
      return;
      localObject1 = a.values()[i];
      break;
    }
  }
  
  public final void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(180368);
    if (!paramBoolean) {
      ac.e("MicroMsg.AppBrandRemoteTaskController", "onCallbackResult failed, mOp[%s], mAppId[%s], mClsName[%s]", new Object[] { this.lXU, this.mAppId, this.jjP });
    }
    AppMethodBeat.o(180368);
  }
  
  public final void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(48416);
    if ((lYb) && (!paramBoolean))
    {
      AppMethodBeat.o(48416);
      return;
    }
    this.lXU = a.lYo;
    AppBrandMainProcessService.a(this);
    lYb = true;
    AppMethodBeat.o(48416);
  }
  
  final void uO(int paramInt)
  {
    AppMethodBeat.i(48418);
    ac.i("MicroMsg.AppBrandRemoteTaskController", "killForMainProcess(%d), class[%s] appId[%s] debugType[%d]", new Object[] { Integer.valueOf(paramInt), this.jjP, this.mAppId, Integer.valueOf(this.mDebugType) });
    this.lXU = a.lYi;
    this.lXV = paramInt;
    bet();
    AppMethodBeat.o(48418);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(48425);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.mDebugType);
    paramParcel.writeString(this.jjP);
    paramParcel.writeLong(this.lXT);
    if (this.lXU == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.lXV);
      paramParcel.writeLong(this.lXW);
      if (this.lXY != null) {
        break label118;
      }
    }
    label118:
    for (paramInt = i;; paramInt = this.lXY.ordinal())
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.lXZ);
      paramParcel.writeInt(this.lXS);
      AppMethodBeat.o(48425);
      return;
      paramInt = this.lXU.ordinal();
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(48411);
      lYe = new a("NONE", 0);
      lYf = new a("REGISTER", 1);
      lYg = new a("UPDATE", 2);
      lYh = new a("REMOVE", 3);
      lYi = new a("KILL", 4);
      lYj = new a("KILL_ALL", 5);
      lYk = new a("ASSERT", 6);
      lYl = new a("CHECK_ALIVE", 7);
      lYm = new a("NETWORK_CHANGE", 8);
      lYn = new a("CLEAR_DUPLICATED", 9);
      lYo = new a("PRELOAD", 10);
      lYp = new a("NOTIFY_PAUSE", 11);
      lYq = new a[] { lYe, lYf, lYg, lYh, lYi, lYj, lYk, lYl, lYm, lYn, lYo, lYp };
      AppMethodBeat.o(48411);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */