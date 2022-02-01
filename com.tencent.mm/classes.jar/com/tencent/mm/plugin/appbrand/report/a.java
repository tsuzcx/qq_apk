package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "MSG_REPORT", "", "TAG", "", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "vals", "", "(I[Ljava/lang/Object;)V", "kvStatFull", "type", "isReportNow", "", "isImportant", "ignoreFreqLimit", "kvStatWithType", "(II[Ljava/lang/Object;)V", "reportAll", "sync", "reportIPC", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "reportMM", "scene", "plugin-appbrand-integration_release"})
public final class a
{
  private static final MMHandler pRi;
  private static final LinkedList<en> qIh;
  private static final int qIi;
  public static final a qIj;
  
  static
  {
    AppMethodBeat.i(51002);
    a locala = new a();
    qIj = locala;
    qIh = new LinkedList();
    qIi = locala.hashCode();
    pRi = new MMHandler("AppBrandCrossProcessSafeReporter$H", (MMHandler.Callback)a.qIk);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    AppMethodBeat.i(274304);
    p.k(paramString, "vals");
    if (MMApplicationContext.isMainProcess())
    {
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.AppBrandCrossProcessSafeReporter", "kvStatFull(mm-direct): logID:" + paramInt1 + ", type:" + paramInt2 + ", val:" + paramString);
      }
      localObject = h.IzE;
      h.c(paramInt1, paramInt2, paramString, paramBoolean1, paramBoolean3);
      AppMethodBeat.o(274304);
      return;
    }
    Object localObject = null;
    synchronized (qIh)
    {
      LinkedList localLinkedList2 = qIh;
      en localen = new en();
      localen.RCo = paramInt1;
      localen.value = paramString;
      localen.Izq = paramBoolean1;
      localen.IyX = paramBoolean2;
      localen.Izr = paramBoolean3;
      localen.type = paramInt2;
      localLinkedList2.add(localen);
      paramString = (String)localObject;
      if (qIh.size() >= 1000)
      {
        paramString = new em();
        paramString.jmy.addAll((Collection)qIh);
        qIh.clear();
      }
      localObject = x.aazN;
      if ((paramString != null) && (a(paramString, false) == true))
      {
        pRi.removeMessages(qIi);
        pRi.sendEmptyMessageDelayed(qIi, 10000L);
        AppMethodBeat.o(274304);
        return;
      }
    }
    if (!pRi.hasMessages(qIi)) {
      pRi.sendEmptyMessageDelayed(qIi, 10000L);
    }
    AppMethodBeat.o(274304);
  }
  
  private static boolean a(em paramem, boolean paramBoolean)
  {
    AppMethodBeat.i(274303);
    Collection localCollection = (Collection)paramem.jmy;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(274303);
      return false;
    }
    if (paramBoolean) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramem, (m)b.qIl);
    }
    for (;;)
    {
      AppMethodBeat.o(274303);
      return true;
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramem, (d)c.qIm, null);
    }
  }
  
  public static final void jy(boolean paramBoolean)
  {
    AppMethodBeat.i(274301);
    synchronized (qIh)
    {
      em localem = new em();
      localem.jmy.addAll((Collection)qIh);
      qIh.clear();
      x localx = x.aazN;
      a(localem, paramBoolean);
      AppMethodBeat.o(274301);
      return;
    }
  }
  
  public final void a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51001);
    p.k(paramVarArgs, "vals");
    h localh = h.IzE;
    paramVarArgs = h.u(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    p.j(paramVarArgs, "ReportManager.INSTANCE.g…StringFromMutilObj(*vals)");
    a(paramInt, 0, false, false, false, paramVarArgs);
    AppMethodBeat.o(51001);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    public static final a qIk;
    
    static
    {
      AppMethodBeat.i(276706);
      qIk = new a();
      AppMethodBeat.o(276706);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(276704);
      int i = paramMessage.what;
      paramMessage = a.qIj;
      if (i == a.chl()) {
        a.chk();
      }
      AppMethodBeat.o(276704);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "invoke"})
  static final class b<InputType, ResultType>
    implements m<em, IPCVoid>
  {
    public static final b qIl;
    
    static
    {
      AppMethodBeat.i(284242);
      qIl = new b();
      AppMethodBeat.o(284242);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements c<em, IPCVoid>
  {
    public static final c qIm;
    
    static
    {
      AppMethodBeat.i(274550);
      qIm = new c();
      AppMethodBeat.o(274550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */