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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR;
  private static long lwd;
  private static boolean lwh;
  private g iFa = null;
  private d iGx = null;
  private String iJJ;
  public int lvY = -1;
  @Deprecated
  private long lvZ = 0L;
  public a lwa = a.lwk;
  private int lwb;
  private long lwc;
  private e lwe = e.lwz;
  public String lwf;
  private transient boolean lwg = false;
  public String mAppId;
  public int mDebugType;
  
  static
  {
    AppMethodBeat.i(48428);
    lwh = false;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(48428);
  }
  
  private void MJ(String paramString)
  {
    try
    {
      AppMethodBeat.i(48423);
      ad.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
      this.lwg = true;
      f.MK(paramString);
      this.lwg = false;
      AppMethodBeat.o(48423);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void bnC()
  {
    AppMethodBeat.i(48421);
    i locali = f.MP(this.iJJ);
    if (locali == null)
    {
      AppMethodBeat.o(48421);
      return;
    }
    locali.a(this.mAppId, this.mDebugType, this);
    locali.lvY = this.lvY;
    f.a(locali);
    f.a(this.mAppId, this);
    AppMethodBeat.o(48421);
  }
  
  private void bnD()
  {
    AppMethodBeat.i(48422);
    if (f.dS(this.mAppId, this.iJJ) == null)
    {
      f.a(this.mAppId, this);
      AppMethodBeat.o(48422);
      return;
    }
    f.MS(this.mAppId);
    AppMethodBeat.o(48422);
  }
  
  public final void MG(String paramString)
  {
    AppMethodBeat.i(48414);
    this.lwa = a.lwn;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48414);
  }
  
  public final void MH(String paramString)
  {
    AppMethodBeat.i(48415);
    this.lwa = a.lwt;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(48415);
  }
  
  final void MI(String paramString)
  {
    AppMethodBeat.i(48417);
    ad.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", new Object[] { paramString, Boolean.valueOf(this.lwg), Log.getStackTraceString(new Throwable()) });
    if (this.lwg)
    {
      ad.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
      AppMethodBeat.o(48417);
      return;
    }
    this.lwa = a.lwn;
    this.mAppId = paramString;
    bnD();
    aXw();
    AppMethodBeat.o(48417);
  }
  
  public final void a(g paramg, d paramd)
  {
    AppMethodBeat.i(48412);
    this.iJJ = paramg.getActivity().getClass().getName();
    this.iFa = paramg;
    this.iGx = paramd;
    AppMethodBeat.o(48412);
  }
  
  public final void a(String paramString, int paramInt, e parame)
  {
    AppMethodBeat.i(48413);
    this.lwa = a.lwl;
    this.mAppId = paramString;
    this.mDebugType = paramInt;
    this.lwe = parame;
    this.lwf = com.tencent.mm.plugin.appbrand.report.quality.a.ME(paramString).kGa;
    paramString = com.tencent.mm.plugin.appbrand.a.CR(paramString);
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label78;
      }
    }
    label78:
    for (paramInt = -1;; paramInt = paramString.aPc())
    {
      this.lvY = paramInt;
      AppBrandMainProcessService.a(this);
      AppMethodBeat.o(48413);
      return;
      paramString = paramString.aLC();
      break;
    }
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(48424);
    switch (3.lwj[this.lwa.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48424);
      return;
      this.iGx.qr(hashCode());
      AppMethodBeat.o(48424);
      return;
      switch (this.lwb)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(48424);
        return;
        b.uU(aj.getProcessName());
        this.iFa.finish();
        if (this.lwb == 0) {
          gV(true);
        }
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(48424);
        return;
        this.iFa.a(new g.a()
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
      this.iGx.onNetworkChange(hashCode());
    }
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(48420);
    switch (3.lwj[this.lwa.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48420);
      return;
      bnC();
      try
      {
        long l;
        if (lwd == 0L)
        {
          l = System.currentTimeMillis();
          lwd = l;
        }
        try
        {
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          ad.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
          this.lwc = lwd;
          aXw();
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
        bnC();
      }
      finally
      {
        AppMethodBeat.o(48420);
      }
      AppMethodBeat.o(48420);
      return;
      bnD();
      AppMethodBeat.o(48420);
      return;
      f.tX(this.lwb);
      AppMethodBeat.o(48420);
      return;
      MJ(this.mAppId);
      AppMethodBeat.o(48420);
      return;
      f.a(this.lwe, true);
      AppMethodBeat.o(48420);
      return;
      Object localObject2 = com.tencent.mm.plugin.appbrand.report.model.e.lqO;
      String str = this.mAppId;
      localObject2 = (e.a)((com.tencent.mm.plugin.appbrand.report.model.e)localObject2).lqP.get(str);
      if (localObject2 != null) {
        ((e.a)localObject2).lqR = bt.eGO();
      }
    }
  }
  
  final boolean bnB()
  {
    AppMethodBeat.i(48419);
    this.lwa = a.lwr;
    boolean bool = aXw();
    AppMethodBeat.o(48419);
    return bool;
  }
  
  public final void e(Parcel paramParcel)
  {
    Object localObject2 = null;
    AppMethodBeat.i(48426);
    this.mAppId = paramParcel.readString();
    this.mDebugType = paramParcel.readInt();
    this.iJJ = paramParcel.readString();
    this.lvZ = paramParcel.readLong();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      localObject1 = null;
      this.lwa = ((a)localObject1);
      this.lwb = paramParcel.readInt();
      this.lwc = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i != -1) {
        break label124;
      }
    }
    label124:
    for (Object localObject1 = localObject2;; localObject1 = e.values()[i])
    {
      this.lwe = ((e)localObject1);
      this.lwf = paramParcel.readString();
      this.lvY = paramParcel.readInt();
      AppMethodBeat.o(48426);
      return;
      localObject1 = a.values()[i];
      break;
    }
  }
  
  public final void fK(boolean paramBoolean)
  {
    AppMethodBeat.i(180368);
    if (!paramBoolean) {
      ad.e("MicroMsg.AppBrandRemoteTaskController", "onCallbackResult failed, mOp[%s], mAppId[%s], mClsName[%s]", new Object[] { this.lwa, this.mAppId, this.iJJ });
    }
    AppMethodBeat.o(180368);
  }
  
  public final void gV(boolean paramBoolean)
  {
    AppMethodBeat.i(48416);
    if ((lwh) && (!paramBoolean))
    {
      AppMethodBeat.o(48416);
      return;
    }
    this.lwa = a.lwu;
    AppBrandMainProcessService.a(this);
    lwh = true;
    AppMethodBeat.o(48416);
  }
  
  final void tW(int paramInt)
  {
    AppMethodBeat.i(48418);
    ad.i("MicroMsg.AppBrandRemoteTaskController", "killForMainProcess(%d), class[%s] appId[%s] debugType[%d]", new Object[] { Integer.valueOf(paramInt), this.iJJ, this.mAppId, Integer.valueOf(this.mDebugType) });
    this.lwa = a.lwo;
    this.lwb = paramInt;
    aXw();
    AppMethodBeat.o(48418);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(48425);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.mDebugType);
    paramParcel.writeString(this.iJJ);
    paramParcel.writeLong(this.lvZ);
    if (this.lwa == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.lwb);
      paramParcel.writeLong(this.lwc);
      if (this.lwe != null) {
        break label118;
      }
    }
    label118:
    for (paramInt = i;; paramInt = this.lwe.ordinal())
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.lwf);
      paramParcel.writeInt(this.lvY);
      AppMethodBeat.o(48425);
      return;
      paramInt = this.lwa.ordinal();
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(48411);
      lwk = new a("NONE", 0);
      lwl = new a("REGISTER", 1);
      lwm = new a("UPDATE", 2);
      lwn = new a("REMOVE", 3);
      lwo = new a("KILL", 4);
      lwp = new a("KILL_ALL", 5);
      lwq = new a("ASSERT", 6);
      lwr = new a("CHECK_ALIVE", 7);
      lws = new a("NETWORK_CHANGE", 8);
      lwt = new a("CLEAR_DUPLICATED", 9);
      lwu = new a("PRELOAD", 10);
      lwv = new a("NOTIFY_PAUSE", 11);
      lww = new a[] { lwk, lwl, lwm, lwn, lwo, lwp, lwq, lwr, lws, lwt, lwu, lwv };
      AppMethodBeat.o(48411);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */