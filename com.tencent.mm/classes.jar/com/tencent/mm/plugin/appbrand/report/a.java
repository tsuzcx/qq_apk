package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "TAG", "", "periodReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "reportAll", "report", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "IPC_reportKvSafe", "plugin-appbrand-integration_release"})
public final class a
{
  private static final LinkedList<ee> mqm;
  private static final av mqn;
  public static final a mqo;
  
  static
  {
    AppMethodBeat.i(51002);
    mqo = new a();
    mqm = new LinkedList();
    mqn = new av("MicroMsg.AppBrandCrossProcessSafeReporter.TimerLooper", (av.a)new a.b(), true);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(189585);
    p.h(paramVarArgs, "vals");
    if (aj.cmR())
    {
      localObject = g.yhR;
      paramVarArgs = g.v(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localObject = g.yhR;
      g.c(paramInt, paramVarArgs, paramBoolean1, paramBoolean3);
      AppMethodBeat.o(189585);
      return;
    }
    if (mqn.fkZ()) {
      mqn.CX(10000L);
    }
    Object localObject = null;
    synchronized (mqm)
    {
      LinkedList localLinkedList2 = mqm;
      ee localee = new ee();
      localee.FoM = paramInt;
      g localg = g.yhR;
      localee.value = g.v(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localee.yhD = paramBoolean1;
      localee.yhl = paramBoolean2;
      localee.yhE = paramBoolean3;
      localLinkedList2.add(localee);
      paramVarArgs = (Object[])localObject;
      if (mqm.size() >= 1000)
      {
        paramVarArgs = new ed();
        paramVarArgs.fVg.addAll((Collection)mqm);
        mqm.clear();
      }
      localObject = z.MKo;
      if (paramVarArgs != null)
      {
        if (a(paramVarArgs) == true) {
          mqn.CX(10000L);
        }
        AppMethodBeat.o(189585);
        return;
      }
    }
    AppMethodBeat.o(189585);
  }
  
  private static boolean a(ed paramed)
  {
    AppMethodBeat.i(50999);
    Collection localCollection = (Collection)paramed.fVg;
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
  
  public static final void bwZ()
  {
    AppMethodBeat.i(189584);
    synchronized (mqm)
    {
      ed localed = new ed();
      localed.fVg.addAll((Collection)mqm);
      mqm.clear();
      z localz = z.MKo;
      a(localed);
      AppMethodBeat.o(189584);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$IPC_reportKvSafe;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<ed, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */