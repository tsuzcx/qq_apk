package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class AppBrandIDKeyBatchReport$IDKeyBatchReportTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR;
  public int iFn;
  int iFo;
  public String iFp;
  public int iFq;
  czw iFr;
  
  static
  {
    AppMethodBeat.i(132519);
    CREATOR = new AppBrandIDKeyBatchReport.IDKeyBatchReportTask.1();
    AppMethodBeat.o(132519);
  }
  
  AppBrandIDKeyBatchReport$IDKeyBatchReportTask() {}
  
  AppBrandIDKeyBatchReport$IDKeyBatchReportTask(Parcel paramParcel)
  {
    AppMethodBeat.i(132515);
    f(paramParcel);
    AppMethodBeat.o(132515);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(132516);
    if (1 == this.iFn)
    {
      if ((!bo.isNullOrNil(this.iFp)) && (com.tencent.mm.kernel.g.RJ().eHg))
      {
        Pair localPair = ((b)com.tencent.mm.plugin.appbrand.app.g.w(b.class)).I(this.iFp, 5, this.iFq);
        if (((Boolean)localPair.first).booleanValue())
        {
          ab.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", new Object[] { this.iFp, Integer.valueOf(this.iFq) });
          com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
          com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(((Integer)localPair.second).intValue(), 167L);
          AppMethodBeat.o(132516);
          return;
        }
      }
      AppBrandIDKeyBatchReport.b.kM(0);
      AppBrandIDKeyBatchReport.b.access$300();
      AppMethodBeat.o(132516);
      return;
    }
    if (2 == this.iFn)
    {
      AppBrandIDKeyBatchReport.b.BI();
      AppMethodBeat.o(132516);
      return;
    }
    if (3 == this.iFn) {
      AppBrandIDKeyBatchReport.b.c(this.iFr);
    }
    AppMethodBeat.o(132516);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(132517);
    this.iFn = paramParcel.readInt();
    this.iFo = paramParcel.readInt();
    this.iFp = paramParcel.readString();
    this.iFq = paramParcel.readInt();
    if (3 == this.iFn) {
      try
      {
        this.iFr = new czw();
        this.iFr.parseFrom(paramParcel.createByteArray());
        AppMethodBeat.o(132517);
        return;
      }
      catch (Exception paramParcel)
      {
        ab.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[] { paramParcel });
        this.iFr = null;
      }
    }
    AppMethodBeat.o(132517);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(132518);
    paramParcel.writeInt(this.iFn);
    paramParcel.writeInt(this.iFo);
    paramParcel.writeString(this.iFp);
    paramParcel.writeInt(this.iFq);
    if (3 == this.iFn) {
      try
      {
        paramParcel.writeByteArray(this.iFr.toByteArray());
        AppMethodBeat.o(132518);
        return;
      }
      catch (Exception paramParcel)
      {
        ab.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[] { paramParcel });
      }
    }
    AppMethodBeat.o(132518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.IDKeyBatchReportTask
 * JD-Core Version:    0.7.0.1
 */