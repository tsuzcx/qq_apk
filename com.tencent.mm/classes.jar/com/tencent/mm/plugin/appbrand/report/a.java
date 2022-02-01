package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "MSG_REPORT", "", "TAG", "", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "reportAll", "sync", "reportIPC", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "reportMM", "scene", "plugin-appbrand-integration_release"})
public final class a
{
  private static final MMHandler mQp;
  private static final LinkedList<eq> nFV;
  private static final int nFW;
  public static final a nFX;
  
  static
  {
    AppMethodBeat.i(51002);
    a locala = new a();
    nFX = locala;
    nFV = new LinkedList();
    nFW = locala.hashCode();
    mQp = new MMHandler("AppBrandCrossProcessSafeReporter$H", (MMHandler.Callback)a.nFY);
    AppMethodBeat.o(51002);
  }
  
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object... paramVarArgs)
  {
    AppMethodBeat.i(229294);
    p.h(paramVarArgs, "vals");
    if (MMApplicationContext.isMainProcess())
    {
      localObject = h.CyF;
      paramVarArgs = h.u(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localObject = h.CyF;
      h.c(paramInt, paramVarArgs, paramBoolean1, paramBoolean3);
      AppMethodBeat.o(229294);
      return;
    }
    Object localObject = null;
    synchronized (nFV)
    {
      LinkedList localLinkedList2 = nFV;
      eq localeq = new eq();
      localeq.KAy = paramInt;
      h localh = h.CyF;
      localeq.value = h.u(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      localeq.Cyr = paramBoolean1;
      localeq.CxY = paramBoolean2;
      localeq.Cys = paramBoolean3;
      localLinkedList2.add(localeq);
      paramVarArgs = (Object[])localObject;
      if (nFV.size() >= 1000)
      {
        paramVarArgs = new ep();
        paramVarArgs.gCs.addAll((Collection)nFV);
        nFV.clear();
      }
      localObject = x.SXb;
      if ((paramVarArgs != null) && (a(paramVarArgs, false) == true))
      {
        mQp.removeMessages(nFW);
        mQp.sendEmptyMessageDelayed(nFW, 10000L);
        AppMethodBeat.o(229294);
        return;
      }
    }
    if (!mQp.hasMessages(nFW)) {
      mQp.sendEmptyMessageDelayed(nFW, 10000L);
    }
    AppMethodBeat.o(229294);
  }
  
  private static boolean a(ep paramep, boolean paramBoolean)
  {
    AppMethodBeat.i(229293);
    Collection localCollection = (Collection)paramep.gCs;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(229293);
      return false;
    }
    if (paramBoolean) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramep, (k)b.nFZ);
    }
    for (;;)
    {
      AppMethodBeat.o(229293);
      return true;
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramep, (b)c.nGa, null);
    }
  }
  
  public static final void iA(boolean paramBoolean)
  {
    AppMethodBeat.i(229291);
    synchronized (nFV)
    {
      ep localep = new ep();
      localep.gCs.addAll((Collection)nFV);
      nFV.clear();
      x localx = x.SXb;
      a(localep, paramBoolean);
      AppMethodBeat.o(229291);
      return;
    }
  }
  
  public final void a(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51001);
    p.h(paramVarArgs, "vals");
    a(paramInt, false, false, false, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    AppMethodBeat.o(51001);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
  static final class a
    implements MMHandler.Callback
  {
    public static final a nFY;
    
    static
    {
      AppMethodBeat.i(229286);
      nFY = new a();
      AppMethodBeat.o(229286);
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(229285);
      int i = paramMessage.what;
      paramMessage = a.nFX;
      if (i == a.bUf()) {
        a.bUe();
      }
      AppMethodBeat.o(229285);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "invoke"})
  static final class b<InputType, ResultType>
    implements k<ep, IPCVoid>
  {
    public static final b nFZ;
    
    static
    {
      AppMethodBeat.i(229288);
      nFZ = new b();
      AppMethodBeat.o(229288);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements b<ep, IPCVoid>
  {
    public static final c nGa;
    
    static
    {
      AppMethodBeat.i(229290);
      nGa = new c();
      AppMethodBeat.o(229290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.a
 * JD-Core Version:    0.7.0.1
 */