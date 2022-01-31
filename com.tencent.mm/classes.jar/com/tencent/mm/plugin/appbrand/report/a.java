package com.tencent.mm.plugin.appbrand.report;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dm;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "TAG", "", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "IPC_reportKvSafe", "plugin-appbrand-integration_release"})
public final class a
{
  private static final LinkedList<dm> iFd;
  public static final a iFe;
  
  static
  {
    AppMethodBeat.i(155959);
    iFe = new a();
    iFd = new LinkedList();
    AppMethodBeat.o(155959);
  }
  
  public static void a(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    AppMethodBeat.i(155957);
    j.q(paramVarArgs, "vals");
    for (;;)
    {
      synchronized (iFd)
      {
        Object localObject = iFd;
        dm localdm = new dm();
        localdm.wjb = paramInt;
        h localh = h.qsU;
        localdm.value = h.t(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
        localdm.qsG = false;
        localdm.qsi = false;
        localdm.qsH = paramBoolean;
        ((LinkedList)localObject).add(localdm);
        if (iFd.size() < 1000) {
          break label164;
        }
        paramVarArgs = new dl();
        paramVarArgs.elu.addAll((Collection)iFd);
        iFd.clear();
        localObject = y.BMg;
        if (paramVarArgs != null)
        {
          XIPCInvoker.a("com.tencent.mm", paramVarArgs, a.a.class, null);
          AppMethodBeat.o(155957);
          return;
        }
      }
      AppMethodBeat.o(155957);
      return;
      label164:
      paramVarArgs = null;
    }
  }
  
  public static void e(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155958);
    j.q(paramVarArgs, "vals");
    a(paramInt, false, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(155958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */