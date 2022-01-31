package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.model.e.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR;
  public static boolean iKC;
  private static long iKy;
  private i gQB = null;
  private f gRu = null;
  private String gSG;
  String iKA;
  private transient boolean iKB = false;
  private long iKv;
  public AppBrandRemoteTaskController.a iKw = AppBrandRemoteTaskController.a.iKF;
  int iKx;
  private g iKz = g.iKU;
  public int ikk;
  public String mAppId;
  private long mTimestamp;
  
  static
  {
    AppMethodBeat.i(132841);
    iKC = false;
    CREATOR = new AppBrandRemoteTaskController.3();
    AppMethodBeat.o(132841);
  }
  
  private void ET(String paramString)
  {
    try
    {
      AppMethodBeat.i(143577);
      ab.i("MicroMsg.AppBrandRemoteTaskController", "clearDuplicatedImplByMainProcess");
      this.iKB = true;
      h.EU(paramString);
      this.iKB = false;
      AppMethodBeat.o(143577);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void aLR()
  {
    AppMethodBeat.i(132835);
    j localj;
    Object localObject;
    if (this.gSG.endsWith(".AppBrandEmbedUI"))
    {
      localj = h.a(new AppBrandRemoteTaskController.1(this));
      localObject = localj;
      if (localj == null) {
        localObject = new a(this.iKv);
      }
    }
    do
    {
      ((j)localObject).a(this.mAppId, this.ikk, this);
      h.b((j)localObject);
      h.a(this.mAppId, this);
      AppMethodBeat.o(132835);
      return;
      localj = h.EY(this.gSG);
      localObject = localj;
    } while (localj != null);
    AppMethodBeat.o(132835);
  }
  
  private void aLS()
  {
    AppMethodBeat.i(132836);
    if (h.cS(this.mAppId, this.gSG) == null)
    {
      h.a(this.mAppId, this);
      AppMethodBeat.o(132836);
      return;
    }
    h.EN(this.mAppId);
    AppMethodBeat.o(132836);
  }
  
  public final void EQ(String paramString)
  {
    AppMethodBeat.i(143576);
    this.iKw = AppBrandRemoteTaskController.a.iKI;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(143576);
  }
  
  public final void ER(String paramString)
  {
    AppMethodBeat.i(132831);
    this.iKw = AppBrandRemoteTaskController.a.iKO;
    this.mAppId = paramString;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(132831);
  }
  
  final void ES(String paramString)
  {
    AppMethodBeat.i(132832);
    ab.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess appId[%s] mIgnoreRemovalForMainProcessOnce[%b], stack = %s", new Object[] { paramString, Boolean.valueOf(this.iKB), Log.getStackTraceString(new Throwable()) });
    if (this.iKB)
    {
      ab.i("MicroMsg.AppBrandRemoteTaskController", "removeForMainProcess, ignore once");
      AppMethodBeat.o(132832);
      return;
    }
    this.iKw = AppBrandRemoteTaskController.a.iKI;
    this.mAppId = paramString;
    aLS();
    aBp();
    AppMethodBeat.o(132832);
  }
  
  public final void a(i parami, f paramf)
  {
    AppMethodBeat.i(143575);
    Activity localActivity = parami.getContext();
    this.gSG = localActivity.getClass().getName();
    if ((localActivity instanceof AppBrandEmbedUI)) {
      this.iKv = ((AppBrandEmbedUI)localActivity).iLR;
    }
    this.gQB = parami;
    this.gRu = paramf;
    AppMethodBeat.o(143575);
  }
  
  public final void a(String paramString, int paramInt, g paramg)
  {
    AppMethodBeat.i(132830);
    this.iKw = AppBrandRemoteTaskController.a.iKG;
    this.mAppId = paramString;
    this.ikk = paramInt;
    this.iKz = paramg;
    this.iKA = com.tencent.mm.plugin.appbrand.report.quality.a.EM(paramString).ikX;
    AppBrandMainProcessService.a(this);
    AppMethodBeat.o(132830);
  }
  
  final boolean aLQ()
  {
    AppMethodBeat.i(132833);
    this.iKw = AppBrandRemoteTaskController.a.iKM;
    boolean bool = aBp();
    AppMethodBeat.o(132833);
    return bool;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(132834);
    switch (AppBrandRemoteTaskController.4.iKE[this.iKw.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132834);
      return;
      aLR();
      try
      {
        long l;
        if (iKy == 0L)
        {
          l = System.currentTimeMillis();
          iKy = l;
        }
        try
        {
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          ab.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
          this.mTimestamp = iKy;
          aBp();
          AppMethodBeat.o(132834);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.AppBrandReporter", localThrowable, "updateTimestamp(%d)", new Object[] { Long.valueOf(l) });
          }
        }
        aLR();
      }
      finally
      {
        AppMethodBeat.o(132834);
      }
      AppMethodBeat.o(132834);
      return;
      aLS();
      AppMethodBeat.o(132834);
      return;
      h.pA(this.iKx);
      AppMethodBeat.o(132834);
      return;
      ET(this.mAppId);
      AppMethodBeat.o(132834);
      return;
      h.a(this.iKz, true);
      AppMethodBeat.o(132834);
      return;
      Object localObject2 = e.iGL;
      String str = this.mAppId;
      localObject2 = (e.a)((e)localObject2).iGM.get(str);
      if (localObject2 != null) {
        ((e.a)localObject2).iGO = bo.aoy();
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(132837);
    switch (AppBrandRemoteTaskController.4.iKE[this.iKw.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132837);
      return;
      this.gRu.ni(hashCode());
      AppMethodBeat.o(132837);
      return;
      switch (this.iKx)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(132837);
        return;
        b.qf(ah.getProcessName());
        this.gQB.finish();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(132837);
        return;
        this.gQB.a(new AppBrandRemoteTaskController.2(this));
      }
      Assert.assertTrue("AppBrand Test Assert", false);
      AppMethodBeat.o(132837);
      return;
      this.gRu.onNetworkChange(hashCode());
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    Object localObject2 = null;
    AppMethodBeat.i(132839);
    this.mAppId = paramParcel.readString();
    this.ikk = paramParcel.readInt();
    this.gSG = paramParcel.readString();
    this.iKv = paramParcel.readLong();
    int i = paramParcel.readInt();
    if (i == -1)
    {
      localObject1 = null;
      this.iKw = ((AppBrandRemoteTaskController.a)localObject1);
      this.iKx = paramParcel.readInt();
      this.mTimestamp = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i != -1) {
        break label116;
      }
    }
    label116:
    for (Object localObject1 = localObject2;; localObject1 = g.values()[i])
    {
      this.iKz = ((g)localObject1);
      this.iKA = paramParcel.readString();
      AppMethodBeat.o(132839);
      return;
      localObject1 = AppBrandRemoteTaskController.a.values()[i];
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    AppMethodBeat.i(132838);
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.ikk);
    paramParcel.writeString(this.gSG);
    paramParcel.writeLong(this.iKv);
    if (this.iKw == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.iKx);
      paramParcel.writeLong(this.mTimestamp);
      if (this.iKz != null) {
        break label110;
      }
    }
    label110:
    for (paramInt = i;; paramInt = this.iKz.ordinal())
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.iKA);
      AppMethodBeat.o(132838);
      return;
      paramInt = this.iKw.ordinal();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */