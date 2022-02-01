package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "TAG", "", "periodReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "reportAll", "report", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "IPC_reportKvSafe", "plugin-appbrand-integration_release"})
public final class a
{
  private static final LinkedList<ee> mvk;
  private static final aw mvl;
  public static final a mvm;
  
  static
  {
    AppMethodBeat.i(51002);
    mvm = new a();
    mvk = new LinkedList();
    mvl = new aw("MicroMsg.AppBrandCrossProcessSafeReporter.TimerLooper", (aw.a)new a.b(), true);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(223854);
    p.h(paramVarArgs, "vals");
    if (ak.coh())
    {
      localObject = g.yxI;
      paramVarArgs = g.u(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localObject = g.yxI;
      g.c(paramInt, paramVarArgs, paramBoolean1, paramBoolean3);
      AppMethodBeat.o(223854);
      return;
    }
    if (mvl.foU()) {
      mvl.Dv(10000L);
    }
    Object localObject = null;
    synchronized (mvk)
    {
      LinkedList localLinkedList2 = mvk;
      ee localee = new ee();
      localee.FHk = paramInt;
      g localg = g.yxI;
      localee.value = g.u(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localee.yxu = paramBoolean1;
      localee.yxc = paramBoolean2;
      localee.yxv = paramBoolean3;
      localLinkedList2.add(localee);
      paramVarArgs = (Object[])localObject;
      if (mvk.size() >= 1000)
      {
        paramVarArgs = new ed();
        paramVarArgs.fXm.addAll((Collection)mvk);
        mvk.clear();
      }
      localObject = z.Nhr;
      if (paramVarArgs != null)
      {
        if (a(paramVarArgs) == true) {
          mvl.Dv(10000L);
        }
        AppMethodBeat.o(223854);
        return;
      }
    }
    AppMethodBeat.o(223854);
  }
  
  private static boolean a(ed paramed)
  {
    AppMethodBeat.i(50999);
    Collection localCollection = (Collection)paramed.fXm;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50999);
      return false;
    }
    XIPCInvoker.a("com.tencent.mm", paramed, a.class, null);
    AppMethodBeat.o(50999);
    return true;
  }
  
  public static final void bxS()
  {
    AppMethodBeat.i(223853);
    synchronized (mvk)
    {
      ed localed = new ed();
      localed.fXm.addAll((Collection)mvk);
      mvk.clear();
      z localz = z.Nhr;
      a(localed);
      AppMethodBeat.o(223853);
      return;
    }
  }
  
  public static void f(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51001);
    p.h(paramVarArgs, "vals");
    a(paramInt, false, false, false, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(51001);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$IPC_reportKvSafe;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<ed, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */