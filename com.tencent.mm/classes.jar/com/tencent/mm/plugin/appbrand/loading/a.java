package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ay;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "", "ctx", "Landroid/content/Context;", "startAppBrandIntent", "Landroid/content/Intent;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "getConnect", "()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "connect$delegate", "Lkotlin/Lazy;", "pendingIntentKey", "", "forceDisable", "", "getUiFlavor", "needPreLoadingUi", "onNeedPreLoadingUI", "", "setupOpenAnim", "Landroid/app/Activity;", "startAppBrandProgress", "targetServiceClassName", "", "startPreLoadingActivity", "targetActivityName", "xLabIsOpen", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static ServiceConnection lSp;
  public static final a lSq;
  public final Context ctx;
  public final AppBrandInitConfigWC jGE;
  public final AppBrandStatObject jGF;
  public int lSl;
  private final f lSm;
  public final Intent lSn;
  public final i lSo;
  
  static
  {
    AppMethodBeat.i(50818);
    lSq = new a((byte)0);
    AppMethodBeat.o(50818);
  }
  
  public a(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, i parami, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50817);
    this.ctx = paramContext;
    this.lSn = paramIntent;
    this.jGE = paramAppBrandInitConfigWC;
    this.lSo = parami;
    this.jGF = paramAppBrandStatObject;
    this.lSl = -1;
    this.lSm = d.g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(50817);
  }
  
  public final b bsN()
  {
    AppMethodBeat.i(175200);
    b localb = (b)this.lSm.getValue();
    AppMethodBeat.o(175200);
    return localb;
  }
  
  public final int bsO()
  {
    if ((this.lSo instanceof com.tencent.mm.plugin.appbrand.task.b)) {
      return 4;
    }
    return 5;
  }
  
  public final boolean bsP()
  {
    AppMethodBeat.i(50816);
    if ((this.lSo.bzF() == e.mDe) && (!this.jGE.kaQ))
    {
      Object localObject = this.lSo.bzG();
      p.g(localObject, "task.processTriggerServiceClass");
      localObject = (CharSequence)((Class)localObject).getCanonicalName();
      label102:
      label125:
      boolean bool;
      if ((localObject == null) || (n.aD((CharSequence)localObject)))
      {
        i = 1;
        if ((i != 0) || (com.tencent.mm.plugin.appbrand.aa.g.VY(this.jGE.appId)) || (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(this.jGE, this.jGF))) {
          break label191;
        }
        if (com.tencent.mm.protocal.d.FFI) {
          break label171;
        }
        i = 1;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qKZ, i) != 1) {
          break label176;
        }
        i = 1;
        if (i == 0) {
          break label191;
        }
        localObject = com.tencent.mm.plugin.appbrand.app.d.jGw;
        localObject = com.tencent.mm.plugin.appbrand.app.d.LD();
        if (localObject == null) {
          break label181;
        }
        bool = ((ay)localObject).getBoolean("enable_pre_loading", true);
        label149:
        if (bool) {
          break label186;
        }
      }
      label171:
      label176:
      label181:
      label186:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label191;
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
        break label149;
      }
    }
    label191:
    AppMethodBeat.o(50816);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic$Companion;", "", "()V", "INTENT_KEY_APP_ID", "", "INTENT_KEY_ATTR_VERSION_INFO", "INTENT_KEY_ICON", "INTENT_KEY_NAME", "INTENT_KEY_PENDING_INTENT", "INTENT_KEY_SCENE", "INTENT_KEY_SERVICE_NAME", "INTENT_KEY_SPLASH_FLAVOR", "INTENT_KEY_TARGET_ACTIVITY_NAME", "IPC_PRE_LOAD_SUCCESS", "", "IPC_TRIGGER_PROGRESS", "IPC_TRIGGER_PROGRESS_FAIL", "IPC_TRIGGER_PROGRESS_SUCCESS", "NORMAL", "PLUGIN", "TAG", "connectionRefForUnbind", "Landroid/content/ServiceConnection;", "getConnectionRefForUnbind", "()Landroid/content/ServiceConnection;", "setConnectionRefForUnbind", "(Landroid/content/ServiceConnection;)V", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(a parama, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.a
 * JD-Core Version:    0.7.0.1
 */