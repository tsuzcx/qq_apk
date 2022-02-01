package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.pj;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandUIStandaloneTaskVisitReporter;", "", "activity", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;)V", "reportPVKeyOnResumed", "", "reportKey", "", "key", "reportLifecycle", "lifecycle", "", "reportWeAppLoadKV", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "reportWeAppSwitchFromSystemTaskBarKV", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final SparseArray<o> sLp;
  public static final a tOo;
  private final AppBrandUI tOp;
  private int tOq;
  
  static
  {
    AppMethodBeat.i(321527);
    tOo = new a((byte)0);
    sLp = new SparseArray();
    AppMethodBeat.o(321527);
  }
  
  public o(AppBrandUI paramAppBrandUI)
  {
    AppMethodBeat.i(321507);
    this.tOp = paramAppBrandUI;
    AppMethodBeat.o(321507);
  }
  
  private static void AQ(int paramInt)
  {
    AppMethodBeat.i(321510);
    com.tencent.threadpool.h.ahAA.j(new o..ExternalSyntheticLambda0(paramInt), "AppBrandUIStandaloneTaskVisitReporter");
    AppMethodBeat.o(321510);
  }
  
  private static final void Db(int paramInt)
  {
    AppMethodBeat.i(321515);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1758, paramInt + 100);
    AppMethodBeat.o(321515);
  }
  
  private static void h(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(321513);
    pj localpj = new pj();
    localpj.ioV = 1L;
    localpj.aIW();
    localpj.wL(paramAppBrandInitConfigWC.appId);
    localpj.wM(paramAppBrandInitConfigWC.eoP);
    localpj.bMH();
    AppMethodBeat.o(321513);
  }
  
  public final void afR(String paramString)
  {
    AppMethodBeat.i(321535);
    s.u(paramString, "lifecycle");
    if (n.U(paramString, "onCreate", false))
    {
      this.tOq = 3;
      paramString = this.tOp.getInitConfig();
      if (paramString != null)
      {
        h(paramString);
        AppMethodBeat.o(321535);
      }
    }
    else
    {
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(321535);
      return;
      if (!paramString.equals("onDestroy"))
      {
        AppMethodBeat.o(321535);
        return;
        if (!paramString.equals("onNewIntent"))
        {
          AppMethodBeat.o(321535);
          return;
          if (!paramString.equals("onPause"))
          {
            AppMethodBeat.o(321535);
            return;
            if (!paramString.equals("onResume")) {
              AppMethodBeat.o(321535);
            }
          }
          else
          {
            this.tOq = 0;
            af.c((Context)this.tOp, (b)new o.b(this));
            AppMethodBeat.o(321535);
            return;
          }
          AQ(1);
          if (this.tOq > 0) {}
          for (int i = this.tOq;; i = 2)
          {
            AQ(i);
            if (2 != i) {
              break;
            }
            paramString = this.tOp.getInitConfig();
            if (paramString == null) {
              break;
            }
            pj localpj = new pj();
            localpj.ioV = 2L;
            localpj.aIW();
            localpj.wL(paramString.appId);
            localpj.wM(paramString.eoP);
            localpj.bMH();
            AppMethodBeat.o(321535);
            return;
          }
        }
        this.tOq = 4;
        paramString = this.tOp.getInitConfig();
        if (paramString != null)
        {
          h(paramString);
          AppMethodBeat.o(321535);
        }
      }
      else
      {
        a.a(this.tOp);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandUIStandaloneTaskVisitReporter$Companion;", "", "()V", "ID", "", "KEY_PV_RESUME_AFTER_CREATE", "KEY_PV_RESUME_AFTER_NEW_INTENT", "KEY_PV_RESUME_AFTER_SCREEN_ON", "KEY_PV_RESUME_TOTAL", "KEY_PV_UNKNOWN_RESUME", "KEY_UV_RESUME_AFTER_CREATE", "KEY_UV_RESUME_AFTER_NEW_INTENT", "KEY_UV_RESUME_AFTER_SCREEN_ON", "KEY_UV_RESUME_TOTAL", "KEY_UV_UNKNOWN_RESUME", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandUIStandaloneTaskVisitReporter;", "obtain", "activity", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "releaseRef", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(AppBrandUI paramAppBrandUI)
    {
      AppMethodBeat.i(321357);
      o.cIB().remove(paramAppBrandUI.hashCode());
      AppMethodBeat.o(321357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o
 * JD-Core Version:    0.7.0.1
 */