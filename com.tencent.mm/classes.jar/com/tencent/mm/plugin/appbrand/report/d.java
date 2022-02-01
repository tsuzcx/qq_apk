package com.tencent.mm.plugin.appbrand.report;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.fnm;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.protocal.protobuf.fnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew;", "Lcom/tencent/mm/plugin/appbrand/report/WxaCgiIDKeyBatchReportProtocol;", "()V", "BATCH_RECORD_COUNT_MAX", "", "BATCH_REPORT_INTERVAL_MS", "", "CGI_URL", "", "TAG", "batchReportBufferQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxaAppRecord;", "batchReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerGuard", "", "reportNow", "", "reason", "stopTimer", "startTimer", "", "appId", "runtimeEnterScene", "writeIDKeyData", "data", "plugin-appbrand-integration_release"})
public final class d
  implements y
{
  private static final String qIJ = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
  private static final int qIK = 50;
  private static final long qIL;
  private static final LinkedList<fnr> qIM;
  private static MTimerHandler qIN;
  private static final Object qIO;
  public static final d qIP;
  
  static
  {
    AppMethodBeat.i(277626);
    qIP = new d();
    qIJ = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
    qIK = 50;
    qIL = TimeUnit.SECONDS.toMillis(30L);
    qIM = new LinkedList();
    qIO = new Object();
    AppMethodBeat.o(277626);
  }
  
  public static boolean aD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(277625);
    p.k(paramString, "reason");
    if (paramBoolean) {
      synchronized (qIO)
      {
        ??? = qIN;
        if (??? != null) {
          ((MTimerHandler)???).stopTimer();
        }
        qIN = null;
        ??? = x.aazN;
      }
    }
    for (;;)
    {
      synchronized (qIM)
      {
        ??? = new LinkedList((Collection)qIM);
        qIM.clear();
        Log.i("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + paramString + ", reportList.size=" + ((LinkedList)???).size());
        if (((Collection)???).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(277625);
          return false;
          paramString = finally;
          AppMethodBeat.o(277625);
          throw paramString;
        }
      }
      int i = 0;
    }
    ??? = new fnm();
    dwx localdwx = new dwx();
    localdwx.rWh = Build.MANUFACTURER;
    localdwx.UcF = 2;
    localdwx.jUb = com.tencent.mm.protocal.d.RAx;
    localdwx.jUc = com.tencent.mm.protocal.d.RAw;
    Object localObject3 = MMApplicationContext.getResources();
    p.j(localObject3, "MMApplicationContext.getResources()");
    localdwx.Jwa = ((Resources)localObject3).getDisplayMetrics().widthPixels;
    localObject3 = MMApplicationContext.getResources();
    p.j(localObject3, "MMApplicationContext.getResources()");
    localdwx.UcG = ((Resources)localObject3).getDisplayMetrics().heightPixels;
    localdwx.jUd = com.tencent.mm.protocal.d.RAz;
    localdwx.jUe = com.tencent.mm.protocal.d.RAA;
    localObject3 = MMApplicationContext.getResources();
    p.j(localObject3, "MMApplicationContext.getResources()");
    localObject3 = ((Resources)localObject3).getConfiguration().locale;
    p.j(localObject3, "MMApplicationContext.get…es().configuration.locale");
    localdwx.sST = ((Locale)localObject3).getLanguage();
    ((fnm)???).ULT = localdwx;
    ((fnm)???).ULS.addAll((Collection)???);
    ((com.tencent.mm.plugin.appbrand.networking.c)e.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a(qIJ, (a)???, fnn.class).a((com.tencent.mm.vending.g.d.b)new a(paramString, (LinkedList)???)).a((com.tencent.mm.vending.g.d.a)new b(paramString, (LinkedList)???));
    AppMethodBeat.o(277625);
    return true;
  }
  
  public final void a(fnr arg1)
  {
    AppMethodBeat.i(277624);
    Log.i("Luggage.AppBrandIDKeyBatchReportNew", "writeIDKeyData type:" + ???.rWu);
    synchronized (qIM)
    {
      qIM.addLast(???);
      int i = qIM.size();
      if (i >= qIK)
      {
        aD("writeIDKeyData", true);
        AppMethodBeat.o(277624);
        return;
      }
    }
    synchronized (qIO)
    {
      if (qIN != null)
      {
        ??? = qIN;
        if ((??? == null) || (((MTimerHandler)???).stopped() != true)) {}
      }
      else
      {
        ??? = new MTimerHandler("Luggage.AppBrandIDKeyBatchReportNew", (MTimerHandler.CallBack)new c(), true);
        long l = qIL;
        ((MTimerHandler)???).startTimer(l, l);
        qIN = (MTimerHandler)???;
      }
      ??? = x.aazN;
      AppMethodBeat.o(277624);
      return;
    }
  }
  
  public final void cD(String paramString, int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/WxaAppIDKeyBatchReportResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class a<T>
    implements com.tencent.mm.vending.g.d.b<fnn>
  {
    a(String paramString, LinkedList paramLinkedList) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    b(String paramString, LinkedList paramLinkedList) {}
    
    public final void cm(Object arg1)
    {
      AppMethodBeat.i(278134);
      Object localObject1 = new StringBuilder("reportNow, reason=").append(this.qIQ).append(", reportList.size=").append(this.qIR.size()).append(", cgi error ");
      if (??? != null) {
        ??? = ???.toString();
      }
      for (;;)
      {
        Log.e("Luggage.AppBrandIDKeyBatchReportNew", ???);
        ??? = d.qIP;
        synchronized (d.chv())
        {
          localObject1 = d.qIP;
          d.chv().addAll((Collection)this.qIR);
          this.qIR.clear();
          AppMethodBeat.o(278134);
          return;
          ??? = null;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew$startTimer$1$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(266968);
      d locald = d.qIP;
      boolean bool = d.aD("onTimerExpired", false);
      AppMethodBeat.o(266968);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */