package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.cmf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class AppBrandIDKeyBatchReport$IDKeyBatchReportTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR = new AppBrandIDKeyBatchReport.IDKeyBatchReportTask.1();
  public int gXk;
  int gXl;
  public String gXm;
  public int gXn;
  cmf gXo;
  
  AppBrandIDKeyBatchReport$IDKeyBatchReportTask() {}
  
  AppBrandIDKeyBatchReport$IDKeyBatchReportTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    if (1 == this.gXk) {
      if ((!bk.bl(this.gXm)) && (g.DN().dJH))
      {
        Pair localPair = ((b)e.G(b.class)).w(this.gXm, 5, this.gXn);
        if (((Boolean)localPair.first).booleanValue())
        {
          y.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.gXm, Integer.valueOf(this.gXn) });
          com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(((Integer)localPair.second).intValue(), 167L);
        }
      }
    }
    do
    {
      return;
      AppBrandIDKeyBatchReport.b.hZ(0);
      AppBrandIDKeyBatchReport.b.IV();
      return;
      if (2 == this.gXk)
      {
        AppBrandIDKeyBatchReport.b.anZ();
        return;
      }
    } while (3 != this.gXk);
    AppBrandIDKeyBatchReport.b.c(this.gXo);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gXk = paramParcel.readInt();
    this.gXl = paramParcel.readInt();
    this.gXm = paramParcel.readString();
    this.gXn = paramParcel.readInt();
    if (3 == this.gXk) {}
    try
    {
      this.gXo = new cmf();
      this.gXo.aH(paramParcel.createByteArray());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
      this.gXo = null;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.gXk);
    paramParcel.writeInt(this.gXl);
    paramParcel.writeString(this.gXm);
    paramParcel.writeInt(this.gXn);
    if (3 == this.gXk) {}
    try
    {
      paramParcel.writeByteArray(this.gXo.toByteArray());
      return;
    }
    catch (Exception paramParcel)
    {
      y.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[] { paramParcel });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.IDKeyBatchReportTask
 * JD-Core Version:    0.7.0.1
 */