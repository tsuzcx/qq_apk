package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.model.f.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import junit.framework.Assert;

public class AppBrandRemoteTaskController
  extends MainProcessTask
{
  public static final Parcelable.Creator<AppBrandRemoteTaskController> CREATOR = new AppBrandRemoteTaskController.3();
  private static long hbD;
  public String fAR;
  public h fyY = null;
  public e fzL = null;
  public int gJA;
  public long hbA;
  public AppBrandRemoteTaskController.a hbB = AppBrandRemoteTaskController.a.hbH;
  int hbC;
  private f hbE = f.hbW;
  public String mAppId;
  private long mTimestamp;
  
  private void aoK()
  {
    i locali;
    Object localObject;
    if (this.fAR.endsWith(".AppBrandEmbedUI"))
    {
      locali = g.a(new g.a()
      {
        public final boolean a(i paramAnonymousi)
        {
          return ((paramAnonymousi instanceof a)) && (((a)paramAnonymousi).hbb == AppBrandRemoteTaskController.a(AppBrandRemoteTaskController.this));
        }
      });
      localObject = locali;
      if (locali == null) {
        localObject = new a(this.hbA);
      }
    }
    do
    {
      ((i)localObject).a(this.mAppId, this.gJA, this);
      g.b((i)localObject);
      return;
      locali = g.wq(this.fAR);
      localObject = locali;
    } while (locali != null);
  }
  
  private void aoL()
  {
    if (g.cc(this.mAppId, this.fAR) == null) {
      return;
    }
    g.wi(this.mAppId);
  }
  
  public final void Zu()
  {
    switch (AppBrandRemoteTaskController.4.hbG[this.hbB.ordinal()])
    {
    }
    Object localObject2;
    do
    {
      return;
      aoK();
      try
      {
        if (hbD == 0L)
        {
          long l = System.currentTimeMillis();
          hbD = l;
          SharedPreferences.Editor localEditor = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "pref_appbrand_process", 4).edit();
          localEditor.putLong("on_wxa_process_connected_time", l);
          localEditor.commit();
          y.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[] { Long.valueOf(l) });
        }
        this.mTimestamp = hbD;
        ahI();
        return;
      }
      finally {}
      aoK();
      return;
      aoL();
      return;
      g.mo(this.hbC);
      return;
      g.wm(this.mAppId);
      return;
      g.b(this.hbE);
      return;
      localObject2 = com.tencent.mm.plugin.appbrand.report.model.f.gYu;
      String str = this.mAppId;
      localObject2 = (f.a)((com.tencent.mm.plugin.appbrand.report.model.f)localObject2).gYv.get(str);
    } while (localObject2 == null);
    ((f.a)localObject2).gYx = bk.UY();
  }
  
  public final void Zv()
  {
    switch (AppBrandRemoteTaskController.4.hbG[this.hbB.ordinal()])
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 3: 
      this.fzL.finish();
      return;
    case 8: 
      switch (this.hbC)
      {
      default: 
        return;
      case 0: 
        b.jr(ae.getProcessName());
        this.fyY.finish();
        Process.killProcess(Process.myPid());
        return;
      }
      this.fyY.a(new AppBrandRemoteTaskController.2(this));
      return;
    case 9: 
      Assert.assertTrue("AppBrand Test Assert", false);
      return;
    }
    this.fzL.onNetworkChange();
  }
  
  public final void a(String paramString, int paramInt, f paramf)
  {
    this.hbB = AppBrandRemoteTaskController.a.hbI;
    this.mAppId = paramString;
    this.gJA = paramInt;
    this.hbE = paramf;
    AppBrandMainProcessService.a(this);
  }
  
  public final void e(Parcel paramParcel)
  {
    Object localObject = null;
    this.mAppId = paramParcel.readString();
    this.gJA = paramParcel.readInt();
    this.fAR = paramParcel.readString();
    this.hbA = paramParcel.readLong();
    int i = paramParcel.readInt();
    AppBrandRemoteTaskController.a locala;
    if (i == -1)
    {
      locala = null;
      this.hbB = locala;
      this.hbC = paramParcel.readInt();
      this.mTimestamp = paramParcel.readLong();
      i = paramParcel.readInt();
      if (i != -1) {
        break label96;
      }
    }
    label96:
    for (paramParcel = localObject;; paramParcel = f.values()[i])
    {
      this.hbE = paramParcel;
      return;
      locala = AppBrandRemoteTaskController.a.values()[i];
      break;
    }
  }
  
  final void wl(String paramString)
  {
    this.hbB = AppBrandRemoteTaskController.a.hbK;
    this.mAppId = paramString;
    aoL();
    ahI();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = -1;
    paramParcel.writeString(this.mAppId);
    paramParcel.writeInt(this.gJA);
    paramParcel.writeString(this.fAR);
    paramParcel.writeLong(this.hbA);
    if (this.hbB == null)
    {
      paramInt = -1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hbC);
      paramParcel.writeLong(this.mTimestamp);
      if (this.hbE != null) {
        break label90;
      }
    }
    label90:
    for (paramInt = i;; paramInt = this.hbE.ordinal())
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = this.hbB.ordinal();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController
 * JD-Core Version:    0.7.0.1
 */