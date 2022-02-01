package com.tencent.mm.plugin.appbrand.report;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.gkj;
import com.tencent.mm.protocal.protobuf.gkk;
import com.tencent.mm.protocal.protobuf.gkq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew;", "Lcom/tencent/mm/plugin/appbrand/report/WxaCgiIDKeyBatchReportProtocol;", "()V", "BATCH_RECORD_COUNT_MAX", "", "BATCH_REPORT_INTERVAL_MS", "", "CGI_URL", "", "TAG", "batchReportBufferQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxaAppRecord;", "batchReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerGuard", "", "reportNow", "", "reason", "stopTimer", "startTimer", "", "appId", "runtimeEnterScene", "writeIDKeyData", "data", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements z
{
  public static final d tNo;
  private static final String tNp;
  private static final int tNq;
  private static final long tNr;
  private static final LinkedList<gkq> tNs;
  private static MTimerHandler tNt;
  private static final Object tNu;
  
  static
  {
    AppMethodBeat.i(321406);
    tNo = new d();
    tNp = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
    tNq = 50;
    tNr = TimeUnit.SECONDS.toMillis(30L);
    tNs = new LinkedList();
    tNu = new Object();
    AppMethodBeat.o(321406);
  }
  
  private static final void a(String paramString, LinkedList paramLinkedList, gkk paramgkk)
  {
    AppMethodBeat.i(321399);
    s.u(paramString, "$reason");
    s.u(paramLinkedList, "$reportList");
    Log.i("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + paramString + ", reportList.size=" + paramLinkedList.size() + ", cgi back ok");
    paramLinkedList.clear();
    AppMethodBeat.o(321399);
  }
  
  private static final void a(String arg0, LinkedList paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(321403);
    s.u(???, "$reason");
    s.u(paramLinkedList, "$reportList");
    StringBuilder localStringBuilder = new StringBuilder("reportNow, reason=").append(???).append(", reportList.size=").append(paramLinkedList.size()).append(", cgi error ");
    if (paramObject == null) {
      ??? = null;
    }
    for (;;)
    {
      Log.e("Luggage.AppBrandIDKeyBatchReportNew", ???);
      synchronized (tNs)
      {
        tNs.addAll((Collection)paramLinkedList);
        paramLinkedList.clear();
        AppMethodBeat.o(321403);
        return;
        ??? = paramObject.toString();
      }
    }
  }
  
  public static boolean aP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(321395);
    s.u(paramString, "reason");
    if (paramBoolean) {
      synchronized (tNu)
      {
        ??? = tNt;
        if (??? != null) {
          ((MTimerHandler)???).stopTimer();
        }
        tNt = null;
        ??? = ah.aiuX;
      }
    }
    for (;;)
    {
      synchronized (tNs)
      {
        ??? = new LinkedList((Collection)tNs);
        tNs.clear();
        Log.i("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + paramString + ", reportList.size=" + ((LinkedList)???).size());
        if (((Collection)???).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(321395);
          return false;
          paramString = finally;
          AppMethodBeat.o(321395);
          throw paramString;
        }
      }
      int i = 0;
    }
    ??? = new gkj();
    eqb localeqb = new eqb();
    localeqb.vhx = Build.MANUFACTURER;
    localeqb.abtZ = 2;
    localeqb.mut = com.tencent.mm.protocal.d.Yxb;
    localeqb.muu = com.tencent.mm.protocal.d.Yxa;
    localeqb.PJy = MMApplicationContext.getResources().getDisplayMetrics().widthPixels;
    localeqb.abua = MMApplicationContext.getResources().getDisplayMetrics().heightPixels;
    localeqb.muv = com.tencent.mm.protocal.d.Yxd;
    localeqb.muw = com.tencent.mm.protocal.d.Yxe;
    localeqb.vYj = MMApplicationContext.getResources().getConfiguration().locale.getLanguage();
    ((gkj)???).acgn = localeqb;
    ((gkj)???).acgm.addAll((Collection)???);
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a(tNp, (a)???, gkk.class).a(new d..ExternalSyntheticLambda1(paramString, (LinkedList)???)).a(new d..ExternalSyntheticLambda0(paramString, (LinkedList)???));
    AppMethodBeat.o(321395);
    return true;
  }
  
  public final void a(gkq arg1)
  {
    int i = 1;
    AppMethodBeat.i(321422);
    Log.i("Luggage.AppBrandIDKeyBatchReportNew", s.X("writeIDKeyData type:", Integer.valueOf(???.vhJ)));
    synchronized (tNs)
    {
      tNs.addLast(???);
      int j = tNs.size();
      if (j >= tNq)
      {
        aP("writeIDKeyData", true);
        AppMethodBeat.o(321422);
        return;
      }
    }
    for (;;)
    {
      synchronized (tNu)
      {
        if (tNt != null)
        {
          ??? = tNt;
          if ((??? != null) && (((MTimerHandler)???).stopped() == true)) {
            break label192;
          }
        }
        else
        {
          ??? = new MTimerHandler("Luggage.AppBrandIDKeyBatchReportNew", (MTimerHandler.CallBack)new a(), true);
          long l = tNr;
          ((MTimerHandler)???).startTimer(l, l);
          tNt = (MTimerHandler)???;
          ??? = ah.aiuX;
          AppMethodBeat.o(321422);
          return;
        }
        i = 0;
      }
      label192:
      if (i == 0) {}
    }
  }
  
  public final void dd(String paramString, int paramInt) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew$startTimer$1$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(321351);
      d locald = d.tNo;
      boolean bool = d.aP("onTimerExpired", false);
      AppMethodBeat.o(321351);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */