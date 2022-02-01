package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.ea;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "TAG", "", "periodReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "reportAll", "report", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "IPC_reportKvSafe", "plugin-appbrand-integration_release"})
public final class a
{
  private static final LinkedList<ea> lQw;
  private static final au lQx;
  public static final a lQy;
  
  static
  {
    AppMethodBeat.i(51002);
    lQy = new a();
    lQw = new LinkedList();
    lQx = new au("MicroMsg.AppBrandCrossProcessSafeReporter.TimerLooper", (au.a)new b(), true);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    AppMethodBeat.i(51000);
    k.h(paramVarArgs, "vals");
    if (ai.cin())
    {
      h.wUl.a(paramInt, false, false, paramBoolean, new Object[] { paramVarArgs });
      AppMethodBeat.o(51000);
      return;
    }
    if (lQx.eVs()) {
      lQx.Ah(10000L);
    }
    y localy = null;
    synchronized (lQw)
    {
      LinkedList localLinkedList2 = lQw;
      ea localea = new ea();
      localea.DJF = paramInt;
      h localh = h.wUl;
      localea.value = h.v(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localea.wTX = false;
      localea.wTB = false;
      localea.wTY = paramBoolean;
      localLinkedList2.add(localea);
      paramVarArgs = localy;
      if (lQw.size() >= 1000)
      {
        paramVarArgs = new dz();
        paramVarArgs.fBS.addAll((Collection)lQw);
        lQw.clear();
      }
      localy = y.KTp;
      if (paramVarArgs != null)
      {
        if (a(paramVarArgs) == true) {
          lQx.Ah(10000L);
        }
        AppMethodBeat.o(51000);
        return;
      }
    }
    AppMethodBeat.o(51000);
  }
  
  private static boolean a(dz paramdz)
  {
    AppMethodBeat.i(50999);
    Collection localCollection = (Collection)paramdz.fBS;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50999);
      return false;
    }
    XIPCInvoker.a("com.tencent.mm", paramdz, a.class, null);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$IPC_reportKvSafe;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<dz, IPCVoid>
  {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter$periodReportTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements au.a
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50998);
      a locala = a.lQy;
      a.bsV();
      AppMethodBeat.o(50998);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */