package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "", "ctx", "Landroid/content/Context;", "startAppBrandIntent", "Landroid/content/Intent;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "getConnect", "()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "connect$delegate", "Lkotlin/Lazy;", "pendingIntentKey", "", "forceDisable", "", "getUiFlavor", "needPreLoadingUi", "onNeedPreLoadingUI", "", "setupOpenAnim", "Landroid/app/Activity;", "startAppBrandProgress", "targetServiceClassName", "", "startPreLoadingActivity", "targetActivityName", "xLabIsOpen", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static ServiceConnection qae;
  public static final a.a qaf;
  public final Context ctx;
  public final AppBrandInitConfigWC nCs;
  public final AppBrandStatObject nyh;
  public int qaa;
  private final kotlin.f qab;
  public final Intent qac;
  public final d qad;
  
  static
  {
    AppMethodBeat.i(50818);
    qaf = new a.a((byte)0);
    AppMethodBeat.o(50818);
  }
  
  public a(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, d paramd, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(271980);
    this.ctx = paramContext;
    this.qac = paramIntent;
    this.nCs = paramAppBrandInitConfigWC;
    this.qad = paramd;
    this.nyh = paramAppBrandStatObject;
    this.qaa = -1;
    this.qab = kotlin.g.ar((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(271980);
  }
  
  public final b caI()
  {
    AppMethodBeat.i(175200);
    b localb = (b)this.qab.getValue();
    AppMethodBeat.o(175200);
    return localb;
  }
  
  public final boolean caJ()
  {
    AppMethodBeat.i(50816);
    if ((!this.nCs.Qv()) && (!this.nCs.nYb) && (!this.nCs.nYi))
    {
      Object localObject = (CharSequence)this.qad.qRf.getCanonicalName();
      boolean bool;
      if ((localObject == null) || (n.ba((CharSequence)localObject)))
      {
        i = 1;
        if ((i != 0) || (com.tencent.mm.plugin.appbrand.ag.g.anz(this.nCs.appId)) || (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(this.nCs, this.nyh))) {
          break label157;
        }
        localObject = com.tencent.mm.plugin.appbrand.app.f.nCi.aal();
        if (localObject == null) {
          break label147;
        }
        bool = ((MultiProcessMMKV)localObject).getBoolean("enable_pre_loading", true);
        label112:
        if (bool) {
          break label152;
        }
      }
      label147:
      label152:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (this.nCs.nBE.isEnable())) {
          break label157;
        }
        AppMethodBeat.o(50816);
        return true;
        i = 0;
        break;
        bool = true;
        break label112;
      }
    }
    label157:
    AppMethodBeat.o(50816);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(a parama, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.a
 * JD-Core Version:    0.7.0.1
 */