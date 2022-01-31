package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;

public class ReportStorageSizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<ReportStorageSizeTask> CREATOR;
  public String appId;
  
  static
  {
    AppMethodBeat.i(129148);
    CREATOR = new ReportStorageSizeTask.1();
    AppMethodBeat.o(129148);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(129145);
    Object localObject = g.wf();
    if (localObject == null)
    {
      AppMethodBeat.o(129145);
      return;
    }
    c.a locala = c.gZf;
    if (c.a.yV(this.appId) != 1) {}
    for (localObject = Integer.valueOf(((com.tencent.luggage.sdk.customize.b)e.q(com.tencent.luggage.sdk.customize.b.class)).cc(this.appId).yT(this.appId));; localObject = Integer.valueOf(((com.tencent.mm.plugin.appbrand.appstorage.b)localObject).yT(this.appId)))
    {
      h.qsU.e(14073, new Object[] { this.appId, "", "", localObject, Long.valueOf(AppBrandLocalMediaObjectManager.yW(this.appId)), Long.valueOf(AppBrandLocalMediaObjectManager.yX(this.appId)) });
      AppMethodBeat.o(129145);
      return;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(129147);
    this.appId = paramParcel.readString();
    AppMethodBeat.o(129147);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(129146);
    paramParcel.writeString(this.appId);
    AppMethodBeat.o(129146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ReportStorageSizeTask
 * JD-Core Version:    0.7.0.1
 */