package com.tencent.mm.plugin.appbrand.report.model;

import android.net.Uri;
import android.os.Parcelable;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.c.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/model/AppBrandUIInvalidIntentTraceReport;", "", "()V", "ID", "", "KEY_BASE_LOAD_TOTAL", "KEY_BASE_TIMESTAMP_EXCEED_24_HOURS", "KEY_BASE_TIMESTAMP_IN_10_MINUTES_TO_30_MINUTES", "KEY_BASE_TIMESTAMP_IN_12_HOURS_TO_24_HOURS", "KEY_BASE_TIMESTAMP_IN_1_HOUR_TO_2_HOURS", "KEY_BASE_TIMESTAMP_IN_1_MINUTE_TO_2_MINUTES", "KEY_BASE_TIMESTAMP_IN_2_HOURS_TO_6_HOURS", "KEY_BASE_TIMESTAMP_IN_2_MINUTES_TO_5_MINUTES", "KEY_BASE_TIMESTAMP_IN_30_MINUTES_TO_1_HOUR", "KEY_BASE_TIMESTAMP_IN_30_SECONDS_TO_1_MINUTE", "KEY_BASE_TIMESTAMP_IN_5_MINUTES_TO_10_MINUTES", "KEY_BASE_TIMESTAMP_IN_6_HOURS_TO_12_HOURS", "KEY_PADDING_FOR_NEW_INTENT", "KEY_PADDING_FOR_SCAN_CODE", "TAG", "", "reportOnRuntimeLoad", "", "activity", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "scene", "showAlertForScanCodeTimestampExpired", "ReportWorker", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f tPq;
  
  static
  {
    AppMethodBeat.i(321495);
    tPq = new f();
    AppMethodBeat.o(321495);
  }
  
  private static final void I(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(321488);
    Log.i("MicroMsg.AppBrandUIInvalidIntentTraceReport", "showAlertForScanCodeTimestampExpired positiveClick");
    AppMethodBeat.o(321488);
  }
  
  public static final void a(AppBrandUI paramAppBrandUI, AppBrandInitConfigWC paramAppBrandInitConfigWC, String paramString)
  {
    AppMethodBeat.i(321486);
    s.u(paramAppBrandUI, "activity");
    s.u(paramAppBrandInitConfigWC, "config");
    s.u(paramString, "scene");
    if (s.p("onNewIntent", paramString)) {}
    for (int i = 100;; i = 0)
    {
      paramAppBrandUI = paramAppBrandInitConfigWC.appId;
      s.s(paramAppBrandUI, "config.appId");
      paramAppBrandUI = new f.a(paramAppBrandUI, paramAppBrandInitConfigWC.eul);
      paramAppBrandUI.padding = i;
      paramAppBrandUI.cIO();
      paramAppBrandUI.jS(Util.nowMilliSecond() - paramAppBrandInitConfigWC.startTime);
      paramAppBrandUI.flush();
      paramAppBrandUI = g.tdE;
      s.s(paramAppBrandUI, "BARCODE_SCENES");
      if (!k.contains(paramAppBrandUI, paramAppBrandInitConfigWC.epn.scene))
      {
        paramAppBrandUI = g.tdF;
        s.s(paramAppBrandUI, "QRCODE_SCENES");
        if (!k.contains(paramAppBrandUI, paramAppBrandInitConfigWC.epn.scene)) {
          break;
        }
      }
      else
      {
        try
        {
          paramAppBrandUI = Uri.parse(paramAppBrandInitConfigWC.qAF).getQueryParameter("scancode_time");
          s.checkNotNull(paramAppBrandUI);
          s.s(paramAppBrandUI, "parse(config.enterPath).…ameter(\"scancode_time\")!!");
          long l1 = Long.parseLong(paramAppBrandUI);
          l1 *= 1000L;
          long l2 = cn.bDx();
          if ((l1 <= 0L) || (l2 <= 0L)) {
            break;
          }
          Log.i("MicroMsg.AppBrandUIInvalidIntentTraceReport", "reportOnRuntimeLoad, appId:" + paramAppBrandInitConfigWC.appId + ", appScene:" + paramAppBrandInitConfigWC.epn.scene + ", uiScene:" + paramString + ", scanCodeTime:" + l1 + ", serverSyncTime:" + l2);
          paramAppBrandUI = paramAppBrandInitConfigWC.appId;
          s.s(paramAppBrandUI, "config.appId");
          paramAppBrandUI = new f.a(paramAppBrandUI, paramAppBrandInitConfigWC.eul);
          paramAppBrandUI.padding = (i + 20);
          paramAppBrandUI.cIO();
          paramAppBrandUI.jS(l2 - l1);
          paramAppBrandUI.flush();
          long l3 = ((c)h.ax(c.class)).a(c.a.yPu, 3600000L);
          if ((l3 <= 0L) || (l2 - l1 <= l3)) {
            break;
          }
          paramAppBrandUI = new a();
          AppMethodBeat.o(321486);
          throw paramAppBrandUI;
        }
        catch (Exception paramAppBrandUI)
        {
          AppMethodBeat.o(321486);
          return;
        }
      }
    }
    AppMethodBeat.o(321486);
  }
  
  public static final void cIN()
  {
    AppMethodBeat.i(321479);
    String str = MMApplicationContext.getMainProcessName();
    s.s(str, "getMainProcessName()");
    com.tencent.mm.ipcinvoker.a.a(str, (Parcelable)IPCVoid.mzv, (d)f..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(321479);
  }
  
  private static final void d(IPCVoid paramIPCVoid, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(321492);
    paramIPCVoid = new g.a(MMApplicationContext.getContext());
    paramIPCVoid.bDE(MMApplicationContext.getString(ba.i.appbrand_open_weapp_failed_by_scancode_time_exipred_span_check));
    paramIPCVoid.b(f..ExternalSyntheticLambda1.INSTANCE);
    paramIPCVoid.show();
    AppMethodBeat.o(321492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.f
 * JD-Core Version:    0.7.0.1
 */