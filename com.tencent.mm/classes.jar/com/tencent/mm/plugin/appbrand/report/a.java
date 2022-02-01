package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "TAG", "", "periodReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "reportAll", "report", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "IPC_reportKvSafe", "plugin-appbrand-integration_release"})
public final class a
{
  private static final LinkedList<dy> low;
  private static final av lox;
  public static final a loy;
  
  static
  {
    AppMethodBeat.i(51002);
    loy = new a();
    low = new LinkedList();
    lox = new av("MicroMsg.AppBrandCrossProcessSafeReporter.TimerLooper", (av.a)new b(), true);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    AppMethodBeat.i(51000);
    k.h(paramVarArgs, "vals");
    if (aj.cbe())
    {
      h.vKh.a(paramInt, false, false, paramBoolean, new Object[] { paramVarArgs });
      AppMethodBeat.o(51000);
      return;
    }
    if (lox.eFX()) {
      lox.vE(10000L);
    }
    y localy = null;
    synchronized (low)
    {
      LinkedList localLinkedList2 = low;
      dy localdy = new dy();
      localdy.Crn = paramInt;
      h localh = h.vKh;
      localdy.value = h.t(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localdy.vJT = false;
      localdy.vJx = false;
      localdy.vJU = paramBoolean;
      localLinkedList2.add(localdy);
      paramVarArgs = localy;
      if (low.size() >= 1000)
      {
        paramVarArgs = new dx();
        paramVarArgs.fyl.addAll((Collection)low);
        low.clear();
      }
      localy = y.JfV;
      if (paramVarArgs != null)
      {
        if (a(paramVarArgs) == true) {
          lox.vE(10000L);
        }
        AppMethodBeat.o(51000);
        return;
      }
    }
    AppMethodBeat.o(51000);
  }
  
  private static boolean a(dx paramdx)
  {
    AppMethodBeat.i(50999);
    Collection localCollection = (Collection)paramdx.fyl;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50999);
      return false;
    }
    XIPCInvoker.a("com.tencent.mm", paramdx, a.class, null);
    AppMethodBeat.o(50999);
    return true;
  }
  
  public static void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51001);
    k.h(paramVarArgs, "vals");
    a(paramInt, false, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(51001);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$IPC_reportKvSafe;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<dx, IPCVoid>
  {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$periodReportTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements av.a
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50998);
      a locala = a.loy;
      a.blZ();
      AppMethodBeat.o(50998);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */