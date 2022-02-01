package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "", "ctx", "Landroid/content/Context;", "startAppBrandIntent", "Landroid/content/Intent;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "getConnect", "()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "connect$delegate", "Lkotlin/Lazy;", "pendingIntentKey", "", "forceDisable", "", "getUiFlavor", "needPreLoadingUi", "onNeedPreLoadingUI", "", "setupOpenAnim", "Landroid/app/Activity;", "startAppBrandProgress", "targetServiceClassName", "", "startPreLoadingActivity", "targetActivityName", "xLabIsOpen", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static ServiceConnection kOR;
  public static final a kOS;
  public final Context ctx;
  public final AppBrandInitConfigWC iJK;
  public final AppBrandStatObject iJL;
  public int kON;
  private final d.f kOO;
  public final Intent kOP;
  public final i kOQ;
  
  static
  {
    AppMethodBeat.i(50818);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "connect", "getConnect()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;")) };
    kOS = new a((byte)0);
    AppMethodBeat.o(50818);
  }
  
  public a(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, i parami, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50817);
    this.ctx = paramContext;
    this.kOP = paramIntent;
    this.iJK = paramAppBrandInitConfigWC;
    this.kOQ = parami;
    this.iJL = paramAppBrandStatObject;
    this.kON = -1;
    this.kOO = d.g.E((d.g.a.a)new b(this));
    AppMethodBeat.o(50817);
  }
  
  public final b bhp()
  {
    AppMethodBeat.i(175200);
    b localb = (b)this.kOO.getValue();
    AppMethodBeat.o(175200);
    return localb;
  }
  
  public final int bhq()
  {
    if ((this.kOQ instanceof com.tencent.mm.plugin.appbrand.task.b)) {
      return 4;
    }
    return 5;
  }
  
  public final boolean bhr()
  {
    AppMethodBeat.i(50816);
    if ((this.kOQ.bnK() == e.lwx) && (!this.iJK.jds))
    {
      Object localObject = this.kOQ.bnL();
      d.g.b.k.g(localObject, "task.processTriggerServiceClass");
      localObject = (CharSequence)((Class)localObject).getCanonicalName();
      label102:
      label125:
      boolean bool;
      if ((localObject == null) || (n.aC((CharSequence)localObject)))
      {
        i = 1;
        if ((i != 0) || (com.tencent.mm.plugin.appbrand.ac.g.Nz(this.iJK.appId)) || (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.d(this.iJK, this.iJL))) {
          break label192;
        }
        if (com.tencent.mm.protocal.d.CpL) {
          break label172;
        }
        i = 1;
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pud, i) != 1) {
          break label177;
        }
        i = 1;
        if (i == 0) {
          break label192;
        }
        localObject = com.tencent.mm.plugin.appbrand.app.d.iJD;
        localObject = com.tencent.mm.plugin.appbrand.app.d.Km();
        if (localObject == null) {
          break label182;
        }
        bool = ((ax)localObject).getBoolean("enable_pre_loading", true);
        label150:
        if (bool) {
          break label187;
        }
      }
      label172:
      label177:
      label182:
      label187:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label192;
        }
        AppMethodBeat.o(50816);
        return true;
        i = 0;
        break;
        i = 0;
        break label102;
        i = 0;
        break label125;
        bool = true;
        break label150;
      }
    }
    label192:
    AppMethodBeat.o(50816);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic$Companion;", "", "()V", "INTENT_KEY_APP_ID", "", "INTENT_KEY_ATTR_VERSION_INFO", "INTENT_KEY_ICON", "INTENT_KEY_NAME", "INTENT_KEY_PENDING_INTENT", "INTENT_KEY_SCENE", "INTENT_KEY_SERVICE_NAME", "INTENT_KEY_SPLASH_FLAVOR", "INTENT_KEY_TARGET_ACTIVITY_NAME", "IPC_PRE_LOAD_SUCCESS", "", "IPC_TRIGGER_PROGRESS", "IPC_TRIGGER_PROGRESS_FAIL", "IPC_TRIGGER_PROGRESS_SUCCESS", "NORMAL", "PLUGIN", "TAG", "connectionRefForUnbind", "Landroid/content/ServiceConnection;", "getConnectionRefForUnbind", "()Landroid/content/ServiceConnection;", "setConnectionRefForUnbind", "(Landroid/content/ServiceConnection;)V", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(a parama, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.a
 * JD-Core Version:    0.7.0.1
 */