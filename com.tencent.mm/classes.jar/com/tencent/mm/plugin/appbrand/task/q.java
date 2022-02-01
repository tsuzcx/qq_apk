package com.tencent.mm.plugin.appbrand.task;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.crash_report.b;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.plugin.appbrand.report.o.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandUILifeCycleSpeedProfile;", "", "()V", "TAG", "", "onAppBrandUILifeCycle", "", "ui", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUI;", "lifecycle", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q tWE;
  
  static
  {
    AppMethodBeat.i(51067);
    tWE = new q();
    AppMethodBeat.o(51067);
  }
  
  public static void b(AppBrandUI paramAppBrandUI, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(51066);
    s.u(paramAppBrandUI, "ui");
    s.u(paramString, "lifecycle");
    Object localObject3 = o.tOo;
    s.u(paramAppBrandUI, "activity");
    if ((paramAppBrandUI.isFinishing()) || (paramAppBrandUI.isDestroyed())) {
      o.a.a(paramAppBrandUI);
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((o)localObject1).afR(paramString);
      }
      int i;
      if (n.U(paramString, "onCreate", false))
      {
        localObject1 = b.rcV;
        s.u(paramAppBrandUI, "ui");
        if (paramAppBrandUI.ccf())
        {
          i = 29;
          label87:
          b.zJ(i);
        }
      }
      try
      {
        for (;;)
        {
          if (s.p("finish", paramString))
          {
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getLocalClassName() + " finish, stack:" + android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(51066);
            return;
            if (!paramAppBrandUI.ccf()) {
              break;
            }
            i = paramAppBrandUI.hashCode();
            localObject3 = (o)o.cIB().get(i, null);
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = new o(paramAppBrandUI);
            o.cIB().put(i, localObject1);
            break;
            i = 30;
            break label87;
            if (s.p(paramString, "onDestroy"))
            {
              localObject1 = b.rcV;
              s.u(paramAppBrandUI, "ui");
              if (paramAppBrandUI.ccf()) {}
              for (i = 26;; i = 27)
              {
                b.zJ(i);
                break;
              }
            }
          }
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getLocalClassName() + ' ' + paramString);
        AppMethodBeat.o(51066);
        return;
      }
      finally
      {
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUILifeCycleSpeedProfile", "onAppBrandLifeCycle " + paramAppBrandUI.hashCode() + ' ' + paramAppBrandUI.getClass().getSimpleName() + ' ' + paramString);
        AppMethodBeat.o(51066);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.q
 * JD-Core Version:    0.7.0.1
 */