package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "MSG_REPORT", "", "TAG", "", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "vals", "", "(I[Ljava/lang/Object;)V", "kvStatFull", "type", "isReportNow", "", "isImportant", "ignoreFreqLimit", "kvStatWithType", "(II[Ljava/lang/Object;)V", "reportAll", "sync", "reportIPC", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "reportMM", "scene", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final MMHandler sVR;
  public static final a tMQ;
  private static final LinkedList<fh> tMR;
  private static final int tMS;
  
  static
  {
    AppMethodBeat.i(51002);
    tMQ = new a();
    tMR = new LinkedList();
    tMS = tMQ.hashCode();
    sVR = new MMHandler("AppBrandCrossProcessSafeReporter$H", a..ExternalSyntheticLambda2.INSTANCE);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    AppMethodBeat.i(321405);
    s.u(paramString, "vals");
    if (MMApplicationContext.isMainProcess())
    {
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.AppBrandCrossProcessSafeReporter", "kvStatFull(mm-direct): logID:" + paramInt1 + ", type:" + paramInt2 + ", val:" + paramString);
      }
      localObject = h.OAn;
      h.c(paramInt1, paramInt2, paramString, paramBoolean1, paramBoolean3);
      AppMethodBeat.o(321405);
      return;
    }
    Object localObject = null;
    for (;;)
    {
      synchronized (tMR)
      {
        LinkedList localLinkedList2 = tMR;
        fh localfh = new fh();
        localfh.YyQ = paramInt1;
        localfh.value = paramString;
        localfh.OzZ = paramBoolean1;
        localfh.OzE = paramBoolean2;
        localfh.OAa = paramBoolean3;
        localfh.type = paramInt2;
        paramString = ah.aiuX;
        localLinkedList2.add(localfh);
        paramString = (String)localObject;
        if (tMR.size() >= 1000)
        {
          paramString = new fg();
          paramString.lPK.addAll((Collection)tMR);
          localObject = ah.aiuX;
          tMR.clear();
        }
        localObject = ah.aiuX;
        if ((paramString != null) && (a(paramString) == true))
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            break;
          }
          sVR.removeMessages(tMS);
          sVR.sendEmptyMessageDelayed(tMS, 10000L);
          AppMethodBeat.o(321405);
          return;
        }
      }
      paramInt1 = 0;
    }
    if (!sVR.hasMessages(tMS)) {
      sVR.sendEmptyMessageDelayed(tMS, 10000L);
    }
    AppMethodBeat.o(321405);
  }
  
  private static final void a(fg paramfg, f paramf)
  {
    AppMethodBeat.i(321419);
    a(paramfg, "ipcInvokeMM");
    if (paramf != null) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
    }
    AppMethodBeat.o(321419);
  }
  
  private static void a(fg paramfg, String paramString)
  {
    AppMethodBeat.i(321400);
    if (paramfg == null) {}
    for (paramfg = null;; paramfg = paramfg.lPK)
    {
      Object localObject = (List)paramfg;
      paramfg = (fg)localObject;
      if (localObject == null) {
        paramfg = (List)ab.aivy;
      }
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.AppBrandCrossProcessSafeReporter", "reportMM scene:" + paramString + ", size:" + paramfg.size());
      }
      paramfg = paramfg.iterator();
      while (paramfg.hasNext())
      {
        paramString = (fh)paramfg.next();
        try
        {
          if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.AppBrandCrossProcessSafeReporter", "kvStat(mm-ipc): logID:" + paramString.YyQ + ", type:" + paramString.type + ", val:" + paramString.value);
          }
          localObject = h.OAn;
          h.c(paramString.YyQ, paramString.type, paramString.value, paramString.OzZ, paramString.OAa);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandCrossProcessSafeReporter", "reportMM logid=" + paramString.YyQ + ", e=" + localException);
        }
      }
    }
    AppMethodBeat.o(321400);
  }
  
  private static boolean a(fg paramfg, boolean paramBoolean)
  {
    AppMethodBeat.i(321390);
    Collection localCollection = (Collection)paramfg.lPK;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(321390);
      return false;
    }
    if (paramBoolean) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramfg, a..ExternalSyntheticLambda1.INSTANCE);
    }
    for (;;)
    {
      AppMethodBeat.o(321390);
      return true;
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramfg, (d)a..ExternalSyntheticLambda0.INSTANCE, null);
    }
  }
  
  private static final IPCVoid b(fg paramfg)
  {
    AppMethodBeat.i(321414);
    a(paramfg, "ipcInvokeMMSync");
    paramfg = IPCVoid.mzv;
    AppMethodBeat.o(321414);
    return paramfg;
  }
  
  private static final boolean i(Message paramMessage)
  {
    AppMethodBeat.i(321409);
    s.u(paramMessage, "it");
    if (paramMessage.what == tMS) {
      kL(false);
    }
    AppMethodBeat.o(321409);
    return true;
  }
  
  public static final void kL(boolean paramBoolean)
  {
    AppMethodBeat.i(321384);
    synchronized (tMR)
    {
      fg localfg = new fg();
      localfg.lPK.addAll((Collection)tMR);
      ah localah = ah.aiuX;
      tMR.clear();
      localah = ah.aiuX;
      a(localfg, paramBoolean);
      AppMethodBeat.o(321384);
      return;
    }
  }
  
  public final void b(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51001);
    s.u(paramVarArgs, "vals");
    h localh = h.OAn;
    paramVarArgs = h.w(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    s.s(paramVarArgs, "getStringFromMutilObj(*vals)");
    a(paramInt, 0, false, false, false, paramVarArgs);
    AppMethodBeat.o(51001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */