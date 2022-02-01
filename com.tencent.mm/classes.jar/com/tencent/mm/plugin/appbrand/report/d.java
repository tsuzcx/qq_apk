package com.tencent.mm.plugin.appbrand.report;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.fcm;
import com.tencent.mm.protocal.protobuf.fcq;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew;", "Lcom/tencent/mm/plugin/appbrand/report/WxaCgiIDKeyBatchReportProtocol;", "()V", "BATCH_RECORD_COUNT_MAX", "", "BATCH_REPORT_INTERVAL_MS", "", "CGI_URL", "", "TAG", "batchReportBufferQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxaAppRecord;", "batchReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerGuard", "", "reportNow", "", "reason", "stopTimer", "startTimer", "", "appId", "runtimeEnterScene", "writeIDKeyData", "data", "plugin-appbrand-integration_release"})
public final class d
  implements x
{
  private static final long nGA;
  private static final LinkedList<fcq> nGB;
  private static MTimerHandler nGC;
  private static final Object nGD;
  public static final d nGE;
  private static final String nGy = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
  private static final int nGz = 50;
  
  static
  {
    AppMethodBeat.i(229301);
    nGE = new d();
    nGy = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
    nGz = 50;
    nGA = TimeUnit.SECONDS.toMillis(30L);
    nGB = new LinkedList();
    nGD = new Object();
    AppMethodBeat.o(229301);
  }
  
  public static boolean aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(229300);
    p.h(paramString, "reason");
    if (paramBoolean) {
      synchronized (nGD)
      {
        ??? = nGC;
        if (??? != null) {
          ((MTimerHandler)???).stopTimer();
        }
        nGC = null;
        ??? = kotlin.x.SXb;
      }
    }
    for (;;)
    {
      synchronized (nGB)
      {
        ??? = new LinkedList((Collection)nGB);
        nGB.clear();
        Log.i("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + paramString + ", reportList.size=" + ((LinkedList)???).size());
        if (((Collection)???).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(229300);
          return false;
          paramString = finally;
          AppMethodBeat.o(229300);
          throw paramString;
        }
      }
      int i = 0;
    }
    ??? = new fcl();
    dnf localdnf = new dnf();
    localdnf.oUj = Build.MANUFACTURER;
    localdnf.MQy = 2;
    localdnf.hid = com.tencent.mm.protocal.d.KyJ;
    localdnf.hie = com.tencent.mm.protocal.d.KyI;
    Object localObject3 = MMApplicationContext.getResources();
    p.g(localObject3, "MMApplicationContext.getResources()");
    localdnf.Dqw = ((Resources)localObject3).getDisplayMetrics().widthPixels;
    localObject3 = MMApplicationContext.getResources();
    p.g(localObject3, "MMApplicationContext.getResources()");
    localdnf.MQz = ((Resources)localObject3).getDisplayMetrics().heightPixels;
    localdnf.hif = com.tencent.mm.protocal.d.KyL;
    localdnf.hig = com.tencent.mm.protocal.d.KyM;
    localObject3 = MMApplicationContext.getResources();
    p.g(localObject3, "MMApplicationContext.getResources()");
    localObject3 = ((Resources)localObject3).getConfiguration().locale;
    p.g(localObject3, "MMApplicationContext.get…es().configuration.locale");
    localdnf.pLl = ((Locale)localObject3).getLanguage();
    ((fcl)???).Nyq = localdnf;
    ((fcl)???).Nyp.addAll((Collection)???);
    ((com.tencent.mm.plugin.appbrand.networking.c)e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a(nGy, (a)???, fcm.class).a((com.tencent.mm.vending.g.d.b)new a(paramString, (LinkedList)???)).a((com.tencent.mm.vending.g.d.a)new b(paramString, (LinkedList)???));
    AppMethodBeat.o(229300);
    return true;
  }
  
  public final void a(fcq arg1)
  {
    AppMethodBeat.i(229299);
    Log.i("Luggage.AppBrandIDKeyBatchReportNew", "writeIDKeyData type:" + ???.oUv);
    synchronized (nGB)
    {
      nGB.addLast(???);
      int i = nGB.size();
      if (i >= nGz)
      {
        aB("writeIDKeyData", true);
        AppMethodBeat.o(229299);
        return;
      }
    }
    synchronized (nGD)
    {
      if (nGC != null)
      {
        ??? = nGC;
        if ((??? == null) || (((MTimerHandler)???).stopped() != true)) {}
      }
      else
      {
        ??? = new MTimerHandler("Luggage.AppBrandIDKeyBatchReportNew", (MTimerHandler.CallBack)new c(), true);
        long l = nGA;
        ((MTimerHandler)???).startTimer(l, l);
        nGC = (MTimerHandler)???;
      }
      ??? = kotlin.x.SXb;
      AppMethodBeat.o(229299);
      return;
    }
  }
  
  public final void ce(String paramString, int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/WxaAppIDKeyBatchReportResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class a<T>
    implements com.tencent.mm.vending.g.d.b<fcm>
  {
    a(String paramString, LinkedList paramLinkedList) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements com.tencent.mm.vending.g.d.a<Object>
  {
    b(String paramString, LinkedList paramLinkedList) {}
    
    public final void cn(Object arg1)
    {
      AppMethodBeat.i(229297);
      Object localObject1 = new StringBuilder("reportNow, reason=").append(this.nGF).append(", reportList.size=").append(this.nGG.size()).append(", cgi error ");
      if (??? != null) {
        ??? = ???.toString();
      }
      for (;;)
      {
        Log.e("Luggage.AppBrandIDKeyBatchReportNew", ???);
        ??? = d.nGE;
        synchronized (d.bUq())
        {
          localObject1 = d.nGE;
          d.bUq().addAll((Collection)this.nGG);
          this.nGG.clear();
          AppMethodBeat.o(229297);
          return;
          ??? = null;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew$startTimer$1$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"})
  public static final class c
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(229298);
      d locald = d.nGE;
      boolean bool = d.aB("onTimerExpired", false);
      AppMethodBeat.o(229298);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */