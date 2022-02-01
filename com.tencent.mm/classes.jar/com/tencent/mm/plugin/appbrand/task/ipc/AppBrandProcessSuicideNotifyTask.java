package com.tencent.mm.plugin.appbrand.task.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic.a;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandProcessSuicideNotifyTask;", "", "reason", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic$SUICIDE_REASON;", "(Lcom/tencent/mm/plugin/appbrand/app/AppBrandProcessSuicideLogic$SUICIDE_REASON;)V", "executeAsync", "", "Args", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandProcessSuicideNotifyTask
{
  private static final AppBrandProcessSuicideNotifyTask.a tWK;
  private final AppBrandProcessSuicideLogic.a tWL;
  
  static
  {
    AppMethodBeat.i(318666);
    tWK = new AppBrandProcessSuicideNotifyTask.a((byte)0);
    AppMethodBeat.o(318666);
  }
  
  public AppBrandProcessSuicideNotifyTask(AppBrandProcessSuicideLogic.a parama)
  {
    AppMethodBeat.i(318641);
    this.tWL = parama;
    AppMethodBeat.o(318641);
  }
  
  private static final void a(Args paramArgs, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(318653);
    int i = paramArgs.epc;
    String str = paramArgs.processName;
    long l3 = paramArgs.tWM;
    int j = paramArgs.qBN;
    try
    {
      paramArgs = i.tWq;
      com.tencent.mm.plugin.appbrand.task.d locald = (com.tencent.mm.plugin.appbrand.task.d)i.a.cJV().mt(i);
      Iterator localIterator = ((Iterable)locald.etV).iterator();
      if (!localIterator.hasNext()) {}
      label82:
      boolean bool;
      for (paramf = null;; paramf = paramArgs)
      {
        paramArgs = (e)paramf;
        if (paramArgs != null) {
          break label287;
        }
        l1 = 0L;
        if (l1 > l3) {
          break label299;
        }
        locald.ase();
        locald.etX = LuggageServiceType.eux;
        locald.etV.clear();
        locald.asc();
        com.tencent.mm.plugin.report.service.h.OAn.kJ(365, j);
        bool = true;
        label131:
        Log.i("MicroMsg.AppBrandProcessSuicideNotifyTask", "executeAsync in main process, processIndex:" + i + ", processName:" + str + ", killed:" + bool + ", timestamp:(" + l1 + " , " + l3 + ')');
        AppMethodBeat.o(318653);
        return;
        paramArgs = localIterator.next();
        if (localIterator.hasNext()) {
          break;
        }
      }
      long l1 = ((com.tencent.mm.plugin.appbrand.task.f)paramArgs).qYe;
      label238:
      paramf = localIterator.next();
      long l2 = ((com.tencent.mm.plugin.appbrand.task.f)paramf).qYe;
      if (l1 < l2)
      {
        paramArgs = paramf;
        l1 = l2;
      }
      for (;;)
      {
        paramf = paramArgs;
        if (!localIterator.hasNext()) {
          break;
        }
        break label238;
        label287:
        l1 = ((com.tencent.mm.plugin.appbrand.task.f)paramArgs).qYe;
        break label82;
        label299:
        bool = false;
        break label131;
      }
    }
    catch (Exception paramArgs)
    {
      Log.e("MicroMsg.AppBrandProcessSuicideNotifyTask", "executeAsync in main process, processIndex:" + i + ", processName:" + str + ", get exception:" + paramArgs);
      AppMethodBeat.o(318653);
      return;
    }
  }
  
  public final void cKh()
  {
    AppMethodBeat.i(318682);
    if (!MMApplicationContext.isMMProcessExist())
    {
      AppMethodBeat.o(318682);
      return;
    }
    int i = com.tencent.mm.plugin.appbrand.task.h.epc;
    String str = MMApplicationContext.getProcessName();
    s.s(str, "getProcessName()");
    a.a(new Args(i, str, Util.nowMilliSecond(), this.tWL.qBN), (com.tencent.mm.ipcinvoker.d)AppBrandProcessSuicideNotifyTask..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(318682);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/ipc/AppBrandProcessSuicideNotifyTask$Args;", "Landroid/os/Parcelable;", "processIndex", "", "processName", "", "invokeTimestampMs", "", "reportKey", "(ILjava/lang/String;JI)V", "getInvokeTimestampMs", "()J", "getProcessIndex", "()I", "getProcessName", "()Ljava/lang/String;", "getReportKey", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Args
    implements Parcelable
  {
    public static final Parcelable.Creator<Args> CREATOR;
    final int epc;
    final String processName;
    final int qBN;
    final long tWM;
    
    static
    {
      AppMethodBeat.i(318680);
      CREATOR = (Parcelable.Creator)new a();
      AppMethodBeat.o(318680);
    }
    
    public Args(int paramInt1, String paramString, long paramLong, int paramInt2)
    {
      AppMethodBeat.i(318674);
      this.epc = paramInt1;
      this.processName = paramString;
      this.tWM = paramLong;
      this.qBN = paramInt2;
      AppMethodBeat.o(318674);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(318692);
      if (this == paramObject)
      {
        AppMethodBeat.o(318692);
        return true;
      }
      if (!(paramObject instanceof Args))
      {
        AppMethodBeat.o(318692);
        return false;
      }
      paramObject = (Args)paramObject;
      if (this.epc != paramObject.epc)
      {
        AppMethodBeat.o(318692);
        return false;
      }
      if (!s.p(this.processName, paramObject.processName))
      {
        AppMethodBeat.o(318692);
        return false;
      }
      if (this.tWM != paramObject.tWM)
      {
        AppMethodBeat.o(318692);
        return false;
      }
      if (this.qBN != paramObject.qBN)
      {
        AppMethodBeat.o(318692);
        return false;
      }
      AppMethodBeat.o(318692);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(318691);
      int i = this.epc;
      int j = this.processName.hashCode();
      int k = q.a..ExternalSyntheticBackport0.m(this.tWM);
      int m = this.qBN;
      AppMethodBeat.o(318691);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(318685);
      String str = "Args(processIndex=" + this.epc + ", processName=" + this.processName + ", invokeTimestampMs=" + this.tWM + ", reportKey=" + this.qBN + ')';
      AppMethodBeat.o(318685);
      return str;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(318698);
      s.u(paramParcel, "out");
      paramParcel.writeInt(this.epc);
      paramParcel.writeString(this.processName);
      paramParcel.writeLong(this.tWM);
      paramParcel.writeInt(this.qBN);
      AppMethodBeat.o(318698);
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Parcelable.Creator<AppBrandProcessSuicideNotifyTask.Args>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandProcessSuicideNotifyTask
 * JD-Core Version:    0.7.0.1
 */